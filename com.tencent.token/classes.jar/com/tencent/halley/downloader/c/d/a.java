package com.tencent.halley.downloader.c.d;

import com.tencent.token.lq;

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
    if ((parama != a.e) && (parama != a.f)) {
      paramString = a.j;
    }
  }
  
  public static a a(a parama, boolean paramBoolean)
  {
    a[] arrayOfa;
    if (paramBoolean) {
      arrayOfa = d;
    } else {
      arrayOfa = e;
    }
    int i = 0;
    a locala = arrayOfa[0];
    if (parama != null) {
      while (i < arrayOfa.length)
      {
        if ((parama == arrayOfa[i]) && (i != arrayOfa.length - 1)) {
          return arrayOfa[(i + 1)];
        }
        i += 1;
      }
    }
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
  
  public final String toString()
  {
    boolean bool;
    if ((this.b != a.e) && (this.b != a.f) && (this.b != a.j) && (this.b != a.c) && (this.b != a.h)) {
      bool = false;
    } else {
      bool = true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c);
    localStringBuilder.append(":");
    localStringBuilder.append(this.b.ordinal());
    localStringBuilder.append(":");
    localStringBuilder.append(lq.a(this.a, bool));
    return localStringBuilder.toString();
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