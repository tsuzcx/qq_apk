package com.tencent.biz.pubaccount.readinjoy.view.ucrop;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import nqq;
import nra;

public class TransformImageView
  extends ImageView
{
  protected a a;
  protected boolean aui;
  protected boolean auj;
  protected final float[] aw = new float[8];
  protected final float[] ax = new float[2];
  private float[] ay;
  private float[] az;
  private int bbq;
  protected float kS;
  protected float kT;
  private final float[] mMatrixValues = new float[9];
  protected int mThisHeight;
  protected int mThisWidth;
  protected Matrix w = new Matrix();
  
  public TransformImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TransformImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TransformImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void bal()
  {
    this.w.mapPoints(this.aw, this.ay);
    this.w.mapPoints(this.ax, this.az);
  }
  
  @Nullable
  public Bitmap R()
  {
    if (getDrawable() == null) {}
    do
    {
      return null;
      if ((getDrawable() instanceof nqq)) {
        return ((nqq)getDrawable()).getBitmap();
      }
    } while (!(getDrawable() instanceof BitmapDrawable));
    return ((BitmapDrawable)getDrawable()).getBitmap();
  }
  
  public float a(@NonNull Matrix paramMatrix)
  {
    return (float)-(Math.atan2(a(paramMatrix, 1), a(paramMatrix, 0)) * 57.295779513082323D);
  }
  
  protected float a(@NonNull Matrix paramMatrix, @IntRange(from=0L, to=9L) int paramInt)
  {
    paramMatrix.getValues(this.mMatrixValues);
    return this.mMatrixValues[paramInt];
  }
  
  public float ao()
  {
    return getMatrixScale(this.w);
  }
  
  public float ap()
  {
    return a(this.w);
  }
  
  protected void bah()
  {
    Object localObject = getDrawable();
    if (localObject == null) {}
    do
    {
      return;
      float f1 = ((Drawable)localObject).getIntrinsicWidth();
      float f2 = ((Drawable)localObject).getIntrinsicHeight();
      Log.d("TransformImageView", String.format("Image size: [%d:%d]", new Object[] { Integer.valueOf((int)f1), Integer.valueOf((int)f2) }));
      localObject = new RectF(0.0F, 0.0F, f1, f2);
      this.ay = nra.a((RectF)localObject);
      this.az = nra.b((RectF)localObject);
      this.auj = true;
    } while (this.a == null);
    this.a.bam();
  }
  
  public void c(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 != 0.0F)
    {
      this.kS = paramFloat2;
      this.kT = paramFloat3;
      this.w.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
      setImageMatrix(this.w);
      if (this.a != null) {
        this.a.V(getMatrixScale(this.w));
      }
    }
  }
  
  public float getMatrixScale(@NonNull Matrix paramMatrix)
  {
    return (float)Math.sqrt(Math.pow(a(paramMatrix, 0), 2.0D) + Math.pow(a(paramMatrix, 3), 2.0D));
  }
  
  protected void init()
  {
    setScaleType(ImageView.ScaleType.MATRIX);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) || ((this.aui) && (!this.auj)))
    {
      paramInt1 = getPaddingLeft();
      paramInt2 = getPaddingTop();
      paramInt3 = getWidth();
      paramInt4 = getPaddingRight();
      int i = getHeight();
      int j = getPaddingBottom();
      this.mThisWidth = (paramInt3 - paramInt4 - paramInt1);
      this.mThisHeight = (i - j - paramInt2);
      bah();
    }
  }
  
  public void postTranslate(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 != 0.0F) || (paramFloat2 != 0.0F))
    {
      this.w.postTranslate(paramFloat1, paramFloat2);
      setImageMatrix(this.w);
    }
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    setImageDrawable(new nqq(paramBitmap));
  }
  
  public void setImageMatrix(Matrix paramMatrix)
  {
    super.setImageMatrix(paramMatrix);
    this.w.set(paramMatrix);
    bal();
  }
  
  public void setMaxBitmapSize(int paramInt)
  {
    this.bbq = paramInt;
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if (paramScaleType == ImageView.ScaleType.MATRIX)
    {
      super.setScaleType(paramScaleType);
      return;
    }
    Log.w("TransformImageView", "Invalid ScaleType. Only ScaleType.MATRIX can be used");
  }
  
  public void setTransformImageListener(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void U(float paramFloat);
    
    public abstract void V(float paramFloat);
    
    public abstract void bam();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ucrop.TransformImageView
 * JD-Core Version:    0.7.0.1
 */