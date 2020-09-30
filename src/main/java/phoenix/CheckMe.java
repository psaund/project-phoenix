package phoenix;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class CheckMe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Something some = new Something();
		List<String> list = new ArrayList();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		some.doSomething(list);
		
		System.out.println(list);

	}

}

class Something{
	//List<String> list;
	
    public Something(){
        
    }
    
    public void doSomething(List<String> list){
    	ListIterator<String> iterator = list.listIterator();
    	while (iterator.hasNext()) {
    		String item = iterator.next();
    		if(item.equals(2)) {
    			iterator.remove();	
    		}
    	}
    	List<String> list2 = new ArrayList();
		list2.add("11");
		list2.add("21");
		list2.add("31");
		list2.add("41");
		list2.add("51");
    	list.clear();
    	list.addAll(list2);
    	
    	/*iterator = list.listIterator();
    	int i = 0;
    	while(iterator.hasNext()) {
    		iterator.next();
    		if(++i >0){
    			iterator.remove();
    		}
    		
    	}*/
    	//list.subList(0, 2);
    	
    }
}