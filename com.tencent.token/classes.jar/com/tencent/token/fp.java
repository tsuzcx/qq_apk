package com.tencent.token;

import android.os.Build.VERSION;
import android.view.ViewGroup;

public final class fp
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
    extends fp.c
  {}
  
  static final class b
    extends fp.a
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
      Boolean localBoolean = (Boolean)paramViewGroup.getTag(ca.a.tag_transition_group);
      return ((localBoolean != null) && (localBoolean.booleanValue())) || (paramViewGroup.getBackground() != null) || (fo.h(paramViewGroup) != null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.fp
 * JD-Core Version:    0.7.0.1
 */