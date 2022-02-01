package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StCurrChannelInfo;
import NS_MINI_INTERFACE.INTERFACE.StUseUserAppReq;
import NS_MINI_INTERFACE.INTERFACE.StUseUserAppRsp;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;

public class UseUserAppRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_app_userapp.UseUserApp";
  public static final String TAG = "UseUserAppRequest";
  private INTERFACE.StUseUserAppReq req = new INTERFACE.StUseUserAppReq();
  
  public UseUserAppRequest(COMM.StCommonExt paramStCommonExt, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    this.req.appId.set(paramString1);
    this.req.verType.set(paramInt1);
    this.req.source.set(paramInt2);
    paramString1 = new INTERFACE.StCurrChannelInfo();
    paramString1.refer.set(paramString2);
    paramString1.via.set(paramString3);
    this.req.channelInfo.set(paramString1);
    if (paramStCommonExt != null) {
      this.req.extInfo.set(paramStCommonExt);
    }
  }
  
  public static INTERFACE.StUseUserAppRsp onResponse(byte[] paramArrayOfByte)
  {
    INTERFACE.StUseUserAppRsp localStUseUserAppRsp = new INTERFACE.StUseUserAppRsp();
    try
    {
      localStUseUserAppRsp.mergeFrom(decode(paramArrayOfByte));
      return localStUseUserAppRsp;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UseUserAppRequest", 2, "onResponse fail." + paramArrayOfByte);
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
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.UseUserAppRequest
 * JD-Core Version:    0.7.0.1
 */