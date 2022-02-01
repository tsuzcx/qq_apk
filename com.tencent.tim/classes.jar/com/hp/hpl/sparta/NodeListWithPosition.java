package com.hp.hpl.sparta;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

class NodeListWithPosition
{
  private static final Integer EIGHT = new Integer(8);
  private static final Integer FIVE;
  private static final Integer FOUR;
  private static final Integer NINE = new Integer(9);
  private static final Integer ONE = new Integer(1);
  private static final Integer SEVEN;
  private static final Integer SIX;
  private static final Integer TEN = new Integer(10);
  private static final Integer THREE;
  private static final Integer TWO = new Integer(2);
  private Hashtable positions_ = new Hashtable();
  private final Vector vector_ = new Vector();
  
  static
  {
    THREE = new Integer(3);
    FOUR = new Integer(4);
    FIVE = new Integer(5);
    SIX = new Integer(6);
    SEVEN = new Integer(7);
  }
  
  private static Integer identity(Node paramNode)
  {
    return new Integer(System.identityHashCode(paramNode));
  }
  
  void add(Node paramNode, int paramInt)
  {
    this.vector_.addElement(paramNode);
    Integer localInteger;
    switch (paramInt)
    {
    default: 
      localInteger = new Integer(paramInt);
    }
    for (;;)
    {
      this.positions_.put(identity(paramNode), localInteger);
      return;
      localInteger = ONE;
      continue;
      localInteger = TWO;
      continue;
      localInteger = THREE;
      continue;
      localInteger = FOUR;
      continue;
      localInteger = FIVE;
      continue;
      localInteger = SIX;
      continue;
      localInteger = SEVEN;
      continue;
      localInteger = EIGHT;
      continue;
      localInteger = NINE;
      continue;
      localInteger = TEN;
    }
  }
  
  void add(String paramString)
  {
    this.vector_.addElement(paramString);
  }
  
  Enumeration iterator()
  {
    return this.vector_.elements();
  }
  
  int position(Node paramNode)
  {
    return ((Integer)this.positions_.get(identity(paramNode))).intValue();
  }
  
  void removeAllElements()
  {
    this.vector_.removeAllElements();
    this.positions_.clear();
  }
  
  public String toString()
  {
    for (;;)
    {
      Object localObject;
      try
      {
        StringBuffer localStringBuffer = new StringBuffer("{ ");
        Enumeration localEnumeration = this.vector_.elements();
        if (!localEnumeration.hasMoreElements())
        {
          localStringBuffer.append("}");
          return localStringBuffer.toString();
        }
        localObject = localEnumeration.nextElement();
        if ((localObject instanceof String))
        {
          localStringBuffer.append("String(" + localObject + ") ");
          continue;
        }
        localObject = (Node)localObject;
      }
      catch (IOException localIOException)
      {
        return localIOException.toString();
      }
      localIOException.append("Node(" + ((Node)localObject).toXml() + ")[" + this.positions_.get(identity((Node)localObject)) + "] ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.hp.hpl.sparta.NodeListWithPosition
 * JD-Core Version:    0.7.0.1
 */