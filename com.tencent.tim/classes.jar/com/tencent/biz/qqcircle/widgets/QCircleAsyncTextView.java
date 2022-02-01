package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.biz.subscribe.widget.textview.AsyncRichTextView;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import pdh;
import pen;

public class QCircleAsyncTextView
  extends AsyncRichTextView
{
  private boolean azF;
  private long zN;
  
  public QCircleAsyncTextView(Context paramContext)
  {
    super(paramContext, null);
  }
  
  public QCircleAsyncTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QCircleAsyncTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2, a parama)
  {
    if ((TextUtils.isEmpty(paramSpannableStringBuilder)) || (paramInt2 < paramInt1) || (paramSpannableStringBuilder.length() < paramInt2)) {
      return;
    }
    parama = new pen(this, parama);
    setHighlightColor(getResources().getColor(2131167595));
    paramSpannableStringBuilder.setSpan(parama, paramInt1, paramInt2, 33);
  }
  
  public void a(SpannableStringBuilder paramSpannableStringBuilder, int paramInt, Drawable paramDrawable)
  {
    if ((TextUtils.isEmpty(paramSpannableStringBuilder)) || (paramInt < 0) || (paramInt > paramSpannableStringBuilder.length()) || (paramDrawable == null)) {
      return;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramSpannableStringBuilder);
    paramSpannableStringBuilder.clear();
    paramSpannableStringBuilder.append(localSpannableStringBuilder.subSequence(0, paramInt)).append(" ");
    if (paramInt < localSpannableStringBuilder.length()) {
      paramSpannableStringBuilder.append(localSpannableStringBuilder.subSequence(paramInt, localSpannableStringBuilder.length()));
    }
    paramSpannableStringBuilder.setSpan(new VerticalCenterImageSpan(paramDrawable), paramInt, paramInt + 1, 33);
  }
  
  public MovementMethod getDefaultMovementMethod()
  {
    return pdh.a();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.azF = false;
    if (paramMotionEvent.getAction() == 0) {
      this.zN = System.currentTimeMillis();
    }
    while ((paramMotionEvent.getAction() != 1) || (System.currentTimeMillis() - this.zN <= 500L)) {
      return super.onTouchEvent(paramMotionEvent);
    }
    return true;
  }
  
  public boolean performClick()
  {
    if (this.azF) {
      return true;
    }
    return super.performClick();
  }
  
  public static abstract interface a
  {
    public abstract void onClick();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView
 * JD-Core Version:    0.7.0.1
 */