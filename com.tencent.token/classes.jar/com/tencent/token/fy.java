package com.tencent.token;

import android.os.Build.VERSION;
import android.widget.TextView;

public final class fy
{
  static final g a = new g();
  
  static
  {
    if (dq.a())
    {
      a = new f();
      return;
    }
    if (Build.VERSION.SDK_INT >= 26)
    {
      a = new e();
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      a = new d();
      return;
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      a = new c();
      return;
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      a = new b();
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      a = new a();
      return;
    }
  }
  
  public static void a(TextView paramTextView, int paramInt)
  {
    a.a(paramTextView, paramInt);
  }
  
  static class a
    extends fy.g
  {}
  
  static class b
    extends fy.a
  {}
  
  static class c
    extends fy.b
  {}
  
  static class d
    extends fy.c
  {
    public final void a(TextView paramTextView, int paramInt)
    {
      paramTextView.setTextAppearance(paramInt);
    }
  }
  
  static class e
    extends fy.d
  {}
  
  static final class f
    extends fy.e
  {}
  
  static class g
  {
    public void a(TextView paramTextView, int paramInt)
    {
      paramTextView.setTextAppearance(paramTextView.getContext(), paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.fy
 * JD-Core Version:    0.7.0.1
 */