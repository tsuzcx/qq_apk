package com.hp.hpl.sparta.xpath;

public class PositionEqualsExpr
  extends BooleanExpr
{
  private final int position_;
  
  public PositionEqualsExpr(int paramInt)
  {
    this.position_ = paramInt;
  }
  
  public void accept(BooleanExprVisitor paramBooleanExprVisitor)
    throws XPathException
  {
    paramBooleanExprVisitor.visit(this);
  }
  
  public int getPosition()
  {
    return this.position_;
  }
  
  public String toString()
  {
    return "[" + this.position_ + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.hp.hpl.sparta.xpath.PositionEqualsExpr
 * JD-Core Version:    0.7.0.1
 */