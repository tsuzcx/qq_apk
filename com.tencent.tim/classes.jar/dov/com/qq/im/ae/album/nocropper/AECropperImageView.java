package dov.com.qq.im.ae.album.nocropper;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import android.view.View.MeasureSpec;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import atau.a;
import awvl;
import awvm;
import awvn;
import awvo;
import awvp;
import awvq;
import awvs;
import axiy;

public class AECropperImageView
  extends ImageView
{
  private boolean DEBUG;
  private float DF;
  private float DG;
  private float DH;
  private float DI;
  protected ScaleGestureDetector a;
  private a a;
  public Animator.AnimatorListener animatorListener = null;
  private boolean dsO;
  private boolean dsP;
  private boolean dsQ = true;
  private boolean dsR = true;
  private boolean dsS;
  private boolean dsT;
  private boolean dsU = true;
  private int eDc = -1;
  private int eDd = 1;
  public Bitmap mBitmap;
  protected GestureDetector mGestureDetector;
  private float[] mMatrixValues = new float[9];
  private float mMaxZoom;
  private float mMinZoom;
  private boolean showAnimation = true;
  
  public AECropperImageView(Context paramContext)
  {
    super(paramContext);
    init(paramContext, null);
  }
  
  public AECropperImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext, paramAttributeSet);
  }
  
  public AECropperImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramAttributeSet);
  }
  
  private float a(Matrix paramMatrix, int paramInt)
  {
    paramMatrix.getValues(this.mMatrixValues);
    return this.mMatrixValues[paramInt];
  }
  
  private void a(Drawable paramDrawable, int paramInt, boolean paramBoolean)
  {
    if (paramDrawable == null) {
      if (this.DEBUG) {
        axiy.e("AECropperImageView", "Drawable is null. I can't fit anything");
      }
    }
    do
    {
      do
      {
        return;
        if (paramInt != 0) {
          break;
        }
      } while (!this.DEBUG);
      axiy.e("AECropperImageView", "VideoFrame Dimension is 0. I'm quite boggled by it.");
      return;
      this.eDd = 2;
      if (paramBoolean) {
        break;
      }
      i = this.mBitmap.getWidth();
      j = this.mBitmap.getHeight();
      f1 = d(i, j, getWidth());
      localMatrix = new Matrix();
      localMatrix.setScale(f1, f1, i / 2.0F, j / 2.0F);
      localMatrix.postTranslate((paramInt - i) / 2, (paramInt - j) / 2);
      setImageMatrix(localMatrix);
      f1 = a(localMatrix, 2);
      f2 = a(localMatrix, 5);
      f3 = a(localMatrix, 0);
    } while (f3 >= this.mMinZoom);
    d(f1, getWidth() / 2 - this.mMinZoom * paramDrawable.getIntrinsicWidth() / 2.0F, f2, getHeight() / 2 - this.mMinZoom * paramDrawable.getIntrinsicHeight() / 2.0F, f3, this.mMinZoom);
    return;
    int i = this.mBitmap.getWidth();
    int j = this.mBitmap.getHeight();
    float f1 = d(i, j, getWidth());
    Matrix localMatrix = new Matrix();
    localMatrix.setScale(f1, f1, i / 2.0F, j / 2.0F);
    localMatrix.postTranslate((paramInt - i) / 2, (paramInt - j) / 2);
    float f2 = a(localMatrix, 2);
    float f3 = a(localMatrix, 5);
    float f4 = a(getImageMatrix(), 0);
    float f5 = getWidth() / 2;
    f5 = paramDrawable.getIntrinsicWidth() * f1 / 2.0F;
    f5 = getHeight() / 2;
    f5 = paramDrawable.getIntrinsicHeight() * f1 / 2.0F;
    d(f2, f2, f3, f3, f4, f1);
  }
  
  private boolean aNO()
  {
    float f6 = 0.0F;
    float f3 = 0.0F;
    Drawable localDrawable = getDrawable();
    if (localDrawable == null) {
      return false;
    }
    Matrix localMatrix = getImageMatrix();
    float f4 = a(localMatrix, 2);
    float f5 = a(localMatrix, 5);
    float f7 = a(localMatrix, 0);
    float f8 = a(localMatrix, 4);
    if (this.DEBUG)
    {
      axiy.d("AECropperImageView", "onUp( tx = " + f4 + ", ty = " + f5 + ")");
      axiy.d("AECropperImageView", "onUp() - scale: " + f7);
      axiy.d("AECropperImageView", "onUp() - min, max, base zoom: " + this.mMinZoom + ", " + this.mMaxZoom + ", " + this.DF);
      axiy.d("AECropperImageView", "onUp() - imageview size: " + getWidth() + " " + getHeight());
      axiy.d("AECropperImageView", "onUp() - drawable size: " + localDrawable.getIntrinsicWidth() + " " + localDrawable.getIntrinsicHeight());
      axiy.d("AECropperImageView", "onUp() - scaled drawable size: " + localDrawable.getIntrinsicWidth() * f7 + " " + localDrawable.getIntrinsicHeight() * f8);
      axiy.d("AECropperImageView", "onUp() - h diff: " + (localDrawable.getIntrinsicHeight() * f8 + f5 - getHeight()));
    }
    float f2;
    float f1;
    if ((f7 < this.mMinZoom) && (this.mMinZoom >= this.DF))
    {
      axiy.i("AECropperImageView", "onUp(" + f7 + ", " + this.mMinZoom + ", " + this.DF + ") - 1 scaleX < mMinZoom && mMinZoom >= mBaseZoom");
      if (this.DEBUG) {
        axiy.d("AECropperImageView", "onUp() - set scale to min zoom: " + this.mMinZoom);
      }
      f2 = getWidth() / 2 - this.mMinZoom * localDrawable.getIntrinsicWidth() / 2.0F;
      f1 = getHeight() / 2 - this.mMinZoom * localDrawable.getIntrinsicHeight() / 2.0F;
      if (localDrawable.getIntrinsicHeight() > localDrawable.getIntrinsicWidth()) {
        if (f5 >= 0.0F)
        {
          f1 = f3;
          if (!aNQ()) {
            break label702;
          }
          d(f4, f2, f5, f1, f7, this.mMinZoom);
        }
      }
      for (;;)
      {
        return true;
        if (localDrawable.getIntrinsicHeight() * f8 + f5 <= getHeight())
        {
          f1 = getHeight() - this.mMinZoom * localDrawable.getIntrinsicHeight();
          break;
        }
        f1 = this.DI;
        f3 = this.mMinZoom / f8;
        f1 = this.DI + (f5 - f1) * f3;
        break;
        if (f4 >= 0.0F)
        {
          f2 = 0.0F;
          break;
        }
        if (localDrawable.getIntrinsicWidth() * f7 + f4 <= getWidth())
        {
          f2 = getWidth() - this.mMinZoom * localDrawable.getIntrinsicWidth();
          break;
        }
        f2 = (f4 - this.DH) * (this.mMinZoom / f7) + this.DH;
        break;
        label702:
        localMatrix.reset();
        localMatrix.setScale(this.mMinZoom, this.mMinZoom);
        localMatrix.postTranslate(f2, f1);
        setImageMatrix(localMatrix);
        invalidate();
        if (this.DEBUG) {
          axiy.d("AECropperImageView", "onUp() - scale after invalidate: " + getScale(localMatrix));
        }
      }
    }
    if ((f7 <= this.DF) || (f7 <= this.DG))
    {
      axiy.i("AECropperImageView", "onUp(" + f7 + ", " + this.mMinZoom + ", " + this.DF + ") - 2 scaleX <= mBaseZoom || scaleX <= mBaseZoomBigger");
      int i = localDrawable.getIntrinsicHeight();
      int j = localDrawable.getIntrinsicWidth();
      if (i <= j)
      {
        f2 = getHeight() / 2 - i * f7 / 2.0F;
        if (f4 >= 0.0F)
        {
          f1 = f2;
          f2 = f6;
          if (!aNQ()) {
            break label1064;
          }
          localMatrix.reset();
          localMatrix.postScale(f7, f7);
          localMatrix.postTranslate(f4, f5);
          setImageMatrix(localMatrix);
          ae(f2 - f4, f1 - f5);
        }
      }
      for (;;)
      {
        return true;
        f1 = getWidth() - localDrawable.getIntrinsicWidth() * f7;
        if (f4 < f1) {}
        for (;;)
        {
          f3 = f1;
          f1 = f2;
          f2 = f3;
          break;
          f1 = f4;
        }
        f1 = getWidth() / 2 - j * f7 / 2.0F;
        if (f5 >= 0.0F)
        {
          f3 = 0.0F;
          f2 = f1;
          f1 = f3;
          break;
        }
        f2 = getHeight() - localDrawable.getIntrinsicHeight() * f8;
        if (f5 < f2)
        {
          f3 = f1;
          f1 = f2;
          f2 = f3;
          break;
        }
        f2 = f1;
        f1 = f5;
        break;
        label1064:
        localMatrix.reset();
        localMatrix.postScale(f7, f7);
        localMatrix.postTranslate(f2, f1);
        setImageMatrix(localMatrix);
        invalidate();
      }
    }
    if ((this.dsO) && (f7 > this.mMaxZoom))
    {
      axiy.i("AECropperImageView", "onUp(" + f7 + ", " + this.mMinZoom + ", " + this.DF + ") - 3 isMaxZoomSet && scaleX > mMaxZoom");
      if (this.DEBUG)
      {
        axiy.d("AECropperImageView", "onUp() - set to max zoom");
        axiy.d("AECropperImageView", "onUp() - isMaxZoomSet: " + this.dsO);
      }
      if (aNQ()) {
        eGD();
      }
      for (;;)
      {
        return true;
        localMatrix.postScale(this.mMaxZoom / f7, this.mMaxZoom / f7, this.DH, this.DI);
        setImageMatrix(localMatrix);
        invalidate();
        aNP();
      }
    }
    if (this.DEBUG) {
      axiy.d("AECropperImageView", "onUp() - adjust to sides");
    }
    aNP();
    return true;
  }
  
  private boolean aNP()
  {
    boolean bool1 = false;
    boolean bool2 = false;
    float f2 = 0.0F;
    Drawable localDrawable = getDrawable();
    if (localDrawable == null) {
      return bool2;
    }
    Matrix localMatrix = getImageMatrix();
    float f1 = a(localMatrix, 2);
    float f3 = a(localMatrix, 5);
    float f5 = a(localMatrix, 0);
    float f4 = a(localMatrix, 4);
    if (f1 > 0.0F)
    {
      f1 = -f1;
      bool1 = true;
      label74:
      if (f3 <= 0.0F) {
        break label151;
      }
      f2 = -f3;
      bool1 = true;
    }
    for (;;)
    {
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      if (!aNQ()) {
        break label186;
      }
      ae(f1, f2);
      return bool1;
      f5 = getWidth() - f5 * localDrawable.getIntrinsicWidth();
      if (f1 < f5)
      {
        f1 = f5 - f1;
        bool1 = true;
        break label74;
      }
      f1 = 0.0F;
      break label74;
      label151:
      f4 = getHeight() - localDrawable.getIntrinsicHeight() * f4;
      if (f3 < f4)
      {
        f2 = f4 - f3;
        bool1 = true;
      }
    }
    label186:
    localMatrix.postTranslate(f1, f2);
    setImageMatrix(localMatrix);
    invalidate();
    return bool1;
  }
  
  private void ae(float paramFloat1, float paramFloat2)
  {
    Matrix localMatrix = getImageMatrix();
    float f1 = a(localMatrix, 2);
    float f2 = a(localMatrix, 5);
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.addUpdateListener(new awvn(this, localMatrix, paramFloat1, f1, paramFloat2, f2));
    localValueAnimator.addListener(new awvo(this));
    localValueAnimator.start();
  }
  
  private float d(int paramInt1, int paramInt2, int paramInt3)
  {
    float f = paramInt1 * 1.0F / paramInt2;
    if (f <= 0.3333333F) {
      return paramInt3 / (paramInt1 / 0.3333333F);
    }
    if (f >= 1.777778F) {
      return paramInt3 / (paramInt2 * 1.777778F);
    }
    if (f < 1.0F) {
      return paramInt3 * 1.0F / paramInt2;
    }
    return paramInt3 * 1.0F / paramInt1;
  }
  
  private void d(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 20 });
    localValueAnimator.addUpdateListener(new awvl(this, paramFloat6, paramFloat5, paramFloat2, paramFloat1, paramFloat4, paramFloat3));
    localValueAnimator.addListener(new awvm(this));
    localValueAnimator.start();
  }
  
  private float e(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 * 1.0F / paramInt2 <= 1.0F) {
      return paramInt3 * 1.0F / paramInt1;
    }
    return paramInt3 * 1.0F / paramInt2;
  }
  
  private void eGD()
  {
    float f = getScale(getImageMatrix());
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 20 });
    localValueAnimator.addUpdateListener(new awvp(this, f));
    localValueAnimator.addListener(new awvq(this));
    localValueAnimator.start();
  }
  
  private float getScale(Matrix paramMatrix)
  {
    return a(paramMatrix, 0);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet != null)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.py);
      if (paramAttributeSet != null)
      {
        this.eDc = paramAttributeSet.getColor(2, this.eDc);
        this.dsR = paramAttributeSet.getBoolean(0, true);
        if (!paramAttributeSet.getBoolean(1, false)) {
          break label110;
        }
      }
    }
    label110:
    for (this.eDd = 2;; this.eDd = 1)
    {
      paramAttributeSet.recycle();
      this.mGestureDetector = new GestureDetector(paramContext, new b(null), null, true);
      this.jdField_a_of_type_AndroidViewScaleGestureDetector = new ScaleGestureDetector(paramContext, new c(null));
      setScaleType(ImageView.ScaleType.MATRIX);
      return;
    }
  }
  
  private void j(Drawable paramDrawable, int paramInt)
  {
    if (paramDrawable == null) {
      if (this.DEBUG) {
        axiy.e("AECropperImageView", "Drawable is null. I can't fit anything");
      }
    }
    do
    {
      return;
      if (paramInt != 0) {
        break;
      }
    } while (!this.DEBUG);
    axiy.e("AECropperImageView", "VideoFrame Dimension is 0. I'm quite boggled by it.");
    return;
    this.eDd = 1;
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    float f = e(this.mBitmap.getWidth(), this.mBitmap.getHeight(), getWidth());
    paramDrawable = new Matrix();
    paramDrawable.setScale(f, f, this.mBitmap.getWidth() / 2.0F, this.mBitmap.getHeight() / 2.0F);
    paramDrawable.postTranslate((paramInt - i) / 2, (paramInt - j) / 2);
    setImageMatrix(paramDrawable);
  }
  
  private void k(Drawable paramDrawable, int paramInt)
  {
    a(paramDrawable, paramInt, false);
  }
  
  private boolean m(float paramFloat)
  {
    if (paramFloat <= 0.0F)
    {
      axiy.e("AECropperImageView", "Min zoom must be greater than 0");
      return false;
    }
    if ((this.dsO) && (paramFloat > this.mMaxZoom))
    {
      axiy.e("AECropperImageView", "Min zoom must not be greater than max zoom");
      this.mMaxZoom = paramFloat;
    }
    this.dsP = false;
    this.mMinZoom = paramFloat;
    return true;
  }
  
  public int QF()
  {
    return this.eDd;
  }
  
  public void XJ(boolean paramBoolean)
  {
    if (this.dsT) {
      axiy.e("AECropperImageView", "Cropping current bitmap. Can't perform this action right now.");
    }
    Drawable localDrawable;
    do
    {
      return;
      localDrawable = getDrawable();
    } while (localDrawable == null);
    j(localDrawable, getWidth());
  }
  
  public void XK(boolean paramBoolean)
  {
    if (this.dsT) {
      axiy.e("AECropperImageView", "Cropping current bitmap. Can't perform this action right now.");
    }
    Drawable localDrawable;
    do
    {
      return;
      localDrawable = getDrawable();
    } while (localDrawable == null);
    a(localDrawable, getWidth(), paramBoolean);
  }
  
  public awvs a()
  {
    boolean bool = true;
    int j = 0;
    if (this.mBitmap == null)
    {
      axiy.e("AECropperImageView", "original image is not available");
      return null;
    }
    Object localObject = getImageMatrix();
    float f4 = a((Matrix)localObject, 2);
    float f5 = a((Matrix)localObject, 5);
    float f1 = a((Matrix)localObject, 0);
    if (this.DEBUG)
    {
      axiy.d("AECropperImageView", "xTrans: " + f4 + ", yTrans: " + f5 + " , scale: " + f1);
      axiy.d("AECropperImageView", "old bitmap: " + this.mBitmap.getWidth() + " " + this.mBitmap.getHeight());
    }
    int i;
    if ((f4 > 0.0F) && (f5 > 0.0F) && (f1 <= this.mMinZoom))
    {
      if (this.mBitmap.getHeight() > this.mBitmap.getWidth())
      {
        i = 0;
        if (this.mBitmap.getWidth() <= this.mBitmap.getHeight()) {
          break label257;
        }
      }
      for (;;)
      {
        return awvs.a(this.mBitmap, this.dsR, j, i, this.eDc);
        i = (this.mBitmap.getWidth() - this.mBitmap.getHeight()) / 2;
        break;
        label257:
        j = (this.mBitmap.getHeight() - this.mBitmap.getWidth()) / 2;
      }
    }
    float f2 = -f5 / f1;
    float f6 = getHeight() / f1;
    float f3 = -f4 / f1;
    float f7 = getWidth() / f1;
    if (this.DEBUG)
    {
      axiy.d("AECropperImageView", "cropY: " + f2);
      axiy.d("AECropperImageView", "Y: " + f6);
      axiy.d("AECropperImageView", "cropX: " + f3);
      axiy.d("AECropperImageView", "X: " + f7);
    }
    label546:
    int k;
    if (f2 + f6 > this.mBitmap.getHeight())
    {
      f2 = this.mBitmap.getHeight() - f6;
      f1 = f2;
      if (this.DEBUG)
      {
        axiy.d("AECropperImageView", "readjust cropY to: " + f2);
        f1 = f2;
      }
      if (f3 + f7 <= this.mBitmap.getWidth()) {
        break label707;
      }
      f3 = this.mBitmap.getWidth() - f7;
      f2 = f3;
      if (this.DEBUG)
      {
        axiy.d("AECropperImageView", "readjust cropX to: " + f3);
        f2 = f3;
      }
      if (this.mBitmap.getHeight() <= this.mBitmap.getWidth()) {
        break label787;
      }
      if (f4 < 0.0F) {
        break label752;
      }
      localObject = new Rect(0, (int)f1, this.mBitmap.getWidth(), (int)(f1 + f6));
      k = (int)((f6 - this.mBitmap.getWidth()) / 2.0F);
      i = 0;
      j = 1;
      label616:
      if ((j == 0) || ((k == 0) && (i == 0))) {
        break label878;
      }
      j = 1;
      label634:
      if ((!this.dsR) || (j == 0)) {
        break label884;
      }
    }
    for (;;)
    {
      return awvs.a((Rect)localObject, bool, k, i, this.eDc);
      f1 = f2;
      if (f2 >= 0.0F) {
        break;
      }
      if (this.DEBUG) {
        axiy.d("AECropperImageView", "readjust cropY to: " + 0.0F);
      }
      f1 = 0.0F;
      break;
      label707:
      f2 = f3;
      if (f3 >= 0.0F) {
        break label546;
      }
      if (this.DEBUG) {
        axiy.d("AECropperImageView", "readjust cropX to: " + 0.0F);
      }
      f2 = 0.0F;
      break label546;
      label752:
      localObject = new Rect((int)f2, (int)f1, (int)(f2 + f7), (int)(f1 + f6));
      j = 0;
      i = 0;
      k = 0;
      break label616;
      label787:
      if (f5 >= 0.0F)
      {
        localObject = new Rect((int)f2, 0, (int)(f2 + f7), this.mBitmap.getHeight());
        i = (int)((f7 - this.mBitmap.getHeight()) / 2.0F);
        k = 0;
        j = 1;
        break label616;
      }
      localObject = new Rect((int)f2, (int)f1, (int)(f2 + f7), (int)(f1 + f6));
      j = 0;
      i = 0;
      k = 0;
      break label616;
      label878:
      j = 0;
      break label634;
      label884:
      bool = false;
    }
  }
  
  public boolean aNQ()
  {
    return this.showAnimation;
  }
  
  public boolean aNR()
  {
    return this.dsU;
  }
  
  public float bX()
  {
    if (this.mBitmap != null) {
      return e(this.mBitmap.getWidth(), this.mBitmap.getHeight(), getWidth());
    }
    return 0.0F;
  }
  
  public float bh()
  {
    return this.mMinZoom;
  }
  
  public void eGA()
  {
    if (this.mBitmap == null) {
      return;
    }
    if (this.eDd == 2)
    {
      eGB();
      return;
    }
    eGC();
  }
  
  public void eGB()
  {
    XJ(false);
  }
  
  public void eGC()
  {
    XK(false);
  }
  
  public int getImageHeight()
  {
    if (this.mBitmap != null) {
      return this.mBitmap.getHeight();
    }
    return 0;
  }
  
  public int getImageWidth()
  {
    if (this.mBitmap != null) {
      return this.mBitmap.getWidth();
    }
    return 0;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.DEBUG) {
      axiy.d("AECropperImageView", "onLayout: " + paramBoolean + " [" + paramInt1 + ", " + paramInt2 + ", " + paramInt3 + ", " + paramInt4 + "]");
    }
    Drawable localDrawable;
    if (((paramBoolean) || (this.dsQ)) && (this.dsQ))
    {
      localDrawable = getDrawable();
      if (localDrawable != null) {
        break label133;
      }
      if (this.DEBUG) {
        axiy.e("AECropperImageView", "drawable is null");
      }
    }
    return;
    label133:
    if (getResources().getConfiguration().orientation == 2) {
      this.DF = ((paramInt3 - paramInt1) / Math.max(localDrawable.getIntrinsicHeight(), localDrawable.getIntrinsicWidth()));
    }
    for (this.DG = ((paramInt3 - paramInt1) / Math.min(localDrawable.getIntrinsicHeight(), localDrawable.getIntrinsicWidth()));; this.DG = ((paramInt4 - paramInt2) / Math.min(localDrawable.getIntrinsicHeight(), localDrawable.getIntrinsicWidth())))
    {
      if ((this.dsO) && (this.DF > this.mMaxZoom))
      {
        this.DF = this.mMaxZoom;
        this.DG = this.mMaxZoom;
        if (this.mMinZoom > this.mMaxZoom)
        {
          axiy.e("AECropperImageView", "min zoom is greater than max zoom. Changing min zoom = max zoom");
          m(this.mMaxZoom);
        }
      }
      if ((this.mMinZoom <= 0.0F) || (!this.dsP)) {
        m(this.DF);
      }
      this.dsQ = false;
      return;
      this.DF = ((paramInt4 - paramInt2) / Math.max(localDrawable.getIntrinsicHeight(), localDrawable.getIntrinsicWidth()));
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i = getContext().getResources().getConfiguration().orientation;
    if ((i == 1) || (i == 0))
    {
      paramInt1 = View.MeasureSpec.getSize(paramInt1);
      setMeasuredDimension(paramInt1, View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824));
      return;
    }
    paramInt1 = View.MeasureSpec.getSize(paramInt2);
    setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), paramInt1);
  }
  
  public boolean onScroll(float paramFloat1, float paramFloat2)
  {
    Matrix localMatrix = getImageMatrix();
    localMatrix.postTranslate(-paramFloat1, -paramFloat2);
    setImageMatrix(localMatrix);
    invalidate();
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.dsS)
    {
      axiy.d("AECropperImageView", "onTouchEvent(isAdjusting) - Can't perform this action right now.");
      return true;
    }
    if (this.dsT)
    {
      axiy.d("AECropperImageView", "onTouchEvent(isCropping) - Can't perform this action right now.");
      return true;
    }
    axiy.d("AECropperImageView", "onTouchEvent(" + paramMotionEvent.getActionMasked() + ", " + paramMotionEvent.getAction() + ")");
    getParent().requestDisallowInterceptTouchEvent(true);
    if (paramMotionEvent.getActionMasked() == 0)
    {
      axiy.d("AECropperImageView", "onTouchEvent(MotionEvent.ACTION_DOWN)");
      if (this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperImageView$a != null) {
        this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperImageView$a.eGE();
      }
    }
    this.jdField_a_of_type_AndroidViewScaleGestureDetector.onTouchEvent(paramMotionEvent);
    if (!this.jdField_a_of_type_AndroidViewScaleGestureDetector.isInProgress()) {
      this.mGestureDetector.onTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
      return true;
    }
    axiy.d("AECropperImageView", "onTouchEvent(MotionEvent.ACTION_UP)");
    if (this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperImageView$a != null) {
      this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperImageView$a.eGF();
    }
    return aNO();
  }
  
  public void setDEBUG(boolean paramBoolean)
  {
    this.DEBUG = paramBoolean;
  }
  
  public void setGestureCallback(a parama)
  {
    this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperImageView$a = parama;
  }
  
  public void setGestureEnabled(boolean paramBoolean)
  {
    this.dsU = paramBoolean;
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    if (this.dsT)
    {
      axiy.e("AECropperImageView", "Cropping current bitmap. Can't set bitmap now");
      return;
    }
    this.dsQ = true;
    if (paramBitmap == null)
    {
      this.mBitmap = null;
      super.setImageBitmap(null);
      return;
    }
    if ((paramBitmap.getHeight() > 1280) || ((paramBitmap.getWidth() > 1280) && (this.DEBUG))) {
      axiy.w("AECropperImageView", "Bitmap size greater than 1280. This might cause memory issues");
    }
    this.mBitmap = paramBitmap;
    setMinZoom(d(this.mBitmap.getWidth(), this.mBitmap.getHeight(), getWidth()));
    super.setImageBitmap(paramBitmap);
    if (this.eDd == 2) {
      k(getDrawable(), getWidth());
    }
    for (;;)
    {
      requestLayout();
      return;
      j(getDrawable(), getWidth());
    }
  }
  
  public void setMakeSquare(boolean paramBoolean)
  {
    this.dsR = paramBoolean;
  }
  
  public void setMaxZoom(float paramFloat)
  {
    if (paramFloat <= 0.0F)
    {
      axiy.e("AECropperImageView", "Max zoom must be greater than 0");
      return;
    }
    if ((this.mMinZoom > 0.0F) && (paramFloat < this.mMinZoom))
    {
      axiy.e("AECropperImageView", "Max zoom must be greater than min zoom");
      return;
    }
    this.mMaxZoom = paramFloat;
    this.dsO = true;
  }
  
  public void setMinZoom(float paramFloat)
  {
    if (m(paramFloat)) {
      this.dsP = true;
    }
  }
  
  public void setPaddingColor(int paramInt)
  {
    this.eDc = paramInt;
  }
  
  public void setShowAnimation(boolean paramBoolean)
  {
    this.showAnimation = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract void eGE();
    
    public abstract void eGF();
  }
  
  class b
    extends GestureDetector.SimpleOnGestureListener
  {
    private b() {}
    
    public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      if (!AECropperImageView.a(AECropperImageView.this)) {}
      do
      {
        return false;
        if (AECropperImageView.b(AECropperImageView.this))
        {
          axiy.e("AECropperImageView", "Cropping current bitmap. Can't perform this action right now.");
          return false;
        }
      } while ((paramMotionEvent1 == null) || (paramMotionEvent2 == null) || (paramMotionEvent1.getPointerCount() > 1) || (paramMotionEvent2.getPointerCount() > 1));
      AECropperImageView.this.onScroll(paramFloat1, paramFloat2);
      return false;
    }
  }
  
  class c
    extends ScaleGestureDetector.SimpleOnScaleGestureListener
  {
    private c() {}
    
    public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
    {
      if (!AECropperImageView.a(AECropperImageView.this)) {
        return false;
      }
      if (AECropperImageView.b(AECropperImageView.this))
      {
        axiy.e("AECropperImageView", "Cropping current bitmap. Can't perform this action right now.");
        return false;
      }
      Matrix localMatrix = AECropperImageView.this.getImageMatrix();
      AECropperImageView.a(AECropperImageView.this, paramScaleGestureDetector.getFocusX());
      AECropperImageView.b(AECropperImageView.this, paramScaleGestureDetector.getFocusY());
      localMatrix.postScale(paramScaleGestureDetector.getScaleFactor(), paramScaleGestureDetector.getScaleFactor(), paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
      AECropperImageView.this.setImageMatrix(localMatrix);
      AECropperImageView.this.invalidate();
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.album.nocropper.AECropperImageView
 * JD-Core Version:    0.7.0.1
 */