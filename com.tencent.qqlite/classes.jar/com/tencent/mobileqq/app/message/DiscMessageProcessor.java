package com.tencent.mobileqq.app.message;

import MessageSvcPack.SvcResponseSetConfMsgRead;
import OnlinePushPack.MsgInfo;
import OnlinePushPack.SvcReqPushMsg;
import PushNotifyPack.DisMsgReadedNotify;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.ContactFacade;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.PBDecodeContext;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cyp;
import cyq;
import cyr;
import cys;
import czc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;
import msf.msgcomm.msg_comm.AppShareInfo;
import msf.msgcomm.msg_comm.ContentHead;
import msf.msgcomm.msg_comm.DiscussInfo;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgsvc.msg_svc.PbGetDiscussMsgResp;
import msf.onlinepush.msg_onlinepush.PbPushMsg;
import tencent.im.msg.im_msg_body.MsgBody;

public class DiscMessageProcessor
  extends BaseMessageProcessorForTroopAndDisc
{
  public static final byte a = 1;
  public static final byte b = 2;
  public static final byte c = 3;
  public static final String c = "Q.msg.DiscMessageProcessor";
  public static final byte d = 6;
  public static final byte e = 9;
  public static final byte f = 10;
  public static final byte g = 11;
  public static final byte h = 15;
  public static final byte i = 7;
  public static final byte j = 22;
  public cys a;
  private final Timer a;
  public final ConcurrentHashMap a;
  
  public DiscMessageProcessor(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilTimer = ThreadManager.a();
    this.jdField_a_of_type_Cys = new cys(this, null);
  }
  
  private MessageRecord a(MsgInfo paramMsgInfo, long paramLong)
  {
    Object localObject5 = paramMsgInfo.vMsg;
    long l2 = paramMsgInfo.lFromUin;
    long l1 = PkgTools.a((byte[])localObject5, 0);
    byte b1 = localObject5[4];
    Object localObject4 = new ArrayList();
    Object localObject3 = (DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6);
    Object localObject6 = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    Object localObject1 = (ContactFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46);
    Object localObject7 = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(45);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.DiscMessageProcessor.discuss", 2, "handleDiscussionMemchangeMsg cOpType: " + b1 + ", dwConfUin=" + l1);
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
      for (;;)
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
          QLog.d("Q.msg.DiscMessageProcessor.discuss", 2, "handleDiscussionMemchangeMsg discussionUin: " + l1 + " memberUin: " + l2);
        }
        if (a(l2, l1, paramMsgInfo.shMsgSeq))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.DiscMessageProcessor.discuss", 2, "handleDiscussionMemchangeMsg memberChangeMsgFilter return");
          }
          return null;
        }
        if (!String.valueOf(paramLong).equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
          ((DiscussionHandler)localObject3).a(String.valueOf(paramLong), l1);
        }
        ((DiscussionHandler)localObject3).a(l1);
        k = ((DiscussionManager)localObject7).a(l1 + "");
        if (!((DiscussionManager)localObject7).a(String.valueOf(l1), String.valueOf(l2)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.DiscMessageProcessor.discuss", 2, "handleDiscussionUpdateMsg add discussion " + l1 + " member number by 1 " + l2 + " num: " + k);
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
          if (QLog.isColorLevel())
          {
            QLog.d("Q.msg.DiscMessageProcessor.discuss", 2, "handleDiscussionMemchangeMsg setDiscussionMemberNum memnum" + k);
            continue;
            l3 = PkgTools.a((byte[])localObject5, 5);
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.DiscMessageProcessor.discuss", 2, "handleDiscussionMemchangeMsg discussionUin: " + l1 + " memberUin: " + l3);
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
                QLog.d("Q.msg.DiscMessageProcessor.discuss", 2, "coptype 2 server memberName empty");
              }
              localObject2 = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l1), (String)localObject5);
            }
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131363226, new Object[] { localObject2 });
            ((List)localObject4).add(localObject5);
            if (((String)localObject5).equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))
            {
              ((DiscussionHandler)localObject3).a(String.valueOf(l1));
              return null;
            }
            ((DiscussionHandler)localObject3).a(l1);
            ((DiscussionManager)localObject7).a(String.valueOf(l1), String.valueOf(l3));
            a(paramMsgInfo, paramLong, l2, l2, (String)localObject1);
            continue;
            localObject2 = paramMsgInfo.getVNickName();
            l2 = PkgTools.a((byte[])localObject5, 5);
            n = PkgTools.a((byte[])localObject5, 13);
            localObject1 = new ArrayList();
            m = 15;
            for (k = 1; k < n + 1; k = (short)(k + 1))
            {
              localObject6 = (String)((ArrayList)localObject2).get(k);
              l3 = PkgTools.a((byte[])localObject5, m);
              m += 4;
              ((List)localObject4).add(String.valueOf(l3));
              ((ArrayList)localObject1).add(new Pair(String.valueOf(l3), localObject6));
              ((DiscussionHandler)localObject3).a(String.valueOf(l3), l1);
            }
            localObject2 = new Pair(Long.valueOf(l2), ((ArrayList)localObject2).get(0));
            localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
            if (((RecentUserProxy)localObject3).b(Long.toString(l1), 3000) != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.DiscMessageProcessor.discuss", 2, "handleDiscussionMemchangeMsg ru alreadyintab");
              }
              a((Pair)localObject2, paramMsgInfo, (ArrayList)localObject1, paramLong, String.valueOf(l1), b1, false);
            }
            else
            {
              localObject4 = ((RecentUserProxy)localObject3).a(Long.toString(l1), 3000);
              RecentUtil.a((RecentUser)localObject4, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
              ((RecentUser)localObject4).uin = Long.toString(l1);
              ((RecentUser)localObject4).lastmsgtime = paramMsgInfo.uRealMsgTime;
              ((RecentUser)localObject4).type = 3000;
              ((RecentUserProxy)localObject3).a((RecentUser)localObject4);
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.DiscMessageProcessor.discuss", 2, "handleDiscussionMemchangeMsg ru.lastmsgtime " + paramMsgInfo.uRealMsgTime);
              }
              localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
              if (SelectMemberActivity.a)
              {
                SelectMemberActivity.a = false;
              }
              else if (TextUtils.equals((CharSequence)localObject3, String.valueOf(l2)))
              {
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Multi_call", "Show_discuss_tips", 0, 0, "", "", "", "");
              }
              else
              {
                a((Pair)localObject2, paramMsgInfo, (ArrayList)localObject1, paramLong, String.valueOf(l1), b1, true);
                continue;
                l2 = PkgTools.a((byte[])localObject5, 5);
                l3 = PkgTools.a((byte[])localObject5, 9);
                PkgTools.a((byte[])localObject5, 13);
                k = PkgTools.a((byte[])localObject5, 17);
                localObject1 = new byte[k];
                PkgTools.b((byte[])localObject5, 19, (byte[])localObject1, k);
                localObject4 = new String((byte[])localObject1);
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.DiscMessageProcessor.discuss", 2, "cOptye:" + b1 + "dwCmdUin =" + l2 + " dwCmdTime=" + l3 + " strName=" + (String)localObject4);
                }
                if (l2 == paramLong) {}
                for (localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131363957, new Object[] { localObject4 });; localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131363958, new Object[] { localObject2, localObject4 }))
                {
                  ((DiscussionHandler)localObject3).a(String.valueOf(l1), (String)localObject4);
                  a(paramMsgInfo, paramLong, l1, l2, (String)localObject1);
                  break;
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
                      QLog.d("Q.msg.DiscMessageProcessor.discuss", 2, "coptype 6 server opeaterName empty");
                    }
                    localObject2 = ((FriendsManagerImp)localObject6).c(String.valueOf(l1), String.valueOf(l2));
                  }
                }
                if (PkgTools.a((byte[])localObject5, 5) != 0)
                {
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
                    QLog.d("Q.msg.DiscMessageProcessor.discuss", 2, "cOptye:9 +uinList.size()=" + ((ArrayList)localObject3).size());
                  }
                  localObject2 = ((ArrayList)localObject3).iterator();
                  while (((Iterator)localObject2).hasNext())
                  {
                    localObject4 = (Pair)((Iterator)localObject2).next();
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.msg.DiscMessageProcessor.discuss", 2, "cOptye:9 +遍历uin uin=" + ((Pair)localObject4).first);
                    }
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.DiscMessageProcessor.discuss", 2, "cOptye:9 +sTips=" + (String)localObject1 + "+lUin=" + paramLong);
                  }
                  this.jdField_a_of_type_JavaUtilTimer.schedule(new cyp(this, (ArrayList)localObject3, paramLong, l1, (String)localObject1, paramMsgInfo, l2), 2000L);
                }
              }
            }
          }
        }
      }
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
      switch ((int)l4)
      {
      }
      for (;;)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        if (((RecentUserProxy)localObject1).b(Long.toString(l1), 3000) != null) {
          break;
        }
        localObject2 = ((RecentUserProxy)localObject1).a(Long.toString(l1), 3000);
        ((RecentUser)localObject2).uin = Long.toString(l1);
        ((RecentUser)localObject2).lastmsgtime = paramMsgInfo.uRealMsgTime;
        ((RecentUser)localObject2).type = 3000;
        ((RecentUserProxy)localObject1).a((RecentUser)localObject2);
        break;
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
        ArrayList localArrayList = new ArrayList();
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
            localArrayList.add(new Pair(str, localObject1));
            ((List)localObject4).add(str);
            ((DiscussionHandler)localObject3).a(str, l1);
            m += 4;
            k += 1;
          }
        }
        ((DiscussionHandler)localObject3).a(l1, String.valueOf(l3), (List)localObject4, 0);
        this.jdField_a_of_type_JavaUtilTimer.schedule(new cyq(this, l3, paramLong, (Pair)localObject6, paramMsgInfo, l1, l2, b1, l4, (Pair)localObject7, localArrayList), 2000L);
      }
      PkgTools.a((byte[])localObject5, 5);
      PkgTools.a((byte[])localObject5, 9);
      k = localObject5[13];
      break;
      PkgTools.a((byte[])localObject5, 5);
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
        l3 = PkgTools.a((byte[])localObject5, m);
        m += 4;
        ((HashSet)localObject1).add(String.valueOf(l3));
        ((List)localObject4).add(String.valueOf(l3));
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
        a(paramMsgInfo, paramLong, l2, l2, "你已被移出讨论组");
        break;
      }
      ((DiscussionHandler)localObject2).a((String)localObject3, (HashSet)localObject1);
      break;
      l3 = PkgTools.a((byte[])localObject5, 5);
      PkgTools.a((byte[])localObject5, 9);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMessageProcessor.discuss", 2, "handleDiscussionMemchangeMsg discussionUin: " + l1 + " memberUin: " + l3);
      }
      localObject7 = String.valueOf(l3);
      if (a(l3, l1, paramMsgInfo.shMsgSeq)) {
        return null;
      }
      if (((String)localObject7).equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
        break;
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
          QLog.d("Q.msg.DiscMessageProcessor.discuss", 2, "coptype 2 server memberName empty");
        }
        localObject1 = ((FriendsManagerImp)localObject6).c(String.valueOf(l1), (String)localObject7);
      }
      for (;;)
      {
        n = PkgTools.a((byte[])localObject5, 13);
        m = 15;
        localObject7 = new HashSet();
        k = 0;
        while (k < n)
        {
          l3 = PkgTools.a((byte[])localObject5, m);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.DiscMessageProcessor.discuss", 2, "handleDiscussionMemchangeMsg MSG_DISCUSSION_TYPE_KICKOUT_MEMBER uin=" + l3);
          }
          m += 4;
          ((HashSet)localObject7).add(String.valueOf(l3));
          ((List)localObject4).add(String.valueOf(l3));
          k += 1;
        }
        localObject4 = new StringBuffer();
        localObject2 = "";
        if (((HashSet)localObject7).size() > 0)
        {
          localObject5 = ((HashSet)localObject7).iterator();
          while (((Iterator)localObject5).hasNext()) {
            ((StringBuffer)localObject4).append(((FriendsManagerImp)localObject6).c(String.valueOf(l1), (String)((Iterator)localObject5).next())).append("、");
          }
        }
        if (((StringBuffer)localObject4).length() > 0) {
          localObject2 = ((StringBuffer)localObject4).deleteCharAt(((StringBuffer)localObject4).toString().length() - 1).toString();
        }
        localObject4 = (DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131363227, new Object[] { localObject2 });
        if (((HashSet)localObject7).contains(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))
        {
          ((DiscussionHandler)localObject4).a(String.valueOf(l1));
          a(paramMsgInfo, paramLong, l2, l2, "你已被移出讨论组");
          break;
        }
        localObject1 = (String)localObject1 + "将" + (String)localObject2;
        ((DiscussionHandler)localObject4).a(String.valueOf(l1), (HashSet)localObject7);
        ((DiscussionHandler)localObject3).a(l1);
        a(paramMsgInfo, paramLong, l2, l2, (String)localObject1);
        break;
      }
    }
  }
  
  private MessageRecord a(MsgInfo paramMsgInfo, SvcReqPushMsg paramSvcReqPushMsg)
  {
    paramMsgInfo = a(paramMsgInfo, paramSvcReqPushMsg.lUin);
    if ((paramMsgInfo != null) && (!MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMsgInfo, true))) {
      return paramMsgInfo;
    }
    return null;
  }
  
  private void a(MsgInfo paramMsgInfo, long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    MessageRecord localMessageRecord = MessageRecordFactory.a(-1004);
    localMessageRecord.init(paramLong1, paramLong2, paramLong2, paramString, paramMsgInfo.uRealMsgTime, -1004, 3000, paramMsgInfo.uMsgTime);
    localMessageRecord.isread = true;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.DiscMessageProcessor", 2, "----------handleC2COnlinePushMsgResp after analysis friendUin: " + paramLong2 + " msgType: " + -1004 + " friendType: " + 3000 + " shMsgSeq: " + paramMsgInfo.shMsgSeq + " msgContent: " + Utils.a(paramString));
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
        QLog.d("Q.msg.DiscMessageProcessor.discuss", 2, "coptype 0xb server showName empty");
      }
      paramPair1 = localFriendManager.c(String.valueOf(paramLong2), String.valueOf(l1));
    }
    for (;;)
    {
      String str = (String)paramPair2.second;
      paramPair2 = str;
      if (TextUtils.isEmpty(str))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.DiscMessageProcessor.discuss", 2, "coptype 0xb server shareName empty");
        }
        paramPair2 = localFriendManager.c(String.valueOf(paramLong2), String.valueOf(l2));
      }
      if (paramLong4 == 0L) {
        paramPair1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131363238, new Object[] { paramPair1 });
      }
      for (;;)
      {
        a(paramMsgInfo, paramLong1, paramLong2, paramLong3, paramPair1);
        return;
        if (paramLong4 == 1L) {
          paramPair1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131363240, new Object[] { paramPair1, paramPair2 });
        } else if (paramLong4 == 2L) {
          paramPair1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131364377, new Object[] { paramPair1 });
        } else {
          paramPair1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131363225, new Object[] { paramPair1 });
        }
      }
    }
  }
  
  private void a(Pair paramPair, MsgInfo paramMsgInfo, ArrayList paramArrayList, long paramLong1, String paramString, byte paramByte, long paramLong2, boolean paramBoolean)
  {
    long l = ((Long)paramPair.first).longValue();
    String str1 = (String)paramPair.second;
    FriendManager localFriendManager = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    StringBuffer localStringBuffer = new StringBuffer();
    int n = paramArrayList.size();
    int k = 0;
    int m;
    if (k < n)
    {
      paramPair = (Pair)paramArrayList.get(k);
      String str2 = (String)paramPair.first;
      if (Long.valueOf(str2).longValue() == paramLong1)
      {
        m = 1;
        label96:
        if (m == 0) {
          break label142;
        }
        paramPair = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131363233);
        label115:
        if (k != 0) {
          break label210;
        }
        localStringBuffer.append(paramPair);
      }
      for (;;)
      {
        k += 1;
        break;
        m = 0;
        break label96;
        label142:
        localObject = (String)paramPair.second;
        paramPair = (Pair)localObject;
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break label115;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.DiscMessageProcessor.discuss", 2, "showWelcomeTips server name empty cOpType:" + paramByte);
        }
        paramPair = localFriendManager.c(paramString, str2);
        break label115;
        label210:
        localStringBuffer.append("、" + paramPair);
      }
    }
    k = -1004;
    if (paramBoolean) {
      k = -5001;
    }
    paramArrayList = new ArrayList();
    Object localObject = MessageRecordFactory.a(k);
    paramPair = "";
    if (paramByte == 11) {
      paramPair = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131363237, new Object[] { localStringBuffer.toString() });
    }
    if (paramByte == 22)
    {
      if (paramLong2 == 0L) {
        paramPair = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131363237, new Object[] { localStringBuffer.toString() });
      }
      for (;;)
      {
        ((MessageRecord)localObject).init(paramLong1, paramMsgInfo.lFromUin, paramMsgInfo.lFromUin, paramPair, paramMsgInfo.uRealMsgTime, k, 3000, paramMsgInfo.uMsgTime);
        ((MessageRecord)localObject).shmsgseq = paramMsgInfo.shMsgSeq;
        ((MessageRecord)localObject).isread = true;
        if ((localObject instanceof MessageForNewGrayTips)) {
          ((MessageForNewGrayTips)localObject).updateMsgData();
        }
        if (!MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject, false)) {
          paramArrayList.add(localObject);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.DiscMessageProcessor", 2, "----------handleC2COnlinePushMsgResp after analysis(showWelcomeTips) friendUin: " + ((MessageRecord)localObject).frienduin + " msgType: " + k + " friendType: " + 3000 + " shMsgSeq: " + paramMsgInfo.shMsgSeq + " msgContent: " + ((MessageRecord)localObject).getLogColorContent());
        }
        if (paramArrayList.size() > 0) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramArrayList, String.valueOf(paramLong1));
        }
        return;
        if (paramLong2 == 1L) {
          paramPair = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131363239);
        } else if (paramLong2 == 2L) {
          paramPair = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131364378, new Object[] { localStringBuffer.toString() });
        }
      }
    }
    if (l == paramLong1)
    {
      m = 1;
      label610:
      if (m == 0) {
        break label687;
      }
      if (!QLog.isColorLevel()) {
        break label780;
      }
      paramPair = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131363232);
    }
    for (;;)
    {
      paramPair = paramPair + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131363225, new Object[] { localStringBuffer.toString() });
      break;
      m = 0;
      break label610;
      label687:
      paramPair = str1;
      if (TextUtils.isEmpty(str1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.DiscMessageProcessor.discuss", 2, "showWelcomeTips server invitorName empty cOpType:" + paramByte);
        }
        paramPair = localFriendManager.c(paramString, String.valueOf(l));
      }
      paramPair = paramPair + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131363231);
      continue;
      label780:
      paramPair = "";
    }
  }
  
  private void a(Pair paramPair, MsgInfo paramMsgInfo, ArrayList paramArrayList, long paramLong, String paramString, byte paramByte, boolean paramBoolean)
  {
    a(paramPair, paramMsgInfo, paramArrayList, paramLong, paramString, paramByte, 0L, paramBoolean);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg.getServiceCmd();
    paramToServiceMsg.extraData.getLong("groupuin");
    paramToServiceMsg.extraData.getLong("lastReadSeq");
    long l1 = paramToServiceMsg.extraData.getLong("msgSeq");
    long l2 = paramToServiceMsg.extraData.getLong("timeOut");
    paramToServiceMsg.extraData.getInt("retryIndex");
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramToServiceMsg, paramFromServiceMsg);
    paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l1);
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg.getResultCode() != 2901) {
        break label115;
      }
      paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
      paramToServiceMsg.getClass();
      if (!paramFromServiceMsg.a(paramToServiceMsg, "msf")) {
        break label115;
      }
    }
    label115:
    while ((480000L != l2) && (!paramToServiceMsg.a())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.DiscMessageProcessor", 2, "<ReadReport><E>_Discussion_reqSeq:" + l1);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l1);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcResponseSetConfMsgRead paramSvcResponseSetConfMsgRead)
  {
    paramToServiceMsg.getServiceCmd();
    paramToServiceMsg.extraData.getLong("groupuin");
    paramToServiceMsg.extraData.getLong("lastReadSeq");
    long l = paramToServiceMsg.extraData.getLong("msgSeq");
    paramToServiceMsg.extraData.getLong("timeOut");
    paramToServiceMsg.extraData.getInt("retryIndex");
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramToServiceMsg, paramFromServiceMsg);
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l) == null) {}
    while (paramSvcResponseSetConfMsgRead == null) {
      return;
    }
    int k = paramSvcResponseSetConfMsgRead.cReplyCode;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.DiscMessageProcessor", 2, "<ReadReport><R>_Discussion_reqSeq:" + l + " replyCode:" + k);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, ArrayList paramArrayList, msg_svc.PbGetDiscussMsgResp paramPbGetDiscussMsgResp)
  {
    Object localObject = new ArrayList();
    String str = String.valueOf(paramToServiceMsg.extraData.getLong("lDisUin", paramPbGetDiscussMsgResp.discuss_uin.get()));
    long l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g(str);
    StringBuilder localStringBuilder = new StringBuilder();
    if (QLog.isColorLevel())
    {
      localStringBuilder.append("<<---initGetPullDiscussionMsg discussUin: ").append(str).append(" res.cReplyCode: ").append(paramPbGetDiscussMsgResp.result.get()).append(" lastSeq: ").append(l1);
      QLog.d("Q.msg.DiscMessageProcessor", 2, localStringBuilder.toString());
    }
    if (paramArrayList != null) {
      a(paramArrayList, (ArrayList)localObject);
    }
    if ((paramPbGetDiscussMsgResp.result.get() == 104) && (((ArrayList)localObject).size() == 0))
    {
      l1 = paramToServiceMsg.extraData.getLong("lEndSeq", paramPbGetDiscussMsgResp.return_end_seq.get());
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMessageProcessor", 2, "initGetPullDiscussionMsg reply 104 !! disUin=" + str + ", reqEndSeq=" + l1);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(str, l1);
    }
    for (int k = 1;; k = 0)
    {
      int m;
      boolean bool2;
      boolean bool3;
      if (((ArrayList)localObject).size() > 0)
      {
        paramToServiceMsg = ((ArrayList)localObject).iterator();
        while (paramToServiceMsg.hasNext())
        {
          paramArrayList = (MessageRecord)paramToServiceMsg.next();
          if ((paramArrayList.senderuin != null) && (paramArrayList.senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())))
          {
            paramArrayList.isread = true;
            paramArrayList.issend = 2;
          }
        }
        Collections.sort((List)localObject, this.jdField_a_of_type_JavaUtilComparator);
        paramToServiceMsg = new ArrayList();
        m = ((ArrayList)localObject).size() - 1;
        if (m >= 0)
        {
          paramArrayList = (MessageRecord)((ArrayList)localObject).get(m);
          if (QLog.isColorLevel())
          {
            localStringBuilder.setLength(0);
            localStringBuilder.append("----------initGetPullDiscussionMsg update send message  mr.senderuin: ").append(paramArrayList.senderuin).append(" mr.msgtype: ").append(paramArrayList.msgtype).append(" mr.frienduin: ").append(paramArrayList.frienduin).append(" mr.shmsgseq: ").append(paramArrayList.shmsgseq).append(" mr.time:").append(paramArrayList.time).append(" mr.msg: ").append(paramArrayList.getLogColorContent());
            QLog.d("Q.msg.DiscMessageProcessor", 2, localStringBuilder.toString());
          }
          if ((paramArrayList.senderuin != null) && (paramArrayList.senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())))
          {
            paramPbGetDiscussMsgResp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramArrayList.frienduin, 3000, paramArrayList);
            if (paramPbGetDiscussMsgResp != null)
            {
              if (((paramArrayList instanceof MessageForText)) && ((paramPbGetDiscussMsgResp instanceof MessageForText)) && (paramArrayList.getRepeatCount() > 0))
              {
                paramPbGetDiscussMsgResp.setRepeatCount(paramArrayList.getRepeatCount());
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.DiscMessageProcessor", 2, "<---initGetPullDiscussionMsg_PB ===> update findMr.repeatCount=" + paramArrayList.getRepeatCount());
                }
              }
              if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().f()) {
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(paramPbGetDiscussMsgResp.frienduin, paramPbGetDiscussMsgResp.istroop, paramPbGetDiscussMsgResp.uniseq);
              }
              this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramArrayList.frienduin, 3000, paramPbGetDiscussMsgResp.uniseq, paramArrayList.shmsgseq, paramArrayList.time);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g(str, paramArrayList.shmsgseq);
            }
          }
          for (;;)
          {
            m -= 1;
            break;
            paramToServiceMsg.add(0, paramArrayList);
          }
        }
        bool2 = false;
        m = 0;
        l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g(str);
        if (paramToServiceMsg.size() > 0)
        {
          paramArrayList = paramToServiceMsg.iterator();
          if (paramArrayList.hasNext())
          {
            paramPbGetDiscussMsgResp = (MessageRecord)paramArrayList.next();
            if (paramPbGetDiscussMsgResp.shmsgseq > l1) {
              l1 = paramPbGetDiscussMsgResp.shmsgseq;
            }
            for (;;)
            {
              break;
            }
          }
          paramArrayList = (BaseMessageManagerForTroopAndDisc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(3000);
          if (paramArrayList.a(str, 3000, paramToServiceMsg, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
            break label1126;
          }
          paramPbGetDiscussMsgResp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str);
          long l2 = ((Long)paramPbGetDiscussMsgResp[0]).longValue();
          int n = paramToServiceMsg.size();
          m = 0;
          while (m < n)
          {
            if ((((MessageRecord)paramToServiceMsg.get(m)).senderuin != null) && (((MessageRecord)paramToServiceMsg.get(m)).senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())))
            {
              ((MessageRecord)paramToServiceMsg.get(m)).isread = true;
              ((MessageRecord)paramToServiceMsg.get(m)).issend = 2;
            }
            if (((Long)paramPbGetDiscussMsgResp[0]).longValue() >= ((MessageRecord)paramToServiceMsg.get(m)).shmsgseq) {
              ((MessageRecord)paramToServiceMsg.get(m)).isread = true;
            }
            m += 1;
          }
          bool2 = MessageHandlerUtils.a(paramToServiceMsg);
          bool3 = MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramToServiceMsg);
          m = MsgProxyUtils.a(paramToServiceMsg, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          paramPbGetDiscussMsgResp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          if ((bool2) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause))
          {
            bool1 = true;
            paramPbGetDiscussMsgResp.a(paramToServiceMsg, (String)localObject, bool1, false);
            paramArrayList.c(str, 3000, l2);
          }
        }
      }
      label1126:
      for (boolean bool1 = bool3;; bool1 = false)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g(str, l1);
        a("initGetPullDiscussionMsg", true, m, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(bool2, bool1), false);
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramToServiceMsg);
        for (;;)
        {
          if ((k != 0) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(str) == 1))
          {
            l1 = ((Long)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str)[0]).longValue();
            ((BaseMessageManagerForTroopAndDisc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(3000)).c(str, 3000, l1);
          }
          return;
          bool1 = false;
          break;
          k = 1;
          continue;
          k = 1;
        }
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, ArrayList paramArrayList, msg_svc.PbGetDiscussMsgResp paramPbGetDiscussMsgResp, String paramString)
  {
    ArrayList localArrayList1 = new ArrayList();
    HashSet localHashSet = new HashSet();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject1;
    Object localObject2;
    long l1;
    long l2;
    long l3;
    int k;
    long l4;
    int m;
    int n;
    long l5;
    int i1;
    long l6;
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMessageProcessor", 2, "<---refreshDiscussionHead_PB: size:" + paramArrayList.size());
      }
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (msg_comm.Msg)localIterator.next();
        paramArrayList = (msg_comm.MsgHead)((msg_comm.Msg)localObject1).msg_head.get();
        if (!paramArrayList.discuss_info.has())
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.DiscMessageProcessor", 2, "<---refreshDiscussionHead_PB: no discussInfo.");
          }
        }
        else
        {
          localObject2 = (msg_comm.DiscussInfo)paramArrayList.discuss_info.get();
          l1 = paramArrayList.from_uin.get();
          l2 = paramArrayList.to_uin.get();
          l3 = paramArrayList.msg_seq.get();
          k = paramArrayList.msg_time.get();
          l4 = paramArrayList.msg_uid.get();
          m = paramArrayList.user_active.get();
          n = paramArrayList.from_instid.get();
          l5 = ((msg_comm.DiscussInfo)localObject2).discuss_uin.get();
          i1 = ((msg_comm.DiscussInfo)localObject2).discuss_type.get();
          l6 = ((msg_comm.DiscussInfo)localObject2).discuss_info_seq.get();
          if ((!((msg_comm.DiscussInfo)localObject2).discuss_remark.has()) || (((msg_comm.DiscussInfo)localObject2).discuss_remark.get() == null)) {
            break label1017;
          }
        }
      }
    }
    label1017:
    for (paramArrayList = ((msg_comm.DiscussInfo)localObject2).discuss_remark.get().toByteArray();; paramArrayList = null)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.DiscMessageProcessor", 2, "<---refreshDiscussionHead_PB : fromUin:" + l1 + ",toUin:" + l2 + ",msgTime:" + k + ",msgSeq:" + l3 + ",msgUid:" + l4 + ",userActive:" + m + ",fromInstid:" + n + ",disUin:" + l5 + ",disType:" + i1 + ",disSeq:" + l6 + ",remarkSender:" + Arrays.toString(paramArrayList) + ",hasAppShare:" + ((msg_comm.Msg)localObject1).appshare_info.has() + ",hasMsgBody:" + ((msg_comm.Msg)localObject1).msg_body.has());
        }
        localObject2 = new ArrayList();
        ArrayList localArrayList3 = new ArrayList();
        PBDecodeContext localPBDecodeContext = new PBDecodeContext();
        localPBDecodeContext.e = l5;
        localPBDecodeContext.c = 3000;
        localPBDecodeContext.d = i1;
        if (((msg_comm.Msg)localObject1).content_head.has())
        {
          msg_comm.ContentHead localContentHead = (msg_comm.ContentHead)((msg_comm.Msg)localObject1).content_head.get();
          k = localContentHead.div_seq.get();
          m = localContentHead.pkg_index.get();
          n = localContentHead.pkg_num.get();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.DiscMessageProcessor", 2, "<---refreshDiscussionHead_PB ContentHead: divSeq:" + k + ",pkgIndex:" + m + ",pkgNum:" + n);
          }
        }
        try
        {
          a((msg_comm.Msg)localObject1, localArrayList3, localPBDecodeContext, true, null);
          if (localArrayList3.size() > 0) {
            a(localArrayList3, (ArrayList)localObject2, true);
          }
          if ((localObject2 == null) || (((ArrayList)localObject2).size() < 1)) {
            break;
          }
          MessageHandlerUtils.a((List)localObject2);
          localArrayList1.addAll((Collection)localObject2);
          MessageHandlerUtils.a("Q.msg.DiscMessageProcessor", paramString, l3, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), String.valueOf(l5));
          if ((paramArrayList == null) || (paramArrayList.length <= 0)) {
            break;
          }
          localObject2 = String.valueOf(l1);
          localObject1 = HexUtil.a(paramArrayList) + ":" + (String)localObject2;
          if (localHashSet.contains(localObject1)) {
            break;
          }
          paramArrayList = ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(paramArrayList, String.valueOf(l5), (String)localObject2, false);
          if (paramArrayList == null) {
            break;
          }
          localArrayList2.add(paramArrayList);
          localHashSet.add(localObject1);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.DiscMessageProcessor", 2, "decodeSinglePbMsg_GroupDis error,", localException);
            }
          }
        }
      }
      if (localArrayList2.size() > 0) {
        ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).c(localArrayList2);
      }
      paramArrayList = localArrayList1.iterator();
      while (paramArrayList.hasNext())
      {
        paramString = (MessageRecord)paramArrayList.next();
        if ((paramString.senderuin != null) && (paramString.senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))) {
          paramString.issend = 2;
        }
        paramString.isread = true;
      }
      Collections.sort(localArrayList1, this.jdField_a_of_type_JavaUtilComparator);
      paramToServiceMsg = paramToServiceMsg.extraData.getBundle("context");
      paramArrayList = new ArrayList();
      if (paramToServiceMsg != null)
      {
        paramToServiceMsg.putLong("beginSeq", paramPbGetDiscussMsgResp.return_begin_seq.get());
        paramToServiceMsg.putLong("endSeq", paramPbGetDiscussMsgResp.return_end_seq.get());
        paramToServiceMsg.putBoolean("success", true);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(paramPbGetDiscussMsgResp.discuss_uin.get()), 3000, localArrayList1, paramArrayList, paramToServiceMsg);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramArrayList);
      return;
    }
  }
  
  private void a(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    if ((paramArrayList1 == null) || (paramArrayList1.size() <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMessageProcessor", 2, "discussionMsgRecordHandle_PB msgs is null or size <= 0");
      }
      return;
    }
    HashSet localHashSet = new HashSet();
    ArrayList localArrayList1 = new ArrayList();
    new ArrayList();
    Iterator localIterator = paramArrayList1.iterator();
    long l1 = 0L;
    label62:
    msg_comm.Msg localMsg;
    Object localObject;
    long l4;
    long l2;
    long l3;
    int k;
    long l5;
    int m;
    int n;
    int i1;
    long l6;
    if (localIterator.hasNext())
    {
      localMsg = (msg_comm.Msg)localIterator.next();
      paramArrayList1 = (msg_comm.MsgHead)localMsg.msg_head.get();
      if ((!paramArrayList1.discuss_info.has()) && (QLog.isColorLevel())) {
        QLog.d("Q.msg.DiscMessageProcessor", 2, "<---handleMsgPush_PB_Group: no groupInfo.");
      }
      localObject = (msg_comm.DiscussInfo)paramArrayList1.discuss_info.get();
      l4 = paramArrayList1.from_uin.get();
      l2 = paramArrayList1.to_uin.get();
      l3 = paramArrayList1.msg_seq.get();
      k = paramArrayList1.msg_time.get();
      l5 = paramArrayList1.msg_uid.get();
      m = paramArrayList1.user_active.get();
      n = paramArrayList1.from_instid.get();
      l1 = ((msg_comm.DiscussInfo)localObject).discuss_uin.get();
      i1 = ((msg_comm.DiscussInfo)localObject).discuss_type.get();
      l6 = ((msg_comm.DiscussInfo)localObject).discuss_info_seq.get();
      if ((!((msg_comm.DiscussInfo)localObject).discuss_remark.has()) || (((msg_comm.DiscussInfo)localObject).discuss_remark.get() == null)) {
        break label988;
      }
    }
    label982:
    label985:
    label988:
    for (paramArrayList1 = ((msg_comm.DiscussInfo)localObject).discuss_remark.get().toByteArray();; paramArrayList1 = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMessageProcessor", 2, "<---discussionMsgRecordHandle_PB : fromUin:" + l4 + ",toUin:" + l2 + ",msgTime:" + k + ",msgSeq:" + l3 + ",msgUid:" + l5 + ",userActive:" + m + ",fromInstid:" + n + ",disUin:" + l1 + ",disType:" + i1 + ",disSeq:" + l6 + ",remarkSender:" + Arrays.toString(paramArrayList1) + ",hasAppShare:" + localMsg.appshare_info.has() + ",hasMsgBody:" + localMsg.msg_body.has());
      }
      localObject = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      PBDecodeContext localPBDecodeContext = new PBDecodeContext();
      localPBDecodeContext.e = l1;
      localPBDecodeContext.c = 3000;
      localPBDecodeContext.d = i1;
      if (localMsg.content_head.has())
      {
        msg_comm.ContentHead localContentHead = (msg_comm.ContentHead)localMsg.content_head.get();
        k = localContentHead.div_seq.get();
        m = localContentHead.pkg_index.get();
        n = localContentHead.pkg_num.get();
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.DiscMessageProcessor", 2, "<---discussionMsgRecordHandle_PB ContentHead. disUin:" + l1 + ", divSeq:" + k + ",pkgIndex:" + m + ",pkgNum:" + n);
        }
      }
      l2 = System.currentTimeMillis();
      for (;;)
      {
        try
        {
          a(localMsg, localArrayList2, localPBDecodeContext, true, null);
          if (!QLog.isColorLevel()) {
            break label985;
          }
          l3 = System.currentTimeMillis();
          QLog.d("Q.msg.DiscMessageProcessor", 2, "<---discussionMsgRecordHandle_PB decodeSinglePbMsg_Group. isUin:" + l1 + ", cost=" + (l3 - l2));
          l2 = l3;
          if (localArrayList2 != null) {
            a(localArrayList2, (ArrayList)localObject, true);
          }
          if (QLog.isColorLevel())
          {
            l3 = System.currentTimeMillis();
            QLog.d("Q.msg.DiscMessageProcessor", 2, "<---discussionMsgRecordHandle_PB msgListFilter. disUin:" + l1 + ", cost=" + (l3 - l2));
          }
          if (localObject == null) {
            break label982;
          }
          if (((ArrayList)localObject).size() >= 1) {}
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.w("Q.msg.DiscMessageProcessor", 2, "decodeSinglePbMsg_GroupDis error,", localException);
          continue;
          MessageHandlerUtils.a((List)localObject);
          paramArrayList2.addAll((Collection)localObject);
          if ((paramArrayList1 != null) && (paramArrayList1.length > 0))
          {
            localObject = String.valueOf(l4);
            String str = HexUtil.a(paramArrayList1) + ":" + (String)localObject;
            if (!localHashSet.contains(str))
            {
              paramArrayList1 = ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(paramArrayList1, String.valueOf(l1), (String)localObject, false);
              if (paramArrayList1 != null)
              {
                localArrayList1.add(paramArrayList1);
                localHashSet.add(str);
              }
            }
          }
        }
        break label62;
        l2 = System.currentTimeMillis();
        if (localArrayList1.size() > 0) {
          ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).c(localArrayList1);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        l3 = System.currentTimeMillis();
        QLog.d("Q.msg.DiscMessageProcessor", 2, "<---discussionMsgRecordHandle_PB saveDiscussionMemberInfoList. disUin:" + l1 + ", cost=" + (l3 - l2));
        return;
        break label62;
      }
    }
  }
  
  private void a(List paramList1, List paramList2)
  {
    Pair localPair = super.a(paramList1, paramList2);
    if ((((Boolean)localPair.first).booleanValue()) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder("<---DiscussionMessagePackage:msgFilter_OnePkg ");
      localStringBuilder.append((CharSequence)localPair.second);
      localStringBuilder.append(" inListSize:").append(paramList1.size()).append(" outListSize:").append(paramList2.size());
      QLog.d("Q.msg.DiscMessageProcessor", 2, localStringBuilder.toString());
    }
  }
  
  private void a(msg_comm.Msg paramMsg, FromServiceMsg paramFromServiceMsg, msg_onlinepush.PbPushMsg paramPbPushMsg, boolean paramBoolean)
  {
    Object localObject1 = (msg_comm.MsgHead)paramMsg.msg_head.get();
    if (!((msg_comm.MsgHead)localObject1).discuss_info.has())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMessageProcessor", 2, "<---handleMsgPush_PB_Group: no groupInfo.");
      }
      return;
    }
    Object localObject2 = (msg_comm.DiscussInfo)((msg_comm.MsgHead)localObject1).discuss_info.get();
    long l1 = ((msg_comm.MsgHead)localObject1).from_uin.get();
    long l4 = ((msg_comm.MsgHead)localObject1).to_uin.get();
    long l5 = ((msg_comm.MsgHead)localObject1).msg_seq.get();
    int i2 = ((msg_comm.MsgHead)localObject1).msg_time.get();
    long l6 = ((msg_comm.MsgHead)localObject1).msg_uid.get();
    int i3 = ((msg_comm.MsgHead)localObject1).user_active.get();
    int i4 = ((msg_comm.MsgHead)localObject1).from_instid.get();
    long l2 = ((msg_comm.DiscussInfo)localObject2).discuss_uin.get();
    int i5 = ((msg_comm.DiscussInfo)localObject2).discuss_type.get();
    long l7 = ((msg_comm.DiscussInfo)localObject2).discuss_info_seq.get();
    long l3;
    if (paramFromServiceMsg.getUin() == null)
    {
      localObject1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      l3 = ((Long)localObject1).longValue();
      if ((!((msg_comm.DiscussInfo)localObject2).discuss_remark.has()) || (((msg_comm.DiscussInfo)localObject2).discuss_remark.get() == null)) {
        break label1818;
      }
    }
    label1424:
    label1818:
    for (localObject1 = ((msg_comm.DiscussInfo)localObject2).discuss_remark.get().toByteArray();; localObject1 = null)
    {
      int n;
      int m;
      int k;
      if (paramMsg.content_head.has())
      {
        localObject2 = (msg_comm.ContentHead)paramMsg.content_head.get();
        n = ((msg_comm.ContentHead)localObject2).div_seq.get();
        m = ((msg_comm.ContentHead)localObject2).pkg_index.get();
        k = ((msg_comm.ContentHead)localObject2).pkg_num.get();
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.ao = i3;
        int i1 = paramFromServiceMsg.getRequestSsoSeq();
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a())
        {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l3, paramPbPushMsg.svrip.get(), i1);
          return;
          localObject1 = Long.valueOf(paramFromServiceMsg.getUin());
          break;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(String.valueOf(l2)) != 2)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(String.valueOf(l2), new Object[] { paramMsg, paramFromServiceMsg, paramPbPushMsg });
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.DiscMessageProcessor", 2, "handleMsgPush_PB_Dis unfinished discussionUin=" + l2);
          }
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l3, paramPbPushMsg.svrip.get(), i1);
          return;
        }
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder("<---handleMsgPush_PB_Dis ");
          paramFromServiceMsg.append(" fromUin:").append(l1).append(" toUin").append(l4).append(" msgTime:").append(i2).append(" msgSeq:").append(l5).append(" msgUid:").append(l6).append(" userActive:").append(i3).append(" fromInstid:").append(i4).append(" disUin:").append(l2).append(" disType:").append(i5).append(" disSeq:").append(l7).append(" remarkSender:").append(HexUtil.a((byte[])localObject1)).append(" divSeq:").append(n).append(" pkgIndex:").append(m).append(" pkgNum:").append(k).append(" hasShare:").append(paramMsg.appshare_info.has());
          QLog.d("Q.msg.DiscMessageProcessor", 2, paramFromServiceMsg.toString());
        }
        ((DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6)).b(l2);
        paramFromServiceMsg = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        paramFromServiceMsg.a(l1);
        localObject2 = new PBDecodeContext();
        ((PBDecodeContext)localObject2).e = l2;
        ((PBDecodeContext)localObject2).c = 3000;
        ((PBDecodeContext)localObject2).d = i5;
        localObject2 = a(paramMsg, (PBDecodeContext)localObject2);
        Object localObject3 = new HashSet();
        ArrayList localArrayList = new ArrayList();
        paramMsg = new ArrayList();
        if ((localObject2 != null) && (((List)localObject2).size() > 0))
        {
          MessageHandlerUtils.a((List)localObject2);
          m = ((List)localObject2).size();
          k = 0;
          if (k < m)
          {
            Object localObject4 = (MessageRecord)((List)localObject2).get(k);
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.DiscMessageProcessor", 2, "----------handleMsgPush_PB_Dis after analysis  mr.senderuin: " + ((MessageRecord)localObject4).senderuin + " mr.msgtype: " + ((MessageRecord)localObject4).msgtype + " mr.frienduin: " + ((MessageRecord)localObject4).frienduin + " mr.shmsgseq: " + ((MessageRecord)localObject4).shmsgseq + " mr.time:" + ((MessageRecord)localObject4).time + " mr.msg: " + ((MessageRecord)localObject4).getLogColorContent());
            }
            Object localObject5;
            if ((((MessageRecord)localObject4).senderuin != null) && (((MessageRecord)localObject4).senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())))
            {
              localObject5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject4).frienduin, 3000, (MessageRecord)localObject4);
              if (localObject5 != null)
              {
                if (((localObject4 instanceof MessageForText)) && ((localObject5 instanceof MessageForText)) && (((MessageRecord)localObject4).getRepeatCount() > 0))
                {
                  ((MessageRecord)localObject5).setRepeatCount(((MessageRecord)localObject4).getRepeatCount());
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.DiscMessageProcessor", 2, "<---handleMsgPush_PB_Dis ===> update findMr.repeatCount=" + ((MessageRecord)localObject5).getRepeatCount());
                  }
                }
                this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(((MessageRecord)localObject4).frienduin, 3000, ((MessageRecord)localObject5).uniseq, ((MessageRecord)localObject4).shmsgseq, ((MessageRecord)localObject4).time);
                this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a((MessageRecord)localObject4, (MessageRecord)localObject5);
                if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((MessageRecord)localObject5))
                {
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(((MessageRecord)localObject5).frienduin, 3000, ((MessageRecord)localObject5).uniseq);
                  a(6003, true, ((MessageRecord)localObject5).frienduin);
                  this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(((MessageRecord)localObject5).msgseq);
                }
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g(((MessageRecord)localObject4).frienduin, ((MessageRecord)localObject4).shmsgseq);
              }
            }
            for (;;)
            {
              k += 1;
              break;
              ((MessageRecord)localObject4).isread = true;
              ((MessageRecord)localObject4).issend = 2;
              this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(((MessageRecord)localObject4).frienduin, 3000, ((MessageRecord)localObject4).shmsgseq);
              paramMsg.add(localObject4);
              if ((k == 0) && (localObject1 != null) && (localObject1.length > 0))
              {
                String str = ((MessageRecord)localObject4).senderuin;
                localObject5 = HexUtil.a((byte[])localObject1) + ":" + str;
                if (!((HashSet)localObject3).contains(localObject5))
                {
                  localObject4 = paramFromServiceMsg.a((byte[])localObject1, ((MessageRecord)localObject4).frienduin, str, false);
                  if (localObject4 != null)
                  {
                    localArrayList.add(localObject4);
                    ((HashSet)localObject3).add(localObject5);
                  }
                }
              }
            }
          }
        }
        if (localArrayList.size() > 0) {
          paramFromServiceMsg.c(localArrayList);
        }
        paramFromServiceMsg = new ArrayList();
        if ((paramMsg != null) && (paramMsg.size() > 0)) {
          paramFromServiceMsg.addAll(paramMsg);
        }
        if (paramFromServiceMsg.size() > 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMsg);
          boolean bool2 = MessageHandlerUtils.a(paramFromServiceMsg);
          boolean bool3 = MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFromServiceMsg);
          m = MsgProxyUtils.a(paramFromServiceMsg, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          paramMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          if ((bool2) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause))
          {
            bool1 = true;
            paramMsg.a(paramFromServiceMsg, String.valueOf(l3), bool1);
            paramMsg = new HashMap();
            localObject1 = paramFromServiceMsg.iterator();
          }
          for (;;)
          {
            if (!((Iterator)localObject1).hasNext()) {
              break label1597;
            }
            localObject2 = (MessageRecord)((Iterator)localObject1).next();
            if (((MessageRecord)localObject2).istroop == 3000)
            {
              if (paramMsg.containsKey(((MessageRecord)localObject2).frienduin))
              {
                localObject3 = ((MessageRecord)localObject2).frienduin;
                if (((MessageRecord)localObject2).shmsgseq > ((Long)paramMsg.get(((MessageRecord)localObject2).frienduin)).longValue()) {}
                for (l1 = ((MessageRecord)localObject2).shmsgseq;; l1 = ((Long)paramMsg.get(((MessageRecord)localObject2).frienduin)).longValue())
                {
                  paramMsg.put(localObject3, Long.valueOf(l1));
                  break label1424;
                  bool1 = false;
                  break;
                }
              }
              paramMsg.put(((MessageRecord)localObject2).frienduin, Long.valueOf(Math.max(((MessageRecord)localObject2).shmsgseq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g(((MessageRecord)localObject2).frienduin))));
            }
          }
          label1597:
          localObject1 = paramMsg.keySet().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g((String)localObject2, ((Long)paramMsg.get(localObject2)).longValue());
          }
          paramMsg = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(l2);
          paramMsg = paramMsg.a(((StringBuilder)localObject1).toString(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
          k = 0;
          if (paramMsg != null)
          {
            if ((paramMsg.flag & 0x1) != 0) {
              break label1794;
            }
            k = 1;
          }
          if ((k == 0) || (!this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(bool2, bool3))) {
            break label1800;
          }
        }
        for (boolean bool1 = true;; bool1 = false)
        {
          a("handleMsgPush_PB_Dis", true, m, bool1, false);
          if (paramBoolean) {
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l3, paramPbPushMsg.svrip.get(), i1);
          }
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramFromServiceMsg);
          return;
          k = 0;
          break;
        }
        k = 0;
        m = 0;
        n = 0;
      }
    }
  }
  
  /* Error */
  private boolean a(long paramLong1, long paramLong2, short paramShort)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 106	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   9: lload_1
    //   10: invokevirtual 121	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13: ldc_w 1200
    //   16: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: lload_3
    //   20: invokevirtual 121	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   23: ldc_w 1200
    //   26: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: iload 5
    //   31: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   34: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: astore 7
    //   39: aload_0
    //   40: getfield 79	com/tencent/mobileqq/app/message/DiscMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   43: invokevirtual 659	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   46: invokevirtual 1202	com/tencent/mobileqq/service/message/MessageCache:a	()Ljava/util/ArrayList;
    //   49: aload 7
    //   51: invokevirtual 1203	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   54: ifeq +44 -> 98
    //   57: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   60: ifeq +30 -> 90
    //   63: ldc 14
    //   65: iconst_2
    //   66: new 106	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   73: ldc_w 1205
    //   76: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload 7
    //   81: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 1207	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   90: iconst_1
    //   91: istore 6
    //   93: aload_0
    //   94: monitorexit
    //   95: iload 6
    //   97: ireturn
    //   98: aload_0
    //   99: getfield 79	com/tencent/mobileqq/app/message/DiscMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   102: invokevirtual 659	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   105: aload 7
    //   107: invokevirtual 1208	com/tencent/mobileqq/service/message/MessageCache:a	(Ljava/lang/String;)V
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
    //   0	123	0	this	DiscMessageProcessor
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
  
  public czc a(int paramInt, MsgInfo paramMsgInfo, SvcReqPushMsg paramSvcReqPushMsg)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return null;
      if ((paramMsgInfo != null) && (paramSvcReqPushMsg != null)) {
        return new czc(a(paramMsgInfo, paramSvcReqPushMsg), false);
      }
      a(getClass().getName(), paramInt);
    }
  }
  
  public List a(msg_comm.Msg paramMsg, PBDecodeContext paramPBDecodeContext)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    try
    {
      a(paramMsg, localArrayList1, paramPBDecodeContext, true, null);
      a(localArrayList1, localArrayList2, true);
      return localArrayList2;
    }
    catch (Exception paramMsg)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.DiscMessageProcessor", 2, "decodeSinglePbMsg_GroupDis error,", paramMsg);
        }
      }
    }
  }
  
  public void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    ArrayList localArrayList;
    switch (paramInt)
    {
    default: 
      return;
    case 1001: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 4))
      {
        a((msg_comm.Msg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], (msg_onlinepush.PbPushMsg)paramVarArgs[2], ((Boolean)paramVarArgs[3]).booleanValue());
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    case 1002: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        localArrayList = new ArrayList();
        a((ArrayList)paramVarArgs[1], localArrayList);
        a((ToServiceMsg)paramVarArgs[0], localArrayList, (msg_svc.PbGetDiscussMsgResp)paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    case 1003: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 4))
      {
        localArrayList = new ArrayList();
        a((ArrayList)paramVarArgs[1], localArrayList);
        a((ToServiceMsg)paramVarArgs[0], localArrayList, (msg_svc.PbGetDiscussMsgResp)paramVarArgs[2], (String)paramVarArgs[3]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length == 3))
    {
      a((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], (SvcResponseSetConfMsgRead)paramVarArgs[2]);
      return;
    }
    a(getClass().getName(), paramInt);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    a(true, false, false, 0L, new cyr(this, paramLong1, paramLong2));
  }
  
  public void a(DisMsgReadedNotify paramDisMsgReadedNotify)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.DiscMessageProcessor", 2, "DisMsgReadedNotify lDisUin is " + paramDisMsgReadedNotify.lDisUin + ", lMemberSeq  is " + paramDisMsgReadedNotify.lMemberSeq);
    }
    String str = String.valueOf(paramDisMsgReadedNotify.lDisUin);
    Object[] arrayOfObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str);
    if ((arrayOfObject != null) && (arrayOfObject.length >= 2))
    {
      long l = ((Long)arrayOfObject[0]).longValue();
      ((Long)arrayOfObject[1]).longValue();
      if (l < paramDisMsgReadedNotify.lMemberSeq) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(str, new Object[] { Long.valueOf(paramDisMsgReadedNotify.lMemberSeq), Long.valueOf(paramDisMsgReadedNotify.lDisMsgSeq) });
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, 3000, paramDisMsgReadedNotify.lMemberSeq);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(str, paramDisMsgReadedNotify.lMemberSeq);
  }
  
  public void b(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    a(paramToServiceMsg, paramFromServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.DiscMessageProcessor
 * JD-Core Version:    0.7.0.1
 */