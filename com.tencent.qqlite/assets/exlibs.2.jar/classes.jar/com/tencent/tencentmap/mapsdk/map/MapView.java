package com.tencent.tencentmap.mapsdk.map;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ZoomControls;
import java.util.List;

public class MapView
  extends ViewGroup
  implements h
{
  ZoomControls a = null;
  View.OnClickListener b = null;
  View.OnClickListener c = null;
  long d = 10000L;
  private n e;
  private Handler f = null;
  private Runnable g = null;
  private boolean h = true;
  private b i = new b()
  {
    public final MapView a()
    {
      return MapView.this;
    }
  };
  private int j = 120000;
  private Handler k = new Handler();
  private Runnable l = new Runnable()
  {
    public final void run()
    {
      MapView.a(MapView.this);
      if (MapView.b(MapView.this) == null) {
        MapView.a(MapView.this, new Handler());
      }
      MapView.b(MapView.this).removeCallbacks(MapView.c(MapView.this));
      MapView.b(MapView.this).postDelayed(MapView.c(MapView.this), MapView.d(MapView.this));
    }
  };
  
  public MapView(Context paramContext)
  {
    super(paramContext);
    setClickable(true);
    if (isInEditMode() == true) {
      return;
    }
    if ((paramContext instanceof MapActivity)) {
      ((MapActivity)paramContext).a(this);
    }
    a(paramContext);
  }
  
  public MapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
  }
  
  private MapView(Context paramContext, AttributeSet paramAttributeSet, byte paramByte)
  {
    super(paramContext, paramAttributeSet, 0);
    setClickable(true);
    if (isInEditMode() == true) {
      return;
    }
    if ((paramContext instanceof MapActivity)) {
      ((MapActivity)paramContext).a(this);
    }
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    setBackgroundColor(Color.rgb(242, 239, 238));
    this.e = new n(paramContext);
    this.e.a(this.i);
    addView(this.e.a(), 0, new LayoutParams(-1, -1));
    this.a = new ZoomControls(getContext());
    this.b = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        MapView.e(MapView.this).e.a(1);
      }
    };
    this.c = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        MapView.e(MapView.this).e.b(1);
      }
    };
    this.a.setOnZoomInClickListener(this.b);
    this.a.setOnZoomOutClickListener(this.c);
    this.f = new Handler();
    this.g = new Runnable()
    {
      public final void run()
      {
        if (MapView.this.a.getVisibility() != 4) {
          MapView.this.a.setVisibility(4);
        }
      }
    };
    a(false, false);
    setEnabled(true);
    this.e.a.b(false);
    if (this.k == null) {
      this.k = new Handler();
    }
    if (this.l != null) {
      this.l.run();
    }
  }
  
  private boolean a(String paramString)
  {
    boolean bool1 = false;
    int n = this.e.b.a.size();
    int m = 0;
    while (m < n)
    {
      i locali = (i)this.e.b.a.get(m);
      boolean bool2 = bool1;
      if (locali != null)
      {
        bool2 = bool1;
        if (locali.h.equals(paramString)) {
          bool2 = true;
        }
      }
      m += 1;
      bool1 = bool2;
    }
    return bool1;
  }
  
  final void a()
  {
    this.a.bringToFront();
  }
  
  final void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.f == null) || (this.g == null)) {}
    do
    {
      do
      {
        return;
      } while (!this.h);
      if ((paramBoolean1) && (this.a.getVisibility() != 0)) {
        this.a.setVisibility(0);
      }
    } while (paramBoolean2 != true);
    this.f.removeCallbacks(this.g);
    this.f.postDelayed(this.g, this.d);
  }
  
  public final boolean addOverlay(Overlay paramOverlay)
  {
    boolean bool1 = false;
    if (paramOverlay == null) {}
    boolean bool2;
    do
    {
      List localList;
      do
      {
        return bool1;
        localList = this.e.b.c;
      } while (localList == null);
      bool2 = localList.add(paramOverlay);
      bool1 = bool2;
    } while (bool2 != true);
    postInvalidate();
    return bool2;
  }
  
  final void b()
  {
    if (this.e.a.g() == this.e.a.d()) {
      this.a.setIsZoomOutEnabled(false);
    }
    while (this.e.a.g() == this.e.a.c())
    {
      this.a.setIsZoomInEnabled(false);
      return;
      this.a.setIsZoomOutEnabled(true);
    }
    this.a.setIsZoomInEnabled(true);
  }
  
  public boolean canCoverCenter()
  {
    n.a locala = this.e.b;
    getMapCenter();
    return locala.d();
  }
  
  public final void clearAllOverlays()
  {
    List localList = this.e.b.c;
    if (localList == null) {}
    int m;
    do
    {
      return;
      m = localList.size();
    } while (m <= 0);
    while (m > 0)
    {
      Overlay localOverlay = (Overlay)localList.remove(0);
      int n = m - 1;
      m = n;
      if (localOverlay != null)
      {
        localOverlay.onRemoveOverlay();
        m = n;
      }
    }
    postInvalidate();
  }
  
  public MapController getController()
  {
    return this.e.d;
  }
  
  public int getLatitudeSpan()
  {
    return this.e.c.k.a();
  }
  
  public int getLongitudeSpan()
  {
    return this.e.c.k.b();
  }
  
  public GeoPoint getMapCenter()
  {
    return this.e.a.h();
  }
  
  public int getMaxZoomLevel()
  {
    return this.e.a.c();
  }
  
  public int getMinZoomLevel()
  {
    return this.e.a.d();
  }
  
  public Projection getProjection()
  {
    return this.e.c.k;
  }
  
  public final String getVersion()
  {
    return "1.0.7";
  }
  
  public int getZoomLevel()
  {
    return this.e.a.g();
  }
  
  public void invalidate()
  {
    super.invalidate();
    if (this.e == null) {}
    View localView;
    do
    {
      return;
      localView = this.e.a();
    } while (localView == null);
    localView.invalidate();
  }
  
  public final boolean isAppKeyAvailable()
  {
    n localn = this.e;
    return q.a == q.a.a;
  }
  
  public final boolean isGoogle()
  {
    return this.e.i == q.b.b;
  }
  
  public boolean isSatellite()
  {
    if (this.e == null) {}
    while (this.e.i != q.b.d) {
      return false;
    }
    return true;
  }
  
  public boolean isTraffic()
  {
    return a("trafficmap_raster");
  }
  
  public void onDestroy()
  {
    this.e.g();
    if (this.e.e != null) {
      this.e.e.b();
    }
    this.j = 1410065408;
    this.k.removeCallbacks(this.l);
    this.l = null;
    this.k = null;
    this.d = 1410065408L;
    this.f.removeCallbacks(this.g);
    this.g = null;
    this.f = null;
    removeView(this.e.a());
    n localn = this.e;
    localn.f.a.setIsLongpressEnabled(false);
    localn.b.b();
    localn.b.c();
    this.a.setOnZoomInClickListener(null);
    this.a.setOnZoomOutClickListener(null);
    this.b = null;
    this.c = null;
    removeView(this.a);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.e != null) {
      this.e.b().i();
    }
  }
  
  public void onPause()
  {
    this.e.i();
  }
  
  public void onRestart()
  {
    n localn = this.e;
  }
  
  public void onResume()
  {
    this.e.h();
    if (this.l != null) {
      this.l.run();
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject = new Point(paramInt1 / 2, paramInt2 / 2);
    if (isInEditMode() == true) {
      return;
    }
    this.e.c.a((Point)localObject);
    if ((this.e == null) || (this.e.b == null))
    {
      label62:
      localObject = new LayoutParams(-2, -2, paramInt1 - 8, paramInt2 - 5, 85);
      if (-1 != indexOfChild(this.a)) {
        break label225;
      }
      addView(this.a, (ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      this.e.a.a(paramInt1, paramInt2);
      if ((paramInt1 == 0) || (paramInt2 == 0) || (this.e.a.e == null) || (this.e.a.f == null)) {
        break;
      }
      this.e.a.a(this.e.a.e, this.e.a.f, true);
      this.e.a.e = null;
      this.e.a.f = null;
      return;
      this.e.b.a(paramInt1, paramInt2, getContext());
      break label62;
      label225:
      updateViewLayout(this.a, (ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void onStop()
  {
    n localn = this.e;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.e == null) {}
    while (this.e.b.a(paramMotionEvent)) {
      return true;
    }
    this.e.a(paramMotionEvent);
    if (paramMotionEvent.getAction() == 0) {
      a(true, false);
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      if (paramMotionEvent.getAction() == 1) {
        a(true, true);
      }
    }
  }
  
  public void postInvalidate()
  {
    super.postInvalidate();
    if (this.e == null) {}
    View localView;
    do
    {
      return;
      localView = this.e.a();
    } while (localView == null);
    localView.postInvalidate();
  }
  
  public void refreshMap()
  {
    postInvalidate();
  }
  
  public final boolean removeOverlay(Overlay paramOverlay)
  {
    boolean bool1;
    if (paramOverlay == null) {
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      List localList = this.e.b.c;
      if (localList == null) {
        return false;
      }
      bool2 = localList.remove(paramOverlay);
      if (!bool2) {
        return false;
      }
      paramOverlay.onRemoveOverlay();
      bool1 = bool2;
    } while (bool2 != true);
    postInvalidate();
    return bool2;
  }
  
  public void setBuiltInZoomControls(boolean paramBoolean)
  {
    this.h = paramBoolean;
    if (this.h == true)
    {
      a(true, true);
      return;
    }
    this.f.removeCallbacks(this.g);
    this.a.setVisibility(4);
  }
  
  public final void setGoogleMapEnable(boolean paramBoolean)
  {
    if (this.e == null) {
      return;
    }
    if (paramBoolean == true)
    {
      this.e.b.a(q.b.b, getContext());
      return;
    }
    this.e.b.a(q.b.c, getContext());
  }
  
  public final void setLogoAnchor(int paramInt)
  {
    if (this.e == null) {
      return;
    }
    this.e.b.c(paramInt);
  }
  
  public final void setLogoMarginBottom(int paramInt)
  {
    if (this.e == null) {
      return;
    }
    this.e.b.a(paramInt);
    postInvalidate();
  }
  
  public final void setLogoMarginLeft(int paramInt)
  {
    if (this.e == null) {
      return;
    }
    this.e.b.b(paramInt);
    postInvalidate();
  }
  
  public final void setLogoMarginRate(int paramInt, float paramFloat)
  {
    if (this.e == null) {
      return;
    }
    this.e.b.a(paramInt, paramFloat);
    postInvalidate();
  }
  
  public void setSatellite(boolean paramBoolean)
  {
    if (this.e == null) {
      return;
    }
    if (paramBoolean == true)
    {
      this.e.b.a(q.b.d, getContext());
      return;
    }
    this.e.b.a(q.b.c, getContext());
  }
  
  public void setTraffic(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    while (a("trafficmap_raster") == true) {
      synchronized (this.e.b.d)
      {
        this.e.b.a("trafficmap_raster");
        this.e.a.b = false;
        this.e.a.b(false);
        return;
      }
    }
    this.e.b.a(getContext());
    this.e.a.b(false);
  }
  
  public static class LayoutParams
    extends ViewGroup.LayoutParams
  {
    public static final int BOTTOM = 80;
    public static final int BOTTOM_CENTER = 81;
    public static final int CENTER = 17;
    public static final int CENTER_HORIZONTAL = 1;
    public static final int CENTER_VERTICAL = 16;
    public static final int LEFT = 3;
    public static final int MODE_MAP = 0;
    public static final int MODE_VIEW = 1;
    public static final int RIGHT = 5;
    public static final int TOP = 48;
    public static final int TOP_LEFT = 51;
    public int alignment = 51;
    public int mode = 1;
    public GeoPoint point = null;
    public int x = 0;
    public int y = 0;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      super(paramInt2);
      this.x = paramInt3;
      this.y = paramInt4;
      this.alignment = paramInt5;
    }
    
    public LayoutParams(int paramInt1, int paramInt2, GeoPoint paramGeoPoint, int paramInt3)
    {
      this(paramInt1, paramInt2, paramGeoPoint, 0, 0, paramInt3);
    }
    
    public LayoutParams(int paramInt1, int paramInt2, GeoPoint paramGeoPoint, int paramInt3, int paramInt4, int paramInt5)
    {
      super(paramInt2);
      this.mode = 0;
      this.point = paramGeoPoint;
      this.x = paramInt3;
      this.y = paramInt4;
      this.alignment = paramInt5;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
  }
  
  static abstract interface a
  {
    public abstract void i();
  }
  
  static abstract interface b
  {
    public abstract MapView a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.MapView
 * JD-Core Version:    0.7.0.1
 */