package com.tencent.mobileqq.location.ui;

import aeif;
import aekm;
import aiqn;
import aiqs;
import aiqs.a;
import airk;
import aitz;
import aiua;
import aiuc;
import aiud;
import aiue;
import aiuf;
import aiug;
import aiuh;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import aqcx;
import ayxa;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.lbssearch.TencentSearch;
import com.tencent.lbssearch.object.param.DrivingParam;
import com.tencent.lbssearch.object.param.RoutePlanningParam;
import com.tencent.lbssearch.object.param.TransitParam;
import com.tencent.lbssearch.object.param.WalkingParam;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.data.LocationRoom.b;
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
import com.tencent.tencentmap.mapsdk.maps.model.Polyline;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapWidget
  extends TextureMapView
{
  private aiqs.a jdField_a_of_type_Aiqs$a;
  private LocationRoom.Venue jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue;
  private a jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget$a;
  public Polyline a;
  public LocationRoom b;
  private CameraPosition b;
  private volatile boolean clN;
  private Marker h;
  private Map<String, Marker> lA = new HashMap(10);
  public Map<String, Marker> lB = new HashMap(10);
  private Activity mActivity;
  public TencentMap mTencentMap;
  public int mWidgetType = 0;
  private View vb;
  
  public MapWidget(Context paramContext)
  {
    this(paramContext, (TencentMapOptions)null);
  }
  
  public MapWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MapWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext.getApplicationContext(), paramAttributeSet, paramInt);
  }
  
  public MapWidget(Context paramContext, TencentMapOptions paramTencentMapOptions)
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
    LatLng localLatLng = this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom.a().a();
    if ((localLatLng == null) || (paramLatLng == null)) {}
    while ((Math.abs(paramLatLng.altitude - localLatLng.altitude) > 5.E-006D) || (Math.abs(paramLatLng.latitude - localLatLng.latitude) > 5.E-006D) || (Math.abs(paramLatLng.longitude - localLatLng.longitude) > 5.E-006D)) {
      return false;
    }
    return true;
  }
  
  private void al(Map<String, Marker> paramMap)
  {
    List localList = this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom.ft();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (Marker)((Map.Entry)localObject).getValue();
      if (!localList.contains(str))
      {
        ((Marker)localObject).remove();
        paramMap.remove();
      }
    }
  }
  
  private void b(aiqn paramaiqn)
  {
    Marker localMarker = this.mTencentMap.addMarker(new MarkerOptions(paramaiqn.a()));
    if (localMarker != null)
    {
      this.lA.put(paramaiqn.getUin(), localMarker);
      if (!paramaiqn.equals(this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom.a())) {
        break label102;
      }
      localMarker.setIcon(BitmapDescriptorFactory.fromResource(2130841353));
    }
    for (;;)
    {
      localMarker.setTag(paramaiqn.getUin());
      a(paramaiqn, localMarker, true);
      if (QLog.isColorLevel()) {
        QLog.d("MapWidget", 2, new Object[] { "[map][new]onNewLabelMarker invoked. Result LocationItem: ", paramaiqn });
      }
      return;
      label102:
      localMarker.setIcon(BitmapDescriptorFactory.fromResource(2130841352));
    }
  }
  
  private void duC()
  {
    al(this.lB);
  }
  
  private void duD()
  {
    al(this.lA);
  }
  
  private void duE()
  {
    LocationRoom.Venue localVenue = this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom.a();
    if (localVenue != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MapWidget", 2, "[map][venue]resetVenue invoked. venue: " + localVenue + " mVenueMarker: " + this.h);
      }
      if (this.h == null) {
        break label94;
      }
    }
    label94:
    for (this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom.a().t = new SoftReference(this.h);; this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom.a().t = null)
    {
      this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom.setVenue(localVenue);
      return;
    }
  }
  
  private void duw()
  {
    Iterator localIterator = this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom.fs().iterator();
    while (localIterator.hasNext()) {
      a((aiqn)localIterator.next());
    }
  }
  
  private void duy()
  {
    if ((this.vb != null) && (this.vb.getHeight() == 0))
    {
      ViewTreeObserver localViewTreeObserver = this.vb.getViewTreeObserver();
      localViewTreeObserver.addOnGlobalLayoutListener(new aiuf(this, localViewTreeObserver));
      return;
    }
    lk(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelPolyline.getPoints());
  }
  
  private void duz()
  {
    lk(this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom.fq());
  }
  
  private List<String> fu()
  {
    ArrayList localArrayList = new ArrayList(30);
    Iterator localIterator = this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom.fs().iterator();
    while (localIterator.hasNext())
    {
      aiqn localaiqn = (aiqn)localIterator.next();
      if (!this.lB.containsKey(localaiqn.getUin())) {
        localArrayList.add(localaiqn.getUin());
      }
    }
    return localArrayList;
  }
  
  private void gZ(View paramView)
  {
    ImageView localImageView;
    if (this.mWidgetType == 0)
    {
      localImageView = (ImageView)paramView.findViewById(2131381217);
      paramView = (aekm)aeif.a().o(575);
      if (paramView == null) {
        break label65;
      }
    }
    label65:
    for (paramView = paramView.tk();; paramView = null)
    {
      if (TextUtils.isEmpty(paramView))
      {
        localImageView.setVisibility(8);
        return;
      }
      localImageView.setVisibility(0);
      aitz.l(localImageView, paramView);
      return;
    }
  }
  
  private void lk(List<LatLng> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    int i;
    if (this.vb != null) {
      if ((this.vb instanceof PoiSlideBottomPanel)) {
        i = ((PoiSlideBottomPanel)this.vb).FY();
      }
    }
    for (;;)
    {
      int j = aqcx.dip2px(getContext(), 60.0F);
      int k = aqcx.dip2px(getContext(), 102.0F) + ayxa.sNotchHeight + j + j / 2;
      i += j / 2;
      paramList = this.mTencentMap.calculateZoomToSpanLevel(null, paramList, j, j, k, i);
      if (QLog.isColorLevel()) {
        QLog.d("MapWidget", 2, new Object[] { "[map][init]zoomMapToShowAll invoked. mBottomContainer: " + this.vb + " paddingTop: " + k + " paddingBottom: " + i + " cameraPosition: ", paramList });
      }
      if (paramList == null) {
        break;
      }
      this.mTencentMap.animateCamera(CameraUpdateFactory.newCameraPosition(paramList));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("MapWidget", 2, new Object[] { "[map][init]zoomMapToShowAll invoked. target: ", paramList.target + " zoom: " + paramList.zoom });
      return;
      i = this.vb.getHeight();
      continue;
      i = 0;
    }
  }
  
  public void LW(String paramString)
  {
    airk.a(this.mActivity, paramString, "我的位置", this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom.a().name, this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom.a().a(), this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom.a().g);
  }
  
  public void Lv(boolean paramBoolean)
  {
    a(paramBoolean, null);
  }
  
  public void Lw(boolean paramBoolean)
  {
    this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom.Ls(paramBoolean);
  }
  
  public void Lx(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelPolyline != null)
    {
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelPolyline.remove();
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelPolyline = null;
    }
    if (paramBoolean) {
      this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom.Qh(-1);
    }
  }
  
  public LocationRoom.Venue a()
  {
    return this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom.a();
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
  
  public void a(Activity paramActivity, LocationRoom paramLocationRoom, CameraPosition paramCameraPosition, int paramInt, View paramView)
  {
    this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom = paramLocationRoom;
    this.mActivity = paramActivity;
    this.vb = paramView;
    this.mTencentMap = getMap();
    this.mTencentMap.getUiSettings().setRotateGesturesEnabled(false);
    this.mTencentMap.getUiSettings().setLogoPositionWithMargin(3, paramInt, 0, aqcx.dip2px(BaseApplicationImpl.context, 10.0F), 0);
    this.mTencentMap.getUiSettings().setScaleViewPositionWithMargin(0, 0, aqcx.dip2px(BaseApplicationImpl.context, 17.0F), aqcx.dip2px(BaseApplicationImpl.context, 62.0F), 0);
    paramActivity = paramCameraPosition;
    if (paramCameraPosition == null) {
      paramActivity = this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom.b();
    }
    this.jdField_b_of_type_ComTencentTencentmapMapsdkMapsModelCameraPosition = paramActivity;
    if ((this.jdField_b_of_type_ComTencentTencentmapMapsdkMapsModelCameraPosition == null) || (QLog.isColorLevel())) {}
    try
    {
      QLog.d("MapWidget", 2, new Object[] { "[map][init]init: invoked. ", " camera position cached: ", this.jdField_b_of_type_ComTencentTencentmapMapsdkMapsModelCameraPosition });
      label151:
      this.mTencentMap.moveCamera(CameraUpdateFactory.newCameraPosition(this.jdField_b_of_type_ComTencentTencentmapMapsdkMapsModelCameraPosition));
      for (;;)
      {
        setTag(-2147483648, Boolean.valueOf(true));
        if (this.mWidgetType == 0)
        {
          this.mTencentMap.setOnMapLoadedCallback(new aiua(this));
          this.mTencentMap.addTencentMapGestureListener(new aiuc(this));
        }
        return;
        paramActivity = TencentLocationManager.getInstance(getContext()).getLastKnownLocation();
        if (paramActivity != null)
        {
          paramActivity = new LatLng(paramActivity.getLatitude(), paramActivity.getLongitude());
          if (QLog.isColorLevel()) {
            QLog.d("MapWidget", 2, new Object[] { "[map][init]init: invoked. ", " location last known: ", paramActivity });
          }
          this.mTencentMap.moveCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(paramActivity, this.mTencentMap.getCameraPosition().zoom)));
        }
      }
    }
    catch (Throwable paramActivity)
    {
      break label151;
    }
  }
  
  public void a(LatLng paramLatLng, boolean paramBoolean)
  {
    if (!this.mTencentMap.isDestroyed())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MapWidget", 2, new Object[] { "[map][marker]moveMapToLocation invoked. location: ", paramLatLng });
      }
      paramLatLng = CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(paramLatLng, this.mTencentMap.getCameraPosition().zoom));
      if (paramBoolean) {
        this.mTencentMap.animateCamera(paramLatLng);
      }
    }
    else
    {
      return;
    }
    this.mTencentMap.moveCamera(paramLatLng);
  }
  
  public void a(boolean paramBoolean, Float paramFloat)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget$a.a(true, null);
    }
    aiqn localaiqn = this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom.a();
    localaiqn.setZIndex(this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom.FU());
    Float localFloat;
    if (!this.mTencentMap.isDestroyed())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MapWidget", 2, new Object[] { "[map][init]moveMapToSelfCenter invoked. location: ", localaiqn.a() });
      }
      if (!paramBoolean) {
        break label132;
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
      label132:
      localFloat = paramFloat;
      if (paramFloat == null) {
        localFloat = Float.valueOf(15.0F);
      }
      this.mTencentMap.moveCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(localaiqn.a(), localFloat.floatValue())));
    }
  }
  
  public CameraPosition b()
  {
    return this.mTencentMap.getCameraPosition();
  }
  
  public void b(LatLng paramLatLng, Double paramDouble, boolean paramBoolean)
  {
    if (this.mTencentMap.isDestroyed()) {
      break label10;
    }
    label10:
    while (paramLatLng == null) {
      return;
    }
    aiqn localaiqn = this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom.a();
    Marker localMarker = (Marker)this.lA.get(localaiqn.getUin());
    if ((this.jdField_b_of_type_ComTencentTencentmapMapsdkMapsModelCameraPosition == null) && (localMarker == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MapWidget", 2, new Object[] { "[map][init]updateSelfLocation invoked. moveMapToSelfCenter: ", paramLatLng });
      }
      this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom.Lr(true);
    }
    if (((Boolean)getTag(-2147483648) != null) && (!aitz.a(getContext(), this.mTencentMap, paramLatLng)))
    {
      Lv(false);
      setTag(-2147483648, null);
      if (QLog.isColorLevel()) {
        QLog.d("MapWidget", 2, new Object[] { "[map][init]updateSelfLocation invoked. success moveMapToSelfCenter selfItem: ", localaiqn.a() });
      }
    }
    this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom.b(paramLatLng, paramDouble);
    if (paramBoolean)
    {
      a(localaiqn);
      label179:
      if ((this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget$a != null) && (localMarker != null)) {
        if (!paramBoolean) {
          break label265;
        }
      }
    }
    label265:
    for (paramLatLng = fu();; paramLatLng = null)
    {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget$a.a(localMarker.getPosition(), localMarker.getRotation(), paramLatLng);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("MapWidget", 2, new Object[] { "[map][location]updateSelfLocation invoked. update self LocationItem: ", localaiqn });
      return;
      if (localMarker == null) {
        break label179;
      }
      a(localaiqn, localMarker, true);
      break label179;
    }
  }
  
  public LatLng c()
  {
    return this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom.a().a();
  }
  
  public void cs(String paramString, boolean paramBoolean)
  {
    aiqn localaiqn = this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom.a(paramString);
    if (localaiqn == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget$a.a(paramString.equals(this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom.a().getUin()), null);
    }
    localaiqn.setZIndex(this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom.FU());
    if (!this.mTencentMap.isDestroyed())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MapWidget", 2, new Object[] { "[map][init]moveMapToUserCenter invoked. uin: " + paramString + " location: ", localaiqn.a() });
      }
      if (!paramBoolean) {
        break label155;
      }
      this.mTencentMap.animateCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(localaiqn.a(), this.mTencentMap.getCameraPosition().zoom)));
    }
    for (;;)
    {
      a(localaiqn);
      return;
      label155:
      this.mTencentMap.moveCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(localaiqn.a(), this.mTencentMap.getCameraPosition().zoom)));
    }
  }
  
  protected void duA()
  {
    lk(this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom.fr());
  }
  
  public void duB()
  {
    duE();
    duD();
    duC();
    duw();
  }
  
  public void dux() {}
  
  public Integer f(int paramInt)
  {
    Object localObject = null;
    Lx(false);
    if ((this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom == null) || (this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom.a() == null) || (this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom.a() == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("MapWidget", 2, "[map][venue][route]showRouteToVenue invoked. error mLocationRoom: " + this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom);
      }
    }
    LatLng localLatLng1;
    LatLng localLatLng2;
    do
    {
      return null;
      localLatLng1 = this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom.a().a();
      localLatLng2 = this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom.a().g;
      if ((localLatLng1 != null) && (localLatLng2 != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MapWidget", 2, "[map][venue][route]showRouteToVenue invoked. error locationSelf: " + localLatLng1 + " locationVenue: " + localLatLng2);
    return null;
    int i = paramInt;
    b localb;
    if (paramInt == 0)
    {
      if (aitz.a(localLatLng1, localLatLng2) < 2000.0D) {
        i = 3;
      }
    }
    else
    {
      localb = new b();
      localb.ag = Integer.valueOf(i);
      switch (i)
      {
      default: 
        label220:
        this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom.Qh(i);
        if (localObject != null)
        {
          localObject = ((RoutePlanningParam)localObject).from(localLatLng1).to(localLatLng2);
          new TencentSearch(getContext()).getRoutePlan((RoutePlanningParam)localObject, new aiue(this, i, localb));
        }
        break;
      }
    }
    for (;;)
    {
      return Integer.valueOf(i);
      i = 1;
      break;
      localObject = new DrivingParam();
      break label220;
      localObject = new TransitParam();
      break label220;
      localObject = new WalkingParam();
      break label220;
      if (QLog.isColorLevel()) {
        QLog.d("MapWidget", 2, "[map][venue][route]showRouteToVenue invoked. error RoutePlanningParam: null");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget$a != null) {
        this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget$a.a(false, localb);
      }
    }
  }
  
  public void g(LocationRoom.b paramb)
  {
    if ((this.mTencentMap.isDestroyed()) || (this.mActivity.isFinishing())) {}
    do
    {
      do
      {
        return;
      } while ((this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom == null) || (!this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom.a(paramb)));
      duw();
      if (this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom.apy())
      {
        if (QLog.isColorLevel())
        {
          paramb = this.mTencentMap.getCameraPosition();
          QLog.d("MapWidget", 2, "[map][location]onUpdateUserLocations invoked. target: " + paramb.target + " zoom: " + paramb.zoom);
        }
        this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom.Lr(false);
        duA();
      }
    } while (!this.clN);
    paramb = this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom.a();
    if (this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget$a != null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue != null) || (paramb == null)) {
        break label181;
      }
      if (this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom.FT() == -1) {
        this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget$a.b(paramb);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue = paramb;
      return;
      label181:
      if ((this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue != null) && (paramb == null))
      {
        this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget$a.b(null);
        a(true, Float.valueOf(15.0F));
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue != null) && (paramb != null) && (!this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue.equals(paramb)) && (this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom.FT() == -1))
      {
        this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget$a.b(paramb);
      }
    }
  }
  
  public void onDestroy()
  {
    this.mActivity = null;
    aitz.a(this.mTencentMap);
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    aiqs.a(localQQAppInterface).b(this.jdField_a_of_type_Aiqs$a);
    this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom.a(localQQAppInterface, this.mTencentMap.getCameraPosition());
    if (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelPolyline == null) {
      this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom.Qh(-1);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (this.jdField_a_of_type_Aiqs$a == null) {
      this.jdField_a_of_type_Aiqs$a = new aiug(this);
    }
    aiqs.a(localQQAppInterface).a(this.jdField_a_of_type_Aiqs$a);
    try
    {
      aiqs.a(localQQAppInterface).a(this.mActivity, this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom);
      this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom.a(new aiuh(this));
      duE();
      if (this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom.FT() != -1) {
        f(this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom.FT());
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("MapWidget", 1, "onResume: failed. ", localThrowable);
      }
    }
  }
  
  public void setListener(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget$a = parama;
    if (this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget$a != null)
    {
      boolean bool = a(this.mTencentMap.getCameraPosition().target);
      this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget$a.a(bool, null);
    }
  }
  
  public void setMapLogoVisibility(int paramInt)
  {
    aitz.a(this.mTencentMap, paramInt);
  }
  
  public void setVenue(LocationRoom.Venue paramVenue)
  {
    this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom.setVenue(paramVenue);
    getViewTreeObserver().addOnGlobalLayoutListener(new aiud(this, paramVenue));
  }
  
  public void setVenueOprating(boolean paramBoolean)
  {
    this.clN = paramBoolean;
  }
  
  public void u(String paramString, Bitmap paramBitmap)
  {
    if ((this.mTencentMap.isDestroyed()) || (BaseActivity.sTopActivity != this.mActivity) || (this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom == null) || (paramBitmap == null)) {}
    aiqn localaiqn;
    do
    {
      return;
      localaiqn = this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom.a(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("MapWidget", 2, new Object[] { "[map][head]updateUserHead invoked. ", "LocationItem = [" + localaiqn + "], uin = [" + paramString + "], avatar = [" + paramBitmap + "]" });
      }
    } while (localaiqn == null);
    View localView = inflate(getContext(), 2131559499, null);
    gZ(localView);
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
      paramBitmap = this.mTencentMap.addMarker(new MarkerOptions(localaiqn.a()).anchor(0.5F, 1.1F).icon(BitmapDescriptorFactory.fromView(localView)));
      paramBitmap.setTag(paramString);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(LatLng paramLatLng, float paramFloat, List<String> paramList);
    
    public abstract void a(boolean paramBoolean, Point paramPoint);
    
    public abstract void a(boolean paramBoolean, MapWidget.b paramb);
    
    public abstract void b(LocationRoom.Venue paramVenue);
    
    public abstract void b(LatLng paramLatLng);
  }
  
  public static class b
  {
    public Integer ag;
    public float distance;
    public float duration;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.MapWidget
 * JD-Core Version:    0.7.0.1
 */