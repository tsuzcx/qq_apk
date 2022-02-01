package com.tencent.mobileqq.dating.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewDebug.ExportedProperty;
import android.widget.TextView;
import com.tencent.mobileqq.freshnews.BlockableEditTextView.a;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class DatingCommentTextView
  extends TextView
{
  private ClickableSpan b;
  private int mEnd = -1;
  private int mStart = -1;
  
  public DatingCommentTextView(Context paramContext)
  {
    super(paramContext);
    setFocusable(false);
  }
  
  public DatingCommentTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setFocusable(false);
  }
  
  @ViewDebug.ExportedProperty(category="focus")
  public boolean hasFocus()
  {
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onTouchEvent(paramMotionEvent);
    int i;
    ClickableSpan[] arrayOfClickableSpan;
    try
    {
      i = paramMotionEvent.getActionMasked();
      int j = (int)paramMotionEvent.getX();
      int k = (int)paramMotionEvent.getY();
      int m = getTotalPaddingLeft();
      int n = getTotalPaddingTop();
      int i1 = getScrollX();
      int i2 = getScrollY();
      paramMotionEvent = getLayout();
      j = paramMotionEvent.getOffsetForHorizontal(paramMotionEvent.getLineForVertical(k - n + i2), j - m + i1);
      paramMotionEvent = getText();
      if ((TextUtils.isEmpty(paramMotionEvent)) || (!(paramMotionEvent instanceof Spannable))) {
        break label455;
      }
      paramMotionEvent = (Spannable)getText();
      arrayOfClickableSpan = (ClickableSpan[])paramMotionEvent.getSpans(j, j, ClickableSpan.class);
      if ((arrayOfClickableSpan == null) || (arrayOfClickableSpan.length == 0)) {
        break label360;
      }
      if (i == 0)
      {
        this.b = arrayOfClickableSpan[0];
        this.mStart = paramMotionEvent.getSpanStart(arrayOfClickableSpan[0]);
        this.mEnd = paramMotionEvent.getSpanEnd(arrayOfClickableSpan[0]);
        if ((this.mStart < 0) || (this.mEnd < this.mStart)) {
          break label458;
        }
        if ((arrayOfClickableSpan[0] instanceof a)) {
          ((a)arrayOfClickableSpan[0]).setPressed(true);
        } else {
          paramMotionEvent.setSpan(new BackgroundColorSpan(Color.parseColor("#d5d5d5")), this.mStart, this.mEnd, 33);
        }
      }
    }
    catch (Exception paramMotionEvent)
    {
      if (QLog.isDevelopLevel()) {
        paramMotionEvent.printStackTrace();
      }
      return bool;
    }
    if ((i == 1) || (i == 3))
    {
      this.b = null;
      if ((this.mStart >= 0) && (this.mEnd >= this.mStart))
      {
        if ((arrayOfClickableSpan[0] instanceof a)) {
          ((a)arrayOfClickableSpan[0]).setPressed(false);
        }
        for (;;)
        {
          Selection.removeSelection(paramMotionEvent);
          this.mStart = -1;
          this.mEnd = -1;
          break;
          paramMotionEvent.setSpan(new BackgroundColorSpan(0), this.mStart, this.mEnd, 33);
        }
        label360:
        if ((this.mStart < 0) || (this.mEnd < this.mStart)) {
          break label460;
        }
        if ((this.b != null) && ((this.b instanceof a)))
        {
          ((a)this.b).setPressed(false);
          this.b = null;
        }
        for (;;)
        {
          Selection.removeSelection(paramMotionEvent);
          this.mStart = -1;
          this.mEnd = -1;
          break;
          paramMotionEvent.setSpan(new BackgroundColorSpan(0), this.mStart, this.mEnd, 33);
        }
        label455:
        return bool;
      }
    }
    label458:
    return true;
    label460:
    return false;
  }
  
  public static class a
    extends ClickableSpan
    implements BlockableEditTextView.a
  {
    private WeakReference<View.OnClickListener> aw;
    private ColorStateList p;
    private boolean pressed;
    private ColorStateList q;
    
    public a(View.OnClickListener paramOnClickListener, int paramInt)
    {
      this(paramOnClickListener, ColorStateList.valueOf(paramInt), null);
    }
    
    public a(View.OnClickListener paramOnClickListener, ColorStateList paramColorStateList)
    {
      this(paramOnClickListener, paramColorStateList, null);
    }
    
    public a(View.OnClickListener paramOnClickListener, ColorStateList paramColorStateList1, ColorStateList paramColorStateList2)
    {
      this.aw = new WeakReference(paramOnClickListener);
      this.p = paramColorStateList1;
      this.q = paramColorStateList2;
    }
    
    public void onClick(View paramView)
    {
      if (this.aw != null)
      {
        View.OnClickListener localOnClickListener = (View.OnClickListener)this.aw.get();
        if (localOnClickListener != null) {
          localOnClickListener.onClick(paramView);
        }
      }
    }
    
    public void setPressed(boolean paramBoolean)
    {
      this.pressed = paramBoolean;
    }
    
    public void updateDrawState(TextPaint paramTextPaint)
    {
      super.updateDrawState(paramTextPaint);
      paramTextPaint.setUnderlineText(false);
      if (this.p != null) {
        if (this.pressed)
        {
          i = this.p.getColorForState(new int[] { 16842919 }, 0);
          paramTextPaint.setColor(i);
          label46:
          if (this.q == null) {
            break label122;
          }
          if (!this.pressed) {
            break label107;
          }
        }
      }
      label107:
      for (int i = this.q.getColorForState(new int[] { 16842919 }, 0);; i = this.q.getColorForState(new int[0], 0))
      {
        paramTextPaint.bgColor = i;
        return;
        i = this.p.getColorForState(new int[0], 0);
        break;
        paramTextPaint.setColor(-16777216);
        break label46;
      }
      label122:
      paramTextPaint.bgColor = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.widget.DatingCommentTextView
 * JD-Core Version:    0.7.0.1
 */