package com.tencent.qqmini.sdk.request;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_APP_PAY.MiniAppMidasPay.StMiniCheckOfferIdReq;
import NS_MINI_APP_PAY.MiniAppMidasPay.StMiniCheckOfferIdRsp;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

public class CheckOfferIdRequest
  extends ProtoBufRequest
{
  private static final String TAG = "CheckOfferIdRequest";
  private MiniAppMidasPay.StMiniCheckOfferIdReq req = new MiniAppMidasPay.StMiniCheckOfferIdReq();
  
  public CheckOfferIdRequest(COMM.StCommonExt paramStCommonExt, String paramString1, String paramString2)
  {
    this.req.appId.set(paramString1);
    this.req.offerId.set(paramString2);
    if (paramStCommonExt != null) {
      this.req.extInfo.set(paramStCommonExt);
    }
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
  
  protected String getCmdName()
  {
    return "MiniCheckOfferId";
  }
  
  protected String getModule()
  {
    return "mini_app_pay";
  }
  
  public JSONObject getResponse(byte[] paramArrayOfByte, JSONObject paramJSONObject)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    MiniAppMidasPay.StMiniCheckOfferIdRsp localStMiniCheckOfferIdRsp = new MiniAppMidasPay.StMiniCheckOfferIdRsp();
    try
    {
      localStMiniCheckOfferIdRsp.mergeFrom(paramArrayOfByte);
      if (localStMiniCheckOfferIdRsp != null)
      {
        paramJSONObject.put("result", localStMiniCheckOfferIdRsp.result.get());
        paramJSONObject.put("ext", localStMiniCheckOfferIdRsp.extInfo);
        paramJSONObject.put("firstRefer", localStMiniCheckOfferIdRsp.firstRefer);
        paramJSONObject.put("firstVia", localStMiniCheckOfferIdRsp.firstVia);
        return paramJSONObject;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      QMLog.d("CheckOfferIdRequest", "onResponse fail." + paramArrayOfByte);
      return null;
    }
    QMLog.d("CheckOfferIdRequest", "onResponse fail.rsp = null");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.CheckOfferIdRequest
 * JD-Core Version:    0.7.0.1
 */