package com.tencent.mobileqq.widget;

import acfp;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import android.widget.TextView;
import aqcl;
import ares;
import aret;
import atau.a;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.List;

public class ClearableEditText
  extends EditText
{
  a a;
  public b a;
  private boolean cZH;
  private boolean cZI;
  private float density;
  public Drawable fX;
  public boolean mDetached;
  private int mHeight;
  private int mStyle = 0;
  private int mWidth;
  
  public ClearableEditText(Context paramContext)
  {
    this(paramContext, null, 16842862);
  }
  
  public ClearableEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842862);
  }
  
  public ClearableEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    try
    {
      init(paramContext, paramAttributeSet);
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText$a = new a(this);
      ViewCompat.setAccessibilityDelegate(this, this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText$a);
      ViewCompat.setImportantForAccessibility(this, 1);
      return;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  private boolean aGr()
  {
    for (;;)
    {
      try
      {
        Object localObject = TextView.class.getDeclaredField("mSingleLine");
        ((Field)localObject).setAccessible(true);
        localObject = ((Field)localObject).get(this);
        if ((localObject instanceof Boolean))
        {
          bool = ((Boolean)localObject).booleanValue();
          return bool;
        }
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        localNoSuchFieldException.printStackTrace();
        return false;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localIllegalArgumentException.printStackTrace();
        return false;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
        return false;
      }
      boolean bool = false;
    }
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.density = paramContext.getResources().getDisplayMetrics().density;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.sS);
    try
    {
      this.fX = paramContext.getDrawable(0);
      this.mWidth = paramContext.getDimensionPixelSize(2, -1);
      this.mHeight = paramContext.getDimensionPixelSize(1, -1);
      paramContext.recycle();
      if (this.fX == null) {
        this.fX = getResources().getDrawable(2130839802);
      }
      if (this.fX != null)
      {
        if ((this.mWidth == -1) || (this.mHeight == -1))
        {
          this.mWidth = ((int)(this.density * 19.0F));
          this.mHeight = ((int)(this.density * 19.0F));
        }
        this.fX.setBounds(0, 0, this.mWidth, this.mHeight);
        setClearButtonVisible(false);
      }
      setOnTouchListener(new ares(this));
      addTextChangedListener(new aret(this));
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  public Drawable bb()
  {
    return this.fX;
  }
  
  protected boolean dispatchHoverEvent(MotionEvent paramMotionEvent)
  {
    if ((this.cZH) && (paramMotionEvent.getX() > getWidth() - getPaddingRight() - this.fX.getIntrinsicWidth())) {
      return this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText$a.dispatchHoverEvent(paramMotionEvent);
    }
    return super.dispatchHoverEvent(paramMotionEvent);
  }
  
  public void onDetachedFromWindow()
  {
    if ((QLog.isColorLevel()) && (AppSetting.isEnableAutoDumpLeak))
    {
      StringBuilder localStringBuilder = new StringBuilder(100);
      localStringBuilder.append("onDetachedFromWindow ");
      localStringBuilder.append(getContext().getClass().getSimpleName());
      localStringBuilder.append("@0x");
      localStringBuilder.append(Integer.toHexString(getContext().hashCode()));
      localStringBuilder.append(" ClearableEditText@0x");
      localStringBuilder.append(Integer.toHexString(hashCode()));
      QLog.d("ClearableEditText", 2, localStringBuilder.toString());
    }
    this.mDetached = true;
    super.onDetachedFromWindow();
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    if (!paramBoolean)
    {
      setCursorVisible(false);
      setClearButtonVisible(false);
    }
    do
    {
      return;
      setCursorVisible(true);
    } while (getText().toString().length() == 0);
    setClearButtonVisible(true);
  }
  
  public void setCanMultiLine(boolean paramBoolean)
  {
    this.cZI = paramBoolean;
  }
  
  public void setClearButtonStyle(int paramInt)
  {
    this.mStyle = paramInt;
    if (this.mStyle == 1) {
      setClearButtonVisible(false);
    }
    while (this.mStyle != 2) {
      return;
    }
    setClearButtonVisible(true);
  }
  
  public void setClearButtonVisible(boolean paramBoolean)
  {
    if (((paramBoolean) && (this.mStyle == 1)) || ((!paramBoolean) && (this.mStyle == 2))) {
      return;
    }
    if (paramBoolean) {}
    for (Drawable localDrawable = this.fX;; localDrawable = null)
    {
      setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], localDrawable, getCompoundDrawables()[3]);
      if (this.cZH != paramBoolean) {
        aqcl.ip(this);
      }
      this.cZH = paramBoolean;
      return;
    }
  }
  
  public void setCursorVisible(boolean paramBoolean)
  {
    if ((QLog.isColorLevel()) && (AppSetting.isEnableAutoDumpLeak) && (this.mDetached))
    {
      StringBuilder localStringBuilder = new StringBuilder(100);
      localStringBuilder.append("setCursorVisible=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" ");
      localStringBuilder.append(getContext().getClass().getSimpleName());
      localStringBuilder.append("@0x");
      localStringBuilder.append(Integer.toHexString(getContext().hashCode()));
      localStringBuilder.append(" ClearableEditText@0x");
      localStringBuilder.append(Integer.toHexString(hashCode()));
      QLog.d("ClearableEditText", 2, localStringBuilder.toString(), new Exception());
    }
    super.setCursorVisible(paramBoolean);
  }
  
  public void setTextClearedListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText$b = paramb;
  }
  
  class a
    extends ExploreByTouchHelper
  {
    public a(View paramView)
    {
      super();
    }
    
    public int getVirtualViewAt(float paramFloat1, float paramFloat2)
    {
      if ((ClearableEditText.c(ClearableEditText.this)) && (paramFloat1 > ClearableEditText.this.getWidth() - ClearableEditText.this.getPaddingRight() - ClearableEditText.this.fX.getIntrinsicWidth())) {
        return 0;
      }
      return -1;
    }
    
    public void getVisibleVirtualViews(List<Integer> paramList)
    {
      if (ClearableEditText.c(ClearableEditText.this)) {
        paramList.add(Integer.valueOf(0));
      }
    }
    
    public boolean onPerformActionForVirtualView(int paramInt1, int paramInt2, Bundle paramBundle)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ClearableEditTextHelper", 2, "onPerformActionForVirtualView virtualViewId:" + paramInt1);
      }
      return false;
    }
    
    public void onPopulateEventForVirtualView(int paramInt, AccessibilityEvent paramAccessibilityEvent)
    {
      if (paramInt == 0) {
        paramAccessibilityEvent.setContentDescription(acfp.m(2131703961));
      }
    }
    
    public void onPopulateNodeForVirtualView(int paramInt, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      if (paramInt == 0)
      {
        paramAccessibilityNodeInfoCompat.setContentDescription(acfp.m(2131703960));
        paramAccessibilityNodeInfoCompat.addAction(16);
        paramAccessibilityNodeInfoCompat.setBoundsInParent(new Rect(ClearableEditText.this.getWidth() - ClearableEditText.this.getPaddingRight() - ClearableEditText.this.fX.getIntrinsicWidth(), ClearableEditText.this.getPaddingTop(), ClearableEditText.this.getWidth() - ClearableEditText.this.getPaddingRight(), ClearableEditText.this.getHeight() - ClearableEditText.this.getPaddingBottom()));
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void bFw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ClearableEditText
 * JD-Core Version:    0.7.0.1
 */