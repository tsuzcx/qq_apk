package com.tencent.mobileqq.app.message;

import android.util.Pair;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.OpenTroopInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.service.message.PBDecodeContext;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.MessageNavInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import czj;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.AppShareInfo;
import msf.msgcomm.msg_comm.ContentHead;
import msf.msgcomm.msg_comm.GroupInfo;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.msg.im_msg_body.AnonymousGroupMsg;
import tencent.im.msg.im_msg_body.Attr;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ElemFlags2;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.Ptt;
import tencent.im.msg.im_msg_body.PubGroup;
import tencent.im.msg.im_msg_body.RichText;

public class BaseMessageProcessorForTroopAndDisc
  extends BaseMessageProcessor
{
  public static final String b = "Q.msg.BaseMessageProcessorForTroopAndDisc";
  protected Comparator a;
  
  public BaseMessageProcessorForTroopAndDisc(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
    this.jdField_a_of_type_JavaUtilComparator = new czj(this);
  }
  
  private void a(String paramString)
  {
    FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    if (localFriendsManagerImp.a(paramString) == null)
    {
      TroopInfo localTroopInfo = new TroopInfo();
      localTroopInfo.troopuin = paramString;
      localFriendsManagerImp.b(localTroopInfo);
      ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(17)).a(paramString, (byte)1, 0L, 0);
    }
  }
  
  public TroopMemberInfo a(msg_comm.Msg paramMsg, ArrayList paramArrayList, PBDecodeContext paramPBDecodeContext, boolean paramBoolean, MessageInfo paramMessageInfo)
  {
    long l4 = System.currentTimeMillis();
    if ((paramPBDecodeContext == null) || (paramMsg == null) || (paramArrayList == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "<---decodeSinglePbMsg_GroupDis : " + paramPBDecodeContext);
      }
      return null;
    }
    msg_comm.MsgHead localMsgHead = (msg_comm.MsgHead)paramMsg.msg_head.get();
    long l5 = localMsgHead.from_uin.get();
    localMsgHead.to_uin.get();
    long l6 = localMsgHead.msg_seq.get();
    long l8 = localMsgHead.msg_time.get();
    long l3 = 0L;
    long l7 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin();
    String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    Object localObject1;
    int k;
    int j;
    int i;
    if (paramMsg.content_head.has())
    {
      localObject1 = (msg_comm.ContentHead)paramMsg.content_head.get();
      k = ((msg_comm.ContentHead)localObject1).div_seq.get();
      j = ((msg_comm.ContentHead)localObject1).pkg_num.get();
      i = ((msg_comm.ContentHead)localObject1).pkg_index.get();
    }
    for (;;)
    {
      localObject1 = MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, String.valueOf(l5), String.valueOf(l5));
      long l1;
      if (((Long)((Pair)localObject1).first).longValue() != 4294967295L)
      {
        l1 = ((Long)((Pair)localObject1).first).longValue();
        if (l1 != -1L) {
          break label1742;
        }
      }
      label772:
      label782:
      label1044:
      label1173:
      label1742:
      for (long l2 = 0L;; l2 = l1)
      {
        Object localObject2 = new ArrayList();
        MessageInfo localMessageInfo = new MessageInfo();
        if (paramMsg.appshare_info.has())
        {
          MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, (List)localObject2, paramMsg, paramPBDecodeContext.e, l8, false);
          paramMsg = null;
          l1 = l3;
        }
        for (;;)
        {
          Object localObject3 = ((List)localObject2).iterator();
          byte b1 = 0;
          byte b2;
          for (;;)
          {
            if (!((Iterator)localObject3).hasNext()) {
              break label1044;
            }
            MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject3).next();
            localMessageRecord.time = l8;
            localMessageRecord.msgseq = l8;
            localMessageRecord.shmsgseq = l6;
            localMessageRecord.msgUid = l1;
            localMessageRecord.selfuin = str2;
            localMessageRecord.istroop = paramPBDecodeContext.c;
            localMessageRecord.senderuin = String.valueOf(l5);
            localMessageRecord.frienduin = String.valueOf(paramPBDecodeContext.e);
            localMessageRecord.longMsgId = k;
            localMessageRecord.longMsgCount = j;
            localMessageRecord.longMsgIndex = i;
            if (paramPBDecodeContext.d == 127)
            {
              localMessageRecord.msg = "PTT_URL";
              localMessageRecord.msgtype = -2006;
              localMessageRecord.isread = true;
            }
            if (localMessageRecord.msgtype == -1035) {
              ((ChatMessage)localMessageRecord).parse();
            }
            b2 = b1;
            if (localMsgHead.msg_flag.has())
            {
              b2 = b1;
              if ((localMsgHead.msg_flag.get() & 1L) == 1L)
              {
                b1 = 1;
                localMessageInfo.b.a(l6, localMessageRecord.uniseq);
                b2 = b1;
                if (QLog.isColorLevel())
                {
                  QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "receive the TroopMsg from TroopSpecialAttention!");
                  b2 = b1;
                }
              }
            }
            if (paramMessageInfo != null)
            {
              if (localMessageInfo.c.a != -1L) {
                localMessageInfo.c.b = localMessageRecord.uniseq;
              }
              if (localMessageInfo.a.a != -1L) {
                localMessageInfo.a.b = localMessageRecord.uniseq;
              }
              if (l6 > this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(paramPBDecodeContext.e), 1)) {
                paramMessageInfo.a(localMessageInfo);
              }
            }
            int m;
            byte[] arrayOfByte;
            int n;
            int i1;
            if ((paramPBDecodeContext.c == 1) && (paramMsg != null))
            {
              localObject1 = paramMsg.iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (im_msg_body.Elem)((Iterator)localObject1).next();
                if (((im_msg_body.Elem)localObject2).anon_group_msg.has())
                {
                  localObject1 = (im_msg_body.AnonymousGroupMsg)((im_msg_body.Elem)localObject2).anon_group_msg.get();
                  m = ((im_msg_body.AnonymousGroupMsg)localObject1).uint32_flags.get();
                  arrayOfByte = ((im_msg_body.AnonymousGroupMsg)localObject1).str_anon_id.get().toByteArray();
                  localObject2 = ((im_msg_body.AnonymousGroupMsg)localObject1).str_anon_nick.get().toByteArray();
                  n = ((im_msg_body.AnonymousGroupMsg)localObject1).uint32_head_portrait.get();
                  i1 = ((im_msg_body.AnonymousGroupMsg)localObject1).uint32_expire_time.get();
                  if (arrayOfByte == null) {
                    break label1022;
                  }
                }
              }
            }
            try
            {
              localObject1 = new String(arrayOfByte, "ISO-8859-1");
              if (localObject2 != null) {
                break label1030;
              }
              localObject2 = "";
              localMessageRecord.saveExtInfoToExtStr("anonymous", AnonymousChatHelper.a(m, (String)localObject1, (String)localObject2, n, i1));
              localMessageRecord.extLong |= 0x3;
              if (QLog.isColorLevel()) {
                QLog.d("anonymous_decode", 2, "anonymous_flags = " + m);
              }
              paramArrayList.add(localMessageRecord);
              b1 = b2;
            }
            catch (UnsupportedEncodingException localUnsupportedEncodingException)
            {
              localUnsupportedEncodingException.printStackTrace();
            }
          }
          l1 = ((Long)((Pair)localObject1).second).longValue();
          break;
          if (paramMsg.msg_body.has())
          {
            localObject1 = (im_msg_body.MsgBody)paramMsg.msg_body.get();
            if (((im_msg_body.MsgBody)localObject1).rich_text.has())
            {
              localObject3 = (im_msg_body.RichText)((im_msg_body.MsgBody)localObject1).rich_text.get();
              if (((im_msg_body.RichText)localObject3).attr.has()) {}
              for (l1 = MessageUtils.a(((im_msg_body.Attr)((im_msg_body.RichText)localObject3).attr.get()).random.get());; l1 = 0L)
              {
                localObject1 = ((im_msg_body.RichText)localObject3).elems.get();
                if (((im_msg_body.RichText)localObject3).ptt.has())
                {
                  MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, (List)localObject2);
                  paramMsg = (msg_comm.Msg)localObject1;
                  break;
                }
                MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, (List)localObject2, paramMsg, false, false, localMessageInfo);
                paramMsg = (msg_comm.Msg)localObject1;
                break;
                label1022:
                String str1 = "";
                break label772;
                localObject2 = new String((byte[])localObject2);
                break label782;
                byte b3;
                boolean bool1;
                boolean bool2;
                if (paramPBDecodeContext.c == 1)
                {
                  b2 = 0;
                  b3 = 1;
                  i = 100;
                  paramPBDecodeContext = (msg_comm.GroupInfo)localMsgHead.group_info.get();
                  if (paramPBDecodeContext != null)
                  {
                    l1 = paramPBDecodeContext.group_code.get();
                    if (paramMsg != null)
                    {
                      paramMsg = paramMsg.iterator();
                      if (paramMsg.hasNext())
                      {
                        paramMessageInfo = (im_msg_body.Elem)paramMsg.next();
                        if (paramMessageInfo.pub_group.has())
                        {
                          bool1 = true;
                          paramMsg = (im_msg_body.PubGroup)paramMessageInfo.pub_group.get();
                          b2 = (byte)paramMsg.uint32_age.get();
                          b3 = (byte)paramMsg.uint32_gender.get();
                          i = paramMsg.uint32_distance.get();
                        }
                        for (;;)
                        {
                          if (QLog.isColorLevel()) {
                            QLog.d("OpenTroopDebug", 2, "recv msg, groupcode = " + l1 + ", hasPubGroup = " + bool1);
                          }
                          paramMsg = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
                          bool2 = paramMsg.f("" + l1);
                          if (!bool1) {
                            break label1386;
                          }
                          if (!bool2) {
                            break label1380;
                          }
                          paramMsg = paramMsg.a("" + l1);
                          if ((paramMsg != null) && (!paramMsg.isNeedDelete)) {
                            break label1386;
                          }
                          paramArrayList.clear();
                          return null;
                          if ((!paramMessageInfo.elem_flags2.has()) || (!((im_msg_body.ElemFlags2)paramMessageInfo.elem_flags2.get()).uint32_longtitude.has()) || (!((im_msg_body.ElemFlags2)paramMessageInfo.elem_flags2.get()).uint32_latitude.has()) || (l7 != l5)) {
                            break;
                          }
                          bool1 = false;
                        }
                        label1380:
                        paramArrayList.clear();
                        return null;
                        label1386:
                        if ((bool2) && (!bool1))
                        {
                          if (QLog.isColorLevel()) {
                            QLog.e("OpenTroopDebug", 2, "opentroop but no PubGroup, server error!");
                          }
                          bool1 = true;
                          paramMessageInfo = String.valueOf(l1);
                          str1 = String.valueOf(l5);
                          paramMsg = paramPBDecodeContext.group_card.get().toByteArray();
                          j = paramPBDecodeContext.group_level.get();
                        }
                      }
                    }
                  }
                }
                for (;;)
                {
                  try
                  {
                    paramMsg = new String(paramMsg, "utf-8");
                    if ((!bool1) && (!bool2))
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("OpenTroopDebug", 2, "checkGroupExist, groupcode = " + paramMessageInfo);
                      }
                      a(paramMessageInfo);
                    }
                    if (paramBoolean)
                    {
                      ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(paramMessageInfo, str1, paramMsg, j, null, null, b2, b3, i, l6, b1, 0L, -100.0D);
                      paramMsg = null;
                      paramArrayList = paramArrayList.iterator();
                      if (!paramArrayList.hasNext()) {
                        continue;
                      }
                      ((MessageRecord)paramArrayList.next()).vipBubbleID = l2;
                      continue;
                    }
                  }
                  catch (UnsupportedEncodingException paramMsg)
                  {
                    paramMsg.printStackTrace();
                    paramMsg = null;
                    continue;
                    paramPBDecodeContext = new TroopMemberInfo();
                    paramPBDecodeContext.troopuin = paramMessageInfo;
                    paramPBDecodeContext.memberuin = str1;
                    paramPBDecodeContext.troopnick = paramMsg;
                    paramPBDecodeContext.level = j;
                    paramPBDecodeContext.sex = b3;
                    paramPBDecodeContext.age = b2;
                    paramPBDecodeContext.distance = i;
                    paramPBDecodeContext.msgseq = l6;
                    if (b1 == 1)
                    {
                      paramBoolean = true;
                      paramPBDecodeContext.isTroopFollowed = paramBoolean;
                      paramPBDecodeContext.distanceToSelf = -100.0D;
                      paramPBDecodeContext.distanceToSelfUpdateTimeStamp = System.currentTimeMillis();
                      paramMsg = paramPBDecodeContext;
                      continue;
                    }
                    paramBoolean = false;
                    continue;
                    MsgAutoMonitorUtil.a().g(System.currentTimeMillis() - l4);
                    return paramMsg;
                  }
                  break label1415;
                  bool1 = false;
                  break label1173;
                  l1 = 0L;
                  break;
                  paramMsg = null;
                }
              }
            }
          }
          paramMsg = null;
          l1 = l3;
        }
      }
      label1030:
      label1415:
      i = 0;
      j = 0;
      k = 0;
    }
  }
  
  protected String a(msg_comm.Msg paramMsg)
  {
    long l = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
    return 64 + "key_seq_" + l;
  }
  
  public List a(msg_comm.Msg paramMsg, PBDecodeContext paramPBDecodeContext)
  {
    return null;
  }
  
  public void a(int paramInt, Object... paramVarArgs) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.BaseMessageProcessorForTroopAndDisc
 * JD-Core Version:    0.7.0.1
 */