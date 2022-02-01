import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.data.MessageRecord;>;
import localpb.richMsg.RichMsg.PttRec;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.cs.ptt_reserve.ptt_reserve.ReserveStruct;
import tencent.im.cs.ptt_waveform.ptt_waveform.PttWaveform;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ElemFlags2;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.NearByMessageType;
import tencent.im.msg.im_msg_body.Ptt;
import tencent.im.msg.im_msg_body.PubGroup;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.Text;

public class anbu
  implements anbs
{
  private int f(msg_comm.Msg paramMsg)
  {
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has())) {
      return 0;
    }
    paramMsg = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get().iterator();
    while (paramMsg.hasNext())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)paramMsg.next();
      if ((localElem.elem_flags2.has()) && (((im_msg_body.ElemFlags2)localElem.elem_flags2.get()).uint32_vip_status.has()))
      {
        int i = ((im_msg_body.ElemFlags2)localElem.elem_flags2.get()).uint32_vip_status.get();
        if (i == 1) {
          return 1;
        }
        if (i == 2) {
          return 2;
        }
      }
    }
    return 0;
  }
  
  public void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, anax paramanax)
  {
    im_msg_body.Ptt localPtt = (im_msg_body.Ptt)((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).ptt.get();
    String str2 = localPtt.bytes_file_name.get().toStringUtf8();
    Object localObject2 = "";
    paramanax = null;
    int m;
    int i4;
    int j;
    boolean bool;
    long l2;
    long l3;
    long l4;
    long l5;
    long l6;
    Object localObject1;
    int n;
    label205:
    int i;
    long l1;
    if (str2.endsWith(".amr"))
    {
      if (!anvq.bD(paramMessageHandler.app)) {
        break label1237;
      }
      m = 1;
      i4 = f(paramMsg);
      j = localPtt.uint32_file_type.get();
      bool = localPtt.bool_valid.get();
      l2 = localPtt.uint64_src_uin.get();
      l3 = localPtt.uint32_file_size.get();
      l4 = localPtt.uint32_file_id.get() & 0xFFFFFFFF;
      l5 = localPtt.uint32_server_ip.get();
      l6 = localPtt.uint32_server_port.get();
      localObject1 = localPtt.bytes_file_uuid.get().toByteArray();
      paramanax = localPtt.bytes_file_md5.get().toByteArray();
      if (!localPtt.uint32_format.has()) {
        break label1243;
      }
      n = localPtt.uint32_format.get();
      if (!localPtt.uint32_time.has()) {
        break label1249;
      }
      i = localPtt.uint32_time.get();
      l1 = aqlv.kh(i);
      if (!localPtt.bytes_down_para.has()) {
        break label2561;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SPD", 2, "receive ptt msg , bytes_down_para has ! " + localPtt.bytes_down_para.get());
      }
      localObject4 = localPtt.bytes_down_para.get();
      if (localObject4 == null) {
        break label2561;
      }
    }
    label2561:
    for (Object localObject4 = ((ByteStringMicro)localObject4).toStringUtf8();; localObject4 = "")
    {
      if (QLog.isColorLevel()) {
        QLog.d("SPD", 2, "receive ptt msg , url : " + (String)localObject4 + " srcuin " + l2 + "filename" + str2);
      }
      if (QLog.isColorLevel()) {
        QLog.d("RecordParams", 2, "<---decodeGrpDisMsgPkg_PTT voiceType：" + n + " voiceLengh:" + l1);
      }
      localObject1 = aqhs.bytes2HexStr((byte[])localObject1);
      Object localObject5 = aqhs.bytes2HexStr(paramanax);
      if (localPtt.bytes_group_file_key.has()) {}
      for (paramanax = localPtt.bytes_group_file_key.get().toByteArray();; paramanax = null) {
        try
        {
          paramanax = new String(paramanax, "utf-8");
          if (localObject5 == null)
          {
            localObject5 = "";
            if (QLog.isColorLevel())
            {
              localObject6 = new StringBuilder("<---decodeSinglePbMsg_GroupDis:");
              ((StringBuilder)localObject6).append(" pttType:").append(j).append(" isValid:").append(bool).append(" srcUin:").append(l2).append(" fileSize:").append(l3 & 0xFFFFFFFF).append(" fileID").append(l4).append(" serverIP:").append(l5 & 0xFFFFFFFF).append(" serverPort:").append(l6 & 0xFFFFFFFF).append(" fileName:").append(str2).append(" uuidStr:").append((String)localObject1).append(" md5Str:").append((String)localObject5).append(" GrpFileKey:").append(paramanax);
              QLog.d("GrpDisPTTDecoder", 2, ((StringBuilder)localObject6).toString());
            }
            i1 = 0;
            int i2 = 0;
            int i3 = 0;
            String str1 = "";
            if (localPtt.bytes_pb_reserve.has())
            {
              ptt_reserve.ReserveStruct localReserveStruct = new ptt_reserve.ReserveStruct();
              k = i3;
              j = i2;
              i = i1;
              localObject1 = localObject2;
              try
              {
                localReserveStruct.mergeFrom(localPtt.bytes_pb_reserve.get().toByteArray());
                k = i3;
                j = i2;
                i = i1;
                localObject1 = localObject2;
                i1 = localReserveStruct.uint32_change_voice.get();
                k = i3;
                j = i2;
                i = i1;
                localObject1 = localObject2;
                i2 = localReserveStruct.uint32_redpack_type.get();
                k = i3;
                j = i2;
                i = i1;
                localObject1 = localObject2;
                i3 = localReserveStruct.uint32_autototext_voice.get();
                k = i3;
                j = i2;
                i = i1;
                localObject1 = localObject2;
                localObject6 = localReserveStruct.bytes_voice_text_abs.get().toStringUtf8();
                localObject2 = str1;
                k = i3;
                j = i2;
                i = i1;
                localObject1 = localObject6;
                if (localReserveStruct.bytes_redpack_score_id.has())
                {
                  k = i3;
                  j = i2;
                  i = i1;
                  localObject1 = localObject6;
                  localObject2 = localReserveStruct.bytes_redpack_score_id.get().toStringUtf8();
                }
                localObject1 = localObject2;
                i = i3;
                j = i2;
                k = i1;
                localObject2 = localObject6;
              }
              catch (Exception localException)
              {
                do
                {
                  for (;;)
                  {
                    localObject6 = "";
                    i1 = i;
                    localObject3 = localObject1;
                    localObject1 = localObject6;
                    i = k;
                    k = i1;
                  }
                  localObject4 = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get();
                  localObject3 = new StringBuilder();
                  if ((localObject4 != null) && (((List)localObject4).size() > 0)) {
                    break;
                  }
                } while (!QLog.isColorLevel());
                ((StringBuilder)localObject3).append("elems:null || elems.size() <= 0");
                QLog.d("GrpDisPTTDecoder", 2, ((StringBuilder)localObject3).toString());
                return;
                if (!QLog.isColorLevel()) {
                  break label1402;
                }
                ((StringBuilder)localObject3).append("elemsSize").append(((List)localObject4).size()).append("\n");
                i = 0;
              }
              aoon.a(str2, 0L, 2, false, str2);
              localObject6 = new RichMsg.PttRec();
              ((RichMsg.PttRec)localObject6).localPath.set(str2);
              ((RichMsg.PttRec)localObject6).size.set(localPtt.uint32_file_size.get());
              ((RichMsg.PttRec)localObject6).type.set(2);
              ((RichMsg.PttRec)localObject6).uuid.set(str2);
              ((RichMsg.PttRec)localObject6).isRead.set(false);
              ((RichMsg.PttRec)localObject6).md5.set((String)localObject5);
              ((RichMsg.PttRec)localObject6).isReport.set(0);
              ((RichMsg.PttRec)localObject6).version.set(5);
              ((RichMsg.PttRec)localObject6).groupFileID.set(l4);
              ((RichMsg.PttRec)localObject6).pttFlag.set(m);
              ((RichMsg.PttRec)localObject6).longPttVipFlag.set(i4);
              if (paramanax != null) {
                ((RichMsg.PttRec)localObject6).group_file_key.set(paramanax);
              }
              l2 = System.currentTimeMillis() / 1000L;
              l3 = paramMsg.msg_head.msg_time.get();
              ((RichMsg.PttRec)localObject6).msgRecTime.set(l2);
              ((RichMsg.PttRec)localObject6).msgTime.set(l3);
              ((RichMsg.PttRec)localObject6).voiceType.set(n);
              ((RichMsg.PttRec)localObject6).voiceLength.set(aqft.ag(l1));
              ((RichMsg.PttRec)localObject6).voiceChangeFlag.set(k);
              ((RichMsg.PttRec)localObject6).directUrl.set((String)localObject4);
              ((RichMsg.PttRec)localObject6).redpack_type.set(j);
              ((RichMsg.PttRec)localObject6).autototext_voice.set(i);
              ((RichMsg.PttRec)localObject6).sttText.set((String)localObject2);
              paramanax = anbi.d(-2002);
              paramanax.msgtype = -2002;
              paramanax.msgData = ((RichMsg.PttRec)localObject6).toByteArray();
              ((MessageForPtt)paramanax).parse();
              paramList.add(paramanax);
              localObject2 = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get();
              new anbg().P((List)localObject2, paramList);
              aagm.d((String)localObject1, paramanax);
              if (paramanax == null)
              {
                return;
                label1237:
                m = 0;
                break;
                label1243:
                n = 0;
                break label205;
                label1249:
                i = 0;
              }
            }
          }
        }
        catch (UnsupportedEncodingException paramanax)
        {
          for (;;)
          {
            Object localObject6;
            int i1;
            int k;
            paramanax = null;
            continue;
            Object localObject3;
            for (;;)
            {
              label1402:
              if (i >= ((List)localObject4).size()) {
                break label2095;
              }
              localObject5 = (im_msg_body.Elem)((List)localObject4).get(i);
              if (((im_msg_body.Elem)localObject5).near_by_msg.has())
              {
                if (QLog.isColorLevel()) {
                  ((StringBuilder)localObject3).append("elemType: near_by_msg;");
                }
                paramList = ((im_msg_body.Elem)localObject5).near_by_msg;
                if ((paramList.uint32_identify_type.has()) && (paramList.uint32_identify_type.get() == 1))
                {
                  paramanax.saveExtInfoToExtStr("identify_flag", "true");
                  if (QLog.isColorLevel()) {
                    ((StringBuilder)localObject3).append("has identify;");
                  }
                }
              }
              for (;;)
              {
                if ((!((im_msg_body.Elem)localObject5).general_flags.has()) || (!((im_msg_body.Elem)localObject5).general_flags.bytes_pb_reserve.has())) {
                  break label2078;
                }
                paramList = new generalflags.ResvAttr();
                try
                {
                  paramList.mergeFrom(((im_msg_body.Elem)localObject5).general_flags.bytes_pb_reserve.get().toByteArray());
                  if (paramList.uint32_holiday_flag.has())
                  {
                    j = paramList.uint32_holiday_flag.get();
                    if (j == 1) {
                      paramanax.saveExtInfoToExtStr(anbb.ccL, String.valueOf(j));
                    }
                    if (QLog.isColorLevel()) {
                      QLog.i("GrpDisPTTDecoder", 2, "decodeGrpDisMsgPkg_PTT uint32_holiday_flag = " + j);
                    }
                  }
                  bool = paramList.bytes_pb_ptt_waveform.has();
                  if (!bool) {}
                }
                catch (Exception paramList)
                {
                  for (;;)
                  {
                    label2047:
                    paramList.printStackTrace();
                  }
                }
                try
                {
                  localObject1 = new ptt_waveform.PttWaveform();
                  ((ptt_waveform.PttWaveform)localObject1).mergeFrom(paramList.bytes_pb_ptt_waveform.get().toByteArray());
                  ((MessageForPtt)paramanax).waveformArray = aqjh.a((ptt_waveform.PttWaveform)localObject1);
                  if (QLog.isColorLevel())
                  {
                    paramList = new StringBuilder();
                    localObject1 = ((MessageForPtt)paramanax).waveformArray;
                    k = localObject1.length;
                    j = 0;
                    for (;;)
                    {
                      if (j < k)
                      {
                        paramList.append(localObject1[j]);
                        paramList.append(";");
                        j += 1;
                        continue;
                        if (((im_msg_body.Elem)localObject5).pub_group.has())
                        {
                          paramList = (im_msg_body.PubGroup)((im_msg_body.Elem)localObject5).pub_group.get();
                          if (paramList == null) {
                            break;
                          }
                          j = paramList.uint32_gender.get();
                          localObject1 = paramList.bytes_nickname.get().toStringUtf8();
                          paramanax.saveExtInfoToExtStr("hotchat_gender", String.valueOf(j));
                          paramList = (List<MessageRecord>)localObject1;
                          if (localObject1 == null) {
                            paramList = "";
                          }
                          paramanax.saveExtInfoToExtStr("hotchat_nick", paramList);
                          if (!QLog.isColorLevel()) {
                            break;
                          }
                          ((StringBuilder)localObject3).append("has pub_group;");
                          break;
                        }
                        if ((((im_msg_body.Elem)localObject5).general_flags.has()) && (((im_msg_body.GeneralFlags)((im_msg_body.Elem)localObject5).general_flags.get()).uint32_olympic_torch.has()))
                        {
                          j = ((im_msg_body.Elem)localObject5).general_flags.uint32_olympic_torch.get();
                          if (QLog.isColorLevel()) {
                            ((StringBuilder)localObject3).append("has olympicTorch:").append(j).append(";");
                          }
                          if (j <= 0) {
                            break;
                          }
                          paramanax.saveExtInfoToExtStr("olympic_torch_flg", j + "");
                          break;
                        }
                        if ((!((im_msg_body.Elem)localObject5).common_elem.has()) || (13 != ((im_msg_body.Elem)localObject5).common_elem.uint32_service_type.get())) {
                          break;
                        }
                        if (QLog.isColorLevel()) {
                          ((StringBuilder)localObject3).append("decodeGrpDisMsgPkg_PTT decode hummer_commelem == UpdateStrangerAvatar");
                        }
                        new anbg().a((List)localObject4, paramMsg, (StringBuilder)localObject3);
                        break;
                      }
                    }
                    QLog.d("GrpDisPTTDecoder", 2, "decodeGrpDisMsgPkg_PTT, waveformArray = " + paramList.toString());
                  }
                }
                catch (Throwable paramList)
                {
                  break label2047;
                }
              }
              if ((((MessageForPtt)paramanax).waveformArray == null) || (((MessageForPtt)paramanax).waveformArray.length == 0)) {
                ((MessageForPtt)paramanax).buileDefaultWaveform();
              }
              label2078:
              i += 1;
            }
            label2095:
            i = 0;
            for (;;)
            {
              if (i < ((List)localObject4).size())
              {
                paramList = (im_msg_body.Elem)((List)localObject4).get(i);
                if (paramList.general_flags.bytes_pb_reserve.has()) {
                  localObject1 = new generalflags.ResvAttr();
                }
                try
                {
                  ((generalflags.ResvAttr)localObject1).mergeFrom(paramList.general_flags.bytes_pb_reserve.get().toByteArray());
                  if (((generalflags.ResvAttr)localObject1).uint32_robot_msg_flag.has())
                  {
                    j = ((generalflags.ResvAttr)localObject1).uint32_robot_msg_flag.get();
                    paramanax.mRobotFlag = j;
                    if (QLog.isColorLevel()) {
                      QLog.d("GrpDisPTTDecoder", 2, "handleGeneralSettingFlags uint32_robot_msg_flag = " + j);
                    }
                  }
                  i += 1;
                }
                catch (InvalidProtocolBufferMicroException paramList)
                {
                  for (;;)
                  {
                    paramList.printStackTrace();
                  }
                }
              }
            }
            bool = ((aptw)paramMessageHandler.app.getManager(203)).cR(((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get());
            if ((paramanax.mRobotFlag == 1) || (paramanax.mRobotFlag == 2) || (bool))
            {
              localObject1 = ((List)localObject4).iterator();
              label2484:
              label2489:
              while (((Iterator)localObject1).hasNext())
              {
                paramList = (im_msg_body.Elem)((Iterator)localObject1).next();
                if (paramList.text.has())
                {
                  paramList = (im_msg_body.Text)paramList.text.get();
                  if (paramList.attr_6_buf.has())
                  {
                    paramList = paramList.attr_6_buf.get();
                    if (paramList != null) {}
                    for (paramList = paramList.toByteArray();; paramList = null)
                    {
                      if ((paramList == null) || (paramList.length == 0)) {
                        break label2489;
                      }
                      k = aqoj.b(paramList, 0);
                      j = 2;
                      i = 0;
                      for (;;)
                      {
                        if ((i >= k) || (j >= 2048)) {
                          break label2484;
                        }
                        localObject4 = new MessageForText.AtTroopMemberInfo();
                        if (!((MessageForText.AtTroopMemberInfo)localObject4).readFrom(paramList, j)) {
                          break;
                        }
                        j += ((MessageForText.AtTroopMemberInfo)localObject4).length();
                        i = (short)(i + 1);
                        if (paramanax.atInfoList == null) {
                          paramanax.atInfoList = new ArrayList();
                        }
                        paramanax.atInfoList.add(localObject4);
                      }
                      break;
                    }
                  }
                }
              }
              ((MessageForPtt)paramanax).parse();
            }
            aegu.a(paramMsg, paramanax, paramMessageHandler.app);
            if (QLog.isColorLevel())
            {
              QLog.d("GrpDisPTTDecoder", 2, ((StringBuilder)localObject3).toString());
              return;
              localObject1 = "";
              i = 0;
              j = 0;
              k = 0;
              localObject3 = "";
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anbu
 * JD-Core Version:    0.7.0.1
 */