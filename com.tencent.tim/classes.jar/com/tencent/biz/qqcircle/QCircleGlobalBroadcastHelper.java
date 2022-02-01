package com.tencent.biz.qqcircle;

import altq;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.events.QCircleFollowUpdateEvent;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import pbu;
import pbz;
import rwv;

public class QCircleGlobalBroadcastHelper
{
  private static final String TAG = QCircleGlobalBroadcastHelper.class.getSimpleName();
  private static volatile QCircleGlobalBroadcastHelper jdField_a_of_type_ComTencentBizQqcircleQCircleGlobalBroadcastHelper;
  private final QCircleGlobalBroadcastReceiver jdField_a_of_type_ComTencentBizQqcircleQCircleGlobalBroadcastHelper$QCircleGlobalBroadcastReceiver = new QCircleGlobalBroadcastReceiver();
  
  public static QCircleGlobalBroadcastHelper a()
  {
    if (jdField_a_of_type_ComTencentBizQqcircleQCircleGlobalBroadcastHelper == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentBizQqcircleQCircleGlobalBroadcastHelper == null) {
        jdField_a_of_type_ComTencentBizQqcircleQCircleGlobalBroadcastHelper = new QCircleGlobalBroadcastHelper();
      }
      return jdField_a_of_type_ComTencentBizQqcircleQCircleGlobalBroadcastHelper;
    }
    finally {}
  }
  
  private static AppInterface getAppInterface()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      if ((localObject instanceof AppInterface)) {
        return (AppInterface)localObject;
      }
    }
    return null;
  }
  
  public void bhH()
  {
    altq localaltq = (altq)BaseApplicationImpl.getApplication().getRuntime().getManager(36);
    localaltq.a(localaltq.getAppInfoByPath("140000"), 9, "");
    ThreadManager.getSubThreadHandler().postDelayed(new QCircleGlobalBroadcastHelper.1(this), 1000L);
  }
  
  public void init()
  {
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("action_clear_message_red_poiont");
      localIntentFilter.addAction("action_update_native_user_follow_state");
      localIntentFilter.addAction("action_update_native_tag_follow_state");
      localIntentFilter.addAction("action_receive_message_push");
      BaseApplicationImpl.getApplication().registerReceiver(this.jdField_a_of_type_ComTencentBizQqcircleQCircleGlobalBroadcastHelper$QCircleGlobalBroadcastReceiver, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void release()
  {
    try
    {
      BaseApplicationImpl.getApplication().unregisterReceiver(this.jdField_a_of_type_ComTencentBizQqcircleQCircleGlobalBroadcastHelper$QCircleGlobalBroadcastReceiver);
      jdField_a_of_type_ComTencentBizQqcircleQCircleGlobalBroadcastHelper = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public class QCircleGlobalBroadcastReceiver
    extends BroadcastReceiver
  {
    public QCircleGlobalBroadcastReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      boolean bool2 = true;
      boolean bool1 = true;
      paramContext = paramIntent.getAction();
      QLog.d(QCircleGlobalBroadcastHelper.TAG, 1, "onReceive action" + paramContext);
      if (TextUtils.equals(paramContext, "action_clear_message_red_poiont")) {}
      do
      {
        int i;
        do
        {
          do
          {
            try
            {
              i = paramIntent.getIntExtra("createTime", 0);
              QLog.d(QCircleGlobalBroadcastHelper.TAG, 1, "ACTION_CLEAR_MESSAGE_RED_POIONT createTime:" + i);
              QCircleGlobalBroadcastHelper.this.bhH();
              return;
            }
            catch (Exception paramContext)
            {
              paramContext.printStackTrace();
              return;
            }
            if (!TextUtils.equals(paramContext, "action_update_native_user_follow_state")) {
              break;
            }
            paramContext = paramIntent.getStringExtra("uin");
            i = paramIntent.getIntExtra("type", -1);
          } while ((TextUtils.isEmpty(paramContext)) || (i == -1));
          QLog.d(QCircleGlobalBroadcastHelper.TAG, 1, "updateFollowManager uin:" + paramContext + " type:" + i);
          if (i == 1) {}
          for (;;)
          {
            pbu.a().setUinFollowed(paramContext, bool1);
            rwv.a().a(new QCircleFollowUpdateEvent(i, paramContext));
            return;
            bool1 = false;
          }
          if (!TextUtils.equals(paramContext, "action_update_native_tag_follow_state")) {
            break;
          }
          paramContext = paramIntent.getStringExtra("tagId");
          i = paramIntent.getIntExtra("type", -1);
        } while ((TextUtils.isEmpty(paramContext)) || (i == -1));
        QLog.d(QCircleGlobalBroadcastHelper.TAG, 1, "updateTagFollowManager tagId:" + paramContext + " type:" + i);
        if (i == 1) {}
        for (bool1 = bool2;; bool1 = false)
        {
          pbz.a().as(paramContext, bool1);
          return;
        }
      } while (!TextUtils.equals(paramContext, "action_receive_message_push"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.QCircleGlobalBroadcastHelper
 * JD-Core Version:    0.7.0.1
 */