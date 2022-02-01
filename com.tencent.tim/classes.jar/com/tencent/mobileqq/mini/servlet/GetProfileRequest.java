package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE.StGetProfileReq;
import NS_MINI_INTERFACE.INTERFACE.StGetProfileRsp;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;

public class GetProfileRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_user_info.GetProfile";
  private static final String unikey = "GetProfile";
  private INTERFACE.StGetProfileReq req = new INTERFACE.StGetProfileReq();
  
  public GetProfileRequest(String paramString1, boolean paramBoolean, String paramString2)
  {
    this.req.appid.set(paramString1);
    paramString1 = this.req.withCredentials;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramString1.set(i);
      if (!TextUtils.isEmpty(paramString2)) {
        this.req.lang.set(paramString2);
      }
      return;
    }
  }
  
  public static INTERFACE.StGetProfileRsp onResponse(byte[] paramArrayOfByte)
  {
    INTERFACE.StGetProfileRsp localStGetProfileRsp = new INTERFACE.StGetProfileRsp();
    try
    {
      localStGetProfileRsp.mergeFrom(decode(paramArrayOfByte));
      return localStGetProfileRsp;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProtoBufRequest", 2, "onResponse fail." + paramArrayOfByte);
      }
    }
    return null;
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.GetProfileRequest
 * JD-Core Version:    0.7.0.1
 */