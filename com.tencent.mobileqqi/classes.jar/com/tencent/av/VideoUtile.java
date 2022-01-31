package com.tencent.av;

public class VideoUtile
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 0;
  public static final int e = 1;
  public static final int f = 2;
  public static final int g = 3;
  public static final int h = 4;
  public static final int i = 5;
  public static final int j = 6;
  public static final int k = 7;
  public static final int l = 8;
  public static final int m = 9;
  public static final int n = 10;
  public static final int o = 11;
  
  public static String a(String paramString, long paramLong, int paramInt, boolean paramBoolean)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append('\026');
    localStringBuffer.append(paramString);
    localStringBuffer.append('|');
    localStringBuffer.append(paramLong);
    localStringBuffer.append('|');
    localStringBuffer.append(paramInt);
    localStringBuffer.append('|');
    if (paramBoolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      localStringBuffer.append(paramInt);
      return localStringBuffer.toString();
    }
  }
  
  public static String[] a(String paramString)
  {
    return paramString.split("\026")[1].split("\\|");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.VideoUtile
 * JD-Core Version:    0.7.0.1
 */