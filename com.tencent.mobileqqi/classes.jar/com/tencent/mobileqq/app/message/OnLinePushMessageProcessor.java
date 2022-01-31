package com.tencent.mobileqq.app.message;

import IMMsgBodyPack.MsgType0x210;
import IMMsgBodyPack.MsgType0x210SubMsgType0x24;
import IMMsgBodyPack.PersonInfoChange;
import IMMsgBodyPack.PersonInfoField;
import IMMsgBodyPack.PluginNum;
import IMMsgBodyPack.SlaveMasterMsg;
import OnlinePushPack.DelMsgInfo;
import OnlinePushPack.MsgInfo;
import OnlinePushPack.SvcReqPushMsg;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.qq.taf.jce.JceInputStream;
import com.tencent.av.VideoController;
import com.tencent.av.core.AbstractNetChannel;
import com.tencent.av.gaudio.GAudioNotifyCenter;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.ContactFacade;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQGAudioMsgHandler;
import com.tencent.mobileqq.app.QQProfileItem;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.SafeCenterPushHandler;
import com.tencent.mobileqq.app.ShieldListHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.GroupActionResp;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
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
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBFixed32Field;
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
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.sharealbum.QZoneShareAlbumAssistantManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.stt.SttManager;
import com.tencent.mobileqq.subaccount.SubAccountAssistantImpl;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.systemmsg.SystemMsgController;
import com.tencent.mobileqq.systemmsg.SystemMsgUtils;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.msf.service.protocol.pb.SubMsgType0x51.MsgBody;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import fnw;
import fnx;
import fny;
import fnz;
import foa;
import friendlist.AddGroupResp;
import friendlist.DelGroupResp;
import friendlist.RenameGroupResp;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;
import localpb.richMsg.SafeMsg.SafeMoreInfo;
import mqq.app.MobileQQ;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgType0x210;
import protocol.KQQConfig.GetResourceReqInfo;
import tencent.im.group.cmd0x2dc.GroupVisitorJoinMsg;
import tencent.im.group.cmd0x2dc.VisitorJoinInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.AppTipNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.MsgBody.SubCmd0x3UpdateDiscussAppInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.AddGroup;
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
import tencent.im.s2c.msgtype0x210.submsgtype0x31.submsgtype0x31.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x35.Submsgtype0x35.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x3b.Submsgtype0x3b.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.ClearCountMsg;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.FriendSyncMsg;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.GroupSyncMsg;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x48.RecommendDeviceLock;
import tencent.im.s2c.msgtype0x210.submsgtype0x54.submsgtype0x54.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x54.submsgtype0x54.MsgBody.TaskInfo;

public class OnLinePushMessageProcessor
  extends BaseMessageProcessor
{
  public static final byte a = 1;
  public static final byte b = 2;
  public static final byte c = 3;
  public static final byte d = 6;
  public static final byte e = 9;
  public static final byte f = 10;
  public static final byte g = 11;
  public static final byte h = 15;
  public static final byte i = 7;
  public static final byte j = 22;
  private QvipSpecialCareManager jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager = null;
  public fnz a;
  private final Timer jdField_a_of_type_JavaUtilTimer = ThreadManager.a();
  public final ConcurrentHashMap a;
  
  public OnLinePushMessageProcessor(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_Fnz = new fnz(this, null);
  }
  
  private MessageRecord a(MsgInfo paramMsgInfo, long paramLong)
  {
    Object localObject = paramMsgInfo.vMsg;
    long l1 = PkgTools.a((byte[])localObject, 0);
    int k = localObject[4];
    long l2 = PkgTools.a((byte[])localObject, 5);
    long l3 = PkgTools.a((byte[])localObject, 9);
    PkgTools.a((byte[])localObject, 13);
    k = localObject[17];
    long l4 = PkgTools.a((byte[])localObject, 18);
    k = PkgTools.a((byte[])localObject, 22);
    switch (PkgTools.a((byte[])localObject, 24))
    {
    default: 
      return null;
    }
    k -= 2;
    byte[] arrayOfByte = new byte[k];
    PkgTools.b((byte[])localObject, 26, arrayOfByte, k);
    long l5 = paramMsgInfo.lFromUin;
    localObject = MessageRecordFactory.a(-1038);
    ((MessageRecord)localObject).init(paramLong, l1, l4, paramMsgInfo.strMsg, l3, -1038, 1, l2);
    ((MessageRecord)localObject).issend = 1;
    return MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject, arrayOfByte, false);
  }
  
  private void a(byte paramByte, long paramLong1, long paramLong2)
  {
    if (paramLong2 != Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue()) {}
    Handler localHandler;
    do
    {
      do
      {
        return;
      } while (paramByte != 2);
      localHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(GAudioNotifyCenter.class);
    } while (localHandler == null);
    Message localMessage = localHandler.obtainMessage(10003);
    localMessage.obj = Long.valueOf(paramLong1);
    localHandler.sendMessage(localMessage);
  }
  
  private void a(int paramInt)
  {
    ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12)).a(paramInt);
  }
  
  private void a(MsgInfo paramMsgInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "Recieved user info update");
    }
    paramMsgInfo = new JceInputStream(paramMsgInfo.vMsg);
    paramMsgInfo.setServerEncoding("utf-8");
    PersonInfoChange localPersonInfoChange = new PersonInfoChange();
    localPersonInfoChange.readFrom(paramMsgInfo);
    int m;
    int k;
    long l;
    int n;
    if (localPersonInfoChange.cType == 0)
    {
      paramMsgInfo = localPersonInfoChange.vChgField.iterator();
      m = 0;
      k = 0;
      if (paramMsgInfo.hasNext())
      {
        l = ((PersonInfoField)paramMsgInfo.next()).uField;
        if ((l == 20015L) || (l == 10009L))
        {
          n = 1;
          m = k;
          k = n;
        }
      }
    }
    for (;;)
    {
      n = m;
      m = k;
      k = n;
      break;
      if ((l == 20002L) || (l == 20009L) || (l == 20031L) || (l == 20019L))
      {
        k = m;
        m = 1;
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
        {
          paramMsgInfo = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
          if (m != 0) {
            paramMsgInfo.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
          }
          if (k != 0) {
            paramMsgInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
          }
        }
        do
        {
          return;
        } while ((localPersonInfoChange.cType != 1) || (!QLog.isColorLevel()));
        QLog.d("MessageHandler", 2, "group data update push");
      }
      else
      {
        n = k;
        k = m;
        m = n;
      }
    }
  }
  
  private void a(MsgInfo paramMsgInfo, long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    MessageRecord localMessageRecord = MessageRecordFactory.a(-1004);
    localMessageRecord.init(paramLong1, paramLong2, paramLong2, paramString, paramMsgInfo.uRealMsgTime, -1004, 3000, paramMsgInfo.uMsgTime);
    localMessageRecord.isread = true;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "----------handleC2COnlinePushMsgResp after analysis friendUin: " + paramLong2 + " msgType: " + -1004 + " friendType: " + 3000 + " shMsgSeq: " + paramMsgInfo.shMsgSeq + " msgContent: " + Utils.a(paramString));
    }
    if (!MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord, false)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord, String.valueOf(paramLong1));
    }
  }
  
  private void a(Pair paramPair1, MsgInfo paramMsgInfo, long paramLong1, long paramLong2, long paramLong3, byte paramByte, long paramLong4, Pair paramPair2)
  {
    long l1 = ((Long)paramPair1.first).longValue();
    long l2 = ((Long)paramPair2.first).longValue();
    FriendManager localFriendManager = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    paramPair1 = (String)paramPair1.second;
    if (TextUtils.isEmpty(paramPair1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor.discuss", 2, "coptype 0xb server showName empty");
      }
      paramPair1 = localFriendManager.d(String.valueOf(paramLong2), String.valueOf(l1));
    }
    for (;;)
    {
      String str = (String)paramPair2.second;
      paramPair2 = str;
      if (TextUtils.isEmpty(str))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor.discuss", 2, "coptype 0xb server shareName empty");
        }
        paramPair2 = localFriendManager.d(String.valueOf(paramLong2), String.valueOf(l2));
      }
      if (paramLong4 == 0L) {
        paramPair1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131561418, new Object[] { paramPair1 });
      }
      for (;;)
      {
        a(paramMsgInfo, paramLong1, paramLong2, paramLong3, paramPair1);
        return;
        if (paramLong4 == 1L) {
          paramPair1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131561503, new Object[] { paramPair1, paramPair2 });
        } else if (paramLong4 == 2L) {
          paramPair1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131561523, new Object[] { paramPair1 });
        } else {
          paramPair1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131561529, new Object[] { paramPair1 });
        }
      }
    }
  }
  
  private void a(Pair paramPair, MsgInfo paramMsgInfo, ArrayList paramArrayList, long paramLong, String paramString, byte paramByte)
  {
    a(paramPair, paramMsgInfo, paramArrayList, paramLong, paramString, paramByte, 0L);
  }
  
  private void a(Pair paramPair, MsgInfo paramMsgInfo, ArrayList paramArrayList, long paramLong1, String paramString, byte paramByte, long paramLong2)
  {
    long l = ((Long)paramPair.first).longValue();
    String str1 = (String)paramPair.second;
    FriendManager localFriendManager = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    StringBuffer localStringBuffer = new StringBuffer();
    int n = paramArrayList.size();
    int k = 0;
    if (k < n)
    {
      paramPair = (Pair)paramArrayList.get(k);
      String str2 = (String)paramPair.first;
      int m;
      if (Long.valueOf(str2).longValue() == paramLong1)
      {
        m = 1;
        label96:
        if (m == 0) {
          break label158;
        }
        paramPair = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131563231);
        a(paramByte, Long.valueOf(paramString).longValue(), paramLong1);
        label131:
        if (k != 0) {
          break label227;
        }
        localStringBuffer.append(paramPair);
      }
      for (;;)
      {
        k += 1;
        break;
        m = 0;
        break label96;
        label158:
        localObject = (String)paramPair.second;
        paramPair = (Pair)localObject;
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break label131;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor.discuss", 2, "showWelcomeTips server name empty cOpType:" + paramByte);
        }
        paramPair = localFriendManager.d(paramString, str2);
        break label131;
        label227:
        localStringBuffer.append("、" + paramPair);
      }
    }
    paramArrayList = new ArrayList();
    Object localObject = MessageRecordFactory.a(-1004);
    paramPair = "";
    if (paramByte == 11) {
      paramPair = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131561487, new Object[] { localStringBuffer.toString() });
    }
    if (paramByte == 22) {
      if (paramLong2 == 0L) {
        paramPair = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131561487, new Object[] { localStringBuffer.toString() });
      }
    }
    for (;;)
    {
      ((MessageRecord)localObject).init(paramLong1, paramMsgInfo.lFromUin, paramMsgInfo.lFromUin, paramPair, paramMsgInfo.uRealMsgTime, -1004, 3000, paramMsgInfo.uMsgTime);
      ((MessageRecord)localObject).shmsgseq = paramMsgInfo.shMsgSeq;
      ((MessageRecord)localObject).isread = true;
      if (!MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject, false)) {
        paramArrayList.add(localObject);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "----------handleC2COnlinePushMsgResp after analysis(showWelcomeTips) friendUin: " + ((MessageRecord)localObject).frienduin + " msgType: " + -1004 + " friendType: " + 3000 + " shMsgSeq: " + paramMsgInfo.shMsgSeq + " msgContent: " + ((MessageRecord)localObject).getLogColorContent());
      }
      if (paramArrayList.size() > 0) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramArrayList, String.valueOf(paramLong1));
      }
      return;
      if (paramLong2 == 1L)
      {
        paramPair = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131563277);
      }
      else if (paramLong2 == 2L)
      {
        paramPair = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131563278, new Object[] { localStringBuffer.toString() });
        continue;
        if (l == paramLong1)
        {
          k = 1;
          label600:
          if (k == 0) {
            break label677;
          }
          if (!QLog.isColorLevel()) {
            break label771;
          }
          paramPair = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131563269);
        }
        for (;;)
        {
          paramPair = paramPair + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131561529, new Object[] { localStringBuffer.toString() });
          break;
          k = 0;
          break label600;
          label677:
          paramPair = str1;
          if (TextUtils.isEmpty(str1))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageProcessor.discuss", 2, "showWelcomeTips server invitorName empty cOpType:" + paramByte);
            }
            paramPair = localFriendManager.d(paramString, String.valueOf(l));
          }
          paramPair = paramPair + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131561408);
          continue;
          label771:
          paramPair = "";
        }
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcReqPushMsg paramSvcReqPushMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "handleC2COnlinePushMsgResp");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.ah = paramSvcReqPushMsg.wUserActive;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "OnlinePush.ReqPush,notify.wUserActive:" + paramSvcReqPushMsg.wUserActive);
    }
    String str = (String)paramFromServiceMsg.getAttribute("_tag_LOGSTR");
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = paramSvcReqPushMsg.vMsgInfos;
    ArrayList localArrayList3;
    long l3;
    int i1;
    ArrayList localArrayList4;
    MsgInfo localMsgInfo;
    short s;
    int n;
    Object localObject;
    long l2;
    long l1;
    label260:
    long l4;
    if ((localArrayList2 != null) && (localArrayList2.size() > 0))
    {
      localArrayList3 = new ArrayList();
      BaseApplication.getContext().getSharedPreferences("share", 0).getString("no_auto_reply" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "");
      l3 = paramSvcReqPushMsg.lUin;
      i1 = paramSvcReqPushMsg.svrip;
      localArrayList4 = new ArrayList();
      Iterator localIterator = localArrayList2.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localMsgInfo = (MsgInfo)localIterator.next();
          try
          {
            new ArrayList();
            s = localMsgInfo.shMsgType;
            n = -1000;
            localObject = null;
            l2 = localMsgInfo.lFromUin;
            l1 = localMsgInfo.lFromUin;
            if (paramFromServiceMsg.getUin() == null)
            {
              paramToServiceMsg = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
              l4 = paramToServiceMsg.longValue();
              if (l4 == l2) {}
              paramToServiceMsg = new DelMsgInfo();
              ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(localMsgInfo.lFromUin);
              paramToServiceMsg.lFromUin = localMsgInfo.lFromUin;
              paramToServiceMsg.shMsgSeq = localMsgInfo.shMsgSeq;
              paramToServiceMsg.uMsgTime = localMsgInfo.uMsgTime;
              paramToServiceMsg.vMsgCookies = localMsgInfo.vMsgCookies;
              localArrayList3.add(paramToServiceMsg);
              if ((42 != s) && (83 != s) && (127 != s) && (QLog.isColorLevel())) {
                MessageHandlerUtils.a("Q.msg.BaseMessageProcessor", str, localMsgInfo.shMsgSeq, String.valueOf(l3), String.valueOf(localMsgInfo.lFromUin));
              }
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageProcessor", 2, "----------handleC2COnlinePushMsgResp  before analysis msgInfo.lFromUin: " + localMsgInfo.lFromUin + " msgInfo.shMsgType: " + localMsgInfo.shMsgType + " msgInfo.uRealMsgTime: " + localMsgInfo.uRealMsgTime + " msgInfo.shMsgSeq: " + localMsgInfo.shMsgSeq + ", msgInfo.lMsgUid" + localMsgInfo.lMsgUid);
              }
              if (169 != s) {
                break label798;
              }
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageProcessor", 2, "------->msgFilter-handleC2COnlinePushMsgResp receive msg size:" + localArrayList2.size());
              }
              if (MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, String.valueOf(l1), String.valueOf(l2), localMsgInfo.uMsgTime, localMsgInfo.shMsgSeq)) {
                continue;
              }
              localArrayList3.remove(paramToServiceMsg);
              paramToServiceMsg = new String(localMsgInfo.vMsg) + localMsgInfo.uMsgTime;
              if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramToServiceMsg)) {
                break label780;
              }
              paramToServiceMsg = new long[1];
              paramToServiceMsg[0] = localMsgInfo.lFromUin;
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageProcessor", 2, "---->handleC2COnlinePushMsgResp, new file msg, about to call handleOffLineFileResp");
              }
              a(String.valueOf(l1), l3, paramToServiceMsg, localMsgInfo.vMsg, localMsgInfo.uMsgTime, localMsgInfo.shMsgSeq, false);
              localMsgInfo.lFromUin = paramToServiceMsg[0];
            }
          }
          catch (Exception paramToServiceMsg)
          {
            paramToServiceMsg.printStackTrace();
            if ((localMsgInfo.vMsg != null) && (QLog.isColorLevel())) {
              QLog.w("Q.msg.BaseMessageProcessor", 2, "~~~~~handleC2COnlinePushMsgResp Exception msgInfo.vMsg: " + HexUtil.a(localMsgInfo.vMsg));
            }
          }
        }
      }
    }
    label2304:
    for (;;)
    {
      label742:
      boolean bool1;
      if (localMsgInfo.uAppShareID > 0L)
      {
        localArrayList4.add(AppShareIDUtil.a(localMsgInfo.uAppShareID));
        break;
        paramToServiceMsg = Long.valueOf(paramFromServiceMsg.getUin());
        break label260;
        label780:
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.msg.BaseMessageProcessor", 2, "rcv a repeated offline file push msg");
        break;
        label798:
        if (193 == s)
        {
          a(l3, localMsgInfo.vMsg, localMsgInfo.lFromUin, (int)localMsgInfo.uMsgTime);
          break;
        }
        if (s != 734) {
          break label2154;
        }
        if (QLog.isColorLevel()) {
          QLog.d("simonchwang", 2, "===========handleSharpVideoMessageResp 2========");
        }
        bool1 = AbstractNetChannel.a(localMsgInfo.vMsg);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l3, localMsgInfo.vMsg, localMsgInfo.lFromUin, (int)localMsgInfo.uMsgTime, bool1);
        break;
      }
      for (;;)
      {
        label898:
        if (paramToServiceMsg == null) {
          break label2304;
        }
        MessageRecord localMessageRecord = MessageRecordFactory.a(n);
        localMessageRecord.init(l3, l1, l2, paramToServiceMsg, localMsgInfo.uRealMsgTime, n, k, localMsgInfo.uMsgTime);
        localMessageRecord.shmsgseq = localMsgInfo.shMsgSeq;
        localMessageRecord.isread = bool1;
        localMessageRecord.msgUid = localMsgInfo.lMsgUid;
        localMessageRecord.msgData = ((byte[])localObject);
        if (m > 0) {
          localMessageRecord.extraflag = m;
        }
        if (!MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord, true)) {
          localArrayList1.add(localMessageRecord);
        }
        if (!QLog.isColorLevel()) {
          break label742;
        }
        QLog.d("Q.msg.BaseMessageProcessor", 2, "----------handleC2COnlinePushMsgResp after analysis friendUin: " + l1 + " msgType: " + n + " friendType: " + k + " shMsgSeq: " + localMsgInfo.shMsgSeq + " msgContent: " + Utils.a(paramToServiceMsg));
        break label742;
        break;
        label1088:
        if (8 == s)
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
            break label2179;
          }
        }
        else
        {
          if (132 == s)
          {
            paramToServiceMsg = new byte[4];
            if (localMsgInfo.vMsg.length > 4) {
              PkgTools.a(paramToServiceMsg, 0, localMsgInfo.vMsg, 0, 4);
            }
            l2 = PkgTools.a(paramToServiceMsg, 0);
            paramToServiceMsg = (ToServiceMsg)localObject;
            if (localMsgInfo.vMsg.length < 9) {
              break label2201;
            }
            paramToServiceMsg = new byte[localMsgInfo.vMsg.length - 9];
            PkgTools.a(paramToServiceMsg, 0, localMsgInfo.vMsg, 8, paramToServiceMsg.length);
            paramToServiceMsg = new String(MessageUtils.b(paramToServiceMsg), "utf-8");
            break label2201;
          }
          if (732 == s)
          {
            paramToServiceMsg = new byte[localMsgInfo.vMsg.length];
            PkgTools.a(paramToServiceMsg, 0, localMsgInfo.vMsg, 0, paramToServiceMsg.length);
            if (a(paramToServiceMsg, localMsgInfo.shMsgSeq)) {
              return;
            }
            if ((localMsgInfo.vMsg == null) || (localMsgInfo.vMsg.length <= 7)) {
              break label2224;
            }
            paramToServiceMsg = new byte[localMsgInfo.vMsg.length - 7];
            PkgTools.a(paramToServiceMsg, 0, localMsgInfo.vMsg, 7, paramToServiceMsg.length);
            c(paramToServiceMsg);
            break label2224;
          }
          if (230 == s)
          {
            paramToServiceMsg = new String(MessageUtils.b(localMsgInfo.vMsg), "utf-8");
            localObject = ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).c(l1 + "");
            if ((localObject == null) || (!((Friends)localObject).isFriend())) {
              break label2241;
            }
            k = 0;
            localObject = new SafeMsg.SafeMoreInfo();
            ((SafeMsg.SafeMoreInfo)localObject).strFromMobile.set(localMsgInfo.strFromMobile);
            ((SafeMsg.SafeMoreInfo)localObject).strFromName.set(localMsgInfo.strFromName);
            ((SafeMsg.SafeMoreInfo)localObject).strMsgTxt.set(paramToServiceMsg);
            localObject = ((SafeMsg.SafeMoreInfo)localObject).toByteArray();
            n = -1002;
            bool1 = true;
            m = -1;
            continue;
          }
          if (SystemMsg.isSystemMessage(s))
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(2);
            n = -1006 - (s - 187);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(l3, localMsgInfo.lFromUin, s, n);
            FriendSystemMsgController.a().a(l2, localMsgInfo.uMsgTime, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            l1 = 9998L;
            localObject = null;
            paramToServiceMsg = null;
            m = -1;
            bool1 = false;
            k = 0;
            continue;
          }
          if (SystemMsg.isTroopSystemMessage(s))
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(3);
            if (s == 45)
            {
              paramToServiceMsg = a(localMsgInfo, l3);
              if ((paramToServiceMsg == null) || (MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramToServiceMsg, true))) {
                break label2249;
              }
              localArrayList1.add(paramToServiceMsg);
              break label2249;
            }
          }
        }
        for (;;)
        {
          label1459:
          GroupSystemMsgController.a().a(l2, localMsgInfo.uMsgTime, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          localObject = null;
          paramToServiceMsg = null;
          bool1 = false;
          m = k;
          k = 0;
          break label898;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(l3, s, localMsgInfo.vMsg, localMsgInfo.lFromUin, localMsgInfo.uMsgTime, localMsgInfo.shMsgSeq);
          l1 = 9998L;
          k = 32769;
          n = SystemMsg.getTroopSystemMsgType(s);
          continue;
          if (524 == s)
          {
            paramToServiceMsg = b(localMsgInfo, l3);
            if ((paramToServiceMsg == null) || (MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramToServiceMsg, true))) {
              break label2255;
            }
            localArrayList1.add(paramToServiceMsg);
            break label2255;
          }
          if (736 == s)
          {
            a(localMsgInfo);
            paramToServiceMsg = null;
            m = -1;
            localObject = null;
            bool1 = false;
            k = 0;
            break label898;
          }
          if (528 == s)
          {
            paramToServiceMsg = c(localMsgInfo, l4);
            if ((paramToServiceMsg == null) || (MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramToServiceMsg, true))) {
              break label2272;
            }
            localArrayList1.add(paramToServiceMsg);
            break label2272;
          }
          if (526 == s)
          {
            paramToServiceMsg = new JceInputStream(localMsgInfo.vMsg);
            localObject = new SlaveMasterMsg();
            ((SlaveMasterMsg)localObject).readFrom(paramToServiceMsg);
            if (((int)((SlaveMasterMsg)localObject).uMsgType != 529) || (4L != ((SlaveMasterMsg)localObject).uCmd)) {
              break label2289;
            }
            MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), localMsgInfo, (SlaveMasterMsg)localObject);
            break;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.w("Q.msg.BaseMessageProcessor", 2, "~~~~~handleC2COnlinePushMsgResp msgtype: unknow msgType!!!");
          break;
          if (localArrayList4.size() > 0) {
            a(localArrayList4);
          }
          k = paramFromServiceMsg.getRequestSsoSeq();
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l3, localArrayList3, i1, k);
          boolean bool2;
          boolean bool3;
          if (localArrayList1.size() > 0)
          {
            bool2 = MessageHandlerUtils.a(localArrayList1);
            bool3 = MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList1);
            paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
            if ((!bool2) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause)) {
              break label2143;
            }
          }
          label2143:
          for (bool1 = true;; bool1 = false)
          {
            paramToServiceMsg.a(localArrayList1, String.valueOf(l3), bool1);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((int)paramSvcReqPushMsg.uMsgTime);
            a("handleGetBuddyMessageResp", true, localArrayList1, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(bool2, bool3), false);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localArrayList1);
            return;
          }
          paramToServiceMsg = null;
          break label2179;
          label2154:
          if (208 != s) {
            break label1088;
          }
          paramToServiceMsg = null;
          m = -1;
          localObject = null;
          bool1 = false;
          k = 0;
          break label898;
          label2179:
          k = 1000;
          n = -1000;
          m = -1;
          localObject = null;
          bool1 = false;
          break label898;
          label2201:
          n = -1000;
          m = -1;
          localObject = null;
          bool1 = false;
          k = 1020;
          break label898;
          return;
          label2224:
          paramToServiceMsg = null;
          m = -1;
          localObject = null;
          bool1 = false;
          k = 0;
          break label898;
          label2241:
          k = 1000;
          break label1459;
          label2249:
          k = -1;
        }
        label2255:
        paramToServiceMsg = null;
        int m = -1;
        localObject = null;
        bool1 = false;
        int k = 0;
        continue;
        label2272:
        paramToServiceMsg = null;
        m = -1;
        localObject = null;
        bool1 = false;
        k = 0;
        continue;
        label2289:
        paramToServiceMsg = null;
        m = -1;
        localObject = null;
        bool1 = false;
        k = 0;
      }
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
  
  private void a(ArrayList paramArrayList, String paramString1, String paramString2, String paramString3)
  {
    MessageRecord localMessageRecord = MessageRecordFactory.a(-1016);
    long l = MessageCache.a();
    if ((paramArrayList != null) && (paramArrayList.size() > 1))
    {
      int m = paramArrayList.size();
      Object localObject = "";
      int k = 1;
      while (k < m)
      {
        String str = (String)localObject + (String)paramArrayList.get(k);
        localObject = str;
        if (k != m - 1) {
          localObject = str + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131561536);
        }
        k += 1;
      }
      paramArrayList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131563276, new Object[] { localObject });
      localMessageRecord.init(paramString2, paramString1, paramString3, paramArrayList + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131563102), l, -1016, 3000, l);
      localMessageRecord.extStr = paramArrayList;
      localMessageRecord.isread = true;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord, localMessageRecord.selfuin);
    }
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
  
  /* Error */
  private boolean a(long paramLong1, long paramLong2, short paramShort)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 252	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 253	java/lang/StringBuilder:<init>	()V
    //   9: lload_1
    //   10: invokevirtual 262	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13: ldc_w 774
    //   16: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: lload_3
    //   20: invokevirtual 262	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   23: ldc_w 774
    //   26: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: iload 5
    //   31: invokevirtual 267	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   34: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: astore 7
    //   39: aload_0
    //   40: getfield 101	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   43: invokevirtual 718	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   46: invokevirtual 777	com/tencent/mobileqq/service/message/MessageCache:a	()Ljava/util/ArrayList;
    //   49: aload 7
    //   51: invokevirtual 780	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   54: ifeq +44 -> 98
    //   57: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   60: ifeq +30 -> 90
    //   63: ldc 163
    //   65: iconst_2
    //   66: new 252	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 253	java/lang/StringBuilder:<init>	()V
    //   73: ldc_w 782
    //   76: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload 7
    //   81: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 544	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   90: iconst_1
    //   91: istore 6
    //   93: aload_0
    //   94: monitorexit
    //   95: iload 6
    //   97: ireturn
    //   98: aload_0
    //   99: getfield 101	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   102: invokevirtual 718	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   105: aload 7
    //   107: invokevirtual 783	com/tencent/mobileqq/service/message/MessageCache:a	(Ljava/lang/String;)V
    //   110: iconst_0
    //   111: istore 6
    //   113: goto -20 -> 93
    //   116: astore 7
    //   118: aload_0
    //   119: monitorexit
    //   120: aload 7
    //   122: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	OnLinePushMessageProcessor
    //   0	123	1	paramLong1	long
    //   0	123	3	paramLong2	long
    //   0	123	5	paramShort	short
    //   91	21	6	bool	boolean
    //   37	69	7	str	String
    //   116	5	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	90	116	finally
    //   98	110	116	finally
  }
  
  private boolean a(byte[] paramArrayOfByte, int paramInt)
  {
    long l1 = PkgTools.a(paramArrayOfByte, 0);
    if (paramArrayOfByte[4] == 12)
    {
      int k = paramArrayOfByte[5];
      long l2 = PkgTools.a(paramArrayOfByte, 6);
      PkgTools.a(paramArrayOfByte, 10);
      long l3 = NetConnInfoCenter.getServerTime();
      int n = PkgTools.a(paramArrayOfByte, 14);
      int m = 16;
      ArrayList localArrayList = new ArrayList();
      k = 0;
      while (k < n)
      {
        long l4 = PkgTools.a(paramArrayOfByte, m);
        m += 4;
        long l5 = PkgTools.a(paramArrayOfByte, m);
        m += 4;
        localArrayList.add(new PushParam(String.valueOf(l4), l5));
        k += 1;
      }
      ((TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(44)).a(paramInt, l1, l2, l3, localArrayList);
      return true;
    }
    return false;
  }
  
  private MessageRecord b(MsgInfo paramMsgInfo, long paramLong)
  {
    Object localObject5 = paramMsgInfo.vMsg;
    long l2 = paramMsgInfo.lFromUin;
    long l1 = PkgTools.a((byte[])localObject5, 0);
    byte b1 = localObject5[4];
    Object localObject4 = new ArrayList();
    Object localObject3 = (DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6);
    Object localObject6 = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    Object localObject1 = (ContactFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49);
    Object localObject7 = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor.discuss", 2, "handleDiscussionMemchangeMsg cOpType: " + b1 + ", dwConfUin=" + l1);
    }
    long l3;
    Object localObject2;
    int n;
    int m;
    long l4;
    long l5;
    switch (b1)
    {
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 6: 
    case 9: 
      do
      {
        do
        {
          return null;
          paramLong = PkgTools.a((byte[])localObject5, 5);
          l2 = PkgTools.a((byte[])localObject5, 9);
          new StringBuilder().append(String.valueOf(l1)).append("_").append(String.valueOf(paramLong)).toString();
          if ((paramMsgInfo.vNickName != null) && (paramMsgInfo.vNickName.size() > 0)) {
            localObject1 = (String)paramMsgInfo.vNickName.get(0);
          }
          if ((paramMsgInfo.vNickName != null) && (paramMsgInfo.vNickName.size() > 1)) {
            localObject1 = (String)paramMsgInfo.vNickName.get(1);
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor.discuss", 2, "handleDiscussionMemchangeMsg discussionUin: " + l1 + " memberUin: " + l2);
          }
          if (a(l2, l1, paramMsgInfo.shMsgSeq))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageProcessor.discuss", 2, "handleDiscussionMemchangeMsg memberChangeMsgFilter return");
            }
            return null;
          }
          if (!String.valueOf(paramLong).equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
            ((DiscussionHandler)localObject3).a(String.valueOf(paramLong), l1);
          }
          ((DiscussionHandler)localObject3).a(l1);
          k = ((DiscussionManager)localObject7).a(l1 + "");
        } while (((DiscussionManager)localObject7).a(String.valueOf(l1), String.valueOf(l2)));
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor.discuss", 2, "handleDiscussionUpdateMsg add discussion " + l1 + " member number by 1 " + l2 + " num: " + k);
        }
        paramMsgInfo = new DiscussionMemberInfo();
        paramMsgInfo.discussionUin = String.valueOf(l1);
        paramMsgInfo.memberUin = String.valueOf(l2);
        paramMsgInfo.flag = 0;
        localObject1 = ((FriendsManagerImp)localObject6).c(String.valueOf(l2));
        if ((localObject1 != null) && (((Friends)localObject1).name != null)) {
          paramMsgInfo.memberName = ((Friends)localObject1).name;
        }
        ((DiscussionManager)localObject7).a(paramMsgInfo);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor.discuss", 2, "handleDiscussionMemchangeMsg setDiscussionMemberNum memnum" + k);
        }
        return null;
        l3 = PkgTools.a((byte[])localObject5, 5);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor.discuss", 2, "handleDiscussionMemchangeMsg discussionUin: " + l1 + " memberUin: " + l3);
        }
        localObject5 = String.valueOf(l3);
        if (a(l3, l1, paramMsgInfo.shMsgSeq)) {
          return null;
        }
        localObject2 = "";
        localObject1 = localObject2;
        if (paramMsgInfo.vNickName != null)
        {
          localObject1 = localObject2;
          if (paramMsgInfo.vNickName.size() > 0) {
            localObject1 = (String)paramMsgInfo.vNickName.get(0);
          }
        }
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor.discuss", 2, "coptype 2 server memberName empty");
          }
          localObject2 = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l1), (String)localObject5);
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131561524, new Object[] { localObject2 });
        ((List)localObject4).add(localObject5);
        ((DiscussionHandler)localObject3).a(l1, (String)localObject5, (List)localObject4, 10009);
        if (((String)localObject5).equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))
        {
          a(b1, l1, l3);
          ((DiscussionHandler)localObject3).a(String.valueOf(l1));
          return null;
        }
        ((DiscussionHandler)localObject3).a(l1);
        ((DiscussionManager)localObject7).a(String.valueOf(l1), String.valueOf(l3));
        a(paramMsgInfo, paramLong, l2, l2, (String)localObject1);
        return null;
        localObject1 = paramMsgInfo.getVNickName();
        l2 = PkgTools.a((byte[])localObject5, 5);
        n = PkgTools.a((byte[])localObject5, 13);
        localObject2 = new ArrayList();
        m = 15;
        for (k = 1; k < n + 1; k = (short)(k + 1))
        {
          localObject6 = (String)((ArrayList)localObject1).get(k);
          l3 = PkgTools.a((byte[])localObject5, m);
          m += 4;
          ((List)localObject4).add(String.valueOf(l3));
          ((ArrayList)localObject2).add(new Pair(String.valueOf(l3), localObject6));
          ((DiscussionHandler)localObject3).a(String.valueOf(l3), l1);
        }
        ((DiscussionHandler)localObject3).a(l1, String.valueOf(l2), (List)localObject4, 10004);
        localObject4 = new Pair(Long.valueOf(l2), ((ArrayList)localObject1).get(0));
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        if (((RecentUserProxy)localObject3).b(Long.toString(l1), 3000) != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor.discuss", 2, "handleDiscussionMemchangeMsg ru alreadyintab");
          }
          a((Pair)localObject4, paramMsgInfo, (ArrayList)localObject2, paramLong, String.valueOf(l1), b1);
          return null;
        }
        localObject2 = ((RecentUserProxy)localObject3).a(Long.toString(l1), 3000);
        RecentUtil.a((RecentUser)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        ((RecentUser)localObject2).uin = Long.toString(l1);
        ((RecentUser)localObject2).lastmsgtime = paramMsgInfo.uRealMsgTime;
        ((RecentUser)localObject2).type = 3000;
        ((RecentUserProxy)localObject3).a((RecentUser)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor.discuss", 2, "handleDiscussionMemchangeMsg ru.lastmsgtime " + paramMsgInfo.uRealMsgTime);
        }
        paramMsgInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        if (SelectMemberActivity.a) {
          SelectMemberActivity.a = false;
        }
        for (;;)
        {
          return null;
          if (TextUtils.equals(paramMsgInfo, String.valueOf(l2)))
          {
            a((ArrayList)localObject1, ((RecentUser)localObject2).uin, paramMsgInfo, paramMsgInfo);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Multi_call", "Show_discuss_tips", 0, 0, "", "", "", "");
          }
        }
        l2 = PkgTools.a((byte[])localObject5, 5);
        l3 = PkgTools.a((byte[])localObject5, 9);
        PkgTools.a((byte[])localObject5, 13);
        k = PkgTools.a((byte[])localObject5, 17);
        localObject1 = new byte[k];
        PkgTools.b((byte[])localObject5, 19, (byte[])localObject1, k);
        localObject4 = new String((byte[])localObject1);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor.discuss", 2, "cOptye:" + b1 + "dwCmdUin =" + l2 + " dwCmdTime=" + l3 + " strName=" + (String)localObject4);
        }
        if (l2 == paramLong) {}
        for (localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131563279, new Object[] { localObject4 });; localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131561416, new Object[] { localObject2, localObject4 }))
        {
          ((DiscussionHandler)localObject3).a(String.valueOf(l1), (String)localObject4);
          a(paramMsgInfo, paramLong, l1, l2, (String)localObject1);
          return null;
          localObject2 = "";
          localObject1 = localObject2;
          if (paramMsgInfo.vNickName != null)
          {
            localObject1 = localObject2;
            if (paramMsgInfo.vNickName.size() > 0) {
              localObject1 = (String)paramMsgInfo.vNickName.get(0);
            }
          }
          localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageProcessor.discuss", 2, "coptype 6 server opeaterName empty");
            }
            localObject2 = ((FriendsManagerImp)localObject6).d(String.valueOf(l1), String.valueOf(l2));
          }
        }
      } while (PkgTools.a((byte[])localObject5, 5) == 0);
      n = PkgTools.a((byte[])localObject5, 7);
      localObject3 = new ArrayList();
      k = 9;
      m = 0;
      while (m < n)
      {
        l3 = PkgTools.a((byte[])localObject5, k);
        localObject2 = "";
        localObject1 = localObject2;
        if (paramMsgInfo.vNickName != null)
        {
          localObject1 = localObject2;
          if (paramMsgInfo.vNickName.size() >= n) {
            localObject1 = (String)paramMsgInfo.vNickName.get(m);
          }
        }
        ((ArrayList)localObject3).add(new Pair(Long.valueOf(l3), localObject1));
        k += 4;
        m += 1;
      }
      m = PkgTools.a((byte[])localObject5, k);
      localObject1 = new byte[m];
      PkgTools.b((byte[])localObject5, k + 2, (byte[])localObject1, m);
      localObject1 = new String((byte[])localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor.discuss", 2, "cOptye:9 +uinList.size()=" + ((ArrayList)localObject3).size());
      }
      localObject2 = ((ArrayList)localObject3).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (Pair)((Iterator)localObject2).next();
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor.discuss", 2, "cOptye:9 +遍历uin uin=" + ((Pair)localObject4).first);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor.discuss", 2, "cOptye:9 +sTips=" + (String)localObject1 + "+lUin=" + paramLong);
      }
      this.jdField_a_of_type_JavaUtilTimer.schedule(new fnw(this, (ArrayList)localObject3, paramLong, l1, (String)localObject1, paramMsgInfo, l2), 2000L);
      return null;
    case 22: 
      l3 = PkgTools.a((byte[])localObject5, 5);
      PkgTools.a((byte[])localObject5, 9);
      l4 = PkgTools.a((byte[])localObject5, 13);
      l5 = PkgTools.a((byte[])localObject5, 17);
      if (l5 == 0L) {
        break;
      }
    }
    for (int k = 1;; k = 0)
    {
      localObject2 = "";
      localObject1 = localObject2;
      if (paramMsgInfo.vNickName != null)
      {
        localObject1 = localObject2;
        if (paramMsgInfo.vNickName.size() >= 1) {
          localObject1 = (String)paramMsgInfo.vNickName.get(0);
        }
      }
      localObject6 = new Pair(Long.valueOf(l3), localObject1);
      Object localObject8;
      switch ((int)l4)
      {
      default: 
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        if (((RecentUserProxy)localObject1).b(Long.toString(l1), 3000) != null) {
          return null;
        }
        break;
      case 0: 
      case 1: 
      case 2: 
        n = PkgTools.a((byte[])localObject5, 25);
        m = 27;
        localObject2 = "";
        localObject1 = localObject2;
        if (k != 0)
        {
          localObject1 = localObject2;
          if (paramMsgInfo.vNickName != null)
          {
            localObject1 = localObject2;
            if (paramMsgInfo.vNickName.size() >= 2) {
              localObject1 = (String)paramMsgInfo.vNickName.get(1);
            }
          }
        }
        localObject7 = new Pair(Long.valueOf(l5), localObject1);
        ((DiscussionHandler)localObject3).a(l1);
        localObject8 = new ArrayList();
        if (k != 0) {}
        for (k = 1;; k = 0)
        {
          int i1 = k + 1;
          k = 0;
          while (k < n)
          {
            String str = String.valueOf(PkgTools.a((byte[])localObject5, m));
            localObject2 = "";
            localObject1 = localObject2;
            if (paramMsgInfo.vNickName != null)
            {
              localObject1 = localObject2;
              if (paramMsgInfo.vNickName.size() >= n + i1) {
                localObject1 = (String)paramMsgInfo.vNickName.get(k + i1);
              }
            }
            ((ArrayList)localObject8).add(new Pair(str, localObject1));
            ((List)localObject4).add(str);
            ((DiscussionHandler)localObject3).a(str, l1);
            m += 4;
            k += 1;
          }
        }
        k = 0;
        if (l4 == 0L) {
          k = 10007;
        }
        for (;;)
        {
          ((DiscussionHandler)localObject3).a(l1, String.valueOf(l3), (List)localObject4, k);
          this.jdField_a_of_type_JavaUtilTimer.schedule(new fnx(this, l3, paramLong, (Pair)localObject6, paramMsgInfo, l1, l2, b1, l4, (Pair)localObject7, (ArrayList)localObject8), 2000L);
          break;
          if (l4 == 1L) {
            k = 10006;
          } else if (l4 == 2L) {
            k = 10008;
          }
        }
      }
      localObject2 = ((RecentUserProxy)localObject1).a(Long.toString(l1), 3000);
      ((RecentUser)localObject2).uin = Long.toString(l1);
      ((RecentUser)localObject2).lastmsgtime = paramMsgInfo.uRealMsgTime;
      ((RecentUser)localObject2).type = 3000;
      ((RecentUserProxy)localObject1).a((RecentUser)localObject2);
      return null;
      PkgTools.a((byte[])localObject5, 5);
      l2 = PkgTools.a((byte[])localObject5, 9);
      switch (localObject5[13])
      {
      default: 
        return null;
      }
      k = localObject5[14];
      PkgTools.a((byte[])localObject5, 15);
      PkgTools.a((byte[])localObject5, 17);
      k = PkgTools.a((byte[])localObject5, 21);
      localObject1 = new byte[k];
      PkgTools.b((byte[])localObject5, 23, (byte[])localObject1, k);
      l3 = paramMsgInfo.lFromUin;
      localObject2 = MessageRecordFactory.a(-1038);
      ((MessageRecord)localObject2).init(paramLong, l1, l1, paramMsgInfo.strMsg, l2, -1038, 3000, paramMsgInfo.uMsgTime);
      ((MessageRecord)localObject2).issend = 1;
      return MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject2, (byte[])localObject1, false);
      l3 = PkgTools.a((byte[])localObject5, 5);
      PkgTools.a((byte[])localObject5, 9);
      k = PkgTools.a(localObject5[13]);
      PkgTools.a((byte[])localObject5, 14, k);
      k += 14;
      n = PkgTools.a((byte[])localObject5, k);
      m = k + 2;
      localObject1 = new HashSet();
      k = 0;
      while (k < n)
      {
        l4 = PkgTools.a((byte[])localObject5, m);
        m += 4;
        ((HashSet)localObject1).add(String.valueOf(l4));
        ((List)localObject4).add(String.valueOf(l4));
        k += 1;
      }
      if (((HashSet)localObject1).size() <= 0) {
        break;
      }
      localObject2 = (DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6);
      localObject3 = String.valueOf(l1);
      if (((HashSet)localObject1).contains(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))
      {
        ((DiscussionHandler)localObject2).a((String)localObject3);
        a(paramMsgInfo, paramLong, l2, l2, BaseApplication.getContext().getString(2131559195));
      }
      for (;;)
      {
        ((DiscussionHandler)localObject2).a(l1, String.valueOf(l3), (List)localObject4, 10005);
        return null;
        ((DiscussionHandler)localObject2).a((String)localObject3, (HashSet)localObject1);
      }
      l3 = PkgTools.a((byte[])localObject5, 5);
      PkgTools.a((byte[])localObject5, 9);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor.discuss", 2, "handleDiscussionMemchangeMsg discussionUin: " + l1 + " memberUin: " + l3);
      }
      localObject7 = String.valueOf(l3);
      if (a(l3, l1, paramMsgInfo.shMsgSeq)) {
        return null;
      }
      if (((String)localObject7).equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
        return null;
      }
      localObject2 = "";
      localObject1 = localObject2;
      if (paramMsgInfo.vNickName != null)
      {
        localObject1 = localObject2;
        if (paramMsgInfo.vNickName.size() > 0) {
          localObject1 = (String)paramMsgInfo.vNickName.get(0);
        }
      }
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor.discuss", 2, "coptype 2 server memberName empty");
        }
        localObject1 = ((FriendsManagerImp)localObject6).d(String.valueOf(l1), (String)localObject7);
      }
      for (;;)
      {
        n = PkgTools.a((byte[])localObject5, 13);
        m = 15;
        localObject8 = new HashSet();
        k = 0;
        while (k < n)
        {
          l3 = PkgTools.a((byte[])localObject5, m);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor.discuss", 2, "handleDiscussionMemchangeMsg MSG_DISCUSSION_TYPE_KICKOUT_MEMBER uin=" + l3);
          }
          m += 4;
          ((HashSet)localObject8).add(String.valueOf(l3));
          ((List)localObject4).add(String.valueOf(l3));
          k += 1;
        }
        localObject2 = new StringBuffer();
        if (((HashSet)localObject8).size() > 0)
        {
          localObject5 = ((HashSet)localObject8).iterator();
          while (((Iterator)localObject5).hasNext()) {
            ((StringBuffer)localObject2).append(((FriendsManagerImp)localObject6).d(String.valueOf(l1), (String)((Iterator)localObject5).next())).append("、");
          }
        }
        if (((StringBuffer)localObject2).length() > 0) {}
        for (localObject2 = ((StringBuffer)localObject2).deleteCharAt(((StringBuffer)localObject2).toString().length() - 1).toString();; localObject2 = "")
        {
          localObject5 = (DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6);
          ((DiscussionHandler)localObject5).a(l1, (String)localObject7, (List)localObject4, 10005);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131561526, new Object[] { localObject2 });
          if (((HashSet)localObject8).contains(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))
          {
            ((DiscussionHandler)localObject5).a(String.valueOf(l1));
            a(paramMsgInfo, paramLong, l2, l2, BaseApplication.getContext().getString(2131559195));
            return null;
          }
          localObject1 = BaseApplication.getContext().getString(2131559196, new Object[] { localObject1, localObject2 });
          ((DiscussionHandler)localObject5).a(String.valueOf(l1), (HashSet)localObject8);
          ((DiscussionHandler)localObject3).a(l1);
          a(paramMsgInfo, paramLong, l2, l2, (String)localObject1);
          return null;
        }
      }
    }
  }
  
  private foa b(int paramInt, MsgInfo paramMsgInfo, SvcReqPushMsg paramSvcReqPushMsg)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(OnLinePushMsgTypeProcessorDispatcher.a(paramInt)).a(OnLinePushMsgTypeProcessorDispatcher.a(String.valueOf(paramInt)), paramMsgInfo, paramSvcReqPushMsg);
  }
  
  private void b(long paramLong, byte[] paramArrayOfByte)
  {
    Object localObject = new submsgtype0x31.MsgBody();
    try
    {
      paramArrayOfByte = (submsgtype0x31.MsgBody)((submsgtype0x31.MsgBody)localObject).mergeFrom(paramArrayOfByte);
      if (paramArrayOfByte == null)
      {
        paramArrayOfByte = new HashMap();
        paramArrayOfByte.put("param_FailCode", "12017");
        paramArrayOfByte.put("fail_step", "msgbyod_null");
        paramArrayOfByte.put("fail_location", "MessageHandler");
        StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "actSBPushNotifaction", false, 0L, 0L, paramArrayOfByte, "");
        return;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      int k;
      long l1;
      do
      {
        long l2;
        do
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.msg.BaseMessageProcessor", 2, "<---decodeC2CMsgPkg_SecretfileReport parse failed.", paramArrayOfByte);
            }
            paramArrayOfByte = null;
          }
          if ((!paramArrayOfByte.uint32_flag.has()) || (!paramArrayOfByte.uint64_bind_uin.has()) || (!paramArrayOfByte.uint64_uin.has()))
          {
            paramArrayOfByte = new HashMap();
            paramArrayOfByte.put("param_FailCode", "12017");
            paramArrayOfByte.put("fail_step", "uinflag_null");
            paramArrayOfByte.put("fail_location", "MessageHandler");
            StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "actSBPushNotifaction", false, 0L, 0L, paramArrayOfByte, "");
            return;
          }
          k = paramArrayOfByte.uint32_flag.get();
          l1 = paramArrayOfByte.uint32_time.get();
          l1 = paramArrayOfByte.uint64_uin.get();
          l2 = paramArrayOfByte.uint64_bind_uin.get();
          if ((l1 <= 0L) || (l2 <= 0L))
          {
            paramArrayOfByte = new HashMap();
            paramArrayOfByte.put("param_FailCode", "12017");
            paramArrayOfByte.put("fail_step", "uin_error");
            paramArrayOfByte.put("fail_location", "MessageHandler");
            StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "actSBPushNotifaction", false, 0L, 0L, paramArrayOfByte, "");
            return;
          }
        } while (!String.valueOf(paramLong).equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()));
        localObject = new SubAccountBackProtocData();
        ((SubAccountBackProtocData)localObject).c = String.valueOf(l1);
        ((SubAccountBackProtocData)localObject).b = String.valueOf(l2);
        paramArrayOfByte = new HashMap();
        paramArrayOfByte.put("param_FailCode", "12018");
        paramArrayOfByte.put("fail_step", "success_" + k);
        paramArrayOfByte.put("fail_location", "MessageHandler");
        StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "actSBPushNotifaction", true, 0L, 0L, paramArrayOfByte, "");
        SubAccountAssistantImpl.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, System.currentTimeMillis() / 1000L);
        if (k == 1) {
          for (;;)
          {
            try
            {
              paramArrayOfByte = SubAccountAssistantImpl.a().a();
              SubAccountAssistantImpl localSubAccountAssistantImpl = SubAccountAssistantImpl.a();
              QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              paramLong = Long.parseLong(String.valueOf(l1));
              if (paramArrayOfByte != null) {
                continue;
              }
              paramArrayOfByte = null;
              localSubAccountAssistantImpl.a(localQQAppInterface, (byte)1, paramLong, paramArrayOfByte, 21);
            }
            catch (Exception paramArrayOfByte)
            {
              paramArrayOfByte.printStackTrace();
              continue;
            }
            SubAccountAssistantImpl.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            DBUtils.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 1);
            ((SubAccountBackProtocData)localObject).p = 1;
            a(8004, true, localObject);
            return;
            paramArrayOfByte = HexUtil.a(paramArrayOfByte);
          }
        }
      } while (k != 0);
      SubAccountAssistantImpl.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      DBUtils.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
      SubAccountAssistantImpl.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l1));
      if (SubAccountAssistantImpl.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l1))) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSubAccountKey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), String.valueOf(l1), new fny(this));
      }
      ((SubAccountBackProtocData)localObject).p = 0;
      a(8004, true, localObject);
    }
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
  
  private MessageRecord c(MsgInfo paramMsgInfo, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cardpush", 2, "get a push message MsgType0x210");
    }
    Object localObject5 = GameCenterPackeger.a(paramMsgInfo.vMsg);
    if (localObject5 == null) {
      return null;
    }
    Object localObject1;
    Object localObject2;
    if ((((MsgType0x210)localObject5).uSubMsgType == 36L) && (((MsgType0x210)localObject5).stMsgInfo0x24 != null))
    {
      paramMsgInfo = ((MsgType0x210)localObject5).stMsgInfo0x24;
      if ((paramMsgInfo != null) && (paramMsgInfo.vPluginNumList != null))
      {
        localObject1 = paramMsgInfo.vPluginNumList;
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          paramMsgInfo = (GameCenterManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
          if (paramMsgInfo != null)
          {
            localObject1 = ((List)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (PluginNum)((Iterator)localObject1).next();
              if (localObject2 != null)
              {
                paramLong = ((PluginNum)localObject2).dwID;
                if (((PluginNum)localObject2).cFlag == 0) {}
                for (boolean bool = false;; bool = true)
                {
                  paramMsgInfo.a(paramLong, bool, ((PluginNum)localObject2).dwNUm);
                  break;
                }
              }
            }
          }
        }
      }
      paramMsgInfo = null;
    }
    int k;
    for (;;)
    {
      return paramMsgInfo;
      if (((MsgType0x210)localObject5).vProtobuf == null) {
        break label1986;
      }
      if (((MsgType0x210)localObject5).uSubMsgType == 39L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("cardpush", 2, "get a push message");
        }
        a(((MsgType0x210)localObject5).vProtobuf);
        paramMsgInfo = null;
      }
      else if ((((MsgType0x210)localObject5).uSubMsgType == 40L) || (((MsgType0x210)localObject5).uSubMsgType == 63L))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Hyim", 2, "get a push message for public account handler");
        }
        ((PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(10)).a(((MsgType0x210)localObject5).uSubMsgType, ((MsgType0x210)localObject5).vProtobuf);
        paramMsgInfo = null;
      }
      else if (((MsgType0x210)localObject5).uSubMsgType == 48L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShieldListSvrPush", 2, "<---receive shieldlist push : forward to shieldlisthandler");
        }
        ((ShieldListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(17)).a(((MsgType0x210)localObject5).vProtobuf);
        paramMsgInfo = null;
      }
      else if (((MsgType0x210)localObject5).uSubMsgType == 49L)
      {
        b(paramLong, ((MsgType0x210)localObject5).vProtobuf);
        paramMsgInfo = null;
      }
      else
      {
        if (((MsgType0x210)localObject5).uSubMsgType != 53L) {
          break;
        }
        try
        {
          k = ((Submsgtype0x35.MsgBody)new Submsgtype0x35.MsgBody().mergeFrom(((MsgType0x210)localObject5).vProtobuf)).uint32_bubble_timestamp.get();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "bubble push timestamp=" + k);
          }
          ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12)).e();
          paramMsgInfo = null;
        }
        catch (Exception paramMsgInfo)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.msg.BaseMessageProcessor", 2, "<---decodeC2CMsgPkg_SecretfileReport parse failed.", paramMsgInfo);
          }
          paramMsgInfo = null;
        }
      }
    }
    if (((MsgType0x210)localObject5).uSubMsgType == 59L) {}
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("troop_level_info_change", 2, "receive troop member level switch or map change push");
        }
        localObject1 = new Submsgtype0x3b.MsgBody();
        ((Submsgtype0x3b.MsgBody)localObject1).mergeFrom(((MsgType0x210)localObject5).vProtobuf);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder().append("group code: ");
          if (!((Submsgtype0x3b.MsgBody)localObject1).uint64_group_code.has()) {
            break label2084;
          }
          paramMsgInfo = String.valueOf(((Submsgtype0x3b.MsgBody)localObject1).uint64_group_code.get());
          localObject2 = ((StringBuilder)localObject2).append(paramMsgInfo).append(" user switch: ");
          if (((Submsgtype0x3b.MsgBody)localObject1).uint32_user_show_flag.has())
          {
            paramMsgInfo = String.valueOf(((Submsgtype0x3b.MsgBody)localObject1).uint32_user_show_flag.get());
            QLog.e("troop_level_info_change", 2, paramMsgInfo + " level map changed: " + ((Submsgtype0x3b.MsgBody)localObject1).uint32_member_level_changed.has());
          }
        }
        else
        {
          if (!((Submsgtype0x3b.MsgBody)localObject1).uint64_group_code.has()) {
            break label2079;
          }
          if (((Submsgtype0x3b.MsgBody)localObject1).uint32_user_show_flag.has())
          {
            k = ((Submsgtype0x3b.MsgBody)localObject1).uint32_user_show_flag.get();
            paramLong = ((Submsgtype0x3b.MsgBody)localObject1).uint64_group_code.get();
            paramMsgInfo = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
            localObject2 = paramMsgInfo.a(String.valueOf(paramLong));
            ((TroopInfo)localObject2).cGroupRankUserFlag = ((byte)k);
            paramMsgInfo.b((TroopInfo)localObject2);
          }
          if (!((Submsgtype0x3b.MsgBody)localObject1).uint32_member_level_changed.has()) {
            break label2079;
          }
          paramLong = ((Submsgtype0x3b.MsgBody)localObject1).uint64_group_code.get();
          ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(19)).f(String.valueOf(paramLong));
          break label2079;
        }
        paramMsgInfo = "";
        continue;
      }
      catch (Exception paramMsgInfo)
      {
        if (QLog.isColorLevel()) {
          QLog.e("troop_level_info_change", 2, "failed to parse Submsgtype0x3b.MsgBody");
        }
        paramMsgInfo = null;
      }
      if (((MsgType0x210)localObject5).uSubMsgType == 61L)
      {
        ((SttManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(15)).a(((MsgType0x210)localObject5).vProtobuf);
        paramMsgInfo = null;
        break;
      }
      if (((MsgType0x210)localObject5).uSubMsgType == 65L)
      {
        localObject1 = ((MsgType0x210)localObject5).vProtobuf;
        localObject2 = MessageRecordFactory.a(-1038);
        ((MessageRecord)localObject2).init(paramLong, paramMsgInfo.lFromUin, paramMsgInfo.lFromUin, paramMsgInfo.strMsg, paramMsgInfo.uRealMsgTime, -1038, 0, paramMsgInfo.uMsgTime);
        ((MessageRecord)localObject2).issend = 1;
        paramMsgInfo = MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject2, (byte[])localObject1, true);
        break;
      }
      if (((MsgType0x210)localObject5).uSubMsgType == 67L)
      {
        ConfigHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MsgType0x210)localObject5).vProtobuf);
        paramMsgInfo = null;
        break;
      }
      if ((localObject5 != null) && (((MsgType0x210)localObject5).uSubMsgType == 68L) && (((MsgType0x210)localObject5).vProtobuf != null))
      {
        a(paramLong, ((MsgType0x210)localObject5).vProtobuf);
        paramMsgInfo = null;
        break;
      }
      if ((((MsgType0x210)localObject5).uSubMsgType == 38L) && (((MsgType0x210)localObject5).vProtobuf != null))
      {
        b(((MsgType0x210)localObject5).vProtobuf);
        paramMsgInfo = null;
        break;
      }
      Object localObject3;
      if ((((MsgType0x210)localObject5).uSubMsgType == 72L) && (((MsgType0x210)localObject5).vProtobuf != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("DevLock", 2, "recv msg0x210.Submsgtype0x48");
        }
        paramMsgInfo = new RecommendDeviceLock();
        try
        {
          paramMsgInfo.mergeFrom(((MsgType0x210)localObject5).vProtobuf);
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("canCancel", paramMsgInfo.canCancel.get());
          ((Intent)localObject1).putExtra("tipMsg", paramMsgInfo.wording.get());
          ((Intent)localObject1).putExtra("title", paramMsgInfo.str_title.get());
          ((Intent)localObject1).putExtra("secondTitle", paramMsgInfo.str_second_title.get());
          ((Intent)localObject1).putExtra("thirdTitle", paramMsgInfo.str_third_title.get());
          localObject2 = paramMsgInfo.str_wording_list.get();
          localObject3 = new ArrayList();
          if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
            ((ArrayList)localObject3).addAll((Collection)localObject2);
          }
          ((Intent)localObject1).putStringArrayListExtra("wordsList", (ArrayList)localObject3);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setDevLockIntent((Intent)localObject1);
          a(8007, true, new Object[] { Boolean.valueOf(paramMsgInfo.canCancel.get()), paramMsgInfo.wording.get(), paramMsgInfo.str_title.get(), paramMsgInfo.str_second_title.get(), paramMsgInfo.str_third_title.get(), localObject3 });
        }
        catch (Exception paramMsgInfo)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("DevLock", 2, "failed to parse msg0x210.Submsgtype0x48");
            }
            a(8007, false, new Object[] { Boolean.valueOf(true), "" });
          }
        }
        paramMsgInfo = null;
        break;
      }
      Object localObject4;
      long l;
      int m;
      if ((((MsgType0x210)localObject5).uSubMsgType == 81L) && (((MsgType0x210)localObject5).vProtobuf != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("DevLock", 2, "recv msg0x210.Submsgtype0x51");
        }
        new SubMsgType0x51.MsgBody();
        localObject1 = null;
        localObject2 = null;
        localObject3 = null;
        try
        {
          localObject4 = new SubMsgType0x51.MsgBody();
          ((SubMsgType0x51.MsgBody)localObject4).mergeFrom(((MsgType0x210)localObject5).vProtobuf);
          if (((SubMsgType0x51.MsgBody)localObject4).bytes_qrsig_url.has()) {
            localObject1 = new String(((SubMsgType0x51.MsgBody)localObject4).bytes_qrsig_url.get().toByteArray(), "utf-8");
          }
          if (((SubMsgType0x51.MsgBody)localObject4).bytes_hint1.has()) {
            localObject2 = new String(((SubMsgType0x51.MsgBody)localObject4).bytes_hint1.get().toByteArray(), "utf-8");
          }
          if (((SubMsgType0x51.MsgBody)localObject4).bytes_hint2.has()) {
            localObject3 = new String(((SubMsgType0x51.MsgBody)localObject4).bytes_hint2.get().toByteArray(), "utf-8");
          }
          if (QLog.isColorLevel()) {
            QLog.d("DevLock", 2, "recv devlock quicklogin push qrcode=" + (String)localObject1 + " maintip=" + (String)localObject2 + " smalltip" + (String)localObject3);
          }
          EquipmentLockImpl.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, (String)localObject2, (String)localObject3);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("DevLock", 2, "failed to parse msg0x210.Submsgtype0x51");
            }
          }
        }
        paramLong = paramMsgInfo.lFromUin;
        k = paramMsgInfo.shMsgSeq;
        l = paramMsgInfo.lMsgUid;
        m = paramMsgInfo.shMsgType;
        MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramLong, k, l, m);
        paramMsgInfo = null;
        break;
      }
      if (((MsgType0x210)localObject5).uSubMsgType == 75L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "ShareAlbum receive push:");
        }
        QZoneShareAlbumAssistantManager.a().a(((MsgType0x210)localObject5).vProtobuf, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        paramMsgInfo = null;
        break;
      }
      if ((((MsgType0x210)localObject5).uSubMsgType == 74L) && (((MsgType0x210)localObject5).vProtobuf != null))
      {
        ((SafeCenterPushHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(24)).a(((MsgType0x210)localObject5).vProtobuf);
        paramMsgInfo = null;
        break;
      }
      if ((((MsgType0x210)localObject5).uSubMsgType == 84L) && (((MsgType0x210)localObject5).vProtobuf != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQOperateVoIP", 2, "get voip_tips from handleC2COnlinePushMsg0x210Resp");
        }
        paramMsgInfo = (ConfigHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(4);
        if (paramMsgInfo != null)
        {
          submsgtype0x54.MsgBody localMsgBody = new submsgtype0x54.MsgBody();
          try
          {
            localMsgBody.mergeFrom(((MsgType0x210)localObject5).vProtobuf);
            k = localMsgBody.peer_type.get();
            localObject3 = localMsgBody.task_list.get();
            localObject2 = new ArrayList();
            if ((localObject3 != null) && (((List)localObject3).size() > 0))
            {
              localObject3 = ((List)localObject3).iterator();
              while (((Iterator)localObject3).hasNext())
              {
                localObject4 = (submsgtype0x54.MsgBody.TaskInfo)((Iterator)localObject3).next();
                localObject5 = new QQOperationViopTipTask();
                ((QQOperationViopTipTask)localObject5).taskid = ((submsgtype0x54.MsgBody.TaskInfo)localObject4).task_id.get();
                ((ArrayList)localObject2).add(localObject5);
              }
            }
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
          {
            for (;;)
            {
              localInvalidProtocolBufferMicroException.printStackTrace();
            }
            paramLong = localMsgBody.peer_uin.get();
            if (k != 1) {}
          }
        }
        for (k = 0;; k = 3000)
        {
          paramMsgInfo.a(String.valueOf(paramLong), k, localInvalidProtocolBufferMicroException);
          paramMsgInfo = null;
          break;
        }
        label1986:
        if ((((MsgType0x210)localObject5).uSubMsgType == 78L) && (((MsgType0x210)localObject5).vProtobuf != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopNotificationHelper", 2, "get notice from handleC2COnlinePushMsg0x210Resp");
          }
          MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MsgType0x210)localObject5).vProtobuf);
          paramLong = paramMsgInfo.lFromUin;
          k = paramMsgInfo.shMsgSeq;
          l = paramMsgInfo.lMsgUid;
          m = paramMsgInfo.shMsgType;
          MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramLong, k, l, m);
        }
      }
      paramMsgInfo = null;
      break;
      label2079:
      paramMsgInfo = null;
      break;
      label2084:
      paramMsgInfo = "";
    }
  }
  
  private void c(byte[] paramArrayOfByte)
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
      return;
    }
    catch (Exception paramArrayOfByte) {}
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
        break label1047;
      }
    }
    int k;
    label344:
    Object localObject1;
    Object localObject2;
    if (paramArrayOfByte.msg_friend_msg_sync.get() != null) {
      if (a(paramArrayOfByte.msg_friend_msg_sync.uint32_processflag.get()))
      {
        k = 1;
        if (c(paramArrayOfByte.msg_friend_msg_sync.uint32_processtype.get()))
        {
          localObject1 = String.valueOf(paramArrayOfByte.msg_friend_msg_sync.uint64_fuin.get());
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (StringUtil.d((String)localObject1)))
          {
            localObject2 = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
            if (((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(String.valueOf(paramLong), String.valueOf(localObject1), 0)) {
              ((FriendsManagerImp)localObject2).a((String)localObject1, false);
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_friend_msg_sync uint32_processflag=" + paramArrayOfByte.msg_friend_msg_sync.uint32_processflag.get() + ";uint32_processtype=" + paramArrayOfByte.msg_friend_msg_sync.uint32_processtype.get());
        }
      }
    }
    label1027:
    label1047:
    for (int m = k;; m = 0)
    {
      if ((paramArrayOfByte.msg_group_msg_sync.has()) && (paramArrayOfByte.msg_group_msg_sync.get() != null)) {
        if (a(paramArrayOfByte.msg_group_msg_sync.uint32_processflag.get()))
        {
          k = 1;
          label545:
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
                ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(19)).a(localTroopInfo.troopuin, (byte)1, localTroopInfo.dwTimeStamp, 0);
              }
              a(2001, true, null);
            }
          }
          n = k;
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_group_msg_sync uint32_processflag=" + paramArrayOfByte.msg_group_msg_sync.uint32_processflag.get() + ";uint32_msg_type=" + paramArrayOfByte.msg_group_msg_sync.uint32_msg_type.get());
          }
        }
      }
      for (int n = k;; n = 0)
      {
        if ((m != 0) || (n != 0))
        {
          if ((m == 0) || (n == 0)) {
            break label991;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a().a(4);
        }
        for (;;)
        {
          if ((!paramArrayOfByte.msg_clean_count_msg.has()) || (paramArrayOfByte.msg_clean_count_msg.get() == null)) {
            break label1027;
          }
          if (a(paramArrayOfByte.msg_clean_count_msg.uint32_processflag.get()))
          {
            SystemMsgController.a().c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(AppConstants.ag, 9000, 0 - GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
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
          label991:
          if (m != 0) {
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a().a(2);
          } else if (n != 0) {
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a().a(3);
          }
        }
        break;
        k = 0;
        break label545;
      }
      k = 0;
      break label344;
    }
  }
  
  public void a(long paramLong1, byte[] paramArrayOfByte, long paramLong2, int paramInt)
  {
    if (VideoController.b() == 2)
    {
      if (paramArrayOfByte[2] == 1) {
        VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, 8, true, String.valueOf(paramLong2), String.valueOf(paramLong1), false, null, false);
      }
      return;
    }
    if (paramArrayOfByte != null) {}
    for (String str = String.valueOf(paramArrayOfByte[2]);; str = "null")
    {
      if (QLog.isColorLevel()) {
        QLog.d("svenxu", 2, "Decode video message: selfUin = " + paramLong1 + " " + "fromUin = " + paramLong2 + " " + "buffer[2] = " + str);
      }
      Friends localFriends = ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).c(String.valueOf(paramLong2));
      boolean bool = false;
      Object localObject2;
      Object localObject1;
      short s;
      if (localFriends != null)
      {
        localObject2 = localFriends.name;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((String)localObject2).trim().length() != 0) {}
        }
        else
        {
          localObject1 = String.valueOf(paramLong2);
        }
        s = localFriends.faceid;
        bool = localFriends.isFriend();
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("svenxu", 2, "isFriend: " + bool);
        }
        localObject2 = new Intent("tencent.video.q2v.RecvVideoCall");
        ((Intent)localObject2).setClassName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getPackageName(), "com.tencent.av.VideoMsgBroadcastReceiver");
        ((Intent)localObject2).putExtra("m2m", false);
        ((Intent)localObject2).putExtra("uin", String.valueOf(paramLong1));
        ((Intent)localObject2).putExtra("fromUin", String.valueOf(paramLong2));
        ((Intent)localObject2).putExtra("faceID", s);
        ((Intent)localObject2).putExtra("buffer", paramArrayOfByte);
        ((Intent)localObject2).putExtra("time", paramInt);
        ((Intent)localObject2).putExtra("name", (String)localObject1);
        ((Intent)localObject2).putExtra("isFriend", bool);
        ((Intent)localObject2).putExtra("isPttRecordingOrPlaying", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.s());
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast((Intent)localObject2);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("svenxu", 2, "Send video recv broadcast: selfUin = " + paramLong1 + " " + "fromUin = " + paramLong2 + " " + "buffer[2] = " + str);
        return;
        localObject1 = String.valueOf(paramLong2);
        s = 0;
      }
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
    for (;;)
    {
      try
      {
        SubMsgType0x51.MsgBody localMsgBody = new SubMsgType0x51.MsgBody();
        localMsgBody.mergeFrom(paramMsgType0x210);
        if (!localMsgBody.bytes_qrsig_url.has()) {
          break label313;
        }
        paramMsgType0x210 = new String(localMsgBody.bytes_qrsig_url.get().toByteArray(), "utf-8");
        if (!localMsgBody.bytes_hint1.has()) {
          break label308;
        }
        paramMsg = new String(localMsgBody.bytes_hint1.get().toByteArray(), "utf-8");
        if (localMsgBody.bytes_hint2.has()) {
          str = new String(localMsgBody.bytes_hint2.get().toByteArray(), "utf-8");
        }
        if (QLog.isColorLevel()) {
          QLog.d("DevLock", 2, "decodeDevlockQuickLoginPush recv devlock quicklogin push qrcode=" + paramMsgType0x210 + " maintip=" + paramMsg + " smalltip" + str);
        }
        EquipmentLockImpl.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMsgType0x210, paramMsg, str);
        return;
      }
      catch (Exception paramMsgType0x210) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("DevLock", 2, "failed to parse msg0x210.Submsgtype0x51");
      return;
      label308:
      paramMsg = null;
      continue;
      label313:
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
    int k;
    for (;;)
    {
      return;
      localObject1 = new SubMsgType0x27.MsgBody();
      try
      {
        paramArrayOfByte = (SubMsgType0x27.MsgBody)((SubMsgType0x27.MsgBody)localObject1).mergeFrom(paramArrayOfByte);
        if (paramArrayOfByte != null)
        {
          localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46);
          localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47);
          localPublicAccountDataManager = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
          paramArrayOfByte = paramArrayOfByte.rpt_msg_mod_infos.get();
          arrayOfFriends = new Friends[paramArrayOfByte.size()];
          Iterator localIterator = paramArrayOfByte.iterator();
          k = 0;
          for (;;)
          {
            if (!localIterator.hasNext()) {
              break label6522;
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
            break label316;
          }
        }
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return;
      }
    }
    label316:
    Object localObject4;
    int m;
    label1010:
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
          m = ((SubMsgType0x27.ModGroupName)localObject1).uint32_groupid.get();
          localObject4 = ((SubMsgType0x27.ModGroupName)localObject1).bytes_groupname.get().toStringUtf8();
          paramArrayOfByte = localFriendsManager.a(String.valueOf(m));
          if (paramArrayOfByte == null) {
            break label1010;
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
          m = (byte)((SubMsgType0x27.ModGroupName)localObject1).uint32_groupid.get();
          paramArrayOfByte.sGroupName = new String(((SubMsgType0x27.ModGroupName)localObject1).bytes_groupname.get().toStringUtf8());
          paramArrayOfByte = new GroupActionResp(0, "", paramArrayOfByte);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(19, true, paramArrayOfByte);
          break;
          paramArrayOfByte = new Groups();
          paramArrayOfByte.group_id = m;
        }
      } while (!paramArrayOfByte.msg_mod_group_sort.has());
      localObject4 = ((SubMsgType0x27.ModGroupSort)paramArrayOfByte.msg_mod_group_sort.get()).rpt_msg_groupsort.get();
      if (localObject4 != null)
      {
        paramArrayOfByte = new byte[((List)localObject4).size()];
        localObject1 = new byte[((List)localObject4).size()];
        localObject4 = ((List)localObject4).iterator();
        m = 0;
        label1099:
        if (((Iterator)localObject4).hasNext())
        {
          localObject5 = (SubMsgType0x27.GroupSort)((Iterator)localObject4).next();
          if ((!((SubMsgType0x27.GroupSort)localObject5).uint32_groupid.has()) || (!((SubMsgType0x27.GroupSort)localObject5).uint32_sortid.has())) {
            break label6539;
          }
          paramArrayOfByte[m] = ((byte)((SubMsgType0x27.GroupSort)localObject5).uint32_groupid.get());
          localObject1[m] = ((byte)((SubMsgType0x27.GroupSort)localObject5).uint32_sortid.get());
          if (QLog.isColorLevel()) {
            QLog.d("cardpush", 2, "push a ModGroupSort  = id:" + ((SubMsgType0x27.GroupSort)localObject5).uint32_groupid.get() + " sortid:" + ((SubMsgType0x27.GroupSort)localObject5).uint32_sortid.get());
          }
          m += 1;
        }
      }
      break;
    }
    label6533:
    label6539:
    for (;;)
    {
      break label1099;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(22, true, null);
      localFriendsManager.a(paramArrayOfByte, (byte[])localObject1);
      break;
      if (!paramArrayOfByte.msg_mod_friend_group.has()) {
        break;
      }
      paramArrayOfByte = ((SubMsgType0x27.ModFriendGroup)paramArrayOfByte.msg_mod_friend_group.get()).rpt_msg_frd_group.get();
      label1300:
      long l1;
      int n;
      if (paramArrayOfByte != null)
      {
        paramArrayOfByte = paramArrayOfByte.iterator();
        while (paramArrayOfByte.hasNext())
        {
          localObject1 = (SubMsgType0x27.FriendGroup)paramArrayOfByte.next();
          if ((((SubMsgType0x27.FriendGroup)localObject1).uint64_fuin.has()) && (((SubMsgType0x27.FriendGroup)localObject1).rpt_uint32_new_group_id.get().size() > 0))
          {
            l1 = ((SubMsgType0x27.FriendGroup)localObject1).uint64_fuin.get();
            n = ((Integer)((SubMsgType0x27.FriendGroup)localObject1).rpt_uint32_new_group_id.get(0)).intValue();
            if (((SubMsgType0x27.FriendGroup)localObject1).rpt_uint32_old_group_id.get().size() <= 0) {
              break label6533;
            }
          }
        }
      }
      for (m = ((Integer)((SubMsgType0x27.FriendGroup)localObject1).rpt_uint32_old_group_id.get(0)).intValue();; m = 0)
      {
        localFriendsManager.a(l1 + "", n);
        if (QLog.isColorLevel()) {
          QLog.d("cardpush", 2, "push a ModFriendGroup  = id:" + l1 + " newgroupid:" + n);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(9, true, new Object[] { l1 + "", Byte.valueOf((byte)n), Byte.valueOf((byte)m) });
        break label1300;
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
        break;
        if (paramArrayOfByte.msg_mod_friend_rings.has())
        {
          localObject1 = ((SubMsgType0x27.ModSnsGeneralInfo)paramArrayOfByte.msg_mod_friend_rings.get()).rpt_msg_sns_general_infos.get().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject4 = (SubMsgType0x27.SnsUpateBuffer)((Iterator)localObject1).next();
            localObject5 = ((SubMsgType0x27.SnsUpateBuffer)localObject4).rpt_msg_sns_update_item.get().iterator();
            while (((Iterator)localObject5).hasNext())
            {
              Object localObject6 = (SubMsgType0x27.SnsUpdateItem)((Iterator)localObject5).next();
              if (((SubMsgType0x27.SnsUpdateItem)localObject6).uint32_update_sns_type.get() == 13569)
              {
                String str = localTroopManager.b(Long.valueOf(((SubMsgType0x27.SnsUpateBuffer)localObject4).uint64_uin.get()).toString());
                m = ((SubMsgType0x27.SnsUpdateItem)localObject6).bytes_value.get().size();
                if (m == 0)
                {
                  if (localTroopManager.c(str)) {
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(21).a(18, true, new Object[] { str, Integer.valueOf(1), Integer.valueOf(0), null });
                  }
                }
                else if (m >= 4)
                {
                  localObject6 = ((SubMsgType0x27.SnsUpdateItem)localObject6).bytes_value.get().toByteArray();
                  byte[] arrayOfByte = new byte[m];
                  System.arraycopy(localObject6, 0, arrayOfByte, 0, 4);
                  if (localTroopManager.a(str, MessageHandlerUtils.a(arrayOfByte))) {
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(21).a(18, true, new Object[] { str, Integer.valueOf(0), Integer.valueOf(0), null });
                  }
                }
              }
            }
          }
        }
        if (!paramArrayOfByte.msg_mod_friend_rings.has()) {
          break;
        }
        paramArrayOfByte = (SubMsgType0x27.ModSnsGeneralInfo)paramArrayOfByte.msg_mod_friend_rings.get();
        if ((paramArrayOfByte != null) && (paramArrayOfByte.rpt_msg_sns_general_infos.has()))
        {
          paramArrayOfByte = paramArrayOfByte.rpt_msg_sns_general_infos.get().iterator();
          while (paramArrayOfByte.hasNext())
          {
            localObject1 = (SubMsgType0x27.SnsUpateBuffer)paramArrayOfByte.next();
            if ((localObject1 != null) && (((SubMsgType0x27.SnsUpateBuffer)localObject1).uint64_uin.has()) && (((SubMsgType0x27.SnsUpateBuffer)localObject1).rpt_msg_sns_update_item.has()))
            {
              l1 = ((SubMsgType0x27.SnsUpateBuffer)localObject1).uint64_uin.get();
              if (this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager == null) {
                this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager = new QvipSpecialCareManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
              }
              localObject1 = ((SubMsgType0x27.SnsUpateBuffer)localObject1).rpt_msg_sns_update_item.get().iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject4 = (SubMsgType0x27.SnsUpdateItem)((Iterator)localObject1).next();
                if ((localObject4 != null) && (((SubMsgType0x27.SnsUpdateItem)localObject4).uint32_update_sns_type.has()) && (((SubMsgType0x27.SnsUpdateItem)localObject4).bytes_value.has()) && (((SubMsgType0x27.SnsUpdateItem)localObject4).uint32_update_sns_type.get() == 13568))
                {
                  localObject4 = ((SubMsgType0x27.SnsUpdateItem)localObject4).bytes_value.get().toStringUtf8();
                  this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager.a(String.valueOf(l1), (String)localObject4);
                }
              }
            }
          }
        }
        break;
        if (!paramArrayOfByte.msg_mod_friend_flag.has()) {
          break;
        }
        paramArrayOfByte = (SubMsgType0x27.SnsUpdateFlag)paramArrayOfByte.msg_mod_friend_flag.get();
        long l2;
        boolean bool;
        if (paramArrayOfByte.rpt_msg_update_sns_flag.has())
        {
          paramArrayOfByte = paramArrayOfByte.rpt_msg_update_sns_flag.get().iterator();
          while (paramArrayOfByte.hasNext())
          {
            localObject1 = (SubMsgType0x27.SnsUpdateOneFlag)paramArrayOfByte.next();
            l1 = ((SubMsgType0x27.SnsUpdateOneFlag)localObject1).uint64__uin.get();
            m = ((SubMsgType0x27.SnsUpdateOneFlag)localObject1).uint32_flag.get();
            l2 = ((SubMsgType0x27.SnsUpdateOneFlag)localObject1).uint64_id.get();
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageProcessor", 2, "FriendShield : onLinePush : uin : " + l1 + " flag:" + m + " id:" + l2);
            }
            if (l2 == 4051L)
            {
              localObject1 = localFriendsManager.c(String.valueOf(l1));
              if (localObject1 != null)
              {
                if (m == 1) {}
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
        n = k;
        if (paramArrayOfByte.uint64_uin.has())
        {
          l1 = paramArrayOfByte.uint64_uin.get();
          localObject4 = paramArrayOfByte.rpt_msg_profile_infos.get().iterator();
          m = k;
          for (;;)
          {
            n = m;
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
                arrayOfFriends[m] = localFriendsManager.a(l1 + "", paramArrayOfByte.toStringUtf8());
                localObject1 = localFriendsManager.a(l1 + "");
                if (localObject1 != null)
                {
                  ((Card)localObject1).strNick = paramArrayOfByte.toStringUtf8();
                  localFriendsManager.a((Card)localObject1);
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2).a(1, true, localObject1);
                }
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(3, true, Long.toString(l1));
                m += 1;
                break;
              case 20015: 
                paramArrayOfByte = paramArrayOfByte.bytes_value.get();
                if ((paramArrayOfByte != null) && (paramArrayOfByte.size() == 2))
                {
                  k = paramArrayOfByte.byteAt(0);
                  k = (short)(paramArrayOfByte.byteAt(1) | k << 8);
                  if (QLog.isColorLevel()) {
                    QLog.d("cardpush", 2, "push a ModProfile Head = " + k);
                  }
                  ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).b(l1 + "");
                  paramArrayOfByte = localFriendsManager.a(l1 + "");
                  if (paramArrayOfByte != null)
                  {
                    paramArrayOfByte.nFaceID = k;
                    localFriendsManager.a(paramArrayOfByte);
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(4, true, new Object[] { l1 + "", paramArrayOfByte, null });
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2).a(1, true, paramArrayOfByte);
                  }
                }
                break;
              case 20009: 
                n = paramArrayOfByte.bytes_value.get().byteAt(0);
                if (n == 1) {
                  k = 0;
                }
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("cardpush", 2, "push a ModProfile Sex = " + k);
                  }
                  paramArrayOfByte = localFriendsManager.a(l1 + "");
                  if (paramArrayOfByte == null) {
                    break;
                  }
                  paramArrayOfByte.shGender = ((short)k);
                  localFriendsManager.a(paramArrayOfByte);
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2).a(1, true, paramArrayOfByte);
                  break;
                  if (n == 2)
                  {
                    k = 1;
                  }
                  else
                  {
                    k = n;
                    if (n == 0) {
                      k = 2;
                    }
                  }
                }
              case 20059: 
                k = ByteBuffer.wrap(paramArrayOfByte.bytes_value.get().toByteArray()).asIntBuffer().get(0);
                a(k);
                paramArrayOfByte = (SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12);
                paramArrayOfByte.a(101, true, Integer.valueOf(k));
                if (k != paramArrayOfByte.b()) {
                  paramArrayOfByte.d();
                }
                if (QLog.isColorLevel()) {
                  QLog.d("vip", 2, "bubble id = " + k);
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
                  k = 0;
                  ((Friends)localObject1).qqVipInfo = ((byte)k << 24);
                  if ((paramArrayOfByte.byteAt(0) & 0x8) != 0) {
                    break label3653;
                  }
                }
                for (k = 0;; k = 1)
                {
                  ((Friends)localObject1).superQqInfo = ((byte)k << 24);
                  localFriendsManager.a((Friends)localObject1);
                  paramArrayOfByte = (SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12);
                  paramArrayOfByte.a(100, true, null);
                  if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(Long.toString(l1))) {
                    break;
                  }
                  paramArrayOfByte.c(2);
                  ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(12)).b();
                  break;
                  k = 1;
                  break label3540;
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
                    break label3871;
                  }
                }
                for (k = 1;; k = 0)
                {
                  ((Friends)localObject5).superVipInfo = ((byte)k << 24);
                  localFriendsManager.a((Friends)localObject5);
                  if (QLog.isColorLevel()) {
                    QLog.d("vip", 2, "isSVip=" + bool + "friend.superVipInfo=" + ((Friends)localObject5).superVipInfo);
                  }
                  if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(localObject1)) {
                    break;
                  }
                  ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12)).a(100, true, null);
                  ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(12)).b();
                  break;
                  bool = false;
                  break label3737;
                }
              case 23109: 
                if ((paramArrayOfByte.bytes_value.get().byteAt(12) & 0x8) != 0) {}
                for (bool = true;; bool = false)
                {
                  SttManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool);
                  break;
                }
              case 27025: 
                l2 = ByteBuffer.wrap(paramArrayOfByte.bytes_value.get().toByteArray()).asLongBuffer().get();
                localObject1 = localFriendsManager.a(String.valueOf(l1));
                paramArrayOfByte = (byte[])localObject1;
                if (localObject1 == null)
                {
                  paramArrayOfByte = new ExtensionInfo();
                  paramArrayOfByte.uin = String.valueOf(l1);
                }
                paramArrayOfByte.pendantId = l2;
                paramArrayOfByte.timestamp = System.currentTimeMillis();
                localFriendsManager.a(paramArrayOfByte);
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.BaseMessageProcessor", 2, "push, Get Pendant, uin=" + l1 + ", id=" + paramArrayOfByte.pendantId);
                }
                break;
              case 27032: 
                label3540:
                k = ByteBuffer.wrap(paramArrayOfByte.bytes_value.get().toByteArray()).asIntBuffer().get();
                label3653:
                localObject1 = localFriendsManager.a(String.valueOf(l1));
                label3737:
                label3871:
                paramArrayOfByte = (byte[])localObject1;
                if (localObject1 == null)
                {
                  paramArrayOfByte = new ExtensionInfo();
                  paramArrayOfByte.uin = String.valueOf(l1);
                }
                if (paramArrayOfByte.uVipFont != k)
                {
                  paramArrayOfByte.uVipFont = k;
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
        k = n;
        break;
        if (!paramArrayOfByte.msg_mod_custom_face.has()) {
          break;
        }
        paramArrayOfByte = (SubMsgType0x27.ModCustomFace)paramArrayOfByte.msg_mod_custom_face.get();
        if ((paramArrayOfByte.uint32_type.has()) && (paramArrayOfByte.uint64_uin.has()))
        {
          localObject1 = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
          if (paramArrayOfByte.uint32_type.get() != 0) {
            break label4342;
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
          label4342:
          if (paramArrayOfByte.uint32_type.get() == 1)
          {
            l1 = paramArrayOfByte.uint64_group_code.get();
            if (QLog.isColorLevel()) {
              QLog.d("cardpush", 2, "push a ModCustomFace  :1 Troop uin = " + l1);
            }
            ((FriendListHandler)localObject1).c(l1 + "");
          }
        }
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
        arrayOfFriends[k] = localFriendsManager.a(paramArrayOfByte, (byte[])localObject1, l1);
        localObject4 = localFriendsManager.a(((SubMsgType0x27.ModLongNick)localObject4).uint64_uin.get() + "");
        if (localObject4 != null)
        {
          ((Card)localObject4).vRichSign = ((byte[])localObject1);
          ((Card)localObject4).lSignModifyTime = l1;
          localFriendsManager.a((Card)localObject4);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(3, true, paramArrayOfByte);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(2, true, new String[] { paramArrayOfByte });
        k += 1;
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
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(19).a(1, false, null);
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
            m = ((ByteStringMicro)localObject4).byteAt(0);
            short s = (short)(((ByteStringMicro)localObject4).byteAt(1) | m << 8);
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
          label6078:
          label6517:
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (SubMsgType0x27.GroupMemberProfileInfo)((Iterator)localObject3).next();
            if ((((SubMsgType0x27.GroupMemberProfileInfo)localObject4).uint32_field.has()) && (((SubMsgType0x27.GroupMemberProfileInfo)localObject4).bytes_value.has()))
            {
              if (((SubMsgType0x27.GroupMemberProfileInfo)localObject4).uint32_field.get() != 1) {
                break label6078;
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
                break label6517;
              }
              DBUtils.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramArrayOfByte);
              localObject4 = new ArrayList();
              ((ArrayList)localObject4).add(paramArrayOfByte);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(19).a(16, true, localObject4);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(19).a(10, true, new Object[] { localObject4, Boolean.valueOf(true) });
              break;
              if (((SubMsgType0x27.GroupMemberProfileInfo)localObject4).uint32_field.get() == 2)
              {
                if (((SubMsgType0x27.GroupMemberProfileInfo)localObject4).bytes_value.get().size() == 1)
                {
                  byte b1 = ((SubMsgType0x27.GroupMemberProfileInfo)localObject4).bytes_value.get().byteAt(0);
                  if (QLog.isColorLevel()) {
                    QLog.d("cardpush", 2, "push a ModGroupMemberProfile 2--sex = " + b1);
                  }
                  localTroopManager.a(l1 + "", l3 + "", null, -100, null, null, -100, b1, -100, -100L, -100L);
                  if (paramArrayOfByte != null) {
                    paramArrayOfByte.sex = b1;
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
        label6522:
        localFriendsManager.a(arrayOfFriends, k);
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
      do
      {
        do
        {
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
            if (localMsgBody.uint32_sub_cmd.get() == 1)
            {
              ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(19)).a(paramArrayOfByte);
              return;
            }
          } while (localMsgBody.uint32_sub_cmd.get() != 3);
          if ((!localMsgBody.msg_subcmd_0x3_push_body.has()) && (QLog.isColorLevel())) {
            QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x26 : msg has not 0x3_push_body");
          }
          paramArrayOfByte = (submsgtype0x26.MsgBody.SubCmd0x3UpdateDiscussAppInfo)localMsgBody.msg_subcmd_0x3_push_body.get();
        } while ((!paramArrayOfByte.uint64_conf_uin.has()) || (!paramArrayOfByte.msg_app_tip_notify.has()));
        paramArrayOfByte.uint64_conf_uin.get();
        paramArrayOfByte = (submsgtype0x26.AppTipNotify)paramArrayOfByte.msg_app_tip_notify.get();
      } while (!paramArrayOfByte.bytes_text.has());
      paramArrayOfByte = paramArrayOfByte.bytes_text.get().toByteArray();
    } while (paramArrayOfByte.length <= 0);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.OnLinePushMessageProcessor
 * JD-Core Version:    0.7.0.1
 */