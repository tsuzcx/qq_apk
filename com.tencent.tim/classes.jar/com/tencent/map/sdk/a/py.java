package com.tencent.map.sdk.a;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import com.tencent.map.sdk.basemap.interfaces.IMapRenderView;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public final class py
  extends pv
  implements mh, pv.m, IMapRenderView
{
  private pn c;
  private boolean d;
  private Object e;
  
  public py(Context paramContext, TencentMapOptions paramTencentMapOptions)
  {
    super(paramContext);
    if ((paramTencentMapOptions != null) && (paramTencentMapOptions.getExtSurface() != null)) {
      this.e = paramTencentMapOptions.getExtSurface();
    }
    setEGLContextClientVersion(2);
    setPreserveEGLContextOnPause(true);
    setEGLConfigChooser(new pv.b(this, 8, 16));
    setEGLContextFactory(new py.1(this));
    if (this.e != null) {
      setEGLWindowSurfaceFactory(new py.2(this));
    }
    setRenderer(this);
    setRenderMode(0);
    if (Build.VERSION.SDK_INT < 11) {}
    for (;;)
    {
      this.d = bool;
      this.c = new pn(this, getContext().getApplicationContext(), paramTencentMapOptions);
      setContentDescription("地图");
      return;
      setPreserveEGLContextOnPause(true);
      bool = true;
    }
  }
  
  public final void a(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    if (this.c != null) {
      this.c.a(paramGL10, paramInt1, paramInt2);
    }
  }
  
  public final void a(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    if (this.c != null) {
      this.c.a(paramGL10, paramEGLConfig);
    }
  }
  
  public final boolean a(GL10 paramGL10)
  {
    if (this.c == null) {
      return false;
    }
    return this.c.a(paramGL10);
  }
  
  protected final boolean dispatchHoverEvent(MotionEvent paramMotionEvent)
  {
    if ((this.c != null) && (this.c.a(paramMotionEvent))) {
      return true;
    }
    return super.dispatchHoverEvent(paramMotionEvent);
  }
  
  public final int getEGLContextHash()
  {
    if (this.c != null) {
      return this.c.getEGLContextHash();
    }
    return 0;
  }
  
  public final pn getVectorMapDelegate()
  {
    return this.c;
  }
  
  public final void onDestroy()
  {
    if (this.c != null) {
      this.c.onDestroy();
    }
  }
  
  public final void onPause()
  {
    if (this.d) {
      super.onPause();
    }
    if (this.c != null) {
      this.c.onPause();
    }
  }
  
  public final void onRedraw()
  {
    if (getVisibility() == 0)
    {
      pv.i locali = this.b;
      synchronized (pv.a)
      {
        locali.l = true;
        pv.a.notifyAll();
        return;
      }
    }
  }
  
  public final void onResume()
  {
    if (this.d) {
      super.onResume();
    }
    if (this.c != null) {
      this.c.onResume();
    }
  }
  
  public final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.c != null) {
      this.c.a(paramInt1, paramInt2);
    }
  }
  
  public final void onSurfaceChanged(Object paramObject, int paramInt1, int paramInt2) {}
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.c != null) {
      return this.c.onTouchEvent(paramMotionEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.py
 * JD-Core Version:    0.7.0.1
 */