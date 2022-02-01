package cooperation.qqindividuality;

import acfp;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import arhz;
import aurf;
import avfw;
import avks;
import avkt;
import avku;
import avkw;
import avlf;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginInfo;

public class QQIndividualityBridgeActivity
  extends QQIndividualityBaseBridgeActivity
{
  public static long azC;
  public static int exn;
  public static int exo = 1;
  public static int exp = 2;
  public a a;
  public b a;
  public boolean amg = true;
  String name = null;
  String path = null;
  int requestCode;
  public int type = -1;
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.type == exn) {
      if (this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$a != null)
      {
        if (this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$a.isShowing()) {
          this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$a.dismiss();
        }
        this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$a.setOnDismissListener(null);
        this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$a = null;
      }
    }
    for (;;)
    {
      setResult(paramInt2, paramIntent);
      super.finish();
      return;
      if (((this.type == exo) || (this.type == exp)) && (this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$b != null))
      {
        if (this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$b.isShowing()) {
          this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$b.dismiss();
        }
        this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$b.setOnDismissListener(null);
        this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$b = null;
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(2131167595);
    if (Math.abs(System.currentTimeMillis() - azC) < 800L)
    {
      setResult(1001);
      super.finish();
    }
    do
    {
      int i;
      do
      {
        return true;
        paramBundle = getIntent();
        if (paramBundle != null) {
          this.type = paramBundle.getIntExtra("individuality_plugin", -1);
        }
        azC = System.currentTimeMillis();
        this.path = getIntent().getStringExtra(avkw.cLA);
        this.name = getIntent().getStringExtra(avkw.cLB);
        if ((TextUtils.isEmpty(this.path)) || (TextUtils.isEmpty(this.name)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQIndividuality", 2, "path or name is null , return: " + this.path + " " + this.name);
          }
          setResult(1001);
          super.finish();
        }
        i = super.getResources().getDimensionPixelSize(2131299627);
        this.requestCode = getIntent().getIntExtra(avkw.cLE, -1);
        if ((this.type == exo) || (this.type == exp))
        {
          this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$b = new b(this);
          this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$b.setCanceledOnTouchOutside(false);
          this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$b.setOnDismissListener(new avks(this));
        }
      } while (this.type != exn);
      this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$a = new a(this, i);
      this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$a.setMessage(acfp.m(2131711804));
      this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$a.setCanceledOnTouchOutside(false);
    } while (this.requestCode == -1);
    this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$a.setOnDismissListener(new avkt(this));
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$a != null)
    {
      if (this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$a.isShowing()) {
        this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$a.dismiss();
      }
      this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$a.setOnDismissListener(null);
      this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$a = null;
    }
    if (this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$b != null)
    {
      if (this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$b.isShowing()) {
        this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$b.dismiss();
      }
      this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$b.setOnDismissListener(null);
      this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$b = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQIndividuality", 2, "destroy.....");
    }
    sTopActivity = null;
  }
  
  public void eAz()
  {
    Intent localIntent = getIntent();
    if (localIntent == null) {}
    for (;;)
    {
      return;
      if (!QIPCServerHelper.getInstance().isModuleRunning("qqindividuality_plugin.apk"))
      {
        this.amg = false;
        if (this.type == exn)
        {
          QQIndividualityProxyActivity.a(this, localIntent, this.app.getCurrentAccountUin(), "com.qqindividuality.activity.QQIndividualityActivity", QQIndividualityProxyActivity.class, this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$a, this.requestCode);
          overridePendingTransition(2130772162, 0);
        }
      }
      while (-1 == this.requestCode)
      {
        super.finish();
        return;
        if (this.type == exo)
        {
          localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
          localIntent.putExtra("is_first_open", true);
          QQIndividualityProxyActivity.a(this, localIntent, this.app.getCurrentAccountUin(), "com.qqindividuality.activity.QQIndividualitySignatureActivity", QQIndividualityProxyActivity.class, this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$b, this.requestCode);
          overridePendingTransition(2130772162, 0);
        }
        else if (this.type == exp)
        {
          QQIndividualityProxyActivity.a(this, localIntent, this.app.getCurrentAccountUin(), "com.qqindividuality.activity.QQIndividualityStatusHistoryActivity", QQIndividualityProxyActivity.class, this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$b, this.requestCode);
          overridePendingTransition(2130772162, 0);
          continue;
          if (this.type == exn)
          {
            QQIndividualityProxyActivity.a(this, localIntent, this.app.getCurrentAccountUin(), "com.qqindividuality.activity.QQIndividualityActivity", QQIndividualityProxyActivity.class, null, this.requestCode);
          }
          else if (this.type == exo)
          {
            localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
            QQIndividualityProxyActivity.a(this, localIntent, this.app.getCurrentAccountUin(), "com.qqindividuality.activity.QQIndividualitySignatureActivity", QQIndividualityProxyActivity.class, null, this.requestCode);
          }
          else if (this.type == exp)
          {
            QQIndividualityProxyActivity.a(this, localIntent, this.app.getCurrentAccountUin(), "com.qqindividuality.activity.QQIndividualityStatusHistoryActivity", QQIndividualityProxyActivity.class, null, this.requestCode);
            overridePendingTransition(2130772162, 0);
          }
        }
      }
    }
  }
  
  public void initPlugin()
  {
    if (this.jdField_a_of_type_Avfw == null) {
      return;
    }
    PluginInfo localPluginInfo = this.jdField_a_of_type_Avfw.b("qqindividuality_plugin.apk");
    if (localPluginInfo != null)
    {
      if (localPluginInfo.mState == 4)
      {
        eAz();
        return;
      }
      if ((localPluginInfo.mState == 1) || (localPluginInfo.mState == 3))
      {
        showDialog();
        this.b.sendEmptyMessageDelayed(1000, 200L);
        return;
      }
      showDialog();
      this.jdField_a_of_type_Avfw.installPlugin("qqindividuality_plugin.apk", new avku(this));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQIndividuality", 2, "initPlugin pluginInfo == null");
    }
    showDialog();
    this.b.sendEmptyMessageDelayed(1000, 200L);
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(1);
  }
  
  public void showDialog()
  {
    if (!isFinishing())
    {
      if (this.type != exn) {
        break label25;
      }
      this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$a.show();
    }
    label25:
    while ((this.type != exp) && (this.type != exo)) {
      return;
    }
    this.jdField_a_of_type_CooperationQqindividualityQQIndividualityBridgeActivity$b.show();
  }
  
  class a
    extends arhz
  {
    public a(Context paramContext, int paramInt)
    {
      super(paramInt);
    }
    
    public void onBackPressed()
    {
      if (QQIndividualityBridgeActivity.this.amg) {
        super.onBackPressed();
      }
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("IphoneTitleBarActivity", 2, "tool process has started, cancel by the tool");
    }
  }
  
  class b
    extends avlf
  {
    public b(Context paramContext)
    {
      super();
    }
    
    public void onBackPressed()
    {
      if (QQIndividualityBridgeActivity.this.amg) {
        super.onBackPressed();
      }
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("IphoneTitleBarActivity", 2, "tool process has started, cancel by the tool");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqindividuality.QQIndividualityBridgeActivity
 * JD-Core Version:    0.7.0.1
 */