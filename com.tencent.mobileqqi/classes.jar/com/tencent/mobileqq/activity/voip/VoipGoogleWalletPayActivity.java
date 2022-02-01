package com.tencent.mobileqq.activity.voip;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.view.Menu;
import com.pay.googlewaletsdk.entity.RequestInfo;
import com.pay.googlewalletsdk.GoogleWalletPayHelper;
import com.pay.googlewalletsdk.IPayListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import ewi;
import ewj;
import ewk;
import ewl;
import ewm;

public class VoipGoogleWalletPayActivity
  extends BaseActivity
  implements IPayListener
{
  private static Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  public static final String a = "VoipGooglePayActivityParam";
  public QQProgressDialog a;
  private boolean jdField_a_of_type_Boolean = false;
  private final String b;
  private String c = "";
  private String d = "";
  
  public VoipGoogleWalletPayActivity()
  {
    this.jdField_b_of_type_JavaLangString = "release";
  }
  
  private void e()
  {
    jdField_a_of_type_AndroidOsHandler.post(new ewj(this));
  }
  
  private void f()
  {
    jdField_a_of_type_AndroidOsHandler.post(new ewk(this));
  }
  
  private void g()
  {
    jdField_a_of_type_AndroidOsHandler.post(new ewl(this));
  }
  
  private void h()
  {
    jdField_a_of_type_AndroidOsHandler.post(new ewm(this));
  }
  
  public void a(Activity paramActivity)
  {
    GoogleWalletPayHelper.getInstance().init(paramActivity, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA1NiOGiwiiVAc8WoXdMzw+pD7J65wpQYS7n9+e0Hvttf2UCLv7rxxQqWh3siJwl2nf62MKZjnKoiNxwunShwbncsEFwa/X1OYpJ0ANNJq0vwrDaAiZb7mrwz67eqwU8ChZtzb5fj58AtZqevvBwBZ6C7EKrclwQTonE0Kj3jihuuJkwlzSmr08yVrUUMELTwDeAGMv79HCEEicbdo8BDJ3SCyByy+hWtBf0FRuYZeTXlCIEdtIbFG5RRAksFD4ab8Zs4BMqkNHDKUMsshRcZ9b//OtphYR4jYTh/YZAht0MHPneNqsXXQLgHkyBEMKZ+CRQW2HJEQ5QjrsIXhlXFYuwIDAQAB", this);
    GoogleWalletPayHelper.getInstance().setEnv("release");
  }
  
  public void a(ComponentName paramComponentName, IBinder paramIBinder) {}
  
  public void a(String paramString)
  {
    try
    {
      paramString = QQiGoogleWalletPayHelper.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.d(), paramString, this.d);
      GoogleWalletPayHelper.getInstance().pay(paramString);
      e();
      return;
    }
    catch (Exception paramString)
    {
      h();
    }
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_Boolean = true;
    GoogleWalletPayHelper.getInstance().restorPay(paramString);
  }
  
  public void d()
  {
    GoogleWalletPayHelper.getInstance().dispose();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130904062);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131562300);
    paramBundle = getIntent().getExtras().getBundle("VoipGooglePayActivityParam");
    this.c = paramBundle.getString("productid");
    this.d = paramBundle.getString("price");
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    a(this);
    new Handler().postDelayed(new ewi(this), 1000L);
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    d();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.hide();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    QLog.d("IABHelper", 2, "onActivityResult");
    if (!GoogleWalletPayHelper.getInstance().handleActivityResult(paramInt1, paramInt2, paramIntent)) {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    f();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    return true;
  }
  
  public void onDeliverFinishFailuer(RequestInfo paramRequestInfo, String paramString, int paramInt)
  {
    QLog.d("IABHelper", 2, "onDeliverFinishFailuer");
    onNetWorkEorror(null, 0);
  }
  
  public void onDeliverFinishSucess(RequestInfo paramRequestInfo)
  {
    QLog.d("IABHelper", 2, "onDeliverFinishSucess");
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      f();
      a(paramRequestInfo.productID);
      return;
    }
    g();
  }
  
  public void onLoginExpiry(RequestInfo paramRequestInfo)
  {
    QLog.d("IABHelper", 2, "onLoginExpiry");
    onNetWorkEorror(null, 0);
  }
  
  public void onNetWorkEorror(RequestInfo paramRequestInfo, int paramInt)
  {
    QLog.d("IABHelper", 2, "onNetWorkEorror");
    this.jdField_a_of_type_Boolean = false;
    h();
  }
  
  public void onOrderFinishFailuer(RequestInfo paramRequestInfo, String paramString, int paramInt)
  {
    QLog.d("IABHelper", 2, "onOrderFinishFailuer");
    onNetWorkEorror(null, 0);
  }
  
  public void onOrderFinishSucess(RequestInfo paramRequestInfo)
  {
    QLog.d("IABHelper", 2, "onOrderFinishSucess");
  }
  
  public void onPurchaseFinishFailuer(RequestInfo paramRequestInfo, String paramString, int paramInt)
  {
    QLog.d("IABHelper", 2, "onPurchaseFinishFailuer");
    b(paramRequestInfo.productID);
  }
  
  public void onPurchaseFinishSucess(RequestInfo paramRequestInfo)
  {
    QLog.d("IABHelper", 2, "onPurchaseFinishSucess");
  }
  
  public void onQueryProductInfoFailure(RequestInfo paramRequestInfo)
  {
    QLog.d("IABHelper", 2, "onQueryProductInfoFailure");
    onNetWorkEorror(null, 0);
  }
  
  public void onRestoreFinishFailue(String paramString, int paramInt)
  {
    QLog.d("IABHelper", 2, "onRestoreFinishFailue");
    onNetWorkEorror(null, 0);
  }
  
  public void onSetUpFinishFailure(RequestInfo paramRequestInfo, String paramString, int paramInt)
  {
    QLog.d("IABHelper", 2, "onSetUpFinishFailure");
    onNetWorkEorror(null, 0);
  }
  
  public void onSetUpFinishSucess()
  {
    QLog.d("IABHelper", 2, "onSetUpFinishSucess");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.voip.VoipGoogleWalletPayActivity
 * JD-Core Version:    0.7.0.1
 */