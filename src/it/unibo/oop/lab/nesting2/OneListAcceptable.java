package it.unibo.oop.lab.nesting2;

import java.util.HashSet;
import java.util.List;

public class OneListAcceptable<T> implements Acceptable<T> {

	private List<T> list;
	
	public Acceptor<T> acceptor() {
		return new AcceptorImpl<T>(new HashSet<>(list));
	}

	public OneListAcceptable(List<T> list) {
		this.list = list;
	}
	
}
