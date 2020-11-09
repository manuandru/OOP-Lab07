package it.unibo.oop.lab.nesting2;

import java.util.Iterator;
import java.util.List;

public class OneListAcceptable<T> implements Acceptable<T> {

	private List<T> acceptedList;
	
	/**
	 * @param acceptedList of accepted Element T
	 */
	public OneListAcceptable(List<T> acceptedList) {
		this.acceptedList = acceptedList;
	}
	
	public Acceptor<T> acceptor() {
		return new Acceptor<T>() {
			
			private Iterator<T> actualAcceptedIterator = acceptedList.iterator();
			
			public void accept(T newElement) throws ElementNotAcceptedException {
				if (!actualAcceptedIterator.hasNext() 
						|| !actualAcceptedIterator.next().equals(newElement)) {
					throw new ElementNotAcceptedException(newElement);
				}
			}

			public void end() throws EndNotAcceptedException {
				if (actualAcceptedIterator.hasNext()) {
					throw new EndNotAcceptedException();
				}
			}
			
		};
	}

	/**
	 * @return String rapresentation of acceptedList
	 */
	public String toString() {
		return "OneListAcceptable [acceptedList=" + acceptedList + "]";
	}
	
}
