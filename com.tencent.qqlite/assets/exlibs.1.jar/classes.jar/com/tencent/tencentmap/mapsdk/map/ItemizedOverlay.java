package com.tencent.tencentmap.mapsdk.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public abstract class ItemizedOverlay<Item extends OverlayItem>
  extends Overlay
{
  private boolean a = true;
  private Drawable b;
  private ItemizedOverlay<Item>.b c = null;
  private OnFocusChangeListener d = null;
  private int e = -1;
  private int f = -1;
  private Item g;
  private boolean h = false;
  private boolean i = true;
  
  public ItemizedOverlay(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("Contex can not be null!");
    }
    String str = "marker_small.png";
    if (q.a()) {
      str = "marker_big.png";
    }
    Bitmap localBitmap = q.a(paramContext, str);
    if (localBitmap == null) {
      throw new IllegalArgumentException(str + " is missing in tencent mapsdk!");
    }
    this.b = new BitmapDrawable(paramContext.getResources(), localBitmap);
    if (this.b == null) {
      throw new IllegalArgumentException("the drawable can not be null!");
    }
    boundCenterBottom(this.b);
  }
  
  public ItemizedOverlay(Drawable paramDrawable)
  {
    this.b = paramDrawable;
    if (this.b == null) {
      throw new IllegalArgumentException("the drawable can not be null!");
    }
    paramDrawable = this.b.getBounds();
    if (paramDrawable == null) {
      boundCenterBottom(this.b);
    }
    while ((paramDrawable.left != 0) || (paramDrawable.right != 0) || (paramDrawable.top != 0) || (paramDrawable.bottom != 0)) {
      return;
    }
    boundCenterBottom(this.b);
  }
  
  private static Drawable a(Drawable paramDrawable, a parama)
  {
    if ((paramDrawable == null) || (a.a == parama)) {
      return null;
    }
    paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
    Rect localRect = paramDrawable.getBounds();
    int n = localRect.width() / 2;
    int m = -localRect.height();
    int k = 0;
    int j = m;
    if (parama == a.b)
    {
      j = m / 2;
      k = -j;
    }
    paramDrawable.setBounds(-n, j, n, k);
    return paramDrawable;
  }
  
  private void a(Canvas paramCanvas, boolean paramBoolean, Item paramItem, Point paramPoint)
  {
    Drawable localDrawable = paramItem.getMarker();
    paramItem = localDrawable;
    if (localDrawable == null) {
      paramItem = this.b;
    }
    if (paramBoolean)
    {
      paramCanvas.save();
      paramCanvas.translate(paramPoint.x, paramPoint.y);
      paramItem.setColorFilter(2130706432, PorterDuff.Mode.SRC_IN);
      paramCanvas.skew(-0.89F, 0.0F);
      paramCanvas.scale(1.0F, 0.5F);
      paramItem.draw(paramCanvas);
      paramItem.clearColorFilter();
      paramCanvas.restore();
      return;
    }
    paramCanvas.save();
    paramCanvas.translate(paramPoint.x, paramPoint.y);
    paramItem.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public static Drawable boundCenter(Drawable paramDrawable)
  {
    return a(paramDrawable, a.b);
  }
  
  public static Drawable boundCenterBottom(Drawable paramDrawable)
  {
    return a(paramDrawable, a.c);
  }
  
  protected abstract Item createItem(int paramInt);
  
  public void draw(Canvas paramCanvas, MapView paramMapView)
  {
    int k = size();
    if (k <= 0) {}
    label88:
    do
    {
      return;
      paramMapView = paramMapView.getProjection();
      int j = 0;
      while (j < k)
      {
        try
        {
          localOverlayItem = getItem(getIndexToDraw(j));
          if (localOverlayItem != null)
          {
            Point localPoint = paramMapView.toPixels(localOverlayItem.getPoint(), null);
            if (localPoint != null)
            {
              if (this.i == true) {
                a(paramCanvas, true, localOverlayItem, localPoint);
              }
              a(paramCanvas, false, localOverlayItem, localPoint);
            }
          }
        }
        catch (Exception localException)
        {
          OverlayItem localOverlayItem;
          break label88;
        }
        j += 1;
      }
      localOverlayItem = getFocus();
    } while ((!this.a) || (localOverlayItem == null));
    paramMapView = paramMapView.toPixels(localOverlayItem.getPoint(), null);
    if (this.i == true) {
      a(paramCanvas, true, localOverlayItem, paramMapView);
    }
    a(paramCanvas, false, localOverlayItem, paramMapView);
  }
  
  public GeoPoint getCenter()
  {
    if (this.c == null) {
      return null;
    }
    return new GeoPoint(this.c.a, this.c.b);
  }
  
  public Item getFocus()
  {
    if (this.c == null) {}
    while (this.f == -1) {
      return null;
    }
    return this.c.a(this.f);
  }
  
  protected int getIndexToDraw(int paramInt)
  {
    if (this.c == null) {
      return -1;
    }
    return this.c.b(paramInt);
  }
  
  public final Item getItem(int paramInt)
  {
    if (this.c == null) {
      return null;
    }
    return this.c.a(paramInt);
  }
  
  public final int getLastFocusedIndex()
  {
    return this.e;
  }
  
  public int getLatSpanE6()
  {
    if (this.c == null) {
      return 0;
    }
    return this.c.a(true);
  }
  
  public int getLonSpanE6()
  {
    if (this.c == null) {
      return 0;
    }
    return this.c.a(false);
  }
  
  public boolean isShadowEnable()
  {
    return this.i;
  }
  
  public Item nextFocus(boolean paramBoolean)
  {
    if ((this.c == null) || (this.c.a() == 0)) {}
    int j;
    label100:
    do
    {
      do
      {
        return null;
        if (this.e != -1) {
          break;
        }
      } while (this.f == -1);
      return this.c.a(0);
      if (this.f == -1) {}
      for (j = this.e;; j = this.f)
      {
        if (!paramBoolean) {
          break label100;
        }
        if ((this.c == null) || (j == this.c.a() - 1)) {
          break;
        }
        return this.c.a(j + 1);
      }
    } while ((this.c == null) || (j == 0));
    return this.c.a(j - 1);
  }
  
  public void onEmptyTap(GeoPoint paramGeoPoint)
  {
    super.onEmptyTap(paramGeoPoint);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent, MapView paramMapView)
  {
    return false;
  }
  
  public boolean onLongPress(GeoPoint paramGeoPoint, MotionEvent paramMotionEvent, MapView paramMapView)
  {
    if (this.c == null) {
      return false;
    }
    this.c.a(paramGeoPoint, paramMapView);
    this.h = true;
    paramGeoPoint = this.g;
    return false;
  }
  
  protected boolean onTap(int paramInt)
  {
    if (this.c == null) {}
    while (paramInt == this.f) {
      return false;
    }
    setFocus(getItem(paramInt));
    return false;
  }
  
  public boolean onTap(GeoPoint paramGeoPoint, MapView paramMapView)
  {
    if (this.c == null) {
      return false;
    }
    return this.c.b(paramGeoPoint, paramMapView);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, MapView paramMapView)
  {
    if ((!this.h) || (this.g == null)) {
      return false;
    }
    if (!this.g.isDragable()) {
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    case 0: 
    default: 
      return false;
    case 1: 
    case 3: 
    case 4: 
      this.h = false;
      this.g = null;
      return true;
    }
    int j = (int)paramMotionEvent.getX();
    int k = (int)paramMotionEvent.getY();
    paramMotionEvent = paramMapView.getProjection().fromPixels(j, k);
    this.g.setPoint(paramMotionEvent);
    paramMapView.invalidate();
    return true;
  }
  
  public boolean onTrackballEvent(MotionEvent paramMotionEvent, MapView paramMapView)
  {
    return false;
  }
  
  protected final void populate()
  {
    if (this.c != null) {
      this.c.b();
    }
    this.c = new b();
    this.e = -1;
    this.f = -1;
  }
  
  public void setDrawFocusedItem(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void setFocus(Item paramItem)
  {
    if (this.c == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while ((paramItem != null) && (this.f == this.c.a(paramItem)));
        if ((paramItem == null) && (this.f != -1))
        {
          if (this.d != null) {
            this.d.onFocusChanged(this, paramItem);
          }
          this.f = -1;
          return;
        }
        this.f = this.c.a(paramItem);
      } while (this.f == -1);
      setLastFocusedIndex(this.f);
    } while (this.d == null);
    this.d.onFocusChanged(this, paramItem);
  }
  
  protected void setLastFocusedIndex(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setOnFocusChangeListener(OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.d = paramOnFocusChangeListener;
  }
  
  public void setShadowEnable(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public abstract int size();
  
  public static abstract interface OnFocusChangeListener
  {
    public abstract void onFocusChanged(ItemizedOverlay<?> paramItemizedOverlay, OverlayItem paramOverlayItem);
  }
  
  static enum a
  {
    private a() {}
  }
  
  final class b
    implements Comparator<Integer>
  {
    int a = 0;
    int b = 0;
    private ArrayList<Item> d = new ArrayList();
    private ArrayList<Integer> e = new ArrayList();
    
    public b()
    {
      if (this.d != null) {
        this.d.clear();
      }
      if (this.e != null) {
        this.e.clear();
      }
      int k = 0;
      int i = 0;
      int m = ItemizedOverlay.this.size();
      int j = 0;
      while (j < m)
      {
        this.e.add(Integer.valueOf(j));
        OverlayItem localOverlayItem = ItemizedOverlay.this.createItem(j);
        k += localOverlayItem.getPoint().getLatitudeE6();
        i += localOverlayItem.getPoint().getLongitudeE6();
        this.d.add(localOverlayItem);
        j += 1;
      }
      if (m > 0) {
        this.a = (k / m);
      }
      for (this.b = (i / m);; this.b = 0)
      {
        Collections.sort(this.e, this);
        return;
        this.a = 0;
      }
    }
    
    private int c(GeoPoint paramGeoPoint, MapView paramMapView)
    {
      Projection localProjection = paramMapView.getProjection();
      Point localPoint1 = localProjection.toPixels(paramGeoPoint, null);
      int m = -1;
      double d2 = 1.7976931348623157E+308D;
      int k = 2147483647;
      int i1 = this.d.size();
      int i = 0;
      if (i < i1)
      {
        paramGeoPoint = (OverlayItem)this.d.get(i);
        int j = m;
        double d3 = d2;
        int n = k;
        double d1;
        if (paramGeoPoint != null)
        {
          d1 = -1.0D;
          Point localPoint2 = localProjection.toPixels(paramGeoPoint.getPoint(), null);
          paramMapView = paramGeoPoint.getMarker();
          Point localPoint3 = new Point(localPoint1.x - localPoint2.x, localPoint1.y - localPoint2.y);
          paramGeoPoint = paramMapView;
          if (paramMapView == null) {
            paramGeoPoint = ItemizedOverlay.a(ItemizedOverlay.this);
          }
          if (paramGeoPoint.getBounds().contains(localPoint3.x, localPoint3.y))
          {
            paramGeoPoint = new Point(localPoint1.x - localPoint2.x, localPoint1.y - localPoint2.y);
            j = paramGeoPoint.x;
            n = paramGeoPoint.x;
            int i2 = paramGeoPoint.y;
            d1 = paramGeoPoint.y * i2 + j * n;
          }
          if ((d1 < 0.0D) || (d1 >= d2)) {
            break label277;
          }
          n = b(i);
          j = i;
          d3 = d1;
        }
        for (;;)
        {
          i += 1;
          m = j;
          d2 = d3;
          k = n;
          break;
          label277:
          j = m;
          d3 = d2;
          n = k;
          if (d1 == d2)
          {
            j = m;
            d3 = d2;
            n = k;
            if (b(i) > k)
            {
              j = i;
              d3 = d2;
              n = k;
            }
          }
        }
      }
      return m;
    }
    
    public final int a()
    {
      return this.d.size();
    }
    
    public final int a(Item paramItem)
    {
      int k = -1;
      int m = this.d.size();
      int j = k;
      int i;
      if (paramItem != null) {
        i = 0;
      }
      for (;;)
      {
        j = k;
        if (i < m)
        {
          if (paramItem.equals(this.d.get(i))) {
            j = i;
          }
        }
        else {
          return j;
        }
        i += 1;
      }
    }
    
    public final int a(boolean paramBoolean)
    {
      if (this.d.size() == 0) {
        return 0;
      }
      int k = -2147483648;
      int j = 2147483647;
      Iterator localIterator = this.d.iterator();
      if (localIterator.hasNext())
      {
        GeoPoint localGeoPoint = ((OverlayItem)localIterator.next()).getPoint();
        if (paramBoolean) {}
        for (int i = localGeoPoint.getLatitudeE6();; i = localGeoPoint.getLongitudeE6())
        {
          int m = k;
          if (i > k) {
            m = i;
          }
          k = m;
          if (i >= j) {
            break;
          }
          k = m;
          j = i;
          break;
        }
      }
      return k - j;
    }
    
    public final Item a(int paramInt)
    {
      if (this.d == null) {}
      while ((this.d.size() <= paramInt) || (paramInt < 0)) {
        return null;
      }
      return (OverlayItem)this.d.get(paramInt);
    }
    
    public final boolean a(GeoPoint paramGeoPoint, MapView paramMapView)
    {
      int i = c(paramGeoPoint, paramMapView);
      if (i != -1) {
        ItemizedOverlay.a(ItemizedOverlay.this, (OverlayItem)this.d.get(i));
      }
      return false;
    }
    
    public final int b(int paramInt)
    {
      if (this.e.size() <= paramInt) {
        return -1;
      }
      return ((Integer)this.e.get(paramInt)).intValue();
    }
    
    public final void b()
    {
      if (this.d != null) {
        this.d.clear();
      }
      if (this.e != null) {
        this.e.clear();
      }
    }
    
    public final boolean b(GeoPoint paramGeoPoint, MapView paramMapView)
    {
      boolean bool = false;
      int i = c(paramGeoPoint, paramMapView);
      if (i >= 0) {
        bool = ItemizedOverlay.this.onTap(i);
      }
      for (;;)
      {
        paramMapView.postInvalidate();
        return bool;
        ItemizedOverlay.this.setFocus(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.ItemizedOverlay
 * JD-Core Version:    0.7.0.1
 */