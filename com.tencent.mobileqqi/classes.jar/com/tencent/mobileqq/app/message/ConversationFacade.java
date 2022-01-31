package com.tencent.mobileqq.app.message;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BadgeUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Set;
import mqq.manager.Manager;

public class ConversationFacade
  extends Observable
  implements Manager
{
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final String jdField_a_of_type_JavaLangString = "Q.unread.Facade";
  
  public ConversationFacade(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private ConversationProxy a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
  }
  
  private MsgProxy a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt);
  }
  
  private QQMessageFacade a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
  }
  
  private FriendManager a()
  {
    return (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 3000) || (paramInt == 1);
  }
  
  private boolean a(MessageRecord paramMessageRecord, Set paramSet)
  {
    if ((paramSet == null) || (paramSet.isEmpty())) {
      return false;
    }
    paramSet = paramSet.iterator();
    while (paramSet.hasNext()) {
      if (MsgProxyUtils.a(paramMessageRecord, (MessageRecord)paramSet.next())) {
        return true;
      }
    }
    return false;
  }
  
  private void b()
  {
    c(AppConstants.V, 1001);
    c(AppConstants.N, 1009);
  }
  
  private void c(String paramString, int paramInt)
  {
    Object localObject = a(paramInt).a(paramString, paramInt);
    if ((localObject == null) || (((List)localObject).isEmpty())) {}
    int i;
    do
    {
      return;
      localObject = ((List)localObject).iterator();
      MessageRecord localMessageRecord;
      for (i = 0; ((Iterator)localObject).hasNext(); i = a(localMessageRecord.senderuin, localMessageRecord.istroop) + i) {
        localMessageRecord = (MessageRecord)((Iterator)localObject).next();
      }
      if (a(paramString, paramInt) != i) {
        a().a(paramString, paramInt, i);
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.unread.Facade", 2, "calculateMsgBoxUnreadCount boxUin=" + paramString + ", unread=" + i);
  }
  
  public int a(String paramString, int paramInt)
  {
    return a().a(paramString, paramInt);
  }
  
  public long a(String paramString, int paramInt)
  {
    return a().a(paramString, paramInt);
  }
  
  public Set a()
  {
    return a().a();
  }
  
  public void a()
  {
    a().c();
    Object localObject2 = a().a();
    Object localObject1 = new HashSet();
    localObject2 = ((Set)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      ConversationInfo localConversationInfo = (ConversationInfo)((Iterator)localObject2).next();
      if (b(localConversationInfo.uin, localConversationInfo.type))
      {
        if (MsgProxyUtils.a(localConversationInfo.uin, localConversationInfo.type)) {
          c(localConversationInfo.uin, localConversationInfo.type);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.unread.Facade", 2, "initCache info=" + localConversationInfo.toString());
        }
      }
      else if ((MsgProxyUtils.l(localConversationInfo.type)) && (!MsgProxyUtils.a(localConversationInfo.uin, localConversationInfo.type)) && (!a(localConversationInfo.uin, localConversationInfo.type)))
      {
        ((Set)localObject1).add(localConversationInfo);
      }
    }
    if (!((Set)localObject1).isEmpty())
    {
      localObject1 = ((Set)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ConversationInfo)((Iterator)localObject1).next();
        if (QLog.isColorLevel()) {
          QLog.d("Q.unread.Facade", 2, "initCache remove info=" + ((ConversationInfo)localObject2).toString());
        }
        a().a(((ConversationInfo)localObject2).uin, ((ConversationInfo)localObject2).type);
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    a(paramString, paramInt, a().a(paramString, paramInt));
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.unread.Facade", 2, "rewriteUnreadCount uin=" + paramString + ",type" + paramInt1 + ",unread" + paramInt2);
    }
    a().a(paramString, paramInt1, paramInt2);
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    long l = a().a(paramString, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("Q.unread.Facade", 2, "cleanUnread uin=" + paramString + ",type" + paramInt + ",unread" + l + " ,lastread" + paramLong);
    }
    a().a(paramString, paramInt, paramLong, 0);
    if (l > 0L)
    {
      if (MsgProxyUtils.a(paramInt)) {
        b();
      }
      QQMessageFacade.Message localMessage = a().a(paramString, paramInt);
      if (localMessage != null) {
        a(paramInt).a(paramString, paramInt, localMessage);
      }
    }
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    paramInt2 = a().a(paramString2, paramInt2);
    int i = a().a(paramString1, paramInt1);
    int j = Math.min(paramInt2, i);
    if (QLog.isColorLevel()) {
      QLog.d("Q.unread.Facade", 2, "moveBoxToMessageTab innerItemUnread=" + paramInt2 + ", convsItemUnread=" + i);
    }
    a().a(paramString1, paramInt1, i - j);
  }
  
  public void a(List paramList)
  {
    Object localObject1 = null;
    int i;
    MessageRecord localMessageRecord;
    Object localObject2;
    String str;
    if (paramList != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.unread.Facade", 2, "addUnread msg size=" + paramList.size());
      }
      Iterator localIterator = paramList.iterator();
      i = 0;
      paramList = (List)localObject1;
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localMessageRecord = (MessageRecord)localIterator.next();
          localObject2 = paramList;
          if (localMessageRecord.isSendFromLocal()) {
            break label357;
          }
          localObject2 = paramList;
          if (localMessageRecord.isread) {
            break label357;
          }
          localObject1 = paramList;
          if (localMessageRecord.isLongMsg())
          {
            str = MsgProxyUtils.a(localMessageRecord);
            localObject2 = paramList;
            if (paramList == null) {
              localObject2 = new HashSet();
            }
            if (MsgProxyUtils.a(localMessageRecord))
            {
              paramList = (List)localObject2;
              if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord)) {
                continue;
              }
              paramList = (List)localObject2;
              if (((Set)localObject2).contains(str)) {
                continue;
              }
              ((Set)localObject2).add(str);
              localObject1 = localObject2;
            }
          }
          else
          {
            label185:
            if (1001 != localMessageRecord.istroop) {
              break label297;
            }
            if (!AppConstants.V.equals(localMessageRecord.frienduin)) {
              break label278;
            }
            a().b(localMessageRecord.senderuin, 1001, 1);
            label226:
            localObject2 = localObject1;
            if (!MsgProxyUtils.a(localMessageRecord.istroop)) {
              break label357;
            }
            i = 1;
          }
        }
      }
    }
    label278:
    label297:
    label357:
    for (paramList = (List)localObject1;; paramList = (List)localObject2)
    {
      break;
      localObject1 = localObject2;
      if (!((Set)localObject2).contains(str)) {
        break label185;
      }
      ((Set)localObject2).remove(str);
      localObject1 = localObject2;
      break label185;
      a().b(localMessageRecord.frienduin, 1001, 1);
      break label226;
      if (1009 == localMessageRecord.istroop)
      {
        a().b(localMessageRecord.frienduin, 1009, 1);
        break label226;
      }
      a().b(localMessageRecord.frienduin, localMessageRecord.istroop, 1);
      break label226;
      if (i != 0) {
        b();
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.unread.Facade", 2, "cleanAllUnread needUpdateMsgtable=" + paramBoolean);
    }
    if (paramBoolean)
    {
      Iterator localIterator = a().a().iterator();
      while (localIterator.hasNext())
      {
        ConversationInfo localConversationInfo = (ConversationInfo)localIterator.next();
        if (localConversationInfo.unreadCount > 0) {
          a(localConversationInfo.uin, localConversationInfo.type);
        }
      }
    }
    a().d();
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    RecentUserProxy localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    int[] arrayOfInt = MsgProxyUtils.k;
    int j = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (localRecentUserProxy.b(paramString, arrayOfInt[i]) != null) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public boolean a(String paramString, int paramInt)
  {
    if (paramString == null) {
      return false;
    }
    Object localObject = null;
    if (paramInt == 1009) {
      localObject = a(paramInt).a(AppConstants.N, 1009);
    }
    while ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((List)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!paramString.equals(((MessageRecord)((Iterator)localObject).next()).senderuin));
      return true;
      if (paramInt == 1001) {
        localObject = a(paramInt).a(AppConstants.V, 1001);
      }
    }
    return false;
  }
  
  public void b(String paramString, int paramInt)
  {
    a(paramString, paramInt);
    a().a(paramString, paramInt);
  }
  
  public void b(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.unread.Facade", 2, "increaseUnread uin=" + paramString + ",type" + paramInt1 + ",count" + paramInt2);
    }
    a().b(paramString, paramInt1, paramInt2);
    if (MsgProxyUtils.a(paramInt1)) {
      b();
    }
  }
  
  protected void b(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.unread.Facade", 2, "cleanUnreadFrom uin=" + paramString + ",type=" + paramInt + ",lastread=" + paramLong);
    }
    c(paramString, paramInt, paramLong);
    a(paramInt).a(paramString, paramInt, paramLong);
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    NewFriendManager localNewFriendManager;
    if (paramString != null)
    {
      localNewFriendManager = (NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32);
      if (localNewFriendManager == null) {
        break label129;
      }
    }
    label129:
    for (paramInt = localNewFriendManager.a(1);; paramInt = 0)
    {
      int i = paramString.f();
      BadgeUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramInt + i);
      return;
    }
  }
  
  public boolean b(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b(paramString, paramInt) != null) {
      return true;
    }
    if (!a(paramInt)) {
      return a(paramString);
    }
    return false;
  }
  
  protected void c(String paramString, int paramInt, long paramLong)
  {
    Object localObject1 = a(paramInt).b(paramString, paramInt);
    if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
      if (a().a(paramString, paramInt) > 0) {
        a(paramString, paramInt, paramLong);
      }
    }
    do
    {
      return;
      if (((!a(paramInt)) || (((MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1)).shmsgseq > paramLong)) && ((a(paramInt)) || (((MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1)).time > paramLong))) {
        break;
      }
    } while (a().a(paramString, paramInt) <= 0);
    a(paramString, paramInt, paramLong);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("Q.unread.Facade", 2, "updateLastReadSeq uin=" + paramString + ",type=" + paramInt + ",lastread=" + paramLong);
    }
    ConversationInfo localConversationInfo = a().a(paramString, paramInt);
    long l;
    label221:
    int j;
    if (localConversationInfo != null) {
      if (a(paramInt))
      {
        l = Math.max(paramLong, localConversationInfo.lastread);
        j = localConversationInfo.unreadCount;
      }
    }
    for (;;)
    {
      label261:
      int i;
      Object localObject2;
      label313:
      MessageRecord localMessageRecord;
      label348:
      Object localObject3;
      label377:
      Object localObject4;
      if (a(paramInt))
      {
        paramLong = ((MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1)).shmsgseq - l;
        i = (int)paramLong;
        if (QLog.isColorLevel()) {
          QLog.d("Q.unread.Facade", 2, "updateLastReadSeq unread =" + i);
        }
        localObject2 = null;
        Iterator localIterator = ((List)localObject1).iterator();
        localObject1 = null;
        if (!localIterator.hasNext()) {
          break label748;
        }
        localMessageRecord = (MessageRecord)localIterator.next();
        if (!a(paramInt)) {
          break label512;
        }
        paramLong = localMessageRecord.shmsgseq;
        if ((!localMessageRecord.isLongMsg()) || (paramLong > l)) {
          break label867;
        }
        if (localObject1 != null) {
          break label860;
        }
        localObject3 = new HashMap();
        localObject1 = MsgProxyUtils.a(localMessageRecord);
        if (!((Map)localObject3).containsKey(MsgProxyUtils.a(localMessageRecord))) {
          break label521;
        }
        localObject4 = (Set)((Map)localObject3).get(localObject1);
        localObject1 = localObject3;
        if (localObject4 != null)
        {
          localObject1 = localObject3;
          if (!((Set)localObject4).isEmpty())
          {
            localObject1 = localObject3;
            if (!a(localMessageRecord, (Set)localObject4))
            {
              ((Set)localObject4).add(localMessageRecord);
              localObject1 = localObject3;
            }
          }
        }
      }
      label512:
      label521:
      label851:
      label857:
      label860:
      label867:
      for (;;)
      {
        localObject3 = localObject2;
        if (paramLong > l)
        {
          if (MsgProxyUtils.h(localMessageRecord.msgtype))
          {
            i -= 1;
            break label313;
            paramLong = a(paramInt).a(paramString, paramInt, paramLong);
            break label261;
            paramLong = localMessageRecord.time;
            break label348;
            localObject4 = new HashSet();
            ((Set)localObject4).add(localMessageRecord);
            ((Map)localObject3).put(localObject1, localObject4);
            localObject1 = localObject3;
            continue;
          }
          localObject3 = localObject2;
          if (localMessageRecord.isLongMsg())
          {
            if ((localObject1 != null) && (((Map)localObject1).containsKey(MsgProxyUtils.a(localMessageRecord))) && (a(localMessageRecord, (Set)((Map)localObject1).get(MsgProxyUtils.a(localMessageRecord)))))
            {
              i -= 1;
              break label313;
            }
            if (localObject2 != null) {
              break label857;
            }
            localObject2 = new HashSet();
          }
        }
        for (;;)
        {
          localObject3 = MsgProxyUtils.a(localMessageRecord);
          if (MsgProxyUtils.a(localMessageRecord))
          {
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord))
            {
              i -= 1;
              break label313;
            }
            if (((Set)localObject2).contains(localObject3))
            {
              i -= 1;
              break label313;
            }
            ((Set)localObject2).add(localObject3);
          }
          for (localObject3 = localObject2;; localObject3 = localObject2)
          {
            localObject2 = localObject3;
            break;
            if (((Set)localObject2).contains(localObject3)) {
              ((Set)localObject2).remove(localObject3);
            }
          }
          label748:
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder().append("updateLastReadSeq before=");
            if (localConversationInfo == null) {
              break label851;
            }
          }
          for (localObject1 = localConversationInfo.toString();; localObject1 = null)
          {
            QLog.d("Q.unread.Facade", 2, (String)localObject1 + " , end unread=" + i + ", lastread=" + l);
            a().a(paramString, paramInt, l, i);
            if ((i == j) || (!MsgProxyUtils.a(paramInt))) {
              break;
            }
            b();
            return;
          }
        }
        localObject3 = localObject1;
        break label377;
      }
      l = paramLong;
      break label221;
      j = 0;
      l = paramLong;
    }
  }
  
  public void onDestroy()
  {
    deleteObservers();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.ConversationFacade
 * JD-Core Version:    0.7.0.1
 */