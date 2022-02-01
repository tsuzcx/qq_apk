package com.tencent.mobileqq.location.window;

import aiqn;
import aiqs;
import aius;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import aqcx;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.data.LocationRoom.b;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapLoadedCallback;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.Polyline;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

public class FloatMapWidget
  extends MapWidget
{
  private TencentMap.OnMapLoadedCallback a;
  private LocationRoom.Venue jdField_c_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue;
  private Double jdField_c_of_type_JavaLangDouble;
  private boolean clS;
  private LocationRoom.Venue d;
  private int dfk;
  private Marker i;
  private final Map<String, View> lC = new HashMap();
  private LatLng m;
  
  public FloatMapWidget(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public FloatMapWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FloatMapWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mWidgetType = 1;
  }
  
  private Marker a(aiqn paramaiqn, View paramView)
  {
    String str = paramaiqn.getUin();
    Marker localMarker = (Marker)this.lB.get(str);
    if (localMarker == null)
    {
      localMarker = this.mTencentMap.addMarker(new MarkerOptions(paramaiqn.a()).icon(BitmapDescriptorFactory.fromView(paramView)));
      paramView = localMarker;
      if (QLog.isColorLevel()) {
        QLog.d("FloatMapWidget", 2, new Object[] { "findHeadMarker: invoked. ", " headMarker: ", localMarker, "isDestroyed: ", Boolean.valueOf(this.mTencentMap.isDestroyed()) });
      }
    }
    for (paramView = localMarker;; paramView = localMarker)
    {
      paramView.setTag(str);
      this.lB.put(str, paramView);
      if (QLog.isColorLevel()) {
        QLog.d("FloatMapWidget", 4, new Object[] { "dev: findHeadMarker: invoked. ", " item: ", paramaiqn });
      }
      return paramView;
      localMarker.setIcon(BitmapDescriptorFactory.fromView(paramView));
    }
  }
  
  private void a(aiqn paramaiqn, View paramView)
  {
    paramView = (ImageView)paramView.findViewById(2131367231);
    if (paramaiqn.getUin().equals(this.b.a().getUin())) {
      paramView.setBackgroundResource(2130841346);
    }
    for (;;)
    {
      paramView.setRotation((float)(paramaiqn.x() + 315.0D));
      return;
      paramView.setBackgroundResource(2130841347);
    }
  }
  
  private void duI()
  {
    int j = this.b.FT();
    if (QLog.isColorLevel()) {
      QLog.d("FloatMapWidget", 2, new Object[] { "drawMapRoute: invoked. ", " routeType: ", Integer.valueOf(j) });
    }
    Lx(false);
    if (j != -1) {
      f(j);
    }
  }
  
  private void duJ()
  {
    View localView = inflate(getContext(), 2131559334, null);
    LocationRoom.Venue localVenue = this.b.a();
    if (QLog.isColorLevel()) {
      QLog.d("FloatMapWidget", 2, new Object[] { "drawMapVenue: invoked. ", " venue: ", localVenue, " mLastDrawVenue: ", this.jdField_c_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue });
    }
    this.jdField_c_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue = localVenue;
    if (this.i != null) {
      this.i.remove();
    }
    if (localVenue != null)
    {
      this.i = this.mTencentMap.addMarker(new MarkerOptions(localVenue.g).anchor(0.5F, 0.8F).zIndex(2.147484E+009F).icon(BitmapDescriptorFactory.fromView(localView)));
      this.i.refreshInfoWindow();
    }
  }
  
  @NotNull
  private View h(String paramString)
  {
    View localView2 = (View)this.lC.get(paramString);
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = inflate(getContext(), 2131559333, null);
      this.lC.put(paramString, localView1);
    }
    return localView1;
  }
  
  public void a(boolean paramBoolean, Float paramFloat)
  {
    aiqn localaiqn = this.b.a();
    localaiqn.setZIndex(this.b.FU());
    if (!this.mTencentMap.isDestroyed())
    {
      if (QLog.isColorLevel()) {
        QLog.d("FloatMapWidget", 2, new Object[] { "[float][map][init]moveMapToSelfCenter invoked. location: ", localaiqn.a() });
      }
      if (paramBoolean)
      {
        localFloat = paramFloat;
        if (paramFloat == null) {
          localFloat = Float.valueOf(this.mTencentMap.getCameraPosition().zoom);
        }
        this.mTencentMap.animateCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(localaiqn.a(), localFloat.floatValue())));
      }
    }
    else
    {
      return;
    }
    Float localFloat = paramFloat;
    if (paramFloat == null) {
      localFloat = Float.valueOf(15.0F);
    }
    this.mTencentMap.moveCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(localaiqn.a(), localFloat.floatValue())));
  }
  
  public void b(LocationRoom.Venue paramVenue)
  {
    if (paramVenue == null) {
      Lx(true);
    }
  }
  
  public void b(LatLng paramLatLng, Double paramDouble, boolean paramBoolean)
  {
    paramBoolean = this.mTencentMap.isDestroyed();
    if ((!QLog.isColorLevel()) || (paramBoolean)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (paramLatLng == null);
        if ((!paramLatLng.equals(this.m)) || (paramDouble == null) || (Math.abs(paramDouble.doubleValue() - this.jdField_c_of_type_JavaLangDouble.doubleValue()) >= 5.0D)) {
          break;
        }
      } while (!QLog.isColorLevel());
      return;
      this.m = paramLatLng;
      this.jdField_c_of_type_JavaLangDouble = paramDouble;
      aiqn localaiqn = this.b.a();
      this.b.b(paramLatLng, paramDouble);
      paramLatLng = h(localaiqn.getUin());
      a(localaiqn, paramLatLng);
      a(localaiqn, paramLatLng).refreshInfoWindow();
    } while (!QLog.isColorLevel());
  }
  
  public void duA()
  {
    int j = aqcx.dip2px(getContext(), 16.0F);
    Object localObject1 = this.b.fr();
    label310:
    label353:
    for (;;)
    {
      try
      {
        if (this.b.FT() == -1) {
          break label353;
        }
        Object localObject2 = new ArrayList();
        if (!QLog.isColorLevel()) {
          continue;
        }
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          if (this.m != null) {
            ((List)localObject2).add(this.m);
          }
          localObject1 = localObject2;
          if (this.b.a() != null)
          {
            ((List)localObject2).add(this.b.a().g);
            localObject1 = localObject2;
          }
          if (QLog.isColorLevel()) {
            QLog.d("FloatMapWidget", 2, new Object[] { "zoomMapToShowAll: invoked. ", " mPolyLine: ", this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelPolyline });
          }
          if ((this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelPolyline == null) || (this.b.FT() == -1)) {
            continue;
          }
          localObject2 = this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelPolyline.getPoints();
          if (localObject2 != null) {
            ((List)localObject1).addAll((Collection)localObject2);
          }
          localObject1 = this.mTencentMap.calculateZoomToSpanLevel(null, (List)localObject1, j, j, j, j);
          if (localObject1 == null) {
            break label310;
          }
          this.mTencentMap.animateCamera(CameraUpdateFactory.newCameraPosition((CameraPosition)localObject1));
          if (QLog.isColorLevel()) {
            QLog.d("FloatMapWidget", 2, new Object[] { "[map][init]zoomMapToShowAll invoked. target: ", ((CameraPosition)localObject1).target + " zoom: " + ((CameraPosition)localObject1).zoom });
          }
          return;
        }
        catch (Throwable localThrowable2)
        {
          localObject1 = localThrowable1;
          Object localObject3 = localThrowable2;
          continue;
        }
        localThrowable1 = localThrowable1;
        QLog.e("FloatMapWidget", 1, "zoomMapToShowAll: failed. ", localThrowable1);
        continue;
        if ((this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelPolyline != null) || (this.b.FT() == -1)) {
          continue;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FloatMapWidget", 2, new Object[] { "zoomMapToShowAll: invoked. need wait route draw. ", " latLngs: ", localObject1 });
        return;
      }
      QLog.d("FloatMapWidget", 2, new Object[] { "zoomMapToShowAll: invoked. check padding", " cameraPosition: ", localObject1 });
      return;
    }
  }
  
  public void dux()
  {
    super.dux();
    if (this.clS) {
      duA();
    }
  }
  
  public void g(LocationRoom.b paramb)
  {
    if ((this.b != null) && (this.b.a(paramb)))
    {
      paramb = this.b.a();
      if (QLog.isColorLevel()) {
        QLog.d("FloatMapWidget", 2, new Object[] { "onUpdateUserLocations: invoked. ", " currentVenue: ", paramb, " mLastDrawVenue: ", this.jdField_c_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue });
      }
      if ((this.d != null) && (paramb == null)) {
        b(paramb);
      }
      this.d = paramb;
      this.b.Lr(true);
      if (this.b.apy())
      {
        if (QLog.isColorLevel())
        {
          paramb = this.mTencentMap.getCameraPosition();
          if (paramb != null) {
            QLog.d("FloatMapWidget", 2, "[map][location]onUpdateUserLocations invoked.  zoom: " + paramb.zoom);
          }
        }
        this.b.Lr(false);
        duJ();
        if (this.clS) {
          duA();
        }
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    setListener(null);
    aiqs.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(null);
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap$OnMapLoadedCallback = null;
    this.lC.clear();
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelPolyline = null;
  }
  
  public void setOnMapLoadedCallback()
  {
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap$OnMapLoadedCallback = new aius(this);
    this.mTencentMap.setOnMapLoadedCallback(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap$OnMapLoadedCallback);
  }
  
  public void u(String paramString, Bitmap paramBitmap)
  {
    boolean bool = this.mTencentMap.isDestroyed();
    if (QLog.isColorLevel()) {
      QLog.d("FloatMapWidget", 2, new Object[] { "updateUserHead: invoked. ", " mapDestroyed: ", Boolean.valueOf(bool) });
    }
    if (bool) {}
    aiqn localaiqn;
    do
    {
      return;
      localaiqn = this.b.a(paramString);
      int j = this.b.ft().size();
      if (this.dfk != j)
      {
        this.lC.clear();
        this.lB.clear();
        this.mTencentMap.clear();
        duI();
        this.dfk = j;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FloatMapWidget", 2, new Object[] { "[map][head]updateUserHead invoked. ", "LocationItem = [" + localaiqn + "], uin = [" + paramString + "], avatar = [" + paramBitmap + "]" });
      }
    } while (localaiqn == null);
    View localView = h(paramString);
    ((RoundImageView)localView.findViewById(2131367232)).setImageBitmap(paramBitmap);
    a(localaiqn, localView);
    paramBitmap = a(localaiqn, localView);
    if (paramString.equals(this.b.a().getUin())) {
      if (QLog.isColorLevel()) {
        QLog.d("FloatMapWidget", 2, new Object[] { "updateUserHead: invoked. no need refresh self. ", " uin: ", paramString });
      }
    }
    for (;;)
    {
      paramBitmap.refreshInfoWindow();
      return;
      paramString = localaiqn.a();
      if (paramString != null)
      {
        paramBitmap.setZIndex(localaiqn.getZIndex());
        paramBitmap.setPosition(paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.window.FloatMapWidget
 * JD-Core Version:    0.7.0.1
 */