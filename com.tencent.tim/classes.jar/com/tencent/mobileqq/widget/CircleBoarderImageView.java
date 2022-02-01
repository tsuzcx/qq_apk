package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import atau.a;

public class CircleBoarderImageView
  extends ImageView
{
  private static final Bitmap.Config BITMAP_CONFIG = Bitmap.Config.ARGB_8888;
  private static final ImageView.ScaleType SCALE_TYPE = ImageView.ScaleType.CENTER_CROP;
  private boolean ix;
  private boolean iy;
  private Bitmap mBitmap;
  private int mBitmapHeight;
  private final Paint mBitmapPaint = new Paint();
  private BitmapShader mBitmapShader;
  private int mBitmapWidth;
  private int mBorderColor = -16777216;
  private final Paint mBorderPaint = new Paint();
  private float mBorderRadius;
  private final RectF mBorderRect = new RectF();
  private int mBorderWidth = 0;
  private ColorFilter mColorFilter;
  private float mDrawableRadius;
  private final RectF mDrawableRect = new RectF();
  private final Paint mFillPaint = new Paint();
  private boolean mReady;
  private boolean mSetupPending;
  private final Matrix mShaderMatrix = new Matrix();
  private int wn = 0;
  
  public CircleBoarderImageView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public CircleBoarderImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CircleBoarderImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.pP, paramInt, 0);
    this.mBorderWidth = paramContext.getDimensionPixelSize(2, 0);
    this.mBorderColor = paramContext.getColor(0, -16777216);
    this.ix = paramContext.getBoolean(1, false);
    this.wn = paramContext.getColor(3, 0);
    paramContext.recycle();
    init();
  }
  
  private RectF a()
  {
    int i = getWidth() - getPaddingLeft() - getPaddingRight();
    int j = getHeight() - getPaddingTop() - getPaddingBottom();
    int k = Math.min(i, j);
    float f1 = getPaddingLeft();
    f1 = (i - k) / 2.0F + f1;
    float f2 = getPaddingTop();
    f2 = (j - k) / 2.0F + f2;
    return new RectF(f1, f2, k + f1, k + f2);
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
      for (Bitmap localBitmap = Bitmap.createBitmap(2, 2, BITMAP_CONFIG);; localBitmap = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), BITMAP_CONFIG))
      {
        Canvas localCanvas = new Canvas(localBitmap);
        paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
        paramDrawable.draw(localCanvas);
        return localBitmap;
      }
      return null;
    }
    catch (Exception paramDrawable)
    {
      paramDrawable.printStackTrace();
    }
  }
  
  private void init()
  {
    super.setScaleType(SCALE_TYPE);
    this.mReady = true;
    if (this.mSetupPending)
    {
      setup();
      this.mSetupPending = false;
    }
  }
  
  private void po()
  {
    if (this.mBitmapPaint != null) {
      this.mBitmapPaint.setColorFilter(this.mColorFilter);
    }
  }
  
  private void pp()
  {
    if (this.iy) {}
    for (this.mBitmap = null;; this.mBitmap = getBitmapFromDrawable(getDrawable()))
    {
      setup();
      return;
    }
  }
  
  private void setup()
  {
    if (!this.mReady) {
      this.mSetupPending = true;
    }
    while ((getWidth() == 0) && (getHeight() == 0)) {
      return;
    }
    if (this.mBitmap == null)
    {
      invalidate();
      return;
    }
    this.mBitmapShader = new BitmapShader(this.mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    this.mBitmapPaint.setAntiAlias(true);
    this.mBitmapPaint.setShader(this.mBitmapShader);
    this.mBorderPaint.setStyle(Paint.Style.STROKE);
    this.mBorderPaint.setAntiAlias(true);
    this.mBorderPaint.setColor(this.mBorderColor);
    this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
    this.mFillPaint.setStyle(Paint.Style.FILL);
    this.mFillPaint.setAntiAlias(true);
    this.mFillPaint.setColor(this.wn);
    this.mBitmapHeight = this.mBitmap.getHeight();
    this.mBitmapWidth = this.mBitmap.getWidth();
    this.mBorderRect.set(a());
    this.mBorderRadius = Math.min((this.mBorderRect.height() - this.mBorderWidth) / 2.0F, (this.mBorderRect.width() - this.mBorderWidth) / 2.0F);
    this.mDrawableRect.set(this.mBorderRect);
    if ((!this.ix) && (this.mBorderWidth > 0)) {
      this.mDrawableRect.inset(this.mBorderWidth - 1.0F, this.mBorderWidth - 1.0F);
    }
    this.mDrawableRadius = Math.min(this.mDrawableRect.height() / 2.0F, this.mDrawableRect.width() / 2.0F);
    po();
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
      this.mShaderMatrix.postTranslate((int)(f3 + 0.5F) + this.mDrawableRect.left, (int)(f2 + 0.5F) + this.mDrawableRect.top);
      this.mBitmapShader.setLocalMatrix(this.mShaderMatrix);
      return;
      f1 = this.mDrawableRect.width() / this.mBitmapWidth;
      f2 = this.mDrawableRect.height();
      float f4 = this.mBitmapHeight;
      f3 = 0.0F;
      f2 = (f2 - f4 * f1) * 0.5F;
    }
  }
  
  public ColorFilter getColorFilter()
  {
    return this.mColorFilter;
  }
  
  public ImageView.ScaleType getScaleType()
  {
    return SCALE_TYPE;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.iy) {
      super.onDraw(paramCanvas);
    }
    do
    {
      do
      {
        return;
      } while (this.mBitmap == null);
      if (this.wn != 0) {
        paramCanvas.drawCircle(this.mDrawableRect.centerX(), this.mDrawableRect.centerY(), this.mDrawableRadius, this.mFillPaint);
      }
      paramCanvas.drawCircle(this.mDrawableRect.centerX(), this.mDrawableRect.centerY(), this.mDrawableRadius, this.mBitmapPaint);
    } while (this.mBorderWidth <= 0);
    paramCanvas.drawCircle(this.mBorderRect.centerX(), this.mBorderRect.centerY(), this.mBorderRadius, this.mBorderPaint);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    setup();
  }
  
  public void setAdjustViewBounds(boolean paramBoolean)
  {
    if (paramBoolean) {
      throw new IllegalArgumentException("adjustViewBounds not supported.");
    }
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
  
  @Deprecated
  public void setBorderColorResource(int paramInt)
  {
    setBorderColor(getContext().getResources().getColor(paramInt));
  }
  
  public void setBorderOverlay(boolean paramBoolean)
  {
    if (paramBoolean == this.ix) {
      return;
    }
    this.ix = paramBoolean;
    setup();
  }
  
  public void setBorderWidth(int paramInt)
  {
    if (paramInt == this.mBorderWidth) {
      return;
    }
    this.mBorderWidth = paramInt;
    setup();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    if (paramColorFilter == this.mColorFilter) {
      return;
    }
    this.mColorFilter = paramColorFilter;
    po();
    invalidate();
  }
  
  public void setDisableCircularTransformation(boolean paramBoolean)
  {
    if (this.iy == paramBoolean) {
      return;
    }
    this.iy = paramBoolean;
    pp();
  }
  
  @Deprecated
  public void setFillColor(int paramInt)
  {
    if (paramInt == this.wn) {
      return;
    }
    this.wn = paramInt;
    this.mFillPaint.setColor(paramInt);
    invalidate();
  }
  
  @Deprecated
  public void setFillColorResource(int paramInt)
  {
    setFillColor(getContext().getResources().getColor(paramInt));
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
    pp();
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    pp();
  }
  
  public void setImageResource(int paramInt)
  {
    super.setImageResource(paramInt);
    pp();
  }
  
  public void setImageURI(Uri paramUri)
  {
    super.setImageURI(paramUri);
    pp();
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    setup();
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if (paramScaleType != SCALE_TYPE) {
      throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[] { paramScaleType }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CircleBoarderImageView
 * JD-Core Version:    0.7.0.1
 */