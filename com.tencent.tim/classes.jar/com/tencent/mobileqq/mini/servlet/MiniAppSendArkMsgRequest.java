package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_SHARE.MiniProgramShare.StSendArkMsgReq;
import NS_MINI_SHARE.MiniProgramShare.StSendArkMsgRsp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;

public class MiniAppSendArkMsgRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_app_share.SendArkMsg";
  public static final String TAG = "MiniAppSendArkMsgRequest";
  private static final String unikey = "MiniAppSendArkMsgRequest";
  private MiniProgramShare.StSendArkMsgReq req = new MiniProgramShare.StSendArkMsgReq();
  
  public MiniAppSendArkMsgRequest(COMM.StCommonExt paramStCommonExt, String paramString1, String paramString2, String paramString3)
  {
    if (paramStCommonExt != null) {
      this.req.extInfo.set(paramStCommonExt);
    }
    this.req.appId.set(paramString1);
    this.req.openId.set(paramString2);
    this.req.arkJson.set(paramString3);
  }
  
  public static MiniProgramShare.StSendArkMsgRsp onResponse(byte[] paramArrayOfByte)
  {
    MiniProgramShare.StSendArkMsgRsp localStSendArkMsgRsp = new MiniProgramShare.StSendArkMsgRsp();
    try
    {
      localStSendArkMsgRsp.mergeFrom(decode(paramArrayOfByte));
      return localStSendArkMsgRsp;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MiniAppSendArkMsgRequest", 2, "onResponse fail." + paramArrayOfByte);
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
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppSendArkMsgRequest
 * JD-Core Version:    0.7.0.1
 */