package com.tencent.android.tpush.c;

import android.content.Context;
import com.tencent.android.tpush.stat.b.b;
import com.tencent.android.tpush.stat.b.c;
import com.tencent.android.tpush.stat.b.e;

public abstract class d
{
  protected c a = b.b();
  protected Context b = null;
  protected int c = 0;
  
  protected d(Context paramContext, int paramInt)
  {
    this.b = paramContext;
    this.c = paramInt;
  }
  
  private String e()
  {
    if (b()) {
      return b(a());
    }
    return null;
  }
  
  protected abstract String a();
  
  protected String b(String paramString)
  {
    return e.a(paramString);
  }
  
  protected abstract boolean b();
  
  protected String c()
  {
    if (this.c == 0) {
      return e.a("4kU71lN96TJUomD1vOU9lgj9Tw==");
    }
    return e.a("4kU71lN96TJUomD1vOU9lgj9Tw==") + this.c;
  }
  
  public a d()
  {
    String str = e();
    if (str != null) {
      return a.a(str);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.c.d
 * JD-Core Version:    0.7.0.1
 */