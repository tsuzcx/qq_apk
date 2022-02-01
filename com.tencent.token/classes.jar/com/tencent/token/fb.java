package com.tencent.token;

import android.os.Build.VERSION;
import android.view.ViewGroup;

public final class fb
{
  static final c a = new c();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      a = new b();
      return;
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      a = new a();
      return;
    }
  }
  
  public static boolean a(ViewGroup paramViewGroup)
  {
    return a.a(paramViewGroup);
  }
  
  static class a
    extends fb.c
  {}
  
  static final class b
    extends fb.a
  {
    public final boolean a(ViewGroup paramViewGroup)
    {
      return paramViewGroup.isTransitionGroup();
    }
  }
  
  static class c
  {
    public boolean a(ViewGroup paramViewGroup)
    {
      Boolean localBoolean = (Boolean)paramViewGroup.getTag(bm.a.tag_transition_group);
      return ((localBoolean != null) && (localBoolean.booleanValue())) || (paramViewGroup.getBackground() != null) || (fa.h(paramViewGroup) != null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.fb
 * JD-Core Version:    0.7.0.1
 */