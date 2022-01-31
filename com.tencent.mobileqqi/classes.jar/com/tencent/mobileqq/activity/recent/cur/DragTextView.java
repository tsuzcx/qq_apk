package com.tencent.mobileqq.activity.recent.cur;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import epc;

public class DragTextView
  extends TextView
  implements IDragView
{
  private final float jdField_a_of_type_Float = 12.0F * getResources().getDisplayMetrics().density;
  private IDragView.OnChangeModeListener jdField_a_of_type_ComTencentMobileqqActivityRecentCurIDragView$OnChangeModeListener;
  private boolean jdField_a_of_type_Boolean;
  private int f = -1;
  
  public DragTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public DragTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public DragTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public int a()
  {
    return this.f;
  }
  
  public IDragView.OnChangeModeListener a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurIDragView$OnChangeModeListener;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.f != -1) && (!this.jdField_a_of_type_Boolean) && (paramMotionEvent.getAction() == 0))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurIDragView$OnChangeModeListener != null)
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurIDragView$OnChangeModeListener.a(this, this.f);
        return true;
      }
      return super.onTouchEvent(paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setDragViewType(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setOnModeChangeListener(IDragView.OnChangeModeListener paramOnChangeModeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurIDragView$OnChangeModeListener = paramOnChangeModeListener;
    if (QLog.isColorLevel()) {
      QLog.d("Drag", 2, "setOnModeChangeListener:" + paramOnChangeModeListener);
    }
    paramOnChangeModeListener = (ViewGroup)getParent();
    Rect localRect = new Rect();
    getHitRect(localRect);
    localRect.top = ((int)(localRect.top - this.jdField_a_of_type_Float * 1.5D));
    localRect.bottom = ((int)(localRect.bottom + this.jdField_a_of_type_Float));
    localRect.left = ((int)(localRect.left - this.jdField_a_of_type_Float));
    localRect.right = ((int)(localRect.right + this.jdField_a_of_type_Float * 1.5D));
    paramOnChangeModeListener.setTouchDelegate(new epc(this, localRect, this));
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if ((this.jdField_a_of_type_Boolean) && (paramInt == 0)) {
      this.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.cur.DragTextView
 * JD-Core Version:    0.7.0.1
 */