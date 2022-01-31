package com.tencent.halley.downloader.c.d;

import com.tencent.halley.common.j;

public final class a
{
  private static a.a[] d = { a.a.c, a.a.b, a.a.f, a.a.e, a.a.j, a.a.d, a.a.h, a.a.i, a.a.g };
  private static a.a[] e = { a.a.f, a.a.c, a.a.e, a.a.d, a.a.j, a.a.b, a.a.h, a.a.i, a.a.g };
  public String a;
  public a.a b;
  public int c = 0;
  
  public a(String paramString, a.a parama)
  {
    this.a = paramString;
    this.b = parama;
    if ((parama != a.a.e) && (parama != a.a.f) && (parama == a.a.j)) {}
  }
  
  public static a.a a(a.a parama, boolean paramBoolean)
  {
    int i = 0;
    a.a[] arrayOfa;
    a.a locala;
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
  
  public static boolean a(a.a parama)
  {
    return (parama == a.a.c) || (parama == a.a.d) || (parama == a.a.e) || (parama == a.a.f) || (parama == a.a.h) || (parama == a.a.i) || (parama == a.a.j);
  }
  
  public static boolean b(a.a parama)
  {
    return (parama == a.a.c) || (parama == a.a.e) || (parama == a.a.f) || (parama == a.a.h) || (parama == a.a.j);
  }
  
  public final void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public final String toString()
  {
    boolean bool = false;
    if ((this.b == a.a.e) || (this.b == a.a.f) || (this.b == a.a.j) || (this.b == a.a.c) || (this.b == a.a.h)) {
      bool = true;
    }
    return this.c + ":" + this.b.ordinal() + ":" + j.a(this.a, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.downloader.c.d.a
 * JD-Core Version:    0.7.0.1
 */