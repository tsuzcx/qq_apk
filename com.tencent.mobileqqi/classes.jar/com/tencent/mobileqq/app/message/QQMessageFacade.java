package com.tencent.mobileqq.app.message;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.dataline.activities.LiteActivity;
import com.dataline.util.WaitEvent;
import com.tencent.biz.pubaccount.assistant.PubAccountAssistantManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.contact.troop.TroopNotificationUtils;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.I18nPublicAccountsManagerImp;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.ChatHistorySearchData;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.DraftTextInfo;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.NeedHandleUserData;
import com.tencent.mobileqq.data.PubAccountAssistantData;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.Sqlite;
import com.tencent.mobileqq.data.SubAccountInfo;
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
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.sharealbum.QZoneShareAlbumAssistantManager;
import com.tencent.mobileqq.subaccount.SubAccountAssistantImpl;
import com.tencent.mobileqq.subaccount.SubAccountDataControll;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.TroopAndDiscMsgProxy;
import com.tencent.mobileqq.troop.data.TroopMessageManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import fjo;
import fjp;
import fjq;
import fjr;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.manager.Manager;
import msf.msgsvc.msg_svc.PbBindUinMsgReadedConfirmReq;
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
  public static final String a = "notification";
  public static final boolean a = true;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 2;
  public static final int f = 4;
  public static final int g = 5;
  public static final int h = 6;
  public static final int i = 7;
  private static final int k = 5000;
  private static final int l = 90;
  private static final int m = 8;
  private static final int o = 3;
  public Handler a;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private C2CMessageManager jdField_a_of_type_ComTencentMobileqqAppMessageC2CMessageManager;
  private DiscMessageManager jdField_a_of_type_ComTencentMobileqqAppMessageDiscMessageManager;
  private QQMessageFacade.Message jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message;
  private DraftTextManager jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager;
  private TroopMessageManager jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageManager;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public final List a;
  public final Map a;
  public final ConcurrentHashMap a;
  public final AtomicInteger a;
  private String jdField_b_of_type_JavaLangString = null;
  public Map b;
  public final ConcurrentHashMap b;
  private volatile boolean jdField_b_of_type_Boolean = false;
  private final String jdField_c_of_type_JavaLangString = "Q.msg.QQMessageFacade";
  private final Map jdField_c_of_type_JavaUtilMap = new HashMap();
  private int j = -1;
  private volatile int n = -1;
  
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
  
  private int a(String paramString, boolean paramBoolean, int paramInt)
  {
    int i2 = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "needShowSVipTips|senderUin=" + paramString + ",vipType=" + paramInt);
    }
    int i1 = i2;
    if (paramBoolean)
    {
      i1 = i2;
      if (paramInt == 0)
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
        paramInt = paramString.getInt("svip_last_type", 0);
        i1 = i2;
        if (paramString.getBoolean("svip_first_expired", false))
        {
          i1 = i2;
          if (paramInt != 0)
          {
            paramString.edit().putInt("svip_last_type", 0).commit();
            paramString.edit().putBoolean("svip_first_expired", false).commit();
            i1 = 3;
          }
        }
      }
    }
    return i1;
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
  
  private DataLineMsgProxy a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
  }
  
  private void a(DataLineMsgRecord paramDataLineMsgRecord, EntityManager paramEntityManager)
  {
    a().a(paramDataLineMsgRecord);
    b(paramDataLineMsgRecord.getTableName(), 6000);
    paramEntityManager = a().a(paramDataLineMsgRecord.groupId);
    QQMessageFacade.Message localMessage;
    if ((DataLineMsgSet.isSingle(paramDataLineMsgRecord)) || (paramEntityManager == null) || (paramEntityManager.getComeCount() <= 1))
    {
      localMessage = a(String.valueOf(AppConstants.P), 6000);
      localMessage.selfuin = String.valueOf(AppConstants.P);
      localMessage.senderuin = String.valueOf(AppConstants.P);
      localMessage.msgtype = paramDataLineMsgRecord.msgtype;
      localMessage.msg = paramDataLineMsgRecord.msg;
      localMessage.emoRecentMsg = null;
      localMessage.time = paramDataLineMsgRecord.time;
      localMessage.msgseq = paramDataLineMsgRecord.msgseq;
      localMessage.isread = paramDataLineMsgRecord.isread;
      localMessage.issend = paramDataLineMsgRecord.issend;
      localMessage.frienduin = String.valueOf(AppConstants.P);
      localMessage.istroop = 6000;
      localMessage.fileType = -1;
      localMessage.msgId = paramDataLineMsgRecord.msgId;
      a(localMessage);
      if (!paramDataLineMsgRecord.isSend()) {
        localMessage.hasReply = true;
      }
      if ((!paramDataLineMsgRecord.isSendFromLocal()) && (!paramDataLineMsgRecord.isread))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message = localMessage;
        if (!DataLineMsgSet.isSingle(paramDataLineMsgRecord)) {
          break label231;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localMessage.frienduin, localMessage.istroop, 1);
      }
    }
    label231:
    while ((paramEntityManager != null) && (paramEntityManager.getComeCount() != 1)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localMessage.frienduin, localMessage.istroop, 1);
  }
  
  private void a(String paramString, MessageRecord paramMessageRecord)
  {
    Object localObject = (SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12);
    paramMessageRecord.vipBubbleID = ((SVIPHandler)localObject).b();
    if (QLog.isColorLevel()) {
      QLog.i("vip", 2, "onMessageSend id=" + paramMessageRecord.vipBubbleID);
    }
    if (paramMessageRecord.istroop != 0) {}
    int i1;
    do
    {
      return;
      if (!((SVIPHandler)localObject).a)
      {
        ((SVIPHandler)localObject).c(1);
        ((SVIPHandler)localObject).a = true;
      }
      i1 = a(paramString, true, ((SVIPHandler)localObject).c());
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.QQMessageFacade", 2, "onMessageSend|showType=" + i1);
      }
    } while ((i1 == 0) || (i1 != 3));
    ((SVIPHandler)localObject).a = false;
    paramString = String.format("QQ会员已过期，<a href=%s>点击续费</a>尊享VIP多彩气泡。", new Object[] { ((SVIPHandler)localObject).b(false) });
    localObject = MessageRecordFactory.a(-4001);
    ((MessageRecord)localObject).init(paramMessageRecord.selfuin, paramMessageRecord.frienduin, paramMessageRecord.senderuin, paramString, paramMessageRecord.time, -4001, paramMessageRecord.istroop, paramMessageRecord.msgseq);
    a((MessageRecord)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
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
    paramEntityManager = ((BaseMessageManager.AddMessageContext)localObject1).d.keySet().iterator();
    while (paramEntityManager.hasNext())
    {
      localObject2 = (String)paramEntityManager.next();
      PubAccountAssistantManager.a().a((MessageRecord)((BaseMessageManager.AddMessageContext)localObject1).d.get(localObject2), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
          if (((MessageInfo)localObject2).a() == paramEntityManager.shmsgseq) {
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
        break label643;
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
          if (((MessageInfo)localObject2).a() != paramEntityManager.shmsgseq) {
            break;
          }
          i1 = ((MessageInfo)localObject2).b();
          break;
        }
        ((BaseMessageManager.AddMessageContext)localObject1).jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager.b(localRecentUser.uin);
      }
    }
    label643:
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
  
  public static String[] a(String paramString)
  {
    String[] arrayOfString = new String[3];
    int i1 = paramString.indexOf("http://maps.google.com/maps?q=");
    Object localObject;
    int i2;
    if (i1 >= 0)
    {
      paramString = paramString.substring(i1);
      localObject = Pattern.compile("\\s*(loc:)?-?\\d+(.\\d+)?\\s*,\\s*-?\\d+(.\\d+)?").matcher(paramString);
      if (((Matcher)localObject).find())
      {
        localObject = ((Matcher)localObject).group();
        if ((localObject != null) && (((String)localObject).length() > 0))
        {
          i2 = ((String)localObject).indexOf(',');
          i1 = ((String)localObject).indexOf("loc:");
          if (i2 >= 0)
          {
            if (i1 < 0) {
              break label181;
            }
            i1 += 4;
          }
        }
      }
    }
    for (;;)
    {
      arrayOfString[0] = ((String)localObject).substring(i1, i2);
      arrayOfString[1] = ((String)localObject).substring(i2 + 1, ((String)localObject).length());
      paramString = Pattern.compile("\\(.+\\)").matcher(paramString);
      if (paramString.find())
      {
        paramString = paramString.group();
        if ((paramString != null) && (paramString.length() > 2)) {
          arrayOfString[2] = paramString.substring(1, paramString.length() - 1);
        }
      }
      if (arrayOfString[2] == null) {
        arrayOfString[2] = "";
      }
      return arrayOfString;
      label181:
      i1 = 0;
    }
  }
  
  private int b(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a();
    int i2;
    if ((localObject == null) || (((Set)localObject).isEmpty()))
    {
      i2 = 0;
      return i2;
    }
    localObject = ((Set)localObject).iterator();
    int i1 = 0;
    for (;;)
    {
      i2 = i1;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      ConversationInfo localConversationInfo = (ConversationInfo)((Iterator)localObject).next();
      if (!localConversationInfo.uin.equalsIgnoreCase(AppConstants.ag)) {
        i1 = a(localConversationInfo.type).a(paramInt, localConversationInfo) + i1;
      }
    }
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
  
  private void b(EntityManager paramEntityManager)
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
  
  private void d(QQMessageFacade.Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.frienduin != null) && (paramMessage.frienduin.equals(AppConstants.N)) && (paramMessage.istroop == 1009))
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
  
  private void q()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((QQMessageFacade.Message)localIterator.next()).counter = 0;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public int a()
  {
    return this.j;
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
    new Handler(localLooper).post(new fjq(this, localDataLineMsgSet));
    return 0;
  }
  
  public int a(DataLineMsgSet paramDataLineMsgSet)
  {
    boolean bool = false;
    Object localObject = Looper.getMainLooper();
    if (Thread.currentThread() == ((Looper)localObject).getThread())
    {
      int i1 = a().a(paramDataLineMsgSet);
      if (i1 > 0)
      {
        paramDataLineMsgSet = b(String.valueOf(AppConstants.P), 6000);
        if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramDataLineMsgSet))
        {
          bool = ((QQMessageFacade.Message)this.jdField_a_of_type_JavaUtilMap.get(paramDataLineMsgSet)).hasReply;
          this.jdField_a_of_type_JavaUtilMap.remove(paramDataLineMsgSet);
        }
        if (a().a().size() > 0L)
        {
          paramDataLineMsgSet = a().a();
          localObject = new QQMessageFacade.Message();
          MessageRecord.copyMessageRecordBaseField((MessageRecord)localObject, paramDataLineMsgSet);
          ((QQMessageFacade.Message)localObject).emoRecentMsg = null;
          ((QQMessageFacade.Message)localObject).hasReply = bool;
          a((QQMessageFacade.Message)localObject);
          this.jdField_a_of_type_JavaUtilMap.put(b(((QQMessageFacade.Message)localObject).frienduin, ((QQMessageFacade.Message)localObject).istroop), localObject);
        }
        paramDataLineMsgSet = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(String.valueOf(AppConstants.P), 6000);
        paramDataLineMsgSet.a();
        if (localObject != null)
        {
          setChanged();
          notifyObservers(localObject);
        }
      }
      return i1;
    }
    new Handler((Looper)localObject).post(new fjr(this, paramDataLineMsgSet));
    return 0;
  }
  
  public int a(String paramString, int paramInt)
  {
    return a(paramString, paramInt, true, true);
  }
  
  public int a(String paramString, int paramInt, long paramLong)
  {
    int i1 = a(paramInt).b(paramString, paramInt, paramLong);
    Object localObject = b(paramString, paramInt);
    if ((i1 > 0) && (this.jdField_a_of_type_JavaUtilMap.containsKey(localObject)))
    {
      if (i1 == 2) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString, paramInt, -1);
      }
      int i2 = ((QQMessageFacade.Message)this.jdField_a_of_type_JavaUtilMap.get(localObject)).counter;
      boolean bool = ((QQMessageFacade.Message)this.jdField_a_of_type_JavaUtilMap.get(localObject)).hasReply;
      this.jdField_a_of_type_JavaUtilMap.remove(localObject);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramString, paramInt);
      MessageRecord localMessageRecord = b(paramString, paramInt);
      if (localMessageRecord == null) {
        break label216;
      }
      paramString = new QQMessageFacade.Message();
      MessageRecord.copyMessageRecordBaseField(paramString, localMessageRecord);
      paramString.emoRecentMsg = null;
      paramString.counter = i2;
      paramString.hasReply = bool;
      a(paramString);
      this.jdField_a_of_type_JavaUtilMap.put(b(paramString.frienduin, paramString.istroop), paramString);
    }
    for (;;)
    {
      if (localObject != null)
      {
        setChanged();
        notifyObservers(localObject);
      }
      return i1;
      label216:
      if ((paramString.equals(String.valueOf(AppConstants.R))) && (localObject != null)) {
        a((RecentUser)localObject);
      }
    }
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
  
  public long a(DataLineMsgRecord paramDataLineMsgRecord, boolean paramBoolean)
  {
    long l1;
    if (paramDataLineMsgRecord == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.QQMessageFacade", 2, "mr is null");
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
          RecentUser localRecentUser = ((RecentUserProxy)localObject2).a(String.valueOf(AppConstants.P), 6000);
          localRecentUser.type = 6000;
          localRecentUser.lastmsgtime = paramDataLineMsgRecord.time;
          ((RecentUserProxy)localObject2).a(localRecentUser);
          a(paramDataLineMsgRecord, (EntityManager)localObject1);
          long l2 = paramDataLineMsgRecord.msgId;
          if (paramBoolean) {
            paramDataLineMsgRecord.issuc = true;
          }
          setChanged();
          notifyObservers(paramDataLineMsgRecord);
          ((EntityManager)localObject1).a();
          l1 = l2;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.msg.QQMessageFacade", 2, "mr.msgId: " + l2);
            return l2;
          }
        }
        finally
        {
          ((EntityManager)localObject1).a();
        }
      }
    }
    new Handler((Looper)localObject2).post(new fjp(this, paramDataLineMsgRecord, (WaitEvent)localObject1));
    ((WaitEvent)localObject1).a(-1L);
    return 0L;
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
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageManager == null) {}
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageManager == null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageManager = new TroopMessageManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
        }
        return this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageManager;
      }
    }
    if (paramInt == 3000)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppMessageDiscMessageManager == null) {}
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppMessageDiscMessageManager == null) {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageDiscMessageManager = new DiscMessageManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
        }
        return this.jdField_a_of_type_ComTencentMobileqqAppMessageDiscMessageManager;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageC2CMessageManager == null) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppMessageC2CMessageManager == null) {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageC2CMessageManager = new C2CMessageManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      }
      return this.jdField_a_of_type_ComTencentMobileqqAppMessageC2CMessageManager;
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
  
  public DiscMessageManager a()
  {
    return (DiscMessageManager)a(3000);
  }
  
  public QQMessageFacade.Message a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message;
  }
  
  public QQMessageFacade.Message a(String paramString, int paramInt)
  {
    if (paramString == null) {
      localObject1 = null;
    }
    StringBuilder localStringBuilder;
    String str1;
    do
    {
      return localObject1;
      System.currentTimeMillis();
      localStringBuilder = new StringBuilder("Case:");
      str1 = b(paramString, paramInt);
      localObject2 = (QQMessageFacade.Message)this.jdField_a_of_type_JavaUtilMap.get(str1);
      localObject1 = localObject2;
    } while (localObject2 != null);
    if (this.n == 0)
    {
      localObject1 = new QQMessageFacade.Message();
      ((QQMessageFacade.Message)localObject1).frienduin = paramString;
      ((QQMessageFacade.Message)localObject1).istroop = paramInt;
      this.jdField_a_of_type_JavaUtilMap.put(str1, localObject1);
      localStringBuilder.append("All-In");
      return localObject1;
    }
    if (!this.jdField_b_of_type_Boolean)
    {
      localObject1 = new QQMessageFacade.Message();
      ((QQMessageFacade.Message)localObject1).frienduin = paramString;
      ((QQMessageFacade.Message)localObject1).istroop = paramInt;
      ((QQMessageFacade.Message)localObject1).isCacheValid = false;
      this.jdField_a_of_type_JavaUtilMap.put(str1, localObject1);
      localStringBuilder.append("Not-Finish-Yet");
      return localObject1;
    }
    Object localObject1 = MessageRecord.getTableName(paramString, paramInt);
    String str2 = MessageRecord.getOldTableName(paramString, paramInt);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    if ((((EntityManager)localObject2).d((String)localObject1)) || (((EntityManager)localObject2).d(str2)))
    {
      paramString = a(paramString, paramInt, (EntityManager)localObject2);
      localStringBuilder.append("Check-DB");
    }
    for (;;)
    {
      ((EntityManager)localObject2).a();
      return paramString;
      localObject1 = new QQMessageFacade.Message();
      ((QQMessageFacade.Message)localObject1).frienduin = paramString;
      ((QQMessageFacade.Message)localObject1).istroop = paramInt;
      this.jdField_a_of_type_JavaUtilMap.put(str1, localObject1);
      localStringBuilder.append("Not-In-TableCache");
      paramString = (String)localObject1;
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
  
  public DataLineMsgRecord a(long paramLong)
  {
    return a().a(paramLong);
  }
  
  public DataLineMsgSet a(long paramLong)
  {
    return a().b(paramLong);
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
    return this.jdField_b_of_type_JavaLangString;
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
        else if (String.valueOf(9992L).equals(((ConversationInfo)localObject3).uin))
        {
          localObject2 = SubAccountDataControll.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (localObject2 != null)
          {
            SubAccountDataControll.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((SubAccountInfo)localObject2).subuin);
            localObject2 = SubAccountAssistantImpl.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            if (localObject2 != null)
            {
              localObject3 = new msg_svc.PbBindUinMsgReadedConfirmReq();
              ((msg_svc.PbBindUinMsgReadedConfirmReq)localObject3).sync_cookie.set(ByteStringMicro.copyFrom((byte[])localObject2));
              localPbMsgReadedReportReq.bind_uin_read_report.set((MessageMicro)localObject3);
              localStringBuilder.append("{SUBUIN}");
            }
          }
        }
        else
        {
          if ((1006 != ((ConversationInfo)localObject3).type) && ((!MsgProxyUtils.a(((ConversationInfo)localObject3).type)) || (Long.valueOf(((ConversationInfo)localObject3).uin).longValue() <= 10000L))) {
            break label734;
          }
          c(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type);
          l1 = b(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type);
          if (l1 != -1L) {
            break label588;
          }
        }
      }
    }
    label501:
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
    label588:
    localObject2 = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
    if (1006 == ((ConversationInfo)localObject3).type)
    {
      ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject2).peer_uin.set(Long.valueOf(ContactUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((ConversationInfo)localObject3).uin)).longValue());
      localStringBuilder.append("{C2C:").append(Long.valueOf(ContactUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((ConversationInfo)localObject3).uin))).append(((ConversationInfo)localObject3).type).append("}");
      label675:
      ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject2).last_read_time.set((int)l1);
      if (localObject1 != null) {
        break label948;
      }
      localObject1 = new msg_svc.PbC2CReadedReportReq();
    }
    label948:
    for (;;)
    {
      ((msg_svc.PbC2CReadedReportReq)localObject1).pair_info.add((MessageMicro)localObject2);
      break;
      ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject2).peer_uin.set(Long.valueOf(((ConversationInfo)localObject3).uin).longValue());
      break label675;
      label734:
      if (3000 == ((ConversationInfo)localObject3).type)
      {
        c(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type);
        l1 = b(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type);
        if (l1 == -1L) {
          break label501;
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
        break label501;
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
    ThreadManager.a(new fjo(this));
  }
  
  public void a(int paramInt)
  {
    String str = String.valueOf(AppConstants.ah);
    if (a().a(str, 4000) <= 0) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.QQMessageFacade", 2, "setRecommendMsgReaded return : unread=0");
      }
    }
    do
    {
      return;
      QQMessageFacade.Message localMessage = a(str, 4000);
      paramInt = a(4000).a(paramInt, localMessage);
      a().b(str, 4000, -paramInt);
    } while (paramInt == 0);
    setChanged();
    notifyObservers(a(str, 4000));
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    int i2 = 0;
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    int i1;
    if (this.n == -1)
    {
      if (localEntityManager.d(ConversationInfo.getConversationInfoTableName()))
      {
        i1 = 1;
        this.n = i1;
      }
    }
    else
    {
      localObject = ((RecentUserProxy)localObject).a();
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
        b(localEntityManager);
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
  
  public void a(long paramLong)
  {
    a().b(paramLong);
  }
  
  public void a(long paramLong, String paramString, byte[] paramArrayOfByte)
  {
    a().a(paramLong, paramString, paramArrayOfByte);
  }
  
  public void a(QQMessageFacade.Message paramMessage)
  {
    a(paramMessage.istroop).a(paramMessage);
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (!paramMessageRecord.isSendFromLocal()) {}
    for (;;)
    {
      return;
      TransFileController localTransFileController = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      ArrayList localArrayList = new ArrayList();
      Object localObject;
      if ((paramMessageRecord instanceof MessageForMixedMsg))
      {
        paramMessageRecord = (MessageForMixedMsg)paramMessageRecord;
        i2 = paramMessageRecord.msgElemList.size();
        i1 = 0;
        while (i1 < i2)
        {
          localObject = (MessageRecord)paramMessageRecord.msgElemList.get(i1);
          if ((localObject instanceof MessageForPic)) {
            localArrayList.add((MessageForPic)localObject);
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
          localObject = (MessageRecord)paramMessageRecord.longMsgFragmentList.get(i1);
          if ((localObject instanceof MessageForPic)) {
            localArrayList.add((MessageForPic)localObject);
          }
          for (;;)
          {
            i1 += 1;
            break;
            if ((localObject instanceof MessageForMixedMsg))
            {
              localObject = (MessageForMixedMsg)localObject;
              int i4 = ((MessageForMixedMsg)localObject).msgElemList.size();
              i2 = 0;
              while (i2 < i4)
              {
                MessageRecord localMessageRecord = (MessageRecord)((MessageForMixedMsg)localObject).msgElemList.get(i2);
                if ((localMessageRecord instanceof MessageForPic)) {
                  localArrayList.add((MessageForPic)localMessageRecord);
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
        localArrayList.add((MessageForPic)paramMessageRecord);
      }
      int i2 = localArrayList.size();
      int i1 = 0;
      while (i1 < i2)
      {
        paramMessageRecord = (MessageForPic)localArrayList.get(i1);
        paramMessageRecord = paramMessageRecord.frienduin + paramMessageRecord.uniseq + "_" + paramMessageRecord.subMsgId;
        localObject = localTransFileController.a(paramMessageRecord);
        if ((localObject != null) && ((localObject instanceof BaseTransProcessor)))
        {
          ((BaseTransProcessor)localObject).h();
          localTransFileController.d(paramMessageRecord);
        }
        i1 += 1;
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, MessageObserver paramMessageObserver)
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
      b(paramMessageRecord, paramMessageObserver);
    } while (!QLog.isColorLevel());
    QLog.d("SendMsgBtn", 2, " addAndSendMessage sendMessage end currenttime:" + System.currentTimeMillis());
  }
  
  public void a(MessageRecord paramMessageRecord, String paramString)
  {
    Object localObject = (I18nPublicAccountsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53);
    if ((localObject != null) && (paramMessageRecord.istroop == 1008) && (!((I18nPublicAccountsManagerImp)localObject).a(paramMessageRecord.senderuin)) && (!paramMessageRecord.senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))) {
      return;
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString).createEntityManager();
    try
    {
      localObject = new ArrayList();
      ((List)localObject).add(paramMessageRecord);
      a((List)localObject, paramString, false, true, true, true);
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
    a(paramMessageRecord.istroop).a(paramMessageRecord, paramBoolean);
  }
  
  public void a(RecentUser paramRecentUser)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b(paramRecentUser);
    c(paramRecentUser.uin, paramRecentUser.type);
  }
  
  public void a(EntityManager paramEntityManager)
  {
    Object localObject = paramEntityManager.a(PubAccountAssistantData.class, false, null, null, null, null, "mLastMsgTime desc", null);
    if ((localObject == null) || (((List)localObject).size() == 0)) {}
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        PubAccountAssistantData localPubAccountAssistantData = (PubAccountAssistantData)((Iterator)localObject).next();
        a(localPubAccountAssistantData.mUin, localPubAccountAssistantData.mType, paramEntityManager);
      }
    }
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
    this.jdField_b_of_type_JavaLangString = paramString;
    this.j = paramInt;
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
  
  public void a(String paramString, int paramInt1, long paramLong, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext, ArrayList paramArrayList)
  {
    MessageRecord localMessageRecord1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, paramLong);
    Object localObject1 = new StringBuilder().append("loadFromLocal uniseq=").append(paramLong).append(",count=").append(paramInt2).append(", fromtime=");
    label134:
    MessageRecord localMessageRecord2;
    if (localMessageRecord1 == null)
    {
      paramLong = -1L;
      a(paramLong, "");
      if (localMessageRecord1 == null) {
        break label500;
      }
      long l3 = localMessageRecord1.time;
      long l2 = localMessageRecord1.getId();
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).b(paramString, paramInt1);
      localObject1 = new ArrayList();
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localMessageRecord2 = (MessageRecord)((Iterator)localObject2).next();
          if ((localMessageRecord2.time <= l3) && (!MsgProxyUtils.a(localMessageRecord1, localMessageRecord2, true))) {
            break label451;
          }
        }
        a("loadFromLocal load from Cache", (Collection)localObject1);
      }
      long l1 = l2;
      paramLong = l3;
      if (paramArrayList.size() < paramInt2)
      {
        l1 = l2;
        paramLong = l3;
        if (((List)localObject1).size() > 0)
        {
          paramArrayList.addAll(0, ((List)localObject1).subList(Math.max(((List)localObject1).size() - (paramInt2 - paramArrayList.size()), 0), ((List)localObject1).size()));
          l1 = l2;
          paramLong = l3;
          if (paramArrayList.size() > 0)
          {
            paramLong = Math.min(l3, ((MessageRecord)paramArrayList.get(0)).time);
            l1 = Math.max(Math.min(l2, ((MessageRecord)paramArrayList.get(0)).getId()), 0L);
          }
        }
      }
      if (paramArrayList.size() < paramInt2)
      {
        paramString = a(paramInt1).a(paramString, paramInt1, l1, localMessageRecord1.versionCode, paramLong, paramInt2, String.format(" or (time=%d and _id<%d) ", new Object[] { Long.valueOf(paramLong), Long.valueOf(l1) }));
        a("queryTimedMessageDBUnion list size" + paramString.size() + ", getID=" + localMessageRecord1.getId(), "");
        if (!paramString.isEmpty()) {
          break label464;
        }
        paramRefreshMessageContext.a = true;
      }
    }
    for (;;)
    {
      paramRefreshMessageContext.c = true;
      return;
      paramLong = localMessageRecord1.time;
      break;
      label451:
      ((List)localObject1).add(localMessageRecord2);
      break label134;
      label464:
      if (paramString.size() < paramInt2) {
        paramRefreshMessageContext.a = true;
      }
      a("loadFromLocal load from DB", paramString);
      paramArrayList.addAll(0, paramString);
    }
    label500:
    paramRefreshMessageContext.c = true;
    paramRefreshMessageContext.a = true;
    a("loadFromLocal complete", "");
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
    return (this.jdField_b_of_type_JavaLangString != null) && (this.j >= 0);
  }
  
  public boolean a(long paramLong)
  {
    return a().a(paramLong);
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    return a(paramMessageRecord.frienduin, paramMessageRecord.istroop).uniseq == paramMessageRecord.uniseq;
  }
  
  protected boolean a(FriendManager paramFriendManager, String paramString)
  {
    paramFriendManager = (I18nPublicAccountsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53);
    if (paramFriendManager != null) {
      return paramFriendManager.a(paramString);
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.b())
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(paramString));
      return true;
    }
    return false;
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
    QQMessageFacade.Message localMessage = a(String.valueOf(AppConstants.P), 6000);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() == null) {
      return 0;
    }
    int i1 = a().a();
    if (i1 > 0)
    {
      localMessage.msg = null;
      localMessage.emoRecentMsg = null;
      localMessage.fileType = -1;
    }
    setChanged();
    notifyObservers(localMessage);
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
  
  public DataLineMsgRecord b(long paramLong)
  {
    return a().b(paramLong);
  }
  
  public MessageRecord b(String paramString, int paramInt, long paramLong)
  {
    return a(paramInt).b(paramString, paramInt, paramLong);
  }
  
  public void b()
  {
    this.jdField_b_of_type_JavaLangString = null;
    this.j = -1;
  }
  
  public void b(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(4000).b(String.valueOf(AppConstants.ah), 4000);
    if ((localObject == null) || (((List)localObject).size() == 0)) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramInt);
    } while (a(4000).a(paramInt) <= 0);
    setChanged();
    localObject = new RecentUser();
    ((RecentUser)localObject).uin = String.valueOf(AppConstants.ag);
    notifyObservers(localObject);
  }
  
  public void b(long paramLong)
  {
    a().c(paramLong);
  }
  
  public void b(QQMessageFacade.Message paramMessage)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message = paramMessage;
  }
  
  public void b(MessageRecord paramMessageRecord, MessageObserver paramMessageObserver)
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
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord, null);
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
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord, null);
        return;
        if ((paramMessageRecord.msgtype == -2011) || (paramMessageRecord.msgtype == -2007) || (paramMessageRecord.msgtype == -2002) || (paramMessageRecord.msgtype == -2000) || (paramMessageRecord.msgtype == -2010) || (paramMessageRecord.msgtype == -2020)) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord, paramMessageObserver);
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
    Object localObject = (Integer)this.jdField_c_of_type_JavaUtilMap.get(paramString);
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
      this.jdField_c_of_type_JavaUtilMap.put(paramString, Integer.valueOf(i1));
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
    if ((paramString != null) && (this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager.a(paramString, paramInt);
    }
    return false;
  }
  
  public int c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    for (int i1 = 0; localIterator.hasNext(); i1 = ((QQMessageFacade.Message)localIterator.next()).counter + i1) {}
    return i1;
  }
  
  public void c()
  {
    a(0).c();
    a(3000).c();
    a(1).c();
  }
  
  public void c(long paramLong)
  {
    a().a(paramLong);
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
    return this.jdField_b_of_type_JavaUtilMap.containsKey(b(paramString, paramInt));
  }
  
  public int d()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public void d()
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    boolean bool;
    int i1;
    if (this.n == -1)
    {
      bool = localEntityManager.d(ConversationInfo.getConversationInfoTableName());
      if (bool)
      {
        i1 = 1;
        this.n = i1;
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
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i1 = 0;
    while (localIterator.hasNext())
    {
      QQMessageFacade.Message localMessage = (QQMessageFacade.Message)localIterator.next();
      if (localMessage.istroop != 1008)
      {
        if (7000 == localMessage.istroop) {
          i1 = SubAccountDataControll.a().a() + i1;
        }
        for (;;)
        {
          break;
          i1 += 1;
        }
      }
    }
    return i1;
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
      List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a();
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
        } while ((((QQMessageFacade.Message)localObject1).frienduin.equals(String.valueOf(AppConstants.P))) && (!((Sqlite)localObject3).tbl_name.equals(DataLineMsgRecord.tableName())));
        if ((!AppConstants.V.equals(((QQMessageFacade.Message)localObject1).frienduin)) && (((QQMessageFacade.Message)localObject1).istroop == 1001))
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
              if ((MsgProxyUtils.l(((QQMessageFacade.Message)localObject1).istroop)) && (a().a(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop)))
              {
                if (((QQMessageFacade.Message)localObject1).istroop != 1009) {
                  a(AppConstants.N, 1009, ((QQMessageFacade.Message)localObject1).frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
                }
                if (((QQMessageFacade.Message)localObject1).istroop != 1001) {
                  a(AppConstants.V, 1001, ((QQMessageFacade.Message)localObject1).frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
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
    int i2 = b(2) + QZoneShareAlbumAssistantManager.a().a();
    int i1 = i2;
    if (a().b(AppConstants.ag, 9000)) {
      i1 = i2 + TroopNotificationUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    return i1;
  }
  
  public void f()
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    try
    {
      RecentUserProxy localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      RecentUser localRecentUser = localRecentUserProxy.a(String.valueOf(AppConstants.P), 6000);
      localRecentUser.type = 6000;
      localRecentUser.lastmsgtime = MessageCache.a();
      localRecentUserProxy.a(localRecentUser);
      localEntityManager.a();
      setChanged();
      notifyObservers(a(String.valueOf(AppConstants.P), 6000));
      return;
    }
    finally
    {
      localEntityManager.a();
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
    return b(6);
  }
  
  public void g()
  {
    a().d();
  }
  
  public int h()
  {
    return b(7);
  }
  
  public void h()
  {
    a().c();
  }
  
  public void i()
  {
    if (!LiteActivity.class.getName().equals(ConfigHandler.a(BaseApplication.getContext()))) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.QQMessageFacade", 2, "setDataLineMsgReaded,unread=" + a().a(AppConstants.P, 6000));
      }
    } while (a().a(AppConstants.P, 6000) <= 0);
    a().e();
    a().a(AppConstants.P, 6000);
    setChanged();
    notifyObservers(a(AppConstants.P, 6000));
  }
  
  public void j()
  {
    Object localObject = new RecentUser().getTableName();
    SQLiteDatabase localSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localSQLiteDatabase == null) {
      return;
    }
    localObject = localSQLiteDatabase.a((String)localObject, new String[] { "uin", "type" }, null, null, null, null);
    if (localObject != null)
    {
      ((Cursor)localObject).moveToFirst();
      int i1 = 0;
      while (i1 < ((Cursor)localObject).getCount())
      {
        a(((Cursor)localObject).getString(0), ((Cursor)localObject).getInt(1), false, true);
        ((Cursor)localObject).moveToNext();
        i1 += 1;
      }
      ((Cursor)localObject).close();
    }
    a(0).e();
    a(0).d();
    a(3000).e();
    a(3000).d();
    a(1).e();
    a(1).d();
  }
  
  public void k()
  {
    String str1 = new RecentUser().getTableName();
    String str2 = new TroopAssistantData().getTableName();
    String str3 = new PubAccountAssistantData().getTableName();
    String str4 = new NeedHandleUserData().getTableName();
    SQLiteDatabase localSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localSQLiteDatabase == null) {
      return;
    }
    localSQLiteDatabase.a(str1, null, null);
    localSQLiteDatabase.a(str2, null, null);
    localSQLiteDatabase.a(str3, null, null);
    localSQLiteDatabase.a(str4, null, null);
    ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32)).h();
    TroopAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
    QZoneShareAlbumAssistantManager.a().l(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    m();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().c();
  }
  
  public void l()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false);
  }
  
  public void m()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true);
  }
  
  public void n()
  {
    q();
  }
  
  public void notifyObservers(Object paramObject)
  {
    long l1 = System.currentTimeMillis();
    super.notifyObservers(paramObject);
    MsgAutoMonitorUtil.a().c(System.currentTimeMillis() - l1);
    MsgAutoMonitorUtil.a().c();
  }
  
  public void o()
  {
    g(AppConstants.N, 1009);
    g(AppConstants.V, 1001);
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
  
  public void p()
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.QQMessageFacade
 * JD-Core Version:    0.7.0.1
 */