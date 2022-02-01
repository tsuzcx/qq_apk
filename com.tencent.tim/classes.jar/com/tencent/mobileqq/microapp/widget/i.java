package com.tencent.mobileqq.microapp.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.microapp.a.c;

public final class i
{
  protected WebViewProgressBar a;
  private byte b = -1;
  private int c = 0;
  private Handler d = new b();
  private boolean e = false;
  private int f = 255;
  private float g;
  private float h;
  private float i;
  private float j;
  private float k;
  private byte l = 6;
  private long m;
  
  private long a(long paramLong)
  {
    long l1 = paramLong;
    if (paramLong > 30L) {
      l1 = 30L;
    }
    return l1;
  }
  
  public byte a()
  {
    return this.l;
  }
  
  public void a(byte paramByte)
  {
    switch (paramByte)
    {
    default: 
    case 0: 
      do
      {
        return;
      } while (this.b == 0);
      this.b = 0;
      d();
      return;
    case 1: 
      e();
      return;
    }
    if ((this.b == 0) || (this.b == 1)) {
      f();
    }
    this.b = 2;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(WebViewProgressBar paramWebViewProgressBar)
  {
    this.a = paramWebViewProgressBar;
  }
  
  public float b()
  {
    return this.k;
  }
  
  public int c()
  {
    return this.f;
  }
  
  public void d()
  {
    int i1 = a.a(0).b();
    int n = i1;
    if (i1 <= 0) {
      n = a.a(0).a();
    }
    this.i = (20.0F / n);
    this.h = 0.0F;
    this.l = 0;
    this.k = this.j;
    this.f = 255;
    this.m = System.currentTimeMillis();
    if (this.a != null) {
      this.a.setVisibility(0);
    }
    h();
  }
  
  public void e()
  {
    a.a(0).c();
    int i1 = a.a(1).b();
    int n = i1;
    if (i1 <= 0) {
      n = a.a(1).a();
    }
    this.i = (60.0F / n);
    this.m = System.currentTimeMillis();
    this.l = 2;
    this.b = 1;
    h();
  }
  
  public void f()
  {
    a.a(1).c();
    this.m = System.currentTimeMillis();
    this.l = 5;
    this.i = 0.1333333F;
    if (this.h <= 60.0F) {
      this.i = ((40.0F + (60.0F - this.h) * 0.5F) / 300.0F);
    }
    for (this.g = 0.8166667F;; this.g = (245.0F * this.i / (100.0F - this.h)))
    {
      h();
      return;
    }
  }
  
  public void g()
  {
    this.l = 6;
    this.h = 0.0F;
    this.j = ((int)(this.h * this.c / 100.0F));
    this.f = 255;
    this.m = System.currentTimeMillis();
  }
  
  public void h()
  {
    long l1;
    if (this.l != 6)
    {
      l1 = System.currentTimeMillis();
      if (this.h < 100.0F) {
        break label66;
      }
      g();
    }
    for (;;)
    {
      this.d.removeMessages(200);
      this.d.sendEmptyMessageDelayed(200, 20L);
      if (this.a != null) {
        this.a.invalidate();
      }
      return;
      label66:
      long l2;
      float f1;
      switch (this.l)
      {
      default: 
        break;
      case 0: 
        l2 = a(l1 - this.m);
        f1 = this.h;
        this.h = ((float)l2 * this.i + f1);
        this.m = l1;
        if (this.h >= 20.0F)
        {
          this.m = l1;
          this.l = 1;
          this.i /= 5.0F;
        }
        this.k = (this.c * this.h / 100.0F);
        break;
      case 1: 
        l2 = a(l1 - this.m);
        f1 = this.h;
        this.h = ((float)l2 * this.i + f1);
        this.m = l1;
        if (this.h >= 98.0F)
        {
          this.m = l1;
          this.l = 4;
          this.h = 98.0F;
          this.i = 0.0F;
        }
        this.k = (this.c * this.h / 100.0F);
        break;
      case 2: 
        l2 = a(l1 - this.m);
        f1 = this.h;
        this.h = ((float)l2 * this.i + f1);
        this.m = l1;
        if (this.h >= 80.0F)
        {
          this.m = l1;
          this.l = 3;
          this.i /= 20.0F;
        }
        this.k = (this.c * this.h / 100.0F);
        break;
      case 3: 
        l2 = a(l1 - this.m);
        f1 = this.h;
        this.h = ((float)l2 * this.i + f1);
        this.m = l1;
        if (this.h >= 98.0F)
        {
          this.m = l1;
          this.l = 4;
          this.i = 0.0F;
        }
        this.k = (this.c * this.h / 100.0F);
        break;
      case 5: 
        l2 = a(l1 - this.m);
        this.h += (float)l2 * this.i;
        this.m = l1;
        this.k = (this.c * this.h / 100.0F);
        if (this.e)
        {
          if (this.k >= this.c) {
            this.k = this.c;
          }
        }
        else
        {
          this.f -= (int)((float)l2 * this.g);
          if (this.f <= 0)
          {
            g();
            this.f = 0;
          }
        }
        break;
      case 4: 
        this.k = (this.c * this.h / 100.0F);
      }
    }
  }
  
  static final class a
  {
    private static a b = null;
    private static a c = null;
    private int[] a = null;
    private int d = 0;
    private int e = 0;
    private int f = 9000;
    private int g = 1800;
    private long h;
    private int i;
    
    public a(int paramInt)
    {
      this.d = paramInt;
      this.e = 0;
      if (this.d == 0) {
        this.f = 9000;
      }
      for (this.g = 1800;; this.g = 1200)
      {
        this.h = 0L;
        this.i = 0;
        this.a = new int[3];
        paramInt = 0;
        while (paramInt < 3)
        {
          this.a[paramInt] = 0;
          paramInt += 1;
        }
        this.f = 6000;
      }
    }
    
    public static a a(int paramInt)
    {
      if (paramInt == 0)
      {
        if (b == null) {
          b = new a(0);
        }
        return b;
      }
      if (c == null) {
        c = new a(1);
      }
      return c;
    }
    
    private int d()
    {
      int j = 0;
      int k = 0;
      int n;
      for (int m = 0; j < 3; m = n)
      {
        int i1 = k;
        n = m;
        if (this.a[j] > 0)
        {
          n = m + 1;
          i1 = k + this.a[j];
        }
        j += 1;
        k = i1;
      }
      if (m > 0) {
        return k / m;
      }
      return 0;
    }
    
    private void e()
    {
      int j = 0;
      while (j < 3)
      {
        this.a[j] = 0;
        j += 1;
      }
      this.i = 0;
    }
    
    public int a()
    {
      if (2 == this.e) {
        return this.f;
      }
      return this.g;
    }
    
    public int b()
    {
      this.h = System.currentTimeMillis();
      int k = c.a();
      int j;
      if (this.e != k)
      {
        j = 1;
        this.e = k;
        if (j == 0) {
          break label62;
        }
        if (this.e != 2) {
          break label54;
        }
        j = this.f;
        label43:
        e();
      }
      label54:
      label62:
      do
      {
        return j;
        j = 0;
        break;
        j = this.g;
        break label43;
        k = d();
        j = k;
      } while (k > 0);
      return 0;
    }
    
    public void c()
    {
      int k = (int)(System.currentTimeMillis() - this.h);
      int m = d();
      int j;
      if (this.e == 2)
      {
        j = this.f;
        if (m != 0) {
          break label90;
        }
        j *= 3;
        label36:
        if (k > 100) {
          if (k <= j) {
            break label97;
          }
        }
      }
      for (;;)
      {
        this.a[this.i] = ((int)(j * 1.2F));
        j = this.i + 1;
        this.i = j;
        this.i = (j % 3);
        return;
        j = this.g;
        break;
        label90:
        j = m * 3;
        break label36;
        label97:
        j = k;
      }
    }
  }
  
  final class b
    extends Handler
  {
    public b()
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        return;
      }
      i.this.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.i
 * JD-Core Version:    0.7.0.1
 */