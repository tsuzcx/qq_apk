package com.tencent.map.sdk.service.protocol.request;

import com.tencent.map.sdk.a.nc.a;
import com.tencent.map.sdk.service.net.annotation.NetRequest;
import com.tencent.map.tools.net.NetMethod;
import com.tencent.map.tools.net.NetResponse;

public abstract interface MapDataRequest
  extends nc.a
{
  @NetRequest(constQuery="pf=androidsdk&fr=02001", method=NetMethod.POST, path="fileupdate", queryKeys={"sdkver", "imei", "appsuid", "nettp", "api_key"})
  public abstract NetResponse configFileUpdate(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, byte[] paramArrayOfByte);
  
  @NetRequest(method=NetMethod.URL, path="indoor_map")
  public abstract String getIndoorMapUrl();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.service.protocol.request.MapDataRequest
 * JD-Core Version:    0.7.0.1
 */