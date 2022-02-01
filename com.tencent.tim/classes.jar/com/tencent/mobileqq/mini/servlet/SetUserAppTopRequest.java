package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StSetUserAppTopReq;
import NS_MINI_INTERFACE.INTERFACE.StSetUserAppTopRsp;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;

public class SetUserAppTopRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_app_userapp.SetUserAppTop";
  private INTERFACE.StSetUserAppTopReq req = new INTERFACE.StSetUserAppTopReq();
  
  public SetUserAppTopRequest(COMM.StCommonExt paramStCommonExt, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.req.appId.set(paramString);
    this.req.verType.set(paramInt2);
    this.req.putTop.set(paramInt1);
    if (paramStCommonExt != null) {
      this.req.extInfo.set(paramStCommonExt);
    }
    this.req.oldIdx.set(paramInt3);
    this.req.newIdx.set(paramInt4);
    this.req.fromNewDownload.set(paramInt5);
  }
  
  public static INTERFACE.StSetUserAppTopRsp onResponse(byte[] paramArrayOfByte)
  {
    INTERFACE.StSetUserAppTopRsp localStSetUserAppTopRsp = new INTERFACE.StSetUserAppTopRsp();
    try
    {
      localStSetUserAppTopRsp.mergeFrom(decode(paramArrayOfByte));
      return localStSetUserAppTopRsp;
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
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.SetUserAppTopRequest
 * JD-Core Version:    0.7.0.1
 */