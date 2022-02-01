package com.tencent.qqmini.sdk.launcher.core.proxy;

import android.app.Activity;
import android.os.Bundle;

public abstract class PayProxy
{
  public static final String MINI_EVENT_NAME = "mini_event_name";
  public static final String MINI_EVENT_SEQ = "mini_event_seq";
  public static final String MINI_RESPONSE_STR = "mini_response_str";
  
  public static String getPayStateMsg(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case -1: 
      return "支付状态未知";
    case 0: 
      return "支付成功";
    case 1: 
      return "用户取消";
    }
    return "支付出错";
  }
  
  public static String getResultCodeMsg(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return "";
    case -1: 
      return "支付流程失败";
    case 0: 
      return "支付流程成功";
    case 2: 
      return "用户取消";
    }
    return "参数错误";
  }
  
  public abstract Bundle midasPay(Activity paramActivity, String paramString, IPayResultCallBack paramIPayResultCallBack, Bundle paramBundle);
  
  public static abstract interface IPayResultCallBack
  {
    public abstract void onPayCallBack(PayProxy.PayResponse paramPayResponse);
    
    public abstract void payNeedLogin();
  }
  
  public class PayResponse
  {
    public static final int PAYCHANEL_ACCT_QBQD = 11;
    public static final int PAYCHANEL_ACCT_QDQB = 0;
    public static final int PAYCHANEL_GOLDCOUPONS = 10;
    public static final int PAYCHANEL_HF = 9;
    public static final int PAYCHANEL_MCARD = 5;
    public static final int PAYCHANEL_QQCARD = 4;
    public static final int PAYCHANEL_TENPAY_BANK = 2;
    public static final int PAYCHANEL_TENPAY_CFT = 1;
    public static final int PAYCHANEL_TENPAY_KJ = 3;
    public static final int PAYCHANEL_UNKOWN = -1;
    public static final int PAYCHANEL_WECHAT = 8;
    public static final int PAYCHANEL_YB = 7;
    public static final int PAYPROVIDESTATE_SUCC = 0;
    public static final int PAYPROVIDESTATE_UNKOWN = -1;
    public static final int PAYRESULT_ALREADY_OWNED = 1159;
    public static final int PAYRESULT_CANCEL = 2;
    public static final int PAYRESULT_ERROR = -1;
    public static final int PAYRESULT_PARAMERROR = 3;
    public static final int PAYRESULT_PENDING = 101;
    public static final int PAYRESULT_SUCC = 0;
    public static final int PAYRESULT_UNKOWN = 100;
    public static final int PAYSTATE_PAYCANCEL = 1;
    public static final int PAYSTATE_PAYERROR = 2;
    public static final int PAYSTATE_PAYSUCC = 0;
    public static final int PAYSTATE_PAYUNKOWN = -1;
    public String extendInfo = null;
    public int payChannel = -1;
    public String payReserve1 = null;
    public String payReserve2 = null;
    public String payReserve3 = null;
    public int payState = -1;
    public int provideState = -1;
    public int realSaveNum = 0;
    public int resultCode = -1;
    public int resultInerCode = 0;
    public String resultMsg = null;
    
    public PayResponse() {}
    
    public String getExtendInfo()
    {
      return this.extendInfo;
    }
    
    public int getPayChannel()
    {
      return this.payChannel;
    }
    
    public String getPayReserve1()
    {
      return this.payReserve1;
    }
    
    public String getPayReserve2()
    {
      return this.payReserve2;
    }
    
    public String getPayReserve3()
    {
      return this.payReserve3;
    }
    
    public int getPayState()
    {
      return this.payState;
    }
    
    public int getProvideState()
    {
      return this.provideState;
    }
    
    public int getRealSaveNum()
    {
      return this.realSaveNum;
    }
    
    public int getResultCode()
    {
      return this.resultCode;
    }
    
    public int getResultInerCode()
    {
      return this.resultInerCode;
    }
    
    public String getResultMsg()
    {
      return this.resultMsg;
    }
    
    public void reset()
    {
      this.realSaveNum = 0;
      this.resultCode = -1;
      this.resultInerCode = 0;
      this.payChannel = -1;
      this.payState = -1;
      this.provideState = -1;
      this.resultMsg = "";
      this.extendInfo = "";
      this.payReserve1 = "";
      this.payReserve2 = "";
      this.payReserve3 = "";
    }
    
    public void setExtendInfo(String paramString)
    {
      this.extendInfo = paramString;
    }
    
    public void setPayChannel(int paramInt)
    {
      this.payChannel = paramInt;
    }
    
    public void setPayReserve1(String paramString)
    {
      this.payReserve1 = paramString;
    }
    
    public void setPayReserve2(String paramString)
    {
      this.payReserve2 = paramString;
    }
    
    public void setPayReserve3(String paramString)
    {
      this.payReserve3 = paramString;
    }
    
    public void setPayState(int paramInt)
    {
      this.payState = paramInt;
    }
    
    public void setProvideState(int paramInt)
    {
      this.provideState = paramInt;
    }
    
    public void setRealSaveNum(int paramInt)
    {
      this.realSaveNum = paramInt;
    }
    
    public void setResultCode(int paramInt)
    {
      this.resultCode = paramInt;
    }
    
    public void setResultInerCode(int paramInt)
    {
      this.resultInerCode = paramInt;
    }
    
    public void setResultMsg(String paramString)
    {
      this.resultMsg = paramString;
    }
  }
  
  public static class Source
  {
    public static final String PAY_CALLBACK_SN_EXTRA_KEY = "payparmas_callback_sn";
    public static final String PAY_H5_START_EXTRA_KEY = "payparmas_h5_start";
    public static final int PAY_INVOKER_BUY_GOODS = 7;
    public static final int PAY_INVOKER_PAY = 9;
    public static final int PAY_INVOKER_RECHARGE_GAME_CURRENCY = 6;
    public static final int PAY_INVOKER_SUBSCRIBE_MONTH_CARD = 14;
    public static final String PAY_IS_LOCK_WITHDRAW = "payparmas_is_lock_withdraw";
    public static final String PAY_JSON_EXTRA_KEY = "payparmas_json";
    public static final String PAY_REQUEST_CODE_KEY = "payparmas_request_code";
    public static final String PAY_REQUEST_SDK_PF = "payparmas_sdk_pf";
    public static final String PAY_TYPE_EXTRA_KEY = "payparmas_paytype";
    public static final String PAY_URL_APPINFO_EXTRA_KEY = "payparmas_url_appinfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy
 * JD-Core Version:    0.7.0.1
 */