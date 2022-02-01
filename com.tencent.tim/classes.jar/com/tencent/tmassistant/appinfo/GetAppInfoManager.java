package com.tencent.tmassistant.appinfo;

import com.tencent.tmassistant.appinfo.aidl.GetAppInfoCallback;
import com.tencent.tmassistant.appinfo.data.AppDetailReqParam;
import com.tencent.tmdownloader.f;

public class GetAppInfoManager
{
  private static volatile GetAppInfoManager sInstance = null;
  
  private GetAppInfoManager()
  {
    f.a();
  }
  
  public static GetAppInfoManager get()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new GetAppInfoManager();
      }
      return sInstance;
    }
    finally {}
  }
  
  public int requestAppInfo(AppDetailReqParam paramAppDetailReqParam, GetAppInfoCallback paramGetAppInfoCallback)
  {
    return f.a().a(paramAppDetailReqParam, paramGetAppInfoCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tmassistant.appinfo.GetAppInfoManager
 * JD-Core Version:    0.7.0.1
 */