import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Book implements Comparable<Book>{
    String ISBN;
    String title;
    String author;
    int price;
    int sales;
    int comments;

    public Book(String ISBN, String title, String author, int price, int sales, int comments) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.price = price;
        this.sales = sales;
        this.comments = comments;
    }

    @Override
    public int compareTo(Book o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Book{" +
                "ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", sales=" + sales +
                ", comments=" + comments +
                '}';
    }
    
    static class Sort {
        public static void sort(List<Book> books) {
            for (int i = 1; i < books.size(); i++) {
                Book book = books.get(i);
                int j = i - 1;
                for (; j >= 0 && books.get(j).compareTo(book) > 0; j--) {
                    books.set(j + 1, books.get(j));
                }
                books.set(j + 1, book);
            }
        }
        public static void sort(List<Book> books, Comparator<Book> comparator) {
            for (int i = 1; i < books.size(); i++) {
                Book book = books.get(i);
                int j = i - 1;
                for (; j >= 0 && comparator.compare(books.get(j), book) > 0; j--){
                    books.set(j + 1, books.get(j));
                }
                books.set(j + 1, book);
            }
        }
    }

    static class TitleComparator implements Comparator<Book> {
        @Override
        public int compare(Book o1, Book o2) {
            return o1.title.compareTo(o2.title);
        }
    }

    static class PriceComparator implements Comparator<Book>{
        /**
         * true代表从小到大，false代表从大到小
         */
        boolean asc;

        public PriceComparator(boolean asc) {
            this.asc = asc;
        }


        @Override
        public int compare(Book o1, Book o2) {
            if(asc){
                return o1.price-o2.price;
            }else{
                return o2.price-o1.price;
            }
        }
    }
        public static void main(String[] args) {
            List<Book> books = new ArrayList<>();
            books.add(new Book("9787201151304", "从一到无穷大", "[美] 乔治·伽莫夫", 1600, 400, 26));
            books.add(new Book("9787020147465", "应物兄", "李洱", 7900, 1668, 300));
            books.add(new Book("9787220107085", "如何写甲骨文", "日本文字文化机构", 8800, 23, 6));
            books.add(new Book("9787521706635", "敌人与邻居", "[英]伊恩·布莱克", 10800, 3, 0));
            books.add(new Book("9787301280751", "法国大革命 (第2版)", "布兰宁(T.C.W.Blanning)", 4500, 1993, 188));

            List<Book> copy;

            // 按自然顺序（ISBN）排序
            System.out.println("按 ISBN 排序：");
            copy = new ArrayList<>(books);
            Sort.sort(copy);
            System.out.println(copy);

            // 按书名排序
            System.out.println("按 书名 排序：");
            copy = new ArrayList<>(books);
            Sort.sort(copy, new TitleComparator());
            System.out.println(copy);

            // 按价格排序-从小到大
            System.out.println("按 价格-从小到大 排序：");
            copy = new ArrayList<>(books);
            Sort.sort(copy, new PriceComparator(true));
            System.out.println(copy);

            // 按价格排序-从大到小
            System.out.println("按 价格-从大到小 排序：");
            copy = new ArrayList<>(books);
            Sort.sort(copy, new PriceComparator(false));
            System.out.println(copy);
        }
}
