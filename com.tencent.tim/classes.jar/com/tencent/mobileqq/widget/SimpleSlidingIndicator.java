package com.tencent.mobileqq.widget;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import argc;
import arix;
import ariy;
import ariz;
import arja;
import atau.a;
import com.tencent.common.config.AppSetting;

@TargetApi(14)
public class SimpleSlidingIndicator
  extends HorizontalScrollView
{
  private static final int[] ATTRS = { 16842901, 16842904 };
  private int LB;
  private argc jdField_a_of_type_Argc;
  private a jdField_a_of_type_ComTencentMobileqqWidgetSimpleSlidingIndicator$a;
  private Paint aI;
  private int aYR;
  private int aYS = -16777216;
  private int aYT = -7829368;
  private int aYU = -16776961;
  private int aYV;
  private int aii = 12;
  private int aim = 4;
  private String[] bD;
  private LinearLayout.LayoutParams c;
  private int ccl = 52;
  private int currentPosition;
  private int[] dw;
  private int eih = 1;
  private int eii = -3355444;
  private LinearLayout ek;
  private int tabPadding = 18;
  
  public SimpleSlidingIndicator(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SimpleSlidingIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SimpleSlidingIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setFillViewport(true);
    setWillNotDraw(false);
    Object localObject = getResources().getDisplayMetrics();
    this.ccl = ((int)TypedValue.applyDimension(1, this.ccl, (DisplayMetrics)localObject));
    this.aim = ((int)TypedValue.applyDimension(1, this.aim, (DisplayMetrics)localObject));
    this.eih = ((int)TypedValue.applyDimension(1, this.eih, (DisplayMetrics)localObject));
    this.tabPadding = ((int)TypedValue.applyDimension(1, this.tabPadding, (DisplayMetrics)localObject));
    this.aii = ((int)TypedValue.applyDimension(2, this.aii, (DisplayMetrics)localObject));
    localObject = paramContext.obtainStyledAttributes(paramAttributeSet, ATTRS);
    this.aii = ((TypedArray)localObject).getDimensionPixelSize(0, this.aii);
    ((TypedArray)localObject).recycle();
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.sx);
    this.aYU = paramAttributeSet.getColor(1, this.aYU);
    this.eii = paramAttributeSet.getColor(5, this.eii);
    this.aYS = paramAttributeSet.getColor(0, this.aYS);
    this.aYT = paramAttributeSet.getColor(4, this.aYT);
    this.aim = paramAttributeSet.getDimensionPixelSize(2, this.aim);
    this.eih = paramAttributeSet.getDimensionPixelSize(6, this.eih);
    this.tabPadding = paramAttributeSet.getDimensionPixelSize(9, this.tabPadding);
    paramAttributeSet.recycle();
    initPaint();
    ck(paramContext);
    if (Build.VERSION.SDK_INT >= 14) {
      setAccessibilityDelegate(new arix(this));
    }
  }
  
  private void ET(int paramInt)
  {
    if (this.aYR == 0) {}
    do
    {
      View localView;
      do
      {
        return;
        setAccessibilityMsg();
        localView = this.ek.getChildAt(paramInt);
      } while (localView == null);
      paramInt = getScrollX();
      int i = this.tabPadding * 3;
      int j = localView.getRight() - paramInt + i - getWidth();
      if (j > 0)
      {
        smoothScrollBy(j, 0);
        return;
      }
      paramInt = localView.getLeft() - paramInt - i;
    } while (paramInt >= 0);
    smoothScrollBy(paramInt, 0);
  }
  
  private void aXq()
  {
    if (this.LB != this.currentPosition)
    {
      Object localObject = this.ek.getChildAt(this.LB);
      View localView = this.ek.getChildAt(this.currentPosition);
      if ((localObject != null) && (localView != null))
      {
        localObject = ValueAnimator.ofInt(new int[] { ((View)localObject).getLeft(), localView.getLeft() });
        ((ValueAnimator)localObject).setDuration(200L);
        ((ValueAnimator)localObject).addUpdateListener(new ariz(this));
        ((ValueAnimator)localObject).start();
      }
      return;
    }
    this.aYV = this.ek.getChildAt(this.currentPosition).getLeft();
    invalidate();
  }
  
  private void ck(Context paramContext)
  {
    this.c = new LinearLayout.LayoutParams(-2, -1);
    this.ek = new LinearLayout(paramContext);
    this.ek.setOrientation(0);
    this.ek.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    addView(this.ek);
  }
  
  private void cnp()
  {
    int i = 0;
    while (i < this.aYR)
    {
      View localView = this.ek.getChildAt(i);
      if ((localView instanceof TextView)) {
        ((TextView)localView).setTextSize(0, this.aii);
      }
      i += 1;
    }
  }
  
  private void initPaint()
  {
    this.aI = new Paint();
    this.aI.setAntiAlias(true);
    this.aI.setStyle(Paint.Style.FILL);
    this.aI.setTextSize(this.aii);
  }
  
  private void j(int paramInt1, String paramString, int paramInt2)
  {
    TextView localTextView = new TextView(getContext());
    localTextView.setText(paramString);
    localTextView.setGravity(17);
    localTextView.setSingleLine();
    localTextView.setId(paramInt2);
    k(paramInt1, localTextView);
  }
  
  private void k(int paramInt, View paramView)
  {
    paramView.setFocusable(true);
    paramView.setOnClickListener(new ariy(this, paramInt));
    paramView.setPadding(this.tabPadding, 0, this.tabPadding, 0);
    this.ek.addView(paramView, paramInt, this.c);
  }
  
  private void tB(int paramInt)
  {
    int j = this.ek.getChildCount();
    int i = 0;
    if (i < j)
    {
      TextView localTextView = (TextView)this.ek.getChildAt(i);
      if (i == paramInt) {
        localTextView.setTextColor(this.aYS);
      }
      for (;;)
      {
        i += 1;
        break;
        localTextView.setTextColor(this.aYT);
      }
    }
  }
  
  public void h(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.currentPosition != paramInt) && (this.currentPosition >= 0))
    {
      this.LB = this.currentPosition;
      this.currentPosition = paramInt;
      tB(paramInt);
      ET(this.currentPosition);
      if (!paramBoolean1) {
        break label69;
      }
      aXq();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetSimpleSlidingIndicator$a != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetSimpleSlidingIndicator$a.d(paramInt, paramBoolean2);
      }
      return;
      label69:
      this.aYV = this.ek.getChildAt(this.currentPosition).getLeft();
      invalidate();
    }
  }
  
  public void notifyDataSetChanged()
  {
    this.ek.removeAllViews();
    this.aYR = this.bD.length;
    int i = 0;
    while (i < this.aYR)
    {
      j(i, this.bD[i], this.dw[i]);
      i += 1;
    }
    cnp();
    getViewTreeObserver().addOnGlobalLayoutListener(new arja(this));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((isInEditMode()) || (this.aYR == 0)) {
      return;
    }
    int i = getHeight();
    this.aI.setColor(this.aYU);
    View localView = this.ek.getChildAt(this.currentPosition);
    float f1 = this.aYV + this.tabPadding - 10;
    float f2 = i - this.aim;
    int j = this.aYV;
    paramCanvas.drawRect(f1, f2, localView.getWidth() + j - this.tabPadding + 10, i, this.aI);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      if (this.jdField_a_of_type_Argc != null)
      {
        this.jdField_a_of_type_Argc.Bg(true);
        continue;
        if (this.jdField_a_of_type_Argc != null) {
          this.jdField_a_of_type_Argc.Bg(false);
        }
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      if (this.jdField_a_of_type_Argc != null) {
        this.jdField_a_of_type_Argc.Bg(false);
      }
    }
  }
  
  public void setAccessibilityMsg()
  {
    if (AppSetting.enableTalkBack)
    {
      int i = 0;
      while (i < this.aYR)
      {
        View localView = this.ek.getChildAt(i);
        if (localView != null)
        {
          String str2 = this.bD[i] + " 按钮";
          String str1 = str2;
          if (i == this.currentPosition) {
            str1 = str2 + "，已选中";
          }
          localView.setContentDescription(str1);
        }
        i += 1;
      }
    }
  }
  
  public void setCurrentPosition(int paramInt, boolean paramBoolean)
  {
    h(paramInt, paramBoolean, false);
  }
  
  public void setInterceptListener(argc paramargc)
  {
    this.jdField_a_of_type_Argc = paramargc;
  }
  
  public void setOnTabListener(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetSimpleSlidingIndicator$a = parama;
  }
  
  public void setOverScrollMode(int paramInt)
  {
    super.setOverScrollMode(2);
  }
  
  public void setTabData(String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0) || (paramArrayOfInt == null) || (paramArrayOfInt.length != paramArrayOfString.length)) {
      return;
    }
    this.bD = ((String[])paramArrayOfString.clone());
    this.dw = ((int[])paramArrayOfInt.clone());
    notifyDataSetChanged();
  }
  
  public static abstract interface a
  {
    public abstract int d(int paramInt, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SimpleSlidingIndicator
 * JD-Core Version:    0.7.0.1
 */