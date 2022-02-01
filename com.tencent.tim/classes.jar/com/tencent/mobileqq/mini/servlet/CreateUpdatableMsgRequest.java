package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE.StCreateUpdatableMsgReq;
import NS_MINI_INTERFACE.INTERFACE.StCreateUpdatableMsgRsp;
import NS_MINI_INTERFACE.INTERFACE.StUpdatableMsgShareInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;

public class CreateUpdatableMsgRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_app_updatablemsg.CreateUpdatableMsg";
  private static final String TAG = "CreateUpdatableMsgRequest";
  private INTERFACE.StCreateUpdatableMsgReq req = new INTERFACE.StCreateUpdatableMsgReq();
  
  public CreateUpdatableMsgRequest(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    this.req.appid.set(paramString1);
    this.req.templateId.set(paramString2);
    this.req.from.set(paramInt1);
    paramString1 = new INTERFACE.StUpdatableMsgShareInfo();
    paramString1.scene.set(paramInt2);
    switch (paramInt2)
    {
    default: 
      QLog.e("CreateUpdatableMsgRequest", 2, "Create StUpdatableMsgShareInfo with wrong scene:" + paramInt2);
    }
    for (;;)
    {
      this.req.shareInfo.set(paramString1);
      return;
      paramString1.groupId.set(paramString3);
      paramString1.chatUin.set("");
      continue;
      paramString1.chatUin.set(paramString3);
      paramString1.groupId.set("");
    }
  }
  
  public static INTERFACE.StCreateUpdatableMsgRsp onResponse(byte[] paramArrayOfByte)
  {
    INTERFACE.StCreateUpdatableMsgRsp localStCreateUpdatableMsgRsp = new INTERFACE.StCreateUpdatableMsgRsp();
    try
    {
      localStCreateUpdatableMsgRsp.mergeFrom(decode(paramArrayOfByte));
      return localStCreateUpdatableMsgRsp;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CreateUpdatableMsgRequest", 2, "onResponse fail." + paramArrayOfByte);
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
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.CreateUpdatableMsgRequest
 * JD-Core Version:    0.7.0.1
 */