package com.tencent.mobileqq.tribe.view;

import android.text.style.ForegroundColorSpan;

public class TribeThemeSpan
  extends ForegroundColorSpan
{
  public int end;
  public int start;
  
  public TribeThemeSpan(int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1);
    this.start = paramInt2;
    this.end = paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.view.TribeThemeSpan
 * JD-Core Version:    0.7.0.1
 */