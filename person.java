import java.util.Comparator;
class PersonHeightComparator implements Comparator<Person>{
    @Override
    public int compare(Person o1, Person o2) {
        return (int)(o1.height-o2.height);
    }
}
class PersonNameComparator implements Comparator<Person>{

    @Override
    //把Person1的name取出来，并用Person1的自然顺序为比较顺序
    public int compare(Person o1, Person o2) {
        return o1.name.compareTo(o2.name);
    }
}
public class Person implements Comparable<Person>{
    public String name;
    public int age;
    public double height;
    public int weight;
    public int level;
    public int gender;

    public Person(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    @Override
    public int compareTo(Person o) {
        return age-o.age;
        /*
        if(age<o.age){
            return -1;
        }else if(age==o.age){
            return 0;
        }else if(age>o.age){
            return 1;
        }
        */
    }
    
//设计一个复杂比较器，比较顺序依次为身高、体重、姓名、年龄
    class ComplexComparator implements Comparator<Person>{
        @Override
        public int compare(Person o1, Person o2) {
            if(o1.height<o2.height){
                return -1;
            }else if(o1.height>o2.height){
                return 1;
            }
            if(o1.weight<o2.weight){
                return -1;
            }else if(o1.weight>o2.weight){
                return 1;
            }
            int n=o1.name.compareTo(o2.name);
            if(n!=0){
                return n;
            }
            return o1.age-o2.age;
        }
    }
    
    public static void main(String[] args) {
        Person p=new Person("James",18,185.0);
        Person q=new Person("Tom",20,180.2);
        //按照年龄比较
        System.out.println("按照年龄比较：");
        int a=p.compareTo(q);
        if(a<0){
            System.out.println("p小于q");
        }else if(a==0){
            System.out.println("p等于q");
        }else{
            System.out.println("p大于q");
        }

        Comparator<Person> comparator=new PersonNameComparator();
        //按照姓名比较
        System.out.println("按照姓名比较：");
        int n=comparator.compare(p,q);
        if(n<0){
            System.out.println("p小于q");
        }else if(n==0){
            System.out.println("p等于q");
        }else{
            System.out.println("p大于q");
        }

        comparator=new PersonHeightComparator();
        //基于身高的比较
        System.out.println("按照身高比较：");
        int h=comparator.compare(p,q);
        if(h<0){
            System.out.println("p小于q");
        }else if(h==0){
            System.out.println("p等于q");
        }else{
            System.out.println("p大于q");
        }

        //额外的验证用例：String和Integer已经实现过Comparable
        System.out.println("额外的验证用例：体现String已经实现过Comparable：");
        System.out.println("abc".compareTo("bbc"));
        System.out.println("abc".compareTo("abcd"));
    }
}
