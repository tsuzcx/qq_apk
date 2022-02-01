package uilib.doraemon;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import com.tencent.token.gi;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class DoraemonAnimationView
  extends ImageView
{
  private static final String a = "DoraemonAnimationView";
  private static final Map<String, a> b = new HashMap();
  private static final Map<String, WeakReference<a>> c = new HashMap();
  private final e d = new e(this);
  private b e;
  private boolean f = false;
  private boolean g = false;
  private boolean h = false;
  private a i;
  
  public DoraemonAnimationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
  }
  
  public DoraemonAnimationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    this.e = b.b;
    this.d.c(false);
    setProgress(0.0F);
    a(false);
    if ((Build.VERSION.SDK_INT >= 17) && (Settings.Global.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0F) == 0.0F)) {
      this.d.e();
    }
    e();
  }
  
  @TargetApi(11)
  private void e()
  {
    boolean bool = this.h;
    int k = 1;
    int j;
    if ((bool) && (this.d.f())) {
      j = 1;
    } else {
      j = 0;
    }
    if (j != 0) {
      k = 2;
    }
    setLayerType(k, null);
  }
  
  void a()
  {
    e locale = this.d;
    if (locale != null) {
      locale.c();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.d.a(paramBoolean);
  }
  
  public boolean b()
  {
    return this.d.f();
  }
  
  public void c()
  {
    this.d.g();
    e();
  }
  
  public void d()
  {
    this.d.n();
    e();
  }
  
  public long getDuration()
  {
    a locala = this.i;
    if (locala != null) {
      return locala.c();
    }
    return 0L;
  }
  
  public String getImageAssetsFolder()
  {
    return this.d.b();
  }
  
  public h getPerformanceTracker()
  {
    return this.d.d();
  }
  
  public float getProgress()
  {
    return this.d.h();
  }
  
  public float getScale()
  {
    return this.d.l();
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    Drawable localDrawable = getDrawable();
    e locale = this.d;
    if (localDrawable == locale)
    {
      super.invalidateDrawable(locale);
      return;
    }
    super.invalidateDrawable(paramDrawable);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((this.g) && (this.f)) {
      c();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    if (b())
    {
      d();
      this.f = true;
    }
    a();
    super.onDetachedFromWindow();
  }
  
  public void setAlign(a parama)
  {
    this.d.a(parama);
  }
  
  public void setComposition(a parama)
  {
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Set Composition \n");
    localStringBuilder.append(parama);
    Log.v(str, localStringBuilder.toString());
    this.d.setCallback(this);
    boolean bool = this.d.a(parama);
    e();
    if (!bool) {
      return;
    }
    setImageDrawable(null);
    setImageDrawable(this.d);
    this.i = parama;
    requestLayout();
  }
  
  public void setFontAssetDelegate(f paramf)
  {
    this.d.a(paramf);
  }
  
  public void setImageAssetDelegate(c paramc)
  {
    this.d.a(paramc);
  }
  
  public void setImageAssetsFolder(String paramString)
  {
    this.d.a(paramString);
  }
  
  public void setMaxFrame(int paramInt)
  {
    this.d.b(paramInt);
  }
  
  public void setMaxProgress(float paramFloat)
  {
    this.d.b(paramFloat);
  }
  
  public void setMinFrame(int paramInt)
  {
    this.d.a(paramInt);
  }
  
  public void setMinProgress(float paramFloat)
  {
    this.d.a(paramFloat);
  }
  
  public void setPerformanceTrackingEnabled(boolean paramBoolean)
  {
    this.d.b(paramBoolean);
  }
  
  public void setProgress(float paramFloat)
  {
    this.d.d(paramFloat);
  }
  
  public void setScale(float paramFloat)
  {
    this.d.e(paramFloat);
    if (getDrawable() == this.d)
    {
      setImageDrawable(null);
      setImageDrawable(this.d);
    }
  }
  
  public void setShapeStrokeDelegate(gi paramgi)
  {
    this.d.a(paramgi);
  }
  
  public void setSpeed(float paramFloat)
  {
    this.d.c(paramFloat);
  }
  
  public void setTextDelegate(d paramd)
  {
    this.d.a(paramd);
  }
  
  public static enum a
  {
    private a() {}
  }
  
  public static enum b
  {
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     uilib.doraemon.DoraemonAnimationView
 * JD-Core Version:    0.7.0.1
 */