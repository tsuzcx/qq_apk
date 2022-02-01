package com.tencent.tencentmap.mapsdk.maps.internal;

import com.tencent.map.lib.mapstructure.MapRouteSectionWithName;
import com.tencent.map.sdk.a.hk;
import com.tencent.map.sdk.a.ki;
import com.tencent.map.sdk.a.ks;
import com.tencent.map.sdk.a.kw;
import com.tencent.map.sdk.a.ln;
import com.tencent.map.sdk.a.pn;
import com.tencent.map.sdk.a.py;
import com.tencent.map.sdk.basemap.interfaces.IMapRenderView;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdate;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.AsyncOperateCallback;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.IOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class TencentMapPro
{
  private ki glMapControl = null;
  private boolean mapDestroyed = false;
  private ln mapManager = null;
  private ks viewControl;
  
  public TencentMapPro(ln paramln, ks paramks, ki paramki)
  {
    this.mapManager = paramln;
    this.viewControl = paramks;
    this.glMapControl = paramki;
  }
  
  private void addRouteNameSegments(List<MapRouteSectionWithName> paramList, List<LatLng> paramList1)
  {
    if (paramList != null)
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MapRouteSectionWithName localMapRouteSectionWithName = (MapRouteSectionWithName)paramList.next();
        if (localMapRouteSectionWithName != null)
        {
          hk localhk = new hk();
          localhk.c = localMapRouteSectionWithName.color;
          localhk.b = localMapRouteSectionWithName.endNum;
          localhk.d = localMapRouteSectionWithName.roadName;
          localhk.a = localMapRouteSectionWithName.startNum;
          localArrayList.add(localhk);
        }
      }
      addSegmentsWithRouteName(localArrayList, paramList1);
    }
  }
  
  private void addSegmentsWithRouteName(List<hk> paramList, List<LatLng> paramList1)
  {
    if (this.mapDestroyed) {}
    ki localki;
    do
    {
      return;
      if (this.glMapControl == null) {
        this.glMapControl = new ki(this.mapManager);
      }
      localki = this.glMapControl;
    } while (localki.a == null);
    localki.a.a(paramList, paramList1);
  }
  
  private final void animateToNaviPosition(LatLng paramLatLng, float paramFloat1, float paramFloat2)
  {
    if (this.mapDestroyed) {}
    ki localki;
    do
    {
      return;
      if (this.glMapControl == null) {
        this.glMapControl = new ki(this.mapManager);
      }
      localki = this.glMapControl;
    } while (localki.a == null);
    localki.a.a(paramLatLng, paramFloat1, paramFloat2);
  }
  
  private final void animateToNaviPosition(LatLng paramLatLng, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (this.mapDestroyed) {
      return;
    }
    if (this.glMapControl == null) {
      this.glMapControl = new ki(this.mapManager);
    }
    this.glMapControl.a(paramLatLng, paramFloat1, paramFloat2, paramFloat3, true);
  }
  
  private final void animateToNaviPosition(LatLng paramLatLng, float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean)
  {
    if (this.mapDestroyed) {
      return;
    }
    if (this.glMapControl == null) {
      this.glMapControl = new ki(this.mapManager);
    }
    this.glMapControl.a(paramLatLng, paramFloat1, paramFloat2, paramFloat3, paramBoolean);
  }
  
  private final void animateToNaviPosition2(LatLng paramLatLng, float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean)
  {
    if (this.mapDestroyed) {}
    ki localki;
    do
    {
      return;
      if (this.glMapControl == null) {
        this.glMapControl = new ki(this.mapManager);
      }
      localki = this.glMapControl;
    } while (localki.a == null);
    localki.a.a(paramLatLng, paramFloat1, paramFloat2, paramFloat3);
  }
  
  private float calNaviLevel(LatLngBounds paramLatLngBounds, float paramFloat, int paramInt, boolean paramBoolean)
  {
    if (this.mapDestroyed) {}
    ki localki;
    do
    {
      return 0.0F;
      if (this.glMapControl == null) {
        this.glMapControl = new ki(this.mapManager);
      }
      localki = this.glMapControl;
    } while (localki.a == null);
    return localki.a.a(paramLatLngBounds, paramFloat, paramInt, paramBoolean);
  }
  
  private float calNaviLevel2(LatLng paramLatLng1, LatLng paramLatLng2, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
  {
    if (this.mapDestroyed) {}
    ki localki;
    do
    {
      return 0.0F;
      if (this.glMapControl == null) {
        this.glMapControl = new ki(this.mapManager);
      }
      localki = this.glMapControl;
    } while (localki.a == null);
    return localki.a.a(paramLatLng1, paramLatLng2, paramFloat1, paramInt, paramBoolean);
  }
  
  private float calNaviLevel3(LatLng paramLatLng1, LatLng paramLatLng2, float paramFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    if (this.mapDestroyed) {
      return 0.0F;
    }
    if (this.glMapControl == null) {
      this.glMapControl = new ki(this.mapManager);
    }
    ki localki = this.glMapControl;
    if (localki.a == null) {
      return 0.0F;
    }
    return localki.a.a(paramLatLng1, paramLatLng2, paramFloat, paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean);
  }
  
  private CameraPosition calculateZoomToSpanLevelAsync(List<IOverlay> paramList, List<LatLng> paramList1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, TencentMap.AsyncOperateCallback<CameraPosition> paramAsyncOperateCallback)
  {
    if (this.mapDestroyed) {
      if (paramAsyncOperateCallback != null) {
        paramAsyncOperateCallback.onOperateFinished(null);
      }
    }
    ki localki;
    do
    {
      return null;
      if (this.glMapControl == null) {
        this.glMapControl = new ki(this.mapManager);
      }
      localki = this.glMapControl;
    } while (localki.a == null);
    return localki.a.a(paramList, paramList1, paramInt1, paramInt2, paramInt3, paramInt4, paramAsyncOperateCallback);
  }
  
  private void clearRouteNameSegments()
  {
    if (this.mapDestroyed) {}
    ki localki;
    do
    {
      return;
      if (this.glMapControl == null) {
        this.glMapControl = new ki(this.mapManager);
      }
      localki = this.glMapControl;
    } while (localki.a == null);
    localki.a.m();
  }
  
  private boolean isNaviStateEnabled()
  {
    if (this.glMapControl == null) {
      return false;
    }
    return this.glMapControl.b();
  }
  
  private void setNavCenter(int paramInt1, int paramInt2)
  {
    if (this.viewControl == null) {}
    IMapRenderView localIMapRenderView;
    do
    {
      return;
      localIMapRenderView = this.viewControl.a();
    } while (!(localIMapRenderView instanceof py));
    ((py)localIMapRenderView).getVectorMapDelegate().c(paramInt1, paramInt2);
  }
  
  private void setNaviFixingProportion(float paramFloat1, float paramFloat2)
  {
    if (this.mapDestroyed) {}
    ki localki;
    do
    {
      return;
      if (this.glMapControl == null) {
        this.glMapControl = new ki(this.mapManager);
      }
      localki = this.glMapControl;
    } while (localki.a == null);
    localki.a.a(paramFloat1, paramFloat2);
  }
  
  private void setNaviFixingProportion2D(float paramFloat1, float paramFloat2)
  {
    if (this.mapDestroyed) {}
    ki localki;
    do
    {
      return;
      if (this.glMapControl == null) {
        this.glMapControl = new ki(this.mapManager);
      }
      localki = this.glMapControl;
    } while (localki.a == null);
    localki.a.b(paramFloat1, paramFloat2);
  }
  
  private void setNaviStateEnabled(boolean paramBoolean)
  {
    if (this.glMapControl == null) {
      this.glMapControl = new ki(this.mapManager);
    }
    ki localki = this.glMapControl;
    if (localki.a != null) {
      localki.a.h(paramBoolean);
    }
  }
  
  private void setOnCameraChangeListener(TencentMap.OnCameraChangeListener paramOnCameraChangeListener)
  {
    if (this.mapDestroyed) {}
    ki localki;
    do
    {
      return;
      if (this.glMapControl == null) {
        this.glMapControl = new ki(this.mapManager);
      }
      localki = this.glMapControl;
    } while (localki.a == null);
    localki.a.b(paramOnCameraChangeListener);
  }
  
  public final void moveToNavPosition(CameraUpdate paramCameraUpdate, LatLng paramLatLng)
  {
    if (this.mapDestroyed) {}
    do
    {
      return;
      if (this.glMapControl == null) {
        this.glMapControl = new ki(this.mapManager);
      }
      this.glMapControl.a(paramCameraUpdate);
    } while (paramLatLng == null);
    setNavCenter((int)(paramLatLng.latitude * 1000000.0D), (int)(paramLatLng.longitude * 1000000.0D));
  }
  
  public final void onDestroy()
  {
    this.mapDestroyed = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.internal.TencentMapPro
 * JD-Core Version:    0.7.0.1
 */