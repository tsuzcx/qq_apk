package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import atau.a;
import wja;

public class ReadInJoyCapsuleView
  extends FrameLayout
{
  private int aYi;
  private int aYj;
  private final PorterDuffXfermode b = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
  private Drawable cK;
  ImageView kv;
  private Drawable mBackground;
  private final Paint mPaint = new Paint(1);
  private final Path mPath = new Path();
  private final RectF mRectF = new RectF();
  private String mText;
  private int mTextColor;
  TextView mTextView;
  
  public ReadInJoyCapsuleView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReadInJoyCapsuleView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, atau.a.rD, 0, 0);
    try
    {
      this.mText = paramAttributeSet.getString(3);
      this.cK = paramAttributeSet.getDrawable(4);
      this.aYi = paramAttributeSet.getDimensionPixelSize(5, 6);
      this.aYj = paramAttributeSet.getDimensionPixelSize(0, 24);
      this.mTextColor = paramAttributeSet.getColor(1, -1);
      this.mBackground = paramAttributeSet.getDrawable(2);
      paramAttributeSet.recycle();
      initViews(paramContext);
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
    }
  }
  
  private void ag(Canvas paramCanvas)
  {
    int i = getWidth();
    int j = getHeight();
    float f = j * 0.5F;
    this.mPath.moveTo(f, 0.0F);
    this.mPath.lineTo(i - f, 0.0F);
    this.mRectF.set(i - 2.0F * f, 0.0F, i, j);
    this.mPath.arcTo(this.mRectF, -90.0F, 180.0F);
    this.mPath.lineTo(f, j);
    this.mRectF.set(0.0F, 0.0F, f * 2.0F, j);
    this.mPath.arcTo(this.mRectF, 90.0F, 180.0F);
    this.mPath.close();
    this.mPaint.setXfermode(this.b);
    this.mPaint.setColor(-16777216);
    this.mPaint.setStyle(Paint.Style.FILL);
    paramCanvas.drawPath(this.mPath, this.mPaint);
    this.mPaint.setXfermode(null);
    this.mPath.reset();
  }
  
  private void initViews(Context paramContext)
  {
    this.kv = new ImageView(paramContext);
    this.kv.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.kv.setImageDrawable(this.mBackground);
    addView(this.kv, new FrameLayout.LayoutParams(-1, -1));
    this.mTextView = new TextView(paramContext);
    this.mTextView.setTypeface(this.mTextView.getTypeface(), 1);
    this.mTextView.setTextColor(this.mTextColor);
    this.mTextView.setText(this.mText);
    this.mTextView.setTextSize(0, this.aYj);
    if (this.cK != null) {
      setDrawableLeft(this.cK);
    }
    this.mTextView.setIncludeFontPadding(false);
    this.mTextView.setGravity(16);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
    localLayoutParams.leftMargin = wja.dp2px(12.0F, paramContext.getResources());
    localLayoutParams.rightMargin = wja.dp2px(12.0F, paramContext.getResources());
    addView(this.mTextView, localLayoutParams);
  }
  
  public void clearColorFilter()
  {
    this.kv.clearColorFilter();
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    paramCanvas.saveLayer(null, null, 31);
    super.dispatchDraw(paramCanvas);
    ag(paramCanvas);
    paramCanvas.restore();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    measureChildWithMargins(this.mTextView, paramInt1, 0, paramInt2, 0);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mTextView.getLayoutParams();
    paramInt1 = this.mTextView.getMeasuredWidth();
    int i = localLayoutParams.leftMargin;
    paramInt1 = View.MeasureSpec.makeMeasureSpec(localLayoutParams.rightMargin + (paramInt1 + i), 1073741824);
    this.kv.measure(paramInt1, paramInt2);
    setMeasuredDimension(paramInt1, paramInt2);
  }
  
  public void setBackgroundSrc(Drawable paramDrawable)
  {
    this.mBackground = paramDrawable;
    this.kv.setImageDrawable(this.mBackground);
  }
  
  public void setColorFilter(int paramInt)
  {
    this.kv.setColorFilter(paramInt, PorterDuff.Mode.DARKEN);
  }
  
  public void setDrawableLeft(Drawable paramDrawable)
  {
    this.cK = paramDrawable;
    float f = this.aYj / this.cK.getIntrinsicHeight();
    this.cK.setBounds(0, 0, (int)(this.cK.getIntrinsicWidth() * f), (int)(f * this.cK.getIntrinsicHeight()));
    this.mTextView.setCompoundDrawables(this.cK, null, null, null);
    this.mTextView.setCompoundDrawablePadding(this.aYi);
  }
  
  public void setText(String paramString)
  {
    this.mText = paramString;
    this.mTextView.setText(paramString);
  }
  
  public void setTextColor(int paramInt)
  {
    this.mTextColor = paramInt;
    this.mTextView.setTextColor(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyCapsuleView
 * JD-Core Version:    0.7.0.1
 */