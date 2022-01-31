package com.etrump.mixlayout;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.text.Spannable;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.AnimationTextView.OnDoubleClick;
import com.tencent.qphone.base.util.QLog;

public class ETTextView
  extends AnimationTextView
{
  static final String jdField_a_of_type_JavaLangString = "ETTextView";
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private MotionEvent jdField_a_of_type_AndroidViewMotionEvent;
  private ETFont jdField_a_of_type_ComEtrumpMixlayoutETFont;
  private ETLayout jdField_a_of_type_ComEtrumpMixlayoutETLayout;
  private int jdField_b_of_type_Int;
  private MotionEvent jdField_b_of_type_AndroidViewMotionEvent;
  
  public ETTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ETTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ETTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComEtrumpMixlayoutETLayout != null) {
      return this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.a(paramInt1, paramInt2);
    }
    return -1;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComEtrumpMixlayoutETFont != null) && (this.jdField_a_of_type_ComEtrumpMixlayoutETFont.jdField_a_of_type_Int != 0);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (!a())
    {
      super.onDraw(paramCanvas);
      return;
    }
    if (this.jdField_a_of_type_ComEtrumpMixlayoutETFont != null)
    {
      this.jdField_a_of_type_ComEtrumpMixlayoutETFont.a(getTextColors().getDefaultColor());
      this.jdField_a_of_type_ComEtrumpMixlayoutETFont.a(getTextSize());
    }
    this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.a(paramCanvas, getPaddingLeft(), getPaddingTop());
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (!a())
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    try
    {
      int i = this.jdField_a_of_type_Int;
      int j = getPaddingLeft();
      int k = getPaddingRight();
      int m = getLinkTextColors().getDefaultColor();
      if (this.jdField_a_of_type_ComEtrumpMixlayoutETFont != null)
      {
        this.jdField_a_of_type_ComEtrumpMixlayoutETFont.a(getTextColors().getDefaultColor());
        this.jdField_a_of_type_ComEtrumpMixlayoutETFont.a(getTextSize());
      }
      if (this.jdField_a_of_type_ComEtrumpMixlayoutETLayout != null) {
        this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.b();
      }
      this.jdField_a_of_type_ComEtrumpMixlayoutETLayout = ETLayoutCache.a().a(i - (j + k), this.jdField_a_of_type_Long, getText(), this.jdField_a_of_type_ComEtrumpMixlayoutETFont, m);
      this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.a();
      this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.a(this.jdField_b_of_type_Int);
      Rect localRect = this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.a();
      if ((localRect.width() >= 2048) || (localRect.height() >= 2048)) {
        throw new Exception("large bitmap width=" + localRect.width() + ", height=" + localRect.height());
      }
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ETTextView", 2, "measure fail " + localThrowable.getMessage());
      }
      this.jdField_a_of_type_ComEtrumpMixlayoutETFont.jdField_a_of_type_Int = 0;
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    setMeasuredDimension(localThrowable.width() + getPaddingLeft() + getPaddingRight(), localThrowable.height() + getPaddingTop() + getPaddingBottom());
  }
  
  public boolean onPreDraw()
  {
    if (!a()) {
      return super.onPreDraw();
    }
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!a()) {
      return super.onTouchEvent(paramMotionEvent);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick != null) {
      if ((this.jdField_b_of_type_AndroidViewMotionEvent != null) && (paramMotionEvent.getAction() == 0))
      {
        this.jdField_a_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
        if ((this.jdField_b_of_type_AndroidViewMotionEvent != null) && (this.jdField_a_of_type_AndroidViewMotionEvent != null) && (a(this.jdField_a_of_type_AndroidViewMotionEvent, this.jdField_b_of_type_AndroidViewMotionEvent, paramMotionEvent)))
        {
          this.jdField_a_of_type_AndroidViewMotionEvent = null;
          this.jdField_b_of_type_AndroidViewMotionEvent = null;
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick.a(this);
            return true;
          }
        }
      }
      else if (paramMotionEvent.getAction() == 1)
      {
        int i = (int)paramMotionEvent.getX();
        int j = (int)paramMotionEvent.getY();
        int k = getPaddingLeft();
        int m = getPaddingTop();
        int n = getScrollX();
        int i1 = getScrollY();
        i = this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.a(i - k + n, j - m + i1) + 1;
        ClickableSpan[] arrayOfClickableSpan = (ClickableSpan[])((Spannable)getText()).getSpans(i, i, ClickableSpan.class);
        if (arrayOfClickableSpan.length != 0)
        {
          arrayOfClickableSpan[0].onClick(this);
          return true;
        }
        this.jdField_b_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setFont(int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_ComEtrumpMixlayoutETFont == null) {
      this.jdField_a_of_type_ComEtrumpMixlayoutETFont = new ETFont(paramInt, "", getTextSize());
    }
    for (;;)
    {
      this.jdField_a_of_type_Long = paramLong;
      return;
      this.jdField_a_of_type_ComEtrumpMixlayoutETFont.jdField_a_of_type_Int = paramInt;
    }
  }
  
  public void setLinkBackcolor(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComEtrumpMixlayoutETLayout != null) {
      this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.a(paramInt);
    }
  }
  
  public void setMaxWidth(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    super.setMaxWidth(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.etrump.mixlayout.ETTextView
 * JD-Core Version:    0.7.0.1
 */