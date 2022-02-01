package com.tencent.token;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

public final class fg
{
  public final Object a;
  
  public fg()
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      this.a = new b(this);
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.a = new a(this);
      return;
    }
    this.a = null;
  }
  
  public fg(Object paramObject)
  {
    this.a = paramObject;
  }
  
  static class a
    extends AccessibilityNodeProvider
  {
    final fg a;
    
    a(fg paramfg)
    {
      this.a = paramfg;
    }
    
    public AccessibilityNodeInfo createAccessibilityNodeInfo(int paramInt)
    {
      return null;
    }
    
    public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String paramString, int paramInt)
    {
      return null;
    }
    
    public boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
    {
      return false;
    }
  }
  
  static final class b
    extends fg.a
  {
    b(fg paramfg)
    {
      super();
    }
    
    public final AccessibilityNodeInfo findFocus(int paramInt)
    {
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.fg
 * JD-Core Version:    0.7.0.1
 */