package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemDiscussionMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemNewFriendMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemPcDataLine;
import com.tencent.mobileqq.activity.recent.data.RecentItemPubAccountAssitant;
import com.tencent.mobileqq.activity.recent.data.RecentItemTroopAssistant;
import com.tencent.mobileqq.activity.recent.data.RecentItemTroopMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemTroopNotification;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.sharealbum.QZoneRecentItemQZonePhotoAssistant;
import com.tencent.mobileqq.sharealbum.QZoneShareAlbumAssistantManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.TraceUtils;
import java.util.List;

public class ConversationDataFactory
{
  public static RecentBaseData a(RecentUser paramRecentUser, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject2 = localObject1;
    if (paramRecentUser != null)
    {
      localObject2 = localObject1;
      if (paramQQAppInterface != null)
      {
        if (paramContext != null) {
          break label29;
        }
        localObject2 = localObject1;
      }
    }
    label29:
    do
    {
      return localObject2;
      if (!TextUtils.isEmpty(paramRecentUser.uin)) {
        break;
      }
      localObject2 = localObject1;
    } while (!QLog.isColorLevel());
    QLog.i("Q.recent", 2, "buildRecentItemData, uin is null, " + paramRecentUser);
    return null;
    localObject1 = localObject3;
    switch (paramRecentUser.type)
    {
    default: 
      localObject1 = localObject3;
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        break;
      }
      ((RecentBaseData)localObject1).a(paramQQAppInterface, paramContext);
      localObject2 = localObject1;
      if (!QLog.isDevelopLevel()) {
        break;
      }
      return localObject1;
      localObject1 = new RecentItemTroopAssistant(paramRecentUser);
      continue;
      localObject1 = new RecentItemPcDataLine(paramRecentUser);
      continue;
      localObject1 = new RecentItemChatMsgData(paramRecentUser);
      continue;
      localObject1 = new RecentItemNewFriendMsgData(paramRecentUser);
      continue;
      localObject1 = new RecentItemTroopMsgData(paramRecentUser);
      continue;
      localObject1 = new RecentItemDiscussionMsgData(paramRecentUser);
      continue;
      localObject1 = new QZoneRecentItemQZonePhotoAssistant(paramRecentUser, paramQQAppInterface, paramContext);
      QZoneShareAlbumAssistantManager.a().a((RecentBaseData)localObject1);
      continue;
      localObject1 = new RecentItemPubAccountAssitant(paramRecentUser);
      continue;
      localObject1 = new RecentItemTroopNotification(paramRecentUser);
    }
  }
  
  public static void a(List paramList1, QQAppInterface paramQQAppInterface, Context paramContext, List paramList2, int paramInt)
  {
    if (paramList2 == null) {
      return;
    }
    for (;;)
    {
      RecentUser localRecentUser;
      RecentBaseData localRecentBaseData;
      try
      {
        paramList2.clear();
        if (paramList1 == null)
        {
          i = 0;
          break label206;
          if (i >= paramInt) {
            break;
          }
          localRecentUser = (RecentUser)paramList1.get(i);
          if (localRecentUser == null) {
            break label238;
          }
          if ((localRecentUser.type < 7000) || (localRecentUser.type >= 8000)) {
            continue;
          }
          break label238;
        }
        i = paramList1.size();
        break label206;
        TraceUtils.a(localRecentUser.uin);
        String str = RecentDataListManager.a(localRecentUser.uin, localRecentUser.type);
        localRecentBaseData = RecentDataListManager.a().a(str);
        if (localRecentBaseData == null)
        {
          localRecentBaseData = a(localRecentUser, paramQQAppInterface, paramContext);
          RecentDataListManager.a().a(localRecentBaseData, str);
          if (localRecentBaseData != null) {
            paramList2.add(localRecentBaseData);
          }
          TraceUtils.a();
        }
      }
      finally {}
      if ((localRecentBaseData instanceof RecentUserBaseData)) {
        ((RecentUserBaseData)localRecentBaseData).a(localRecentUser);
      }
      localRecentBaseData.a(paramQQAppInterface, paramContext);
      continue;
      int j;
      label206:
      do
      {
        paramInt = j;
        break;
        j = i;
        if (i > paramInt) {
          j = paramInt;
        }
      } while (j <= 99);
      paramInt = 99;
      int i = 0;
      continue;
      label238:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.ConversationDataFactory
 * JD-Core Version:    0.7.0.1
 */