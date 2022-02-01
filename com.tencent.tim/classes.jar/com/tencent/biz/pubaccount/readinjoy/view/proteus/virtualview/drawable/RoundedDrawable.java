package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.drawable;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.ImageView.ScaleType;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RoundedDrawable
  extends Drawable
{
  public static final int DEFAULT_BORDER_COLOR = -16777216;
  public static final String TAG = "RoundedDrawable";
  private final Bitmap mBitmap;
  private final int mBitmapHeight;
  private final Paint mBitmapPaint;
  private final RectF mBitmapRect = new RectF();
  private final int mBitmapWidth;
  private ColorStateList mBorderColor = ColorStateList.valueOf(-16777216);
  private final Paint mBorderPaint;
  private final RectF mBorderRect = new RectF();
  private float mBorderWidth = 0.0F;
  private final RectF mBounds = new RectF();
  private float mCornerRadius = 0.0F;
  private final boolean[] mCornersRounded = { 1, 1, 1, 1 };
  private final RectF mDrawableRect = new RectF();
  private boolean mOval = false;
  private boolean mRebuildShader = true;
  private ImageView.ScaleType mScaleType = ImageView.ScaleType.FIT_CENTER;
  private final Matrix mShaderMatrix = new Matrix();
  private final RectF mSquareCornersRect = new RectF();
  private Shader.TileMode mTileModeX = Shader.TileMode.CLAMP;
  private Shader.TileMode mTileModeY = Shader.TileMode.CLAMP;
  
  public RoundedDrawable(Bitmap paramBitmap)
  {
    this.mBitmap = paramBitmap;
    this.mBitmapWidth = paramBitmap.getWidth();
    this.mBitmapHeight = paramBitmap.getHeight();
    this.mBitmapRect.set(0.0F, 0.0F, this.mBitmapWidth, this.mBitmapHeight);
    this.mBitmapPaint = new Paint();
    this.mBitmapPaint.setStyle(Paint.Style.FILL);
    this.mBitmapPaint.setAntiAlias(true);
    this.mBorderPaint = new Paint();
    this.mBorderPaint.setStyle(Paint.Style.STROKE);
    this.mBorderPaint.setAntiAlias(true);
    this.mBorderPaint.setColor(this.mBorderColor.getColorForState(getState(), -16777216));
    this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
  }
  
  private static boolean all(boolean[] paramArrayOfBoolean)
  {
    int j = paramArrayOfBoolean.length;
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfBoolean[i] != 0) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private static boolean any(boolean[] paramArrayOfBoolean)
  {
    boolean bool2 = false;
    int j = paramArrayOfBoolean.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramArrayOfBoolean[i] != 0) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static Bitmap drawableToBitmap(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    int i = Math.max(paramDrawable.getIntrinsicWidth(), 2);
    int j = Math.max(paramDrawable.getIntrinsicHeight(), 2);
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
      paramDrawable.draw(localCanvas);
      return localBitmap;
    }
    catch (Throwable paramDrawable)
    {
      paramDrawable.printStackTrace();
      Log.w("RoundedDrawable", "Failed to create bitmap from drawable!");
    }
    return null;
  }
  
  public static RoundedDrawable fromBitmap(Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      return new RoundedDrawable(paramBitmap);
    }
    return null;
  }
  
  public static RoundedDrawable fromDrawable(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      if ((paramDrawable instanceof RoundedDrawable)) {
        return (RoundedDrawable)paramDrawable;
      }
      if ((paramDrawable instanceof LayerDrawable)) {
        throw new IllegalStateException("can not change LayerDrawable");
      }
      if ((paramDrawable instanceof StateListDrawable)) {
        throw new IllegalStateException("can not change StateListDrawable");
      }
      paramDrawable = drawableToBitmap(paramDrawable);
      if (paramDrawable != null) {
        return new RoundedDrawable(paramDrawable);
      }
    }
    return null;
  }
  
  private static boolean only(int paramInt, boolean[] paramArrayOfBoolean)
  {
    int j = paramArrayOfBoolean.length;
    int i = 0;
    while (i < j)
    {
      int m = paramArrayOfBoolean[i];
      if (i == paramInt) {}
      for (int k = 1; m != k; k = 0) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private void redrawBitmapForSquareCorners(Canvas paramCanvas)
  {
    if (all(this.mCornersRounded)) {}
    float f1;
    float f4;
    float f5;
    do
    {
      do
      {
        return;
      } while (this.mCornerRadius == 0.0F);
      f1 = this.mDrawableRect.left;
      float f2 = this.mDrawableRect.top;
      float f3 = this.mDrawableRect.width() + f1;
      f4 = this.mDrawableRect.height() + f2;
      f5 = this.mCornerRadius;
      if (this.mCornersRounded[0] == 0)
      {
        this.mSquareCornersRect.set(f1, f2, f1 + f5, f2 + f5);
        paramCanvas.drawRect(this.mSquareCornersRect, this.mBitmapPaint);
      }
      if (this.mCornersRounded[1] == 0)
      {
        this.mSquareCornersRect.set(f3 - f5, f2, f3, f5);
        paramCanvas.drawRect(this.mSquareCornersRect, this.mBitmapPaint);
      }
      if (this.mCornersRounded[2] == 0)
      {
        this.mSquareCornersRect.set(f3 - f5, f4 - f5, f3, f4);
        paramCanvas.drawRect(this.mSquareCornersRect, this.mBitmapPaint);
      }
    } while (this.mCornersRounded[3] != 0);
    this.mSquareCornersRect.set(f1, f4 - f5, f5 + f1, f4);
    paramCanvas.drawRect(this.mSquareCornersRect, this.mBitmapPaint);
  }
  
  private void redrawBorderForSquareCorners(Canvas paramCanvas)
  {
    if (all(this.mCornersRounded)) {}
    float f1;
    float f4;
    float f5;
    float f6;
    do
    {
      do
      {
        return;
      } while (this.mCornerRadius == 0.0F);
      f1 = this.mDrawableRect.left;
      float f2 = this.mDrawableRect.top;
      float f3 = f1 + this.mDrawableRect.width();
      f4 = f2 + this.mDrawableRect.height();
      f5 = this.mCornerRadius;
      f6 = this.mBorderWidth / 2.0F;
      if (this.mCornersRounded[0] == 0)
      {
        paramCanvas.drawLine(f1 - f6, f2, f1 + f5, f2, this.mBorderPaint);
        paramCanvas.drawLine(f1, f2 - f6, f1, f2 + f5, this.mBorderPaint);
      }
      if (this.mCornersRounded[1] == 0)
      {
        paramCanvas.drawLine(f3 - f5 - f6, f2, f3, f2, this.mBorderPaint);
        paramCanvas.drawLine(f3, f2 - f6, f3, f2 + f5, this.mBorderPaint);
      }
      if (this.mCornersRounded[2] == 0)
      {
        paramCanvas.drawLine(f3 - f5 - f6, f4, f3 + f6, f4, this.mBorderPaint);
        paramCanvas.drawLine(f3, f4 - f5, f3, f4, this.mBorderPaint);
      }
    } while (this.mCornersRounded[3] != 0);
    paramCanvas.drawLine(f1 - f6, f4, f1 + f5, f4, this.mBorderPaint);
    paramCanvas.drawLine(f1, f4 - f5, f1, f4, this.mBorderPaint);
  }
  
  private void updateShaderMatrix()
  {
    float f2 = 0.0F;
    switch (RoundedDrawable.1.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()])
    {
    case 4: 
    default: 
      this.mBorderRect.set(this.mBitmapRect);
      this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mBounds, Matrix.ScaleToFit.CENTER);
      this.mShaderMatrix.mapRect(this.mBorderRect);
      this.mBorderRect.inset(this.mBorderWidth / 2.0F, this.mBorderWidth / 2.0F);
      this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mBorderRect, Matrix.ScaleToFit.FILL);
    }
    for (;;)
    {
      this.mDrawableRect.set(this.mBorderRect);
      this.mRebuildShader = true;
      return;
      this.mBorderRect.set(this.mBounds);
      this.mBorderRect.inset(this.mBorderWidth / 2.0F, this.mBorderWidth / 2.0F);
      this.mShaderMatrix.reset();
      this.mShaderMatrix.setTranslate((int)((this.mBorderRect.width() - this.mBitmapWidth) * 0.5F + 0.5F), (int)((this.mBorderRect.height() - this.mBitmapHeight) * 0.5F + 0.5F));
      continue;
      this.mBorderRect.set(this.mBounds);
      this.mBorderRect.inset(this.mBorderWidth / 2.0F, this.mBorderWidth / 2.0F);
      this.mShaderMatrix.reset();
      float f3;
      if (this.mBitmapWidth * this.mBorderRect.height() > this.mBorderRect.width() * this.mBitmapHeight)
      {
        f1 = this.mBorderRect.height() / this.mBitmapHeight;
        f3 = (this.mBorderRect.width() - this.mBitmapWidth * f1) * 0.5F;
      }
      for (;;)
      {
        this.mShaderMatrix.setScale(f1, f1);
        this.mShaderMatrix.postTranslate((int)(f3 + 0.5F) + this.mBorderWidth / 2.0F, (int)(f2 + 0.5F) + this.mBorderWidth / 2.0F);
        break;
        f1 = this.mBorderRect.width() / this.mBitmapWidth;
        f2 = this.mBorderRect.height();
        float f4 = this.mBitmapHeight;
        f3 = 0.0F;
        f2 = (f2 - f4 * f1) * 0.5F;
      }
      this.mShaderMatrix.reset();
      if ((this.mBitmapWidth <= this.mBounds.width()) && (this.mBitmapHeight <= this.mBounds.height())) {}
      for (float f1 = 1.0F;; f1 = Math.min(this.mBounds.width() / this.mBitmapWidth, this.mBounds.height() / this.mBitmapHeight))
      {
        f2 = (int)((this.mBounds.width() - this.mBitmapWidth * f1) * 0.5F + 0.5F);
        f3 = (int)((this.mBounds.height() - this.mBitmapHeight * f1) * 0.5F + 0.5F);
        this.mShaderMatrix.setScale(f1, f1);
        this.mShaderMatrix.postTranslate(f2, f3);
        this.mBorderRect.set(this.mBitmapRect);
        this.mShaderMatrix.mapRect(this.mBorderRect);
        this.mBorderRect.inset(this.mBorderWidth / 2.0F, this.mBorderWidth / 2.0F);
        this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mBorderRect, Matrix.ScaleToFit.FILL);
        break;
      }
      this.mBorderRect.set(this.mBitmapRect);
      this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mBounds, Matrix.ScaleToFit.END);
      this.mShaderMatrix.mapRect(this.mBorderRect);
      this.mBorderRect.inset(this.mBorderWidth / 2.0F, this.mBorderWidth / 2.0F);
      this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mBorderRect, Matrix.ScaleToFit.FILL);
      continue;
      this.mBorderRect.set(this.mBitmapRect);
      this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mBounds, Matrix.ScaleToFit.START);
      this.mShaderMatrix.mapRect(this.mBorderRect);
      this.mBorderRect.inset(this.mBorderWidth / 2.0F, this.mBorderWidth / 2.0F);
      this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mBorderRect, Matrix.ScaleToFit.FILL);
      continue;
      this.mBorderRect.set(this.mBounds);
      this.mBorderRect.inset(this.mBorderWidth / 2.0F, this.mBorderWidth / 2.0F);
      this.mShaderMatrix.reset();
      this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mBorderRect, Matrix.ScaleToFit.FILL);
    }
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    if (this.mRebuildShader)
    {
      BitmapShader localBitmapShader = new BitmapShader(this.mBitmap, this.mTileModeX, this.mTileModeY);
      if ((this.mTileModeX == Shader.TileMode.CLAMP) && (this.mTileModeY == Shader.TileMode.CLAMP)) {
        localBitmapShader.setLocalMatrix(this.mShaderMatrix);
      }
      this.mBitmapPaint.setShader(localBitmapShader);
      this.mRebuildShader = false;
    }
    if (this.mOval) {
      if (this.mBorderWidth > 0.0F)
      {
        paramCanvas.drawOval(this.mDrawableRect, this.mBitmapPaint);
        paramCanvas.drawOval(this.mBorderRect, this.mBorderPaint);
      }
    }
    do
    {
      return;
      paramCanvas.drawOval(this.mDrawableRect, this.mBitmapPaint);
      return;
      if (any(this.mCornersRounded))
      {
        float f = this.mCornerRadius;
        if (this.mBorderWidth > 0.0F)
        {
          paramCanvas.drawRoundRect(this.mDrawableRect, f, f, this.mBitmapPaint);
          paramCanvas.drawRoundRect(this.mBorderRect, f, f, this.mBorderPaint);
          redrawBitmapForSquareCorners(paramCanvas);
          redrawBorderForSquareCorners(paramCanvas);
          return;
        }
        paramCanvas.drawRoundRect(this.mDrawableRect, f, f, this.mBitmapPaint);
        redrawBitmapForSquareCorners(paramCanvas);
        return;
      }
      paramCanvas.drawRect(this.mDrawableRect, this.mBitmapPaint);
    } while (this.mBorderWidth <= 0.0F);
    paramCanvas.drawRect(this.mBorderRect, this.mBorderPaint);
  }
  
  public int getAlpha()
  {
    return this.mBitmapPaint.getAlpha();
  }
  
  public int getBorderColor()
  {
    return this.mBorderColor.getDefaultColor();
  }
  
  public ColorStateList getBorderColors()
  {
    return this.mBorderColor;
  }
  
  public float getBorderWidth()
  {
    return this.mBorderWidth;
  }
  
  public ColorFilter getColorFilter()
  {
    return this.mBitmapPaint.getColorFilter();
  }
  
  public float getCornerRadius()
  {
    return this.mCornerRadius;
  }
  
  public float getCornerRadius(int paramInt)
  {
    if (this.mCornersRounded[paramInt] != 0) {
      return this.mCornerRadius;
    }
    return 0.0F;
  }
  
  public int getIntrinsicHeight()
  {
    return this.mBitmapHeight;
  }
  
  public int getIntrinsicWidth()
  {
    return this.mBitmapWidth;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public ImageView.ScaleType getScaleType()
  {
    return this.mScaleType;
  }
  
  public Bitmap getSourceBitmap()
  {
    return this.mBitmap;
  }
  
  public Shader.TileMode getTileModeX()
  {
    return this.mTileModeX;
  }
  
  public Shader.TileMode getTileModeY()
  {
    return this.mTileModeY;
  }
  
  public boolean isOval()
  {
    return this.mOval;
  }
  
  public boolean isStateful()
  {
    return this.mBorderColor.isStateful();
  }
  
  protected void onBoundsChange(@NonNull Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.mBounds.set(paramRect);
    updateShaderMatrix();
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    int i = this.mBorderColor.getColorForState(paramArrayOfInt, 0);
    if (this.mBorderPaint.getColor() != i)
    {
      this.mBorderPaint.setColor(i);
      return true;
    }
    return super.onStateChange(paramArrayOfInt);
  }
  
  public RoundedDrawable radius(int paramInt)
  {
    setCornerRadius(paramInt);
    return this;
  }
  
  public RoundedDrawable scaleType(ImageView.ScaleType paramScaleType)
  {
    setScaleType(paramScaleType);
    return this;
  }
  
  public void setAlpha(int paramInt)
  {
    this.mBitmapPaint.setAlpha(paramInt);
    invalidateSelf();
  }
  
  public RoundedDrawable setBorderColor(@ColorInt int paramInt)
  {
    return setBorderColor(ColorStateList.valueOf(paramInt));
  }
  
  public RoundedDrawable setBorderColor(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null) {}
    for (;;)
    {
      this.mBorderColor = paramColorStateList;
      this.mBorderPaint.setColor(this.mBorderColor.getColorForState(getState(), -16777216));
      return this;
      paramColorStateList = ColorStateList.valueOf(0);
    }
  }
  
  public RoundedDrawable setBorderWidth(float paramFloat)
  {
    this.mBorderWidth = paramFloat;
    this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
    return this;
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mBitmapPaint.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  public RoundedDrawable setCornerRadius(float paramFloat)
  {
    setCornerRadius(paramFloat, paramFloat, paramFloat, paramFloat);
    return this;
  }
  
  public RoundedDrawable setCornerRadius(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    int j = 1;
    Object localObject = new HashSet(4);
    ((Set)localObject).add(Float.valueOf(paramFloat1));
    ((Set)localObject).add(Float.valueOf(paramFloat2));
    ((Set)localObject).add(Float.valueOf(paramFloat3));
    ((Set)localObject).add(Float.valueOf(paramFloat4));
    ((Set)localObject).remove(Float.valueOf(0.0F));
    if (((Set)localObject).size() > 1) {
      throw new IllegalArgumentException("Multiple nonzero corner radii not yet supported.");
    }
    if (!((Set)localObject).isEmpty())
    {
      float f = ((Float)((Set)localObject).iterator().next()).floatValue();
      if ((Float.isInfinite(f)) || (Float.isNaN(f)) || (f < 0.0F)) {
        throw new IllegalArgumentException("Invalid radius value: " + f);
      }
      this.mCornerRadius = f;
      localObject = this.mCornersRounded;
      if (paramFloat1 <= 0.0F) {
        break label280;
      }
      i = 1;
      label199:
      localObject[0] = i;
      localObject = this.mCornersRounded;
      if (paramFloat2 <= 0.0F) {
        break label286;
      }
      i = 1;
      label220:
      localObject[1] = i;
      localObject = this.mCornersRounded;
      if (paramFloat3 <= 0.0F) {
        break label292;
      }
      i = 1;
      label241:
      localObject[2] = i;
      localObject = this.mCornersRounded;
      if (paramFloat4 <= 0.0F) {
        break label298;
      }
    }
    label280:
    label286:
    label292:
    label298:
    for (int i = j;; i = 0)
    {
      localObject[3] = i;
      return this;
      this.mCornerRadius = 0.0F;
      break;
      i = 0;
      break label199;
      i = 0;
      break label220;
      i = 0;
      break label241;
    }
  }
  
  public RoundedDrawable setCornerRadius(int paramInt, float paramFloat)
  {
    if ((paramFloat != 0.0F) && (this.mCornerRadius != 0.0F) && (this.mCornerRadius != paramFloat)) {
      throw new IllegalArgumentException("Multiple nonzero corner radii not yet supported.");
    }
    if (paramFloat == 0.0F)
    {
      if (only(paramInt, this.mCornersRounded)) {
        this.mCornerRadius = 0.0F;
      }
      this.mCornersRounded[paramInt] = false;
      return this;
    }
    if (this.mCornerRadius == 0.0F) {
      this.mCornerRadius = paramFloat;
    }
    this.mCornersRounded[paramInt] = true;
    return this;
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.mBitmapPaint.setDither(paramBoolean);
    invalidateSelf();
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.mBitmapPaint.setFilterBitmap(paramBoolean);
    invalidateSelf();
  }
  
  public RoundedDrawable setOval(boolean paramBoolean)
  {
    this.mOval = paramBoolean;
    return this;
  }
  
  public RoundedDrawable setScaleType(ImageView.ScaleType paramScaleType)
  {
    ImageView.ScaleType localScaleType = paramScaleType;
    if (paramScaleType == null) {
      localScaleType = ImageView.ScaleType.FIT_CENTER;
    }
    if (this.mScaleType != localScaleType)
    {
      this.mScaleType = localScaleType;
      updateShaderMatrix();
    }
    return this;
  }
  
  public RoundedDrawable setTileModeX(Shader.TileMode paramTileMode)
  {
    if (this.mTileModeX != paramTileMode)
    {
      this.mTileModeX = paramTileMode;
      this.mRebuildShader = true;
      invalidateSelf();
    }
    return this;
  }
  
  public RoundedDrawable setTileModeY(Shader.TileMode paramTileMode)
  {
    if (this.mTileModeY != paramTileMode)
    {
      this.mTileModeY = paramTileMode;
      this.mRebuildShader = true;
      invalidateSelf();
    }
    return this;
  }
  
  public Bitmap toBitmap()
  {
    return drawableToBitmap(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.drawable.RoundedDrawable
 * JD-Core Version:    0.7.0.1
 */