package com.hp.hpl.sparta.xpath;

public class TextEqualsExpr
  extends TextCompareExpr
{
  TextEqualsExpr(String paramString)
  {
    super(paramString);
  }
  
  public void accept(BooleanExprVisitor paramBooleanExprVisitor)
    throws XPathException
  {
    paramBooleanExprVisitor.visit(this);
  }
  
  public String toString()
  {
    return toString("=");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.hp.hpl.sparta.xpath.TextEqualsExpr
 * JD-Core Version:    0.7.0.1
 */