package com.tencent.mobileqq.microapp.out;

import alkx;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import ausj;
import ausj.a;
import auss;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.microapp.R.dimen;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class c
  implements ausj.a
{
  protected ausj a = null;
  protected HashSet b = new HashSet();
  protected LinkedHashMap c = new LinkedHashMap();
  protected HashMap d = new HashMap();
  protected int[] e = new int[6];
  protected String f;
  protected String g;
  protected LatLng h;
  protected LatLng i;
  protected Context j;
  protected int k = 0;
  private String l;
  
  public c(Context paramContext)
  {
    this.j = paramContext;
    this.c.put("com.tencent.map", "腾讯地图");
    this.c.put("com.baidu.BaiduMap", "百度地图");
    this.d.put("com.tencent.map", Integer.valueOf(1));
    this.d.put("com.baidu.BaiduMap", Integer.valueOf(2));
    new Handler(Looper.getMainLooper());
  }
  
  public static double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    paramDouble2 = 3.141592653589793D * paramDouble2 / 180.0D;
    paramDouble4 = 3.141592653589793D * paramDouble4 / 180.0D;
    paramDouble3 = (paramDouble1 - paramDouble3) * 3.141592653589793D / 180.0D;
    paramDouble1 = Math.sin((paramDouble2 - paramDouble4) / 2.0D);
    paramDouble3 = Math.sin(paramDouble3 / 2.0D);
    return 6378137.0D * 2.0D * Math.asin(Math.sqrt(Math.cos(paramDouble2) * Math.cos(paramDouble4) * paramDouble3 * paramDouble3 + paramDouble1 * paramDouble1));
  }
  
  public static double[] a(double paramDouble1, double paramDouble2)
  {
    double d1 = Math.sqrt(paramDouble2 * paramDouble2 + paramDouble1 * paramDouble1) + 2.E-005D * Math.sin(paramDouble1 * 3.141592653589793D);
    paramDouble1 = Math.atan2(paramDouble1, paramDouble2);
    paramDouble1 = Math.cos(3.141592653589793D * paramDouble2) * 3.E-006D + paramDouble1;
    paramDouble2 = Math.cos(paramDouble1);
    return new double[] { Math.sin(paramDouble1) * d1 + 0.006D, paramDouble2 * d1 + 0.0065D };
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (this.e[paramInt])
    {
    }
    for (;;)
    {
      if (this.a.isShowing()) {
        this.a.dismiss();
      }
      return;
      b();
      continue;
      c();
    }
  }
  
  protected void a()
  {
    long l1 = System.currentTimeMillis();
    this.b.clear();
    List localList = alkx.a(this.j.getPackageManager(), 0);
    if (localList != null)
    {
      int m = 0;
      while (m < localList.size())
      {
        String str = ((PackageInfo)localList.get(m)).packageName;
        if (this.c.containsKey(str)) {
          this.b.add(str);
        }
        m += 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqmap", 2, "checkInstalledMapApp: time=" + (System.currentTimeMillis() - l1));
    }
  }
  
  public void a(LatLng paramLatLng1, LatLng paramLatLng2, String paramString1, String paramString2)
  {
    if ((paramLatLng1 == null) || (paramLatLng2 == null))
    {
      QQToast.a(this.j, 0, "获取当前位置失败", 1).show(this.j.getResources().getDimensionPixelSize(R.dimen.b));
      return;
    }
    this.h = paramLatLng1;
    this.i = paramLatLng2;
    this.f = paramString1;
    this.g = paramString2;
    if (TextUtils.isEmpty(this.f)) {
      this.f = "自己位置";
    }
    if (TextUtils.isEmpty(this.g)) {
      this.g = "目标位置";
    }
    double d1 = a(paramLatLng1.getLongitude(), paramLatLng1.getLatitude(), paramLatLng2.getLongitude(), paramLatLng2.getLatitude());
    if (d1 > 1000.0D)
    {
      this.k = 1;
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqmap", 2, "showActionSheet: self=" + paramLatLng1.toString() + ",to=" + paramLatLng2.toString() + ",selfPoi=" + paramString1 + ",toPoi=" + paramString2 + ",distance=" + d1);
      }
      a();
      this.a = ((ausj)auss.a(this.j, null));
      this.a.a(this);
      if (TextUtils.isEmpty(this.l)) {
        break label405;
      }
      this.a.addButton("街景地图");
      this.e[0] = 0;
    }
    label402:
    label405:
    for (int m = 1;; m = 0)
    {
      this.a.addButton("腾讯地图");
      this.e[m] = 1;
      paramLatLng1 = this.c.entrySet().iterator();
      m += 1;
      label298:
      if (paramLatLng1.hasNext())
      {
        paramString1 = (Map.Entry)paramLatLng1.next();
        paramLatLng2 = (String)paramString1.getKey();
        paramString1 = (String)paramString1.getValue();
        if (!this.b.contains(paramLatLng2)) {
          break label402;
        }
        this.a.addButton(paramString1);
        this.e[m] = ((Integer)this.d.get(paramLatLng2)).intValue();
        m += 1;
      }
      for (;;)
      {
        break label298;
        this.k = 0;
        break;
        this.a.show();
        return;
      }
    }
  }
  
  public void a(String paramString)
  {
    this.l = paramString;
  }
  
  protected void b()
  {
    Object localObject;
    if (this.b.contains("com.tencent.map"))
    {
      localObject = "drive";
      if (this.k == 0) {
        localObject = "walk";
      }
      localObject = String.format("qqmap://map/routeplan?type=%s&from=%s&fromcoord=%f,%f&to=%s&tocoord=%f,%f&policy=1&referer=qq", new Object[] { localObject, this.f, Double.valueOf(this.h.getLatitude()), Double.valueOf(this.h.getLongitude()), this.g, Double.valueOf(this.i.getLatitude()), Double.valueOf(this.i.getLongitude()) });
    }
    do
    {
      try
      {
        Intent localIntent = Intent.parseUri((String)localObject, 0);
        localIntent.addCategory("android.intent.category.BROWSABLE");
        localIntent.setComponent(null);
        localIntent.setSelector(null);
        this.j.startActivity(localIntent);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqmap", 2, "openQQMapForRoute:" + (String)localObject);
        }
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.qqmap", 2, "openQQMapForRoute:" + (String)localObject, localException);
        }
      }
      localObject = new Intent(this.j, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", "https://pr.map.qq.com/j/tmap/download");
      this.j.startActivity((Intent)localObject);
    } while (!QLog.isColorLevel());
    QLog.d("Q.qqmap", 2, "openQQMapForRoute, download=https://pr.map.qq.com/j/tmap/download");
  }
  
  protected void c()
  {
    String str = "driving";
    if (this.k == 0) {
      str = "walking";
    }
    Object localObject2 = "";
    Object localObject1 = localObject2;
    try
    {
      double[] arrayOfDouble1 = a(this.h.getLatitude(), this.h.getLongitude());
      localObject1 = localObject2;
      double[] arrayOfDouble2 = a(this.i.getLatitude(), this.i.getLongitude());
      localObject1 = localObject2;
      str = String.format("intent://map/direction?origin=latlng:%f,%f|name:%s&destination=latlng:%f,%f|name:%s&mode=%s&src=src=thirdapp.navi.yourCompanyName.yourAppName#Intent;scheme=bdapp;package=com.baidu.BaiduMap;end", new Object[] { Double.valueOf(arrayOfDouble1[0]), Double.valueOf(arrayOfDouble1[1]), this.f, Double.valueOf(arrayOfDouble2[0]), Double.valueOf(arrayOfDouble2[1]), this.g, str });
      localObject1 = str;
      localObject2 = Intent.getIntent(str);
      localObject1 = str;
      ((Intent)localObject2).addCategory("android.intent.category.BROWSABLE");
      localObject1 = str;
      ((Intent)localObject2).setComponent(null);
      localObject1 = str;
      ((Intent)localObject2).setSelector(null);
      localObject1 = str;
      this.j.startActivity((Intent)localObject2);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.out.c
 * JD-Core Version:    0.7.0.1
 */