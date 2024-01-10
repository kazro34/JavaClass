package oe.lesson2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class MainClass {
	public static void main(String[] args) {
		ArrayList<person> aList = new ArrayList();
		person joe = new person("Joe",26);
		person jane = new person("Jane",20);
		person tom = new person("Tom",42);
		person mary = new person("Mary",6);
		
		System.out.println("- Stream basics");
		aList.stream().forEach(System.out::println);
		//same as
		//aList.stream().forEach(p->System.out.println(p));
		
		/*Convert stream back to List: collect(Collectors.toList()) {
			System.out.println(p);
		}*/
		
		System.out.println("- Stream ordering");
		aList.stream().sorted(Comparator.comparing(person::getAge).reversed()).forEach(System.out::println);
		
		
		System.out.println("- Stream filtering");
		aList.stream().filter(p->p.getAge()>40).forEach(System.out::println);
		
		System.out.println("- Stream mapping");
		aList.stream().map(p->p.getName()).forEach(System.out::println);
		
		System.out.println("- Names of people younger than 50, order by name. collect names into a single string");
		String names = aList.stream()
				.filter(p->p.getAge()<50)
				.map(p->p.getName())
				.sorted()
				.collect(Collectors.joining(", "));
		System.out.println(names);
		
		System.out.println("- Aggregation");
		//Number of people whose names starts with "J":
		System.out.println(aList.stream().filter(p->p.getName().startsWith("J")).count());
		System.out.println(aList.stream().min(Comparator.comparing(person::getAge)).get());
		System.out.println(aList.stream().collect(Collectors.averagingInt(person::getAge)));
		System.out.println(aList.stream().collect(Collectors.summingInt(person::getAge)));
		
		System.out.println("- Groupping");
		var grouping=aList.stream().collect(Collectors.groupingBy(p->p.getAge()/10));
		for (Map.Entry<Integer, List<person>> entry : grouping.entrySet()) {
			System.out.printf("%d0-s: %s%n", entry.getKey(),
					entry.getValue().stream().map(p->p.getName()).collect(Collectors.joining(",")));
		}
		
		System.out.println("- ArrayList");
		ArrayList<person> AList= new ArrayList();
		AList.add(joe);
		AList.add(jane);
		AList.add(tom);
		AList.add(jane);
		AList.add(1, mary);
		for (person Person:AList) {
			System.out.println(Person.getName());
		}
		System.out.println("--- Arrays.asList: fixed-sized list");
		List<person> test=Arrays.asList(joe, jane, tom, mary);
		System.out.println(test.getClass());
		System.out.println(AList.getClass());
		try {
			test.add(new person("Eddie",50));
		} catch (Exception e){
			System.out.println("Cannot add element to fixed-sozed list.");
		}
		System.out.println("- PriorityQueuet");
		PriorityQueue<person> queue=new PriorityQueue();
		queue.add(jane);
		queue.add(joe);
		queue.add(tom);
		queue.add(jane);
		queue.add(mary);
		System.out.println("---Peek: read element");
		System.out.println(queue.peek().getName());
		System.out.println("---change head element priority");
		queue.peek().setAge(70);
		System.out.println(queue.peek().getName()); //Did not reorder
		queue.add(queue.poll()); //Remove and reorder
		System.out.println(queue.peek().getName());
		
		System.out.println("---Poll: read and remove head element");
		person p;
		while ((p=queue.poll())!=null) {
			System.out.printf("%a (%d)%n", p.getName(),p.getAge());
		}
		System.out.println("Queue size: "+ queue.size());
		
		System.out.println("- LinkedList");
		LinkedList<person> lList = new LinkedList();
		lList.add(joe);
		lList.add(joe);
		lList.add(jane);
		lList.add(tom);
		lList.add(1, mary);
		for (person Person : lList) {
			System.out.println(Person.getName());
		}
		System.out.println("---LinkedList as Queue:");
		System.out.println("Peek: "+lList.peek().getName());
		while ((p=lList.poll())!=null) {
			System.out.printf("%a (%d)%n", p.getName(),p.getAge());
		}
		System.out.println("- TreeSett");
		TreeSet<person> tSet = new TreeSet();
			tSet.add(joe);
			tSet.add(jane);
			tSet.add(jane);
			tSet.add(tom);
			tSet.add(mary);
			for (person Person: tSet) {
				System.out.println(Person.getName());
		}
			
		person newperson= new person("Adam",40);
		System.out.println("---All the people younger than Adam:");
		for (person Person: tSet.headSet(newperson)) {
			System.out.println(Person.getName());
		}
		System.out.println("---Youngest person older than Adam:");
		System.out.println(tSet.higher(newperson).getName()); 
		
		System.out.println("- HashMap");
		HashMap<Integer, person> hMap= new HashMap();
		hMap.put(111, joe);
		hMap.put(112, jane);
		hMap.put(113, tom);
		hMap.put(114, mary);
		for (Map.Entry<Integer, person> entry: hMap.entrySet()) {
			System.out.printf("%d: %s%n", entry.getKey(), entry.getValue().getName());
		}
		System.out.println("---HashMap: get element value for key 112");
		System.out.println(hMap.get(112).getName()); 
		
		System.out.println("---HashMap after changes");
		hMap.put(111, new person("Adam",40));
		hMap.putIfAbsent(114, new person("Elizabeth",90));
		for (Map.Entry<Integer, person> entry: hMap.entrySet()) {
			System.out.printf("%d: %s%n", entry.getKey(), entry.getValue().getName());
		}
		}
	
}

		

