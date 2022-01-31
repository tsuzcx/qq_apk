package uilib.doraemon;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import com.tencent.token.io;
import java.util.HashMap;
import java.util.Map;

public class DoraemonAnimationView
  extends ImageView
{
  private static final String a = DoraemonAnimationView.class.getSimpleName();
  private static final Map b = new HashMap();
  private static final Map c = new HashMap();
  private final e d = new e(this);
  private DoraemonAnimationView.b e;
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
    this.e = DoraemonAnimationView.b.b;
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
    int k = 1;
    if ((this.h) && (this.d.f())) {}
    for (int j = 1;; j = 0)
    {
      if (j != 0) {
        k = 2;
      }
      setLayerType(k, null);
      return;
    }
  }
  
  void a()
  {
    if (this.d != null) {
      this.d.c();
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
    if (this.i != null) {
      return this.i.c();
    }
    return 0L;
  }
  
  public String getImageAssetsFolder()
  {
    return this.d.b();
  }
  
  public n getPerformanceTracker()
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
    if (getDrawable() == this.d)
    {
      super.invalidateDrawable(this.d);
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
  
  public void setAlign(DoraemonAnimationView.a parama)
  {
    this.d.a(parama);
  }
  
  public void setComposition(a parama)
  {
    Log.v(a, "Set Composition \n" + parama);
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
  
  public void setFontAssetDelegate(l paraml)
  {
    this.d.a(paraml);
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
  
  public void setShapeStrokeDelegate(io paramio)
  {
    this.d.a(paramio);
  }
  
  public void setSpeed(float paramFloat)
  {
    this.d.c(paramFloat);
  }
  
  public void setTextDelegate(d paramd)
  {
    this.d.a(paramd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     uilib.doraemon.DoraemonAnimationView
 * JD-Core Version:    0.7.0.1
 */