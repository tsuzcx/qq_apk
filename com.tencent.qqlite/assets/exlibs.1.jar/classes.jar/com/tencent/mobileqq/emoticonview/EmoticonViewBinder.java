package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.drawable.Drawable;

public abstract class EmoticonViewBinder
{
  public static final int c = 1;
  public static final int d = 2;
  public static final int e = 3;
  public static final int f = 4;
  public static final int g = 5;
  public static final int h = 6;
  public static final int i = 7;
  public static final int j = 8;
  public static final int k = 9;
  public static final int l = 100;
  public static final int m = 101;
  public int n;
  
  public EmoticonViewBinder(int paramInt)
  {
    this.n = paramInt;
  }
  
  public abstract Drawable a(Context paramContext);
  
  public void a() {}
  
  public int b()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonViewBinder
 * JD-Core Version:    0.7.0.1
 */