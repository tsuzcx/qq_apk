package com.tencent.mobileqq.widget;

import android.content.Context;
import android.text.Layout;
import android.text.Spannable;
import android.util.AttributeSet;
import android.util.StateSet;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.TextView.BufferType;

public class ClickableColorSpanTextView
  extends TextView
{
  private a jdField_a_of_type_ComTencentMobileqqWidgetClickableColorSpanTextView$a;
  private StatableSpanTextView.StatableForegroundColorSpan jdField_a_of_type_ComTencentMobileqqWidgetStatableSpanTextView$StatableForegroundColorSpan;
  private StatableSpanTextView.StatableForegroundColorSpan[] jdField_a_of_type_ArrayOfComTencentMobileqqWidgetStatableSpanTextView$StatableForegroundColorSpan;
  
  public ClickableColorSpanTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ClickableColorSpanTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ClickableColorSpanTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private int a(int paramInt, float paramFloat)
  {
    paramFloat = c(paramFloat);
    return getLayout().getOffsetForHorizontal(paramInt, paramFloat);
  }
  
  private int b(float paramFloat)
  {
    paramFloat = Math.max(0.0F, paramFloat - getTotalPaddingTop());
    paramFloat = Math.min(getHeight() - getTotalPaddingBottom() - 1, paramFloat);
    float f = getScrollY();
    return getLayout().getLineForVertical((int)(paramFloat + f));
  }
  
  private float c(float paramFloat)
  {
    paramFloat = Math.max(0.0F, paramFloat - getTotalPaddingLeft());
    return Math.min(getWidth() - getTotalPaddingRight() - 1, paramFloat) + getScrollX();
  }
  
  public int getOffsetForPosition(float paramFloat1, float paramFloat2)
  {
    if (getLayout() == null) {
      return -1;
    }
    return a(b(paramFloat2), paramFloat1);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i;
    StatableSpanTextView.StatableForegroundColorSpan localStatableForegroundColorSpan;
    if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetStatableSpanTextView$StatableForegroundColorSpan != null) && ((getText() instanceof Spannable)))
    {
      int j = getOffsetForPosition(paramMotionEvent.getX(), paramMotionEvent.getY());
      StatableSpanTextView.StatableForegroundColorSpan[] arrayOfStatableForegroundColorSpan = this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetStatableSpanTextView$StatableForegroundColorSpan;
      int k = arrayOfStatableForegroundColorSpan.length;
      i = 0;
      if (i >= k) {
        break label247;
      }
      localStatableForegroundColorSpan = arrayOfStatableForegroundColorSpan[i];
      int m = ((Spannable)getText()).getSpanStart(localStatableForegroundColorSpan);
      int n = ((Spannable)getText()).getSpanEnd(localStatableForegroundColorSpan);
      if ((j <= m) || (j >= n)) {
        break label138;
      }
    }
    for (;;)
    {
      switch (paramMotionEvent.getAction())
      {
      }
      for (;;)
      {
        return super.onTouchEvent(paramMotionEvent);
        label138:
        i += 1;
        break;
        if (localStatableForegroundColorSpan != null)
        {
          localStatableForegroundColorSpan.o(StatableSpanTextView.StatableForegroundColorSpan.pi);
          this.jdField_a_of_type_ComTencentMobileqqWidgetStatableSpanTextView$StatableForegroundColorSpan = localStatableForegroundColorSpan;
          invalidate();
          return true;
          if ((this.jdField_a_of_type_ComTencentMobileqqWidgetStatableSpanTextView$StatableForegroundColorSpan == localStatableForegroundColorSpan) && (this.jdField_a_of_type_ComTencentMobileqqWidgetStatableSpanTextView$StatableForegroundColorSpan != null)) {
            return true;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetStatableSpanTextView$StatableForegroundColorSpan != null)
          {
            if ((this.jdField_a_of_type_ComTencentMobileqqWidgetStatableSpanTextView$StatableForegroundColorSpan == localStatableForegroundColorSpan) && (this.jdField_a_of_type_ComTencentMobileqqWidgetClickableColorSpanTextView$a != null)) {
              this.jdField_a_of_type_ComTencentMobileqqWidgetClickableColorSpanTextView$a.a(this, this.jdField_a_of_type_ComTencentMobileqqWidgetStatableSpanTextView$StatableForegroundColorSpan);
            }
            this.jdField_a_of_type_ComTencentMobileqqWidgetStatableSpanTextView$StatableForegroundColorSpan.o(StateSet.WILD_CARD);
            this.jdField_a_of_type_ComTencentMobileqqWidgetStatableSpanTextView$StatableForegroundColorSpan = null;
            invalidate();
          }
        }
      }
      label247:
      localStatableForegroundColorSpan = null;
    }
  }
  
  public void setSpanClickListener(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetClickableColorSpanTextView$a = parama;
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    if ((paramCharSequence != null) && ((paramCharSequence instanceof Spannable)))
    {
      paramBufferType = (Spannable)paramCharSequence;
      this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetStatableSpanTextView$StatableForegroundColorSpan = ((StatableSpanTextView.StatableForegroundColorSpan[])paramBufferType.getSpans(0, paramBufferType.length(), StatableSpanTextView.StatableForegroundColorSpan.class));
      paramBufferType = TextView.BufferType.SPANNABLE;
    }
    for (;;)
    {
      super.setText(paramCharSequence, paramBufferType);
      return;
      this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetStatableSpanTextView$StatableForegroundColorSpan = null;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(ClickableColorSpanTextView paramClickableColorSpanTextView, StatableSpanTextView.StatableForegroundColorSpan paramStatableForegroundColorSpan);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ClickableColorSpanTextView
 * JD-Core Version:    0.7.0.1
 */