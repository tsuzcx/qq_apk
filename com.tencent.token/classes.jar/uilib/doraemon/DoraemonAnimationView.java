package uilib.doraemon;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.token.avq;
import com.tencent.token.avr;
import com.tencent.token.avs;
import com.tencent.token.avt;
import com.tencent.token.avt.3;
import com.tencent.token.avt.4;
import com.tencent.token.avu;
import com.tencent.token.avw;
import com.tencent.token.avx;
import com.tencent.token.avy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DoraemonAnimationView
  extends ImageView
{
  private static final String a = "DoraemonAnimationView";
  private static final Map<String, avq> b = new HashMap();
  private static final Map<String, WeakReference<avq>> c = new HashMap();
  private final avt d = new avt(this);
  private int e;
  private boolean f = false;
  private boolean g = false;
  private boolean h = false;
  private avq i;
  
  public DoraemonAnimationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public DoraemonAnimationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.e = b.b;
    this.d.b();
    setProgress(0.0F);
    this.d.a();
    if ((Build.VERSION.SDK_INT >= 17) && (Settings.Global.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0F) == 0.0F)) {
      this.d.m = true;
    }
    b();
  }
  
  @TargetApi(11)
  private void b()
  {
    boolean bool = this.h;
    int k = 1;
    int j;
    if ((bool) && (this.d.b.isRunning())) {
      j = 1;
    } else {
      j = 0;
    }
    if (j != 0) {
      k = 2;
    }
    setLayerType(k, null);
  }
  
  public long getDuration()
  {
    avq localavq = this.i;
    if (localavq != null) {
      return localavq.a();
    }
    return 0L;
  }
  
  public String getImageAssetsFolder()
  {
    return this.d.g;
  }
  
  public avw getPerformanceTracker()
  {
    avt localavt = this.d;
    if (localavt.a != null) {
      return localavt.a.f;
    }
    return null;
  }
  
  public float getProgress()
  {
    return this.d.c;
  }
  
  public float getScale()
  {
    return this.d.d;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    Drawable localDrawable = getDrawable();
    avt localavt = this.d;
    if (localDrawable == localavt)
    {
      super.invalidateDrawable(localavt);
      return;
    }
    super.invalidateDrawable(paramDrawable);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((this.g) && (this.f))
    {
      this.d.c();
      b();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    if (this.d.b.isRunning())
    {
      avt localavt = this.d;
      localavt.e.clear();
      localavt.b.cancel();
      b();
      this.f = true;
    }
    super.onDetachedFromWindow();
  }
  
  public void setAlign(a parama)
  {
    this.d.o = parama;
  }
  
  public void setComposition(avq paramavq)
  {
    new StringBuilder("Set Composition \n").append(paramavq);
    this.d.setCallback(this);
    boolean bool = this.d.a(paramavq);
    b();
    if (!bool) {
      return;
    }
    setImageDrawable(null);
    setImageDrawable(this.d);
    this.i = paramavq;
    requestLayout();
  }
  
  public void setFontAssetDelegate(avu paramavu)
  {
    avt localavt = this.d;
    localavt.j = paramavu;
    if (localavt.i != null) {
      localavt.i.a = paramavu;
    }
  }
  
  public void setImageAssetDelegate(avr paramavr)
  {
    avt localavt = this.d;
    localavt.h = paramavr;
    if (localavt.f != null) {
      localavt.f.a = paramavr;
    }
  }
  
  public void setImageAssetsFolder(String paramString)
  {
    this.d.g = paramString;
  }
  
  public void setMaxFrame(int paramInt)
  {
    avt localavt = this.d;
    if (localavt.a == null)
    {
      localavt.e.add(new avt.4(localavt, paramInt));
      return;
    }
    localavt.b(paramInt / localavt.a.b());
  }
  
  public void setMaxProgress(float paramFloat)
  {
    this.d.b(paramFloat);
  }
  
  public void setMinFrame(int paramInt)
  {
    avt localavt = this.d;
    if (localavt.a == null)
    {
      localavt.e.add(new avt.3(localavt, paramInt));
      return;
    }
    localavt.a(paramInt / localavt.a.b());
  }
  
  public void setMinProgress(float paramFloat)
  {
    this.d.a(paramFloat);
  }
  
  public void setPerformanceTrackingEnabled(boolean paramBoolean)
  {
    avt localavt = this.d;
    localavt.n = paramBoolean;
    if (localavt.a != null) {
      localavt.a.a(paramBoolean);
    }
  }
  
  public void setProgress(float paramFloat)
  {
    this.d.d(paramFloat);
  }
  
  public void setScale(float paramFloat)
  {
    avt localavt = this.d;
    localavt.d = paramFloat;
    localavt.e();
    if (getDrawable() == this.d)
    {
      setImageDrawable(null);
      setImageDrawable(this.d);
    }
  }
  
  public void setShapeStrokeDelegate(avx paramavx)
  {
    this.d.l = paramavx;
  }
  
  public void setSpeed(float paramFloat)
  {
    this.d.c(paramFloat);
  }
  
  public void setTextDelegate(avs paramavs)
  {
    this.d.k = paramavs;
  }
  
  public static enum a
  {
    private a() {}
  }
  
  public static enum b
  {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     uilib.doraemon.DoraemonAnimationView
 * JD-Core Version:    0.7.0.1
 */