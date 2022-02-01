import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.KplRoleInfo;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForFunnyFace;
import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.data.MessageForLimitChatConfirm;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForPokeEmo;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopStory;
import com.tencent.mobileqq.data.MessageForWantGiftMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import msf.msgcomm.msg_comm.UinPairMsg;
import msf.msgsvc.msg_ctrl.MsgCtrl;
import msf.msgsvc.msg_svc.C2C;
import msf.msgsvc.msg_svc.MultiMsgAssist;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import msf.msgsvc.msg_svc.RoutingHead;
import org.json.JSONObject;
import tencent.im.babyq.babyq_cookie.BabyQCookie;
import tencent.im.cs.ptt_waveform.ptt_waveform.PttWaveform;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype13;
import tencent.im.msg.im_msg_body.AnonymousGroupMsg;
import tencent.im.msg.im_msg_body.BlessingMessage;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ExtraInfo;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.NearByMessageType;
import tencent.im.msg.im_msg_body.PubGroup;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.Text;
import tencent.im.oidb.oidb_0xdea.PassThrough;
import tencent.im.qzone.album.UploadParam;

public class achp
{
  public static boolean F(ArrayList<MessageRecord> paramArrayList)
  {
    if (paramArrayList == null) {
      return false;
    }
    paramArrayList = paramArrayList.iterator();
    MessageRecord localMessageRecord;
    do
    {
      if (!paramArrayList.hasNext()) {
        break;
      }
      localMessageRecord = (MessageRecord)paramArrayList.next();
    } while ((localMessageRecord.isSend()) || (localMessageRecord.isread));
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean G(ArrayList<MessageRecord> paramArrayList)
  {
    if (paramArrayList == null) {
      return false;
    }
    paramArrayList = paramArrayList.iterator();
    MessageRecord localMessageRecord;
    do
    {
      if (!paramArrayList.hasNext()) {
        break;
      }
      localMessageRecord = (MessageRecord)paramArrayList.next();
    } while ((localMessageRecord.msgtype == -2006) && ((localMessageRecord instanceof MessageForFoldMsg)));
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  public static boolean Z(MessageRecord paramMessageRecord)
  {
    AppInterface localAppInterface = axol.getAppInterface();
    if ((localAppInterface instanceof QQAppInterface)) {
      return (paramMessageRecord.extraflag != 32768) && (!((QQAppInterface)localAppInterface).a().aR(paramMessageRecord));
    }
    return false;
  }
  
  public static long a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, long paramLong3)
  {
    long l = paramQQAppInterface.getLongAccountUin();
    if (paramLong1 == l) {
      return paramLong2;
    }
    if (paramLong2 == l) {
      return paramLong1;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.msg.MessageHandlerUtils", 2, "<---decodeC2CMessagePackage: neither fromUin nor toUin is selfUin.use peerUin instead.");
    }
    return paramLong3;
  }
  
  public static long a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, long paramLong3, msg_comm.UinPairMsg paramUinPairMsg)
  {
    return ahti.a(a(paramQQAppInterface, paramLong1, paramLong2, paramLong3), paramUinPairMsg, paramQQAppInterface);
  }
  
  public static msg_svc.PbSendMsgReq a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    Object localObject1;
    int i;
    if (paramMessageRecord.msgtype == -1000)
    {
      localObject1 = anbh.a((MessageForText)paramMessageRecord);
      i = ((MessageForText)paramMessageRecord).msgVia;
    }
    while (localObject1 == null)
    {
      return null;
      if (paramMessageRecord.msgtype == -1049)
      {
        localObject1 = anbh.a((MessageForReplyText)paramMessageRecord);
        i = ((MessageForReplyText)paramMessageRecord).msgVia;
      }
      else if (paramMessageRecord.msgtype == -2056)
      {
        localObject1 = anbh.a((MessageForText)paramMessageRecord);
        i = 0;
      }
      else if (paramMessageRecord.msgtype == -2000)
      {
        localObject1 = anbh.a((MessageForPic)paramMessageRecord);
        i = ((MessageForPic)paramMessageRecord).msgVia;
      }
      else if (paramMessageRecord.msgtype == -2002)
      {
        localObject1 = anbh.a((MessageForPtt)paramMessageRecord);
        i = ((MessageForPtt)paramMessageRecord).msgVia;
      }
      else if (paramMessageRecord.msgtype == -2007)
      {
        localObject1 = anbh.a((MessageForMarketFace)paramMessageRecord);
        i = ((MessageForMarketFace)paramMessageRecord).msgVia;
      }
      else if (paramMessageRecord.msgtype == -2058)
      {
        if ((paramMessageRecord instanceof MessageForMarketFace))
        {
          localObject1 = anbh.a((MessageForMarketFace)paramMessageRecord);
          i = ((MessageForMarketFace)paramMessageRecord).msgVia;
        }
        else if ((paramMessageRecord instanceof MessageForText))
        {
          localObject1 = anbh.a((MessageForText)paramMessageRecord);
          i = ((MessageForText)paramMessageRecord).msgVia;
        }
        else
        {
          if (!(paramMessageRecord instanceof MessageForPic)) {
            break label2406;
          }
          localObject1 = anbh.a((MessageForPic)paramMessageRecord);
          i = ((MessageForPic)paramMessageRecord).msgVia;
        }
      }
      else if (paramMessageRecord.msgtype == -2039)
      {
        localObject1 = anbh.a((MessageForApollo)paramMessageRecord);
        i = 0;
      }
      else if ((paramMessageRecord.msgtype == -2011) || (paramMessageRecord.msgtype == -2051) || (paramMessageRecord.msgtype == -7002))
      {
        localObject1 = anbh.a((MessageForStructing)paramMessageRecord);
        i = 0;
      }
      else if (paramMessageRecord.msgtype == -2010)
      {
        localObject1 = anbh.a((MessageForFunnyFace)paramMessageRecord);
        i = 0;
      }
      else if (paramMessageRecord.msgtype == -2020)
      {
        localObject1 = anbh.a((MessageForShakeWindow)paramMessageRecord);
        i = 0;
      }
      else if (paramMessageRecord.msgtype == -2022)
      {
        localObject1 = anbh.a((MessageForShortVideo)paramMessageRecord);
        i = 0;
      }
      else if (paramMessageRecord.msgtype == -2071)
      {
        localObject1 = anbh.a((MessageForLightVideo)paramMessageRecord);
        i = 0;
      }
      else if (paramMessageRecord.msgtype == -5008)
      {
        localObject1 = anbh.a((ChatMessage)paramMessageRecord, false);
        i = 0;
      }
      else if (paramMessageRecord.msgtype == -5013)
      {
        localObject1 = anbh.c((ChatMessage)paramMessageRecord);
        i = 0;
      }
      else if (paramMessageRecord.msgtype == -5014)
      {
        localObject1 = anbh.d((ChatMessage)paramMessageRecord);
        i = 0;
      }
      else if (paramMessageRecord.msgtype == -5012)
      {
        localObject1 = anbh.e((MessageForPoke)paramMessageRecord);
        i = 0;
      }
      else if (paramMessageRecord.msgtype == -5018)
      {
        localObject1 = anbh.f((MessageForPokeEmo)paramMessageRecord);
        i = 0;
      }
      else if (paramMessageRecord.msgtype == -1051)
      {
        localObject1 = anbh.a((MessageForLongTextMsg)paramMessageRecord, true);
        i = 0;
      }
      else if (paramMessageRecord.msgtype == -1052)
      {
        localObject1 = new im_msg_body.RichText();
        i = 0;
      }
      else if (paramMessageRecord.msgtype == -1035)
      {
        localObject1 = anbh.a((MessageForMixedMsg)paramMessageRecord);
        i = 0;
      }
      else if (paramMessageRecord.msgtype == -2057)
      {
        localObject1 = anbh.a((MessageForTroopStory)paramMessageRecord);
        i = 0;
      }
      else if (paramMessageRecord.msgtype == -7001)
      {
        localObject1 = anbh.g((MessageForScribble)paramMessageRecord);
        i = 0;
      }
      else if (paramMessageRecord.msgtype == -5016)
      {
        localObject1 = anbh.c((MessageForArkBabyqReply)paramMessageRecord, false);
        i = 0;
      }
      else if (paramMessageRecord.msgtype == -5017)
      {
        localObject1 = anbh.b((MessageForArkApp)paramMessageRecord, false);
        i = 0;
      }
      else if (paramMessageRecord.msgtype == -7005)
      {
        localObject1 = anbh.b((MessageForLimitChatConfirm)paramMessageRecord);
        i = 0;
      }
      else
      {
        localObject1 = a(paramQQAppInterface, paramMessageRecord);
        i = 0;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgVia", 2, "send message, entrance: " + i);
    }
    Object localObject2;
    if (paramMessageRecord.msgtype == -1000)
    {
      localObject3 = (MessageForText)paramMessageRecord;
      if (((MessageForText)localObject3).mPasswdRedBagFlag != 0)
      {
        localObject2 = new im_msg_body.ExtraInfo();
        ((im_msg_body.ExtraInfo)localObject2).uint64_uin.set(((MessageForText)localObject3).mPasswdRedBagSender);
        ((im_msg_body.ExtraInfo)localObject2).uint32_msg_state_flag.set(((MessageForText)localObject3).mPasswdRedBagFlag);
        localObject3 = new im_msg_body.Elem();
        ((im_msg_body.Elem)localObject3).extra_info.set((MessageMicro)localObject2);
        ((im_msg_body.RichText)localObject1).elems.add((MessageMicro)localObject3);
      }
    }
    Object localObject4;
    if (jof.a(paramMessageRecord))
    {
      localObject2 = new im_msg_body.Elem();
      localObject3 = new im_msg_body.AnonymousGroupMsg();
      localObject4 = jof.a(paramMessageRecord);
      ((im_msg_body.AnonymousGroupMsg)localObject3).uint32_flags.set(((jof.a)localObject4).flags);
      if (!TextUtils.isEmpty(((jof.a)localObject4).TF)) {
        ((im_msg_body.AnonymousGroupMsg)localObject3).str_anon_id.set(ByteStringMicro.copyFrom(((jof.a)localObject4).TF.getBytes()));
      }
      if (!TextUtils.isEmpty(((jof.a)localObject4).TG)) {
        ((im_msg_body.AnonymousGroupMsg)localObject3).str_anon_nick.set(ByteStringMicro.copyFrom(((jof.a)localObject4).TG.getBytes()));
      }
      ((im_msg_body.AnonymousGroupMsg)localObject3).uint32_head_portrait.set(((jof.a)localObject4).aCv);
      ((im_msg_body.AnonymousGroupMsg)localObject3).uint32_expire_time.set(((jof.a)localObject4).expire_time);
      if (!TextUtils.isEmpty(((jof.a)localObject4).TH)) {
        ((im_msg_body.AnonymousGroupMsg)localObject3).str_rank_color.set(ByteStringMicro.copyFrom(((jof.a)localObject4).TH.getBytes()));
      }
      ((im_msg_body.AnonymousGroupMsg)localObject3).uint32_bubble_id.set((int)paramMessageRecord.vipBubbleID);
      ((im_msg_body.Elem)localObject2).anon_group_msg.set((MessageMicro)localObject3);
      ((im_msg_body.RichText)localObject1).elems.add((MessageMicro)localObject2);
    }
    label1073:
    int j;
    int k;
    do
    {
      localObject2 = afck.c(paramMessageRecord);
      if (localObject2 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.nearby_bank", 2, "clearingElem has carry, elem:" + ((im_msg_body.Elem)localObject2).near_by_msg.uint32_type.get());
        }
        ((im_msg_body.RichText)localObject1).elems.add((MessageMicro)localObject2);
      }
      localObject2 = (aczr)paramQQAppInterface.getManager(199);
      if ((localObject2 != null) && (((aczr)localObject2).adh()) && (((aczr)localObject2).fl() == 1L) && ((paramMessageRecord.istroop == 1) || (paramMessageRecord.istroop == 3000)))
      {
        localObject2 = ((aczr)localObject2).a();
        if (localObject2 != null)
        {
          j = ((Setting)localObject2).systemHeadID;
          k = ((Setting)localObject2).bHeadType;
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandlerUtils", 4, new Object[] { Integer.valueOf(2), " QQ 18 aniversary activity send system head id = " + j + ", head flag = " + k });
          }
          localObject2 = new im_msg_body.Elem();
          localObject3 = new im_msg_body.CommonElem();
          ((im_msg_body.CommonElem)localObject3).uint32_service_type.set(13);
          localObject4 = new hummer_commelem.MsgElemInfo_servtype13();
          ((hummer_commelem.MsgElemInfo_servtype13)localObject4).uint32_sys_head_id.set(j);
          ((hummer_commelem.MsgElemInfo_servtype13)localObject4).uint32_head_flag.set(k);
          ((im_msg_body.CommonElem)localObject3).bytes_pb_elem.set(ByteStringMicro.copyFrom(((hummer_commelem.MsgElemInfo_servtype13)localObject4).toByteArray()));
          ((im_msg_body.Elem)localObject2).common_elem.set((MessageMicro)localObject3);
          ((im_msg_body.RichText)localObject1).elems.add((MessageMicro)localObject2);
        }
      }
      if (((acff)paramQQAppInterface.getManager(51)).bHx)
      {
        if (QLog.isColorLevel()) {
          QLog.d("KplMessage", 2, "get kpl global flag");
        }
        paramMessageRecord.saveExtInfoToExtStr("msg_ext_key", "Y");
        localObject2 = paramMessageRecord.frienduin;
        j = paramMessageRecord.istroop;
        long l = paramMessageRecord.uniseq;
        paramQQAppInterface.b().a((String)localObject2, j, l, "extStr", paramMessageRecord.extStr);
        paramQQAppInterface.b().a((String)localObject2, j, l, "extLong", Integer.valueOf(paramMessageRecord.extLong));
      }
      localObject1 = anbh.a(paramQQAppInterface, paramMessageRecord, (im_msg_body.RichText)localObject1, i);
      if ((localObject1 != null) && ((paramMessageRecord instanceof MessageForStructing)))
      {
        localObject2 = (MessageForStructing)paramMessageRecord;
        if ((((MessageForStructing)localObject2).structingMsg != null) && (oec.b(((MessageForStructing)localObject2).structingMsg)))
        {
          localObject2 = new msg_ctrl.MsgCtrl();
          ((msg_ctrl.MsgCtrl)localObject2).msg_flag.set(4);
          ((msg_svc.PbSendMsgReq)localObject1).msg_ctrl.set((MessageMicro)localObject2);
        }
      }
      localObject2 = a(paramQQAppInterface, paramMessageRecord, (msg_svc.PbSendMsgReq)localObject1);
      if ((localObject2 != null) && (localObject1 != null))
      {
        localObject3 = (im_msg_body.RichText)((im_msg_body.MsgBody)((msg_svc.PbSendMsgReq)localObject1).msg_body.get()).rich_text.get();
        localObject4 = new im_msg_body.Elem();
        ((im_msg_body.Elem)localObject4).general_flags.set((MessageMicro)localObject2);
        ((im_msg_body.RichText)localObject3).elems.get().add(localObject4);
      }
      if ((paramMessageRecord instanceof MessageForPic))
      {
        localObject2 = (MessageForPic)paramMessageRecord;
        if ((((MessageForPic)localObject2).msgCtrl != null) && (localObject1 != null))
        {
          ((msg_svc.PbSendMsgReq)localObject1).msg_ctrl.set(((MessageForPic)localObject2).msgCtrl);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandlerUtils", 2, "set msg_crl for MessageForPic");
          }
        }
      }
      b(paramMessageRecord, (msg_svc.PbSendMsgReq)localObject1, paramQQAppInterface);
      return localObject1;
      if ((paramMessageRecord.istroop != 1) && (paramMessageRecord.istroop != 1026)) {
        break;
      }
      localObject4 = (acff)paramQQAppInterface.getManager(51);
      localObject2 = (HotChatManager)paramQQAppInterface.getManager(60);
      if (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("ext_key_group_chat_confess_info")))
      {
        localObject3 = aegu.b(paramMessageRecord);
        if (localObject3 != null) {
          ((im_msg_body.RichText)localObject1).elems.add((MessageMicro)localObject3);
        }
        if (QLog.isColorLevel()) {
          QLog.i("Q.confess", 2, "bindGroupFirstMsgConfessInfoElem elem:" + localObject3);
        }
      }
      localObject2 = ((HotChatManager)localObject2).a(paramMessageRecord.frienduin);
      localObject3 = (TroopManager)paramQQAppInterface.getManager(52);
    } while ((localObject2 == null) && (!((TroopManager)localObject3).kz(paramMessageRecord.frienduin)));
    Object localObject3 = new im_msg_body.PubGroup();
    for (;;)
    {
      try
      {
        localObject2 = (String)ajrb.c(paramQQAppInterface.getCurrentAccountUin(), "self_nick", String.valueOf(""));
        k = ((Integer)ajrb.c(paramQQAppInterface.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
        j = ((Integer)ajrb.c(paramQQAppInterface.getCurrentAccountUin(), "self_age", Integer.valueOf(-1))).intValue();
        if ((j >= 0) && (k >= 0)) {
          continue;
        }
        localFriends = ((acff)localObject4).e(paramQQAppInterface.getCurrentAccountUin());
        if (localFriends == null) {
          continue;
        }
        j = localFriends.age;
        if (localFriends.gender != 2) {
          continue;
        }
        k = 1;
        localObject2 = localFriends.name;
        if ((localObject2 != null) && (((String)localObject2).length() > 0)) {
          ((im_msg_body.PubGroup)localObject3).bytes_nickname.set(ByteStringMicro.copyFrom(((String)localObject2).getBytes()));
        }
        ((im_msg_body.PubGroup)localObject3).uint32_age.set(j);
        ((im_msg_body.PubGroup)localObject3).uint32_gender.set(k);
      }
      catch (Exception localException)
      {
        Friends localFriends;
        localException.printStackTrace();
        continue;
        ((im_msg_body.RichText)localObject1).elems.add(localException);
      }
      localObject2 = new im_msg_body.Elem();
      ((im_msg_body.Elem)localObject2).pub_group.set((MessageMicro)localObject3);
      ((im_msg_body.RichText)localObject1).elems.add((MessageMicro)localObject2);
      localObject2 = HotChatManager.a(paramQQAppInterface, paramMessageRecord);
      if (localObject2 == null) {
        break label1073;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.hotchat", 2, "carry authElem:" + ((im_msg_body.Elem)localObject2).near_by_msg.uint32_identify_type.get());
      }
      if (paramMessageRecord.msgtype == -2011)
      {
        localObject3 = ((im_msg_body.RichText)localObject1).elems.get();
        ((List)localObject3).add(0, localObject2);
        ((im_msg_body.RichText)localObject1).elems.set((List)localObject3);
        break label1073;
        if (localFriends.gender != 1) {
          break label2414;
        }
        k = 0;
        continue;
        localObject4 = ((acff)localObject4).b(paramQQAppInterface.getCurrentAccountUin());
        if (localObject4 != null)
        {
          j = ((Card)localObject4).age;
          k = ((Card)localObject4).shGender;
          localObject2 = ((Card)localObject4).strNick;
          continue;
        }
        j = 0;
        k = 2;
        continue;
        k -= 1;
        continue;
      }
      break label1073;
      if ((paramMessageRecord.istroop == 1033) || (paramMessageRecord.istroop == 1034))
      {
        localElem = new im_msg_body.Elem();
        aegu.a(localElem, paramMessageRecord);
        ((im_msg_body.RichText)localObject1).elems.add(localElem);
        if (!QLog.isColorLevel()) {
          break label1073;
        }
        QLog.i("Q.confess", 2, "bindConfessInfoElem");
        break label1073;
      }
      if (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("ext_key_frd_chat_confess_info")))
      {
        localElem = aegu.a(paramMessageRecord);
        if (localElem != null) {
          ((im_msg_body.RichText)localObject1).elems.add(localElem);
        }
        if (!QLog.isColorLevel()) {
          break label1073;
        }
        QLog.i("Q.confess", 2, "bindC2CFirstMsgConfessInfoElem elem:" + localElem);
        break label1073;
      }
      if (paramMessageRecord.istroop != 10007) {
        break label1073;
      }
      im_msg_body.Elem localElem = new im_msg_body.Elem();
      ahti.b(localElem, paramMessageRecord);
      ((im_msg_body.RichText)localObject1).elems.add(localElem);
      if (!QLog.isColorLevel()) {
        break label1073;
      }
      QLog.i("Q.confess", 2, "bindTinyInfoElem");
      break label1073;
      label2406:
      i = 0;
      localObject1 = null;
      break;
      label2414:
      k = 2;
    }
  }
  
  public static msg_svc.PbSendMsgReq a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, ArrayList<String> paramArrayList, ujt.a parama)
  {
    int i = 0;
    Object localObject1;
    boolean bool1;
    label69:
    boolean bool2;
    label85:
    boolean bool3;
    if (paramMessageRecord.msgtype == -1000)
    {
      localObject1 = anbh.a((MessageForText)paramMessageRecord);
      i = ((MessageForText)paramMessageRecord).msgVia;
      if ((localObject1 != null) && (((im_msg_body.RichText)localObject1).elems != null) && (paramArrayList != null) && (paramArrayList.size() != 0)) {
        break label261;
      }
      if (QLog.isColorLevel())
      {
        if (localObject1 != null) {
          break label237;
        }
        bool1 = true;
        if ((localObject1 == null) || (((im_msg_body.RichText)localObject1).elems != null)) {
          break label243;
        }
        bool2 = true;
        if (paramArrayList != null) {
          break label249;
        }
        bool3 = true;
        label92:
        if ((paramArrayList == null) || (paramArrayList.size() != 0)) {
          break label255;
        }
      }
    }
    label237:
    label243:
    label249:
    label255:
    for (boolean bool4 = true;; bool4 = false)
    {
      QLog.d("Q.msg.MessageHandlerUtils", 2, String.format("getPbSendReqFromBlessMsg, error: %s, %s, %s, %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4) }));
      return null;
      if (paramMessageRecord.msgtype == -2022)
      {
        localObject1 = anbh.a((MessageForShortVideo)paramMessageRecord);
        break;
      }
      if (paramMessageRecord.msgtype == -2000)
      {
        localObject1 = anbh.a((MessageForPic)paramMessageRecord);
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandlerUtils", 2, "getPbSendReqFromBlessMsg, error msgtype, " + paramMessageRecord.msgtype);
      }
      return null;
      bool1 = false;
      break label69;
      bool2 = false;
      break label85;
      bool3 = false;
      break label92;
    }
    label261:
    Object localObject2 = new im_msg_body.Elem();
    Object localObject3 = new im_msg_body.BlessingMessage();
    ((im_msg_body.BlessingMessage)localObject3).uint32_msg_type.set(1);
    if (paramMessageRecord.needUpdateMsgTag) {
      ((im_msg_body.BlessingMessage)localObject3).uint32_ex_flag.set(1);
    }
    for (;;)
    {
      ((im_msg_body.Elem)localObject2).bless_msg.set((MessageMicro)localObject3);
      ((im_msg_body.RichText)localObject1).elems.add((MessageMicro)localObject2);
      localObject2 = new im_msg_body.MsgBody();
      ((im_msg_body.MsgBody)localObject2).rich_text.set((MessageMicro)localObject1);
      localObject1 = new msg_svc.MultiMsgAssist();
      ((msg_svc.MultiMsgAssist)localObject1).msg_use.set(1);
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject3 = (String)paramArrayList.next();
        msg_svc.RoutingHead localRoutingHead = new msg_svc.RoutingHead();
        msg_svc.C2C localC2C = new msg_svc.C2C();
        localC2C.to_uin.set(Long.valueOf((String)localObject3).longValue());
        localRoutingHead.c2c.set(localC2C);
        ((msg_svc.MultiMsgAssist)localObject1).repeated_routing.add(localRoutingHead);
      }
      ((im_msg_body.BlessingMessage)localObject3).uint32_ex_flag.set(0);
    }
    if (parama != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandlerUtils", 2, String.format("getPbSendReqFromBlessMsg, hongbao param, temp_id: %d, video_len: %d, redbag_id: %s, redbag_amount: %d, has_readbag: %d, has_video: %d", new Object[] { Long.valueOf(parama.FA), Long.valueOf(parama.FB), parama.bY, Long.valueOf(parama.FC), Integer.valueOf(parama.bEU), Integer.valueOf(parama.bEV) }));
      }
      ((msg_svc.MultiMsgAssist)localObject1).uint64_temp_id.set(parama.FA);
      ((msg_svc.MultiMsgAssist)localObject1).uint64_vedio_len.set(parama.FB);
      ((msg_svc.MultiMsgAssist)localObject1).uint32_has_readbag.set(parama.bEU);
      if (parama.bEU == 1)
      {
        if (parama.bY != null) {
          ((msg_svc.MultiMsgAssist)localObject1).bytes_redbag_id.set(ByteStringMicro.copyFrom(parama.bY));
        }
        ((msg_svc.MultiMsgAssist)localObject1).uint64_redbag_amount.set(parama.FC);
      }
      ((msg_svc.MultiMsgAssist)localObject1).uint32_has_vedio.set(parama.bEV);
    }
    int j = anbk.ab(paramMessageRecord.msgUid);
    int k = (short)(int)paramMessageRecord.msgseq;
    parama = paramQQAppInterface.a().am();
    paramArrayList = new msg_svc.PbSendMsgReq();
    paramArrayList.msg_body.set((MessageMicro)localObject2);
    paramArrayList.msg_seq.set(k & 0xFFFF);
    paramArrayList.msg_rand.set(j);
    paramArrayList.msg_via.set(i);
    paramArrayList.multi_msg_assist.set((MessageMicro)localObject1);
    if (parama != null) {
      paramArrayList.sync_cookie.set(ByteStringMicro.copyFrom(parama));
    }
    if (paramArrayList != null)
    {
      i = paramArrayList.toByteArray().length;
      parama = (acle)paramQQAppInterface.getBusinessHandler(13);
      j = parama.AU();
      paramQQAppInterface = (BubbleManager)paramQQAppInterface.getManager(44);
      k = parama.AS();
      if (k <= 0) {
        break label1209;
      }
      paramQQAppInterface = paramQQAppInterface.a(k, false);
      if ((paramQQAppInterface != null) && ((paramQQAppInterface == null) || (paramQQAppInterface.jN == null) || (paramQQAppInterface.jN.size() <= 0))) {
        break label1191;
      }
      bool1 = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandlerUtils", 2, "bubbleId->" + k + " needSend->" + bool1);
      }
      if ((paramArrayList.msg_body.has()) && (((im_msg_body.MsgBody)paramArrayList.msg_body.get()).rich_text.has()))
      {
        paramQQAppInterface = (im_msg_body.RichText)((im_msg_body.MsgBody)paramArrayList.msg_body.get()).rich_text.get();
        if ((paramQQAppInterface.elems != null) && (paramQQAppInterface.elems.has()))
        {
          parama = new im_msg_body.GeneralFlags();
          localObject1 = new generalflags.ResvAttr();
          if ((!bool1) || ((j > 0) && ((i + 7 >= j) || (j <= 0))) || (paramMessageRecord.vipBubbleDiyTextId <= 0)) {
            break label1203;
          }
          j = 1;
          parama.uint32_bubble_diy_text_id.set(paramMessageRecord.vipBubbleDiyTextId);
          i = j;
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandlerUtils", 2, "add BubbleDiyTextId!");
          }
        }
      }
      label1191:
      label1203:
      for (i = j;; i = 0)
      {
        if (paramMessageRecord.vipSubBubbleId != 0)
        {
          j = 1;
          parama.uint32_bubble_sub_id.set(paramMessageRecord.vipSubBubbleId);
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.i("Q.msg.MessageHandlerUtils", 2, "getPbSendReqFromBlessMsg, sub bubbleid: " + paramMessageRecord.vipSubBubbleId);
            i = j;
          }
        }
        if ((paramMessageRecord instanceof MessageForShortVideo))
        {
          paramMessageRecord = (MessageForShortVideo)paramMessageRecord;
          if (paramMessageRecord.redBagType == LocalMediaInfo.REDBAG_TYPE_GET)
          {
            j = 1;
            ((generalflags.ResvAttr)localObject1).uint32_red_envelope_type.set(paramMessageRecord.redBagType);
            ((generalflags.ResvAttr)localObject1).bytes_shortVideoId.set(ByteStringMicro.copyFromUtf8(paramMessageRecord.shortVideoId));
            QLog.d("Q.msg.MessageHandlerUtils", 1, "VideoRedbag, generalflag take redbag flag in bless");
          }
        }
        for (;;)
        {
          if (j != 0)
          {
            i = 1;
            parama.bytes_pb_reserve.set(ByteStringMicro.copyFrom(((generalflags.ResvAttr)localObject1).toByteArray()));
          }
          if (i != 0)
          {
            paramMessageRecord = new im_msg_body.Elem();
            paramMessageRecord.general_flags.set(parama);
            paramQQAppInterface.elems.get().add(paramMessageRecord);
          }
          return paramArrayList;
          bool1 = false;
          break;
          j = 0;
        }
      }
      label1209:
      bool1 = false;
    }
  }
  
  private static im_msg_body.GeneralFlags a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, msg_svc.PbSendMsgReq paramPbSendMsgReq)
  {
    int j = 0;
    im_msg_body.GeneralFlags localGeneralFlags = new im_msg_body.GeneralFlags();
    generalflags.ResvAttr localResvAttr = new generalflags.ResvAttr();
    Object localObject1 = paramMessageRecord.getExtInfoFromExtStr(anbb.ccL);
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    label1053:
    label1191:
    label3134:
    for (;;)
    {
      try
      {
        i = Integer.parseInt((String)localObject1);
        localResvAttr.uint32_holiday_flag.set(i);
        i = 1;
      }
      catch (Exception localException2)
      {
        try
        {
          if ("babyq_set_avator".equals(paramMessageRecord.msg))
          {
            paramQQAppInterface = new babyq_cookie.BabyQCookie();
            paramQQAppInterface.uint32_type.set(201);
            localGeneralFlags.babyq_guide_msg_cookie.set(ByteStringMicro.copyFrom(paramQQAppInterface.toByteArray()));
            return localGeneralFlags;
            localException2 = localException2;
            if (QLog.isColorLevel()) {
              QLog.i("Q.msg.MessageHandlerUtils", 2, "getGeneralFlagElem, holiday_activie_flag.error: " + (String)localObject1);
            }
            i = 0;
            continue;
          }
          if ("babyq_add_friend".equals(paramMessageRecord.msg))
          {
            paramQQAppInterface = new babyq_cookie.BabyQCookie();
            paramQQAppInterface.uint32_type.set(202);
            localGeneralFlags.babyq_guide_msg_cookie.set(ByteStringMicro.copyFrom(paramQQAppInterface.toByteArray()));
            return localGeneralFlags;
          }
        }
        catch (Exception paramQQAppInterface)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandlerUtils", 2, "set guideMsgCookie error!", paramQQAppInterface);
          }
          return null;
        }
        if (!"babyq_add_troop".equals(paramMessageRecord.msg)) {
          continue;
        }
        paramQQAppInterface = new babyq_cookie.BabyQCookie();
        paramQQAppInterface.uint32_type.set(203);
        localGeneralFlags.babyq_guide_msg_cookie.set(ByteStringMicro.copyFrom(paramQQAppInterface.toByteArray()));
        return localGeneralFlags;
        if (!"babyq_game_strategy".equals(paramMessageRecord.msg)) {
          continue;
        }
        paramQQAppInterface = new babyq_cookie.BabyQCookie();
        paramQQAppInterface.uint32_type.set(204);
        paramQQAppInterface.uint32_user_click.set(1);
        localGeneralFlags.babyq_guide_msg_cookie.set(ByteStringMicro.copyFrom(paramQQAppInterface.toByteArray()));
        return localGeneralFlags;
        if (!"babyq_game_gift".equals(paramMessageRecord.msg)) {
          continue;
        }
        paramQQAppInterface = new babyq_cookie.BabyQCookie();
        paramQQAppInterface.uint32_type.set(205);
        paramQQAppInterface.uint32_user_click.set(1);
        localGeneralFlags.babyq_guide_msg_cookie.set(ByteStringMicro.copyFrom(paramQQAppInterface.toByteArray()));
        return localGeneralFlags;
        if (!"babyq_game_tribe".equals(paramMessageRecord.msg)) {
          continue;
        }
        paramQQAppInterface = new babyq_cookie.BabyQCookie();
        paramQQAppInterface.uint32_type.set(206);
        paramQQAppInterface.uint32_user_click.set(1);
        localGeneralFlags.babyq_guide_msg_cookie.set(ByteStringMicro.copyFrom(paramQQAppInterface.toByteArray()));
        return localGeneralFlags;
        if (!"baqyq_mayknow_people".equals(paramMessageRecord.msg)) {
          continue;
        }
        paramQQAppInterface = new babyq_cookie.BabyQCookie();
        paramQQAppInterface.uint32_type.set(207);
        paramQQAppInterface.uint32_user_click.set(1);
        localGeneralFlags.babyq_guide_msg_cookie.set(ByteStringMicro.copyFrom(paramQQAppInterface.toByteArray()));
        return localGeneralFlags;
        paramQQAppInterface = aqft.p(paramMessageRecord.msg);
        if (paramQQAppInterface == null) {
          continue;
        }
        localGeneralFlags.babyq_guide_msg_cookie.set(ByteStringMicro.copyFrom(paramQQAppInterface));
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.msg.MessageHandlerUtils", 2, "getGeneralFlagElem, guideMsgCookie: " + paramMessageRecord.msg + " ,bytes:" + Arrays.toString(paramQQAppInterface));
        return localGeneralFlags;
      }
      if (paramMessageRecord.msgtype == -1052)
      {
        if (paramMessageRecord.msg != null) {}
        return null;
      }
      localObject1 = (BubbleManager)paramQQAppInterface.getManager(44);
      Object localObject2;
      int k;
      int m;
      if (paramPbSendMsgReq != null)
      {
        j = paramPbSendMsgReq.toByteArray().length;
        localObject2 = (acle)paramQQAppInterface.getBusinessHandler(13);
        k = ((acle)localObject2).AU();
        m = ((acle)localObject2).AS();
        if (m <= 0) {
          break label3296;
        }
        localObject1 = ((BubbleManager)localObject1).a(m, false);
        if ((localObject1 != null) && ((localObject1 == null) || (((adxm)localObject1).jN == null) || (((adxm)localObject1).jN.size() <= 0))) {
          break label2164;
        }
      }
      label1866:
      label3276:
      label3296:
      for (boolean bool = true;; bool = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandlerUtils", 2, "bubbleId->" + m + " needSend->" + bool);
        }
        if ((bool) && ((k <= 0) || ((j + 7 < k) && (k > 0))) && (paramMessageRecord.vipBubbleDiyTextId > 0) && (paramPbSendMsgReq.msg_body.has()) && (((im_msg_body.MsgBody)paramPbSendMsgReq.msg_body.get()).rich_text.has()))
        {
          localObject1 = (im_msg_body.RichText)((im_msg_body.MsgBody)paramPbSendMsgReq.msg_body.get()).rich_text.get();
          if ((((im_msg_body.RichText)localObject1).elems != null) && (((im_msg_body.RichText)localObject1).elems.has()))
          {
            k = 1;
            localGeneralFlags.uint32_bubble_diy_text_id.set(paramMessageRecord.vipBubbleDiyTextId);
            j = k;
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandlerUtils", 2, "add BubbleDiyTextId!");
            }
          }
        }
        for (j = k;; j = 0) {
          for (;;)
          {
            if (paramMessageRecord.vipSubBubbleId != 0)
            {
              if (QLog.isColorLevel()) {
                QLog.i("Q.msg.MessageHandlerUtils", 2, "getGeneralFlagElemFromMsg, sub bubbleid: " + paramMessageRecord.vipSubBubbleId);
              }
              j = 1;
              localGeneralFlags.uint32_bubble_sub_id.set(paramMessageRecord.vipSubBubbleId);
            }
            int i1 = i;
            int n = j;
            if ((paramMessageRecord instanceof MessageForFoldMsg))
            {
              i1 = i;
              n = j;
              if (zxj.I(paramQQAppInterface))
              {
                bool = zxj.J(paramQQAppInterface);
                localObject2 = (zxj)paramQQAppInterface.getManager(125);
                localObject1 = (MessageForFoldMsg)paramMessageRecord;
                k = i;
                m = j;
                if (((MessageForFoldMsg)localObject1).redBagId != null)
                {
                  k = i;
                  m = j;
                  if (zxj.J(paramQQAppInterface))
                  {
                    n = 1;
                    i1 = 1;
                    if ((!bool) || (((zxj)localObject2).buu)) {
                      break label2170;
                    }
                    i = 1;
                    label1018:
                    if (i == 0) {
                      localGeneralFlags.uint64_uin.set(((MessageForFoldMsg)localObject1).mPasswdRedBagSender);
                    }
                    localObject2 = localGeneralFlags.uint32_prp_fold;
                    if (!((MessageForFoldMsg)localObject1).foldFlagTemp) {
                      break label2175;
                    }
                    j = 1;
                    ((PBUInt32Field)localObject2).set(j);
                    if ((!TextUtils.isEmpty(((MessageForFoldMsg)localObject1).redBagId)) && (i == 0)) {
                      localGeneralFlags.bytes_rp_id.set(ByteStringMicro.copyFromUtf8(((MessageForFoldMsg)localObject1).redBagId));
                    }
                    k = i1;
                    m = n;
                    if (!TextUtils.isEmpty(((MessageForFoldMsg)localObject1).redBagIndex))
                    {
                      k = i1;
                      m = n;
                      if (bool)
                      {
                        localGeneralFlags.bytes_rp_index.set(ByteStringMicro.copyFromUtf8(((MessageForFoldMsg)localObject1).redBagIndex));
                        localResvAttr.redbag_msg_sender_uin.set(((MessageForFoldMsg)localObject1).mPasswdRedBagSender);
                        m = n;
                        k = i1;
                      }
                    }
                  }
                }
                i1 = k;
                n = m;
                if (QLog.isColorLevel())
                {
                  long l = ((MessageForFoldMsg)localObject1).mPasswdRedBagSender;
                  if (!((MessageForFoldMsg)localObject1).foldFlagTemp) {
                    break label2181;
                  }
                  i = 1;
                  QLog.d("msgFold", 2, String.format("Send, pack foldMsg, senderUin: %d, foldFlag: %s, redBagId: %s", new Object[] { Long.valueOf(l), Integer.valueOf(i), ((MessageForFoldMsg)localObject1).redBagId }));
                  QLog.d("msgFold", 2, String.format("Send, send foldMsg, frienduin: %s, msguid: %s, shmsgseq: %s content: %s", new Object[] { ((MessageForFoldMsg)localObject1).frienduin, Long.valueOf(((MessageForFoldMsg)localObject1).msgUid), Long.valueOf(((MessageForFoldMsg)localObject1).shmsgseq), ((MessageForFoldMsg)localObject1).getLogColorContent() }));
                  n = m;
                  i1 = k;
                }
              }
            }
            j = i1;
            if (paramMessageRecord.msgtype == -2058)
            {
              localObject1 = EmojiStickerManager.a(paramMessageRecord);
              j = i1;
              if (localObject1 != null)
              {
                i = 1;
                localResvAttr.float_sticker_x.set(((EmojiStickerManager.StickerInfo)localObject1).x);
                localResvAttr.float_sticker_y.set(((EmojiStickerManager.StickerInfo)localObject1).y);
                localResvAttr.float_sticker_width.set(((EmojiStickerManager.StickerInfo)localObject1).width);
                localResvAttr.float_sticker_height.set(((EmojiStickerManager.StickerInfo)localObject1).height);
                localResvAttr.uint32_sticker_rotate.set(((EmojiStickerManager.StickerInfo)localObject1).rotate);
                if (paramMessageRecord.istroop != 0) {
                  break label2186;
                }
                localResvAttr.uint64_sticker_host_msgseq.set((short)(int)((EmojiStickerManager.StickerInfo)localObject1).hostMsgSeq & 0xFFFF);
                localResvAttr.uint64_sticker_host_msguid.set(((EmojiStickerManager.StickerInfo)localObject1).hostMsgUid);
                localResvAttr.uint64_sticker_host_time.set(((EmojiStickerManager.StickerInfo)localObject1).hostMsgTime);
                j = i;
                if (QLog.isColorLevel())
                {
                  QLog.i("Q.msg.MessageHandlerUtils", 2, "set generalFlag for sticker info: " + ((EmojiStickerManager.StickerInfo)localObject1).toString());
                  j = i;
                }
              }
            }
            if ((paramMessageRecord instanceof MessageForLongTextMsg))
            {
              localObject1 = (MessageForLongTextMsg)paramMessageRecord;
              i = n;
              if (((MessageForLongTextMsg)localObject1).structingMsg != null)
              {
                localGeneralFlags.long_text_flag.set(1);
                localGeneralFlags.long_text_resid.set(ByteStringMicro.copyFromUtf8(((MessageForLongTextMsg)localObject1).structingMsg.mResid));
                i = 1;
              }
              localObject1 = ((acff)paramQQAppInterface.getManager(51)).a(paramQQAppInterface.getCurrentUin());
              k = j;
              j = i;
              if (localObject1 != null)
              {
                localGeneralFlags.uint64_pendant_id.set(((ExtensionInfo)localObject1).pendantId);
                m = 1;
                localResvAttr.uint32_mobile_custom_font.set(ku.a((ExtensionInfo)localObject1));
                localObject2 = paramMessageRecord.getExtInfoFromExtStr("vip_sub_font_id");
                i = 0;
                if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                  i = Integer.parseInt((String)localObject2);
                }
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.MessageHandlerUtils", 2, "getGeneralFlagElemFromMsg: fontId=" + ((ExtensionInfo)localObject1).uVipFont + " subFontId=" + i);
                }
                localResvAttr.uint64_subfont_id.set(i);
                if ((((ExtensionInfo)localObject1).diyFontTimestampMap != null) && (((ExtensionInfo)localObject1).diyFontTimestampMap.get(Integer.valueOf((int)((ExtensionInfo)localObject1).uVipFont)) != null)) {
                  localResvAttr.uint32_diy_font_timestamp.set(((Integer)((ExtensionInfo)localObject1).diyFontTimestampMap.get(Integer.valueOf((int)((ExtensionInfo)localObject1).uVipFont))).intValue());
                }
                i = 1;
                if (((ExtensionInfo)localObject1).pendantDiyId > 0) {
                  localResvAttr.uint32_pendant_diy_id.set(((ExtensionInfo)localObject1).pendantDiyId);
                }
                if (((ExtensionInfo)localObject1).faceId > 0) {
                  localResvAttr.uint32_face_id.set(((ExtensionInfo)localObject1).faceId);
                }
                k = i;
                j = m;
                if (((ExtensionInfo)localObject1).fontEffect > 0)
                {
                  localResvAttr.uint32_req_font_effect_id.set(((ExtensionInfo)localObject1).fontEffect);
                  j = m;
                  k = i;
                }
              }
              i = k;
              if ((paramMessageRecord instanceof MessageForWantGiftMsg))
              {
                localResvAttr.want_gift_sender_uin.set(((MessageForWantGiftMsg)paramMessageRecord).wantGiftSenderUin);
                i = 1;
              }
              localObject1 = paramMessageRecord.getExtInfoFromExtStr("robot_news_class_id");
            }
            try
            {
              for (;;)
              {
                localResvAttr.uint32_bot_message_class_id.set(Integer.parseInt((String)localObject1));
                localObject1 = paramMessageRecord.getExtInfoFromExtStr("key_message_extra_info_flag");
                try
                {
                  k = Integer.parseInt((String)localObject1);
                  if ((k & 0x1) == 1)
                  {
                    m = 1;
                    if (m != 0)
                    {
                      localResvAttr.uint32_msg_info_flag.set(k);
                      if (QLog.isColorLevel()) {
                        QLog.i("Q.msg.MessageHandlerUtils", 2, "getGeneralFlagElemFromMsg: invoked.  containPasteExtra: " + (String)localObject1);
                      }
                    }
                    if (!((aptw)paramQQAppInterface.getManager(203)).bf(paramMessageRecord)) {
                      break label2338;
                    }
                    localResvAttr.uint32_robot_msg_flag.set(1, true);
                    k = 1;
                    i = k;
                    if (!(paramMessageRecord instanceof MessageForPtt)) {
                      break label2338;
                    }
                    localObject1 = (MessageForPtt)paramMessageRecord;
                    new im_msg_body.Elem();
                    new im_msg_body.Text();
                    i = k;
                    if (((MessageForPtt)localObject1).atInfoList == null) {
                      break label2338;
                    }
                    i = k;
                    if (((MessageForPtt)localObject1).atInfoList.isEmpty()) {
                      break label2338;
                    }
                    paramPbSendMsgReq = (im_msg_body.RichText)((im_msg_body.MsgBody)paramPbSendMsgReq.msg_body.get()).rich_text.get();
                    anbh.a(paramPbSendMsgReq, ((MessageForPtt)localObject1).mInputContent, ((MessageForPtt)localObject1).atInfoList);
                    i = k;
                    if (!paramPbSendMsgReq.elems.has()) {
                      break label2338;
                    }
                    paramPbSendMsgReq = paramPbSendMsgReq.elems.get().iterator();
                    for (;;)
                    {
                      i = k;
                      if (!paramPbSendMsgReq.hasNext()) {
                        break;
                      }
                      localObject1 = (im_msg_body.Elem)paramPbSendMsgReq.next();
                      if (((im_msg_body.Elem)localObject1).text.has())
                      {
                        localObject1 = (im_msg_body.Text)((im_msg_body.Elem)localObject1).text.get();
                        if (((im_msg_body.Text)localObject1).str.has()) {
                          ((im_msg_body.Text)localObject1).str.set(ByteStringMicro.copyFromUtf8(""));
                        }
                      }
                    }
                    label2164:
                    bool = false;
                    break;
                    label2170:
                    i = 0;
                    break label1018;
                    label2175:
                    j = 0;
                    break label1053;
                    i = 0;
                    break label1191;
                    localResvAttr.uint64_sticker_host_msgseq.set(((EmojiStickerManager.StickerInfo)localObject1).hostMsgSeq);
                    break label1417;
                    if ((paramMessageRecord instanceof MessageForArkApp))
                    {
                      localObject1 = (MessageForArkApp)paramMessageRecord;
                      i = n;
                      if (TextUtils.isEmpty(((MessageForArkApp)localObject1).resIDForLongMsg)) {
                        break label1539;
                      }
                      localGeneralFlags.long_text_flag.set(1);
                      localGeneralFlags.long_text_resid.set(ByteStringMicro.copyFromUtf8(((MessageForArkApp)localObject1).resIDForLongMsg));
                      i = 1;
                      break label1539;
                    }
                    i = n;
                    if (!(paramMessageRecord instanceof MessageForArkBabyqReply)) {
                      break label1539;
                    }
                    localObject1 = (MessageForArkBabyqReply)paramMessageRecord;
                    i = n;
                    if (TextUtils.isEmpty(((MessageForArkBabyqReply)localObject1).resIDForLongMsg)) {
                      break label1539;
                    }
                    localGeneralFlags.long_text_flag.set(1);
                    localGeneralFlags.long_text_resid.set(ByteStringMicro.copyFromUtf8(((MessageForArkBabyqReply)localObject1).resIDForLongMsg));
                    i = 1;
                  }
                }
                catch (NumberFormatException localNumberFormatException)
                {
                  for (;;)
                  {
                    localNumberFormatException.printStackTrace();
                    k = 0;
                    continue;
                    m = 0;
                  }
                  if (afdw.an(paramMessageRecord))
                  {
                    k = 1;
                    localResvAttr.uint32_doutu_msg_type.set(1);
                    i = k;
                    if (QLog.isColorLevel())
                    {
                      QLog.d("Q.msg.MessageHandlerUtils", 2, "getGeneralFlagElemFromMsg [doutu] set uint32_doutu_msg_type ");
                      i = k;
                    }
                  }
                  k = i;
                  if ((paramMessageRecord instanceof MessageForPic))
                  {
                    k = i;
                    if (ykm.e((MessageForPic)paramMessageRecord))
                    {
                      i = 1;
                      localResvAttr.uint32_custom_featureid.set(33025);
                      k = i;
                      if (QLog.isColorLevel())
                      {
                        QLog.d("Q.msg.MessageHandlerUtils", 2, "getGeneralFlagElemFromMsg [zhitu] set uint32_custom_featureid ");
                        k = i;
                      }
                    }
                  }
                  i = k;
                  if ((paramMessageRecord instanceof ChatMessage))
                  {
                    i = k;
                    if (TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("msg_ext_key"))) {}
                  }
                  try
                  {
                    paramPbSendMsgReq = KplRoleInfo.getGameNickByUin(paramQQAppInterface, paramMessageRecord.selfuin);
                    paramQQAppInterface = KplRoleInfo.getGameNickByUin(paramQQAppInterface, paramMessageRecord.frienduin);
                    localObject1 = new JSONObject();
                    ((JSONObject)localObject1).put(paramMessageRecord.selfuin, paramPbSendMsgReq);
                    ((JSONObject)localObject1).put(paramMessageRecord.frienduin, paramQQAppInterface);
                    paramQQAppInterface = ((JSONObject)localObject1).toString();
                    if (QLog.isColorLevel()) {
                      QLog.d("KplMessage", 2, "general kpl flag=" + paramQQAppInterface);
                    }
                    paramQQAppInterface = paramQQAppInterface.getBytes("utf-8");
                  }
                  catch (Exception paramQQAppInterface)
                  {
                    try
                    {
                      paramQQAppInterface = new UploadParam();
                      paramQQAppInterface.bytes_qzone_albumid.set(ByteStringMicro.copyFromUtf8(paramMessageRecord.getExtInfoFromExtStr("msg_extra_key_qzone_album_id")));
                      paramQQAppInterface.uint64_batchid.set(Long.valueOf(paramMessageRecord.getExtInfoFromExtStr("msg_extra_key_qzone_batch_id")).longValue());
                      paramQQAppInterface.uint32_full_image.set(Integer.valueOf(paramMessageRecord.getExtInfoFromExtStr("msg_extra_key_qzone_is_raw")).intValue());
                      paramQQAppInterface.uint64_image_number.set(Long.valueOf(paramMessageRecord.getExtInfoFromExtStr("msg_extra_key_qzone_batch_count")).longValue());
                      paramQQAppInterface.uint64_image_number_index.set(Long.valueOf(paramMessageRecord.getExtInfoFromExtStr("msg_extra_key_qzone_photo_index")).longValue());
                      localResvAttr.bytes_upload_image_to_qzone_param.set(ByteStringMicro.copyFrom(paramQQAppInterface.toByteArray()));
                      if (!QLog.isColorLevel()) {
                        break label3010;
                      }
                      QLog.d("Q.msg.MessageHandlerUtils", 2, "general syncQzoneAlbum : albumid = " + paramMessageRecord.getExtInfoFromExtStr("msg_extra_key_qzone_album_id") + ", batchid = " + paramMessageRecord.getExtInfoFromExtStr("msg_extra_key_qzone_batch_id") + ", isRaw = " + paramMessageRecord.getExtInfoFromExtStr("msg_extra_key_qzone_is_raw") + ", imgCount = " + paramMessageRecord.getExtInfoFromExtStr("msg_extra_key_qzone_batch_count") + ", imgIndex = " + paramMessageRecord.getExtInfoFromExtStr("msg_extra_key_qzone_photo_index"));
                      if (!(paramMessageRecord instanceof MessageForPtt)) {
                        break label3050;
                      }
                      paramQQAppInterface = (MessageForPtt)paramMessageRecord;
                      if (paramQQAppInterface.waveformArray == null) {
                        break label3050;
                      }
                      localResvAttr.bytes_pb_ptt_waveform.set(ByteStringMicro.copyFrom(aqjh.a(paramQQAppInterface.waveformArray).toByteArray()));
                      if (!(paramMessageRecord instanceof MessageForReplyText)) {
                        break label3205;
                      }
                      i = 1;
                      paramQQAppInterface = (MessageForReplyText)paramMessageRecord;
                      if (!paramQQAppInterface.isBarrageMsg) {
                        break label3134;
                      }
                      localResvAttr.uint32_comment_flag.set(1);
                      localResvAttr.uint64_comment_location.set(paramQQAppInterface.barrageTimeLocation);
                      paramMessageRecord = new oidb_0xdea.PassThrough();
                      paramMessageRecord.entrance.set(paramQQAppInterface.barrageSourceMsgType);
                      paramMessageRecord.uint32_client_type.set(1);
                      localResvAttr.bytes_pass_through.set(ByteStringMicro.copyFrom(paramMessageRecord.toByteArray()));
                      k = i;
                      if (!QLog.isColorLevel()) {
                        break label3205;
                      }
                      QLog.d("Q.msg.MessageHandlerUtils", 2, new Object[] { "send replay msg, isBarrageMsg: ", Boolean.valueOf(paramQQAppInterface.isBarrageMsg), " timeLocation:", Long.valueOf(paramQQAppInterface.barrageTimeLocation), " type:", Integer.valueOf(paramQQAppInterface.barrageSourceMsgType) });
                      k = i;
                      if (k == 0) {
                        break label3229;
                      }
                      j = 1;
                      localGeneralFlags.bytes_pb_reserve.set(ByteStringMicro.copyFrom(localResvAttr.toByteArray()));
                      if (j == 0) {
                        break label3276;
                      }
                      for (paramQQAppInterface = localGeneralFlags;; paramQQAppInterface = null)
                      {
                        return paramQQAppInterface;
                        paramQQAppInterface = paramQQAppInterface;
                        if (QLog.isColorLevel()) {
                          QLog.d("KplMessage", 2, "some error at MessageHandlerUtils::getGeneralFlagElemFromMsg()");
                        }
                        paramQQAppInterface.printStackTrace();
                        paramQQAppInterface = null;
                        break;
                        k = 0;
                        break label2657;
                        i = 0;
                        break label2722;
                      }
                    }
                    catch (Exception paramQQAppInterface)
                    {
                      break label3010;
                    }
                  }
                  i = k;
                  if (paramQQAppInterface != null)
                  {
                    i = 1;
                    localResvAttr.bytes_kpl_info.set(ByteStringMicro.copyFrom(paramQQAppInterface));
                  }
                  k = i;
                  if ((paramMessageRecord instanceof MessageForShortVideo))
                  {
                    paramQQAppInterface = (MessageForShortVideo)paramMessageRecord;
                    if (paramQQAppInterface.redBagType == LocalMediaInfo.REDBAG_TYPE_GET)
                    {
                      i = 1;
                      localResvAttr.uint32_red_envelope_type.set(paramQQAppInterface.redBagType);
                      localResvAttr.bytes_shortVideoId.set(ByteStringMicro.copyFromUtf8(paramQQAppInterface.shortVideoId));
                      QLog.d("Q.msg.MessageHandlerUtils", 1, "VideoRedbag, generalflag take redbag flag");
                    }
                    paramPbSendMsgReq = localResvAttr.uint32_aio_sync_to_story_flag;
                    if (paramQQAppInterface.syncToStory)
                    {
                      k = 1;
                      label2657:
                      paramPbSendMsgReq.set(k);
                      QLog.d("Q.msg.MessageHandlerUtils", 1, "EditAioSyncToStoryPart Video sync to story is " + paramQQAppInterface.syncToStory);
                      k = i;
                    }
                  }
                  else
                  {
                    if ((paramMessageRecord instanceof MessageForPic))
                    {
                      paramQQAppInterface = (MessageForPic)paramMessageRecord;
                      paramPbSendMsgReq = localResvAttr.uint32_aio_sync_to_story_flag;
                      if (!paramQQAppInterface.sync2Story) {
                        break label3271;
                      }
                      i = 1;
                      paramPbSendMsgReq.set(i);
                      QLog.d("Q.msg.MessageHandlerUtils", 1, "EditAioSyncToStoryPart pic sync to story is " + paramQQAppInterface.sync2Story);
                    }
                    if (((paramMessageRecord instanceof MessageForPic)) && (paramMessageRecord.getExtInfoFromExtStr("msg_extra_key_is_sync_qzone").equals("1"))) {
                      localResvAttr.uint32_upload_image_to_qzone_flag.set(1);
                    }
                  }
                }
              }
            }
            catch (Exception localException1)
            {
              label3050:
              break label1866;
            }
          }
        }
      }
      label3010:
      label3271:
      int i = 0;
    }
  }
  
  private static im_msg_body.RichText a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    Object localObject = null;
    Iterator localIterator = paramQQAppInterface.b().a().cz().iterator();
    while (localIterator.hasNext())
    {
      im_msg_body.RichText localRichText = ((tpm)localIterator.next()).a(paramMessageRecord, paramQQAppInterface);
      localObject = localRichText;
      if (localRichText != null) {
        localObject = localRichText;
      }
    }
    return localObject;
  }
  
  public static void a(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel())
    {
      QLog.d(paramString1, 2, "<" + paramString2 + paramLong);
      paramString3 = paramLong + "|" + paramString3 + "|" + paramString4;
      if (paramString2 != null) {
        QLog.d(paramString1, 2, paramString2 + paramString3);
      }
    }
  }
  
  public static boolean a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (tpu)paramQQAppInterface.b().a().a().get(Integer.valueOf(paramInt));
    if ((paramQQAppInterface != null) && (paramQQAppInterface.Or())) {
      return true;
    }
    if ((paramInt == 1) || (paramInt == 3) || (paramInt == 24) || (paramInt == 14) || (paramInt == 5) || (paramInt == 6) || (paramInt == 10) || (paramInt == 11) || (paramInt == 12) || (paramInt == 23) || (paramInt == 25) || (paramInt == 26) || (paramInt == 8) || (paramInt == 16) || (paramInt == 17) || (paramInt == 18) || (paramInt == 15) || (paramInt == 19) || (paramInt == 20) || (paramInt == 22) || (paramInt == 28) || (paramInt == 27) || (paramInt == 29) || (paramInt == 31) || (paramInt == 30) || (paramInt == 32)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    paramQQAppInterface = paramQQAppInterface.b().k(paramString1, paramInt);
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder().append("------->msgFilter :msgIsTroop:").append(paramInt).append(",peerUin:").append(paramString1).append(",list size:");
      if (paramQQAppInterface != null) {
        break label164;
      }
    }
    label164:
    for (paramInt = 0;; paramInt = paramQQAppInterface.size())
    {
      QLog.d("Q.msg.MessageHandlerUtils", 2, paramInt);
      if ((paramQQAppInterface == null) || (paramQQAppInterface.size() <= 0)) {
        break;
      }
      paramQQAppInterface = paramQQAppInterface.iterator();
      do
      {
        if (!paramQQAppInterface.hasNext()) {
          break;
        }
        paramString1 = (MessageRecord)paramQQAppInterface.next();
      } while ((Math.abs(paramString1.time - paramLong1) >= 30L) || (paramString1.shmsgseq != paramLong2) || (!paramString1.senderuin.equals(paramString2)));
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandlerUtils", 2, "------->msgFilter-duplicated msg.");
      }
      return true;
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if ((paramMessageRecord == null) || ((paramMessageRecord.msg == null) && (paramMessageRecord.msgData == null)))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.MessageHandlerUtils", 2, "---------------msgFilter message [before filter] is null !");
      }
      return true;
    }
    long l = System.currentTimeMillis();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder(256);
      localStringBuilder.append("---------------msgFilter istroop: ").append(paramMessageRecord.istroop).append(" uid: ").append(paramMessageRecord.msgUid).append(" shmsgseq: ").append(paramMessageRecord.shmsgseq).append(" friendUin: ").append(paramMessageRecord.frienduin).append(" senderUin: ").append(paramMessageRecord.senderuin).append(" msgType: ").append(paramMessageRecord.msgtype).append(" time:").append(paramMessageRecord.time).append(" msgContent: ").append(paramMessageRecord.getLogColorContent()).append(" isNormalMsg: ").append(paramBoolean);
    }
    for (;;)
    {
      Object localObject = paramQQAppInterface.b().k(paramMessageRecord.frienduin, paramMessageRecord.istroop);
      if ((paramMessageRecord.istroop == 1) || (paramMessageRecord.istroop == 1026) || (paramMessageRecord.istroop == 3000))
      {
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            if (top.a((MessageRecord)((Iterator)localObject).next(), paramMessageRecord, false, paramBoolean))
            {
              if ((QLog.isColorLevel()) && (localStringBuilder != null))
              {
                localStringBuilder.append(" filterType: troop msg isNormalMsg=" + paramBoolean);
                QLog.w("Q.msg.MessageHandlerUtils", 2, localStringBuilder.toString());
              }
              MsgAutoMonitorUtil.getInstance().addMsgFilterTime(System.currentTimeMillis() - l);
              return true;
            }
          }
        }
        if (paramQQAppInterface.a().aV(paramMessageRecord)) {
          return true;
        }
      }
      else if (top.fv(paramMessageRecord.istroop))
      {
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            if (top.a((MessageRecord)((Iterator)localObject).next(), paramMessageRecord, paramBoolean))
            {
              if ((QLog.isColorLevel()) && (localStringBuilder != null))
              {
                localStringBuilder.append(" filterType: " + paramMessageRecord.istroop);
                QLog.w("Q.msg.MessageHandlerUtils", 2, localStringBuilder.toString());
              }
              MsgAutoMonitorUtil.getInstance().addMsgFilterTime(System.currentTimeMillis() - l);
              return true;
            }
          }
        }
        if (paramQQAppInterface.a().aV(paramMessageRecord)) {
          return true;
        }
      }
      else if (paramMessageRecord.istroop == 7220)
      {
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          paramQQAppInterface = ((List)localObject).iterator();
          do
          {
            if (!paramQQAppInterface.hasNext()) {
              break;
            }
          } while (!top.a((MessageRecord)paramQQAppInterface.next(), paramMessageRecord, true));
          if ((QLog.isColorLevel()) && (localStringBuilder != null))
          {
            localStringBuilder.append(" filterType: other");
            QLog.w("Q.msg.MessageHandlerUtils", 2, localStringBuilder.toString());
          }
          MsgAutoMonitorUtil.getInstance().addMsgFilterTime(System.currentTimeMillis() - l);
          return true;
        }
      }
      else if ((localObject != null) && (((List)localObject).size() > 0))
      {
        paramQQAppInterface = ((List)localObject).iterator();
        while (paramQQAppInterface.hasNext())
        {
          localObject = (MessageRecord)paramQQAppInterface.next();
          if ((((MessageRecord)localObject).time == paramMessageRecord.time) && (((MessageRecord)localObject).msg.equals(paramMessageRecord.msg)))
          {
            if ((QLog.isColorLevel()) && (localStringBuilder != null))
            {
              localStringBuilder.append(" filterType: other");
              QLog.w("Q.msg.MessageHandlerUtils", 2, localStringBuilder.toString());
            }
            MsgAutoMonitorUtil.getInstance().addMsgFilterTime(System.currentTimeMillis() - l);
            return true;
          }
        }
      }
      if ((QLog.isColorLevel()) && (localStringBuilder != null)) {
        QLog.d("Q.msg.MessageHandlerUtils", 2, localStringBuilder.toString());
      }
      MsgAutoMonitorUtil.getInstance().addMsgFilterTime(System.currentTimeMillis() - l);
      return false;
      localStringBuilder = null;
    }
  }
  
  public static String[] a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return null;
    }
    String[] arrayOfString = new String[7];
    long l1 = paramToServiceMsg.extraData.getLong("startTime", 0L);
    long l6 = paramFromServiceMsg.extraData.getLong("timestamp_app2msf_atAppSite", 0L);
    long l5 = paramFromServiceMsg.extraData.getLong("timestamp_app2msf_atMsfSite", 0L);
    long l8 = paramFromServiceMsg.extraData.getLong("timestamp_msf2net_atMsfSite", 0L);
    long l3 = paramFromServiceMsg.extraData.getLong("timestamp_net2msf_atMsfSite", 0L);
    long l4 = paramFromServiceMsg.extraData.getLong("timestamp_msf2app_atMsfSite", 0L);
    long l2 = paramFromServiceMsg.extraData.getLong("timestamp_msf2app_atAppSite", 0L);
    long l7 = System.currentTimeMillis();
    arrayOfString[1] = String.valueOf(l7 - l1);
    arrayOfString[2] = String.valueOf(l3 - l8);
    arrayOfString[3] = String.valueOf(l8 - l1);
    arrayOfString[4] = String.valueOf(l7 - l3);
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("handler");
    if (l6 != 0L)
    {
      paramToServiceMsg.append("|").append(String.valueOf(l6 - l1)).append("|app");
      l1 = l6;
    }
    for (;;)
    {
      if (l5 != 0L)
      {
        paramToServiceMsg.append("|").append(String.valueOf(l5 - l1)).append("|msf");
        l1 = l5;
      }
      for (;;)
      {
        if (l8 != 0L) {
          paramToServiceMsg.append("|").append(String.valueOf(l8 - l1)).append("|net");
        }
        arrayOfString[5] = paramToServiceMsg.toString();
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("net");
        if (l4 != 0L) {
          paramToServiceMsg.append("|").append(String.valueOf(l4 - l3)).append("|msf");
        }
        for (l1 = l4;; l1 = l3)
        {
          if (l2 != 0L)
          {
            paramToServiceMsg.append("|").append(String.valueOf(l2 - l1)).append("|app");
            l1 = l2;
          }
          for (;;)
          {
            paramToServiceMsg.append("|").append(String.valueOf(l7 - l1)).append("|handler");
            arrayOfString[6] = paramToServiceMsg.toString();
            paramToServiceMsg = new StringBuilder();
            paramToServiceMsg.append("{");
            paramToServiceMsg.append("total:").append(arrayOfString[1]).append(",");
            paramToServiceMsg.append("net:").append(arrayOfString[2]).append(",");
            paramToServiceMsg.append("send:").append(arrayOfString[3]).append(",");
            paramToServiceMsg.append("recv:").append(arrayOfString[4]).append(",");
            paramToServiceMsg.append("sendDetail:").append(arrayOfString[5]).append(",");
            paramToServiceMsg.append("recvDetail:").append(arrayOfString[6]);
            paramToServiceMsg.append("}");
            arrayOfString[0] = paramToServiceMsg.toString();
            return arrayOfString;
          }
        }
      }
    }
  }
  
  public static boolean aa(MessageRecord paramMessageRecord)
  {
    boolean bool = true;
    if ((paramMessageRecord.istroop != 1) && (paramMessageRecord.istroop != 3000)) {
      bool = Z(paramMessageRecord);
    }
    while ((Z(paramMessageRecord)) && (paramMessageRecord.extraflag == 0)) {
      return bool;
    }
    return false;
  }
  
  private static void b(MessageRecord paramMessageRecord, msg_svc.PbSendMsgReq paramPbSendMsgReq, QQAppInterface paramQQAppInterface)
  {
    Iterator localIterator = paramQQAppInterface.b().a().cz().iterator();
    while (localIterator.hasNext()) {
      ((tpm)localIterator.next()).a(paramMessageRecord, paramPbSendMsgReq, paramQQAppInterface);
    }
  }
  
  public static long c(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length != 4) {
      return 0L;
    }
    return ((paramArrayOfByte[0] & 0xFF) << 24) + ((paramArrayOfByte[1] & 0xFF) << 16) + ((paramArrayOfByte[2] & 0xFF) << 8) + (paramArrayOfByte[3] & 0xFF);
  }
  
  public static String e(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    String str = paramQQAppInterface.getCurrentAccountUin();
    if ((str != null) && (str.equals(paramString1))) {
      return acfp.m(2131708199);
    }
    paramString2 = aqgv.a(paramQQAppInterface, paramString1, paramString2, 1, 0);
    if (paramString2 == paramString1)
    {
      paramQQAppInterface = ((acff)paramQQAppInterface.getManager(51)).e(paramString1);
      if (paramQQAppInterface != null) {
        return aqgv.c(paramQQAppInterface);
      }
    }
    return paramString2;
  }
  
  public static boolean f(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.MessageHandlerUtils", 2, "---------------msgFilter message [before filter] is null !");
      }
      return true;
    }
    long l = System.currentTimeMillis();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder(256);
      localStringBuilder.append("---------------msgFilter istroop: ").append(paramMessageRecord.istroop).append(" shmsgseq: ").append(paramMessageRecord.shmsgseq).append(" friendUin: ").append(paramMessageRecord.frienduin).append(" senderUin: ").append(paramMessageRecord.senderuin).append(" msgType: ").append(paramMessageRecord.msgtype).append(" time:").append(paramMessageRecord.time).append(" msgContent: ").append(paramMessageRecord.getLogColorContent());
    }
    for (;;)
    {
      paramQQAppInterface = paramQQAppInterface.b().k(paramMessageRecord.frienduin, paramMessageRecord.istroop);
      int j;
      int i;
      if (paramQQAppInterface == null)
      {
        j = 0;
        if (j <= 15) {
          break label275;
        }
        i = j - 15;
      }
      for (;;)
      {
        if (i >= j) {
          break label287;
        }
        MessageRecord localMessageRecord = (MessageRecord)paramQQAppInterface.get(i);
        if ((localMessageRecord != null) && (localMessageRecord.msgtype == paramMessageRecord.msgtype) && (aqft.equalsWithNullCheck(localMessageRecord.msg, paramMessageRecord.msg)))
        {
          if ((QLog.isColorLevel()) && (localStringBuilder != null))
          {
            localStringBuilder.append(" filterType: other");
            QLog.w("Q.msg.MessageHandlerUtils", 2, localStringBuilder.toString());
          }
          MsgAutoMonitorUtil.getInstance().addMsgFilterTime(System.currentTimeMillis() - l);
          return true;
          j = paramQQAppInterface.size();
          break;
          label275:
          i = 0;
          continue;
        }
        i += 1;
      }
      label287:
      if ((QLog.isColorLevel()) && (localStringBuilder != null)) {
        QLog.d("Q.msg.MessageHandlerUtils", 2, localStringBuilder.toString());
      }
      MsgAutoMonitorUtil.getInstance().addMsgFilterTime(System.currentTimeMillis() - l);
      return false;
      localStringBuilder = null;
    }
  }
  
  public static void iZ(List<MessageRecord> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 1)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramList.size())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.get(i);
      if (anbk.aW(localMessageRecord)) {
        if (((i <= 0) || (((MessageRecord)paramList.get(i - 1)).shmsgseq != localMessageRecord.shmsgseq)) && ((i >= paramList.size() - 1) || (((MessageRecord)paramList.get(i + 1)).shmsgseq != localMessageRecord.shmsgseq))) {
          break label141;
        }
      }
      label141:
      for (int j = 1;; j = 0)
      {
        if (j != 0) {
          localArrayList.add(localMessageRecord);
        }
        i += 1;
        break;
      }
    }
    paramList.removeAll(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     achp
 * JD-Core Version:    0.7.0.1
 */