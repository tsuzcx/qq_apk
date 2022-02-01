import android.os.Bundle;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TransFileInfo;
import com.tencent.mobileqq.filemanager.data.FMTransC2CMsgInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Random;
import msf.msgsvc.msg_ctrl.MsgCtrl;
import msf.msgsvc.msg_ctrl.ResvResvInfo;
import msf.msgsvc.msg_svc.AccostTmp;
import msf.msgsvc.msg_svc.AddressListTmp;
import msf.msgsvc.msg_svc.BusinessWPATmp;
import msf.msgsvc.msg_svc.CommTmp;
import msf.msgsvc.msg_svc.DisTmp;
import msf.msgsvc.msg_svc.GrpTmp;
import msf.msgsvc.msg_svc.NearByDatingTmp;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import msf.msgsvc.msg_svc.PbSendMsgResp;
import msf.msgsvc.msg_svc.RoutingHead;
import msf.msgsvc.msg_svc.Trans0x211;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.Trans211TmpMsg;

public class acrc
  extends tnv
{
  ArrayList<String> tU = new ArrayList(20);
  
  public acrc(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, anbd.a parama)
  {
    if (parama == null) {
      aA(paramToServiceMsg, paramFromServiceMsg);
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("wk", 2, "onReceive, MessageConstants.CMD_TRANSSERVICE_REQOFFFILEPACK: " + parama.bx);
      }
      if (parama.bx == 6)
      {
        e(paramToServiceMsg, paramFromServiceMsg, parama);
        return;
      }
      if (parama.bx == 3)
      {
        d(paramToServiceMsg, paramFromServiceMsg, parama);
        return;
      }
      if (parama.bx == 2)
      {
        c(paramToServiceMsg, paramFromServiceMsg, parama);
        return;
      }
    } while (parama.bx != 1);
    b(paramToServiceMsg, paramFromServiceMsg, parama);
  }
  
  private void a(msg_svc.PbSendMsgReq paramPbSendMsgReq, FMTransC2CMsgInfo paramFMTransC2CMsgInfo)
  {
    if (paramFMTransC2CMsgInfo.entity == null) {
      if (QLog.isColorLevel()) {
        QLog.i("IMG_FILE_QR", 1, "add image QrInfo , info is null, maybe is not qr image");
      }
    }
    for (;;)
    {
      return;
      paramFMTransC2CMsgInfo = ahwo.a(paramFMTransC2CMsgInfo.entity.getFilePath(), paramFMTransC2CMsgInfo.entity.imgWidth, paramFMTransC2CMsgInfo.entity.imgHeight, paramFMTransC2CMsgInfo.entity.strQRUrl);
      if (paramFMTransC2CMsgInfo != null)
      {
        paramPbSendMsgReq.msg_ctrl.set(paramFMTransC2CMsgInfo);
        try
        {
          if (QLog.isColorLevel())
          {
            if (paramFMTransC2CMsgInfo.resv_resv_info.has())
            {
              QLog.i("IMG_FILE_QR", 1, "reqFeeds with ImageInfo has uint32_flag:" + ((msg_ctrl.ResvResvInfo)paramFMTransC2CMsgInfo.resv_resv_info.get()).uint32_flag.get());
              QLog.i("IMG_FILE_QR", 1, "reqFeeds with ImageInfo has uint64_reserv2:" + ((msg_ctrl.ResvResvInfo)paramFMTransC2CMsgInfo.resv_resv_info.get()).uint64_reserv2.get());
              QLog.i("IMG_FILE_QR", 1, "reqFeeds with ImageInfo has uint64_reserv3:" + ((msg_ctrl.ResvResvInfo)paramFMTransC2CMsgInfo.resv_resv_info.get()).uint64_reserv3.get());
              QLog.i("IMG_FILE_QR", 1, "reqFeeds with ImageInfo has uint32_create_time:" + ((msg_ctrl.ResvResvInfo)paramFMTransC2CMsgInfo.resv_resv_info.get()).uint32_create_time.get());
              QLog.i("IMG_FILE_QR", 1, "reqFeeds with ImageInfo has uint32_pic_width:" + ((msg_ctrl.ResvResvInfo)paramFMTransC2CMsgInfo.resv_resv_info.get()).uint32_pic_width.get());
              QLog.i("IMG_FILE_QR", 1, "reqFeeds with ImageInfo has uint32_pic_height:" + ((msg_ctrl.ResvResvInfo)paramFMTransC2CMsgInfo.resv_resv_info.get()).uint32_pic_height.get());
              return;
            }
            QLog.i("IMG_FILE_QR", 1, "eqFeeds without ImageInfo");
            return;
          }
        }
        catch (Throwable paramPbSendMsgReq) {}
      }
    }
  }
  
  private void a(msg_svc.PbSendMsgReq paramPbSendMsgReq, FMTransC2CMsgInfo paramFMTransC2CMsgInfo, anbn paramanbn)
  {
    long l1 = 0L;
    if ((paramFMTransC2CMsgInfo == null) || (paramFMTransC2CMsgInfo.entity == null)) {
      return;
    }
    paramFMTransC2CMsgInfo = paramFMTransC2CMsgInfo.entity;
    msg_svc.RoutingHead localRoutingHead = paramPbSendMsgReq.routing_head;
    int i = (int)paramFMTransC2CMsgInfo.tmpSessionType;
    switch (i)
    {
    default: 
      return;
    case 100: 
      localRoutingHead.accost_tmp.to_uin.set(Long.parseLong(paramFMTransC2CMsgInfo.peerUin));
      if ((paramFMTransC2CMsgInfo.tmpSessionSig != null) && (paramFMTransC2CMsgInfo.tmpSessionSig.length > 0)) {
        localRoutingHead.accost_tmp.sig.set(ByteStringMicro.copyFrom(paramFMTransC2CMsgInfo.tmpSessionSig));
      }
      localRoutingHead.accost_tmp.setHasFlag(true);
      localRoutingHead.setHasFlag(true);
    }
    for (;;)
    {
      if ((paramanbn != null) && (paramanbn.msg != null)) {
        break label790;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("Q.msg.BaseMessageProcessor", 2, "tmpsession Bug msgContext or msgContext.msg null!");
      return;
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg.BaseMessageProcessor", 2, "addTempSessionData add disctmp Info");
      }
      long l2;
      try
      {
        l2 = Long.parseLong(paramFMTransC2CMsgInfo.tmpSessionRelatedUin);
        l1 = l2;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          QLog.e("Q.msg.BaseMessageProcessor", 1, "case to long faild, relatedUin[" + paramFMTransC2CMsgInfo.tmpSessionRelatedUin + "]");
        }
      }
      localRoutingHead.dis_tmp.dis_uin.set(l1);
      localRoutingHead.dis_tmp.to_uin.set(Long.parseLong(paramFMTransC2CMsgInfo.peerUin));
      localRoutingHead.dis_tmp.setHasFlag(true);
      localRoutingHead.setHasFlag(true);
      continue;
      try
      {
        l2 = Long.parseLong(paramFMTransC2CMsgInfo.tmpSessionRelatedUin);
        l1 = l2;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          QLog.e("Q.msg.BaseMessageProcessor", 1, "case to long faild, relatedUin[" + paramFMTransC2CMsgInfo.tmpSessionRelatedUin + "]");
        }
      }
      localRoutingHead.grp_tmp.group_uin.set(l1);
      localRoutingHead.grp_tmp.to_uin.set(Long.parseLong(paramFMTransC2CMsgInfo.peerUin));
      localRoutingHead.grp_tmp.setHasFlag(true);
      localRoutingHead.setHasFlag(true);
      continue;
      localRoutingHead.comm_tmp.to_uin.set(Long.parseLong(paramFMTransC2CMsgInfo.peerUin));
      if ((paramFMTransC2CMsgInfo.tmpSessionSig != null) && (paramFMTransC2CMsgInfo.tmpSessionSig.length > 0)) {
        localRoutingHead.comm_tmp.sig.set(ByteStringMicro.copyFrom(paramFMTransC2CMsgInfo.tmpSessionSig));
      }
      localRoutingHead.comm_tmp.c2c_type.set(1);
      localRoutingHead.comm_tmp.svr_type.set(149);
      localRoutingHead.comm_tmp.setHasFlag(true);
      localRoutingHead.setHasFlag(true);
      continue;
      localRoutingHead.nearby_dating_tmp.to_uin.set(Long.parseLong(paramFMTransC2CMsgInfo.peerUin));
      if ((paramFMTransC2CMsgInfo.tmpSessionSig != null) && (paramFMTransC2CMsgInfo.tmpSessionSig.length > 0)) {
        localRoutingHead.nearby_dating_tmp.sig.set(ByteStringMicro.copyFrom(paramFMTransC2CMsgInfo.tmpSessionSig));
      }
      localRoutingHead.nearby_dating_tmp.setHasFlag(true);
      localRoutingHead.setHasFlag(true);
      continue;
      if (paramFMTransC2CMsgInfo.tmpSessionFromPhone == null) {
        paramFMTransC2CMsgInfo.tmpSessionFromPhone = "";
      }
      localRoutingHead.address_list.from_phone.set(paramFMTransC2CMsgInfo.tmpSessionFromPhone);
      if (paramFMTransC2CMsgInfo.tmpSessionToPhone == null) {
        paramFMTransC2CMsgInfo.tmpSessionToPhone = "";
      }
      localRoutingHead.address_list.to_phone.set(paramFMTransC2CMsgInfo.tmpSessionToPhone);
      String str = paramFMTransC2CMsgInfo.peerUin.replace("+", "");
      localRoutingHead.address_list.to_uin.set(Long.parseLong(str));
      if ((paramFMTransC2CMsgInfo.tmpSessionSig != null) && (paramFMTransC2CMsgInfo.tmpSessionSig.length > 0)) {
        localRoutingHead.address_list.sig.set(ByteStringMicro.copyFrom(paramFMTransC2CMsgInfo.tmpSessionSig));
      }
      localRoutingHead.address_list.setHasFlag(true);
      localRoutingHead.setHasFlag(true);
      continue;
      localRoutingHead.business_wpa_tmp.to_uin.set(Long.parseLong(paramFMTransC2CMsgInfo.peerUin));
      if ((paramFMTransC2CMsgInfo.tmpSessionSig != null) && (paramFMTransC2CMsgInfo.tmpSessionSig.length > 0)) {
        localRoutingHead.business_wpa_tmp.sig.set(ByteStringMicro.copyFrom(paramFMTransC2CMsgInfo.tmpSessionSig));
      }
      localRoutingHead.business_wpa_tmp.setHasFlag(true);
      localRoutingHead.setHasFlag(true);
    }
    label790:
    if (QLog.isColorLevel()) {
      QLog.e("Q.msg.BaseMessageProcessor", 2, "tmpsession msg0x211[" + i + "]");
    }
    localRoutingHead.trans_0x211.setHasFlag(false);
    paramPbSendMsgReq.msg_body.msg_content.setHasFlag(false);
    paramPbSendMsgReq.msg_body.rich_text.setHasFlag(true);
    paramPbSendMsgReq.msg_body.rich_text.trans_211_tmp_msg.setHasFlag(true);
    paramPbSendMsgReq.msg_body.rich_text.trans_211_tmp_msg.bytes_msg_body.set(ByteStringMicro.copyFrom(paramanbn.msg));
    paramPbSendMsgReq.msg_body.rich_text.trans_211_tmp_msg.uint32_c2c_cmd.set(4);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, anbd.a parama)
  {
    if ((parama == null) || (parama.akw != 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("wk", 2, "handleSendOfflineFileResp-->handleError");
      }
      this.a.n(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("wk", 2, "handleSendOfflineFileResp-->notify NOTIFY_TYPE_SEND_OFFLINE_FILE");
    }
    int i = paramToServiceMsg.extraData.getInt("retryIndex", 0);
    achq.a locala = new achq.a();
    locala.errCode = paramFromServiceMsg.getResultCode();
    locala.retryCount = i;
    this.a.a(paramToServiceMsg, 5004, true, new Object[] { parama, locala });
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, anbd.a parama)
  {
    if ((parama == null) || (parama.akw != 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("wk", 2, "handleSetOfflineFileState-->handleError");
      }
      this.a.n(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("wk", 2, "handleSetOfflineFileState-->notify NOTIFY_TYPE_SEND_OFFLINE_FILE");
    }
    int i = paramToServiceMsg.extraData.getInt("retryIndex", 0);
    achq.a locala = new achq.a();
    locala.errCode = paramFromServiceMsg.getResultCode();
    locala.retryCount = i;
    this.a.a(paramToServiceMsg, 5005, true, new Object[] { parama, locala });
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, anbd.a parama)
  {
    if (parama == null) {
      this.a.n(paramToServiceMsg, paramFromServiceMsg);
    }
    for (;;)
    {
      return;
      long l1 = parama.akx;
      long l2 = parama.time;
      long l3 = parama.fileSize;
      long l4 = parama.senderUin;
      paramFromServiceMsg = parama.url;
      String str1 = parama.fileName;
      String str2 = paramToServiceMsg.extraData.getString("friendUin");
      boolean bool = paramToServiceMsg.extraData.getBoolean("isRead");
      Object localObject = "http://" + aqoj.bT(l1) + "/?ver=" + "2" + "&rkey=" + paramFromServiceMsg;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "<<---handleGetOffLineFileResp serverPath: " + (String)localObject + " strFileName: " + str1 + " time: " + parama.time + " seq: " + parama.aq);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "friendUin:" + str2 + "  struct.senderUin: " + parama.senderUin + " struct.time: " + parama.time + " struct.seq: " + parama.aq);
      }
      int i;
      if (anbk.ah(str1, parama.type))
      {
        paramFromServiceMsg = aoon.a((String)localObject, l3, 1, false, (String)localObject);
        i = -2000;
      }
      while (paramFromServiceMsg != null)
      {
        localObject = anbi.d(i);
        ((MessageRecord)localObject).selfuin = paramToServiceMsg.getUin();
        ((MessageRecord)localObject).frienduin = str2;
        ((MessageRecord)localObject).senderuin = String.valueOf(l4);
        ((MessageRecord)localObject).isread = bool;
        ((MessageRecord)localObject).time = l2;
        ((MessageRecord)localObject).msgtype = i;
        ((MessageRecord)localObject).istroop = 0;
        ((MessageRecord)localObject).msg = paramFromServiceMsg;
        ((MessageRecord)localObject).msgseq = parama.aq;
        ((MessageRecord)localObject).shmsgseq = parama.aq;
        if (this.app.getCurrentAccountUin().equals(((MessageRecord)localObject).senderuin))
        {
          ((MessageRecord)localObject).isread = true;
          ((MessageRecord)localObject).issend = 2;
        }
        this.app.b().b((MessageRecord)localObject, paramToServiceMsg.getUin());
        if (-2005 == i)
        {
          paramToServiceMsg = paramToServiceMsg.extraData.getByteArray("filepath");
          paramFromServiceMsg = (TransFileInfo)this.app.a().b().find(TransFileInfo.class, new String[] { String.valueOf(l2), String.valueOf(((MessageRecord)localObject).msgseq), this.app.getCurrentAccountUin(), ((MessageRecord)localObject).frienduin });
          paramFromServiceMsg = new TransFileInfo();
          paramFromServiceMsg.selfUin = this.app.getCurrentAccountUin();
          paramFromServiceMsg.friendUin = ((MessageRecord)localObject).frienduin;
          paramFromServiceMsg.transferedSize = 0L;
          paramFromServiceMsg.status = 2008;
          paramFromServiceMsg.mr_seq = ((MessageRecord)localObject).shmsgseq;
          paramFromServiceMsg.mr_time = l2;
          paramFromServiceMsg.fileName = str1;
          paramFromServiceMsg.uuid = paramToServiceMsg;
          this.app.a().b().persistOrReplace(paramFromServiceMsg);
        }
        a("handleGetOffLineFileResp", true, 1, true, false);
        return;
        if (anbk.ai(str1, parama.type))
        {
          if (!str1.contains("_")) {}
          for (paramFromServiceMsg = str1.substring(0, str1.length() - 4);; paramFromServiceMsg = str1.substring(str1.lastIndexOf("_") + 1, str1.length() - 4))
          {
            paramFromServiceMsg = l4 + paramFromServiceMsg;
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageProcessor", 2, "isPttSuffix offfile key：" + paramFromServiceMsg);
            }
            if (!anqo.pC(paramFromServiceMsg)) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageProcessor", 2, "is Duplicate key：" + paramFromServiceMsg);
            }
            anqo.pB(paramFromServiceMsg);
            return;
          }
          anqo.pA(paramFromServiceMsg);
          paramFromServiceMsg = aoon.a((String)localObject, l3, 2, false);
          i = -2002;
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("wk", 2, "rcv offline file：" + (String)localObject + " fileSize:" + l3);
          }
          paramFromServiceMsg = aoon.a(aojs.a(this.app.getAccount(), str1, 0, null), l3, 0, false, (String)localObject);
          i = -2005;
        }
      }
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, anbd.a parama)
  {
    if (parama == null)
    {
      this.a.n(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    int i = paramToServiceMsg.extraData.getInt("retryIndex", 0);
    achq.a locala = new achq.a();
    locala.errCode = paramFromServiceMsg.getResultCode();
    locala.retryCount = i;
    this.a.a(paramToServiceMsg, 5003, true, new Object[] { parama.fu, locala });
  }
  
  private void il(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "<PbSendMsg><R><---handleSendTransMessageResp");
    }
    String str2 = paramToServiceMsg.getServiceCmd();
    long l = paramToServiceMsg.extraData.getLong("msgSeq");
    String str1 = paramToServiceMsg.extraData.getString("uin");
    int k = paramToServiceMsg.extraData.getInt("transC2CCmd");
    msg_svc.PbSendMsgResp localPbSendMsgResp = new msg_svc.PbSendMsgResp();
    try
    {
      paramObject = (msg_svc.PbSendMsgResp)localPbSendMsgResp.mergeFrom((byte[])paramObject);
      if ((paramObject == null) || (!paramObject.result.has()))
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.BaseMessageProcessor", 2, "server did not return a valid result code, use 4 instead.");
        }
        i = 4;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "<PbSendMsg><R><---handleSendTransMessageResp: ---cmd:" + str2 + "----replyCode:" + i + ",sendC2CMessage resp : peerUin:" + str1 + ",msgSeq:" + l + ",transc2ccmd:" + k);
        }
        paramFromServiceMsg.extraData.putLong("ServerReplyCode", i);
        this.a.ae(paramToServiceMsg, paramFromServiceMsg);
        paramFromServiceMsg = this.a.a(l);
        if (paramFromServiceMsg != null) {
          break label316;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "<PbSendMsg><R><---handleSendTransMessageResp: ---cmd:" + str2 + ",no SendMessageHandler found.");
        }
      }
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        int i;
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.BaseMessageProcessor", 2, "<---handleSendTransMessageResp::invalid.", paramObject);
        }
        paramObject = null;
        continue;
        if (paramObject.result.get() != 0)
        {
          i = paramObject.result.get();
          continue;
          label316:
          if (i == 255) {}
          for (int j = 1;; j = 0)
          {
            if (j != 0)
            {
              paramObject = this.a;
              paramFromServiceMsg.getClass();
              if (paramObject.a(paramFromServiceMsg, "server")) {
                break;
              }
            }
            if ((i != 0) && (i != 241)) {
              break label495;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageProcessor", 2, "<---handleSendTransMessageResp : send successfully.");
            }
            this.a.hB(l);
            if (133 == k) {
              this.app.a().i(str1, paramToServiceMsg.extraData.getLong("sessionid"), true);
            }
            if (135 != k) {
              break label460;
            }
            this.app.a().j(str1, paramToServiceMsg.extraData.getLong("sessionid"), true);
            return;
          }
          label460:
          if (QLog.isColorLevel())
          {
            QLog.w("Q.msg.BaseMessageProcessor", 2, "<---handleSendTransMessageResp : can not handle transc2ccmd:" + k);
            return;
            label495:
            if (QLog.isColorLevel()) {
              QLog.e("Q.msg.BaseMessageProcessor", 2, "<---handleSendTransMessageResp : send failed:" + i + ", transc2ccmd:" + k);
            }
            this.a.hB(l);
            if (133 == k)
            {
              this.app.a().i(str1, paramToServiceMsg.extraData.getLong("sessionid"), false);
              return;
            }
            if (135 == k) {
              this.app.a().j(str1, paramToServiceMsg.extraData.getLong("sessionid"), false);
            }
          }
        }
        else
        {
          i = 0;
        }
      }
    }
  }
  
  private void im(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "<PbSendMsg><R><---handleSendTransMessageExResp");
    }
    Object localObject2 = paramToServiceMsg.getServiceCmd();
    long l1 = paramToServiceMsg.extraData.getLong("uniseq");
    long l2 = paramToServiceMsg.extraData.getLong("queueSeq");
    long l3 = paramToServiceMsg.extraData.getLong("msgSeq");
    String str = paramToServiceMsg.extraData.getString("uin");
    Object localObject1 = paramToServiceMsg.extraData.getString("uuid");
    int k = paramToServiceMsg.extraData.getInt("transC2CCmd");
    int m = paramToServiceMsg.extraData.getInt("busiType");
    long l4 = paramToServiceMsg.extraData.getLong("tmpSessionType");
    Object localObject3 = new msg_svc.PbSendMsgResp();
    try
    {
      paramObject = (msg_svc.PbSendMsgResp)((msg_svc.PbSendMsgResp)localObject3).mergeFrom((byte[])paramObject);
      label343:
      if ((paramObject == null) || (!paramObject.result.has()))
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.BaseMessageProcessor", 2, "server did not return a valid result code, use 4 instead.");
        }
        i = 4;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "<PbSendMsg><R><---handleSendTransMessageExResp: ---cmd:" + (String)localObject2 + "----replyCode:" + i + ",sendC2CMessage resp : peerUin:" + str + ",uniseq:" + l1 + ",msgSeq:" + l3 + ",transc2ccmd:" + k);
        }
        paramFromServiceMsg.extraData.putLong("ServerReplyCode", i);
        this.a.ae(paramToServiceMsg, paramFromServiceMsg);
        localObject3 = this.a.a(l2);
        if (localObject3 != null) {
          break label389;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "<PbSendMsg><R><---handleSendTransMessageExResp: ---cmd:" + (String)localObject2 + ",no SendMessageHandler found.");
        }
      }
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        int i;
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.BaseMessageProcessor", 2, "<---handleSendTransMessageExResp::invalid.", paramObject);
        }
        paramObject = null;
        continue;
        if (paramObject.result.get() != 0)
        {
          i = paramObject.result.get();
          continue;
          label389:
          if (i == 255) {}
          for (int j = 1;; j = 0)
          {
            if (j != 0)
            {
              localObject2 = this.a;
              localObject3.getClass();
              if (((MessageHandler)localObject2).a((SendMessageHandler)localObject3, "server")) {
                break;
              }
            }
            if ((i != 0) && (i != 241)) {
              break label877;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageProcessor", 2, "<---handleSendTransMessageExResp : send successfully.");
            }
            this.a.hB(l2);
            if ((paramObject.send_time.has()) && (l1 != 0L))
            {
              l2 = 0xFFFFFFFF & paramObject.send_time.get();
              this.a.d(str, 0, l1, l2);
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageProcessor", 2, "updateSendTransMsgTime: sendBuddyPb: respData.uSendTime:" + l2 + ",peerUin:" + str);
              }
            }
            if (529 != k) {
              break label842;
            }
            switch (m)
            {
            case 1026: 
            case 1027: 
            case 1030: 
            case 1031: 
            default: 
              if (!QLog.isColorLevel()) {
                break label343;
              }
              QLog.d("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---handleSendTransMessageExResp : should not come here for the moment, busiType" + m);
              return;
            }
          }
          this.app.a().j(str, paramToServiceMsg.extraData.getLong("sessionid"), true);
          return;
          if (paramObject.send_time.has()) {
            kJ((String)localObject1 + String.valueOf(paramObject.send_time.get()));
          }
          this.app.a().a(paramToServiceMsg, paramFromServiceMsg, paramToServiceMsg.extraData.getLong("sessionid"));
          if (QLog.isColorLevel())
          {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---handleSendTransMessageExResp : send offline file  suc");
            return;
            if (QLog.isColorLevel())
            {
              QLog.d("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---handleSendTransMessageExResp : send file receipt suc");
              return;
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageProcessor", 2, "QLINK_<---handleSendTransMessageExResp : qlink send file suc");
              }
              l1 = paramToServiceMsg.extraData.getLong("sessionid");
              this.app.a().nD(l1);
              return;
              label1296:
              if (QLog.isColorLevel())
              {
                QLog.d("Q.msg.BaseMessageProcessor", 2, "QLINK_<---handleSendTransMessageExResp : qlink send file state sync suc");
                return;
                label842:
                if (QLog.isColorLevel())
                {
                  QLog.w("Q.msg.BaseMessageProcessor", 2, "<---handleSendTransMessageExResp : can not handle transc2ccmd:" + k);
                  return;
                  label877:
                  if (QLog.isColorLevel()) {
                    QLog.e("Q.msg.BaseMessageProcessor", 2, "<---handleSendTransMessageExResp : send failed:" + i + ", transc2ccmd:" + k);
                  }
                  if (((l4 == 100L) || (l4 == 127L)) && (paramObject != null) && (paramObject.errmsg.has()))
                  {
                    acqn.a(this.app, str, paramObject.errmsg.get(), 1001, false, false);
                    paramFromServiceMsg.setMsgFail();
                    localObject1 = this.app;
                    if (l4 != 100L) {
                      break label1151;
                    }
                  }
                  label1151:
                  for (paramObject = "0";; paramObject = "1")
                  {
                    anot.a((QQAppInterface)localObject1, "dc00899", "grp_lbs", "", "c2c_tmp", "no_send", 0, 0, paramObject, "" + i, "", "");
                    this.a.hB(l3);
                    if (529 != k) {
                      break label1296;
                    }
                    switch (m)
                    {
                    case 1026: 
                    case 1027: 
                    case 1030: 
                    case 1031: 
                    default: 
                      if (!QLog.isColorLevel()) {
                        break label343;
                      }
                      QLog.d("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---handleSendTransMessageExResp : should not come here for the moment, busiType" + m);
                      return;
                    }
                  }
                  this.app.a().j(str, paramToServiceMsg.extraData.getLong("sessionid"), false);
                  return;
                  this.app.a().a(paramToServiceMsg, paramFromServiceMsg, paramToServiceMsg.extraData.getLong("sessionid"));
                  if (QLog.isColorLevel())
                  {
                    QLog.d("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---handleSendTransMessageExResp : send offline file  fail");
                    return;
                    if (QLog.isColorLevel())
                    {
                      QLog.d("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---handleSendTransMessageExResp : send file receipt fail");
                      return;
                      if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.BaseMessageProcessor", 2, "QLINK_<---handleSendTransMessageExResp : qlink send file fail");
                      }
                      l1 = paramToServiceMsg.extraData.getLong("sessionid");
                      this.app.a().nE(l1);
                      return;
                      if (QLog.isColorLevel())
                      {
                        QLog.d("Q.msg.BaseMessageProcessor", 2, "QLINK_<---handleSendTransMessageExResp : qlink send file state sync fail");
                        return;
                        if (QLog.isColorLevel()) {
                          QLog.w("Q.msg.BaseMessageProcessor", 2, "<---handleSendTransMessageExResp : can not handle transc2ccmd:" + k);
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        else
        {
          i = 0;
        }
      }
    }
  }
  
  public void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    aA(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public boolean a(String paramString, int paramInt, byte[] paramArrayOfByte, FMTransC2CMsgInfo paramFMTransC2CMsgInfo)
  {
    int i = amzo.seq;
    amzo.seq = i + 1;
    long l = i;
    paramFMTransC2CMsgInfo.queueSeq = l;
    a(true, true, true, l, new acrd(this, paramString, paramFMTransC2CMsgInfo, paramInt, paramArrayOfByte));
    return true;
  }
  
  public boolean a(String paramString, long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    int i = amzo.seq;
    amzo.seq = i + 1;
    long l = i;
    a(true, true, true, l, new acre(this, paramString, paramLong, Math.abs(new Random().nextInt()), l, paramInt, paramArrayOfByte));
    return true;
  }
  
  public void aA(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i = paramToServiceMsg.extraData.getInt("retryIndex", 0);
    if (QLog.isColorLevel()) {
      QLog.d("wk", 2, "handleReqOffFilePackError, count: " + i);
    }
    if (i < 2)
    {
      paramToServiceMsg.extraData.putInt("retryIndex", i + 1);
      this.a.send(paramToServiceMsg);
    }
    achq.a locala;
    do
    {
      return;
      locala = new achq.a();
      locala.errCode = paramFromServiceMsg.getResultCode();
      locala.retryCount = i;
      if (paramFromServiceMsg.getResultCode() == 1000)
      {
        locala.errCode = 2900;
        locala.Qw = paramFromServiceMsg.extraData.getLong("ServerReplyCode", 2139062142L);
      }
      MessageHandler localMessageHandler = this.a;
      locala.timeoutReason = MessageHandler.b(paramFromServiceMsg);
      paramFromServiceMsg = paramToServiceMsg.extraData.getString("uin");
      if (paramToServiceMsg.extraData.getInt("offfile_type") == 0)
      {
        this.a.a(paramToServiceMsg, 3006, false, paramFromServiceMsg);
        return;
      }
      if (paramToServiceMsg.extraData.getInt("offfile_type") == 1)
      {
        this.a.a(paramToServiceMsg, 5003, false, new Object[] { paramFromServiceMsg, locala });
        return;
      }
      if (paramToServiceMsg.extraData.getInt("offfile_type") == 2)
      {
        this.a.a(paramToServiceMsg, 5005, false, new Object[] { paramFromServiceMsg, locala });
        return;
      }
    } while (paramToServiceMsg.extraData.getInt("offfile_type") != 3);
    this.a.a(paramToServiceMsg, 5004, false, new Object[] { paramFromServiceMsg, locala });
  }
  
  public void aB(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject = paramToServiceMsg.getServiceCmd();
    long l1 = paramToServiceMsg.extraData.getLong("msgSeq");
    String str = paramToServiceMsg.extraData.getString("uin");
    long l2 = paramToServiceMsg.extraData.getLong("timeOut");
    int i = paramToServiceMsg.extraData.getInt("transC2CCmd");
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "<PbSendMsg><E><---handleSendTransMessageError: ---cmd:" + (String)localObject + ",sendC2CMessage error : peerUin:" + str + ",msgSeq:" + l1 + ",transc2ccmd:" + i);
    }
    this.a.ae(paramToServiceMsg, paramFromServiceMsg);
    localObject = this.a.a(l1);
    if (localObject != null)
    {
      if (paramFromServiceMsg.getResultCode() != 2901) {
        break label194;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "<PbSendMsg><R><---handleSendTransMessageError, msf said:RESNDMSG");
      }
      paramFromServiceMsg = this.a;
      localObject.getClass();
      if (!paramFromServiceMsg.a((SendMessageHandler)localObject, "msf")) {
        break label194;
      }
    }
    label194:
    do
    {
      do
      {
        return;
      } while ((480000L != l2) && (!((SendMessageHandler)localObject).aFa()));
      this.a.hB(l1);
      if (133 == i)
      {
        this.app.a().i(str, paramToServiceMsg.extraData.getLong("sessionid"), false);
        return;
      }
    } while (135 != i);
    this.app.a().j(str, paramToServiceMsg.extraData.getLong("sessionid"), false);
  }
  
  public void aC(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject = paramToServiceMsg.getServiceCmd();
    long l1 = paramToServiceMsg.extraData.getLong("uniseq");
    long l2 = paramToServiceMsg.extraData.getLong("queueSeq");
    long l3 = paramToServiceMsg.extraData.getLong("msgSeq");
    String str = paramToServiceMsg.extraData.getString("uin");
    long l4 = paramToServiceMsg.extraData.getLong("timeOut");
    int i = paramToServiceMsg.extraData.getInt("transC2CCmd");
    int j = paramToServiceMsg.extraData.getInt("busiType");
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "<PbSendMsg><E><---handleSendTransMessageExError: ---cmd:" + (String)localObject + ",sendC2CMessage error : peerUin:" + str + ",uniseq:" + l1 + ",msgSeq:" + l3 + ",transc2ccmd:" + i);
    }
    this.a.ae(paramToServiceMsg, paramFromServiceMsg);
    localObject = this.a.a(l2);
    if (localObject != null)
    {
      if (paramFromServiceMsg.getResultCode() != 2901) {
        break label243;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "<PbSendMsg><R><---handleSendTransMessageExError, msf said:RESNDMSG");
      }
      MessageHandler localMessageHandler = this.a;
      localObject.getClass();
      if (!localMessageHandler.a((SendMessageHandler)localObject, "msf")) {
        break label243;
      }
    }
    label243:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
            } while ((480000L != l4) && (!((SendMessageHandler)localObject).aFa()));
            this.a.hB(l2);
            if (529 != i) {
              break;
            }
            switch (j)
            {
            }
          } while (!QLog.isColorLevel());
          QLog.d("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---handleSendTransMessageExResp : should not come here for the moment, busiType" + j);
          return;
          this.app.a().j(str, paramToServiceMsg.extraData.getLong("sessionid"), false);
          return;
          this.app.a().a(paramToServiceMsg, paramFromServiceMsg, paramToServiceMsg.extraData.getLong("sessionid"));
        } while (!QLog.isColorLevel());
        QLog.d("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---handleSendTransMessageExResp : send offline file  fail");
        return;
      } while (!QLog.isColorLevel());
      QLog.d("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---handleSendTransMessageExResp : send file receipt fail");
      return;
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---handleSendTransMessageExError : qlink send file state fail");
  }
  
  public void b(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    aA(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void f(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 7001: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        a((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], (anbd.a)paramVarArgs[2]);
        return;
      }
      bN(getClass().getName(), paramInt);
      return;
    case 7002: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        il((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      bN(getClass().getName(), paramInt);
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length == 3))
    {
      im((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
      return;
    }
    bN(getClass().getName(), paramInt);
  }
  
  public boolean kJ(String paramString)
  {
    if (!this.tU.contains(paramString))
    {
      if (this.tU.size() >= 20) {
        this.tU.remove(0);
      }
      this.tU.add(paramString);
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acrc
 * JD-Core Version:    0.7.0.1
 */