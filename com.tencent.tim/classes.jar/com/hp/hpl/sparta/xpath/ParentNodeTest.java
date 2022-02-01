package com.hp.hpl.sparta.xpath;

public class ParentNodeTest
  extends NodeTest
{
  static final ParentNodeTest INSTANCE = new ParentNodeTest();
  
  public void accept(Visitor paramVisitor)
    throws XPathException
  {
    paramVisitor.visit(this);
  }
  
  public boolean isStringValue()
  {
    return false;
  }
  
  public String toString()
  {
    return "..";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.hp.hpl.sparta.xpath.ParentNodeTest
 * JD-Core Version:    0.7.0.1
 */