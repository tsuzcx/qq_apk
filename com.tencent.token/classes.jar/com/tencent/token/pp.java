package com.tencent.token;

import android.os.Build;
import android.os.Build.VERSION;
import java.io.PrintStream;

public final class pp
{
  private static int a = 6;
  private static PrintStream b;
  private static byte[] c;
  private static final String d;
  
  static
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder("VERSION.RELEASE:[");
    localStringBuilder2.append(Build.VERSION.RELEASE);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("] VERSION.CODENAME:[");
    localStringBuilder2.append(Build.VERSION.CODENAME);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("] VERSION.INCREMENTAL:[");
    localStringBuilder2.append(Build.VERSION.INCREMENTAL);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("] BOARD:[");
    localStringBuilder2.append(Build.BOARD);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("] DEVICE:[");
    localStringBuilder2.append(Build.DEVICE);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("] DISPLAY:[");
    localStringBuilder2.append(Build.DISPLAY);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("] FINGERPRINT:[");
    localStringBuilder2.append(Build.FINGERPRINT);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("] HOST:[");
    localStringBuilder2.append(Build.HOST);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("] MANUFACTURER:[");
    localStringBuilder2.append(Build.MANUFACTURER);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("] MODEL:[");
    localStringBuilder2.append(Build.MODEL);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("] PRODUCT:[");
    localStringBuilder2.append(Build.PRODUCT);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("] TAGS:[");
    localStringBuilder2.append(Build.TAGS);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("] TYPE:[");
    localStringBuilder2.append(Build.TYPE);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("] USER:[");
    localStringBuilder2.append(Build.USER);
    localStringBuilder2.append("]");
    localStringBuilder1.append(localStringBuilder2.toString());
    d = localStringBuilder1.toString();
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (a <= 4) {
      pq.a(b, c, "E/".concat(String.valueOf(paramString1)), paramString2);
    }
  }
  
  public static void b(String paramString1, String paramString2)
  {
    if (a <= 2) {
      pq.a(b, c, "I/".concat(String.valueOf(paramString1)), paramString2);
    }
  }
  
  public static void c(String paramString1, String paramString2)
  {
    if (a <= 1) {
      pq.a(b, c, "D/".concat(String.valueOf(paramString1)), paramString2);
    }
  }
  
  public static void d(String paramString1, String paramString2)
  {
    if (a <= 0) {
      pq.a(b, c, "V/".concat(String.valueOf(paramString1)), paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.pp
 * JD-Core Version:    0.7.0.1
 */