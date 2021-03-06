import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForHiBoom;
import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msgbackup.data.MsgBackupMsgEntity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.ContentHead;
import msf.msgcomm.msg_comm.DiscussInfo;
import msf.msgcomm.msg_comm.GroupInfo;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.msg.im_msg_body.AnonymousGroupMsg;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ElemFlags2;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.Ptt;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.Text;

public class ajes
  extends acxq
{
  public static long startTime;
  
  public ajes(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    super(paramQQAppInterface, paramProxyManager);
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    msg_comm.Msg localMsg = new msg_comm.Msg();
    if ((paramArrayOfByte == null) || (paramQQAppInterface == null)) {}
    try
    {
      if (!QLog.isColorLevel()) {
        break label1266;
      }
      QLog.d("MsgBackup_msgproxy", 2, "transToMessageRecord, extensionData is null");
    }
    catch (InvalidProtocolBufferMicroException paramQQAppInterface)
    {
      long l4;
      long l5;
      long l6;
      long l7;
      paramQQAppInterface.printStackTrace();
      return null;
    }
    localMsg.mergeFrom(paramArrayOfByte);
    paramArrayOfByte = (msg_comm.MsgHead)localMsg.msg_head.get();
    l4 = paramArrayOfByte.from_uin.get();
    long l3 = paramArrayOfByte.to_uin.get();
    l5 = paramArrayOfByte.msg_seq.get();
    l6 = paramArrayOfByte.msg_time.get();
    l7 = paramArrayOfByte.msg_uid.get();
    int k = paramArrayOfByte.msg_type.get();
    MessageHandler localMessageHandler = paramQQAppInterface.a();
    Object localObject2 = new Pair(Long.valueOf(-1L), Long.valueOf(-1L));
    long l1;
    ArrayList localArrayList;
    int i;
    if (((Long)((Pair)localObject2).first).longValue() != 4294967295L)
    {
      l1 = ((Long)((Pair)localObject2).first).longValue();
      break label1268;
      localArrayList = new ArrayList();
      if (((!anbk.lu(k)) && (k != 208) && (k != 529)) || (!paramArrayOfByte.c2c_cmd.has())) {
        break label562;
      }
      i = paramArrayOfByte.c2c_cmd.get();
      if ((k != 529) || (i != 4)) {
        break label1297;
      }
      if (c(localArrayList, localMsg)) {
        paramQQAppInterface.a().a().a(localArrayList, ((im_msg_body.MsgBody)localMsg.msg_body.get()).msg_content.get());
      }
    }
    label273:
    label311:
    label326:
    int j;
    for (;;)
    {
      if ((k == 208) && (c(localArrayList, localMsg)))
      {
        new anby().a(localMessageHandler, localMsg, localArrayList, null);
        break label1283;
        int m = anbh.a(localMsg);
        paramArrayOfByte = localArrayList.iterator();
        i = 0;
        if (paramArrayOfByte.hasNext())
        {
          localObject2 = (MessageRecord)paramArrayOfByte.next();
          ((MessageRecord)localObject2).time = l6;
          ((MessageRecord)localObject2).shmsgseq = l5;
          ((MessageRecord)localObject2).msgUid = l7;
          ((MessageRecord)localObject2).selfuin = paramQQAppInterface.getCurrentAccountUin();
          ((MessageRecord)localObject2).senderuin = String.valueOf(l4);
          ((MessageRecord)localObject2).frienduin = String.valueOf(l1);
          ((MessageRecord)localObject2).vipBubbleDiyTextId = m;
          Object localObject1;
          ((MessageRecord)localObject2).vipBubbleID = acle.g((int)localObject1, m);
          ((MessageRecord)localObject2).isread = true;
          if (l4 != paramQQAppInterface.getLongAccountUin()) {
            break label1345;
          }
          j = 1;
          label434:
          ((MessageRecord)localObject2).issend = j;
          if ((k != 82) && (k != 43)) {
            break label1350;
          }
          ((MessageRecord)localObject2).istroop = 1;
          label460:
          if (((MessageRecord)localObject2).senderuin.equals(((MessageRecord)localObject2).selfuin)) {
            ((MessageRecord)localObject2).issend = 1;
          }
          if ((((MessageRecord)localObject2).msgData != null) || (((MessageRecord)localObject2).msg == null)) {
            break label1290;
          }
          ((MessageRecord)localObject2).msgData = ((MessageRecord)localObject2).msg.getBytes();
          break label1290;
          l1 = ((Long)((Pair)localObject2).second).longValue();
          break label1268;
          label530:
          if (!c(localArrayList, localMsg)) {
            break label1311;
          }
          anbh.a(localMessageHandler, localArrayList, localMsg, true, false, null);
          continue;
          label562:
          if (((k != 82) && (k != 43)) || (!paramArrayOfByte.group_info.has())) {
            break label1323;
          }
          l1 = paramArrayOfByte.group_info.group_code.get();
          if (!c(localArrayList, localMsg)) {
            break label1256;
          }
          if (!paramQQAppInterface.a().a().a(localArrayList, localMsg)) {
            anbh.a(localMessageHandler, localArrayList, localMsg, false, false, null);
          }
          paramArrayOfByte = (im_msg_body.MsgBody)localMsg.msg_body.get();
          if (!paramArrayOfByte.rich_text.has()) {
            break label1320;
          }
          im_msg_body.RichText localRichText = (im_msg_body.RichText)paramArrayOfByte.rich_text.get();
          if (localRichText.elems.has())
          {
            paramArrayOfByte = localRichText.elems.get();
            if (paramArrayOfByte != null)
            {
              paramArrayOfByte = paramArrayOfByte.iterator();
              while (paramArrayOfByte.hasNext())
              {
                localObject2 = (im_msg_body.Elem)paramArrayOfByte.next();
                if (((im_msg_body.Elem)localObject2).anon_group_msg.has())
                {
                  localObject2 = (im_msg_body.AnonymousGroupMsg)((im_msg_body.Elem)localObject2).anon_group_msg.get();
                  i = ((im_msg_body.AnonymousGroupMsg)localObject2).uint32_flags.get();
                  paramArrayOfByte = ((im_msg_body.AnonymousGroupMsg)localObject2).str_anon_id.get().toByteArray();
                  byte[] arrayOfByte = ((im_msg_body.AnonymousGroupMsg)localObject2).str_anon_nick.get().toByteArray();
                  j = ((im_msg_body.AnonymousGroupMsg)localObject2).uint32_head_portrait.get();
                  m = ((im_msg_body.AnonymousGroupMsg)localObject2).uint32_expire_time.get();
                  String str = ((im_msg_body.AnonymousGroupMsg)localObject2).str_rank_color.get().toStringUtf8();
                  if (paramArrayOfByte == null) {
                    break label1313;
                  }
                  for (;;)
                  {
                    try
                    {
                      paramArrayOfByte = new String(paramArrayOfByte, "ISO-8859-1");
                      label828:
                      Iterator localIterator = localArrayList.iterator();
                      if (!localIterator.hasNext()) {
                        break;
                      }
                      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
                      if (arrayOfByte == null)
                      {
                        localObject2 = "";
                        localMessageRecord.saveExtInfoToExtStr("anonymous", jof.a(i, paramArrayOfByte, (String)localObject2, j, m, str));
                        localMessageRecord.extLong |= 0x3;
                      }
                      else
                      {
                        localObject2 = new String(arrayOfByte);
                      }
                    }
                    catch (UnsupportedEncodingException paramArrayOfByte)
                    {
                      paramArrayOfByte.printStackTrace();
                    }
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("anonymous_decode", 2, "anonymous_flags has = " + i);
                  }
                }
              }
            }
          }
          if (!localRichText.ptt.has()) {
            break label1320;
          }
          new anbu().a(localMessageHandler, localMsg, localArrayList, null);
          break label1320;
          label988:
          if (paramArrayOfByte.discuss_info.has())
          {
            l1 = paramArrayOfByte.discuss_info.discuss_uin.get();
            if (!c(localArrayList, localMsg)) {
              break label1253;
            }
            if (!paramQQAppInterface.a().a().b(localArrayList, localMsg)) {
              anbh.a(localMessageHandler, localArrayList, localMsg, false, false, null);
            }
            paramArrayOfByte = (im_msg_body.MsgBody)localMsg.msg_body.get();
            if ((!paramArrayOfByte.rich_text.has()) || (!((im_msg_body.RichText)paramArrayOfByte.rich_text.get()).ptt.has())) {
              break label1340;
            }
            new anbu().a(localMessageHandler, localMsg, localArrayList, null);
            break label1340;
          }
          label1110:
          if (!QLog.isColorLevel()) {
            break label1343;
          }
          QLog.d("MsgBackup_msgproxy", 2, "unpackPbToMultiMsgWithNest, illegal msgType:" + k);
          break label1343;
        }
      }
    }
    label1283:
    label1290:
    label1297:
    label1311:
    label1313:
    label1320:
    label1323:
    label1340:
    label1343:
    label1345:
    label1350:
    for (;;)
    {
      label1146:
      ((MessageRecord)localObject2).istroop = 3000;
      break label460;
      label1253:
      label1256:
      label1266:
      label1268:
      do
      {
        if (acbn.bkw.equals(Long.valueOf(l3)))
        {
          ((MessageRecord)localObject2).istroop = 6000;
          break label460;
        }
        if (acbn.bkx.equals(Long.valueOf(l3)))
        {
          ((MessageRecord)localObject2).istroop = 6003;
          break label460;
        }
        ((MessageRecord)localObject2).istroop = 0;
        break label460;
        achp.iZ(localArrayList);
        if (localArrayList.size() > 0) {
          return (MessageRecord)localArrayList.get(0);
        }
        ajgv.b("MsgBackup_msgproxy", "transToMessageRecord failed.........", new Object[0]);
        return null;
        break label311;
        break label311;
        do
        {
          l2 = l1;
          break;
          return null;
        } while (l1 != -1L);
        long l2 = 0L;
        break;
        l1 = l3;
        break label311;
        i += 1;
        break label326;
        if (i == 175) {
          break label530;
        }
        if (i != 11) {
          break label273;
        }
        break label530;
        break label273;
        paramArrayOfByte = "";
        break label828;
        break label311;
        if (k == 83) {
          break label988;
        }
        if (k != 42) {
          break label1110;
        }
        break label988;
        break label311;
        return null;
        j = 0;
        break label434;
        if (k == 83) {
          break label1146;
        }
      } while (k != 42);
    }
  }
  
  public static msg_comm.MsgHead a(MessageRecord paramMessageRecord, long paramLong)
  {
    msg_comm.MsgHead localMsgHead = new msg_comm.MsgHead();
    Object localObject = top.g(paramMessageRecord);
    for (;;)
    {
      try
      {
        long l1 = Long.valueOf((String)localObject).longValue();
        long l2 = Long.valueOf(paramMessageRecord.frienduin).longValue();
        localMsgHead.from_uin.set(l1);
        localMsgHead.to_uin.set(l2);
        localMsgHead.is_src_msg.set(paramMessageRecord.isReplySource);
        localMsgHead.msg_seq.set((int)paramMessageRecord.shmsgseq);
        localMsgHead.msg_time.set((int)paramMessageRecord.time);
        localMsgHead.msg_uid.set(Long.valueOf(paramMessageRecord.msgUid).longValue());
        if ((paramMessageRecord.istroop != 0) && (paramMessageRecord.istroop != 6000) && (paramMessageRecord.istroop != 6003) && (paramMessageRecord.istroop != 1000) && (paramMessageRecord.istroop != 1004) && (paramMessageRecord.istroop != 1022)) {
          break label311;
        }
        paramLong = f(paramLong, l1, l2);
        localMsgHead.to_uin.set(paramLong);
        if ((paramMessageRecord instanceof MessageForPtt))
        {
          localMsgHead.msg_type.set(208);
          if ((!(paramMessageRecord instanceof MessageForText)) && (!(paramMessageRecord instanceof MessageForStructing))) {
            break;
          }
          localMsgHead.c2c_cmd.set(11);
          break label446;
        }
        if ((paramMessageRecord instanceof MessageForFile)) {
          localMsgHead.msg_type.set(529);
        } else {
          localMsgHead.msg_type.set(9);
        }
      }
      catch (Exception paramMessageRecord)
      {
        QLog.e("MsgBackup_msgproxy", 1, paramMessageRecord, new Object[0]);
        return null;
      }
    }
    if ((paramMessageRecord instanceof MessageForFile))
    {
      localMsgHead.c2c_cmd.set(4);
    }
    else
    {
      localMsgHead.c2c_cmd.set(175);
      break label446;
      label311:
      if (paramMessageRecord.istroop == 3000)
      {
        localMsgHead.msg_type.set(83);
        localObject = new msg_comm.DiscussInfo();
        ((msg_comm.DiscussInfo)localObject).discuss_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
        localMsgHead.discuss_info.set((MessageMicro)localObject);
      }
      else if (paramMessageRecord.istroop == 1)
      {
        localMsgHead.msg_type.set(82);
        localObject = new msg_comm.GroupInfo();
        ((msg_comm.GroupInfo)localObject).group_code.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
        localMsgHead.group_info.set((MessageMicro)localObject);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_msgproxy", 2, "getMultiMsgHead, error:mr is not a C2C/dis/troop msg");
        }
        return null;
      }
    }
    label446:
    return localMsgHead;
  }
  
  public static im_msg_body.MsgBody a(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if ((paramMessageRecord.msgtype == -1000) || (paramMessageRecord.msgtype == -10000)) {
      if (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("sens_msg_source_msg_info"))) {
        paramQQAppInterface = anbh.a(paramMessageRecord);
      }
    }
    label965:
    for (;;)
    {
      if ((paramQQAppInterface != null) && (!paramQQAppInterface.elems.isEmpty()))
      {
        Object localObject1 = new im_msg_body.ElemFlags2();
        ((im_msg_body.ElemFlags2)localObject1).uint32_color_text_id.set((int)(paramMessageRecord.vipBubbleID & 0xFFFFFFFF));
        Object localObject2 = new im_msg_body.Elem();
        ((im_msg_body.Elem)localObject2).elem_flags2.set((MessageMicro)localObject1);
        paramQQAppInterface.elems.add((MessageMicro)localObject2);
        if (jof.a(paramMessageRecord))
        {
          localObject1 = new im_msg_body.Elem();
          localObject2 = new im_msg_body.AnonymousGroupMsg();
          jof.a locala = jof.a(paramMessageRecord);
          ((im_msg_body.AnonymousGroupMsg)localObject2).uint32_flags.set(locala.flags);
          if (!TextUtils.isEmpty(locala.TF)) {
            ((im_msg_body.AnonymousGroupMsg)localObject2).str_anon_id.set(ByteStringMicro.copyFrom(locala.TF.getBytes()));
          }
          if (!TextUtils.isEmpty(locala.TG)) {
            ((im_msg_body.AnonymousGroupMsg)localObject2).str_anon_nick.set(ByteStringMicro.copyFrom(locala.TG.getBytes()));
          }
          ((im_msg_body.AnonymousGroupMsg)localObject2).uint32_head_portrait.set(locala.aCv);
          ((im_msg_body.AnonymousGroupMsg)localObject2).uint32_expire_time.set(locala.expire_time);
          if (!TextUtils.isEmpty(locala.TH)) {
            ((im_msg_body.AnonymousGroupMsg)localObject2).str_rank_color.set(ByteStringMicro.copyFrom(locala.TH.getBytes()));
          }
          ((im_msg_body.AnonymousGroupMsg)localObject2).uint32_bubble_id.set((int)paramMessageRecord.vipBubbleID);
          ((im_msg_body.Elem)localObject1).anon_group_msg.set((MessageMicro)localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("anonymous_decode", 2, "anonymous_addd anon_group_msg = ");
          }
          paramQQAppInterface.elems.add((MessageMicro)localObject1);
        }
        paramMessageRecord = new im_msg_body.MsgBody();
        paramMessageRecord.rich_text.set(paramQQAppInterface);
        return paramMessageRecord;
        paramQQAppInterface = anbh.a((MessageForText)paramMessageRecord);
        continue;
        if (paramMessageRecord.msgtype == -1049)
        {
          paramQQAppInterface = anbh.a((MessageForReplyText)paramMessageRecord);
          continue;
        }
        if (paramMessageRecord.msgtype == -2005) {
          return paramQQAppInterface.a().a().a(2, paramMessageRecord);
        }
        if (paramMessageRecord.msgtype == -2017) {
          return paramQQAppInterface.a().a().a(2, paramMessageRecord);
        }
        if (paramMessageRecord.msgtype == -2052)
        {
          paramQQAppInterface = anbh.a((MessageForQQStoryComment)paramMessageRecord);
          continue;
        }
        if (paramMessageRecord.msgtype == -2000)
        {
          paramQQAppInterface = anbh.a((MessageForPic)paramMessageRecord);
          continue;
        }
        if (paramMessageRecord.msgtype == -5008)
        {
          paramQQAppInterface = anbh.a((MessageForArkApp)paramMessageRecord, true);
          continue;
        }
        if (paramMessageRecord.msgtype == -5016)
        {
          paramQQAppInterface = anbh.c((MessageForArkBabyqReply)paramMessageRecord, true);
          continue;
        }
        if (paramMessageRecord.msgtype == -5017)
        {
          paramQQAppInterface = anbh.b((MessageForArkApp)paramMessageRecord, true);
          continue;
        }
        if (paramMessageRecord.msgtype == -5013)
        {
          paramQQAppInterface = anbh.c((MessageForArkFlashChat)paramMessageRecord);
          continue;
        }
        if (paramMessageRecord.msgtype == -5014)
        {
          paramQQAppInterface = anbh.d((MessageForHiBoom)paramMessageRecord);
          continue;
        }
        if (paramMessageRecord.msgtype == -2011)
        {
          paramQQAppInterface = anbh.a((MessageForStructing)paramMessageRecord);
          if (paramQQAppInterface != null) {
            break label965;
          }
          return null;
        }
        if (paramMessageRecord.msgtype == -1035)
        {
          paramQQAppInterface = new im_msg_body.RichText();
          int k = ((MessageForMixedMsg)paramMessageRecord).msgElemList.size();
          int i = 0;
          while (i < k)
          {
            localObject1 = (MessageRecord)((MessageForMixedMsg)paramMessageRecord).msgElemList.get(i);
            if ((localObject1 instanceof MessageForText))
            {
              localObject1 = anbh.a((MessageForText)localObject1);
              if (localObject1 == null) {
                return null;
              }
              int j = 0;
              while (j < ((im_msg_body.RichText)localObject1).elems.size())
              {
                paramQQAppInterface.elems.add(((im_msg_body.RichText)localObject1).elems.get(j));
                j += 1;
              }
            }
            if ((localObject1 instanceof MessageForRichText))
            {
              localObject1 = ((MessageForPic)localObject1).richText;
              if (localObject1 == null) {
                return null;
              }
              paramQQAppInterface.elems.add(((im_msg_body.RichText)localObject1).elems.get(0));
            }
            i += 1;
          }
          continue;
        }
        if (paramMessageRecord.msgtype == -1051)
        {
          paramQQAppInterface = anbh.a((MessageForLongTextMsg)paramMessageRecord, false);
          continue;
        }
        if (paramMessageRecord.msgtype == -2022)
        {
          if ((paramMessageRecord instanceof MessageForRichText)) {
            paramQQAppInterface = ((MessageForRichText)paramMessageRecord).richText;
          }
        }
        else if (paramMessageRecord.msgtype == -2002)
        {
          if ((paramMessageRecord instanceof MessageForRichText)) {
            paramQQAppInterface = ((MessageForRichText)paramMessageRecord).richText;
          }
        }
        else
        {
          if (paramMessageRecord.msgtype == -2071)
          {
            paramQQAppInterface = ((MessageForLightVideo)paramMessageRecord).richText;
            continue;
          }
          if (paramMessageRecord.msgtype == -2007)
          {
            paramQQAppInterface = anbh.a((MessageForMarketFace)paramMessageRecord);
            continue;
          }
          if ((paramMessageRecord.msgtype == -2059) && (!TextUtils.isEmpty(paramMessageRecord.msg)))
          {
            paramQQAppInterface = new im_msg_body.RichText();
            localObject1 = new im_msg_body.Elem();
            localObject2 = new im_msg_body.Text();
            ((im_msg_body.Text)localObject2).str.set(ByteStringMicro.copyFromUtf8(paramMessageRecord.msg));
            ((im_msg_body.Elem)localObject1).text.set((MessageMicro)localObject2);
            paramQQAppInterface.elems.add((MessageMicro)localObject1);
          }
        }
      }
      else
      {
        return null;
      }
      paramQQAppInterface = null;
    }
  }
  
  public static byte[] a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    msg_comm.Msg localMsg = new msg_comm.Msg();
    msg_comm.MsgHead localMsgHead = a(paramMessageRecord, paramQQAppInterface.getLongAccountUin());
    try
    {
      paramQQAppInterface = a(paramMessageRecord, paramQQAppInterface);
      if ((localMsgHead == null) || (paramQQAppInterface == null)) {
        return null;
      }
    }
    catch (Throwable paramQQAppInterface)
    {
      for (;;)
      {
        QLog.e("MsgBackup_msgproxy", 1, "transToBackupEntity,getMsgBody error mr = " + paramMessageRecord.getClass().getSimpleName());
        annt.e(paramQQAppInterface, "MsgBackup_msgproxy,mr = " + paramMessageRecord.getClass().getSimpleName());
        paramQQAppInterface = null;
      }
      if (localMsgHead != null) {
        localMsg.msg_head.set(localMsgHead);
      }
      if (paramQQAppInterface != null) {
        localMsg.msg_body.set(paramQQAppInterface);
      }
    }
    return localMsg.toByteArray();
  }
  
  private static boolean c(ArrayList<MessageRecord> paramArrayList, msg_comm.Msg paramMsg)
  {
    return (paramMsg.msg_body.has()) && ((((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has()) || (((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has()));
  }
  
  public static long e(long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramLong2 == paramLong1) {
      return paramLong3;
    }
    return paramLong2;
  }
  
  public static long f(long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramLong3 == paramLong2) {
      return paramLong1;
    }
    return paramLong3;
  }
  
  public MessageRecord a(@NonNull MsgBackupMsgEntity paramMsgBackupMsgEntity)
  {
    msg_comm.Msg localMsg = new msg_comm.Msg();
    long l5;
    int i1;
    Object localObject4;
    Object localObject5;
    long l1;
    int i;
    label436:
    label469:
    int k;
    int j;
    label531:
    int n;
    label686:
    label722:
    label1255:
    Object localObject3;
    for (;;)
    {
      MessageHandler localMessageHandler;
      long l3;
      try
      {
        if (paramMsgBackupMsgEntity.extensionData == null)
        {
          if (!QLog.isColorLevel()) {
            break label1566;
          }
          QLog.d("MsgBackup_msgproxy", 2, "transToMessageRecord, extensionData is null");
          break label1566;
        }
        localMsg.mergeFrom(paramMsgBackupMsgEntity.extensionData);
        if ((!localMsg.msg_body.has()) || ((!((im_msg_body.MsgBody)localMsg.msg_body.get()).rich_text.has()) && (!((im_msg_body.MsgBody)localMsg.msg_body.get()).msg_content.has())))
        {
          if (!QLog.isColorLevel()) {
            break label1568;
          }
          QLog.d("MsgBackup_msgproxy", 2, "transToMessageRecord, no msg_body or rich_text, msg_body.has():" + localMsg.msg_body.has());
          break label1568;
        }
        localObject2 = (msg_comm.MsgHead)localMsg.msg_head.get();
        long l4 = ((msg_comm.MsgHead)localObject2).from_uin.get();
        l5 = ((msg_comm.MsgHead)localObject2).to_uin.get();
        long l6 = ((msg_comm.MsgHead)localObject2).msg_seq.get();
        long l7 = ((msg_comm.MsgHead)localObject2).msg_time.get();
        long l8 = ((msg_comm.MsgHead)localObject2).msg_uid.get();
        i1 = ((msg_comm.MsgHead)localObject2).msg_type.get();
        boolean bool = ((msg_comm.MsgHead)localObject2).is_src_msg.get();
        localObject4 = new aozx();
        ((aozx)localObject4).uinType = ajgv.fk(paramMsgBackupMsgEntity.chatType);
        localMessageHandler = this.app.a();
        localObject5 = anbh.a(localMessageHandler, localMsg, String.valueOf(l5), String.valueOf(l4));
        if (((Long)((Pair)localObject5).first).longValue() != 4294967295L)
        {
          l1 = ((Long)((Pair)localObject5).first).longValue();
          break label1570;
          localObject5 = new ArrayList();
          if (((!anbk.lu(i1)) && (i1 != 208) && (i1 != 529)) || (!((msg_comm.MsgHead)localObject2).c2c_cmd.has())) {
            break label817;
          }
          l3 = e(this.app.getLongAccountUin(), l4, l5);
          i = ((msg_comm.MsgHead)localObject2).c2c_cmd.get();
          if ((i1 != 529) || (i != 4)) {
            break label1585;
          }
          l1 = System.currentTimeMillis();
          this.app.a().a().a((ArrayList)localObject5, ((im_msg_body.MsgBody)localMsg.msg_body.get()).msg_content.get());
          startTime += System.currentTimeMillis() - l1;
          l1 = l3;
          if (i1 == 208)
          {
            new anby().a(localMessageHandler, localMsg, (List)localObject5, null);
            l1 = l3;
          }
          int m = 0;
          int i2 = anbh.a(localMsg);
          if (!localMsg.content_head.has()) {
            break label1549;
          }
          localObject2 = (msg_comm.ContentHead)localMsg.content_head.get();
          k = ((msg_comm.ContentHead)localObject2).div_seq.get();
          j = ((msg_comm.ContentHead)localObject2).pkg_num.get();
          i = ((msg_comm.ContentHead)localObject2).pkg_index.get();
          localObject2 = ((ArrayList)localObject5).iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject4 = (MessageRecord)((Iterator)localObject2).next();
          ((MessageRecord)localObject4).isReplySource = bool;
          ((MessageRecord)localObject4).time = l7;
          ((MessageRecord)localObject4).shmsgseq = l6;
          ((MessageRecord)localObject4).msgUid = l8;
          ((MessageRecord)localObject4).selfuin = this.app.getCurrentAccountUin();
          ((MessageRecord)localObject4).senderuin = String.valueOf(l4);
          ((MessageRecord)localObject4).frienduin = String.valueOf(l1);
          ((MessageRecord)localObject4).vipBubbleDiyTextId = i2;
          Object localObject1;
          ((MessageRecord)localObject4).vipBubbleID = acle.g((int)localObject1, i2);
          ((MessageRecord)localObject4).isread = true;
          if (j > 1)
          {
            ((MessageRecord)localObject4).longMsgCount = j;
            ((MessageRecord)localObject4).longMsgId = k;
            ((MessageRecord)localObject4).longMsgIndex = i;
          }
          if (l4 != this.app.getLongAccountUin()) {
            break label1631;
          }
          n = 2;
          ((MessageRecord)localObject4).issend = n;
          if ((i1 != 82) && (i1 != 43)) {
            break label1637;
          }
          ((MessageRecord)localObject4).istroop = 1;
          ((MessageRecord)localObject4).shmsgseq = paramMsgBackupMsgEntity.msgSeq;
          if ((((MessageRecord)localObject4).msgData == null) && (((MessageRecord)localObject4).msg != null)) {
            ((MessageRecord)localObject4).msgData = ((MessageRecord)localObject4).msg.getBytes();
          }
          ((MessageRecord)localObject4).msgBackupMsgSeq = paramMsgBackupMsgEntity.msgSeq;
          ((MessageRecord)localObject4).msgBackupMsgRandom = paramMsgBackupMsgEntity.msgRandom;
          m += 1;
          continue;
        }
        l1 = ((Long)((Pair)localObject5).second).longValue();
      }
      catch (InvalidProtocolBufferMicroException paramMsgBackupMsgEntity)
      {
        label794:
        paramMsgBackupMsgEntity.printStackTrace();
        return null;
      }
      anbh.a(localMessageHandler, (List)localObject5, localMsg, true, false, (aozx)localObject4);
      continue;
      label817:
      if (((i1 != 82) && (i1 != 43)) || (!((msg_comm.MsgHead)localObject2).group_info.has())) {
        break label1612;
      }
      l1 = ((msg_comm.MsgHead)localObject2).group_info.group_code.get();
      if (!this.app.a().a().a((ArrayList)localObject5, localMsg)) {
        anbh.a(localMessageHandler, (List)localObject5, localMsg, false, false, (aozx)localObject4);
      }
      Object localObject2 = (im_msg_body.MsgBody)localMsg.msg_body.get();
      if (!((im_msg_body.MsgBody)localObject2).rich_text.has()) {
        break label1609;
      }
      im_msg_body.RichText localRichText = (im_msg_body.RichText)((im_msg_body.MsgBody)localObject2).rich_text.get();
      if (localRichText.elems.has())
      {
        localObject2 = localRichText.elems.get();
        if (localObject2 != null)
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject4 = (im_msg_body.Elem)((Iterator)localObject2).next();
            if (((im_msg_body.Elem)localObject4).anon_group_msg.has())
            {
              localObject4 = (im_msg_body.AnonymousGroupMsg)((im_msg_body.Elem)localObject4).anon_group_msg.get();
              i = ((im_msg_body.AnonymousGroupMsg)localObject4).uint32_flags.get();
              localObject2 = ((im_msg_body.AnonymousGroupMsg)localObject4).str_anon_id.get().toByteArray();
              byte[] arrayOfByte = ((im_msg_body.AnonymousGroupMsg)localObject4).str_anon_nick.get().toByteArray();
              j = ((im_msg_body.AnonymousGroupMsg)localObject4).uint32_head_portrait.get();
              k = ((im_msg_body.AnonymousGroupMsg)localObject4).uint32_expire_time.get();
              String str = ((im_msg_body.AnonymousGroupMsg)localObject4).str_rank_color.get().toStringUtf8();
              if (localObject2 == null) {
                break label1601;
              }
              for (;;)
              {
                try
                {
                  localObject2 = new String((byte[])localObject2, "ISO-8859-1");
                  label1092:
                  Iterator localIterator = ((ArrayList)localObject5).iterator();
                  if (!localIterator.hasNext()) {
                    break;
                  }
                  MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
                  if (arrayOfByte == null)
                  {
                    localObject4 = "";
                    localMessageRecord.saveExtInfoToExtStr("anonymous", jof.a(i, (String)localObject2, (String)localObject4, j, k, str));
                    localMessageRecord.extLong |= 0x3;
                  }
                  else
                  {
                    localObject4 = new String(arrayOfByte);
                  }
                }
                catch (UnsupportedEncodingException localUnsupportedEncodingException)
                {
                  localUnsupportedEncodingException.printStackTrace();
                }
              }
              if (QLog.isColorLevel()) {
                QLog.d("anonymous_decode", 2, "anonymous_flags has = " + i);
              }
            }
          }
        }
      }
      if (!localRichText.ptt.has()) {
        break label1609;
      }
      new anbu().a(localMessageHandler, localMsg, (List)localObject5, null);
      break label1609;
      if (localUnsupportedEncodingException.discuss_info.has())
      {
        l3 = localUnsupportedEncodingException.discuss_info.discuss_uin.get();
        if (!this.app.a().a().b((ArrayList)localObject5, localMsg)) {
          anbh.a(localMessageHandler, (List)localObject5, localMsg, false, false, (aozx)localObject4);
        }
        localObject3 = (im_msg_body.MsgBody)localMsg.msg_body.get();
        l1 = l3;
        if (((im_msg_body.MsgBody)localObject3).rich_text.has())
        {
          l1 = l3;
          if (((im_msg_body.RichText)((im_msg_body.MsgBody)localObject3).rich_text.get()).ptt.has())
          {
            new anbu().a(localMessageHandler, localMsg, (List)localObject5, null);
            l1 = l3;
          }
        }
      }
      else
      {
        label1388:
        if (!QLog.isColorLevel()) {
          break label1629;
        }
        QLog.d("MsgBackup_msgproxy", 2, "unpackPbToMultiMsgWithNest, illegal msgType:" + i1);
        break label1629;
      }
    }
    for (;;)
    {
      label1424:
      ((MessageRecord)localObject4).istroop = 3000;
      ((MessageRecord)localObject4).shmsgseq = paramMsgBackupMsgEntity.msgSeq;
      break label722;
      label1549:
      label1566:
      label1568:
      label1570:
      label1585:
      label1601:
      label1609:
      label1612:
      label1629:
      label1631:
      label1637:
      do
      {
        if (acbn.bkw.equals(Long.valueOf(l5))) {
          ((MessageRecord)localObject4).istroop = 6000;
        }
        for (;;)
        {
          ((MessageRecord)localObject4).msgseq = paramMsgBackupMsgEntity.msgSeq;
          break;
          if (acbn.bkx.equals(Long.valueOf(l5))) {
            ((MessageRecord)localObject4).istroop = 6003;
          } else {
            ((MessageRecord)localObject4).istroop = 0;
          }
        }
        achp.iZ((List)localObject5);
        if (((ArrayList)localObject5).size() > 0) {
          return (MessageRecord)((ArrayList)localObject5).get(0);
        }
        ajgv.b("MsgBackup_msgproxy", "transToMessageRecord failed.........", new Object[0]);
        return null;
        i = 0;
        k = 0;
        j = 0;
        break label531;
        do
        {
          l2 = l1;
          break;
          return null;
          return null;
        } while (l1 != -1L);
        long l2 = 0L;
        break;
        if (i == 175) {
          break label794;
        }
        if (i != 11) {
          break label436;
        }
        break label794;
        localObject3 = "";
        break label1092;
        break label469;
        if (i1 == 83) {
          break label1255;
        }
        if (i1 != 42) {
          break label1388;
        }
        break label1255;
        return null;
        n = 0;
        break label686;
        if (i1 == 83) {
          break label1424;
        }
      } while (i1 != 42);
    }
  }
  
  public MsgBackupMsgEntity a(@NonNull MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return null;
    }
    if ((paramMessageRecord.istroop == 1) && (paramMessageRecord.shmsgseq == 0L)) {
      QLog.e("MsgBackup_msgproxy", 1, "troopMsg msgshseq = 0,mr  == " + paramMessageRecord.toString());
    }
    msg_comm.Msg localMsg = new msg_comm.Msg();
    Object localObject1;
    if (paramMessageRecord.isLongMsg())
    {
      localObject1 = new msg_comm.ContentHead();
      ((msg_comm.ContentHead)localObject1).pkg_num.set(paramMessageRecord.longMsgCount);
      ((msg_comm.ContentHead)localObject1).div_seq.set(paramMessageRecord.longMsgId);
      ((msg_comm.ContentHead)localObject1).pkg_index.set(paramMessageRecord.longMsgIndex);
      localMsg.content_head.set((MessageMicro)localObject1);
    }
    msg_comm.MsgHead localMsgHead = a(paramMessageRecord, this.app.getLongAccountUin());
    Object localObject2;
    try
    {
      localObject1 = a(paramMessageRecord, this.app);
      if ((localMsgHead == null) || (localObject1 == null))
      {
        ajgv.b("transBackupEntity error,mr = %s ", paramMessageRecord.toString(), new Object[0]);
        return null;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("MsgBackup_msgproxy", 1, "transToBackupEntity,getMsgBody error mr = " + paramMessageRecord.getClass().getSimpleName());
        annt.e(localThrowable, "MsgBackup_msgproxy,mr = " + paramMessageRecord.getClass().getSimpleName());
        localObject2 = null;
      }
      localMsg.msg_head.set(localMsgHead);
      localMsg.msg_body.set((MessageMicro)localObject2);
      localObject2 = new MsgBackupMsgEntity();
      ((MsgBackupMsgEntity)localObject2).chatUin = paramMessageRecord.frienduin;
      ((MsgBackupMsgEntity)localObject2).chatType = ajgv.cS(paramMessageRecord.istroop);
      ((MsgBackupMsgEntity)localObject2).msgType = ajgv.hW(paramMessageRecord.msgtype);
      ((MsgBackupMsgEntity)localObject2).msgTime = paramMessageRecord.time;
      ((MsgBackupMsgEntity)localObject2).msgSeq = paramMessageRecord.msgseq;
      if (paramMessageRecord.istroop == 1) {
        break label324;
      }
    }
    label324:
    int i;
    if (paramMessageRecord.istroop == 3000)
    {
      ((MsgBackupMsgEntity)localObject2).msgSeq = paramMessageRecord.shmsgseq;
      if (!ajgv.coy) {
        break label413;
      }
      i = localMsg.getSerializedSize();
      paramMessageRecord = ajej.getByteArray(i);
      if (paramMessageRecord != null) {
        break label402;
      }
      paramMessageRecord = localMsg.toByteArray();
      ajej.bj(paramMessageRecord);
    }
    label363:
    for (((MsgBackupMsgEntity)localObject2).extensionData = paramMessageRecord;; ((MsgBackupMsgEntity)localObject2).extensionData = localMsg.toByteArray())
    {
      return localObject2;
      i = anbk.ac(paramMessageRecord.msgUid);
      ((MsgBackupMsgEntity)localObject2).msgSeq = (0xFFFF & (short)(int)paramMessageRecord.shmsgseq);
      ((MsgBackupMsgEntity)localObject2).msgRandom = i;
      break;
      localMsg.toByteArray(paramMessageRecord, 0, i);
      break label363;
    }
  }
  
  protected void destory() {}
  
  protected void init() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajes
 * JD-Core Version:    0.7.0.1
 */