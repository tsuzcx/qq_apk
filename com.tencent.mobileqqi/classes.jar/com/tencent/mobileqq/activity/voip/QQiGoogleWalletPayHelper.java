package com.tencent.mobileqq.activity.voip;

import com.pay.googlewaletsdk.entity.RequestInfo;
import com.pay.googlewaletsdk.entity.RequestInfo.changkeyType;
import com.pay.googlewaletsdk.entity.RequestInfo.keytype;
import com.pay.googlewaletsdk.entity.RequestInfo.productType;
import java.io.PrintStream;

public class QQiGoogleWalletPayHelper
{
  public static final String a = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA1NiOGiwiiVAc8WoXdMzw+pD7J65wpQYS7n9+e0Hvttf2UCLv7rxxQqWh3siJwl2nf62MKZjnKoiNxwunShwbncsEFwa/X1OYpJ0ANNJq0vwrDaAiZb7mrwz67eqwU8ChZtzb5fj58AtZqevvBwBZ6C7EKrclwQTonE0Kj3jihuuJkwlzSmr08yVrUUMELTwDeAGMv79HCEEicbdo8BDJ3SCyByy+hWtBf0FRuYZeTXlCIEdtIbFG5RRAksFD4ab8Zs4BMqkNHDKUMsshRcZ9b//OtphYR4jYTh/YZAht0MHPneNqsXXQLgHkyBEMKZ+CRQW2HJEQ5QjrsIXhlXFYuwIDAQAB";
  private static final String b = "1450001096";
  
  public static RequestInfo a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    System.out.println("createRequestInfo begin!");
    RequestInfo localRequestInfo = new RequestInfo();
    localRequestInfo.openid = paramString1;
    localRequestInfo.openkey = paramString2;
    localRequestInfo.productID = paramString3;
    localRequestInfo.session_id = "uin";
    localRequestInfo.session_type = "skey";
    localRequestInfo.zoneid = "1";
    localRequestInfo.pf = "qq_m_qqi-0001-android-0001";
    localRequestInfo.pfkey = "pfkey";
    localRequestInfo.appid = "1450001096";
    localRequestInfo.payItem = (paramString3 + "*" + paramString4 + "*1");
    localRequestInfo.isDepostGameCoin = false;
    localRequestInfo.varItem = "1";
    localRequestInfo.changeKey = RequestInfo.changkeyType.Nonmal;
    localRequestInfo.quantity = 1;
    localRequestInfo.setKey("changekey");
    localRequestInfo.keyType = RequestInfo.keytype.BaseKey;
    localRequestInfo.productType = RequestInfo.productType.Consumable;
    System.out.println("createRequestInfo OK!");
    return localRequestInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.voip.QQiGoogleWalletPayHelper
 * JD-Core Version:    0.7.0.1
 */