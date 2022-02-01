package com.tencent.biz.pubaccount.readinjoy.view.widget.ticker;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import atau.a;
import nsz;
import nta;
import ntb;
import ntc;
import ntd;

public class TickerView
  extends View
{
  private static final Interpolator b = new AccelerateDecelerateInterpolator();
  private final nsz jdField_a_of_type_Nsz = new nsz(this.jdField_a_of_type_Nta);
  private final nta jdField_a_of_type_Nta = new nta(this.textPaint);
  private String anF;
  private final ValueAnimator animator = ValueAnimator.ofFloat(new float[] { 1.0F });
  private boolean auy;
  private int bcp;
  private int bcq;
  private Interpolator c;
  private int gravity;
  private String text;
  private int textColor;
  protected final Paint textPaint = new TextPaint(1);
  private float textSize;
  private int textStyle;
  private final Rect viewBounds = new Rect();
  private long yf;
  private long yg;
  
  public TickerView(Context paramContext)
  {
    super(paramContext);
    init(paramContext, null, 0, 0);
  }
  
  public TickerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext, paramAttributeSet, 0, 0);
  }
  
  public TickerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  static void a(Canvas paramCanvas, int paramInt, Rect paramRect, float paramFloat1, float paramFloat2)
  {
    int i = paramRect.width();
    int j = paramRect.height();
    float f1;
    if ((paramInt & 0x10) == 16) {
      f1 = paramRect.top;
    }
    for (float f2 = (j - paramFloat2) / 2.0F + f1;; f2 = 0.0F)
    {
      if ((paramInt & 0x1) == 1) {}
      for (f1 = paramRect.left + (i - paramFloat1) / 2.0F;; f1 = 0.0F)
      {
        if ((paramInt & 0x30) == 48) {
          f2 = 0.0F;
        }
        if ((paramInt & 0x50) == 80) {
          f2 = paramRect.top + (j - paramFloat2);
        }
        if ((paramInt & 0x800003) == 8388611) {
          f1 = 0.0F;
        }
        if ((paramInt & 0x800005) == 8388613) {
          f1 = paramRect.left + (i - paramFloat1);
        }
        paramCanvas.translate(f1, f2);
        paramCanvas.clipRect(0.0F, 0.0F, paramFloat1, paramFloat2);
        return;
      }
    }
  }
  
  private void aj(Canvas paramCanvas)
  {
    float f1 = this.jdField_a_of_type_Nsz.aq();
    float f2 = this.jdField_a_of_type_Nta.as();
    a(paramCanvas, this.gravity, this.viewBounds, f1, f2);
  }
  
  private void baW()
  {
    int j = 1;
    int i;
    if (this.bcp != qV())
    {
      i = 1;
      if (this.bcq == qW()) {
        break label44;
      }
    }
    for (;;)
    {
      if ((i != 0) || (j != 0)) {
        requestLayout();
      }
      return;
      i = 0;
      break;
      label44:
      j = 0;
    }
  }
  
  private void baX()
  {
    this.jdField_a_of_type_Nta.invalidate();
    baW();
    invalidate();
  }
  
  private int qV()
  {
    if (this.auy) {}
    for (float f = this.jdField_a_of_type_Nsz.aq();; f = this.jdField_a_of_type_Nsz.ar()) {
      return (int)f + getPaddingLeft() + getPaddingRight();
    }
  }
  
  private int qW()
  {
    return (int)this.jdField_a_of_type_Nta.as() + getPaddingTop() + getPaddingBottom();
  }
  
  public boolean Ga()
  {
    return this.jdField_a_of_type_Nsz.a() != null;
  }
  
  protected void init(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    a locala = new a(paramContext.getResources());
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.sw, paramInt1, paramInt2);
    paramInt1 = paramAttributeSet.getResourceId(0, -1);
    if (paramInt1 != -1)
    {
      paramContext = paramContext.obtainStyledAttributes(paramInt1, atau.a.sw);
      locala.e(paramContext);
      paramContext.recycle();
    }
    locala.e(paramAttributeSet);
    this.c = b;
    this.yg = paramAttributeSet.getInt(11, 350);
    this.auy = paramAttributeSet.getBoolean(10, false);
    this.gravity = locala.gravity;
    if (locala.shadowColor != 0) {
      this.textPaint.setShadowLayer(locala.shadowRadius, locala.shadowDx, locala.shadowDy, locala.shadowColor);
    }
    if (locala.textStyle != 0)
    {
      this.textStyle = locala.textStyle;
      setTypeface(this.textPaint.getTypeface());
    }
    setTextColor(locala.textColor);
    setTextSize(locala.textSize);
    switch (paramAttributeSet.getInt(12, 0))
    {
    default: 
      if (isInEditMode()) {
        setCharacterLists(new String[] { ntb.kL() });
      }
      break;
    }
    for (;;)
    {
      paramInt1 = paramAttributeSet.getInt(13, 0);
      switch (paramInt1)
      {
      default: 
        throw new IllegalArgumentException("Unsupported ticker_defaultPreferredScrollingDirection: " + paramInt1);
        setCharacterLists(new String[] { ntb.kL() });
        continue;
        setCharacterLists(new String[] { ntb.kM() });
      }
    }
    this.jdField_a_of_type_Nta.setPreferredScrollingDirection(0);
    if (Ga()) {
      setText(locala.text, false);
    }
    for (;;)
    {
      paramAttributeSet.recycle();
      this.animator.addUpdateListener(new ntc(this));
      this.animator.addListener(new ntd(this));
      return;
      this.jdField_a_of_type_Nta.setPreferredScrollingDirection(1);
      break;
      this.jdField_a_of_type_Nta.setPreferredScrollingDirection(2);
      break;
      this.anF = locala.text;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.save();
    aj(paramCanvas);
    paramCanvas.translate(0.0F, this.jdField_a_of_type_Nta.at());
    this.jdField_a_of_type_Nsz.draw(paramCanvas, this.textPaint);
    paramCanvas.restore();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.bcp = qV();
    this.bcq = qW();
    setMeasuredDimension(resolveSize(this.bcp, paramInt1), resolveSize(this.bcq, paramInt2));
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.viewBounds.set(getPaddingLeft(), getPaddingTop(), paramInt1 - getPaddingRight(), paramInt2 - getPaddingBottom());
  }
  
  public void setAnimateMeasurementChange(boolean paramBoolean)
  {
    this.auy = paramBoolean;
  }
  
  public void setAnimationDelay(long paramLong)
  {
    this.yf = paramLong;
  }
  
  public void setAnimationDuration(long paramLong)
  {
    this.yg = paramLong;
  }
  
  public void setAnimationInterpolator(Interpolator paramInterpolator)
  {
    this.c = paramInterpolator;
  }
  
  public void setCharacterLists(String... paramVarArgs)
  {
    this.jdField_a_of_type_Nsz.setCharacterLists(paramVarArgs);
    if (this.anF != null)
    {
      setText(this.anF, false);
      this.anF = null;
    }
  }
  
  public void setDigitalAnimWidthSpeedIncrement(boolean paramBoolean)
  {
    this.jdField_a_of_type_Nsz.setDigitalAnimWidthSpeedIncrement(paramBoolean);
  }
  
  public void setGravity(int paramInt)
  {
    if (this.gravity != paramInt)
    {
      this.gravity = paramInt;
      invalidate();
    }
  }
  
  public void setIgnoreWidthAnim(boolean paramBoolean)
  {
    this.jdField_a_of_type_Nsz.setIgnoreWidthAnim(paramBoolean);
  }
  
  public void setPreferredScrollingDirection(int paramInt)
  {
    this.jdField_a_of_type_Nta.setPreferredScrollingDirection(paramInt);
  }
  
  public void setText(String paramString)
  {
    if (!TextUtils.isEmpty(this.text)) {}
    for (boolean bool = true;; bool = false)
    {
      setText(paramString, bool);
      return;
    }
  }
  
  public void setText(String paramString, boolean paramBoolean)
  {
    if (TextUtils.equals(paramString, this.text)) {
      return;
    }
    this.text = paramString;
    if (paramString == null) {}
    for (char[] arrayOfChar = new char[0];; arrayOfChar = paramString.toCharArray())
    {
      this.jdField_a_of_type_Nsz.c(arrayOfChar);
      setContentDescription(paramString);
      if (!paramBoolean) {
        break;
      }
      if (this.animator.isRunning()) {
        this.animator.cancel();
      }
      this.animator.setStartDelay(this.yf);
      this.animator.setDuration(this.yg);
      this.animator.setInterpolator(this.c);
      this.animator.start();
      return;
    }
    this.jdField_a_of_type_Nsz.setAnimationProgress(1.0F);
    this.jdField_a_of_type_Nsz.onAnimationEnd();
    baW();
    invalidate();
  }
  
  public void setTextColor(int paramInt)
  {
    if (this.textColor != paramInt)
    {
      this.textColor = paramInt;
      this.textPaint.setColor(this.textColor);
      invalidate();
    }
  }
  
  public void setTextSize(float paramFloat)
  {
    if (this.textSize != paramFloat)
    {
      this.textSize = paramFloat;
      this.textPaint.setTextSize(paramFloat);
      baX();
    }
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    Typeface localTypeface;
    if (this.textStyle == 3) {
      localTypeface = Typeface.create(paramTypeface, 3);
    }
    for (;;)
    {
      this.textPaint.setTypeface(localTypeface);
      baX();
      return;
      if (this.textStyle == 1)
      {
        localTypeface = Typeface.create(paramTypeface, 1);
      }
      else
      {
        localTypeface = paramTypeface;
        if (this.textStyle == 2) {
          localTypeface = Typeface.create(paramTypeface, 2);
        }
      }
    }
  }
  
  class a
  {
    int gravity;
    int shadowColor;
    float shadowDx;
    float shadowDy;
    float shadowRadius;
    String text;
    int textColor = -16777216;
    float textSize;
    int textStyle;
    
    a(Resources paramResources)
    {
      this.textSize = TypedValue.applyDimension(2, 12.0F, paramResources.getDisplayMetrics());
      this.gravity = 8388611;
    }
    
    void e(TypedArray paramTypedArray)
    {
      this.gravity = paramTypedArray.getInt(4, this.gravity);
      this.shadowColor = paramTypedArray.getColor(6, this.shadowColor);
      this.shadowDx = paramTypedArray.getFloat(7, this.shadowDx);
      this.shadowDy = paramTypedArray.getFloat(8, this.shadowDy);
      this.shadowRadius = paramTypedArray.getFloat(9, this.shadowRadius);
      this.text = paramTypedArray.getString(5);
      this.textColor = paramTypedArray.getColor(3, this.textColor);
      this.textSize = paramTypedArray.getDimension(1, this.textSize);
      this.textStyle = paramTypedArray.getInt(2, this.textStyle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.ticker.TickerView
 * JD-Core Version:    0.7.0.1
 */