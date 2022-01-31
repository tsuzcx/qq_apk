package com.tencent.mobileqq.troop.data;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.message.MsgPool;
import com.tencent.mobileqq.app.message.MsgProxy;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.proxy.MsgQueueItem;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.persistence.MessageRecordEntityManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.MessageDBUtils;
import com.tencent.qphone.base.util.QLog;
import emh;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class TroopAndDiscMsgProxy
  extends MsgProxy
{
  static final String b = "Q.msg.TroopMsgProxy";
  
  public TroopAndDiscMsgProxy(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    super(paramQQAppInterface, paramProxyManager);
  }
  
  protected int a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if (paramMessageRecord.extraflag == 32772) {}
    for (paramMessageRecord = a(paramMessageRecord, false, paramBoolean); paramMessageRecord == null; paramMessageRecord = a(paramMessageRecord, -2006, paramBoolean)) {
      return -1;
    }
    if (paramMessageRecord.isread) {
      return 1;
    }
    return 2;
  }
  
  protected int a(String paramString, int paramInt, long paramLong)
  {
    int i = 0;
    String str = MessageRecord.getTableName(paramString, paramInt);
    str = String.format("select m.*,(select count() from %s mr where mr.isread=0 and mr.issend='0' and mr.%s>'%d') as unReadNum from %s m where m.%s>'%d' order by %s limit 1", new Object[] { str, "shmsgseq", Long.valueOf(paramLong), str, "shmsgseq", Long.valueOf(paramLong), "shmsgseq desc , _id desc" });
    if (a(paramString, paramInt, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(a());
    }
    paramString = a().a(QQMessageFacade.Message.class, str, null);
    paramInt = i;
    if (paramString != null)
    {
      paramInt = i;
      if (!paramString.isEmpty()) {
        paramInt = ((QQMessageFacade.Message)paramString.get(0)).unReadNum;
      }
    }
    return paramInt;
  }
  
  protected int a(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    int i = 0;
    paramString = MessageRecord.getTableName(paramString, paramInt);
    MessageRecordEntityManager localMessageRecordEntityManager = this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager;
    String str = "( msgtype " + MsgProxyUtils.b() + " and isValid=1 ) " + "and shmsgseq <= ?";
    long l = paramMessageRecord.shmsgseq;
    paramString = localMessageRecordEntityManager.a(false, paramString, new String[] { "_id" }, str, new String[] { String.valueOf(l) }, null, null, null, null);
    paramInt = i;
    if (paramString != null)
    {
      paramInt = paramString.getCount();
      paramString.close();
    }
    return paramInt;
  }
  
  public MessageRecord a(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    return a(paramString, paramInt, paramMessageRecord, b(paramString, paramInt));
  }
  
  public MessageRecord a(String paramString, int paramInt, MessageRecord paramMessageRecord, List paramList)
  {
    if ((paramMessageRecord == null) || (paramList == null) || (paramList.isEmpty()) || (paramMessageRecord.msgtype == -2006))
    {
      paramMessageRecord = null;
      return paramMessageRecord;
    }
    paramInt = paramList.size() - 1;
    label43:
    if (paramInt >= 0) {
      if (MsgProxyUtils.a((MessageRecord)paramList.get(paramInt), paramMessageRecord, true, true)) {
        paramString = (MessageRecord)paramList.get(paramInt);
      }
    }
    for (;;)
    {
      if (paramString != null)
      {
        paramMessageRecord = paramString;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.msg.TroopMsgProxy", 2, "getSendMsgItemByMsgTimeAndContent[pull]: find msg =" + paramString.getLogColorContent() + " , mr.seq = " + paramString.shmsgseq + " , mr.time = " + paramString.time + " , mr.msgtype = " + paramString.msgtype + " , extra = " + paramString.extraflag);
        return paramString;
        if ((((MessageRecord)paramList.get(paramInt)).msgtype == -2011) && (paramMessageRecord.msgtype == -2011) && (paramMessageRecord.msgUid == ((MessageRecord)paramList.get(paramInt)).msgUid))
        {
          paramString = (MessageRecord)paramList.get(paramInt);
          continue;
        }
        paramInt -= 1;
        break label43;
      }
      paramMessageRecord = paramString;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("Q.msg.TroopMsgProxy", 2, "getSendMsgItemByMsgTimeAndContent[pull]: find fail !");
      return paramString;
      paramString = null;
    }
  }
  
  protected String a(Cursor paramCursor, SessionInfo paramSessionInfo, int paramInt)
  {
    return paramCursor.getString(paramCursor.getColumnIndex("senderuin"));
  }
  
  public List a(String paramString, int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.TroopMsgProxy", 2, "queryTroopMessageFromDB_UnionTables, peerUin = " + paramString + ", type " + paramInt1 + ",_id = " + paramLong1 + ",versionCode = " + paramInt2 + ", endSeq " + paramLong2 + ",count = " + paramInt3 + ",customTypes = " + Arrays.toString(paramArrayOfInt));
    }
    if (a(paramString, paramInt1, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(a());
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfInt != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfInt.length > 0)
      {
        localObject1 = new StringBuilder(" and msgtype in ( ");
        int i = 0;
        while (i < paramArrayOfInt.length)
        {
          ((StringBuilder)localObject1).append(paramArrayOfInt[i]);
          if (i < paramArrayOfInt.length - 1) {
            ((StringBuilder)localObject1).append(" , ");
          }
          i += 1;
        }
        ((StringBuilder)localObject1).append(" ) ");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    paramString = MessageDBUtils.a(MessageRecord.getOldTableName(paramString, paramInt1), MessageRecord.getTableName(paramString, paramInt1), paramLong1, paramInt2, paramLong2, (String)localObject1, paramInt3, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b());
    if (paramString == null) {
      paramString = new ArrayList();
    }
    do
    {
      return paramString;
      paramString = paramString.toString();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.TroopMsgProxy", 2, "queryTroopMessageFromDB_UnionTables " + paramString);
      }
      paramArrayOfInt = a().a(paramString, null, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramString = paramArrayOfInt;
    } while (paramArrayOfInt != null);
    return new ArrayList();
  }
  
  protected List a(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.TroopMsgProxy", 2, "queryMessageByTimeOrSeq:uin=" + paramString1 + ",type=" + paramInt1 + ",seq=" + paramLong + ",count=" + paramInt2);
    }
    if (a(paramString1, paramInt1, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.c();
    }
    if (MessageDBUtils.a(MessageRecord.getTableName(paramString1, paramInt1), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b()))
    {
      paramString1 = b(paramString1, paramInt1, paramLong, paramInt2, paramString2);
      if (paramString1 != null) {
        return paramString1;
      }
    }
    return new ArrayList();
  }
  
  protected List a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.TroopMsgProxy", 2, "getAIOMsgList peerUin: " + paramString + " type: " + paramInt + " , autoInit = " + paramBoolean1);
    }
    label660:
    for (;;)
    {
      Object localObject1;
      synchronized (MsgPool.a().a(paramString, paramInt))
      {
        localObject1 = (List)MsgPool.a().b().get(a(paramString, paramInt));
        if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
          break label619;
        }
        if (!paramBoolean1) {
          break label583;
        }
        List localList = d(paramString, paramInt);
        if ((localList == null) || (localList.isEmpty())) {
          break label570;
        }
        new ArrayList();
        localObject2 = MsgProxyUtils.a(localList, false);
        if ((paramBoolean2) && (paramInt == 1) && (!((List)localObject2).isEmpty()) && (((MessageRecord)((List)localObject2).get(((List)localObject2).size() - 1)).shmsgseq > this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramString, paramInt)))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString, paramInt, ((MessageRecord)((List)localObject2).get(((List)localObject2).size() - 1)).shmsgseq);
          if ((((List)localObject2).size() >= localList.size()) || (((List)localObject2).size() >= 10)) {
            continue;
          }
          long l = ((MessageRecord)((List)localObject2).get(0)).shmsgseq;
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString, paramInt) < l)
          {
            a(paramString, paramInt, true);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramString, paramInt, l);
          }
        }
        localObject1 = localObject2;
        if (MsgProxyUtils.a(paramString, paramInt, (List)localObject2))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.TroopMsgProxy", 2, "getAIOMsgList : pull more long msg");
          }
          localObject1 = MsgProxyUtils.a(localList, false, 30);
        }
        if ((MsgProxyUtils.a((List)localObject1)) || (localObject1 == null) || (((List)localObject1).isEmpty())) {
          break label660;
        }
        localObject2 = b(localList, ((MessageRecord)((List)localObject1).get(0)).shmsgseq);
        if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
        {
          localObject1 = localObject2;
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new ArrayList();
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.TroopMsgProxy", 2, "continuedList :" + ((List)localObject2).size());
          }
          MsgPool.a().b().put(a(paramString, paramInt), localObject2);
          return (List)MsgPool.a().b().get(a(paramString, paramInt));
          a(paramString, paramInt, false);
        }
      }
      Object localObject2 = b(paramString, paramInt, 15);
      if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
      {
        localObject1 = MsgProxyUtils.a((List)localObject2, false);
        continue;
        label570:
        localObject1 = a(paramString, paramInt, 15);
        continue;
        label583:
        MsgPool.a().b().remove(a(paramString, paramInt));
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.TroopMsgProxy", 2, "MsgPool.getPoolInstance().getAioMsgPool().remove :");
        }
        return null;
        label619:
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.TroopMsgProxy", 2, "getAIOMsgList from aiopool size = " + ((List)localObject1).size());
        }
      }
    }
  }
  
  protected void a(SessionInfo paramSessionInfo, String paramString, int paramInt, Set paramSet)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      paramSessionInfo = ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(paramString);
      paramString = paramSessionInfo.iterator();
      while (paramString.hasNext()) {
        paramSet.add(((TroopMemberInfo)paramString.next()).memberuin);
      }
      paramSessionInfo.clear();
      return;
    }
    paramSessionInfo = ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(45)).a(paramString);
    paramString = paramSessionInfo.iterator();
    while (paramString.hasNext()) {
      paramSet.add(((DiscussionMemberInfo)paramString.next()).memberUin);
    }
    paramSessionInfo.clear();
  }
  
  protected void a(String paramString, int paramInt, long paramLong)
  {
    b(paramString, paramInt, paramLong);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("isread", Boolean.valueOf(true));
    a(paramString, paramInt, MessageRecord.getTableName(paramString, paramInt), localContentValues, String.format("isread=? and %s<=?", new Object[] { "shmsgseq" }), new String[] { "0", String.valueOf(paramLong) }, null);
  }
  
  public void a(String paramString, int paramInt, MessageRecord paramMessageRecord, ProxyListener paramProxyListener, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    a(paramString, paramInt, paramMessageRecord, paramBoolean3);
    if (paramMessageRecord.shmsgseq <= 0L)
    {
      if (paramMessageRecord.shmsgseq < 0L) {}
      while (!MsgProxyUtils.i(paramMessageRecord.msgtype)) {
        return;
      }
    }
    a(paramString, paramInt, paramMessageRecord, paramProxyListener, paramBoolean1, paramBoolean2);
  }
  
  protected void a(String paramString, int paramInt, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.TroopMsgProxy", 2, "insertToList " + paramMessageRecord.getBaseInfoString());
    }
    for (;;)
    {
      synchronized (MsgPool.a().a(paramString, paramInt))
      {
        List localList = d(paramString, paramInt);
        String str = a(paramString, paramInt);
        if ((paramMessageRecord.isSendFromLocal()) || ((MsgProxyUtils.i(paramMessageRecord.msgtype)) && (paramMessageRecord.msgtype != -4009)))
        {
          if ((localList == null) || (localList.isEmpty()) || (((MessageRecord)localList.get(localList.size() - 1)).shmsgseq <= 0L)) {
            continue;
          }
          paramMessageRecord.shmsgseq = ((MessageRecord)localList.get(localList.size() - 1)).shmsgseq;
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.TroopMsgProxy", 2, "insertToList change seq " + paramMessageRecord.getBaseInfoString());
          }
        }
        MsgProxyUtils.a(localList, paramMessageRecord, true);
        if ((localList.size() > 40) && (!MsgProxyUtils.a(paramString))) {
          localList.remove(0);
        }
        if ((MsgPool.a().b().containsKey(str)) && (paramBoolean))
        {
          localList = (List)MsgPool.a().b().get(str);
          paramString = localList;
          if (localList == null) {
            paramString = new ArrayList();
          }
          if (paramMessageRecord.msgtype == -4009) {
            MsgProxyUtils.a(paramString, paramMessageRecord, true);
          }
        }
        else
        {
          a(paramMessageRecord);
          return;
          QLog.d("Q.msg.TroopMsgProxy", 1, "insertToList " + paramMessageRecord.getUserLogString());
          continue;
          paramMessageRecord.shmsgseq = 0L;
        }
      }
      paramString.add(paramMessageRecord);
    }
  }
  
  public void a(String paramString, int paramInt, List paramList)
  {
    synchronized (MsgPool.a().a(paramString, paramInt))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
        if (localMessageRecord.msgtype == -4004) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord.frienduin, 1, localMessageRecord.msgtype, localMessageRecord.uniseq);
        }
      }
    }
    super.a(paramString, paramInt, paramList);
  }
  
  protected void a(String paramString, int paramInt, boolean paramBoolean)
  {
    new Thread(new emh(this, paramBoolean), "report_troop_aio_break").start();
  }
  
  protected boolean a(int paramInt, long paramLong, MessageRecord paramMessageRecord)
  {
    return paramLong >= paramMessageRecord.shmsgseq;
  }
  
  protected boolean a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramString == null) {
      return false;
    }
    Iterator localIterator = ((Vector)this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a().clone()).iterator();
    while (localIterator.hasNext())
    {
      MsgQueueItem localMsgQueueItem = (MsgQueueItem)localIterator.next();
      if ((paramString.equals(localMsgQueueItem.a)) && (paramInt == localMsgQueueItem.h) && ((localMsgQueueItem.i == 1) || (localMsgQueueItem.i == 2) || ((paramBoolean) && (localMsgQueueItem.i == 0))))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.TroopMsgProxy", 2, "needTransSaveToDatabase uin=" + paramString + ", type=" + paramInt + ", hasInsertAction=" + paramBoolean + ",result=true");
        }
        return true;
      }
    }
    return super.a(paramString, paramInt, paramBoolean);
  }
  
  public MessageRecord b(String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    MessageRecord localMessageRecord = a(paramString, paramInt, paramLong1);
    int j = 0;
    if (localMessageRecord != null) {
      if (localMessageRecord.shmsgseq > 0L) {
        break label189;
      }
    }
    label189:
    for (int i = 1;; i = 0)
    {
      localMessageRecord.shmsgseq = paramLong2;
      localMessageRecord.time = paramLong3;
      if ((localMessageRecord.extraflag == 32772) || (localMessageRecord.extraflag == 32768))
      {
        localMessageRecord.extraflag = 0;
        localMessageRecord.sendFailCode = 0;
        if (!localMessageRecord.isValid)
        {
          localMessageRecord.msgtype = -2006;
          localMessageRecord.isValid = true;
        }
      }
      d(paramString, paramInt, paramLong1);
      a(paramString, paramInt, localMessageRecord);
      j = i;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.msg.TroopMsgProxy", 2, "update msgSeq set msg =" + localMessageRecord.getBaseInfoString());
        j = i;
      }
      if ((localMessageRecord == null) || (!localMessageRecord.isSendFromLocal()) || (j == 0)) {
        break;
      }
      a(paramString, paramInt, localMessageRecord, null);
      return localMessageRecord;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("shmsgseq", Long.valueOf(paramLong2));
    localContentValues.put("time", Long.valueOf(paramLong3));
    if (localMessageRecord != null)
    {
      localContentValues.put("msgtype", Integer.valueOf(localMessageRecord.msgtype));
      localContentValues.put("isValid", Boolean.valueOf(localMessageRecord.isValid));
      if (localMessageRecord.extraflag == 0)
      {
        localContentValues.put("extraflag", Integer.valueOf(0));
        localContentValues.put("sendFailCode", Integer.valueOf(0));
      }
      if (localMessageRecord.getId() > 0L)
      {
        a(paramString, paramInt, localMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(localMessageRecord.getId()) }, null);
        return localMessageRecord;
      }
      a(paramString, paramInt, localMessageRecord.versionCode, localContentValues, "uniseq=?", new String[] { String.valueOf(paramLong1) }, null);
      return localMessageRecord;
    }
    a(paramString, paramInt, 3, localContentValues, "uniseq=?", new String[] { String.valueOf(paramLong1) }, null);
    return localMessageRecord;
  }
  
  protected String b(String paramString, int paramInt)
  {
    return "select * from " + MessageRecord.getTableName(paramString, paramInt) + " order by shmsgseq desc , _id desc limit " + 40;
  }
  
  protected List b(List paramList, long paramLong)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = paramList.size() - 1;
    if (i >= 0)
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.get(i);
      if (localMessageRecord.shmsgseq >= paramLong) {}
      for (;;)
      {
        i -= 1;
        break;
        if ((localMessageRecord.isValid) && (localMessageRecord.msgtype != -2006))
        {
          long l = localMessageRecord.shmsgseq;
          localArrayList.add(0, localMessageRecord);
        }
      }
    }
    return localArrayList;
  }
  
  protected void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.c();
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.d();
    SQLiteDatabase localSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    String[] arrayOfString = localSQLiteDatabase.b();
    if (arrayOfString == null) {
      return;
    }
    int i = 0;
    while (i < arrayOfString.length)
    {
      String str1 = arrayOfString[i];
      Object localObject1;
      if ((str1.startsWith("mr_discusssion")) || (str1.startsWith("mr_troop")))
      {
        localObject1 = "select frienduin, istroop, shmsgseq as tmpseq, issend from " + str1 + " where shmsgseq=(select max(shmsgseq) from " + str1 + ")";
        if (localObject1 != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("", 2, "sql zsw =" + (String)localObject1);
          }
          localObject1 = localSQLiteDatabase.a((String)localObject1, null);
          if (localObject1 == null) {}
        }
      }
      try
      {
        if (((Cursor)localObject1).getCount() > 0)
        {
          ((Cursor)localObject1).moveToFirst();
          long l = ((Cursor)localObject1).getLong(((Cursor)localObject1).getColumnIndexOrThrow("tmpseq"));
          String str2 = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndexOrThrow("frienduin"));
          int j = ((Cursor)localObject1).getInt(((Cursor)localObject1).getColumnIndexOrThrow("istroop"));
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str2, j, l);
        }
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
        localSQLiteDatabase.a(str1, null, null);
        i += 1;
      }
      finally
      {
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAndDiscMsgProxy
 * JD-Core Version:    0.7.0.1
 */