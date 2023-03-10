package Program3;

public class MySortedArrayCollection<T> extends SortedArrayCollection<T>
		implements MySortedArrayCollectionInterface<T> {
	
	
	
	
	public MySortedArrayCollection() {
		super(100);
	}

	public MySortedArrayCollection(int capacity) {
		super(capacity);
		
	}

	public String toString() { //pass
		String text = "Size: " + size() + 
				"\n" + "isEmpty(): " + isEmpty() +
				"\n" + "isFull(): " + isFull() + 
				"\n" + "Smallest(): " + smallest() +"\n";
		for ( int i = 0 ; i <size(); i++) {
			  text = text + "Element[" + i + "] " + elements[i] + "\n";
		}
		
		return text;
	}

	public T smallest() {    //pass
          if (isEmpty()) {
        	  return null;
          }
                    
          
  		String[] array = new String[size()];
  		for (int i =0 ; i<array.length; i++) {
  			   array[i] = (String)elements[i];
  		} 
  		
  		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i].compareTo(array[j]) > 0) {					
					String temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
           //now first element of this "String array" is the smallest        	     
                   
        	 T data = (T)array[0];
        	
          return data;
	}

	public int greater(T element) {     //pass
	     
		     
		     //find location of the element using "find" method
		       find(element);
		       int counter = 0;		  		       
		       
		    String[] array = new String[size()];
	  		for (int i =0 ; i<array.length; i++) {
	  			   array[i] = (String)elements[i];
	  		}       
		         
	  		for(int i=0; i<location; i++) {
	  			 if ( array[i].compareTo(array[location]) > 0) {
	  				  counter++;
	  			 }
	  		}
	  		
	  		for(int i=location + 1; i<array.length; i++) {
	  			 if ( array[i].compareTo(array[location]) > 0) {
	  				  counter++;
	  			 }
	  		}
		        	
		          return counter;
	}

	public MySortedArrayCollection<T> combine(MySortedArrayCollection<T> other) {
						
		 
		this.addAll(other);
		
			return this;			
		        
	}

	public T[] toArray() {
		T[] array = (T[]) new Object[this.size()];

		for (int i = 0; i < this.size(); i++)
			array[i] = elements[i];

		return array;
	}

	public void clear() {
         
		for ( int i= 0 ; i <elements.length;i++) {
			 elements[i] = null;
		}
		numElements = 0;
		
         
	}

	public boolean equals(Object obj) {
		 T data = (T)obj.toString();
		 T data2 = (T)this.toString();
		 return data.equals(data2);
	}

	public boolean addAll(MySortedArrayCollection<T> other) {		          				    
		   
		 int currentsize = size()*1; 
		 int length = other.size();
		 
		 for (int i =0 ; i <length; i++) {			 		 
		 this.add(other.get(other.elements[i]));		
		 }
		 
			 
			 
			 
		 if ( currentsize != size()) {
			 
			 return true;
		 }
		   
			return false;
	}

	public boolean retainAll(MySortedArrayCollection<T> retain) {
		   	 		  		  		     		     
		      int currentsize = size() * 1;		     
		      clear();		
		      this.addAll(retain);
		      
		    	  
		    	  
		    	  
		    	  
		    	  
		    return !(currentsize==this.size());
	}                                                      

	public void removeAll(MySortedArrayCollection<T> remove) {
               //delete all of these
					
		         for( int i=0 ; i<size(); i++) {
		        	 
		    	                for(int k=0; k<remove.size(); k++) {
		    	                	    if(elements[i].equals(remove.elements[k]))		    	                	    	  
		    	                	    	 remove(elements[i]);
		    	                }
		         }
	}
}
