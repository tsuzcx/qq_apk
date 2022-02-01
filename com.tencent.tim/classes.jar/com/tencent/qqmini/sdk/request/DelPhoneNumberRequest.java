package com.tencent.qqmini.sdk.request;

import NS_MINI_INTERFACE.INTERFACE.StDelPhoneNumbersReq;
import NS_MINI_INTERFACE.INTERFACE.StDelPhoneNumbersRsp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

public class DelPhoneNumberRequest
  extends ProtoBufRequest
{
  private static final String TAG = "DelPhoneNumberRequest";
  private INTERFACE.StDelPhoneNumbersReq req = new INTERFACE.StDelPhoneNumbersReq();
  
  public DelPhoneNumberRequest(String paramString1, String paramString2)
  {
    this.req.purePhoneNumber.set(paramString2);
    this.req.appId.set(paramString1);
  }
  
  protected byte[] getBusiBuf()
  {
    return new byte[0];
  }
  
  protected String getCmdName()
  {
    return "DelPhoneNumbers";
  }
  
  protected String getModule()
  {
    return "mini_user_info";
  }
  
  public JSONObject getResponse(byte[] paramArrayOfByte, JSONObject paramJSONObject)
    throws Exception
  {
    if (paramArrayOfByte == null) {
      paramJSONObject = null;
    }
    for (;;)
    {
      return paramJSONObject;
      INTERFACE.StDelPhoneNumbersRsp localStDelPhoneNumbersRsp = new INTERFACE.StDelPhoneNumbersRsp();
      try
      {
        localStDelPhoneNumbersRsp.mergeFrom(paramArrayOfByte);
        if (localStDelPhoneNumbersRsp == null)
        {
          QMLog.d("DelPhoneNumberRequest", "onResponse fail.rsp = null");
          return null;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        QMLog.d("DelPhoneNumberRequest", "onResponse fail." + paramArrayOfByte);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.DelPhoneNumberRequest
 * JD-Core Version:    0.7.0.1
 */