package com.tencent.qqmail.trd.guava;

import org.apache.commons.lang3.StringUtils;

public class Joiner
{
  private String mChar;
  
  private Joiner(String paramString)
  {
    this.mChar = paramString;
  }
  
  public static Joiner on(String paramString)
  {
    return new Joiner(paramString);
  }
  
  public String join(Iterable<?> paramIterable)
  {
    return StringUtils.join(paramIterable.iterator(), this.mChar);
  }
  
  public String join(Object[] paramArrayOfObject)
  {
    return StringUtils.join(paramArrayOfObject, this.mChar);
  }
  
  public Joiner skipNulls()
  {
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.trd.guava.Joiner
 * JD-Core Version:    0.7.0.1
 */