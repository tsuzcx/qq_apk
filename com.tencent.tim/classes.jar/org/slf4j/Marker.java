package org.slf4j;

import java.io.Serializable;
import java.util.Iterator;

public abstract interface Marker
  extends Serializable
{
  public static final String ANY_MARKER = "*";
  public static final String ANY_NON_NULL_MARKER = "+";
  
  public abstract void add(Marker paramMarker);
  
  public abstract boolean contains(String paramString);
  
  public abstract boolean contains(Marker paramMarker);
  
  public abstract boolean equals(Object paramObject);
  
  public abstract String getName();
  
  public abstract boolean hasChildren();
  
  public abstract boolean hasReferences();
  
  public abstract int hashCode();
  
  public abstract Iterator<Marker> iterator();
  
  public abstract boolean remove(Marker paramMarker);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.slf4j.Marker
 * JD-Core Version:    0.7.0.1
 */