package com.tencent.token;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

public class ez
{
  private static final b b;
  private static final View.AccessibilityDelegate c = new View.AccessibilityDelegate();
  final View.AccessibilityDelegate a = b.a(this);
  
  static
  {
    if (Build.VERSION.SDK_INT >= 16) {
      b = new a();
    } else {
      b = new b();
    }
  }
  
  public static fx a(View paramView)
  {
    return b.a(c, paramView);
  }
  
  public static void a(View paramView, int paramInt)
  {
    c.sendAccessibilityEvent(paramView, paramInt);
  }
  
  public static void a(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    c.sendAccessibilityEventUnchecked(paramView, paramAccessibilityEvent);
  }
  
  public static void c(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    c.onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public void a(View paramView, fw paramfw)
  {
    c.onInitializeAccessibilityNodeInfo(paramView, paramfw.a);
  }
  
  public boolean a(View paramView, int paramInt, Bundle paramBundle)
  {
    return b.a(c, paramView, paramInt, paramBundle);
  }
  
  public boolean a(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return c.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
  }
  
  public boolean b(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return c.dispatchPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public void d(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    c.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  static final class a
    extends ez.b
  {
    public final View.AccessibilityDelegate a(final ez paramez)
    {
      new View.AccessibilityDelegate()
      {
        public final boolean dispatchPopulateAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
        {
          return paramez.b(paramAnonymousView, paramAnonymousAccessibilityEvent);
        }
        
        public final AccessibilityNodeProvider getAccessibilityNodeProvider(View paramAnonymousView)
        {
          paramAnonymousView = ez.a(paramAnonymousView);
          if (paramAnonymousView != null) {
            return (AccessibilityNodeProvider)paramAnonymousView.a;
          }
          return null;
        }
        
        public final void onInitializeAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
        {
          paramez.d(paramAnonymousView, paramAnonymousAccessibilityEvent);
        }
        
        public final void onInitializeAccessibilityNodeInfo(View paramAnonymousView, AccessibilityNodeInfo paramAnonymousAccessibilityNodeInfo)
        {
          paramez.a(paramAnonymousView, fw.a(paramAnonymousAccessibilityNodeInfo));
        }
        
        public final void onPopulateAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
        {
          ez.c(paramAnonymousView, paramAnonymousAccessibilityEvent);
        }
        
        public final boolean onRequestSendAccessibilityEvent(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
        {
          return paramez.a(paramAnonymousViewGroup, paramAnonymousView, paramAnonymousAccessibilityEvent);
        }
        
        public final boolean performAccessibilityAction(View paramAnonymousView, int paramAnonymousInt, Bundle paramAnonymousBundle)
        {
          return paramez.a(paramAnonymousView, paramAnonymousInt, paramAnonymousBundle);
        }
        
        public final void sendAccessibilityEvent(View paramAnonymousView, int paramAnonymousInt)
        {
          ez.a(paramAnonymousView, paramAnonymousInt);
        }
        
        public final void sendAccessibilityEventUnchecked(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
        {
          ez.a(paramAnonymousView, paramAnonymousAccessibilityEvent);
        }
      };
    }
    
    public final fx a(View.AccessibilityDelegate paramAccessibilityDelegate, View paramView)
    {
      paramAccessibilityDelegate = paramAccessibilityDelegate.getAccessibilityNodeProvider(paramView);
      if (paramAccessibilityDelegate != null) {
        return new fx(paramAccessibilityDelegate);
      }
      return null;
    }
    
    public final boolean a(View.AccessibilityDelegate paramAccessibilityDelegate, View paramView, int paramInt, Bundle paramBundle)
    {
      return paramAccessibilityDelegate.performAccessibilityAction(paramView, paramInt, paramBundle);
    }
  }
  
  static class b
  {
    public View.AccessibilityDelegate a(final ez paramez)
    {
      new View.AccessibilityDelegate()
      {
        public final boolean dispatchPopulateAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
        {
          return paramez.b(paramAnonymousView, paramAnonymousAccessibilityEvent);
        }
        
        public final void onInitializeAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
        {
          paramez.d(paramAnonymousView, paramAnonymousAccessibilityEvent);
        }
        
        public final void onInitializeAccessibilityNodeInfo(View paramAnonymousView, AccessibilityNodeInfo paramAnonymousAccessibilityNodeInfo)
        {
          paramez.a(paramAnonymousView, fw.a(paramAnonymousAccessibilityNodeInfo));
        }
        
        public final void onPopulateAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
        {
          ez.c(paramAnonymousView, paramAnonymousAccessibilityEvent);
        }
        
        public final boolean onRequestSendAccessibilityEvent(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
        {
          return paramez.a(paramAnonymousViewGroup, paramAnonymousView, paramAnonymousAccessibilityEvent);
        }
        
        public final void sendAccessibilityEvent(View paramAnonymousView, int paramAnonymousInt)
        {
          ez.a(paramAnonymousView, paramAnonymousInt);
        }
        
        public final void sendAccessibilityEventUnchecked(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
        {
          ez.a(paramAnonymousView, paramAnonymousAccessibilityEvent);
        }
      };
    }
    
    public fx a(View.AccessibilityDelegate paramAccessibilityDelegate, View paramView)
    {
      return null;
    }
    
    public boolean a(View.AccessibilityDelegate paramAccessibilityDelegate, View paramView, int paramInt, Bundle paramBundle)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ez
 * JD-Core Version:    0.7.0.1
 */