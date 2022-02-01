package androidx.appcompat.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.DrawableCompat;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
class DrawableContainer
  extends Drawable
  implements Drawable.Callback
{
  private static final boolean DEBUG = false;
  private static final boolean DEFAULT_DITHER = true;
  private static final String TAG = "DrawableContainer";
  private int mAlpha = 255;
  private Runnable mAnimationRunnable;
  private BlockInvalidateCallback mBlockInvalidateCallback;
  private int mCurIndex = -1;
  private Drawable mCurrDrawable;
  private DrawableContainerState mDrawableContainerState;
  private long mEnterAnimationEnd;
  private long mExitAnimationEnd;
  private boolean mHasAlpha;
  private Rect mHotspotBounds;
  private Drawable mLastDrawable;
  private int mLastIndex = -1;
  private boolean mMutated;
  
  /* Error */
  private void initializeDrawableForDisplay(Drawable paramDrawable)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 60	androidx/appcompat/graphics/drawable/DrawableContainer:mBlockInvalidateCallback	Landroidx/appcompat/graphics/drawable/DrawableContainer$BlockInvalidateCallback;
    //   4: ifnonnull +14 -> 18
    //   7: aload_0
    //   8: new 8	androidx/appcompat/graphics/drawable/DrawableContainer$BlockInvalidateCallback
    //   11: dup
    //   12: invokespecial 61	androidx/appcompat/graphics/drawable/DrawableContainer$BlockInvalidateCallback:<init>	()V
    //   15: putfield 60	androidx/appcompat/graphics/drawable/DrawableContainer:mBlockInvalidateCallback	Landroidx/appcompat/graphics/drawable/DrawableContainer$BlockInvalidateCallback;
    //   18: aload_1
    //   19: aload_0
    //   20: getfield 60	androidx/appcompat/graphics/drawable/DrawableContainer:mBlockInvalidateCallback	Landroidx/appcompat/graphics/drawable/DrawableContainer$BlockInvalidateCallback;
    //   23: aload_1
    //   24: invokevirtual 65	android/graphics/drawable/Drawable:getCallback	()Landroid/graphics/drawable/Drawable$Callback;
    //   27: invokevirtual 69	androidx/appcompat/graphics/drawable/DrawableContainer$BlockInvalidateCallback:wrap	(Landroid/graphics/drawable/Drawable$Callback;)Landroidx/appcompat/graphics/drawable/DrawableContainer$BlockInvalidateCallback;
    //   30: invokevirtual 73	android/graphics/drawable/Drawable:setCallback	(Landroid/graphics/drawable/Drawable$Callback;)V
    //   33: aload_0
    //   34: getfield 75	androidx/appcompat/graphics/drawable/DrawableContainer:mDrawableContainerState	Landroidx/appcompat/graphics/drawable/DrawableContainer$DrawableContainerState;
    //   37: getfield 78	androidx/appcompat/graphics/drawable/DrawableContainer$DrawableContainerState:mEnterFadeDuration	I
    //   40: ifgt +18 -> 58
    //   43: aload_0
    //   44: getfield 80	androidx/appcompat/graphics/drawable/DrawableContainer:mHasAlpha	Z
    //   47: ifeq +11 -> 58
    //   50: aload_1
    //   51: aload_0
    //   52: getfield 51	androidx/appcompat/graphics/drawable/DrawableContainer:mAlpha	I
    //   55: invokevirtual 84	android/graphics/drawable/Drawable:setAlpha	(I)V
    //   58: aload_0
    //   59: getfield 75	androidx/appcompat/graphics/drawable/DrawableContainer:mDrawableContainerState	Landroidx/appcompat/graphics/drawable/DrawableContainer$DrawableContainerState;
    //   62: getfield 87	androidx/appcompat/graphics/drawable/DrawableContainer$DrawableContainerState:mHasColorFilter	Z
    //   65: ifeq +146 -> 211
    //   68: aload_1
    //   69: aload_0
    //   70: getfield 75	androidx/appcompat/graphics/drawable/DrawableContainer:mDrawableContainerState	Landroidx/appcompat/graphics/drawable/DrawableContainer$DrawableContainerState;
    //   73: getfield 91	androidx/appcompat/graphics/drawable/DrawableContainer$DrawableContainerState:mColorFilter	Landroid/graphics/ColorFilter;
    //   76: invokevirtual 95	android/graphics/drawable/Drawable:setColorFilter	(Landroid/graphics/ColorFilter;)V
    //   79: aload_1
    //   80: aload_0
    //   81: invokevirtual 99	androidx/appcompat/graphics/drawable/DrawableContainer:isVisible	()Z
    //   84: iconst_1
    //   85: invokevirtual 103	android/graphics/drawable/Drawable:setVisible	(ZZ)Z
    //   88: pop
    //   89: aload_1
    //   90: aload_0
    //   91: getfield 75	androidx/appcompat/graphics/drawable/DrawableContainer:mDrawableContainerState	Landroidx/appcompat/graphics/drawable/DrawableContainer$DrawableContainerState;
    //   94: getfield 106	androidx/appcompat/graphics/drawable/DrawableContainer$DrawableContainerState:mDither	Z
    //   97: invokevirtual 110	android/graphics/drawable/Drawable:setDither	(Z)V
    //   100: aload_1
    //   101: aload_0
    //   102: invokevirtual 114	androidx/appcompat/graphics/drawable/DrawableContainer:getState	()[I
    //   105: invokevirtual 118	android/graphics/drawable/Drawable:setState	([I)Z
    //   108: pop
    //   109: aload_1
    //   110: aload_0
    //   111: invokevirtual 122	androidx/appcompat/graphics/drawable/DrawableContainer:getLevel	()I
    //   114: invokevirtual 126	android/graphics/drawable/Drawable:setLevel	(I)Z
    //   117: pop
    //   118: aload_1
    //   119: aload_0
    //   120: invokevirtual 130	androidx/appcompat/graphics/drawable/DrawableContainer:getBounds	()Landroid/graphics/Rect;
    //   123: invokevirtual 134	android/graphics/drawable/Drawable:setBounds	(Landroid/graphics/Rect;)V
    //   126: getstatic 139	android/os/Build$VERSION:SDK_INT	I
    //   129: bipush 23
    //   131: if_icmplt +12 -> 143
    //   134: aload_1
    //   135: aload_0
    //   136: invokevirtual 142	androidx/appcompat/graphics/drawable/DrawableContainer:getLayoutDirection	()I
    //   139: invokevirtual 145	android/graphics/drawable/Drawable:setLayoutDirection	(I)Z
    //   142: pop
    //   143: getstatic 139	android/os/Build$VERSION:SDK_INT	I
    //   146: bipush 19
    //   148: if_icmplt +14 -> 162
    //   151: aload_1
    //   152: aload_0
    //   153: getfield 75	androidx/appcompat/graphics/drawable/DrawableContainer:mDrawableContainerState	Landroidx/appcompat/graphics/drawable/DrawableContainer$DrawableContainerState;
    //   156: getfield 148	androidx/appcompat/graphics/drawable/DrawableContainer$DrawableContainerState:mAutoMirrored	Z
    //   159: invokevirtual 151	android/graphics/drawable/Drawable:setAutoMirrored	(Z)V
    //   162: aload_0
    //   163: getfield 153	androidx/appcompat/graphics/drawable/DrawableContainer:mHotspotBounds	Landroid/graphics/Rect;
    //   166: astore_2
    //   167: getstatic 139	android/os/Build$VERSION:SDK_INT	I
    //   170: bipush 21
    //   172: if_icmplt +27 -> 199
    //   175: aload_2
    //   176: ifnull +23 -> 199
    //   179: aload_1
    //   180: aload_2
    //   181: getfield 158	android/graphics/Rect:left	I
    //   184: aload_2
    //   185: getfield 161	android/graphics/Rect:top	I
    //   188: aload_2
    //   189: getfield 164	android/graphics/Rect:right	I
    //   192: aload_2
    //   193: getfield 167	android/graphics/Rect:bottom	I
    //   196: invokevirtual 171	android/graphics/drawable/Drawable:setHotspotBounds	(IIII)V
    //   199: aload_1
    //   200: aload_0
    //   201: getfield 60	androidx/appcompat/graphics/drawable/DrawableContainer:mBlockInvalidateCallback	Landroidx/appcompat/graphics/drawable/DrawableContainer$BlockInvalidateCallback;
    //   204: invokevirtual 174	androidx/appcompat/graphics/drawable/DrawableContainer$BlockInvalidateCallback:unwrap	()Landroid/graphics/drawable/Drawable$Callback;
    //   207: invokevirtual 73	android/graphics/drawable/Drawable:setCallback	(Landroid/graphics/drawable/Drawable$Callback;)V
    //   210: return
    //   211: aload_0
    //   212: getfield 75	androidx/appcompat/graphics/drawable/DrawableContainer:mDrawableContainerState	Landroidx/appcompat/graphics/drawable/DrawableContainer$DrawableContainerState;
    //   215: getfield 177	androidx/appcompat/graphics/drawable/DrawableContainer$DrawableContainerState:mHasTintList	Z
    //   218: ifeq +14 -> 232
    //   221: aload_1
    //   222: aload_0
    //   223: getfield 75	androidx/appcompat/graphics/drawable/DrawableContainer:mDrawableContainerState	Landroidx/appcompat/graphics/drawable/DrawableContainer$DrawableContainerState;
    //   226: getfield 181	androidx/appcompat/graphics/drawable/DrawableContainer$DrawableContainerState:mTintList	Landroid/content/res/ColorStateList;
    //   229: invokestatic 187	androidx/core/graphics/drawable/DrawableCompat:setTintList	(Landroid/graphics/drawable/Drawable;Landroid/content/res/ColorStateList;)V
    //   232: aload_0
    //   233: getfield 75	androidx/appcompat/graphics/drawable/DrawableContainer:mDrawableContainerState	Landroidx/appcompat/graphics/drawable/DrawableContainer$DrawableContainerState;
    //   236: getfield 190	androidx/appcompat/graphics/drawable/DrawableContainer$DrawableContainerState:mHasTintMode	Z
    //   239: ifeq -160 -> 79
    //   242: aload_1
    //   243: aload_0
    //   244: getfield 75	androidx/appcompat/graphics/drawable/DrawableContainer:mDrawableContainerState	Landroidx/appcompat/graphics/drawable/DrawableContainer$DrawableContainerState;
    //   247: getfield 194	androidx/appcompat/graphics/drawable/DrawableContainer$DrawableContainerState:mTintMode	Landroid/graphics/PorterDuff$Mode;
    //   250: invokestatic 198	androidx/core/graphics/drawable/DrawableCompat:setTintMode	(Landroid/graphics/drawable/Drawable;Landroid/graphics/PorterDuff$Mode;)V
    //   253: goto -174 -> 79
    //   256: astore_2
    //   257: aload_1
    //   258: aload_0
    //   259: getfield 60	androidx/appcompat/graphics/drawable/DrawableContainer:mBlockInvalidateCallback	Landroidx/appcompat/graphics/drawable/DrawableContainer$BlockInvalidateCallback;
    //   262: invokevirtual 174	androidx/appcompat/graphics/drawable/DrawableContainer$BlockInvalidateCallback:unwrap	()Landroid/graphics/drawable/Drawable$Callback;
    //   265: invokevirtual 73	android/graphics/drawable/Drawable:setCallback	(Landroid/graphics/drawable/Drawable$Callback;)V
    //   268: aload_2
    //   269: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	270	0	this	DrawableContainer
    //   0	270	1	paramDrawable	Drawable
    //   166	27	2	localRect	Rect
    //   256	13	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   33	58	256	finally
    //   58	79	256	finally
    //   79	143	256	finally
    //   143	162	256	finally
    //   162	175	256	finally
    //   179	199	256	finally
    //   211	232	256	finally
    //   232	253	256	finally
  }
  
  private boolean needsMirroring()
  {
    return (isAutoMirrored()) && (DrawableCompat.getLayoutDirection(this) == 1);
  }
  
  static int resolveDensity(@Nullable Resources paramResources, int paramInt)
  {
    if (paramResources == null) {}
    for (;;)
    {
      int i = paramInt;
      if (paramInt == 0) {
        i = 160;
      }
      return i;
      paramInt = paramResources.getDisplayMetrics().densityDpi;
    }
  }
  
  void animate(boolean paramBoolean)
  {
    this.mHasAlpha = true;
    long l = SystemClock.uptimeMillis();
    int i;
    int j;
    if (this.mCurrDrawable != null)
    {
      if (this.mEnterAnimationEnd == 0L) {
        break label184;
      }
      if (this.mEnterAnimationEnd <= l)
      {
        this.mCurrDrawable.setAlpha(this.mAlpha);
        this.mEnterAnimationEnd = 0L;
        i = 0;
        if (this.mLastDrawable == null) {
          break label232;
        }
        j = i;
        if (this.mExitAnimationEnd != 0L)
        {
          if (this.mExitAnimationEnd > l) {
            break label189;
          }
          this.mLastDrawable.setVisible(false, false);
          this.mLastDrawable = null;
          this.mLastIndex = -1;
          this.mExitAnimationEnd = 0L;
          j = i;
        }
      }
    }
    for (;;)
    {
      if ((paramBoolean) && (j != 0)) {
        scheduleSelf(this.mAnimationRunnable, 16L + l);
      }
      return;
      i = (int)((this.mEnterAnimationEnd - l) * 255L) / this.mDrawableContainerState.mEnterFadeDuration;
      this.mCurrDrawable.setAlpha((255 - i) * this.mAlpha / 255);
      i = 1;
      break;
      this.mEnterAnimationEnd = 0L;
      label184:
      i = 0;
      break;
      label189:
      i = (int)((this.mExitAnimationEnd - l) * 255L) / this.mDrawableContainerState.mExitFadeDuration;
      this.mLastDrawable.setAlpha(i * this.mAlpha / 255);
      j = 1;
      continue;
      label232:
      this.mExitAnimationEnd = 0L;
      j = i;
    }
  }
  
  @RequiresApi(21)
  public void applyTheme(@NonNull Resources.Theme paramTheme)
  {
    this.mDrawableContainerState.applyTheme(paramTheme);
  }
  
  @RequiresApi(21)
  public boolean canApplyTheme()
  {
    return this.mDrawableContainerState.canApplyTheme();
  }
  
  void clearMutated()
  {
    this.mDrawableContainerState.clearMutated();
    this.mMutated = false;
  }
  
  DrawableContainerState cloneConstantState()
  {
    return this.mDrawableContainerState;
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    if (this.mCurrDrawable != null) {
      this.mCurrDrawable.draw(paramCanvas);
    }
    if (this.mLastDrawable != null) {
      this.mLastDrawable.draw(paramCanvas);
    }
  }
  
  public int getAlpha()
  {
    return this.mAlpha;
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.mDrawableContainerState.getChangingConfigurations();
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    if (this.mDrawableContainerState.canConstantState())
    {
      this.mDrawableContainerState.mChangingConfigurations = getChangingConfigurations();
      return this.mDrawableContainerState;
    }
    return null;
  }
  
  @NonNull
  public Drawable getCurrent()
  {
    return this.mCurrDrawable;
  }
  
  int getCurrentIndex()
  {
    return this.mCurIndex;
  }
  
  public void getHotspotBounds(@NonNull Rect paramRect)
  {
    if (this.mHotspotBounds != null)
    {
      paramRect.set(this.mHotspotBounds);
      return;
    }
    super.getHotspotBounds(paramRect);
  }
  
  public int getIntrinsicHeight()
  {
    if (this.mDrawableContainerState.isConstantSize()) {
      return this.mDrawableContainerState.getConstantHeight();
    }
    if (this.mCurrDrawable != null) {
      return this.mCurrDrawable.getIntrinsicHeight();
    }
    return -1;
  }
  
  public int getIntrinsicWidth()
  {
    if (this.mDrawableContainerState.isConstantSize()) {
      return this.mDrawableContainerState.getConstantWidth();
    }
    if (this.mCurrDrawable != null) {
      return this.mCurrDrawable.getIntrinsicWidth();
    }
    return -1;
  }
  
  public int getMinimumHeight()
  {
    if (this.mDrawableContainerState.isConstantSize()) {
      return this.mDrawableContainerState.getConstantMinimumHeight();
    }
    if (this.mCurrDrawable != null) {
      return this.mCurrDrawable.getMinimumHeight();
    }
    return 0;
  }
  
  public int getMinimumWidth()
  {
    if (this.mDrawableContainerState.isConstantSize()) {
      return this.mDrawableContainerState.getConstantMinimumWidth();
    }
    if (this.mCurrDrawable != null) {
      return this.mCurrDrawable.getMinimumWidth();
    }
    return 0;
  }
  
  public int getOpacity()
  {
    if ((this.mCurrDrawable == null) || (!this.mCurrDrawable.isVisible())) {
      return -2;
    }
    return this.mDrawableContainerState.getOpacity();
  }
  
  @RequiresApi(21)
  public void getOutline(@NonNull Outline paramOutline)
  {
    if (this.mCurrDrawable != null) {
      this.mCurrDrawable.getOutline(paramOutline);
    }
  }
  
  public boolean getPadding(@NonNull Rect paramRect)
  {
    Rect localRect = this.mDrawableContainerState.getConstantPadding();
    int i;
    boolean bool;
    if (localRect != null)
    {
      paramRect.set(localRect);
      i = localRect.left;
      int j = localRect.top;
      int k = localRect.bottom;
      if ((localRect.right | i | j | k) != 0) {
        bool = true;
      }
    }
    for (;;)
    {
      if (needsMirroring())
      {
        i = paramRect.left;
        paramRect.left = paramRect.right;
        paramRect.right = i;
      }
      return bool;
      bool = false;
      continue;
      if (this.mCurrDrawable != null) {
        bool = this.mCurrDrawable.getPadding(paramRect);
      } else {
        bool = super.getPadding(paramRect);
      }
    }
  }
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    if (this.mDrawableContainerState != null) {
      this.mDrawableContainerState.invalidateCache();
    }
    if ((paramDrawable == this.mCurrDrawable) && (getCallback() != null)) {
      getCallback().invalidateDrawable(this);
    }
  }
  
  public boolean isAutoMirrored()
  {
    return this.mDrawableContainerState.mAutoMirrored;
  }
  
  public boolean isStateful()
  {
    return this.mDrawableContainerState.isStateful();
  }
  
  public void jumpToCurrentState()
  {
    int j = 1;
    int i = 0;
    if (this.mLastDrawable != null)
    {
      this.mLastDrawable.jumpToCurrentState();
      this.mLastDrawable = null;
      this.mLastIndex = -1;
      i = 1;
    }
    if (this.mCurrDrawable != null)
    {
      this.mCurrDrawable.jumpToCurrentState();
      if (this.mHasAlpha) {
        this.mCurrDrawable.setAlpha(this.mAlpha);
      }
    }
    if (this.mExitAnimationEnd != 0L)
    {
      this.mExitAnimationEnd = 0L;
      i = 1;
    }
    if (this.mEnterAnimationEnd != 0L)
    {
      this.mEnterAnimationEnd = 0L;
      i = j;
    }
    for (;;)
    {
      if (i != 0) {
        invalidateSelf();
      }
      return;
    }
  }
  
  @NonNull
  public Drawable mutate()
  {
    if ((!this.mMutated) && (super.mutate() == this))
    {
      DrawableContainerState localDrawableContainerState = cloneConstantState();
      localDrawableContainerState.mutate();
      setConstantState(localDrawableContainerState);
      this.mMutated = true;
    }
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    if (this.mLastDrawable != null) {
      this.mLastDrawable.setBounds(paramRect);
    }
    if (this.mCurrDrawable != null) {
      this.mCurrDrawable.setBounds(paramRect);
    }
  }
  
  public boolean onLayoutDirectionChanged(int paramInt)
  {
    return this.mDrawableContainerState.setLayoutDirection(paramInt, getCurrentIndex());
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    if (this.mLastDrawable != null) {
      return this.mLastDrawable.setLevel(paramInt);
    }
    if (this.mCurrDrawable != null) {
      return this.mCurrDrawable.setLevel(paramInt);
    }
    return false;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    if (this.mLastDrawable != null) {
      return this.mLastDrawable.setState(paramArrayOfInt);
    }
    if (this.mCurrDrawable != null) {
      return this.mCurrDrawable.setState(paramArrayOfInt);
    }
    return false;
  }
  
  public void scheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable, long paramLong)
  {
    if ((paramDrawable == this.mCurrDrawable) && (getCallback() != null)) {
      getCallback().scheduleDrawable(this, paramRunnable, paramLong);
    }
  }
  
  boolean selectDrawable(int paramInt)
  {
    if (paramInt == this.mCurIndex) {
      return false;
    }
    long l = SystemClock.uptimeMillis();
    if (this.mDrawableContainerState.mExitFadeDuration > 0)
    {
      if (this.mLastDrawable != null) {
        this.mLastDrawable.setVisible(false, false);
      }
      if (this.mCurrDrawable != null)
      {
        this.mLastDrawable = this.mCurrDrawable;
        this.mLastIndex = this.mCurIndex;
        this.mExitAnimationEnd = (this.mDrawableContainerState.mExitFadeDuration + l);
        if ((paramInt < 0) || (paramInt >= this.mDrawableContainerState.mNumChildren)) {
          break label235;
        }
        Drawable localDrawable = this.mDrawableContainerState.getChild(paramInt);
        this.mCurrDrawable = localDrawable;
        this.mCurIndex = paramInt;
        if (localDrawable != null)
        {
          if (this.mDrawableContainerState.mEnterFadeDuration > 0) {
            this.mEnterAnimationEnd = (l + this.mDrawableContainerState.mEnterFadeDuration);
          }
          initializeDrawableForDisplay(localDrawable);
        }
        label149:
        if ((this.mEnterAnimationEnd != 0L) || (this.mExitAnimationEnd != 0L))
        {
          if (this.mAnimationRunnable != null) {
            break label248;
          }
          this.mAnimationRunnable = new DrawableContainer.1(this);
        }
      }
    }
    for (;;)
    {
      animate(true);
      invalidateSelf();
      return true;
      this.mLastDrawable = null;
      this.mLastIndex = -1;
      this.mExitAnimationEnd = 0L;
      break;
      if (this.mCurrDrawable == null) {
        break;
      }
      this.mCurrDrawable.setVisible(false, false);
      break;
      label235:
      this.mCurrDrawable = null;
      this.mCurIndex = -1;
      break label149;
      label248:
      unscheduleSelf(this.mAnimationRunnable);
    }
  }
  
  public void setAlpha(int paramInt)
  {
    if ((!this.mHasAlpha) || (this.mAlpha != paramInt))
    {
      this.mHasAlpha = true;
      this.mAlpha = paramInt;
      if (this.mCurrDrawable != null)
      {
        if (this.mEnterAnimationEnd != 0L) {
          break label50;
        }
        this.mCurrDrawable.setAlpha(paramInt);
      }
    }
    return;
    label50:
    animate(false);
  }
  
  public void setAutoMirrored(boolean paramBoolean)
  {
    if (this.mDrawableContainerState.mAutoMirrored != paramBoolean)
    {
      this.mDrawableContainerState.mAutoMirrored = paramBoolean;
      if (this.mCurrDrawable != null) {
        DrawableCompat.setAutoMirrored(this.mCurrDrawable, this.mDrawableContainerState.mAutoMirrored);
      }
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mDrawableContainerState.mHasColorFilter = true;
    if (this.mDrawableContainerState.mColorFilter != paramColorFilter)
    {
      this.mDrawableContainerState.mColorFilter = paramColorFilter;
      if (this.mCurrDrawable != null) {
        this.mCurrDrawable.setColorFilter(paramColorFilter);
      }
    }
  }
  
  void setConstantState(DrawableContainerState paramDrawableContainerState)
  {
    this.mDrawableContainerState = paramDrawableContainerState;
    if (this.mCurIndex >= 0)
    {
      this.mCurrDrawable = paramDrawableContainerState.getChild(this.mCurIndex);
      if (this.mCurrDrawable != null) {
        initializeDrawableForDisplay(this.mCurrDrawable);
      }
    }
    this.mLastIndex = -1;
    this.mLastDrawable = null;
  }
  
  void setCurrentIndex(int paramInt)
  {
    selectDrawable(paramInt);
  }
  
  public void setDither(boolean paramBoolean)
  {
    if (this.mDrawableContainerState.mDither != paramBoolean)
    {
      this.mDrawableContainerState.mDither = paramBoolean;
      if (this.mCurrDrawable != null) {
        this.mCurrDrawable.setDither(this.mDrawableContainerState.mDither);
      }
    }
  }
  
  public void setEnterFadeDuration(int paramInt)
  {
    this.mDrawableContainerState.mEnterFadeDuration = paramInt;
  }
  
  public void setExitFadeDuration(int paramInt)
  {
    this.mDrawableContainerState.mExitFadeDuration = paramInt;
  }
  
  public void setHotspot(float paramFloat1, float paramFloat2)
  {
    if (this.mCurrDrawable != null) {
      DrawableCompat.setHotspot(this.mCurrDrawable, paramFloat1, paramFloat2);
    }
  }
  
  public void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mHotspotBounds == null) {
      this.mHotspotBounds = new Rect(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    for (;;)
    {
      if (this.mCurrDrawable != null) {
        DrawableCompat.setHotspotBounds(this.mCurrDrawable, paramInt1, paramInt2, paramInt3, paramInt4);
      }
      return;
      this.mHotspotBounds.set(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    this.mDrawableContainerState.mHasTintList = true;
    if (this.mDrawableContainerState.mTintList != paramColorStateList)
    {
      this.mDrawableContainerState.mTintList = paramColorStateList;
      DrawableCompat.setTintList(this.mCurrDrawable, paramColorStateList);
    }
  }
  
  public void setTintMode(@NonNull PorterDuff.Mode paramMode)
  {
    this.mDrawableContainerState.mHasTintMode = true;
    if (this.mDrawableContainerState.mTintMode != paramMode)
    {
      this.mDrawableContainerState.mTintMode = paramMode;
      DrawableCompat.setTintMode(this.mCurrDrawable, paramMode);
    }
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    if (this.mLastDrawable != null) {
      this.mLastDrawable.setVisible(paramBoolean1, paramBoolean2);
    }
    if (this.mCurrDrawable != null) {
      this.mCurrDrawable.setVisible(paramBoolean1, paramBoolean2);
    }
    return bool;
  }
  
  public void unscheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable)
  {
    if ((paramDrawable == this.mCurrDrawable) && (getCallback() != null)) {
      getCallback().unscheduleDrawable(this, paramRunnable);
    }
  }
  
  final void updateDensity(Resources paramResources)
  {
    this.mDrawableContainerState.updateDensity(paramResources);
  }
  
  static class BlockInvalidateCallback
    implements Drawable.Callback
  {
    private Drawable.Callback mCallback;
    
    public void invalidateDrawable(@NonNull Drawable paramDrawable) {}
    
    public void scheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable, long paramLong)
    {
      if (this.mCallback != null) {
        this.mCallback.scheduleDrawable(paramDrawable, paramRunnable, paramLong);
      }
    }
    
    public void unscheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable)
    {
      if (this.mCallback != null) {
        this.mCallback.unscheduleDrawable(paramDrawable, paramRunnable);
      }
    }
    
    public Drawable.Callback unwrap()
    {
      Drawable.Callback localCallback = this.mCallback;
      this.mCallback = null;
      return localCallback;
    }
    
    public BlockInvalidateCallback wrap(Drawable.Callback paramCallback)
    {
      this.mCallback = paramCallback;
      return this;
    }
  }
  
  static abstract class DrawableContainerState
    extends Drawable.ConstantState
  {
    boolean mAutoMirrored;
    boolean mCanConstantState;
    int mChangingConfigurations;
    boolean mCheckedConstantSize;
    boolean mCheckedConstantState;
    boolean mCheckedOpacity;
    boolean mCheckedPadding;
    boolean mCheckedStateful;
    int mChildrenChangingConfigurations;
    ColorFilter mColorFilter;
    int mConstantHeight;
    int mConstantMinimumHeight;
    int mConstantMinimumWidth;
    Rect mConstantPadding;
    boolean mConstantSize = false;
    int mConstantWidth;
    int mDensity = 160;
    boolean mDither = true;
    SparseArray<Drawable.ConstantState> mDrawableFutures;
    Drawable[] mDrawables;
    int mEnterFadeDuration = 0;
    int mExitFadeDuration = 0;
    boolean mHasColorFilter;
    boolean mHasTintList;
    boolean mHasTintMode;
    int mLayoutDirection;
    boolean mMutated;
    int mNumChildren;
    int mOpacity;
    final DrawableContainer mOwner;
    Resources mSourceRes;
    boolean mStateful;
    ColorStateList mTintList;
    PorterDuff.Mode mTintMode;
    boolean mVariablePadding = false;
    
    DrawableContainerState(DrawableContainerState paramDrawableContainerState, DrawableContainer paramDrawableContainer, Resources paramResources)
    {
      this.mOwner = paramDrawableContainer;
      int i;
      if (paramResources != null)
      {
        paramDrawableContainer = paramResources;
        this.mSourceRes = paramDrawableContainer;
        if (paramDrawableContainerState == null) {
          break label450;
        }
        i = paramDrawableContainerState.mDensity;
        label65:
        this.mDensity = DrawableContainer.resolveDensity(paramResources, i);
        if (paramDrawableContainerState == null) {
          break label488;
        }
        this.mChangingConfigurations = paramDrawableContainerState.mChangingConfigurations;
        this.mChildrenChangingConfigurations = paramDrawableContainerState.mChildrenChangingConfigurations;
        this.mCheckedConstantState = true;
        this.mCanConstantState = true;
        this.mVariablePadding = paramDrawableContainerState.mVariablePadding;
        this.mConstantSize = paramDrawableContainerState.mConstantSize;
        this.mDither = paramDrawableContainerState.mDither;
        this.mMutated = paramDrawableContainerState.mMutated;
        this.mLayoutDirection = paramDrawableContainerState.mLayoutDirection;
        this.mEnterFadeDuration = paramDrawableContainerState.mEnterFadeDuration;
        this.mExitFadeDuration = paramDrawableContainerState.mExitFadeDuration;
        this.mAutoMirrored = paramDrawableContainerState.mAutoMirrored;
        this.mColorFilter = paramDrawableContainerState.mColorFilter;
        this.mHasColorFilter = paramDrawableContainerState.mHasColorFilter;
        this.mTintList = paramDrawableContainerState.mTintList;
        this.mTintMode = paramDrawableContainerState.mTintMode;
        this.mHasTintList = paramDrawableContainerState.mHasTintList;
        this.mHasTintMode = paramDrawableContainerState.mHasTintMode;
        if (paramDrawableContainerState.mDensity == this.mDensity)
        {
          if (paramDrawableContainerState.mCheckedPadding)
          {
            this.mConstantPadding = new Rect(paramDrawableContainerState.mConstantPadding);
            this.mCheckedPadding = true;
          }
          if (paramDrawableContainerState.mCheckedConstantSize)
          {
            this.mConstantWidth = paramDrawableContainerState.mConstantWidth;
            this.mConstantHeight = paramDrawableContainerState.mConstantHeight;
            this.mConstantMinimumWidth = paramDrawableContainerState.mConstantMinimumWidth;
            this.mConstantMinimumHeight = paramDrawableContainerState.mConstantMinimumHeight;
            this.mCheckedConstantSize = true;
          }
        }
        if (paramDrawableContainerState.mCheckedOpacity)
        {
          this.mOpacity = paramDrawableContainerState.mOpacity;
          this.mCheckedOpacity = true;
        }
        if (paramDrawableContainerState.mCheckedStateful)
        {
          this.mStateful = paramDrawableContainerState.mStateful;
          this.mCheckedStateful = true;
        }
        paramDrawableContainer = paramDrawableContainerState.mDrawables;
        this.mDrawables = new Drawable[paramDrawableContainer.length];
        this.mNumChildren = paramDrawableContainerState.mNumChildren;
        paramDrawableContainerState = paramDrawableContainerState.mDrawableFutures;
        if (paramDrawableContainerState == null) {
          break label456;
        }
        this.mDrawableFutures = paramDrawableContainerState.clone();
        label378:
        int k = this.mNumChildren;
        i = j;
        label388:
        if (i >= k) {
          return;
        }
        if (paramDrawableContainer[i] != null)
        {
          paramDrawableContainerState = paramDrawableContainer[i].getConstantState();
          if (paramDrawableContainerState == null) {
            break label474;
          }
          this.mDrawableFutures.put(i, paramDrawableContainerState);
        }
      }
      for (;;)
      {
        i += 1;
        break label388;
        if (paramDrawableContainerState != null)
        {
          paramDrawableContainer = paramDrawableContainerState.mSourceRes;
          break;
        }
        paramDrawableContainer = null;
        break;
        label450:
        i = 0;
        break label65;
        label456:
        this.mDrawableFutures = new SparseArray(this.mNumChildren);
        break label378;
        label474:
        this.mDrawables[i] = paramDrawableContainer[i];
      }
      label488:
      this.mDrawables = new Drawable[10];
      this.mNumChildren = 0;
    }
    
    private void createAllFutures()
    {
      if (this.mDrawableFutures != null)
      {
        int j = this.mDrawableFutures.size();
        int i = 0;
        while (i < j)
        {
          int k = this.mDrawableFutures.keyAt(i);
          Drawable.ConstantState localConstantState = (Drawable.ConstantState)this.mDrawableFutures.valueAt(i);
          this.mDrawables[k] = prepareDrawable(localConstantState.newDrawable(this.mSourceRes));
          i += 1;
        }
        this.mDrawableFutures = null;
      }
    }
    
    private Drawable prepareDrawable(Drawable paramDrawable)
    {
      if (Build.VERSION.SDK_INT >= 23) {
        paramDrawable.setLayoutDirection(this.mLayoutDirection);
      }
      paramDrawable = paramDrawable.mutate();
      paramDrawable.setCallback(this.mOwner);
      return paramDrawable;
    }
    
    public final int addChild(Drawable paramDrawable)
    {
      int i = this.mNumChildren;
      if (i >= this.mDrawables.length) {
        growArray(i, i + 10);
      }
      paramDrawable.mutate();
      paramDrawable.setVisible(false, true);
      paramDrawable.setCallback(this.mOwner);
      this.mDrawables[i] = paramDrawable;
      this.mNumChildren += 1;
      this.mChildrenChangingConfigurations |= paramDrawable.getChangingConfigurations();
      invalidateCache();
      this.mConstantPadding = null;
      this.mCheckedPadding = false;
      this.mCheckedConstantSize = false;
      this.mCheckedConstantState = false;
      return i;
    }
    
    @RequiresApi(21)
    final void applyTheme(Resources.Theme paramTheme)
    {
      if (paramTheme != null)
      {
        createAllFutures();
        int j = this.mNumChildren;
        Drawable[] arrayOfDrawable = this.mDrawables;
        int i = 0;
        while (i < j)
        {
          if ((arrayOfDrawable[i] != null) && (arrayOfDrawable[i].canApplyTheme()))
          {
            arrayOfDrawable[i].applyTheme(paramTheme);
            this.mChildrenChangingConfigurations |= arrayOfDrawable[i].getChangingConfigurations();
          }
          i += 1;
        }
        updateDensity(paramTheme.getResources());
      }
    }
    
    @RequiresApi(21)
    public boolean canApplyTheme()
    {
      int j = this.mNumChildren;
      Drawable[] arrayOfDrawable = this.mDrawables;
      int i = 0;
      while (i < j)
      {
        Object localObject = arrayOfDrawable[i];
        if (localObject != null)
        {
          if (((Drawable)localObject).canApplyTheme()) {
            return true;
          }
        }
        else
        {
          localObject = (Drawable.ConstantState)this.mDrawableFutures.get(i);
          if ((localObject != null) && (((Drawable.ConstantState)localObject).canApplyTheme())) {
            return true;
          }
        }
        i += 1;
      }
      return false;
    }
    
    public boolean canConstantState()
    {
      boolean bool = false;
      for (;;)
      {
        try
        {
          if (this.mCheckedConstantState)
          {
            bool = this.mCanConstantState;
            return bool;
          }
          createAllFutures();
          this.mCheckedConstantState = true;
          int j = this.mNumChildren;
          Drawable[] arrayOfDrawable = this.mDrawables;
          int i = 0;
          if (i >= j) {
            break label79;
          }
          if (arrayOfDrawable[i].getConstantState() == null)
          {
            this.mCanConstantState = false;
            continue;
          }
          i += 1;
        }
        finally {}
        continue;
        label79:
        this.mCanConstantState = true;
        bool = true;
      }
    }
    
    final void clearMutated()
    {
      this.mMutated = false;
    }
    
    protected void computeConstantSize()
    {
      int i = 0;
      this.mCheckedConstantSize = true;
      createAllFutures();
      int j = this.mNumChildren;
      Drawable[] arrayOfDrawable = this.mDrawables;
      this.mConstantHeight = -1;
      this.mConstantWidth = -1;
      this.mConstantMinimumHeight = 0;
      this.mConstantMinimumWidth = 0;
      while (i < j)
      {
        Drawable localDrawable = arrayOfDrawable[i];
        int k = localDrawable.getIntrinsicWidth();
        if (k > this.mConstantWidth) {
          this.mConstantWidth = k;
        }
        k = localDrawable.getIntrinsicHeight();
        if (k > this.mConstantHeight) {
          this.mConstantHeight = k;
        }
        k = localDrawable.getMinimumWidth();
        if (k > this.mConstantMinimumWidth) {
          this.mConstantMinimumWidth = k;
        }
        k = localDrawable.getMinimumHeight();
        if (k > this.mConstantMinimumHeight) {
          this.mConstantMinimumHeight = k;
        }
        i += 1;
      }
    }
    
    final int getCapacity()
    {
      return this.mDrawables.length;
    }
    
    public int getChangingConfigurations()
    {
      return this.mChangingConfigurations | this.mChildrenChangingConfigurations;
    }
    
    public final Drawable getChild(int paramInt)
    {
      Object localObject = this.mDrawables[paramInt];
      if (localObject != null) {}
      Drawable localDrawable;
      do
      {
        return localObject;
        if (this.mDrawableFutures == null) {
          break;
        }
        int i = this.mDrawableFutures.indexOfKey(paramInt);
        if (i < 0) {
          break;
        }
        localDrawable = prepareDrawable(((Drawable.ConstantState)this.mDrawableFutures.valueAt(i)).newDrawable(this.mSourceRes));
        this.mDrawables[paramInt] = localDrawable;
        this.mDrawableFutures.removeAt(i);
        localObject = localDrawable;
      } while (this.mDrawableFutures.size() != 0);
      this.mDrawableFutures = null;
      return localDrawable;
      return null;
    }
    
    public final int getChildCount()
    {
      return this.mNumChildren;
    }
    
    public final int getConstantHeight()
    {
      if (!this.mCheckedConstantSize) {
        computeConstantSize();
      }
      return this.mConstantHeight;
    }
    
    public final int getConstantMinimumHeight()
    {
      if (!this.mCheckedConstantSize) {
        computeConstantSize();
      }
      return this.mConstantMinimumHeight;
    }
    
    public final int getConstantMinimumWidth()
    {
      if (!this.mCheckedConstantSize) {
        computeConstantSize();
      }
      return this.mConstantMinimumWidth;
    }
    
    public final Rect getConstantPadding()
    {
      Object localObject1 = null;
      if (this.mVariablePadding) {
        return null;
      }
      if ((this.mConstantPadding != null) || (this.mCheckedPadding)) {
        return this.mConstantPadding;
      }
      createAllFutures();
      Rect localRect = new Rect();
      int j = this.mNumChildren;
      Drawable[] arrayOfDrawable = this.mDrawables;
      int i = 0;
      while (i < j)
      {
        Object localObject3 = localObject1;
        if (arrayOfDrawable[i].getPadding(localRect))
        {
          Object localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new Rect(0, 0, 0, 0);
          }
          if (localRect.left > ((Rect)localObject2).left) {
            ((Rect)localObject2).left = localRect.left;
          }
          if (localRect.top > ((Rect)localObject2).top) {
            ((Rect)localObject2).top = localRect.top;
          }
          if (localRect.right > ((Rect)localObject2).right) {
            ((Rect)localObject2).right = localRect.right;
          }
          localObject3 = localObject2;
          if (localRect.bottom > ((Rect)localObject2).bottom)
          {
            ((Rect)localObject2).bottom = localRect.bottom;
            localObject3 = localObject2;
          }
        }
        i += 1;
        localObject1 = localObject3;
      }
      this.mCheckedPadding = true;
      this.mConstantPadding = localObject1;
      return localObject1;
    }
    
    public final int getConstantWidth()
    {
      if (!this.mCheckedConstantSize) {
        computeConstantSize();
      }
      return this.mConstantWidth;
    }
    
    public final int getEnterFadeDuration()
    {
      return this.mEnterFadeDuration;
    }
    
    public final int getExitFadeDuration()
    {
      return this.mExitFadeDuration;
    }
    
    public final int getOpacity()
    {
      if (this.mCheckedOpacity) {
        return this.mOpacity;
      }
      createAllFutures();
      int k = this.mNumChildren;
      Drawable[] arrayOfDrawable = this.mDrawables;
      if (k > 0) {}
      for (int i = arrayOfDrawable[0].getOpacity();; i = -2)
      {
        int j = 1;
        while (j < k)
        {
          i = Drawable.resolveOpacity(i, arrayOfDrawable[j].getOpacity());
          j += 1;
        }
      }
      this.mOpacity = i;
      this.mCheckedOpacity = true;
      return i;
    }
    
    public void growArray(int paramInt1, int paramInt2)
    {
      Drawable[] arrayOfDrawable = new Drawable[paramInt2];
      System.arraycopy(this.mDrawables, 0, arrayOfDrawable, 0, paramInt1);
      this.mDrawables = arrayOfDrawable;
    }
    
    void invalidateCache()
    {
      this.mCheckedOpacity = false;
      this.mCheckedStateful = false;
    }
    
    public final boolean isConstantSize()
    {
      return this.mConstantSize;
    }
    
    public final boolean isStateful()
    {
      boolean bool2 = false;
      if (this.mCheckedStateful) {
        return this.mStateful;
      }
      createAllFutures();
      int j = this.mNumChildren;
      Drawable[] arrayOfDrawable = this.mDrawables;
      int i = 0;
      for (;;)
      {
        boolean bool1 = bool2;
        if (i < j)
        {
          if (arrayOfDrawable[i].isStateful()) {
            bool1 = true;
          }
        }
        else
        {
          this.mStateful = bool1;
          this.mCheckedStateful = true;
          return bool1;
        }
        i += 1;
      }
    }
    
    void mutate()
    {
      int j = this.mNumChildren;
      Drawable[] arrayOfDrawable = this.mDrawables;
      int i = 0;
      while (i < j)
      {
        if (arrayOfDrawable[i] != null) {
          arrayOfDrawable[i].mutate();
        }
        i += 1;
      }
      this.mMutated = true;
    }
    
    public final void setConstantSize(boolean paramBoolean)
    {
      this.mConstantSize = paramBoolean;
    }
    
    public final void setEnterFadeDuration(int paramInt)
    {
      this.mEnterFadeDuration = paramInt;
    }
    
    public final void setExitFadeDuration(int paramInt)
    {
      this.mExitFadeDuration = paramInt;
    }
    
    final boolean setLayoutDirection(int paramInt1, int paramInt2)
    {
      int j = this.mNumChildren;
      Drawable[] arrayOfDrawable = this.mDrawables;
      int i = 0;
      boolean bool1 = false;
      if (i < j)
      {
        if (arrayOfDrawable[i] == null) {
          break label72;
        }
        if (Build.VERSION.SDK_INT < 23) {
          break label79;
        }
      }
      label72:
      label79:
      for (boolean bool2 = arrayOfDrawable[i].setLayoutDirection(paramInt1);; bool2 = false)
      {
        if (i == paramInt2) {}
        for (;;)
        {
          i += 1;
          bool1 = bool2;
          break;
          this.mLayoutDirection = paramInt1;
          return bool1;
          bool2 = bool1;
        }
      }
    }
    
    public final void setVariablePadding(boolean paramBoolean)
    {
      this.mVariablePadding = paramBoolean;
    }
    
    final void updateDensity(Resources paramResources)
    {
      if (paramResources != null)
      {
        this.mSourceRes = paramResources;
        int i = DrawableContainer.resolveDensity(paramResources, this.mDensity);
        int j = this.mDensity;
        this.mDensity = i;
        if (j != i)
        {
          this.mCheckedConstantSize = false;
          this.mCheckedPadding = false;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.appcompat.graphics.drawable.DrawableContainer
 * JD-Core Version:    0.7.0.1
 */