package com.tencent.qqmail.utilities.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Shader.TileMode;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.androidqqmail.R.styleable;

public class DividerTextView
  extends TextView
{
  public static final int LINE_STYLE_DASH = 1;
  public static final int LINE_STYLE_DIAMOND = 3;
  public static final int LINE_STYLE_SOLID = 2;
  int dividerHeight;
  int dividerWidth;
  LinearGradient linearGradientShader;
  private Context mContext;
  private Path mLinePath;
  private int mLineStyle;
  private Paint mPaint;
  private int mTextPadding;
  int paintLineColor;
  
  public DividerTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DividerTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DividerTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    initAttributeSet(paramAttributeSet);
  }
  
  private void drawLine(Canvas paramCanvas)
  {
    int j = getWidth();
    int i = getHeight() / 2;
    float f = getPaint().measureText(getText().toString());
    int m = (int)(j - f) / 2;
    j = m - this.mTextPadding;
    int k = j - this.dividerWidth;
    m = (int)(m + f + this.mTextPadding);
    int n = m + this.dividerWidth;
    this.mLinePath.reset();
    this.mLinePath.moveTo(k, i);
    this.mLinePath.lineTo(j, i);
    this.mLinePath.close();
    int i1 = this.paintLineColor;
    this.linearGradientShader = new LinearGradient(k, i, j, i, 0, i1, Shader.TileMode.CLAMP);
    this.mPaint.setShader(this.linearGradientShader);
    paramCanvas.drawPath(this.mLinePath, this.mPaint);
    this.mLinePath.reset();
    this.mLinePath.moveTo(m, i);
    this.mLinePath.lineTo(n, i);
    this.mLinePath.close();
    this.linearGradientShader = new LinearGradient(m, i, n, i, i1, 0, Shader.TileMode.CLAMP);
    this.mPaint.setShader(this.linearGradientShader);
    paramCanvas.drawPath(this.mLinePath, this.mPaint);
  }
  
  private void forceTextCenter()
  {
    setGravity(17);
  }
  
  private void initAttributeSet(AttributeSet paramAttributeSet)
  {
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.DividerTextView);
    this.mLineStyle = paramAttributeSet.getInteger(R.styleable.DividerTextView_lineStyle, 2);
    paramAttributeSet.recycle();
    this.mTextPadding = this.mContext.getResources().getDimensionPixelSize(2131297133);
    this.mLinePath = new Path();
    this.paintLineColor = getResources().getColor(2131165770);
    this.dividerHeight = getResources().getDimensionPixelSize(2131297594);
    this.dividerWidth = getResources().getDimensionPixelSize(2131296810);
    performSetLineStyle();
    forceTextCenter();
  }
  
  private void performSetLineStyle()
  {
    if (this.mPaint == null)
    {
      this.mPaint = new Paint(1);
      this.mPaint.setStyle(Paint.Style.STROKE);
      this.mPaint.setAntiAlias(true);
      this.mPaint.setStrokeWidth(this.dividerHeight);
    }
    if (this.mLineStyle == 1)
    {
      this.mPaint.setColor(getResources().getColor(2131165771));
      localDashPathEffect = new DashPathEffect(new float[] { getResources().getDimensionPixelSize(2131296672), getResources().getDimensionPixelSize(2131296671) }, 1.0F);
      this.mPaint.setPathEffect(localDashPathEffect);
      setBackgroundResource(0);
    }
    while (this.mLineStyle != 2)
    {
      DashPathEffect localDashPathEffect;
      return;
    }
    this.mPaint.setColor(this.paintLineColor);
    setBackgroundResource(0);
  }
  
  private void updateLayoutWidth()
  {
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    if ((this.mLineStyle == 1) || (this.mLineStyle == 2)) {
      localLayoutParams.width = -1;
    }
    for (;;)
    {
      setLayoutParams(localLayoutParams);
      return;
      if (this.mLineStyle == 3) {
        localLayoutParams.width = -2;
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((this.mLineStyle == 2) || (this.mLineStyle == 1)) {
      drawLine(paramCanvas);
    }
    super.onDraw(paramCanvas);
  }
  
  public void setLineColor(int paramInt)
  {
    this.mPaint.setColor(paramInt);
    invalidate();
  }
  
  public void setLineStyle(int paramInt)
  {
    this.mLineStyle = paramInt;
    performSetLineStyle();
    updateLayoutWidth();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.DividerTextView
 * JD-Core Version:    0.7.0.1
 */