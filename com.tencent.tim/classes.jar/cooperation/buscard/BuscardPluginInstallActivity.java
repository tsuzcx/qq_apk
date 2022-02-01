package cooperation.buscard;

import acej;
import acfp;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import aqgz;
import arhz;
import avci;
import avcj;
import avfw;
import avfw.d;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginInfo;
import cooperation.pluginbridge.BridgeHelper;
import cooperation.qwallet.plugin.QWalletPayProgressDialog;
import cooperation.qwallet.plugin.proxy.QWalletNFCProxyActivity;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class BuscardPluginInstallActivity
  extends BaseActivity
{
  private arhz S;
  private avfw jdField_a_of_type_Avfw;
  private a jdField_a_of_type_CooperationBuscardBuscardPluginInstallActivity$a;
  private StringBuilder af = new StringBuilder("load plugin cost time info:");
  public long azs = 0L;
  private OnPluginInstallListener b;
  protected QWalletPayProgressDialog b;
  private String cJe;
  private boolean dma;
  private boolean dmb = true;
  private String mTag;
  private String skey = "";
  long start = 0L;
  
  public BuscardPluginInstallActivity()
  {
    this.jdField_b_of_type_ComTencentMobileqqPluginsdkOnPluginInstallListener = new avci(this);
  }
  
  private void ZG(String paramString)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isDevelopLevel()) {
      QLog.i("BuscardPluginInstallActivity", 4, "goPlugin " + paramString);
    }
    try
    {
      localObject1 = getApplicationContext();
      if (BridgeHelper.b("BuscardPlugin.apk", this.app.getCurrentAccountUin(), (Context)localObject1)) {
        if (getIntent() != null)
        {
          localIntent = getIntent();
          localIntent.putExtra("skey", this.skey);
          localIntent.putExtra("skey_type", "2");
          localIntent.putExtra("qq_version", aqgz.getQQVersion());
          localIntent.putExtra("params_remote_connect_at_launch", true);
          localIntent.addFlags(67108864);
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("mPluginType", 1);
          ((JSONObject)localObject2).put("mPluginID", "BuscardPlugin.apk");
          ((JSONObject)localObject2).put("mPluginName", PluginInfo.cKD);
          ((JSONObject)localObject2).put("mConponentName", b(this.mTag, localIntent));
          ((JSONObject)localObject2).put("mProxyActivityClass", QWalletNFCProxyActivity.class.getName());
          ((JSONObject)localObject2).put("mRequestCode", 19);
          ((JSONObject)localObject2).put("mTimeOut", 15000);
          ((JSONObject)localObject2).put("mDialogDismissBySDK", false);
          ((JSONObject)localObject2).put("skey", this.skey);
          ((JSONObject)localObject2).put("skey_type", 2);
          ((JSONObject)localObject2).put("font_level", acej.aV());
          localObject2 = ((JSONObject)localObject2).toString();
        }
      }
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        Object localObject1;
        for (;;)
        {
          Object localObject2;
          localObject3 = BridgeHelper.a((Context)localObject1, this.app.getCurrentAccountUin()).getConfig("buscard_pluginNewNfcAPIFlag");
          localObject1 = BridgeHelper.a((Context)localObject1, this.app.getCurrentAccountUin()).getConfig("buscard_pluginNewNfcAPIBlackModel");
          localIntent.putExtra("buscard_pluginNewNfcAPIFlag", (String)localObject3);
          localIntent.putExtra("buscard_pluginNewNfcAPIBlackModel", (String)localObject1);
          BridgeHelper.a(this, this.app, localIntent, (String)localObject2, "BuscardPlugin.apk", PluginInfo.cKD);
          avcj.register();
          return;
          Intent localIntent = new Intent();
        }
        localThrowable1 = localThrowable1;
        if (QLog.isDevelopLevel())
        {
          localObject1 = new StringBuilder().append("go brigde Plugin failed;where=").append(paramString).append("; app.getCurrentAccountUin()=");
          if (this.app.getCurrentAccountUin() != null)
          {
            paramString = this.app.getCurrentAccountUin();
            localObject1 = ((StringBuilder)localObject1).append(paramString).append("; error=");
            if ((localThrowable1 == null) || (localThrowable1.getMessage() == null)) {
              break label623;
            }
            paramString = localThrowable1.getMessage();
            QLog.i("BuscardPluginInstallActivity", 4, paramString);
          }
        }
        else
        {
          long l2 = System.currentTimeMillis();
          this.af.append(" ==step6:goPlugin isPluginLaunchModeBridge() cost=" + (l2 - l1) + ";start time=" + l1);
          l1 = System.currentTimeMillis();
          if (!this.jdField_a_of_type_Avfw.isPlugininstalled("BuscardPlugin.apk")) {
            break label629;
          }
          this.dmb = true;
          this.af.append(" ==step7:goPlugin plugin has installed, cost=" + (System.currentTimeMillis() - l1));
          ezs();
          return;
        }
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          Object localObject3;
          if (QLog.isDevelopLevel())
          {
            localObject3 = new StringBuilder().append("go brigde Plugin failed; error=");
            if ((localThrowable2 != null) && (localThrowable2.getMessage() != null)) {}
            for (String str = localThrowable2.getMessage();; str = "null")
            {
              QLog.i("BuscardPluginInstallActivity", 4, str);
              break;
            }
            paramString = "null";
            continue;
            label623:
            paramString = "null";
          }
        }
        label629:
        this.dmb = false;
        this.af.append(" ==step7:goPlugin plugin has not installed, cost=" + (System.currentTimeMillis() - l1));
        this.azs = System.currentTimeMillis();
        this.jdField_a_of_type_Avfw.installPlugin("BuscardPlugin.apk", this.jdField_b_of_type_ComTencentMobileqqPluginsdkOnPluginInstallListener);
      }
    }
  }
  
  private String b(String paramString, Intent paramIntent)
  {
    StringBuffer localStringBuffer = new StringBuffer("com.tenpay.android.qqplugin.activity.");
    if ((paramString == null) && (this.cJe != null)) {
      localStringBuffer.append("RedepositActivity");
    }
    if (("experience".equals(paramString)) || ("recharge".equals(paramString))) {
      localStringBuffer.append("BusCardActivity");
    }
    for (;;)
    {
      return localStringBuffer.toString();
      if ("load".equals(paramString))
      {
        localStringBuffer.append("RedepositActivity");
      }
      else if ("friends".equals(paramString))
      {
        localStringBuffer.append("BusCardActivity");
        if (paramIntent != null) {
          paramIntent.putExtra("buscard_plugin_from", "FriendsActivity");
        }
      }
      else if ("replace_load".equals(paramString))
      {
        localStringBuffer.append("RedepositActivity");
        if (paramIntent != null) {
          paramIntent.putExtra("buscard_plugin_from", "FriendsActivity");
        }
      }
      else
      {
        localStringBuffer.append("BusCardActivity");
      }
    }
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
      this.jdField_b_of_type_CooperationQwalletPluginQWalletPayProgressDialog.setMessage(acfp.m(2131703294));
      this.jdField_b_of_type_CooperationQwalletPluginQWalletPayProgressDialog.show();
      return;
    }
    this.jdField_b_of_type_CooperationQwalletPluginQWalletPayProgressDialog.dismiss();
    this.jdField_b_of_type_CooperationQwalletPluginQWalletPayProgressDialog = null;
  }
  
  private void ezr()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("BuscardPluginInstallActivity", 4, "initPluginManager");
    }
    long l1 = System.currentTimeMillis();
    this.jdField_a_of_type_Avfw = ((avfw)this.app.getManager(27));
    long l2 = System.currentTimeMillis();
    this.af.append(" ==step2:initPluginManager app.getManager cost=" + (l2 - l1));
    bx(true);
    l1 = System.currentTimeMillis();
    BuscardPluginInstallActivity.1 local1 = new BuscardPluginInstallActivity.1(this);
    ThreadManager.getSubThreadHandler().post(local1);
    l2 = System.currentTimeMillis();
    this.af.append(" ==step3:initPluginManager post runnable cost=" + (l2 - l1) + ";post time=" + l2);
  }
  
  private void ezs()
  {
    long l1 = System.currentTimeMillis();
    Intent localIntent;
    if (getIntent() != null) {
      localIntent = getIntent();
    }
    Object localObject2;
    for (;;)
    {
      localIntent.putExtra("skey", this.skey);
      localIntent.putExtra("skey_type", "2");
      localIntent.putExtra("font_level", acej.aV());
      if (this.cJe != null) {
        localIntent.putExtra("pay_result", this.cJe);
      }
      localIntent.putExtra("param_plugin_gesturelock", true);
      localIntent.putExtra("useSkinEngine", true);
      localIntent.putExtra("qq_version", aqgz.getQQVersion());
      localIntent.putExtra("params_remote_connect_at_launch", true);
      localIntent.addFlags(67108864);
      long l2 = System.currentTimeMillis();
      this.af.append(" ==step8:launchBuscardPlugin put cost=" + (l2 - l1));
      l1 = System.currentTimeMillis();
      try
      {
        Object localObject1 = BridgeHelper.a(getApplicationContext(), this.app.getCurrentAccountUin()).getConfig("buscard_pluginNewNfcAPIFlag");
        localObject2 = BridgeHelper.a(getApplicationContext(), this.app.getCurrentAccountUin()).getConfig("buscard_pluginNewNfcAPIBlackModel");
        localIntent.putExtra("buscard_pluginNewNfcAPIFlag", (String)localObject1);
        localIntent.putExtra("buscard_pluginNewNfcAPIBlackModel", (String)localObject2);
        l2 = System.currentTimeMillis();
        this.af.append(" ==step9:launchBuscardPlugin gray control cost=" + (l2 - l1));
        l1 = System.currentTimeMillis();
        localIntent.putExtra("plugin_lunch_costtime_info", this.af.toString());
        localIntent.putExtra("plugin_lunch_start", this.start);
        localIntent.putExtra("plugin_openActivity_start", l1);
        localIntent.putExtra("plugin_is_installed", this.dmb);
        localObject1 = new avfw.d(1);
        ((avfw.d)localObject1).mPluginID = "BuscardPlugin.apk";
        ((avfw.d)localObject1).mPluginName = "BuscardPlugin";
        ((avfw.d)localObject1).mDialog = null;
        ((avfw.d)localObject1).mUin = this.app.getCurrentAccountUin();
        ((avfw.d)localObject1).mIntent = localIntent;
        ((avfw.d)localObject1).cKu = b(this.mTag, localIntent);
        ((avfw.d)localObject1).K = QWalletNFCProxyActivity.class;
        ((avfw.d)localObject1).mRequestCode = 19;
        ((avfw.d)localObject1).mTimeOut = 15000;
        ((avfw.d)localObject1).dmV = false;
        ((avfw.d)localObject1).cKv = null;
        avfw.a(this, (avfw.d)localObject1);
        l2 = System.currentTimeMillis();
        this.af.append(" ==step10:launchBuscardPlugin openActivityForResult cost=" + (l2 - l1));
        l1 = System.currentTimeMillis();
        avcj.register();
        if (this.S != null)
        {
          this.S.dismiss();
          this.S = null;
        }
        localIntent = new Intent();
        localIntent.putExtra("ret", "ok");
        setResult(-1, localIntent);
        this.af.append(" ==step11:launchBuscardPlugin finish cost=" + (System.currentTimeMillis() - l1));
        if (QLog.isDevelopLevel()) {
          QLog.i("BuscardPluginInstallActivity", 2, "buscard lunch cost info ===========" + this.af.toString());
        }
        finish();
        return;
        localIntent = new Intent();
      }
      catch (Throwable localThrowable)
      {
        while (!QLog.isDevelopLevel()) {}
        localObject2 = new StringBuilder().append("go brigde Plugin failed; error=");
        if (localThrowable == null) {
          break label649;
        }
      }
    }
    if (localThrowable.getMessage() != null) {}
    label649:
    for (String str = localThrowable.getMessage();; str = "null")
    {
      QLog.i("BuscardPluginInstallActivity", 4, str);
      break;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.start = System.currentTimeMillis();
    super.doOnCreate(paramBundle);
    if (!this.app.isLogin())
    {
      paramBundle = new Intent();
      paramBundle.setClass(this, LoginActivity.class);
      paramBundle.addFlags(262144);
      startActivity(paramBundle);
      finish();
      return false;
    }
    paramBundle = (TicketManager)this.app.getManager(2);
    if (paramBundle != null) {
      this.skey = paramBundle.getSkey(this.app.getCurrentAccountUin());
    }
    StringBuilder localStringBuilder;
    for (;;)
    {
      paramBundle = new IntentFilter();
      paramBundle.addAction("bridge.plugin.onresume.broadcast");
      this.jdField_a_of_type_CooperationBuscardBuscardPluginInstallActivity$a = new a(null);
      registerReceiver(this.jdField_a_of_type_CooperationBuscardBuscardPluginInstallActivity$a, paramBundle);
      Intent localIntent = getIntent();
      if (localIntent != null)
      {
        paramBundle = localIntent.getStringExtra("options");
        if (paramBundle == null) {}
      }
      try
      {
        this.mTag = new JSONObject(paramBundle).optString("tag");
        this.cJe = localIntent.getDataString();
        this.af.append(" ==step1:doOnCreate cost=" + (System.currentTimeMillis() - this.start));
        ezr();
        return true;
        this.skey = "";
      }
      catch (Exception paramBundle)
      {
        while (!QLog.isDevelopLevel()) {}
        localStringBuilder = new StringBuilder().append("mPluginManager.queryPlugin->error:");
        if (paramBundle == null) {
          break label281;
        }
      }
    }
    if (paramBundle.getMessage() != null) {}
    label281:
    for (paramBundle = paramBundle.getMessage();; paramBundle = "null")
    {
      QLog.e("BuscardPluginInstallActivity", 4, paramBundle);
      break;
    }
  }
  
  public void doOnDestroy()
  {
    StringBuilder localStringBuilder;
    try
    {
      if (this.jdField_a_of_type_CooperationBuscardBuscardPluginInstallActivity$a != null) {
        unregisterReceiver(this.jdField_a_of_type_CooperationBuscardBuscardPluginInstallActivity$a);
      }
      bx(false);
      super.doOnDestroy();
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isDevelopLevel()) {}
      localStringBuilder = new StringBuilder().append("doOnDestroy->error:");
      if (localThrowable == null) {
        break label79;
      }
    }
    if (localThrowable.getMessage() != null) {}
    label79:
    for (String str = localThrowable.getMessage();; str = "null")
    {
      QLog.e("BuscardPluginInstallActivity", 4, str);
      break;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("BuscardPluginInstallActivity", 4, "onActivityResult:requestCode=" + paramInt1 + ",resultCode=" + paramInt2);
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
  
  class a
    extends BroadcastReceiver
  {
    private a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("BuscardPluginInstallActivity", 4, "BuscardPluginOnResumeReceiver->onReceive, intent:" + paramIntent);
      }
      if ((paramIntent == null) || (!"bridge.plugin.onresume.broadcast".equals(paramIntent.getAction()))) {
        return;
      }
      BuscardPluginInstallActivity.this.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.buscard.BuscardPluginInstallActivity
 * JD-Core Version:    0.7.0.1
 */