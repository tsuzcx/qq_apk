package com.tencent.token.core.bean;

import android.view.View.OnClickListener;

public class e
{
  private View.OnClickListener a;
  private int b;
  private String c;
  private boolean d = false;
  private boolean e = true;
  private int f;
  private String g;
  private String h;
  
  public e(View.OnClickListener paramOnClickListener, int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3)
  {
    this.a = paramOnClickListener;
    this.b = paramInt1;
    this.c = paramString1;
    this.f = paramInt2;
    this.h = paramString2;
    this.g = paramString3;
  }
  
  public String a()
  {
    return this.h;
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public View.OnClickListener d()
  {
    return this.a;
  }
  
  public boolean e()
  {
    return this.d;
  }
  
  public boolean f()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.e
 * JD-Core Version:    0.7.0.1
 */