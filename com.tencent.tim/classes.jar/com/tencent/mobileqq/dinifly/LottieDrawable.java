package com.tencent.mobileqq.dinifly;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.support.annotation.FloatRange;
import android.support.annotation.IntRange;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.SparseArrayCompat;
import android.util.Log;
import android.view.View;
import com.tencent.mobileqq.dinifly.manager.FontAssetManager;
import com.tencent.mobileqq.dinifly.manager.ImageAssetManager;
import com.tencent.mobileqq.dinifly.model.KeyPath;
import com.tencent.mobileqq.dinifly.model.KeyPathElement;
import com.tencent.mobileqq.dinifly.model.LottieCompositionCache;
import com.tencent.mobileqq.dinifly.model.Marker;
import com.tencent.mobileqq.dinifly.model.layer.CompositionLayer;
import com.tencent.mobileqq.dinifly.parser.LayerParser;
import com.tencent.mobileqq.dinifly.utils.LottieValueAnimator;
import com.tencent.mobileqq.dinifly.utils.MiscUtils;
import com.tencent.mobileqq.dinifly.value.LottieValueCallback;
import com.tencent.mobileqq.dinifly.value.SimpleLottieValueCallback;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LottieDrawable
  extends Drawable
  implements Animatable, Drawable.Callback
{
  public static final int INFINITE = -1;
  public static final int RESTART = 1;
  public static final int REVERSE = 2;
  private static final String TAG = LottieDrawable.class.getSimpleName();
  private int alpha = 255;
  private final LottieValueAnimator animator = new LottieValueAnimator();
  private final Set<ColorFilterData> colorFilterData = new HashSet();
  private LottieComposition composition;
  @Nullable
  private CompositionLayer compositionLayer;
  private boolean enableMergePaths;
  @Nullable
  FontAssetDelegate fontAssetDelegate;
  @Nullable
  private FontAssetManager fontAssetManager;
  @Nullable
  private ImageAssetDelegate imageAssetDelegate;
  @Nullable
  private ImageAssetManager imageAssetManager;
  @Nullable
  private String imageAssetsFolder;
  private boolean isDirty = false;
  private final ArrayList<LazyCompositionTask> lazyCompositionTasks = new ArrayList();
  private final Matrix matrix = new Matrix();
  private boolean performanceTrackingEnabled;
  private float scaleX = 1.0F;
  private float scaleY = 1.0F;
  @Nullable
  TextDelegate textDelegate;
  
  public LottieDrawable()
  {
    this.animator.addUpdateListener(new LottieDrawable.1(this));
  }
  
  private void buildCompositionLayer()
  {
    long l = SystemClock.uptimeMillis();
    if (this.composition.compositionLayer != null) {}
    for (this.compositionLayer = this.composition.compositionLayer;; this.compositionLayer = new CompositionLayer(this, LayerParser.parse(this.composition), this.composition.getLayers(), this.composition))
    {
      this.composition.layerInfo.buildLayerTime = (SystemClock.uptimeMillis() - l);
      return;
    }
  }
  
  @Nullable
  private Context getContext()
  {
    Drawable.Callback localCallback = getCallback();
    if (localCallback == null) {
      return null;
    }
    if ((localCallback instanceof View)) {
      return ((View)localCallback).getContext();
    }
    return null;
  }
  
  private FontAssetManager getFontAssetManager()
  {
    if (getCallback() == null) {
      return null;
    }
    if (this.fontAssetManager == null) {
      this.fontAssetManager = new FontAssetManager(getCallback(), this.fontAssetDelegate);
    }
    return this.fontAssetManager;
  }
  
  private ImageAssetManager getImageAssetManager()
  {
    if (getCallback() == null) {
      return null;
    }
    if ((this.imageAssetManager != null) && (!this.imageAssetManager.hasSameContext(getContext()))) {
      this.imageAssetManager = null;
    }
    if (this.imageAssetManager == null) {
      this.imageAssetManager = new ImageAssetManager(getCallback(), this.imageAssetsFolder, this.imageAssetDelegate, this.composition.getImages());
    }
    return this.imageAssetManager;
  }
  
  private float getMaxScale(@NonNull Canvas paramCanvas)
  {
    return Math.min(paramCanvas.getWidth() / this.composition.getBounds().width(), paramCanvas.getHeight() / this.composition.getBounds().height());
  }
  
  private void updateBounds()
  {
    if (this.composition == null) {
      return;
    }
    setBounds(0, 0, (int)(this.composition.getBounds().width() * this.scaleX), (int)(this.composition.getBounds().height() * this.scaleY));
  }
  
  public void addAnimatorListener(Animator.AnimatorListener paramAnimatorListener)
  {
    this.animator.addListener(paramAnimatorListener);
  }
  
  public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener)
  {
    this.animator.addUpdateListener(paramAnimatorUpdateListener);
  }
  
  public <T> void addValueCallback(KeyPath paramKeyPath, T paramT, LottieValueCallback<T> paramLottieValueCallback)
  {
    int i = 1;
    int j = 0;
    if (this.compositionLayer == null) {
      this.lazyCompositionTasks.add(new LottieDrawable.15(this, paramKeyPath, paramT, paramLottieValueCallback));
    }
    label143:
    for (;;)
    {
      return;
      if (paramKeyPath.getResolvedElement() != null) {
        paramKeyPath.getResolvedElement().addValueCallback(paramT, paramLottieValueCallback);
      }
      for (;;)
      {
        if (i == 0) {
          break label143;
        }
        invalidateSelf();
        if (paramT != LottieProperty.TIME_REMAP) {
          break;
        }
        setProgress(getProgress());
        return;
        paramKeyPath = resolveKeyPath(paramKeyPath);
        i = 0;
        while (i < paramKeyPath.size())
        {
          ((KeyPath)paramKeyPath.get(i)).getResolvedElement().addValueCallback(paramT, paramLottieValueCallback);
          i += 1;
        }
        i = j;
        if (!paramKeyPath.isEmpty()) {
          i = 1;
        }
      }
    }
  }
  
  public <T> void addValueCallback(KeyPath paramKeyPath, T paramT, SimpleLottieValueCallback<T> paramSimpleLottieValueCallback)
  {
    addValueCallback(paramKeyPath, paramT, new LottieDrawable.16(this, paramSimpleLottieValueCallback));
  }
  
  public void cancelAnimation()
  {
    this.lazyCompositionTasks.clear();
    this.animator.cancel();
  }
  
  public void clearComposition()
  {
    if (this.animator.isRunning()) {
      this.animator.cancel();
    }
    this.composition = null;
    this.compositionLayer = null;
    this.imageAssetManager = null;
    this.animator.clearComposition();
    invalidateSelf();
  }
  
  public void clearCompositionAndCache(String paramString)
  {
    LottieCompositionCache.getInstance().removeCacheByKey(paramString);
    LottieCompositionFactory.removeCacheByKey(paramString);
    clearComposition();
  }
  
  public LayerInfo collectLayerInfo()
  {
    if ((this.composition == null) || (this.compositionLayer == null)) {
      return null;
    }
    this.compositionLayer.collectLayers(this.composition.layerInfo);
    return this.composition.layerInfo;
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    this.isDirty = false;
    L.beginSection("Drawable#draw");
    if (this.compositionLayer == null) {
      return;
    }
    float f2 = this.scaleX;
    float f4 = this.scaleY;
    float f3 = getMaxScale(paramCanvas);
    float f1;
    if (f2 > f3)
    {
      f1 = this.scaleX / f3;
      f2 = f3;
    }
    for (;;)
    {
      if (f4 > f3) {}
      float f5;
      for (f4 = this.scaleY / f3;; f4 = f5)
      {
        int i = -1;
        if ((f1 > 1.0F) || (f4 > 1.0F))
        {
          i = paramCanvas.save();
          paramCanvas.scale(f1, f4);
        }
        this.matrix.reset();
        this.matrix.preScale(f2, f3);
        this.compositionLayer.draw(paramCanvas, this.matrix, this.alpha);
        L.endSection("Drawable#draw");
        if (i <= 0) {
          break;
        }
        paramCanvas.restoreToCount(i);
        return;
        f5 = 1.0F;
        f3 = f4;
      }
      f1 = 1.0F;
    }
  }
  
  public void enableMergePathsForKitKatAndAbove(boolean paramBoolean)
  {
    if (this.enableMergePaths == paramBoolean) {}
    do
    {
      return;
      if (Build.VERSION.SDK_INT < 19)
      {
        Log.w(TAG, "Merge paths are not supported pre-Kit Kat.");
        return;
      }
      this.enableMergePaths = paramBoolean;
    } while (this.composition == null);
    buildCompositionLayer();
  }
  
  public boolean enableMergePathsForKitKatAndAbove()
  {
    return this.enableMergePaths;
  }
  
  @MainThread
  public void endAnimation()
  {
    this.lazyCompositionTasks.clear();
    this.animator.endAnimation();
  }
  
  public int getAlpha()
  {
    return this.alpha;
  }
  
  public LottieComposition getComposition()
  {
    return this.composition;
  }
  
  @Nullable
  public CompositionLayer getCompositionLayer()
  {
    return this.compositionLayer;
  }
  
  public int getFrame()
  {
    return (int)this.animator.getFrame();
  }
  
  @Nullable
  public Bitmap getImageAsset(String paramString)
  {
    ImageAssetManager localImageAssetManager = getImageAssetManager();
    if (localImageAssetManager != null) {
      return localImageAssetManager.bitmapForId(paramString);
    }
    return null;
  }
  
  @Nullable
  public String getImageAssetsFolder()
  {
    return this.imageAssetsFolder;
  }
  
  public int getIntrinsicHeight()
  {
    if (this.composition == null) {
      return -1;
    }
    return (int)(this.composition.getBounds().height() * this.scaleY);
  }
  
  public int getIntrinsicWidth()
  {
    if (this.composition == null) {
      return -1;
    }
    return (int)(this.composition.getBounds().width() * this.scaleX);
  }
  
  public float getMaxFrame()
  {
    return this.animator.getMaxFrame();
  }
  
  public float getMinFrame()
  {
    return this.animator.getMinFrame();
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  @Nullable
  public PerformanceTracker getPerformanceTracker()
  {
    if (this.composition != null) {
      return this.composition.getPerformanceTracker();
    }
    return null;
  }
  
  @FloatRange(from=0.0D, to=1.0D)
  public float getProgress()
  {
    return this.animator.getAnimatedValueAbsolute();
  }
  
  public int getRepeatCount()
  {
    return this.animator.getRepeatCount();
  }
  
  public int getRepeatMode()
  {
    return this.animator.getRepeatMode();
  }
  
  public float getScale()
  {
    return Math.min(this.scaleX, this.scaleY);
  }
  
  public float getSpeed()
  {
    return this.animator.getSpeed();
  }
  
  @Nullable
  public TextDelegate getTextDelegate()
  {
    return this.textDelegate;
  }
  
  @Nullable
  public Typeface getTypeface(String paramString1, String paramString2)
  {
    FontAssetManager localFontAssetManager = getFontAssetManager();
    if (localFontAssetManager != null) {
      return localFontAssetManager.getTypeface(paramString1, paramString2);
    }
    return null;
  }
  
  public boolean hasMasks()
  {
    return (this.compositionLayer != null) && (this.compositionLayer.hasMasks());
  }
  
  public boolean hasMatte()
  {
    return (this.compositionLayer != null) && (this.compositionLayer.hasMatte());
  }
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    paramDrawable = getCallback();
    if (paramDrawable == null) {
      return;
    }
    paramDrawable.invalidateDrawable(this);
  }
  
  public void invalidateSelf()
  {
    if (this.isDirty) {}
    Drawable.Callback localCallback;
    do
    {
      return;
      this.isDirty = true;
      localCallback = getCallback();
    } while (localCallback == null);
    localCallback.invalidateDrawable(this);
  }
  
  public boolean isAnimating()
  {
    return this.animator.isRunning();
  }
  
  public boolean isLooping()
  {
    return this.animator.getRepeatCount() == -1;
  }
  
  public boolean isMergePathsEnabledForKitKatAndAbove()
  {
    return this.enableMergePaths;
  }
  
  public boolean isRunning()
  {
    return isAnimating();
  }
  
  @Deprecated
  public void loop(boolean paramBoolean)
  {
    LottieValueAnimator localLottieValueAnimator = this.animator;
    if (paramBoolean) {}
    for (int i = -1;; i = 0)
    {
      localLottieValueAnimator.setRepeatCount(i);
      return;
    }
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    if ((this.composition != null) && (!hasMatte()))
    {
      int i = paramRect.width();
      int j = paramRect.height();
      int k = this.composition.getBounds().width();
      int m = this.composition.getBounds().height();
      this.scaleX = (i / k);
      this.scaleY = (j / m);
    }
  }
  
  public void pauseAnimation()
  {
    this.lazyCompositionTasks.clear();
    this.animator.pauseAnimation();
  }
  
  @MainThread
  public void playAnimation()
  {
    if (this.compositionLayer == null)
    {
      this.lazyCompositionTasks.add(new LottieDrawable.2(this));
      return;
    }
    this.animator.playAnimation();
  }
  
  public void recycleBitmaps()
  {
    if (this.imageAssetManager != null) {
      this.imageAssetManager.recycleBitmaps();
    }
  }
  
  public void removeAllAnimatorListeners()
  {
    this.animator.removeAllListeners();
  }
  
  public void removeAllUpdateListeners()
  {
    this.animator.removeAllUpdateListeners();
  }
  
  public void removeAnimatorListener(Animator.AnimatorListener paramAnimatorListener)
  {
    this.animator.removeListener(paramAnimatorListener);
  }
  
  public void removeAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener)
  {
    this.animator.removeUpdateListener(paramAnimatorUpdateListener);
  }
  
  public List<KeyPath> resolveKeyPath(KeyPath paramKeyPath)
  {
    if (this.compositionLayer == null)
    {
      Log.w("LOTTIE", "Cannot resolve KeyPath. Composition is not set yet.");
      return Collections.emptyList();
    }
    ArrayList localArrayList = new ArrayList();
    this.compositionLayer.resolveKeyPath(paramKeyPath, 0, localArrayList, new KeyPath(new String[0]));
    return localArrayList;
  }
  
  @MainThread
  public void resumeAnimation()
  {
    if (this.compositionLayer == null)
    {
      this.lazyCompositionTasks.add(new LottieDrawable.3(this));
      return;
    }
    this.animator.resumeAnimation();
  }
  
  public void reverseAnimationSpeed()
  {
    this.animator.reverseAnimationSpeed();
  }
  
  public void scheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable, long paramLong)
  {
    paramDrawable = getCallback();
    if (paramDrawable == null) {
      return;
    }
    paramDrawable.scheduleDrawable(this, paramRunnable, paramLong);
  }
  
  public void setAlpha(@IntRange(from=0L, to=255L) int paramInt)
  {
    this.alpha = paramInt;
  }
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter)
  {
    Log.w("LOTTIE", "Use addColorFilter instead.");
  }
  
  public boolean setComposition(LottieComposition paramLottieComposition)
  {
    if (this.composition == paramLottieComposition) {
      return false;
    }
    this.isDirty = false;
    clearComposition();
    this.composition = paramLottieComposition;
    buildCompositionLayer();
    this.animator.setComposition(paramLottieComposition);
    setProgress(this.animator.getAnimatedFraction());
    setScale(this.scaleX, this.scaleY);
    updateBounds();
    Iterator localIterator = new ArrayList(this.lazyCompositionTasks).iterator();
    while (localIterator.hasNext())
    {
      ((LazyCompositionTask)localIterator.next()).run(paramLottieComposition);
      localIterator.remove();
    }
    this.lazyCompositionTasks.clear();
    paramLottieComposition.setPerformanceTrackingEnabled(this.performanceTrackingEnabled);
    return true;
  }
  
  public void setFontAssetDelegate(FontAssetDelegate paramFontAssetDelegate)
  {
    this.fontAssetDelegate = paramFontAssetDelegate;
    if (this.fontAssetManager != null) {
      this.fontAssetManager.setDelegate(paramFontAssetDelegate);
    }
  }
  
  public void setFrame(int paramInt)
  {
    if (this.composition == null)
    {
      this.lazyCompositionTasks.add(new LottieDrawable.13(this, paramInt));
      return;
    }
    this.animator.setFrame(paramInt);
  }
  
  public void setImageAssetDelegate(ImageAssetDelegate paramImageAssetDelegate)
  {
    this.imageAssetDelegate = paramImageAssetDelegate;
    if (this.imageAssetManager != null) {
      this.imageAssetManager.setDelegate(paramImageAssetDelegate);
    }
  }
  
  public void setImagesAssetsFolder(@Nullable String paramString)
  {
    this.imageAssetsFolder = paramString;
  }
  
  public void setMaxFrame(int paramInt)
  {
    if (this.composition == null)
    {
      this.lazyCompositionTasks.add(new LottieDrawable.6(this, paramInt));
      return;
    }
    this.animator.setMaxFrame(paramInt + 0.99F);
  }
  
  public void setMaxFrame(String paramString)
  {
    if (this.composition == null)
    {
      this.lazyCompositionTasks.add(new LottieDrawable.9(this, paramString));
      return;
    }
    Marker localMarker = this.composition.getMarker(paramString);
    if (localMarker == null) {
      throw new IllegalArgumentException("Cannot find marker with name " + paramString + ".");
    }
    float f = localMarker.startFrame;
    setMaxFrame((int)(localMarker.durationFrames + f));
  }
  
  public void setMaxProgress(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    if (this.composition == null)
    {
      this.lazyCompositionTasks.add(new LottieDrawable.7(this, paramFloat));
      return;
    }
    setMaxFrame((int)MiscUtils.lerp(this.composition.getStartFrame(), this.composition.getEndFrame(), paramFloat));
  }
  
  public void setMinAndMaxFrame(int paramInt1, int paramInt2)
  {
    if (this.composition == null)
    {
      this.lazyCompositionTasks.add(new LottieDrawable.11(this, paramInt1, paramInt2));
      return;
    }
    this.animator.setMinAndMaxFrames(paramInt1, paramInt2 + 0.99F);
  }
  
  public void setMinAndMaxFrame(String paramString)
  {
    if (this.composition == null)
    {
      this.lazyCompositionTasks.add(new LottieDrawable.10(this, paramString));
      return;
    }
    Marker localMarker = this.composition.getMarker(paramString);
    if (localMarker == null) {
      throw new IllegalArgumentException("Cannot find marker with name " + paramString + ".");
    }
    int i = (int)localMarker.startFrame;
    setMinAndMaxFrame(i, (int)localMarker.durationFrames + i);
  }
  
  public void setMinAndMaxProgress(@FloatRange(from=0.0D, to=1.0D) float paramFloat1, @FloatRange(from=0.0D, to=1.0D) float paramFloat2)
  {
    if (this.composition == null)
    {
      this.lazyCompositionTasks.add(new LottieDrawable.12(this, paramFloat1, paramFloat2));
      return;
    }
    setMinAndMaxFrame((int)MiscUtils.lerp(this.composition.getStartFrame(), this.composition.getEndFrame(), paramFloat1), (int)MiscUtils.lerp(this.composition.getStartFrame(), this.composition.getEndFrame(), paramFloat2));
  }
  
  public void setMinFrame(int paramInt)
  {
    if (this.composition == null)
    {
      this.lazyCompositionTasks.add(new LottieDrawable.4(this, paramInt));
      return;
    }
    this.animator.setMinFrame(paramInt);
  }
  
  public void setMinFrame(String paramString)
  {
    if (this.composition == null)
    {
      this.lazyCompositionTasks.add(new LottieDrawable.8(this, paramString));
      return;
    }
    Marker localMarker = this.composition.getMarker(paramString);
    if (localMarker == null) {
      throw new IllegalArgumentException("Cannot find marker with name " + paramString + ".");
    }
    setMinFrame((int)localMarker.startFrame);
  }
  
  public void setMinProgress(float paramFloat)
  {
    if (this.composition == null)
    {
      this.lazyCompositionTasks.add(new LottieDrawable.5(this, paramFloat));
      return;
    }
    setMinFrame((int)MiscUtils.lerp(this.composition.getStartFrame(), this.composition.getEndFrame(), paramFloat));
  }
  
  public void setPerformanceTrackingEnabled(boolean paramBoolean)
  {
    this.performanceTrackingEnabled = paramBoolean;
    if (this.composition != null) {
      this.composition.setPerformanceTrackingEnabled(paramBoolean);
    }
  }
  
  public void setProgress(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    if (this.composition == null)
    {
      this.lazyCompositionTasks.add(new LottieDrawable.14(this, paramFloat));
      return;
    }
    setFrame((int)MiscUtils.lerp(this.composition.getStartFrame(), this.composition.getEndFrame(), paramFloat));
  }
  
  public void setRepeatCount(int paramInt)
  {
    this.animator.setRepeatCount(paramInt);
  }
  
  public void setRepeatMode(int paramInt)
  {
    this.animator.setRepeatMode(paramInt);
  }
  
  public void setScale(float paramFloat1, float paramFloat2)
  {
    this.scaleX = paramFloat1;
    this.scaleY = paramFloat2;
    updateBounds();
  }
  
  public void setSpeed(float paramFloat)
  {
    this.animator.setSpeed(paramFloat);
  }
  
  public void setTextDelegate(TextDelegate paramTextDelegate)
  {
    this.textDelegate = paramTextDelegate;
  }
  
  @MainThread
  public void start()
  {
    playAnimation();
  }
  
  @MainThread
  public void stop()
  {
    endAnimation();
  }
  
  public void unscheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable)
  {
    paramDrawable = getCallback();
    if (paramDrawable == null) {
      return;
    }
    paramDrawable.unscheduleDrawable(this, paramRunnable);
  }
  
  @Nullable
  public Bitmap updateBitmap(String paramString, @Nullable Bitmap paramBitmap)
  {
    ImageAssetManager localImageAssetManager = getImageAssetManager();
    if (localImageAssetManager == null)
    {
      Log.w("LOTTIE", "Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
      return null;
    }
    paramString = localImageAssetManager.updateBitmap(paramString, paramBitmap);
    invalidateSelf();
    return paramString;
  }
  
  public boolean useTextGlyphs()
  {
    return (this.textDelegate == null) && (this.composition.getCharacters().size() > 0);
  }
  
  static class ColorFilterData
  {
    @Nullable
    final ColorFilter colorFilter;
    @Nullable
    final String contentName;
    final String layerName;
    
    ColorFilterData(@Nullable String paramString1, @Nullable String paramString2, @Nullable ColorFilter paramColorFilter)
    {
      this.layerName = paramString1;
      this.contentName = paramString2;
      this.colorFilter = paramColorFilter;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof ColorFilterData)) {
          return false;
        }
        paramObject = (ColorFilterData)paramObject;
      } while ((hashCode() == paramObject.hashCode()) && (this.colorFilter == paramObject.colorFilter));
      return false;
    }
    
    public int hashCode()
    {
      int i = 17;
      if (this.layerName != null) {
        i = this.layerName.hashCode() * 527;
      }
      int j = i;
      if (this.contentName != null) {
        j = i * 31 * this.contentName.hashCode();
      }
      return j;
    }
  }
  
  static abstract interface LazyCompositionTask
  {
    public abstract void run(LottieComposition paramLottieComposition);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface RepeatMode {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.LottieDrawable
 * JD-Core Version:    0.7.0.1
 */