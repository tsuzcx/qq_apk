package com.tencent.token;

import com.tencent.wcdb.database.SQLiteCustomFunction;
import java.util.ArrayList;
import java.util.Locale;

public final class aht
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
  
  public aht(aht paramaht)
  {
    if (paramaht != null)
    {
      this.a = paramaht.a;
      this.b = paramaht.b;
      a(paramaht);
      return;
    }
    throw new IllegalArgumentException("other must not be null.");
  }
  
  public aht(String paramString, int paramInt)
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
  
  public final void a(aht paramaht)
  {
    if (paramaht != null)
    {
      if (this.a.equals(paramaht.a))
      {
        this.d = paramaht.d;
        this.e = paramaht.e;
        this.f = paramaht.f;
        this.g = paramaht.g;
        this.h = paramaht.h;
        this.j = paramaht.j;
        this.k = paramaht.k;
        this.i = paramaht.i;
        this.c = paramaht.c;
        this.l.clear();
        this.l.addAll(paramaht.l);
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
 * Qualified Name:     com.tencent.token.aht
 * JD-Core Version:    0.7.0.1
 */