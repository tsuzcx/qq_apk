package com.tencent.mobileqq.app.message;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarData;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.contact.troop.TroopNotificationUtils;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.ChatHistorySearchData;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.DraftTextInfo;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.NeedHandleUserData;
import com.tencent.mobileqq.data.PubAccountAssistantData;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.Sqlite;
import com.tencent.mobileqq.data.TransFileInfo;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.managers.DraftTextManager;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.TroopAndDiscMsgProxy;
import com.tencent.mobileqq.troop.data.TroopMessageManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import dag;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.manager.Manager;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq.UinPairReadInfo;
import msf.msgsvc.msg_svc.PbDiscussReadedReportReq;
import msf.msgsvc.msg_svc.PbGroupReadedReportReq;
import msf.msgsvc.msg_svc.PbMsgReadedReportReq;

public class QQMessageFacade
  extends Observable
  implements Manager
{
  public static final int a = 1;
  public static final String a = "dataline_manager";
  public static final boolean a = true;
  public static final int b = 2;
  public static final String b = "notification";
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 2;
  public static final int f = 4;
  public static final int g = 5;
  public static final int h = 6;
  public static final int i = 7;
  public static final int j = 8;
  private static final int l = 5000;
  private static final int m = 90;
  private static final int n = 8;
  public Handler a;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private BaseMessageManager jdField_a_of_type_ComTencentMobileqqAppMessageBaseMessageManager;
  private QQMessageFacade.Message jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message;
  private DraftTextManager jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public final List a;
  public final Map a;
  public final ConcurrentHashMap a;
  public final AtomicInteger a;
  private BaseMessageManager jdField_b_of_type_ComTencentMobileqqAppMessageBaseMessageManager;
  public Map b;
  public final ConcurrentHashMap b;
  private volatile boolean jdField_b_of_type_Boolean = false;
  private BaseMessageManager jdField_c_of_type_ComTencentMobileqqAppMessageBaseMessageManager;
  private String jdField_c_of_type_JavaLangString = null;
  private Map jdField_c_of_type_JavaUtilMap = new ConcurrentHashMap();
  private final String jdField_d_of_type_JavaLangString = "Q.msg.QQMessageFacade";
  private final Map jdField_d_of_type_JavaUtilMap = new HashMap();
  private int k = -1;
  private volatile int o = -1;
  
  public QQMessageFacade(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager = DraftTextManager.a(paramQQAppInterface);
    a();
  }
  
  private int a(int paramInt)
  {
    int i3 = 0;
    int i1 = 0;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a();
    int i2 = i1;
    if (localObject != null)
    {
      if (((Set)localObject).isEmpty()) {
        i2 = i1;
      }
    }
    else {
      return i2;
    }
    if (QLog.isColorLevel()) {}
    for (StringBuilder localStringBuilder = new StringBuilder("getUnreadMsgsNum type=" + paramInt + "{");; localStringBuilder = null)
    {
      localObject = ((Set)localObject).iterator();
      i1 = i3;
      while (((Iterator)localObject).hasNext())
      {
        ConversationInfo localConversationInfo = (ConversationInfo)((Iterator)localObject).next();
        if (!localConversationInfo.uin.equalsIgnoreCase(AppConstants.aj))
        {
          i2 = a(localConversationInfo.type).a(paramInt, localConversationInfo);
          if ((QLog.isColorLevel()) && (localStringBuilder != null) && (i2 > 0)) {
            localStringBuilder.append("[" + localConversationInfo.uin + "," + localConversationInfo.type + "," + i2 + "]");
          }
          i1 += i2;
        }
      }
      i2 = i1;
      if (!QLog.isColorLevel()) {
        break;
      }
      i2 = i1;
      if (localStringBuilder == null) {
        break;
      }
      i2 = i1;
      if (i1 <= 0) {
        break;
      }
      localStringBuilder.append("}");
      QLog.d("Q.msg.QQMessageFacade", 2, localStringBuilder.toString());
      return i1;
    }
  }
  
  private int a(List paramList, QQMessageFacade.Message paramMessage)
  {
    int i2;
    if ((paramList == null) || (paramMessage == null))
    {
      i2 = -1;
      return i2;
    }
    int i1 = 0;
    for (;;)
    {
      if (i1 >= paramList.size()) {
        break label54;
      }
      i2 = i1;
      if (a((QQMessageFacade.Message)paramList.get(i1), paramMessage)) {
        break;
      }
      i1 += 1;
    }
    label54:
    return -1;
  }
  
  public static long a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    long l1 = 0L;
    if ((paramInt == 1) || (paramInt == 3000))
    {
      QQMessageFacade.Message localMessage = paramQQAppInterface.a().a(paramString, paramInt);
      l1 = localMessage.shmsgseq;
      if (localMessage.isLongMsg())
      {
        paramQQAppInterface = paramQQAppInterface.a().a(paramString, paramInt);
        if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0)) {
          l1 = Math.max(l1, ((MessageRecord)paramQQAppInterface.get(paramQQAppInterface.size() - 1)).shmsgseq);
        }
      }
    }
    else
    {
      return l1;
    }
    return l1;
  }
  
  private MsgProxy a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt);
  }
  
  private QQMessageFacade.Message a(String paramString, int paramInt, EntityManager paramEntityManager)
  {
    return a(paramInt).a(paramString, paramInt, paramEntityManager);
  }
  
  private void a(EntityManager paramEntityManager)
  {
    Object localObject = paramEntityManager.a(TroopAssistantData.class, false, null, null, null, null, "lastmsgtime desc", null);
    if ((localObject == null) || (((List)localObject).size() == 0)) {}
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        a(((TroopAssistantData)((Iterator)localObject).next()).troopUin, 1, paramEntityManager);
      }
    }
  }
  
  private void a(String paramString, MessageRecord paramMessageRecord)
  {
    paramString = (SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12);
    if (!AnonymousChatHelper.a(paramMessageRecord)) {
      paramMessageRecord.vipBubbleID = paramString.b();
    }
  }
  
  private void a(List paramList, EntityManager paramEntityManager, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("addMultiMessagesInner size = ");
      if (paramList != null) {
        break label105;
      }
    }
    label105:
    for (int i1 = 0;; i1 = paramList.size())
    {
      a(i1 + " sync = " + paramBoolean1 + " saveToDB = " + paramBoolean2 + " needUpdateUnread = " + paramBoolean3 + " needAddAIO = " + paramBoolean4, null);
      if ((paramList != null) && (!paramList.isEmpty())) {
        break;
      }
      return;
    }
    Object localObject1 = new BaseMessageManager.AddMessageContext(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    long l2 = paramList.size();
    Object localObject2 = paramList.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (MessageRecord)((Iterator)localObject2).next();
      a(((MessageRecord)localObject3).istroop).a((MessageRecord)localObject3, paramEntityManager, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, (BaseMessageManager.AddMessageContext)localObject1);
    }
    paramEntityManager = a();
    int i2;
    if (paramEntityManager != null)
    {
      i2 = 0;
      if (paramEntityManager.istroop == 1)
      {
        localObject2 = ((BaseMessageManager.AddMessageContext)localObject1).jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager.a(paramEntityManager.frienduin);
        i1 = i2;
        if (localObject2 != null)
        {
          i1 = i2;
          if (((MessageInfo)localObject2).b() == paramEntityManager.shmsgseq) {
            i1 = ((MessageInfo)localObject2).a();
          }
        }
        paramEntityManager.bizType = i1;
      }
    }
    else
    {
      localObject2 = ((BaseMessageManager.AddMessageContext)localObject1).jdField_a_of_type_JavaUtilMap.keySet().iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext()) {
        break label579;
      }
      localObject3 = (String)((Iterator)localObject2).next();
      RecentUser localRecentUser = (RecentUser)((BaseMessageManager.AddMessageContext)localObject1).jdField_a_of_type_JavaUtilMap.get(localObject3);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.QQMessageFacade", 2, "addMessage saveRecentUser uin = " + localRecentUser.uin + " , type = " + localRecentUser.type + ", lastmsgtime = " + localRecentUser.lastmsgtime);
      }
      RecentUtil.a(localRecentUser, this);
      ((BaseMessageManager.AddMessageContext)localObject1).jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy.a((RecentUser)((BaseMessageManager.AddMessageContext)localObject1).jdField_a_of_type_JavaUtilMap.get(localObject3));
      if (paramEntityManager != null)
      {
        if (paramEntityManager.istroop == 3000)
        {
          ((BaseMessageManager.AddMessageContext)localObject1).jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager.b(localRecentUser.uin + "&" + 3000);
          continue;
          i1 = i2;
          if (paramEntityManager.istroop != 3000) {
            break;
          }
          localObject2 = ((BaseMessageManager.AddMessageContext)localObject1).jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager.a(paramEntityManager.frienduin + "&" + 3000);
          i1 = i2;
          if (localObject2 == null) {
            break;
          }
          i1 = i2;
          if (((MessageInfo)localObject2).b() != paramEntityManager.shmsgseq) {
            break;
          }
          i1 = ((MessageInfo)localObject2).b();
          break;
        }
        ((BaseMessageManager.AddMessageContext)localObject1).jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager.b(localRecentUser.uin);
      }
    }
    label579:
    paramEntityManager = ((BaseMessageManager.AddMessageContext)localObject1).jdField_b_of_type_JavaUtilMap.keySet().iterator();
    while (paramEntityManager.hasNext())
    {
      localObject2 = (String)paramEntityManager.next();
      TroopAssistantManager.a().a((MessageRecord)((BaseMessageManager.AddMessageContext)localObject1).jdField_b_of_type_JavaUtilMap.get(localObject2), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (paramBoolean3) {
      ((BaseMessageManager.AddMessageContext)localObject1).jdField_a_of_type_ComTencentMobileqqAppMessageConversationFacade.a(paramList);
    }
    paramList = ((BaseMessageManager.AddMessageContext)localObject1).jdField_c_of_type_JavaUtilMap.keySet().iterator();
    while (paramList.hasNext())
    {
      paramEntityManager = (String)paramList.next();
      paramEntityManager = (MessageRecord)((BaseMessageManager.AddMessageContext)localObject1).jdField_c_of_type_JavaUtilMap.get(paramEntityManager);
      paramEntityManager = a(paramEntityManager.frienduin, paramEntityManager.istroop);
      a(paramEntityManager);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.QQMessageFacade", 2, "addMessage decodeMsg uin = " + paramEntityManager.frienduin + " , type = " + paramEntityManager.istroop + " ,msgType:" + paramEntityManager.msgtype + ", con = " + paramEntityManager.getLogColorContent());
      }
    }
    MsgAutoMonitorUtil.a().a(System.currentTimeMillis() - l1, l2);
  }
  
  private boolean a(QQMessageFacade.Message paramMessage1, QQMessageFacade.Message paramMessage2)
  {
    return a(paramMessage1.frienduin, paramMessage2.frienduin);
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null)) {
      return paramString1.equals(paramString2);
    }
    return (paramString1 == null) && (paramString2 == null);
  }
  
  private boolean a(List paramList, QQMessageFacade.Message paramMessage)
  {
    if ((paramList == null) || (paramMessage == null)) {
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (a((QQMessageFacade.Message)paramList.next(), paramMessage)) {
        return true;
      }
    }
    return false;
  }
  
  private MessageRecord b(String paramString, int paramInt)
  {
    paramString = MsgProxyUtils.b(a(paramInt).b(paramString, paramInt));
    if ((paramString != null) && (!paramString.isEmpty())) {
      return (MessageRecord)paramString.get(paramString.size() - 1);
    }
    return null;
  }
  
  private String b(String paramString, int paramInt)
  {
    return MsgProxyUtils.a(paramString, paramInt);
  }
  
  private void d(QQMessageFacade.Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.frienduin != null) && (paramMessage.frienduin.equals(AppConstants.S)) && (paramMessage.istroop == 1009))
    {
      paramMessage.unReadNum = 0;
      Object localObject = a(paramMessage.istroop).a(paramMessage.frienduin, paramMessage.istroop);
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
          int i1 = paramMessage.unReadNum;
          paramMessage.unReadNum = (a(paramMessage.istroop).a(localMessageRecord.senderuin, localMessageRecord.istroop, 0L) + i1);
        }
        localEntityManager.a();
      }
    }
  }
  
  private void g(String paramString, int paramInt)
  {
    Object localObject = a(paramInt).a(paramString, paramInt);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if (((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).b(localMessageRecord.senderuin))
        {
          a().a(paramString, paramInt, localMessageRecord.frienduin, localMessageRecord.istroop);
          a(paramString, paramInt, localMessageRecord.senderuin, localMessageRecord.selfuin);
          QQMessageFacade.Message localMessage = a(localMessageRecord.senderuin, paramInt);
          RecentUserProxy localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
          RecentUser localRecentUser = localRecentUserProxy.a(localMessage.frienduin, localMessage.istroop);
          localRecentUser.lastmsgtime = localMessage.time;
          RecentUtil.a(localRecentUser, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
          localRecentUserProxy.a(localRecentUser);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.QQMessageFacade", 2, "refreshMsgBox uin=" + paramString + ",type=" + paramInt + ",move " + localMessageRecord.senderuin + " from box to recentlist");
          }
          setChanged();
          notifyObservers(localRecentUser);
        }
      }
    }
  }
  
  private void m()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((QQMessageFacade.Message)localIterator.next()).counter = 0;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public int a()
  {
    return this.k;
  }
  
  public int a(String paramString, int paramInt)
  {
    return a(paramString, paramInt, true, true);
  }
  
  public int a(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a(paramString, 0, paramLong1, paramLong2);
  }
  
  public int a(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    return a(paramInt).a(paramString, paramInt, paramMessageRecord);
  }
  
  public int a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramInt).a(paramString, paramInt, paramBoolean1, paramBoolean2);
  }
  
  public long a(String paramString)
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0).b(paramString, 0);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    int i1;
    if (localList != null)
    {
      i1 = localList.size() - 1;
      localObject1 = localObject2;
      if (i1 >= 0)
      {
        localObject1 = (MessageRecord)localList.get(i1);
        if (!((MessageRecord)localObject1).senderuin.equals(paramString)) {
          break label178;
        }
        if (!QLog.isColorLevel()) {
          break label198;
        }
        QLog.i("vip", 2, "getLastC2CBubleID find in cache");
      }
    }
    label152:
    label178:
    label198:
    for (;;)
    {
      if (localObject1 == null)
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0).a(paramString, 0, 9223372036854775807L, 1, String.format("issend<>%d and issend<>%d", new Object[] { Integer.valueOf(1), Integer.valueOf(2) }));
        if ((paramString != null) && (!paramString.isEmpty()))
        {
          paramString = (MessageRecord)paramString.get(0);
          localObject1 = paramString;
          if (QLog.isColorLevel())
          {
            QLog.d("vip", 2, "getLastC2CBubleID find in db");
            localObject1 = paramString;
          }
        }
      }
      for (;;)
      {
        if (localObject1 == null)
        {
          return 0L;
          i1 -= 1;
          break;
        }
        return ((MessageRecord)localObject1).vipBubbleID;
        paramString = (String)localObject1;
        break label152;
      }
    }
  }
  
  public long a(String paramString, int paramInt)
  {
    List localList = a(paramInt).b(paramString, paramInt);
    if ((localList == null) || (localList.isEmpty())) {
      return MessageCache.a();
    }
    if ((a()) && (a().equals(paramString)) && (a() == paramInt)) {
      return ((MessageRecord)localList.get(localList.size() - 1)).time;
    }
    paramInt = localList.size() - 1;
    while (paramInt >= 0)
    {
      if (((MessageRecord)localList.get(paramInt)).isread) {
        return ((MessageRecord)localList.get(paramInt)).time;
      }
      paramInt -= 1;
    }
    return Math.max(((MessageRecord)localList.get(0)).time - 1L, 0L);
  }
  
  public long a(String paramString1, String paramString2)
  {
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0).b(paramString1, 0);
    int i1;
    MessageRecord localMessageRecord;
    if (paramString1 != null)
    {
      i1 = paramString1.size() - 1;
      if (i1 >= 0)
      {
        localMessageRecord = (MessageRecord)paramString1.get(i1);
        if (localMessageRecord.senderuin.equals(paramString2))
        {
          paramString1 = localMessageRecord;
          if (QLog.isColorLevel()) {
            QLog.i("vip", 2, "getLastC2CBubleID find in cache");
          }
        }
      }
    }
    for (paramString1 = localMessageRecord;; paramString1 = null)
    {
      if (paramString1 == null)
      {
        return 0L;
        i1 -= 1;
        break;
      }
      return paramString1.vipBubbleID;
    }
  }
  
  public BaseMessageManager a(int paramInt)
  {
    if (paramInt == 1)
    {
      if (this.jdField_b_of_type_ComTencentMobileqqAppMessageBaseMessageManager == null) {}
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_b_of_type_ComTencentMobileqqAppMessageBaseMessageManager == null) {
          this.jdField_b_of_type_ComTencentMobileqqAppMessageBaseMessageManager = new TroopMessageManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
        }
        return this.jdField_b_of_type_ComTencentMobileqqAppMessageBaseMessageManager;
      }
    }
    if (paramInt == 3000)
    {
      if (this.jdField_c_of_type_ComTencentMobileqqAppMessageBaseMessageManager == null) {}
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_c_of_type_ComTencentMobileqqAppMessageBaseMessageManager == null) {
          this.jdField_c_of_type_ComTencentMobileqqAppMessageBaseMessageManager = new DiscMessageManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
        }
        return this.jdField_c_of_type_ComTencentMobileqqAppMessageBaseMessageManager;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageBaseMessageManager == null) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppMessageBaseMessageManager == null) {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageBaseMessageManager = new C2CMessageManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      }
      return this.jdField_a_of_type_ComTencentMobileqqAppMessageBaseMessageManager;
    }
  }
  
  public C2CMessageManager a()
  {
    return (C2CMessageManager)a(0);
  }
  
  public ConversationFacade a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
  }
  
  public DatalineMessageManager a()
  {
    return (DatalineMessageManager)a("dataline_manager");
  }
  
  public DiscMessageManager a()
  {
    return (DiscMessageManager)a(3000);
  }
  
  public IMessageManager a(String paramString)
  {
    if (this.jdField_c_of_type_JavaUtilMap == null) {
      return null;
    }
    if (!this.jdField_c_of_type_JavaUtilMap.containsKey(paramString)) {}
    for (;;)
    {
      synchronized (this.jdField_c_of_type_JavaUtilMap)
      {
        if (this.jdField_c_of_type_JavaUtilMap.containsKey(paramString)) {
          break label89;
        }
        if (!"dataline_manager".equals(paramString)) {
          break label105;
        }
        localDatalineMessageManager = new DatalineMessageManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
        if (localDatalineMessageManager == null) {
          return null;
        }
      }
      this.jdField_c_of_type_JavaUtilMap.put(paramString, localDatalineMessageManager);
      label89:
      return (IMessageManager)this.jdField_c_of_type_JavaUtilMap.get(paramString);
      label105:
      DatalineMessageManager localDatalineMessageManager = null;
    }
  }
  
  public QQMessageFacade.Message a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message;
  }
  
  public QQMessageFacade.Message a(String paramString, int paramInt)
  {
    if (paramString == null) {
      localObject = null;
    }
    StringBuilder localStringBuilder;
    String str1;
    QQMessageFacade.Message localMessage;
    do
    {
      return localObject;
      System.currentTimeMillis();
      localStringBuilder = new StringBuilder("Case:");
      str1 = b(paramString, paramInt);
      localMessage = (QQMessageFacade.Message)this.jdField_a_of_type_JavaUtilMap.get(str1);
      if (localMessage == null) {
        break;
      }
      localObject = localMessage;
    } while (localMessage.isCacheValid);
    if (this.o == 0)
    {
      localMessage = new QQMessageFacade.Message();
      localMessage.frienduin = paramString;
      localMessage.istroop = paramInt;
      this.jdField_a_of_type_JavaUtilMap.put(str1, localMessage);
      localStringBuilder.append("All-In");
      return localMessage;
    }
    if (!this.jdField_b_of_type_Boolean)
    {
      localObject = localMessage;
      if (localMessage == null)
      {
        localObject = new QQMessageFacade.Message();
        ((QQMessageFacade.Message)localObject).frienduin = paramString;
        ((QQMessageFacade.Message)localObject).istroop = paramInt;
        ((QQMessageFacade.Message)localObject).isCacheValid = false;
        this.jdField_a_of_type_JavaUtilMap.put(str1, localObject);
      }
      localStringBuilder.append("Not-Finish-Yet");
      return localObject;
    }
    String str2 = MessageRecord.getTableName(paramString, paramInt);
    String str3 = MessageRecord.getOldTableName(paramString, paramInt);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    if ((((EntityManager)localObject).d(str2)) || (((EntityManager)localObject).d(str3)))
    {
      localMessage = a(paramString, paramInt, (EntityManager)localObject);
      localStringBuilder.append("Check-DB");
      ((EntityManager)localObject).a();
      return localMessage;
    }
    if (localMessage == null)
    {
      localMessage = new QQMessageFacade.Message();
      localMessage.frienduin = paramString;
      localMessage.istroop = paramInt;
      this.jdField_a_of_type_JavaUtilMap.put(str1, localMessage);
    }
    for (;;)
    {
      localStringBuilder.append("Not-In-TableCache");
      break;
      localMessage.isCacheValid = true;
    }
  }
  
  public ChatHistorySearchData a(SessionInfo paramSessionInfo, String paramString)
  {
    return a(paramSessionInfo.a).a(paramSessionInfo, paramString);
  }
  
  public ChatHistorySearchData a(String paramString, int paramInt, List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    ChatHistorySearchData localChatHistorySearchData = new ChatHistorySearchData();
    localChatHistorySearchData.mSearchData1 = a(paramInt).a(paramString, paramInt, paramList);
    return localChatHistorySearchData;
  }
  
  public DraftSummaryInfo a(String paramString, int paramInt)
  {
    if ((paramString != null) && (this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramInt);
    }
    return null;
  }
  
  public MessageRecord a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.longMsgIndex == 0) {}
    List localList;
    do
    {
      return paramMessageRecord;
      localList = a(paramMessageRecord.istroop).b(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    } while ((localList == null) || (localList.isEmpty()));
    int i1 = localList.size() - 1;
    if (i1 >= 0)
    {
      MessageRecord localMessageRecord = (MessageRecord)localList.get(i1);
      if (MsgProxyUtils.a(localMessageRecord, paramMessageRecord))
      {
        if (localMessageRecord.longMsgIndex == 0) {
          return localMessageRecord;
        }
        if (localMessageRecord.longMsgIndex < paramMessageRecord.longMsgIndex) {
          paramMessageRecord = localMessageRecord;
        }
      }
      for (;;)
      {
        i1 -= 1;
        break;
      }
    }
    return paramMessageRecord;
  }
  
  public MessageRecord a(String paramString, int paramInt)
  {
    Object localObject1 = a(paramInt).b(paramString, paramInt);
    if (localObject1 != null)
    {
      int i1 = ((List)localObject1).size() - 1;
      Object localObject2;
      if (i1 >= 0)
      {
        localObject2 = (MessageRecord)((List)localObject1).get(i1);
        if ((((MessageRecord)localObject2).isValid) && (!MsgProxyUtils.d(((MessageRecord)localObject2).msgtype)))
        {
          localObject1 = localObject2;
          if (!((MessageRecord)localObject2).isLongMsg()) {}
        }
      }
      for (localObject1 = a((MessageRecord)localObject2);; localObject1 = null)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = a(paramInt).a(paramString, paramInt, null);
        }
        return localObject2;
        i1 -= 1;
        break;
      }
    }
    return null;
  }
  
  public MessageRecord a(String paramString, int paramInt, long paramLong)
  {
    return a(paramInt).a(paramString, paramInt, paramLong);
  }
  
  public MessageRecord a(String paramString1, int paramInt1, long paramLong1, String paramString2, String paramString3, long paramLong2, int paramInt2)
  {
    return a(paramInt1).a(paramString1, paramInt1, paramLong1, paramString2, paramString3, paramLong2, paramInt2);
  }
  
  public MessageRecord a(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    MsgProxy localMsgProxy = a(paramInt);
    if ((localMsgProxy instanceof TroopAndDiscMsgProxy)) {
      return ((TroopAndDiscMsgProxy)localMsgProxy).a(paramString, paramInt, paramMessageRecord);
    }
    return null;
  }
  
  public MessageRecord a(String paramString, int paramInt, MessageRecord paramMessageRecord, List paramList)
  {
    MsgProxy localMsgProxy = a(paramInt);
    if ((localMsgProxy instanceof TroopAndDiscMsgProxy)) {
      return ((TroopAndDiscMsgProxy)localMsgProxy).a(paramString, paramInt, paramMessageRecord, paramList);
    }
    return null;
  }
  
  public TroopMessageManager a()
  {
    return (TroopMessageManager)a(1);
  }
  
  public String a()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public String a(Context paramContext, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    QQMessageFacade.Message localMessage = new QQMessageFacade.Message();
    MessageRecord.copyMessageRecordBaseField(localMessage, paramMessageRecord);
    localMessage.emoRecentMsg = null;
    localMessage.fileType = -1;
    a(localMessage);
    paramMessageRecord = new MsgSummary();
    MsgUtils.a(paramContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessage, localMessage.istroop, paramMessageRecord, localMessage.nickName, false, paramBoolean);
    return paramMessageRecord.a(paramContext).toString();
  }
  
  public String a(String paramString, int paramInt)
  {
    if ((paramString != null) && (this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramInt);
    }
    return null;
  }
  
  public HashMap a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public List a(String paramString, int paramInt)
  {
    return a(paramInt).b(paramString, paramInt);
  }
  
  public List a(String paramString, int paramInt1, int paramInt2)
  {
    return a(paramInt1).a(paramString, paramInt1, paramInt2, null);
  }
  
  public List a(String paramString, int paramInt, boolean paramBoolean)
  {
    return a(paramInt).a(paramString, paramInt, paramBoolean);
  }
  
  public List a(String paramString, int paramInt, int[] paramArrayOfInt)
  {
    return a(paramInt).a(paramString, paramInt, 5000, paramArrayOfInt);
  }
  
  public msg_svc.PbMsgReadedReportReq a()
  {
    Object localObject1 = null;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a();
    if ((localObject2 == null) || (((Set)localObject2).isEmpty())) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    msg_svc.PbMsgReadedReportReq localPbMsgReadedReportReq = new msg_svc.PbMsgReadedReportReq();
    Iterator localIterator = ((Set)localObject2).iterator();
    Object localObject3;
    long l1;
    while (localIterator.hasNext())
    {
      localObject3 = (ConversationInfo)localIterator.next();
      if ((((ConversationInfo)localObject3).unreadCount > 0) && (a().b(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type))) {
        if (MsgProxyUtils.a(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type))
        {
          localObject3 = a(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type);
          if (localObject3 != null)
          {
            int i1 = ((List)localObject3).size() - 1;
            localObject2 = localObject1;
            localObject1 = localObject2;
            if (i1 >= 0)
            {
              MessageRecord localMessageRecord = (MessageRecord)((List)localObject3).get(i1);
              if (localMessageRecord == null) {
                localObject1 = localObject2;
              }
              for (;;)
              {
                i1 -= 1;
                localObject2 = localObject1;
                break;
                c(localMessageRecord.senderuin, localMessageRecord.istroop);
                msg_svc.PbC2CReadedReportReq.UinPairReadInfo localUinPairReadInfo = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
                localUinPairReadInfo.peer_uin.set(Long.valueOf(localMessageRecord.senderuin).longValue());
                localUinPairReadInfo.last_read_time.set((int)localMessageRecord.time);
                localObject1 = localObject2;
                if (localObject2 == null) {
                  localObject1 = new msg_svc.PbC2CReadedReportReq();
                }
                ((msg_svc.PbC2CReadedReportReq)localObject1).pair_info.add(localUinPairReadInfo);
                localStringBuilder.append("{MSGBOX:").append(localMessageRecord.frienduin).append("}");
              }
            }
          }
        }
        else if (7000 != ((ConversationInfo)localObject3).type)
        {
          if ((1006 != ((ConversationInfo)localObject3).type) && ((!MsgProxyUtils.a(((ConversationInfo)localObject3).type)) || (Long.valueOf(((ConversationInfo)localObject3).uin).longValue() <= 10000L))) {
            break label633;
          }
          c(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type);
          l1 = b(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type);
          if (l1 != -1L) {
            break label488;
          }
        }
      }
    }
    label401:
    if (localObject1 != null)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a();
      if (localObject2 != null) {
        ((msg_svc.PbC2CReadedReportReq)localObject1).sync_cookie.set(ByteStringMicro.copyFrom((byte[])localObject2));
      }
      localPbMsgReadedReportReq.c2c_read_report.set((MessageMicro)localObject1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "<ReadReport_All>setAllReaded: " + localStringBuilder.toString());
    }
    return localPbMsgReadedReportReq;
    label488:
    localObject2 = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
    if (1006 == ((ConversationInfo)localObject3).type)
    {
      ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject2).peer_uin.set(Long.valueOf(ContactUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((ConversationInfo)localObject3).uin)).longValue());
      localStringBuilder.append("{C2C:").append(Long.valueOf(ContactUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((ConversationInfo)localObject3).uin))).append(((ConversationInfo)localObject3).type).append("}");
      label574:
      ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject2).last_read_time.set((int)l1);
      if (localObject1 != null) {
        break label847;
      }
      localObject1 = new msg_svc.PbC2CReadedReportReq();
    }
    label847:
    for (;;)
    {
      ((msg_svc.PbC2CReadedReportReq)localObject1).pair_info.add((MessageMicro)localObject2);
      break;
      ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject2).peer_uin.set(Long.valueOf(((ConversationInfo)localObject3).uin).longValue());
      break label574;
      label633:
      if (3000 == ((ConversationInfo)localObject3).type)
      {
        c(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type);
        l1 = b(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type);
        if (l1 == -1L) {
          break label401;
        }
        localObject2 = new msg_svc.PbDiscussReadedReportReq();
        ((msg_svc.PbDiscussReadedReportReq)localObject2).conf_uin.set(Long.valueOf(((ConversationInfo)localObject3).uin).longValue());
        ((msg_svc.PbDiscussReadedReportReq)localObject2).last_read_seq.set(l1);
        localPbMsgReadedReportReq.dis_read_report.add((MessageMicro)localObject2);
        break;
      }
      if ((1 != ((ConversationInfo)localObject3).type) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type))) {
        break;
      }
      c(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type);
      l1 = b(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type);
      if (l1 == -1L) {
        break label401;
      }
      localObject2 = new msg_svc.PbGroupReadedReportReq();
      ((msg_svc.PbGroupReadedReportReq)localObject2).group_code.set(Long.valueOf(((ConversationInfo)localObject3).uin).longValue());
      ((msg_svc.PbGroupReadedReportReq)localObject2).last_read_seq.set(l1);
      localPbMsgReadedReportReq.grp_read_report.add((MessageMicro)localObject2);
      break;
    }
  }
  
  public msg_svc.PbMsgReadedReportReq a(String paramString, int paramInt)
  {
    if (MsgProxyUtils.a(paramString, paramInt))
    {
      List localList = a(paramString, paramInt);
      if (localList == null) {
        return null;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      msg_svc.PbMsgReadedReportReq localPbMsgReadedReportReq = new msg_svc.PbMsgReadedReportReq();
      paramInt = localList.size() - 1;
      paramString = null;
      Object localObject;
      if (paramInt >= 0)
      {
        MessageRecord localMessageRecord = (MessageRecord)localList.get(paramInt);
        if (localMessageRecord == null) {}
        for (;;)
        {
          paramInt -= 1;
          break;
          c(localMessageRecord.senderuin, localMessageRecord.istroop);
          msg_svc.PbC2CReadedReportReq.UinPairReadInfo localUinPairReadInfo = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
          localUinPairReadInfo.peer_uin.set(Long.valueOf(localMessageRecord.senderuin).longValue());
          localUinPairReadInfo.last_read_time.set((int)localMessageRecord.time);
          localObject = paramString;
          if (paramString == null) {
            localObject = new msg_svc.PbC2CReadedReportReq();
          }
          ((msg_svc.PbC2CReadedReportReq)localObject).pair_info.add(localUinPairReadInfo);
          localStringBuilder.append("{MSGBOX:").append(localMessageRecord.frienduin).append("}");
          paramString = (String)localObject;
        }
      }
      if (paramString != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a();
        if (localObject != null) {
          paramString.sync_cookie.set(ByteStringMicro.copyFrom((byte[])localObject));
        }
        localPbMsgReadedReportReq.c2c_read_report.set(paramString);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.QQMessageFacade", 2, "<ReadReport_LBS>setLbsFriendReaded: " + localStringBuilder.toString());
        }
        return localPbMsgReadedReportReq;
      }
    }
    return null;
  }
  
  public void a()
  {
    ThreadManager.a(new dag(this));
  }
  
  public void a(int paramInt)
  {
    String str = String.valueOf(AppConstants.al);
    if (a().a(str, 4001) <= 0) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.QQMessageFacade", 2, "setRecommendMsgReaded return : unread=0");
      }
    }
    do
    {
      return;
      QQMessageFacade.Message localMessage = a(str, 4001);
      paramInt = a(4001).a(paramInt, localMessage);
      a().b(str, 4001, -paramInt);
    } while (paramInt == 0);
    setChanged();
    notifyObservers(a(str, 4001));
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    int i2 = 0;
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    int i1;
    if (this.o == -1)
    {
      if (localEntityManager.d(ConversationInfo.getConversationInfoTableName()))
      {
        i1 = 1;
        this.o = i1;
      }
    }
    else
    {
      localObject = ((RecentUserProxy)localObject).b();
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label171;
      }
      i1 = ((List)localObject).size();
      if (paramInt <= 0) {
        break label213;
      }
      if (i1 <= paramInt) {
        break label163;
      }
      i1 = i2;
    }
    for (;;)
    {
      if (i1 < paramInt)
      {
        RecentUser localRecentUser = (RecentUser)((List)localObject).get(i1);
        a(localRecentUser.uin, localRecentUser.type, localEntityManager);
        if (i1 == 8)
        {
          setChanged();
          notifyObservers(new RecentUser());
        }
        i1 += 1;
        continue;
        i1 = 0;
        break;
        label163:
        paramInt = i1;
        i1 = i2;
        continue;
      }
      label171:
      if (paramBoolean) {
        a(localEntityManager);
      }
      if ((paramBoolean) || (((List)localObject).size() > 8))
      {
        setChanged();
        notifyObservers(new RecentUser());
      }
      return;
      label213:
      paramInt = i1;
      i1 = i2;
    }
  }
  
  public void a(QQMessageFacade.Message paramMessage)
  {
    try
    {
      a(paramMessage.istroop).a(paramMessage);
      return;
    }
    catch (Throwable paramMessage)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.msg.QQMessageFacade", 2, "decodeMsg ERROR", paramMessage);
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    Object localObject1;
    Object localObject2;
    if ((paramMessageRecord instanceof MessageForShortVideo))
    {
      localObject1 = (MessageForShortVideo)paramMessageRecord;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (!((MessageForShortVideo)localObject1).isSendFromLocal())
      {
        ((TransFileController)localObject2).b(((MessageForShortVideo)localObject1).frienduin, ((MessageForShortVideo)localObject1).uniseq);
        ShortVideoUtils.a((MessageForShortVideo)localObject1);
      }
    }
    else
    {
      if (paramMessageRecord.isSendFromLocal()) {
        break label78;
      }
    }
    for (;;)
    {
      return;
      ((TransFileController)localObject2).c(((MessageForShortVideo)localObject1).frienduin, ((MessageForShortVideo)localObject1).uniseq);
      break;
      label78:
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      localObject2 = new ArrayList();
      Object localObject3;
      if ((paramMessageRecord instanceof MessageForMixedMsg))
      {
        paramMessageRecord = (MessageForMixedMsg)paramMessageRecord;
        i2 = paramMessageRecord.msgElemList.size();
        i1 = 0;
        while (i1 < i2)
        {
          localObject3 = (MessageRecord)paramMessageRecord.msgElemList.get(i1);
          if ((localObject3 instanceof MessageForPic)) {
            ((List)localObject2).add((MessageForPic)localObject3);
          }
          i1 += 1;
        }
      }
      if ((paramMessageRecord instanceof MessageForLongMsg))
      {
        paramMessageRecord = (MessageForLongMsg)paramMessageRecord;
        int i3 = paramMessageRecord.longMsgFragmentList.size();
        i1 = 0;
        if (i1 < i3)
        {
          localObject3 = (MessageRecord)paramMessageRecord.longMsgFragmentList.get(i1);
          if ((localObject3 instanceof MessageForPic)) {
            ((List)localObject2).add((MessageForPic)localObject3);
          }
          for (;;)
          {
            i1 += 1;
            break;
            if ((localObject3 instanceof MessageForMixedMsg))
            {
              localObject3 = (MessageForMixedMsg)localObject3;
              int i4 = ((MessageForMixedMsg)localObject3).msgElemList.size();
              i2 = 0;
              while (i2 < i4)
              {
                MessageRecord localMessageRecord = (MessageRecord)((MessageForMixedMsg)localObject3).msgElemList.get(i2);
                if ((localMessageRecord instanceof MessageForPic)) {
                  ((List)localObject2).add((MessageForPic)localMessageRecord);
                }
                i2 += 1;
              }
            }
          }
        }
      }
      else
      {
        if (!(paramMessageRecord instanceof MessageForPic)) {
          continue;
        }
        ((List)localObject2).add((MessageForPic)paramMessageRecord);
      }
      int i2 = ((List)localObject2).size();
      int i1 = 0;
      while (i1 < i2)
      {
        paramMessageRecord = (MessageForPic)((List)localObject2).get(i1);
        paramMessageRecord = paramMessageRecord.frienduin + paramMessageRecord.uniseq + "_" + paramMessageRecord.subMsgId;
        localObject3 = ((TransFileController)localObject1).a(paramMessageRecord);
        if ((localObject3 != null) && ((localObject3 instanceof BaseTransProcessor)))
        {
          ((BaseTransProcessor)localObject3).h();
          ((TransFileController)localObject1).d(paramMessageRecord);
        }
        i1 += 1;
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, MessageObserver paramMessageObserver)
  {
    a(paramMessageRecord, paramMessageObserver, false);
  }
  
  public void a(MessageRecord paramMessageRecord, MessageObserver paramMessageObserver, boolean paramBoolean)
  {
    if (paramMessageRecord == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " addAndSendMessage addSendMessage start currenttime:" + System.currentTimeMillis());
      }
      if ((paramMessageRecord instanceof ChatMessage)) {
        ((ChatMessage)paramMessageRecord).mPendantAnimatable = true;
      }
      b(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " addAndSendMessage addSendMessage end and sendMessage start currenttime:" + System.currentTimeMillis());
      }
      b(paramMessageRecord, paramMessageObserver, paramBoolean);
    } while (!QLog.isColorLevel());
    QLog.d("SendMsgBtn", 2, " addAndSendMessage sendMessage end currenttime:" + System.currentTimeMillis());
  }
  
  public void a(MessageRecord paramMessageRecord, String paramString)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString).createEntityManager();
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramMessageRecord);
      a(localArrayList, paramString, false, true, true, true);
      setChanged();
      if (((paramMessageRecord instanceof ChatMessage)) && (paramMessageRecord.isSend())) {
        ((ChatMessage)paramMessageRecord).mPendantAnimatable = true;
      }
      notifyObservers(paramMessageRecord);
      return;
    }
    finally
    {
      paramString.a();
    }
  }
  
  public void a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    a(paramMessageRecord.istroop).a(paramMessageRecord, true, paramBoolean);
  }
  
  public void a(RecentUser paramRecentUser)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b(paramRecentUser);
    c(paramRecentUser.uin, paramRecentUser.type);
  }
  
  public void a(Object paramObject)
  {
    setChanged();
    notifyObservers(paramObject);
  }
  
  public void a(String paramString)
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    paramString = (ArrayList)localEntityManager.a(TransFileInfo.class, false, "friendUin = ?", new String[] { paramString }, null, null, null, null);
    if (paramString != null)
    {
      paramString = paramString.iterator();
      while (paramString.hasNext()) {
        localEntityManager.b((TransFileInfo)paramString.next());
      }
    }
    localEntityManager.a();
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
    this.k = paramInt;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext)
  {
    a(paramInt1).a(paramString, paramInt1, paramInt2, paramRefreshMessageContext);
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    a(paramInt).b(paramString, paramInt, paramLong);
  }
  
  public void a(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    a(paramString, paramInt1, paramLong, 32768, paramInt2);
    paramString = a(paramString, paramInt1);
    if ((paramString != null) && (paramString.uniseq == paramLong))
    {
      paramString.extraflag = 32768;
      paramString.sendFailCode = paramInt2;
      setChanged();
      notifyObservers(paramString);
    }
  }
  
  public void a(String paramString, int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "updateMsgExtraFlagByuniseq: peerUin = " + paramString + " type = " + paramInt1 + " uniseq = " + paramLong);
    }
    MessageRecord localMessageRecord = a(paramInt1).a(paramString, paramInt1, paramLong, paramInt2, paramInt3);
    a(paramInt1).a(paramString, paramInt1, localMessageRecord, 3);
  }
  
  public void a(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "updateC2CMsgTimeByUniseq: peerUin = " + paramString + " type = " + paramInt + " uniseq = " + paramLong1 + " time = " + paramLong2);
    }
    MessageRecord localMessageRecord = a(paramInt).a(paramString, paramInt, paramLong1, paramLong2);
    a(paramInt).a(paramString, paramInt, localMessageRecord, 3);
  }
  
  public void a(String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "updateGroupMsgSeqAndTimeByUniseq: peerUin = " + paramString + " type = " + paramInt + " uniseq = " + paramLong1 + " shmsgseq = " + paramLong2 + " time = " + paramLong3);
    }
    Object localObject = a(paramInt);
    if ((localObject instanceof TroopAndDiscMsgProxy)) {}
    for (localObject = ((TroopAndDiscMsgProxy)localObject).b(paramString, paramInt, paramLong1, paramLong2, paramLong3);; localObject = null)
    {
      a(paramInt).a(paramString, paramInt, (MessageRecord)localObject, 3);
      a(paramString, paramInt, paramLong2);
      setChanged();
      notifyObservers(localObject);
      return;
    }
  }
  
  public void a(String paramString1, int paramInt, long paramLong, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "updateMsgContent: peerUin = " + paramString1 + " type = " + paramInt + " uniseq = " + paramLong);
    }
    paramString2 = a(paramInt).a(paramString1, paramInt, paramLong, paramString2);
    a(paramInt).a(paramString1, paramInt, paramString2, 2);
  }
  
  public void a(String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "updateMsgContentByUniSeq: peerUin = " + paramString + " type = " + paramInt + " uniseq = " + paramLong);
    }
    paramArrayOfByte = a(paramInt).a(paramString, paramInt, paramLong, paramArrayOfByte);
    a(paramInt).a(paramString, paramInt, paramArrayOfByte, 2);
  }
  
  public void a(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    a(paramInt).b(paramString, paramInt, paramMessageRecord);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager != null) && (paramString2 != null) && (paramString1 != null) && (paramString1.length() >= 5))
    {
      DraftTextInfo localDraftTextInfo = new DraftTextInfo();
      localDraftTextInfo.uin = paramString1;
      localDraftTextInfo.type = paramInt;
      localDraftTextInfo.text = paramString2.toString();
      this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localDraftTextInfo);
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    a(paramInt).a(paramString1, paramInt, paramString2, paramString3);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong)
  {
    if (QLog.isColorLevel()) {}
    for (long l1 = System.currentTimeMillis();; l1 = 0L)
    {
      if (TextUtils.isEmpty(paramString3)) {
        paramLong = 0L;
      }
      for (;;)
      {
        a(paramInt).a(paramString1, paramInt, paramString2, paramString3, paramLong);
        if (QLog.isColorLevel()) {
          QLog.i("notification", 2, "notifyDraftUpdated| " + (System.currentTimeMillis() - l1));
        }
        return;
      }
    }
  }
  
  public void a(String paramString, int paramInt, List paramList1, List paramList2, Bundle paramBundle)
  {
    a(paramInt).a(paramString, paramInt, paramList1, paramList2, paramBundle);
  }
  
  public void a(String paramString, long paramLong)
  {
    if (paramLong < 0L) {
      return;
    }
    d(paramString, 1);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, paramString1);
    }
  }
  
  public void a(String paramString, Collection paramCollection)
  {
    if (paramCollection != null)
    {
      a("------------" + paramString + "--------------" + paramCollection.size(), "");
      return;
    }
    a("------------" + paramString + "-------------- is null", "");
  }
  
  public void a(ArrayList paramArrayList, String paramString, boolean paramBoolean)
  {
    boolean bool = true;
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString).createEntityManager();
    if (!paramBoolean) {}
    for (;;)
    {
      try
      {
        a(paramArrayList, paramString, paramBoolean, bool, true, true);
        paramString.a();
        if ((paramBoolean) && (paramArrayList != null) && (!paramArrayList.isEmpty())) {
          a(((MessageRecord)paramArrayList.get(0)).istroop).a(paramArrayList, null);
        }
        paramArrayList = MsgProxyUtils.a(paramArrayList);
        if (paramArrayList != null) {
          setChanged();
        }
        return;
      }
      finally
      {
        paramString.a();
      }
      bool = false;
    }
  }
  
  public void a(ArrayList paramArrayList, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString).createEntityManager();
    if (!paramBoolean1) {}
    for (;;)
    {
      try
      {
        a(paramArrayList, paramString, paramBoolean1, bool, paramBoolean2, true);
        paramString.a();
        if ((paramBoolean1) && (paramArrayList != null) && (!paramArrayList.isEmpty())) {
          a(((MessageRecord)paramArrayList.get(0)).istroop).a(paramArrayList, null);
        }
        if (paramBoolean2)
        {
          paramArrayList = MsgProxyUtils.a(paramArrayList);
          if (paramArrayList != null) {
            setChanged();
          }
        }
        return;
      }
      finally
      {
        paramString.a();
      }
      bool = false;
    }
  }
  
  public void a(ArrayList paramArrayList, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    boolean bool = true;
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString).createEntityManager();
    if (!paramBoolean1) {}
    for (;;)
    {
      try
      {
        a(paramArrayList, paramString, paramBoolean1, bool, paramBoolean2, true);
        paramString.a();
        if ((paramBoolean1) && (paramArrayList != null) && (!paramArrayList.isEmpty())) {
          a(((MessageRecord)paramArrayList.get(0)).istroop).a(paramArrayList, null);
        }
        if ((paramBoolean2) || (paramBoolean3))
        {
          paramArrayList = MsgProxyUtils.a(paramArrayList);
          if (paramArrayList != null) {
            setChanged();
          }
        }
        return;
      }
      finally
      {
        paramString.a();
      }
      bool = false;
    }
  }
  
  public void a(List paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      a(((MessageRecord)paramList.get(0)).istroop).a(paramList, null);
    }
  }
  
  public void a(List paramList, String paramString)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    try
    {
      a(paramList, paramString, false, true, true, true);
      paramString.a();
      paramList = MsgProxyUtils.a(paramList);
      if (paramList != null)
      {
        setChanged();
        notifyObservers(paramList);
      }
      return;
    }
    finally
    {
      paramString.a();
    }
  }
  
  public boolean a()
  {
    return (this.jdField_c_of_type_JavaLangString != null) && (this.k >= 0);
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    return a(paramMessageRecord.frienduin, paramMessageRecord.istroop).uniseq == paramMessageRecord.uniseq;
  }
  
  public boolean a(String paramString)
  {
    return b(paramString, 0);
  }
  
  public boolean a(String paramString, int paramInt)
  {
    paramString = b(paramString, paramInt);
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
    {
      paramString = (QQMessageFacade.Message)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      if ((paramString.time > 0L) && (paramString.senderuin != null)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (MsgProxyUtils.e(paramInt2))
    {
      bool1 = bool2;
      if (MsgProxyUtils.d(paramInt2))
      {
        bool1 = bool2;
        if (a(paramInt1).c(paramString, paramInt1, paramLong) != null) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean a(String paramString, int paramInt, List paramList, boolean paramBoolean)
  {
    if ((paramList != null) && (paramList.isEmpty())) {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.QQMessageFacade", 2, "refresh C2C autopull step 0 , FAIL! , timestamp = " + System.currentTimeMillis());
      }
    }
    do
    {
      return false;
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(b(paramString, paramInt), Boolean.valueOf(true));
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).e(paramString, paramInt);
    } while ((paramString == null) || (paramString.isEmpty()));
    if (!paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).c();
    }
    paramList = new StringBuilder().append("refresh C2C autopull, size = ");
    if (paramString == null) {}
    for (paramInt = -1;; paramInt = paramString.size())
    {
      a(paramInt, ", timestamp = " + System.currentTimeMillis());
      return true;
    }
  }
  
  public int b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    for (int i1 = 0; localIterator.hasNext(); i1 = ((QQMessageFacade.Message)localIterator.next()).counter + i1) {}
    return i1;
  }
  
  public long b(String paramString, int paramInt)
  {
    long l2 = -1L;
    Object localObject;
    long l1;
    if ((paramInt == 1) || (paramInt == 3000))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt);
      l2 = ((QQMessageFacade.Message)localObject).shmsgseq;
      l1 = l2;
      if (((QQMessageFacade.Message)localObject).isLongMsg())
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt);
        l1 = l2;
        if (paramString != null)
        {
          l1 = l2;
          if (paramString.size() > 0) {
            return Math.max(l2, ((MessageRecord)paramString.get(paramString.size() - 1)).shmsgseq);
          }
        }
      }
    }
    else
    {
      l1 = l2;
      if (MsgProxyUtils.a(paramInt))
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).b(paramString, paramInt);
        l1 = l2;
        if (paramString != null)
        {
          l1 = l2;
          if (!paramString.isEmpty())
          {
            paramInt = paramString.size() - 1;
            for (;;)
            {
              l1 = l2;
              if (paramInt < 0) {
                break;
              }
              localObject = (MessageRecord)paramString.get(paramInt);
              if (!MsgUtils.b(((MessageRecord)localObject).issend)) {
                return ((MessageRecord)localObject).time;
              }
              paramInt -= 1;
            }
          }
        }
      }
    }
    return l1;
  }
  
  public MessageRecord b(String paramString, int paramInt, long paramLong)
  {
    return a(paramInt).b(paramString, paramInt, paramLong);
  }
  
  public void b()
  {
    this.jdField_c_of_type_JavaLangString = null;
    this.k = -1;
  }
  
  public void b(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(4001).b(String.valueOf(AppConstants.al), 4001);
    if ((localObject == null) || (((List)localObject).size() == 0)) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramInt);
    } while (a(4001).a(paramInt) <= 0);
    setChanged();
    localObject = new RecentUser();
    ((RecentUser)localObject).uin = String.valueOf(AppConstants.aj);
    notifyObservers(localObject);
  }
  
  public void b(QQMessageFacade.Message paramMessage)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message = paramMessage;
  }
  
  public void b(MessageRecord paramMessageRecord, MessageObserver paramMessageObserver)
  {
    b(paramMessageRecord, paramMessageObserver, false);
  }
  
  public void b(MessageRecord paramMessageRecord, MessageObserver paramMessageObserver, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "sendMessage: mr_uinType:" + paramMessageRecord.istroop + " mr_msgType:" + paramMessageRecord.msgtype);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMessageRecord.msgtype);
    try
    {
      if (paramMessageRecord.msgUid == 0L) {
        paramMessageRecord.msgUid = MessageUtils.a(MessageUtils.a());
      }
      if (paramMessageRecord.msgtype == -1000) {
        if (paramMessageRecord.istroop == 1001)
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(paramMessageRecord.frienduin))
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageForText)paramMessageRecord);
            return;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord, null, paramBoolean);
          return;
        }
      }
    }
    catch (Exception paramMessageRecord)
    {
      if (QLog.isColorLevel())
      {
        QLog.e("Q.msg.QQMessageFacade", 2, "sendMessage ERROR:" + paramMessageRecord.getMessage(), paramMessageRecord);
        return;
        if (paramMessageRecord.istroop == 1003)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageForText)paramMessageRecord);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord, null, paramBoolean);
        return;
        if ((paramMessageRecord.msgtype == -2011) || (paramMessageRecord.msgtype == -2007) || (paramMessageRecord.msgtype == -2002) || (paramMessageRecord.msgtype == -2000) || (paramMessageRecord.msgtype == -2010) || (paramMessageRecord.msgtype == -2020) || (paramMessageRecord.msgtype == -2022)) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord, paramMessageObserver, paramBoolean);
        }
      }
    }
  }
  
  public void b(MessageRecord paramMessageRecord, String paramString)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    try
    {
      a(paramMessageRecord.frienduin, paramMessageRecord);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramMessageRecord);
      a(localArrayList, paramString, false, true, true, true);
      if (QLog.isColorLevel()) {
        QLog.d("sendmsg", 2, "addSendMessage key =" + paramMessageRecord.uniseq + paramMessageRecord.frienduin + paramMessageRecord.istroop);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramMessageRecord);
      setChanged();
      notifyObservers(paramMessageRecord);
      return;
    }
    finally
    {
      paramString.a();
    }
  }
  
  public void b(String paramString, int paramInt)
  {
    SQLiteDatabase localSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localSQLiteDatabase == null) {
      return;
    }
    Object localObject = (Integer)this.jdField_d_of_type_JavaUtilMap.get(paramString);
    int i2;
    if ((localObject == null) || (((Integer)localObject).intValue() == 0))
    {
      i1 = localSQLiteDatabase.a(paramString);
      i2 = i1 + 1;
      i1 = i2;
      if (i2 > 5000)
      {
        i1 = Math.max(i2 - 5000, 200);
        if (paramInt != 0) {
          break label152;
        }
        localObject = String.format("delete from %s where time in (select time from %s order by time limit %s)", new Object[] { paramString, paramString, Integer.valueOf(i1) });
      }
    }
    for (;;)
    {
      try
      {
        System.currentTimeMillis();
        localSQLiteDatabase.a((String)localObject);
        i1 = i2 - i1;
      }
      catch (Exception localException)
      {
        label152:
        i1 = 0;
        continue;
      }
      this.jdField_d_of_type_JavaUtilMap.put(paramString, Integer.valueOf(i1));
      return;
      i1 = ((Integer)localObject).intValue();
      break;
      if ((paramInt == 1) || (paramInt == 3000)) {
        localObject = String.format("delete from %s where shmsgseq in (select shmsgseq from %s order by shmsgseq limit %s)", new Object[] { paramString, paramString, Integer.valueOf(i1) });
      } else {
        localObject = String.format("delete from %s where _id in (select _id from %s order by _id limit %s)", new Object[] { paramString, paramString, Integer.valueOf(i1) });
      }
    }
  }
  
  public void b(String paramString, int paramInt, long paramLong)
  {
    int i1 = 1;
    MessageRecord localMessageRecord = b(paramString, paramInt, paramLong);
    if (a(paramInt).b(paramString, paramInt, paramLong) == 2) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString, paramInt, -1);
    }
    if (localMessageRecord != null) {
      if ((localMessageRecord instanceof MessageForLongMsg))
      {
        if (!MsgProxyUtils.a(localMessageRecord, a(localMessageRecord.frienduin, localMessageRecord.istroop))) {
          break label120;
        }
        paramInt = i1;
        if (paramInt != 0)
        {
          if (!MsgProxyUtils.k(localMessageRecord.istroop)) {
            break label125;
          }
          a(localMessageRecord.istroop).a(localMessageRecord);
        }
      }
    }
    label120:
    label125:
    while (!QLog.isColorLevel())
    {
      for (;;)
      {
        return;
        paramInt = i1;
        if (!a(localMessageRecord)) {
          paramInt = 0;
        }
      }
      a(localMessageRecord.istroop).b(localMessageRecord);
      return;
    }
    QLog.w("Q.msg.QQMessageFacade", 2, "removeMsgByUniseq error: message not found. uin=" + paramString + ",type=" + paramInt + ",uniseq=" + paramLong);
  }
  
  public void b(String paramString, long paramLong)
  {
    if (paramLong < 0L) {
      return;
    }
    d(paramString, 3000);
  }
  
  public void b(List paramList, String paramString)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    try
    {
      a(paramList, paramString, false, true, true, false);
      paramString.a();
      paramList = MsgProxyUtils.a(paramList);
      if (paramList != null)
      {
        setChanged();
        notifyObservers(paramList);
      }
      return;
    }
    finally
    {
      paramString.a();
    }
  }
  
  public boolean b(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.b())
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt);
      return true;
    }
    return false;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public void c()
  {
    a(0).c();
    a(3000).c();
    a(1).c();
  }
  
  public void c(QQMessageFacade.Message paramMessage)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      if (a(this.jdField_a_of_type_JavaUtilList, paramMessage)) {
        this.jdField_a_of_type_JavaUtilList.set(a(this.jdField_a_of_type_JavaUtilList, paramMessage), paramMessage);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(paramMessage);
  }
  
  public void c(String paramString, int paramInt)
  {
    a(paramInt).a(paramString, paramInt);
  }
  
  public void c(String paramString, long paramLong)
  {
    if (paramLong < 0L) {
      return;
    }
    d(paramString, 0);
  }
  
  public void c(List paramList, String paramString)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString).createEntityManager();
    try
    {
      a(paramList, paramString, true, false, true, true);
      paramString.a();
      paramList = MsgProxyUtils.a(paramList);
      if (paramList != null)
      {
        setChanged();
        notifyObservers(paramList);
      }
      return;
    }
    finally
    {
      paramString.a();
    }
  }
  
  public boolean c(String paramString, int paramInt)
  {
    if ((paramString != null) && (this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager.a(paramString, paramInt);
    }
    return false;
  }
  
  public int d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i1 = 0;
    while (localIterator.hasNext())
    {
      QQMessageFacade.Message localMessage = (QQMessageFacade.Message)localIterator.next();
      if ((localMessage.istroop != 1008) && (7000 != localMessage.istroop)) {
        for (;;)
        {
          i1 += 1;
        }
      }
    }
    return i1;
  }
  
  public void d()
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    boolean bool;
    int i1;
    if (this.o == -1)
    {
      bool = localEntityManager.d(ConversationInfo.getConversationInfoTableName());
      if (bool)
      {
        i1 = 1;
        this.o = i1;
      }
    }
    for (;;)
    {
      localEntityManager.a();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.QQMessageFacade", 2, "CACHE : refreshCache start : Lazy : " + bool);
      }
      long l1 = System.currentTimeMillis();
      if (bool)
      {
        a(0, true);
        this.jdField_b_of_type_Boolean = true;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.QQMessageFacade", 2, "CACHE : refreshCache finish : TimeSpend:" + (System.currentTimeMillis() - l1));
        }
        return;
        i1 = 0;
        break;
        e();
      }
      bool = true;
    }
  }
  
  public void d(String paramString, int paramInt)
  {
    a(paramInt).c(paramString, paramInt);
  }
  
  public int e()
  {
    int i1 = a(2);
    if ((i1 != 0) && (QLog.isColorLevel())) {
      QLog.d("Q.msg.QQMessageFacade", 2, "Recent Msg Unread=" + i1);
    }
    int i2;
    if (a().b(AppConstants.aj, 9000))
    {
      i2 = TroopNotificationUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((i2 != 0) && (QLog.isColorLevel())) {
        QLog.d("Q.msg.QQMessageFacade", 2, "Recent TroopNotification Unread=" + i1);
      }
      i1 += i2;
    }
    for (;;)
    {
      i2 = i1;
      if (a().b(AppConstants.V, 4000))
      {
        i2 = ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(31)).a();
        if ((i2 != 0) && (QLog.isColorLevel())) {
          QLog.d("Q.msg.QQMessageFacade", 2, "Recent NewFriendUnread Unread=" + i1);
        }
        i2 = i1 + i2;
      }
      return i2;
    }
  }
  
  public void e()
  {
    a("refreshCache", "");
    System.currentTimeMillis();
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    Object localObject1 = localEntityManager.a(Sqlite.class, "select distinct tbl_name from Sqlite_master where tbl_name like \"mr_%\"", null);
    int i2;
    if (localObject1 != null)
    {
      List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b();
      boolean bool1 = localEntityManager.d(ConversationInfo.getConversationInfoTableName());
      ConversationFacade localConversationFacade = a();
      StringBuilder localStringBuilder = new StringBuilder(128);
      Iterator localIterator = ((List)localObject1).iterator();
      int i1 = 0;
      boolean bool2;
      Object localObject2;
      label511:
      do
      {
        Object localObject3;
        do
        {
          do
          {
            i2 = i1;
            if (!localIterator.hasNext()) {
              break;
            }
            localObject3 = (Sqlite)localIterator.next();
            ((Sqlite)localObject3).tbl_name = SecurityUtile.a(((Sqlite)localObject3).tbl_name);
          } while (((Sqlite)localObject3).tbl_name.equals("mr_fileManager"));
          bool2 = ((Sqlite)localObject3).tbl_name.endsWith("_New");
          localObject2 = a(MsgProxyUtils.a(((Sqlite)localObject3).tbl_name)).a(((Sqlite)localObject3).tbl_name, localEntityManager);
          if (QLog.isDevelopLevel()) {
            QLog.d("Q.msg.QQMessageFacade", 4, "getMsgProxy().queryLastMessage = " + localObject2);
          }
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (((QQMessageFacade.Message)localObject2).uniseq == 0L)
            {
              a(((QQMessageFacade.Message)localObject2).istroop).b(((QQMessageFacade.Message)localObject2).frienduin, ((QQMessageFacade.Message)localObject2).istroop);
              localObject2 = a(((QQMessageFacade.Message)localObject2).istroop).a(((Sqlite)localObject3).tbl_name, localEntityManager);
              localObject1 = localObject2;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.msg.QQMessageFacade", 2, "requeryLastMessage = " + localObject2);
                localObject1 = localObject2;
              }
            }
          }
          if (localObject1 == null) {
            break label866;
          }
        } while ((((QQMessageFacade.Message)localObject1).frienduin.equals(String.valueOf(AppConstants.T))) && (!((Sqlite)localObject3).tbl_name.equals(DataLineMsgRecord.tableName())));
        if ((!AppConstants.Z.equals(((QQMessageFacade.Message)localObject1).frienduin)) && (((QQMessageFacade.Message)localObject1).istroop == 1001))
        {
          localObject2 = a(((QQMessageFacade.Message)localObject1).istroop).b(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop);
          if ((localObject2 != null) && (((List)localObject2).size() > 0))
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (MessageRecord)((Iterator)localObject2).next();
              if ((((MessageRecord)localObject3).senderuin != null) && (((MessageRecord)localObject3).senderuin.equals(((MessageRecord)localObject3).frienduin))) {
                ((QQMessageFacade.Message)localObject1).hasReply = true;
              }
            }
          }
        }
        a((QQMessageFacade.Message)localObject1);
        if (!bool1)
        {
          d((QQMessageFacade.Message)localObject1);
          if (localList != null)
          {
            i2 = 0;
            if (i2 < localList.size())
            {
              localObject2 = (RecentUser)localList.get(i2);
              if ((localObject2 == null) || (((RecentUser)localObject2).uin == null) || (!((RecentUser)localObject2).uin.equals(((QQMessageFacade.Message)localObject1).frienduin))) {
                break;
              }
              if ((MsgProxyUtils.k(((QQMessageFacade.Message)localObject1).istroop)) && (a().a(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop)))
              {
                if (((QQMessageFacade.Message)localObject1).istroop != 1009) {
                  a(AppConstants.S, 1009, ((QQMessageFacade.Message)localObject1).frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
                }
                if (((QQMessageFacade.Message)localObject1).istroop != 1001) {
                  a(AppConstants.Z, 1001, ((QQMessageFacade.Message)localObject1).frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
                }
              }
            }
          }
          localStringBuilder.setLength(0);
          localStringBuilder.append("refreshCache message uin = ").append(((QQMessageFacade.Message)localObject1).frienduin).append(", type = ").append(((QQMessageFacade.Message)localObject1).istroop).append(", unread = ").append(((QQMessageFacade.Message)localObject1).unReadNum).append(", time = ").append(((QQMessageFacade.Message)localObject1).time);
          a(localStringBuilder.toString(), "");
        }
        localObject2 = b(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop);
      } while ((!bool2) && (this.jdField_a_of_type_JavaUtilMap.containsKey(localObject2)));
      this.jdField_a_of_type_JavaUtilMap.put(localObject2, localObject1);
      i2 = i1 + 1;
      i1 = i2;
      if (!bool1)
      {
        localConversationFacade.a(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop, ((QQMessageFacade.Message)localObject1).unReadNum);
        i1 = i2;
      }
    }
    label866:
    for (;;)
    {
      break;
      i2 += 1;
      break label511;
      i2 = 0;
      localEntityManager.a();
      MsgAutoMonitorUtil.a().a("MSG_TableNum", i2 + "");
      return;
    }
  }
  
  public void e(String paramString, int paramInt)
  {
    paramString = new QQMessageFacade.MessageNotifyParam(paramString, paramInt, 0, null);
    setChanged();
    notifyObservers(paramString);
  }
  
  public int f()
  {
    return a(6);
  }
  
  public void f()
  {
    Object localObject1 = new RecentUser().getTableName();
    SQLiteDatabase localSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localSQLiteDatabase == null) {
      return;
    }
    localObject1 = localSQLiteDatabase.a((String)localObject1, new String[] { "uin", "type" }, null, null, null, null);
    if (localObject1 != null) {}
    try
    {
      ((Cursor)localObject1).moveToFirst();
      int i1 = 0;
      while (i1 < ((Cursor)localObject1).getCount())
      {
        a(((Cursor)localObject1).getString(0), ((Cursor)localObject1).getInt(1), false, true);
        ((Cursor)localObject1).moveToNext();
        i1 += 1;
      }
      if (localObject1 != null) {
        ((Cursor)localObject1).close();
      }
      a(0).e();
      a(0).d();
      a(3000).e();
      a(3000).d();
      a(1).e();
      a(1).d();
      return;
    }
    finally
    {
      if (localObject1 != null) {
        ((Cursor)localObject1).close();
      }
    }
  }
  
  public void f(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() < 5)) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager == null) || (paramString == null) || (paramString.length() < 5)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramInt);
  }
  
  public int g()
  {
    return a(7);
  }
  
  public void g()
  {
    String str1 = new RecentUser().getTableName();
    String str2 = new TroopAssistantData().getTableName();
    String str3 = new PubAccountAssistantData().getTableName();
    String str4 = new TroopBarData().getTableName();
    String str5 = new NeedHandleUserData().getTableName();
    SQLiteDatabase localSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localSQLiteDatabase == null) {
      return;
    }
    localSQLiteDatabase.a(str1, null, null);
    localSQLiteDatabase.a(str2, null, null);
    localSQLiteDatabase.a(str3, null, null);
    localSQLiteDatabase.a(str5, null, null);
    localSQLiteDatabase.a(str4, null, null);
    ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(31)).h();
    TroopAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
    i();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().c();
  }
  
  public int h()
  {
    return a(8);
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false);
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true);
  }
  
  public void j()
  {
    m();
  }
  
  public void k()
  {
    g(AppConstants.S, 1009);
    g(AppConstants.Z, 1001);
  }
  
  public void l()
  {
    StringBuilder localStringBuilder = new StringBuilder("MessageFacade : checkMsgCounts:");
    HashMap localHashMap = new HashMap(this.jdField_a_of_type_JavaUtilHashMap);
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    Iterator localIterator = localHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      int i1 = ((Integer)localHashMap.get(str)).intValue();
      if (QLog.isColorLevel()) {
        localStringBuilder.append(" tableName:").append(str).append(";");
      }
      b(str, i1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, localStringBuilder.toString());
    }
  }
  
  public void notifyObservers(Object paramObject)
  {
    long l1 = System.currentTimeMillis();
    super.notifyObservers(paramObject);
    MsgAutoMonitorUtil.a().c(System.currentTimeMillis() - l1);
    MsgAutoMonitorUtil.a().c();
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager.a();
    }
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
    if (this.jdField_b_of_type_JavaUtilMap != null) {
      this.jdField_b_of_type_JavaUtilMap.clear();
    }
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    this.jdField_b_of_type_Boolean = false;
    deleteObservers();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.QQMessageFacade
 * JD-Core Version:    0.7.0.1
 */