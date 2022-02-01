import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.ecshopassit.EcShopData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.os.MqqHandler;

class kdn
  extends BroadcastReceiver
{
  kdn(kdm paramkdm) {}
  
  public void onReceive(Context arg1, Intent paramIntent)
  {
    if ((paramIntent == null) || (this.this$0.mApp == null)) {}
    for (;;)
    {
      return;
      ??? = paramIntent.getAction();
      Object localObject;
      if ("action_get_PA_head".equals(???))
      {
        ??? = paramIntent.getStringExtra("uin");
        if ((TextUtils.isEmpty(???)) || (this.this$0.a == null)) {
          continue;
        }
        paramIntent = this.this$0.a.b(1, ???);
        if (paramIntent != null)
        {
          localObject = new Intent("action_decode_finish");
          ((Intent)localObject).putExtra("bitmap", paramIntent);
          ((Intent)localObject).putExtra("uin", ???);
          BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject);
          return;
        }
        this.this$0.a.i(???, 1, true);
        return;
      }
      int i;
      boolean bool;
      long l;
      if ("action_shop_set_read".equals(???))
      {
        localObject = paramIntent.getStringExtra("uin");
        i = paramIntent.getIntExtra("unReadNum", 0);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          continue;
        }
        bool = paramIntent.getBooleanExtra("needDelete", false);
        synchronized (kdm.a(this.this$0))
        {
          paramIntent = (EcShopData)kdm.a(this.this$0).get(localObject);
          if (paramIntent == null) {
            continue;
          }
          ??? = null;
          paramIntent = this.this$0.mApp.b();
          if (paramIntent != null) {
            ??? = paramIntent.a((String)localObject, 1008);
          }
          if (??? != null)
          {
            aalb.l(this.this$0.mApp, (String)localObject, 1008);
            paramIntent = this.this$0.mApp.a();
            if (paramIntent != null) {
              paramIntent.h(???.frienduin, ???.istroop, true);
            }
          }
          if (!bool) {
            continue;
          }
          this.this$0.lU((String)localObject);
          if (((String)localObject).equals(kdm.Yr))
          {
            l = kdm.h().getLong("ad_id", 0L);
            ((kec)this.this$0.mApp.getBusinessHandler(88)).a(134246438, null, null, null, null, l, false);
            ??? = kdm.h().edit();
            ???.remove("ad_id");
            ???.putBoolean("is_ad_added", false);
            ???.commit();
            kdm.Yr = "";
            return;
          }
        }
        anot.a(null, "dc00899", "Pb_account_lifeservice", (String)localObject, "0X80064D2", "0X80064D2", 0, 0, "" + i, "", "", "");
        return;
      }
      if ("action_folder_set_read".equals(???))
      {
        ??? = paramIntent.getStringExtra("uin");
        if (!TextUtils.isEmpty(???))
        {
          ??? = this.this$0.mApp.b().a(???, 1008);
          if (??? != null) {
            this.this$0.eh(???.time);
          }
        }
        ??? = kdm.h();
        this.this$0.aeq = false;
        if (???.getBoolean("folder_reddot", false)) {
          ???.edit().putBoolean("folder_reddot", false).commit();
        }
        ??? = this.this$0.mApp.getHandler(Conversation.class);
        if (??? == null) {
          continue;
        }
        ???.sendEmptyMessage(1009);
        return;
      }
      if ("action_folder_destroy".equals(???))
      {
        if (paramIntent.getLongExtra("stay_time", 0L) >= this.this$0.rM) {
          kdm.h().edit().putLong("last_stay_folder", System.currentTimeMillis());
        }
        this.this$0.aer = false;
        return;
      }
      if ("action_folder_msg_change".equals(???))
      {
        ??? = paramIntent.getStringExtra("msg");
        i = paramIntent.getIntExtra("type", -1);
        paramIntent = this.this$0.a();
        if ((TextUtils.isEmpty(???)) || (paramIntent == null)) {
          continue;
        }
        paramIntent = kdm.h().edit();
        paramIntent.putString("str_ecshop_diy", ???);
        paramIntent.putInt("last_show_time1", (int)(System.currentTimeMillis() / 1000L));
        paramIntent.putInt("FOLDER_MSG_TYPE", i);
        paramIntent.putString("PUSH_JUMP_URL", "");
        paramIntent.commit();
        return;
      }
      if ("action_set_folder_tab_red".equals(???))
      {
        kdm.h().edit().putBoolean("folder_tab_red", true).commit();
        return;
      }
      if (!"action_follow_status".equals(???)) {
        continue;
      }
      ??? = paramIntent.getStringExtra("puin");
      if (TextUtils.isEmpty(???)) {
        continue;
      }
      try
      {
        l = Long.parseLong(???);
        if (l == -1L) {
          continue;
        }
        bool = ((acja)this.this$0.mApp.getManager(56)).f(Long.valueOf(l));
        paramIntent = new Intent("action_follow_status_finish");
        paramIntent.putExtra("isFollow", bool);
        paramIntent.putExtra("uin", String.valueOf(l));
        BaseApplicationImpl.getContext().sendBroadcast(paramIntent);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("EcShopAssistantManager", 2, "follow_status uin:" + ??? + ",isfollow:" + bool);
        return;
      }
      catch (Exception paramIntent)
      {
        for (;;)
        {
          l = -1L;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kdn
 * JD-Core Version:    0.7.0.1
 */