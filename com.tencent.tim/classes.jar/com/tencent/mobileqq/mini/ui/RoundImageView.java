package com.tencent.mobileqq.mini.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class RoundImageView
  extends ImageView
{
  private static final Bitmap.Config BITMAP_CONFIG = Bitmap.Config.ARGB_8888;
  private static final int COLORDRAWABLE_DIMENSION = 1;
  private static final int DEFAULT_BORDER_COLOR = 0;
  private static final int DEFAULT_BORDER_WIDTH = 0;
  private static final ImageView.ScaleType SCALE_TYPE = ImageView.ScaleType.CENTER_CROP;
  private Bitmap mBitmap;
  private int mBitmapHeight;
  private final Paint mBitmapPaint = new Paint();
  private BitmapShader mBitmapShader;
  private int mBitmapWidth;
  private int mBorderColor = 0;
  private final Paint mBorderPaint = new Paint();
  private float mBorderRadius;
  private final RectF mBorderRect = new RectF();
  private int mBorderWidth = 0;
  private float mDrawableRadius;
  private final RectF mDrawableRect = new RectF();
  private boolean mReady;
  private boolean mSetupPending;
  private final Matrix mShaderMatrix = new Matrix();
  
  public RoundImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public RoundImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RoundImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    super.setScaleType(SCALE_TYPE);
    this.mReady = true;
    if (this.mSetupPending)
    {
      setup();
      this.mSetupPending = false;
    }
  }
  
  private Bitmap getBitmapFromDrawable(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return null;
    }
    if ((paramDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    try
    {
      if ((paramDrawable instanceof ColorDrawable)) {}
      for (Bitmap localBitmap = Bitmap.createBitmap(1, 1, BITMAP_CONFIG);; localBitmap = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), BITMAP_CONFIG))
      {
        Canvas localCanvas = new Canvas(localBitmap);
        paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
        paramDrawable.draw(localCanvas);
        return localBitmap;
      }
      return null;
    }
    catch (OutOfMemoryError paramDrawable) {}
  }
  
  private void setup()
  {
    if (!this.mReady) {
      this.mSetupPending = true;
    }
    while (this.mBitmap == null) {
      return;
    }
    this.mBitmapShader = new BitmapShader(this.mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    this.mBitmapPaint.setAntiAlias(true);
    this.mBitmapPaint.setShader(this.mBitmapShader);
    this.mBorderPaint.setStyle(Paint.Style.STROKE);
    this.mBorderPaint.setAntiAlias(true);
    this.mBorderPaint.setColor(this.mBorderColor);
    this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
    this.mBitmapHeight = this.mBitmap.getHeight();
    this.mBitmapWidth = this.mBitmap.getWidth();
    this.mBorderRect.set(0.0F, 0.0F, getWidth(), getHeight());
    this.mBorderRadius = Math.min((this.mBorderRect.height() - this.mBorderWidth) / 2.0F, (this.mBorderRect.width() - this.mBorderWidth) / 2.0F);
    this.mDrawableRect.set(this.mBorderWidth, this.mBorderWidth, this.mBorderRect.width() - this.mBorderWidth, this.mBorderRect.height() - this.mBorderWidth);
    this.mDrawableRadius = Math.min(this.mDrawableRect.height() / 2.0F, this.mDrawableRect.width() / 2.0F);
    updateShaderMatrix();
    invalidate();
  }
  
  private void updateShaderMatrix()
  {
    float f2 = 0.0F;
    this.mShaderMatrix.set(null);
    float f1;
    float f3;
    if (this.mBitmapWidth * this.mDrawableRect.height() > this.mDrawableRect.width() * this.mBitmapHeight)
    {
      f1 = this.mDrawableRect.height() / this.mBitmapHeight;
      f3 = (this.mDrawableRect.width() - this.mBitmapWidth * f1) * 0.5F;
    }
    for (;;)
    {
      this.mShaderMatrix.setScale(f1, f1);
      this.mShaderMatrix.postTranslate((int)(f3 + 0.5F) + this.mBorderWidth, (int)(f2 + 0.5F) + this.mBorderWidth);
      this.mBitmapShader.setLocalMatrix(this.mShaderMatrix);
      return;
      f1 = this.mDrawableRect.width() / this.mBitmapWidth;
      f2 = this.mDrawableRect.height();
      float f4 = this.mBitmapHeight;
      f3 = 0.0F;
      f2 = (f2 - f4 * f1) * 0.5F;
    }
  }
  
  public int getBorderColor()
  {
    return this.mBorderColor;
  }
  
  public int getBorderWidth()
  {
    return this.mBorderWidth;
  }
  
  public ImageView.ScaleType getScaleType()
  {
    return SCALE_TYPE;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (getDrawable() == null) {
      return;
    }
    paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.mDrawableRadius, this.mBitmapPaint);
    paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.mBorderRadius, this.mBorderPaint);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    setup();
  }
  
  public void setBorderColor(int paramInt)
  {
    if (paramInt == this.mBorderColor) {
      return;
    }
    this.mBorderColor = paramInt;
    this.mBorderPaint.setColor(this.mBorderColor);
    invalidate();
  }
  
  public void setBorderWidth(int paramInt)
  {
    if (paramInt == this.mBorderWidth) {
      return;
    }
    this.mBorderWidth = paramInt;
    setup();
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
    this.mBitmap = paramBitmap;
    setup();
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    this.mBitmap = getBitmapFromDrawable(paramDrawable);
    setup();
  }
  
  public void setImageResource(int paramInt)
  {
    super.setImageResource(paramInt);
    this.mBitmap = getBitmapFromDrawable(getDrawable());
    setup();
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if (paramScaleType != SCALE_TYPE) {
      throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[] { paramScaleType }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.ui.RoundImageView
 * JD-Core Version:    0.7.0.1
 */