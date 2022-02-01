package com.tencent.token;

import android.os.Build.VERSION;
import android.widget.TextView;

public final class gb
{
  static final g a = new g();
  
  static
  {
    if (dt.a())
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
    extends gb.g
  {}
  
  static class b
    extends gb.a
  {}
  
  static class c
    extends gb.b
  {}
  
  static class d
    extends gb.c
  {
    public final void a(TextView paramTextView, int paramInt)
    {
      paramTextView.setTextAppearance(paramInt);
    }
  }
  
  static class e
    extends gb.d
  {}
  
  static final class f
    extends gb.e
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
 * Qualified Name:     com.tencent.token.gb
 * JD-Core Version:    0.7.0.1
 */