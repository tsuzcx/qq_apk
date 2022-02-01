package com.tencent.token;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;

public final class fe
{
  public final AccessibilityNodeInfo a;
  public int b = -1;
  
  private fe(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    this.a = paramAccessibilityNodeInfo;
  }
  
  public static fe a(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    return new fe(paramAccessibilityNodeInfo);
  }
  
  public static fe a(fe paramfe)
  {
    return a(AccessibilityNodeInfo.obtain(paramfe.a));
  }
  
  public final void a(int paramInt)
  {
    this.a.addAction(paramInt);
  }
  
  public final void a(Rect paramRect)
  {
    this.a.getBoundsInParent(paramRect);
  }
  
  public final void a(View paramView)
  {
    this.a.setSource(paramView);
  }
  
  public final void a(CharSequence paramCharSequence)
  {
    this.a.setPackageName(paramCharSequence);
  }
  
  public final void a(boolean paramBoolean)
  {
    this.a.setFocusable(paramBoolean);
  }
  
  public final boolean a()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return this.a.isVisibleToUser();
    }
    return false;
  }
  
  public final boolean a(a parama)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return this.a.removeAction((AccessibilityNodeInfo.AccessibilityAction)parama.E);
    }
    return false;
  }
  
  public final void b(Rect paramRect)
  {
    this.a.setBoundsInParent(paramRect);
  }
  
  public final void b(View paramView)
  {
    this.a.addChild(paramView);
  }
  
  public final void b(CharSequence paramCharSequence)
  {
    this.a.setClassName(paramCharSequence);
  }
  
  public final void b(boolean paramBoolean)
  {
    this.a.setFocused(paramBoolean);
  }
  
  public final boolean b()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return this.a.isAccessibilityFocused();
    }
    return false;
  }
  
  public final void c(Rect paramRect)
  {
    this.a.getBoundsInScreen(paramRect);
  }
  
  public final void c(View paramView)
  {
    this.a.setParent(paramView);
  }
  
  public final void c(CharSequence paramCharSequence)
  {
    this.a.setContentDescription(paramCharSequence);
  }
  
  public final void c(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      this.a.setVisibleToUser(paramBoolean);
    }
  }
  
  public final void d(Rect paramRect)
  {
    this.a.setBoundsInScreen(paramRect);
  }
  
  public final void d(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      this.a.setAccessibilityFocused(paramBoolean);
    }
  }
  
  public final void e(boolean paramBoolean)
  {
    this.a.setSelected(paramBoolean);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (getClass() != paramObject.getClass()) {
      return false;
    }
    paramObject = (fe)paramObject;
    AccessibilityNodeInfo localAccessibilityNodeInfo = this.a;
    if (localAccessibilityNodeInfo == null)
    {
      if (paramObject.a != null) {
        return false;
      }
    }
    else if (!localAccessibilityNodeInfo.equals(paramObject.a)) {
      return false;
    }
    return true;
  }
  
  public final void f(boolean paramBoolean)
  {
    this.a.setClickable(paramBoolean);
  }
  
  public final void g(boolean paramBoolean)
  {
    this.a.setLongClickable(paramBoolean);
  }
  
  public final void h(boolean paramBoolean)
  {
    this.a.setEnabled(paramBoolean);
  }
  
  public final int hashCode()
  {
    AccessibilityNodeInfo localAccessibilityNodeInfo = this.a;
    if (localAccessibilityNodeInfo == null) {
      return 0;
    }
    return localAccessibilityNodeInfo.hashCode();
  }
  
  public final void i(boolean paramBoolean)
  {
    this.a.setScrollable(paramBoolean);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    Object localObject = new Rect();
    a((Rect)localObject);
    localStringBuilder.append("; boundsInParent: ".concat(String.valueOf(localObject)));
    c((Rect)localObject);
    localStringBuilder.append("; boundsInScreen: ".concat(String.valueOf(localObject)));
    localStringBuilder.append("; packageName: ");
    localStringBuilder.append(this.a.getPackageName());
    localStringBuilder.append("; className: ");
    localStringBuilder.append(this.a.getClassName());
    localStringBuilder.append("; text: ");
    localStringBuilder.append(this.a.getText());
    localStringBuilder.append("; contentDescription: ");
    localStringBuilder.append(this.a.getContentDescription());
    localStringBuilder.append("; viewId: ");
    if (Build.VERSION.SDK_INT >= 18) {
      localObject = this.a.getViewIdResourceName();
    } else {
      localObject = null;
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("; checkable: ");
    localStringBuilder.append(this.a.isCheckable());
    localStringBuilder.append("; checked: ");
    localStringBuilder.append(this.a.isChecked());
    localStringBuilder.append("; focusable: ");
    localStringBuilder.append(this.a.isFocusable());
    localStringBuilder.append("; focused: ");
    localStringBuilder.append(this.a.isFocused());
    localStringBuilder.append("; selected: ");
    localStringBuilder.append(this.a.isSelected());
    localStringBuilder.append("; clickable: ");
    localStringBuilder.append(this.a.isClickable());
    localStringBuilder.append("; longClickable: ");
    localStringBuilder.append(this.a.isLongClickable());
    localStringBuilder.append("; enabled: ");
    localStringBuilder.append(this.a.isEnabled());
    localStringBuilder.append("; password: ");
    localStringBuilder.append(this.a.isPassword());
    localObject = new StringBuilder("; scrollable: ");
    ((StringBuilder)localObject).append(this.a.isScrollable());
    localStringBuilder.append(((StringBuilder)localObject).toString());
    localStringBuilder.append("; [");
    int i = this.a.getActions();
    while (i != 0)
    {
      int k = 1 << Integer.numberOfTrailingZeros(i);
      int j = i & (k ^ 0xFFFFFFFF);
      switch (k)
      {
      default: 
        localObject = "ACTION_UNKNOWN";
        break;
      case 131072: 
        localObject = "ACTION_SET_SELECTION";
        break;
      case 65536: 
        localObject = "ACTION_CUT";
        break;
      case 32768: 
        localObject = "ACTION_PASTE";
        break;
      case 16384: 
        localObject = "ACTION_COPY";
        break;
      case 8192: 
        localObject = "ACTION_SCROLL_BACKWARD";
        break;
      case 4096: 
        localObject = "ACTION_SCROLL_FORWARD";
        break;
      case 2048: 
        localObject = "ACTION_PREVIOUS_HTML_ELEMENT";
        break;
      case 1024: 
        localObject = "ACTION_NEXT_HTML_ELEMENT";
        break;
      case 512: 
        localObject = "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
        break;
      case 256: 
        localObject = "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
        break;
      case 128: 
        localObject = "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
        break;
      case 64: 
        localObject = "ACTION_ACCESSIBILITY_FOCUS";
        break;
      case 32: 
        localObject = "ACTION_LONG_CLICK";
        break;
      case 16: 
        localObject = "ACTION_CLICK";
        break;
      case 8: 
        localObject = "ACTION_CLEAR_SELECTION";
        break;
      case 4: 
        localObject = "ACTION_SELECT";
        break;
      case 2: 
        localObject = "ACTION_CLEAR_FOCUS";
        break;
      case 1: 
        localObject = "ACTION_FOCUS";
      }
      localStringBuilder.append((String)localObject);
      i = j;
      if (j != 0)
      {
        localStringBuilder.append(", ");
        i = j;
      }
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public static final class a
  {
    public static final a A;
    public static final a B;
    public static final a C;
    public static final a D;
    public static final a a = new a(1);
    public static final a b = new a(2);
    public static final a c = new a(4);
    public static final a d = new a(8);
    public static final a e = new a(16);
    public static final a f = new a(32);
    public static final a g = new a(64);
    public static final a h = new a(128);
    public static final a i = new a(256);
    public static final a j = new a(512);
    public static final a k = new a(1024);
    public static final a l = new a(2048);
    public static final a m = new a(4096);
    public static final a n = new a(8192);
    public static final a o = new a(16384);
    public static final a p = new a(32768);
    public static final a q = new a(65536);
    public static final a r = new a(131072);
    public static final a s = new a(262144);
    public static final a t = new a(524288);
    public static final a u = new a(1048576);
    public static final a v = new a(2097152);
    public static final a w;
    public static final a x;
    public static final a y;
    public static final a z;
    final Object E;
    
    static
    {
      int i1 = Build.VERSION.SDK_INT;
      Object localObject2 = null;
      if (i1 >= 23) {
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN;
      } else {
        localObject1 = null;
      }
      w = new a(localObject1);
      if (Build.VERSION.SDK_INT >= 23) {
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION;
      } else {
        localObject1 = null;
      }
      x = new a(localObject1);
      if (Build.VERSION.SDK_INT >= 23) {
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP;
      } else {
        localObject1 = null;
      }
      y = new a(localObject1);
      if (Build.VERSION.SDK_INT >= 23) {
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT;
      } else {
        localObject1 = null;
      }
      z = new a(localObject1);
      if (Build.VERSION.SDK_INT >= 23) {
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN;
      } else {
        localObject1 = null;
      }
      A = new a(localObject1);
      if (Build.VERSION.SDK_INT >= 23) {
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT;
      } else {
        localObject1 = null;
      }
      B = new a(localObject1);
      if (Build.VERSION.SDK_INT >= 23) {
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK;
      } else {
        localObject1 = null;
      }
      C = new a(localObject1);
      Object localObject1 = localObject2;
      if (Build.VERSION.SDK_INT >= 24) {
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS;
      }
      D = new a(localObject1);
    }
    
    private a(int paramInt)
    {
      this(localAccessibilityAction);
    }
    
    private a(Object paramObject)
    {
      this.E = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.fe
 * JD-Core Version:    0.7.0.1
 */