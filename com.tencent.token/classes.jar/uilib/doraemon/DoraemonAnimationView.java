package uilib.doraemon;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.token.ass;
import com.tencent.token.ast;
import com.tencent.token.asu;
import com.tencent.token.asv;
import com.tencent.token.asv.3;
import com.tencent.token.asv.4;
import com.tencent.token.asw;
import com.tencent.token.asy;
import com.tencent.token.asz;
import com.tencent.token.ata;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DoraemonAnimationView
  extends ImageView
{
  private static final String a = "DoraemonAnimationView";
  private static final Map<String, ass> b = new HashMap();
  private static final Map<String, WeakReference<ass>> c = new HashMap();
  private final asv d = new asv(this);
  private int e;
  private boolean f = false;
  private boolean g = false;
  private boolean h = false;
  private ass i;
  
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
    ass localass = this.i;
    if (localass != null) {
      return localass.a();
    }
    return 0L;
  }
  
  public String getImageAssetsFolder()
  {
    return this.d.g;
  }
  
  public asy getPerformanceTracker()
  {
    asv localasv = this.d;
    if (localasv.a != null) {
      return localasv.a.f;
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
    asv localasv = this.d;
    if (localDrawable == localasv)
    {
      super.invalidateDrawable(localasv);
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
      asv localasv = this.d;
      localasv.e.clear();
      localasv.b.cancel();
      b();
      this.f = true;
    }
    super.onDetachedFromWindow();
  }
  
  public void setAlign(a parama)
  {
    this.d.o = parama;
  }
  
  public void setComposition(ass paramass)
  {
    new StringBuilder("Set Composition \n").append(paramass);
    this.d.setCallback(this);
    boolean bool = this.d.a(paramass);
    b();
    if (!bool) {
      return;
    }
    setImageDrawable(null);
    setImageDrawable(this.d);
    this.i = paramass;
    requestLayout();
  }
  
  public void setFontAssetDelegate(asw paramasw)
  {
    asv localasv = this.d;
    localasv.j = paramasw;
    if (localasv.i != null) {
      localasv.i.a = paramasw;
    }
  }
  
  public void setImageAssetDelegate(ast paramast)
  {
    asv localasv = this.d;
    localasv.h = paramast;
    if (localasv.f != null) {
      localasv.f.a = paramast;
    }
  }
  
  public void setImageAssetsFolder(String paramString)
  {
    this.d.g = paramString;
  }
  
  public void setMaxFrame(int paramInt)
  {
    asv localasv = this.d;
    if (localasv.a == null)
    {
      localasv.e.add(new asv.4(localasv, paramInt));
      return;
    }
    localasv.b(paramInt / localasv.a.b());
  }
  
  public void setMaxProgress(float paramFloat)
  {
    this.d.b(paramFloat);
  }
  
  public void setMinFrame(int paramInt)
  {
    asv localasv = this.d;
    if (localasv.a == null)
    {
      localasv.e.add(new asv.3(localasv, paramInt));
      return;
    }
    localasv.a(paramInt / localasv.a.b());
  }
  
  public void setMinProgress(float paramFloat)
  {
    this.d.a(paramFloat);
  }
  
  public void setPerformanceTrackingEnabled(boolean paramBoolean)
  {
    asv localasv = this.d;
    localasv.n = paramBoolean;
    if (localasv.a != null) {
      localasv.a.a(paramBoolean);
    }
  }
  
  public void setProgress(float paramFloat)
  {
    this.d.d(paramFloat);
  }
  
  public void setScale(float paramFloat)
  {
    asv localasv = this.d;
    localasv.d = paramFloat;
    localasv.e();
    if (getDrawable() == this.d)
    {
      setImageDrawable(null);
      setImageDrawable(this.d);
    }
  }
  
  public void setShapeStrokeDelegate(asz paramasz)
  {
    this.d.l = paramasz;
  }
  
  public void setSpeed(float paramFloat)
  {
    this.d.c(paramFloat);
  }
  
  public void setTextDelegate(asu paramasu)
  {
    this.d.k = paramasu;
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