package com.tencent.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityNodeInfo;
import aofy;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XEditTextEx
  extends XEditText
  implements View.OnTouchListener
{
  private List<WeakReference<View.OnClickListener>> Ln;
  private List<f> Lo = new ArrayList();
  private PerformClick jdField_a_of_type_ComTencentWidgetXEditTextEx$PerformClick;
  private a jdField_a_of_type_ComTencentWidgetXEditTextEx$a;
  private b jdField_a_of_type_ComTencentWidgetXEditTextEx$b;
  private c jdField_a_of_type_ComTencentWidgetXEditTextEx$c;
  private d jdField_a_of_type_ComTencentWidgetXEditTextEx$d;
  public e b;
  private int euX;
  private int mTouchSlop;
  public Object mUserData;
  
  public XEditTextEx(Context paramContext)
  {
    super(paramContext);
  }
  
  public XEditTextEx(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void O(View.OnClickListener paramOnClickListener)
  {
    if (this.Ln == null) {
      this.Ln = new ArrayList();
    }
    this.Ln.add(new WeakReference(paramOnClickListener));
  }
  
  public void a(@Nullable f paramf)
  {
    this.Lo.add(paramf);
  }
  
  public void b(@Nullable f paramf)
  {
    this.Lo.remove(paramf);
  }
  
  public boolean b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat1 >= -paramFloat3) && (paramFloat2 >= -paramFloat3) && (paramFloat1 < getRight() - getLeft() + paramFloat3) && (paramFloat2 < getBottom() - getTop() + paramFloat3);
  }
  
  public boolean dispatchKeyEventPreIme(KeyEvent paramKeyEvent)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx$a != null) && (this.jdField_a_of_type_ComTencentWidgetXEditTextEx$a.dispatchKeyEventPreIme(paramKeyEvent))) {
      return true;
    }
    return super.dispatchKeyEventPreIme(paramKeyEvent);
  }
  
  public boolean onCheckIsTextEditor()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx$b != null) {
      return this.jdField_a_of_type_ComTencentWidgetXEditTextEx$b.shouldShow();
    }
    return super.onCheckIsTextEditor();
  }
  
  @TargetApi(14)
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    String str = aofy.og(getText().toString());
    paramAccessibilityNodeInfo.setText(str);
    paramAccessibilityNodeInfo.setContentDescription(str);
  }
  
  public boolean onPrivateIMECommand(String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("XEditTextEx", 1, "onPrivateIMECommand(), action:" + paramString + " data:" + paramBundle);
    }
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx$c != null) {
      return this.jdField_a_of_type_ComTencentWidgetXEditTextEx$c.onPrivateIMECommand(paramString, paramBundle);
    }
    return super.onPrivateIMECommand(paramString, paramBundle);
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = this.Lo.iterator();
        if (!localIterator.hasNext()) {
          continue;
        }
        localf = (f)localIterator.next();
        switch (paramInt)
        {
        case 16908320: 
          if (!localf.RZ()) {
            continue;
          }
          return true;
        }
      }
      catch (Throwable localThrowable)
      {
        try
        {
          f localf;
          boolean bool = super.onTextContextMenuItem(paramInt);
          return bool;
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
        }
        QLog.d("XEditTextEx", 2, "onTextContextMenuItem has exception,", localException);
        return false;
      }
      if (localf.RY())
      {
        return true;
        bool = localf.Sa();
        if (bool) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!paramView.isClickable()) {}
    float f1;
    float f2;
    long l;
    do
    {
      return false;
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      int i = paramMotionEvent.getAction();
      l = System.currentTimeMillis();
      if (this.mTouchSlop == 0) {
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
      }
      if (this.euX == 0) {
        this.euX = ViewConfiguration.getLongPressTimeout();
      }
      switch (i)
      {
      default: 
        return false;
      case 0: 
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx$PerformClick = new PerformClick(paramView, l);
        return false;
      case 3: 
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx$PerformClick = null;
        return false;
      }
    } while (b(f1, f2, this.mTouchSlop));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx$PerformClick = null;
    return false;
    if ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx$PerformClick != null) && (Math.abs(l - this.jdField_a_of_type_ComTencentWidgetXEditTextEx$PerformClick.pd) < this.euX)) {
      post(this.jdField_a_of_type_ComTencentWidgetXEditTextEx$PerformClick);
    }
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx$PerformClick = null;
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx$d != null) {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx$d.onWindowFocusChanged(paramBoolean);
    }
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx$b == null) || (this.jdField_a_of_type_ComTencentWidgetXEditTextEx$b.shouldShow())) {
      super.scrollTo(paramInt1, paramInt2);
    }
  }
  
  public void setKeyEventPreImeListener(a parama)
  {
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx$a = parama;
  }
  
  public void setOnKeyboardShowListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx$b = paramb;
  }
  
  public void setOnPrivateIMECommandListener(c paramc)
  {
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx$c = paramc;
  }
  
  public void setOnWindowFocusChangedListener(d paramd)
  {
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx$d = paramd;
  }
  
  final class PerformClick
    implements Runnable
  {
    long pd;
    View view;
    
    PerformClick(View paramView, long paramLong)
    {
      this.view = paramView;
      this.pd = paramLong;
    }
    
    public void run()
    {
      if ((XEditTextEx.a(XEditTextEx.this) != null) && (XEditTextEx.a(XEditTextEx.this).size() > 0))
      {
        Iterator localIterator = XEditTextEx.a(XEditTextEx.this).iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (WeakReference)localIterator.next();
          if (localObject != null)
          {
            localObject = (View.OnClickListener)((WeakReference)localObject).get();
            if (localObject != null) {
              ((View.OnClickListener)localObject).onClick(this.view);
            }
          }
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean dispatchKeyEventPreIme(KeyEvent paramKeyEvent);
  }
  
  public static abstract interface b
  {
    public abstract boolean shouldShow();
  }
  
  public static abstract interface c
  {
    public abstract boolean onPrivateIMECommand(String paramString, Bundle paramBundle);
  }
  
  public static abstract interface d
  {
    public abstract void onWindowFocusChanged(boolean paramBoolean);
  }
  
  public static abstract interface e {}
  
  public static abstract interface f
  {
    public abstract boolean RY();
    
    public abstract boolean RZ();
    
    public abstract boolean Sa();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.XEditTextEx
 * JD-Core Version:    0.7.0.1
 */