package com.tencent.mobileqq.app.message;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RecentManagerFor3rdPart;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.international.LocaleUtil;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.PBDecodeContext;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.systemmsg.SystemMsgController;
import com.tencent.mobileqq.systemmsg.SystemMsgUtils;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoReq;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import fjt;
import fju;
import fjv;
import fjw;
import fjx;
import fjy;
import fjz;
import fka;
import fkb;
import fkc;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;
import msf.msgcomm.msg_comm.Msg;
import tencent.mobileim.structmsg.structmsg.FlagInfo;
import tencent.mobileim.structmsg.structmsg.ReqNextSystemMsg;
import tencent.mobileim.structmsg.structmsg.ReqSystemMsg;
import tencent.mobileim.structmsg.structmsg.ReqSystemMsgAction;
import tencent.mobileim.structmsg.structmsg.ReqSystemMsgNew;
import tencent.mobileim.structmsg.structmsg.ReqSystemMsgRead;
import tencent.mobileim.structmsg.structmsg.RspHead;
import tencent.mobileim.structmsg.structmsg.RspNextSystemMsg;
import tencent.mobileim.structmsg.structmsg.RspSystemMsg;
import tencent.mobileim.structmsg.structmsg.RspSystemMsgAction;
import tencent.mobileim.structmsg.structmsg.RspSystemMsgNew;
import tencent.mobileim.structmsg.structmsg.RspSystemMsgRead;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class SystemMessageProcessor
  extends BaseMessageProcessor
{
  private static final String jdField_b_of_type_JavaLangString = "SystemMessageProcessor";
  private int jdField_b_of_type_Int;
  private int c;
  private int d;
  private final int e = 2;
  private final int f = 2;
  private final int g = 2;
  
  public SystemMessageProcessor(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
  }
  
  private String a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.Z, 0);
    if ((localObject == null) || (((List)localObject).size() <= 0)) {
      if (QLog.isColorLevel()) {
        QLog.d("SystemMessageProcessor", 2, "mLocalDataList is null !");
      }
    }
    while ((localObject == null) || (((List)localObject).size() <= 0)) {
      return "";
    }
    localObject = (MessageForSystemMsg)((List)localObject).get(((List)localObject).size() - 1);
    ((MessageForSystemMsg)localObject).parse();
    return ((MessageForSystemMsg)localObject).structMsg.msg.req_uin_nick.get() + " " + ((MessageForSystemMsg)localObject).structMsg.msg.msg_describe.get();
  }
  
  private void a(RecentUserProxy paramRecentUserProxy, RecentUser paramRecentUser)
  {
    paramRecentUserProxy.a(paramRecentUser);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg.getServiceCmd();
    long l1 = paramToServiceMsg.extraData.getLong("latestFriendSeq");
    long l2 = paramToServiceMsg.extraData.getLong("latestGroupSeq");
    long l3 = paramToServiceMsg.extraData.getLong("msgSeq");
    long l4 = paramToServiceMsg.extraData.getLong("timeOut");
    paramToServiceMsg.extraData.getInt("retryIndex");
    int i = paramToServiceMsg.extraData.getInt("type");
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramToServiceMsg, paramFromServiceMsg);
    paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l3);
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg.getResultCode() != 2901) {
        break label123;
      }
      paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
      paramToServiceMsg.getClass();
      if (!paramFromServiceMsg.a(paramToServiceMsg, "msf")) {
        break label123;
      }
    }
    label123:
    while ((480000L != l4) && (!paramToServiceMsg.a())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SystemMessageProcessor", 2, "handleSendSystemMsgReadedReportError type=" + i + ";reqSeq=" + l3 + ";latestFriendSeq=" + l1 + ";latestGroupSeq=" + l2);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l3);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getUin() == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    }
    Object localObject2;
    for (;;)
    {
      Object localObject1;
      try
      {
        localObject1 = new structmsg.RspSystemMsgNew();
      }
      catch (Exception localException1)
      {
        localObject1 = null;
      }
      try
      {
        ((structmsg.RspSystemMsgNew)localObject1).mergeFrom((byte[])paramObject);
        localObject2 = localObject1;
        localObject1 = new StringBuilder();
        if ((localObject2 != null) && (localObject2.head.result.get() == 0)) {
          break;
        }
        ((StringBuilder)localObject1).setLength(0);
        if (QLog.isColorLevel()) {
          QLog.e("SystemMessageProcessor", 2, ((StringBuilder)localObject1).toString());
        }
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      catch (Exception localException2)
      {
        break label115;
      }
      paramFromServiceMsg.getUin();
      continue;
      label115:
      localObject2 = localObject1;
      if (QLog.isColorLevel())
      {
        QLog.e("SystemMessageProcessor", 2, "<---handleGetSystemMsgRespNew : decode pb error:", localException1);
        localObject2 = localObject1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("SystemMessageProcessor", 2, "SystemMessageProcessor: listsize");
    }
    a(paramToServiceMsg, paramFromServiceMsg, paramObject, localObject2);
    b(paramToServiceMsg, paramFromServiceMsg, paramObject, localObject2);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, structmsg.RspSystemMsgNew paramRspSystemMsgNew)
  {
    if (paramFromServiceMsg.getUin() == null) {}
    for (Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(); FriendSystemMsgController.a().b(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler); localObject1 = paramFromServiceMsg.getUin()) {
      return;
    }
    if (paramRspSystemMsgNew != null) {}
    for (;;)
    {
      paramObject = new StringBuilder();
      if ((paramRspSystemMsgNew != null) && (paramRspSystemMsgNew.head.result.get() == 0)) {
        break;
      }
      paramObject.setLength(0);
      if (QLog.isColorLevel()) {
        QLog.e("SystemMessageProcessor", 2, paramObject.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramToServiceMsg, paramFromServiceMsg);
      return;
      try
      {
        paramRspSystemMsgNew = new structmsg.RspSystemMsgNew();
        try
        {
          paramRspSystemMsgNew.mergeFrom((byte[])paramObject);
        }
        catch (Exception localException1)
        {
          paramObject = paramRspSystemMsgNew;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          int j;
          int k;
          int i;
          long l2;
          long l1;
          boolean bool1;
          Object localObject2;
          int m;
          int n;
          boolean bool2;
          paramObject = null;
        }
      }
      paramRspSystemMsgNew = paramObject;
      if (QLog.isColorLevel())
      {
        QLog.e("Q.systemmsg.", 2, "<---handleGetFriendSystemMsgResp : decode pb error:", localException1);
        paramRspSystemMsgNew = paramObject;
      }
    }
    paramFromServiceMsg = paramRspSystemMsgNew.friendmsgs.get();
    j = paramFromServiceMsg.size();
    k = paramRspSystemMsgNew.unread_friend_count.get();
    i = FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    paramToServiceMsg = "";
    if (paramRspSystemMsgNew.msg_display.has()) {
      paramToServiceMsg = paramRspSystemMsgNew.msg_display.get();
    }
    l2 = 0L;
    l1 = l2;
    if (paramFromServiceMsg != null)
    {
      l1 = l2;
      if (paramFromServiceMsg.size() > 0) {
        l1 = ((structmsg.StructMsg)paramFromServiceMsg.get(0)).msg_time.get();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.systemmsg.", 2, "<---handleGetFriendSystemMsgResp : decode pb MsgsSize = " + j + " latest_friend_seq" + paramRspSystemMsgNew.latest_friend_seq.get() + " latest_group_seq" + paramRspSystemMsgNew.latest_group_seq.get() + " following_friend_seq" + paramRspSystemMsgNew.following_friend_seq.get() + " following_group_seq" + paramRspSystemMsgNew.following_group_seq.get() + " unreadCount" + k + " localunreadCount" + i);
    }
    this.b = 0;
    if ((j == 0) && (k == i))
    {
      FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, k);
      if (TextUtils.isEmpty(paramToServiceMsg))
      {
        paramToServiceMsg = a();
        FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, paramToServiceMsg, l1);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_friend_seq_47", paramRspSystemMsgNew.latest_friend_seq.get());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("following_friend_seq_47", paramRspSystemMsgNew.following_friend_seq.get());
      FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, k);
      bool1 = false;
      if (k > i) {
        bool1 = true;
      }
      paramObject = new ArrayList();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.Z, 0, true, false);
      FriendSystemMsgController.a().a(true);
      FriendSystemMsgController.a().a(false, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      i = 0;
      if (i < j)
      {
        paramRspSystemMsgNew = MessageRecordFactory.a(-2018);
        paramRspSystemMsgNew.msgtype = -2018;
        paramRspSystemMsgNew.selfuin = ((String)localObject1);
        paramRspSystemMsgNew.frienduin = AppConstants.Z;
        paramRspSystemMsgNew.senderuin = (((structmsg.StructMsg)paramFromServiceMsg.get(i)).req_uin.get() + "");
        paramRspSystemMsgNew.istroop = 0;
        if (i == 0) {
          paramRspSystemMsgNew.extStr = paramToServiceMsg;
        }
        localObject2 = (MessageForSystemMsg)paramRspSystemMsgNew;
        ((MessageForSystemMsg)localObject2).structMsg = ((structmsg.StructMsg)((structmsg.StructMsg)paramFromServiceMsg.get(i)).get());
        m = ((MessageForSystemMsg)localObject2).structMsg.msg_type.get();
        n = ((MessageForSystemMsg)localObject2).structMsg.msg.sub_type.get();
        if ((m == 1) && (!SystemMsgUtils.a(n))) {
          if (QLog.isColorLevel()) {
            QLog.e("Q.systemmsg.", 2, "<---handleGetFriendSystemMsgResp : decode pb filtered");
          }
        }
        for (;;)
        {
          i += 1;
          break;
          paramRspSystemMsgNew.msgData = ((MessageForSystemMsg)localObject2).structMsg.toByteArray();
          ((ChatMessage)paramRspSystemMsgNew).parse();
          paramObject.add(localObject2);
        }
      }
      if (paramObject.size() > 0)
      {
        paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        paramRspSystemMsgNew = String.valueOf(localObject1);
        if ((MessageHandlerUtils.a(paramObject)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause))
        {
          bool2 = true;
          paramFromServiceMsg.a(paramObject, paramRspSystemMsgNew, bool2);
          a("handleGetSystemMsgResp", true, k, bool1, false);
        }
      }
      else
      {
        if (k == 0) {
          a(paramObject);
        }
        paramFromServiceMsg = paramToServiceMsg;
        if (!TextUtils.isEmpty(paramToServiceMsg)) {
          break label1223;
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.Z, 0);
        if ((localObject2 == null) || (((List)localObject2).size() != 0)) {
          break label923;
        }
      }
      for (;;)
      {
        FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, paramToServiceMsg, l1);
        a(4005, true, null);
        return;
        bool2 = false;
        break;
        label923:
        paramRspSystemMsgNew = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        localObject1 = paramRspSystemMsgNew.a(AppConstants.R, 4000);
        ((RecentUser)localObject1).msgType = 5;
        ((RecentUser)localObject1).displayName = "新朋友";
        l2 = l1;
        paramObject = paramToServiceMsg;
        if (localObject2 != null)
        {
          l2 = l1;
          paramObject = paramToServiceMsg;
          paramFromServiceMsg = paramToServiceMsg;
        }
        try
        {
          if (((List)localObject2).size() > 0)
          {
            paramFromServiceMsg = paramToServiceMsg;
            localObject2 = (MessageForSystemMsg)((List)localObject2).get(((List)localObject2).size() - 1);
            paramFromServiceMsg = paramToServiceMsg;
            ((MessageForSystemMsg)localObject2).parse();
            paramFromServiceMsg = paramToServiceMsg;
            paramObject = ((MessageForSystemMsg)localObject2).structMsg.msg.req_uin_nick.get() + " " + ((MessageForSystemMsg)localObject2).structMsg.msg.msg_describe.get() + NewFriendManager.b + 0;
            paramFromServiceMsg = paramToServiceMsg;
            ((RecentUser)localObject1).lastmsgtime = ((MessageForSystemMsg)localObject2).time;
            paramFromServiceMsg = paramToServiceMsg;
            ((RecentUser)localObject1).msgData = paramObject.getBytes();
            paramFromServiceMsg = paramToServiceMsg;
            ((RecentUser)localObject1).msg = paramObject;
            paramFromServiceMsg = paramToServiceMsg;
            ((RecentUser)localObject1).reParse();
            paramFromServiceMsg = paramToServiceMsg;
            ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32)).b();
            paramFromServiceMsg = paramToServiceMsg;
            a(paramRspSystemMsgNew, (RecentUser)localObject1);
            paramFromServiceMsg = paramToServiceMsg;
            paramObject = ((MessageForSystemMsg)localObject2).structMsg.msg.req_uin_nick.get() + " " + ((MessageForSystemMsg)localObject2).structMsg.msg.msg_describe.get();
            paramFromServiceMsg = paramObject;
            l2 = ((MessageForSystemMsg)localObject2).time;
          }
          paramToServiceMsg = paramObject;
          l1 = l2;
        }
        catch (Exception paramToServiceMsg)
        {
          paramToServiceMsg.printStackTrace();
        }
        label1223:
        paramToServiceMsg = paramFromServiceMsg;
      }
    }
  }
  
  private void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    RecentUserProxy localRecentUserProxy;
    do
    {
      return;
      localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    } while ((paramList == null) || (paramList.size() <= 0) || (localRecentUserProxy.a(AppConstants.R, 4000)));
    RecentUser localRecentUser = localRecentUserProxy.a(AppConstants.R, 4000);
    localRecentUser.msgType = 5;
    localRecentUser.displayName = "新朋友";
    Object localObject = (MessageForSystemMsg)paramList.get(0);
    ((MessageForSystemMsg)localObject).parse();
    if (!TextUtils.isEmpty(((MessageForSystemMsg)localObject).extStr)) {}
    for (String str = ((MessageForSystemMsg)localObject).extStr + NewFriendManager.b + 0;; str = ((MessageForSystemMsg)localObject).structMsg.msg.req_uin_nick.get() + " " + ((MessageForSystemMsg)localObject).structMsg.msg.msg_describe.get() + NewFriendManager.b + 0)
    {
      localRecentUser.lastmsgtime = ((MessageForSystemMsg)localObject).time;
      localRecentUser.msgData = str.getBytes();
      localRecentUser.msg = str;
      localRecentUser.reParse();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("mDataList.size() ").append(paramList.size()).append(" | msg = ");
        paramList = str;
        if (TextUtils.isEmpty(str)) {
          paramList = "";
        }
        QLog.d("SystemMessageProcessor", 2, paramList);
      }
      a(localRecentUserProxy, localRecentUser);
      ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32)).b();
      return;
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str;
    if (paramFromServiceMsg.getUin() == null) {
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    }
    for (;;)
    {
      try
      {
        localObject1 = new structmsg.RspNextSystemMsg();
      }
      catch (Exception localException1)
      {
        Object localObject1;
        paramObject = null;
      }
      try
      {
        ((structmsg.RspNextSystemMsg)localObject1).mergeFrom((byte[])paramObject);
        paramObject = localObject1;
        localObject1 = new StringBuilder();
        if ((paramObject != null) && (paramObject.head.result.get() == 0)) {
          break;
        }
        ((StringBuilder)localObject1).setLength(0);
        if (QLog.isColorLevel()) {
          QLog.e("SystemMessageProcessor", 2, ((StringBuilder)localObject1).toString());
        }
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          int j;
          int i;
          long l1;
          long l3;
          long l2;
          boolean bool;
          paramObject = localObject2;
          Object localObject2 = localException2;
        }
      }
      str = paramFromServiceMsg.getUin();
      continue;
      if (QLog.isColorLevel()) {
        QLog.e("SystemMessageProcessor", 2, "<---handleGetNextOldSystemMsgResp : decode pb:", localException1);
      }
    }
    paramToServiceMsg = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.bN = 0;
    paramFromServiceMsg = paramObject.msgs.get();
    j = paramFromServiceMsg.size();
    if (QLog.isColorLevel()) {
      QLog.e("SystemMessageProcessor", 2, "<---handleGetNextOldSystemMsgResp : decode pb size = " + j);
    }
    i = 0;
    while (i < j)
    {
      localObject2 = MessageRecordFactory.a(-2018);
      ((MessageRecord)localObject2).msgtype = -2018;
      ((MessageRecord)localObject2).selfuin = str;
      ((MessageRecord)localObject2).frienduin = AppConstants.U;
      ((MessageRecord)localObject2).senderuin = AppConstants.U;
      ((MessageRecord)localObject2).istroop = 0;
      MessageForSystemMsg localMessageForSystemMsg = (MessageForSystemMsg)localObject2;
      localMessageForSystemMsg.structMsg = ((structmsg.StructMsg)((structmsg.StructMsg)paramFromServiceMsg.get(i)).get());
      ((MessageRecord)localObject2).msgData = localMessageForSystemMsg.structMsg.toByteArray();
      paramToServiceMsg.add(localMessageForSystemMsg);
      i += 1;
    }
    if (paramToServiceMsg.size() > 0)
    {
      if (paramToServiceMsg.size() < 10) {
        SystemMsgController.a().a(true, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      SystemMsgController.a().a(false);
      l1 = paramObject.following_friend_seq.get();
      l3 = paramObject.following_group_seq.get();
      if (l1 > 0L) {
        break label567;
      }
      l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("following_friend_seq_47");
      l2 = l3;
      if (l3 <= 0L) {
        l2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("following_group_seq");
      }
      if (QLog.isColorLevel()) {
        QLog.e("SystemMessageProcessor", 2, "<---handleGetNextOldSystemMsgResp : decode pb following_friend_seq" + l1 + " following_group_seq" + l2);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(l1, l2);
      paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      paramObject = String.valueOf(str);
      if ((MessageHandlerUtils.a(paramToServiceMsg)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause))
      {
        bool = true;
        paramFromServiceMsg.a(paramToServiceMsg, paramObject, bool);
        a("handleGetSystemMsgResp", true, paramToServiceMsg.size(), false, false);
      }
    }
    for (;;)
    {
      a(4005, true, null);
      return;
      bool = false;
      break;
      SystemMsgController.a().a(true, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, structmsg.RspSystemMsgNew paramRspSystemMsgNew)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("SystemMessageProcessor", 4, "processGroupSystemMsg");
    }
    String str;
    if (paramFromServiceMsg.getUin() == null)
    {
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      if (!GroupSystemMsgController.a().b(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler)) {
        break label54;
      }
    }
    label54:
    do
    {
      return;
      str = paramFromServiceMsg.getUin();
      break;
      if (paramRspSystemMsgNew != null) {}
      for (;;)
      {
        if ((paramRspSystemMsgNew != null) && (!TextUtils.isEmpty(paramRspSystemMsgNew.grp_msg_display.get()))) {
          GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRspSystemMsgNew.grp_msg_display.get());
        }
        paramObject = new StringBuilder();
        if ((paramRspSystemMsgNew != null) && (paramRspSystemMsgNew.head.result.get() == 0)) {
          break;
        }
        paramObject.setLength(0);
        if (QLog.isColorLevel()) {
          QLog.e("SystemMessageProcessor", 2, paramObject.toString());
        }
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramToServiceMsg, paramFromServiceMsg);
        return;
        try
        {
          paramRspSystemMsgNew = new structmsg.RspSystemMsgNew();
          try
          {
            paramRspSystemMsgNew.mergeFrom((byte[])paramObject);
          }
          catch (Exception localException1)
          {
            paramObject = paramRspSystemMsgNew;
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            int j;
            int k;
            int i;
            boolean bool1;
            MessageForSystemMsg localMessageForSystemMsg;
            int m;
            int n;
            boolean bool2;
            paramObject = null;
          }
        }
        paramRspSystemMsgNew = paramObject;
        if (QLog.isColorLevel())
        {
          QLog.e("SystemMessageProcessor", 2, "<---handleGetGroupSystemMsgResp : decode pb error:", localException1);
          paramRspSystemMsgNew = paramObject;
        }
      }
      paramFromServiceMsg = paramRspSystemMsgNew.groupmsgs.get();
      j = paramFromServiceMsg.size();
      if (QLog.isColorLevel()) {
        QLog.d("SystemMessageProcessor", 2, "<---handleGetGroupSystemMsgResp : decode pb groupMsgsSize = " + j + " latest_friend_seq" + paramRspSystemMsgNew.latest_friend_seq.get() + " latest_group_seq" + paramRspSystemMsgNew.latest_group_seq.get() + " following_friend_seq" + paramRspSystemMsgNew.following_friend_seq.get() + " following_group_seq" + paramRspSystemMsgNew.following_group_seq.get());
      }
      k = paramRspSystemMsgNew.unread_group_count.get();
      i = GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    } while (j == 0);
    this.b = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_group_seq", paramRspSystemMsgNew.latest_group_seq.get());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("following_group_seq", paramRspSystemMsgNew.following_group_seq.get());
    GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, k);
    bool1 = false;
    if (k > i) {
      bool1 = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(AppConstants.ag, 9000, k - i);
    paramToServiceMsg = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.aa, 0, true, false);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.ad, 0, true, false);
    GroupSystemMsgController.a().a(true);
    GroupSystemMsgController.a().a(false, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    i = 0;
    if (i < j)
    {
      paramObject = MessageRecordFactory.a(-2018);
      paramObject.msgtype = -2018;
      paramObject.selfuin = str;
      paramObject.frienduin = AppConstants.aa;
      paramObject.senderuin = (((structmsg.StructMsg)paramFromServiceMsg.get(i)).req_uin.get() + "");
      paramObject.istroop = 0;
      localMessageForSystemMsg = (MessageForSystemMsg)paramObject;
      localMessageForSystemMsg.structMsg = ((structmsg.StructMsg)((structmsg.StructMsg)paramFromServiceMsg.get(i)).get());
      m = localMessageForSystemMsg.structMsg.msg_type.get();
      n = localMessageForSystemMsg.structMsg.msg.sub_type.get();
      if ((m == 1) && (!SystemMsgUtils.a(n))) {}
      for (;;)
      {
        i += 1;
        break;
        if (n == 1) {
          paramObject.senderuin = (((structmsg.StructMsg)paramFromServiceMsg.get(i)).msg.action_uin.get() + "");
        }
        m = ((structmsg.StructMsg)paramFromServiceMsg.get(i)).msg.group_msg_type.get();
        if ((m == 13) || (m == 6) || (m == 7))
        {
          FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
          if (localFriendsManagerImp != null)
          {
            localFriendsManagerImp.a(((structmsg.StructMsg)paramFromServiceMsg.get(i)).msg.group_code.get() + "", ((structmsg.StructMsg)paramFromServiceMsg.get(i)).req_uin.get() + "");
            if (m == 7)
            {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((structmsg.StructMsg)paramFromServiceMsg.get(i)).msg.group_code.get() + "", 1);
              localFriendsManagerImp.e(((structmsg.StructMsg)paramFromServiceMsg.get(i)).msg.group_code.get() + "");
              DBUtils.a().a(((structmsg.StructMsg)paramFromServiceMsg.get(i)).msg.group_code.get() + "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
            }
          }
        }
        paramObject.msgData = localMessageForSystemMsg.structMsg.toByteArray();
        paramToServiceMsg.add(localMessageForSystemMsg);
      }
    }
    if (paramToServiceMsg.size() > 0)
    {
      paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      paramObject = String.valueOf(str);
      if ((!MessageHandlerUtils.a(paramToServiceMsg)) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause)) {
        break label1371;
      }
    }
    label1371:
    for (bool2 = true;; bool2 = false)
    {
      paramFromServiceMsg.a(paramToServiceMsg, paramObject, bool2);
      a("handleGetSystemMsgResp", true, k, bool1, false);
      if ((paramRspSystemMsgNew.msg_ribbon_group.has()) && (paramRspSystemMsgNew.msg_ribbon_group.get() != null))
      {
        paramObject = (structmsg.StructMsg)paramRspSystemMsgNew.msg_ribbon_group.get();
        paramFromServiceMsg = MessageRecordFactory.a(-2018);
        paramFromServiceMsg.selfuin = str;
        paramFromServiceMsg.frienduin = AppConstants.ad;
        paramFromServiceMsg.senderuin = (paramObject.req_uin.get() + "");
        paramFromServiceMsg.istroop = 0;
        paramRspSystemMsgNew = (MessageForSystemMsg)paramFromServiceMsg;
        paramRspSystemMsgNew.structMsg = paramObject;
        paramFromServiceMsg.msgData = paramRspSystemMsgNew.structMsg.toByteArray();
        paramObject = new ArrayList();
        paramObject.add(paramFromServiceMsg);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramObject, String.valueOf(str), true);
        if (QLog.isColorLevel()) {
          QLog.d("Q.systemmsg.", 2, "ribbon info");
        }
      }
      GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramFromServiceMsg = (RecentManagerFor3rdPart)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(31);
      paramToServiceMsg = ((MessageForSystemMsg)paramToServiceMsg.get(0)).getSystemMsg();
      GroupSystemMsgController.a().a(paramToServiceMsg);
      long l = paramToServiceMsg.msg_time.get();
      paramFromServiceMsg.a(AppConstants.ag, 9000, BaseApplicationImpl.getContext().getString(2131559197), l, l);
      paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(Conversation.class);
      if (paramToServiceMsg != null) {
        paramToServiceMsg.sendMessage(paramToServiceMsg.obtainMessage(1009));
      }
      a(4005, true, null);
      return;
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str;
    if (paramFromServiceMsg.getUin() == null)
    {
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      if (!SystemMsgController.a().b(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler)) {
        break label39;
      }
    }
    label39:
    do
    {
      do
      {
        do
        {
          return;
          str = paramFromServiceMsg.getUin();
          break;
          for (;;)
          {
            try
            {
              localObject = new structmsg.RspSystemMsg();
              localObject = paramObject;
            }
            catch (Exception localException1)
            {
              try
              {
                ((structmsg.RspSystemMsg)localObject).mergeFrom((byte[])paramObject);
                paramObject = new StringBuilder();
                if ((localObject != null) && (((structmsg.RspSystemMsg)localObject).head.result.get() == 0)) {
                  break;
                }
                paramObject.setLength(0);
                if (QLog.isColorLevel()) {
                  QLog.e("SystemMessageProcessor", 2, paramObject.toString());
                }
                this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramToServiceMsg, paramFromServiceMsg);
                return;
              }
              catch (Exception localException2)
              {
                for (;;)
                {
                  Object localObject;
                  int j;
                  int k;
                  int i;
                  boolean bool1;
                  int m;
                  int n;
                  boolean bool2;
                  paramObject = localObject;
                }
              }
              localException1 = localException1;
              paramObject = null;
            }
            if (QLog.isColorLevel())
            {
              QLog.e("SystemMessageProcessor", 2, "<---handleGetSystemMsgResp : decode pb error:", localException1);
              localObject = paramObject;
            }
          }
          paramFromServiceMsg = ((structmsg.RspSystemMsg)localObject).msgs.get();
          j = paramFromServiceMsg.size();
          if (QLog.isColorLevel()) {
            QLog.e("SystemMessageProcessor", 2, "<---handleGetSystemMsgResp : decode pb size = " + j + " unreadNum = " + ((structmsg.RspSystemMsg)localObject).unread_count.get() + " tabDispaly" + Utils.a(((structmsg.RspSystemMsg)localObject).msg_display.get()) + " latest_friend_seq" + ((structmsg.RspSystemMsg)localObject).latest_friend_seq.get() + " latest_group_seq" + ((structmsg.RspSystemMsg)localObject).latest_group_seq.get() + " following_friend_seq" + ((structmsg.RspSystemMsg)localObject).following_friend_seq.get() + " following_group_seq" + ((structmsg.RspSystemMsg)localObject).following_group_seq.get());
          }
          k = ((structmsg.RspSystemMsg)localObject).unread_count.get();
          i = SystemMsgController.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          this.b = 0;
          if (!SystemMsgController.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
            break label418;
          }
          if (k > 0) {
            break label407;
          }
        } while (j <= 0);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((structmsg.RspSystemMsg)localObject).latest_friend_seq.get(), ((structmsg.RspSystemMsg)localObject).latest_group_seq.get());
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((structmsg.RspSystemMsg)localObject).following_friend_seq.get(), ((structmsg.RspSystemMsg)localObject).following_group_seq.get());
        return;
        SystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
        if (j != 0) {
          break label466;
        }
      } while (i == k);
      SystemMsgController.a().c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, k);
      paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(Conversation.class);
    } while (paramToServiceMsg == null);
    label407:
    label418:
    paramToServiceMsg.sendEmptyMessage(1009);
    return;
    label466:
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((structmsg.RspSystemMsg)localObject).latest_friend_seq.get(), ((structmsg.RspSystemMsg)localObject).latest_group_seq.get());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((structmsg.RspSystemMsg)localObject).following_friend_seq.get(), ((structmsg.RspSystemMsg)localObject).following_group_seq.get());
    SystemMsgController.a().c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, k);
    bool1 = false;
    if (k > i) {
      bool1 = true;
    }
    paramToServiceMsg = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.U, 0, true, false);
    SystemMsgController.a().a(true);
    SystemMsgController.a().a(false, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    SystemMsgController.a().a(((structmsg.RspSystemMsg)localObject).msg_display.get(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    i = 0;
    if (i < j)
    {
      paramObject = MessageRecordFactory.a(-2018);
      paramObject.msgtype = -2018;
      paramObject.selfuin = str;
      paramObject.frienduin = AppConstants.U;
      paramObject.senderuin = (((structmsg.StructMsg)paramFromServiceMsg.get(i)).req_uin.get() + "");
      paramObject.istroop = 0;
      localObject = (MessageForSystemMsg)paramObject;
      ((MessageForSystemMsg)localObject).structMsg = ((structmsg.StructMsg)((structmsg.StructMsg)paramFromServiceMsg.get(i)).get());
      m = ((MessageForSystemMsg)localObject).structMsg.msg_type.get();
      n = ((MessageForSystemMsg)localObject).structMsg.msg.sub_type.get();
      if ((m == 1) && (!SystemMsgUtils.a(n))) {}
      for (;;)
      {
        i += 1;
        break;
        paramObject.msgData = ((MessageForSystemMsg)localObject).structMsg.toByteArray();
        paramToServiceMsg.add(localObject);
      }
    }
    if (paramToServiceMsg.size() > 0)
    {
      paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      paramObject = String.valueOf(str);
      if ((!MessageHandlerUtils.a(paramToServiceMsg)) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause)) {
        break label859;
      }
    }
    label859:
    for (bool2 = true;; bool2 = false)
    {
      paramFromServiceMsg.a(paramToServiceMsg, paramObject, bool2);
      a("handleGetSystemMsgResp", true, k, bool1, false);
      a(4005, true, null);
      return;
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg.getServiceCmd();
    long l1 = paramToServiceMsg.extraData.getLong("latestFriendSeq");
    long l2 = paramToServiceMsg.extraData.getLong("latestGroupSeq");
    long l3 = paramToServiceMsg.extraData.getLong("msgSeq");
    paramToServiceMsg.extraData.getLong("timeOut");
    paramToServiceMsg.extraData.getInt("retryIndex");
    int i = paramToServiceMsg.extraData.getInt("type");
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramToServiceMsg, paramFromServiceMsg);
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l3) == null) {}
    for (;;)
    {
      return;
      if (paramObject == null) {
        continue;
      }
      paramToServiceMsg = new structmsg.RspSystemMsgRead();
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg == null) {
          continue;
        }
        int j = paramToServiceMsg.head.result.get();
        if (j == 0) {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l3);
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SystemMessageProcessor", 2, "handleSendSystemMsgReadedReport type =" + i + ";reqSeq=" + l3 + ";resultCode=" + j + ";latestFriendSeq=" + l1 + ";latestGroupSeq=" + l2);
        return;
      }
      catch (Exception paramFromServiceMsg)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("SystemMessageProcessor", 2, "<---handleSendSystemMsgReadedReport :type = " + i + " decode pb:", paramFromServiceMsg);
          }
        }
      }
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getUin() == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = new structmsg.RspSystemMsgAction();
      }
      catch (Exception paramObject)
      {
        int i;
        paramFromServiceMsg = null;
        if (QLog.isColorLevel()) {
          QLog.e("SystemMessageProcessor", 2, "<---handleSendSystemMsgAction : decode pb:", paramObject);
        }
        continue;
        String str = paramFromServiceMsg.head.msg_fail.get();
        paramObject = str;
        if (str == null) {
          paramObject = "";
        }
        paramToServiceMsg.extraData.putString("system_msg_action_resp_error_key", paramObject);
        bool = false;
        continue;
      }
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg == null) {
          break label300;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SystemMessageProcessor", 2, "handleSendSystemMsgAction result id=" + paramFromServiceMsg.head.result.get());
        }
        if (paramFromServiceMsg.head.result.get() != 0) {
          continue;
        }
        bool = true;
        str = paramFromServiceMsg.msg_detail.get();
        paramObject = str;
        if (str == null) {
          paramObject = "";
        }
        i = -1;
        if (paramFromServiceMsg.remark_result.has()) {
          i = paramFromServiceMsg.remark_result.get();
        }
        paramToServiceMsg.extraData.putString("system_msg_action_resp_key", paramObject);
        paramToServiceMsg.extraData.putInt("system_msg_action_resp_result_code_key", paramFromServiceMsg.head.result.get());
        paramToServiceMsg.extraData.putInt("system_msg_action_resp_type_key", paramFromServiceMsg.type.get());
        paramToServiceMsg.extraData.putString("system_msg_action_resp_invalid_decided_key", paramFromServiceMsg.msg_invalid_decided.get());
        paramToServiceMsg.extraData.putInt("system_msg_action_resp_remark_result_key", i);
      }
      catch (Exception paramObject)
      {
        continue;
        bool = false;
        continue;
      }
      a(4011, bool, paramToServiceMsg);
      return;
      paramFromServiceMsg.getUin();
    }
  }
  
  public List a(msg_comm.Msg paramMsg, PBDecodeContext paramPBDecodeContext)
  {
    return null;
  }
  
  public void a()
  {
    long l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_friend_seq_47");
    long l2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_group_seq");
    structmsg.ReqSystemMsgRead localReqSystemMsgRead = new structmsg.ReqSystemMsgRead();
    localReqSystemMsgRead.latest_friend_seq.set(l1);
    localReqSystemMsgRead.latest_group_seq.set(l2);
    if (QLog.isColorLevel()) {
      QLog.d("SystemMessageProcessor", 2, "sendSystemMsgReadedReport latestFriendSeq=" + l1 + ";latestGroupSeq=" + l2);
    }
    a(true, true, false, 0L, new fjv(this, l1, l2, localReqSystemMsgRead));
  }
  
  public void a(int paramInt)
  {
    if (!MessageHandler.c) {
      a(false);
    }
    Object localObject2;
    boolean bool;
    int i;
    do
    {
      return;
      localObject2 = null;
      switch (paramInt)
      {
      default: 
        localObject1 = "ProfileService.Pb.ReqSystemMsgNew";
        bool = false;
        i = 0;
        if (QLog.isColorLevel()) {
          QLog.w("Q.systemmsg.", 2, "<---sendGetSystemMsg type=" + paramInt + "isHold = " + bool + " latest_friend_seq = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_friend_seq_47") + " latest_group_seq = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_group_seq"));
        }
        break;
      }
    } while (bool);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a((String)localObject1);
    structmsg.ReqSystemMsgNew localReqSystemMsgNew = new structmsg.ReqSystemMsgNew();
    localReqSystemMsgNew.msg_num.set(10);
    localReqSystemMsgNew.checktype.set(i);
    localReqSystemMsgNew.latest_friend_seq.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_friend_seq_47"));
    localReqSystemMsgNew.latest_group_seq.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_group_seq"));
    if (localObject2 != null) {
      localReqSystemMsgNew.flag.set((MessageMicro)localObject2);
    }
    localReqSystemMsgNew.is_get_frd_ribbon.set(false);
    localReqSystemMsgNew.version.set(1000);
    localReqSystemMsgNew.is_get_grp_ribbon.set(false);
    paramInt = LocaleUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext());
    if (paramInt == 2) {
      localReqSystemMsgNew.language.set(1000);
    }
    for (;;)
    {
      ((ToServiceMsg)localObject1).putWupBuffer(localReqSystemMsgNew.toByteArray());
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b((ToServiceMsg)localObject1);
      return;
      localObject1 = "ProfileService.Pb.ReqSystemMsgNew";
      if ((FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler)) && (GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler))) {}
      for (bool = true;; bool = false)
      {
        localObject2 = new structmsg.FlagInfo();
        ((structmsg.FlagInfo)localObject2).GrpMsg_Kick_Admin.set(1);
        ((structmsg.FlagInfo)localObject2).GrpMsg_HiddenGrp.set(1);
        i = 4;
        break;
      }
      bool = FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler);
      localObject1 = "ProfileService.Pb.ReqSystemMsgNew.Friend";
      i = 2;
      break;
      bool = GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler);
      localObject2 = new structmsg.FlagInfo();
      ((structmsg.FlagInfo)localObject2).GrpMsg_Kick_Admin.set(1);
      ((structmsg.FlagInfo)localObject2).GrpMsg_HiddenGrp.set(1);
      localObject1 = "ProfileService.Pb.ReqSystemMsgNew.Group";
      i = 3;
      break;
      if (paramInt == 1) {
        localReqSystemMsgNew.language.set(1001);
      } else if (paramInt == 6) {
        localReqSystemMsgNew.language.set(1002);
      } else if (paramInt == 8) {
        localReqSystemMsgNew.language.set(1003);
      } else if (paramInt == 7) {
        localReqSystemMsgNew.language.set(1004);
      } else if (paramInt == 4) {
        localReqSystemMsgNew.language.set(1005);
      } else if (paramInt == 5) {
        localReqSystemMsgNew.language.set(1006);
      } else if (paramInt == 3) {
        localReqSystemMsgNew.language.set(1007);
      } else {
        localReqSystemMsgNew.language.set(1001);
      }
    }
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, structmsg.SystemMsgActionInfo paramSystemMsgActionInfo, int paramInt6)
  {
    a(paramInt1, paramLong1, paramLong2, paramInt2, paramInt3, paramInt4, paramInt5, paramSystemMsgActionInfo, paramInt6, null);
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, structmsg.SystemMsgActionInfo paramSystemMsgActionInfo, int paramInt6, structmsg.StructMsg paramStructMsg)
  {
    long l = paramInt1 + paramLong1;
    if (QLog.isColorLevel()) {
      QLog.d("Q.systemmsg.", 2, "sendFriendSystemMsgAction logStr=" + l);
    }
    Object localObject = new structmsg.ReqSystemMsgAction();
    ((structmsg.ReqSystemMsgAction)localObject).msg_type.set(paramInt1);
    ((structmsg.ReqSystemMsgAction)localObject).msg_seq.set(paramLong1);
    ((structmsg.ReqSystemMsgAction)localObject).req_uin.set(paramLong2);
    ((structmsg.ReqSystemMsgAction)localObject).sub_type.set(paramInt2);
    ((structmsg.ReqSystemMsgAction)localObject).src_id.set(paramInt3);
    ((structmsg.ReqSystemMsgAction)localObject).sub_src_id.set(paramInt4);
    ((structmsg.ReqSystemMsgAction)localObject).group_msg_type.set(paramInt5);
    ((structmsg.ReqSystemMsgAction)localObject).action_info.set(paramSystemMsgActionInfo);
    paramInt1 = LocaleUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext());
    if (paramInt1 == 2) {
      ((structmsg.ReqSystemMsgAction)localObject).language.set(1000);
    }
    for (;;)
    {
      ProtoReqManager.ProtoReq localProtoReq = new ProtoReqManager.ProtoReq();
      localProtoReq.a();
      localProtoReq.jdField_a_of_type_JavaLangString = "ProfileService.Pb.ReqSystemMsgAction.Friend";
      localProtoReq.jdField_a_of_type_ArrayOfByte = ((structmsg.ReqSystemMsgAction)localObject).toByteArray();
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a("ProfileService.Pb.ReqSystemMsgAction.Friend");
      ((ToServiceMsg)localObject).addAttribute("_tag_LOGSTR", String.valueOf(l));
      ((ToServiceMsg)localObject).extraData.putInt("system_msg_action_type", paramInt6);
      localProtoReq.jdField_a_of_type_JavaLangObject = localObject;
      localProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack = new fjt(this, paramInt6, paramLong2, paramSystemMsgActionInfo, paramStructMsg);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localProtoReq);
      return;
      if (paramInt1 == 1) {
        ((structmsg.ReqSystemMsgAction)localObject).language.set(1001);
      } else if (paramInt1 == 6) {
        ((structmsg.ReqSystemMsgAction)localObject).language.set(1002);
      } else if (paramInt1 == 8) {
        ((structmsg.ReqSystemMsgAction)localObject).language.set(1003);
      } else if (paramInt1 == 7) {
        ((structmsg.ReqSystemMsgAction)localObject).language.set(1004);
      } else if (paramInt1 == 4) {
        ((structmsg.ReqSystemMsgAction)localObject).language.set(1005);
      } else if (paramInt1 == 5) {
        ((structmsg.ReqSystemMsgAction)localObject).language.set(1006);
      } else if (paramInt1 == 3) {
        ((structmsg.ReqSystemMsgAction)localObject).language.set(1007);
      } else {
        ((structmsg.ReqSystemMsgAction)localObject).language.set(1001);
      }
    }
  }
  
  public void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    switch (paramInt)
    {
    case 6004: 
    default: 
      return;
    case 6002: 
    case 6005: 
      this.b = 0;
      return;
    case 6001: 
      this.c = 0;
      return;
    case 6003: 
      this.d = 0;
      return;
    }
    a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 6002: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        a((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    case 6001: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        a((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2], null);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    case 6003: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        b((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2], null);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    case 6004: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        b((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    case 6005: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        c((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    case 6006: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        d((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length == 3))
    {
      e((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
      return;
    }
    a(getClass().getName(), paramInt);
  }
  
  public void a(long paramLong1, int paramInt, byte[] paramArrayOfByte, long paramLong2, long paramLong3, long paramLong4)
  {
    if ((paramInt == 85) || (paramInt == 36))
    {
      FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      TroopInfo localTroopInfo2 = localFriendsManagerImp.a(String.valueOf(SystemMsg.getTroopCodeFromTroopSysMsg(paramArrayOfByte)));
      TroopInfo localTroopInfo1 = localTroopInfo2;
      if (localTroopInfo2 == null)
      {
        localTroopInfo1 = new TroopInfo();
        localTroopInfo1.troopuin = String.valueOf(SystemMsg.getTroopCodeFromTroopSysMsg(paramArrayOfByte));
        localTroopInfo1.troopcode = String.valueOf(paramLong2);
        localFriendsManagerImp.a(localTroopInfo1);
        ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(19)).a(localTroopInfo1.troopuin, (byte)1, localTroopInfo1.dwTimeStamp, 0);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(localTroopInfo1.troopuin, 1, paramLong3, true);
      b(2001, true, null);
    }
  }
  
  public void a(long paramLong1, long paramLong2, short paramShort, int paramInt)
  {
    String str = String.valueOf(paramLong2);
    FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    FriendListHandler localFriendListHandler = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
    if ((paramShort == 188) || (paramShort == 189))
    {
      bool = localFriendsManagerImp.b(String.valueOf(str));
      if (localFriendListHandler.a(String.valueOf(paramLong1), String.valueOf(str), 0)) {
        localFriendsManagerImp.a(str, false);
      }
      if (!bool) {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(str, 0, -1L, true);
      }
    }
    while (paramShort != 190)
    {
      boolean bool;
      return;
    }
    localFriendsManagerImp.a(str, false);
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool = SystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler);
    if (QLog.isColorLevel()) {
      QLog.w("SystemMessageProcessor", 2, "<---sendGetSystemMsgOld newMsg=" + paramBoolean + "isHold = " + bool + "latest_friend_seq = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_friend_seq_47") + " latest_group_seq = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_group_seq"));
    }
    if (bool) {
      return;
    }
    ToServiceMsg localToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a("ProfileService.Pb.ReqSystemMsg");
    localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
    structmsg.ReqSystemMsg localReqSystemMsg = new structmsg.ReqSystemMsg();
    localReqSystemMsg.msg_num.set(10);
    localReqSystemMsg.latest_friend_seq.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_friend_seq_47"));
    localReqSystemMsg.latest_group_seq.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_group_seq"));
    int i = LocaleUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext());
    if (i == 2) {
      localReqSystemMsg.language.set(1000);
    }
    for (;;)
    {
      localToServiceMsg.putWupBuffer(localReqSystemMsg.toByteArray());
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(localToServiceMsg);
      return;
      if (i == 1) {
        localReqSystemMsg.language.set(1001);
      } else if (i == 6) {
        localReqSystemMsg.language.set(1002);
      } else if (i == 8) {
        localReqSystemMsg.language.set(1003);
      } else if (i == 7) {
        localReqSystemMsg.language.set(1004);
      } else if (i == 4) {
        localReqSystemMsg.language.set(1005);
      } else if (i == 5) {
        localReqSystemMsg.language.set(1006);
      } else if (i == 3) {
        localReqSystemMsg.language.set(1007);
      } else {
        localReqSystemMsg.language.set(1001);
      }
    }
  }
  
  public void b()
  {
    int i = MobileQQService.c;
    MobileQQService.c = i + 1;
    long l1 = i;
    System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_friend_seq_47");
    long l3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_group_seq");
    if (QLog.isColorLevel()) {
      QLog.d("Q.systemmsg.", 2, "sendSystemMsgReadedReport reqSeq=" + l1 + ";latestFriendSeq=" + l2 + ";latestGroupSeq=" + l3);
    }
    structmsg.ReqSystemMsgRead localReqSystemMsgRead = new structmsg.ReqSystemMsgRead();
    localReqSystemMsgRead.latest_friend_seq.set(l2);
    localReqSystemMsgRead.checktype.set(2);
    ProtoReqManager.ProtoReq localProtoReq = new ProtoReqManager.ProtoReq();
    localProtoReq.jdField_a_of_type_JavaLangString = "ProfileService.Pb.ReqSystemMsgRead.Friend";
    localProtoReq.jdField_a_of_type_ArrayOfByte = localReqSystemMsgRead.toByteArray();
    localProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack = new fjw(this, l1, l2, l3);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localProtoReq);
  }
  
  public void b(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, structmsg.SystemMsgActionInfo paramSystemMsgActionInfo, int paramInt6)
  {
    long l = paramInt1 + paramLong1;
    if (QLog.isColorLevel()) {
      QLog.d("Q.systemmsg.", 2, "sendFriendSystemMsgAction logStr=" + l);
    }
    Object localObject = new structmsg.ReqSystemMsgAction();
    ((structmsg.ReqSystemMsgAction)localObject).msg_type.set(paramInt1);
    ((structmsg.ReqSystemMsgAction)localObject).msg_seq.set(paramLong1);
    ((structmsg.ReqSystemMsgAction)localObject).req_uin.set(paramLong2);
    ((structmsg.ReqSystemMsgAction)localObject).sub_type.set(paramInt2);
    ((structmsg.ReqSystemMsgAction)localObject).src_id.set(paramInt3);
    ((structmsg.ReqSystemMsgAction)localObject).sub_src_id.set(paramInt4);
    ((structmsg.ReqSystemMsgAction)localObject).group_msg_type.set(paramInt5);
    ((structmsg.ReqSystemMsgAction)localObject).action_info.set(paramSystemMsgActionInfo);
    paramInt1 = LocaleUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext());
    if (paramInt1 == 2) {
      ((structmsg.ReqSystemMsgAction)localObject).language.set(1000);
    }
    for (;;)
    {
      paramSystemMsgActionInfo = new ProtoReqManager.ProtoReq();
      paramSystemMsgActionInfo.a();
      paramSystemMsgActionInfo.jdField_a_of_type_JavaLangString = "ProfileService.Pb.ReqSystemMsgAction.Group";
      paramSystemMsgActionInfo.jdField_a_of_type_ArrayOfByte = ((structmsg.ReqSystemMsgAction)localObject).toByteArray();
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a("ProfileService.Pb.ReqSystemMsgAction.Group");
      ((ToServiceMsg)localObject).addAttribute("_tag_LOGSTR", String.valueOf(l));
      ((ToServiceMsg)localObject).extraData.putInt("system_msg_action_type", paramInt6);
      paramSystemMsgActionInfo.jdField_a_of_type_JavaLangObject = localObject;
      paramSystemMsgActionInfo.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack = new fju(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramSystemMsgActionInfo);
      return;
      if (paramInt1 == 1) {
        ((structmsg.ReqSystemMsgAction)localObject).language.set(1001);
      } else if (paramInt1 == 6) {
        ((structmsg.ReqSystemMsgAction)localObject).language.set(1002);
      } else if (paramInt1 == 8) {
        ((structmsg.ReqSystemMsgAction)localObject).language.set(1003);
      } else if (paramInt1 == 7) {
        ((structmsg.ReqSystemMsgAction)localObject).language.set(1004);
      } else if (paramInt1 == 4) {
        ((structmsg.ReqSystemMsgAction)localObject).language.set(1005);
      } else if (paramInt1 == 5) {
        ((structmsg.ReqSystemMsgAction)localObject).language.set(1006);
      } else if (paramInt1 == 3) {
        ((structmsg.ReqSystemMsgAction)localObject).language.set(1007);
      } else {
        ((structmsg.ReqSystemMsgAction)localObject).language.set(1001);
      }
    }
  }
  
  public void b(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 6002: 
    case 6005: 
      if (this.b < 2)
      {
        this.b += 1;
        a(4);
        return;
      }
      this.b = 0;
      return;
    case 6001: 
      if (this.c < 2)
      {
        this.c += 1;
        a(2);
        return;
      }
      this.c = 0;
      return;
    case 6003: 
      if (this.d < 2)
      {
        this.d += 1;
        a(3);
        return;
      }
      this.d = 0;
      return;
    case 6004: 
      if (QLog.isColorLevel()) {
        QLog.d("SystemMessageProcessor", 2, "onGetSystemMsgFin time out");
      }
      b(4006, false, null);
      return;
    case 6006: 
      a(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SystemMessageProcessor", 2, "onSendSystemMsgActionError");
    }
    b(4012, false, paramToServiceMsg);
  }
  
  public void c()
  {
    int i = MobileQQService.c;
    MobileQQService.c = i + 1;
    long l1 = i;
    System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_friend_seq_47");
    long l3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_group_seq");
    if (QLog.isColorLevel()) {
      QLog.d("Q.systemmsg.", 2, "sendGroupSystemMsgReadedReport reqSeq=" + l1 + ";latestFriendSeq=" + l2 + ";latestGroupSeq=" + l3);
    }
    structmsg.ReqSystemMsgRead localReqSystemMsgRead = new structmsg.ReqSystemMsgRead();
    localReqSystemMsgRead.latest_group_seq.set(l3);
    localReqSystemMsgRead.checktype.set(3);
    ProtoReqManager.ProtoReq localProtoReq = new ProtoReqManager.ProtoReq();
    localProtoReq.jdField_a_of_type_JavaLangString = "ProfileService.Pb.ReqSystemMsgRead.Group";
    localProtoReq.jdField_a_of_type_ArrayOfByte = localReqSystemMsgRead.toByteArray();
    localProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack = new fjx(this, l1, l2, l3);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localProtoReq);
  }
  
  public void d()
  {
    int i = MobileQQService.c;
    MobileQQService.c = i + 1;
    long l1 = i;
    System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_friend_seq_47");
    long l3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_group_seq");
    if (QLog.isColorLevel()) {
      QLog.d("Q.systemmsg.", 2, "clearFriendSystemMsg reqSeq=" + l1 + ";latestFriendSeq=" + l2 + ";latestGroupSeq=" + l3);
    }
    structmsg.ReqSystemMsgRead localReqSystemMsgRead = new structmsg.ReqSystemMsgRead();
    localReqSystemMsgRead.latest_friend_seq.set(l2);
    localReqSystemMsgRead.checktype.set(2);
    localReqSystemMsgRead.type.set(1);
    ProtoReqManager.ProtoReq localProtoReq = new ProtoReqManager.ProtoReq();
    localProtoReq.jdField_a_of_type_JavaLangString = "ProfileService.Pb.ReqSystemMsgRead.Friend";
    localProtoReq.jdField_a_of_type_ArrayOfByte = localReqSystemMsgRead.toByteArray();
    localProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack = new fjy(this, l1, l2, l3);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localProtoReq);
  }
  
  public void e()
  {
    int i = MobileQQService.c;
    MobileQQService.c = i + 1;
    long l1 = i;
    System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_friend_seq_47");
    long l3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_group_seq");
    if (QLog.isColorLevel()) {
      QLog.d("Q.systemmsg.", 2, "clearGroupSystemMsg reqSeq=" + l1 + ";latestFriendSeq=" + l2 + ";latestGroupSeq=" + l3);
    }
    structmsg.ReqSystemMsgRead localReqSystemMsgRead = new structmsg.ReqSystemMsgRead();
    localReqSystemMsgRead.latest_group_seq.set(l3);
    localReqSystemMsgRead.checktype.set(3);
    localReqSystemMsgRead.type.set(1);
    ProtoReqManager.ProtoReq localProtoReq = new ProtoReqManager.ProtoReq();
    localProtoReq.jdField_a_of_type_JavaLangString = "ProfileService.Pb.ReqSystemMsgRead.Group";
    localProtoReq.jdField_a_of_type_ArrayOfByte = localReqSystemMsgRead.toByteArray();
    localProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack = new fjz(this, l1, l2, l3);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localProtoReq);
  }
  
  public void f()
  {
    long l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_friend_seq_47");
    long l2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_group_seq");
    structmsg.ReqSystemMsgRead localReqSystemMsgRead = new structmsg.ReqSystemMsgRead();
    localReqSystemMsgRead.latest_friend_seq.set(l1);
    localReqSystemMsgRead.latest_group_seq.set(l2);
    localReqSystemMsgRead.type.set(1);
    if (QLog.isColorLevel()) {
      QLog.d("SystemMessageProcessor", 2, "clearSystemMsg latestFriendSeq=" + l1 + ";latestGroupSeq=" + l2);
    }
    a(true, true, false, 0L, new fka(this, l1, l2, localReqSystemMsgRead));
  }
  
  public void g()
  {
    ToServiceMsg localToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a("ProfileService.Pb.ReqNextSystemMsg");
    if (QLog.isColorLevel()) {
      QLog.w("Q.systemmsg.", 2, "<---sendGetNextOldSystemMsgfollowing_friend_seq = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("following_friend_seq_47") + "following_group_seq = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("following_group_seq"));
    }
    structmsg.ReqNextSystemMsg localReqNextSystemMsg = new structmsg.ReqNextSystemMsg();
    localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
    localReqNextSystemMsg.msg_num.set(10);
    localReqNextSystemMsg.version.set(1000);
    localReqNextSystemMsg.following_friend_seq.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("following_friend_seq_47"));
    localReqNextSystemMsg.following_group_seq.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("following_group_seq"));
    int i = LocaleUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext());
    if (i == 2) {
      localReqNextSystemMsg.language.set(1000);
    }
    for (;;)
    {
      localToServiceMsg.putWupBuffer(localReqNextSystemMsg.toByteArray());
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(localToServiceMsg);
      return;
      if (i == 1) {
        localReqNextSystemMsg.language.set(1001);
      } else if (i == 6) {
        localReqNextSystemMsg.language.set(1002);
      } else if (i == 8) {
        localReqNextSystemMsg.language.set(1003);
      } else if (i == 7) {
        localReqNextSystemMsg.language.set(1004);
      } else if (i == 4) {
        localReqNextSystemMsg.language.set(1005);
      } else if (i == 5) {
        localReqNextSystemMsg.language.set(1006);
      } else if (i == 3) {
        localReqNextSystemMsg.language.set(1007);
      } else {
        localReqNextSystemMsg.language.set(1001);
      }
    }
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a("ProfileService.Pb.ReqNextSystemMsg.Friend");
    if (QLog.isColorLevel()) {
      QLog.w("Q.systemmsg.", 2, "<---sendGetNextFriendSystemMsgfollowing_friend_seq = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("following_friend_seq_47"));
    }
    structmsg.ReqNextSystemMsg localReqNextSystemMsg = new structmsg.ReqNextSystemMsg();
    localReqNextSystemMsg.msg_num.set(10);
    localReqNextSystemMsg.following_friend_seq.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("following_friend_seq_47"));
    localReqNextSystemMsg.checktype.set(2);
    localReqNextSystemMsg.version.set(1000);
    int i = LocaleUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext());
    if (i == 2) {
      localReqNextSystemMsg.language.set(1000);
    }
    for (;;)
    {
      ProtoReqManager.ProtoReq localProtoReq = new ProtoReqManager.ProtoReq();
      localProtoReq.a();
      localProtoReq.jdField_a_of_type_JavaLangString = "ProfileService.Pb.ReqNextSystemMsg.Friend";
      localProtoReq.jdField_a_of_type_ArrayOfByte = localReqNextSystemMsg.toByteArray();
      localProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack = new fkb(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localProtoReq);
      return;
      if (i == 1) {
        localReqNextSystemMsg.language.set(1001);
      } else if (i == 6) {
        localReqNextSystemMsg.language.set(1002);
      } else if (i == 8) {
        localReqNextSystemMsg.language.set(1003);
      } else if (i == 7) {
        localReqNextSystemMsg.language.set(1004);
      } else if (i == 4) {
        localReqNextSystemMsg.language.set(1005);
      } else if (i == 5) {
        localReqNextSystemMsg.language.set(1006);
      } else if (i == 3) {
        localReqNextSystemMsg.language.set(1007);
      } else {
        localReqNextSystemMsg.language.set(1001);
      }
    }
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a("ProfileService.Pb.ReqNextSystemMsg.Group");
    if (QLog.isColorLevel()) {
      QLog.w("Q.systemmsg.", 2, "<---sendGetNextGroupSystemMsgfollowing_group_seq = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("following_group_seq"));
    }
    structmsg.ReqNextSystemMsg localReqNextSystemMsg = new structmsg.ReqNextSystemMsg();
    localReqNextSystemMsg.msg_num.set(10);
    localReqNextSystemMsg.following_group_seq.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("following_group_seq"));
    localReqNextSystemMsg.checktype.set(3);
    localReqNextSystemMsg.version.set(1000);
    Object localObject = new structmsg.FlagInfo();
    ((structmsg.FlagInfo)localObject).GrpMsg_Kick_Admin.set(1);
    localReqNextSystemMsg.flag.set((MessageMicro)localObject);
    int i = LocaleUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext());
    if (i == 2) {
      localReqNextSystemMsg.language.set(1000);
    }
    for (;;)
    {
      localObject = new ProtoReqManager.ProtoReq();
      ((ProtoReqManager.ProtoReq)localObject).a();
      ((ProtoReqManager.ProtoReq)localObject).jdField_a_of_type_JavaLangString = "ProfileService.Pb.ReqNextSystemMsg.Group";
      ((ProtoReqManager.ProtoReq)localObject).jdField_a_of_type_ArrayOfByte = localReqNextSystemMsg.toByteArray();
      ((ProtoReqManager.ProtoReq)localObject).jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack = new fkc(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((ProtoReqManager.ProtoReq)localObject);
      return;
      if (i == 1) {
        localReqNextSystemMsg.language.set(1001);
      } else if (i == 6) {
        localReqNextSystemMsg.language.set(1002);
      } else if (i == 8) {
        localReqNextSystemMsg.language.set(1003);
      } else if (i == 7) {
        localReqNextSystemMsg.language.set(1004);
      } else if (i == 4) {
        localReqNextSystemMsg.language.set(1005);
      } else if (i == 5) {
        localReqNextSystemMsg.language.set(1006);
      } else if (i == 3) {
        localReqNextSystemMsg.language.set(1007);
      } else {
        localReqNextSystemMsg.language.set(1001);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.SystemMessageProcessor
 * JD-Core Version:    0.7.0.1
 */