package com.hp.hpl.sparta.xpath;

public class TrueExpr
  extends BooleanExpr
{
  static final TrueExpr INSTANCE = new TrueExpr();
  
  public void accept(BooleanExprVisitor paramBooleanExprVisitor)
  {
    paramBooleanExprVisitor.visit(this);
  }
  
  public String toString()
  {
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.hp.hpl.sparta.xpath.TrueExpr
 * JD-Core Version:    0.7.0.1
 */