package com.tencent.token;

import android.os.Build.VERSION;
import android.widget.EdgeEffect;

public final class ft
{
  private static final b a = new b();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      a = new a();
      return;
    }
  }
  
  public static void a(EdgeEffect paramEdgeEffect, float paramFloat1, float paramFloat2)
  {
    a.a(paramEdgeEffect, paramFloat1, paramFloat2);
  }
  
  static final class a
    extends ft.b
  {
    public final void a(EdgeEffect paramEdgeEffect, float paramFloat1, float paramFloat2)
    {
      paramEdgeEffect.onPull(paramFloat1, paramFloat2);
    }
  }
  
  static class b
  {
    public void a(EdgeEffect paramEdgeEffect, float paramFloat1, float paramFloat2)
    {
      paramEdgeEffect.onPull(paramFloat1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ft
 * JD-Core Version:    0.7.0.1
 */