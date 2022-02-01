package com.tencent.lottieNew;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.FloatRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.view.View.BaseSavedState;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import atau.a;
import com.tencent.mobileqq.dinifly.FontAssetDelegate;
import com.tencent.mobileqq.dinifly.ImageAssetDelegate;
import com.tencent.mobileqq.dinifly.L;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieCompositionFactory;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.LottieListener;
import com.tencent.mobileqq.dinifly.LottieOnCompositionLoadedListener;
import com.tencent.mobileqq.dinifly.LottieProperty;
import com.tencent.mobileqq.dinifly.LottieTask;
import com.tencent.mobileqq.dinifly.RenderMode;
import com.tencent.mobileqq.dinifly.SimpleColorFilter;
import com.tencent.mobileqq.dinifly.TextDelegate;
import com.tencent.mobileqq.dinifly.model.KeyPath;
import com.tencent.mobileqq.dinifly.value.LottieValueCallback;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import trq;

public class DiniFlyAnimationView
  extends ImageView
{
  private static final String TAG = com.tencent.mobileqq.dinifly.DiniFlyAnimationView.class.getSimpleName();
  public static int inDensity = 320;
  public static int inTargetDensity;
  private String animationName;
  private int animationResId;
  private boolean autoPlay = false;
  @Nullable
  private LottieComposition composition;
  @Nullable
  private LottieTask<LottieComposition> compositionTask;
  private final LottieListener<Throwable> failureListener = new a(null);
  private boolean fobiddenLayer;
  private final LottieListener<LottieComposition> loadedListener = new b(null);
  private final LottieDrawable lottieDrawable = new LottieDrawable();
  private Set<LottieOnCompositionLoadedListener> lottieOnCompositionLoadedListeners = new HashSet();
  private RenderMode renderMode = RenderMode.AUTOMATIC;
  private boolean wasAnimatingWhenDetached = false;
  private boolean wasAnimatingWhenVisibilityChanged = false;
  
  public DiniFlyAnimationView(Context paramContext)
  {
    super(paramContext);
    init((AttributeSet)null);
  }
  
  public DiniFlyAnimationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramAttributeSet);
  }
  
  public DiniFlyAnimationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramAttributeSet);
  }
  
  private void cancelLoaderTask()
  {
    if (this.compositionTask != null)
    {
      this.compositionTask.removeListener(this.loadedListener);
      this.compositionTask.removeFailureListener(this.failureListener);
    }
  }
  
  private void clearComposition()
  {
    this.composition = null;
    this.lottieDrawable.clearComposition();
  }
  
  @SuppressLint({"RestrictedApi"})
  private void enableOrDisableHardwareLayer()
  {
    int j = 2;
    int i = 0;
    if (this.fobiddenLayer) {
      setLayerType(0, (Paint)null);
    }
    for (;;)
    {
      if (getLayerType() == 1) {
        Log.e("DiniFlyAnimationView", "useHardwareLayer:" + getLayerType());
      }
      return;
      switch (trp.$SwitchMap$com$tencent$mobileqq$dinifly$RenderMode[this.renderMode.ordinal()])
      {
      default: 
        break;
      case 1: 
        setLayerType(2, (Paint)null);
        break;
      case 2: 
        setLayerType(1, (Paint)null);
      }
    }
    if ((this.composition != null) && (this.composition.hasDashPattern()) && (Build.VERSION.SDK_INT < 28)) {
      label148:
      if (i == 0) {
        break label189;
      }
    }
    label189:
    for (i = j;; i = 1)
    {
      setLayerType(i, (Paint)null);
      break;
      if ((this.composition != null) && (this.composition.getMaskAndMatteCount() > 4)) {
        break label148;
      }
      i = 1;
      break label148;
    }
  }
  
  private void init(@Nullable AttributeSet paramAttributeSet)
  {
    inTargetDensity = getContext().getResources().getDisplayMetrics().densityDpi;
    if (getContext().getResources().getDisplayMetrics().density < 320.0F) {}
    boolean bool1;
    boolean bool2;
    boolean bool3;
    for (inDensity = 160;; inDensity = 320)
    {
      inTargetDensity = getContext().getResources().getDisplayMetrics().densityDpi;
      if (inDensity < inTargetDensity) {
        inDensity = inTargetDensity;
      }
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, atau.a.qe);
      if (isInEditMode()) {
        break label162;
      }
      bool1 = paramAttributeSet.hasValue(8);
      bool2 = paramAttributeSet.hasValue(4);
      bool3 = paramAttributeSet.hasValue(14);
      if ((!bool1) || (!bool2)) {
        break;
      }
      throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
    }
    if (bool1)
    {
      int i = paramAttributeSet.getResourceId(8, 0);
      if (i != 0) {
        setAnimation(i);
      }
    }
    for (;;)
    {
      label162:
      if (paramAttributeSet.getBoolean(0, false))
      {
        this.wasAnimatingWhenDetached = true;
        this.autoPlay = true;
      }
      if (paramAttributeSet.getBoolean(6, false)) {
        this.lottieDrawable.setRepeatCount(-1);
      }
      if (paramAttributeSet.hasValue(11)) {
        setRepeatMode(paramAttributeSet.getInt(11, 1));
      }
      if (paramAttributeSet.hasValue(10)) {
        setRepeatCount(paramAttributeSet.getInt(10, -1));
      }
      if (paramAttributeSet.hasValue(13)) {
        setSpeed(paramAttributeSet.getFloat(13, 1.0F));
      }
      setImageAssetsFolder(paramAttributeSet.getString(5));
      setProgress(paramAttributeSet.getFloat(7, 0.0F));
      enableMergePathsForKitKatAndAbove(paramAttributeSet.getBoolean(3, false));
      Object localObject1;
      if (paramAttributeSet.hasValue(2))
      {
        Object localObject2 = new SimpleColorFilter(paramAttributeSet.getColor(2, 0));
        localObject1 = new KeyPath(new String[] { "**" });
        localObject2 = new LottieValueCallback(localObject2);
        addValueCallback((KeyPath)localObject1, LottieProperty.COLOR_FILTER, (LottieValueCallback)localObject2);
      }
      if (paramAttributeSet.hasValue(12)) {
        this.lottieDrawable.setScale(paramAttributeSet.getFloat(12, 1.0F), paramAttributeSet.getFloat(12, 1.0F));
      }
      paramAttributeSet.recycle();
      enableOrDisableHardwareLayer();
      return;
      if (bool2)
      {
        localObject1 = paramAttributeSet.getString(4);
        if (localObject1 != null) {
          setAnimation((String)localObject1);
        }
      }
      else if (bool3)
      {
        localObject1 = paramAttributeSet.getString(14);
        if (localObject1 != null) {
          setAnimationFromUrl((String)localObject1);
        }
      }
    }
  }
  
  private void setCompositionTask(LottieTask<LottieComposition> paramLottieTask)
  {
    clearComposition();
    cancelLoaderTask();
    this.compositionTask = paramLottieTask.addListener(this.loadedListener).addFailureListener(this.failureListener);
  }
  
  public <T> void addValueCallback(KeyPath paramKeyPath, T paramT, LottieValueCallback<T> paramLottieValueCallback)
  {
    this.lottieDrawable.addValueCallback(paramKeyPath, paramT, paramLottieValueCallback);
  }
  
  public void cancelAnimation()
  {
    this.lottieDrawable.cancelAnimation();
    enableOrDisableHardwareLayer();
  }
  
  public void enableMergePathsForKitKatAndAbove(boolean paramBoolean)
  {
    this.lottieDrawable.enableMergePathsForKitKatAndAbove(paramBoolean);
  }
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      if (getDrawable() == this.lottieDrawable) {
        super.invalidateDrawable(this.lottieDrawable);
      }
    }
    else {
      return;
    }
    super.invalidateDrawable(paramDrawable);
  }
  
  public boolean isAnimating()
  {
    return this.lottieDrawable.isAnimating();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((this.autoPlay) && (this.wasAnimatingWhenDetached)) {
      playAnimation();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    if (isAnimating())
    {
      cancelAnimation();
      this.wasAnimatingWhenDetached = true;
    }
    super.onDetachedFromWindow();
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.animationName = paramParcelable.animationName;
    if (!TextUtils.isEmpty(this.animationName)) {
      setAnimation(this.animationName);
    }
    this.animationResId = paramParcelable.animationResId;
    if (this.animationResId != 0) {
      setAnimation(this.animationResId);
    }
    setProgress(paramParcelable.progress);
    if (paramParcelable.isAnimating) {
      playAnimation();
    }
    this.lottieDrawable.setImagesAssetsFolder(paramParcelable.imageAssetsFolder);
    setRepeatMode(paramParcelable.repeatMode);
    setRepeatCount(paramParcelable.repeatCount);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.animationName = this.animationName;
    localSavedState.animationResId = this.animationResId;
    localSavedState.progress = this.lottieDrawable.getProgress();
    localSavedState.isAnimating = this.lottieDrawable.isAnimating();
    localSavedState.imageAssetsFolder = this.lottieDrawable.getImageAssetsFolder();
    localSavedState.repeatMode = this.lottieDrawable.getRepeatMode();
    localSavedState.repeatCount = this.lottieDrawable.getRepeatCount();
    return localSavedState;
  }
  
  protected void onVisibilityChanged(@NonNull View paramView, int paramInt)
  {
    if (this.lottieDrawable != null)
    {
      if (paramInt != 0) {
        break label23;
      }
      if (this.wasAnimatingWhenVisibilityChanged) {
        resumeAnimation();
      }
    }
    label23:
    do
    {
      return;
      this.wasAnimatingWhenVisibilityChanged = isAnimating();
    } while (!isAnimating());
    pauseAnimation();
  }
  
  public void pauseAnimation()
  {
    this.lottieDrawable.pauseAnimation();
    enableOrDisableHardwareLayer();
  }
  
  public void playAnimation()
  {
    this.lottieDrawable.playAnimation();
    enableOrDisableHardwareLayer();
  }
  
  public void resumeAnimation()
  {
    this.lottieDrawable.resumeAnimation();
    enableOrDisableHardwareLayer();
  }
  
  public void setAnimation(int paramInt)
  {
    this.animationResId = paramInt;
    this.animationName = null;
    setCompositionTask(LottieCompositionFactory.fromRawRes(getContext(), paramInt));
  }
  
  public void setAnimation(JsonReader paramJsonReader, @Nullable String paramString)
  {
    setCompositionTask(LottieCompositionFactory.fromJsonReader(paramJsonReader, paramString));
  }
  
  public void setAnimation(String paramString)
  {
    this.animationName = paramString;
    this.animationResId = 0;
    setCompositionTask(LottieCompositionFactory.fromAsset(getContext(), paramString));
  }
  
  @Deprecated
  public void setAnimationFromJson(String paramString)
  {
    setAnimationFromJson(paramString, (String)null);
  }
  
  public void setAnimationFromJson(String paramString1, @Nullable String paramString2)
  {
    setAnimation(new JsonReader(new StringReader(paramString1)), paramString2);
  }
  
  public void setAnimationFromUrl(String paramString)
  {
    setCompositionTask(LottieCompositionFactory.fromUrl(getContext(), paramString));
  }
  
  public void setComposition(@NonNull LottieComposition paramLottieComposition)
  {
    if (L.DBG) {
      Log.v(TAG, "Set Composition \n" + paramLottieComposition);
    }
    this.lottieDrawable.setCallback(this);
    this.composition = paramLottieComposition;
    boolean bool = this.lottieDrawable.setComposition(paramLottieComposition);
    enableOrDisableHardwareLayer();
    if ((getDrawable() != this.lottieDrawable) || (bool))
    {
      setImageDrawable((Drawable)null);
      setImageDrawable(this.lottieDrawable);
      requestLayout();
      Iterator localIterator = this.lottieOnCompositionLoadedListeners.iterator();
      while (localIterator.hasNext()) {
        ((LottieOnCompositionLoadedListener)localIterator.next()).onCompositionLoaded(paramLottieComposition);
      }
    }
  }
  
  public void setFitFullScreenXY()
  {
    setScaleType(ImageView.ScaleType.FIT_XY);
  }
  
  public void setFontAssetDelegate(FontAssetDelegate paramFontAssetDelegate)
  {
    this.lottieDrawable.setFontAssetDelegate(paramFontAssetDelegate);
  }
  
  public void setFrame(int paramInt)
  {
    this.lottieDrawable.setFrame(paramInt);
  }
  
  public void setImageAssetDelegate(ImageAssetDelegate paramImageAssetDelegate)
  {
    this.lottieDrawable.setImageAssetDelegate(paramImageAssetDelegate);
  }
  
  public void setImageAssetsFolder(String paramString)
  {
    this.lottieDrawable.setImagesAssetsFolder(paramString);
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    cancelLoaderTask();
    super.setImageBitmap(paramBitmap);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    cancelLoaderTask();
    super.setImageDrawable(paramDrawable);
  }
  
  public void setImageResource(int paramInt)
  {
    cancelLoaderTask();
    super.setImageResource(paramInt);
  }
  
  public void setMaxFrame(int paramInt)
  {
    this.lottieDrawable.setMaxFrame(paramInt);
  }
  
  public void setMaxFrame(String paramString)
  {
    this.lottieDrawable.setMaxFrame(paramString);
  }
  
  public void setMaxProgress(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    this.lottieDrawable.setMaxProgress(paramFloat);
  }
  
  public void setMinAndMaxFrame(int paramInt1, int paramInt2)
  {
    this.lottieDrawable.setMinAndMaxFrame(paramInt1, paramInt2);
  }
  
  public void setMinAndMaxFrame(String paramString)
  {
    this.lottieDrawable.setMinAndMaxFrame(paramString);
  }
  
  public void setMinAndMaxProgress(@FloatRange(from=0.0D, to=1.0D) float paramFloat1, @FloatRange(from=0.0D, to=1.0D) float paramFloat2)
  {
    this.lottieDrawable.setMinAndMaxProgress(paramFloat1, paramFloat2);
  }
  
  public void setMinFrame(int paramInt)
  {
    this.lottieDrawable.setMinFrame(paramInt);
  }
  
  public void setMinFrame(String paramString)
  {
    this.lottieDrawable.setMinFrame(paramString);
  }
  
  public void setMinProgress(float paramFloat)
  {
    this.lottieDrawable.setMinProgress(paramFloat);
  }
  
  public void setPerformanceTrackingEnabled(boolean paramBoolean)
  {
    this.lottieDrawable.setPerformanceTrackingEnabled(paramBoolean);
  }
  
  public void setProgress(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    this.lottieDrawable.setProgress(paramFloat);
  }
  
  public void setRenderMode(RenderMode paramRenderMode)
  {
    this.renderMode = paramRenderMode;
    enableOrDisableHardwareLayer();
  }
  
  public void setRepeatCount(int paramInt)
  {
    this.lottieDrawable.setRepeatCount(paramInt);
  }
  
  public void setRepeatMode(int paramInt)
  {
    this.lottieDrawable.setRepeatMode(paramInt);
  }
  
  public void setScale(float paramFloat)
  {
    setScaleXY(paramFloat, paramFloat);
  }
  
  public void setScaleXY(float paramFloat1, float paramFloat2)
  {
    this.lottieDrawable.setScale(paramFloat1, paramFloat2);
    if (getDrawable() == this.lottieDrawable)
    {
      setImageDrawable((Drawable)null);
      setImageDrawable(this.lottieDrawable);
    }
  }
  
  public void setSpeed(float paramFloat)
  {
    this.lottieDrawable.setSpeed(paramFloat);
  }
  
  public void setTextDelegate(TextDelegate paramTextDelegate)
  {
    this.lottieDrawable.setTextDelegate(paramTextDelegate);
  }
  
  public static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new trq();
    String animationName;
    int animationResId;
    String imageAssetsFolder;
    boolean isAnimating;
    float progress;
    int repeatCount;
    int repeatMode;
    
    private SavedState(Parcel paramParcel)
    {
      super();
      this.animationName = paramParcel.readString();
      this.progress = paramParcel.readFloat();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.isAnimating = bool;
        this.imageAssetsFolder = paramParcel.readString();
        this.repeatMode = paramParcel.readInt();
        this.repeatCount = paramParcel.readInt();
        return;
        bool = false;
      }
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.animationName);
      paramParcel.writeFloat(this.progress);
      if (this.isAnimating) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.imageAssetsFolder);
        paramParcel.writeInt(this.repeatMode);
        paramParcel.writeInt(this.repeatCount);
        return;
      }
    }
  }
  
  class a
    implements LottieListener<Throwable>
  {
    private a() {}
    
    public void onResult(Throwable paramThrowable)
    {
      throw new IllegalStateException("Unable to parse composition", paramThrowable);
    }
  }
  
  class b
    implements LottieListener<LottieComposition>
  {
    private b() {}
    
    public void onResult(LottieComposition paramLottieComposition)
    {
      DiniFlyAnimationView.this.setComposition(paramLottieComposition);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.lottieNew.DiniFlyAnimationView
 * JD-Core Version:    0.7.0.1
 */