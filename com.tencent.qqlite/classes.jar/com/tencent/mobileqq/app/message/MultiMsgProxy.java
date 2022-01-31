package com.tencent.mobileqq.app.message;

import android.content.ContentValues;
import android.util.Pair;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.proxy.BaseProxy;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.OpenTroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.MessageRecordEntityManager;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.DiscussInfo;
import msf.msgcomm.msg_comm.GroupInfo;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.MutilTransHead;
import msf.msgsvc.msgtransmit.msg_transmit.PbMultiMsgTransmit;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ElemFlags2;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.PubGroup;
import tencent.im.msg.im_msg_body.RichText;

public class MultiMsgProxy
  extends BaseProxy
{
  public static final int a = 10000;
  static final String jdField_a_of_type_JavaLangString = "MultiMsg";
  private static final Class[] jdField_a_of_type_ArrayOfJavaLangClass = { MessageForText.class, MessageForPic.class, MessageForMixedMsg.class, MessageForLongMsg.class };
  public static final String b = "mr_multimessage";
  MessageRecordEntityManager jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager = null;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  
  public MultiMsgProxy(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    super(paramQQAppInterface, paramProxyManager);
  }
  
  private MessageRecordEntityManager a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager.a())) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager.a())) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager = ((MessageRecordEntityManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createMessageRecordEntityManager());
      }
      return this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager;
    }
  }
  
  public static boolean a(ChatMessage paramChatMessage)
  {
    Object localObject = jdField_a_of_type_ArrayOfJavaLangClass;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      if (localObject[i].isInstance(paramChatMessage)) {
        return true;
      }
      i += 1;
    }
    if (MessageForStructing.class.isInstance(paramChatMessage))
    {
      localObject = (MessageForStructing)paramChatMessage;
      if ((((MessageForStructing)localObject).structingMsg != null) && ("viewMultiMsg".equals(((MessageForStructing)localObject).structingMsg.mMsgAction))) {
        return false;
      }
      if (paramChatMessage.msgtype != -2011) {
        return false;
      }
      if ((((MessageForStructing)localObject).structingMsg != null) && (((MessageForStructing)localObject).structingMsg.fwFlag == 1)) {
        return false;
      }
      return (((MessageForStructing)localObject).structingMsg == null) || (!((MessageForStructing)localObject).structingMsg.hasFlag(1));
    }
    return false;
  }
  
  protected MessageRecord a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg", 2, "queryLastMsg,delNum:" + paramInt);
    }
    ArrayList localArrayList = (ArrayList)a().a(MessageRecord.class, "select * from mr_multimessage limit 1 offset ?", new String[] { String.valueOf(paramInt - 1) });
    if ((localArrayList == null) || (localArrayList.size() < 1)) {
      return null;
    }
    return (MessageRecord)localArrayList.get(0);
  }
  
  protected MessageRecord a(long paramLong1, long paramLong2)
  {
    List localList = a().a(MessageRecord.class, "select * from mr_multimessage where msgseq=? and uniseq=?", new String[] { String.valueOf(paramLong2), String.valueOf(paramLong1) });
    if ((localList == null) || (localList.size() < 1)) {
      return null;
    }
    ((MessageRecord)localList.get(0)).isMultiMsg = true;
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg", 2, "queryOneMsgFromMultiMsg,list.get(0).uniseq:" + ((MessageRecord)localList.get(0)).uniseq + " msgseq:" + ((MessageRecord)localList.get(0)).msgseq);
    }
    return (MessageRecord)localList.get(0);
  }
  
  public ArrayList a(long paramLong)
  {
    ArrayList localArrayList = (ArrayList)a().a(MessageRecord.class, "select * from mr_multimessage where msgseq=? order by _id asc", new String[] { String.valueOf(paramLong) });
    Object localObject1;
    if ((localArrayList == null) || (localArrayList.size() < 1)) {
      localObject1 = new ArrayList();
    }
    do
    {
      return localObject1;
      localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (MessageRecord)((Iterator)localObject1).next();
        ((MessageRecord)localObject2).isMultiMsg = true;
        if (((MessageRecord)localObject2).msgtype == -1035)
        {
          localObject2 = ((MessageForMixedMsg)localObject2).msgElemList.iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((MessageRecord)((Iterator)localObject2).next()).isMultiMsg = true;
          }
        }
      }
      localObject1 = localArrayList;
    } while (!QLog.isColorLevel());
    QLog.d("MultiMsg", 2, "querySevalMsgFromMultiMsg,list.get(0).uniseq:" + ((MessageRecord)localArrayList.get(0)).uniseq + " msgseq:" + ((MessageRecord)localArrayList.get(0)).msgseq);
    return localArrayList;
  }
  
  public ArrayList a(MessageRecord paramMessageRecord, ArrayList paramArrayList, ProxyListener paramProxyListener)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = paramArrayList.iterator();
    while (localIterator1.hasNext())
    {
      MessageRecord localMessageRecord1 = (MessageRecord)localIterator1.next();
      if (localMessageRecord1.msgtype == -1037) {
        paramArrayList = (MessageForText)((MessageForLongMsg)localMessageRecord1).rebuildLongMsg();
      }
      while (paramArrayList == null)
      {
        return null;
        if (localMessageRecord1.msgtype == -1036) {
          paramArrayList = (MessageForMixedMsg)((MessageForLongMsg)localMessageRecord1).rebuildLongMsg();
        } else if (localMessageRecord1.msgtype == -2011) {
          paramArrayList = new MessageForStructing(localMessageRecord1);
        } else {
          paramArrayList = (MessageRecord)localMessageRecord1.deepCopyByReflect();
        }
      }
      paramArrayList.msgseq = paramMessageRecord.uniseq;
      paramArrayList.isMultiMsg = true;
      paramArrayList.extraflag = 32770;
      if (paramArrayList.msgtype == -1035)
      {
        Iterator localIterator2 = ((MessageForMixedMsg)paramArrayList).msgElemList.iterator();
        while (localIterator2.hasNext())
        {
          MessageRecord localMessageRecord2 = (MessageRecord)localIterator2.next();
          localMessageRecord2.msgseq = paramArrayList.msgseq;
          localMessageRecord2.isMultiMsg = true;
        }
      }
      localArrayList.add(paramArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg", 2, "preAddMultiMsg, MessageRecord:" + localMessageRecord1.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.c(paramArrayList.frienduin, paramArrayList.istroop, paramArrayList.getTableName(), paramArrayList, 0, paramProxyListener);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.c();
    return localArrayList;
  }
  
  public ArrayList a(byte[] paramArrayOfByte, HashMap paramHashMap, MessageRecord paramMessageRecord)
  {
    long l4 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg", 2, "unpackPbToMultiMsg, start unpack, startTime:" + l4);
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg", 2, "unpackPbToMultiMsg, data is null or data.lenght is 0");
      }
      return null;
    }
    Object localObject1 = b(paramArrayOfByte);
    if (localObject1 == null) {
      return null;
    }
    paramArrayOfByte = new ArrayList();
    Object localObject2 = new msg_transmit.PbMultiMsgTransmit();
    int i;
    Object localObject3;
    try
    {
      localObject1 = (msg_transmit.PbMultiMsgTransmit)((msg_transmit.PbMultiMsgTransmit)localObject2).mergeFrom((byte[])localObject1);
      i = 0;
      if (i >= ((msg_transmit.PbMultiMsgTransmit)localObject1).msg.size()) {
        break label897;
      }
      localObject3 = (msg_comm.Msg)((msg_transmit.PbMultiMsgTransmit)localObject1).msg.get(i);
      if ((!((msg_comm.Msg)localObject3).msg_body.has()) || (!((im_msg_body.MsgBody)((msg_comm.Msg)localObject3).msg_body.get()).rich_text.has()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg", 2, "unpackPbToMultiMsg, no msg_body or rich_text, msg_body.has():" + ((msg_comm.Msg)localObject3).msg_body.has());
        }
        return null;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg", 2, "unpackPbToMultiMsg, error: exception occurs while parsing the pb bytes", paramArrayOfByte);
      }
      return null;
    }
    Object localObject4 = (msg_comm.MsgHead)((msg_comm.Msg)localObject3).msg_head.get();
    long l3 = ((msg_comm.MsgHead)localObject4).from_uin.get();
    long l5 = ((msg_comm.MsgHead)localObject4).msg_seq.get();
    long l6 = ((msg_comm.MsgHead)localObject4).msg_time.get();
    long l7 = ((msg_comm.MsgHead)localObject4).msg_uid.get();
    int j = ((msg_comm.MsgHead)localObject4).msg_type.get();
    MessageHandler localMessageHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    localObject2 = MessageProtoCodec.a(localMessageHandler, (msg_comm.Msg)localObject3, String.valueOf(l3), String.valueOf(l3));
    long l1;
    if (((Long)((Pair)localObject2).first).longValue() != 4294967295L)
    {
      l1 = ((Long)((Pair)localObject2).first).longValue();
      if (l1 != -1L) {
        break label963;
      }
    }
    label897:
    label963:
    for (long l2 = 0L;; l2 = l1)
    {
      localObject2 = new ArrayList();
      if ((MessageUtils.c(j)) && (((msg_comm.MsgHead)localObject4).c2c_cmd.has()))
      {
        int k = ((msg_comm.MsgHead)localObject4).c2c_cmd.get();
        if ((k == 175) || (k == 11)) {
          MessageProtoCodec.a(localMessageHandler, (List)localObject2, (msg_comm.Msg)localObject3, true, false, null);
        }
        if ((((msg_comm.MsgHead)localObject4).from_nick.has()) && (paramHashMap != null)) {
          paramHashMap.put(String.valueOf(l3), ((msg_comm.MsgHead)localObject4).from_nick.get());
        }
        l1 = l3;
        label465:
        localObject3 = ((ArrayList)localObject2).iterator();
      }
      for (;;)
      {
        if (!((Iterator)localObject3).hasNext()) {
          break label876;
        }
        localObject4 = (MessageRecord)((Iterator)localObject3).next();
        ((MessageRecord)localObject4).time = l6;
        ((MessageRecord)localObject4).shmsgseq = l5;
        ((MessageRecord)localObject4).msgUid = l7;
        ((MessageRecord)localObject4).selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        ((MessageRecord)localObject4).senderuin = String.valueOf(l3);
        ((MessageRecord)localObject4).frienduin = String.valueOf(l1);
        ((MessageRecord)localObject4).vipBubbleID = l2;
        if ((j == 82) || (j == 43))
        {
          ((MessageRecord)localObject4).istroop = 1;
          continue;
          l1 = ((Long)((Pair)localObject2).second).longValue();
          break;
          if (((j == 82) || (j == 43)) && (((msg_comm.MsgHead)localObject4).group_info.has()))
          {
            l1 = ((msg_comm.MsgHead)localObject4).group_info.group_code.get();
            ((msg_comm.MsgHead)localObject4).group_info.group_code.get();
            MessageProtoCodec.a(localMessageHandler, (List)localObject2, (msg_comm.Msg)localObject3, false, false, null);
            if ((((msg_comm.MsgHead)localObject4).group_info.group_card.has()) && (paramHashMap != null)) {
              paramHashMap.put(String.valueOf(l3), ((msg_comm.MsgHead)localObject4).group_info.group_card.get().toStringUtf8());
            }
            break label465;
          }
          if (((j == 83) || (j == 42)) && (((msg_comm.MsgHead)localObject4).discuss_info.has()))
          {
            l1 = ((msg_comm.MsgHead)localObject4).discuss_info.discuss_uin.get();
            ((msg_comm.MsgHead)localObject4).discuss_info.discuss_uin.get();
            MessageProtoCodec.a(localMessageHandler, (List)localObject2, (msg_comm.Msg)localObject3, false, false, null);
            if ((((msg_comm.MsgHead)localObject4).discuss_info.discuss_remark.has()) && (paramHashMap != null)) {
              paramHashMap.put(String.valueOf(l3), ((msg_comm.MsgHead)localObject4).discuss_info.discuss_remark.get().toStringUtf8());
            }
            break label465;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MultiMsg", 2, "unpackPbToMultiMsg, illegal msgType:" + j);
          }
          return null;
        }
        if ((j == 83) || (j == 42)) {
          ((MessageRecord)localObject4).istroop = 3000;
        } else {
          ((MessageRecord)localObject4).istroop = 0;
        }
      }
      label876:
      MessageHandlerUtils.a((List)localObject2);
      paramArrayOfByte.addAll((Collection)localObject2);
      i += 1;
      break;
      if (!a(paramMessageRecord, paramArrayOfByte, null)) {
        return null;
      }
      l1 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg", 2, "unpackPbToMultiMsg, end unpack,endTime:" + l1 + " cost:" + (l1 - l4));
      }
      return paramArrayOfByte;
    }
  }
  
  public msg_comm.MsgHead a(MessageRecord paramMessageRecord, HashMap paramHashMap, boolean paramBoolean)
  {
    msg_comm.MsgHead localMsgHead = new msg_comm.MsgHead();
    localMsgHead.from_uin.set(Long.valueOf(paramMessageRecord.senderuin).longValue());
    localMsgHead.msg_seq.set((int)paramMessageRecord.shmsgseq);
    localMsgHead.msg_time.set((int)paramMessageRecord.time);
    localMsgHead.msg_uid.set(Long.valueOf(paramMessageRecord.msgUid).longValue());
    Object localObject = new msg_comm.MutilTransHead().status;
    int i;
    if (paramBoolean)
    {
      i = 0;
      ((PBUInt32Field)localObject).set(i);
      localMsgHead.mutiltrans_head.set(new msg_comm.MutilTransHead());
      if (paramMessageRecord.istroop != 0) {
        break label224;
      }
      localMsgHead.msg_type.set(9);
      if ((!(paramMessageRecord instanceof MessageForText)) && (!(paramMessageRecord instanceof MessageForStructing))) {
        break label196;
      }
      localMsgHead.c2c_cmd.set(11);
      label153:
      if ((paramHashMap == null) || (paramHashMap.get(paramMessageRecord.senderuin) == null)) {
        break label210;
      }
      localMsgHead.from_nick.set((String)paramHashMap.get(paramMessageRecord.senderuin));
    }
    for (;;)
    {
      return localMsgHead;
      i = -1;
      break;
      label196:
      localMsgHead.c2c_cmd.set(175);
      break label153;
      label210:
      localMsgHead.from_nick.set(" ");
    }
    label224:
    if (paramMessageRecord.istroop == 3000)
    {
      localMsgHead.msg_type.set(83);
      localObject = new msg_comm.DiscussInfo();
      ((msg_comm.DiscussInfo)localObject).discuss_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      if ((paramHashMap != null) && (paramHashMap.get(paramMessageRecord.senderuin) != null)) {
        ((msg_comm.DiscussInfo)localObject).discuss_remark.set(ByteStringMicro.copyFromUtf8((String)paramHashMap.get(paramMessageRecord.senderuin)));
      }
      for (;;)
      {
        localMsgHead.discuss_info.set((MessageMicro)localObject);
        break;
        ((msg_comm.DiscussInfo)localObject).discuss_remark.set(ByteStringMicro.copyFromUtf8(" "));
      }
    }
    if (paramMessageRecord.istroop == 1)
    {
      localMsgHead.msg_type.set(82);
      localObject = new msg_comm.GroupInfo();
      ((msg_comm.GroupInfo)localObject).group_code.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      if ((paramHashMap != null) && (paramHashMap.get(paramMessageRecord.senderuin) != null)) {
        ((msg_comm.GroupInfo)localObject).group_card.set(ByteStringMicro.copyFromUtf8((String)paramHashMap.get(paramMessageRecord.senderuin)));
      }
      for (;;)
      {
        localMsgHead.group_info.set((MessageMicro)localObject);
        break;
        ((msg_comm.GroupInfo)localObject).group_card.set(ByteStringMicro.copyFromUtf8(" "));
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg", 2, "MultiMsg:getMultiMsgHead, error:mr is not a C2C/dis/troop msg");
    }
    return null;
  }
  
  public im_msg_body.MsgBody a(MessageRecord paramMessageRecord)
  {
    int k = 0;
    Object localObject1;
    if ((paramMessageRecord.msgtype == -1000) || (paramMessageRecord.msgtype == -10000)) {
      localObject1 = MessageProtoCodec.a((MessageForText)paramMessageRecord);
    }
    for (;;)
    {
      Object localObject2;
      Card localCard;
      PBUInt32Field localPBUInt32Field;
      if ((localObject1 != null) && (!((im_msg_body.RichText)localObject1).elems.isEmpty()))
      {
        localObject2 = new im_msg_body.ElemFlags2();
        ((im_msg_body.ElemFlags2)localObject2).uint32_color_text_id.set((int)(paramMessageRecord.vipBubbleID & 0xFFFFFFFF));
        ((im_msg_body.Elem)((im_msg_body.RichText)localObject1).elems.get(0)).elem_flags2.set((MessageMicro)localObject2);
        if (paramMessageRecord.istroop == 1)
        {
          localObject2 = ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(paramMessageRecord.frienduin);
          if (localObject2 != null)
          {
            paramMessageRecord = new im_msg_body.PubGroup();
            localCard = (Card)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager().a(Card.class, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
            localPBUInt32Field = paramMessageRecord.uint32_age;
            if (localCard != null) {
              break label483;
            }
            i = k;
            label178:
            localPBUInt32Field.set(i);
            localPBUInt32Field = paramMessageRecord.uint32_gender;
            if (localCard != null) {
              break label492;
            }
          }
        }
      }
      label483:
      label492:
      for (int i = 2;; i = localCard.shGender)
      {
        localPBUInt32Field.set(i);
        paramMessageRecord.uint32_distance.set(((OpenTroopInfo)localObject2).troopDistance);
        localObject2 = new im_msg_body.Elem();
        ((im_msg_body.Elem)localObject2).pub_group.set(paramMessageRecord);
        ((im_msg_body.RichText)localObject1).elems.add((MessageMicro)localObject2);
        paramMessageRecord = new im_msg_body.MsgBody();
        paramMessageRecord.rich_text.set((MessageMicro)localObject1);
        return paramMessageRecord;
        if (paramMessageRecord.msgtype == -2000)
        {
          localObject1 = MessageProtoCodec.a((MessageForPic)paramMessageRecord);
          break;
        }
        if (paramMessageRecord.msgtype == -2011)
        {
          localObject1 = MessageProtoCodec.a((MessageForStructing)paramMessageRecord);
          break;
        }
        if (paramMessageRecord.msgtype != -1035) {
          break label501;
        }
        localObject2 = new im_msg_body.RichText();
        int m = ((MessageForMixedMsg)paramMessageRecord).msgElemList.size();
        i = 0;
        for (;;)
        {
          localObject1 = localObject2;
          if (i >= m) {
            break;
          }
          localObject1 = (MessageRecord)((MessageForMixedMsg)paramMessageRecord).msgElemList.get(i);
          if ((localObject1 instanceof MessageForText))
          {
            localObject1 = MessageProtoCodec.a((MessageForText)localObject1);
            if (localObject1 == null) {
              return null;
            }
            int j = 0;
            while (j < ((im_msg_body.RichText)localObject1).elems.size())
            {
              ((im_msg_body.RichText)localObject2).elems.add(((im_msg_body.RichText)localObject1).elems.get(j));
              j += 1;
            }
          }
          if ((localObject1 instanceof MessageForPic))
          {
            localObject1 = ((MessageForPic)localObject1).richText;
            if (localObject1 == null) {
              return null;
            }
            ((im_msg_body.RichText)localObject2).elems.add(((im_msg_body.RichText)localObject1).elems.get(0));
          }
          i += 1;
        }
        return null;
        i = localCard.age;
        break label178;
      }
      label501:
      localObject1 = null;
    }
  }
  
  protected void a() {}
  
  protected void a(String paramString1, int paramInt1, int paramInt2, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString, ProxyListener paramProxyListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramString1, paramInt1, "mr_multimessage", paramContentValues, paramString2, paramArrayOfString, 1, paramProxyListener);
  }
  
  protected void a(String paramString, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramString, paramInt, "mr_multimessage", "msgseq=?", new String[] { String.valueOf(paramLong) }, 2, null);
  }
  
  protected void a(String paramString1, int paramInt, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramString1, paramInt, "mr_multimessage", "selfuin=?", new String[] { paramString2 }, 2, null);
  }
  
  protected boolean a(MessageRecord paramMessageRecord, List paramList, ProxyListener paramProxyListener)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord1 = (MessageRecord)paramList.next();
      if (paramMessageRecord.senderuin.equals(localMessageRecord1.senderuin))
      {
        localMessageRecord1.issend = 1;
        localMessageRecord1.selfuin = localMessageRecord1.senderuin;
      }
      localMessageRecord1.msgseq = paramMessageRecord.uniseq;
      localMessageRecord1.isMultiMsg = true;
      if (localMessageRecord1.msgtype == -1035)
      {
        Iterator localIterator = ((MessageForMixedMsg)localMessageRecord1).msgElemList.iterator();
        while (localIterator.hasNext())
        {
          MessageRecord localMessageRecord2 = (MessageRecord)localIterator.next();
          localMessageRecord2.msgseq = localMessageRecord1.msgseq;
          localMessageRecord2.isMultiMsg = true;
        }
      }
      if (QLog.isColorLevel())
      {
        localMessageRecord1.toString();
        QLog.d("MultiMsg", 2, "AddMultiMsg,time:" + localMessageRecord1.time + " senderuin:" + localMessageRecord1.senderuin + " istroop:" + localMessageRecord1.istroop + " shmsgseq:" + localMessageRecord1.shmsgseq + " msgseq:" + localMessageRecord1.msgseq + " msgData:" + localMessageRecord1.msgData);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.c(localMessageRecord1.frienduin, localMessageRecord1.istroop, localMessageRecord1.getTableName(), localMessageRecord1, 0, paramProxyListener);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.c();
    return true;
  }
  
  protected boolean a(List paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      if (localMessageRecord == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg", 2, "checkMultiMsg, mr == null");
        }
        return false;
      }
      if (((localMessageRecord.istroop == 3000) || (localMessageRecord.istroop == 1)) && (localMessageRecord.shmsgseq <= 0L))
      {
        if (localMessageRecord.shmsgseq < 0L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MultiMsg", 2, "checkMultiMsg, shmsgseq < 0");
          }
          return false;
        }
        if (!MsgProxyUtils.i(localMessageRecord.msgtype))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MultiMsg", 2, "checkMultiMsg, shmsgseq=0 and msgtype:" + localMessageRecord.msgtype);
          }
          return false;
        }
      }
      if ((MsgProxyUtils.e(localMessageRecord.msgtype)) && (!MsgProxyUtils.a(localMessageRecord.frienduin, localMessageRecord.istroop)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg", 2, "checkMultiMsg, msgtype:" + localMessageRecord.msgtype + " frienduin:" + localMessageRecord.frienduin + " istroop:" + localMessageRecord.istroop);
        }
        return false;
      }
    }
    return true;
  }
  
  protected boolean a(List paramList, ProxyListener paramProxyListener)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramProxyListener = (MessageRecord)paramList.next();
      if (paramProxyListener.getStatus() == 1000) {
        this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.c(paramProxyListener.frienduin, paramProxyListener.istroop, paramProxyListener.getTableName(), paramProxyListener, 3, null);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.c(paramProxyListener.frienduin, paramProxyListener.istroop, paramProxyListener.getTableName(), paramProxyListener, 4, null);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.c();
    return true;
  }
  
  public byte[] a(MessageRecord paramMessageRecord, ArrayList paramArrayList, HashMap paramHashMap, boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg", 2, "packPbToMultiMsg, start pack, startTime:" + l1);
    }
    paramMessageRecord = new msg_transmit.PbMultiMsgTransmit();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramArrayList.next();
      msg_comm.Msg localMsg = new msg_comm.Msg();
      msg_comm.MsgHead localMsgHead = a(localMessageRecord, paramHashMap, paramBoolean);
      im_msg_body.MsgBody localMsgBody = a(localMessageRecord);
      if ((localMsgHead != null) && (localMsgBody != null))
      {
        localMsg.msg_head.set(localMsgHead);
        localMsg.msg_body.set(localMsgBody);
        paramMessageRecord.msg.add(localMsg);
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("MultiMsg", 2, "packPbFromMultiMsg, error:msg_head or msg_body is null,uniseq:" + localMessageRecord.uniseq);
      }
    }
    paramMessageRecord = a(paramMessageRecord.toByteArray());
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg", 2, "packPbToMultiMsg, end pack,endTime:" + l2 + " cost:" + (l2 - l1));
    }
    return paramMessageRecord;
  }
  
  /* Error */
  public byte[] a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +30 -> 33
    //   6: ldc 10
    //   8: iconst_2
    //   9: new 106	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 685
    //   19: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_1
    //   23: arraylength
    //   24: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   27: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: new 687	java/io/ByteArrayInputStream
    //   36: dup
    //   37: aload_1
    //   38: invokespecial 690	java/io/ByteArrayInputStream:<init>	([B)V
    //   41: astore 4
    //   43: new 692	java/io/ByteArrayOutputStream
    //   46: dup
    //   47: invokespecial 693	java/io/ByteArrayOutputStream:<init>	()V
    //   50: astore 5
    //   52: sipush 1024
    //   55: newarray byte
    //   57: astore_1
    //   58: new 695	java/util/zip/GZIPOutputStream
    //   61: dup
    //   62: aload 5
    //   64: invokespecial 698	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   67: astore_3
    //   68: aload 4
    //   70: aload_1
    //   71: iconst_0
    //   72: sipush 1024
    //   75: invokevirtual 702	java/io/ByteArrayInputStream:read	([BII)I
    //   78: istore_2
    //   79: iload_2
    //   80: iconst_m1
    //   81: if_icmpeq +65 -> 146
    //   84: aload_3
    //   85: aload_1
    //   86: iconst_0
    //   87: iload_2
    //   88: invokevirtual 706	java/util/zip/GZIPOutputStream:write	([BII)V
    //   91: goto -23 -> 68
    //   94: astore_3
    //   95: aconst_null
    //   96: astore_1
    //   97: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   100: ifeq +32 -> 132
    //   103: ldc 10
    //   105: iconst_2
    //   106: new 106	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   113: ldc_w 708
    //   116: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_3
    //   120: invokevirtual 711	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   123: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   132: aload 5
    //   134: invokevirtual 714	java/io/ByteArrayOutputStream:close	()V
    //   137: aload 4
    //   139: invokevirtual 715	java/io/ByteArrayInputStream:close	()V
    //   142: aload_1
    //   143: astore_3
    //   144: aload_3
    //   145: areturn
    //   146: aload_3
    //   147: invokevirtual 718	java/util/zip/GZIPOutputStream:flush	()V
    //   150: aload_3
    //   151: invokevirtual 719	java/util/zip/GZIPOutputStream:close	()V
    //   154: aload 5
    //   156: invokevirtual 720	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   159: astore_1
    //   160: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   163: ifeq +30 -> 193
    //   166: ldc 10
    //   168: iconst_2
    //   169: new 106	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   176: ldc_w 722
    //   179: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: aload_1
    //   183: arraylength
    //   184: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   187: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   193: aload 5
    //   195: invokevirtual 714	java/io/ByteArrayOutputStream:close	()V
    //   198: aload 4
    //   200: invokevirtual 715	java/io/ByteArrayInputStream:close	()V
    //   203: aload_1
    //   204: areturn
    //   205: astore 4
    //   207: aload_1
    //   208: astore_3
    //   209: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   212: ifeq -68 -> 144
    //   215: ldc 10
    //   217: iconst_2
    //   218: new 106	java/lang/StringBuilder
    //   221: dup
    //   222: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   225: ldc_w 724
    //   228: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: aload 4
    //   233: invokevirtual 725	java/io/IOException:getMessage	()Ljava/lang/String;
    //   236: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   245: aload_1
    //   246: areturn
    //   247: astore 4
    //   249: aload_1
    //   250: astore_3
    //   251: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   254: ifeq -110 -> 144
    //   257: ldc 10
    //   259: iconst_2
    //   260: new 106	java/lang/StringBuilder
    //   263: dup
    //   264: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   267: ldc_w 724
    //   270: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: aload 4
    //   275: invokevirtual 725	java/io/IOException:getMessage	()Ljava/lang/String;
    //   278: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   287: aload_1
    //   288: areturn
    //   289: astore_3
    //   290: aconst_null
    //   291: astore_1
    //   292: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   295: ifeq +32 -> 327
    //   298: ldc 10
    //   300: iconst_2
    //   301: new 106	java/lang/StringBuilder
    //   304: dup
    //   305: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   308: ldc_w 727
    //   311: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: aload_3
    //   315: invokevirtual 728	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   318: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   327: aload 5
    //   329: invokevirtual 714	java/io/ByteArrayOutputStream:close	()V
    //   332: aload 4
    //   334: invokevirtual 715	java/io/ByteArrayInputStream:close	()V
    //   337: aload_1
    //   338: areturn
    //   339: astore 4
    //   341: aload_1
    //   342: astore_3
    //   343: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   346: ifeq -202 -> 144
    //   349: ldc 10
    //   351: iconst_2
    //   352: new 106	java/lang/StringBuilder
    //   355: dup
    //   356: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   359: ldc_w 724
    //   362: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: aload 4
    //   367: invokevirtual 725	java/io/IOException:getMessage	()Ljava/lang/String;
    //   370: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   376: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   379: aload_1
    //   380: areturn
    //   381: astore_1
    //   382: aload 5
    //   384: invokevirtual 714	java/io/ByteArrayOutputStream:close	()V
    //   387: aload 4
    //   389: invokevirtual 715	java/io/ByteArrayInputStream:close	()V
    //   392: aload_1
    //   393: athrow
    //   394: astore_3
    //   395: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   398: ifeq -6 -> 392
    //   401: ldc 10
    //   403: iconst_2
    //   404: new 106	java/lang/StringBuilder
    //   407: dup
    //   408: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   411: ldc_w 724
    //   414: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: aload_3
    //   418: invokevirtual 725	java/io/IOException:getMessage	()Ljava/lang/String;
    //   421: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   427: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   430: goto -38 -> 392
    //   433: astore_3
    //   434: goto -142 -> 292
    //   437: astore_3
    //   438: goto -341 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	441	0	this	MultiMsgProxy
    //   0	441	1	paramArrayOfByte	byte[]
    //   78	10	2	i	int
    //   67	18	3	localGZIPOutputStream	java.util.zip.GZIPOutputStream
    //   94	26	3	localException1	Exception
    //   143	108	3	arrayOfByte1	byte[]
    //   289	26	3	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   342	1	3	arrayOfByte2	byte[]
    //   394	24	3	localIOException1	java.io.IOException
    //   433	1	3	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   437	1	3	localException2	Exception
    //   41	158	4	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   205	27	4	localIOException2	java.io.IOException
    //   247	86	4	localIOException3	java.io.IOException
    //   339	49	4	localIOException4	java.io.IOException
    //   50	333	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   52	68	94	java/lang/Exception
    //   68	79	94	java/lang/Exception
    //   84	91	94	java/lang/Exception
    //   146	160	94	java/lang/Exception
    //   193	203	205	java/io/IOException
    //   132	142	247	java/io/IOException
    //   52	68	289	java/lang/OutOfMemoryError
    //   68	79	289	java/lang/OutOfMemoryError
    //   84	91	289	java/lang/OutOfMemoryError
    //   146	160	289	java/lang/OutOfMemoryError
    //   327	337	339	java/io/IOException
    //   52	68	381	finally
    //   68	79	381	finally
    //   84	91	381	finally
    //   97	132	381	finally
    //   146	160	381	finally
    //   160	193	381	finally
    //   292	327	381	finally
    //   382	392	394	java/io/IOException
    //   160	193	433	java/lang/OutOfMemoryError
    //   160	193	437	java/lang/Exception
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager.a())) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager.a();
    }
  }
  
  /* Error */
  public byte[] b(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +30 -> 33
    //   6: ldc 10
    //   8: iconst_2
    //   9: new 106	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 732
    //   19: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_1
    //   23: arraylength
    //   24: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   27: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: new 687	java/io/ByteArrayInputStream
    //   36: dup
    //   37: aload_1
    //   38: invokespecial 690	java/io/ByteArrayInputStream:<init>	([B)V
    //   41: astore 4
    //   43: new 692	java/io/ByteArrayOutputStream
    //   46: dup
    //   47: invokespecial 693	java/io/ByteArrayOutputStream:<init>	()V
    //   50: astore 5
    //   52: sipush 1024
    //   55: newarray byte
    //   57: astore_1
    //   58: new 734	java/util/zip/GZIPInputStream
    //   61: dup
    //   62: aload 4
    //   64: invokespecial 737	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   67: astore_3
    //   68: aload_3
    //   69: aload_1
    //   70: iconst_0
    //   71: sipush 1024
    //   74: invokevirtual 738	java/util/zip/GZIPInputStream:read	([BII)I
    //   77: istore_2
    //   78: iload_2
    //   79: iconst_m1
    //   80: if_icmpeq +66 -> 146
    //   83: aload 5
    //   85: aload_1
    //   86: iconst_0
    //   87: iload_2
    //   88: invokevirtual 739	java/io/ByteArrayOutputStream:write	([BII)V
    //   91: goto -23 -> 68
    //   94: astore_3
    //   95: aconst_null
    //   96: astore_1
    //   97: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   100: ifeq +32 -> 132
    //   103: ldc 10
    //   105: iconst_2
    //   106: new 106	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   113: ldc_w 741
    //   116: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_3
    //   120: invokevirtual 711	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   123: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   132: aload 5
    //   134: invokevirtual 714	java/io/ByteArrayOutputStream:close	()V
    //   137: aload 4
    //   139: invokevirtual 715	java/io/ByteArrayInputStream:close	()V
    //   142: aload_1
    //   143: astore_3
    //   144: aload_3
    //   145: areturn
    //   146: aload_3
    //   147: invokevirtual 742	java/util/zip/GZIPInputStream:close	()V
    //   150: aload 5
    //   152: invokevirtual 720	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   155: astore_1
    //   156: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   159: ifeq +30 -> 189
    //   162: ldc 10
    //   164: iconst_2
    //   165: new 106	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   172: ldc_w 744
    //   175: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: aload_1
    //   179: arraylength
    //   180: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   183: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   189: aload 5
    //   191: invokevirtual 714	java/io/ByteArrayOutputStream:close	()V
    //   194: aload 4
    //   196: invokevirtual 715	java/io/ByteArrayInputStream:close	()V
    //   199: aload_1
    //   200: areturn
    //   201: astore 4
    //   203: aload_1
    //   204: astore_3
    //   205: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   208: ifeq -64 -> 144
    //   211: ldc 10
    //   213: iconst_2
    //   214: new 106	java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   221: ldc_w 746
    //   224: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: aload 4
    //   229: invokevirtual 725	java/io/IOException:getMessage	()Ljava/lang/String;
    //   232: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   241: aload_1
    //   242: areturn
    //   243: astore 4
    //   245: aload_1
    //   246: astore_3
    //   247: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   250: ifeq -106 -> 144
    //   253: ldc 10
    //   255: iconst_2
    //   256: new 106	java/lang/StringBuilder
    //   259: dup
    //   260: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   263: ldc_w 746
    //   266: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: aload 4
    //   271: invokevirtual 725	java/io/IOException:getMessage	()Ljava/lang/String;
    //   274: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   283: aload_1
    //   284: areturn
    //   285: astore_3
    //   286: aconst_null
    //   287: astore_1
    //   288: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   291: ifeq +32 -> 323
    //   294: ldc 10
    //   296: iconst_2
    //   297: new 106	java/lang/StringBuilder
    //   300: dup
    //   301: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   304: ldc_w 741
    //   307: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: aload_3
    //   311: invokevirtual 728	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   314: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   323: aload 5
    //   325: invokevirtual 714	java/io/ByteArrayOutputStream:close	()V
    //   328: aload 4
    //   330: invokevirtual 715	java/io/ByteArrayInputStream:close	()V
    //   333: aload_1
    //   334: areturn
    //   335: astore 4
    //   337: aload_1
    //   338: astore_3
    //   339: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   342: ifeq -198 -> 144
    //   345: ldc 10
    //   347: iconst_2
    //   348: new 106	java/lang/StringBuilder
    //   351: dup
    //   352: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   355: ldc_w 746
    //   358: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: aload 4
    //   363: invokevirtual 725	java/io/IOException:getMessage	()Ljava/lang/String;
    //   366: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   372: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   375: aload_1
    //   376: areturn
    //   377: astore_1
    //   378: aload 5
    //   380: invokevirtual 714	java/io/ByteArrayOutputStream:close	()V
    //   383: aload 4
    //   385: invokevirtual 715	java/io/ByteArrayInputStream:close	()V
    //   388: aload_1
    //   389: athrow
    //   390: astore_3
    //   391: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   394: ifeq -6 -> 388
    //   397: ldc 10
    //   399: iconst_2
    //   400: new 106	java/lang/StringBuilder
    //   403: dup
    //   404: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   407: ldc_w 746
    //   410: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: aload_3
    //   414: invokevirtual 725	java/io/IOException:getMessage	()Ljava/lang/String;
    //   417: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   423: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   426: goto -38 -> 388
    //   429: astore_3
    //   430: goto -142 -> 288
    //   433: astore_3
    //   434: goto -337 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	437	0	this	MultiMsgProxy
    //   0	437	1	paramArrayOfByte	byte[]
    //   77	11	2	i	int
    //   67	2	3	localGZIPInputStream	java.util.zip.GZIPInputStream
    //   94	26	3	localException1	Exception
    //   143	104	3	arrayOfByte1	byte[]
    //   285	26	3	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   338	1	3	arrayOfByte2	byte[]
    //   390	24	3	localIOException1	java.io.IOException
    //   429	1	3	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   433	1	3	localException2	Exception
    //   41	154	4	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   201	27	4	localIOException2	java.io.IOException
    //   243	86	4	localIOException3	java.io.IOException
    //   335	49	4	localIOException4	java.io.IOException
    //   50	329	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   52	68	94	java/lang/Exception
    //   68	78	94	java/lang/Exception
    //   83	91	94	java/lang/Exception
    //   146	156	94	java/lang/Exception
    //   189	199	201	java/io/IOException
    //   132	142	243	java/io/IOException
    //   52	68	285	java/lang/OutOfMemoryError
    //   68	78	285	java/lang/OutOfMemoryError
    //   83	91	285	java/lang/OutOfMemoryError
    //   146	156	285	java/lang/OutOfMemoryError
    //   323	333	335	java/io/IOException
    //   52	68	377	finally
    //   68	78	377	finally
    //   83	91	377	finally
    //   97	132	377	finally
    //   146	156	377	finally
    //   156	189	377	finally
    //   288	323	377	finally
    //   378	388	390	java/io/IOException
    //   156	189	429	java/lang/OutOfMemoryError
    //   156	189	433	java/lang/Exception
  }
  
  public void c()
  {
    SQLiteDatabase localSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localSQLiteDatabase == null) {}
    do
    {
      return;
      i = localSQLiteDatabase.a("mr_multimessage");
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg", 2, "checkMsgCounts, count:" + i);
      }
    } while (i <= 10000);
    int i = Math.max(i - 10000, 200);
    MessageRecord localMessageRecord = a(i);
    String str = String.format("delete from %s where _id in (select _id from %s order by _id limit %s)", new Object[] { "mr_multimessage", "mr_multimessage", Integer.valueOf(i) });
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg", 2, "checkMsgCounts, delNum:" + i + "mr.msgseq:" + localMessageRecord.msgseq);
    }
    try
    {
      localSQLiteDatabase.a(str);
      label158:
      a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.msgseq);
      return;
    }
    catch (Exception localException)
    {
      break label158;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.MultiMsgProxy
 * JD-Core Version:    0.7.0.1
 */