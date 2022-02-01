package com.tencent.token;

import com.tencent.wcdb.database.SQLiteCustomFunction;
import java.util.ArrayList;
import java.util.Locale;

public final class ait
{
  public final String a;
  public final String b;
  public String c;
  public int d;
  public int e;
  public Locale f;
  public boolean g;
  public boolean h;
  public int i;
  public boolean j;
  public boolean k;
  public final ArrayList<SQLiteCustomFunction> l = new ArrayList();
  
  public ait(ait paramait)
  {
    if (paramait != null)
    {
      this.a = paramait.a;
      this.b = paramait.b;
      a(paramait);
      return;
    }
    throw new IllegalArgumentException("other must not be null.");
  }
  
  public ait(String paramString, int paramInt)
  {
    if (paramString != null)
    {
      this.a = paramString;
      this.b = paramString;
      this.d = paramInt;
      this.i = 2;
      this.e = 25;
      this.f = Locale.getDefault();
      if ((paramInt & 0x100) != 0) {
        paramString = "vfslog";
      } else {
        paramString = null;
      }
      this.c = paramString;
      return;
    }
    throw new IllegalArgumentException("path must not be null.");
  }
  
  public final void a(ait paramait)
  {
    if (paramait != null)
    {
      if (this.a.equals(paramait.a))
      {
        this.d = paramait.d;
        this.e = paramait.e;
        this.f = paramait.f;
        this.g = paramait.g;
        this.h = paramait.h;
        this.j = paramait.j;
        this.k = paramait.k;
        this.i = paramait.i;
        this.c = paramait.c;
        this.l.clear();
        this.l.addAll(paramait.l);
        return;
      }
      throw new IllegalArgumentException("other configuration must refer to the same database.");
    }
    throw new IllegalArgumentException("other must not be null.");
  }
  
  public final boolean a()
  {
    return this.a.equalsIgnoreCase(":memory:");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ait
 * JD-Core Version:    0.7.0.1
 */