package com.hp.hpl.sparta.xpath;

import com.hp.hpl.sparta.Sparta;

public abstract class AttrCompareExpr
  extends AttrExpr
{
  private final String attrValue_;
  
  AttrCompareExpr(String paramString1, String paramString2)
  {
    super(paramString1);
    this.attrValue_ = Sparta.intern(paramString2);
  }
  
  public String getAttrValue()
  {
    return this.attrValue_;
  }
  
  protected String toString(String paramString)
  {
    return "[" + super.toString() + paramString + "'" + this.attrValue_ + "']";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.hp.hpl.sparta.xpath.AttrCompareExpr
 * JD-Core Version:    0.7.0.1
 */