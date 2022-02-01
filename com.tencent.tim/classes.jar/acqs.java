import OnlinePushPack.MsgInfo;
import OnlinePushPack.SvcReqPushMsg;
import PushNotifyPack.DisMsgReadedNotify;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.DiscMessageProcessor.1;
import com.tencent.mobileqq.app.message.DiscMessageProcessor.2;
import com.tencent.mobileqq.app.message.DiscMessageProcessor.3;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.data.MessageForQQWalletTips;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.revokemsg.RevokeMsgInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
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
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import msf.msgcomm.msg_comm.AppShareInfo;
import msf.msgcomm.msg_comm.ContentHead;
import msf.msgcomm.msg_comm.DiscussInfo;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgsvc.msg_svc.PbDiscussReadedReportReq;
import msf.msgsvc.msg_svc.PbGetDiscussMsgResp;
import msf.msgsvc.msg_svc.PbMsgReadedReportReq;
import msf.onlinepush.msg_onlinepush.PbPushMsg;
import tencent.im.apollo_game_status.STCMGameMessage;
import tencent.im.apollo_push_msgInfo.STPushMsgElem;
import tencent.im.conf.sysmsg_0x20c_0x20.Convert2Group;
import tencent.im.conf.sysmsg_0x20c_0x20.MemberNumRemind;
import tencent.im.conf.sysmsg_0x20c_0x20.SysMsgBody;
import tencent.im.conf.sysmsg_0x20c_0x20.UploadFileRemind;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msgrevoke.msgrevoke_userdef.MsgInfoUserDef;
import tencent.im.msgrevoke.msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef;
import tencent.im.oidb.cmd0x858.oidb_0x858.GoldMsgTipsElem;
import tencent.im.oidb.cmd0x858.oidb_0x858.MessageRecallReminder;
import tencent.im.oidb.cmd0x858.oidb_0x858.MessageRecallReminder.MessageMeta;
import tencent.im.oidb.cmd0x858.oidb_0x858.NotifyMsgBody;
import tencent.im.oidb.cmd0x858.oidb_0x858.NotifyObjmsgUpdate;
import tencent.im.oidb.cmd0x858.oidb_0x858.RedGrayTipsInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xaa.SubMsgType0xaa.MsgBody;

public class acqs
  extends tnx
{
  public final ConcurrentHashMap<String, ArrayList<Pair<String, String>>> ey = new ConcurrentHashMap();
  Handler mSubHandler;
  
  public acqs(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
  }
  
  private MessageRecord a(MsgInfo paramMsgInfo, SvcReqPushMsg paramSvcReqPushMsg)
  {
    paramMsgInfo = c(paramMsgInfo, paramSvcReqPushMsg.lUin);
    if ((paramMsgInfo != null) && (!achp.a(this.app, paramMsgInfo, true))) {
      return paramMsgInfo;
    }
    return null;
  }
  
  private void a(byte paramByte, long paramLong1, long paramLong2)
  {
    if (paramLong2 != Long.valueOf(this.app.getCurrentAccountUin()).longValue()) {}
    MqqHandler localMqqHandler;
    do
    {
      do
      {
        return;
      } while (paramByte != 2);
      localMqqHandler = this.app.getHandler(AVNotifyCenter.class);
    } while (localMqqHandler == null);
    Message localMessage = localMqqHandler.obtainMessage(10003);
    localMessage.obj = Long.valueOf(paramLong1);
    localMqqHandler.sendMessage(localMessage);
  }
  
  private void a(MsgInfo paramMsgInfo, long paramLong1, long paramLong2, long paramLong3, int paramInt)
  {
    MessageRecord localMessageRecord = anbi.d(-1050);
    String str = this.app.getApplication().getString(2131721589);
    switch (paramInt)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc", 2, "showUpdateToGroupTips: unknown type!");
      }
      return;
    }
    for (int i = 2131692851;; i = 2131692831)
    {
      localMessageRecord.init(paramLong2, paramLong1, paramLong3, this.app.getApplication().getString(i, new Object[] { str }), paramMsgInfo.uRealMsgTime, -1050, 3000, paramMsgInfo.uMsgTime);
      localMessageRecord.extStr = str;
      localMessageRecord.isread = true;
      localMessageRecord.extraflag = paramInt;
      this.app.b().b(localMessageRecord, localMessageRecord.selfuin);
      return;
    }
  }
  
  private void a(MsgInfo paramMsgInfo, long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    MessageRecord localMessageRecord = anbi.d(-1004);
    localMessageRecord.init(paramLong1, paramLong2, paramLong2, paramString, paramMsgInfo.uRealMsgTime, -1004, 3000, paramMsgInfo.uMsgTime);
    localMessageRecord.isread = true;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.DiscMsgPc", 2, "----------handleC2COnlinePushMsgResp after analysis friendUin: " + paramLong2 + " msgType: " + -1004 + " friendType: " + 3000 + " shMsgSeq: " + paramMsgInfo.shMsgSeq + " msgContent: " + aqft.pk(paramString));
    }
    if (!achp.a(this.app, localMessageRecord, false)) {
      this.app.b().b(localMessageRecord, String.valueOf(paramLong1));
    }
  }
  
  private void a(Pair<Long, String> paramPair1, MsgInfo paramMsgInfo, long paramLong1, long paramLong2, long paramLong3, byte paramByte, long paramLong4, Pair<Long, String> paramPair2)
  {
    long l1 = ((Long)paramPair1.first).longValue();
    long l2 = ((Long)paramPair2.first).longValue();
    paramPair1 = (String)paramPair1.second;
    if (TextUtils.isEmpty(paramPair1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc.discuss", 2, "coptype 0xb server showName empty");
      }
      paramPair1 = aqgv.m(this.app, String.valueOf(paramLong2), String.valueOf(l1));
    }
    for (;;)
    {
      String str = (String)paramPair2.second;
      paramPair2 = str;
      if (TextUtils.isEmpty(str))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.DiscMsgPc.discuss", 2, "coptype 0xb server shareName empty");
        }
        paramPair2 = aqgv.m(this.app, String.valueOf(paramLong2), String.valueOf(l2));
      }
      if (aqgv.aa(this.app, String.valueOf(paramLong2))) {
        paramPair1 = aqgv.m(this.app, String.valueOf(paramLong2), String.valueOf(l1));
      }
      if (paramLong4 == 0L) {
        paramPair1 = this.app.getApp().getString(2131692896, new Object[] { paramPair1 });
      }
      for (;;)
      {
        a(paramMsgInfo, paramLong1, paramLong2, paramLong3, paramPair1);
        return;
        if (paramLong4 == 1L) {
          paramPair1 = this.app.getApp().getString(2131692897, new Object[] { paramPair1, paramPair2 });
        } else if (paramLong4 == 2L) {
          paramPair1 = this.app.getApp().getString(2131693399, new Object[] { paramPair1 });
        } else {
          paramPair1 = this.app.getApp().getString(2131692892, new Object[] { paramPair1 });
        }
      }
    }
  }
  
  private void a(Pair<Long, String> paramPair, MsgInfo paramMsgInfo, ArrayList<Pair<String, String>> paramArrayList, long paramLong1, String paramString, byte paramByte, long paramLong2, boolean paramBoolean)
  {
    long l = ((Long)paramPair.first).longValue();
    String str = (String)paramPair.second;
    int m = paramArrayList.size();
    StringBuffer localStringBuffer;
    int j;
    label55:
    int k;
    if (m > 50)
    {
      i = 50;
      localStringBuffer = new StringBuffer(i * 10);
      j = 0;
      if (j >= i) {
        break label271;
      }
      paramPair = (Pair)paramArrayList.get(j);
      localObject = (String)paramPair.first;
      if (Long.valueOf((String)localObject).longValue() != paramLong1) {
        break label161;
      }
      k = 1;
      label98:
      if (k == 0) {
        break label167;
      }
      paramPair = this.app.getApp().getString(2131692901);
      a(paramByte, Long.valueOf(paramString).longValue(), paramLong1);
      label133:
      if (j != 0) {
        break label242;
      }
      localStringBuffer.append(paramPair);
    }
    for (;;)
    {
      j += 1;
      break label55;
      i = m;
      break;
      label161:
      k = 0;
      break label98;
      label167:
      paramPair = (String)paramPair.second;
      if ((!TextUtils.isEmpty(paramPair)) && (!aqgv.aa(this.app, paramString))) {
        break label133;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc.discuss", 2, "showWelcomeTips server name empty cOpType:" + paramByte);
      }
      paramPair = aqgv.m(this.app, paramString, (String)localObject);
      break label133;
      label242:
      localStringBuffer.append("、" + paramPair);
    }
    label271:
    if (m > 50)
    {
      localStringBuffer.append(" 等");
      localStringBuffer.append(m - 1);
      localStringBuffer.append("人");
    }
    int i = -1004;
    if (paramBoolean) {
      i = -5001;
    }
    paramArrayList = new ArrayList();
    Object localObject = anbi.d(i);
    paramPair = "";
    if (paramByte == 11) {
      paramPair = this.app.getApp().getString(2131692899);
    }
    if (paramByte == 22)
    {
      if (paramLong2 == 0L) {
        paramPair = this.app.getApp().getString(2131692899);
      }
      for (;;)
      {
        ((MessageRecord)localObject).init(paramLong1, paramMsgInfo.lFromUin, paramMsgInfo.lFromUin, paramPair, paramMsgInfo.uRealMsgTime, i, 3000, paramMsgInfo.uMsgTime);
        ((MessageRecord)localObject).isread = true;
        if ((localObject instanceof MessageForNewGrayTips)) {
          ((MessageForNewGrayTips)localObject).updateMsgData();
        }
        if (!achp.a(this.app, (MessageRecord)localObject, false)) {
          paramArrayList.add(localObject);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.DiscMsgPc", 2, "----------handleC2COnlinePushMsgResp after analysis(showWelcomeTips) friendUin: " + ((MessageRecord)localObject).frienduin + " msgType: " + i + " friendType: " + 3000 + " shMsgSeq: " + paramMsgInfo.shMsgSeq + " msgContent: " + ((MessageRecord)localObject).getLogColorContent());
        }
        if (paramArrayList.size() > 0) {
          this.app.b().s(paramArrayList, String.valueOf(paramLong1));
        }
        return;
        if (paramLong2 == 1L) {
          paramPair = this.app.getApp().getString(2131692900);
        } else if (paramLong2 == 2L) {
          paramPair = this.app.getApp().getString(2131693400, new Object[] { localStringBuffer.toString() });
        }
      }
    }
    if (l == paramLong1)
    {
      j = 1;
      label640:
      if (j == 0) {
        break label717;
      }
      if (!QLog.isColorLevel()) {
        break label837;
      }
      paramPair = this.app.getApp().getString(2131692873);
    }
    for (;;)
    {
      paramPair = paramPair + this.app.getApp().getString(2131692892, new Object[] { localStringBuffer.toString() });
      break;
      j = 0;
      break label640;
      label717:
      paramPair = str;
      if (TextUtils.isEmpty(str))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.DiscMsgPc.discuss", 2, "showWelcomeTips server invitorName empty cOpType:" + paramByte);
        }
        paramPair = aqgv.m(this.app, paramString, String.valueOf(l));
      }
      if (aqgv.aa(this.app, paramString)) {
        paramPair = aqgv.m(this.app, paramString, String.valueOf(l));
      }
      paramPair = paramPair + this.app.getApp().getString(2131692872);
      continue;
      label837:
      paramPair = "";
    }
  }
  
  private void a(Pair<Long, String> paramPair, MsgInfo paramMsgInfo, ArrayList<Pair<String, String>> paramArrayList, long paramLong, String paramString, byte paramByte, boolean paramBoolean)
  {
    if (this.mSubHandler == null) {
      this.mSubHandler = new Handler(ThreadManager.getSubThreadLooper());
    }
    this.mSubHandler.postDelayed(new DiscMessageProcessor.3(this, paramPair, paramMsgInfo, paramArrayList, paramLong, paramString, paramByte, paramBoolean), 2000L);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, int paramInt, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    int i = paramArrayOfByte.length - paramInt;
    paramMessageRecord = new byte[i];
    aqoj.c(paramArrayOfByte, paramInt, paramMessageRecord, i);
    paramArrayOfByte = new oidb_0x858.NotifyMsgBody();
    try
    {
      paramArrayOfByte.mergeFrom(paramMessageRecord);
      paramInt = paramArrayOfByte.opt_enum_type.get();
      l1 = paramArrayOfByte.opt_uint64_conf_uin.get();
      if ((paramInt != 7) || (!paramArrayOfByte.opt_msg_recall_reminder.has())) {
        return;
      }
      localObject1 = (oidb_0x858.MessageRecallReminder)paramArrayOfByte.opt_msg_recall_reminder.get();
      l2 = ((oidb_0x858.MessageRecallReminder)localObject1).uint64_uin.get();
      l3 = ((oidb_0x858.MessageRecallReminder)localObject1).uint64_admin_uin.get();
      paramArrayOfByte = new HashMap();
      try
      {
        paramMessageRecord = new msgrevoke_userdef.MsgInfoUserDef();
        paramMessageRecord.mergeFrom(((oidb_0x858.MessageRecallReminder)localObject1).bytes_userdef.get().toByteArray());
        paramInt = paramMessageRecord.uint32_long_message_flag.get();
        if (paramInt != 1) {
          break label216;
        }
        paramMessageRecord = ((ArrayList)paramMessageRecord.long_msg_info.get()).iterator();
        while (paramMessageRecord.hasNext())
        {
          localObject2 = (msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef)paramMessageRecord.next();
          paramArrayOfByte.put(Integer.valueOf(((msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef)localObject2).uint32_msg_seq.get()), localObject2);
        }
        QLog.d("revokeMsg", 2, "recv 0x20c_0x19 msg, parse msgInfoUserDef error");
      }
      catch (Exception paramQQAppInterface)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      long l1;
      Object localObject1;
      long l2;
      long l3;
      Object localObject2;
      label216:
      paramQQAppInterface.printStackTrace();
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.e("Q.msg.DiscMsgPc", 2, "parse0x20c_subType0x19 Exception " + paramQQAppInterface.getStackTrace());
      return;
      paramQQAppInterface.b().v(paramMessageRecord, false);
    }
    paramMessageRecord = new ArrayList();
    localObject1 = ((ArrayList)((oidb_0x858.MessageRecallReminder)localObject1).uint32_recalled_msg_list.get()).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject3 = (oidb_0x858.MessageRecallReminder.MessageMeta)((Iterator)localObject1).next();
      localObject2 = new RevokeMsgInfo();
      ((RevokeMsgInfo)localObject2).bYD = String.valueOf(l2);
      ((RevokeMsgInfo)localObject2).bYE = String.valueOf(l3);
      ((RevokeMsgInfo)localObject2).frienduin = String.valueOf(l1);
      ((RevokeMsgInfo)localObject2).istroop = 3000;
      ((RevokeMsgInfo)localObject2).shmsgseq = ((oidb_0x858.MessageRecallReminder.MessageMeta)localObject3).uint32_seq.get();
      ((RevokeMsgInfo)localObject2).time = ((oidb_0x858.MessageRecallReminder.MessageMeta)localObject3).uint32_time.get();
      ((RevokeMsgInfo)localObject2).dyl = ((oidb_0x858.MessageRecallReminder.MessageMeta)localObject3).uint32_is_anony_msg.get();
      if (paramInt == 1)
      {
        localObject3 = (msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef)paramArrayOfByte.get(Integer.valueOf(((oidb_0x858.MessageRecallReminder.MessageMeta)localObject3).uint32_seq.get()));
        ((RevokeMsgInfo)localObject2).dyi = ((msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef)localObject3).long_msg_id.get();
        ((RevokeMsgInfo)localObject2).dyj = ((msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef)localObject3).long_msg_num.get();
        ((RevokeMsgInfo)localObject2).dyk = ((msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef)localObject3).long_msg_index.get();
      }
      paramMessageRecord.add(localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("revokeMsg", 2, "recv 0x20c_0x19 msg," + ((RevokeMsgInfo)localObject2).toString());
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, ArrayList<msg_comm.Msg> paramArrayList, msg_svc.PbGetDiscussMsgResp paramPbGetDiscussMsgResp)
  {
    Object localObject = new ArrayList();
    String str = String.valueOf(paramToServiceMsg.extraData.getLong("lDisUin", paramPbGetDiscussMsgResp.discuss_uin.get()));
    long l1 = this.app.a().aG(str);
    StringBuilder localStringBuilder = new StringBuilder();
    if (QLog.isColorLevel())
    {
      localStringBuilder.append("<<---initGetPullDiscussionMsg discussUin: ").append(str).append(" res.cReplyCode: ").append(paramPbGetDiscussMsgResp.result.get()).append(" lastSeq: ").append(l1);
      QLog.d("Q.msg.DiscMsgPc_At_Me_DISC", 2, localStringBuilder.toString());
    }
    if (paramArrayList != null) {
      n(paramArrayList, (ArrayList)localObject);
    }
    if ((paramPbGetDiscussMsgResp.result.get() == 104) && (((ArrayList)localObject).size() == 0))
    {
      l1 = paramToServiceMsg.extraData.getLong("lEndSeq", paramPbGetDiscussMsgResp.return_end_seq.get());
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc", 2, "initGetPullDiscussionMsg reply 104 !! disUin=" + str + ", reqEndSeq=" + l1);
      }
      this.app.a().aL(str, l1);
    }
    for (int i = 1;; i = 0)
    {
      int j;
      boolean bool2;
      if (((ArrayList)localObject).size() > 0)
      {
        paramToServiceMsg = (acdt)this.app.getBusinessHandler(6);
        paramArrayList = ((ArrayList)localObject).iterator();
        while (paramArrayList.hasNext())
        {
          paramPbGetDiscussMsgResp = (MessageRecord)paramArrayList.next();
          if ((paramPbGetDiscussMsgResp.senderuin != null) && (paramPbGetDiscussMsgResp.senderuin.equals(this.app.getCurrentAccountUin())))
          {
            paramPbGetDiscussMsgResp.isread = true;
            paramPbGetDiscussMsgResp.issend = 2;
          }
          try
          {
            paramToServiceMsg.Y(Long.parseLong(paramPbGetDiscussMsgResp.frienduin), Long.parseLong(paramPbGetDiscussMsgResp.senderuin));
          }
          catch (Exception localException) {}
          if (QLog.isColorLevel()) {
            QLog.e("Q.msg.DiscMsgPc", 2, "processOffline exception when checkAndGetDiscussionMemberExist " + paramPbGetDiscussMsgResp.frienduin + ":" + paramPbGetDiscussMsgResp.senderuin);
          }
        }
        Collections.sort((List)localObject, this.w);
        paramToServiceMsg = new ArrayList();
        j = ((ArrayList)localObject).size() - 1;
        if (j >= 0)
        {
          paramArrayList = (MessageRecord)((ArrayList)localObject).get(j);
          if (QLog.isColorLevel())
          {
            localStringBuilder.setLength(0);
            localStringBuilder.append("----------initGetPullDiscussionMsg update send message  mr.senderuin: ").append(paramArrayList.senderuin).append(" mr.msgtype: ").append(paramArrayList.msgtype).append(" mr.frienduin: ").append(paramArrayList.frienduin).append(" mr.shmsgseq: ").append(paramArrayList.shmsgseq).append(" mr.time:").append(paramArrayList.time).append(" mr.msg: ").append(paramArrayList.getLogColorContent());
            QLog.d("Q.msg.DiscMsgPc", 2, localStringBuilder.toString());
          }
          if ((paramArrayList.senderuin != null) && (paramArrayList.senderuin.equalsIgnoreCase(this.app.getCurrentAccountUin())))
          {
            paramPbGetDiscussMsgResp = this.app.b().a(paramArrayList.frienduin, 3000, paramArrayList);
            if (paramPbGetDiscussMsgResp != null)
            {
              if (((paramArrayList instanceof MessageForText)) && ((paramPbGetDiscussMsgResp instanceof MessageForText)) && (paramArrayList.getRepeatCount() > 0))
              {
                paramPbGetDiscussMsgResp.setRepeatCount(paramArrayList.getRepeatCount());
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.DiscMsgPc", 2, "<---initGetPullDiscussionMsg_PB ===> update findMr.repeatCount=" + paramArrayList.getRepeatCount());
                }
              }
              if (!this.app.a().aww()) {
                this.app.a().e(paramPbGetDiscussMsgResp.frienduin, paramPbGetDiscussMsgResp.istroop, paramPbGetDiscussMsgResp.uniseq);
              }
              this.a.b(paramArrayList.frienduin, 3000, paramPbGetDiscussMsgResp.uniseq, paramArrayList.shmsgseq, paramArrayList.time);
              this.app.a().aQ(str, paramArrayList.shmsgseq);
            }
          }
          for (;;)
          {
            j -= 1;
            break;
            paramToServiceMsg.add(0, paramArrayList);
          }
        }
        int k = ((ArrayList)localObject).size();
        j = 0;
        while (j < k)
        {
          paramArrayList = (MessageRecord)((ArrayList)localObject).get(j);
          if ((paramArrayList instanceof MessageForMarketFace)) {
            ajdf.a(this.app, (MessageForMarketFace)paramArrayList);
          }
          j += 1;
        }
        j = 0;
        l1 = this.app.a().aG(str);
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
          paramArrayList = (tnu)this.app.b().a(3000);
          if (paramArrayList.a(str, 3000, paramToServiceMsg, this.app.getCurrentAccountUin())) {
            break label1314;
          }
          paramPbGetDiscussMsgResp = this.app.a().d(str);
          long l2 = ((Long)paramPbGetDiscussMsgResp[0]).longValue();
          k = paramToServiceMsg.size();
          j = 0;
          while (j < k)
          {
            if ((((MessageRecord)paramToServiceMsg.get(j)).senderuin != null) && (((MessageRecord)paramToServiceMsg.get(j)).senderuin.equalsIgnoreCase(this.app.getCurrentAccountUin())))
            {
              ((MessageRecord)paramToServiceMsg.get(j)).isread = true;
              ((MessageRecord)paramToServiceMsg.get(j)).issend = 2;
            }
            if (((Long)paramPbGetDiscussMsgResp[0]).longValue() >= ((MessageRecord)paramToServiceMsg.get(j)).shmsgseq) {
              ((MessageRecord)paramToServiceMsg.get(j)).isread = true;
            }
            j += 1;
          }
          bool2 = achp.F(paramToServiceMsg);
          j = top.a(paramToServiceMsg, this.app);
          paramPbGetDiscussMsgResp = this.app.b();
          localObject = this.app.getCurrentAccountUin();
          if ((bool2) && (this.app.isBackground_Stop))
          {
            bool1 = true;
            paramPbGetDiscussMsgResp.a(paramToServiceMsg, (String)localObject, bool1, false);
            paramArrayList.k(str, 3000, l2);
            paramArrayList.r(str, paramToServiceMsg);
          }
        }
      }
      label1173:
      label1314:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.app.a().aQ(str, l1);
        if ((this.a.aO(bool1)) && (!top.g(this.app, str, 3000)))
        {
          bool1 = true;
          a("initGetPullDiscussionMsg", true, j, bool1, false);
          this.a.dI(paramToServiceMsg);
          ((aqrc)this.app.getManager(235)).c.ka(paramToServiceMsg);
        }
        for (;;)
        {
          if ((i != 0) && (this.app.a().ec(str) == 1))
          {
            paramToServiceMsg = this.app.a().d(str);
            if (paramToServiceMsg != null)
            {
              l1 = ((Long)paramToServiceMsg[0]).longValue();
              ((tnu)this.app.b().a(3000)).k(str, 3000, l1);
            }
          }
          return;
          bool1 = false;
          break;
          bool1 = false;
          break label1173;
          i = 1;
          continue;
          i = 1;
        }
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, ArrayList<msg_comm.Msg> paramArrayList, msg_svc.PbGetDiscussMsgResp paramPbGetDiscussMsgResp, String paramString)
  {
    ArrayList localArrayList1 = new ArrayList();
    Object localObject1 = new HashSet();
    ArrayList localArrayList2 = new ArrayList();
    aozx localaozx = new aozx();
    Object localObject2;
    Object localObject3;
    long l1;
    long l2;
    long l3;
    int i;
    long l4;
    int j;
    int k;
    long l5;
    int m;
    long l6;
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc", 2, "<---refreshDiscussionHead_PB: size:" + paramArrayList.size());
      }
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (msg_comm.Msg)localIterator.next();
        paramArrayList = (msg_comm.MsgHead)((msg_comm.Msg)localObject2).msg_head.get();
        if (!paramArrayList.discuss_info.has())
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.DiscMsgPc", 2, "<---refreshDiscussionHead_PB: no discussInfo.");
          }
        }
        else
        {
          localObject3 = (msg_comm.DiscussInfo)paramArrayList.discuss_info.get();
          l1 = paramArrayList.from_uin.get();
          l2 = paramArrayList.to_uin.get();
          l3 = paramArrayList.msg_seq.get();
          i = paramArrayList.msg_time.get();
          l4 = paramArrayList.msg_uid.get();
          j = paramArrayList.user_active.get();
          k = paramArrayList.from_instid.get();
          l5 = ((msg_comm.DiscussInfo)localObject3).discuss_uin.get();
          m = ((msg_comm.DiscussInfo)localObject3).discuss_type.get();
          l6 = ((msg_comm.DiscussInfo)localObject3).discuss_info_seq.get();
          if ((!((msg_comm.DiscussInfo)localObject3).discuss_remark.has()) || (((msg_comm.DiscussInfo)localObject3).discuss_remark.get() == null)) {
            break label1191;
          }
        }
      }
    }
    label1191:
    for (paramArrayList = ((msg_comm.DiscussInfo)localObject3).discuss_remark.get().toByteArray();; paramArrayList = null)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.DiscMsgPc", 2, "<---refreshDiscussionHead_PB : fromUin:" + l1 + ",toUin:" + l2 + ",msgTime:" + i + ",msgSeq:" + l3 + ",msgUid:" + l4 + ",userActive:" + j + ",fromInstid:" + k + ",disUin:" + l5 + ",disType:" + m + ",disSeq:" + l6 + ",remarkSender:" + Arrays.toString(paramArrayList) + ",hasAppShare:" + ((msg_comm.Msg)localObject2).appshare_info.has() + ",hasMsgBody:" + ((msg_comm.Msg)localObject2).msg_body.has());
        }
        localObject3 = new ArrayList();
        ArrayList localArrayList3 = new ArrayList();
        anbl localanbl = new anbl();
        localanbl.friendUin = l5;
        localanbl.uinType = 3000;
        localanbl.dEX = m;
        if (((msg_comm.Msg)localObject2).content_head.has())
        {
          msg_comm.ContentHead localContentHead = (msg_comm.ContentHead)((msg_comm.Msg)localObject2).content_head.get();
          i = localContentHead.div_seq.get();
          j = localContentHead.pkg_index.get();
          k = localContentHead.pkg_num.get();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.DiscMsgPc", 2, "<---refreshDiscussionHead_PB ContentHead: divSeq:" + i + ",pkgIndex:" + j + ",pkgNum:" + k);
          }
        }
        try
        {
          a((msg_comm.Msg)localObject2, localArrayList3, localanbl, true, localaozx);
          if (localArrayList3.size() > 0) {
            a(localArrayList3, (ArrayList)localObject3, true);
          }
          if ((localObject3 == null) || (((ArrayList)localObject3).size() < 1)) {
            break;
          }
          achp.iZ((List)localObject3);
          localArrayList1.addAll((Collection)localObject3);
          achp.a("Q.msg.DiscMsgPc", paramString, l3, this.app.getAccount(), String.valueOf(l5));
          if ((paramArrayList == null) || (paramArrayList.length <= 0)) {
            break;
          }
          localObject3 = String.valueOf(l1);
          localObject2 = aqhs.bytes2HexStr(paramArrayList) + ":" + (String)localObject3;
          if (((HashSet)localObject1).contains(localObject2)) {
            break;
          }
          paramArrayList = ((acdu)this.app.getManager(53)).a(paramArrayList, String.valueOf(l5), (String)localObject3, false);
          if (paramArrayList == null) {
            break;
          }
          localArrayList2.add(paramArrayList);
          ((HashSet)localObject1).add(localObject2);
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.DiscMsgPc", 2, "decodeSinglePbMsg_GroupDis error,", localException2);
            }
          }
        }
      }
      if (localArrayList2.size() > 0) {
        ((acdu)this.app.getManager(53)).iH(localArrayList2);
      }
      paramArrayList = (acdt)this.app.getBusinessHandler(6);
      paramString = localArrayList1.iterator();
      while (paramString.hasNext())
      {
        localObject1 = (MessageRecord)paramString.next();
        if ((((MessageRecord)localObject1).senderuin != null) && (((MessageRecord)localObject1).senderuin.equalsIgnoreCase(this.app.getCurrentAccountUin()))) {
          ((MessageRecord)localObject1).issend = 2;
        }
        ((MessageRecord)localObject1).isread = true;
        try
        {
          paramArrayList.Y(Long.parseLong(((MessageRecord)localObject1).frienduin), Long.parseLong(((MessageRecord)localObject1).senderuin));
        }
        catch (Exception localException1) {}
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.DiscMsgPc", 2, "processRefreshHead exception when checkAndGetDiscussionMemberExist " + ((MessageRecord)localObject1).frienduin + ":" + ((MessageRecord)localObject1).senderuin);
        }
      }
      Collections.sort(localArrayList1, this.w);
      paramToServiceMsg = paramToServiceMsg.extraData.getBundle("context");
      paramArrayList = paramPbGetDiscussMsgResp.discuss_uin.toString();
      ((ajdr)this.app.getManager(37)).a(paramArrayList + "&" + 3000, localaozx);
      paramArrayList = new ArrayList();
      if (paramToServiceMsg != null)
      {
        paramToServiceMsg.putLong("beginSeq", paramPbGetDiscussMsgResp.return_begin_seq.get());
        paramToServiceMsg.putLong("endSeq", paramPbGetDiscussMsgResp.return_end_seq.get());
        paramToServiceMsg.putBoolean("success", true);
      }
      this.app.b().b(String.valueOf(paramPbGetDiscussMsgResp.discuss_uin.get()), 3000, localArrayList1, paramArrayList, paramToServiceMsg);
      this.a.dI(paramArrayList);
      ((aqrc)this.app.getManager(235)).c.ka(localArrayList1);
      return;
    }
  }
  
  private void a(msg_comm.Msg paramMsg, FromServiceMsg paramFromServiceMsg, msg_onlinepush.PbPushMsg paramPbPushMsg, boolean paramBoolean)
  {
    Object localObject1 = (msg_comm.MsgHead)paramMsg.msg_head.get();
    if (!((msg_comm.MsgHead)localObject1).discuss_info.has())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc", 2, "<---handleMsgPush_PB_Group: no groupInfo.");
      }
      return;
    }
    Object localObject2 = (msg_comm.DiscussInfo)((msg_comm.MsgHead)localObject1).discuss_info.get();
    long l1 = ((msg_comm.MsgHead)localObject1).from_uin.get();
    long l4 = ((msg_comm.MsgHead)localObject1).to_uin.get();
    long l5 = ((msg_comm.MsgHead)localObject1).msg_seq.get();
    int m = ((msg_comm.MsgHead)localObject1).msg_time.get();
    long l6 = ((msg_comm.MsgHead)localObject1).msg_uid.get();
    int n = ((msg_comm.MsgHead)localObject1).user_active.get();
    int i1 = ((msg_comm.MsgHead)localObject1).from_instid.get();
    long l2 = ((msg_comm.DiscussInfo)localObject2).discuss_uin.get();
    int i2 = ((msg_comm.DiscussInfo)localObject2).discuss_type.get();
    long l7 = ((msg_comm.DiscussInfo)localObject2).discuss_info_seq.get();
    long l3;
    if (paramFromServiceMsg.getUin() == null)
    {
      localObject1 = Long.valueOf(this.app.getCurrentAccountUin());
      l3 = ((Long)localObject1).longValue();
      if ((!((msg_comm.DiscussInfo)localObject2).discuss_remark.has()) || (((msg_comm.DiscussInfo)localObject2).discuss_remark.get() == null)) {
        break label1837;
      }
    }
    label1819:
    label1837:
    for (localObject1 = ((msg_comm.DiscussInfo)localObject2).discuss_remark.get().toByteArray();; localObject1 = null)
    {
      int k;
      int j;
      int i;
      if (paramMsg.content_head.has())
      {
        localObject2 = (msg_comm.ContentHead)paramMsg.content_head.get();
        k = ((msg_comm.ContentHead)localObject2).div_seq.get();
        j = ((msg_comm.ContentHead)localObject2).pkg_index.get();
        i = ((msg_comm.ContentHead)localObject2).pkg_num.get();
      }
      for (;;)
      {
        this.app.cxj = n;
        int i3 = paramFromServiceMsg.getRequestSsoSeq();
        if (!this.app.a.abS())
        {
          this.a.E(l3, paramPbPushMsg.svrip.get(), i3);
          return;
          localObject1 = Long.valueOf(paramFromServiceMsg.getUin());
          break;
        }
        if (!MessageHandler.bIl)
        {
          if (this.app.a().ec(String.valueOf(l2)) != 2)
          {
            this.app.a().t(String.valueOf(l2), new Object[] { paramMsg, paramFromServiceMsg, paramPbPushMsg });
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.DiscMsgPc", 2, "handleMsgPush_PB_Dis unfinished discussionUin=" + l2);
            }
            this.a.E(l3, paramPbPushMsg.svrip.get(), i3);
          }
        }
        else if (!this.app.a.abU())
        {
          this.app.a().t(String.valueOf(l2), new Object[] { paramMsg, paramFromServiceMsg, paramPbPushMsg });
          this.a.E(l3, paramPbPushMsg.svrip.get(), i3);
          return;
        }
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder("<---handleMsgPush_PB_Dis ");
          paramFromServiceMsg.append(" fromUin:").append(l1).append(" toUin").append(l4).append(" msgTime:").append(m).append(" msgSeq:").append(l5).append(" msgUid:").append(l6).append(" userActive:").append(n).append(" fromInstid:").append(i1).append(" disUin:").append(l2).append(" disType:").append(i2).append(" disSeq:").append(l7).append(" remarkSender:").append(aqhs.bytes2HexStr((byte[])localObject1)).append(" divSeq:").append(k).append(" pkgIndex:").append(j).append(" pkgNum:").append(i).append(" hasShare:").append(paramMsg.appshare_info.has());
          QLog.d("Q.msg.DiscMsgPc", 2, paramFromServiceMsg.toString());
        }
        ((acdt)this.app.getBusinessHandler(6)).Y(l2, l1);
        ((acff)this.app.getManager(51)).hu(l1);
        paramFromServiceMsg = (acdu)this.app.getManager(53);
        localObject2 = new anbl();
        ((anbl)localObject2).friendUin = l2;
        ((anbl)localObject2).uinType = 3000;
        ((anbl)localObject2).dEX = i2;
        paramMsg = a(paramMsg, (anbl)localObject2);
        Object localObject3 = new HashSet();
        Object localObject4 = new ArrayList();
        localObject2 = new ArrayList();
        if ((paramMsg != null) && (paramMsg.size() > 0))
        {
          achp.iZ(paramMsg);
          j = paramMsg.size();
          i = 0;
          if (i < j)
          {
            Object localObject5 = (MessageRecord)paramMsg.get(i);
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.DiscMsgPc", 2, "----------handleMsgPush_PB_Dis after analysis  mr.senderuin: " + ((MessageRecord)localObject5).senderuin + " mr.msgtype: " + ((MessageRecord)localObject5).msgtype + " mr.frienduin: " + ((MessageRecord)localObject5).frienduin + " mr.shmsgseq: " + ((MessageRecord)localObject5).shmsgseq + " mr.time:" + ((MessageRecord)localObject5).time + " mr.msg: " + ((MessageRecord)localObject5).getLogColorContent());
            }
            Object localObject6;
            if ((((MessageRecord)localObject5).senderuin != null) && (((MessageRecord)localObject5).senderuin.equalsIgnoreCase(this.app.getCurrentAccountUin())))
            {
              localObject6 = this.app.b().a(((MessageRecord)localObject5).frienduin, 3000, (MessageRecord)localObject5);
              if (localObject6 != null)
              {
                if (((localObject5 instanceof MessageForText)) && ((localObject6 instanceof MessageForText)) && (((MessageRecord)localObject5).getRepeatCount() > 0))
                {
                  ((MessageRecord)localObject6).setRepeatCount(((MessageRecord)localObject5).getRepeatCount());
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.DiscMsgPc", 2, "<---handleMsgPush_PB_Dis ===> update findMr.repeatCount=" + ((MessageRecord)localObject6).getRepeatCount());
                  }
                }
                this.a.b(((MessageRecord)localObject5).frienduin, 3000, ((MessageRecord)localObject6).uniseq, ((MessageRecord)localObject5).shmsgseq, ((MessageRecord)localObject5).time);
                this.a.a((MessageRecord)localObject5, (MessageRecord)localObject6);
                y((MessageRecord)localObject6);
                this.app.a().aQ(((MessageRecord)localObject5).frienduin, ((MessageRecord)localObject5).shmsgseq);
                wte.a().h(this.app, ((MessageRecord)localObject6).uniseq);
              }
            }
            for (;;)
            {
              i += 1;
              break;
              ((MessageRecord)localObject5).isread = true;
              ((MessageRecord)localObject5).issend = 2;
              this.c.s(((MessageRecord)localObject5).frienduin, 3000, ((MessageRecord)localObject5).shmsgseq);
              if ((localObject5 instanceof MessageForMarketFace)) {
                ajdf.a(this.app, (MessageForMarketFace)localObject5);
              }
              ((ArrayList)localObject2).add(localObject5);
              if ((i == 0) && (localObject1 != null) && (localObject1.length > 0))
              {
                String str = ((MessageRecord)localObject5).senderuin;
                localObject6 = aqhs.bytes2HexStr((byte[])localObject1) + ":" + str;
                if (!((HashSet)localObject3).contains(localObject6))
                {
                  localObject5 = paramFromServiceMsg.a((byte[])localObject1, ((MessageRecord)localObject5).frienduin, str, false);
                  if (localObject5 != null)
                  {
                    ((ArrayList)localObject4).add(localObject5);
                    ((HashSet)localObject3).add(localObject6);
                  }
                }
              }
            }
          }
        }
        if (((ArrayList)localObject4).size() > 0) {
          paramFromServiceMsg.iH((List)localObject4);
        }
        paramFromServiceMsg = new ArrayList();
        if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0)) {
          paramFromServiceMsg.addAll((Collection)localObject2);
        }
        if (paramFromServiceMsg.size() > 0)
        {
          this.app.a().mp((List)localObject2);
          boolean bool2 = achp.F(paramFromServiceMsg);
          i = top.a(paramFromServiceMsg, this.app);
          localObject1 = this.app.b();
          if ((bool2) && (this.app.isBackground_Stop))
          {
            bool1 = true;
            ((QQMessageFacade)localObject1).c(paramFromServiceMsg, String.valueOf(l3), bool1);
            localObject1 = new HashMap();
            localObject2 = paramFromServiceMsg.iterator();
          }
          for (;;)
          {
            label1477:
            if (!((Iterator)localObject2).hasNext()) {
              break label1655;
            }
            localObject3 = (MessageRecord)((Iterator)localObject2).next();
            if (((MessageRecord)localObject3).istroop == 3000)
            {
              if (((Map)localObject1).containsKey(((MessageRecord)localObject3).frienduin))
              {
                localObject4 = ((MessageRecord)localObject3).frienduin;
                if (((MessageRecord)localObject3).shmsgseq > ((Long)((Map)localObject1).get(((MessageRecord)localObject3).frienduin)).longValue()) {}
                for (l1 = ((MessageRecord)localObject3).shmsgseq;; l1 = ((Long)((Map)localObject1).get(((MessageRecord)localObject3).frienduin)).longValue())
                {
                  ((Map)localObject1).put(localObject4, Long.valueOf(l1));
                  break label1477;
                  bool1 = false;
                  break;
                }
              }
              ((Map)localObject1).put(((MessageRecord)localObject3).frienduin, Long.valueOf(Math.max(((MessageRecord)localObject3).shmsgseq, this.app.a().aG(((MessageRecord)localObject3).frienduin))));
            }
          }
          label1655:
          localObject2 = ((Map)localObject1).keySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (String)((Iterator)localObject2).next();
            this.app.a().aQ((String)localObject3, ((Long)((Map)localObject1).get(localObject3)).longValue());
          }
          if ((!this.a.aO(bool2)) || (top.g(this.app, Long.toString(l2), 3000))) {
            break label1819;
          }
        }
        for (boolean bool1 = true;; bool1 = false)
        {
          a("handleMsgPush_PB_Dis", true, i, bool1, false);
          if (paramBoolean) {
            this.a.E(l3, paramPbPushMsg.svrip.get(), i3);
          }
          this.a.dI(paramFromServiceMsg);
          ((aqrc)this.app.getManager(235)).c.ka(paramMsg);
          return;
        }
        i = 0;
        j = 0;
        k = 0;
      }
    }
  }
  
  /* Error */
  private boolean a(long paramLong1, long paramLong2, short paramShort)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 164	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   9: lload_1
    //   10: invokevirtual 174	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13: ldc_w 1156
    //   16: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: lload_3
    //   20: invokevirtual 174	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   23: ldc_w 1156
    //   26: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: iload 5
    //   31: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   34: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: astore 7
    //   39: aload_0
    //   40: getfield 27	acqs:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   43: invokevirtual 574	com/tencent/mobileqq/app/QQAppInterface:a	()Lanaz;
    //   46: invokevirtual 1160	anaz:dD	()Ljava/util/ArrayList;
    //   49: aload 7
    //   51: invokevirtual 1161	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   54: ifeq +44 -> 98
    //   57: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   60: ifeq +30 -> 90
    //   63: ldc 111
    //   65: iconst_2
    //   66: new 164	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   73: ldc_w 1163
    //   76: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload 7
    //   81: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 1165	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   90: iconst_1
    //   91: istore 6
    //   93: aload_0
    //   94: monitorexit
    //   95: iload 6
    //   97: ireturn
    //   98: aload_0
    //   99: getfield 27	acqs:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   102: invokevirtual 574	com/tencent/mobileqq/app/QQAppInterface:a	()Lanaz;
    //   105: aload 7
    //   107: invokevirtual 1168	anaz:Qf	(Ljava/lang/String;)V
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
    //   0	123	0	this	acqs
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
  
  private void b(Pair<Long, String> paramPair, MsgInfo paramMsgInfo, ArrayList<Pair<String, String>> paramArrayList, long paramLong, String paramString, byte paramByte, boolean paramBoolean)
  {
    a(paramPair, paramMsgInfo, paramArrayList, paramLong, paramString, paramByte, 0L, paramBoolean);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, int paramInt, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    int i = paramArrayOfByte.length - paramInt;
    paramMessageRecord = new byte[i];
    aqoj.c(paramArrayOfByte, paramInt, paramMessageRecord, i);
    paramArrayOfByte = new oidb_0x858.NotifyMsgBody();
    try
    {
      paramArrayOfByte.mergeFrom(paramMessageRecord);
      paramInt = paramArrayOfByte.opt_enum_type.get();
      long l = paramArrayOfByte.opt_uint64_conf_uin.get();
      if (paramInt == 11)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloGameManager", 2, "apollo game status push, [Discussion].");
        }
        if (!paramArrayOfByte.opt_stcm_game_state.has()) {
          return;
        }
        paramArrayOfByte = (apollo_game_status.STCMGameMessage)paramArrayOfByte.opt_stcm_game_state.get();
        if (paramQQAppInterface == null) {
          return;
        }
        ((abhe)paramQQAppInterface.getManager(211)).a(0, 3000, Long.toString(l), paramArrayOfByte);
        return;
      }
      if (paramInt == 12)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPushManager", 2, "recv action push message, [Discussion].");
        }
        if (!paramArrayOfByte.apllo_msg_push.has()) {
          return;
        }
        paramArrayOfByte = (apollo_push_msgInfo.STPushMsgElem)paramArrayOfByte.apllo_msg_push.get();
        if (paramQQAppInterface == null) {
          return;
        }
        ((abht)paramQQAppInterface.getManager(227)).a(3000, paramArrayOfByte);
        return;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
      QLog.e("Q.msg.DiscMsgPc", 1, "parse0x20c_subType0x23 Exception " + paramQQAppInterface.getStackTrace());
      return;
    }
    if (paramInt == 13)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc", 2, "goldmsg push, [Discussion].");
      }
      if (paramArrayOfByte.opt_msg_goldtips.has())
      {
        paramQQAppInterface = (oidb_0x858.GoldMsgTipsElem)paramArrayOfByte.opt_msg_goldtips.get();
        if ((paramQQAppInterface.type.has()) && (paramQQAppInterface.type.get() == 3)) {
          aaca.a(3000, null, (oidb_0x858.GoldMsgTipsElem)paramArrayOfByte.opt_msg_goldtips.get());
        }
      }
    }
  }
  
  private void b(ArrayList<String> paramArrayList, String paramString1, String paramString2, String paramString3)
  {
    MessageRecord localMessageRecord = anbi.d(-1016);
    long l = anaz.gQ();
    if ((paramArrayList != null) && (paramArrayList.size() > 1))
    {
      int k = paramArrayList.size();
      if (k > 50) {}
      StringBuilder localStringBuilder;
      for (int i = 50;; i = k)
      {
        localStringBuilder = new StringBuilder(i * 10);
        int j = 1;
        while (j < i)
        {
          localStringBuilder.append((String)paramArrayList.get(j));
          if (j != i - 1) {
            localStringBuilder.append("、");
          }
          j += 1;
        }
      }
      if (k > 50)
      {
        localStringBuilder.append(" 等");
        localStringBuilder.append(k - 1);
        localStringBuilder.append("人");
      }
      paramArrayList = this.app.getApplication().getString(2131692343, new Object[] { localStringBuilder });
      localMessageRecord.init(paramString2, paramString1, paramString3, paramArrayList + this.app.getApplication().getString(2131696104), l, -1016, 3000, l);
      localMessageRecord.extStr = paramArrayList;
      localMessageRecord.isread = true;
      this.app.b().b(localMessageRecord, localMessageRecord.selfuin);
    }
  }
  
  private MessageRecord c(MsgInfo paramMsgInfo, long paramLong)
  {
    Object localObject6 = paramMsgInfo.vMsg;
    long l2 = paramMsgInfo.lFromUin;
    long l1 = aqoj.getLongData((byte[])localObject6, 0);
    byte b = localObject6[4];
    Object localObject5 = new ArrayList();
    Object localObject4 = (acdt)this.app.getBusinessHandler(6);
    Object localObject1 = (acff)this.app.getManager(51);
    Object localObject7 = (acdu)this.app.getManager(53);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.DiscMsgPc.discuss", 2, "handleDiscussionMemchangeMsg cOpType: " + b + ", dwConfUin=" + l1);
    }
    Object localObject3;
    long l3;
    int k;
    int j;
    long l4;
    long l5;
    switch (b)
    {
    case 4: 
    case 5: 
    case 8: 
    case 12: 
    case 13: 
    case 14: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    case 23: 
    case 26: 
    case 27: 
    case 28: 
    case 29: 
    case 30: 
    case 31: 
    case 33: 
    default: 
    case 1: 
    case 11: 
    case 2: 
    case 3: 
    case 6: 
    case 9: 
      do
      {
        do
        {
          return null;
          paramLong = aqoj.getLongData((byte[])localObject6, 5);
          l2 = aqoj.getLongData((byte[])localObject6, 9);
          new StringBuilder().append(String.valueOf(l1)).append("_").append(String.valueOf(paramLong)).toString();
          if ((paramMsgInfo.vNickName != null) && (paramMsgInfo.vNickName.size() > 0)) {
            localObject3 = (String)paramMsgInfo.vNickName.get(0);
          }
          if ((paramMsgInfo.vNickName != null) && (paramMsgInfo.vNickName.size() > 1)) {
            localObject3 = (String)paramMsgInfo.vNickName.get(1);
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.DiscMsgPc.discuss", 2, "handleDiscussionMemchangeMsg discussionUin: " + l1 + " memberUin: " + l2);
          }
          if (a(l2, l1, paramMsgInfo.shMsgSeq))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.DiscMsgPc.discuss", 2, "handleDiscussionMemchangeMsg memberChangeMsgFilter return");
            }
            return null;
          }
          ((acdt)localObject4).hk(l1);
          i = ((acdu)localObject7).cn(l1 + "");
        } while (((acdu)localObject7).au(String.valueOf(l1), String.valueOf(l2)));
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.DiscMsgPc.discuss", 2, "handleDiscussionUpdateMsg add discussion " + l1 + " member number by 1 " + l2 + " num: " + i);
        }
        paramMsgInfo = new DiscussionMemberInfo();
        paramMsgInfo.discussionUin = String.valueOf(l1);
        paramMsgInfo.memberUin = String.valueOf(l2);
        paramMsgInfo.flag = 0;
        localObject1 = ((acff)localObject1).e(String.valueOf(l2));
        if ((localObject1 != null) && (((Friends)localObject1).name != null)) {
          paramMsgInfo.memberName = ((Friends)localObject1).name;
        }
        ((acdu)localObject7).a(paramMsgInfo);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.DiscMsgPc.discuss", 2, "handleDiscussionMemchangeMsg setDiscussionMemberNum memnum" + i);
        }
        return null;
        l3 = aqoj.getLongData((byte[])localObject6, 5);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.DiscMsgPc.discuss", 2, "handleDiscussionMemchangeMsg discussionUin: " + l1 + " memberUin: " + l3);
        }
        localObject6 = String.valueOf(l3);
        if (a(l3, l1, paramMsgInfo.shMsgSeq)) {
          return null;
        }
        localObject3 = "";
        localObject1 = localObject3;
        if (paramMsgInfo.vNickName != null)
        {
          localObject1 = localObject3;
          if (paramMsgInfo.vNickName.size() > 0) {
            localObject1 = (String)paramMsgInfo.vNickName.get(0);
          }
        }
        if ((TextUtils.isEmpty((CharSequence)localObject1)) || (aqgv.aa(this.app, String.valueOf(l1))))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.DiscMsgPc.discuss", 2, "coptype 2 server memberName empty");
          }
          localObject1 = aqgv.m(this.app, String.valueOf(l1), (String)localObject6);
        }
        localObject1 = this.app.getApp().getString(2131692898, new Object[] { localObject1 });
        ((List)localObject5).add(localObject6);
        ((acdt)localObject4).a(l1, (String)localObject6, (List)localObject5, 10009);
        if (((String)localObject6).equals(this.app.getCurrentAccountUin()))
        {
          ((acdu)localObject7).eG(String.valueOf(l1), String.valueOf(l3));
          a(b, l1, l3);
          ((acdt)localObject4).Dz(String.valueOf(l1));
          return null;
        }
        ((acdt)localObject4).hk(l1);
        ((acdu)localObject7).eG(String.valueOf(l1), String.valueOf(l3));
        a(paramMsgInfo, paramLong, l2, l2, (String)localObject1);
        return null;
        localObject1 = paramMsgInfo.getVNickName();
        l2 = aqoj.getLongData((byte[])localObject6, 5);
        k = aqoj.b((byte[])localObject6, 13);
        localObject3 = new ArrayList();
        j = 15;
        for (i = 1; i < k + 1; i = (short)(i + 1))
        {
          localObject7 = (String)((ArrayList)localObject1).get(i);
          l3 = aqoj.getLongData((byte[])localObject6, j);
          j += 4;
          ((List)localObject5).add(String.valueOf(l3));
          ((ArrayList)localObject3).add(new Pair(String.valueOf(l3), localObject7));
        }
        localObject6 = new acdt.c();
        ((acdt.c)localObject6).memberCount = ((ArrayList)localObject1).size();
        ((acdt.c)localObject6).uin = String.valueOf(l1);
        ((acdt)localObject4).a((acdt.c)localObject6);
        ((acdt)localObject4).a(l1, String.valueOf(l2), (List)localObject5, 10004);
        localObject4 = new Pair(Long.valueOf(l2), ((ArrayList)localObject1).get(0));
        localObject6 = this.app.a().a();
        if (((acxw)localObject6).b(Long.toString(l1), 3000) != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.DiscMsgPc.discuss", 2, "handleDiscussionMemchangeMsg ru alreadyintab");
          }
          if (aqgv.aa(this.app, String.valueOf(l1)))
          {
            a((Pair)localObject4, paramMsgInfo, (ArrayList)localObject3, paramLong, String.valueOf(l1), b, false);
            return null;
          }
          b((Pair)localObject4, paramMsgInfo, (ArrayList)localObject3, paramLong, String.valueOf(l1), b, false);
          return null;
        }
        localObject5 = ((acxw)localObject6).a(Long.toString(l1), 3000);
        aalb.a((RecentUser)localObject5, this.app.b());
        ((RecentUser)localObject5).uin = Long.toString(l1);
        ((RecentUser)localObject5).lastmsgtime = paramMsgInfo.uRealMsgTime;
        ((RecentUser)localObject5).setType(3000);
        ((acxw)localObject6).e((RecentUser)localObject5);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.DiscMsgPc.discuss", 2, "handleDiscussionMemchangeMsg ru.lastmsgtime " + paramMsgInfo.uRealMsgTime);
        }
        localObject6 = this.app.getCurrentAccountUin();
        if (SelectMemberActivity.bAJ)
        {
          SelectMemberActivity.bAJ = false;
          b((Pair)localObject4, paramMsgInfo, (ArrayList)localObject3, paramLong, String.valueOf(l1), b, true);
        }
        for (;;)
        {
          return null;
          if (TextUtils.equals((CharSequence)localObject6, String.valueOf(l2)))
          {
            b((ArrayList)localObject1, ((RecentUser)localObject5).uin, (String)localObject6, (String)localObject6);
            anot.a(this.app, "CliOper", "", "", "Multi_call", "Show_discuss_tips", 0, 0, "", "", "", "");
          }
          else
          {
            b((Pair)localObject4, paramMsgInfo, (ArrayList)localObject3, paramLong, String.valueOf(l1), b, true);
          }
        }
        l2 = aqoj.getLongData((byte[])localObject6, 5);
        l3 = aqoj.getLongData((byte[])localObject6, 9);
        aqoj.getLongData((byte[])localObject6, 13);
        i = aqoj.b((byte[])localObject6, 17);
        localObject1 = new byte[i];
        aqoj.c((byte[])localObject6, 19, (byte[])localObject1, i);
        localObject5 = new String((byte[])localObject1);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.DiscMsgPc.discuss", 2, "cOptye:" + b + "dwCmdUin =" + l2 + " dwCmdTime=" + l3 + " strName=" + (String)localObject5);
        }
        if (l2 == paramLong)
        {
          localObject1 = this.app.getApp().getString(2131692839, new Object[] { localObject5 });
          ((acdt)localObject4).eE(String.valueOf(l1), (String)localObject5);
          a(paramMsgInfo, paramLong, l1, l2, (String)localObject1);
          return null;
        }
        localObject3 = "";
        localObject1 = ((acdu)localObject7).a(String.valueOf(l1));
        if ((localObject1 != null) && (((DiscussionInfo)localObject1).isDiscussHrMeeting())) {
          localObject1 = aqjl.a((acdu)localObject7, ((DiscussionInfo)localObject1).uin, String.valueOf(l2));
        }
        for (;;)
        {
          localObject3 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.DiscMsgPc.discuss", 2, "coptype 6 server opeaterName empty");
            }
            localObject3 = aqgv.m(this.app, String.valueOf(l1), String.valueOf(l2));
          }
          localObject1 = this.app.getApp().getString(2131692840, new Object[] { localObject3, localObject5 });
          break;
          localObject1 = localObject3;
          if (paramMsgInfo.vNickName != null)
          {
            localObject1 = localObject3;
            if (paramMsgInfo.vNickName.size() > 0) {
              localObject1 = (String)paramMsgInfo.vNickName.get(0);
            }
          }
        }
      } while (aqoj.b((byte[])localObject6, 5) == 0);
      k = aqoj.b((byte[])localObject6, 7);
      localObject4 = new ArrayList();
      i = 9;
      j = 0;
      while (j < k)
      {
        l3 = aqoj.getLongData((byte[])localObject6, i);
        localObject3 = "";
        localObject1 = localObject3;
        if (paramMsgInfo.vNickName != null)
        {
          localObject1 = localObject3;
          if (paramMsgInfo.vNickName.size() >= k) {
            localObject1 = (String)paramMsgInfo.vNickName.get(j);
          }
        }
        ((ArrayList)localObject4).add(new Pair(Long.valueOf(l3), localObject1));
        i += 4;
        j += 1;
      }
      j = aqoj.b((byte[])localObject6, i);
      localObject1 = new byte[j];
      aqoj.c((byte[])localObject6, i + 2, (byte[])localObject1, j);
      localObject1 = new String((byte[])localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc.discuss", 2, "cOptye:9 +uinList.size()=" + ((ArrayList)localObject4).size());
      }
      localObject3 = ((ArrayList)localObject4).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject5 = (Pair)((Iterator)localObject3).next();
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.DiscMsgPc.discuss", 2, "cOptye:9 +遍历uin uin=" + ((Pair)localObject5).first);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc.discuss", 2, "cOptye:9 +sTips=" + (String)localObject1 + "+lUin=" + paramLong);
      }
      if (this.mSubHandler == null) {
        this.mSubHandler = new Handler(ThreadManager.getSubThreadLooper());
      }
      this.mSubHandler.postDelayed(new DiscMessageProcessor.1(this, (ArrayList)localObject4, paramLong, l1, (String)localObject1, paramMsgInfo, l2), 2000L);
      return null;
    case 22: 
      l3 = aqoj.getLongData((byte[])localObject6, 5);
      aqoj.getLongData((byte[])localObject6, 9);
      l4 = aqoj.getLongData((byte[])localObject6, 13);
      l5 = aqoj.getLongData((byte[])localObject6, 17);
      if (l5 == 0L) {
        break;
      }
    }
    for (int i = 1;; i = 0)
    {
      localObject3 = "";
      localObject1 = localObject3;
      if (paramMsgInfo.vNickName != null)
      {
        localObject1 = localObject3;
        if (paramMsgInfo.vNickName.size() >= 1) {
          localObject1 = (String)paramMsgInfo.vNickName.get(0);
        }
      }
      localObject7 = new Pair(Long.valueOf(l3), localObject1);
      Object localObject8;
      Object localObject9;
      switch ((int)l4)
      {
      default: 
        localObject1 = this.app.a().a();
        if (((acxw)localObject1).b(Long.toString(l1), 3000) != null) {
          return null;
        }
        break;
      case 0: 
      case 1: 
      case 2: 
        k = aqoj.b((byte[])localObject6, 25);
        j = 27;
        localObject3 = "";
        localObject1 = localObject3;
        if (i != 0)
        {
          localObject1 = localObject3;
          if (paramMsgInfo.vNickName != null)
          {
            localObject1 = localObject3;
            if (paramMsgInfo.vNickName.size() >= 2) {
              localObject1 = (String)paramMsgInfo.vNickName.get(1);
            }
          }
        }
        localObject8 = new Pair(Long.valueOf(l5), localObject1);
        localObject1 = new acdt.c();
        ((acdt.c)localObject1).memberCount = k;
        ((acdt.c)localObject1).uin = String.valueOf(l1);
        ((acdt)localObject4).a((acdt.c)localObject1);
        localObject9 = new ArrayList();
        if (i != 0) {}
        for (i = 1;; i = 0)
        {
          int m = i + 1;
          i = 0;
          while (i < k)
          {
            String str = String.valueOf(aqoj.getLongData((byte[])localObject6, j));
            localObject3 = "";
            localObject1 = localObject3;
            if (paramMsgInfo.vNickName != null)
            {
              localObject1 = localObject3;
              if (paramMsgInfo.vNickName.size() >= k + m) {
                localObject1 = (String)paramMsgInfo.vNickName.get(i + m);
              }
            }
            ((ArrayList)localObject9).add(new Pair(str, localObject1));
            ((List)localObject5).add(str);
            j += 4;
            i += 1;
          }
        }
        i = 0;
        if (l4 == 0L) {
          i = 10007;
        }
        for (;;)
        {
          ((acdt)localObject4).a(l1, String.valueOf(l3), (List)localObject5, i);
          if (this.mSubHandler == null) {
            this.mSubHandler = new Handler(ThreadManager.getSubThreadLooper());
          }
          this.mSubHandler.postDelayed(new DiscMessageProcessor.2(this, l3, paramLong, (Pair)localObject7, paramMsgInfo, l1, l2, b, l4, (Pair)localObject8, (ArrayList)localObject9), 2000L);
          break;
          if (l4 == 1L) {
            i = 10006;
          } else if (l4 == 2L) {
            i = 10008;
          }
        }
      }
      localObject3 = ((acxw)localObject1).a(Long.toString(l1), 3000);
      ((RecentUser)localObject3).uin = Long.toString(l1);
      ((RecentUser)localObject3).lastmsgtime = paramMsgInfo.uRealMsgTime;
      ((RecentUser)localObject3).setType(3000);
      ((acxw)localObject1).e((RecentUser)localObject3);
      return null;
      i = localObject6.length - 5;
      localObject1 = new byte[i];
      aqoj.c((byte[])localObject6, 5, (byte[])localObject1, i);
      localObject3 = new oidb_0x858.NotifyMsgBody();
      paramMsgInfo = (MessageForQQWalletTips)anbi.d(-2029);
      try
      {
        ((oidb_0x858.NotifyMsgBody)localObject3).mergeFrom((byte[])localObject1);
        localObject1 = (oidb_0x858.RedGrayTipsInfo)((oidb_0x858.NotifyMsgBody)localObject3).opt_msg_redtips.get();
        paramMsgInfo.senderUin = (((oidb_0x858.RedGrayTipsInfo)localObject1).uint64_sender_uin.get() + "");
        paramMsgInfo.reciverUin = (((oidb_0x858.RedGrayTipsInfo)localObject1).uint64_receiver_uin.get() + "");
        paramMsgInfo.senderContent = ((oidb_0x858.RedGrayTipsInfo)localObject1).bytes_sender_rich_content.get().toStringUtf8();
        paramMsgInfo.reciverContent = ((oidb_0x858.RedGrayTipsInfo)localObject1).bytes_receiver_rich_content.get().toStringUtf8();
        paramMsgInfo.authKey = ((oidb_0x858.RedGrayTipsInfo)localObject1).bytes_authkey.get().toStringUtf8();
        paramMsgInfo.idiomSeq = ((oidb_0x858.RedGrayTipsInfo)localObject1).uint32_idiom_seq.get();
        paramMsgInfo.idiom = ((oidb_0x858.RedGrayTipsInfo)localObject1).bytes_idiom.get().toStringUtf8();
        paramMsgInfo.msgType = ((oidb_0x858.RedGrayTipsInfo)localObject1).sint32_msgtype.get();
        paramMsgInfo.richContent = ((oidb_0x858.RedGrayTipsInfo)localObject1).bytes_broadcast_rich_content.get().toStringUtf8();
        paramMsgInfo.lastPinyin = ((oidb_0x858.RedGrayTipsInfo)localObject1).bytes_idiom_alpha.get().toStringUtf8();
        paramMsgInfo.bytes_jumpurl = ((oidb_0x858.RedGrayTipsInfo)localObject1).bytes_jumpurl.get().toStringUtf8();
        paramMsgInfo.subChannel = ((oidb_0x858.RedGrayTipsInfo)localObject1).uint32_subchannel.get();
        paramMsgInfo.init(this.app.getCurrentAccountUin(), l2 + "", "", "[QQWallet Tips]", anaz.gQ(), -2029, 3000, anaz.gQ());
        paramMsgInfo.isread = true;
        paramMsgInfo.getBytes();
        paramMsgInfo.onReceiveGrapTips();
        return paramMsgInfo;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return paramMsgInfo;
      }
      a(this.app, (byte[])localObject6, 5, null, true);
      return null;
      aqoj.getLongData((byte[])localObject6, 5);
      aqoj.getLongData((byte[])localObject6, 9);
      i = localObject6[13];
      return null;
      l3 = aqoj.getLongData((byte[])localObject6, 5);
      l4 = aqoj.getLongData((byte[])localObject6, 9);
      i = aqoj.b(localObject6[13]);
      aqoj.a((byte[])localObject6, 14, i);
      i += 14;
      k = aqoj.b((byte[])localObject6, i);
      j = i + 2;
      Object localObject2 = new HashSet();
      i = 0;
      while (i < k)
      {
        l5 = aqoj.getLongData((byte[])localObject6, j);
        j += 4;
        ((HashSet)localObject2).add(String.valueOf(l5));
        ((List)localObject5).add(String.valueOf(l5));
        i += 1;
      }
      if (((HashSet)localObject2).size() <= 0) {
        break;
      }
      localObject3 = (acdt)this.app.getBusinessHandler(6);
      localObject4 = String.valueOf(l1);
      if (((HashSet)localObject2).contains(this.app.getCurrentAccountUin()))
      {
        if ((int)l4 < 0) {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.DiscMsgPc", 2, "0x7: kicked from the disc because of converting to a group，dwCmdTime=" + l4);
          }
        }
        for (;;)
        {
          ((acdt)localObject3).a(l1, String.valueOf(l3), (List)localObject5, 10005);
          return null;
          ((acdt)localObject3).Dz((String)localObject4);
          a(paramMsgInfo, paramLong, l2, l2, acfp.m(2131705125));
        }
      }
      ((acdt)localObject3).a((String)localObject4, (HashSet)localObject2);
      if (Long.getLong((String)localObject4) != null) {}
      for (paramLong = Long.getLong((String)localObject4).longValue();; paramLong = 0L)
      {
        ((acdt)localObject3).hk(paramLong);
        break;
      }
      l4 = aqoj.getLongData((byte[])localObject6, 5);
      l3 = aqoj.getLongData((byte[])localObject6, 9);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc.discuss", 2, "handleDiscussionMemchangeMsg discussionUin: " + l1 + " memberUin: " + l4);
      }
      localObject7 = String.valueOf(l4);
      if (a(l4, l1, paramMsgInfo.shMsgSeq)) {
        return null;
      }
      if (((String)localObject7).equals(this.app.getCurrentAccountUin())) {
        return null;
      }
      localObject3 = "";
      localObject2 = localObject3;
      if (paramMsgInfo.vNickName != null)
      {
        localObject2 = localObject3;
        if (paramMsgInfo.vNickName.size() > 0) {
          localObject2 = (String)paramMsgInfo.vNickName.get(0);
        }
      }
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.DiscMsgPc.discuss", 2, "coptype 2 server memberName empty");
        }
        localObject2 = aqgv.m(this.app, String.valueOf(l1), (String)localObject7);
      }
      for (;;)
      {
        k = aqoj.b((byte[])localObject6, 13);
        j = 15;
        localObject8 = new HashSet();
        i = 0;
        while (i < k)
        {
          l4 = aqoj.getLongData((byte[])localObject6, j);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.DiscMsgPc.discuss", 2, "handleDiscussionMemchangeMsg MSG_DISCUSSION_TYPE_KICKOUT_MEMBER uin=" + l4);
          }
          j += 4;
          ((HashSet)localObject8).add(String.valueOf(l4));
          ((List)localObject5).add(String.valueOf(l4));
          i += 1;
        }
        localObject3 = new StringBuffer();
        if (((HashSet)localObject8).size() > 0)
        {
          localObject6 = ((HashSet)localObject8).iterator();
          while (((Iterator)localObject6).hasNext())
          {
            localObject9 = (String)((Iterator)localObject6).next();
            ((StringBuffer)localObject3).append(aqgv.m(this.app, String.valueOf(l1), (String)localObject9)).append("、");
          }
        }
        if (((StringBuffer)localObject3).length() > 0) {}
        for (localObject3 = ((StringBuffer)localObject3).deleteCharAt(((StringBuffer)localObject3).toString().length() - 1).toString();; localObject3 = "")
        {
          localObject6 = (acdt)this.app.getBusinessHandler(6);
          ((acdt)localObject6).a(l1, (String)localObject7, (List)localObject5, 10005);
          localObject3 = this.app.getApp().getString(2131692895, new Object[] { localObject3 });
          if (((HashSet)localObject8).contains(this.app.getCurrentAccountUin()))
          {
            if ((int)l3 < 0)
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("Q.msg.DiscMsgPc", 2, "0x7: kicked from the disc because of converting to a group，dwCmdTime=" + l3);
              return null;
            }
            ((acdt)localObject6).Dz(String.valueOf(l1));
            a(paramMsgInfo, paramLong, l2, l2, acfp.m(2131705124));
            return null;
          }
          localObject2 = (String)localObject2 + acfp.m(2131705123) + (String)localObject3;
          ((acdt)localObject6).a(String.valueOf(l1), (HashSet)localObject8);
          ((acdt)localObject4).hk(l1);
          a(paramMsgInfo, paramLong, l2, l2, (String)localObject2);
          return null;
          i = (int)aqoj.getLongData((byte[])localObject6, 5);
          localObject2 = new byte[i];
          aqoj.c((byte[])localObject6, 9, (byte[])localObject2, i);
          localObject3 = new sysmsg_0x20c_0x20.SysMsgBody();
          try
          {
            ((sysmsg_0x20c_0x20.SysMsgBody)localObject3).mergeFrom((byte[])localObject2);
            if (!((sysmsg_0x20c_0x20.SysMsgBody)localObject3).u32_cmd.has()) {
              break label4679;
            }
            switch (((sysmsg_0x20c_0x20.SysMsgBody)localObject3).u32_cmd.get())
            {
            case 2: 
              if (!((sysmsg_0x20c_0x20.SysMsgBody)localObject3).msg_convert_to_group.has()) {
                break label4679;
              }
              localObject3 = (sysmsg_0x20c_0x20.Convert2Group)((sysmsg_0x20c_0x20.SysMsgBody)localObject3).msg_convert_to_group.get();
              paramMsgInfo = String.valueOf(((sysmsg_0x20c_0x20.Convert2Group)localObject3).u64_operator.get());
              localObject2 = String.valueOf(((sysmsg_0x20c_0x20.Convert2Group)localObject3).u64_group_code.get());
              localObject3 = String.valueOf(((sysmsg_0x20c_0x20.Convert2Group)localObject3).u64_discuss_code.get());
              if (((acdu)localObject7).jj != null)
              {
                ((acdu)localObject7).jj.put(localObject3, new String[] { localObject2, paramMsgInfo });
                ((acdu)localObject7).bL.add(localObject2);
              }
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.DiscMsgPc", 2, String.format("0x20(cmd=2): Discussion %s is converted to group %s by user %s.", new Object[] { localObject3, localObject2, paramMsgInfo }));
              }
              ((acdt)this.app.getBusinessHandler(6)).Dz(String.valueOf(l1));
              if ((BaseActivity.sTopActivity instanceof SplashActivity)) {}
              ((accc)this.app.getBusinessHandler(22)).notifyUI(41, true, new Object[] { Integer.valueOf(2131698372), localObject3, localObject2, Boolean.valueOf(this.app.getCurrentUin().equals(paramMsgInfo)) });
            }
          }
          catch (Exception paramMsgInfo)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.DiscMsgPc", 2, "0x20: Parsing data failed!");
            }
            return null;
          }
          if (!((sysmsg_0x20c_0x20.SysMsgBody)localObject3).msg_mem_num_remind.has()) {
            break label4679;
          }
          localObject2 = (sysmsg_0x20c_0x20.MemberNumRemind)((sysmsg_0x20c_0x20.SysMsgBody)localObject3).msg_mem_num_remind.get();
          i = ((sysmsg_0x20c_0x20.MemberNumRemind)localObject2).u32_mem_num.get();
          l1 = ((sysmsg_0x20c_0x20.MemberNumRemind)localObject2).u64_discuss_code.get();
          a(paramMsgInfo, l1, paramLong, l1, 1);
          if (!QLog.isColorLevel()) {
            break label4679;
          }
          QLog.d("Q.msg.DiscMsgPc", 2, String.format("0x20(cmd=3): Discussion %d remains %d members.", new Object[] { Long.valueOf(l1), Integer.valueOf(i) }));
          break label4679;
          if (!((sysmsg_0x20c_0x20.SysMsgBody)localObject3).msg_upload_file_remind.has()) {
            break label4679;
          }
          l1 = ((sysmsg_0x20c_0x20.UploadFileRemind)((sysmsg_0x20c_0x20.SysMsgBody)localObject3).msg_upload_file_remind.get()).u64_discuss_code.get();
          a(paramMsgInfo, l1, paramLong, paramLong, 2);
          if (!QLog.isColorLevel()) {
            break label4679;
          }
          QLog.d("Q.msg.DiscMsgPc", 2, String.format("0x20(cmd=4): Discussion %d gets a file uploaded.", new Object[] { Long.valueOf(l1) }));
          break label4679;
          if (QLog.isColorLevel()) {
            QLog.d("GameParty", 2, "recv 0x20c_0x22 online push");
          }
          c(this.app, (byte[])localObject6, 5, null, true);
          return null;
          if (QLog.isColorLevel()) {
            QLog.d("ApolloGameManager", 2, "recv 0x20c_0x23 online push.[Discussion]");
          }
          b(this.app, (byte[])localObject6, 5, null, true);
          return null;
        }
      }
    }
    label4679:
    return null;
  }
  
  public static void c(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, int paramInt, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    int i = paramArrayOfByte.length - paramInt;
    paramMessageRecord = new byte[i];
    aqoj.c(paramArrayOfByte, paramInt, paramMessageRecord, i);
    paramArrayOfByte = new oidb_0x858.NotifyMsgBody();
    try
    {
      paramArrayOfByte.mergeFrom(paramMessageRecord);
      paramInt = paramArrayOfByte.opt_enum_type.get();
      paramArrayOfByte.opt_uint64_conf_uin.get();
      if ((paramInt == 9) && (paramArrayOfByte.opt_msg_obj_update.has()))
      {
        paramMessageRecord = (oidb_0x858.NotifyObjmsgUpdate)paramArrayOfByte.opt_msg_obj_update.get();
        if (paramMessageRecord.bytes_ext_msg.has())
        {
          paramArrayOfByte = new SubMsgType0xaa.MsgBody();
          try
          {
            paramArrayOfByte.mergeFrom(paramMessageRecord.bytes_ext_msg.get().toByteArray());
            ((ahvn)paramQQAppInterface.getManager(156)).a(paramArrayOfByte, false);
            return;
          }
          catch (Exception paramMessageRecord)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("GameParty", 2, "recv 0x858_notifyobjmsgupdate, prase msgBody error");
              }
            }
          }
        }
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.DiscMsgPc", 2, "parse0x20c_subType0x22 Exception " + paramQQAppInterface.getStackTrace());
      }
    }
  }
  
  private void n(ArrayList<msg_comm.Msg> paramArrayList, ArrayList<MessageRecord> paramArrayList1)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc", 2, "discussionMsgRecordHandle_PB msgs is null or size <= 0");
      }
      return;
    }
    HashSet localHashSet = new HashSet();
    ArrayList localArrayList1 = new ArrayList();
    new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    long l1 = 0L;
    label62:
    msg_comm.Msg localMsg;
    Object localObject1;
    Object localObject2;
    long l4;
    long l2;
    long l3;
    int i;
    long l5;
    int j;
    int k;
    int m;
    long l6;
    if (localIterator.hasNext())
    {
      localMsg = (msg_comm.Msg)localIterator.next();
      localObject1 = new aozx();
      paramArrayList = (msg_comm.MsgHead)localMsg.msg_head.get();
      if ((!paramArrayList.discuss_info.has()) && (QLog.isColorLevel())) {
        QLog.d("Q.msg.DiscMsgPc", 2, "<---handleMsgPush_PB_Group: no groupInfo.");
      }
      localObject2 = (msg_comm.DiscussInfo)paramArrayList.discuss_info.get();
      l4 = paramArrayList.from_uin.get();
      l2 = paramArrayList.to_uin.get();
      l3 = paramArrayList.msg_seq.get();
      i = paramArrayList.msg_time.get();
      l5 = paramArrayList.msg_uid.get();
      j = paramArrayList.user_active.get();
      k = paramArrayList.from_instid.get();
      l1 = ((msg_comm.DiscussInfo)localObject2).discuss_uin.get();
      m = ((msg_comm.DiscussInfo)localObject2).discuss_type.get();
      l6 = ((msg_comm.DiscussInfo)localObject2).discuss_info_seq.get();
      if ((!((msg_comm.DiscussInfo)localObject2).discuss_remark.has()) || (((msg_comm.DiscussInfo)localObject2).discuss_remark.get() == null)) {
        break label998;
      }
    }
    label992:
    label995:
    label998:
    for (paramArrayList = ((msg_comm.DiscussInfo)localObject2).discuss_remark.get().toByteArray();; paramArrayList = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc", 2, "<---discussionMsgRecordHandle_PB : fromUin:" + l4 + ",toUin:" + l2 + ",msgTime:" + i + ",msgSeq:" + l3 + ",msgUid:" + l5 + ",userActive:" + j + ",fromInstid:" + k + ",disUin:" + l1 + ",disType:" + m + ",disSeq:" + l6 + ",remarkSender:" + Arrays.toString(paramArrayList) + ",hasAppShare:" + localMsg.appshare_info.has() + ",hasMsgBody:" + localMsg.msg_body.has());
      }
      localObject2 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      anbl localanbl = new anbl();
      localanbl.friendUin = l1;
      localanbl.uinType = 3000;
      localanbl.dEX = m;
      if (localMsg.content_head.has())
      {
        msg_comm.ContentHead localContentHead = (msg_comm.ContentHead)localMsg.content_head.get();
        i = localContentHead.div_seq.get();
        j = localContentHead.pkg_index.get();
        k = localContentHead.pkg_num.get();
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.DiscMsgPc", 2, "<---discussionMsgRecordHandle_PB ContentHead. disUin:" + l1 + ", divSeq:" + i + ",pkgIndex:" + j + ",pkgNum:" + k);
        }
      }
      l2 = System.currentTimeMillis();
      for (;;)
      {
        try
        {
          a(localMsg, localArrayList2, localanbl, true, (aozx)localObject1);
          if (!QLog.isColorLevel()) {
            break label995;
          }
          l3 = System.currentTimeMillis();
          QLog.d("Q.msg.DiscMsgPc", 2, "<---discussionMsgRecordHandle_PB decodeSinglePbMsg_Group. isUin:" + l1 + ", cost=" + (l3 - l2));
          l2 = l3;
          if (localArrayList2 != null) {
            a(localArrayList2, (ArrayList)localObject2, true);
          }
          if (QLog.isColorLevel())
          {
            l3 = System.currentTimeMillis();
            QLog.d("Q.msg.DiscMsgPc", 2, "<---discussionMsgRecordHandle_PB msgListFilter. disUin:" + l1 + ", cost=" + (l3 - l2));
          }
          if (localObject2 == null) {
            break label992;
          }
          if (((ArrayList)localObject2).size() >= 1) {}
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.w("Q.msg.DiscMsgPc", 2, "decodeSinglePbMsg_GroupDis error,", localException);
          continue;
          achp.iZ((List)localObject2);
          paramArrayList1.addAll((Collection)localObject2);
          if ((paramArrayList != null) && (paramArrayList.length > 0))
          {
            localObject1 = String.valueOf(l4);
            String str = aqhs.bytes2HexStr(paramArrayList) + ":" + (String)localObject1;
            if (!localHashSet.contains(str))
            {
              paramArrayList = ((acdu)this.app.getManager(53)).a(paramArrayList, String.valueOf(l1), (String)localObject1, false);
              if (paramArrayList != null)
              {
                localArrayList1.add(paramArrayList);
                localHashSet.add(str);
              }
            }
          }
        }
        break label62;
        l2 = System.currentTimeMillis();
        if (localArrayList1.size() > 0) {
          ((acdu)this.app.getManager(53)).iH(localArrayList1);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        l3 = System.currentTimeMillis();
        QLog.d("Q.msg.DiscMsgPc", 2, "<---discussionMsgRecordHandle_PB saveDiscussionMemberInfoList. disUin:" + l1 + ", cost=" + (l3 - l2));
        return;
        break label62;
      }
    }
  }
  
  private void t(List<msg_comm.Msg> paramList1, List<msg_comm.Msg> paramList2)
  {
    Pair localPair = super.a(paramList1, paramList2);
    if ((((Boolean)localPair.first).booleanValue()) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder("<---DiscussionMessagePackage:msgFilter_OnePkg ");
      localStringBuilder.append((CharSequence)localPair.second);
      localStringBuilder.append(" inListSize:").append(paramList1.size()).append(" outListSize:").append(paramList2.size());
      QLog.d("Q.msg.DiscMsgPc", 2, localStringBuilder.toString());
    }
  }
  
  public List<MessageRecord> a(msg_comm.Msg paramMsg, anbl paramanbl)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    aozx localaozx = new aozx();
    try
    {
      a(paramMsg, localArrayList1, paramanbl, true, localaozx);
      long l = paramMsg.msg_head.discuss_info.discuss_uin.get();
      ((ajdr)this.app.getManager(37)).a(String.valueOf(l) + "&" + 3000, localaozx);
      a(localArrayList1, localArrayList2, true);
      return localArrayList2;
    }
    catch (Exception paramMsg)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.DiscMsgPc", 2, "decodeSinglePbMsg_GroupDis error,", paramMsg);
        }
      }
    }
  }
  
  public tov a(int paramInt, MsgInfo paramMsgInfo, SvcReqPushMsg paramSvcReqPushMsg)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return null;
      if ((paramMsgInfo != null) && (paramSvcReqPushMsg != null)) {
        return new tov(a(paramMsgInfo, paramSvcReqPushMsg), false);
      }
      bN(getClass().getName(), paramInt);
    }
  }
  
  public void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  public void a(DisMsgReadedNotify paramDisMsgReadedNotify)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.DiscMsgPc", 2, "DisMsgReadedNotify lDisUin is " + paramDisMsgReadedNotify.lDisUin + ", lMemberSeq  is " + paramDisMsgReadedNotify.lMemberSeq);
    }
    String str = String.valueOf(paramDisMsgReadedNotify.lDisUin);
    Object[] arrayOfObject = this.app.a().d(str);
    if ((arrayOfObject != null) && (arrayOfObject.length >= 2))
    {
      long l = ((Long)arrayOfObject[0]).longValue();
      ((Long)arrayOfObject[1]).longValue();
      if (l < paramDisMsgReadedNotify.lMemberSeq) {
        this.app.a().r(str, new Object[] { Long.valueOf(paramDisMsgReadedNotify.lMemberSeq), Long.valueOf(paramDisMsgReadedNotify.lDisMsgSeq) });
      }
    }
    this.app.b().s(str, 3000, paramDisMsgReadedNotify.lMemberSeq);
    if (paramDisMsgReadedNotify.lMemberSeq >= 0L) {
      this.app.b().a.ea(str, 3000);
    }
  }
  
  public void b(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  public void f(int paramInt, Object... paramVarArgs)
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
      bN(getClass().getName(), paramInt);
      return;
    case 1002: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        localArrayList = new ArrayList();
        t((ArrayList)paramVarArgs[1], localArrayList);
        a((ToServiceMsg)paramVarArgs[0], localArrayList, (msg_svc.PbGetDiscussMsgResp)paramVarArgs[2]);
        return;
      }
      bN(getClass().getName(), paramInt);
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length == 4))
    {
      localArrayList = new ArrayList();
      t((ArrayList)paramVarArgs[1], localArrayList);
      a((ToServiceMsg)paramVarArgs[0], localArrayList, (msg_svc.PbGetDiscussMsgResp)paramVarArgs[2], (String)paramVarArgs[3]);
      return;
    }
    bN(getClass().getName(), paramInt);
  }
  
  public void m(String paramString, int paramInt, long paramLong)
  {
    super.m(paramString, paramInt, paramLong);
    msg_svc.PbMsgReadedReportReq localPbMsgReadedReportReq = new msg_svc.PbMsgReadedReportReq();
    msg_svc.PbDiscussReadedReportReq localPbDiscussReadedReportReq = new msg_svc.PbDiscussReadedReportReq();
    localPbDiscussReadedReportReq.conf_uin.set(Long.valueOf(paramString).longValue());
    localPbDiscussReadedReportReq.last_read_seq.set(paramLong);
    localPbMsgReadedReportReq.dis_read_report.add(localPbDiscussReadedReportReq);
    a(localPbMsgReadedReportReq);
  }
  
  public void onDestory()
  {
    if (this.mSubHandler != null) {
      this.mSubHandler.removeCallbacksAndMessages(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acqs
 * JD-Core Version:    0.7.0.1
 */