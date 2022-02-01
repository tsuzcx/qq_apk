package com.tencent.biz.qqstory.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.playvideo.entrance.SingleFeedPlayInfo;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import jsp;
import pso;
import psx;
import puz;
import qea;
import qgg;
import rar;

public class StoryMsgNotificationReceiver
  extends BroadcastReceiver
{
  public static final Intent a(Context paramContext)
  {
    ((pso)psx.a(18)).IH();
    if (QLog.isColorLevel()) {
      QLog.w("Q.qqstory.protocol", 2, "getMainIntent() isNowTabAdded = " + jsp.abw);
    }
    if (jsp.abw)
    {
      paramContext = new Intent(paramContext, SplashActivity.class);
      paramContext.putExtra("fragment_id", 1);
      paramContext.putExtra("tab_index", MainFragment.bIp);
      paramContext.putExtra("open_now_tab_fragment", true);
      paramContext.putExtra("extra_from_share", true);
      paramContext.setFlags(335544320);
      return paramContext;
    }
    paramContext = new Intent(paramContext, QQStoryMainActivity.class);
    paramContext.setFlags(335544320);
    return paramContext;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "MsgNotificationReceiver action: " + (String)localObject);
    }
    if ("com.tencent.biz.qqstory.notification.qqstory_delete_notify".equals(localObject))
    {
      i = paramIntent.getIntExtra("push_type", 0);
      qea.a().T(paramContext, i);
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "delete type = " + i);
      }
    }
    while (!"com.tencent.biz.qqstory.notification.qqstory_jump_activity_notify".equals(localObject)) {
      return;
    }
    localObject = (StoryPushMsg)paramIntent.getParcelableExtra("storyPushMsg");
    if (QLog.isColorLevel()) {
      QLog.w("Q.qqstory.protocol", 2, "onReceive() jumpActivity pushMsg = " + localObject);
    }
    Intent localIntent = a(paramContext);
    int i = ((StoryPushMsg)localObject).type;
    switch (i)
    {
    default: 
      i = 0;
      label310:
      paramIntent = "";
      if ((((StoryPushMsg)localObject).type == 3) || (((StoryPushMsg)localObject).type == 9)) {
        paramIntent = String.valueOf(((StoryPushMsg)localObject).uin);
      }
      if (!TextUtils.isEmpty(((StoryPushMsg)localObject).subType)) {
        break;
      }
    }
    for (localObject = "9999";; localObject = ((StoryPushMsg)localObject).subType)
    {
      rar.a("notice_msg", "clk_push", 0, 0, new String[] { localObject, paramIntent, "", "" });
      if ((i != 0) || (localIntent == null)) {
        break;
      }
      localIntent.addFlags(268435456);
      paramContext.startActivity(localIntent);
      return;
      localIntent.putExtra("action", 8);
      localIntent.putExtra("pushType", i);
      localIntent.putExtra("extra_feedid", ((StoryPushMsg)localObject).mFeedId);
      rar.a("notice_msg", "clk_notice", 0, 0, new String[] { "", "", "", "" });
      i = 0;
      break label310;
      if (((puz)QQStoryContext.a().getManager(252)).aBT)
      {
        qgg.r(paramContext, ((StoryPushMsg)localObject).mFeedId, ((StoryPushMsg)localObject).mVid);
        rar.a("notice_msg", "care_android", 0, 0, new String[] { "", "", "", "" });
        i = 1;
        break label310;
      }
      localIntent.putExtra("EXTRA_PLAY_INFO", new SingleFeedPlayInfo(((StoryPushMsg)localObject).mFeedId, ((StoryPushMsg)localObject).mFeedId, ((StoryPushMsg)localObject).mVid, 1, true));
      localIntent.putExtra("action", 9);
      rar.a("notice_msg", "care_android", 0, 0, new String[] { "", "", "", "" });
      i = 0;
      break label310;
      i = 0;
      break label310;
      localIntent.putExtra("action", 4);
      localIntent.putExtra("extra_topic_id", ((StoryPushMsg)localObject).I.getLong("hot_topic_id"));
      localIntent.putExtra("extra_topic_name", ((StoryPushMsg)localObject).I.getString("hot_topic_name"));
      localIntent.putExtra("extra_share_from_type", 31);
      i = 0;
      break label310;
      localIntent.putExtra("action", 1);
      i = 0;
      break label310;
      localIntent.putExtra("action", 7);
      localIntent.putExtra("EXTRA_USER_UIN", ((StoryPushMsg)localObject).I.getString("big_v_id"));
      localIntent.putExtra("EXTRA_USER_UNION_ID", ((StoryPushMsg)localObject).I.getString("big_v_union_id"));
      localIntent.putExtra("extra_share_from_type", 31);
      i = 0;
      break label310;
      localIntent.putExtra("action", 6);
      localIntent.putExtra("user_type", ((StoryPushMsg)localObject).I.getInt("pgc_type"));
      localIntent.putExtra("user_unionid", ((StoryPushMsg)localObject).I.getString("pgc_column_union_id"));
      localIntent.putExtra("come_from", 29);
      i = 0;
      break label310;
      localIntent.putExtra("action", 10);
      localIntent.putExtra("url", ((StoryPushMsg)localObject).I.getString("link"));
      localIntent.putExtra("webStyle", "noBottomBar");
      i = 0;
      break label310;
      paramIntent = new StringBuilder("https://story.now.qq.com/m/vote/index.html?_wv=3&_nav_alpha=0");
      paramIntent.append("&vid=").append(((StoryPushMsg)localObject).mVid);
      localIntent.putExtra("action", 10);
      localIntent.putExtra("url", paramIntent.toString());
      localIntent.putExtra("webStyle", "noBottomBar");
      i = 0;
      break label310;
      paramIntent = new StringBuilder("https://story.now.qq.com/m/score/index.html?_wv=3&_nav_alpha=0");
      paramIntent.append("&vid=").append(((StoryPushMsg)localObject).mVid);
      localIntent.putExtra("action", 10);
      localIntent.putExtra("url", paramIntent.toString());
      localIntent.putExtra("webStyle", "noBottomBar");
      i = 0;
      break label310;
      qgg.c(paramContext, ((StoryPushMsg)localObject).mVid, ((StoryPushMsg)localObject).mFeedId, 29);
      i = 1;
      break label310;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.notification.StoryMsgNotificationReceiver
 * JD-Core Version:    0.7.0.1
 */