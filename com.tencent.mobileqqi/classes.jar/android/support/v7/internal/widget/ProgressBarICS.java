package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;

public class ProgressBarICS
  extends View
{
  private static final int ANIMATION_RESOLUTION = 200;
  private static final int MAX_LEVEL = 10000;
  private static final int[] android_R_styleable_ProgressBar = { 16843062, 16843063, 16843064, 16843065, 16843066, 16843067, 16843068, 16843069, 16843070, 16843071, 16843039, 16843072, 16843040, 16843073 };
  private AlphaAnimation mAnimation;
  private int mBehavior;
  private Drawable mCurrentDrawable;
  private int mDuration;
  private boolean mInDrawing;
  private boolean mIndeterminate;
  private Drawable mIndeterminateDrawable;
  private Interpolator mInterpolator;
  private long mLastDrawTime;
  private int mMax;
  int mMaxHeight;
  int mMaxWidth;
  int mMinHeight;
  int mMinWidth;
  private boolean mNoInvalidate;
  private boolean mOnlyIndeterminate;
  private int mProgress;
  private Drawable mProgressDrawable;
  private ProgressBarICS.RefreshProgressRunnable mRefreshProgressRunnable;
  Bitmap mSampleTile;
  private int mSecondaryProgress;
  private boolean mShouldStartAnimationDrawable;
  private Transformation mTransformation;
  private long mUiThreadId = Thread.currentThread().getId();
  
  public ProgressBarICS(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1);
    initProgressBar();
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, android_R_styleable_ProgressBar, paramInt1, paramInt2);
    this.mNoInvalidate = true;
    setMax(paramAttributeSet.getInt(0, this.mMax));
    setProgress(paramAttributeSet.getInt(1, this.mProgress));
    setSecondaryProgress(paramAttributeSet.getInt(2, this.mSecondaryProgress));
    boolean bool2 = paramAttributeSet.getBoolean(3, this.mIndeterminate);
    this.mOnlyIndeterminate = paramAttributeSet.getBoolean(4, this.mOnlyIndeterminate);
    Drawable localDrawable = paramAttributeSet.getDrawable(5);
    if (localDrawable != null) {
      setIndeterminateDrawable(tileifyIndeterminate(localDrawable));
    }
    localDrawable = paramAttributeSet.getDrawable(6);
    if (localDrawable != null) {
      setProgressDrawable(tileify(localDrawable, false));
    }
    this.mDuration = paramAttributeSet.getInt(7, this.mDuration);
    this.mBehavior = paramAttributeSet.getInt(8, this.mBehavior);
    this.mMinWidth = paramAttributeSet.getDimensionPixelSize(9, this.mMinWidth);
    this.mMaxWidth = paramAttributeSet.getDimensionPixelSize(10, this.mMaxWidth);
    this.mMinHeight = paramAttributeSet.getDimensionPixelSize(11, this.mMinHeight);
    this.mMaxHeight = paramAttributeSet.getDimensionPixelSize(12, this.mMaxHeight);
    paramInt1 = paramAttributeSet.getResourceId(13, 17432587);
    if (paramInt1 > 0) {
      setInterpolator(paramContext, paramInt1);
    }
    paramAttributeSet.recycle();
    this.mNoInvalidate = false;
    if ((this.mOnlyIndeterminate) || (bool2)) {
      bool1 = true;
    }
    setIndeterminate(bool1);
  }
  
  private void doRefreshProgress(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      Object localObject2;
      try
      {
        float f;
        if (this.mMax > 0)
        {
          f = paramInt2 / this.mMax;
          localObject2 = this.mCurrentDrawable;
          if (localObject2 != null)
          {
            Drawable localDrawable = null;
            if (!(localObject2 instanceof LayerDrawable)) {
              break label85;
            }
            localDrawable = ((LayerDrawable)localObject2).findDrawableByLayerId(paramInt1);
            break label85;
            ((Drawable)localObject2).setLevel(paramInt1);
          }
        }
        else
        {
          f = 0.0F;
          continue;
        }
        invalidate();
        continue;
        paramInt1 = (int)(f * 10000.0F);
      }
      finally {}
      label85:
      if (localObject1 != null) {
        localObject2 = localObject1;
      }
    }
  }
  
  private void initProgressBar()
  {
    this.mMax = 100;
    this.mProgress = 0;
    this.mSecondaryProgress = 0;
    this.mIndeterminate = false;
    this.mOnlyIndeterminate = false;
    this.mDuration = 4000;
    this.mBehavior = 1;
    this.mMinWidth = 24;
    this.mMaxWidth = 48;
    this.mMinHeight = 24;
    this.mMaxHeight = 48;
  }
  
  private void refreshProgress(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (this.mUiThreadId == Thread.currentThread().getId())
        {
          doRefreshProgress(paramInt1, paramInt2, paramBoolean, true);
          return;
        }
        if (this.mRefreshProgressRunnable != null)
        {
          ProgressBarICS.RefreshProgressRunnable localRefreshProgressRunnable1 = this.mRefreshProgressRunnable;
          this.mRefreshProgressRunnable = null;
          localRefreshProgressRunnable1.setup(paramInt1, paramInt2, paramBoolean);
          post(localRefreshProgressRunnable1);
        }
        else
        {
          ProgressBarICS.RefreshProgressRunnable localRefreshProgressRunnable2 = new ProgressBarICS.RefreshProgressRunnable(this, paramInt1, paramInt2, paramBoolean);
        }
      }
      finally {}
    }
  }
  
  private Drawable tileify(Drawable paramDrawable, boolean paramBoolean)
  {
    int j = 0;
    Object localObject;
    if ((paramDrawable instanceof LayerDrawable))
    {
      LayerDrawable localLayerDrawable = (LayerDrawable)paramDrawable;
      int k = localLayerDrawable.getNumberOfLayers();
      paramDrawable = new Drawable[k];
      int i = 0;
      if (i < k)
      {
        int m = localLayerDrawable.getId(i);
        localObject = localLayerDrawable.getDrawable(i);
        if ((m == 16908301) || (m == 16908303)) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          paramDrawable[i] = tileify((Drawable)localObject, paramBoolean);
          i += 1;
          break;
        }
      }
      localObject = new LayerDrawable(paramDrawable);
      i = j;
      for (;;)
      {
        paramDrawable = (Drawable)localObject;
        if (i >= k) {
          break;
        }
        ((LayerDrawable)localObject).setId(i, localLayerDrawable.getId(i));
        i += 1;
      }
    }
    if ((paramDrawable instanceof BitmapDrawable))
    {
      localObject = ((BitmapDrawable)paramDrawable).getBitmap();
      if (this.mSampleTile == null) {
        this.mSampleTile = ((Bitmap)localObject);
      }
      paramDrawable = new ShapeDrawable(getDrawableShape());
      localObject = new BitmapShader((Bitmap)localObject, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP);
      paramDrawable.getPaint().setShader((Shader)localObject);
      if (paramBoolean)
      {
        paramDrawable = new ClipDrawable(paramDrawable, 3, 1);
        return paramDrawable;
      }
      return paramDrawable;
    }
    return paramDrawable;
  }
  
  private Drawable tileifyIndeterminate(Drawable paramDrawable)
  {
    Object localObject = paramDrawable;
    if ((paramDrawable instanceof AnimationDrawable))
    {
      paramDrawable = (AnimationDrawable)paramDrawable;
      int j = paramDrawable.getNumberOfFrames();
      localObject = new AnimationDrawable();
      ((AnimationDrawable)localObject).setOneShot(paramDrawable.isOneShot());
      int i = 0;
      while (i < j)
      {
        Drawable localDrawable = tileify(paramDrawable.getFrame(i), true);
        localDrawable.setLevel(10000);
        ((AnimationDrawable)localObject).addFrame(localDrawable, paramDrawable.getDuration(i));
        i += 1;
      }
      ((AnimationDrawable)localObject).setLevel(10000);
    }
    return localObject;
  }
  
  private void updateDrawableBounds(int paramInt1, int paramInt2)
  {
    int j = paramInt1 - getPaddingRight() - getPaddingLeft();
    int i = paramInt2 - getPaddingBottom() - getPaddingTop();
    int k;
    float f1;
    float f2;
    if (this.mIndeterminateDrawable != null) {
      if ((this.mOnlyIndeterminate) && (!(this.mIndeterminateDrawable instanceof AnimationDrawable)))
      {
        k = this.mIndeterminateDrawable.getIntrinsicWidth();
        int m = this.mIndeterminateDrawable.getIntrinsicHeight();
        f1 = k / m;
        f2 = paramInt1 / paramInt2;
        if (f1 != f2) {
          if (f2 > f1)
          {
            paramInt2 = (int)(f1 * paramInt2);
            k = (paramInt1 - paramInt2) / 2;
            paramInt2 += k;
            paramInt1 = i;
            j = 0;
            i = k;
            this.mIndeterminateDrawable.setBounds(i, j, paramInt2, paramInt1);
          }
        }
      }
    }
    for (;;)
    {
      if (this.mProgressDrawable != null) {
        this.mProgressDrawable.setBounds(0, 0, paramInt2, paramInt1);
      }
      return;
      f2 = paramInt1;
      paramInt1 = (int)(1.0F / f1 * f2);
      i = (paramInt2 - paramInt1) / 2;
      paramInt2 = j;
      paramInt1 += i;
      j = i;
      i = 0;
      break;
      k = 0;
      paramInt2 = j;
      paramInt1 = i;
      j = 0;
      i = k;
      break;
      paramInt1 = i;
      paramInt2 = j;
    }
  }
  
  private void updateDrawableState()
  {
    int[] arrayOfInt = getDrawableState();
    if ((this.mProgressDrawable != null) && (this.mProgressDrawable.isStateful())) {
      this.mProgressDrawable.setState(arrayOfInt);
    }
    if ((this.mIndeterminateDrawable != null) && (this.mIndeterminateDrawable.isStateful())) {
      this.mIndeterminateDrawable.setState(arrayOfInt);
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    updateDrawableState();
  }
  
  Shape getDrawableShape()
  {
    return new RoundRectShape(new float[] { 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F }, null, null);
  }
  
  public Drawable getIndeterminateDrawable()
  {
    return this.mIndeterminateDrawable;
  }
  
  public Interpolator getInterpolator()
  {
    return this.mInterpolator;
  }
  
  public int getMax()
  {
    try
    {
      int i = this.mMax;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public int getProgress()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 114	android/support/v7/internal/widget/ProgressBarICS:mIndeterminate	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +9 -> 17
    //   11: iconst_0
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 104	android/support/v7/internal/widget/ProgressBarICS:mProgress	I
    //   21: istore_1
    //   22: goto -9 -> 13
    //   25: astore_3
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_3
    //   29: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	30	0	this	ProgressBarICS
    //   12	10	1	i	int
    //   6	2	2	bool	boolean
    //   25	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	25	finally
    //   17	22	25	finally
  }
  
  public Drawable getProgressDrawable()
  {
    return this.mProgressDrawable;
  }
  
  /* Error */
  public int getSecondaryProgress()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 114	android/support/v7/internal/widget/ProgressBarICS:mIndeterminate	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +9 -> 17
    //   11: iconst_0
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 109	android/support/v7/internal/widget/ProgressBarICS:mSecondaryProgress	I
    //   21: istore_1
    //   22: goto -9 -> 13
    //   25: astore_3
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_3
    //   29: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	30	0	this	ProgressBarICS
    //   12	10	1	i	int
    //   6	2	2	bool	boolean
    //   25	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	25	finally
    //   17	22	25	finally
  }
  
  public final void incrementProgressBy(int paramInt)
  {
    try
    {
      setProgress(this.mProgress + paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void incrementSecondaryProgressBy(int paramInt)
  {
    try
    {
      setSecondaryProgress(this.mSecondaryProgress + paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    if (!this.mInDrawing)
    {
      if (verifyDrawable(paramDrawable))
      {
        paramDrawable = paramDrawable.getBounds();
        int i = getScrollX() + getPaddingLeft();
        int j = getScrollY() + getPaddingTop();
        invalidate(paramDrawable.left + i, paramDrawable.top + j, i + paramDrawable.right, paramDrawable.bottom + j);
      }
    }
    else {
      return;
    }
    super.invalidateDrawable(paramDrawable);
  }
  
  public boolean isIndeterminate()
  {
    try
    {
      boolean bool = this.mIndeterminate;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.mIndeterminate) {
      startAnimation();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    if (this.mIndeterminate) {
      stopAnimation();
    }
    if (this.mRefreshProgressRunnable != null) {
      removeCallbacks(this.mRefreshProgressRunnable);
    }
    super.onDetachedFromWindow();
  }
  
  /* Error */
  protected void onDraw(android.graphics.Canvas paramCanvas)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokespecial 415	android/view/View:onDraw	(Landroid/graphics/Canvas;)V
    //   7: aload_0
    //   8: getfield 181	android/support/v7/internal/widget/ProgressBarICS:mCurrentDrawable	Landroid/graphics/drawable/Drawable;
    //   11: astore 5
    //   13: aload 5
    //   15: ifnull +145 -> 160
    //   18: aload_1
    //   19: invokevirtual 420	android/graphics/Canvas:save	()I
    //   22: pop
    //   23: aload_1
    //   24: aload_0
    //   25: invokevirtual 305	android/support/v7/internal/widget/ProgressBarICS:getPaddingLeft	()I
    //   28: i2f
    //   29: aload_0
    //   30: invokevirtual 311	android/support/v7/internal/widget/ProgressBarICS:getPaddingTop	()I
    //   33: i2f
    //   34: invokevirtual 424	android/graphics/Canvas:translate	(FF)V
    //   37: aload_0
    //   38: invokevirtual 427	android/support/v7/internal/widget/ProgressBarICS:getDrawingTime	()J
    //   41: lstore_3
    //   42: aload_0
    //   43: getfield 429	android/support/v7/internal/widget/ProgressBarICS:mAnimation	Landroid/view/animation/AlphaAnimation;
    //   46: ifnull +74 -> 120
    //   49: aload_0
    //   50: getfield 429	android/support/v7/internal/widget/ProgressBarICS:mAnimation	Landroid/view/animation/AlphaAnimation;
    //   53: lload_3
    //   54: aload_0
    //   55: getfield 431	android/support/v7/internal/widget/ProgressBarICS:mTransformation	Landroid/view/animation/Transformation;
    //   58: invokevirtual 437	android/view/animation/AlphaAnimation:getTransformation	(JLandroid/view/animation/Transformation;)Z
    //   61: pop
    //   62: aload_0
    //   63: getfield 431	android/support/v7/internal/widget/ProgressBarICS:mTransformation	Landroid/view/animation/Transformation;
    //   66: invokevirtual 443	android/view/animation/Transformation:getAlpha	()F
    //   69: fstore_2
    //   70: aload_0
    //   71: iconst_1
    //   72: putfield 363	android/support/v7/internal/widget/ProgressBarICS:mInDrawing	Z
    //   75: aload 5
    //   77: fload_2
    //   78: ldc 196
    //   80: fmul
    //   81: f2i
    //   82: invokevirtual 192	android/graphics/drawable/Drawable:setLevel	(I)Z
    //   85: pop
    //   86: aload_0
    //   87: iconst_0
    //   88: putfield 363	android/support/v7/internal/widget/ProgressBarICS:mInDrawing	Z
    //   91: invokestatic 448	android/os/SystemClock:uptimeMillis	()J
    //   94: aload_0
    //   95: getfield 450	android/support/v7/internal/widget/ProgressBarICS:mLastDrawTime	J
    //   98: lsub
    //   99: ldc2_w 451
    //   102: lcmp
    //   103: iflt +17 -> 120
    //   106: aload_0
    //   107: invokestatic 448	android/os/SystemClock:uptimeMillis	()J
    //   110: putfield 450	android/support/v7/internal/widget/ProgressBarICS:mLastDrawTime	J
    //   113: aload_0
    //   114: ldc2_w 451
    //   117: invokevirtual 456	android/support/v7/internal/widget/ProgressBarICS:postInvalidateDelayed	(J)V
    //   120: aload 5
    //   122: aload_1
    //   123: invokevirtual 459	android/graphics/drawable/Drawable:draw	(Landroid/graphics/Canvas;)V
    //   126: aload_1
    //   127: invokevirtual 462	android/graphics/Canvas:restore	()V
    //   130: aload_0
    //   131: getfield 464	android/support/v7/internal/widget/ProgressBarICS:mShouldStartAnimationDrawable	Z
    //   134: ifeq +26 -> 160
    //   137: aload 5
    //   139: instanceof 466
    //   142: ifeq +18 -> 160
    //   145: aload 5
    //   147: checkcast 466	android/graphics/drawable/Animatable
    //   150: invokeinterface 469 1 0
    //   155: aload_0
    //   156: iconst_0
    //   157: putfield 464	android/support/v7/internal/widget/ProgressBarICS:mShouldStartAnimationDrawable	Z
    //   160: aload_0
    //   161: monitorexit
    //   162: return
    //   163: astore_1
    //   164: aload_0
    //   165: iconst_0
    //   166: putfield 363	android/support/v7/internal/widget/ProgressBarICS:mInDrawing	Z
    //   169: aload_1
    //   170: athrow
    //   171: astore_1
    //   172: aload_0
    //   173: monitorexit
    //   174: aload_1
    //   175: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	ProgressBarICS
    //   0	176	1	paramCanvas	android.graphics.Canvas
    //   69	9	2	f	float
    //   41	13	3	l	long
    //   11	135	5	localDrawable	Drawable
    // Exception table:
    //   from	to	target	type
    //   70	86	163	finally
    //   2	13	171	finally
    //   18	70	171	finally
    //   86	120	171	finally
    //   120	160	171	finally
    //   164	171	171	finally
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        Drawable localDrawable = this.mCurrentDrawable;
        if (localDrawable != null)
        {
          j = Math.max(this.mMinWidth, Math.min(this.mMaxWidth, localDrawable.getIntrinsicWidth()));
          i = Math.max(this.mMinHeight, Math.min(this.mMaxHeight, localDrawable.getIntrinsicHeight()));
          updateDrawableState();
          int k = getPaddingLeft();
          int m = getPaddingRight();
          int n = getPaddingTop();
          int i1 = getPaddingBottom();
          setMeasuredDimension(resolveSize(j + (k + m), paramInt1), resolveSize(i + (n + i1), paramInt2));
          return;
        }
      }
      finally {}
      int j = 0;
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (ProgressBarICS.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    setProgress(paramParcelable.progress);
    setSecondaryProgress(paramParcelable.secondaryProgress);
  }
  
  public Parcelable onSaveInstanceState()
  {
    ProgressBarICS.SavedState localSavedState = new ProgressBarICS.SavedState(super.onSaveInstanceState());
    localSavedState.progress = this.mProgress;
    localSavedState.secondaryProgress = this.mSecondaryProgress;
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    updateDrawableBounds(paramInt1, paramInt2);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (this.mIndeterminate)
    {
      if ((paramInt == 8) || (paramInt == 4)) {
        stopAnimation();
      }
    }
    else {
      return;
    }
    startAnimation();
  }
  
  public void postInvalidate()
  {
    if (!this.mNoInvalidate) {
      super.postInvalidate();
    }
  }
  
  /* Error */
  public void setIndeterminate(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 120	android/support/v7/internal/widget/ProgressBarICS:mOnlyIndeterminate	Z
    //   6: ifeq +10 -> 16
    //   9: aload_0
    //   10: getfield 114	android/support/v7/internal/widget/ProgressBarICS:mIndeterminate	Z
    //   13: ifne +32 -> 45
    //   16: iload_1
    //   17: aload_0
    //   18: getfield 114	android/support/v7/internal/widget/ProgressBarICS:mIndeterminate	Z
    //   21: if_icmpeq +24 -> 45
    //   24: aload_0
    //   25: iload_1
    //   26: putfield 114	android/support/v7/internal/widget/ProgressBarICS:mIndeterminate	Z
    //   29: iload_1
    //   30: ifeq +18 -> 48
    //   33: aload_0
    //   34: aload_0
    //   35: getfield 313	android/support/v7/internal/widget/ProgressBarICS:mIndeterminateDrawable	Landroid/graphics/drawable/Drawable;
    //   38: putfield 181	android/support/v7/internal/widget/ProgressBarICS:mCurrentDrawable	Landroid/graphics/drawable/Drawable;
    //   41: aload_0
    //   42: invokevirtual 402	android/support/v7/internal/widget/ProgressBarICS:startAnimation	()V
    //   45: aload_0
    //   46: monitorexit
    //   47: return
    //   48: aload_0
    //   49: aload_0
    //   50: getfield 325	android/support/v7/internal/widget/ProgressBarICS:mProgressDrawable	Landroid/graphics/drawable/Drawable;
    //   53: putfield 181	android/support/v7/internal/widget/ProgressBarICS:mCurrentDrawable	Landroid/graphics/drawable/Drawable;
    //   56: aload_0
    //   57: invokevirtual 406	android/support/v7/internal/widget/ProgressBarICS:stopAnimation	()V
    //   60: goto -15 -> 45
    //   63: astore_2
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_2
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	ProgressBarICS
    //   0	68	1	paramBoolean	boolean
    //   63	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	16	63	finally
    //   16	29	63	finally
    //   33	45	63	finally
    //   48	60	63	finally
  }
  
  public void setIndeterminateDrawable(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      paramDrawable.setCallback(this);
    }
    this.mIndeterminateDrawable = paramDrawable;
    if (this.mIndeterminate)
    {
      this.mCurrentDrawable = paramDrawable;
      postInvalidate();
    }
  }
  
  public void setInterpolator(Context paramContext, int paramInt)
  {
    setInterpolator(AnimationUtils.loadInterpolator(paramContext, paramInt));
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    this.mInterpolator = paramInterpolator;
  }
  
  public void setMax(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    try
    {
      if (i != this.mMax)
      {
        this.mMax = i;
        postInvalidate();
        if (this.mProgress > i) {
          this.mProgress = i;
        }
        refreshProgress(16908301, this.mProgress, false);
      }
      return;
    }
    finally {}
  }
  
  public void setProgress(int paramInt)
  {
    try
    {
      setProgress(paramInt, false);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void setProgress(int paramInt, boolean paramBoolean)
  {
    try
    {
      boolean bool = this.mIndeterminate;
      if (bool) {
        return;
      }
      if (paramInt < 0) {
        paramInt = 0;
      }
      for (;;)
      {
        int i = paramInt;
        if (paramInt > this.mMax) {
          i = this.mMax;
        }
        if (i == this.mProgress) {
          break;
        }
        this.mProgress = i;
        refreshProgress(16908301, this.mProgress, paramBoolean);
        break;
      }
    }
    finally {}
  }
  
  public void setProgressDrawable(Drawable paramDrawable)
  {
    if ((this.mProgressDrawable != null) && (paramDrawable != this.mProgressDrawable)) {
      this.mProgressDrawable.setCallback(null);
    }
    for (int i = 1;; i = 0)
    {
      if (paramDrawable != null)
      {
        paramDrawable.setCallback(this);
        int j = paramDrawable.getMinimumHeight();
        if (this.mMaxHeight < j)
        {
          this.mMaxHeight = j;
          requestLayout();
        }
      }
      this.mProgressDrawable = paramDrawable;
      if (!this.mIndeterminate)
      {
        this.mCurrentDrawable = paramDrawable;
        postInvalidate();
      }
      if (i != 0)
      {
        updateDrawableBounds(getWidth(), getHeight());
        updateDrawableState();
        doRefreshProgress(16908301, this.mProgress, false, false);
        doRefreshProgress(16908303, this.mSecondaryProgress, false, false);
      }
      return;
    }
  }
  
  public void setSecondaryProgress(int paramInt)
  {
    int i = 0;
    try
    {
      boolean bool = this.mIndeterminate;
      if (bool) {
        return;
      }
      if (paramInt < 0) {
        paramInt = i;
      }
      for (;;)
      {
        i = paramInt;
        if (paramInt > this.mMax) {
          i = this.mMax;
        }
        if (i == this.mSecondaryProgress) {
          break;
        }
        this.mSecondaryProgress = i;
        refreshProgress(16908303, this.mSecondaryProgress, false);
        break;
      }
    }
    finally {}
  }
  
  public void setVisibility(int paramInt)
  {
    if (getVisibility() != paramInt)
    {
      super.setVisibility(paramInt);
      if (this.mIndeterminate)
      {
        if ((paramInt != 8) && (paramInt != 4)) {
          break label36;
        }
        stopAnimation();
      }
    }
    return;
    label36:
    startAnimation();
  }
  
  void startAnimation()
  {
    if (getVisibility() != 0) {
      return;
    }
    if ((this.mIndeterminateDrawable instanceof Animatable))
    {
      this.mShouldStartAnimationDrawable = true;
      this.mAnimation = null;
    }
    for (;;)
    {
      postInvalidate();
      return;
      if (this.mInterpolator == null) {
        this.mInterpolator = new LinearInterpolator();
      }
      this.mTransformation = new Transformation();
      this.mAnimation = new AlphaAnimation(0.0F, 1.0F);
      this.mAnimation.setRepeatMode(this.mBehavior);
      this.mAnimation.setRepeatCount(-1);
      this.mAnimation.setDuration(this.mDuration);
      this.mAnimation.setInterpolator(this.mInterpolator);
      this.mAnimation.setStartTime(-1L);
    }
  }
  
  void stopAnimation()
  {
    this.mAnimation = null;
    this.mTransformation = null;
    if ((this.mIndeterminateDrawable instanceof Animatable))
    {
      ((Animatable)this.mIndeterminateDrawable).stop();
      this.mShouldStartAnimationDrawable = false;
    }
    postInvalidate();
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (paramDrawable == this.mProgressDrawable) || (paramDrawable == this.mIndeterminateDrawable) || (super.verifyDrawable(paramDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.widget.ProgressBarICS
 * JD-Core Version:    0.7.0.1
 */