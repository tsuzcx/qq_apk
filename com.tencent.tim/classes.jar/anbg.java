import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.ark.open.ArkUtil;
import com.tencent.biz.bmqq.protocol.Crm.CrmCCNotify;
import com.tencent.biz.bmqq.protocol.Crm.GrayMsg;
import com.tencent.biz.bmqq.protocol.Crm.QidianGroupMsg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.im.msg.hummer.resv12.MarketFaceExtPb.ResvAttr;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.data.Apollo3DMessage;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HiBoomMessage;
import com.tencent.mobileqq.data.KplRoleInfo;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForApproval;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForHiBoom;
import com.tencent.mobileqq.data.MessageForIncompatibleGrayTips;
import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.data.MessageForLimitChatConfirm;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForPokeEmo;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStarLeague;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageForTribeShortVideo;
import com.tencent.mobileqq.data.MessageForTroopEffectPic;
import com.tencent.mobileqq.data.MessageForTroopFee;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.mobileqq.data.MessageForTroopPobing;
import com.tencent.mobileqq.data.MessageForTroopSign;
import com.tencent.mobileqq.data.MessageForTroopStory;
import com.tencent.mobileqq.data.MessageForVIPDonate;
import com.tencent.mobileqq.data.MessageForWantGiftMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.QQWalletAioBodyReserve;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.mobileqq.data.RecommendCommonMessage;
import com.tencent.mobileqq.data.ShakeWindowMsg;
import com.tencent.mobileqq.data.TroopFileData;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.VIPDonateMsg;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.hiboom.hiboom_type.Hiboom_Type;
import com.tencent.mobileqq.nearby.NearbyFlowerMessage;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessagePBElemDecoder.1;
import com.tencent.mobileqq.service.message.MessagePBElemDecoder.2;
import com.tencent.mobileqq.shortvideo.redbag.VideoRedbagData;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.troop.data.TroopTipsEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.pb.apollomsgextend.ApolloMsgExtend.AuthReserve;
import com.tencent.pb.apollomsgextend.ApolloMsgExtend.ThreeDBaseInfo;
import com.tencent.qidian.data.BmqqAccountType;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.dingdong.MessageForDingdongSchedule;
import com.tencent.tim.todo.MessageForToDo;
import com.trunk.Qworkflow.Qworkflow.AppID;
import com.trunk.Qworkflow.Qworkflow.Notification;
import com.trunk.Qworkflow.Qworkflow.ScheduleChangeNotification;
import com.trunk.Qworkflow.Qworkflow.Text;
import com.trunk.Qworkflow.Qworkflow.TimTodoNotification;
import com.trunk.Qworkflow.Qworkflow.WorkflowChangeNotification;
import com.trunk.Qworkflow.Qworkflow.WorkflowState;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ltencent.im.msg.im_msg_body.Elem;>;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.Inflater;
import localpb.richMsg.RichMsg.PicRec;
import localpb.richMsg.RichMsg.VideoFile;
import mqq.os.MqqHandler;
import msf.msgcomm.msg_comm.C2CTmpMsgHead;
import msf.msgcomm.msg_comm.DiscussInfo;
import msf.msgcomm.msg_comm.GroupInfo;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.babyq.babyq_cookie.BabyQCookie;
import tencent.im.msg.hummer.resv.ResvAttrForGiftMsg.ActivityGiftInfo;
import tencent.im.msg.hummer.resv.ResvAttrForGiftMsg.InteractGift;
import tencent.im.msg.hummer.resv.ResvAttrForGiftMsg.ResvAttr;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.hummer.resv.source_msg.ResvAttr;
import tencent.im.msg.hummer.resv.videoFile.ResvAttr;
import tencent.im.msg.hummer.resv1.TextMsgExtPb.ResvAttr;
import tencent.im.msg.hummer.resv3.CustomFaceExtPb.AnimationImageShow;
import tencent.im.msg.hummer.resv3.CustomFaceExtPb.ResvAttr;
import tencent.im.msg.hummer.resv6.NotOnlineImageExtPb.ResvAttr;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype11;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype13;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype14;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype15;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype16;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype19;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype2;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype20;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype23;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype24;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype24.LimitChatEnter;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype24.LimitChatExit;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype27;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype3;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype33;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype5;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype8;
import tencent.im.msg.im_msg_body.AnonymousGroupMsg;
import tencent.im.msg.im_msg_body.ApolloActMsg;
import tencent.im.msg.im_msg_body.ArkAppElem;
import tencent.im.msg.im_msg_body.Attr;
import tencent.im.msg.im_msg_body.BlessingMessage;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.CrmElem;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.DeliverGiftMsg;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ElemFlags2;
import tencent.im.msg.im_msg_body.Face;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.msg.im_msg_body.GroupFile;
import tencent.im.msg.im_msg_body.GroupPubAccountInfo;
import tencent.im.msg.im_msg_body.LifeOnlineAccount;
import tencent.im.msg.im_msg_body.LightAppElem;
import tencent.im.msg.im_msg_body.MarketFace;
import tencent.im.msg.im_msg_body.MarketTrans;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.NearByMessageType;
import tencent.im.msg.im_msg_body.NotOnlineImage;
import tencent.im.msg.im_msg_body.OnlineImage;
import tencent.im.msg.im_msg_body.PubAccInfo;
import tencent.im.msg.im_msg_body.PubGroup;
import tencent.im.msg.im_msg_body.QQWalletAioBody;
import tencent.im.msg.im_msg_body.QQWalletMsg;
import tencent.im.msg.im_msg_body.RichMsg;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.ShakeWindow;
import tencent.im.msg.im_msg_body.SmallEmoji;
import tencent.im.msg.im_msg_body.SourceMsg;
import tencent.im.msg.im_msg_body.Text;
import tencent.im.msg.im_msg_body.TipsInfo;
import tencent.im.msg.im_msg_body.TransElem;
import tencent.im.msg.im_msg_body.VideoFile;
import tencent.im.msg.im_msg_body.WorkflowNotifyMsg;
import tencent.im.msg.obj_msg.MsgContentInfo;
import tencent.im.msg.obj_msg.MsgContentInfo.MsgFile;
import tencent.im.msg.obj_msg.ObjMsg;
import tencent.im.msg.resv21.hummer_resv_21.FileImgInfo;
import tencent.im.msg.resv21.hummer_resv_21.ResvAttr;
import tencent.im.oidb.oidb_0xdea.PassThrough;

public class anbg
{
  private QQAppInterface app = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
  private MessageHandler c = this.app.a();
  
  public static byte[] A(byte[] paramArrayOfByte)
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
  
  public static MessageForQQWalletMsg a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new JSONObject(paramString1);
      if (paramString1 != null)
      {
        MessageForQQWalletMsg localMessageForQQWalletMsg = (MessageForQQWalletMsg)anbi.d(-2025);
        localMessageForQQWalletMsg.msgtype = -2025;
        localMessageForQQWalletMsg.messageType = paramString1.getInt("msgType");
        localMessageForQQWalletMsg.mQQWalletTransferMsg = null;
        localMessageForQQWalletMsg.mQQWalletRedPacketMsg = a(paramString1, paramString2);
        if (localMessageForQQWalletMsg.mQQWalletRedPacketMsg == null) {
          return null;
        }
        localMessageForQQWalletMsg.msg = localMessageForQQWalletMsg.getMsgSummary();
        localMessageForQQWalletMsg.msgData = localMessageForQQWalletMsg.getBytes();
        return localMessageForQQWalletMsg;
      }
    }
    catch (Exception paramString1)
    {
      return null;
    }
    return null;
  }
  
  @NotNull
  private MessageForShortVideo a(im_msg_body.GeneralFlags paramGeneralFlags, RichMsg.VideoFile paramVideoFile)
  {
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)anbi.d(-2022);
    localMessageForShortVideo.msgtype = -2022;
    localMessageForShortVideo.msgData = paramVideoFile.toByteArray();
    if (paramVideoFile.uint32_busi_type.get() == 2) {}
    for (localMessageForShortVideo.msg = anft.cdz;; localMessageForShortVideo.msg = anft.cdy)
    {
      if ((paramGeneralFlags != null) && (paramGeneralFlags.babyq_guide_msg_cookie.has())) {}
      try
      {
        babyq_cookie.BabyQCookie localBabyQCookie = new babyq_cookie.BabyQCookie();
        byte[] arrayOfByte = paramGeneralFlags.babyq_guide_msg_cookie.get().toByteArray();
        localBabyQCookie = (babyq_cookie.BabyQCookie)localBabyQCookie.mergeFrom(arrayOfByte);
        if ((localBabyQCookie.uint32_need_not_report.has()) && (localBabyQCookie.uint32_need_not_report.get() == 0))
        {
          String str = aqft.bytesToHexString(arrayOfByte);
          if (QLog.isColorLevel()) {
            QLog.d("DecodeMsg", 2, "decodePBMsgElems_VideoFile, guideMsgCookie: " + str + ",bytes: " + Arrays.toString(paramGeneralFlags.babyq_guide_msg_cookie.get().toByteArray()));
          }
          localMessageForShortVideo.saveExtInfoToExtStr("guide_msg_cookie", str);
        }
        if (localBabyQCookie.uint32_video_type.has())
        {
          int i = localBabyQCookie.uint32_video_type.get();
          if (QLog.isColorLevel()) {
            QLog.d("DecodeMsg", 2, "decodePBMsgElems_VideoFile, video_type: " + i);
          }
          localMessageForShortVideo.saveExtInfoToExtStr("guide_video_type", String.valueOf(i));
        }
        ((acbs)this.app.getBusinessHandler(53)).au(arrayOfByte);
      }
      catch (Exception paramGeneralFlags)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("DecodeMsg", 2, "get video guideMsgCookie error!", paramGeneralFlags);
          }
        }
      }
      localMessageForShortVideo.parse();
      if (localMessageForShortVideo.redBagType == LocalMediaInfo.REDBAG_TYPE_GET)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DecodeMsg", 2, "VideoRedbag, decodePBMsgElems_VideoFile");
        }
        anjo.R(this.app, false);
        if (VideoRedbagData.queryRewardStat(localMessageForShortVideo.shortVideoId))
        {
          localMessageForShortVideo.redBagStat = 1;
          paramVideoFile.red_envelope_pay_stat.set(1);
        }
      }
      return localMessageForShortVideo;
    }
  }
  
  public static MessageForVIPDonate a(String paramString, boolean paramBoolean)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("DecodeMsg", 1, "content is empty ");
      localObject = null;
      return localObject;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DecodeMsg", 2, "createVIPDonateMsg: msg = " + paramString);
    }
    JSONObject localJSONObject;
    VIPDonateMsg localVIPDonateMsg;
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject(paramString);
        if (localJSONObject == null) {
          break label444;
        }
        MessageForVIPDonate localMessageForVIPDonate = (MessageForVIPDonate)anbi.d(-2047);
        localMessageForVIPDonate.msgtype = -2047;
        localVIPDonateMsg = new VIPDonateMsg();
        if (localJSONObject.has("title"))
        {
          localObject = localJSONObject.getString("title");
          localVIPDonateMsg.title = ((String)localObject);
          if (!localJSONObject.has("footer")) {
            break label328;
          }
          localObject = localJSONObject.getString("footer");
          localVIPDonateMsg.footer = ((String)localObject);
          if (!paramBoolean) {
            break label348;
          }
          if (!localJSONObject.has("sendsubtitle")) {
            break label333;
          }
          localObject = localJSONObject.getString("sendsubtitle");
          localVIPDonateMsg.subTitle = ((String)localObject);
          if (!localJSONObject.has("sendurl")) {
            break label338;
          }
          localObject = localJSONObject.getString("sendurl");
          localVIPDonateMsg.jumpUrl = ((String)localObject);
          if (!localJSONObject.has("sendbrief")) {
            break label343;
          }
          localObject = localJSONObject.getString("sendbrief");
          localVIPDonateMsg.brief = ((String)localObject);
          localMessageForVIPDonate.donateMsg = localVIPDonateMsg;
          localMessageForVIPDonate.msg = localMessageForVIPDonate.getSummaryMsg();
          localMessageForVIPDonate.msgData = aczw.b(localVIPDonateMsg);
          localObject = localMessageForVIPDonate;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("vipdonateMsgparse", 2, "donateMsg = " + localMessageForVIPDonate.donateMsg);
          return localMessageForVIPDonate;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QLog.e("DecodeMsg", 1, "vipdonate json error :json = " + paramString);
        return null;
      }
      str = null;
      continue;
      label328:
      str = null;
      continue;
      label333:
      str = null;
      continue;
      label338:
      str = null;
      continue;
      label343:
      str = null;
    }
    label348:
    if (localJSONObject.has("recvsubtitle"))
    {
      str = localJSONObject.getString("recvsubtitle");
      label368:
      localVIPDonateMsg.subTitle = str;
      if (!localJSONObject.has("recvurl")) {
        break label434;
      }
      str = localJSONObject.getString("recvurl");
      localVIPDonateMsg.jumpUrl = str;
      if (!localJSONObject.has("recvbrief")) {
        break label439;
      }
    }
    label394:
    label434:
    label439:
    for (String str = localJSONObject.getString("recvbrief");; str = null)
    {
      localVIPDonateMsg.brief = str;
      break;
      str = null;
      break label368;
      str = null;
      break label394;
    }
    label444:
    return null;
  }
  
  public static QQWalletRedPacketMsg a(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null) {
      try
      {
        im_msg_body.QQWalletAioBody localQQWalletAioBody = new im_msg_body.QQWalletAioBody();
        localQQWalletAioBody.sint32_channelid.set(paramJSONObject.getInt("channelid"));
        localQQWalletAioBody.sint32_templateid.set(paramJSONObject.getInt("templateid"));
        localQQWalletAioBody.uint32_resend.set(paramJSONObject.getInt("resend"));
        localQQWalletAioBody.sint32_redtype.set(paramJSONObject.getInt("redtype"));
        localQQWalletAioBody.sint32_envelopeid.set(-1);
        paramString = new QQWalletRedPacketMsg(localQQWalletAioBody, paramString);
        paramString.redPacketId = paramJSONObject.getString("billno");
        paramString.authkey = paramJSONObject.getString("authkey");
        if (paramString.redPacketId.equals("")) {
          return null;
        }
        paramString.elem = a(paramJSONObject);
        paramJSONObject = paramString.elem;
        if (paramJSONObject != null) {
          return paramString;
        }
      }
      catch (Exception paramJSONObject) {}
    }
    return null;
  }
  
  public static QQWalletTransferMsgElem a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      try
      {
        QQWalletTransferMsgElem localQQWalletTransferMsgElem = new QQWalletTransferMsgElem();
        paramJSONObject = paramJSONObject.getJSONObject("receiver");
        if (paramJSONObject == null) {
          return null;
        }
        localQQWalletTransferMsgElem.nativeAndroid = paramJSONObject.getString("nativeAndroid");
        if (!localQQWalletTransferMsgElem.nativeAndroid.equals(""))
        {
          localQQWalletTransferMsgElem.background = paramJSONObject.getInt("background");
          localQQWalletTransferMsgElem.icon = paramJSONObject.getInt("icon");
          localQQWalletTransferMsgElem.title = paramJSONObject.getString("title");
          localQQWalletTransferMsgElem.subTitle = paramJSONObject.getString("subtitle");
          localQQWalletTransferMsgElem.content = paramJSONObject.getString("content");
          localQQWalletTransferMsgElem.linkUrl = paramJSONObject.getString("linkurl");
          localQQWalletTransferMsgElem.blackStripe = paramJSONObject.getString("blackstripe");
          localQQWalletTransferMsgElem.notice = paramJSONObject.getString("notice");
          localQQWalletTransferMsgElem.titleColor = paramJSONObject.getInt("titleColor");
          localQQWalletTransferMsgElem.subtitleColor = paramJSONObject.getInt("subtitleColor");
          localQQWalletTransferMsgElem.actionsPriority = paramJSONObject.getString("actionsPriority");
          localQQWalletTransferMsgElem.jumpUrl = paramJSONObject.getString("jumpUrl");
          localQQWalletTransferMsgElem.iconUrl = paramJSONObject.getString("iconurl");
          localQQWalletTransferMsgElem.contentColor = -1;
          localQQWalletTransferMsgElem.contentBgColor = -1;
          localQQWalletTransferMsgElem.aioImageLeft = "";
          localQQWalletTransferMsgElem.aioImageRight = "";
          localQQWalletTransferMsgElem.cftImage = "";
          return localQQWalletTransferMsgElem;
        }
      }
      catch (Exception paramJSONObject) {}
    }
    return null;
  }
  
  private Boolean a(List<im_msg_body.Elem> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        im_msg_body.Elem localElem = (im_msg_body.Elem)paramList.next();
        if ((localElem.market_trans.has()) || (localElem.rich_msg.has())) {
          return Boolean.valueOf(true);
        }
      }
    }
    return Boolean.valueOf(false);
  }
  
  protected static Boolean a(im_msg_body.Elem paramElem)
  {
    boolean bool = true;
    if ((paramElem.text.has()) || (paramElem.face.has()) || (paramElem.small_emoji.has()) || (paramElem.online_image.has()) || (paramElem.bankcode_ctrl_info.has())) {
      return Boolean.valueOf(true);
    }
    if (paramElem.common_elem.has())
    {
      if (33 == paramElem.common_elem.uint32_service_type.get()) {}
      for (;;)
      {
        return Boolean.valueOf(bool);
        bool = false;
      }
    }
    return Boolean.valueOf(false);
  }
  
  private String a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, boolean paramBoolean)
  {
    String str = null;
    Object localObject = paramList.iterator();
    paramList = null;
    if (((Iterator)localObject).hasNext())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)((Iterator)localObject).next();
      if (!localElem.text.has()) {
        break label160;
      }
      paramList = (im_msg_body.Text)localElem.text.get();
    }
    label160:
    for (;;)
    {
      break;
      localObject = str;
      if (paramList != null)
      {
        localObject = str;
        if (paramList.str.has())
        {
          paramList = paramList.str.get().toStringUtf8();
          localObject = paramList;
          if (paramBoolean)
          {
            str = anbk.w(paramList, false);
            localObject = paramList;
            if (str.length() > 0)
            {
              localObject = (MessageForText)anbi.d(-1000);
              ((MessageForText)localObject).msgtype = -1000;
              ((MessageForText)localObject).msg = str;
              paramList1.add(localObject);
              localObject = paramList;
            }
          }
        }
      }
      return localObject;
    }
  }
  
  @NotNull
  private RichMsg.VideoFile a(im_msg_body.VideoFile paramVideoFile, im_msg_body.GeneralFlags paramGeneralFlags)
  {
    RichMsg.VideoFile localVideoFile = new RichMsg.VideoFile();
    localVideoFile.setHasFlag(true);
    localVideoFile.bytes_file_name.set(paramVideoFile.bytes_file_name.get());
    localVideoFile.bytes_file_md5.set(paramVideoFile.bytes_file_md5.get());
    localVideoFile.bytes_file_uuid.set(paramVideoFile.bytes_file_uuid.get());
    localVideoFile.uint32_file_format.set(paramVideoFile.uint32_file_format.get());
    localVideoFile.uint32_file_size.set(paramVideoFile.uint32_file_size.get());
    localVideoFile.uint32_file_time.set(paramVideoFile.uint32_file_time.get());
    localVideoFile.uint32_thumb_width.set(paramVideoFile.uint32_thumb_width.get());
    localVideoFile.uint32_thumb_height.set(paramVideoFile.uint32_thumb_height.get());
    localVideoFile.uint32_file_status.set(2008);
    localVideoFile.uint32_file_progress.set(0);
    localVideoFile.bytes_thumb_file_md5.set(paramVideoFile.bytes_thumb_file_md5.get());
    localVideoFile.bytes_source.set(paramVideoFile.bytes_source.get());
    localVideoFile.uint32_thumb_file_size.set(paramVideoFile.uint32_thumb_file_size.get());
    localVideoFile.uint32_busi_type.set(paramVideoFile.uint32_busi_type.get());
    localVideoFile.uin32_from_chat_type.set(paramVideoFile.uint32_from_chat_type.get());
    localVideoFile.uin32_to_chat_type.set(paramVideoFile.uint32_to_chat_type.get());
    localVideoFile.bool_support_progressive.set(paramVideoFile.bool_support_progressive.get());
    localVideoFile.uint32_file_width.set(paramVideoFile.uint32_file_width.get());
    localVideoFile.uint32_file_height.set(paramVideoFile.uint32_file_height.get());
    localVideoFile.uint32_sub_busi_type.set(paramVideoFile.uint32_sub_busi_type.get());
    localVideoFile.uint32_video_attr.set(paramVideoFile.uint32_video_attr.get());
    videoFile.ResvAttr localResvAttr;
    if (paramVideoFile.bytes_pb_reserve.has()) {
      localResvAttr = new videoFile.ResvAttr();
    }
    try
    {
      localResvAttr.mergeFrom(paramVideoFile.bytes_pb_reserve.get().toByteArray());
      localVideoFile.bytes_hotvideo_icon.set(localResvAttr.bytes_hotvideo_icon.get());
      localVideoFile.bytes_hotvideo_icon_sub.set(localResvAttr.bytes_hotvideo_icon_sub.get());
      localVideoFile.bytes_hotvideo_title.set(localResvAttr.bytes_hotvideo_title.get());
      localVideoFile.bytes_hotvideo_url.set(localResvAttr.bytes_hotvideo_url.get());
      localVideoFile.uint32_special_video_type.set(localResvAttr.uint32_special_video_type.get());
      localVideoFile.uint32_msg_tail_type.set(localResvAttr.uint32_msg_tail_type.get());
      localVideoFile.uint32_long_video_kandian_type.set(localResvAttr.uint32_long_video_kandian_type.get());
      if (localResvAttr.bytes_camera_templateid.has()) {
        localVideoFile.bytes_camera_video_templateid.set(localResvAttr.bytes_camera_templateid.get());
      }
      if (localResvAttr.bytes_camera_templateName.has()) {
        localVideoFile.bytes_camera_video_templatename.set(localResvAttr.bytes_camera_templateName.get());
      }
    }
    catch (InvalidProtocolBufferMicroException paramVideoFile)
    {
      try
      {
        do
        {
          paramVideoFile.mergeFrom(paramGeneralFlags.bytes_pb_reserve.get().toByteArray());
          localVideoFile.uint32_red_envelope_type.set(paramVideoFile.uint32_red_envelope_type.get());
          localVideoFile.bytes_shortVideoId.set(paramVideoFile.bytes_shortVideoId.get());
          return localVideoFile;
          paramVideoFile = paramVideoFile;
        } while (!QLog.isColorLevel());
        QLog.d("DecodeMsg", 2, "ShortVideo doParse error!", paramVideoFile);
      }
      catch (Exception paramVideoFile)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("DecodeMsg", 2, "ShortVideo doParse generalFlag error!", paramVideoFile);
      }
    }
    if ((paramGeneralFlags != null) && (paramGeneralFlags.bytes_pb_reserve.has())) {
      paramVideoFile = new generalflags.ResvAttr();
    }
    return localVideoFile;
  }
  
  private void a(im_msg_body.Elem paramElem, List<MessageRecord> paramList, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, anbm paramanbm)
  {
    Object localObject = (im_msg_body.CrmElem)paramElem.crm_elem.get();
    if (localObject != null)
    {
      i = ((im_msg_body.CrmElem)localObject).uint32_qidian_flag.get();
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("has uint32_qidian_flag:").append(i).append(";");
      }
      if (i == 1)
      {
        if (!paramList.isEmpty()) {
          ((MessageRecord)paramList.get(0)).saveExtInfoToExtStr("crmelem_qidian_flag", i + "");
        }
        paramStringBuilder = this.c.app.getCurrentAccountUin();
        paramElem = String.valueOf(paramMsg.msg_head.from_uin.get());
        if (!paramStringBuilder.equals(paramElem))
        {
          paramStringBuilder = (asgx)this.c.app.getManager(165);
          if (!paramStringBuilder.oU.containsKey(paramElem)) {
            paramStringBuilder.a(new BmqqAccountType(paramElem, 1));
          }
        }
        if ((paramanbm != null) && (paramanbm.friendType == 1024)) {
          paramanbm.friendType = 1025;
        }
      }
      if (((im_msg_body.CrmElem)localObject).crm_buf.has()) {
        paramElem = new Crm.CrmCCNotify();
      }
    }
    while (!QLog.isColorLevel()) {
      try
      {
        paramElem.mergeFrom(((im_msg_body.CrmElem)localObject).crm_buf.get().toByteArray());
        int i = paramElem.crm_flag.get();
        int j;
        long l1;
        long l2;
        if ((i == 8) && (paramElem.qidian_group_msg.has()))
        {
          paramStringBuilder = (Crm.QidianGroupMsg)paramElem.qidian_group_msg.get();
          j = paramStringBuilder.uint32_group_task_id.get();
          int k = paramStringBuilder.uint32_group_msg_type.get();
          l1 = paramStringBuilder.uint64_kfuin.get();
          int m = paramStringBuilder.uint32_show_tip.get();
          paramStringBuilder = paramStringBuilder.str_tip_text.get();
          if (!paramList.isEmpty())
          {
            localObject = (MessageRecord)paramList.get(0);
            if (localObject != null)
            {
              ((MessageRecord)localObject).mQidianTaskId = j;
              ((MessageRecord)localObject).mQidianMasterUin = l1;
              ((MessageRecord)localObject).mIsShowQidianTips = m;
              ((MessageRecord)localObject).mQidianTipText = paramStringBuilder;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("DecodeMsg", 2, String.format("received qidian bulk message taskId: %d, msgType: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) }));
          }
          l1 = paramMsg.msg_head.from_uin.get();
          k = paramMsg.msg_head.msg_seq.get();
          l2 = paramMsg.msg_head.msg_uid.get();
          m = paramMsg.msg_head.msg_type.get();
          anbh.a(this.c, l1, k, l2, m);
          if (j != 0)
          {
            paramStringBuilder = (ashy)this.app.getBusinessHandler(85);
            localObject = new JSONObject();
            ((JSONObject)localObject).put("action", "receive");
            ((JSONObject)localObject).put("fromUin", String.valueOf(paramMsg.msg_head.from_uin.get()));
            ((JSONObject)localObject).put("toUin", this.app.getCurrentAccountUin());
            ((JSONObject)localObject).put("taskID", String.valueOf(j));
            ((JSONObject)localObject).put("clickURL", "");
            ((JSONObject)localObject).put("timestamp", String.valueOf(System.currentTimeMillis() / 1000L));
            paramStringBuilder.g(((JSONObject)localObject).toString(), String.valueOf(paramMsg.msg_head.from_uin.get()), "", 10009, 0);
          }
        }
        if ((i == 11) && (paramElem.msg_gray_msg.has()))
        {
          localObject = (Crm.GrayMsg)paramElem.msg_gray_msg.get();
          i = ((Crm.GrayMsg)localObject).uint32_type.get();
          paramStringBuilder = ((Crm.GrayMsg)localObject).str_text.get();
          l1 = ((Crm.GrayMsg)localObject).uint64_from_uin.get();
          j = paramMsg.msg_head.msg_seq.get();
          l2 = paramMsg.msg_head.msg_uid.get();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(j);
          ((StringBuilder)localObject).append(l2);
          if (QLog.isColorLevel()) {
            QLog.d("DecodeMsg", 2, String.format("received qidian gray msg type: %d, tips: %s, fromUin: %d", new Object[] { Integer.valueOf(i), paramStringBuilder, Long.valueOf(l1) }));
          }
          asih.a(this.app, String.valueOf(l1), paramStringBuilder, 1024, ((StringBuilder)localObject).toString());
        }
        if (paramElem.str_check_id.has()) {
          asih.a(this.app, paramList, paramMsg, paramanbm, paramElem);
        }
        if ((paramanbm != null) && (paramanbm.friendType == 1024) && (paramElem.str_ext_nick_name.has()))
        {
          paramElem = paramElem.str_ext_nick_name.get();
          if (!paramList.isEmpty())
          {
            paramList = (MessageRecord)paramList.get(0);
            if (paramList != null) {
              paramList.saveExtInfoToExtStr("qidian_ext_nick_name", paramElem);
            }
          }
        }
        return;
      }
      catch (Exception paramElem)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("DecodeMsg", 2, "receive ccNotify but throw exception " + paramElem.getMessage());
        return;
      }
    }
    paramStringBuilder.append("has crmElem, but crmElem is null");
  }
  
  private void a(im_msg_body.Elem paramElem, im_msg_body.NotOnlineImage paramNotOnlineImage, List<MessageRecord> paramList, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg)
  {
    BaseApplication.getContext().getString(2131696611);
    boolean bool;
    if (paramNotOnlineImage != null) {
      bool = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("flash", 2, "parsePBMsgElems_OfflineMsg hasComFlashPic=" + bool);
      }
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("elemType:NotOnlineImage;\n hasComFlashPic=" + bool);
      }
      int i = 0;
      if (paramNotOnlineImage == null)
      {
        QLog.d("flash", 2, "offlineImg null");
        return;
        if (paramElem != null)
        {
          paramNotOnlineImage = (im_msg_body.NotOnlineImage)paramElem.not_online_image.get();
          bool = false;
        }
      }
      else
      {
        int j;
        if (paramNotOnlineImage != null)
        {
          j = paramNotOnlineImage.file_len.get();
          i = paramNotOnlineImage.img_type.get();
        }
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("DecodeMsg", 2, "[NotOnlineImage] file_len=" + j);
            QLog.d("DecodeMsg", 2, "[NotOnlineImage] imgType=" + i);
          }
          paramNotOnlineImage.flag.get().toByteArray();
          String str1 = paramNotOnlineImage.str_thumb_url.get();
          String str2 = paramNotOnlineImage.str_400_url.get();
          int i1 = paramNotOnlineImage.uint32_thumb_width.get();
          int i2 = paramNotOnlineImage.uint32_thumb_height.get();
          if (QLog.isColorLevel()) {
            QLog.d("DecodeMsg", 2, "[NotOnlineImage] ThumbWidth=" + i1 + ",ThumbHeight=" + i2);
          }
          if (paramNotOnlineImage.uint32_file_id.has()) {}
          for (int k = paramNotOnlineImage.uint32_file_id.get();; k = 0)
          {
            String str3 = paramNotOnlineImage.str_big_url.get();
            String str4 = paramNotOnlineImage.str_orig_url.get();
            int i3 = paramNotOnlineImage.pic_width.get();
            int i4 = paramNotOnlineImage.pic_height.get();
            int m = paramNotOnlineImage.uint32_show_len.get();
            int n = paramNotOnlineImage.uint32_download_len.get();
            if (QLog.isDevelopLevel()) {
              QLog.d("peak_pgjpeg", 4, "MessageProtoCodec.decodePBMsgElems(): showLen " + m + ", downloadLen " + n + ", fileLen " + j);
            }
            int i5 = paramNotOnlineImage.original.get();
            if (paramNotOnlineImage.res_id.has()) {
              paramElem = paramNotOnlineImage.res_id.get().toStringUtf8();
            }
            for (;;)
            {
              Object localObject1;
              if ((paramElem != null) && (!paramElem.equals("")))
              {
                localObject1 = "";
                paramMsg = (msg_comm.Msg)localObject1;
                if (paramNotOnlineImage.pic_md5.has())
                {
                  localObject2 = paramNotOnlineImage.pic_md5.get().toByteArray();
                  paramMsg = (msg_comm.Msg)localObject1;
                  if (localObject2 != null)
                  {
                    paramMsg = (msg_comm.Msg)localObject1;
                    if (localObject2.length > 0) {
                      paramMsg = aqhs.bytes2HexStr((byte[])localObject2);
                    }
                  }
                }
                Object localObject2 = aoon.b(paramElem, j, 1, false, paramElem, paramMsg, "picplatform", str1, str2, str3, str4, i5, 0);
                localObject1 = new RichMsg.PicRec();
                ((RichMsg.PicRec)localObject1).localPath.set(paramElem);
                ((RichMsg.PicRec)localObject1).size.set(j);
                ((RichMsg.PicRec)localObject1).type.set(1);
                ((RichMsg.PicRec)localObject1).isRead.set(false);
                ((RichMsg.PicRec)localObject1).uuid.set(paramElem);
                ((RichMsg.PicRec)localObject1).md5.set(paramMsg);
                ((RichMsg.PicRec)localObject1).serverStorageSource.set("picplatform");
                ((RichMsg.PicRec)localObject1).thumbMsgUrl.set(str1);
                ((RichMsg.PicRec)localObject1).bigthumbMsgUrl.set(str2);
                ((RichMsg.PicRec)localObject1).uint32_thumb_width.set(i1);
                ((RichMsg.PicRec)localObject1).uint32_thumb_height.set(i2);
                ((RichMsg.PicRec)localObject1).uint32_width.set(i3);
                ((RichMsg.PicRec)localObject1).uint32_height.set(i4);
                if (paramNotOnlineImage.uint32_file_id.has()) {
                  ((RichMsg.PicRec)localObject1).groupFileID.set(k);
                }
                ((RichMsg.PicRec)localObject1).bigMsgUrl.set(str3);
                ((RichMsg.PicRec)localObject1).rawMsgUrl.set(str4);
                ((RichMsg.PicRec)localObject1).fileSizeFlag.set(i5);
                ((RichMsg.PicRec)localObject1).uiOperatorFlag.set(0);
                ((RichMsg.PicRec)localObject1).version.set(5);
                ((RichMsg.PicRec)localObject1).isReport.set(0);
                if (QLog.isColorLevel()) {
                  paramStringBuilder.append("content:").append((String)localObject2).append("\n");
                }
                if (i5 != 1) {
                  break label1195;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("DecodeMsg", 2, "[NotOnlineImage] showLen =" + m + ",downloadLen = " + n + ",raw photo msg,clear progressjpg info!");
                }
                k = 0;
                j = 0;
              }
              for (;;)
              {
                ((RichMsg.PicRec)localObject1).uint32_show_len.set(k);
                ((RichMsg.PicRec)localObject1).uint32_download_len.set(j);
                ((RichMsg.PicRec)localObject1).uint32_image_type.set(i);
                if (paramNotOnlineImage.bytes_pb_reserve.has()) {
                  ((RichMsg.PicRec)localObject1).bytes_pb_reserved.set(paramNotOnlineImage.bytes_pb_reserve.get());
                }
                paramElem = (MessageForPic)anbi.d(-2000);
                if (bool) {
                  acei.d(paramElem, false);
                }
                paramElem.msgtype = -2000;
                paramElem.msgData = ((RichMsg.PicRec)localObject1).toByteArray();
                paramElem.parse();
                paramList.add(paramElem);
                return;
                if (!paramNotOnlineImage.download_path.has()) {
                  break label1206;
                }
                paramElem = paramNotOnlineImage.download_path.get().toStringUtf8();
                break;
                if (QLog.isColorLevel()) {
                  paramStringBuilder.append("serverPath is null or empty string : " + paramElem);
                }
                paramElem = (msg_comm.MsgHead)paramMsg.msg_head.get();
                long l1 = paramElem.msg_seq.get();
                long l2 = paramElem.msg_uid.get();
                long l3 = paramElem.msg_time.get();
                long l4 = paramElem.from_uin.get();
                long l5 = paramElem.to_uin.get();
                paramElem = new HashMap();
                paramElem.put("param_FailCode", String.valueOf(10002));
                paramElem.put("fromUin", String.valueOf(l4));
                paramElem.put("toUin", String.valueOf(l5));
                paramElem.put("msgSeq", String.valueOf(l1));
                paramElem.put("msgUid", String.valueOf(l2));
                paramElem.put("msgtime", String.valueOf(l3));
                paramNotOnlineImage = this.c.app.getCurrentAccountUin();
                anpc.a(BaseApplication.getContext()).collectPerformance(paramNotOnlineImage, "actMessageEvent", false, 0L, 0L, paramElem, "");
                return;
                label1195:
                j = n;
                k = m;
              }
              label1206:
              paramElem = null;
            }
          }
          j = 0;
        }
      }
      paramNotOnlineImage = null;
      bool = false;
    }
  }
  
  private void a(im_msg_body.GeneralFlags paramGeneralFlags, boolean paramBoolean, String paramString, List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, aozx paramaozx)
  {
    Object localObject = a(paramList, paramList1, false);
    MessageForArkApp localMessageForArkApp = (MessageForArkApp)anbi.d(-5008);
    localMessageForArkApp.msgtype = -5008;
    if (localObject != null) {
      localMessageForArkApp.compatibleMsg = ((String)localObject);
    }
    if ((paramGeneralFlags != null) && (paramGeneralFlags.bytes_pb_reserve.has())) {}
    try
    {
      localObject = new generalflags.ResvAttr();
      ((generalflags.ResvAttr)localObject).mergeFrom(paramGeneralFlags.bytes_pb_reserve.get().toByteArray());
      if (((generalflags.ResvAttr)localObject).bytes_oac_msg_extend.has()) {
        localMessageForArkApp.saveExtInfoToExtStr("report_key_bytes_oac_msg_extend", ((generalflags.ResvAttr)localObject).bytes_oac_msg_extend.get().toStringUtf8());
      }
      if (((generalflags.ResvAttr)localObject).uint32_service_msg_type.has())
      {
        paramGeneralFlags = new JSONObject(paramString).optString("appid");
        if (!TextUtils.isEmpty(paramGeneralFlags)) {
          localMessageForArkApp.saveExtInfoToExtStr("appid", paramGeneralFlags);
        }
      }
    }
    catch (Throwable paramGeneralFlags)
    {
      for (;;)
      {
        QLog.e("DecodeMsg", 2, "decodePBMsgElems_ArkApp() parse generalflags error! " + QLog.getStackTraceString(paramGeneralFlags));
        continue;
        QLog.i("DecodeMsg", 1, "decode msg, ark message is not valid..");
      }
    }
    paramGeneralFlags = new ArkAppMessage();
    paramGeneralFlags.fromAppXml(paramString);
    localMessageForArkApp.msgData = paramGeneralFlags.toBytes();
    localMessageForArkApp.parse();
    if ((!TextUtils.isEmpty(localMessageForArkApp.ark_app_message.appName)) && (!TextUtils.isEmpty(localMessageForArkApp.ark_app_message.appView)))
    {
      paramList1.add(localMessageForArkApp);
      paramBoolean = true;
      if (!paramBoolean) {
        g(paramList, paramList1, paramStringBuilder, paramMsg, paramaozx);
      }
      return;
    }
  }
  
  private static PAMessage b(String paramString)
  {
    paramString = obj.a(paramString);
    if (paramString != null) {
      return paramString;
    }
    return null;
  }
  
  private static String nk(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < paramString.length())
    {
      if ((paramString.charAt(i) == '\024') && (i + 2 < paramString.length()))
      {
        int j = (paramString.charAt(i + 1) - 'A') * 128 + paramString.charAt(i + 2) - 65;
        if (QLog.isColorLevel()) {
          QLog.d("DecodeMsg", 2, "faceIndex:" + j);
        }
        j = afky.hm(j);
        if (j >= 0)
        {
          localStringBuilder.append(paramString.charAt(i));
          localStringBuilder.append((char)j);
        }
        i = i + 1 + 1;
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(paramString.charAt(i));
      }
    }
    return localStringBuilder.toString();
  }
  
  public String O(List<im_msg_body.Elem> paramList)
  {
    StringBuilder localStringBuilder1 = new StringBuilder("");
    StringBuilder localStringBuilder2 = new StringBuilder("<---decodePbElems:");
    int i = 0;
    int k = paramList.size();
    int j = 0;
    if (j < k)
    {
      Object localObject = (im_msg_body.Elem)paramList.get(j);
      if (((im_msg_body.Elem)localObject).text.has()) {
        if (i != 0) {
          i = 0;
        }
      }
      for (;;)
      {
        j += 1;
        break;
        if (QLog.isColorLevel()) {
          localStringBuilder2.append("elemType:Text;\n");
        }
        localStringBuilder1.length();
        localObject = (im_msg_body.Text)((im_msg_body.Elem)localObject).text.get();
        if (((im_msg_body.Text)localObject).str.has()) {
          localStringBuilder1.append(anbk.w(((im_msg_body.Text)localObject).str.get().toStringUtf8(), false));
        }
        continue;
        int m;
        if (((im_msg_body.Elem)localObject).face.has())
        {
          if (QLog.isColorLevel()) {
            localStringBuilder2.append("elemType:Face;\n");
          }
          if (((im_msg_body.Face)((im_msg_body.Elem)localObject).face.get()).index.has())
          {
            m = afky.hm(((im_msg_body.Face)((im_msg_body.Elem)localObject).face.get()).index.get());
            if (m >= 0)
            {
              localStringBuilder1.append('\024');
              localStringBuilder1.append((char)m);
            }
          }
        }
        else if (((im_msg_body.Elem)localObject).small_emoji.has())
        {
          if (QLog.isColorLevel()) {
            localStringBuilder2.append("elemType:small_emoji;\n");
          }
          if (((im_msg_body.SmallEmoji)((im_msg_body.Elem)localObject).small_emoji.get()).packIdSum.has())
          {
            i = (((im_msg_body.SmallEmoji)((im_msg_body.Elem)localObject).small_emoji.get()).packIdSum.get() & 0xFFFF0000) >> 16;
            m = 0xFFFF & ((im_msg_body.SmallEmoji)((im_msg_body.Elem)localObject).small_emoji.get()).packIdSum.get();
            char[] arrayOfChar = afgc.a(i, m);
            if ((((im_msg_body.SmallEmoji)((im_msg_body.Elem)localObject).small_emoji.get()).imageType.has()) && ((((im_msg_body.SmallEmoji)((im_msg_body.Elem)localObject).small_emoji.get()).imageType.get() & 0xFFFF) == 2))
            {
              arrayOfChar[3] = 'ǿ';
              if (QLog.isColorLevel()) {
                QLog.d("DecodeMsg", 2, "get apng epid = " + i + " eid = " + m);
              }
            }
            localStringBuilder1.append('\024');
            localStringBuilder1.append(arrayOfChar[3]);
            localStringBuilder1.append(arrayOfChar[2]);
            localStringBuilder1.append(arrayOfChar[1]);
            localStringBuilder1.append(arrayOfChar[0]);
            i = 1;
          }
        }
        else if ((((im_msg_body.Elem)localObject).common_elem.has()) && (33 == ((im_msg_body.Elem)localObject).common_elem.uint32_service_type.get()))
        {
          if (QLog.isColorLevel()) {
            localStringBuilder2.append("elemType:NewSysFaceMsg;\n");
          }
          localStringBuilder1.append(a((im_msg_body.CommonElem)((im_msg_body.Elem)localObject).common_elem.get()));
        }
      }
    }
    return localStringBuilder1.toString();
  }
  
  public void P(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)paramList.next();
      if ((localElem.general_flags.has()) && (localElem.general_flags.bytes_pb_reserve.has()))
      {
        generalflags.ResvAttr localResvAttr = new generalflags.ResvAttr();
        try
        {
          localResvAttr.mergeFrom(localElem.general_flags.bytes_pb_reserve.get().toByteArray());
          if (localResvAttr.uint32_tail_key.has())
          {
            int i = localResvAttr.uint32_tail_key.get();
            if (2 == i) {
              ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("app_qim_tail_id", String.valueOf(i));
            }
          }
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
        }
      }
    }
  }
  
  public anbg.a a(List<im_msg_body.Elem> paramList, StringBuilder paramStringBuilder, long paramLong, aozx paramaozx)
  {
    anbg.a locala = new anbg.a();
    locala.b = a(paramList, paramStringBuilder);
    anbg.b localb = new anbg.b();
    Object localObject = localb.An;
    StringBuilder localStringBuilder = a(null, paramList, paramStringBuilder, paramLong, paramaozx, localb, null);
    if ((localObject != null) && (((ArrayList)localObject).size() == 2)) {
      if (((ArrayList)localObject).get(0) != null)
      {
        paramList = (MessageForText.AtTroopMemberInfo)((ArrayList)localObject).get(0);
        paramStringBuilder = paramList;
        if (((ArrayList)localObject).get(1) != null) {
          locala.fv = ((byte[])((ArrayList)localObject).get(1));
        }
      }
    }
    for (paramStringBuilder = paramList;; paramStringBuilder = null)
    {
      int i;
      if ((localStringBuilder.length() > 0) && (locala.b != null))
      {
        locala.cdm = localStringBuilder.toString();
        if ((TextUtils.isEmpty(locala.b.mAnonymousNickName)) && (paramStringBuilder != null) && (!TextUtils.isEmpty(locala.cdm)) && (locala.cdm.length() >= paramStringBuilder.textLen + paramStringBuilder.startPos))
        {
          locala.a = paramStringBuilder;
          localObject = locala.cdm;
          locala.cdm = "";
          if (paramStringBuilder.startPos > 0) {
            locala.cdm = ((String)localObject).substring(0, paramStringBuilder.startPos);
          }
          paramList = "";
          i = paramStringBuilder.startPos + paramStringBuilder.textLen;
          if (i + 1 < ((String)localObject).length()) {
            paramList = ((String)localObject).substring(i, i + 1);
          }
          if (!paramList.equals(" ")) {
            break label381;
          }
        }
      }
      label381:
      for (locala.cdm += ((String)localObject).substring(i + 1);; locala.cdm += ((String)localObject).substring(i))
      {
        locala.cdn = ((String)localObject).substring(paramStringBuilder.startPos, paramStringBuilder.startPos + paramStringBuilder.textLen);
        if ((paramStringBuilder.isIncludingMe(this.c.app.getLongAccountUin())) && (localb.b == null)) {
          paramaozx.b.as(24, -1L);
        }
        return locala;
      }
      paramList = null;
      break;
    }
  }
  
  public MarkFaceMessage a(im_msg_body.Elem paramElem, List<MessageRecord> paramList, StringBuilder paramStringBuilder, long paramLong)
  {
    if (QLog.isColorLevel()) {
      paramStringBuilder.append("elemType:MarketFace;\n");
    }
    im_msg_body.MarketFace localMarketFace = (im_msg_body.MarketFace)paramElem.market_face.get();
    if (localMarketFace != null)
    {
      paramElem = new MarkFaceMessage();
      paramElem.cFaceInfo = localMarketFace.uint32_face_info.get();
      paramElem.index = 0L;
      paramElem.cSubType = localMarketFace.uint32_sub_type.get();
      paramElem.dwMSGItemType = localMarketFace.uint32_item_type.get();
      paramElem.dwTabID = localMarketFace.uint32_tab_id.get();
      paramElem.sbfKey = localMarketFace.bytes_key.get().toByteArray();
      paramElem.sbufID = localMarketFace.bytes_face_id.get().toByteArray();
      paramElem.mediaType = localMarketFace.uint32_media_type.get();
      paramElem.imageWidth = 200;
      paramElem.imageHeight = 200;
      paramElem.mobileparam = localMarketFace.bytes_mobileparam.get().toByteArray();
      MarketFaceExtPb.ResvAttr localResvAttr;
      if (localMarketFace.bytes_pb_reserve.has())
      {
        paramElem.resvAttr = localMarketFace.bytes_pb_reserve.get().toByteArray();
        localResvAttr = new MarketFaceExtPb.ResvAttr();
      }
      try
      {
        localResvAttr.mergeFrom(paramElem.resvAttr);
        paramElem.copywritingType = localResvAttr.uint32_source_type.get();
        paramElem.copywritingContent = localResvAttr.str_source_name.get();
        paramElem.jumpUrl = localResvAttr.str_source_jump_url.get();
        paramElem.beginTime = localResvAttr.uint32_start_time.get();
        paramElem.endTime = localResvAttr.uint32_end_time.get();
        paramElem.from = localResvAttr.str_source_type_name.get();
        if (localResvAttr.uint32_emoji_type.get() != 2) {
          break label599;
        }
        bool = true;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        try
        {
          for (;;)
          {
            paramStringBuilder.msgData = aczw.b(paramElem);
            paramList.add(paramStringBuilder);
            return paramElem;
            boolean bool = false;
            continue;
            bool = false;
            continue;
            localInvalidProtocolBufferMicroException = localInvalidProtocolBufferMicroException;
            QLog.e("DecodeMsg", 1, "mergeFrom resvAttr error e = " + localInvalidProtocolBufferMicroException);
          }
          paramElem.faceName = paramStringBuilder;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
      paramElem.isAPNG = bool;
      if (localResvAttr.uint32_has_ip_product.get() == 1)
      {
        bool = true;
        paramElem.hasIpProduct = bool;
        if (localResvAttr.uint32_voice_item_height_arr.has()) {
          paramElem.voicePrintItems = localResvAttr.uint32_voice_item_height_arr.get();
        }
        if (localResvAttr.str_back_color.has()) {
          paramElem.backColor = localResvAttr.str_back_color.get();
        }
        if (localResvAttr.str_volume_color.has()) {
          paramElem.volumeColor = localResvAttr.str_volume_color.get();
        }
        if (QLog.isColorLevel()) {
          paramStringBuilder.append(" mediaType = ").append(paramElem.mediaType).append("\n");
        }
        if (localMarketFace.bytes_face_name.has())
        {
          paramStringBuilder = localMarketFace.bytes_face_name.get().toStringUtf8();
          if ((TextUtils.isEmpty(paramStringBuilder)) || (paramStringBuilder.length() <= 1) || (paramStringBuilder.charAt(0) != '[') || (paramStringBuilder.charAt(paramStringBuilder.length() - 1) != ']')) {
            break label643;
          }
          paramElem.faceName = paramStringBuilder.substring(1, paramStringBuilder.length() - 1);
        }
        paramStringBuilder = (MessageForMarketFace)anbi.d(-2007);
        paramStringBuilder.msgtype = -2007;
        paramStringBuilder.msg = "it is marketface";
        paramStringBuilder.mMarkFaceMessage = paramElem;
        if ((paramElem.mobileparam != null) && (paramElem.mobileparam.length > 0)) {
          anot.a(this.c.app, "CliOper", "", "", "MbJieshou", "MbXiaoxi", 0, 0, "", "", "", "");
        }
      }
    }
    label599:
    return null;
  }
  
  public MessageForDeliverGiftTips a(String paramString1, String paramString2, im_msg_body.DeliverGiftMsg paramDeliverGiftMsg, List<MessageRecord> paramList, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg)
  {
    if (QLog.isColorLevel()) {
      paramStringBuilder.append("elemType:GiftMsg;\n");
    }
    int i = paramDeliverGiftMsg.uint32_animation_package_id.get();
    int j = paramDeliverGiftMsg.uint32_stmessage_exflag.get();
    if ((i == 0) && ((j < 1000) || (j > 2000)))
    {
      paramStringBuilder = (MessageForDeliverGiftTips)anbi.d(-2035);
      paramStringBuilder.msgtype = -2035;
      paramStringBuilder.senderName = paramString1;
      paramStringBuilder.grayTipContent = paramDeliverGiftMsg.bytes_gray_tip_content.get().toStringUtf8();
      paramStringBuilder.animationPackageId = paramDeliverGiftMsg.uint32_animation_package_id.get();
      paramStringBuilder.animationPackageUrl = paramDeliverGiftMsg.bytes_animation_package_url_a.get().toStringUtf8();
      paramStringBuilder.remindBrief = paramDeliverGiftMsg.bytes_remind_brief.get().toStringUtf8();
      paramStringBuilder.giftId = paramDeliverGiftMsg.uint32_gift_id.get();
      paramStringBuilder.giftCount = paramDeliverGiftMsg.uint32_gift_count.get();
      paramStringBuilder.animationBrief = paramDeliverGiftMsg.bytes_animation_brief.get().toStringUtf8();
      paramStringBuilder.senderUin = paramDeliverGiftMsg.uint64_sender_uin.get();
      paramStringBuilder.receiverUin = paramDeliverGiftMsg.uint64_receiver_uin.get();
      if (paramDeliverGiftMsg.bytes_receiver_name.has()) {
        paramStringBuilder.receiverName = paramDeliverGiftMsg.bytes_receiver_name.get().toStringUtf8();
      }
      if (paramDeliverGiftMsg.bytes_receiver_pic.has()) {
        paramStringBuilder.receiverHead = paramDeliverGiftMsg.bytes_receiver_pic.get().toStringUtf8();
      }
      if (paramDeliverGiftMsg.bytes_pb_reserve.has()) {
        paramString1 = new ResvAttrForGiftMsg.ResvAttr();
      }
    }
    for (;;)
    {
      try
      {
        paramString1.mergeFrom(paramDeliverGiftMsg.bytes_pb_reserve.get().toByteArray());
        paramStringBuilder.sendScore = paramString1.int32_send_score.get();
        paramStringBuilder.recvScore = paramString1.int32_recv_score.get();
        if (paramString1.bytes_charm_heroism.has()) {
          paramStringBuilder.charmHeroism = paramString1.bytes_charm_heroism.get().toStringUtf8();
        }
        paramStringBuilder.btFlag = paramString1.uint32_button_flag.get();
        paramStringBuilder.objColor = paramString1.uint32_obj_color.get();
        if (!paramString1.activity_gift_info.has()) {
          continue;
        }
        ResvAttrForGiftMsg.ActivityGiftInfo localActivityGiftInfo = (ResvAttrForGiftMsg.ActivityGiftInfo)paramString1.activity_gift_info.get();
        paramStringBuilder.is_activity_gift = localActivityGiftInfo.is_activity_gift.get();
        paramStringBuilder.activity_text_color = localActivityGiftInfo.text_color.get();
        paramStringBuilder.activity_text = localActivityGiftInfo.text.get();
        paramStringBuilder.activity_url = localActivityGiftInfo.url.get();
        paramStringBuilder.animationType = paramString1.uint32_animation_type.get();
        if (paramString1.msg_interact_gift.has()) {
          paramStringBuilder.interactId = paramString1.msg_interact_gift.bytes_interact_id.get().toStringUtf8();
        }
      }
      catch (InvalidProtocolBufferMicroException paramString1)
      {
        paramString1.printStackTrace();
        continue;
        if ((paramStringBuilder.remindBrief == null) || (paramStringBuilder.remindBrief.split("#").length <= 1)) {
          continue;
        }
        paramStringBuilder.saveExtInfoToExtStr("troop_send_gift_ext_remind", paramStringBuilder.remindBrief.split("#")[1]);
        continue;
      }
      paramStringBuilder.rcvName = paramString2;
      if (paramDeliverGiftMsg.bytes_comefrom_link.has()) {
        paramStringBuilder.jumpUrl = paramDeliverGiftMsg.bytes_comefrom_link.get().toStringUtf8();
      }
      paramString1 = (apuf)this.c.app.getManager(81);
      if (paramString1 != null)
      {
        paramStringBuilder.grayTipsEntity = new TroopTipsEntity();
        paramStringBuilder.grayTipsEntity.isSupportImage = true;
        paramStringBuilder.grayTipsEntity.troopUin = String.valueOf(paramMsg.msg_head.group_info.group_code.get());
        paramStringBuilder.grayTipsEntity.optContent = paramStringBuilder.grayTipContent;
        paramString1.a(paramStringBuilder.grayTipsEntity);
        paramStringBuilder.msg = paramStringBuilder.grayTipsEntity.optContent;
        if ((paramStringBuilder instanceof MessageForTroopGift))
        {
          paramString1 = (MessageForTroopGift)paramStringBuilder;
          paramString1.bagId = paramDeliverGiftMsg.bytes_to_all_gift_id.get().toStringUtf8();
          paramString1.title = paramDeliverGiftMsg.bytes_stmessage_title.get().toStringUtf8();
          paramString1.subtitle = paramDeliverGiftMsg.bytes_stmessage_subtitle.get().toStringUtf8();
          paramString1.message = paramDeliverGiftMsg.bytes_stmessage_message.get().toStringUtf8();
          paramString1.giftPicId = paramDeliverGiftMsg.uint32_stmessage_giftpicid.get();
          paramString1.comefrom = paramDeliverGiftMsg.bytes_stmessage_comefrom.get().toStringUtf8();
          paramString1.exflag = paramDeliverGiftMsg.uint32_stmessage_exflag.get();
          if (paramDeliverGiftMsg.bytes_stmessage_gifturl.has()) {
            paramString1.giftUrl = paramDeliverGiftMsg.bytes_stmessage_gifturl.get().toStringUtf8();
          }
        }
        if (TextUtils.isEmpty(paramStringBuilder.summary)) {
          paramStringBuilder.summary = paramStringBuilder.msg;
        }
        if (paramStringBuilder.grayTipsEntity.highlightNum != 0) {
          apuf.a(paramStringBuilder, paramStringBuilder.grayTipsEntity.highlightItems);
        }
        if ((paramStringBuilder instanceof MessageForTroopGift)) {
          ((MessageForTroopGift)paramStringBuilder).prewrite();
        }
        if ((this.c.app.getCurrentAccountUin() == null) || (!this.c.app.getCurrentAccountUin().equals(paramStringBuilder.receiverUin + ""))) {
          continue;
        }
        if (paramStringBuilder.remindBrief != null) {
          paramStringBuilder.saveExtInfoToExtStr("troop_send_gift_ext_remind", paramStringBuilder.remindBrief.split("#")[0]);
        }
        paramList.add(paramStringBuilder);
      }
      if ((paramStringBuilder instanceof MessageForTroopGift))
      {
        paramString1 = (MessageForTroopGift)paramStringBuilder;
        paramString1.bagId = paramDeliverGiftMsg.bytes_to_all_gift_id.get().toStringUtf8();
        paramString1.title = paramDeliverGiftMsg.bytes_stmessage_title.get().toStringUtf8();
        paramString1.subtitle = paramDeliverGiftMsg.bytes_stmessage_subtitle.get().toStringUtf8();
        paramString1.message = paramDeliverGiftMsg.bytes_stmessage_message.get().toStringUtf8();
        paramString1.giftPicId = paramDeliverGiftMsg.uint32_stmessage_giftpicid.get();
        paramString1.comefrom = paramDeliverGiftMsg.bytes_stmessage_comefrom.get().toStringUtf8();
        paramString1.exflag = paramDeliverGiftMsg.uint32_stmessage_exflag.get();
        if (paramDeliverGiftMsg.bytes_stmessage_gifturl.has()) {
          paramString1.giftUrl = paramDeliverGiftMsg.bytes_stmessage_gifturl.get().toStringUtf8();
        }
        ((MessageForTroopGift)paramStringBuilder).prewrite();
      }
      if (QLog.isColorLevel()) {
        QLog.i(".troop.send_gift", 2, "MessageProtoCodec.decodePBMsgElems  decode send gift gray tips" + paramStringBuilder.msg);
      }
      if ((paramStringBuilder.summary != null) && (paramStringBuilder.rcvName != null) && (paramStringBuilder.rcvName.length() > 0))
      {
        paramDeliverGiftMsg = Pattern.compile(acfp.m(2131708224));
        paramString2 = paramStringBuilder.msg;
        paramString1 = paramString2;
        if (!paramStringBuilder.isToAll())
        {
          paramString1 = paramString2;
          if (paramStringBuilder.msg.startsWith("["))
          {
            i = paramStringBuilder.msg.indexOf("]");
            paramString1 = paramString2;
            if (i != -1)
            {
              paramString1 = paramString2;
              if (i < paramStringBuilder.msg.length()) {
                paramString1 = paramStringBuilder.msg.substring(i + 1);
              }
            }
          }
        }
        paramString2 = paramDeliverGiftMsg.matcher(paramString1);
        if (paramString2.find())
        {
          paramString2 = paramString2.group();
          i = paramString1.indexOf(paramString2);
          j = paramString1.lastIndexOf(paramString2);
          if ((i > 0) && (j == i)) {
            paramStringBuilder.senderName = paramString1.substring(0, i);
          }
        }
      }
      return paramStringBuilder;
      paramStringBuilder = (MessageForTroopGift)anbi.d(-2038);
      paramStringBuilder.msgtype = -2038;
      break;
      paramStringBuilder.is_activity_gift = 0;
    }
  }
  
  public MessageForReplyText.SourceMsgInfo a(List<im_msg_body.Elem> paramList, StringBuilder paramStringBuilder)
  {
    im_msg_body.Elem localElem = null;
    Iterator localIterator = paramList.iterator();
    paramList = null;
    Object localObject;
    if (localIterator.hasNext())
    {
      localObject = (im_msg_body.Elem)localIterator.next();
      if (((im_msg_body.Elem)localObject).src_msg.has())
      {
        localObject = (im_msg_body.SourceMsg)((im_msg_body.Elem)localObject).src_msg.get();
        paramList = (List<im_msg_body.Elem>)localObject;
        if (((im_msg_body.SourceMsg)localObject).bytes_src_msg.has()) {
          paramList = (List<im_msg_body.Elem>)localObject;
        }
      }
    }
    for (;;)
    {
      localObject = localElem;
      if (paramList != null)
      {
        localObject = localElem;
        if (paramList.elems.has())
        {
          if (QLog.isColorLevel()) {
            paramStringBuilder.append("elemType:SrcMsg;\n");
          }
          paramStringBuilder = paramList.elems.get();
          localObject = new MessageForReplyText.SourceMsgInfo();
          ((MessageForReplyText.SourceMsgInfo)localObject).mSourceMsgSeq = ((Integer)paramList.uint32_orig_seqs.get(0)).intValue();
          ((MessageForReplyText.SourceMsgInfo)localObject).mSourceMsgText = O(paramStringBuilder);
          ((MessageForReplyText.SourceMsgInfo)localObject).mSourceMsgTime = paramList.uint32_time.get();
          ((MessageForReplyText.SourceMsgInfo)localObject).mSourceMsgSenderUin = paramList.uint64_sender_uin.get();
          if (paramList.bytes_troop_name.has()) {}
          for (((MessageForReplyText.SourceMsgInfo)localObject).mSourceMsgTroopName = paramList.bytes_troop_name.get().toStringUtf8();; ((MessageForReplyText.SourceMsgInfo)localObject).mSourceMsgTroopName = null)
          {
            ((MessageForReplyText.SourceMsgInfo)localObject).mSourceMsgToUin = paramList.uint64_to_uin.get();
            ((MessageForReplyText.SourceMsgInfo)localObject).mSourceSummaryFlag = paramList.uint32_flag.get();
            paramStringBuilder = paramStringBuilder.iterator();
            while (paramStringBuilder.hasNext())
            {
              localElem = (im_msg_body.Elem)paramStringBuilder.next();
              if (localElem.anon_group_msg.has()) {
                ((MessageForReplyText.SourceMsgInfo)localObject).mAnonymousNickName = ((im_msg_body.AnonymousGroupMsg)localElem.anon_group_msg.get()).str_anon_nick.get().toStringUtf8();
              }
            }
            break;
          }
          if (paramList.uint32_type.has()) {
            ((MessageForReplyText.SourceMsgInfo)localObject).mType = paramList.uint32_type.get();
          }
          if (paramList.bytes_richMsg.has()) {
            ((MessageForReplyText.SourceMsgInfo)localObject).mRichMsg = paramList.bytes_richMsg.get().toStringUtf8();
          }
          if (paramList.bytes_pb_reserve.has()) {
            paramStringBuilder = new source_msg.ResvAttr();
          }
        }
      }
      try
      {
        paramStringBuilder.mergeFrom(paramList.bytes_pb_reserve.get().toByteArray());
        if (paramStringBuilder.uint32_ori_msgtype.has()) {
          ((MessageForReplyText.SourceMsgInfo)localObject).oriMsgType = paramStringBuilder.uint32_ori_msgtype.get();
        }
        if ((paramStringBuilder.uint64_orig_uids.has()) && (!paramStringBuilder.uint64_orig_uids.isEmpty())) {
          ((MessageForReplyText.SourceMsgInfo)localObject).origUid = ((Long)paramStringBuilder.uint64_orig_uids.get(0)).longValue();
        }
      }
      catch (InvalidProtocolBufferMicroException paramStringBuilder)
      {
        for (;;)
        {
          paramStringBuilder.printStackTrace();
        }
      }
      if (paramList.bytes_src_msg.has()) {
        ((MessageForReplyText.SourceMsgInfo)localObject).setSourceMsgByte(paramList.bytes_src_msg.get().toByteArray());
      }
      return localObject;
    }
  }
  
  public String a(im_msg_body.CommonElem paramCommonElem)
  {
    String str = "";
    Object localObject = str;
    if (paramCommonElem != null)
    {
      localObject = str;
      if (!paramCommonElem.bytes_pb_elem.has()) {}
    }
    try
    {
      localObject = new hummer_commelem.MsgElemInfo_servtype33();
      ((hummer_commelem.MsgElemInfo_servtype33)localObject).mergeFrom(paramCommonElem.bytes_pb_elem.get().toByteArray());
      if (((hummer_commelem.MsgElemInfo_servtype33)localObject).bytes_text.has()) {
        ((hummer_commelem.MsgElemInfo_servtype33)localObject).bytes_text.get().toStringUtf8();
      }
      int i = afky.hm(((hummer_commelem.MsgElemInfo_servtype33)localObject).uint32_index.get());
      localObject = str;
      if (i >= 0) {
        localObject = afky.eb(i);
      }
      return localObject;
    }
    catch (InvalidProtocolBufferMicroException paramCommonElem)
    {
      paramCommonElem.printStackTrace();
    }
    return "";
  }
  
  public StringBuilder a(StringBuilder paramStringBuilder1, List<im_msg_body.Elem> paramList, StringBuilder paramStringBuilder2, long paramLong, aozx paramaozx, anbg.b paramb, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList)
  {
    anbg.b localb = paramb;
    if (paramb == null) {
      localb = new anbg.b();
    }
    Object localObject2 = null;
    Object localObject1 = localb.b;
    paramb = null;
    if (paramStringBuilder1 != null) {}
    int i;
    for (StringBuilder localStringBuilder = new StringBuilder(paramStringBuilder1);; localStringBuilder = new StringBuilder(""))
    {
      i = 0;
      Iterator localIterator = paramList.iterator();
      paramStringBuilder1 = (StringBuilder)localObject2;
      paramList = (List<im_msg_body.Elem>)localObject1;
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label1269;
        }
        localObject1 = (im_msg_body.Elem)localIterator.next();
        if (!((im_msg_body.Elem)localObject1).text.has()) {
          break label631;
        }
        if (QLog.isColorLevel()) {
          paramStringBuilder2.append("elemType:Text;\n");
        }
        if (i == 0) {
          break;
        }
        i = 0;
      }
    }
    localObject1 = (im_msg_body.Text)((im_msg_body.Elem)localObject1).text.get();
    int m = localStringBuilder.length();
    if (((im_msg_body.Text)localObject1).str.has()) {
      localStringBuilder.append(anbk.w(((im_msg_body.Text)localObject1).str.get().toStringUtf8(), false));
    }
    label220:
    int k;
    int j;
    label275:
    label378:
    MessageForText.AtTroopMemberInfo localAtTroopMemberInfo;
    if (((im_msg_body.Text)localObject1).attr_6_buf.has())
    {
      localObject1 = ((im_msg_body.Text)localObject1).attr_6_buf.get();
      if (localObject1 != null)
      {
        localObject2 = ((ByteStringMicro)localObject1).toByteArray();
        if ((paramaozx != null) && ((paramaozx.uinType == 3000) || (paramaozx.uinType == 1)) && (paramArrayList != null) && (localObject2 != null) && (localObject2.length != 0))
        {
          n = aqoj.b((byte[])localObject2, 0);
          k = 2;
          j = 0;
          if ((j < n) && (k < 2048))
          {
            localObject1 = new MessageForText.AtTroopMemberInfo();
            if (((MessageForText.AtTroopMemberInfo)localObject1).readFrom((byte[])localObject2, k)) {
              break label472;
            }
          }
        }
        if ((paramaozx == null) || ((!paramaozx.b.r(24, paramLong)) && (!paramaozx.b.r(13, paramLong)) && (paramList != null)) || (localObject2 == null) || (localObject2.length == 0)) {
          break label1407;
        }
        int n = aqoj.b((byte[])localObject2, 0);
        k = 2;
        j = 0;
        localObject1 = paramStringBuilder1;
        if ((j >= n) || (k >= 2048)) {
          break label1399;
        }
        localAtTroopMemberInfo = new MessageForText.AtTroopMemberInfo();
        paramStringBuilder1 = (StringBuilder)localObject1;
        if (j == 0)
        {
          paramStringBuilder1 = (StringBuilder)localObject1;
          if (localObject1 == null) {
            paramStringBuilder1 = localAtTroopMemberInfo;
          }
        }
        if (localAtTroopMemberInfo.readFrom((byte[])localObject2, k)) {
          break label514;
        }
        localObject1 = paramList;
        paramList = paramStringBuilder1;
        paramStringBuilder1 = (StringBuilder)localObject1;
      }
    }
    for (;;)
    {
      localObject1 = paramb;
      paramb = paramList;
      paramList = paramStringBuilder1;
      paramStringBuilder1 = (StringBuilder)localObject1;
      label453:
      localObject1 = paramb;
      paramb = paramStringBuilder1;
      paramStringBuilder1 = (StringBuilder)localObject1;
      break;
      localObject2 = null;
      break label220;
      label472:
      k += ((MessageForText.AtTroopMemberInfo)localObject1).length();
      ((MessageForText.AtTroopMemberInfo)localObject1).startPos = ((short)(((MessageForText.AtTroopMemberInfo)localObject1).startPos + m));
      j = (short)(j + 1);
      paramArrayList.add(localObject1);
      break label275;
      label514:
      k += localAtTroopMemberInfo.length();
      localAtTroopMemberInfo.startPos = ((short)(localAtTroopMemberInfo.startPos + m));
      j = (short)(j + 1);
      if (localAtTroopMemberInfo.isIncludingAll()) {
        paramaozx.b.as(13, paramLong);
      }
      if (localAtTroopMemberInfo.isIncludingMe(this.c.app.getLongAccountUin()))
      {
        paramaozx.b.as(24, paramLong);
        if ((localAtTroopMemberInfo != paramStringBuilder1) && (paramList == null) && (paramStringBuilder1.isIncludingMe(this.c.app.getLongAccountUin()))) {
          paramList = localAtTroopMemberInfo;
        }
      }
      for (;;)
      {
        localObject1 = paramStringBuilder1;
        break label378;
        label631:
        if (((im_msg_body.Elem)localObject1).face.has())
        {
          if (QLog.isColorLevel()) {
            paramStringBuilder2.append("elemType:Face;\n");
          }
          if (!((im_msg_body.Face)((im_msg_body.Elem)localObject1).face.get()).index.has()) {
            break label1256;
          }
          j = afky.hm(((im_msg_body.Face)((im_msg_body.Elem)localObject1).face.get()).index.get());
          if (j >= 0)
          {
            localStringBuilder.append('\024');
            localStringBuilder.append((char)j);
          }
          localObject1 = paramStringBuilder1;
          paramStringBuilder1 = paramb;
          paramb = (anbg.b)localObject1;
          break label453;
        }
        if (((im_msg_body.Elem)localObject1).small_emoji.has())
        {
          if (QLog.isColorLevel()) {
            paramStringBuilder2.append("elemType:small_emoji;\n");
          }
          if (!((im_msg_body.SmallEmoji)((im_msg_body.Elem)localObject1).small_emoji.get()).packIdSum.has()) {
            break label1256;
          }
          i = (((im_msg_body.SmallEmoji)((im_msg_body.Elem)localObject1).small_emoji.get()).packIdSum.get() & 0xFFFF0000) >> 16;
          j = 0xFFFF & ((im_msg_body.SmallEmoji)((im_msg_body.Elem)localObject1).small_emoji.get()).packIdSum.get();
          localObject2 = afgc.a(i, j);
          if ((((im_msg_body.SmallEmoji)((im_msg_body.Elem)localObject1).small_emoji.get()).imageType.has()) && ((((im_msg_body.SmallEmoji)((im_msg_body.Elem)localObject1).small_emoji.get()).imageType.get() & 0xFFFF) == 2))
          {
            localObject2[3] = 511;
            if (QLog.isColorLevel()) {
              QLog.d("DecodeMsg", 2, "get apng epid = " + i + " eid = " + j);
            }
          }
          localStringBuilder.append('\024');
          localStringBuilder.append(localObject2[3]);
          localStringBuilder.append(localObject2[2]);
          localStringBuilder.append(localObject2[1]);
          localStringBuilder.append(localObject2[0]);
          i = 1;
          localObject1 = paramStringBuilder1;
          paramStringBuilder1 = paramb;
          paramb = (anbg.b)localObject1;
          break label453;
        }
        if (((im_msg_body.Elem)localObject1).online_image.has())
        {
          if (QLog.isColorLevel()) {
            paramStringBuilder2.append("elemType:OnlineImage;\n");
          }
          localStringBuilder.append(BaseApplication.getContext().getString(2131696611));
          localObject1 = paramStringBuilder1;
          paramStringBuilder1 = paramb;
          paramb = (anbg.b)localObject1;
          break label453;
        }
        if (((im_msg_body.Elem)localObject1).bankcode_ctrl_info.has())
        {
          if (QLog.isColorLevel()) {
            paramStringBuilder2.append("elemType: bankcode_ctrlinfo;\n");
          }
          localObject2 = ((im_msg_body.Elem)localObject1).bankcode_ctrl_info.get().toByteArray();
          j = localObject2[0];
          k = localObject2[(localObject2.length - 1)];
          if ((j != 40) || (k != 41))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            paramStringBuilder2.append("elemType: bankcode_ctrlinfo buffer error;\n");
            break;
          }
          if (ByteBuffer.wrap((byte[])localObject2, 2, 2).getShort() != 29786) {
            break;
          }
          j = ByteBuffer.wrap((byte[])localObject2, 4, 2).getShort();
          if (j <= 0) {
            break;
          }
          localObject1 = new byte[j];
          System.arraycopy(localObject2, 6, localObject1, 0, j);
          paramb = paramStringBuilder1;
          paramStringBuilder1 = (StringBuilder)localObject1;
          break label453;
        }
        if ((((im_msg_body.Elem)localObject1).common_elem.has()) && (33 == ((im_msg_body.Elem)localObject1).common_elem.uint32_service_type.get()))
        {
          if (QLog.isColorLevel()) {
            paramStringBuilder2.append("elemType:NewSysFaceMsg;\n");
          }
          localStringBuilder.append(a((im_msg_body.CommonElem)((im_msg_body.Elem)localObject1).common_elem.get()));
        }
        label1256:
        localObject1 = paramStringBuilder1;
        paramStringBuilder1 = paramb;
        paramb = (anbg.b)localObject1;
        break label453;
        label1269:
        localb.b = paramList;
        paramList = localb.An;
        if ((paramList != null) && ((paramStringBuilder1 != null) || (paramb != null)))
        {
          if (!paramList.isEmpty()) {
            break label1317;
          }
          paramList.add(paramStringBuilder1);
          paramList.add(paramb);
        }
        label1317:
        while ((paramList.size() != 2) || ((paramList.get(0) != null) && (paramList.get(1) != null))) {
          return localStringBuilder;
        }
        if (paramList.get(0) == null) {
          if (paramList.get(1) != null) {
            break label1386;
          }
        }
        for (;;)
        {
          paramList.clear();
          paramList.add(paramStringBuilder1);
          paramList.add(paramb);
          return localStringBuilder;
          paramStringBuilder1 = paramList.get(0);
          break;
          label1386:
          paramb = paramList.get(1);
        }
      }
      label1399:
      paramStringBuilder1 = paramList;
      paramList = (List<im_msg_body.Elem>)localObject1;
      continue;
      label1407:
      localObject1 = paramStringBuilder1;
      paramStringBuilder1 = paramList;
      paramList = (List<im_msg_body.Elem>)localObject1;
    }
  }
  
  public void a(MessageHandler paramMessageHandler, List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, aozx paramaozx)
  {
    paramList = a(paramList, paramStringBuilder, paramMsg.msg_head.msg_seq.get(), paramaozx);
    paramMsg = paramList.b;
    if (paramList.cdm != null)
    {
      paramStringBuilder = (ChatMessage)anbi.d(-1049);
      paramStringBuilder.msg = paramList.cdm;
      paramaozx = (MessageForReplyText)paramStringBuilder;
    }
    try
    {
      paramaozx.extLong |= 0x1;
      if (paramMsg.getSourceMsg() != null)
      {
        paramaozx.setSourceMessageRecord(paramMsg.unPackSourceMsg(paramMessageHandler.app));
        if ((paramaozx.getSourceMessage() != null) && (ahav.ax(paramaozx.getSourceMessage())))
        {
          paramMessageHandler = paramaozx.getSourceMessage().getExtInfoFromExtStr("_m_ForwardFileType");
          ChatMessage localChatMessage = ahav.e((ChatMessage)paramaozx.getSourceMessage());
          ahbr.a(this.app, localChatMessage, paramaozx.getSourceMessage());
          if ((!TextUtils.isEmpty(paramMessageHandler)) && (localChatMessage != null))
          {
            int i = Integer.parseInt(paramMessageHandler);
            if ((i == 1) || (i == 2))
            {
              QLog.i("DecodeMsg<QFile>", 1, "decode reply file msg, msg uniseq[" + localChatMessage.uniseq + "]");
              ahav.a(this.app, localChatMessage.uniseq, localChatMessage.frienduin, localChatMessage.istroop, (ChatMessage)paramaozx.getSourceMessage());
            }
          }
        }
      }
      paramMessageHandler = aqhs.bytes2HexStr(aczw.b(paramMsg));
      paramaozx.mSourceMsgInfo = paramMsg;
      paramaozx.saveExtInfoToExtStr("sens_msg_source_msg_info", paramMessageHandler);
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, "reply:" + paramaozx + " sourceMsg=" + paramaozx.getSourceMessage());
      }
    }
    catch (Exception paramMessageHandler)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SendMsgBtn", 2, "Save sourceMsgInfo exception:" + paramMessageHandler.getMessage());
        }
      }
    }
    if (paramList.fv != null) {
      paramStringBuilder.saveExtInfoToExtStr("sens_msg_ctrl_info", aqhs.bytes2HexStr(paramList.fv));
    }
    paramList1.add(paramStringBuilder);
    if (QLog.isColorLevel()) {
      QLog.d("DecodeMsg", 2, "reply msgRand = " + anbk.ab(paramStringBuilder.msgUid) + ", msgUid = " + paramStringBuilder.msgUid);
    }
  }
  
  public void a(MessageHandler paramMessageHandler, List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, aozx paramaozx, boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder("");
    ChatMessage localChatMessage = null;
    int i = 0;
    anbg.b localb = new anbg.b();
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = new ArrayList(2);
    im_msg_body.GeneralFlags localGeneralFlags = null;
    Iterator localIterator = paramList.iterator();
    im_msg_body.Elem localElem;
    Object localObject3;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localElem = (im_msg_body.Elem)localIterator.next();
        MessageForText localMessageForText;
        if (localElem.custom_face.has())
        {
          localObject3 = localObject2;
          if (((StringBuilder)localObject1).length() > 0)
          {
            localMessageForText = (MessageForText)anbi.d(-1000);
            localMessageForText.msgtype = -1000;
            localMessageForText.msg = ((StringBuilder)localObject1).toString();
            localMessageForText.atInfoList = ((ArrayList)localObject2);
            localObject3 = new ArrayList(2);
            localArrayList.add(localMessageForText);
            ((StringBuilder)localObject1).delete(0, ((StringBuilder)localObject1).length());
          }
          a(localElem, null, localArrayList, paramStringBuilder, paramMsg, paramBoolean, paramaozx);
        }
        for (localObject2 = localObject3;; localObject2 = localObject3)
        {
          break;
          if (!localElem.not_online_image.has()) {
            break label305;
          }
          localObject3 = localObject2;
          if (((StringBuilder)localObject1).length() > 0)
          {
            localMessageForText = (MessageForText)anbi.d(-1000);
            localMessageForText.msgtype = -1000;
            localMessageForText.msg = ((StringBuilder)localObject1).toString();
            localMessageForText.atInfoList = ((ArrayList)localObject2);
            localObject3 = new ArrayList(2);
            localArrayList.add(localMessageForText);
            ((StringBuilder)localObject1).delete(0, ((StringBuilder)localObject1).length());
          }
          a(localElem, null, localArrayList, paramStringBuilder, paramMsg);
        }
        label305:
        if (a(localElem).booleanValue())
        {
          if (i != 0)
          {
            i = 0;
            continue;
          }
          if (!localElem.small_emoji.has()) {
            break label2132;
          }
          i = 1;
        }
      }
    }
    label1685:
    label2076:
    label2084:
    label2132:
    for (;;)
    {
      localObject3 = new ArrayList();
      ((List)localObject3).add(localElem);
      localObject1 = a((StringBuilder)localObject1, (List)localObject3, paramStringBuilder, paramMsg.msg_head.msg_seq.get(), paramaozx, localb, (ArrayList)localObject2);
      break;
      if (localElem.general_flags.has())
      {
        localGeneralFlags = (im_msg_body.GeneralFlags)localElem.general_flags.get();
        break;
        if (((StringBuilder)localObject1).length() > 0)
        {
          localObject3 = (MessageForText)anbi.d(-1000);
          ((MessageForText)localObject3).msgtype = -1000;
          ((MessageForText)localObject3).msg = ((StringBuilder)localObject1).toString();
          ((MessageForText)localObject3).atInfoList = ((ArrayList)localObject2);
          if (paramaozx != null) {
            appb.a(paramaozx.uinType, (ArrayList)localObject2, (ChatMessage)localObject3);
          }
          localArrayList.add(localObject3);
          ((StringBuilder)localObject1).delete(0, ((StringBuilder)localObject1).length());
        }
        localObject2 = localb.An;
        if ((localObject2 != null) && (((ArrayList)localObject2).size() == 2)) {
          if (((ArrayList)localObject2).get(0) != null)
          {
            localObject1 = (MessageForText.AtTroopMemberInfo)((ArrayList)localObject2).get(0);
            if (((ArrayList)localObject2).get(1) != null)
            {
              localObject3 = (byte[])((ArrayList)localObject2).get(1);
              localObject2 = localObject1;
              localObject1 = localObject3;
            }
          }
        }
        for (;;)
        {
          paramList = a(paramList, paramStringBuilder);
          if (paramList != null) {
            paramStringBuilder = (MessageForReplyText)anbi.d(-1049);
          }
          try
          {
            paramStringBuilder.extLong |= 0x1;
            paramStringBuilder.mSourceMsgInfo = paramList;
            if (paramList.getSourceMsg() != null)
            {
              paramStringBuilder.setSourceMessageRecord(paramList.unPackSourceMsg(paramMessageHandler.app));
              if ((paramStringBuilder.getSourceMessage() != null) && (ahav.ax(paramStringBuilder.getSourceMessage())))
              {
                localObject3 = paramStringBuilder.getSourceMessage().getExtInfoFromExtStr("_m_ForwardFileType");
                localChatMessage = ahav.e((ChatMessage)paramStringBuilder.getSourceMessage());
                ahbr.a(this.app, localChatMessage, paramStringBuilder.getSourceMessage());
                if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (localChatMessage != null))
                {
                  i = Integer.parseInt((String)localObject3);
                  if ((i == 1) || (i == 2))
                  {
                    QLog.i("DecodeMsg<QFile>", 1, "decode mix inner reply file msg, msg uniseq[" + localChatMessage.uniseq + "]");
                    ahav.a(this.app, localChatMessage.uniseq, localChatMessage.frienduin, localChatMessage.istroop, (ChatMessage)paramStringBuilder.getSourceMessage());
                  }
                }
              }
            }
            paramStringBuilder.saveExtInfoToExtStr("sens_msg_source_msg_info", aqhs.bytes2HexStr(aczw.b(paramList)));
          }
          catch (Exception paramList)
          {
            for (;;)
            {
              if (QLog.isColorLevel())
              {
                QLog.d("SendMsgBtn", 2, "Save sourceMsgInfo exception:" + paramList.getMessage());
                continue;
                ((MessageForReplyText)localObject3).msg += paramStringBuilder.substring(i);
                continue;
                paramList = paramStringBuilder;
                if (QLog.isColorLevel())
                {
                  QLog.w("zivonchen", 2, "replytext 内容为空，有回复消息，但第一个消息体不是文本消息");
                  paramList = paramStringBuilder;
                  continue;
                  paramList = paramStringBuilder;
                  if (QLog.isColorLevel())
                  {
                    QLog.w("zivonchen", 2, "");
                    paramList = paramStringBuilder;
                  }
                }
              }
            }
          }
          paramList = paramStringBuilder;
          if (TextUtils.isEmpty(paramStringBuilder.mSourceMsgInfo.mAnonymousNickName))
          {
            paramList = paramStringBuilder;
            if (localObject2 != null)
            {
              if (localArrayList.size() <= 0) {
                break label1685;
              }
              paramList = (MessageRecord)localArrayList.get(0);
              if (!(paramList instanceof MessageForText)) {
                break label1660;
              }
              localObject3 = (MessageForReplyText)anbi.d(-1049);
              MessageRecord.copyMessageRecordBaseField((MessageRecord)localObject3, paramList);
              MessageRecord.copyMessageRecordStatusField((MessageRecord)localObject3, paramList);
              ((MessageForReplyText)localObject3).atInfoList = paramStringBuilder.atInfoList;
              ((MessageForReplyText)localObject3).msg = paramList.msg;
              ((MessageForReplyText)localObject3).mSourceMsgInfo = paramStringBuilder.mSourceMsgInfo;
              ((MessageForReplyText)localObject3).msgtype = -1049;
              if ((!TextUtils.isEmpty(((MessageForReplyText)localObject3).msg)) && (((MessageForReplyText)localObject3).msg.length() >= ((MessageForText.AtTroopMemberInfo)localObject2).textLen + ((MessageForText.AtTroopMemberInfo)localObject2).startPos))
              {
                paramStringBuilder = ((MessageForReplyText)localObject3).msg;
                ((MessageForReplyText)localObject3).msg = "";
                if (((MessageForText.AtTroopMemberInfo)localObject2).startPos > 0) {
                  ((MessageForReplyText)localObject3).msg = paramStringBuilder.substring(0, ((MessageForText.AtTroopMemberInfo)localObject2).startPos);
                }
                paramList = "";
                i = ((MessageForText.AtTroopMemberInfo)localObject2).startPos + ((MessageForText.AtTroopMemberInfo)localObject2).textLen;
                if (i + 1 < paramStringBuilder.length()) {
                  paramList = paramStringBuilder.substring(i, i + 1);
                }
                if (!paramList.equals(" ")) {
                  break label1624;
                }
                ((MessageForReplyText)localObject3).msg += paramStringBuilder.substring(i + 1);
                if ((((MessageForText.AtTroopMemberInfo)localObject2).isIncludingMe(paramMessageHandler.app.getLongAccountUin())) && (localb.b == null)) {
                  paramaozx.b.as(24, -1L);
                }
              }
              localArrayList.remove(0);
              localArrayList.add(0, localObject3);
              paramList = null;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("zivonchen", 2, "sb.length == 0");
          }
          if (paramList != null) {
            localArrayList.add(0, paramList);
          }
          if ((localGeneralFlags != null) && (localGeneralFlags.babyq_guide_msg_cookie.has())) {}
          try
          {
            if (localArrayList.size() > 0)
            {
              paramList = (MessageRecord)localArrayList.get(0);
              paramStringBuilder = localGeneralFlags.babyq_guide_msg_cookie.get().toByteArray();
              localObject3 = aqft.bytesToHexString(paramStringBuilder);
              if (QLog.isColorLevel()) {
                QLog.d("DecodeMsg", 2, "decodePBMsgElems_Pic, guideMsgCookie: " + (String)localObject3 + " ,byte: " + Arrays.toString(localGeneralFlags.babyq_guide_msg_cookie.get().toByteArray()));
              }
              paramList.saveExtInfoToExtStr("guide_msg_cookie", (String)localObject3);
              ((acbs)this.app.getBusinessHandler(53)).au(paramStringBuilder);
            }
          }
          catch (Exception paramList)
          {
            label1750:
            for (;;)
            {
              int j;
              long l;
              int k;
              int m;
              label1624:
              label1660:
              if (QLog.isColorLevel())
              {
                QLog.d("DecodeMsg", 2, "get pic msg guideMsgCookie error!", paramList);
                continue;
                if (paramStringBuilder.msgtype == -2000)
                {
                  j += 1;
                  continue;
                  continue;
                  if (j != 0)
                  {
                    paramList = new ArrayList();
                    paramStringBuilder = localArrayList.iterator();
                    while (paramStringBuilder.hasNext())
                    {
                      paramMsg = (MessageRecord)paramStringBuilder.next();
                      if ((paramMsg.msgtype != -1000) && (paramMsg.msgtype != -1049) && (paramMsg.msgtype != -2000))
                      {
                        if (paramList.size() > 0) {
                          if (k == 0) {
                            break label1931;
                          }
                        }
                        for (paramMessageHandler = null;; paramMessageHandler = (MessageHandler)localObject1)
                        {
                          paramList1.add(anbh.a(paramList, paramMessageHandler, paramaozx));
                          paramList.clear();
                          paramList1.add(paramMsg);
                          break;
                        }
                      }
                      paramList.add(paramMsg);
                    }
                    if (paramList.size() > 0)
                    {
                      if (k != 0) {
                        localObject1 = null;
                      }
                      paramMessageHandler = anbh.a(paramList, (byte[])localObject1, paramaozx);
                      paramList1.add(paramMessageHandler);
                      ((MessageForMixedMsg)paramMessageHandler).mAtInfo = ((MessageForText.AtTroopMemberInfo)localObject2);
                      paramList.clear();
                    }
                  }
                  for (;;)
                  {
                    return;
                    if (localObject1 == null)
                    {
                      paramList1.addAll(localArrayList);
                      return;
                    }
                    paramMessageHandler = localArrayList.iterator();
                    while (paramMessageHandler.hasNext())
                    {
                      paramList = (MessageRecord)paramMessageHandler.next();
                      if (((paramList instanceof MessageForText)) && (k == 0)) {
                        paramList.saveExtInfoToExtStr("sens_msg_ctrl_info", aqhs.bytes2HexStr((byte[])localObject1));
                      }
                      paramList1.add(paramList);
                    }
                  }
                  i = 0;
                  paramMessageHandler = null;
                  continue;
                  k = 0;
                }
                else
                {
                  continue;
                  j = 0;
                }
              }
            }
          }
          if (localArrayList.size() > 1)
          {
            paramList = localArrayList.iterator();
            j = 0;
            i = 0;
            if (paramList.hasNext())
            {
              paramStringBuilder = (MessageRecord)paramList.next();
              if (((paramStringBuilder.msgtype == -1000) || (paramStringBuilder.msgtype == -1049)) && (i == 0))
              {
                i = 1;
                j += 1;
                if (j < 2) {
                  break label1750;
                }
                j = 1;
                if (!paramMsg.msg_head.from_uin.has()) {
                  break label2084;
                }
                l = paramMsg.msg_head.from_uin.get();
                if (!TextUtils.equals(paramMessageHandler.app.getCurrentAccountUin(), Long.toString(l))) {
                  break label2084;
                }
                k = 1;
                m = 0;
                paramList = null;
                if ((localGeneralFlags == null) || (!localGeneralFlags.bytes_pb_reserve.has())) {
                  break label2076;
                }
              }
              try
              {
                paramStringBuilder = new generalflags.ResvAttr();
                paramStringBuilder.mergeFrom(localGeneralFlags.bytes_pb_reserve.get().toByteArray());
                paramMessageHandler = paramList;
                i = m;
                if (paramStringBuilder.bytes_kpl_info.has())
                {
                  paramMessageHandler = paramList;
                  i = m;
                  if (paramStringBuilder.bytes_kpl_info.has())
                  {
                    i = 1;
                    paramMessageHandler = paramStringBuilder.bytes_kpl_info.get().toStringUtf8();
                  }
                }
              }
              catch (Exception paramMessageHandler)
              {
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("KplMessage", 2, "parse proto catch exception about kpl");
                  }
                  paramMessageHandler.printStackTrace();
                  i = 0;
                  paramMessageHandler = null;
                }
                if (!QLog.isColorLevel()) {
                  break label1798;
                }
                QLog.d("KplMessage", 2, "resv a kpl pic message !");
                KplRoleInfo.handleKplFlag(this.app, paramMessageHandler);
              }
              if (i != 0)
              {
                paramList = localArrayList.iterator();
                while (paramList.hasNext()) {
                  ((MessageRecord)paramList.next()).saveExtInfoToExtStr("msg_ext_key", "Y");
                }
              }
            }
          }
          localObject3 = null;
          localObject2 = localObject1;
          localObject1 = localObject3;
          continue;
          localObject1 = null;
          break;
          localObject1 = null;
          localObject2 = localChatMessage;
        }
      }
      break;
    }
  }
  
  public void a(ArrayList<String> paramArrayList, List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, aozx paramaozx, anbm paramanbm, anax paramanax)
  {
    if (paramArrayList.contains("lifeOnline")) {
      a(paramList, paramList1, paramStringBuilder, paramMsg, paramaozx);
    }
    if (paramArrayList.contains("updateAvatar")) {
      a(paramList, paramMsg, paramStringBuilder);
    }
    paramArrayList = paramList.iterator();
    int i;
    long l;
    int n;
    int m;
    if (paramArrayList.hasNext())
    {
      paramList = (im_msg_body.Elem)paramArrayList.next();
      if ((paramList.near_by_msg.has()) && (paramList.near_by_msg.uint32_identify_type.has()) && (paramList.near_by_msg.uint32_identify_type.get() == 1))
      {
        if (!paramList1.isEmpty()) {
          ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("identify_flag", "true");
        }
        if (QLog.isColorLevel()) {
          paramStringBuilder.append("elemType: near_by_msg has identify;\n");
        }
      }
      if ((paramList.general_flags.has()) && (((im_msg_body.GeneralFlags)paramList.general_flags.get()).uint32_olympic_torch.has()))
      {
        i = paramList.general_flags.uint32_olympic_torch.get();
        if (QLog.isColorLevel()) {
          paramStringBuilder.append("has olympicTorch:").append(i).append(";");
        }
        if ((i > 0) && (!paramList1.isEmpty())) {
          ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("olympic_torch_flg", i + "");
        }
      }
      if (paramList.crm_elem.has()) {
        a(paramList, paramList1, paramStringBuilder, paramMsg, paramanbm);
      }
      if (paramList.general_flags.has())
      {
        if (paramList.general_flags.uint64_pendant_id.has())
        {
          l = paramList.general_flags.uint64_pendant_id.get();
          if (QLog.isColorLevel()) {
            QLog.d("DecodeMsg", 2, "vip_pendant_id = " + l);
          }
          if ((l >= 0L) && (!paramList1.isEmpty())) {
            ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("vip_pendant_id", String.valueOf(l));
          }
        }
        k = 0;
        n = 0;
        m = 0;
        if (paramList.general_flags.bytes_pb_reserve.has())
        {
          paramaozx = new generalflags.ResvAttr();
          j = n;
        }
      }
      try
      {
        paramaozx.mergeFrom(paramList.general_flags.bytes_pb_reserve.get().toByteArray());
        j = n;
        if (paramaozx.float_sticker_x.has())
        {
          j = n;
          localObject1 = new EmojiStickerManager.StickerInfo();
          j = n;
          ((EmojiStickerManager.StickerInfo)localObject1).x = paramaozx.float_sticker_x.get();
          j = n;
          if (!paramaozx.float_sticker_y.has()) {
            break label2592;
          }
          j = n;
          f = paramaozx.float_sticker_y.get();
          label520:
          j = n;
          ((EmojiStickerManager.StickerInfo)localObject1).y = f;
          j = n;
          if (!paramaozx.float_sticker_width.has()) {
            break label2598;
          }
          j = n;
          f = paramaozx.float_sticker_width.get();
          label560:
          j = n;
          ((EmojiStickerManager.StickerInfo)localObject1).width = f;
          j = n;
          if (!paramaozx.float_sticker_height.has()) {
            break label2604;
          }
          j = n;
          f = paramaozx.float_sticker_height.get();
          label600:
          j = n;
          ((EmojiStickerManager.StickerInfo)localObject1).height = f;
          j = n;
          if (!paramaozx.uint32_sticker_rotate.has()) {
            break label2610;
          }
          j = n;
          i = paramaozx.uint32_sticker_rotate.get();
          label640:
          j = n;
          ((EmojiStickerManager.StickerInfo)localObject1).rotate = i;
          j = n;
          if (!paramaozx.uint64_sticker_host_msgseq.has()) {
            break label2616;
          }
          j = n;
          l = paramaozx.uint64_sticker_host_msgseq.get();
          label680:
          j = n;
          ((EmojiStickerManager.StickerInfo)localObject1).hostMsgSeq = l;
          j = n;
          if (!paramaozx.uint64_sticker_host_msguid.has()) {
            break label2622;
          }
          j = n;
          l = paramaozx.uint64_sticker_host_msguid.get();
          label720:
          j = n;
          ((EmojiStickerManager.StickerInfo)localObject1).hostMsgUid = l;
          j = n;
          if (!paramaozx.uint64_sticker_host_time.has()) {
            break label2628;
          }
          j = n;
          l = paramaozx.uint64_sticker_host_time.get();
          label760:
          j = n;
          ((EmojiStickerManager.StickerInfo)localObject1).hostMsgTime = l;
          j = n;
          if (QLog.isColorLevel())
          {
            j = n;
            QLog.d("DecodeMsg", 2, "decodeC2CMsgPkg_EmojSticker->" + ((EmojiStickerManager.StickerInfo)localObject1).toString());
          }
          j = n;
          if (!paramList1.isEmpty())
          {
            j = n;
            localObject2 = (MessageRecord)paramList1.get(0);
            if (localObject2 != null)
            {
              j = n;
              ((MessageRecord)localObject2).saveExtInfoToExtStr("sticker_info", ((EmojiStickerManager.StickerInfo)localObject1).toJsonString());
              j = n;
              EmojiStickerManager.a((MessageRecord)localObject2, (EmojiStickerManager.StickerInfo)localObject1);
              j = n;
              ((MessageRecord)localObject2).saveExtInfoToExtStr("message_is_sticker", "true");
            }
          }
        }
        j = n;
        if (!paramaozx.uint32_mobile_custom_font.has()) {
          break label2634;
        }
        j = n;
        l = paramaozx.uint32_mobile_custom_font.get() & 0xFFFFFFFF;
        j = n;
        if (!paramList1.isEmpty())
        {
          j = n;
          ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("vip_font_id", String.valueOf(l));
        }
        j = n;
        if (!QLog.isColorLevel()) {
          break label2751;
        }
        j = n;
        QLog.d("DecodeMsg", 2, "vip_font_id = " + l + " fontId = " + ku.h(l) + " type = " + ku.c(l));
      }
      catch (InvalidProtocolBufferMicroException paramaozx)
      {
        for (;;)
        {
          Object localObject1;
          float f;
          Object localObject2;
          label1036:
          paramaozx.printStackTrace();
          k = j;
          continue;
          j = i;
          if (QLog.isColorLevel())
          {
            j = i;
            QLog.d("VasFont", 2, "diy_font_timestamp not in message");
          }
        }
      }
      j = i;
      if (paramaozx.uint64_subfont_id.has())
      {
        j = i;
        l = paramaozx.uint64_subfont_id.get();
        j = i;
        if (!paramList1.isEmpty())
        {
          j = i;
          ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("vip_sub_font_id", String.valueOf(l));
        }
        j = i;
        if (QLog.isColorLevel())
        {
          j = i;
          QLog.d("DecodeMsg", 2, "handleGeneralSettingFlags: subFontId=" + l);
        }
      }
      j = i;
      if (paramaozx.uint32_diy_font_timestamp.has())
      {
        j = i;
        l = paramaozx.uint32_diy_font_timestamp.get();
        j = i;
        if (!paramList1.isEmpty())
        {
          j = i;
          ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("diy_timestamp", String.valueOf(l));
        }
        j = i;
        if (QLog.isColorLevel())
        {
          j = i;
          QLog.d("VasFont", 2, "diy_font_timestamp = " + l);
        }
        j = i;
        if (paramaozx.uint32_tail_key.has())
        {
          j = i;
          if (2 == paramaozx.uint32_tail_key.get())
          {
            j = i;
            if (paramaozx.uint32_show_tail_flag.has())
            {
              j = i;
              if (1 != paramaozx.uint32_show_tail_flag.get())
              {
                j = i;
                paramaozx.uint32_tail_key.clear();
                j = i;
                if (QLog.isColorLevel())
                {
                  j = i;
                  QLog.d("DecodeMsg", 2, "handleGeneralSettingFlags uint32_show_tail_flag != 1, uint32_tail_key been cleaned ");
                }
              }
            }
          }
        }
        j = i;
        if (paramaozx.uint32_tail_key.has())
        {
          j = i;
          k = paramaozx.uint32_tail_key.get();
          j = i;
          if (!paramList1.isEmpty())
          {
            j = i;
            ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("app_tail_id", String.valueOf(k));
          }
          j = i;
          if (QLog.isColorLevel())
          {
            j = i;
            QLog.d("DecodeMsg", 2, "handleGeneralSettingFlags uint32_tail_key = " + k);
          }
        }
        j = i;
        if (paramaozx.uint32_bot_message_class_id.has())
        {
          j = i;
          k = paramaozx.uint32_bot_message_class_id.get();
          j = i;
          if (!paramList1.isEmpty())
          {
            j = i;
            ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("robot_news_class_id", String.valueOf(k));
          }
          j = i;
          if (QLog.isColorLevel())
          {
            j = i;
            QLog.d("DecodeMsg", 2, "handleGeneralSettingFlags uint32_bot_message_class_id = " + k);
          }
        }
        j = i;
        if (paramaozx.uint32_holiday_flag.has())
        {
          j = i;
          k = paramaozx.uint32_holiday_flag.get();
          if (k == 1)
          {
            j = i;
            if (!paramList1.isEmpty())
            {
              j = i;
              ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr(anbb.ccL, String.valueOf(k));
            }
          }
          j = i;
          if (QLog.isColorLevel())
          {
            j = i;
            QLog.d("DecodeMsg", 2, "handleGeneralSettingFlags uint32_holiday_flag = " + k);
          }
        }
        j = i;
        localObject1 = new StringBuilder("<---decodeMiniProgramPBMsgElems:");
        j = i;
        if (paramaozx.uint32_service_msg_type.has())
        {
          j = i;
          k = paramaozx.uint32_service_msg_type.get();
          j = i;
          if (!paramList1.isEmpty())
          {
            j = i;
            ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr(anbb.cdi, String.valueOf(k));
          }
          j = i;
          ((StringBuilder)localObject1).append("---uint32_service_msg_type = ").append(k).append("---");
        }
        j = i;
        if (paramaozx.uint32_service_msg_remind_type.has())
        {
          j = i;
          k = paramaozx.uint32_service_msg_remind_type.get();
          j = i;
          if (!paramList1.isEmpty())
          {
            j = i;
            ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr(anbb.cdj, String.valueOf(k));
          }
          j = i;
          ((StringBuilder)localObject1).append("---uint32_service_msg_remind_type = ").append(k).append("---");
        }
        j = i;
        if (paramaozx.bytes_service_msg_name.has())
        {
          j = i;
          localObject2 = paramaozx.bytes_service_msg_name.get().toStringUtf8();
          j = i;
          if (!paramList1.isEmpty())
          {
            j = i;
            ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr(anbb.cdk, (String)localObject2);
          }
          j = i;
          ((StringBuilder)localObject1).append("---bytes_service_msg_name = ").append((String)localObject2).append("---");
        }
        j = i;
        if (QLog.isColorLevel())
        {
          j = i;
          QLog.d("DecodeMsg", 2, new Object[] { localObject1 });
        }
        j = i;
      }
    }
    try
    {
      if (paramaozx.uint32_msg_info_flag.has())
      {
        j = i;
        k = paramaozx.uint32_msg_info_flag.get();
        j = i;
        if (!paramList1.isEmpty())
        {
          j = i;
          ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("key_message_extra_info_flag", String.valueOf(k));
        }
        j = i;
        if (QLog.isColorLevel())
        {
          j = i;
          QLog.i("DecodeMsg", 2, "handleGeneralSettingFlags: invoked.  flag: " + k);
        }
      }
    }
    catch (Throwable localThrowable)
    {
      label2107:
      break label2107;
    }
    int k = i;
    int j = i;
    if (paramaozx.uint32_comment_flag.has())
    {
      k = i;
      j = i;
      if (paramaozx.uint64_comment_location.has())
      {
        k = i;
        j = i;
        if (!paramList1.isEmpty())
        {
          j = i;
          if (paramaozx.uint32_comment_flag.get() != 1) {
            break label2757;
          }
        }
      }
    }
    label2592:
    label2598:
    label2604:
    label2610:
    label2616:
    label2622:
    label2628:
    label2757:
    for (boolean bool = true;; bool = false)
    {
      j = i;
      l = paramaozx.uint64_comment_location.get();
      j = i;
      localObject1 = (MessageRecord)paramList1.get(0);
      j = i;
      if ((localObject1 instanceof MessageForReplyText))
      {
        j = i;
        localObject1 = (MessageForReplyText)localObject1;
        j = i;
        ((MessageForReplyText)localObject1).isBarrageMsg = bool;
        j = i;
        ((MessageForReplyText)localObject1).barrageTimeLocation = l;
        j = i;
        if (((MessageForReplyText)localObject1).isBarrageMsg)
        {
          j = i;
          ((MessageForReplyText)localObject1).saveExtInfoToExtStr("barrage_time_location", String.valueOf(((MessageForReplyText)localObject1).barrageTimeLocation));
          j = i;
        }
      }
      try
      {
        localObject2 = new oidb_0xdea.PassThrough();
        j = i;
        ((oidb_0xdea.PassThrough)localObject2).mergeFrom(paramaozx.bytes_pass_through.get().toByteArray());
        j = i;
        ((MessageForReplyText)localObject1).barrageSourceMsgType = ((oidb_0xdea.PassThrough)localObject2).entrance.get();
      }
      catch (Exception paramaozx)
      {
        for (;;)
        {
          j = i;
          QLog.i("DecodeMsg", 1, "handleGeneralSettingFlags fail, " + paramaozx);
        }
      }
      k = i;
      j = i;
      if (QLog.isColorLevel())
      {
        j = i;
        QLog.d("DecodeMsg", 2, new Object[] { "receive replay msg, isBarrageMsg: ", Boolean.valueOf(bool), " timeLocation:", Long.valueOf(l) });
        k = i;
      }
      if (k == 0)
      {
        l = anbh.a(paramMsg);
        if (l >= 0L)
        {
          if (!paramList1.isEmpty()) {
            ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("vip_font_id", String.valueOf(l));
          }
          if (QLog.isColorLevel()) {
            QLog.d("DecodeMsg", 2, "old vip_font_id = " + l + " fontId = " + ku.h(l) + " type = " + ku.c(l));
          }
        }
      }
      if ((paramList.common_elem.has()) && (21 == paramList.common_elem.uint32_service_type.get())) {
        aegu.a(paramMsg, paramList, paramList1, this.c.app);
      }
      if ((!paramList.common_elem.has()) || (34 != paramList.common_elem.uint32_service_type.get())) {
        break;
      }
      ahti.a(paramMsg, paramList, paramList1, this.c.app, paramanax);
      break;
      f = 0.0F;
      break label520;
      f = 0.0F;
      break label560;
      f = 0.0F;
      break label600;
      i = 0;
      break label640;
      l = 0L;
      break label680;
      l = 0L;
      break label720;
      l = 0L;
      break label760;
      label2634:
      i = m;
      j = n;
      if (!QLog.isColorLevel()) {
        break label1036;
      }
      j = n;
      QLog.d("DecodeMsg", 2, "handleGeneralSettingFlags vip_font not has");
      i = m;
      break label1036;
      return;
      i = 1;
      break label1036;
    }
  }
  
  public void a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder)
  {
    Object localObject = null;
    boolean bool = true;
    Iterator localIterator = paramList.iterator();
    int i = -1;
    int j = 0;
    im_msg_body.Elem localElem = null;
    paramList = (List<im_msg_body.Elem>)localObject;
    localObject = localElem;
    if (localIterator.hasNext())
    {
      localElem = (im_msg_body.Elem)localIterator.next();
      if (!localElem.video_file.has()) {
        break label334;
      }
      localObject = (im_msg_body.VideoFile)localElem.video_file.get();
    }
    label316:
    label334:
    for (;;)
    {
      if ((localElem.bless_msg.has()) && (localElem.bless_msg.uint32_msg_type.get() == 1)) {
        if (localElem.bless_msg.uint32_ex_flag.has())
        {
          i = localElem.bless_msg.uint32_ex_flag.get();
          j = 1;
        }
      }
      for (;;)
      {
        if (localElem.general_flags.has()) {
          paramList = (im_msg_body.GeneralFlags)localElem.general_flags.get();
        }
        for (;;)
        {
          break;
          if (localObject == null) {
            return;
          }
          if (QLog.isColorLevel()) {
            paramStringBuilder.append("elemType:video_file;\n");
          }
          paramList = a(paramList, a((im_msg_body.VideoFile)localObject, paramList));
          paramList1.add(paramList);
          if (j != 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("DecodeMsg", 2, "decodePBMsgElems, isBlessMsg: true ,updateFlag: " + i);
            }
            paramList.isBlessMsg = true;
            if (i > -1) {
              if ((i & 0x1) != 1) {
                break label316;
              }
            }
          }
          for (;;)
          {
            paramList.needUpdateMsgTag = bool;
            if (!QLog.isColorLevel()) {
              break;
            }
            paramStringBuilder.append("ShortVideo.msg: ").append(paramList.toString() + "\n" + paramList.toLogString()).append("\n");
            return;
            bool = false;
          }
        }
        j = 1;
      }
    }
  }
  
  public void a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, aozx paramaozx)
  {
    paramStringBuilder = paramList.iterator();
    im_msg_body.Elem localElem;
    do
    {
      if (!paramStringBuilder.hasNext()) {
        break;
      }
      localElem = (im_msg_body.Elem)paramStringBuilder.next();
    } while (!localElem.life_online.has());
    for (;;)
    {
      if (localElem == null) {
        return;
      }
      long l1;
      label111:
      long l2;
      label139:
      long l3;
      label166:
      long l4;
      label193:
      int j;
      int i3;
      int i4;
      Object localObject3;
      String str;
      label271:
      boolean bool;
      label306:
      int m;
      label345:
      int n;
      label384:
      int i1;
      label423:
      int i5;
      int i6;
      int i;
      label509:
      int k;
      label548:
      label587:
      label616:
      Object localObject1;
      label646:
      label676:
      Object localObject2;
      int i2;
      if ((localElem.life_online.has()) && (localElem.life_online.uint32_ack.has()) && (localElem.life_online.uint32_ack.get() == 1))
      {
        if (localElem.life_online.uint64_unique_id.has())
        {
          l1 = localElem.life_online.uint64_unique_id.get();
          if (!localElem.life_online.uint32_op.has()) {
            break label1318;
          }
          l2 = localElem.life_online.uint32_op.get();
          if (!paramMsg.msg_head.from_uin.has()) {
            break label1324;
          }
          l3 = paramMsg.msg_head.from_uin.get();
          if (!paramMsg.msg_head.to_uin.has()) {
            break label1330;
          }
          l4 = paramMsg.msg_head.to_uin.get();
          kaw.a().a(BaseApplication.getContext(), this.c.app, l1, l2, l3, l4, 1, null);
        }
      }
      else
      {
        j = 0;
        i3 = 0;
        i4 = 0;
        paramaozx = "";
        localObject3 = "";
        str = "";
        if (!localElem.life_online.uint64_unique_id.has()) {
          break label1336;
        }
        l1 = localElem.life_online.uint64_unique_id.get();
        if (!localElem.life_online.uint64_bitmap.has()) {
          break label1348;
        }
        if ((localElem.life_online.uint64_bitmap.get() & 1L) != 1L) {
          break label1342;
        }
        bool = true;
        if (!localElem.life_online.uint64_bitmap.has()) {
          break label1360;
        }
        if ((localElem.life_online.uint64_bitmap.get() & 0x4) != 4L) {
          break label1354;
        }
        m = 1;
        if (!localElem.life_online.uint64_bitmap.has()) {
          break label1372;
        }
        if ((localElem.life_online.uint64_bitmap.get() & 0x40) != 64L) {
          break label1366;
        }
        n = 1;
        if (!localElem.life_online.uint64_bitmap.has()) {
          break label1384;
        }
        if ((localElem.life_online.uint64_bitmap.get() & 0x800) != 2048L) {
          break label1378;
        }
        i1 = 1;
        i5 = (int)((localElem.life_online.uint64_bitmap.get() & 0x180) >> 7);
        i6 = (int)((localElem.life_online.uint64_bitmap.get() & 0x600) >> 9);
        if (m == 0) {
          break label1449;
        }
        if (!localElem.life_online.uint64_bitmap.has()) {
          break label1396;
        }
        if ((localElem.life_online.uint64_bitmap.get() & 0x8) != 8L) {
          break label1390;
        }
        i = 1;
        if (!localElem.life_online.uint64_bitmap.has()) {
          break label1408;
        }
        if ((localElem.life_online.uint64_bitmap.get() & 0x10) != 16L) {
          break label1402;
        }
        j = 1;
        if (!localElem.life_online.uint64_bitmap.has()) {
          break label1420;
        }
        if ((localElem.life_online.uint64_bitmap.get() & 0x20) != 32L) {
          break label1414;
        }
        k = 1;
        if (!localElem.life_online.gdt_imp_data.has()) {
          break label1426;
        }
        paramStringBuilder = localElem.life_online.gdt_imp_data.get().toStringUtf8();
        if (!localElem.life_online.gdt_cli_data.has()) {
          break label1433;
        }
        paramaozx = localElem.life_online.gdt_cli_data.get().toStringUtf8();
        if (!localElem.life_online.view_id.has()) {
          break label1441;
        }
        localObject1 = localElem.life_online.view_id.get().toStringUtf8();
        localObject2 = paramStringBuilder;
        if (paramStringBuilder.length() > 100) {
          localObject2 = paramStringBuilder.substring(0, 100);
        }
        if (paramaozx.length() <= 100) {
          break label1720;
        }
        paramStringBuilder = paramaozx.substring(0, 100);
        i2 = j;
      }
      label1408:
      label1665:
      for (;;)
      {
        label720:
        if (localElem.life_online.uint64_bitmap.has()) {
          if ((localElem.life_online.uint64_bitmap.get() & 0x1000) == 4096L)
          {
            j = 1;
            label759:
            if (((j != 0) || ((paramMsg.msg_head.from_uin.has()) && (paramMsg.msg_head.from_uin.get() == 1579646438L))) && (!paramList1.isEmpty())) {
              ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("kandian_replace_subscribe_msg", "1");
            }
            if (i1 != 0)
            {
              if (!paramList1.isEmpty()) {
                ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("recent_list_advertisement_message", "1");
              }
              if (QLog.isColorLevel())
              {
                localObject3 = new StringBuilder().append("isRecentAd, uint64_bitmap value is: ");
                if (!localElem.life_online.uint64_bitmap.has()) {
                  break label1582;
                }
                paramaozx = Long.valueOf(localElem.life_online.uint64_bitmap.get());
                QLog.d("DecodeMsg", 2, paramaozx);
              }
              ThreadManager.getSubThreadHandler().postDelayed(new MessagePBElemDecoder.1(this), 1000L);
            }
            if (!paramList1.isEmpty())
            {
              paramaozx = (MessageRecord)paramList1.get(0);
              paramaozx.extLong |= 0x1;
              ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("pa_msgHasRead", "false");
              ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("pa_msgId", String.valueOf(l1));
              ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("pa_should_report", String.valueOf(bool));
              if (m != 0)
              {
                ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("isAdMsg", "1");
                ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("ad_msgHasRead", "false");
                ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("gdt_msgClick", paramStringBuilder);
                ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("gdt_msgImp", (String)localObject2);
                paramaozx = (MessageRecord)paramList1.get(0);
                if (i == 0) {
                  break label1590;
                }
                paramStringBuilder = "1";
                label1135:
                paramaozx.saveExtInfoToExtStr("gdt_singleAd", paramStringBuilder);
                paramaozx = (MessageRecord)paramList1.get(0);
                if (i2 == 0) {
                  break label1597;
                }
                paramStringBuilder = "1";
                paramaozx.saveExtInfoToExtStr("gdt_mulAd", paramStringBuilder);
                paramaozx = (MessageRecord)paramList1.get(0);
                if (k == 0) {
                  break label1604;
                }
                paramStringBuilder = "1";
                paramaozx.saveExtInfoToExtStr("gdt_followAd", paramStringBuilder);
                ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("is_AdArrive_Msg", "1");
                ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("gdt_view_id", (String)localObject1);
              }
            }
            if ((n == 0) || (paramList1.isEmpty())) {
              break label1665;
            }
            paramList = paramList.iterator();
            i = 0;
            label1265:
            if (!paramList.hasNext()) {
              break label1611;
            }
            paramStringBuilder = (im_msg_body.Elem)paramList.next();
            if (!paramStringBuilder.pub_acc_info.uint32_is_inter_num.has()) {
              break label1717;
            }
            i = paramStringBuilder.pub_acc_info.uint32_is_inter_num.get();
          }
        }
        label908:
        label1165:
        label1195:
        label1324:
        label1330:
        label1717:
        for (;;)
        {
          break label1265;
          l1 = 0L;
          break label111;
          l2 = 0L;
          break label139;
          l3 = 0L;
          break label166;
          l4 = 0L;
          break label193;
          label1336:
          l1 = 0L;
          break label271;
          label1342:
          bool = false;
          break label306;
          label1348:
          bool = false;
          break label306;
          label1354:
          m = 0;
          break label345;
          label1360:
          m = 0;
          break label345;
          label1366:
          n = 0;
          break label384;
          label1372:
          n = 0;
          break label384;
          label1378:
          i1 = 0;
          break label423;
          label1384:
          i1 = 0;
          break label423;
          label1390:
          i = 0;
          break label509;
          label1396:
          i = 0;
          break label509;
          label1402:
          j = 0;
          break label548;
          j = 0;
          break label548;
          k = 0;
          break label587;
          k = 0;
          break label587;
          paramStringBuilder = "";
          break label616;
          paramaozx = "";
          break label646;
          localObject1 = "";
          break label676;
          i2 = i3;
          k = i4;
          localObject2 = localObject3;
          paramStringBuilder = paramaozx;
          localObject1 = str;
          i = j;
          if (!QLog.isColorLevel()) {
            break label720;
          }
          localObject1 = new StringBuilder().append("isAdArriveMsg is false, uint64_bitmap value is: ");
          if (localElem.life_online.uint64_bitmap.has()) {}
          for (paramStringBuilder = Long.valueOf(localElem.life_online.uint64_bitmap.get());; paramStringBuilder = "null")
          {
            QLog.d("DecodeMsg", 2, paramStringBuilder);
            i2 = i3;
            k = i4;
            localObject2 = localObject3;
            paramStringBuilder = paramaozx;
            localObject1 = str;
            i = j;
            break;
          }
          j = 0;
          break label759;
          j = 0;
          break label759;
          paramaozx = "null";
          break label908;
          label1590:
          paramStringBuilder = "0";
          break label1135;
          label1597:
          paramStringBuilder = "0";
          break label1165;
          label1604:
          paramStringBuilder = "0";
          break label1195;
          label1611:
          paramList = (MessageRecord)paramList1.get(0);
          paramList.saveExtInfoToExtStr("welcome_msg", "true");
          if ((i != 2) && (((paramList instanceof MessageForText)) || ((paramList instanceof MessageForLongMsg)))) {
            ThreadManager.executeOnSubThread(new MessagePBElemDecoder.2(this, paramMsg));
          }
          if (paramList1.isEmpty()) {
            break;
          }
          ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("public_account_msg_unread_flag", String.valueOf(i5));
          ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("public_account_msg_extra_info_type", String.valueOf(i6));
          return;
        }
        label1318:
        label1449:
        label1582:
        label1720:
        i2 = j;
        label1414:
        label1420:
        label1426:
        label1433:
        label1441:
        paramStringBuilder = paramaozx;
      }
      localElem = null;
    }
  }
  
  public void a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, aozx paramaozx, boolean paramBoolean)
  {
    int i = 0;
    im_msg_body.Elem localElem = null;
    ArrayList localArrayList = new ArrayList();
    if (QLog.isColorLevel()) {
      paramStringBuilder.append("elemType:MarketFace;\n");
    }
    Iterator localIterator = paramList.iterator();
    paramList = localElem;
    if (localIterator.hasNext())
    {
      localElem = (im_msg_body.Elem)localIterator.next();
      if (localElem.market_face.has())
      {
        if (!localArrayList.isEmpty())
        {
          a(this.c, localArrayList, paramList1, paramStringBuilder, paramMsg, paramaozx, paramBoolean);
          localArrayList.clear();
        }
        paramList = a(localElem, paramList1, paramStringBuilder, ((im_msg_body.Attr)((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).attr.get()).time.get());
        i = 1;
      }
      for (;;)
      {
        for (;;)
        {
          break;
          if ((i != 0) && (localElem.text.has()) && (paramList != null))
          {
            paramList.faceName = ((im_msg_body.Text)localElem.text.get()).str.get().toStringUtf8();
            if ((paramList.faceName.charAt(0) == '[') && (paramList.faceName.charAt(paramList.faceName.length() - 1) == ']')) {
              paramList.faceName = paramList.faceName.substring(1, paramList.faceName.length() - 1);
            }
            try
            {
              ((MessageRecord)paramList1.get(paramList1.size() - 1)).msgData = aczw.b(paramList);
              if (QLog.isColorLevel()) {
                paramStringBuilder.append("filter the text expalin:").append(((im_msg_body.Text)localElem.text.get()).str.get()).append("\n");
              }
              i = 0;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                QLog.e("MessageForMarketFace", 1, "decodePBMsgElems_MarketFace: ", localException);
              }
            }
          }
        }
        localArrayList.add(localElem);
      }
    }
    if (!localArrayList.isEmpty())
    {
      a(this.c, localArrayList, paramList1, paramStringBuilder, paramMsg, paramaozx, paramBoolean);
      localArrayList.clear();
    }
  }
  
  public void a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, boolean paramBoolean)
  {
    Iterator localIterator = paramList.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      paramList = (im_msg_body.Elem)localIterator.next();
    } while (!paramList.hc_flash_pic.has());
    for (;;)
    {
      if (paramList == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("elemType:FlashPic;\n");
      }
      a(paramList, null, paramList1, paramStringBuilder, paramMsg, paramBoolean);
      return;
      paramList = null;
    }
  }
  
  public void a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    Object localObject = paramList.iterator();
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      paramList = (im_msg_body.Elem)((Iterator)localObject).next();
    } while (!paramList.shake_window.has());
    for (;;)
    {
      if (paramList == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("elemType:ShakeWindow;\n");
      }
      paramList = (im_msg_body.ShakeWindow)paramList.shake_window.get();
      localObject = (MessageForShakeWindow)anbi.d(-2020);
      ((MessageForShakeWindow)localObject).msgtype = -2020;
      ((MessageForShakeWindow)localObject).msg = "[Shake Window]";
      ShakeWindowMsg localShakeWindowMsg = new ShakeWindowMsg();
      localShakeWindowMsg.mType = paramList.uint32_type.get();
      localShakeWindowMsg.mReserve = paramList.uint32_reserve.get();
      if (paramBoolean) {}
      for (int i = 2;; i = 1)
      {
        localShakeWindowMsg.onlineFlag = i;
        localShakeWindowMsg.shake = true;
        ((MessageForShakeWindow)localObject).msgData = localShakeWindowMsg.getBytes();
        if (((MessageForShakeWindow)localObject).msgData != null) {
          break label189;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        paramStringBuilder.append("c2cMsgContent.data:null;\n");
        return;
      }
      label189:
      paramList1.add(localObject);
      return;
      paramList = null;
    }
  }
  
  public void a(List<im_msg_body.Elem> paramList, msg_comm.Msg paramMsg, StringBuilder paramStringBuilder)
  {
    paramList = paramList.iterator();
    do
    {
      if (!paramList.hasNext()) {
        break;
      }
      paramStringBuilder = (im_msg_body.Elem)paramList.next();
    } while (!paramStringBuilder.common_elem.has());
    for (paramList = (im_msg_body.CommonElem)paramStringBuilder.common_elem.get();; paramList = null)
    {
      if (paramList == null) {}
      for (;;)
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("DecodeMsg", 2, "QQ 18 Parse msg found common_lem elemType = UpdateStrangerAvatar;\n");
        }
        paramStringBuilder = new hummer_commelem.MsgElemInfo_servtype13();
        try
        {
          paramStringBuilder.mergeFrom(paramList.bytes_pb_elem.get().toByteArray());
          if ((paramStringBuilder.uint32_sys_head_id.has()) && (paramStringBuilder.uint32_head_flag.has()))
          {
            int i = paramStringBuilder.uint32_sys_head_id.get();
            int j = paramStringBuilder.uint32_head_flag.get();
            if (QLog.isColorLevel()) {
              QLog.d("DecodeMsg", 2, "QQ 18 elemType:UpdateStrangerAvatar system id = " + i + ", headType = " + j);
            }
            long l = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
            paramList = (aczr)this.app.getManager(199);
            if ((paramList != null) && (paramList.adh()))
            {
              paramList.ag(String.valueOf(l), i, j);
              return;
            }
          }
        }
        catch (InvalidProtocolBufferMicroException paramList)
        {
          paramList.printStackTrace();
          return;
        }
      }
    }
  }
  
  public void a(im_msg_body.Elem paramElem, im_msg_body.CustomFace paramCustomFace, List<MessageRecord> paramList, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, boolean paramBoolean)
  {
    a(paramElem, paramCustomFace, paramList, paramStringBuilder, paramMsg, paramBoolean, null);
  }
  
  public void a(im_msg_body.Elem paramElem, im_msg_body.CustomFace paramCustomFace, List<MessageRecord> paramList, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, boolean paramBoolean, aozx paramaozx)
  {
    if (paramElem != null) {}
    for (boolean bool1 = paramElem.hc_flash_pic.has();; bool1 = false)
    {
      if (paramCustomFace != null) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        if (QLog.isColorLevel()) {
          paramStringBuilder.append("elemType:CustomFace: isC2C:").append(paramBoolean).append(";\n");
        }
        StringBuilder localStringBuilder = new StringBuilder("");
        if (paramBoolean)
        {
          localStringBuilder.append(BaseApplication.getContext().getString(2131696611));
          paramElem = (msg_comm.MsgHead)paramMsg.msg_head.get();
          l1 = paramElem.msg_seq.get();
          l2 = paramElem.msg_uid.get();
          long l3 = paramElem.msg_time.get();
          long l4 = paramElem.from_uin.get();
          long l5 = paramElem.to_uin.get();
          paramElem = new HashMap();
          paramElem.put("param_FailCode", String.valueOf(10001));
          paramElem.put("fromUin", String.valueOf(l4));
          paramElem.put("toUin", String.valueOf(l5));
          paramElem.put("msgSeq", String.valueOf(l1));
          paramElem.put("msgUid", String.valueOf(l2));
          paramElem.put("msgtime", String.valueOf(l3));
          paramCustomFace = this.c.app.getCurrentAccountUin();
          anpc.a(BaseApplication.getContext()).collectPerformance(paramCustomFace, "actMessageEvent", false, 0L, 0L, paramElem, "");
          if (QLog.isColorLevel()) {
            QLog.d("flash", 2, "parsePBMsgElems_CustomFace isC2C");
          }
          return;
        }
        if ((localStringBuilder.length() > 0) && (!bool1) && (!bool2))
        {
          localObject1 = (MessageForText)anbi.d(-1000);
          ((MessageForText)localObject1).msgtype = -1000;
          ((MessageForText)localObject1).msg = localStringBuilder.toString();
          paramList.add(localObject1);
          localStringBuilder.delete(0, localStringBuilder.length());
        }
        Object localObject1 = null;
        if (paramCustomFace != null) {}
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("flash", 2, "parsePBMsgElems_CustomFace hasComFlashPic=" + bool2);
          }
          if (paramCustomFace != null) {
            break;
          }
          QLog.d("DecodeMsg", 2, "parsePBMsgElems_CustomFace customface is null");
          return;
          paramCustomFace = (im_msg_body.CustomFace)localObject1;
          if (paramElem != null) {
            if (bool1) {
              paramCustomFace = (im_msg_body.CustomFace)paramElem.hc_flash_pic.get();
            } else {
              paramCustomFace = (im_msg_body.CustomFace)paramElem.custom_face.get();
            }
          }
        }
        paramElem = paramCustomFace.str_file_path.get();
        paramCustomFace.str_shortcut.get();
        String str1 = paramCustomFace.str_big_url.get();
        String str2 = paramCustomFace.str_orig_url.get();
        String str3 = paramCustomFace.str_thumb_url.get();
        String str4 = paramCustomFace.str_400_url.get();
        int m = paramCustomFace.uint32_thumb_width.get();
        int n = paramCustomFace.uint32_thumb_height.get();
        if (QLog.isColorLevel()) {
          QLog.d("DecodeMsg", 2, "[CustomFace] ThumbWidth=" + m + ",ThumbHeight=" + n + "downURLBigThum400=" + str4);
        }
        int j = paramCustomFace.uint32_show_len.get();
        int i = paramCustomFace.uint32_download_len.get();
        long l1 = paramCustomFace.uint32_file_id.get();
        long l2 = paramCustomFace.uint32_file_type.get();
        l2 = paramCustomFace.uint32_server_ip.get();
        l2 = paramCustomFace.uint32_server_port.get();
        l2 = paramCustomFace.uint32_useful.get();
        l2 = paramCustomFace.uint32_size.get() & 0xFFFFFFFF;
        int k = paramCustomFace.image_type.get();
        if (QLog.isColorLevel())
        {
          QLog.d("DecodeMsg", 2, "[CustomFace] uint32_size=" + l2);
          QLog.d("DecodeMsg", 2, "[CustomFace] imgType=" + k);
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("peak_pgjpeg", 4, "MessageProtoCodec.decodePBMsgElems(): showLen " + j + ", downloadLen " + i + ", fileLen " + l2);
        }
        Object localObject2 = paramCustomFace.bytes_md5.get().toByteArray();
        localObject1 = paramCustomFace.bytes_signature.get().toByteArray();
        paramCustomFace.bytes_buffer.get().toByteArray();
        Object localObject3 = paramCustomFace.bytes_flag.get().toByteArray();
        int i1 = (int)(paramCustomFace.uint32_width.get() & 0xFFFFFFFF);
        int i2 = (int)(paramCustomFace.uint32_height.get() & 0xFFFFFFFF);
        localObject2 = aqhs.bytes2HexStr((byte[])localObject2);
        aqhs.bytes2HexStr((byte[])localObject1);
        aqhs.bytes2HexStr((byte[])localObject3);
        int i3 = paramCustomFace.uint32_origin.get();
        localObject3 = aooh.a.a(paramElem, 0L, 1, false, paramElem, (String)localObject2, "picplatform", str3, str4, str1, str2, i3, 0);
        localObject1 = new RichMsg.PicRec();
        ((RichMsg.PicRec)localObject1).localPath.set(paramElem);
        ((RichMsg.PicRec)localObject1).size.set(l2);
        ((RichMsg.PicRec)localObject1).type.set(1);
        ((RichMsg.PicRec)localObject1).isRead.set(false);
        ((RichMsg.PicRec)localObject1).uuid.set(paramElem);
        ((RichMsg.PicRec)localObject1).groupFileID.set(l1 & 0xFFFFFFFF);
        if (localObject2 != null) {
          ((RichMsg.PicRec)localObject1).md5.set((String)localObject2);
        }
        ((RichMsg.PicRec)localObject1).serverStorageSource.set("picplatform");
        ((RichMsg.PicRec)localObject1).thumbMsgUrl.set(str3);
        ((RichMsg.PicRec)localObject1).bigthumbMsgUrl.set(str4);
        ((RichMsg.PicRec)localObject1).uint32_thumb_width.set(m);
        ((RichMsg.PicRec)localObject1).uint32_thumb_height.set(n);
        ((RichMsg.PicRec)localObject1).uint32_width.set(i1);
        ((RichMsg.PicRec)localObject1).uint32_height.set(i2);
        ((RichMsg.PicRec)localObject1).bigMsgUrl.set(str1);
        ((RichMsg.PicRec)localObject1).rawMsgUrl.set(str2);
        ((RichMsg.PicRec)localObject1).fileSizeFlag.set(0);
        ((RichMsg.PicRec)localObject1).uiOperatorFlag.set(0);
        ((RichMsg.PicRec)localObject1).version.set(5);
        ((RichMsg.PicRec)localObject1).isReport.set(0);
        ((RichMsg.PicRec)localObject1).fileSizeFlag.set(i3);
        if (i3 == 1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("DecodeMsg", 2, "[customFace] showLen =" + j + ",downloadLen = " + i + ",raw photo msg,clear progressjpg info!");
          }
          j = 0;
          i = 0;
        }
        for (;;)
        {
          ((RichMsg.PicRec)localObject1).uint32_show_len.set(j);
          ((RichMsg.PicRec)localObject1).uint32_download_len.set(i);
          ((RichMsg.PicRec)localObject1).enableEnc.set(true);
          ((RichMsg.PicRec)localObject1).uint32_image_type.set(k);
          if (QLog.isColorLevel()) {
            paramStringBuilder.append("protocolStr:").append((String)localObject3).append("\n");
          }
          if (paramCustomFace.bytes_pb_reserve.has()) {
            ((RichMsg.PicRec)localObject1).bytes_pb_reserved.set(paramCustomFace.bytes_pb_reserve.get());
          }
          i = 0;
          if (paramCustomFace.bytes_pb_reserve.has()) {
            paramStringBuilder = new CustomFaceExtPb.ResvAttr();
          }
          for (;;)
          {
            try
            {
              paramStringBuilder.mergeFrom(paramCustomFace.bytes_pb_reserve.get().toByteArray());
              if (paramStringBuilder.msg_image_show.has())
              {
                paramElem = (MessageForPic)anbi.d(-5015);
                paramElem.msgtype = -5015;
                ((MessageForTroopEffectPic)paramElem).effectId = ((CustomFaceExtPb.AnimationImageShow)paramStringBuilder.msg_image_show.get()).int32_effect_id.get();
                paramElem.frienduin = String.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).group_info.group_code.get());
                paramElem.istroop = 1;
                paramCustomFace = (apqk)this.app.getManager(223);
                if (paramCustomFace != null) {
                  paramCustomFace.a((apqk.c)paramElem, false);
                }
                i = 1;
                if (i == 0)
                {
                  paramElem = (MessageForPic)anbi.d(-2000);
                  paramElem.msgtype = -2000;
                }
                if (bool1) {
                  acfx.d(paramElem, false);
                }
                if (bool2) {
                  acei.d(paramElem, false);
                }
                if (paramaozx != null) {
                  paramElem.istroop = paramaozx.uinType;
                }
                paramElem.msgData = ((RichMsg.PicRec)localObject1).toByteArray();
                paramElem.parse();
                paramList.add(paramElem);
                localStringBuilder.delete(0, localStringBuilder.length());
                return;
              }
            }
            catch (InvalidProtocolBufferMicroException paramElem)
            {
              paramElem.printStackTrace();
              continue;
            }
            paramElem = null;
          }
        }
      }
    }
  }
  
  public boolean a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg)
  {
    Iterator localIterator = paramList.iterator();
    paramList = null;
    Object localObject1 = null;
    Object localObject3;
    if (localIterator.hasNext())
    {
      localObject3 = (im_msg_body.Elem)localIterator.next();
      if (!((im_msg_body.Elem)localObject3).deliver_gift_msg.has()) {}
    }
    for (Object localObject2 = localObject3;; localObject2 = null)
    {
      if (localObject2 == null)
      {
        return false;
        localObject2 = localObject1;
        if (((im_msg_body.Elem)localObject3).pub_group.has()) {
          localObject2 = ((im_msg_body.Elem)localObject3).pub_group.bytes_nickname.get().toStringUtf8();
        }
        localObject1 = localObject2;
        if (!((im_msg_body.Elem)localObject3).text.has()) {
          break;
        }
        localObject3 = ((im_msg_body.Text)((im_msg_body.Elem)localObject3).text.get()).str.get().toStringUtf8();
        localObject1 = localObject2;
        if (localObject3 == null) {
          break;
        }
        localObject1 = localObject2;
        if (!((String)localObject3).startsWith("@")) {
          break;
        }
        paramList = ((String)localObject3).substring(1);
        localObject1 = localObject2;
        break;
      }
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("elemType:GiftMsg;\n");
      }
      paramList = a(localObject1, paramList, ((im_msg_body.Elem)localObject2).deliver_gift_msg, paramList1, paramStringBuilder, paramMsg);
      paramList1 = new Intent("tencent.video.q2v.VideoSendGift");
      paramList1.putExtra("data", ((im_msg_body.Elem)localObject2).deliver_gift_msg.toByteArray());
      paramList1.putExtra("troopUin", paramList.grayTipsEntity.troopUin);
      paramList1.putExtra("shmsgSeq", paramMsg.msg_head.msg_seq.get());
      paramList1.putExtra("senderName", paramList.senderName);
      paramList1.putExtra("rcvName", paramList.rcvName);
      this.app.getApp().sendBroadcast(paramList1);
      return true;
    }
  }
  
  public boolean a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, String paramString)
  {
    Object localObject1 = null;
    Iterator localIterator = paramList.iterator();
    String str1 = null;
    paramList = null;
    im_msg_body.Elem localElem;
    if (localIterator.hasNext())
    {
      localElem = (im_msg_body.Elem)localIterator.next();
      if (!localElem.pub_group.has()) {
        break label264;
      }
      str1 = localElem.pub_group.bytes_nickname.get().toStringUtf8();
    }
    label264:
    for (;;)
    {
      Object localObject2 = localObject1;
      if (localElem.text.has())
      {
        String str2 = ((im_msg_body.Text)localElem.text.get()).str.get().toStringUtf8();
        localObject2 = localObject1;
        if (str2 != null)
        {
          localObject2 = localObject1;
          if (str2.startsWith("@")) {
            localObject2 = str2.substring(1);
          }
        }
      }
      if (localElem.common_elem.has()) {
        paramList = localElem.common_elem;
      }
      for (;;)
      {
        localObject1 = localObject2;
        break;
        if (paramList == null) {
          return false;
        }
        localObject2 = new hummer_commelem.MsgElemInfo_servtype8();
        try
        {
          ((hummer_commelem.MsgElemInfo_servtype8)localObject2).mergeFrom(paramList.bytes_pb_elem.get().toByteArray());
          if (QLog.isColorLevel()) {
            paramStringBuilder.append("elemType:GiftMsg;\n");
          }
          paramList = a(str1, localObject1, ((hummer_commelem.MsgElemInfo_servtype8)localObject2).wifi_deliver_gift_msg, paramList1, paramStringBuilder, paramMsg);
          paramList.frienduin = paramString;
          paramList.isFromNearby = true;
          paramList1 = (apqk)this.app.getManager(223);
          if (paramList1 != null) {
            paramList1.b(paramList);
          }
          return true;
        }
        catch (InvalidProtocolBufferMicroException paramList)
        {
          return false;
        }
      }
    }
  }
  
  public void b(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("DecodeMsg", 2, "lightvideo msg decode failed");
      }
      return;
    }
    Object localObject = null;
    Iterator localIterator = paramList.iterator();
    paramList = (List<im_msg_body.Elem>)localObject;
    label43:
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (im_msg_body.Elem)localIterator.next();
    } while ((!((im_msg_body.Elem)localObject).common_elem.has()) || (((im_msg_body.Elem)localObject).common_elem.uint32_service_type.get() != 27) || (!((im_msg_body.Elem)localObject).common_elem.bytes_pb_elem.has()));
    label639:
    for (;;)
    {
      try
      {
        hummer_commelem.MsgElemInfo_servtype27 localMsgElemInfo_servtype27 = new hummer_commelem.MsgElemInfo_servtype27();
        localMsgElemInfo_servtype27.mergeFrom(((im_msg_body.Elem)localObject).common_elem.bytes_pb_elem.get().toByteArray());
        if ((localMsgElemInfo_servtype27 == null) || (!localMsgElemInfo_servtype27.video_file.has())) {
          break label639;
        }
        localObject = (im_msg_body.VideoFile)localMsgElemInfo_servtype27.video_file.get();
        paramList = (List<im_msg_body.Elem>)localObject;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
      break label43;
      if (paramList == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("DecodeMsg", 2, "lightvideo msg decode failed, videoFile is null");
        return;
      }
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("elemType:light_video;\n");
      }
      RichMsg.VideoFile localVideoFile = new RichMsg.VideoFile();
      localVideoFile.setHasFlag(true);
      localVideoFile.bytes_file_name.set(paramList.bytes_file_name.get());
      localVideoFile.bytes_file_md5.set(paramList.bytes_file_md5.get());
      localVideoFile.bytes_file_uuid.set(paramList.bytes_file_uuid.get());
      localVideoFile.uint32_file_format.set(paramList.uint32_file_format.get());
      localVideoFile.uint32_file_size.set(paramList.uint32_file_size.get());
      localVideoFile.uint32_file_time.set(paramList.uint32_file_time.get());
      localVideoFile.uint32_thumb_width.set(paramList.uint32_thumb_width.get());
      localVideoFile.uint32_thumb_height.set(paramList.uint32_thumb_height.get());
      localVideoFile.uint32_file_status.set(2008);
      localVideoFile.uint32_file_progress.set(0);
      localVideoFile.bytes_thumb_file_md5.set(paramList.bytes_thumb_file_md5.get());
      localVideoFile.bytes_source.set(paramList.bytes_source.get());
      localVideoFile.uint32_thumb_file_size.set(paramList.uint32_thumb_file_size.get());
      localVideoFile.uint32_busi_type.set(paramList.uint32_busi_type.get());
      localVideoFile.uin32_from_chat_type.set(paramList.uint32_from_chat_type.get());
      localVideoFile.uin32_to_chat_type.set(paramList.uint32_to_chat_type.get());
      localVideoFile.bool_support_progressive.set(paramList.bool_support_progressive.get());
      localVideoFile.uint32_file_width.set(paramList.uint32_file_width.get());
      localVideoFile.uint32_file_height.set(paramList.uint32_file_height.get());
      localVideoFile.uint32_sub_busi_type.set(paramList.uint32_sub_busi_type.get());
      localVideoFile.uint32_video_attr.set(paramList.uint32_video_attr.get());
      paramList = (MessageForLightVideo)anbi.d(-2071);
      paramList.msgtype = -2071;
      paramList.msgData = localVideoFile.toByteArray();
      paramList.msg = BaseApplication.getContext().getString(2131692312);
      paramList.parse();
      paramList1.add(paramList);
      if (!QLog.isColorLevel()) {
        break;
      }
      paramStringBuilder.append("LightVideo.msg: ").append(paramList.toString() + "\n" + paramList.toLogString()).append("\n");
      return;
    }
  }
  
  public void b(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg)
  {
    Object localObject = null;
    Iterator localIterator = paramList.iterator();
    do
    {
      paramList = (List<im_msg_body.Elem>)localObject;
      if (!localIterator.hasNext()) {
        break;
      }
      paramList = (im_msg_body.Elem)localIterator.next();
    } while (!paramList.group_file.has());
    paramList = (im_msg_body.GroupFile)paramList.group_file.get();
    if (paramList == null) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("elemType:GroupFile;\n");
      }
      long l1 = 0L;
      paramStringBuilder = (msg_comm.MsgHead)paramMsg.msg_head.get();
      if (paramStringBuilder.discuss_info.has()) {
        l1 = ((msg_comm.DiscussInfo)paramStringBuilder.discuss_info.get()).discuss_uin.get();
      }
      long l4 = paramStringBuilder.from_uin.get();
      long l6 = paramStringBuilder.msg_time.get();
      long l7 = paramStringBuilder.msg_seq.get();
      long l5 = this.c.app.getLongAccountUin();
      if (achp.a(this.c.app, 3000, String.valueOf(l1), String.valueOf(l4), l6, l7)) {
        continue;
      }
      paramStringBuilder = "";
      try
      {
        localObject = new String(paramList.bytes_filename.get().toByteArray(), "UTF-8");
        paramStringBuilder = (StringBuilder)localObject;
        long l3 = 0L;
        l2 = l3;
        if (paramMsg.msg_body.has())
        {
          paramMsg = (im_msg_body.MsgBody)paramMsg.msg_body.get();
          l2 = l3;
          if (paramMsg.rich_text.attr.has()) {
            l2 = anbk.I(((im_msg_body.Attr)paramMsg.rich_text.attr.get()).random.get());
          }
        }
        paramMsg = (MessageForFile)anbi.d(-2005);
        paramMsg.msgtype = -2005;
        k = 0;
        m = 0;
        j = m;
        i = k;
        if (paramList.bytes_pb_reserve.has()) {
          localObject = new hummer_resv_21.ResvAttr();
        }
      }
      catch (UnsupportedEncodingException localInvalidProtocolBufferMicroException)
      {
        try
        {
          long l2;
          int k;
          int m;
          ((hummer_resv_21.ResvAttr)localObject).mergeFrom(paramList.bytes_pb_reserve.get().toByteArray());
          int j = m;
          int i = k;
          if (((hummer_resv_21.ResvAttr)localObject).file_image_info.has())
          {
            i = ((hummer_resv_21.ResvAttr)localObject).file_image_info.uint32_file_height.get();
            j = ((hummer_resv_21.ResvAttr)localObject).file_image_info.uint32_file_width.get();
            paramMsg.saveExtInfoToExtStr("file_pic_width", String.valueOf(j));
            paramMsg.saveExtInfoToExtStr("file_pic_heigth", String.valueOf(i));
          }
          paramMsg.uniseq = this.c.app.a().b(paramMsg.uniseq, l1, l4, l7, l2, l6, paramList, j, i);
          l1 = paramList.uint64_file_size.get();
          if (l4 == l5)
          {
            bool = true;
            paramMsg.msg = aoon.a(paramStringBuilder, l1, 0, bool);
            paramMsg.doParse();
          }
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          try
          {
            for (;;)
            {
              paramMsg.fileName = ahav.getFileName(new String(paramList.bytes_filename.get().toByteArray(), "UTF-8"));
              paramList1.add(paramMsg);
              ((aocq)this.app.getManager(272)).Z(paramMsg);
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("DecodeMsg", 2, "GroupDiscFile.msg: " + paramList.bytes_filename.get() + ";");
              return;
              localUnsupportedEncodingException = localUnsupportedEncodingException;
              localUnsupportedEncodingException.printStackTrace();
              continue;
              localInvalidProtocolBufferMicroException = localInvalidProtocolBufferMicroException;
              localInvalidProtocolBufferMicroException.printStackTrace();
            }
            boolean bool = false;
          }
          catch (UnsupportedEncodingException paramStringBuilder)
          {
            for (;;)
            {
              paramStringBuilder.printStackTrace();
              QLog.e("DecodeMsg", 1, "internalDiscOfflineFile: Exception is " + paramStringBuilder.toString());
            }
          }
        }
      }
    }
  }
  
  public void b(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, aozx paramaozx)
  {
    int j = 0;
    Object localObject1 = null;
    Object localObject2 = paramList.iterator();
    Object localObject3;
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (im_msg_body.Elem)((Iterator)localObject2).next();
      if (!((im_msg_body.Elem)localObject3).common_elem.has()) {
        break label872;
      }
      localObject1 = (im_msg_body.CommonElem)((im_msg_body.Elem)localObject3).common_elem.get();
    }
    label572:
    label589:
    label872:
    for (;;)
    {
      break;
      localObject3 = O(paramList);
      if (QLog.isColorLevel()) {
        QLog.d("DecodeMsg", 2, "decodePBMsgElems_FlashChat  common_lem" + localObject1 + ", text " + (String)localObject3);
      }
      if (localObject1 == null) {
        return;
      }
      if (((im_msg_body.CommonElem)localObject1).uint32_business_type.has()) {}
      for (int i = ((im_msg_body.CommonElem)localObject1).uint32_business_type.get();; i = 0)
      {
        localObject2 = new hummer_commelem.MsgElemInfo_servtype14();
        try
        {
          ((hummer_commelem.MsgElemInfo_servtype14)localObject2).mergeFrom(((im_msg_body.CommonElem)localObject1).bytes_pb_elem.get().toByteArray());
          if (i != 0) {
            break label589;
          }
          if (!((FlashChatManager)this.app.getManager(217)).amX())
          {
            g(paramList, paramList1, paramStringBuilder, paramMsg, paramaozx);
            return;
          }
        }
        catch (InvalidProtocolBufferMicroException paramList)
        {
          paramList.printStackTrace();
          return;
        }
        if (!ArkUtil.isDeviceSupportArkMsg())
        {
          QLog.i("FlashChat", 1, "decodePBMsgElems_FlashChat is false, ignore msg.");
          return;
        }
        if ((!((hummer_commelem.MsgElemInfo_servtype14)localObject2).uint32_id.has()) || (!((hummer_commelem.MsgElemInfo_servtype14)localObject2).reserve_Info.has())) {
          break;
        }
        int k = ((hummer_commelem.MsgElemInfo_servtype14)localObject2).uint32_id.get();
        String str = ((hummer_commelem.MsgElemInfo_servtype14)localObject2).reserve_Info.get().toStringUtf8();
        if (!((hummer_commelem.MsgElemInfo_servtype14)localObject2).reserve_Info.has())
        {
          QLog.i("flashchat", 1, "ecodePBMsgElems_FlashChat, reserve_Info not exist.");
          return;
        }
        localObject2 = ((hummer_commelem.MsgElemInfo_servtype14)localObject2).reserve_Info.get().toByteArray();
        if ((localObject2 == null) || (localObject2.length <= 0))
        {
          QLog.i("flashchat", 1, "decodePBMsgElems_FlashChat, reserve_Info empty.");
          return;
        }
        localObject1 = null;
        localObject2 = ansi.d((byte[])localObject2, -1);
        if (localObject2 != null)
        {
          i = localObject2.length;
          if (i > 0)
          {
            try
            {
              localObject2 = new String((byte[])localObject2, "UTF-8");
              localObject1 = localObject2;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                label372:
                QLog.i("flashchat", 1, "decodePBMsgElems_FlashChat convert failed");
              }
            }
            localObject2 = new ArkFlashChatMessage();
            ((ArkFlashChatMessage)localObject2).fromAppXml((String)localObject1);
            ((ArkFlashChatMessage)localObject2).appResId = k;
            ((ArkFlashChatMessage)localObject2).promptText = ((String)localObject3);
            localObject3 = (MessageForArkFlashChat)anbi.d(-5013);
            ((MessageForArkFlashChat)localObject3).msgtype = -5013;
            ((MessageForArkFlashChat)localObject3).msgData = ((ArkFlashChatMessage)localObject2).toBytes();
            ((MessageForArkFlashChat)localObject3).parse();
            if ((TextUtils.isEmpty(((MessageForArkFlashChat)localObject3).ark_app_message.appName)) || (TextUtils.isEmpty(((MessageForArkFlashChat)localObject3).ark_app_message.appView))) {
              break label572;
            }
            paramList1.add(localObject3);
          }
        }
        for (i = 1;; i = j)
        {
          QLog.d("flashchat", 2, "decodePBMsgElems_FlashChat id = " + k + ", reserveInfo = " + str + ", arkData = " + (String)localObject1);
          if (i != 0) {
            break;
          }
          g(paramList, paramList1, paramStringBuilder, paramMsg, paramaozx);
          return;
          QLog.i("flashchat", 1, "decodePBMsgElems_FlashChat empty.");
          break label372;
          QLog.i("flashchat", 1, "decodePBMsgElems_FlashChat not valid..");
        }
        if ((i != 1) || (!localException.uint32_id.has())) {
          break;
        }
        i = localException.uint32_id.get();
        if (localException.reserve_Info.has())
        {
          paramList = localException.reserve_Info.get().toByteArray();
          paramStringBuilder = new hiboom_type.Hiboom_Type();
          paramStringBuilder.mergeFrom(paramList);
          if (paramStringBuilder.uint32_hiboom_type.has())
          {
            j = paramStringBuilder.uint32_hiboom_type.get();
            if (ahxs.jZ(j))
            {
              paramStringBuilder = new HiBoomMessage();
              paramStringBuilder.id = i;
              paramStringBuilder.text = ((String)localObject3);
              paramStringBuilder.type = j;
              paramList = (MessageForHiBoom)anbi.d(-5014);
              paramList.mHiBoomMessage = paramStringBuilder;
              paramList.msgtype = -5014;
              paramList.msg = ((String)localObject3);
              try
              {
                paramList.msgData = aczw.b(paramStringBuilder);
                if (QLog.isColorLevel()) {
                  QLog.d("HiBoomFont.MessagePBElemDecoder", 2, "receive hiboom message id = " + i + "message = " + ((String)localObject3).charAt(0));
                }
                paramList1.add(paramList);
                return;
              }
              catch (Exception paramStringBuilder)
              {
                for (;;)
                {
                  QLog.e("HiBoomFont.MessagePBElemDecoder", 1, "getBytesFromObject error, ", paramStringBuilder);
                }
              }
            }
            QLog.i("HiBoomFont", 1, "decodePBMsgElems_Hiboom type not support: type = " + j);
            return;
          }
          QLog.i("HiBoomFont", 1, "decodePBMsgElems_Hiboom no type");
          return;
        }
        QLog.i("HiBoomFont", 1, "decodePBMsgElems_Hiboom no reserve_info");
        return;
      }
    }
  }
  
  public void b(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, boolean paramBoolean)
  {
    paramList = paramList.iterator();
    Object localObject;
    do
    {
      if (!paramList.hasNext()) {
        break;
      }
      localObject = (im_msg_body.Elem)paramList.next();
    } while (!((im_msg_body.Elem)localObject).common_elem.has());
    for (paramList = (im_msg_body.CommonElem)((im_msg_body.Elem)localObject).common_elem.get();; paramList = null)
    {
      if (paramList == null) {}
      do
      {
        for (;;)
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("flash", 2, "decodePBMsgElems_FlashPicCommen isC2C=" + paramBoolean);
          }
          if (QLog.isColorLevel()) {
            paramStringBuilder.append("ELEM_FlashPicCommen;\n");
          }
          localObject = new hummer_commelem.MsgElemInfo_servtype3();
          try
          {
            ((hummer_commelem.MsgElemInfo_servtype3)localObject).mergeFrom(paramList.bytes_pb_elem.get().toByteArray());
            if (!paramBoolean)
            {
              if (!((hummer_commelem.MsgElemInfo_servtype3)localObject).flash_troop_pic.has()) {
                continue;
              }
              a(null, (im_msg_body.CustomFace)((hummer_commelem.MsgElemInfo_servtype3)localObject).flash_troop_pic.get(), paramList1, paramStringBuilder, paramMsg, paramBoolean);
            }
          }
          catch (InvalidProtocolBufferMicroException paramList)
          {
            paramList.printStackTrace();
            return;
          }
        }
      } while (!((hummer_commelem.MsgElemInfo_servtype3)localObject).flash_c2c_pic.has());
      a(null, (im_msg_body.NotOnlineImage)((hummer_commelem.MsgElemInfo_servtype3)localObject).flash_c2c_pic.get(), paramList1, paramStringBuilder, paramMsg);
      return;
    }
  }
  
  public void b(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    int i = 0;
    if (i < paramList.size()) {
      if (!((im_msg_body.Elem)paramList.get(i)).apollo_msg.has()) {}
    }
    for (im_msg_body.ApolloActMsg localApolloActMsg = (im_msg_body.ApolloActMsg)((im_msg_body.Elem)paramList.get(i)).apollo_msg.get();; localApolloActMsg = null)
    {
      if (localApolloActMsg == null) {}
      do
      {
        return;
        i += 1;
        break;
        if (QLog.isColorLevel()) {
          paramStringBuilder.append("elemType:Apollo...\n");
        }
      } while (localApolloActMsg == null);
      for (;;)
      {
        int i5;
        float f2;
        int i3;
        int i4;
        int i7;
        long l1;
        int i6;
        ApolloMsgExtend.ThreeDBaseInfo localThreeDBaseInfo;
        List localList;
        Apollo3DMessage localApollo3DMessage;
        ApolloMsgExtend.AuthReserve localAuthReserve;
        long l4;
        try
        {
          ApolloMessage localApolloMessage = new ApolloMessage();
          localApolloMessage.id = localApolloActMsg.uint32_action_id.get();
          localApolloMessage.name = localApolloActMsg.bytes_action_name.get().toByteArray();
          if ((!paramBoolean) && (localApolloActMsg.bytes_action_text.has())) {
            localApolloMessage.text = localApolloActMsg.bytes_action_text.get().toByteArray();
          }
          i5 = -1;
          f2 = 0.0F;
          long l5 = 0L;
          i3 = -1;
          i4 = 0;
          i = 0;
          i7 = 0;
          l1 = 0L;
          ArrayList localArrayList = new ArrayList();
          Object localObject5 = null;
          paramStringBuilder = null;
          j = 0;
          i6 = 0;
          localObject1 = null;
          localThreeDBaseInfo = null;
          Iterator localIterator = null;
          localList = null;
          localApollo3DMessage = new Apollo3DMessage();
          localAuthReserve = new ApolloMsgExtend.AuthReserve();
          localObject4 = localIterator;
          localObject3 = localThreeDBaseInfo;
          i1 = i6;
          localObject2 = localObject5;
          n = i7;
          l2 = l1;
          m = i4;
          k = i3;
          l3 = l5;
          f1 = f2;
          i2 = i5;
          try
          {
            localAuthReserve.mergeFrom(localApolloActMsg.bytes_pb_reserve.get().toByteArray());
            localObject4 = localIterator;
            localObject3 = localThreeDBaseInfo;
            i1 = i6;
            localObject2 = localObject5;
            n = i7;
            l2 = l1;
            m = i4;
            k = i3;
            l3 = l5;
            f1 = f2;
            i2 = i5;
            i5 = localAuthReserve.diy_voice_id.get();
            localObject4 = localIterator;
            localObject3 = localThreeDBaseInfo;
            i1 = i6;
            localObject2 = localObject5;
            n = i7;
            l2 = l1;
            m = i4;
            k = i3;
            l3 = l5;
            f1 = f2;
            i2 = i5;
            f2 = (float)localAuthReserve.diy_voice_begin_ts.get();
            f1 = 1000.0F;
            localObject4 = localIterator;
            localObject3 = localThreeDBaseInfo;
            i1 = i6;
            localObject2 = localObject5;
            n = i7;
            l2 = l1;
            m = i4;
            k = i3;
            l3 = l5;
            i2 = i5;
            f2 /= 1000.0F;
            localObject4 = localIterator;
            localObject3 = localThreeDBaseInfo;
            i1 = i6;
            localObject2 = localObject5;
            n = i7;
            l2 = l1;
            m = i4;
            k = i3;
            l3 = l5;
            f1 = f2;
            i2 = i5;
            i3 = localAuthReserve.sub_type.get();
            localObject4 = localIterator;
            localObject3 = localThreeDBaseInfo;
            i1 = i6;
            localObject2 = localObject5;
            n = i7;
            l2 = l1;
            m = i4;
            k = i3;
            l3 = l5;
            f1 = f2;
            i2 = i5;
            i4 = localAuthReserve.game_id.get();
            localObject4 = localIterator;
            localObject3 = localThreeDBaseInfo;
            i1 = i6;
            localObject2 = localObject5;
            n = i7;
            l2 = l1;
            m = i4;
            k = i3;
            l3 = l5;
            f1 = f2;
            i2 = i5;
            l4 = localAuthReserve.room_id.get();
            localObject4 = localIterator;
            localObject3 = localThreeDBaseInfo;
            i1 = i6;
            localObject2 = localObject5;
            n = i7;
            l2 = l4;
            m = i4;
            k = i3;
            l3 = l5;
            f1 = f2;
            i2 = i5;
            localAuthReserve.img_type.get();
            localObject4 = localIterator;
            localObject3 = localThreeDBaseInfo;
            i1 = i6;
            localObject2 = localObject5;
            n = i7;
            l2 = l4;
            m = i4;
            k = i3;
            l3 = l5;
            f1 = f2;
            i2 = i5;
            if (localAuthReserve.game_text.has())
            {
              localObject4 = localIterator;
              localObject3 = localThreeDBaseInfo;
              i1 = i6;
              localObject2 = localObject5;
              n = i7;
              l2 = l4;
              m = i4;
              k = i3;
              l3 = l5;
              f1 = f2;
              i2 = i5;
              if (localAuthReserve.game_text.get() != null)
              {
                localObject4 = localIterator;
                localObject3 = localThreeDBaseInfo;
                i1 = i6;
                localObject2 = localObject5;
                n = i7;
                l2 = l4;
                m = i4;
                k = i3;
                l3 = l5;
                f1 = f2;
                i2 = i5;
                new String(localAuthReserve.game_text.get().toByteArray());
              }
            }
            paramList = paramStringBuilder;
            localObject4 = localIterator;
            localObject3 = localThreeDBaseInfo;
            i1 = i6;
            localObject2 = localObject5;
            n = i7;
            l2 = l4;
            m = i4;
            k = i3;
            l3 = l5;
            f1 = f2;
            i2 = i5;
            if (localAuthReserve.game_name.has())
            {
              paramList = paramStringBuilder;
              localObject4 = localIterator;
              localObject3 = localThreeDBaseInfo;
              i1 = i6;
              localObject2 = localObject5;
              n = i7;
              l2 = l4;
              m = i4;
              k = i3;
              l3 = l5;
              f1 = f2;
              i2 = i5;
              if (localAuthReserve.game_name.get() != null)
              {
                localObject4 = localIterator;
                localObject3 = localThreeDBaseInfo;
                i1 = i6;
                localObject2 = localObject5;
                n = i7;
                l2 = l4;
                m = i4;
                k = i3;
                l3 = l5;
                f1 = f2;
                i2 = i5;
                paramList = new String(localAuthReserve.game_name.get().toByteArray());
              }
            }
            paramStringBuilder = localList;
            localObject4 = localIterator;
            localObject3 = localThreeDBaseInfo;
            i1 = i6;
            localObject2 = paramList;
            n = i7;
            l2 = l4;
            m = i4;
            k = i3;
            l3 = l5;
            f1 = f2;
            i2 = i5;
            if (localAuthReserve.game_share_ark_json.has())
            {
              paramStringBuilder = localList;
              localObject4 = localIterator;
              localObject3 = localThreeDBaseInfo;
              i1 = i6;
              localObject2 = paramList;
              n = i7;
              l2 = l4;
              m = i4;
              k = i3;
              l3 = l5;
              f1 = f2;
              i2 = i5;
              if (localAuthReserve.game_share_ark_json.get() != null)
              {
                localObject4 = localIterator;
                localObject3 = localThreeDBaseInfo;
                i1 = i6;
                localObject2 = paramList;
                n = i7;
                l2 = l4;
                m = i4;
                k = i3;
                l3 = l5;
                f1 = f2;
                i2 = i5;
                paramStringBuilder = new String(localAuthReserve.game_share_ark_json.get().toByteArray());
              }
            }
            l1 = l5;
            localObject4 = paramStringBuilder;
            localObject3 = localThreeDBaseInfo;
            i1 = i6;
            localObject2 = paramList;
            n = i7;
            l2 = l4;
            m = i4;
            k = i3;
            l3 = l5;
            f1 = f2;
            i2 = i5;
            if (localAuthReserve.sign_ts.has())
            {
              localObject4 = paramStringBuilder;
              localObject3 = localThreeDBaseInfo;
              i1 = i6;
              localObject2 = paramList;
              n = i7;
              l2 = l4;
              m = i4;
              k = i3;
              l3 = l5;
              f1 = f2;
              i2 = i5;
              l1 = localAuthReserve.sign_ts.get();
            }
            localObject4 = paramStringBuilder;
            localObject3 = localThreeDBaseInfo;
            i1 = i6;
            localObject2 = paramList;
            n = i7;
            l2 = l4;
            m = i4;
            k = i3;
            l3 = l1;
            f1 = f2;
            i2 = i5;
            if (localAuthReserve.action_ver.has())
            {
              localObject4 = paramStringBuilder;
              localObject3 = localThreeDBaseInfo;
              i1 = i6;
              localObject2 = paramList;
              n = i7;
              l2 = l4;
              m = i4;
              k = i3;
              l3 = l1;
              f1 = f2;
              i2 = i5;
              l5 = localAuthReserve.action_ver.get();
              if (l5 != 0L)
              {
                localObject4 = paramStringBuilder;
                localObject3 = localThreeDBaseInfo;
                i1 = i6;
                localObject2 = paramList;
                n = i7;
                l2 = l4;
                m = i4;
                k = i3;
                l3 = l1;
                f1 = f2;
                i2 = i5;
                if (l5 > ApolloUtil.gh(1))
                {
                  localObject4 = paramStringBuilder;
                  localObject3 = localThreeDBaseInfo;
                  i1 = i6;
                  localObject2 = paramList;
                  n = i7;
                  l2 = l4;
                  m = i4;
                  k = i3;
                  l3 = l1;
                  f1 = f2;
                  i2 = i5;
                  aczo.r(this.app, 1);
                }
              }
            }
            localObject4 = paramStringBuilder;
            localObject3 = localThreeDBaseInfo;
            i1 = i6;
            localObject2 = paramList;
            n = i7;
            l2 = l4;
            m = i4;
            k = i3;
            l3 = l1;
            f1 = f2;
            i2 = i5;
            if (localAuthReserve.slave_action_id.has())
            {
              localObject4 = paramStringBuilder;
              localObject3 = localThreeDBaseInfo;
              i1 = i6;
              localObject2 = paramList;
              n = i7;
              l2 = l4;
              m = i4;
              k = i3;
              l3 = l1;
              f1 = f2;
              i2 = i5;
              localAuthReserve.slave_action_id.get();
            }
            localObject4 = paramStringBuilder;
            localObject3 = localThreeDBaseInfo;
            i1 = i6;
            localObject2 = paramList;
            n = i7;
            l2 = l4;
            m = i4;
            k = i3;
            l3 = l1;
            f1 = f2;
            i2 = i5;
            if (!localAuthReserve.slave_uin_list.has()) {
              break label2527;
            }
            localObject4 = paramStringBuilder;
            localObject3 = localThreeDBaseInfo;
            i1 = i6;
            localObject2 = paramList;
            n = i7;
            l2 = l4;
            m = i4;
            k = i3;
            l3 = l1;
            f1 = f2;
            i2 = i5;
            localList = localAuthReserve.slave_uin_list.get();
            if (localList == null) {
              break label2527;
            }
            localObject4 = paramStringBuilder;
            localObject3 = localThreeDBaseInfo;
            i1 = i6;
            localObject2 = paramList;
            n = i7;
            l2 = l4;
            m = i4;
            k = i3;
            l3 = l1;
            f1 = f2;
            i2 = i5;
            localIterator = localList.iterator();
            localObject4 = paramStringBuilder;
            localObject3 = localThreeDBaseInfo;
            i1 = i6;
            localObject2 = paramList;
            n = i7;
            l2 = l4;
            m = i4;
            k = i3;
            l3 = l1;
            f1 = f2;
            i2 = i5;
            if (!localIterator.hasNext()) {
              break label2405;
            }
            localObject4 = paramStringBuilder;
            localObject3 = localThreeDBaseInfo;
            i1 = i6;
            localObject2 = paramList;
            n = i7;
            l2 = l4;
            m = i4;
            k = i3;
            l3 = l1;
            f1 = f2;
            i2 = i5;
            localArrayList.add(Long.valueOf(aqft.K(((Integer)localIterator.next()).intValue())));
            continue;
            localObject3 = new JSONObject();
          }
          catch (InvalidProtocolBufferMicroException paramList)
          {
            paramList.printStackTrace();
            paramList = (List<im_msg_body.Elem>)localObject4;
            paramStringBuilder = (StringBuilder)localObject3;
            localObject1 = localObject2;
            i = m;
            j = k;
            l1 = l3;
          }
          if (!localApolloActMsg.input_text.has()) {
            break label3553;
          }
          localObject2 = new String(localApolloActMsg.input_text.get().toByteArray());
          ((JSONObject)localObject3).put("inputText", localObject2);
          if (i2 > 0)
          {
            ((JSONObject)localObject3).put("audioID", i2);
            ((JSONObject)localObject3).put("audioStartTime", f1);
          }
          if (ApolloGameUtil.ib(j))
          {
            ((JSONObject)localObject3).put("gameId", i);
            ((JSONObject)localObject3).put("gameMode", n);
            ((JSONObject)localObject3).put("roomid", l2);
            ((JSONObject)localObject3).put("msgTyep", j);
            ((JSONObject)localObject3).put("gameName", localObject1);
            ((JSONObject)localObject3).put("gameExtendJson", paramList);
          }
          if (!TextUtils.isEmpty(paramStringBuilder)) {
            ((JSONObject)localObject3).put("extendJson", paramStringBuilder);
          }
          ((JSONObject)localObject3).put("actionType", i1);
          localObject4 = localApollo3DMessage.getMessageJSONObject();
          if (localObject4 != null) {
            ((JSONObject)localObject3).put("mApollo3DMessage", localObject4);
          }
          localApolloMessage.extStr = ((JSONObject)localObject3).toString();
          localApolloMessage.flag = localApolloActMsg.uint32_flag.get();
          localApolloMessage.peer_uin = aqft.K(localApolloActMsg.uint32_peer_uin.get());
          localApolloMessage.sender_ts = aqft.K(localApolloActMsg.uint32_sender_ts.get());
          localApolloMessage.peer_ts = aqft.K(localApolloActMsg.uint32_peer_ts.get());
          localApolloMessage.sender_status = localApolloActMsg.int32_sender_status.get();
          localApolloMessage.peer_status = localApolloActMsg.int32_peer_status.get();
          localObject3 = (MessageForApollo)anbi.d(-2039);
          ((MessageForApollo)localObject3).msgtype = -2039;
          ((MessageForApollo)localObject3).mApolloMessage = localApolloMessage;
          ((MessageForApollo)localObject3).msgData = aczw.b(localApolloMessage);
          ((MessageForApollo)localObject3).inputText = ((String)localObject2);
          ((MessageForApollo)localObject3).audioId = i2;
          ((MessageForApollo)localObject3).audioStartTime = f1;
          ((MessageForApollo)localObject3).msgType = j;
          ((MessageForApollo)localObject3).gameId = i;
          ((MessageForApollo)localObject3).mGameMode = n;
          ((MessageForApollo)localObject3).roomId = l2;
          ((MessageForApollo)localObject3).signTs = l1;
          ((MessageForApollo)localObject3).gameName = ((String)localObject1);
          ((MessageForApollo)localObject3).actionType = i1;
          ((MessageForApollo)localObject3).extendJson = paramStringBuilder;
          ((MessageForApollo)localObject3).gameExtendJson = paramList;
          ((MessageForApollo)localObject3).gameStatus = ApolloUtil.z(((MessageForApollo)localObject3).extendJson, "gameStatus");
          ((MessageForApollo)localObject3).mApollo3DMessage = localApollo3DMessage;
          paramList1.add(localObject3);
          return;
        }
        catch (Throwable paramList) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("DecodeMsg", 2, "decode apollo msg failed", paramList);
        return;
        label2405:
        Object localObject4 = paramStringBuilder;
        Object localObject3 = localThreeDBaseInfo;
        int i1 = i6;
        Object localObject2 = paramList;
        int n = i7;
        long l2 = l4;
        int m = i4;
        int k = i3;
        long l3 = l1;
        float f1 = f2;
        int i2 = i5;
        if (QLog.isColorLevel())
        {
          localObject4 = paramStringBuilder;
          localObject3 = localThreeDBaseInfo;
          i1 = i6;
          localObject2 = paramList;
          n = i7;
          l2 = l4;
          m = i4;
          k = i3;
          l3 = l1;
          f1 = f2;
          i2 = i5;
          QLog.d("DecodeMsg", 2, "slave size:" + localList.size());
        }
        label2527:
        localObject4 = paramStringBuilder;
        localObject3 = localThreeDBaseInfo;
        i1 = i6;
        localObject2 = paramList;
        n = i7;
        l2 = l4;
        m = i4;
        k = i3;
        l3 = l1;
        f1 = f2;
        i2 = i5;
        if (localAuthReserve.game_mode.has())
        {
          localObject4 = paramStringBuilder;
          localObject3 = localThreeDBaseInfo;
          i1 = i6;
          localObject2 = paramList;
          n = i7;
          l2 = l4;
          m = i4;
          k = i3;
          l3 = l1;
          f1 = f2;
          i2 = i5;
          i = localAuthReserve.game_mode.get();
        }
        localObject4 = paramStringBuilder;
        localObject3 = localThreeDBaseInfo;
        i1 = i6;
        localObject2 = paramList;
        n = i;
        l2 = l4;
        m = i4;
        k = i3;
        l3 = l1;
        f1 = f2;
        i2 = i5;
        if (localAuthReserve.extend_json.has())
        {
          localObject4 = paramStringBuilder;
          localObject3 = localThreeDBaseInfo;
          i1 = i6;
          localObject2 = paramList;
          n = i;
          l2 = l4;
          m = i4;
          k = i3;
          l3 = l1;
          f1 = f2;
          i2 = i5;
          localObject1 = new String(localAuthReserve.extend_json.get().toByteArray());
        }
        localObject4 = paramStringBuilder;
        localObject3 = localObject1;
        i1 = i6;
        localObject2 = paramList;
        n = i;
        l2 = l4;
        m = i4;
        k = i3;
        l3 = l1;
        f1 = f2;
        i2 = i5;
        if (localAuthReserve.action_type.has())
        {
          localObject4 = paramStringBuilder;
          localObject3 = localObject1;
          i1 = i6;
          localObject2 = paramList;
          n = i;
          l2 = l4;
          m = i4;
          k = i3;
          l3 = l1;
          f1 = f2;
          i2 = i5;
          j = localAuthReserve.action_type.get();
        }
        localObject4 = paramStringBuilder;
        localObject3 = localObject1;
        i1 = j;
        localObject2 = paramList;
        n = i;
        l2 = l4;
        m = i4;
        k = i3;
        l3 = l1;
        f1 = f2;
        i2 = i5;
        if (localAuthReserve.act3d.has())
        {
          localObject4 = paramStringBuilder;
          localObject3 = localObject1;
          i1 = j;
          localObject2 = paramList;
          n = i;
          l2 = l4;
          m = i4;
          k = i3;
          l3 = l1;
          f1 = f2;
          i2 = i5;
          localThreeDBaseInfo = (ApolloMsgExtend.ThreeDBaseInfo)localAuthReserve.act3d.get();
          localObject4 = paramStringBuilder;
          localObject3 = localObject1;
          i1 = j;
          localObject2 = paramList;
          n = i;
          l2 = l4;
          m = i4;
          k = i3;
          l3 = l1;
          f1 = f2;
          i2 = i5;
          if (localThreeDBaseInfo.uint32_action_id.has())
          {
            localObject4 = paramStringBuilder;
            localObject3 = localObject1;
            i1 = j;
            localObject2 = paramList;
            n = i;
            l2 = l4;
            m = i4;
            k = i3;
            l3 = l1;
            f1 = f2;
            i2 = i5;
            localApollo3DMessage.actionID_3D = localThreeDBaseInfo.uint32_action_id.get();
          }
          localObject4 = paramStringBuilder;
          localObject3 = localObject1;
          i1 = j;
          localObject2 = paramList;
          n = i;
          l2 = l4;
          m = i4;
          k = i3;
          l3 = l1;
          f1 = f2;
          i2 = i5;
          if (localThreeDBaseInfo.action_type.has())
          {
            localObject4 = paramStringBuilder;
            localObject3 = localObject1;
            i1 = j;
            localObject2 = paramList;
            n = i;
            l2 = l4;
            m = i4;
            k = i3;
            l3 = l1;
            f1 = f2;
            i2 = i5;
            localApollo3DMessage.actionType_3D = localThreeDBaseInfo.action_type.get();
          }
          localObject4 = paramStringBuilder;
          localObject3 = localObject1;
          i1 = j;
          localObject2 = paramList;
          n = i;
          l2 = l4;
          m = i4;
          k = i3;
          l3 = l1;
          f1 = f2;
          i2 = i5;
          if (localThreeDBaseInfo.bytes_action_name.has())
          {
            localObject4 = paramStringBuilder;
            localObject3 = localObject1;
            i1 = j;
            localObject2 = paramList;
            n = i;
            l2 = l4;
            m = i4;
            k = i3;
            l3 = l1;
            f1 = f2;
            i2 = i5;
            localApollo3DMessage.actionName_3D = new String(localThreeDBaseInfo.bytes_action_name.get().toByteArray());
          }
          localObject4 = paramStringBuilder;
          localObject3 = localObject1;
          i1 = j;
          localObject2 = paramList;
          n = i;
          l2 = l4;
          m = i4;
          k = i3;
          l3 = l1;
          f1 = f2;
          i2 = i5;
          if (localThreeDBaseInfo.int32_sender_status.has())
          {
            localObject4 = paramStringBuilder;
            localObject3 = localObject1;
            i1 = j;
            localObject2 = paramList;
            n = i;
            l2 = l4;
            m = i4;
            k = i3;
            l3 = l1;
            f1 = f2;
            i2 = i5;
            localApollo3DMessage.senderStatus_3D = localThreeDBaseInfo.int32_sender_status.get();
          }
          localObject4 = paramStringBuilder;
          localObject3 = localObject1;
          i1 = j;
          localObject2 = paramList;
          n = i;
          l2 = l4;
          m = i4;
          k = i3;
          l3 = l1;
          f1 = f2;
          i2 = i5;
          if (localThreeDBaseInfo.int32_peer_status.has())
          {
            localObject4 = paramStringBuilder;
            localObject3 = localObject1;
            i1 = j;
            localObject2 = paramList;
            n = i;
            l2 = l4;
            m = i4;
            k = i3;
            l3 = l1;
            f1 = f2;
            i2 = i5;
            localApollo3DMessage.peerStatus_3D = localThreeDBaseInfo.int32_peer_status.get();
          }
        }
        localObject2 = paramList;
        f1 = f2;
        paramList = paramStringBuilder;
        paramStringBuilder = (StringBuilder)localObject1;
        i1 = j;
        Object localObject1 = localObject2;
        l2 = l4;
        n = i;
        i = i4;
        int j = i3;
        i2 = i5;
        continue;
        label3553:
        localObject2 = null;
      }
    }
  }
  
  public void c(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder)
  {
    Object localObject1 = null;
    Object localObject2 = paramList.iterator();
    if (((Iterator)localObject2).hasNext())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)((Iterator)localObject2).next();
      if (!localElem.market_trans.has()) {
        break label328;
      }
      localObject1 = (im_msg_body.MarketTrans)localElem.market_trans.get();
    }
    label328:
    for (;;)
    {
      break;
      if (localObject1 == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("elemType:MarketTrans;\n");
      }
      int i = ((im_msg_body.MarketTrans)localObject1).int32_flag.get();
      localObject1 = anre.a(((im_msg_body.MarketTrans)localObject1).bytes_xml.get().toByteArray(), i);
      if (localObject1 == null)
      {
        if (QLog.isColorLevel()) {
          paramStringBuilder.append("c2cMsgContent.data:null;\n");
        }
        a(paramList, paramList1, true);
        return;
      }
      paramStringBuilder = paramList.iterator();
      while (paramStringBuilder.hasNext())
      {
        localObject2 = (im_msg_body.Elem)paramStringBuilder.next();
        if ((((im_msg_body.Elem)localObject2).life_online.has()) && (((im_msg_body.LifeOnlineAccount)((im_msg_body.Elem)localObject2).life_online.get()).uint32_report.has()) && (((im_msg_body.LifeOnlineAccount)((im_msg_body.Elem)localObject2).life_online.get()).uint32_report.get() == 1) && (((im_msg_body.LifeOnlineAccount)((im_msg_body.Elem)localObject2).life_online.get()).uint64_unique_id.has())) {
          ((AbsStructMsg)localObject1).msgId = ((im_msg_body.LifeOnlineAccount)((im_msg_body.Elem)localObject2).life_online.get()).uint64_unique_id.get();
        }
      }
      paramList = a(paramList, paramList1, false);
      if (paramList != null) {
        ((AbsStructMsg)localObject1).mCompatibleText = paramList;
      }
      paramList = (MessageForStructing)anbi.d(-2011);
      paramList.msgtype = -2011;
      paramList.msg = "MarketTrans";
      paramList.structingMsg = ((AbsStructMsg)localObject1);
      paramList.msgData = paramList.structingMsg.getBytes();
      paramList1.add(paramList);
      return;
    }
  }
  
  public void c(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg)
  {
    atnk localatnk = null;
    Object localObject = paramList.iterator();
    do
    {
      paramList = localatnk;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      paramList = (im_msg_body.Elem)((Iterator)localObject).next();
    } while (!paramList.msg_workflow_notify.has());
    paramList = (im_msg_body.WorkflowNotifyMsg)paramList.msg_workflow_notify.get();
    if (paramList == null) {}
    for (;;)
    {
      return;
      long l1 = paramMsg.msg_head.from_uin.get();
      if (QLog.isColorLevel())
      {
        paramStringBuilder.append("elemType: dingdong_msg;\n");
        QLog.i("Approval", 1, "recv Dingdong Msg from[" + l1 + "]");
      }
      try
      {
        paramMsg = new Qworkflow.Notification();
        paramMsg.mergeFrom(paramList.bytes_ext_msg.get().toByteArray());
        if (paramMsg.msg_workflow_change.has()) {}
        for (paramList = (Qworkflow.WorkflowChangeNotification)paramMsg.msg_workflow_change.get();; paramList = null)
        {
          l1 = paramMsg.msg_appid.uint64_appid.get();
          localatnk = (atnk)this.c.app.getManager(115);
          int i;
          int j;
          if (l1 == 1800000001L)
          {
            paramMsg = paramList.bytes_workflow_id.get().toStringUtf8();
            i = paramList.uint32_sub_type.get();
            long l2 = paramList.uint64_author_uin.get();
            j = paramList.enum_change_type.get();
            if (QLog.isColorLevel())
            {
              int k = paramList.uint32_main_type.get();
              localObject = paramList.bytes_title.get().toStringUtf8();
              String str = paramList.msg_summary.bytes_content.get().toStringUtf8();
              int m = paramList.enum_change_type.get();
              int n = paramList.msg_current_state.uint32_state_num.get();
              paramStringBuilder.append("appid[").append(l1).append("]");
              paramStringBuilder.append("workId[").append(paramMsg).append("]");
              paramStringBuilder.append("mainType[").append(k).append("]");
              paramStringBuilder.append("subType[").append(i).append("]");
              paramStringBuilder.append("creator[").append(l2).append("]");
              paramStringBuilder.append("title[").append((String)localObject).append("]");
              paramStringBuilder.append("summary[").append(str).append("]");
              paramStringBuilder.append("notifyType[").append(m).append("]");
              paramStringBuilder.append("status[").append(n).append("]").append("\n");
            }
            if ((j >= 4) && (j <= 8))
            {
              paramStringBuilder = (MessageForApproval)anbi.d(-2040);
              paramStringBuilder.msgtype = -2040;
              paramStringBuilder.msgData = paramList.toByteArray();
              paramStringBuilder.parse();
              paramList1.add(paramStringBuilder);
              if (j == 7) {
                localatnk.YT(paramMsg);
              }
            }
            for (;;)
            {
              localatnk.L(paramMsg, i, l2);
              return;
              if (j == 8)
              {
                localatnk.YU(paramMsg);
                continue;
                if ((j == 2) && (this.c.app.getCurrentAccountUin().equalsIgnoreCase(String.valueOf(l2))))
                {
                  paramStringBuilder = (MessageForGrayTips)anbi.d(-2041);
                  paramStringBuilder.saveExtInfoToExtStr("approval_workid", paramMsg);
                  paramStringBuilder.saveExtInfoToExtStr("approval_subtype", String.valueOf(i));
                  paramStringBuilder.msgtype = -2041;
                  paramStringBuilder.isread = true;
                  paramStringBuilder.issend = 0;
                  paramStringBuilder.msgData = paramList.toByteArray();
                  paramList1.add(paramStringBuilder);
                }
                else if (j == 1)
                {
                  localatnk.YV(paramMsg);
                }
              }
            }
          }
          if ((l1 == 1800000002L) && (paramMsg.msg_schedule_change.has()))
          {
            i = paramMsg.msg_schedule_change.uint32_main_type.get();
            j = paramMsg.msg_schedule_change.uint32_sub_type.get();
            if ((i != 100) || ((j != 1) && (j != 2))) {
              break;
            }
            paramList = (MessageForDingdongSchedule)anbi.d(-5010);
            paramList.msgData = ((Qworkflow.ScheduleChangeNotification)paramMsg.msg_schedule_change.get()).toByteArray();
            paramList.parse();
            paramList.scheduleC2CdataReport();
            if (!paramList.canShowInAIO()) {
              break;
            }
            paramList1.add(paramList);
            return;
          }
          if ((l1 != 1801000006L) || (!paramMsg.msg_timtodo_notice.has())) {
            break;
          }
          paramList = (MessageForToDo)anbi.d(-8002);
          paramList.msgData = ((Qworkflow.TimTodoNotification)paramMsg.msg_timtodo_notice.get()).toByteArray();
          paramList.parse();
          paramList1.add(paramList);
          return;
        }
        return;
      }
      catch (Exception paramList) {}
    }
  }
  
  public void c(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, aozx paramaozx)
  {
    Object localObject1 = null;
    Object localObject2 = paramList.iterator();
    Object localObject3;
    for (im_msg_body.CommonElem localCommonElem = null; ((Iterator)localObject2).hasNext(); localCommonElem = (im_msg_body.CommonElem)((im_msg_body.Elem)localObject3).common_elem.get())
    {
      localObject3 = (im_msg_body.Elem)((Iterator)localObject2).next();
      if (!((im_msg_body.Elem)localObject3).common_elem.has()) {
        break label498;
      }
    }
    O(paramList);
    if (QLog.isColorLevel()) {
      QLog.d("ArkBabyq", 2, "decodePBMsgElems_ArkBabyqReply  common_lem" + localCommonElem);
    }
    if (localCommonElem == null) {
      return;
    }
    localObject2 = new hummer_commelem.MsgElemInfo_servtype19();
    try
    {
      ((hummer_commelem.MsgElemInfo_servtype19)localObject2).mergeFrom(localCommonElem.bytes_pb_elem.get().toByteArray());
      if (!ArkUtil.isDeviceSupportArkMsg())
      {
        QLog.i("ArkBabyq", 1, "decodePBMsgElems_ArkBabyqReply is false, ignore msg.");
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramList)
    {
      paramList.printStackTrace();
      return;
    }
    if (((hummer_commelem.MsgElemInfo_servtype19)localObject2).bytes_data.has())
    {
      ((hummer_commelem.MsgElemInfo_servtype19)localObject2).bytes_data.get().toStringUtf8();
      localObject2 = ((hummer_commelem.MsgElemInfo_servtype19)localObject2).bytes_data.get().toByteArray();
      if ((localObject2 == null) || (localObject2.length <= 0))
      {
        QLog.i("ArkBabyq", 1, "decodePBMsgElems_ArkBabyqReply, bytes_data empty.");
        return;
      }
      localObject2 = ansi.d((byte[])localObject2, -1);
      if (localObject2 != null)
      {
        int i = localObject2.length;
        if (i > 0)
        {
          try
          {
            localObject2 = new String((byte[])localObject2, "UTF-8");
            localObject1 = localObject2;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              label257:
              QLog.i("ArkBabyq", 1, "decodePBMsgElems_ArkBabyqReply convert failed");
            }
          }
          localObject2 = a(paramList, paramList1, false);
          localObject3 = (MessageForArkBabyqReply)anbi.d(-5016);
          ((MessageForArkBabyqReply)localObject3).msgtype = -5016;
          if (localObject2 != null) {
            ((MessageForArkBabyqReply)localObject3).compatibleMsg = ((String)localObject2);
          }
          ((MessageForArkBabyqReply)localObject3).fromAppXml(localObject1);
          if (localCommonElem.uint32_business_type.get() == 2) {
            break label501;
          }
        }
      }
    }
    label498:
    label501:
    for (boolean bool = true;; bool = false)
    {
      ((MessageForArkBabyqReply)localObject3).showAsBabyq = bool;
      ((MessageForArkBabyqReply)localObject3).msgData = ((MessageForArkBabyqReply)localObject3).toBytes();
      ((MessageForArkBabyqReply)localObject3).parse();
      if ((TextUtils.isEmpty(((MessageForArkBabyqReply)localObject3).babyqReplyText)) && (!((MessageForArkBabyqReply)localObject3).isFailed) && ((((MessageForArkBabyqReply)localObject3).mArkBabyqReplyCardList == null) || (((MessageForArkBabyqReply)localObject3).mArkBabyqReplyCardList.size() <= 0))) {
        QLog.i("ArkBabyq", 1, "decodePBMsgElems_ArkBabyqReply not valid..");
      }
      for (bool = false;; bool = true)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArkBabyq", 2, "decodePBMsgElems_ArkBabyqReply hasArkBabyQMsg = " + bool);
        }
        if (bool) {
          break;
        }
        g(paramList, paramList1, paramStringBuilder, paramMsg, paramaozx);
        return;
        QLog.i("ArkBabyq", 1, "decodePBMsgElems_ArkBabyqReply empty.");
        break label257;
        paramList1.add(localObject3);
      }
      QLog.i("ArkBabyq", 1, "decodePBMsgElems_ArkBabyqReply, bytes_data not exist.");
      return;
      break;
    }
  }
  
  public void d(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder)
  {
    MessageForIncompatibleGrayTips localMessageForIncompatibleGrayTips = null;
    Iterator localIterator = paramList.iterator();
    do
    {
      paramList = localMessageForIncompatibleGrayTips;
      if (!localIterator.hasNext()) {
        break;
      }
      paramList = (im_msg_body.Elem)localIterator.next();
    } while (!paramList.tips_info.has());
    paramList = (im_msg_body.TipsInfo)paramList.tips_info.get();
    if (paramList == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("elemType:TipsInfo;\n");
      }
      localMessageForIncompatibleGrayTips = (MessageForIncompatibleGrayTips)anbi.d(-5002);
      if (localMessageForIncompatibleGrayTips.parseTextXML(paramList.text.get()).booleanValue())
      {
        paramList1.add(localMessageForIncompatibleGrayTips);
        return;
      }
    } while (!QLog.isColorLevel());
    paramStringBuilder.append("TipsInfo parse failed;\n");
  }
  
  public void d(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg)
  {
    Object localObject1 = null;
    Object localObject3 = paramList.iterator();
    Object localObject2 = null;
    if (((Iterator)localObject3).hasNext())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)((Iterator)localObject3).next();
      if (localElem.trans_elem_info.has()) {
        localObject2 = (im_msg_body.TransElem)localElem.trans_elem_info.get();
      }
      if (!localElem.general_flags.has()) {
        break label1569;
      }
      localObject1 = (im_msg_body.GeneralFlags)localElem.general_flags.get();
    }
    label1560:
    label1569:
    for (;;)
    {
      break;
      if (localObject2 == null) {}
      int i;
      int j;
      StringBuilder localStringBuilder;
      label444:
      label449:
      do
      {
        do
        {
          do
          {
            return;
            if (QLog.isColorLevel()) {
              paramStringBuilder.append("elemType:TransElemInfo;\n");
            }
            i = ((im_msg_body.TransElem)localObject2).elem_type.get();
            if (QLog.isColorLevel()) {
              paramStringBuilder.append("transElemType:").append(i).append(";\n");
            }
            localObject3 = ((im_msg_body.TransElem)localObject2).elem_value.get().toByteArray();
            if ((localObject3 == null) || (localObject3.length == 0))
            {
              paramStringBuilder.append("transElemByte is null or transElemByte.length == 0\n");
              return;
            }
            switch (i)
            {
            default: 
              return;
            case 3: 
              paramList = BaseApplication.getContext().getString(2131696611);
              paramStringBuilder = (MessageForText)anbi.d(-1000);
              paramStringBuilder.msgtype = -1000;
              paramStringBuilder.msg = paramList;
              paramList1.add(paramStringBuilder);
              return;
            }
          } while (localObject3[0] != 1);
          i = aqoj.b((byte[])localObject3, 1);
          j = localObject3[3];
          localObject2 = new byte[i - 1];
          aqoj.copyData((byte[])localObject2, 0, (byte[])localObject3, 4, i - 1);
          paramStringBuilder = (StringBuilder)localObject2;
          if (j == 1) {
            paramStringBuilder = A((byte[])localObject2);
          }
          if (paramStringBuilder == null) {
            break label1560;
          }
          try
          {
            if (paramStringBuilder.length <= 0) {
              break label1560;
            }
            paramStringBuilder = new String(paramStringBuilder, "utf-8");
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              long l;
              paramList = "";
              paramStringBuilder = null;
            }
          }
          try
          {
            localObject2 = b(paramStringBuilder);
            if (localObject2 == null) {
              break label628;
            }
            try
            {
              paramList = paramList.iterator();
              while (paramList.hasNext())
              {
                localObject3 = (im_msg_body.Elem)paramList.next();
                if ((((im_msg_body.Elem)localObject3).elem_flags2.has()) && (((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject3).elem_flags2.get()).uint64_msg_id.has())) {
                  ((PAMessage)localObject2).mMsgId = ((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject3).elem_flags2.get()).uint64_msg_id.get();
                }
              }
              ((Exception)localObject2).printStackTrace();
            }
            catch (Exception localException4)
            {
              paramList = (List<im_msg_body.Elem>)localObject2;
              localObject2 = localException4;
              localStringBuilder = paramStringBuilder;
              paramStringBuilder = paramList;
              paramList = localStringBuilder;
            }
          }
          catch (Exception localException3)
          {
            localStringBuilder = null;
            paramList = paramStringBuilder;
            paramStringBuilder = localStringBuilder;
            break label444;
            paramList = null;
            break label1347;
          }
          if (!paramMsg.msg_head.from_uin.has()) {
            break;
          }
          l = paramMsg.msg_head.from_uin.get();
        } while (xki.hN(l + ""));
      } while (paramStringBuilder == null);
      paramMsg = (MessageForPubAccount)anbi.d(-3006);
      paramMsg.msgtype = -3006;
      paramMsg.msg = paramList.toString();
      paramMsg.mPAMessage = paramStringBuilder;
      for (;;)
      {
        for (;;)
        {
          try
          {
            paramMsg.msgData = obj.a(paramStringBuilder);
            if ((localObject1 == null) || (!((im_msg_body.GeneralFlags)localObject1).bytes_pb_reserve.has())) {}
          }
          catch (Exception paramList)
          {
            try
            {
              paramList = new generalflags.ResvAttr();
              paramList.mergeFrom(((im_msg_body.GeneralFlags)localObject1).bytes_pb_reserve.get().toByteArray());
              if (paramList.bytes_oac_msg_extend.has()) {
                paramMsg.saveExtInfoToExtStr("report_key_bytes_oac_msg_extend", paramList.bytes_oac_msg_extend.get().toStringUtf8());
              }
              paramList1.add(paramMsg);
              return;
              label628:
              paramList = paramStringBuilder;
              paramStringBuilder = (StringBuilder)localObject2;
              break label449;
              paramList = paramList;
              paramList.printStackTrace();
            }
            catch (Throwable paramList)
            {
              QLog.e("DecodeMsg", 2, "decodePBMsgElems_TransElemInfo()-MessageForPubAccount: parse generalflags error! " + QLog.getStackTraceString(paramList));
              continue;
            }
          }
          int k = ((im_msg_body.TransElem)localObject2).elem_value.get().size();
          j = 0;
          i = 0;
          for (;;)
          {
            if (k <= 3) {
              break label851;
            }
            int m = j + 1;
            if (j > 100) {
              break;
            }
            int n = localStringBuilder[i];
            int i1 = aqoj.b(localStringBuilder, i + 1);
            j = k - (i1 + 3);
            k = i1 + 3 + i;
            if (n != 1)
            {
              i = k;
              k = j;
              j = m;
            }
            else
            {
              paramList = new byte[i1];
              aqoj.copyData(paramList, 0, localStringBuilder, i + 3, i1);
              paramStringBuilder = new obj_msg.ObjMsg();
              try
              {
                paramList = (obj_msg.ObjMsg)paramStringBuilder.mergeFrom(paramList);
                if (paramList.uint32_msg_type.get() == 6L) {
                  break label853;
                }
                i = k;
                k = j;
                j = m;
              }
              catch (Exception paramList)
              {
                i = k;
                k = j;
                j = m;
              }
            }
          }
          label851:
          break;
          label853:
          paramStringBuilder = new TroopFileData();
          paramStringBuilder.fileUrl = new String(((obj_msg.MsgContentInfo)paramList.msg_content_info.get(0)).msg_file.bytes_file_path.get().toByteArray());
          paramStringBuilder.bisID = ((obj_msg.MsgContentInfo)paramList.msg_content_info.get(0)).msg_file.uint32_bus_id.get();
          paramStringBuilder.fileName = ((obj_msg.MsgContentInfo)paramList.msg_content_info.get(0)).msg_file.str_file_name.get();
          paramStringBuilder.lfileSize = ((obj_msg.MsgContentInfo)paramList.msg_content_info.get(0)).msg_file.uint64_file_size.get();
          paramStringBuilder.lastTime = ((obj_msg.MsgContentInfo)paramList.msg_content_info.get(0)).msg_file.int64_dead_time.get();
          paramStringBuilder.sha1 = new String(((obj_msg.MsgContentInfo)paramList.msg_content_info.get(0)).msg_file.bytes_file_sha1.get().toByteArray());
          paramStringBuilder.uuid = UUID.nameUUIDFromBytes(paramStringBuilder.fileUrl.getBytes()).toString();
          if (((obj_msg.MsgContentInfo)paramList.msg_content_info.get(0)).msg_file.bytes_ext.has()) {
            localObject1 = ((obj_msg.MsgContentInfo)paramList.msg_content_info.get(0)).msg_file.bytes_ext.get().toStringUtf8();
          }
          try
          {
            localObject1 = new JSONObject((String)localObject1);
            paramStringBuilder.width = ((JSONObject)localObject1).optInt("width");
            paramStringBuilder.height = ((JSONObject)localObject1).optInt("height");
            paramStringBuilder.duration = ((JSONObject)localObject1).optInt("duration");
            paramStringBuilder.yybApkPackageName = ((JSONObject)localObject1).optString("yyb_apk_package_name_key");
            paramStringBuilder.yybApkName = ((JSONObject)localObject1).optString("yyb_apk_name_key");
            paramStringBuilder.yybApkIconUrl = ((JSONObject)localObject1).optString("yyb_apk_icon_url_key");
            paramStringBuilder.dspFileName = new String(paramList.bytes_title.get().toByteArray());
            paramStringBuilder.dspFileName = ahav.getFileName(paramStringBuilder.dspFileName);
            paramStringBuilder.dspFileSize = new String(((ByteStringMicro)paramList.rpt_bytes_abstact.get(0)).toByteArray());
            apsc.a(paramMsg.msg_head.group_info.group_code.get()).a(this.c.app, paramStringBuilder.fileUrl, paramStringBuilder);
            localObject1 = new StringBuilder("decodePBMshElems==>").append(paramStringBuilder.toString());
            paramList = TroopFileTransferManager.a(this.c.app, paramMsg.msg_head.group_info.group_code.get()).a(paramStringBuilder.fileUrl);
            if (paramList != null)
            {
              paramList = this.c.app.a().b(paramList.entrySessionID);
              if (paramList != null) {
                paramList.lastTime = paramStringBuilder.lastTime;
              }
              label1347:
              localObject2 = (MessageForTroopFile)anbi.d(-2017);
              ((MessageForTroopFile)localObject2).msgtype = -2017;
              ((MessageForTroopFile)localObject2).msg = acfp.m(2131708227);
            }
          }
          catch (Exception localException1)
          {
            try
            {
              ((MessageForTroopFile)localObject2).msgData = aczw.b(paramStringBuilder);
              ((MessageForTroopFile)localObject2).parse();
              paramList1.add(localObject2);
              if (paramList != null)
              {
                this.c.app.b().c(paramMsg.msg_head.group_info.group_code.get() + "", 1, paramList.structMsgSeq, ((MessageForTroopFile)localObject2).msgData);
                ((StringBuilder)localObject1).append("|updateMsgContentByUniseq, msgSeq:").append(paramList.structMsgSeq);
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("DecodeMsg", 2, "<TroopFile> " + ((StringBuilder)localObject1).toString());
              return;
              localException1 = localException1;
              localException1.printStackTrace();
            }
            catch (Exception paramStringBuilder)
            {
              for (;;)
              {
                paramStringBuilder.printStackTrace();
              }
            }
          }
        }
        paramList = "";
        paramStringBuilder = null;
      }
    }
  }
  
  public void d(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, aozx paramaozx)
  {
    Object localObject3 = null;
    Iterator localIterator = paramList.iterator();
    im_msg_body.GeneralFlags localGeneralFlags = null;
    Object localObject1 = null;
    im_msg_body.ArkAppElem localArkAppElem = null;
    im_msg_body.Elem localElem;
    if (localIterator.hasNext())
    {
      localElem = (im_msg_body.Elem)localIterator.next();
      if (localElem.ark_app.has()) {
        localArkAppElem = (im_msg_body.ArkAppElem)localElem.ark_app.get();
      }
      if (!localElem.light_app.has()) {
        break label439;
      }
      localObject1 = (im_msg_body.LightAppElem)localElem.light_app.get();
    }
    label439:
    for (;;)
    {
      if (localElem.general_flags.has()) {
        localGeneralFlags = (im_msg_body.GeneralFlags)localElem.general_flags.get();
      }
      for (;;)
      {
        break;
        paramStringBuilder.append("elemType:ArkApp/LightApp;\n");
        if (!ArkUtil.isDeviceSupportArkMsg())
        {
          QLog.i("ArkApp", 1, "decode msg, ArkAppCenter.isDeviceSupportArkMsg is false, ignore msg.");
          if (a(paramList).booleanValue())
          {
            g(paramList, paramList1, paramStringBuilder, paramMsg, paramaozx);
            return;
          }
          paramList = (MessageForText)anbi.d(-1000);
          paramList.msgtype = -1000;
          paramList.msg = BaseApplication.getContext().getString(2131695296);
          paramList1.add(paramList);
          return;
        }
        if (ArkAppCenter.aft())
        {
          QLog.i("ArkApp", 1, "decode msg, ArkAppCenter.isPANonShow is true, ignore msg.");
          return;
        }
        if (localArkAppElem != null)
        {
          if (!localArkAppElem.bytes_data.has())
          {
            QLog.i("ArkApp", 1, "decode msg, ark_app.bytes_data not exist.");
            return;
          }
          localObject1 = localArkAppElem.bytes_data.get().toByteArray();
        }
        for (;;)
        {
          if ((localObject1 == null) || (localObject1.length <= 0))
          {
            QLog.i("ArkApp", 1, "decode msg, ark_app.bytes_data is empty.");
            return;
            if (localObject1 != null)
            {
              if (!((im_msg_body.LightAppElem)localObject1).bytes_data.has())
              {
                QLog.i("ArkApp", 1, "decode msg, light_app.bytes_data not exist.");
                return;
              }
              localObject1 = ((im_msg_body.LightAppElem)localObject1).bytes_data.get().toByteArray();
            }
          }
          else
          {
            localObject1 = ansi.d((byte[])localObject1, -1);
            if ((localObject1 != null) && (localObject1.length > 0)) {}
            for (;;)
            {
              try
              {
                localObject1 = new String((byte[])localObject1, "UTF-8");
                if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                  break;
                }
                QLog.i("ArkApp", 1, "decode msg, ark data is empty.");
                return;
              }
              catch (Exception localException)
              {
                QLog.i("ArkApp", 1, "decode msg, raw data cannot convert to string.");
                localObject2 = localObject3;
                continue;
              }
              QLog.i("ArkApp", 1, "decode msg, raw data is empty.");
              localObject2 = localObject3;
            }
            a(localGeneralFlags, false, localObject2, paramList, paramList1, paramStringBuilder, paramMsg, paramaozx);
            return;
          }
          Object localObject2 = null;
        }
      }
    }
  }
  
  public void e(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder)
  {
    paramList = paramList.iterator();
    im_msg_body.Elem localElem;
    do
    {
      if (!paramList.hasNext()) {
        break;
      }
      localElem = (im_msg_body.Elem)paramList.next();
    } while (!localElem.common_elem.has());
    for (paramList = (im_msg_body.CommonElem)localElem.common_elem.get();; paramList = null)
    {
      if (paramList == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("elemType:QQStoryComment;\n");
      }
      paramStringBuilder = new hummer_commelem.MsgElemInfo_servtype5();
      try
      {
        paramStringBuilder.mergeFrom(paramList.bytes_pb_elem.get().toByteArray());
        paramList = (MessageForQQStoryComment)anbi.d(-2052);
        paramList.vid = paramStringBuilder.vid.get().toStringUtf8();
        paramList.comment = paramStringBuilder.comment_content.get().toStringUtf8();
        paramList.coverUrl = paramStringBuilder.cover.get().toStringUtf8();
        paramList.title = paramStringBuilder.title.get().toStringUtf8();
        paramList.summary = paramStringBuilder.summary.get().toStringUtf8();
        paramList.createTime = paramStringBuilder.createTime.get();
        paramList.author = paramStringBuilder.author.get();
        paramList.prewrite();
        paramList1.add(paramList);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramList)
      {
        paramList.printStackTrace();
        return;
      }
    }
  }
  
  public void e(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg)
  {
    paramList = paramList.iterator();
    do
    {
      if (!paramList.hasNext()) {
        break;
      }
      paramMsg = (im_msg_body.Elem)paramList.next();
    } while (!paramMsg.common_elem.has());
    for (paramList = (im_msg_body.CommonElem)paramMsg.common_elem.get();; paramList = null)
    {
      if (paramList == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("decodePBMsgElems_ScribbleMsg;\n");
      }
      paramStringBuilder = new hummer_commelem.MsgElemInfo_servtype11();
      try
      {
        paramStringBuilder.mergeFrom(paramList.bytes_pb_elem.get().toByteArray());
        paramList = (MessageForScribble)anbi.d(-7001);
        paramList.msgtype = -7001;
        if (paramStringBuilder.bytes_Doodle_md5.has()) {
          paramList.combineFileMd5 = new String(paramStringBuilder.bytes_Doodle_md5.get().toByteArray());
        }
        if (paramStringBuilder.bytes_Doodle_url.has()) {
          paramList.combineFileUrl = new String(paramStringBuilder.bytes_Doodle_url.get().toByteArray());
        }
        if (paramStringBuilder.uint32_doodleData_offset.has()) {
          paramList.offSet = paramStringBuilder.uint32_doodleData_offset.get();
        }
        if (paramStringBuilder.uint32_doodle_gif_id.has()) {
          paramList.gifId = paramStringBuilder.uint32_doodle_gif_id.get();
        }
        if (QLog.isColorLevel()) {
          QLog.i("DecodeMsgscribble msg", 1, " decodePBMsgElems_ScribbleMsg " + paramList.combineFileMd5 + " " + paramList.combineFileUrl);
        }
        paramList.prewrite();
        paramList1.add(paramList);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramList)
      {
        paramList.printStackTrace();
        QLog.e("DecodeMsgscribble msg", 1, paramList, new Object[0]);
        return;
      }
    }
  }
  
  public void e(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, aozx paramaozx)
  {
    Object localObject2 = null;
    Object localObject3 = paramList.iterator();
    Object localObject1 = null;
    Object localObject4;
    if (((Iterator)localObject3).hasNext())
    {
      localObject4 = (im_msg_body.Elem)((Iterator)localObject3).next();
      if (!((im_msg_body.Elem)localObject4).common_elem.has()) {
        break label464;
      }
      localObject1 = (im_msg_body.CommonElem)((im_msg_body.Elem)localObject4).common_elem.get();
    }
    label437:
    label451:
    label464:
    for (;;)
    {
      break;
      O(paramList);
      if (QLog.isColorLevel()) {
        QLog.d("ArkSdkShare", 2, "decodePBMsgElems_ArkSdkApp  common_lem" + localObject1);
      }
      if (localObject1 == null) {}
      for (;;)
      {
        return;
        localObject3 = new hummer_commelem.MsgElemInfo_servtype20();
        try
        {
          ((hummer_commelem.MsgElemInfo_servtype20)localObject3).mergeFrom(((im_msg_body.CommonElem)localObject1).bytes_pb_elem.get().toByteArray());
          if (!ArkUtil.isDeviceSupportArkMsg())
          {
            QLog.i("ArkSdkShare", 1, "decodePBMsgElems_ArkSdkApp is false, ignore msg.");
            return;
          }
        }
        catch (InvalidProtocolBufferMicroException paramList)
        {
          paramList.printStackTrace();
          return;
        }
        if (!((hummer_commelem.MsgElemInfo_servtype20)localObject3).bytes_data.has()) {
          break;
        }
        ((hummer_commelem.MsgElemInfo_servtype20)localObject3).bytes_data.get().toStringUtf8();
        localObject3 = ((hummer_commelem.MsgElemInfo_servtype20)localObject3).bytes_data.get().toByteArray();
        if ((localObject3 == null) || (localObject3.length <= 0))
        {
          QLog.i("ArkSdkShare", 1, "decodePBMsgElems_ArkSdkApp, bytes_data empty.");
          return;
        }
        localObject3 = ansi.d((byte[])localObject3, -1);
        if (localObject3 != null)
        {
          i = localObject3.length;
          if (i > 0)
          {
            try
            {
              localObject3 = new String((byte[])localObject3, "UTF-8");
              localObject2 = localObject3;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                QLog.i("ArkSdkShare", 1, "decodePBMsgElems_ArkSdkApp convert failed");
              }
            }
            localObject4 = a(paramList, paramList1, false);
            localObject3 = (MessageForArkApp)anbi.d(-5017);
            ((MessageForArkApp)localObject3).msgtype = -5017;
            if (((im_msg_body.CommonElem)localObject1).uint32_business_type.get() == 1) {
              ((MessageForArkApp)localObject3).saveExtInfoToExtStr(anbb.ccN, "1");
            }
            if (localObject4 != null) {
              ((MessageForArkApp)localObject3).compatibleMsg = ((String)localObject4);
            }
            localObject1 = new ArkAppMessage();
            ((ArkAppMessage)localObject1).fromAppXml(localObject2);
            ((MessageForArkApp)localObject3).msgData = ((ArkAppMessage)localObject1).toBytes();
            ((MessageForArkApp)localObject3).parse();
            if ((TextUtils.isEmpty(((MessageForArkApp)localObject3).ark_app_message.appName)) || (TextUtils.isEmpty(((MessageForArkApp)localObject3).ark_app_message.appView))) {
              break label437;
            }
            paramList1.add(localObject3);
          }
        }
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label451;
          }
          g(paramList, paramList1, paramStringBuilder, paramMsg, paramaozx);
          return;
          QLog.i("ArkSdkShare", 1, "decodePBMsgElems_ArkSdkApp empty.");
          break;
          QLog.i("arksdk", 1, "decode msg, ark message is not valid..");
        }
      }
      QLog.i("ArkSdkShare", 1, "decodePBMsgElems_ArkSdkApp, bytes_data not exist.");
      return;
    }
  }
  
  public void f(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder)
  {
    paramList = paramList.iterator();
    im_msg_body.Elem localElem;
    do
    {
      if (!paramList.hasNext()) {
        break;
      }
      localElem = (im_msg_body.Elem)paramList.next();
    } while (!localElem.common_elem.has());
    for (paramList = (im_msg_body.CommonElem)localElem.common_elem.get();; paramList = null)
    {
      if (paramList == null) {}
      for (;;)
      {
        return;
        if (QLog.isColorLevel()) {
          paramStringBuilder.append("elemType:TroopStoryComment;\n");
        }
        paramStringBuilder = new hummer_commelem.MsgElemInfo_servtype15();
        try
        {
          paramStringBuilder.mergeFrom(paramList.bytes_pb_elem.get().toByteArray());
          paramList = (MessageForQQStoryComment)anbi.d(-2052);
          paramList.vid = paramStringBuilder.vid.get().toStringUtf8();
          paramList.comment = paramStringBuilder.comment_content.get().toStringUtf8();
          paramList.coverUrl = paramStringBuilder.cover.get().toStringUtf8();
          paramList.title = paramStringBuilder.title.get().toStringUtf8();
          paramList.summary = paramStringBuilder.summary.get().toStringUtf8();
          paramList.createTime = paramStringBuilder.createTime.get();
          paramList.author = paramStringBuilder.author.get();
          paramList.ctrVersion = paramStringBuilder.ctr_version.get();
          if (paramList.ctrVersion <= 1)
          {
            paramList.prewrite();
            paramList1.add(paramList);
            return;
          }
        }
        catch (InvalidProtocolBufferMicroException paramList)
        {
          paramList.printStackTrace();
          return;
        }
      }
    }
  }
  
  public void f(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, aozx paramaozx)
  {
    Object localObject1 = paramList.iterator();
    Object localObject2;
    do
    {
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      localObject2 = (im_msg_body.Elem)((Iterator)localObject1).next();
    } while (!((im_msg_body.Elem)localObject2).qqwallet_msg.has());
    for (localObject1 = (im_msg_body.QQWalletMsg)((im_msg_body.Elem)localObject2).qqwallet_msg.get();; localObject1 = null)
    {
      if (localObject1 == null) {}
      int k;
      int n;
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            paramStringBuilder.append("elemType:QQWalletMsg;\n");
          }
        } while (!((im_msg_body.QQWalletMsg)localObject1).aio_body.has());
        k = 0;
        n = ((im_msg_body.QQWalletMsg)localObject1).aio_body.sint32_msgtype.get();
        if (QLog.isColorLevel()) {
          QLog.i("DecodeMsg", 2, "--msgType: " + n);
        }
      } while (n > 3000);
      int j;
      label154:
      MessageForQQWalletMsg localMessageForQQWalletMsg;
      boolean bool;
      label273:
      Object localObject3;
      if (n > 2000)
      {
        j = k;
        if (j != 0) {
          break label1745;
        }
        localMessageForQQWalletMsg = (MessageForQQWalletMsg)anbi.d(-2025);
        localMessageForQQWalletMsg.msgtype = -2025;
        localMessageForQQWalletMsg.messageType = n;
        if (!((im_msg_body.QQWalletAioBody)((im_msg_body.QQWalletMsg)localObject1).aio_body.get()).sint32_redtype.has()) {
          break label1253;
        }
        localMessageForQQWalletMsg.mQQWalletTransferMsg = null;
        localMessageForQQWalletMsg.mQQWalletRedPacketMsg = new QQWalletRedPacketMsg(((im_msg_body.QQWalletMsg)localObject1).aio_body, this.c.app.getCurrentAccountUin());
        if ((localMessageForQQWalletMsg.mQQWalletRedPacketMsg != null) && ((n == 4) || (n == 5)))
        {
          if (localMessageForQQWalletMsg.mQQWalletRedPacketMsg.msgFrom != 1) {
            break label1056;
          }
          bool = true;
          localMessageForQQWalletMsg.isBlessMsg = bool;
          if (QLog.isColorLevel()) {
            QLog.d("BlessManagerHB", 2, "decode msgFrom=" + localMessageForQQWalletMsg.mQQWalletRedPacketMsg.msgFrom);
          }
        }
        if ((n == 7) || (n == 8))
        {
          localObject2 = this.app.getCurrentAccountUin();
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject3 = ((im_msg_body.QQWalletMsg)localObject1).aio_body.uint64_grap_uin.get().iterator();
            do
            {
              if (!((Iterator)localObject3).hasNext()) {
                break;
              }
            } while (!((String)localObject2).equals(String.valueOf((Long)((Iterator)localObject3).next())));
          }
        }
      }
      for (int i = 1;; i = 0)
      {
        long l;
        for (;;)
        {
          if ((i != 0) && (paramaozx != null))
          {
            paramaozx.b.b(17, paramMsg.msg_head.msg_seq.get(), localMessageForQQWalletMsg.msgseq);
            localMessageForQQWalletMsg.mMessageInfo = paramaozx;
          }
          label564:
          label584:
          String str;
          Object localObject4;
          if ((n == 6) || (n == 13) || (n == 15) || (n == 18) || (n == 19) || (n == 21) || (n == 22) || (n == 23) || (n == 24) || (n == 25))
          {
            i = paramMsg.msg_head.msg_type.get();
            if ((i != 82) && (i != 43)) {
              break label1062;
            }
            j = 1;
            l = paramMsg.msg_head.group_info.group_code.get();
            i = 0;
            if ((n != 13) && (n != 15)) {
              break label1163;
            }
            i = 1;
            str = "";
            localObject2 = str;
            if (i == 4)
            {
              localObject2 = "";
              localObject3 = localObject2;
              if (localMessageForQQWalletMsg.mQQWalletRedPacketMsg != null)
              {
                localObject3 = localObject2;
                if (localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem != null) {
                  localObject3 = localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title;
                }
              }
              localObject2 = "";
              localObject4 = localObject2;
              if (localMessageForQQWalletMsg.mQQWalletRedPacketMsg != null)
              {
                localObject4 = localObject2;
                if (localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem != null) {
                  localObject4 = localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.lastPinyin;
                }
              }
              localObject2 = str;
              if (!aqmr.isEmpty((String)localObject3))
              {
                localObject2 = str;
                if (!aqmr.isEmpty((String)localObject4)) {
                  localObject2 = (String)localObject3 + "_" + (String)localObject4;
                }
              }
            }
            if (QLog.isColorLevel()) {
              QLog.i("DecodeMsg", 2, "--subChannel: " + localMessageForQQWalletMsg.mQQWalletRedPacketMsg.body.subChannel);
            }
            localObject3 = (zxj)this.c.app.getManager(125);
            if (localObject3 != null) {
              localObject4 = new JSONObject();
            }
          }
          try
          {
            ((JSONObject)localObject4).put("key_sub_channel", localMessageForQQWalletMsg.mQQWalletRedPacketMsg.body.subChannel);
            str = zxi.hU(localMessageForQQWalletMsg.mQQWalletRedPacketMsg.body.poemRule);
            if (!TextUtils.isEmpty(str)) {
              ((JSONObject)localObject4).put("key_poem_rule", str);
            }
            ((zxj)localObject3).a((im_msg_body.QQWalletAioBody)((im_msg_body.QQWalletMsg)localObject1).aio_body.get(), j, l, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_time.get(), i, (String)localObject2, ((JSONObject)localObject4).toString());
            label921:
            localMessageForQQWalletMsg.msg = localMessageForQQWalletMsg.getMsgSummary();
            localMessageForQQWalletMsg.msgData = localMessageForQQWalletMsg.getBytes();
            localMessageForQQWalletMsg.onDecodeFinish(this.app, paramMsg);
            if ((localMessageForQQWalletMsg != null) && (!localMessageForQQWalletMsg.isMsgEmpty())) {
              break label1611;
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            paramStringBuilder.append("c2cMsgContent.QQWalletTransferMsg:null or mqt:isMsgEmpty;\n");
            return;
            j = k;
            if (n > 1000) {
              break label154;
            }
            int m = 0;
            localObject2 = MessageForQQWalletMsg.mMsgType;
            int i1 = localObject2.length;
            j = 0;
            for (;;)
            {
              i = m;
              if (j < i1)
              {
                if (localObject2[j] == n) {
                  i = 1;
                }
              }
              else
              {
                j = k;
                if (i != 0) {
                  break;
                }
                j = 1;
                break;
              }
              j += 1;
            }
            label1056:
            bool = false;
            break label273;
            label1062:
            if ((i == 83) || (i == 42))
            {
              j = 2;
              l = paramMsg.msg_head.discuss_info.discuss_uin.get();
              break label564;
            }
            j = 3;
            if (this.c.app.getCurrentAccountUin().equals(String.valueOf(paramMsg.msg_head.to_uin.get()))) {}
            for (l = paramMsg.msg_head.from_uin.get();; l = paramMsg.msg_head.to_uin.get()) {
              break;
            }
            label1163:
            if (n == 18)
            {
              i = 2;
              break label584;
            }
            if (n == 19)
            {
              i = 3;
              break label584;
            }
            if ((n == 21) || (n == 24) || (n == 25))
            {
              i = 4;
              break label584;
            }
            if (n == 22)
            {
              i = 5;
              break label584;
            }
            if (n != 23) {
              break label584;
            }
            i = 6;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
            }
          }
        }
        label1253:
        localMessageForQQWalletMsg.mQQWalletRedPacketMsg = null;
        localMessageForQQWalletMsg.mQQWalletTransferMsg = new QQWalletTransferMsg(((im_msg_body.QQWalletMsg)localObject1).aio_body, this.c.app.getCurrentAccountUin());
        if (((im_msg_body.QQWalletMsg)localObject1).aio_body.uint64_senduin.has())
        {
          l = ((im_msg_body.QQWalletMsg)localObject1).aio_body.uint64_senduin.get();
          localObject2 = this.c.app.getCurrentAccountUin();
        }
        for (;;)
        {
          if ((n == 10) && (localMessageForQQWalletMsg.mQQWalletTransferMsg.elem != null) && (!TextUtils.isEmpty(localMessageForQQWalletMsg.mQQWalletTransferMsg.elem.nativeAndroid)))
          {
            localObject3 = localMessageForQQWalletMsg.mQQWalletTransferMsg.elem.nativeAndroid.split("\\?");
            if (localObject3.length > 1) {}
            for (localObject3 = localMessageForQQWalletMsg.parseUrlParams(localObject3[1]);; localObject3 = new HashMap())
            {
              zya.c(this.app, (String)((HashMap)localObject3).get("tokenid"), ((im_msg_body.QQWalletMsg)localObject1).aio_body.uint64_senduin.get());
              if ((l == 0L) || (TextUtils.isEmpty((CharSequence)localObject2)) || (((String)localObject2).compareTo("" + l) == 0)) {
                break;
              }
              anot.a(this.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "friendpay.payaio.buyershow", 0, 0, "", "", "", "");
              break;
            }
          }
          if ((n != 9) || (l == 0L) || (TextUtils.isEmpty((CharSequence)localObject2)) || (((String)localObject2).compareTo("" + l) == 0)) {
            break label921;
          }
          anot.a(this.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "friendpay.askaio.payershow", 0, 0, "", "", "", "");
          break label921;
          label1611:
          if (((im_msg_body.QQWalletMsg)localObject1).aio_body.uint32_msg_priority.has()) {}
          for (i = ((im_msg_body.QQWalletMsg)localObject1).aio_body.uint32_msg_priority.get(); i >= 3; i = 10)
          {
            paramList1.add(localMessageForQQWalletMsg);
            return;
          }
          if (i >= 2)
          {
            g(paramList, paramList1, paramStringBuilder, paramMsg, paramaozx);
            if (!paramList1.isEmpty()) {
              break;
            }
            paramList1.add(localMessageForQQWalletMsg);
            return;
          }
          if (i < 1) {
            break;
          }
          g(paramList, paramList1, paramStringBuilder, paramMsg, paramaozx);
          if (paramList1.isEmpty())
          {
            i(paramList, paramList1, paramStringBuilder, paramMsg, paramaozx);
            return;
          }
          paramList1.add(localMessageForQQWalletMsg);
          return;
          label1745:
          i(paramList, paramList1, paramStringBuilder, paramMsg, paramaozx);
          return;
          localObject2 = "";
          l = 0L;
        }
      }
    }
  }
  
  public void g(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder)
  {
    Object localObject = null;
    Iterator localIterator = paramList.iterator();
    im_msg_body.CommonElem localCommonElem1 = null;
    paramList = (List<im_msg_body.Elem>)localObject;
    localObject = paramList;
    im_msg_body.CommonElem localCommonElem2 = localCommonElem1;
    if (localIterator.hasNext())
    {
      localObject = (im_msg_body.Elem)localIterator.next();
      if (!((im_msg_body.Elem)localObject).common_elem.has()) {
        break label87;
      }
      localCommonElem1 = (im_msg_body.CommonElem)((im_msg_body.Elem)localObject).common_elem.get();
      if (paramList == null) {
        break label417;
      }
      localCommonElem2 = localCommonElem1;
      localObject = paramList;
    }
    for (;;)
    {
      if (localCommonElem2 != null) {
        break label128;
      }
      return;
      label87:
      if (!((im_msg_body.Elem)localObject).text.has()) {
        break label414;
      }
      paramList = (im_msg_body.Text)((im_msg_body.Elem)localObject).text.get();
      if (localCommonElem1 == null) {
        break;
      }
      localObject = paramList;
      localCommonElem2 = localCommonElem1;
    }
    label128:
    label414:
    label417:
    for (;;)
    {
      break;
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("elemType:TroopStory;\n");
      }
      for (paramList = new hummer_commelem.MsgElemInfo_servtype16();; paramList = ((im_msg_body.Text)localObject).str.get().toStringUtf8()) {
        try
        {
          paramList.mergeFrom(localCommonElem2.bytes_pb_elem.get().toByteArray());
          int i = paramList.ctr_version.get();
          if (i > 1) {
            break;
          }
          paramStringBuilder = (MessageForTroopStory)anbi.d(-2057);
          paramStringBuilder.uid = paramList.uid.get();
          paramStringBuilder.unionId = paramList.unionID.get().toStringUtf8();
          paramStringBuilder.storyId = paramList.storyID.get().toStringUtf8();
          paramStringBuilder.md5 = paramList.md5.get().toStringUtf8();
          paramStringBuilder.thumbUrl = paramList.thumbUrl.get().toStringUtf8();
          paramStringBuilder.doodleUrl = paramList.doodleUrl.get().toStringUtf8();
          paramStringBuilder.videoWidth = paramList.videoWidth.get();
          paramStringBuilder.videoHeight = paramList.videoHeight.get();
          paramStringBuilder.sourceName = paramList.sourceName.get().toStringUtf8();
          paramStringBuilder.sourceActionType = paramList.sourceActionType.get().toStringUtf8();
          paramStringBuilder.sourceActionData = paramList.sourceActionData.get().toStringUtf8();
          if (localObject == null)
          {
            paramList = "";
            paramStringBuilder.compatibleText = paramList;
            paramStringBuilder.ctrVersion = i;
            paramStringBuilder.msg = MessageForTroopStory.MSG_CONTENT;
            paramStringBuilder.serial();
            paramList1.add(paramStringBuilder);
            if (!QLog.isDevelopLevel()) {
              break;
            }
            QLog.d("TroopStory", 4, paramStringBuilder.toDebugString());
            return;
          }
        }
        catch (InvalidProtocolBufferMicroException paramList)
        {
          paramList.printStackTrace();
          return;
        }
      }
    }
  }
  
  public void g(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, aozx paramaozx)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DecodeMsg", 2, "begin decodePBMsgElems_RichMsg");
    }
    Object localObject6 = null;
    Object localObject9 = paramList.iterator();
    Object localObject5 = null;
    Object localObject3 = null;
    Object localObject7;
    if (((Iterator)localObject9).hasNext())
    {
      localObject7 = (im_msg_body.Elem)((Iterator)localObject9).next();
      if (!((im_msg_body.Elem)localObject7).rich_msg.has()) {
        break label5010;
      }
    }
    label285:
    label1334:
    Object localObject4;
    label917:
    label2348:
    label2610:
    Object localObject2;
    label1416:
    label5010:
    for (Object localObject1 = (im_msg_body.RichMsg)((im_msg_body.Elem)localObject7).rich_msg.get();; localObject2 = localObject4)
    {
      if (((im_msg_body.Elem)localObject7).general_flags.has()) {}
      for (localObject3 = (im_msg_body.GeneralFlags)((im_msg_body.Elem)localObject7).general_flags.get();; localObject4 = localObject5)
      {
        if (((im_msg_body.Elem)localObject7).text.has()) {}
        label4387:
        for (localObject5 = (im_msg_body.Text)((im_msg_body.Elem)localObject7).text.get();; localObject5 = localObject6)
        {
          localObject7 = localObject3;
          localObject3 = localObject1;
          localObject6 = localObject5;
          localObject5 = localObject7;
          break;
          if (localObject3 == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("DecodeMsg", 2, "richMsg is null");
            }
            return;
          }
          if (QLog.isColorLevel()) {
            paramStringBuilder.append("elemType:RichMsg;\n");
          }
          int i = 0;
          int k = i;
          if (localObject5 != null)
          {
            k = i;
            if (((im_msg_body.GeneralFlags)localObject5).long_text_flag.get() == 1)
            {
              i = 1;
              k = i;
              if (QLog.isColorLevel())
              {
                QLog.d("DecodeMsg", 2, "decodePBMsgElems_RichMsg, longTextFlag: true");
                k = i;
              }
            }
          }
          if (((im_msg_body.RichMsg)localObject3).bytes_template_1.has()) {}
          label2604:
          label4949:
          for (localObject1 = ((im_msg_body.RichMsg)localObject3).bytes_template_1.get().toByteArray();; localObject2 = null)
          {
            long l1;
            MessageForStructing localMessageForStructing;
            long l3;
            int m;
            long l2;
            if (paramMsg.msg_head.from_uin.has())
            {
              l1 = paramMsg.msg_head.from_uin.get();
              localMessageForStructing = new MessageForStructing();
              localMessageForStructing.msgtype = -2011;
              l3 = paramMsg.msg_head.to_uin.get();
              m = paramMsg.msg_head.msg_type.get();
              if (m != 82)
              {
                l2 = l3;
                if (m != 43) {}
              }
              else
              {
                l2 = l3;
                if (paramMsg.msg_head.group_info != null)
                {
                  l2 = l3;
                  if (paramMsg.msg_head.group_info.group_code.has()) {
                    l2 = paramMsg.msg_head.group_info.group_code.get();
                  }
                }
              }
              localObject3 = ((im_msg_body.RichMsg)localObject3).bytes_msg_resid.get();
              if (localObject3 == null) {
                break label4982;
              }
            }
            label4447:
            label4974:
            label4982:
            for (localObject9 = ((ByteStringMicro)localObject3).toStringUtf8();; localObject9 = "")
            {
              Object localObject10;
              if (!aqmr.isEmpty((String)localObject9))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("DecodeMsg", 2, new Object[] { "decodePBMsgElems_RichMsg longMsgResId=", localObject9 });
                }
                localObject3 = "";
                localObject10 = paramList.iterator();
                do
                {
                  localObject7 = localObject3;
                  if (!((Iterator)localObject10).hasNext()) {
                    break;
                  }
                  localObject7 = (im_msg_body.Elem)((Iterator)localObject10).next();
                } while (!((im_msg_body.Elem)localObject7).pub_acc_info.has());
                if (((im_msg_body.Elem)localObject7).pub_acc_info.string_long_msg_url.get() != null) {
                  localObject3 = ((im_msg_body.Elem)localObject7).pub_acc_info.string_long_msg_url.get();
                }
                localObject10 = ((im_msg_body.Elem)localObject7).pub_acc_info.bytes_download_key.get();
                localObject7 = localObject3;
                if (localObject10 == null) {
                  break label4974;
                }
                localObject10 = StructLongMessageDownloadProcessor.bytesToHexString(((ByteStringMicro)localObject10).toByteArray());
                localObject7 = localObject3;
              }
              for (localObject3 = localObject10;; localObject4 = "")
              {
                if ((!aqmr.isEmpty((String)localObject7)) && (!aqmr.isEmpty((String)localObject3)) && (!aqmr.isEmpty((String)localObject9)))
                {
                  localMessageForStructing.saveExtInfoToExtStr("pub_long_msg_url", (String)localObject7);
                  localMessageForStructing.saveExtInfoToExtStr("pub_long_msg_download_key", (String)localObject3);
                  localMessageForStructing.saveExtInfoToExtStr("pub_long_msg_resid", (String)localObject9);
                }
                for (boolean bool = true;; bool = false) {
                  for (;;)
                  {
                    localObject3 = ancb.a(paramMsg, this.app);
                    if ((((anbm)localObject3).friendType == 1008) && (QLog.isColorLevel()))
                    {
                      localObject7 = new StringBuilder().append("msgId=").append(localMessageForStructing.uniseq).append(", serviceType(Pa-129,140,142):").append(((msg_comm.C2CTmpMsgHead)((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_tmp_msg_head.get()).service_type.get()).append(", xmlContentLength:");
                      if (localObject1 == null)
                      {
                        i = 0;
                        QLog.d("PaOldLongMsg", 2, i + ", longMsgResId:" + (String)localObject9 + ", isPaNewLongMsg:" + bool);
                      }
                    }
                    else if ((localObject5 == null) || (!((im_msg_body.GeneralFlags)localObject5).babyq_guide_msg_cookie.has())) {}
                    try
                    {
                      localObject7 = ((im_msg_body.GeneralFlags)localObject5).babyq_guide_msg_cookie.get().toByteArray();
                      localObject10 = aqft.bytesToHexString((byte[])localObject7);
                      if (QLog.isColorLevel()) {
                        QLog.d("DecodeMsg", 2, "decodePBMsgElems_RichMsg, guideMsgCookie: " + (String)localObject10 + " ,byte: " + Arrays.toString(((im_msg_body.GeneralFlags)localObject5).babyq_guide_msg_cookie.get().toByteArray()));
                      }
                      localMessageForStructing.saveExtInfoToExtStr("guide_msg_cookie", (String)localObject10);
                      ((acbs)this.app.getBusinessHandler(53)).au((byte[])localObject7);
                      if (bool)
                      {
                        if (QLog.isColorLevel()) {
                          QLog.d("DecodeMsg", 2, "begin getEmptyGeneralStructMsg");
                        }
                        localMessageForStructing.structingMsg = ((StructMsgForGeneralShare)anre.b());
                        if (localMessageForStructing.structingMsg == null) {
                          break label2562;
                        }
                        if (!(localMessageForStructing.structingMsg instanceof StructMsgForGeneralShare)) {
                          break label1416;
                        }
                        localObject3 = ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mWarningTips;
                        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                          localMessageForStructing.saveExtInfoToExtStr("pa_phone_msg_tip", (String)localObject3);
                        }
                        if (((StructMsgForGeneralShare)localMessageForStructing.structingMsg).isPayMessage()) {
                          localMessageForStructing.saveExtInfoToExtStr("pa_pay_message", "1");
                        }
                        localObject3 = ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mPARedPacket;
                        if (TextUtils.isEmpty((CharSequence)localObject3)) {
                          break label1334;
                        }
                        localObject3 = a((String)localObject3, this.c.app.getCurrentAccountUin());
                        if (localObject3 == null) {
                          break label1334;
                        }
                        paramList1.add(localObject3);
                        return;
                        l1 = 0L;
                        break label285;
                        i = localObject1.length;
                      }
                    }
                    catch (Exception localException2)
                    {
                      for (;;)
                      {
                        if (QLog.isColorLevel())
                        {
                          QLog.d("DecodeMsg", 2, "get richmsg guideMsgCookie error!", localException2);
                          continue;
                          if ((localObject1 == null) || (localObject1.length == 0))
                          {
                            if ((((anbm)localObject3).friendType == 1008) && (!TextUtils.isEmpty((CharSequence)localObject9)))
                            {
                              if (QLog.isColorLevel()) {
                                QLog.d("PaOldLongMsg", 2, "msgId=" + localMessageForStructing.uniseq + ", begin getEmptyGeneralStructMsg for PA oldLongMsg!");
                              }
                              localMessageForStructing.structingMsg = ((StructMsgForGeneralShare)anre.b());
                              localMessageForStructing.saveExtInfoToExtStr("pub_old_long_msg", "1");
                              localMessageForStructing.saveExtInfoToExtStr("pub_long_msg_resid", (String)localObject9);
                              localMessageForStructing.saveExtInfoToExtStr("longMsg_State", String.valueOf(1));
                            }
                          }
                          else
                          {
                            if (QLog.isColorLevel()) {
                              QLog.d("DecodeMsg", 2, new Object[] { "begin getStructMsgFromXmlBuff: type=", Integer.valueOf(m), ", code=", Long.valueOf(l2) });
                            }
                            localObject3 = aqnl.a((byte[])localObject1, (im_msg_body.GeneralFlags)localObject5, -1);
                            if (localObject3 != null) {
                              i = 0;
                            }
                            for (;;)
                            {
                              localMessageForStructing.structingMsg = anre.a(this.c.app, m, l2, (byte[])localObject3, i);
                              localObject1 = localObject3;
                              if (!QLog.isColorLevel()) {
                                break label917;
                              }
                              QLog.d("StructMsg", 2, "StructMsg = " + localMessageForStructing.structingMsg);
                              localObject1 = localObject3;
                              break label917;
                              if (localMessageForStructing.structingMsg.mMsgServiceID == 74)
                              {
                                localObject3 = ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mVipDonateStr;
                                if (!TextUtils.isEmpty((CharSequence)localObject3))
                                {
                                  bool = false;
                                  if (String.valueOf(l1).equals(this.app.getCurrentAccountUin())) {
                                    bool = true;
                                  }
                                  localObject3 = a((String)localObject3, bool);
                                  if (localObject3 != null)
                                  {
                                    paramList1.add(localObject3);
                                    return;
                                  }
                                }
                              }
                              int j = 0;
                              i = j;
                              if (paramMsg.msg_head.c2c_tmp_msg_head.service_type.has())
                              {
                                int n = paramMsg.msg_head.c2c_tmp_msg_head.service_type.get();
                                if ((n != 129) && (n != 140))
                                {
                                  i = j;
                                  if (n != 142) {}
                                }
                                else
                                {
                                  i = 1;
                                }
                              }
                              Object localObject8;
                              if ((i != 0) || (localMessageForStructing.structingMsg.sourceAccoutType != 0))
                              {
                                localMessageForStructing.saveExtInfoToExtStr("accostType", String.valueOf(AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA));
                                if ((TextUtils.isEmpty(localMessageForStructing.structingMsg.mMsgBrief)) || (localMessageForStructing.structingMsg.mEmptyMsgBriefModified)) {
                                  localMessageForStructing.structingMsg.mMsgBrief = AbsStructMsg.PA_DEFAULT_MSG_BRIEF;
                                }
                                if ((localObject5 != null) && (((im_msg_body.GeneralFlags)localObject5).bytes_pb_reserve.has())) {
                                  try
                                  {
                                    localObject3 = new generalflags.ResvAttr();
                                    ((generalflags.ResvAttr)localObject3).mergeFrom(((im_msg_body.GeneralFlags)localObject5).bytes_pb_reserve.get().toByteArray());
                                    if ((((generalflags.ResvAttr)localObject3).bytes_oac_msg_extend.has()) && (((generalflags.ResvAttr)localObject3).bytes_oac_msg_extend.get() != null))
                                    {
                                      localObject3 = new JSONObject(new JSONObject(((generalflags.ResvAttr)localObject3).bytes_oac_msg_extend.get().toStringUtf8()).optString("money_extra"));
                                      if ((localObject3 != null) && (((JSONObject)localObject3).optInt("gdt_flg") == 1))
                                      {
                                        localObject3 = ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).getStructMsgItemLists();
                                        if ((localObject3 != null) && (((List)localObject3).size() > 0)) {
                                          localObject8 = ((List)localObject3).iterator();
                                        }
                                      }
                                    }
                                    while (((Iterator)localObject8).hasNext()) {
                                      if (((anqu)((Iterator)localObject8).next() instanceof antu))
                                      {
                                        ((Iterator)localObject8).remove();
                                        continue;
                                        localObject4 = paramList.iterator();
                                      }
                                    }
                                  }
                                  catch (Throwable localThrowable)
                                  {
                                    QLog.e("DecodeMsg", 1, "parse wallet ad tail fail: ", localThrowable);
                                  }
                                }
                              }
                              while (((Iterator)localObject4).hasNext())
                              {
                                localObject8 = (im_msg_body.Elem)((Iterator)localObject4).next();
                                if ((((im_msg_body.Elem)localObject8).life_online.has()) && (((im_msg_body.LifeOnlineAccount)((im_msg_body.Elem)localObject8).life_online.get()).uint32_report.has()) && (((im_msg_body.LifeOnlineAccount)((im_msg_body.Elem)localObject8).life_online.get()).uint32_report.get() == 1) && (((im_msg_body.LifeOnlineAccount)((im_msg_body.Elem)localObject8).life_online.get()).uint64_unique_id.has()))
                                {
                                  localMessageForStructing.structingMsg.msgId = ((im_msg_body.LifeOnlineAccount)((im_msg_body.Elem)localObject8).life_online.get()).uint64_unique_id.get();
                                  continue;
                                  localObject8 = anrd.a(0);
                                  ((anqv)localObject8).a(new anst());
                                  ((anqv)localObject8).e = localMessageForStructing.structingMsg;
                                  ((List)localObject4).add(localObject8);
                                  localObject8 = anrd.a(31);
                                  ((anqv)localObject8).e = localMessageForStructing.structingMsg;
                                  ((List)localObject4).add(localObject8);
                                  localMessageForStructing.saveExtInfoToExtStr("wallet_ad_msg", "1");
                                }
                              }
                              if (QLog.isColorLevel()) {
                                QLog.d("DecodeMsg", 2, "decodePBMsgElems_RichMsg serviceId" + localMessageForStructing.structingMsg.mMsgServiceID);
                              }
                              if (localMessageForStructing.structingMsg.mMsgServiceID == 37) {
                                break;
                              }
                              if (localMessageForStructing.structingMsg.mMsgServiceID == 499)
                              {
                                paramList = (MessageForTroopFee)anbi.d(-2036);
                                paramStringBuilder = MessageForTroopFee.decodeMsgFromXmlBuff(this.c.app, m, l2, (byte[])localObject1, -1);
                                if (paramStringBuilder != null) {
                                  paramList.copyFrom(paramStringBuilder);
                                }
                                paramList.msgtype = -2036;
                                paramList.msg = paramList.getSummaryMsg();
                                paramList.msgData = paramList.getBytes();
                                paramList1.add(paramList);
                                localMessageForStructing.structingMsg = null;
                                if (!QLog.isColorLevel()) {
                                  break;
                                }
                                QLog.d(".troop.troop_fee", 2, "Troop Fee has decode suceess" + paramList.getSummaryMsg());
                                return;
                              }
                              if (localMessageForStructing.structingMsg.mMsgServiceID == 52)
                              {
                                if (QLog.isColorLevel()) {
                                  QLog.d(acie.class.getSimpleName(), 2, "Received flower message");
                                }
                                localObject1 = NearbyFlowerMessage.getFlowerMsgVersion(localMessageForStructing);
                                if ((!"1".equals(localObject1)) && (!"2".equals(localObject1)))
                                {
                                  l3 = l1;
                                  if (!"3".equals(localObject1)) {}
                                }
                                else
                                {
                                  localObject1 = (msg_comm.GroupInfo)paramMsg.msg_head.group_info.get();
                                  if (localObject1 == null) {
                                    break label4949;
                                  }
                                }
                              }
                              for (l2 = ((msg_comm.GroupInfo)localObject1).group_code.get();; l2 = 0L)
                              {
                                if (QLog.isColorLevel()) {
                                  QLog.i(acie.class.getSimpleName(), 2, "decodePBMsgElems, groupCode:" + l2);
                                }
                                l3 = l1;
                                if (l2 <= 0L)
                                {
                                  if (!paramMsg.msg_head.from_uin.has()) {
                                    break label2604;
                                  }
                                  l1 = paramMsg.msg_head.from_uin.get();
                                  if (!paramMsg.msg_head.to_uin.has()) {
                                    break label2610;
                                  }
                                  l2 = paramMsg.msg_head.to_uin.get();
                                  paramList1.add(((acie)this.c.app.getManager(124)).a(Long.toString(l1), Long.toString(l2), localMessageForStructing.istroop, localMessageForStructing.structingMsg));
                                  l3 = l1;
                                }
                                do
                                {
                                  for (;;)
                                  {
                                    if (((2171946401L == l3) || (2173223560L == l3) || (2062433139L == l3) || (3434959637L == l3)) && ((localMessageForStructing.structingMsg instanceof AbsShareMsg)))
                                    {
                                      if (2171946401L == l3) {
                                        ocp.a(this.app, localMessageForStructing, 11);
                                      }
                                      ((AbsShareMsg)localMessageForStructing.structingMsg).clearItems();
                                      localMessageForStructing.extInt = 1;
                                      localMessageForStructing.extLong = 1;
                                      if (QLog.isColorLevel()) {
                                        QLog.d("DecodeMsg", 2, "decode structMsg form XIN_KANDIAN, items = " + ((AbsShareMsg)localMessageForStructing.structingMsg).getStructMsgItemLists().size());
                                      }
                                    }
                                    localMessageForStructing.structingMsg.mCompatibleText = a(paramList, paramList1, false);
                                    localMessageForStructing.msgData = localMessageForStructing.structingMsg.getBytes();
                                    localMessageForStructing.msg = "richMsg";
                                    if (localMessageForStructing.structingMsg != null) {
                                      break label4447;
                                    }
                                    if (QLog.isColorLevel()) {
                                      paramStringBuilder.append("c2cMsgContent.data:null;\n");
                                    }
                                    i(paramList, paramList1, paramStringBuilder, paramMsg, paramaozx);
                                    return;
                                    l1 = 0L;
                                    break;
                                    l2 = 0L;
                                    break label2348;
                                    if ((localMessageForStructing.structingMsg.mMsgServiceID == 80) && ((localMessageForStructing.structingMsg instanceof StructMsgForGeneralShare)))
                                    {
                                      if (pmb.Ir())
                                      {
                                        paramList = (MessageForQQStory)anbi.d(-2051);
                                        paramList.msgtype = -2051;
                                        paramStringBuilder = (StructMsgForGeneralShare)localMessageForStructing.structingMsg;
                                        if ((TextUtils.isEmpty(paramStringBuilder.mCompatibleText)) && (localObject6 != null) && (((im_msg_body.Text)localObject6).str.has())) {
                                          paramStringBuilder.mCompatibleText = ((im_msg_body.Text)localObject6).str.get().toStringUtf8();
                                        }
                                        paramList.structingMsg = paramStringBuilder;
                                        paramList.doPrewrite();
                                        if (TextUtils.isEmpty(paramStringBuilder.mCompatibleText))
                                        {
                                          paramList.doParse();
                                          paramStringBuilder.mCompatibleText = MessageForQQStory.buildCompatibleText(paramList.authorName, paramList.brief, paramList.srcName);
                                          paramList.doPrewrite();
                                          if (QLog.isColorLevel()) {
                                            QLog.d("Q.qqstory.share", 2, "recv storyMsg, mCompatibleText isEmpty, rebuild:" + paramStringBuilder.mCompatibleText);
                                          }
                                        }
                                        paramList1.add(paramList);
                                        localMessageForStructing.structingMsg = null;
                                        return;
                                      }
                                      localMessageForStructing.structingMsg = null;
                                      if (localObject6 != null)
                                      {
                                        ((im_msg_body.Text)localObject6).str.set(ByteStringMicro.copyFromUtf8(pmb.mj()));
                                        return;
                                      }
                                      l3 = l1;
                                      if (QLog.isColorLevel())
                                      {
                                        QLog.d("Q.qqstory.share", 2, "recv storyMsg, isSDKAPISupportStory==false, txtMsg==null");
                                        l3 = l1;
                                      }
                                    }
                                    else
                                    {
                                      if ((localMessageForStructing.structingMsg.mMsgServiceID == 118) && ((localMessageForStructing.structingMsg instanceof StructMsgForGeneralShare)))
                                      {
                                        paramList = (MessageForTribeShortVideo)anbi.d(-7002);
                                        paramList.msgtype = -7002;
                                        paramStringBuilder = (StructMsgForGeneralShare)localMessageForStructing.structingMsg;
                                        if ((TextUtils.isEmpty(paramStringBuilder.mCompatibleText)) && (localObject6 != null) && (((im_msg_body.Text)localObject6).str.has())) {
                                          paramStringBuilder.mCompatibleText = ((im_msg_body.Text)localObject6).str.get().toStringUtf8();
                                        }
                                        paramList.structingMsg = paramStringBuilder;
                                        paramList.doPrewrite();
                                        if (TextUtils.isEmpty(paramStringBuilder.mCompatibleText))
                                        {
                                          paramList.doParse();
                                          paramStringBuilder.mCompatibleText = MessageForTribeShortVideo.buildCompatibleText();
                                          paramList.doPrewrite();
                                          if (QLog.isColorLevel()) {
                                            QLog.d("DecodeMsg", 2, "recv shortVideoMsg, mCompatibleText isEmpty, rebuild:" + paramStringBuilder.mCompatibleText);
                                          }
                                        }
                                        paramList1.add(paramList);
                                        localMessageForStructing.structingMsg = null;
                                        return;
                                      }
                                      if ((localMessageForStructing.structingMsg.mMsgServiceID == 104) && ((localMessageForStructing.structingMsg instanceof StructMsgForGeneralShare)))
                                      {
                                        paramList = (MessageForTroopPobing)anbi.d(-2059);
                                        paramList.msgtype = -2059;
                                        paramList1 = (StructMsgForGeneralShare)localMessageForStructing.structingMsg;
                                        if ((TextUtils.isEmpty(paramList1.mCompatibleText)) && (localObject6 != null) && (((im_msg_body.Text)localObject6).str.has())) {
                                          paramList1.mCompatibleText = ((im_msg_body.Text)localObject6).str.get().toStringUtf8();
                                        }
                                        if ((localObject5 != null) && (((im_msg_body.GeneralFlags)localObject5).bytes_pb_reserve.has())) {}
                                        try
                                        {
                                          paramStringBuilder = new generalflags.ResvAttr();
                                          paramStringBuilder.mergeFrom(((im_msg_body.GeneralFlags)localObject5).bytes_pb_reserve.get().toByteArray());
                                          if ((paramStringBuilder.uint32_troop_pobing_template.has()) && (paramStringBuilder.uint32_troop_pobing_template.get() > 0)) {
                                            paramList1.pobingTemplateId = paramStringBuilder.uint32_troop_pobing_template.get();
                                          }
                                          if (QLog.isColorLevel()) {
                                            QLog.d("DecodeMsg", 2, "uint32_troop_pobing_template: " + paramList1.pobingTemplateId);
                                          }
                                          paramList.structingMsg = paramList1;
                                          paramList.doPrewrite();
                                          paramList.doParse();
                                          if (TextUtils.isEmpty(paramList1.mCompatibleText))
                                          {
                                            paramList.doParse();
                                            paramList1.mCompatibleText = MessageForTroopPobing.buildCompatibleText();
                                            paramList.doPrewrite();
                                            if (QLog.isColorLevel()) {
                                              QLog.d("Q.qqstory.share", 2, "recv storyMsg, mCompatibleText isEmpty, rebuild:" + paramList1.mCompatibleText);
                                            }
                                          }
                                          localMessageForStructing.structingMsg = null;
                                          new anov(this.app).a("dc00899").b("Grp_AIO").c("newman_join").d("exp_obj").a(new String[] { l2 + "" }).report();
                                          new anov(this.app).a("dc00899").b("Grp_AIO").c("newman_join").d("exp_welcome").a(new String[] { l2 + "", "", "" + apuh.o(this.app, String.valueOf(l2)) }).report();
                                          return;
                                        }
                                        catch (InvalidProtocolBufferMicroException paramStringBuilder)
                                        {
                                          for (;;)
                                          {
                                            QLog.e("DecodeMsg", 1, "decode uint32_troop_pobing_template fail: ", paramStringBuilder);
                                          }
                                        }
                                      }
                                      if ((localMessageForStructing.structingMsg.mMsgServiceID == 90) && ((localMessageForStructing.structingMsg instanceof StructMsgForGeneralShare)))
                                      {
                                        paramList = (MessageForTroopSign)anbi.d(-2054);
                                        paramList.msgtype = -2054;
                                        paramStringBuilder = (StructMsgForGeneralShare)localMessageForStructing.structingMsg;
                                        paramList.structingMsg = paramStringBuilder;
                                        paramList.msg = paramStringBuilder.mMsgBrief;
                                        paramList.doPrewrite();
                                        paramList1.add(paramList);
                                        localMessageForStructing.structingMsg = null;
                                        return;
                                      }
                                      l3 = l1;
                                      if (localMessageForStructing.structingMsg.mMsgServiceID != 43)
                                      {
                                        if (((localMessageForStructing.structingMsg.mMsgServiceID == 83) || (localMessageForStructing.structingMsg.mMsgServiceID == 108) || (localMessageForStructing.structingMsg.mMsgServiceID == 114) || (localMessageForStructing.structingMsg.mMsgServiceID == 116)) && (!TextUtils.isEmpty(localMessageForStructing.structingMsg.mMsgActionData)))
                                        {
                                          localObject4 = "";
                                          localObject1 = localObject4;
                                          if (!TextUtils.isEmpty(localMessageForStructing.structingMsg.mMsgUrl)) {
                                            localObject1 = Uri.parse(localMessageForStructing.structingMsg.mMsgUrl);
                                          }
                                          try
                                          {
                                            localObject1 = ((Uri)localObject1).getQueryParameter("article_id");
                                            localObject4 = localObject1;
                                          }
                                          catch (Exception localException1)
                                          {
                                            for (;;)
                                            {
                                              localException1.printStackTrace();
                                            }
                                          }
                                          localObject1 = localObject4;
                                          if (localObject4 == null) {
                                            localObject1 = "";
                                          }
                                          kbp.a(null, "", "0X8007238", "0X8007238", 0, 0, (String)localObject1, "", "", "");
                                          kbp.d("0X8007238", "", (String)localObject1, "", "", "");
                                          localMessageForStructing.structingMsg.mMsgActionData = nk(localMessageForStructing.structingMsg.mMsgActionData);
                                          l3 = l1;
                                          continue;
                                        }
                                        if (((localMessageForStructing.structingMsg.mMsgServiceID == 5) || (localMessageForStructing.structingMsg.mMsgServiceID == 137)) && ((localMessageForStructing.structingMsg instanceof StructMsgForImageShare)))
                                        {
                                          localObject4 = paramList.iterator();
                                          do
                                          {
                                            for (;;)
                                            {
                                              l3 = l1;
                                              if (!((Iterator)localObject4).hasNext()) {
                                                break;
                                              }
                                              im_msg_body.Elem localElem = (im_msg_body.Elem)((Iterator)localObject4).next();
                                              if (!localElem.not_online_image.has()) {
                                                break label4096;
                                              }
                                              localObject6 = (im_msg_body.NotOnlineImage)localElem.not_online_image.get();
                                              localObject4 = (StructMsgForImageShare)localMessageForStructing.structingMsg;
                                              ((StructMsgForImageShare)localObject4).thumbHeight = ((im_msg_body.NotOnlineImage)localObject6).uint32_thumb_height.get();
                                              ((StructMsgForImageShare)localObject4).thumbWidth = ((im_msg_body.NotOnlineImage)localObject6).uint32_thumb_width.get();
                                              ((StructMsgForImageShare)localObject4).width = ((im_msg_body.NotOnlineImage)localObject6).pic_width.get();
                                              ((StructMsgForImageShare)localObject4).height = ((im_msg_body.NotOnlineImage)localObject6).pic_height.get();
                                              ((StructMsgForImageShare)localObject4).thumbUrl = ((im_msg_body.NotOnlineImage)localObject6).str_thumb_url.get();
                                              ((StructMsgForImageShare)localObject4).bigUrl = ((im_msg_body.NotOnlineImage)localObject6).str_big_url.get();
                                              ((StructMsgForImageShare)localObject4).rawUrl = ((im_msg_body.NotOnlineImage)localObject6).str_orig_url.get();
                                              l3 = l1;
                                              if (!localElem.not_online_image.bytes_pb_reserve.has()) {
                                                break;
                                              }
                                              try
                                              {
                                                localObject6 = new NotOnlineImageExtPb.ResvAttr();
                                                ((NotOnlineImageExtPb.ResvAttr)localObject6).mergeFrom(localElem.not_online_image.bytes_pb_reserve.get().toByteArray());
                                                ((StructMsgForImageShare)localObject4).mImageBizType = ((NotOnlineImageExtPb.ResvAttr)localObject6).uint32_image_biz_type.get();
                                                l3 = l1;
                                              }
                                              catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
                                              {
                                                localInvalidProtocolBufferMicroException1.printStackTrace();
                                                l3 = l1;
                                              }
                                            }
                                            break;
                                          } while (!localInvalidProtocolBufferMicroException1.custom_face.has());
                                          localObject6 = (im_msg_body.CustomFace)localInvalidProtocolBufferMicroException1.custom_face.get();
                                          localObject4 = (StructMsgForImageShare)localMessageForStructing.structingMsg;
                                          ((StructMsgForImageShare)localObject4).thumbHeight = ((im_msg_body.CustomFace)localObject6).uint32_thumb_height.get();
                                          ((StructMsgForImageShare)localObject4).thumbWidth = ((im_msg_body.CustomFace)localObject6).uint32_thumb_width.get();
                                          ((StructMsgForImageShare)localObject4).width = ((im_msg_body.CustomFace)localObject6).uint32_width.get();
                                          ((StructMsgForImageShare)localObject4).height = ((im_msg_body.CustomFace)localObject6).uint32_height.get();
                                          ((StructMsgForImageShare)localObject4).rawUrl = ((im_msg_body.CustomFace)localObject6).str_orig_url.get();
                                          ((StructMsgForImageShare)localObject4).thumbUrl = ((im_msg_body.CustomFace)localObject6).str_thumb_url.get();
                                          ((StructMsgForImageShare)localObject4).bigUrl = ((im_msg_body.CustomFace)localObject6).str_big_url.get();
                                          ((StructMsgForImageShare)localObject4).rawUrl = ((im_msg_body.CustomFace)localObject6).str_orig_url.get();
                                          l3 = l1;
                                          if (localInvalidProtocolBufferMicroException1.custom_face.bytes_pb_reserve.has()) {
                                            try
                                            {
                                              localObject6 = new CustomFaceExtPb.ResvAttr();
                                              ((CustomFaceExtPb.ResvAttr)localObject6).mergeFrom(localInvalidProtocolBufferMicroException1.custom_face.bytes_pb_reserve.get().toByteArray());
                                              ((StructMsgForImageShare)localObject4).mImageBizType = ((CustomFaceExtPb.ResvAttr)localObject6).uint32_image_biz_type.get();
                                              l3 = l1;
                                            }
                                            catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
                                            {
                                              localInvalidProtocolBufferMicroException2.printStackTrace();
                                              l3 = l1;
                                            }
                                          }
                                        }
                                        else
                                        {
                                          if (localMessageForStructing.structingMsg.mMsgServiceID != 106) {
                                            break label4387;
                                          }
                                          l3 = l1;
                                          if ((localMessageForStructing.structingMsg instanceof StructMsgForGeneralShare))
                                          {
                                            localObject2 = (StructMsgForGeneralShare)localMessageForStructing.structingMsg;
                                            localObject4 = ((StructMsgForGeneralShare)localObject2).animResId;
                                            apot.a().a((String)localObject4, null);
                                            apot.a().Tt(((StructMsgForGeneralShare)localObject2).atMembers);
                                            l3 = l1;
                                          }
                                        }
                                      }
                                    }
                                  }
                                  l3 = l1;
                                } while (localMessageForStructing.structingMsg.mMsgServiceID != 126);
                                paramList = MessageForStarLeague.decodeMsgFromXmlBuff(this.c.app, m, l2, (byte[])localObject2, -1);
                                paramList.msgData = paramList.getBytes();
                                paramList.msg = paramList.getSummaryMsg();
                                paramList1.add(paramList);
                                return;
                                j = 0;
                                m = 0;
                                paramStringBuilder = null;
                                paramMsg = null;
                                paramList = paramStringBuilder;
                                i = j;
                                if (localObject5 != null)
                                {
                                  paramList = paramStringBuilder;
                                  i = j;
                                  if (!((im_msg_body.GeneralFlags)localObject5).bytes_pb_reserve.has()) {}
                                }
                                try
                                {
                                  paramaozx = new generalflags.ResvAttr();
                                  paramaozx.mergeFrom(((im_msg_body.GeneralFlags)localObject5).bytes_pb_reserve.get().toByteArray());
                                  paramStringBuilder = paramMsg;
                                  j = m;
                                  if (paramaozx.bytes_kpl_info.has())
                                  {
                                    paramStringBuilder = paramMsg;
                                    j = m;
                                    if (paramaozx.bytes_kpl_info.has())
                                    {
                                      j = 1;
                                      paramStringBuilder = paramaozx.bytes_kpl_info.get().toStringUtf8();
                                    }
                                  }
                                  paramList = paramStringBuilder;
                                  i = j;
                                  if (paramaozx.bytes_oac_msg_extend.has())
                                  {
                                    localMessageForStructing.saveExtInfoToExtStr("report_key_bytes_oac_msg_extend", paramaozx.bytes_oac_msg_extend.get().toStringUtf8());
                                    i = j;
                                    paramList = paramStringBuilder;
                                  }
                                }
                                catch (Exception paramList)
                                {
                                  for (;;)
                                  {
                                    if (QLog.isColorLevel()) {
                                      QLog.d("KplMessage", 2, "parse proto catch exception about kpl");
                                    }
                                    paramList.printStackTrace();
                                    i = 0;
                                    paramList = null;
                                  }
                                  paramList1.add(paramList);
                                  return;
                                }
                                if (i != 0)
                                {
                                  localMessageForStructing.saveExtInfoToExtStr("msg_ext_key", "Y");
                                  if (QLog.isColorLevel()) {
                                    QLog.d("KplMessage", 2, "resv a kpl struct message !");
                                  }
                                  KplRoleInfo.handleKplFlag(this.app, paramList);
                                }
                                if (k != 0)
                                {
                                  if (QLog.isColorLevel()) {
                                    QLog.d("DecodeMsg", 2, "decodePBMsgElems_RichMsg need to pull longtextmsg!");
                                  }
                                  try
                                  {
                                    if ((localMessageForStructing.structingMsg instanceof AbsShareMsg))
                                    {
                                      paramList = (ChatMessage)anbi.d(-1051);
                                      paramList.saveExtInfoToExtStr("long_text_recv_state", "3");
                                      paramList.saveExtInfoToExtStr("long_text_msg_resid", localMessageForStructing.structingMsg.mResid);
                                      paramStringBuilder = ((AbsShareMsg)localMessageForStructing.structingMsg).getStructMsgItemLists();
                                      if (paramStringBuilder != null)
                                      {
                                        paramStringBuilder = paramStringBuilder.iterator();
                                        for (;;)
                                        {
                                          if (paramStringBuilder.hasNext())
                                          {
                                            paramMsg = (anqu)paramStringBuilder.next();
                                            if ((paramMsg instanceof anqv))
                                            {
                                              paramMsg = ((anqv)paramMsg).rz;
                                              if (paramMsg != null)
                                              {
                                                paramMsg = paramMsg.iterator();
                                                if (paramMsg.hasNext())
                                                {
                                                  paramaozx = (anqu)paramMsg.next();
                                                  if (!(paramaozx instanceof StructMsgItemTitle)) {
                                                    break;
                                                  }
                                                  paramList.msg = ((StructMsgItemTitle)paramaozx).getText();
                                                  if (QLog.isDevelopLevel())
                                                  {
                                                    QLog.d("DecodeMsg", 2, "longtextmsg getMsg from structMsg msg:" + paramList.msg);
                                                    continue;
                                                    paramList1.add(localMessageForStructing);
                                                  }
                                                }
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                  catch (Exception paramList)
                                  {
                                    if (QLog.isColorLevel()) {
                                      QLog.d("DecodeMsg", 2, "failed to pull longtextmsg exception!", paramList);
                                    }
                                  }
                                }
                                for (;;)
                                {
                                  return;
                                  if (QLog.isColorLevel()) {
                                    QLog.d("DecodeMsg", 2, "absShareMsg is null");
                                  }
                                }
                              }
                              i = -1;
                              localObject4 = localObject2;
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void h(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder)
  {
    if (QLog.isColorLevel()) {
      paramStringBuilder.append("elemType:PokeMsg;\n");
    }
    paramList = paramList.iterator();
    do
    {
      if (!paramList.hasNext()) {
        break;
      }
      paramStringBuilder = (im_msg_body.Elem)paramList.next();
    } while (!paramStringBuilder.common_elem.has());
    for (paramList = (im_msg_body.CommonElem)paramStringBuilder.common_elem.get();; paramList = null)
    {
      if (paramList == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PokeMsg", 2, "decodePBMsgElems_PokeMsg null commomElem!");
        }
        return;
      }
      paramStringBuilder = new MessageForPoke();
      paramStringBuilder.msgtype = -5012;
      if (paramList.uint32_business_type.has()) {
        paramStringBuilder.interactType = paramList.uint32_business_type.get();
      }
      hummer_commelem.MsgElemInfo_servtype2 localMsgElemInfo_servtype2;
      if (paramList.bytes_pb_elem.has()) {
        localMsgElemInfo_servtype2 = new hummer_commelem.MsgElemInfo_servtype2();
      }
      for (;;)
      {
        try
        {
          localMsgElemInfo_servtype2.mergeFrom(paramList.bytes_pb_elem.get().toByteArray());
          paramStringBuilder.msg = localMsgElemInfo_servtype2.bytes_poke_summary.get().toStringUtf8();
          paramStringBuilder.doubleHitState = localMsgElemInfo_servtype2.uint32_double_hit.get();
          if (!localMsgElemInfo_servtype2.uint32_vaspoke_id.has()) {
            continue;
          }
          i = localMsgElemInfo_servtype2.uint32_vaspoke_id.get();
          paramStringBuilder.subId = i;
          if (!localMsgElemInfo_servtype2.bytes_vaspoke_name.has()) {
            continue;
          }
          paramList = localMsgElemInfo_servtype2.bytes_vaspoke_name.get().toStringUtf8();
          paramStringBuilder.name = paramList;
          if (!localMsgElemInfo_servtype2.bytes_vaspoke_minver.has()) {
            continue;
          }
          paramList = localMsgElemInfo_servtype2.bytes_vaspoke_minver.get().toStringUtf8();
          paramStringBuilder.minVersion = paramList;
          paramStringBuilder.strength = localMsgElemInfo_servtype2.uint32_poke_strength.get();
          if (!localMsgElemInfo_servtype2.uint32_poke_flag.has()) {
            continue;
          }
          i = localMsgElemInfo_servtype2.uint32_poke_flag.get();
          paramStringBuilder.flag = i;
          if (paramStringBuilder.interactType == 126) {
            VasWebviewUtil.reportCommercialDrainage("", "poke", "receive", "", 0, 0, 0, "", String.valueOf(paramStringBuilder.subId), "none", "", "", "", "", 0, 0, 0, 0);
          }
        }
        catch (Exception paramList)
        {
          int i;
          QLog.d("PokeMsg", 1, "decodePBMsgElems_PokeMsg exception!", paramList);
          continue;
        }
        paramList1.add(paramStringBuilder);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("PokeMsg", 2, "decodePbElems, common_elem type 2, interactType:" + paramStringBuilder.interactType + " ,doubleHitState:" + paramStringBuilder.doubleHitState);
        return;
        i = -1;
        continue;
        paramList = acfp.m(2131708231);
        continue;
        paramList = "";
        continue;
        i = 0;
      }
    }
  }
  
  public void h(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, aozx paramaozx)
  {
    Object localObject2 = null;
    Object localObject6 = paramList.iterator();
    Object localObject1 = null;
    Object localObject7;
    Object localObject3;
    if (((Iterator)localObject6).hasNext())
    {
      localObject7 = (im_msg_body.Elem)((Iterator)localObject6).next();
      localObject3 = localObject1;
      if (((im_msg_body.Elem)localObject7).group_pub_acc_info.has())
      {
        localObject3 = localObject1;
        if (((im_msg_body.Elem)localObject7).group_pub_acc_info.uint64_pub_account.has()) {
          localObject3 = (im_msg_body.GroupPubAccountInfo)((im_msg_body.Elem)localObject7).group_pub_acc_info.get();
        }
      }
      if (!((im_msg_body.Elem)localObject7).general_flags.has()) {
        break label896;
      }
    }
    label896:
    for (localObject1 = (im_msg_body.GeneralFlags)((im_msg_body.Elem)localObject7).general_flags.get();; localObject1 = localObject2)
    {
      localObject2 = localObject1;
      localObject1 = localObject3;
      break;
      if (localObject1 == null) {
        return;
      }
      long l1 = ((im_msg_body.GroupPubAccountInfo)localObject1).uint64_pub_account.get();
      localObject1 = null;
      int i = 0;
      localObject7 = (MessageForPubAccount)anbi.d(-3006);
      ((MessageForPubAccount)localObject7).msgtype = -3006;
      ((MessageForPubAccount)localObject7).associatePubAccUin = l1;
      StringBuilder localStringBuilder = new StringBuilder("");
      Iterator localIterator = paramList.iterator();
      label185:
      if (localIterator.hasNext())
      {
        localObject3 = (im_msg_body.Elem)localIterator.next();
        if ((((im_msg_body.Elem)localObject3).text.has()) && (((im_msg_body.Elem)localObject3).text.str.has()))
        {
          ((MessageForPubAccount)localObject7).msg = localStringBuilder.toString();
          localObject3 = new PAMessage();
          ((PAMessage)localObject3).msg = localStringBuilder.toString();
          ((MessageForPubAccount)localObject7).msgData = obj.a((PAMessage)localObject3);
        }
      }
      for (;;)
      {
        localObject1 = localObject3;
        break label185;
        if (((im_msg_body.Elem)localObject3).trans_elem_info.has())
        {
          localObject3 = (im_msg_body.TransElem)((im_msg_body.Elem)localObject3).trans_elem_info.get();
          int j = ((im_msg_body.TransElem)localObject3).elem_type.get();
          localObject3 = ((im_msg_body.TransElem)localObject3).elem_value.get().toByteArray();
          if (j != 16)
          {
            paramStringBuilder.append("PubAccount Message type is not 16.\n");
            break label185;
          }
          if ((localObject3 == null) || (localObject3.length == 0))
          {
            paramStringBuilder.append("transElemByte is null or transElemByte.length == 0\n");
            break label185;
          }
          if (localObject3[0] == 1)
          {
            i = aqoj.b((byte[])localObject3, 1);
            j = localObject3[3];
            localObject6 = new byte[i - 1];
            aqoj.copyData((byte[])localObject6, 0, (byte[])localObject3, 4, i - 1);
            localObject3 = localObject6;
            if (j == 1) {
              localObject3 = A((byte[])localObject6);
            }
            if (localObject3 == null) {}
          }
          for (;;)
          {
            try
            {
              for (;;)
              {
                if (localObject3.length > 0)
                {
                  localObject3 = new String((byte[])localObject3, "utf-8");
                  localStringBuilder.append((String)localObject3);
                  localObject3 = b((String)localObject3);
                  localObject1 = localObject3;
                  j = 1;
                  i = j;
                  localObject3 = localObject1;
                  if (localObject2 == null) {
                    break;
                  }
                  i = j;
                  localObject3 = localObject1;
                  if (!((im_msg_body.GeneralFlags)localObject2).bytes_pb_reserve.has()) {
                    break;
                  }
                  try
                  {
                    localObject6 = new generalflags.ResvAttr();
                    ((generalflags.ResvAttr)localObject6).mergeFrom(((im_msg_body.GeneralFlags)localObject2).bytes_pb_reserve.get().toByteArray());
                    i = j;
                    localObject3 = localObject1;
                    if (!((generalflags.ResvAttr)localObject6).bytes_oac_msg_extend.has()) {
                      break;
                    }
                    ((MessageForPubAccount)localObject7).saveExtInfoToExtStr("report_key_bytes_oac_msg_extend", ((generalflags.ResvAttr)localObject6).bytes_oac_msg_extend.get().toStringUtf8());
                    i = j;
                    localObject3 = localObject1;
                  }
                  catch (Throwable localThrowable)
                  {
                    QLog.e("DecodeMsg", 2, "decodePBMsgElems_TransElemInfo()-MessageForPubAccount: parse generalflags error! " + QLog.getStackTraceString(localThrowable));
                    i = j;
                    Object localObject4 = localObject1;
                  }
                }
              }
            }
            catch (Exception localException)
            {
              paramStringBuilder.append("PubAccount Message parse decodeContext.mPamag exception.\n");
            }
            continue;
            if (localObject1 != null)
            {
              localObject2 = paramList.iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject5 = (im_msg_body.Elem)((Iterator)localObject2).next();
                if ((((im_msg_body.Elem)localObject5).elem_flags2.has()) && (((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject5).elem_flags2.get()).uint64_msg_id.has())) {
                  ((PAMessage)localObject1).mMsgId = ((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject5).elem_flags2.get()).uint64_msg_id.get();
                }
              }
              ((MessageForPubAccount)localObject7).mPAMessage = ((PAMessage)localObject1);
              ((MessageForPubAccount)localObject7).msgData = obj.a((PAMessage)localObject1);
            }
            if (i != 0)
            {
              localObject1 = (TroopManager)this.c.app.getManager(52);
              if (paramMsg.msg_head.group_info.has())
              {
                long l2 = paramMsg.msg_head.group_info.group_code.get();
                localObject2 = ((TroopManager)localObject1).b(String.valueOf(l2));
                if (localObject2 != null)
                {
                  ((TroopInfo)localObject2).associatePubAccount = l1;
                  ((TroopManager)localObject1).i((TroopInfo)localObject2);
                  this.c.app.getBusinessHandler(20).notifyUI(79, true, new Object[] { Long.valueOf(l2) });
                }
              }
            }
            paramList1.add(localObject7);
            if (i != 0) {
              break;
            }
            g(paramList, paramList1, paramStringBuilder, paramMsg, paramaozx);
            return;
            j = i;
          }
        }
        Object localObject5 = localObject1;
      }
    }
  }
  
  public void i(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder)
  {
    if (QLog.isColorLevel()) {
      paramStringBuilder.append("elemType:PokeMsg;\n");
    }
    paramList = paramList.iterator();
    do
    {
      if (!paramList.hasNext()) {
        break;
      }
      paramStringBuilder = (im_msg_body.Elem)paramList.next();
    } while (!paramStringBuilder.common_elem.has());
    for (paramList = (im_msg_body.CommonElem)paramStringBuilder.common_elem.get();; paramList = null)
    {
      if (paramList == null) {
        if (QLog.isColorLevel()) {
          QLog.d("PokeMsg", 2, "decodePBMsgElems_PokeMsg null commomElem!");
        }
      }
      for (;;)
      {
        return;
        paramStringBuilder = new MessageForPokeEmo();
        paramStringBuilder.msgtype = -5018;
        hummer_commelem.MsgElemInfo_servtype23 localMsgElemInfo_servtype23;
        if (paramList.bytes_pb_elem.has()) {
          localMsgElemInfo_servtype23 = new hummer_commelem.MsgElemInfo_servtype23();
        }
        try
        {
          localMsgElemInfo_servtype23.mergeFrom(paramList.bytes_pb_elem.get().toByteArray());
          paramStringBuilder.pokeemoId = localMsgElemInfo_servtype23.uint32_face_type.get();
          paramStringBuilder.pokeemoPressCount = localMsgElemInfo_servtype23.uint32_face_bubble_count.get();
          paramStringBuilder.summary = localMsgElemInfo_servtype23.bytes_face_summary.get().toStringUtf8();
          paramStringBuilder.initMsg();
          paramList1.add(paramStringBuilder);
          if (QLog.isColorLevel())
          {
            QLog.d("PokeEmoMsg", 2, "decodePbElems, common_elem type 23, pokeemoId:" + paramStringBuilder.pokeemoId + " ,pokeemoPressCount:" + paramStringBuilder.pokeemoPressCount);
            return;
          }
        }
        catch (Exception paramList)
        {
          for (;;)
          {
            QLog.d("PokeEmoMsg", 1, "decodePBMsgElems_PokeEmoMsg exception!", paramList);
          }
        }
      }
    }
  }
  
  public void i(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, aozx paramaozx)
  {
    String str = null;
    int k = 0;
    Object localObject1 = paramList.iterator();
    int m = 0;
    int n = -1;
    int i1 = 0;
    im_msg_body.GeneralFlags localGeneralFlags = null;
    im_msg_body.Elem localElem;
    label72:
    int i;
    int j;
    if (((Iterator)localObject1).hasNext())
    {
      localElem = (im_msg_body.Elem)((Iterator)localObject1).next();
      if (!localElem.general_flags.has()) {
        break label1945;
      }
      localGeneralFlags = (im_msg_body.GeneralFlags)localElem.general_flags.get();
      i = i1;
      if (!localElem.bless_msg.has()) {
        break label1938;
      }
      i = i1;
      if (localElem.bless_msg.uint32_msg_type.get() != 1) {
        break label1938;
      }
      i = 1;
      if (!localElem.bless_msg.uint32_ex_flag.has()) {
        break label1938;
      }
      j = localElem.bless_msg.uint32_ex_flag.get();
      i = 1;
      label139:
      if ((!localElem.elem_flags2.has()) || (!localElem.elem_flags2.uint32_msg_rpt_cnt.has())) {
        break label1935;
      }
      m = localElem.elem_flags2.uint32_msg_rpt_cnt.get();
      label177:
      if ((!localElem.text.has()) || (!localElem.text.str.has())) {
        break label1932;
      }
      str = localElem.text.str.get().toStringUtf8();
      if ((str != null) && (str.startsWith("[")) && (str.endsWith("]")))
      {
        str = aqhs.bytes2HexStr(localElem.text.str.get().toByteArray());
        label264:
        n = k;
        if (localElem.text.has())
        {
          n = k;
          if (!localElem.text.bytes_pb_reserve.has()) {}
        }
      }
    }
    label1932:
    label1935:
    label1938:
    label1945:
    label1948:
    for (;;)
    {
      try
      {
        localObject3 = new TextMsgExtPb.ResvAttr();
        ((TextMsgExtPb.ResvAttr)localObject3).mergeFrom(localElem.text.bytes_pb_reserve.get().toByteArray());
        if (!((TextMsgExtPb.ResvAttr)localObject3).text_analysis_result.has()) {
          break label1948;
        }
        n = ((TextMsgExtPb.ResvAttr)localObject3).text_analysis_result.get();
        k = n;
        n = k;
      }
      catch (Exception localException)
      {
        QLog.e("DecodeMsg", 1, "parse TextMsgExtPb.ResvAttr error, ", localException);
        n = k;
        continue;
      }
      k = n;
      n = j;
      i1 = i;
      break;
      str = "";
      break label264;
      Object localObject2 = null;
      localObject1 = new anbg.b();
      ArrayList localArrayList1 = ((anbg.b)localObject1).An;
      ArrayList localArrayList2 = new ArrayList(2);
      Object localObject3 = a(null, paramList, paramStringBuilder, paramMsg.msg_head.msg_seq.get(), paramaozx, (anbg.b)localObject1, localArrayList2);
      localObject1 = localObject2;
      if (localArrayList1 != null)
      {
        localObject1 = localObject2;
        if (localArrayList1.size() == 2)
        {
          localObject1 = localObject2;
          if (localArrayList1.get(1) != null) {
            localObject1 = (byte[])localArrayList1.get(1);
          }
        }
      }
      if (((StringBuilder)localObject3).length() == 0) {
        return;
      }
      long l3 = 0L;
      int i2 = 0;
      i = 0;
      j = 0;
      long l4 = 0L;
      long l2;
      if (localGeneralFlags != null)
      {
        l2 = l3;
        if (localGeneralFlags.bytes_pb_reserve.has())
        {
          i = i2;
          l2 = l3;
        }
      }
      label1844:
      for (;;)
      {
        long l1;
        boolean bool1;
        boolean bool3;
        try
        {
          paramList = new generalflags.ResvAttr();
          i = i2;
          l2 = l3;
          paramList.mergeFrom(localGeneralFlags.bytes_pb_reserve.get().toByteArray());
          l1 = l3;
          i = i2;
          l2 = l3;
          if (paramList.redbag_msg_sender_uin.has())
          {
            i = 1;
            j = 1;
            l2 = l3;
            l1 = paramList.redbag_msg_sender_uin.get();
          }
          l3 = l4;
          i = j;
          l2 = l1;
          if (paramList.want_gift_sender_uin.has())
          {
            i = j;
            l2 = l1;
            l3 = paramList.want_gift_sender_uin.get();
          }
          l2 = l3;
          i = j;
          l3 = l1;
          j = i;
          l1 = l3;
          if (i == 0)
          {
            j = i;
            l1 = l3;
            if (localGeneralFlags.uint64_uin.has())
            {
              i = 1;
              l3 = localGeneralFlags.uint64_uin.get();
              j = i;
              l1 = l3;
              if (QLog.isColorLevel())
              {
                QLog.d("msgFold", 2, "from old version");
                l1 = l3;
                j = i;
              }
            }
          }
          if (j == 0) {
            break label1900;
          }
          if (localGeneralFlags.uint32_prp_fold.get() == 1)
          {
            bool2 = true;
            paramList = localGeneralFlags.bytes_rp_id.get().toStringUtf8();
            paramStringBuilder = localGeneralFlags.bytes_rp_index.get().toStringUtf8();
            bool1 = zxj.J(this.app);
            if ((j == 0) || (!zxj.I(this.c.app))) {
              break label1894;
            }
            if (TextUtils.isEmpty(paramList)) {
              break label1596;
            }
            bool1 = true;
            if (QLog.isColorLevel()) {
              QLog.d("msgFold", 2, String.format("Recv, recv foldMsg, redBagSender: %s, foldFlag: %s, redBagId: %s, index: %s, foldSwitch: %s, isValidFoldMsg: %s", new Object[] { Long.valueOf(l1), Boolean.valueOf(bool2), paramList, paramStringBuilder, Boolean.valueOf(zxj.I(this.app)), Boolean.valueOf(bool1) }));
            }
            if (!String.valueOf(paramMsg.msg_head.from_uin.get()).equals(this.app.getCurrentAccountUin())) {
              break label1879;
            }
            bool3 = false;
            bool2 = bool1;
            bool1 = bool3;
            j = 0;
            i = j;
            if (localGeneralFlags != null) {
              if (localGeneralFlags.long_text_flag.get() != 2)
              {
                i = j;
                if (localGeneralFlags.long_text_flag.get() != 1) {}
              }
              else
              {
                j = 1;
                i = j;
                if (QLog.isColorLevel())
                {
                  QLog.d("DecodeMsg", 2, "decodePBMsgElems_Text, longTextFlag: true");
                  i = j;
                }
              }
            }
            if (!bool2) {
              break label1614;
            }
            paramaozx = new MessageForFoldMsg();
            ((MessageForFoldMsg)paramaozx).init(bool1, paramList, paramStringBuilder, l1, true);
            paramList = paramaozx;
            paramList.msg = ((StringBuilder)localObject3).toString();
            if ((paramList instanceof MessageForText)) {
              aptw.aI(paramList);
            }
            j = 0;
            i = j;
            if (paramMsg.msg_head.from_uin.has())
            {
              l1 = paramMsg.msg_head.from_uin.get();
              i = j;
              if (TextUtils.equals(this.c.app.getCurrentAccountUin(), Long.toString(l1))) {
                i = 1;
              }
            }
            if ((localObject1 != null) && (i == 0)) {
              paramList.saveExtInfoToExtStr("sens_msg_ctrl_info", aqhs.bytes2HexStr((byte[])localObject1));
            }
            if ((localGeneralFlags == null) || (!localGeneralFlags.babyq_guide_msg_cookie.has())) {}
          }
        }
        catch (Exception paramList)
        {
          QLog.e("msgFold", 1, "prase ResvAttr error, ", paramList);
        }
        try
        {
          paramStringBuilder = localGeneralFlags.babyq_guide_msg_cookie.get().toByteArray();
          paramMsg = aqft.bytesToHexString(paramStringBuilder);
          if (QLog.isColorLevel()) {
            QLog.d("DecodeMsg", 2, "decodePBMsgElems_Text, guideMsgCookie: " + paramMsg + ",bytes: " + Arrays.toString(localGeneralFlags.babyq_guide_msg_cookie.get().toByteArray()));
          }
          paramList.saveExtInfoToExtStr("guide_msg_cookie", paramMsg);
          ((acbs)this.app.getBusinessHandler(53)).au(paramStringBuilder);
        }
        catch (Exception paramStringBuilder)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("DecodeMsg", 2, "get text guideMsgCookie error!", paramStringBuilder);
          continue;
          bool1 = false;
          continue;
        }
        if (i1 != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("DecodeMsg", 2, "decodePBMsgElems, isBlessMsg: true ,updateFlag: " + n);
          }
          paramList.isBlessMsg = true;
          if (n > -1)
          {
            if ((n & 0x1) != 1) {
              break label1844;
            }
            bool1 = true;
            paramList.needUpdateMsgTag = bool1;
          }
        }
        if (m > 0)
        {
          paramList.setRepeatCount(m);
          if (QLog.isColorLevel()) {
            QLog.d("DecodeMsg", 2, "MessageForText ====> repeatCount = " + paramList.getRepeatCount());
          }
        }
        j = 0;
        paramMsg = null;
        paramStringBuilder = paramMsg;
        i = j;
        if (localGeneralFlags != null)
        {
          paramStringBuilder = paramMsg;
          i = j;
          if (!localGeneralFlags.bytes_pb_reserve.has()) {}
        }
        try
        {
          paramaozx = new generalflags.ResvAttr();
          paramaozx.mergeFrom(localGeneralFlags.bytes_pb_reserve.get().toByteArray());
          paramStringBuilder = paramMsg;
          i = j;
          if (paramaozx.bytes_kpl_info.has())
          {
            paramStringBuilder = paramMsg;
            i = j;
            if (paramaozx.bytes_kpl_info.has())
            {
              i = 1;
              paramStringBuilder = paramaozx.bytes_kpl_info.get().toStringUtf8();
            }
          }
        }
        catch (Exception paramStringBuilder)
        {
          if (!QLog.isColorLevel()) {
            break label1867;
          }
          QLog.d("KplMessage", 2, "parse proto catch exception about kpl");
          paramStringBuilder.printStackTrace();
          i = 0;
          paramStringBuilder = null;
          continue;
        }
        if (i != 0)
        {
          paramList.saveExtInfoToExtStr("msg_ext_key", "Y");
          if (QLog.isColorLevel()) {
            QLog.d("KplMessage", 2, "resv a kpl text message !");
          }
          KplRoleInfo.handleKplFlag(this.app, paramStringBuilder);
        }
        if (!TextUtils.isEmpty(str)) {
          paramList.saveExtInfoToExtStr("small_description", str);
        }
        if ((paramList instanceof RecommendCommonMessage)) {
          paramList.saveExtInfoToExtStr("ark_text_analysis_flag", String.valueOf(k));
        }
        paramList1.add(paramList);
        return;
        l3 = l2;
        l2 = 0L;
        continue;
        boolean bool2 = false;
        continue;
        label1596:
        if ((!TextUtils.isEmpty(paramStringBuilder)) && (bool1))
        {
          bool1 = true;
          continue;
          label1614:
          if (i != 0)
          {
            paramList = (ChatMessage)anbi.d(-1051);
            paramList.saveExtInfoToExtStr("long_text_recv_state", "1");
            paramList.removeExtInfoToExtStr("long_text_msg_resid");
          }
          else if (l2 != 0L)
          {
            paramList = new MessageForWantGiftMsg();
            ((MessageForWantGiftMsg)paramList).wantGiftSenderUin = l2;
            ((MessageForWantGiftMsg)paramList).saveExtInfoToExtStr(MessageForWantGiftMsg.GIFT_SENDER_UIN, l2 + "");
            ((MessageForWantGiftMsg)paramList).msgtype = -2056;
          }
          else
          {
            paramList = (ChatMessage)anbi.d(-1000);
            if ((paramaozx != null) && (localArrayList2 != null)) {
              appb.a(paramaozx.uinType, localArrayList2, paramList);
            }
            if (localArrayList1.size() > 0)
            {
              paramStringBuilder = new ArrayList(localArrayList1.size());
              paramaozx = localArrayList1.iterator();
              while (paramaozx.hasNext())
              {
                localObject2 = paramaozx.next();
                if ((localObject2 instanceof MessageForText.AtTroopMemberInfo)) {
                  paramStringBuilder.add((MessageForText.AtTroopMemberInfo)localObject2);
                }
              }
              paramList.atInfoTempList = paramStringBuilder;
            }
            continue;
            label1879:
            bool3 = bool1;
            bool1 = bool2;
            bool2 = bool3;
          }
        }
        else
        {
          label1867:
          label1894:
          bool1 = false;
          continue;
          label1900:
          paramStringBuilder = null;
          bool1 = false;
          bool2 = false;
          paramList = null;
          continue;
          paramStringBuilder = null;
          l1 = 0L;
          l2 = 0L;
          bool2 = false;
          bool1 = false;
          paramList = null;
        }
      }
      break label264;
      break label177;
      j = n;
      break label139;
      break label72;
    }
  }
  
  public void j(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder)
  {
    MessageForLimitChatConfirm localMessageForLimitChatConfirm = null;
    Iterator localIterator = paramList.iterator();
    do
    {
      paramList = localMessageForLimitChatConfirm;
      if (!localIterator.hasNext()) {
        break;
      }
      paramList = (im_msg_body.Elem)localIterator.next();
    } while (!paramList.common_elem.has());
    paramList = (im_msg_body.CommonElem)paramList.common_elem.get();
    if (paramList == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      paramStringBuilder.append("decodePBMsgElems_LimitChatConfirmMsg;\n");
    }
    paramStringBuilder = new hummer_commelem.MsgElemInfo_servtype24();
    for (;;)
    {
      try
      {
        paramStringBuilder.mergeFrom(paramList.bytes_pb_elem.get().toByteArray());
        localMessageForLimitChatConfirm = (MessageForLimitChatConfirm)anbi.d(-7005);
        localMessageForLimitChatConfirm.msgtype = -7005;
        if (paramList.uint32_business_type.has())
        {
          i = paramList.uint32_business_type.get();
          if (i != 1) {
            break label383;
          }
          if (!paramStringBuilder.limit_chat_enter.has()) {
            break label370;
          }
          localMessageForLimitChatConfirm.SenderNickName = paramStringBuilder.limit_chat_enter.bytes_match_nick.get().toStringUtf8();
          localMessageForLimitChatConfirm.tipsWording = paramStringBuilder.limit_chat_enter.bytes_tips_wording.get().toStringUtf8();
          localMessageForLimitChatConfirm.leftChatTime = paramStringBuilder.limit_chat_enter.uint32_left_chat_time.get();
          localMessageForLimitChatConfirm.c2cExpiredTime = paramStringBuilder.limit_chat_enter.uint32_c2c_expired_time.get();
          localMessageForLimitChatConfirm.matchExpiredTime = paramStringBuilder.limit_chat_enter.uint32_match_expired_time.get();
          localMessageForLimitChatConfirm.timeStamp = paramStringBuilder.limit_chat_enter.uint64_match_ts.get();
          localMessageForLimitChatConfirm.readyTs = paramStringBuilder.limit_chat_enter.uint64_ready_ts.get();
          localMessageForLimitChatConfirm.bEnterMsg = true;
          if (QLog.isColorLevel()) {
            QLog.i("DecodeMsgLimitChatConfirm msg", 1, " decodePBMsgElems_LimitChatConfirmMsg type" + i + " " + localMessageForLimitChatConfirm.matchExpiredTime + " " + localMessageForLimitChatConfirm.frienduin);
          }
          localMessageForLimitChatConfirm.prewrite();
          paramList1.add(localMessageForLimitChatConfirm);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramList)
      {
        paramList.printStackTrace();
        QLog.e("DecodeMsgscribble msg", 1, paramList, new Object[0]);
        return;
      }
      int i = 1;
      continue;
      label370:
      QLog.e("DecodeMsgExtendFriendLimitChatLimitChatConfirm msg", 1, " !!!limitChatElem  limit_chat_enter is null ");
      continue;
      label383:
      if (paramStringBuilder.limit_chat_exit.has())
      {
        localMessageForLimitChatConfirm.bEnterMsg = false;
        localMessageForLimitChatConfirm.leaveChatType = paramStringBuilder.limit_chat_exit.uint32_exit_method.get();
        localMessageForLimitChatConfirm.timeStamp = paramStringBuilder.limit_chat_exit.uint64_match_ts.get();
      }
      else
      {
        QLog.e("DecodeMsgLimitChatConfirm msg", 1, " limitChatElem  limit_chat_exit is null ");
      }
    }
  }
  
  public class a
  {
    public MessageForText.AtTroopMemberInfo a;
    public MessageForReplyText.SourceMsgInfo b;
    public String cdm;
    public String cdn;
    public byte[] fv;
    
    public a() {}
  }
  
  public static class b
  {
    public ArrayList<Object> An = new ArrayList(2);
    public MessageForText.AtTroopMemberInfo b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anbg
 * JD-Core Version:    0.7.0.1
 */