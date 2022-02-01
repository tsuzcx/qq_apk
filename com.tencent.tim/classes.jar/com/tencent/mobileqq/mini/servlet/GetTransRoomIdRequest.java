package com.tencent.mobileqq.mini.servlet;

import NS_MINI_APP_MISC.MISC.StTrans4RoomidReq;
import NS_MINI_INTERFACE.INTERFACE.StTrans4TinyidRsp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;

public class GetTransRoomIdRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_app_misc.Trans4Roomid";
  public static final String TAG = "GetTransRoomIdRequest";
  private MISC.StTrans4RoomidReq req = new MISC.StTrans4RoomidReq();
  
  public GetTransRoomIdRequest(String paramString1, String paramString2)
  {
    this.req.appid.set(paramString1);
    this.req.groupid.set(paramString2);
  }
  
  public static INTERFACE.StTrans4TinyidRsp onResponse(byte[] paramArrayOfByte)
  {
    INTERFACE.StTrans4TinyidRsp localStTrans4TinyidRsp = new INTERFACE.StTrans4TinyidRsp();
    try
    {
      localStTrans4TinyidRsp.mergeFrom(decode(paramArrayOfByte));
      return localStTrans4TinyidRsp;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GetTransRoomIdRequest", 2, "onResponse fail." + paramArrayOfByte);
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
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.GetTransRoomIdRequest
 * JD-Core Version:    0.7.0.1
 */