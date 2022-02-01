package uilib.doraemon;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.token.ast;
import com.tencent.token.asu;
import com.tencent.token.asv;
import com.tencent.token.asw;
import com.tencent.token.asw.3;
import com.tencent.token.asw.4;
import com.tencent.token.asx;
import com.tencent.token.asz;
import com.tencent.token.ata;
import com.tencent.token.atb;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DoraemonAnimationView
  extends ImageView
{
  private static final String a = "DoraemonAnimationView";
  private static final Map<String, ast> b = new HashMap();
  private static final Map<String, WeakReference<ast>> c = new HashMap();
  private final asw d = new asw(this);
  private int e;
  private boolean f = false;
  private boolean g = false;
  private boolean h = false;
  private ast i;
  
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
    ast localast = this.i;
    if (localast != null) {
      return localast.a();
    }
    return 0L;
  }
  
  public String getImageAssetsFolder()
  {
    return this.d.g;
  }
  
  public asz getPerformanceTracker()
  {
    asw localasw = this.d;
    if (localasw.a != null) {
      return localasw.a.f;
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
    asw localasw = this.d;
    if (localDrawable == localasw)
    {
      super.invalidateDrawable(localasw);
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
      asw localasw = this.d;
      localasw.e.clear();
      localasw.b.cancel();
      b();
      this.f = true;
    }
    super.onDetachedFromWindow();
  }
  
  public void setAlign(a parama)
  {
    this.d.o = parama;
  }
  
  public void setComposition(ast paramast)
  {
    new StringBuilder("Set Composition \n").append(paramast);
    this.d.setCallback(this);
    boolean bool = this.d.a(paramast);
    b();
    if (!bool) {
      return;
    }
    setImageDrawable(null);
    setImageDrawable(this.d);
    this.i = paramast;
    requestLayout();
  }
  
  public void setFontAssetDelegate(asx paramasx)
  {
    asw localasw = this.d;
    localasw.j = paramasx;
    if (localasw.i != null) {
      localasw.i.a = paramasx;
    }
  }
  
  public void setImageAssetDelegate(asu paramasu)
  {
    asw localasw = this.d;
    localasw.h = paramasu;
    if (localasw.f != null) {
      localasw.f.a = paramasu;
    }
  }
  
  public void setImageAssetsFolder(String paramString)
  {
    this.d.g = paramString;
  }
  
  public void setMaxFrame(int paramInt)
  {
    asw localasw = this.d;
    if (localasw.a == null)
    {
      localasw.e.add(new asw.4(localasw, paramInt));
      return;
    }
    localasw.b(paramInt / localasw.a.b());
  }
  
  public void setMaxProgress(float paramFloat)
  {
    this.d.b(paramFloat);
  }
  
  public void setMinFrame(int paramInt)
  {
    asw localasw = this.d;
    if (localasw.a == null)
    {
      localasw.e.add(new asw.3(localasw, paramInt));
      return;
    }
    localasw.a(paramInt / localasw.a.b());
  }
  
  public void setMinProgress(float paramFloat)
  {
    this.d.a(paramFloat);
  }
  
  public void setPerformanceTrackingEnabled(boolean paramBoolean)
  {
    asw localasw = this.d;
    localasw.n = paramBoolean;
    if (localasw.a != null) {
      localasw.a.a(paramBoolean);
    }
  }
  
  public void setProgress(float paramFloat)
  {
    this.d.d(paramFloat);
  }
  
  public void setScale(float paramFloat)
  {
    asw localasw = this.d;
    localasw.d = paramFloat;
    localasw.e();
    if (getDrawable() == this.d)
    {
      setImageDrawable(null);
      setImageDrawable(this.d);
    }
  }
  
  public void setShapeStrokeDelegate(ata paramata)
  {
    this.d.l = paramata;
  }
  
  public void setSpeed(float paramFloat)
  {
    this.d.c(paramFloat);
  }
  
  public void setTextDelegate(asv paramasv)
  {
    this.d.k = paramasv;
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