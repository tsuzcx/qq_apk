package com.tencent.token;

import android.support.v4.widget.DrawerLayout.c;

public final class gc
  implements DrawerLayout.c
{
  boolean a;
  private final a b;
  private gt c;
  private boolean d;
  private final int e;
  private final int f;
  
  private void a(int paramInt)
  {
    this.b.a(paramInt);
  }
  
  private void b(float paramFloat)
  {
    if (paramFloat == 1.0F) {
      this.c.a(true);
    } else if (paramFloat == 0.0F) {
      this.c.a(false);
    }
    this.c.a(paramFloat);
  }
  
  public final void a()
  {
    b(1.0F);
    if (this.a) {
      a(this.f);
    }
  }
  
  public final void a(float paramFloat)
  {
    if (this.d)
    {
      b(Math.min(1.0F, Math.max(0.0F, paramFloat)));
      return;
    }
    b(0.0F);
  }
  
  public final void b()
  {
    b(0.0F);
    if (this.a) {
      a(this.e);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.gc
 * JD-Core Version:    0.7.0.1
 */