package com.tencent.mobileqq.widget;

import aawc;
import aawe;
import adxp;
import adyk;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.DynamicDrawableSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView.BufferType;
import anot;
import aofk;
import aofk.a;
import aofk.c;
import auru;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import xov;

public class AnimationTextView
  extends PatchedTextView
  implements aawc, Handler.Callback
{
  private static final int MSG_INVALIDATE = 1;
  private static final String TAG = "AnimationTextView";
  public boolean doublleClicked;
  private boolean hasStroke;
  private Drawable[] hold;
  private Drawable[] hold2;
  public boolean isSingleClick = true;
  private boolean mBlockRelayout;
  private MotionEvent mCurrentDownEvent;
  private final Handler mHandler = new auru(Looper.myLooper(), this);
  private boolean mHasSelected;
  private int mHighlightBackgroundColor = -5250572;
  private Paint mHighlightPaint;
  private Path mHighlightPath;
  private boolean mIsHighlight;
  private boolean mIsSelectable = true;
  private MotionEvent mPreviousUpEvent;
  protected aawe mSelectDelegate;
  private int mSelectEnd;
  private int mSelectStart;
  private int mStrokeColor;
  private final int[] mTempLocation = new int[2];
  Runnable mTimerForSecondClick = new AnimationTextView.1(this);
  public a onDoubleClick;
  public b onSingleClick;
  public float touchL;
  public float touchT;
  
  public AnimationTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AnimationTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AnimationTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void checkDelegateBound()
  {
    if (this.mSelectDelegate == null) {
      throw new RuntimeException("Select delegate has not bound.");
    }
  }
  
  private void checkHighlightPaintAvailable()
  {
    if (this.mHighlightPaint == null)
    {
      this.mHighlightPaint = new Paint();
      this.mHighlightPaint.setAntiAlias(true);
      this.mHighlightPaint.setStyle(Paint.Style.FILL);
    }
  }
  
  private void checkHighlightPathAvailable()
  {
    if (this.mHighlightPath == null) {
      this.mHighlightPath = new Path();
    }
  }
  
  private void dealSmallEmojiClick()
  {
    int i = 0;
    float f1 = this.touchL;
    float f3 = xov.bTu;
    float f2 = this.touchT - xov.bTs;
    adxp localadxp = (adxp)getTag(2131364051);
    Object localObject = (ChatMessage)getTag(2131364546);
    if (localObject != null) {}
    for (boolean bool = ((ChatMessage)localObject).isSend();; bool = false)
    {
      if (bool) {}
      for (f1 = this.touchL - xov.bTv;; f1 -= f3)
      {
        localObject = getText();
        if ((localObject instanceof aofk))
        {
          localObject = (aofk)localObject;
          localObject = (aofk.a[])((aofk)localObject).getSpans(0, ((aofk)localObject).length(), aofk.a.class);
          int k;
          for (int j = 0; i < localObject.length; j = k)
          {
            aofk.c localc = localObject[i];
            k = j;
            if ((localc instanceof aofk.c))
            {
              localc = (aofk.c)localc;
              f3 = localc.Aa;
              float f4 = localc.Ab;
              float f5 = localc.Ac;
              float f6 = localc.Ad;
              k = j;
              if (f1 >= f3)
              {
                k = j;
                if (f1 <= f5)
                {
                  k = j;
                  if (f2 >= f4)
                  {
                    k = j;
                    if (f2 <= f6)
                    {
                      k = j;
                      if (j == 0) {
                        k = 1;
                      }
                    }
                  }
                }
              }
            }
            i += 1;
          }
          if (j != 0)
          {
            localObject = getBackground();
            if ((localObject == null) || (!(localObject instanceof adyk))) {
              break label277;
            }
            ((adyk)localObject).bSa = true;
          }
        }
        label277:
        while ((localObject == null) || (localadxp == null)) {
          return;
        }
        localObject = getResources();
        if (bool) {}
        for (i = 2130851000;; i = 2130850823)
        {
          localadxp.a(this, ((Resources)localObject).getDrawable(i));
          return;
        }
      }
    }
  }
  
  private int detectIndexByOffset(int paramInt1, int paramInt2)
  {
    Layout localLayout = getLayout();
    if (localLayout != null)
    {
      int i = localLayout.getOffsetForHorizontal(localLayout.getLineForVertical(paramInt2), paramInt1);
      paramInt2 = i;
      if ((int)localLayout.getPrimaryHorizontal(i) > paramInt1) {
        paramInt2 = localLayout.getOffsetToLeftOf(i);
      }
      return paramInt2;
    }
    return -1;
  }
  
  private int detectIndexByOffsetSpring(int paramInt1, int paramInt2)
  {
    int i = -1;
    checkDelegateBound();
    int j = this.mSelectDelegate.zo();
    if (j == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AnimationTextView", 2, "detectIndexByOffsetSpring backport to detectIndexByOffset");
      }
      i = detectIndexByOffset(paramInt1, paramInt2);
    }
    Layout localLayout;
    do
    {
      return i;
      localLayout = getLayout();
    } while (localLayout == null);
    int k;
    if (j == 1)
    {
      i = this.mSelectDelegate.startIndex();
      k = localLayout.getLineForVertical(paramInt2);
      j = i;
      if (isFirstIndexOnEndLine(i))
      {
        m = (int)localLayout.getPrimaryHorizontal(i - 1);
        n = (int)localLayout.getLineRight(k);
        j = i;
        if (paramInt1 > n - (n - m) / 2) {
          j = i - 1;
        }
      }
      j = localLayout.getLineForOffset(j);
      int m = localLayout.getLineTop(j);
      int n = localLayout.getLineBottom(j);
      int i1 = (n - m) / 2;
      if (k == j + 1)
      {
        i = j;
        if (paramInt2 - n < i1) {}
      }
      else
      {
        if ((k != j - 1) || (m - paramInt2 >= i1)) {
          break label291;
        }
      }
    }
    label291:
    for (i = j;; i = k)
    {
      paramInt2 = localLayout.getOffsetForHorizontal(i, paramInt1);
      if ((paramInt2 < contentLength() - 1) && (isFirstIndexOnEndLine(paramInt2 + 1)))
      {
        j = (int)localLayout.getPrimaryHorizontal(paramInt2);
        i = (int)localLayout.getLineRight(i);
        if (paramInt1 > i - (i - j) / 2)
        {
          return paramInt2 + 1;
          i = this.mSelectDelegate.endIndex();
          break;
        }
      }
      return paramInt2;
    }
  }
  
  private void invlidateSpan(Object paramObject)
  {
    Object localObject = getText();
    if ((localObject instanceof Spannable))
    {
      localObject = (Spannable)localObject;
      int j = ((Spannable)localObject).getSpanStart(paramObject);
      int k = ((Spannable)localObject).getSpanEnd(paramObject);
      SpanWatcher[] arrayOfSpanWatcher = (SpanWatcher[])((Spannable)localObject).getSpans(j, k, SpanWatcher.class);
      if ((arrayOfSpanWatcher != null) && (arrayOfSpanWatcher.length > 0))
      {
        int m = arrayOfSpanWatcher.length;
        int i = 0;
        for (;;)
        {
          if (i < m)
          {
            SpanWatcher localSpanWatcher = arrayOfSpanWatcher[i];
            try
            {
              localSpanWatcher.onSpanChanged((Spannable)localObject, paramObject, j, k, j, k);
              i += 1;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("AnimationTextView", 2, "Exception: " + localException.getMessage());
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static boolean isConsideredDoubleTap(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, MotionEvent paramMotionEvent3)
  {
    if (paramMotionEvent3.getEventTime() - paramMotionEvent2.getEventTime() > 200L) {}
    int i;
    int j;
    do
    {
      return false;
      i = (int)paramMotionEvent2.getX() - (int)paramMotionEvent3.getX();
      j = (int)paramMotionEvent2.getY() - (int)paramMotionEvent3.getY();
    } while (i * i + j * j >= 10000);
    return true;
  }
  
  private boolean isFirstIndexOnEndLine(int paramInt)
  {
    Layout localLayout = getLayout();
    if (localLayout == null) {
      throw new RuntimeException("Has no layout.");
    }
    return (paramInt > 0) && (localLayout.getLineForOffset(paramInt) == localLayout.getLineForOffset(paramInt - 1) + 1);
  }
  
  public void bind(@Nullable aawe paramaawe)
  {
    this.mSelectDelegate = paramaawe;
  }
  
  public void clearHighlightContent()
  {
    this.mIsHighlight = false;
    invalidate();
  }
  
  @Nullable
  public CharSequence content()
  {
    CharSequence localCharSequence = getText();
    if (localCharSequence != null) {
      return localCharSequence.toString();
    }
    return null;
  }
  
  public int contentLength()
  {
    return getText().length();
  }
  
  @Nullable
  public aawe delegate()
  {
    return this.mSelectDelegate;
  }
  
  public void doSelecting(ChatMessage paramChatMessage)
  {
    if (this.mSelectDelegate == null) {
      throw new IllegalStateException("Has no bound delegate!");
    }
    this.mSelectDelegate.O(paramChatMessage);
    anot.a(null, "dc00898", "", "", "0X800AE7A", "0X800AE7A", 1, 0, "", "", "", "");
  }
  
  public int endIndex()
  {
    return this.mSelectEnd;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    Object localObject1;
    do
    {
      do
      {
        return true;
        localObject1 = getText();
      } while (!(localObject1 instanceof Spannable));
      localObject1 = (Spannable)localObject1;
      localObject1 = (aofk.a[])((Spannable)localObject1).getSpans(0, ((Spannable)localObject1).length(), aofk.a.class);
    } while ((localObject1 == null) || (localObject1.length <= 0));
    this.mBlockRelayout = true;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      if (localObject2.getDrawable() == paramMessage.obj) {
        invlidateSpan(localObject2);
      }
      i += 1;
    }
    this.mBlockRelayout = false;
    return true;
  }
  
  public void hasSelected(boolean paramBoolean) {}
  
  public boolean hasSelected()
  {
    return this.mHasSelected;
  }
  
  public boolean hasTouchSelectableArea(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public int highlightBackgroundColor()
  {
    return this.mHighlightBackgroundColor;
  }
  
  public void highlightBackgroundColor(@ColorInt int paramInt)
  {
    this.mHighlightBackgroundColor = paramInt;
  }
  
  public void highlightContent()
  {
    if (!hasSelected()) {
      clearHighlightContent();
    }
    Layout localLayout = getLayout();
    if (localLayout == null) {
      return;
    }
    checkHighlightPaintAvailable();
    checkHighlightPathAvailable();
    this.mIsHighlight = true;
    this.mHighlightPath.reset();
    this.mHighlightPaint.setColor(this.mHighlightBackgroundColor);
    localLayout.getSelectionPath(this.mSelectStart, this.mSelectEnd, this.mHighlightPath);
    invalidate();
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    super.invalidateDrawable(paramDrawable);
    Message localMessage = this.mHandler.obtainMessage(1);
    localMessage.obj = paramDrawable;
    this.mHandler.removeMessages(1);
    this.mHandler.sendMessageDelayed(localMessage, 100L);
  }
  
  public void isSelectable(boolean paramBoolean)
  {
    this.mIsSelectable = paramBoolean;
  }
  
  public boolean isSelectable()
  {
    return this.mIsSelectable;
  }
  
  public void locationByIndex(int paramInt, @NonNull int[] paramArrayOfInt, boolean paramBoolean)
  {
    Layout localLayout = getLayout();
    if (localLayout == null)
    {
      paramArrayOfInt[0] = -1;
      paramArrayOfInt[1] = -1;
      return;
    }
    getLocationInWindow(paramArrayOfInt);
    paramArrayOfInt[0] = (paramArrayOfInt[0] + (int)localLayout.getPrimaryHorizontal(paramInt) + getPaddingLeft());
    int i = paramArrayOfInt[1];
    paramArrayOfInt[1] = (localLayout.getLineBottom(localLayout.getLineForOffset(paramInt)) + i + getPaddingTop());
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.mHandler.removeMessages(1);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.mIsHighlight)
    {
      paramCanvas.translate(getPaddingLeft(), getPaddingTop());
      paramCanvas.drawPath(this.mHighlightPath, this.mHighlightPaint);
      paramCanvas.translate(-getPaddingLeft(), -getPaddingTop());
    }
    if (this.hasStroke)
    {
      int i = getCurrentTextColor();
      getPaint().setStyle(Paint.Style.STROKE);
      getPaint().setStrokeWidth(3.0F);
      setTextColor(this.mStrokeColor);
      super.onDraw(paramCanvas);
      getPaint().setStyle(Paint.Style.FILL);
      setTextColor(i);
      super.onDraw(paramCanvas);
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.onDoubleClick != null) {
      if ((this.mPreviousUpEvent != null) && (paramMotionEvent.getAction() == 0))
      {
        this.touchL = paramMotionEvent.getX();
        this.touchT = paramMotionEvent.getY();
        dealSmallEmojiClick();
        this.mCurrentDownEvent = MotionEvent.obtain(paramMotionEvent);
        if ((this.mPreviousUpEvent != null) && (this.mCurrentDownEvent != null) && (isConsideredDoubleTap(this.mCurrentDownEvent, this.mPreviousUpEvent, paramMotionEvent)))
        {
          this.isSingleClick = false;
          this.mCurrentDownEvent = null;
          this.mPreviousUpEvent = null;
          if (this.onDoubleClick != null)
          {
            this.onDoubleClick.R(this);
            this.doublleClicked = true;
            if (QLog.isColorLevel()) {
              QLog.d("AnimationTextView", 2, "DoubleClick invoked");
            }
            return true;
          }
        }
      }
      else
      {
        if ((this.mPreviousUpEvent != null) || (paramMotionEvent.getAction() != 0)) {
          break label192;
        }
        this.isSingleClick = true;
        this.touchL = paramMotionEvent.getX();
        this.touchT = paramMotionEvent.getY();
        dealSmallEmojiClick();
        if (QLog.isColorLevel()) {
          QLog.d("AnimationTextView", 2, "reserve to initial status");
        }
      }
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      label192:
      if (paramMotionEvent.getAction() == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AnimationTextView", 2, "action up");
        }
        if (getLayout() == null) {
          return super.onTouchEvent(paramMotionEvent);
        }
        this.mPreviousUpEvent = MotionEvent.obtain(paramMotionEvent);
        if (this.doublleClicked)
        {
          this.doublleClicked = false;
          this.mPreviousUpEvent = null;
        }
        postDelayed(this.mTimerForSecondClick, 200L);
      }
    }
  }
  
  public void requestLayout()
  {
    if (!this.mBlockRelayout) {
      super.requestLayout();
    }
  }
  
  @Nullable
  public CharSequence selectContent()
  {
    CharSequence localCharSequence = content();
    if (localCharSequence != null) {
      return localCharSequence.subSequence(this.mSelectStart, this.mSelectEnd);
    }
    return null;
  }
  
  public void selectContent(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == -1) || (paramInt2 == -1))
    {
      this.mSelectStart = -1;
      this.mSelectEnd = -1;
      this.mHasSelected = false;
    }
    for (;;)
    {
      return;
      if (paramInt1 > paramInt2) {
        this.mSelectStart = paramInt2;
      }
      for (this.mSelectEnd = paramInt1; this.mSelectEnd - this.mSelectStart > 0; this.mSelectEnd = paramInt2)
      {
        this.mHasSelected = true;
        return;
        this.mSelectStart = paramInt1;
      }
    }
  }
  
  public void setStrokeColor(boolean paramBoolean, int paramInt)
  {
    this.hasStroke = paramBoolean;
    this.mStrokeColor = paramInt;
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    int j = 0;
    Object localObject = getText();
    super.setText(paramCharSequence, paramBufferType);
    this.hold = null;
    this.hold2 = null;
    if ((localObject != paramCharSequence) && ((getText() instanceof Spanned)))
    {
      paramCharSequence = (Spanned)getText();
      paramBufferType = (aofk.a[])paramCharSequence.getSpans(0, paramCharSequence.length(), aofk.a.class);
      localObject = new Drawable[paramBufferType.length];
      int i = 0;
      while (i < paramBufferType.length)
      {
        localObject[i] = paramBufferType[i].getDrawable();
        if (localObject[i] != null) {
          localObject[i].setCallback(this);
        }
        i += 1;
      }
      this.hold = ((Drawable[])localObject);
      paramCharSequence = (DynamicDrawableSpan[])paramCharSequence.getSpans(0, paramCharSequence.length(), DynamicDrawableSpan.class);
      paramBufferType = new Drawable[paramCharSequence.length];
      i = j;
      while (i < paramCharSequence.length)
      {
        paramBufferType[i] = paramCharSequence[i].getDrawable();
        if (paramBufferType[i] != null) {
          paramBufferType[i].setCallback(this);
        }
        i += 1;
      }
      this.hold2 = paramBufferType;
    }
  }
  
  public int startIndex()
  {
    return this.mSelectStart;
  }
  
  public int touchIndex(int paramInt1, int paramInt2)
  {
    getLocationInWindow(this.mTempLocation);
    paramInt1 = paramInt1 - this.mTempLocation[0] - getPaddingLeft();
    paramInt2 = paramInt2 - this.mTempLocation[1] - getPaddingTop();
    if (this.mSelectDelegate == null) {
      return detectIndexByOffset(paramInt1, paramInt2);
    }
    return detectIndexByOffsetSpring(paramInt1, paramInt2);
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return true;
  }
  
  @Nullable
  public View view()
  {
    return this;
  }
  
  public static abstract interface a
  {
    public abstract void R(View paramView);
  }
  
  public static abstract interface b
  {
    public abstract void fk(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AnimationTextView
 * JD-Core Version:    0.7.0.1
 */