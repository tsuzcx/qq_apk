package com.hp.hpl.sparta.xpath;

public abstract class AttrRelationalExpr
  extends AttrExpr
{
  private final int attrValue_;
  
  AttrRelationalExpr(String paramString, int paramInt)
  {
    super(paramString);
    this.attrValue_ = paramInt;
  }
  
  public double getAttrValue()
  {
    return this.attrValue_;
  }
  
  protected String toString(String paramString)
  {
    return "[" + super.toString() + paramString + "'" + this.attrValue_ + "']";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.hp.hpl.sparta.xpath.AttrRelationalExpr
 * JD-Core Version:    0.7.0.1
 */