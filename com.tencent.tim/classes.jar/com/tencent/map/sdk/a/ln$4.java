package com.tencent.map.sdk.a;

import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;

final class ln$4
  implements kb.a
{
  ln$4(ln paramln) {}
  
  public final void a(float paramFloat, GeoPoint arg2)
  {
    double d1 = 0.0D;
    ??? = fz.a(???);
    double d2 = 20.0D - Math.log(1.0F / paramFloat) / Math.log(2.0D);
    if (d2 < 0.0D) {}
    for (;;)
    {
      this.a.f = new CameraPosition(???, (float)d1, this.a.b.az.h(), this.a.b.az.g());
      synchronized (this.a.g)
      {
        this.a.g.notifyAll();
        return;
      }
      d1 = d2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.ln.4
 * JD-Core Version:    0.7.0.1
 */