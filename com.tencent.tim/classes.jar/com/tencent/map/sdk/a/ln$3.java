package com.tencent.map.sdk.a;

import android.os.Handler;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.CancelableCallback;

final class ln$3
  implements kb.a
{
  ln$3(ln paramln, boolean paramBoolean, TencentMap.CancelableCallback paramCancelableCallback, long paramLong) {}
  
  public final void a(float paramFloat, GeoPoint paramGeoPoint)
  {
    if (this.d.b == null) {
      return;
    }
    this.d.b.ad.post(new ln.3.1(this, paramFloat, paramGeoPoint));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.ln.3
 * JD-Core Version:    0.7.0.1
 */