package com.tencent.mobileqq.activity.voip;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Menu;
import android.widget.Button;
import com.pay.googlewaletsdk.entity.RequestInfo;
import com.pay.googlewaletsdk.entity.RequestInfo.changkeyType;
import com.pay.googlewaletsdk.entity.RequestInfo.keytype;
import com.pay.googlewaletsdk.entity.RequestInfo.productType;
import com.pay.googlewalletsdk.GoogleWalletPayHelper;
import com.pay.googlewalletsdk.IPayListener;
import com.pay.googlewalletsdk.util.IabHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import ewx;
import ewy;
import java.io.PrintStream;
import mqq.app.MobileQQ;

public class VoipPayActivity
  extends BaseActivity
  implements IPayListener
{
  private static IabHelper a;
  private static final String b = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA1NiOGiwiiVAc8WoXdMzw+pD7J65wpQYS7n9+e0Hvttf2UCLv7rxxQqWh3siJwl2nf62MKZjnKoiNxwunShwbncsEFwa/X1OYpJ0ANNJq0vwrDaAiZb7mrwz67eqwU8ChZtzb5fj58AtZqevvBwBZ6C7EKrclwQTonE0Kj3jihuuJkwlzSmr08yVrUUMELTwDeAGMv79HCEEicbdo8BDJ3SCyByy+hWtBf0FRuYZeTXlCIEdtIbFG5RRAksFD4ab8Zs4BMqkNHDKUMsshRcZ9b//OtphYR4jYTh/YZAht0MHPneNqsXXQLgHkyBEMKZ+CRQW2HJEQ5QjrsIXhlXFYuwIDAQAB";
  public String a;
  
  public VoipPayActivity()
  {
    this.jdField_a_of_type_JavaLangString = "voip_test2";
  }
  
  private RequestInfo a()
  {
    System.out.println("createRequestInfo begin!");
    RequestInfo localRequestInfo = new RequestInfo();
    localRequestInfo.openid = this.b.a();
    localRequestInfo.openkey = this.b.d();
    localRequestInfo.productID = this.jdField_a_of_type_JavaLangString;
    localRequestInfo.session_id = "uin";
    localRequestInfo.session_type = "skey";
    localRequestInfo.zoneid = "1";
    localRequestInfo.pf = "qq_m_qqi-0001-android-0001";
    localRequestInfo.pfkey = "pfkey";
    localRequestInfo.appid = "1450001096";
    localRequestInfo.payItem = (this.jdField_a_of_type_JavaLangString + "*8*1");
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
  
  public void a(Activity paramActivity)
  {
    GoogleWalletPayHelper.getInstance().init(paramActivity, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA1NiOGiwiiVAc8WoXdMzw+pD7J65wpQYS7n9+e0Hvttf2UCLv7rxxQqWh3siJwl2nf62MKZjnKoiNxwunShwbncsEFwa/X1OYpJ0ANNJq0vwrDaAiZb7mrwz67eqwU8ChZtzb5fj58AtZqevvBwBZ6C7EKrclwQTonE0Kj3jihuuJkwlzSmr08yVrUUMELTwDeAGMv79HCEEicbdo8BDJ3SCyByy+hWtBf0FRuYZeTXlCIEdtIbFG5RRAksFD4ab8Zs4BMqkNHDKUMsshRcZ9b//OtphYR4jYTh/YZAht0MHPneNqsXXQLgHkyBEMKZ+CRQW2HJEQ5QjrsIXhlXFYuwIDAQAB", this);
    System.out.println("init OK!");
    GoogleWalletPayHelper.getInstance().setEnv("test");
    System.out.println("setEnv OK!");
    GoogleWalletPayHelper.getInstance().setDebugLog(true);
    System.out.println("setDebugLog OK!");
  }
  
  public void a(ComponentName paramComponentName, IBinder paramIBinder) {}
  
  public void a(String paramString)
  {
    GoogleWalletPayHelper.getInstance().restorPay(paramString);
    System.out.println("restorePay OK!");
  }
  
  public void d()
  {
    GoogleWalletPayHelper.getInstance().dispose();
    System.out.println("destroy OK!");
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130904061);
    jdField_a_of_type_ComPayGooglewalletsdkUtilIabHelper = new IabHelper(this.b.getApplication().getApplicationContext(), "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA1NiOGiwiiVAc8WoXdMzw+pD7J65wpQYS7n9+e0Hvttf2UCLv7rxxQqWh3siJwl2nf62MKZjnKoiNxwunShwbncsEFwa/X1OYpJ0ANNJq0vwrDaAiZb7mrwz67eqwU8ChZtzb5fj58AtZqevvBwBZ6C7EKrclwQTonE0Kj3jihuuJkwlzSmr08yVrUUMELTwDeAGMv79HCEEicbdo8BDJ3SCyByy+hWtBf0FRuYZeTXlCIEdtIbFG5RRAksFD4ab8Zs4BMqkNHDKUMsshRcZ9b//OtphYR4jYTh/YZAht0MHPneNqsXXQLgHkyBEMKZ+CRQW2HJEQ5QjrsIXhlXFYuwIDAQAB");
    GoogleWalletPayHelper.getInstance().init(this, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA1NiOGiwiiVAc8WoXdMzw+pD7J65wpQYS7n9+e0Hvttf2UCLv7rxxQqWh3siJwl2nf62MKZjnKoiNxwunShwbncsEFwa/X1OYpJ0ANNJq0vwrDaAiZb7mrwz67eqwU8ChZtzb5fj58AtZqevvBwBZ6C7EKrclwQTonE0Kj3jihuuJkwlzSmr08yVrUUMELTwDeAGMv79HCEEicbdo8BDJ3SCyByy+hWtBf0FRuYZeTXlCIEdtIbFG5RRAksFD4ab8Zs4BMqkNHDKUMsshRcZ9b//OtphYR4jYTh/YZAht0MHPneNqsXXQLgHkyBEMKZ+CRQW2HJEQ5QjrsIXhlXFYuwIDAQAB", this);
    GoogleWalletPayHelper.getInstance().setEnv("test");
    GoogleWalletPayHelper.getInstance().setDebugLog(true);
    ((Button)findViewById(2131234706)).setOnClickListener(new ewx(this));
    ((Button)findViewById(2131234707)).setOnClickListener(new ewy(this));
    return true;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (!GoogleWalletPayHelper.getInstance().handleActivityResult(paramInt1, paramInt2, paramIntent)) {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    return true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.voip.VoipPayActivity
 * JD-Core Version:    0.7.0.1
 */