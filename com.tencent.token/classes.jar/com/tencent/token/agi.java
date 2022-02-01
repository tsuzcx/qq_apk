package com.tencent.token;

import com.tencent.wcdb.database.SQLiteCustomFunction;
import java.util.ArrayList;
import java.util.Locale;

public final class agi
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
  
  public agi(agi paramagi)
  {
    if (paramagi != null)
    {
      this.a = paramagi.a;
      this.b = paramagi.b;
      a(paramagi);
      return;
    }
    throw new IllegalArgumentException("other must not be null.");
  }
  
  public agi(String paramString, int paramInt)
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
  
  public final void a(agi paramagi)
  {
    if (paramagi != null)
    {
      if (this.a.equals(paramagi.a))
      {
        this.d = paramagi.d;
        this.e = paramagi.e;
        this.f = paramagi.f;
        this.g = paramagi.g;
        this.h = paramagi.h;
        this.j = paramagi.j;
        this.k = paramagi.k;
        this.i = paramagi.i;
        this.c = paramagi.c;
        this.l.clear();
        this.l.addAll(paramagi.l);
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
 * Qualified Name:     com.tencent.token.agi
 * JD-Core Version:    0.7.0.1
 */