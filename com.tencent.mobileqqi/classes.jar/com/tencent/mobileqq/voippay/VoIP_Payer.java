package com.tencent.mobileqq.voippay;

import android.app.Activity;
import android.content.Intent;
import com.pay.googlewaletsdk.entity.RequestInfo;
import com.pay.googlewaletsdk.entity.RequestInfo.changkeyType;
import com.pay.googlewaletsdk.entity.RequestInfo.keytype;
import com.pay.googlewaletsdk.entity.RequestInfo.productType;
import com.pay.googlewalletsdk.GoogleWalletPayHelper;
import com.pay.googlewalletsdk.IPayListener;
import java.io.PrintStream;

public class VoIP_Payer
  extends Activity
  implements IPayListener
{
  private static VoIP_Payer jdField_a_of_type_ComTencentMobileqqVoippayVoIP_Payer;
  private static final String jdField_a_of_type_JavaLangString = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA1NiOGiwiiVAc8WoXdMzw+pD7J65wpQYS7n9+e0Hvttf2UCLv7rxxQqWh3siJwl2nf62MKZjnKoiNxwunShwbncsEFwa/X1OYpJ0ANNJq0vwrDaAiZb7mrwz67eqwU8ChZtzb5fj58AtZqevvBwBZ6C7EKrclwQTonE0Kj3jihuuJkwlzSmr08yVrUUMELTwDeAGMv79HCEEicbdo8BDJ3SCyByy+hWtBf0FRuYZeTXlCIEdtIbFG5RRAksFD4ab8Zs4BMqkNHDKUMsshRcZ9b//OtphYR4jYTh/YZAht0MHPneNqsXXQLgHkyBEMKZ+CRQW2HJEQ5QjrsIXhlXFYuwIDAQAB";
  
  static
  {
    a = null;
  }
  
  private RequestInfo a(VoIP_PayInfo paramVoIP_PayInfo)
  {
    System.out.println("createRequestInfo begin!");
    RequestInfo localRequestInfo = new RequestInfo();
    System.out.println("new RequestInfo!");
    localRequestInfo.openid = paramVoIP_PayInfo.a();
    localRequestInfo.openkey = paramVoIP_PayInfo.b();
    localRequestInfo.session_id = "uin";
    localRequestInfo.session_type = "skey";
    localRequestInfo.zoneid = "1";
    localRequestInfo.pf = "qq_m_qqi-0001-android-0001";
    localRequestInfo.pfkey = "pfkey";
    localRequestInfo.appid = "1450000948";
    localRequestInfo.payItem = "1";
    localRequestInfo.productID = paramVoIP_PayInfo.c();
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
  
  public static VoIP_Payer a()
  {
    if (a == null) {
      a = new VoIP_Payer();
    }
    return a;
  }
  
  public void a()
  {
    GoogleWalletPayHelper.getInstance().dispose();
    System.out.println("destroy OK!");
  }
  
  public void a(Activity paramActivity)
  {
    GoogleWalletPayHelper.getInstance().init(paramActivity, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA1NiOGiwiiVAc8WoXdMzw+pD7J65wpQYS7n9+e0Hvttf2UCLv7rxxQqWh3siJwl2nf62MKZjnKoiNxwunShwbncsEFwa/X1OYpJ0ANNJq0vwrDaAiZb7mrwz67eqwU8ChZtzb5fj58AtZqevvBwBZ6C7EKrclwQTonE0Kj3jihuuJkwlzSmr08yVrUUMELTwDeAGMv79HCEEicbdo8BDJ3SCyByy+hWtBf0FRuYZeTXlCIEdtIbFG5RRAksFD4ab8Zs4BMqkNHDKUMsshRcZ9b//OtphYR4jYTh/YZAht0MHPneNqsXXQLgHkyBEMKZ+CRQW2HJEQ5QjrsIXhlXFYuwIDAQAB", this);
    System.out.println("init OK!");
    GoogleWalletPayHelper.getInstance().setEnv("test");
    System.out.println("setEnv OK!");
    GoogleWalletPayHelper.getInstance().setDebugLog(true);
    System.out.println("setDebugLog OK!");
  }
  
  public void a(VoIP_PayInfo paramVoIP_PayInfo)
  {
    System.out.println("pay begin!");
    paramVoIP_PayInfo = a(paramVoIP_PayInfo);
    System.out.println("create OK!");
    GoogleWalletPayHelper.getInstance().pay(paramVoIP_PayInfo);
    System.out.println("begin pay!");
  }
  
  public void a(String paramString)
  {
    GoogleWalletPayHelper.getInstance().restorPay(paramString);
    System.out.println("restorePay OK!");
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (!GoogleWalletPayHelper.getInstance().handleActivityResult(paramInt1, paramInt2, paramIntent)) {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onDeliverFinishFailuer(RequestInfo paramRequestInfo, String paramString, int paramInt)
  {
    System.out.println("onDeliverFinishFailuer");
  }
  
  public void onDeliverFinishSucess(RequestInfo paramRequestInfo)
  {
    System.out.println("onDeliverFinishSucess");
  }
  
  public void onLoginExpiry(RequestInfo paramRequestInfo)
  {
    System.out.println("onLoginExpiry");
  }
  
  public void onNetWorkEorror(RequestInfo paramRequestInfo, int paramInt)
  {
    System.out.println("onNetWorkEorror");
  }
  
  public void onOrderFinishFailuer(RequestInfo paramRequestInfo, String paramString, int paramInt)
  {
    System.out.println("onOrderFinishFailuer");
  }
  
  public void onOrderFinishSucess(RequestInfo paramRequestInfo)
  {
    System.out.println("onOrderFinishSucess");
  }
  
  public void onPurchaseFinishFailuer(RequestInfo paramRequestInfo, String paramString, int paramInt)
  {
    System.out.println("onPurchaseFinishFailuer");
  }
  
  public void onPurchaseFinishSucess(RequestInfo paramRequestInfo)
  {
    System.out.println("onPurchaseFinishSucess");
  }
  
  public void onQueryProductInfoFailure(RequestInfo paramRequestInfo)
  {
    System.out.println("onQueryProductInfoFailure");
  }
  
  public void onRestoreFinishFailue(String paramString, int paramInt)
  {
    System.out.println("onRestoreFinishFailue");
  }
  
  public void onSetUpFinishFailure(RequestInfo paramRequestInfo, String paramString, int paramInt)
  {
    System.out.println("onSetUpFinishFailure");
  }
  
  public void onSetUpFinishSucess()
  {
    System.out.println("onSetUpFinishSucess");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.voippay.VoIP_Payer
 * JD-Core Version:    0.7.0.1
 */