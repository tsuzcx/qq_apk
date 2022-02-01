import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.ConversationTitleBtnCtrl.1;
import com.tencent.mobileqq.activity.ConversationTitleBtnCtrl.2;
import com.tencent.mobileqq.activity.ConversationTitleBtnCtrl.4;
import com.tencent.mobileqq.activity.ConversationTitleBtnCtrl.5;
import com.tencent.mobileqq.activity.ConversationTitleBtnCtrl.6;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatMatchFragment;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import common.config.service.QzoneConfig.a;
import mqq.os.MqqHandler;

public class utt
  implements View.OnClickListener, QzoneConfig.a
{
  private static long lastClickTime;
  private TextView CU;
  private Conversation a;
  private volatile boolean aVx;
  private volatile boolean aVy;
  private RedTouch l;
  private Activity mActivity;
  private int mEntranceType;
  private Handler mUiHandler;
  public ImageView pO;
  private View sl;
  private View sm;
  
  private void bMP()
  {
    if (this.mEntranceType == 2)
    {
      if ((this.sl == null) || (this.pO != null)) {
        this.pO.setVisibility(8);
      }
      if (this.l != null) {
        this.l.setVisibility(8);
      }
    }
    do
    {
      return;
      if (this.l != null) {
        this.l.setVisibility(0);
      }
      if (this.pO != null)
      {
        this.pO.setVisibility(8);
        IphoneTitleBarActivity.setLayerType(this.pO);
        bMR();
      }
      if (this.sl != null) {
        this.sl.setVisibility(8);
      }
    } while (this.CU == null);
    this.CU.setVisibility(8);
  }
  
  private void bMQ()
  {
    QLog.d("ConversationTitleBtnCtrl", 1, "hideAllEntrances");
    if (this.sl != null) {
      this.sl.setVisibility(8);
    }
    if (this.CU != null) {
      this.CU.setVisibility(8);
    }
    if (this.pO != null) {
      this.pO.setVisibility(8);
    }
    if (this.l != null) {
      this.l.setVisibility(8);
    }
  }
  
  private void bMS()
  {
    if ((this.mEntranceType != 0) && (this.mEntranceType != 2))
    {
      this.mEntranceType = 0;
      if (this.pO != null)
      {
        this.pO.setImageResource(2130851763);
        this.pO.setContentDescription(this.mActivity.getString(2131692222));
      }
    }
  }
  
  public void bMR()
  {
    boolean bool = afwy.av(this.a.app);
    if (QLog.isDevelopLevel()) {
      QLog.d("ConversationTitleBtnCtrl", 4, "switchType isMatchChatMode =" + bool);
    }
    if (bool)
    {
      this.pO.setImageResource(2130851765);
      this.pO.setContentDescription(this.mActivity.getString(2131692221));
      this.mEntranceType = 1;
      return;
    }
    bMS();
  }
  
  public void bMT()
  {
    QLog.d("ConversationTitleBtnCtrl", 1, "onAfterSyncMsg " + this.mEntranceType);
    if (this.mEntranceType == 2) {
      ThreadManager.post(new ConversationTitleBtnCtrl.6(this), 1, null, false);
    }
  }
  
  public void bMe()
  {
    bMS();
    if ((this.l != null) && (aekx.a().cNI == 1) && (Build.VERSION.SDK_INT >= 21) && (this.mEntranceType == 0))
    {
      this.l.dGB();
      this.pO.setVisibility(8);
    }
    bMQ();
  }
  
  public void bMt()
  {
    this.sl = this.a.findViewById(2131365436);
    this.sm = this.sl.findViewById(2131375027);
    this.CU = ((TextView)this.a.findViewById(2131365437));
    this.pO = ((ImageView)this.a.findViewById(2131365435));
    this.l = new RedTouch(this.a.a(), this.pO).a();
    this.sl.setOnClickListener(this);
    this.pO.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.pO.setVisibility(8);
    this.sl.setVisibility(8);
    this.sm.setVisibility(8);
    this.l.setVisibility(8);
  }
  
  public void bcH()
  {
    bMR();
  }
  
  public void eC(View paramView)
  {
    axgk.a().eJx();
    axgk.a().acy("userClick");
    if (Build.VERSION.SDK_INT >= 23) {}
    for (boolean bool = aczy.bd(this.a.a());; bool = true)
    {
      if (!bool)
      {
        this.a.a().requestPermissions(new utu(this, paramView), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
        return;
      }
      eD(paramView);
      return;
    }
  }
  
  public void eD(View paramView)
  {
    Object localObject1 = "mqqapi://videostory/takevideo?src_type=internal&version=1&from=mainCamera&uin=&appid=406&widgetid=&shareto=1";
    if (paramView == this.l)
    {
      localObject2 = (altq)this.a.app.getManager(36);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((altq)localObject2).a(6, "120000");
      localObject1 = ayja.cB(localAppInfo.buffer.get(), "mqqapi://videostory/takevideo?src_type=internal&version=1&from=mainCamera&uin=&appid=406&widgetid=&shareto=1");
      ((altq)localObject2).d(localAppInfo, null);
    }
    Object localObject2 = localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = localObject1;
      if (!((String)localObject1).contains("cmode"))
      {
        if (!((String)localObject1).contains("?")) {
          break label223;
        }
        localObject2 = "&";
        localObject2 = ((String)localObject1).concat((String)localObject2 + "cmode" + "=" + "all");
      }
    }
    localObject1 = new Intent();
    ((Intent)localObject1).setData(Uri.parse((String)localObject2));
    this.a.a().startActivity((Intent)localObject1);
    ThreadManager.getUIHandler().postDelayed(new ConversationTitleBtnCtrl.4(this), 500L);
    if (paramView != this.l) {}
    for (paramView = "1";; paramView = "3")
    {
      anot.a(null, "dc00898", "", "", "0X800A2D5", "0X800A2D5", 0, 0, paramView, "", "", "");
      return;
      label223:
      localObject2 = "?";
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    long l1 = System.currentTimeMillis();
    if (l1 - lastClickTime < 500L) {
      lastClickTime = l1;
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      lastClickTime = l1;
      if (QLog.isDevelopLevel()) {
        QLog.d("ConversationTitleBtnCtrl", 4, "userClick time=" + System.currentTimeMillis());
      }
      if (this.mEntranceType == 0)
      {
        eC(paramView);
      }
      else
      {
        Intent localIntent;
        if (this.mEntranceType == 1)
        {
          localIntent = new Intent();
          localIntent.putExtra("ExtendFriendLimitChatFromeType", 1);
          PublicFragmentActivity.start(this.a.a(), localIntent, ExtendFriendLimitChatMatchFragment.class);
        }
        else if (this.mEntranceType == 2)
        {
          localIntent = new Intent();
          localIntent.putExtra("key_enable_splash", true);
          localIntent.putExtra("key_jump_from", "4");
          oux.u(this.a.a(), localIntent);
          ThreadManager.post(new ConversationTitleBtnCtrl.2(this), 5, null, false);
          if (this.aVy) {
            pco.b("", 2, 2L, 1L);
          } else {
            pco.b("", 2, 2L, 3L);
          }
        }
      }
    }
  }
  
  public void onConfigChange()
  {
    QLog.d("ConversationTitleBtnCtrl", 1, "onConfigChange");
    this.mUiHandler.post(new ConversationTitleBtnCtrl.5(this));
  }
  
  public void onPause()
  {
    this.aVx = true;
  }
  
  public void wW(boolean paramBoolean)
  {
    QLog.d("ConversationTitleBtnCtrl", 1, "updateQQCircle " + paramBoolean);
    if (QzoneConfig.isQQCircleShowMessageEntrance()) {}
    for (this.mEntranceType = 2;; this.mEntranceType = 0)
    {
      bMP();
      wX(paramBoolean);
      return;
    }
  }
  
  public void wX(boolean paramBoolean)
  {
    int i = 2;
    if (this.mEntranceType != 2) {
      return;
    }
    if (paramBoolean) {}
    for (;;)
    {
      ThreadManager.post(new ConversationTitleBtnCtrl.1(this), i, null, false);
      return;
      i = 5;
    }
  }
  
  public void wY(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     utt
 * JD-Core Version:    0.7.0.1
 */