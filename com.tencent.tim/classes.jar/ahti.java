import PushNotifyPack.C2CMsgReadedNotify;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.message.TinyInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.C2CTmpMsgHead;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.UinPairMsg;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq.UinPairReadInfo;
import msf.msgsvc.msg_svc.PbMsgReadedReportReq;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype34;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype34.GameSession;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;

public class ahti
{
  public static long a(long paramLong, msg_comm.UinPairMsg paramUinPairMsg, QQAppInterface paramQQAppInterface)
  {
    if (paramUinPairMsg != null) {
      try
      {
        if ((paramUinPairMsg.service_type.has()) && (paramUinPairMsg.service_type.get() == 164))
        {
          if (paramUinPairMsg.uint64_to_tiny_id.has())
          {
            paramUinPairMsg = String.valueOf(paramUinPairMsg.uint64_to_tiny_id.get());
            if (QLog.isColorLevel()) {
              QLog.d("Q.tiny_msg.decoder.TinyMsgCodec", 2, "convertTinyToUin is called, fromTinyId: " + paramLong + "toTinyId :" + paramUinPairMsg);
            }
            return Long.parseLong(paramQQAppInterface.a().bb(String.valueOf(paramLong), paramUinPairMsg));
          }
          if (QLog.isColorLevel())
          {
            QLog.d("Q.tiny_msg.decoder.TinyMsgCodec", 2, "convertTinyToUin is called, but toTinyId is not contained.");
            return paramLong;
          }
        }
      }
      catch (Exception paramUinPairMsg)
      {
        QLog.d("Q.tiny_msg.decoder.TinyMsgCodec", 1, "convertTinyToUin is called", paramUinPairMsg);
      }
    }
    return paramLong;
  }
  
  public static String a(msg_comm.UinPairMsg paramUinPairMsg, QQAppInterface paramQQAppInterface, int paramInt)
  {
    long l = paramUinPairMsg.peer_uin.get();
    if ((paramInt == 10007) && (paramQQAppInterface != null)) {
      return String.valueOf(a(l, paramUinPairMsg, paramQQAppInterface));
    }
    return String.valueOf(l);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, String paramString, int paramInt)
  {
    if ((paramQQAppInterface == null) || (paramChatMessage == null)) {
      return;
    }
    for (;;)
    {
      try
      {
        paramQQAppInterface = paramQQAppInterface.a(paramInt).a(paramString, paramInt);
        if (paramQQAppInterface == null) {
          break;
        }
        paramString = paramQQAppInterface.getExtInfoFromExtStr("ext_key_game_msg_info");
        boolean bool2 = paramQQAppInterface.isSend();
        if (!bool2)
        {
          bool1 = true;
          paramQQAppInterface = new TinyInfo(paramString, bool1);
          paramChatMessage.saveExtInfoToExtStr("ext_key_game_msg_info", paramQQAppInterface.toJsonStr());
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.tiny_msg.decoder.TinyMsgCodec", 2, "bindTinyInfo is called, issend: " + bool2 + "tinyInfo :" + paramQQAppInterface);
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        return;
      }
      boolean bool1 = false;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, C2CMsgReadedNotify paramC2CMsgReadedNotify)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.tiny_msg.decoder.TinyMsgCodec", 2, "handlePushReadNotify is called peerUin = " + paramString + ", cr.uint64_to_tiny_id = " + paramC2CMsgReadedNotify.uint64_to_tiny_id);
      }
      paramString = paramQQAppInterface.a().bb(paramString, String.valueOf(paramC2CMsgReadedNotify.uint64_to_tiny_id));
      paramQQAppInterface.b().s(paramString, 10007, paramC2CMsgReadedNotify.lLastReadTime);
      if (paramC2CMsgReadedNotify.lLastReadTime >= 0L) {
        paramQQAppInterface.b().a.ea(paramString, 10007);
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("Q.tiny_msg.decoder.TinyMsgCodec", 1, "handlePushReadNotify error", paramQQAppInterface);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, msg_svc.PbC2CReadedReportReq paramPbC2CReadedReportReq, long paramLong, ConversationInfo paramConversationInfo)
  {
    if ((paramLong == 0L) || (paramConversationInfo == null) || (paramQQAppInterface == null)) {}
    long l1;
    long l2;
    do
    {
      for (;;)
      {
        return;
        paramConversationInfo = paramQQAppInterface.a().c(paramConversationInfo.uin);
        try
        {
          l1 = Long.valueOf((String)paramConversationInfo.first).longValue();
          l2 = Long.valueOf((String)paramConversationInfo.second).longValue();
          if (QLog.isColorLevel()) {
            QLog.d("Q.tiny_msg.decoder.TinyMsgCodecsendReadConfirm_PB", 2, "createMsgReadConfirm is called");
          }
          if (paramQQAppInterface.getCurrentAccountUin() != null) {
            if ((l1 == 0L) || (l2 == 0L))
            {
              QLog.e("Q.tiny_msg.decoder.TinyMsgCodecsendReadConfirm_PB", 1, "peeruin & toTinyid exception!");
              return;
            }
          }
        }
        catch (NumberFormatException paramQQAppInterface)
        {
          QLog.e("Q.tiny_msg.decoder.TinyMsgCodecsendReadConfirm_PB", 1, paramQQAppInterface, new Object[0]);
          return;
        }
      }
      paramQQAppInterface = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
      paramQQAppInterface.peer_uin.set(l1);
      paramQQAppInterface.last_read_time.set((int)paramLong);
      paramQQAppInterface.aio_type.set(3);
      paramQQAppInterface.uint64_to_tiny_id.set(l2);
      paramPbC2CReadedReportReq.pair_info.add(paramQQAppInterface);
    } while (!QLog.isColorLevel());
    QLog.d("Q.tiny_msg.decoder.TinyMsgCodecsendReadConfirm_PB", 2, "msgReadedReportUin : " + l1 + ", toIinyId = " + l2);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, msg_svc.PbMsgReadedReportReq paramPbMsgReadedReportReq, String paramString, long paramLong)
  {
    if ((paramLong == 0L) || (paramQQAppInterface == null)) {}
    long l1;
    long l2;
    do
    {
      for (;;)
      {
        return;
        localObject = paramQQAppInterface.a().c(paramString);
        try
        {
          l1 = Long.valueOf((String)((Pair)localObject).first).longValue();
          l2 = Long.valueOf((String)((Pair)localObject).second).longValue();
          if (QLog.isColorLevel()) {
            QLog.d("Q.tiny_msg.decoder.TinyMsgCodecsendReadConfirm_PB", 2, "createMsgReadConfirm is called curFriendUin = " + paramString);
          }
          if (paramQQAppInterface.getCurrentAccountUin() != null) {
            if ((l1 == 0L) || (l2 == 0L))
            {
              QLog.e("Q.tiny_msg.decoder.TinyMsgCodecsendReadConfirm_PB", 1, "peeruin & toTinyid exception!");
              return;
            }
          }
        }
        catch (NumberFormatException paramQQAppInterface)
        {
          QLog.e("Q.tiny_msg.decoder.TinyMsgCodecsendReadConfirm_PB", 1, paramQQAppInterface, new Object[0]);
          return;
        }
      }
      Object localObject = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
      ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject).peer_uin.set(l1);
      ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject).last_read_time.set((int)paramLong);
      ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject).aio_type.set(3);
      ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject).uint64_to_tiny_id.set(l2);
      paramString = new msg_svc.PbC2CReadedReportReq();
      paramString.pair_info.add((MessageMicro)localObject);
      paramQQAppInterface = paramQQAppInterface.a().a().am();
      if (paramQQAppInterface != null) {
        paramString.sync_cookie.set(ByteStringMicro.copyFrom(paramQQAppInterface));
      }
      paramQQAppInterface = paramPbMsgReadedReportReq;
      if (paramPbMsgReadedReportReq == null) {
        paramQQAppInterface = new msg_svc.PbMsgReadedReportReq();
      }
      paramQQAppInterface.c2c_read_report.set(paramString);
    } while (!QLog.isColorLevel());
    QLog.d("Q.tiny_msg.decoder.TinyMsgCodecsendReadConfirm_PB", 2, "msgReadedReportUin : " + l1 + ", toIinyId = " + l2);
  }
  
  private static void a(msg_comm.Msg paramMsg, QQAppInterface paramQQAppInterface, anax paramanax, String paramString1, String paramString2)
  {
    if (paramMsg.msg_head.has())
    {
      paramMsg = (msg_comm.C2CTmpMsgHead)((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_tmp_msg_head.get();
      if ((!paramanax.cEE) && (paramMsg.sig.has()))
      {
        paramMsg = paramMsg.sig.get().toByteArray();
        paramQQAppInterface.a().i(paramString1, paramString2, paramMsg);
        if (QLog.isDevelopLevel()) {
          QLog.d("Q.tiny_msg.decoder.TinyMsgCodec", 4, "saveTokenSig tempHead.sig.get()----> sig:" + aqhs.bytes2HexStr(paramMsg) + ",length:" + paramMsg.length);
        }
      }
    }
  }
  
  public static void a(msg_comm.Msg paramMsg, im_msg_body.Elem paramElem, List<MessageRecord> paramList, QQAppInterface paramQQAppInterface, anax paramanax)
  {
    if ((paramElem == null) || (paramList == null) || (paramQQAppInterface == null) || (paramList.size() <= 0)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.tiny_msg.decoder.TinyMsgCodec", 2, "decodePBMsgElems_GameInterComm");
    }
    String str4 = paramQQAppInterface.getCurrentAccountUin();
    for (;;)
    {
      try
      {
        if ((34 != paramElem.common_elem.uint32_service_type.get()) || (paramElem.common_elem.uint32_business_type.get() != 1) || (!paramElem.common_elem.bytes_pb_elem.has())) {
          break;
        }
        localObject1 = new hummer_commelem.MsgElemInfo_servtype34();
        ((hummer_commelem.MsgElemInfo_servtype34)localObject1).mergeFrom(paramElem.common_elem.bytes_pb_elem.get().toByteArray());
        if (((hummer_commelem.MsgElemInfo_servtype34)localObject1).from_nickname.has())
        {
          paramElem = ((hummer_commelem.MsgElemInfo_servtype34)localObject1).from_nickname.get().toStringUtf8();
          if (!((hummer_commelem.MsgElemInfo_servtype34)localObject1).push_window_flag.has()) {
            break label645;
          }
          i = ((hummer_commelem.MsgElemInfo_servtype34)localObject1).push_window_flag.get();
          if (!((hummer_commelem.MsgElemInfo_servtype34)localObject1).game_session.has()) {
            break label651;
          }
          localObject2 = (hummer_commelem.MsgElemInfo_servtype34.GameSession)((hummer_commelem.MsgElemInfo_servtype34)localObject1).game_session.get();
          if (localObject2 == null) {
            break label635;
          }
          if (!((hummer_commelem.MsgElemInfo_servtype34.GameSession)localObject2).from_role_id.has()) {
            break label657;
          }
          localObject1 = ((hummer_commelem.MsgElemInfo_servtype34.GameSession)localObject2).from_role_id.get().toStringUtf8();
          if (!((hummer_commelem.MsgElemInfo_servtype34.GameSession)localObject2).from_open_id.has()) {
            break label665;
          }
          str1 = ((hummer_commelem.MsgElemInfo_servtype34.GameSession)localObject2).from_open_id.get().toStringUtf8();
          if (!((hummer_commelem.MsgElemInfo_servtype34.GameSession)localObject2).to_role_id.has()) {
            break label673;
          }
          str2 = ((hummer_commelem.MsgElemInfo_servtype34.GameSession)localObject2).to_role_id.get().toStringUtf8();
          if (!((hummer_commelem.MsgElemInfo_servtype34.GameSession)localObject2).to_open_id.has()) {
            break label681;
          }
          str3 = ((hummer_commelem.MsgElemInfo_servtype34.GameSession)localObject2).to_open_id.get().toStringUtf8();
          if (!((hummer_commelem.MsgElemInfo_servtype34.GameSession)localObject2).game_appid.has()) {
            break label689;
          }
          l1 = ((hummer_commelem.MsgElemInfo_servtype34.GameSession)localObject2).game_appid.get();
          if (!((hummer_commelem.MsgElemInfo_servtype34.GameSession)localObject2).from_tiny_id.has()) {
            break label695;
          }
          l2 = ((hummer_commelem.MsgElemInfo_servtype34.GameSession)localObject2).from_tiny_id.get();
          if (!((hummer_commelem.MsgElemInfo_servtype34.GameSession)localObject2).to_tiny_id.has()) {
            break label701;
          }
          l3 = ((hummer_commelem.MsgElemInfo_servtype34.GameSession)localObject2).to_tiny_id.get();
          paramList = paramList.iterator();
          if (!paramList.hasNext()) {
            break label600;
          }
          localObject2 = (MessageRecord)paramList.next();
          String str5 = TinyInfo.toJsonStr((String)localObject1, str1, str2, str3, l1, l2, l3, i, paramElem);
          af(paramQQAppInterface, (String)localObject1);
          ((MessageRecord)localObject2).saveExtInfoToExtStr("ext_key_game_msg_info", str5);
          if (paramanax.cEI) {
            continue;
          }
          ((MessageRecord)localObject2).frienduin = paramQQAppInterface.a().bb(String.valueOf(l3), String.valueOf(l2));
          a(paramMsg, paramQQAppInterface, paramanax, ((MessageRecord)localObject2).frienduin, str4);
          paramanax.friendUin = Long.parseLong(((MessageRecord)localObject2).frienduin);
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.tiny_msg.decoder.TinyMsgCodecdecodePBMsgGameInterCommElem", 2, "toTinyId = " + l3 + ", fromTinyId = " + l2 + ", ctx.senderUin = " + paramanax.senderUin + ", ctx.friendUin = " + paramanax.friendUin + ", mr = " + ((MessageRecord)localObject2).getBaseInfoString());
          continue;
        }
      }
      catch (InvalidProtocolBufferMicroException paramMsg)
      {
        QLog.e("Q.tiny_msg.decoder.TinyMsgCodec", 1, "decodePBMsgGameInterCommElem error", paramMsg);
        return;
        paramElem = "";
        continue;
        paramanax.senderUin = paramanax.friendUin;
        continue;
      }
      catch (Exception paramMsg)
      {
        QLog.e("Q.tiny_msg.decoder.TinyMsgCodec", 1, "decodePBMsgGameInterCommElem error", paramMsg);
        return;
      }
      label600:
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.tiny_msg.decoder.TinyMsgCodec", 2, String.format("decodePBMsgGameInterCommElem fromNickName:%s windowFlag:%d", new Object[] { paramElem, Integer.valueOf(i) }));
      return;
      label635:
      QLog.d("Q.tiny_msg.decoder.TinyMsgCodec", 1, "decodePBMsgGameInterCommElem error gameSession is null!");
      return;
      label645:
      int i = 0;
      continue;
      label651:
      Object localObject2 = null;
      continue;
      label657:
      Object localObject1 = "";
      continue;
      label665:
      String str1 = "";
      continue;
      label673:
      String str2 = "";
      continue;
      label681:
      String str3 = "";
      continue;
      label689:
      long l1 = 0L;
      continue;
      label695:
      long l2 = 0L;
      continue;
      label701:
      long l3 = 0L;
    }
  }
  
  public static boolean aA(MessageRecord paramMessageRecord)
  {
    TinyInfo localTinyInfo;
    if (paramMessageRecord.istroop == 10007)
    {
      paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("ext_key_game_msg_info");
      if (!TextUtils.isEmpty(paramMessageRecord))
      {
        localTinyInfo = new TinyInfo();
        localTinyInfo.parseFromJson(paramMessageRecord);
        if (QLog.isColorLevel()) {
          QLog.d("Q.tiny_msg.decoder.TinyMsgCodec", 2, "isNeedTips windowflag = " + localTinyInfo.windowFlag);
        }
      }
    }
    return (localTinyInfo.windowFlag & 1L) == 1L;
  }
  
  private static void af(QQAppInterface paramQQAppInterface, String paramString)
  {
    ((ahta)paramQQAppInterface.getManager(358)).a(paramString);
  }
  
  public static void b(im_msg_body.Elem paramElem, MessageRecord paramMessageRecord)
  {
    Object localObject = paramMessageRecord.getExtInfoFromExtStr("ext_key_game_msg_info");
    paramMessageRecord = new TinyInfo();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramMessageRecord.parseFromJson((String)localObject);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.tiny_msg.decoder.TinyMsgCodecbindTinyInfoElem", 2, "bindTinyInfoElem is called, info: " + paramMessageRecord);
    }
    localObject = new hummer_commelem.MsgElemInfo_servtype34();
    hummer_commelem.MsgElemInfo_servtype34.GameSession localGameSession = new hummer_commelem.MsgElemInfo_servtype34.GameSession();
    if ((TextUtils.isEmpty(paramMessageRecord.fromRoleId)) || (TextUtils.isEmpty(paramMessageRecord.toRoleId))) {
      return;
    }
    localGameSession.from_open_id.set(ByteStringMicro.copyFromUtf8(paramMessageRecord.fromOpenId));
    localGameSession.from_role_id.set(ByteStringMicro.copyFromUtf8(paramMessageRecord.fromRoleId));
    localGameSession.to_role_id.set(ByteStringMicro.copyFromUtf8(paramMessageRecord.toRoleId));
    localGameSession.to_open_id.set(ByteStringMicro.copyFromUtf8(paramMessageRecord.toOpenId));
    localGameSession.game_appid.set(paramMessageRecord.gameAppId);
    localGameSession.from_tiny_id.set(paramMessageRecord.fromTinyId);
    localGameSession.to_tiny_id.set(paramMessageRecord.toTinyId);
    ((hummer_commelem.MsgElemInfo_servtype34)localObject).game_session.set(localGameSession);
    paramMessageRecord = new im_msg_body.CommonElem();
    paramMessageRecord.uint32_service_type.set(34);
    paramMessageRecord.uint32_business_type.set(1);
    paramMessageRecord.bytes_pb_elem.set(ByteStringMicro.copyFrom(((hummer_commelem.MsgElemInfo_servtype34)localObject).toByteArray()));
    paramElem.common_elem.set(paramMessageRecord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahti
 * JD-Core Version:    0.7.0.1
 */