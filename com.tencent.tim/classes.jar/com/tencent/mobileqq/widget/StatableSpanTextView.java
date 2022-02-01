package com.tencent.mobileqq.widget;

import amii;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.StateSet;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import arev;
import java.util.ArrayList;
import java.util.Arrays;

public class StatableSpanTextView
  extends TextView
{
  amii jdField_a_of_type_Amii;
  private ImageSpan[] jdField_a_of_type_ArrayOfAndroidTextStyleImageSpan;
  private StatableForegroundColorSpan[] jdField_a_of_type_ArrayOfComTencentMobileqqWidgetStatableSpanTextView$StatableForegroundColorSpan;
  private long lastClickTime;
  
  public StatableSpanTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public StatableSpanTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public StatableSpanTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void drawableStateChanged()
  {
    int j = 0;
    super.drawableStateChanged();
    int[] arrayOfInt;
    Object localObject;
    int k;
    int i;
    if (this.jdField_a_of_type_ArrayOfAndroidTextStyleImageSpan != null)
    {
      arrayOfInt = getDrawableState();
      localObject = this.jdField_a_of_type_ArrayOfAndroidTextStyleImageSpan;
      k = localObject.length;
      i = 0;
      while (i < k)
      {
        Drawable localDrawable = localObject[i].getDrawable();
        if (localDrawable.isStateful()) {
          localDrawable.setState(arrayOfInt);
        }
        i += 1;
      }
    }
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetStatableSpanTextView$StatableForegroundColorSpan != null)
    {
      arrayOfInt = getDrawableState();
      localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetStatableSpanTextView$StatableForegroundColorSpan;
      k = localObject.length;
      i = j;
      while (i < k)
      {
        localObject[i].o(arrayOfInt);
        i += 1;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject2 = getMovementMethod();
    if (((localObject2 != null) || (onCheckIsTextEditor())) && (isEnabled()) && ((getText() instanceof Spannable)) && (getLayout() != null))
    {
      Object localObject1 = (Spannable)getText();
      if (localObject2 != null)
      {
        int i = paramMotionEvent.getAction();
        if ((i == 1) || (i == 0))
        {
          if (i == 0) {
            this.lastClickTime = System.currentTimeMillis();
          }
          int j = (int)paramMotionEvent.getX();
          int k = (int)paramMotionEvent.getY();
          int m = getTotalPaddingLeft();
          int n = getTotalPaddingTop();
          int i1 = getScrollX();
          int i2 = getScrollY();
          localObject2 = getLayout();
          j = ((Layout)localObject2).getOffsetForHorizontal(((Layout)localObject2).getLineForVertical(k - n + i2), j - m + i1);
          localObject1 = (amii[])((Spannable)localObject1).getSpans(j, j, amii.class);
          if (localObject1.length != 0)
          {
            localObject1 = localObject1[0];
            if (i == 1)
            {
              ((amii)localObject1).M(this, false);
              if (System.currentTimeMillis() - this.lastClickTime < 500L) {
                ((amii)localObject1).onClick(this);
              }
            }
            for (;;)
            {
              return true;
              return super.onTouchEvent(paramMotionEvent);
              if (i == 0)
              {
                ((amii)localObject1).M(this, true);
                this.jdField_a_of_type_Amii = ((amii)localObject1);
              }
              else
              {
                ((amii)localObject1).M(this, false);
              }
            }
          }
          if (this.jdField_a_of_type_Amii != null) {
            this.jdField_a_of_type_Amii.M(this, false);
          }
        }
      }
    }
    return false;
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    Spannable localSpannable;
    if ((paramCharSequence != null) && ((paramCharSequence instanceof Spannable)))
    {
      localSpannable = (Spannable)paramCharSequence;
      this.jdField_a_of_type_ArrayOfAndroidTextStyleImageSpan = ((ImageSpan[])localSpannable.getSpans(0, localSpannable.length(), ImageSpan.class));
      if (this.jdField_a_of_type_ArrayOfAndroidTextStyleImageSpan != null)
      {
        ArrayList localArrayList = new ArrayList();
        ImageSpan[] arrayOfImageSpan = this.jdField_a_of_type_ArrayOfAndroidTextStyleImageSpan;
        int j = arrayOfImageSpan.length;
        int i = 0;
        while (i < j)
        {
          ImageSpan localImageSpan = arrayOfImageSpan[i];
          if (!(localImageSpan instanceof arev)) {
            localArrayList.add(localImageSpan);
          }
          i += 1;
        }
        if (localArrayList.size() <= 0) {
          break label172;
        }
        this.jdField_a_of_type_ArrayOfAndroidTextStyleImageSpan = new ImageSpan[localArrayList.size()];
        this.jdField_a_of_type_ArrayOfAndroidTextStyleImageSpan = ((ImageSpan[])localArrayList.toArray(this.jdField_a_of_type_ArrayOfAndroidTextStyleImageSpan));
      }
    }
    for (this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetStatableSpanTextView$StatableForegroundColorSpan = ((StatableForegroundColorSpan[])localSpannable.getSpans(0, localSpannable.length(), StatableForegroundColorSpan.class));; this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetStatableSpanTextView$StatableForegroundColorSpan = null)
    {
      super.setText(paramCharSequence, paramBufferType);
      return;
      label172:
      this.jdField_a_of_type_ArrayOfAndroidTextStyleImageSpan = null;
      break;
      this.jdField_a_of_type_ArrayOfAndroidTextStyleImageSpan = null;
    }
  }
  
  public static class StatableForegroundColorSpan
    extends ForegroundColorSpan
  {
    public static final int[] pi = { 16842919 };
    ArrayList<int[]> Dq;
    private int eio;
    ArrayList<Integer> mColors;
    private int[] pp;
    
    public StatableForegroundColorSpan(int paramInt)
    {
      super();
      this.eio = paramInt;
    }
    
    public StatableForegroundColorSpan(int paramInt1, int paramInt2)
    {
      this(paramInt1);
      a(pi, Integer.valueOf(paramInt2));
    }
    
    private int i(int[] paramArrayOfInt)
    {
      ArrayList localArrayList = this.Dq;
      if (localArrayList == null) {
        return super.getForegroundColor();
      }
      int j = this.mColors.size();
      int i = 0;
      while (i < j)
      {
        if (StateSet.stateSetMatches((int[])localArrayList.get(i), paramArrayOfInt)) {
          return ((Integer)this.mColors.get(i)).intValue();
        }
        i += 1;
      }
      return super.getForegroundColor();
    }
    
    public int a(int[] paramArrayOfInt, Integer paramInteger)
    {
      if (this.Dq == null)
      {
        this.Dq = new ArrayList();
        this.mColors = new ArrayList();
      }
      this.Dq.add(paramArrayOfInt);
      this.mColors.add(paramInteger);
      return this.mColors.size();
    }
    
    public int getForegroundColor()
    {
      return this.eio;
    }
    
    public void o(int[] paramArrayOfInt)
    {
      if (!Arrays.equals(this.pp, paramArrayOfInt))
      {
        this.pp = paramArrayOfInt;
        this.eio = i(paramArrayOfInt);
      }
    }
    
    public void updateDrawState(TextPaint paramTextPaint)
    {
      paramTextPaint.setColor(this.eio);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.StatableSpanTextView
 * JD-Core Version:    0.7.0.1
 */