package com.tencent.mobileqq.app.message;

import android.content.res.Resources;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class DiscMessageManager
  extends BaseMessageManagerForTroopAndDisc
{
  public DiscMessageManager(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade)
  {
    super(paramQQAppInterface, paramQQMessageFacade);
  }
  
  public String a(String paramString1, String paramString2)
  {
    if (this.a.a().equals(paramString1)) {
      return this.a.a().getResources().getString(2131363563);
    }
    FriendManager localFriendManager = (FriendManager)this.a.getManager(8);
    if (localFriendManager != null) {
      return localFriendManager.c(paramString2, paramString1);
    }
    return ContactUtils.a(this.a, paramString1, 0);
  }
  
  public void a(MessageRecord paramMessageRecord, EntityManager paramEntityManager, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, BaseMessageManager.AddMessageContext paramAddMessageContext)
  {
    if (paramMessageRecord == null) {
      return;
    }
    Map localMap = paramAddMessageContext.jdField_a_of_type_JavaUtilMap;
    Object localObject = paramAddMessageContext.jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy;
    if (paramMessageRecord.time == 0L) {
      paramMessageRecord.time = MessageCache.a();
    }
    if (paramMessageRecord.msgseq == 0L) {
      paramMessageRecord.msgseq = ((int)paramMessageRecord.time);
    }
    String str1 = paramMessageRecord.frienduin;
    int i = paramMessageRecord.istroop;
    long l = paramMessageRecord.time;
    RecentUser localRecentUser = ((RecentUserProxy)localObject).a(str1, paramMessageRecord.istroop);
    localObject = null;
    TroopInfoManager localTroopInfoManager = paramAddMessageContext.jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager;
    String str2;
    MessageInfo localMessageInfo;
    if (localTroopInfoManager != null)
    {
      str2 = str1 + "&" + 3000;
      localMessageInfo = localTroopInfoManager.a(str2);
      if (localMessageInfo == null) {
        break label500;
      }
      if (localMessageInfo.a() == paramMessageRecord.shmsgseq) {
        break label443;
      }
      localMessageInfo = null;
      localObject = localMessageInfo;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "addMessageRecord:not the same msg:" + str2);
        localObject = localMessageInfo;
      }
    }
    if ((localObject != null) && (((MessageInfo)localObject).a()))
    {
      int j = ((MessageInfo)localObject).b();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "addMessageRecord, bizType" + j + "|ru.msgType:" + localRecentUser.msgType);
      }
      if (j >= localRecentUser.msgType)
      {
        localRecentUser.msgType = j;
        localRecentUser.msg = MessageInfo.a(this.a, str1, (MessageInfo)localObject, localRecentUser.msg, paramMessageRecord, false);
        localMap.put(MsgProxyUtils.a(str1, i), localRecentUser);
      }
    }
    if (localMap.containsKey(MsgProxyUtils.a(localRecentUser.uin, localRecentUser.type))) {}
    for (localObject = (RecentUser)localMap.get(MsgProxyUtils.a(localRecentUser.uin, localRecentUser.type));; localObject = localRecentUser)
    {
      if (!MsgProxyUtils.d(paramMessageRecord.msgtype))
      {
        ((RecentUser)localObject).uin = str1;
        ((RecentUser)localObject).type = i;
        if (l > ((RecentUser)localObject).lastmsgtime)
        {
          ((RecentUser)localObject).lastmsgtime = l;
          localMap.put(MsgProxyUtils.a(str1, i), localObject);
        }
      }
      super.a(paramMessageRecord, paramEntityManager, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramAddMessageContext);
      return;
      label443:
      localObject = localMessageInfo;
      if (!paramMessageRecord.isread) {
        break;
      }
      localTroopInfoManager.b(str2);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "addMessageRecord:readed msg been removed:" + str2);
      }
      localObject = null;
      break;
      label500:
      localObject = localMessageInfo;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "addMessageRecord:msgInfo == null " + str2);
      localObject = localMessageInfo;
      break;
    }
  }
  
  protected void a(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "afterCleanUnRead:" + paramString + "-" + paramInt + "-" + paramLong);
    }
    super.a(paramString, paramInt, paramLong);
    d(paramString, paramInt, paramLong);
  }
  
  public void b(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "afterCleanUnRead:" + paramString + "-" + paramInt);
    }
    super.b(paramString, paramInt);
    ProxyManager localProxyManager = this.a.a();
    paramString = localProxyManager.a().a(paramString, paramInt);
    if (paramString.shouldShowInRecentList())
    {
      paramString.cleanMsgAndMsgData(paramString.msgType);
      localProxyManager.a().a(paramString);
    }
  }
  
  public void c(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "afterCleanUnRead:" + paramString + "-" + paramInt + "-" + paramLong);
    }
    if (this.a.a().a(paramString, paramInt) > 0) {
      d(paramString, paramInt, paramLong);
    }
    super.c(paramString, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.DiscMessageManager
 * JD-Core Version:    0.7.0.1
 */