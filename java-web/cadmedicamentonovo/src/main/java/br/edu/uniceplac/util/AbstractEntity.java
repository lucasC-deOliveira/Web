package br.edu.uniceplac.util;

import java.io.Serializable;

public interface AbstractEntity<T> extends Serializable  {
	
	 T getId();

}
