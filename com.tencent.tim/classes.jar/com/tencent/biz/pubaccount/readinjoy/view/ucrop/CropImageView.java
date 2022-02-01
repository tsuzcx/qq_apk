package com.tencent.biz.pubaccount.readinjoy.view.ucrop;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import mqq.os.MqqHandler;
import nqu;
import nqv;
import nqy;
import nqz;
import nra;

public class CropImageView
  extends TransformImageView
{
  private final RectF K = new RectF();
  private nqu a;
  private int bbf;
  private int bbg;
  private Runnable da;
  private Runnable db;
  private float kF;
  private float kG = 10.0F;
  private float mMaxScale;
  private float mMinScale;
  private final Matrix mTempMatrix = new Matrix();
  private long yc = 500L;
  
  public CropImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CropImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CropImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void A(float paramFloat1, float paramFloat2)
  {
    float f3 = this.K.width();
    float f2 = this.K.height();
    float f1 = Math.max(this.K.width() / paramFloat1, this.K.height() / paramFloat2);
    paramFloat1 = (f3 - paramFloat1 * f1) / 2.0F;
    f3 = this.K.left;
    paramFloat2 = (f2 - paramFloat2 * f1) / 2.0F;
    f2 = this.K.top;
    this.w.reset();
    this.w.postScale(f1, f1);
    this.w.postTranslate(paramFloat1 + f3, paramFloat2 + f2);
    setImageMatrix(this.w);
  }
  
  private void Z(Object paramObject)
  {
    if (paramObject != null) {
      this.aui = true;
    }
  }
  
  private void a(String paramString, boolean paramBoolean, @Nullable nqv paramnqv)
  {
    if (paramnqv == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new CropImageView.2(this, paramBoolean, paramnqv, paramString));
  }
  
  private void bai()
  {
    Drawable localDrawable = getDrawable();
    if (localDrawable == null) {
      return;
    }
    z(localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
  }
  
  private float[] e()
  {
    float f3 = 0.0F;
    this.mTempMatrix.reset();
    this.mTempMatrix.setRotate(-ap());
    Object localObject2 = Arrays.copyOf(this.aw, this.aw.length);
    Object localObject1 = nra.a(this.K);
    this.mTempMatrix.mapPoints((float[])localObject2);
    this.mTempMatrix.mapPoints((float[])localObject1);
    localObject2 = nra.a((float[])localObject2);
    localObject1 = nra.a((float[])localObject1);
    float f1 = ((RectF)localObject2).left - ((RectF)localObject1).left;
    float f5 = ((RectF)localObject2).top - ((RectF)localObject1).top;
    float f4 = ((RectF)localObject2).right - ((RectF)localObject1).right;
    float f2 = ((RectF)localObject2).bottom - ((RectF)localObject1).bottom;
    localObject1 = new float[4];
    if (f1 > 0.0F)
    {
      localObject1[0] = f1;
      if (f5 <= 0.0F) {
        break label222;
      }
      f1 = f5;
      label152:
      localObject1[1] = f1;
      if (f4 >= 0.0F) {
        break label227;
      }
    }
    label222:
    label227:
    for (f1 = f4;; f1 = 0.0F)
    {
      localObject1[2] = f1;
      f1 = f3;
      if (f2 < 0.0F) {
        f1 = f2;
      }
      localObject1[3] = f1;
      this.mTempMatrix.reset();
      this.mTempMatrix.setRotate(ap());
      this.mTempMatrix.mapPoints((float[])localObject1);
      return localObject1;
      f1 = 0.0F;
      break;
      f1 = 0.0F;
      break label152;
    }
  }
  
  private void z(float paramFloat1, float paramFloat2)
  {
    this.mMinScale = Math.min(Math.min(this.K.width() / paramFloat1, this.K.width() / paramFloat2), Math.min(this.K.height() / paramFloat2, this.K.height() / paramFloat1));
    if (this.kG != -1.0F) {
      this.mMaxScale = (this.mMinScale * this.kG);
    }
  }
  
  protected boolean FW()
  {
    return a(this.aw);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 >= getMinScale()) {
      c(paramFloat1 / ao(), paramFloat2, paramFloat3);
    }
  }
  
  protected void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    a(paramFloat1, paramFloat2, paramFloat3, paramLong, false);
  }
  
  protected void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CropImageView", 2, "zoomImageToPosition scale:" + paramFloat1 + " ,centerX:" + paramFloat2 + " ,centerY:" + paramFloat3 + " ,durationMs:" + paramLong + " ，isZoomOut：" + paramBoolean);
    }
    float f = paramFloat1;
    if (paramFloat1 > getMaxScale()) {
      f = getMaxScale();
    }
    paramFloat1 = ao();
    ZoomImageToPosition localZoomImageToPosition = new ZoomImageToPosition(this, paramLong, paramFloat1, f - paramFloat1, paramFloat2, paramFloat3, paramBoolean);
    this.db = localZoomImageToPosition;
    post(localZoomImageToPosition);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean)
  {
    if ((paramFloat1 > 1.0F) && ((paramBoolean) || (ao() * paramFloat1 <= getMaxScale()))) {
      super.c(paramFloat1, paramFloat2, paramFloat3);
    }
    while ((paramFloat1 >= 1.0F) || ((!paramBoolean) && (ao() * paramFloat1 < getMinScale()))) {
      return;
    }
    super.c(paramFloat1, paramFloat2, paramFloat3);
  }
  
  public void a(@NonNull Bitmap.CompressFormat paramCompressFormat, int paramInt1, int paramInt2, int paramInt3, @Nullable nqv paramnqv)
  {
    bag();
    setImageToWrapCropBounds(false);
    Bitmap localBitmap = R();
    if (localBitmap == null)
    {
      if (paramnqv != null) {
        paramnqv.aPQ();
      }
      return;
    }
    ThreadManager.executeOnFileThread(new CropImageView.1(this, localBitmap, new nqy(this.K, nra.a(this.aw), ao(), ap()), paramCompressFormat, paramInt1, paramnqv));
  }
  
  protected boolean a(float[] paramArrayOfFloat)
  {
    this.mTempMatrix.reset();
    this.mTempMatrix.setRotate(-ap());
    paramArrayOfFloat = Arrays.copyOf(paramArrayOfFloat, paramArrayOfFloat.length);
    this.mTempMatrix.mapPoints(paramArrayOfFloat);
    float[] arrayOfFloat = nra.a(this.K);
    this.mTempMatrix.mapPoints(arrayOfFloat);
    return nra.a(paramArrayOfFloat).contains(nra.a(arrayOfFloat));
  }
  
  public void b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 <= getMaxScale()) {
      c(paramFloat1 / ao(), paramFloat2, paramFloat3);
    }
  }
  
  protected void b(@NonNull TypedArray paramTypedArray)
  {
    float f1 = Math.abs(paramTypedArray.getFloat(0, 0.0F));
    float f2 = Math.abs(paramTypedArray.getFloat(1, 0.0F));
    if ((f1 == 0.0F) || (f2 == 0.0F))
    {
      this.kF = 0.0F;
      return;
    }
    this.kF = (f1 / f2);
  }
  
  public void bag()
  {
    removeCallbacks(this.da);
    removeCallbacks(this.db);
  }
  
  protected void bah()
  {
    super.bah();
    Drawable localDrawable = getDrawable();
    if (localDrawable == null) {
      return;
    }
    float f1 = localDrawable.getIntrinsicWidth();
    float f2 = localDrawable.getIntrinsicHeight();
    if (this.kF == 0.0F) {
      this.kF = (f1 / f2);
    }
    int i = (int)(this.mThisWidth / this.kF);
    int j;
    if (i > this.mThisHeight)
    {
      i = (int)(this.mThisHeight * this.kF);
      j = (this.mThisWidth - i) / 2;
      this.K.set(j, 0.0F, i + j, this.mThisHeight);
    }
    for (;;)
    {
      z(f1, f2);
      A(f1, f2);
      if (this.jdField_a_of_type_Nqu != null) {
        this.jdField_a_of_type_Nqu.W(this.kF);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewUcropTransformImageView$a == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewUcropTransformImageView$a.V(ao());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewUcropTransformImageView$a.U(ap());
      return;
      j = (this.mThisHeight - i) / 2;
      this.K.set(0.0F, j, this.mThisWidth, i + j);
    }
  }
  
  public void c(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    a(paramFloat1, paramFloat2, paramFloat3, false);
  }
  
  public float getMaxScale()
  {
    return this.mMaxScale;
  }
  
  public float getMinScale()
  {
    return this.mMinScale;
  }
  
  public void setCropBoundsChangeListener(@Nullable nqu paramnqu)
  {
    this.jdField_a_of_type_Nqu = paramnqu;
  }
  
  public void setCropRect(RectF paramRectF)
  {
    this.kF = (paramRectF.width() / paramRectF.height());
    this.K.set(paramRectF.left - getPaddingLeft(), paramRectF.top - getPaddingTop(), paramRectF.right - getPaddingRight(), paramRectF.bottom - getPaddingBottom());
    bai();
    setImageToWrapCropBounds();
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    Z(paramBitmap);
    super.setImageBitmap(paramBitmap);
  }
  
  @Deprecated
  public void setImageDrawable(@Nullable Drawable paramDrawable)
  {
    Z(paramDrawable);
    super.setImageDrawable(paramDrawable);
  }
  
  public void setImageToLowerMaxScale()
  {
    if (ao() > getMaxScale())
    {
      float[] arrayOfFloat = new float[9];
      this.w.getValues(arrayOfFloat);
      a(getMaxScale(), this.kS, this.kT, 200L, true);
    }
  }
  
  public void setImageToWrapCropBounds()
  {
    setImageToWrapCropBounds(true);
  }
  
  public void setImageToWrapCropBounds(boolean paramBoolean)
  {
    float f6;
    float f1;
    float f2;
    float f3;
    Object localObject;
    boolean bool;
    if ((this.auj) && (!FW()))
    {
      float f4 = this.ax[0];
      float f5 = this.ax[1];
      f6 = ao();
      f1 = this.K.centerX() - f4;
      f2 = this.K.centerY() - f5;
      f3 = 0.0F;
      this.mTempMatrix.reset();
      this.mTempMatrix.setTranslate(f1, f2);
      localObject = Arrays.copyOf(this.aw, this.aw.length);
      this.mTempMatrix.mapPoints((float[])localObject);
      bool = a((float[])localObject);
      if (!bool) {
        break label187;
      }
      localObject = e();
      f1 = -(localObject[0] + localObject[2]);
      f2 = localObject[1];
      f2 = -(localObject[3] + f2);
      if (!paramBoolean) {
        break label271;
      }
      localObject = new WrapCropBoundsRunnable(this, this.yc, f4, f5, f1, f2, f6, f3, bool);
      this.da = ((Runnable)localObject);
      post((Runnable)localObject);
    }
    label187:
    do
    {
      return;
      localObject = new RectF(this.K);
      this.mTempMatrix.reset();
      this.mTempMatrix.setRotate(ap());
      this.mTempMatrix.mapRect((RectF)localObject);
      float[] arrayOfFloat = nra.b(this.aw);
      f3 = Math.max(((RectF)localObject).width() / arrayOfFloat[0], ((RectF)localObject).height() / arrayOfFloat[1]) * f6 - f6;
      break;
      postTranslate(f1, f2);
    } while (bool);
    label271:
    b(f6 + f3, this.K.centerX(), this.K.centerY());
  }
  
  public void setImageToWrapCropBoundsAnimDuration(@IntRange(from=100L) long paramLong)
  {
    if (paramLong > 0L)
    {
      this.yc = paramLong;
      return;
    }
    throw new IllegalArgumentException("Animation duration cannot be negative value.");
  }
  
  public void setMaxResultImageSizeX(@IntRange(from=10L) int paramInt)
  {
    this.bbf = paramInt;
  }
  
  public void setMaxResultImageSizeY(@IntRange(from=10L) int paramInt)
  {
    this.bbg = paramInt;
  }
  
  public void setMaxScale(float paramFloat)
  {
    this.mMaxScale = paramFloat;
    this.kG = -1.0F;
  }
  
  public void setMaxScaleMultiplier(float paramFloat)
  {
    this.kG = paramFloat;
  }
  
  public void setTargetAspectRatio(float paramFloat)
  {
    Drawable localDrawable = getDrawable();
    if (localDrawable == null) {
      this.kF = paramFloat;
    }
    for (;;)
    {
      return;
      if (paramFloat == 0.0F) {}
      for (this.kF = (localDrawable.getIntrinsicWidth() / localDrawable.getIntrinsicHeight()); this.jdField_a_of_type_Nqu != null; this.kF = paramFloat)
      {
        this.jdField_a_of_type_Nqu.W(this.kF);
        return;
      }
    }
  }
  
  static class WrapCropBoundsRunnable
    implements Runnable
  {
    private final boolean atZ;
    private final WeakReference<CropImageView> cy;
    private final float kH;
    private final float kI;
    private final float kJ;
    private final float kK;
    private final float kL;
    private final float mDeltaScale;
    private final long mStartTime;
    private final long yd;
    
    public WrapCropBoundsRunnable(CropImageView paramCropImageView, long paramLong, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean)
    {
      this.cy = new WeakReference(paramCropImageView);
      this.yd = paramLong;
      this.mStartTime = System.currentTimeMillis();
      this.kH = paramFloat1;
      this.kI = paramFloat2;
      this.kJ = paramFloat3;
      this.kK = paramFloat4;
      this.kL = paramFloat5;
      this.mDeltaScale = paramFloat6;
      this.atZ = paramBoolean;
    }
    
    public void run()
    {
      CropImageView localCropImageView = (CropImageView)this.cy.get();
      if (localCropImageView == null) {}
      do
      {
        float f1;
        float f2;
        float f3;
        float f4;
        do
        {
          return;
          long l = System.currentTimeMillis();
          f1 = (float)Math.min(this.yd, l - this.mStartTime);
          f2 = nqz.b(f1, 0.0F, this.kJ, (float)this.yd);
          f3 = nqz.b(f1, 0.0F, this.kK, (float)this.yd);
          f4 = nqz.c(f1, 0.0F, this.mDeltaScale, (float)this.yd);
        } while (f1 >= (float)this.yd);
        localCropImageView.postTranslate(f2 - (localCropImageView.ax[0] - this.kH), f3 - (localCropImageView.ax[1] - this.kI));
        if (!this.atZ) {
          localCropImageView.b(this.kL + f4, CropImageView.a(localCropImageView).centerX(), CropImageView.a(localCropImageView).centerY());
        }
      } while (localCropImageView.FW());
      localCropImageView.post(this);
    }
  }
  
  static class ZoomImageToPosition
    implements Runnable
  {
    private final boolean aua;
    private final WeakReference<CropImageView> cy;
    private final float kL;
    private final float kM;
    private final float kN;
    private final float mDeltaScale;
    private final long mStartTime;
    private final long yd;
    
    public ZoomImageToPosition(CropImageView paramCropImageView, long paramLong, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean)
    {
      this.cy = new WeakReference(paramCropImageView);
      this.mStartTime = System.currentTimeMillis();
      this.yd = paramLong;
      this.kL = paramFloat1;
      this.mDeltaScale = paramFloat2;
      this.kM = paramFloat3;
      this.kN = paramFloat4;
      this.aua = paramBoolean;
    }
    
    public void run()
    {
      CropImageView localCropImageView = (CropImageView)this.cy.get();
      if (localCropImageView == null) {
        return;
      }
      long l = System.currentTimeMillis();
      float f2 = (float)Math.min(this.yd, l - this.mStartTime);
      float f1;
      if (this.aua)
      {
        f1 = nqz.b(f2, 0.0F, this.mDeltaScale, (float)this.yd);
        if (f2 >= (float)this.yd) {
          break label143;
        }
        if (this.aua) {
          break label121;
        }
        localCropImageView.b(f1 + this.kL, this.kM, this.kN);
      }
      for (;;)
      {
        localCropImageView.post(this);
        return;
        f1 = nqz.c(f2, 0.0F, this.mDeltaScale, (float)this.yd);
        break;
        label121:
        localCropImageView.a(f1 + this.kL, this.kM, this.kN);
      }
      label143:
      localCropImageView.setImageToWrapCropBounds();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ucrop.CropImageView
 * JD-Core Version:    0.7.0.1
 */