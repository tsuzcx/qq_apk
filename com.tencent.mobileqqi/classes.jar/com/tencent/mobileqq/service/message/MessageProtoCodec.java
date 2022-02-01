package com.tencent.mobileqq.service.message;

import IMMsgBodyPack.SlaveMasterMsg;
import OnlinePushPack.MsgInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.pubaccount.util.PAMessageUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.TroopNotificationCache;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQGAudioMsgHandler;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.ShieldListHandler;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.message.OfflineFileMessageProcessor;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.FunnyFaceMessage;
import com.tencent.mobileqq.data.FunnyFaceMessage.Bomb;
import com.tencent.mobileqq.data.FunnyFaceMessage.Turntable;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForFunnyFace;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPlayTogetherResult;
import com.tencent.mobileqq.data.MessageForPlayTogetherResult.PlayTogetherResultInfo;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.ShakeWindowMsg;
import com.tencent.mobileqq.data.TroopFileData;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.OnlineFileSessionInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.stt.SttManager;
import com.tencent.mobileqq.transfile.TranDbRecord.PicDbRecord;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.MessageNavInfo;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.mobileqq.utils.ActionMsgUtil.AppShareCookie;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qlink.QlinkServiceManager;
import gja;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.zip.Inflater;
import localpb.richMsg.MixedMsg.Elem;
import localpb.richMsg.MixedMsg.Msg;
import localpb.richMsg.RichMsg.PicRec;
import localpb.richMsg.RichMsg.PttRec;
import msf.msgcomm.msg_comm.AppShareInfo;
import msf.msgcomm.msg_comm.C2CTmpMsgHead;
import msf.msgcomm.msg_comm.ContentHead;
import msf.msgcomm.msg_comm.DiscussInfo;
import msf.msgcomm.msg_comm.GroupInfo;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.MsgType0x210;
import msf.msgcomm.msg_comm.PluginInfo;
import msf.msgsvc.msg_svc.AccostTmp;
import msf.msgsvc.msg_svc.AddressListTmp;
import msf.msgsvc.msg_svc.AuthTmp;
import msf.msgsvc.msg_svc.BsnsTmp;
import msf.msgsvc.msg_svc.BusinessWPATmp;
import msf.msgsvc.msg_svc.C2C;
import msf.msgsvc.msg_svc.Dis;
import msf.msgsvc.msg_svc.DisTmp;
import msf.msgsvc.msg_svc.Grp;
import msf.msgsvc.msg_svc.GrpTmp;
import msf.msgsvc.msg_svc.PbDeleteMsgReq;
import msf.msgsvc.msg_svc.PbDeleteMsgReq.MsgItem;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import msf.msgsvc.msg_svc.PubGroupTmp;
import msf.msgsvc.msg_svc.PublicPlat;
import msf.msgsvc.msg_svc.QQQueryBusinessTmp;
import msf.msgsvc.msg_svc.RichStatusTmp;
import msf.msgsvc.msg_svc.RoutingHead;
import msf.msgsvc.msg_svc.Trans0x211;
import msf.msgsvc.msg_svc.TransMsg;
import msf.msgsvc.msg_svc.WPATmp;
import tencent.im.msg.im_msg_body.Attr;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ElemFlags2;
import tencent.im.msg.im_msg_body.Face;
import tencent.im.msg.im_msg_body.FunFace;
import tencent.im.msg.im_msg_body.FunFace.Bomb;
import tencent.im.msg.im_msg_body.FunFace.Turntable;
import tencent.im.msg.im_msg_body.GroupFile;
import tencent.im.msg.im_msg_body.MarketFace;
import tencent.im.msg.im_msg_body.MarketTrans;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.NotOnlineFile;
import tencent.im.msg.im_msg_body.NotOnlineImage;
import tencent.im.msg.im_msg_body.OnlineImage;
import tencent.im.msg.im_msg_body.Ptt;
import tencent.im.msg.im_msg_body.RichMsg;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.SecretFileMsg;
import tencent.im.msg.im_msg_body.ShakeWindow;
import tencent.im.msg.im_msg_body.Text;
import tencent.im.msg.im_msg_body.TmpPtt;
import tencent.im.msg.im_msg_body.TransElem;
import tencent.im.msg.obj_msg.MsgContentInfo;
import tencent.im.msg.obj_msg.MsgContentInfo.MsgFile;
import tencent.im.msg.obj_msg.ObjMsg;
import tencent.im.s2c.msgtype0x210.submsgtype0x35.Submsgtype0x35.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x41.MsgType0x210_SubMsgType0x41.GameRsultMsg;
import tencent.im.s2c.msgtype0x210.submsgtype0x41.MsgType0x210_SubMsgType0x41.UinResult;
import tencent.im.s2c.msgtype0x210.submsgtype0x4e.Submsgtype0x4e.GroupBulletin;
import tencent.im.s2c.msgtype0x210.submsgtype0x4e.Submsgtype0x4e.GroupBulletin.Content;
import tencent.im.s2c.msgtype0x210.submsgtype0x4e.Submsgtype0x4e.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x3.SubMsgType0x3.FailNotify;
import tencent.im.s2c.msgtype0x211.submsgtype0x3.SubMsgType0x3.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x3.SubMsgType0x3.ProgressNotify;
import tencent.im.s2c.msgtype0x211.submsgtype0x4.SubMsgType0x4.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody;

public class MessageProtoCodec
{
  public static final int a = 30;
  private static final long jdField_a_of_type_Long = 4294967295L;
  private static final String jdField_a_of_type_JavaLangString = "Q.msg.MessageHandler";
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 7: 
    case 9: 
    case 13: 
    default: 
      return 0;
    case 3: 
      return 1000;
    case 6: 
      return 1005;
    case 8: 
      return 1008;
    case 10: 
      return 1006;
    case 5: 
      return 1004;
    case 11: 
      return 1009;
    case 12: 
      return 1001;
    case 4: 
      return 3000;
    case 2: 
      return 1;
    case 14: 
      return 1020;
    case 16: 
      return 1021;
    case 17: 
      return 1022;
    case 18: 
      return 1023;
    }
    return 1024;
  }
  
  public static int a(msg_comm.Msg paramMsg)
  {
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has())) {
      return 0;
    }
    paramMsg = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get().iterator();
    while (paramMsg.hasNext())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)paramMsg.next();
      if ((localElem.elem_flags2.has()) && (((im_msg_body.ElemFlags2)localElem.elem_flags2.get()).uint32_ptt_change_bit.has())) {
        if (((im_msg_body.ElemFlags2)localElem.elem_flags2.get()).uint32_ptt_change_bit.get() == 1) {
          return 1;
        }
      }
    }
    return 0;
  }
  
  public static int a(im_msg_body.RichText paramRichText, String paramString1, ArrayList paramArrayList, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int k = 0;
    int j = 0;
    int i = 0;
    label31:
    Object localObject;
    if (k < paramString1.length())
    {
      if (paramArrayList == null) {
        break label500;
      }
      if (j >= paramArrayList.size()) {
        break label494;
      }
      localObject = (MessageForText.AtTroopMemberInfo)paramArrayList.get(j);
      if ((localObject == null) || (!((MessageForText.AtTroopMemberInfo)localObject).isValid())) {}
    }
    for (;;)
    {
      int m;
      im_msg_body.Elem localElem;
      if ((localObject != null) && (((MessageForText.AtTroopMemberInfo)localObject).startPos <= k))
      {
        m = i;
        if (localStringBuilder.length() > 0)
        {
          a(paramRichText, localStringBuilder.toString());
          localStringBuilder.delete(0, localStringBuilder.length());
          m = i + 1;
        }
        localElem = a(paramRichText, paramString1.substring(((MessageForText.AtTroopMemberInfo)localObject).startPos, ((MessageForText.AtTroopMemberInfo)localObject).startPos + ((MessageForText.AtTroopMemberInfo)localObject).textLen));
        ((MessageForText.AtTroopMemberInfo)localObject).startPos = 0;
        a((MessageForText.AtTroopMemberInfo)localObject, localElem);
        localStringBuilder.delete(0, localStringBuilder.length());
        i = m + 1;
        m = ((MessageForText.AtTroopMemberInfo)localObject).textLen;
        j += 1;
        k += m - 1;
      }
      for (;;)
      {
        k += 1;
        break;
        j += 1;
        break label31;
        if (paramString1.charAt(k) == '\024')
        {
          m = i;
          if (localStringBuilder.length() > 0)
          {
            a(paramRichText, localStringBuilder.toString());
            localStringBuilder.delete(0, localStringBuilder.length());
            m = i + 1;
          }
          int i1 = paramString1.charAt(k + 1);
          int n = k;
          i = m;
          if (i1 >= 0)
          {
            n = k;
            i = m;
            if (i1 < MessageUtils.a.length)
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "---faceIndex:" + MessageUtils.a[i1]);
              }
              localObject = new im_msg_body.Face();
              ((im_msg_body.Face)localObject).index.set(MessageUtils.a[i1]);
              localElem = new im_msg_body.Elem();
              localElem.face.set((MessageMicro)localObject);
              paramRichText.elems.add(localElem);
              i = m + 1;
              n = k + 1;
            }
          }
          k = n;
        }
        else
        {
          localStringBuilder.append(paramString1.charAt(k));
        }
      }
      j = i;
      if (localStringBuilder.length() > 0)
      {
        paramString1 = localStringBuilder.toString();
        if (paramString2.equals("2927565187")) {
          paramString1 = localStringBuilder.toString() + "[QQI]";
        }
        a(paramRichText, paramString1);
        j = i + 1;
      }
      return j;
      label494:
      localObject = null;
      continue;
      label500:
      localObject = null;
    }
  }
  
  public static long a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_GroupSys");
    }
    long l2;
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has()))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_GroupSys return null:hasBody:" + paramMsg.msg_body.has() + ",hasMsgContent" + ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has() + ",isReaded:" + paramBoolean1 + "syncOther:" + paramBoolean2);
      }
      l2 = 0L;
      return l2;
    }
    long l3 = Long.valueOf(paramMessageHandler.a.a()).longValue();
    long l4 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
    int i = (short)((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_type.get();
    byte[] arrayOfByte = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
    if ((arrayOfByte != null) && (arrayOfByte.length > 0)) {}
    for (long l1 = PkgTools.a(arrayOfByte, 0);; l1 = 0L)
    {
      Object localObject = (msg_comm.MsgHead)paramMsg.msg_head.get();
      if (localObject != null)
      {
        localObject = ((msg_comm.MsgHead)localObject).group_name.get();
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler.sysnick", 2, "TroopCode:" + l1 + "TroopName:" + (String)localObject);
        }
        paramMessageHandler.c("" + l1, (String)localObject);
      }
      l2 = l1;
      if (paramBoolean1) {
        break;
      }
      l2 = l1;
      if (paramBoolean2) {
        break;
      }
      l2 = l1;
      if (paramBoolean3) {
        break;
      }
      paramMessageHandler.a().a(l3, i, arrayOfByte, l4, ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get(), ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get());
      return l1;
    }
  }
  
  public static long a(msg_comm.Msg paramMsg)
  {
    long l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has())) {}
    do
    {
      do
      {
        return l1;
        paramMsg = (im_msg_body.Ptt)((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).ptt.get();
      } while (!paramMsg.bytes_reserve.has());
      paramMsg = paramMsg.bytes_reserve.get().toByteArray();
    } while ((paramMsg == null) || (paramMsg.length <= 1));
    int i = paramMsg[0];
    i = 1;
    while (i < paramMsg.length - 1)
    {
      int j = paramMsg[i];
      int k = i + 1;
      i = PkgTools.a(paramMsg, k);
      k += 2;
      long l2 = l1;
      if (j == 3)
      {
        byte[] arrayOfByte = new byte[i];
        PkgTools.a(arrayOfByte, 0, paramMsg, k, i);
        long l3 = PkgTools.a(arrayOfByte, 0);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "--->decodeC2CMsgPkg_msgTime PTT_ROAM : TimeStamp in d0 :" + l1);
        }
        l2 = l1;
        if (l3 > 0L) {
          l2 = l3;
        }
      }
      i = k + i;
      l1 = l2;
    }
    return l1;
  }
  
  public static Pair a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, String paramString1, String paramString2)
  {
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has())) {
      return new Pair(Long.valueOf(0L), Long.valueOf(0L));
    }
    paramMsg = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get().iterator();
    Object localObject;
    long l1;
    if (paramMsg.hasNext())
    {
      localObject = (im_msg_body.Elem)paramMsg.next();
      if ((((im_msg_body.Elem)localObject).elem_flags2.has()) && (((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject).elem_flags2.get()).uint32_color_text_id.has())) {
        l1 = ((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject).elem_flags2.get()).uint32_color_text_id.get() & 0xFFFFFFFF;
      }
    }
    for (;;)
    {
      label151:
      if (l1 == 4294967295L) {}
      for (long l2 = paramMessageHandler.a.a().a(paramString1, paramString2);; l2 = -1L)
      {
        return new Pair(Long.valueOf(l1), Long.valueOf(l2));
        if (!((im_msg_body.Elem)localObject).secret_file.has()) {
          break;
        }
        localObject = ((im_msg_body.Elem)localObject).secret_file;
        if ((!((im_msg_body.SecretFileMsg)localObject).elem_flags2.has()) || (!((im_msg_body.SecretFileMsg)localObject).elem_flags2.uint32_color_text_id.has())) {
          break;
        }
        l1 = ((im_msg_body.ElemFlags2)((im_msg_body.SecretFileMsg)localObject).elem_flags2.get()).uint32_color_text_id.get() & 0xFFFFFFFF;
        break label151;
      }
      l1 = -1L;
    }
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        localGameRsultMsg = (MsgType0x210_SubMsgType0x41.GameRsultMsg)new MsgType0x210_SubMsgType0x41.GameRsultMsg().mergeFrom(paramArrayOfByte);
        if (localGameRsultMsg == null) {
          return null;
        }
        str = null;
        localObject2 = null;
        localObject3 = null;
        paramArrayOfByte = null;
        localMessageForPlayTogetherResult = (MessageForPlayTogetherResult)paramMessageRecord;
      }
      catch (Exception paramArrayOfByte)
      {
        MsgType0x210_SubMsgType0x41.GameRsultMsg localGameRsultMsg;
        String str;
        Object localObject2;
        Object localObject3;
        MessageForPlayTogetherResult localMessageForPlayTogetherResult;
        Object localObject4;
        long l;
        int i;
        paramQQAppInterface = null;
        continue;
        Object localObject1 = null;
        continue;
      }
      try
      {
        if (!localGameRsultMsg.str_game_name.has()) {
          continue;
        }
        localObject1 = localGameRsultMsg.str_game_name.get();
        if (localGameRsultMsg.str_game_pic.has()) {
          str = localGameRsultMsg.str_game_pic.get();
        }
        if (localGameRsultMsg.str_more_info.has()) {
          localObject2 = localGameRsultMsg.str_more_info.get();
        }
        if (localGameRsultMsg.str_game_subheading.has()) {
          localObject3 = localGameRsultMsg.str_game_subheading.get();
        }
        if (localGameRsultMsg.str_game_subheading.has()) {
          paramArrayOfByte = localGameRsultMsg.bytes_nickname.get().toStringUtf8();
        }
        if (paramArrayOfByte != null)
        {
          localObject4 = paramArrayOfByte;
          if (!paramArrayOfByte.equals("")) {}
        }
        else
        {
          localObject4 = ContactUtils.a(paramQQAppInterface, String.valueOf(localGameRsultMsg.uint64_uin.get()), null, ContactUtils.b(0), 3);
        }
        localMessageForPlayTogetherResult.setResultInfo((String)localObject1, str, (String)localObject2, (String)localObject3, ContactUtils.a((String)localObject4, 12, "..."));
        l = 0L;
        paramArrayOfByte = null;
        i = 0;
        localObject2 = localGameRsultMsg.rpt_msg_game_rsts.get().iterator();
        str = null;
        if (!((Iterator)localObject2).hasNext()) {
          continue;
        }
        localObject3 = (MsgType0x210_SubMsgType0x41.UinResult)((Iterator)localObject2).next();
        if (((MsgType0x210_SubMsgType0x41.UinResult)localObject3).uint64_uin.has()) {
          l = ((MsgType0x210_SubMsgType0x41.UinResult)localObject3).uint64_uin.get();
        }
        localObject1 = paramArrayOfByte;
        if (((MsgType0x210_SubMsgType0x41.UinResult)localObject3).bytes_nickname.has()) {
          localObject1 = ((MsgType0x210_SubMsgType0x41.UinResult)localObject3).bytes_nickname.get().toStringUtf8();
        }
        paramArrayOfByte = (byte[])localObject1;
        if (paramBoolean)
        {
          paramArrayOfByte = (byte[])localObject1;
          if (l != 0L) {
            paramArrayOfByte = ContactUtils.a(paramQQAppInterface, String.valueOf(l), null, ContactUtils.b(0), 3);
          }
        }
        if (((MsgType0x210_SubMsgType0x41.UinResult)localObject3).uint32_grade.has()) {
          i = ((MsgType0x210_SubMsgType0x41.UinResult)localObject3).uint32_grade.get();
        }
        if (((MsgType0x210_SubMsgType0x41.UinResult)localObject3).str_score.has()) {
          str = ((MsgType0x210_SubMsgType0x41.UinResult)localObject3).str_score.get();
        }
        localMessageForPlayTogetherResult.addUinResultInfo(paramQQAppInterface, l, paramArrayOfByte, i, str);
        continue;
        QLog.e(MessageForPlayTogetherResult.TAG, 2, "Play together result, mr type is " + paramMessageRecord.msgtype + ", seq is " + paramMessageRecord.msgseq);
      }
      catch (Exception paramArrayOfByte)
      {
        paramQQAppInterface = localMessageForPlayTogetherResult;
        paramArrayOfByte.printStackTrace();
        if (!QLog.isColorLevel()) {
          return paramQQAppInterface;
        }
      }
      return paramQQAppInterface;
      localMessageForPlayTogetherResult.msgData = localMessageForPlayTogetherResult.getMsgInfo().toBytes();
      paramQQAppInterface = localMessageForPlayTogetherResult;
    }
    return paramQQAppInterface;
  }
  
  public static MessageRecord a(List paramList)
  {
    MixedMsg.Msg localMsg = new MixedMsg.Msg();
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      Object localObject = (MessageRecord)paramList.next();
      MixedMsg.Elem localElem = new MixedMsg.Elem();
      if (((MessageRecord)localObject).msgtype == -1000) {
        localElem.textMsg.set(((MessageRecord)localObject).msg);
      }
      for (;;)
      {
        localMsg.elems.get().add(localElem);
        break;
        if (((MessageRecord)localObject).msgtype == -2000)
        {
          RichMsg.PicRec localPicRec = new RichMsg.PicRec();
          try
          {
            localObject = (RichMsg.PicRec)localPicRec.mergeFrom(((MessageRecord)localObject).msgData);
            localElem.picMsg.set((MessageMicro)localObject);
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
          {
            localInvalidProtocolBufferMicroException.printStackTrace();
          }
        }
      }
    }
    paramList = (MessageForMixedMsg)MessageRecordFactory.a(-1035);
    paramList.msgtype = -1035;
    paramList.msgData = localMsg.toByteArray();
    paramList.parse();
    return paramList;
  }
  
  private static PAMessage a(String paramString)
  {
    paramString = PAMessageUtil.a(paramString);
    if (paramString != null) {
      return paramString;
    }
    return null;
  }
  
  public static MessageDecContent a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, long paramLong1, boolean paramBoolean1, boolean paramBoolean2, long paramLong2)
  {
    im_msg_body.MsgBody localMsgBody = (im_msg_body.MsgBody)paramMsg.msg_body.get();
    int i = ((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_cmd.get();
    Long localLong1 = Long.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get());
    Long localLong2 = Long.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).to_uin.get());
    long l = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
    short s = (short)((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
    Object localObject = localLong1.toString();
    String str = paramMessageHandler.a.a();
    if (i == 129)
    {
      paramMsg = (msg_comm.Msg)localObject;
      if (((String)localObject).equals(String.valueOf(localLong2)))
      {
        paramMsg = (msg_comm.Msg)localObject;
        if (((String)localObject).equals(str))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_OnlineFile recv  a 0x81 that is from self.");
          }
          return null;
        }
      }
    }
    else
    {
      if (!str.equals(String.valueOf(localLong1))) {
        break label238;
      }
      paramMsg = String.valueOf(localLong2);
    }
    switch (i)
    {
    }
    for (;;)
    {
      return null;
      label238:
      paramMsg = String.valueOf(localLong1);
      break;
      if (str.equalsIgnoreCase(String.valueOf(localLong1)))
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_OnlineFile 0x81 request is error.it is from self!!!");
        }
        return null;
      }
      if (paramBoolean2)
      {
        QLog.i("Q.msg.MessageHandler", 1, "recv roam online msg, return null!");
        return null;
      }
      localObject = paramMessageHandler.a.a().a(localMsgBody.msg_content.get().toByteArray());
      if (localObject != null)
      {
        if (!paramMessageHandler.a.a().a((OnlineFileSessionInfo)localObject))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_OnlineFile 0x81 request is error.");
          }
          return null;
        }
        if (!((OnlineFileSessionInfo)localObject).c)
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_OnlineFile 0x81. requset is no mulitend olfile.");
          }
          return null;
        }
        paramMessageHandler.a.a().b(i, String.valueOf(paramLong1), paramMsg, l, s, paramBoolean1, 0, null, (OnlineFileSessionInfo)localObject, paramLong2);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_OnlineFile decode 0x81 failed.");
        }
        return null;
        localObject = paramMessageHandler.a.a().a(localMsgBody.msg_content.get().toByteArray());
        if (localObject != null)
        {
          if (!paramMessageHandler.a.a().a((OnlineFileSessionInfo)localObject))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_OnlineFile 0x83  is error.");
            }
            return null;
          }
          paramMessageHandler.a.a().b(i, String.valueOf(paramLong1), paramMsg, l, s, paramBoolean1, 0, null, (OnlineFileSessionInfo)localObject, paramLong2);
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_OnlineFile decode 0x83 failed.");
          }
          return null;
          localObject = paramMessageHandler.a.a().b(localMsgBody.msg_content.get().toByteArray());
          if (localObject == null) {
            break label628;
          }
          if (!paramMessageHandler.a.a().a((OnlineFileSessionInfo)localObject))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_OnlineFile 0x85  is error.");
            }
            return null;
          }
          paramMessageHandler.a.a().b(i, String.valueOf(paramLong1), paramMsg, l, s, paramBoolean1, 0, null, (OnlineFileSessionInfo)localObject, paramLong2);
        }
      }
    }
    label628:
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_OnlineFile decode 0x85 failed.");
    }
    return null;
  }
  
  public static TempSessionInfo a(msg_comm.Msg paramMsg)
  {
    TempSessionInfo localTempSessionInfo = new TempSessionInfo();
    int i = -1;
    paramMsg = (msg_comm.C2CTmpMsgHead)((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_tmp_msg_head.get();
    int j;
    int k;
    if (!paramMsg.c2c_type.has())
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "It doesn't has a c2cType.");
      }
      j = paramMsg.c2c_type.get();
      k = paramMsg.service_type.get();
      switch (k)
      {
      default: 
        label180:
        localTempSessionInfo.jdField_b_of_type_Int = i;
        localTempSessionInfo.jdField_b_of_type_Long = -1L;
        localTempSessionInfo.c = -1L;
        switch (k)
        {
        }
        break;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        paramMsg = new StringBuilder("<---getC2CMsgPkgTempInfo: dump info:");
        paramMsg.append(" c2cType:").append(j).append(" serviceType:").append(k).append(" info:").append(localTempSessionInfo.toString());
        QLog.d("Q.msg.MessageHandler", 2, paramMsg.toString());
      }
      return localTempSessionInfo;
      if ((paramMsg.service_type.has()) || (!QLog.isColorLevel())) {
        break;
      }
      QLog.e("Q.msg.MessageHandler", 2, "Invalid service type, the pb data has no service type.");
      break;
      i = 1000;
      break label180;
      i = 1004;
      break label180;
      i = 1024;
      break label180;
      i = 1005;
      break label180;
      i = 1008;
      break label180;
      i = 1006;
      break label180;
      i = 1009;
      break label180;
      i = 1001;
      break label180;
      i = 1020;
      break label180;
      i = 1021;
      break label180;
      i = 1022;
      break label180;
      i = 1023;
      break label180;
      localTempSessionInfo.jdField_b_of_type_Long = paramMsg.group_code.get();
      localTempSessionInfo.c = paramMsg.group_uin.get();
      continue;
      localTempSessionInfo.jdField_b_of_type_Long = paramMsg.group_code.get();
      localTempSessionInfo.c = paramMsg.group_code.get();
      continue;
      localTempSessionInfo.jdField_b_of_type_Long = paramMsg.group_code.get();
      localTempSessionInfo.c = paramMsg.group_uin.get();
    }
  }
  
  public static msg_svc.PbSendMsgReq a(MessageHandler paramMessageHandler, String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, TransMsgContext paramTransMsgContext, long paramLong, int paramInt3)
  {
    if (paramTransMsgContext == null) {
      paramMessageHandler = null;
    }
    do
    {
      return paramMessageHandler;
      int i = (short)(int)paramLong;
      int j = 0xFFFF & i;
      long l = paramTransMsgContext.jdField_a_of_type_ArrayOfByte.length;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "<PbSendMsg><S>--->createTempSessionSendMsgReq: routingType:13,toUin:" + paramString + ",msgUid:" + (0x0 | l << 16 | 0xA6) + ",msgSeq:" + paramLong + ",uint32Seq:" + j + ",shortSeq:" + i + ",randomNum:" + paramInt3 + ",msgContext:" + paramTransMsgContext);
      }
      paramMessageHandler = paramMessageHandler.a.a();
      msg_svc.RoutingHead localRoutingHead = new msg_svc.RoutingHead();
      Object localObject = new msg_svc.Trans0x211();
      ((msg_svc.Trans0x211)localObject).cc_cmd.set(paramTransMsgContext.jdField_a_of_type_Int);
      ((msg_svc.Trans0x211)localObject).to_uin.set(Long.valueOf(paramString).longValue());
      if (paramArrayOfByte != null) {
        ((msg_svc.Trans0x211)localObject).sig.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      }
      ((msg_svc.Trans0x211)localObject).c2c_type.set(paramInt1);
      ((msg_svc.Trans0x211)localObject).service_type.set(paramInt2);
      localRoutingHead.trans_0x211.set((MessageMicro)localObject);
      paramArrayOfByte = new msg_comm.ContentHead();
      paramArrayOfByte.pkg_num.set(1);
      paramArrayOfByte.div_seq.set(i);
      paramArrayOfByte.pkg_index.set(0);
      localObject = new im_msg_body.MsgBody();
      ((im_msg_body.MsgBody)localObject).msg_content.set(ByteStringMicro.copyFrom(paramTransMsgContext.jdField_a_of_type_ArrayOfByte));
      paramString = new msg_svc.PbSendMsgReq();
      paramString.routing_head.set(localRoutingHead);
      paramString.content_head.set(paramArrayOfByte);
      paramString.msg_body.set((MessageMicro)localObject);
      paramString.msg_seq.set(j);
      paramString.msg_rand.set(paramInt3);
      paramArrayOfByte = paramMessageHandler.a();
      paramMessageHandler = paramString;
    } while (paramArrayOfByte == null);
    paramString.sync_cookie.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    return paramString;
  }
  
  public static msg_svc.PbSendMsgReq a(QQAppInterface paramQQAppInterface, int paramInt1, MessageRecord paramMessageRecord, im_msg_body.RichText paramRichText, msg_comm.AppShareInfo paramAppShareInfo, int paramInt2)
  {
    if ((paramInt1 == 9) || (paramInt1 == 13) || (paramMessageRecord == null)) {
      return null;
    }
    long l = paramMessageRecord.msgUid;
    int k = (short)(int)paramMessageRecord.msgseq;
    int m = MessageUtils.a(l);
    MessageCache localMessageCache = paramQQAppInterface.a();
    msg_svc.RoutingHead localRoutingHead = new msg_svc.RoutingHead();
    int j = 0;
    int i = j;
    switch (paramInt1)
    {
    default: 
      i = j;
    }
    while (i == 0)
    {
      return null;
      paramQQAppInterface = new msg_svc.C2C();
      paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      localRoutingHead.c2c.set(paramQQAppInterface);
      i = 1;
      continue;
      paramQQAppInterface = new msg_svc.Grp();
      paramQQAppInterface.group_code.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      localRoutingHead.grp.set(paramQQAppInterface);
      i = 1;
      continue;
      paramQQAppInterface = new msg_svc.GrpTmp();
      paramQQAppInterface.group_uin.set(Long.valueOf(paramMessageRecord.senderuin).longValue());
      paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      localRoutingHead.grp_tmp.set(paramQQAppInterface);
      i = 1;
      continue;
      paramQQAppInterface = new msg_svc.Dis();
      paramQQAppInterface.dis_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      localRoutingHead.dis.set(paramQQAppInterface);
      i = 1;
      continue;
      paramQQAppInterface = new msg_svc.DisTmp();
      paramQQAppInterface.dis_uin.set(Long.valueOf(paramMessageRecord.senderuin).longValue());
      paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      localRoutingHead.dis_tmp.set(paramQQAppInterface);
      i = 1;
      continue;
      paramQQAppInterface = localMessageCache.b(paramMessageRecord.frienduin);
      Object localObject = new msg_svc.WPATmp();
      ((msg_svc.WPATmp)localObject).to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      byte[] arrayOfByte;
      if (paramQQAppInterface != null)
      {
        arrayOfByte = new byte[paramQQAppInterface.length - 2];
        PkgTools.a(arrayOfByte, 0, paramQQAppInterface, 2, paramQQAppInterface.length - 2);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "wpa------>" + HexUtil.a(arrayOfByte) + ",length:" + arrayOfByte.length);
        }
        ((msg_svc.WPATmp)localObject).sig.set(ByteStringMicro.copyFrom(arrayOfByte));
      }
      localRoutingHead.wpa_tmp.set((MessageMicro)localObject);
      i = 1;
      continue;
      paramQQAppInterface = localMessageCache.c(paramMessageRecord.frienduin);
      localObject = new msg_svc.QQQueryBusinessTmp();
      ((msg_svc.QQQueryBusinessTmp)localObject).to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      if (paramQQAppInterface != null)
      {
        arrayOfByte = new byte[paramQQAppInterface.length - 2];
        PkgTools.a(arrayOfByte, 0, paramQQAppInterface, 2, paramQQAppInterface.length - 2);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "wpa------>" + HexUtil.a(arrayOfByte) + ",length:" + arrayOfByte.length);
        }
        ((msg_svc.QQQueryBusinessTmp)localObject).sig.set(ByteStringMicro.copyFrom(arrayOfByte));
      }
      localRoutingHead.qq_querybusiness_tmp.set((MessageMicro)localObject);
      i = 1;
      continue;
      localObject = localMessageCache.d(paramMessageRecord.frienduin);
      paramQQAppInterface = new msg_svc.BusinessWPATmp();
      paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "conversation------>sig:" + HexUtil.a((byte[])localObject) + ",length:" + localObject.length);
        }
        paramQQAppInterface.sig.set(ByteStringMicro.copyFrom((byte[])localObject));
      }
      localObject = localMessageCache.e(paramMessageRecord.frienduin);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "conversation------>sigt:" + HexUtil.a((byte[])localObject) + ",length:" + localObject.length);
        }
        paramQQAppInterface.sigt.set(ByteStringMicro.copyFrom((byte[])localObject));
      }
      localRoutingHead.business_wpa_tmp.set(paramQQAppInterface);
      i = 1;
      continue;
      paramQQAppInterface = new msg_svc.AddressListTmp();
      paramQQAppInterface.from_phone.set(paramMessageRecord.senderuin);
      paramQQAppInterface.to_phone.set(paramMessageRecord.frienduin);
      localObject = localMessageCache.f(paramMessageRecord.frienduin);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "sameState------>" + HexUtil.a((byte[])localObject) + ",length:" + localObject.length);
        }
        paramQQAppInterface.sig.set(ByteStringMicro.copyFrom((byte[])localObject));
      }
      localRoutingHead.address_list.set(paramQQAppInterface);
      i = 1;
      continue;
      paramQQAppInterface = localMessageCache.a(paramMessageRecord.frienduin);
      localObject = new msg_svc.PublicPlat();
      ((msg_svc.PublicPlat)localObject).to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      if (paramQQAppInterface != null)
      {
        arrayOfByte = new byte[paramQQAppInterface.length - 2];
        PkgTools.a(arrayOfByte, 0, paramQQAppInterface, 2, paramQQAppInterface.length - 2);
        ((msg_svc.PublicPlat)localObject).sig.set(ByteStringMicro.copyFrom(arrayOfByte));
      }
      localRoutingHead.public_plat.set((MessageMicro)localObject);
      i = 1;
      continue;
      paramQQAppInterface = new msg_svc.RichStatusTmp();
      paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      localObject = localMessageCache.j(paramMessageRecord.frienduin);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "sameState------>" + HexUtil.a((byte[])localObject) + ",length:" + localObject.length);
        }
        paramQQAppInterface.sig.set(ByteStringMicro.copyFrom((byte[])localObject));
      }
      localRoutingHead.rich_status_tmp.set(paramQQAppInterface);
      i = 1;
      continue;
      localObject = new msg_svc.AccostTmp();
      ((msg_svc.AccostTmp)localObject).to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      paramQQAppInterface = paramQQAppInterface.a().a(paramMessageRecord.frienduin, 1001);
      ((msg_svc.AccostTmp)localObject).reply.set(paramQQAppInterface.hasReply);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "LBSFriend------>reply=" + paramQQAppInterface.hasReply);
      }
      paramQQAppInterface = localMessageCache.k(paramMessageRecord.frienduin);
      if (paramQQAppInterface != null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("fight_accost", 4, "发送附近人临时会消息 有keyLBSFriend------>" + HexUtil.a(paramQQAppInterface) + ",length:" + paramQQAppInterface.length);
        }
        ((msg_svc.AccostTmp)localObject).sig.set(ByteStringMicro.copyFrom(paramQQAppInterface));
      }
      localRoutingHead.accost_tmp.set((MessageMicro)localObject);
      i = 1;
      continue;
      paramQQAppInterface = new msg_svc.PubGroupTmp();
      paramQQAppInterface.group_uin.set(Long.valueOf(paramMessageRecord.senderuin).longValue());
      paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      localRoutingHead.pub_group_tmp.set(paramQQAppInterface);
      i = 1;
      continue;
      paramQQAppInterface = new msg_svc.BsnsTmp();
      paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      localObject = localMessageCache.g(paramMessageRecord.frienduin);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "circleGroup------>" + HexUtil.a((byte[])localObject) + ",length:" + localObject.length);
        }
        paramQQAppInterface.sig.set(ByteStringMicro.copyFrom((byte[])localObject));
      }
      localRoutingHead.bsns_tmp.set(paramQQAppInterface);
      i = 1;
      continue;
      paramQQAppInterface = new msg_svc.AuthTmp();
      paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      localObject = localMessageCache.i(paramMessageRecord.frienduin);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "friendValidation------>" + HexUtil.a((byte[])localObject) + ",length:" + localObject.length);
        }
        paramQQAppInterface.sig.set(ByteStringMicro.copyFrom((byte[])localObject));
      }
      localRoutingHead.auth_tmp.set(paramQQAppInterface);
      i = 1;
    }
    paramQQAppInterface = new msg_comm.ContentHead();
    paramQQAppInterface.pkg_num.set(paramMessageRecord.longMsgCount);
    paramQQAppInterface.div_seq.set(paramMessageRecord.longMsgId);
    paramQQAppInterface.pkg_index.set(paramMessageRecord.longMsgIndex);
    paramMessageRecord = new im_msg_body.MsgBody();
    paramMessageRecord.rich_text.set(paramRichText);
    paramRichText = new msg_svc.PbSendMsgReq();
    paramRichText.routing_head.set(localRoutingHead);
    paramRichText.content_head.set(paramQQAppInterface);
    paramRichText.msg_body.set(paramMessageRecord);
    paramRichText.msg_seq.set(k & 0xFFFF);
    paramRichText.msg_rand.set(m);
    if ((paramInt1 != 2) && (paramInt1 != 4))
    {
      paramQQAppInterface = localMessageCache.a();
      if (paramQQAppInterface != null) {
        paramRichText.sync_cookie.set(ByteStringMicro.copyFrom(paramQQAppInterface));
      }
    }
    if (paramAppShareInfo != null) {
      paramRichText.app_share.set(paramAppShareInfo);
    }
    paramRichText.msg_via.set(paramInt2);
    return paramRichText;
  }
  
  public static msg_svc.PbSendMsgReq a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString, TransMsgContext paramTransMsgContext, long paramLong, int paramInt2)
  {
    if (paramTransMsgContext == null) {
      paramQQAppInterface = null;
    }
    label338:
    do
    {
      return paramQQAppInterface;
      int j = (short)(int)paramLong;
      int k = 0xFFFF & j;
      long l;
      msg_svc.RoutingHead localRoutingHead;
      if ((paramInt1 == 9) || (paramInt1 == 13))
      {
        l = 0x0 | paramTransMsgContext.jdField_a_of_type_ArrayOfByte.length << 16 | 0xA6;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "<PbSendMsg><S>--->createPbSendMsgReq: routingType:" + paramInt1 + ",toUin:" + paramString + ",msgUid:" + l + ",msgSeq:" + paramLong + ",uint32Seq:" + k + ",shortSeq:" + j + ",randomNum:" + paramInt2 + ",msgContext:" + paramTransMsgContext);
        }
        paramQQAppInterface = paramQQAppInterface.a();
        localRoutingHead = new msg_svc.RoutingHead();
        int i = 0;
        switch (paramInt1)
        {
        default: 
          paramInt1 = i;
        }
      }
      for (;;)
      {
        if (paramInt1 != 0) {
          break label338;
        }
        return null;
        l = 0x0 | paramInt2;
        break;
        localObject = new msg_svc.TransMsg();
        ((msg_svc.TransMsg)localObject).c2c_cmd.set(paramTransMsgContext.jdField_a_of_type_Int);
        ((msg_svc.TransMsg)localObject).to_uin.set(Long.valueOf(paramString).longValue());
        localRoutingHead.trans_msg.set((MessageMicro)localObject);
        paramInt1 = 1;
        continue;
        localObject = new msg_svc.Trans0x211();
        ((msg_svc.Trans0x211)localObject).cc_cmd.set(paramTransMsgContext.jdField_a_of_type_Int);
        paramString = paramString.replace("+", "");
        ((msg_svc.Trans0x211)localObject).to_uin.set(Long.valueOf(paramString).longValue());
        localRoutingHead.trans_0x211.set((MessageMicro)localObject);
        paramInt1 = 1;
      }
      Object localObject = new msg_comm.ContentHead();
      ((msg_comm.ContentHead)localObject).pkg_num.set(1);
      ((msg_comm.ContentHead)localObject).div_seq.set(j);
      ((msg_comm.ContentHead)localObject).pkg_index.set(0);
      im_msg_body.MsgBody localMsgBody = new im_msg_body.MsgBody();
      localMsgBody.msg_content.set(ByteStringMicro.copyFrom(paramTransMsgContext.jdField_a_of_type_ArrayOfByte));
      paramString = new msg_svc.PbSendMsgReq();
      paramString.routing_head.set(localRoutingHead);
      paramString.content_head.set((MessageMicro)localObject);
      paramString.msg_body.set(localMsgBody);
      paramString.msg_seq.set(k);
      paramString.msg_rand.set(paramInt2);
      paramTransMsgContext = paramQQAppInterface.a();
      paramQQAppInterface = paramString;
    } while (paramTransMsgContext == null);
    paramString.sync_cookie.set(ByteStringMicro.copyFrom(paramTransMsgContext));
    return paramString;
  }
  
  private static im_msg_body.Elem a(im_msg_body.RichText paramRichText, String paramString)
  {
    im_msg_body.Text localText = new im_msg_body.Text();
    localText.str.set(ByteStringMicro.copyFromUtf8(paramString));
    paramString = new im_msg_body.Elem();
    paramString.text.set(localText);
    paramRichText.elems.add(paramString);
    return paramString;
  }
  
  public static im_msg_body.RichText a(ChatMessage paramChatMessage)
  {
    if (paramChatMessage != null)
    {
      if ((paramChatMessage instanceof MessageForPic)) {
        return ((MessageForPic)paramChatMessage).richText;
      }
      if ((paramChatMessage instanceof MessageForPtt)) {
        return ((MessageForPtt)paramChatMessage).richText;
      }
    }
    return null;
  }
  
  public static im_msg_body.RichText a(FunnyFaceMessage paramFunnyFaceMessage)
  {
    im_msg_body.FunFace localFunFace = new im_msg_body.FunFace();
    Object localObject;
    if (paramFunnyFaceMessage.faceId == 1)
    {
      localObject = new im_msg_body.FunFace.Turntable();
      Iterator localIterator = paramFunnyFaceMessage.turntable.uinList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ((im_msg_body.FunFace.Turntable)localObject).rpt_uint64_uin_list.add(Long.valueOf(str));
      }
      ((im_msg_body.FunFace.Turntable)localObject).uint64_hit_uin.set(Long.valueOf(paramFunnyFaceMessage.turntable.hitUin).longValue());
      localFunFace.msg_turntable.set((MessageMicro)localObject);
    }
    for (;;)
    {
      paramFunnyFaceMessage = new im_msg_body.RichText();
      localObject = new im_msg_body.Elem();
      ((im_msg_body.Elem)localObject).fun_face.set(localFunFace);
      paramFunnyFaceMessage.elems.add((MessageMicro)localObject);
      return paramFunnyFaceMessage;
      if (paramFunnyFaceMessage.faceId == 2)
      {
        localObject = new im_msg_body.FunFace.Bomb();
        ((im_msg_body.FunFace.Bomb)localObject).bool_burst.set(paramFunnyFaceMessage.bomb.isBurst);
        localFunFace.msg_bomb.set((MessageMicro)localObject);
      }
    }
  }
  
  public static im_msg_body.RichText a(MarkFaceMessage paramMarkFaceMessage, String paramString, boolean paramBoolean)
  {
    Object localObject = new im_msg_body.MarketFace();
    if (paramMarkFaceMessage.sbufID != null) {
      ((im_msg_body.MarketFace)localObject).bytes_face_id.set(ByteStringMicro.copyFrom(paramMarkFaceMessage.sbufID));
    }
    if ((paramBoolean) && (paramString != null)) {
      ((im_msg_body.MarketFace)localObject).bytes_face_name.set(ByteStringMicro.copyFromUtf8(paramString));
    }
    if (paramMarkFaceMessage.sbfKey != null) {
      ((im_msg_body.MarketFace)localObject).bytes_key.set(ByteStringMicro.copyFrom(paramMarkFaceMessage.sbfKey));
    }
    ((im_msg_body.MarketFace)localObject).uint32_face_info.set(paramMarkFaceMessage.cFaceInfo);
    ((im_msg_body.MarketFace)localObject).uint32_item_type.set(paramMarkFaceMessage.dwMSGItemType);
    ((im_msg_body.MarketFace)localObject).uint32_sub_type.set(paramMarkFaceMessage.cSubType);
    ((im_msg_body.MarketFace)localObject).uint32_tab_id.set(paramMarkFaceMessage.dwTabID);
    ((im_msg_body.MarketFace)localObject).uint32_media_type.set(paramMarkFaceMessage.mediaType);
    ((im_msg_body.MarketFace)localObject).uint32_image_width.set(paramMarkFaceMessage.imageWidth);
    ((im_msg_body.MarketFace)localObject).uint32_image_height.set(paramMarkFaceMessage.imageHeight);
    if ((paramMarkFaceMessage.mobileparam != null) && (paramMarkFaceMessage.mobileparam.length > 0)) {
      ((im_msg_body.MarketFace)localObject).bytes_mobileparam.set(ByteStringMicro.copyFrom(paramMarkFaceMessage.mobileparam));
    }
    paramMarkFaceMessage = new im_msg_body.Text();
    paramMarkFaceMessage.str.set(ByteStringMicro.copyFromUtf8(paramString));
    paramString = new im_msg_body.RichText();
    im_msg_body.Elem localElem = new im_msg_body.Elem();
    localElem.market_face.set((MessageMicro)localObject);
    paramString.elems.add(localElem);
    localObject = new im_msg_body.Elem();
    ((im_msg_body.Elem)localObject).text.set(paramMarkFaceMessage);
    paramString.elems.add((MessageMicro)localObject);
    return paramString;
  }
  
  public static im_msg_body.RichText a(MessageForFunnyFace paramMessageForFunnyFace)
  {
    if ((paramMessageForFunnyFace == null) || (paramMessageForFunnyFace.mFunnyFaceMessage == null)) {
      return null;
    }
    return a(paramMessageForFunnyFace.mFunnyFaceMessage);
  }
  
  public static im_msg_body.RichText a(MessageForMarketFace paramMessageForMarketFace)
  {
    if ((paramMessageForMarketFace == null) || (paramMessageForMarketFace.mMarkFaceMessage == null)) {
      return null;
    }
    String str = "[" + paramMessageForMarketFace.mMarkFaceMessage.faceName + "]";
    boolean bool = true;
    if (paramMessageForMarketFace.istroop == 3000) {
      bool = false;
    }
    return a(paramMessageForMarketFace.mMarkFaceMessage, str, bool);
  }
  
  public static im_msg_body.RichText a(MessageForShakeWindow paramMessageForShakeWindow)
  {
    if ((paramMessageForShakeWindow == null) || (paramMessageForShakeWindow.mShakeWindowMsg == null)) {
      return null;
    }
    im_msg_body.RichText localRichText = new im_msg_body.RichText();
    im_msg_body.ShakeWindow localShakeWindow = new im_msg_body.ShakeWindow();
    localShakeWindow.uint32_type.set(paramMessageForShakeWindow.mShakeWindowMsg.mType);
    paramMessageForShakeWindow = new im_msg_body.Elem();
    paramMessageForShakeWindow.shake_window.set(localShakeWindow);
    localRichText.elems.add(paramMessageForShakeWindow);
    return localRichText;
  }
  
  public static im_msg_body.RichText a(MessageForStructing paramMessageForStructing)
  {
    im_msg_body.RichText localRichText = null;
    Object localObject1 = localRichText;
    if (paramMessageForStructing != null)
    {
      if (paramMessageForStructing.structingMsg != null) {
        break label19;
      }
      localObject1 = localRichText;
    }
    label19:
    do
    {
      do
      {
        return localObject1;
        if (paramMessageForStructing.richText != null) {
          return paramMessageForStructing.richText;
        }
        localObject2 = paramMessageForStructing.structingMsg.getXmlBytes();
        localObject1 = localRichText;
      } while (localObject2 == null);
      localObject1 = new im_msg_body.RichMsg();
      ((im_msg_body.RichMsg)localObject1).bytes_template_1.set(ByteStringMicro.copyFrom((byte[])localObject2));
      ((im_msg_body.RichMsg)localObject1).uint32_service_id.set(paramMessageForStructing.structingMsg.mMsgServiceID);
      localRichText = new im_msg_body.RichText();
      localObject2 = new im_msg_body.Elem();
      ((im_msg_body.Elem)localObject2).rich_msg.set((MessageMicro)localObject1);
      localRichText.elems.add((MessageMicro)localObject2);
      localObject1 = localRichText;
    } while (TextUtils.isEmpty(paramMessageForStructing.structingMsg.mCompatibleText));
    localObject1 = new im_msg_body.Elem();
    Object localObject2 = new im_msg_body.Text();
    ((im_msg_body.Text)localObject2).str.set(ByteStringMicro.copyFrom(paramMessageForStructing.structingMsg.mCompatibleText.getBytes()));
    ((im_msg_body.Elem)localObject1).text.set((MessageMicro)localObject2);
    localRichText.elems.add((MessageMicro)localObject1);
    return localRichText;
  }
  
  public static im_msg_body.RichText a(MessageForText paramMessageForText)
  {
    im_msg_body.RichText localRichText2 = new im_msg_body.RichText();
    im_msg_body.RichText localRichText1 = localRichText2;
    if (a(localRichText2, paramMessageForText.msg, paramMessageForText.atInfoList, paramMessageForText.frienduin) <= 0) {
      localRichText1 = null;
    }
    return localRichText1;
  }
  
  private static void a(long paramLong1, long paramLong2, int paramInt) {}
  
  public static void a(MessageHandler paramMessageHandler, long paramLong1, int paramInt1, long paramLong2, int paramInt2)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", paramMessageHandler.a.a(), "MessageSvc.PbDeleteMsg");
    msg_svc.PbDeleteMsgReq localPbDeleteMsgReq = new msg_svc.PbDeleteMsgReq();
    msg_svc.PbDeleteMsgReq.MsgItem localMsgItem = new msg_svc.PbDeleteMsgReq.MsgItem();
    localMsgItem.from_uin.set(paramLong1);
    localMsgItem.msg_seq.set(paramInt1);
    localMsgItem.msg_uid.set(paramLong2);
    paramLong2 = 0L;
    try
    {
      paramLong1 = Long.parseLong(paramMessageHandler.a.a());
      localMsgItem.to_uin.set(paramLong1);
      localMsgItem.msg_type.set(paramInt2);
      localPbDeleteMsgReq.msgItems.add(localMsgItem);
      localToServiceMsg.putWupBuffer(localPbDeleteMsgReq.toByteArray());
      localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
      paramMessageHandler.a.a(localToServiceMsg);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramLong1 = paramLong2;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.msg.MessageHandler", 2, localException.getMessage());
          paramLong1 = paramLong2;
        }
      }
    }
  }
  
  public static void a(MessageHandler paramMessageHandler, long paramLong, msg_comm.Msg paramMsg, boolean paramBoolean)
  {
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has())) {}
    int i;
    for (;;)
    {
      return;
      msg_comm.MsgType0x210 localMsgType0x210 = new msg_comm.MsgType0x210();
      try
      {
        localMsgType0x210 = (msg_comm.MsgType0x210)localMsgType0x210.mergeFrom(((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray());
        if (localMsgType0x210 == null)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_MsgType0x210 : msgType0x210 is null.");
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_MsgType0x210 : failed.", localException);
          }
          localObject = null;
        }
        if ((!((msg_comm.MsgType0x210)localObject).sub_msg_type.has()) || (!((msg_comm.MsgType0x210)localObject).msg_content.has()))
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_MsgType0x210 : msgType0x210 require more info: hasType:" + ((msg_comm.MsgType0x210)localObject).sub_msg_type.has() + ",hasMsgContent:" + ((msg_comm.MsgType0x210)localObject).msg_content.has());
          }
        }
        else
        {
          i = ((msg_comm.MsgType0x210)localObject).sub_msg_type.get();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_MsgType0x210 : msgType0x210 type:" + i);
          }
          switch (i)
          {
          }
        }
      }
    }
    return;
    a(paramMessageHandler, paramMsg, paramBoolean);
    return;
    ((ShieldListHandler)paramMessageHandler.a.a(17)).a(((msg_comm.MsgType0x210)localObject).msg_content.get().toByteArray());
    return;
    a(paramMessageHandler, (msg_comm.MsgType0x210)localObject);
    return;
    ((SttManager)paramMessageHandler.a.getManager(15)).a(((msg_comm.MsgType0x210)localObject).msg_content.get().toByteArray());
    return;
    ((PublicAccountHandler)paramMessageHandler.a.a(10)).a(i, ((msg_comm.MsgType0x210)localObject).msg_content.get().toByteArray());
    return;
    if (QLog.isColorLevel()) {
      QLog.d("Q.troopgetnews.", 2, "decodeC2CMsgPkg_MsgType0x210, receive troop news push");
    }
    ((TroopHandler)paramMessageHandler.a.a(19)).a(((msg_comm.MsgType0x210)localObject).msg_content.get().toByteArray());
    return;
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationHelper", 2, "get notice from decodeC2CMsgPkg_MsgType0x210");
    }
    Object localObject = ((msg_comm.MsgType0x210)localObject).msg_content.get().toByteArray();
    a(paramMessageHandler.a, (byte[])localObject);
    a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
    return;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_MsgType0x210 : subtype 0x51");
    }
    paramMessageHandler.a((msg_comm.MsgType0x210)localObject, paramMsg);
    a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
  }
  
  public static void a(MessageHandler paramMessageHandler, MsgInfo paramMsgInfo, SlaveMasterMsg paramSlaveMasterMsg)
  {
    Object localObject = new SubMsgType0x4.MsgBody();
    try
    {
      localObject = (SubMsgType0x4.MsgBody)((SubMsgType0x4.MsgBody)localObject).mergeFrom(paramSlaveMasterMsg.vOrigMsg);
      if (!((SubMsgType0x4.MsgBody)localObject).msg_not_online_file.has())
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : MsgBody has not NotOnlineFile");
        }
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramMessageHandler)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[0x4] failed", paramMessageHandler);
      return;
    }
    localObject = (im_msg_body.NotOnlineFile)((SubMsgType0x4.MsgBody)localObject).msg_not_online_file.get();
    ArrayList localArrayList = new ArrayList();
    msg_comm.Msg localMsg = new msg_comm.Msg();
    localMsg.msg_head.msg_uid.set(paramMsgInfo.lMsgUid);
    localMsg.msg_head.msg_time.set(paramMsgInfo.uRealMsgTime);
    localMsg.msg_head.from_uin.set(paramSlaveMasterMsg.lFromUin);
    localMsg.msg_head.msg_seq.set((int)paramSlaveMasterMsg.uSeq);
    paramMessageHandler.a.a().a(paramMessageHandler, localArrayList, localMsg, (im_msg_body.NotOnlineFile)localObject, String.valueOf(paramSlaveMasterMsg.lToUin), true, false, -100L);
  }
  
  public static void a(MessageHandler paramMessageHandler, List paramList, int paramInt, msg_comm.Msg paramMsg, long paramLong1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, long paramLong2, boolean paramBoolean4)
  {
    StringBuilder localStringBuilder = new StringBuilder("<---decodeC2CMsgPkg_OfflineFile : ");
    localStringBuilder.append(" c2cCmd:").append(paramInt).append(";friendUin:").append(paramLong1).append(";isReaded:").append(paramBoolean1).append(";isPullRoam:").append(paramBoolean2).append(";isSelfSender:").append(paramBoolean3).append(";\n");
    long l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
    long l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
    int i = (short)((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has())) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_OfflineFile return null:hasBody:" + paramMsg.msg_body.has() + "hasRichT:" + ((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has());
      }
    }
    Object localObject1;
    do
    {
      do
      {
        return;
        localObject2 = (im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get();
        localObject1 = (im_msg_body.NotOnlineFile)((im_msg_body.RichText)localObject2).not_online_file.get();
        if (((im_msg_body.RichText)localObject2).not_online_file.has()) {
          break;
        }
        localStringBuilder.append("hasNotOnlineFile:").append(((im_msg_body.RichText)localObject2).not_online_file.has()).append(";hasUUID:").append(((im_msg_body.NotOnlineFile)localObject1).bytes_file_uuid.has());
      } while (!QLog.isColorLevel());
      QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
      return;
      if ((paramInt != 169) && (paramInt != 243)) {
        break;
      }
    } while (paramBoolean4);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<FileAssistant>offlineFile come: c2cCmd[" + paramInt + "]");
    }
    paramMessageHandler.a.a().a(paramMessageHandler, paramList, paramMsg, (im_msg_body.NotOnlineFile)localObject1, String.valueOf(paramLong1), paramBoolean1, paramBoolean2, paramLong2);
    return;
    Object localObject2 = new String(((im_msg_body.NotOnlineFile)localObject1).bytes_file_uuid.get().toStringUtf8() + l2);
    paramMsg = ((im_msg_body.NotOnlineFile)localObject1).bytes_file_uuid.get().toStringUtf8();
    localStringBuilder.append("     NotOnLineFile info : serverPath:").append(paramMsg).append(";fileKey :").append((String)localObject2).append(";");
    if (!paramMessageHandler.a().a((String)localObject2))
    {
      paramMessageHandler = ((im_msg_body.NotOnlineFile)localObject1).bytes_file_name.get().toStringUtf8();
      localStringBuilder.append("strFileName:").append(paramMessageHandler).append(";");
      paramLong1 = ((im_msg_body.NotOnlineFile)localObject1).uint64_file_size.get();
      if ((paramInt == 241) || (MessageUtils.a(paramMessageHandler, paramInt)))
      {
        paramMessageHandler = new RichMsg.PicRec();
        paramMessageHandler.localPath.set(paramMsg);
        paramMessageHandler.size.set(paramLong1);
        paramMessageHandler.type.set(1);
        paramMessageHandler.isRead.set(false);
        paramMessageHandler.uuid.set(paramMsg);
        paramMessageHandler.serverStorageSource.set("ftn");
        paramMessageHandler.version.set(5);
        paramMessageHandler.isReport.set(0);
        paramMsg = (MessageForPic)MessageRecordFactory.a(-2000);
        paramMsg.msgtype = -2000;
        paramMsg.msgData = paramMessageHandler.toByteArray();
        paramMsg.parse();
        paramList.add(paramMsg);
        paramMessageHandler = null;
      }
    }
    for (;;)
    {
      localStringBuilder.append("protocolStr:").append(paramMessageHandler).append(";");
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label1046;
        }
        QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
        return;
        if ((paramInt != 242) && (!MessageUtils.b(paramMessageHandler, paramInt))) {
          break label1048;
        }
        if ((paramMessageHandler != null) && (!paramMessageHandler.equals("")))
        {
          if (!paramMessageHandler.contains("_")) {}
          for (paramMessageHandler = paramMessageHandler.substring(0, paramMessageHandler.length() - 4);; paramMessageHandler = paramMessageHandler.substring(paramMessageHandler.lastIndexOf("_") + 1, paramMessageHandler.length() - 4))
          {
            paramMessageHandler = l1 + paramMessageHandler;
            localStringBuilder.append("c2cCmd:0xf2;key:").append(paramMessageHandler).append(";");
            if (paramBoolean4) {
              break label879;
            }
            if (!StreamDataManager.e(paramMessageHandler)) {
              break;
            }
            localStringBuilder.append("DuplicateKey:").append(paramMessageHandler).append(";");
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
            }
            StreamDataManager.d(paramMessageHandler);
            return;
          }
          StreamDataManager.c(paramMessageHandler);
        }
        for (;;)
        {
          label879:
          paramMessageHandler = TransfileUtile.a(paramMsg, paramLong1, 2, false, paramMsg, null, "ftn");
          localObject1 = new RichMsg.PttRec();
          ((RichMsg.PttRec)localObject1).localPath.set(paramMsg);
          ((RichMsg.PttRec)localObject1).size.set(paramLong1);
          ((RichMsg.PttRec)localObject1).type.set(2);
          ((RichMsg.PttRec)localObject1).uuid.set(paramMsg);
          ((RichMsg.PttRec)localObject1).isRead.set(false);
          ((RichMsg.PttRec)localObject1).serverStorageSource.set("ftn");
          ((RichMsg.PttRec)localObject1).isReport.set(0);
          ((RichMsg.PttRec)localObject1).version.set(5);
          paramMsg = (MessageForPtt)MessageRecordFactory.a(-2002);
          paramMsg.msgtype = -2002;
          paramMsg.msgData = ((RichMsg.PttRec)localObject1).toByteArray();
          paramMsg.parse();
          paramList.add(paramMsg);
          break;
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "offline ptt no filename");
          }
        }
        localStringBuilder.append("rcv a repeated offline file push msg");
      }
      label1046:
      break;
      label1048:
      paramMessageHandler = null;
    }
  }
  
  public static void a(MessageHandler paramMessageHandler, List paramList, msg_comm.Msg paramMsg)
  {
    long l3 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has())) {}
    im_msg_body.Ptt localPtt;
    do
    {
      return;
      paramMsg = (im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get();
      localPtt = (im_msg_body.Ptt)paramMsg.ptt.get();
      if ((paramMsg.ptt.has()) && (localPtt.uint32_file_type.has()) && ((localPtt.uint32_file_type.get() == 4) || (localPtt.uint32_file_type.get() == 6)) && (localPtt.bytes_file_uuid.has())) {
        break;
      }
    } while (!QLog.isColorLevel());
    paramMessageHandler = new StringBuilder("<---decodeC2CMsgPkg_PTT return null:");
    if (localPtt == null) {
      paramMessageHandler.append(" ptt is null.");
    }
    for (;;)
    {
      QLog.d("Q.msg.MessageHandler", 2, paramMessageHandler.toString());
      return;
      paramMessageHandler.append(" HasileType:").append(localPtt.uint32_file_type.has()).append(" fileType:").append(localPtt.uint32_file_type.get()).append(" hasUUID:").append(localPtt.bytes_file_uuid.has());
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "PTT_ROAM : decodeC2CMsgPkg_PTT. fileType : " + localPtt.uint32_file_type.get());
    }
    int i;
    long l2;
    long l1;
    int k;
    label357:
    int m;
    int n;
    if (SttManager.a(paramMessageHandler.a))
    {
      i = 1;
      l2 = -1L;
      j = i;
      l1 = l2;
      if (!localPtt.bytes_reserve.has()) {
        break label574;
      }
      paramMsg = localPtt.bytes_reserve.get().toByteArray();
      j = i;
      l1 = l2;
      if (paramMsg == null) {
        break label574;
      }
      j = i;
      l1 = l2;
      if (paramMsg.length <= 1) {
        break label574;
      }
      j = paramMsg[0];
      l1 = -1L;
      k = 1;
      if (k >= paramMsg.length - 1) {
        break label571;
      }
      m = paramMsg[k];
      j = k + 1;
      k = PkgTools.a(paramMsg, j);
      n = j + 2;
      if (m != 2) {
        break label472;
      }
      localObject = new byte[k];
      PkgTools.a((byte[])localObject, 0, paramMsg, n, k);
      l2 = l1;
      j = i;
      if (localObject.length > 0)
      {
        l2 = l1;
        j = i;
        if (localObject[0] == 1)
        {
          j = 1;
          l2 = l1;
        }
      }
    }
    for (;;)
    {
      k = n + k;
      l1 = l2;
      i = j;
      break label357;
      i = 0;
      break;
      label472:
      l2 = l1;
      j = i;
      if (m == 3)
      {
        localObject = new byte[k];
        PkgTools.a((byte[])localObject, 0, paramMsg, n, k);
        l2 = PkgTools.a((byte[])localObject, 0);
        if (l2 > 0L) {
          l1 = l2;
        }
        l2 = l1;
        j = i;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.msg.MessageHandler", 2, "PTT_ROAM : TimeStamp in d0 :" + l1);
          l2 = l1;
          j = i;
        }
      }
    }
    label571:
    int j = i;
    label574:
    Object localObject = localPtt.bytes_file_uuid.get().toStringUtf8();
    paramMsg = localPtt.bytes_file_name.get().toStringUtf8();
    if (!paramMsg.contains("_")) {}
    for (paramMsg = paramMsg.substring(0, paramMsg.length() - 4);; paramMsg = paramMsg.substring(paramMsg.lastIndexOf("_") + 1, paramMsg.length() - 4))
    {
      paramMsg = l3 + "_" + paramMsg;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_PTT isPttSuffix offfile key：" + paramMsg + " fileUuid:" + (String)localObject);
      }
      paramMsg = new RichMsg.PttRec();
      paramMsg.localPath.set((String)localObject);
      paramMsg.size.set(localPtt.uint32_file_size.get());
      paramMsg.type.set(2);
      paramMsg.uuid.set((String)localObject);
      paramMsg.isRead.set(false);
      paramMsg.serverStorageSource.set("pttcenter");
      paramMsg.isReport.set(0);
      paramMsg.version.set(5);
      paramMsg.pttFlag.set(j);
      i = MessageUtils.a(paramMessageHandler.a, String.valueOf(l3));
      paramMsg.longPttVipFlag.set(i);
      paramMessageHandler = MessageRecordFactory.a(-2002);
      paramMessageHandler.msgtype = -2002;
      paramMessageHandler.msgData = paramMsg.toByteArray();
      paramMessageHandler.time = l1;
      ((MessageForPtt)paramMessageHandler).parse();
      paramList.add(paramMessageHandler);
      return;
    }
  }
  
  public static void a(MessageHandler paramMessageHandler, List paramList, msg_comm.Msg paramMsg, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    msg_comm.AppShareInfo localAppShareInfo = (msg_comm.AppShareInfo)paramMsg.appshare_info.get();
    long l1;
    Object localObject1;
    Object localObject2;
    if (paramMsg.appshare_info.has())
    {
      l1 = localAppShareInfo.appshare_id.get() & 0xFFFFFFFF;
      localObject1 = (msg_comm.PluginInfo)localAppShareInfo.appshare_resource.get();
      if ((!localAppShareInfo.appshare_resource.has()) || (localObject1 == null) || (paramBoolean)) {
        break label1881;
      }
      localObject1 = AppShareIDUtil.a((msg_comm.PluginInfo)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared appShareID:" + ((AppShareID)localObject1).toString());
      }
      localObject2 = (AppShareID)paramMessageHandler.a().a(AppShareID.class, "strPkgName=?", new String[] { ((AppShareID)localObject1).strPkgName });
      if (localObject2 == null)
      {
        paramMessageHandler.a().a((Entity)localObject1);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared Persist DB appid = " + ((AppShareID)localObject1).strPkgName);
        }
        paramMessageHandler.a.a().a(((AppShareID)localObject1).strPkgName, (AppShareID)localObject1);
      }
    }
    label301:
    label569:
    label1869:
    label1878:
    label1881:
    for (int i = 1;; i = 0)
    {
      Object localObject3;
      boolean bool1;
      boolean bool2;
      boolean bool3;
      if ((paramMsg.msg_body.has()) && (((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has()))
      {
        localObject1 = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get();
        paramMsg = null;
        localObject2 = BaseApplication.getContext().getString(2131561551);
        Iterator localIterator = ((List)localObject1).iterator();
        paramBoolean = false;
        localObject3 = null;
        bool1 = false;
        if (localIterator.hasNext())
        {
          localObject1 = (im_msg_body.Elem)localIterator.next();
          bool2 = ((im_msg_body.Elem)localObject1).text.has();
          bool3 = ((im_msg_body.Elem)localObject1).not_online_image.has();
          if (!bool3) {
            break label1878;
          }
          paramBoolean = true;
        }
      }
      for (;;)
      {
        if (bool2) {
          bool1 = true;
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared hasText:" + bool2 + ",hasNotOnlineImage:" + bool3);
          }
          int j;
          Object localObject4;
          if (bool3)
          {
            localObject1 = (im_msg_body.NotOnlineImage)((im_msg_body.Elem)localObject1).not_online_image.get();
            j = ((im_msg_body.NotOnlineImage)localObject1).file_len.get();
            if (!((im_msg_body.NotOnlineImage)localObject1).download_path.has()) {
              break label1869;
            }
            localObject4 = ((im_msg_body.NotOnlineImage)localObject1).download_path.get().toStringUtf8();
            localObject1 = localObject4;
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared: serverPath:" + (String)localObject4);
            }
          }
          for (localObject1 = localObject4;; localObject1 = null)
          {
            if (localObject1 != null)
            {
              localObject3 = new RichMsg.PicRec();
              localObject4 = ((RichMsg.PicRec)localObject3).localPath;
              if (localObject1 != null)
              {
                localObject2 = localObject1;
                ((PBStringField)localObject4).set((String)localObject2);
                ((RichMsg.PicRec)localObject3).size.set(j);
                ((RichMsg.PicRec)localObject3).type.set(1);
                localObject4 = ((RichMsg.PicRec)localObject3).uuid;
                if (localObject1 == null) {
                  break label774;
                }
                localObject2 = localObject1;
                ((PBStringField)localObject4).set((String)localObject2);
                localObject2 = TransfileUtile.a((String)localObject1, j, 1, false, (String)localObject1);
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared: content:" + (String)localObject2);
                }
              }
            }
            for (localObject1 = localObject3;; localObject1 = localObject3)
            {
              localObject3 = localObject1;
              for (;;)
              {
                break label301;
                if ((((AppShareID)localObject1).uiNewVer != ((AppShareID)localObject2).uiNewVer) || (Math.abs(((AppShareID)localObject2).updateTime - ((AppShareID)localObject1).updateTime) > 86400000L))
                {
                  paramMessageHandler.a().b((Entity)localObject2);
                  paramMessageHandler.a().a((Entity)localObject1);
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared Update DB appid = " + ((AppShareID)localObject1).strPkgName);
                  break;
                }
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared Not need update DB appid = " + ((AppShareID)localObject1).strPkgName);
                break;
                localObject2 = "";
                break label526;
                localObject2 = "";
                break label569;
                if (bool2)
                {
                  localObject1 = (im_msg_body.Text)((im_msg_body.Elem)localObject1).text.get();
                  paramMsg = ((im_msg_body.Text)localObject1).str.get().toStringUtf8();
                  if (QLog.isColorLevel())
                  {
                    QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared actionUrl:" + paramMsg + ",hasLink:" + ((im_msg_body.Text)localObject1).link.has() + ",str:" + ((im_msg_body.Text)localObject1).str.has() + ",strC:" + ((im_msg_body.Text)localObject1).str.get().toStringUtf8());
                    QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared : bytes:" + ((im_msg_body.Text)localObject1).str.get().size() + ",cont:" + ((im_msg_body.Text)localObject1).str.get() + ",content:" + Arrays.toString(((im_msg_body.Text)localObject1).str.get().toByteArray()));
                  }
                }
                else if (((im_msg_body.Elem)localObject1).custom_face.has())
                {
                  Object localObject6 = (im_msg_body.CustomFace)((im_msg_body.Elem)localObject1).custom_face.get();
                  localObject1 = ((im_msg_body.CustomFace)localObject6).str_file_path.get();
                  localObject2 = ((im_msg_body.CustomFace)localObject6).str_shortcut.get();
                  localObject3 = ((im_msg_body.CustomFace)localObject6).str_big_url.get();
                  localObject4 = ((im_msg_body.CustomFace)localObject6).str_orig_url.get();
                  String str = ((im_msg_body.CustomFace)localObject6).str_thumb_url.get();
                  long l2 = ((im_msg_body.CustomFace)localObject6).uint32_file_id.get();
                  long l3 = ((im_msg_body.CustomFace)localObject6).uint32_file_type.get();
                  long l4 = ((im_msg_body.CustomFace)localObject6).uint32_server_ip.get();
                  long l5 = ((im_msg_body.CustomFace)localObject6).uint32_server_port.get();
                  long l6 = ((im_msg_body.CustomFace)localObject6).uint32_useful.get();
                  Object localObject7 = ((im_msg_body.CustomFace)localObject6).bytes_md5.get().toByteArray();
                  Object localObject5 = ((im_msg_body.CustomFace)localObject6).bytes_signature.get().toByteArray();
                  ((im_msg_body.CustomFace)localObject6).bytes_buffer.get().toByteArray();
                  localObject6 = ((im_msg_body.CustomFace)localObject6).bytes_flag.get().toByteArray();
                  localObject7 = HexUtil.a((byte[])localObject7);
                  localObject5 = HexUtil.a((byte[])localObject5);
                  localObject6 = HexUtil.a((byte[])localObject6);
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgElems: decode CustomFace, dump customFace info: filePath:" + (String)localObject1 + ", shortCut:" + (String)localObject2 + ", fileID:" + (l2 & 0xFFFFFFFF) + ", fileType:" + (l3 & 0xFFFFFFFF) + ", serverIP:" + (l4 & 0xFFFFFFFF) + ", serverPort" + (l5 & 0xFFFFFFFF) + ", useful" + (l6 & 0xFFFFFFFF) + ",md5:" + (String)localObject7 + ",signature:" + (String)localObject5 + ",flag:" + (String)localObject6 + ",downURLBig:" + (String)localObject3 + ",downURLOri:" + (String)localObject4 + ",downURLThum:" + str);
                  }
                  localObject1 = "http://quntu.3g.qq.com/cgi/svr/chatimg/get?pic=" + (String)localObject1 + "&gid=" + paramLong1 + "&time=" + paramLong2 + "&msfid=" + paramMessageHandler.a.a();
                  localObject3 = new RichMsg.PicRec();
                  localObject4 = ((RichMsg.PicRec)localObject3).localPath;
                  if (localObject1 != null)
                  {
                    localObject2 = localObject1;
                    ((PBStringField)localObject4).set((String)localObject2);
                    ((RichMsg.PicRec)localObject3).size.set(0L);
                    ((RichMsg.PicRec)localObject3).type.set(1);
                    localObject4 = ((RichMsg.PicRec)localObject3).uuid;
                    if (localObject1 == null) {
                      break label1522;
                    }
                  }
                  label1522:
                  for (localObject2 = localObject1;; localObject2 = "")
                  {
                    ((PBStringField)localObject4).set((String)localObject2);
                    localObject2 = TransfileUtile.a((String)localObject1, 0L, 1, false, (String)localObject1);
                    paramBoolean = true;
                    break;
                    localObject2 = "";
                    break label1448;
                  }
                  if ((paramBoolean) && (!bool1))
                  {
                    paramMsg = (MessageForPic)MessageRecordFactory.a(-2000);
                    paramMsg.msgtype = -2000;
                    paramMsg.msgData = ((RichMsg.PicRec)localObject3).toByteArray();
                    paramMsg.msg = ((String)localObject2);
                    paramMsg.parse();
                    paramList.add(paramMsg);
                  }
                  for (;;)
                  {
                    if (i == 0) {
                      paramMessageHandler.a(Long.valueOf(l1));
                    }
                    return;
                    if ((!paramBoolean) && (bool1))
                    {
                      paramMessageHandler = (MessageForText)MessageRecordFactory.a(-1000);
                      paramMessageHandler.msgtype = -1000;
                      paramMessageHandler.msg = paramMsg;
                      paramList.add(paramMessageHandler);
                      return;
                    }
                    localObject1 = paramMsg.trim();
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared: hasPicCnt:" + paramBoolean + ",hasTextCnt:" + bool1);
                    }
                    paramMessageHandler.d(String.valueOf(AppShareIDUtil.b(l1)));
                    paramMsg = ActionMsgUtil.a(localAppShareInfo.appshare_cookie.get().toByteArray());
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared: content:" + (String)localObject2 + ",opType:" + paramMsg.jdField_b_of_type_Int);
                    }
                    localObject1 = ActionMsgUtil.a((String)localObject2, (String)localObject1, l1, paramMsg.a);
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared : content:" + (String)localObject2 + ",encodeMsg:" + (String)localObject1);
                    }
                    localObject2 = MessageRecordFactory.a(paramMsg.jdField_b_of_type_Int);
                    ((MessageRecord)localObject2).msgtype = paramMsg.jdField_b_of_type_Int;
                    ((MessageRecord)localObject2).msg = ((String)localObject1);
                    paramList.add(localObject2);
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static void a(MessageHandler paramMessageHandler, List paramList, msg_comm.Msg paramMsg, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    label48:
    Object localObject1;
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has()) || (!((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_cmd.has()))
    {
      return;
    }
    else
    {
      while (!paramMsg.content_head.has()) {
        if (QLog.isColorLevel())
        {
          QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMessagePackage: msg doesn't has the contentHead.");
          return;
        }
      }
      localObject1 = (msg_comm.ContentHead)paramMsg.content_head.get();
      if ((!((msg_comm.ContentHead)localObject1).auto_reply.has()) || (((msg_comm.ContentHead)localObject1).auto_reply.get() != 1)) {
        break label428;
      }
    }
    label428:
    for (paramBoolean2 = true;; paramBoolean2 = false)
    {
      localObject1 = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder(128);
        ((StringBuilder)localObject2).append("<---decodeC2CMsgPkg_Buddy:elems size:").append(((List)localObject1).size()).append(" isAutoReply:").append(paramBoolean2);
        QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject2).toString());
      }
      if (!paramBoolean2) {
        break label434;
      }
      if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
        break label48;
      }
      paramMsg = BaseApplication.getContext().getString(2131561538);
      localObject1 = ((List)localObject1).iterator();
      if (!((Iterator)localObject1).hasNext()) {
        break label48;
      }
      Object localObject2 = (im_msg_body.Elem)((Iterator)localObject1).next();
      if (!((im_msg_body.Elem)localObject2).text.has()) {
        break;
      }
      localObject1 = (im_msg_body.Text)((im_msg_body.Elem)localObject2).text.get();
      if ((BaseApplication.getContext().getSharedPreferences("share", 0).getString("no_auto_reply" + paramMessageHandler.a.a(), "").contains("NAR" + paramLong + ",")) || (paramBoolean1)) {
        break label48;
      }
      paramMessageHandler = paramMsg + " " + ((im_msg_body.Text)localObject1).str.get().toStringUtf8();
      paramMsg = MessageRecordFactory.a(-10000);
      paramMsg.msgtype = -10000;
      paramMsg.msg = paramMessageHandler;
      paramList.add(paramMsg);
      return;
    }
    label434:
    a(paramMessageHandler, paramList, paramMsg, true, paramBoolean1, null);
  }
  
  public static void a(MessageHandler paramMessageHandler, List paramList, msg_comm.Msg paramMsg, long paramLong1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, long paramLong2, boolean paramBoolean4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211");
    }
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has())) {}
    byte[] arrayOfByte;
    label425:
    label441:
    label491:
    label766:
    do
    {
      for (;;)
      {
        return;
        try
        {
          arrayOfByte = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
          i = ((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_cmd.get();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[" + i + "]");
          }
          switch (i)
          {
          case 5: 
          case 6: 
          default: 
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[" + i + "] is not implemented");
            return;
          }
        }
        catch (Exception paramMessageHandler) {}
        if (QLog.isColorLevel())
        {
          QLog.e("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : failed.", paramMessageHandler);
          return;
          paramList = new SubMsgType0x3.MsgBody();
          int j;
          int k;
          for (;;)
          {
            try
            {
              paramList.mergeFrom(arrayOfByte);
              if (!paramList.msg_fail_notify.has()) {
                break label537;
              }
              j = 0;
              paramList = (SubMsgType0x3.FailNotify)paramList.msg_fail_notify.get();
              if (!paramList.uint32_sessionid.has()) {
                break label425;
              }
              k = paramList.uint32_sessionid.get();
              if (!paramList.uint32_retCode.has()) {
                break label441;
              }
              i = paramList.uint32_retCode.get();
              if (!paramList.bytes_reason.has()) {
                break label491;
              }
              paramList = new String(paramList.bytes_reason.get().toStringUtf8());
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : FailNotify sessionId[" + k + "], retCode[" + i + "], reason[" + paramList + "]");
              }
              paramMessageHandler.a.a().a(String.valueOf(paramLong1), k, i, paramList);
              return;
            }
            catch (InvalidProtocolBufferMicroException paramMessageHandler) {}
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.e("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[0x3] failed", paramMessageHandler);
            return;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.e("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : failNotify has not sessionId");
            return;
            i = j;
            if (QLog.isColorLevel())
            {
              QLog.w("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : sessionId[" + k + "], failNotify has not RetCode");
              i = j;
              continue;
              if (QLog.isColorLevel()) {
                QLog.w("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : sessionId[" + k + "], failNotify has not reason");
              }
              paramList = "";
            }
          }
          if (paramList.msg_progress_notify.has())
          {
            j = 0;
            paramList = (SubMsgType0x3.ProgressNotify)paramList.msg_progress_notify.get();
            if (paramList.uint32_sessionid.has())
            {
              k = paramList.uint32_sessionid.get();
              if (!paramList.uint32_progress.has()) {
                break label716;
              }
              i = paramList.uint32_progress.get();
              if (!paramList.uint32_average_speed.has()) {
                break label766;
              }
            }
            for (j = paramList.uint32_average_speed.get();; j = 0)
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : progressNotify sessionId[" + k + "], progress[" + i + "], speed[" + j + "]");
              }
              paramMessageHandler.a.a().a(String.valueOf(paramLong1), k, i, j);
              return;
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.e("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : progressNotify has not sessionId");
              return;
              i = j;
              if (!QLog.isColorLevel()) {
                break label599;
              }
              QLog.w("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : sessionId[" + k + "], progressNotify has not Progress");
              i = j;
              break label599;
              if (QLog.isColorLevel()) {
                QLog.w("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : sessionId[" + k + "], progressNotify has not AverageSpeed");
              }
            }
          }
          if (QLog.isColorLevel())
          {
            QLog.e("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : progressNotify has neither failNotify not progressNotify");
            return;
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "<FileAssistant>offlineFile come: cmd[0x211, 0x4]");
            }
            localObject = new SubMsgType0x4.MsgBody();
            try
            {
              localObject = (SubMsgType0x4.MsgBody)((SubMsgType0x4.MsgBody)localObject).mergeFrom(arrayOfByte);
              if (((SubMsgType0x4.MsgBody)localObject).msg_not_online_file.has()) {
                break label908;
              }
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.e("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : MsgBody has not NotOnlineFile");
              return;
            }
            catch (InvalidProtocolBufferMicroException paramMessageHandler) {}
            if (QLog.isColorLevel())
            {
              QLog.e("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[0x4] failed", paramMessageHandler);
              return;
              localObject = (im_msg_body.NotOnlineFile)((SubMsgType0x4.MsgBody)localObject).msg_not_online_file.get();
              if (paramBoolean4)
              {
                paramMessageHandler = new MessageRecord();
                paramLong2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
                paramMessageHandler.senderuin = Long.toString(((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get());
                paramMessageHandler.msgtype = -2005;
                paramMessageHandler.frienduin = Long.toString(paramLong1);
                paramMessageHandler.time = paramLong2;
                paramList.add(paramMessageHandler);
                return;
              }
              paramMessageHandler.a.a().a(paramMessageHandler, paramList, paramMsg, (im_msg_body.NotOnlineFile)localObject, String.valueOf(paramLong1), paramBoolean1, paramBoolean2, paramLong2);
              return;
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "<dataline> message come: cmd[0x211, 0x7]");
              }
              paramList = new SubMsgType0x7.MsgBody();
              try
              {
                paramList = (SubMsgType0x7.MsgBody)paramList.mergeFrom(arrayOfByte);
                if (!paramBoolean4)
                {
                  ((DataLineHandler)paramMessageHandler.a.a(8)).a(paramMsg, paramList);
                  return;
                }
              }
              catch (InvalidProtocolBufferMicroException paramMessageHandler) {}
            }
          }
        }
      }
    } while (!QLog.isColorLevel());
    label537:
    label599:
    QLog.e("Q.msg.MessageHandler", 2, "<dataline><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[0x7] failed", paramMessageHandler);
    label716:
    return;
    label908:
    paramLong1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
    int i = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
    paramLong2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_uid.get();
    long l = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
    paramList = null;
    if (((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_tmp_msg_head.has()) {
      localObject = ((msg_comm.C2CTmpMsgHead)((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_tmp_msg_head.get()).toByteArray();
    }
    try
    {
      paramMsg = ((msg_comm.C2CTmpMsgHead)((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_tmp_msg_head.get()).sig.get().toByteArray();
      paramList = (List)localObject;
      if (paramMsg != null)
      {
        FMDataCache.a(String.valueOf(paramLong1), paramMsg);
        paramList = (List)localObject;
      }
    }
    catch (Exception paramList)
    {
      for (;;)
      {
        paramList = (List)localObject;
      }
    }
    paramMessageHandler.a.a().a(paramLong1, i, paramLong2, l, paramList, arrayOfByte);
  }
  
  public static void a(MessageHandler paramMessageHandler, List paramList, msg_comm.Msg paramMsg, TempSessionInfo paramTempSessionInfo, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    Object localObject1 = (msg_comm.MsgHead)paramMsg.msg_head.get();
    if ((!((msg_comm.MsgHead)localObject1).c2c_tmp_msg_head.has()) || (!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has())) {}
    int i;
    int j;
    Object localObject2;
    do
    {
      return;
      localObject1 = (msg_comm.C2CTmpMsgHead)((msg_comm.MsgHead)localObject1).c2c_tmp_msg_head.get();
      i = ((msg_comm.C2CTmpMsgHead)localObject1).c2c_type.get();
      j = ((msg_comm.C2CTmpMsgHead)localObject1).service_type.get();
      if ((paramDecodeProtoPkgContext.d) || (paramTempSessionInfo.jdField_b_of_type_Int != 1006)) {
        break label220;
      }
      localObject2 = ((msg_comm.C2CTmpMsgHead)localObject1).from_phone.get();
      if ((((msg_comm.C2CTmpMsgHead)localObject1).from_phone.has()) && (localObject2 != null) && (!((String)localObject2).equals("+0"))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_Temp2 : contact fromPhoneNum error : " + ((msg_comm.C2CTmpMsgHead)localObject1).from_phone.get());
    return;
    ContactUtils.a(paramMessageHandler.a, ((msg_comm.C2CTmpMsgHead)localObject1).from_phone.get(), paramDecodeProtoPkgContext.e + "");
    label220:
    if ((!paramDecodeProtoPkgContext.d) && (((msg_comm.C2CTmpMsgHead)localObject1).sig.has()))
    {
      localObject2 = ((msg_comm.C2CTmpMsgHead)localObject1).sig.get().toByteArray();
      localObject1 = localObject2;
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.msg.MessageHandler", 4, "tempHead.sig.get()----> sig:" + HexUtil.a((byte[])localObject2) + ",length:" + localObject2.length);
      }
    }
    for (localObject1 = localObject2;; localObject1 = null)
    {
      for (;;)
      {
        if (localObject1 != null) {}
        switch (paramTempSessionInfo.jdField_b_of_type_Int)
        {
        default: 
          label400:
          j = 0;
          i = j;
          if (paramMsg.content_head.has())
          {
            i = j;
            if (((msg_comm.ContentHead)paramMsg.content_head.get()).auto_reply.has()) {
              if (((msg_comm.ContentHead)paramMsg.content_head.get()).auto_reply.get() != 1) {
                break label1036;
              }
            }
          }
          break;
        }
        label1036:
        for (i = 1;; i = 0)
        {
          localObject1 = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get();
          if (i == 0) {
            break label1042;
          }
          if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
            break;
          }
          paramMsg = (im_msg_body.Text)((im_msg_body.Elem)((List)localObject1).get(0)).text.get();
          if ((BaseApplication.getContext().getSharedPreferences("share", 0).getString("no_auto_reply" + paramMessageHandler.a.a(), "").contains("NAR" + paramDecodeProtoPkgContext.e + ",")) || (paramDecodeProtoPkgContext.b)) {
            break;
          }
          paramMessageHandler = BaseApplication.getContext().getString(2131561538) + " " + paramMsg.str.get().toStringUtf8();
          paramMsg = MessageRecordFactory.a(-10000);
          paramMsg.msgtype = -10000;
          paramMsg.msg = paramMessageHandler;
          paramList.add(paramMsg);
          return;
          localObject2 = new byte[localObject1.length + 2];
          localObject2[0] = ((byte)i);
          localObject2[1] = ((byte)j);
          PkgTools.a((byte[])localObject2, 2, (byte[])localObject1, 0, localObject1.length);
          paramMessageHandler.a.a().a(String.valueOf(paramDecodeProtoPkgContext.e), (byte[])localObject2);
          break label400;
          localObject2 = new byte[localObject1.length + 2];
          localObject2[0] = ((byte)i);
          localObject2[1] = ((byte)j);
          PkgTools.a((byte[])localObject2, 2, (byte[])localObject1, 0, localObject1.length);
          paramMessageHandler.a.a().b(String.valueOf(paramDecodeProtoPkgContext.e), (byte[])localObject2);
          break label400;
          paramMessageHandler.a.a().c(String.valueOf(paramDecodeProtoPkgContext.e), (byte[])localObject1);
          break label400;
          localObject2 = new byte[localObject1.length + 2];
          localObject2[0] = ((byte)i);
          localObject2[1] = ((byte)j);
          PkgTools.a((byte[])localObject2, 2, (byte[])localObject1, 0, localObject1.length);
          paramMessageHandler.a.a().e(String.valueOf(paramDecodeProtoPkgContext.e), (byte[])localObject2);
          break label400;
          localObject2 = new byte[localObject1.length + 2];
          localObject2[0] = ((byte)i);
          localObject2[1] = ((byte)j);
          PkgTools.a((byte[])localObject2, 2, (byte[])localObject1, 0, localObject1.length);
          paramMessageHandler.a.a().f(String.valueOf(paramDecodeProtoPkgContext.e), (byte[])localObject2);
          break label400;
          paramMessageHandler.a.a().g(String.valueOf(paramDecodeProtoPkgContext.e), (byte[])localObject1);
          break label400;
          paramMessageHandler.a.a().h(String.valueOf(paramDecodeProtoPkgContext.e), (byte[])localObject1);
          break label400;
          paramMessageHandler.a.a().i(String.valueOf(paramDecodeProtoPkgContext.e), (byte[])localObject1);
          break label400;
          paramMessageHandler.a.a().k(String.valueOf(paramDecodeProtoPkgContext.e), (byte[])localObject1);
          break label400;
        }
        label1042:
        if (paramTempSessionInfo == null) {
          break;
        }
        if ((((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_type.get() == 529) && (((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_cmd.get() == 6))
        {
          paramMessageHandler = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
          paramMsg = new im_msg_body.TmpPtt();
          try
          {
            paramMessageHandler = (im_msg_body.TmpPtt)paramMsg.mergeFrom(paramMessageHandler);
            if ((paramMessageHandler == null) || (!paramMessageHandler.uint32_file_type.has()) || (paramMessageHandler.uint32_file_type.get() != 4) || (!paramMessageHandler.bytes_file_uuid.has())) {
              break;
            }
            paramTempSessionInfo = paramMessageHandler.bytes_file_uuid.get().toStringUtf8();
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_Temp2 : ptt uuid:" + paramTempSessionInfo);
            }
            paramMsg = new RichMsg.PttRec();
            paramMsg.localPath.set(paramMessageHandler.bytes_file_uuid.get().toStringUtf8());
            paramMsg.size.set(paramMessageHandler.uint32_file_size.get());
            paramMsg.type.set(2);
            paramMsg.uuid.set(paramTempSessionInfo);
            paramMsg.isRead.set(false);
            paramMsg.serverStorageSource.set("pttcenter");
            paramMsg.isReport.set(0);
            paramMsg.version.set(5);
            paramMsg.pttFlag.set(0);
            j = 0;
            i = j;
            if (paramMessageHandler.uint32_user_type.has())
            {
              int k = paramMessageHandler.uint32_user_type.get();
              if (k != 1)
              {
                i = j;
                if (k != 2) {}
              }
              else
              {
                i = k;
              }
            }
            paramMsg.longPttVipFlag.set(i);
            paramMessageHandler = MessageRecordFactory.a(-2002);
            paramMessageHandler.msgtype = -2002;
            paramMessageHandler.msgData = paramMsg.toByteArray();
            ((MessageForPtt)paramMessageHandler).parse();
            paramList.add(paramMessageHandler);
            return;
          }
          catch (InvalidProtocolBufferMicroException paramMessageHandler)
          {
            for (;;)
            {
              paramMessageHandler.printStackTrace();
              paramMessageHandler = null;
            }
          }
        }
      }
      a(paramMessageHandler, paramList, paramMsg, true, paramDecodeProtoPkgContext.b, null);
      return;
    }
  }
  
  public static void a(MessageHandler paramMessageHandler, List paramList, msg_comm.Msg paramMsg, boolean paramBoolean1, boolean paramBoolean2, MessageInfo paramMessageInfo)
  {
    List localList = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get();
    Object localObject3 = null;
    StringBuilder localStringBuilder1 = new StringBuilder("<---decodePBMsgElems:");
    ArrayList localArrayList = new ArrayList();
    if ((localList == null) || (localList.size() <= 0))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder1.append("elems:null || elems.size() <= 0");
        QLog.d("Q.msg.MessageHandler", 2, localStringBuilder1.toString());
      }
      return;
    }
    if (QLog.isColorLevel()) {
      localStringBuilder1.append(" elemsSize:").append(localList.size()).append(";");
    }
    int m = 0;
    int k = 0;
    int i = 0;
    StringBuilder localStringBuilder2 = new StringBuilder("");
    Object localObject1 = null;
    Object localObject5 = null;
    int j = 0;
    long l4 = paramMsg.msg_head.msg_seq.get();
    boolean bool2 = a(localList);
    Object localObject4 = null;
    int i5 = 0;
    im_msg_body.Elem localElem;
    int n;
    Object localObject6;
    while (i5 < localList.size())
    {
      if (QLog.isColorLevel()) {
        localStringBuilder1.append("\n      Decode Elem[").append(i5).append("] : elem data : ");
      }
      localElem = (im_msg_body.Elem)localList.get(i5);
      if ((k == 0) || (!localElem.text.has())) {
        break label6480;
      }
      ((MarkFaceMessage)localObject3).faceName = ((im_msg_body.Text)localElem.text.get()).str.get().toStringUtf8();
      if ((((MarkFaceMessage)localObject3).faceName.charAt(0) == '[') && (((MarkFaceMessage)localObject3).faceName.charAt(((MarkFaceMessage)localObject3).faceName.length() - 1) == ']')) {
        ((MarkFaceMessage)localObject3).faceName = ((MarkFaceMessage)localObject3).faceName.substring(1, ((MarkFaceMessage)localObject3).faceName.length() - 1);
      }
      if (QLog.isColorLevel()) {
        localStringBuilder1.append("filter the text expalin:").append(((im_msg_body.Text)localElem.text.get()).str.get());
      }
      if (!bool2)
      {
        n = j;
        j = 0;
        k = m;
        localObject6 = localObject4;
        localObject4 = localObject3;
        localObject3 = localObject1;
        localObject1 = localObject5;
        m = n;
        localObject5 = localObject6;
        label409:
        i5 += 1;
        n = k;
        localObject6 = localObject4;
        k = j;
        localObject4 = localObject5;
        j = m;
        localObject5 = localObject1;
        localObject1 = localObject3;
        m = n;
        localObject3 = localObject6;
      }
      else
      {
        k = 0;
      }
    }
    label1190:
    label1199:
    label1219:
    label6342:
    label6474:
    label6480:
    for (;;)
    {
      Object localObject8;
      long l2;
      long l1;
      Object localObject10;
      if (localElem.rich_msg.has())
      {
        if (localStringBuilder2.length() > 0)
        {
          localObject6 = (MessageForText)MessageRecordFactory.a(-1000);
          ((MessageForText)localObject6).msgtype = -1000;
          ((MessageForText)localObject6).msg = localStringBuilder2.toString();
          localArrayList.add(localObject6);
          localStringBuilder2.delete(0, localStringBuilder2.length());
        }
        if (QLog.isColorLevel()) {
          localStringBuilder1.append("elemType:RichMsg;");
        }
        localObject8 = ((im_msg_body.RichMsg)localElem.rich_msg.get()).bytes_template_1.get().toByteArray();
        localObject6 = new MessageForStructing();
        ((MessageForStructing)localObject6).msgtype = -2011;
        l2 = paramMsg.msg_head.to_uin.get();
        j = paramMsg.msg_head.msg_type.get();
        if (j != 82)
        {
          l1 = l2;
          if (j != 43) {}
        }
        else
        {
          l1 = l2;
          if (paramMsg.msg_head.group_info != null)
          {
            l1 = l2;
            if (paramMsg.msg_head.group_info.group_code.has()) {
              l1 = paramMsg.msg_head.group_info.group_code.get();
            }
          }
        }
        ((MessageForStructing)localObject6).structingMsg = StructMsgFactory.a(paramMessageHandler.a, j, l1, (byte[])localObject8, -1);
        if (localObject4 != null) {
          ((MessageForStructing)localObject6).structingMsg.mCompatibleText = ((String)localObject4);
        }
        if (((MessageForStructing)localObject6).structingMsg != null) {
          ((MessageForStructing)localObject6).msgData = ((MessageForStructing)localObject6).structingMsg.getBytes();
        }
        ((MessageForStructing)localObject6).msg = "richMsg";
        if (((MessageForStructing)localObject6).structingMsg == null)
        {
          if (QLog.isColorLevel()) {
            localStringBuilder1.append("c2cMsgContent.data:null;");
          }
          localObject6 = localObject5;
          localObject8 = localObject1;
          j = 0;
          k = m;
          localObject10 = localObject3;
          m = 1;
          localObject5 = localObject4;
          localObject1 = localObject6;
          localObject3 = localObject8;
          localObject4 = localObject10;
          break label409;
        }
        localArrayList.add(localObject6);
        localObject8 = localObject1;
        j = 0;
        localObject10 = localObject3;
        n = 1;
        k = m;
        localObject5 = localObject4;
        m = n;
        localObject1 = localObject6;
        localObject3 = localObject8;
        localObject4 = localObject10;
        break label409;
      }
      int i4;
      label976:
      label1122:
      label1145:
      int i6;
      label1390:
      int i1;
      if (localElem.text.has())
      {
        if (QLog.isColorLevel()) {
          localStringBuilder1.append("elemType:Text;");
        }
        i4 = localStringBuilder2.length();
        localObject6 = (im_msg_body.Text)localElem.text.get();
        localObject4 = null;
        if (((im_msg_body.Text)localObject6).str.has())
        {
          localObject4 = ((im_msg_body.Text)localObject6).str.get().toStringUtf8();
          localStringBuilder2.append(MessageUtils.a((String)localObject4, false));
        }
        if ((j != 0) && (localObject5 != null))
        {
          localObject5.structingMsg.mCompatibleText = ((String)localObject4);
          if (localObject5.structingMsg != null) {
            localObject5.msgData = localObject5.structingMsg.getBytes();
          }
          if (localStringBuilder2.length() > 0)
          {
            paramMessageHandler = (MessageForText)MessageRecordFactory.a(-1000);
            paramMessageHandler.msgtype = -1000;
            paramMessageHandler.msg = localStringBuilder2.toString();
            localArrayList.add(paramMessageHandler);
          }
          if ((m > 0) && (localArrayList.size() == 1))
          {
            paramMessageHandler = (MessageRecord)localArrayList.get(0);
            if ((paramMessageHandler instanceof MessageForText))
            {
              paramMessageHandler.setRepeatCount(m);
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "MessageForText ====> repeatCount = " + paramMessageHandler.getRepeatCount());
              }
            }
          }
          paramMessageHandler = new ArrayList();
          if (j == 0) {
            break label6295;
          }
          if (localObject5 == null) {
            break label6267;
          }
          paramMessageHandler.add(localObject5);
          if (paramMessageHandler.size() <= 1) {
            break label6418;
          }
          paramMsg = paramMessageHandler.iterator();
          j = 0;
          i = 0;
          if (!paramMsg.hasNext()) {
            break label6418;
          }
          paramMessageInfo = (MessageRecord)paramMsg.next();
          if ((paramMessageInfo.msgtype != -1000) || (i != 0)) {
            break label6307;
          }
          i = 1;
          j += 1;
          if (j < 2) {
            break label6327;
          }
          i = 1;
          if (i == 0) {
            break label6404;
          }
          paramMsg = new ArrayList();
          paramMessageHandler = paramMessageHandler.iterator();
          for (;;)
          {
            if (!paramMessageHandler.hasNext()) {
              break label6342;
            }
            paramMessageInfo = (MessageRecord)paramMessageHandler.next();
            if ((paramMessageInfo.msgtype == -1000) || (paramMessageInfo.msgtype == -2000)) {
              break;
            }
            if (paramMsg.size() > 0)
            {
              paramList.add(a(paramMsg));
              paramMsg.clear();
            }
            paramList.add(paramMessageInfo);
          }
        }
        if ((localElem.text.attr_6_buf.has()) && (paramMsg.msg_head.from_uin.get() != paramMessageHandler.a.getLongAccountUin()) && (paramMessageInfo != null) && ((paramMessageInfo.a.a(l4)) || (paramMessageInfo.c.a(l4))))
        {
          localObject6 = localElem.text.attr_6_buf.get();
          if (localObject6 == null) {
            break label1565;
          }
          localObject6 = ((ByteStringMicro)localObject6).toByteArray();
          if ((localObject6 != null) && (localObject6.length != 0))
          {
            i6 = PkgTools.a((byte[])localObject6, 0);
            n = 2;
            i1 = 0;
            if ((i1 < i6) && (n < 2048))
            {
              localObject8 = new MessageForText.AtTroopMemberInfo();
              if (((MessageForText.AtTroopMemberInfo)localObject8).readFrom((byte[])localObject6, n)) {
                break label1571;
              }
            }
          }
        }
        n = j;
        j = k;
        k = n;
      }
      int i2;
      int i3;
      Object localObject13;
      String str;
      Object localObject11;
      Object localObject12;
      for (;;)
      {
        if ((localElem.elem_flags2.has()) && (localElem.elem_flags2.uint32_msg_rpt_cnt.has()))
        {
          n = localElem.elem_flags2.uint32_msg_rpt_cnt.get();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "decodePBMsgElems ====> msgRepeatCount = " + n);
          }
          localObject6 = localObject3;
          localObject3 = localObject1;
          localObject1 = localObject5;
          localObject5 = localObject4;
          m = k;
          k = n;
          localObject4 = localObject6;
          break;
          localObject6 = null;
          break label1390;
          i2 = n + ((MessageForText.AtTroopMemberInfo)localObject8).length();
          ((MessageForText.AtTroopMemberInfo)localObject8).startPos = ((short)(((MessageForText.AtTroopMemberInfo)localObject8).startPos + i4));
          i3 = (short)(i1 + 1);
          if (((MessageForText.AtTroopMemberInfo)localObject8).isIncludingAll()) {
            paramMessageInfo.c.a = l4;
          }
          i1 = i3;
          n = i2;
          if (!((MessageForText.AtTroopMemberInfo)localObject8).isIncludingMe(paramMessageHandler.a.getLongAccountUin())) {
            break label1415;
          }
          paramMessageInfo.a.a = l4;
          i1 = i3;
          n = i2;
          break label1415;
          if (localElem.shake_window.has())
          {
            if (QLog.isColorLevel()) {
              localStringBuilder1.append("elemType:ShakeWindow;");
            }
            localObject6 = (im_msg_body.ShakeWindow)localElem.shake_window.get();
            localObject8 = (MessageForShakeWindow)MessageRecordFactory.a(-2020);
            ((MessageForShakeWindow)localObject8).msgtype = -2020;
            ((MessageForShakeWindow)localObject8).msg = "[Shake Window]";
            localStringBuilder2.delete(0, localStringBuilder2.length());
            localObject10 = new ShakeWindowMsg();
            ((ShakeWindowMsg)localObject10).mType = ((im_msg_body.ShakeWindow)localObject6).uint32_type.get();
            ((ShakeWindowMsg)localObject10).mReserve = ((im_msg_body.ShakeWindow)localObject6).uint32_reserve.get();
            if (paramBoolean2) {}
            for (n = 2;; n = 1)
            {
              ((ShakeWindowMsg)localObject10).onlineFlag = n;
              ((ShakeWindowMsg)localObject10).shake = true;
              ((MessageForShakeWindow)localObject8).msgData = ((ShakeWindowMsg)localObject10).getBytes();
              if (((MessageForShakeWindow)localObject8).msgData != null) {
                break label1852;
              }
              if (QLog.isColorLevel()) {
                localStringBuilder1.append("c2cMsgContent.data:null;");
              }
              n = k;
              k = j;
              j = n;
              break;
            }
            localArrayList.add(localObject8);
            break label976;
          }
          if (localElem.face.has())
          {
            if (QLog.isColorLevel()) {
              localStringBuilder1.append("elemType:Face;");
            }
            if (!((im_msg_body.Face)localElem.face.get()).index.has()) {
              break label6459;
            }
            n = ((im_msg_body.Face)localElem.face.get()).index.get();
            if (n < MessageUtils.b.length)
            {
              n = MessageUtils.b[n];
              if (n >= 0)
              {
                localStringBuilder2.append('\024');
                localStringBuilder2.append((char)n);
              }
            }
            n = k;
            k = j;
            j = n;
          }
          else if (localElem.online_image.has())
          {
            if (QLog.isColorLevel()) {
              localStringBuilder1.append("elemType:OnlineImage;");
            }
            if (i != 0) {
              break label6459;
            }
            localStringBuilder2.append(BaseApplication.getContext().getString(2131561549));
            i = j;
            n = 1;
            j = k;
            k = i;
            i = n;
          }
          else if (localElem.not_online_image.has())
          {
            if (QLog.isColorLevel()) {
              localStringBuilder1.append("elemType:NotOnlineImage;");
            }
            if (localStringBuilder2.length() > 0)
            {
              localObject6 = (MessageForText)MessageRecordFactory.a(-1000);
              ((MessageForText)localObject6).msgtype = -1000;
              ((MessageForText)localObject6).msg = localStringBuilder2.toString();
              localArrayList.add(localObject6);
              localStringBuilder2.delete(0, localStringBuilder2.length());
            }
            BaseApplication.getContext().getString(2131561549);
            localObject13 = (im_msg_body.NotOnlineImage)localElem.not_online_image.get();
            n = ((im_msg_body.NotOnlineImage)localObject13).file_len.get();
            ((im_msg_body.NotOnlineImage)localObject13).flag.get().toByteArray();
            str = ((im_msg_body.NotOnlineImage)localObject13).str_thumb_url.get();
            i1 = ((im_msg_body.NotOnlineImage)localObject13).uint32_thumb_width.get();
            i2 = ((im_msg_body.NotOnlineImage)localObject13).uint32_thumb_height.get();
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "[NotOnlineImage] ThumbWidth=" + i1 + ",ThumbHeight=" + i2);
            }
            localObject11 = ((im_msg_body.NotOnlineImage)localObject13).str_big_url.get();
            localObject12 = ((im_msg_body.NotOnlineImage)localObject13).str_orig_url.get();
            i3 = ((im_msg_body.NotOnlineImage)localObject13).pic_width.get();
            i4 = ((im_msg_body.NotOnlineImage)localObject13).pic_height.get();
            i6 = ((im_msg_body.NotOnlineImage)localObject13).original.get();
            if (((im_msg_body.NotOnlineImage)localObject13).res_id.has()) {
              localObject6 = ((im_msg_body.NotOnlineImage)localObject13).res_id.get().toStringUtf8();
            }
          }
        }
      }
      for (;;)
      {
        long l3;
        long l5;
        long l6;
        Object localObject2;
        for (;;)
        {
          if ((localObject6 != null) && (!((String)localObject6).equals("")))
          {
            localObject10 = "";
            localObject8 = localObject10;
            if (((im_msg_body.NotOnlineImage)localObject13).pic_md5.has())
            {
              localObject13 = ((im_msg_body.NotOnlineImage)localObject13).pic_md5.get().toByteArray();
              localObject8 = localObject10;
              if (localObject13 != null)
              {
                localObject8 = localObject10;
                if (localObject13.length > 0) {
                  localObject8 = HexUtil.a((byte[])localObject13);
                }
              }
            }
            localObject13 = TransfileUtile.a((String)localObject6, n, 1, false, (String)localObject6, (String)localObject8, "picplatform", str, (String)localObject11, (String)localObject12, i6, 0);
            localObject10 = new RichMsg.PicRec();
            ((RichMsg.PicRec)localObject10).localPath.set((String)localObject6);
            ((RichMsg.PicRec)localObject10).size.set(n);
            ((RichMsg.PicRec)localObject10).type.set(1);
            ((RichMsg.PicRec)localObject10).isRead.set(false);
            ((RichMsg.PicRec)localObject10).uuid.set((String)localObject6);
            ((RichMsg.PicRec)localObject10).md5.set((String)localObject8);
            ((RichMsg.PicRec)localObject10).serverStorageSource.set("picplatform");
            ((RichMsg.PicRec)localObject10).thumbMsgUrl.set(str);
            ((RichMsg.PicRec)localObject10).uint32_thumb_width.set(i1);
            ((RichMsg.PicRec)localObject10).uint32_thumb_height.set(i2);
            ((RichMsg.PicRec)localObject10).bigMsgUrl.set((String)localObject11);
            ((RichMsg.PicRec)localObject10).rawMsgUrl.set((String)localObject12);
            ((RichMsg.PicRec)localObject10).fileSizeFlag.set(i6);
            ((RichMsg.PicRec)localObject10).uiOperatorFlag.set(0);
            ((RichMsg.PicRec)localObject10).version.set(5);
            ((RichMsg.PicRec)localObject10).isReport.set(0);
            if (QLog.isColorLevel()) {
              localStringBuilder1.append("content:").append((String)localObject13);
            }
            localObject6 = (MessageForPic)MessageRecordFactory.a(-2000);
            ((MessageForPic)localObject6).msgtype = -2000;
            ((MessageForPic)localObject6).msgData = ((RichMsg.PicRec)localObject10).toByteArray();
            ((MessageForPic)localObject6).width = i3;
            ((MessageForPic)localObject6).height = i4;
            ((MessageForPic)localObject6).parse();
            localArrayList.add(localObject6);
          }
          for (;;)
          {
            n = k;
            k = j;
            j = n;
            break;
            if (!((im_msg_body.NotOnlineImage)localObject13).download_path.has()) {
              break label6474;
            }
            localObject6 = ((im_msg_body.NotOnlineImage)localObject13).download_path.get().toStringUtf8();
            break label2330;
            if (QLog.isColorLevel()) {
              localStringBuilder1.append("serverPath is null or empty string : " + (String)localObject6);
            }
            localObject6 = (msg_comm.MsgHead)paramMsg.msg_head.get();
            l1 = ((msg_comm.MsgHead)localObject6).msg_seq.get();
            l2 = ((msg_comm.MsgHead)localObject6).msg_uid.get();
            l3 = ((msg_comm.MsgHead)localObject6).msg_time.get();
            l5 = ((msg_comm.MsgHead)localObject6).from_uin.get();
            l6 = ((msg_comm.MsgHead)localObject6).to_uin.get();
            localObject6 = new HashMap();
            ((HashMap)localObject6).put("param_FailCode", String.valueOf(10002));
            ((HashMap)localObject6).put("fromUin", String.valueOf(l5));
            ((HashMap)localObject6).put("toUin", String.valueOf(l6));
            ((HashMap)localObject6).put("msgSeq", String.valueOf(l1));
            ((HashMap)localObject6).put("msgUid", String.valueOf(l2));
            ((HashMap)localObject6).put("msgtime", String.valueOf(l3));
            localObject8 = paramMessageHandler.a.a();
            StatisticCollector.a(BaseApplication.getContext()).a((String)localObject8, "actMessageEvent", false, 0L, 0L, (HashMap)localObject6, "");
          }
          if (localElem.trans_elem_info.has())
          {
            if (QLog.isColorLevel()) {
              localStringBuilder1.append("elemType:TransElemInfo;");
            }
            localObject6 = (im_msg_body.TransElem)localElem.trans_elem_info.get();
            n = ((im_msg_body.TransElem)localObject6).elem_type.get();
            if (QLog.isColorLevel()) {
              localStringBuilder1.append("transElemType:").append(n).append(";");
            }
            if ((localStringBuilder2.length() > 0) && (n != 3))
            {
              localObject8 = (MessageForText)MessageRecordFactory.a(-1000);
              ((MessageForText)localObject8).msgtype = -1000;
              ((MessageForText)localObject8).msg = localStringBuilder2.toString();
              localArrayList.add(localObject8);
              localStringBuilder2.delete(0, localStringBuilder2.length());
            }
            localObject8 = ((im_msg_body.TransElem)localObject6).elem_value.get().toByteArray();
            if ((localObject8 == null) || (localObject8.length == 0))
            {
              localStringBuilder1.append("transElemByte is null or transElemByte.length == 0");
              localObject6 = localObject5;
              localObject8 = localObject1;
              n = m;
              localObject10 = localObject3;
              localObject5 = localObject4;
              m = j;
              localObject1 = localObject6;
              localObject3 = localObject8;
              j = k;
              k = n;
              localObject4 = localObject10;
              break;
            }
            switch (n)
            {
            default: 
              i4 = i;
              localObject6 = localObject1;
            }
            for (;;)
            {
              localObject1 = localObject6;
              i = i4;
              n = k;
              k = j;
              j = n;
              break;
              localObject6 = localObject1;
              i4 = i;
              if (i == 0)
              {
                localStringBuilder2.append(BaseApplication.getContext().getString(2131561549));
                i4 = 1;
                localObject6 = localObject1;
                continue;
                localObject6 = localObject1;
                i4 = i;
                if (localObject8[0] == 1)
                {
                  n = PkgTools.a((byte[])localObject8, 1);
                  i1 = localObject8[3];
                  localObject6 = new byte[n - 1];
                  PkgTools.a((byte[])localObject6, 0, (byte[])localObject8, 4, n - 1);
                  localObject10 = localObject6;
                  if (i1 == 1) {
                    localObject10 = a((byte[])localObject6);
                  }
                  localObject6 = localObject1;
                  if (localObject10 != null)
                  {
                    localObject8 = localObject1;
                    localObject6 = localObject1;
                    try
                    {
                      if (localObject10.length > 0)
                      {
                        localObject8 = localObject1;
                        localObject6 = new String((byte[])localObject10, "utf-8");
                        localObject8 = localObject1;
                        localStringBuilder2.append((String)localObject6);
                        localObject8 = localObject1;
                        localObject1 = a((String)localObject6);
                        localObject6 = localObject1;
                        if (localObject1 != null)
                        {
                          localObject8 = localObject1;
                          localObject10 = localList.iterator();
                          for (;;)
                          {
                            localObject8 = localObject1;
                            localObject6 = localObject1;
                            if (!((Iterator)localObject10).hasNext()) {
                              break;
                            }
                            localObject8 = localObject1;
                            localObject6 = (im_msg_body.Elem)((Iterator)localObject10).next();
                            localObject8 = localObject1;
                            if (((im_msg_body.Elem)localObject6).elem_flags2.has())
                            {
                              localObject8 = localObject1;
                              if (((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject6).elem_flags2.get()).uint64_msg_id.has())
                              {
                                localObject8 = localObject1;
                                ((PAMessage)localObject1).mMsgId = ((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject6).elem_flags2.get()).uint64_msg_id.get();
                              }
                            }
                          }
                        }
                      }
                      if (localObject6 == null) {
                        break label3601;
                      }
                    }
                    catch (Exception localException1)
                    {
                      localException1.printStackTrace();
                      localObject6 = localObject8;
                    }
                  }
                  else
                  {
                    localObject2 = (MessageForPubAccount)MessageRecordFactory.a(-3006);
                    ((MessageForPubAccount)localObject2).msgtype = -3006;
                    ((MessageForPubAccount)localObject2).msg = localStringBuilder2.toString();
                  }
                  try
                  {
                    ((MessageForPubAccount)localObject2).mPAMessage = ((PAMessage)localObject6);
                  }
                  catch (Exception localException3)
                  {
                    try
                    {
                      for (;;)
                      {
                        ((MessageForPubAccount)localObject2).msgData = PAMessageUtil.a((PAMessage)localObject6);
                        localArrayList.add(localObject2);
                        localStringBuilder2.delete(0, localStringBuilder2.length());
                        i4 = i;
                        break;
                        localException3 = localException3;
                        localException3.printStackTrace();
                      }
                    }
                    catch (Exception localException4)
                    {
                      for (;;)
                      {
                        localException4.printStackTrace();
                      }
                    }
                  }
                  i2 = ((im_msg_body.TransElem)localObject6).elem_value.get().size();
                  i1 = 0;
                  n = 0;
                  for (;;)
                  {
                    localObject6 = localObject2;
                    i4 = i;
                    if (i2 <= 3) {
                      break;
                    }
                    i3 = i1 + 1;
                    localObject6 = localObject2;
                    i4 = i;
                    if (i1 > 100) {
                      break;
                    }
                    i4 = localException4[n];
                    i6 = PkgTools.a(localException4, n + 1);
                    i1 = i2 - (i6 + 3);
                    i2 = i6 + 3 + n;
                    if (i4 != 1)
                    {
                      n = i2;
                      i2 = i1;
                      i1 = i3;
                    }
                    else
                    {
                      localObject6 = new byte[i6];
                      PkgTools.a((byte[])localObject6, 0, localException4, n + 3, i6);
                      localObject10 = new obj_msg.ObjMsg();
                      try
                      {
                        localObject6 = (obj_msg.ObjMsg)((obj_msg.ObjMsg)localObject10).mergeFrom((byte[])localObject6);
                        if (((obj_msg.ObjMsg)localObject6).uint32_msg_type.get() == 6L) {
                          break label3840;
                        }
                        n = i2;
                        i2 = i1;
                        i1 = i3;
                      }
                      catch (Exception localException2)
                      {
                        n = i2;
                        i2 = i1;
                        i1 = i3;
                      }
                    }
                  }
                  TroopFileData localTroopFileData = new TroopFileData();
                  localTroopFileData.fileUrl = new String(((obj_msg.MsgContentInfo)localException2.msg_content_info.get(0)).msg_file.bytes_file_path.get().toByteArray());
                  localTroopFileData.bisID = ((obj_msg.MsgContentInfo)localException2.msg_content_info.get(0)).msg_file.uint32_bus_id.get();
                  localTroopFileData.fileName = ((obj_msg.MsgContentInfo)localException2.msg_content_info.get(0)).msg_file.str_file_name.get();
                  localTroopFileData.lfileSize = ((obj_msg.MsgContentInfo)localException2.msg_content_info.get(0)).msg_file.uint64_file_size.get();
                  localTroopFileData.dspFileName = new String(localException2.bytes_title.get().toByteArray());
                  localTroopFileData.dspFileName = FileManagerUtil.a(localTroopFileData.dspFileName);
                  localTroopFileData.dspFileSize = new String(((ByteStringMicro)localException2.rpt_bytes_abstact.get(0)).toByteArray());
                  localStringBuilder2.append(BaseApplicationImpl.getContext().getString(2131559290));
                  localObject7 = (MessageForTroopFile)MessageRecordFactory.a(-2017);
                  ((MessageForTroopFile)localObject7).msgtype = -2017;
                  ((MessageForTroopFile)localObject7).msg = localStringBuilder2.toString();
                  try
                  {
                    ((MessageForTroopFile)localObject7).msgData = MessagePkgUtils.a(localTroopFileData);
                    ((MessageForTroopFile)localObject7).parse();
                    paramList.add(localObject7);
                    localStringBuilder2.delete(0, localStringBuilder2.length());
                    localObject7 = localObject2;
                    i4 = i;
                  }
                  catch (Exception localException5)
                  {
                    for (;;)
                    {
                      localException5.printStackTrace();
                    }
                  }
                }
              }
            }
          }
          if (localElem.market_face.has())
          {
            if (QLog.isColorLevel()) {
              localStringBuilder1.append("elemType:MarketFace;");
            }
            if (localStringBuilder2.length() > 0)
            {
              localObject7 = (MessageForText)MessageRecordFactory.a(-1000);
              ((MessageForText)localObject7).msgtype = -1000;
              ((MessageForText)localObject7).msg = localStringBuilder2.toString();
              localArrayList.add(localObject7);
              localStringBuilder2.delete(0, localStringBuilder2.length());
            }
            localObject7 = (im_msg_body.MarketFace)localElem.market_face.get();
            if (localObject7 != null)
            {
              localObject3 = new MarkFaceMessage();
              ((MarkFaceMessage)localObject3).cFaceInfo = ((im_msg_body.MarketFace)localObject7).uint32_face_info.get();
              ((MarkFaceMessage)localObject3).index = i5;
              ((MarkFaceMessage)localObject3).cSubType = ((im_msg_body.MarketFace)localObject7).uint32_sub_type.get();
              ((MarkFaceMessage)localObject3).dwMSGItemType = ((im_msg_body.MarketFace)localObject7).uint32_item_type.get();
              ((MarkFaceMessage)localObject3).dwTabID = ((im_msg_body.MarketFace)localObject7).uint32_tab_id.get();
              ((MarkFaceMessage)localObject3).sbfKey = ((im_msg_body.MarketFace)localObject7).bytes_key.get().toByteArray();
              ((MarkFaceMessage)localObject3).sbufID = ((im_msg_body.MarketFace)localObject7).bytes_face_id.get().toByteArray();
              ((MarkFaceMessage)localObject3).mediaType = ((im_msg_body.MarketFace)localObject7).uint32_media_type.get();
              ((MarkFaceMessage)localObject3).imageWidth = ((im_msg_body.MarketFace)localObject7).uint32_image_width.get();
              ((MarkFaceMessage)localObject3).imageHeight = ((im_msg_body.MarketFace)localObject7).uint32_image_height.get();
              ((MarkFaceMessage)localObject3).mobileparam = ((im_msg_body.MarketFace)localObject7).bytes_mobileparam.get().toByteArray();
              if (QLog.isColorLevel()) {
                localStringBuilder1.append(" mediaType = ").append(((MarkFaceMessage)localObject3).mediaType);
              }
              localStringBuilder2.append("it is marketface");
              localObject7 = (MessageForMarketFace)MessageRecordFactory.a(-2007);
              ((MessageForMarketFace)localObject7).msgtype = -2007;
              ((MessageForMarketFace)localObject7).msg = localStringBuilder2.toString();
              ((MessageForMarketFace)localObject7).mMarkFaceMessage = ((MarkFaceMessage)localObject3);
              if ((((MarkFaceMessage)localObject3).mobileparam != null) && (((MarkFaceMessage)localObject3).mobileparam.length > 0)) {
                ReportController.b(paramMessageHandler.a, "CliOper", "", "", "MbJieshou", "MbXiaoxi", 0, 0, "", "", "", "");
              }
            }
            try
            {
              ((MessageForMarketFace)localObject7).msgData = MessagePkgUtils.a((Serializable)localObject3);
              localArrayList.add(localObject7);
              localStringBuilder2.delete(0, localStringBuilder2.length());
              n = 1;
              k = j;
              j = n;
            }
            catch (Exception localException6)
            {
              for (;;)
              {
                localException6.printStackTrace();
              }
            }
          }
        }
        Object localObject9;
        if (localElem.custom_face.has())
        {
          if (QLog.isColorLevel()) {
            localStringBuilder1.append("elemType:CustomFace: isC2C:").append(paramBoolean1).append(";");
          }
          if (paramBoolean1)
          {
            localStringBuilder2.append(BaseApplication.getContext().getString(2131561549));
            localObject7 = (msg_comm.MsgHead)paramMsg.msg_head.get();
            l1 = ((msg_comm.MsgHead)localObject7).msg_seq.get();
            l2 = ((msg_comm.MsgHead)localObject7).msg_uid.get();
            l3 = ((msg_comm.MsgHead)localObject7).msg_time.get();
            l5 = ((msg_comm.MsgHead)localObject7).from_uin.get();
            l6 = ((msg_comm.MsgHead)localObject7).to_uin.get();
            localObject7 = new HashMap();
            ((HashMap)localObject7).put("param_FailCode", String.valueOf(10001));
            ((HashMap)localObject7).put("fromUin", String.valueOf(l5));
            ((HashMap)localObject7).put("toUin", String.valueOf(l6));
            ((HashMap)localObject7).put("msgSeq", String.valueOf(l1));
            ((HashMap)localObject7).put("msgUid", String.valueOf(l2));
            ((HashMap)localObject7).put("msgtime", String.valueOf(l3));
            localObject9 = paramMessageHandler.a.a();
            StatisticCollector.a(BaseApplication.getContext()).a((String)localObject9, "actMessageEvent", false, 0L, 0L, (HashMap)localObject7, "");
            localObject7 = localObject5;
            localObject9 = localObject2;
            n = m;
            localObject10 = localObject3;
            localObject5 = localObject4;
            m = j;
            localObject2 = localObject7;
            localObject3 = localObject9;
            j = k;
            k = n;
            localObject4 = localObject10;
            break label409;
          }
          if (localStringBuilder2.length() > 0)
          {
            localObject7 = (MessageForText)MessageRecordFactory.a(-1000);
            ((MessageForText)localObject7).msgtype = -1000;
            ((MessageForText)localObject7).msg = localStringBuilder2.toString();
            localArrayList.add(localObject7);
            localStringBuilder2.delete(0, localStringBuilder2.length());
          }
          localObject12 = (im_msg_body.CustomFace)localElem.custom_face.get();
          localObject7 = ((im_msg_body.CustomFace)localObject12).str_file_path.get();
          ((im_msg_body.CustomFace)localObject12).str_shortcut.get();
          localObject9 = ((im_msg_body.CustomFace)localObject12).str_big_url.get();
          localObject10 = ((im_msg_body.CustomFace)localObject12).str_orig_url.get();
          str = ((im_msg_body.CustomFace)localObject12).str_thumb_url.get();
          n = ((im_msg_body.CustomFace)localObject12).uint32_thumb_width.get();
          i1 = ((im_msg_body.CustomFace)localObject12).uint32_thumb_height.get();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "[CustomFace] ThumbWidth=" + n + ",ThumbHeight=" + i1);
          }
          l1 = ((im_msg_body.CustomFace)localObject12).uint32_file_id.get();
          l2 = ((im_msg_body.CustomFace)localObject12).uint32_file_type.get();
          l2 = ((im_msg_body.CustomFace)localObject12).uint32_server_ip.get();
          l2 = ((im_msg_body.CustomFace)localObject12).uint32_server_port.get();
          l2 = ((im_msg_body.CustomFace)localObject12).uint32_useful.get();
          l2 = ((im_msg_body.CustomFace)localObject12).uint32_size.get();
          localObject11 = ((im_msg_body.CustomFace)localObject12).bytes_md5.get().toByteArray();
          localObject13 = ((im_msg_body.CustomFace)localObject12).bytes_signature.get().toByteArray();
          ((im_msg_body.CustomFace)localObject12).bytes_buffer.get().toByteArray();
          byte[] arrayOfByte = ((im_msg_body.CustomFace)localObject12).bytes_flag.get().toByteArray();
          i2 = (int)(((im_msg_body.CustomFace)localObject12).uint32_width.get() & 0xFFFFFFFF);
          i3 = (int)(((im_msg_body.CustomFace)localObject12).uint32_height.get() & 0xFFFFFFFF);
          localObject11 = HexUtil.a((byte[])localObject11);
          HexUtil.a((byte[])localObject13);
          HexUtil.a(arrayOfByte);
          i4 = ((im_msg_body.CustomFace)localObject12).uint32_origin.get();
          localObject13 = TranDbRecord.PicDbRecord.a((String)localObject7, 0L, 1, false, (String)localObject7, (String)localObject11, "picplatform", str, (String)localObject9, (String)localObject10, i4, 0);
          localObject12 = new RichMsg.PicRec();
          ((RichMsg.PicRec)localObject12).localPath.set((String)localObject7);
          ((RichMsg.PicRec)localObject12).size.set(l2 & 0xFFFFFFFF);
          ((RichMsg.PicRec)localObject12).type.set(1);
          ((RichMsg.PicRec)localObject12).isRead.set(false);
          ((RichMsg.PicRec)localObject12).uuid.set((String)localObject7);
          ((RichMsg.PicRec)localObject12).groupFileID.set(l1 & 0xFFFFFFFF);
          ((RichMsg.PicRec)localObject12).md5.set((String)localObject11);
          ((RichMsg.PicRec)localObject12).serverStorageSource.set("picplatform");
          ((RichMsg.PicRec)localObject12).thumbMsgUrl.set(str);
          ((RichMsg.PicRec)localObject12).uint32_thumb_width.set(n);
          ((RichMsg.PicRec)localObject12).uint32_thumb_height.set(i1);
          ((RichMsg.PicRec)localObject12).bigMsgUrl.set((String)localObject9);
          ((RichMsg.PicRec)localObject12).rawMsgUrl.set((String)localObject10);
          ((RichMsg.PicRec)localObject12).fileSizeFlag.set(0);
          ((RichMsg.PicRec)localObject12).uiOperatorFlag.set(0);
          ((RichMsg.PicRec)localObject12).version.set(5);
          ((RichMsg.PicRec)localObject12).isReport.set(0);
          ((RichMsg.PicRec)localObject12).fileSizeFlag.set(i4);
          if (QLog.isColorLevel()) {
            localStringBuilder1.append("protocolStr:").append((String)localObject13);
          }
          localObject7 = (MessageForPic)MessageRecordFactory.a(-2000);
          ((MessageForPic)localObject7).msgtype = -2000;
          ((MessageForPic)localObject7).msgData = ((RichMsg.PicRec)localObject12).toByteArray();
          ((MessageForPic)localObject7).width = i2;
          ((MessageForPic)localObject7).height = i3;
          ((MessageForPic)localObject7).parse();
          localArrayList.add(localObject7);
          localStringBuilder2.delete(0, localStringBuilder2.length());
          n = k;
          k = j;
          j = n;
          break label1463;
        }
        if (localElem.fun_face.has())
        {
          if (!QLog.isColorLevel()) {
            break label6459;
          }
          localStringBuilder1.append("elemType:FunFace;");
          n = k;
          k = j;
          j = n;
          break label1463;
        }
        if (localElem.group_file.has())
        {
          l1 = 0L;
          localObject7 = (msg_comm.MsgHead)paramMsg.msg_head.get();
          if (((msg_comm.MsgHead)localObject7).discuss_info.has()) {
            l1 = ((msg_comm.DiscussInfo)((msg_comm.MsgHead)localObject7).discuss_info.get()).discuss_uin.get();
          }
          l5 = ((msg_comm.MsgHead)localObject7).from_uin.get();
          long l7 = ((msg_comm.MsgHead)localObject7).msg_time.get();
          long l8 = ((msg_comm.MsgHead)localObject7).msg_seq.get();
          l6 = paramMessageHandler.a.getLongAccountUin();
          localObject10 = (im_msg_body.GroupFile)localElem.group_file.get();
          if (MessageHandlerUtils.a(paramMessageHandler.a, 3000, String.valueOf(l1), String.valueOf(l5), l7, l8))
          {
            localObject7 = localObject5;
            localObject9 = localObject2;
            n = m;
            localObject10 = localObject3;
            localObject5 = localObject4;
            m = j;
            localObject2 = localObject7;
            localObject3 = localObject9;
            j = k;
            k = n;
            localObject4 = localObject10;
            break label409;
          }
          localObject7 = "";
          try
          {
            localObject9 = new String(((im_msg_body.GroupFile)localObject10).bytes_filename.get().toByteArray(), "UTF-8");
            localObject7 = localObject9;
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            for (;;)
            {
              localUnsupportedEncodingException.printStackTrace();
              continue;
              boolean bool1 = false;
            }
          }
          l3 = 0L;
          l2 = l3;
          if (paramMsg.msg_body.has())
          {
            localObject9 = (im_msg_body.MsgBody)paramMsg.msg_body.get();
            l2 = l3;
            if (((im_msg_body.MsgBody)localObject9).rich_text.attr.has()) {
              l2 = MessageUtils.a(((im_msg_body.Attr)((im_msg_body.MsgBody)localObject9).rich_text.attr.get()).random.get());
            }
          }
          localObject9 = (MessageForFile)MessageRecordFactory.a(-2005);
          ((MessageForFile)localObject9).msgtype = -2005;
          ((MessageForFile)localObject9).uniseq = paramMessageHandler.a.a().a(((MessageForFile)localObject9).uniseq, l1, l5, l8, l2, l7, (im_msg_body.GroupFile)localObject10);
          l1 = ((im_msg_body.GroupFile)localObject10).uint64_file_size.get();
          if (l5 == l6)
          {
            bool1 = true;
            ((MessageForFile)localObject9).msg = TransfileUtile.a((String)localObject7, l1, 0, bool1);
            ((MessageForFile)localObject9).doParse();
            paramList.add(localObject9);
            if (QLog.isColorLevel()) {
              localStringBuilder1.append("GroupDiscFile.msg:").append(((im_msg_body.GroupFile)localObject10).bytes_filename.get()).append(";");
            }
            n = k;
            k = j;
            j = n;
            break label1463;
          }
        }
        if (localElem.market_trans.has())
        {
          if (QLog.isColorLevel()) {
            localStringBuilder1.append("elemType:MarketTrans;");
          }
          if (localStringBuilder2.length() > 0)
          {
            localObject7 = (MessageForText)MessageRecordFactory.a(-1000);
            ((MessageForText)localObject7).msgtype = -1000;
            ((MessageForText)localObject7).msg = localStringBuilder2.toString();
            localArrayList.add(localObject7);
            localStringBuilder2.delete(0, localStringBuilder2.length());
          }
          localObject7 = (im_msg_body.MarketTrans)localElem.market_trans.get();
          j = ((im_msg_body.MarketTrans)localObject7).int32_flag.get();
          localObject7 = StructMsgFactory.a(((im_msg_body.MarketTrans)localObject7).bytes_xml.get().toByteArray(), j);
          if (localObject4 != null) {
            ((AbsStructMsg)localObject7).mCompatibleText = ((String)localObject4);
          }
          if (localObject7 != null)
          {
            MessageForStructing localMessageForStructing = (MessageForStructing)MessageRecordFactory.a(-2011);
            localMessageForStructing.msgtype = -2011;
            localMessageForStructing.msg = "MarketTrans";
            localMessageForStructing.structingMsg = ((AbsStructMsg)localObject7);
            localMessageForStructing.msgData = localMessageForStructing.structingMsg.getBytes();
            paramList.add(localMessageForStructing);
            k = 1;
            j = 0;
            break label1463;
          }
          if (QLog.isColorLevel()) {
            localStringBuilder1.append("c2cMsgContent.data:null;");
          }
          k = 1;
          j = 0;
          break label1463;
          label6267:
          if (localArrayList.size() <= 0) {
            break label1122;
          }
          paramMessageHandler.add(localArrayList.get(0));
          break label1122;
          paramMessageHandler.addAll(localArrayList);
          break label1122;
          if (paramMessageInfo.msgtype == -2000)
          {
            j += 1;
            break label1190;
            break label1145;
            paramMsg.add(paramMessageInfo);
            break label1219;
            if (paramMsg.size() > 0)
            {
              paramList.add(a(paramMsg));
              paramMsg.clear();
            }
            while (QLog.isColorLevel())
            {
              localStringBuilder1.append("\n Decode Elems Finish : msgRecordsSize:").append(paramList.size());
              QLog.d("Q.msg.MessageHandler", 2, localStringBuilder1.toString());
              return;
              paramList.addAll(paramMessageHandler);
            }
            break;
          }
          break label1190;
          i = 0;
          break label1199;
          localObject7 = localObject3;
          n = m;
          localObject3 = localObject2;
          localObject2 = localObject5;
          localObject5 = localObject4;
          m = k;
          k = n;
          localObject4 = localObject7;
          break label409;
        }
        n = k;
        k = j;
        j = n;
        break label1463;
        Object localObject7 = null;
      }
    }
  }
  
  public static void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has()) || (paramDecodeProtoPkgContext.a) || (paramDecodeProtoPkgContext.f))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_Video return null:hasBody:" + paramMsg.msg_body.has() + ",hasMsgContent" + ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has() + ",isReaded:" + paramDecodeProtoPkgContext.a + "syncOther:" + paramDecodeProtoPkgContext.f);
      }
      return;
    }
    long l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
    l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_uid.get();
    long l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
    long l3 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
    long l4 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).to_uin.get();
    Long.valueOf(paramMessageHandler.a.a()).longValue();
    paramMessageHandler = l3 + "-" + l4 + "-" + l2 + "-" + l1;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_Video :  key:" + paramMessageHandler);
    }
    ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
    MessageCache.a();
  }
  
  public static void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List paramList)
  {
    Object localObject = (im_msg_body.Ptt)((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).ptt.get();
    String str = ((im_msg_body.Ptt)localObject).bytes_file_name.get().toStringUtf8();
    int i;
    int j;
    int k;
    boolean bool;
    long l1;
    long l2;
    long l3;
    long l4;
    long l5;
    if (str.endsWith(".amr"))
    {
      if (!SttManager.a(paramMessageHandler.a)) {
        break label495;
      }
      i = 1;
      j = b(paramMsg);
      k = ((im_msg_body.Ptt)localObject).uint32_file_type.get();
      bool = ((im_msg_body.Ptt)localObject).bool_valid.get();
      l1 = ((im_msg_body.Ptt)localObject).uint64_src_uin.get();
      l2 = ((im_msg_body.Ptt)localObject).uint32_file_size.get();
      l3 = ((im_msg_body.Ptt)localObject).uint32_file_id.get() & 0xFFFFFFFF;
      l4 = ((im_msg_body.Ptt)localObject).uint32_server_ip.get();
      l5 = ((im_msg_body.Ptt)localObject).uint32_server_port.get();
      paramMessageHandler = ((im_msg_body.Ptt)localObject).bytes_file_uuid.get().toByteArray();
      localObject = ((im_msg_body.Ptt)localObject).bytes_file_md5.get().toByteArray();
      paramMsg = HexUtil.a(paramMessageHandler);
      paramMessageHandler = HexUtil.a((byte[])localObject);
      if (paramMessageHandler != null) {
        break label503;
      }
      paramMessageHandler = "";
    }
    label495:
    label503:
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder("<---decodeSinglePbMsg_GroupDis:");
        ((StringBuilder)localObject).append(" pttType:").append(k).append(" isValid:").append(bool).append(" srcUin:").append(l1).append(" fileSize:").append(l2 & 0xFFFFFFFF).append(" fileID").append(l3).append(" serverIP:").append(l4 & 0xFFFFFFFF).append(" serverPort:").append(l5 & 0xFFFFFFFF).append(" fileName:").append(str).append(" uuidStr:").append(paramMsg).append(" md5Str:").append(paramMessageHandler);
        QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject).toString());
      }
      TransfileUtile.a(str, 0L, 2, false, str);
      paramMsg = new RichMsg.PttRec();
      paramMsg.localPath.set(str);
      paramMsg.size.set(0L);
      paramMsg.type.set(2);
      paramMsg.uuid.set(str);
      paramMsg.isRead.set(false);
      paramMsg.md5.set(paramMessageHandler);
      paramMsg.isReport.set(0);
      paramMsg.version.set(5);
      paramMsg.groupFileID.set(l3);
      paramMsg.pttFlag.set(i);
      paramMsg.longPttVipFlag.set(j);
      paramMessageHandler = MessageRecordFactory.a(-2002);
      paramMessageHandler.msgtype = -2002;
      paramMessageHandler.msgData = paramMsg.toByteArray();
      ((MessageForPtt)paramMessageHandler).parse();
      paramList.add(paramMessageHandler);
      return;
      i = a(paramMsg);
      break;
    }
  }
  
  private static void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, msg_comm.MsgType0x210 paramMsgType0x210)
  {
    paramMsgType0x210 = paramMsgType0x210.msg_content.get().toByteArray();
    HexUtil.a(paramMsgType0x210);
    MessageRecord localMessageRecord = MessageRecordFactory.a(-1038);
    paramMsg = (msg_comm.MsgHead)paramMsg.msg_head.get();
    localMessageRecord.init(Long.valueOf(paramMessageHandler.a.a()).longValue(), paramMsg.from_uin.get(), paramMsg.from_uin.get(), "", paramMsg.msg_time.get(), -1038, 0, paramMsg.msg_seq.get());
    localMessageRecord.issend = 1;
    paramMsg = a(paramMessageHandler.a, localMessageRecord, paramMsgType0x210, false);
    paramMessageHandler.a.a().a(paramMsg, paramMsg.selfuin);
  }
  
  public static void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_Dataline");
    }
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_Dataline: return isReaded4DataLine:" + paramBoolean);
      }
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new gja(paramMessageHandler, paramMsg));
      return;
    }
    ((DataLineHandler)paramMessageHandler.a.a(8)).a(paramMsg);
  }
  
  public static void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has()) || (paramBoolean1) || (paramBoolean2)) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_SharpVideo return null:hasBody:" + paramMsg.msg_body.has() + ",hasMsgContent" + ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has() + ",isReaded:" + paramBoolean1 + "syncOther:" + paramBoolean2);
      }
    }
    long l1;
    do
    {
      do
      {
        return;
        l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
        l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_uid.get();
        long l3 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
        long l4 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
        ((msg_comm.MsgHead)paramMsg.msg_head.get()).to_uin.get();
        localObject = l3 + "-" + l2;
        if (QLog.isColorLevel()) {
          QLog.d("shanezhaiSHARP", 2, "<---decodeC2CMsgPkg_SharpVideo :  key:" + (String)localObject);
        }
        if (!paramMessageHandler.a.a().a(l4, (String)localObject)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("shanezhaiSHARP", 2, "msg has been pulled");
      return;
      long l2 = MessageCache.a();
      Long.valueOf(paramMessageHandler.a.a()).longValue();
      paramMessageHandler = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
      l1 = l2 - l1;
      paramMsg = new byte[4];
      Object localObject = new byte[4];
      System.arraycopy(paramMessageHandler, 0, paramMsg, 0, 4);
      System.arraycopy(paramMessageHandler, 4, localObject, 0, 4);
    } while ((l1 >= 60L) && (!QLog.isColorLevel()));
    QLog.d("shanezhaiSHARP", 2, "Discard video message because of time out " + l1 + " s");
  }
  
  public static void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has())) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_AddFriend return null:hasBody:" + paramMsg.msg_body.has() + ",hasMsgContent" + ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has() + ",isReaded:" + paramBoolean1 + "syncOther:" + paramBoolean2);
      }
    }
    String str;
    do
    {
      do
      {
        return;
        long l1 = Long.valueOf(paramMessageHandler.a.a()).longValue();
        long l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
        short s = (short)((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_type.get();
        if ((!paramBoolean1) && (!paramBoolean2) && (!paramBoolean3)) {
          paramMessageHandler.a().a(l1, l2, s, -1006 - (s - 187));
        }
        localObject = (msg_comm.MsgHead)paramMsg.msg_head.get();
      } while (localObject == null);
      paramMsg = "" + ((msg_comm.MsgHead)localObject).auth_uin.get();
      str = ((msg_comm.MsgHead)localObject).auth_nick.get();
      Object localObject = ((msg_comm.MsgHead)localObject).auth_remark.get();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler.sysnick", 2, "FriendSys auUin:" + paramMsg + "aunick:" + str + "auRemark:" + (String)localObject);
      }
      if ((!TextUtils.isEmpty(paramMsg)) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler.sysremark", 2, "FriendSys saveremark");
        }
        paramMessageHandler.b(paramMsg, (String)localObject);
      }
    } while ((TextUtils.isEmpty(paramMsg)) || (TextUtils.isEmpty(str)));
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler.sysnick", 2, "FriendSys savenick");
    }
    paramMessageHandler.a(paramMsg, str);
  }
  
  public static void a(MessageHandler paramMessageHandler, msg_comm.MsgType0x210 paramMsgType0x210)
  {
    paramMsgType0x210 = paramMsgType0x210.msg_content.get().toByteArray();
    Submsgtype0x35.MsgBody localMsgBody = new Submsgtype0x35.MsgBody();
    try
    {
      int i = ((Submsgtype0x35.MsgBody)localMsgBody.mergeFrom(paramMsgType0x210)).uint32_bubble_timestamp.get();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "decodeC2CMsgPkg_MsgType0x210 bubble push timestamp=" + i);
      }
      ((SVIPHandler)paramMessageHandler.a.a(12)).e();
      return;
    }
    catch (Exception paramMessageHandler)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_MsgType0x210 : fail to parse SubMsgType0x35.");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    Object localObject = new Submsgtype0x4e.MsgBody();
    for (;;)
    {
      int i;
      long l1;
      long l2;
      long l3;
      String str;
      int j;
      try
      {
        paramArrayOfByte = (Submsgtype0x4e.MsgBody)((Submsgtype0x4e.MsgBody)localObject).mergeFrom(paramArrayOfByte);
        i = paramArrayOfByte.uint32_appid.get();
        l1 = paramArrayOfByte.uint64_group_id.get();
        l2 = paramArrayOfByte.uint64_group_code.get();
        if (paramArrayOfByte.msg_group_bulletin.has())
        {
          l3 = (int)MessageCache.a();
          localObject = paramArrayOfByte.msg_group_bulletin.rpt_msg_content.get();
          new ArrayList();
          paramArrayOfByte = paramQQAppInterface.a().createEntityManager();
          localObject = ((List)localObject).iterator();
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          Submsgtype0x4e.GroupBulletin.Content localContent = (Submsgtype0x4e.GroupBulletin.Content)((Iterator)localObject).next();
          l3 = localContent.uint64_uin.get();
          str = localContent.bytes_feedid.get().toStringUtf8();
          j = localContent.uint32_time.get();
          if (TroopNotificationHelper.c(str))
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("TroopNotificationHelper", 2, "notice is loading");
            continue;
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_MsgType0x210 : fail to parse SubMsgType0x4e.");
        }
      }
      if ((TroopNotificationCache)paramArrayOfByte.a(TroopNotificationCache.class, "troopUin=? and feedsId=?", new String[] { String.valueOf(l2), str }) != null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.MessageHandler", 2, "notice has exist!");
        }
      }
      else {
        TroopNotificationHelper.a(paramQQAppInterface, i, l1, l2, l3, str, j, "OidbSvc.0x852_35", (short)23, false);
      }
    }
    paramArrayOfByte.a();
  }
  
  private static void a(MessageForText.AtTroopMemberInfo paramAtTroopMemberInfo, im_msg_body.Elem paramElem)
  {
    if (paramAtTroopMemberInfo != null)
    {
      byte[] arrayOfByte = new byte[13];
      PkgTools.a(arrayOfByte, 0, (short)1);
      paramAtTroopMemberInfo.writeTo(arrayOfByte, 2);
      paramElem.text.attr_6_buf.set(ByteStringMicro.copyFrom(arrayOfByte));
    }
  }
  
  private static boolean a(List paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((im_msg_body.Elem)paramList.next()).rich_msg.has()) {
        return true;
      }
    }
    return false;
  }
  
  private static byte[] a(byte[] paramArrayOfByte)
  {
    Inflater localInflater = new Inflater();
    localInflater.reset();
    localInflater.setInput(paramArrayOfByte);
    localByteArrayOutputStream = new ByteArrayOutputStream(paramArrayOfByte.length);
    try
    {
      byte[] arrayOfByte1 = new byte[1024];
      while (!localInflater.finished()) {
        localByteArrayOutputStream.write(arrayOfByte1, 0, localInflater.inflate(arrayOfByte1));
      }
      try
      {
        byte[] arrayOfByte2;
        localByteArrayOutputStream.close();
        throw paramArrayOfByte;
      }
      catch (IOException localIOException3)
      {
        for (;;)
        {
          localIOException3.printStackTrace();
        }
      }
    }
    catch (Exception localException)
    {
      localException = localException;
      localException.printStackTrace();
      try
      {
        localByteArrayOutputStream.close();
        for (;;)
        {
          localInflater.end();
          return paramArrayOfByte;
          arrayOfByte2 = localByteArrayOutputStream.toByteArray();
          paramArrayOfByte = arrayOfByte2;
          try
          {
            localByteArrayOutputStream.close();
          }
          catch (IOException localIOException1)
          {
            localIOException1.printStackTrace();
          }
        }
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          localIOException2.printStackTrace();
        }
      }
    }
    finally {}
  }
  
  public static int b(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return 1;
    case 1000: 
      return 3;
    case 1005: 
      return 6;
    case 1008: 
      return 8;
    case 1006: 
      return 10;
    case 1004: 
      return 5;
    case 1009: 
      return 11;
    case 3000: 
      return 4;
    case 1: 
      return 2;
    case 1001: 
      return 12;
    case 1020: 
      return 14;
    case 1021: 
      return 16;
    case 1022: 
      return 17;
    case 1023: 
      return 18;
    }
    return 15;
  }
  
  public static int b(msg_comm.Msg paramMsg)
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
  
  public static void b(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
    ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_uid.get();
    long l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
    MessageCache.a();
    Long.valueOf(paramMessageHandler.a.a()).longValue();
    paramMsg = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
    if (QLog.isColorLevel()) {
      QLog.d("shanezhai", 2, "recv MultiVideo offline msg !msgTime is:" + l1);
    }
    paramMessageHandler.a.a().h(paramMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.MessageProtoCodec
 * JD-Core Version:    0.7.0.1
 */