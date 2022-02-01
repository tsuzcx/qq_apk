package com.tencent.map.sdk.a;

import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.AsyncOperateCallback;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;

final class ln$5
  implements kb.a
{
  ln$5(ln paramln, TencentMap.AsyncOperateCallback paramAsyncOperateCallback) {}
  
  public final void a(float paramFloat, GeoPoint paramGeoPoint)
  {
    double d1 = 0.0D;
    paramGeoPoint = fz.a(paramGeoPoint);
    double d2 = 20.0D - Math.log(1.0F / paramFloat) / Math.log(2.0D);
    if (d2 < 0.0D) {}
    for (;;)
    {
      this.b.f = new CameraPosition(paramGeoPoint, (float)d1, this.b.b.az.h(), this.b.b.az.g());
      if (this.a != null) {
        this.a.onOperateFinished(this.b.f);
      }
      return;
      d1 = d2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.ln.5
 * JD-Core Version:    0.7.0.1
 */