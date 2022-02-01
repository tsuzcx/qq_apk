package uilib.doraemon;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.token.aus;
import com.tencent.token.aut;
import com.tencent.token.auu;
import com.tencent.token.auv;
import com.tencent.token.auv.3;
import com.tencent.token.auv.4;
import com.tencent.token.auw;
import com.tencent.token.auy;
import com.tencent.token.auz;
import com.tencent.token.ava;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DoraemonAnimationView
  extends ImageView
{
  private static final String a = "DoraemonAnimationView";
  private static final Map<String, aus> b = new HashMap();
  private static final Map<String, WeakReference<aus>> c = new HashMap();
  private final auv d = new auv(this);
  private int e;
  private boolean f = false;
  private boolean g = false;
  private boolean h = false;
  private aus i;
  
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
    aus localaus = this.i;
    if (localaus != null) {
      return localaus.a();
    }
    return 0L;
  }
  
  public String getImageAssetsFolder()
  {
    return this.d.g;
  }
  
  public auy getPerformanceTracker()
  {
    auv localauv = this.d;
    if (localauv.a != null) {
      return localauv.a.f;
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
    auv localauv = this.d;
    if (localDrawable == localauv)
    {
      super.invalidateDrawable(localauv);
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
      auv localauv = this.d;
      localauv.e.clear();
      localauv.b.cancel();
      b();
      this.f = true;
    }
    super.onDetachedFromWindow();
  }
  
  public void setAlign(a parama)
  {
    this.d.o = parama;
  }
  
  public void setComposition(aus paramaus)
  {
    new StringBuilder("Set Composition \n").append(paramaus);
    this.d.setCallback(this);
    boolean bool = this.d.a(paramaus);
    b();
    if (!bool) {
      return;
    }
    setImageDrawable(null);
    setImageDrawable(this.d);
    this.i = paramaus;
    requestLayout();
  }
  
  public void setFontAssetDelegate(auw paramauw)
  {
    auv localauv = this.d;
    localauv.j = paramauw;
    if (localauv.i != null) {
      localauv.i.a = paramauw;
    }
  }
  
  public void setImageAssetDelegate(aut paramaut)
  {
    auv localauv = this.d;
    localauv.h = paramaut;
    if (localauv.f != null) {
      localauv.f.a = paramaut;
    }
  }
  
  public void setImageAssetsFolder(String paramString)
  {
    this.d.g = paramString;
  }
  
  public void setMaxFrame(int paramInt)
  {
    auv localauv = this.d;
    if (localauv.a == null)
    {
      localauv.e.add(new auv.4(localauv, paramInt));
      return;
    }
    localauv.b(paramInt / localauv.a.b());
  }
  
  public void setMaxProgress(float paramFloat)
  {
    this.d.b(paramFloat);
  }
  
  public void setMinFrame(int paramInt)
  {
    auv localauv = this.d;
    if (localauv.a == null)
    {
      localauv.e.add(new auv.3(localauv, paramInt));
      return;
    }
    localauv.a(paramInt / localauv.a.b());
  }
  
  public void setMinProgress(float paramFloat)
  {
    this.d.a(paramFloat);
  }
  
  public void setPerformanceTrackingEnabled(boolean paramBoolean)
  {
    auv localauv = this.d;
    localauv.n = paramBoolean;
    if (localauv.a != null) {
      localauv.a.a(paramBoolean);
    }
  }
  
  public void setProgress(float paramFloat)
  {
    this.d.d(paramFloat);
  }
  
  public void setScale(float paramFloat)
  {
    auv localauv = this.d;
    localauv.d = paramFloat;
    localauv.e();
    if (getDrawable() == this.d)
    {
      setImageDrawable(null);
      setImageDrawable(this.d);
    }
  }
  
  public void setShapeStrokeDelegate(auz paramauz)
  {
    this.d.l = paramauz;
  }
  
  public void setSpeed(float paramFloat)
  {
    this.d.c(paramFloat);
  }
  
  public void setTextDelegate(auu paramauu)
  {
    this.d.k = paramauu;
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