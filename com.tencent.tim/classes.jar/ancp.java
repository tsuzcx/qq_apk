import OnlinePushPack.MsgInfo;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.MsgBoxInterFollowManager;
import com.tencent.mobileqq.data.PushRecommend;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.now.enter.pb.NowPushMsgList.MsgBody;
import com.tencent.mobileqq.now.enter.pb.NowPushMsgList.NowPushMsg;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.revokemsg.RevokeMsgInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.MsgType0x210;
import org.jetbrains.annotations.Nullable;
import tencent.im.apollo_push_msgInfo.STPushMsgElem;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msgrevoke.msgrevoke_userdef.UinTypeUserDef;
import tencent.im.msgsync.cmd0x100.Submsgtype0x8a.MsgInfo;
import tencent.im.msgsync.cmd0x100.Submsgtype0x8a.ReqBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x104.submsgtype0x104.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x119.SubMsgType0x119.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x87.SubMsgType0x87.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x9b.SubMsgType0x9b.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xaa.SubMsgType0xaa.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xae.SubMsgType0xae.AddFriendSource;
import tencent.im.s2c.msgtype0x210.submsgtype0xae.SubMsgType0xae.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xae.SubMsgType0xae.PersonMayKnow;
import tencent.im.s2c.msgtype0x210.submsgtype0xae.SubMsgType0xae.PushPeopleMayKnowV2;
import tencent.im.s2c.msgtype0x210.submsgtype0xcb.SubMsgType0xcb.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xe8.submsgtype0xe8.MsgBody;

public class ancp
  implements anbs
{
  private tpb<Integer, ancz> c = new tpc();
  
  public ancp()
  {
    onCreate();
  }
  
  private MessageRecord a(MessageHandler paramMessageHandler, byte[] paramArrayOfByte, msg_comm.Msg paramMsg)
  {
    SubMsgType0xcb.MsgBody localMsgBody = new SubMsgType0xcb.MsgBody();
    for (;;)
    {
      try
      {
        localMsgBody.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = (MessageForNearbyLiveTip)anbi.d(-2053);
        if (localMsgBody.uint32_anchor_status.get() == 1)
        {
          bool = true;
          paramArrayOfByte.isLiving = bool;
          paramArrayOfByte.jumpingUrl = localMsgBody.bytes_jump_schema.get().toStringUtf8();
          paramArrayOfByte.msg = localMsgBody.bytes_live_wording.get().toStringUtf8();
          paramArrayOfByte.headUrl = localMsgBody.bytes_anchor_head_url.get().toStringUtf8();
          paramArrayOfByte.nickName = localMsgBody.bytes_anchor_nickname.get().toStringUtf8();
          paramArrayOfByte.liveEndWording = localMsgBody.bytes_live_end_wording.get().toStringUtf8();
          paramArrayOfByte.c2cMsgWording = localMsgBody.bytes_c2c_msg_wording.get().toStringUtf8();
          paramArrayOfByte.startLiveWordingType = localMsgBody.uint32_live_wording_type.get();
          paramArrayOfByte.endLiveWordingType = localMsgBody.uint32_end_wording_type.get();
          long l1 = paramMsg.msg_head.from_uin.get();
          int i = paramMsg.msg_head.msg_seq.get();
          long l2 = paramMsg.msg_head.msg_uid.get();
          int j = paramMsg.msg_head.msg_type.get();
          paramArrayOfByte.time = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
          paramArrayOfByte.msgseq = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
          paramArrayOfByte.shmsgseq = i;
          paramArrayOfByte.msgUid = l2;
          paramArrayOfByte.selfuin = paramMessageHandler.app.getCurrentAccountUin();
          paramArrayOfByte.istroop = 1001;
          paramArrayOfByte.senderuin = String.valueOf(acbn.Pd + l1);
          paramArrayOfByte.frienduin = String.valueOf(acbn.Pd + l1);
          paramArrayOfByte.getBytes();
          anbh.a(paramMessageHandler, l1, i, l2, j);
          if (QLog.isColorLevel())
          {
            paramMessageHandler = new StringBuilder();
            paramMessageHandler.append("status=").append(paramArrayOfByte.isLiving).append("jumpingUrl=").append(paramArrayOfByte.jumpingUrl).append("liveWording=").append(paramArrayOfByte.msg).append("headUrl").append(paramArrayOfByte.headUrl).append("nickName").append(paramArrayOfByte.nickName).append("startLiveWordingType=").append(localMsgBody.uint32_live_wording_type.get()).append("endLiveWordingType=").append(localMsgBody.uint32_end_wording_type.get());
            QLog.i("MsgType0x210Decoder", 2, paramMessageHandler.toString());
          }
          anot.a(null, "dc00899", "grp_lbs", "", "msg_box", "view_live_message", 0, 0, "", "", "", "");
          return paramArrayOfByte;
        }
      }
      catch (InvalidProtocolBufferMicroException paramMessageHandler)
      {
        if (QLog.isColorLevel()) {
          QLog.i("MsgType0x210Decoder", 2, "decodeNearbyLiveTipMsg decode failed" + paramMessageHandler.toString());
        }
        return null;
      }
      boolean bool = false;
    }
  }
  
  @Nullable
  static msg_comm.MsgType0x210 a(msg_comm.Msg paramMsg)
  {
    Object localObject = new msg_comm.MsgType0x210();
    try
    {
      paramMsg = (msg_comm.MsgType0x210)((msg_comm.MsgType0x210)localObject).mergeFrom(((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray());
      if (paramMsg == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MsgType0x210Decoder", 2, "<---decodeC2CMsgPkg_MsgType0x210 : msgType0x210 is null.");
        }
        localObject = null;
        return localObject;
      }
    }
    catch (Exception paramMsg)
    {
      do
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("MsgType0x210Decoder", 2, "<---decodeC2CMsgPkg_MsgType0x210 : failed.", paramMsg);
          }
          paramMsg = null;
        }
        if (!paramMsg.sub_msg_type.has()) {
          break;
        }
        localObject = paramMsg;
      } while (paramMsg.msg_content.has());
      if (QLog.isColorLevel()) {
        QLog.e("MsgType0x210Decoder", 2, "<---decodeC2CMsgPkg_MsgType0x210 : msgType0x210 require more info: hasType:" + paramMsg.sub_msg_type.has() + ",hasMsgContent:" + paramMsg.msg_content.has());
      }
    }
    return null;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Submsgtype0x8a.ReqBody paramReqBody, long paramLong, boolean paramBoolean)
  {
    int i = 0;
    long l = 0L;
    Object localObject1 = (ArrayList)paramReqBody.msg_info.get();
    Object localObject2 = new msgrevoke_userdef.UinTypeUserDef();
    Object localObject3;
    boolean bool;
    try
    {
      ((msgrevoke_userdef.UinTypeUserDef)localObject2).mergeFrom(paramReqBody.bytes_reserved.get().toByteArray());
      int j = ((msgrevoke_userdef.UinTypeUserDef)localObject2).uint32_from_uin_type.get();
      if (j == 1)
      {
        i = 1000;
        l = ((msgrevoke_userdef.UinTypeUserDef)localObject2).uint64_from_group_code.get();
      }
      for (;;)
      {
        localObject2 = new ArrayList();
        paramReqBody = ((ArrayList)localObject1).iterator();
        for (;;)
        {
          if (!paramReqBody.hasNext()) {
            break label367;
          }
          localObject1 = (Submsgtype0x8a.MsgInfo)paramReqBody.next();
          localObject3 = new RevokeMsgInfo();
          ((RevokeMsgInfo)localObject3).istroop = i;
          ((RevokeMsgInfo)localObject3).bYD = String.valueOf(((Submsgtype0x8a.MsgInfo)localObject1).uint64_from_uin.get());
          ((RevokeMsgInfo)localObject3).frienduin = String.valueOf(((Submsgtype0x8a.MsgInfo)localObject1).uint64_to_uin.get());
          ((RevokeMsgInfo)localObject3).bYF = String.valueOf(l);
          ((RevokeMsgInfo)localObject3).shmsgseq = ((short)((Submsgtype0x8a.MsgInfo)localObject1).uint32_msg_seq.get());
          ((RevokeMsgInfo)localObject3).msguid = ((Submsgtype0x8a.MsgInfo)localObject1).uint64_msg_uid.get();
          ((RevokeMsgInfo)localObject3).time = ((Submsgtype0x8a.MsgInfo)localObject1).uint64_msg_time.get();
          ((RevokeMsgInfo)localObject3).dyi = ((Submsgtype0x8a.MsgInfo)localObject1).uint32_div_seq.get();
          ((RevokeMsgInfo)localObject3).dyj = ((Submsgtype0x8a.MsgInfo)localObject1).uint32_pkg_num.get();
          ((RevokeMsgInfo)localObject3).dyk = ((Submsgtype0x8a.MsgInfo)localObject1).uint32_pkg_index.get();
          if ((((Submsgtype0x8a.MsgInfo)localObject1).uint32_flag.get() & 0x8) != 0) {
            break;
          }
          bool = true;
          ((RevokeMsgInfo)localObject3).czE = bool;
          ((ArrayList)localObject2).add(localObject3);
          if (QLog.isColorLevel()) {
            QLog.d("revokeMsg", 2, "recv 0x210_0x8a_8b msg," + ((RevokeMsgInfo)localObject3).toString());
          }
        }
        if (j == 2)
        {
          i = 1004;
          l = ((msgrevoke_userdef.UinTypeUserDef)localObject2).uint64_from_group_code.get();
        }
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.d("revokeMsg", 2, "recv 0x210_0x8a_8b msg, prase uintypeUserdef error");
      }
    }
    label814:
    for (;;)
    {
      bool = false;
      break;
      label367:
      if (!paramBoolean)
      {
        paramQQAppInterface.b().v((ArrayList)localObject2, false);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("revokeMsg", 2, "recv 0x210_0x8a_8b subaccount msg");
      }
      if (!((ArrayList)localObject2).isEmpty())
      {
        String str1 = Long.toString(paramLong);
        String str2 = paramQQAppInterface.getCurrentAccountUin();
        anxr localanxr = (anxr)paramQQAppInterface.getManager(61);
        if (localanxr != null)
        {
          List localList = localanxr.aQ(str1);
          paramReqBody = null;
          localObject1 = null;
          Iterator localIterator1 = ((ArrayList)localObject2).iterator();
          if (localIterator1.hasNext())
          {
            localObject2 = (RevokeMsgInfo)localIterator1.next();
            Iterator localIterator2 = localList.iterator();
            while (localIterator2.hasNext())
            {
              localObject3 = (SubAccountMessage)localIterator2.next();
              if ((((RevokeMsgInfo)localObject2).shmsgseq == ((SubAccountMessage)localObject3).shmsgseq) && (((RevokeMsgInfo)localObject2).msguid == ((SubAccountMessage)localObject3).msgUid))
              {
                localObject1 = localObject3;
                paramReqBody = (Submsgtype0x8a.ReqBody)localObject2;
              }
            }
          }
          for (;;)
          {
            break;
            if (paramReqBody == null) {
              break label814;
            }
            localObject2 = acfp.m(2131708232);
            localObject3 = (SubAccountMessage)((SubAccountMessage)localObject1).deepCopyByReflect();
            ((SubAccountMessage)localObject3).msg = ((String)localObject2).concat(BaseApplicationImpl.getApplication().getString(2131696088));
            ((SubAccountMessage)localObject3).unreadNum = Math.max(0, ((SubAccountMessage)localObject1).unreadNum - 1);
            ((SubAccountMessage)localObject3).time = paramReqBody.time;
            ((SubAccountMessage)localObject3).needNotify = paramQQAppInterface.isBackground_Pause;
            ((SubAccountMessage)localObject3).mTimeString = aqmu.a(((SubAccountMessage)localObject3).time * 1000L, true, anxk.ciB);
            ((SubAccountMessage)localObject3).mEmoRecentMsg = new aofk(((SubAccountMessage)localObject3).msg, 0);
            if (localanxr != null) {
              localanxr.b((SubAccountMessage)localObject3);
            }
            anxk.G(paramQQAppInterface, str1, 6);
            paramReqBody = ((SubAccountMessage)localObject3).convertToMessageRecord();
            paramReqBody.istroop = 7000;
            paramReqBody.frienduin = str1;
            paramQQAppInterface.a().G(paramReqBody.frienduin, paramReqBody.istroop, -1);
            if (localanxr != null) {
              localanxr.Rz(str1);
            }
            localObject1 = new ArrayList();
            ((ArrayList)localObject1).add(paramReqBody);
            paramQQAppInterface.b().a((ArrayList)localObject1, str2, false, false, true);
            paramQQAppInterface.cLO();
            paramReqBody = new anxs();
            paramReqBody.aLa = str2;
            paramReqBody.aQf = str1;
            paramReqBody.cKB = true;
            paramReqBody.cKC = true;
            paramReqBody.errorType = 0;
            paramQQAppInterface.a().a().b(8003, true, paramReqBody);
            return;
          }
        }
      }
    }
  }
  
  public void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, anax paramanax)
  {
    if (paramanax.cEE) {
      break label8;
    }
    label8:
    Object localObject1;
    int i;
    do
    {
      do
      {
        do
        {
          long l1;
          long l2;
          int j;
          do
          {
            for (;;)
            {
              return;
              if ((paramMsg.msg_body.has()) && (((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has()))
              {
                bool = paramanax.cEE;
                localObject1 = a(paramMsg);
                if (localObject1 == null) {
                  break;
                }
                i = ((msg_comm.MsgType0x210)localObject1).sub_msg_type.get();
                if (QLog.isColorLevel()) {
                  QLog.d("MsgType0x210Decoder", 2, "<---decodeC2CMsgPkg_MsgType0x210 : msgType0x210 type:" + i);
                }
                Object localObject2 = (ancz)this.c.get(Integer.valueOf(i));
                if (localObject2 != null)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("MsgType0x210Decoder", 2, "subType=" + i + ", decoder=" + localObject2);
                  }
                  ((ancz)localObject2).a((msg_comm.MsgType0x210)localObject1, paramMsg, paramList, paramanax, paramMessageHandler);
                }
                switch (i)
                {
                default: 
                  return;
                case 135: 
                case 141: 
                  try
                  {
                    paramList = new SubMsgType0x87.MsgBody();
                    paramList.mergeFrom(((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray());
                    if (paramList.rpt_msg_msg_notify.has()) {
                      yrv.a(paramMessageHandler.app, paramList);
                    }
                    anbh.a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
                    return;
                  }
                  catch (Exception paramList)
                  {
                    for (;;)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.e("MsgType0x210Decoder", 2, "offline push parse 0x210 subtype 0x87 msg error", paramList);
                      }
                    }
                  }
                case 138: 
                case 139: 
                  if (!bool)
                  {
                    paramMsg = new Submsgtype0x8a.ReqBody();
                    try
                    {
                      paramMsg.mergeFrom(((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray());
                      a(paramMessageHandler.app, paramMsg, 0L, false);
                      return;
                    }
                    catch (Exception paramMessageHandler) {}
                    if (QLog.isColorLevel())
                    {
                      QLog.d("revokeMsg", 2, "recv 0x210_0x8a_8b offline msg, prase reqBody error");
                      return;
                    }
                  }
                  break;
                case 155: 
                  paramList = new SubMsgType0x9b.MsgBody();
                  try
                  {
                    paramList.mergeFrom(((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray());
                    anbh.a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
                    return;
                  }
                  catch (InvalidProtocolBufferMicroException paramMessageHandler)
                  {
                    paramMessageHandler.printStackTrace();
                    return;
                  }
                case 170: 
                  if (QLog.isColorLevel()) {
                    QLog.d("MsgType0x210Decoder", 2, "handleMsgType0x210SubMsgType0xaa receive 0xaa push message");
                  }
                  paramList = new SubMsgType0xaa.MsgBody();
                  try
                  {
                    paramList.mergeFrom(((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray());
                    ((ahvn)paramMessageHandler.app.getManager(156)).a(paramList, true);
                    anbh.a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
                    return;
                  }
                  catch (Exception paramanax)
                  {
                    for (;;)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("MsgType0x210Decoder", 2, "handleMsgType0x210SubMsgType0xaa, prase msgBody error");
                      }
                    }
                  }
                case 174: 
                  if (QLog.isColorLevel()) {
                    QLog.d("MsgType0x210Decoder", 2, "handleMsgType0x210SubMsgType0xae receive 0xae push message");
                  }
                  paramList = new SubMsgType0xae.MsgBody();
                  try
                  {
                    paramList.mergeFrom(((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray());
                    if ((paramList.uint32_type.has()) && (paramList.uint32_type.get() == 2))
                    {
                      l1 = paramList.msg_persons_may_know.fixed32_timestamp.get();
                      if (QLog.isColorLevel()) {
                        QLog.d("MsgType0x210Decoder", 2, "handlePushRecommend receive push time=" + l1);
                      }
                      paramanax = paramList.msg_persons_may_know.rpt_msg_friend_list.get();
                      if ((paramanax != null) && (paramanax.size() > 0))
                      {
                        paramList = new ArrayList(paramanax.size());
                        paramanax = paramanax.iterator();
                        while (paramanax.hasNext())
                        {
                          localObject1 = (SubMsgType0xae.PersonMayKnow)paramanax.next();
                          localObject2 = new PushRecommend();
                          if (((SubMsgType0xae.PersonMayKnow)localObject1).uint64_uin.has()) {
                            ((PushRecommend)localObject2).uin = Long.toString(((SubMsgType0xae.PersonMayKnow)localObject1).uint64_uin.get());
                          }
                          if (((SubMsgType0xae.PersonMayKnow)localObject1).bytes_name.has()) {
                            ((PushRecommend)localObject2).nick = new String(((SubMsgType0xae.PersonMayKnow)localObject1).bytes_name.get().toByteArray());
                          }
                          if (((SubMsgType0xae.PersonMayKnow)localObject1).uint32_age.has()) {
                            ((PushRecommend)localObject2).age = ((short)((SubMsgType0xae.PersonMayKnow)localObject1).uint32_age.get());
                          }
                          if (((SubMsgType0xae.PersonMayKnow)localObject1).uint32_sex.has()) {
                            ((PushRecommend)localObject2).gender = ((short)((SubMsgType0xae.PersonMayKnow)localObject1).uint32_sex.get());
                          }
                          if (((SubMsgType0xae.PersonMayKnow)localObject1).bytes_main_reason.has()) {
                            ((PushRecommend)localObject2).recommendReason = new String(((SubMsgType0xae.PersonMayKnow)localObject1).bytes_main_reason.get().toByteArray());
                          }
                          if (((SubMsgType0xae.PersonMayKnow)localObject1).bytes_alghrithm.has()) {
                            ((PushRecommend)localObject2).algBuffer = ((SubMsgType0xae.PersonMayKnow)localObject1).bytes_alghrithm.get().toByteArray();
                          }
                          if (((SubMsgType0xae.PersonMayKnow)localObject1).bytes_soure_reason.has()) {
                            ((PushRecommend)localObject2).sourceReason = new String(((SubMsgType0xae.PersonMayKnow)localObject1).bytes_soure_reason.get().toByteArray());
                          }
                          if (((SubMsgType0xae.PersonMayKnow)localObject1).uint32_source.has()) {
                            ((PushRecommend)localObject2).fromSource = ((SubMsgType0xae.PersonMayKnow)localObject1).uint32_source.get();
                          }
                          if (((SubMsgType0xae.PersonMayKnow)localObject1).msg_android_source.has())
                          {
                            SubMsgType0xae.AddFriendSource localAddFriendSource = (SubMsgType0xae.AddFriendSource)((SubMsgType0xae.PersonMayKnow)localObject1).msg_android_source.get();
                            if (localAddFriendSource != null)
                            {
                              if (localAddFriendSource.uint32_source.has()) {
                                ((PushRecommend)localObject2).sourceId = localAddFriendSource.uint32_source.get();
                              }
                              if (localAddFriendSource.uint32_sub_source.has()) {
                                ((PushRecommend)localObject2).subSourceId = localAddFriendSource.uint32_sub_source.get();
                              }
                            }
                          }
                          if (((SubMsgType0xae.PersonMayKnow)localObject1).bytes_msg.has()) {
                            ((PushRecommend)localObject2).wzryVerifyStr = new String(((SubMsgType0xae.PersonMayKnow)localObject1).bytes_msg.get().toByteArray());
                          }
                          if (((SubMsgType0xae.PersonMayKnow)localObject1).uint32_game_source.has()) {
                            ((PushRecommend)localObject2).wzrySourceId = ((SubMsgType0xae.PersonMayKnow)localObject1).uint32_game_source.get();
                          }
                          if (((SubMsgType0xae.PersonMayKnow)localObject1).bytes_role_name.has()) {
                            ((PushRecommend)localObject2).wzryGameNick = new String(((SubMsgType0xae.PersonMayKnow)localObject1).bytes_role_name.get().toByteArray());
                          }
                          ((PushRecommend)localObject2).timestamp = l1;
                          paramList.add(localObject2);
                        }
                      }
                    }
                    if (!QLog.isColorLevel()) {}
                  }
                  catch (Exception paramList)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("MayknowRecommendManager", 2, "recv 0x210_0xae, prase msgBody error");
                    }
                    anbh.a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
                    return;
                  }
                case 179: 
                  QLog.d("MsgType0x210Decoder", 2, "handleMsgType0x210SubMsgType0xb3 receive 0xaa push message");
                  paramMsg = ((tos)paramMessageHandler.a("businessbase_processor")).o(((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray());
                  if (!TextUtils.isEmpty(paramMsg))
                  {
                    bool = ((acff)paramMessageHandler.app.getManager(51)).isFriend(paramMsg);
                    if (QLog.isColorLevel()) {
                      QLog.d("MsgType0x210Decoder", 2, "handleMsgType0x210SubMsgType0xb3 isFriend=" + bool + ", uin=" + paramMsg);
                    }
                    if (!bool)
                    {
                      QLog.d("MsgType0x210Decoder", 1, "handleMsgType0x210SubMsgType0xb3 not friend, getDetail");
                      ((FriendListHandler)paramMessageHandler.app.getBusinessHandler(1)).DF(paramMsg);
                      return;
                    }
                  }
                  break;
                case 197: 
                  if (QLog.isColorLevel()) {
                    QLog.d("MsgType0x210Decoder", 2, "handleMsgType0x210SubMsgType0xc5 receive 0xc5 push message");
                  }
                  ((tos)paramMessageHandler.a("businessbase_processor")).h(((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray(), paramMsg.msg_head.msg_time.get());
                  anbh.a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
                  return;
                case 238: 
                  if (QLog.isColorLevel()) {
                    QLog.d("MsgType0x210Decoder", 2, "handleMsgType0x210SubMsgType0xee receive 0xee push message");
                  }
                  ((tos)paramMessageHandler.a("businessbase_processor")).i(((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray(), paramMsg.msg_head.msg_time.get());
                  anbh.a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
                  return;
                case 249: 
                  paramList = (tos)paramMessageHandler.a("businessbase_processor");
                  paramList = new MsgInfo();
                  paramList.lFromUin = paramMsg.msg_head.from_uin.get();
                  paramList.shMsgSeq = ((short)paramMsg.msg_head.msg_seq.get());
                  paramList.uMsgTime = paramMsg.msg_head.msg_time.get();
                  paramList.uRealMsgTime = paramMsg.msg_head.msg_time.get();
                  paramList.lMsgUid = paramMsg.msg_head.msg_uid.get();
                  paramList.shMsgType = ((short)paramMsg.msg_head.msg_type.get());
                  anbh.a(paramMessageHandler, paramList.lFromUin, paramList.shMsgSeq, paramList.lMsgUid, paramList.shMsgType);
                  return;
                case 258: 
                  if (QLog.isColorLevel()) {
                    QLog.d("MsgType0x210Decoder", 2, "handleMsgType0x210_0x102 offline ");
                  }
                  anbh.a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
                  return;
                case 253: 
                  paramList = (tos)paramMessageHandler.a("businessbase_processor");
                  paramList = new MsgInfo();
                  paramList.lFromUin = paramMsg.msg_head.from_uin.get();
                  paramList.shMsgSeq = ((short)paramMsg.msg_head.msg_seq.get());
                  paramList.uMsgTime = paramMsg.msg_head.msg_time.get();
                  paramList.uRealMsgTime = paramMsg.msg_head.msg_time.get();
                  paramList.lMsgUid = paramMsg.msg_head.msg_uid.get();
                  paramList.shMsgType = ((short)paramMsg.msg_head.msg_type.get());
                  anbh.a(paramMessageHandler, paramList.lFromUin, paramList.shMsgSeq, paramList.lMsgUid, paramList.shMsgType);
                  return;
                case 199: 
                  if (QLog.isColorLevel()) {
                    QLog.d("HotFriend_PushMessage", 2, "handleMsgType0x210SubMsgType0xc7  push message");
                  }
                  l1 = paramMsg.msg_head.from_uin.get();
                  i = paramMsg.msg_head.msg_seq.get();
                  l2 = paramMsg.msg_head.msg_uid.get();
                  j = paramMsg.msg_head.msg_type.get();
                  int k = paramMsg.msg_head.msg_time.get();
                  paramMsg = new acrj(l1, i, l2, j, k, false);
                  ((tos)paramMessageHandler.a("businessbase_processor")).a(((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray(), paramMsg);
                  anbh.a(paramMessageHandler, l1, i, l2, j);
                  return;
                case 203: 
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.nearby.tag_nearby_live_tip", 4, "decodeC2CMsgPkg_MsgType0x210 receive 0xcb push message");
                  }
                  paramList = a(paramMessageHandler, ((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray(), paramMsg);
                  if ((paramList != null) && (!achp.a(paramMessageHandler.app, paramList, true)) && (paramList.msgtype == -2053))
                  {
                    paramMsg = (MessageForNearbyLiveTip)paramList;
                    if ((MessageForNearbyLiveTip.isHuayangTip(paramMsg.jumpingUrl)) && (!MessageForNearbyLiveTip.isSupportHuayangBusinessType(paramMsg.jumpingUrl)))
                    {
                      if (QLog.isColorLevel()) {
                        QLog.i("Q.nearby.tag_nearby_live_tip", 2, "decodeC2CMsgPkg_MsgType0x210 discard a not support huayang tips message, jumpUrl=" + paramMsg.jumpingUrl);
                      }
                    }
                    else
                    {
                      if (paramMsg.isLiving)
                      {
                        paramMessageHandler.app.b().b(paramList, paramMessageHandler.app.getCurrentAccountUin());
                        return;
                      }
                      paramanax = paramMessageHandler.app.b().a(paramMsg.frienduin, paramMsg.istroop);
                      if (paramanax != null)
                      {
                        paramMessageHandler.app.b().c(paramMsg.frienduin, paramMsg.istroop, paramanax.uniseq, paramMsg.msgData);
                        paramList = new ArrayList();
                        paramList.add(paramMsg);
                        paramMessageHandler.app.b().fv(paramList);
                        return;
                      }
                      paramMessageHandler.app.b().b(paramList, paramMessageHandler.app.getCurrentAccountUin());
                      return;
                    }
                  }
                  break;
                case 254: 
                  if (QLog.isColorLevel()) {
                    QLog.i("MsgType0x210Decoder", 2, "MessageProtoCodec,decodeC2CMsgPkg_MsgType0x210 receive 0xfe push message");
                  }
                  l1 = paramMsg.msg_head.from_uin.get();
                  i = paramMsg.msg_head.msg_seq.get();
                  l2 = paramMsg.msg_head.msg_uid.get();
                  j = paramMsg.msg_head.msg_type.get();
                  ((MsgBoxInterFollowManager)paramMessageHandler.app.getManager(202)).decode0xfeInteractAndFollowMsg(((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray());
                  anbh.a(paramMessageHandler, l1, i, l2, j);
                  return;
                case 215: 
                  if (QLog.isColorLevel()) {
                    QLog.i("MsgType0x210Decoder", 2, "MessageProtoCodec,decodeC2CMsgPkg_MsgType0x210 receive 0xd7 push message");
                  }
                  l1 = paramMsg.msg_head.from_uin.get();
                  i = paramMsg.msg_head.msg_seq.get();
                  l2 = paramMsg.msg_head.msg_uid.get();
                  j = paramMsg.msg_head.msg_type.get();
                  ((MsgBoxInterFollowManager)paramMessageHandler.app.getManager(202)).decode0xd7InteractAndFollowMsg(((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray());
                  anbh.a(paramMessageHandler, l1, i, l2, j);
                  return;
                case 220: 
                  if (QLog.isColorLevel()) {
                    QLog.i("MsgType0x210Decoder", 2, "MessageProtoCodec,decodeC2CMsgPkg_MsgType0x210 receive 0xdc push message");
                  }
                  paramList = (abhh)paramMessageHandler.app.getManager(153);
                  if (paramList != null) {
                    paramList.at(((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray());
                  }
                  anbh.a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
                  return;
                case 232: 
                  QLog.d("ApolloPushManager", 1, "recv action push message 0x210_0xe8, [C2C.offline]");
                  try
                  {
                    paramMsg = new submsgtype0xe8.MsgBody();
                    paramMsg.mergeFrom(((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray());
                    if (paramMsg.msg_item.has())
                    {
                      paramMsg = (apollo_push_msgInfo.STPushMsgElem)paramMsg.msg_item.get();
                      if (paramMessageHandler.app != null)
                      {
                        paramMessageHandler = (abht)paramMessageHandler.app.getManager(227);
                        paramMessageHandler.a(0, paramMsg);
                        paramMessageHandler.c(paramMsg);
                        paramMessageHandler.b(paramMsg);
                        return;
                      }
                    }
                  }
                  catch (Exception paramMessageHandler)
                  {
                    paramMessageHandler.printStackTrace();
                    QLog.e("ApolloPushManager", 1, "[msg0x210.uSubMsgType == 0xe8], errInfo->" + paramMessageHandler.getMessage());
                    return;
                  }
                }
              }
            }
            if (QLog.isColorLevel()) {
              QLog.i("MsgType0x210Decoder", 2, "decodeC2CMsgPkg_MsgType0x210 invoked. info: AIO Feed offline messageRecord: 0xf4");
            }
            l1 = paramMsg.msg_head.from_uin.get();
            paramMsg = ((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray();
            paramMessageHandler = (plz)paramMessageHandler.app.getManager(253);
            paramMessageHandler.a(paramMessageHandler.a(paramMsg, String.valueOf(l1)));
            return;
            if (QLog.isColorLevel()) {
              QLog.i("MsgType0x210Decoder", 2, "decodeC2CMsgPkg_MsgType0x210 invoked. info: 0xfb");
            }
            try
            {
              paramList = new NowPushMsgList.MsgBody();
              paramList.mergeFrom(((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray());
              paramList = paramList.rpt_now_push_msg.get().iterator();
              while (paramList.hasNext())
              {
                paramanax = (NowPushMsgList.NowPushMsg)paramList.next();
                if (paramMessageHandler.app != null) {
                  ((aklj)paramMessageHandler.app.getManager(266)).b(paramanax);
                }
                if (QLog.isColorLevel()) {
                  QLog.d("MsgType0x210Decoder", 2, "decodeC2CMsgPkg_MsgType0x210 0xfb " + paramanax.uint32_switch.get() + "  uint32_task_id " + paramanax.uint32_task_id.get() + "  uint32_type " + paramanax.uint32_type.get() + "  uint64_start_time " + paramanax.uint64_start_time.get() + "  uint64_end_time " + paramanax.uint64_end_time.get() + " app=" + paramMessageHandler.app);
                }
              }
              anbh.a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
            }
            catch (Exception paramMessageHandler)
            {
              QLog.e("MsgType0x210Decoder", 1, "[msg0x210.uSubMsgType == 0xfb], errInfo->" + paramMessageHandler.getMessage());
              return;
            }
            return;
            if (QLog.isColorLevel()) {
              QLog.i("MsgType0x210Decoder", 2, "offline push decodeC2CMsgPkg_MsgType0x210 invoked. info: 0x111");
            }
            try
            {
              paramList = ((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray();
              achg.c(paramMessageHandler.app, paramList);
              anbh.a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
              return;
            }
            catch (Exception paramMessageHandler)
            {
              QLog.e("MsgType0x210Decoder", 1, "[msg0x210.uSubMsgType == 0x111], errInfo->" + paramMessageHandler.getMessage());
              return;
            }
            if (QLog.isColorLevel()) {
              QLog.i("MsgType0x210Decoder", 2, "offline push decodeC2CMsgPkg_MsgType0x210 invoked. info: 0x11e");
            }
            try
            {
              paramList = ((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray();
              paramanax = (FriendListHandler)paramMessageHandler.app.getBusinessHandler(1);
              if (paramanax != null) {
                paramanax.aw(paramList);
              }
              anbh.a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
              return;
            }
            catch (Exception paramMessageHandler)
            {
              QLog.e("MsgType0x210Decoder", 1, "[msg0x210.uSubMsgType == 0x11e], errInfo->" + paramMessageHandler.getMessage());
              return;
            }
            if (QLog.isColorLevel()) {
              QLog.d("MsgType0x210Decoder", 2, "offline push decodeC2CMsgPkg_MsgType0x210 invoked, info: 0x11f");
            }
            paramList = ((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray();
            ainz.b(paramMessageHandler.app, paramList, paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_time.get(), true);
            anbh.a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
            return;
            if (QLog.isColorLevel()) {
              QLog.d("MsgType0x210Decoder", 2, "offline push decodeC2CMsgPkg_MsgType0x127 invoked, info: 0x127");
            }
            paramList = ((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray();
            paramanax = ((aohy)paramMessageHandler.app.getManager(339)).a(4);
            if (paramanax != null) {
              paramanax.a(paramMessageHandler.app, paramList, paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_time.get(), true);
            }
            anbh.a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
            return;
            if (QLog.isColorLevel()) {
              QLog.i("MsgType0x210Decoder", 2, "decodeC2CMsgPkg_MsgType0x210 invoked. info: 0x100");
            }
          } while (paramMessageHandler.app == null);
          paramList = afce.a(paramMessageHandler.app, ((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray(), paramMsg);
          paramMessageHandler.app.b().b(paramList, paramMessageHandler.app.getCurrentAccountUin());
          anbh.a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
          return;
          if (QLog.isColorLevel()) {
            QLog.d("MsgType0x210Decoder", 2, "handleMsgType0x210SubMsgType0x104  push message");
          }
          try
          {
            l1 = paramMsg.msg_head.from_uin.get();
            i = paramMsg.msg_head.msg_seq.get();
            l2 = paramMsg.msg_head.msg_uid.get();
            j = paramMsg.msg_head.msg_type.get();
            paramMsg = new submsgtype0x104.MsgBody();
            paramMsg.mergeFrom(((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray());
            paramMessageHandler.app.a().a().a(paramMsg);
            anbh.a(paramMessageHandler, l1, i, l2, j);
            return;
          }
          catch (Exception paramMessageHandler) {}
        } while (!QLog.isColorLevel());
        QLog.i("MsgType0x210Decoder", 2, "onLinePush receive 0x210_0x104 wrong:" + paramMessageHandler.toString());
        return;
        if (QLog.isColorLevel()) {
          QLog.i("MsgType0x210Decoder", 2, "decodeC2CMsgPkg_MsgType0x210 invoked. info: 0x108");
        }
      } while (paramMessageHandler.app == null);
      paramList = afdd.b(paramMessageHandler.app, ((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray(), paramMsg);
      paramMessageHandler.app.b().b(paramList, paramMessageHandler.app.getCurrentAccountUin());
      anbh.a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
      return;
    } while (!QLog.isColorLevel());
    QLog.d("MsgType0x210Decoder", 2, "submsgtype0x116 decodeC2CMsgPkg_MsgType0x210 receive 0x116 push message");
    return;
    paramList = ((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray();
    if (QLog.isColorLevel()) {
      QLog.d("MsgType0x210Decoder", 2, "troopFormLog offLinePush receive submsgtype0x119 decodeC2CMsgPkg_MsgType0x210 receive 0x119 push message");
    }
    try
    {
      paramanax = new SubMsgType0x119.MsgBody();
      paramanax.mergeFrom(paramList);
      if (!aobw.iD(paramMsg.msg_head.msg_seq.get()))
      {
        aobw.a(paramMessageHandler.app, paramanax);
        QLog.d("MsgType0x210Decoder", 1, "troopFormLog isPushMessageDuplicated ");
      }
      anbh.a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
      return;
    }
    catch (Exception paramMessageHandler)
    {
      QLog.e("MsgType0x210Decoder", 1, "troopFormLog offLinePush receive submsgtype0x119 decodeC2CMsgPkg_MsgType0x210 receive 0x119 push message, errInfo->" + paramMessageHandler.getMessage());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgType0x210Decoder", 2, "handleC2COfflinePushMsgGrayTip subType = " + i);
    }
    paramList = ((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray();
    paramanax = new MsgInfo();
    paramanax.lFromUin = paramMsg.msg_head.from_uin.get();
    paramanax.shMsgSeq = ((short)paramMsg.msg_head.msg_seq.get());
    paramanax.uMsgTime = paramMsg.msg_head.msg_time.get();
    paramanax.uRealMsgTime = paramMsg.msg_head.msg_time.get();
    paramanax.lMsgUid = paramMsg.msg_head.msg_uid.get();
    paramanax.shMsgType = ((short)paramMsg.msg_head.msg_type.get());
    paramMessageHandler = paramMessageHandler.app;
    if (i == 290) {}
    for (boolean bool = true;; bool = false)
    {
      ahwb.a(paramMessageHandler, paramList, paramanax, bool);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("MsgType0x210Decoder", 2, "offline push decodeC2CMsgPkg_MsgType0x210 invoked. info: 0x133");
    }
    try
    {
      paramList = ((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray();
      paramanax = (ypc)paramMessageHandler.app.getBusinessHandler(169);
      if (paramanax != null) {
        paramanax.an(paramList);
      }
      anbh.a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
      return;
    }
    catch (Exception paramMessageHandler)
    {
      QLog.e("MsgType0x210Decoder", 1, "[msg0x210.uSubMsgType == 0x133], errInfo->" + paramMessageHandler.getMessage());
    }
  }
  
  protected void onCreate()
  {
    this.c.a(Integer.valueOf(0), ancm.class);
    this.c.a(Integer.valueOf(38), andc.class);
    this.c.a(Integer.valueOf(48), ancx.class);
    this.c.a(Integer.valueOf(61), ancy.class);
    this.c.a(Integer.valueOf(63), anct.class);
    this.c.a(Integer.valueOf(78), anda.class);
    this.c.a(Integer.valueOf(81), ancn.class);
    this.c.a(Integer.valueOf(102), ancs.class);
    this.c.a(Integer.valueOf(103), ancq.class);
    this.c.a(Integer.valueOf(107), ancr.class);
    this.c.a(Integer.valueOf(110), ancv.class);
    this.c.a(Integer.valueOf(111), andd.class);
    this.c.a(Integer.valueOf(114), ancu.class);
    this.c.a(Integer.valueOf(118), ancl.class);
    this.c.a(Integer.valueOf(124), ancw.class);
    this.c.a(Integer.valueOf(177), andb.class);
    this.c.a(Integer.valueOf(296), anco.class);
    this.c.a(Integer.valueOf(311), anco.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ancp
 * JD-Core Version:    0.7.0.1
 */