package com.tencent.mobileqq.app.message;

import android.os.Bundle;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver.StatictisInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TransFileInfo;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.data.FMTransC2CMsgInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.message.MessageFactoryReceiver.OffLineFileInfo;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.service.message.PBDecodeContext;
import com.tencent.mobileqq.service.message.TransMsgContext;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qlink.QQServiceForQlink;
import fjh;
import fji;
import fjj;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import msf.msgcomm.msg_comm.Msg;
import msf.msgsvc.msg_svc.AccostTmp;
import msf.msgsvc.msg_svc.AddressListTmp;
import msf.msgsvc.msg_svc.DisTmp;
import msf.msgsvc.msg_svc.GrpTmp;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import msf.msgsvc.msg_svc.PbSendMsgResp;
import msf.msgsvc.msg_svc.RoutingHead;
import msf.msgsvc.msg_svc.Trans0x211;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.Trans211TmpMsg;

public class OfflineFileMessageProcessor
  extends BaseMessageProcessor
{
  private static final int b = 20;
  ArrayList a;
  
  public OfflineFileMessageProcessor(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(20);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, MessageFactoryReceiver.OffLineFileInfo paramOffLineFileInfo)
  {
    if (paramOffLineFileInfo == null) {
      a(paramToServiceMsg, paramFromServiceMsg);
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("wk", 2, "onReceive, MessageConstants.CMD_TRANSSERVICE_REQOFFFILEPACK: " + paramOffLineFileInfo.jdField_b_of_type_Byte);
      }
      if (paramOffLineFileInfo.jdField_b_of_type_Byte == 6)
      {
        e(paramToServiceMsg, paramFromServiceMsg, paramOffLineFileInfo);
        return;
      }
      if (paramOffLineFileInfo.jdField_b_of_type_Byte == 3)
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramOffLineFileInfo);
        return;
      }
      if (paramOffLineFileInfo.jdField_b_of_type_Byte == 2)
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramOffLineFileInfo);
        return;
      }
    } while (paramOffLineFileInfo.jdField_b_of_type_Byte != 1);
    b(paramToServiceMsg, paramFromServiceMsg, paramOffLineFileInfo);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramToServiceMsg, paramFromServiceMsg);
        paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l);
        if (paramFromServiceMsg != null) {
          break label297;
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
          label297:
          if (i == 255) {}
          for (int j = 1;; j = 0)
          {
            if (j != 0)
            {
              paramObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
              paramFromServiceMsg.getClass();
              if (paramObject.a(paramFromServiceMsg, "server")) {
                break;
              }
            }
            if ((i != 0) && (i != 241)) {
              break label463;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageProcessor", 2, "<---handleSendTransMessageResp : send successfully.");
            }
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l);
            if (133 == k) {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str1, paramToServiceMsg.extraData.getLong("sessionid"), true);
            }
            if (135 != k) {
              break label436;
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(str1, paramToServiceMsg.extraData.getLong("sessionid"), true);
            return;
          }
          label436:
          QLog.w("Q.msg.BaseMessageProcessor", 2, "<---handleSendTransMessageResp : can not handle transc2ccmd:" + k);
          return;
          label463:
          if (QLog.isColorLevel()) {
            QLog.e("Q.msg.BaseMessageProcessor", 2, "<---handleSendTransMessageResp : send failed:" + i + ", transc2ccmd:" + k);
          }
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l);
          if (133 == k)
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str1, paramToServiceMsg.extraData.getLong("sessionid"), false);
            return;
          }
          if (135 == k) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(str1, paramToServiceMsg.extraData.getLong("sessionid"), false);
          }
        }
        else
        {
          i = 0;
        }
      }
    }
  }
  
  private void a(msg_svc.PbSendMsgReq paramPbSendMsgReq, FMTransC2CMsgInfo paramFMTransC2CMsgInfo, TransMsgContext paramTransMsgContext)
  {
    if ((paramFMTransC2CMsgInfo == null) || (paramFMTransC2CMsgInfo.entity == null)) {
      return;
    }
    paramFMTransC2CMsgInfo = paramFMTransC2CMsgInfo.entity;
    msg_svc.RoutingHead localRoutingHead = paramPbSendMsgReq.routing_head;
    int i = (int)paramFMTransC2CMsgInfo.tmpSessionType;
    switch (i)
    {
    case 101: 
    case 103: 
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
    while ((paramTransMsgContext == null) || (paramTransMsgContext.jdField_a_of_type_ArrayOfByte == null))
    {
      QLog.e("Q.msg.BaseMessageProcessor", 2, "tmpsession Bug msgContext or msgContext.msg null!");
      return;
      QLog.i("Q.msg.BaseMessageProcessor", 2, "addTempSessionData add disctmp Info");
      localRoutingHead.dis_tmp.dis_uin.set(Long.parseLong(paramFMTransC2CMsgInfo.tmpSessionRelatedUin));
      localRoutingHead.dis_tmp.to_uin.set(Long.parseLong(paramFMTransC2CMsgInfo.peerUin));
      localRoutingHead.dis_tmp.setHasFlag(true);
      localRoutingHead.setHasFlag(true);
      continue;
      localRoutingHead.grp_tmp.group_uin.set(Long.parseLong(paramFMTransC2CMsgInfo.tmpSessionRelatedUin));
      localRoutingHead.grp_tmp.to_uin.set(Long.parseLong(paramFMTransC2CMsgInfo.peerUin));
      localRoutingHead.grp_tmp.setHasFlag(true);
      localRoutingHead.setHasFlag(true);
      continue;
      localRoutingHead.address_list.from_phone.set(paramFMTransC2CMsgInfo.tmpSessionFromPhone);
      localRoutingHead.address_list.to_phone.set(paramFMTransC2CMsgInfo.tmpSessionToPhone);
      String str = paramFMTransC2CMsgInfo.peerUin.replace("+", "");
      localRoutingHead.address_list.to_uin.set(Long.parseLong(str));
      if ((paramFMTransC2CMsgInfo.tmpSessionSig != null) && (paramFMTransC2CMsgInfo.tmpSessionSig.length > 0)) {
        localRoutingHead.address_list.sig.set(ByteStringMicro.copyFrom(paramFMTransC2CMsgInfo.tmpSessionSig));
      }
      localRoutingHead.address_list.setHasFlag(true);
      localRoutingHead.setHasFlag(true);
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.msg.BaseMessageProcessor", 2, "tmpsession msg0x211[" + i + "]");
    }
    localRoutingHead.trans_0x211.setHasFlag(false);
    paramPbSendMsgReq.msg_body.msg_content.setHasFlag(false);
    paramPbSendMsgReq.msg_body.rich_text.setHasFlag(true);
    paramPbSendMsgReq.msg_body.rich_text.trans_211_tmp_msg.setHasFlag(true);
    paramPbSendMsgReq.msg_body.rich_text.trans_211_tmp_msg.bytes_msg_body.set(ByteStringMicro.copyFrom(paramTransMsgContext.jdField_a_of_type_ArrayOfByte));
    paramPbSendMsgReq.msg_body.rich_text.trans_211_tmp_msg.uint32_c2c_cmd.set(4);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, MessageFactoryReceiver.OffLineFileInfo paramOffLineFileInfo)
  {
    if ((paramOffLineFileInfo == null) || (paramOffLineFileInfo.jdField_a_of_type_Long != 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("wk", 2, "handleSendOfflineFileResp-->handleError");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("wk", 2, "handleSendOfflineFileResp-->notify NOTIFY_TYPE_SEND_OFFLINE_FILE");
    }
    int i = paramToServiceMsg.extraData.getInt("retryIndex", 0);
    MessageObserver.StatictisInfo localStatictisInfo = new MessageObserver.StatictisInfo();
    localStatictisInfo.b = paramFromServiceMsg.getResultCode();
    localStatictisInfo.c = i;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramToServiceMsg, 5004, true, new Object[] { paramOffLineFileInfo, localStatictisInfo });
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "<PbSendMsg><R><---handleSendTransMessageExResp");
    }
    Object localObject1 = paramToServiceMsg.getServiceCmd();
    long l1 = paramToServiceMsg.extraData.getLong("uniseq");
    long l2 = paramToServiceMsg.extraData.getLong("queueSeq");
    long l3 = paramToServiceMsg.extraData.getLong("msgSeq");
    String str1 = paramToServiceMsg.extraData.getString("uin");
    String str2 = paramToServiceMsg.extraData.getString("uuid");
    int k = paramToServiceMsg.extraData.getInt("transC2CCmd");
    int m = paramToServiceMsg.extraData.getInt("busiType");
    Object localObject2 = new msg_svc.PbSendMsgResp();
    try
    {
      paramObject = (msg_svc.PbSendMsgResp)((msg_svc.PbSendMsgResp)localObject2).mergeFrom((byte[])paramObject);
      label317:
      if ((paramObject == null) || (!paramObject.result.has()))
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.BaseMessageProcessor", 2, "server did not return a valid result code, use 4 instead.");
        }
        i = 4;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "<PbSendMsg><R><---handleSendTransMessageExResp: ---cmd:" + (String)localObject1 + "----replyCode:" + i + ",sendC2CMessage resp : peerUin:" + str1 + ",uniseq:" + l1 + ",msgSeq:" + l3 + ",transc2ccmd:" + k);
        }
        paramFromServiceMsg.extraData.putLong("ServerReplyCode", i);
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramToServiceMsg, paramFromServiceMsg);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l2);
        if (localObject2 != null) {
          break label362;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "<PbSendMsg><R><---handleSendTransMessageExResp: ---cmd:" + (String)localObject1 + ",no SendMessageHandler found.");
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
          label362:
          if (i == 255) {}
          for (int j = 1;; j = 0)
          {
            if (j != 0)
            {
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
              localObject2.getClass();
              if (((MessageHandler)localObject1).a((SendMessageHandler)localObject2, "server")) {
                break;
              }
            }
            if ((i != 0) && (i != 241)) {
              break label836;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageProcessor", 2, "<---handleSendTransMessageExResp : send successfully.");
            }
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l2);
            if ((paramObject.send_time.has()) && (l1 != 0L))
            {
              l2 = paramObject.send_time.get() & 0xFFFFFFFF;
              this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(str1, 0, l1, l2);
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageProcessor", 2, "updateSendTransMsgTime: sendBuddyPb: respData.uSendTime:" + l2 + ",peerUin:" + str1);
              }
            }
            if (529 != k) {
              break label802;
            }
            switch (m)
            {
            case 1026: 
            case 1027: 
            case 1030: 
            case 1031: 
            default: 
              if (!QLog.isColorLevel()) {
                break label317;
              }
              QLog.d("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---handleSendTransMessageExResp : should not come here for the moment, busiType" + m);
              return;
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(str1, paramToServiceMsg.extraData.getLong("sessionid"), true);
          return;
          if (paramObject.send_time.has()) {
            a(str2 + String.valueOf(paramObject.send_time.get()));
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramToServiceMsg, paramFromServiceMsg, paramToServiceMsg.extraData.getLong("sessionid"));
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
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l1);
              return;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.msg.BaseMessageProcessor", 2, "QLINK_<---handleSendTransMessageExResp : qlink send file state sync suc");
                return;
                label802:
                if (QLog.isColorLevel())
                {
                  QLog.w("Q.msg.BaseMessageProcessor", 2, "<---handleSendTransMessageExResp : can not handle transc2ccmd:" + k);
                  return;
                  label836:
                  if (QLog.isColorLevel()) {
                    QLog.e("Q.msg.BaseMessageProcessor", 2, "<---handleSendTransMessageExResp : send failed:" + i + ", transc2ccmd:" + k);
                  }
                  this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l3);
                  if (529 == k) {
                    switch (m)
                    {
                    case 1026: 
                    case 1027: 
                    case 1030: 
                    case 1031: 
                    default: 
                      if (!QLog.isColorLevel()) {
                        continue;
                      }
                      QLog.d("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---handleSendTransMessageExResp : should not come here for the moment, busiType" + m);
                      return;
                    case 1025: 
                      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(str1, paramToServiceMsg.extraData.getLong("sessionid"), false);
                      return;
                    case 1028: 
                      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramToServiceMsg, paramFromServiceMsg, paramToServiceMsg.extraData.getLong("sessionid"));
                      if (!QLog.isColorLevel()) {
                        continue;
                      }
                      QLog.d("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---handleSendTransMessageExResp : send offline file  fail");
                      return;
                    case 1029: 
                      if (!QLog.isColorLevel()) {
                        continue;
                      }
                      QLog.d("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---handleSendTransMessageExResp : send file receipt fail");
                      return;
                    case 1032: 
                      if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.BaseMessageProcessor", 2, "QLINK_<---handleSendTransMessageExResp : qlink send file fail");
                      }
                      l1 = paramToServiceMsg.extraData.getLong("sessionid");
                      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(l1);
                      return;
                    case 1033: 
                      if (!QLog.isColorLevel()) {
                        continue;
                      }
                      QLog.d("Q.msg.BaseMessageProcessor", 2, "QLINK_<---handleSendTransMessageExResp : qlink send file state sync fail");
                      return;
                    }
                  } else if (QLog.isColorLevel()) {
                    QLog.w("Q.msg.BaseMessageProcessor", 2, "<---handleSendTransMessageExResp : can not handle transc2ccmd:" + k);
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
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, MessageFactoryReceiver.OffLineFileInfo paramOffLineFileInfo)
  {
    if ((paramOffLineFileInfo == null) || (paramOffLineFileInfo.jdField_a_of_type_Long != 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("wk", 2, "handleSetOfflineFileState-->handleError");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("wk", 2, "handleSetOfflineFileState-->notify NOTIFY_TYPE_SEND_OFFLINE_FILE");
    }
    int i = paramToServiceMsg.extraData.getInt("retryIndex", 0);
    MessageObserver.StatictisInfo localStatictisInfo = new MessageObserver.StatictisInfo();
    localStatictisInfo.b = paramFromServiceMsg.getResultCode();
    localStatictisInfo.c = i;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramToServiceMsg, 5005, true, new Object[] { paramOffLineFileInfo, localStatictisInfo });
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, MessageFactoryReceiver.OffLineFileInfo paramOffLineFileInfo)
  {
    if (paramOffLineFileInfo == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramToServiceMsg, paramFromServiceMsg);
    }
    for (;;)
    {
      return;
      long l1 = paramOffLineFileInfo.jdField_c_of_type_Long;
      long l2 = paramOffLineFileInfo.d;
      long l3 = paramOffLineFileInfo.e;
      long l4 = paramOffLineFileInfo.jdField_b_of_type_Long;
      paramFromServiceMsg = paramOffLineFileInfo.jdField_b_of_type_JavaLangString;
      String str1 = paramOffLineFileInfo.jdField_c_of_type_JavaLangString;
      String str2 = paramToServiceMsg.extraData.getString("friendUin");
      boolean bool = paramToServiceMsg.extraData.getBoolean("isRead");
      Object localObject = "http://" + PkgTools.b(l1) + "/?ver=" + "2" + "&rkey=" + paramFromServiceMsg;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "<<---handleGetOffLineFileResp serverPath: " + (String)localObject + " strFileName: " + str1 + " time: " + paramOffLineFileInfo.d + " seq: " + paramOffLineFileInfo.jdField_a_of_type_Short);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "friendUin:" + str2 + "  struct.senderUin: " + paramOffLineFileInfo.jdField_b_of_type_Long + " struct.time: " + paramOffLineFileInfo.d + " struct.seq: " + paramOffLineFileInfo.jdField_a_of_type_Short);
      }
      int i;
      if (MessageUtils.a(str1, paramOffLineFileInfo.jdField_a_of_type_Byte))
      {
        paramFromServiceMsg = TransfileUtile.a((String)localObject, l3, 1, false, (String)localObject);
        i = -2000;
      }
      while (paramFromServiceMsg != null)
      {
        localObject = MessageRecordFactory.a(i);
        ((MessageRecord)localObject).selfuin = paramToServiceMsg.getUin();
        ((MessageRecord)localObject).frienduin = str2;
        ((MessageRecord)localObject).senderuin = String.valueOf(l4);
        ((MessageRecord)localObject).isread = bool;
        ((MessageRecord)localObject).time = l2;
        ((MessageRecord)localObject).msgtype = i;
        ((MessageRecord)localObject).istroop = 0;
        ((MessageRecord)localObject).msg = paramFromServiceMsg;
        ((MessageRecord)localObject).msgseq = paramOffLineFileInfo.jdField_a_of_type_Short;
        ((MessageRecord)localObject).shmsgseq = paramOffLineFileInfo.jdField_a_of_type_Short;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(((MessageRecord)localObject).senderuin))
        {
          ((MessageRecord)localObject).isread = true;
          ((MessageRecord)localObject).issend = 2;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject, paramToServiceMsg.getUin());
        if (-2005 == i)
        {
          paramToServiceMsg = paramToServiceMsg.extraData.getByteArray("filepath");
          paramFromServiceMsg = (TransFileInfo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(TransFileInfo.class, new String[] { String.valueOf(l2), String.valueOf(((MessageRecord)localObject).msgseq), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), ((MessageRecord)localObject).frienduin });
          paramFromServiceMsg = new TransFileInfo();
          paramFromServiceMsg.selfUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          paramFromServiceMsg.friendUin = ((MessageRecord)localObject).frienduin;
          paramFromServiceMsg.transferedSize = 0L;
          paramFromServiceMsg.status = 2008;
          paramFromServiceMsg.mr_seq = ((MessageRecord)localObject).shmsgseq;
          paramFromServiceMsg.mr_time = l2;
          paramFromServiceMsg.fileName = str1;
          paramFromServiceMsg.uuid = paramToServiceMsg;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b(paramFromServiceMsg);
        }
        a("handleGetOffLineFileResp", true, 1, true, false);
        return;
        if (MessageUtils.b(str1, paramOffLineFileInfo.jdField_a_of_type_Byte))
        {
          if (!str1.contains("_")) {}
          for (paramFromServiceMsg = str1.substring(0, str1.length() - 4);; paramFromServiceMsg = str1.substring(str1.lastIndexOf("_") + 1, str1.length() - 4))
          {
            paramFromServiceMsg = l4 + paramFromServiceMsg;
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageProcessor", 2, "isPttSuffix offfile key：" + paramFromServiceMsg);
            }
            if (!StreamDataManager.e(paramFromServiceMsg)) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageProcessor", 2, "is Duplicate key：" + paramFromServiceMsg);
            }
            StreamDataManager.d(paramFromServiceMsg);
            return;
          }
          StreamDataManager.c(paramFromServiceMsg);
          paramFromServiceMsg = TransfileUtile.a((String)localObject, l3, 2, false);
          i = -2002;
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("wk", 2, "rcv offline file：" + (String)localObject + " fileSize:" + l3);
          }
          paramFromServiceMsg = TransfileUtile.a(BuddyTransfileProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), str1, 0, null), l3, 0, false, (String)localObject);
          i = -2005;
        }
      }
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, MessageFactoryReceiver.OffLineFileInfo paramOffLineFileInfo)
  {
    if (paramOffLineFileInfo == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    int i = paramToServiceMsg.extraData.getInt("retryIndex", 0);
    MessageObserver.StatictisInfo localStatictisInfo = new MessageObserver.StatictisInfo();
    localStatictisInfo.b = paramFromServiceMsg.getResultCode();
    localStatictisInfo.c = i;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramToServiceMsg, 5003, true, new Object[] { paramOffLineFileInfo.jdField_a_of_type_ArrayOfByte, localStatictisInfo });
  }
  
  public List a(msg_comm.Msg paramMsg, PBDecodeContext paramPBDecodeContext)
  {
    return null;
  }
  
  public void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 7001: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        a((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], (MessageFactoryReceiver.OffLineFileInfo)paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    case 7002: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        a((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length == 3))
    {
      b((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
      return;
    }
    a(getClass().getName(), paramInt);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i = paramToServiceMsg.extraData.getInt("retryIndex", 0);
    if (QLog.isColorLevel()) {
      QLog.d("wk", 2, "handleReqOffFilePackError, count: " + i);
    }
    if (i < 2)
    {
      paramToServiceMsg.extraData.putInt("retryIndex", i + 1);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramToServiceMsg);
    }
    MessageObserver.StatictisInfo localStatictisInfo;
    do
    {
      return;
      localStatictisInfo = new MessageObserver.StatictisInfo();
      localStatictisInfo.b = paramFromServiceMsg.getResultCode();
      localStatictisInfo.c = i;
      if (paramFromServiceMsg.getResultCode() == 1000)
      {
        localStatictisInfo.b = 2900;
        localStatictisInfo.d = paramFromServiceMsg.extraData.getLong("ServerReplyCode", 2139062142L);
      }
      MessageHandler localMessageHandler = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
      localStatictisInfo.a = MessageHandler.a(paramFromServiceMsg);
      paramFromServiceMsg = paramToServiceMsg.extraData.getString("uin");
      if (paramToServiceMsg.extraData.getInt("offfile_type") == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramToServiceMsg, 3006, false, paramFromServiceMsg);
        return;
      }
      if (paramToServiceMsg.extraData.getInt("offfile_type") == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramToServiceMsg, 5003, false, new Object[] { paramFromServiceMsg, localStatictisInfo });
        return;
      }
      if (paramToServiceMsg.extraData.getInt("offfile_type") == 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramToServiceMsg, 5005, false, new Object[] { paramFromServiceMsg, localStatictisInfo });
        return;
      }
    } while (paramToServiceMsg.extraData.getInt("offfile_type") != 3);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramToServiceMsg, 5004, false, new Object[] { paramFromServiceMsg, localStatictisInfo });
  }
  
  public boolean a(String paramString)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramString))
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() >= 20) {
        this.jdField_a_of_type_JavaUtilArrayList.remove(0);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
      return false;
    }
    return true;
  }
  
  public boolean a(String paramString, int paramInt1, byte[] paramArrayOfByte1, int paramInt2, int paramInt3, byte[] paramArrayOfByte2, FMTransC2CMsgInfo paramFMTransC2CMsgInfo)
  {
    int i = MobileQQService.c;
    MobileQQService.c = i + 1;
    long l = i;
    paramFMTransC2CMsgInfo.queueSeq = l;
    a(true, true, true, l, new fjh(this, paramString, paramFMTransC2CMsgInfo, paramInt1, paramArrayOfByte2, paramArrayOfByte1, paramInt2, paramInt3));
    return true;
  }
  
  public boolean a(String paramString, int paramInt, byte[] paramArrayOfByte, FMTransC2CMsgInfo paramFMTransC2CMsgInfo)
  {
    int i = MobileQQService.c;
    MobileQQService.c = i + 1;
    long l = i;
    paramFMTransC2CMsgInfo.queueSeq = l;
    a(true, true, true, l, new fji(this, paramString, paramFMTransC2CMsgInfo, paramInt, paramArrayOfByte));
    return true;
  }
  
  public boolean a(String paramString, long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    int i = MobileQQService.c;
    MobileQQService.c = i + 1;
    long l = i;
    a(true, true, true, l, new fjj(this, paramString, paramLong, Math.abs(new Random().nextInt()), l, paramInt, paramArrayOfByte));
    return true;
  }
  
  public void b(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    a(paramToServiceMsg, paramFromServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.OfflineFileMessageProcessor
 * JD-Core Version:    0.7.0.1
 */