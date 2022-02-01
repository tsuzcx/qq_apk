package com.tencent.token;

import com.tencent.wcdb.database.SQLiteCustomFunction;
import java.util.ArrayList;
import java.util.Locale;

public final class agh
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
  
  public agh(agh paramagh)
  {
    if (paramagh != null)
    {
      this.a = paramagh.a;
      this.b = paramagh.b;
      a(paramagh);
      return;
    }
    throw new IllegalArgumentException("other must not be null.");
  }
  
  public agh(String paramString, int paramInt)
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
  
  public final void a(agh paramagh)
  {
    if (paramagh != null)
    {
      if (this.a.equals(paramagh.a))
      {
        this.d = paramagh.d;
        this.e = paramagh.e;
        this.f = paramagh.f;
        this.g = paramagh.g;
        this.h = paramagh.h;
        this.j = paramagh.j;
        this.k = paramagh.k;
        this.i = paramagh.i;
        this.c = paramagh.c;
        this.l.clear();
        this.l.addAll(paramagh.l);
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
 * Qualified Name:     com.tencent.token.agh
 * JD-Core Version:    0.7.0.1
 */