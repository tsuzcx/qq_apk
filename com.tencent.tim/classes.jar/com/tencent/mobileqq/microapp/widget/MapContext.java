package com.tencent.mobileqq.microapp.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint.Style;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mobileqq.microapp.R.drawable;
import com.tencent.mobileqq.microapp.apkg.f;
import com.tencent.mobileqq.microapp.appbrand.page.PageWebview;
import com.tencent.mobileqq.microapp.appbrand.page.ServiceWebview;
import com.tencent.mobileqq.widget.QQMapView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapCameraChangeListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapClickListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLoadedListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener;
import org.json.JSONException;
import org.json.JSONObject;

public final class MapContext
  implements TencentMap.InfoWindowAdapter, TencentMap.OnInfoWindowClickListener, TencentMap.OnMapCameraChangeListener, TencentMap.OnMapClickListener, TencentMap.OnMapLoadedListener, TencentMap.OnMarkerClickListener
{
  protected PageWebview a;
  public TencentMap b;
  public QQMapView c;
  public int d;
  protected Context e;
  public ServiceWebview f;
  private float g;
  private SparseArray h;
  
  public MapContext(PageWebview paramPageWebview, ServiceWebview paramServiceWebview, QQMapView paramQQMapView, int paramInt, f paramf)
  {
    this.a = paramPageWebview;
    this.f = paramServiceWebview;
    this.c = paramQQMapView;
    this.b = paramQQMapView.getMap();
    this.d = paramInt;
    this.e = paramQQMapView.getContext();
    this.b.setInfoWindowAdapter(this);
    this.b.setOnMarkerClickListener(this);
    this.b.setOnInfoWindowClickListener(this);
    this.b.setOnMapClickListener(this);
    this.b.setOnMapLoadedListener(this);
    this.b.setOnMapCameraChangeListener(this);
    this.h = new SparseArray();
    this.g = this.e.getResources().getDisplayMetrics().density;
    try
    {
      BitmapFactory.decodeResource(paramQQMapView.getResources(), R.drawable.h);
      return;
    }
    catch (OutOfMemoryError paramPageWebview) {}
  }
  
  private void a(String paramString, JSONObject paramJSONObject)
  {
    paramString = "WeixinJSBridge.subscribeHandler(\"" + paramString + "\", " + paramJSONObject + "," + this.a.pageWebviewId + ")";
    if (QLog.isColorLevel()) {
      QLog.d("MapContext", 2, "callbackJs jsStr=" + paramString);
    }
    this.a.evaluteJs(paramString);
  }
  
  public View getInfoWindow(Marker paramMarker)
  {
    paramMarker = paramMarker.getTag();
    if ((paramMarker instanceof JSONObject))
    {
      Object localObject = ((JSONObject)paramMarker).optJSONObject("callout");
      if (localObject == null) {
        return null;
      }
      paramMarker = ((JSONObject)localObject).optString("content", "");
      String str1 = ((JSONObject)localObject).optString("color", "");
      float f1 = (float)((JSONObject)localObject).optDouble("fontSize", 0.0D);
      float f2 = (float)((JSONObject)localObject).optDouble("borderRadius", 0.0D);
      String str2 = ((JSONObject)localObject).optString("bgColor", "");
      int i = (int)(((JSONObject)localObject).optInt("padding", 0) * this.g);
      String str3 = ((JSONObject)localObject).optString("display", "");
      localObject = ((JSONObject)localObject).optString("textAlign", "");
      InfoView localInfoView = new InfoView(this.e);
      localInfoView.a(paramMarker, str1, f1, f2, str2, i, str3, (String)localObject);
      return localInfoView;
    }
    return null;
  }
  
  public void onCameraChange(CameraPosition paramCameraPosition)
  {
    try
    {
      paramCameraPosition = new JSONObject();
      paramCameraPosition.put("mapId", this.d);
      paramCameraPosition.put("type", "begin");
      this.f.evaluteJs("WeixinJSBridge.subscribeHandler(\"onMapRegionChange\", " + paramCameraPosition + ", " + this.a.pageWebviewId + ")");
      return;
    }
    catch (JSONException paramCameraPosition)
    {
      paramCameraPosition.printStackTrace();
    }
  }
  
  public void onCameraChangeFinish(CameraPosition paramCameraPosition)
  {
    try
    {
      paramCameraPosition = new JSONObject();
      paramCameraPosition.put("mapId", this.d);
      paramCameraPosition.put("type", "end");
      this.f.evaluteJs("WeixinJSBridge.subscribeHandler(\"onMapRegionChange\", " + paramCameraPosition + ", " + this.a.pageWebviewId + ")");
      return;
    }
    catch (JSONException paramCameraPosition)
    {
      paramCameraPosition.printStackTrace();
    }
  }
  
  public void onInfoWindowClick(Marker paramMarker)
  {
    try
    {
      paramMarker = ((JSONObject)paramMarker.getTag()).optString("data");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("data", paramMarker);
      this.f.evaluteJs("WeixinJSBridge.subscribeHandler(\"onMapCalloutClick\", " + localJSONObject + ", " + this.a.pageWebviewId + ")");
      return;
    }
    catch (JSONException paramMarker)
    {
      paramMarker.printStackTrace();
    }
  }
  
  public void onInfoWindowDettached(Marker paramMarker, View paramView) {}
  
  public void onMapClick(LatLng paramLatLng)
  {
    int j = this.h.size();
    int i = 0;
    while (i < j)
    {
      paramLatLng = (Marker)this.h.valueAt(i);
      if ((paramLatLng != null) && (paramLatLng.isInfoWindowShown())) {
        paramLatLng.hideInfoWindow();
      }
      i += 1;
    }
    try
    {
      paramLatLng = new JSONObject();
      paramLatLng.put("mapId", this.d);
      this.f.evaluteJs("WeixinJSBridge.subscribeHandler(\"onMapClick\", " + paramLatLng + ", " + this.a.pageWebviewId + ")");
      return;
    }
    catch (JSONException paramLatLng)
    {
      paramLatLng.printStackTrace();
    }
  }
  
  public void onMapLoaded()
  {
    a("onMapUpdated", new JSONObject());
  }
  
  public boolean onMarkerClick(Marker paramMarker)
  {
    if (paramMarker == null) {
      return false;
    }
    try
    {
      if (!paramMarker.isInfoWindowShown()) {
        paramMarker.showInfoWindow();
      }
      paramMarker = ((JSONObject)paramMarker.getTag()).optString("data");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("data", paramMarker);
      this.f.evaluteJs("WeixinJSBridge.subscribeHandler(\"onMapMarkerClick\", " + localJSONObject + ", " + this.a.pageWebviewId + ")");
    }
    catch (JSONException paramMarker)
    {
      for (;;)
      {
        paramMarker.printStackTrace();
      }
    }
    return true;
  }
  
  class InfoView
    extends LinearLayout
  {
    TextView a;
    
    public InfoView(Context paramContext)
    {
      super();
      this.a = new TextView(paramContext);
      this.a.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
      this.a.setTextColor(-16777216);
      this.a.setTextSize(12.0F);
      setOrientation(1);
      setBackgroundColor(-1);
      addView(this.a);
    }
    
    public void a(String paramString1, String paramString2, float paramFloat1, float paramFloat2, String paramString3, int paramInt, String paramString4, String paramString5)
    {
      this.a.setText(paramString1);
      if (!TextUtils.isEmpty(paramString2)) {}
      try
      {
        this.a.setTextColor(Color.parseColor(paramString2));
        label26:
        if (paramFloat1 > 0.0F) {
          this.a.setTextSize(paramFloat1);
        }
        paramFloat1 = paramFloat2;
        if (paramFloat2 < 1.0F) {
          paramFloat1 = 2.0F;
        }
        int j = -1;
        int k = (int)(MapContext.a(MapContext.this) * paramFloat1 + 0.5F);
        int i = j;
        if (!TextUtils.isEmpty(paramString3)) {}
        try
        {
          i = Color.parseColor(paramString3);
          paramString1 = new e(i, Paint.Style.FILL, 0.0F, 255, k);
          if (Build.VERSION.SDK_INT >= 16)
          {
            this.a.setBackground(paramString1);
            if (paramInt > 0) {
              this.a.setPadding(paramInt, paramInt, paramInt, paramInt);
            }
            if (!"left".equals(paramString5)) {
              break label194;
            }
            this.a.setGravity(3);
          }
          for (;;)
          {
            if ("center".equals(paramString5)) {
              this.a.setGravity(17);
            }
            return;
            this.a.setBackgroundDrawable(paramString1);
            break;
            label194:
            if ("right".equals(paramString5)) {
              this.a.setGravity(5);
            }
          }
        }
        catch (IllegalArgumentException paramString1)
        {
          for (;;)
          {
            i = j;
          }
        }
      }
      catch (IllegalArgumentException paramString1)
      {
        break label26;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.MapContext
 * JD-Core Version:    0.7.0.1
 */