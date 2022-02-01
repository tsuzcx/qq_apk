package com.tencent.halley.downloader.c.d;

import com.tencent.halley.common.h;

public final class a
{
  private static a[] d = { a.c, a.b, a.f, a.e, a.j, a.d, a.h, a.i, a.g };
  private static a[] e = { a.f, a.c, a.e, a.d, a.j, a.b, a.h, a.i, a.g };
  public String a;
  public a b;
  public int c = 0;
  
  public a(String paramString, a parama)
  {
    this.a = paramString;
    this.b = parama;
    if ((parama != a.e) && (parama != a.f) && (parama == a.j)) {}
  }
  
  public static a a(a parama, boolean paramBoolean)
  {
    int i = 0;
    a[] arrayOfa;
    a locala;
    if (paramBoolean)
    {
      arrayOfa = d;
      locala = arrayOfa[0];
      if (parama == null) {}
    }
    else
    {
      for (;;)
      {
        if (i >= arrayOfa.length) {
          break label60;
        }
        if ((parama == arrayOfa[i]) && (i != arrayOfa.length - 1))
        {
          return arrayOfa[(i + 1)];
          arrayOfa = e;
          break;
        }
        i += 1;
      }
    }
    label60:
    return locala;
  }
  
  public static boolean a(a parama)
  {
    return (parama == a.c) || (parama == a.d) || (parama == a.e) || (parama == a.f) || (parama == a.h) || (parama == a.i) || (parama == a.j);
  }
  
  public static boolean b(a parama)
  {
    return (parama == a.c) || (parama == a.e) || (parama == a.f) || (parama == a.h) || (parama == a.j);
  }
  
  public final void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public final String toString()
  {
    boolean bool = false;
    if ((this.b == a.e) || (this.b == a.f) || (this.b == a.j) || (this.b == a.c) || (this.b == a.h)) {
      bool = true;
    }
    return this.c + ":" + this.b.ordinal() + ":" + h.a(this.a, bool);
  }
  
  public static enum a
  {
    public static a[] a()
    {
      return (a[])k.clone();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.downloader.c.d.a
 * JD-Core Version:    0.7.0.1
 */