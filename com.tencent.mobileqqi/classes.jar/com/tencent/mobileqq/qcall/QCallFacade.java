package com.tencent.mobileqq.qcall;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.AbilityUtils;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.data.QCallRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import gfs;
import gft;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import mqq.manager.Manager;

public class QCallFacade
  extends Observable
  implements Manager
{
  private static final String jdField_a_of_type_JavaLangString = QCallFacade.class.getSimpleName();
  private DiscussionObserver jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = new gft(this);
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new gfs(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public QCallFacade(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    paramQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
  }
  
  private int a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getNewestMissCallCount friendUin:" + paramString + ",uinType:" + paramInt);
    }
    paramString = a(paramString, paramInt);
    int i;
    if ((paramString == null) || (paramString.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getNewestMissCallCount count 0");
      }
      i = 0;
    }
    do
    {
      return i;
      i = 0;
      int j;
      for (paramInt = 0; i < paramString.size(); paramInt = j)
      {
        QCallRecord localQCallRecord = (QCallRecord)paramString.get(i);
        j = paramInt;
        if (localQCallRecord != null)
        {
          j = paramInt;
          if (localQCallRecord.type == QCallRecord.TYPE_REALRECORD)
          {
            if (!localQCallRecord.isMissCall()) {
              break;
            }
            j = paramInt + 1;
          }
        }
        i += 1;
      }
      i = paramInt;
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "getNewestMissCallCount count:" + paramInt);
    return paramInt;
  }
  
  private long a(QQAppInterface paramQQAppInterface)
  {
    BaseApplication localBaseApplication = paramQQAppInterface.a();
    paramQQAppInterface = paramQQAppInterface.a();
    return localBaseApplication.getSharedPreferences("voice_tab_time", 0).getLong(paramQQAppInterface, 0L);
  }
  
  private QCallRecent a(MessageForVideo paramMessageForVideo)
  {
    int i = 1;
    String str = paramMessageForVideo.frienduin;
    long l = paramMessageForVideo.time;
    QCallRecent localQCallRecent = a().a(str, paramMessageForVideo.istroop);
    localQCallRecent.uin = str;
    localQCallRecent.type = paramMessageForVideo.istroop;
    localQCallRecent.sendFlag = paramMessageForVideo.issend;
    localQCallRecent.lastCallMsg = MsgUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramMessageForVideo.text);
    if (l > localQCallRecent.lastCallTime) {
      localQCallRecent.lastCallTime = l;
    }
    if ((localQCallRecent.type == 1000) || (localQCallRecent.type == 1020) || (localQCallRecent.type == 1004)) {
      localQCallRecent.troopUin = paramMessageForVideo.senderuin;
    }
    localQCallRecent.missedCallCount = a(paramMessageForVideo.frienduin, paramMessageForVideo.istroop);
    paramMessageForVideo = paramMessageForVideo.msg;
    if (paramMessageForVideo != null)
    {
      paramMessageForVideo = paramMessageForVideo.split("\\|");
      if ((paramMessageForVideo == null) || (paramMessageForVideo.length <= 3)) {
        break label198;
      }
      if (!"1".equals(paramMessageForVideo[3])) {
        break label193;
      }
    }
    for (;;)
    {
      localQCallRecent.isVideo = i;
      return localQCallRecent;
      label193:
      i = 0;
    }
    label198:
    localQCallRecent.isVideo = 1;
    return localQCallRecent;
  }
  
  private QCallRecord a(MessageForVideo paramMessageForVideo)
  {
    if (paramMessageForVideo == null) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getMessageToCallRecord message is null");
      }
    }
    QCallRecord localQCallRecord;
    do
    {
      return null;
      localQCallRecord = new QCallRecord();
      localQCallRecord.friendUin = paramMessageForVideo.frienduin;
      localQCallRecord.time = paramMessageForVideo.time;
      localQCallRecord.uinType = paramMessageForVideo.istroop;
      localQCallRecord.senderuin = paramMessageForVideo.senderuin;
      localQCallRecord.issend = paramMessageForVideo.issend;
      localQCallRecord.uniseq = paramMessageForVideo.uniseq;
      if ((localQCallRecord.uinType == 1000) || (localQCallRecord.uinType == 1020) || (localQCallRecord.uinType == 1004)) {
        localQCallRecord.troopUin = paramMessageForVideo.senderuin;
      }
      paramMessageForVideo = paramMessageForVideo.msg;
      if (paramMessageForVideo != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "getMessageToCallRecord message's msg is null");
    return null;
    Object localObject = paramMessageForVideo.split("\\|");
    int i;
    if ((localObject != null) && (localObject.length > 3)) {
      if ("1".equals(localObject[3]))
      {
        i = 1;
        localQCallRecord.isVideo = i;
        if (localObject.length <= 3) {
          break label390;
        }
        localObject[0].trim();
      }
    }
    for (;;)
    {
      try
      {
        localQCallRecord.state = Integer.parseInt(localObject[1]);
        if (QLog.isColorLevel())
        {
          localObject = jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder().append("getMessageToCallRecord:");
          if (localQCallRecord == null) {
            break label393;
          }
          paramMessageForVideo = localQCallRecord.toString();
          QLog.d((String)localObject, 2, paramMessageForVideo);
        }
        return localQCallRecord;
        i = 0;
        break;
        localQCallRecord.isVideo = 1;
      }
      catch (Exception localException)
      {
        if ((paramMessageForVideo != null) && (paramMessageForVideo.length() > 0) && (paramMessageForVideo.charAt(0) == '\026'))
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "getMessageToCallRecord java.lang.NumberFormatException: Invalid int: " + localObject[1] + " msg is " + paramMessageForVideo);
          continue;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getMessageToCallRecord java.lang.NumberFormatException: Invalid int: " + localObject[1] + " msg byte " + Utils.a(paramMessageForVideo));
        continue;
      }
      label390:
      continue;
      label393:
      paramMessageForVideo = "";
    }
  }
  
  private QCallProxy a()
  {
    c();
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    paramQQAppInterface = paramQQAppInterface.a().getSharedPreferences("voice_tab_time", 0);
    if (!paramQQAppInterface.getBoolean("audio_tips_state", false)) {
      paramQQAppInterface.edit().putLong("login_success_time", paramLong).commit();
    }
  }
  
  private void b()
  {
    setChanged();
    notifyObservers();
    if (a().a())
    {
      setChanged();
      notifyObservers(Boolean.valueOf(true));
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a();
  }
  
  private void c(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("voice_tab_time", 0).edit().putLong("merge_data_time", paramLong).commit();
  }
  
  public int a()
  {
    Object localObject = a().a();
    if (localObject == null) {
      return 0;
    }
    long l = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localObject = ((List)localObject).iterator();
    int i = 0;
    int j;
    if (((Iterator)localObject).hasNext())
    {
      QCallRecent localQCallRecent = (QCallRecent)((Iterator)localObject).next();
      if (localQCallRecent.lastCallTime <= l) {
        break label106;
      }
      if (localQCallRecent.isMissedCall())
      {
        j = a(localQCallRecent.uin, localQCallRecent.type, l);
        label92:
        i = j + i;
      }
    }
    label106:
    for (;;)
    {
      break;
      j = 0;
      break label92;
      return i;
    }
  }
  
  public int a(String paramString, int paramInt, long paramLong)
  {
    paramString = a().a(paramString, paramInt);
    paramInt = 0;
    int i = 0;
    if (paramInt < paramString.size())
    {
      QCallRecord localQCallRecord = (QCallRecord)paramString.get(paramInt);
      int j;
      if (localQCallRecord.type == QCallRecord.TYPE_DATE) {
        j = i;
      }
      for (;;)
      {
        paramInt += 1;
        i = j;
        break;
        if (!localQCallRecord.isMissCall()) {
          break label94;
        }
        j = i;
        if (localQCallRecord.time > paramLong) {
          j = i + 1;
        }
      }
    }
    label94:
    return i;
  }
  
  public List a()
  {
    return a().a();
  }
  
  public List a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getListRecord friendUin:" + paramString + ",uinType:" + paramInt);
    }
    return a().a(paramString, paramInt);
  }
  
  public void a()
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a();
    if ((localList == null) || (localList.size() < 1)) {
      return;
    }
    QQMessageFacade localQQMessageFacade = (QQMessageFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(17);
    int i = 0;
    if (i < localList.size())
    {
      RecentUser localRecentUser = (RecentUser)localList.get(i);
      if (!AbilityUtils.a(localRecentUser.type)) {}
      for (;;)
      {
        i += 1;
        break;
        Object localObject = localQQMessageFacade.a(localRecentUser.uin, localRecentUser.type, new int[] { -2009 });
        if ((localObject != null) && (((List)localObject).size() >= 1) && (((MessageRecord)((List)localObject).get(0)).istroop != 1))
        {
          ArrayList localArrayList = new ArrayList();
          int j = 0;
          while (j < ((List)localObject).size())
          {
            if ((((List)localObject).get(j) instanceof MessageForVideo))
            {
              MessageForVideo localMessageForVideo = (MessageForVideo)((List)localObject).get(j);
              localMessageForVideo.parse();
              localArrayList.add(localMessageForVideo);
              a(localMessageForVideo, false);
            }
            j += 1;
          }
          if (localArrayList.size() >= 1)
          {
            localObject = (MessageForVideo)localArrayList.get(localArrayList.size() - 1);
            if (QLog.isDevelopLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 4, String.format("handleDataMigration# add last msg from uin:%s->%s", new Object[] { localRecentUser.uin, ((MessageForVideo)localObject).toString() }));
            }
            a((MessageForVideo)localObject);
          }
        }
      }
    }
    c(System.currentTimeMillis());
  }
  
  public void a(int paramInt, long paramLong)
  {
    QCallRecent localQCallRecent = a().a(String.valueOf(paramLong), 3000);
    localQCallRecent.uin = String.valueOf(paramLong);
    localQCallRecent.lastCallTime = MessageCache.a();
    localQCallRecent.type = 3000;
    localQCallRecent.sendFlag = paramInt;
    localQCallRecent.troopUin = String.valueOf(paramLong);
    localQCallRecent.missedCallCount = a(String.valueOf(paramLong), 3000);
    if (paramInt == 1) {
      localQCallRecent.state = 4;
    }
    a(localQCallRecent);
  }
  
  public void a(long paramLong) {}
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean1, long paramLong3, boolean paramBoolean2)
  {
    QCallRecent localQCallRecent;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(String.valueOf(paramLong2)))
    {
      localQCallRecent = a().a(String.valueOf(paramLong1), 3000);
      localQCallRecent.lastCallTime = MessageCache.a();
      if (!paramBoolean1) {
        break label59;
      }
      localQCallRecent.state = 1;
    }
    for (;;)
    {
      a(localQCallRecent);
      return;
      label59:
      localQCallRecent.state = 3;
      localQCallRecent.time = paramLong3;
      if (paramLong3 > 0L)
      {
        localQCallRecord = new QCallRecord();
        localQCallRecord.friendUin = String.valueOf(paramLong1);
        localQCallRecord.isVideo = 0;
        localQCallRecord.time = MessageCache.a();
        localQCallRecord.talkTime = String.valueOf(paramLong3);
        localQCallRecord.type = QCallRecord.TYPE_REALRECORD;
        localQCallRecord.uinType = 3000;
        if (paramBoolean2) {
          localQCallRecord.state = 4;
        }
        for (localQCallRecord.issend = 1;; localQCallRecord.issend = 0)
        {
          a().a(localQCallRecord);
          break;
          localQCallRecord.state = 3;
        }
      }
      QCallRecord localQCallRecord = new QCallRecord();
      localQCallRecord.friendUin = String.valueOf(paramLong1);
      localQCallRecord.issend = 1;
      localQCallRecord.isVideo = 0;
      localQCallRecord.time = MessageCache.a();
      localQCallRecord.type = QCallRecord.TYPE_REALRECORD;
      localQCallRecord.state = 4;
      localQCallRecord.uinType = 3000;
      a().a(localQCallRecord);
    }
  }
  
  public void a(MessageForVideo paramMessageForVideo)
  {
    paramMessageForVideo.parse();
    paramMessageForVideo = a(paramMessageForVideo);
    a(paramMessageForVideo);
    if ((paramMessageForVideo != null) && (paramMessageForVideo.type == 3000))
    {
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (paramMessageForVideo.isSend()) {}
      for (paramMessageForVideo = "1";; paramMessageForVideo = "0")
      {
        ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8004067", "0X8004067", 0, 0, paramMessageForVideo, "", "", "");
        return;
      }
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (paramMessageForVideo.isSend()) {}
    for (paramMessageForVideo = "1";; paramMessageForVideo = "0")
    {
      ReportController.b(localQQAppInterface, "CliOper", "", "", "Msg_tab", "Call_history_count", 0, 0, paramMessageForVideo, "", "", "");
      return;
    }
  }
  
  public void a(MessageForVideo paramMessageForVideo, boolean paramBoolean)
  {
    if (paramMessageForVideo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "insertCallRecord updateRecentMissedCallCount: msg is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "insertCallRecord updateRecentMissedCallCount:" + paramBoolean + ", msg :" + paramMessageForVideo.toString());
    }
    Object localObject = a(paramMessageForVideo);
    a().a((QCallRecord)localObject);
    if (paramBoolean)
    {
      localObject = a().b(paramMessageForVideo.frienduin, paramMessageForVideo.istroop);
      if (localObject != null)
      {
        ((QCallRecent)localObject).missedCallCount = a(paramMessageForVideo.frienduin, paramMessageForVideo.istroop);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "insertCallRecord QCallRecent update MissCallCount" + ((QCallRecent)localObject).missedCallCount);
        }
        a((QCallRecent)localObject);
      }
    }
    setChanged();
    notifyObservers(a(paramMessageForVideo.frienduin, paramMessageForVideo.istroop));
  }
  
  public void a(QCallRecent paramQCallRecent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "save " + paramQCallRecent);
    }
    a().c(paramQCallRecent);
    b();
  }
  
  public void a(String paramString)
  {
    a(paramString, 0);
    a(paramString, 1000);
    a(paramString, 1020);
    a(paramString, 1004);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    QCallRecent localQCallRecent = a().b(paramString, paramInt);
    if (localQCallRecent != null) {
      b(localQCallRecent);
    }
    b(paramString, paramInt);
  }
  
  public void a(String paramString1, String paramString2)
  {
    paramString2 = new QCallRecord();
    paramString2.friendUin = String.valueOf(paramString1);
    paramString2.issend = 0;
    paramString2.isVideo = 0;
    paramString2.time = MessageCache.a();
    paramString2.type = QCallRecord.TYPE_REALRECORD;
    paramString2.state = 2;
    paramString2.uinType = 3000;
    a().a(paramString2);
    paramString2 = a().a(String.valueOf(paramString1), 3000);
    paramString2.uin = String.valueOf(paramString1);
    paramString2.lastCallTime = MessageCache.a();
    paramString2.type = 3000;
    paramString2.sendFlag = 0;
    paramString2.troopUin = String.valueOf(paramString1);
    paramString2.state = 2;
    paramString2.missedCallCount = a(paramString1, 3000);
    a(paramString2);
  }
  
  public void a(boolean paramBoolean)
  {
    a().a(paramBoolean);
  }
  
  public boolean a()
  {
    return a().a();
  }
  
  public void b(long paramLong)
  {
    BaseApplication localBaseApplication = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    localBaseApplication.getSharedPreferences("voice_tab_time", 0).edit().putLong(str, paramLong).commit();
  }
  
  public void b(QCallRecent paramQCallRecent)
  {
    if (paramQCallRecent == null) {
      return;
    }
    a().a(paramQCallRecent);
    b();
  }
  
  public void b(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "clearAllRecord friendUin:" + paramString + ",uinType:" + paramInt);
    }
    a().a(paramString, paramInt);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("voice_tab_time", 0).edit().putBoolean("audio_tips_state", paramBoolean).commit();
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
    deleteObservers();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.QCallFacade
 * JD-Core Version:    0.7.0.1
 */