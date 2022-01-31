package com.tencent.mobileqq.app.message;

import android.util.Pair;
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
import cyb;
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
    this.jdField_a_of_type_JavaUtilComparator = new cyb(this);
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
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    Object localObject1;
    int k;
    int i;
    int j;
    if (paramMsg.content_head.has())
    {
      localObject1 = (msg_comm.ContentHead)paramMsg.content_head.get();
      k = ((msg_comm.ContentHead)localObject1).div_seq.get();
      i = ((msg_comm.ContentHead)localObject1).pkg_num.get();
      int m = ((msg_comm.ContentHead)localObject1).pkg_index.get();
      j = i;
      i = m;
    }
    for (;;)
    {
      localObject1 = MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, String.valueOf(l5), String.valueOf(l5));
      long l1;
      if (((Long)((Pair)localObject1).first).longValue() != 4294967295L)
      {
        l1 = ((Long)((Pair)localObject1).first).longValue();
        if (l1 != -1L) {
          break label1503;
        }
      }
      label934:
      label1488:
      label1494:
      label1503:
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
          localObject1 = ((List)localObject2).iterator();
          byte b1 = 0;
          byte b2;
          im_msg_body.RichText localRichText;
          for (;;)
          {
            if (((Iterator)localObject1).hasNext())
            {
              localObject2 = (MessageRecord)((Iterator)localObject1).next();
              ((MessageRecord)localObject2).time = l8;
              ((MessageRecord)localObject2).msgseq = l8;
              ((MessageRecord)localObject2).shmsgseq = l6;
              ((MessageRecord)localObject2).msgUid = l1;
              ((MessageRecord)localObject2).selfuin = str;
              ((MessageRecord)localObject2).istroop = paramPBDecodeContext.c;
              ((MessageRecord)localObject2).senderuin = String.valueOf(l5);
              ((MessageRecord)localObject2).frienduin = String.valueOf(paramPBDecodeContext.e);
              ((MessageRecord)localObject2).longMsgId = k;
              ((MessageRecord)localObject2).longMsgCount = j;
              ((MessageRecord)localObject2).longMsgIndex = i;
              if (paramPBDecodeContext.d == 127)
              {
                ((MessageRecord)localObject2).msg = "PTT_URL";
                ((MessageRecord)localObject2).msgtype = -2006;
                ((MessageRecord)localObject2).isread = true;
              }
              if (((MessageRecord)localObject2).msgtype == -1035) {
                ((ChatMessage)localObject2).parse();
              }
              b2 = b1;
              if (localMsgHead.msg_flag.has())
              {
                b2 = b1;
                if ((localMsgHead.msg_flag.get() & 1L) == 1L)
                {
                  b1 = 1;
                  localMessageInfo.b.a(l6, ((MessageRecord)localObject2).uniseq);
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
                  localMessageInfo.c.b = ((MessageRecord)localObject2).uniseq;
                }
                if (localMessageInfo.a.a != -1L) {
                  localMessageInfo.a.b = ((MessageRecord)localObject2).uniseq;
                }
                if (l6 > this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(paramPBDecodeContext.e), 1)) {
                  paramMessageInfo.a(localMessageInfo);
                }
              }
              paramArrayList.add(localObject2);
              b1 = b2;
              continue;
              l1 = ((Long)((Pair)localObject1).second).longValue();
              break;
              if (!paramMsg.msg_body.has()) {
                break label1494;
              }
              localObject1 = (im_msg_body.MsgBody)paramMsg.msg_body.get();
              if (!((im_msg_body.MsgBody)localObject1).rich_text.has()) {
                break label1494;
              }
              localRichText = (im_msg_body.RichText)((im_msg_body.MsgBody)localObject1).rich_text.get();
              if (!localRichText.attr.has()) {
                break label1488;
              }
            }
          }
          for (l1 = MessageUtils.a(((im_msg_body.Attr)localRichText.attr.get()).random.get());; l1 = 0L)
          {
            localObject1 = localRichText.elems.get();
            if (localRichText.ptt.has())
            {
              MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, (List)localObject2);
              paramMsg = (msg_comm.Msg)localObject1;
              break;
            }
            MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, (List)localObject2, paramMsg, false, false, localMessageInfo);
            paramMsg = (msg_comm.Msg)localObject1;
            break;
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
                        break label1147;
                      }
                      if (!bool2) {
                        break label1141;
                      }
                      paramMsg = paramMsg.a("" + l1);
                      if ((paramMsg != null) && (!paramMsg.isNeedDelete)) {
                        break label1147;
                      }
                      paramArrayList.clear();
                      return null;
                      if ((!paramMessageInfo.elem_flags2.has()) || (!((im_msg_body.ElemFlags2)paramMessageInfo.elem_flags2.get()).uint32_longtitude.has()) || (!((im_msg_body.ElemFlags2)paramMessageInfo.elem_flags2.get()).uint32_latitude.has()) || (l7 != l5)) {
                        break;
                      }
                      bool1 = false;
                    }
                    label1141:
                    paramArrayList.clear();
                    return null;
                    label1147:
                    if ((bool2) && (!bool1))
                    {
                      if (QLog.isColorLevel()) {
                        QLog.e("OpenTroopDebug", 2, "opentroop but no PubGroup, server error!");
                      }
                      bool1 = true;
                      paramMessageInfo = String.valueOf(l1);
                      localObject1 = String.valueOf(l5);
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
                  ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(paramMessageInfo, (String)localObject1, paramMsg, j, null, null, b2, b3, i, l6, b1, 0L, -100.0D);
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
                paramPBDecodeContext.memberuin = ((String)localObject1);
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
              break label1176;
              bool1 = false;
              break label934;
              l1 = 0L;
              break;
              paramMsg = null;
            }
          }
          paramMsg = null;
          l1 = l3;
        }
      }
      label1176:
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