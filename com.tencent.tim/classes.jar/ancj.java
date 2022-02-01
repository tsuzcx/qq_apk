import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import localpb.richMsg.RichMsg.PicRec;
import localpb.richMsg.RichMsg.PttRec;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.NotOnlineFile;
import tencent.im.msg.im_msg_body.RichText;

public class ancj
  implements anbs
{
  private void a(MessageHandler paramMessageHandler, List<MessageRecord> paramList, int paramInt1, msg_comm.Msg paramMsg, long paramLong1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, long paramLong2, boolean paramBoolean4, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder("<---decodeC2CMsgPkg_OfflineFile : ");
    localStringBuilder.append(" c2cCmd:").append(paramInt1).append(";friendUin:").append(paramLong1).append(";isReaded:").append(paramBoolean1).append(";isPullRoam:").append(paramBoolean2).append(";isSelfSender:").append(paramBoolean3).append(";\n");
    long l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
    long l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
    int i = (short)((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has())) {
      if (QLog.isColorLevel()) {
        QLog.e("OfflineFileDecoder", 2, "<---decodeC2CMsgPkg_OfflineFile return null:hasBody:" + paramMsg.msg_body.has() + "hasRichT:" + ((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has());
      }
    }
    label904:
    label1118:
    for (;;)
    {
      return;
      Object localObject1 = (im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get();
      Object localObject2 = (im_msg_body.NotOnlineFile)((im_msg_body.RichText)localObject1).not_online_file.get();
      if (!((im_msg_body.RichText)localObject1).not_online_file.has())
      {
        localStringBuilder.append("hasNotOnlineFile:").append(((im_msg_body.RichText)localObject1).not_online_file.has()).append(";hasUUID:").append(((im_msg_body.NotOnlineFile)localObject2).bytes_file_uuid.has());
        if (QLog.isColorLevel()) {
          QLog.d("OfflineFileDecoder", 2, localStringBuilder.toString());
        }
      }
      else if ((paramInt1 == 169) || (paramInt1 == 243))
      {
        if (!paramBoolean4)
        {
          if (QLog.isColorLevel()) {
            QLog.d("OfflineFileDecoder", 2, "<FileAssistant>offlineFile come: c2cCmd[" + paramInt1 + "]");
          }
          paramMessageHandler.app.a().a(paramMessageHandler, paramList, paramMsg, (im_msg_body.NotOnlineFile)localObject2, String.valueOf(paramLong1), paramBoolean1, paramBoolean2, paramLong2, paramInt2, null);
        }
      }
      else
      {
        paramMsg = null;
        String str = new String(((im_msg_body.NotOnlineFile)localObject2).bytes_file_uuid.get().toStringUtf8() + l1);
        localObject1 = ((im_msg_body.NotOnlineFile)localObject2).bytes_file_uuid.get().toStringUtf8();
        localStringBuilder.append("     NotOnLineFile info : serverPath:").append((String)localObject1).append(";fileKey :").append(str).append(";");
        if (!paramMessageHandler.a().kJ(str))
        {
          str = ((im_msg_body.NotOnlineFile)localObject2).bytes_file_name.get().toStringUtf8();
          localStringBuilder.append("strFileName:").append(str).append(";");
          paramLong1 = ((im_msg_body.NotOnlineFile)localObject2).uint64_file_size.get();
          if ((paramInt1 == 241) || (anbk.ah(str, paramInt1)))
          {
            paramMessageHandler = new RichMsg.PicRec();
            paramMessageHandler.localPath.set((String)localObject1);
            paramMessageHandler.size.set(paramLong1);
            paramMessageHandler.type.set(1);
            paramMessageHandler.isRead.set(false);
            paramMessageHandler.uuid.set((String)localObject1);
            paramMessageHandler.serverStorageSource.set("ftn");
            paramMessageHandler.version.set(5);
            paramMessageHandler.isReport.set(0);
            paramMsg = (MessageForPic)anbi.d(-2000);
            paramMsg.msgtype = -2000;
            paramMsg.msgData = paramMessageHandler.toByteArray();
            paramMsg.parse();
            paramList.add(paramMsg);
            paramMsg = null;
            localStringBuilder.append("protocolStr:").append(paramMsg).append(";");
          }
        }
        for (;;)
        {
          if (!QLog.isColorLevel()) {
            break label1118;
          }
          QLog.d("OfflineFileDecoder", 2, localStringBuilder.toString());
          return;
          if ((paramInt1 != 242) && (!anbk.ai(str, paramInt1))) {
            break;
          }
          if ((str != null) && (!str.equals("")))
          {
            if (!str.contains("_")) {}
            for (paramMsg = str.substring(0, str.length() - 4);; paramMsg = str.substring(str.lastIndexOf("_") + 1, str.length() - 4))
            {
              paramMsg = l2 + paramMsg;
              localStringBuilder.append("c2cCmd:0xf2;key:").append(paramMsg).append(";");
              if (paramBoolean4) {
                break label904;
              }
              if (!anqo.pC(paramMsg)) {
                break;
              }
              localStringBuilder.append("DuplicateKey:").append(paramMsg).append(";");
              if (QLog.isColorLevel()) {
                QLog.d("OfflineFileDecoder", 2, localStringBuilder.toString());
              }
              anqo.pB(paramMsg);
              return;
            }
            anqo.pA(paramMsg);
          }
          for (;;)
          {
            paramMsg = aoon.a((String)localObject1, paramLong1, 2, false, (String)localObject1, null, "ftn");
            localObject2 = new RichMsg.PttRec();
            ((RichMsg.PttRec)localObject2).localPath.set((String)localObject1);
            ((RichMsg.PttRec)localObject2).size.set(paramLong1);
            ((RichMsg.PttRec)localObject2).type.set(2);
            ((RichMsg.PttRec)localObject2).uuid.set((String)localObject1);
            ((RichMsg.PttRec)localObject2).isRead.set(false);
            ((RichMsg.PttRec)localObject2).serverStorageSource.set("ftn");
            ((RichMsg.PttRec)localObject2).isReport.set(0);
            ((RichMsg.PttRec)localObject2).version.set(5);
            paramLong1 = System.currentTimeMillis() / 1000L;
            ((RichMsg.PttRec)localObject2).msgRecTime.set(paramLong1);
            ((RichMsg.PttRec)localObject2).msgTime.set(l1);
            localObject1 = (MessageForPtt)anbi.d(-2002);
            ((MessageForPtt)localObject1).msgtype = -2002;
            ((MessageForPtt)localObject1).msgData = ((RichMsg.PttRec)localObject2).toByteArray();
            ((MessageForPtt)localObject1).parse();
            paramList.add(localObject1);
            aomq.b(paramMessageHandler.app, 1, false, 4);
            break;
            if (QLog.isColorLevel()) {
              QLog.d("OfflineFileDecoder", 2, "offline ptt no filename");
            }
          }
          localStringBuilder.append("rcv a repeated offline file push msg");
        }
      }
    }
  }
  
  public void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, anax paramanax)
  {
    long l1 = paramMsg.msg_head.from_uin.get();
    int i = paramMsg.msg_head.c2c_cmd.get();
    long l2 = paramanax.friendUin;
    boolean bool2 = paramanax.isRead;
    boolean bool3 = paramanax.cEC;
    if (l1 == paramanax.akr) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      a(paramMessageHandler, paramList, i, paramMsg, l2, bool2, bool3, bool1, paramanax.vipBubbleID, paramanax.cEE, paramanax.dEN);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ancj
 * JD-Core Version:    0.7.0.1
 */