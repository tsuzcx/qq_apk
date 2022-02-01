package com.tencent.token;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;

public final class fc
{
  static final c a = new c();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      a = new b();
      return;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      a = new a();
      return;
    }
  }
  
  public static void a(ViewParent paramViewParent, View paramView, int paramInt)
  {
    if ((paramViewParent instanceof ev))
    {
      ((ev)paramViewParent).c(paramInt);
      return;
    }
    if (paramInt == 0) {
      a.a(paramViewParent, paramView);
    }
  }
  
  public static void a(ViewParent paramViewParent, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if ((paramViewParent instanceof ev))
    {
      ((ev)paramViewParent).d(paramInt5);
      return;
    }
    if (paramInt5 == 0) {
      a.a(paramViewParent, paramView, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public static void a(ViewParent paramViewParent, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    if ((paramViewParent instanceof ev))
    {
      ((ev)paramViewParent).a(paramInt1, paramInt2, paramArrayOfInt, paramInt3);
      return;
    }
    if (paramInt3 == 0) {
      a.a(paramViewParent, paramView, paramInt1, paramInt2, paramArrayOfInt);
    }
  }
  
  public static boolean a(ViewParent paramViewParent, View paramView, float paramFloat1, float paramFloat2)
  {
    return a.a(paramViewParent, paramView, paramFloat1, paramFloat2);
  }
  
  public static boolean a(ViewParent paramViewParent, View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return a.a(paramViewParent, paramView, paramFloat1, paramFloat2, paramBoolean);
  }
  
  public static boolean a(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    if ((paramViewParent instanceof ev)) {
      return ((ev)paramViewParent).b(paramInt2);
    }
    if (paramInt2 == 0) {
      return a.a(paramViewParent, paramView1, paramView2, paramInt1);
    }
    return false;
  }
  
  public static void b(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    if ((paramViewParent instanceof ev))
    {
      ((ev)paramViewParent).a(paramView2, paramInt1);
      return;
    }
    if (paramInt2 == 0) {
      a.b(paramViewParent, paramView1, paramView2, paramInt1);
    }
  }
  
  static class a
    extends fc.c
  {}
  
  static final class b
    extends fc.a
  {
    public final void a(ViewParent paramViewParent, View paramView)
    {
      try
      {
        paramViewParent.onStopNestedScroll(paramView);
        return;
      }
      catch (AbstractMethodError paramView)
      {
        label8:
        break label8;
      }
      paramView = new StringBuilder("ViewParent ");
      paramView.append(paramViewParent);
      paramView.append(" does not implement interface method onStopNestedScroll");
    }
    
    public final void a(ViewParent paramViewParent, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      try
      {
        paramViewParent.onNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
        return;
      }
      catch (AbstractMethodError paramView)
      {
        label15:
        break label15;
      }
      paramView = new StringBuilder("ViewParent ");
      paramView.append(paramViewParent);
      paramView.append(" does not implement interface method onNestedScroll");
    }
    
    public final void a(ViewParent paramViewParent, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
    {
      try
      {
        paramViewParent.onNestedPreScroll(paramView, paramInt1, paramInt2, paramArrayOfInt);
        return;
      }
      catch (AbstractMethodError paramView)
      {
        label13:
        break label13;
      }
      paramView = new StringBuilder("ViewParent ");
      paramView.append(paramViewParent);
      paramView.append(" does not implement interface method onNestedPreScroll");
    }
    
    public final boolean a(ViewParent paramViewParent, View paramView, float paramFloat1, float paramFloat2)
    {
      try
      {
        boolean bool = paramViewParent.onNestedPreFling(paramView, paramFloat1, paramFloat2);
        return bool;
      }
      catch (AbstractMethodError paramView)
      {
        label15:
        break label15;
      }
      paramView = new StringBuilder("ViewParent ");
      paramView.append(paramViewParent);
      paramView.append(" does not implement interface method onNestedPreFling");
      return false;
    }
    
    public final boolean a(ViewParent paramViewParent, View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
    {
      try
      {
        paramBoolean = paramViewParent.onNestedFling(paramView, paramFloat1, paramFloat2, paramBoolean);
        return paramBoolean;
      }
      catch (AbstractMethodError paramView)
      {
        label17:
        break label17;
      }
      paramView = new StringBuilder("ViewParent ");
      paramView.append(paramViewParent);
      paramView.append(" does not implement interface method onNestedFling");
      return false;
    }
    
    public final boolean a(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt)
    {
      try
      {
        boolean bool = paramViewParent.onStartNestedScroll(paramView1, paramView2, paramInt);
        return bool;
      }
      catch (AbstractMethodError paramView1)
      {
        label15:
        break label15;
      }
      paramView1 = new StringBuilder("ViewParent ");
      paramView1.append(paramViewParent);
      paramView1.append(" does not implement interface method onStartNestedScroll");
      return false;
    }
    
    public final void b(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt)
    {
      try
      {
        paramViewParent.onNestedScrollAccepted(paramView1, paramView2, paramInt);
        return;
      }
      catch (AbstractMethodError paramView1)
      {
        label11:
        break label11;
      }
      paramView1 = new StringBuilder("ViewParent ");
      paramView1.append(paramViewParent);
      paramView1.append(" does not implement interface method onNestedScrollAccepted");
    }
  }
  
  static class c
  {
    public void a(ViewParent paramViewParent, View paramView)
    {
      if ((paramViewParent instanceof eu)) {
        ((eu)paramViewParent).onStopNestedScroll(paramView);
      }
    }
    
    public void a(ViewParent paramViewParent, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      if ((paramViewParent instanceof eu)) {
        ((eu)paramViewParent).onNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
      }
    }
    
    public void a(ViewParent paramViewParent, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
    {
      if ((paramViewParent instanceof eu)) {
        ((eu)paramViewParent).onNestedPreScroll(paramView, paramInt1, paramInt2, paramArrayOfInt);
      }
    }
    
    public boolean a(ViewParent paramViewParent, View paramView, float paramFloat1, float paramFloat2)
    {
      if ((paramViewParent instanceof eu)) {
        return ((eu)paramViewParent).onNestedPreFling(paramView, paramFloat1, paramFloat2);
      }
      return false;
    }
    
    public boolean a(ViewParent paramViewParent, View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
    {
      if ((paramViewParent instanceof eu)) {
        return ((eu)paramViewParent).onNestedFling(paramView, paramFloat1, paramFloat2, paramBoolean);
      }
      return false;
    }
    
    public boolean a(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt)
    {
      if ((paramViewParent instanceof eu)) {
        return ((eu)paramViewParent).onStartNestedScroll(paramView1, paramView2, paramInt);
      }
      return false;
    }
    
    public void b(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt)
    {
      if ((paramViewParent instanceof eu)) {
        ((eu)paramViewParent).onNestedScrollAccepted(paramView1, paramView2, paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.fc
 * JD-Core Version:    0.7.0.1
 */