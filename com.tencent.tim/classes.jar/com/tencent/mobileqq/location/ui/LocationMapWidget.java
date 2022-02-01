package com.tencent.mobileqq.location.ui;

import aiqn;
import aisc;
import aise;
import aisf;
import aitz;
import akub;
import akub.a;
import akue;
import akuf;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import aqcx;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.TextureMapView;
import com.tencent.tencentmap.mapsdk.maps.UiSettings;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocationMapWidget
  extends TextureMapView
{
  private akub.a jdField_a_of_type_Akub$a;
  akuf jdField_a_of_type_Akuf;
  private a jdField_a_of_type_ComTencentMobileqqLocationUiLocationMapWidget$a;
  aiqn jdField_b_of_type_Aiqn;
  private CameraPosition jdField_b_of_type_ComTencentTencentmapMapsdkMapsModelCameraPosition;
  aiqn c;
  private Map<String, Marker> lA = new HashMap(10);
  protected Map<String, Marker> lB = new HashMap(10);
  private Activity mActivity;
  public TencentMap mTencentMap;
  protected int mWidgetType = 0;
  
  public LocationMapWidget(Context paramContext)
  {
    this(paramContext, (TencentMapOptions)null);
  }
  
  public LocationMapWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LocationMapWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext.getApplicationContext(), paramAttributeSet, paramInt);
  }
  
  public LocationMapWidget(Context paramContext, TencentMapOptions paramTencentMapOptions)
  {
    super(paramContext.getApplicationContext(), paramTencentMapOptions);
  }
  
  private void a(aiqn paramaiqn, Marker paramMarker, boolean paramBoolean)
  {
    paramMarker.setZIndex(paramaiqn.getZIndex());
    paramMarker.setPosition(paramaiqn.a());
    paramMarker.setClickable(false);
    if (paramBoolean) {
      paramMarker.setRotation((float)paramaiqn.x());
    }
    paramMarker.refreshInfoWindow();
  }
  
  private boolean a(LatLng paramLatLng)
  {
    LatLng localLatLng = this.jdField_b_of_type_Aiqn.a();
    if ((localLatLng == null) || (paramLatLng == null)) {}
    while ((Math.abs(paramLatLng.altitude - localLatLng.altitude) > 5.E-006D) || (Math.abs(paramLatLng.latitude - localLatLng.latitude) > 5.E-006D) || (Math.abs(paramLatLng.longitude - localLatLng.longitude) > 5.E-006D)) {
      return false;
    }
    return true;
  }
  
  private boolean apD()
  {
    boolean bool = true;
    if ((this.jdField_b_of_type_ComTencentTencentmapMapsdkMapsModelCameraPosition == null) || (this.jdField_b_of_type_ComTencentTencentmapMapsdkMapsModelCameraPosition.target == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusMapWidget", 2, new Object[] { "[map][init]init: invoked. ", " mLastCameraPosition params error " });
      }
      bool = false;
    }
    do
    {
      return bool;
      if ((this.c == null) || (this.c.a() == null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("OnlineStatusMapWidget", 2, new Object[] { "[map][init]init: invoked. ", " mFriendItem params error" });
        }
        return false;
      }
      if ((this.c.a().latitude != this.jdField_b_of_type_ComTencentTencentmapMapsdkMapsModelCameraPosition.target.latitude) || (this.c.a().longitude != this.jdField_b_of_type_ComTencentTencentmapMapsdkMapsModelCameraPosition.target.longitude)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("OnlineStatusMapWidget", 2, new Object[] { "[map][init]init: invoked. ", " params same " });
    return true;
    return false;
  }
  
  private void b(aiqn paramaiqn)
  {
    Marker localMarker = this.mTencentMap.addMarker(new MarkerOptions(paramaiqn.a()));
    if (localMarker != null)
    {
      this.lA.put(paramaiqn.getUin(), localMarker);
      if (!paramaiqn.equals(this.jdField_b_of_type_Aiqn)) {
        break label99;
      }
      localMarker.setIcon(BitmapDescriptorFactory.fromResource(2130841353));
    }
    for (;;)
    {
      localMarker.setTag(paramaiqn.getUin());
      a(paramaiqn, localMarker, true);
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusMapWidget", 2, new Object[] { "[map][new]onNewLabelMarker invoked. Result LocationItem: ", paramaiqn });
      }
      return;
      label99:
      localMarker.setIcon(BitmapDescriptorFactory.fromResource(2130841352));
    }
  }
  
  private List<String> fu()
  {
    ArrayList localArrayList = new ArrayList(30);
    if (!this.lB.containsKey(this.c.getUin())) {
      localArrayList.add(this.c.getUin());
    }
    if (!this.lB.containsKey(this.jdField_b_of_type_Aiqn.getUin())) {
      localArrayList.add(this.jdField_b_of_type_Aiqn.getUin());
    }
    return localArrayList;
  }
  
  public void Lv(boolean paramBoolean)
  {
    a(paramBoolean, null);
  }
  
  protected void a(aiqn paramaiqn)
  {
    Marker localMarker = (Marker)this.lA.get(paramaiqn.getUin());
    if (localMarker != null) {
      a(paramaiqn, localMarker, true);
    }
    for (;;)
    {
      localMarker = (Marker)this.lB.get(paramaiqn.getUin());
      if (localMarker != null) {
        a(paramaiqn, localMarker, false);
      }
      return;
      b(paramaiqn);
    }
  }
  
  public void a(Activity paramActivity, aiqn paramaiqn1, aiqn paramaiqn2, akuf paramakuf, int paramInt)
  {
    this.mActivity = paramActivity;
    this.jdField_b_of_type_Aiqn = paramaiqn1;
    this.c = paramaiqn2;
    this.jdField_a_of_type_Akuf = paramakuf;
    this.mTencentMap = getMap();
    this.mTencentMap.getUiSettings().setRotateGesturesEnabled(false);
    this.mTencentMap.getUiSettings().setLogoPositionWithMargin(3, paramInt, 0, aqcx.dip2px(BaseApplicationImpl.context, 10.0F), 0);
    this.mTencentMap.getUiSettings().setScaleViewPositionWithMargin(0, 0, aqcx.dip2px(BaseApplicationImpl.context, 109.0F), aqcx.dip2px(BaseApplicationImpl.context, 62.0F), 0);
    this.jdField_b_of_type_ComTencentTencentmapMapsdkMapsModelCameraPosition = paramakuf.b();
    if ((!apD()) || (QLog.isColorLevel())) {}
    try
    {
      QLog.d("OnlineStatusMapWidget", 2, new Object[] { "[map][init]init: invoked. ", " camera position cached: ", this.jdField_b_of_type_ComTencentTencentmapMapsdkMapsModelCameraPosition });
      label144:
      this.mTencentMap.moveCamera(CameraUpdateFactory.newCameraPosition(this.jdField_b_of_type_ComTencentTencentmapMapsdkMapsModelCameraPosition));
      label348:
      for (;;)
      {
        setTag(-2147483648, Boolean.valueOf(true));
        if (this.mWidgetType == 0)
        {
          this.mTencentMap.setOnMapLoadedCallback(new aisc(this));
          this.mTencentMap.addTencentMapGestureListener(new aise(this));
        }
        return;
        paramaiqn1 = TencentLocationManager.getInstance(getContext()).getLastKnownLocation();
        paramActivity = null;
        if ((this.c != null) && (akue.c(this.c.a().getLatitude(), this.c.a().getLongitude()))) {
          paramActivity = this.c.a();
        }
        for (;;)
        {
          if (paramActivity == null) {
            break label348;
          }
          if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusMapWidget", 2, new Object[] { "[map][init]init: invoked. ", " location last known: ", paramActivity });
          }
          this.mTencentMap.moveCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(paramActivity, this.mTencentMap.getCameraPosition().zoom)));
          break;
          if (paramaiqn1 != null) {
            paramActivity = new LatLng(paramaiqn1.getLatitude(), paramaiqn1.getLongitude());
          }
        }
      }
    }
    catch (Throwable paramActivity)
    {
      break label144;
    }
  }
  
  protected void a(boolean paramBoolean, Float paramFloat)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationMapWidget$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationMapWidget$a.a(true, null);
    }
    aiqn localaiqn = this.jdField_b_of_type_Aiqn;
    Float localFloat;
    if (!this.mTencentMap.isDestroyed())
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusMapWidget", 2, new Object[] { "[map][init]moveMapToSelfCenter invoked. location: ", localaiqn.a() });
      }
      if (!paramBoolean) {
        break label117;
      }
      localFloat = paramFloat;
      if (paramFloat == null) {
        localFloat = Float.valueOf(this.mTencentMap.getCameraPosition().zoom);
      }
      this.mTencentMap.animateCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(localaiqn.a(), localFloat.floatValue())));
    }
    for (;;)
    {
      a(localaiqn);
      return;
      label117:
      localFloat = paramFloat;
      if (paramFloat == null) {
        localFloat = Float.valueOf(15.0F);
      }
      this.mTencentMap.moveCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(localaiqn.a(), localFloat.floatValue())));
    }
  }
  
  public void b(LatLng paramLatLng, Double paramDouble, boolean paramBoolean)
  {
    if (this.mTencentMap.isDestroyed()) {}
    while (paramLatLng == null) {
      return;
    }
    aiqn localaiqn = this.jdField_b_of_type_Aiqn;
    Marker localMarker = (Marker)this.lA.get(localaiqn.getUin());
    if ((this.jdField_b_of_type_ComTencentTencentmapMapsdkMapsModelCameraPosition == null) && (localMarker == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusMapWidget", 2, new Object[] { "[map][init]updateSelfLocation invoked. moveMapToSelfCenter: ", paramLatLng });
      }
      this.jdField_a_of_type_Akuf.Lr(true);
    }
    if (((Boolean)getTag(-2147483648) != null) && (!aitz.a(getContext(), this.mTencentMap, paramLatLng)))
    {
      Lv(false);
      setTag(-2147483648, null);
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusMapWidget", 2, new Object[] { "[map][init]updateSelfLocation invoked. success moveMapToSelfCenter selfItem: ", localaiqn.a() });
      }
    }
    this.jdField_b_of_type_Aiqn.a(paramLatLng, paramDouble);
    if (paramBoolean)
    {
      a(localaiqn);
      label176:
      if ((this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationMapWidget$a == null) || (localMarker == null)) {
        break label233;
      }
      if (!paramBoolean) {
        break label235;
      }
    }
    label233:
    label235:
    for (paramLatLng = fu();; paramLatLng = null)
    {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationMapWidget$a.a(localMarker.getPosition(), localMarker.getRotation(), paramLatLng);
      return;
      if (localMarker == null) {
        break label176;
      }
      a(localaiqn, localMarker, true);
      break label176;
      break;
    }
  }
  
  public LatLng c()
  {
    return this.jdField_b_of_type_Aiqn.a();
  }
  
  public void onDestroy()
  {
    this.mActivity = null;
    aitz.a(this.mTencentMap);
    akub.a().dDx();
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    akub.a().b(this.jdField_a_of_type_Akub$a);
    this.jdField_a_of_type_Akuf.a(this.mTencentMap.getCameraPosition());
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Akub$a == null) {
      this.jdField_a_of_type_Akub$a = new aisf(this);
    }
    akub.a().a(this.jdField_a_of_type_Akub$a);
    try
    {
      akub.a().cb(this.mActivity);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("OnlineStatusMapWidget", 1, "onResume: failed. ", localThrowable);
    }
  }
  
  public void setListener(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationMapWidget$a = parama;
    if (this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationMapWidget$a != null)
    {
      boolean bool = a(this.mTencentMap.getCameraPosition().target);
      this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationMapWidget$a.a(bool, null);
    }
  }
  
  public void setMapLogoVisibility(int paramInt)
  {
    aitz.a(this.mTencentMap, paramInt);
  }
  
  public void u(String paramString, Bitmap paramBitmap)
  {
    if ((this.mTencentMap.isDestroyed()) || (BaseActivity.sTopActivity != this.mActivity) || (this.jdField_b_of_type_Aiqn == null) || (paramBitmap == null)) {}
    aiqn localaiqn;
    do
    {
      return;
      if (!this.jdField_b_of_type_Aiqn.getUin().equals(paramString)) {
        break;
      }
      localaiqn = this.jdField_b_of_type_Aiqn;
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusMapWidget", 2, new Object[] { "[map][head]updateUserHead invoked. ", "LocationItem = [" + localaiqn + "], uin = [" + paramString + "], avatar = [" + paramBitmap + "]" });
      }
    } while (localaiqn == null);
    View localView = inflate(getContext(), 2131559499, null);
    ((ImageView)localView.findViewById(2131370850)).setImageBitmap(paramBitmap);
    paramBitmap = (Marker)this.lB.get(paramString);
    if (paramBitmap != null) {
      paramBitmap.setIcon(BitmapDescriptorFactory.fromView(localView));
    }
    for (;;)
    {
      a(localaiqn, paramBitmap, false);
      this.lB.put(paramString, paramBitmap);
      return;
      localaiqn = this.c;
      break;
      paramBitmap = this.mTencentMap.addMarker(new MarkerOptions(localaiqn.a()).anchor(0.5F, 1.1F).icon(BitmapDescriptorFactory.fromView(localView)));
      paramBitmap.setTag(paramString);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(LatLng paramLatLng, float paramFloat, List<String> paramList);
    
    public abstract void a(LatLng paramLatLng, List<String> paramList);
    
    public abstract void a(boolean paramBoolean, Point paramPoint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationMapWidget
 * JD-Core Version:    0.7.0.1
 */