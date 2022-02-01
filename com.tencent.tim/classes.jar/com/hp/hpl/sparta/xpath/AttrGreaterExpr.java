package com.hp.hpl.sparta.xpath;

public class AttrGreaterExpr
  extends AttrRelationalExpr
{
  public AttrGreaterExpr(String paramString, int paramInt)
  {
    super(paramString, paramInt);
  }
  
  public void accept(BooleanExprVisitor paramBooleanExprVisitor)
    throws XPathException
  {
    paramBooleanExprVisitor.visit(this);
  }
  
  public String toString()
  {
    return toString(">");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.hp.hpl.sparta.xpath.AttrGreaterExpr
 * JD-Core Version:    0.7.0.1
 */