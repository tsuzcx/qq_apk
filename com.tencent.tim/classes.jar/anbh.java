import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Apollo3DMessage;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.FunnyFaceMessage;
import com.tencent.mobileqq.data.FunnyFaceMessage.Bomb;
import com.tencent.mobileqq.data.FunnyFaceMessage.Turntable;
import com.tencent.mobileqq.data.HiBoomMessage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForFunnyFace;
import com.tencent.mobileqq.data.MessageForHiBoom;
import com.tencent.mobileqq.data.MessageForLimitChatConfirm;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForPokeEmo;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageForTroopStory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.ShakeWindowMsg;
import com.tencent.mobileqq.hiboom.hiboom_type.Hiboom_Type;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.pb.apollomsgextend.ApolloMsgExtend.AuthReserve;
import com.tencent.pb.apollomsgextend.ApolloMsgExtend.ThreeDBaseInfo;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import localpb.richMsg.MixedMsg.Elem;
import localpb.richMsg.MixedMsg.Msg;
import localpb.richMsg.RichMsg.PicRec;
import mqq.app.AccountNotMatchException;
import msf.msgcomm.msg_comm.ContentHead;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgsvc.msg_svc.PbDeleteMsgReq;
import msf.msgsvc.msg_svc.PbDeleteMsgReq.MsgItem;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import msf.msgsvc.msg_svc.RoutingHead;
import msf.msgsvc.msg_svc.Trans0x211;
import msf.msgsvc.msg_svc.TransMsg;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.hummer.resv.source_msg.ResvAttr;
import tencent.im.msg.hummer.resv1.TextMsgExtPb.ResvAttr;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype11;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype14;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype16;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype19;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype2;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype20;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype23;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype24;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype24.LimitChatEnter;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype24.LimitChatExit;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype33;
import tencent.im.msg.im_msg_body.AnonymousGroupMsg;
import tencent.im.msg.im_msg_body.ApolloActMsg;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ElemFlags2;
import tencent.im.msg.im_msg_body.Face;
import tencent.im.msg.im_msg_body.FunFace;
import tencent.im.msg.im_msg_body.FunFace.Bomb;
import tencent.im.msg.im_msg_body.FunFace.Turntable;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.msg.im_msg_body.LightAppElem;
import tencent.im.msg.im_msg_body.MarketFace;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.RichMsg;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.SecretFileMsg;
import tencent.im.msg.im_msg_body.ShakeWindow;
import tencent.im.msg.im_msg_body.SmallEmoji;
import tencent.im.msg.im_msg_body.SourceMsg;
import tencent.im.msg.im_msg_body.Text;

public class anbh
{
  public static int a(msg_comm.Msg paramMsg)
  {
    int i;
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has())) {
      i = 0;
    }
    int j;
    do
    {
      return i;
      paramMsg = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get().iterator();
      im_msg_body.Elem localElem;
      do
      {
        if (!paramMsg.hasNext()) {
          break;
        }
        localElem = (im_msg_body.Elem)paramMsg.next();
      } while ((!localElem.general_flags.has()) || (!((im_msg_body.GeneralFlags)localElem.general_flags.get()).uint32_bubble_diy_text_id.has()));
      j = ((im_msg_body.GeneralFlags)localElem.general_flags.get()).uint32_bubble_diy_text_id.get();
      i = j;
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.MessageHandler", 2, "decodeC2CMsgPkg_BubbleDiyTextID->" + j);
    return j;
    return 0;
  }
  
  public static int a(im_msg_body.RichText paramRichText, String paramString, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    int j = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    int k = 0;
    if (k < str.length())
    {
      paramString = null;
      if (paramArrayList == null) {
        break label1123;
      }
      label45:
      if (i >= paramArrayList.size()) {
        break label1118;
      }
      paramString = (MessageForText.AtTroopMemberInfo)paramArrayList.get(i);
      if ((paramString == null) || (!paramString.isValid())) {}
    }
    label1107:
    label1113:
    label1118:
    label1123:
    for (;;)
    {
      int m;
      Object localObject1;
      if ((paramString != null) && (paramString.startPos <= k))
      {
        m = j;
        if (localStringBuilder.length() > 0)
        {
          a(paramRichText, localStringBuilder.toString());
          localStringBuilder.delete(0, localStringBuilder.length());
          m = j + 1;
        }
        localObject1 = a(paramRichText, str.substring(paramString.startPos, paramString.startPos + paramString.textLen));
        short s = paramString.startPos;
        paramString.startPos = 0;
        a(paramString, (im_msg_body.Elem)localObject1);
        paramString.startPos = s;
        localStringBuilder.delete(0, localStringBuilder.length());
        j = m + 1;
        m = paramString.textLen;
        i += 1;
        k += m - 1;
        k += 1;
        break;
        i += 1;
        break label45;
      }
      int n;
      label492:
      label504:
      Object localObject2;
      int[] arrayOfInt;
      if ((str.charAt(k) == '\024') && (k + 1 < str.length()))
      {
        n = j;
        if (localStringBuilder.length() > 0)
        {
          a(paramRichText, localStringBuilder.toString());
          localStringBuilder.delete(0, localStringBuilder.length());
          n = j + 1;
        }
        m = str.charAt(k + 1);
        j = m;
        if (m == 250) {
          j = 10;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "localeCode value:" + j);
        }
        if (afky.jr(j))
        {
          m = afky.hl(j);
          if (m >= 260)
          {
            paramString = new hummer_commelem.MsgElemInfo_servtype33();
            paramString.uint32_index.set(m);
            localObject1 = afky.ea(j);
            paramString.bytes_text.set(ByteStringMicro.copyFromUtf8((String)localObject1));
            paramString.bytes_compat.set(ByteStringMicro.copyFromUtf8((String)localObject1));
            localObject1 = new im_msg_body.CommonElem();
            ((im_msg_body.CommonElem)localObject1).uint32_service_type.set(33);
            ((im_msg_body.CommonElem)localObject1).uint32_business_type.set(1);
            ((im_msg_body.CommonElem)localObject1).bytes_pb_elem.set(ByteStringMicro.copyFrom(paramString.toByteArray()));
            paramString = new im_msg_body.Elem();
            paramString.common_elem.set((MessageMicro)localObject1);
            paramRichText.elems.add(paramString);
            j = n + 1;
            m = k + 1;
          }
        }
        do
        {
          k = m;
          break;
          paramString = new im_msg_body.Face();
          paramString.index.set(m);
          localObject1 = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject1).face.set(paramString);
          paramRichText.elems.add((MessageMicro)localObject1);
          break label492;
          m = k;
          j = n;
        } while (k + 4 >= str.length());
        localObject2 = new char[4];
        localObject2[3] = str.charAt(k + 1);
        localObject2[2] = str.charAt(k + 2);
        localObject2[1] = str.charAt(k + 3);
        localObject2[0] = str.charAt(k + 4);
        j = 0;
        if (j < 4)
        {
          if (localObject2[j] == 'ú') {
            localObject2[j] = 10;
          }
          for (;;)
          {
            j += 1;
            break;
            if (localObject2[j] == 'þ') {
              localObject2[j] = 13;
            }
          }
        }
        arrayOfInt = afgc.a((char[])localObject2);
        paramString = BaseApplicationImpl.getContext();
        if (Build.VERSION.SDK_INT > 10) {
          j = 4;
        }
      }
      for (paramString = paramString.getSharedPreferences("Last_Login", j).getString("uin", "");; paramString = null) {
        for (;;)
        {
          try
          {
            paramString = (AppInterface)BaseApplicationImpl.getApplication().getAppRuntime(paramString);
            localObject1 = aofk.ckA;
            if (paramString == null) {
              break label1107;
            }
            paramString = (ajdg)paramString.getManager(14);
            if (paramString == null) {
              break label1113;
            }
            paramString = paramString.a(Integer.toString(arrayOfInt[0]), Integer.toString(arrayOfInt[1]));
            if (paramString == null) {
              break label1107;
            }
            paramString = paramString.character;
            j = arrayOfInt[0];
            m = arrayOfInt[1];
            localObject1 = new im_msg_body.SmallEmoji();
            ((im_msg_body.SmallEmoji)localObject1).packIdSum.set((j << 16) + m);
            if (localObject2[3] == 'ÿ')
            {
              ((im_msg_body.SmallEmoji)localObject1).imageType.set(1);
              localObject2 = new im_msg_body.Elem();
              ((im_msg_body.Elem)localObject2).small_emoji.set((MessageMicro)localObject1);
              paramRichText.elems.add((MessageMicro)localObject2);
              localObject1 = new im_msg_body.Text();
              ((im_msg_body.Text)localObject1).str.set(ByteStringMicro.copyFromUtf8(paramString));
              paramString = new im_msg_body.Elem();
              paramString.text.set((MessageMicro)localObject1);
              paramRichText.elems.add(paramString);
              j = n + 1 + 1;
              m = k + 4;
              break label504;
              j = 0;
            }
          }
          catch (AccountNotMatchException paramString)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "[AccountNotMatchException]," + paramString.getMessage());
            }
            paramString = null;
            continue;
            if (localObject2[3] != 'ǿ') {
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "send apng epid = " + arrayOfInt[0] + " eid = " + arrayOfInt[1]);
            }
            ((im_msg_body.SmallEmoji)localObject1).imageType.set(2);
            continue;
          }
          localStringBuilder.append(str.charAt(k));
          break;
          i = j;
          if (localStringBuilder.length() > 0)
          {
            a(paramRichText, localStringBuilder.toString());
            i = j + 1;
          }
          return i;
          paramString = (String)localObject1;
        }
      }
      paramString = null;
    }
  }
  
  public static long a(msg_comm.Msg paramMsg)
  {
    long l1 = -1L;
    long l2 = l1;
    if (paramMsg.msg_body.has())
    {
      if (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has()) {
        l2 = l1;
      }
    }
    else {
      return l2;
    }
    paramMsg = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get().iterator();
    label70:
    Object localObject;
    if (paramMsg.hasNext())
    {
      localObject = (im_msg_body.Elem)paramMsg.next();
      if ((((im_msg_body.Elem)localObject).elem_flags2.has()) && (((im_msg_body.Elem)localObject).elem_flags2.uint32_custom_font.has())) {
        l1 = ((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject).elem_flags2.get()).uint32_custom_font.get() & 0xFFFFFFFF;
      }
    }
    for (;;)
    {
      break label70;
      if (((im_msg_body.Elem)localObject).secret_file.has())
      {
        localObject = ((im_msg_body.Elem)localObject).secret_file;
        if ((((im_msg_body.SecretFileMsg)localObject).elem_flags2.has()) && (((im_msg_body.SecretFileMsg)localObject).elem_flags2.uint32_custom_font.has()))
        {
          l1 = ((im_msg_body.ElemFlags2)((im_msg_body.SecretFileMsg)localObject).elem_flags2.get()).uint32_custom_font.get() & 0xFFFFFFFF;
          continue;
          l2 = l1;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.msg.MessageHandler", 2, "decodeC2CMsgPkg_VipFontID: fontid = " + l1);
          return l1;
        }
      }
    }
  }
  
  public static Pair<Long, Long> a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, String paramString1, String paramString2)
  {
    long l2 = -1L;
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has())) {
      return new Pair(Long.valueOf(0L), Long.valueOf(0L));
    }
    paramMsg = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get().iterator();
    long l1 = -1L;
    Object localObject;
    if (paramMsg.hasNext())
    {
      localObject = (im_msg_body.Elem)paramMsg.next();
      if ((((im_msg_body.Elem)localObject).elem_flags2.has()) && (((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject).elem_flags2.get()).uint32_color_text_id.has())) {
        l1 = ((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject).elem_flags2.get()).uint32_color_text_id.get() & 0xFFFFFFFF;
      }
    }
    for (;;)
    {
      break;
      if (((im_msg_body.Elem)localObject).secret_file.has())
      {
        localObject = ((im_msg_body.Elem)localObject).secret_file;
        if ((((im_msg_body.SecretFileMsg)localObject).elem_flags2.has()) && (((im_msg_body.SecretFileMsg)localObject).elem_flags2.uint32_color_text_id.has()))
        {
          l1 = ((im_msg_body.ElemFlags2)((im_msg_body.SecretFileMsg)localObject).elem_flags2.get()).uint32_color_text_id.get() & 0xFFFFFFFF;
          continue;
          if (l1 == 4294967295L) {
            l2 = paramMessageHandler.app.b().c(paramString1, paramString2);
          }
          return new Pair(Long.valueOf(l1), Long.valueOf(l2));
        }
      }
    }
  }
  
  public static MessageRecord a(List<MessageRecord> paramList, byte[] paramArrayOfByte, aozx paramaozx)
  {
    MixedMsg.Msg localMsg = new MixedMsg.Msg();
    JSONObject localJSONObject = new JSONObject();
    paramList = paramList.iterator();
    int i = 0;
    int k = 0;
    while (paramList.hasNext())
    {
      Object localObject1 = (MessageRecord)paramList.next();
      MixedMsg.Elem localElem = new MixedMsg.Elem();
      int j;
      if (((MessageRecord)localObject1).msgtype == -1000)
      {
        if (!TextUtils.isEmpty(((MessageRecord)localObject1).msg))
        {
          localElem.textMsg.set(((MessageRecord)localObject1).msg);
          j = i;
        }
      }
      else {
        for (;;)
        {
          Object localObject2;
          try
          {
            if (((MessageRecord)localObject1).atInfoList != null)
            {
              j = i;
              if (((MessageRecord)localObject1).atInfoList.size() > 0)
              {
                localObject2 = new JSONArray();
                localObject1 = ((MessageRecord)localObject1).atInfoList.iterator();
                j = 0;
                if (((Iterator)localObject1).hasNext())
                {
                  ((JSONArray)localObject2).put(j, ((MessageForText.AtTroopMemberInfo)((Iterator)localObject1).next()).toJsonObject());
                  j += 1;
                  continue;
                }
                localJSONObject.put("" + k, localObject2);
                j = 1;
              }
            }
            i = j;
          }
          catch (JSONException localJSONException)
          {
            QLog.e("Q.msg.MessageHandler", 1, "disc mixMsg create atInfos error:", localJSONException);
            continue;
          }
          localMsg.elems.get().add(localElem);
          k += 1;
          break;
          if (localJSONException.msgtype == -2000)
          {
            localObject2 = new RichMsg.PicRec();
            try
            {
              RichMsg.PicRec localPicRec = (RichMsg.PicRec)((RichMsg.PicRec)localObject2).mergeFrom(localJSONException.msgData);
              localElem.picMsg.set(localPicRec);
            }
            catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
            {
              for (;;)
              {
                QLog.e("Q.msg.MessageHandler", 1, "mergeMixedMsgContent", localInvalidProtocolBufferMicroException);
              }
            }
          }
          else if (localInvalidProtocolBufferMicroException.msgtype == -1049)
          {
            try
            {
              MessageForReplyText localMessageForReplyText = (MessageForReplyText)localInvalidProtocolBufferMicroException;
              localObject2 = aczw.b(localMessageForReplyText.mSourceMsgInfo);
              localElem.sourceMsgInfo.set(aqhs.bytes2HexStr((byte[])localObject2));
              if (!TextUtils.isEmpty(localMessageForReplyText.msg)) {
                localElem.textMsg.set(localMessageForReplyText.msg);
              }
            }
            catch (Exception localException)
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, localException.getMessage());
              }
            }
          }
        }
      }
    }
    paramList = (MessageForMixedMsg)anbi.d(-1035);
    paramList.msgtype = -1035;
    paramList.msgData = localMsg.toByteArray();
    if ((paramaozx != null) && (paramaozx.uinType == 3000)) {
      paramList.frienduin = paramaozx.frienduin;
    }
    if (i != 0) {
      appb.a(paramaozx.uinType, localJSONObject.toString(), paramList);
    }
    if (paramArrayOfByte != null) {
      paramList.saveExtInfoToExtStr("sens_msg_ctrl_info", aqhs.bytes2HexStr(paramArrayOfByte));
    }
    paramList.parse();
    return paramList;
  }
  
  public static msg_svc.PbSendMsgReq a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString, anbn paramanbn, long paramLong, int paramInt2)
  {
    if (paramanbn == null) {
      paramQQAppInterface = null;
    }
    label334:
    do
    {
      return paramQQAppInterface;
      int j = (short)(int)paramLong;
      int k = 0xFFFF & j;
      long l;
      msg_svc.RoutingHead localRoutingHead;
      if ((paramInt1 == 9) || (paramInt1 == 13))
      {
        l = 0x0 | paramanbn.msg.length << 16 | 0xA6;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "<PbSendMsg><S>--->createPbSendMsgReq: routingType:" + paramInt1 + ",toUin:" + paramString + ",msgUid:" + l + ",msgSeq:" + paramLong + ",uint32Seq:" + k + ",shortSeq:" + j + ",randomNum:" + paramInt2 + ",msgContext:" + paramanbn);
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
          break label334;
        }
        return null;
        l = 0x0 | paramInt2;
        break;
        localObject = new msg_svc.TransMsg();
        ((msg_svc.TransMsg)localObject).c2c_cmd.set(paramanbn.dEY);
        ((msg_svc.TransMsg)localObject).to_uin.set(Long.valueOf(paramString).longValue());
        localRoutingHead.trans_msg.set((MessageMicro)localObject);
        paramInt1 = 1;
        continue;
        localObject = new msg_svc.Trans0x211();
        ((msg_svc.Trans0x211)localObject).cc_cmd.set(paramanbn.dEY);
        paramString = paramString.replace("+", "");
        ((msg_svc.Trans0x211)localObject).to_uin.set(jji.B(paramString));
        localRoutingHead.trans_0x211.set((MessageMicro)localObject);
        paramInt1 = 1;
      }
      Object localObject = new msg_comm.ContentHead();
      ((msg_comm.ContentHead)localObject).pkg_num.set(1);
      ((msg_comm.ContentHead)localObject).div_seq.set(j);
      ((msg_comm.ContentHead)localObject).pkg_index.set(0);
      im_msg_body.MsgBody localMsgBody = new im_msg_body.MsgBody();
      localMsgBody.msg_content.set(ByteStringMicro.copyFrom(paramanbn.msg));
      paramString = new msg_svc.PbSendMsgReq();
      paramString.routing_head.set(localRoutingHead);
      paramString.content_head.set((MessageMicro)localObject);
      paramString.msg_body.set(localMsgBody);
      paramString.msg_seq.set(k);
      paramString.msg_rand.set(paramInt2);
      paramanbn = paramQQAppInterface.am();
      paramQQAppInterface = paramString;
    } while (paramanbn == null);
    paramString.sync_cookie.set(ByteStringMicro.copyFrom(paramanbn));
    return paramString;
  }
  
  public static msg_svc.PbSendMsgReq a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, im_msg_body.RichText paramRichText, int paramInt)
  {
    int i = c(paramMessageRecord.istroop, paramQQAppInterface);
    if ((i == 9) || (i == 13)) {}
    int j;
    int k;
    anaz localanaz;
    msg_svc.RoutingHead localRoutingHead;
    do
    {
      return null;
      long l = paramMessageRecord.msgUid;
      j = (short)(int)paramMessageRecord.msgseq;
      k = anbk.ab(l);
      localanaz = paramQQAppInterface.a();
      localRoutingHead = new msg_svc.RoutingHead();
    } while (!a(paramQQAppInterface, paramMessageRecord, localRoutingHead));
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
    paramRichText.msg_seq.set(j & 0xFFFF);
    paramRichText.msg_rand.set(k);
    if ((i != 2) && (i != 4) && (i != 21))
    {
      paramQQAppInterface = localanaz.am();
      if (paramQQAppInterface != null) {
        paramRichText.sync_cookie.set(ByteStringMicro.copyFrom(paramQQAppInterface));
      }
    }
    paramRichText.msg_via.set(paramInt);
    return paramRichText;
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
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForRichText))) {
      return ((MessageForRichText)paramChatMessage).richText;
    }
    return null;
  }
  
  public static im_msg_body.RichText a(ChatMessage paramChatMessage, boolean paramBoolean)
  {
    Object localObject2 = null;
    Object localObject1;
    if (paramChatMessage == null) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      return localObject1;
      localObject1 = localObject2;
      if (!(paramChatMessage instanceof MessageForArkApp)) {
        continue;
      }
      paramChatMessage = (MessageForArkApp)paramChatMessage;
      localObject1 = localObject2;
      if (paramChatMessage == null) {
        continue;
      }
      localObject1 = localObject2;
      if (paramChatMessage.ark_app_message == null) {
        continue;
      }
      Object localObject3 = paramChatMessage.ark_app_message.toPbData();
      localObject1 = localObject2;
      if (localObject3 == null) {
        continue;
      }
      localObject1 = localObject2;
      if (localObject3.length == 0) {
        continue;
      }
      byte[] arrayOfByte = ansi.compress((byte[])localObject3);
      localObject1 = localObject2;
      if (arrayOfByte == null) {
        continue;
      }
      localObject1 = localObject2;
      if (arrayOfByte.length == 0) {
        continue;
      }
      localObject3 = new ByteArrayOutputStream();
      try
      {
        ((ByteArrayOutputStream)localObject3).write(1);
        ((ByteArrayOutputStream)localObject3).write(arrayOfByte);
        if ((!TextUtils.isEmpty(paramChatMessage.resIDForLongMsg)) && (!paramBoolean))
        {
          localObject1 = new im_msg_body.RichText();
          localObject2 = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject2).general_flags.long_text_flag.set(1);
          ((im_msg_body.Elem)localObject2).general_flags.long_text_resid.set(ByteStringMicro.copyFromUtf8(paramChatMessage.resIDForLongMsg));
          ((im_msg_body.RichText)localObject1).elems.add((MessageMicro)localObject2);
          return localObject1;
        }
        if (paramChatMessage.ark_app_message.containStructMsg != null)
        {
          paramChatMessage = a((MessageForStructing)paramChatMessage.ark_app_message.containStructMsg);
          localObject1 = new im_msg_body.LightAppElem();
          ((im_msg_body.LightAppElem)localObject1).bytes_data.set(ByteStringMicro.copyFrom(((ByteArrayOutputStream)localObject3).toByteArray()));
          localObject2 = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject2).light_app.set((MessageMicro)localObject1);
          localObject1 = paramChatMessage;
          if (paramChatMessage == null) {
            continue;
          }
          paramChatMessage.elems.add((MessageMicro)localObject2);
          return paramChatMessage;
        }
        localObject2 = new im_msg_body.RichText();
        if (!TextUtils.isEmpty(paramChatMessage.ark_app_message.compatibleText)) {
          localObject1 = paramChatMessage.ark_app_message.compatibleText;
        }
        for (;;)
        {
          paramChatMessage = (ChatMessage)localObject2;
          if (localObject1 == null) {
            break;
          }
          paramChatMessage = (ChatMessage)localObject2;
          if (((String)localObject1).length() <= 0) {
            break;
          }
          paramChatMessage = new im_msg_body.Text();
          paramChatMessage.str.set(ByteStringMicro.copyFromUtf8((String)localObject1));
          localObject1 = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject1).text.set(paramChatMessage);
          ((im_msg_body.RichText)localObject2).elems.add((MessageMicro)localObject1);
          paramChatMessage = (ChatMessage)localObject2;
          break;
          paramChatMessage = paramChatMessage.getSummery();
          if ((paramChatMessage == null) || (paramChatMessage.length() == 0)) {
            localObject1 = BaseApplication.getContext().getString(2131695294);
          } else {
            localObject1 = String.format(BaseApplication.getContext().getString(2131695295), new Object[] { paramChatMessage });
          }
        }
        return null;
      }
      catch (Exception paramChatMessage) {}
    }
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
    if ((paramMarkFaceMessage.resvAttr != null) && (paramMarkFaceMessage.resvAttr.length > 0)) {
      ((im_msg_body.MarketFace)localObject).bytes_pb_reserve.set(ByteStringMicro.copyFrom(paramMarkFaceMessage.resvAttr));
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "encodeMarketFace : mf epid = " + ((im_msg_body.MarketFace)localObject).uint32_tab_id.get() + " csubtype = " + ((im_msg_body.MarketFace)localObject).uint32_sub_type.get() + ";mediaType = " + ((im_msg_body.MarketFace)localObject).uint32_media_type.get());
    }
    paramMarkFaceMessage = new im_msg_body.Text();
    if (paramString != null) {
      paramMarkFaceMessage.str.set(ByteStringMicro.copyFromUtf8(paramString));
    }
    paramString = new im_msg_body.RichText();
    im_msg_body.Elem localElem = new im_msg_body.Elem();
    localElem.market_face.set((MessageMicro)localObject);
    paramString.elems.add(localElem);
    localObject = new im_msg_body.Elem();
    ((im_msg_body.Elem)localObject).text.set(paramMarkFaceMessage);
    paramString.elems.add((MessageMicro)localObject);
    return paramString;
  }
  
  public static im_msg_body.RichText a(MessageForApollo paramMessageForApollo)
  {
    if ((paramMessageForApollo == null) || (paramMessageForApollo.mApolloMessage == null)) {
      return null;
    }
    return b(paramMessageForApollo);
  }
  
  public static im_msg_body.RichText a(MessageForFunnyFace paramMessageForFunnyFace)
  {
    if ((paramMessageForFunnyFace == null) || (paramMessageForFunnyFace.mFunnyFaceMessage == null)) {
      return null;
    }
    return a(paramMessageForFunnyFace.mFunnyFaceMessage);
  }
  
  public static im_msg_body.RichText a(MessageForLongTextMsg paramMessageForLongTextMsg, boolean paramBoolean)
  {
    Object localObject2 = null;
    if (paramMessageForLongTextMsg == null) {
      localObject1 = localObject2;
    }
    do
    {
      do
      {
        do
        {
          return localObject1;
          if (!paramBoolean) {
            break;
          }
          localObject1 = localObject2;
        } while (paramMessageForLongTextMsg.structingMsg == null);
        localObject3 = paramMessageForLongTextMsg.structingMsg.getXmlBytes();
        localObject1 = localObject2;
      } while (localObject3 == null);
      localObject1 = new im_msg_body.RichMsg();
      ((im_msg_body.RichMsg)localObject1).bytes_template_1.set(ByteStringMicro.copyFrom((byte[])localObject3));
      ((im_msg_body.RichMsg)localObject1).uint32_service_id.set(paramMessageForLongTextMsg.structingMsg.mMsgServiceID);
      localObject2 = new im_msg_body.RichText();
      localObject3 = new im_msg_body.Elem();
      ((im_msg_body.Elem)localObject3).rich_msg.set((MessageMicro)localObject1);
      ((im_msg_body.RichText)localObject2).elems.add((MessageMicro)localObject3);
      localObject1 = localObject2;
    } while (TextUtils.isEmpty(paramMessageForLongTextMsg.structingMsg.mCompatibleText));
    Object localObject1 = new im_msg_body.Elem();
    Object localObject3 = new im_msg_body.Text();
    ((im_msg_body.Text)localObject3).str.set(ByteStringMicro.copyFrom(paramMessageForLongTextMsg.structingMsg.mCompatibleText.getBytes()));
    ((im_msg_body.Elem)localObject1).text.set((MessageMicro)localObject3);
    ((im_msg_body.RichText)localObject2).elems.add((MessageMicro)localObject1);
    return localObject2;
    paramMessageForLongTextMsg = a(paramMessageForLongTextMsg.msg, paramMessageForLongTextMsg.atInfoList);
    localObject1 = new im_msg_body.GeneralFlags();
    ((im_msg_body.GeneralFlags)localObject1).long_text_flag.set(2);
    localObject2 = new im_msg_body.Elem();
    ((im_msg_body.Elem)localObject2).general_flags.set((MessageMicro)localObject1);
    paramMessageForLongTextMsg.elems.add((MessageMicro)localObject2);
    return paramMessageForLongTextMsg;
  }
  
  public static im_msg_body.RichText a(MessageForMarketFace paramMessageForMarketFace)
  {
    if ((paramMessageForMarketFace == null) || (paramMessageForMarketFace.mMarkFaceMessage == null)) {
      return null;
    }
    if (TextUtils.isEmpty(paramMessageForMarketFace.mMarkFaceMessage.faceName)) {}
    for (String str = acfp.m(2131708226);; str = "[" + paramMessageForMarketFace.mMarkFaceMessage.faceName + "]")
    {
      boolean bool = true;
      if (paramMessageForMarketFace.istroop == 3000) {
        bool = false;
      }
      return a(paramMessageForMarketFace.mMarkFaceMessage, str, bool);
    }
  }
  
  public static im_msg_body.RichText a(MessageForMixedMsg paramMessageForMixedMsg)
  {
    if (paramMessageForMixedMsg == null) {
      return null;
    }
    im_msg_body.RichText localRichText = new im_msg_body.RichText();
    int k = paramMessageForMixedMsg.msgElemList.size();
    int i = 0;
    if (i < k)
    {
      Object localObject = (MessageRecord)paramMessageForMixedMsg.msgElemList.get(i);
      int j;
      if ((localObject instanceof MessageForText))
      {
        localObject = a((MessageForText)localObject);
        if (localObject == null) {
          return null;
        }
        j = 0;
        while (j < ((im_msg_body.RichText)localObject).elems.size())
        {
          localRichText.elems.add(((im_msg_body.RichText)localObject).elems.get(j));
          j += 1;
        }
      }
      if ((localObject instanceof MessageForRichText))
      {
        localObject = ((MessageForPic)localObject).richText;
        if (localObject == null) {
          return null;
        }
        localRichText.elems.add(((im_msg_body.RichText)localObject).elems.get(0));
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localObject instanceof MessageForReplyText))
        {
          localObject = a((MessageForReplyText)localObject);
          if (localObject != null)
          {
            j = 0;
            while (j < ((im_msg_body.RichText)localObject).elems.size())
            {
              localRichText.elems.add(((im_msg_body.RichText)localObject).elems.get(j));
              j += 1;
            }
          }
        }
      }
    }
    return localRichText;
  }
  
  public static im_msg_body.RichText a(MessageForQQStoryComment paramMessageForQQStoryComment)
  {
    return a(paramMessageForQQStoryComment.msg, null);
  }
  
  public static im_msg_body.RichText a(MessageForReplyText paramMessageForReplyText)
  {
    localObject2 = paramMessageForReplyText.getExtInfoFromExtStr("sens_msg_source_msg_info");
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {}
    try
    {
      String str = aqhs.bytes2HexStr(aczw.b(paramMessageForReplyText.mSourceMsgInfo));
      localObject1 = str;
      localObject2 = str;
      if (!TextUtils.isEmpty(str))
      {
        localObject2 = str;
        paramMessageForReplyText.saveExtInfoToExtStr("sens_msg_source_msg_info", str);
        localObject1 = str;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.msg.MessageHandler", 2, QLog.getStackTraceString(localException));
          localObject1 = localObject2;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.", 2, "getSourceMsgInfo data = " + localObject1 + ", mSourceMsgInfo = " + paramMessageForReplyText.mSourceMsgInfo);
    }
    return a(paramMessageForReplyText);
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
    if ((paramMessageForStructing == null) || (paramMessageForStructing.structingMsg == null)) {
      localObject1 = null;
    }
    Object localObject2;
    label344:
    do
    {
      return localObject1;
      if (paramMessageForStructing.richText != null) {
        return paramMessageForStructing.richText;
      }
      localObject2 = paramMessageForStructing.structingMsg.getXmlBytes();
      if (localObject2 == null) {
        return null;
      }
      if ((paramMessageForStructing.structingMsg.mMsgServiceID != 83) && (paramMessageForStructing.structingMsg.mMsgServiceID != 108) && (paramMessageForStructing.structingMsg.mMsgServiceID != 114) && (paramMessageForStructing.structingMsg.mMsgServiceID != 116) && (paramMessageForStructing.structingMsg.mMsgServiceID != 151))
      {
        localObject1 = localObject2;
        if (paramMessageForStructing.structingMsg.mMsgServiceID != 156) {}
      }
      else
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(paramMessageForStructing.structingMsg.mMsgActionData))
        {
          localObject2 = paramMessageForStructing.structingMsg.mMsgActionData;
          paramMessageForStructing.structingMsg.mMsgActionData = nl(paramMessageForStructing.structingMsg.mMsgActionData);
          localObject1 = paramMessageForStructing.structingMsg.getXmlBytes();
          paramMessageForStructing.structingMsg.mMsgActionData = ((String)localObject2);
        }
      }
      localObject3 = new im_msg_body.RichMsg();
      ((im_msg_body.RichMsg)localObject3).bytes_template_1.set(ByteStringMicro.copyFrom((byte[])localObject1));
      ((im_msg_body.RichMsg)localObject3).uint32_service_id.set(paramMessageForStructing.structingMsg.mMsgServiceID);
      if ((paramMessageForStructing.structingMsg instanceof AbsShareMsg))
      {
        localObject1 = ((AbsShareMsg)paramMessageForStructing.structingMsg).getStructMsgItemLists();
        if (localObject1 != null)
        {
          localObject1 = ((List)localObject1).iterator();
          for (;;)
          {
            if (!((Iterator)localObject1).hasNext()) {
              break label344;
            }
            localObject2 = (anqu)((Iterator)localObject1).next();
            if ((localObject2 instanceof anqv))
            {
              localObject2 = ((anqv)localObject2).rz;
              if (localObject2 != null)
              {
                localObject2 = ((List)localObject2).iterator();
                if (((Iterator)localObject2).hasNext())
                {
                  anqu localanqu = (anqu)((Iterator)localObject2).next();
                  if (!(localanqu instanceof anvf)) {
                    break;
                  }
                  if (((anvf)localanqu).aza()) {
                    ((im_msg_body.RichMsg)localObject3).uint32_flags.set(4);
                  } else {
                    ((im_msg_body.RichMsg)localObject3).uint32_flags.set(2);
                  }
                }
              }
            }
          }
        }
      }
      localObject2 = new im_msg_body.RichText();
      localObject1 = new im_msg_body.Elem();
      ((im_msg_body.Elem)localObject1).rich_msg.set((MessageMicro)localObject3);
      ((im_msg_body.RichText)localObject2).elems.add((MessageMicro)localObject1);
      if (TextUtils.isEmpty(paramMessageForStructing.structingMsg.mCompatibleText)) {
        paramMessageForStructing.structingMsg.mCompatibleText = paramMessageForStructing.structingMsg.mMsgUrl;
      }
      localObject1 = localObject2;
    } while (TextUtils.isEmpty(paramMessageForStructing.structingMsg.mCompatibleText));
    Object localObject1 = new im_msg_body.Elem();
    Object localObject3 = new im_msg_body.Text();
    ((im_msg_body.Text)localObject3).str.set(ByteStringMicro.copyFrom(paramMessageForStructing.structingMsg.mCompatibleText.getBytes()));
    ((im_msg_body.Elem)localObject1).text.set((MessageMicro)localObject3);
    ((im_msg_body.RichText)localObject2).elems.add((MessageMicro)localObject1);
    return localObject2;
  }
  
  public static im_msg_body.RichText a(MessageForText paramMessageForText)
  {
    return a(paramMessageForText.msg, paramMessageForText.atInfoList);
  }
  
  public static im_msg_body.RichText a(MessageForTroopStory paramMessageForTroopStory)
  {
    Object localObject2 = new im_msg_body.CommonElem();
    ((im_msg_body.CommonElem)localObject2).uint32_service_type.set(16);
    Object localObject1 = new hummer_commelem.MsgElemInfo_servtype16();
    ((hummer_commelem.MsgElemInfo_servtype16)localObject1).uid.set(paramMessageForTroopStory.uid);
    ((hummer_commelem.MsgElemInfo_servtype16)localObject1).unionID.set(ByteStringMicro.copyFromUtf8(paramMessageForTroopStory.unionId));
    ((hummer_commelem.MsgElemInfo_servtype16)localObject1).storyID.set(ByteStringMicro.copyFromUtf8(paramMessageForTroopStory.storyId));
    ((hummer_commelem.MsgElemInfo_servtype16)localObject1).md5.set(ByteStringMicro.copyFromUtf8(paramMessageForTroopStory.md5));
    ((hummer_commelem.MsgElemInfo_servtype16)localObject1).thumbUrl.set(ByteStringMicro.copyFromUtf8(paramMessageForTroopStory.thumbUrl));
    ((hummer_commelem.MsgElemInfo_servtype16)localObject1).doodleUrl.set(ByteStringMicro.copyFromUtf8(paramMessageForTroopStory.doodleUrl));
    ((hummer_commelem.MsgElemInfo_servtype16)localObject1).videoWidth.set(paramMessageForTroopStory.videoWidth);
    ((hummer_commelem.MsgElemInfo_servtype16)localObject1).videoHeight.set(paramMessageForTroopStory.videoHeight);
    ((hummer_commelem.MsgElemInfo_servtype16)localObject1).sourceName.set(ByteStringMicro.copyFromUtf8(paramMessageForTroopStory.sourceName));
    ((hummer_commelem.MsgElemInfo_servtype16)localObject1).sourceActionType.set(ByteStringMicro.copyFromUtf8(paramMessageForTroopStory.sourceActionType));
    ((hummer_commelem.MsgElemInfo_servtype16)localObject1).sourceActionData.set(ByteStringMicro.copyFromUtf8(paramMessageForTroopStory.sourceActionData));
    ((hummer_commelem.MsgElemInfo_servtype16)localObject1).ctr_version.set(paramMessageForTroopStory.ctrVersion);
    ((im_msg_body.CommonElem)localObject2).bytes_pb_elem.set(ByteStringMicro.copyFrom(((hummer_commelem.MsgElemInfo_servtype16)localObject1).toByteArray()));
    localObject1 = new im_msg_body.Elem();
    ((im_msg_body.Elem)localObject1).common_elem.set((MessageMicro)localObject2);
    localObject2 = paramMessageForTroopStory.compatibleText;
    paramMessageForTroopStory = new im_msg_body.Text();
    paramMessageForTroopStory.str.set(ByteStringMicro.copyFromUtf8((String)localObject2));
    localObject2 = new im_msg_body.Elem();
    ((im_msg_body.Elem)localObject2).text.set(paramMessageForTroopStory);
    paramMessageForTroopStory = new im_msg_body.RichText();
    paramMessageForTroopStory.elems.add((MessageMicro)localObject1);
    paramMessageForTroopStory.elems.add((MessageMicro)localObject2);
    return paramMessageForTroopStory;
  }
  
  public static im_msg_body.RichText a(MessageRecord paramMessageRecord)
  {
    Object localObject3 = null;
    Object localObject4 = paramMessageRecord.getExtInfoFromExtStr("sens_msg_source_msg_info");
    Object localObject1;
    ArrayList localArrayList;
    Object localObject2;
    if (paramMessageRecord.msg == null)
    {
      localObject1 = "";
      localArrayList = paramMessageRecord.atInfoList;
      localObject2 = paramMessageRecord.getExtInfoFromExtStr("sens_reply_special_msg");
      paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("sens_reply_special_at_list");
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty(paramMessageRecord))) {
        break label548;
      }
      localArrayList = MessageForText.getTroopMemberInfoFromExtrJson(paramMessageRecord);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject4))
      {
        try
        {
          localSourceMsgInfo = (MessageForReplyText.SourceMsgInfo)aczw.c(aqhs.hexStr2Bytes((String)localObject4));
          if (localSourceMsgInfo == null) {
            break label543;
          }
          localObject4 = new im_msg_body.SourceMsg();
          ((im_msg_body.SourceMsg)localObject4).uint32_orig_seqs.add(Integer.valueOf((int)localSourceMsgInfo.mSourceMsgSeq));
          paramMessageRecord = a(localSourceMsgInfo.mSourceMsgText, null);
          ((im_msg_body.SourceMsg)localObject4).elems.set(paramMessageRecord.elems.get());
          if (localSourceMsgInfo.getSourceMsg() != null) {
            ((im_msg_body.SourceMsg)localObject4).bytes_src_msg.set(ByteStringMicro.copyFrom(localSourceMsgInfo.getSourceMsg()));
          }
          if (!TextUtils.isEmpty(localSourceMsgInfo.mAnonymousNickName))
          {
            paramMessageRecord = new im_msg_body.AnonymousGroupMsg();
            paramMessageRecord.str_anon_nick.set(ByteStringMicro.copyFromUtf8(localSourceMsgInfo.mAnonymousNickName));
            localObject1 = new im_msg_body.Elem();
            ((im_msg_body.Elem)localObject1).anon_group_msg.set(paramMessageRecord);
            ((im_msg_body.SourceMsg)localObject4).elems.add((MessageMicro)localObject1);
          }
          if (!TextUtils.isEmpty(localSourceMsgInfo.mSourceMsgTroopName)) {
            ((im_msg_body.SourceMsg)localObject4).bytes_troop_name.set(ByteStringMicro.copyFromUtf8(localSourceMsgInfo.mSourceMsgTroopName));
          }
          ((im_msg_body.SourceMsg)localObject4).uint64_sender_uin.set(localSourceMsgInfo.mSourceMsgSenderUin);
          ((im_msg_body.SourceMsg)localObject4).uint64_to_uin.set(localSourceMsgInfo.mSourceMsgToUin);
          ((im_msg_body.SourceMsg)localObject4).uint32_time.set(localSourceMsgInfo.mSourceMsgTime);
          ((im_msg_body.SourceMsg)localObject4).uint32_flag.set(localSourceMsgInfo.mSourceSummaryFlag);
          ((im_msg_body.SourceMsg)localObject4).uint32_type.set(localSourceMsgInfo.mType);
          if (localSourceMsgInfo.mRichMsg != null) {
            ((im_msg_body.SourceMsg)localObject4).bytes_richMsg.set(ByteStringMicro.copyFromUtf8(localSourceMsgInfo.mRichMsg));
          }
          if (localSourceMsgInfo.oriMsgType == 0) {
            break label538;
          }
          paramMessageRecord = new source_msg.ResvAttr();
          paramMessageRecord.uint32_ori_msgtype.set(localSourceMsgInfo.oriMsgType);
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            MessageForReplyText.SourceMsgInfo localSourceMsgInfo;
            paramMessageRecord = localObject3;
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.", 2, "getSourceMsgInfo exception:" + localException1.getMessage());
            }
            continue;
            localMessageRecord = paramMessageRecord;
            continue;
            paramMessageRecord = null;
          }
        }
        if (localSourceMsgInfo.origUid != 0L)
        {
          localObject1 = paramMessageRecord;
          if (paramMessageRecord == null) {
            localObject1 = new source_msg.ResvAttr();
          }
          ((source_msg.ResvAttr)localObject1).uint64_orig_uids.add(Long.valueOf(localSourceMsgInfo.origUid));
          if (localObject1 != null) {
            ((im_msg_body.SourceMsg)localObject4).bytes_pb_reserve.set(ByteStringMicro.copyFrom(((source_msg.ResvAttr)localObject1).toByteArray()));
          }
        }
      }
      MessageRecord localMessageRecord;
      label538:
      label543:
      for (paramMessageRecord = new im_msg_body.RichText();; paramMessageRecord = null)
      {
        try
        {
          localObject1 = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject1).src_msg.set((MessageMicro)localObject4);
          paramMessageRecord.elems.add((MessageMicro)localObject1);
          a(paramMessageRecord, (String)localObject2, localArrayList);
          localObject1 = paramMessageRecord;
          if (paramMessageRecord == null) {
            localObject1 = a((String)localObject2, localArrayList);
          }
          return localObject1;
        }
        catch (Exception localException2)
        {
          continue;
        }
        localObject1 = paramMessageRecord.msg;
        break;
      }
      label548:
      localObject2 = localMessageRecord;
    }
  }
  
  public static im_msg_body.RichText a(String paramString, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList)
  {
    im_msg_body.RichText localRichText2 = new im_msg_body.RichText();
    im_msg_body.RichText localRichText1 = localRichText2;
    if (a(localRichText2, paramString, paramArrayList) <= 0) {
      localRichText1 = null;
    }
    return localRichText1;
  }
  
  public static void a(MessageHandler paramMessageHandler, long paramLong1, int paramInt1, long paramLong2, int paramInt2)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", paramMessageHandler.app.getCurrentAccountUin(), "MessageSvc.PbDeleteMsg");
    msg_svc.PbDeleteMsgReq localPbDeleteMsgReq = new msg_svc.PbDeleteMsgReq();
    msg_svc.PbDeleteMsgReq.MsgItem localMsgItem = new msg_svc.PbDeleteMsgReq.MsgItem();
    localMsgItem.from_uin.set(paramLong1);
    localMsgItem.msg_seq.set(paramInt1);
    localMsgItem.msg_uid.set(paramLong2);
    paramLong2 = 0L;
    try
    {
      paramLong1 = Long.parseLong(paramMessageHandler.app.getCurrentAccountUin());
      localMsgItem.to_uin.set(paramLong1);
      localMsgItem.msg_type.set(paramInt2);
      localPbDeleteMsgReq.msgItems.add(localMsgItem);
      localToServiceMsg.putWupBuffer(localPbDeleteMsgReq.toByteArray());
      localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
      paramMessageHandler.app.sendToService(localToServiceMsg);
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
  
  public static void a(MessageHandler paramMessageHandler, long paramLong1, int paramInt1, long paramLong2, int paramInt2, byte[] paramArrayOfByte)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", paramMessageHandler.app.getCurrentAccountUin(), "MessageSvc.PbDeleteMsg");
    msg_svc.PbDeleteMsgReq localPbDeleteMsgReq = new msg_svc.PbDeleteMsgReq();
    msg_svc.PbDeleteMsgReq.MsgItem localMsgItem = new msg_svc.PbDeleteMsgReq.MsgItem();
    localMsgItem.from_uin.set(paramLong1);
    localMsgItem.msg_seq.set(paramInt1);
    localMsgItem.msg_uid.set(paramLong2);
    paramLong2 = 0L;
    try
    {
      paramLong1 = Long.parseLong(paramMessageHandler.app.getCurrentAccountUin());
      localMsgItem.to_uin.set(paramLong1);
      localMsgItem.msg_type.set(paramInt2);
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
        localMsgItem.sig.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      }
      localPbDeleteMsgReq.msgItems.add(localMsgItem);
      localToServiceMsg.putWupBuffer(localPbDeleteMsgReq.toByteArray());
      localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
      paramMessageHandler.app.sendToService(localToServiceMsg);
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
  
  public static void a(MessageHandler paramMessageHandler, List<MessageRecord> paramList, msg_comm.Msg paramMsg, boolean paramBoolean1, boolean paramBoolean2, aozx paramaozx)
  {
    a(paramMessageHandler, paramList, paramMsg, paramBoolean1, paramBoolean2, paramaozx, null, null);
  }
  
  public static void a(MessageHandler paramMessageHandler, List<MessageRecord> paramList, msg_comm.Msg paramMsg, boolean paramBoolean1, boolean paramBoolean2, aozx paramaozx, anbm paramanbm, anax paramanax)
  {
    List localList = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("<---decodePBMsgElems: elems: ");
      if (localList != null) {
        break label88;
      }
    }
    label88:
    for (Object localObject = null;; localObject = Integer.valueOf(localList.size()))
    {
      QLog.d("Q.msg.MessageHandler", 2, localObject);
      if ((localList != null) && (localList.size() > 0)) {
        break;
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("<---decodePBMsgElems:");
    ArrayList localArrayList = anbf.D(localList);
    int i = anbf.s(localArrayList);
    if (QLog.isColorLevel()) {
      localStringBuilder.append("decodeElemType:").append(i).append(" ElemStrs:").append(localArrayList.toString()).append("\n");
    }
    anbg localanbg = new anbg();
    if (QLog.isColorLevel()) {
      QLog.d("flash", 2, "decodePBMsgElems decodeElemType=" + i);
    }
    switch (i)
    {
    }
    for (;;)
    {
      a(localList, paramMsg, paramList, localStringBuilder, paramMessageHandler.app.b(), paramBoolean2);
      if (paramList.isEmpty()) {
        localanbg.g(localList, paramList, localStringBuilder, paramMsg, paramaozx);
      }
      if (paramList.isEmpty()) {
        localanbg.i(localList, paramList, localStringBuilder, paramMsg, paramaozx);
      }
      localanbg.P(localList, paramList);
      if (anbf.L(localArrayList)) {
        localanbg.a(localArrayList, localList, paramList, localStringBuilder, paramMsg, paramaozx, paramanbm, paramanax);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
      return;
      localanbg.a(localList, paramList, localStringBuilder, paramMsg);
      continue;
      localanbg.b(localList, paramList, localStringBuilder, paramBoolean1);
      continue;
      localanbg.b(localList, paramList, localStringBuilder, paramMsg);
      continue;
      localanbg.d(localList, paramList, localStringBuilder, paramMsg, paramaozx);
      continue;
      localanbg.b(localList, paramList, localStringBuilder, paramMsg, paramaozx);
      continue;
      localanbg.c(localList, paramList, localStringBuilder, paramMsg, paramaozx);
      continue;
      localanbg.e(localList, paramList, localStringBuilder, paramMsg, paramaozx);
      continue;
      localanbg.c(localList, paramList, localStringBuilder);
      continue;
      localanbg.a(localList, paramList, localStringBuilder);
      continue;
      localanbg.d(localList, paramList, localStringBuilder);
      continue;
      localanbg.h(localList, paramList, localStringBuilder, paramMsg, paramaozx);
      continue;
      localanbg.d(localList, paramList, localStringBuilder, paramMsg);
      continue;
      localanbg.f(localList, paramList, localStringBuilder, paramMsg, paramaozx);
      continue;
      localanbg.h(localList, paramList, localStringBuilder);
      continue;
      localanbg.i(localList, paramList, localStringBuilder);
      continue;
      localanbg.g(localList, paramList, localStringBuilder, paramMsg, paramaozx);
      continue;
      localanbg.a(localList, paramList, localStringBuilder, paramMsg, paramaozx, paramBoolean1);
      continue;
      localanbg.a(paramMessageHandler, localList, paramList, localStringBuilder, paramMsg, paramaozx, paramBoolean1);
      continue;
      localanbg.a(paramMessageHandler, localList, paramList, localStringBuilder, paramMsg, paramaozx);
      continue;
      localanbg.i(localList, paramList, localStringBuilder, paramMsg, paramaozx);
      continue;
      localanbg.a(localList, paramList, localStringBuilder, paramMsg, paramBoolean1);
      continue;
      localanbg.b(localList, paramList, localStringBuilder, paramMsg, paramBoolean1);
      continue;
      localanbg.e(localList, paramList, localStringBuilder);
      continue;
      localanbg.f(localList, paramList, localStringBuilder);
      continue;
      if (paramBoolean1)
      {
        if (paramMessageHandler.app.getLongAccountUin() == paramMsg.msg_head.to_uin.get()) {}
        for (localObject = paramMsg.msg_head.from_uin.get() + "";; localObject = paramMsg.msg_head.to_uin.get() + "")
        {
          localanbg.a(localList, paramList, localStringBuilder, paramMsg, (String)localObject);
          break;
        }
      }
      if (paramaozx != null) {}
      for (localObject = paramaozx.frienduin;; localObject = paramMsg.msg_head.to_uin.get() + "") {
        break;
      }
      localanbg.g(localList, paramList, localStringBuilder);
      continue;
      localanbg.e(localList, paramList, localStringBuilder, paramMsg);
      continue;
      localanbg.j(localList, paramList, localStringBuilder);
      continue;
      localanbg.b(localList, paramList, localStringBuilder);
      continue;
      aiup.a(paramMessageHandler.app, localList, paramList, localStringBuilder, paramMsg, paramBoolean1, paramaozx);
      continue;
      localanbg.c(localList, paramList, localStringBuilder, paramMsg);
    }
  }
  
  private static void a(MessageForText.AtTroopMemberInfo paramAtTroopMemberInfo, im_msg_body.Elem paramElem)
  {
    if (paramAtTroopMemberInfo != null)
    {
      byte[] arrayOfByte = new byte[13];
      aqoj.Word2Byte(arrayOfByte, 0, (short)1);
      paramAtTroopMemberInfo.writeTo(arrayOfByte, 2);
      paramElem.text.attr_6_buf.set(ByteStringMicro.copyFrom(arrayOfByte));
    }
  }
  
  private static void a(List<im_msg_body.Elem> paramList, msg_comm.Msg paramMsg, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, QQMessageFacade paramQQMessageFacade, boolean paramBoolean)
  {
    paramQQMessageFacade = paramQQMessageFacade.a().cw().iterator();
    while (paramQQMessageFacade.hasNext())
    {
      tpp localtpp = (tpp)paramQQMessageFacade.next();
      if (localtpp != null) {
        localtpp.a(paramList, paramMsg, paramList1, paramStringBuilder, paramBoolean);
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, msg_svc.RoutingHead paramRoutingHead)
  {
    if (paramRoutingHead == null) {
      return false;
    }
    int i = c(paramMessageRecord.istroop, paramQQAppInterface);
    return ((tpu)paramQQAppInterface.b().a().a().get(Integer.valueOf(i))).a(paramRoutingHead, paramMessageRecord, paramQQAppInterface);
  }
  
  public static int b(int paramInt, QQAppInterface paramQQAppInterface)
  {
    return ((tpu)paramQQAppInterface.b().a().a().get(Integer.valueOf(paramInt))).lk();
  }
  
  public static int b(msg_comm.Msg paramMsg)
  {
    int j;
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has())) {
      j = 0;
    }
    for (;;)
    {
      return j;
      Object localObject = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get().iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        paramMsg = (im_msg_body.Elem)((Iterator)localObject).next();
      } while ((!paramMsg.general_flags.has()) || (!((im_msg_body.GeneralFlags)paramMsg.general_flags.get()).bytes_pb_reserve.has()));
      localObject = new generalflags.ResvAttr();
      try
      {
        ((generalflags.ResvAttr)localObject).mergeFrom(paramMsg.general_flags.bytes_pb_reserve.get().toByteArray());
        if (!((generalflags.ResvAttr)localObject).uint32_req_font_effect_id.has()) {
          break label205;
        }
        i = ((generalflags.ResvAttr)localObject).uint32_req_font_effect_id.get();
        j = i;
        try
        {
          if (QLog.isColorLevel())
          {
            QLog.d("Q.msg.MessageHandler", 2, "decodeC2CMsgPkg_FontEffectID->" + i);
            return i;
          }
        }
        catch (InvalidProtocolBufferMicroException paramMsg) {}
      }
      catch (InvalidProtocolBufferMicroException paramMsg)
      {
        for (;;)
        {
          int i = 0;
        }
      }
    }
    paramMsg.printStackTrace();
    return i;
    label205:
    return 0;
  }
  
  public static im_msg_body.RichText b(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForLimitChatConfirm)))
    {
      Object localObject1 = (MessageForLimitChatConfirm)paramChatMessage;
      Object localObject2 = new im_msg_body.CommonElem();
      ((im_msg_body.CommonElem)localObject2).uint32_service_type.set(24);
      paramChatMessage = new im_msg_body.Elem();
      hummer_commelem.MsgElemInfo_servtype24 localMsgElemInfo_servtype24 = new hummer_commelem.MsgElemInfo_servtype24();
      if (((MessageForLimitChatConfirm)localObject1).bEnterMsg)
      {
        localMsgElemInfo_servtype24.limit_chat_enter.bytes_match_nick.set(ByteStringMicro.copyFromUtf8(((MessageForLimitChatConfirm)localObject1).SenderNickName));
        localMsgElemInfo_servtype24.limit_chat_enter.bytes_tips_wording.set(ByteStringMicro.copyFromUtf8(((MessageForLimitChatConfirm)localObject1).tipsWording));
        localMsgElemInfo_servtype24.limit_chat_enter.uint32_left_chat_time.set(((MessageForLimitChatConfirm)localObject1).leftChatTime);
        localMsgElemInfo_servtype24.limit_chat_enter.uint32_c2c_expired_time.set(((MessageForLimitChatConfirm)localObject1).c2cExpiredTime);
        localMsgElemInfo_servtype24.limit_chat_enter.uint32_match_expired_time.set(((MessageForLimitChatConfirm)localObject1).matchExpiredTime);
        localMsgElemInfo_servtype24.limit_chat_enter.uint64_match_ts.set(((MessageForLimitChatConfirm)localObject1).timeStamp);
        localMsgElemInfo_servtype24.limit_chat_enter.uint64_ready_ts.set(((MessageForLimitChatConfirm)localObject1).readyTs);
        localMsgElemInfo_servtype24.limit_chat_enter.setHasFlag(true);
        if (!((MessageForLimitChatConfirm)localObject1).bEnterMsg) {
          break label352;
        }
      }
      label352:
      for (int i = 1;; i = 2)
      {
        ((im_msg_body.CommonElem)localObject2).uint32_business_type.set(i, true);
        ((im_msg_body.CommonElem)localObject2).bytes_pb_elem.set(ByteStringMicro.copyFrom(localMsgElemInfo_servtype24.toByteArray()), true);
        paramChatMessage.common_elem.set((MessageMicro)localObject2, true);
        localObject1 = new im_msg_body.Elem();
        localObject2 = new im_msg_body.Text();
        ((im_msg_body.Text)localObject2).str.set(ByteStringMicro.copyFromUtf8(acfp.m(2131708229)));
        ((im_msg_body.Elem)localObject1).text.set((MessageMicro)localObject2);
        ((im_msg_body.Elem)localObject1).text.setHasFlag(true);
        localObject2 = new im_msg_body.RichText();
        ((im_msg_body.RichText)localObject2).elems.add((MessageMicro)localObject1);
        ((im_msg_body.RichText)localObject2).elems.add(paramChatMessage);
        if (QLog.isColorLevel()) {
          QLog.d("LimitChat", 2, "getSendLimitChatConfirmMsgBody");
        }
        return localObject2;
        localMsgElemInfo_servtype24.limit_chat_exit.uint32_exit_method.set(((MessageForLimitChatConfirm)localObject1).leaveChatType);
        localMsgElemInfo_servtype24.limit_chat_exit.uint64_match_ts.set(((MessageForLimitChatConfirm)localObject1).timeStamp);
        localMsgElemInfo_servtype24.limit_chat_exit.setHasFlag(true);
        break;
      }
    }
    return null;
  }
  
  public static im_msg_body.RichText b(ChatMessage paramChatMessage, boolean paramBoolean)
  {
    if (paramChatMessage == null)
    {
      paramChatMessage = null;
      return paramChatMessage;
    }
    if (!(paramChatMessage instanceof MessageForArkApp)) {
      return null;
    }
    Object localObject1 = (MessageForArkApp)paramChatMessage;
    if ((localObject1 == null) || (((MessageForArkApp)localObject1).ark_app_message == null)) {
      return null;
    }
    Object localObject2 = ((MessageForArkApp)localObject1).ark_app_message.toPbData();
    if ((localObject2 == null) || (localObject2.length == 0)) {
      return null;
    }
    localObject2 = ansi.compress((byte[])localObject2);
    if ((localObject2 == null) || (localObject2.length == 0)) {
      return null;
    }
    Object localObject3 = new ByteArrayOutputStream();
    try
    {
      ((ByteArrayOutputStream)localObject3).write(1);
      ((ByteArrayOutputStream)localObject3).write((byte[])localObject2);
      if ((!TextUtils.isEmpty(((MessageForArkApp)localObject1).resIDForLongMsg)) && (!paramBoolean))
      {
        paramChatMessage = new im_msg_body.RichText();
        localObject2 = new im_msg_body.Elem();
        ((im_msg_body.Elem)localObject2).general_flags.long_text_flag.set(1);
        ((im_msg_body.Elem)localObject2).general_flags.long_text_resid.set(ByteStringMicro.copyFromUtf8(((MessageForArkApp)localObject1).resIDForLongMsg));
        paramChatMessage.elems.add((MessageMicro)localObject2);
        return paramChatMessage;
      }
    }
    catch (Exception paramChatMessage)
    {
      return null;
    }
    Object localObject4;
    if (((MessageForArkApp)localObject1).ark_app_message.containStructMsg != null)
    {
      localObject1 = a((MessageForStructing)((MessageForArkApp)localObject1).ark_app_message.containStructMsg);
      localObject4 = new hummer_commelem.MsgElemInfo_servtype20();
      ((hummer_commelem.MsgElemInfo_servtype20)localObject4).bytes_data.set(ByteStringMicro.copyFrom(((ByteArrayOutputStream)localObject3).toByteArray()));
      localObject2 = new im_msg_body.CommonElem();
      ((im_msg_body.CommonElem)localObject2).uint32_service_type.set(20);
      ((im_msg_body.CommonElem)localObject2).bytes_pb_elem.set(ByteStringMicro.copyFrom(((hummer_commelem.MsgElemInfo_servtype20)localObject4).toByteArray()));
      localObject3 = ((im_msg_body.CommonElem)localObject2).uint32_business_type;
      if (!"1".equals(paramChatMessage.getExtInfoFromExtStr(anbb.ccN))) {
        break label469;
      }
    }
    label469:
    for (int i = 1;; i = 0)
    {
      ((PBUInt32Field)localObject3).set(i);
      localObject3 = new im_msg_body.Elem();
      ((im_msg_body.Elem)localObject3).common_elem.set((MessageMicro)localObject2);
      paramChatMessage = (ChatMessage)localObject1;
      if (localObject1 == null) {
        break;
      }
      ((im_msg_body.RichText)localObject1).elems.add((MessageMicro)localObject3);
      return localObject1;
      localObject2 = new im_msg_body.RichText();
      if (((MessageForArkApp)localObject1).ark_app_message.compatibleText != null) {
        localObject1 = ((MessageForArkApp)localObject1).ark_app_message.compatibleText;
      }
      for (;;)
      {
        if ((localObject1 != null) && (((String)localObject1).length() > 0))
        {
          localObject4 = new im_msg_body.Text();
          ((im_msg_body.Text)localObject4).str.set(ByteStringMicro.copyFromUtf8((String)localObject1));
          localObject1 = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject1).text.set((MessageMicro)localObject4);
          ((im_msg_body.RichText)localObject2).elems.add((MessageMicro)localObject1);
        }
        localObject1 = localObject2;
        break;
        localObject1 = ((MessageForArkApp)localObject1).getSummery();
        if ((localObject1 == null) || (((String)localObject1).length() == 0)) {
          localObject1 = BaseApplication.getContext().getString(2131695294);
        } else {
          localObject1 = String.format(BaseApplication.getContext().getString(2131695295), new Object[] { localObject1 });
        }
      }
    }
  }
  
  public static im_msg_body.RichText b(MessageForApollo paramMessageForApollo)
  {
    im_msg_body.ApolloActMsg localApolloActMsg = new im_msg_body.ApolloActMsg();
    ApolloMessage localApolloMessage = paramMessageForApollo.mApolloMessage;
    localApolloActMsg.uint32_action_id.set(localApolloMessage.id);
    localApolloActMsg.uint32_flag.set(localApolloMessage.flag);
    localApolloActMsg.uint32_peer_uin.set(aqft.ag(localApolloMessage.peer_uin));
    localApolloActMsg.uint32_sender_ts.set(aqft.ag(localApolloMessage.sender_ts));
    localApolloActMsg.uint32_peer_ts.set(aqft.ag(localApolloMessage.peer_ts));
    localApolloActMsg.int32_sender_status.set(localApolloMessage.sender_status);
    localApolloActMsg.int32_peer_status.set(localApolloMessage.peer_status);
    Object localObject1 = new ApolloMsgExtend.AuthReserve();
    ((ApolloMsgExtend.AuthReserve)localObject1).diy_voice_id.set(paramMessageForApollo.audioId);
    ((ApolloMsgExtend.AuthReserve)localObject1).diy_voice_begin_ts.set((paramMessageForApollo.audioStartTime * 1000.0F));
    ((ApolloMsgExtend.AuthReserve)localObject1).game_id.set(paramMessageForApollo.gameId);
    ((ApolloMsgExtend.AuthReserve)localObject1).sub_type.set(paramMessageForApollo.msgType);
    ((ApolloMsgExtend.AuthReserve)localObject1).room_id.set(paramMessageForApollo.roomId);
    if (!TextUtils.isEmpty(paramMessageForApollo.gameName)) {
      ((ApolloMsgExtend.AuthReserve)localObject1).game_name.set(ByteStringMicro.copyFrom(paramMessageForApollo.gameName.getBytes()));
    }
    if (!TextUtils.isEmpty(paramMessageForApollo.gameExtendJson)) {
      ((ApolloMsgExtend.AuthReserve)localObject1).game_share_ark_json.set(ByteStringMicro.copyFrom(paramMessageForApollo.gameExtendJson.getBytes()));
    }
    ((ApolloMsgExtend.AuthReserve)localObject1).action_type.set(paramMessageForApollo.actionType);
    if (!TextUtils.isEmpty(paramMessageForApollo.extendJson)) {
      ((ApolloMsgExtend.AuthReserve)localObject1).extend_json.set(ByteStringMicro.copyFrom(paramMessageForApollo.extendJson.getBytes()));
    }
    if (paramMessageForApollo.mApollo3DMessage != null)
    {
      localObject2 = paramMessageForApollo.mApollo3DMessage;
      ApolloMsgExtend.ThreeDBaseInfo localThreeDBaseInfo = new ApolloMsgExtend.ThreeDBaseInfo();
      localThreeDBaseInfo.uint32_action_id.set(((Apollo3DMessage)localObject2).actionID_3D);
      localThreeDBaseInfo.action_type.set(((Apollo3DMessage)localObject2).actionType_3D);
      localThreeDBaseInfo.bytes_action_name.set(ByteStringMicro.copyFrom(((Apollo3DMessage)localObject2).actionName_3D.getBytes()));
      localThreeDBaseInfo.int32_sender_status.set(((Apollo3DMessage)localObject2).senderStatus_3D);
      localThreeDBaseInfo.int32_peer_status.set(((Apollo3DMessage)localObject2).peerStatus_3D);
      ((ApolloMsgExtend.AuthReserve)localObject1).act3d.set(localThreeDBaseInfo);
    }
    localObject1 = ((ApolloMsgExtend.AuthReserve)localObject1).toByteArray();
    if ((localObject1 != null) && (localObject1.length > 0)) {
      localApolloActMsg.bytes_pb_reserve.set(ByteStringMicro.copyFrom((byte[])localObject1));
    }
    if (localApolloMessage.name != null) {
      localApolloActMsg.bytes_action_name.set(ByteStringMicro.copyFrom(localApolloMessage.name));
    }
    if (localApolloMessage.text != null) {
      localApolloActMsg.bytes_action_text.set(ByteStringMicro.copyFrom(localApolloMessage.text));
    }
    if (!TextUtils.isEmpty(paramMessageForApollo.inputText)) {
      localApolloActMsg.input_text.set(ByteStringMicro.copyFrom(paramMessageForApollo.inputText.getBytes()));
    }
    Object localObject2 = new im_msg_body.Text();
    localObject1 = acfp.m(2131708230);
    paramMessageForApollo = (MessageForApollo)localObject1;
    if (localApolloMessage.name != null) {
      paramMessageForApollo = (String)localObject1 + new String(localApolloMessage.name);
    }
    ((im_msg_body.Text)localObject2).str.set(ByteStringMicro.copyFromUtf8(paramMessageForApollo));
    paramMessageForApollo = new im_msg_body.RichText();
    localObject1 = new im_msg_body.Elem();
    ((im_msg_body.Elem)localObject1).apollo_msg.set(localApolloActMsg);
    paramMessageForApollo.elems.add((MessageMicro)localObject1);
    localObject1 = new im_msg_body.Elem();
    ((im_msg_body.Elem)localObject1).text.set((MessageMicro)localObject2);
    paramMessageForApollo.elems.add((MessageMicro)localObject1);
    return paramMessageForApollo;
  }
  
  public static int c(int paramInt, QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.b().a().a().eF(paramInt);
  }
  
  public static int c(msg_comm.Msg paramMsg)
  {
    int j;
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has())) {
      j = 0;
    }
    for (;;)
    {
      return j;
      Object localObject = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get().iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        paramMsg = (im_msg_body.Elem)((Iterator)localObject).next();
      } while ((!paramMsg.general_flags.has()) || (!((im_msg_body.GeneralFlags)paramMsg.general_flags.get()).bytes_pb_reserve.has()));
      localObject = new generalflags.ResvAttr();
      try
      {
        ((generalflags.ResvAttr)localObject).mergeFrom(paramMsg.general_flags.bytes_pb_reserve.get().toByteArray());
        if (!((generalflags.ResvAttr)localObject).uint32_pendant_diy_id.has()) {
          break label205;
        }
        i = ((generalflags.ResvAttr)localObject).uint32_pendant_diy_id.get();
        j = i;
        try
        {
          if (QLog.isColorLevel())
          {
            QLog.d("Q.msg.MessageHandler", 2, "decodeC2CMsgPkg_PendantDiyID->" + i);
            return i;
          }
        }
        catch (InvalidProtocolBufferMicroException paramMsg) {}
      }
      catch (InvalidProtocolBufferMicroException paramMsg)
      {
        for (;;)
        {
          int i = 0;
        }
      }
    }
    paramMsg.printStackTrace();
    return i;
    label205:
    return 0;
  }
  
  public static im_msg_body.RichText c(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {}
    Object localObject2;
    do
    {
      do
      {
        do
        {
          do
          {
            return null;
          } while (!(paramChatMessage instanceof MessageForArkFlashChat));
          paramChatMessage = (MessageForArkFlashChat)paramChatMessage;
        } while ((paramChatMessage == null) || (paramChatMessage.ark_app_message == null));
        localObject1 = paramChatMessage.ark_app_message.toPbData();
      } while ((localObject1 == null) || (localObject1.length == 0));
      localObject2 = ansi.compress((byte[])localObject1);
    } while ((localObject2 == null) || (localObject2.length == 0));
    Object localObject1 = new ByteArrayOutputStream();
    try
    {
      ((ByteArrayOutputStream)localObject1).write(1);
      ((ByteArrayOutputStream)localObject1).write((byte[])localObject2);
      localObject2 = new hummer_commelem.MsgElemInfo_servtype14();
      ((hummer_commelem.MsgElemInfo_servtype14)localObject2).reserve_Info.set(ByteStringMicro.copyFrom(((ByteArrayOutputStream)localObject1).toByteArray()));
      ((hummer_commelem.MsgElemInfo_servtype14)localObject2).uint32_id.set(paramChatMessage.ark_app_message.appResId);
      localObject1 = new im_msg_body.CommonElem();
      ((im_msg_body.CommonElem)localObject1).uint32_business_type.set(0);
      ((im_msg_body.CommonElem)localObject1).uint32_service_type.set(14);
      ((im_msg_body.CommonElem)localObject1).bytes_pb_elem.set(ByteStringMicro.copyFrom(((hummer_commelem.MsgElemInfo_servtype14)localObject2).toByteArray()));
      localObject2 = new im_msg_body.Elem();
      ((im_msg_body.Elem)localObject2).common_elem.set((MessageMicro)localObject1);
      paramChatMessage = a(anbk.a(paramChatMessage.getSummery(), true, null), null);
      paramChatMessage.elems.add((MessageMicro)localObject2);
      return paramChatMessage;
    }
    catch (Exception paramChatMessage) {}
    return null;
  }
  
  public static im_msg_body.RichText c(ChatMessage paramChatMessage, boolean paramBoolean)
  {
    int i = 1;
    if (paramChatMessage == null) {
      return null;
    }
    if (!(paramChatMessage instanceof MessageForArkBabyqReply)) {
      return null;
    }
    Object localObject1 = (MessageForArkBabyqReply)paramChatMessage;
    paramChatMessage = ((MessageForArkBabyqReply)localObject1).toPbData();
    if ((paramChatMessage == null) || (paramChatMessage.length == 0)) {
      return null;
    }
    paramChatMessage = ansi.compress(paramChatMessage);
    if ((paramChatMessage == null) || (paramChatMessage.length == 0)) {
      return null;
    }
    Object localObject2 = new ByteArrayOutputStream();
    try
    {
      ((ByteArrayOutputStream)localObject2).write(1);
      ((ByteArrayOutputStream)localObject2).write(paramChatMessage);
      paramChatMessage = new im_msg_body.RichText();
      if ((!TextUtils.isEmpty(((MessageForArkBabyqReply)localObject1).resIDForLongMsg)) && (!paramBoolean))
      {
        localObject2 = new im_msg_body.Elem();
        ((im_msg_body.Elem)localObject2).general_flags.long_text_flag.set(1);
        ((im_msg_body.Elem)localObject2).general_flags.long_text_resid.set(ByteStringMicro.copyFromUtf8(((MessageForArkBabyqReply)localObject1).resIDForLongMsg));
        paramChatMessage.elems.add((MessageMicro)localObject2);
        return paramChatMessage;
      }
    }
    catch (Exception paramChatMessage)
    {
      return null;
    }
    Object localObject3 = new hummer_commelem.MsgElemInfo_servtype19();
    ((hummer_commelem.MsgElemInfo_servtype19)localObject3).bytes_data.set(ByteStringMicro.copyFrom(((ByteArrayOutputStream)localObject2).toByteArray()));
    localObject2 = new im_msg_body.CommonElem();
    ((im_msg_body.CommonElem)localObject2).uint32_service_type.set(19);
    ((im_msg_body.CommonElem)localObject2).bytes_pb_elem.set(ByteStringMicro.copyFrom(((hummer_commelem.MsgElemInfo_servtype19)localObject3).toByteArray()));
    localObject3 = ((im_msg_body.CommonElem)localObject2).uint32_business_type;
    if (((MessageForArkBabyqReply)localObject1).showAsBabyq) {}
    for (;;)
    {
      ((PBUInt32Field)localObject3).set(i);
      localObject3 = new im_msg_body.Elem();
      ((im_msg_body.Elem)localObject3).common_elem.set((MessageMicro)localObject2);
      paramChatMessage.elems.add((MessageMicro)localObject3);
      localObject2 = ((MessageForArkBabyqReply)localObject1).babyqReplyText;
      if ((localObject2 == null) || (((String)localObject2).length() <= 0)) {
        break;
      }
      localObject1 = new im_msg_body.Text();
      ((im_msg_body.Text)localObject1).str.set(ByteStringMicro.copyFromUtf8((String)localObject2));
      localObject2 = new im_msg_body.Elem();
      ((im_msg_body.Elem)localObject2).text.set((MessageMicro)localObject1);
      paramChatMessage.elems.add((MessageMicro)localObject2);
      break;
      i = 2;
    }
  }
  
  public static int d(msg_comm.Msg paramMsg)
  {
    int j;
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has())) {
      j = 0;
    }
    for (;;)
    {
      return j;
      Object localObject = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get().iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        paramMsg = (im_msg_body.Elem)((Iterator)localObject).next();
      } while ((!paramMsg.general_flags.has()) || (!((im_msg_body.GeneralFlags)paramMsg.general_flags.get()).bytes_pb_reserve.has()));
      localObject = new generalflags.ResvAttr();
      try
      {
        ((generalflags.ResvAttr)localObject).mergeFrom(paramMsg.general_flags.bytes_pb_reserve.get().toByteArray());
        if (!((generalflags.ResvAttr)localObject).uint32_face_id.has()) {
          break label210;
        }
        i = ((generalflags.ResvAttr)localObject).uint32_face_id.get();
        j = i;
        try
        {
          if (QLog.isColorLevel())
          {
            QLog.d("Q.msg.MessageHandler", 2, "decodeC2CMsgPkg_FaceID->" + i);
            return i;
          }
        }
        catch (InvalidProtocolBufferMicroException paramMsg) {}
      }
      catch (InvalidProtocolBufferMicroException paramMsg)
      {
        for (;;)
        {
          int i = 0;
        }
      }
    }
    QLog.e("Q.msg.MessageHandler", 1, "", paramMsg);
    return i;
    label210:
    return 0;
  }
  
  public static im_msg_body.RichText d(ChatMessage paramChatMessage)
  {
    Object localObject1 = null;
    if (!(paramChatMessage instanceof MessageForHiBoom)) {
      paramChatMessage = (ChatMessage)localObject1;
    }
    do
    {
      do
      {
        return paramChatMessage;
        localObject2 = (MessageForHiBoom)paramChatMessage;
        paramChatMessage = (ChatMessage)localObject1;
      } while (((MessageForHiBoom)localObject2).mHiBoomMessage == null);
      paramChatMessage = new hummer_commelem.MsgElemInfo_servtype14();
      paramChatMessage.uint32_id.set(((MessageForHiBoom)localObject2).mHiBoomMessage.id);
      localObject1 = new hiboom_type.Hiboom_Type();
      ((hiboom_type.Hiboom_Type)localObject1).uint32_hiboom_type.set(((MessageForHiBoom)localObject2).mHiBoomMessage.type);
      paramChatMessage.reserve_Info.set(ByteStringMicro.copyFrom(((hiboom_type.Hiboom_Type)localObject1).toByteArray()));
      localObject1 = new im_msg_body.CommonElem();
      ((im_msg_body.CommonElem)localObject1).uint32_business_type.set(1);
      ((im_msg_body.CommonElem)localObject1).uint32_service_type.set(14);
      ((im_msg_body.CommonElem)localObject1).bytes_pb_elem.set(ByteStringMicro.copyFrom(paramChatMessage.toByteArray()));
      paramChatMessage = new im_msg_body.Elem();
      paramChatMessage.common_elem.set((MessageMicro)localObject1);
      localObject1 = new im_msg_body.RichText();
      ((im_msg_body.RichText)localObject1).elems.add(paramChatMessage);
      localObject2 = ((MessageForHiBoom)localObject2).mHiBoomMessage.text;
      paramChatMessage = (ChatMessage)localObject1;
    } while (TextUtils.isEmpty((CharSequence)localObject2));
    paramChatMessage = new im_msg_body.Text();
    paramChatMessage.str.set(ByteStringMicro.copyFromUtf8((String)localObject2));
    Object localObject2 = new im_msg_body.Elem();
    ((im_msg_body.Elem)localObject2).text.set(paramChatMessage);
    ((im_msg_body.RichText)localObject1).elems.add((MessageMicro)localObject2);
    return localObject1;
  }
  
  public static int e(msg_comm.Msg paramMsg)
  {
    int i;
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has())) {
      i = 0;
    }
    int j;
    do
    {
      return i;
      paramMsg = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get().iterator();
      im_msg_body.Elem localElem;
      do
      {
        if (!paramMsg.hasNext()) {
          break;
        }
        localElem = (im_msg_body.Elem)paramMsg.next();
      } while ((!localElem.general_flags.has()) || (!((im_msg_body.GeneralFlags)localElem.general_flags.get()).uint32_bubble_sub_id.has()));
      j = ((im_msg_body.GeneralFlags)localElem.general_flags.get()).uint32_bubble_sub_id.get();
      i = j;
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.MessageHandler", 2, "decodeC2CMsgPkg_SubBubbleID->" + j);
    return j;
    return 0;
  }
  
  public static im_msg_body.RichText e(ChatMessage paramChatMessage)
  {
    Object localObject1 = new im_msg_body.CommonElem();
    ((im_msg_body.CommonElem)localObject1).uint32_service_type.set(2);
    if ((paramChatMessage instanceof MessageForPoke))
    {
      localObject2 = new hummer_commelem.MsgElemInfo_servtype2();
      paramChatMessage = (MessageForPoke)paramChatMessage;
      int i = paramChatMessage.interactType;
      int j = paramChatMessage.doubleHitState;
      int k = paramChatMessage.strength;
      ((hummer_commelem.MsgElemInfo_servtype2)localObject2).uint32_poke_type.set(i);
      ((hummer_commelem.MsgElemInfo_servtype2)localObject2).uint32_double_hit.set(j);
      ((hummer_commelem.MsgElemInfo_servtype2)localObject2).uint32_vaspoke_id.set(paramChatMessage.subId);
      ((hummer_commelem.MsgElemInfo_servtype2)localObject2).bytes_vaspoke_name.set(ByteStringMicro.copyFromUtf8(paramChatMessage.name));
      ((hummer_commelem.MsgElemInfo_servtype2)localObject2).bytes_vaspoke_minver.set(ByteStringMicro.copyFromUtf8(paramChatMessage.minVersion));
      ((hummer_commelem.MsgElemInfo_servtype2)localObject2).uint32_poke_strength.set(k);
      ((hummer_commelem.MsgElemInfo_servtype2)localObject2).uint32_poke_flag.set(paramChatMessage.flag);
      ((im_msg_body.CommonElem)localObject1).bytes_pb_elem.set(ByteStringMicro.copyFrom(((hummer_commelem.MsgElemInfo_servtype2)localObject2).toByteArray()));
      ((im_msg_body.CommonElem)localObject1).uint32_business_type.set(i);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "getSendPokeMsgBody type:" + i + " ,doubleHitState:" + j);
      }
    }
    paramChatMessage = new im_msg_body.Elem();
    paramChatMessage.common_elem.set((MessageMicro)localObject1);
    Object localObject2 = acfp.m(2131708228);
    localObject1 = new im_msg_body.Text();
    ((im_msg_body.Text)localObject1).str.set(ByteStringMicro.copyFromUtf8((String)localObject2));
    localObject2 = new im_msg_body.Elem();
    ((im_msg_body.Elem)localObject2).text.set((MessageMicro)localObject1);
    localObject1 = new im_msg_body.RichText();
    ((im_msg_body.RichText)localObject1).elems.add(paramChatMessage);
    ((im_msg_body.RichText)localObject1).elems.add((MessageMicro)localObject2);
    if (QLog.isColorLevel()) {
      QLog.d("PokeMsg", 2, "getSendPokeMsgBody");
    }
    return localObject1;
  }
  
  public static im_msg_body.RichText f(ChatMessage paramChatMessage)
  {
    Object localObject3 = new im_msg_body.CommonElem();
    ((im_msg_body.CommonElem)localObject3).uint32_service_type.set(23);
    Object localObject2 = acfp.m(2131708233);
    Object localObject1 = "";
    hummer_commelem.MsgElemInfo_servtype23 localMsgElemInfo_servtype23;
    int i;
    int j;
    PBBytesField localPBBytesField;
    if ((paramChatMessage instanceof MessageForPokeEmo))
    {
      localMsgElemInfo_servtype23 = new hummer_commelem.MsgElemInfo_servtype23();
      paramChatMessage = (MessageForPokeEmo)paramChatMessage;
      i = paramChatMessage.pokeemoId;
      j = paramChatMessage.pokeemoPressCount;
      paramChatMessage = paramChatMessage.summary;
      localObject2 = String.format("[%s]x%d", new Object[] { paramChatMessage, Integer.valueOf(j) });
      localMsgElemInfo_servtype23.uint32_face_type.set(i);
      localMsgElemInfo_servtype23.uint32_face_bubble_count.set(j);
      localPBBytesField = localMsgElemInfo_servtype23.bytes_face_summary;
      if (paramChatMessage != null) {
        break label356;
      }
    }
    label356:
    for (localObject1 = "";; localObject1 = paramChatMessage)
    {
      localPBBytesField.set(ByteStringMicro.copyFromUtf8((String)localObject1));
      ((im_msg_body.CommonElem)localObject3).bytes_pb_elem.set(ByteStringMicro.copyFrom(localMsgElemInfo_servtype23.toByteArray()));
      ((im_msg_body.CommonElem)localObject3).uint32_business_type.set(i);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "getSendPokeEmoMsgBody pokeemoId:" + i + " ,pokeemoPressCount:" + j);
      }
      localObject1 = localObject2;
      localObject2 = paramChatMessage;
      paramChatMessage = new im_msg_body.Elem();
      paramChatMessage.common_elem.set((MessageMicro)localObject3);
      localObject3 = String.format("[%s]请使用最新版手机QQ体验新功能。", new Object[] { localObject2 });
      localObject2 = new im_msg_body.Text();
      ((im_msg_body.Text)localObject2).str.set(ByteStringMicro.copyFromUtf8((String)localObject1));
      localObject1 = new TextMsgExtPb.ResvAttr();
      ((TextMsgExtPb.ResvAttr)localObject1).wording.set(ByteStringMicro.copyFromUtf8((String)localObject3));
      ((im_msg_body.Text)localObject2).bytes_pb_reserve.set(ByteStringMicro.copyFrom(((TextMsgExtPb.ResvAttr)localObject1).toByteArray()));
      localObject1 = new im_msg_body.Elem();
      ((im_msg_body.Elem)localObject1).text.set((MessageMicro)localObject2);
      localObject2 = new im_msg_body.RichText();
      ((im_msg_body.RichText)localObject2).elems.add(paramChatMessage);
      ((im_msg_body.RichText)localObject2).elems.add((MessageMicro)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("PokeMsg", 2, "getSendPokeMsgBody");
      }
      return localObject2;
    }
  }
  
  public static im_msg_body.RichText g(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForScribble)))
    {
      Object localObject1 = (MessageForScribble)paramChatMessage;
      Object localObject2 = new im_msg_body.CommonElem();
      ((im_msg_body.CommonElem)localObject2).uint32_service_type.set(11);
      paramChatMessage = new im_msg_body.Elem();
      hummer_commelem.MsgElemInfo_servtype11 localMsgElemInfo_servtype11 = new hummer_commelem.MsgElemInfo_servtype11();
      localMsgElemInfo_servtype11.bytes_Doodle_url.set(ByteStringMicro.copyFromUtf8(((MessageForScribble)localObject1).combineFileUrl));
      localMsgElemInfo_servtype11.bytes_Doodle_md5.set(ByteStringMicro.copyFromUtf8(((MessageForScribble)localObject1).combineFileMd5));
      localMsgElemInfo_servtype11.uint32_doodleData_offset.set(((MessageForScribble)localObject1).offSet);
      localMsgElemInfo_servtype11.uint32_doodle_gif_id.set(((MessageForScribble)localObject1).gifId);
      ((im_msg_body.CommonElem)localObject2).uint32_business_type.set(1);
      ((im_msg_body.CommonElem)localObject2).bytes_pb_elem.set(ByteStringMicro.copyFrom(localMsgElemInfo_servtype11.toByteArray()));
      paramChatMessage.common_elem.set((MessageMicro)localObject2);
      localObject1 = new im_msg_body.Elem();
      localObject2 = new im_msg_body.Text();
      ((im_msg_body.Text)localObject2).str.set(ByteStringMicro.copyFromUtf8(acfp.m(2131708225)));
      ((im_msg_body.Elem)localObject1).text.set((MessageMicro)localObject2);
      ((im_msg_body.Elem)localObject1).text.setHasFlag(true);
      localObject2 = new im_msg_body.RichText();
      ((im_msg_body.RichText)localObject2).elems.add((MessageMicro)localObject1);
      ((im_msg_body.RichText)localObject2).elems.add(paramChatMessage);
      if (QLog.isColorLevel()) {
        QLog.d("pap", 2, "getSendPapScribeMsgBody");
      }
      return localObject2;
    }
    return null;
  }
  
  public static String nl(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < paramString.length())
    {
      if ((paramString.charAt(i) == '\024') && (i + 1 < paramString.length()))
      {
        int k = paramString.charAt(i + 1);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "localeCode value:" + k + ",max len:" + anbk.j.length);
        }
        j = i;
        if (afky.jr(k))
        {
          j = afky.hl(k);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "---faceIndex:" + j);
          }
          localStringBuilder.append(paramString.charAt(i));
          localStringBuilder.append((char)(j / 128 + 65));
          localStringBuilder.append((char)(j % 128 + 65));
        }
      }
      for (int j = i + 1;; j = i)
      {
        i = j + 1;
        break;
        localStringBuilder.append(paramString.charAt(i));
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anbh
 * JD-Core Version:    0.7.0.1
 */