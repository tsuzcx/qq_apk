package com.hp.hpl.sparta.xpath;

public class TextTest
  extends NodeTest
{
  static final TextTest INSTANCE = new TextTest();
  
  public void accept(Visitor paramVisitor)
    throws XPathException
  {
    paramVisitor.visit(this);
  }
  
  public boolean isStringValue()
  {
    return true;
  }
  
  public String toString()
  {
    return "text()";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.hp.hpl.sparta.xpath.TextTest
 * JD-Core Version:    0.7.0.1
 */