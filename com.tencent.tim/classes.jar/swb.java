import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.MapView;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds.Builder;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class swb
  implements ausj.a
{
  protected swb.a a;
  protected GeoPoint g;
  protected GeoPoint i;
  protected int[] mActionArray = new int[6];
  protected HashMap<String, Integer> mActionMap = new HashMap();
  protected ausj mActionSheet;
  protected LinkedHashMap<String, String> mAppNameMap = new LinkedHashMap();
  protected Context mContext;
  protected HashSet<String> mInstalledMapAppSet = new HashSet();
  protected int mRouteMode = 0;
  protected String mSelfPoiName;
  protected String mTargetPoiName;
  protected Handler mUIHandler;
  
  public swb(Context paramContext)
  {
    this.mContext = paramContext;
    this.mAppNameMap.put("com.google.android.apps.maps", "Google地图");
    this.mAppNameMap.put("com.autonavi.minimap", acfp.m(2131711860));
    this.mAppNameMap.put("com.baidu.BaiduMap", acfp.m(2131711861));
    this.mActionMap.put("com.google.android.apps.maps", Integer.valueOf(5));
    this.mActionMap.put("com.autonavi.minimap", Integer.valueOf(4));
    this.mActionMap.put("com.baidu.BaiduMap", Integer.valueOf(3));
    this.mUIHandler = new Handler(Looper.getMainLooper());
  }
  
  public static void a(List<LatLng> paramList, MapView paramMapView, int paramInt)
  {
    if ((paramList == null) || (paramList.size() < 2)) {
      return;
    }
    LatLngBounds.Builder localBuilder = new LatLngBounds.Builder();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localBuilder.include((LatLng)paramList.next());
    }
    paramMapView.getMap().moveCamera(CameraUpdateFactory.newLatLngBounds(localBuilder.build(), paramInt));
  }
  
  protected static List<LatLng> az(List<Float> paramList)
  {
    if ((paramList == null) || (paramList.size() < 2)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new LatLng(((Float)paramList.get(0)).floatValue(), ((Float)paramList.get(1)).floatValue()));
    int j = 2;
    while (j < paramList.size())
    {
      float f3 = (float)((LatLng)localArrayList.get(j / 2 - 1)).getLatitude();
      float f4 = Float.valueOf(((Float)paramList.get(j)).floatValue()).floatValue() / 1000000.0F;
      float f1 = (float)((LatLng)localArrayList.get(j / 2 - 1)).getLongitude();
      float f2 = Float.valueOf(((Float)paramList.get(j + 1)).floatValue()).floatValue() / 1000000.0F;
      f3 = (float)(Math.round((f3 + f4) * 1000000.0D) / 1000000.0D);
      f1 = (float)(Math.round((f2 + f1) * 1000000.0D) / 1000000.0D);
      localArrayList.add(new LatLng(f3, f1));
      j += 2;
    }
    paramList = new ArrayList();
    j = 0;
    if (j < localArrayList.size())
    {
      if (paramList.size() >= 1) {
        if (!((LatLng)paramList.get(paramList.size() - 1)).equals(localArrayList.get(j))) {
          paramList.add(localArrayList.get(j));
        }
      }
      for (;;)
      {
        j += 1;
        break;
        paramList.add(localArrayList.get(j));
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqmap", 2, "parseRoutes: rawPoints=" + localArrayList.size() + ", resultPoints=" + paramList.size());
    }
    return paramList;
  }
  
  public static String c(double paramDouble)
  {
    if (paramDouble < 1000.0D) {
      return String.format(acfp.m(2131711868), new Object[] { Double.valueOf(paramDouble) });
    }
    return String.format(acfp.m(2131711867), new Object[] { Double.valueOf(paramDouble / 1000.0D) });
  }
  
  public static void cY(String paramString1, String paramString2)
  {
    anot.a(null, "P_CliOper", "Pb_account_lifeservice", "", "rec_locate", paramString1, 0, 0, paramString2, "", "", "");
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqmap.report", 2, "opName=" + paramString1 + ",extra1=" + paramString2);
    }
  }
  
  public static double getDistance(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    paramDouble2 = 3.141592653589793D * paramDouble2 / 180.0D;
    paramDouble4 = 3.141592653589793D * paramDouble4 / 180.0D;
    paramDouble3 = (paramDouble1 - paramDouble3) * 3.141592653589793D / 180.0D;
    paramDouble1 = Math.sin((paramDouble2 - paramDouble4) / 2.0D);
    paramDouble3 = Math.sin(paramDouble3 / 2.0D);
    return 6378137.0D * 2.0D * Math.asin(Math.sqrt(Math.cos(paramDouble2) * Math.cos(paramDouble4) * paramDouble3 * paramDouble3 + paramDouble1 * paramDouble1));
  }
  
  public static double[] map_tx2bd(double paramDouble1, double paramDouble2)
  {
    double d = Math.sqrt(paramDouble2 * paramDouble2 + paramDouble1 * paramDouble1) + 2.E-005D * Math.sin(paramDouble1 * 3.141592653589793D);
    paramDouble1 = Math.atan2(paramDouble1, paramDouble2);
    paramDouble2 = Math.cos(3.141592653589793D * paramDouble2) * 3.E-006D + paramDouble1;
    paramDouble1 = Math.cos(paramDouble2) * d + 0.0065D;
    paramDouble2 = Math.sin(paramDouble2) * d + 0.006D;
    System.out.println("bd_lat:" + paramDouble2);
    System.out.println("bd_lon:" + paramDouble1);
    return new double[] { paramDouble2, paramDouble1 };
  }
  
  public static void report(String paramString)
  {
    report(paramString, "");
  }
  
  public static void report(String paramString1, String paramString2)
  {
    report(paramString1, paramString2, "");
  }
  
  public static void report(String paramString1, String paramString2, String paramString3)
  {
    anot.a(null, "dc00899", "Pb_account_lifeservice", "", "rec_locate_android", paramString1, 0, 0, paramString2, paramString3, "", "");
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqmap.report", 2, "opName=" + paramString1 + ",extra1=" + paramString2 + ",extra2=" + paramString3);
    }
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (this.mActionArray[paramInt])
    {
    }
    for (;;)
    {
      if (this.mActionSheet.isShowing()) {
        this.mActionSheet.dismiss();
      }
      return;
      if (this.a != null) {
        if (!this.a.yc())
        {
          a(this.g, this.i);
          report("show_route");
        }
        else
        {
          this.a.ayv();
          report("hide_route");
          continue;
          openBaiduMapForRoute();
          report("baidumap_open");
          cY("click_navig", "4");
          continue;
          bBq();
          report("gaodemap_open");
          cY("click_navig", "3");
          continue;
          bBp();
          report("googlemap_open");
          cY("click_navig", "6");
        }
      }
    }
  }
  
  public void a(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2)
  {
    if (!aqiw.isNetworkAvailable(this.mContext))
    {
      paramGeoPoint1 = this.mContext.getResources();
      QQToast.a(this.mContext.getApplicationContext(), 1, paramGeoPoint1.getString(2131696272), 1).show(paramGeoPoint1.getDimensionPixelSize(2131299627));
      return;
    }
    Bundle localBundle1 = new Bundle();
    Bundle localBundle2 = new Bundle();
    String str;
    if (this.mRouteMode == 1)
    {
      str = "https://apis.map.qq.com/ws/direction/v1/driving/";
      localBundle1.putString("get_mp", "0");
      localBundle1.putString("get_speed", "0");
      localBundle2.putInt("mode", 0);
    }
    for (;;)
    {
      localBundle1.putString("from", paramGeoPoint1.getLatitudeE6() / 1000000.0D + "," + paramGeoPoint1.getLongitudeE6() / 1000000.0D);
      localBundle1.putString("to", paramGeoPoint2.getLatitudeE6() / 1000000.0D + "," + paramGeoPoint2.getLongitudeE6() / 1000000.0D);
      localBundle1.putString("output", "json");
      localBundle1.putString("callback", "cb");
      localBundle1.putString("key", "UZVBZ-TYEKV-N6OPT-UFMDO-VYNG7-3MB7J");
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqmap", 2, "getRoute:" + str);
      }
      paramGeoPoint1 = new HashMap();
      paramGeoPoint1.put("BUNDLE", localBundle1);
      paramGeoPoint1.put("CONTEXT", BaseApplication.getContext());
      new aprb(str, "GET", new swc(this), 1000, localBundle2, true).execute(new HashMap[] { paramGeoPoint1 });
      return;
      str = "https://apis.map.qq.com/ws/direction/v1/walking/";
      localBundle2.putInt("routeMode", 1);
    }
  }
  
  public void a(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2, String paramString1, String paramString2)
  {
    if ((paramGeoPoint1 == null) || (paramGeoPoint2 == null))
    {
      QQToast.a(this.mContext.getApplicationContext(), 0, acfp.m(2131711865), 1).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
      return;
    }
    this.g = paramGeoPoint1;
    this.i = paramGeoPoint2;
    this.mSelfPoiName = paramString1;
    this.mTargetPoiName = paramString2;
    if (TextUtils.isEmpty(this.mSelfPoiName)) {
      this.mSelfPoiName = acfp.m(2131711863);
    }
    if (TextUtils.isEmpty(this.mTargetPoiName)) {
      this.mTargetPoiName = acfp.m(2131711859);
    }
    double d = getDistance(paramGeoPoint1.getLongitudeE6() / 1000000.0D, paramGeoPoint1.getLatitudeE6() / 1000000.0D, paramGeoPoint2.getLongitudeE6() / 1000000.0D, paramGeoPoint2.getLatitudeE6() / 1000000.0D);
    if (d > 1000.0D)
    {
      this.mRouteMode = 1;
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqmap", 2, "showActionSheet: self=" + paramGeoPoint1.toString() + ",to=" + paramGeoPoint2.toString() + ",selfPoi=" + paramString1 + ",toPoi=" + paramString2 + ",distance=" + d);
      }
      checkInstalledMapApp();
      this.mActionSheet = ausj.b(this.mContext);
      this.mActionSheet.a(this);
      if ((this.a == null) || (this.a.yc())) {
        break label424;
      }
      this.mActionSheet.addButton(acfp.m(2131711866));
      label295:
      this.mActionArray[0] = 0;
      paramGeoPoint1 = this.mAppNameMap.entrySet().iterator();
      int j = 1;
      label318:
      if (!paramGeoPoint1.hasNext()) {
        break label440;
      }
      paramString1 = (Map.Entry)paramGeoPoint1.next();
      paramGeoPoint2 = (String)paramString1.getKey();
      paramString1 = (String)paramString1.getValue();
      if ((paramGeoPoint2.equals("com.tencent.map")) || (!this.mInstalledMapAppSet.contains(paramGeoPoint2))) {
        break label458;
      }
      this.mActionSheet.addButton(paramString1);
      this.mActionArray[j] = ((Integer)this.mActionMap.get(paramGeoPoint2)).intValue();
      j += 1;
    }
    label424:
    label440:
    label458:
    for (;;)
    {
      break label318;
      this.mRouteMode = 0;
      break;
      this.mActionSheet.addButton(acfp.m(2131711858));
      break label295;
      this.mActionSheet.addCancelButton(2131721058);
      this.mActionSheet.show();
      return;
    }
  }
  
  public void a(swb.a parama)
  {
    this.a = parama;
  }
  
  public void b(JSONObject paramJSONObject, int paramInt)
  {
    int m = 0;
    int k = 0;
    StringBuilder localStringBuilder;
    Object localObject;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("parseRoutes: mode=").append(paramInt).append(", ");
      if (paramJSONObject != null)
      {
        localObject = paramJSONObject.toString();
        QLog.d("Q.qqmap", 2, (String)localObject);
      }
    }
    else
    {
      localStringBuilder = null;
      if (paramJSONObject == null) {
        break label334;
      }
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          if (paramJSONObject.getInt("status") != 0) {
            continue;
          }
          paramJSONObject = paramJSONObject.getJSONObject("result").getJSONArray("routes");
          if (paramJSONObject.length() <= 0) {
            continue;
          }
          paramJSONObject = paramJSONObject.getJSONObject(0);
          j = paramJSONObject.getInt("distance");
        }
        catch (Exception localException1)
        {
          int j = 0;
          paramInt = j;
          paramJSONObject = localStringBuilder;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.w("Q.qqmap", 2, "parseRoutes:", localException1);
          paramInt = j;
          paramJSONObject = localStringBuilder;
          continue;
          paramInt = 0;
          paramJSONObject = null;
          continue;
        }
        try
        {
          paramJSONObject.getInt("duration");
          if (paramInt != 0) {
            continue;
          }
          paramJSONObject = paramJSONObject.getJSONArray("polyline");
          localObject = new ArrayList();
          paramInt = k;
          if (paramInt < paramJSONObject.length())
          {
            ((List)localObject).add(Float.valueOf((float)paramJSONObject.getDouble(paramInt)));
            paramInt += 1;
            continue;
            localObject = "";
            break;
          }
          paramJSONObject = az((List)localObject);
          paramInt = j;
        }
        catch (Exception localException2)
        {
          continue;
          paramJSONObject = null;
          paramInt = j;
        }
      }
      if (this.a != null) {
        this.a.i(paramJSONObject, paramInt);
      }
      return;
      if (paramInt == 1)
      {
        paramJSONObject = paramJSONObject.getJSONArray("polyline");
        localObject = new ArrayList();
        paramInt = m;
        if (paramInt < paramJSONObject.length())
        {
          ((List)localObject).add(Float.valueOf((float)paramJSONObject.getDouble(paramInt)));
          paramInt += 1;
        }
        else
        {
          paramJSONObject = az((List)localObject);
          paramInt = j;
        }
      }
      else
      {
        label334:
        paramInt = 0;
        paramJSONObject = localStringBuilder;
      }
    }
  }
  
  protected void bBp()
  {
    String str = "http://maps.google.com/maps?f=d&source=s_d&saddr=%f,%f&daddr=%f,%f&hl=zh";
    if (this.mRouteMode == 0) {
      str = "http://maps.google.com/maps?f=d&source=s_d&saddr=%f,%f&daddr=%f,%f&hl=zh" + "&dirflg=w";
    }
    str = String.format(str, new Object[] { Double.valueOf(this.g.getLatitudeE6() / 1000000.0D), Double.valueOf(this.g.getLongitudeE6() / 1000000.0D), Double.valueOf(this.i.getLatitudeE6() / 1000000.0D), Double.valueOf(this.i.getLongitudeE6() / 1000000.0D) });
    try
    {
      Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(str));
      localIntent.addFlags(0);
      localIntent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
      this.mContext.startActivity(localIntent);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqmap", 2, "openGoogleMapForRoute:" + str);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("Q.qqmap", 2, "openGoogleMapForRoute:" + str, localException);
    }
  }
  
  protected void bBq()
  {
    if (this.mRouteMode == 0) {}
    for (int j = 4;; j = 2)
    {
      String str = String.format("androidamap://route?sourceApplication=qq&slat=%f&slon=%f&sname=%s&dlat=%f&dlon=%f&dname=%s&dev=0&m=0&t=%d", new Object[] { Double.valueOf(this.g.getLatitudeE6() / 1000000.0D), Double.valueOf(this.g.getLongitudeE6() / 1000000.0D), this.mSelfPoiName, Double.valueOf(this.i.getLatitudeE6() / 1000000.0D), Double.valueOf(this.i.getLongitudeE6() / 1000000.0D), this.mTargetPoiName, Integer.valueOf(j) });
      try
      {
        Intent localIntent = new Intent("android.intent.action.VIEW");
        localIntent.setData(Uri.parse(str));
        localIntent.setPackage("com.autonavi.minimap");
        this.mContext.startActivity(localIntent);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqmap", 2, "openGaodeMapForRoute:" + str);
        }
        return;
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.w("Q.qqmap", 2, "openGaodeMapForRoute:" + str, localException);
        return;
      }
    }
  }
  
  protected void checkInstalledMapApp()
  {
    long l = System.currentTimeMillis();
    this.mInstalledMapAppSet.clear();
    Iterator localIterator = this.mAppNameMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (ausc.bb(this.mContext, str)) {
        this.mInstalledMapAppSet.add(str);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqmap", 2, "checkInstalledMapApp: time=" + (System.currentTimeMillis() - l));
    }
  }
  
  protected void openBaiduMapForRoute()
  {
    String str = "driving";
    if (this.mRouteMode == 0) {
      str = "walking";
    }
    Object localObject2 = "";
    Object localObject1 = localObject2;
    try
    {
      double[] arrayOfDouble1 = map_tx2bd(this.g.getLatitudeE6() / 1000000.0D, this.g.getLongitudeE6() / 1000000.0D);
      localObject1 = localObject2;
      double[] arrayOfDouble2 = map_tx2bd(this.i.getLatitudeE6() / 1000000.0D, this.i.getLongitudeE6() / 1000000.0D);
      localObject1 = localObject2;
      str = String.format("intent://map/direction?origin=latlng:%f,%f|name:%s&destination=latlng:%f,%f|name:%s&mode=%s&src=src=thirdapp.navi.yourCompanyName.yourAppName#Intent;scheme=bdapp;package=com.baidu.BaiduMap;end", new Object[] { Double.valueOf(arrayOfDouble1[0]), Double.valueOf(arrayOfDouble1[1]), this.mSelfPoiName, Double.valueOf(arrayOfDouble2[0]), Double.valueOf(arrayOfDouble2[1]), this.mTargetPoiName, str });
      localObject1 = str;
      localObject2 = Intent.getIntent(str);
      localObject1 = str;
      this.mContext.startActivity((Intent)localObject2);
      localObject1 = str;
      if (QLog.isColorLevel())
      {
        localObject1 = str;
        QLog.d("Q.qqmap", 2, "openBaiduMapForRoute:" + str);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("Q.qqmap", 2, "openBaiduMapForRoute:" + (String)localObject1, localException);
    }
  }
  
  public static abstract interface a
  {
    public abstract void ayv();
    
    public abstract void i(List<LatLng> paramList, int paramInt);
    
    public abstract boolean yc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     swb
 * JD-Core Version:    0.7.0.1
 */