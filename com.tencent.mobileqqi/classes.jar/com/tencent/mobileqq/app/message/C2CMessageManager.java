package com.tencent.mobileqq.app.message;

import android.os.Bundle;
import android.util.Pair;
import com.tencent.biz.pubaccount.assistant.PubAccountAssistantManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.remind.RemindHelper;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.systemmsg.SystemMsgController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class C2CMessageManager
  extends BaseMessageManager
{
  public C2CMessageManager(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade)
  {
    super(paramQQAppInterface, paramQQMessageFacade);
  }
  
  private MessageRecord a(MessageRecord paramMessageRecord)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramMessageRecord.istroop).a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.time, paramMessageRecord.senderuin, paramMessageRecord.msg);
  }
  
  private ArrayList a(String paramString, List paramList1, List paramList2, long paramLong1, long paramLong2)
  {
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("C2CMsgFilter basetime=" + paramLong1 + ",lowtime=" + paramLong2, "");
    if ((paramList1 == null) || (paramList1.isEmpty())) {
      return localArrayList;
    }
    Object localObject1 = paramList1.iterator();
    long l1 = -1L;
    long l2 = 9223372036854775807L;
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (MessageRecord)((Iterator)localObject1).next();
      if (l2 < ((MessageRecord)localObject2).time) {
        break label768;
      }
      l2 = ((MessageRecord)localObject2).time;
    }
    label768:
    for (;;)
    {
      if (l1 <= ((MessageRecord)localObject2).time) {
        l1 = ((MessageRecord)localObject2).time;
      }
      for (;;)
      {
        break;
        localObject2 = b(paramString, 0, l2 - 30L, l1 + 30L);
        MessageRecord localMessageRecord1;
        MessageRecord localMessageRecord2;
        if (paramList2 == null)
        {
          localObject1 = null;
          localMessageRecord1 = MessageRecordFactory.a(-1000);
          localMessageRecord2 = MessageRecordFactory.a(-1000);
          paramList1 = paramList1.iterator();
        }
        label391:
        label763:
        for (;;)
        {
          MessageRecord localMessageRecord3;
          boolean bool;
          if (paramList1.hasNext())
          {
            localMessageRecord3 = (MessageRecord)paramList1.next();
            localMessageRecord3.time -= 30L;
            localMessageRecord3.time += 30L;
            Object localObject3 = a((List)localObject2, localMessageRecord1.time, localMessageRecord2.time);
            if ((localObject2 == null) || (((List)localObject2).size() == 0))
            {
              localArrayList.add(localMessageRecord3);
              if (localObject1 == null) {
                continue;
              }
              ((List)localObject1).add(localMessageRecord3);
              continue;
              localObject1 = new ArrayList();
              break;
            }
            Object localObject4 = ((List)localObject3).iterator();
            for (;;)
            {
              if (((Iterator)localObject4).hasNext())
              {
                localObject3 = (MessageRecord)((Iterator)localObject4).next();
                if (MsgProxyUtils.a((MessageRecord)localObject3, localMessageRecord3, true)) {
                  if (QLog.isColorLevel())
                  {
                    localObject4 = new StringBuilder().append("C2CMsgFilter shmsgseq equals?");
                    if (localMessageRecord3.shmsgseq == ((MessageRecord)localObject3).shmsgseq)
                    {
                      bool = true;
                      QLog.i("Q.msg.BaseMessageManager", 2, bool + ",msg=" + localMessageRecord3.getLogColorContent() + "time:" + localMessageRecord3.time + "<->" + ((MessageRecord)localObject3).time + ", type=" + ((MessageRecord)localObject3).msgtype + "-" + localMessageRecord3.msgtype);
                    }
                  }
                  else if ((localObject1 != null) && (paramLong1 != -1L) && (((MessageRecord)localObject3).time <= paramLong1))
                  {
                    ((List)localObject1).add(localObject3);
                  }
                }
              }
            }
          }
          for (int i = 1;; i = 0)
          {
            if (i != 0) {
              break label763;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageManager", 2, "C2CMsgFilter not eq: msg=" + localMessageRecord3.getLogColorContent() + "time:" + localMessageRecord3.time + ",type:" + localMessageRecord3.msgtype + ",msg.con : " + localMessageRecord3.getLogColorContent());
            }
            if (localObject1 != null) {
              ((List)localObject1).add(localMessageRecord3);
            }
            localArrayList.add(localMessageRecord3);
            break;
            bool = false;
            break label391;
            if ((paramLong1 > 0L) && (localObject1 != null))
            {
              localMessageRecord1.time = paramLong2;
              localMessageRecord2.time = paramLong1;
              paramString = b(paramString, 0, paramLong2, paramLong1).iterator();
              while (paramString.hasNext())
              {
                paramList1 = (MessageRecord)paramString.next();
                if ((!MsgProxyUtils.b(paramList1.msgtype)) && (paramList1.time <= paramLong1))
                {
                  this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("addmsg ptt = " + paramList1.getId(), "");
                  MsgProxyUtils.b((List)localObject1, paramList1, true);
                }
              }
            }
            if (paramList2 != null) {
              paramList2.addAll((Collection)localObject1);
            }
            return localArrayList;
          }
        }
      }
    }
  }
  
  private List a(String paramString, List paramList, long paramLong1, long paramLong2)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = a(paramString, paramList, localArrayList, paramLong1, paramLong2);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("needSave", paramString);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("msgInDB", localArrayList);
    if ((paramString != null) && (!paramString.isEmpty())) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(((MessageRecord)paramString.get(0)).istroop).a(paramString, null);
    }
    paramList = paramString.iterator();
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord1 = (MessageRecord)paramList.next();
      if (localMessageRecord1.getId() < 0L)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("refresh C2C insert db error ! , mr.seq = " + localMessageRecord1.shmsgseq + " , mr.uniseq = " + localMessageRecord1.uniseq + ", mr.uid=" + localMessageRecord1.msgUid, "mr.msg = " + localMessageRecord1.getLogColorContent());
        MessageRecord localMessageRecord2 = a(localMessageRecord1);
        if (localMessageRecord2 == null)
        {
          localArrayList.remove(localMessageRecord1);
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("refresh C2C insert db error ! , m.seq = " + localMessageRecord2.shmsgseq + " , mr.uniseq = " + localMessageRecord2.uniseq + ", m.uid=" + localMessageRecord2.msgUid, "");
          localArrayList.set(localArrayList.indexOf(localMessageRecord1), localMessageRecord2);
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("refresh C2C roam step 3 , mr.seq = " + localMessageRecord1.shmsgseq + " , mr.uniseq = " + localMessageRecord1.uniseq, "mr.msg = " + localMessageRecord1.getLogColorContent());
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("setC2CRoamMessageResult needsave=" + paramString.size(), "");
    return localArrayList;
  }
  
  private List a(List paramList, long paramLong1, long paramLong2)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.isEmpty())) {
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      if ((localMessageRecord.time > paramLong1) && (localMessageRecord.time < paramLong2)) {
        localArrayList.add(localMessageRecord);
      }
    }
    return localArrayList;
  }
  
  private List b(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    return a(paramString, paramInt, Math.min(paramLong1, paramLong2), Math.max(paramLong1, paramLong2));
  }
  
  public long a(MessageRecord paramMessageRecord)
  {
    return paramMessageRecord.time;
  }
  
  List a(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).b(paramString, paramInt);
    ArrayList localArrayList = new ArrayList();
    if (localObject != null) {
      localObject = ((List)localObject).iterator();
    }
    for (;;)
    {
      MessageRecord localMessageRecord;
      if (((Iterator)localObject).hasNext())
      {
        localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if ((localMessageRecord.time < paramLong1) || (localMessageRecord.time > paramLong2)) {}
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "getTempListFromDB fromCache=" + localArrayList.size());
        }
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a(paramString, paramInt, paramLong2, -1, String.format("time>=%d or time=%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "getTempListFromDB from=" + paramLong1 + ",to=" + paramLong2 + ",size=" + paramString.size());
        }
        paramString = MsgProxyUtils.a(localArrayList, paramString).iterator();
        while (paramString.hasNext()) {
          MsgProxyUtils.b(localArrayList, (MessageRecord)paramString.next(), false);
        }
      }
      localArrayList.add(localMessageRecord);
    }
    return localArrayList;
  }
  
  public void a(MessageRecord paramMessageRecord, EntityManager paramEntityManager, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, BaseMessageManager.AddMessageContext paramAddMessageContext)
  {
    if (paramMessageRecord == null) {
      return;
    }
    Map localMap = paramAddMessageContext.jdField_a_of_type_JavaUtilMap;
    FriendManager localFriendManager = paramAddMessageContext.jdField_a_of_type_ComTencentMobileqqModelFriendManager;
    RecentUserProxy localRecentUserProxy = paramAddMessageContext.jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy;
    ConversationFacade localConversationFacade = paramAddMessageContext.jdField_a_of_type_ComTencentMobileqqAppMessageConversationFacade;
    if (paramMessageRecord.time == 0L) {
      paramMessageRecord.time = MessageCache.a();
    }
    if (paramMessageRecord.msgseq == 0L) {
      paramMessageRecord.msgseq = ((int)paramMessageRecord.time);
    }
    String str1 = paramMessageRecord.frienduin;
    String str2 = paramMessageRecord.senderuin;
    int i = paramMessageRecord.istroop;
    long l = paramMessageRecord.time;
    Object localObject2;
    Object localObject1;
    if ((i != 3000) && (i != 1))
    {
      localObject2 = paramMessageRecord.frienduin;
      localObject1 = localObject2;
      if (String.valueOf(AppConstants.V).equals(localObject2)) {
        localObject1 = paramMessageRecord.senderuin;
      }
      if ((i != 1009) && (localConversationFacade.a((String)localObject1, 1009)))
      {
        localConversationFacade.a(AppConstants.N, 1009, (String)localObject1, paramMessageRecord.istroop);
        a(AppConstants.N, 1009, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      }
      if ((i != 1001) && (localConversationFacade.a((String)localObject1, 1001)))
      {
        localConversationFacade.a(AppConstants.V, 1001, (String)localObject1, paramMessageRecord.istroop);
        a(AppConstants.V, 1001, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      }
    }
    if ((paramMessageRecord.istroop == 1009) && (!localFriendManager.b(str1)) && (!localConversationFacade.a(str1)) && (!localMap.containsKey(MsgProxyUtils.a(paramMessageRecord.frienduin, paramMessageRecord.istroop))))
    {
      localObject1 = MessageRecordFactory.a(paramMessageRecord.msgtype);
      MessageRecord.copyMessageRecordBaseField((MessageRecord)localObject1, paramMessageRecord);
      ((MessageRecord)localObject1).senderuin = paramMessageRecord.frienduin;
      ((MessageRecord)localObject1).frienduin = AppConstants.N;
      ((MessageRecord)localObject1).istroop = 1009;
      str1 = ((MessageRecord)localObject1).frienduin;
      i = ((MessageRecord)localObject1).istroop;
      l = ((MessageRecord)localObject1).time;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramMessageRecord.istroop).a(str1, i, ((MessageRecord)localObject1).senderuin, ((MessageRecord)localObject1).selfuin);
      a((MessageRecord)localObject1, null, false, true, 1);
    }
    for (;;)
    {
      if (((paramMessageRecord instanceof MessageForVideo)) && (paramMessageRecord.istroop != 3000) && (paramMessageRecord.istroop != 1))
      {
        localObject1 = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
        ((QCallFacade)localObject1).a((MessageForVideo)paramMessageRecord, false);
        ((QCallFacade)localObject1).a((MessageForVideo)paramMessageRecord);
      }
      localObject2 = localRecentUserProxy.a(str1, paramMessageRecord.istroop);
      localObject1 = localObject2;
      if (localMap.containsKey(MsgProxyUtils.a(((RecentUser)localObject2).uin, ((RecentUser)localObject2).type))) {
        localObject1 = (RecentUser)localMap.get(MsgProxyUtils.a(((RecentUser)localObject2).uin, ((RecentUser)localObject2).type));
      }
      if ((!MsgProxyUtils.d(paramMessageRecord.msgtype)) && ((i != 1008) || (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(localFriendManager, str1)))) {
        break label1437;
      }
      label557:
      super.a(paramMessageRecord, paramEntityManager, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramAddMessageContext);
      return;
      if (String.valueOf(AppConstants.V).equals(paramMessageRecord.frienduin))
      {
        if ((localConversationFacade.a(paramMessageRecord.senderuin)) || (localFriendManager.b(paramMessageRecord.senderuin)) || (localMap.containsKey(MsgProxyUtils.a(paramMessageRecord.senderuin, paramMessageRecord.istroop))))
        {
          str1 = paramMessageRecord.senderuin;
          paramMessageRecord.frienduin = paramMessageRecord.senderuin;
        }
        else
        {
          localObject1 = MessageRecordFactory.a(paramMessageRecord.msgtype);
          MessageRecord.copyMessageRecordBaseField((MessageRecord)localObject1, paramMessageRecord);
          ((MessageRecord)localObject1).frienduin = ((MessageRecord)localObject1).senderuin;
          ((MessageRecord)localObject1).istroop = 1001;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(((MessageRecord)localObject1).istroop).a(AppConstants.V, 1001, paramMessageRecord.senderuin, paramMessageRecord.selfuin);
          a((MessageRecord)localObject1, null, false, true, 1);
        }
      }
      else if ((paramMessageRecord.istroop == 1001) && (MsgProxyUtils.a(paramMessageRecord.istroop, paramMessageRecord.msgtype)) && (!localFriendManager.b(str1)) && (!localConversationFacade.a(str1)) && (!localMap.containsKey(MsgProxyUtils.a(paramMessageRecord.frienduin, paramMessageRecord.istroop))))
      {
        localObject1 = MessageRecordFactory.a(paramMessageRecord.msgtype);
        MessageRecord.copyMessageRecordBaseField((MessageRecord)localObject1, paramMessageRecord);
        ((MessageRecord)localObject1).senderuin = paramMessageRecord.frienduin;
        ((MessageRecord)localObject1).frienduin = AppConstants.V;
        ((MessageRecord)localObject1).istroop = 1001;
        str1 = ((MessageRecord)localObject1).frienduin;
        i = ((MessageRecord)localObject1).istroop;
        l = ((MessageRecord)localObject1).time;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramMessageRecord.istroop).a(AppConstants.V, 1001, paramMessageRecord.frienduin, paramMessageRecord.selfuin);
        a((MessageRecord)localObject1, null, false, true, 1);
      }
      else
      {
        if (!String.valueOf(AppConstants.U).equals(paramMessageRecord.frienduin)) {
          break;
        }
        if ((SystemMsgController.a().a() == null) && (SystemMsgController.a().a())) {
          SystemMsgController.a().a((MessageForSystemMsg)paramMessageRecord);
        }
        if (!(paramMessageRecord instanceof MessageForSystemMsg)) {
          break label1679;
        }
        localObject1 = ((MessageForSystemMsg)paramMessageRecord).getSystemMsg();
        if (localObject1 != null) {
          paramMessageRecord.time = ((structmsg.StructMsg)localObject1).msg_time.get();
        }
        l = paramMessageRecord.time;
      }
    }
    if (String.valueOf(AppConstants.Z).equals(paramMessageRecord.frienduin))
    {
      if (!(paramMessageRecord instanceof MessageForSystemMsg)) {
        break label1682;
      }
      localObject1 = ((MessageForSystemMsg)paramMessageRecord).getSystemMsg();
      if (localObject1 != null) {
        paramMessageRecord.time = ((structmsg.StructMsg)localObject1).msg_time.get();
      }
      l = paramMessageRecord.time;
    }
    label1679:
    label1682:
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
      int m = FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      int k;
      int j;
      if (m > 0)
      {
        k = 0;
        j = k;
        if (!paramMessageRecord.isSendFromLocal())
        {
          j = k;
          if (paramMessageRecord.time < ((QQMessageFacade.Message)localObject1).time) {
            j = 1;
          }
        }
        if (j == 0)
        {
          MessageRecord.copyMessageRecordBaseField((MessageRecord)localObject1, paramMessageRecord);
          ((QQMessageFacade.Message)localObject1).msgData = paramMessageRecord.msgData;
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b((QQMessageFacade.Message)localObject1);
          a((QQMessageFacade.Message)localObject1);
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().unReadNum = m;
        }
      }
      for (;;)
      {
        break;
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b(null);
      }
      if (String.valueOf(AppConstants.aa).equals(paramMessageRecord.frienduin))
      {
        if ((paramMessageRecord instanceof MessageForSystemMsg))
        {
          localObject1 = ((MessageForSystemMsg)paramMessageRecord).getSystemMsg();
          if (localObject1 != null) {
            paramMessageRecord.time = ((structmsg.StructMsg)localObject1).msg_time.get();
          }
          l = paramMessageRecord.time;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
        m = GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (m > 0)
        {
          k = 0;
          j = k;
          if (!paramMessageRecord.isSendFromLocal())
          {
            j = k;
            if (paramMessageRecord.time < ((QQMessageFacade.Message)localObject1).time) {
              j = 1;
            }
          }
          if (j == 0)
          {
            MessageRecord.copyMessageRecordBaseField((MessageRecord)localObject1, paramMessageRecord);
            ((QQMessageFacade.Message)localObject1).msgData = paramMessageRecord.msgData;
            this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b((QQMessageFacade.Message)localObject1);
            a((QQMessageFacade.Message)localObject1);
            this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().unReadNum = m;
          }
        }
        for (;;)
        {
          break;
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b(null);
        }
      }
      if (AppConstants.S.equals(paramMessageRecord.frienduin))
      {
        try
        {
          localObject1 = paramEntityManager.a(MessageRecord.class, paramMessageRecord.getTableName(), false, null, null, null, null, null, null);
          if (localObject1 != null)
          {
            localObject1 = ((List)localObject1).iterator();
            while (((Iterator)localObject1).hasNext()) {
              paramEntityManager.b((MessageRecord)((Iterator)localObject1).next());
            }
          }
        }
        finally {}
        break;
        label1437:
        if ((i == 1008) && (!paramMessageRecord.isSendFromLocal()) && (!paramMessageRecord.isread) && (str1.equals(AppConstants.L)))
        {
          ((RecentUser)localObject1).uin = str1;
          ((RecentUser)localObject1).type = i;
          ((RecentUser)localObject1).lastmsgtime = 9223372036854775806L;
          localMap.put(MsgProxyUtils.a(str1, i), localObject1);
          break label557;
        }
        if ((i == 1009) && (str1.equals(AppConstants.N)))
        {
          if (l > ((RecentUser)localObject1).lastmsgtime) {
            ((RecentUser)localObject1).lastmsgtime = l;
          }
          localRecentUserProxy.a((RecentUser)localObject1);
          break label557;
        }
        if (PubAccountAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1))
        {
          paramAddMessageContext.d.put(MsgProxyUtils.a(str1, i), paramMessageRecord);
          break label557;
        }
        ((RecentUser)localObject1).uin = str1;
        if ((i == 1000) || (i == 1020) || (i == 1004)) {
          ((RecentUser)localObject1).troopUin = str2;
        }
        ((RecentUser)localObject1).type = i;
        if (l > ((RecentUser)localObject1).lastmsgtime) {
          ((RecentUser)localObject1).lastmsgtime = l;
        }
        localMap.put(MsgProxyUtils.a(str1, i), localObject1);
        break label557;
      }
      break;
    }
  }
  
  protected void a(String paramString, int paramInt, long paramLong)
  {
    super.a(paramString, paramInt, paramLong);
    if ((1008 == paramInt) && (AppConstants.L.equals(paramString)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt) <= 0)) {
      RemindHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  public void a(String paramString, int paramInt, List paramList1, List paramList2, Bundle paramBundle)
  {
    boolean bool1 = paramBundle.getBoolean("success");
    boolean bool2 = paramBundle.getBoolean("complete");
    List localList = (List)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramBundle.getInt("counter")));
    paramBundle.putBoolean("timeout", false);
    long l1 = paramBundle.getLong("baseTime");
    long l2 = paramBundle.getLong("lowTime");
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade;
    Object localObject = new StringBuilder().append("setC2CRoamMessageResult success=").append(bool1).append(",complete=").append(bool2).append(",res_size=");
    if (paramList1 == null)
    {
      paramInt = -1;
      paramBundle.a(paramInt + ",baseT=" + l1 + ",lowTime=" + l2, "");
      if (paramList1 != null) {
        break label526;
      }
    }
    label526:
    for (paramBundle = new ArrayList();; paramBundle = paramList1)
    {
      paramList1 = paramList2;
      if (paramList2 == null) {
        paramList1 = new ArrayList();
      }
      if (bool1)
      {
        paramList2 = a(paramString, paramBundle, l1, l2);
        if ((localList != null) && (!localList.isEmpty()))
        {
          l1 = ((MessageRecord)localList.get(0)).time;
          paramString = new ArrayList();
          paramBundle = localList.iterator();
          for (;;)
          {
            if (paramBundle.hasNext())
            {
              localObject = (MessageRecord)paramBundle.next();
              if (((MessageRecord)localObject).time == l1)
              {
                paramString.add(localObject);
                continue;
                paramInt = paramList1.size();
                break;
              }
            }
          }
          paramList2 = paramList2.iterator();
          paramInt = 0;
          if (!paramList2.hasNext()) {
            break label446;
          }
          paramBundle = (MessageRecord)paramList2.next();
          localObject = paramString.iterator();
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
          } while (!MsgProxyUtils.a((MessageRecord)((Iterator)localObject).next(), paramBundle, true));
        }
      }
      for (int j = 1;; j = 0)
      {
        int i = paramInt;
        if (localList != null)
        {
          i = paramInt;
          if (j == 0)
          {
            localList.add(paramInt, paramBundle);
            i = paramInt + 1;
            paramList1.add(paramBundle);
          }
        }
        paramInt = i;
        break;
        if (localList != null) {
          localList.addAll(paramList2);
        }
        label446:
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade;
        paramList1 = new StringBuilder().append("setC2CRoamMessageResult locallist:");
        if (localList == null) {}
        for (paramInt = -1;; paramInt = localList.size())
        {
          paramString.a(paramInt, "");
          if (localList != null) {}
          try
          {
            localList.notify();
            return;
          }
          finally {}
        }
      }
    }
  }
  
  protected void b(String paramString, int paramInt)
  {
    super.b(paramString, paramInt);
    if ((1008 == paramInt) && (AppConstants.L.equals(paramString))) {
      RemindHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  public void b(String paramString, int paramInt1, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext)
  {
    if (paramInt1 != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "refreshMessageListHead TYPE ERROR! TYPE = " + paramInt1);
      }
      paramRefreshMessageContext.jdField_a_of_type_Boolean = true;
      paramRefreshMessageContext.jdField_a_of_type_JavaUtilList = null;
      a(paramRefreshMessageContext, paramInt1);
      return;
    }
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).e(paramString, paramInt1);
    if ((localObject3 == null) || (((List)localObject3).isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead ERROR: AIO is closed !!");
      }
      paramRefreshMessageContext.jdField_a_of_type_JavaUtilList = null;
      a(paramRefreshMessageContext, paramInt1);
      return;
    }
    if (localObject3 != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("current Aio", ((List)localObject3).subList(0, Math.min(15, ((List)localObject3).size())));
    }
    long l2 = ((MessageRecord)((List)localObject3).get(0)).uniseq;
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString);
    long l1;
    Object localObject4;
    ArrayList localArrayList;
    int i;
    if (localObject1 == null)
    {
      l1 = 0L;
      localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).b(paramString, paramInt1);
      localArrayList = new ArrayList();
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("refreshC2CMessageListHead isLocalOnly=" + paramRefreshMessageContext.c + ",uniseq=" + l2 + ",ect=" + l1, " ,getC2CRoamingSetting" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f());
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f() == 0) {
        paramRefreshMessageContext.c = true;
      }
      i = 0;
      label309:
      if (i >= ((List)localObject3).size()) {
        break label2580;
      }
      if (((MessageRecord)((List)localObject3).get(i)).uniseq != l2) {
        break label561;
      }
      label342:
      if (i >= ((List)localObject3).size()) {
        break label2574;
      }
      if (!MsgProxyUtils.b(((MessageRecord)((List)localObject3).get(i)).msgtype)) {
        break label552;
      }
      l2 = ((MessageRecord)((List)localObject3).get(i)).uniseq;
      i = 1;
    }
    for (;;)
    {
      if ((paramRefreshMessageContext.c) || (l1 == 0L) || (i == 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString, paramInt1, l2, paramInt2, paramRefreshMessageContext, localArrayList);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, localArrayList);
        paramRefreshMessageContext.jdField_a_of_type_JavaUtilList = localArrayList;
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade;
        localObject1 = new StringBuilder().append("refresh load local C2C msg only FIN , context = ").append(paramRefreshMessageContext).append(", size = ");
        if (localArrayList == null) {}
        for (paramInt1 = -1;; paramInt1 = localArrayList.size())
        {
          paramString.a(paramInt1, ", timestamp = " + System.currentTimeMillis());
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramRefreshMessageContext);
          return;
          l1 = ((Long)((Pair)localObject1).first).longValue();
          break;
          label552:
          i += 1;
          break label342;
          label561:
          i += 1;
          break label309;
        }
      }
      i = 0;
      if (i < ((List)localObject4).size())
      {
        localObject1 = (MessageRecord)((List)localObject4).get(i);
        if (((MessageRecord)localObject1).uniseq != l2) {}
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead cacheIndex:" + i + ", itemList:" + ((List)localObject4).size());
        }
        long l3;
        if (localObject1 == null)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, l2);
          if (localObject1 == null)
          {
            this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("refresh from empty C2C msg", "");
            paramRefreshMessageContext.jdField_a_of_type_Boolean = true;
            paramRefreshMessageContext.c = true;
            paramRefreshMessageContext.jdField_a_of_type_JavaUtilList = new ArrayList();
            this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramRefreshMessageContext);
            return;
            i += 1;
            break;
          }
          l3 = ((MessageRecord)localObject1).time;
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("refreshC2CMessageListHead uniseq=" + l2 + ", aioBase.getId():" + ((MessageRecord)localObject1).getId(), "");
          localArrayList.addAll(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, l3, paramInt2, String.format("time>=%d or (time=%d and _id<%d)", new Object[] { Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(((MessageRecord)localObject1).getId()) })));
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("refreshC2CMessageListHead Db fromTime:" + l3, "");
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("only load in db", localArrayList);
          l2 = l3;
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead locallist size " + localArrayList.size());
          }
          if (l1 <= l2) {
            break label2559;
          }
          l1 = Math.min(l2, paramRefreshMessageContext.jdField_a_of_type_Long);
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("ect > fromTime!! newEct:" + l1, "");
        }
        label2260:
        label2559:
        for (boolean bool1 = false;; bool1 = true)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("before pull locallist", localArrayList);
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("before pull locallist" + localArrayList.size(), "");
          if (localArrayList.size() < paramInt2)
          {
            localObject4 = new Bundle();
            i = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
            ((Bundle)localObject4).putInt("counter", i);
            ((Bundle)localObject4).putBoolean("timeout", true);
            ((Bundle)localObject4).putLong("UIN", Long.valueOf(paramString).longValue());
            ((Bundle)localObject4).putBoolean("canUpdateEct", bool1);
            this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(i), localArrayList);
            Object localObject5 = new ArrayList();
            i = 0;
            Object localObject6;
            while (i < ((List)localObject3).size())
            {
              localObject6 = (MessageRecord)((List)localObject3).get(i);
              if (((MessageRecord)localObject6).time == ((MessageRecord)localObject1).time)
              {
                ((ArrayList)localObject5).add(localObject6);
                i += 1;
                continue;
                l2 = ((MessageRecord)localObject1).time;
                if (i >= paramInt2)
                {
                  j = i - paramInt2;
                  while (j < i)
                  {
                    localObject5 = (MessageRecord)((List)localObject4).get(j);
                    if (((MessageRecord)localObject5).time >= l1) {
                      localArrayList.add(localObject5);
                    }
                    j += 1;
                  }
                  this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("all in cache", localArrayList);
                }
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead fromTime:" + l2);
                  }
                  break;
                  localObject5 = (MessageRecord)((List)localObject4).get(0);
                  localObject4 = ((List)localObject4).subList(0, i).iterator();
                  while (((Iterator)localObject4).hasNext())
                  {
                    localObject6 = (MessageRecord)((Iterator)localObject4).next();
                    if (((MessageRecord)localObject6).time >= l1) {
                      localArrayList.add(localObject6);
                    }
                  }
                  this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("cache part", localArrayList);
                  i = paramInt2 - localArrayList.size();
                  localArrayList.addAll(0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, ((MessageRecord)localObject5).time, i, String.format("time>=%d or (time=%d and _id<%d)", new Object[] { Long.valueOf(l1), Long.valueOf(((MessageRecord)localObject5).time), Long.valueOf(((MessageRecord)localObject5).getId()) })));
                  this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("cache + db", localArrayList);
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead memdb:size:" + localArrayList.size() + ",miss:" + i);
                  }
                }
              }
            }
            l2 = ((MessageRecord)localObject1).uniseq;
            i = localArrayList.size();
            if (localArrayList.isEmpty()) {
              i = paramInt2;
            }
            for (;;)
            {
              ((Bundle)localObject4).putLong("baseTime", l1);
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "pull roam " + i + ",time=" + l1 + ",timeFilterList:" + ((ArrayList)localObject5).size());
              }
              l3 = 0L;
              if (!bool1) {
                l3 = paramRefreshMessageContext.b;
              }
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, l1, (short)i, (Bundle)localObject4, l3);
              ((Bundle)localObject4).putInt("size_req", i);
              this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b.put(MsgProxyUtils.a(paramString, paramInt1), Boolean.valueOf(false));
              try
              {
                localArrayList.wait(35000L);
                if ((this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b.containsKey(MsgProxyUtils.a(paramString, paramInt1))) && (((Boolean)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b.get(MsgProxyUtils.a(paramString, paramInt1))).booleanValue()))
                {
                  paramRefreshMessageContext.jdField_a_of_type_JavaUtilList = null;
                  this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("get auto pull C2C msg when pull refresh !", ", timestamp = " + System.currentTimeMillis());
                  this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramRefreshMessageContext);
                  return;
                  i = paramInt2 - i;
                }
              }
              catch (InterruptedException localInterruptedException)
              {
                for (;;)
                {
                  localInterruptedException.printStackTrace();
                }
              }
              finally {}
            }
            if (((Bundle)localObject4).getBoolean("timeout")) {
              QLog.w("Q.msg.BaseMessageManager", 2, "timeout!");
            }
            this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("after pull locallist" + localArrayList.size(), "");
            this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("after pull locallist", localArrayList);
            localObject2 = new ArrayList();
            int j = localArrayList.size() - 1;
            while (j >= 0)
            {
              localObject3 = (MessageRecord)localArrayList.get(j);
              localObject6 = ((ArrayList)localObject5).iterator();
              while (((Iterator)localObject6).hasNext())
              {
                MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject6).next();
                if (MsgProxyUtils.a(localMessageRecord, (MessageRecord)localObject3, true))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead filterMr " + localMessageRecord.getLogColorContent() + ",uniseq=" + localMessageRecord.uniseq);
                  }
                  ((ArrayList)localObject2).add(localObject3);
                }
                else if (QLog.isColorLevel())
                {
                  QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead not find filterMr " + localMessageRecord.getLogColorContent() + ",mr=" + ((MessageRecord)localObject3).getLogColorContent());
                }
              }
              j -= 1;
            }
            localArrayList.removeAll((Collection)localObject2);
            if (((Bundle)localObject4).getBoolean("timeout")) {
              break label2487;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead " + localArrayList.size());
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, l2, localArrayList);
            boolean bool2 = ((Bundle)localObject4).getBoolean("success");
            boolean bool3 = ((Bundle)localObject4).getBoolean("complete");
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.BaseMessageManager", 2, "success ?" + bool2 + ", complete?" + bool3);
            }
            if ((!bool2) || (bool3))
            {
              paramRefreshMessageContext.c = true;
              if (!localArrayList.isEmpty()) {
                break label2459;
              }
              if (!localArrayList.isEmpty()) {
                break label2476;
              }
              this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString, paramInt1, l2, paramInt2, paramRefreshMessageContext, localArrayList);
            }
            if (!bool1)
            {
              paramRefreshMessageContext.jdField_a_of_type_Long = ((Bundle)localObject4).getLong("tempEct");
              paramRefreshMessageContext.b = ((Bundle)localObject4).getLong("tempRandom");
              this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("update tempEct:" + paramRefreshMessageContext.jdField_a_of_type_Long + ", rand=" + paramRefreshMessageContext.b, "");
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, localArrayList);
          paramRefreshMessageContext.jdField_a_of_type_JavaUtilList = localArrayList;
          paramString = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade;
          localObject2 = new StringBuilder().append("refresh C2C finish , context = ").append(paramRefreshMessageContext).append(" , size = ");
          if (localArrayList == null) {}
          for (paramInt1 = -1;; paramInt1 = localArrayList.size())
          {
            paramString.a(paramInt1, ", timestamp = " + System.currentTimeMillis());
            this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramRefreshMessageContext);
            return;
            l2 = ((MessageRecord)localArrayList.get(0)).uniseq;
            break;
            paramInt2 -= localArrayList.size();
            break label2260;
            this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("pull timeout", "");
            paramRefreshMessageContext.c = true;
            if (localArrayList.isEmpty()) {}
            for (;;)
            {
              this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString, paramInt1, l2, i, paramRefreshMessageContext, localArrayList);
              break;
              l2 = ((MessageRecord)localArrayList.get(0)).uniseq;
            }
          }
        }
        label2459:
        label2476:
        label2487:
        i = 0;
        Object localObject2 = null;
      }
      label2574:
      i = 0;
      continue;
      label2580:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.C2CMessageManager
 * JD-Core Version:    0.7.0.1
 */