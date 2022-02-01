package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

class WifiJsPlugin$4
{
  WifiJsPlugin$4(WifiJsPlugin paramWifiJsPlugin, WifiJsPlugin.LocationPermissionListener paramLocationPermissionListener) {}
  
  @QQPermissionDenied(1)
  public void denied()
  {
    this.val$listener.onExecute(false);
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    this.val$listener.onExecute(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.WifiJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */