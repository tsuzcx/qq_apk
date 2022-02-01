package com.tencent.mm.sdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.sdk.modelbase.BaseReq;

public class OpenBusiLuckyMoney
{
  public static class Req
    extends BaseReq
  {
    private static final int MAX_URL_LENGHT = 10240;
    public String appId;
    public String nonceStr;
    public String packageExt;
    public String signType;
    public String signature;
    public String timeStamp;
    
    public boolean checkArgs()
    {
      if ((this.appId == null) || (this.appId.length() <= 0)) {}
      while ((this.timeStamp == null) || (this.timeStamp.length() <= 0) || (this.nonceStr == null) || (this.nonceStr.length() <= 0) || (this.signType == null) || (this.signType.length() <= 0) || (this.signature == null) || (this.signature.length() <= 0)) {
        return false;
      }
      return true;
    }
    
    public int getType()
    {
      return 13;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      super.toBundle(paramBundle);
      paramBundle.putString("_wxapi_open_busi_lucky_money_appid", this.appId);
      paramBundle.putString("_wxapi_open_busi_lucky_money_timeStamp", this.timeStamp);
      paramBundle.putString("_wxapi_open_busi_lucky_money_nonceStr", this.nonceStr);
      paramBundle.putString("_wxapi_open_busi_lucky_money_signType", this.signType);
      paramBundle.putString("_wxapi_open_busi_lucky_money_signature", this.signature);
      paramBundle.putString("_wxapi_open_busi_lucky_money_package", this.packageExt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.modelbiz.OpenBusiLuckyMoney
 * JD-Core Version:    0.7.0.1
 */