package com.tencent.mobileqq.app.message;

import android.os.Handler;
import android.os.Looper;
import com.dataline.activities.LiteActivity;
import com.dataline.util.WaitEvent;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cyg;
import cyh;
import cyi;
import java.util.Map;

public class DatalineMessageManager
  implements IMessageManager
{
  public static final String a = "Q.msg.DatalineMessageManager";
  public QQAppInterface a;
  public QQMessageFacade a;
  
  public DatalineMessageManager(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade = paramQQMessageFacade;
  }
  
  private DataLineMsgProxy a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
  }
  
  private void a(DataLineMsgRecord paramDataLineMsgRecord, EntityManager paramEntityManager)
  {
    a().a(paramDataLineMsgRecord);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b(paramDataLineMsgRecord.getTableName(), 6000);
    paramEntityManager = a().a(paramDataLineMsgRecord.groupId);
    QQMessageFacade.Message localMessage;
    if ((DataLineMsgSet.isSingle(paramDataLineMsgRecord)) || (paramEntityManager == null) || (paramEntityManager.getComeCount() <= 1))
    {
      localMessage = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(String.valueOf(AppConstants.T), 6000);
      localMessage.selfuin = String.valueOf(AppConstants.T);
      localMessage.senderuin = String.valueOf(AppConstants.T);
      localMessage.msgtype = paramDataLineMsgRecord.msgtype;
      if (localMessage.msgtype == -2009) {
        localMessage.msgtype = -2005;
      }
      localMessage.msg = paramDataLineMsgRecord.msg;
      localMessage.emoRecentMsg = null;
      localMessage.time = paramDataLineMsgRecord.time;
      localMessage.msgseq = paramDataLineMsgRecord.msgseq;
      localMessage.isread = paramDataLineMsgRecord.isread;
      localMessage.issend = paramDataLineMsgRecord.issend;
      localMessage.frienduin = String.valueOf(AppConstants.T);
      localMessage.istroop = 6000;
      localMessage.fileType = -1;
      localMessage.msgId = paramDataLineMsgRecord.msgId;
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(localMessage);
      if (!paramDataLineMsgRecord.isSend()) {
        localMessage.hasReply = true;
      }
      if ((!paramDataLineMsgRecord.isSendFromLocal()) && (!paramDataLineMsgRecord.isread))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b(localMessage);
        if (!DataLineMsgSet.isSingle(paramDataLineMsgRecord)) {
          break label260;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localMessage.frienduin, localMessage.istroop, 1);
      }
    }
    label260:
    while ((paramEntityManager != null) && (paramEntityManager.getComeCount() != 1)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localMessage.frienduin, localMessage.istroop, 1);
  }
  
  public int a()
  {
    Object localObject = Looper.getMainLooper();
    if (Thread.currentThread() != ((Looper)localObject).getThread()) {
      throw new RuntimeException("clearHistory in no-main thread");
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(String.valueOf(AppConstants.T), 6000);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() == null) {
      return 0;
    }
    int i = a().a();
    if (i > 0)
    {
      ((QQMessageFacade.Message)localObject).msg = null;
      ((QQMessageFacade.Message)localObject).emoRecentMsg = null;
      ((QQMessageFacade.Message)localObject).fileType = -1;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(localObject);
    return i;
  }
  
  public int a(int paramInt)
  {
    return a().a(paramInt);
  }
  
  public int a(long paramLong)
  {
    DataLineMsgSet localDataLineMsgSet = a().a(paramLong);
    if (localDataLineMsgSet == null) {
      return -1;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread()) {
      return a(localDataLineMsgSet);
    }
    new Handler(localLooper).post(new cyh(this, localDataLineMsgSet));
    return 0;
  }
  
  public int a(DataLineMsgSet paramDataLineMsgSet)
  {
    boolean bool = false;
    Object localObject = Looper.getMainLooper();
    if (Thread.currentThread() == ((Looper)localObject).getThread())
    {
      int i = a().a(paramDataLineMsgSet);
      if (i > 0)
      {
        paramDataLineMsgSet = MsgProxyUtils.a(String.valueOf(AppConstants.T), 6000);
        if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a.containsKey(paramDataLineMsgSet))
        {
          bool = ((QQMessageFacade.Message)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a.get(paramDataLineMsgSet)).hasReply;
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a.remove(paramDataLineMsgSet);
        }
        if (a().a().size() > 0L)
        {
          paramDataLineMsgSet = a().a();
          localObject = new QQMessageFacade.Message();
          MessageRecord.copyMessageRecordBaseField((MessageRecord)localObject, paramDataLineMsgSet);
          ((QQMessageFacade.Message)localObject).emoRecentMsg = null;
          ((QQMessageFacade.Message)localObject).hasReply = bool;
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a((QQMessageFacade.Message)localObject);
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a.put(MsgProxyUtils.a(((QQMessageFacade.Message)localObject).frienduin, ((QQMessageFacade.Message)localObject).istroop), localObject);
        }
        paramDataLineMsgSet = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(String.valueOf(AppConstants.T), 6000);
        paramDataLineMsgSet.a();
        if (localObject != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(localObject);
        }
      }
      return i;
    }
    new Handler((Looper)localObject).post(new cyi(this, paramDataLineMsgSet));
    return 0;
  }
  
  public long a(DataLineMsgRecord paramDataLineMsgRecord, boolean paramBoolean)
  {
    long l1;
    if (paramDataLineMsgRecord == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.DatalineMessageManager", 2, "mr is null");
      }
      l1 = -1L;
    }
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      return l1;
      ((DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8)).a(false);
      localObject1 = new WaitEvent(false, false);
      localObject2 = Looper.getMainLooper();
      if (Thread.currentThread() == ((Looper)localObject2).getThread())
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        try
        {
          if (paramDataLineMsgRecord.time == 0L) {
            paramDataLineMsgRecord.time = MessageCache.a();
          }
          if (paramDataLineMsgRecord.msgseq == 0L) {
            paramDataLineMsgRecord.msgseq = ((int)paramDataLineMsgRecord.time);
          }
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
          RecentUser localRecentUser = ((RecentUserProxy)localObject2).a(String.valueOf(AppConstants.T), 6000);
          localRecentUser.type = 6000;
          localRecentUser.lastmsgtime = paramDataLineMsgRecord.time;
          ((RecentUserProxy)localObject2).a(localRecentUser);
          a(paramDataLineMsgRecord, (EntityManager)localObject1);
          long l2 = paramDataLineMsgRecord.msgId;
          if (paramBoolean) {
            paramDataLineMsgRecord.issuc = true;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramDataLineMsgRecord);
          ((EntityManager)localObject1).a();
          l1 = l2;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.msg.DatalineMessageManager", 2, "mr.msgId: " + l2);
            return l2;
          }
        }
        finally
        {
          ((EntityManager)localObject1).a();
        }
      }
    }
    new Handler((Looper)localObject2).post(new cyg(this, paramDataLineMsgRecord, (WaitEvent)localObject1));
    ((WaitEvent)localObject1).a(-1L);
    return 0L;
  }
  
  public DataLineMsgRecord a(long paramLong)
  {
    return a().a(paramLong);
  }
  
  public DataLineMsgSet a(long paramLong)
  {
    return a().b(paramLong);
  }
  
  public void a()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    try
    {
      RecentUserProxy localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      RecentUser localRecentUser = localRecentUserProxy.a(String.valueOf(AppConstants.T), 6000);
      localRecentUser.type = 6000;
      localRecentUser.lastmsgtime = MessageCache.a();
      localRecentUserProxy.a(localRecentUser);
      ((EntityManager)localObject1).a();
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(String.valueOf(AppConstants.T), 6000);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(localObject1);
      return;
    }
    finally
    {
      ((EntityManager)localObject1).a();
    }
  }
  
  public void a(long paramLong)
  {
    a().b(paramLong);
  }
  
  public void a(long paramLong, String paramString, byte[] paramArrayOfByte)
  {
    a().a(paramLong, paramString, paramArrayOfByte);
  }
  
  public boolean a(long paramLong)
  {
    return a().a(paramLong);
  }
  
  public DataLineMsgRecord b(long paramLong)
  {
    return a().b(paramLong);
  }
  
  public void b()
  {
    a().d();
  }
  
  public void b(long paramLong)
  {
    a().c(paramLong);
  }
  
  public void c()
  {
    a().c();
  }
  
  public void c(long paramLong)
  {
    a().a(paramLong);
  }
  
  public void d()
  {
    if (!LiteActivity.class.getName().equals(ConfigHandler.a(BaseApplication.getContext()))) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DatalineMessageManager", 2, "setDataLineMsgReaded,unread=" + this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().a(AppConstants.T, 6000));
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().a(AppConstants.T, 6000) <= 0);
    a().e();
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().a(AppConstants.T, 6000);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(AppConstants.T, 6000));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.DatalineMessageManager
 * JD-Core Version:    0.7.0.1
 */