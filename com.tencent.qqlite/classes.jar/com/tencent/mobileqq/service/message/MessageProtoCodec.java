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
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.transfile.TransfileUtile;
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
import com.tencent.qqlite.data.MarkFaceMessage;
import eds;
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
import tencent.im.msg.im_msg_body.TmpPtt;
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
    long l1 = -1L;
    long l2 = l1;
    int i;
    if (localPtt.bytes_reserve.has())
    {
      paramMsg = localPtt.bytes_reserve.get().toByteArray();
      l2 = l1;
      if (paramMsg != null)
      {
        l2 = l1;
        if (paramMsg.length > 1)
        {
          i = paramMsg[0];
          i = 1;
          for (;;)
          {
            l2 = l1;
            if (i >= paramMsg.length - 1) {
              break;
            }
            int j = paramMsg[i];
            int k = i + 1;
            i = PkgTools.a(paramMsg, k);
            k += 2;
            l2 = l1;
            if (j == 3)
            {
              localObject = new byte[i];
              PkgTools.a((byte[])localObject, 0, paramMsg, k, i);
              l2 = PkgTools.a((byte[])localObject, 0);
              if (l2 > 0L) {
                l1 = l2;
              }
              l2 = l1;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.msg.MessageHandler", 2, "PTT_ROAM : TimeStamp in d0 :" + l1);
                l2 = l1;
              }
            }
            i = k + i;
            l1 = l2;
          }
        }
      }
    }
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
      paramMsg.pttFlag.set(0);
      i = MessageUtils.a(paramMessageHandler.a, String.valueOf(l3));
      paramMsg.longPttVipFlag.set(i);
      paramMessageHandler = MessageRecordFactory.a(-2002);
      paramMessageHandler.msgtype = -2002;
      paramMessageHandler.msgData = paramMsg.toByteArray();
      paramMessageHandler.time = l2;
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
        localObject2 = BaseApplication.getContext().getString(2131364118);
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
      paramMsg = BaseApplication.getContext().getString(2131363597);
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
          label384:
          j = 0;
          i = j;
          if (paramMsg.content_head.has())
          {
            i = j;
            if (((msg_comm.ContentHead)paramMsg.content_head.get()).auto_reply.has()) {
              if (((msg_comm.ContentHead)paramMsg.content_head.get()).auto_reply.get() != 1) {
                break label939;
              }
            }
          }
          break;
        }
        label939:
        for (i = 1;; i = 0)
        {
          localObject1 = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get();
          if (i == 0) {
            break label945;
          }
          if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
            break;
          }
          paramMsg = (im_msg_body.Text)((im_msg_body.Elem)((List)localObject1).get(0)).text.get();
          if ((BaseApplication.getContext().getSharedPreferences("share", 0).getString("no_auto_reply" + paramMessageHandler.a.a(), "").contains("NAR" + paramDecodeProtoPkgContext.e + ",")) || (paramDecodeProtoPkgContext.b)) {
            break;
          }
          paramMessageHandler = BaseApplication.getContext().getString(2131363597) + " " + paramMsg.str.get().toStringUtf8();
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
          break label384;
          localObject2 = new byte[localObject1.length + 2];
          localObject2[0] = ((byte)i);
          localObject2[1] = ((byte)j);
          PkgTools.a((byte[])localObject2, 2, (byte[])localObject1, 0, localObject1.length);
          paramMessageHandler.a.a().b(String.valueOf(paramDecodeProtoPkgContext.e), (byte[])localObject2);
          break label384;
          paramMessageHandler.a.a().c(String.valueOf(paramDecodeProtoPkgContext.e), (byte[])localObject1);
          break label384;
          localObject2 = new byte[localObject1.length + 2];
          localObject2[0] = ((byte)i);
          localObject2[1] = ((byte)j);
          PkgTools.a((byte[])localObject2, 2, (byte[])localObject1, 0, localObject1.length);
          paramMessageHandler.a.a().e(String.valueOf(paramDecodeProtoPkgContext.e), (byte[])localObject2);
          break label384;
          paramMessageHandler.a.a().g(String.valueOf(paramDecodeProtoPkgContext.e), (byte[])localObject1);
          break label384;
          paramMessageHandler.a.a().h(String.valueOf(paramDecodeProtoPkgContext.e), (byte[])localObject1);
          break label384;
          paramMessageHandler.a.a().j(String.valueOf(paramDecodeProtoPkgContext.e), (byte[])localObject1);
          break label384;
        }
        label945:
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
    //   34: ldc_w 2016
    //   37: invokespecial 510	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   40: astore 45
    //   42: new 99	java/util/ArrayList
    //   45: dup
    //   46: invokespecial 1367	java/util/ArrayList:<init>	()V
    //   49: astore 46
    //   51: aload 48
    //   53: ifnull +13 -> 66
    //   56: aload 48
    //   58: invokeinterface 1836 1 0
    //   63: ifgt +30 -> 93
    //   66: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   69: ifeq +23 -> 92
    //   72: aload 45
    //   74: ldc_w 2018
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
    //   101: ldc_w 2020
    //   104: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload 48
    //   109: invokeinterface 1836 1 0
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
    //   175: invokestatic 2023	com/tencent/mobileqq/service/message/MessageProtoCodec:a	(Ljava/util/List;)Z
    //   178: istore 21
    //   180: aconst_null
    //   181: astore 40
    //   183: iconst_0
    //   184: istore 17
    //   186: iload 17
    //   188: aload 48
    //   190: invokeinterface 1836 1 0
    //   195: if_icmpge +1111 -> 1306
    //   198: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   201: ifeq +23 -> 224
    //   204: aload 45
    //   206: ldc_w 2025
    //   209: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: iload 17
    //   214: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   217: ldc_w 2027
    //   220: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload 48
    //   226: iload 17
    //   228: invokeinterface 1982 2 0
    //   233: checkcast 70	tencent/im/msg/im_msg_body$Elem
    //   236: astore 49
    //   238: iload 10
    //   240: ifeq +7559 -> 7799
    //   243: aload 49
    //   245: getfield 937	tencent/im/msg/im_msg_body$Elem:text	Ltencent/im/msg/im_msg_body$Text;
    //   248: invokevirtual 1632	tencent/im/msg/im_msg_body$Text:has	()Z
    //   251: ifeq +7548 -> 7799
    //   254: aload 39
    //   256: aload 49
    //   258: getfield 937	tencent/im/msg/im_msg_body$Elem:text	Ltencent/im/msg/im_msg_body$Text;
    //   261: invokevirtual 1679	tencent/im/msg/im_msg_body$Text:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
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
    //   348: ldc_w 2029
    //   351: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: aload 49
    //   356: getfield 937	tencent/im/msg/im_msg_body$Elem:text	Ltencent/im/msg/im_msg_body$Text;
    //   359: invokevirtual 1679	tencent/im/msg/im_msg_body$Text:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
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
    //   492: invokevirtual 2030	tencent/im/msg/im_msg_body$RichMsg:has	()Z
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
    //   522: putfield 1789	com/tencent/mobileqq/data/MessageForText:msgtype	I
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
    //   565: ldc_w 2032
    //   568: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: pop
    //   572: aload 49
    //   574: getfield 1101	tencent/im/msg/im_msg_body$Elem:rich_msg	Ltencent/im/msg/im_msg_body$RichMsg;
    //   577: invokevirtual 2033	tencent/im/msg/im_msg_body$RichMsg:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   580: checkcast 1087	tencent/im/msg/im_msg_body$RichMsg
    //   583: getfield 1091	tencent/im/msg/im_msg_body$RichMsg:bytes_template_1	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   586: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   589: invokevirtual 257	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   592: astore 43
    //   594: new 1075	com/tencent/mobileqq/data/MessageForStructing
    //   597: dup
    //   598: invokespecial 2034	com/tencent/mobileqq/data/MessageForStructing:<init>	()V
    //   601: astore 42
    //   603: aload 42
    //   605: sipush -2011
    //   608: putfield 2035	com/tencent/mobileqq/data/MessageForStructing:msgtype	I
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
    //   661: getfield 2039	msf/msgcomm/msg_comm$MsgHead:group_info	Lmsf/msgcomm/msg_comm$GroupInfo;
    //   664: ifnull +38 -> 702
    //   667: lload 24
    //   669: lstore 22
    //   671: aload_2
    //   672: getfield 234	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   675: getfield 2039	msf/msgcomm/msg_comm$MsgHead:group_info	Lmsf/msgcomm/msg_comm$GroupInfo;
    //   678: getfield 2042	msf/msgcomm/msg_comm$GroupInfo:group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   681: invokevirtual 2043	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   684: ifeq +18 -> 702
    //   687: aload_2
    //   688: getfield 234	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   691: getfield 2039	msf/msgcomm/msg_comm$MsgHead:group_info	Lmsf/msgcomm/msg_comm$GroupInfo;
    //   694: getfield 2042	msf/msgcomm/msg_comm$GroupInfo:group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   697: invokevirtual 245	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   700: lstore 22
    //   702: aload 42
    //   704: aload_0
    //   705: getfield 216	com/tencent/mobileqq/app/MessageHandler:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   708: iload 12
    //   710: lload 22
    //   712: aload 43
    //   714: iconst_m1
    //   715: invokestatic 2048	com/tencent/mobileqq/structmsg/StructMsgFactory:a	(Lcom/tencent/mobileqq/app/QQAppInterface;IJ[BI)Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
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
    //   741: invokestatic 2053	com/tencent/mobileqq/structmsg/StructMsgUtils:a	([BI)[B
    //   744: ldc_w 2055
    //   747: invokespecial 2058	java/lang/String:<init>	([BLjava/lang/String;)V
    //   750: astore 42
    //   752: aload 47
    //   754: aload 42
    //   756: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   759: pop
    //   760: aload 42
    //   762: invokestatic 2060	com/tencent/mobileqq/service/message/MessageProtoCodec:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/PAMessage;
    //   765: astore 42
    //   767: aload 42
    //   769: ifnull +59 -> 828
    //   772: sipush -3006
    //   775: invokestatic 399	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   778: checkcast 2062	com/tencent/mobileqq/data/MessageForPubAccount
    //   781: astore 38
    //   783: aload 38
    //   785: sipush -3006
    //   788: putfield 2063	com/tencent/mobileqq/data/MessageForPubAccount:msgtype	I
    //   791: aload 38
    //   793: aload 47
    //   795: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   798: putfield 2064	com/tencent/mobileqq/data/MessageForPubAccount:msg	Ljava/lang/String;
    //   801: aload 38
    //   803: aload 42
    //   805: putfield 2068	com/tencent/mobileqq/data/MessageForPubAccount:mPAMessage	Lcom/tencent/mobileqq/data/PAMessage;
    //   808: aload 38
    //   810: aload 42
    //   812: invokestatic 2071	com/tencent/biz/pubaccount/util/PAMessageUtil:a	(Lcom/tencent/mobileqq/data/PAMessage;)[B
    //   815: putfield 2072	com/tencent/mobileqq/data/MessageForPubAccount:msgData	[B
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
    //   899: invokevirtual 2073	java/lang/Exception:printStackTrace	()V
    //   902: goto -94 -> 808
    //   905: astore 43
    //   907: aload 42
    //   909: astore 38
    //   911: aload 43
    //   913: astore 42
    //   915: aload 42
    //   917: invokevirtual 2073	java/lang/Exception:printStackTrace	()V
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
    //   987: invokevirtual 2073	java/lang/Exception:printStackTrace	()V
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
    //   1023: invokevirtual 2074	com/tencent/mobileqq/structmsg/AbsStructMsg:getBytes	()[B
    //   1026: putfield 2075	com/tencent/mobileqq/data/MessageForStructing:msgData	[B
    //   1029: aload 42
    //   1031: ldc_w 2077
    //   1034: putfield 2078	com/tencent/mobileqq/data/MessageForStructing:msg	Ljava/lang/String;
    //   1037: aload 42
    //   1039: getfield 1079	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1042: ifnonnull +75 -> 1117
    //   1045: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1048: ifeq +12 -> 1060
    //   1051: aload 45
    //   1053: ldc_w 2080
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
    //   1185: invokevirtual 1632	tencent/im/msg/im_msg_body$Text:has	()Z
    //   1188: ifeq +840 -> 2028
    //   1191: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1194: ifeq +12 -> 1206
    //   1197: aload 45
    //   1199: ldc_w 2082
    //   1202: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1205: pop
    //   1206: aload 47
    //   1208: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   1211: istore 16
    //   1213: aload 49
    //   1215: getfield 937	tencent/im/msg/im_msg_body$Elem:text	Ltencent/im/msg/im_msg_body$Text;
    //   1218: invokevirtual 1679	tencent/im/msg/im_msg_body$Text:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
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
    //   1258: invokestatic 2085	com/tencent/mobileqq/service/message/MessageUtils:a	(Ljava/lang/String;Z)Ljava/lang/String;
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
    //   1300: invokevirtual 2074	com/tencent/mobileqq/structmsg/AbsStructMsg:getBytes	()[B
    //   1303: putfield 2075	com/tencent/mobileqq/data/MessageForStructing:msgData	[B
    //   1306: aload 47
    //   1308: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   1311: ifle +38 -> 1349
    //   1314: sipush -1000
    //   1317: invokestatic 399	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   1320: checkcast 1120	com/tencent/mobileqq/data/MessageForText
    //   1323: astore_0
    //   1324: aload_0
    //   1325: sipush -1000
    //   1328: putfield 1789	com/tencent/mobileqq/data/MessageForText:msgtype	I
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
    //   1356: invokeinterface 1836 1 0
    //   1361: iconst_1
    //   1362: if_icmpne +63 -> 1425
    //   1365: aload 46
    //   1367: iconst_0
    //   1368: invokeinterface 1982 2 0
    //   1373: checkcast 356	com/tencent/mobileqq/data/MessageRecord
    //   1376: astore_0
    //   1377: aload_0
    //   1378: instanceof 1120
    //   1381: ifeq +44 -> 1425
    //   1384: aload_0
    //   1385: iload 11
    //   1387: invokevirtual 2088	com/tencent/mobileqq/data/MessageRecord:setRepeatCount	(I)V
    //   1390: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1393: ifeq +32 -> 1425
    //   1396: ldc 13
    //   1398: iconst_2
    //   1399: new 91	java/lang/StringBuilder
    //   1402: dup
    //   1403: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   1406: ldc_w 2090
    //   1409: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1412: aload_0
    //   1413: invokevirtual 2093	com/tencent/mobileqq/data/MessageRecord:getRepeatCount	()I
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
    //   1453: invokeinterface 1836 1 0
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
    //   1592: invokeinterface 1836 1 0
    //   1597: ifle +20 -> 1617
    //   1600: aload_1
    //   1601: aload_2
    //   1602: invokestatic 2095	com/tencent/mobileqq/service/message/MessageProtoCodec:a	(Ljava/util/List;)Lcom/tencent/mobileqq/data/MessageRecord;
    //   1605: invokeinterface 375 2 0
    //   1610: pop
    //   1611: aload_2
    //   1612: invokeinterface 2098 1 0
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
    //   1664: getfield 2101	tencent/im/msg/im_msg_body$Text:attr_6_buf	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1667: invokevirtual 197	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   1670: ifeq +141 -> 1811
    //   1673: aload_2
    //   1674: getfield 234	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   1677: getfield 241	msf/msgcomm/msg_comm$MsgHead:from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1680: invokevirtual 245	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1683: aload_0
    //   1684: getfield 216	com/tencent/mobileqq/app/MessageHandler:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1687: invokevirtual 2104	com/tencent/mobileqq/app/QQAppInterface:getLongAccountUin	()J
    //   1690: lcmp
    //   1691: ifeq +120 -> 1811
    //   1694: aload 5
    //   1696: ifnull +115 -> 1811
    //   1699: aload 5
    //   1701: getfield 2109	com/tencent/mobileqq/troop/data/MessageInfo:a	Lcom/tencent/mobileqq/troop/data/MessageNavInfo;
    //   1704: lload 28
    //   1706: invokevirtual 2114	com/tencent/mobileqq/troop/data/MessageNavInfo:a	(J)Z
    //   1709: ifne +16 -> 1725
    //   1712: aload 5
    //   1714: getfield 2116	com/tencent/mobileqq/troop/data/MessageInfo:c	Lcom/tencent/mobileqq/troop/data/MessageNavInfo;
    //   1717: lload 28
    //   1719: invokevirtual 2114	com/tencent/mobileqq/troop/data/MessageNavInfo:a	(J)Z
    //   1722: ifeq +89 -> 1811
    //   1725: aload 49
    //   1727: getfield 937	tencent/im/msg/im_msg_body$Elem:text	Ltencent/im/msg/im_msg_body$Text;
    //   1730: getfield 2101	tencent/im/msg/im_msg_body$Text:attr_6_buf	Lcom/tencent/mobileqq/pb/PBBytesField;
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
    //   1794: invokespecial 2117	com/tencent/mobileqq/data/MessageForText$AtTroopMemberInfo:<init>	()V
    //   1797: astore 43
    //   1799: aload 43
    //   1801: aload 42
    //   1803: iload 12
    //   1805: invokevirtual 2121	com/tencent/mobileqq/data/MessageForText$AtTroopMemberInfo:readFrom	([BI)Z
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
    //   1843: getfield 2124	tencent/im/msg/im_msg_body$ElemFlags2:uint32_msg_rpt_cnt	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1846: invokevirtual 85	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1849: ifeq +5903 -> 7752
    //   1852: aload 49
    //   1854: getfield 74	tencent/im/msg/im_msg_body$Elem:elem_flags2	Ltencent/im/msg/im_msg_body$ElemFlags2;
    //   1857: getfield 2124	tencent/im/msg/im_msg_body$ElemFlags2:uint32_msg_rpt_cnt	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1860: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1863: istore 12
    //   1865: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1868: ifeq +30 -> 1898
    //   1871: ldc 13
    //   1873: iconst_2
    //   1874: new 91	java/lang/StringBuilder
    //   1877: dup
    //   1878: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   1881: ldc_w 2126
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
    //   1939: invokevirtual 2127	com/tencent/mobileqq/data/MessageForText$AtTroopMemberInfo:length	()I
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
    //   1968: invokevirtual 2130	com/tencent/mobileqq/data/MessageForText$AtTroopMemberInfo:isIncludingAll	()Z
    //   1971: ifeq +13 -> 1984
    //   1974: aload 5
    //   1976: getfield 2116	com/tencent/mobileqq/troop/data/MessageInfo:c	Lcom/tencent/mobileqq/troop/data/MessageNavInfo;
    //   1979: lload 28
    //   1981: putfield 2132	com/tencent/mobileqq/troop/data/MessageNavInfo:a	J
    //   1984: iload 15
    //   1986: istore 13
    //   1988: iload 14
    //   1990: istore 12
    //   1992: aload 43
    //   1994: aload_0
    //   1995: getfield 216	com/tencent/mobileqq/app/MessageHandler:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1998: invokevirtual 2104	com/tencent/mobileqq/app/QQAppInterface:getLongAccountUin	()J
    //   2001: invokevirtual 2135	com/tencent/mobileqq/data/MessageForText$AtTroopMemberInfo:isIncludingMe	(J)Z
    //   2004: ifeq -229 -> 1775
    //   2007: aload 5
    //   2009: getfield 2109	com/tencent/mobileqq/troop/data/MessageInfo:a	Lcom/tencent/mobileqq/troop/data/MessageNavInfo;
    //   2012: lload 28
    //   2014: putfield 2132	com/tencent/mobileqq/troop/data/MessageNavInfo:a	J
    //   2017: iload 15
    //   2019: istore 13
    //   2021: iload 14
    //   2023: istore 12
    //   2025: goto -250 -> 1775
    //   2028: aload 49
    //   2030: getfield 1071	tencent/im/msg/im_msg_body$Elem:shake_window	Ltencent/im/msg/im_msg_body$ShakeWindow;
    //   2033: invokevirtual 2136	tencent/im/msg/im_msg_body$ShakeWindow:has	()Z
    //   2036: ifeq +201 -> 2237
    //   2039: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2042: ifeq +12 -> 2054
    //   2045: aload 45
    //   2047: ldc_w 2138
    //   2050: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2053: pop
    //   2054: aload 49
    //   2056: getfield 1071	tencent/im/msg/im_msg_body$Elem:shake_window	Ltencent/im/msg/im_msg_body$ShakeWindow;
    //   2059: invokevirtual 2139	tencent/im/msg/im_msg_body$ShakeWindow:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2062: checkcast 1058	tencent/im/msg/im_msg_body$ShakeWindow
    //   2065: astore 42
    //   2067: sipush -2020
    //   2070: invokestatic 399	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   2073: checkcast 1052	com/tencent/mobileqq/data/MessageForShakeWindow
    //   2076: astore 43
    //   2078: aload 43
    //   2080: sipush -2020
    //   2083: putfield 2140	com/tencent/mobileqq/data/MessageForShakeWindow:msgtype	I
    //   2086: aload 43
    //   2088: ldc_w 2142
    //   2091: putfield 2143	com/tencent/mobileqq/data/MessageForShakeWindow:msg	Ljava/lang/String;
    //   2094: aload 47
    //   2096: iconst_0
    //   2097: aload 47
    //   2099: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   2102: invokevirtual 126	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   2105: pop
    //   2106: new 1064	com/tencent/mobileqq/data/ShakeWindowMsg
    //   2109: dup
    //   2110: invokespecial 2144	com/tencent/mobileqq/data/ShakeWindowMsg:<init>	()V
    //   2113: astore 44
    //   2115: aload 44
    //   2117: aload 42
    //   2119: getfield 1062	tencent/im/msg/im_msg_body$ShakeWindow:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2122: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2125: putfield 1067	com/tencent/mobileqq/data/ShakeWindowMsg:mType	I
    //   2128: aload 44
    //   2130: aload 42
    //   2132: getfield 2147	tencent/im/msg/im_msg_body$ShakeWindow:uint32_reserve	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2135: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2138: putfield 2150	com/tencent/mobileqq/data/ShakeWindowMsg:mReserve	I
    //   2141: iload 4
    //   2143: ifeq +75 -> 2218
    //   2146: iconst_2
    //   2147: istore 12
    //   2149: aload 44
    //   2151: iload 12
    //   2153: putfield 2153	com/tencent/mobileqq/data/ShakeWindowMsg:onlineFlag	I
    //   2156: aload 44
    //   2158: iconst_1
    //   2159: putfield 2156	com/tencent/mobileqq/data/ShakeWindowMsg:shake	Z
    //   2162: aload 43
    //   2164: aload 44
    //   2166: invokevirtual 2157	com/tencent/mobileqq/data/ShakeWindowMsg:getBytes	()[B
    //   2169: putfield 2158	com/tencent/mobileqq/data/MessageForShakeWindow:msgData	[B
    //   2172: aload 43
    //   2174: getfield 2158	com/tencent/mobileqq/data/MessageForShakeWindow:msgData	[B
    //   2177: ifnonnull +47 -> 2224
    //   2180: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2183: ifeq +12 -> 2195
    //   2186: aload 45
    //   2188: ldc_w 2080
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
    //   2242: invokevirtual 2159	tencent/im/msg/im_msg_body$Face:has	()Z
    //   2245: ifeq +123 -> 2368
    //   2248: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2251: ifeq +12 -> 2263
    //   2254: aload 45
    //   2256: ldc_w 2161
    //   2259: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2262: pop
    //   2263: iload 8
    //   2265: istore 12
    //   2267: aload 49
    //   2269: getfield 178	tencent/im/msg/im_msg_body$Elem:face	Ltencent/im/msg/im_msg_body$Face;
    //   2272: invokevirtual 2162	tencent/im/msg/im_msg_body$Face:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2275: checkcast 165	tencent/im/msg/im_msg_body$Face
    //   2278: getfield 169	tencent/im/msg/im_msg_body$Face:index	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2281: invokevirtual 85	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   2284: ifeq +5279 -> 7563
    //   2287: aload 49
    //   2289: getfield 178	tencent/im/msg/im_msg_body$Elem:face	Ltencent/im/msg/im_msg_body$Face;
    //   2292: invokevirtual 2162	tencent/im/msg/im_msg_body$Face:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2295: checkcast 165	tencent/im/msg/im_msg_body$Face
    //   2298: getfield 169	tencent/im/msg/im_msg_body$Face:index	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2301: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2304: istore 12
    //   2306: iload 12
    //   2308: getstatic 2164	com/tencent/mobileqq/service/message/MessageUtils:b	[S
    //   2311: arraylength
    //   2312: if_icmpge +33 -> 2345
    //   2315: getstatic 2164	com/tencent/mobileqq/service/message/MessageUtils:b	[S
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
    //   2370: getfield 2168	tencent/im/msg/im_msg_body$Elem:online_image	Ltencent/im/msg/im_msg_body$OnlineImage;
    //   2373: invokevirtual 2171	tencent/im/msg/im_msg_body$OnlineImage:has	()Z
    //   2376: ifeq +72 -> 2448
    //   2379: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2382: ifeq +12 -> 2394
    //   2385: aload 45
    //   2387: ldc_w 2173
    //   2390: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2393: pop
    //   2394: iload 8
    //   2396: istore 12
    //   2398: iload 6
    //   2400: ifne +5163 -> 7563
    //   2403: aload 47
    //   2405: invokestatic 1624	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   2408: ldc_w 2174
    //   2411: invokevirtual 1631	android/content/Context:getString	(I)Ljava/lang/String;
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
    //   2450: getfield 1636	tencent/im/msg/im_msg_body$Elem:not_online_image	Ltencent/im/msg/im_msg_body$NotOnlineImage;
    //   2453: invokevirtual 1639	tencent/im/msg/im_msg_body$NotOnlineImage:has	()Z
    //   2456: ifeq +974 -> 3430
    //   2459: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2462: ifeq +12 -> 2474
    //   2465: aload 45
    //   2467: ldc_w 2176
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
    //   2498: putfield 1789	com/tencent/mobileqq/data/MessageForText:msgtype	I
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
    //   2533: invokestatic 1624	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   2536: ldc_w 2174
    //   2539: invokevirtual 1631	android/content/Context:getString	(I)Ljava/lang/String;
    //   2542: pop
    //   2543: aload 49
    //   2545: getfield 1636	tencent/im/msg/im_msg_body$Elem:not_online_image	Ltencent/im/msg/im_msg_body$NotOnlineImage;
    //   2548: invokevirtual 1644	tencent/im/msg/im_msg_body$NotOnlineImage:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2551: checkcast 1638	tencent/im/msg/im_msg_body$NotOnlineImage
    //   2554: astore 50
    //   2556: aload 50
    //   2558: getfield 1647	tencent/im/msg/im_msg_body$NotOnlineImage:file_len	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2561: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2564: istore 13
    //   2566: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2569: ifeq +30 -> 2599
    //   2572: ldc 13
    //   2574: iconst_2
    //   2575: new 91	java/lang/StringBuilder
    //   2578: dup
    //   2579: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   2582: ldc_w 2178
    //   2585: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2588: iload 13
    //   2590: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2593: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2596: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2599: aload 50
    //   2601: getfield 2181	tencent/im/msg/im_msg_body$NotOnlineImage:flag	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2604: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2607: invokevirtual 257	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2610: pop
    //   2611: aload 50
    //   2613: getfield 2182	tencent/im/msg/im_msg_body$NotOnlineImage:str_thumb_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2616: invokevirtual 270	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2619: astore 51
    //   2621: aload 50
    //   2623: getfield 2185	tencent/im/msg/im_msg_body$NotOnlineImage:uint32_thumb_width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2626: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2629: istore 14
    //   2631: aload 50
    //   2633: getfield 2188	tencent/im/msg/im_msg_body$NotOnlineImage:uint32_thumb_height	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2636: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2639: istore 15
    //   2641: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2644: ifeq +41 -> 2685
    //   2647: ldc 13
    //   2649: iconst_2
    //   2650: new 91	java/lang/StringBuilder
    //   2653: dup
    //   2654: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   2657: ldc_w 2190
    //   2660: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2663: iload 14
    //   2665: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2668: ldc_w 2192
    //   2671: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2674: iload 15
    //   2676: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2679: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2682: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2685: aload 50
    //   2687: getfield 2193	tencent/im/msg/im_msg_body$NotOnlineImage:uint32_file_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2690: invokevirtual 85	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   2693: ifeq +5100 -> 7793
    //   2696: aload 50
    //   2698: getfield 2193	tencent/im/msg/im_msg_body$NotOnlineImage:uint32_file_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2701: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2704: istore 12
    //   2706: aload 50
    //   2708: getfield 2194	tencent/im/msg/im_msg_body$NotOnlineImage:str_big_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2711: invokevirtual 270	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2714: astore 52
    //   2716: aload 50
    //   2718: getfield 2195	tencent/im/msg/im_msg_body$NotOnlineImage:str_orig_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2721: invokevirtual 270	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2724: astore 53
    //   2726: aload 50
    //   2728: getfield 2198	tencent/im/msg/im_msg_body$NotOnlineImage:pic_width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2731: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2734: istore 16
    //   2736: aload 50
    //   2738: getfield 2201	tencent/im/msg/im_msg_body$NotOnlineImage:pic_height	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2741: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2744: istore 18
    //   2746: aload 50
    //   2748: getfield 2204	tencent/im/msg/im_msg_body$NotOnlineImage:original	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2751: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2754: istore 19
    //   2756: aload 50
    //   2758: getfield 2207	tencent/im/msg/im_msg_body$NotOnlineImage:res_id	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2761: invokevirtual 197	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   2764: ifeq +414 -> 3178
    //   2767: aload 50
    //   2769: getfield 2207	tencent/im/msg/im_msg_body$NotOnlineImage:res_id	Lcom/tencent/mobileqq/pb/PBBytesField;
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
    //   2807: getfield 2210	tencent/im/msg/im_msg_body$NotOnlineImage:pic_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2810: invokevirtual 197	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   2813: ifeq +42 -> 2855
    //   2816: aload 50
    //   2818: getfield 2210	tencent/im/msg/im_msg_body$NotOnlineImage:pic_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
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
    //   2866: ldc_w 2212
    //   2869: aload 51
    //   2871: aload 52
    //   2873: aload 53
    //   2875: iload 19
    //   2877: iconst_0
    //   2878: invokestatic 2215	com/tencent/mobileqq/transfile/TransfileUtile:a	(Ljava/lang/String;JIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)Ljava/lang/String;
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
    //   2943: getfield 2218	localpb/richMsg/RichMsg$PicRec:md5	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2946: aload 43
    //   2948: invokevirtual 371	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   2951: aload 44
    //   2953: getfield 1466	localpb/richMsg/RichMsg$PicRec:serverStorageSource	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2956: ldc_w 2212
    //   2959: invokevirtual 371	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   2962: aload 44
    //   2964: getfield 2221	localpb/richMsg/RichMsg$PicRec:thumbMsgUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2967: aload 51
    //   2969: invokevirtual 371	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   2972: aload 44
    //   2974: getfield 2222	localpb/richMsg/RichMsg$PicRec:uint32_thumb_width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2977: iload 14
    //   2979: invokevirtual 173	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   2982: aload 44
    //   2984: getfield 2223	localpb/richMsg/RichMsg$PicRec:uint32_thumb_height	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2987: iload 15
    //   2989: invokevirtual 173	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   2992: aload 44
    //   2994: getfield 2226	localpb/richMsg/RichMsg$PicRec:uint32_width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2997: iload 16
    //   2999: invokevirtual 173	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   3002: aload 44
    //   3004: getfield 2229	localpb/richMsg/RichMsg$PicRec:uint32_height	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3007: iload 18
    //   3009: invokevirtual 173	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   3012: aload 50
    //   3014: getfield 2193	tencent/im/msg/im_msg_body$NotOnlineImage:uint32_file_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3017: invokevirtual 85	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   3020: ifeq +14 -> 3034
    //   3023: aload 44
    //   3025: getfield 2232	localpb/richMsg/RichMsg$PicRec:groupFileID	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   3028: iload 12
    //   3030: i2l
    //   3031: invokevirtual 581	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   3034: aload 44
    //   3036: getfield 2235	localpb/richMsg/RichMsg$PicRec:bigMsgUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3039: aload 52
    //   3041: invokevirtual 371	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   3044: aload 44
    //   3046: getfield 2238	localpb/richMsg/RichMsg$PicRec:rawMsgUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3049: aload 53
    //   3051: invokevirtual 371	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   3054: aload 44
    //   3056: getfield 2241	localpb/richMsg/RichMsg$PicRec:fileSizeFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   3059: iload 19
    //   3061: invokevirtual 1475	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   3064: aload 44
    //   3066: getfield 2244	localpb/richMsg/RichMsg$PicRec:uiOperatorFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
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
    //   3099: ldc_w 2246
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
    //   3180: getfield 1650	tencent/im/msg/im_msg_body$NotOnlineImage:download_path	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3183: invokevirtual 197	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   3186: ifeq +4601 -> 7787
    //   3189: aload 50
    //   3191: getfield 1650	tencent/im/msg/im_msg_body$NotOnlineImage:download_path	Lcom/tencent/mobileqq/pb/PBBytesField;
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
    //   3220: ldc_w 2248
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
    //   3302: new 2250	java/util/HashMap
    //   3305: dup
    //   3306: invokespecial 2251	java/util/HashMap:<init>	()V
    //   3309: astore 42
    //   3311: aload 42
    //   3313: ldc_w 2253
    //   3316: sipush 10002
    //   3319: invokestatic 2255	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   3322: invokevirtual 2259	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3325: pop
    //   3326: aload 42
    //   3328: ldc_w 2261
    //   3331: lload 30
    //   3333: invokestatic 465	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   3336: invokevirtual 2259	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3339: pop
    //   3340: aload 42
    //   3342: ldc_w 2263
    //   3345: lload 32
    //   3347: invokestatic 465	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   3350: invokevirtual 2259	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3353: pop
    //   3354: aload 42
    //   3356: ldc_w 2265
    //   3359: lload 22
    //   3361: invokestatic 465	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   3364: invokevirtual 2259	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3367: pop
    //   3368: aload 42
    //   3370: ldc_w 2266
    //   3373: lload 24
    //   3375: invokestatic 465	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   3378: invokevirtual 2259	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3381: pop
    //   3382: aload 42
    //   3384: ldc_w 2268
    //   3387: lload 26
    //   3389: invokestatic 465	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   3392: invokevirtual 2259	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3395: pop
    //   3396: aload_0
    //   3397: getfield 216	com/tencent/mobileqq/app/MessageHandler:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3400: invokevirtual 220	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   3403: astore 43
    //   3405: invokestatic 1624	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   3408: invokestatic 2273	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   3411: aload 43
    //   3413: ldc_w 2275
    //   3416: iconst_0
    //   3417: lconst_0
    //   3418: lconst_0
    //   3419: aload 42
    //   3421: ldc_w 281
    //   3424: invokevirtual 2278	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   3427: goto -272 -> 3155
    //   3430: aload 49
    //   3432: getfield 2282	tencent/im/msg/im_msg_body$Elem:trans_elem_info	Ltencent/im/msg/im_msg_body$TransElem;
    //   3435: invokevirtual 2285	tencent/im/msg/im_msg_body$TransElem:has	()Z
    //   3438: ifeq +1178 -> 4616
    //   3441: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3444: ifeq +12 -> 3456
    //   3447: aload 45
    //   3449: ldc_w 2287
    //   3452: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3455: pop
    //   3456: aload 49
    //   3458: getfield 2282	tencent/im/msg/im_msg_body$Elem:trans_elem_info	Ltencent/im/msg/im_msg_body$TransElem;
    //   3461: invokevirtual 2288	tencent/im/msg/im_msg_body$TransElem:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3464: checkcast 2284	tencent/im/msg/im_msg_body$TransElem
    //   3467: astore 42
    //   3469: aload 42
    //   3471: getfield 2291	tencent/im/msg/im_msg_body$TransElem:elem_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3474: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3477: istore 12
    //   3479: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3482: ifeq +23 -> 3505
    //   3485: aload 45
    //   3487: ldc_w 2293
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
    //   3535: putfield 1789	com/tencent/mobileqq/data/MessageForText:msgtype	I
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
    //   3572: getfield 2296	tencent/im/msg/im_msg_body$TransElem:elem_value	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3575: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3578: invokevirtual 257	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   3581: astore 43
    //   3583: aload 43
    //   3585: ifnull +9 -> 3594
    //   3588: aload 43
    //   3590: arraylength
    //   3591: ifne +75 -> 3666
    //   3594: aload 45
    //   3596: ldc_w 2298
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
    //   3758: invokestatic 1624	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   3761: ldc_w 2174
    //   3764: invokevirtual 1631	android/content/Context:getString	(I)Ljava/lang/String;
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
    //   3844: invokestatic 2301	com/tencent/mobileqq/service/message/MessageProtoCodec:a	([B)[B
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
    //   3882: ldc_w 2055
    //   3885: invokespecial 2058	java/lang/String:<init>	([BLjava/lang/String;)V
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
    //   3908: invokestatic 2302	com/tencent/mobileqq/service/message/MessageProtoCodec:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/PAMessage;
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
    //   3999: getfield 2305	tencent/im/msg/im_msg_body$ElemFlags2:uint64_msg_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   4002: invokevirtual 2043	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   4005: ifeq -70 -> 3935
    //   4008: aload 38
    //   4010: astore 43
    //   4012: aload 38
    //   4014: aload 42
    //   4016: getfield 74	tencent/im/msg/im_msg_body$Elem:elem_flags2	Ltencent/im/msg/im_msg_body$ElemFlags2;
    //   4019: invokevirtual 78	tencent/im/msg/im_msg_body$ElemFlags2:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4022: checkcast 76	tencent/im/msg/im_msg_body$ElemFlags2
    //   4025: getfield 2305	tencent/im/msg/im_msg_body$ElemFlags2:uint64_msg_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   4028: invokevirtual 245	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   4031: putfield 2310	com/tencent/mobileqq/data/PAMessage:mMsgId	J
    //   4034: goto -99 -> 3935
    //   4037: astore 38
    //   4039: aload 38
    //   4041: invokevirtual 2073	java/lang/Exception:printStackTrace	()V
    //   4044: aload 43
    //   4046: astore 42
    //   4048: aload 42
    //   4050: ifnull +59 -> 4109
    //   4053: sipush -3006
    //   4056: invokestatic 399	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   4059: checkcast 2062	com/tencent/mobileqq/data/MessageForPubAccount
    //   4062: astore 38
    //   4064: aload 38
    //   4066: sipush -3006
    //   4069: putfield 2063	com/tencent/mobileqq/data/MessageForPubAccount:msgtype	I
    //   4072: aload 38
    //   4074: aload 47
    //   4076: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4079: putfield 2064	com/tencent/mobileqq/data/MessageForPubAccount:msg	Ljava/lang/String;
    //   4082: aload 38
    //   4084: aload 42
    //   4086: putfield 2068	com/tencent/mobileqq/data/MessageForPubAccount:mPAMessage	Lcom/tencent/mobileqq/data/PAMessage;
    //   4089: aload 38
    //   4091: aload 42
    //   4093: invokestatic 2071	com/tencent/biz/pubaccount/util/PAMessageUtil:a	(Lcom/tencent/mobileqq/data/PAMessage;)[B
    //   4096: putfield 2072	com/tencent/mobileqq/data/MessageForPubAccount:msgData	[B
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
    //   4132: invokevirtual 2073	java/lang/Exception:printStackTrace	()V
    //   4135: goto -46 -> 4089
    //   4138: astore 43
    //   4140: aload 43
    //   4142: invokevirtual 2073	java/lang/Exception:printStackTrace	()V
    //   4145: goto -46 -> 4099
    //   4148: aload 42
    //   4150: getfield 2296	tencent/im/msg/im_msg_body$TransElem:elem_value	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4153: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4156: invokevirtual 1694	com/tencent/mobileqq/pb/ByteStringMicro:size	()I
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
    //   4279: new 2312	tencent/im/msg/obj_msg$ObjMsg
    //   4282: dup
    //   4283: invokespecial 2313	tencent/im/msg/obj_msg$ObjMsg:<init>	()V
    //   4286: astore 44
    //   4288: aload 44
    //   4290: aload 42
    //   4292: invokevirtual 2314	tencent/im/msg/obj_msg$ObjMsg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4295: checkcast 2312	tencent/im/msg/obj_msg$ObjMsg
    //   4298: astore 42
    //   4300: aload 42
    //   4302: getfield 2317	tencent/im/msg/obj_msg$ObjMsg:uint32_msg_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4305: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4308: i2l
    //   4309: ldc2_w 2318
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
    //   4348: new 2321	com/tencent/mobileqq/data/TroopFileData
    //   4351: dup
    //   4352: invokespecial 2322	com/tencent/mobileqq/data/TroopFileData:<init>	()V
    //   4355: astore 43
    //   4357: aload 43
    //   4359: new 94	java/lang/String
    //   4362: dup
    //   4363: aload 42
    //   4365: getfield 2325	tencent/im/msg/obj_msg$ObjMsg:msg_content_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4368: iconst_0
    //   4369: invokevirtual 2328	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4372: checkcast 2330	tencent/im/msg/obj_msg$MsgContentInfo
    //   4375: getfield 2334	tencent/im/msg/obj_msg$MsgContentInfo:msg_file	Ltencent/im/msg/obj_msg$MsgContentInfo$MsgFile;
    //   4378: getfield 2339	tencent/im/msg/obj_msg$MsgContentInfo$MsgFile:bytes_file_path	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4381: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4384: invokevirtual 257	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   4387: invokespecial 2341	java/lang/String:<init>	([B)V
    //   4390: putfield 2344	com/tencent/mobileqq/data/TroopFileData:fileUrl	Ljava/lang/String;
    //   4393: aload 43
    //   4395: aload 42
    //   4397: getfield 2325	tencent/im/msg/obj_msg$ObjMsg:msg_content_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4400: iconst_0
    //   4401: invokevirtual 2328	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4404: checkcast 2330	tencent/im/msg/obj_msg$MsgContentInfo
    //   4407: getfield 2334	tencent/im/msg/obj_msg$MsgContentInfo:msg_file	Ltencent/im/msg/obj_msg$MsgContentInfo$MsgFile;
    //   4410: getfield 2347	tencent/im/msg/obj_msg$MsgContentInfo$MsgFile:uint32_bus_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4413: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4416: putfield 2350	com/tencent/mobileqq/data/TroopFileData:bisID	I
    //   4419: aload 43
    //   4421: aload 42
    //   4423: getfield 2325	tencent/im/msg/obj_msg$ObjMsg:msg_content_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4426: iconst_0
    //   4427: invokevirtual 2328	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4430: checkcast 2330	tencent/im/msg/obj_msg$MsgContentInfo
    //   4433: getfield 2334	tencent/im/msg/obj_msg$MsgContentInfo:msg_file	Ltencent/im/msg/obj_msg$MsgContentInfo$MsgFile;
    //   4436: getfield 2353	tencent/im/msg/obj_msg$MsgContentInfo$MsgFile:str_file_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   4439: invokevirtual 270	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   4442: putfield 2356	com/tencent/mobileqq/data/TroopFileData:fileName	Ljava/lang/String;
    //   4445: aload 43
    //   4447: aload 42
    //   4449: getfield 2325	tencent/im/msg/obj_msg$ObjMsg:msg_content_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4452: iconst_0
    //   4453: invokevirtual 2328	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4456: checkcast 2330	tencent/im/msg/obj_msg$MsgContentInfo
    //   4459: getfield 2334	tencent/im/msg/obj_msg$MsgContentInfo:msg_file	Ltencent/im/msg/obj_msg$MsgContentInfo$MsgFile;
    //   4462: getfield 2357	tencent/im/msg/obj_msg$MsgContentInfo$MsgFile:uint64_file_size	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   4465: invokevirtual 245	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   4468: putfield 2360	com/tencent/mobileqq/data/TroopFileData:lfileSize	J
    //   4471: aload 43
    //   4473: new 94	java/lang/String
    //   4476: dup
    //   4477: aload 42
    //   4479: getfield 2363	tencent/im/msg/obj_msg$ObjMsg:bytes_title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4482: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4485: invokevirtual 257	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   4488: invokespecial 2341	java/lang/String:<init>	([B)V
    //   4491: putfield 2366	com/tencent/mobileqq/data/TroopFileData:dspFileName	Ljava/lang/String;
    //   4494: aload 43
    //   4496: new 94	java/lang/String
    //   4499: dup
    //   4500: aload 42
    //   4502: getfield 2369	tencent/im/msg/obj_msg$ObjMsg:rpt_bytes_abstact	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4505: iconst_0
    //   4506: invokevirtual 2370	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   4509: checkcast 253	com/tencent/mobileqq/pb/ByteStringMicro
    //   4512: invokevirtual 257	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   4515: invokespecial 2341	java/lang/String:<init>	([B)V
    //   4518: putfield 2373	com/tencent/mobileqq/data/TroopFileData:dspFileSize	Ljava/lang/String;
    //   4521: aload 47
    //   4523: ldc_w 2375
    //   4526: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4529: pop
    //   4530: sipush -2017
    //   4533: invokestatic 399	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   4536: checkcast 2377	com/tencent/mobileqq/data/MessageForTroopFile
    //   4539: astore 42
    //   4541: aload 42
    //   4543: sipush -2017
    //   4546: putfield 2378	com/tencent/mobileqq/data/MessageForTroopFile:msgtype	I
    //   4549: aload 42
    //   4551: aload 47
    //   4553: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4556: putfield 2379	com/tencent/mobileqq/data/MessageForTroopFile:msg	Ljava/lang/String;
    //   4559: aload 42
    //   4561: aload 43
    //   4563: invokestatic 2384	com/tencent/mobileqq/app/utils/MessagePkgUtils:a	(Ljava/io/Serializable;)[B
    //   4566: putfield 2385	com/tencent/mobileqq/data/MessageForTroopFile:msgData	[B
    //   4569: aload 42
    //   4571: invokevirtual 2386	com/tencent/mobileqq/data/MessageForTroopFile:parse	()V
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
    //   4610: invokevirtual 2073	java/lang/Exception:printStackTrace	()V
    //   4613: goto -44 -> 4569
    //   4616: aload 49
    //   4618: getfield 1197	tencent/im/msg/im_msg_body$Elem:market_face	Ltencent/im/msg/im_msg_body$MarketFace;
    //   4621: invokevirtual 2387	tencent/im/msg/im_msg_body$MarketFace:has	()Z
    //   4624: ifeq +432 -> 5056
    //   4627: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4630: ifeq +12 -> 4642
    //   4633: aload 45
    //   4635: ldc_w 2389
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
    //   4666: putfield 1789	com/tencent/mobileqq/data/MessageForText:msgtype	I
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
    //   4706: invokevirtual 2390	tencent/im/msg/im_msg_body$MarketFace:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4709: checkcast 1129	tencent/im/msg/im_msg_body$MarketFace
    //   4712: astore 42
    //   4714: aload 42
    //   4716: ifnull +312 -> 5028
    //   4719: new 1038	com/tencent/qqlite/data/MarkFaceMessage
    //   4722: dup
    //   4723: invokespecial 2391	com/tencent/qqlite/data/MarkFaceMessage:<init>	()V
    //   4726: astore 39
    //   4728: aload 39
    //   4730: aload 42
    //   4732: getfield 1148	tencent/im/msg/im_msg_body$MarketFace:uint32_face_info	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4735: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4738: putfield 1151	com/tencent/qqlite/data/MarkFaceMessage:cFaceInfo	I
    //   4741: aload 39
    //   4743: iload 17
    //   4745: i2l
    //   4746: putfield 2393	com/tencent/qqlite/data/MarkFaceMessage:index	J
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
    //   4883: ldc_w 2395
    //   4886: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4889: aload 39
    //   4891: getfield 1175	com/tencent/qqlite/data/MarkFaceMessage:mediaType	I
    //   4894: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4897: pop
    //   4898: aload 47
    //   4900: ldc_w 2397
    //   4903: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4906: pop
    //   4907: sipush -2007
    //   4910: invokestatic 399	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   4913: checkcast 1030	com/tencent/mobileqq/data/MessageForMarketFace
    //   4916: astore 42
    //   4918: aload 42
    //   4920: sipush -2007
    //   4923: putfield 2398	com/tencent/mobileqq/data/MessageForMarketFace:msgtype	I
    //   4926: aload 42
    //   4928: aload 47
    //   4930: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4933: putfield 2399	com/tencent/mobileqq/data/MessageForMarketFace:msg	Ljava/lang/String;
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
    //   4964: ldc_w 2401
    //   4967: ldc_w 281
    //   4970: ldc_w 281
    //   4973: ldc_w 2403
    //   4976: ldc_w 2405
    //   4979: iconst_0
    //   4980: iconst_0
    //   4981: ldc_w 281
    //   4984: ldc_w 281
    //   4987: ldc_w 281
    //   4990: ldc_w 281
    //   4993: invokestatic 2410	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   4996: aload 42
    //   4998: aload 39
    //   5000: invokestatic 2384	com/tencent/mobileqq/app/utils/MessagePkgUtils:a	(Ljava/io/Serializable;)[B
    //   5003: putfield 2411	com/tencent/mobileqq/data/MessageForMarketFace:msgData	[B
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
    //   5050: invokevirtual 2073	java/lang/Exception:printStackTrace	()V
    //   5053: goto -47 -> 5006
    //   5056: aload 49
    //   5058: getfield 1706	tencent/im/msg/im_msg_body$Elem:custom_face	Ltencent/im/msg/im_msg_body$CustomFace;
    //   5061: invokevirtual 1709	tencent/im/msg/im_msg_body$CustomFace:has	()Z
    //   5064: ifeq +1032 -> 6096
    //   5067: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5070: ifeq +22 -> 5092
    //   5073: aload 45
    //   5075: ldc_w 2413
    //   5078: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5081: iload_3
    //   5082: invokevirtual 202	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5085: ldc_w 1431
    //   5088: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5091: pop
    //   5092: iload_3
    //   5093: ifeq +270 -> 5363
    //   5096: aload 47
    //   5098: invokestatic 1624	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   5101: ldc_w 2174
    //   5104: invokevirtual 1631	android/content/Context:getString	(I)Ljava/lang/String;
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
    //   5175: new 2250	java/util/HashMap
    //   5178: dup
    //   5179: invokespecial 2251	java/util/HashMap:<init>	()V
    //   5182: astore 42
    //   5184: aload 42
    //   5186: ldc_w 2253
    //   5189: sipush 10001
    //   5192: invokestatic 2255	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   5195: invokevirtual 2259	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   5198: pop
    //   5199: aload 42
    //   5201: ldc_w 2261
    //   5204: lload 30
    //   5206: invokestatic 465	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   5209: invokevirtual 2259	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   5212: pop
    //   5213: aload 42
    //   5215: ldc_w 2263
    //   5218: lload 32
    //   5220: invokestatic 465	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   5223: invokevirtual 2259	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   5226: pop
    //   5227: aload 42
    //   5229: ldc_w 2265
    //   5232: lload 22
    //   5234: invokestatic 465	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   5237: invokevirtual 2259	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   5240: pop
    //   5241: aload 42
    //   5243: ldc_w 2266
    //   5246: lload 24
    //   5248: invokestatic 465	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   5251: invokevirtual 2259	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   5254: pop
    //   5255: aload 42
    //   5257: ldc_w 2268
    //   5260: lload 26
    //   5262: invokestatic 465	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   5265: invokevirtual 2259	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   5268: pop
    //   5269: aload_0
    //   5270: getfield 216	com/tencent/mobileqq/app/MessageHandler:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5273: invokevirtual 220	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   5276: astore 43
    //   5278: invokestatic 1624	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   5281: invokestatic 2273	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   5284: aload 43
    //   5286: ldc_w 2275
    //   5289: iconst_0
    //   5290: lconst_0
    //   5291: lconst_0
    //   5292: aload 42
    //   5294: ldc_w 281
    //   5297: invokevirtual 2278	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
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
    //   5387: putfield 1789	com/tencent/mobileqq/data/MessageForText:msgtype	I
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
    //   5424: getfield 1706	tencent/im/msg/im_msg_body$Elem:custom_face	Ltencent/im/msg/im_msg_body$CustomFace;
    //   5427: invokevirtual 1710	tencent/im/msg/im_msg_body$CustomFace:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   5430: checkcast 1708	tencent/im/msg/im_msg_body$CustomFace
    //   5433: astore 52
    //   5435: aload 52
    //   5437: getfield 1713	tencent/im/msg/im_msg_body$CustomFace:str_file_path	Lcom/tencent/mobileqq/pb/PBStringField;
    //   5440: invokevirtual 270	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   5443: astore 42
    //   5445: aload 52
    //   5447: getfield 1716	tencent/im/msg/im_msg_body$CustomFace:str_shortcut	Lcom/tencent/mobileqq/pb/PBStringField;
    //   5450: invokevirtual 270	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   5453: pop
    //   5454: aload 52
    //   5456: getfield 1719	tencent/im/msg/im_msg_body$CustomFace:str_big_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   5459: invokevirtual 270	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   5462: astore 43
    //   5464: aload 52
    //   5466: getfield 1722	tencent/im/msg/im_msg_body$CustomFace:str_orig_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   5469: invokevirtual 270	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   5472: astore 44
    //   5474: aload 52
    //   5476: getfield 1725	tencent/im/msg/im_msg_body$CustomFace:str_thumb_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   5479: invokevirtual 270	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   5482: astore 50
    //   5484: aload 52
    //   5486: getfield 2414	tencent/im/msg/im_msg_body$CustomFace:uint32_thumb_width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5489: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5492: istore 12
    //   5494: aload 52
    //   5496: getfield 2415	tencent/im/msg/im_msg_body$CustomFace:uint32_thumb_height	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5499: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5502: istore 13
    //   5504: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5507: ifeq +41 -> 5548
    //   5510: ldc 13
    //   5512: iconst_2
    //   5513: new 91	java/lang/StringBuilder
    //   5516: dup
    //   5517: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   5520: ldc_w 2417
    //   5523: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5526: iload 12
    //   5528: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5531: ldc_w 2192
    //   5534: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5537: iload 13
    //   5539: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5542: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5545: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5548: aload 52
    //   5550: getfield 1728	tencent/im/msg/im_msg_body$CustomFace:uint32_file_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5553: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5556: i2l
    //   5557: lstore 22
    //   5559: aload 52
    //   5561: getfield 1729	tencent/im/msg/im_msg_body$CustomFace:uint32_file_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5564: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5567: i2l
    //   5568: lstore 24
    //   5570: aload 52
    //   5572: getfield 1732	tencent/im/msg/im_msg_body$CustomFace:uint32_server_ip	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5575: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5578: i2l
    //   5579: lstore 24
    //   5581: aload 52
    //   5583: getfield 1735	tencent/im/msg/im_msg_body$CustomFace:uint32_server_port	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5586: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5589: i2l
    //   5590: lstore 24
    //   5592: aload 52
    //   5594: getfield 1738	tencent/im/msg/im_msg_body$CustomFace:uint32_useful	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5597: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5600: i2l
    //   5601: lstore 24
    //   5603: aload 52
    //   5605: getfield 2420	tencent/im/msg/im_msg_body$CustomFace:uint32_size	Lcom/tencent/mobileqq/pb/PBUInt32Field;
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
    //   5634: ldc_w 2422
    //   5637: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5640: lload 24
    //   5642: invokevirtual 277	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5645: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5648: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5651: aload 52
    //   5653: getfield 1741	tencent/im/msg/im_msg_body$CustomFace:bytes_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5656: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   5659: invokevirtual 257	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   5662: astore 51
    //   5664: aload 52
    //   5666: getfield 1744	tencent/im/msg/im_msg_body$CustomFace:bytes_signature	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5669: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   5672: invokevirtual 257	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   5675: astore 53
    //   5677: aload 52
    //   5679: getfield 1747	tencent/im/msg/im_msg_body$CustomFace:bytes_buffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5682: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   5685: invokevirtual 257	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   5688: pop
    //   5689: aload 52
    //   5691: getfield 1750	tencent/im/msg/im_msg_body$CustomFace:bytes_flag	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5694: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   5697: invokevirtual 257	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   5700: astore 54
    //   5702: aload 52
    //   5704: getfield 2423	tencent/im/msg/im_msg_body$CustomFace:uint32_width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5707: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5710: i2l
    //   5711: ldc2_w 9
    //   5714: land
    //   5715: l2i
    //   5716: istore 14
    //   5718: aload 52
    //   5720: getfield 2424	tencent/im/msg/im_msg_body$CustomFace:uint32_height	Lcom/tencent/mobileqq/pb/PBUInt32Field;
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
    //   5755: getfield 2427	tencent/im/msg/im_msg_body$CustomFace:uint32_origin	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5758: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5761: istore 16
    //   5763: aload 42
    //   5765: lconst_0
    //   5766: iconst_1
    //   5767: iconst_0
    //   5768: aload 42
    //   5770: aload 51
    //   5772: ldc_w 2212
    //   5775: aload 50
    //   5777: aload 43
    //   5779: aload 44
    //   5781: iload 16
    //   5783: iconst_0
    //   5784: invokestatic 2430	com/tencent/mobileqq/transfile/TranDbRecord$PicDbRecord:a	(Ljava/lang/String;JIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)Ljava/lang/String;
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
    //   5848: getfield 2232	localpb/richMsg/RichMsg$PicRec:groupFileID	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   5851: lload 22
    //   5853: ldc2_w 9
    //   5856: land
    //   5857: invokevirtual 581	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   5860: aload 52
    //   5862: getfield 2218	localpb/richMsg/RichMsg$PicRec:md5	Lcom/tencent/mobileqq/pb/PBStringField;
    //   5865: aload 51
    //   5867: invokevirtual 371	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   5870: aload 52
    //   5872: getfield 1466	localpb/richMsg/RichMsg$PicRec:serverStorageSource	Lcom/tencent/mobileqq/pb/PBStringField;
    //   5875: ldc_w 2212
    //   5878: invokevirtual 371	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   5881: aload 52
    //   5883: getfield 2221	localpb/richMsg/RichMsg$PicRec:thumbMsgUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   5886: aload 50
    //   5888: invokevirtual 371	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   5891: aload 52
    //   5893: getfield 2222	localpb/richMsg/RichMsg$PicRec:uint32_thumb_width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5896: iload 12
    //   5898: invokevirtual 173	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   5901: aload 52
    //   5903: getfield 2223	localpb/richMsg/RichMsg$PicRec:uint32_thumb_height	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5906: iload 13
    //   5908: invokevirtual 173	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   5911: aload 52
    //   5913: getfield 2226	localpb/richMsg/RichMsg$PicRec:uint32_width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5916: iload 14
    //   5918: invokevirtual 173	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   5921: aload 52
    //   5923: getfield 2229	localpb/richMsg/RichMsg$PicRec:uint32_height	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5926: iload 15
    //   5928: invokevirtual 173	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   5931: aload 52
    //   5933: getfield 2235	localpb/richMsg/RichMsg$PicRec:bigMsgUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   5936: aload 43
    //   5938: invokevirtual 371	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   5941: aload 52
    //   5943: getfield 2238	localpb/richMsg/RichMsg$PicRec:rawMsgUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   5946: aload 44
    //   5948: invokevirtual 371	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   5951: aload 52
    //   5953: getfield 2241	localpb/richMsg/RichMsg$PicRec:fileSizeFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5956: iconst_0
    //   5957: invokevirtual 1475	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   5960: aload 52
    //   5962: getfield 2244	localpb/richMsg/RichMsg$PicRec:uiOperatorFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
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
    //   5989: getfield 2241	localpb/richMsg/RichMsg$PicRec:fileSizeFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
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
    //   6101: invokevirtual 2431	tencent/im/msg/im_msg_body$FunFace:has	()Z
    //   6104: ifeq +45 -> 6149
    //   6107: iload 8
    //   6109: istore 12
    //   6111: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6114: ifeq +1449 -> 7563
    //   6117: aload 45
    //   6119: ldc_w 2433
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
    //   6151: getfield 2437	tencent/im/msg/im_msg_body$Elem:group_file	Ltencent/im/msg/im_msg_body$GroupFile;
    //   6154: invokevirtual 2440	tencent/im/msg/im_msg_body$GroupFile:has	()Z
    //   6157: ifeq +468 -> 6625
    //   6160: lconst_0
    //   6161: lstore 22
    //   6163: aload_2
    //   6164: getfield 234	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   6167: invokevirtual 237	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   6170: checkcast 236	msf/msgcomm/msg_comm$MsgHead
    //   6173: astore 42
    //   6175: aload 42
    //   6177: getfield 2444	msf/msgcomm/msg_comm$MsgHead:discuss_info	Lmsf/msgcomm/msg_comm$DiscussInfo;
    //   6180: invokevirtual 2447	msf/msgcomm/msg_comm$DiscussInfo:has	()Z
    //   6183: ifeq +22 -> 6205
    //   6186: aload 42
    //   6188: getfield 2444	msf/msgcomm/msg_comm$MsgHead:discuss_info	Lmsf/msgcomm/msg_comm$DiscussInfo;
    //   6191: invokevirtual 2448	msf/msgcomm/msg_comm$DiscussInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   6194: checkcast 2446	msf/msgcomm/msg_comm$DiscussInfo
    //   6197: getfield 2451	msf/msgcomm/msg_comm$DiscussInfo:discuss_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
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
    //   6241: invokevirtual 2104	com/tencent/mobileqq/app/QQAppInterface:getLongAccountUin	()J
    //   6244: lstore 32
    //   6246: aload 49
    //   6248: getfield 2437	tencent/im/msg/im_msg_body$Elem:group_file	Ltencent/im/msg/im_msg_body$GroupFile;
    //   6251: invokevirtual 2452	tencent/im/msg/im_msg_body$GroupFile:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   6254: checkcast 2439	tencent/im/msg/im_msg_body$GroupFile
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
    //   6280: invokestatic 2457	com/tencent/mobileqq/app/MessageHandlerUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;ILjava/lang/String;Ljava/lang/String;JJ)Z
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
    //   6360: getfield 2460	tencent/im/msg/im_msg_body$GroupFile:bytes_filename	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   6363: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   6366: invokevirtual 257	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   6369: ldc_w 2462
    //   6372: invokespecial 2058	java/lang/String:<init>	([BLjava/lang/String;)V
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
    //   6419: getfield 2466	tencent/im/msg/im_msg_body$RichText:attr	Ltencent/im/msg/im_msg_body$Attr;
    //   6422: invokevirtual 2469	tencent/im/msg/im_msg_body$Attr:has	()Z
    //   6425: ifeq +28 -> 6453
    //   6428: aload 43
    //   6430: getfield 40	tencent/im/msg/im_msg_body$MsgBody:rich_text	Ltencent/im/msg/im_msg_body$RichText;
    //   6433: getfield 2466	tencent/im/msg/im_msg_body$RichText:attr	Ltencent/im/msg/im_msg_body$Attr;
    //   6436: invokevirtual 2470	tencent/im/msg/im_msg_body$Attr:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   6439: checkcast 2468	tencent/im/msg/im_msg_body$Attr
    //   6442: getfield 2473	tencent/im/msg/im_msg_body$Attr:random	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   6445: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   6448: invokestatic 2476	com/tencent/mobileqq/service/message/MessageUtils:a	(I)J
    //   6451: lstore 24
    //   6453: sipush -2005
    //   6456: invokestatic 399	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   6459: checkcast 2478	com/tencent/mobileqq/data/MessageForFile
    //   6462: astore 43
    //   6464: aload 43
    //   6466: sipush -2005
    //   6469: putfield 2479	com/tencent/mobileqq/data/MessageForFile:msgtype	I
    //   6472: aload 43
    //   6474: aload_0
    //   6475: getfield 216	com/tencent/mobileqq/app/MessageHandler:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6478: invokevirtual 445	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/app/FileTransferHandler;
    //   6481: aload 43
    //   6483: getfield 2482	com/tencent/mobileqq/data/MessageForFile:uniseq	J
    //   6486: lload 22
    //   6488: lload 30
    //   6490: lload 36
    //   6492: lload 24
    //   6494: lload 34
    //   6496: aload 44
    //   6498: invokevirtual 2485	com/tencent/mobileqq/filemanager/app/FileTransferHandler:a	(JJJJJJLtencent/im/msg/im_msg_body$GroupFile;)J
    //   6501: putfield 2482	com/tencent/mobileqq/data/MessageForFile:uniseq	J
    //   6504: aload 44
    //   6506: getfield 2486	tencent/im/msg/im_msg_body$GroupFile:uint64_file_size	Lcom/tencent/mobileqq/pb/PBUInt64Field;
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
    //   6534: invokestatic 2489	com/tencent/mobileqq/transfile/TransfileUtile:a	(Ljava/lang/String;JIZ)Ljava/lang/String;
    //   6537: putfield 2490	com/tencent/mobileqq/data/MessageForFile:msg	Ljava/lang/String;
    //   6540: aload 43
    //   6542: invokevirtual 2493	com/tencent/mobileqq/data/MessageForFile:doParse	()V
    //   6545: aload_1
    //   6546: aload 43
    //   6548: invokeinterface 375 2 0
    //   6553: pop
    //   6554: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6557: ifeq +29 -> 6586
    //   6560: aload 45
    //   6562: ldc_w 2495
    //   6565: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6568: aload 44
    //   6570: getfield 2460	tencent/im/msg/im_msg_body$GroupFile:bytes_filename	Lcom/tencent/mobileqq/pb/PBBytesField;
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
    //   6613: invokevirtual 2496	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   6616: goto -235 -> 6381
    //   6619: iconst_0
    //   6620: istore 20
    //   6622: goto -97 -> 6525
    //   6625: aload 49
    //   6627: getfield 2500	tencent/im/msg/im_msg_body$Elem:market_trans	Ltencent/im/msg/im_msg_body$MarketTrans;
    //   6630: invokevirtual 2503	tencent/im/msg/im_msg_body$MarketTrans:has	()Z
    //   6633: ifeq +226 -> 6859
    //   6636: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6639: ifeq +12 -> 6651
    //   6642: aload 45
    //   6644: ldc_w 2505
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
    //   6675: putfield 1789	com/tencent/mobileqq/data/MessageForText:msgtype	I
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
    //   6712: getfield 2500	tencent/im/msg/im_msg_body$Elem:market_trans	Ltencent/im/msg/im_msg_body$MarketTrans;
    //   6715: invokevirtual 2506	tencent/im/msg/im_msg_body$MarketTrans:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   6718: checkcast 2502	tencent/im/msg/im_msg_body$MarketTrans
    //   6721: astore 42
    //   6723: aload 42
    //   6725: getfield 2509	tencent/im/msg/im_msg_body$MarketTrans:int32_flag	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6728: invokevirtual 2510	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6731: istore 9
    //   6733: aload 42
    //   6735: getfield 2513	tencent/im/msg/im_msg_body$MarketTrans:bytes_xml	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   6738: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   6741: invokevirtual 257	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   6744: iload 9
    //   6746: invokestatic 2516	com/tencent/mobileqq/structmsg/StructMsgFactory:a	([BI)Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
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
    //   6784: putfield 2035	com/tencent/mobileqq/data/MessageForStructing:msgtype	I
    //   6787: aload 43
    //   6789: ldc_w 2518
    //   6792: putfield 2078	com/tencent/mobileqq/data/MessageForStructing:msg	Ljava/lang/String;
    //   6795: aload 43
    //   6797: aload 42
    //   6799: putfield 1079	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   6802: aload 43
    //   6804: aload 43
    //   6806: getfield 1079	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   6809: invokevirtual 2074	com/tencent/mobileqq/structmsg/AbsStructMsg:getBytes	()[B
    //   6812: putfield 2075	com/tencent/mobileqq/data/MessageForStructing:msgData	[B
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
    //   6849: ldc_w 2080
    //   6852: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6855: pop
    //   6856: goto -32 -> 6824
    //   6859: aload 49
    //   6861: getfield 2522	tencent/im/msg/im_msg_body$Elem:video_file	Ltencent/im/msg/im_msg_body$VideoFile;
    //   6864: invokevirtual 2525	tencent/im/msg/im_msg_body$VideoFile:has	()Z
    //   6867: ifeq +364 -> 7231
    //   6870: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6873: ifeq +12 -> 6885
    //   6876: aload 45
    //   6878: ldc_w 2527
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
    //   6913: getfield 2522	tencent/im/msg/im_msg_body$Elem:video_file	Ltencent/im/msg/im_msg_body$VideoFile;
    //   6916: invokevirtual 2528	tencent/im/msg/im_msg_body$VideoFile:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   6919: checkcast 2524	tencent/im/msg/im_msg_body$VideoFile
    //   6922: astore 43
    //   6924: new 2530	localpb/richMsg/RichMsg$VideoFile
    //   6927: dup
    //   6928: invokespecial 2531	localpb/richMsg/RichMsg$VideoFile:<init>	()V
    //   6931: astore 42
    //   6933: aload 42
    //   6935: iconst_1
    //   6936: invokevirtual 2534	localpb/richMsg/RichMsg$VideoFile:setHasFlag	(Z)V
    //   6939: aload 42
    //   6941: getfield 2535	localpb/richMsg/RichMsg$VideoFile:bytes_file_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   6944: aload 43
    //   6946: getfield 2536	tencent/im/msg/im_msg_body$VideoFile:bytes_file_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   6949: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   6952: invokevirtual 591	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   6955: aload 42
    //   6957: getfield 2539	localpb/richMsg/RichMsg$VideoFile:bytes_file_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   6960: aload 43
    //   6962: getfield 2540	tencent/im/msg/im_msg_body$VideoFile:bytes_file_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   6965: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   6968: invokevirtual 591	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   6971: aload 42
    //   6973: getfield 2541	localpb/richMsg/RichMsg$VideoFile:bytes_file_uuid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   6976: aload 43
    //   6978: getfield 2542	tencent/im/msg/im_msg_body$VideoFile:bytes_file_uuid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   6981: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   6984: invokevirtual 591	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   6987: aload 42
    //   6989: getfield 2545	localpb/richMsg/RichMsg$VideoFile:uint32_file_format	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   6992: aload 43
    //   6994: getfield 2546	tencent/im/msg/im_msg_body$VideoFile:uint32_file_format	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   6997: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   7000: invokevirtual 173	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   7003: aload 42
    //   7005: getfield 2547	localpb/richMsg/RichMsg$VideoFile:uint32_file_size	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7008: aload 43
    //   7010: getfield 2548	tencent/im/msg/im_msg_body$VideoFile:uint32_file_size	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7013: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   7016: invokevirtual 173	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   7019: aload 42
    //   7021: getfield 2551	localpb/richMsg/RichMsg$VideoFile:uint32_file_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7024: aload 43
    //   7026: getfield 2552	tencent/im/msg/im_msg_body$VideoFile:uint32_file_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7029: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   7032: invokevirtual 173	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   7035: aload 42
    //   7037: getfield 2553	localpb/richMsg/RichMsg$VideoFile:uint32_thumb_width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7040: aload 43
    //   7042: getfield 2554	tencent/im/msg/im_msg_body$VideoFile:uint32_thumb_width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7045: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   7048: invokevirtual 173	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   7051: aload 42
    //   7053: getfield 2555	localpb/richMsg/RichMsg$VideoFile:uint32_thumb_height	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7056: aload 43
    //   7058: getfield 2556	tencent/im/msg/im_msg_body$VideoFile:uint32_thumb_height	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7061: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   7064: invokevirtual 173	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   7067: aload 42
    //   7069: getfield 2559	localpb/richMsg/RichMsg$VideoFile:uint32_file_status	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7072: sipush 2008
    //   7075: invokevirtual 173	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   7078: aload 42
    //   7080: getfield 2562	localpb/richMsg/RichMsg$VideoFile:uint32_file_progress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7083: iconst_0
    //   7084: invokevirtual 173	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   7087: aload 42
    //   7089: getfield 2565	localpb/richMsg/RichMsg$VideoFile:bytes_thumb_file_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   7092: aload 43
    //   7094: getfield 2566	tencent/im/msg/im_msg_body$VideoFile:bytes_thumb_file_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   7097: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   7100: invokevirtual 591	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   7103: sipush -2022
    //   7106: invokestatic 399	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   7109: checkcast 949	com/tencent/mobileqq/data/MessageForShortVideo
    //   7112: astore 43
    //   7114: aload 43
    //   7116: sipush -2022
    //   7119: putfield 2567	com/tencent/mobileqq/data/MessageForShortVideo:msgtype	I
    //   7122: aload 43
    //   7124: aload 42
    //   7126: invokevirtual 2568	localpb/richMsg/RichMsg$VideoFile:toByteArray	()[B
    //   7129: putfield 2569	com/tencent/mobileqq/data/MessageForShortVideo:msgData	[B
    //   7132: aload 43
    //   7134: ldc_w 2571
    //   7137: putfield 2572	com/tencent/mobileqq/data/MessageForShortVideo:msg	Ljava/lang/String;
    //   7140: aload 43
    //   7142: invokevirtual 2573	com/tencent/mobileqq/data/MessageForShortVideo:parse	()V
    //   7145: aload 46
    //   7147: aload 43
    //   7149: invokeinterface 375 2 0
    //   7154: pop
    //   7155: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7158: ifeq +47 -> 7205
    //   7161: aload 45
    //   7163: ldc_w 2575
    //   7166: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7169: new 91	java/lang/StringBuilder
    //   7172: dup
    //   7173: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   7176: aload 43
    //   7178: invokevirtual 2576	com/tencent/mobileqq/data/MessageForShortVideo:toString	()Ljava/lang/String;
    //   7181: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7184: ldc_w 2578
    //   7187: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7190: aload 43
    //   7192: invokevirtual 2581	com/tencent/mobileqq/data/MessageForShortVideo:toLogString	()Ljava/lang/String;
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
    //   7233: getfield 2585	tencent/im/msg/im_msg_body$Elem:tips_info	Ltencent/im/msg/im_msg_body$TipsInfo;
    //   7236: invokevirtual 2588	tencent/im/msg/im_msg_body$TipsInfo:has	()Z
    //   7239: ifeq +124 -> 7363
    //   7242: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7245: ifeq +12 -> 7257
    //   7248: aload 45
    //   7250: ldc_w 2590
    //   7253: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7256: pop
    //   7257: aload 49
    //   7259: getfield 2585	tencent/im/msg/im_msg_body$Elem:tips_info	Ltencent/im/msg/im_msg_body$TipsInfo;
    //   7262: invokevirtual 2591	tencent/im/msg/im_msg_body$TipsInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   7265: checkcast 2587	tencent/im/msg/im_msg_body$TipsInfo
    //   7268: astore 42
    //   7270: sipush -5002
    //   7273: invokestatic 399	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   7276: checkcast 2593	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips
    //   7279: astore 43
    //   7281: aload 43
    //   7283: aload 42
    //   7285: getfield 2595	tencent/im/msg/im_msg_body$TipsInfo:text	Lcom/tencent/mobileqq/pb/PBStringField;
    //   7288: invokevirtual 270	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   7291: invokevirtual 2599	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:parseTextXML	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   7294: invokevirtual 2604	java/lang/Boolean:booleanValue	()Z
    //   7297: ifne +41 -> 7338
    //   7300: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7303: ifeq +12 -> 7315
    //   7306: aload 45
    //   7308: ldc_w 2606
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
    //   7369: getfield 2610	tencent/im/msg/im_msg_body$Elem:qqwallet_msg	Ltencent/im/msg/im_msg_body$QQWalletMsg;
    //   7372: invokevirtual 2613	tencent/im/msg/im_msg_body$QQWalletMsg:has	()Z
    //   7375: ifeq +188 -> 7563
    //   7378: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7381: ifeq +12 -> 7393
    //   7384: aload 45
    //   7386: ldc_w 2615
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
    //   7418: getfield 2610	tencent/im/msg/im_msg_body$Elem:qqwallet_msg	Ltencent/im/msg/im_msg_body$QQWalletMsg;
    //   7421: invokevirtual 2616	tencent/im/msg/im_msg_body$QQWalletMsg:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   7424: checkcast 2612	tencent/im/msg/im_msg_body$QQWalletMsg
    //   7427: astore 42
    //   7429: sipush -2025
    //   7432: invokestatic 399	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   7435: checkcast 2618	com/tencent/mobileqq/data/MessageForQQWalletMsg
    //   7438: astore 43
    //   7440: aload 43
    //   7442: sipush -2025
    //   7445: putfield 2619	com/tencent/mobileqq/data/MessageForQQWalletMsg:msgtype	I
    //   7448: aload 43
    //   7450: new 2621	com/tencent/mobileqq/data/QQWalletTransferMsg
    //   7453: dup
    //   7454: aload 42
    //   7456: getfield 2625	tencent/im/msg/im_msg_body$QQWalletMsg:aio_body	Ltencent/im/msg/im_msg_body$QQWalletAioBody;
    //   7459: aload_0
    //   7460: getfield 216	com/tencent/mobileqq/app/MessageHandler:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7463: invokevirtual 220	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   7466: invokespecial 2628	com/tencent/mobileqq/data/QQWalletTransferMsg:<init>	(Ltencent/im/msg/im_msg_body$QQWalletAioBody;Ljava/lang/String;)V
    //   7469: putfield 2632	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletTransferMsg	Lcom/tencent/mobileqq/data/QQWalletTransferMsg;
    //   7472: aload 43
    //   7474: aload 43
    //   7476: invokevirtual 2635	com/tencent/mobileqq/data/MessageForQQWalletMsg:getMsgSummary	()Ljava/lang/String;
    //   7479: putfield 2636	com/tencent/mobileqq/data/MessageForQQWalletMsg:msg	Ljava/lang/String;
    //   7482: aload 43
    //   7484: aload 43
    //   7486: invokevirtual 2637	com/tencent/mobileqq/data/MessageForQQWalletMsg:getBytes	()[B
    //   7489: putfield 2638	com/tencent/mobileqq/data/MessageForQQWalletMsg:msgData	[B
    //   7492: aload 47
    //   7494: iconst_0
    //   7495: aload 47
    //   7497: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   7500: invokevirtual 126	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   7503: pop
    //   7504: aload 43
    //   7506: getfield 2632	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletTransferMsg	Lcom/tencent/mobileqq/data/QQWalletTransferMsg;
    //   7509: ifnonnull +44 -> 7553
    //   7512: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7515: ifeq +48 -> 7563
    //   7518: aload 45
    //   7520: ldc_w 2640
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
    //   7592: invokeinterface 1836 1 0
    //   7597: ifle -6145 -> 1452
    //   7600: aload_0
    //   7601: aload 46
    //   7603: iconst_0
    //   7604: invokeinterface 1982 2 0
    //   7609: invokeinterface 375 2 0
    //   7614: pop
    //   7615: goto -6163 -> 1452
    //   7618: aload_0
    //   7619: aload 46
    //   7621: invokeinterface 2644 2 0
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
    //   7666: invokeinterface 1836 1 0
    //   7671: ifle +20 -> 7691
    //   7674: aload_1
    //   7675: aload_2
    //   7676: invokestatic 2095	com/tencent/mobileqq/service/message/MessageProtoCodec:a	(Ljava/util/List;)Lcom/tencent/mobileqq/data/MessageRecord;
    //   7679: invokeinterface 375 2 0
    //   7684: pop
    //   7685: aload_2
    //   7686: invokeinterface 2098 1 0
    //   7691: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7694: ifeq -7602 -> 92
    //   7697: aload 45
    //   7699: ldc_w 2646
    //   7702: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7705: aload_1
    //   7706: invokeinterface 1836 1 0
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
    //   7729: invokeinterface 2644 2 0
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
    paramMessageHandler = (im_msg_body.Ptt)((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).ptt.get();
    String str = paramMessageHandler.bytes_file_name.get().toStringUtf8();
    int i;
    int j;
    int k;
    boolean bool;
    long l1;
    long l2;
    long l3;
    long l4;
    long l5;
    Object localObject;
    if (str.endsWith(".amr"))
    {
      i = a(paramMsg);
      j = b(paramMsg);
      k = paramMessageHandler.uint32_file_type.get();
      bool = paramMessageHandler.bool_valid.get();
      l1 = paramMessageHandler.uint64_src_uin.get();
      l2 = paramMessageHandler.uint32_file_size.get();
      l3 = paramMessageHandler.uint32_file_id.get() & 0xFFFFFFFF;
      l4 = paramMessageHandler.uint32_server_ip.get();
      l5 = paramMessageHandler.uint32_server_port.get();
      localObject = paramMessageHandler.bytes_file_uuid.get().toByteArray();
      paramMsg = paramMessageHandler.bytes_file_md5.get().toByteArray();
      localObject = HexUtil.a((byte[])localObject);
      paramMsg = HexUtil.a(paramMsg);
      if (!paramMessageHandler.bytes_group_file_key.has()) {
        break label557;
      }
    }
    label557:
    for (paramMessageHandler = paramMessageHandler.bytes_group_file_key.get().toByteArray();; paramMessageHandler = null) {
      try
      {
        paramMessageHandler = new String(paramMessageHandler, "utf-8");
        if (paramMsg == null)
        {
          paramMsg = "";
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder("<---decodeSinglePbMsg_GroupDis:");
            localStringBuilder.append(" pttType:").append(k).append(" isValid:").append(bool).append(" srcUin:").append(l1).append(" fileSize:").append(l2 & 0xFFFFFFFF).append(" fileID").append(l3).append(" serverIP:").append(l4 & 0xFFFFFFFF).append(" serverPort:").append(l5 & 0xFFFFFFFF).append(" fileName:").append(str).append(" uuidStr:").append((String)localObject).append(" md5Str:").append(paramMsg).append(" GrpFileKey:").append(paramMessageHandler);
            QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
          }
          TransfileUtile.a(str, 0L, 2, false, str);
          localObject = new RichMsg.PttRec();
          ((RichMsg.PttRec)localObject).localPath.set(str);
          ((RichMsg.PttRec)localObject).size.set(0L);
          ((RichMsg.PttRec)localObject).type.set(2);
          ((RichMsg.PttRec)localObject).uuid.set(str);
          ((RichMsg.PttRec)localObject).isRead.set(false);
          ((RichMsg.PttRec)localObject).md5.set(paramMsg);
          ((RichMsg.PttRec)localObject).isReport.set(0);
          ((RichMsg.PttRec)localObject).version.set(5);
          ((RichMsg.PttRec)localObject).groupFileID.set(l3);
          ((RichMsg.PttRec)localObject).pttFlag.set(i);
          ((RichMsg.PttRec)localObject).longPttVipFlag.set(j);
          if (paramMessageHandler != null) {
            ((RichMsg.PttRec)localObject).group_file_key.set(paramMessageHandler);
          }
          paramMessageHandler = MessageRecordFactory.a(-2002);
          paramMessageHandler.msgtype = -2002;
          paramMessageHandler.msgData = ((RichMsg.PttRec)localObject).toByteArray();
          ((MessageForPtt)paramMessageHandler).parse();
          paramList.add(paramMessageHandler);
          return;
        }
      }
      catch (UnsupportedEncodingException paramMessageHandler)
      {
        for (;;)
        {
          paramMessageHandler = null;
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
      new Handler(localLooper).post(new eds(paramMessageHandler, paramMsg));
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