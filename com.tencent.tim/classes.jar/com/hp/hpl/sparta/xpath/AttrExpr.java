package com.hp.hpl.sparta.xpath;

public abstract class AttrExpr
  extends BooleanExpr
{
  private final String attrName_;
  
  AttrExpr(String paramString)
  {
    this.attrName_ = paramString;
  }
  
  public String getAttrName()
  {
    return this.attrName_;
  }
  
  public String toString()
  {
    return "@" + this.attrName_;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.hp.hpl.sparta.xpath.AttrExpr
 * JD-Core Version:    0.7.0.1
 */