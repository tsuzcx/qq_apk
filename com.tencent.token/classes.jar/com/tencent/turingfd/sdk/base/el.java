package com.tencent.turingfd.sdk.base;

import android.app.Activity;
import android.content.Context;
import com.tencent.token.fh;
import java.lang.ref.WeakReference;

public class el
{
  public String d;
  public int e;
  public int f;
  public int g;
  public int h;
  public Context i;
  public String j;
  public String k;
  public String l;
  public int m = 0;
  public String n = "";
  public WeakReference o;
  public fh p;
  public String q = "";
  
  public String d()
  {
    return this.d;
  }
  
  public int e()
  {
    return this.e;
  }
  
  public int f()
  {
    return this.f;
  }
  
  public int g()
  {
    return this.g;
  }
  
  public int h()
  {
    return this.h;
  }
  
  public String i()
  {
    return this.j;
  }
  
  public String j()
  {
    return this.k;
  }
  
  public String k()
  {
    return this.l;
  }
  
  public int l()
  {
    return this.m;
  }
  
  public String m()
  {
    return this.n;
  }
  
  public Activity n()
  {
    WeakReference localWeakReference = this.o;
    if (localWeakReference != null) {
      return (Activity)localWeakReference.get();
    }
    return null;
  }
  
  public Context o()
  {
    return this.i;
  }
  
  public fh p()
  {
    return this.p;
  }
  
  public dg q()
  {
    return new o("http://mazu.3g.qq.com");
  }
  
  public String r()
  {
    return this.q;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.el
 * JD-Core Version:    0.7.0.1
 */