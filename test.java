import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

class Person {
	private String name;
	private Integer age;

	public Person(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public String toString() {
		return "Person{" + "name='" + name + '\'' + ",age=" + age + '}';
	}

	public String getName() {
		return name;
	}

	public void setName() {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge() {
		this.age = age;
	}
}

class AscAgeComparator implements Comparator<Person> {
	public int compare(Person o1, Person o2) {
		return o1.getAge() - o2.getAge();
	}
}

class DescAgeComparator implements Comparator<Person> {
	public int compare(Person o1, Person o2) {
		return o2.getAge() - o1.getAge();
	}
}

public class TestDemo {
	public static void main(String[] args) {
		Set<Person> set = new TreeSet<>(new AscAgeComparator());
		set.add(new Person("张三", 20));
		set.add(new Person("李四", 18));
		System.out.println(set);
		Set<Person> set2 = new TreeSet<>(new DescAgeComparator());
		set2.add(new Person("张三", 20));
		set2.add(new Person("李四", 18));
		System.out.println(set2);
	}
}
