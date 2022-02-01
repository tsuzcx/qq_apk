import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.Apollo3DMessage;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopConfess;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.nearby.NearbyFlowerMessage;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.utils.VipUtils.b;
import com.tencent.mobileqq.utils.VipUtils.b.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import localpb.richMsg.SafeMsg.SafeMoreInfo;
import msf.msgcomm.msg_comm.AppShareInfo;
import msf.msgcomm.msg_comm.ContentHead;
import msf.msgcomm.msg_comm.GroupInfo;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.im_msg_body.AnonymousGroupMsg;
import tencent.im.msg.im_msg_body.Attr;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ElemFlags2;
import tencent.im.msg.im_msg_body.ExtraInfo;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.msg.im_msg_body.GroupBusinessMsg;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.Ptt;
import tencent.im.msg.im_msg_body.PubGroup;
import tencent.im.msg.im_msg_body.RichText;

public class tnx
  extends tnv
{
  protected Comparator w = new tnz(this);
  
  public tnx(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
  }
  
  private boolean n(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForArkApp))
    {
      paramMessageRecord = ((MessageForArkApp)paramMessageRecord).ark_app_message;
      if ((paramMessageRecord == null) || ((!"com.tencent.homeworkContent".equals(paramMessageRecord.appName)) && (!"com.tencent.test.homeworkContent".equals(paramMessageRecord.appName)))) {}
    }
    else
    {
      do
      {
        return true;
        if (!(paramMessageRecord instanceof MessageForStructing)) {
          break;
        }
        paramMessageRecord = ((MessageForStructing)paramMessageRecord).structingMsg;
      } while ((paramMessageRecord != null) && (paramMessageRecord.mMsgServiceID == 60));
    }
    return false;
  }
  
  private boolean o(MessageRecord paramMessageRecord)
  {
    return ((paramMessageRecord instanceof MessageForArkApp)) && ("com.tencent.qqopen.teamup".equals(((MessageForArkApp)paramMessageRecord).ark_app_message.appName));
  }
  
  private boolean p(MessageRecord paramMessageRecord)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramMessageRecord instanceof MessageForArkApp))
    {
      paramMessageRecord = (MessageForArkApp)paramMessageRecord;
      bool1 = bool2;
      if (paramMessageRecord.ark_app_message != null)
      {
        bool1 = bool2;
        if (adph.lb(paramMessageRecord.ark_app_message.appName)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  protected TroopMemberInfo a(msg_comm.Msg paramMsg, ArrayList<MessageRecord> paramArrayList, anbl paramanbl, boolean paramBoolean, aozx paramaozx)
  {
    long l5;
    Object localObject7;
    long l6;
    long l3;
    long l2;
    long l7;
    Object localObject8;
    Object localObject2;
    int m;
    int k;
    int j;
    long l1;
    try
    {
      l5 = System.currentTimeMillis();
      if ((paramanbl == null) || (paramMsg == null) || (paramArrayList == null)) {
        break label8148;
      }
      localObject7 = (msg_comm.MsgHead)paramMsg.msg_head.get();
      l6 = ((msg_comm.MsgHead)localObject7).from_uin.get();
      ((msg_comm.MsgHead)localObject7).to_uin.get();
      l3 = ((msg_comm.MsgHead)localObject7).msg_seq.get();
      l2 = ((msg_comm.MsgHead)localObject7).msg_time.get();
      l7 = this.app.getLongAccountUin();
      localObject8 = this.app.getCurrentAccountUin();
      if (paramanbl.uinType == 1026)
      {
        l3 = aqft.K(((msg_comm.MsgHead)localObject7).msg_seq.get());
        l2 = aqft.K(((msg_comm.MsgHead)localObject7).msg_time.get());
      }
      if (!paramMsg.content_head.has()) {
        break label8136;
      }
      localObject2 = (msg_comm.ContentHead)paramMsg.content_head.get();
      m = ((msg_comm.ContentHead)localObject2).div_seq.get();
      k = ((msg_comm.ContentHead)localObject2).pkg_num.get();
      j = ((msg_comm.ContentHead)localObject2).pkg_index.get();
      localObject2 = anbh.a(this.a, paramMsg, String.valueOf(l6), String.valueOf(l6));
      if (((Long)((Pair)localObject2).first).longValue() == 4294967295L) {
        break label1050;
      }
      l1 = ((Long)((Pair)localObject2).first).longValue();
    }
    catch (Throwable paramMsg)
    {
      label233:
      if (!QLog.isColorLevel()) {
        break label1048;
      }
      QLog.e("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "decodeSinglePbMsg_GroupDis failure : ", paramMsg);
      return null;
    }
    Object localObject3 = new ArrayList();
    aozx localaozx = new aozx();
    if (paramMsg.appshare_info.has())
    {
      anbo.a(this.a, (List)localObject3, paramMsg, paramanbl.friendUin, l2, false);
      localObject2 = null;
      l1 = 0L;
    }
    label284:
    label1145:
    int i;
    label1048:
    label1050:
    boolean bool1;
    label1421:
    label1692:
    label1821:
    label1843:
    label2000:
    int i1;
    label3085:
    int n;
    label3344:
    label3379:
    label3408:
    label3447:
    Object localObject5;
    label3614:
    label3653:
    boolean bool3;
    label3854:
    label4032:
    boolean bool2;
    label4114:
    int i5;
    int i4;
    int i3;
    label4570:
    int i2;
    boolean bool4;
    label4712:
    boolean bool5;
    int i9;
    int i8;
    int i7;
    int i6;
    label4911:
    label4932:
    label4953:
    label4974:
    int i18;
    label5131:
    label5150:
    int i17;
    label5638:
    int i16;
    int i15;
    int i14;
    int i13;
    int i12;
    int i10;
    int i11;
    boolean bool6;
    for (;;)
    {
      Object localObject4;
      if ((((List)localObject3).size() == 0) && (k > 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "<---decodeSinglePbMsg_GroupDis, empty long msg fragment");
        }
        localObject4 = (MessageForText)anbi.d(-1000);
        ((MessageForText)localObject4).msgtype = -1000;
        ((MessageForText)localObject4).msg = "";
        ((List)localObject3).add(localObject4);
      }
      byte b2 = 0;
      Iterator localIterator = ((List)localObject3).iterator();
      localObject3 = null;
      Object localObject6;
      long l8;
      if (localIterator.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
        localMessageRecord.time = l2;
        localMessageRecord.msgseq = l2;
        localMessageRecord.shmsgseq = l3;
        localMessageRecord.msgUid = l1;
        localMessageRecord.selfuin = ((String)localObject8);
        localMessageRecord.istroop = paramanbl.uinType;
        localMessageRecord.senderuin = String.valueOf(l6);
        localMessageRecord.frienduin = String.valueOf(paramanbl.friendUin);
        localMessageRecord.longMsgId = m;
        localMessageRecord.longMsgCount = k;
        localMessageRecord.longMsgIndex = j;
        if (((localMessageRecord instanceof MessageForFoldMsg)) && (QLog.isColorLevel())) {
          QLog.d("msgFold", 2, String.format("Recv, recv foldMsg, frienduin: %s, senduin: %s, msguid: %s, shmsgseq: %s content: %s", new Object[] { localMessageRecord.frienduin, localMessageRecord.senderuin, Long.valueOf(localMessageRecord.msgUid), Long.valueOf(localMessageRecord.shmsgseq), localMessageRecord.getLogColorContent() }));
        }
        if (paramanbl.dEX == 127)
        {
          localMessageRecord.msg = "PTT_URL";
          localMessageRecord.msgtype = -2006;
          localMessageRecord.isread = true;
        }
        if (localMessageRecord.msgtype == -1035) {
          ((ChatMessage)localMessageRecord).parse();
        }
        byte b1 = b2;
        if (((msg_comm.MsgHead)localObject7).msg_flag.has())
        {
          b1 = b2;
          if ((((msg_comm.MsgHead)localObject7).msg_flag.get() & 1L) == 1L)
          {
            b1 = b2;
            if (localMessageRecord.msgtype != -2058)
            {
              b2 = 1;
              localaozx.b.b(17, l3, localMessageRecord.uniseq);
              b1 = b2;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "receive the TroopMsg from TroopSpecialAttention!");
                b1 = b2;
              }
            }
          }
        }
        if ((localMessageRecord.istroop == 1) && (aqsz.a(this.app).bZ(localMessageRecord.msg, localMessageRecord.frienduin))) {
          localaozx.b.b(16, l3, localMessageRecord.uniseq);
        }
        if (((localMessageRecord instanceof MessageForTroopConfess)) && (((MessageForTroopConfess)localMessageRecord).isToSelf)) {
          localaozx.b.b(10, l3, localMessageRecord.uniseq);
        }
        if (n(localMessageRecord)) {
          localaozx.b.b(5, l3, localMessageRecord.uniseq);
        }
        if (o(localMessageRecord)) {
          localaozx.b.b(19, l3, localMessageRecord.uniseq);
        }
        if (p(localMessageRecord)) {
          localaozx.b.b(20, l3, localMessageRecord.uniseq);
        }
        Object localObject9;
        if (((paramanbl.uinType == 1) || (paramanbl.uinType == 1026)) && (localObject2 != null))
        {
          localObject4 = ((List)localObject2).iterator();
          for (;;)
          {
            if (((Iterator)localObject4).hasNext())
            {
              localObject6 = (im_msg_body.Elem)((Iterator)localObject4).next();
              if ((((im_msg_body.Elem)localObject6).general_flags.has()) && (((im_msg_body.Elem)localObject6).general_flags.bytes_pb_reserve.has()))
              {
                localObject9 = new generalflags.ResvAttr();
                ((generalflags.ResvAttr)localObject9).mergeFrom(((im_msg_body.Elem)localObject6).general_flags.bytes_pb_reserve.get().toByteArray());
                if ((((generalflags.ResvAttr)localObject9).uint32_group_savedb_flag.has()) && ((((generalflags.ResvAttr)localObject9).uint32_group_savedb_flag.get() & 0x1) == 1))
                {
                  localaozx.b.b(23, l3, localMessageRecord.uniseq);
                  if (QLog.isColorLevel())
                  {
                    QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "decodeSinglePbMsg_GroupDis, should show shop ark");
                    continue;
                    l1 = ((Long)((Pair)localObject2).second).longValue();
                    break label8150;
                    if (!paramMsg.msg_body.has()) {
                      break label8120;
                    }
                    localObject2 = (im_msg_body.MsgBody)paramMsg.msg_body.get();
                    if (!((im_msg_body.MsgBody)localObject2).rich_text.has()) {
                      break label8120;
                    }
                    localObject4 = (im_msg_body.RichText)((im_msg_body.MsgBody)localObject2).rich_text.get();
                    if (!((im_msg_body.RichText)localObject4).attr.has()) {
                      break label8114;
                    }
                    l1 = anbk.I(((im_msg_body.Attr)((im_msg_body.RichText)localObject4).attr.get()).random.get());
                    localObject2 = ((im_msg_body.RichText)localObject4).elems.get();
                    if (((im_msg_body.RichText)localObject4).ptt.has())
                    {
                      new anbu().a(this.a, paramMsg, (List)localObject3, null);
                      break;
                    }
                    localaozx.frienduin = String.valueOf(paramanbl.friendUin);
                    localaozx.uinType = paramanbl.uinType;
                    anbh.a(this.a, (List)localObject3, paramMsg, false, false, localaozx);
                    break;
                  }
                }
              }
            }
          }
        }
        if (localMessageRecord.msgtype == -1049)
        {
          localObject4 = (MessageForReplyText)localMessageRecord;
          if ((this.app.getCurrentAccountUin() != null) && (this.app.getCurrentAccountUin().equals(((MessageForReplyText)localObject4).mSourceMsgInfo.mSourceMsgSenderUin + ""))) {
            localaozx.b.b(22, l3, localMessageRecord.uniseq);
          }
        }
        if (localMessageRecord.msgtype == -5015) {
          localaozx.b.b(6, l3, localMessageRecord.uniseq);
        }
        if (localMessageRecord.msgtype == -2058) {
          EmojiStickerManager.f(localMessageRecord, this.app);
        }
        if (((localMessageRecord.msgtype != -2058) || (paramaozx.b.shmsgseq != -1L) || (paramaozx.b.uniseq != -1L)) || (localMessageRecord.msgtype == -1035))
        {
          localObject4 = (MessageForMixedMsg)localMessageRecord;
          i = 0;
          if (i < ((MessageForMixedMsg)localObject4).msgElemList.size())
          {
            localObject6 = (MessageRecord)((MessageForMixedMsg)localObject4).msgElemList.get(i);
            if (!(localObject6 instanceof MessageForReplyText)) {
              break label8168;
            }
            localObject4 = (MessageForReplyText)localObject6;
            if ((this.app.getCurrentAccountUin() != null) && (this.app.getCurrentAccountUin().equals(((MessageForReplyText)localObject4).mSourceMsgInfo.mSourceMsgSenderUin + ""))) {
              localaozx.b.b(22, l3, localMessageRecord.uniseq);
            }
          }
        }
        if ((localMessageRecord.msgtype == -2035) || (localMessageRecord.msgtype == -2038))
        {
          localObject4 = (MessageForDeliverGiftTips)localMessageRecord;
          localObject6 = aqgv.a(this.app, ((MessageForDeliverGiftTips)localObject4).istroop, ((MessageForDeliverGiftTips)localObject4).frienduin, ((MessageForDeliverGiftTips)localObject4).senderuin);
          if (!TextUtils.isEmpty((CharSequence)localObject6)) {
            ((MessageForDeliverGiftTips)localObject4).senderName = ((String)localObject6);
          }
          if (!((MessageForDeliverGiftTips)localObject4).isFromNearby)
          {
            localObject6 = this.app.getCurrentAccountUin();
            if (!TextUtils.isEmpty((CharSequence)localObject6))
            {
              if ((!((String)localObject6).equals(((MessageForDeliverGiftTips)localObject4).receiverUin + "")) && (!((MessageForDeliverGiftTips)localObject4).isToAll())) {
                break label3379;
              }
              localObject6 = localaozx.b;
              localObject9 = this.app;
              if (localMessageRecord.istroop != 1) {
                break label8177;
              }
              bool1 = true;
              ((aozy)localObject6).a((QQAppInterface)localObject9, bool1, localMessageRecord.frienduin, l3, localMessageRecord.uniseq);
            }
            localObject6 = (apqk)this.app.getManager(223);
            if (localObject6 != null) {
              ((apqk)localObject6).b((MessageForDeliverGiftTips)localObject4);
            }
          }
        }
        if (ajpt.aL(localMessageRecord))
        {
          localObject4 = new NearbyFlowerMessage(this.app, (MessageForStructing)localMessageRecord);
          if (this.app.getCurrentAccountUin() != null)
          {
            if (!this.app.getCurrentAccountUin().equals(((NearbyFlowerMessage)localObject4).rUin)) {
              break label3408;
            }
            localObject4 = localaozx.b;
            localObject6 = this.app;
            if (localMessageRecord.istroop != 1) {
              break label8183;
            }
            bool1 = true;
            ((aozy)localObject4).a((QQAppInterface)localObject6, bool1, localMessageRecord.frienduin, l3, localMessageRecord.uniseq);
          }
        }
        if ((localMessageRecord instanceof MessageForStructing))
        {
          localObject4 = anre.a(localMessageRecord.msgData);
          if ((localObject4 instanceof StructMsgForGeneralShare))
          {
            localObject4 = (StructMsgForGeneralShare)localObject4;
            if ((localObject4 == null) || (((StructMsgForGeneralShare)localObject4).mMsgServiceID != 75)) {
              break label3447;
            }
            localObject4 = (TroopManager)this.app.getManager(52);
            l8 = localMessageRecord.uniseq;
            localObject4 = localMessageRecord.frienduin;
            localObject9 = new tnt.a(this.app);
            localObject6 = ((tnt.a)localObject9).a;
            localObject9 = ((tnt.a)localObject9).gH;
            localObject6 = ((acxw)localObject6).a((String)localObject4, 1);
            TroopManager.a(this.app, localMessageRecord.frienduin, StructMsgForGeneralShare.eventId, localMessageRecord.shmsgseq, new tny(this, false, localaozx, l3, l8, (RecentUser)localObject6, (String)localObject4, localMessageRecord, (Map)localObject9));
          }
        }
        if ((localMessageRecord instanceof MessageForTroopFile)) {
          localaozx.b.b(3, l3, localMessageRecord.uniseq);
        }
        if (apsa.B(localMessageRecord)) {
          localaozx.b.b(8, l3, localMessageRecord.uniseq);
        }
        if ((localMessageRecord.msgtype == -5008) && ((localMessageRecord instanceof MessageForArkApp)))
        {
          localObject4 = (MessageForArkApp)localMessageRecord;
          if ((((MessageForArkApp)localObject4).ark_app_message != null) && (((MessageForArkApp)localObject4).ark_app_message.appName.equals("com.tencent.mannounce"))) {
            localaozx.b.b(11, l3, localMessageRecord.uniseq);
          }
        }
        Object localObject10;
        Object localObject11;
        if (localMessageRecord.msgtype == -2039)
        {
          localObject6 = (MessageForApollo)localMessageRecord;
          localObject9 = new ArrayList(2);
          localObject10 = (abhh)this.app.getManager(153);
          localObject4 = null;
          if (QLog.isColorLevel()) {
            localObject4 = new StringBuilder("decode apollo troop msg: ").append(", id: ").append(((MessageForApollo)localObject6).mApolloMessage.id).append(", name: ").append(new String(((MessageForApollo)localObject6).mApolloMessage.name)).append(", doubleAction: ").append(((MessageForApollo)localObject6).isDoubleAction()).append(", time: ").append(localMessageRecord.time).append("\nsender: ").append(localMessageRecord.senderuin);
          }
          if (!localMessageRecord.isSend())
          {
            localObject11 = ((abhh)localObject10).b(((MessageForApollo)localObject6).senderuin);
            if (QLog.isColorLevel()) {
              ((StringBuilder)localObject4).append(", update time: ").append(((ApolloBaseInfo)localObject11).apolloUpdateTime);
            }
            if ((localMessageRecord.time > ((ApolloBaseInfo)localObject11).apolloUpdateTime) && ((((ApolloBaseInfo)localObject11).apolloServerTS < ((MessageForApollo)localObject6).mApolloMessage.sender_ts) || (((ApolloBaseInfo)localObject11).apolloStatus != ((MessageForApollo)localObject6).mApolloMessage.sender_status) || (((ApolloBaseInfo)localObject11).superYellowDiamondFlag != (((MessageForApollo)localObject6).mApolloMessage.flag >> 30 & 0x1)) || ((((MessageForApollo)localObject6).is3dAction()) && (((MessageForApollo)localObject6).mApollo3DMessage != null) && (((ApolloBaseInfo)localObject11).cmshow3dFlag != ((MessageForApollo)localObject6).mApollo3DMessage.senderStatus_3D))))
            {
              ((ApolloBaseInfo)localObject11).apolloStatus = ((MessageForApollo)localObject6).mApolloMessage.sender_status;
              ((ApolloBaseInfo)localObject11).apolloServerTS = ((MessageForApollo)localObject6).mApolloMessage.sender_ts;
              ((ApolloBaseInfo)localObject11).superYellowDiamondFlag = (((MessageForApollo)localObject6).mApolloMessage.flag >> 30 & 0x1);
              if ((((MessageForApollo)localObject6).is3dAction()) && (((MessageForApollo)localObject6).mApollo3DMessage != null)) {
                ((ApolloBaseInfo)localObject11).cmshow3dFlag = ((MessageForApollo)localObject6).mApollo3DMessage.senderStatus_3D;
              }
              ((ApolloBaseInfo)localObject11).apolloUpdateTime = localMessageRecord.time;
              ((ArrayList)localObject9).add(localObject11);
              if (QLog.isColorLevel()) {
                ((StringBuilder)localObject4).append("\n save apollo info: ").append(((ApolloBaseInfo)localObject11).apolloVipFlag).append("|").append(((ApolloBaseInfo)localObject11).apolloStatus).append("|").append(((ApolloBaseInfo)localObject11).apolloLocalTS).append("|").append(((ApolloBaseInfo)localObject11).apolloServerTS).append("|").append(((ApolloBaseInfo)localObject11).cmshow3dFlag).append("|").append(((ApolloBaseInfo)localObject11).apolloUpdateTime);
              }
            }
          }
          if ((((MessageForApollo)localObject6).isDoubleAction()) && (!TextUtils.equals(this.app.getCurrentAccountUin(), ((MessageForApollo)localObject6).mApolloMessage.peer_uin + "")))
          {
            localObject11 = ((abhh)localObject10).b(((MessageForApollo)localObject6).mApolloMessage.peer_uin + "");
            if (QLog.isColorLevel()) {
              ((StringBuilder)localObject4).append("\n peer: ").append(((ApolloBaseInfo)localObject11).uin).append(", update time: ").append(((ApolloBaseInfo)localObject11).apolloUpdateTime);
            }
            if ((localMessageRecord.time > ((ApolloBaseInfo)localObject11).apolloUpdateTime) && ((((ApolloBaseInfo)localObject11).apolloServerTS < ((MessageForApollo)localObject6).mApolloMessage.peer_ts) || (((ApolloBaseInfo)localObject11).apolloStatus != ((MessageForApollo)localObject6).mApolloMessage.peer_status) || (((ApolloBaseInfo)localObject11).superYellowDiamondFlag != (((MessageForApollo)localObject6).mApolloMessage.flag >> 31 & 0x1)) || ((((MessageForApollo)localObject6).is3dAction()) && (((MessageForApollo)localObject6).mApollo3DMessage != null) && (((ApolloBaseInfo)localObject11).cmshow3dFlag != ((MessageForApollo)localObject6).mApollo3DMessage.peerStatus_3D))))
            {
              ((ApolloBaseInfo)localObject11).apolloStatus = ((MessageForApollo)localObject6).mApolloMessage.peer_status;
              ((ApolloBaseInfo)localObject11).apolloServerTS = ((MessageForApollo)localObject6).mApolloMessage.peer_ts;
              ((ApolloBaseInfo)localObject11).superYellowDiamondFlag = (((MessageForApollo)localObject6).mApolloMessage.flag >> 31 & 0x1);
              if ((((MessageForApollo)localObject6).is3dAction()) && (((MessageForApollo)localObject6).mApollo3DMessage != null)) {
                ((ApolloBaseInfo)localObject11).cmshow3dFlag = ((MessageForApollo)localObject6).mApollo3DMessage.peerStatus_3D;
              }
              ((ApolloBaseInfo)localObject11).apolloUpdateTime = localMessageRecord.time;
              ((ArrayList)localObject9).add(localObject11);
              if (QLog.isColorLevel()) {
                ((StringBuilder)localObject4).append("\n save apollo info ").append(((ApolloBaseInfo)localObject11).apolloVipFlag).append("|").append(((ApolloBaseInfo)localObject11).apolloStatus).append("|").append(((ApolloBaseInfo)localObject11).apolloLocalTS).append("|").append(((ApolloBaseInfo)localObject11).apolloServerTS).append("|").append(((ApolloBaseInfo)localObject11).cmshow3dFlag).append("|").append(((ApolloBaseInfo)localObject11).apolloUpdateTime);
              }
            }
          }
          if (((ArrayList)localObject9).size() > 0) {
            ((abhh)localObject10).hW((List)localObject9);
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, ((StringBuilder)localObject4).toString());
          }
          if (this.app != null)
          {
            i1 = ((abhh)localObject10).cd(this.app.getCurrentUin());
            localObject4 = "";
            if (((MessageForApollo)localObject6).msgType != 0) {
              break label3614;
            }
            localObject4 = String.valueOf(((MessageForApollo)localObject6).mApolloMessage.id);
          }
        }
        for (;;)
        {
          if (localMessageRecord.istroop != 1) {
            break label8189;
          }
          i = 1;
          localObject9 = this.app.a(false);
          n = i;
          if (localObject9 != null)
          {
            n = i;
            if (((HotChatManager)localObject9).kj(localMessageRecord.frienduin)) {
              n = 3;
            }
          }
          VipUtils.a(this.app, "cmshow", "Apollo", "rev_action", String.valueOf(localMessageRecord.senderuin), n, ((MessageForApollo)localObject6).msgType, new String[] { localObject4, Integer.toString(i1), Integer.toString(abhh.a(this.app)), String.valueOf(System.currentTimeMillis() / 1000L) });
          if (paramaozx != null)
          {
            localaozx.b.ar(13, localMessageRecord.uniseq);
            localaozx.b.ar(24, localMessageRecord.uniseq);
            if ((l3 > this.app.a().e(String.valueOf(paramanbl.friendUin), paramanbl.uinType)) && (localaozx.aAH()))
            {
              paramaozx.a(localaozx);
              localMessageRecord.mMessageInfo = localaozx;
            }
          }
          if (((paramanbl.uinType != 1) && (paramanbl.uinType != 1026) && (paramanbl.uinType != 3000)) || (localObject2 == null) || (TextUtils.equals(localMessageRecord.selfuin, localMessageRecord.senderuin))) {
            break label3854;
          }
          i = 0;
          localObject4 = ((List)localObject2).iterator();
          if (!((Iterator)localObject4).hasNext()) {
            break label3653;
          }
          if (!((im_msg_body.Elem)((Iterator)localObject4).next()).anon_group_msg.has()) {
            break label8111;
          }
          i = 1;
          break label8165;
          if (((MessageForDeliverGiftTips)localObject4).animationPackageId <= 0) {
            break;
          }
          localaozx.b.b(7, l3, localMessageRecord.uniseq);
          break;
          if (this.app.getCurrentAccountUin().equals(((NearbyFlowerMessage)localObject4).sUin)) {
            break label1843;
          }
          localaozx.b.b(7, l3, localMessageRecord.uniseq);
          break label1843;
          if ((localObject4 != null) && (((StructMsgForGeneralShare)localObject4).mMsgServiceID == 19) && (!((StructMsgForGeneralShare)localObject4).mMsgBrief.startsWith(acfp.m(2131703125))) && (!((StructMsgForGeneralShare)localObject4).mMsgBrief.equals(acfp.m(2131703119))))
          {
            localaozx.b.b(2, l3, localMessageRecord.uniseq);
            break label2000;
          }
          if ((localObject4 != null) && (((StructMsgForGeneralShare)localObject4).mMsgServiceID == 106))
          {
            if ((((StructMsgForGeneralShare)localObject4).atMembers == null) || (!((StructMsgForGeneralShare)localObject4).atMembers.contains(this.app.getCurrentAccountUin()))) {
              break label2000;
            }
            localaozx.b.b(24, l3, localMessageRecord.uniseq);
            break label2000;
          }
          if ((localObject4 == null) || (((StructMsgForGeneralShare)localObject4).mMsgServiceID != 107)) {
            break label2000;
          }
          localaozx.b.b(12, l3, localMessageRecord.uniseq);
          break label2000;
          if (ApolloGameUtil.ib(((MessageForApollo)localObject6).msgType)) {
            localObject4 = "" + ((MessageForApollo)localObject6).gameId;
          }
        }
        localObject4 = ((List)localObject2).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject6 = (im_msg_body.Elem)((Iterator)localObject4).next();
          if ((i == 0) && (((im_msg_body.Elem)localObject6).extra_info.has()))
          {
            localObject6 = (im_msg_body.ExtraInfo)((im_msg_body.Elem)localObject6).extra_info.get();
            if (((im_msg_body.ExtraInfo)localObject6).uint32_msg_tail_id.has())
            {
              n = ((im_msg_body.ExtraInfo)localObject6).uint32_msg_tail_id.get();
              if (n > 0)
              {
                localObject6 = anbi.d(-1002);
                if (localObject6 != null)
                {
                  localObject9 = Integer.toString(n);
                  localObject10 = new SafeMsg.SafeMoreInfo();
                  ((SafeMsg.SafeMoreInfo)localObject10).strMsgTxt.set((String)localObject9);
                  ((MessageRecord)localObject6).init(localMessageRecord.selfuin, localMessageRecord.frienduin, localMessageRecord.senderuin, (String)localObject9, localMessageRecord.time, -1002, localMessageRecord.istroop, localMessageRecord.msgseq);
                  ((MessageRecord)localObject6).isread = true;
                  ((MessageRecord)localObject6).shmsgseq = localMessageRecord.shmsgseq;
                  ((MessageRecord)localObject6).msgData = ((SafeMsg.SafeMoreInfo)localObject10).toByteArray();
                  paramArrayList.add(localObject6);
                }
              }
            }
          }
        }
        if (paramanbl.uinType != 1)
        {
          localObject4 = localObject3;
          if (paramanbl.uinType != 1026) {}
        }
        else
        {
          localObject4 = localObject3;
          if (localObject2 != null)
          {
            localObject6 = ((List)localObject2).iterator();
            do
            {
              localObject4 = localObject3;
              if (!((Iterator)localObject6).hasNext()) {
                break label8104;
              }
              localObject9 = (im_msg_body.Elem)((Iterator)localObject6).next();
              if (((im_msg_body.Elem)localObject9).anon_group_msg.has())
              {
                localObject9 = (im_msg_body.AnonymousGroupMsg)((im_msg_body.Elem)localObject9).anon_group_msg.get();
                i = ((im_msg_body.AnonymousGroupMsg)localObject9).uint32_flags.get();
                localObject4 = ((im_msg_body.AnonymousGroupMsg)localObject9).str_anon_id.get().toByteArray();
                localObject6 = ((im_msg_body.AnonymousGroupMsg)localObject9).str_anon_nick.get().toByteArray();
                n = ((im_msg_body.AnonymousGroupMsg)localObject9).uint32_head_portrait.get();
                i1 = ((im_msg_body.AnonymousGroupMsg)localObject9).uint32_expire_time.get();
                localObject9 = ((im_msg_body.AnonymousGroupMsg)localObject9).str_rank_color.get().toStringUtf8();
                if (localObject4 == null) {
                  break label8195;
                }
                for (;;)
                {
                  try
                  {
                    localObject4 = new String((byte[])localObject4, "ISO-8859-1");
                    if (localObject6 == null)
                    {
                      localObject6 = "";
                      localMessageRecord.saveExtInfoToExtStr("anonymous", jof.a(i, (String)localObject4, (String)localObject6, n, i1, (String)localObject9));
                      localMessageRecord.extLong |= 0x3;
                      localObject4 = localObject3;
                      if (!QLog.isColorLevel()) {
                        break label8104;
                      }
                      QLog.d("anonymous_decode", 2, "anonymous_flags = " + i);
                      paramArrayList.add(localMessageRecord);
                      b2 = b1;
                    }
                  }
                  catch (UnsupportedEncodingException localUnsupportedEncodingException)
                  {
                    localUnsupportedEncodingException.printStackTrace();
                    break label8195;
                  }
                  localObject6 = new String((byte[])localObject6);
                }
              }
              localObject5 = localObject3;
              if (((im_msg_body.Elem)localObject9).extra_info.has())
              {
                localObject10 = (im_msg_body.ExtraInfo)((im_msg_body.Elem)localObject9).extra_info.get();
                localObject3 = ((im_msg_body.ExtraInfo)localObject10).bytes_sender_title.get().toStringUtf8();
                i = ((im_msg_body.ExtraInfo)localObject10).uint32_flags.get();
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc.troop.special_msg", 2, "dwFlags:" + i);
                }
                localObject5 = localObject3;
                if (((im_msg_body.ExtraInfo)localObject10).uint32_new_group_flag.has())
                {
                  localObject11 = paramanbl.friendUin + "";
                  localObject5 = localObject3;
                  if (this.app.cs((String)localObject11) != ((im_msg_body.ExtraInfo)localObject10).uint32_new_group_flag.get())
                  {
                    this.app.b((String)localObject11, Integer.valueOf(((im_msg_body.ExtraInfo)localObject10).uint32_new_group_flag.get()));
                    localObject5 = localObject3;
                  }
                }
              }
              localObject3 = localObject5;
            } while (!((im_msg_body.Elem)localObject9).group_business_msg.has());
            localObject9 = apsb.a.a(((im_msg_body.Elem)localObject9).group_business_msg);
            apsb.b(localMessageRecord, (apsb.a)localObject9);
            localObject10 = this.app;
            if (localMessageRecord.frienduin == null) {}
            for (localObject3 = "";; localObject3 = localMessageRecord.frienduin)
            {
              anot.a((QQAppInterface)localObject10, "P_CliOper", "Grp_AIO", "", "five_m", "revice_msg", 0, 0, (String)localObject3, localMessageRecord.msgtype + "", ((apsb.a)localObject9).nickname, "");
              localObject3 = localObject5;
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.i("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "decode group_business_msg:" + localObject9);
              localObject3 = localObject5;
              break;
            }
          }
        }
      }
      else
      {
        bool3 = false;
        bool2 = false;
        i5 = 0;
        i4 = 0;
        j = -100;
        k = -100;
        m = -100;
        n = -100;
        i1 = -100;
        i3 = 0;
        if ((paramanbl.uinType == 1) || (paramanbl.uinType == 1026))
        {
          double d = -100.0D;
          i = -1;
          localObject5 = (msg_comm.GroupInfo)((msg_comm.MsgHead)localObject7).group_info.get();
          if (localObject5 != null)
          {
            l1 = ((msg_comm.GroupInfo)localObject5).group_code.get();
            if (localObject2 != null)
            {
              localObject2 = ((List)localObject2).iterator();
              j = -1;
              n = -100;
              i3 = -100;
              i2 = -100;
              i = 0;
              m = -100;
              d = -100.0D;
              bool1 = false;
              i1 = -100;
              k = -100;
              for (;;)
              {
                if (((Iterator)localObject2).hasNext())
                {
                  localObject6 = (im_msg_body.Elem)((Iterator)localObject2).next();
                  if (((im_msg_body.Elem)localObject6).general_flags.has())
                  {
                    bool4 = bool2;
                    bool3 = bool1;
                    if (!((im_msg_body.Elem)localObject6).general_flags.uint32_group_type.has()) {}
                  }
                  switch (((im_msg_body.Elem)localObject6).general_flags.uint32_group_type.get())
                  {
                  case 1: 
                    label5824:
                    do
                    {
                      bool4 = bool2;
                      bool3 = bool5;
                      if (QLog.isColorLevel())
                      {
                        QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "decodeSinglePbMsg_GroupDis,receive general_flags.uint32_group_type, isPubGroupVisitor = " + bool2 + ", isHotChatMsg = " + bool5);
                        bool3 = bool5;
                        bool4 = bool2;
                      }
                      if (((im_msg_body.Elem)localObject6).general_flags.uint32_glamour_level.has()) {
                        i1 = ((im_msg_body.Elem)localObject6).general_flags.uint32_glamour_level.get();
                      }
                      i9 = j;
                      i8 = n;
                      i7 = i3;
                      i6 = i2;
                      i5 = i;
                      i3 = m;
                      i2 = k;
                      if (((im_msg_body.Elem)localObject6).general_flags.bytes_pb_reserve.has())
                      {
                        paramaozx = new generalflags.ResvAttr();
                        paramaozx.mergeFrom(((im_msg_body.Elem)localObject6).general_flags.bytes_pb_reserve.get().toByteArray());
                        if (paramaozx.uint32_rich_card_name_ver.has()) {
                          paramaozx.uint32_rich_card_name_ver.get();
                        }
                        if (!paramaozx.uint32_nearby_charm_level.has()) {
                          break label8333;
                        }
                        i2 = paramaozx.uint32_nearby_charm_level.get();
                        if (!paramaozx.uint32_global_group_level.has()) {
                          break label8340;
                        }
                        i3 = paramaozx.uint32_global_group_level.get();
                        if (!paramaozx.uint32_vip_type.has()) {
                          break label8347;
                        }
                        i6 = paramaozx.uint32_vip_type.get();
                        if (!paramaozx.uint32_vip_level.has()) {
                          break label8353;
                        }
                        i5 = paramaozx.uint32_vip_level.get();
                        i7 = VipUtils.kl(i5);
                        if (paramaozx.uint32_user_bigclub_flag.has()) {
                          n = paramaozx.uint32_user_bigclub_flag.get();
                        }
                        if (paramaozx.uint32_user_bigclub_level.has()) {
                          k = paramaozx.uint32_user_bigclub_level.get();
                        }
                        if (paramaozx.uint32_nameplate.has()) {
                          m = paramaozx.uint32_nameplate.get();
                        }
                        i8 = n;
                        i5 = i;
                        if (n != 0)
                        {
                          i8 = n;
                          i5 = i;
                          if (paramaozx.uint32_nameplate_vip_type.has())
                          {
                            i8 = n;
                            i5 = i;
                            if (paramaozx.uint32_gray_name_plate.has())
                            {
                              i5 = paramaozx.uint32_nameplate_vip_type.get();
                              localObject7 = VipUtils.b.a.a(i5);
                              if ((!VipUtils.b.my(i5)) || (((VipUtils.b.a)localObject7).aFh())) {
                                break label8359;
                              }
                              i5 = 1;
                              if ((paramaozx.uint32_gray_name_plate.get() != 0) || (i5 != 0)) {
                                break label8209;
                              }
                              i8 = n;
                              i5 = i;
                              if (n == 3)
                              {
                                i8 = n;
                                i5 = i;
                                if (!((VipUtils.b.a)localObject7).aFi())
                                {
                                  i8 = 1;
                                  i5 = i;
                                }
                              }
                            }
                          }
                        }
                        if (QLog.isColorLevel()) {
                          QLog.d("kaiyan", 2, "isHideBigClub=" + i5);
                        }
                        i9 = j;
                        if (paramaozx.uint32_title_id.has())
                        {
                          i = paramaozx.uint32_title_id.get();
                          if (i > 0) {
                            j = i;
                          }
                          i9 = j;
                          if (QLog.isColorLevel())
                          {
                            QLog.d("TroopRankConfig", 2, "decodeSinglePbMsg_GroupDis, titleId=" + i + ", troopUin=" + l1 + ", sender=" + l6 + ", msgTime=" + l2 + ", isSaveDb=" + paramBoolean);
                            i9 = j;
                          }
                        }
                        if ((paramanbl.uinType == 1) && (paramaozx.uint32_group_member_flag_ex2.has()))
                        {
                          i = paramaozx.uint32_group_member_flag_ex2.get();
                          acqi.b(this.app, l1, i);
                        }
                        if ((paramanbl.uinType == 1) && (paramaozx.uint32_group_ringtone_id.has()) && (paramaozx.uint32_group_ringtone_id.get() > 0))
                        {
                          i = paramaozx.uint32_group_ringtone_id.get();
                          acqi.c(this.app, l1, i);
                        }
                        localObject7 = (TroopManager)this.app.getManager(52);
                        if (localObject7 != null) {
                          ((TroopManager)localObject7).d(String.valueOf(l1), String.valueOf(l6), i2, i3);
                        }
                        if ((paramanbl.uinType == 1) && (paramaozx.uint32_custom_featureid.has()) && (localObject7 != null) && (paramaozx.uint32_custom_featureid.get() == 19713))
                        {
                          if (QLog.isColorLevel()) {
                            QLog.d(".troop.qidian_private_troop", 2, "decodeSinglePbMsg_GroupDis, hasPrivateTroopFlag, troopUin=" + l1);
                          }
                          localObject8 = ((TroopManager)localObject7).b(String.valueOf(l1));
                          if ((localObject8 != null) && (!((TroopInfo)localObject8).isQidianPrivateTroop()))
                          {
                            ((TroopInfo)localObject8).setQidianPrivateTroopFlag();
                            ((TroopManager)localObject7).i((TroopInfo)localObject8);
                            if (QLog.isColorLevel()) {
                              QLog.d(".troop.qidian_private_troop", 2, "set privateTroop flag, troopUin=" + l1);
                            }
                          }
                        }
                        if (!paramaozx.bytes_hudong_mark.has()) {
                          break label8365;
                        }
                        paramaozx = paramaozx.bytes_hudong_mark.get().toByteArray();
                        paramaozx = apmc.A(paramaozx);
                        ((apmb)this.app.getManager(346)).ba(String.valueOf(l1), String.valueOf(l6), paramaozx);
                        i2 = k;
                        i3 = m;
                      }
                      i18 = i9;
                      i17 = i8;
                      i16 = i7;
                      i15 = i6;
                      i14 = i5;
                      i13 = i3;
                      i12 = i2;
                      i10 = i1;
                      i11 = i4;
                      bool6 = bool4;
                      bool5 = bool3;
                      if (paramanbl.uinType != 1) {
                        break label8022;
                      }
                      i18 = i9;
                      i17 = i8;
                      i16 = i7;
                      i15 = i6;
                      i14 = i5;
                      i13 = i3;
                      i12 = i2;
                      i10 = i1;
                      i11 = i4;
                      bool6 = bool4;
                      bool5 = bool3;
                      if (!((im_msg_body.Elem)localObject6).general_flags.uint64_group_rank_seq.has()) {
                        break label8022;
                      }
                      paramaozx = String.valueOf(l1);
                      if ((this.app.a == null) || (!this.app.a.abT())) {
                        break label8371;
                      }
                      bool1 = true;
                      if (!bool1) {
                        break;
                      }
                      localObject7 = ((TroopManager)this.app.getManager(52)).b(paramaozx);
                      if (localObject7 == null) {
                        break label8215;
                      }
                      l8 = ((im_msg_body.Elem)localObject6).general_flags.uint64_group_rank_seq.get();
                      if (QLog.isColorLevel()) {
                        QLog.d("Q.getTroopMemberLevelInfo", 2, "onNewMsg: troopUin=" + paramaozx + ", serverRankSeq=" + l8 + ", localRankSeq=" + ((TroopInfo)localObject7).dwGroupLevelSeq + ", isSyncMsgFinish=" + bool1);
                      }
                      if (l8 <= ((TroopInfo)localObject7).dwGroupLevelSeq) {
                        break label8215;
                      }
                      ((acms)this.app.getBusinessHandler(20)).bK(paramaozx, false);
                      break label8215;
                      bool5 = bool1;
                    } while (!((im_msg_body.Elem)localObject6).general_flags.uint32_to_uin_flag.has());
                    if (((im_msg_body.Elem)localObject6).general_flags.uint32_to_uin_flag.get() == 2)
                    {
                      bool2 = true;
                      break label8314;
                      if (QLog.isColorLevel())
                      {
                        QLog.d("Q.getTroopMemberLevelInfo", 2, "onNewMsg: troopUin=" + paramaozx + ", isSyncMsgFinish=" + bool1);
                        break label8215;
                        if ((((im_msg_body.Elem)localObject6).extra_info.has()) && (((im_msg_body.Elem)localObject6).extra_info.uint32_flags.has()))
                        {
                          i18 = j;
                          i17 = n;
                          i16 = i3;
                          i15 = i2;
                          i14 = i;
                          i13 = m;
                          i12 = k;
                          i10 = i1;
                          i11 = i4;
                          bool6 = bool2;
                          bool5 = bool1;
                          if (bool1)
                          {
                            i5 = ((im_msg_body.Elem)localObject6).extra_info.uint32_flags.get();
                            if (QLog.isColorLevel()) {
                              QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "elem.extra_info.uint32_flags:" + i5 + "|groupCode:" + l1 + "fromUin:" + l6);
                            }
                            if ((i5 & 0x10) != 16) {
                              break label8377;
                            }
                            paramaozx = ((HotChatManager)this.app.getManager(60)).a(l1 + "");
                            localObject6 = l6 + "";
                            if ((paramaozx == null) || (paramaozx.adminUins.contains(localObject6))) {
                              break label8377;
                            }
                            paramaozx.adminUins.add(localObject6);
                            break label8377;
                          }
                        }
                        else if (((im_msg_body.Elem)localObject6).pub_group.has())
                        {
                          i11 = 1;
                          i18 = j;
                          i17 = n;
                          i16 = i3;
                          i15 = i2;
                          i14 = i;
                          i13 = m;
                          i12 = k;
                          i10 = i1;
                          bool6 = bool2;
                          bool5 = bool1;
                          if (QLog.isColorLevel())
                          {
                            if (!((im_msg_body.PubGroup)((im_msg_body.Elem)localObject6).pub_group.get()).bytes_nickname.has()) {
                              break label8069;
                            }
                            paramaozx = ((im_msg_body.PubGroup)((im_msg_body.Elem)localObject6).pub_group.get()).bytes_nickname.get().toStringUtf8();
                            label6404:
                            QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "decodeSinglePbMsg_GroupDis,receive  pub_group,bytes_nickname = " + paramaozx);
                            i4 = i;
                            i5 = m;
                            i6 = k;
                            i7 = i1;
                            i8 = 1;
                            bool3 = bool1;
                            i = j;
                            j = n;
                            k = i3;
                            m = i2;
                            n = i4;
                            i1 = i5;
                            i2 = i6;
                            i3 = i7;
                            i4 = i8;
                            bool1 = bool2;
                            bool2 = bool3;
                            break label8255;
                          }
                        }
                        else
                        {
                          i18 = j;
                          i17 = n;
                          i16 = i3;
                          i15 = i2;
                          i14 = i;
                          i13 = m;
                          i12 = k;
                          i10 = i1;
                          i11 = i4;
                          bool6 = bool2;
                          bool5 = bool1;
                          if (((im_msg_body.Elem)localObject6).elem_flags2.has())
                          {
                            i18 = j;
                            i17 = n;
                            i16 = i3;
                            i15 = i2;
                            i14 = i;
                            i13 = m;
                            i12 = k;
                            i10 = i1;
                            i11 = i4;
                            bool6 = bool2;
                            bool5 = bool1;
                            if (((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject6).elem_flags2.get()).uint32_longtitude.has())
                            {
                              i18 = j;
                              i17 = n;
                              i16 = i3;
                              i15 = i2;
                              i14 = i;
                              i13 = m;
                              i12 = k;
                              i10 = i1;
                              i11 = i4;
                              bool6 = bool2;
                              bool5 = bool1;
                              if (((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject6).elem_flags2.get()).uint32_latitude.has())
                              {
                                if (l7 == l6) {
                                  continue;
                                }
                                d = -1001.0D;
                                i5 = i;
                                i6 = m;
                                i7 = k;
                                i8 = i1;
                                bool3 = bool1;
                                i = j;
                                j = n;
                                k = i3;
                                m = i2;
                                n = i5;
                                i1 = i6;
                                i2 = i7;
                                i3 = i8;
                                bool1 = bool2;
                                bool2 = bool3;
                                break label8255;
                                label6760:
                                paramaozx = String.valueOf(l1);
                                paramanbl = (TroopManager)this.app.getManager(52);
                                localObject2 = paramanbl.b(paramaozx);
                                if (QLog.isColorLevel()) {
                                  QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "decodeSinglePbMsg_GroupDis: troopUin=" + l1 + ", memberUin=" + l6 + "，isHotChatMsg = " + bool1 + ",ti = " + localObject2);
                                }
                                if ((!bool1) && (localObject2 == null))
                                {
                                  if (QLog.isColorLevel()) {
                                    QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "decodeSinglePbMsg_GroupDis: troopUin=" + l1 + ", memberUin=" + l6 + " troopinfo is null, getGroupInfoReq ");
                                  }
                                  localObject2 = new TroopInfo();
                                  ((TroopInfo)localObject2).troopuin = paramaozx;
                                  paramanbl.i((TroopInfo)localObject2);
                                  ((acms)this.app.getBusinessHandler(20)).Fa(paramaozx);
                                }
                                localObject2 = String.valueOf(l6);
                                i5 = ((msg_comm.GroupInfo)localObject5).group_level.get();
                                localObject6 = aqpm.f(((msg_comm.GroupInfo)localObject5).group_card.get());
                                i6 = ((msg_comm.GroupInfo)localObject5).group_card_type.get();
                                if (bool1) {
                                  ((HotChatManager)this.app.getManager(60)).hw(l1);
                                }
                                if (!bool2) {
                                  break label8491;
                                }
                                paramanbl = paramArrayList.iterator();
                                while (paramanbl.hasNext()) {
                                  ((MessageRecord)paramanbl.next()).isOpenTroopMessage = true;
                                }
                                paramanbl = (TroopManager)this.app.getManager(52);
                                if ((paramanbl == null) || (paramanbl.kz(paramaozx))) {
                                  break label8491;
                                }
                                paramanbl = (acms)this.app.getBusinessHandler(20);
                                if (paramanbl == null) {
                                  break label8491;
                                }
                                paramanbl.bN(paramaozx, false);
                                break label8491;
                                label7103:
                                if (i2 != -100)
                                {
                                  paramanbl = (TroopManager)this.app.getManager(52);
                                  if (paramanbl != null) {
                                    paramanbl.e(paramaozx, (String)localObject2, i2);
                                  }
                                }
                                if (paramBoolean) {
                                  paramanbl = (TroopManager)this.app.getManager(52);
                                }
                                switch (i6)
                                {
                                case 1: 
                                  paramanbl.a(paramaozx, (String)localObject2, (String)localObject6, i, null, null, 0, 1, 100, l3, b2, 0L, d, null, -100, j, k, m, n, i1, i3);
                                case 2: 
                                  for (;;)
                                  {
                                    label7180:
                                    paramanbl.aw(paramaozx, (String)localObject2, (String)localObject3);
                                    paramanbl = null;
                                    label7233:
                                    if ((localObject2 == null) || (((String)localObject2).equals(this.app.getCurrentAccountUin()))) {
                                      break label8532;
                                    }
                                    localObject2 = (apsa)this.app.getManager(132);
                                    if (((apsa)localObject2).qP(paramaozx)) {
                                      break label8532;
                                    }
                                    if (!((apsa)localObject2).qQ(paramaozx)) {
                                      break label7679;
                                    }
                                    i2 = paramArrayList.size();
                                    i = 0;
                                    i3 = i2 - 1;
                                    if (i3 < 0) {
                                      break label7679;
                                    }
                                    localObject3 = (MessageRecord)paramArrayList.get(i3);
                                    i2 = i;
                                    if (!apsa.B((MessageRecord)localObject3)) {
                                      break label8525;
                                    }
                                    if ((!TextUtils.isEmpty(((MessageRecord)localObject3).msg)) || (((MessageRecord)localObject3).msgData != null)) {
                                      break;
                                    }
                                    break label8507;
                                    paramanbl.a(paramaozx, (String)localObject2, (String)localObject6, i, null, null, 0, 1, 100, l3, b2, 0L, d, null, -100, j, k, m, n, i1, i3);
                                    continue;
                                    paramanbl.a(paramaozx, (String)localObject2, "", i, (String)localObject6, null, 0, 1, 100, l3, b2, 0L, d, null, -100, j, k, m, n, i1, i3);
                                  }
                                  paramanbl = new TroopMemberInfo();
                                  paramanbl.troopuin = paramaozx;
                                  paramanbl.memberuin = ((String)localObject2);
                                  switch (i6)
                                  {
                                  case 2: 
                                    label7484:
                                    localObject3 = aqpm.pQ((String)localObject6);
                                    paramanbl.troopColorNick = ((String)localObject6);
                                    paramanbl.troopnick = ((String)localObject3);
                                    for (;;)
                                    {
                                      paramanbl.level = i;
                                      paramanbl.realLevel = i5;
                                      paramanbl.sex = 1;
                                      paramanbl.age = 0;
                                      paramanbl.distance = 100;
                                      paramanbl.msgseq = l3;
                                      if (b2 != 1) {
                                        break label8519;
                                      }
                                      paramBoolean = true;
                                      label7546:
                                      paramanbl.isTroopFollowed = paramBoolean;
                                      paramanbl.distanceToSelf = d;
                                      paramanbl.distanceToSelfUpdateTimeStamp = System.currentTimeMillis();
                                      break;
                                      paramanbl.troopnick = "";
                                      paramanbl.friendnick = ((String)localObject6);
                                    }
                                    i2 = i;
                                    if (i == 0)
                                    {
                                      ((apsa)localObject2).bi(paramaozx, ((MessageRecord)localObject3).uniseq);
                                      i2 = 1;
                                    }
                                    if (QLog.isColorLevel()) {
                                      QLog.d("TroopBindPublicAccountMgr.redDot", 2, "decodePBAccountMSg:" + paramaozx + "," + ((MessageRecord)localObject3).uniseq + "," + ((MessageRecord)localObject3).shmsgseq);
                                    }
                                    ((apsa)localObject2).TN(paramaozx);
                                    break label8525;
                                    label7679:
                                    if (this.app.cs(paramaozx) != 3) {
                                      break label8532;
                                    }
                                    if (QLog.isColorLevel()) {
                                      QLog.d(".troop.closeRcvMsgTmp", 2, "Shield troop recv msg:" + paramaozx);
                                    }
                                    ((acms)this.app.getBusinessHandler(20)).m(paramaozx, this.app.getCurrentAccountUin(), 0, 0);
                                    break label8532;
                                  }
                                  break;
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                    break;
                  }
                }
              }
            }
          }
        }
      }
    }
    label7755:
    label8148:
    label8532:
    for (;;)
    {
      i = anbh.a(paramMsg);
      i2 = anbh.e(paramMsg);
      i3 = anbh.c(paramMsg);
      i4 = anbh.b(paramMsg);
      i5 = anbh.d(paramMsg);
      paramMsg = paramArrayList.iterator();
      while (paramMsg.hasNext())
      {
        paramArrayList = (MessageRecord)paramMsg.next();
        paramArrayList.vipBubbleDiyTextId = i;
        Object localObject1;
        paramArrayList.vipBubbleID = acle.g((int)localObject1, i);
        paramArrayList.vipSubBubbleId = i2;
        this.app.a().ll(paramArrayList.time);
        if (i2 != 0) {
          paramArrayList.saveExtInfoToExtStr("bubble_sub_id", String.valueOf(i2));
        }
        if (i3 > 0) {
          paramArrayList.saveExtInfoToExtStr("vip_pendant_diy_id", String.valueOf(i3));
        }
        if (i5 >= 0) {
          paramArrayList.saveExtInfoToExtStr("vip_face_id", String.valueOf(i5));
        }
        if (i4 >= 0) {
          paramArrayList.saveExtInfoToExtStr("vip_font_effect_id", String.valueOf(i4));
        }
        if (j > 0) {
          paramArrayList.saveExtInfoToExtStr("vip_type", String.valueOf(j));
        }
        if (k > 0) {
          paramArrayList.saveExtInfoToExtStr("vip_level", String.valueOf(k));
        }
        if (m > 0) {
          paramArrayList.saveExtInfoToExtStr("bigClub_type", String.valueOf(m));
        }
        if (n > 0) {
          paramArrayList.saveExtInfoToExtStr("bigClub_level", String.valueOf(n));
        }
        if (i1 > 0) {
          paramArrayList.saveExtInfoToExtStr("vip_card_id", String.valueOf(i1));
        }
      }
      MsgAutoMonitorUtil.getInstance().addDecodeGrpDisMsgTime(System.currentTimeMillis() - l5);
      return paramanbl;
      label8022:
      label8165:
      label8168:
      label8177:
      label8183:
      label8189:
      do
      {
        paramanbl = null;
        break label7233;
        i = i18;
        j = i17;
        k = i16;
        m = i15;
        n = i14;
        i1 = i13;
        i2 = i12;
        i3 = i10;
        i4 = i11;
        bool1 = bool6;
        bool2 = bool5;
        break label8255;
        paramaozx = null;
        break label6404;
        i2 = -100;
        bool1 = false;
        i4 = i5;
        bool2 = bool3;
        break label6760;
        l1 = 0L;
        break label4570;
        paramanbl = null;
        break label7755;
        localObject3 = localObject5;
        break label4114;
        break label8165;
        l1 = 0L;
        break label1145;
        localObject2 = null;
        l1 = 0L;
        break label284;
        do
        {
          l4 = l1;
          break label233;
          j = 0;
          k = 0;
          m = 0;
          break;
          return null;
        } while (l1 != -1L);
        long l4 = 0L;
        break label233;
        break label3344;
        i += 1;
        break label1421;
        bool1 = false;
        break label1692;
        bool1 = false;
        break label1821;
        i = 2;
        break label3085;
        localObject5 = "";
        break label4032;
        bool5 = bool1;
        break label4712;
        i = 1;
        break label5150;
        i = i9;
        j = i8;
        k = i7;
        m = i6;
        n = i5;
        i5 = i3;
        bool1 = bool4;
        bool2 = bool3;
        i3 = i1;
        i1 = i5;
        for (;;)
        {
          bool3 = bool2;
          i5 = i3;
          i6 = i2;
          i7 = n;
          n = j;
          j = i;
          i3 = k;
          i2 = m;
          i = i7;
          m = i1;
          k = i6;
          i1 = i5;
          bool2 = bool1;
          bool1 = bool3;
          break;
          for (;;)
          {
            bool5 = bool1;
            break;
            bool2 = false;
          }
          bool5 = true;
          break label4712;
          i2 = -100;
          break label4911;
          i3 = -100;
          break label4932;
          i6 = 0;
          break label4953;
          i5 = 0;
          break label4974;
          i5 = 0;
          break label5131;
          paramaozx = null;
          break label5638;
          bool1 = false;
          break label5824;
          i5 = i;
          i6 = m;
          i7 = k;
          i8 = i1;
          bool3 = bool1;
          i = j;
          j = n;
          k = i3;
          m = i2;
          n = i5;
          i1 = i6;
          i2 = i7;
          i3 = i8;
          bool1 = bool2;
          bool2 = bool3;
        }
        i6 = i3;
        i3 = i;
        i5 = m;
        i7 = k;
        k = i2;
        i = j;
        i2 = i1;
        j = k;
        k = i6;
        m = n;
        n = i7;
        i1 = i5;
        break label6760;
        if (i4 == 0) {
          break label7103;
        }
      } while (!bool1);
      label8150:
      label8314:
      break label7103;
      break label7180;
      for (;;)
      {
        i3 -= 1;
        break;
        break label7484;
        paramBoolean = false;
        break label7546;
        i = i2;
      }
    }
  }
  
  protected String a(msg_comm.Msg paramMsg)
  {
    long l = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
    return 64 + "key_seq_" + l;
  }
  
  public List<MessageRecord> a(msg_comm.Msg paramMsg, anbl paramanbl)
  {
    return null;
  }
  
  public void f(int paramInt, Object... paramVarArgs) {}
  
  protected void y(MessageRecord paramMessageRecord)
  {
    if (this.app.a().aR(paramMessageRecord))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "handle push . notifySendMessageSuccessful" + paramMessageRecord.toString());
      }
      this.app.a().e(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
      b(6003, true, new Object[] { paramMessageRecord.frienduin, String.valueOf(paramMessageRecord.uniseq) });
      this.a.hB(paramMessageRecord.msgseq);
      if (top.fI(paramMessageRecord.msgtype))
      {
        achq.a locala = new achq.a();
        locala.errCode = 1000;
        locala.retryCount = 0;
        this.app.a().notifyUI(5006, true, new Object[] { Long.valueOf(paramMessageRecord.uniseq), locala });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tnx
 * JD-Core Version:    0.7.0.1
 */