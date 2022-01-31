package com.tencent.mobileqq.app.message;

import ActionMsg.MsgBody;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.FunnyFaceMessage;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.systemmsg.SystemMsgController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import fnf;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public abstract class BaseMessageManager
{
  public static final int a = 0;
  static final long a = 35000L;
  public static final String a = "Q.msg.BaseMessageManager";
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  protected QQAppInterface a;
  public QQMessageFacade a;
  
  public BaseMessageManager(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade = paramQQMessageFacade;
  }
  
  private long a(String paramString, int paramInt)
  {
    if (paramString == null) {
      return 0L;
    }
    Object localObject = null;
    if (paramInt == 1009) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a(AppConstants.N, 1009);
    }
    while ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((List)localObject).iterator();
      MessageRecord localMessageRecord;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localMessageRecord = (MessageRecord)((Iterator)localObject).next();
      } while (!paramString.equals(localMessageRecord.senderuin));
      return localMessageRecord.uniseq;
      if (paramInt == 1001) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a(AppConstants.V, 1001);
      }
    }
    return 0L;
  }
  
  private void a(MessageRecord paramMessageRecord)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    if (localObject != null) {
      b(((MessageRecord)localObject).frienduin, ((MessageRecord)localObject).istroop, (MessageRecord)localObject, 4);
    }
    for (;;)
    {
      return;
      localObject = null;
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (paramMessageRecord.istroop == 1001)
      {
        a(AppConstants.V, paramMessageRecord.istroop, paramMessageRecord.frienduin, str);
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(AppConstants.V, 1001);
      }
      while ((localObject != null) && (((QQMessageFacade.Message)localObject).senderuin != null) && (((QQMessageFacade.Message)localObject).senderuin.equals(paramMessageRecord.frienduin)))
      {
        ((QQMessageFacade.Message)localObject).cleanMessageRecordBaseField();
        return;
        if (paramMessageRecord.istroop == 1009)
        {
          a(AppConstants.N, paramMessageRecord.istroop, paramMessageRecord.frienduin, str);
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(AppConstants.N, 1009);
        }
      }
    }
  }
  
  private boolean a(String paramString)
  {
    if (paramString.charAt(0) == '\026')
    {
      paramString = paramString.split("\026")[1].split("\\|");
      if (paramString.length < 2) {
        return true;
      }
      if (paramString.length > 3) {
        try
        {
          Long.valueOf(paramString[1]);
          Integer.valueOf(paramString[2]);
          Boolean.valueOf(paramString[3]);
          return true;
        }
        catch (NumberFormatException paramString)
        {
          return false;
        }
      }
      return false;
    }
    return false;
  }
  
  private void b(MessageRecord paramMessageRecord)
  {
    Object localObject = paramMessageRecord.frienduin;
    int i = paramMessageRecord.istroop;
    paramMessageRecord = MsgProxyUtils.a((String)localObject, i);
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.containsKey(paramMessageRecord))
    {
      paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a((String)localObject, i);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a((String)localObject, i);
      if (localObject == null) {
        break label155;
      }
      a((MessageRecord)localObject, true, 4);
      if (paramMessageRecord != null)
      {
        if ((((MessageRecord)localObject).istroop == 1000) || (((MessageRecord)localObject).istroop == 1020) || (((MessageRecord)localObject).istroop == 1004)) {
          paramMessageRecord.troopUin = ((MessageRecord)localObject).senderuin;
        }
        paramMessageRecord.type = ((MessageRecord)localObject).istroop;
        paramMessageRecord.lastmsgtime = ((MessageRecord)localObject).time;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramMessageRecord);
      }
    }
    for (;;)
    {
      if (paramMessageRecord != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramMessageRecord);
      }
      return;
      label155:
      if (paramMessageRecord != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTabAfterDelMsg : No MessageRecord for replacing the mstTab, delete the ru.");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramMessageRecord);
      }
    }
  }
  
  public int a(int paramInt, ConversationInfo paramConversationInfo)
  {
    if (paramConversationInfo.unreadCount > 0) {
      if (paramInt == 2)
      {
        if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramConversationInfo.uin, paramConversationInfo.type)) && (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().b(paramConversationInfo.uin, paramConversationInfo.type))) {
          return paramConversationInfo.unreadCount;
        }
      }
      else if (paramInt == 5)
      {
        if (paramConversationInfo.type != 1001) {
          return paramConversationInfo.unreadCount;
        }
      }
      else if (paramInt == 6)
      {
        if ((paramConversationInfo.type == 1001) && (AppConstants.V.equals(paramConversationInfo.uin)) && (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().b(paramConversationInfo.uin, paramConversationInfo.type))) {
          return paramConversationInfo.unreadCount;
        }
      }
      else if (paramInt == 7)
      {
        if ((paramConversationInfo.type == 1009) && (paramConversationInfo.uin.equals(AppConstants.N))) {
          return paramConversationInfo.unreadCount;
        }
      }
      else {
        return paramConversationInfo.unreadCount;
      }
    }
    return 0;
  }
  
  public int a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "clearHistory uin = " + paramString + ", type = " + paramInt + ", needDeleteDB = " + paramBoolean1);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString, paramInt);
    QQMessageFacade.Message localMessage = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString, paramInt);
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a(paramString, paramInt, paramBoolean1);
    Object localObject;
    switch (paramInt)
    {
    default: 
      if ((3000 != paramInt) && (1 != paramInt) && (5000 != paramInt)) {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString);
      }
      if (i > 0) {
        localMessage.cleanMessageRecordBaseField();
      }
      if ((paramInt != 3000) && (paramInt != 1) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt)))
      {
        if (paramInt != 1009) {
          break label322;
        }
        a(AppConstants.N, 1009, paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(AppConstants.N, 1009);
        if ((((QQMessageFacade.Message)localObject).senderuin != null) && (((QQMessageFacade.Message)localObject).senderuin.equals(paramString))) {
          ((QQMessageFacade.Message)localObject).cleanMessageRecordBaseField();
        }
      }
      break;
    }
    for (;;)
    {
      if (paramBoolean2)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramString, localMessage.istroop);
        if (localObject != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a((RecentUser)localObject);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.remove(MsgProxyUtils.a(paramString, paramInt));
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(localMessage);
      return i;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, 0);
      break;
      label322:
      if (paramInt == 1001)
      {
        a(AppConstants.V, 1001, paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(AppConstants.V, 1001);
        if ((((QQMessageFacade.Message)localObject).senderuin != null) && (((QQMessageFacade.Message)localObject).senderuin.equals(paramString))) {
          ((QQMessageFacade.Message)localObject).cleanMessageRecordBaseField();
        }
      }
    }
  }
  
  public abstract long a(MessageRecord paramMessageRecord);
  
  public QQMessageFacade.Message a(String paramString, int paramInt, EntityManager paramEntityManager)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramString == null)
    {
      paramEntityManager = (EntityManager)localObject2;
      return paramEntityManager;
    }
    String str = MsgProxyUtils.a(paramString, paramInt);
    localObject2 = (QQMessageFacade.Message)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.get(str);
    StringBuilder localStringBuilder = new StringBuilder("CACHE : refreshSingleLastMsg:uin:" + paramString + " uinType:" + paramInt);
    if ((localObject2 == null) || (!((QQMessageFacade.Message)localObject2).isCacheValid))
    {
      localObject1 = MessageRecord.getTableName(paramString, paramInt);
      if (paramString.equals(String.valueOf(AppConstants.P))) {
        localObject1 = DataLineMsgRecord.tableName();
      }
      QQMessageFacade.Message localMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a((String)localObject1, paramEntityManager);
      Object localObject3 = localObject1;
      localObject2 = localMessage;
      if (localMessage == null) {
        if ((!MsgProxyUtils.a(paramInt)) && (paramInt != 1))
        {
          localObject3 = localObject1;
          localObject2 = localMessage;
          if (paramInt != 3000) {}
        }
        else
        {
          localObject3 = MessageRecord.getOldTableName(paramString, paramInt);
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a((String)localObject3, paramEntityManager);
        }
      }
      if (QLog.isColorLevel()) {
        localStringBuilder.append(" message:" + localObject2);
      }
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((QQMessageFacade.Message)localObject2).uniseq == 0L)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(((QQMessageFacade.Message)localObject2).istroop).b(((QQMessageFacade.Message)localObject2).frienduin, ((QQMessageFacade.Message)localObject2).istroop);
          paramEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(((QQMessageFacade.Message)localObject2).istroop).a((String)localObject3, paramEntityManager);
          localObject1 = paramEntityManager;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.msg.BaseMessageManager", 2, "CACHE : requeryLastMessage = " + paramEntityManager);
            localObject1 = paramEntityManager;
          }
        }
      }
      if (localObject1 != null)
      {
        if (paramString.equals(String.valueOf(AppConstants.P)))
        {
          paramString = new DataLineMsgRecord();
          DataLineMsgRecord.unpackMsgData(paramString, ((QQMessageFacade.Message)localObject1).msgData, ((QQMessageFacade.Message)localObject1).versionCode);
          ((QQMessageFacade.Message)localObject1).msg = paramString.msg;
        }
        paramString = (String)localObject1;
        if (!AppConstants.V.equals(((QQMessageFacade.Message)localObject1).frienduin))
        {
          paramString = (String)localObject1;
          if (((QQMessageFacade.Message)localObject1).istroop == 1001)
          {
            paramEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(((QQMessageFacade.Message)localObject1).istroop).b(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop);
            paramString = (String)localObject1;
            if (paramEntityManager != null)
            {
              paramString = (String)localObject1;
              if (paramEntityManager.size() > 0)
              {
                paramEntityManager = paramEntityManager.iterator();
                do
                {
                  paramString = (String)localObject1;
                  if (!paramEntityManager.hasNext()) {
                    break;
                  }
                  paramString = (MessageRecord)paramEntityManager.next();
                } while ((paramString.senderuin == null) || (!paramString.senderuin.equals(paramString.frienduin)));
                ((QQMessageFacade.Message)localObject1).hasReply = true;
                paramString = (String)localObject1;
              }
            }
          }
        }
        label520:
        paramEntityManager = (QQMessageFacade.Message)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.get(str);
        if (paramEntityManager != null) {
          break label622;
        }
        if (QLog.isColorLevel()) {
          localStringBuilder.append(" : case 1 : null inplace");
        }
        a(paramString);
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.put(str, paramString);
      }
    }
    for (;;)
    {
      paramEntityManager = paramString;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.msg.BaseMessageManager", 2, localStringBuilder.toString());
      return paramString;
      paramEntityManager = new QQMessageFacade.Message();
      paramEntityManager.frienduin = paramString;
      paramEntityManager.istroop = paramInt;
      paramString = paramEntityManager;
      break label520;
      label622:
      if (a(paramEntityManager) < a(paramString))
      {
        a(paramString);
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.put(str, paramString);
      }
      else
      {
        if (QLog.isColorLevel()) {
          localStringBuilder.append(" : case 4 :invalid inplace");
        }
        paramEntityManager.isCacheValid = true;
        paramString = paramEntityManager;
        continue;
        paramString = (String)localObject1;
        if (QLog.isColorLevel())
        {
          localStringBuilder.append(" : case 5 : not null or isValid : " + localObject2);
          paramString = (String)localObject1;
        }
      }
    }
  }
  
  public List a(String paramString, int paramInt, boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a(paramString, paramInt, true, true);
    if (localObject1 == null) {
      return new ArrayList();
    }
    localObject1 = (List)((ArrayList)localObject1).clone();
    MsgProxyUtils.a((List)localObject1);
    MsgProxyUtils.a(paramString, paramInt, (List)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Object localObject2;
    if ((!((List)localObject1).isEmpty()) && ((((List)localObject1).get(((List)localObject1).size() - 1) instanceof MessageForLongMsg)) && (MsgProxyUtils.a((MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1), this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString, paramInt))))
    {
      localObject2 = (MessageForLongMsg)((List)localObject1).get(((List)localObject1).size() - 1);
      if ((((MessageForLongMsg)localObject2).longMsgFragmentList != null) && (!((MessageForLongMsg)localObject2).longMsgFragmentList.isEmpty()) && (((MessageRecord)((MessageForLongMsg)localObject2).longMsgFragmentList.get(0)).longMsgIndex < this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString, paramInt).longMsgIndex))
      {
        a((MessageRecord)((MessageForLongMsg)localObject2).longMsgFragmentList.get(0), true, 2);
        b(paramString, paramInt, (MessageRecord)((MessageForLongMsg)localObject2).longMsgFragmentList.get(0), 2);
        a((MessageRecord)localObject2, true, 3);
        b(paramString, paramInt, (MessageRecord)localObject2, 3);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("newAIOCursor clone ");
      if (localObject1 == null) {
        break label361;
      }
    }
    label361:
    for (paramString = Integer.valueOf(((List)localObject1).size());; paramString = "clone is null")
    {
      QLog.d("Q.msg.BaseMessageManager", 2, paramString);
      paramString = new ArrayList();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        paramString.add((ChatMessage)((Iterator)localObject1).next());
      }
    }
    return paramString;
  }
  
  public void a(QQMessageFacade.Message paramMessage)
  {
    if (((paramMessage.msgtype == -1003) || (paramMessage.msgtype == -1032) || (paramMessage.msgtype == 201)) && (paramMessage.istroop == 1001)) {}
    try
    {
      paramMessage.msg = ActionMsgUtil.a(paramMessage.msg).msg;
      if (paramMessage.msgtype == -2018) {}
      for (;;)
      {
        try
        {
          localObject3 = new structmsg.StructMsg();
          ((structmsg.StructMsg)localObject3).mergeFrom(paramMessage.msgData);
          if (((structmsg.StructMsg)localObject3).msg_type.get() != 1) {
            continue;
          }
          switch (((structmsg.StructMsg)localObject3).msg.sub_type.get())
          {
          case 2: 
          case 3: 
            localObject1 = ((structmsg.StructMsg)localObject3).msg.msg_describe.get();
            localObject1 = ((structmsg.StructMsg)localObject3).msg.req_uin_nick.get() + (String)localObject1;
            paramMessage.msg = ((String)localObject1);
          }
        }
        catch (Exception localException3)
        {
          Object localObject3;
          Object localObject1;
          continue;
        }
        if ((ActionMsgUtil.a(paramMessage.msgtype)) || (paramMessage.msgtype == -3001) || (paramMessage.msgtype == -30002) || (paramMessage.msgtype == -30003)) {}
        try
        {
          localObject1 = ActionMsgUtil.a(paramMessage.msg);
          paramMessage.msg = ((MsgBody)localObject1).msg;
          paramMessage.action = ((MsgBody)localObject1).action;
          paramMessage.shareAppID = ((MsgBody)localObject1).shareAppID;
          paramMessage.actMsgContentValue = ((MsgBody)localObject1).actMsgContentValue;
          localObject1 = null;
          if ((!AppConstants.W.equals(paramMessage.senderuin)) || (paramMessage.msgtype != -2011)) {
            localObject1 = SystemMsg.decode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage.msg, paramMessage.senderuin, paramMessage.msgtype);
          }
          b(paramMessage);
          if (localObject1 != null)
          {
            paramMessage.msg = ((SystemMsg)localObject1).message;
            if (QLog.isDevelopLevel()) {
              QLog.d("Q.msg.BaseMessageManager", 4, "addFrindSystemMsg decode end" + paramMessage.msg);
            }
            return;
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getString(2131561412);
            continue;
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getString(2131561403);
            continue;
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getString(2131561405);
            continue;
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getString(2131561407);
            continue;
            localObject1 = TroopUtils.a((structmsg.StructMsg)localObject3, ((structmsg.StructMsg)localObject3).msg.msg_describe.get());
            continue;
            if (paramMessage.msgtype != -2011) {
              continue;
            }
            localObject3 = StructMsgFactory.a(paramMessage.msgData);
            localObject1 = "";
            if (localObject3 != null) {
              localObject1 = ((AbsStructMsg)localObject3).mMsgBrief;
            }
            paramMessage.msg = ((String)localObject1);
            continue;
          }
          if (paramMessage.msgtype == -2007)
          {
            paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131561548);
            return;
          }
          if (paramMessage.msgtype == -1035)
          {
            localObject1 = new MessageForMixedMsg();
            ((MessageForMixedMsg)localObject1).msgData = paramMessage.msgData;
            ((MessageForMixedMsg)localObject1).parse();
            paramMessage.msg = ((MessageForMixedMsg)localObject1).msg;
            if ((paramMessage.msg == null) || ("".equals(paramMessage.msg))) {
              continue;
            }
            paramMessage.emoRecentMsg = new QQText(paramMessage.msg, 3, 16);
            return;
          }
          if (paramMessage.msgtype == -3006)
          {
            paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131561547);
            return;
          }
          if (paramMessage.msgtype == -2010)
          {
            localObject1 = new FunnyFaceMessage();
            try
            {
              ((FunnyFaceMessage)localObject1).readExternal(new ObjectInputStream(new ByteArrayInputStream(paramMessage.msgData)));
              if (localObject1 == null) {
                continue;
              }
              if (((FunnyFaceMessage)localObject1).faceId == 1)
              {
                paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131563247);
                return;
              }
            }
            catch (Exception localException1)
            {
              if (QLog.isColorLevel()) {
                QLog.e("Q.msg.BaseMessageManager", 2, localException1.toString());
              }
              localObject2 = null;
              continue;
            }
            if (((FunnyFaceMessage)localObject2).faceId != 2) {
              continue;
            }
            paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131563284);
            return;
          }
          if (paramMessage.msgtype == -2000)
          {
            paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131561543);
            return;
          }
          if (paramMessage.msgtype == -2005)
          {
            paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131561540);
            return;
          }
          if (paramMessage.msgtype == -2020)
          {
            paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131562920);
            if (MsgUtils.a(paramMessage.issend))
            {
              localObject2 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage.frienduin, "", 0, 0);
              paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131563283, new Object[] { localObject2 });
              return;
            }
            paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131562920);
            return;
          }
          if ((paramMessage.msgtype == -2002) || (paramMessage.msgtype == -1031))
          {
            paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131561555);
            try
            {
              paramMessage.pttUrl = ((MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramMessage.frienduin, paramMessage.istroop, paramMessage.uniseq)).url;
              return;
            }
            catch (Exception paramMessage)
            {
              paramMessage.printStackTrace();
              return;
            }
          }
          if ((paramMessage.msg == null) || ("".equals(paramMessage.msg))) {
            continue;
          }
          Object localObject2 = paramMessage.msg;
          if (a((String)localObject2))
          {
            localObject2 = localObject2.split("\026")[1].split("\\|");
            if (localObject2 == null) {
              continue;
            }
            int i;
            if (localObject2.length < 2)
            {
              i = 1;
              paramMessage.fileType = i;
            }
            try
            {
              if (localObject2.length < 2)
              {
                l = -1L;
                paramMessage.fileSize = l;
              }
            }
            catch (Exception localException5)
            {
              long l;
              if (QLog.isColorLevel()) {
                QLog.w("Q.msg.BaseMessageManager", 2, "decodeMsg filesize exception", localException5);
              }
              paramMessage.fileSize = -1L;
              continue;
              if (paramMessage.msgtype == -3001)
              {
                paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131563015);
                return;
              }
              paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131561543);
              return;
            }
            switch (i)
            {
            case 3: 
            default: 
              return;
            case 0: 
              paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131561540);
              return;
              i = Integer.valueOf(localObject2[2]).intValue();
              continue;
              l = Long.valueOf(localObject2[1]).longValue();
              break;
            case 1: 
            case 65538: 
            case 2: 
              paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131561555);
              paramMessage.pttUrl = localObject2[0];
              return;
            }
          }
          if (paramMessage.msgtype == -2006)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.msg.BaseMessageManager", 2, "<0x7f_trace>  0x7f in MsgTab decodeMsg method !");
            }
            paramMessage.msg = (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131561555) + "(0x7f)");
            return;
          }
          if (paramMessage.msgtype == -2008)
          {
            paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131562941);
            return;
          }
          if (paramMessage.msg.indexOf("http://maps.google.com/maps?q=") != -1)
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade;
            String[] arrayOfString = QQMessageFacade.a(paramMessage.msg);
            String str = "";
            localObject2 = str;
            if (arrayOfString != null)
            {
              localObject2 = str;
              if (arrayOfString[2] != null) {
                localObject2 = arrayOfString[2];
              }
            }
            paramMessage.fileType = 65536;
            paramMessage.msg = ("[" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131562304) + "] " + (String)localObject2);
            return;
          }
          paramMessage.emoRecentMsg = new QQText(paramMessage.msg, 3, 16);
          return;
        }
        catch (Exception localException2) {}
      }
    }
    catch (Exception localException4)
    {
      for (;;) {}
    }
  }
  
  protected void a(QQMessageFacade.RefreshMessageContext paramRefreshMessageContext, int paramInt)
  {
    int j;
    if ((paramRefreshMessageContext.jdField_a_of_type_JavaUtilList != null) && (paramRefreshMessageContext.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      j = 1;
      MsgProxyUtils.a(paramRefreshMessageContext.jdField_a_of_type_JavaUtilList);
      i = j;
      if (paramRefreshMessageContext.jdField_a_of_type_JavaUtilList.size() > 0) {
        MsgProxyUtils.a(paramRefreshMessageContext.jdField_a_of_type_JavaLangString, paramRefreshMessageContext.c, paramRefreshMessageContext.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
    for (int i = j;; i = 0)
    {
      String str = paramRefreshMessageContext.jdField_a_of_type_JavaLangString;
      j = paramRefreshMessageContext.jdField_d_of_type_Int;
      if ((paramRefreshMessageContext.jdField_d_of_type_Boolean) && (i != 0) && (paramRefreshMessageContext.jdField_a_of_type_JavaUtilList.isEmpty()) && (paramRefreshMessageContext.jdField_a_of_type_Int < 3))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "refreshHeadComplete : the list is empty after the filter, trying to get more. [ index:" + paramRefreshMessageContext.jdField_a_of_type_Int + " ]");
        }
        paramRefreshMessageContext.jdField_a_of_type_Int += 1;
        b(str, paramInt, j, paramRefreshMessageContext);
      }
      do
      {
        return;
        paramRefreshMessageContext.jdField_a_of_type_Int = 0;
        paramRefreshMessageContext.b = 0;
      } while (!paramRefreshMessageContext.f);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramRefreshMessageContext);
      return;
    }
  }
  
  protected void a(MessageRecord paramMessageRecord, ProxyListener paramProxyListener, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramMessageRecord.istroop).a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord, paramProxyListener, paramBoolean1, paramBoolean2, true);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b(paramMessageRecord.getTableName(), paramMessageRecord.istroop);
    a(paramMessageRecord, true, paramInt);
  }
  
  public void a(MessageRecord paramMessageRecord, EntityManager paramEntityManager, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, BaseMessageManager.AddMessageContext paramAddMessageContext)
  {
    if (paramMessageRecord == null) {}
    int i;
    MessageRecord localMessageRecord;
    do
    {
      do
      {
        return;
        paramEntityManager = paramAddMessageContext.c;
        if (paramMessageRecord.time == 0L) {
          paramMessageRecord.time = MessageCache.a();
        }
        if (paramMessageRecord.msgseq == 0L) {
          paramMessageRecord.msgseq = ((int)paramMessageRecord.time);
        }
        paramAddMessageContext = paramMessageRecord.frienduin;
        i = paramMessageRecord.istroop;
        if ((paramMessageRecord.isSendFromLocal()) && ((paramMessageRecord.istroop == 3000) || (paramMessageRecord.istroop == 1) || (paramMessageRecord.istroop == 0)) && (paramMessageRecord.extraflag == 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "addMessage set sendmsg extra " + paramMessageRecord.getBaseInfoString());
          }
          paramMessageRecord.extraflag = 32772;
          paramMessageRecord.sendFailCode = 0;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramMessageRecord.istroop).a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord, null, paramBoolean1, paramBoolean2, paramBoolean4);
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().put(paramMessageRecord.getTableName(), Integer.valueOf(paramMessageRecord.istroop));
        if ((paramMessageRecord.istroop != 3000) && (paramMessageRecord.istroop != 1) && (paramMessageRecord.istroop != 0)) {
          break;
        }
      } while (!a(paramMessageRecord, false, 1));
      if ((!paramEntityManager.containsKey(MsgProxyUtils.a(paramAddMessageContext, i))) || (paramMessageRecord.isSendFromLocal()))
      {
        paramEntityManager.put(MsgProxyUtils.a(paramAddMessageContext, i), paramMessageRecord);
        return;
      }
      localMessageRecord = (MessageRecord)paramEntityManager.get(MsgProxyUtils.a(paramAddMessageContext, i));
    } while (a(paramMessageRecord) < a(localMessageRecord));
    paramEntityManager.put(MsgProxyUtils.a(paramAddMessageContext, i), paramMessageRecord);
    return;
    a(paramMessageRecord, true, 1);
  }
  
  public void a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    int i = 1;
    int j = 0;
    ArrayList localArrayList = new ArrayList();
    if ((paramMessageRecord instanceof MessageForLongMsg))
    {
      localArrayList.addAll(((MessageForLongMsg)paramMessageRecord).longMsgFragmentList);
      if (!MsgProxyUtils.a(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramMessageRecord.frienduin, paramMessageRecord.istroop))) {
        break label351;
      }
      i = 1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "-->removeMsgByMessageRecord : uniseq:" + paramMessageRecord.uniseq + " _id:" + paramMessageRecord.getId() + " isTroop:" + paramMessageRecord.istroop);
      }
      Object localObject = MsgProxyUtils.a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
      if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.containsKey(localObject))
      {
        localObject = (QQMessageFacade.Message)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.get(localObject);
        if ((!paramMessageRecord.isread) && (localObject != null)) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((QQMessageFacade.Message)localObject).frienduin, ((QQMessageFacade.Message)localObject).istroop, -1);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramMessageRecord);
      int k = localArrayList.size();
      for (;;)
      {
        if (j < k)
        {
          localObject = (MessageRecord)localArrayList.get(j);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(((MessageRecord)localObject).istroop).a((MessageRecord)localObject, paramBoolean);
          j += 1;
          continue;
          localArrayList.add(paramMessageRecord);
          if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramMessageRecord)) {
            break;
          }
          i = 0;
          break;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord);
      if (i != 0)
      {
        if (!MsgProxyUtils.l(paramMessageRecord.istroop)) {
          break label343;
        }
        a(paramMessageRecord);
      }
      for (;;)
      {
        if (paramBoolean) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramMessageRecord.istroop).f();
        }
        return;
        label343:
        b(paramMessageRecord);
      }
      label351:
      i = 0;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "setReaded uin=" + paramString + ",type=" + paramInt);
    }
    if (paramString == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "setReaded return : uin=null");
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt) > 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.BaseMessageManager", 2, "setReaded return : unread=0");
    return;
    MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a(paramString, paramInt);
    ConversationFacade localConversationFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localMessageRecord != null) {}
    for (long l = a(localMessageRecord);; l = 0L)
    {
      localConversationFacade.a(paramString, paramInt, l);
      b(paramString, paramInt);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString, paramInt));
      return;
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext)
  {
    paramRefreshMessageContext.jdField_d_of_type_Boolean = true;
    paramRefreshMessageContext.jdField_a_of_type_JavaLangString = paramString;
    paramRefreshMessageContext.c = paramInt1;
    paramRefreshMessageContext.jdField_d_of_type_Int = paramInt2;
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b.containsKey(MsgProxyUtils.a(paramString, paramInt1)))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "refreshMessageListHead UNFINISHED ERROR uin = " + paramString + ", type = " + paramInt1);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramRefreshMessageContext);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b.put(MsgProxyUtils.a(paramString, paramInt1), Boolean.valueOf(true));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new fnf(this, paramString, paramInt1, paramInt2, paramRefreshMessageContext));
  }
  
  public void a(String paramString, int paramInt, long paramLong) {}
  
  public void a(String paramString, int paramInt1, MessageRecord paramMessageRecord, int paramInt2)
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).b(paramString, paramInt1);
    QQMessageFacade.Message localMessage = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString, paramInt1);
    if ((paramMessageRecord != null) && (paramMessageRecord.isLongMsg())) {
      if ((MsgProxyUtils.a(paramMessageRecord, localMessage)) && (((paramInt2 == 3) && (paramMessageRecord.extraflag == 32768)) || (paramMessageRecord.longMsgIndex == localMessage.longMsgIndex)))
      {
        a(paramMessageRecord, true, paramInt2);
        b(paramString, paramInt1, paramMessageRecord, paramInt2);
      }
    }
    while ((paramMessageRecord == null) || (localList == null) || (localList.isEmpty()) || (paramMessageRecord.uniseq != ((MessageRecord)localList.get(localList.size() - 1)).uniseq)) {
      return;
    }
    a(paramMessageRecord, true, paramInt2);
    b(paramString, paramInt1, paramMessageRecord, paramInt2);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a(paramString1, paramInt, paramString2, paramString3);
    paramString3 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString1, paramInt);
    if ((paramString3.senderuin != null) && (paramString3.senderuin.equals(paramString2)))
    {
      paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).b(paramString1, paramInt);
      if ((paramString2 == null) || (paramString2.isEmpty())) {
        break label174;
      }
      paramString2 = (MessageRecord)paramString2.get(paramString2.size() - 1);
      paramString3.selfuin = paramString2.selfuin;
      paramString3.senderuin = paramString2.senderuin;
      paramString3.frienduin = paramString1;
      paramString3.msg = paramString2.msg;
      paramString3.msgtype = paramString2.msgtype;
      paramString3.time = paramString2.time;
      paramString3.istroop = paramInt;
      paramString3.issend = paramString2.issend;
      paramString3.isread = paramString2.isread;
      a(paramString3);
    }
    label174:
    do
    {
      return;
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramString1, paramInt);
    } while (paramString1 == null);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString1);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong)
  {
    paramString3 = null;
    RecentUserProxy localRecentUserProxy;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString1, paramInt)) || (!MsgProxyUtils.l(paramInt)))
    {
      localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      if (0L != paramLong) {
        break label100;
      }
      paramString1 = localRecentUserProxy.b(paramString1, paramInt);
      paramString3 = paramString1;
      if (paramString1 != null)
      {
        paramString1.lastmsgdrafttime = paramLong;
        if ((0L != paramLong) || (paramString1.lastmsgtime != 0L)) {
          break label116;
        }
        localRecentUserProxy.b(paramString1);
      }
    }
    for (paramString3 = paramString1;; paramString3 = paramString1)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString3);
      return;
      label100:
      paramString1 = localRecentUserProxy.a(paramString1, paramInt);
      paramString1.troopUin = paramString2;
      break;
      label116:
      localRecentUserProxy.a(paramString1);
    }
  }
  
  public abstract void a(String paramString, int paramInt, List paramList1, List paramList2, Bundle paramBundle);
  
  public boolean a(MessageRecord paramMessageRecord, boolean paramBoolean, int paramInt)
  {
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab " + paramMessageRecord.getBaseInfoString() + ",reason " + paramInt);
    }
    boolean bool1;
    if (paramMessageRecord == null) {
      bool1 = bool2;
    }
    MessageRecord localMessageRecord;
    label160:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return bool1;
                localMessageRecord = paramMessageRecord;
                if (!paramMessageRecord.isLongMsg()) {
                  break label160;
                }
                if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord)) {
                  break;
                }
                bool1 = bool2;
              } while (paramInt != 1);
              bool1 = bool2;
            } while (paramMessageRecord.isSendFromLocal());
            bool1 = bool2;
          } while (paramMessageRecord.isread);
          bool1 = bool2;
        } while (String.valueOf(AppConstants.R).equals(paramMessageRecord.frienduin));
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b(null);
        return false;
        localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramMessageRecord);
        bool1 = bool2;
      } while (!localMessageRecord.isValid);
      bool1 = bool2;
    } while (MsgProxyUtils.d(localMessageRecord.msgtype));
    paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(localMessageRecord.frienduin, localMessageRecord.istroop);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab getLastMessage " + paramMessageRecord.getBaseInfoString());
    }
    if (paramInt == 1) {
      if ((localMessageRecord.istroop == 3000) || (localMessageRecord.istroop == 1))
      {
        if ((localMessageRecord.isSendFromLocal()) || (localMessageRecord.shmsgseq >= paramMessageRecord.shmsgseq)) {
          break label779;
        }
        paramInt = 1;
      }
    }
    for (;;)
    {
      label288:
      if (MsgProxyUtils.a(localMessageRecord, paramMessageRecord))
      {
        bool1 = bool2;
        if (localMessageRecord.longMsgIndex >= paramMessageRecord.longMsgIndex) {
          break;
        }
        paramInt = 0;
      }
      bool1 = bool3;
      if (paramInt == 0)
      {
        MessageRecord.copyMessageRecordBaseField(paramMessageRecord, localMessageRecord);
        paramMessageRecord.emoRecentMsg = null;
        paramMessageRecord.fileType = -1;
        if (paramBoolean) {
          a(paramMessageRecord);
        }
        bool1 = true;
      }
      if (!localMessageRecord.isSend()) {
        paramMessageRecord.hasReply = true;
      }
      if ((localMessageRecord.isSendFromLocal()) || (localMessageRecord.isread))
      {
        paramBoolean = bool1;
        if (localMessageRecord.msgtype != -1013) {}
      }
      else
      {
        if (localMessageRecord.msgtype == -1013) {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b(paramMessageRecord);
        }
        if (!String.valueOf(AppConstants.R).equals(paramMessageRecord.frienduin)) {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b(paramMessageRecord);
        }
        if (AppConstants.U.equals(paramMessageRecord.frienduin))
        {
          paramInt = SystemMsgController.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (paramInt <= 0) {
            break label647;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().unReadNum = paramInt;
        }
        label476:
        if (AppConstants.Z.equals(paramMessageRecord.frienduin))
        {
          paramInt = FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (paramInt <= 0) {
            break label658;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().unReadNum = paramInt;
        }
        label515:
        paramBoolean = bool1;
        if (AppConstants.aa.equals(paramMessageRecord.frienduin))
        {
          paramInt = GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (paramInt <= 0) {
            break label669;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().unReadNum = paramInt;
          paramBoolean = bool1;
        }
      }
      label647:
      label658:
      label669:
      label723:
      do
      {
        for (;;)
        {
          bool1 = paramBoolean;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab fin " + paramMessageRecord.getBaseInfoString() + " , result = " + paramBoolean);
          return paramBoolean;
          if ((!MsgProxyUtils.a(localMessageRecord.istroop)) || (localMessageRecord.isSendFromLocal()) || (localMessageRecord.time >= paramMessageRecord.time)) {
            break label779;
          }
          paramInt = 1;
          break label288;
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b(null);
          break label476;
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b(null);
          break label515;
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b(null);
          paramBoolean = bool1;
          continue;
          if ((paramInt != 4) && (paramInt != 2)) {
            break label723;
          }
          MessageRecord.copyMessageRecordBaseField(paramMessageRecord, localMessageRecord);
          paramMessageRecord.emoRecentMsg = null;
          paramMessageRecord.fileType = -1;
          if (paramBoolean) {
            a(paramMessageRecord);
          }
          paramBoolean = true;
        }
        paramBoolean = bool4;
      } while (paramInt != 3);
      if (paramMessageRecord.uniseq == localMessageRecord.uniseq) {
        MessageRecord.copyMessageRecordStatusField(paramMessageRecord, localMessageRecord);
      }
      for (;;)
      {
        paramBoolean = true;
        break;
        MessageRecord.copyMessageRecordBaseField(paramMessageRecord, localMessageRecord);
        paramMessageRecord.emoRecentMsg = null;
        paramMessageRecord.fileType = -1;
        a(paramMessageRecord);
      }
      label779:
      paramInt = 0;
    }
  }
  
  protected void b(QQMessageFacade.Message paramMessage) {}
  
  public void b(String paramString, int paramInt) {}
  
  public abstract void b(String paramString, int paramInt1, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext);
  
  public void b(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "setReadFrom uin=" + paramString + ",type=" + paramInt + ",from=" + paramLong);
    }
    if (paramLong < 0L) {}
    do
    {
      return;
      if (paramString != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.BaseMessageManager", 2, "setReadFrom return : uin=null");
    return;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt) <= 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "setReadFrom return : unread=0");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt, paramLong);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString, paramInt, paramLong);
    a(paramString, paramInt, paramLong);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString, paramInt));
  }
  
  public void b(String paramString, int paramInt1, MessageRecord paramMessageRecord, int paramInt2)
  {
    long l;
    QQMessageFacade.Message localMessage;
    if ((paramInt1 != 3000) && (paramInt1 != 1))
    {
      l = a(paramString, paramInt1);
      if (l != 0L)
      {
        if (paramInt1 != 1009) {
          break label309;
        }
        localMessage = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(AppConstants.N, 1009);
        if ((localMessage.senderuin != null) && (localMessage.senderuin.equals(paramString)))
        {
          paramString = MessageRecordFactory.a(paramMessageRecord.msgtype);
          paramString.selfuin = paramMessageRecord.selfuin;
          paramString.senderuin = paramMessageRecord.frienduin;
          paramString.frienduin = AppConstants.N;
          paramString.msg = paramMessageRecord.msg;
          paramString.msgtype = paramMessageRecord.msgtype;
          paramString.time = paramMessageRecord.time;
          paramString.istroop = 1009;
          paramString.issend = paramMessageRecord.issend;
          paramString.isread = paramMessageRecord.isread;
          if (paramInt2 != 3) {
            break label220;
          }
          a(paramString, true, paramInt2);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.N, 1009, l, paramMessageRecord.extraflag, localMessage.sendFailCode);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.N, 1009, l, paramMessageRecord.time, paramMessageRecord.shmsgseq);
        }
      }
    }
    label220:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (paramInt2 == 2)
            {
              a(paramString, true, paramInt2);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.N, 1009, l, paramMessageRecord.msg);
              return;
            }
          } while (paramInt2 != 4);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.N, paramInt1, paramString.senderuin, paramString.selfuin);
          a(paramString, null, false, true, paramInt2);
          a(paramMessageRecord, true, paramInt2);
          return;
        } while (paramInt1 != 1001);
        localMessage = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(AppConstants.V, 1001);
      } while ((localMessage.senderuin == null) || (!localMessage.senderuin.equals(paramString)));
      paramString = MessageRecordFactory.a(paramMessageRecord.msgtype);
      paramString.selfuin = paramMessageRecord.selfuin;
      paramString.senderuin = paramMessageRecord.frienduin;
      paramString.frienduin = AppConstants.V;
      paramString.msg = paramMessageRecord.msg;
      paramString.msgtype = paramMessageRecord.msgtype;
      paramString.time = paramMessageRecord.time;
      paramString.istroop = 1001;
      paramString.issend = paramMessageRecord.issend;
      paramString.isread = paramMessageRecord.isread;
      if (paramInt2 == 3)
      {
        a(paramString, true, paramInt2);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.V, 1001, l, paramMessageRecord.extraflag, localMessage.sendFailCode);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.V, 1001, l, paramMessageRecord.time, paramMessageRecord.shmsgseq);
        return;
      }
      if (paramInt2 == 2)
      {
        a(paramString, true, paramInt2);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.V, 1001, l, paramMessageRecord.msg);
        return;
      }
    } while (paramInt2 != 4);
    label309:
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.V, paramInt1, paramString.senderuin, paramString.selfuin);
    a(paramString, null, false, true, paramInt2);
    a(paramMessageRecord, true, paramInt2);
  }
  
  public void c(String paramString, int paramInt)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "removeNotification uin" + paramString + ",type:" + paramInt);
    }
    if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause) || (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilList.iterator();
    Object localObject = null;
    label89:
    QQMessageFacade.Message localMessage;
    if (localIterator.hasNext())
    {
      localMessage = (QQMessageFacade.Message)localIterator.next();
      if ((paramInt == localMessage.istroop) || ((MsgProxyUtils.a(paramInt)) && (MsgProxyUtils.a(localMessage.istroop)) && (localMessage.frienduin.equals(paramString))))
      {
        localMessage.counter = 0;
        localIterator.remove();
      }
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder().append("removeNotification remove:").append(bool1).append(",preMsg is null");
        if (localObject != null) {
          break label284;
        }
      }
      for (;;)
      {
        QLog.d("notification", 2, bool2 + ",iterator.hasNext():" + localIterator.hasNext());
        if (!bool1) {
          break;
        }
        paramString = localObject;
        if (localObject == null)
        {
          paramString = localObject;
          if (localIterator.hasNext()) {
            paramString = (QQMessageFacade.Message)localIterator.next();
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString);
        return;
        localObject = localMessage;
        break label89;
        label284:
        bool2 = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.BaseMessageManager
 * JD-Core Version:    0.7.0.1
 */