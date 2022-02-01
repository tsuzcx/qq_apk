package com.tencent.hlyyb.downloader.e.d;

public final class a
{
  private static int[] g = { b.c, b.b, b.f, b.e, b.j, b.d, b.h, b.i, b.g };
  private static int[] h = { b.f, b.c, b.e, b.d, b.j, b.b, b.h, b.i, b.g };
  public String a;
  public int b;
  public int c = 0;
  public boolean d = false;
  public String e = "";
  public boolean f = false;
  
  public a(String paramString, int paramInt)
  {
    this.a = paramString;
    this.b = paramInt;
  }
  
  public static int a(int paramInt, boolean paramBoolean)
  {
    int i = 0;
    int[] arrayOfInt;
    int j;
    if (paramBoolean)
    {
      arrayOfInt = g;
      j = arrayOfInt[0];
      if (paramInt == 0) {}
    }
    else
    {
      for (;;)
      {
        if (i >= arrayOfInt.length) {
          return j;
        }
        if ((paramInt == arrayOfInt[i]) && (i != arrayOfInt.length - 1))
        {
          return arrayOfInt[(i + 1)];
          arrayOfInt = h;
          break;
        }
        i += 1;
      }
    }
    return j;
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == b.c) || (paramInt == b.d) || (paramInt == b.e) || (paramInt == b.f) || (paramInt == b.h) || (paramInt == b.i) || (paramInt == b.j);
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt == b.c) || (paramInt == b.e) || (paramInt == b.f) || (paramInt == b.h) || (paramInt == b.j);
  }
  
  public final String toString()
  {
    boolean bool = false;
    if ((this.b == b.e) || (this.b == b.f) || (this.b == b.j) || (this.b == b.c) || (this.b == b.h)) {
      bool = true;
    }
    return this.c + ":" + (this.b - 1) + ":" + com.tencent.hlyyb.common.b.b.a(this.a, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.e.d.a
 * JD-Core Version:    0.7.0.1
 */