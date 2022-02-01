package com.tencent.mobileqq.activity.history;

import achs;
import aczx;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.TimeZone;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

class ChatHistoryC2CAllFragment$5
  implements Runnable
{
  ChatHistoryC2CAllFragment$5(ChatHistoryC2CAllFragment paramChatHistoryC2CAllFragment, boolean paramBoolean) {}
  
  public void run()
  {
    boolean bool1 = false;
    if (VipUtils.ce(this.this$0.mApp))
    {
      this.this$0.vipType = "svip";
      this.this$0.baf = "2";
      VipUtils.a(this.this$0.mApp, "vip", "0X8004FAB", "0X8004FAB", 0, 0, new String[] { this.this$0.vipType });
    }
    for (;;)
    {
      try
      {
        localObject = this.this$0.mApp.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
        if (1 == ((SharedPreferences)localObject).getInt("setting_guide_tips_flag" + this.this$0.mApp.getCurrentAccountUin(), -1)) {
          continue;
        }
        localEditor = ((SharedPreferences)localObject).edit();
        j = ((SharedPreferences)localObject).getInt("setting_guide_tips_show_time" + this.this$0.mApp.getCurrentAccountUin(), 1);
        if (!this.this$0.baf.equals("2")) {
          continue;
        }
        i = 1;
      }
      catch (Exception localException)
      {
        Object localObject;
        SharedPreferences.Editor localEditor;
        int j;
        boolean bool2;
        QLog.d("Q.history.C2CAllFragment", 2, "settingGuideFlag Exception: " + localException.getMessage());
        continue;
        int i = 0;
        continue;
      }
      if (i != 0) {
        localEditor.putInt("setting_guide_tips_flag" + this.this$0.mApp.getCurrentAccountUin(), 1);
      }
      i = TimeZone.getTimeZone("GMT+8").getRawOffset();
      i = (int)Math.ceil((System.currentTimeMillis() + i) / 86400000L);
      if (j != i) {
        bool1 = true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.C2CAllFragment", 2, "settingGuideFlag isShow: " + bool1 + ", showDay: " + j + ", nowDay: " + i);
      }
      if (bool1)
      {
        localEditor.putInt("setting_guide_tips_show_time" + this.this$0.mApp.getCurrentAccountUin(), i).commit();
        this.this$0.mUIHandler.sendMessage(this.this$0.mUIHandler.obtainMessage(10, this.this$0.mRootView));
      }
      if (this.this$0.b.getAuthMode() == 0)
      {
        localObject = (aczx)this.this$0.mApp.getBusinessHandler(59);
        if (localObject != null) {
          ((aczx)localObject).cPt();
        }
      }
      return;
      if (VipUtils.cf(this.this$0.mApp))
      {
        this.this$0.vipType = "vip";
        this.this$0.baf = "1";
        break;
      }
      this.this$0.vipType = "notvip";
      this.this$0.baf = "0";
      break;
      if (this.this$0.baf.equals("1"))
      {
        if (this.this$0.cdn < 3) {
          continue;
        }
        i = 1;
      }
      else
      {
        bool2 = this.bre;
        if (!bool2) {
          continue;
        }
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment.5
 * JD-Core Version:    0.7.0.1
 */