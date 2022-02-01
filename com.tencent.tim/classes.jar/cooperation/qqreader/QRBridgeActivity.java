package cooperation.qqreader;

import acff;
import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import anot;
import avda;
import avlw;
import avlz;
import avmd;
import avme;
import avmg;
import avmi;
import avmj;
import avoc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class QRBridgeActivity
  extends Activity
{
  public static String cMc = "-1";
  public static boolean dnn;
  public static boolean dno;
  private QQAppInterface app = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
  private Bundle bL;
  
  private void initPlugin()
  {
    boolean bool = avlz.a().EU();
    if (!bool) {
      avmj.o(2, this.app);
    }
    this.bL.putBoolean("auto_launch", bool);
    eAE();
    avlz.a().go(this);
  }
  
  public int PD()
  {
    int i = (int)(Math.random() * 100.0D) + 1;
    if (i <= 30) {
      return 0;
    }
    if (i <= 60) {
      return 1;
    }
    return 2;
  }
  
  public void eAE()
  {
    int i;
    Object localObject;
    if (avmi.bB(this) == -1)
    {
      i = -1;
      localObject = ((acff)this.app.getManager(51)).b(this.app.getCurrentAccountUin());
      if (localObject != null) {
        i = ((Card)localObject).shGender;
      }
      if ((i == 0) || (i == 1)) {
        break label177;
      }
      i = PD();
      avoc.d("QRBridgeActivity", "set prefer by random " + i);
      anot.a(this.app, "P_CliOper", "VIP_QQREADER", "", "0X8005877", "0X8005877", 0, 0, "" + i, "", "", "");
    }
    for (;;)
    {
      avmi.ba(this, i);
      localObject = this.app.getHandler(Conversation.class);
      if (localObject != null)
      {
        ((MqqHandler)localObject).sendMessageDelayed(((MqqHandler)localObject).obtainMessage(1134028), 1000L);
        ((MqqHandler)localObject).sendMessageDelayed(((MqqHandler)localObject).obtainMessage(1134040), 1000L);
      }
      avda.n(null);
      return;
      label177:
      avoc.d("QRBridgeActivity", "set prefer by gender " + i);
      anot.a(this.app, "P_CliOper", "VIP_QQREADER", "", "0X8005876", "0X8005876", 0, 0, "" + i, "", "", "");
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    avoc.d("QRBridgeActivity", "QRBridgeActivity onCreate");
    if (Build.VERSION.SDK_INT < 26) {
      setRequestedOrientation(1);
    }
    QRBridgeUtil.preloadPSkey(this.app, this.app.getCurrentUin(), "books.qq.com");
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
    getWindow().setBackgroundDrawableResource(2131167595);
    long l1 = System.currentTimeMillis();
    long l2 = getIntent().getLongExtra("click_start_time", 0L);
    avoc.u("cost_time_tag", "QRBridgeActivity :clickToOnCreate =" + (l1 - l2));
    this.bL = getIntent().getExtras();
    if (this.bL == null) {
      this.bL = new Bundle();
    }
    if (!this.app.isLogin())
    {
      avoc.e("QRBridgeActivity", "app is not login");
      finish();
      return;
    }
    setContentView(new FrameLayout(this), new FrameLayout.LayoutParams(-1, -1));
    paramBundle = (avmd)this.app.getManager(129);
    paramBundle.bE(this.app.getCurrentUin(), System.currentTimeMillis());
    paramBundle.eAM();
    initPlugin();
    paramBundle = new Intent();
    paramBundle.putExtra("key_click_leba_start_time", l2);
    paramBundle.putExtra("key_enter_qr_bridge_activity_oncreate_time", l1);
    paramBundle.putExtras(this.bL);
    paramBundle = avlw.a(this, paramBundle, BaseApplicationImpl.getApplication().getRuntime().getAccount());
    PluginCommunicationHandler.getInstance().register(new avmg());
    PluginCommunicationHandler.getInstance().register(new avme());
    paramBundle.putExtra("startOpenPageTime", l2);
    paramBundle.putExtra("is_follow_publicaccount", avmi.B(this.app));
    if (!paramBundle.hasExtra("big_brother_source_key")) {
      paramBundle.putExtra("big_brother_source_key", "biz_src_jc_neirong");
    }
    if (paramBundle.hasExtra("ChannelID")) {
      cMc = paramBundle.getStringExtra("ChannelID");
    }
    paramBundle.putExtra("key_qr_bridge_activity_start_activity_time", System.currentTimeMillis());
    startActivity(paramBundle);
    finish();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    avoc.d("QRBridgeActivity", "QRBridgeActivity onDestroy");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqreader.QRBridgeActivity
 * JD-Core Version:    0.7.0.1
 */