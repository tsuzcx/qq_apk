package moai.view.moaiphoto;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import java.lang.ref.WeakReference;
import moai.view.moaiphoto.gestures.OnGestureListener;
import moai.view.moaiphoto.gestures.VersionedGestureDetector;
import moai.view.moaiphoto.log.LogManager;
import moai.view.moaiphoto.log.Logger;
import moai.view.moaiphoto.scrollerproxy.ScrollerProxy;

public class PhotoViewAttacher
  implements View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener, IPhotoView, OnGestureListener
{
  private static final boolean DEBUG = Log.isLoggable("PhotoViewAttacher", 3);
  static final int EDGE_BOTH = 2;
  static final int EDGE_LEFT = 0;
  static final int EDGE_NONE = -1;
  static final int EDGE_RIGHT = 1;
  private static final String LOG_TAG = "PhotoViewAttacher";
  static int SINGLE_TOUCH = 1;
  int ZOOM_DURATION = 200;
  private boolean mAllowParentInterceptOnEdge = true;
  private final Matrix mBaseMatrix = new Matrix();
  private float mBaseRotation;
  private boolean mBlockParentIntercept = false;
  private FlingRunnable mCurrentFlingRunnable;
  private final RectF mDisplayRect = new RectF();
  private final Matrix mDrawMatrix = new Matrix();
  private android.view.GestureDetector mGestureDetector;
  private WeakReference<ImageView> mImageView;
  private Interpolator mInterpolator = new AccelerateDecelerateInterpolator();
  private int mIvBottom;
  private int mIvLeft;
  private int mIvRight;
  private int mIvTop;
  private View.OnLongClickListener mLongClickListener;
  private OnMatrixChangedListener mMatrixChangeListener;
  private final float[] mMatrixValues = new float[9];
  private float mMaxScale = 3.0F;
  private float mMidScale = 1.75F;
  private float mMinScale = 0.6F;
  private OnPhotoTapListener mPhotoTapListener;
  private OnScaleChangeListener mScaleChangeListener;
  private moai.view.moaiphoto.gestures.GestureDetector mScaleDragDetector;
  private ImageView.ScaleType mScaleType = ImageView.ScaleType.FIT_CENTER;
  private int mScrollEdge = 2;
  private OnSingleFlingListener mSingleFlingListener;
  private final Matrix mSuppMatrix = new Matrix();
  private OnViewTapListener mViewTapListener;
  private boolean mZoomEnabled;
  
  public PhotoViewAttacher(ImageView paramImageView)
  {
    this(paramImageView, true);
  }
  
  public PhotoViewAttacher(ImageView paramImageView, boolean paramBoolean)
  {
    this.mImageView = new WeakReference(paramImageView);
    paramImageView.setDrawingCacheEnabled(true);
    paramImageView.setOnTouchListener(this);
    ViewTreeObserver localViewTreeObserver = paramImageView.getViewTreeObserver();
    if (localViewTreeObserver != null) {
      localViewTreeObserver.addOnGlobalLayoutListener(this);
    }
    setImageViewScaleTypeMatrix(paramImageView);
    if (paramImageView.isInEditMode()) {
      return;
    }
    this.mScaleDragDetector = VersionedGestureDetector.newInstance(paramImageView.getContext(), this);
    this.mGestureDetector = new android.view.GestureDetector(paramImageView.getContext(), new PhotoViewAttacher.1(this));
    this.mGestureDetector.setOnDoubleTapListener(new DefaultOnDoubleTapListener(this));
    this.mBaseRotation = 0.0F;
    setZoomable(paramBoolean);
  }
  
  private void cancelFling()
  {
    if (this.mCurrentFlingRunnable != null)
    {
      this.mCurrentFlingRunnable.cancelFling();
      this.mCurrentFlingRunnable = null;
    }
  }
  
  private void checkAndDisplayMatrix()
  {
    if (checkMatrixBounds()) {
      setImageViewMatrix(getDrawMatrix());
    }
  }
  
  private void checkImageViewScaleType()
  {
    ImageView localImageView = getImageView();
    if ((localImageView != null) && (!(localImageView instanceof IPhotoView)) && (!ImageView.ScaleType.MATRIX.equals(localImageView.getScaleType()))) {
      throw new IllegalStateException("The ImageView's ScaleType has been changed since attaching a PhotoViewAttacher. You should call setScaleType on the PhotoViewAttacher instead of on the ImageView");
    }
  }
  
  private boolean checkMatrixBounds()
  {
    float f2 = 0.0F;
    ImageView localImageView = getImageView();
    if (localImageView == null) {
      return false;
    }
    RectF localRectF = getDisplayRect(getDrawMatrix());
    if (localRectF == null) {
      return false;
    }
    float f1 = localRectF.height();
    float f3 = localRectF.width();
    int i = getImageViewHeight(localImageView);
    if (f1 <= i) {
      switch (PhotoViewAttacher.2.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()])
      {
      default: 
        f1 = (i - f1) / 2.0F - localRectF.top;
      }
    }
    for (;;)
    {
      i = getImageViewWidth(localImageView);
      if (f3 <= i) {
        switch (PhotoViewAttacher.2.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()])
        {
        default: 
          f2 = (i - f3) / 2.0F - localRectF.left;
          label170:
          this.mScrollEdge = 2;
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
          f1 = -localRectF.top;
          break;
        }
        if (localRectF.bottom >= i) {
          break label345;
        }
        f1 = i - localRectF.bottom;
        break;
        f2 = -localRectF.left;
        break label170;
        f2 = i - f3 - localRectF.left;
        break label170;
        if (localRectF.left > 0.0F)
        {
          this.mScrollEdge = 0;
          f2 = -localRectF.left;
        }
        else if (localRectF.right < i)
        {
          f2 = i - localRectF.right;
          this.mScrollEdge = 1;
        }
        else
        {
          this.mScrollEdge = -1;
        }
      }
      label345:
      f1 = 0.0F;
    }
  }
  
  private static void checkZoomLevels(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 >= paramFloat2) {
      throw new IllegalArgumentException("Minimum zoom has to be less than Medium zoom. Call setMinimumZoom() with a more appropriate value");
    }
    if (paramFloat2 >= paramFloat3) {
      throw new IllegalArgumentException("Medium zoom has to be less than Maximum zoom. Call setMaximumZoom() with a more appropriate value");
    }
  }
  
  private RectF getDisplayRect(Matrix paramMatrix)
  {
    Object localObject = getImageView();
    if (localObject != null)
    {
      localObject = ((ImageView)localObject).getDrawable();
      if (localObject != null)
      {
        this.mDisplayRect.set(0.0F, 0.0F, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
        paramMatrix.mapRect(this.mDisplayRect);
        return this.mDisplayRect;
      }
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
    if (paramImageView == null) {
      return 0;
    }
    return paramImageView.getHeight() - paramImageView.getPaddingTop() - paramImageView.getPaddingBottom();
  }
  
  private int getImageViewWidth(ImageView paramImageView)
  {
    if (paramImageView == null) {
      return 0;
    }
    return paramImageView.getWidth() - paramImageView.getPaddingLeft() - paramImageView.getPaddingRight();
  }
  
  private float getValue(Matrix paramMatrix, int paramInt)
  {
    paramMatrix.getValues(this.mMatrixValues);
    return this.mMatrixValues[paramInt];
  }
  
  private static boolean hasDrawable(ImageView paramImageView)
  {
    return (paramImageView != null) && (paramImageView.getDrawable() != null);
  }
  
  private static boolean isSupportedScaleType(ImageView.ScaleType paramScaleType)
  {
    if (paramScaleType == null) {
      return false;
    }
    switch (PhotoViewAttacher.2.$SwitchMap$android$widget$ImageView$ScaleType[paramScaleType.ordinal()])
    {
    default: 
      return true;
    }
    throw new IllegalArgumentException(paramScaleType.name() + " is not supported in PhotoView");
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
    ImageView localImageView = getImageView();
    if (localImageView != null)
    {
      checkImageViewScaleType();
      localImageView.setImageMatrix(paramMatrix);
      if (this.mMatrixChangeListener != null)
      {
        paramMatrix = getDisplayRect(paramMatrix);
        if (paramMatrix != null) {
          this.mMatrixChangeListener.onMatrixChanged(paramMatrix);
        }
      }
    }
  }
  
  private static void setImageViewScaleTypeMatrix(ImageView paramImageView)
  {
    if ((paramImageView != null) && (!(paramImageView instanceof IPhotoView)) && (!ImageView.ScaleType.MATRIX.equals(paramImageView.getScaleType()))) {
      paramImageView.setScaleType(ImageView.ScaleType.MATRIX);
    }
  }
  
  private void updateBaseMatrix(Drawable paramDrawable)
  {
    Object localObject = getImageView();
    if ((localObject == null) || (paramDrawable == null)) {
      return;
    }
    float f1 = getImageViewWidth((ImageView)localObject);
    float f2 = getImageViewHeight((ImageView)localObject);
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
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
        localObject = new RectF(0.0F, 0.0F, f1, f2);
        if ((int)this.mBaseRotation % 180 != 0) {
          paramDrawable = new RectF(0.0F, 0.0F, j, i);
        }
        switch (PhotoViewAttacher.2.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()])
        {
        default: 
          break;
        case 2: 
          this.mBaseMatrix.setRectToRect(paramDrawable, (RectF)localObject, Matrix.ScaleToFit.START);
          break;
        case 4: 
          this.mBaseMatrix.setRectToRect(paramDrawable, (RectF)localObject, Matrix.ScaleToFit.CENTER);
          break;
        case 3: 
          this.mBaseMatrix.setRectToRect(paramDrawable, (RectF)localObject, Matrix.ScaleToFit.END);
          break;
        case 5: 
          this.mBaseMatrix.setRectToRect(paramDrawable, (RectF)localObject, Matrix.ScaleToFit.FILL);
        }
      }
    }
  }
  
  public boolean canZoom()
  {
    return this.mZoomEnabled;
  }
  
  public void cleanup()
  {
    if (this.mImageView == null) {
      return;
    }
    ImageView localImageView = (ImageView)this.mImageView.get();
    if (localImageView != null)
    {
      ViewTreeObserver localViewTreeObserver = localImageView.getViewTreeObserver();
      if ((localViewTreeObserver != null) && (localViewTreeObserver.isAlive())) {
        localViewTreeObserver.removeGlobalOnLayoutListener(this);
      }
      localImageView.setOnTouchListener(null);
      cancelFling();
    }
    if (this.mGestureDetector != null) {
      this.mGestureDetector.setOnDoubleTapListener(null);
    }
    this.mMatrixChangeListener = null;
    this.mPhotoTapListener = null;
    this.mViewTapListener = null;
    this.mImageView = null;
  }
  
  public void getDisplayMatrix(Matrix paramMatrix)
  {
    paramMatrix.set(getDrawMatrix());
  }
  
  public RectF getDisplayRect()
  {
    checkMatrixBounds();
    return getDisplayRect(getDrawMatrix());
  }
  
  public IPhotoView getIPhotoViewImplementation()
  {
    return this;
  }
  
  public Matrix getImageMatrix()
  {
    return this.mDrawMatrix;
  }
  
  public ImageView getImageView()
  {
    ImageView localImageView = null;
    if (this.mImageView != null) {
      localImageView = (ImageView)this.mImageView.get();
    }
    if (localImageView == null)
    {
      cleanup();
      LogManager.getLogger().i("PhotoViewAttacher", "ImageView no longer exists. You should not use this PhotoViewAttacher any more.");
    }
    return localImageView;
  }
  
  public float getMaximumScale()
  {
    return this.mMaxScale;
  }
  
  public float getMediumScale()
  {
    return this.mMidScale;
  }
  
  public float getMinimumScale()
  {
    return this.mMinScale;
  }
  
  @Nullable
  OnPhotoTapListener getOnPhotoTapListener()
  {
    return this.mPhotoTapListener;
  }
  
  @Nullable
  OnViewTapListener getOnViewTapListener()
  {
    return this.mViewTapListener;
  }
  
  public float getScale()
  {
    return (float)Math.sqrt((float)Math.pow(getValue(this.mSuppMatrix, 0), 2.0D) + (float)Math.pow(getValue(this.mSuppMatrix, 3), 2.0D));
  }
  
  public ImageView.ScaleType getScaleType()
  {
    return this.mScaleType;
  }
  
  public void getSuppMatrix(Matrix paramMatrix)
  {
    paramMatrix.set(this.mSuppMatrix);
  }
  
  public Bitmap getVisibleRectangleBitmap()
  {
    ImageView localImageView = getImageView();
    if (localImageView == null) {
      return null;
    }
    return localImageView.getDrawingCache();
  }
  
  public void onDrag(float paramFloat1, float paramFloat2)
  {
    if (this.mScaleDragDetector.isScaling()) {}
    Object localObject;
    do
    {
      do
      {
        return;
        if (DEBUG) {
          LogManager.getLogger().d("PhotoViewAttacher", String.format("onDrag: dx: %.2f. dy: %.2f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) }));
        }
        localObject = getImageView();
        this.mSuppMatrix.postTranslate(paramFloat1, paramFloat2);
        checkAndDisplayMatrix();
        localObject = ((ImageView)localObject).getParent();
        if ((!this.mAllowParentInterceptOnEdge) || (this.mScaleDragDetector.isScaling()) || (this.mBlockParentIntercept)) {
          break;
        }
      } while (((this.mScrollEdge != 2) && ((this.mScrollEdge != 0) || (paramFloat1 < 1.0F)) && ((this.mScrollEdge != 1) || (paramFloat1 > -1.0F))) || (localObject == null));
      ((ViewParent)localObject).requestDisallowInterceptTouchEvent(false);
      return;
    } while (localObject == null);
    ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
  }
  
  public void onFling(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (DEBUG) {
      LogManager.getLogger().d("PhotoViewAttacher", "onFling. sX: " + paramFloat1 + " sY: " + paramFloat2 + " Vx: " + paramFloat3 + " Vy: " + paramFloat4);
    }
    ImageView localImageView = getImageView();
    this.mCurrentFlingRunnable = new FlingRunnable(localImageView.getContext());
    this.mCurrentFlingRunnable.fling(getImageViewWidth(localImageView), getImageViewHeight(localImageView), (int)paramFloat3, (int)paramFloat4);
    localImageView.post(this.mCurrentFlingRunnable);
  }
  
  public void onGlobalLayout()
  {
    ImageView localImageView = getImageView();
    if (localImageView != null)
    {
      if (!this.mZoomEnabled) {
        break label107;
      }
      int i = localImageView.getTop();
      int j = localImageView.getRight();
      int k = localImageView.getBottom();
      int m = localImageView.getLeft();
      if ((i != this.mIvTop) || (k != this.mIvBottom) || (m != this.mIvLeft) || (j != this.mIvRight))
      {
        updateBaseMatrix(localImageView.getDrawable());
        this.mIvTop = i;
        this.mIvRight = j;
        this.mIvBottom = k;
        this.mIvLeft = m;
      }
    }
    return;
    label107:
    updateBaseMatrix(localImageView.getDrawable());
  }
  
  public void onScale(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (DEBUG) {
      LogManager.getLogger().d("PhotoViewAttacher", String.format("onScale: scale: %.2f. fX: %.2f. fY: %.2f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3) }));
    }
    if (((getScale() < this.mMaxScale) || (paramFloat1 < 1.0F)) && ((getScale() > this.mMinScale) || (paramFloat1 > 1.0F)))
    {
      if (this.mScaleChangeListener != null) {
        this.mScaleChangeListener.onScaleChange(paramFloat1, paramFloat2, paramFloat3);
      }
      this.mSuppMatrix.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
      checkAndDisplayMatrix();
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    if ((this.mZoomEnabled) && (hasDrawable((ImageView)paramView)))
    {
      Object localObject = paramView.getParent();
      boolean bool1;
      label63:
      boolean bool3;
      int i;
      switch (paramMotionEvent.getAction())
      {
      case 2: 
      default: 
        bool1 = false;
        if (this.mScaleDragDetector != null)
        {
          bool1 = this.mScaleDragDetector.isScaling();
          boolean bool4 = this.mScaleDragDetector.isDragging();
          bool3 = this.mScaleDragDetector.onTouchEvent(paramMotionEvent);
          if ((bool1) || (this.mScaleDragDetector.isScaling())) {
            break label305;
          }
          i = 1;
          label123:
          if ((bool4) || (this.mScaleDragDetector.isDragging())) {
            break label310;
          }
        }
        break;
      }
      label305:
      label310:
      for (int j = 1;; j = 0)
      {
        bool1 = bool2;
        if (i != 0)
        {
          bool1 = bool2;
          if (j != 0) {
            bool1 = true;
          }
        }
        this.mBlockParentIntercept = bool1;
        bool1 = bool3;
        bool2 = bool1;
        if (this.mGestureDetector != null)
        {
          bool2 = bool1;
          if (this.mGestureDetector.onTouchEvent(paramMotionEvent)) {
            bool2 = true;
          }
        }
        return bool2;
        if (localObject != null) {
          ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
        }
        for (;;)
        {
          cancelFling();
          bool1 = false;
          break;
          LogManager.getLogger().i("PhotoViewAttacher", "onTouch getParent() returned null");
        }
        if (getScale() >= this.mMinScale) {
          break;
        }
        localObject = getDisplayRect();
        if (localObject == null) {
          break;
        }
        paramView.post(new AnimatedZoomRunnable(getScale(), this.mMinScale, ((RectF)localObject).centerX(), ((RectF)localObject).centerY()));
        bool1 = true;
        break label63;
        i = 0;
        break label123;
      }
    }
    return false;
  }
  
  public void setAllowParentInterceptOnEdge(boolean paramBoolean)
  {
    this.mAllowParentInterceptOnEdge = paramBoolean;
  }
  
  public void setBaseRotation(float paramFloat)
  {
    this.mBaseRotation = (paramFloat % 360.0F);
    update();
    setRotationBy(this.mBaseRotation);
    checkAndDisplayMatrix();
  }
  
  public boolean setDisplayMatrix(Matrix paramMatrix)
  {
    if (paramMatrix == null) {
      throw new IllegalArgumentException("Matrix cannot be null");
    }
    ImageView localImageView = getImageView();
    if (localImageView == null) {}
    while (localImageView.getDrawable() == null) {
      return false;
    }
    this.mSuppMatrix.set(paramMatrix);
    setImageViewMatrix(getDrawMatrix());
    checkMatrixBounds();
    return true;
  }
  
  public void setMaximumScale(float paramFloat)
  {
    checkZoomLevels(this.mMinScale, this.mMidScale, paramFloat);
    this.mMaxScale = paramFloat;
  }
  
  public void setMediumScale(float paramFloat)
  {
    checkZoomLevels(this.mMinScale, paramFloat, this.mMaxScale);
    this.mMidScale = paramFloat;
  }
  
  public void setMinimumScale(float paramFloat)
  {
    checkZoomLevels(paramFloat, this.mMidScale, this.mMaxScale);
    this.mMinScale = paramFloat;
  }
  
  public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener)
  {
    if (paramOnDoubleTapListener != null)
    {
      this.mGestureDetector.setOnDoubleTapListener(paramOnDoubleTapListener);
      return;
    }
    this.mGestureDetector.setOnDoubleTapListener(new DefaultOnDoubleTapListener(this));
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.mLongClickListener = paramOnLongClickListener;
  }
  
  public void setOnMatrixChangeListener(OnMatrixChangedListener paramOnMatrixChangedListener)
  {
    this.mMatrixChangeListener = paramOnMatrixChangedListener;
  }
  
  public void setOnPhotoTapListener(OnPhotoTapListener paramOnPhotoTapListener)
  {
    this.mPhotoTapListener = paramOnPhotoTapListener;
  }
  
  public void setOnScaleChangeListener(OnScaleChangeListener paramOnScaleChangeListener)
  {
    this.mScaleChangeListener = paramOnScaleChangeListener;
  }
  
  public void setOnSingleFlingListener(OnSingleFlingListener paramOnSingleFlingListener)
  {
    this.mSingleFlingListener = paramOnSingleFlingListener;
  }
  
  public void setOnViewTapListener(OnViewTapListener paramOnViewTapListener)
  {
    this.mViewTapListener = paramOnViewTapListener;
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
    ImageView localImageView = getImageView();
    if (localImageView != null)
    {
      if ((paramFloat1 < this.mMinScale) || (paramFloat1 > this.mMaxScale)) {
        LogManager.getLogger().i("PhotoViewAttacher", "Scale must be within the range of minScale and maxScale");
      }
    }
    else {
      return;
    }
    if (paramBoolean)
    {
      localImageView.post(new AnimatedZoomRunnable(getScale(), paramFloat1, paramFloat2, paramFloat3));
      return;
    }
    this.mSuppMatrix.setScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
    checkAndDisplayMatrix();
  }
  
  public void setScale(float paramFloat, boolean paramBoolean)
  {
    ImageView localImageView = getImageView();
    if (localImageView != null) {
      setScale(paramFloat, localImageView.getRight() / 2, localImageView.getBottom() / 2, paramBoolean);
    }
  }
  
  public void setScaleLevels(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    checkZoomLevels(paramFloat1, paramFloat2, paramFloat3);
    this.mMinScale = paramFloat1;
    this.mMidScale = paramFloat2;
    this.mMaxScale = paramFloat3;
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if ((isSupportedScaleType(paramScaleType)) && (paramScaleType != this.mScaleType))
    {
      this.mScaleType = paramScaleType;
      update();
    }
  }
  
  public void setZoomInterpolator(Interpolator paramInterpolator)
  {
    this.mInterpolator = paramInterpolator;
  }
  
  public void setZoomTransitionDuration(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = 200;
    }
    this.ZOOM_DURATION = i;
  }
  
  public void setZoomable(boolean paramBoolean)
  {
    this.mZoomEnabled = paramBoolean;
    update();
  }
  
  public void update()
  {
    ImageView localImageView = getImageView();
    if (localImageView != null)
    {
      if (this.mZoomEnabled)
      {
        setImageViewScaleTypeMatrix(localImageView);
        updateBaseMatrix(localImageView.getDrawable());
      }
    }
    else {
      return;
    }
    resetMatrix();
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
      float f = Math.min(1.0F, (float)(System.currentTimeMillis() - this.mStartTime) * 1.0F / PhotoViewAttacher.this.ZOOM_DURATION);
      return PhotoViewAttacher.this.mInterpolator.getInterpolation(f);
    }
    
    public void run()
    {
      ImageView localImageView = PhotoViewAttacher.this.getImageView();
      if (localImageView == null) {}
      float f1;
      do
      {
        return;
        f1 = interpolate();
        float f2 = (this.mZoomStart + (this.mZoomEnd - this.mZoomStart) * f1) / PhotoViewAttacher.this.getScale();
        PhotoViewAttacher.this.onScale(f2, this.mFocalX, this.mFocalY);
      } while (f1 >= 1.0F);
      Compat.postOnAnimation(localImageView, this);
    }
  }
  
  class FlingRunnable
    implements Runnable
  {
    private int mCurrentX;
    private int mCurrentY;
    private final ScrollerProxy mScroller;
    
    public FlingRunnable(Context paramContext)
    {
      this.mScroller = ScrollerProxy.getScroller(paramContext);
    }
    
    public void cancelFling()
    {
      if (PhotoViewAttacher.DEBUG) {
        LogManager.getLogger().d("PhotoViewAttacher", "Cancel Fling");
      }
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
          break label215;
        }
        m = Math.round(localRectF.height() - paramInt2);
      }
      for (paramInt2 = 0;; paramInt2 = k)
      {
        this.mCurrentX = i;
        this.mCurrentY = k;
        if (PhotoViewAttacher.DEBUG) {
          LogManager.getLogger().d("PhotoViewAttacher", "fling. StartX:" + i + " StartY:" + k + " MaxX:" + j + " MaxY:" + m);
        }
        if ((i == j) && (k == m)) {
          break;
        }
        this.mScroller.fling(i, k, paramInt3, paramInt4, paramInt1, j, paramInt2, m, 0, 0);
        return;
        j = i;
        paramInt1 = i;
        break label52;
        label215:
        m = k;
      }
    }
    
    public void run()
    {
      if (this.mScroller.isFinished()) {}
      ImageView localImageView;
      do
      {
        return;
        localImageView = PhotoViewAttacher.this.getImageView();
      } while ((localImageView == null) || (!this.mScroller.computeScrollOffset()));
      int i = this.mScroller.getCurrX();
      int j = this.mScroller.getCurrY();
      if (PhotoViewAttacher.DEBUG) {
        LogManager.getLogger().d("PhotoViewAttacher", "fling run(). CurrentX:" + this.mCurrentX + " CurrentY:" + this.mCurrentY + " NewX:" + i + " NewY:" + j);
      }
      PhotoViewAttacher.this.mSuppMatrix.postTranslate(this.mCurrentX - i, this.mCurrentY - j);
      PhotoViewAttacher.this.setImageViewMatrix(PhotoViewAttacher.access$500(PhotoViewAttacher.this));
      this.mCurrentX = i;
      this.mCurrentY = j;
      Compat.postOnAnimation(localImageView, this);
    }
  }
  
  public static abstract interface OnMatrixChangedListener
  {
    public abstract void onMatrixChanged(RectF paramRectF);
  }
  
  public static abstract interface OnPhotoTapListener
  {
    public abstract void onOutsidePhotoTap();
    
    public abstract void onPhotoTap(View paramView, float paramFloat1, float paramFloat2);
  }
  
  public static abstract interface OnScaleChangeListener
  {
    public abstract void onScaleChange(float paramFloat1, float paramFloat2, float paramFloat3);
  }
  
  public static abstract interface OnSingleFlingListener
  {
    public abstract boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2);
  }
  
  public static abstract interface OnViewTapListener
  {
    public abstract void onViewTap(View paramView, float paramFloat1, float paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.view.moaiphoto.PhotoViewAttacher
 * JD-Core Version:    0.7.0.1
 */