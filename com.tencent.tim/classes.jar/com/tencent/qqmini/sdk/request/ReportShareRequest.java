package com.tencent.qqmini.sdk.request;

import NS_MINI_INTERFACE.INTERFACE.StReportShareReq;
import NS_MINI_INTERFACE.INTERFACE.StReportShareRsp;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

public class ReportShareRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_app_usr_time.ReportShare";
  public static final String TAG = "ReportShareRequest";
  private INTERFACE.StReportShareReq req = new INTERFACE.StReportShareReq();
  
  public ReportShareRequest(long paramLong, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    this.req.reportTime.set(paramLong);
    this.req.appid.set(paramString1);
    this.req.appType.set(paramInt1);
    this.req.shareScene.set(paramInt2);
    this.req.shareType.set(paramInt3);
    this.req.destType.set(paramInt4);
    this.req.destId.set(paramString2);
  }
  
  protected byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
  
  protected String getCmdName()
  {
    return "ReportShare";
  }
  
  protected String getModule()
  {
    return "mini_app_usr_time";
  }
  
  public JSONObject getResponse(byte[] paramArrayOfByte, JSONObject paramJSONObject)
  {
    if (paramArrayOfByte == null) {
      paramJSONObject = null;
    }
    for (;;)
    {
      return paramJSONObject;
      INTERFACE.StReportShareRsp localStReportShareRsp = new INTERFACE.StReportShareRsp();
      try
      {
        localStReportShareRsp.mergeFrom(paramArrayOfByte);
        if (localStReportShareRsp == null)
        {
          QMLog.d("ReportShareRequest", "onResponse fail.rsp = null");
          return null;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        QMLog.d("ReportShareRequest", "onResponse fail." + paramArrayOfByte);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.ReportShareRequest
 * JD-Core Version:    0.7.0.1
 */