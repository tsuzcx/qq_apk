package cooperation.hce;

import acfp;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import auri;
import avfk;
import avfl;
import avfm;
import avfw;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletHelper;
import cooperation.qwallet.plugin.QWalletPayProgressDialog;
import tzd;
import tzg;
import tzk;

public class HcePluginInstallActivity
  extends BaseActivity
{
  private String Tn;
  private avfw a;
  private OnPluginInstallListener b;
  protected QWalletPayProgressDialog b;
  private tzg c;
  private String cKp;
  private tzd d = new avfl(this);
  private boolean dma;
  
  public HcePluginInstallActivity()
  {
    this.jdField_b_of_type_ComTencentMobileqqPluginsdkOnPluginInstallListener = new avfk(this);
  }
  
  private void ZG(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("HcePluginInstallActivity", 4, "goPlugin " + paramString);
    }
    if (this.a.isPlugininstalled("vfc_plugin.apk"))
    {
      ezs();
      return;
    }
    this.a.installPlugin("vfc_plugin.apk", this.jdField_b_of_type_ComTencentMobileqqPluginsdkOnPluginInstallListener);
  }
  
  private void bx(boolean paramBoolean)
  {
    boolean bool = super.isFinishing();
    if (paramBoolean) {
      if (!bool)
      {
        if (this.jdField_b_of_type_CooperationQwalletPluginQWalletPayProgressDialog == null) {
          break label28;
        }
        this.jdField_b_of_type_CooperationQwalletPluginQWalletPayProgressDialog.show();
      }
    }
    label28:
    while ((this.jdField_b_of_type_CooperationQwalletPluginQWalletPayProgressDialog == null) || (!this.jdField_b_of_type_CooperationQwalletPluginQWalletPayProgressDialog.isShowing()))
    {
      return;
      this.jdField_b_of_type_CooperationQwalletPluginQWalletPayProgressDialog = new QWalletPayProgressDialog(this);
      this.jdField_b_of_type_CooperationQwalletPluginQWalletPayProgressDialog.setMessage(acfp.m(2131707116));
      this.jdField_b_of_type_CooperationQwalletPluginQWalletPayProgressDialog.show();
      return;
    }
    this.jdField_b_of_type_CooperationQwalletPluginQWalletPayProgressDialog.dismiss();
    this.jdField_b_of_type_CooperationQwalletPluginQWalletPayProgressDialog = null;
  }
  
  private void ezI()
  {
    tzk.prepare();
    this.c = tzk.a(this, 4, "1106788359");
  }
  
  private void ezJ()
  {
    try
    {
      QWalletHelper.launchVfcPlugin(this, this.app, this.cKp, this.Tn, avfm.FO());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("HcePluginInstallActivity", 1, localThrowable, new Object[0]);
      return;
    }
    finally
    {
      finish();
    }
  }
  
  private void ezr()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("HcePluginInstallActivity", 4, "initPluginManager");
    }
    this.a = ((avfw)this.app.getManager(27));
    this.Tn = auri.getIMEI("0e8bd1");
    bx(true);
    ThreadManagerV2.executeOnSubThread(new HcePluginInstallActivity.1(this));
  }
  
  private void ezs()
  {
    this.cKp = "";
    if (!isNetworkAvailable(getApplicationContext()))
    {
      QQToast.a(getApplicationContext(), 2131696284, 0).show();
      ezJ();
    }
    while (this.c == null) {
      return;
    }
    this.c.a("loginSilent", null, this.d);
  }
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {}
    for (;;)
    {
      return false;
      paramContext = paramContext.getAllNetworkInfo();
      if (paramContext != null)
      {
        int i = 0;
        while (i < paramContext.length)
        {
          if (paramContext[i].getState() == NetworkInfo.State.CONNECTED) {
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    ezI();
    ezr();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.c != null) {
      this.c.release();
    }
    bx(false);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("HcePluginInstallActivity", 4, "onActivityResult:requestCode=" + paramInt1 + ",resultCode=" + paramInt2);
    }
    if ((paramInt1 != 1) || (paramInt2 == 0)) {}
    for (;;)
    {
      if ((paramInt1 == 19) && ((paramInt2 == 20) || (paramInt2 == 4865))) {
        finish();
      }
      return;
      ZG("onActivityResult");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.hce.HcePluginInstallActivity
 * JD-Core Version:    0.7.0.1
 */