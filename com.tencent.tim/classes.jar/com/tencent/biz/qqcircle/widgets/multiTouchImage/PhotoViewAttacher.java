package com.tencent.biz.qqcircle.widgets.multiTouchImage;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.OverScroller;
import com.tencent.qphone.base.util.QLog;
import piw;
import pix;
import piz;
import pja;
import pjb;
import pjc;
import pjd;
import pje;
import pjf;
import pjg;
import pjh;
import pji;
import pjj;
import pjk;
import pjm;

public class PhotoViewAttacher
  implements View.OnLayoutChangeListener, View.OnTouchListener
{
  private static float DEFAULT_MAX_SCALE;
  private static float DEFAULT_MID_SCALE;
  private static float DEFAULT_MIN_SCALE;
  private static int DEFAULT_ZOOM_DURATION = 200;
  private static int SINGLE_TOUCH = 1;
  private static float lV = 6.0F;
  private static float lW;
  private FlingRunnable jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher$FlingRunnable;
  private piz jdField_a_of_type_Piz;
  private pjb jdField_a_of_type_Pjb;
  private pjc jdField_a_of_type_Pjc;
  private pjd jdField_a_of_type_Pjd;
  private pje jdField_a_of_type_Pje;
  private pjf jdField_a_of_type_Pjf;
  private pjg jdField_a_of_type_Pjg;
  private pjh jdField_a_of_type_Pjh;
  private pix jdField_b_of_type_Pix;
  private pja jdField_b_of_type_Pja = new pji(this);
  private int biS = DEFAULT_ZOOM_DURATION;
  private int biT = 2;
  private int biU = 2;
  private boolean mAllowParentInterceptOnEdge = true;
  private final Matrix mBaseMatrix = new Matrix();
  private float mBaseRotation;
  private boolean mBlockParentIntercept;
  private final RectF mDisplayRect = new RectF();
  private final Matrix mDrawMatrix = new Matrix();
  private GestureDetector mGestureDetector;
  private ImageView mImageView;
  private Interpolator mInterpolator = new AccelerateDecelerateInterpolator();
  private View.OnLongClickListener mLongClickListener;
  private final float[] mMatrixValues = new float[9];
  private float mMaxScale = DEFAULT_MAX_SCALE;
  private float mMidScale = DEFAULT_MID_SCALE;
  private float mMinScale = DEFAULT_MIN_SCALE;
  private View.OnClickListener mOnClickListener;
  private ImageView.ScaleType mScaleType = ImageView.ScaleType.FIT_CENTER;
  private final Matrix mSuppMatrix = new Matrix();
  private boolean mZoomEnabled = true;
  
  static
  {
    DEFAULT_MAX_SCALE = 4.0F;
    DEFAULT_MID_SCALE = 1.75F;
    DEFAULT_MIN_SCALE = 1.0F;
    lW = 0.7F;
  }
  
  public PhotoViewAttacher(ImageView paramImageView)
  {
    this.mImageView = paramImageView;
    paramImageView.setOnTouchListener(this);
    paramImageView.addOnLayoutChangeListener(this);
    if (paramImageView.isInEditMode()) {
      return;
    }
    this.mBaseRotation = 0.0F;
    this.jdField_b_of_type_Pix = new pix(paramImageView.getContext(), this.jdField_b_of_type_Pja);
    this.mGestureDetector = new GestureDetector(paramImageView.getContext(), new pjj(this));
    this.mGestureDetector.setOnDoubleTapListener(new pjk(this));
  }
  
  private void cancelFling()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher$FlingRunnable != null)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher$FlingRunnable.cancelFling();
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher$FlingRunnable = null;
    }
  }
  
  private void checkAndDisplayMatrix()
  {
    if (checkMatrixBounds()) {
      setImageViewMatrix(getDrawMatrix());
    }
  }
  
  private boolean checkMatrixBounds()
  {
    float f2 = 0.0F;
    RectF localRectF = getDisplayRect(getDrawMatrix());
    if (localRectF == null) {
      return false;
    }
    float f1 = localRectF.height();
    float f3 = localRectF.width();
    int i = getImageViewHeight(this.mImageView);
    if (f1 <= i) {
      switch (pjl.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()])
      {
      default: 
        f1 = (i - f1) / 2.0F - localRectF.top;
        this.biU = 2;
        label103:
        i = getImageViewWidth(this.mImageView);
        if (f3 <= i) {
          switch (pjl.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()])
          {
          default: 
            f2 = (i - f3) / 2.0F - localRectF.left;
            label170:
            this.biT = 2;
          }
        }
        break;
      }
    }
    for (;;)
    {
      this.mSuppMatrix.postTranslate(f2, f1);
      return true;
      f1 = -localRectF.top;
      break;
      f1 = i - f1 - localRectF.top;
      break;
      if (localRectF.top > 0.0F)
      {
        this.biU = 0;
        f1 = -localRectF.top;
        break label103;
      }
      if (localRectF.bottom < i)
      {
        this.biU = 1;
        f1 = i - localRectF.bottom;
        break label103;
      }
      this.biU = -1;
      f1 = 0.0F;
      break label103;
      f2 = -localRectF.left;
      break label170;
      f2 = i - f3 - localRectF.left;
      break label170;
      if (localRectF.left > 0.0F)
      {
        this.biT = 0;
        f2 = -localRectF.left;
      }
      else if (localRectF.right < i)
      {
        f2 = i - localRectF.right;
        this.biT = 1;
      }
      else
      {
        this.biT = -1;
      }
    }
  }
  
  private RectF getDisplayRect(Matrix paramMatrix)
  {
    Drawable localDrawable = this.mImageView.getDrawable();
    if (localDrawable != null)
    {
      this.mDisplayRect.set(0.0F, 0.0F, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      paramMatrix.mapRect(this.mDisplayRect);
      return this.mDisplayRect;
    }
    return null;
  }
  
  private Matrix getDrawMatrix()
  {
    this.mDrawMatrix.set(this.mBaseMatrix);
    this.mDrawMatrix.postConcat(this.mSuppMatrix);
    return this.mDrawMatrix;
  }
  
  private int getImageViewHeight(ImageView paramImageView)
  {
    return paramImageView.getHeight() - paramImageView.getPaddingTop() - paramImageView.getPaddingBottom();
  }
  
  private int getImageViewWidth(ImageView paramImageView)
  {
    return paramImageView.getWidth() - paramImageView.getPaddingLeft() - paramImageView.getPaddingRight();
  }
  
  private float getValue(Matrix paramMatrix, int paramInt)
  {
    paramMatrix.getValues(this.mMatrixValues);
    return this.mMatrixValues[paramInt];
  }
  
  private void resetMatrix()
  {
    this.mSuppMatrix.reset();
    setRotationBy(this.mBaseRotation);
    setImageViewMatrix(getDrawMatrix());
    checkMatrixBounds();
  }
  
  private void setImageViewMatrix(Matrix paramMatrix)
  {
    this.mImageView.setImageMatrix(paramMatrix);
    if (this.jdField_a_of_type_Pjb != null)
    {
      paramMatrix = getDisplayRect(paramMatrix);
      if (paramMatrix != null) {
        this.jdField_a_of_type_Pjb.onMatrixChanged(paramMatrix);
      }
    }
  }
  
  private void updateBaseMatrix(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return;
    }
    float f1 = getImageViewWidth(this.mImageView);
    float f2 = getImageViewHeight(this.mImageView);
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    QLog.d("PhotoViewAttacher", 4, "updateBaseMatrix viewWidth:" + f1 + " viewHeight:" + f2 + " drawableWidth:" + i + " drawableHeight:" + j + " drawableHash:" + paramDrawable.hashCode());
    this.mBaseMatrix.reset();
    float f3 = f1 / i;
    float f4 = f2 / j;
    if (this.mScaleType == ImageView.ScaleType.CENTER) {
      this.mBaseMatrix.postTranslate((f1 - i) / 2.0F, (f2 - j) / 2.0F);
    }
    for (;;)
    {
      resetMatrix();
      return;
      if (this.mScaleType == ImageView.ScaleType.CENTER_CROP)
      {
        f3 = Math.max(f3, f4);
        this.mBaseMatrix.postScale(f3, f3);
        this.mBaseMatrix.postTranslate((f1 - i * f3) / 2.0F, (f2 - f3 * j) / 2.0F);
      }
      else if (this.mScaleType == ImageView.ScaleType.CENTER_INSIDE)
      {
        f3 = Math.min(1.0F, Math.min(f3, f4));
        this.mBaseMatrix.postScale(f3, f3);
        this.mBaseMatrix.postTranslate((f1 - i * f3) / 2.0F, (f2 - f3 * j) / 2.0F);
      }
      else
      {
        paramDrawable = new RectF(0.0F, 0.0F, i, j);
        RectF localRectF = new RectF(0.0F, 0.0F, f1, f2);
        if ((int)this.mBaseRotation % 180 != 0) {
          paramDrawable = new RectF(0.0F, 0.0F, j, i);
        }
        switch (pjl.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()])
        {
        default: 
          break;
        case 1: 
          this.mBaseMatrix.setRectToRect(paramDrawable, localRectF, Matrix.ScaleToFit.CENTER);
          break;
        case 2: 
          this.mBaseMatrix.setRectToRect(paramDrawable, localRectF, Matrix.ScaleToFit.START);
          break;
        case 3: 
          this.mBaseMatrix.setRectToRect(paramDrawable, localRectF, Matrix.ScaleToFit.END);
          break;
        case 4: 
          this.mBaseMatrix.setRectToRect(paramDrawable, localRectF, Matrix.ScaleToFit.FILL);
        }
      }
    }
  }
  
  public RectF getDisplayRect()
  {
    checkMatrixBounds();
    return getDisplayRect(getDrawMatrix());
  }
  
  public Matrix getImageMatrix()
  {
    return this.mDrawMatrix;
  }
  
  public float getScale()
  {
    return (float)Math.sqrt((float)Math.pow(getValue(this.mSuppMatrix, 0), 2.0D) + (float)Math.pow(getValue(this.mSuppMatrix, 3), 2.0D));
  }
  
  public ImageView.ScaleType getScaleType()
  {
    return this.mScaleType;
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if ((paramInt1 != paramInt5) || (paramInt2 != paramInt6) || (paramInt3 != paramInt7) || (paramInt4 != paramInt8)) {
      updateBaseMatrix(this.mImageView.getDrawable());
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool3 = false;
    if ((this.mZoomEnabled) && (pjm.hasDrawable((ImageView)paramView)))
    {
      boolean bool1;
      label59:
      boolean bool5;
      boolean bool6;
      boolean bool4;
      switch (paramMotionEvent.getAction())
      {
      case 2: 
      default: 
        bool1 = false;
        if (this.jdField_b_of_type_Pix != null)
        {
          bool5 = this.jdField_b_of_type_Pix.isScaling();
          bool6 = this.jdField_b_of_type_Pix.isDragging();
          bool4 = this.jdField_b_of_type_Pix.onTouchEvent(paramMotionEvent);
          if ((bool5) || (this.jdField_b_of_type_Pix.isScaling())) {
            break label615;
          }
          bool1 = true;
          label112:
          if ((bool6) || (this.jdField_b_of_type_Pix.isDragging())) {
            break label621;
          }
        }
        break;
      }
      label615:
      label621:
      for (boolean bool2 = true;; bool2 = false)
      {
        int i = paramMotionEvent.getPointerCount();
        if (((bool1) && (bool2)) || (i > 1)) {
          bool3 = true;
        }
        this.mBlockParentIntercept = bool3;
        QLog.d("PhotoViewAttacher", 4, "onTouch scaleDragDetector wasScaling:" + bool5 + " wasDragging:" + bool6 + " didntScale:" + bool1 + " didntDrag:" + bool2 + " mBlockParentIntercept:" + this.mBlockParentIntercept);
        bool1 = bool4;
        bool2 = bool1;
        if (this.mGestureDetector != null)
        {
          bool2 = bool1;
          if (this.mGestureDetector.onTouchEvent(paramMotionEvent)) {
            bool2 = true;
          }
        }
        return bool2;
        paramView = paramView.getParent();
        if (paramView != null) {
          paramView.requestDisallowInterceptTouchEvent(true);
        }
        cancelFling();
        bool1 = false;
        break label59;
        if (getScale() < this.mMinScale)
        {
          f2 = getScale();
          f1 = f2;
          if (f2 < lW) {
            f1 = lW;
          }
          localRectF = getDisplayRect();
          if (localRectF == null) {
            break;
          }
          QLog.d("PhotoViewAttacher", 4, "postAnimationZoom minscale event:" + paramMotionEvent.getAction() + " scale:" + getScale() + " startScale:" + f1 + " mMinScale:" + this.mMinScale + " rect:" + localRectF.toString());
          paramView.post(new AnimatedZoomRunnable(f1, this.mMinScale, localRectF.centerX(), localRectF.centerY()));
          bool1 = true;
          break label59;
        }
        if (getScale() <= this.mMaxScale) {
          break;
        }
        float f2 = getScale();
        float f1 = f2;
        if (f2 > lV) {
          f1 = lV;
        }
        RectF localRectF = getDisplayRect();
        if (localRectF == null) {
          break;
        }
        QLog.d("PhotoViewAttacher", 4, "postAnimationZoom maxscale event:" + paramMotionEvent.getAction() + " scale:" + getScale() + " startScale:" + f1 + " mMaxScale:" + this.mMaxScale + " rect:" + localRectF.toString());
        paramView.post(new AnimatedZoomRunnable(f1, this.mMaxScale, localRectF.centerX(), localRectF.centerY()));
        bool1 = true;
        break label59;
        bool1 = false;
        break label112;
      }
    }
    return false;
  }
  
  public void reset()
  {
    resetMatrix();
  }
  
  public void setAllowParentInterceptOnEdge(boolean paramBoolean)
  {
    this.mAllowParentInterceptOnEdge = paramBoolean;
  }
  
  public void setMaximumScale(float paramFloat)
  {
    pjm.checkZoomLevels(this.mMinScale, this.mMidScale, paramFloat);
    this.mMaxScale = paramFloat;
  }
  
  public void setMediumScale(float paramFloat)
  {
    pjm.checkZoomLevels(this.mMinScale, paramFloat, this.mMaxScale);
    this.mMidScale = paramFloat;
  }
  
  public void setMinimumScale(float paramFloat)
  {
    pjm.checkZoomLevels(paramFloat, this.mMidScale, this.mMaxScale);
    this.mMinScale = paramFloat;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mOnClickListener = paramOnClickListener;
  }
  
  public void setOnDoubleTabListener(piz parampiz)
  {
    this.jdField_a_of_type_Piz = parampiz;
  }
  
  public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener)
  {
    this.mGestureDetector.setOnDoubleTapListener(paramOnDoubleTapListener);
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.mLongClickListener = paramOnLongClickListener;
  }
  
  public void setOnMatrixChangeListener(pjb parampjb)
  {
    this.jdField_a_of_type_Pjb = parampjb;
  }
  
  public void setOnOutsidePhotoTapListener(pjc parampjc)
  {
    this.jdField_a_of_type_Pjc = parampjc;
  }
  
  public void setOnPhotoTapListener(pjd parampjd)
  {
    this.jdField_a_of_type_Pjd = parampjd;
  }
  
  public void setOnScaleChangeListener(pje parampje)
  {
    this.jdField_a_of_type_Pje = parampje;
  }
  
  public void setOnSingleFlingListener(pjf parampjf)
  {
    this.jdField_a_of_type_Pjf = parampjf;
  }
  
  public void setOnViewDragListener(pjg parampjg)
  {
    this.jdField_a_of_type_Pjg = parampjg;
  }
  
  public void setOnViewTapListener(pjh parampjh)
  {
    this.jdField_a_of_type_Pjh = parampjh;
  }
  
  public void setRotationBy(float paramFloat)
  {
    this.mSuppMatrix.postRotate(paramFloat % 360.0F);
    checkAndDisplayMatrix();
  }
  
  public void setRotationTo(float paramFloat)
  {
    this.mSuppMatrix.setRotate(paramFloat % 360.0F);
    checkAndDisplayMatrix();
  }
  
  public void setScale(float paramFloat)
  {
    setScale(paramFloat, false);
  }
  
  public void setScale(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean)
  {
    if ((paramFloat1 < this.mMinScale) || (paramFloat1 > this.mMaxScale)) {
      throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale");
    }
    if (paramBoolean)
    {
      this.mImageView.post(new AnimatedZoomRunnable(getScale(), paramFloat1, paramFloat2, paramFloat3));
      return;
    }
    this.mSuppMatrix.setScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
    checkAndDisplayMatrix();
  }
  
  public void setScale(float paramFloat, boolean paramBoolean)
  {
    setScale(paramFloat, this.mImageView.getRight() / 2, this.mImageView.getBottom() / 2, paramBoolean);
  }
  
  public void setScaleLevels(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    pjm.checkZoomLevels(paramFloat1, paramFloat2, paramFloat3);
    this.mMinScale = paramFloat1;
    this.mMidScale = paramFloat2;
    this.mMaxScale = paramFloat3;
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if ((pjm.isSupportedScaleType(paramScaleType)) && (paramScaleType != this.mScaleType))
    {
      this.mScaleType = paramScaleType;
      update();
    }
  }
  
  public void setZoomTransitionDuration(int paramInt)
  {
    this.biS = paramInt;
  }
  
  public void setZoomable(boolean paramBoolean)
  {
    this.mZoomEnabled = paramBoolean;
    update();
  }
  
  public void update()
  {
    if (this.mZoomEnabled)
    {
      updateBaseMatrix(this.mImageView.getDrawable());
      return;
    }
    resetMatrix();
  }
  
  public boolean w(float paramFloat1, float paramFloat2)
  {
    if ((this.mAllowParentInterceptOnEdge) && (!this.jdField_b_of_type_Pix.isScaling()) && (!this.mBlockParentIntercept))
    {
      int i;
      if ((Math.abs(paramFloat2) > 8.0F) && (Math.abs(paramFloat2) > Math.abs(paramFloat1)))
      {
        i = 1;
        if ((Math.abs(paramFloat1) <= 8.0F) || (Math.abs(paramFloat1) <= Math.abs(paramFloat2))) {
          break label261;
        }
      }
      label261:
      for (int j = 1;; j = 0)
      {
        if ((i == 0) || (Math.abs(paramFloat2) * 0.6F <= Math.abs(paramFloat1)) || ((this.biU != 2) && ((this.biU != 0) || (paramFloat2 < 8.0F)) && ((this.biU != 1) || (paramFloat2 > 0.0F - 8.0F)))) {
          break label267;
        }
        QLog.d("PhotoViewAttacher", 4, "isNeedToDisAllowInterceptEvent vertical solp false mAllowParentInterceptOnEdge:" + this.mAllowParentInterceptOnEdge + " isScaling:" + this.jdField_b_of_type_Pix.isScaling() + " mBlockParentIntercept:" + this.mBlockParentIntercept + " getScale:" + getScale() + " mHorizontalScrollEdge:" + this.biT + " mVerticalScrollEdge:" + this.biU + " dx:" + paramFloat1 + " dy:" + paramFloat2);
        return false;
        i = 0;
        break;
      }
      label267:
      if ((j != 0) && (Math.abs(paramFloat1) * 0.6F > Math.abs(paramFloat2)) && ((this.biT == 2) || ((this.biT == 0) && (paramFloat1 >= 8.0F)) || ((this.biT == 1) && (paramFloat1 <= 0.0F - 8.0F))))
      {
        QLog.d("PhotoViewAttacher", 4, "isNeedToDisAllowInterceptEvent horizontal solp false mAllowParentInterceptOnEdge:" + this.mAllowParentInterceptOnEdge + " isScaling:" + this.jdField_b_of_type_Pix.isScaling() + " mBlockParentIntercept:" + this.mBlockParentIntercept + " getScale:" + getScale() + " mHorizontalScrollEdge:" + this.biT + " mVerticalScrollEdge:" + this.biU + " dx:" + paramFloat1 + " dy:" + paramFloat2);
        return false;
      }
      if (((this.biU == 0) && (this.biT == 0) && (paramFloat2 >= 8.0F) && (paramFloat1 >= 8.0F)) || ((this.biU == 0) && (this.biT == 1) && (paramFloat2 >= 8.0F) && (paramFloat1 <= 0.0F - 8.0F)) || ((this.biU == 1) && (this.biT == 0) && (paramFloat2 <= 0.0F - 8.0F) && (paramFloat1 >= 8.0F)) || ((this.biU == 1) && (this.biT == 1) && (paramFloat2 <= 0.0F - 8.0F) && (paramFloat1 <= 0.0F - 8.0F)))
      {
        QLog.d("PhotoViewAttacher", 4, "isNeedToDisAllowInterceptEvent corner slop false mAllowParentInterceptOnEdge:" + this.mAllowParentInterceptOnEdge + " isScaling:" + this.jdField_b_of_type_Pix.isScaling() + " mBlockParentIntercept:" + this.mBlockParentIntercept + " getScale:" + getScale() + " mHorizontalScrollEdge:" + this.biT + " mVerticalScrollEdge:" + this.biU + " dx:" + paramFloat1 + " dy:" + paramFloat2);
        return false;
      }
    }
    else
    {
      QLog.d("PhotoViewAttacher", 4, "isNeedToDisAllowInterceptEvent true mAllowParentInterceptOnEdge:" + this.mAllowParentInterceptOnEdge + " isScaling:" + this.jdField_b_of_type_Pix.isScaling() + " mBlockParentIntercept:" + this.mBlockParentIntercept + " getScale:" + getScale() + " mHorizontalScrollEdge:" + this.biT + " mVerticalScrollEdge:" + this.biU + " dx:" + paramFloat1 + " dy:" + paramFloat2);
      return true;
    }
    QLog.d("PhotoViewAttacher", 4, "isNeedToDisAllowInterceptEvent default:true mAllowParentInterceptOnEdge:" + this.mAllowParentInterceptOnEdge + " isScaling:" + this.jdField_b_of_type_Pix.isScaling() + " mBlockParentIntercept:" + this.mBlockParentIntercept + " getScale:" + getScale() + " mHorizontalScrollEdge:" + this.biT + " mVerticalScrollEdge:" + this.biU + " dx:" + paramFloat1 + " dy:" + paramFloat2);
    return true;
  }
  
  class AnimatedZoomRunnable
    implements Runnable
  {
    private final float mFocalX;
    private final float mFocalY;
    private final long mStartTime;
    private final float mZoomEnd;
    private final float mZoomStart;
    
    public AnimatedZoomRunnable(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      this.mFocalX = paramFloat3;
      this.mFocalY = paramFloat4;
      this.mStartTime = System.currentTimeMillis();
      this.mZoomStart = paramFloat1;
      this.mZoomEnd = paramFloat2;
    }
    
    private float interpolate()
    {
      float f = Math.min(1.0F, (float)(System.currentTimeMillis() - this.mStartTime) * 1.0F / PhotoViewAttacher.c(PhotoViewAttacher.this));
      return PhotoViewAttacher.a(PhotoViewAttacher.this).getInterpolation(f);
    }
    
    public void run()
    {
      float f1 = interpolate();
      float f2 = (this.mZoomStart + (this.mZoomEnd - this.mZoomStart) * f1) / PhotoViewAttacher.this.getScale();
      PhotoViewAttacher.a(PhotoViewAttacher.this).onScale(f2, this.mFocalX, this.mFocalY);
      if (f1 < 1.0F)
      {
        piw.postOnAnimation(PhotoViewAttacher.a(PhotoViewAttacher.this), this);
        QLog.d("PhotoViewAttacher", 4, "AnimatedZoomRunnable postOnAnimation t:" + f1 + " deltaScale:" + f2 + " mFocalX:" + this.mFocalX + " mFocalY:" + this.mFocalY);
      }
      QLog.d("PhotoViewAttacher", 4, "AnimatedZoomRunnable t:" + f1 + " deltaScale:" + f2 + " mFocalX:" + this.mFocalX + " mFocalY:" + this.mFocalY);
    }
  }
  
  public class FlingRunnable
    implements Runnable
  {
    private int mCurrentX;
    private int mCurrentY;
    private final OverScroller mScroller;
    
    public FlingRunnable(Context paramContext)
    {
      this.mScroller = new OverScroller(paramContext);
    }
    
    public void cancelFling()
    {
      this.mScroller.forceFinished(true);
    }
    
    public void fling(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      RectF localRectF = PhotoViewAttacher.this.getDisplayRect();
      if (localRectF == null) {
        return;
      }
      int i = Math.round(-localRectF.left);
      int j;
      label52:
      int k;
      int m;
      if (paramInt1 < localRectF.width())
      {
        j = Math.round(localRectF.width() - paramInt1);
        paramInt1 = 0;
        k = Math.round(-localRectF.top);
        if (paramInt2 >= localRectF.height()) {
          break label148;
        }
        m = Math.round(localRectF.height() - paramInt2);
      }
      for (paramInt2 = 0;; paramInt2 = k)
      {
        this.mCurrentX = i;
        this.mCurrentY = k;
        if ((i == j) && (k == m)) {
          break;
        }
        this.mScroller.fling(i, k, paramInt3, paramInt4, paramInt1, j, paramInt2, m, 0, 0);
        return;
        j = i;
        paramInt1 = i;
        break label52;
        label148:
        m = k;
      }
    }
    
    public void run()
    {
      if (this.mScroller.isFinished()) {}
      while (!this.mScroller.computeScrollOffset()) {
        return;
      }
      int i = this.mScroller.getCurrX();
      int j = this.mScroller.getCurrY();
      PhotoViewAttacher.a(PhotoViewAttacher.this).postTranslate(this.mCurrentX - i, this.mCurrentY - j);
      PhotoViewAttacher.a(PhotoViewAttacher.this);
      this.mCurrentX = i;
      this.mCurrentY = j;
      piw.postOnAnimation(PhotoViewAttacher.a(PhotoViewAttacher.this), this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.multiTouchImage.PhotoViewAttacher
 * JD-Core Version:    0.7.0.1
 */