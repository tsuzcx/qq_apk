package com.tencent.qqmini.map;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.qqmini.miniapp.action.CoverViewAction;
import com.tencent.qqmini.sdk.action.PageAction;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.widget.CoverView;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;

@JsPlugin
public class MapViewJsPlugin
  extends BaseJsPlugin
{
  public static final String EVENT_ADD_MAP_CIRCLES = "addMapCircles";
  public static final String EVENT_ADD_MAP_CONTROLS = "addMapControls";
  public static final String EVENT_ADD_MAP_LINE = "addMapLines";
  public static final String EVENT_ADD_MAP_MARKERS = "addMapMarkers";
  public static final String EVENT_ADD_MAP_POLYGONS = "addMapPolygons";
  public static final String EVENT_GET_MAPCENTER_LOCATION = "getMapCenterLocation";
  public static final String EVENT_GET_MAP_REGION = "getMapRegion";
  public static final String EVENT_GET_MAP_ROTATE = "getMapRotate";
  public static final String EVENT_GET_MAP_SCALE = "getMapScale";
  public static final String EVENT_GET_MAP_SKEW = "getMapSkew";
  public static final String EVENT_INCLUDE_MAP_POINT = "includeMapPoints";
  public static final String EVENT_INSERT_MAP = "insertMap";
  public static final String EVENT_MOVE_TO_MAP_LOCATION = "moveToMapLocation";
  public static final String EVENT_REMOVE_MAP = "removeMap";
  public static final String EVENT_REMOVE_MAP_MARKERS = "removeMapMarkers";
  public static final String EVENT_TRANSLATE_MAP_MARKER = "translateMapMarker";
  public static final String EVENT_UPDATE_MAP = "updateMap";
  public static final String EVENT_UPDATE_MAP_COVERS = "updateMapCovers";
  public static final String MAP_TAG = "MiniAppMapTag";
  public static final String TAG = "MapViewJsPlugin";
  private SparseArray<MapContext> mapContextArray;
  
  private MapContext getMapContext(int paramInt)
  {
    return (MapContext)this.mapContextArray.get(paramInt);
  }
  
  private int getPageId()
  {
    return PageAction.obtain(this.mMiniAppContext).getPageId();
  }
  
  private void insertMap(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    Object localObject = (MapContext)this.mapContextArray.get(paramInt1);
    if (QMLog.isColorLevel()) {
      QMLog.d("MapViewJsPlugin", "insertMapView mapId=" + paramInt1 + ",mapContext=" + localObject);
    }
    if (localObject != null) {
      return;
    }
    CoverView localCoverView = CoverViewAction.obtain(this.mMiniAppContext).get(paramInt1);
    localObject = localCoverView;
    if (localCoverView == null)
    {
      if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
        break label223;
      }
      localObject = new TencentMapOptions();
      ((TencentMapOptions)localObject).setSubInfo(paramString1, paramString2);
    }
    label223:
    for (paramString1 = new CoverMapView(this.mContext, (TencentMapOptions)localObject);; paramString1 = new CoverMapView(this.mContext))
    {
      paramString1.setContentDescription(paramInt1 + "_" + paramInt2);
      paramString1.setParentId(paramInt2);
      CoverViewAction.obtain(this.mMiniAppContext).add(paramInt2, paramInt1, paramString1);
      localObject = paramString1;
      if (!(localObject instanceof CoverMapView)) {
        break;
      }
      paramString1 = new MapContext(this.mMiniAppContext, (CoverMapView)localObject, paramInt1, getPageId());
      this.mapContextArray.put(paramInt1, paramString1);
      ((CoverView)localObject).setTag("MiniAppMapTag");
      return;
    }
  }
  
  @JsEvent({"addMapCircles"})
  public void addMapCircles(RequestEvent paramRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new MapViewJsPlugin.5(this, paramRequestEvent));
  }
  
  @JsEvent({"addMapControls"})
  public void addMapControls(RequestEvent paramRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new MapViewJsPlugin.14(this, paramRequestEvent));
  }
  
  @JsEvent({"addMapLines"})
  public void addMapLines(RequestEvent paramRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new MapViewJsPlugin.3(this, paramRequestEvent));
  }
  
  @JsEvent({"addMapMarkers"})
  public void addMapMarkers(RequestEvent paramRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new MapViewJsPlugin.12(this, paramRequestEvent));
  }
  
  @JsEvent({"addMapPolygons"})
  public void addMapPolygons(RequestEvent paramRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new MapViewJsPlugin.4(this, paramRequestEvent));
  }
  
  @JsEvent({"getMapCenterLocation"})
  public void getMapCenterLocation(RequestEvent paramRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new MapViewJsPlugin.6(this, paramRequestEvent));
  }
  
  @JsEvent({"getMapRegion"})
  public void getMapRegion(RequestEvent paramRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new MapViewJsPlugin.11(this, paramRequestEvent));
  }
  
  @JsEvent({"getMapRotate"})
  public void getMapRotate(RequestEvent paramRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new MapViewJsPlugin.15(this, paramRequestEvent));
  }
  
  @JsEvent({"getMapScale"})
  public void getMapScale(RequestEvent paramRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new MapViewJsPlugin.10(this, paramRequestEvent));
  }
  
  @JsEvent({"getMapSkew"})
  public void getMapSkew(RequestEvent paramRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new MapViewJsPlugin.16(this, paramRequestEvent));
  }
  
  @JsEvent({"includeMapPoints"})
  public void includeMapPoints(RequestEvent paramRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new MapViewJsPlugin.9(this, paramRequestEvent));
  }
  
  @JsEvent({"insertMap"})
  public void insertMap(RequestEvent paramRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new MapViewJsPlugin.1(this, paramRequestEvent));
  }
  
  @JsEvent({"moveToMapLocation"})
  public void moveToMapLocation(RequestEvent paramRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new MapViewJsPlugin.7(this, paramRequestEvent));
  }
  
  public void onCreate(IMiniAppContext paramIMiniAppContext)
  {
    super.onCreate(paramIMiniAppContext);
    this.mapContextArray = new SparseArray();
  }
  
  @JsEvent({"removeMapMarkers"})
  public void removeMapMarkers(RequestEvent paramRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new MapViewJsPlugin.13(this, paramRequestEvent));
  }
  
  @JsEvent({"translateMapMarker"})
  public void translateMapMarker(RequestEvent paramRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new MapViewJsPlugin.8(this, paramRequestEvent));
  }
  
  @JsEvent({"updateMap"})
  public void updateMap(RequestEvent paramRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new MapViewJsPlugin.2(this, paramRequestEvent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.map.MapViewJsPlugin
 * JD-Core Version:    0.7.0.1
 */