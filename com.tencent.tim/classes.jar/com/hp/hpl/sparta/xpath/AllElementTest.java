package com.hp.hpl.sparta.xpath;

public class AllElementTest
  extends NodeTest
{
  static final AllElementTest INSTANCE = new AllElementTest();
  
  public void accept(Visitor paramVisitor)
  {
    paramVisitor.visit(this);
  }
  
  public boolean isStringValue()
  {
    return false;
  }
  
  public String toString()
  {
    return "*";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.hp.hpl.sparta.xpath.AllElementTest
 * JD-Core Version:    0.7.0.1
 */