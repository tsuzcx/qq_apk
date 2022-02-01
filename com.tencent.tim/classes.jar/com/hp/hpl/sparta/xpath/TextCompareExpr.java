package com.hp.hpl.sparta.xpath;

public abstract class TextCompareExpr
  extends BooleanExpr
{
  private final String value_;
  
  TextCompareExpr(String paramString)
  {
    this.value_ = paramString;
  }
  
  public String getValue()
  {
    return this.value_;
  }
  
  protected String toString(String paramString)
  {
    return "[text()" + paramString + "'" + this.value_ + "']";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.hp.hpl.sparta.xpath.TextCompareExpr
 * JD-Core Version:    0.7.0.1
 */