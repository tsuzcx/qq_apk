package com.tencent.mobileqq.app.message;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
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
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
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
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import dah;
import dai;
import daj;
import dak;
import dal;
import dam;
import dan;
import dao;
import dap;
import daq;
import dar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import msf.msgcomm.msg_comm.Msg;
import tencent.im.msg.im_msg_body.MsgBody;
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
  public static final int b = 0;
  public static final String b = "getSystemMsgSender";
  public static final int c = 1;
  private static final String c = "SystemMessageProcessor";
  private Map a;
  private int d;
  private int e;
  private int f;
  private final int g = 2;
  private final int h = 2;
  private final int i = 2;
  
  public SystemMessageProcessor(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  private String a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.ad, 0);
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
    int j = paramToServiceMsg.extraData.getInt("type");
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
      QLog.d("SystemMessageProcessor", 2, "handleSendSystemMsgReadedReportError type=" + j + ";reqSeq=" + l3 + ";latestFriendSeq=" + l1 + ";latestGroupSeq=" + l2);
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
          int k;
          int m;
          int j;
          long l2;
          long l1;
          boolean bool1;
          Object localObject2;
          int n;
          int i1;
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
    k = paramFromServiceMsg.size();
    m = paramRspSystemMsgNew.unread_friend_count.get();
    j = FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
      QLog.d("Q.systemmsg.", 2, "<---handleGetFriendSystemMsgResp : decode pb MsgsSize = " + k + " latest_friend_seq" + paramRspSystemMsgNew.latest_friend_seq.get() + " latest_group_seq" + paramRspSystemMsgNew.latest_group_seq.get() + " following_friend_seq" + paramRspSystemMsgNew.following_friend_seq.get() + " following_group_seq" + paramRspSystemMsgNew.following_group_seq.get() + " unreadCount" + m + " localunreadCount" + j);
    }
    this.d = 0;
    if ((k == 0) && (m == j))
    {
      FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, m);
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
      FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, m);
      bool1 = false;
      if (m > j) {
        bool1 = true;
      }
      paramObject = new ArrayList();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.ad, 0, true, false);
      FriendSystemMsgController.a().a(true);
      FriendSystemMsgController.a().a(false, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      j = 0;
      if (j < k)
      {
        paramRspSystemMsgNew = MessageRecordFactory.a(-2018);
        paramRspSystemMsgNew.msgtype = -2018;
        paramRspSystemMsgNew.selfuin = ((String)localObject1);
        paramRspSystemMsgNew.frienduin = AppConstants.ad;
        paramRspSystemMsgNew.senderuin = (((structmsg.StructMsg)paramFromServiceMsg.get(j)).req_uin.get() + "");
        paramRspSystemMsgNew.istroop = 0;
        if (j == 0) {
          paramRspSystemMsgNew.extStr = paramToServiceMsg;
        }
        localObject2 = (MessageForSystemMsg)paramRspSystemMsgNew;
        ((MessageForSystemMsg)localObject2).structMsg = ((structmsg.StructMsg)((structmsg.StructMsg)paramFromServiceMsg.get(j)).get());
        n = ((MessageForSystemMsg)localObject2).structMsg.msg_type.get();
        i1 = ((MessageForSystemMsg)localObject2).structMsg.msg.sub_type.get();
        if ((n == 1) && (!SystemMsgUtils.a(i1))) {
          if (QLog.isColorLevel()) {
            QLog.e("Q.systemmsg.", 2, "<---handleGetFriendSystemMsgResp : decode pb filtered");
          }
        }
        for (;;)
        {
          j += 1;
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
          a("handleGetSystemMsgResp", true, m, bool1, false);
        }
      }
      else
      {
        if (m == 0) {
          a(paramObject);
        }
        paramFromServiceMsg = paramToServiceMsg;
        if (!TextUtils.isEmpty(paramToServiceMsg)) {
          break label1254;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SystemMessageProcessor", 2, "newFriendMsgDisplay is null! using LocalDataList show");
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.ad, 0);
        if ((localObject2 != null) && (((List)localObject2).size() != 0)) {
          break label954;
        }
        paramFromServiceMsg = paramToServiceMsg;
        if (!QLog.isColorLevel()) {
          break label1254;
        }
        QLog.d("SystemMessageProcessor", 2, "mLocalDataList is null !");
      }
      for (;;)
      {
        FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, paramToServiceMsg, l1);
        a(4005, true, null);
        return;
        bool2 = false;
        break;
        label954:
        paramRspSystemMsgNew = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        localObject1 = paramRspSystemMsgNew.a(AppConstants.V, 4000);
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
            ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(31)).b();
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
        label1254:
        paramToServiceMsg = paramFromServiceMsg;
      }
    }
  }
  
  private void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      if (QLog.isColorLevel()) {
        QLog.d("SystemMessageProcessor", 2, "refreshRecentData, mDataList is null !");
      }
    }
    RecentUserProxy localRecentUserProxy;
    do
    {
      return;
      localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    } while ((paramList == null) || (paramList.size() <= 0) || (localRecentUserProxy.a(AppConstants.V, 4000)));
    RecentUser localRecentUser = localRecentUserProxy.a(AppConstants.V, 4000);
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
      ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(31)).b();
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
          int k;
          int j;
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
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.bD = 0;
    paramFromServiceMsg = paramObject.msgs.get();
    k = paramFromServiceMsg.size();
    if (QLog.isColorLevel()) {
      QLog.e("SystemMessageProcessor", 2, "<---handleGetNextOldSystemMsgResp : decode pb size = " + k);
    }
    j = 0;
    while (j < k)
    {
      localObject2 = MessageRecordFactory.a(-2018);
      ((MessageRecord)localObject2).msgtype = -2018;
      ((MessageRecord)localObject2).selfuin = str;
      ((MessageRecord)localObject2).frienduin = AppConstants.Y;
      ((MessageRecord)localObject2).senderuin = AppConstants.Y;
      ((MessageRecord)localObject2).istroop = 0;
      MessageForSystemMsg localMessageForSystemMsg = (MessageForSystemMsg)localObject2;
      localMessageForSystemMsg.structMsg = ((structmsg.StructMsg)((structmsg.StructMsg)paramFromServiceMsg.get(j)).get());
      ((MessageRecord)localObject2).msgData = localMessageForSystemMsg.structMsg.toByteArray();
      paramToServiceMsg.add(localMessageForSystemMsg);
      j += 1;
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
    int m = paramToServiceMsg.extraData.getInt("getSystemMsgSender");
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("SystemMessageProcessor", 2, "processGroupSystemMsg-->requestFrom:" + m);
    }
    String str;
    if (paramFromServiceMsg.getUin() == null)
    {
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      if ((!GroupSystemMsgController.a().b(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler)) || (m == 1)) {
        break label107;
      }
    }
    label107:
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
            int n;
            int i1;
            int k;
            Object localObject1;
            boolean bool;
            paramObject = null;
            continue;
            long l2 = -1L;
          }
        }
        paramRspSystemMsgNew = paramObject;
        if (QLog.isColorLevel())
        {
          QLog.e("SystemMessageProcessor", 2, "<---handleGetGroupSystemMsgResp : decode pb error:", localException1);
          paramRspSystemMsgNew = paramObject;
        }
      }
      paramToServiceMsg = paramRspSystemMsgNew.groupmsgs.get();
      n = paramToServiceMsg.size();
      i1 = paramRspSystemMsgNew.unread_group_count.get();
      k = GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d("SystemMessageProcessor", 2, "<---handleGetGroupSystemMsgResp : decode pb groupMsgsSize = " + n + " latest_friend_seq" + paramRspSystemMsgNew.latest_friend_seq.get() + " latest_group_seq" + paramRspSystemMsgNew.latest_group_seq.get() + " following_friend_seq" + paramRspSystemMsgNew.following_friend_seq.get() + " following_group_seq" + paramRspSystemMsgNew.following_group_seq.get() + " unreadCount" + i1 + " localUnreadCount" + k);
      }
    } while (n == 0);
    this.d = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_group_seq", paramRspSystemMsgNew.latest_group_seq.get());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("following_group_seq", paramRspSystemMsgNew.following_group_seq.get());
    GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i1);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(AppConstants.aj, 9000, i1 - k);
    paramFromServiceMsg = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.ae, 0, true, false);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.ah, 0, true, false);
    GroupSystemMsgController.a().a(true);
    GroupSystemMsgController.a().a(false, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Collections.sort(paramToServiceMsg, new dah(this));
    k = 0;
    while (k < n)
    {
      paramObject = MessageRecordFactory.a(-2018);
      paramObject.msgtype = -2018;
      paramObject.selfuin = str;
      paramObject.frienduin = AppConstants.ae;
      paramObject.senderuin = (((structmsg.StructMsg)paramToServiceMsg.get(k)).req_uin.get() + "");
      paramObject.istroop = 0;
      localObject1 = (MessageForSystemMsg)paramObject;
      ((MessageForSystemMsg)localObject1).structMsg = ((structmsg.StructMsg)((structmsg.StructMsg)paramToServiceMsg.get(k)).get());
      int i3 = ((MessageForSystemMsg)localObject1).structMsg.msg_type.get();
      int i2 = ((MessageForSystemMsg)localObject1).structMsg.msg.sub_type.get();
      if ((i3 == 1) && (!SystemMsgUtils.a(i2)))
      {
        k += 1;
      }
      else
      {
        i3 = ((structmsg.StructMsg)paramToServiceMsg.get(k)).msg.group_msg_type.get();
        if ((i3 == 2) && (i2 == 2) && (a(String.valueOf(((structmsg.StructMsg)paramToServiceMsg.get(k)).msg.group_code.get()), ((structmsg.StructMsg)paramToServiceMsg.get(k)).msg_seq.get())) && (TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((structmsg.StructMsg)paramToServiceMsg.get(k)).msg.group_code.get(), String.valueOf(((structmsg.StructMsg)paramToServiceMsg.get(k)).msg.action_uin.get()))))
        {
          if (QLog.isColorLevel()) {
            QLog.d("SystemMessageProcessor", 2, "processGroupSystemMsg-->msgPos:" + k + ":addFriendTipsMr");
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((structmsg.StructMsg)paramToServiceMsg.get(k)).msg.group_code.get() + "", 1, -1L, 10004, true);
        }
        if (i2 == 1) {
          paramObject.senderuin = (((structmsg.StructMsg)paramToServiceMsg.get(k)).msg.action_uin.get() + "");
        }
        if ((m != 1) || (j != 0)) {
          break label1986;
        }
        Object localObject2;
        Object localObject3;
        if (i3 == 3)
        {
          localObject2 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(44);
          localObject3 = ((TroopManager)localObject2).a(((structmsg.StructMsg)paramToServiceMsg.get(k)).msg.group_code.get() + "");
          if (localObject3 != null)
          {
            ((TroopInfo)localObject3).dwCmdUinUinFlag = 1L;
            ((TroopManager)localObject2).b((TroopInfo)localObject3);
          }
        }
        for (;;)
        {
          if ((i3 == 13) || (i3 == 6) || (i3 == 7))
          {
            if (QLog.isColorLevel()) {
              QLog.d("SystemMessageProcessor", 2, "processGroupSystemMsg-->msgPos:" + k + ",msgTime:" + ((structmsg.StructMsg)paramToServiceMsg.get(k)).msg_time + ",msgType:" + i3 + ":delete troopMember, delete troop, clear local history");
            }
            localObject2 = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
            if (localObject2 != null)
            {
              localObject3 = ((structmsg.StructMsg)paramToServiceMsg.get(k)).msg.group_code.get() + "";
              ((FriendsManagerImp)localObject2).a((String)localObject3, ((structmsg.StructMsg)paramToServiceMsg.get(k)).req_uin.get() + "");
              if (i3 == 7)
              {
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject3, 1);
                ((FriendsManagerImp)localObject2).e((String)localObject3);
                DBUtils.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject3, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
              }
            }
          }
          j = 1;
          paramObject.msgData = ((MessageForSystemMsg)localObject1).structMsg.toByteArray();
          paramFromServiceMsg.add(localObject1);
          break;
          if (i3 == 15)
          {
            localObject2 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(44);
            localObject3 = ((TroopManager)localObject2).a(((structmsg.StructMsg)paramToServiceMsg.get(k)).msg.group_code.get() + "");
            if (localObject3 != null)
            {
              ((TroopInfo)localObject3).dwCmdUinUinFlag = 0L;
              ((TroopManager)localObject2).b((TroopInfo)localObject3);
            }
          }
        }
      }
    }
    if (paramFromServiceMsg.size() > 0)
    {
      paramObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      localObject1 = String.valueOf(str);
      if ((!MessageHandlerUtils.a(paramFromServiceMsg)) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause)) {
        break label1965;
      }
    }
    label1965:
    for (bool = true;; bool = false)
    {
      paramObject.a(paramFromServiceMsg, (String)localObject1, bool);
      a("handleGetSystemMsgResp", true, i1, false, false);
      if ((paramRspSystemMsgNew.msg_ribbon_group.has()) && (paramRspSystemMsgNew.msg_ribbon_group.get() != null))
      {
        paramRspSystemMsgNew = (structmsg.StructMsg)paramRspSystemMsgNew.msg_ribbon_group.get();
        paramObject = MessageRecordFactory.a(-2018);
        paramObject.selfuin = str;
        paramObject.frienduin = AppConstants.ah;
        paramObject.senderuin = (paramRspSystemMsgNew.req_uin.get() + "");
        paramObject.istroop = 0;
        localObject1 = (MessageForSystemMsg)paramObject;
        ((MessageForSystemMsg)localObject1).structMsg = paramRspSystemMsgNew;
        paramObject.msgData = ((MessageForSystemMsg)localObject1).structMsg.toByteArray();
        paramRspSystemMsgNew = new ArrayList();
        paramRspSystemMsgNew.add(paramObject);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramRspSystemMsgNew, String.valueOf(str), true);
        if (QLog.isColorLevel()) {
          QLog.d("Q.systemmsg.", 2, "ribbon info");
        }
      }
      GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramObject = (RecentManagerFor3rdPart)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(30);
      paramFromServiceMsg = ((MessageForSystemMsg)paramFromServiceMsg.get(0)).getSystemMsg();
      GroupSystemMsgController.a().a(paramFromServiceMsg);
      long l1 = paramFromServiceMsg.msg_time.get();
      paramObject.a(AppConstants.aj, 9000, "群通知", l1, l1);
      paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(Conversation.class);
      if (paramFromServiceMsg != null) {
        paramFromServiceMsg.sendMessage(paramFromServiceMsg.obtainMessage(1009));
      }
      paramToServiceMsg = (structmsg.StructMsg)paramToServiceMsg.get(0);
      j = -1;
      l1 = -1L;
      if (paramToServiceMsg.msg.has())
      {
        if (((structmsg.SystemMsg)paramToServiceMsg.msg.get()).group_msg_type.has()) {
          j = ((structmsg.SystemMsg)paramToServiceMsg.msg.get()).group_msg_type.get();
        }
        if (((structmsg.SystemMsg)paramToServiceMsg.msg.get()).group_code.has()) {
          l1 = ((structmsg.SystemMsg)paramToServiceMsg.msg.get()).group_code.get();
        }
        if (!paramToServiceMsg.req_uin.has()) {
          break;
        }
        l2 = paramToServiceMsg.req_uin.get();
        if ((j == -1) || (l2 == -1L) || (l1 == -1L)) {}
      }
      a(4005, true, null);
      this.jdField_a_of_type_JavaUtilMap.clear();
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
                  int k;
                  int m;
                  int j;
                  boolean bool1;
                  int n;
                  int i1;
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
          k = paramFromServiceMsg.size();
          if (QLog.isColorLevel()) {
            QLog.e("SystemMessageProcessor", 2, "<---handleGetSystemMsgResp : decode pb size = " + k + " unreadNum = " + ((structmsg.RspSystemMsg)localObject).unread_count.get() + " tabDispaly" + Utils.a(((structmsg.RspSystemMsg)localObject).msg_display.get()) + " latest_friend_seq" + ((structmsg.RspSystemMsg)localObject).latest_friend_seq.get() + " latest_group_seq" + ((structmsg.RspSystemMsg)localObject).latest_group_seq.get() + " following_friend_seq" + ((structmsg.RspSystemMsg)localObject).following_friend_seq.get() + " following_group_seq" + ((structmsg.RspSystemMsg)localObject).following_group_seq.get());
          }
          m = ((structmsg.RspSystemMsg)localObject).unread_count.get();
          j = SystemMsgController.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          this.d = 0;
          if (!SystemMsgController.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
            break label418;
          }
          if (m > 0) {
            break label407;
          }
        } while (k <= 0);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((structmsg.RspSystemMsg)localObject).latest_friend_seq.get(), ((structmsg.RspSystemMsg)localObject).latest_group_seq.get());
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((structmsg.RspSystemMsg)localObject).following_friend_seq.get(), ((structmsg.RspSystemMsg)localObject).following_group_seq.get());
        return;
        SystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
        if (k != 0) {
          break label466;
        }
      } while (j == m);
      SystemMsgController.a().c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, m);
      paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(Conversation.class);
    } while (paramToServiceMsg == null);
    label407:
    label418:
    paramToServiceMsg.sendEmptyMessage(1009);
    return;
    label466:
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((structmsg.RspSystemMsg)localObject).latest_friend_seq.get(), ((structmsg.RspSystemMsg)localObject).latest_group_seq.get());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((structmsg.RspSystemMsg)localObject).following_friend_seq.get(), ((structmsg.RspSystemMsg)localObject).following_group_seq.get());
    SystemMsgController.a().c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, m);
    bool1 = false;
    if (m > j) {
      bool1 = true;
    }
    paramToServiceMsg = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.Y, 0, true, false);
    SystemMsgController.a().a(true);
    SystemMsgController.a().a(false, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    SystemMsgController.a().a(((structmsg.RspSystemMsg)localObject).msg_display.get(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    j = 0;
    if (j < k)
    {
      paramObject = MessageRecordFactory.a(-2018);
      paramObject.msgtype = -2018;
      paramObject.selfuin = str;
      paramObject.frienduin = AppConstants.Y;
      paramObject.senderuin = (((structmsg.StructMsg)paramFromServiceMsg.get(j)).req_uin.get() + "");
      paramObject.istroop = 0;
      localObject = (MessageForSystemMsg)paramObject;
      ((MessageForSystemMsg)localObject).structMsg = ((structmsg.StructMsg)((structmsg.StructMsg)paramFromServiceMsg.get(j)).get());
      n = ((MessageForSystemMsg)localObject).structMsg.msg_type.get();
      i1 = ((MessageForSystemMsg)localObject).structMsg.msg.sub_type.get();
      if ((n == 1) && (!SystemMsgUtils.a(i1))) {}
      for (;;)
      {
        j += 1;
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
      a("handleGetSystemMsgResp", true, m, bool1, false);
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
    int j = paramToServiceMsg.extraData.getInt("type");
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
        int k = paramToServiceMsg.head.result.get();
        if (k == 0) {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l3);
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SystemMessageProcessor", 2, "handleSendSystemMsgReadedReport type =" + j + ";reqSeq=" + l3 + ";resultCode=" + k + ";latestFriendSeq=" + l1 + ";latestGroupSeq=" + l2);
        return;
      }
      catch (Exception paramFromServiceMsg)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("SystemMessageProcessor", 2, "<---handleSendSystemMsgReadedReport :type = " + j + " decode pb:", paramFromServiceMsg);
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
        int j;
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
        j = -1;
        if (paramFromServiceMsg.remark_result.has()) {
          j = paramFromServiceMsg.remark_result.get();
        }
        paramToServiceMsg.extraData.putString("system_msg_action_resp_key", paramObject);
        paramToServiceMsg.extraData.putInt("system_msg_action_resp_result_code_key", paramFromServiceMsg.head.result.get());
        paramToServiceMsg.extraData.putInt("system_msg_action_resp_type_key", paramFromServiceMsg.type.get());
        paramToServiceMsg.extraData.putString("system_msg_action_resp_invalid_decided_key", paramFromServiceMsg.msg_invalid_decided.get());
        paramToServiceMsg.extraData.putInt("system_msg_action_resp_remark_result_key", j);
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
    a(true, true, false, 0L, new dal(this, l1, l2, localReqSystemMsgRead));
  }
  
  public void a(int paramInt)
  {
    a(paramInt, 0);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (!MessageHandler.c)
    {
      a(false);
      return;
    }
    Object localObject1 = "ProfileService.Pb.ReqSystemMsgNew";
    Object localObject2 = null;
    int j;
    boolean bool;
    switch (paramInt1)
    {
    default: 
      j = 0;
      bool = false;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.systemmsg.", 2, "<---sendGetSystemMsg type=" + paramInt1 + "isHold = " + bool + " latest_friend_seq = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_friend_seq_47") + " latest_group_seq = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_group_seq"));
      }
      if (bool) {
        break;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a((String)localObject1);
      structmsg.ReqSystemMsgNew localReqSystemMsgNew = new structmsg.ReqSystemMsgNew();
      localReqSystemMsgNew.msg_num.set(10);
      localReqSystemMsgNew.checktype.set(j);
      localReqSystemMsgNew.latest_friend_seq.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_friend_seq_47"));
      localReqSystemMsgNew.latest_group_seq.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_group_seq"));
      if (localObject2 != null) {
        localReqSystemMsgNew.flag.set((MessageMicro)localObject2);
      }
      localReqSystemMsgNew.is_get_frd_ribbon.set(false);
      localReqSystemMsgNew.version.set(1000);
      localReqSystemMsgNew.is_get_grp_ribbon.set(false);
      ((ToServiceMsg)localObject1).extraData.putInt("getSystemMsgSender", paramInt2);
      ((ToServiceMsg)localObject1).putWupBuffer(localReqSystemMsgNew.toByteArray());
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b((ToServiceMsg)localObject1);
      return;
      if ((FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler)) && (GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler))) {}
      for (bool = true;; bool = false)
      {
        localObject2 = new structmsg.FlagInfo();
        ((structmsg.FlagInfo)localObject2).GrpMsg_Kick_Admin.set(1);
        ((structmsg.FlagInfo)localObject2).GrpMsg_HiddenGrp.set(1);
        j = 4;
        localObject1 = "ProfileService.Pb.ReqSystemMsgNew";
        break;
      }
      bool = FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler);
      localObject1 = "ProfileService.Pb.ReqSystemMsgNew.Friend";
      j = 2;
      continue;
      bool = GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler);
      localObject2 = new structmsg.FlagInfo();
      ((structmsg.FlagInfo)localObject2).GrpMsg_Kick_Admin.set(1);
      ((structmsg.FlagInfo)localObject2).GrpMsg_HiddenGrp.set(1);
      j = 3;
      localObject1 = "ProfileService.Pb.ReqSystemMsgNew.Group";
    }
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, structmsg.SystemMsgActionInfo paramSystemMsgActionInfo, int paramInt6)
  {
    a(paramInt1, paramLong1, paramLong2, paramInt2, paramInt3, paramInt4, paramInt5, paramSystemMsgActionInfo, paramInt6, null, false);
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, structmsg.SystemMsgActionInfo paramSystemMsgActionInfo, int paramInt6, structmsg.StructMsg paramStructMsg, boolean paramBoolean)
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
    ProtoReqManager.ProtoReq localProtoReq = new ProtoReqManager.ProtoReq();
    localProtoReq.a();
    localProtoReq.jdField_a_of_type_JavaLangString = "ProfileService.Pb.ReqSystemMsgAction.Friend";
    localProtoReq.jdField_a_of_type_ArrayOfByte = ((structmsg.ReqSystemMsgAction)localObject).toByteArray();
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a("ProfileService.Pb.ReqSystemMsgAction.Friend");
    ((ToServiceMsg)localObject).addAttribute("_tag_LOGSTR", String.valueOf(l));
    ((ToServiceMsg)localObject).extraData.putInt("system_msg_action_type", paramInt6);
    ((ToServiceMsg)localObject).extraData.putBoolean("isUncommonlyUsedFrd", paramBoolean);
    localProtoReq.jdField_a_of_type_JavaLangObject = localObject;
    localProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack = new dak(this, paramInt6, paramInt3, paramSystemMsgActionInfo, paramStructMsg, paramLong2);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localProtoReq);
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
      this.d = 0;
      return;
    case 6001: 
      this.e = 0;
      return;
    case 6003: 
      this.f = 0;
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
        ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(17)).a(localTroopInfo1.troopuin, (byte)1, localTroopInfo1.dwTimeStamp, 0);
      }
      if (QLog.isColorLevel()) {
        QLog.d("SystemMessageProcessor", 2, "handleTroopSystemMessageResp-->msgTime:" + paramLong3 + ":addFriendTipsMr");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(localTroopInfo1.troopuin, 1, paramLong3, 10004, true);
      b(2001, true, null);
    }
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    String str = String.valueOf(paramLong2);
    Object localObject = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    FriendListHandler localFriendListHandler = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
    if ((paramInt1 == 188) || (paramInt1 == 189))
    {
      bool2 = ((FriendsManagerImp)localObject).b(String.valueOf(str));
      localObject = String.valueOf(str);
      if (paramLong1 == paramLong2)
      {
        bool1 = true;
        localFriendListHandler.a((String)localObject, 0, 10004, null, bool1, false);
        if (!bool2) {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(str, 0, -1L, 10004, true);
        }
      }
    }
    while (paramInt1 != 190) {
      for (;;)
      {
        boolean bool2;
        return;
        boolean bool1 = false;
      }
    }
    ((FriendsManagerImp)localObject).a(str, false);
  }
  
  public void a(long paramLong1, long paramLong2, short paramShort, int paramInt, msg_comm.Msg paramMsg)
  {
    String str = String.valueOf(paramLong2);
    FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    FriendListHandler localFriendListHandler = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
    if ((paramShort == 188) || (paramShort == 189))
    {
      paramMsg = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
      paramMsg = SystemMsg.decode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, HexUtil.a(paramMsg), String.valueOf(str), paramInt).strGameName;
      bool = localFriendsManagerImp.b(String.valueOf(str));
      localFriendListHandler.a(String.valueOf(str), 0, 10004, paramMsg, true, false);
      if (!bool) {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(str, 0, -1L, 10004, true, paramMsg, true);
      }
    }
    while (paramShort != 190)
    {
      boolean bool;
      return;
    }
    localFriendsManagerImp.a(str, false);
  }
  
  public void a(String paramString, long paramLong, boolean paramBoolean)
  {
    paramString = paramString + "_" + paramLong;
    this.jdField_a_of_type_JavaUtilMap.put(paramString, Boolean.valueOf(paramBoolean));
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
    localToServiceMsg.putWupBuffer(localReqSystemMsg.toByteArray());
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(localToServiceMsg);
  }
  
  public boolean a(String paramString, long paramLong)
  {
    paramString = paramString + "_" + (1L + paramLong);
    if ((this.jdField_a_of_type_JavaUtilMap != null) && (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))) {
      return ((Boolean)this.jdField_a_of_type_JavaUtilMap.remove(paramString)).booleanValue();
    }
    return false;
  }
  
  public void b()
  {
    int j = MobileQQService.c;
    MobileQQService.c = j + 1;
    long l1 = j;
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
    localProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack = new dam(this, l1, l2, l3);
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
    paramSystemMsgActionInfo = new ProtoReqManager.ProtoReq();
    paramSystemMsgActionInfo.a();
    paramSystemMsgActionInfo.jdField_a_of_type_JavaLangString = "ProfileService.Pb.ReqSystemMsgAction.Group";
    paramSystemMsgActionInfo.jdField_a_of_type_ArrayOfByte = ((structmsg.ReqSystemMsgAction)localObject).toByteArray();
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a("ProfileService.Pb.ReqSystemMsgAction.Group");
    ((ToServiceMsg)localObject).addAttribute("_tag_LOGSTR", String.valueOf(l));
    ((ToServiceMsg)localObject).extraData.putInt("system_msg_action_type", paramInt6);
    paramSystemMsgActionInfo.jdField_a_of_type_JavaLangObject = localObject;
    paramSystemMsgActionInfo.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack = new daj(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramSystemMsgActionInfo);
  }
  
  public void b(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 6002: 
    case 6005: 
      if (this.d < 2)
      {
        this.d += 1;
        a(4);
        return;
      }
      this.d = 0;
      return;
    case 6001: 
      if (this.e < 2)
      {
        this.e += 1;
        a(2);
        return;
      }
      this.e = 0;
      return;
    case 6003: 
      if (this.f < 2)
      {
        this.f += 1;
        a(3);
        return;
      }
      this.f = 0;
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
    int j = MobileQQService.c;
    MobileQQService.c = j + 1;
    long l1 = j;
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
    localProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack = new dan(this, l1, l2, l3);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localProtoReq);
  }
  
  public void d()
  {
    int j = MobileQQService.c;
    MobileQQService.c = j + 1;
    long l1 = j;
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
    localProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack = new dao(this, l1, l2, l3);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localProtoReq);
  }
  
  public void e()
  {
    int j = MobileQQService.c;
    MobileQQService.c = j + 1;
    long l1 = j;
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
    localProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack = new dap(this, l1, l2, l3);
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
    a(true, true, false, 0L, new daq(this, l1, l2, localReqSystemMsgRead));
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
    localToServiceMsg.putWupBuffer(localReqNextSystemMsg.toByteArray());
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(localToServiceMsg);
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
    ProtoReqManager.ProtoReq localProtoReq = new ProtoReqManager.ProtoReq();
    localProtoReq.a();
    localProtoReq.jdField_a_of_type_JavaLangString = "ProfileService.Pb.ReqNextSystemMsg.Friend";
    localProtoReq.jdField_a_of_type_ArrayOfByte = localReqNextSystemMsg.toByteArray();
    localProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack = new dar(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localProtoReq);
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
    localObject = new ProtoReqManager.ProtoReq();
    ((ProtoReqManager.ProtoReq)localObject).a();
    ((ProtoReqManager.ProtoReq)localObject).jdField_a_of_type_JavaLangString = "ProfileService.Pb.ReqNextSystemMsg.Group";
    ((ProtoReqManager.ProtoReq)localObject).jdField_a_of_type_ArrayOfByte = localReqNextSystemMsg.toByteArray();
    ((ProtoReqManager.ProtoReq)localObject).jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack = new dai(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((ProtoReqManager.ProtoReq)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.SystemMessageProcessor
 * JD-Core Version:    0.7.0.1
 */