package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_APP_PAY.MiniAppMidasPay.StQueryStarCurrencyReq;
import NS_MINI_APP_PAY.MiniAppMidasPay.StQueryStarCurrencyRsp;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;

public class QueryCurrencyRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_app_pay.QueryStarCurrency";
  public static final String TAG = "QueryCurrencyRequest";
  private static final String unikey = "QueryStarCurrency";
  private MiniAppMidasPay.StQueryStarCurrencyReq req = new MiniAppMidasPay.StQueryStarCurrencyReq();
  
  public QueryCurrencyRequest(COMM.StCommonExt paramStCommonExt, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (paramStCommonExt != null) {
      this.req.extInfo.set(paramStCommonExt);
    }
    this.req.appId.set(paramString1);
    this.req.prepayId.set(paramString2);
    this.req.starCurrency.set(paramInt1);
    this.req.sandboxEnv.set(paramInt2);
  }
  
  public static MiniAppMidasPay.StQueryStarCurrencyRsp onResponse(byte[] paramArrayOfByte)
  {
    MiniAppMidasPay.StQueryStarCurrencyRsp localStQueryStarCurrencyRsp = new MiniAppMidasPay.StQueryStarCurrencyRsp();
    try
    {
      localStQueryStarCurrencyRsp.mergeFrom(decode(paramArrayOfByte));
      return localStQueryStarCurrencyRsp;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QueryCurrencyRequest", 2, "onResponse fail." + paramArrayOfByte);
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
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.QueryCurrencyRequest
 * JD-Core Version:    0.7.0.1
 */