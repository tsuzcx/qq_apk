package com.hp.hpl.sparta.xpath;

public class TextExistsExpr
  extends BooleanExpr
{
  static final TextExistsExpr INSTANCE = new TextExistsExpr();
  
  public void accept(BooleanExprVisitor paramBooleanExprVisitor)
    throws XPathException
  {
    paramBooleanExprVisitor.visit(this);
  }
  
  public String toString()
  {
    return "[text()]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.hp.hpl.sparta.xpath.TextExistsExpr
 * JD-Core Version:    0.7.0.1
 */