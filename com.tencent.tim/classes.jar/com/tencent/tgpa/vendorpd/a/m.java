package com.tencent.tgpa.vendorpd.a;

import android.util.Log;

public class m
{
  public static boolean a = false;
  
  public static void a(String paramString)
  {
    if (a) {
      Log.v("TGPA", paramString);
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    a = paramBoolean;
  }
  
  public static void b(String paramString)
  {
    if (a) {
      Log.d("TGPA", paramString);
    }
  }
  
  public static void c(String paramString)
  {
    if (a) {
      Log.e("TGPA", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tgpa.vendorpd.a.m
 * JD-Core Version:    0.7.0.1
 */