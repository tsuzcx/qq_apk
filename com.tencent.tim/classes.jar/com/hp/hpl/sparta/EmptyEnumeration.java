package com.hp.hpl.sparta;

import java.util.Enumeration;
import java.util.NoSuchElementException;

class EmptyEnumeration
  implements Enumeration
{
  public boolean hasMoreElements()
  {
    return false;
  }
  
  public Object nextElement()
  {
    throw new NoSuchElementException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.hp.hpl.sparta.EmptyEnumeration
 * JD-Core Version:    0.7.0.1
 */