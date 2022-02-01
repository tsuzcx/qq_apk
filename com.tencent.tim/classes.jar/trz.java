import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.os.Build.VERSION;
import android.support.annotation.FloatRange;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.tencent.lottieNew.model.layer.Layer.a;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class trz
  extends Drawable
  implements Drawable.Callback
{
  private static final String TAG = trz.class.getSimpleName();
  @Nullable
  trr jdField_a_of_type_Trr;
  @Nullable
  private trs jdField_a_of_type_Trs;
  private trx jdField_a_of_type_Trx;
  @Nullable
  tsk jdField_a_of_type_Tsk;
  @Nullable
  private ttx jdField_a_of_type_Ttx;
  @Nullable
  private tty jdField_a_of_type_Tty;
  @Nullable
  private twh jdField_a_of_type_Twh;
  private final twt jdField_a_of_type_Twt = new twt();
  private boolean aQt;
  private int alpha = 255;
  private final Set<trz.a> colorFilterData = new HashSet();
  private boolean enableMergePaths;
  @Nullable
  private String imageAssetsFolder;
  private final ArrayList<trz.b> lazyCompositionTasks = new ArrayList();
  private final Matrix matrix = new Matrix();
  private boolean performanceTrackingEnabled;
  private float scale = 1.0F;
  private float speed = 1.0F;
  
  public trz()
  {
    this.jdField_a_of_type_Twt.setRepeatCount(0);
    this.jdField_a_of_type_Twt.setInterpolator(new LinearInterpolator());
    this.jdField_a_of_type_Twt.addUpdateListener(new tsa(this));
  }
  
  private ttx a()
  {
    if (getCallback() == null) {
      return null;
    }
    if (this.jdField_a_of_type_Ttx == null) {
      this.jdField_a_of_type_Ttx = new ttx(getCallback(), this.jdField_a_of_type_Trr);
    }
    return this.jdField_a_of_type_Ttx;
  }
  
  private tty a()
  {
    if (getCallback() == null) {
      return null;
    }
    if ((this.jdField_a_of_type_Tty != null) && (!this.jdField_a_of_type_Tty.hasSameContext(getContext())))
    {
      this.jdField_a_of_type_Tty.recycleBitmaps();
      this.jdField_a_of_type_Tty = null;
    }
    if (this.jdField_a_of_type_Tty == null) {
      this.jdField_a_of_type_Tty = new tty(getCallback(), this.imageAssetsFolder, this.jdField_a_of_type_Trs, this.jdField_a_of_type_Trx.getImages());
    }
    return this.jdField_a_of_type_Tty;
  }
  
  private void a(@Nullable String paramString1, @Nullable String paramString2, @Nullable ColorFilter paramColorFilter)
  {
    trz.a locala = new trz.a(paramString1, paramString2, paramColorFilter);
    if ((paramColorFilter == null) && (this.colorFilterData.contains(locala))) {
      this.colorFilterData.remove(locala);
    }
    while (this.jdField_a_of_type_Twh == null)
    {
      return;
      this.colorFilterData.add(new trz.a(paramString1, paramString2, paramColorFilter));
    }
    this.jdField_a_of_type_Twh.b(paramString1, paramString2, paramColorFilter);
  }
  
  private void bEM()
  {
    if (this.jdField_a_of_type_Twh == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.colorFilterData.iterator();
      while (localIterator.hasNext())
      {
        trz.a locala = (trz.a)localIterator.next();
        this.jdField_a_of_type_Twh.b(locala.layerName, locala.contentName, locala.colorFilter);
      }
    }
  }
  
  private void buildCompositionLayer()
  {
    this.jdField_a_of_type_Twh = new twh(this, Layer.a.a(this.jdField_a_of_type_Trx), this.jdField_a_of_type_Trx.getLayers(), this.jdField_a_of_type_Trx);
  }
  
  private void clearComposition()
  {
    recycleBitmaps();
    this.jdField_a_of_type_Twh = null;
    this.jdField_a_of_type_Tty = null;
    invalidateSelf();
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
  
  private float getMaxScale(@NonNull Canvas paramCanvas)
  {
    return Math.min(paramCanvas.getWidth() / this.jdField_a_of_type_Trx.getBounds().width(), paramCanvas.getHeight() / this.jdField_a_of_type_Trx.getBounds().height());
  }
  
  private void updateBounds()
  {
    if (this.jdField_a_of_type_Trx == null) {
      return;
    }
    float f = getScale();
    setBounds(0, 0, (int)(this.jdField_a_of_type_Trx.getBounds().width() * f), (int)(f * this.jdField_a_of_type_Trx.getBounds().height()));
  }
  
  private void vA(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Twh == null)
    {
      this.lazyCompositionTasks.add(new tsb(this, paramBoolean));
      return;
    }
    float f = this.jdField_a_of_type_Twt.getProgress();
    this.jdField_a_of_type_Twt.start();
    if ((paramBoolean) || (this.jdField_a_of_type_Twt.getAnimatedFraction() == 1.0F))
    {
      this.jdField_a_of_type_Twt.setProgress(this.jdField_a_of_type_Twt.aG());
      return;
    }
    this.jdField_a_of_type_Twt.setProgress(f);
  }
  
  public trx a()
  {
    return this.jdField_a_of_type_Trx;
  }
  
  @Nullable
  public tsk a()
  {
    return this.jdField_a_of_type_Tsk;
  }
  
  public boolean a(trx paramtrx)
  {
    if (this.jdField_a_of_type_Trx == paramtrx) {
      return false;
    }
    clearComposition();
    this.jdField_a_of_type_Trx = paramtrx;
    setSpeed(this.speed);
    updateBounds();
    buildCompositionLayer();
    bEM();
    Iterator localIterator = new ArrayList(this.lazyCompositionTasks).iterator();
    while (localIterator.hasNext())
    {
      ((trz.b)localIterator.next()).b(paramtrx);
      localIterator.remove();
    }
    this.lazyCompositionTasks.clear();
    paramtrx.setPerformanceTrackingEnabled(this.performanceTrackingEnabled);
    this.jdField_a_of_type_Twt.bEO();
    return true;
  }
  
  public void addAnimatorListener(Animator.AnimatorListener paramAnimatorListener)
  {
    this.jdField_a_of_type_Twt.addListener(paramAnimatorListener);
  }
  
  public void bEN()
  {
    this.aQt = true;
    this.jdField_a_of_type_Twt.bEN();
  }
  
  public void c(ColorFilter paramColorFilter)
  {
    a(null, null, paramColorFilter);
  }
  
  public void cancelAnimation()
  {
    this.lazyCompositionTasks.clear();
    this.jdField_a_of_type_Twt.cancel();
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    int j = 0;
    trt.beginSection("Drawable#draw");
    if (this.jdField_a_of_type_Twh == null) {
      return;
    }
    float f3 = this.scale;
    float f2 = 1.0F;
    float f5 = getMaxScale(paramCanvas);
    int i;
    float f1;
    if (!this.jdField_a_of_type_Twh.hasMatte())
    {
      i = j;
      f1 = f3;
      if (!this.jdField_a_of_type_Twh.hasMasks()) {}
    }
    else
    {
      float f4 = f3 / f5;
      f3 = Math.min(f3, f5);
      i = j;
      f2 = f4;
      f1 = f3;
      if (f4 > 1.001F)
      {
        i = 1;
        f1 = f3;
        f2 = f4;
      }
    }
    if (i != 0)
    {
      paramCanvas.save();
      f2 *= f2;
      j = (int)(this.jdField_a_of_type_Trx.getBounds().width() * f1 / 2.0F);
      int k = (int)(this.jdField_a_of_type_Trx.getBounds().height() * f1 / 2.0F);
      paramCanvas.scale(f2, f2, j, k);
    }
    this.matrix.reset();
    this.matrix.preScale(f1, f1);
    this.jdField_a_of_type_Twh.draw(paramCanvas, this.matrix, this.alpha);
    if (i != 0) {
      paramCanvas.restore();
    }
    trt.endSection("Drawable#draw");
  }
  
  public void enableMergePathsForKitKatAndAbove(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 19) {
      Log.w(TAG, "Merge paths are not supported pre-Kit Kat.");
    }
    do
    {
      return;
      this.enableMergePaths = paramBoolean;
    } while (this.jdField_a_of_type_Trx == null);
    buildCompositionLayer();
  }
  
  public boolean enableMergePathsForKitKatAndAbove()
  {
    return this.enableMergePaths;
  }
  
  public int getAlpha()
  {
    return this.alpha;
  }
  
  @Nullable
  public Bitmap getImageAsset(String paramString)
  {
    tty localtty = a();
    if (localtty != null) {
      return localtty.bitmapForId(paramString);
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
    if (this.jdField_a_of_type_Trx == null) {
      return -1;
    }
    return (int)(this.jdField_a_of_type_Trx.getBounds().height() * this.scale);
  }
  
  public int getIntrinsicWidth()
  {
    if (this.jdField_a_of_type_Trx == null) {
      return -1;
    }
    return (int)(this.jdField_a_of_type_Trx.getBounds().width() * this.scale);
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public float getProgress()
  {
    return this.jdField_a_of_type_Twt.getProgress();
  }
  
  public float getScale()
  {
    return this.scale;
  }
  
  @Nullable
  public Typeface getTypeface(String paramString1, String paramString2)
  {
    ttx localttx = a();
    if (localttx != null) {
      return localttx.getTypeface(paramString1, paramString2);
    }
    return null;
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
    Drawable.Callback localCallback = getCallback();
    if (localCallback != null) {
      localCallback.invalidateDrawable(this);
    }
  }
  
  public boolean isAnimating()
  {
    return this.jdField_a_of_type_Twt.isRunning();
  }
  
  public boolean isLooping()
  {
    return this.jdField_a_of_type_Twt.getRepeatCount() == -1;
  }
  
  public void loop(boolean paramBoolean)
  {
    twt localtwt = this.jdField_a_of_type_Twt;
    if (paramBoolean) {}
    for (int i = -1;; i = 0)
    {
      localtwt.setRepeatCount(i);
      return;
    }
  }
  
  public void playAnimation()
  {
    vA(true);
  }
  
  public void recycleBitmaps()
  {
    if (this.jdField_a_of_type_Tty != null) {
      this.jdField_a_of_type_Tty.recycleBitmaps();
    }
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
    QLog.e("LottieDrawable", 2, "Use addColorFilter instead.");
  }
  
  public void setFontAssetDelegate(trr paramtrr)
  {
    this.jdField_a_of_type_Trr = paramtrr;
    if (this.jdField_a_of_type_Ttx != null) {
      this.jdField_a_of_type_Ttx.a(paramtrr);
    }
  }
  
  public void setImageAssetDelegate(trs paramtrs)
  {
    this.jdField_a_of_type_Trs = paramtrs;
    if (this.jdField_a_of_type_Tty != null) {
      this.jdField_a_of_type_Tty.a(paramtrs);
    }
  }
  
  public void setImagesAssetsFolder(@Nullable String paramString)
  {
    this.imageAssetsFolder = paramString;
  }
  
  public void setMaxFrame(int paramInt)
  {
    if (this.jdField_a_of_type_Trx == null)
    {
      this.lazyCompositionTasks.add(new tsd(this, paramInt));
      return;
    }
    setMaxProgress(paramInt / this.jdField_a_of_type_Trx.getDurationFrames());
  }
  
  public void setMaxProgress(float paramFloat)
  {
    this.jdField_a_of_type_Twt.setMaxProgress(paramFloat);
  }
  
  public void setMinAndMaxFrame(int paramInt1, int paramInt2)
  {
    setMinFrame(paramInt1);
    setMaxFrame(paramInt2);
  }
  
  public void setMinAndMaxProgress(float paramFloat1, float paramFloat2)
  {
    setMinProgress(paramFloat1);
    setMaxProgress(paramFloat2);
  }
  
  public void setMinFrame(int paramInt)
  {
    if (this.jdField_a_of_type_Trx == null)
    {
      this.lazyCompositionTasks.add(new tsc(this, paramInt));
      return;
    }
    setMinProgress(paramInt / this.jdField_a_of_type_Trx.getDurationFrames());
  }
  
  public void setMinProgress(float paramFloat)
  {
    this.jdField_a_of_type_Twt.setMinProgress(paramFloat);
  }
  
  public void setPerformanceTrackingEnabled(boolean paramBoolean)
  {
    this.performanceTrackingEnabled = paramBoolean;
    if (this.jdField_a_of_type_Trx != null) {
      this.jdField_a_of_type_Trx.setPerformanceTrackingEnabled(paramBoolean);
    }
  }
  
  public void setProgress(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    this.jdField_a_of_type_Twt.setProgress(paramFloat);
    if (this.jdField_a_of_type_Twh != null) {
      this.jdField_a_of_type_Twh.setProgress(paramFloat);
    }
  }
  
  public void setScale(float paramFloat)
  {
    this.scale = paramFloat;
    updateBounds();
  }
  
  public void setSpeed(float paramFloat)
  {
    this.speed = paramFloat;
    twt localtwt = this.jdField_a_of_type_Twt;
    if (paramFloat < 0.0F) {}
    for (boolean bool = true;; bool = false)
    {
      localtwt.vB(bool);
      if (this.jdField_a_of_type_Trx != null) {
        this.jdField_a_of_type_Twt.setDuration(((float)this.jdField_a_of_type_Trx.getDuration() / Math.abs(paramFloat)));
      }
      return;
    }
  }
  
  public void setTextDelegate(tsk paramtsk)
  {
    this.jdField_a_of_type_Tsk = paramtsk;
  }
  
  public void unscheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable)
  {
    paramDrawable = getCallback();
    if (paramDrawable == null) {
      return;
    }
    paramDrawable.unscheduleDrawable(this, paramRunnable);
  }
  
  public boolean useTextGlyphs()
  {
    return (this.jdField_a_of_type_Tsk == null) && (this.jdField_a_of_type_Trx.U().size() > 0);
  }
  
  static class a
  {
    @Nullable
    final ColorFilter colorFilter;
    @Nullable
    final String contentName;
    final String layerName;
    
    a(@Nullable String paramString1, @Nullable String paramString2, @Nullable ColorFilter paramColorFilter)
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
        if (!(paramObject instanceof a)) {
          return false;
        }
        paramObject = (a)paramObject;
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
  
  static abstract interface b
  {
    public abstract void b(trx paramtrx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     trz
 * JD-Core Version:    0.7.0.1
 */