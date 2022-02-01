package cooperation.qlink;

import acfp;
import android.content.BroadcastReceiver;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import aqgv;
import aqha;
import aqju;
import avhc;
import avib;
import avic;
import avid;
import avie;
import avif;
import avig;
import avih;
import avii;
import avij;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class QlinkStandardDialogActivity
  extends BaseActivity
{
  private BroadcastReceiver ak;
  final DialogInterface.OnDismissListener m = new avic(this);
  private BaseActivity r;
  
  private void b(boolean paramBoolean, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    avig localavig = new avig(this);
    avih localavih = new avih(this);
    String str = paramString2;
    if (paramString1 != null)
    {
      str = paramString2;
      if (paramString1.equalsIgnoreCase(paramString2)) {
        str = aqgv.A(this.app, paramString1);
      }
    }
    if (paramBoolean) {}
    for (paramString1 = getString(2131700522) + str + getString(2131700523) + paramInt + getString(2131700524) + paramString3 + getString(2131700525) + paramString4 + "。";; paramString1 = getString(2131700513) + str + getString(2131700514) + paramInt + getString(2131700515) + paramString3 + getString(2131700516) + paramString4 + "。")
    {
      paramString1 = aqha.a(this, 230, getString(2131700493), paramString1, 2131700540, 2131700541, localavih, localavig);
      paramString1.setOnDismissListener(this.m);
      paramString1.show();
      return;
    }
  }
  
  private void eAm()
  {
    Object localObject = new avid(this);
    localObject = aqha.a(this, 230, getString(2131700493), getString(2131700479), 2131700486, 2131700486, (DialogInterface.OnClickListener)localObject, null);
    ((aqju)localObject).setOnDismissListener(this.m);
    ((aqju)localObject).show();
  }
  
  private void jp(String paramString1, String paramString2)
  {
    paramString1 = aqha.a(this, 230, getString(2131700472), acfp.m(2131711440) + paramString2 + acfp.m(2131711438), 2131700485, 2131700471, new avii(this, paramString1, paramString2), new avij(this));
    paramString1.setOnDismissListener(this.m);
    paramString1.show();
  }
  
  private void o(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    avie localavie = new avie(this);
    avif localavif = new avif(this, paramBoolean1, paramBoolean2);
    if (paramBoolean1) {}
    for (int i = 2131700488;; i = 2131700487)
    {
      paramString = aqha.a(this, 230, getString(2131700493), paramString, 2131700485, i, localavif, localavie);
      paramString.setOnDismissListener(this.m);
      paramString.show();
      return;
    }
  }
  
  public void doOnDestroy()
  {
    if ((this.app != null) && (this.app.getApp() != null) && (this.ak != null)) {
      this.app.getApp().unregisterReceiver(this.ak);
    }
    super.doOnDestroy();
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    this.r = SplashActivity.sTopActivity;
    super.onCreate(paramBundle);
    if (this.app == null)
    {
      QLog.e("QlinkStandardDialogActivity", 2, "onCreate: app=null");
      return;
    }
    setTitle(null);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.qlink.finishdlg");
    if (this.app.getApp() != null)
    {
      this.ak = new avib(this);
      this.app.getApp().registerReceiver(this.ak, paramBundle);
    }
    for (;;)
    {
      switch (getIntent().getIntExtra("str_type", 0))
      {
      default: 
        finish();
        return;
        QLog.e("QlinkStandardDialogActivity", 2, "onCreate: app.getapp()=null");
      }
    }
    o(getIntent().getBooleanExtra("param_send", false), getIntent().getBooleanExtra("_INIT_SEND_IOS_", false), getIntent().getStringExtra("_DLG_CONTENT_"));
    this.app.a().ezZ();
    return;
    b(getIntent().getBooleanExtra("param_send", false), getIntent().getStringExtra("param_uin"), getIntent().getStringExtra("param_nick"), getIntent().getIntExtra("param_transcount", 0), getIntent().getStringExtra("param_jsliuliang"), getIntent().getStringExtra("param_pjspeed"));
    this.app.a().ezZ();
    return;
    eAm();
    return;
    paramBundle = getIntent().getStringExtra("_ADD_UIN_NICK_");
    jp(getIntent().getStringExtra("_ADD_UIN_"), paramBundle);
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qlink.QlinkStandardDialogActivity
 * JD-Core Version:    0.7.0.1
 */