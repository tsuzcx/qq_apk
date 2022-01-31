package com.tencent.mobileqq.troop.widget;

import NearbyGroup.GroupArea;
import NearbyGroup.GroupInfo;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;
import com.tencent.tencentmap.mapsdk.map.ItemizedOverlay;
import com.tencent.tencentmap.mapsdk.map.MapView;
import java.util.ArrayList;
import java.util.Iterator;

public class NearbyTroopsMapViewItemOverlay
  extends ItemizedOverlay
{
  public Context a;
  public Bitmap a;
  public Drawable a;
  public NearbyTroopsMapViewItemOverlay.Callback a;
  public String a;
  public ArrayList a;
  public Bitmap b;
  public ArrayList b;
  public Bitmap c;
  
  public NearbyTroopsMapViewItemOverlay(Drawable paramDrawable, String paramString)
  {
    super(paramDrawable);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangString = paramString;
    if (size() > 0) {
      populate();
    }
  }
  
  private double a(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2)
  {
    return Math.sqrt(Math.pow(paramGeoPoint1.getLatitudeE6() - paramGeoPoint2.getLatitudeE6(), 2.0D) + Math.pow(paramGeoPoint1.getLongitudeE6() - paramGeoPoint2.getLongitudeE6(), 2.0D));
  }
  
  protected NearbyTroopsMapViewOverlayItem a(int paramInt)
  {
    return (NearbyTroopsMapViewOverlayItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public NearbyTroopsMapViewOverlayItem a(MapView paramMapView)
  {
    GeoPoint localGeoPoint1 = paramMapView.getMapCenter();
    int m = paramMapView.getLatitudeSpan();
    int n = paramMapView.getLongitudeSpan();
    int i1 = localGeoPoint1.getLongitudeE6() - n / 2;
    int i2 = localGeoPoint1.getLatitudeE6() - m / 2;
    paramMapView = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    int k = -1;
    double d2 = -1.0D;
    int i = 0;
    if (paramMapView.hasNext())
    {
      GeoPoint localGeoPoint2 = ((NearbyTroopsMapViewOverlayItem)paramMapView.next()).getPoint();
      int i3 = localGeoPoint2.getLongitudeE6();
      int i4 = localGeoPoint2.getLatitudeE6();
      double d1 = d2;
      int j = k;
      double d3;
      if (i3 > i1)
      {
        d1 = d2;
        j = k;
        if (i3 < i1 + n)
        {
          d1 = d2;
          j = k;
          if (i4 > i2)
          {
            d1 = d2;
            j = k;
            if (i4 < i2 + m)
            {
              d3 = a(localGeoPoint1, localGeoPoint2);
              if (d2 != -1.0D) {
                break label202;
              }
              d1 = d3;
              j = i;
            }
          }
        }
      }
      for (;;)
      {
        i += 1;
        d2 = d1;
        k = j;
        break;
        label202:
        d1 = d2;
        j = k;
        if (d3 < d2)
        {
          d1 = d3;
          j = i;
        }
      }
    }
    if ((k >= 0) && (k < this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return (NearbyTroopsMapViewOverlayItem)this.jdField_a_of_type_JavaUtilArrayList.get(k);
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapViewItemOverlay$Callback = null;
    this.jdField_a_of_type_JavaUtilArrayList = null;
  }
  
  public void a(NearbyTroopsMapViewItemOverlay.Callback paramCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapViewItemOverlay$Callback = paramCallback;
  }
  
  public void a(ArrayList paramArrayList, Boolean paramBoolean, boolean paramBoolean1)
  {
    if (paramArrayList == null) {}
    NearbyTroopsMapViewOverlayItem localNearbyTroopsMapViewOverlayItem;
    label119:
    do
    {
      return;
      localNearbyTroopsMapViewOverlayItem = (NearbyTroopsMapViewOverlayItem)getFocus();
      if ((this.jdField_a_of_type_JavaUtilArrayList.size() > 100) || (paramBoolean.booleanValue()))
      {
        this.jdField_a_of_type_JavaUtilArrayList = null;
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramArrayList.size());
        if (localNearbyTroopsMapViewOverlayItem != null) {
          this.jdField_a_of_type_JavaUtilArrayList.add(localNearbyTroopsMapViewOverlayItem);
        }
      }
      paramBoolean = new ArrayList(paramArrayList.size());
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        paramArrayList = (GroupArea)localIterator.next();
        Object localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        Object localObject2;
        for (int i = 0; ((Iterator)localObject1).hasNext(); i = 1)
        {
          localObject2 = (NearbyTroopsMapViewOverlayItem)((Iterator)localObject1).next();
          if (((paramArrayList.iLat != ((NearbyTroopsMapViewOverlayItem)localObject2).getPoint().getLatitudeE6()) || (paramArrayList.iLon != ((NearbyTroopsMapViewOverlayItem)localObject2).getPoint().getLongitudeE6())) && (!paramArrayList.strAreaName.equals(((NearbyTroopsMapViewOverlayItem)localObject2).jdField_a_of_type_JavaLangString))) {
            break label119;
          }
        }
        if (i == 0)
        {
          localObject2 = (GroupInfo)paramArrayList.vGroupInfo.get(0);
          if (localObject2 != null)
          {
            localObject1 = new NearbyTroopsMapViewOverlayItem(new GeoPoint(paramArrayList.iLat, paramArrayList.iLon), paramArrayList.dwGroupTotalCnt, paramArrayList.strAreaName, ((GroupInfo)localObject2).strName, ((GroupInfo)localObject2).lCode);
            ((NearbyTroopsMapViewOverlayItem)localObject1).jdField_a_of_type_Boolean = paramBoolean1;
            if ((this.jdField_a_of_type_AndroidContentContext != null) && (paramBoolean1))
            {
              if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
                this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130838283);
              }
              if (this.b == null) {
                this.b = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130838285);
              }
              if (!Long.toString(((GroupInfo)localObject2).lCreator).equals(this.jdField_a_of_type_JavaLangString)) {
                break label610;
              }
              this.c = this.b;
              if (((NearbyTroopsMapViewOverlayItem)localObject1).jdField_a_of_type_Long <= 99L) {
                break label621;
              }
            }
            for (paramArrayList = "99";; paramArrayList = "" + ((NearbyTroopsMapViewOverlayItem)localObject1).jdField_a_of_type_Long)
            {
              float f1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
              i = this.c.getHeight();
              int j = this.c.getWidth();
              localObject2 = Bitmap.createBitmap(j, i, Bitmap.Config.ARGB_8888);
              Canvas localCanvas = new Canvas((Bitmap)localObject2);
              Paint localPaint = new Paint(33);
              localCanvas.drawBitmap(this.c, 0.0F, 0.0F, localPaint);
              localPaint.setAntiAlias(true);
              localPaint.setColor(Color.parseColor("#66b74e"));
              localPaint.setTextAlign(Paint.Align.CENTER);
              float f2 = 13.0F * this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().scaledDensity;
              localPaint.setTextSize(f2);
              localCanvas.drawText(paramArrayList, j / 2, (f1 * 31.0F + f2) / 2.0F, localPaint);
              localCanvas.save(31);
              localCanvas.restore();
              paramArrayList = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject2);
              boundCenterBottom(paramArrayList);
              ((NearbyTroopsMapViewOverlayItem)localObject1).setMarker(paramArrayList);
              if ((this.jdField_a_of_type_AndroidContentContext != null) && (!paramBoolean1))
              {
                if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
                  this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838284);
                }
                ((NearbyTroopsMapViewOverlayItem)localObject1).setMarker(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
              }
              paramBoolean.add(localObject1);
              break;
              this.c = this.jdField_a_of_type_AndroidGraphicsBitmap;
              break label346;
            }
          }
        }
      }
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramBoolean);
      if (size() > 0) {
        populate();
      }
    } while (localNearbyTroopsMapViewOverlayItem == null);
    label346:
    label610:
    label621:
    setFocus(localNearbyTroopsMapViewOverlayItem);
  }
  
  public void draw(Canvas paramCanvas, MapView paramMapView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramMapView.getContext();
    super.draw(paramCanvas, paramMapView);
  }
  
  public boolean onLongPress(GeoPoint paramGeoPoint, MotionEvent paramMotionEvent, MapView paramMapView)
  {
    return true;
  }
  
  protected boolean onTap(int paramInt)
  {
    NearbyTroopsMapViewOverlayItem localNearbyTroopsMapViewOverlayItem = (NearbyTroopsMapViewOverlayItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapViewItemOverlay$Callback == null) || (localNearbyTroopsMapViewOverlayItem == null) || (!localNearbyTroopsMapViewOverlayItem.jdField_a_of_type_Boolean)) {
      return true;
    }
    setFocus(localNearbyTroopsMapViewOverlayItem);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapViewItemOverlay$Callback.b(localNearbyTroopsMapViewOverlayItem);
    return true;
  }
  
  public boolean onTap(GeoPoint paramGeoPoint, MapView paramMapView)
  {
    if (size() == 0) {
      return false;
    }
    return super.onTap(paramGeoPoint, paramMapView);
  }
  
  public int size()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.NearbyTroopsMapViewItemOverlay
 * JD-Core Version:    0.7.0.1
 */