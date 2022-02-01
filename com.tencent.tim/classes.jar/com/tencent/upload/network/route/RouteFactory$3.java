package com.tencent.upload.network.route;

import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.uinterface.IUploadConfig;

final class RouteFactory$3
  implements IRouteIPProvider
{
  public String getBakIps()
  {
    return UploadGlobalConfig.getConfig().getOtherBakUrl();
  }
  
  public String getHostUrl()
  {
    return UploadGlobalConfig.getConfig().getOtherHostUrl();
  }
  
  public String getOptIps()
  {
    return UploadGlobalConfig.getConfig().getOtherOptUrl();
  }
  
  public String getV6HostUrl()
  {
    return "v6.other.upqzfile.com";
  }
  
  public String getV6OptIps()
  {
    return UploadGlobalConfig.getConfig().getOtherOptUrlV6();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.upload.network.route.RouteFactory.3
 * JD-Core Version:    0.7.0.1
 */