package it.unibo.oop.lab.nesting2;

import java.util.HashSet;
import java.util.Set;


public class AcceptorImpl<T> implements Acceptor<T> {

	private final Set<T> acceptedSet;
	private final Set<T> actualSet;
	
	/**
	 * 
	 * @param acceptedSet
	 * 			new acceptable Set 
	 */
	public AcceptorImpl(Set<T> acceptedSet) {
		this.acceptedSet = acceptedSet;
		this.actualSet = new HashSet<>();	
	}
	
	/**
	 * Accept an element
	 * @throws {@link it.unibo.oop.lab.nesting2.ElementNotAcceptedException} 
	 * 			if element is not acceptable
	 */
	public void accept(T newElement) throws ElementNotAcceptedException {
		if (this.acceptedSet.contains(newElement)) {
			actualSet.add(newElement);
		} else {
			throw new ElementNotAcceptedException(newElement);
		}
	}

	/**
	 * @throws {@link it.unibo.oop.lab.nesting2.EndNotAcceptedException} 
	 * 			if all acceptable element are not accepted
	 */
	public void end() throws EndNotAcceptedException {
		if (!this.isAcceptionFinish()) {
			throw new EndNotAcceptedException();
		}
	}

	private boolean isAcceptionFinish() {
		return this.acceptedSet.equals(this.actualSet);
	}
}
