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
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.biz.pubaccount.util.PAMessageUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.TroopNotificationCache;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ShieldListHandler;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.message.OfflineFileMessageProcessor;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.FunnyFaceMessage;
import com.tencent.mobileqq.data.FunnyFaceMessage.Bomb;
import com.tencent.mobileqq.data.FunnyFaceMessage.Turntable;
import com.tencent.mobileqq.data.MessageForFunnyFace;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.ShakeWindowMsg;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.data.OnlineFileSessionInfo;
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
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.mobileqq.utils.ActionMsgUtil.AppShareCookie;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlite.data.MarkFaceMessage;
import efd;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
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
import tencent.im.cs.ptt_reserve.ptt_reserve.ReserveStruct;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ElemFlags2;
import tencent.im.msg.im_msg_body.Face;
import tencent.im.msg.im_msg_body.FunFace;
import tencent.im.msg.im_msg_body.FunFace.Bomb;
import tencent.im.msg.im_msg_body.FunFace.Turntable;
import tencent.im.msg.im_msg_body.MarketFace;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.NotOnlineFile;
import tencent.im.msg.im_msg_body.NotOnlineImage;
import tencent.im.msg.im_msg_body.Ptt;
import tencent.im.msg.im_msg_body.RichMsg;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.SecretFileMsg;
import tencent.im.msg.im_msg_body.ShakeWindow;
import tencent.im.msg.im_msg_body.Text;
import tencent.im.s2c.msgtype0x210.submsgtype0x35.Submsgtype0x35.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x4e.Submsgtype0x4e.GroupBulletin;
import tencent.im.s2c.msgtype0x210.submsgtype0x4e.Submsgtype0x4e.GroupBulletin.Content;
import tencent.im.s2c.msgtype0x210.submsgtype0x4e.Submsgtype0x4e.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x67.submsgtype0x67.MsgBody;
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
    case 8: 
    case 9: 
    case 13: 
    case 16: 
    default: 
      return 0;
    case 3: 
      return 1000;
    case 6: 
      return 1005;
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
        ((im_msg_body.ElemFlags2)localElem.elem_flags2.get()).uint32_ptt_change_bit.get();
      }
    }
    return 0;
  }
  
  public static int a(im_msg_body.RichText paramRichText, String paramString, ArrayList paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int k = 0;
    int j = 0;
    int i = 0;
    label30:
    Object localObject;
    if (k < paramString.length())
    {
      if (paramArrayList == null) {
        break label454;
      }
      if (j >= paramArrayList.size()) {
        break label448;
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
        localElem = a(paramRichText, paramString.substring(((MessageForText.AtTroopMemberInfo)localObject).startPos, ((MessageForText.AtTroopMemberInfo)localObject).startPos + ((MessageForText.AtTroopMemberInfo)localObject).textLen));
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
        break label30;
        if (paramString.charAt(k) == '\024')
        {
          m = i;
          if (localStringBuilder.length() > 0)
          {
            a(paramRichText, localStringBuilder.toString());
            localStringBuilder.delete(0, localStringBuilder.length());
            m = i + 1;
          }
          int i1 = paramString.charAt(k + 1);
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
          localStringBuilder.append(paramString.charAt(k));
        }
      }
      j = i;
      if (localStringBuilder.length() > 0)
      {
        a(paramRichText, localStringBuilder.toString());
        j = i + 1;
      }
      return j;
      label448:
      localObject = null;
      continue;
      label454:
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
        if (QLog.isColorLevel()) {
          QLog.i("Q.msg.MessageHandler", 2, "recv roam online msg, return null!");
        }
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
            break label634;
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
    label634:
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_OnlineFile decode 0x85 failed.");
    }
    return null;
  }
  
  public static TempSessionInfo a(msg_comm.Msg paramMsg)
  {
    TempSessionInfo localTempSessionInfo = new TempSessionInfo();
    int i = -1;
    msg_comm.C2CTmpMsgHead localC2CTmpMsgHead = (msg_comm.C2CTmpMsgHead)((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_tmp_msg_head.get();
    int j;
    int k;
    if (!localC2CTmpMsgHead.c2c_type.has())
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "It doesn't has a c2cType.");
      }
      j = localC2CTmpMsgHead.c2c_type.get();
      k = localC2CTmpMsgHead.service_type.get();
      switch (k)
      {
      default: 
        label168:
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
      if ((localC2CTmpMsgHead.service_type.has()) || (!QLog.isColorLevel())) {
        break;
      }
      QLog.e("Q.msg.MessageHandler", 2, "Invalid service type, the pb data has no service type.");
      break;
      i = 1000;
      break label168;
      i = 1004;
      break label168;
      i = 1024;
      if ((!BmqqSegmentUtil.b(BaseApplicationImpl.getContext(), String.valueOf(paramMsg.msg_head.from_uin.get()))) && (!BmqqSegmentUtil.b(BaseApplicationImpl.getContext(), String.valueOf(paramMsg.msg_head.to_uin.get())))) {
        break label168;
      }
      i = 1025;
      break label168;
      i = 1005;
      break label168;
      i = 1006;
      break label168;
      i = 1009;
      break label168;
      i = 1001;
      break label168;
      i = 1020;
      break label168;
      i = 1022;
      break label168;
      i = 1023;
      break label168;
      localTempSessionInfo.jdField_b_of_type_Long = localC2CTmpMsgHead.group_code.get();
      localTempSessionInfo.c = localC2CTmpMsgHead.group_uin.get();
      continue;
      localTempSessionInfo.jdField_b_of_type_Long = localC2CTmpMsgHead.group_code.get();
      localTempSessionInfo.c = localC2CTmpMsgHead.group_code.get();
      continue;
      localTempSessionInfo.jdField_b_of_type_Long = localC2CTmpMsgHead.group_code.get();
      localTempSessionInfo.c = localC2CTmpMsgHead.group_uin.get();
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
      if ((paramChatMessage instanceof MessageForShortVideo)) {
        return ((MessageForShortVideo)paramChatMessage).richText;
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
      if (TextUtils.isEmpty(paramMessageForStructing.structingMsg.mCompatibleText)) {
        paramMessageForStructing.structingMsg.mCompatibleText = paramMessageForStructing.structingMsg.mMsgUrl;
      }
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
    if (a(localRichText2, paramMessageForText.msg, paramMessageForText.atInfoList) <= 0) {
      localRichText1 = null;
    }
    return localRichText1;
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
    Object localObject1;
    do
    {
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
        catch (Exception localException1)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_MsgType0x210 : failed.", localException1);
            }
            localObject1 = null;
          }
          if ((!((msg_comm.MsgType0x210)localObject1).sub_msg_type.has()) || (!((msg_comm.MsgType0x210)localObject1).msg_content.has()))
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_MsgType0x210 : msgType0x210 require more info: hasType:" + ((msg_comm.MsgType0x210)localObject1).sub_msg_type.has() + ",hasMsgContent:" + ((msg_comm.MsgType0x210)localObject1).msg_content.has());
            }
          }
          else
          {
            i = ((msg_comm.MsgType0x210)localObject1).sub_msg_type.get();
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
      ((ShieldListHandler)paramMessageHandler.a.a(15)).a(((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray());
      return;
      a(paramMessageHandler, (msg_comm.MsgType0x210)localObject1);
      return;
      ((PublicAccountHandler)paramMessageHandler.a.a(10)).a(i, ((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray());
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.troopgetnews.", 2, "decodeC2CMsgPkg_MsgType0x210, receive troop news push");
      }
      ((TroopHandler)paramMessageHandler.a.a(17)).a(((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray());
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotificationHelper", 2, "get notice from decodeC2CMsgPkg_MsgType0x210");
      }
      localObject1 = ((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray();
      a(paramMessageHandler.a, (byte[])localObject1);
      a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_MsgType0x210 : subtype 0x51");
      }
      paramMessageHandler.a((msg_comm.MsgType0x210)localObject1, paramMsg);
      a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TurnBrand", 2, "decodeTurnBrandTipsPush recv msg0x210.Submsgtype0x6f");
      }
      if (((msg_comm.MsgType0x210)localObject1).msg_content != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TurnBrand", 2, "decodeTurnBrandTipsPush msg_content is null");
    return;
    paramMessageHandler.a(((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray());
    a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
    return;
    if (QLog.isColorLevel()) {
      QLog.d("TurnBrand", 2, "decode recv msg0x210.Submsgtype0x6e");
    }
    a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
    return;
    if (QLog.isColorLevel()) {
      QLog.d("nearbyTroopPush", 2, "receive offline msgtype0x210.submsgtype0x67 group recmd msg");
    }
    Object localObject2 = new submsgtype0x67.MsgBody();
    try
    {
      ((submsgtype0x67.MsgBody)localObject2).mergeFrom(((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray());
      if (((submsgtype0x67.MsgBody)localObject2).rpt_msg_grpinfo.has())
      {
        localObject1 = ((submsgtype0x67.MsgBody)localObject2).rpt_msg_grpinfo.get();
        localObject2 = (LBSHandler)paramMessageHandler.a.a(3);
        if (localObject2 != null) {
          ((LBSHandler)localObject2).b((List)localObject1);
        }
      }
      a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
      return;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("nearbyTroopPush", 2, "receive offline msgtype0x210.submsgtype0x67 mergeFrom exception: " + localException2.toString());
        }
      }
    }
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
      localObject1 = (im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get();
      localPtt = (im_msg_body.Ptt)((im_msg_body.RichText)localObject1).ptt.get();
      if ((((im_msg_body.RichText)localObject1).ptt.has()) && (localPtt.uint32_file_type.has()) && ((localPtt.uint32_file_type.get() == 4) || (localPtt.uint32_file_type.get() == 6)) && (localPtt.bytes_file_uuid.has())) {
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
    long l1 = -1L;
    int i2 = 0;
    int i = 0;
    int i3 = 0;
    int j = 0;
    int i4 = 0;
    int k = 0;
    int m = i4;
    int n = i3;
    int i1 = i2;
    long l2 = l1;
    Object localObject2;
    if (localPtt.bytes_reserve.has())
    {
      localObject1 = localPtt.bytes_reserve.get().toByteArray();
      m = i4;
      n = i3;
      i1 = i2;
      l2 = l1;
      if (localObject1 != null)
      {
        m = i4;
        n = i3;
        i1 = i2;
        l2 = l1;
        if (localObject1.length > 1)
        {
          m = localObject1[0];
          i2 = 1;
          m = k;
          n = j;
          i1 = i;
          l2 = l1;
          if (i2 < localObject1.length - 1)
          {
            i4 = localObject1[i2];
            m = i2 + 1;
            i2 = PkgTools.a((byte[])localObject1, m);
            i3 = m + 2;
            if (i4 == 3)
            {
              localObject2 = new byte[i2];
              PkgTools.a((byte[])localObject2, 0, (byte[])localObject1, i3, i2);
              l2 = PkgTools.a((byte[])localObject2, 0);
              if (l2 > 0L) {
                l1 = l2;
              }
              m = k;
              n = j;
              i1 = i;
              l2 = l1;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.msg.MessageHandler", 2, "PTT_ROAM : TimeStamp in d0 :" + l1);
                l2 = l1;
                i1 = i;
                n = j;
                m = k;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      i2 = i3 + i2;
      k = m;
      j = n;
      i = i1;
      l1 = l2;
      break;
      Object localObject3;
      if (i4 == 9)
      {
        localObject2 = new byte[i2];
        PkgTools.a((byte[])localObject2, 0, (byte[])localObject1, i3, i2);
        n = RecordParams.b(Utils.a(PkgTools.a((byte[])localObject2, 0)));
        m = k;
        i1 = i;
        l2 = l1;
      }
      else if (i4 == 8)
      {
        localObject2 = new byte[i2];
        PkgTools.a((byte[])localObject2, 0, (byte[])localObject1, i3, i2);
        i1 = (int)PkgTools.a((byte[])localObject2, 0);
        m = k;
        n = j;
        l2 = l1;
      }
      else
      {
        m = k;
        n = j;
        i1 = i;
        l2 = l1;
        if (i4 == 10)
        {
          localObject2 = new byte[i2];
          PkgTools.a((byte[])localObject2, 0, (byte[])localObject1, i3, i2);
          localObject3 = new ptt_reserve.ReserveStruct();
        }
      }
      try
      {
        ((ptt_reserve.ReserveStruct)localObject3).mergeFrom((byte[])localObject2);
        m = ((ptt_reserve.ReserveStruct)localObject3).uint32_change_voice.get();
        n = j;
        i1 = i;
        l2 = l1;
      }
      catch (Exception localException)
      {
        m = k;
        n = j;
        i1 = i;
        l2 = l1;
      }
    }
    if (localPtt.bytes_down_para.has())
    {
      localObject1 = localPtt.bytes_down_para.get();
      if (localObject1 == null) {}
    }
    for (Object localObject1 = ((ByteStringMicro)localObject1).toStringUtf8();; localObject1 = "")
    {
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        i = 1;
        ReportController.b(paramMessageHandler.a, "CliOper", "", "", "0X80060E4", "0X80060E4", i, 0, "", "", "", "3.5.0");
        localObject3 = localPtt.bytes_file_uuid.get().toStringUtf8();
        localObject2 = localPtt.bytes_file_name.get().toStringUtf8();
        if (((String)localObject2).contains("_")) {
          break label1262;
        }
      }
      label1262:
      for (localObject2 = ((String)localObject2).substring(0, ((String)localObject2).length() - 4);; localObject2 = ((String)localObject2).substring(((String)localObject2).lastIndexOf("_") + 1, ((String)localObject2).length() - 4))
      {
        localObject2 = l3 + "_" + (String)localObject2;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_PTT isPttSuffix offfile key：" + (String)localObject2 + " fileUuid:" + (String)localObject3);
        }
        localObject2 = new RichMsg.PttRec();
        ((RichMsg.PttRec)localObject2).localPath.set((String)localObject3);
        ((RichMsg.PttRec)localObject2).size.set(localPtt.uint32_file_size.get());
        ((RichMsg.PttRec)localObject2).type.set(2);
        ((RichMsg.PttRec)localObject2).uuid.set((String)localObject3);
        ((RichMsg.PttRec)localObject2).isRead.set(false);
        ((RichMsg.PttRec)localObject2).serverStorageSource.set("pttcenter");
        ((RichMsg.PttRec)localObject2).isReport.set(0);
        ((RichMsg.PttRec)localObject2).version.set(5);
        ((RichMsg.PttRec)localObject2).pttFlag.set(0);
        l1 = System.currentTimeMillis() / 1000L;
        long l4 = paramMsg.msg_head.msg_time.get();
        ((RichMsg.PttRec)localObject2).msgRecTime.set(l1);
        ((RichMsg.PttRec)localObject2).msgTime.set(l4);
        ((RichMsg.PttRec)localObject2).voiceType.set(i1);
        ((RichMsg.PttRec)localObject2).voiceLength.set(n);
        ((RichMsg.PttRec)localObject2).voiceChangeFlag.set(m);
        if (QLog.isColorLevel()) {
          QLog.d("RecordParams", 2, "<---decodeC2CMsgPkg_PTT voiceType：" + i1 + " voiceLengh:" + n);
        }
        ((RichMsg.PttRec)localObject2).directUrl.set((String)localObject1);
        i = MessageUtils.a(paramMessageHandler.a, String.valueOf(l3));
        ((RichMsg.PttRec)localObject2).longPttVipFlag.set(i);
        paramMessageHandler = MessageRecordFactory.a(-2002);
        paramMessageHandler.msgtype = -2002;
        paramMessageHandler.msgData = ((RichMsg.PttRec)localObject2).toByteArray();
        paramMessageHandler.time = l2;
        ((MessageForPtt)paramMessageHandler).parse();
        paramList.add(paramMessageHandler);
        return;
        i = 2;
        break;
      }
      break;
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
        localObject2 = BaseApplication.getContext().getString(2131364116);
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
                    paramMessageHandler.e(String.valueOf(AppShareIDUtil.b(l1)));
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
      paramMsg = BaseApplication.getContext().getString(2131363602);
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
    label429:
    label445:
    label495:
    do
    {
      for (;;)
      {
        return;
        Object localObject;
        int i;
        try
        {
          localObject = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
          i = ((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_cmd.get();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[" + i + "]");
          }
          switch (i)
          {
          case 8: 
          case 9: 
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
              paramList.mergeFrom((byte[])localObject);
              if (!paramList.msg_fail_notify.has()) {
                break label541;
              }
              j = 0;
              paramList = (SubMsgType0x3.FailNotify)paramList.msg_fail_notify.get();
              if (!paramList.uint32_sessionid.has()) {
                break label429;
              }
              k = paramList.uint32_sessionid.get();
              if (!paramList.uint32_retCode.has()) {
                break label445;
              }
              i = paramList.uint32_retCode.get();
              if (!paramList.bytes_reason.has()) {
                break label495;
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
                break label720;
              }
              i = paramList.uint32_progress.get();
              if (!paramList.uint32_average_speed.has()) {
                break label770;
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
                break label603;
              }
              QLog.w("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : sessionId[" + k + "], progressNotify has not Progress");
              i = j;
              break label603;
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
            SubMsgType0x4.MsgBody localMsgBody = new SubMsgType0x4.MsgBody();
            try
            {
              localObject = (SubMsgType0x4.MsgBody)localMsgBody.mergeFrom((byte[])localObject);
              if (((SubMsgType0x4.MsgBody)localObject).msg_not_online_file.has()) {
                break label912;
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
                long l = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
                paramMessageHandler.msg = ((im_msg_body.NotOnlineFile)localObject).bytes_file_name.get().toStringUtf8();
                paramMessageHandler.senderuin = Long.toString(l);
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
                paramList = (SubMsgType0x7.MsgBody)paramList.mergeFrom((byte[])localObject);
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
    label541:
    label603:
    QLog.e("Q.msg.MessageHandler", 2, "<dataline><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[0x7] failed", paramMessageHandler);
    label720:
  }
  
  /* Error */
  public static void a(MessageHandler paramMessageHandler, List paramList, msg_comm.Msg paramMsg, TempSessionInfo paramTempSessionInfo, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    // Byte code:
    //   0: aload_2
    //   1: getfield 234	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   4: invokevirtual 237	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   7: checkcast 236	msf/msgcomm/msg_comm$MsgHead
    //   10: astore 12
    //   12: aload 12
    //   14: getfield 489	msf/msgcomm/msg_comm$MsgHead:c2c_tmp_msg_head	Lmsf/msgcomm/msg_comm$C2CTmpMsgHead;
    //   17: invokevirtual 2021	msf/msgcomm/msg_comm$C2CTmpMsgHead:has	()Z
    //   20: ifeq +32 -> 52
    //   23: aload_2
    //   24: getfield 26	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   27: invokevirtual 32	tencent/im/msg/im_msg_body$MsgBody:has	()Z
    //   30: ifeq +22 -> 52
    //   33: aload_2
    //   34: getfield 26	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   37: invokevirtual 36	tencent/im/msg/im_msg_body$MsgBody:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   40: checkcast 28	tencent/im/msg/im_msg_body$MsgBody
    //   43: getfield 40	tencent/im/msg/im_msg_body$MsgBody:rich_text	Ltencent/im/msg/im_msg_body$RichText;
    //   46: invokevirtual 43	tencent/im/msg/im_msg_body$RichText:has	()Z
    //   49: ifne +4 -> 53
    //   52: return
    //   53: aload 12
    //   55: getfield 489	msf/msgcomm/msg_comm$MsgHead:c2c_tmp_msg_head	Lmsf/msgcomm/msg_comm$C2CTmpMsgHead;
    //   58: invokevirtual 492	msf/msgcomm/msg_comm$C2CTmpMsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   61: checkcast 491	msf/msgcomm/msg_comm$C2CTmpMsgHead
    //   64: astore 12
    //   66: aload 12
    //   68: getfield 495	msf/msgcomm/msg_comm$C2CTmpMsgHead:c2c_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   71: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   74: istore 5
    //   76: aload 12
    //   78: getfield 500	msf/msgcomm/msg_comm$C2CTmpMsgHead:service_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   81: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   84: istore 6
    //   86: aload 4
    //   88: getfield 2025	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:d	Z
    //   91: ifne +129 -> 220
    //   94: aload_3
    //   95: getfield 502	com/tencent/mobileqq/service/message/TempSessionInfo:jdField_b_of_type_Int	I
    //   98: sipush 1006
    //   101: if_icmpne +119 -> 220
    //   104: aload 12
    //   106: getfield 2026	msf/msgcomm/msg_comm$C2CTmpMsgHead:from_phone	Lcom/tencent/mobileqq/pb/PBStringField;
    //   109: invokevirtual 270	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   112: astore 13
    //   114: aload 12
    //   116: getfield 2026	msf/msgcomm/msg_comm$C2CTmpMsgHead:from_phone	Lcom/tencent/mobileqq/pb/PBStringField;
    //   119: invokevirtual 1746	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   122: ifeq +19 -> 141
    //   125: aload 13
    //   127: ifnull +14 -> 141
    //   130: aload 13
    //   132: ldc_w 2028
    //   135: invokevirtual 426	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   138: ifeq +43 -> 181
    //   141: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   144: ifeq -92 -> 52
    //   147: ldc 13
    //   149: iconst_2
    //   150: new 91	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   157: ldc_w 2030
    //   160: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload 12
    //   165: getfield 2026	msf/msgcomm/msg_comm$C2CTmpMsgHead:from_phone	Lcom/tencent/mobileqq/pb/PBStringField;
    //   168: invokevirtual 270	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   171: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   180: return
    //   181: aload_0
    //   182: getfield 216	com/tencent/mobileqq/app/MessageHandler:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   185: aload 12
    //   187: getfield 2026	msf/msgcomm/msg_comm$C2CTmpMsgHead:from_phone	Lcom/tencent/mobileqq/pb/PBStringField;
    //   190: invokevirtual 270	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   193: new 91	java/lang/StringBuilder
    //   196: dup
    //   197: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   200: aload 4
    //   202: getfield 2032	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:e	J
    //   205: invokevirtual 277	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   208: ldc_w 281
    //   211: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 2037	com/tencent/mobileqq/utils/ContactUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;)V
    //   220: aload 4
    //   222: getfield 2025	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:d	Z
    //   225: ifne +1209 -> 1434
    //   228: aload 12
    //   230: getfield 2038	msf/msgcomm/msg_comm$C2CTmpMsgHead:sig	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   233: invokevirtual 197	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   236: ifeq +1198 -> 1434
    //   239: aload 12
    //   241: getfield 2038	msf/msgcomm/msg_comm$C2CTmpMsgHead:sig	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   244: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   247: invokevirtual 257	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   250: astore 13
    //   252: aload 13
    //   254: astore 12
    //   256: invokestatic 831	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   259: ifeq +49 -> 308
    //   262: ldc 13
    //   264: iconst_4
    //   265: new 91	java/lang/StringBuilder
    //   268: dup
    //   269: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   272: ldc_w 2040
    //   275: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: aload 13
    //   280: invokestatic 716	com/tencent/mobileqq/utils/HexUtil:a	([B)Ljava/lang/String;
    //   283: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: ldc_w 718
    //   289: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: aload 13
    //   294: arraylength
    //   295: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   298: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   304: aload 13
    //   306: astore 12
    //   308: aload 12
    //   310: ifnull +74 -> 384
    //   313: aload_3
    //   314: getfield 502	com/tencent/mobileqq/service/message/TempSessionInfo:jdField_b_of_type_Int	I
    //   317: lookupswitch	default:+67->384, 1001:+576->893, 1005:+356->673, 1006:+495->812, 1009:+553->870, 1022:+599->916, 1023:+414->731, 1024:+472->789
    //   385: istore 6
    //   387: iload 6
    //   389: istore 5
    //   391: aload_2
    //   392: getfield 1883	msf/msgcomm/msg_comm$Msg:content_head	Lmsf/msgcomm/msg_comm$ContentHead;
    //   395: invokevirtual 1884	msf/msgcomm/msg_comm$ContentHead:has	()Z
    //   398: ifeq +49 -> 447
    //   401: iload 6
    //   403: istore 5
    //   405: aload_2
    //   406: getfield 1883	msf/msgcomm/msg_comm$Msg:content_head	Lmsf/msgcomm/msg_comm$ContentHead;
    //   409: invokevirtual 1887	msf/msgcomm/msg_comm$ContentHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   412: checkcast 600	msf/msgcomm/msg_comm$ContentHead
    //   415: getfield 1890	msf/msgcomm/msg_comm$ContentHead:auto_reply	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   418: invokevirtual 85	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   421: ifeq +26 -> 447
    //   424: aload_2
    //   425: getfield 1883	msf/msgcomm/msg_comm$Msg:content_head	Lmsf/msgcomm/msg_comm$ContentHead;
    //   428: invokevirtual 1887	msf/msgcomm/msg_comm$ContentHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   431: checkcast 600	msf/msgcomm/msg_comm$ContentHead
    //   434: getfield 1890	msf/msgcomm/msg_comm$ContentHead:auto_reply	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   437: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   440: iconst_1
    //   441: if_icmpne +498 -> 939
    //   444: iconst_1
    //   445: istore 5
    //   447: aload_2
    //   448: getfield 26	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   451: invokevirtual 36	tencent/im/msg/im_msg_body$MsgBody:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   454: checkcast 28	tencent/im/msg/im_msg_body$MsgBody
    //   457: getfield 40	tencent/im/msg/im_msg_body$MsgBody:rich_text	Ltencent/im/msg/im_msg_body$RichText;
    //   460: invokevirtual 44	tencent/im/msg/im_msg_body$RichText:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   463: checkcast 42	tencent/im/msg/im_msg_body$RichText
    //   466: getfield 48	tencent/im/msg/im_msg_body$RichText:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   469: invokevirtual 53	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   472: astore 12
    //   474: iload 5
    //   476: ifeq +469 -> 945
    //   479: aload 12
    //   481: ifnull -429 -> 52
    //   484: aload 12
    //   486: invokeinterface 1895 1 0
    //   491: ifle -439 -> 52
    //   494: aload 12
    //   496: iconst_0
    //   497: invokeinterface 2041 2 0
    //   502: checkcast 70	tencent/im/msg/im_msg_body$Elem
    //   505: getfield 937	tencent/im/msg/im_msg_body$Elem:text	Ltencent/im/msg/im_msg_body$Text;
    //   508: invokevirtual 1738	tencent/im/msg/im_msg_body$Text:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   511: checkcast 925	tencent/im/msg/im_msg_body$Text
    //   514: astore_2
    //   515: invokestatic 1683	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   518: ldc_w 1900
    //   521: iconst_0
    //   522: invokevirtual 1904	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   525: new 91	java/lang/StringBuilder
    //   528: dup
    //   529: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   532: ldc_w 1906
    //   535: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: aload_0
    //   539: getfield 216	com/tencent/mobileqq/app/MessageHandler:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   542: invokevirtual 220	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   545: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   551: ldc_w 281
    //   554: invokeinterface 1911 3 0
    //   559: new 91	java/lang/StringBuilder
    //   562: dup
    //   563: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   566: ldc_w 1913
    //   569: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: aload 4
    //   574: getfield 2032	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:e	J
    //   577: invokevirtual 277	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   580: ldc_w 1915
    //   583: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   589: invokevirtual 1491	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   592: ifne -540 -> 52
    //   595: aload 4
    //   597: getfield 2043	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:b	Z
    //   600: ifne -548 -> 52
    //   603: new 91	java/lang/StringBuilder
    //   606: dup
    //   607: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   610: invokestatic 1683	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   613: ldc_w 1898
    //   616: invokevirtual 1690	android/content/Context:getString	(I)Ljava/lang/String;
    //   619: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   622: ldc_w 1917
    //   625: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   628: aload_2
    //   629: getfield 929	tencent/im/msg/im_msg_body$Text:str	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   632: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   635: invokevirtual 1424	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   638: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   641: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   644: astore_0
    //   645: sipush -10000
    //   648: invokestatic 399	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   651: astore_2
    //   652: aload_2
    //   653: sipush -10000
    //   656: putfield 362	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   659: aload_2
    //   660: aload_0
    //   661: putfield 368	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   664: aload_1
    //   665: aload_2
    //   666: invokeinterface 375 2 0
    //   671: pop
    //   672: return
    //   673: aload 12
    //   675: arraylength
    //   676: iconst_2
    //   677: iadd
    //   678: newarray byte
    //   680: astore 13
    //   682: aload 13
    //   684: iconst_0
    //   685: iload 5
    //   687: i2b
    //   688: bastore
    //   689: aload 13
    //   691: iconst_1
    //   692: iload 6
    //   694: i2b
    //   695: bastore
    //   696: aload 13
    //   698: iconst_2
    //   699: aload 12
    //   701: iconst_0
    //   702: aload 12
    //   704: arraylength
    //   705: invokestatic 316	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI[BII)V
    //   708: aload_0
    //   709: getfield 216	com/tencent/mobileqq/app/MessageHandler:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   712: invokevirtual 566	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   715: aload 4
    //   717: getfield 2032	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:e	J
    //   720: invokestatic 465	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   723: aload 13
    //   725: invokevirtual 2046	com/tencent/mobileqq/service/message/MessageCache:a	(Ljava/lang/String;[B)V
    //   728: goto -344 -> 384
    //   731: aload 12
    //   733: arraylength
    //   734: iconst_2
    //   735: iadd
    //   736: newarray byte
    //   738: astore 13
    //   740: aload 13
    //   742: iconst_0
    //   743: iload 5
    //   745: i2b
    //   746: bastore
    //   747: aload 13
    //   749: iconst_1
    //   750: iload 6
    //   752: i2b
    //   753: bastore
    //   754: aload 13
    //   756: iconst_2
    //   757: aload 12
    //   759: iconst_0
    //   760: aload 12
    //   762: arraylength
    //   763: invokestatic 316	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI[BII)V
    //   766: aload_0
    //   767: getfield 216	com/tencent/mobileqq/app/MessageHandler:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   770: invokevirtual 566	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   773: aload 4
    //   775: getfield 2032	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:e	J
    //   778: invokestatic 465	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   781: aload 13
    //   783: invokevirtual 2048	com/tencent/mobileqq/service/message/MessageCache:b	(Ljava/lang/String;[B)V
    //   786: goto -402 -> 384
    //   789: aload_0
    //   790: getfield 216	com/tencent/mobileqq/app/MessageHandler:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   793: invokevirtual 566	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   796: aload 4
    //   798: getfield 2032	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:e	J
    //   801: invokestatic 465	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   804: aload 12
    //   806: invokevirtual 2050	com/tencent/mobileqq/service/message/MessageCache:c	(Ljava/lang/String;[B)V
    //   809: goto -425 -> 384
    //   812: aload 12
    //   814: arraylength
    //   815: iconst_2
    //   816: iadd
    //   817: newarray byte
    //   819: astore 13
    //   821: aload 13
    //   823: iconst_0
    //   824: iload 5
    //   826: i2b
    //   827: bastore
    //   828: aload 13
    //   830: iconst_1
    //   831: iload 6
    //   833: i2b
    //   834: bastore
    //   835: aload 13
    //   837: iconst_2
    //   838: aload 12
    //   840: iconst_0
    //   841: aload 12
    //   843: arraylength
    //   844: invokestatic 316	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI[BII)V
    //   847: aload_0
    //   848: getfield 216	com/tencent/mobileqq/app/MessageHandler:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   851: invokevirtual 566	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   854: aload 4
    //   856: getfield 2032	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:e	J
    //   859: invokestatic 465	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   862: aload 13
    //   864: invokevirtual 2052	com/tencent/mobileqq/service/message/MessageCache:e	(Ljava/lang/String;[B)V
    //   867: goto -483 -> 384
    //   870: aload_0
    //   871: getfield 216	com/tencent/mobileqq/app/MessageHandler:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   874: invokevirtual 566	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   877: aload 4
    //   879: getfield 2032	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:e	J
    //   882: invokestatic 465	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   885: aload 12
    //   887: invokevirtual 2054	com/tencent/mobileqq/service/message/MessageCache:g	(Ljava/lang/String;[B)V
    //   890: goto -506 -> 384
    //   893: aload_0
    //   894: getfield 216	com/tencent/mobileqq/app/MessageHandler:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   897: invokevirtual 566	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   900: aload 4
    //   902: getfield 2032	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:e	J
    //   905: invokestatic 465	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   908: aload 12
    //   910: invokevirtual 2057	com/tencent/mobileqq/service/message/MessageCache:h	(Ljava/lang/String;[B)V
    //   913: goto -529 -> 384
    //   916: aload_0
    //   917: getfield 216	com/tencent/mobileqq/app/MessageHandler:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   920: invokevirtual 566	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   923: aload 4
    //   925: getfield 2032	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:e	J
    //   928: invokestatic 465	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   931: aload 12
    //   933: invokevirtual 2059	com/tencent/mobileqq/service/message/MessageCache:j	(Ljava/lang/String;[B)V
    //   936: goto -552 -> 384
    //   939: iconst_0
    //   940: istore 5
    //   942: goto -495 -> 447
    //   945: aload_3
    //   946: ifnull -894 -> 52
    //   949: aload_2
    //   950: getfield 234	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   953: invokevirtual 237	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   956: checkcast 236	msf/msgcomm/msg_comm$MsgHead
    //   959: getfield 248	msf/msgcomm/msg_comm$MsgHead:msg_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   962: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   965: sipush 529
    //   968: if_icmpne +444 -> 1412
    //   971: aload_2
    //   972: getfield 234	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   975: invokevirtual 237	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   978: checkcast 236	msf/msgcomm/msg_comm$MsgHead
    //   981: getfield 416	msf/msgcomm/msg_comm$MsgHead:c2c_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   984: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   987: bipush 6
    //   989: if_icmpne +423 -> 1412
    //   992: aload_2
    //   993: getfield 26	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   996: invokevirtual 36	tencent/im/msg/im_msg_body$MsgBody:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   999: checkcast 28	tencent/im/msg/im_msg_body$MsgBody
    //   1002: getfield 194	tencent/im/msg/im_msg_body$MsgBody:msg_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1005: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1008: invokevirtual 257	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   1011: astore_0
    //   1012: new 2061	tencent/im/msg/im_msg_body$TmpPtt
    //   1015: dup
    //   1016: invokespecial 2062	tencent/im/msg/im_msg_body$TmpPtt:<init>	()V
    //   1019: astore_3
    //   1020: aload_3
    //   1021: aload_0
    //   1022: invokevirtual 2063	tencent/im/msg/im_msg_body$TmpPtt:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1025: checkcast 2061	tencent/im/msg/im_msg_body$TmpPtt
    //   1028: astore_0
    //   1029: aload_0
    //   1030: ifnull -978 -> 52
    //   1033: aload_0
    //   1034: getfield 2064	tencent/im/msg/im_msg_body$TmpPtt:uint32_file_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1037: invokevirtual 85	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1040: ifeq -988 -> 52
    //   1043: aload_0
    //   1044: getfield 2064	tencent/im/msg/im_msg_body$TmpPtt:uint32_file_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1047: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1050: iconst_4
    //   1051: if_icmpne -999 -> 52
    //   1054: aload_0
    //   1055: getfield 2065	tencent/im/msg/im_msg_body$TmpPtt:bytes_file_uuid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1058: invokevirtual 197	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   1061: ifeq -1009 -> 52
    //   1064: aload_0
    //   1065: getfield 2065	tencent/im/msg/im_msg_body$TmpPtt:bytes_file_uuid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1068: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1071: invokevirtual 1424	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1074: astore 4
    //   1076: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1079: ifeq +30 -> 1109
    //   1082: ldc 13
    //   1084: iconst_2
    //   1085: new 91	java/lang/StringBuilder
    //   1088: dup
    //   1089: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   1092: ldc_w 2067
    //   1095: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1098: aload 4
    //   1100: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1103: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1106: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1109: new 1514	localpb/richMsg/RichMsg$PttRec
    //   1112: dup
    //   1113: invokespecial 1515	localpb/richMsg/RichMsg$PttRec:<init>	()V
    //   1116: astore_3
    //   1117: aload_3
    //   1118: getfield 1516	localpb/richMsg/RichMsg$PttRec:localPath	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1121: aload_0
    //   1122: getfield 2065	tencent/im/msg/im_msg_body$TmpPtt:bytes_file_uuid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1125: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1128: invokevirtual 1424	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1131: invokevirtual 371	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   1134: aload_3
    //   1135: getfield 1517	localpb/richMsg/RichMsg$PttRec:size	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1138: aload_0
    //   1139: getfield 2068	tencent/im/msg/im_msg_body$TmpPtt:uint32_file_size	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1142: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1145: i2l
    //   1146: invokevirtual 581	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   1149: aload_3
    //   1150: getfield 1518	localpb/richMsg/RichMsg$PttRec:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1153: iconst_2
    //   1154: invokevirtual 173	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   1157: aload_3
    //   1158: getfield 1519	localpb/richMsg/RichMsg$PttRec:uuid	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1161: aload 4
    //   1163: invokevirtual 371	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   1166: aload_3
    //   1167: getfield 1520	localpb/richMsg/RichMsg$PttRec:isRead	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   1170: iconst_0
    //   1171: invokevirtual 823	com/tencent/mobileqq/pb/PBBoolField:set	(Z)V
    //   1174: aload_3
    //   1175: getfield 1521	localpb/richMsg/RichMsg$PttRec:serverStorageSource	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1178: ldc_w 1589
    //   1181: invokevirtual 371	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   1184: aload_3
    //   1185: getfield 1522	localpb/richMsg/RichMsg$PttRec:isReport	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1188: iconst_0
    //   1189: invokevirtual 1475	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   1192: aload_3
    //   1193: getfield 1523	localpb/richMsg/RichMsg$PttRec:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1196: iconst_5
    //   1197: invokevirtual 1475	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   1200: aload_3
    //   1201: getfield 1592	localpb/richMsg/RichMsg$PttRec:pttFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1204: iconst_0
    //   1205: invokevirtual 1475	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   1208: iconst_0
    //   1209: istore 6
    //   1211: iload 6
    //   1213: istore 5
    //   1215: aload_0
    //   1216: getfield 2071	tencent/im/msg/im_msg_body$TmpPtt:uint32_user_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1219: invokevirtual 85	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1222: ifeq +32 -> 1254
    //   1225: aload_0
    //   1226: getfield 2071	tencent/im/msg/im_msg_body$TmpPtt:uint32_user_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1229: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1232: istore 7
    //   1234: iload 7
    //   1236: iconst_1
    //   1237: if_icmpeq +13 -> 1250
    //   1240: iload 6
    //   1242: istore 5
    //   1244: iload 7
    //   1246: iconst_2
    //   1247: if_icmpne +7 -> 1254
    //   1250: iload 7
    //   1252: istore 5
    //   1254: iconst_0
    //   1255: istore 7
    //   1257: iload 7
    //   1259: istore 6
    //   1261: aload_0
    //   1262: getfield 2074	tencent/im/msg/im_msg_body$TmpPtt:bytes_pb_reserve	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1265: invokevirtual 197	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   1268: ifeq +38 -> 1306
    //   1271: new 1560	tencent/im/cs/ptt_reserve/ptt_reserve$ReserveStruct
    //   1274: dup
    //   1275: invokespecial 1561	tencent/im/cs/ptt_reserve/ptt_reserve$ReserveStruct:<init>	()V
    //   1278: astore 4
    //   1280: aload 4
    //   1282: aload_0
    //   1283: getfield 2074	tencent/im/msg/im_msg_body$TmpPtt:bytes_pb_reserve	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1286: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1289: invokevirtual 257	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   1292: invokevirtual 1562	tencent/im/cs/ptt_reserve/ptt_reserve$ReserveStruct:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1295: pop
    //   1296: aload 4
    //   1298: getfield 1565	tencent/im/cs/ptt_reserve/ptt_reserve$ReserveStruct:uint32_change_voice	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1301: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1304: istore 6
    //   1306: aload_3
    //   1307: getfield 1629	localpb/richMsg/RichMsg$PttRec:longPttVipFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1310: iload 5
    //   1312: invokevirtual 1475	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   1315: invokestatic 1597	java/lang/System:currentTimeMillis	()J
    //   1318: ldc2_w 1598
    //   1321: ldiv
    //   1322: lstore 8
    //   1324: aload_2
    //   1325: getfield 234	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   1328: getfield 291	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1331: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1334: i2l
    //   1335: lstore 10
    //   1337: aload_3
    //   1338: getfield 1602	localpb/richMsg/RichMsg$PttRec:msgRecTime	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1341: lload 8
    //   1343: invokevirtual 581	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   1346: aload_3
    //   1347: getfield 1605	localpb/richMsg/RichMsg$PttRec:msgTime	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1350: lload 10
    //   1352: invokevirtual 581	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   1355: aload_3
    //   1356: getfield 1614	localpb/richMsg/RichMsg$PttRec:voiceChangeFlag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1359: iload 6
    //   1361: invokevirtual 173	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   1364: sipush -2002
    //   1367: invokestatic 399	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   1370: astore_0
    //   1371: aload_0
    //   1372: sipush -2002
    //   1375: putfield 362	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   1378: aload_0
    //   1379: aload_3
    //   1380: invokevirtual 1525	localpb/richMsg/RichMsg$PttRec:toByteArray	()[B
    //   1383: putfield 382	com/tencent/mobileqq/data/MessageRecord:msgData	[B
    //   1386: aload_0
    //   1387: checkcast 946	com/tencent/mobileqq/data/MessageForPtt
    //   1390: invokevirtual 1527	com/tencent/mobileqq/data/MessageForPtt:parse	()V
    //   1393: aload_1
    //   1394: aload_0
    //   1395: invokeinterface 375 2 0
    //   1400: pop
    //   1401: return
    //   1402: astore_0
    //   1403: aload_0
    //   1404: invokevirtual 394	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   1407: aconst_null
    //   1408: astore_0
    //   1409: goto -380 -> 1029
    //   1412: aload_0
    //   1413: aload_1
    //   1414: aload_2
    //   1415: iconst_1
    //   1416: aload 4
    //   1418: getfield 2043	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:b	Z
    //   1421: aconst_null
    //   1422: invokestatic 1920	com/tencent/mobileqq/service/message/MessageProtoCodec:a	(Lcom/tencent/mobileqq/app/MessageHandler;Ljava/util/List;Lmsf/msgcomm/msg_comm$Msg;ZZLcom/tencent/mobileqq/troop/data/MessageInfo;)V
    //   1425: return
    //   1426: astore_0
    //   1427: iload 7
    //   1429: istore 6
    //   1431: goto -125 -> 1306
    //   1434: aconst_null
    //   1435: astore 12
    //   1437: goto -1129 -> 308
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1440	0	paramMessageHandler	MessageHandler
    //   0	1440	1	paramList	List
    //   0	1440	2	paramMsg	msg_comm.Msg
    //   0	1440	3	paramTempSessionInfo	TempSessionInfo
    //   0	1440	4	paramDecodeProtoPkgContext	DecodeProtoPkgContext
    //   74	1237	5	i	int
    //   84	1346	6	j	int
    //   1232	196	7	k	int
    //   1322	20	8	l1	long
    //   1335	16	10	l2	long
    //   10	1426	12	localObject1	Object
    //   112	751	13	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   1020	1029	1402	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1280	1306	1426	java/lang/Exception
  }
  
  /* Error */
  public static void a(MessageHandler paramMessageHandler, List paramList, msg_comm.Msg paramMsg, boolean paramBoolean1, boolean paramBoolean2, com.tencent.mobileqq.troop.data.MessageInfo paramMessageInfo)
  {
    // Byte code:
    //   0: aload_2
    //   1: getfield 26	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   4: invokevirtual 36	tencent/im/msg/im_msg_body$MsgBody:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   7: checkcast 28	tencent/im/msg/im_msg_body$MsgBody
    //   10: getfield 40	tencent/im/msg/im_msg_body$MsgBody:rich_text	Ltencent/im/msg/im_msg_body$RichText;
    //   13: invokevirtual 44	tencent/im/msg/im_msg_body$RichText:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   16: checkcast 42	tencent/im/msg/im_msg_body$RichText
    //   19: getfield 48	tencent/im/msg/im_msg_body$RichText:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   22: invokevirtual 53	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   25: astore 48
    //   27: aconst_null
    //   28: astore 39
    //   30: new 91	java/lang/StringBuilder
    //   33: dup
    //   34: ldc_w 2078
    //   37: invokespecial 510	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   40: astore 45
    //   42: new 99	java/util/ArrayList
    //   45: dup
    //   46: invokespecial 1367	java/util/ArrayList:<init>	()V
    //   49: astore 46
    //   51: aload 48
    //   53: ifnull +13 -> 66
    //   56: aload 48
    //   58: invokeinterface 1895 1 0
    //   63: ifgt +30 -> 93
    //   66: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   69: ifeq +23 -> 92
    //   72: aload 45
    //   74: ldc_w 2080
    //   77: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: ldc 13
    //   83: iconst_2
    //   84: aload 45
    //   86: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   92: return
    //   93: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   96: ifeq +28 -> 124
    //   99: aload 45
    //   101: ldc_w 2082
    //   104: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload 48
    //   109: invokeinterface 1895 1 0
    //   114: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   117: ldc_w 1431
    //   120: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: iconst_0
    //   125: istore 11
    //   127: iconst_0
    //   128: istore 10
    //   130: iconst_0
    //   131: istore 6
    //   133: new 91	java/lang/StringBuilder
    //   136: dup
    //   137: ldc_w 281
    //   140: invokespecial 510	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   143: astore 47
    //   145: aconst_null
    //   146: astore 38
    //   148: aconst_null
    //   149: astore 41
    //   151: iconst_0
    //   152: istore 9
    //   154: iconst_0
    //   155: istore 7
    //   157: iconst_0
    //   158: istore 8
    //   160: aload_2
    //   161: getfield 234	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   164: getfield 294	msf/msgcomm/msg_comm$MsgHead:msg_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   167: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   170: i2l
    //   171: lstore 28
    //   173: aload 48
    //   175: invokestatic 2085	com/tencent/mobileqq/service/message/MessageProtoCodec:a	(Ljava/util/List;)Z
    //   178: istore 21
    //   180: aconst_null
    //   181: astore 40
    //   183: iconst_0
    //   184: istore 17
    //   186: iload 17
    //   188: aload 48
    //   190: invokeinterface 1895 1 0
    //   195: if_icmpge +1111 -> 1306
    //   198: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   201: ifeq +23 -> 224
    //   204: aload 45
    //   206: ldc_w 2087
    //   209: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: iload 17
    //   214: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   217: ldc_w 2089
    //   220: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload 48
    //   226: iload 17
    //   228: invokeinterface 2041 2 0
    //   233: checkcast 70	tencent/im/msg/im_msg_body$Elem
    //   236: astore 49
    //   238: iload 10
    //   240: ifeq +7559 -> 7799
    //   243: aload 49
    //   245: getfield 937	tencent/im/msg/im_msg_body$Elem:text	Ltencent/im/msg/im_msg_body$Text;
    //   248: invokevirtual 1691	tencent/im/msg/im_msg_body$Text:has	()Z
    //   251: ifeq +7548 -> 7799
    //   254: aload 39
    //   256: aload 49
    //   258: getfield 937	tencent/im/msg/im_msg_body$Elem:text	Ltencent/im/msg/im_msg_body$Text;
    //   261: invokevirtual 1738	tencent/im/msg/im_msg_body$Text:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   264: checkcast 925	tencent/im/msg/im_msg_body$Text
    //   267: getfield 929	tencent/im/msg/im_msg_body$Text:str	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   270: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   273: invokevirtual 1424	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   276: putfield 1041	com/tencent/qqlite/data/MarkFaceMessage:faceName	Ljava/lang/String;
    //   279: aload 39
    //   281: getfield 1041	com/tencent/qqlite/data/MarkFaceMessage:faceName	Ljava/lang/String;
    //   284: iconst_0
    //   285: invokevirtual 140	java/lang/String:charAt	(I)C
    //   288: bipush 91
    //   290: if_icmpne +50 -> 340
    //   293: aload 39
    //   295: getfield 1041	com/tencent/qqlite/data/MarkFaceMessage:faceName	Ljava/lang/String;
    //   298: aload 39
    //   300: getfield 1041	com/tencent/qqlite/data/MarkFaceMessage:faceName	Ljava/lang/String;
    //   303: invokevirtual 97	java/lang/String:length	()I
    //   306: iconst_1
    //   307: isub
    //   308: invokevirtual 140	java/lang/String:charAt	(I)C
    //   311: bipush 93
    //   313: if_icmpne +27 -> 340
    //   316: aload 39
    //   318: aload 39
    //   320: getfield 1041	com/tencent/qqlite/data/MarkFaceMessage:faceName	Ljava/lang/String;
    //   323: iconst_1
    //   324: aload 39
    //   326: getfield 1041	com/tencent/qqlite/data/MarkFaceMessage:faceName	Ljava/lang/String;
    //   329: invokevirtual 97	java/lang/String:length	()I
    //   332: iconst_1
    //   333: isub
    //   334: invokevirtual 133	java/lang/String:substring	(II)Ljava/lang/String;
    //   337: putfield 1041	com/tencent/qqlite/data/MarkFaceMessage:faceName	Ljava/lang/String;
    //   340: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   343: ifeq +32 -> 375
    //   346: aload 45
    //   348: ldc_w 2091
    //   351: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: aload 49
    //   356: getfield 937	tencent/im/msg/im_msg_body$Elem:text	Ltencent/im/msg/im_msg_body$Text;
    //   359: invokevirtual 1738	tencent/im/msg/im_msg_body$Text:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   362: checkcast 925	tencent/im/msg/im_msg_body$Text
    //   365: getfield 929	tencent/im/msg/im_msg_body$Text:str	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   368: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   371: invokevirtual 563	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   374: pop
    //   375: iload 21
    //   377: ifne +107 -> 484
    //   380: iload 8
    //   382: istore 12
    //   384: iload 7
    //   386: istore 13
    //   388: iconst_0
    //   389: istore 7
    //   391: iload 11
    //   393: istore 8
    //   395: aload 40
    //   397: astore 42
    //   399: aload 39
    //   401: astore 40
    //   403: aload 38
    //   405: astore 39
    //   407: aload 41
    //   409: astore 38
    //   411: iload 9
    //   413: istore 10
    //   415: iload 13
    //   417: istore 9
    //   419: iload 12
    //   421: istore 11
    //   423: aload 42
    //   425: astore 41
    //   427: iload 17
    //   429: iconst_1
    //   430: iadd
    //   431: istore 17
    //   433: iload 10
    //   435: istore 12
    //   437: iload 8
    //   439: istore 13
    //   441: aload 40
    //   443: astore 42
    //   445: iload 7
    //   447: istore 10
    //   449: aload 41
    //   451: astore 40
    //   453: iload 11
    //   455: istore 8
    //   457: iload 9
    //   459: istore 7
    //   461: iload 12
    //   463: istore 9
    //   465: aload 38
    //   467: astore 41
    //   469: aload 39
    //   471: astore 38
    //   473: iload 13
    //   475: istore 11
    //   477: aload 42
    //   479: astore 39
    //   481: goto -295 -> 186
    //   484: iconst_0
    //   485: istore 10
    //   487: aload 49
    //   489: getfield 1101	tencent/im/msg/im_msg_body$Elem:rich_msg	Ltencent/im/msg/im_msg_body$RichMsg;
    //   492: invokevirtual 2092	tencent/im/msg/im_msg_body$RichMsg:has	()Z
    //   495: ifeq +685 -> 1180
    //   498: aload 47
    //   500: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   503: ifle +54 -> 557
    //   506: sipush -1000
    //   509: invokestatic 399	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   512: checkcast 1120	com/tencent/mobileqq/data/MessageForText
    //   515: astore 42
    //   517: aload 42
    //   519: sipush -1000
    //   522: putfield 1848	com/tencent/mobileqq/data/MessageForText:msgtype	I
    //   525: aload 42
    //   527: aload 47
    //   529: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   532: putfield 1121	com/tencent/mobileqq/data/MessageForText:msg	Ljava/lang/String;
    //   535: aload 46
    //   537: aload 42
    //   539: invokeinterface 375 2 0
    //   544: pop
    //   545: aload 47
    //   547: iconst_0
    //   548: aload 47
    //   550: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   553: invokevirtual 126	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   556: pop
    //   557: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   560: ifeq +12 -> 572
    //   563: aload 45
    //   565: ldc_w 2094
    //   568: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: pop
    //   572: aload 49
    //   574: getfield 1101	tencent/im/msg/im_msg_body$Elem:rich_msg	Ltencent/im/msg/im_msg_body$RichMsg;
    //   577: invokevirtual 2095	tencent/im/msg/im_msg_body$RichMsg:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   580: checkcast 1087	tencent/im/msg/im_msg_body$RichMsg
    //   583: getfield 1091	tencent/im/msg/im_msg_body$RichMsg:bytes_template_1	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   586: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   589: invokevirtual 257	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   592: astore 43
    //   594: new 1075	com/tencent/mobileqq/data/MessageForStructing
    //   597: dup
    //   598: invokespecial 2096	com/tencent/mobileqq/data/MessageForStructing:<init>	()V
    //   601: astore 42
    //   603: aload 42
    //   605: sipush -2011
    //   608: putfield 2097	com/tencent/mobileqq/data/MessageForStructing:msgtype	I
    //   611: aload_2
    //   612: getfield 234	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   615: getfield 419	msf/msgcomm/msg_comm$MsgHead:to_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   618: invokevirtual 245	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   621: lstore 24
    //   623: aload_2
    //   624: getfield 234	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   627: getfield 248	msf/msgcomm/msg_comm$MsgHead:msg_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   630: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   633: istore 12
    //   635: iload 12
    //   637: bipush 82
    //   639: if_icmpeq +14 -> 653
    //   642: lload 24
    //   644: lstore 22
    //   646: iload 12
    //   648: bipush 43
    //   650: if_icmpne +52 -> 702
    //   653: lload 24
    //   655: lstore 22
    //   657: aload_2
    //   658: getfield 234	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   661: getfield 2101	msf/msgcomm/msg_comm$MsgHead:group_info	Lmsf/msgcomm/msg_comm$GroupInfo;
    //   664: ifnull +38 -> 702
    //   667: lload 24
    //   669: lstore 22
    //   671: aload_2
    //   672: getfield 234	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   675: getfield 2101	msf/msgcomm/msg_comm$MsgHead:group_info	Lmsf/msgcomm/msg_comm$GroupInfo;
    //   678: getfield 2104	msf/msgcomm/msg_comm$GroupInfo:group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   681: invokevirtual 2105	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   684: ifeq +18 -> 702
    //   687: aload_2
    //   688: getfield 234	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   691: getfield 2101	msf/msgcomm/msg_comm$MsgHead:group_info	Lmsf/msgcomm/msg_comm$GroupInfo;
    //   694: getfield 2104	msf/msgcomm/msg_comm$GroupInfo:group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   697: invokevirtual 245	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   700: lstore 22
    //   702: aload 42
    //   704: aload_0
    //   705: getfield 216	com/tencent/mobileqq/app/MessageHandler:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   708: iload 12
    //   710: lload 22
    //   712: aload 43
    //   714: iconst_m1
    //   715: invokestatic 2110	com/tencent/mobileqq/structmsg/StructMsgFactory:a	(Lcom/tencent/mobileqq/app/QQAppInterface;IJ[BI)Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   718: putfield 1079	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   721: aload 42
    //   723: getfield 1079	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   726: getfield 1097	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   729: bipush 37
    //   731: if_icmpne +262 -> 993
    //   734: new 94	java/lang/String
    //   737: dup
    //   738: aload 43
    //   740: iconst_m1
    //   741: invokestatic 2115	com/tencent/mobileqq/structmsg/StructMsgUtils:a	([BI)[B
    //   744: ldc_w 2117
    //   747: invokespecial 2120	java/lang/String:<init>	([BLjava/lang/String;)V
    //   750: astore 42
    //   752: aload 47
    //   754: aload 42
    //   756: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   759: pop
    //   760: aload 42
    //   762: invokestatic 2122	com/tencent/mobileqq/service/message/MessageProtoCodec:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/PAMessage;
    //   765: astore 42
    //   767: aload 42
    //   769: ifnull +59 -> 828
    //   772: sipush -3006
    //   775: invokestatic 399	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   778: checkcast 2124	com/tencent/mobileqq/data/MessageForPubAccount
    //   781: astore 38
    //   783: aload 38
    //   785: sipush -3006
    //   788: putfield 2125	com/tencent/mobileqq/data/MessageForPubAccount:msgtype	I
    //   791: aload 38
    //   793: aload 47
    //   795: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   798: putfield 2126	com/tencent/mobileqq/data/MessageForPubAccount:msg	Ljava/lang/String;
    //   801: aload 38
    //   803: aload 42
    //   805: putfield 2130	com/tencent/mobileqq/data/MessageForPubAccount:mPAMessage	Lcom/tencent/mobileqq/data/PAMessage;
    //   808: aload 38
    //   810: aload 42
    //   812: invokestatic 2133	com/tencent/biz/pubaccount/util/PAMessageUtil:a	(Lcom/tencent/mobileqq/data/PAMessage;)[B
    //   815: putfield 2134	com/tencent/mobileqq/data/MessageForPubAccount:msgData	[B
    //   818: aload 46
    //   820: aload 38
    //   822: invokeinterface 375 2 0
    //   827: pop
    //   828: aload 47
    //   830: iconst_0
    //   831: aload 47
    //   833: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   836: invokevirtual 126	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   839: pop
    //   840: iload 9
    //   842: istore 12
    //   844: aload 41
    //   846: astore 38
    //   848: iload 10
    //   850: istore 13
    //   852: iload 11
    //   854: istore 14
    //   856: aload 39
    //   858: astore 43
    //   860: aload 40
    //   862: astore 41
    //   864: iload 8
    //   866: istore 11
    //   868: iload 7
    //   870: istore 9
    //   872: iload 12
    //   874: istore 10
    //   876: aload 42
    //   878: astore 39
    //   880: iload 13
    //   882: istore 7
    //   884: iload 14
    //   886: istore 8
    //   888: aload 43
    //   890: astore 40
    //   892: goto -465 -> 427
    //   895: astore 43
    //   897: aload 43
    //   899: invokevirtual 2135	java/lang/Exception:printStackTrace	()V
    //   902: goto -94 -> 808
    //   905: astore 43
    //   907: aload 42
    //   909: astore 38
    //   911: aload 43
    //   913: astore 42
    //   915: aload 42
    //   917: invokevirtual 2135	java/lang/Exception:printStackTrace	()V
    //   920: iload 9
    //   922: istore 12
    //   924: aload 41
    //   926: astore 42
    //   928: aload 38
    //   930: astore 43
    //   932: iload 10
    //   934: istore 13
    //   936: iload 11
    //   938: istore 14
    //   940: aload 39
    //   942: astore 44
    //   944: aload 40
    //   946: astore 41
    //   948: iload 8
    //   950: istore 11
    //   952: iload 7
    //   954: istore 9
    //   956: iload 12
    //   958: istore 10
    //   960: aload 42
    //   962: astore 38
    //   964: aload 43
    //   966: astore 39
    //   968: iload 13
    //   970: istore 7
    //   972: iload 14
    //   974: istore 8
    //   976: aload 44
    //   978: astore 40
    //   980: goto -553 -> 427
    //   983: astore 43
    //   985: aload 43
    //   987: invokevirtual 2135	java/lang/Exception:printStackTrace	()V
    //   990: goto -172 -> 818
    //   993: aload 40
    //   995: ifnull +13 -> 1008
    //   998: aload 42
    //   1000: getfield 1079	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1003: aload 40
    //   1005: putfield 1105	com/tencent/mobileqq/structmsg/AbsStructMsg:mCompatibleText	Ljava/lang/String;
    //   1008: aload 42
    //   1010: getfield 1079	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1013: ifnull +16 -> 1029
    //   1016: aload 42
    //   1018: aload 42
    //   1020: getfield 1079	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1023: invokevirtual 2136	com/tencent/mobileqq/structmsg/AbsStructMsg:getBytes	()[B
    //   1026: putfield 2137	com/tencent/mobileqq/data/MessageForStructing:msgData	[B
    //   1029: aload 42
    //   1031: ldc_w 2139
    //   1034: putfield 2140	com/tencent/mobileqq/data/MessageForStructing:msg	Ljava/lang/String;
    //   1037: aload 42
    //   1039: getfield 1079	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1042: ifnonnull +75 -> 1117
    //   1045: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1048: ifeq +12 -> 1060
    //   1051: aload 45
    //   1053: ldc_w 2142
    //   1056: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1059: pop
    //   1060: iconst_1
    //   1061: istore 10
    //   1063: aload 41
    //   1065: astore 42
    //   1067: aload 38
    //   1069: astore 43
    //   1071: iconst_0
    //   1072: istore 13
    //   1074: iload 11
    //   1076: istore 12
    //   1078: aload 39
    //   1080: astore 44
    //   1082: aload 40
    //   1084: astore 41
    //   1086: iload 8
    //   1088: istore 11
    //   1090: iload 7
    //   1092: istore 9
    //   1094: aload 42
    //   1096: astore 38
    //   1098: aload 43
    //   1100: astore 39
    //   1102: iload 13
    //   1104: istore 7
    //   1106: iload 12
    //   1108: istore 8
    //   1110: aload 44
    //   1112: astore 40
    //   1114: goto -687 -> 427
    //   1117: aload 46
    //   1119: aload 42
    //   1121: invokeinterface 375 2 0
    //   1126: pop
    //   1127: iconst_1
    //   1128: istore 10
    //   1130: aload 38
    //   1132: astore 43
    //   1134: iconst_0
    //   1135: istore 13
    //   1137: iload 11
    //   1139: istore 12
    //   1141: aload 39
    //   1143: astore 44
    //   1145: aload 40
    //   1147: astore 41
    //   1149: iload 8
    //   1151: istore 11
    //   1153: iload 7
    //   1155: istore 9
    //   1157: aload 42
    //   1159: astore 38
    //   1161: aload 43
    //   1163: astore 39
    //   1165: iload 13
    //   1167: istore 7
    //   1169: iload 12
    //   1171: istore 8
    //   1173: aload 44
    //   1175: astore 40
    //   1177: goto -750 -> 427
    //   1180: aload 49
    //   1182: getfield 937	tencent/im/msg/im_msg_body$Elem:text	Ltencent/im/msg/im_msg_body$Text;
    //   1185: invokevirtual 1691	tencent/im/msg/im_msg_body$Text:has	()Z
    //   1188: ifeq +840 -> 2028
    //   1191: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1194: ifeq +12 -> 1206
    //   1197: aload 45
    //   1199: ldc_w 2144
    //   1202: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1205: pop
    //   1206: aload 47
    //   1208: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   1211: istore 16
    //   1213: aload 49
    //   1215: getfield 937	tencent/im/msg/im_msg_body$Elem:text	Ltencent/im/msg/im_msg_body$Text;
    //   1218: invokevirtual 1738	tencent/im/msg/im_msg_body$Text:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1221: checkcast 925	tencent/im/msg/im_msg_body$Text
    //   1224: astore 42
    //   1226: aconst_null
    //   1227: astore 40
    //   1229: aload 42
    //   1231: getfield 929	tencent/im/msg/im_msg_body$Text:str	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1234: invokevirtual 197	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   1237: ifeq +28 -> 1265
    //   1240: aload 42
    //   1242: getfield 929	tencent/im/msg/im_msg_body$Text:str	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1245: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1248: invokevirtual 1424	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1251: astore 40
    //   1253: aload 47
    //   1255: aload 40
    //   1257: iconst_0
    //   1258: invokestatic 2147	com/tencent/mobileqq/service/message/MessageUtils:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   1261: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1264: pop
    //   1265: iload 9
    //   1267: ifeq +362 -> 1629
    //   1270: aload 41
    //   1272: ifnull +357 -> 1629
    //   1275: aload 41
    //   1277: getfield 1079	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1280: aload 40
    //   1282: putfield 1105	com/tencent/mobileqq/structmsg/AbsStructMsg:mCompatibleText	Ljava/lang/String;
    //   1285: aload 41
    //   1287: getfield 1079	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1290: ifnull +16 -> 1306
    //   1293: aload 41
    //   1295: aload 41
    //   1297: getfield 1079	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1300: invokevirtual 2136	com/tencent/mobileqq/structmsg/AbsStructMsg:getBytes	()[B
    //   1303: putfield 2137	com/tencent/mobileqq/data/MessageForStructing:msgData	[B
    //   1306: aload 47
    //   1308: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   1311: ifle +38 -> 1349
    //   1314: sipush -1000
    //   1317: invokestatic 399	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   1320: checkcast 1120	com/tencent/mobileqq/data/MessageForText
    //   1323: astore_0
    //   1324: aload_0
    //   1325: sipush -1000
    //   1328: putfield 1848	com/tencent/mobileqq/data/MessageForText:msgtype	I
    //   1331: aload_0
    //   1332: aload 47
    //   1334: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1337: putfield 1121	com/tencent/mobileqq/data/MessageForText:msg	Ljava/lang/String;
    //   1340: aload 46
    //   1342: aload_0
    //   1343: invokeinterface 375 2 0
    //   1348: pop
    //   1349: iload 11
    //   1351: ifle +74 -> 1425
    //   1354: aload 46
    //   1356: invokeinterface 1895 1 0
    //   1361: iconst_1
    //   1362: if_icmpne +63 -> 1425
    //   1365: aload 46
    //   1367: iconst_0
    //   1368: invokeinterface 2041 2 0
    //   1373: checkcast 356	com/tencent/mobileqq/data/MessageRecord
    //   1376: astore_0
    //   1377: aload_0
    //   1378: instanceof 1120
    //   1381: ifeq +44 -> 1425
    //   1384: aload_0
    //   1385: iload 11
    //   1387: invokevirtual 2150	com/tencent/mobileqq/data/MessageRecord:setRepeatCount	(I)V
    //   1390: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1393: ifeq +32 -> 1425
    //   1396: ldc 13
    //   1398: iconst_2
    //   1399: new 91	java/lang/StringBuilder
    //   1402: dup
    //   1403: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   1406: ldc_w 2152
    //   1409: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1412: aload_0
    //   1413: invokevirtual 2155	com/tencent/mobileqq/data/MessageRecord:getRepeatCount	()I
    //   1416: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1419: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1422: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1425: new 99	java/util/ArrayList
    //   1428: dup
    //   1429: invokespecial 1367	java/util/ArrayList:<init>	()V
    //   1432: astore_0
    //   1433: iload 9
    //   1435: ifeq +6183 -> 7618
    //   1438: aload 41
    //   1440: ifnull +6150 -> 7590
    //   1443: aload_0
    //   1444: aload 41
    //   1446: invokeinterface 375 2 0
    //   1451: pop
    //   1452: aload_0
    //   1453: invokeinterface 1895 1 0
    //   1458: iconst_1
    //   1459: if_icmple +6287 -> 7746
    //   1462: aload_0
    //   1463: invokeinterface 59 1 0
    //   1468: astore_2
    //   1469: iconst_0
    //   1470: istore 7
    //   1472: iconst_0
    //   1473: istore 6
    //   1475: aload_2
    //   1476: invokeinterface 64 1 0
    //   1481: ifeq +6265 -> 7746
    //   1484: aload_2
    //   1485: invokeinterface 68 1 0
    //   1490: checkcast 356	com/tencent/mobileqq/data/MessageRecord
    //   1493: astore 5
    //   1495: aload 5
    //   1497: getfield 362	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   1500: sipush -1000
    //   1503: if_icmpne +6127 -> 7630
    //   1506: iload 6
    //   1508: ifne +6122 -> 7630
    //   1511: iconst_1
    //   1512: istore 6
    //   1514: iload 7
    //   1516: iconst_1
    //   1517: iadd
    //   1518: istore 7
    //   1520: iload 7
    //   1522: iconst_2
    //   1523: if_icmplt +6127 -> 7650
    //   1526: iconst_1
    //   1527: istore 6
    //   1529: iload 6
    //   1531: ifeq +6196 -> 7727
    //   1534: new 99	java/util/ArrayList
    //   1537: dup
    //   1538: invokespecial 1367	java/util/ArrayList:<init>	()V
    //   1541: astore_2
    //   1542: aload_0
    //   1543: invokeinterface 59 1 0
    //   1548: astore_0
    //   1549: aload_0
    //   1550: invokeinterface 64 1 0
    //   1555: ifeq +6110 -> 7665
    //   1558: aload_0
    //   1559: invokeinterface 68 1 0
    //   1564: checkcast 356	com/tencent/mobileqq/data/MessageRecord
    //   1567: astore 5
    //   1569: aload 5
    //   1571: getfield 362	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   1574: sipush -1000
    //   1577: if_icmpeq +6076 -> 7653
    //   1580: aload 5
    //   1582: getfield 362	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   1585: sipush -2000
    //   1588: if_icmpeq +6065 -> 7653
    //   1591: aload_2
    //   1592: invokeinterface 1895 1 0
    //   1597: ifle +20 -> 1617
    //   1600: aload_1
    //   1601: aload_2
    //   1602: invokestatic 2157	com/tencent/mobileqq/service/message/MessageProtoCodec:a	(Ljava/util/List;)Lcom/tencent/mobileqq/data/MessageRecord;
    //   1605: invokeinterface 375 2 0
    //   1610: pop
    //   1611: aload_2
    //   1612: invokeinterface 2160 1 0
    //   1617: aload_1
    //   1618: aload 5
    //   1620: invokeinterface 375 2 0
    //   1625: pop
    //   1626: goto -77 -> 1549
    //   1629: iload 7
    //   1631: ifne +8 -> 1639
    //   1634: iload 8
    //   1636: ifeq +23 -> 1659
    //   1639: aload 47
    //   1641: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   1644: ifle +15 -> 1659
    //   1647: aload 47
    //   1649: iconst_0
    //   1650: aload 47
    //   1652: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   1655: invokevirtual 126	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   1658: pop
    //   1659: aload 49
    //   1661: getfield 937	tencent/im/msg/im_msg_body$Elem:text	Ltencent/im/msg/im_msg_body$Text;
    //   1664: getfield 2163	tencent/im/msg/im_msg_body$Text:attr_6_buf	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1667: invokevirtual 197	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   1670: ifeq +141 -> 1811
    //   1673: aload_2
    //   1674: getfield 234	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   1677: getfield 241	msf/msgcomm/msg_comm$MsgHead:from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1680: invokevirtual 245	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1683: aload_0
    //   1684: getfield 216	com/tencent/mobileqq/app/MessageHandler:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1687: invokevirtual 2166	com/tencent/mobileqq/app/QQAppInterface:getLongAccountUin	()J
    //   1690: lcmp
    //   1691: ifeq +120 -> 1811
    //   1694: aload 5
    //   1696: ifnull +115 -> 1811
    //   1699: aload 5
    //   1701: getfield 2171	com/tencent/mobileqq/troop/data/MessageInfo:a	Lcom/tencent/mobileqq/troop/data/MessageNavInfo;
    //   1704: lload 28
    //   1706: invokevirtual 2176	com/tencent/mobileqq/troop/data/MessageNavInfo:a	(J)Z
    //   1709: ifne +16 -> 1725
    //   1712: aload 5
    //   1714: getfield 2178	com/tencent/mobileqq/troop/data/MessageInfo:c	Lcom/tencent/mobileqq/troop/data/MessageNavInfo;
    //   1717: lload 28
    //   1719: invokevirtual 2176	com/tencent/mobileqq/troop/data/MessageNavInfo:a	(J)Z
    //   1722: ifeq +89 -> 1811
    //   1725: aload 49
    //   1727: getfield 937	tencent/im/msg/im_msg_body$Elem:text	Ltencent/im/msg/im_msg_body$Text;
    //   1730: getfield 2163	tencent/im/msg/im_msg_body$Text:attr_6_buf	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1733: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1736: astore 42
    //   1738: aload 42
    //   1740: ifnull +189 -> 1929
    //   1743: aload 42
    //   1745: invokevirtual 257	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   1748: astore 42
    //   1750: aload 42
    //   1752: ifnull +59 -> 1811
    //   1755: aload 42
    //   1757: arraylength
    //   1758: ifeq +53 -> 1811
    //   1761: aload 42
    //   1763: iconst_0
    //   1764: invokestatic 313	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI)S
    //   1767: istore 18
    //   1769: iconst_2
    //   1770: istore 12
    //   1772: iconst_0
    //   1773: istore 13
    //   1775: iload 13
    //   1777: iload 18
    //   1779: if_icmpge +32 -> 1811
    //   1782: iload 12
    //   1784: sipush 2048
    //   1787: if_icmpge +24 -> 1811
    //   1790: new 107	com/tencent/mobileqq/data/MessageForText$AtTroopMemberInfo
    //   1793: dup
    //   1794: invokespecial 2179	com/tencent/mobileqq/data/MessageForText$AtTroopMemberInfo:<init>	()V
    //   1797: astore 43
    //   1799: aload 43
    //   1801: aload 42
    //   1803: iload 12
    //   1805: invokevirtual 2183	com/tencent/mobileqq/data/MessageForText$AtTroopMemberInfo:readFrom	([BI)Z
    //   1808: ifne +127 -> 1935
    //   1811: iload 7
    //   1813: istore 12
    //   1815: iload 10
    //   1817: istore 7
    //   1819: iload 9
    //   1821: istore 10
    //   1823: iload 12
    //   1825: istore 9
    //   1827: aload 49
    //   1829: getfield 74	tencent/im/msg/im_msg_body$Elem:elem_flags2	Ltencent/im/msg/im_msg_body$ElemFlags2;
    //   1832: invokevirtual 77	tencent/im/msg/im_msg_body$ElemFlags2:has	()Z
    //   1835: ifeq +5917 -> 7752
    //   1838: aload 49
    //   1840: getfield 74	tencent/im/msg/im_msg_body$Elem:elem_flags2	Ltencent/im/msg/im_msg_body$ElemFlags2;
    //   1843: getfield 2186	tencent/im/msg/im_msg_body$ElemFlags2:uint32_msg_rpt_cnt	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1846: invokevirtual 85	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1849: ifeq +5903 -> 7752
    //   1852: aload 49
    //   1854: getfield 74	tencent/im/msg/im_msg_body$Elem:elem_flags2	Ltencent/im/msg/im_msg_body$ElemFlags2;
    //   1857: getfield 2186	tencent/im/msg/im_msg_body$ElemFlags2:uint32_msg_rpt_cnt	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1860: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1863: istore 12
    //   1865: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1868: ifeq +30 -> 1898
    //   1871: ldc 13
    //   1873: iconst_2
    //   1874: new 91	java/lang/StringBuilder
    //   1877: dup
    //   1878: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   1881: ldc_w 2188
    //   1884: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1887: iload 12
    //   1889: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1892: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1895: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1898: aload 39
    //   1900: astore 42
    //   1902: aload 38
    //   1904: astore 39
    //   1906: aload 41
    //   1908: astore 38
    //   1910: aload 40
    //   1912: astore 41
    //   1914: iload 8
    //   1916: istore 11
    //   1918: iload 12
    //   1920: istore 8
    //   1922: aload 42
    //   1924: astore 40
    //   1926: goto -1499 -> 427
    //   1929: aconst_null
    //   1930: astore 42
    //   1932: goto -182 -> 1750
    //   1935: iload 12
    //   1937: aload 43
    //   1939: invokevirtual 2189	com/tencent/mobileqq/data/MessageForText$AtTroopMemberInfo:length	()I
    //   1942: iadd
    //   1943: istore 14
    //   1945: aload 43
    //   1947: aload 43
    //   1949: getfield 114	com/tencent/mobileqq/data/MessageForText$AtTroopMemberInfo:startPos	S
    //   1952: iload 16
    //   1954: iadd
    //   1955: i2s
    //   1956: putfield 114	com/tencent/mobileqq/data/MessageForText$AtTroopMemberInfo:startPos	S
    //   1959: iload 13
    //   1961: iconst_1
    //   1962: iadd
    //   1963: i2s
    //   1964: istore 15
    //   1966: aload 43
    //   1968: invokevirtual 2192	com/tencent/mobileqq/data/MessageForText$AtTroopMemberInfo:isIncludingAll	()Z
    //   1971: ifeq +13 -> 1984
    //   1974: aload 5
    //   1976: getfield 2178	com/tencent/mobileqq/troop/data/MessageInfo:c	Lcom/tencent/mobileqq/troop/data/MessageNavInfo;
    //   1979: lload 28
    //   1981: putfield 2194	com/tencent/mobileqq/troop/data/MessageNavInfo:a	J
    //   1984: iload 15
    //   1986: istore 13
    //   1988: iload 14
    //   1990: istore 12
    //   1992: aload 43
    //   1994: aload_0
    //   1995: getfield 216	com/tencent/mobileqq/app/MessageHandler:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1998: invokevirtual 2166	com/tencent/mobileqq/app/QQAppInterface:getLongAccountUin	()J
    //   2001: invokevirtual 2197	com/tencent/mobileqq/data/MessageForText$AtTroopMemberInfo:isIncludingMe	(J)Z
    //   2004: ifeq -229 -> 1775
    //   2007: aload 5
    //   2009: getfield 2171	com/tencent/mobileqq/troop/data/MessageInfo:a	Lcom/tencent/mobileqq/troop/data/MessageNavInfo;
    //   2012: lload 28
    //   2014: putfield 2194	com/tencent/mobileqq/troop/data/MessageNavInfo:a	J
    //   2017: iload 15
    //   2019: istore 13
    //   2021: iload 14
    //   2023: istore 12
    //   2025: goto -250 -> 1775
    //   2028: aload 49
    //   2030: getfield 1071	tencent/im/msg/im_msg_body$Elem:shake_window	Ltencent/im/msg/im_msg_body$ShakeWindow;
    //   2033: invokevirtual 2198	tencent/im/msg/im_msg_body$ShakeWindow:has	()Z
    //   2036: ifeq +201 -> 2237
    //   2039: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2042: ifeq +12 -> 2054
    //   2045: aload 45
    //   2047: ldc_w 2200
    //   2050: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2053: pop
    //   2054: aload 49
    //   2056: getfield 1071	tencent/im/msg/im_msg_body$Elem:shake_window	Ltencent/im/msg/im_msg_body$ShakeWindow;
    //   2059: invokevirtual 2201	tencent/im/msg/im_msg_body$ShakeWindow:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2062: checkcast 1058	tencent/im/msg/im_msg_body$ShakeWindow
    //   2065: astore 42
    //   2067: sipush -2020
    //   2070: invokestatic 399	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   2073: checkcast 1052	com/tencent/mobileqq/data/MessageForShakeWindow
    //   2076: astore 43
    //   2078: aload 43
    //   2080: sipush -2020
    //   2083: putfield 2202	com/tencent/mobileqq/data/MessageForShakeWindow:msgtype	I
    //   2086: aload 43
    //   2088: ldc_w 2204
    //   2091: putfield 2205	com/tencent/mobileqq/data/MessageForShakeWindow:msg	Ljava/lang/String;
    //   2094: aload 47
    //   2096: iconst_0
    //   2097: aload 47
    //   2099: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   2102: invokevirtual 126	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   2105: pop
    //   2106: new 1064	com/tencent/mobileqq/data/ShakeWindowMsg
    //   2109: dup
    //   2110: invokespecial 2206	com/tencent/mobileqq/data/ShakeWindowMsg:<init>	()V
    //   2113: astore 44
    //   2115: aload 44
    //   2117: aload 42
    //   2119: getfield 1062	tencent/im/msg/im_msg_body$ShakeWindow:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2122: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2125: putfield 1067	com/tencent/mobileqq/data/ShakeWindowMsg:mType	I
    //   2128: aload 44
    //   2130: aload 42
    //   2132: getfield 2209	tencent/im/msg/im_msg_body$ShakeWindow:uint32_reserve	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2135: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2138: putfield 2212	com/tencent/mobileqq/data/ShakeWindowMsg:mReserve	I
    //   2141: iload 4
    //   2143: ifeq +75 -> 2218
    //   2146: iconst_2
    //   2147: istore 12
    //   2149: aload 44
    //   2151: iload 12
    //   2153: putfield 2215	com/tencent/mobileqq/data/ShakeWindowMsg:onlineFlag	I
    //   2156: aload 44
    //   2158: iconst_1
    //   2159: putfield 2218	com/tencent/mobileqq/data/ShakeWindowMsg:shake	Z
    //   2162: aload 43
    //   2164: aload 44
    //   2166: invokevirtual 2219	com/tencent/mobileqq/data/ShakeWindowMsg:getBytes	()[B
    //   2169: putfield 2220	com/tencent/mobileqq/data/MessageForShakeWindow:msgData	[B
    //   2172: aload 43
    //   2174: getfield 2220	com/tencent/mobileqq/data/MessageForShakeWindow:msgData	[B
    //   2177: ifnonnull +47 -> 2224
    //   2180: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2183: ifeq +12 -> 2195
    //   2186: aload 45
    //   2188: ldc_w 2142
    //   2191: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2194: pop
    //   2195: iload 9
    //   2197: istore 12
    //   2199: iload 10
    //   2201: istore 13
    //   2203: iload 7
    //   2205: istore 9
    //   2207: iload 12
    //   2209: istore 10
    //   2211: iload 13
    //   2213: istore 7
    //   2215: goto -388 -> 1827
    //   2218: iconst_1
    //   2219: istore 12
    //   2221: goto -72 -> 2149
    //   2224: aload 46
    //   2226: aload 43
    //   2228: invokeinterface 375 2 0
    //   2233: pop
    //   2234: goto -928 -> 1306
    //   2237: aload 49
    //   2239: getfield 178	tencent/im/msg/im_msg_body$Elem:face	Ltencent/im/msg/im_msg_body$Face;
    //   2242: invokevirtual 2221	tencent/im/msg/im_msg_body$Face:has	()Z
    //   2245: ifeq +123 -> 2368
    //   2248: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2251: ifeq +12 -> 2263
    //   2254: aload 45
    //   2256: ldc_w 2223
    //   2259: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2262: pop
    //   2263: iload 8
    //   2265: istore 12
    //   2267: aload 49
    //   2269: getfield 178	tencent/im/msg/im_msg_body$Elem:face	Ltencent/im/msg/im_msg_body$Face;
    //   2272: invokevirtual 2224	tencent/im/msg/im_msg_body$Face:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2275: checkcast 165	tencent/im/msg/im_msg_body$Face
    //   2278: getfield 169	tencent/im/msg/im_msg_body$Face:index	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2281: invokevirtual 85	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   2284: ifeq +5279 -> 7563
    //   2287: aload 49
    //   2289: getfield 178	tencent/im/msg/im_msg_body$Elem:face	Ltencent/im/msg/im_msg_body$Face;
    //   2292: invokevirtual 2224	tencent/im/msg/im_msg_body$Face:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2295: checkcast 165	tencent/im/msg/im_msg_body$Face
    //   2298: getfield 169	tencent/im/msg/im_msg_body$Face:index	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2301: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2304: istore 12
    //   2306: iload 12
    //   2308: getstatic 2226	com/tencent/mobileqq/service/message/MessageUtils:b	[S
    //   2311: arraylength
    //   2312: if_icmpge +33 -> 2345
    //   2315: getstatic 2226	com/tencent/mobileqq/service/message/MessageUtils:b	[S
    //   2318: iload 12
    //   2320: saload
    //   2321: istore 12
    //   2323: iload 12
    //   2325: iflt +20 -> 2345
    //   2328: aload 47
    //   2330: bipush 20
    //   2332: invokevirtual 187	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   2335: pop
    //   2336: aload 47
    //   2338: iload 12
    //   2340: i2c
    //   2341: invokevirtual 187	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   2344: pop
    //   2345: iload 9
    //   2347: istore 12
    //   2349: iload 10
    //   2351: istore 13
    //   2353: iload 7
    //   2355: istore 9
    //   2357: iload 12
    //   2359: istore 10
    //   2361: iload 13
    //   2363: istore 7
    //   2365: goto -538 -> 1827
    //   2368: aload 49
    //   2370: getfield 2230	tencent/im/msg/im_msg_body$Elem:online_image	Ltencent/im/msg/im_msg_body$OnlineImage;
    //   2373: invokevirtual 2233	tencent/im/msg/im_msg_body$OnlineImage:has	()Z
    //   2376: ifeq +72 -> 2448
    //   2379: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2382: ifeq +12 -> 2394
    //   2385: aload 45
    //   2387: ldc_w 2235
    //   2390: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2393: pop
    //   2394: iload 8
    //   2396: istore 12
    //   2398: iload 6
    //   2400: ifne +5163 -> 7563
    //   2403: aload 47
    //   2405: invokestatic 1683	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   2408: ldc_w 2236
    //   2411: invokevirtual 1690	android/content/Context:getString	(I)Ljava/lang/String;
    //   2414: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2417: pop
    //   2418: iload 7
    //   2420: istore 6
    //   2422: iload 9
    //   2424: istore 12
    //   2426: iconst_1
    //   2427: istore 13
    //   2429: iload 10
    //   2431: istore 7
    //   2433: iload 6
    //   2435: istore 9
    //   2437: iload 12
    //   2439: istore 10
    //   2441: iload 13
    //   2443: istore 6
    //   2445: goto -618 -> 1827
    //   2448: aload 49
    //   2450: getfield 1695	tencent/im/msg/im_msg_body$Elem:not_online_image	Ltencent/im/msg/im_msg_body$NotOnlineImage;
    //   2453: invokevirtual 1698	tencent/im/msg/im_msg_body$NotOnlineImage:has	()Z
    //   2456: ifeq +974 -> 3430
    //   2459: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2462: ifeq +12 -> 2474
    //   2465: aload 45
    //   2467: ldc_w 2238
    //   2470: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2473: pop
    //   2474: aload 47
    //   2476: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   2479: ifle +54 -> 2533
    //   2482: sipush -1000
    //   2485: invokestatic 399	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   2488: checkcast 1120	com/tencent/mobileqq/data/MessageForText
    //   2491: astore 42
    //   2493: aload 42
    //   2495: sipush -1000
    //   2498: putfield 1848	com/tencent/mobileqq/data/MessageForText:msgtype	I
    //   2501: aload 42
    //   2503: aload 47
    //   2505: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2508: putfield 1121	com/tencent/mobileqq/data/MessageForText:msg	Ljava/lang/String;
    //   2511: aload 46
    //   2513: aload 42
    //   2515: invokeinterface 375 2 0
    //   2520: pop
    //   2521: aload 47
    //   2523: iconst_0
    //   2524: aload 47
    //   2526: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   2529: invokevirtual 126	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   2532: pop
    //   2533: invokestatic 1683	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   2536: ldc_w 2236
    //   2539: invokevirtual 1690	android/content/Context:getString	(I)Ljava/lang/String;
    //   2542: pop
    //   2543: aload 49
    //   2545: getfield 1695	tencent/im/msg/im_msg_body$Elem:not_online_image	Ltencent/im/msg/im_msg_body$NotOnlineImage;
    //   2548: invokevirtual 1703	tencent/im/msg/im_msg_body$NotOnlineImage:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2551: checkcast 1697	tencent/im/msg/im_msg_body$NotOnlineImage
    //   2554: astore 50
    //   2556: aload 50
    //   2558: getfield 1706	tencent/im/msg/im_msg_body$NotOnlineImage:file_len	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2561: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2564: istore 13
    //   2566: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2569: ifeq +30 -> 2599
    //   2572: ldc 13
    //   2574: iconst_2
    //   2575: new 91	java/lang/StringBuilder
    //   2578: dup
    //   2579: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   2582: ldc_w 2240
    //   2585: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2588: iload 13
    //   2590: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2593: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2596: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2599: aload 50
    //   2601: getfield 2243	tencent/im/msg/im_msg_body$NotOnlineImage:flag	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2604: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2607: invokevirtual 257	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2610: pop
    //   2611: aload 50
    //   2613: getfield 2244	tencent/im/msg/im_msg_body$NotOnlineImage:str_thumb_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2616: invokevirtual 270	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2619: astore 51
    //   2621: aload 50
    //   2623: getfield 2247	tencent/im/msg/im_msg_body$NotOnlineImage:uint32_thumb_width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2626: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2629: istore 14
    //   2631: aload 50
    //   2633: getfield 2250	tencent/im/msg/im_msg_body$NotOnlineImage:uint32_thumb_height	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2636: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2639: istore 15
    //   2641: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2644: ifeq +41 -> 2685
    //   2647: ldc 13
    //   2649: iconst_2
    //   2650: new 91	java/lang/StringBuilder
    //   2653: dup
    //   2654: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   2657: ldc_w 2252
    //   2660: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2663: iload 14
    //   2665: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2668: ldc_w 2254
    //   2671: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2674: iload 15
    //   2676: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2679: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2682: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2685: aload 50
    //   2687: getfield 2255	tencent/im/msg/im_msg_body$NotOnlineImage:uint32_file_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2690: invokevirtual 85	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   2693: ifeq +5100 -> 7793
    //   2696: aload 50
    //   2698: getfield 2255	tencent/im/msg/im_msg_body$NotOnlineImage:uint32_file_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2701: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2704: istore 12
    //   2706: aload 50
    //   2708: getfield 2256	tencent/im/msg/im_msg_body$NotOnlineImage:str_big_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2711: invokevirtual 270	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2714: astore 52
    //   2716: aload 50
    //   2718: getfield 2257	tencent/im/msg/im_msg_body$NotOnlineImage:str_orig_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2721: invokevirtual 270	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2724: astore 53
    //   2726: aload 50
    //   2728: getfield 2260	tencent/im/msg/im_msg_body$NotOnlineImage:pic_width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2731: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2734: istore 16
    //   2736: aload 50
    //   2738: getfield 2263	tencent/im/msg/im_msg_body$NotOnlineImage:pic_height	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2741: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2744: istore 18
    //   2746: aload 50
    //   2748: getfield 2266	tencent/im/msg/im_msg_body$NotOnlineImage:original	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2751: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2754: istore 19
    //   2756: aload 50
    //   2758: getfield 2269	tencent/im/msg/im_msg_body$NotOnlineImage:res_id	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2761: invokevirtual 197	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   2764: ifeq +414 -> 3178
    //   2767: aload 50
    //   2769: getfield 2269	tencent/im/msg/im_msg_body$NotOnlineImage:res_id	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2772: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2775: invokevirtual 1424	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   2778: astore 42
    //   2780: aload 42
    //   2782: ifnull +423 -> 3205
    //   2785: aload 42
    //   2787: ldc_w 281
    //   2790: invokevirtual 426	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2793: ifne +412 -> 3205
    //   2796: ldc_w 281
    //   2799: astore 44
    //   2801: aload 44
    //   2803: astore 43
    //   2805: aload 50
    //   2807: getfield 2272	tencent/im/msg/im_msg_body$NotOnlineImage:pic_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2810: invokevirtual 197	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   2813: ifeq +42 -> 2855
    //   2816: aload 50
    //   2818: getfield 2272	tencent/im/msg/im_msg_body$NotOnlineImage:pic_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2821: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2824: invokevirtual 257	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2827: astore 54
    //   2829: aload 44
    //   2831: astore 43
    //   2833: aload 54
    //   2835: ifnull +20 -> 2855
    //   2838: aload 44
    //   2840: astore 43
    //   2842: aload 54
    //   2844: arraylength
    //   2845: ifle +10 -> 2855
    //   2848: aload 54
    //   2850: invokestatic 716	com/tencent/mobileqq/utils/HexUtil:a	([B)Ljava/lang/String;
    //   2853: astore 43
    //   2855: aload 42
    //   2857: iload 13
    //   2859: i2l
    //   2860: iconst_1
    //   2861: iconst_0
    //   2862: aload 42
    //   2864: aload 43
    //   2866: ldc_w 2274
    //   2869: aload 51
    //   2871: aload 52
    //   2873: aload 53
    //   2875: iload 19
    //   2877: iconst_0
    //   2878: invokestatic 2277	com/tencent/mobileqq/transfile/TransfileUtile:a	(Ljava/lang/String;JIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)Ljava/lang/String;
    //   2881: astore 54
    //   2883: new 377	localpb/richMsg/RichMsg$PicRec
    //   2886: dup
    //   2887: invokespecial 378	localpb/richMsg/RichMsg$PicRec:<init>	()V
    //   2890: astore 44
    //   2892: aload 44
    //   2894: getfield 1452	localpb/richMsg/RichMsg$PicRec:localPath	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2897: aload 42
    //   2899: invokevirtual 371	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   2902: aload 44
    //   2904: getfield 1454	localpb/richMsg/RichMsg$PicRec:size	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   2907: iload 13
    //   2909: i2l
    //   2910: invokevirtual 581	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   2913: aload 44
    //   2915: getfield 1457	localpb/richMsg/RichMsg$PicRec:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2918: iconst_1
    //   2919: invokevirtual 173	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   2922: aload 44
    //   2924: getfield 1460	localpb/richMsg/RichMsg$PicRec:isRead	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   2927: iconst_0
    //   2928: invokevirtual 823	com/tencent/mobileqq/pb/PBBoolField:set	(Z)V
    //   2931: aload 44
    //   2933: getfield 1463	localpb/richMsg/RichMsg$PicRec:uuid	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2936: aload 42
    //   2938: invokevirtual 371	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   2941: aload 44
    //   2943: getfield 2280	localpb/richMsg/RichMsg$PicRec:md5	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2946: aload 43
    //   2948: invokevirtual 371	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   2951: aload 44
    //   2953: getfield 1466	localpb/richMsg/RichMsg$PicRec:serverStorageSource	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2956: ldc_w 2274
    //   2959: invokevirtual 371	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   2962: aload 44
    //   2964: getfield 2283	localpb/richMsg/RichMsg$PicRec:thumbMsgUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2967: aload 51
    //   2969: invokevirtual 371	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   2972: aload 44
    //   2974: getfield 2284	localpb/richMsg/RichMsg$PicRec:uint32_thumb_width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2977: iload 14
    //   2979: invokevirtual 173	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   2982: aload 44
    //   2984: getfield 2285	localpb/richMsg/RichMsg$PicRec:uint32_thumb_height	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2987: iload 15
    //   2989: invokevirtual 173	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   2992: aload 44
    //   2994: getfield 2288	localpb/richMsg/RichMsg$PicRec:uint32_width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2997: iload 16
    //   2999: invokevirtual 173	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   3002: aload 44
    //   3004: getfield 2291	localpb/richMsg/RichMsg$PicRec:uint32_height	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3007: iload 18
    //   3009: invokevirtual 173	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   3012: aload 50
    //   3014: getfield 2255	tencent/im/msg/im_msg_body$NotOnlineImage:uint32_file_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3017: invokevirtual 85	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   3020: ifeq +14 -> 3034
    //   3023: aload 44
    //   3025: getfield 2294	localpb/richMsg/RichMsg$PicRec:groupFileID	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   3028: iload 12
    //   3030: i2l
    //   3031: invokevirtual 581	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   3034: aload 44
    //   3036: getfield 2297	localpb/richMsg/RichMsg$PicRec:bigMsgUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3039: aload 52
    //   3041: invokevirtual 371	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   3044: aload 44
    //   3046: getfield 2300	localpb/richMsg/RichMsg$PicRec:rawMsgUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3049: aload 53
    //   3051: invokevirtual 371	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   3054: aload 44
    //   3056: getfield 2303	localpb/richMsg/RichMsg$PicRec:fileSizeFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   3059: iload 19
    //   3061: invokevirtual 1475	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   3064: aload 44
    //   3066: getfield 2306	localpb/richMsg/RichMsg$PicRec:uiOperatorFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   3069: iconst_0
    //   3070: invokevirtual 1475	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   3073: aload 44
    //   3075: getfield 1472	localpb/richMsg/RichMsg$PicRec:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   3078: iconst_5
    //   3079: invokevirtual 1475	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   3082: aload 44
    //   3084: getfield 1478	localpb/richMsg/RichMsg$PicRec:isReport	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   3087: iconst_0
    //   3088: invokevirtual 1475	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   3091: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3094: ifeq +17 -> 3111
    //   3097: aload 45
    //   3099: ldc_w 2308
    //   3102: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3105: aload 54
    //   3107: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3110: pop
    //   3111: sipush -2000
    //   3114: invokestatic 399	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3117: checkcast 941	com/tencent/mobileqq/data/MessageForPic
    //   3120: astore 42
    //   3122: aload 42
    //   3124: sipush -2000
    //   3127: putfield 1479	com/tencent/mobileqq/data/MessageForPic:msgtype	I
    //   3130: aload 42
    //   3132: aload 44
    //   3134: invokevirtual 1480	localpb/richMsg/RichMsg$PicRec:toByteArray	()[B
    //   3137: putfield 1481	com/tencent/mobileqq/data/MessageForPic:msgData	[B
    //   3140: aload 42
    //   3142: invokevirtual 1482	com/tencent/mobileqq/data/MessageForPic:parse	()V
    //   3145: aload 46
    //   3147: aload 42
    //   3149: invokeinterface 375 2 0
    //   3154: pop
    //   3155: iload 9
    //   3157: istore 12
    //   3159: iload 10
    //   3161: istore 13
    //   3163: iload 7
    //   3165: istore 9
    //   3167: iload 12
    //   3169: istore 10
    //   3171: iload 13
    //   3173: istore 7
    //   3175: goto -1348 -> 1827
    //   3178: aload 50
    //   3180: getfield 1709	tencent/im/msg/im_msg_body$NotOnlineImage:download_path	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3183: invokevirtual 197	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   3186: ifeq +4601 -> 7787
    //   3189: aload 50
    //   3191: getfield 1709	tencent/im/msg/im_msg_body$NotOnlineImage:download_path	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3194: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3197: invokevirtual 1424	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   3200: astore 42
    //   3202: goto -422 -> 2780
    //   3205: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3208: ifeq +30 -> 3238
    //   3211: aload 45
    //   3213: new 91	java/lang/StringBuilder
    //   3216: dup
    //   3217: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   3220: ldc_w 2310
    //   3223: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3226: aload 42
    //   3228: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3231: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3234: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3237: pop
    //   3238: aload_2
    //   3239: getfield 234	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   3242: invokevirtual 237	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3245: checkcast 236	msf/msgcomm/msg_comm$MsgHead
    //   3248: astore 42
    //   3250: aload 42
    //   3252: getfield 294	msf/msgcomm/msg_comm$MsgHead:msg_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3255: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3258: i2l
    //   3259: lstore 22
    //   3261: aload 42
    //   3263: getfield 1308	msf/msgcomm/msg_comm$MsgHead:msg_uid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   3266: invokevirtual 245	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   3269: lstore 24
    //   3271: aload 42
    //   3273: getfield 291	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3276: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3279: i2l
    //   3280: lstore 26
    //   3282: aload 42
    //   3284: getfield 241	msf/msgcomm/msg_comm$MsgHead:from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   3287: invokevirtual 245	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   3290: lstore 30
    //   3292: aload 42
    //   3294: getfield 419	msf/msgcomm/msg_comm$MsgHead:to_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   3297: invokevirtual 245	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   3300: lstore 32
    //   3302: new 2312	java/util/HashMap
    //   3305: dup
    //   3306: invokespecial 2313	java/util/HashMap:<init>	()V
    //   3309: astore 42
    //   3311: aload 42
    //   3313: ldc_w 2315
    //   3316: sipush 10002
    //   3319: invokestatic 2317	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   3322: invokevirtual 2321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3325: pop
    //   3326: aload 42
    //   3328: ldc_w 2323
    //   3331: lload 30
    //   3333: invokestatic 465	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   3336: invokevirtual 2321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3339: pop
    //   3340: aload 42
    //   3342: ldc_w 2325
    //   3345: lload 32
    //   3347: invokestatic 465	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   3350: invokevirtual 2321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3353: pop
    //   3354: aload 42
    //   3356: ldc_w 2327
    //   3359: lload 22
    //   3361: invokestatic 465	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   3364: invokevirtual 2321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3367: pop
    //   3368: aload 42
    //   3370: ldc_w 2328
    //   3373: lload 24
    //   3375: invokestatic 465	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   3378: invokevirtual 2321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3381: pop
    //   3382: aload 42
    //   3384: ldc_w 2330
    //   3387: lload 26
    //   3389: invokestatic 465	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   3392: invokevirtual 2321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3395: pop
    //   3396: aload_0
    //   3397: getfield 216	com/tencent/mobileqq/app/MessageHandler:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3400: invokevirtual 220	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   3403: astore 43
    //   3405: invokestatic 1683	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   3408: invokestatic 2335	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   3411: aload 43
    //   3413: ldc_w 2337
    //   3416: iconst_0
    //   3417: lconst_0
    //   3418: lconst_0
    //   3419: aload 42
    //   3421: ldc_w 281
    //   3424: invokevirtual 2340	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   3427: goto -272 -> 3155
    //   3430: aload 49
    //   3432: getfield 2344	tencent/im/msg/im_msg_body$Elem:trans_elem_info	Ltencent/im/msg/im_msg_body$TransElem;
    //   3435: invokevirtual 2347	tencent/im/msg/im_msg_body$TransElem:has	()Z
    //   3438: ifeq +1178 -> 4616
    //   3441: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3444: ifeq +12 -> 3456
    //   3447: aload 45
    //   3449: ldc_w 2349
    //   3452: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3455: pop
    //   3456: aload 49
    //   3458: getfield 2344	tencent/im/msg/im_msg_body$Elem:trans_elem_info	Ltencent/im/msg/im_msg_body$TransElem;
    //   3461: invokevirtual 2350	tencent/im/msg/im_msg_body$TransElem:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3464: checkcast 2346	tencent/im/msg/im_msg_body$TransElem
    //   3467: astore 42
    //   3469: aload 42
    //   3471: getfield 2353	tencent/im/msg/im_msg_body$TransElem:elem_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3474: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3477: istore 12
    //   3479: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3482: ifeq +23 -> 3505
    //   3485: aload 45
    //   3487: ldc_w 2355
    //   3490: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3493: iload 12
    //   3495: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3498: ldc_w 1431
    //   3501: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3504: pop
    //   3505: aload 47
    //   3507: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   3510: ifle +60 -> 3570
    //   3513: iload 12
    //   3515: iconst_3
    //   3516: if_icmpeq +54 -> 3570
    //   3519: sipush -1000
    //   3522: invokestatic 399	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3525: checkcast 1120	com/tencent/mobileqq/data/MessageForText
    //   3528: astore 43
    //   3530: aload 43
    //   3532: sipush -1000
    //   3535: putfield 1848	com/tencent/mobileqq/data/MessageForText:msgtype	I
    //   3538: aload 43
    //   3540: aload 47
    //   3542: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3545: putfield 1121	com/tencent/mobileqq/data/MessageForText:msg	Ljava/lang/String;
    //   3548: aload 46
    //   3550: aload 43
    //   3552: invokeinterface 375 2 0
    //   3557: pop
    //   3558: aload 47
    //   3560: iconst_0
    //   3561: aload 47
    //   3563: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   3566: invokevirtual 126	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   3569: pop
    //   3570: aload 42
    //   3572: getfield 2358	tencent/im/msg/im_msg_body$TransElem:elem_value	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3575: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3578: invokevirtual 257	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   3581: astore 43
    //   3583: aload 43
    //   3585: ifnull +9 -> 3594
    //   3588: aload 43
    //   3590: arraylength
    //   3591: ifne +75 -> 3666
    //   3594: aload 45
    //   3596: ldc_w 2360
    //   3599: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3602: pop
    //   3603: iload 9
    //   3605: istore 12
    //   3607: aload 41
    //   3609: astore 42
    //   3611: aload 38
    //   3613: astore 43
    //   3615: iload 10
    //   3617: istore 13
    //   3619: iload 11
    //   3621: istore 14
    //   3623: aload 39
    //   3625: astore 44
    //   3627: aload 40
    //   3629: astore 41
    //   3631: iload 8
    //   3633: istore 11
    //   3635: iload 7
    //   3637: istore 9
    //   3639: iload 12
    //   3641: istore 10
    //   3643: aload 42
    //   3645: astore 38
    //   3647: aload 43
    //   3649: astore 39
    //   3651: iload 13
    //   3653: istore 7
    //   3655: iload 14
    //   3657: istore 8
    //   3659: aload 44
    //   3661: astore 40
    //   3663: goto -3236 -> 427
    //   3666: iload 12
    //   3668: lookupswitch	default:+36->3704, 3:+75->3743, 16:+113->3781, 24:+480->4148
    //   3705: iconst_3
    //   3706: istore 16
    //   3708: aload 38
    //   3710: astore 42
    //   3712: iload 9
    //   3714: istore 6
    //   3716: aload 42
    //   3718: astore 38
    //   3720: iload 10
    //   3722: istore 12
    //   3724: iload 7
    //   3726: istore 9
    //   3728: iload 6
    //   3730: istore 10
    //   3732: iload 16
    //   3734: istore 6
    //   3736: iload 12
    //   3738: istore 7
    //   3740: goto -1913 -> 1827
    //   3743: aload 38
    //   3745: astore 42
    //   3747: iload 6
    //   3749: istore 16
    //   3751: iload 6
    //   3753: ifne -41 -> 3712
    //   3756: aload 47
    //   3758: invokestatic 1683	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   3761: ldc_w 2236
    //   3764: invokevirtual 1690	android/content/Context:getString	(I)Ljava/lang/String;
    //   3767: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3770: pop
    //   3771: iconst_1
    //   3772: istore 16
    //   3774: aload 38
    //   3776: astore 42
    //   3778: goto -66 -> 3712
    //   3781: aload 38
    //   3783: astore 42
    //   3785: iload 6
    //   3787: istore 16
    //   3789: aload 43
    //   3791: iconst_0
    //   3792: baload
    //   3793: iconst_1
    //   3794: if_icmpne -82 -> 3712
    //   3797: aload 43
    //   3799: iconst_1
    //   3800: invokestatic 313	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI)S
    //   3803: istore 12
    //   3805: aload 43
    //   3807: iconst_3
    //   3808: baload
    //   3809: istore 13
    //   3811: iload 12
    //   3813: iconst_1
    //   3814: isub
    //   3815: newarray byte
    //   3817: astore 42
    //   3819: aload 42
    //   3821: iconst_0
    //   3822: aload 43
    //   3824: iconst_4
    //   3825: iload 12
    //   3827: iconst_1
    //   3828: isub
    //   3829: invokestatic 316	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI[BII)V
    //   3832: aload 42
    //   3834: astore 44
    //   3836: iload 13
    //   3838: iconst_1
    //   3839: if_icmpne +10 -> 3849
    //   3842: aload 42
    //   3844: invokestatic 2363	com/tencent/mobileqq/service/message/MessageProtoCodec:a	([B)[B
    //   3847: astore 44
    //   3849: aload 38
    //   3851: astore 42
    //   3853: aload 44
    //   3855: ifnull +193 -> 4048
    //   3858: aload 38
    //   3860: astore 43
    //   3862: aload 38
    //   3864: astore 42
    //   3866: aload 44
    //   3868: arraylength
    //   3869: ifle +179 -> 4048
    //   3872: aload 38
    //   3874: astore 43
    //   3876: new 94	java/lang/String
    //   3879: dup
    //   3880: aload 44
    //   3882: ldc_w 2117
    //   3885: invokespecial 2120	java/lang/String:<init>	([BLjava/lang/String;)V
    //   3888: astore 42
    //   3890: aload 38
    //   3892: astore 43
    //   3894: aload 47
    //   3896: aload 42
    //   3898: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3901: pop
    //   3902: aload 38
    //   3904: astore 43
    //   3906: aload 42
    //   3908: invokestatic 2364	com/tencent/mobileqq/service/message/MessageProtoCodec:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/PAMessage;
    //   3911: astore 38
    //   3913: aload 38
    //   3915: astore 42
    //   3917: aload 38
    //   3919: ifnull +129 -> 4048
    //   3922: aload 38
    //   3924: astore 43
    //   3926: aload 48
    //   3928: invokeinterface 59 1 0
    //   3933: astore 44
    //   3935: aload 38
    //   3937: astore 43
    //   3939: aload 38
    //   3941: astore 42
    //   3943: aload 44
    //   3945: invokeinterface 64 1 0
    //   3950: ifeq +98 -> 4048
    //   3953: aload 38
    //   3955: astore 43
    //   3957: aload 44
    //   3959: invokeinterface 68 1 0
    //   3964: checkcast 70	tencent/im/msg/im_msg_body$Elem
    //   3967: astore 42
    //   3969: aload 38
    //   3971: astore 43
    //   3973: aload 42
    //   3975: getfield 74	tencent/im/msg/im_msg_body$Elem:elem_flags2	Ltencent/im/msg/im_msg_body$ElemFlags2;
    //   3978: invokevirtual 77	tencent/im/msg/im_msg_body$ElemFlags2:has	()Z
    //   3981: ifeq -46 -> 3935
    //   3984: aload 38
    //   3986: astore 43
    //   3988: aload 42
    //   3990: getfield 74	tencent/im/msg/im_msg_body$Elem:elem_flags2	Ltencent/im/msg/im_msg_body$ElemFlags2;
    //   3993: invokevirtual 78	tencent/im/msg/im_msg_body$ElemFlags2:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3996: checkcast 76	tencent/im/msg/im_msg_body$ElemFlags2
    //   3999: getfield 2367	tencent/im/msg/im_msg_body$ElemFlags2:uint64_msg_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   4002: invokevirtual 2105	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   4005: ifeq -70 -> 3935
    //   4008: aload 38
    //   4010: astore 43
    //   4012: aload 38
    //   4014: aload 42
    //   4016: getfield 74	tencent/im/msg/im_msg_body$Elem:elem_flags2	Ltencent/im/msg/im_msg_body$ElemFlags2;
    //   4019: invokevirtual 78	tencent/im/msg/im_msg_body$ElemFlags2:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4022: checkcast 76	tencent/im/msg/im_msg_body$ElemFlags2
    //   4025: getfield 2367	tencent/im/msg/im_msg_body$ElemFlags2:uint64_msg_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   4028: invokevirtual 245	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   4031: putfield 2372	com/tencent/mobileqq/data/PAMessage:mMsgId	J
    //   4034: goto -99 -> 3935
    //   4037: astore 38
    //   4039: aload 38
    //   4041: invokevirtual 2135	java/lang/Exception:printStackTrace	()V
    //   4044: aload 43
    //   4046: astore 42
    //   4048: aload 42
    //   4050: ifnull +59 -> 4109
    //   4053: sipush -3006
    //   4056: invokestatic 399	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   4059: checkcast 2124	com/tencent/mobileqq/data/MessageForPubAccount
    //   4062: astore 38
    //   4064: aload 38
    //   4066: sipush -3006
    //   4069: putfield 2125	com/tencent/mobileqq/data/MessageForPubAccount:msgtype	I
    //   4072: aload 38
    //   4074: aload 47
    //   4076: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4079: putfield 2126	com/tencent/mobileqq/data/MessageForPubAccount:msg	Ljava/lang/String;
    //   4082: aload 38
    //   4084: aload 42
    //   4086: putfield 2130	com/tencent/mobileqq/data/MessageForPubAccount:mPAMessage	Lcom/tencent/mobileqq/data/PAMessage;
    //   4089: aload 38
    //   4091: aload 42
    //   4093: invokestatic 2133	com/tencent/biz/pubaccount/util/PAMessageUtil:a	(Lcom/tencent/mobileqq/data/PAMessage;)[B
    //   4096: putfield 2134	com/tencent/mobileqq/data/MessageForPubAccount:msgData	[B
    //   4099: aload 46
    //   4101: aload 38
    //   4103: invokeinterface 375 2 0
    //   4108: pop
    //   4109: aload 47
    //   4111: iconst_0
    //   4112: aload 47
    //   4114: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   4117: invokevirtual 126	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   4120: pop
    //   4121: iload 6
    //   4123: istore 16
    //   4125: goto -413 -> 3712
    //   4128: astore 43
    //   4130: aload 43
    //   4132: invokevirtual 2135	java/lang/Exception:printStackTrace	()V
    //   4135: goto -46 -> 4089
    //   4138: astore 43
    //   4140: aload 43
    //   4142: invokevirtual 2135	java/lang/Exception:printStackTrace	()V
    //   4145: goto -46 -> 4099
    //   4148: aload 42
    //   4150: getfield 2358	tencent/im/msg/im_msg_body$TransElem:elem_value	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4153: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4156: invokevirtual 1753	com/tencent/mobileqq/pb/ByteStringMicro:size	()I
    //   4159: istore 14
    //   4161: iconst_0
    //   4162: istore 13
    //   4164: iconst_0
    //   4165: istore 12
    //   4167: aload 38
    //   4169: astore 42
    //   4171: iload 6
    //   4173: istore 16
    //   4175: iload 14
    //   4177: iconst_3
    //   4178: if_icmple -466 -> 3712
    //   4181: iload 13
    //   4183: iconst_1
    //   4184: iadd
    //   4185: istore 15
    //   4187: aload 38
    //   4189: astore 42
    //   4191: iload 6
    //   4193: istore 16
    //   4195: iload 13
    //   4197: bipush 100
    //   4199: if_icmpgt -487 -> 3712
    //   4202: aload 43
    //   4204: iload 12
    //   4206: baload
    //   4207: istore 16
    //   4209: aload 43
    //   4211: iload 12
    //   4213: iconst_1
    //   4214: iadd
    //   4215: invokestatic 313	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI)S
    //   4218: istore 18
    //   4220: iload 14
    //   4222: iload 18
    //   4224: iconst_3
    //   4225: iadd
    //   4226: isub
    //   4227: istore 13
    //   4229: iload 18
    //   4231: iconst_3
    //   4232: iadd
    //   4233: iload 12
    //   4235: iadd
    //   4236: istore 14
    //   4238: iload 16
    //   4240: iconst_1
    //   4241: if_icmpeq +18 -> 4259
    //   4244: iload 14
    //   4246: istore 12
    //   4248: iload 13
    //   4250: istore 14
    //   4252: iload 15
    //   4254: istore 13
    //   4256: goto -89 -> 4167
    //   4259: iload 18
    //   4261: newarray byte
    //   4263: astore 42
    //   4265: aload 42
    //   4267: iconst_0
    //   4268: aload 43
    //   4270: iload 12
    //   4272: iconst_3
    //   4273: iadd
    //   4274: iload 18
    //   4276: invokestatic 316	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI[BII)V
    //   4279: new 2374	tencent/im/msg/obj_msg$ObjMsg
    //   4282: dup
    //   4283: invokespecial 2375	tencent/im/msg/obj_msg$ObjMsg:<init>	()V
    //   4286: astore 44
    //   4288: aload 44
    //   4290: aload 42
    //   4292: invokevirtual 2376	tencent/im/msg/obj_msg$ObjMsg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4295: checkcast 2374	tencent/im/msg/obj_msg$ObjMsg
    //   4298: astore 42
    //   4300: aload 42
    //   4302: getfield 2379	tencent/im/msg/obj_msg$ObjMsg:uint32_msg_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4305: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4308: i2l
    //   4309: ldc2_w 2380
    //   4312: lcmp
    //   4313: ifeq +35 -> 4348
    //   4316: iload 14
    //   4318: istore 12
    //   4320: iload 13
    //   4322: istore 14
    //   4324: iload 15
    //   4326: istore 13
    //   4328: goto -161 -> 4167
    //   4331: astore 42
    //   4333: iload 14
    //   4335: istore 12
    //   4337: iload 13
    //   4339: istore 14
    //   4341: iload 15
    //   4343: istore 13
    //   4345: goto -178 -> 4167
    //   4348: new 2383	com/tencent/mobileqq/data/TroopFileData
    //   4351: dup
    //   4352: invokespecial 2384	com/tencent/mobileqq/data/TroopFileData:<init>	()V
    //   4355: astore 43
    //   4357: aload 43
    //   4359: new 94	java/lang/String
    //   4362: dup
    //   4363: aload 42
    //   4365: getfield 2387	tencent/im/msg/obj_msg$ObjMsg:msg_content_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4368: iconst_0
    //   4369: invokevirtual 2390	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4372: checkcast 2392	tencent/im/msg/obj_msg$MsgContentInfo
    //   4375: getfield 2396	tencent/im/msg/obj_msg$MsgContentInfo:msg_file	Ltencent/im/msg/obj_msg$MsgContentInfo$MsgFile;
    //   4378: getfield 2401	tencent/im/msg/obj_msg$MsgContentInfo$MsgFile:bytes_file_path	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4381: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4384: invokevirtual 257	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   4387: invokespecial 2403	java/lang/String:<init>	([B)V
    //   4390: putfield 2406	com/tencent/mobileqq/data/TroopFileData:fileUrl	Ljava/lang/String;
    //   4393: aload 43
    //   4395: aload 42
    //   4397: getfield 2387	tencent/im/msg/obj_msg$ObjMsg:msg_content_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4400: iconst_0
    //   4401: invokevirtual 2390	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4404: checkcast 2392	tencent/im/msg/obj_msg$MsgContentInfo
    //   4407: getfield 2396	tencent/im/msg/obj_msg$MsgContentInfo:msg_file	Ltencent/im/msg/obj_msg$MsgContentInfo$MsgFile;
    //   4410: getfield 2409	tencent/im/msg/obj_msg$MsgContentInfo$MsgFile:uint32_bus_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4413: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4416: putfield 2412	com/tencent/mobileqq/data/TroopFileData:bisID	I
    //   4419: aload 43
    //   4421: aload 42
    //   4423: getfield 2387	tencent/im/msg/obj_msg$ObjMsg:msg_content_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4426: iconst_0
    //   4427: invokevirtual 2390	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4430: checkcast 2392	tencent/im/msg/obj_msg$MsgContentInfo
    //   4433: getfield 2396	tencent/im/msg/obj_msg$MsgContentInfo:msg_file	Ltencent/im/msg/obj_msg$MsgContentInfo$MsgFile;
    //   4436: getfield 2415	tencent/im/msg/obj_msg$MsgContentInfo$MsgFile:str_file_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   4439: invokevirtual 270	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   4442: putfield 2418	com/tencent/mobileqq/data/TroopFileData:fileName	Ljava/lang/String;
    //   4445: aload 43
    //   4447: aload 42
    //   4449: getfield 2387	tencent/im/msg/obj_msg$ObjMsg:msg_content_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4452: iconst_0
    //   4453: invokevirtual 2390	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4456: checkcast 2392	tencent/im/msg/obj_msg$MsgContentInfo
    //   4459: getfield 2396	tencent/im/msg/obj_msg$MsgContentInfo:msg_file	Ltencent/im/msg/obj_msg$MsgContentInfo$MsgFile;
    //   4462: getfield 2419	tencent/im/msg/obj_msg$MsgContentInfo$MsgFile:uint64_file_size	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   4465: invokevirtual 245	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   4468: putfield 2422	com/tencent/mobileqq/data/TroopFileData:lfileSize	J
    //   4471: aload 43
    //   4473: new 94	java/lang/String
    //   4476: dup
    //   4477: aload 42
    //   4479: getfield 2425	tencent/im/msg/obj_msg$ObjMsg:bytes_title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4482: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4485: invokevirtual 257	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   4488: invokespecial 2403	java/lang/String:<init>	([B)V
    //   4491: putfield 2428	com/tencent/mobileqq/data/TroopFileData:dspFileName	Ljava/lang/String;
    //   4494: aload 43
    //   4496: new 94	java/lang/String
    //   4499: dup
    //   4500: aload 42
    //   4502: getfield 2431	tencent/im/msg/obj_msg$ObjMsg:rpt_bytes_abstact	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4505: iconst_0
    //   4506: invokevirtual 2432	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   4509: checkcast 253	com/tencent/mobileqq/pb/ByteStringMicro
    //   4512: invokevirtual 257	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   4515: invokespecial 2403	java/lang/String:<init>	([B)V
    //   4518: putfield 2435	com/tencent/mobileqq/data/TroopFileData:dspFileSize	Ljava/lang/String;
    //   4521: aload 47
    //   4523: ldc_w 2437
    //   4526: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4529: pop
    //   4530: sipush -2017
    //   4533: invokestatic 399	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   4536: checkcast 2439	com/tencent/mobileqq/data/MessageForTroopFile
    //   4539: astore 42
    //   4541: aload 42
    //   4543: sipush -2017
    //   4546: putfield 2440	com/tencent/mobileqq/data/MessageForTroopFile:msgtype	I
    //   4549: aload 42
    //   4551: aload 47
    //   4553: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4556: putfield 2441	com/tencent/mobileqq/data/MessageForTroopFile:msg	Ljava/lang/String;
    //   4559: aload 42
    //   4561: aload 43
    //   4563: invokestatic 2446	com/tencent/mobileqq/app/utils/MessagePkgUtils:a	(Ljava/io/Serializable;)[B
    //   4566: putfield 2447	com/tencent/mobileqq/data/MessageForTroopFile:msgData	[B
    //   4569: aload 42
    //   4571: invokevirtual 2448	com/tencent/mobileqq/data/MessageForTroopFile:parse	()V
    //   4574: aload_1
    //   4575: aload 42
    //   4577: invokeinterface 375 2 0
    //   4582: pop
    //   4583: aload 47
    //   4585: iconst_0
    //   4586: aload 47
    //   4588: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   4591: invokevirtual 126	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   4594: pop
    //   4595: aload 38
    //   4597: astore 42
    //   4599: iload 6
    //   4601: istore 16
    //   4603: goto -891 -> 3712
    //   4606: astore 43
    //   4608: aload 43
    //   4610: invokevirtual 2135	java/lang/Exception:printStackTrace	()V
    //   4613: goto -44 -> 4569
    //   4616: aload 49
    //   4618: getfield 1197	tencent/im/msg/im_msg_body$Elem:market_face	Ltencent/im/msg/im_msg_body$MarketFace;
    //   4621: invokevirtual 2449	tencent/im/msg/im_msg_body$MarketFace:has	()Z
    //   4624: ifeq +432 -> 5056
    //   4627: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4630: ifeq +12 -> 4642
    //   4633: aload 45
    //   4635: ldc_w 2451
    //   4638: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4641: pop
    //   4642: aload 47
    //   4644: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   4647: ifle +54 -> 4701
    //   4650: sipush -1000
    //   4653: invokestatic 399	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   4656: checkcast 1120	com/tencent/mobileqq/data/MessageForText
    //   4659: astore 42
    //   4661: aload 42
    //   4663: sipush -1000
    //   4666: putfield 1848	com/tencent/mobileqq/data/MessageForText:msgtype	I
    //   4669: aload 42
    //   4671: aload 47
    //   4673: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4676: putfield 1121	com/tencent/mobileqq/data/MessageForText:msg	Ljava/lang/String;
    //   4679: aload 46
    //   4681: aload 42
    //   4683: invokeinterface 375 2 0
    //   4688: pop
    //   4689: aload 47
    //   4691: iconst_0
    //   4692: aload 47
    //   4694: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   4697: invokevirtual 126	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   4700: pop
    //   4701: aload 49
    //   4703: getfield 1197	tencent/im/msg/im_msg_body$Elem:market_face	Ltencent/im/msg/im_msg_body$MarketFace;
    //   4706: invokevirtual 2452	tencent/im/msg/im_msg_body$MarketFace:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4709: checkcast 1129	tencent/im/msg/im_msg_body$MarketFace
    //   4712: astore 42
    //   4714: aload 42
    //   4716: ifnull +312 -> 5028
    //   4719: new 1038	com/tencent/qqlite/data/MarkFaceMessage
    //   4722: dup
    //   4723: invokespecial 2453	com/tencent/qqlite/data/MarkFaceMessage:<init>	()V
    //   4726: astore 39
    //   4728: aload 39
    //   4730: aload 42
    //   4732: getfield 1148	tencent/im/msg/im_msg_body$MarketFace:uint32_face_info	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4735: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4738: putfield 1151	com/tencent/qqlite/data/MarkFaceMessage:cFaceInfo	I
    //   4741: aload 39
    //   4743: iload 17
    //   4745: i2l
    //   4746: putfield 2455	com/tencent/qqlite/data/MarkFaceMessage:index	J
    //   4749: aload 39
    //   4751: aload 42
    //   4753: getfield 1160	tencent/im/msg/im_msg_body$MarketFace:uint32_sub_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4756: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4759: putfield 1163	com/tencent/qqlite/data/MarkFaceMessage:cSubType	I
    //   4762: aload 39
    //   4764: aload 42
    //   4766: getfield 1154	tencent/im/msg/im_msg_body$MarketFace:uint32_item_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4769: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4772: putfield 1157	com/tencent/qqlite/data/MarkFaceMessage:dwMSGItemType	I
    //   4775: aload 39
    //   4777: aload 42
    //   4779: getfield 1166	tencent/im/msg/im_msg_body$MarketFace:uint32_tab_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4782: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4785: putfield 1169	com/tencent/qqlite/data/MarkFaceMessage:dwTabID	I
    //   4788: aload 39
    //   4790: aload 42
    //   4792: getfield 1145	tencent/im/msg/im_msg_body$MarketFace:bytes_key	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4795: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4798: invokevirtual 257	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   4801: putfield 1142	com/tencent/qqlite/data/MarkFaceMessage:sbfKey	[B
    //   4804: aload 39
    //   4806: aload 42
    //   4808: getfield 1136	tencent/im/msg/im_msg_body$MarketFace:bytes_face_id	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4811: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4814: invokevirtual 257	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   4817: putfield 1133	com/tencent/qqlite/data/MarkFaceMessage:sbufID	[B
    //   4820: aload 39
    //   4822: aload 42
    //   4824: getfield 1172	tencent/im/msg/im_msg_body$MarketFace:uint32_media_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4827: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4830: putfield 1175	com/tencent/qqlite/data/MarkFaceMessage:mediaType	I
    //   4833: aload 39
    //   4835: aload 42
    //   4837: getfield 1178	tencent/im/msg/im_msg_body$MarketFace:uint32_image_width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4840: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4843: putfield 1181	com/tencent/qqlite/data/MarkFaceMessage:imageWidth	I
    //   4846: aload 39
    //   4848: aload 42
    //   4850: getfield 1184	tencent/im/msg/im_msg_body$MarketFace:uint32_image_height	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4853: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4856: putfield 1187	com/tencent/qqlite/data/MarkFaceMessage:imageHeight	I
    //   4859: aload 39
    //   4861: aload 42
    //   4863: getfield 1193	tencent/im/msg/im_msg_body$MarketFace:bytes_mobileparam	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4866: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4869: invokevirtual 257	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   4872: putfield 1190	com/tencent/qqlite/data/MarkFaceMessage:mobileparam	[B
    //   4875: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4878: ifeq +20 -> 4898
    //   4881: aload 45
    //   4883: ldc_w 2457
    //   4886: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4889: aload 39
    //   4891: getfield 1175	com/tencent/qqlite/data/MarkFaceMessage:mediaType	I
    //   4894: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4897: pop
    //   4898: aload 47
    //   4900: ldc_w 2459
    //   4903: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4906: pop
    //   4907: sipush -2007
    //   4910: invokestatic 399	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   4913: checkcast 1030	com/tencent/mobileqq/data/MessageForMarketFace
    //   4916: astore 42
    //   4918: aload 42
    //   4920: sipush -2007
    //   4923: putfield 2460	com/tencent/mobileqq/data/MessageForMarketFace:msgtype	I
    //   4926: aload 42
    //   4928: aload 47
    //   4930: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4933: putfield 2461	com/tencent/mobileqq/data/MessageForMarketFace:msg	Ljava/lang/String;
    //   4936: aload 42
    //   4938: aload 39
    //   4940: putfield 1034	com/tencent/mobileqq/data/MessageForMarketFace:mMarkFaceMessage	Lcom/tencent/qqlite/data/MarkFaceMessage;
    //   4943: aload 39
    //   4945: getfield 1190	com/tencent/qqlite/data/MarkFaceMessage:mobileparam	[B
    //   4948: ifnull +48 -> 4996
    //   4951: aload 39
    //   4953: getfield 1190	com/tencent/qqlite/data/MarkFaceMessage:mobileparam	[B
    //   4956: arraylength
    //   4957: ifle +39 -> 4996
    //   4960: aload_0
    //   4961: getfield 216	com/tencent/mobileqq/app/MessageHandler:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4964: ldc_w 1570
    //   4967: ldc_w 281
    //   4970: ldc_w 281
    //   4973: ldc_w 2463
    //   4976: ldc_w 2465
    //   4979: iconst_0
    //   4980: iconst_0
    //   4981: ldc_w 281
    //   4984: ldc_w 281
    //   4987: ldc_w 281
    //   4990: ldc_w 281
    //   4993: invokestatic 1579	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   4996: aload 42
    //   4998: aload 39
    //   5000: invokestatic 2446	com/tencent/mobileqq/app/utils/MessagePkgUtils:a	(Ljava/io/Serializable;)[B
    //   5003: putfield 2466	com/tencent/mobileqq/data/MessageForMarketFace:msgData	[B
    //   5006: aload 46
    //   5008: aload 42
    //   5010: invokeinterface 375 2 0
    //   5015: pop
    //   5016: aload 47
    //   5018: iconst_0
    //   5019: aload 47
    //   5021: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   5024: invokevirtual 126	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   5027: pop
    //   5028: iload 9
    //   5030: istore 10
    //   5032: iconst_1
    //   5033: istore 12
    //   5035: iload 7
    //   5037: istore 9
    //   5039: iload 12
    //   5041: istore 7
    //   5043: goto -3216 -> 1827
    //   5046: astore 43
    //   5048: aload 43
    //   5050: invokevirtual 2135	java/lang/Exception:printStackTrace	()V
    //   5053: goto -47 -> 5006
    //   5056: aload 49
    //   5058: getfield 1765	tencent/im/msg/im_msg_body$Elem:custom_face	Ltencent/im/msg/im_msg_body$CustomFace;
    //   5061: invokevirtual 1768	tencent/im/msg/im_msg_body$CustomFace:has	()Z
    //   5064: ifeq +1032 -> 6096
    //   5067: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5070: ifeq +22 -> 5092
    //   5073: aload 45
    //   5075: ldc_w 2468
    //   5078: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5081: iload_3
    //   5082: invokevirtual 202	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5085: ldc_w 1431
    //   5088: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5091: pop
    //   5092: iload_3
    //   5093: ifeq +270 -> 5363
    //   5096: aload 47
    //   5098: invokestatic 1683	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   5101: ldc_w 2236
    //   5104: invokevirtual 1690	android/content/Context:getString	(I)Ljava/lang/String;
    //   5107: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5110: pop
    //   5111: aload_2
    //   5112: getfield 234	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   5115: invokevirtual 237	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   5118: checkcast 236	msf/msgcomm/msg_comm$MsgHead
    //   5121: astore 42
    //   5123: aload 42
    //   5125: getfield 294	msf/msgcomm/msg_comm$MsgHead:msg_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5128: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5131: i2l
    //   5132: lstore 22
    //   5134: aload 42
    //   5136: getfield 1308	msf/msgcomm/msg_comm$MsgHead:msg_uid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   5139: invokevirtual 245	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   5142: lstore 24
    //   5144: aload 42
    //   5146: getfield 291	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5149: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5152: i2l
    //   5153: lstore 26
    //   5155: aload 42
    //   5157: getfield 241	msf/msgcomm/msg_comm$MsgHead:from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   5160: invokevirtual 245	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   5163: lstore 30
    //   5165: aload 42
    //   5167: getfield 419	msf/msgcomm/msg_comm$MsgHead:to_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   5170: invokevirtual 245	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   5173: lstore 32
    //   5175: new 2312	java/util/HashMap
    //   5178: dup
    //   5179: invokespecial 2313	java/util/HashMap:<init>	()V
    //   5182: astore 42
    //   5184: aload 42
    //   5186: ldc_w 2315
    //   5189: sipush 10001
    //   5192: invokestatic 2317	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   5195: invokevirtual 2321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   5198: pop
    //   5199: aload 42
    //   5201: ldc_w 2323
    //   5204: lload 30
    //   5206: invokestatic 465	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   5209: invokevirtual 2321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   5212: pop
    //   5213: aload 42
    //   5215: ldc_w 2325
    //   5218: lload 32
    //   5220: invokestatic 465	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   5223: invokevirtual 2321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   5226: pop
    //   5227: aload 42
    //   5229: ldc_w 2327
    //   5232: lload 22
    //   5234: invokestatic 465	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   5237: invokevirtual 2321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   5240: pop
    //   5241: aload 42
    //   5243: ldc_w 2328
    //   5246: lload 24
    //   5248: invokestatic 465	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   5251: invokevirtual 2321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   5254: pop
    //   5255: aload 42
    //   5257: ldc_w 2330
    //   5260: lload 26
    //   5262: invokestatic 465	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   5265: invokevirtual 2321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   5268: pop
    //   5269: aload_0
    //   5270: getfield 216	com/tencent/mobileqq/app/MessageHandler:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5273: invokevirtual 220	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   5276: astore 43
    //   5278: invokestatic 1683	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   5281: invokestatic 2335	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   5284: aload 43
    //   5286: ldc_w 2337
    //   5289: iconst_0
    //   5290: lconst_0
    //   5291: lconst_0
    //   5292: aload 42
    //   5294: ldc_w 281
    //   5297: invokevirtual 2340	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   5300: iload 9
    //   5302: istore 12
    //   5304: aload 41
    //   5306: astore 42
    //   5308: aload 38
    //   5310: astore 43
    //   5312: iload 10
    //   5314: istore 13
    //   5316: iload 11
    //   5318: istore 14
    //   5320: aload 39
    //   5322: astore 44
    //   5324: aload 40
    //   5326: astore 41
    //   5328: iload 8
    //   5330: istore 11
    //   5332: iload 7
    //   5334: istore 9
    //   5336: iload 12
    //   5338: istore 10
    //   5340: aload 42
    //   5342: astore 38
    //   5344: aload 43
    //   5346: astore 39
    //   5348: iload 13
    //   5350: istore 7
    //   5352: iload 14
    //   5354: istore 8
    //   5356: aload 44
    //   5358: astore 40
    //   5360: goto -4933 -> 427
    //   5363: aload 47
    //   5365: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   5368: ifle +54 -> 5422
    //   5371: sipush -1000
    //   5374: invokestatic 399	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   5377: checkcast 1120	com/tencent/mobileqq/data/MessageForText
    //   5380: astore 42
    //   5382: aload 42
    //   5384: sipush -1000
    //   5387: putfield 1848	com/tencent/mobileqq/data/MessageForText:msgtype	I
    //   5390: aload 42
    //   5392: aload 47
    //   5394: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5397: putfield 1121	com/tencent/mobileqq/data/MessageForText:msg	Ljava/lang/String;
    //   5400: aload 46
    //   5402: aload 42
    //   5404: invokeinterface 375 2 0
    //   5409: pop
    //   5410: aload 47
    //   5412: iconst_0
    //   5413: aload 47
    //   5415: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   5418: invokevirtual 126	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   5421: pop
    //   5422: aload 49
    //   5424: getfield 1765	tencent/im/msg/im_msg_body$Elem:custom_face	Ltencent/im/msg/im_msg_body$CustomFace;
    //   5427: invokevirtual 1769	tencent/im/msg/im_msg_body$CustomFace:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   5430: checkcast 1767	tencent/im/msg/im_msg_body$CustomFace
    //   5433: astore 52
    //   5435: aload 52
    //   5437: getfield 1772	tencent/im/msg/im_msg_body$CustomFace:str_file_path	Lcom/tencent/mobileqq/pb/PBStringField;
    //   5440: invokevirtual 270	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   5443: astore 42
    //   5445: aload 52
    //   5447: getfield 1775	tencent/im/msg/im_msg_body$CustomFace:str_shortcut	Lcom/tencent/mobileqq/pb/PBStringField;
    //   5450: invokevirtual 270	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   5453: pop
    //   5454: aload 52
    //   5456: getfield 1778	tencent/im/msg/im_msg_body$CustomFace:str_big_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   5459: invokevirtual 270	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   5462: astore 43
    //   5464: aload 52
    //   5466: getfield 1781	tencent/im/msg/im_msg_body$CustomFace:str_orig_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   5469: invokevirtual 270	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   5472: astore 44
    //   5474: aload 52
    //   5476: getfield 1784	tencent/im/msg/im_msg_body$CustomFace:str_thumb_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   5479: invokevirtual 270	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   5482: astore 50
    //   5484: aload 52
    //   5486: getfield 2469	tencent/im/msg/im_msg_body$CustomFace:uint32_thumb_width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5489: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5492: istore 12
    //   5494: aload 52
    //   5496: getfield 2470	tencent/im/msg/im_msg_body$CustomFace:uint32_thumb_height	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5499: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5502: istore 13
    //   5504: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5507: ifeq +41 -> 5548
    //   5510: ldc 13
    //   5512: iconst_2
    //   5513: new 91	java/lang/StringBuilder
    //   5516: dup
    //   5517: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   5520: ldc_w 2472
    //   5523: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5526: iload 12
    //   5528: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5531: ldc_w 2254
    //   5534: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5537: iload 13
    //   5539: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5542: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5545: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5548: aload 52
    //   5550: getfield 1787	tencent/im/msg/im_msg_body$CustomFace:uint32_file_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5553: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5556: i2l
    //   5557: lstore 22
    //   5559: aload 52
    //   5561: getfield 1788	tencent/im/msg/im_msg_body$CustomFace:uint32_file_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5564: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5567: i2l
    //   5568: lstore 24
    //   5570: aload 52
    //   5572: getfield 1791	tencent/im/msg/im_msg_body$CustomFace:uint32_server_ip	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5575: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5578: i2l
    //   5579: lstore 24
    //   5581: aload 52
    //   5583: getfield 1794	tencent/im/msg/im_msg_body$CustomFace:uint32_server_port	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5586: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5589: i2l
    //   5590: lstore 24
    //   5592: aload 52
    //   5594: getfield 1797	tencent/im/msg/im_msg_body$CustomFace:uint32_useful	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5597: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5600: i2l
    //   5601: lstore 24
    //   5603: aload 52
    //   5605: getfield 2475	tencent/im/msg/im_msg_body$CustomFace:uint32_size	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5608: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5611: i2l
    //   5612: ldc2_w 9
    //   5615: land
    //   5616: lstore 24
    //   5618: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5621: ifeq +30 -> 5651
    //   5624: ldc 13
    //   5626: iconst_2
    //   5627: new 91	java/lang/StringBuilder
    //   5630: dup
    //   5631: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   5634: ldc_w 2477
    //   5637: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5640: lload 24
    //   5642: invokevirtual 277	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5645: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5648: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5651: aload 52
    //   5653: getfield 1800	tencent/im/msg/im_msg_body$CustomFace:bytes_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5656: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   5659: invokevirtual 257	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   5662: astore 51
    //   5664: aload 52
    //   5666: getfield 1803	tencent/im/msg/im_msg_body$CustomFace:bytes_signature	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5669: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   5672: invokevirtual 257	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   5675: astore 53
    //   5677: aload 52
    //   5679: getfield 1806	tencent/im/msg/im_msg_body$CustomFace:bytes_buffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5682: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   5685: invokevirtual 257	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   5688: pop
    //   5689: aload 52
    //   5691: getfield 1809	tencent/im/msg/im_msg_body$CustomFace:bytes_flag	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5694: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   5697: invokevirtual 257	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   5700: astore 54
    //   5702: aload 52
    //   5704: getfield 2478	tencent/im/msg/im_msg_body$CustomFace:uint32_width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5707: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5710: i2l
    //   5711: ldc2_w 9
    //   5714: land
    //   5715: l2i
    //   5716: istore 14
    //   5718: aload 52
    //   5720: getfield 2479	tencent/im/msg/im_msg_body$CustomFace:uint32_height	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5723: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5726: i2l
    //   5727: ldc2_w 9
    //   5730: land
    //   5731: l2i
    //   5732: istore 15
    //   5734: aload 51
    //   5736: invokestatic 716	com/tencent/mobileqq/utils/HexUtil:a	([B)Ljava/lang/String;
    //   5739: astore 51
    //   5741: aload 53
    //   5743: invokestatic 716	com/tencent/mobileqq/utils/HexUtil:a	([B)Ljava/lang/String;
    //   5746: pop
    //   5747: aload 54
    //   5749: invokestatic 716	com/tencent/mobileqq/utils/HexUtil:a	([B)Ljava/lang/String;
    //   5752: pop
    //   5753: aload 52
    //   5755: getfield 2482	tencent/im/msg/im_msg_body$CustomFace:uint32_origin	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5758: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5761: istore 16
    //   5763: aload 42
    //   5765: lconst_0
    //   5766: iconst_1
    //   5767: iconst_0
    //   5768: aload 42
    //   5770: aload 51
    //   5772: ldc_w 2274
    //   5775: aload 50
    //   5777: aload 43
    //   5779: aload 44
    //   5781: iload 16
    //   5783: iconst_0
    //   5784: invokestatic 2485	com/tencent/mobileqq/transfile/TranDbRecord$PicDbRecord:a	(Ljava/lang/String;JIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)Ljava/lang/String;
    //   5787: astore 53
    //   5789: new 377	localpb/richMsg/RichMsg$PicRec
    //   5792: dup
    //   5793: invokespecial 378	localpb/richMsg/RichMsg$PicRec:<init>	()V
    //   5796: astore 52
    //   5798: aload 52
    //   5800: getfield 1452	localpb/richMsg/RichMsg$PicRec:localPath	Lcom/tencent/mobileqq/pb/PBStringField;
    //   5803: aload 42
    //   5805: invokevirtual 371	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   5808: aload 52
    //   5810: getfield 1454	localpb/richMsg/RichMsg$PicRec:size	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   5813: lload 24
    //   5815: invokevirtual 581	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   5818: aload 52
    //   5820: getfield 1457	localpb/richMsg/RichMsg$PicRec:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5823: iconst_1
    //   5824: invokevirtual 173	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   5827: aload 52
    //   5829: getfield 1460	localpb/richMsg/RichMsg$PicRec:isRead	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   5832: iconst_0
    //   5833: invokevirtual 823	com/tencent/mobileqq/pb/PBBoolField:set	(Z)V
    //   5836: aload 52
    //   5838: getfield 1463	localpb/richMsg/RichMsg$PicRec:uuid	Lcom/tencent/mobileqq/pb/PBStringField;
    //   5841: aload 42
    //   5843: invokevirtual 371	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   5846: aload 52
    //   5848: getfield 2294	localpb/richMsg/RichMsg$PicRec:groupFileID	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   5851: lload 22
    //   5853: ldc2_w 9
    //   5856: land
    //   5857: invokevirtual 581	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   5860: aload 52
    //   5862: getfield 2280	localpb/richMsg/RichMsg$PicRec:md5	Lcom/tencent/mobileqq/pb/PBStringField;
    //   5865: aload 51
    //   5867: invokevirtual 371	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   5870: aload 52
    //   5872: getfield 1466	localpb/richMsg/RichMsg$PicRec:serverStorageSource	Lcom/tencent/mobileqq/pb/PBStringField;
    //   5875: ldc_w 2274
    //   5878: invokevirtual 371	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   5881: aload 52
    //   5883: getfield 2283	localpb/richMsg/RichMsg$PicRec:thumbMsgUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   5886: aload 50
    //   5888: invokevirtual 371	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   5891: aload 52
    //   5893: getfield 2284	localpb/richMsg/RichMsg$PicRec:uint32_thumb_width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5896: iload 12
    //   5898: invokevirtual 173	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   5901: aload 52
    //   5903: getfield 2285	localpb/richMsg/RichMsg$PicRec:uint32_thumb_height	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5906: iload 13
    //   5908: invokevirtual 173	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   5911: aload 52
    //   5913: getfield 2288	localpb/richMsg/RichMsg$PicRec:uint32_width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5916: iload 14
    //   5918: invokevirtual 173	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   5921: aload 52
    //   5923: getfield 2291	localpb/richMsg/RichMsg$PicRec:uint32_height	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5926: iload 15
    //   5928: invokevirtual 173	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   5931: aload 52
    //   5933: getfield 2297	localpb/richMsg/RichMsg$PicRec:bigMsgUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   5936: aload 43
    //   5938: invokevirtual 371	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   5941: aload 52
    //   5943: getfield 2300	localpb/richMsg/RichMsg$PicRec:rawMsgUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   5946: aload 44
    //   5948: invokevirtual 371	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   5951: aload 52
    //   5953: getfield 2303	localpb/richMsg/RichMsg$PicRec:fileSizeFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5956: iconst_0
    //   5957: invokevirtual 1475	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   5960: aload 52
    //   5962: getfield 2306	localpb/richMsg/RichMsg$PicRec:uiOperatorFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5965: iconst_0
    //   5966: invokevirtual 1475	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   5969: aload 52
    //   5971: getfield 1472	localpb/richMsg/RichMsg$PicRec:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5974: iconst_5
    //   5975: invokevirtual 1475	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   5978: aload 52
    //   5980: getfield 1478	localpb/richMsg/RichMsg$PicRec:isReport	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5983: iconst_0
    //   5984: invokevirtual 1475	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   5987: aload 52
    //   5989: getfield 2303	localpb/richMsg/RichMsg$PicRec:fileSizeFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5992: iload 16
    //   5994: invokevirtual 1475	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   5997: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6000: ifeq +17 -> 6017
    //   6003: aload 45
    //   6005: ldc_w 1484
    //   6008: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6011: aload 53
    //   6013: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6016: pop
    //   6017: sipush -2000
    //   6020: invokestatic 399	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   6023: checkcast 941	com/tencent/mobileqq/data/MessageForPic
    //   6026: astore 42
    //   6028: aload 42
    //   6030: sipush -2000
    //   6033: putfield 1479	com/tencent/mobileqq/data/MessageForPic:msgtype	I
    //   6036: aload 42
    //   6038: aload 52
    //   6040: invokevirtual 1480	localpb/richMsg/RichMsg$PicRec:toByteArray	()[B
    //   6043: putfield 1481	com/tencent/mobileqq/data/MessageForPic:msgData	[B
    //   6046: aload 42
    //   6048: invokevirtual 1482	com/tencent/mobileqq/data/MessageForPic:parse	()V
    //   6051: aload 46
    //   6053: aload 42
    //   6055: invokeinterface 375 2 0
    //   6060: pop
    //   6061: aload 47
    //   6063: iconst_0
    //   6064: aload 47
    //   6066: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   6069: invokevirtual 126	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   6072: pop
    //   6073: iload 9
    //   6075: istore 12
    //   6077: iload 10
    //   6079: istore 13
    //   6081: iload 7
    //   6083: istore 9
    //   6085: iload 12
    //   6087: istore 10
    //   6089: iload 13
    //   6091: istore 7
    //   6093: goto -4266 -> 1827
    //   6096: aload 49
    //   6098: getfield 997	tencent/im/msg/im_msg_body$Elem:fun_face	Ltencent/im/msg/im_msg_body$FunFace;
    //   6101: invokevirtual 2486	tencent/im/msg/im_msg_body$FunFace:has	()Z
    //   6104: ifeq +45 -> 6149
    //   6107: iload 8
    //   6109: istore 12
    //   6111: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6114: ifeq +1449 -> 7563
    //   6117: aload 45
    //   6119: ldc_w 2488
    //   6122: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6125: pop
    //   6126: iload 9
    //   6128: istore 12
    //   6130: iload 10
    //   6132: istore 13
    //   6134: iload 7
    //   6136: istore 9
    //   6138: iload 12
    //   6140: istore 10
    //   6142: iload 13
    //   6144: istore 7
    //   6146: goto -4319 -> 1827
    //   6149: aload 49
    //   6151: getfield 2492	tencent/im/msg/im_msg_body$Elem:group_file	Ltencent/im/msg/im_msg_body$GroupFile;
    //   6154: invokevirtual 2495	tencent/im/msg/im_msg_body$GroupFile:has	()Z
    //   6157: ifeq +468 -> 6625
    //   6160: lconst_0
    //   6161: lstore 22
    //   6163: aload_2
    //   6164: getfield 234	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   6167: invokevirtual 237	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   6170: checkcast 236	msf/msgcomm/msg_comm$MsgHead
    //   6173: astore 42
    //   6175: aload 42
    //   6177: getfield 2499	msf/msgcomm/msg_comm$MsgHead:discuss_info	Lmsf/msgcomm/msg_comm$DiscussInfo;
    //   6180: invokevirtual 2502	msf/msgcomm/msg_comm$DiscussInfo:has	()Z
    //   6183: ifeq +22 -> 6205
    //   6186: aload 42
    //   6188: getfield 2499	msf/msgcomm/msg_comm$MsgHead:discuss_info	Lmsf/msgcomm/msg_comm$DiscussInfo;
    //   6191: invokevirtual 2503	msf/msgcomm/msg_comm$DiscussInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   6194: checkcast 2501	msf/msgcomm/msg_comm$DiscussInfo
    //   6197: getfield 2506	msf/msgcomm/msg_comm$DiscussInfo:discuss_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   6200: invokevirtual 245	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   6203: lstore 22
    //   6205: aload 42
    //   6207: getfield 241	msf/msgcomm/msg_comm$MsgHead:from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   6210: invokevirtual 245	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   6213: lstore 30
    //   6215: aload 42
    //   6217: getfield 291	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   6220: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   6223: i2l
    //   6224: lstore 34
    //   6226: aload 42
    //   6228: getfield 294	msf/msgcomm/msg_comm$MsgHead:msg_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   6231: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   6234: i2l
    //   6235: lstore 36
    //   6237: aload_0
    //   6238: getfield 216	com/tencent/mobileqq/app/MessageHandler:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6241: invokevirtual 2166	com/tencent/mobileqq/app/QQAppInterface:getLongAccountUin	()J
    //   6244: lstore 32
    //   6246: aload 49
    //   6248: getfield 2492	tencent/im/msg/im_msg_body$Elem:group_file	Ltencent/im/msg/im_msg_body$GroupFile;
    //   6251: invokevirtual 2507	tencent/im/msg/im_msg_body$GroupFile:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   6254: checkcast 2494	tencent/im/msg/im_msg_body$GroupFile
    //   6257: astore 44
    //   6259: aload_0
    //   6260: getfield 216	com/tencent/mobileqq/app/MessageHandler:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6263: sipush 3000
    //   6266: lload 22
    //   6268: invokestatic 465	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   6271: lload 30
    //   6273: invokestatic 465	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   6276: lload 34
    //   6278: lload 36
    //   6280: invokestatic 2512	com/tencent/mobileqq/app/MessageHandlerUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;ILjava/lang/String;Ljava/lang/String;JJ)Z
    //   6283: ifeq +66 -> 6349
    //   6286: iload 9
    //   6288: istore 12
    //   6290: aload 41
    //   6292: astore 42
    //   6294: aload 38
    //   6296: astore 43
    //   6298: iload 10
    //   6300: istore 13
    //   6302: iload 11
    //   6304: istore 14
    //   6306: aload 39
    //   6308: astore 44
    //   6310: aload 40
    //   6312: astore 41
    //   6314: iload 8
    //   6316: istore 11
    //   6318: iload 7
    //   6320: istore 9
    //   6322: iload 12
    //   6324: istore 10
    //   6326: aload 42
    //   6328: astore 38
    //   6330: aload 43
    //   6332: astore 39
    //   6334: iload 13
    //   6336: istore 7
    //   6338: iload 14
    //   6340: istore 8
    //   6342: aload 44
    //   6344: astore 40
    //   6346: goto -5919 -> 427
    //   6349: ldc_w 281
    //   6352: astore 42
    //   6354: new 94	java/lang/String
    //   6357: dup
    //   6358: aload 44
    //   6360: getfield 2515	tencent/im/msg/im_msg_body$GroupFile:bytes_filename	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   6363: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   6366: invokevirtual 257	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   6369: ldc_w 2517
    //   6372: invokespecial 2120	java/lang/String:<init>	([BLjava/lang/String;)V
    //   6375: astore 43
    //   6377: aload 43
    //   6379: astore 42
    //   6381: lconst_0
    //   6382: lstore 26
    //   6384: lload 26
    //   6386: lstore 24
    //   6388: aload_2
    //   6389: getfield 26	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   6392: invokevirtual 32	tencent/im/msg/im_msg_body$MsgBody:has	()Z
    //   6395: ifeq +58 -> 6453
    //   6398: aload_2
    //   6399: getfield 26	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   6402: invokevirtual 36	tencent/im/msg/im_msg_body$MsgBody:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   6405: checkcast 28	tencent/im/msg/im_msg_body$MsgBody
    //   6408: astore 43
    //   6410: lload 26
    //   6412: lstore 24
    //   6414: aload 43
    //   6416: getfield 40	tencent/im/msg/im_msg_body$MsgBody:rich_text	Ltencent/im/msg/im_msg_body$RichText;
    //   6419: getfield 2521	tencent/im/msg/im_msg_body$RichText:attr	Ltencent/im/msg/im_msg_body$Attr;
    //   6422: invokevirtual 2524	tencent/im/msg/im_msg_body$Attr:has	()Z
    //   6425: ifeq +28 -> 6453
    //   6428: aload 43
    //   6430: getfield 40	tencent/im/msg/im_msg_body$MsgBody:rich_text	Ltencent/im/msg/im_msg_body$RichText;
    //   6433: getfield 2521	tencent/im/msg/im_msg_body$RichText:attr	Ltencent/im/msg/im_msg_body$Attr;
    //   6436: invokevirtual 2525	tencent/im/msg/im_msg_body$Attr:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   6439: checkcast 2523	tencent/im/msg/im_msg_body$Attr
    //   6442: getfield 2528	tencent/im/msg/im_msg_body$Attr:random	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   6445: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   6448: invokestatic 2531	com/tencent/mobileqq/service/message/MessageUtils:a	(I)J
    //   6451: lstore 24
    //   6453: sipush -2005
    //   6456: invokestatic 399	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   6459: checkcast 2533	com/tencent/mobileqq/data/MessageForFile
    //   6462: astore 43
    //   6464: aload 43
    //   6466: sipush -2005
    //   6469: putfield 2534	com/tencent/mobileqq/data/MessageForFile:msgtype	I
    //   6472: aload 43
    //   6474: aload_0
    //   6475: getfield 216	com/tencent/mobileqq/app/MessageHandler:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6478: invokevirtual 445	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/app/FileTransferHandler;
    //   6481: aload 43
    //   6483: getfield 2537	com/tencent/mobileqq/data/MessageForFile:uniseq	J
    //   6486: lload 22
    //   6488: lload 30
    //   6490: lload 36
    //   6492: lload 24
    //   6494: lload 34
    //   6496: aload 44
    //   6498: invokevirtual 2540	com/tencent/mobileqq/filemanager/app/FileTransferHandler:a	(JJJJJJLtencent/im/msg/im_msg_body$GroupFile;)J
    //   6501: putfield 2537	com/tencent/mobileqq/data/MessageForFile:uniseq	J
    //   6504: aload 44
    //   6506: getfield 2541	tencent/im/msg/im_msg_body$GroupFile:uint64_file_size	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   6509: invokevirtual 245	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   6512: lstore 22
    //   6514: lload 30
    //   6516: lload 32
    //   6518: lcmp
    //   6519: ifne +100 -> 6619
    //   6522: iconst_1
    //   6523: istore 20
    //   6525: aload 43
    //   6527: aload 42
    //   6529: lload 22
    //   6531: iconst_0
    //   6532: iload 20
    //   6534: invokestatic 2544	com/tencent/mobileqq/transfile/TransfileUtile:a	(Ljava/lang/String;JIZ)Ljava/lang/String;
    //   6537: putfield 2545	com/tencent/mobileqq/data/MessageForFile:msg	Ljava/lang/String;
    //   6540: aload 43
    //   6542: invokevirtual 2548	com/tencent/mobileqq/data/MessageForFile:doParse	()V
    //   6545: aload_1
    //   6546: aload 43
    //   6548: invokeinterface 375 2 0
    //   6553: pop
    //   6554: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6557: ifeq +29 -> 6586
    //   6560: aload 45
    //   6562: ldc_w 2550
    //   6565: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6568: aload 44
    //   6570: getfield 2515	tencent/im/msg/im_msg_body$GroupFile:bytes_filename	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   6573: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   6576: invokevirtual 563	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6579: ldc_w 1431
    //   6582: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6585: pop
    //   6586: iload 9
    //   6588: istore 12
    //   6590: iload 10
    //   6592: istore 13
    //   6594: iload 7
    //   6596: istore 9
    //   6598: iload 12
    //   6600: istore 10
    //   6602: iload 13
    //   6604: istore 7
    //   6606: goto -4779 -> 1827
    //   6609: astore 43
    //   6611: aload 43
    //   6613: invokevirtual 2551	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   6616: goto -235 -> 6381
    //   6619: iconst_0
    //   6620: istore 20
    //   6622: goto -97 -> 6525
    //   6625: aload 49
    //   6627: getfield 2555	tencent/im/msg/im_msg_body$Elem:market_trans	Ltencent/im/msg/im_msg_body$MarketTrans;
    //   6630: invokevirtual 2558	tencent/im/msg/im_msg_body$MarketTrans:has	()Z
    //   6633: ifeq +226 -> 6859
    //   6636: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6639: ifeq +12 -> 6651
    //   6642: aload 45
    //   6644: ldc_w 2560
    //   6647: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6650: pop
    //   6651: aload 47
    //   6653: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   6656: ifle +54 -> 6710
    //   6659: sipush -1000
    //   6662: invokestatic 399	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   6665: checkcast 1120	com/tencent/mobileqq/data/MessageForText
    //   6668: astore 42
    //   6670: aload 42
    //   6672: sipush -1000
    //   6675: putfield 1848	com/tencent/mobileqq/data/MessageForText:msgtype	I
    //   6678: aload 42
    //   6680: aload 47
    //   6682: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6685: putfield 1121	com/tencent/mobileqq/data/MessageForText:msg	Ljava/lang/String;
    //   6688: aload 46
    //   6690: aload 42
    //   6692: invokeinterface 375 2 0
    //   6697: pop
    //   6698: aload 47
    //   6700: iconst_0
    //   6701: aload 47
    //   6703: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   6706: invokevirtual 126	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   6709: pop
    //   6710: aload 49
    //   6712: getfield 2555	tencent/im/msg/im_msg_body$Elem:market_trans	Ltencent/im/msg/im_msg_body$MarketTrans;
    //   6715: invokevirtual 2561	tencent/im/msg/im_msg_body$MarketTrans:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   6718: checkcast 2557	tencent/im/msg/im_msg_body$MarketTrans
    //   6721: astore 42
    //   6723: aload 42
    //   6725: getfield 2564	tencent/im/msg/im_msg_body$MarketTrans:int32_flag	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6728: invokevirtual 2565	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6731: istore 9
    //   6733: aload 42
    //   6735: getfield 2568	tencent/im/msg/im_msg_body$MarketTrans:bytes_xml	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   6738: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   6741: invokevirtual 257	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   6744: iload 9
    //   6746: invokestatic 2571	com/tencent/mobileqq/structmsg/StructMsgFactory:a	([BI)Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   6749: astore 42
    //   6751: aload 40
    //   6753: ifnull +10 -> 6763
    //   6756: aload 42
    //   6758: aload 40
    //   6760: putfield 1105	com/tencent/mobileqq/structmsg/AbsStructMsg:mCompatibleText	Ljava/lang/String;
    //   6763: aload 42
    //   6765: ifnull +76 -> 6841
    //   6768: sipush -2011
    //   6771: invokestatic 399	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   6774: checkcast 1075	com/tencent/mobileqq/data/MessageForStructing
    //   6777: astore 43
    //   6779: aload 43
    //   6781: sipush -2011
    //   6784: putfield 2097	com/tencent/mobileqq/data/MessageForStructing:msgtype	I
    //   6787: aload 43
    //   6789: ldc_w 2573
    //   6792: putfield 2140	com/tencent/mobileqq/data/MessageForStructing:msg	Ljava/lang/String;
    //   6795: aload 43
    //   6797: aload 42
    //   6799: putfield 1079	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   6802: aload 43
    //   6804: aload 43
    //   6806: getfield 1079	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   6809: invokevirtual 2136	com/tencent/mobileqq/structmsg/AbsStructMsg:getBytes	()[B
    //   6812: putfield 2137	com/tencent/mobileqq/data/MessageForStructing:msgData	[B
    //   6815: aload_1
    //   6816: aload 43
    //   6818: invokeinterface 375 2 0
    //   6823: pop
    //   6824: iconst_1
    //   6825: istore 10
    //   6827: iconst_0
    //   6828: istore 12
    //   6830: iload 7
    //   6832: istore 9
    //   6834: iload 12
    //   6836: istore 7
    //   6838: goto -5011 -> 1827
    //   6841: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6844: ifeq +12 -> 6856
    //   6847: aload 45
    //   6849: ldc_w 2142
    //   6852: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6855: pop
    //   6856: goto -32 -> 6824
    //   6859: aload 49
    //   6861: getfield 2577	tencent/im/msg/im_msg_body$Elem:video_file	Ltencent/im/msg/im_msg_body$VideoFile;
    //   6864: invokevirtual 2580	tencent/im/msg/im_msg_body$VideoFile:has	()Z
    //   6867: ifeq +364 -> 7231
    //   6870: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6873: ifeq +12 -> 6885
    //   6876: aload 45
    //   6878: ldc_w 2582
    //   6881: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6884: pop
    //   6885: aload 47
    //   6887: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   6890: ifle +21 -> 6911
    //   6893: aload 47
    //   6895: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6898: pop
    //   6899: aload 47
    //   6901: iconst_0
    //   6902: aload 47
    //   6904: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   6907: invokevirtual 126	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   6910: pop
    //   6911: aload 49
    //   6913: getfield 2577	tencent/im/msg/im_msg_body$Elem:video_file	Ltencent/im/msg/im_msg_body$VideoFile;
    //   6916: invokevirtual 2583	tencent/im/msg/im_msg_body$VideoFile:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   6919: checkcast 2579	tencent/im/msg/im_msg_body$VideoFile
    //   6922: astore 43
    //   6924: new 2585	localpb/richMsg/RichMsg$VideoFile
    //   6927: dup
    //   6928: invokespecial 2586	localpb/richMsg/RichMsg$VideoFile:<init>	()V
    //   6931: astore 42
    //   6933: aload 42
    //   6935: iconst_1
    //   6936: invokevirtual 2589	localpb/richMsg/RichMsg$VideoFile:setHasFlag	(Z)V
    //   6939: aload 42
    //   6941: getfield 2590	localpb/richMsg/RichMsg$VideoFile:bytes_file_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   6944: aload 43
    //   6946: getfield 2591	tencent/im/msg/im_msg_body$VideoFile:bytes_file_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   6949: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   6952: invokevirtual 591	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   6955: aload 42
    //   6957: getfield 2594	localpb/richMsg/RichMsg$VideoFile:bytes_file_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   6960: aload 43
    //   6962: getfield 2595	tencent/im/msg/im_msg_body$VideoFile:bytes_file_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   6965: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   6968: invokevirtual 591	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   6971: aload 42
    //   6973: getfield 2596	localpb/richMsg/RichMsg$VideoFile:bytes_file_uuid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   6976: aload 43
    //   6978: getfield 2597	tencent/im/msg/im_msg_body$VideoFile:bytes_file_uuid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   6981: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   6984: invokevirtual 591	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   6987: aload 42
    //   6989: getfield 2600	localpb/richMsg/RichMsg$VideoFile:uint32_file_format	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   6992: aload 43
    //   6994: getfield 2601	tencent/im/msg/im_msg_body$VideoFile:uint32_file_format	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   6997: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   7000: invokevirtual 173	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   7003: aload 42
    //   7005: getfield 2602	localpb/richMsg/RichMsg$VideoFile:uint32_file_size	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7008: aload 43
    //   7010: getfield 2603	tencent/im/msg/im_msg_body$VideoFile:uint32_file_size	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7013: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   7016: invokevirtual 173	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   7019: aload 42
    //   7021: getfield 2606	localpb/richMsg/RichMsg$VideoFile:uint32_file_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7024: aload 43
    //   7026: getfield 2607	tencent/im/msg/im_msg_body$VideoFile:uint32_file_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7029: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   7032: invokevirtual 173	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   7035: aload 42
    //   7037: getfield 2608	localpb/richMsg/RichMsg$VideoFile:uint32_thumb_width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7040: aload 43
    //   7042: getfield 2609	tencent/im/msg/im_msg_body$VideoFile:uint32_thumb_width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7045: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   7048: invokevirtual 173	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   7051: aload 42
    //   7053: getfield 2610	localpb/richMsg/RichMsg$VideoFile:uint32_thumb_height	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7056: aload 43
    //   7058: getfield 2611	tencent/im/msg/im_msg_body$VideoFile:uint32_thumb_height	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7061: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   7064: invokevirtual 173	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   7067: aload 42
    //   7069: getfield 2614	localpb/richMsg/RichMsg$VideoFile:uint32_file_status	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7072: sipush 2008
    //   7075: invokevirtual 173	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   7078: aload 42
    //   7080: getfield 2617	localpb/richMsg/RichMsg$VideoFile:uint32_file_progress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7083: iconst_0
    //   7084: invokevirtual 173	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   7087: aload 42
    //   7089: getfield 2620	localpb/richMsg/RichMsg$VideoFile:bytes_thumb_file_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   7092: aload 43
    //   7094: getfield 2621	tencent/im/msg/im_msg_body$VideoFile:bytes_thumb_file_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   7097: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   7100: invokevirtual 591	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   7103: sipush -2022
    //   7106: invokestatic 399	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   7109: checkcast 949	com/tencent/mobileqq/data/MessageForShortVideo
    //   7112: astore 43
    //   7114: aload 43
    //   7116: sipush -2022
    //   7119: putfield 2622	com/tencent/mobileqq/data/MessageForShortVideo:msgtype	I
    //   7122: aload 43
    //   7124: aload 42
    //   7126: invokevirtual 2623	localpb/richMsg/RichMsg$VideoFile:toByteArray	()[B
    //   7129: putfield 2624	com/tencent/mobileqq/data/MessageForShortVideo:msgData	[B
    //   7132: aload 43
    //   7134: ldc_w 2626
    //   7137: putfield 2627	com/tencent/mobileqq/data/MessageForShortVideo:msg	Ljava/lang/String;
    //   7140: aload 43
    //   7142: invokevirtual 2628	com/tencent/mobileqq/data/MessageForShortVideo:parse	()V
    //   7145: aload 46
    //   7147: aload 43
    //   7149: invokeinterface 375 2 0
    //   7154: pop
    //   7155: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7158: ifeq +47 -> 7205
    //   7161: aload 45
    //   7163: ldc_w 2630
    //   7166: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7169: new 91	java/lang/StringBuilder
    //   7172: dup
    //   7173: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   7176: aload 43
    //   7178: invokevirtual 2631	com/tencent/mobileqq/data/MessageForShortVideo:toString	()Ljava/lang/String;
    //   7181: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7184: ldc_w 2633
    //   7187: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7190: aload 43
    //   7192: invokevirtual 2636	com/tencent/mobileqq/data/MessageForShortVideo:toLogString	()Ljava/lang/String;
    //   7195: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7198: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7201: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7204: pop
    //   7205: iconst_1
    //   7206: istore 13
    //   7208: iload 9
    //   7210: istore 7
    //   7212: iload 10
    //   7214: istore 12
    //   7216: iload 13
    //   7218: istore 9
    //   7220: iload 7
    //   7222: istore 10
    //   7224: iload 12
    //   7226: istore 7
    //   7228: goto -5401 -> 1827
    //   7231: aload 49
    //   7233: getfield 2640	tencent/im/msg/im_msg_body$Elem:tips_info	Ltencent/im/msg/im_msg_body$TipsInfo;
    //   7236: invokevirtual 2643	tencent/im/msg/im_msg_body$TipsInfo:has	()Z
    //   7239: ifeq +124 -> 7363
    //   7242: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7245: ifeq +12 -> 7257
    //   7248: aload 45
    //   7250: ldc_w 2645
    //   7253: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7256: pop
    //   7257: aload 49
    //   7259: getfield 2640	tencent/im/msg/im_msg_body$Elem:tips_info	Ltencent/im/msg/im_msg_body$TipsInfo;
    //   7262: invokevirtual 2646	tencent/im/msg/im_msg_body$TipsInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   7265: checkcast 2642	tencent/im/msg/im_msg_body$TipsInfo
    //   7268: astore 42
    //   7270: sipush -5002
    //   7273: invokestatic 399	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   7276: checkcast 2648	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips
    //   7279: astore 43
    //   7281: aload 43
    //   7283: aload 42
    //   7285: getfield 2650	tencent/im/msg/im_msg_body$TipsInfo:text	Lcom/tencent/mobileqq/pb/PBStringField;
    //   7288: invokevirtual 270	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   7291: invokevirtual 2654	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:parseTextXML	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   7294: invokevirtual 2659	java/lang/Boolean:booleanValue	()Z
    //   7297: ifne +41 -> 7338
    //   7300: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7303: ifeq +12 -> 7315
    //   7306: aload 45
    //   7308: ldc_w 2661
    //   7311: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7314: pop
    //   7315: iload 9
    //   7317: istore 12
    //   7319: iload 10
    //   7321: istore 13
    //   7323: iload 7
    //   7325: istore 9
    //   7327: iload 12
    //   7329: istore 10
    //   7331: iload 13
    //   7333: istore 7
    //   7335: goto -5508 -> 1827
    //   7338: aload 46
    //   7340: aload 43
    //   7342: invokeinterface 375 2 0
    //   7347: pop
    //   7348: aload 47
    //   7350: iconst_0
    //   7351: aload 47
    //   7353: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   7356: invokevirtual 126	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   7359: pop
    //   7360: goto -45 -> 7315
    //   7363: iload 8
    //   7365: istore 12
    //   7367: aload 49
    //   7369: getfield 2665	tencent/im/msg/im_msg_body$Elem:qqwallet_msg	Ltencent/im/msg/im_msg_body$QQWalletMsg;
    //   7372: invokevirtual 2668	tencent/im/msg/im_msg_body$QQWalletMsg:has	()Z
    //   7375: ifeq +188 -> 7563
    //   7378: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7381: ifeq +12 -> 7393
    //   7384: aload 45
    //   7386: ldc_w 2670
    //   7389: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7392: pop
    //   7393: aload 47
    //   7395: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   7398: ifle +15 -> 7413
    //   7401: aload 47
    //   7403: iconst_0
    //   7404: aload 47
    //   7406: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   7409: invokevirtual 126	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   7412: pop
    //   7413: iconst_1
    //   7414: istore 12
    //   7416: aload 49
    //   7418: getfield 2665	tencent/im/msg/im_msg_body$Elem:qqwallet_msg	Ltencent/im/msg/im_msg_body$QQWalletMsg;
    //   7421: invokevirtual 2671	tencent/im/msg/im_msg_body$QQWalletMsg:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   7424: checkcast 2667	tencent/im/msg/im_msg_body$QQWalletMsg
    //   7427: astore 42
    //   7429: sipush -2025
    //   7432: invokestatic 399	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   7435: checkcast 2673	com/tencent/mobileqq/data/MessageForQQWalletMsg
    //   7438: astore 43
    //   7440: aload 43
    //   7442: sipush -2025
    //   7445: putfield 2674	com/tencent/mobileqq/data/MessageForQQWalletMsg:msgtype	I
    //   7448: aload 43
    //   7450: new 2676	com/tencent/mobileqq/data/QQWalletTransferMsg
    //   7453: dup
    //   7454: aload 42
    //   7456: getfield 2680	tencent/im/msg/im_msg_body$QQWalletMsg:aio_body	Ltencent/im/msg/im_msg_body$QQWalletAioBody;
    //   7459: aload_0
    //   7460: getfield 216	com/tencent/mobileqq/app/MessageHandler:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7463: invokevirtual 220	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   7466: invokespecial 2683	com/tencent/mobileqq/data/QQWalletTransferMsg:<init>	(Ltencent/im/msg/im_msg_body$QQWalletAioBody;Ljava/lang/String;)V
    //   7469: putfield 2687	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletTransferMsg	Lcom/tencent/mobileqq/data/QQWalletTransferMsg;
    //   7472: aload 43
    //   7474: aload 43
    //   7476: invokevirtual 2690	com/tencent/mobileqq/data/MessageForQQWalletMsg:getMsgSummary	()Ljava/lang/String;
    //   7479: putfield 2691	com/tencent/mobileqq/data/MessageForQQWalletMsg:msg	Ljava/lang/String;
    //   7482: aload 43
    //   7484: aload 43
    //   7486: invokevirtual 2692	com/tencent/mobileqq/data/MessageForQQWalletMsg:getBytes	()[B
    //   7489: putfield 2693	com/tencent/mobileqq/data/MessageForQQWalletMsg:msgData	[B
    //   7492: aload 47
    //   7494: iconst_0
    //   7495: aload 47
    //   7497: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   7500: invokevirtual 126	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   7503: pop
    //   7504: aload 43
    //   7506: getfield 2687	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletTransferMsg	Lcom/tencent/mobileqq/data/QQWalletTransferMsg;
    //   7509: ifnonnull +44 -> 7553
    //   7512: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7515: ifeq +48 -> 7563
    //   7518: aload 45
    //   7520: ldc_w 2695
    //   7523: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7526: pop
    //   7527: iconst_1
    //   7528: istore 8
    //   7530: iload 9
    //   7532: istore 12
    //   7534: iload 10
    //   7536: istore 13
    //   7538: iload 7
    //   7540: istore 9
    //   7542: iload 12
    //   7544: istore 10
    //   7546: iload 13
    //   7548: istore 7
    //   7550: goto -5723 -> 1827
    //   7553: aload 46
    //   7555: aload 43
    //   7557: invokeinterface 375 2 0
    //   7562: pop
    //   7563: iload 12
    //   7565: istore 8
    //   7567: iload 9
    //   7569: istore 12
    //   7571: iload 10
    //   7573: istore 13
    //   7575: iload 7
    //   7577: istore 9
    //   7579: iload 12
    //   7581: istore 10
    //   7583: iload 13
    //   7585: istore 7
    //   7587: goto -5760 -> 1827
    //   7590: aload 46
    //   7592: invokeinterface 1895 1 0
    //   7597: ifle -6145 -> 1452
    //   7600: aload_0
    //   7601: aload 46
    //   7603: iconst_0
    //   7604: invokeinterface 2041 2 0
    //   7609: invokeinterface 375 2 0
    //   7614: pop
    //   7615: goto -6163 -> 1452
    //   7618: aload_0
    //   7619: aload 46
    //   7621: invokeinterface 2699 2 0
    //   7626: pop
    //   7627: goto -6175 -> 1452
    //   7630: aload 5
    //   7632: getfield 362	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   7635: sipush -2000
    //   7638: if_icmpne +105 -> 7743
    //   7641: iload 7
    //   7643: iconst_1
    //   7644: iadd
    //   7645: istore 7
    //   7647: goto -6127 -> 1520
    //   7650: goto -6175 -> 1475
    //   7653: aload_2
    //   7654: aload 5
    //   7656: invokeinterface 375 2 0
    //   7661: pop
    //   7662: goto -6113 -> 1549
    //   7665: aload_2
    //   7666: invokeinterface 1895 1 0
    //   7671: ifle +20 -> 7691
    //   7674: aload_1
    //   7675: aload_2
    //   7676: invokestatic 2157	com/tencent/mobileqq/service/message/MessageProtoCodec:a	(Ljava/util/List;)Lcom/tencent/mobileqq/data/MessageRecord;
    //   7679: invokeinterface 375 2 0
    //   7684: pop
    //   7685: aload_2
    //   7686: invokeinterface 2160 1 0
    //   7691: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7694: ifeq -7602 -> 92
    //   7697: aload 45
    //   7699: ldc_w 2701
    //   7702: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7705: aload_1
    //   7706: invokeinterface 1895 1 0
    //   7711: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7714: pop
    //   7715: ldc 13
    //   7717: iconst_2
    //   7718: aload 45
    //   7720: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7723: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7726: return
    //   7727: aload_1
    //   7728: aload_0
    //   7729: invokeinterface 2699 2 0
    //   7734: pop
    //   7735: goto -44 -> 7691
    //   7738: astore 42
    //   7740: goto -6825 -> 915
    //   7743: goto -6223 -> 1520
    //   7746: iconst_0
    //   7747: istore 6
    //   7749: goto -6220 -> 1529
    //   7752: aload 39
    //   7754: astore 42
    //   7756: iload 11
    //   7758: istore 12
    //   7760: aload 38
    //   7762: astore 39
    //   7764: aload 41
    //   7766: astore 38
    //   7768: aload 40
    //   7770: astore 41
    //   7772: iload 8
    //   7774: istore 11
    //   7776: iload 12
    //   7778: istore 8
    //   7780: aload 42
    //   7782: astore 40
    //   7784: goto -7357 -> 427
    //   7787: aconst_null
    //   7788: astore 42
    //   7790: goto -5010 -> 2780
    //   7793: iconst_0
    //   7794: istore 12
    //   7796: goto -5090 -> 2706
    //   7799: goto -7312 -> 487
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	7802	0	paramMessageHandler	MessageHandler
    //   0	7802	1	paramList	List
    //   0	7802	2	paramMsg	msg_comm.Msg
    //   0	7802	3	paramBoolean1	boolean
    //   0	7802	4	paramBoolean2	boolean
    //   0	7802	5	paramMessageInfo	com.tencent.mobileqq.troop.data.MessageInfo
    //   131	7617	6	i	int
    //   155	7491	7	j	int
    //   158	7621	8	k	int
    //   152	7426	9	m	int
    //   128	7454	10	n	int
    //   125	7650	11	i1	int
    //   382	7413	12	i2	int
    //   386	7198	13	i3	int
    //   854	5485	14	i4	int
    //   1964	3963	15	i5	int
    //   1211	4782	16	i6	int
    //   184	4560	17	i7	int
    //   1767	2508	18	i8	int
    //   2754	306	19	i9	int
    //   6523	98	20	bool1	boolean
    //   178	198	21	bool2	boolean
    //   644	5886	22	l1	long
    //   621	5872	24	l2	long
    //   3280	3131	26	l3	long
    //   171	1842	28	l4	long
    //   3290	3225	30	l5	long
    //   3300	3217	32	l6	long
    //   6224	271	34	l7	long
    //   6235	256	36	l8	long
    //   146	3867	38	localObject1	Object
    //   4037	3	38	localException1	Exception
    //   4062	3705	38	localObject2	Object
    //   28	7735	39	localObject3	Object
    //   181	7602	40	localObject4	Object
    //   149	7622	41	localObject5	Object
    //   397	3904	42	localObject6	Object
    //   4331	170	42	localException2	Exception
    //   4539	2916	42	localObject7	Object
    //   7738	1	42	localException3	Exception
    //   7754	35	42	localObject8	Object
    //   592	297	43	localObject9	Object
    //   895	3	43	localException4	Exception
    //   905	7	43	localException5	Exception
    //   930	35	43	localObject10	Object
    //   983	3	43	localException6	Exception
    //   1069	2976	43	localObject11	Object
    //   4128	3	43	localException7	Exception
    //   4138	131	43	localException8	Exception
    //   4355	207	43	localTroopFileData	com.tencent.mobileqq.data.TroopFileData
    //   4606	3	43	localException9	Exception
    //   5046	3	43	localException10	Exception
    //   5276	1271	43	localObject12	Object
    //   6609	3	43	localUnsupportedEncodingException	UnsupportedEncodingException
    //   6777	779	43	localObject13	Object
    //   942	5627	44	localObject14	Object
    //   40	7679	45	localStringBuilder1	StringBuilder
    //   49	7571	46	localArrayList	ArrayList
    //   143	7353	47	localStringBuilder2	StringBuilder
    //   25	3902	48	localList	List
    //   236	7181	49	localElem	im_msg_body.Elem
    //   2554	3333	50	localObject15	Object
    //   2619	3247	51	localObject16	Object
    //   2714	3325	52	localObject17	Object
    //   2724	3288	53	localObject18	Object
    //   2827	2921	54	localObject19	Object
    // Exception table:
    //   from	to	target	type
    //   801	808	895	java/lang/Exception
    //   772	801	905	java/lang/Exception
    //   818	828	905	java/lang/Exception
    //   828	840	905	java/lang/Exception
    //   897	902	905	java/lang/Exception
    //   985	990	905	java/lang/Exception
    //   808	818	983	java/lang/Exception
    //   3866	3872	4037	java/lang/Exception
    //   3876	3890	4037	java/lang/Exception
    //   3894	3902	4037	java/lang/Exception
    //   3906	3913	4037	java/lang/Exception
    //   3926	3935	4037	java/lang/Exception
    //   3943	3953	4037	java/lang/Exception
    //   3957	3969	4037	java/lang/Exception
    //   3973	3984	4037	java/lang/Exception
    //   3988	4008	4037	java/lang/Exception
    //   4012	4034	4037	java/lang/Exception
    //   4082	4089	4128	java/lang/Exception
    //   4089	4099	4138	java/lang/Exception
    //   4288	4300	4331	java/lang/Exception
    //   4559	4569	4606	java/lang/Exception
    //   4996	5006	5046	java/lang/Exception
    //   6354	6377	6609	java/io/UnsupportedEncodingException
    //   734	767	7738	java/lang/Exception
  }
  
  public static void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List paramList)
  {
    im_msg_body.Ptt localPtt = (im_msg_body.Ptt)((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).ptt.get();
    String str = localPtt.bytes_file_name.get().toStringUtf8();
    int k;
    int m;
    int n;
    boolean bool;
    long l2;
    long l3;
    long l4;
    long l5;
    long l6;
    Object localObject4;
    Object localObject3;
    int j;
    if (str.endsWith(".amr"))
    {
      k = a(paramMsg);
      m = b(paramMsg);
      n = localPtt.uint32_file_type.get();
      bool = localPtt.bool_valid.get();
      l2 = localPtt.uint64_src_uin.get();
      l3 = localPtt.uint32_file_size.get();
      l4 = localPtt.uint32_file_id.get() & 0xFFFFFFFF;
      l5 = localPtt.uint32_server_ip.get();
      l6 = localPtt.uint32_server_port.get();
      localObject4 = localPtt.bytes_file_uuid.get().toByteArray();
      localObject3 = localPtt.bytes_file_md5.get().toByteArray();
      if (!localPtt.uint32_format.has()) {
        break label936;
      }
      j = localPtt.uint32_format.get();
    }
    for (;;)
    {
      int i;
      long l1;
      Object localObject1;
      Object localObject5;
      if (localPtt.uint32_time.has())
      {
        i = localPtt.uint32_time.get();
        l1 = RecordParams.b(i);
        localObject1 = "";
        paramMessageHandler = (MessageHandler)localObject1;
        if (localPtt.bytes_down_para.has())
        {
          if (QLog.isColorLevel()) {
            QLog.d("SPD", 2, "receive ptt msg , bytes_down_para has ! " + localPtt.bytes_down_para.get());
          }
          localObject5 = localPtt.bytes_down_para.get();
          paramMessageHandler = (MessageHandler)localObject1;
          if (localObject5 != null) {
            paramMessageHandler = ((ByteStringMicro)localObject5).toStringUtf8();
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("SPD", 2, "receive ptt msg , url : " + paramMessageHandler + " srcuin " + l2 + "filename" + str);
        }
        if (QLog.isColorLevel()) {
          QLog.d("RecordParams", 2, "<---decodeGrpDisMsgPkg_PTT voiceType：" + j + " voiceLengh:" + l1);
        }
        localObject5 = HexUtil.a((byte[])localObject4);
        localObject4 = HexUtil.a((byte[])localObject3);
        localObject3 = null;
        localObject1 = localObject3;
        if (localPtt.bytes_group_file_key.has()) {
          localObject1 = localPtt.bytes_group_file_key.get().toByteArray();
        }
      }
      try
      {
        localObject1 = new String((byte[])localObject1, "utf-8");
        localObject3 = localObject4;
        if (localObject4 == null) {
          localObject3 = "";
        }
        if (QLog.isColorLevel())
        {
          localObject4 = new StringBuilder("<---decodeSinglePbMsg_GroupDis:");
          ((StringBuilder)localObject4).append(" pttType:").append(n).append(" isValid:").append(bool).append(" srcUin:").append(l2).append(" fileSize:").append(l3 & 0xFFFFFFFF).append(" fileID").append(l4).append(" serverIP:").append(l5 & 0xFFFFFFFF).append(" serverPort:").append(l6 & 0xFFFFFFFF).append(" fileName:").append(str).append(" uuidStr:").append((String)localObject5).append(" md5Str:").append((String)localObject3).append(" GrpFileKey:").append((String)localObject1);
          QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject4).toString());
        }
        if (localPtt.bytes_pb_reserve.has())
        {
          localObject4 = new ptt_reserve.ReserveStruct();
          try
          {
            ((ptt_reserve.ReserveStruct)localObject4).mergeFrom(localPtt.bytes_pb_reserve.get().toByteArray());
            i = ((ptt_reserve.ReserveStruct)localObject4).uint32_change_voice.get();
            localObject4 = new RichMsg.PttRec();
            ((RichMsg.PttRec)localObject4).localPath.set(str);
            ((RichMsg.PttRec)localObject4).size.set(0L);
            ((RichMsg.PttRec)localObject4).type.set(2);
            ((RichMsg.PttRec)localObject4).uuid.set(str);
            ((RichMsg.PttRec)localObject4).isRead.set(false);
            ((RichMsg.PttRec)localObject4).md5.set((String)localObject3);
            ((RichMsg.PttRec)localObject4).isReport.set(0);
            ((RichMsg.PttRec)localObject4).version.set(5);
            ((RichMsg.PttRec)localObject4).groupFileID.set(l4);
            ((RichMsg.PttRec)localObject4).pttFlag.set(k);
            ((RichMsg.PttRec)localObject4).longPttVipFlag.set(m);
            if (localObject1 != null) {
              ((RichMsg.PttRec)localObject4).group_file_key.set((String)localObject1);
            }
            l2 = System.currentTimeMillis() / 1000L;
            l3 = paramMsg.msg_head.msg_time.get();
            ((RichMsg.PttRec)localObject4).msgRecTime.set(l2);
            ((RichMsg.PttRec)localObject4).msgTime.set(l3);
            ((RichMsg.PttRec)localObject4).voiceType.set(j);
            ((RichMsg.PttRec)localObject4).voiceLength.set(Utils.a(l1));
            ((RichMsg.PttRec)localObject4).voiceChangeFlag.set(i);
            ((RichMsg.PttRec)localObject4).directUrl.set(paramMessageHandler);
            paramMessageHandler = MessageRecordFactory.a(-2002);
            paramMessageHandler.msgtype = -2002;
            paramMessageHandler.msgData = ((RichMsg.PttRec)localObject4).toByteArray();
            ((MessageForPtt)paramMessageHandler).parse();
            paramList.add(paramMessageHandler);
            return;
            label936:
            j = 0;
            continue;
            i = 0;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              i = 0;
            }
          }
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          Object localObject2 = localObject3;
          continue;
          i = 0;
        }
      }
    }
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
      new Handler(localLooper).post(new efd(paramMessageHandler, paramMsg));
      return;
    }
    ((DataLineHandler)paramMessageHandler.a.a(8)).a(paramMsg);
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
          paramMessageHandler.a().a(l1, l2, s, -1006 - (s - 187), paramMsg);
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
    paramMessageHandler = paramMsgType0x210.msg_content.get().toByteArray();
    paramMsgType0x210 = new Submsgtype0x35.MsgBody();
    try
    {
      int i = ((Submsgtype0x35.MsgBody)paramMsgType0x210.mergeFrom(paramMessageHandler)).uint32_bubble_timestamp.get();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "decodeC2CMsgPkg_MsgType0x210 bubble push timestamp=" + i);
      }
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
        TroopNotificationHelper.a(paramQQAppInterface, i, l1, l2, l3, str, j, "OidbSvc.0x852_35", (short)23, false, false);
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
  
  private static PAMessage b(String paramString)
  {
    paramString = PAMessageUtil.b(paramString);
    if (paramString != null) {
      return paramString;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.MessageProtoCodec
 * JD-Core Version:    0.7.0.1
 */