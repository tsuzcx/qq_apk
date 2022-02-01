package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE.StCheckSessionReq;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;

public class CheckSessionRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_program_auth.CheckSession";
  private INTERFACE.StCheckSessionReq req = new INTERFACE.StCheckSessionReq();
  
  public CheckSessionRequest(long paramLong, String paramString)
  {
    this.req.appid.set(paramString);
  }
  
  public static PROTOCAL.StQWebRsp onResponse(byte[] paramArrayOfByte, int[] paramArrayOfInt)
  {
    if (paramArrayOfByte == null) {}
    do
    {
      return null;
      paramArrayOfInt = new PROTOCAL.StQWebRsp();
      try
      {
        paramArrayOfInt.mergeFrom(paramArrayOfByte);
        return paramArrayOfInt;
      }
      catch (Exception paramArrayOfByte) {}
    } while (!QLog.isColorLevel());
    QLog.d("ProtoBufRequest", 2, "inform QZoneGetGroupCountServlet resultcode fail.");
    return null;
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.CheckSessionRequest
 * JD-Core Version:    0.7.0.1
 */