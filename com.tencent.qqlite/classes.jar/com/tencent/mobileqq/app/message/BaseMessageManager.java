package com.tencent.mobileqq.app.message;

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
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.systemmsg.SystemMsgController;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.qphone.base.util.QLog;
import cxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class BaseMessageManager
  implements IMessageManager
{
  static final long a = 35000L;
  public static final String a = "Q.msg.BaseMessageManager";
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
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a(AppConstants.S, 1009);
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
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a(AppConstants.Z, 1001);
      }
    }
    return 0L;
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
  
  public int a(int paramInt, ConversationInfo paramConversationInfo)
  {
    if (paramConversationInfo.unreadCount > 0) {
      if (paramInt == 2)
      {
        if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramConversationInfo.uin, paramConversationInfo.type)) && (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().b(paramConversationInfo.uin, paramConversationInfo.type))) {
          return paramConversationInfo.unreadCount;
        }
      }
      else if (paramInt == 6)
      {
        if ((paramConversationInfo.type == 1001) && (AppConstants.Z.equals(paramConversationInfo.uin)) && (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().b(paramConversationInfo.uin, paramConversationInfo.type))) {
          return paramConversationInfo.unreadCount;
        }
      }
      else if (paramInt == 7)
      {
        if ((paramConversationInfo.type == 1009) && (paramConversationInfo.uin.equals(AppConstants.S)) && (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().b(paramConversationInfo.uin, paramConversationInfo.type))) {
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
        a(AppConstants.S, 1009, paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(AppConstants.S, 1009);
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
        a(AppConstants.Z, 1001, paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(AppConstants.Z, 1001);
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
      paramString = (String)localObject2;
      return paramString;
    }
    String str = MsgProxyUtils.a(paramString, paramInt);
    localObject2 = (QQMessageFacade.Message)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.get(str);
    StringBuilder localStringBuilder = new StringBuilder("CACHE : refreshSingleLastMsg:uin:" + paramString + " uinType:" + paramInt);
    if ((localObject2 == null) || (!((QQMessageFacade.Message)localObject2).isCacheValid))
    {
      localObject1 = MessageRecord.getTableName(paramString, paramInt);
      if (paramString.equals(String.valueOf(AppConstants.T))) {
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
        if (paramString.equals(String.valueOf(AppConstants.T)))
        {
          paramString = new DataLineMsgRecord();
          DataLineMsgRecord.unpackMsgData(paramString, ((QQMessageFacade.Message)localObject1).msgData, ((QQMessageFacade.Message)localObject1).versionCode);
          ((QQMessageFacade.Message)localObject1).msg = paramString.msg;
        }
        paramString = (String)localObject1;
        if (!AppConstants.Z.equals(((QQMessageFacade.Message)localObject1).frienduin))
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
      }
    }
    for (;;)
    {
      try
      {
        paramEntityManager = (QQMessageFacade.Message)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.get(str);
        if (paramEntityManager != null) {
          continue;
        }
        if (QLog.isColorLevel()) {
          localStringBuilder.append(" : case 1 : null inplace");
        }
        a(paramString);
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.put(str, paramString);
        paramEntityManager = paramString;
      }
      catch (Throwable localThrowable)
      {
        paramEntityManager = paramString;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.msg.BaseMessageManager", 2, "refreshSingleLastMsg ERROR", localThrowable);
        paramEntityManager = paramString;
        continue;
      }
      paramString = paramEntityManager;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.msg.BaseMessageManager", 2, localStringBuilder.toString());
      return paramEntityManager;
      paramEntityManager = new QQMessageFacade.Message();
      paramEntityManager.frienduin = paramString;
      paramEntityManager.istroop = paramInt;
      paramString = paramEntityManager;
      continue;
      if (a(paramEntityManager) < a(paramString))
      {
        if (QLog.isColorLevel()) {
          localStringBuilder.append(" : case 2 : new inplace");
        }
        a(paramString);
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.put(str, paramString);
      }
      else if ((!paramEntityManager.isCacheValid) && (paramString.isCacheValid))
      {
        if (QLog.isColorLevel()) {
          localStringBuilder.append(" : case 3 : valid inplace");
        }
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
        paramEntityManager = localThrowable;
        if (QLog.isColorLevel())
        {
          localStringBuilder.append(" : case 5 : not null or isValid : " + localObject2);
          paramEntityManager = localThrowable;
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
  
  /* Error */
  public void a(QQMessageFacade.Message paramMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 391	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   4: sipush -1003
    //   7: if_icmpeq +23 -> 30
    //   10: aload_1
    //   11: getfield 391	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   14: sipush -1032
    //   17: if_icmpeq +13 -> 30
    //   20: aload_1
    //   21: getfield 391	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   24: sipush 201
    //   27: if_icmpne +27 -> 54
    //   30: aload_1
    //   31: getfield 203	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   34: sipush 1001
    //   37: if_icmpne +17 -> 54
    //   40: aload_1
    //   41: aload_1
    //   42: getfield 303	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   45: invokestatic 396	com/tencent/mobileqq/utils/ActionMsgUtil:a	(Ljava/lang/String;)LActionMsg/MsgBody;
    //   48: getfield 399	ActionMsg/MsgBody:msg	Ljava/lang/String;
    //   51: putfield 303	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   54: aload_1
    //   55: getfield 391	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   58: sipush -2018
    //   61: if_icmpne +506 -> 567
    //   64: new 401	tencent/mobileim/structmsg/structmsg$StructMsg
    //   67: dup
    //   68: invokespecial 402	tencent/mobileim/structmsg/structmsg$StructMsg:<init>	()V
    //   71: astore 6
    //   73: aload 6
    //   75: aload_1
    //   76: getfield 292	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   79: invokevirtual 406	tencent/mobileim/structmsg/structmsg$StructMsg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   82: pop
    //   83: aload 6
    //   85: getfield 410	tencent/mobileim/structmsg/structmsg$StructMsg:msg_type	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   88: invokevirtual 414	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   91: iconst_1
    //   92: if_icmpne +376 -> 468
    //   95: aload 6
    //   97: getfield 417	tencent/mobileim/structmsg/structmsg$StructMsg:msg	Ltencent/mobileim/structmsg/structmsg$SystemMsg;
    //   100: getfield 423	tencent/mobileim/structmsg/structmsg$SystemMsg:sub_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   103: invokevirtual 426	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   106: tableswitch	default:+1664 -> 1770, 1:+278->384, 2:+38->144, 3:+38->144, 4:+299->405, 5:+320->426, 6:+341->447
    //   145: iconst_3
    //   146: getfield 417	tencent/mobileim/structmsg/structmsg$StructMsg:msg	Ltencent/mobileim/structmsg/structmsg$SystemMsg;
    //   149: getfield 430	tencent/mobileim/structmsg/structmsg$SystemMsg:msg_describe	Lcom/tencent/mobileqq/pb/PBStringField;
    //   152: invokevirtual 434	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   155: astore 5
    //   157: new 142	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   164: aload 6
    //   166: getfield 417	tencent/mobileim/structmsg/structmsg$StructMsg:msg	Ltencent/mobileim/structmsg/structmsg$SystemMsg;
    //   169: getfield 437	tencent/mobileim/structmsg/structmsg$SystemMsg:req_uin_nick	Lcom/tencent/mobileqq/pb/PBStringField;
    //   172: invokevirtual 434	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   175: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: aload 5
    //   180: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: astore 5
    //   188: aload_1
    //   189: aload 5
    //   191: putfield 303	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   194: aload_1
    //   195: getfield 391	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   198: invokestatic 438	com/tencent/mobileqq/utils/ActionMsgUtil:a	(I)Z
    //   201: ifne +33 -> 234
    //   204: aload_1
    //   205: getfield 391	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   208: sipush -3001
    //   211: if_icmpeq +23 -> 234
    //   214: aload_1
    //   215: getfield 391	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   218: sipush -30002
    //   221: if_icmpeq +13 -> 234
    //   224: aload_1
    //   225: getfield 391	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   228: sipush -30003
    //   231: if_icmpne +48 -> 279
    //   234: aload_1
    //   235: getfield 303	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   238: invokestatic 396	com/tencent/mobileqq/utils/ActionMsgUtil:a	(Ljava/lang/String;)LActionMsg/MsgBody;
    //   241: astore 5
    //   243: aload_1
    //   244: aload 5
    //   246: getfield 399	ActionMsg/MsgBody:msg	Ljava/lang/String;
    //   249: putfield 303	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   252: aload_1
    //   253: aload 5
    //   255: getfield 441	ActionMsg/MsgBody:action	Ljava/lang/String;
    //   258: putfield 442	com/tencent/mobileqq/app/message/QQMessageFacade$Message:action	Ljava/lang/String;
    //   261: aload_1
    //   262: aload 5
    //   264: getfield 445	ActionMsg/MsgBody:shareAppID	J
    //   267: putfield 446	com/tencent/mobileqq/app/message/QQMessageFacade$Message:shareAppID	J
    //   270: aload_1
    //   271: aload 5
    //   273: getfield 449	ActionMsg/MsgBody:actMsgContentValue	Ljava/lang/String;
    //   276: putfield 450	com/tencent/mobileqq/app/message/QQMessageFacade$Message:actMsgContentValue	Ljava/lang/String;
    //   279: aconst_null
    //   280: astore 5
    //   282: getstatic 453	com/tencent/mobileqq/app/AppConstants:aa	Ljava/lang/String;
    //   285: aload_1
    //   286: getfield 192	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   289: invokevirtual 71	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   292: ifeq +13 -> 305
    //   295: aload_1
    //   296: getfield 391	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   299: sipush -2011
    //   302: if_icmpeq +24 -> 326
    //   305: aload_0
    //   306: getfield 22	com/tencent/mobileqq/app/message/BaseMessageManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   309: aload_1
    //   310: getfield 303	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   313: aload_1
    //   314: getfield 192	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   317: aload_1
    //   318: getfield 391	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   321: invokestatic 459	com/tencent/mobileqq/data/SystemMsg:decode	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;I)Lcom/tencent/mobileqq/data/SystemMsg;
    //   324: astore 5
    //   326: aload_0
    //   327: aload_1
    //   328: invokevirtual 461	com/tencent/mobileqq/app/message/BaseMessageManager:b	(Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)V
    //   331: aload 5
    //   333: ifnull +282 -> 615
    //   336: aload_1
    //   337: aload 5
    //   339: getfield 464	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   342: putfield 303	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   345: invokestatic 467	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   348: ifeq +32 -> 380
    //   351: ldc 13
    //   353: iconst_4
    //   354: new 142	java/lang/StringBuilder
    //   357: dup
    //   358: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   361: ldc_w 469
    //   364: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: aload_1
    //   368: getfield 303	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   371: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   380: return
    //   381: astore_1
    //   382: aload_1
    //   383: athrow
    //   384: aload_0
    //   385: getfield 22	com/tencent/mobileqq/app/message/BaseMessageManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   388: invokevirtual 472	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   391: invokevirtual 478	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   394: ldc_w 479
    //   397: invokevirtual 485	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   400: astore 5
    //   402: goto -245 -> 157
    //   405: aload_0
    //   406: getfield 22	com/tencent/mobileqq/app/message/BaseMessageManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   409: invokevirtual 472	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   412: invokevirtual 478	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   415: ldc_w 486
    //   418: invokevirtual 485	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   421: astore 5
    //   423: goto -266 -> 157
    //   426: aload_0
    //   427: getfield 22	com/tencent/mobileqq/app/message/BaseMessageManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   430: invokevirtual 472	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   433: invokevirtual 478	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   436: ldc_w 487
    //   439: invokevirtual 485	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   442: astore 5
    //   444: goto -287 -> 157
    //   447: aload_0
    //   448: getfield 22	com/tencent/mobileqq/app/message/BaseMessageManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   451: invokevirtual 472	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   454: invokevirtual 478	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   457: ldc_w 488
    //   460: invokevirtual 485	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   463: astore 5
    //   465: goto -308 -> 157
    //   468: aload 6
    //   470: getfield 417	tencent/mobileim/structmsg/structmsg$StructMsg:msg	Ltencent/mobileim/structmsg/structmsg$SystemMsg;
    //   473: getfield 491	tencent/mobileim/structmsg/structmsg$SystemMsg:group_msg_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   476: invokevirtual 426	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   479: tableswitch	default:+1294 -> 1773, 6:+69->548
    //   497: iconst_3
    //   498: getfield 417	tencent/mobileim/structmsg/structmsg$StructMsg:msg	Ltencent/mobileim/structmsg/structmsg$SystemMsg;
    //   501: getfield 437	tencent/mobileim/structmsg/structmsg$SystemMsg:req_uin_nick	Lcom/tencent/mobileqq/pb/PBStringField;
    //   504: invokevirtual 434	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   507: astore 5
    //   509: aload 6
    //   511: new 142	java/lang/StringBuilder
    //   514: dup
    //   515: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   518: aload 5
    //   520: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: aload 6
    //   525: getfield 417	tencent/mobileim/structmsg/structmsg$StructMsg:msg	Ltencent/mobileim/structmsg/structmsg$SystemMsg;
    //   528: getfield 430	tencent/mobileim/structmsg/structmsg$SystemMsg:msg_describe	Lcom/tencent/mobileqq/pb/PBStringField;
    //   531: invokevirtual 434	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   534: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   540: invokestatic 496	com/tencent/mobileqq/troop/utils/TroopUtils:a	(Ltencent/mobileim/structmsg/structmsg$StructMsg;Ljava/lang/String;)Ljava/lang/String;
    //   543: astore 5
    //   545: goto -357 -> 188
    //   548: aload 6
    //   550: getfield 417	tencent/mobileim/structmsg/structmsg$StructMsg:msg	Ltencent/mobileim/structmsg/structmsg$SystemMsg;
    //   553: getfield 499	tencent/mobileim/structmsg/structmsg$SystemMsg:action_uin_nick	Lcom/tencent/mobileqq/pb/PBStringField;
    //   556: invokevirtual 434	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   559: astore 5
    //   561: goto -52 -> 509
    //   564: astore_1
    //   565: aload_1
    //   566: athrow
    //   567: aload_1
    //   568: getfield 391	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   571: sipush -2011
    //   574: if_icmpne -380 -> 194
    //   577: aload_1
    //   578: getfield 292	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   581: invokestatic 504	com/tencent/mobileqq/structmsg/StructMsgFactory:a	([B)Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   584: astore 6
    //   586: ldc_w 506
    //   589: astore 5
    //   591: aload 6
    //   593: ifnull +10 -> 603
    //   596: aload 6
    //   598: getfield 511	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgBrief	Ljava/lang/String;
    //   601: astore 5
    //   603: aload_1
    //   604: aload 5
    //   606: putfield 303	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   609: goto -415 -> 194
    //   612: astore_1
    //   613: aload_1
    //   614: athrow
    //   615: aload_1
    //   616: getfield 391	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   619: sipush -2007
    //   622: if_icmpne +21 -> 643
    //   625: aload_1
    //   626: aload_0
    //   627: getfield 22	com/tencent/mobileqq/app/message/BaseMessageManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   630: invokevirtual 472	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   633: ldc_w 512
    //   636: invokevirtual 513	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   639: putfield 303	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   642: return
    //   643: aload_1
    //   644: getfield 391	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   647: sipush -1035
    //   650: if_icmpne +74 -> 724
    //   653: new 515	com/tencent/mobileqq/data/MessageForMixedMsg
    //   656: dup
    //   657: invokespecial 516	com/tencent/mobileqq/data/MessageForMixedMsg:<init>	()V
    //   660: astore 5
    //   662: aload 5
    //   664: aload_1
    //   665: getfield 292	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   668: putfield 517	com/tencent/mobileqq/data/MessageForMixedMsg:msgData	[B
    //   671: aload 5
    //   673: invokevirtual 520	com/tencent/mobileqq/data/MessageForMixedMsg:parse	()V
    //   676: aload_1
    //   677: aload 5
    //   679: getfield 521	com/tencent/mobileqq/data/MessageForMixedMsg:msg	Ljava/lang/String;
    //   682: putfield 303	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   685: aload_1
    //   686: getfield 303	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   689: ifnull -309 -> 380
    //   692: ldc_w 506
    //   695: aload_1
    //   696: getfield 303	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   699: invokevirtual 71	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   702: ifne -322 -> 380
    //   705: aload_1
    //   706: new 523	com/tencent/mobileqq/text/QQText
    //   709: dup
    //   710: aload_1
    //   711: getfield 303	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   714: iconst_3
    //   715: bipush 16
    //   717: invokespecial 526	com/tencent/mobileqq/text/QQText:<init>	(Ljava/lang/CharSequence;II)V
    //   720: putfield 530	com/tencent/mobileqq/app/message/QQMessageFacade$Message:emoRecentMsg	Ljava/lang/CharSequence;
    //   723: return
    //   724: aload_1
    //   725: getfield 391	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   728: sipush -5000
    //   731: if_icmpeq +13 -> 744
    //   734: aload_1
    //   735: getfield 391	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   738: sipush -5001
    //   741: if_icmpne +74 -> 815
    //   744: new 532	com/tencent/mobileqq/data/MessageForNewGrayTips
    //   747: dup
    //   748: invokespecial 533	com/tencent/mobileqq/data/MessageForNewGrayTips:<init>	()V
    //   751: astore 5
    //   753: aload 5
    //   755: aload_1
    //   756: getfield 292	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   759: putfield 534	com/tencent/mobileqq/data/MessageForNewGrayTips:msgData	[B
    //   762: aload 5
    //   764: invokevirtual 535	com/tencent/mobileqq/data/MessageForNewGrayTips:parse	()V
    //   767: aload_1
    //   768: aload 5
    //   770: getfield 536	com/tencent/mobileqq/data/MessageForNewGrayTips:msg	Ljava/lang/String;
    //   773: putfield 303	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   776: aload_1
    //   777: getfield 303	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   780: ifnull -400 -> 380
    //   783: ldc_w 506
    //   786: aload_1
    //   787: getfield 303	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   790: invokevirtual 71	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   793: ifne -413 -> 380
    //   796: aload_1
    //   797: new 523	com/tencent/mobileqq/text/QQText
    //   800: dup
    //   801: aload_1
    //   802: getfield 303	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   805: iconst_3
    //   806: bipush 16
    //   808: invokespecial 526	com/tencent/mobileqq/text/QQText:<init>	(Ljava/lang/CharSequence;II)V
    //   811: putfield 530	com/tencent/mobileqq/app/message/QQMessageFacade$Message:emoRecentMsg	Ljava/lang/CharSequence;
    //   814: return
    //   815: aload_1
    //   816: getfield 391	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   819: sipush -3006
    //   822: if_icmpne +21 -> 843
    //   825: aload_1
    //   826: aload_0
    //   827: getfield 22	com/tencent/mobileqq/app/message/BaseMessageManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   830: invokevirtual 472	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   833: ldc_w 537
    //   836: invokevirtual 513	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   839: putfield 303	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   842: return
    //   843: aload_1
    //   844: getfield 391	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   847: sipush -2010
    //   850: if_icmpne +119 -> 969
    //   853: new 539	com/tencent/mobileqq/data/FunnyFaceMessage
    //   856: dup
    //   857: invokespecial 540	com/tencent/mobileqq/data/FunnyFaceMessage:<init>	()V
    //   860: astore 5
    //   862: aload 5
    //   864: new 542	java/io/ObjectInputStream
    //   867: dup
    //   868: new 544	java/io/ByteArrayInputStream
    //   871: dup
    //   872: aload_1
    //   873: getfield 292	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   876: invokespecial 547	java/io/ByteArrayInputStream:<init>	([B)V
    //   879: invokespecial 550	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   882: invokevirtual 554	com/tencent/mobileqq/data/FunnyFaceMessage:readExternal	(Ljava/io/ObjectInput;)V
    //   885: aload 5
    //   887: ifnull -507 -> 380
    //   890: aload 5
    //   892: getfield 557	com/tencent/mobileqq/data/FunnyFaceMessage:faceId	I
    //   895: iconst_1
    //   896: if_icmpne +46 -> 942
    //   899: aload_1
    //   900: aload_0
    //   901: getfield 22	com/tencent/mobileqq/app/message/BaseMessageManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   904: invokevirtual 472	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   907: ldc_w 558
    //   910: invokevirtual 513	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   913: putfield 303	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   916: return
    //   917: astore 5
    //   919: invokestatic 140	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   922: ifeq +14 -> 936
    //   925: ldc 13
    //   927: iconst_2
    //   928: aload 5
    //   930: invokevirtual 559	java/lang/Exception:toString	()Ljava/lang/String;
    //   933: invokestatic 562	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   936: aconst_null
    //   937: astore 5
    //   939: goto -54 -> 885
    //   942: aload 5
    //   944: getfield 557	com/tencent/mobileqq/data/FunnyFaceMessage:faceId	I
    //   947: iconst_2
    //   948: if_icmpne -568 -> 380
    //   951: aload_1
    //   952: aload_0
    //   953: getfield 22	com/tencent/mobileqq/app/message/BaseMessageManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   956: invokevirtual 472	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   959: ldc_w 563
    //   962: invokevirtual 513	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   965: putfield 303	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   968: return
    //   969: aload_1
    //   970: getfield 391	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   973: sipush -2000
    //   976: if_icmpne +21 -> 997
    //   979: aload_1
    //   980: aload_0
    //   981: getfield 22	com/tencent/mobileqq/app/message/BaseMessageManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   984: invokevirtual 472	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   987: ldc_w 564
    //   990: invokevirtual 513	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   993: putfield 303	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   996: return
    //   997: aload_1
    //   998: getfield 391	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1001: sipush -2005
    //   1004: if_icmpne +21 -> 1025
    //   1007: aload_1
    //   1008: aload_0
    //   1009: getfield 22	com/tencent/mobileqq/app/message/BaseMessageManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1012: invokevirtual 472	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1015: ldc_w 565
    //   1018: invokevirtual 513	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   1021: putfield 303	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1024: return
    //   1025: aload_1
    //   1026: getfield 391	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1029: sipush -2020
    //   1032: if_icmpne +93 -> 1125
    //   1035: aload_1
    //   1036: aload_0
    //   1037: getfield 22	com/tencent/mobileqq/app/message/BaseMessageManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1040: invokevirtual 472	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1043: ldc_w 566
    //   1046: invokevirtual 513	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   1049: putfield 303	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1052: aload_1
    //   1053: getfield 569	com/tencent/mobileqq/app/message/QQMessageFacade$Message:issend	I
    //   1056: invokestatic 572	com/tencent/mobileqq/utils/MsgUtils:a	(I)Z
    //   1059: ifeq +48 -> 1107
    //   1062: aload_0
    //   1063: getfield 22	com/tencent/mobileqq/app/message/BaseMessageManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1066: aload_1
    //   1067: getfield 283	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   1070: ldc_w 506
    //   1073: iconst_0
    //   1074: iconst_0
    //   1075: invokestatic 577	com/tencent/mobileqq/utils/ContactUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;II)Ljava/lang/String;
    //   1078: astore 5
    //   1080: aload_1
    //   1081: aload_0
    //   1082: getfield 22	com/tencent/mobileqq/app/message/BaseMessageManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1085: invokevirtual 472	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1088: ldc_w 578
    //   1091: iconst_1
    //   1092: anewarray 4	java/lang/Object
    //   1095: dup
    //   1096: iconst_0
    //   1097: aload 5
    //   1099: aastore
    //   1100: invokevirtual 581	com/tencent/qphone/base/util/BaseApplication:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   1103: putfield 303	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1106: return
    //   1107: aload_1
    //   1108: aload_0
    //   1109: getfield 22	com/tencent/mobileqq/app/message/BaseMessageManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1112: invokevirtual 472	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1115: ldc_w 566
    //   1118: invokevirtual 513	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   1121: putfield 303	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1124: return
    //   1125: aload_1
    //   1126: getfield 391	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1129: sipush -2002
    //   1132: if_icmpeq +13 -> 1145
    //   1135: aload_1
    //   1136: getfield 391	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1139: sipush -1031
    //   1142: if_icmpne +56 -> 1198
    //   1145: aload_1
    //   1146: aload_0
    //   1147: getfield 22	com/tencent/mobileqq/app/message/BaseMessageManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1150: invokevirtual 472	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1153: ldc_w 582
    //   1156: invokevirtual 513	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   1159: putfield 303	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1162: aload_1
    //   1163: aload_0
    //   1164: getfield 24	com/tencent/mobileqq/app/message/BaseMessageManager:jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade	Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   1167: aload_1
    //   1168: getfield 283	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   1171: aload_1
    //   1172: getfield 203	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   1175: aload_1
    //   1176: getfield 280	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   1179: invokevirtual 585	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   1182: checkcast 587	com/tencent/mobileqq/data/MessageForPtt
    //   1185: getfield 590	com/tencent/mobileqq/data/MessageForPtt:url	Ljava/lang/String;
    //   1188: putfield 593	com/tencent/mobileqq/app/message/QQMessageFacade$Message:pttUrl	Ljava/lang/String;
    //   1191: return
    //   1192: astore_1
    //   1193: aload_1
    //   1194: invokevirtual 596	java/lang/Exception:printStackTrace	()V
    //   1197: return
    //   1198: aload_1
    //   1199: getfield 391	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1202: sipush -2025
    //   1205: if_icmpne +61 -> 1266
    //   1208: aload_1
    //   1209: getfield 292	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   1212: ifnull -832 -> 380
    //   1215: new 598	com/tencent/mobileqq/data/MessageForQQWalletMsg
    //   1218: dup
    //   1219: invokespecial 599	com/tencent/mobileqq/data/MessageForQQWalletMsg:<init>	()V
    //   1222: astore 5
    //   1224: aload 5
    //   1226: aload_1
    //   1227: getfield 292	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   1230: putfield 600	com/tencent/mobileqq/data/MessageForQQWalletMsg:msgData	[B
    //   1233: aload 5
    //   1235: invokevirtual 601	com/tencent/mobileqq/data/MessageForQQWalletMsg:parse	()V
    //   1238: aload_1
    //   1239: aload 5
    //   1241: invokevirtual 604	com/tencent/mobileqq/data/MessageForQQWalletMsg:getMsgSummary	()Ljava/lang/String;
    //   1244: putfield 303	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1247: return
    //   1248: astore_1
    //   1249: invokestatic 140	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1252: ifeq -872 -> 380
    //   1255: ldc 13
    //   1257: iconst_2
    //   1258: aload_1
    //   1259: invokevirtual 559	java/lang/Exception:toString	()Ljava/lang/String;
    //   1262: invokestatic 562	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1265: return
    //   1266: aload_1
    //   1267: getfield 303	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1270: ifnull -890 -> 380
    //   1273: ldc_w 506
    //   1276: aload_1
    //   1277: getfield 303	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1280: invokevirtual 71	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1283: ifne -903 -> 380
    //   1286: aload_1
    //   1287: getfield 303	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1290: astore 5
    //   1292: aload_0
    //   1293: aload 5
    //   1295: invokespecial 606	com/tencent/mobileqq/app/message/BaseMessageManager:a	(Ljava/lang/String;)Z
    //   1298: ifeq +254 -> 1552
    //   1301: aload 5
    //   1303: ldc 86
    //   1305: invokevirtual 90	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1308: iconst_1
    //   1309: aaload
    //   1310: ldc 92
    //   1312: invokevirtual 90	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1315: astore 5
    //   1317: aload 5
    //   1319: ifnull -939 -> 380
    //   1322: aload 5
    //   1324: arraylength
    //   1325: iconst_2
    //   1326: if_icmpge +97 -> 1423
    //   1329: iconst_1
    //   1330: istore_2
    //   1331: aload_1
    //   1332: iload_2
    //   1333: putfield 609	com/tencent/mobileqq/app/message/QQMessageFacade$Message:fileType	I
    //   1336: aload 5
    //   1338: arraylength
    //   1339: iconst_2
    //   1340: if_icmpge +97 -> 1437
    //   1343: ldc2_w 610
    //   1346: lstore_3
    //   1347: aload_1
    //   1348: lload_3
    //   1349: putfield 614	com/tencent/mobileqq/app/message/QQMessageFacade$Message:fileSize	J
    //   1352: iload_2
    //   1353: lookupswitch	default:+51->1404, 0:+52->1405, 1:+127->1480, 2:+173->1526, 3:+-973->380, 65538:+127->1480
    //   1405: aload_1
    //   1406: aload_0
    //   1407: getfield 22	com/tencent/mobileqq/app/message/BaseMessageManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1410: invokevirtual 472	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1413: ldc_w 565
    //   1416: invokevirtual 513	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   1419: putfield 303	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1422: return
    //   1423: aload 5
    //   1425: iconst_2
    //   1426: aaload
    //   1427: invokestatic 103	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1430: invokevirtual 617	java/lang/Integer:intValue	()I
    //   1433: istore_2
    //   1434: goto -103 -> 1331
    //   1437: aload 5
    //   1439: iconst_1
    //   1440: aaload
    //   1441: invokestatic 98	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   1444: invokevirtual 621	java/lang/Long:longValue	()J
    //   1447: lstore_3
    //   1448: goto -101 -> 1347
    //   1451: astore 6
    //   1453: invokestatic 140	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1456: ifeq +14 -> 1470
    //   1459: ldc 13
    //   1461: iconst_2
    //   1462: ldc_w 623
    //   1465: aload 6
    //   1467: invokestatic 626	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1470: aload_1
    //   1471: ldc2_w 610
    //   1474: putfield 614	com/tencent/mobileqq/app/message/QQMessageFacade$Message:fileSize	J
    //   1477: goto -125 -> 1352
    //   1480: aload_1
    //   1481: getfield 391	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1484: sipush -3001
    //   1487: if_icmpne +21 -> 1508
    //   1490: aload_1
    //   1491: aload_0
    //   1492: getfield 22	com/tencent/mobileqq/app/message/BaseMessageManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1495: invokevirtual 472	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1498: ldc_w 627
    //   1501: invokevirtual 513	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   1504: putfield 303	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1507: return
    //   1508: aload_1
    //   1509: aload_0
    //   1510: getfield 22	com/tencent/mobileqq/app/message/BaseMessageManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1513: invokevirtual 472	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1516: ldc_w 564
    //   1519: invokevirtual 513	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   1522: putfield 303	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1525: return
    //   1526: aload_1
    //   1527: aload_0
    //   1528: getfield 22	com/tencent/mobileqq/app/message/BaseMessageManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1531: invokevirtual 472	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1534: ldc_w 582
    //   1537: invokevirtual 513	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   1540: putfield 303	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1543: aload_1
    //   1544: aload 5
    //   1546: iconst_0
    //   1547: aaload
    //   1548: putfield 593	com/tencent/mobileqq/app/message/QQMessageFacade$Message:pttUrl	Ljava/lang/String;
    //   1551: return
    //   1552: aload_1
    //   1553: getfield 391	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1556: sipush -2006
    //   1559: if_icmpne +55 -> 1614
    //   1562: invokestatic 140	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1565: ifeq +12 -> 1577
    //   1568: ldc 13
    //   1570: iconst_2
    //   1571: ldc_w 629
    //   1574: invokestatic 562	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1577: aload_1
    //   1578: new 142	java/lang/StringBuilder
    //   1581: dup
    //   1582: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   1585: aload_0
    //   1586: getfield 22	com/tencent/mobileqq/app/message/BaseMessageManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1589: invokevirtual 472	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1592: ldc_w 582
    //   1595: invokevirtual 513	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   1598: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1601: ldc_w 631
    //   1604: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1607: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1610: putfield 303	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1613: return
    //   1614: aload_1
    //   1615: getfield 391	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1618: sipush -2008
    //   1621: if_icmpne +21 -> 1642
    //   1624: aload_1
    //   1625: aload_0
    //   1626: getfield 22	com/tencent/mobileqq/app/message/BaseMessageManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1629: invokevirtual 472	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1632: ldc_w 632
    //   1635: invokevirtual 513	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   1638: putfield 303	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1641: return
    //   1642: aload_1
    //   1643: getfield 303	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1646: ldc_w 634
    //   1649: invokevirtual 638	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1652: iconst_m1
    //   1653: if_icmpeq +98 -> 1751
    //   1656: aload_1
    //   1657: getfield 303	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1660: invokestatic 642	com/tencent/mobileqq/service/message/MessageUtils:a	(Ljava/lang/String;)[Ljava/lang/String;
    //   1663: astore 7
    //   1665: ldc_w 506
    //   1668: astore 6
    //   1670: aload 6
    //   1672: astore 5
    //   1674: aload 7
    //   1676: ifnull +20 -> 1696
    //   1679: aload 6
    //   1681: astore 5
    //   1683: aload 7
    //   1685: iconst_2
    //   1686: aaload
    //   1687: ifnull +9 -> 1696
    //   1690: aload 7
    //   1692: iconst_2
    //   1693: aaload
    //   1694: astore 5
    //   1696: aload_1
    //   1697: ldc_w 643
    //   1700: putfield 609	com/tencent/mobileqq/app/message/QQMessageFacade$Message:fileType	I
    //   1703: aload_1
    //   1704: new 142	java/lang/StringBuilder
    //   1707: dup
    //   1708: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   1711: ldc_w 645
    //   1714: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1717: aload_0
    //   1718: getfield 22	com/tencent/mobileqq/app/message/BaseMessageManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1721: invokevirtual 472	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1724: ldc_w 646
    //   1727: invokevirtual 513	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   1730: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1733: ldc_w 648
    //   1736: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1739: aload 5
    //   1741: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1744: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1747: putfield 303	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1750: return
    //   1751: aload_1
    //   1752: new 523	com/tencent/mobileqq/text/QQText
    //   1755: dup
    //   1756: aload_1
    //   1757: getfield 303	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1760: iconst_3
    //   1761: bipush 16
    //   1763: invokespecial 526	com/tencent/mobileqq/text/QQText:<init>	(Ljava/lang/CharSequence;II)V
    //   1766: putfield 530	com/tencent/mobileqq/app/message/QQMessageFacade$Message:emoRecentMsg	Ljava/lang/CharSequence;
    //   1769: return
    //   1770: goto -1626 -> 144
    //   1773: goto -1277 -> 496
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1776	0	this	BaseMessageManager
    //   0	1776	1	paramMessage	QQMessageFacade.Message
    //   1330	104	2	i	int
    //   1346	102	3	l	long
    //   155	736	5	localObject1	Object
    //   917	12	5	localException1	java.lang.Exception
    //   937	803	5	localObject2	Object
    //   71	526	6	localObject3	Object
    //   1451	15	6	localException2	java.lang.Exception
    //   1668	12	6	str	String
    //   1663	28	7	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   40	54	381	java/lang/Exception
    //   64	144	564	java/lang/Exception
    //   144	157	564	java/lang/Exception
    //   157	188	564	java/lang/Exception
    //   188	194	564	java/lang/Exception
    //   384	402	564	java/lang/Exception
    //   405	423	564	java/lang/Exception
    //   426	444	564	java/lang/Exception
    //   447	465	564	java/lang/Exception
    //   468	496	564	java/lang/Exception
    //   496	509	564	java/lang/Exception
    //   509	545	564	java/lang/Exception
    //   548	561	564	java/lang/Exception
    //   234	279	612	java/lang/Exception
    //   862	885	917	java/lang/Exception
    //   1162	1191	1192	java/lang/Exception
    //   1215	1247	1248	java/lang/Exception
    //   1336	1343	1451	java/lang/Exception
    //   1347	1352	1451	java/lang/Exception
    //   1437	1448	1451	java/lang/Exception
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
  
  public void a(MessageRecord paramMessageRecord)
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
        a(AppConstants.Z, paramMessageRecord.istroop, paramMessageRecord.frienduin, str);
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(AppConstants.Z, 1001);
      }
      while ((localObject != null) && (((QQMessageFacade.Message)localObject).senderuin != null) && (((QQMessageFacade.Message)localObject).senderuin.equals(paramMessageRecord.frienduin)))
      {
        ((QQMessageFacade.Message)localObject).cleanMessageRecordBaseField();
        return;
        if (paramMessageRecord.istroop == 1009)
        {
          a(AppConstants.S, paramMessageRecord.istroop, paramMessageRecord.frienduin, str);
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(AppConstants.S, 1009);
        }
      }
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
  
  public void a(MessageRecord paramMessageRecord, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    int j = 0;
    ArrayList localArrayList = new ArrayList();
    if ((paramMessageRecord instanceof MessageForLongMsg))
    {
      localArrayList.addAll(((MessageForLongMsg)paramMessageRecord).longMsgFragmentList);
      if (!MsgProxyUtils.a(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramMessageRecord.frienduin, paramMessageRecord.istroop))) {
        break label359;
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
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(((MessageRecord)localObject).istroop).a((MessageRecord)localObject, paramBoolean2);
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
      if (paramBoolean1) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord);
      }
      if (i != 0)
      {
        if (!MsgProxyUtils.k(paramMessageRecord.istroop)) {
          break label351;
        }
        a(paramMessageRecord);
      }
      for (;;)
      {
        if (paramBoolean2) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramMessageRecord.istroop).f();
        }
        return;
        label351:
        b(paramMessageRecord);
      }
      label359:
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new cxy(this, paramString, paramInt1, paramInt2, paramRefreshMessageContext));
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
        break label192;
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
    }
    label192:
    do
    {
      try
      {
        a(paramString3);
        return;
      }
      catch (Throwable paramString1)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("Q.msg.BaseMessageManager", 2, "removeMsgFromMsgBox ERROR", paramString1);
        return;
      }
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramString1, paramInt);
    } while (paramString1 == null);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString1);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong)
  {
    paramString3 = null;
    RecentUserProxy localRecentUserProxy;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString1, paramInt)) || (!MsgProxyUtils.k(paramInt)))
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
        } while (String.valueOf(AppConstants.V).equals(paramMessageRecord.frienduin));
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
      if ((localMessageRecord.istroop == 3000) || (localMessageRecord.istroop == 1)) {
        if ((localMessageRecord.isSendFromLocal()) || (localMessageRecord.shmsgseq >= paramMessageRecord.shmsgseq)) {
          break label889;
        }
      }
    }
    label889:
    for (paramInt = 1;; paramInt = 0)
    {
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
        if (!paramBoolean) {}
      }
      do
      {
        for (;;)
        {
          try
          {
            a(paramMessageRecord);
            bool1 = true;
            if (!localMessageRecord.isSend()) {
              paramMessageRecord.hasReply = true;
            }
            if (((localMessageRecord.isSendFromLocal()) || (localMessageRecord.isread)) && (localMessageRecord.msgtype != -1013) && (localMessageRecord.msgtype != -1019))
            {
              paramBoolean = bool1;
              if (localMessageRecord.msgtype != -1018) {}
            }
            else
            {
              if ((localMessageRecord.msgtype == -1013) || (localMessageRecord.msgtype == -1019) || (localMessageRecord.msgtype == -1018)) {
                this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b(paramMessageRecord);
              }
              if (!String.valueOf(AppConstants.V).equals(paramMessageRecord.frienduin)) {
                this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b(paramMessageRecord);
              }
              if (AppConstants.Y.equals(paramMessageRecord.frienduin))
              {
                paramInt = SystemMsgController.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                if (paramInt <= 0) {
                  continue;
                }
                this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().unReadNum = paramInt;
              }
              if (AppConstants.ad.equals(paramMessageRecord.frienduin))
              {
                paramInt = FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                if (paramInt <= 0) {
                  continue;
                }
                this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().unReadNum = paramInt;
              }
              paramBoolean = bool1;
              if (AppConstants.ae.equals(paramMessageRecord.frienduin))
              {
                paramInt = GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                if (paramInt <= 0) {
                  continue;
                }
                this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().unReadNum = paramInt;
                paramBoolean = bool1;
              }
            }
            bool1 = paramBoolean;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab fin " + paramMessageRecord.getBaseInfoString() + " , result = " + paramBoolean);
            return paramBoolean;
            if ((!MsgProxyUtils.a(localMessageRecord.istroop)) || (localMessageRecord.isSendFromLocal()) || (localMessageRecord.time >= paramMessageRecord.time)) {
              break label889;
            }
            paramInt = 1;
          }
          catch (Throwable localThrowable3)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab ERROR", localThrowable3);
            continue;
            this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b(null);
            continue;
            this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b(null);
            continue;
            this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b(null);
            paramBoolean = bool1;
            continue;
          }
          if ((paramInt == 4) || (paramInt == 2))
          {
            MessageRecord.copyMessageRecordBaseField(paramMessageRecord, localMessageRecord);
            paramMessageRecord.emoRecentMsg = null;
            paramMessageRecord.fileType = -1;
            if (paramBoolean) {}
            try
            {
              a(paramMessageRecord);
              paramBoolean = true;
            }
            catch (Throwable localThrowable1)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab ERROR", localThrowable1);
                }
              }
            }
          }
        }
        paramBoolean = bool4;
      } while (paramInt != 3);
      if (paramMessageRecord.uniseq == localThrowable1.uniseq) {
        MessageRecord.copyMessageRecordStatusField(paramMessageRecord, localThrowable1);
      }
      for (;;)
      {
        paramBoolean = true;
        break;
        MessageRecord.copyMessageRecordBaseField(paramMessageRecord, localThrowable1);
        paramMessageRecord.emoRecentMsg = null;
        paramMessageRecord.fileType = -1;
        try
        {
          a(paramMessageRecord);
        }
        catch (Throwable localThrowable2) {}
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab ERROR", localThrowable2);
        }
      }
    }
  }
  
  protected void b(QQMessageFacade.Message paramMessage) {}
  
  public void b(MessageRecord paramMessageRecord)
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
          break label267;
        }
        localMessage = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(AppConstants.S, 1009);
        if ((localMessage.senderuin != null) && (localMessage.senderuin.equals(paramString)))
        {
          paramString = MessageRecordFactory.a(paramMessageRecord.msgtype);
          MessageRecord.copyMessageRecordBaseField(paramString, paramMessageRecord);
          paramString.selfuin = paramMessageRecord.selfuin;
          paramString.senderuin = paramMessageRecord.frienduin;
          paramString.frienduin = AppConstants.S;
          if (paramInt2 != 3) {
            break label178;
          }
          a(paramString, true, paramInt2);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.S, 1009, l, paramMessageRecord.extraflag, localMessage.sendFailCode);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.S, 1009, l, paramMessageRecord.time, paramMessageRecord.shmsgseq);
        }
      }
    }
    label178:
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
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.S, 1009, l, paramMessageRecord.msg);
              return;
            }
          } while (paramInt2 != 4);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.S, paramInt1, paramString.senderuin, paramString.selfuin);
          a(paramString, null, false, true, paramInt2);
          a(paramMessageRecord, true, paramInt2);
          return;
        } while (paramInt1 != 1001);
        localMessage = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(AppConstants.Z, 1001);
      } while ((localMessage.senderuin == null) || (!localMessage.senderuin.equals(paramString)));
      paramString = MessageRecordFactory.a(paramMessageRecord.msgtype);
      MessageRecord.copyMessageRecordBaseField(paramString, paramMessageRecord);
      paramString.selfuin = paramMessageRecord.selfuin;
      paramString.senderuin = paramMessageRecord.frienduin;
      paramString.frienduin = AppConstants.Z;
      if (paramInt2 == 3)
      {
        a(paramString, true, paramInt2);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.Z, 1001, l, paramMessageRecord.extraflag, localMessage.sendFailCode);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.Z, 1001, l, paramMessageRecord.time, paramMessageRecord.shmsgseq);
        return;
      }
      if (paramInt2 == 2)
      {
        a(paramString, true, paramInt2);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.Z, 1001, l, paramMessageRecord.msg);
        return;
      }
    } while (paramInt2 != 4);
    label267:
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.Z, paramInt1, paramString.senderuin, paramString.selfuin);
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
      if (((paramInt == localMessage.istroop) || ((MsgProxyUtils.a(paramInt)) && (MsgProxyUtils.a(localMessage.istroop)))) && (localMessage.frienduin.equals(paramString)))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.BaseMessageManager
 * JD-Core Version:    0.7.0.1
 */