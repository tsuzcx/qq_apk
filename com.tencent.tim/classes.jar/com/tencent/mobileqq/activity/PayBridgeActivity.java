package com.tencent.mobileqq.activity;

import affz.a;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.Window;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.pay.PayLogic;
import java.lang.ref.WeakReference;

public class PayBridgeActivity
  extends BaseActivity
{
  private a jdField_a_of_type_ComTencentMobileqqActivityPayBridgeActivity$a;
  private PayLogic jdField_a_of_type_CooperationQwalletPluginPayPayLogic;
  public boolean aYU;
  protected long dj;
  protected boolean mIsResume;
  
  public static boolean a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    return a(paramActivity, paramInt, paramBundle, null);
  }
  
  public static boolean a(Activity paramActivity, int paramInt, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    if ((paramActivity == null) || (paramBundle == null)) {
      return false;
    }
    if (paramResultReceiver != null) {
      paramBundle.putParcelable("receiver", paramResultReceiver);
    }
    paramResultReceiver = new Intent(BaseApplication.getContext(), PayBridgeActivity.class);
    paramResultReceiver.putExtras(paramBundle);
    paramResultReceiver.putExtra("pay_requestcode", paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.pay.PayBridgeActivity", 2, "tenpay startActivity and request=" + paramBundle.toString() + ",requestCode=" + paramInt);
    }
    paramActivity.startActivityForResult(paramResultReceiver, paramInt);
    return true;
  }
  
  public static boolean a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.pay.PayBridgeActivity", 2, "startEmojimallPaycallbackid:" + paramString1 + "appid:" + paramString2 + "userId:" + paramString3 + "userKey:" + paramString4 + "zoneId:" + paramString5 + "pf:" + paramString6 + "pfKey:" + paramString7 + "tokenUrl:" + paramString8 + "drmInfo:" + paramString9);
    }
    if ((paramActivity == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString4)) || (TextUtils.isEmpty(paramString8))) {
      return false;
    }
    Intent localIntent = new Intent(paramActivity, PayBridgeActivity.class);
    localIntent.putExtras(new affz.a(paramString1, paramString2, paramString3, paramString4, "uin", "skey", paramString5, paramString6, paramString7, paramString8, paramString9).getBundleData());
    localIntent.putExtra("pay_requestcode", 1);
    localIntent.addFlags(67108864);
    localIntent.addFlags(536870912);
    paramActivity.startActivityForResult(localIntent, 1);
    return true;
  }
  
  private void bSb()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPayBridgeActivity$a = new a(this);
      IntentFilter localIntentFilter = new IntentFilter("action_launch_completed");
      registerReceiver(this.jdField_a_of_type_ComTencentMobileqqActivityPayBridgeActivity$a, localIntentFilter);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private void bSc()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPayBridgeActivity$a != null) {
        unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqActivityPayBridgeActivity$a);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private String getJson()
  {
    if (getIntent() != null) {
      getIntent().getStringExtra("json");
    }
    return null;
  }
  
  private int getRequestCode()
  {
    int i = -1;
    if (getIntent() != null) {
      i = getIntent().getIntExtra("pay_requestcode", -1);
    }
    return i;
  }
  
  public static boolean isPaying()
  {
    return PayLogic.isPaying();
  }
  
  public static Bundle newPay(AppInterface paramAppInterface, Activity paramActivity, ResultReceiver paramResultReceiver, int paramInt, Bundle paramBundle)
  {
    return PayLogic.newPay(paramAppInterface, paramActivity, paramResultReceiver, paramInt, paramBundle);
  }
  
  public static boolean startGoldCharge(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    if ((paramActivity == null) || (paramBundle == null)) {
      return false;
    }
    Intent localIntent = new Intent(paramActivity, PayBridgeActivity.class);
    localIntent.putExtras(paramBundle);
    paramActivity.startActivityForResult(localIntent, paramInt);
    return true;
  }
  
  public static boolean startOpenQQReaderVip(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    if ((paramActivity == null) || (paramBundle == null)) {
      return false;
    }
    Intent localIntent = new Intent(paramActivity, PayBridgeActivity.class);
    localIntent.putExtras(paramBundle);
    paramActivity.startActivityForResult(localIntent, paramInt);
    return true;
  }
  
  public static boolean tenpay(Activity paramActivity, String paramString1, int paramInt, String paramString2)
  {
    if ((paramActivity == null) || (paramString1 == null)) {
      return false;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("json", paramString1);
    localBundle.putString("callbackSn", paramString2);
    return a(paramActivity, paramInt, localBundle);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      if ((this.mIsResume) && (!isFinishing()))
      {
        long l = NetConnInfoCenter.getServerTimeMillis();
        if ((l > this.dj) && (l - this.dj > 10000L))
        {
          VACDReportUtil.a(null, "qqwallet", "PayBridge", "click.mobileqq", "isPluginloaded=" + this.aYU + "&reqcode=" + getRequestCode() + "&json=" + getJson(), 0, null);
          this.jdField_a_of_type_CooperationQwalletPluginPayPayLogic.end();
        }
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(2131167595);
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.pay.PayBridgeActivity", 2, "doOnCreate@" + hashCode());
    }
    if ((paramBundle != null) && (paramBundle.containsKey("save_instance_logic_tag")))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qwallet.pay.PayBridgeActivity", 2, "doOnCreate from reboot@" + hashCode());
      }
      this.jdField_a_of_type_CooperationQwalletPluginPayPayLogic = PayLogic.getLogic(paramBundle.getInt("save_instance_logic_tag"));
      if ((this.jdField_a_of_type_CooperationQwalletPluginPayPayLogic != null) && (this.jdField_a_of_type_CooperationQwalletPluginPayPayLogic.tryDoOnActivityResult(this))) {
        return false;
      }
      finish();
      return false;
    }
    this.jdField_a_of_type_CooperationQwalletPluginPayPayLogic = new PayLogic(getIntent(), this.app, this);
    if (!this.jdField_a_of_type_CooperationQwalletPluginPayPayLogic.init())
    {
      this.jdField_a_of_type_CooperationQwalletPluginPayPayLogic.end();
      return false;
    }
    this.jdField_a_of_type_CooperationQwalletPluginPayPayLogic.exec();
    bSb();
    return false;
  }
  
  public void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.pay.PayBridgeActivity", 2, "doOnDestroy@" + hashCode());
    }
    super.doOnDestroy();
    if (this.jdField_a_of_type_CooperationQwalletPluginPayPayLogic != null) {
      this.jdField_a_of_type_CooperationQwalletPluginPayPayLogic.onDestroy();
    }
    bSc();
  }
  
  public void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.pay.PayBridgeActivity", 2, "doOnPause@" + hashCode());
    }
    super.doOnPause();
  }
  
  public void doOnRestoreInstanceState(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.pay.PayBridgeActivity", 2, "doOnRestoreInstanceState@" + hashCode());
    }
    super.doOnRestoreInstanceState(paramBundle);
    this.jdField_a_of_type_CooperationQwalletPluginPayPayLogic.doOnRestoreInstanceState(paramBundle);
  }
  
  public void doOnResume()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.pay.PayBridgeActivity", 2, "doOnResume@" + hashCode());
    }
    this.mIsResume = true;
    this.dj = NetConnInfoCenter.getServerTimeMillis();
    super.doOnResume();
  }
  
  public void doOnSaveInstanceState(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.pay.PayBridgeActivity", 2, "doOnSaveInstanceState@" + hashCode());
    }
    super.doOnSaveInstanceState(paramBundle);
    if (paramBundle != null) {
      paramBundle.putInt("save_instance_logic_tag", this.jdField_a_of_type_CooperationQwalletPluginPayPayLogic.getTag());
    }
    this.jdField_a_of_type_CooperationQwalletPluginPayPayLogic.doOnSaveInstanceState(paramBundle);
  }
  
  public void doOnStop()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.pay.PayBridgeActivity", 2, "doOnStop@" + hashCode());
    }
    super.doOnStop();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.pay.PayBridgeActivity", 2, "onActivityResult@" + hashCode());
    }
    this.jdField_a_of_type_CooperationQwalletPluginPayPayLogic.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  static class a
    extends BroadcastReceiver
  {
    WeakReference<PayBridgeActivity> mRef;
    
    a(PayBridgeActivity paramPayBridgeActivity)
    {
      this.mRef = new WeakReference(paramPayBridgeActivity);
    }
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ((paramIntent != null) && ("action_launch_completed".equals(paramIntent.getAction())) && ("qwallet_plugin.apk".equals(paramIntent.getStringExtra("plugin_apk"))) && (this.mRef != null))
      {
        paramContext = (PayBridgeActivity)this.mRef.get();
        if (paramContext != null) {
          paramContext.aYU = true;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PayBridgeActivity
 * JD-Core Version:    0.7.0.1
 */