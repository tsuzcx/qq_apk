package android.support.v4.view.accessibility;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AccessibilityNodeInfoCompat
{
  public static final int ACTION_ACCESSIBILITY_FOCUS = 64;
  public static final String ACTION_ARGUMENT_HTML_ELEMENT_STRING = "ACTION_ARGUMENT_HTML_ELEMENT_STRING";
  public static final String ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT = "ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT";
  public static final int ACTION_CLEAR_ACCESSIBILITY_FOCUS = 128;
  public static final int ACTION_CLEAR_FOCUS = 2;
  public static final int ACTION_CLEAR_SELECTION = 8;
  public static final int ACTION_CLICK = 16;
  public static final int ACTION_FOCUS = 1;
  public static final int ACTION_LONG_CLICK = 32;
  public static final int ACTION_NEXT_AT_MOVEMENT_GRANULARITY = 256;
  public static final int ACTION_NEXT_HTML_ELEMENT = 1024;
  public static final int ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = 512;
  public static final int ACTION_PREVIOUS_HTML_ELEMENT = 2048;
  public static final int ACTION_SCROLL_BACKWARD = 8192;
  public static final int ACTION_SCROLL_FORWARD = 4096;
  public static final int ACTION_SELECT = 4;
  public static final int FOCUS_ACCESSIBILITY = 2;
  public static final int FOCUS_INPUT = 1;
  private static final AccessibilityNodeInfoImpl IMPL = new AccessibilityNodeInfoStubImpl();
  public static final int MOVEMENT_GRANULARITY_CHARACTER = 1;
  public static final int MOVEMENT_GRANULARITY_LINE = 4;
  public static final int MOVEMENT_GRANULARITY_PAGE = 16;
  public static final int MOVEMENT_GRANULARITY_PARAGRAPH = 8;
  public static final int MOVEMENT_GRANULARITY_WORD = 2;
  private final Object mInfo;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      IMPL = new AccessibilityNodeInfoJellybeanImpl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      IMPL = new AccessibilityNodeInfoIcsImpl();
      return;
    }
  }
  
  public AccessibilityNodeInfoCompat(Object paramObject)
  {
    this.mInfo = paramObject;
  }
  
  public static AccessibilityNodeInfoCompat obtain()
  {
    return wrapNonNullInstance(IMPL.obtain());
  }
  
  public static AccessibilityNodeInfoCompat obtain(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    return wrapNonNullInstance(IMPL.obtain(paramAccessibilityNodeInfoCompat.mInfo));
  }
  
  public static AccessibilityNodeInfoCompat obtain(View paramView)
  {
    return wrapNonNullInstance(IMPL.obtain(paramView));
  }
  
  public static AccessibilityNodeInfoCompat obtain(View paramView, int paramInt)
  {
    return wrapNonNullInstance(IMPL.obtain(paramView, paramInt));
  }
  
  static AccessibilityNodeInfoCompat wrapNonNullInstance(Object paramObject)
  {
    if (paramObject != null) {
      return new AccessibilityNodeInfoCompat(paramObject);
    }
    return null;
  }
  
  public void addAction(int paramInt)
  {
    IMPL.addAction(this.mInfo, paramInt);
  }
  
  public void addChild(View paramView)
  {
    IMPL.addChild(this.mInfo, paramView);
  }
  
  public void addChild(View paramView, int paramInt)
  {
    IMPL.addChild(this.mInfo, paramView, paramInt);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (AccessibilityNodeInfoCompat)paramObject;
        if (this.mInfo != null) {
          break;
        }
      } while (paramObject.mInfo == null);
      return false;
    } while (this.mInfo.equals(paramObject.mInfo));
    return false;
  }
  
  public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = IMPL.findAccessibilityNodeInfosByText(this.mInfo, paramString);
    int j = paramString.size();
    int i = 0;
    while (i < j)
    {
      localArrayList.add(new AccessibilityNodeInfoCompat(paramString.get(i)));
      i += 1;
    }
    return localArrayList;
  }
  
  public AccessibilityNodeInfoCompat findFocus(int paramInt)
  {
    return wrapNonNullInstance(IMPL.findFocus(this.mInfo, paramInt));
  }
  
  public AccessibilityNodeInfoCompat focusSearch(int paramInt)
  {
    return wrapNonNullInstance(IMPL.focusSearch(this.mInfo, paramInt));
  }
  
  public int getActions()
  {
    return IMPL.getActions(this.mInfo);
  }
  
  public void getBoundsInParent(Rect paramRect)
  {
    IMPL.getBoundsInParent(this.mInfo, paramRect);
  }
  
  public void getBoundsInScreen(Rect paramRect)
  {
    IMPL.getBoundsInScreen(this.mInfo, paramRect);
  }
  
  public AccessibilityNodeInfoCompat getChild(int paramInt)
  {
    return wrapNonNullInstance(IMPL.getChild(this.mInfo, paramInt));
  }
  
  public int getChildCount()
  {
    return IMPL.getChildCount(this.mInfo);
  }
  
  public CharSequence getClassName()
  {
    return IMPL.getClassName(this.mInfo);
  }
  
  public CharSequence getContentDescription()
  {
    return IMPL.getContentDescription(this.mInfo);
  }
  
  public Object getInfo()
  {
    return this.mInfo;
  }
  
  public int getMovementGranularities()
  {
    return IMPL.getMovementGranularities(this.mInfo);
  }
  
  public CharSequence getPackageName()
  {
    return IMPL.getPackageName(this.mInfo);
  }
  
  public AccessibilityNodeInfoCompat getParent()
  {
    return wrapNonNullInstance(IMPL.getParent(this.mInfo));
  }
  
  public CharSequence getText()
  {
    return IMPL.getText(this.mInfo);
  }
  
  public int getWindowId()
  {
    return IMPL.getWindowId(this.mInfo);
  }
  
  public int hashCode()
  {
    if (this.mInfo == null) {
      return 0;
    }
    return this.mInfo.hashCode();
  }
  
  public boolean isAccessibilityFocused()
  {
    return IMPL.isAccessibilityFocused(this.mInfo);
  }
  
  public boolean isCheckable()
  {
    return IMPL.isCheckable(this.mInfo);
  }
  
  public boolean isChecked()
  {
    return IMPL.isChecked(this.mInfo);
  }
  
  public boolean isClickable()
  {
    return IMPL.isClickable(this.mInfo);
  }
  
  public boolean isEnabled()
  {
    return IMPL.isEnabled(this.mInfo);
  }
  
  public boolean isFocusable()
  {
    return IMPL.isFocusable(this.mInfo);
  }
  
  public boolean isFocused()
  {
    return IMPL.isFocused(this.mInfo);
  }
  
  public boolean isLongClickable()
  {
    return IMPL.isLongClickable(this.mInfo);
  }
  
  public boolean isPassword()
  {
    return IMPL.isPassword(this.mInfo);
  }
  
  public boolean isScrollable()
  {
    return IMPL.isScrollable(this.mInfo);
  }
  
  public boolean isSelected()
  {
    return IMPL.isSelected(this.mInfo);
  }
  
  public boolean isVisibleToUser()
  {
    return IMPL.isVisibleToUser(this.mInfo);
  }
  
  public boolean performAction(int paramInt)
  {
    return IMPL.performAction(this.mInfo, paramInt);
  }
  
  public boolean performAction(int paramInt, Bundle paramBundle)
  {
    return IMPL.performAction(this.mInfo, paramInt, paramBundle);
  }
  
  public void recycle()
  {
    IMPL.recycle(this.mInfo);
  }
  
  public void setAccessibilityFocused(boolean paramBoolean)
  {
    IMPL.setAccessibilityFocused(this.mInfo, paramBoolean);
  }
  
  public void setBoundsInParent(Rect paramRect)
  {
    IMPL.setBoundsInParent(this.mInfo, paramRect);
  }
  
  public void setBoundsInScreen(Rect paramRect)
  {
    IMPL.setBoundsInScreen(this.mInfo, paramRect);
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    IMPL.setCheckable(this.mInfo, paramBoolean);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    IMPL.setChecked(this.mInfo, paramBoolean);
  }
  
  public void setClassName(CharSequence paramCharSequence)
  {
    IMPL.setClassName(this.mInfo, paramCharSequence);
  }
  
  public void setClickable(boolean paramBoolean)
  {
    IMPL.setClickable(this.mInfo, paramBoolean);
  }
  
  public void setContentDescription(CharSequence paramCharSequence)
  {
    IMPL.setContentDescription(this.mInfo, paramCharSequence);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    IMPL.setEnabled(this.mInfo, paramBoolean);
  }
  
  public void setFocusable(boolean paramBoolean)
  {
    IMPL.setFocusable(this.mInfo, paramBoolean);
  }
  
  public void setFocused(boolean paramBoolean)
  {
    IMPL.setFocused(this.mInfo, paramBoolean);
  }
  
  public void setLongClickable(boolean paramBoolean)
  {
    IMPL.setLongClickable(this.mInfo, paramBoolean);
  }
  
  public void setMovementGranularities(int paramInt)
  {
    IMPL.setMovementGranularities(this.mInfo, paramInt);
  }
  
  public void setPackageName(CharSequence paramCharSequence)
  {
    IMPL.setPackageName(this.mInfo, paramCharSequence);
  }
  
  public void setParent(View paramView)
  {
    IMPL.setParent(this.mInfo, paramView);
  }
  
  public void setParent(View paramView, int paramInt)
  {
    IMPL.setParent(this.mInfo, paramView, paramInt);
  }
  
  public void setPassword(boolean paramBoolean)
  {
    IMPL.setPassword(this.mInfo, paramBoolean);
  }
  
  public void setScrollable(boolean paramBoolean)
  {
    IMPL.setScrollable(this.mInfo, paramBoolean);
  }
  
  public void setSelected(boolean paramBoolean)
  {
    IMPL.setSelected(this.mInfo, paramBoolean);
  }
  
  public void setSource(View paramView)
  {
    IMPL.setSource(this.mInfo, paramView);
  }
  
  public void setSource(View paramView, int paramInt)
  {
    IMPL.setSource(this.mInfo, paramView, paramInt);
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    IMPL.setText(this.mInfo, paramCharSequence);
  }
  
  public void setVisibleToUser(boolean paramBoolean)
  {
    IMPL.setVisibleToUser(this.mInfo, paramBoolean);
  }
  
  static class AccessibilityNodeInfoIcsImpl
    extends AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl
  {
    public void addAction(Object paramObject, int paramInt)
    {
      AccessibilityNodeInfoCompatIcs.addAction(paramObject, paramInt);
    }
    
    public void addChild(Object paramObject, View paramView)
    {
      AccessibilityNodeInfoCompatIcs.addChild(paramObject, paramView);
    }
    
    public List<Object> findAccessibilityNodeInfosByText(Object paramObject, String paramString)
    {
      return AccessibilityNodeInfoCompatIcs.findAccessibilityNodeInfosByText(paramObject, paramString);
    }
    
    public int getActions(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.getActions(paramObject);
    }
    
    public void getBoundsInParent(Object paramObject, Rect paramRect)
    {
      AccessibilityNodeInfoCompatIcs.getBoundsInParent(paramObject, paramRect);
    }
    
    public void getBoundsInScreen(Object paramObject, Rect paramRect)
    {
      AccessibilityNodeInfoCompatIcs.getBoundsInScreen(paramObject, paramRect);
    }
    
    public Object getChild(Object paramObject, int paramInt)
    {
      return AccessibilityNodeInfoCompatIcs.getChild(paramObject, paramInt);
    }
    
    public int getChildCount(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.getChildCount(paramObject);
    }
    
    public CharSequence getClassName(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.getClassName(paramObject);
    }
    
    public CharSequence getContentDescription(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.getContentDescription(paramObject);
    }
    
    public CharSequence getPackageName(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.getPackageName(paramObject);
    }
    
    public Object getParent(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.getParent(paramObject);
    }
    
    public CharSequence getText(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.getText(paramObject);
    }
    
    public int getWindowId(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.getWindowId(paramObject);
    }
    
    public boolean isCheckable(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.isCheckable(paramObject);
    }
    
    public boolean isChecked(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.isChecked(paramObject);
    }
    
    public boolean isClickable(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.isClickable(paramObject);
    }
    
    public boolean isEnabled(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.isEnabled(paramObject);
    }
    
    public boolean isFocusable(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.isFocusable(paramObject);
    }
    
    public boolean isFocused(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.isFocused(paramObject);
    }
    
    public boolean isLongClickable(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.isLongClickable(paramObject);
    }
    
    public boolean isPassword(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.isPassword(paramObject);
    }
    
    public boolean isScrollable(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.isScrollable(paramObject);
    }
    
    public boolean isSelected(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.isSelected(paramObject);
    }
    
    public Object obtain()
    {
      return AccessibilityNodeInfoCompatIcs.obtain();
    }
    
    public Object obtain(View paramView)
    {
      return AccessibilityNodeInfoCompatIcs.obtain(paramView);
    }
    
    public Object obtain(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.obtain(paramObject);
    }
    
    public boolean performAction(Object paramObject, int paramInt)
    {
      return AccessibilityNodeInfoCompatIcs.performAction(paramObject, paramInt);
    }
    
    public void recycle(Object paramObject)
    {
      AccessibilityNodeInfoCompatIcs.recycle(paramObject);
    }
    
    public void setBoundsInParent(Object paramObject, Rect paramRect)
    {
      AccessibilityNodeInfoCompatIcs.setBoundsInParent(paramObject, paramRect);
    }
    
    public void setBoundsInScreen(Object paramObject, Rect paramRect)
    {
      AccessibilityNodeInfoCompatIcs.setBoundsInScreen(paramObject, paramRect);
    }
    
    public void setCheckable(Object paramObject, boolean paramBoolean)
    {
      AccessibilityNodeInfoCompatIcs.setCheckable(paramObject, paramBoolean);
    }
    
    public void setChecked(Object paramObject, boolean paramBoolean)
    {
      AccessibilityNodeInfoCompatIcs.setChecked(paramObject, paramBoolean);
    }
    
    public void setClassName(Object paramObject, CharSequence paramCharSequence)
    {
      AccessibilityNodeInfoCompatIcs.setClassName(paramObject, paramCharSequence);
    }
    
    public void setClickable(Object paramObject, boolean paramBoolean)
    {
      AccessibilityNodeInfoCompatIcs.setClickable(paramObject, paramBoolean);
    }
    
    public void setContentDescription(Object paramObject, CharSequence paramCharSequence)
    {
      AccessibilityNodeInfoCompatIcs.setContentDescription(paramObject, paramCharSequence);
    }
    
    public void setEnabled(Object paramObject, boolean paramBoolean)
    {
      AccessibilityNodeInfoCompatIcs.setEnabled(paramObject, paramBoolean);
    }
    
    public void setFocusable(Object paramObject, boolean paramBoolean)
    {
      AccessibilityNodeInfoCompatIcs.setFocusable(paramObject, paramBoolean);
    }
    
    public void setFocused(Object paramObject, boolean paramBoolean)
    {
      AccessibilityNodeInfoCompatIcs.setFocused(paramObject, paramBoolean);
    }
    
    public void setLongClickable(Object paramObject, boolean paramBoolean)
    {
      AccessibilityNodeInfoCompatIcs.setLongClickable(paramObject, paramBoolean);
    }
    
    public void setPackageName(Object paramObject, CharSequence paramCharSequence)
    {
      AccessibilityNodeInfoCompatIcs.setPackageName(paramObject, paramCharSequence);
    }
    
    public void setParent(Object paramObject, View paramView)
    {
      AccessibilityNodeInfoCompatIcs.setParent(paramObject, paramView);
    }
    
    public void setPassword(Object paramObject, boolean paramBoolean)
    {
      AccessibilityNodeInfoCompatIcs.setPassword(paramObject, paramBoolean);
    }
    
    public void setScrollable(Object paramObject, boolean paramBoolean)
    {
      AccessibilityNodeInfoCompatIcs.setScrollable(paramObject, paramBoolean);
    }
    
    public void setSelected(Object paramObject, boolean paramBoolean)
    {
      AccessibilityNodeInfoCompatIcs.setSelected(paramObject, paramBoolean);
    }
    
    public void setSource(Object paramObject, View paramView)
    {
      AccessibilityNodeInfoCompatIcs.setSource(paramObject, paramView);
    }
    
    public void setText(Object paramObject, CharSequence paramCharSequence)
    {
      AccessibilityNodeInfoCompatIcs.setText(paramObject, paramCharSequence);
    }
  }
  
  static abstract interface AccessibilityNodeInfoImpl
  {
    public abstract void addAction(Object paramObject, int paramInt);
    
    public abstract void addChild(Object paramObject, View paramView);
    
    public abstract void addChild(Object paramObject, View paramView, int paramInt);
    
    public abstract List<Object> findAccessibilityNodeInfosByText(Object paramObject, String paramString);
    
    public abstract Object findFocus(Object paramObject, int paramInt);
    
    public abstract Object focusSearch(Object paramObject, int paramInt);
    
    public abstract int getActions(Object paramObject);
    
    public abstract void getBoundsInParent(Object paramObject, Rect paramRect);
    
    public abstract void getBoundsInScreen(Object paramObject, Rect paramRect);
    
    public abstract Object getChild(Object paramObject, int paramInt);
    
    public abstract int getChildCount(Object paramObject);
    
    public abstract CharSequence getClassName(Object paramObject);
    
    public abstract CharSequence getContentDescription(Object paramObject);
    
    public abstract int getMovementGranularities(Object paramObject);
    
    public abstract CharSequence getPackageName(Object paramObject);
    
    public abstract Object getParent(Object paramObject);
    
    public abstract CharSequence getText(Object paramObject);
    
    public abstract int getWindowId(Object paramObject);
    
    public abstract boolean isAccessibilityFocused(Object paramObject);
    
    public abstract boolean isCheckable(Object paramObject);
    
    public abstract boolean isChecked(Object paramObject);
    
    public abstract boolean isClickable(Object paramObject);
    
    public abstract boolean isEnabled(Object paramObject);
    
    public abstract boolean isFocusable(Object paramObject);
    
    public abstract boolean isFocused(Object paramObject);
    
    public abstract boolean isLongClickable(Object paramObject);
    
    public abstract boolean isPassword(Object paramObject);
    
    public abstract boolean isScrollable(Object paramObject);
    
    public abstract boolean isSelected(Object paramObject);
    
    public abstract boolean isVisibleToUser(Object paramObject);
    
    public abstract Object obtain();
    
    public abstract Object obtain(View paramView);
    
    public abstract Object obtain(View paramView, int paramInt);
    
    public abstract Object obtain(Object paramObject);
    
    public abstract boolean performAction(Object paramObject, int paramInt);
    
    public abstract boolean performAction(Object paramObject, int paramInt, Bundle paramBundle);
    
    public abstract void recycle(Object paramObject);
    
    public abstract void setAccessibilityFocused(Object paramObject, boolean paramBoolean);
    
    public abstract void setBoundsInParent(Object paramObject, Rect paramRect);
    
    public abstract void setBoundsInScreen(Object paramObject, Rect paramRect);
    
    public abstract void setCheckable(Object paramObject, boolean paramBoolean);
    
    public abstract void setChecked(Object paramObject, boolean paramBoolean);
    
    public abstract void setClassName(Object paramObject, CharSequence paramCharSequence);
    
    public abstract void setClickable(Object paramObject, boolean paramBoolean);
    
    public abstract void setContentDescription(Object paramObject, CharSequence paramCharSequence);
    
    public abstract void setEnabled(Object paramObject, boolean paramBoolean);
    
    public abstract void setFocusable(Object paramObject, boolean paramBoolean);
    
    public abstract void setFocused(Object paramObject, boolean paramBoolean);
    
    public abstract void setLongClickable(Object paramObject, boolean paramBoolean);
    
    public abstract void setMovementGranularities(Object paramObject, int paramInt);
    
    public abstract void setPackageName(Object paramObject, CharSequence paramCharSequence);
    
    public abstract void setParent(Object paramObject, View paramView);
    
    public abstract void setParent(Object paramObject, View paramView, int paramInt);
    
    public abstract void setPassword(Object paramObject, boolean paramBoolean);
    
    public abstract void setScrollable(Object paramObject, boolean paramBoolean);
    
    public abstract void setSelected(Object paramObject, boolean paramBoolean);
    
    public abstract void setSource(Object paramObject, View paramView);
    
    public abstract void setSource(Object paramObject, View paramView, int paramInt);
    
    public abstract void setText(Object paramObject, CharSequence paramCharSequence);
    
    public abstract void setVisibleToUser(Object paramObject, boolean paramBoolean);
  }
  
  static class AccessibilityNodeInfoJellybeanImpl
    extends AccessibilityNodeInfoCompat.AccessibilityNodeInfoIcsImpl
  {
    public void addChild(Object paramObject, View paramView, int paramInt)
    {
      AccessibilityNodeInfoCompatJellyBean.addChild(paramObject, paramView, paramInt);
    }
    
    public Object findFocus(Object paramObject, int paramInt)
    {
      return AccessibilityNodeInfoCompatJellyBean.findFocus(paramObject, paramInt);
    }
    
    public Object focusSearch(Object paramObject, int paramInt)
    {
      return AccessibilityNodeInfoCompatJellyBean.focusSearch(paramObject, paramInt);
    }
    
    public int getMovementGranularities(Object paramObject)
    {
      return AccessibilityNodeInfoCompatJellyBean.getMovementGranularities(paramObject);
    }
    
    public boolean isAccessibilityFocused(Object paramObject)
    {
      return AccessibilityNodeInfoCompatJellyBean.isAccessibilityFocused(paramObject);
    }
    
    public boolean isVisibleToUser(Object paramObject)
    {
      return AccessibilityNodeInfoCompatJellyBean.isVisibleToUser(paramObject);
    }
    
    public Object obtain(View paramView, int paramInt)
    {
      return AccessibilityNodeInfoCompatJellyBean.obtain(paramView, paramInt);
    }
    
    public boolean performAction(Object paramObject, int paramInt, Bundle paramBundle)
    {
      return AccessibilityNodeInfoCompatJellyBean.performAction(paramObject, paramInt, paramBundle);
    }
    
    public void setAccessibilityFocused(Object paramObject, boolean paramBoolean)
    {
      AccessibilityNodeInfoCompatJellyBean.setAccesibilityFocused(paramObject, paramBoolean);
    }
    
    public void setMovementGranularities(Object paramObject, int paramInt)
    {
      AccessibilityNodeInfoCompatJellyBean.setMovementGranularities(paramObject, paramInt);
    }
    
    public void setParent(Object paramObject, View paramView, int paramInt)
    {
      AccessibilityNodeInfoCompatJellyBean.setParent(paramObject, paramView, paramInt);
    }
    
    public void setSource(Object paramObject, View paramView, int paramInt)
    {
      AccessibilityNodeInfoCompatJellyBean.setSource(paramObject, paramView, paramInt);
    }
    
    public void setVisibleToUser(Object paramObject, boolean paramBoolean)
    {
      AccessibilityNodeInfoCompatJellyBean.setVisibleToUser(paramObject, paramBoolean);
    }
  }
  
  static class AccessibilityNodeInfoStubImpl
    implements AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
  {
    public void addAction(Object paramObject, int paramInt) {}
    
    public void addChild(Object paramObject, View paramView) {}
    
    public void addChild(Object paramObject, View paramView, int paramInt) {}
    
    public List<Object> findAccessibilityNodeInfosByText(Object paramObject, String paramString)
    {
      return Collections.emptyList();
    }
    
    public Object findFocus(Object paramObject, int paramInt)
    {
      return null;
    }
    
    public Object focusSearch(Object paramObject, int paramInt)
    {
      return null;
    }
    
    public int getActions(Object paramObject)
    {
      return 0;
    }
    
    public void getBoundsInParent(Object paramObject, Rect paramRect) {}
    
    public void getBoundsInScreen(Object paramObject, Rect paramRect) {}
    
    public Object getChild(Object paramObject, int paramInt)
    {
      return null;
    }
    
    public int getChildCount(Object paramObject)
    {
      return 0;
    }
    
    public CharSequence getClassName(Object paramObject)
    {
      return null;
    }
    
    public CharSequence getContentDescription(Object paramObject)
    {
      return null;
    }
    
    public int getMovementGranularities(Object paramObject)
    {
      return 0;
    }
    
    public CharSequence getPackageName(Object paramObject)
    {
      return null;
    }
    
    public Object getParent(Object paramObject)
    {
      return null;
    }
    
    public CharSequence getText(Object paramObject)
    {
      return null;
    }
    
    public int getWindowId(Object paramObject)
    {
      return 0;
    }
    
    public boolean isAccessibilityFocused(Object paramObject)
    {
      return false;
    }
    
    public boolean isCheckable(Object paramObject)
    {
      return false;
    }
    
    public boolean isChecked(Object paramObject)
    {
      return false;
    }
    
    public boolean isClickable(Object paramObject)
    {
      return false;
    }
    
    public boolean isEnabled(Object paramObject)
    {
      return false;
    }
    
    public boolean isFocusable(Object paramObject)
    {
      return false;
    }
    
    public boolean isFocused(Object paramObject)
    {
      return false;
    }
    
    public boolean isLongClickable(Object paramObject)
    {
      return false;
    }
    
    public boolean isPassword(Object paramObject)
    {
      return false;
    }
    
    public boolean isScrollable(Object paramObject)
    {
      return false;
    }
    
    public boolean isSelected(Object paramObject)
    {
      return false;
    }
    
    public boolean isVisibleToUser(Object paramObject)
    {
      return false;
    }
    
    public Object obtain()
    {
      return null;
    }
    
    public Object obtain(View paramView)
    {
      return null;
    }
    
    public Object obtain(View paramView, int paramInt)
    {
      return null;
    }
    
    public Object obtain(Object paramObject)
    {
      return null;
    }
    
    public boolean performAction(Object paramObject, int paramInt)
    {
      return false;
    }
    
    public boolean performAction(Object paramObject, int paramInt, Bundle paramBundle)
    {
      return false;
    }
    
    public void recycle(Object paramObject) {}
    
    public void setAccessibilityFocused(Object paramObject, boolean paramBoolean) {}
    
    public void setBoundsInParent(Object paramObject, Rect paramRect) {}
    
    public void setBoundsInScreen(Object paramObject, Rect paramRect) {}
    
    public void setCheckable(Object paramObject, boolean paramBoolean) {}
    
    public void setChecked(Object paramObject, boolean paramBoolean) {}
    
    public void setClassName(Object paramObject, CharSequence paramCharSequence) {}
    
    public void setClickable(Object paramObject, boolean paramBoolean) {}
    
    public void setContentDescription(Object paramObject, CharSequence paramCharSequence) {}
    
    public void setEnabled(Object paramObject, boolean paramBoolean) {}
    
    public void setFocusable(Object paramObject, boolean paramBoolean) {}
    
    public void setFocused(Object paramObject, boolean paramBoolean) {}
    
    public void setLongClickable(Object paramObject, boolean paramBoolean) {}
    
    public void setMovementGranularities(Object paramObject, int paramInt) {}
    
    public void setPackageName(Object paramObject, CharSequence paramCharSequence) {}
    
    public void setParent(Object paramObject, View paramView) {}
    
    public void setParent(Object paramObject, View paramView, int paramInt) {}
    
    public void setPassword(Object paramObject, boolean paramBoolean) {}
    
    public void setScrollable(Object paramObject, boolean paramBoolean) {}
    
    public void setSelected(Object paramObject, boolean paramBoolean) {}
    
    public void setSource(Object paramObject, View paramView) {}
    
    public void setSource(Object paramObject, View paramView, int paramInt) {}
    
    public void setText(Object paramObject, CharSequence paramCharSequence) {}
    
    public void setVisibleToUser(Object paramObject, boolean paramBoolean) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityNodeInfoCompat
 * JD-Core Version:    0.7.0.1
 */