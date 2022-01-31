package com.tencent.mobileqq.app.message;

import IMMsgBodyPack.MsgType0x210;
import IMMsgBodyPack.MsgType0x210SubMsgType0x24;
import OnlinePushPack.DelMsgInfo;
import OnlinePushPack.MsgInfo;
import OnlinePushPack.SvcReqPushMsg;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.TroopRedpoint.TroopRedTouchHandler;
import com.tencent.biz.common.offline.OfflineExpire;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.qwallet.QWalletPushManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQProfileItem;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.SafeCenterPushHandler;
import com.tencent.mobileqq.app.ShieldListHandler;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.GroupActionResp;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.MessageForEnterTroop;
import com.tencent.mobileqq.data.MessageForEnterTroop.User;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.service.config.ConfigUtil;
import com.tencent.mobileqq.service.gamecenter.GameCenterPackeger;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.service.message.PBDecodeContext;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.systemmsg.SystemMsgController;
import com.tencent.mobileqq.systemmsg.SystemMsgUtils;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopTipsMsgMgr;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.msf.service.protocol.pb.SubMsgType0x51.MsgBody;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import czb;
import czc;
import friendlist.AddGroupResp;
import friendlist.DelGroupResp;
import friendlist.RenameGroupResp;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import localpb.richMsg.SafeMsg.SafeMoreInfo;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgType0x210;
import protocol.KQQConfig.GetResourceReqInfo;
import tencent.im.group.cmd0x2dc.GroupVisitorJoinMsg;
import tencent.im.group.cmd0x2dc.VisitorJoinInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.MsgBody.SubCmd0x3UpdateDiscussAppInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.AddGroup;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.DaRenNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.DelFriend;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.DelGroup;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ForwardBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.FriendGroup;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.FriendRemark;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.GroupMemberProfileInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.GroupProfileInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.GroupSort;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModCustomFace;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModFriendGroup;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModFriendRemark;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModGroupMemberProfile;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModGroupName;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModGroupProfile;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModGroupSort;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModLongNick;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModProfile;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModSnsGeneralInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ProfileInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.SnsUpateBuffer;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.SnsUpdateFlag;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.SnsUpdateItem;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.SnsUpdateOneFlag;
import tencent.im.s2c.msgtype0x210.submsgtype0x35.Submsgtype0x35.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x3b.Submsgtype0x3b.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.ClearCountMsg;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.FriendSyncMsg;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.GroupSyncMsg;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x48.RecommendDeviceLock;
import tencent.im.s2c.msgtype0x210.submsgtype0x54.submsgtype0x54.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x54.submsgtype0x54.MsgBody.TaskInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x67.submsgtype0x67.MsgBody;

public class OnLinePushMessageProcessor
  extends BaseMessageProcessor
{
  public czb a;
  
  public OnLinePushMessageProcessor(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
    this.jdField_a_of_type_Czb = new czb(this, null);
  }
  
  private MessageRecord a(MsgInfo paramMsgInfo, long paramLong)
  {
    paramMsgInfo = paramMsgInfo.vMsg;
    PkgTools.a(paramMsgInfo, 0);
    int i = paramMsgInfo[4];
    PkgTools.a(paramMsgInfo, 5);
    PkgTools.a(paramMsgInfo, 9);
    PkgTools.a(paramMsgInfo, 13);
    i = paramMsgInfo[17];
    PkgTools.a(paramMsgInfo, 18);
    PkgTools.a(paramMsgInfo, 22);
    PkgTools.a(paramMsgInfo, 24);
    return null;
  }
  
  private void a(int paramInt)
  {
    ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12)).a(paramInt);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcReqPushMsg paramSvcReqPushMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "handleC2COnlinePushMsgResp");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.ao = paramSvcReqPushMsg.wUserActive;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "OnlinePush.ReqPush,notify.wUserActive:" + paramSvcReqPushMsg.wUserActive);
    }
    String str = (String)paramFromServiceMsg.getAttribute("_tag_LOGSTR");
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = paramSvcReqPushMsg.vMsgInfos;
    ArrayList localArrayList3;
    long l3;
    int m;
    ArrayList localArrayList4;
    MsgInfo localMsgInfo;
    if ((localArrayList2 != null) && (localArrayList2.size() > 0))
    {
      localArrayList3 = new ArrayList();
      BaseApplication.getContext().getSharedPreferences("share", 0);
      l3 = paramSvcReqPushMsg.lUin;
      m = paramSvcReqPushMsg.svrip;
      localArrayList4 = new ArrayList();
      Iterator localIterator = localArrayList2.iterator();
      if (localIterator.hasNext()) {
        localMsgInfo = (MsgInfo)localIterator.next();
      }
    }
    for (;;)
    {
      int k;
      long l2;
      long l1;
      long l4;
      label488:
      Object localObject2;
      try
      {
        j = localMsgInfo.shMsgType;
        k = -1000;
        localObject1 = null;
        l2 = localMsgInfo.lFromUin;
        l1 = localMsgInfo.lFromUin;
        if (paramFromServiceMsg.getUin() != null) {
          continue;
        }
        paramToServiceMsg = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        l4 = paramToServiceMsg.longValue();
        paramToServiceMsg = new DelMsgInfo();
        ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(localMsgInfo.lFromUin);
        paramToServiceMsg.lFromUin = localMsgInfo.lFromUin;
        paramToServiceMsg.shMsgSeq = localMsgInfo.shMsgSeq;
        paramToServiceMsg.uMsgTime = localMsgInfo.uMsgTime;
        paramToServiceMsg.vMsgCookies = localMsgInfo.vMsgCookies;
        localArrayList3.add(paramToServiceMsg);
        if ((42 != j) && (83 != j) && (127 != j) && (QLog.isColorLevel())) {
          MessageHandlerUtils.a("Q.msg.BaseMessageProcessor", str, localMsgInfo.shMsgSeq, String.valueOf(l3), String.valueOf(localMsgInfo.lFromUin));
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "----------handleC2COnlinePushMsgResp  before analysis msgInfo.lFromUin: " + localMsgInfo.lFromUin + " msgInfo.shMsgType: " + localMsgInfo.shMsgType + " msgInfo.uRealMsgTime: " + localMsgInfo.uRealMsgTime + " msgInfo.shMsgSeq: " + localMsgInfo.shMsgSeq + ", msgInfo.lMsgUid" + localMsgInfo.lMsgUid);
        }
        if (!OnLinePushMsgTypeProcessorDispatcher.a().containsKey(Integer.valueOf(j))) {
          continue;
        }
        paramToServiceMsg = b(j, localMsgInfo, paramSvcReqPushMsg);
        if (paramToServiceMsg == null) {
          break label2119;
        }
        if (paramToServiceMsg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
          localArrayList1.add(paramToServiceMsg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
        }
        if (paramToServiceMsg.jdField_a_of_type_Boolean) {
          break;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        if ((localMsgInfo.vMsg == null) || (!QLog.isColorLevel())) {
          continue;
        }
        QLog.w("Q.msg.BaseMessageProcessor", 2, "~~~~~handleC2COnlinePushMsgResp Exception msgInfo.vMsg: " + HexUtil.a(localMsgInfo.vMsg));
        continue;
      }
      if (paramToServiceMsg != null)
      {
        localObject2 = MessageRecordFactory.a(k);
        ((MessageRecord)localObject2).init(l3, l1, l2, paramToServiceMsg, localMsgInfo.uRealMsgTime, k, i, localMsgInfo.uMsgTime);
        ((MessageRecord)localObject2).shmsgseq = localMsgInfo.shMsgSeq;
        ((MessageRecord)localObject2).isread = bool1;
        ((MessageRecord)localObject2).msgUid = localMsgInfo.lMsgUid;
        ((MessageRecord)localObject2).msgData = ((byte[])localObject1);
        if (j > 0) {
          ((MessageRecord)localObject2).extraflag = j;
        }
        if (!MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject2, true)) {
          localArrayList1.add(localObject2);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "----------handleC2COnlinePushMsgResp after analysis friendUin: " + l1 + " msgType: " + k + " friendType: " + i + " shMsgSeq: " + localMsgInfo.shMsgSeq + " msgContent: " + Utils.a(paramToServiceMsg));
        }
      }
      if (localMsgInfo.uAppShareID <= 0L) {
        break;
      }
      localArrayList4.add(AppShareIDUtil.a(localMsgInfo.uAppShareID));
      break;
      paramToServiceMsg = Long.valueOf(paramFromServiceMsg.getUin());
      continue;
      if (169 == j)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "------->msgFilter-handleC2COnlinePushMsgResp receive msg size:" + localArrayList2.size());
        }
        if (MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, String.valueOf(l1), String.valueOf(l2), localMsgInfo.uMsgTime, localMsgInfo.shMsgSeq)) {
          break;
        }
        localArrayList3.remove(paramToServiceMsg);
        paramToServiceMsg = new String(localMsgInfo.vMsg) + localMsgInfo.uMsgTime;
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramToServiceMsg))
        {
          paramToServiceMsg = new long[1];
          paramToServiceMsg[0] = localMsgInfo.lFromUin;
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "---->handleC2COnlinePushMsgResp, new file msg, about to call handleOffLineFileResp");
          }
          a(String.valueOf(l1), l3, paramToServiceMsg, localMsgInfo.vMsg, localMsgInfo.uMsgTime, localMsgInfo.shMsgSeq, false);
          localMsgInfo.lFromUin = paramToServiceMsg[0];
          break;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.msg.BaseMessageProcessor", 2, "rcv a repeated offline file push msg");
        break;
      }
      if (8 == j)
      {
        paramToServiceMsg = new byte[4];
        if (localMsgInfo.vMsg.length > 4) {
          PkgTools.a(paramToServiceMsg, 0, localMsgInfo.vMsg, 0, 4);
        }
        l2 = PkgTools.a(paramToServiceMsg, 0);
        if (localMsgInfo.vMsg.length >= 9)
        {
          paramToServiceMsg = new byte[localMsgInfo.vMsg.length - 9];
          PkgTools.a(paramToServiceMsg, 0, localMsgInfo.vMsg, 8, paramToServiceMsg.length);
          paramToServiceMsg = new String(MessageUtils.b(paramToServiceMsg), "utf-8");
          break label2136;
        }
      }
      else
      {
        if (132 == j)
        {
          paramToServiceMsg = new byte[4];
          if (localMsgInfo.vMsg.length > 4) {
            PkgTools.a(paramToServiceMsg, 0, localMsgInfo.vMsg, 0, 4);
          }
          l2 = PkgTools.a(paramToServiceMsg, 0);
          paramToServiceMsg = (ToServiceMsg)localObject1;
          if (localMsgInfo.vMsg.length < 9) {
            break label2158;
          }
          paramToServiceMsg = new byte[localMsgInfo.vMsg.length - 9];
          PkgTools.a(paramToServiceMsg, 0, localMsgInfo.vMsg, 8, paramToServiceMsg.length);
          paramToServiceMsg = new String(MessageUtils.b(paramToServiceMsg), "utf-8");
          break label2158;
        }
        if (732 == j)
        {
          if (localMsgInfo.vMsg == null) {
            return;
          }
          paramToServiceMsg = new byte[localMsgInfo.vMsg.length];
          PkgTools.a(paramToServiceMsg, 0, localMsgInfo.vMsg, 0, paramToServiceMsg.length);
          i = paramToServiceMsg[4];
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "<---0x2dc push  groupCode:" + PkgTools.a(localMsgInfo.vMsg, 0) + " subType:" + i + "msgSeq:" + localMsgInfo.shMsgSeq);
          }
          if ((i != 16) || (localMsgInfo.vMsg.length <= 7)) {
            break label2181;
          }
          localObject1 = (TroopTipsMsgMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
          localObject2 = new byte[localMsgInfo.vMsg.length - 7];
          PkgTools.a((byte[])localObject2, 0, localMsgInfo.vMsg, 7, localObject2.length);
          ((TroopTipsMsgMgr)localObject1).a((byte[])localObject2, localMsgInfo.shMsgSeq, localMsgInfo.uRealMsgTime, false);
          break label2181;
          label1373:
          if (((TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42)).a(paramToServiceMsg, localMsgInfo.shMsgSeq)) {
            break label2180;
          }
          break label2198;
          label1400:
          if (i == 15)
          {
            a(paramToServiceMsg, localMsgInfo.shMsgSeq);
            return;
          }
          if (i != 6) {
            break label2215;
          }
          c(paramToServiceMsg);
          break label2198;
          label1434:
          if (localMsgInfo.vMsg.length <= 7) {
            break label2198;
          }
          paramToServiceMsg = new byte[localMsgInfo.vMsg.length - 7];
          PkgTools.a(paramToServiceMsg, 0, localMsgInfo.vMsg, 7, paramToServiceMsg.length);
          a(paramToServiceMsg, i);
          break label2198;
        }
        if (230 == j)
        {
          paramToServiceMsg = new String(MessageUtils.b(localMsgInfo.vMsg), "utf-8");
          localObject1 = ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).c(l1 + "");
          if ((localObject1 == null) || (!((Friends)localObject1).isFriend())) {
            break label2232;
          }
          i = 0;
          label1564:
          localObject1 = new SafeMsg.SafeMoreInfo();
          ((SafeMsg.SafeMoreInfo)localObject1).strFromMobile.set(localMsgInfo.strFromMobile);
          ((SafeMsg.SafeMoreInfo)localObject1).strFromName.set(localMsgInfo.strFromName);
          ((SafeMsg.SafeMoreInfo)localObject1).strMsgTxt.set(paramToServiceMsg);
          localObject1 = ((SafeMsg.SafeMoreInfo)localObject1).toByteArray();
          k = -1002;
          bool1 = true;
          j = -1;
          continue;
        }
        if (SystemMsg.isSystemMessage(j))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(2);
          k = -1006 - (j - 187);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(l3, localMsgInfo.lFromUin, j, k);
          FriendSystemMsgController.a().a(l2, localMsgInfo.uMsgTime, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          l1 = 9998L;
          localObject1 = null;
          paramToServiceMsg = null;
          j = -1;
          bool1 = false;
          i = 0;
          continue;
        }
        if (SystemMsg.isTroopSystemMessage(j))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(3);
          if (j == 45)
          {
            paramToServiceMsg = a(localMsgInfo, l3);
            if ((paramToServiceMsg == null) || (MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramToServiceMsg, true))) {
              break label2240;
            }
            localArrayList1.add(paramToServiceMsg);
            break label2240;
          }
        }
      }
      for (;;)
      {
        GroupSystemMsgController.a().a(l2, localMsgInfo.uMsgTime, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        localObject1 = null;
        paramToServiceMsg = null;
        bool1 = false;
        j = i;
        i = 0;
        break label488;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(l3, j, localMsgInfo.vMsg, localMsgInfo.lFromUin, localMsgInfo.uMsgTime, localMsgInfo.shMsgSeq);
        l1 = 9998L;
        i = 32769;
        k = SystemMsg.getTroopSystemMsgType(j);
        continue;
        if (528 == j)
        {
          paramToServiceMsg = b(localMsgInfo, l4);
          if ((paramToServiceMsg == null) || (MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramToServiceMsg, true))) {
            break label2246;
          }
          localArrayList1.add(paramToServiceMsg);
          break label2246;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w("Q.msg.BaseMessageProcessor", 2, "~~~~~handleC2COnlinePushMsgResp msgtype: unknow msgType!!!");
        break;
        if (localArrayList4.size() > 0) {
          a(localArrayList4);
        }
        i = paramFromServiceMsg.getRequestSsoSeq();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l3, localArrayList3, m, i);
        boolean bool2;
        boolean bool3;
        if (localArrayList1.size() > 0)
        {
          bool2 = MessageHandlerUtils.a(localArrayList1);
          bool3 = MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList1);
          i = MsgProxyUtils.a(localArrayList1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          if ((!bool2) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause)) {
            break label2108;
          }
        }
        label2108:
        for (bool1 = true;; bool1 = false)
        {
          paramToServiceMsg.a(localArrayList1, String.valueOf(l3), bool1);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((int)paramSvcReqPushMsg.uMsgTime);
          a("handleGetBuddyMessageResp", true, i, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(bool2, bool3), false);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localArrayList1);
          return;
        }
        paramToServiceMsg = null;
        break label2136;
        label2119:
        paramToServiceMsg = null;
        j = -1;
        localObject1 = null;
        bool1 = false;
        i = 0;
        break label488;
        label2136:
        i = 1000;
        k = -1000;
        j = -1;
        localObject1 = null;
        bool1 = false;
        break label488;
        label2158:
        k = -1000;
        j = -1;
        localObject1 = null;
        bool1 = false;
        i = 1020;
        break label488;
        label2180:
        return;
        label2181:
        if (i == 12) {
          break label1373;
        }
        if (i != 14) {
          break label1400;
        }
        break label1373;
        label2198:
        label2215:
        do
        {
          paramToServiceMsg = null;
          j = -1;
          localObject1 = null;
          bool1 = false;
          i = 0;
          break;
          if (i == 11) {
            break label1434;
          }
        } while (i != 13);
        break label1434;
        label2232:
        i = 1000;
        break label1564;
        label2240:
        i = -1;
      }
      label2246:
      paramToServiceMsg = null;
      int j = -1;
      Object localObject1 = null;
      boolean bool1 = false;
      int i = 0;
    }
  }
  
  private void a(String paramString, long paramLong1, long[] paramArrayOfLong, byte[] paramArrayOfByte, long paramLong2, short paramShort, boolean paramBoolean)
  {
    paramLong1 = paramArrayOfLong[0];
    paramArrayOfByte = BuddyTransfileProcessor.a(paramArrayOfByte, paramArrayOfLong);
    if (paramArrayOfByte != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, String.valueOf(paramArrayOfLong[0]), paramArrayOfByte, paramLong2, paramShort, paramLong1, paramBoolean);
    }
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt)
  {
    Object localObject1 = new cmd0x2dc.GroupVisitorJoinMsg();
    try
    {
      paramArrayOfByte = (cmd0x2dc.GroupVisitorJoinMsg)((cmd0x2dc.GroupVisitorJoinMsg)localObject1).mergeFrom(paramArrayOfByte);
      long l = paramArrayOfByte.uint64_group_code.get();
      Object localObject2 = paramArrayOfByte.rpt_msg_visitor_join_info.get();
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        if (((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).f(String.valueOf(l)))
        {
          localObject1 = (MessageForEnterTroop)MessageRecordFactory.a(-4003);
          ((MessageForEnterTroop)localObject1).init(paramArrayOfByte, "" + l, paramArrayOfByte, "", MessageCache.a(), -4003, 1, 0L);
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            cmd0x2dc.VisitorJoinInfo localVisitorJoinInfo = (cmd0x2dc.VisitorJoinInfo)((Iterator)localObject2).next();
            if (!("" + localVisitorJoinInfo.uint64_visitor_uin.get()).equalsIgnoreCase(paramArrayOfByte)) {
              ((MessageForEnterTroop)localObject1).mList.add(new MessageForEnterTroop.User("" + localVisitorJoinInfo.uint64_visitor_uin.get(), localVisitorJoinInfo.bytes_visitor_name.get().toStringUtf8()));
            }
          }
          if (((MessageForEnterTroop)localObject1).mList.size() > 0)
          {
            ((MessageForEnterTroop)localObject1).isread = true;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject1, paramArrayOfByte);
          }
        }
      }
      return;
    }
    catch (Exception paramArrayOfByte) {}
  }
  
  private boolean a(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    case 2: 
    default: 
      return false;
    case 1: 
      return true;
    }
    return true;
  }
  
  private boolean a(byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool = false;
    long l1 = PkgTools.a(paramArrayOfByte, 0);
    if (paramArrayOfByte[4] == 15)
    {
      long l2 = PkgTools.a(paramArrayOfByte, 5);
      long l3 = PkgTools.a(paramArrayOfByte, 9);
      int i = PkgTools.b(paramArrayOfByte, 13);
      paramArrayOfByte = PkgTools.a(paramArrayOfByte, 15, i);
      long l4 = NetConnInfoCenter.getServerTime();
      ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(44)).a(paramInt, l1, l4, l3, l2, paramArrayOfByte);
      bool = true;
    }
    return bool;
  }
  
  private MessageRecord b(MsgInfo paramMsgInfo, long paramLong)
  {
    int i = 0;
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("cardpush", 2, "get a push message MsgType0x210");
    }
    Object localObject4 = GameCenterPackeger.a(paramMsgInfo.vMsg);
    if (localObject4 == null) {}
    label363:
    Object localObject1;
    Object localObject6;
    label691:
    label698:
    do
    {
      do
      {
        for (;;)
        {
          return null;
          if ((((MsgType0x210)localObject4).uSubMsgType == 36L) && (((MsgType0x210)localObject4).stMsgInfo0x24 != null))
          {
            paramMsgInfo = ((MsgType0x210)localObject4).stMsgInfo0x24;
            if ((paramMsgInfo != null) && (paramMsgInfo.vPluginNumList != null))
            {
              paramMsgInfo = paramMsgInfo.vPluginNumList;
              if ((paramMsgInfo != null) && (paramMsgInfo.size() > 0)) {
                return null;
              }
            }
          }
          else if (((MsgType0x210)localObject4).vProtobuf != null)
          {
            if (((MsgType0x210)localObject4).uSubMsgType == 39L)
            {
              if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "get a push message");
              }
              a(((MsgType0x210)localObject4).vProtobuf);
              return null;
            }
            if ((((MsgType0x210)localObject4).uSubMsgType == 40L) || (((MsgType0x210)localObject4).uSubMsgType == 63L))
            {
              if (QLog.isColorLevel()) {
                QLog.d("Hyim", 2, "get a push message for public account handler");
              }
              ((PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(10)).a(((MsgType0x210)localObject4).uSubMsgType, ((MsgType0x210)localObject4).vProtobuf);
              return null;
            }
            if (((MsgType0x210)localObject4).uSubMsgType == 48L)
            {
              if (QLog.isColorLevel()) {
                QLog.d("ShieldListSvrPush", 2, "<---receive shieldlist push : forward to shieldlisthandler");
              }
              ((ShieldListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(15)).a(((MsgType0x210)localObject4).vProtobuf);
              return null;
            }
            if (((MsgType0x210)localObject4).uSubMsgType != 49L)
            {
              if (((MsgType0x210)localObject4).uSubMsgType != 53L) {
                break label363;
              }
              try
              {
                i = ((Submsgtype0x35.MsgBody)new Submsgtype0x35.MsgBody().mergeFrom(((MsgType0x210)localObject4).vProtobuf)).uint32_bubble_timestamp.get();
                if (QLog.isColorLevel())
                {
                  QLog.d("Q.msg.BaseMessageProcessor", 2, "bubble push timestamp=" + i);
                  return null;
                }
              }
              catch (Exception paramMsgInfo) {}
            }
          }
        }
      } while (!QLog.isColorLevel());
      QLog.e("Q.msg.BaseMessageProcessor", 2, "<---decodeC2CMsgPkg_SecretfileReport parse failed.", paramMsgInfo);
      return null;
      if (((MsgType0x210)localObject4).uSubMsgType == 59L) {
        for (;;)
        {
          try
          {
            if (QLog.isColorLevel()) {
              QLog.i("troop_level_info_change", 2, "receive troop member level switch or map change push");
            }
            localObject1 = new Submsgtype0x3b.MsgBody();
            ((Submsgtype0x3b.MsgBody)localObject1).mergeFrom(((MsgType0x210)localObject4).vProtobuf);
            if (QLog.isColorLevel())
            {
              localObject4 = new StringBuilder().append("group code: ");
              if (!((Submsgtype0x3b.MsgBody)localObject1).uint64_group_code.has()) {
                break label691;
              }
              paramMsgInfo = String.valueOf(((Submsgtype0x3b.MsgBody)localObject1).uint64_group_code.get());
              localObject4 = ((StringBuilder)localObject4).append(paramMsgInfo).append(" user switch: ");
              if (!((Submsgtype0x3b.MsgBody)localObject1).uint32_user_show_flag.has()) {
                break label698;
              }
              paramMsgInfo = String.valueOf(((Submsgtype0x3b.MsgBody)localObject1).uint32_user_show_flag.get());
              QLog.e("troop_level_info_change", 2, paramMsgInfo + " level map changed: " + ((Submsgtype0x3b.MsgBody)localObject1).uint32_member_level_changed.has());
            }
            if (!((Submsgtype0x3b.MsgBody)localObject1).uint64_group_code.has()) {
              break;
            }
            if (((Submsgtype0x3b.MsgBody)localObject1).uint32_user_show_flag.has())
            {
              i = ((Submsgtype0x3b.MsgBody)localObject1).uint32_user_show_flag.get();
              paramMsgInfo = String.valueOf(((Submsgtype0x3b.MsgBody)localObject1).uint64_group_code.get());
              localObject4 = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
              localObject6 = ((FriendsManagerImp)localObject4).a(paramMsgInfo);
              ((TroopInfo)localObject6).cGroupRankUserFlag = ((byte)i);
              ((FriendsManagerImp)localObject4).b((TroopInfo)localObject6);
              if (1 == ((TroopInfo)localObject6).cGroupRankUserFlag) {
                ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(17)).g(paramMsgInfo);
              }
            }
            if (!((Submsgtype0x3b.MsgBody)localObject1).uint32_member_level_changed.has()) {
              break;
            }
            paramLong = ((Submsgtype0x3b.MsgBody)localObject1).uint64_group_code.get();
            ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(17)).g(String.valueOf(paramLong));
            return null;
          }
          catch (Exception paramMsgInfo) {}
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("troop_level_info_change", 2, "failed to parse Submsgtype0x3b.MsgBody");
          return null;
          paramMsgInfo = "";
          continue;
          paramMsgInfo = "";
        }
      }
    } while (((MsgType0x210)localObject4).uSubMsgType == 61L);
    if (((MsgType0x210)localObject4).uSubMsgType == 67L)
    {
      ConfigHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MsgType0x210)localObject4).vProtobuf);
      return null;
    }
    if ((localObject4 != null) && (((MsgType0x210)localObject4).uSubMsgType == 68L) && (((MsgType0x210)localObject4).vProtobuf != null))
    {
      a(paramLong, ((MsgType0x210)localObject4).vProtobuf);
      return null;
    }
    if ((((MsgType0x210)localObject4).uSubMsgType == 38L) && (((MsgType0x210)localObject4).vProtobuf != null))
    {
      b(((MsgType0x210)localObject4).vProtobuf);
      return null;
    }
    if ((((MsgType0x210)localObject4).uSubMsgType == 72L) && (((MsgType0x210)localObject4).vProtobuf != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DevLock", 2, "recv msg0x210.Submsgtype0x48");
      }
      paramMsgInfo = new RecommendDeviceLock();
      try
      {
        paramMsgInfo.mergeFrom(((MsgType0x210)localObject4).vProtobuf);
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("canCancel", paramMsgInfo.canCancel.get());
        ((Intent)localObject1).putExtra("tipMsg", paramMsgInfo.wording.get());
        ((Intent)localObject1).putExtra("title", paramMsgInfo.str_title.get());
        ((Intent)localObject1).putExtra("secondTitle", paramMsgInfo.str_second_title.get());
        ((Intent)localObject1).putExtra("thirdTitle", paramMsgInfo.str_third_title.get());
        localObject4 = paramMsgInfo.str_wording_list.get();
        localObject6 = new ArrayList();
        if ((localObject4 != null) && (((List)localObject4).size() > 0)) {
          ((ArrayList)localObject6).addAll((Collection)localObject4);
        }
        ((Intent)localObject1).putStringArrayListExtra("wordsList", (ArrayList)localObject6);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setDevLockIntent((Intent)localObject1);
        a(8007, true, new Object[] { Boolean.valueOf(paramMsgInfo.canCancel.get()), paramMsgInfo.wording.get(), paramMsgInfo.str_title.get(), paramMsgInfo.str_second_title.get(), paramMsgInfo.str_third_title.get(), localObject6 });
        return null;
      }
      catch (Exception paramMsgInfo)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DevLock", 2, "failed to parse msg0x210.Submsgtype0x48");
        }
        a(8007, false, new Object[] { Boolean.valueOf(true), "" });
        return null;
      }
    }
    if ((((MsgType0x210)localObject4).uSubMsgType == 81L) && (((MsgType0x210)localObject4).vProtobuf != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DevLock", 2, "recv msg0x210.Submsgtype0x51");
      }
      new SubMsgType0x51.MsgBody();
    }
    label2256:
    label2262:
    label2268:
    label2274:
    label2280:
    for (;;)
    {
      for (;;)
      {
        Object localObject7;
        try
        {
          localObject7 = new SubMsgType0x51.MsgBody();
          ((SubMsgType0x51.MsgBody)localObject7).mergeFrom(((MsgType0x210)localObject4).vProtobuf);
          if (!((SubMsgType0x51.MsgBody)localObject7).bytes_qrsig_url.has()) {
            break label2274;
          }
          localObject1 = new String(((SubMsgType0x51.MsgBody)localObject7).bytes_qrsig_url.get().toByteArray(), "utf-8");
          if (!((SubMsgType0x51.MsgBody)localObject7).bytes_hint1.has()) {
            break label2268;
          }
          localObject4 = new String(((SubMsgType0x51.MsgBody)localObject7).bytes_hint1.get().toByteArray(), "utf-8");
          if (!((SubMsgType0x51.MsgBody)localObject7).bytes_hint2.has()) {
            break label2262;
          }
          localObject6 = new String(((SubMsgType0x51.MsgBody)localObject7).bytes_hint2.get().toByteArray(), "utf-8");
          if (!((SubMsgType0x51.MsgBody)localObject7).uint32_allow_tmp_auth.has()) {
            break label2256;
          }
          if (((SubMsgType0x51.MsgBody)localObject7).uint32_allow_tmp_auth.get() != 1) {
            continue;
          }
          bool = true;
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("DevLock", 2, "failed to parse msg0x210.Submsgtype0x51");
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("DevLock", 2, "recv devlock quicklogin push qrcode=" + (String)localObject1 + " maintip=" + (String)localObject4 + " smalltip" + (String)localObject6);
        }
        EquipmentLockImpl.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, (String)localObject4, (String)localObject6, bool);
        paramLong = paramMsgInfo.lFromUin;
        i = paramMsgInfo.shMsgSeq;
        l = paramMsgInfo.lMsgUid;
        j = paramMsgInfo.shMsgType;
        MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramLong, i, l, j);
        return null;
        bool = false;
        break label2280;
        if ((((MsgType0x210)localObject4).uSubMsgType == 74L) && (((MsgType0x210)localObject4).vProtobuf != null))
        {
          ((SafeCenterPushHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22)).a(((MsgType0x210)localObject4).vProtobuf);
          return null;
        }
        Object localObject2;
        if ((((MsgType0x210)localObject4).uSubMsgType == 84L) && (((MsgType0x210)localObject4).vProtobuf != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQOperateVoIP", 2, "get voip_tips from handleC2COnlinePushMsg0x210Resp");
          }
          paramMsgInfo = (ConfigHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(4);
          if (paramMsgInfo == null) {
            break;
          }
          localObject2 = new submsgtype0x54.MsgBody();
          try
          {
            ((submsgtype0x54.MsgBody)localObject2).mergeFrom(((MsgType0x210)localObject4).vProtobuf);
            j = ((submsgtype0x54.MsgBody)localObject2).peer_type.get();
            localObject6 = ((submsgtype0x54.MsgBody)localObject2).task_list.get();
            localObject4 = new ArrayList();
            if ((localObject6 != null) && (((List)localObject6).size() > 0))
            {
              localObject6 = ((List)localObject6).iterator();
              while (((Iterator)localObject6).hasNext())
              {
                localObject7 = (submsgtype0x54.MsgBody.TaskInfo)((Iterator)localObject6).next();
                QQOperationViopTipTask localQQOperationViopTipTask = new QQOperationViopTipTask();
                localQQOperationViopTipTask.taskid = ((submsgtype0x54.MsgBody.TaskInfo)localObject7).task_id.get();
                ((ArrayList)localObject4).add(localQQOperationViopTipTask);
              }
            }
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
          {
            for (;;)
            {
              localInvalidProtocolBufferMicroException2.printStackTrace();
            }
            paramLong = ((submsgtype0x54.MsgBody)localObject2).peer_uin.get();
            if (j != 1) {}
          }
          for (;;)
          {
            paramMsgInfo.a(String.valueOf(paramLong), i, localInvalidProtocolBufferMicroException2);
            return null;
            i = 3000;
          }
        }
        if (localInvalidProtocolBufferMicroException2.uSubMsgType == 103L)
        {
          if (QLog.isColorLevel())
          {
            paramMsgInfo = new StringBuilder().append("receive msgtype0x210.submsgtype0x67 group recmd push: ");
            if (localInvalidProtocolBufferMicroException2.vProtobuf != null) {
              QLog.d("nearbyTroopPush", 2, bool);
            }
          }
          else
          {
            paramMsgInfo = new submsgtype0x67.MsgBody();
          }
          try
          {
            paramMsgInfo.mergeFrom(localInvalidProtocolBufferMicroException2.vProtobuf);
            if (!paramMsgInfo.rpt_msg_grpinfo.has()) {
              break;
            }
            paramMsgInfo = paramMsgInfo.rpt_msg_grpinfo.get();
            localObject2 = (LBSHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(3);
            if (localObject2 == null) {
              break;
            }
            ((LBSHandler)localObject2).b(paramMsgInfo);
            return null;
            bool = false;
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("nearbyTroopPush", 2, "receive msgtype0x210.submsgtype0x67 mergeFrom exception: " + localInvalidProtocolBufferMicroException1.toString());
              }
            }
          }
        }
      }
      if (localInvalidProtocolBufferMicroException2.uSubMsgType == 110L) {
        break;
      }
      if ((localInvalidProtocolBufferMicroException2.uSubMsgType == 99L) && (localInvalidProtocolBufferMicroException2.vProtobuf != null))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.msg.BaseMessageProcessor", 2, "Get crm voip push from handleC2COnlinePushMsg0x210Resp");
        return null;
      }
      if ((localInvalidProtocolBufferMicroException2.uSubMsgType == 101L) && (localInvalidProtocolBufferMicroException2.vProtobuf != null))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d(OfflineExpire.a, 4, "get push cmd from handleC2COnlinePushMsg0x210Resp");
        }
        OfflineExpire.a(localInvalidProtocolBufferMicroException2.vProtobuf);
        return null;
      }
      if ((localInvalidProtocolBufferMicroException2.uSubMsgType == 102L) && (localInvalidProtocolBufferMicroException2.vProtobuf != null))
      {
        QWalletPushManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localInvalidProtocolBufferMicroException2.vProtobuf);
        return null;
      }
      if ((localInvalidProtocolBufferMicroException2.uSubMsgType == 78L) && (localInvalidProtocolBufferMicroException2.vProtobuf != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopNotificationHelper", 2, "get notice from handleC2COnlinePushMsg0x210Resp");
        }
        MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localInvalidProtocolBufferMicroException2.vProtobuf);
        paramLong = paramMsgInfo.lFromUin;
        i = paramMsgInfo.shMsgSeq;
        l = paramMsgInfo.lMsgUid;
        j = paramMsgInfo.shMsgType;
        MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramLong, i, l, j);
        return null;
      }
      if (localInvalidProtocolBufferMicroException2.uSubMsgType == 107L) {
        break;
      }
      if (105L == localInvalidProtocolBufferMicroException2.uSubMsgType)
      {
        if (!TroopRedTouchHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localInvalidProtocolBufferMicroException2.vProtobuf)) {
          break;
        }
        a(105, true, null);
        return null;
      }
      if (localInvalidProtocolBufferMicroException2.uSubMsgType != 111L) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TurnBrand", 2, "get notice from handleC2COnlinePushMsg0x210Resp");
      }
      ((MessageHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0)).a(localInvalidProtocolBufferMicroException2.vProtobuf);
      paramLong = paramMsgInfo.lFromUin;
      i = paramMsgInfo.shMsgSeq;
      long l = paramMsgInfo.lMsgUid;
      int j = paramMsgInfo.shMsgType;
      MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramLong, i, l, j);
      return null;
      bool = false;
      continue;
      localObject6 = null;
      continue;
      Object localObject5 = null;
      continue;
      Object localObject3 = null;
    }
  }
  
  private czc b(int paramInt, MsgInfo paramMsgInfo, SvcReqPushMsg paramSvcReqPushMsg)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(OnLinePushMsgTypeProcessorDispatcher.a(paramInt)).a(OnLinePushMsgTypeProcessorDispatcher.a(paramInt), paramMsgInfo, paramSvcReqPushMsg);
  }
  
  private boolean b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  private void c(byte[] paramArrayOfByte)
  {
    PkgTools.a(paramArrayOfByte, 0);
    int i = paramArrayOfByte[5];
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "----->handleTroopExitMsg cOp = " + i);
    }
  }
  
  private boolean c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public List a(msg_comm.Msg paramMsg, PBDecodeContext paramPBDecodeContext)
  {
    return null;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length == 3))
    {
      a((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], (SvcReqPushMsg)paramVarArgs[2]);
      return;
    }
    a(getClass().getName(), paramInt);
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 parse start");
    }
    try
    {
      paramArrayOfByte = (submsgtype0x44.MsgBody)new submsgtype0x44.MsgBody().mergeFrom(paramArrayOfByte);
      if (paramArrayOfByte == null) {
        return;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 parse failed.", paramArrayOfByte);
        }
        paramArrayOfByte = null;
      }
      if (QLog.isColorLevel())
      {
        if ((paramArrayOfByte.msg_friend_msg_sync.has()) && (paramArrayOfByte.msg_friend_msg_sync.get() != null)) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_friend_msg_sync processflag=" + paramArrayOfByte.msg_friend_msg_sync.uint32_processflag.get() + ";processtype=" + paramArrayOfByte.msg_friend_msg_sync.uint32_processtype.get() + ";fuin" + paramArrayOfByte.msg_friend_msg_sync.uint64_fuin.get());
        }
        if ((paramArrayOfByte.msg_group_msg_sync.has()) && (paramArrayOfByte.msg_group_msg_sync.get() != null)) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_group_msg_sync processflag=" + paramArrayOfByte.msg_group_msg_sync.uint32_processflag.get() + ";processtype=" + paramArrayOfByte.msg_group_msg_sync.uint32_msg_type.get() + ";grp_code=" + paramArrayOfByte.msg_group_msg_sync.uint64_grp_code.get());
        }
        if ((paramArrayOfByte.msg_clean_count_msg.has()) && (paramArrayOfByte.msg_clean_count_msg.get() != null)) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_clean_count_msg processflag=" + paramArrayOfByte.msg_clean_count_msg.uint32_processflag.get());
        }
      }
      if (!paramArrayOfByte.msg_friend_msg_sync.has()) {
        break label1092;
      }
    }
    int i;
    label344:
    Object localObject1;
    Object localObject2;
    if (paramArrayOfByte.msg_friend_msg_sync.get() != null) {
      if (a(paramArrayOfByte.msg_friend_msg_sync.uint32_processflag.get()))
      {
        i = 1;
        if (c(paramArrayOfByte.msg_friend_msg_sync.uint32_processtype.get()))
        {
          localObject1 = String.valueOf(paramArrayOfByte.msg_friend_msg_sync.uint64_fuin.get());
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (StringUtil.d((String)localObject1)))
          {
            localObject2 = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
            localObject2 = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
            j = paramArrayOfByte.msg_friend_msg_sync.uint32_sourceid.get();
            ((FriendListHandler)localObject2).a(String.valueOf(localObject1), 0, j, null, false, false);
          }
        }
        j = i;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_friend_msg_sync uint32_processflag=" + paramArrayOfByte.msg_friend_msg_sync.uint32_processflag.get() + ";uint32_processtype=" + paramArrayOfByte.msg_friend_msg_sync.uint32_processtype.get());
        }
      }
    }
    label1036:
    label1072:
    label1092:
    for (int j = i;; j = 0)
    {
      if ((paramArrayOfByte.msg_group_msg_sync.has()) && (paramArrayOfByte.msg_group_msg_sync.get() != null)) {
        if (a(paramArrayOfByte.msg_group_msg_sync.uint32_processflag.get()))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a().a(String.valueOf(paramArrayOfByte.msg_group_msg_sync.uint64_grp_code.get()), paramArrayOfByte.msg_group_msg_sync.uint64_msg_seq.get(), true);
          i = 1;
          label590:
          if (b(paramArrayOfByte.msg_group_msg_sync.uint32_msg_type.get()))
          {
            localObject1 = String.valueOf(paramArrayOfByte.msg_group_msg_sync.uint64_grp_code.get());
            localObject2 = SystemMsgUtils.a(paramArrayOfByte.msg_group_msg_sync.uint64_grp_code.get());
            if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)) && (StringUtil.d((String)localObject1)))
            {
              FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
              if (localFriendsManagerImp.a((String)localObject1) == null)
              {
                TroopInfo localTroopInfo = new TroopInfo();
                localTroopInfo.troopuin = ((String)localObject1);
                localTroopInfo.troopcode = ((String)localObject2);
                localFriendsManagerImp.a(localTroopInfo);
                ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(17)).a(localTroopInfo.troopuin, (byte)1, localTroopInfo.dwTimeStamp, 0);
              }
              a(2001, true, null);
            }
          }
          k = i;
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_group_msg_sync uint32_processflag=" + paramArrayOfByte.msg_group_msg_sync.uint32_processflag.get() + ";uint32_msg_type=" + paramArrayOfByte.msg_group_msg_sync.uint32_msg_type.get());
          }
        }
      }
      for (int k = i;; k = 0)
      {
        if ((j != 0) || (k != 0))
        {
          if ((j == 0) || (k == 0)) {
            break label1036;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a().a(4);
        }
        for (;;)
        {
          if ((!paramArrayOfByte.msg_clean_count_msg.has()) || (paramArrayOfByte.msg_clean_count_msg.get() == null)) {
            break label1072;
          }
          if (a(paramArrayOfByte.msg_clean_count_msg.uint32_processflag.get()))
          {
            SystemMsgController.a().c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(AppConstants.aj, 9000, 0 - GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
            GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
            GroupSystemMsgController.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
            FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(Conversation.class);
            if (localObject1 != null) {
              ((Handler)localObject1).sendEmptyMessage(1009);
            }
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_clean_count_msg uint32_processflag=" + paramArrayOfByte.msg_clean_count_msg.uint32_processflag.get());
          return;
          if (j != 0) {
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a().a(2);
          } else if (k != 0) {
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a().a(3);
          }
        }
        break;
        i = 0;
        break label590;
      }
      i = 0;
      break label344;
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str);
        if (((localObject == null) || (System.currentTimeMillis() - ((AppShareID)localObject).updateTime >= 86400000L)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().add(str)))
        {
          localObject = new GetResourceReqInfo();
          ((GetResourceReqInfo)localObject).uiResID = 0L;
          ((GetResourceReqInfo)localObject).strPkgName = str;
          ((GetResourceReqInfo)localObject).uiCurVer = 0L;
          ((GetResourceReqInfo)localObject).sResType = 4;
          ((GetResourceReqInfo)localObject).sLanType = 0;
          ((GetResourceReqInfo)localObject).sReqType = 1;
          localArrayList.add(localObject);
          if (QLog.isColorLevel()) {
            QLog.d("share_appid", 2, "Request list add appid = " + str);
          }
        }
      }
      if (localArrayList.size() > 0) {
        ConfigUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), localArrayList);
      }
    }
  }
  
  public void a(msg_comm.MsgType0x210 paramMsgType0x210, msg_comm.Msg paramMsg)
  {
    boolean bool = true;
    String str = null;
    if (QLog.isColorLevel()) {
      QLog.d("DevLock", 2, "decodeDevlockQuickLoginPush recv msg0x210.Submsgtype0x51");
    }
    if (paramMsgType0x210.sub_msg_type.get() != 81) {
      if (QLog.isColorLevel()) {
        QLog.d("DevLock", 2, "decodeDevlockQuickLoginPush submsgtype != 0x51");
      }
    }
    do
    {
      do
      {
        return;
        if (paramMsgType0x210.msg_content != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("DevLock", 2, "decodeDevlockQuickLoginPush msg_content is null");
      return;
      paramMsgType0x210 = paramMsgType0x210.msg_content.get().toByteArray();
      if (paramMsgType0x210 != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("DevLock", 2, "decodeDevlockQuickLoginPush decode ox210Stream is null");
    return;
    new SubMsgType0x51.MsgBody();
    label344:
    label349:
    label354:
    label359:
    label364:
    for (;;)
    {
      try
      {
        SubMsgType0x51.MsgBody localMsgBody = new SubMsgType0x51.MsgBody();
        localMsgBody.mergeFrom(paramMsgType0x210);
        if (!localMsgBody.bytes_qrsig_url.has()) {
          break label359;
        }
        paramMsgType0x210 = new String(localMsgBody.bytes_qrsig_url.get().toByteArray(), "utf-8");
        if (!localMsgBody.bytes_hint1.has()) {
          break label354;
        }
        paramMsg = new String(localMsgBody.bytes_hint1.get().toByteArray(), "utf-8");
        if (localMsgBody.bytes_hint2.has()) {
          str = new String(localMsgBody.bytes_hint2.get().toByteArray(), "utf-8");
        }
        if (!localMsgBody.uint32_allow_tmp_auth.has()) {
          break label349;
        }
        if (localMsgBody.uint32_allow_tmp_auth.get() != 1) {
          break label344;
        }
      }
      catch (Exception paramMsgType0x210) {}
      if (QLog.isColorLevel()) {
        QLog.d("DevLock", 2, "decodeDevlockQuickLoginPush recv devlock quicklogin push qrcode=" + paramMsgType0x210 + " maintip=" + paramMsg + " smalltip" + str);
      }
      EquipmentLockImpl.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMsgType0x210, paramMsg, str, bool);
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("DevLock", 2, "failed to parse msg0x210.Submsgtype0x51");
      return;
      bool = false;
      break label364;
      bool = false;
      continue;
      paramMsg = null;
      continue;
      paramMsgType0x210 = null;
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    Object localObject1;
    FriendsManager localFriendsManager;
    TroopManager localTroopManager;
    PublicAccountDataManager localPublicAccountDataManager;
    Friends[] arrayOfFriends;
    int i;
    for (;;)
    {
      return;
      localObject1 = new SubMsgType0x27.MsgBody();
      try
      {
        paramArrayOfByte = (SubMsgType0x27.MsgBody)((SubMsgType0x27.MsgBody)localObject1).mergeFrom(paramArrayOfByte);
        if (paramArrayOfByte != null)
        {
          localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43);
          localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(44);
          localPublicAccountDataManager = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48);
          paramArrayOfByte = paramArrayOfByte.rpt_msg_mod_infos.get();
          arrayOfFriends = new Friends[paramArrayOfByte.size()];
          Iterator localIterator = paramArrayOfByte.iterator();
          i = 0;
          for (;;)
          {
            if (!localIterator.hasNext()) {
              break label6274;
            }
            paramArrayOfByte = (SubMsgType0x27.ForwardBody)localIterator.next();
            if ((!paramArrayOfByte.uint32_notify_type.has()) || (paramArrayOfByte.uint32_notify_type.get() != 1)) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("cardpush", 2, "push a no content，如何处理？");
            }
          }
          if (!paramArrayOfByte.uint32_op_type.has()) {
            break label324;
          }
        }
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return;
      }
    }
    label324:
    Object localObject4;
    int j;
    label1018:
    Object localObject5;
    switch (paramArrayOfByte.uint32_op_type.get())
    {
    default: 
    case 0: 
    case 1: 
    case 2: 
    case 3: 
      do
      {
        do
        {
          for (;;)
          {
            break;
            if (paramArrayOfByte.msg_add_group.has())
            {
              localObject1 = (SubMsgType0x27.AddGroup)paramArrayOfByte.msg_add_group.get();
              paramArrayOfByte = new Groups();
              if (((SubMsgType0x27.AddGroup)localObject1).uint32_groupid.has()) {
                paramArrayOfByte.group_id = ((SubMsgType0x27.AddGroup)localObject1).uint32_groupid.get();
              }
              if (((SubMsgType0x27.AddGroup)localObject1).bytes_groupname.has()) {
                paramArrayOfByte.group_name = ((SubMsgType0x27.AddGroup)localObject1).bytes_groupname.get().toStringUtf8();
              }
              if (((SubMsgType0x27.AddGroup)localObject1).uint32_sortid.has()) {
                paramArrayOfByte.seqid = ((byte)((SubMsgType0x27.AddGroup)localObject1).uint32_sortid.get());
              }
              if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a AddGroup  = id:" + paramArrayOfByte.group_id + " name : " + paramArrayOfByte.group_name + " sortid: " + paramArrayOfByte.seqid);
              }
              localFriendsManager.a(paramArrayOfByte);
              localObject1 = new AddGroupResp();
              ((AddGroupResp)localObject1).dwToUin = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).longValue();
              ((AddGroupResp)localObject1).dwSequence = paramArrayOfByte.seqid;
              ((AddGroupResp)localObject1).cGroupId = ((byte)paramArrayOfByte.group_id);
              ((AddGroupResp)localObject1).cSortId = paramArrayOfByte.seqid;
              paramArrayOfByte = new GroupActionResp(0, "", (AddGroupResp)localObject1);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(18, true, paramArrayOfByte);
              continue;
              if (paramArrayOfByte.msg_del_group.has())
              {
                localObject1 = (SubMsgType0x27.DelGroup)paramArrayOfByte.msg_del_group.get();
                if (((SubMsgType0x27.DelGroup)localObject1).uint32_groupid.has())
                {
                  localObject4 = localFriendsManager.a(((SubMsgType0x27.DelGroup)localObject1).uint32_groupid.get() + "");
                  if (QLog.isColorLevel()) {
                    QLog.d("cardpush", 2, "push a DelGroup  = id:" + ((SubMsgType0x27.DelGroup)localObject1).uint32_groupid.get());
                  }
                  paramArrayOfByte = new DelGroupResp();
                  paramArrayOfByte.dwToUin = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).longValue();
                  paramArrayOfByte.dwSequence = ((Groups)localObject4).seqid;
                  paramArrayOfByte.cGroupid = ((byte)((SubMsgType0x27.DelGroup)localObject1).uint32_groupid.get());
                  localObject1 = new GroupActionResp(0, "", paramArrayOfByte);
                  ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(paramArrayOfByte, true, (GroupActionResp)localObject1);
                }
              }
            }
          }
        } while (!paramArrayOfByte.msg_mod_group_name.has());
        localObject1 = (SubMsgType0x27.ModGroupName)paramArrayOfByte.msg_mod_group_name.get();
        if ((((SubMsgType0x27.ModGroupName)localObject1).uint32_groupid.has()) && (((SubMsgType0x27.ModGroupName)localObject1).bytes_groupname.has()))
        {
          j = ((SubMsgType0x27.ModGroupName)localObject1).uint32_groupid.get();
          localObject4 = ((SubMsgType0x27.ModGroupName)localObject1).bytes_groupname.get().toStringUtf8();
          paramArrayOfByte = localFriendsManager.a(String.valueOf(j));
          if (paramArrayOfByte == null) {
            break label1018;
          }
        }
        for (paramArrayOfByte.group_name = ((String)localObject4);; paramArrayOfByte.group_name = ((String)localObject4))
        {
          localFriendsManager.a(paramArrayOfByte);
          if (QLog.isColorLevel()) {
            QLog.d("cardpush", 2, "push a ModGroupName  = id:" + ((SubMsgType0x27.ModGroupName)localObject1).uint32_groupid.get() + " name:" + ((SubMsgType0x27.ModGroupName)localObject1).bytes_groupname.get().toStringUtf8());
          }
          paramArrayOfByte = new RenameGroupResp();
          paramArrayOfByte.dwToUin = ((SubMsgType0x27.ModGroupName)localObject1).uint32_groupid.get();
          j = (byte)((SubMsgType0x27.ModGroupName)localObject1).uint32_groupid.get();
          paramArrayOfByte.sGroupName = new String(((SubMsgType0x27.ModGroupName)localObject1).bytes_groupname.get().toStringUtf8());
          paramArrayOfByte = new GroupActionResp(0, "", paramArrayOfByte);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(19, true, paramArrayOfByte);
          break;
          paramArrayOfByte = new Groups();
          paramArrayOfByte.group_id = j;
        }
      } while (!paramArrayOfByte.msg_mod_group_sort.has());
      localObject4 = ((SubMsgType0x27.ModGroupSort)paramArrayOfByte.msg_mod_group_sort.get()).rpt_msg_groupsort.get();
      if (localObject4 != null)
      {
        paramArrayOfByte = new byte[((List)localObject4).size()];
        localObject1 = new byte[((List)localObject4).size()];
        localObject4 = ((List)localObject4).iterator();
        j = 0;
        label1107:
        if (((Iterator)localObject4).hasNext())
        {
          localObject5 = (SubMsgType0x27.GroupSort)((Iterator)localObject4).next();
          if ((!((SubMsgType0x27.GroupSort)localObject5).uint32_groupid.has()) || (!((SubMsgType0x27.GroupSort)localObject5).uint32_sortid.has())) {
            break label6291;
          }
          paramArrayOfByte[j] = ((byte)((SubMsgType0x27.GroupSort)localObject5).uint32_groupid.get());
          localObject1[j] = ((byte)((SubMsgType0x27.GroupSort)localObject5).uint32_sortid.get());
          if (QLog.isColorLevel()) {
            QLog.d("cardpush", 2, "push a ModGroupSort  = id:" + ((SubMsgType0x27.GroupSort)localObject5).uint32_groupid.get() + " sortid:" + ((SubMsgType0x27.GroupSort)localObject5).uint32_sortid.get());
          }
          j += 1;
        }
      }
      break;
    }
    label3213:
    label6291:
    for (;;)
    {
      break label1107;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(22, true, null);
      localFriendsManager.a(paramArrayOfByte, (byte[])localObject1);
      break;
      if (!paramArrayOfByte.msg_mod_friend_group.has()) {
        break;
      }
      paramArrayOfByte = ((SubMsgType0x27.ModFriendGroup)paramArrayOfByte.msg_mod_friend_group.get()).rpt_msg_frd_group.get();
      label1308:
      long l1;
      int k;
      if (paramArrayOfByte != null)
      {
        paramArrayOfByte = paramArrayOfByte.iterator();
        while (paramArrayOfByte.hasNext())
        {
          localObject1 = (SubMsgType0x27.FriendGroup)paramArrayOfByte.next();
          if ((((SubMsgType0x27.FriendGroup)localObject1).uint64_fuin.has()) && (((SubMsgType0x27.FriendGroup)localObject1).rpt_uint32_new_group_id.get().size() > 0))
          {
            l1 = ((SubMsgType0x27.FriendGroup)localObject1).uint64_fuin.get();
            k = ((Integer)((SubMsgType0x27.FriendGroup)localObject1).rpt_uint32_new_group_id.get(0)).intValue();
            if (((SubMsgType0x27.FriendGroup)localObject1).rpt_uint32_old_group_id.get().size() <= 0) {
              break label6285;
            }
          }
        }
      }
      for (j = ((Integer)((SubMsgType0x27.FriendGroup)localObject1).rpt_uint32_old_group_id.get(0)).intValue();; j = 0)
      {
        localFriendsManager.a(l1 + "", k);
        if (QLog.isColorLevel()) {
          QLog.d("cardpush", 2, "push a ModFriendGroup  = id:" + l1 + " newgroupid:" + k);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(9, true, new Object[] { l1 + "", Byte.valueOf((byte)k), Byte.valueOf((byte)j) });
        break label1308;
        break;
        if (!paramArrayOfByte.msg_del_friend.has()) {
          break;
        }
        paramArrayOfByte = ((SubMsgType0x27.DelFriend)paramArrayOfByte.msg_del_friend.get()).rpt_uint64_uins.get().iterator();
        while (paramArrayOfByte.hasNext())
        {
          l1 = ((Long)paramArrayOfByte.next()).longValue();
          localFriendsManager.d(l1 + "");
          localPublicAccountDataManager.a(l1 + "");
          if (QLog.isColorLevel()) {
            QLog.d("cardpush", 2, "push a DelFriend  = id:" + l1);
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
          localObject4 = ((RecentUserProxy)localObject1).a(String.valueOf(l1), 0);
          if (localObject4 != null) {
            ((RecentUserProxy)localObject1).b((RecentUser)localObject4);
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(15, true, Long.valueOf(l1));
        }
        paramArrayOfByte = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
        if (paramArrayOfByte != null) {
          paramArrayOfByte.c();
        }
        break;
        if (!paramArrayOfByte.msg_mod_friend_rings.has()) {
          break;
        }
        paramArrayOfByte = ((SubMsgType0x27.ModSnsGeneralInfo)paramArrayOfByte.msg_mod_friend_rings.get()).rpt_msg_sns_general_infos.get().iterator();
        long l2;
        while (paramArrayOfByte.hasNext())
        {
          localObject1 = (SubMsgType0x27.SnsUpateBuffer)paramArrayOfByte.next();
          localObject4 = ((SubMsgType0x27.SnsUpateBuffer)localObject1).rpt_msg_sns_update_item.get().iterator();
          while (((Iterator)localObject4).hasNext())
          {
            localObject5 = (SubMsgType0x27.SnsUpdateItem)((Iterator)localObject4).next();
            if (((SubMsgType0x27.SnsUpdateItem)localObject5).uint32_update_sns_type.get() == 13571)
            {
              l1 = ((SubMsgType0x27.SnsUpateBuffer)localObject1).uint64_uin.get();
              l2 = ((SubMsgType0x27.SnsUpateBuffer)localObject1).uint64_code.get();
              Long.valueOf(l1).toString();
              String.valueOf(Long.valueOf(l2));
              j = ((SubMsgType0x27.SnsUpdateItem)localObject5).bytes_value.get().size();
              localObject5 = ((SubMsgType0x27.SnsUpdateItem)localObject5).bytes_value.get().toByteArray();
              if (j >= 6)
              {
                if ((localObject5[0] != 1) || (localObject5[0] == 0)) {}
                j = localObject5[1];
              }
            }
          }
        }
        break;
        if (!paramArrayOfByte.msg_mod_friend_flag.has()) {
          break;
        }
        paramArrayOfByte = (SubMsgType0x27.SnsUpdateFlag)paramArrayOfByte.msg_mod_friend_flag.get();
        boolean bool;
        if (paramArrayOfByte.rpt_msg_update_sns_flag.has())
        {
          paramArrayOfByte = paramArrayOfByte.rpt_msg_update_sns_flag.get().iterator();
          while (paramArrayOfByte.hasNext())
          {
            localObject1 = (SubMsgType0x27.SnsUpdateOneFlag)paramArrayOfByte.next();
            l1 = ((SubMsgType0x27.SnsUpdateOneFlag)localObject1).uint64__uin.get();
            j = ((SubMsgType0x27.SnsUpdateOneFlag)localObject1).uint32_flag.get();
            l2 = ((SubMsgType0x27.SnsUpdateOneFlag)localObject1).uint64_id.get();
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageProcessor", 2, "FriendShield : onLinePush : uin : " + l1 + " flag:" + j + " id:" + l2);
            }
            if (l2 == 4051L)
            {
              localObject1 = localFriendsManager.c(String.valueOf(l1));
              if (localObject1 != null)
              {
                if (j == 1) {}
                for (bool = true;; bool = false)
                {
                  ((Friends)localObject1).setShieldFlag(bool);
                  localFriendsManager.a((Friends)localObject1);
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(56, true, new Object[] { Long.valueOf(l1), Boolean.valueOf(bool), Boolean.valueOf(true), Boolean.valueOf(true), "" });
                  break;
                }
              }
            }
          }
        }
        break;
        if (!paramArrayOfByte.msg_mod_profile.has()) {
          break;
        }
        paramArrayOfByte = (SubMsgType0x27.ModProfile)paramArrayOfByte.msg_mod_profile.get();
        k = i;
        if (paramArrayOfByte.uint64_uin.has())
        {
          l1 = paramArrayOfByte.uint64_uin.get();
          localObject4 = paramArrayOfByte.rpt_msg_profile_infos.get().iterator();
          j = i;
          for (;;)
          {
            k = j;
            if (!((Iterator)localObject4).hasNext()) {
              break;
            }
            paramArrayOfByte = (SubMsgType0x27.ProfileInfo)((Iterator)localObject4).next();
            if ((paramArrayOfByte.uint32_field.has()) && (paramArrayOfByte.bytes_value.has())) {
              switch (paramArrayOfByte.uint32_field.get())
              {
              default: 
                if (QLog.isColorLevel()) {
                  QLog.d("cardpush", 2, "push a unknow field Uint32Field = " + paramArrayOfByte.uint32_field.get());
                }
                break;
              case 20002: 
                paramArrayOfByte = paramArrayOfByte.bytes_value.get();
                if (QLog.isColorLevel()) {
                  QLog.d("cardpush", 2, "push a ModProfile Nick = " + paramArrayOfByte.toStringUtf8());
                }
                arrayOfFriends[j] = localFriendsManager.a(l1 + "", paramArrayOfByte.toStringUtf8());
                localObject1 = localFriendsManager.a(l1 + "");
                if (localObject1 != null)
                {
                  ((Card)localObject1).strNick = paramArrayOfByte.toStringUtf8();
                  localFriendsManager.a((Card)localObject1);
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2).a(1, true, localObject1);
                }
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(3, true, Long.toString(l1));
                j += 1;
                break;
              case 20015: 
                paramArrayOfByte = paramArrayOfByte.bytes_value.get();
                if ((paramArrayOfByte != null) && (paramArrayOfByte.size() == 2))
                {
                  i = paramArrayOfByte.byteAt(0);
                  i = (short)(paramArrayOfByte.byteAt(1) | i << 8);
                  if (QLog.isColorLevel()) {
                    QLog.d("cardpush", 2, "push a ModProfile Head = " + i);
                  }
                  ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).b(l1 + "");
                  paramArrayOfByte = localFriendsManager.a(l1 + "");
                  if (paramArrayOfByte != null)
                  {
                    paramArrayOfByte.nFaceID = i;
                    localFriendsManager.a(paramArrayOfByte);
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(4, true, new Object[] { l1 + "", paramArrayOfByte, null });
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2).a(1, true, paramArrayOfByte);
                  }
                }
                break;
              case 20009: 
                k = paramArrayOfByte.bytes_value.get().byteAt(0);
                if (k == 1) {
                  i = 0;
                }
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("cardpush", 2, "push a ModProfile Sex = " + i);
                  }
                  paramArrayOfByte = localFriendsManager.a(l1 + "");
                  if (paramArrayOfByte == null) {
                    break;
                  }
                  paramArrayOfByte.shGender = ((short)i);
                  localFriendsManager.a(paramArrayOfByte);
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2).a(1, true, paramArrayOfByte);
                  break;
                  if (k == 2)
                  {
                    i = 1;
                  }
                  else
                  {
                    i = k;
                    if (k == 0) {
                      i = 2;
                    }
                  }
                }
              case 20059: 
                i = ByteBuffer.wrap(paramArrayOfByte.bytes_value.get().toByteArray()).asIntBuffer().get(0);
                a(i);
                ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12)).a(101, true, Integer.valueOf(i));
                if (QLog.isColorLevel()) {
                  QLog.d("vip", 2, "bubble id = " + i);
                }
                break;
              case 23105: 
                if (QLog.isColorLevel()) {
                  QLog.d("vip", 2, "vip update uin=" + l1);
                }
                paramArrayOfByte = paramArrayOfByte.bytes_value.get();
                localObject1 = (Friends)localFriendsManager.c(Long.toString(l1)).clone();
                if (QLog.isColorLevel()) {
                  QLog.d("vip", 2, "bit info =" + paramArrayOfByte.byteAt(0));
                }
                if ((paramArrayOfByte.byteAt(0) & 0x80) == 0)
                {
                  i = 0;
                  ((Friends)localObject1).qqVipInfo = ((byte)i << 24);
                  if ((paramArrayOfByte.byteAt(0) & 0x8) != 0) {
                    break label3319;
                  }
                }
                for (i = 0;; i = 1)
                {
                  ((Friends)localObject1).superQqInfo = ((byte)i << 24);
                  localFriendsManager.a((Friends)localObject1);
                  ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12)).a(100, true, null);
                  if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(Long.toString(l1))) {
                    break;
                  }
                  ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).b();
                  break;
                  i = 1;
                  break label3213;
                }
              case 23107: 
                if (QLog.isColorLevel()) {
                  QLog.d("vip", 2, "svip update uin=" + l1);
                }
                paramArrayOfByte = paramArrayOfByte.bytes_value.get();
                localObject1 = Long.toString(l1);
                localObject5 = (Friends)localFriendsManager.c((String)localObject1).clone();
                if ((paramArrayOfByte.byteAt(5) & 0x20) != 0)
                {
                  bool = true;
                  if (!bool) {
                    break label3537;
                  }
                }
                for (i = 1;; i = 0)
                {
                  ((Friends)localObject5).superVipInfo = ((byte)i << 24);
                  localFriendsManager.a((Friends)localObject5);
                  if (QLog.isColorLevel()) {
                    QLog.d("vip", 2, "isSVip=" + bool + "friend.superVipInfo=" + ((Friends)localObject5).superVipInfo);
                  }
                  if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(localObject1)) {
                    break;
                  }
                  ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12)).a(100, true, null);
                  ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).b();
                  break;
                  bool = false;
                  break label3403;
                }
              case 23109: 
                paramArrayOfByte.bytes_value.get();
              case 27032: 
                label3319:
                i = ByteBuffer.wrap(paramArrayOfByte.bytes_value.get().toByteArray()).asIntBuffer().get();
                label3403:
                label3537:
                localObject1 = localFriendsManager.a(String.valueOf(l1));
                paramArrayOfByte = (byte[])localObject1;
                if (localObject1 == null)
                {
                  paramArrayOfByte = new ExtensionInfo();
                  paramArrayOfByte.uin = String.valueOf(l1);
                }
                if (paramArrayOfByte.uVipFont != i)
                {
                  paramArrayOfByte.uVipFont = i;
                  paramArrayOfByte.timestamp = System.currentTimeMillis();
                  localFriendsManager.a(paramArrayOfByte);
                }
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.BaseMessageProcessor", 2, "push, Get Font, uin=" + l1 + ", id=" + paramArrayOfByte.uVipFont);
                }
                break;
              }
            }
          }
        }
        i = k;
        break;
        if (!paramArrayOfByte.msg_mod_custom_face.has()) {
          break;
        }
        paramArrayOfByte = (SubMsgType0x27.ModCustomFace)paramArrayOfByte.msg_mod_custom_face.get();
        if ((paramArrayOfByte.uint32_type.has()) && (paramArrayOfByte.uint64_uin.has()))
        {
          localObject1 = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
          if (paramArrayOfByte.uint32_type.get() != 0) {
            break label3850;
          }
          l1 = paramArrayOfByte.uint64_uin.get();
          if (QLog.isColorLevel()) {
            QLog.d("cardpush", 2, "push a ModCustomFace  :0  Normal user uin = " + l1);
          }
          ((FriendListHandler)localObject1).b(l1 + "");
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(3, true, Long.toString(l1));
        }
        for (;;)
        {
          break;
          if (paramArrayOfByte.uint32_type.get() == 1)
          {
            l1 = paramArrayOfByte.uint64_group_code.get();
            if (QLog.isColorLevel()) {
              QLog.d("cardpush", 2, "push a ModCustomFace  :1 Troop uin = " + l1);
            }
            ((FriendListHandler)localObject1).c(l1 + "");
          }
        }
        if (!paramArrayOfByte.msg_daren_notify.has()) {
          break;
        }
        paramArrayOfByte = (SubMsgType0x27.DaRenNotify)paramArrayOfByte.msg_daren_notify.get();
        l1 = paramArrayOfByte.uint64_uin.get();
        j = paramArrayOfByte.uint32_login_days.get();
        k = paramArrayOfByte.uint32_days.get();
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(String.valueOf(l1)))
        {
          paramArrayOfByte = localFriendsManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
          if ((j != paramArrayOfByte.lLoginDays) || (k != paramArrayOfByte.lQQMasterLogindays))
          {
            paramArrayOfByte.lLoginDays = j;
            paramArrayOfByte.lQQMasterLogindays = k;
            localFriendsManager.a(paramArrayOfByte);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2).a(1, true, paramArrayOfByte);
          }
          if (QLog.isColorLevel()) {
            QLog.d("cardpush", 2, "daren notify received local data logindays=" + paramArrayOfByte.lLoginDays + ";days=" + paramArrayOfByte.lQQMasterLogindays);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("cardpush", 2, "daren notify received uin=" + l1 + ";logindays=" + j + ";days=" + k);
        }
        break;
        if (!paramArrayOfByte.msg_mod_friend_remark.has()) {
          break;
        }
        paramArrayOfByte = ((SubMsgType0x27.ModFriendRemark)paramArrayOfByte.msg_mod_friend_remark.get()).rpt_msg_frd_rmk.get().iterator();
        while (paramArrayOfByte.hasNext())
        {
          localObject1 = (SubMsgType0x27.FriendRemark)paramArrayOfByte.next();
          if (((SubMsgType0x27.FriendRemark)localObject1).uint32_type.has()) {
            if (((SubMsgType0x27.FriendRemark)localObject1).uint32_type.get() == 0)
            {
              if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a ModFriendRemark  : 0 Friend uin = " + ((SubMsgType0x27.FriendRemark)localObject1).uint64_fuin.get() + "备注 = " + ((SubMsgType0x27.FriendRemark)localObject1).bytes_rmk_name.get().toStringUtf8());
              }
              localFriendsManager.b(((SubMsgType0x27.FriendRemark)localObject1).uint64_fuin.get() + "", ((SubMsgType0x27.FriendRemark)localObject1).bytes_rmk_name.get().toStringUtf8());
              localObject4 = localFriendsManager.a(((SubMsgType0x27.FriendRemark)localObject1).uint64_fuin.get() + "");
              if (localObject4 != null)
              {
                localObject5 = ((SubMsgType0x27.FriendRemark)localObject1).bytes_rmk_name.get().toStringUtf8();
                if (!((String)localObject5).equals(((Card)localObject4).strReMark))
                {
                  ((Card)localObject4).strReMark = ((String)localObject5);
                  localFriendsManager.a((Card)localObject4);
                }
              }
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(3, true, Long.toString(((SubMsgType0x27.FriendRemark)localObject1).uint64_fuin.get()));
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(27, true, new Object[] { ((SubMsgType0x27.FriendRemark)localObject1).uint64_fuin.get() + "", ((SubMsgType0x27.FriendRemark)localObject1).bytes_rmk_name.get().toStringUtf8(), Byte.valueOf(1) });
            }
            else if (((SubMsgType0x27.FriendRemark)localObject1).uint32_type.get() == 1)
            {
              if (((SubMsgType0x27.FriendRemark)localObject1).uint64_group_code.has())
              {
                if (QLog.isColorLevel()) {
                  QLog.d("cardpush", 2, "push a ModFriendRemark  : 1 troop remarkuin = " + ((SubMsgType0x27.FriendRemark)localObject1).uint64_fuin.get() + " troopcode = " + ((SubMsgType0x27.FriendRemark)localObject1).uint64_group_code.get() + " remark = " + ((SubMsgType0x27.FriendRemark)localObject1).bytes_rmk_name.get().toStringUtf8() + "目前群备注在android上没看到有地方显示？");
                }
              }
              else if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a ModFriendRemark  : 1 troop remark uin = " + ((SubMsgType0x27.FriendRemark)localObject1).uint64_fuin.get() + " remark = " + ((SubMsgType0x27.FriendRemark)localObject1).bytes_rmk_name.get().toStringUtf8() + "目前群备注在android上没看到有地方显示？");
              }
            }
          }
        }
        break;
        break;
        if (!paramArrayOfByte.msg_mod_rich_long_nick.has()) {
          break;
        }
        localObject4 = (SubMsgType0x27.ModLongNick)paramArrayOfByte.msg_mod_rich_long_nick.get();
        paramArrayOfByte = Long.toString(((SubMsgType0x27.ModLongNick)localObject4).uint64_uin.get());
        localObject5 = ByteBuffer.wrap(((SubMsgType0x27.ModLongNick)localObject4).bytes_value.get().toByteArray());
        l1 = ((ByteBuffer)localObject5).getLong();
        localObject1 = new byte[((ByteBuffer)localObject5).remaining()];
        ((ByteBuffer)localObject5).get((byte[])localObject1);
        arrayOfFriends[i] = localFriendsManager.a(paramArrayOfByte, (byte[])localObject1, l1);
        localObject4 = localFriendsManager.a(((SubMsgType0x27.ModLongNick)localObject4).uint64_uin.get() + "");
        if (localObject4 != null)
        {
          ((Card)localObject4).vRichSign = ((byte[])localObject1);
          ((Card)localObject4).lSignModifyTime = l1;
          localFriendsManager.a((Card)localObject4);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(3, true, paramArrayOfByte);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(2, true, new String[] { paramArrayOfByte });
        i += 1;
        break;
        if (!paramArrayOfByte.msg_mod_group_profile.has()) {
          break;
        }
        localObject1 = (SubMsgType0x27.ModGroupProfile)paramArrayOfByte.msg_mod_group_profile.get();
        if (((SubMsgType0x27.ModGroupProfile)localObject1).uint64_group_code.has())
        {
          l1 = ((SubMsgType0x27.ModGroupProfile)localObject1).uint64_group_uin.get();
          l2 = ((SubMsgType0x27.ModGroupProfile)localObject1).uint64_group_code.get();
          paramArrayOfByte = localFriendsManager.a();
        }
        for (;;)
        {
          try
          {
            paramArrayOfByte.a();
            localObject1 = ((SubMsgType0x27.ModGroupProfile)localObject1).rpt_msg_group_profile_infos.get().iterator();
            if (((Iterator)localObject1).hasNext())
            {
              localObject4 = (SubMsgType0x27.GroupProfileInfo)((Iterator)localObject1).next();
              if ((!((SubMsgType0x27.GroupProfileInfo)localObject4).uint32_field.has()) || (!((SubMsgType0x27.GroupProfileInfo)localObject4).bytes_value.has())) {
                continue;
              }
              if (((SubMsgType0x27.GroupProfileInfo)localObject4).uint32_field.get() == 1)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("cardpush", 2, "push a ModGroupProfile 1--TroopName  = " + ((SubMsgType0x27.GroupProfileInfo)localObject4).bytes_value.get().toStringUtf8());
                }
                localObject5 = localTroopManager.a(l2 + "");
                if (localObject5 == null) {
                  continue;
                }
                ((TroopInfo)localObject5).troopname = ((SubMsgType0x27.GroupProfileInfo)localObject4).bytes_value.get().toStringUtf8();
                localTroopManager.b((TroopInfo)localObject5);
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(17).a(1, false, null);
                continue;
              }
            }
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            paramArrayOfByte.b();
            break;
            if (((SubMsgType0x27.GroupProfileInfo)localObject4).uint32_field.get() != 2) {
              continue;
            }
            localObject4 = ((SubMsgType0x27.GroupProfileInfo)localObject4).bytes_value.get();
            if ((localObject4 == null) || (((ByteStringMicro)localObject4).size() != 2)) {
              continue;
            }
            j = ((ByteStringMicro)localObject4).byteAt(0);
            short s = (short)(((ByteStringMicro)localObject4).byteAt(1) | j << 8);
            localObject4 = localTroopManager.a(l1 + "");
            ((TroopInfo)localObject4).troopface = s;
            if (QLog.isColorLevel()) {
              QLog.d("cardpush", 2, "push a ModGroupProfile 2--TroopHead(2bytes) = " + s);
            }
            localTroopManager.b((TroopInfo)localObject4);
            ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).c(l1 + "");
            continue;
          }
          finally
          {
            paramArrayOfByte.b();
          }
          paramArrayOfByte.c();
          paramArrayOfByte.b();
        }
        if (!paramArrayOfByte.msg_mod_group_member_profile.has()) {
          break;
        }
        Object localObject3 = (SubMsgType0x27.ModGroupMemberProfile)paramArrayOfByte.msg_mod_group_member_profile.get();
        if ((((SubMsgType0x27.ModGroupMemberProfile)localObject3).uint64_group_code.has()) && (((SubMsgType0x27.ModGroupMemberProfile)localObject3).uint64_group_uin.has()))
        {
          l1 = ((SubMsgType0x27.ModGroupMemberProfile)localObject3).uint64_group_uin.get();
          l2 = ((SubMsgType0x27.ModGroupMemberProfile)localObject3).uint64_group_code.get();
          long l3 = ((SubMsgType0x27.ModGroupMemberProfile)localObject3).uint64_uin.get();
          paramArrayOfByte = DBUtils.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l2 + "", l3 + "");
          localObject3 = ((SubMsgType0x27.ModGroupMemberProfile)localObject3).rpt_msg_group_member_profile_infos.get().iterator();
          label5830:
          label6269:
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (SubMsgType0x27.GroupMemberProfileInfo)((Iterator)localObject3).next();
            if ((((SubMsgType0x27.GroupMemberProfileInfo)localObject4).uint32_field.has()) && (((SubMsgType0x27.GroupMemberProfileInfo)localObject4).bytes_value.has()))
            {
              if (((SubMsgType0x27.GroupMemberProfileInfo)localObject4).uint32_field.get() != 1) {
                break label5830;
              }
              if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a ModGroupMemberProfile 1--Nick = " + ((SubMsgType0x27.GroupMemberProfileInfo)localObject4).bytes_value.get().toStringUtf8() + " info.bytes_value.get().size() = " + ((SubMsgType0x27.GroupMemberProfileInfo)localObject4).bytes_value.get().size());
              }
              QQProfileItem.a("cardpush", ((SubMsgType0x27.GroupMemberProfileInfo)localObject4).bytes_value.get().toByteArray(), ((SubMsgType0x27.GroupMemberProfileInfo)localObject4).bytes_value.get().size());
              localTroopManager.a(l1 + "", l3 + "", ((SubMsgType0x27.GroupMemberProfileInfo)localObject4).bytes_value.get().toStringUtf8(), -100, null, null, -100, -100, -100, -100L, -100L);
              if (paramArrayOfByte != null) {
                paramArrayOfByte.name = ((SubMsgType0x27.GroupMemberProfileInfo)localObject4).bytes_value.get().toStringUtf8();
              }
            }
            for (;;)
            {
              if (paramArrayOfByte == null) {
                break label6269;
              }
              DBUtils.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramArrayOfByte);
              localObject4 = new ArrayList();
              ((ArrayList)localObject4).add(paramArrayOfByte);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(17).a(16, true, localObject4);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(17).a(10, true, new Object[] { localObject4, Boolean.valueOf(true) });
              break;
              if (((SubMsgType0x27.GroupMemberProfileInfo)localObject4).uint32_field.get() == 2)
              {
                if (((SubMsgType0x27.GroupMemberProfileInfo)localObject4).bytes_value.get().size() == 1)
                {
                  byte b = ((SubMsgType0x27.GroupMemberProfileInfo)localObject4).bytes_value.get().byteAt(0);
                  if (QLog.isColorLevel()) {
                    QLog.d("cardpush", 2, "push a ModGroupMemberProfile 2--sex = " + b);
                  }
                  localTroopManager.a(l1 + "", l3 + "", null, -100, null, null, -100, b, -100, -100L, -100L);
                  if (paramArrayOfByte != null) {
                    paramArrayOfByte.sex = b;
                  }
                }
              }
              else if (((SubMsgType0x27.GroupMemberProfileInfo)localObject4).uint32_field.get() == 3)
              {
                localObject4 = ((SubMsgType0x27.GroupMemberProfileInfo)localObject4).bytes_value.get().toStringUtf8();
                if (QLog.isColorLevel()) {
                  QLog.d("cardpush", 2, "push a ModGroupMemberProfile 3--phone = " + (String)localObject4);
                }
                if (paramArrayOfByte != null) {
                  paramArrayOfByte.tel = ((String)localObject4);
                }
              }
              else if (((SubMsgType0x27.GroupMemberProfileInfo)localObject4).uint32_field.get() == 4)
              {
                localObject4 = ((SubMsgType0x27.GroupMemberProfileInfo)localObject4).bytes_value.get().toStringUtf8();
                if (QLog.isColorLevel()) {
                  QLog.d("cardpush", 2, "push a ModGroupMemberProfile 4--email= " + (String)localObject4);
                }
                if (paramArrayOfByte != null) {
                  paramArrayOfByte.email = ((String)localObject4);
                }
              }
              else if (((SubMsgType0x27.GroupMemberProfileInfo)localObject4).uint32_field.get() == 5)
              {
                localObject4 = ((SubMsgType0x27.GroupMemberProfileInfo)localObject4).bytes_value.get().toStringUtf8();
                if (QLog.isColorLevel()) {
                  QLog.d("cardpush", 2, "push a ModGroupMemberProfile 5--remark= " + (String)localObject4);
                }
                ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(l1 + "", l3 + "", null, -100, null, (String)localObject4, -100, -100, -100, -100L, -100L);
                if (paramArrayOfByte != null) {
                  paramArrayOfByte.memo = ((String)localObject4);
                }
              }
            }
          }
        }
        break;
        localFriendsManager.a(arrayOfFriends, i);
        return;
      }
    }
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x26");
    }
    submsgtype0x26.MsgBody localMsgBody = new submsgtype0x26.MsgBody();
    do
    {
      try
      {
        localMsgBody.mergeFrom(paramArrayOfByte);
        if (!localMsgBody.uint32_sub_cmd.has())
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x26 : msg has not body");
          }
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x26 : fail to parse submsgtype0x26.");
        return;
      }
      if ((localMsgBody.uint32_sub_cmd.get() == 1) || (localMsgBody.uint32_sub_cmd.get() == 4))
      {
        ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(17)).a(paramArrayOfByte);
        return;
      }
    } while ((localMsgBody.uint32_sub_cmd.get() != 3) || (localMsgBody.msg_subcmd_0x3_push_body.has()) || (!QLog.isColorLevel()));
    QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x26 : msg has not 0x3_push_body");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.OnLinePushMessageProcessor
 * JD-Core Version:    0.7.0.1
 */