package com.tencent.av.ui;

import android.os.Handler;
import android.os.Looper;
import bjg;
import java.util.Observable;
import java.util.Observer;

public abstract class ControlUIObserver
  implements Observer
{
  public static final int a = 100;
  public static final int b = 101;
  public static final int c = 102;
  public static final int d = 103;
  public static final int e = 104;
  public static final int f = 105;
  public static final int g = 106;
  public static final int h = 107;
  public static final int i = 108;
  public static final int j = 109;
  public static final int k = 110;
  public static final int l = 111;
  public static final int m = 112;
  public static final int n = 113;
  Handler a = null;
  
  protected abstract void a();
  
  public void a(Object paramObject)
  {
    paramObject = (Object[])paramObject;
    switch (((Integer)paramObject[0]).intValue())
    {
    default: 
      return;
    case 100: 
      a();
      return;
    case 101: 
      b();
      return;
    case 102: 
      c();
      return;
    case 103: 
      d();
      return;
    case 104: 
      e();
      return;
    case 105: 
      f();
      return;
    case 106: 
      g();
      return;
    case 107: 
      h();
      return;
    case 108: 
      i();
      return;
    case 109: 
      j();
      return;
    case 110: 
      k();
      return;
    case 111: 
      a(((Boolean)paramObject[1]).booleanValue());
      return;
    case 112: 
      l();
      return;
    }
    m();
  }
  
  protected abstract void a(boolean paramBoolean);
  
  protected abstract void b();
  
  protected abstract void c();
  
  protected abstract void d();
  
  protected abstract void e();
  
  protected abstract void f();
  
  protected abstract void g();
  
  protected abstract void h();
  
  protected abstract void i();
  
  protected abstract void j();
  
  protected abstract void k();
  
  protected abstract void l();
  
  protected abstract void m();
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = Looper.getMainLooper();
    if (Thread.currentThread() != paramObservable.getThread())
    {
      if (this.a == null) {
        this.a = new Handler(paramObservable);
      }
      this.a.post(new bjg(this, paramObject));
      return;
    }
    a(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.ui.ControlUIObserver
 * JD-Core Version:    0.7.0.1
 */