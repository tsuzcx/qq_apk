package com.tencent.upload.network.route;

import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.uinterface.IUploadConfig;

final class RouteFactory$1
  implements IRouteIPProvider
{
  public String getBakIps()
  {
    return UploadGlobalConfig.getConfig().getPhotoBakUrl();
  }
  
  public String getHostUrl()
  {
    return UploadGlobalConfig.getConfig().getPhotoHostUrl();
  }
  
  public String getOptIps()
  {
    return UploadGlobalConfig.getConfig().getPhotoOptUrl();
  }
  
  public String getV6HostUrl()
  {
    return "v6.pic.upqzfile.com";
  }
  
  public String getV6OptIps()
  {
    return UploadGlobalConfig.getConfig().getPhotoOptUrlV6();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.upload.network.route.RouteFactory.1
 * JD-Core Version:    0.7.0.1
 */