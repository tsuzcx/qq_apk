package com.tencent.lbsapi.a;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

class f
  implements LocationListener
{
  f(d paramd) {}
  
  public void onLocationChanged(Location paramLocation)
  {
    if (paramLocation != null) {
      d.a(this.a, paramLocation);
    }
  }
  
  public void onProviderDisabled(String paramString) {}
  
  public void onProviderEnabled(String paramString) {}
  
  public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.lbsapi.a.f
 * JD-Core Version:    0.7.0.1
 */