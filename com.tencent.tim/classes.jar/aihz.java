import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.activity.miniaio.MiniMsgIPCClient;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser.IMiniMsgActionCallback;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aihz
  implements View.OnClickListener
{
  private View CP;
  MiniMsgUserParam a;
  wiy b = wiy.a();
  private String bIV;
  private String bNN;
  private WindowManager.LayoutParams e;
  private Activity mActivity;
  private WindowManager mWindowManager;
  
  public aihz(Activity paramActivity, String paramString1, String paramString2, MiniMsgUserParam paramMiniMsgUserParam)
  {
    this.mActivity = paramActivity;
    this.bIV = paramString1;
    this.a = paramMiniMsgUserParam;
    this.bNN = paramString2;
  }
  
  public void destroy() {}
  
  public void onBackground()
  {
    if (this.a != null)
    {
      if ((this.a.accessType == 0) && (this.a.entryType == 0))
      {
        zns localzns = MiniMsgIPCClient.getInstance().getBusinessInfo(this.a.businessName);
        if (localzns != null)
        {
          int[] arrayOfInt = ((znq)this.a.unreadCallback).L();
          if (arrayOfInt != null)
          {
            localzns.positionX = arrayOfInt[0];
            localzns.positionY = arrayOfInt[1];
          }
        }
      }
      MiniMsgIPCClient.getInstance();
      MiniMsgIPCClient.onProcessBackground(this.a.businessName);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.a == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.actionCallback != null) {
        this.a.actionCallback.onOpenMiniAIOCallback();
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("key_mini_need_update_unread", true);
      localIntent.putExtra("key_mini_msgtab_businame", this.a.businessName);
      localIntent.putExtra("key_mini_msgtab_type", this.a.filterMsgType);
      localIntent.putExtra("key_mini_msgtab_need_full_screen", this.a.isNeedFullScreen);
      localIntent.putExtra("key_mini_msgtab_isneed_back_conversation", this.a.isNeedBackConversation);
      if (this.a.isNeedBackConversation) {
        localIntent.putExtra("key_mini_msgtab_back_pending_intent", this.a.backConversationIntent);
      }
      MiniChatActivity.a(this.mActivity, 1, this.bIV, this.bNN);
    }
  }
  
  public void onForeground()
  {
    if (this.a != null)
    {
      MiniMsgIPCClient.getInstance();
      MiniMsgIPCClient.register(this.a.businessName, BaseApplicationImpl.getApplication().getQQProcessName());
      MiniMsgIPCClient.getInstance().syncGetUnread();
      MiniMsgIPCClient.getInstance();
      MiniMsgIPCClient.onProcessForeGround(this.a.businessName);
    }
  }
  
  public void showEntry()
  {
    if (this.CP == null)
    {
      this.CP = View.inflate(this.mActivity.getApplicationContext(), 2131563333, null);
      this.CP.setOnClickListener(this);
      String str = apqw.p("", this.bIV, 0);
      aoiz.getFile(str);
      Object localObject2 = (RelativeLayout)this.CP.findViewById(2131371721);
      URLImageView localURLImageView = (URLImageView)this.CP.findViewById(2131371722);
      Object localObject1 = (TextView)this.CP.findViewById(2131371723);
      localObject2 = (RelativeLayout.LayoutParams)((RelativeLayout)localObject2).getLayoutParams();
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localURLImageView.getLayoutParams();
      localObject1 = (RelativeLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
      int i = aqnm.dpToPx(32.0F);
      int j = aqnm.dpToPx(28.0F);
      ((RelativeLayout.LayoutParams)localObject2).width = i;
      ((RelativeLayout.LayoutParams)localObject2).height = j;
      i = aqnm.dpToPx(24.0F);
      localLayoutParams.width = i;
      localLayoutParams.height = i;
      localLayoutParams.leftMargin = aqnm.dpToPx(4.0F);
      localURLImageView.setPadding(0, 0, 0, 0);
      localURLImageView.setBackgroundDrawable(null);
      localURLImageView.setImageDrawable(URLDrawable.getDrawable(str, null));
      if (AppSetting.enableTalkBack) {
        aqcl.R(this.CP, false);
      }
      this.mWindowManager = ((WindowManager)this.mActivity.getApplicationContext().getSystemService("window"));
      this.e = new WindowManager.LayoutParams();
      if (QLog.isColorLevel()) {
        QLog.d("WatchTogetherMiniAioHelper", 0, "is activity window focused " + this.mActivity.hasWindowFocus());
      }
      i = this.a.positionX;
      j = this.a.positionY;
      this.e.type = 1002;
      this.e.format = 1;
      this.e.flags = 40;
      this.e.gravity = 51;
      this.e.x = i;
      this.e.y = j;
      this.e.width = -2;
      this.e.height = -2;
      this.e.token = this.mActivity.getWindow().getDecorView().getWindowToken();
      this.mWindowManager.addView(this.CP, this.e);
    }
    this.CP.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aihz
 * JD-Core Version:    0.7.0.1
 */