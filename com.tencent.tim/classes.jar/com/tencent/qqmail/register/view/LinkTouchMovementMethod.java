package com.tencent.qqmail.register.view;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;

public class LinkTouchMovementMethod
  extends LinkMovementMethod
{
  private static LinkTouchMovementMethod sInstance;
  private TouchableSpan mPressedSpan;
  
  public static LinkTouchMovementMethod getInstance()
  {
    if (sInstance == null) {
      sInstance = new LinkTouchMovementMethod();
    }
    return sInstance;
  }
  
  private TouchableSpan getPressedSpan(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    int j = (int)paramMotionEvent.getX();
    int i = (int)paramMotionEvent.getY();
    int m = paramTextView.getTotalPaddingLeft();
    int k = paramTextView.getTotalPaddingTop();
    j = paramTextView.getScrollX() + (j - m);
    m = paramTextView.getScrollY();
    paramTextView = paramTextView.getLayout();
    k = paramTextView.getLineForVertical(m + (i - k));
    i = paramTextView.getOffsetForHorizontal(k, j);
    if (paramTextView.getLineWidth(k) < j) {
      i = -1;
    }
    paramTextView = (TouchableSpan[])paramSpannable.getSpans(i, i, TouchableSpan.class);
    if (paramTextView.length > 0) {
      return paramTextView[0];
    }
    return null;
  }
  
  public boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.mPressedSpan = getPressedSpan(paramTextView, paramSpannable, paramMotionEvent);
      if (this.mPressedSpan != null)
      {
        this.mPressedSpan.setPressed(true);
        Selection.setSelection(paramSpannable, paramSpannable.getSpanStart(this.mPressedSpan), paramSpannable.getSpanEnd(this.mPressedSpan));
      }
    }
    do
    {
      return true;
      if (paramMotionEvent.getAction() != 2) {
        break;
      }
      paramTextView = getPressedSpan(paramTextView, paramSpannable, paramMotionEvent);
    } while ((this.mPressedSpan == null) || (paramTextView == this.mPressedSpan));
    this.mPressedSpan.setPressed(false);
    this.mPressedSpan = null;
    Selection.removeSelection(paramSpannable);
    return true;
    if (this.mPressedSpan != null)
    {
      this.mPressedSpan.setPressed(false);
      super.onTouchEvent(paramTextView, paramSpannable, paramMotionEvent);
    }
    this.mPressedSpan = null;
    Selection.removeSelection(paramSpannable);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.register.view.LinkTouchMovementMethod
 * JD-Core Version:    0.7.0.1
 */