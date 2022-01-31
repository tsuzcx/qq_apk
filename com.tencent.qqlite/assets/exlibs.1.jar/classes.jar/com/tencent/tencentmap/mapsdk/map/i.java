package com.tencent.tencentmap.mapsdk.map;

import android.graphics.Canvas;
import java.util.ArrayList;

abstract class i
  extends j
{
  protected n f;
  protected boolean g = false;
  
  protected abstract void a();
  
  protected abstract void a(Canvas paramCanvas);
  
  final void a(n paramn)
  {
    this.f = paramn;
  }
  
  protected abstract void a(ArrayList<v.b> paramArrayList, boolean paramBoolean);
  
  protected abstract void b();
  
  protected abstract void b(Canvas paramCanvas);
  
  protected abstract void c();
  
  protected abstract void c(Canvas paramCanvas);
  
  protected abstract void d();
  
  protected abstract int e();
  
  protected abstract void f();
  
  protected abstract void g();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.i
 * JD-Core Version:    0.7.0.1
 */