package com.tencent.mobileqq.app.readinjoy;

import ackq;
import aevk;
import aevs;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import awit;
import awiz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kbp;
import kxm;
import lbz;
import ljc;
import ocp;
import zjq;

class ReadInJoyManager$NotifyReceiver$1
  implements Runnable
{
  ReadInJoyManager$NotifyReceiver$1(ReadInJoyManager.NotifyReceiver paramNotifyReceiver, Intent paramIntent) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(ReadInJoyManager.TAG, 2, String.format("receive %s", new Object[] { this.val$intent.getAction() }));
    }
    long l1;
    if (this.val$intent.getAction().equalsIgnoreCase("notify_main_feeds_msg_newfeeds_read"))
    {
      if (ReadInJoyManager.a(this.b.this$0) == null) {
        return;
      }
      l1 = ReadInJoyManager.a(this.b.this$0).getLong("config_feeds_newfeeds_leba_max_id", 0L);
      localObject1 = ReadInJoyManager.a(this.b.this$0).edit();
      ((SharedPreferences.Editor)localObject1).putLong("config_feeds_newfeeds_leba_read_id", l1);
      awit.a((SharedPreferences.Editor)localObject1, true);
      ReadInJoyManager.a(this.b.this$0);
    }
    label232:
    Object localObject2;
    label292:
    int i;
    int j;
    label1070:
    do
    {
      do
      {
        for (;;)
        {
          localObject1 = new Intent("notify_main_feeds_msg_response");
          BaseApplication.getContext().sendBroadcast((Intent)localObject1);
          return;
          if (this.val$intent.getAction().equals("notify_main_feeds_msg_newcomment_read"))
          {
            l1 = this.val$intent.getExtras().getLong("read_id");
            if (ReadInJoyManager.a(this.b.this$0) == null) {
              break;
            }
            long l2 = ReadInJoyManager.a(this.b.this$0).getLong("config_feeds_newcomment_leba_max_id", 0L);
            long l3 = ReadInJoyManager.a(this.b.this$0).getLong("config_feeds_newcomment_leba_read_id", 0L);
            if (l1 >= l3) {
              if (l2 <= l1) {
                break label292;
              }
            }
            for (;;)
            {
              localObject1 = ReadInJoyManager.a(this.b.this$0).edit();
              ((SharedPreferences.Editor)localObject1).putLong("config_feeds_newcomment_leba_read_id", l1);
              awit.a((SharedPreferences.Editor)localObject1, true);
              ReadInJoyManager.a(this.b.this$0);
              break;
              l1 = l3;
              break label232;
              l1 = l2;
            }
          }
          if (this.val$intent.getAction().equals("notify_main_feeds_msg_publish_fail"))
          {
            localObject1 = new awiz();
            ((awiz)localObject1).avA = 999999;
            ((awiz)localObject1).aBf = this.val$intent.getExtras().getLong("feed_owner");
            ((awiz)localObject1).eBn = this.val$intent.getExtras().getInt("fail_reason");
            localObject2 = new ArrayList();
            ((List)localObject2).add(localObject1);
            this.b.this$0.ju((List)localObject2);
          }
          else
          {
            if (this.val$intent.getAction().equals("notify_main_feeds_msg_republish"))
            {
              if (ReadInJoyManager.a(this.b.this$0) == null) {
                break;
              }
              l1 = ReadInJoyManager.a(this.b.this$0).getLong("config_feeds_publishfail_leba_max_id", 0L);
              localObject1 = ReadInJoyManager.a(this.b.this$0).edit();
              ((SharedPreferences.Editor)localObject1).putLong("config_feeds_publishfail_leba_read_id", l1);
              awit.a((SharedPreferences.Editor)localObject1, true);
              ReadInJoyManager.a(this.b.this$0);
              continue;
            }
            if (this.val$intent.getAction().equals("notify_main_new_channel_clear"))
            {
              if (ReadInJoyManager.a(this.b.this$0) == null) {
                break;
              }
              localObject1 = ReadInJoyManager.a(this.b.this$0).edit();
              ((SharedPreferences.Editor)localObject1).putInt("config_new_channel_notify_flag", -1);
              awit.a((SharedPreferences.Editor)localObject1, true);
              ReadInJoyManager.b(this.b.this$0);
              continue;
            }
            if (this.val$intent.getAction().equals("notify_main_guide_clear"))
            {
              if (ReadInJoyManager.a(this.b.this$0) == null) {
                break;
              }
              localObject1 = ReadInJoyManager.a(this.b.this$0).edit();
              ((SharedPreferences.Editor)localObject1).putInt("config_notify_guide_flag", -1);
              ((SharedPreferences.Editor)localObject1).putLong("config_notify_guide_updated_time", NetConnInfoCenter.getServerTime());
              ((SharedPreferences.Editor)localObject1).putInt("readinjoy_push_channel_article_flag", -1);
              ((SharedPreferences.Editor)localObject1).putLong("readinjoy_push_channel_article_updated_time", NetConnInfoCenter.getServerTime());
              awit.a((SharedPreferences.Editor)localObject1, true);
              ReadInJoyManager.b(this.b.this$0);
              continue;
            }
            if (this.val$intent.getAction().equals("config_local_channel_flag"))
            {
              aevk.aa(ReadInJoyManager.a(this.b.this$0), ReadInJoyManager.a(this.b.this$0).getCurrentAccountUin());
            }
            else if (this.val$intent.getAction().equals("config_follow_uin"))
            {
              i = this.val$intent.getIntExtra("follow_uin_position", -1);
              j = this.val$intent.getIntExtra("follow_uin_smooth_dx", 0);
              localObject1 = this.val$intent.getStringExtra("follow_uin");
              if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                lbz.a().a().a(ReadInJoyManager.a(this.b.this$0).getAccount(), (String)localObject1, true, new ReadInJoyManager.a(i, j, (String)localObject1));
              }
            }
            else if (this.val$intent.getAction().equals("config_update_app_setting"))
            {
              localObject1 = awit.a(ReadInJoyManager.a(this.b.this$0));
              if ((localObject1 != null) && (((aevs)localObject1).bo != 0))
              {
                ((aevs)localObject1).bo = 0;
                zjq.a().a(ReadInJoyManager.a(this.b.this$0), ((aevs)localObject1).a.uiResId, true, NetConnInfoCenter.getServerTimeMillis(), -9223372036854775808L);
                localObject2 = (ackq)ReadInJoyManager.a(this.b.this$0).getBusinessHandler(31);
                if (localObject2 != null)
                {
                  ((ackq)localObject2).f(String.valueOf(((aevs)localObject1).a.uiResId), true, NetConnInfoCenter.getServerTimeMillis());
                  ((ackq)localObject2).notifyUI(1, true, null);
                }
              }
            }
            else if (this.val$intent.getAction().equals("readInJoy_video_play_real_time_report"))
            {
              localObject1 = this.val$intent.getExtras();
              if (localObject1 != null) {
                ocp.f(((Bundle)localObject1).getString("VIDEO_REALTIME_REPORT_AID"), ((Bundle)localObject1).getString("VIDEO_REALTIME_REPORT_VID"), ((Bundle)localObject1).getInt("VIDEO_REALTIME_REPORT_RTYPE"), ((Bundle)localObject1).getInt("VIDEO_REALTIME_REPORT_RCODE"));
              }
            }
            else
            {
              if (!this.val$intent.getAction().equals("notify_main_share_friend_video")) {
                break label1070;
              }
              ForwardUtils.a((QQAppInterface)kxm.getAppRuntime(), null, ReadInJoyManager.a(this.b.this$0).getApp(), this.val$intent, null);
            }
          }
        }
      } while (!this.val$intent.getAction().equals("READINJOY_VIDEO_DATA_REPORT_WITH_FANS_INFO"));
      localObject2 = this.val$intent.getExtras();
    } while (localObject2 == null);
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface)) {}
    for (localObject1 = (QQAppInterface)localObject1;; localObject1 = null)
    {
      String str1 = ((Bundle)localObject2).getString("VIDEO_REPORT_TOUIN");
      String str2 = ((Bundle)localObject2).getString("VIDEO_REPORT_SUBACTION");
      i = ((Bundle)localObject2).getInt("VIDEO_REPORT_FROM_TYPE");
      j = ((Bundle)localObject2).getInt("VIDEO_REPORT_RESULT");
      kbp.c((QQAppInterface)localObject1, str1, str2, ((Bundle)localObject2).getString("VIDEO_REPORT_ACTION_NAME"), i, j, ((Bundle)localObject2).getString("VIDEO_REPORT_R2"), ((Bundle)localObject2).getString("VIDEO_REPORT_R3"), ((Bundle)localObject2).getString("VIDEO_REPORT_R4"), ((Bundle)localObject2).getString("VIDEO_REPORT_R5"), ((Bundle)localObject2).getBoolean("VIDEO_REPORT_SHOULD_ENCODE"));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.readinjoy.ReadInJoyManager.NotifyReceiver.1
 * JD-Core Version:    0.7.0.1
 */