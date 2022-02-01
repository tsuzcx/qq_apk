package com.tencent.mobileqq.dinifly.model;

import android.support.annotation.RestrictTo;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
public class Font
{
  private final float ascent;
  private final String family;
  private final String name;
  private final String style;
  
  public Font(String paramString1, String paramString2, String paramString3, float paramFloat)
  {
    this.family = paramString1;
    this.name = paramString2;
    this.style = paramString3;
    this.ascent = paramFloat;
  }
  
  float getAscent()
  {
    return this.ascent;
  }
  
  public String getFamily()
  {
    return this.family;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getStyle()
  {
    return this.style;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.Font
 * JD-Core Version:    0.7.0.1
 */