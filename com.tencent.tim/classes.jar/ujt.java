import AccostSvc.EventItem;
import NS_MOBILE_AIONewestFeed.AIONewestFeedRsp;
import NS_MOBILE_AIONewestFeed.Media_Data;
import NS_MOBILE_AIONewestFeed.NewestFeedInfo;
import NS_QQ_STORY_CLIENT.CLIENT.StGetUserNewestStoryRsp;
import NS_QQ_STORY_META.META.StStoryFeed;
import VIP.AIOSendReq;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.cloudfile.CloudFile;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.device.file.DeviceFileHandler;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.device.msg.data.MessageForDevShortVideo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade.1;
import com.tencent.mobileqq.activity.ChatActivityFacade.10;
import com.tencent.mobileqq.activity.ChatActivityFacade.11;
import com.tencent.mobileqq.activity.ChatActivityFacade.13;
import com.tencent.mobileqq.activity.ChatActivityFacade.14;
import com.tencent.mobileqq.activity.ChatActivityFacade.15;
import com.tencent.mobileqq.activity.ChatActivityFacade.16;
import com.tencent.mobileqq.activity.ChatActivityFacade.17;
import com.tencent.mobileqq.activity.ChatActivityFacade.18;
import com.tencent.mobileqq.activity.ChatActivityFacade.19;
import com.tencent.mobileqq.activity.ChatActivityFacade.2;
import com.tencent.mobileqq.activity.ChatActivityFacade.20;
import com.tencent.mobileqq.activity.ChatActivityFacade.21;
import com.tencent.mobileqq.activity.ChatActivityFacade.22;
import com.tencent.mobileqq.activity.ChatActivityFacade.6;
import com.tencent.mobileqq.activity.ChatActivityFacade.7;
import com.tencent.mobileqq.activity.ChatActivityFacade.8;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.BeancurdMsg;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.FeedsManager;
import com.tencent.mobileqq.data.HiBoomMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForHiBoom;
import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForPokeEmo;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.mobileqq.data.MessageForQzoneFeed;
import com.tencent.mobileqq.data.MessageForQzoneFeed.MediaData;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageForWantGiftMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.data.RecentEmotion;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.a;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;>;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ujt
{
  public static long Fz = -1L;
  public static ausj T;
  public static ausj U;
  private static ujt.b a = new ujt.b();
  private static ConcurrentHashMap<String, ujt.c> cS = new ConcurrentHashMap();
  public static ChatMessage d;
  public static List<ChatMessage> qn;
  public static QQToast toast;
  
  private static int a(SessionInfo paramSessionInfo, String paramString)
    throws UnsupportedEncodingException
  {
    if ((!aerh.c().bVW) && ((paramSessionInfo.cZ == 3000) || (paramSessionInfo.cZ == 1)))
    {
      paramString = aqft.q(paramString);
      int j = paramString[0];
      int i = j;
      if (paramSessionInfo.cZ == 1) {
        i = j + paramString[1] * 2;
      }
      return i;
    }
    return paramString.getBytes("utf-8").length;
  }
  
  private static long a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if ((paramQQAppInterface == null) || (paramQQAppInterface.getApp() == null) || (paramSessionInfo == null)) {
      return 0L;
    }
    paramSessionInfo = a(paramQQAppInterface, paramSessionInfo, "key_last_story_feed_create_time_for_aio");
    return paramQQAppInterface.getApp().getSharedPreferences("qzone_sp_in_qq", 0).getLong(paramSessionInfo, 0L);
  }
  
  private static long a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, int paramInt, ArrayList<String> paramArrayList)
  {
    long l1 = -1L;
    paramArrayList = anrx.a(paramArrayList);
    if (paramArrayList != null)
    {
      String str = paramQQAppInterface.getCurrentAccountUin();
      int i = amzo.seq;
      amzo.seq = i + 1;
      l1 = i;
      paramSessionInfo = anbi.a(paramQQAppInterface, str, paramSessionInfo.aTl, str, paramSessionInfo.cZ, l1, paramArrayList);
      long l2 = paramSessionInfo.uniseq;
      paramSessionInfo.msgUid = anbk.I(paramInt);
      l1 = l2;
      if (!achp.a(paramQQAppInterface, paramSessionInfo, false))
      {
        paramQQAppInterface.b().z(paramSessionInfo);
        l1 = l2;
      }
    }
    return l1;
  }
  
  private static long a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString)
  {
    if ((paramQQAppInterface == null) || (paramQQAppInterface.getApp() == null) || (paramSessionInfo == null)) {
      return 0L;
    }
    return paramQQAppInterface.getApp().getSharedPreferences("qzone_sp_in_qq", 0).getLong(a(paramQQAppInterface, paramSessionInfo, paramString), 0L);
  }
  
  public static long a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, int paramInt1, boolean paramBoolean, byte paramByte1, byte paramByte2, short paramShort, int paramInt2, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, ujt.d paramd)
  {
    return a(paramQQAppInterface, paramSessionInfo, paramString, paramInt1, paramBoolean, paramByte1, paramByte2, paramShort, paramInt2, paramArrayList, paramd, false);
  }
  
  /* Error */
  public static long a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, int paramInt1, boolean paramBoolean1, byte paramByte1, byte paramByte2, short paramShort, int paramInt2, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, ujt.d paramd, boolean paramBoolean2)
  {
    // Byte code:
    //   0: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +42 -> 45
    //   6: ldc 178
    //   8: iconst_2
    //   9: new 180	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   16: ldc 183
    //   18: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokestatic 193	java/lang/System:currentTimeMillis	()J
    //   24: invokevirtual 196	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   27: ldc 198
    //   29: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_1
    //   33: getfield 201	com/tencent/mobileqq/activity/aio/SessionInfo:entrance	I
    //   36: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   39: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 210	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: aload_2
    //   46: ifnull +1378 -> 1424
    //   49: aload_2
    //   50: iconst_1
    //   51: aload 9
    //   53: invokestatic 213	anbk:a	(Ljava/lang/String;ZLjava/util/ArrayList;)Ljava/lang/String;
    //   56: astore 14
    //   58: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   61: ifeq +30 -> 91
    //   64: ldc 178
    //   66: iconst_2
    //   67: new 180	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   74: ldc 215
    //   76: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokestatic 193	java/lang/System:currentTimeMillis	()J
    //   82: invokevirtual 196	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   85: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 210	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: aload 10
    //   93: getfield 218	ujt$d:mWantGiftSenderUin	J
    //   96: lconst_0
    //   97: lcmp
    //   98: ifeq +663 -> 761
    //   101: new 220	com/tencent/mobileqq/data/MessageForWantGiftMsg
    //   104: dup
    //   105: invokespecial 221	com/tencent/mobileqq/data/MessageForWantGiftMsg:<init>	()V
    //   108: astore_2
    //   109: aload_2
    //   110: checkcast 220	com/tencent/mobileqq/data/MessageForWantGiftMsg
    //   113: aload 10
    //   115: getfield 218	ujt$d:mWantGiftSenderUin	J
    //   118: putfield 224	com/tencent/mobileqq/data/MessageForWantGiftMsg:wantGiftSenderUin	J
    //   121: aload_2
    //   122: checkcast 220	com/tencent/mobileqq/data/MessageForWantGiftMsg
    //   125: getstatic 227	com/tencent/mobileqq/data/MessageForWantGiftMsg:GIFT_SENDER_UIN	Ljava/lang/String;
    //   128: new 180	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   135: aload 10
    //   137: getfield 218	ujt$d:mWantGiftSenderUin	J
    //   140: invokevirtual 196	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   143: ldc 229
    //   145: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokevirtual 233	com/tencent/mobileqq/data/MessageForWantGiftMsg:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   154: aload_2
    //   155: sipush -2056
    //   158: putfield 238	com/tencent/mobileqq/data/ChatMessage:msgtype	I
    //   161: aload_0
    //   162: aload_2
    //   163: aload_1
    //   164: getfield 128	com/tencent/mobileqq/activity/aio/SessionInfo:aTl	Ljava/lang/String;
    //   167: aload_1
    //   168: getfield 241	com/tencent/mobileqq/activity/aio/SessionInfo:troopUin	Ljava/lang/String;
    //   171: aload_1
    //   172: getfield 68	com/tencent/mobileqq/activity/aio/SessionInfo:cZ	I
    //   175: invokestatic 244	anbi:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;Ljava/lang/String;I)V
    //   178: aload_2
    //   179: aload 14
    //   181: putfield 247	com/tencent/mobileqq/data/ChatMessage:msg	Ljava/lang/String;
    //   184: aload_2
    //   185: iload 8
    //   187: invokestatic 143	anbk:I	(I)J
    //   190: putfield 248	com/tencent/mobileqq/data/ChatMessage:msgUid	J
    //   193: aload_2
    //   194: iload 5
    //   196: putfield 251	com/tencent/mobileqq/data/ChatMessage:longMsgCount	I
    //   199: aload_2
    //   200: iload 6
    //   202: putfield 254	com/tencent/mobileqq/data/ChatMessage:longMsgIndex	I
    //   205: aload_2
    //   206: iload 7
    //   208: putfield 257	com/tencent/mobileqq/data/ChatMessage:longMsgId	I
    //   211: aload_2
    //   212: iconst_1
    //   213: putfield 260	com/tencent/mobileqq/data/ChatMessage:mAnimFlag	Z
    //   216: aload 10
    //   218: getfield 264	ujt$d:stickerInfo	Lcom/tencent/mobileqq/emoticon/EmojiStickerManager$StickerInfo;
    //   221: ifnull +30 -> 251
    //   224: aload_2
    //   225: ldc_w 266
    //   228: aload 10
    //   230: getfield 264	ujt$d:stickerInfo	Lcom/tencent/mobileqq/emoticon/EmojiStickerManager$StickerInfo;
    //   233: invokevirtual 271	com/tencent/mobileqq/emoticon/EmojiStickerManager$StickerInfo:toJsonString	()Ljava/lang/String;
    //   236: invokevirtual 272	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   239: aload_2
    //   240: aconst_null
    //   241: invokestatic 277	com/tencent/mobileqq/emoticon/EmojiStickerManager:a	(Lcom/tencent/mobileqq/data/MessageRecord;Lcom/tencent/mobileqq/emoticon/EmojiStickerManager$StickerInfo;)V
    //   244: invokestatic 280	com/tencent/mobileqq/emoticon/EmojiStickerManager:a	()Lcom/tencent/mobileqq/emoticon/EmojiStickerManager;
    //   247: aload_2
    //   248: invokevirtual 283	com/tencent/mobileqq/emoticon/EmojiStickerManager:aj	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   251: aload 10
    //   253: getfield 286	ujt$d:aSL	Z
    //   256: ifeq +8 -> 264
    //   259: aload_2
    //   260: iconst_m1
    //   261: putfield 289	com/tencent/mobileqq/data/ChatMessage:mRobotFlag	I
    //   264: aload 10
    //   266: getfield 292	ujt$d:bEX	I
    //   269: iconst_m1
    //   270: if_icmpeq +18 -> 288
    //   273: aload_2
    //   274: ldc_w 294
    //   277: aload 10
    //   279: getfield 292	ujt$d:bEX	I
    //   282: invokestatic 298	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   285: invokevirtual 272	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   288: aload_2
    //   289: instanceof 300
    //   292: ifeq +964 -> 1256
    //   295: aload_2
    //   296: checkcast 300	com/tencent/mobileqq/data/MessageForReplyText
    //   299: astore 14
    //   301: aload 14
    //   303: aload_1
    //   304: getfield 201	com/tencent/mobileqq/activity/aio/SessionInfo:entrance	I
    //   307: putfield 303	com/tencent/mobileqq/data/MessageForReplyText:msgVia	I
    //   310: aload 14
    //   312: aload 10
    //   314: getfield 306	ujt$d:isBarrageMsg	Z
    //   317: putfield 307	com/tencent/mobileqq/data/MessageForReplyText:isBarrageMsg	Z
    //   320: aload 14
    //   322: aload 10
    //   324: getfield 310	ujt$d:barrageTimeLocation	J
    //   327: putfield 311	com/tencent/mobileqq/data/MessageForReplyText:barrageTimeLocation	J
    //   330: aload 14
    //   332: aload 10
    //   334: getfield 314	ujt$d:barrageSourceMsgType	I
    //   337: putfield 315	com/tencent/mobileqq/data/MessageForReplyText:barrageSourceMsgType	I
    //   340: aload 14
    //   342: getfield 307	com/tencent/mobileqq/data/MessageForReplyText:isBarrageMsg	Z
    //   345: ifeq +35 -> 380
    //   348: aload 14
    //   350: ldc_w 317
    //   353: aload 14
    //   355: getfield 311	com/tencent/mobileqq/data/MessageForReplyText:barrageTimeLocation	J
    //   358: invokestatic 320	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   361: invokevirtual 321	com/tencent/mobileqq/data/MessageForReplyText:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   364: aload 14
    //   366: ldc_w 323
    //   369: aload 14
    //   371: getfield 315	com/tencent/mobileqq/data/MessageForReplyText:barrageSourceMsgType	I
    //   374: invokestatic 298	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   377: invokevirtual 321	com/tencent/mobileqq/data/MessageForReplyText:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   380: aload 9
    //   382: ifnull +10 -> 392
    //   385: aload 14
    //   387: aload 9
    //   389: putfield 327	com/tencent/mobileqq/data/MessageForReplyText:atInfoList	Ljava/util/ArrayList;
    //   392: aload 10
    //   394: getfield 331	ujt$d:mSourceMsgInfo	Lcom/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo;
    //   397: invokestatic 336	aczw:b	(Ljava/io/Serializable;)[B
    //   400: invokestatic 342	aqhs:bytes2HexStr	([B)Ljava/lang/String;
    //   403: astore 9
    //   405: aload 14
    //   407: aload 10
    //   409: getfield 331	ujt$d:mSourceMsgInfo	Lcom/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo;
    //   412: putfield 343	com/tencent/mobileqq/data/MessageForReplyText:mSourceMsgInfo	Lcom/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo;
    //   415: aload 14
    //   417: ldc_w 345
    //   420: aload 9
    //   422: invokevirtual 321	com/tencent/mobileqq/data/MessageForReplyText:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   425: aload 14
    //   427: aload 14
    //   429: getfield 348	com/tencent/mobileqq/data/MessageForReplyText:extLong	I
    //   432: iconst_1
    //   433: ior
    //   434: putfield 348	com/tencent/mobileqq/data/MessageForReplyText:extLong	I
    //   437: aload 14
    //   439: getfield 343	com/tencent/mobileqq/data/MessageForReplyText:mSourceMsgInfo	Lcom/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo;
    //   442: invokevirtual 354	com/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo:getSourceMsg	()[B
    //   445: ifnull +17 -> 462
    //   448: aload 14
    //   450: aload 14
    //   452: getfield 343	com/tencent/mobileqq/data/MessageForReplyText:mSourceMsgInfo	Lcom/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo;
    //   455: aload_0
    //   456: invokevirtual 358	com/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo:unPackSourceMsg	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lcom/tencent/mobileqq/data/MessageRecord;
    //   459: invokevirtual 361	com/tencent/mobileqq/data/MessageForReplyText:setSourceMessageRecord	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   462: aload 10
    //   464: getfield 364	ujt$d:aLN	Ljava/lang/String;
    //   467: invokestatic 370	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   470: ifne +40 -> 510
    //   473: aload 10
    //   475: getfield 373	ujt$d:aLO	Ljava/lang/String;
    //   478: invokestatic 370	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   481: ifne +29 -> 510
    //   484: aload 14
    //   486: ldc_w 375
    //   489: aload 10
    //   491: getfield 364	ujt$d:aLN	Ljava/lang/String;
    //   494: invokevirtual 321	com/tencent/mobileqq/data/MessageForReplyText:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   497: aload 14
    //   499: ldc_w 377
    //   502: aload 10
    //   504: getfield 373	ujt$d:aLO	Ljava/lang/String;
    //   507: invokevirtual 321	com/tencent/mobileqq/data/MessageForReplyText:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   510: aload 10
    //   512: getfield 380	ujt$d:bEW	I
    //   515: ifle +23 -> 538
    //   518: invokestatic 385	wte:a	()Lwte;
    //   521: aload_2
    //   522: getfield 386	com/tencent/mobileqq/data/ChatMessage:uniseq	J
    //   525: aload 10
    //   527: getfield 389	ujt$d:FD	J
    //   530: aload 10
    //   532: getfield 380	ujt$d:bEW	I
    //   535: invokevirtual 393	wte:i	(JJI)V
    //   538: aload_2
    //   539: getfield 396	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   542: iconst_1
    //   543: if_icmpne +750 -> 1293
    //   546: invokestatic 401	jof:a	()Ljof;
    //   549: aload_2
    //   550: invokevirtual 403	jof:a	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   553: aload 10
    //   555: getfield 406	ujt$d:aTt	Z
    //   558: ifeq +7 -> 565
    //   561: aload_2
    //   562: invokestatic 411	afck:ae	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   565: aload_2
    //   566: getfield 396	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   569: sipush 1033
    //   572: if_icmpeq +13 -> 585
    //   575: aload_2
    //   576: getfield 396	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   579: sipush 1034
    //   582: if_icmpne +730 -> 1312
    //   585: aload_0
    //   586: aload_2
    //   587: aload_2
    //   588: getfield 414	com/tencent/mobileqq/data/ChatMessage:frienduin	Ljava/lang/String;
    //   591: aload_2
    //   592: getfield 396	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   595: aload_1
    //   596: getfield 417	com/tencent/mobileqq/activity/aio/SessionInfo:topicId	I
    //   599: invokestatic 422	aegu:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;II)V
    //   602: aload_1
    //   603: getfield 68	com/tencent/mobileqq/activity/aio/SessionInfo:cZ	I
    //   606: sipush 10007
    //   609: if_icmpne +16 -> 625
    //   612: aload_0
    //   613: aload_2
    //   614: aload_2
    //   615: getfield 414	com/tencent/mobileqq/data/ChatMessage:frienduin	Ljava/lang/String;
    //   618: aload_2
    //   619: getfield 396	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   622: invokestatic 427	ahti:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/ChatMessage;Ljava/lang/String;I)V
    //   625: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   628: ifeq +58 -> 686
    //   631: ldc 178
    //   633: iconst_2
    //   634: new 180	java/lang/StringBuilder
    //   637: dup
    //   638: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   641: ldc_w 429
    //   644: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   647: aload_2
    //   648: getfield 432	com/tencent/mobileqq/data/ChatMessage:time	J
    //   651: invokevirtual 196	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   654: ldc_w 434
    //   657: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: aload_2
    //   661: getfield 437	com/tencent/mobileqq/data/ChatMessage:senderuin	Ljava/lang/String;
    //   664: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: ldc_w 439
    //   670: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: aload_2
    //   674: getfield 248	com/tencent/mobileqq/data/ChatMessage:msgUid	J
    //   677: invokevirtual 196	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   680: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   683: invokestatic 210	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   686: aload 10
    //   688: getfield 442	ujt$d:aTv	Z
    //   691: istore 4
    //   693: aload 10
    //   695: getfield 445	ujt$d:aTw	Z
    //   698: ifeq +695 -> 1393
    //   701: iload 4
    //   703: ifeq +647 -> 1350
    //   706: aload_0
    //   707: sipush 166
    //   710: invokevirtual 449	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   713: checkcast 451	ajkw
    //   716: aload_0
    //   717: aload_2
    //   718: iconst_0
    //   719: invokevirtual 454	ajkw:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;Z)V
    //   722: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   725: ifeq +31 -> 756
    //   728: ldc 178
    //   730: iconst_2
    //   731: new 180	java/lang/StringBuilder
    //   734: dup
    //   735: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   738: ldc_w 456
    //   741: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   744: invokestatic 193	java/lang/System:currentTimeMillis	()J
    //   747: invokevirtual 196	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   750: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   753: invokestatic 210	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   756: aload_2
    //   757: getfield 386	com/tencent/mobileqq/data/ChatMessage:uniseq	J
    //   760: lreturn
    //   761: aload 10
    //   763: getfield 459	ujt$d:aLP	Ljava/lang/String;
    //   766: ifnull +45 -> 811
    //   769: aload_0
    //   770: invokestatic 464	zxj:I	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   773: ifeq +38 -> 811
    //   776: new 466	com/tencent/mobileqq/data/MessageForFoldMsg
    //   779: dup
    //   780: invokespecial 467	com/tencent/mobileqq/data/MessageForFoldMsg:<init>	()V
    //   783: astore_2
    //   784: aload_2
    //   785: checkcast 466	com/tencent/mobileqq/data/MessageForFoldMsg
    //   788: iconst_0
    //   789: aload 10
    //   791: getfield 459	ujt$d:aLP	Ljava/lang/String;
    //   794: aload 10
    //   796: getfield 470	ujt$d:aLQ	Ljava/lang/String;
    //   799: aload 10
    //   801: getfield 473	ujt$d:mPasswdRedBagSender	J
    //   804: iconst_1
    //   805: invokevirtual 477	com/tencent/mobileqq/data/MessageForFoldMsg:init	(ZLjava/lang/String;Ljava/lang/String;JZ)V
    //   808: goto -647 -> 161
    //   811: aload 10
    //   813: getfield 331	ujt$d:mSourceMsgInfo	Lcom/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo;
    //   816: ifnonnull +31 -> 847
    //   819: aload 10
    //   821: getfield 442	ujt$d:aTv	Z
    //   824: ifeq +23 -> 847
    //   827: aload_0
    //   828: invokestatic 480	ajkw:bc	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   831: ifeq +16 -> 847
    //   834: sipush -1051
    //   837: invokestatic 483	anbi:d	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   840: checkcast 235	com/tencent/mobileqq/data/ChatMessage
    //   843: astore_2
    //   844: goto -683 -> 161
    //   847: aload 10
    //   849: getfield 331	ujt$d:mSourceMsgInfo	Lcom/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo;
    //   852: ifnull +564 -> 1416
    //   855: sipush -1049
    //   858: istore 12
    //   860: iload 12
    //   862: invokestatic 483	anbi:d	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   865: checkcast 235	com/tencent/mobileqq/data/ChatMessage
    //   868: astore_2
    //   869: aload_0
    //   870: bipush 51
    //   872: invokevirtual 449	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   875: checkcast 485	acff
    //   878: astore 15
    //   880: aload 15
    //   882: aload_0
    //   883: invokevirtual 488	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   886: iconst_0
    //   887: invokevirtual 491	acff:a	(Ljava/lang/String;Z)Lcom/tencent/mobileqq/data/ExtensionInfo;
    //   890: astore 16
    //   892: aload 16
    //   894: ifnull +56 -> 950
    //   897: aload_2
    //   898: ldc_w 493
    //   901: aload 16
    //   903: invokestatic 498	ku:a	(Lcom/tencent/mobileqq/data/ExtensionInfo;)I
    //   906: invokestatic 298	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   909: invokevirtual 272	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   912: aload_2
    //   913: ldc_w 500
    //   916: aload 16
    //   918: getfield 505	com/tencent/mobileqq/data/ExtensionInfo:uVipFont	J
    //   921: invokestatic 508	ku:d	(J)I
    //   924: invokestatic 298	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   927: invokevirtual 272	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   930: iconst_1
    //   931: aload 16
    //   933: getfield 511	com/tencent/mobileqq/data/ExtensionInfo:magicFont	I
    //   936: if_icmpne +232 -> 1168
    //   939: aload_2
    //   940: ldc_w 513
    //   943: iconst_0
    //   944: invokestatic 298	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   947: invokevirtual 272	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   950: aload 15
    //   952: aload_0
    //   953: invokevirtual 119	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   956: invokevirtual 516	acff:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   959: astore 15
    //   961: aload 15
    //   963: ifnull +160 -> 1123
    //   966: aload 15
    //   968: getstatic 522	QQService/EVIPSPEC:E_SP_BIGCLUB	LQQService/EVIPSPEC;
    //   971: invokevirtual 528	com/tencent/mobileqq/data/Friends:isServiceEnabled	(LQQService/EVIPSPEC;)Z
    //   974: ifeq +63 -> 1037
    //   977: iconst_1
    //   978: istore_3
    //   979: aload 15
    //   981: getstatic 522	QQService/EVIPSPEC:E_SP_BIGCLUB	LQQService/EVIPSPEC;
    //   984: invokevirtual 532	com/tencent/mobileqq/data/Friends:getServiceType	(LQQService/EVIPSPEC;)I
    //   987: iconst_1
    //   988: if_icmpne +5 -> 993
    //   991: iconst_3
    //   992: istore_3
    //   993: aload_2
    //   994: ldc_w 534
    //   997: iload_3
    //   998: invokestatic 298	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1001: invokevirtual 272	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   1004: aload_2
    //   1005: ldc_w 536
    //   1008: aload 15
    //   1010: getstatic 522	QQService/EVIPSPEC:E_SP_BIGCLUB	LQQService/EVIPSPEC;
    //   1013: invokevirtual 539	com/tencent/mobileqq/data/Friends:getServiceLevel	(LQQService/EVIPSPEC;)I
    //   1016: invokestatic 298	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1019: invokevirtual 272	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   1022: aload_2
    //   1023: ldc_w 541
    //   1026: aload 15
    //   1028: getfield 544	com/tencent/mobileqq/data/Friends:bigClubTemplateId	I
    //   1031: invokestatic 298	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1034: invokevirtual 272	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   1037: aload 15
    //   1039: getstatic 547	QQService/EVIPSPEC:E_SP_QQVIP	LQQService/EVIPSPEC;
    //   1042: invokevirtual 528	com/tencent/mobileqq/data/Friends:isServiceEnabled	(LQQService/EVIPSPEC;)Z
    //   1045: ifne +14 -> 1059
    //   1048: aload 15
    //   1050: getstatic 550	QQService/EVIPSPEC:E_SP_SUPERVIP	LQQService/EVIPSPEC;
    //   1053: invokevirtual 528	com/tencent/mobileqq/data/Friends:isServiceEnabled	(LQQService/EVIPSPEC;)Z
    //   1056: ifeq +67 -> 1123
    //   1059: aload 15
    //   1061: getstatic 550	QQService/EVIPSPEC:E_SP_SUPERVIP	LQQService/EVIPSPEC;
    //   1064: invokevirtual 528	com/tencent/mobileqq/data/Friends:isServiceEnabled	(LQQService/EVIPSPEC;)Z
    //   1067: ifeq +119 -> 1186
    //   1070: sipush 256
    //   1073: istore_3
    //   1074: aload 15
    //   1076: getstatic 550	QQService/EVIPSPEC:E_SP_SUPERVIP	LQQService/EVIPSPEC;
    //   1079: invokevirtual 532	com/tencent/mobileqq/data/Friends:getServiceType	(LQQService/EVIPSPEC;)I
    //   1082: iconst_1
    //   1083: if_icmpne +7 -> 1090
    //   1086: sipush 258
    //   1089: istore_3
    //   1090: aload 15
    //   1092: getstatic 550	QQService/EVIPSPEC:E_SP_SUPERVIP	LQQService/EVIPSPEC;
    //   1095: invokevirtual 539	com/tencent/mobileqq/data/Friends:getServiceLevel	(LQQService/EVIPSPEC;)I
    //   1098: istore 13
    //   1100: aload_2
    //   1101: ldc_w 552
    //   1104: iload_3
    //   1105: invokestatic 298	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1108: invokevirtual 272	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   1111: aload_2
    //   1112: ldc_w 554
    //   1115: iload 13
    //   1117: invokestatic 298	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1120: invokevirtual 272	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   1123: aload 9
    //   1125: ifnull +13 -> 1138
    //   1128: aload_1
    //   1129: getfield 68	com/tencent/mobileqq/activity/aio/SessionInfo:cZ	I
    //   1132: aload 9
    //   1134: aload_2
    //   1135: invokestatic 559	appb:a	(ILjava/util/ArrayList;Lcom/tencent/mobileqq/data/ChatMessage;)V
    //   1138: iload 12
    //   1140: sipush -1000
    //   1143: if_icmpne +22 -> 1165
    //   1146: aload 10
    //   1148: getfield 562	ujt$d:aTx	Z
    //   1151: ifeq +14 -> 1165
    //   1154: aload_2
    //   1155: ldc_w 564
    //   1158: iconst_1
    //   1159: invokestatic 298	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1162: invokevirtual 272	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   1165: goto -1004 -> 161
    //   1168: aload_2
    //   1169: ldc_w 513
    //   1172: aload 16
    //   1174: getfield 567	com/tencent/mobileqq/data/ExtensionInfo:fontEffect	I
    //   1177: invokestatic 298	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1180: invokevirtual 272	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   1183: goto -233 -> 950
    //   1186: iconst_1
    //   1187: istore_3
    //   1188: aload 15
    //   1190: getstatic 547	QQService/EVIPSPEC:E_SP_QQVIP	LQQService/EVIPSPEC;
    //   1193: invokevirtual 532	com/tencent/mobileqq/data/Friends:getServiceType	(LQQService/EVIPSPEC;)I
    //   1196: iconst_1
    //   1197: if_icmpne +5 -> 1202
    //   1200: iconst_3
    //   1201: istore_3
    //   1202: aload 15
    //   1204: getstatic 547	QQService/EVIPSPEC:E_SP_QQVIP	LQQService/EVIPSPEC;
    //   1207: invokevirtual 539	com/tencent/mobileqq/data/Friends:getServiceLevel	(LQQService/EVIPSPEC;)I
    //   1210: istore 13
    //   1212: goto -112 -> 1100
    //   1215: astore 9
    //   1217: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1220: ifeq -682 -> 538
    //   1223: ldc 178
    //   1225: iconst_2
    //   1226: new 180	java/lang/StringBuilder
    //   1229: dup
    //   1230: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   1233: ldc_w 569
    //   1236: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1239: aload 9
    //   1241: invokevirtual 572	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1244: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1247: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1250: invokestatic 210	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1253: goto -715 -> 538
    //   1256: aload_2
    //   1257: checkcast 574	com/tencent/mobileqq/data/MessageForText
    //   1260: astore 14
    //   1262: aload 14
    //   1264: aload_1
    //   1265: getfield 201	com/tencent/mobileqq/activity/aio/SessionInfo:entrance	I
    //   1268: putfield 575	com/tencent/mobileqq/data/MessageForText:msgVia	I
    //   1271: aload 9
    //   1273: ifnull +10 -> 1283
    //   1276: aload 14
    //   1278: aload 9
    //   1280: putfield 576	com/tencent/mobileqq/data/MessageForText:atInfoList	Ljava/util/ArrayList;
    //   1283: aload 14
    //   1285: aload 10
    //   1287: invokevirtual 580	com/tencent/mobileqq/data/MessageForText:setSendMsgParams	(Lujt$d;)V
    //   1290: goto -752 -> 538
    //   1293: invokestatic 401	jof:a	()Ljof;
    //   1296: getfield 583	jof:aaQ	Z
    //   1299: ifeq -746 -> 553
    //   1302: invokestatic 401	jof:a	()Ljof;
    //   1305: iconst_0
    //   1306: putfield 583	jof:aaQ	Z
    //   1309: goto -756 -> 553
    //   1312: aload_1
    //   1313: getfield 586	com/tencent/mobileqq/activity/aio/SessionInfo:bey	Z
    //   1316: ifeq +15 -> 1331
    //   1319: aload_0
    //   1320: aload_2
    //   1321: aload_1
    //   1322: getfield 128	com/tencent/mobileqq/activity/aio/SessionInfo:aTl	Ljava/lang/String;
    //   1325: invokestatic 589	aegu:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;)V
    //   1328: goto -726 -> 602
    //   1331: aload_1
    //   1332: getfield 592	com/tencent/mobileqq/activity/aio/SessionInfo:bez	Z
    //   1335: ifeq -733 -> 602
    //   1338: aload_0
    //   1339: aload_2
    //   1340: aload_1
    //   1341: getfield 128	com/tencent/mobileqq/activity/aio/SessionInfo:aTl	Ljava/lang/String;
    //   1344: invokestatic 594	aegu:c	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;)V
    //   1347: goto -745 -> 602
    //   1350: iload 11
    //   1352: ifeq +29 -> 1381
    //   1355: aload_0
    //   1356: invokevirtual 154	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   1359: aload_2
    //   1360: invokevirtual 597	com/tencent/imcore/message/QQMessageFacade:B	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   1363: goto -641 -> 722
    //   1366: astore_0
    //   1367: ldc_w 599
    //   1370: iconst_1
    //   1371: ldc_w 601
    //   1374: aload_0
    //   1375: invokestatic 605	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1378: goto -656 -> 722
    //   1381: aload_0
    //   1382: invokevirtual 154	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   1385: aload_2
    //   1386: aconst_null
    //   1387: invokevirtual 608	com/tencent/imcore/message/QQMessageFacade:a	(Lcom/tencent/mobileqq/data/MessageRecord;Lachq;)V
    //   1390: goto -668 -> 722
    //   1393: new 610	com/tencent/mobileqq/activity/ChatActivityFacade$12
    //   1396: dup
    //   1397: iload 4
    //   1399: aload_0
    //   1400: aload_2
    //   1401: iload 11
    //   1403: invokespecial 613	com/tencent/mobileqq/activity/ChatActivityFacade$12:<init>	(ZLcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/ChatMessage;Z)V
    //   1406: bipush 10
    //   1408: aconst_null
    //   1409: iconst_0
    //   1410: invokestatic 619	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1413: goto -691 -> 722
    //   1416: sipush -1000
    //   1419: istore 12
    //   1421: goto -561 -> 860
    //   1424: ldc 229
    //   1426: astore 14
    //   1428: goto -1370 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1431	0	paramQQAppInterface	QQAppInterface
    //   0	1431	1	paramSessionInfo	SessionInfo
    //   0	1431	2	paramString	String
    //   0	1431	3	paramInt1	int
    //   0	1431	4	paramBoolean1	boolean
    //   0	1431	5	paramByte1	byte
    //   0	1431	6	paramByte2	byte
    //   0	1431	7	paramShort	short
    //   0	1431	8	paramInt2	int
    //   0	1431	9	paramArrayList	ArrayList<MessageForText.AtTroopMemberInfo>
    //   0	1431	10	paramd	ujt.d
    //   0	1431	11	paramBoolean2	boolean
    //   858	562	12	i	int
    //   1098	113	13	j	int
    //   56	1371	14	localObject1	Object
    //   878	325	15	localObject2	Object
    //   890	283	16	localExtensionInfo	ExtensionInfo
    // Exception table:
    //   from	to	target	type
    //   392	462	1215	java/lang/Exception
    //   462	510	1215	java/lang/Exception
    //   510	538	1215	java/lang/Exception
    //   706	722	1366	java/lang/Exception
    //   1355	1363	1366	java/lang/Exception
    //   1381	1390	1366	java/lang/Exception
  }
  
  public static long a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, long paramLong, int paramInt2)
  {
    if (paramString1 != null)
    {
      paramString1 = aoon.b(paramString1, paramString3, paramString4, paramLong, paramInt2);
      paramString3 = anbi.d(-20000);
      paramString3.selfuin = paramQQAppInterface.getCurrentAccountUin();
      paramString3.frienduin = paramString2;
      paramString3.senderuin = paramQQAppInterface.getCurrentAccountUin();
      paramString3.msg = paramString1;
      paramString3.msgtype = -20000;
      paramString3.isread = true;
      paramString3.issend = 1;
      paramString3.istroop = paramInt1;
      ((acle)paramQQAppInterface.getBusinessHandler(13)).W(paramString3);
      paramQQAppInterface.b().b(paramString3, paramQQAppInterface.getCurrentAccountUin());
      return paramString3.uniseq;
    }
    return 0L;
  }
  
  public static ChatMessage a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString)
  {
    if (paramSessionInfo == null) {}
    while (paramString == null) {
      return null;
    }
    paramQQAppInterface = anbi.a(paramQQAppInterface, paramSessionInfo.aTl, paramSessionInfo.troopUin, paramSessionInfo.cZ);
    paramQQAppInterface.path = paramString;
    paramQQAppInterface.size = 0L;
    paramQQAppInterface.type = 1;
    paramQQAppInterface.isRead = true;
    paramQQAppInterface.serial();
    return paramQQAppInterface;
  }
  
  public static ChatMessage a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, int paramInt1, boolean paramBoolean, byte paramByte1, byte paramByte2, short paramShort, int paramInt2, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, ujt.d paramd)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " createMsgQueueAndSend start, currenttime:" + System.currentTimeMillis() + " sessionInfo.entrance:" + paramSessionInfo.entrance);
    }
    if (paramString != null) {}
    for (String str = anbk.a(paramString, true, paramArrayList);; str = "")
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " createMsgQueueAndSend step 1  currenttime:" + System.currentTimeMillis());
      }
      if (paramd.mWantGiftSenderUin != 0L)
      {
        paramString = new MessageForWantGiftMsg();
        ((MessageForWantGiftMsg)paramString).wantGiftSenderUin = paramd.mWantGiftSenderUin;
        ((MessageForWantGiftMsg)paramString).saveExtInfoToExtStr(MessageForWantGiftMsg.GIFT_SENDER_UIN, paramd.mWantGiftSenderUin + "");
        paramString.msgtype = -2056;
      }
      for (;;)
      {
        anbi.a(paramQQAppInterface, paramString, paramSessionInfo.aTl, paramSessionInfo.troopUin, paramSessionInfo.cZ);
        paramString.msg = str;
        paramString.msgUid = anbk.I(paramInt2);
        paramString.longMsgCount = paramByte1;
        paramString.longMsgIndex = paramByte2;
        paramString.longMsgId = paramShort;
        paramString.mAnimFlag = true;
        if (paramd.aSL) {
          paramString.mRobotFlag = -1;
        }
        paramString.saveExtInfoToExtStr("robot_news_class_id", String.valueOf(paramd.bEX));
        if (!(paramString instanceof MessageForReplyText)) {
          break label732;
        }
        paramQQAppInterface = (MessageForReplyText)paramString;
        paramQQAppInterface.msgVia = paramSessionInfo.entrance;
        if (paramArrayList != null) {
          paramQQAppInterface.atInfoList = paramArrayList;
        }
        try
        {
          paramQQAppInterface.saveExtInfoToExtStr("sens_msg_source_msg_info", aqhs.bytes2HexStr(aczw.b(paramd.mSourceMsgInfo)));
          if ((!TextUtils.isEmpty(paramd.aLN)) && (!TextUtils.isEmpty(paramd.aLO)))
          {
            paramQQAppInterface.saveExtInfoToExtStr("sens_reply_special_msg", paramd.aLN);
            paramQQAppInterface.saveExtInfoToExtStr("sens_reply_special_at_list", paramd.aLO);
          }
          paramQQAppInterface.mSourceMsgInfo = paramd.mSourceMsgInfo;
          paramQQAppInterface.extLong |= 0x1;
        }
        catch (Exception paramQQAppInterface)
        {
          for (;;)
          {
            label358:
            if (QLog.isColorLevel()) {
              QLog.d("SendMsgBtn", 2, "Save sourceMsgInfo exception:" + paramQQAppInterface.getMessage());
            }
          }
        }
        if (paramString.istroop != 1) {
          break label765;
        }
        jof.a().a(paramString);
        label373:
        if (paramd.aTt) {
          afck.ae(paramString);
        }
        if (QLog.isColorLevel()) {
          QLog.d("SendMsgBtn", 2, " createMsgQueueAndSend step 2 time = " + paramString.time + " senderUin = " + paramString.senderuin + " msgUid = " + paramString.msgUid);
        }
        return paramString;
        if ((paramd.aLP != null) && (zxj.I(paramQQAppInterface)))
        {
          paramString = new MessageForFoldMsg();
          ((MessageForFoldMsg)paramString).init(false, paramd.aLP, paramd.aLQ, paramd.mPasswdRedBagSender, true);
        }
        else
        {
          if ((paramd.mSourceMsgInfo != null) || (!paramd.aTv) || (!ajkw.bc(paramQQAppInterface))) {
            break;
          }
          paramString = (ChatMessage)anbi.d(-1051);
        }
      }
      if (paramd.mSourceMsgInfo != null) {}
      for (paramInt1 = -1049;; paramInt1 = -1000)
      {
        paramString = (ChatMessage)anbi.d(paramInt1);
        ExtensionInfo localExtensionInfo = ((acff)paramQQAppInterface.getManager(51)).a(paramQQAppInterface.getCurrentUin(), false);
        if (localExtensionInfo != null)
        {
          paramString.saveExtInfoToExtStr("vip_font_id", String.valueOf(ku.a(localExtensionInfo)));
          paramString.saveExtInfoToExtStr("vip_sub_font_id", String.valueOf(ku.d(localExtensionInfo.uVipFont)));
          if (1 != localExtensionInfo.magicFont) {
            break label675;
          }
          paramString.saveExtInfoToExtStr("vip_font_effect_id", String.valueOf(0));
        }
        for (;;)
        {
          if (paramArrayList != null) {
            appb.a(paramSessionInfo.cZ, paramArrayList, paramString);
          }
          if ((paramInt1 == -1000) && (paramd.aTx)) {
            paramString.saveExtInfoToExtStr("key_message_extra_info_flag", String.valueOf(1));
          }
          break;
          label675:
          paramString.saveExtInfoToExtStr("vip_font_effect_id", String.valueOf(localExtensionInfo.fontEffect));
        }
        label732:
        paramQQAppInterface = (MessageForText)paramString;
        paramQQAppInterface.msgVia = paramSessionInfo.entrance;
        if (paramArrayList != null) {
          paramQQAppInterface.atInfoList = paramArrayList;
        }
        paramQQAppInterface.setSendMsgParams(paramd);
        break label358;
        label765:
        if (!jof.a().aaQ) {
          break label373;
        }
        jof.a().aaQ = false;
        break label373;
      }
    }
  }
  
  public static ChatMessage a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, ujt.d paramd)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " createTextMessage start, currenttime:" + System.currentTimeMillis());
    }
    String str = a(paramString, paramArrayList);
    if (str == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    boolean bool = false;
    short s = 0;
    Random localRandom = new Random();
    label512:
    for (;;)
    {
      try
      {
        if (a(paramd, false))
        {
          paramArrayList = b(str, paramArrayList, paramd, localArrayList);
          paramString = paramArrayList;
          if (!QLog.isColorLevel()) {
            break label512;
          }
          QLog.d("SendMsgBtn", 2, " createTextMessage step 1, partAtInfoArrayLists.size() = " + localArrayList.size() + " mSourceMsgInfo:true, symbolLens:" + str.getBytes("utf-8").length + " currenttime:" + System.currentTimeMillis());
          paramString = paramArrayList;
          if (QLog.isColorLevel()) {
            QLog.d("SendMsgBtn", 2, " createTextMessage step 2, currenttime:" + System.currentTimeMillis());
          }
          int i = Math.abs(localRandom.nextInt());
          str = (String)paramString.get(0);
          if (localArrayList.size() > 0)
          {
            paramArrayList = (ArrayList)localArrayList.get(0);
            if ((paramSessionInfo.cZ == 3000) || (paramSessionInfo.cZ == 1)) {
              i = Math.abs(localRandom.nextInt());
            }
            return a(paramQQAppInterface, paramSessionInfo, str, -1000, bool, (byte)paramString.size(), (byte)0, s, i, paramArrayList, paramd);
          }
        }
        else
        {
          if (a(paramQQAppInterface, paramSessionInfo, str, paramd))
          {
            paramArrayList = a(str, paramArrayList, paramd, localArrayList);
            paramString = paramArrayList;
            if (!QLog.isColorLevel()) {
              break label512;
            }
            QLog.d("SendMsgBtn", 2, " createTextMessage step 1, partAtInfoArrayLists.size() = " + localArrayList.size() + " isLongTextMsg:true, symbolLens:" + str.getBytes("utf-8").length + " currenttime:" + System.currentTimeMillis());
            paramString = paramArrayList;
            continue;
          }
          paramString = aqft.a(str, 560, 20, paramArrayList, localArrayList);
          if (paramString.size() > 1)
          {
            bool = true;
            if (QLog.isColorLevel()) {
              QLog.d("SendMsgBtn", 2, " createTextMessage step 1, partAtInfoArrayLists.size() = " + localArrayList.size() + " partArray.size() = " + paramString.size() + " isDivide = " + bool + " currenttime:" + System.currentTimeMillis());
            }
            s = a(paramQQAppInterface, paramSessionInfo, bool, (short)0, localRandom);
            continue;
          }
          bool = false;
          continue;
        }
        paramArrayList = null;
      }
      catch (UnsupportedEncodingException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        return null;
      }
    }
  }
  
  public static MessageForPtt a(QQAppInterface paramQQAppInterface, String paramString, SessionInfo paramSessionInfo, int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject1 = localObject2;
      if (paramSessionInfo != null)
      {
        int i = paramSessionInfo.cZ;
        localObject1 = anbi.a(paramQQAppInterface, paramSessionInfo.aTl, paramSessionInfo.troopUin, i);
        ((MessageForPtt)localObject1).url = MessageForPtt.getMsgFilePath(paramInt2, paramString);
        ((MessageForPtt)localObject1).fileSize = paramInt1;
        ((MessageForPtt)localObject1).itemType = 2;
        if ((!anvq.lJ(i)) || (!anvq.bD(paramQQAppInterface))) {
          break label186;
        }
        paramInt1 = 1;
        ((MessageForPtt)localObject1).sttAbility = paramInt1;
        ((MessageForPtt)localObject1).voiceType = paramInt2;
        ((MessageForPtt)localObject1).longPttVipFlag = anbk.k(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin());
        jof.a().a((MessageRecord)localObject1);
        if ((paramSessionInfo.cZ != 1033) && ((paramSessionInfo.cZ != 1034) || (paramSessionInfo.topicId <= 0))) {
          break label191;
        }
        aegu.a(paramQQAppInterface, (MessageRecord)localObject1, paramSessionInfo.aTl, paramSessionInfo.cZ, paramSessionInfo.topicId);
      }
    }
    for (;;)
    {
      ((MessageForPtt)localObject1).serial();
      ((acle)paramQQAppInterface.getBusinessHandler(13)).W((MessageRecord)localObject1);
      return localObject1;
      label186:
      paramInt1 = 0;
      break;
      label191:
      if (paramSessionInfo.bey) {
        aegu.b(paramQQAppInterface, (MessageRecord)localObject1, paramSessionInfo.aTl);
      } else if (paramSessionInfo.bez) {
        aegu.c(paramQQAppInterface, (MessageRecord)localObject1, paramSessionInfo.aTl);
      }
    }
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (top.fv(paramSessionInfo.cZ))
    {
      paramQQAppInterface = paramQQAppInterface.b().k(paramSessionInfo.aTl, paramSessionInfo.cZ);
      if ((paramQQAppInterface != null) && (!paramQQAppInterface.isEmpty()))
      {
        int i = paramQQAppInterface.size() - 1;
        while (i >= 0)
        {
          paramSessionInfo = (MessageRecord)paramQQAppInterface.get(i);
          if (!aqiu.mt(paramSessionInfo.issend)) {
            return paramSessionInfo;
          }
          i -= 1;
        }
      }
    }
    return null;
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, MessageForPtt paramMessageForPtt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramSessionInfo != null)
    {
      localObject1 = localObject2;
      if (paramMessageForPtt != null)
      {
        localObject1 = anbi.e(paramMessageForPtt);
        ((acle)paramQQAppInterface.getBusinessHandler(13)).W((MessageRecord)localObject1);
        paramQQAppInterface.b().b((MessageRecord)localObject1, paramQQAppInterface.getCurrentAccountUin());
      }
    }
    return localObject1;
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, String paramString, SessionInfo paramSessionInfo, int paramInt1, int paramInt2)
  {
    paramString = a(paramQQAppInterface, paramString, paramSessionInfo, paramInt1, paramInt2);
    if (paramString != null)
    {
      paramString.msgVia = paramSessionInfo.entrance;
      paramQQAppInterface.b().b(paramString, paramQQAppInterface.getCurrentAccountUin());
    }
    while (!QLog.isColorLevel()) {
      return paramString;
    }
    QLog.d("ChatActivityFacade", 2, "createPttMessage null");
    return paramString;
  }
  
  public static AbsShareMsg a(Context paramContext, MessageRecord paramMessageRecord, String paramString)
  {
    int i = 50;
    if (paramMessageRecord == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if ((paramMessageRecord instanceof MessageForMixedMsg))
    {
      paramString = new StringBuilder();
      paramString.append(MessageForMixedMsg.getTextFromMixedMsg((MessageForMixedMsg)paramMessageRecord));
      paramMessageRecord = a(paramContext, (int)(BaseChatItemLayout.bNT * 0.8F), 2, 30, paramString.toString()).toString();
      localArrayList.add(new StructMsgItemTitle(paramMessageRecord));
      paramString = paramMessageRecord;
      if (paramMessageRecord.length() > 30) {
        paramString = paramMessageRecord.substring(0, 30);
      }
      paramMessageRecord = paramContext.getString(2131691410);
      paramContext = new AbsShareMsg.a(StructMsgForGeneralShare.class).c(35).a(paramString).a(3).a("viewMultiMsg", "", null, null, null).a(paramMessageRecord, null).d(paramContext.getResources().getString(2131696121)).a();
      paramMessageRecord = new ansv(localArrayList);
      paramMessageRecord.a(new anst());
      paramMessageRecord.a(new anux(acfp.m(2131703570)));
      paramContext.addItem(paramMessageRecord);
      return paramContext;
    }
    label244:
    String str;
    if ((paramMessageRecord instanceof MessageForReplyText))
    {
      paramString = (MessageForReplyText)paramMessageRecord;
      if (paramString.sb != null)
      {
        paramString = paramString.sb.toString();
        str = paramString;
        if (aofy.Z(paramString)) {
          str = aofy.M(paramString);
        }
        if (!jof.a(paramMessageRecord)) {
          break label386;
        }
      }
    }
    for (;;)
    {
      paramMessageRecord = a(paramContext, (int)(BaseChatItemLayout.bNT * 0.8F), 2, i, str).toString();
      break;
      paramString = paramString.msg;
      break label244;
      paramString = (MessageForLongTextMsg)paramMessageRecord;
      if (paramString.sb != null)
      {
        paramString = paramString.sb.toString();
        label323:
        str = paramString;
        if (aofy.Z(paramString)) {
          str = aofy.M(paramString);
        }
        if (!jof.a(paramMessageRecord)) {
          break label380;
        }
      }
      for (;;)
      {
        paramMessageRecord = a(paramContext, (int)(BaseChatItemLayout.bNT * 0.8F), 2, i, str).toString();
        break;
        paramString = paramString.msg;
        break label323;
        label380:
        i = 60;
      }
      label386:
      i = 60;
    }
  }
  
  public static AbsShareMsg a(Context paramContext, String paramString, List<ChatMessage> paramList, Map<String, String> paramMap, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() == 0) || (paramMap == null)) {
      return null;
    }
    String str = "";
    ArrayList localArrayList = new ArrayList();
    int j;
    int k;
    int i;
    label51:
    Object localObject2;
    Object localObject3;
    Object localObject1;
    if (paramList.size() >= 4)
    {
      j = 4;
      k = 0;
      i = 4;
      if ((k >= j) || (i <= 0)) {
        break label692;
      }
      localObject2 = new StringBuilder();
      localObject3 = (ChatMessage)paramList.get(k);
      localObject1 = "";
      if (!paramBoolean) {
        break label317;
      }
      localObject1 = (String)paramMap.get(top.g((MessageRecord)localObject3));
      paramString = (String)localObject1;
      if (((ChatMessage)localObject3).istroop == 1) {
        paramString = aofy.oj((String)localObject1);
      }
      label128:
      if ((TextUtils.isEmpty(paramString)) || (paramString.trim().length() == 0)) {
        break label368;
      }
      localObject1 = paramString;
      if (paramString.length() > 12) {
        localObject1 = paramString.substring(0, 11) + "...";
      }
      label185:
      if (!(localObject3 instanceof MessageForPic)) {
        break label381;
      }
      paramString = ((ChatMessage)localObject3).getSummaryMsg();
    }
    label317:
    label368:
    label1404:
    for (;;)
    {
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(":  ");
      ((StringBuilder)localObject2).append(paramString);
      localObject1 = new boolean[1];
      localArrayList.add(new StructMsgItemTitle(a(paramContext, (int)(BaseChatItemLayout.bNT * 0.8F), 3, 46, ((StringBuilder)localObject2).toString(), (boolean[])localObject1).toString()));
      int m = i - 1;
      i = m;
      if (localObject1[0] != 0) {
        i = m - 1;
      }
      k += 1;
      str = paramString;
      break label51;
      j = paramList.size();
      break;
      Object localObject4 = new ArrayList(paramMap.values());
      paramString = (String)localObject1;
      if (localObject4 == null) {
        break label128;
      }
      paramString = (String)localObject1;
      if (((List)localObject4).isEmpty()) {
        break label128;
      }
      paramString = (String)((List)localObject4).get(0);
      break label128;
      localObject1 = ajlg.me(((ChatMessage)localObject3).senderuin);
      break label185;
      label381:
      if ((localObject3 instanceof MessageForShortVideo))
      {
        if (((ChatMessage)localObject3).msgtype == -2071) {
          paramString = acfp.m(2131703574);
        } else {
          paramString = acfp.m(2131703583);
        }
      }
      else
      {
        if ((localObject3 instanceof MessageForText))
        {
          paramString = (MessageForText)localObject3;
          if (paramString.sb != null) {}
          for (paramString = paramString.sb.toString();; paramString = paramString.msg)
          {
            str = paramString;
            if (aofy.Z(paramString)) {
              str = aofy.M(paramString);
            }
            paramString = str;
            break;
          }
        }
        if ((localObject3 instanceof MessageForQQStoryComment))
        {
          paramString = ((MessageForQQStoryComment)localObject3).comment;
        }
        else if (((localObject3 instanceof MessageForMixedMsg)) || ((localObject3 instanceof MessageForLongMsg)))
        {
          paramString = MessageForMixedMsg.getTextFromMixedMsg((ChatMessage)localObject3).toString();
        }
        else if ((localObject3 instanceof MessageForStructing))
        {
          paramString = ((ChatMessage)localObject3).getSummaryMsg();
        }
        else if ((localObject3 instanceof MessageForArkApp))
        {
          paramString = ((MessageForArkApp)localObject3).getSummery();
        }
        else if ((localObject3 instanceof MessageForArkBabyqReply))
        {
          paramString = ((MessageForArkBabyqReply)localObject3).getSummery();
        }
        else if ((localObject3 instanceof MessageForArkFlashChat))
        {
          paramString = ((MessageForArkFlashChat)localObject3).getSummery();
        }
        else if ((localObject3 instanceof MessageForReplyText))
        {
          paramString = (MessageForReplyText)localObject3;
          paramString.parse();
          paramString = paramString.getSummaryMsg();
        }
        else if ((localObject3 instanceof MessageForFile))
        {
          paramString = ((MessageForFile)localObject3).getSummaryMsg();
        }
        else if ((localObject3 instanceof MessageForTroopFile))
        {
          paramString = ((MessageForTroopFile)localObject3).getSummaryMsg();
        }
        else if ((localObject3 instanceof MessageForPtt))
        {
          paramString = acfp.m(2131703591);
          continue;
          paramString = paramContext.getString(2131691410);
          localObject3 = new AbsShareMsg.a(StructMsgForGeneralShare.class).c(35).a(acfp.m(2131703590)).a(3).a("viewMultiMsg", "", null, null, null).a(paramString, null).a();
          localObject4 = new ansv();
          ChatMessage localChatMessage = (ChatMessage)paramList.get(0);
          if ((localChatMessage.istroop == 1) || (localChatMessage.istroop == 3000)) {
            paramContext = acfp.m(2131703571);
          }
          for (;;)
          {
            paramString = paramContext;
            if (TextUtils.isEmpty(paramContext))
            {
              QLog.w("ChatActivityFacade", 1, "generateMultiMsgForwardStructMsg: titleStr is null");
              paramString = acfp.m(2131703587);
            }
            if (QLog.isColorLevel()) {
              QLog.d("MultiMsg_TAG.Nest", 2, String.format("step.generateStructMsgContent:titleStr = %s,listSize = %d,firstMsg.istroop = %d", new Object[] { paramString, Integer.valueOf(paramList.size()), Integer.valueOf(localChatMessage.istroop) }));
            }
            paramContext = new StructMsgItemTitle(paramString);
            paramContext.Rr("34");
            paramContext.Rs("12");
            paramContext.Rt("2");
            ((anqv)localObject4).a(paramContext);
            paramContext = localArrayList.iterator();
            for (;;)
            {
              if (paramContext.hasNext())
              {
                paramString = (anqu)paramContext.next();
                if ((paramString instanceof anqw))
                {
                  paramMap = (anqw)paramString;
                  paramMap.Rr("26");
                  paramMap.Rq("#777777");
                  paramMap.Rs("12");
                  paramMap.Rt("4");
                }
                ((anqv)localObject4).a(paramString);
                continue;
                if (localChatMessage.istroop != 0) {
                  break label1404;
                }
                paramString = localChatMessage.senderuin;
                if (TextUtils.equals(localChatMessage.senderuin, localChatMessage.selfuin))
                {
                  localObject1 = localChatMessage.frienduin;
                  label1022:
                  localObject2 = (String)paramMap.get(paramString);
                  str = (String)paramMap.get(localObject1);
                  boolean bool = true;
                  paramString = "";
                  i = 0;
                  paramBoolean = bool;
                  if (i >= paramList.size()) {
                    break label1128;
                  }
                  paramMap = (ChatMessage)paramList.get(i);
                  if (!TextUtils.isEmpty(paramString)) {
                    break label1114;
                  }
                  paramString = paramMap.senderuin;
                }
              }
            }
            for (;;)
            {
              i += 1;
              break label1056;
              localObject1 = localChatMessage.selfuin;
              break label1022;
              if (!TextUtils.equals(paramString, paramMap.senderuin))
              {
                paramBoolean = false;
                if ((localObject2 == null) || (((String)localObject2).trim().length() == 0)) {
                  QLog.d("MultiMsg_TAG", 2, "firstNick is null !!!");
                }
                for (paramString = ajlg.me(localChatMessage.senderuin);; paramString = (String)localObject2)
                {
                  if (str != null)
                  {
                    paramMap = str;
                    if (str.trim().length() != 0) {}
                  }
                  else
                  {
                    paramMap = str;
                    if (!paramBoolean)
                    {
                      QLog.d("MultiMsg_TAG", 2, "!hasOnlyOneSender !!! empty nick for receiver");
                      paramMap = ajlg.me((String)localObject1);
                    }
                  }
                  localObject1 = new Paint();
                  ((Paint)localObject1).setTextSize(34.0F);
                  paramContext = a(paramContext, paramString, paramMap, 2, (int)(BaseChatItemLayout.bNT * 0.7F), 2048, (Paint)localObject1, paramBoolean);
                  break;
                  ((anqv)localObject4).a(new anst());
                  paramContext = new anux(String.format(acfp.m(2131703568), new Object[] { Integer.valueOf(paramList.size()) }));
                  paramContext.Rr("26");
                  paramContext.Rq("#777777");
                  ((anqv)localObject4).a(paramContext);
                  ((AbsShareMsg)localObject3).addItem((anqu)localObject4);
                  ((AbsShareMsg)localObject3).mTSum = paramList.size();
                  if (QLog.isColorLevel())
                  {
                    paramContext = ansi.compress(((AbsShareMsg)localObject3).getXmlBytes());
                    paramString = new StringBuilder().append("generateStructMsgLength = ");
                    if (paramContext != null) {
                      break label1388;
                    }
                  }
                  for (i = 0;; i = paramContext.length)
                  {
                    QLog.d("MultiMsg_TAG", 2, i);
                    return localObject3;
                  }
                }
              }
            }
            paramContext = "";
          }
        }
        else
        {
          paramString = str;
        }
      }
    }
  }
  
  private static CharSequence a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    return a(paramContext, paramInt1, paramInt2, paramInt3, paramCharSequence, null);
  }
  
  private static CharSequence a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence, boolean[] paramArrayOfBoolean)
  {
    paramContext = paramContext.getResources();
    TextPaint localTextPaint = new TextPaint(1);
    localTextPaint.density = paramContext.getDisplayMetrics().density;
    int k = paramCharSequence.length();
    int i = 0;
    int j = i;
    if (i < k)
    {
      float f = Layout.getDesiredWidth(paramCharSequence, 0, i + 1, localTextPaint);
      if ((f > paramInt1) && (paramArrayOfBoolean != null) && (paramArrayOfBoolean.length > 0)) {
        paramArrayOfBoolean[0] = true;
      }
      if (f > paramInt1 * paramInt2) {
        j = i - 1;
      }
    }
    else if (j >= k)
    {
      paramContext = paramCharSequence;
      if (j <= paramInt3) {}
    }
    else
    {
      if (j <= paramInt3) {
        break label171;
      }
    }
    for (;;)
    {
      paramContext = paramCharSequence.subSequence(0, paramInt3).toString() + "…";
      return paramContext;
      i += 1;
      break;
      label171:
      paramInt3 = j;
    }
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, Paint paramPaint, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityFacade", 2, "adjustTitleByNick() called with: firstNick = [" + paramString1 + "], secondNick = [" + paramString2 + "]");
    }
    String str = "";
    if (TextUtils.isEmpty(paramString1))
    {
      paramContext = str;
      return paramContext;
    }
    str = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str = "";
    }
    paramString2 = paramString1 + acfp.m(2131703576) + str + acfp.m(2131703569);
    if (paramBoolean) {
      paramString2 = paramString1 + acfp.m(2131703593);
    }
    TextView localTextView = new TextView(paramContext);
    localTextView.getPaint().set(paramPaint);
    localTextView.setLayoutParams(new ViewGroup.LayoutParams(paramInt2, -2));
    localTextView.setText(paramString2);
    int i = View.MeasureSpec.makeMeasureSpec(paramInt2, -2147483648);
    int j = View.MeasureSpec.makeMeasureSpec(paramInt3, -2147483648);
    localTextView.measure(i, j);
    if (localTextView.getLineCount() > paramInt1)
    {
      paramContext = null;
      paramInt2 = 0;
      label231:
      if (paramInt2 <= paramString1.length())
      {
        paramInt3 = paramInt2;
        label244:
        paramString2 = paramString1.substring(0, paramInt3);
        if (paramInt2 > str.length()) {
          break label403;
        }
      }
      label403:
      for (paramInt3 = paramInt2;; paramInt3 = str.length())
      {
        paramPaint = str.substring(0, paramInt3);
        if (!paramBoolean) {
          break label413;
        }
        paramString2 = paramString2 + acfp.m(2131703596);
        localTextView.setText(paramString2);
        localTextView.measure(i, j);
        paramInt3 = localTextView.getLineCount();
        if (QLog.isColorLevel()) {
          QLog.d("ChatActivityFacade", 2, "adjustTitleByNick() called title=[" + paramString2 + "],lineCount=[" + paramInt3 + "]");
        }
        if (paramInt3 > paramInt1) {
          break;
        }
        paramInt2 += 1;
        paramContext = paramString2;
        break label231;
        paramInt3 = paramString1.length();
        break label244;
      }
      label413:
      if (paramInt2 < paramString1.length()) {
        paramString2 = paramString2 + "...";
      }
      for (;;)
      {
        paramString2 = paramString2 + acfp.m(2131703584);
        paramPaint = paramString2 + paramPaint;
        paramString2 = paramPaint;
        if (paramInt2 < str.length()) {
          paramString2 = paramPaint + "...";
        }
        paramString2 = paramString2 + acfp.m(2131703592);
        break;
      }
    }
    return paramString2;
  }
  
  private static String a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString)
  {
    paramQQAppInterface = paramQQAppInterface.getCurrentUin();
    paramSessionInfo = paramSessionInfo.aTl;
    return paramString + "_" + paramQQAppInterface + "_" + paramSessionInfo;
  }
  
  public static String a(String paramString, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList)
  {
    int i = 0;
    int j = 0;
    while ((i < paramString.length()) && (paramString.codePointAt(i) == 0))
    {
      j += 1;
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " createTextMessageToshow, at info starts with char 0");
      }
      i += 1;
    }
    Object localObject = paramString;
    if (j > 0)
    {
      if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
      {
        paramArrayList = paramArrayList.iterator();
        do
        {
          if (!paramArrayList.hasNext()) {
            break;
          }
          localObject = (MessageForText.AtTroopMemberInfo)paramArrayList.next();
          ((MessageForText.AtTroopMemberInfo)localObject).startPos = ((short)(((MessageForText.AtTroopMemberInfo)localObject).startPos - j));
        } while (((MessageForText.AtTroopMemberInfo)localObject).startPos >= 0);
        if (QLog.isColorLevel()) {
          QLog.e("SendMsgBtn", 2, " createTextMessageToshow error, at info starts with char 0");
        }
        localObject = null;
      }
    }
    else {
      return localObject;
    }
    return paramString.substring(j);
  }
  
  public static String a(List<ChatMessage> paramList, Map<String, String> paramMap)
  {
    if ((paramList == null) || (paramList.size() == 0) || (paramMap == null)) {
      return null;
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    int i;
    int j;
    label42:
    StringBuilder localStringBuilder2;
    Object localObject2;
    Object localObject1;
    if (paramList.size() >= 4)
    {
      i = 4;
      j = 0;
      if (j >= i) {
        break label583;
      }
      localStringBuilder2 = new StringBuilder();
      localObject2 = (ChatMessage)paramList.get(j);
      localObject1 = (String)paramMap.get(top.g((MessageRecord)localObject2));
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label589;
      }
    }
    for (;;)
    {
      if ((localObject2 instanceof MessageForPic))
      {
        localObject2 = acfp.m(2131703594);
        localStringBuilder2.append((String)localObject1);
        localStringBuilder2.append(": ");
        localStringBuilder2.append((String)localObject2);
        localStringBuilder1.append(localStringBuilder2.toString());
        localStringBuilder1.append("\r\n");
      }
      label234:
      label372:
      do
      {
        for (;;)
        {
          j += 1;
          break label42;
          i = paramList.size();
          break;
          if (!(localObject2 instanceof MessageForShortVideo)) {
            break label234;
          }
          localObject2 = acfp.m(2131703582);
          localStringBuilder2.append((String)localObject1);
          localStringBuilder2.append(": ");
          localStringBuilder2.append((String)localObject2);
          localStringBuilder1.append(localStringBuilder2.toString());
          localStringBuilder1.append("\r\n");
        }
        if ((localObject2 instanceof MessageForText))
        {
          localObject2 = (MessageForText)localObject2;
          if (((MessageForText)localObject2).sb != null)
          {
            localObject2 = ((MessageForText)localObject2).sb.toString();
            localStringBuilder2.append((String)localObject1);
            localStringBuilder2.append(": ");
            localStringBuilder2.append((String)localObject2);
            localObject2 = localStringBuilder2.toString();
            localObject1 = localObject2;
            if (aofy.Z((String)localObject2)) {
              localObject1 = aofy.M((String)localObject2);
            }
            if (((String)localObject1).length() <= 16) {
              break label372;
            }
            localStringBuilder1.append(((String)localObject1).substring(0, 16)).append("...");
          }
          for (;;)
          {
            localStringBuilder1.append("\r\n");
            break;
            localObject2 = ((MessageForText)localObject2).msg;
            break label269;
            localStringBuilder1.append((String)localObject1);
          }
        }
        if (((localObject2 instanceof MessageForMixedMsg)) || ((localObject2 instanceof MessageForLongMsg)))
        {
          localStringBuilder2.append((String)localObject1);
          localStringBuilder2.append(": ");
          localStringBuilder2.append(MessageForMixedMsg.getTextFromMixedMsg((ChatMessage)localObject2));
          localObject1 = aofy.iF(localStringBuilder2.toString());
          if (((String)localObject1).length() > 16) {
            localStringBuilder1.append(((String)localObject1).substring(0, 16)).append("...");
          }
          for (;;)
          {
            localStringBuilder1.append("\r\n");
            break;
            localStringBuilder1.append((String)localObject1);
          }
        }
      } while (!(localObject2 instanceof MessageForStructing));
      label269:
      localObject2 = ((ChatMessage)localObject2).getSummaryMsg();
      localStringBuilder2.append((String)localObject1);
      localStringBuilder2.append(": ");
      localStringBuilder2.append((String)localObject2);
      if (((String)localObject2).length() > 16) {
        localStringBuilder1.append(((String)localObject2).substring(0, 16)).append("...");
      }
      for (;;)
      {
        localStringBuilder1.append("\r\n");
        break;
        localStringBuilder1.append((String)localObject2);
      }
      label583:
      return localStringBuilder1.toString();
      label589:
      localObject1 = " ";
    }
  }
  
  @NonNull
  private static ArrayList<String> a(String paramString, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, ujt.d paramd, ArrayList<ArrayList<MessageForText.AtTroopMemberInfo>> paramArrayList1)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    paramArrayList1.add(paramArrayList);
    paramd.aTv = true;
    return localArrayList;
  }
  
  public static JSONObject a(NewestFeedInfo paramNewestFeedInfo, boolean paramBoolean, int paramInt)
  {
    if (paramNewestFeedInfo == null) {
      return null;
    }
    Object localObject = acfp.m(2131703589);
    paramNewestFeedInfo.strTitle = paramNewestFeedInfo.strTitle.replaceAll("\\[em\\]e\\d{1,}\\[/em\\]", (String)localObject);
    paramNewestFeedInfo.strSummary = paramNewestFeedInfo.strSummary.replaceAll("\\[em\\]e\\d{1,}\\[/em\\]", (String)localObject);
    paramNewestFeedInfo.strContent = paramNewestFeedInfo.strContent.replaceAll("\\[em\\]e\\d{1,}\\[/em\\]", (String)localObject);
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("appid", paramNewestFeedInfo.uAppid);
      ((JSONObject)localObject).put("title", paramNewestFeedInfo.strTitle);
      ((JSONObject)localObject).put("actionUrl", paramNewestFeedInfo.strJmpUrl);
      ((JSONObject)localObject).put("content", paramNewestFeedInfo.strContent);
      ((JSONObject)localObject).put("coverImageUrl", paramNewestFeedInfo.strImgUrl);
      ((JSONObject)localObject).put("fromuin", paramNewestFeedInfo.uHostUin);
      ((JSONObject)localObject).put("imageCount", paramNewestFeedInfo.uImgCount);
      ((JSONObject)localObject).put("lbsinfo", paramNewestFeedInfo.strLBSInfo);
      ((JSONObject)localObject).put("summery", paramNewestFeedInfo.strSummary);
      ((JSONObject)localObject).put("time", paramNewestFeedInfo.uTime);
      ((JSONObject)localObject).put("version", 2);
      ((JSONObject)localObject).put("likeNums", paramNewestFeedInfo.uLikeNum);
      ((JSONObject)localObject).put("commentNums", paramNewestFeedInfo.uCommentNum);
      ((JSONObject)localObject).put("isFirstMsgWithNewFriend", paramBoolean);
      ((JSONObject)localObject).put("iGender", paramInt);
      if ((paramNewestFeedInfo.mapEx != null) && (!paramNewestFeedInfo.mapEx.isEmpty())) {
        ((JSONObject)localObject).put("mapExt", new JSONObject(paramNewestFeedInfo.mapEx).toString());
      }
      if ((paramNewestFeedInfo.mediaData != null) && (paramNewestFeedInfo.mediaData.size() > 0))
      {
        JSONArray localJSONArray = new JSONArray();
        paramNewestFeedInfo = paramNewestFeedInfo.mediaData.iterator();
        while (paramNewestFeedInfo.hasNext())
        {
          Media_Data localMedia_Data = (Media_Data)paramNewestFeedInfo.next();
          MessageForQzoneFeed.MediaData localMediaData = new MessageForQzoneFeed.MediaData();
          localMediaData.uType = localMedia_Data.uType;
          localMediaData.strImgUrl = localMedia_Data.strImgUrl;
          localMediaData.extendInfo = localMedia_Data.extendInfo;
          localJSONArray.put(localMediaData.toJson());
        }
        ((JSONObject)localObject).put("mediaDatas", localJSONArray.toString());
      }
      return localObject;
    }
    catch (JSONException paramNewestFeedInfo) {}
    return null;
  }
  
  private static short a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean, short paramShort, Random paramRandom)
  {
    if (paramBoolean)
    {
      int i = amzo.seq;
      amzo.seq = i + 1;
      paramShort = (short)(byte)i;
      i = 0;
      for (;;)
      {
        short s = paramShort;
        if (paramQQAppInterface.a().i(paramQQAppInterface.getAccount(), paramSessionInfo.cZ, paramShort))
        {
          if (i > 10) {
            s = (short)(byte)paramQQAppInterface.a().al(paramQQAppInterface.getAccount(), paramSessionInfo.cZ);
          }
        }
        else
        {
          paramQQAppInterface.a().aD(paramQQAppInterface.getAccount(), paramSessionInfo.cZ, s);
          return s;
        }
        paramShort = (short)(byte)Math.abs(paramRandom.nextInt());
        i += 1;
      }
    }
    return paramShort;
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, Bundle paramBundle)
  {
    paramString4 = jqn.a(paramString4, 45, "UTF-8", "...");
    paramString5 = jqn.a(paramString5, 90, "UTF-8", "...");
    if (!paramContext.getResources().getString(2131698324).equals(paramString4))
    {
      paramString3 = paramContext.getResources().getString(2131692313) + " " + paramString4;
      paramString6 = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.PoiMapActivity&type=sharedmap&lat=" + paramString1 + "&lon=" + paramString2 + "&title=" + paramString4 + "&loc=" + paramString5 + "&dpid=" + paramString6;
      paramString3 = new AbsShareMsg.a(StructMsgForGeneralShare.class).c(32).a(paramString3).d("").a("plugin", "", paramString6, "", "").a();
      paramString6 = anrd.a(2);
      paramString6.aU("https://pub.idqqimg.com/pc/misc/lbsshare_icon.jpg", paramString4, paramString5);
      paramString3.addItem(paramString6);
      if ((paramSessionInfo == null) || (paramSessionInfo.cZ != 1008) || (!(paramContext instanceof FragmentActivity))) {
        break label521;
      }
      paramContext = ((FragmentActivity)paramContext).getChatFragment();
      if (paramContext == null) {
        break label521;
      }
      paramContext = paramContext.a();
      if ((paramContext == null) || (paramContext.sessionInfo == null) || (!(paramContext instanceof ycd))) {
        break label521;
      }
    }
    label521:
    for (boolean bool = ((ycd)paramContext).blO;; bool = false)
    {
      if ((paramSessionInfo != null) && ((paramSessionInfo.cZ == 1025) || (paramSessionInfo.cZ == 1024) || ((paramSessionInfo.cZ == 0) && (jou.df(paramSessionInfo.aTl))) || (bool)))
      {
        paramContext = anbi.d(-1000);
        l = anaz.gQ();
        i = paramSessionInfo.cZ;
        paramString1 = ujs.aLM + "http://maps.google.com/maps?q=" + paramString1 + "," + paramString2 + "&iwloc=A&hl=zh-CN (" + paramString5 + ")";
        paramContext.init(paramQQAppInterface.getCurrentAccountUin(), paramSessionInfo.aTl, paramQQAppInterface.getCurrentAccountUin(), paramString1, l, -1000, i, l);
        paramContext.issend = 1;
        paramQQAppInterface.b().a(paramContext, null);
      }
      while (paramSessionInfo == null)
      {
        long l;
        int i;
        return;
        paramString3 = paramContext.getResources().getString(2131692313);
        break;
      }
      if (paramBundle != null) {
        paramString3.forwardID = paramBundle.getInt("KEY_MSG_FORWARD_ID");
      }
      if (a(paramSessionInfo, paramString5, paramBundle))
      {
        a(paramQQAppInterface, paramSessionInfo, paramString1, paramString2, paramString4, paramString5, paramString3, paramString7, paramString8, paramString9);
        return;
      }
      a(paramQQAppInterface, paramSessionInfo, paramString3);
      return;
    }
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    c(paramQQAppInterface, paramChatMessage);
    if ((((paramContext instanceof SplashActivity)) || ((paramContext instanceof ChatActivity))) && (((FragmentActivity)paramContext).getChatFragment() != null) && (((FragmentActivity)paramContext).getChatFragment().a() != null))
    {
      ((FragmentActivity)paramContext).getChatFragment().a().a(paramChatMessage);
      if ((paramChatMessage instanceof MessageForArkApp)) {
        adrm.a().iU(paramChatMessage.uniseq);
      }
      if (((StructLongMessageDownloadProcessor.aZ(paramChatMessage)) || (StructLongMessageDownloadProcessor.bb(paramChatMessage))) && ((paramChatMessage instanceof MessageForStructing))) {
        StructLongMessageDownloadProcessor.u(paramQQAppInterface, ((MessageForStructing)paramChatMessage).uniseq);
      }
      if ((paramChatMessage instanceof MessageForApollo))
      {
        MessageForApollo localMessageForApollo = (MessageForApollo)paramChatMessage;
        if (localMessageForApollo != null)
        {
          abrb.a(localMessageForApollo.uniseq, paramQQAppInterface, "del_msg");
          if ((localMessageForApollo.mApolloMessage != null) && ((paramContext instanceof FragmentActivity)))
          {
            paramContext = ((FragmentActivity)paramContext).getChatFragment().a();
            if ((paramContext != null) && (paramContext.sessionInfo != null)) {
              VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "del_success", ApolloUtil.gi(paramContext.sessionInfo.cZ), 0, new String[] { Integer.toString(localMessageForApollo.mApolloMessage.id) });
            }
          }
        }
      }
      if ((paramChatMessage instanceof MessageForFile))
      {
        paramContext = ahav.a(paramQQAppInterface, (MessageForFile)paramChatMessage);
        paramQQAppInterface.a().ca(paramContext.nSessionId);
        anot.a(paramQQAppInterface, "CliOper", "", "", "0X8006447", "0X8006447", 0, 0, "6", "", "", "");
      }
      if ((paramChatMessage instanceof MessageForLightVideo)) {
        ainb.d(paramQQAppInterface, paramChatMessage);
      }
      paramContext = paramChatMessage.getExtInfoFromExtStr("tim_aio_gary_uniseq");
      if (QLog.isDebugVersion()) {
        QLog.i("AIOMessageSpreadManager", 1, "del garyTips id[" + paramContext + "],targetId[" + paramChatMessage.msgUid + "], hashCode:" + paramChatMessage.hashCode());
      }
      if (TextUtils.isEmpty(paramContext)) {}
    }
    try
    {
      long l = Long.parseLong(paramContext);
      paramQQAppInterface.b().d(paramChatMessage.frienduin, paramChatMessage.istroop, l, true);
      ((aqrc)paramQQAppInterface.getManager(235)).c.ah(paramChatMessage);
      return;
      ThreadManager.post(new ChatActivityFacade.15(paramQQAppInterface, paramChatMessage), 8, null, true);
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        QLog.e("ChatActivityFacade", 1, paramContext.toString());
      }
    }
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, List<ChatMessage> paramList)
  {
    paramQQAppInterface = new ChatActivityFacade.17(paramContext, paramList, paramQQAppInterface);
    paramList = (InputMethodManager)paramContext.getSystemService("input_method");
    boolean bool = paramList.isActive();
    if (((paramContext instanceof Activity)) && (bool)) {
      paramList.hideSoftInputFromWindow(((Activity)paramContext).getWindow().getDecorView().getWindowToken(), 0);
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        new Handler(paramContext.getMainLooper()).postDelayed(paramQQAppInterface, 60L);
        return;
      }
      paramQQAppInterface.run();
      return;
    }
  }
  
  public static void a(aqoa paramaqoa, Context paramContext, int paramInt)
  {
    if ((!AppSetting.aNY) && (paramInt == 0)) {}
    while (top.eD(paramInt) == 1032) {
      return;
    }
    paramaqoa.Z(2131365686, paramContext.getString(2131691404), 2130839081);
  }
  
  public static void a(BaseChatPie paramBaseChatPie, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    int j = 1;
    int i;
    if (paramBaseChatPie != null)
    {
      if (paramQQAppInterface != null) {
        break label27;
      }
      i = 1;
      if (paramSessionInfo != null) {
        break label33;
      }
      label18:
      if ((j | i) == 0) {
        break label39;
      }
    }
    label395:
    for (;;)
    {
      return;
      label27:
      i = 0;
      break;
      label33:
      j = 0;
      break label18;
      label39:
      if ((paramBaseChatPie instanceof xys)) {}
      for (paramBaseChatPie = (xys)paramBaseChatPie;; paramBaseChatPie = null)
      {
        if (paramBaseChatPie == null) {
          break label395;
        }
        aquu localaquu = aquu.a();
        i = paramSessionInfo.cZ;
        boolean bool1 = localaquu.cq(paramQQAppInterface);
        boolean bool2 = localaquu.cr(paramQQAppInterface);
        boolean bool3 = localaquu.ae(paramQQAppInterface, paramSessionInfo.aTl);
        if ((i != 0) || (!bool1) || (!bool2) || (!bool3)) {
          break;
        }
        Object localObject = paramQQAppInterface.getApp().getSharedPreferences(aquu.cxl, 0);
        if (!paramBoolean)
        {
          long l1 = localaquu.r(paramQQAppInterface);
          long l2 = ((SharedPreferences)localObject).getLong(aquu.cxm + paramSessionInfo.aTl, 0L);
          if ((l1 > 0L) && (System.currentTimeMillis() - l2 > l1)) {
            break label271;
          }
        }
        label271:
        acno localacno;
        do
        {
          localObject = localaquu.L(paramQQAppInterface);
          if ((!localaquu.cs(paramQQAppInterface)) || (TextUtils.isEmpty((CharSequence)localObject)) || (!paramBaseChatPie.bkM)) {
            break;
          }
          localaquu.U(paramQQAppInterface, 0);
          top.a(paramQQAppInterface, paramSessionInfo.aTl, paramSessionInfo.cZ, -4022);
          paramQQAppInterface.a().a(paramSessionInfo.aTl, paramQQAppInterface.getCurrentAccountUin(), paramSessionInfo.cZ, -4022, (String)localObject);
          return;
          localacno = (acno)paramQQAppInterface.getBusinessHandler(86);
        } while (localacno == null);
        paramBaseChatPie = new AIOSendReq();
        paramBaseChatPie.iSend = 0;
        paramBaseChatPie.sAid = "";
        paramBaseChatPie.sUin = paramQQAppInterface.getCurrentAccountUin();
        paramBaseChatPie.sFriendUin = paramSessionInfo.aTl;
        localacno.a(paramBaseChatPie);
        paramBaseChatPie = ((SharedPreferences)localObject).edit();
        paramBaseChatPie.putLong(aquu.cxm + paramSessionInfo.aTl, System.currentTimeMillis());
        if (Build.VERSION.SDK_INT <= 8)
        {
          paramBaseChatPie.commit();
          return;
        }
        paramBaseChatPie.apply();
        return;
      }
    }
  }
  
  public static void a(SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    String str = paramSessionInfo.aTl;
    boolean bool = paramSessionInfo.aTl.equals(paramQQAppInterface.getCurrentAccountUin());
    anot.a(paramQQAppInterface, "dc00898", "", "", "0X800A2CE", "0X800A2CE", 0, 0, ChatActivityUtils.cs(paramSessionInfo.cZ), "", "", "");
    Object localObject;
    int i;
    label171:
    Intent localIntent;
    if (bool)
    {
      localObject = new ProfileActivity.AllInOne(paramQQAppInterface.getCurrentAccountUin(), 0);
      i = 0;
      if (i == 0)
      {
        if (TextUtils.isEmpty(((ProfileActivity.AllInOne)localObject).nickname)) {
          ((ProfileActivity.AllInOne)localObject).nickname = paramSessionInfo.aTn;
        }
        ((ProfileActivity.AllInOne)localObject).ae = stj.a(paramSessionInfo);
        ((ProfileActivity.AllInOne)localObject).aOF = paramSessionInfo.aTl;
        ((ProfileActivity.AllInOne)localObject).bIX = paramSessionInfo.cZ;
        if ((paramSessionInfo.cZ == 1000) || (paramSessionInfo.cZ == 1020)) {
          ((ProfileActivity.AllInOne)localObject).troopUin = paramSessionInfo.troopUin;
        }
        ((ProfileActivity.AllInOne)localObject).bIZ = 2;
        if (paramSessionInfo.cZ != 0) {
          break label923;
        }
        ((ProfileActivity.AllInOne)localObject).bJa = 1;
        if ((paramSessionInfo.cZ != 1001) && (paramSessionInfo.cZ != 1010) && (paramSessionInfo.cZ != 10002)) {
          break label990;
        }
        localIntent = new Intent(paramActivity, NearbyPeopleProfileActivity.class);
        if (paramSessionInfo.cZ != 1001) {
          break label933;
        }
        ((ProfileActivity.AllInOne)localObject).bJa = 10;
        localIntent.putExtra("frome_where", 21);
        label242:
        ((ProfileActivity.AllInOne)localObject).ae = stj.a(paramSessionInfo);
        localIntent.putExtra("AllInOne", (Parcelable)localObject);
        if (!aqft.equalsWithNullCheck(paramQQAppInterface.getCurrentAccountUin(), str)) {
          break label977;
        }
        localIntent.putExtra("param_mode", 2);
      }
    }
    for (;;)
    {
      paramActivity.startActivityForResult(localIntent, 9009);
      return;
      if (paramSessionInfo.cZ == 1024)
      {
        jqs.a(paramActivity, null, paramSessionInfo.aTl, true, -1, true, 2000);
        i = 1;
        localObject = null;
        break;
      }
      if (paramSessionInfo.cZ == 1001)
      {
        localObject = new ProfileActivity.AllInOne(str, 42);
        i = 0;
        break;
      }
      if (paramSessionInfo.cZ == 10002)
      {
        localObject = new ProfileActivity.AllInOne(str, 86);
        i = 0;
        break;
      }
      if (paramSessionInfo.cZ == 10004)
      {
        localObject = new ProfileActivity.AllInOne(str, 94);
        i = 0;
        break;
      }
      if (paramSessionInfo.cZ == 0)
      {
        localObject = new ProfileActivity.AllInOne(str, 70);
        i = 0;
        break;
      }
      if (paramSessionInfo.cZ == 1000)
      {
        localObject = new ProfileActivity.AllInOne(str, 22);
        i = 0;
        break;
      }
      if (paramSessionInfo.cZ == 1020)
      {
        localObject = new ProfileActivity.AllInOne(str, 58);
        i = 0;
        break;
      }
      if (paramSessionInfo.cZ == 1001)
      {
        localObject = new ProfileActivity.AllInOne(str, 42);
        i = 0;
        break;
      }
      if (paramSessionInfo.cZ == 10002)
      {
        localObject = new ProfileActivity.AllInOne(str, 86);
        i = 0;
        break;
      }
      if (paramSessionInfo.cZ == 1004)
      {
        localObject = new ProfileActivity.AllInOne(str, 47);
        ((ProfileActivity.AllInOne)localObject).discussUin = paramSessionInfo.troopUin;
        i = 0;
        break;
      }
      if (paramSessionInfo.cZ == 1005)
      {
        localObject = new ProfileActivity.AllInOne(str, 2);
        i = 0;
        break;
      }
      if (paramSessionInfo.cZ == 1023)
      {
        localObject = new ProfileActivity.AllInOne(str, 74);
        i = 0;
        break;
      }
      if (paramSessionInfo.cZ == 1006)
      {
        localObject = new ProfileActivity.AllInOne(str, 34);
        i = 0;
        break;
      }
      if (paramSessionInfo.cZ == 1009)
      {
        localObject = new ProfileActivity.AllInOne(str, 57);
        i = 0;
        break;
      }
      if (paramSessionInfo.cZ == 1021)
      {
        localObject = new ProfileActivity.AllInOne(str, 72);
        i = 0;
        break;
      }
      if (paramSessionInfo.cZ == 1022)
      {
        localObject = new ProfileActivity.AllInOne(str, 27);
        i = 0;
        break;
      }
      if (paramSessionInfo.cZ == 1025)
      {
        localObject = new Intent(paramActivity, ChatSettingActivity.class);
        ((Intent)localObject).putExtra("uin", paramSessionInfo.aTl);
        ((Intent)localObject).putExtra("uinname", paramSessionInfo.aTn);
        ((Intent)localObject).putExtra("uintype", paramSessionInfo.cZ);
        paramActivity.startActivity((Intent)localObject);
        i = 1;
        localObject = null;
        break;
      }
      if ((paramSessionInfo.cZ == 1037) || (paramSessionInfo.cZ == 1044) || (paramSessionInfo.cZ == 1045))
      {
        localObject = new ProfileActivity.AllInOne(str, 96);
        i = 0;
        break;
      }
      if (paramSessionInfo.cZ == 10008)
      {
        localObject = new ProfileActivity.AllInOne(str, 115);
        i = 0;
        break;
      }
      localObject = new ProfileActivity.AllInOne(str, 19);
      i = 0;
      break;
      label923:
      ((ProfileActivity.AllInOne)localObject).bJa = 106;
      break label171;
      label933:
      if (paramSessionInfo.cZ == 1010)
      {
        ((ProfileActivity.AllInOne)localObject).bJa = 11;
        break label242;
      }
      if (paramSessionInfo.cZ != 10002) {
        break label242;
      }
      localIntent.putExtra("frome_where", 22);
      break label242;
      label977:
      localIntent.putExtra("param_mode", 3);
    }
    label990:
    if (aine.f(paramSessionInfo))
    {
      i = 0;
      if (paramSessionInfo.entrance == 20) {
        i = 1;
      }
      ProfileActivity.a(paramActivity, (ProfileActivity.AllInOne)localObject, i, 3);
      return;
    }
    ProfileActivity.b(paramActivity, (ProfileActivity.AllInOne)localObject);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString1, String paramString2, long paramLong1, boolean paramBoolean1, int paramInt2, int paramInt3, boolean paramBoolean2, int paramInt4, int paramInt5, boolean paramBoolean3, long paramLong2, Bundle paramBundle)
  {
    if ((!paramBoolean2) && (!a(paramQQAppInterface, paramString1, paramInt1, paramLong1)) && (!paramBoolean1) && (anqo.et(paramString2) >= 1))
    {
      anqo.a(paramString2, paramQQAppInterface, paramString1, paramLong1, paramInt2, paramInt3, paramLong2, paramBundle);
      return;
    }
    paramBundle = new aool();
    paramBundle.mSelfUin = paramQQAppInterface.getAccount();
    paramBundle.mPeerUin = paramString1;
    paramBundle.mUinType = paramInt1;
    paramBundle.mFileType = 2;
    paramBundle.mUniseq = paramLong1;
    paramBundle.cNy = true;
    paramBundle.dQ = paramString2;
    paramBundle.mBusiType = 1002;
    paramBundle.cNF = paramBoolean3;
    paramBundle.dQL = paramInt5;
    paramBundle.F = paramQQAppInterface.b().a(paramString1, paramInt1, paramLong1);
    if ((paramInt1 == 1026) && (QLog.isColorLevel()))
    {
      paramString2 = new StringBuilder().append("uploadPtt,");
      if (paramBundle.F != null) {
        break label246;
      }
    }
    label246:
    for (paramString1 = "mRec is null";; paramString1 = "mRec is not null")
    {
      QLog.i("PttShow", 2, paramString1);
      if ((paramBundle.F instanceof MessageForPtt))
      {
        paramString1 = (MessageForPtt)paramBundle.F;
        paramString1.voiceType = paramInt3;
        paramString1.voiceLength = QQRecorder.d(paramInt2);
        paramString1.voiceChangeFlag = paramInt4;
      }
      paramQQAppInterface.a().a(paramBundle);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString1, String paramString2, long paramLong1, boolean paramBoolean1, int paramInt2, int paramInt3, boolean paramBoolean2, int paramInt4, int paramInt5, boolean paramBoolean3, long paramLong2, Bundle paramBundle, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, String paramString3, boolean paramBoolean4, int paramInt6)
  {
    a(paramQQAppInterface, paramInt1, paramString1, paramString2, paramLong1, paramBoolean1, paramInt2, paramInt3, paramBoolean2, paramInt4, paramInt5, paramBoolean3, paramLong2, paramBundle, paramArrayList, paramString3, paramBoolean4, null, paramInt6);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString1, String paramString2, long paramLong1, boolean paramBoolean1, int paramInt2, int paramInt3, boolean paramBoolean2, int paramInt4, int paramInt5, boolean paramBoolean3, long paramLong2, Bundle paramBundle, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, String paramString3, boolean paramBoolean4, MessageRecord paramMessageRecord, int paramInt6)
  {
    if ((!paramBoolean2) && (!a(paramQQAppInterface, paramString1, paramInt1, paramLong1)) && (!paramBoolean1) && (anqo.et(paramString2) >= 1))
    {
      anqo.a(paramString2, paramQQAppInterface, paramString1, paramLong1, paramInt2, paramInt3, paramLong2, paramBundle);
      return;
    }
    paramBundle = new aool();
    paramBundle.mSelfUin = paramQQAppInterface.getAccount();
    paramBundle.mPeerUin = paramString1;
    paramBundle.mUinType = paramInt1;
    paramBundle.mFileType = 2;
    paramBundle.mUniseq = paramLong1;
    paramBundle.cNy = true;
    paramBundle.dQ = paramString2;
    paramBundle.mBusiType = 1002;
    paramBundle.cNF = paramBoolean3;
    paramBundle.dQL = paramInt5;
    if (paramMessageRecord != null)
    {
      paramBundle.F = paramMessageRecord;
      if ((paramArrayList != null) && (paramArrayList.size() > 0) && (paramBoolean4) && (paramBundle.F != null))
      {
        paramBundle.F.atInfoList = paramArrayList;
        paramBundle.F.mRobotFlag = 1;
        new anov(paramQQAppInterface).a("dc00899").b("Grp_robot").c("send_msg").d("voice_msg_suc").a(new String[] { paramString1, String.valueOf(((MessageForText.AtTroopMemberInfo)paramArrayList.get(0)).uin) }).report();
      }
      if ((paramInt1 == 1026) && (QLog.isColorLevel()))
      {
        paramString2 = new StringBuilder().append("uploadPtt,");
        if (paramBundle.F != null) {
          break label382;
        }
      }
    }
    label382:
    for (paramString1 = "mRec is null";; paramString1 = "mRec is not null")
    {
      QLog.i("PttShow", 2, paramString1);
      if ((paramBundle.F instanceof MessageForPtt))
      {
        paramString1 = (MessageForPtt)paramBundle.F;
        paramString1.voiceType = paramInt3;
        paramString1.voiceLength = QQRecorder.d(paramInt2);
        paramString1.voiceChangeFlag = paramInt4;
        paramString1.mInputContent = paramString3;
        paramString1.autoToText = paramInt6;
      }
      paramQQAppInterface.a().a(paramBundle);
      return;
      paramBundle.F = paramQQAppInterface.b().a(paramString1, paramInt1, paramLong1);
      break;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, int paramInt1, int paramInt2, String paramString)
  {
    paramContext = new MessageForPokeEmo();
    paramContext.msgtype = -5018;
    paramContext.isNeedPlayed = false;
    paramContext.pokeemoId = paramInt1;
    paramContext.pokeemoPressCount = paramInt2;
    paramContext.summary = yfx.cJ(paramInt1);
    paramContext.initMsg();
    anbi.a(paramQQAppInterface, paramContext, paramSessionInfo.aTl, paramSessionInfo.troopUin, paramSessionInfo.cZ);
    paramQQAppInterface.b().a(paramContext, null);
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityFacade", 2, String.format(" sendPokeEmoMsg.pokeemoID = %d,count = %d,summary = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString }));
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramInt1, paramInt2, paramString1, paramString2, 1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3)
  {
    if (!xks.g(paramQQAppInterface, paramSessionInfo))
    {
      if (toast == null)
      {
        toast = QQToast.a(paramContext, 2131690218, 0);
        xkr.a().send(3);
        xkr.a().send(6);
        xkr.a().send(12);
        xkr.a().send(15);
        xkr.a().send(18);
        xkr.a().send(9);
      }
      if (!toast.isShowing()) {
        toast.show();
      }
      return;
    }
    paramContext = new MessageForPoke();
    paramContext.msgtype = -5012;
    paramContext.isPlayed = false;
    paramContext.interactType = paramInt1;
    paramContext.subId = paramInt2;
    paramContext.name = paramString1;
    paramContext.minVersion = paramString2;
    paramContext.strength = xkr.a().a(paramQQAppInterface, paramSessionInfo.aTl, paramContext.interactType, paramInt3, -1);
    if ((paramInt3 == 3) || (paramInt3 == 4))
    {
      paramInt2 = paramContext.flag;
      if (paramInt3 != 3) {
        break label317;
      }
    }
    label317:
    for (paramInt1 = 8;; paramInt1 = 16)
    {
      paramContext.flag = (paramInt1 | paramInt2);
      paramContext.isPlayed = true;
      anbi.a(paramQQAppInterface, paramContext, paramSessionInfo.aTl, paramSessionInfo.troopUin, paramSessionInfo.cZ);
      paramContext.initMsg();
      if (QLog.isColorLevel()) {
        QLog.d("PokeMsg", 2, "sendPokeMsg strength:" + paramContext.strength + "." + paramContext);
      }
      paramQQAppInterface.b().a(paramContext, null);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("PokeMsg", 2, "sendPokeMsg type:" + paramContext.interactType + "." + paramContext);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, int paramInt, String paramString1, String paramString2)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramInt, -1, paramString1, paramString2, 1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, long paramLong)
  {
    paramContext = paramQQAppInterface.b().a(paramSessionInfo.aTl, paramSessionInfo.cZ, paramLong);
    if ((paramContext != null) && (paramContext.isSendFromLocal())) {
      paramQQAppInterface.a().oy(paramQQAppInterface.a().y(paramContext.frienduin, paramContext.uniseq));
    }
    paramQQAppInterface.b().t(paramSessionInfo.aTl, paramSessionInfo.cZ, paramLong);
    paramContext = anbi.e(paramContext);
    paramQQAppInterface.b().a(paramContext, null, true);
  }
  
  /* Error */
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, abzy paramabzy)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: iconst_0
    //   4: istore 5
    //   6: aload_0
    //   7: ifnull +50 -> 57
    //   10: aload_3
    //   11: ifnull +46 -> 57
    //   14: aload_3
    //   15: getfield 2178	abzy:c	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   18: ifnull +39 -> 57
    //   21: aload_3
    //   22: getfield 2178	abzy:c	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   25: getfield 2183	com/tencent/mobileqq/data/ApolloActionData:actionName	Ljava/lang/String;
    //   28: invokestatic 370	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   31: ifne +26 -> 57
    //   34: aload_3
    //   35: getfield 2178	abzy:c	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   38: getfield 2186	com/tencent/mobileqq/data/ApolloActionData:personNum	I
    //   41: ifle +17 -> 58
    //   44: aload_3
    //   45: getfield 2178	abzy:c	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   48: getfield 2189	com/tencent/mobileqq/data/ApolloActionData:peerUin	Ljava/lang/String;
    //   51: invokestatic 370	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   54: ifeq +4 -> 58
    //   57: return
    //   58: aload_0
    //   59: bipush 51
    //   61: invokevirtual 449	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   64: checkcast 485	acff
    //   67: astore 8
    //   69: aload_0
    //   70: sipush 153
    //   73: invokevirtual 449	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   76: checkcast 2191	abhh
    //   79: astore 11
    //   81: aload_0
    //   82: bipush 71
    //   84: invokevirtual 644	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   87: checkcast 2193	aqrb
    //   90: astore_1
    //   91: aload_2
    //   92: getfield 68	com/tencent/mobileqq/activity/aio/SessionInfo:cZ	I
    //   95: iconst_1
    //   96: if_icmpne +60 -> 156
    //   99: aload_3
    //   100: getfield 2178	abzy:c	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   103: getfield 2186	com/tencent/mobileqq/data/ApolloActionData:personNum	I
    //   106: ifle +50 -> 156
    //   109: aload_3
    //   110: getfield 2178	abzy:c	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   113: getfield 2189	com/tencent/mobileqq/data/ApolloActionData:peerUin	Ljava/lang/String;
    //   116: aload_0
    //   117: invokevirtual 119	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   120: invokevirtual 1412	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   123: ifne +33 -> 156
    //   126: aload 11
    //   128: aload_3
    //   129: getfield 2178	abzy:c	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   132: getfield 2189	com/tencent/mobileqq/data/ApolloActionData:peerUin	Ljava/lang/String;
    //   135: invokevirtual 2196	abhh:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/ApolloBaseInfo;
    //   138: astore 9
    //   140: aload 9
    //   142: ifnonnull +778 -> 920
    //   145: aload_1
    //   146: aload_3
    //   147: getfield 2178	abzy:c	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   150: getfield 2189	com/tencent/mobileqq/data/ApolloActionData:peerUin	Ljava/lang/String;
    //   153: invokevirtual 2199	aqrb:Vx	(Ljava/lang/String;)V
    //   156: aload_3
    //   157: getfield 2178	abzy:c	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   160: getfield 2202	com/tencent/mobileqq/data/ApolloActionData:actionId	I
    //   163: invokestatic 2205	com/tencent/mobileqq/data/ApolloActionData:isAction3DModel	(I)Z
    //   166: istore 7
    //   168: ldc_w 599
    //   171: iconst_1
    //   172: iconst_4
    //   173: anewarray 4	java/lang/Object
    //   176: dup
    //   177: iconst_0
    //   178: ldc_w 2207
    //   181: aastore
    //   182: dup
    //   183: iconst_1
    //   184: aload_3
    //   185: getfield 2178	abzy:c	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   188: getfield 2202	com/tencent/mobileqq/data/ApolloActionData:actionId	I
    //   191: invokestatic 1034	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   194: aastore
    //   195: dup
    //   196: iconst_2
    //   197: ldc_w 2209
    //   200: aastore
    //   201: dup
    //   202: iconst_3
    //   203: iload 7
    //   205: invokestatic 2214	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   208: aastore
    //   209: invokestatic 2217	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   212: new 1562	com/tencent/mobileqq/data/ApolloMessage
    //   215: dup
    //   216: invokespecial 2218	com/tencent/mobileqq/data/ApolloMessage:<init>	()V
    //   219: astore 10
    //   221: iload 7
    //   223: ifeq +900 -> 1123
    //   226: sipush 1024
    //   229: istore 5
    //   231: iload 5
    //   233: istore 4
    //   235: aload_3
    //   236: getfield 2178	abzy:c	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   239: getfield 2186	com/tencent/mobileqq/data/ApolloActionData:personNum	I
    //   242: ifle +817 -> 1059
    //   245: iload 5
    //   247: istore 4
    //   249: aload 10
    //   251: sipush 1454
    //   254: putfield 1565	com/tencent/mobileqq/data/ApolloMessage:id	I
    //   257: iload 5
    //   259: istore 4
    //   261: new 2220	com/tencent/mobileqq/data/Apollo3DMessage
    //   264: dup
    //   265: invokespecial 2221	com/tencent/mobileqq/data/Apollo3DMessage:<init>	()V
    //   268: astore 8
    //   270: aload 8
    //   272: aload_3
    //   273: getfield 2178	abzy:c	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   276: getfield 2202	com/tencent/mobileqq/data/ApolloActionData:actionId	I
    //   279: putfield 2224	com/tencent/mobileqq/data/Apollo3DMessage:actionID_3D	I
    //   282: aload 8
    //   284: aload_3
    //   285: getfield 2178	abzy:c	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   288: getfield 2227	com/tencent/mobileqq/data/ApolloActionData:actionType	I
    //   291: putfield 2230	com/tencent/mobileqq/data/Apollo3DMessage:actionType_3D	I
    //   294: aload 8
    //   296: aload_3
    //   297: getfield 2178	abzy:c	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   300: getfield 2183	com/tencent/mobileqq/data/ApolloActionData:actionName	Ljava/lang/String;
    //   303: putfield 2233	com/tencent/mobileqq/data/Apollo3DMessage:actionName_3D	Ljava/lang/String;
    //   306: aload_0
    //   307: sipush 155
    //   310: invokevirtual 449	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   313: checkcast 2235	abxk
    //   316: aload 10
    //   318: getfield 1565	com/tencent/mobileqq/data/ApolloMessage:id	I
    //   321: invokevirtual 2238	abxk:a	(I)Lcom/tencent/mobileqq/data/ApolloActionData;
    //   324: astore_1
    //   325: aload_1
    //   326: ifnull +774 -> 1100
    //   329: aload_1
    //   330: getfield 2183	com/tencent/mobileqq/data/ApolloActionData:actionName	Ljava/lang/String;
    //   333: invokestatic 370	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   336: ifne +764 -> 1100
    //   339: aload 10
    //   341: aload_1
    //   342: getfield 2183	com/tencent/mobileqq/data/ApolloActionData:actionName	Ljava/lang/String;
    //   345: ldc_w 1404
    //   348: invokevirtual 82	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   351: putfield 2241	com/tencent/mobileqq/data/ApolloMessage:name	[B
    //   354: aload_3
    //   355: getfield 2178	abzy:c	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   358: getfield 2244	com/tencent/mobileqq/data/ApolloActionData:atNickName	Ljava/lang/String;
    //   361: invokestatic 370	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   364: ifne +36 -> 400
    //   367: aload_2
    //   368: getfield 68	com/tencent/mobileqq/activity/aio/SessionInfo:cZ	I
    //   371: iconst_1
    //   372: if_icmpeq +13 -> 385
    //   375: aload_2
    //   376: getfield 68	com/tencent/mobileqq/activity/aio/SessionInfo:cZ	I
    //   379: sipush 3000
    //   382: if_icmpne +18 -> 400
    //   385: aload 10
    //   387: aload_3
    //   388: getfield 2178	abzy:c	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   391: getfield 2244	com/tencent/mobileqq/data/ApolloActionData:atNickName	Ljava/lang/String;
    //   394: invokevirtual 2246	java/lang/String:getBytes	()[B
    //   397: putfield 2249	com/tencent/mobileqq/data/ApolloMessage:text	[B
    //   400: aload 11
    //   402: aload_0
    //   403: invokevirtual 119	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   406: invokevirtual 2196	abhh:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/ApolloBaseInfo;
    //   409: astore 9
    //   411: aload 10
    //   413: aload 9
    //   415: getfield 2254	com/tencent/mobileqq/data/ApolloBaseInfo:apolloServerTS	J
    //   418: invokestatic 2257	aqft:ag	(J)I
    //   421: i2l
    //   422: putfield 2260	com/tencent/mobileqq/data/ApolloMessage:sender_ts	J
    //   425: aload 10
    //   427: aload 9
    //   429: getfield 2263	com/tencent/mobileqq/data/ApolloBaseInfo:apolloStatus	I
    //   432: putfield 2266	com/tencent/mobileqq/data/ApolloMessage:sender_status	I
    //   435: iload 7
    //   437: ifeq +18 -> 455
    //   440: aload 8
    //   442: ifnull +13 -> 455
    //   445: aload 8
    //   447: aload 9
    //   449: getfield 2269	com/tencent/mobileqq/data/ApolloBaseInfo:cmshow3dFlag	I
    //   452: putfield 2272	com/tencent/mobileqq/data/Apollo3DMessage:senderStatus_3D	I
    //   455: iload 5
    //   457: iconst_1
    //   458: ior
    //   459: bipush 8
    //   461: ior
    //   462: bipush 32
    //   464: ior
    //   465: istore 4
    //   467: aload_3
    //   468: getfield 2178	abzy:c	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   471: getfield 2186	com/tencent/mobileqq/data/ApolloActionData:personNum	I
    //   474: ifle +816 -> 1290
    //   477: aload 10
    //   479: aload_3
    //   480: getfield 2178	abzy:c	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   483: getfield 2189	com/tencent/mobileqq/data/ApolloActionData:peerUin	Ljava/lang/String;
    //   486: invokestatic 2275	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   489: invokevirtual 2278	java/lang/Long:longValue	()J
    //   492: putfield 2281	com/tencent/mobileqq/data/ApolloMessage:peer_uin	J
    //   495: aload 11
    //   497: aload_3
    //   498: getfield 2178	abzy:c	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   501: getfield 2189	com/tencent/mobileqq/data/ApolloActionData:peerUin	Ljava/lang/String;
    //   504: invokevirtual 2196	abhh:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/ApolloBaseInfo;
    //   507: astore 9
    //   509: aload 10
    //   511: aload 9
    //   513: getfield 2254	com/tencent/mobileqq/data/ApolloBaseInfo:apolloServerTS	J
    //   516: invokestatic 2257	aqft:ag	(J)I
    //   519: i2l
    //   520: putfield 2284	com/tencent/mobileqq/data/ApolloMessage:peer_ts	J
    //   523: aload 10
    //   525: aload 9
    //   527: getfield 2263	com/tencent/mobileqq/data/ApolloBaseInfo:apolloStatus	I
    //   530: putfield 2287	com/tencent/mobileqq/data/ApolloMessage:peer_status	I
    //   533: iload 7
    //   535: ifeq +18 -> 553
    //   538: aload 8
    //   540: ifnull +13 -> 553
    //   543: aload 8
    //   545: aload 9
    //   547: getfield 2269	com/tencent/mobileqq/data/ApolloBaseInfo:cmshow3dFlag	I
    //   550: putfield 2290	com/tencent/mobileqq/data/Apollo3DMessage:peerStatus_3D	I
    //   553: iload 4
    //   555: iconst_4
    //   556: ior
    //   557: iconst_2
    //   558: ior
    //   559: bipush 16
    //   561: ior
    //   562: bipush 64
    //   564: ior
    //   565: istore 5
    //   567: iload 5
    //   569: istore 4
    //   571: iload 7
    //   573: ifeq +11 -> 584
    //   576: iload 5
    //   578: sipush 2048
    //   581: ior
    //   582: istore 4
    //   584: aload_3
    //   585: getfield 2178	abzy:c	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   588: getfield 2186	com/tencent/mobileqq/data/ApolloActionData:personNum	I
    //   591: ifne +28 -> 619
    //   594: aload_2
    //   595: getfield 68	com/tencent/mobileqq/activity/aio/SessionInfo:cZ	I
    //   598: ifne +21 -> 619
    //   601: aload 10
    //   603: aload_3
    //   604: getfield 2178	abzy:c	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   607: getfield 2189	com/tencent/mobileqq/data/ApolloActionData:peerUin	Ljava/lang/String;
    //   610: invokestatic 2275	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   613: invokevirtual 2278	java/lang/Long:longValue	()J
    //   616: putfield 2281	com/tencent/mobileqq/data/ApolloMessage:peer_uin	J
    //   619: iload 4
    //   621: istore 5
    //   623: aload_3
    //   624: getfield 2293	abzy:cue	I
    //   627: iconst_1
    //   628: if_icmpne +11 -> 639
    //   631: iload 4
    //   633: sipush 128
    //   636: ior
    //   637: istore 5
    //   639: aload 10
    //   641: iload 5
    //   643: putfield 2294	com/tencent/mobileqq/data/ApolloMessage:flag	I
    //   646: new 683	java/util/ArrayList
    //   649: dup
    //   650: invokespecial 684	java/util/ArrayList:<init>	()V
    //   653: pop
    //   654: iconst_0
    //   655: ifne +629 -> 1284
    //   658: new 1270	org/json/JSONObject
    //   661: dup
    //   662: invokespecial 1271	org/json/JSONObject:<init>	()V
    //   665: astore 9
    //   667: iload 7
    //   669: ifeq +500 -> 1169
    //   672: aload 8
    //   674: ifnull +495 -> 1169
    //   677: aload_1
    //   678: ifnull +491 -> 1169
    //   681: aload 9
    //   683: ldc_w 2295
    //   686: aload_1
    //   687: getfield 2227	com/tencent/mobileqq/data/ApolloActionData:actionType	I
    //   690: invokevirtual 1323	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   693: pop
    //   694: aload_3
    //   695: getfield 2298	abzy:cre	I
    //   698: ifle +30 -> 728
    //   701: aload 9
    //   703: ldc_w 2300
    //   706: aload_3
    //   707: getfield 2298	abzy:cre	I
    //   710: invokevirtual 1323	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   713: pop
    //   714: aload 9
    //   716: ldc_w 2302
    //   719: aload_3
    //   720: getfield 2305	abzy:sC	F
    //   723: f2d
    //   724: invokevirtual 2308	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   727: pop
    //   728: aload_3
    //   729: getfield 2178	abzy:c	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   732: getfield 2311	com/tencent/mobileqq/data/ApolloActionData:inputText	Ljava/lang/String;
    //   735: invokestatic 370	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   738: ifne +463 -> 1201
    //   741: aload 9
    //   743: ldc_w 2312
    //   746: aload_3
    //   747: getfield 2178	abzy:c	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   750: getfield 2311	com/tencent/mobileqq/data/ApolloActionData:inputText	Ljava/lang/String;
    //   753: invokevirtual 1285	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   756: pop
    //   757: aload 8
    //   759: ifnull +23 -> 782
    //   762: aload 8
    //   764: invokevirtual 2316	com/tencent/mobileqq/data/Apollo3DMessage:getMessageJSONObject	()Lorg/json/JSONObject;
    //   767: astore_1
    //   768: aload_1
    //   769: ifnull +13 -> 782
    //   772: aload 9
    //   774: ldc_w 2318
    //   777: aload_1
    //   778: invokevirtual 1285	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   781: pop
    //   782: aload 9
    //   784: ifnull +13 -> 797
    //   787: aload 10
    //   789: aload 9
    //   791: invokevirtual 1351	org/json/JSONObject:toString	()Ljava/lang/String;
    //   794: putfield 2321	com/tencent/mobileqq/data/ApolloMessage:extStr	Ljava/lang/String;
    //   797: aload_0
    //   798: aload_2
    //   799: getfield 128	com/tencent/mobileqq/activity/aio/SessionInfo:aTl	Ljava/lang/String;
    //   802: aload_2
    //   803: getfield 241	com/tencent/mobileqq/activity/aio/SessionInfo:troopUin	Ljava/lang/String;
    //   806: aload_2
    //   807: getfield 68	com/tencent/mobileqq/activity/aio/SessionInfo:cZ	I
    //   810: aload 10
    //   812: invokestatic 2324	anbi:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/data/ApolloMessage;)Lcom/tencent/mobileqq/data/MessageForApollo;
    //   815: astore_1
    //   816: aload_1
    //   817: aload_3
    //   818: getfield 2178	abzy:c	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   821: getfield 2311	com/tencent/mobileqq/data/ApolloActionData:inputText	Ljava/lang/String;
    //   824: putfield 2325	com/tencent/mobileqq/data/MessageForApollo:inputText	Ljava/lang/String;
    //   827: aload_1
    //   828: aload_3
    //   829: getfield 2298	abzy:cre	I
    //   832: putfield 2328	com/tencent/mobileqq/data/MessageForApollo:audioId	I
    //   835: aload_1
    //   836: aload_3
    //   837: getfield 2305	abzy:sC	F
    //   840: putfield 2330	com/tencent/mobileqq/data/MessageForApollo:audioStartTime	F
    //   843: aload_1
    //   844: aload_3
    //   845: getfield 2333	abzy:cuf	I
    //   848: putfield 2336	com/tencent/mobileqq/data/MessageForApollo:isPlayDefaultAudio	I
    //   851: aload_1
    //   852: aload_3
    //   853: getfield 2178	abzy:c	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   856: getfield 2227	com/tencent/mobileqq/data/ApolloActionData:actionType	I
    //   859: putfield 2337	com/tencent/mobileqq/data/MessageForApollo:actionType	I
    //   862: aload_1
    //   863: aload 8
    //   865: putfield 2340	com/tencent/mobileqq/data/MessageForApollo:mApollo3DMessage	Lcom/tencent/mobileqq/data/Apollo3DMessage;
    //   868: aload_1
    //   869: getfield 2325	com/tencent/mobileqq/data/MessageForApollo:inputText	Ljava/lang/String;
    //   872: invokestatic 370	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   875: ifeq +11 -> 886
    //   878: aload_1
    //   879: aload_3
    //   880: getfield 2343	abzy:bkj	Ljava/lang/String;
    //   883: putfield 2325	com/tencent/mobileqq/data/MessageForApollo:inputText	Ljava/lang/String;
    //   886: aload_0
    //   887: invokestatic 2348	abrj:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Labrg;
    //   890: astore_2
    //   891: aload_3
    //   892: getfield 2178	abzy:c	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   895: getfield 2227	com/tencent/mobileqq/data/ApolloActionData:actionType	I
    //   898: ifeq +329 -> 1227
    //   901: aload_2
    //   902: ifnull +325 -> 1227
    //   905: aload_2
    //   906: invokevirtual 2353	abrg:a	()Labqz;
    //   909: astore_0
    //   910: aload_0
    //   911: ifnull -854 -> 57
    //   914: aload_0
    //   915: aload_1
    //   916: invokevirtual 2358	abqz:f	(Lcom/tencent/mobileqq/data/MessageForApollo;)V
    //   919: return
    //   920: aload 8
    //   922: aload_3
    //   923: getfield 2178	abzy:c	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   926: getfield 2189	com/tencent/mobileqq/data/ApolloActionData:peerUin	Ljava/lang/String;
    //   929: invokevirtual 2361	acff:isFriend	(Ljava/lang/String;)Z
    //   932: ifne +33 -> 965
    //   935: invokestatic 2366	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   938: aload 9
    //   940: getfield 2369	com/tencent/mobileqq/data/ApolloBaseInfo:apolloUpdateTime	J
    //   943: lsub
    //   944: ldc2_w 2370
    //   947: lcmp
    //   948: iflt +17 -> 965
    //   951: aload_1
    //   952: aload_3
    //   953: getfield 2178	abzy:c	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   956: getfield 2189	com/tencent/mobileqq/data/ApolloActionData:peerUin	Ljava/lang/String;
    //   959: invokevirtual 2199	aqrb:Vx	(Ljava/lang/String;)V
    //   962: goto -806 -> 156
    //   965: aload 8
    //   967: aload_3
    //   968: getfield 2178	abzy:c	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   971: getfield 2189	com/tencent/mobileqq/data/ApolloActionData:peerUin	Ljava/lang/String;
    //   974: invokevirtual 2361	acff:isFriend	(Ljava/lang/String;)Z
    //   977: ifeq +27 -> 1004
    //   980: aload 9
    //   982: getfield 2369	com/tencent/mobileqq/data/ApolloBaseInfo:apolloUpdateTime	J
    //   985: lconst_0
    //   986: lcmp
    //   987: ifne +17 -> 1004
    //   990: aload_1
    //   991: aload_3
    //   992: getfield 2178	abzy:c	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   995: getfield 2189	com/tencent/mobileqq/data/ApolloActionData:peerUin	Ljava/lang/String;
    //   998: invokevirtual 2199	aqrb:Vx	(Ljava/lang/String;)V
    //   1001: goto -845 -> 156
    //   1004: aload 9
    //   1006: getfield 2254	com/tencent/mobileqq/data/ApolloBaseInfo:apolloServerTS	J
    //   1009: aload 9
    //   1011: getfield 2374	com/tencent/mobileqq/data/ApolloBaseInfo:apolloLocalTS	J
    //   1014: lcmp
    //   1015: ifeq -859 -> 156
    //   1018: new 683	java/util/ArrayList
    //   1021: dup
    //   1022: iconst_1
    //   1023: invokespecial 2375	java/util/ArrayList:<init>	(I)V
    //   1026: astore 8
    //   1028: aload 8
    //   1030: aload_3
    //   1031: getfield 2178	abzy:c	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   1034: getfield 2189	com/tencent/mobileqq/data/ApolloActionData:peerUin	Ljava/lang/String;
    //   1037: invokestatic 1636	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   1040: invokestatic 2378	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1043: invokevirtual 1245	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1046: pop
    //   1047: aload_1
    //   1048: aload 8
    //   1050: ldc_w 2380
    //   1053: invokevirtual 2383	aqrb:m	(Ljava/util/ArrayList;Ljava/lang/String;)V
    //   1056: goto -900 -> 156
    //   1059: iload 5
    //   1061: istore 4
    //   1063: aload 10
    //   1065: sipush 1450
    //   1068: putfield 1565	com/tencent/mobileqq/data/ApolloMessage:id	I
    //   1071: goto -814 -> 257
    //   1074: astore 9
    //   1076: aconst_null
    //   1077: astore 8
    //   1079: aconst_null
    //   1080: astore_1
    //   1081: ldc_w 599
    //   1084: iconst_1
    //   1085: ldc_w 2385
    //   1088: aload 9
    //   1090: invokestatic 605	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1093: iload 4
    //   1095: istore 5
    //   1097: goto -743 -> 354
    //   1100: aload 10
    //   1102: ldc_w 2387
    //   1105: invokevirtual 2246	java/lang/String:getBytes	()[B
    //   1108: putfield 2241	com/tencent/mobileqq/data/ApolloMessage:name	[B
    //   1111: goto -757 -> 354
    //   1114: astore 9
    //   1116: iload 5
    //   1118: istore 4
    //   1120: goto -39 -> 1081
    //   1123: iload 6
    //   1125: istore 4
    //   1127: aload 10
    //   1129: aload_3
    //   1130: getfield 2178	abzy:c	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   1133: getfield 2202	com/tencent/mobileqq/data/ApolloActionData:actionId	I
    //   1136: putfield 1565	com/tencent/mobileqq/data/ApolloMessage:id	I
    //   1139: iload 6
    //   1141: istore 4
    //   1143: aload 10
    //   1145: aload_3
    //   1146: getfield 2178	abzy:c	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   1149: getfield 2183	com/tencent/mobileqq/data/ApolloActionData:actionName	Ljava/lang/String;
    //   1152: ldc_w 1404
    //   1155: invokevirtual 82	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   1158: putfield 2241	com/tencent/mobileqq/data/ApolloMessage:name	[B
    //   1161: aconst_null
    //   1162: astore_1
    //   1163: aconst_null
    //   1164: astore 8
    //   1166: goto -812 -> 354
    //   1169: aload 9
    //   1171: ldc_w 2295
    //   1174: aload_3
    //   1175: getfield 2178	abzy:c	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   1178: getfield 2227	com/tencent/mobileqq/data/ApolloActionData:actionType	I
    //   1181: invokevirtual 1323	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1184: pop
    //   1185: goto -491 -> 694
    //   1188: astore_0
    //   1189: ldc_w 599
    //   1192: iconst_1
    //   1193: ldc_w 2389
    //   1196: aload_0
    //   1197: invokestatic 605	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1200: return
    //   1201: aload_3
    //   1202: getfield 2343	abzy:bkj	Ljava/lang/String;
    //   1205: invokestatic 370	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1208: ifne -451 -> 757
    //   1211: aload 9
    //   1213: ldc_w 2312
    //   1216: aload_3
    //   1217: getfield 2343	abzy:bkj	Ljava/lang/String;
    //   1220: invokevirtual 1285	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1223: pop
    //   1224: goto -467 -> 757
    //   1227: aload_0
    //   1228: invokevirtual 154	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   1231: aload_1
    //   1232: aconst_null
    //   1233: invokevirtual 608	com/tencent/imcore/message/QQMessageFacade:a	(Lcom/tencent/mobileqq/data/MessageRecord;Lachq;)V
    //   1236: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1239: ifeq -1182 -> 57
    //   1242: ldc_w 599
    //   1245: iconst_2
    //   1246: new 180	java/lang/StringBuilder
    //   1249: dup
    //   1250: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   1253: ldc_w 2391
    //   1256: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1259: aload_3
    //   1260: invokevirtual 2392	abzy:toString	()Ljava/lang/String;
    //   1263: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1266: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1269: invokestatic 210	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1272: return
    //   1273: astore 9
    //   1275: aconst_null
    //   1276: astore_1
    //   1277: iload 5
    //   1279: istore 4
    //   1281: goto -200 -> 1081
    //   1284: aconst_null
    //   1285: astore 9
    //   1287: goto -620 -> 667
    //   1290: goto -706 -> 584
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1293	0	paramQQAppInterface	QQAppInterface
    //   0	1293	1	paramContext	Context
    //   0	1293	2	paramSessionInfo	SessionInfo
    //   0	1293	3	paramabzy	abzy
    //   233	1047	4	i	int
    //   4	1274	5	j	int
    //   1	1139	6	k	int
    //   166	502	7	bool	boolean
    //   67	1098	8	localObject1	Object
    //   138	872	9	localObject2	Object
    //   1074	15	9	localException1	Exception
    //   1114	98	9	localException2	Exception
    //   1273	1	9	localException3	Exception
    //   1285	1	9	localObject3	Object
    //   219	925	10	localApolloMessage	ApolloMessage
    //   79	417	11	localabhh	abhh
    // Exception table:
    //   from	to	target	type
    //   235	245	1074	java/lang/Exception
    //   249	257	1074	java/lang/Exception
    //   261	270	1074	java/lang/Exception
    //   1063	1071	1074	java/lang/Exception
    //   1127	1139	1074	java/lang/Exception
    //   1143	1161	1074	java/lang/Exception
    //   329	354	1114	java/lang/Exception
    //   1100	1111	1114	java/lang/Exception
    //   658	667	1188	java/lang/Throwable
    //   681	694	1188	java/lang/Throwable
    //   694	728	1188	java/lang/Throwable
    //   728	757	1188	java/lang/Throwable
    //   762	768	1188	java/lang/Throwable
    //   772	782	1188	java/lang/Throwable
    //   1169	1185	1188	java/lang/Throwable
    //   1201	1224	1188	java/lang/Throwable
    //   270	325	1273	java/lang/Exception
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Intent paramIntent, String paramString, ForwardFileInfo paramForwardFileInfo, int paramInt)
  {
    boolean bool1 = paramIntent.getBooleanExtra("not_forward", false);
    boolean bool2 = paramIntent.getBooleanExtra("support_multi_forward", false);
    if ((!bool1) && (!bool2)) {
      return;
    }
    if (paramForwardFileInfo.forwardID <= 0) {}
    for (;;)
    {
      paramQQAppInterface.a().a(paramForwardFileInfo.fR(), paramForwardFileInfo.vj(), paramForwardFileInfo.getFriendUin(), Long.parseLong(paramSessionInfo.aTl), paramSessionInfo.cZ, paramForwardFileInfo.Et(), paramForwardFileInfo.fS(), paramInt);
      if (!paramIntent.getBooleanExtra("not_forward", false)) {
        break;
      }
      paramIntent.removeExtra("not_forward");
      paramIntent.getExtras().remove("not_forward");
      return;
      paramInt = paramForwardFileInfo.forwardID;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Intent paramIntent, String paramString, ForwardFileInfo paramForwardFileInfo, boolean paramBoolean)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramIntent, paramString, paramForwardFileInfo, paramBoolean, 0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Intent paramIntent, String paramString, ForwardFileInfo paramForwardFileInfo, boolean paramBoolean, int paramInt)
  {
    if ((paramInt <= 0) && (paramForwardFileInfo != null)) {}
    for (int i = paramForwardFileInfo.forwardID;; i = paramInt)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("ChatActivityFacade", 1, "forwardForFile");
      }
      if (ForwardUtils.a(paramIntent, paramSessionInfo, paramString, paramQQAppInterface)) {
        if (QLog.isColorLevel()) {
          QLog.d("ChatActivityFacade", 2, "handleForwardEditedPhoto = " + paramString);
        }
      }
      label1411:
      for (;;)
      {
        return;
        if ((paramForwardFileInfo != null) && (paramForwardFileInfo.getType() == 10006) && (TextUtils.isEmpty(paramForwardFileInfo.getLocalPath())))
        {
          a(paramQQAppInterface, paramContext, paramSessionInfo, paramIntent, paramString, paramForwardFileInfo, paramInt);
          return;
        }
        if ((!paramIntent.getBooleanExtra("isFromFavorites", false)) && (paramIntent.getBooleanExtra("isFromShare", false)))
        {
          if (!paramIntent.getBooleanExtra("sendMultiple", false))
          {
            if (paramSessionInfo.cZ == 1)
            {
              paramQQAppInterface.a().a(paramString, paramSessionInfo.aTl, 0L, i);
              return;
            }
            paramQQAppInterface.a().a(paramString, paramSessionInfo.troopUin, paramSessionInfo.aTl, paramSessionInfo.cZ, true, 0L, i);
          }
        }
        else if (paramIntent.getBooleanExtra("not_forward", false))
        {
          paramString = null;
          if (paramForwardFileInfo != null) {
            paramString = paramQQAppInterface.a().c(paramForwardFileInfo.fR());
          }
          String str = paramString;
          if (paramString == null)
          {
            paramString = avja.a(paramIntent.getExtras(), paramSessionInfo.aTl, paramSessionInfo.cZ);
            str = paramString;
            if (paramString != null)
            {
              paramForwardFileInfo.p(paramString.nSessionId);
              str = paramString;
            }
          }
          if ((str == null) && (QLog.isColorLevel())) {
            QLog.e("ChatActivityFacade", 2, "there has a Bug!,sissionId[" + paramForwardFileInfo.fR() + "]");
          }
          switch (paramForwardFileInfo.getType())
          {
          }
          for (;;)
          {
            if ((paramBoolean) || (!paramIntent.getBooleanExtra("not_forward", false))) {
              break label1411;
            }
            paramIntent.removeExtra("not_forward");
            paramIntent.getExtras().remove("not_forward");
            return;
            if (paramSessionInfo.cZ == 1)
            {
              paramQQAppInterface.a().a(paramForwardFileInfo.getLocalPath(), paramSessionInfo.aTl, paramForwardFileInfo.fS(), i);
            }
            else
            {
              paramQQAppInterface = paramQQAppInterface.a().a(paramForwardFileInfo.getLocalPath(), paramSessionInfo.troopUin, paramSessionInfo.aTl, paramSessionInfo.cZ, true, paramForwardFileInfo.fS(), i);
              if (str != null)
              {
                paramQQAppInterface.lastSuccessTime = str.lastSuccessTime;
                continue;
                if (paramSessionInfo.cZ == 1)
                {
                  paramQQAppInterface.a().al(paramForwardFileInfo.fR(), paramSessionInfo.aTl);
                }
                else if (paramSessionInfo.cZ == 0)
                {
                  paramQQAppInterface.a().am(paramForwardFileInfo.fR(), paramSessionInfo.aTl);
                }
                else if (paramSessionInfo.cZ == 3000)
                {
                  paramQQAppInterface.a().an(paramForwardFileInfo.fR(), paramSessionInfo.aTl);
                  continue;
                  if (paramSessionInfo.cZ == 1)
                  {
                    if (ahbj.fileExistsAndNotEmpty(paramForwardFileInfo.getLocalPath()))
                    {
                      paramQQAppInterface.a().aV(paramForwardFileInfo.getLocalPath(), paramSessionInfo.aTl);
                    }
                    else
                    {
                      paramForwardFileInfo.fR();
                      paramContext = paramQQAppInterface.a().b(paramForwardFileInfo.fR());
                      if ((paramContext != null) && (paramContext.peerType == 3000))
                      {
                        paramSessionInfo = paramQQAppInterface.a().a(paramContext, paramSessionInfo.troopUin, paramSessionInfo.aTl, paramContext.peerType, false);
                        paramSessionInfo.selfUin = paramContext.peerUin;
                        paramQQAppInterface.a().a(paramSessionInfo, 27, paramForwardFileInfo.fS(), i);
                      }
                      else
                      {
                        paramQQAppInterface.a().a(3, paramForwardFileInfo.fR(), paramSessionInfo.aTl, paramForwardFileInfo.fS(), i);
                      }
                    }
                  }
                  else
                  {
                    paramString = paramQQAppInterface.a().b(paramForwardFileInfo.fR());
                    if ((paramString != null) && (paramString.status == 16))
                    {
                      if (paramContext == null) {
                        break;
                      }
                      ahav.JI(paramContext.getResources().getString(2131694128));
                      return;
                    }
                    paramContext = paramQQAppInterface.getCurrentAccountUin();
                    if ((paramSessionInfo.cZ == 1004) || (paramSessionInfo.cZ == 1000)) {
                      paramContext = paramSessionInfo.troopUin;
                    }
                    if ((paramString != null) && (paramString.peerType == 3000))
                    {
                      paramContext = paramQQAppInterface.a().a(paramString, paramContext, paramSessionInfo.aTl, paramSessionInfo.cZ, true, paramForwardFileInfo.fS(), i);
                      paramContext.selfUin = paramString.peerUin;
                      if ((paramSessionInfo.cZ == 0) || (paramSessionInfo.cZ == 1006) || (paramSessionInfo.cZ == 1004) || (paramSessionInfo.cZ == 1000) || (paramSessionInfo.cZ == 1001) || (paramSessionInfo.cZ == 10002) || (paramSessionInfo.cZ == 1006))
                      {
                        paramContext.nOpType = 21;
                        paramQQAppInterface.a().a(paramContext, 21);
                      }
                      for (;;)
                      {
                        paramQQAppInterface.a().u(paramContext);
                        break;
                        if (paramSessionInfo.cZ == 3000)
                        {
                          paramContext.nOpType = 22;
                          paramQQAppInterface.a().a(paramContext, 22);
                        }
                      }
                    }
                    paramContext = paramQQAppInterface.a().a(paramString, paramContext, paramSessionInfo.aTl, paramSessionInfo.cZ, true, paramForwardFileInfo.fS(), i);
                    if (paramSessionInfo.cZ == 3000) {
                      paramContext.nOpType = 28;
                    }
                    paramQQAppInterface.a().j(paramContext);
                    paramQQAppInterface.a().u(paramContext);
                    continue;
                    paramContext = paramQQAppInterface.a().b(paramForwardFileInfo.fR());
                    paramQQAppInterface.a().b(paramContext, paramSessionInfo.troopUin, paramSessionInfo.aTl, paramSessionInfo.cZ, i);
                    continue;
                    paramString = paramQQAppInterface.a().b(paramForwardFileInfo.fR());
                    if ((paramString != null) && (paramString.cloudFile != null) && (paramString.cloudFile.onlineFileExt != null))
                    {
                      athu.a(paramQQAppInterface, paramContext, paramString, paramSessionInfo);
                    }
                    else
                    {
                      paramQQAppInterface.a().d(paramString, paramSessionInfo.troopUin, paramSessionInfo.aTl, paramSessionInfo.cZ, i);
                      continue;
                      if (paramSessionInfo.cZ == 1)
                      {
                        if (ahbj.fileExistsAndNotEmpty(paramForwardFileInfo.getLocalPath()))
                        {
                          paramQQAppInterface.a().a(paramForwardFileInfo.getLocalPath(), paramSessionInfo.aTl, 0L, i);
                        }
                        else
                        {
                          paramString = paramQQAppInterface.a().b(paramForwardFileInfo.fR());
                          paramContext = paramQQAppInterface.getCurrentAccountUin();
                          if ((paramSessionInfo.cZ == 1004) || (paramSessionInfo.cZ == 1000)) {
                            paramContext = paramSessionInfo.troopUin;
                          }
                          if ((paramString != null) && (paramString.peerType == 3000))
                          {
                            paramContext = paramQQAppInterface.a().a(paramString, paramContext, paramSessionInfo.aTl, paramString.peerType, false);
                            paramContext.selfUin = paramString.peerUin;
                            paramQQAppInterface.a().a(paramContext, 27);
                          }
                          else
                          {
                            paramQQAppInterface.a().m(paramForwardFileInfo.fR(), paramSessionInfo.aTl, i);
                          }
                        }
                      }
                      else
                      {
                        paramQQAppInterface.a().a(paramForwardFileInfo.fR(), paramSessionInfo.troopUin, paramSessionInfo.aTl, paramSessionInfo.cZ, true, i);
                        continue;
                        paramQQAppInterface.a().a(str, paramSessionInfo.aTl, paramSessionInfo.cZ, i);
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
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Emoticon paramEmoticon)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramEmoticon, 0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Emoticon paramEmoticon, int paramInt)
  {
    if (paramEmoticon == null)
    {
      Toast.makeText(paramContext, "emoticon is null.", 0).show();
      QLog.e("ChatActivityFacade", 1, "sendEmosmMsg emoticon is null:");
      return;
    }
    if (((paramEmoticon.jobType == 0) || (paramEmoticon.jobType == 2) || (paramEmoticon.jobType == 4)) && (!paramEmoticon.hasEncryptKey()))
    {
      Toast.makeText(paramContext, paramContext.getString(2131693340), 0).show();
      a(paramQQAppInterface, paramEmoticon);
      aqrm.b("emotionType", "emotionActionSend", "2", paramEmoticon.epId, paramEmoticon.eId, aqiw.getNetworkType(paramContext) + "", "", "", "", "");
      paramContext = new StringBuilder().append("sendEmosmMsg emoticon Encrypt Key is null.name:");
      if (paramEmoticon.name != null)
      {
        paramQQAppInterface = paramEmoticon.name;
        paramContext = paramContext.append(paramQQAppInterface).append(", epid_eid:");
        if (paramEmoticon.epId == null) {
          break label223;
        }
        paramQQAppInterface = paramEmoticon.epId;
        label176:
        paramContext = paramContext.append(paramQQAppInterface).append("_");
        if (paramEmoticon.eId == null) {
          break label230;
        }
      }
      label223:
      label230:
      for (paramQQAppInterface = paramEmoticon.eId;; paramQQAppInterface = "~")
      {
        QLog.e("ChatActivityFacade", 1, paramQQAppInterface);
        return;
        paramQQAppInterface = "~";
        break;
        paramQQAppInterface = "~";
        break label176;
      }
    }
    ThreadManager.post(new ChatActivityFacade.19(paramQQAppInterface, paramEmoticon, paramContext, paramSessionInfo, paramInt), 5, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Emoticon paramEmoticon, long paramLong)
  {
    paramContext = paramQQAppInterface.b().a(paramSessionInfo.aTl, paramSessionInfo.cZ, paramLong);
    if (paramContext != null)
    {
      paramQQAppInterface.b().t(paramSessionInfo.aTl, paramSessionInfo.cZ, paramLong);
      paramContext = anbi.e(paramContext);
      paramQQAppInterface.b().a(paramContext, null, true);
      paramQQAppInterface = (ajdg)paramQQAppInterface.getManager(14);
      if ((paramQQAppInterface != null) && (paramEmoticon != null))
      {
        paramContext = paramQQAppInterface.a(paramEmoticon);
        if ((paramContext != null) && (paramContext.size() > 0))
        {
          paramContext = paramContext.iterator();
          while (paramContext.hasNext())
          {
            paramSessionInfo = (String)paramContext.next();
            if (!TextUtils.isEmpty(paramSessionInfo))
            {
              RecentEmotion localRecentEmotion = new RecentEmotion();
              localRecentEmotion.epId = paramEmoticon.epId;
              localRecentEmotion.eId = paramEmoticon.eId;
              localRecentEmotion.keyword = paramSessionInfo.toLowerCase();
              localRecentEmotion.exposeNum = 0;
              paramQQAppInterface.a(localRecentEmotion);
            }
          }
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("ChatActivityFacade", 2, "reSendEmosmMessage : mr is null.");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Emoticon paramEmoticon, EmojiStickerManager.StickerInfo paramStickerInfo)
  {
    if (paramEmoticon == null)
    {
      Toast.makeText(paramContext, "emoticon is null.", 0).show();
      QLog.e("ChatActivityFacade", 1, "sendEmosmMsg emoticon is null:");
      return;
    }
    if (((paramEmoticon.jobType == 0) || (paramEmoticon.jobType == 2) || (paramEmoticon.jobType == 4)) && (!paramEmoticon.hasEncryptKey()))
    {
      Toast.makeText(paramContext, paramContext.getString(2131693340), 0).show();
      a(paramQQAppInterface, paramEmoticon);
      aqrm.b("emotionType", "emotionActionSend", "2", paramEmoticon.epId, paramEmoticon.eId, aqiw.getNetworkType(paramContext) + "", "", "", "", "");
      paramContext = new StringBuilder().append("sendEmosmMsg emoticon Encrypt Key is null.name:");
      if (paramEmoticon.name != null)
      {
        paramQQAppInterface = paramEmoticon.name;
        paramContext = paramContext.append(paramQQAppInterface).append(", epid_eid:");
        if (paramEmoticon.epId == null) {
          break label223;
        }
        paramQQAppInterface = paramEmoticon.epId;
        label176:
        paramContext = paramContext.append(paramQQAppInterface).append("_");
        if (paramEmoticon.eId == null) {
          break label230;
        }
      }
      label223:
      label230:
      for (paramQQAppInterface = paramEmoticon.eId;; paramQQAppInterface = "~")
      {
        QLog.e("ChatActivityFacade", 1, paramQQAppInterface);
        return;
        paramQQAppInterface = "~";
        break;
        paramQQAppInterface = "~";
        break label176;
      }
    }
    ThreadManager.post(new ChatActivityFacade.20(paramQQAppInterface, paramEmoticon, paramContext, paramSessionInfo, paramStickerInfo), 5, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString, int paramInt)
  {
    if (paramString == null) {
      return;
    }
    aqhu.a(-1L, paramSessionInfo.cZ, true, "image_send_prepare", "ChatActivity.sendIMEEXpression");
    if (!aqhq.fileExistsAndNotEmpty(paramString))
    {
      ChatActivityUtils.h(paramContext, 2131696982, 0);
      aqhu.a(-1L, paramSessionInfo.cZ, true, "image_send_prepared_failed", "ChatActivity.sendIMEEXpression");
      return;
    }
    paramContext = new akxy.a();
    paramContext.setLocalPath(paramString);
    paramContext.So(paramInt);
    paramContext.NP(paramSessionInfo.aTl);
    paramContext.setProtocolType(aooh.a.dQC);
    paramContext.NT(paramSessionInfo.troopUin);
    paramContext.kc(paramQQAppInterface.getCurrentAccountUin());
    paramContext.Sp(paramSessionInfo.cZ);
    paramContext.St(paramSessionInfo.topicId);
    akxq localakxq = akxj.a(2, paramInt);
    localakxq.c(paramContext.a());
    akxj.a(localakxq, paramQQAppInterface);
    ThreadManager.post(new ChatActivityFacade.10(paramString, paramSessionInfo, paramQQAppInterface), 5, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString, int paramInt, long paramLong)
  {
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      ChatActivityUtils.h(paramContext, 2131693404, 0);
      return;
    }
    paramSessionInfo = paramQQAppInterface.b().a(paramString, paramInt, paramLong);
    if (paramSessionInfo == null)
    {
      ChatActivityUtils.h(paramContext, 2131719483, 0);
      return;
    }
    ThreadManager.post(new ChatActivityFacade.22(paramSessionInfo, paramQQAppInterface, paramString, paramInt, paramLong), 10, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString, long paramLong)
  {
    if ((paramSessionInfo.cZ == 1) && (((apsw)paramQQAppInterface.getManager(48)).a(paramSessionInfo.aTl, true).cSk) && ((paramContext instanceof BaseActivity)))
    {
      paramContext = (BaseActivity)paramContext;
      QQToast.a(paramQQAppInterface.getApp(), 2131699615, 0).show(paramContext.getTitleBarHeight());
      return;
    }
    ThreadManager.post(new ChatActivityFacade.21(paramQQAppInterface, paramSessionInfo, paramLong), 10, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString1, String paramString2, String paramString3, long paramLong, int paramInt, String paramString4)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramString1, paramString2, paramString3, paramLong, paramInt, paramString4, 0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString1, String paramString2, String paramString3, long paramLong, int paramInt1, String paramString4, int paramInt2)
  {
    if (aqhq.fileExistsAndNotEmpty(paramString1)) {
      aqhr.a(paramQQAppInterface, paramString1, paramSessionInfo.aTl, paramSessionInfo.cZ, paramSessionInfo.troopUin, false, paramContext, paramInt2);
    }
    long l1;
    long l2;
    do
    {
      do
      {
        return;
        l1 = a(paramQQAppInterface, paramString1, paramSessionInfo.aTl, paramSessionInfo.cZ, paramString2, paramString3, paramLong, paramInt1);
        paramContext = paramQQAppInterface.a().a(paramString3, paramLong);
        if (QLog.isColorLevel()) {
          QLog.d("streamptt", 2, "ChatActivity.handleForwardData forwardPic wait for download1,uniseq:" + l1 + ",filePath:" + paramString1 + ",forwardImageOrgServerpath:" + paramString2 + ",forwardImageOrgItemId:" + paramLong + ",processor:" + paramContext);
        }
      } while ((paramContext == null) || (!(paramContext instanceof aojn)));
      paramContext = (aojn)paramContext;
      l2 = paramContext.hh();
      if (QLog.isColorLevel()) {
        QLog.d("streamptt", 2, "ChatActivity.handleForwardData forwardPic wait for download2,msgId:" + l1 + ",filePath:" + paramString1 + ",get download process status:" + l2);
      }
    } while ((l2 != 2000L) && (l2 != 2001L) && (l2 != 2002L));
    paramQQAppInterface.a().a(l1, paramString4, paramQQAppInterface, paramSessionInfo.cZ, paramSessionInfo.aTl, paramString1, paramString2, paramString3, paramLong, paramInt1);
    paramContext.b().cly = paramString4;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramString, paramArrayList, new ujt.d());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString1, boolean paramBoolean, String paramString2, Bundle paramBundle)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramString1, false, false, paramBoolean, null, null, paramString2, paramBundle);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, EmojiStickerManager.StickerInfo paramStickerInfo)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramString1, paramBoolean1, paramBoolean2, false, paramString2, paramStickerInfo, null, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2, EmojiStickerManager.StickerInfo paramStickerInfo, String paramString3, Bundle paramBundle)
  {
    if (paramString1 == null)
    {
      QLog.e("ChatActivityFacade", 1, "sendCustomEmotion url == null");
      if (paramBoolean1) {
        aqrm.b("emotionType", "emotionActionSend", "5", "", "", "", "", "", "", "");
      }
      return;
    }
    aqhu.a(-1L, paramSessionInfo.cZ, true, "image_send_prepare", "ChatActivity.sendCustomEmotion");
    if (!aqhq.fileExistsAndNotEmpty(paramString1))
    {
      ChatActivityUtils.h(paramContext, 2131696982, 0);
      if (paramBoolean1) {
        aqrm.b("emotionType", "emotionActionSend", "6", "", "", "", "", "", "", "");
      }
      QLog.e("ChatActivityFacade", 1, "sendCustomEmotion file not exist or problme: URL = " + paramString1);
      return;
    }
    Object localObject = new akxy.a();
    ((akxy.a)localObject).setLocalPath(paramString1);
    ((akxy.a)localObject).So(1006);
    ((akxy.a)localObject).NP(paramSessionInfo.aTl);
    ((akxy.a)localObject).setProtocolType(aooh.a.dQC);
    ((akxy.a)localObject).NT(paramSessionInfo.troopUin);
    ((akxy.a)localObject).kc(paramQQAppInterface.getCurrentAccountUin());
    ((akxy.a)localObject).Sp(paramSessionInfo.cZ);
    ((akxy.a)localObject).St(paramSessionInfo.topicId);
    akxq localakxq = akxj.a(2, 1006);
    localakxq.c(((akxy.a)localObject).a());
    localObject = new PicMessageExtraData();
    if (paramBoolean3)
    {
      ((PicMessageExtraData)localObject).imageBizType = 8;
      if (paramBundle != null) {
        ((PicMessageExtraData)localObject).mTemplateId = paramBundle.getString("widgetinfo", "");
      }
      if (TextUtils.isEmpty(paramString3)) {
        break label411;
      }
      ((PicMessageExtraData)localObject).textSummary = ("[" + paramString3 + "]");
    }
    for (;;)
    {
      localakxq.b = ((PicMessageExtraData)localObject);
      akxj.a(localakxq, paramQQAppInterface);
      if (!paramBoolean1) {
        break;
      }
      ThreadManager.post(new ChatActivityFacade.11(paramString1, paramSessionInfo, paramQQAppInterface), 5, null, false);
      return;
      ((PicMessageExtraData)localObject).imageBizType = 1;
      int i;
      if (paramBoolean2)
      {
        i = 2;
        label364:
        ((PicMessageExtraData)localObject).customFaceType = i;
        if (!paramBoolean2) {
          break label404;
        }
      }
      for (;;)
      {
        ((PicMessageExtraData)localObject).emojiPkgId = paramString2;
        if (paramStickerInfo == null) {
          break;
        }
        ((PicMessageExtraData)localObject).stickerInfo = paramStickerInfo;
        break;
        i = 0;
        break label364;
        label404:
        paramString2 = "";
      }
      label411:
      if (paramBoolean3) {
        ((PicMessageExtraData)localObject).textSummary = paramContext.getResources().getString(2131692308);
      } else {
        ((PicMessageExtraData)localObject).textSummary = paramContext.getResources().getString(2131692307);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, List<String> paramList)
  {
    Object localObject1 = PreferenceManager.getDefaultSharedPreferences(paramContext).getString("single_way_friend_list", "");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      int i;
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        paramList = paramList.iterator();
        if (paramList.hasNext())
        {
          String str = (String)paramList.next();
          i = 0;
          if (i >= ((JSONArray)localObject1).length()) {
            continue;
          }
          Object localObject2 = ((JSONArray)localObject1).getJSONObject(i);
          if ((((JSONObject)localObject2).has("uin")) && (((JSONObject)localObject2).has("type")) && (((JSONObject)localObject2).getString("uin").equals(top.gY(str))))
          {
            localObject2 = paramQQAppInterface.b().k(str, 0);
            ChatActivityUtils.a(paramContext, str, 0, "single_way_friend_list");
            localObject2 = ((List)localObject2).iterator();
            if (((Iterator)localObject2).hasNext())
            {
              MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
              if (localMessageRecord.msgtype != -2019) {
                continue;
              }
              paramQQAppInterface.b().t(str, localMessageRecord.istroop, localMessageRecord.uniseq);
              continue;
            }
          }
        }
        else
        {
          return;
        }
      }
      catch (JSONException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
      }
      i += 1;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    long l;
    do
    {
      try
      {
        Long.valueOf(paramSessionInfo.aTl).longValue();
        l = paramQQAppInterface.b().g(paramSessionInfo.aTl, paramSessionInfo.cZ);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.sendReadConfirm_PB", 2, String.format("ChatActivityFacade,uin: %s, uinType: %d, id: %d", new Object[] { paramSessionInfo.aTl, Integer.valueOf(paramSessionInfo.cZ), Long.valueOf(l) }));
        }
        if (paramSessionInfo.cZ == 1036) {
          return;
        }
      }
      catch (NumberFormatException paramQQAppInterface)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("Q.msg.sendReadConfirm_PB", 2, paramQQAppInterface, new Object[0]);
        return;
      }
    } while ((l == -1L) || (l == paramSessionInfo.Ib));
    paramSessionInfo.Ib = l;
    String str = top.cp(paramSessionInfo.cZ);
    paramQQAppInterface.a().a(str).m(paramSessionInfo.aTl, paramSessionInfo.cZ, l);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, long paramLong)
  {
    if ((paramQQAppInterface == null) || (paramQQAppInterface.getApp() == null) || (paramSessionInfo == null)) {
      return;
    }
    if (paramLong > NetConnInfoCenter.getServerTimeMillis())
    {
      QLog.e("ChatActivityFacade.QZoneFeeds", 2, String.format("帖子创建时间：%d,当前取得服务器时间：%d", new Object[] { Long.valueOf(paramLong), Long.valueOf(NetConnInfoCenter.getServerTimeMillis()) }));
      return;
    }
    QLog.i("ChatActivityFacade.QZoneFeeds", 2, String.format("Story帖子创建时间：%d", new Object[] { Long.valueOf(paramLong) }));
    paramSessionInfo = a(paramQQAppInterface, paramSessionInfo, "key_last_story_feed_create_time_for_aio");
    paramQQAppInterface.getApp().getSharedPreferences("qzone_sp_in_qq", 0).edit().putLong(paramSessionInfo, paramLong).apply();
  }
  
  private static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, AIONewestFeedRsp paramAIONewestFeedRsp, boolean paramBoolean)
  {
    if ((paramAIONewestFeedRsp == null) || (paramAIONewestFeedRsp.uOpuin != Long.valueOf(paramQQAppInterface.getCurrentAccountUin()).longValue()) || (paramAIONewestFeedRsp.uFeedInfos == null) || (paramAIONewestFeedRsp.uFeedInfos.isEmpty())) {
      if ((paramAIONewestFeedRsp != null) && (paramAIONewestFeedRsp.uOpFlag == 1L))
      {
        if (QLog.isColorLevel()) {
          QLog.i("ChatActivityFacade.QZoneFeeds", 2, "newestFeed.uOpFlag==1  需要清理本地缓存");
        }
        f(paramQQAppInterface, paramSessionInfo);
      }
    }
    Object localObject;
    label192:
    long[] arrayOfLong;
    do
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.i("ChatActivityFacade.QZoneFeeds", 2, "addQzoneFeedMessage 没有拉去到feeds信息");
      return;
      String str1;
      if ((paramAIONewestFeedRsp.mapEx != null) && (paramAIONewestFeedRsp.mapEx.containsKey("iGender"))) {
        str1 = (String)paramAIONewestFeedRsp.mapEx.get("iGender");
      }
      int i;
      for (;;)
      {
        try
        {
          i = Integer.parseInt(str1);
          localObject = (NewestFeedInfo)paramAIONewestFeedRsp.uFeedInfos.get(0);
          if (localObject != null) {
            break label192;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("ChatActivityFacade.QZoneFeeds", 2, "addQzoneFeedMessage feedInfo == null");
          return;
        }
        catch (Exception localException)
        {
          QLog.e("ChatActivityFacade.QZoneFeeds", 1, "gender parse error:", localException);
        }
        i = 1;
      }
      paramAIONewestFeedRsp = new boolean[1];
      arrayOfLong = new long[1];
      String str2 = String.valueOf(((NewestFeedInfo)localObject).uHostUin);
      if (FeedsManager.isShowStatus(str2))
      {
        arrayOfLong[0] = FeedsManager.getToken(str2);
        paramAIONewestFeedRsp[0] = 1;
        FeedsManager.hideStatus(str2);
      }
      localObject = a((NewestFeedInfo)localObject, paramBoolean, i);
      if (localObject != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ChatActivityFacade.QZoneFeeds", 2, "jsonOb == null");
    return;
    ThreadManager.getSubThreadHandler().post(new ChatActivityFacade.6(paramQQAppInterface, paramSessionInfo, (JSONObject)localObject, paramBoolean, paramAIONewestFeedRsp, arrayOfLong));
  }
  
  private static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, CLIENT.StGetUserNewestStoryRsp paramStGetUserNewestStoryRsp)
  {
    if (paramStGetUserNewestStoryRsp == null) {
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivityFacade.QZoneStoryFeeds", 2, " rsp is null");
      }
    }
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.i("ChatActivityFacade.QZoneStoryFeeds", 2, " hasNewStory:" + paramStGetUserNewestStoryRsp.hasNewStory.get());
        }
      } while (paramStGetUserNewestStoryRsp.hasNewStory.get() != 1);
      if (paramStGetUserNewestStoryRsp.vecStoryFeed.isEmpty()) {
        break label144;
      }
      paramStGetUserNewestStoryRsp = (META.StStoryFeed)paramStGetUserNewestStoryRsp.vecStoryFeed.get(0);
      if (paramStGetUserNewestStoryRsp != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ChatActivityFacade.QZoneStoryFeeds", 2, "addQzoneStoryFeedMessage storyFeed == null");
    return;
    a(paramQQAppInterface, paramSessionInfo, paramStGetUserNewestStoryRsp.createTime.get());
    ThreadManager.getSubThreadHandler().post(new ChatActivityFacade.7(paramQQAppInterface, paramSessionInfo, paramStGetUserNewestStoryRsp));
    return;
    label144:
    ThreadManager.getSubThreadHandler().post(new ChatActivityFacade.8(paramQQAppInterface, paramSessionInfo));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Intent paramIntent)
  {
    if (paramIntent == null) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    } while ((localArrayList == null) || (localArrayList.isEmpty()) || (TextUtils.isEmpty(paramSessionInfo.aTl)));
    try
    {
      int i = Integer.valueOf(paramIntent.getStringExtra("key_upload_client_key")).intValue();
      long l = a(paramQQAppInterface, paramSessionInfo, i, localArrayList);
      ((acne)paramQQAppInterface.getBusinessHandler(28)).f(i, paramSessionInfo.aTl, l);
      return;
    }
    catch (NumberFormatException paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, MessageForPic paramMessageForPic, int paramInt)
  {
    if ((paramQQAppInterface == null) || (paramSessionInfo == null) || (paramMessageForPic == null))
    {
      QLog.e("ChatActivityFacade", 1, "forwardPicMsg failed!");
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("uin", paramSessionInfo.aTl);
    ((Intent)localObject).putExtra("troop_uin", paramSessionInfo.troopUin);
    ((Intent)localObject).putExtra("uintype", paramSessionInfo.cZ);
    ((Intent)localObject).putExtra("FORWARD_UIN_TYPE", paramSessionInfo.cZ);
    ((Intent)localObject).putExtra("SENDER_TROOP_UIN", paramSessionInfo.troopUin);
    ((Intent)localObject).putExtra("FORWARD_PEER_UIN", paramSessionInfo.aTl);
    ((Intent)localObject).putExtra("FORWARD_SELF_UIN", paramQQAppInterface.getCurrentAccountUin());
    ((Intent)localObject).putExtra("forward_image_width", paramMessageForPic.width);
    ((Intent)localObject).putExtra("forward_image_height", paramMessageForPic.height);
    ((Intent)localObject).putExtra("forward_file_size", paramMessageForPic.size);
    ((Intent)localObject).putExtra("forward_image_type", paramMessageForPic.imageType);
    ((Intent)localObject).putExtra("forward_filepath", paramMessageForPic.path);
    paramSessionInfo = paramMessageForPic.frienduin + paramMessageForPic.uniseq + paramMessageForPic.istroop;
    ((Intent)localObject).putExtra("BUSI_TYPE", 1009);
    ((Intent)localObject).putExtra("forward_download_image_task_key", paramSessionInfo);
    ((Intent)localObject).putExtra("forward_download_image_org_uin", paramMessageForPic.frienduin);
    ((Intent)localObject).putExtra("forward_download_image_org_uin_type", paramMessageForPic.istroop);
    ((Intent)localObject).putExtra("forward_download_image_server_path", paramMessageForPic.uuid);
    ((Intent)localObject).putExtra("forward_download_image_item_id", paramMessageForPic.uniseq);
    ((Intent)localObject).putExtra("forward_photo_isSend", paramMessageForPic.issend);
    ((Intent)localObject).putExtra("forward_photo_md5", paramMessageForPic.md5);
    ((Intent)localObject).putExtra("forward_photo_group_fileid", paramMessageForPic.groupFileID);
    ((Intent)localObject).putExtra("FORWARD_PHOTO_FILE_SIZE_FLAG", paramMessageForPic.fileSizeFlag);
    paramSessionInfo = akxj.a(1009, (Intent)localObject);
    localObject = akxj.a(3, 1009);
    ((akxq)localObject).c(paramSessionInfo);
    ((akxq)localObject).j = paramMessageForPic;
    ((akxq)localObject).b = paramMessageForPic.picExtraData;
    paramMessageForPic.forwardId.put(localObject, Integer.valueOf(paramInt));
    akxj.a((akxq)localObject, paramQQAppInterface);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, MessageForShortVideo paramMessageForShortVideo)
  {
    int j = 2;
    if ((paramQQAppInterface == null) || (paramMessageForShortVideo == null))
    {
      QLog.e("ChatActivityFacade", 1, "forwardPicMsg failed!");
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("uin", paramSessionInfo.aTl);
    ((Intent)localObject).putExtra("troop_uin", paramSessionInfo.troopUin);
    ((Intent)localObject).putExtra("uintype", paramSessionInfo.cZ);
    ((Intent)localObject).putExtra("from_uin", ShortVideoUtils.f(paramMessageForShortVideo));
    ((Intent)localObject).putExtra("from_uin_type", paramMessageForShortVideo.istroop);
    ((Intent)localObject).putExtra("from_session_uin", paramMessageForShortVideo.frienduin);
    ((Intent)localObject).putExtra("from_busi_type", paramMessageForShortVideo.busiType);
    ((Intent)localObject).putExtra("file_send_size", paramMessageForShortVideo.videoFileSize);
    ((Intent)localObject).putExtra("file_send_duration", paramMessageForShortVideo.videoFileTime);
    ((Intent)localObject).putExtra("file_name", paramMessageForShortVideo.videoFileName);
    ((Intent)localObject).putExtra("file_format", paramMessageForShortVideo.videoFileFormat);
    String str = ShortVideoUtils.e(paramMessageForShortVideo);
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityFacade", 2, "Forward menu clicked, videoPath=" + str + ",videoPath = " + str + ", " + paramMessageForShortVideo.toLogString());
    }
    ((Intent)localObject).putExtra("file_send_path", str);
    ((Intent)localObject).putExtra("thumbfile_send_path", ShortVideoUtils.bw(paramMessageForShortVideo.thumbMD5, "jpg"));
    ((Intent)localObject).putExtra("file_shortvideo_md5", paramMessageForShortVideo.md5);
    if (!TextUtils.isEmpty(paramMessageForShortVideo.mLocalMd5)) {
      ((Intent)localObject).putExtra("file_shortvideo_local_md5", paramMessageForShortVideo.mLocalMd5);
    }
    ((Intent)localObject).putExtra("thumbfile_send_width", paramMessageForShortVideo.thumbWidth);
    ((Intent)localObject).putExtra("thumbfile_send_height", paramMessageForShortVideo.thumbHeight);
    ((Intent)localObject).putExtra("thumbfile_md5", paramMessageForShortVideo.thumbMD5);
    ((Intent)localObject).putExtra("file_source", paramMessageForShortVideo.fileSource);
    ((Intent)localObject).putExtra("file_uuid", paramMessageForShortVideo.uuid);
    ((Intent)localObject).putExtra("file_thumb_Size", paramMessageForShortVideo.thumbFileSize);
    ((Intent)localObject).putExtra("support_progressive", paramMessageForShortVideo.supportProgressive);
    ((Intent)localObject).putExtra("file_width", paramMessageForShortVideo.fileWidth);
    ((Intent)localObject).putExtra("file_height", paramMessageForShortVideo.fileHeight);
    ((Intent)localObject).putExtra("from_msg_uniseq", paramMessageForShortVideo.uniseq);
    int i = paramMessageForShortVideo.busiType;
    if (i == 1)
    {
      i = 2;
      ((Intent)localObject).putExtra("special_video_type", paramMessageForShortVideo.specialVideoType);
      if (paramMessageForShortVideo.CheckIsHotVideo())
      {
        ((Intent)localObject).putExtra("hot_video_icon", paramMessageForShortVideo.hotVideoIconUrl);
        ((Intent)localObject).putExtra("hot_video_icon_sub", paramMessageForShortVideo.hotVideoSubIconUrl);
        ((Intent)localObject).putExtra("hot_video_title", paramMessageForShortVideo.hotVideoTitle);
        ((Intent)localObject).putExtra("hot_video_url", paramMessageForShortVideo.hotVideoUrl);
      }
      ((Intent)localObject).putExtra("short_video_msg_tail_type", paramMessageForShortVideo.msgTailType);
      ((Intent)localObject).putExtra("widgetinfo", paramMessageForShortVideo.templateId);
      ((Intent)localObject).putExtra("key_camera_material_name", paramMessageForShortVideo.templateName);
      if ((paramMessageForShortVideo.redBagType == LocalMediaInfo.REDBAG_TYPE_GET) && (paramMessageForShortVideo.senderuin.equals(paramQQAppInterface.getAccount())))
      {
        ((Intent)localObject).putExtra("param_key_redbag_video_id", paramMessageForShortVideo.shortVideoId);
        ((Intent)localObject).putExtra("param_key_redbag_type", paramMessageForShortVideo.redBagType);
        if (paramSessionInfo.cZ != 1) {
          break label696;
        }
        j = 1;
      }
    }
    for (;;)
    {
      aaqi.ao("", "0X80088E4", String.valueOf(j));
      paramSessionInfo = anfr.a(3, i);
      localObject = anfr.a(i, localObject, paramSessionInfo);
      if (localObject != null)
      {
        ((anfw)localObject).uniseq = paramMessageForShortVideo.uniseq;
        ((anfw)localObject).forwardID = paramMessageForShortVideo.forwardID;
        paramSessionInfo.b((anfw)localObject);
      }
      anfr.a(paramSessionInfo, paramQQAppInterface);
      return;
      if (i == 2)
      {
        i = 3;
        break;
      }
      i = 0;
      break;
      label696:
      if (paramSessionInfo.cZ != 3000) {
        j = 3;
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, AbsShareMsg paramAbsShareMsg)
  {
    a(paramQQAppInterface, paramSessionInfo, paramAbsShareMsg);
    adqu.a(paramQQAppInterface, "com.tencent.map", "AIOArkMapSendMessage", 2, 0, 0L, 0L, 0L, "LocationShare", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, AbsStructMsg paramAbsStructMsg)
  {
    switch (paramSessionInfo.cZ)
    {
    }
    for (String str1 = paramQQAppInterface.getCurrentAccountUin();; str1 = paramSessionInfo.troopUin)
    {
      String str2 = paramQQAppInterface.getCurrentAccountUin();
      String str3 = paramSessionInfo.aTl;
      int i = paramSessionInfo.cZ;
      int j = amzo.seq;
      amzo.seq = j + 1;
      paramSessionInfo = anbi.a(paramQQAppInterface, str2, str3, str1, i, j, paramAbsStructMsg);
      wte.a().i(paramSessionInfo.uniseq, paramAbsStructMsg.parentUniseq, paramAbsStructMsg.forwardID);
      paramQQAppInterface.b().a(paramSessionInfo, null);
      return;
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString)
  {
    if ((paramQQAppInterface == null) || (paramQQAppInterface.getApp() == null) || (paramSessionInfo == null)) {
      return;
    }
    paramSessionInfo = a(paramQQAppInterface, paramSessionInfo, paramString);
    paramQQAppInterface.getApp().getSharedPreferences("qzone_sp_in_qq", 0).edit().putLong(paramSessionInfo, NetConnInfoCenter.getServerTimeMillis()).apply();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, int paramInt, long paramLong)
  {
    if (paramLong != -1L)
    {
      int i = paramSessionInfo.cZ;
      Object localObject = paramQQAppInterface.b().a(paramSessionInfo.aTl, i, paramLong);
      if ((localObject instanceof MessageForPtt))
      {
        localObject = (MessageForPtt)localObject;
        ((MessageForPtt)localObject).url = paramString;
        ((MessageForPtt)localObject).fileSize = paramInt;
        ((MessageForPtt)localObject).isread = false;
        ((MessageForPtt)localObject).itemType = 2;
        ((MessageForPtt)localObject).serial();
        paramQQAppInterface.b().c(paramSessionInfo.aTl, i, paramLong, ((MessageForPtt)localObject).msgData);
        paramQQAppInterface.b().a(paramSessionInfo.aTl, i, paramLong, "extStr", ((MessageForPtt)localObject).extStr);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString1, String paramString2, String paramString3)
  {
    if ((paramSessionInfo == null) || (TextUtils.isEmpty(paramSessionInfo.aTl))) {
      return;
    }
    b(paramQQAppInterface, paramSessionInfo, ujs.aLM + "http://maps.google.com/maps?q=" + paramString1 + "," + paramString2 + "&iwloc=A&hl=zh-CN (" + paramString3 + ")");
  }
  
  private static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString1, String paramString2, String paramString3, String paramString4, AbsShareMsg paramAbsShareMsg, String paramString5, String paramString6, String paramString7)
  {
    paramString7 = new ArkAppMessage();
    if (adph.bQb) {}
    for (;;)
    {
      try
      {
        paramString7.appMinVersion = "1.0.0.101";
        paramString7.appName = "com.tencent.map";
        paramString7.appView = "LocationShare";
        paramString6 = ArkAppCacheMgr.getApplicationFromManifest(paramString7.appName, paramString7.appMinVersion);
        if (paramString6 != null)
        {
          paramString7.appDesc = ((String)paramString6.get("desc"));
          paramString7.appMinVersion = ((String)paramString6.get("version"));
        }
        paramString6 = acfp.m(2131703567);
        if ((TextUtils.isEmpty(paramString7.appDesc)) || (paramString7.appDesc.equals(paramString7.appName))) {
          paramString7.appDesc = paramString6;
        }
        switch (paramSessionInfo.cZ)
        {
        case 1000: 
          paramString6 = paramQQAppInterface.getCurrentAccountUin();
          String str1 = paramQQAppInterface.getCurrentAccountUin();
          String str2 = paramSessionInfo.aTl;
          int i = paramSessionInfo.cZ;
          int j = amzo.seq;
          amzo.seq = j + 1;
          paramString7.containStructMsg = anbi.a(paramQQAppInterface, str1, str2, paramString6, i, j, paramAbsShareMsg);
          paramString7.promptText = String.format(acfp.m(2131703580), new Object[] { paramString7.appDesc });
          paramString7.from = 1;
          paramString7.metaList = b(paramString5, paramString3, paramString4, paramString1, paramString2);
          paramString1 = new JSONObject();
          paramString1.put("forward", 1);
          paramString1.put("autosize", 1);
          paramString1.put("type", "card");
          paramString7.config = paramString1.toString();
          a(paramQQAppInterface, paramSessionInfo, paramString7, paramAbsShareMsg.forwardID);
          ArkAppCenter.r("sendArkStructMap", "send ark msg is success and arkMsg.metaList=" + paramString7.metaList);
          adqu.a(paramQQAppInterface, "com.tencent.map", "AIOArkMapSendMessage", 1, 0, 0L, 0L, 0L, paramString7.appView, "");
          return;
        }
      }
      catch (Exception paramString1)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("ArkApp", 1, "ChatActivityFacade send arkMapMessage parameter error: " + paramString1.getMessage());
        ArkAppCenter.r("sendArkStructMap", "parameter error and send ark msg is failed then send struct msg");
        a(paramQQAppInterface, paramSessionInfo, paramAbsShareMsg);
        return;
      }
      paramString6 = paramSessionInfo.troopUin;
      continue;
      ArkAppCenter.r("sendArkStructMap", "sIsArkStructMap is false then send struct msg");
      a(paramQQAppInterface, paramSessionInfo, paramAbsShareMsg);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    if (paramSessionInfo.cZ != 0) {
      return;
    }
    ThreadManager.post(new ChatActivityFacade.2(paramQQAppInterface, paramSessionInfo, paramBoolean), 5, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Emoticon paramEmoticon)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityFacade", 2, "func tryFetchEmosmKey, app:" + paramQQAppInterface + ",e:" + paramEmoticon);
    }
    if ((paramQQAppInterface == null) || (paramEmoticon == null) || (TextUtils.isEmpty(paramEmoticon.epId)) || (TextUtils.isEmpty(paramEmoticon.eId)) || (!TextUtils.isEmpty(paramEmoticon.encryptKey))) {
      return;
    }
    afke localafke = (afke)paramQQAppInterface.getManager(43);
    ThreadManager.post(new ChatActivityFacade.18(paramEmoticon, (ajdg)paramQQAppInterface.getManager(14), localafke), 5, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, MessageForPtt paramMessageForPtt, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2)
  {
    a(paramQQAppInterface, paramString, paramMessageForPtt, paramBoolean1, paramInt1, paramInt2, paramBoolean2, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, MessageForPtt paramMessageForPtt, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, akxb paramakxb)
  {
    paramString = new ChatActivityFacade.1(paramMessageForPtt, paramQQAppInterface, paramString, paramBoolean2, paramakxb, paramInt1, paramInt2);
    if (paramBoolean1)
    {
      paramString.run();
      return;
    }
    paramQQAppInterface.execute(paramString);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, ArrayList<String> paramArrayList, ujt.a parama)
  {
    String str = "";
    if (paramString != null) {
      str = anbk.a(paramString, true, null);
    }
    int i = amzo.seq;
    amzo.seq = i + 1;
    long l1 = i;
    i = Math.abs(new Random().nextInt());
    int j = (int)anaz.gQ();
    paramString = paramQQAppInterface.getCurrentAccountUin();
    long l2 = anbk.I(i);
    ChatMessage localChatMessage = (ChatMessage)anbi.d(-1000);
    localChatMessage.init(paramString, "", paramString, str, j, -1000, 0, l1);
    localChatMessage.isread = true;
    localChatMessage.msgUid = l2;
    localChatMessage.shmsgseq = anbk.d(l1, 0);
    localChatMessage.issend = 1;
    if (paramArrayList.size() <= 10) {}
    for (boolean bool = true;; bool = false)
    {
      localChatMessage.needUpdateMsgTag = bool;
      ((acle)paramQQAppInterface.getBusinessHandler(13)).W(localChatMessage);
      ((MessageForText)localChatMessage).msgVia = 0;
      paramQQAppInterface.b().a(paramQQAppInterface, localChatMessage, paramArrayList, parama);
      return;
    }
  }
  
  private static boolean a(SessionInfo paramSessionInfo, String paramString, Bundle paramBundle)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals("Unknown Address")))
    {
      if (paramBundle != null)
      {
        if (paramBundle.getInt("isArk") == 0)
        {
          ArkAppCenter.r("sendArkStructMap", "isSendArkMsg, isArk=0 and sendStructMsg");
          return false;
        }
        if (c(paramSessionInfo))
        {
          ArkAppCenter.r("sendArkStructMap", "isSendArkMsg, session is allowed and sendArkMsg");
          return true;
        }
        ArkAppCenter.r("sendArkStructMap", "isSendArkMsg, session is not allowed and sendStructMsg");
        return false;
      }
      ArkAppCenter.r("sendArkStructMap", "isSendArkMsg, extra is empty and sendStructMsg");
      return false;
    }
    ArkAppCenter.r("sendArkStructMap", "isSendArkMsg,could not find location and sendStructMsg");
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, MessageForLongMsg paramMessageForLongMsg)
  {
    paramContext = paramMessageForLongMsg.longMsgFragmentList;
    if ((paramContext == null) || (paramContext.isEmpty())) {
      return false;
    }
    paramContext = paramContext.iterator();
    while (paramContext.hasNext())
    {
      paramMessageForLongMsg = (MessageRecord)paramContext.next();
      if (paramMessageForLongMsg.extraflag == 32768)
      {
        if (paramMessageForLongMsg.isSendFromLocal()) {
          paramQQAppInterface.a().oy(paramQQAppInterface.a().y(paramMessageForLongMsg.frienduin, paramMessageForLongMsg.uniseq));
        }
        paramQQAppInterface.b().t(paramSessionInfo.aTl, paramSessionInfo.cZ, paramMessageForLongMsg.uniseq);
        if (paramMessageForLongMsg.msgtype == -1000)
        {
          paramMessageForLongMsg = anbi.e(paramMessageForLongMsg);
          paramQQAppInterface.b().a(paramMessageForLongMsg, null, true);
        }
      }
    }
    return true;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (FeedsManager.isShowStatus(paramSessionInfo.aTl))
    {
      e(paramQQAppInterface, paramSessionInfo);
      c(paramQQAppInterface, paramSessionInfo);
      return true;
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ArkAppMessage paramArkAppMessage)
  {
    MessageForArkApp localMessageForArkApp = anbi.b(paramQQAppInterface, paramSessionInfo.aTl, paramSessionInfo.troopUin, paramSessionInfo.cZ, paramArkAppMessage);
    wte.a().i(localMessageForArkApp.uniseq, paramArkAppMessage.uniSeq, paramArkAppMessage.forwardID);
    if (localMessageForArkApp.istroop == 1) {
      jof.a().a(localMessageForArkApp);
    }
    localMessageForArkApp.saveExtInfoToExtStr(anbb.ccN, "1");
    paramArkAppMessage = (ArkAppCenter)paramQQAppInterface.getManager(121);
    if ((paramArkAppMessage != null) && (localMessageForArkApp.ark_app_message != null))
    {
      paramArkAppMessage = paramArkAppMessage.a();
      if (paramArkAppMessage == null) {}
    }
    for (boolean bool = paramArkAppMessage.a(paramQQAppInterface, localMessageForArkApp.ark_app_message.appName, paramSessionInfo, localMessageForArkApp);; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityFacade", 2, new Object[] { "AAShare.forwardArkMsgOption.isAsyncShareProcess=", Boolean.valueOf(bool) });
      }
      if (!bool) {
        paramQQAppInterface.b().a(localMessageForArkApp, null);
      }
      return true;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ArkAppMessage paramArkAppMessage, int paramInt)
  {
    MessageForArkApp localMessageForArkApp = anbi.a(paramQQAppInterface, paramSessionInfo.aTl, paramSessionInfo.troopUin, paramSessionInfo.cZ, paramArkAppMessage);
    if (paramInt == 0)
    {
      paramInt = paramArkAppMessage.forwardID;
      wte.a().i(localMessageForArkApp.uniseq, paramArkAppMessage.uniSeq, paramInt);
      if (localMessageForArkApp.istroop == 1) {
        jof.a().a(localMessageForArkApp);
      }
      paramArkAppMessage = (ArkAppCenter)paramQQAppInterface.getManager(121);
      if ((paramArkAppMessage == null) || (localMessageForArkApp.ark_app_message == null)) {
        break label161;
      }
      paramArkAppMessage = paramArkAppMessage.a();
      if (paramArkAppMessage == null) {
        break label161;
      }
    }
    label161:
    for (boolean bool = paramArkAppMessage.a(paramQQAppInterface, localMessageForArkApp.ark_app_message.appName, paramSessionInfo, localMessageForArkApp);; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityFacade", 2, new Object[] { "AAShare.forwardArkMsgOption.isAsyncShareProcess=", Boolean.valueOf(bool) });
      }
      if (!bool) {
        paramQQAppInterface.b().a(localMessageForArkApp, null);
      }
      return true;
      break;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ArkFlashChatMessage paramArkFlashChatMessage)
  {
    return a(paramQQAppInterface, paramSessionInfo, paramArkFlashChatMessage, 0);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ArkFlashChatMessage paramArkFlashChatMessage, int paramInt)
  {
    paramSessionInfo = anbi.a(paramQQAppInterface, paramSessionInfo.aTl, paramSessionInfo.troopUin, paramSessionInfo.cZ, paramArkFlashChatMessage);
    if (paramInt == 0) {
      paramInt = paramArkFlashChatMessage.forwardID;
    }
    for (;;)
    {
      wte.a().i(paramSessionInfo.uniseq, paramArkFlashChatMessage.uniSeq, paramInt);
      if (paramSessionInfo.istroop == 1) {
        jof.a().a(paramSessionInfo);
      }
      paramQQAppInterface.b().a(paramSessionInfo, null);
      return true;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, HiBoomMessage paramHiBoomMessage, achq paramachq)
  {
    return a(paramQQAppInterface, paramSessionInfo, paramHiBoomMessage, paramachq, 0);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, HiBoomMessage paramHiBoomMessage, achq paramachq, int paramInt)
  {
    paramSessionInfo = anbi.a(paramQQAppInterface, paramSessionInfo.aTl, paramSessionInfo.troopUin, paramSessionInfo.cZ, paramHiBoomMessage);
    wte.a().i(paramSessionInfo.uniseq, 0L, paramInt);
    if (paramSessionInfo.istroop == 1) {
      jof.a().a(paramSessionInfo);
    }
    paramQQAppInterface.b().a(paramSessionInfo, paramachq);
    return true;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, ujt.d paramd)
    throws UnsupportedEncodingException
  {
    return (ajkw.bc(paramQQAppInterface)) && (top.a(paramQQAppInterface, paramSessionInfo.cZ, paramSessionInfo.aTl)) && ((a(paramSessionInfo, paramString) > 560) || (a(paramd, true)));
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (paramSessionInfo == null)) {}
    do
    {
      return false;
      if (!avpw.aLj()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ChatActivityFacade.QZoneFeeds", 2, "wns 下发配置 要隐藏aio feeds，所以也不发请求了");
    return false;
    if (paramBoolean) {
      return b(paramQQAppInterface, paramSessionInfo);
    }
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageForArkApp paramMessageForArkApp, boolean paramBoolean)
  {
    if (paramMessageForArkApp.istroop == 1) {
      jof.a().a(paramMessageForArkApp);
    }
    if (paramBoolean) {
      paramQQAppInterface.b().z(paramMessageForArkApp);
    }
    paramMessageForArkApp.mPendantAnimatable = true;
    Object localObject = paramQQAppInterface.a().b().a(paramMessageForArkApp);
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityFacade", 2, "step2: sendLongTextMsg pack failed! packData is null.............................");
      }
      paramMessageForArkApp.extraflag = 32768;
      paramQQAppInterface.a().e(paramMessageForArkApp.frienduin, paramMessageForArkApp.istroop, paramMessageForArkApp.uniseq);
      localObject = paramMessageForArkApp.frienduin;
      int i = paramMessageForArkApp.istroop;
      long l = paramMessageForArkApp.uniseq;
      ((MessageHandler)paramQQAppInterface.getBusinessHandler(0)).notifyUI(MessageHandler.gz(paramMessageForArkApp.istroop), false, new Object[] { localObject, Integer.valueOf(i), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
      return true;
    }
    paramBoolean = ((ajkw)paramQQAppInterface.getManager(166)).b(paramQQAppInterface, (byte[])localObject, paramQQAppInterface.getCurrentAccountUin(), paramMessageForArkApp.frienduin, paramMessageForArkApp.frienduin, paramMessageForArkApp.istroop, paramMessageForArkApp.uniseq, 1035, new ujw(paramMessageForArkApp, paramQQAppInterface));
    if (paramBoolean) {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityFacade", 2, "sendLongTextMsg successful, uploadLongTextMsgPkg start!");
      }
    }
    for (;;)
    {
      return true;
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityFacade", 2, "sendLongTextMsg failed! isSuccess:" + paramBoolean);
      }
      ajkw.i(paramQQAppInterface, paramMessageForArkApp);
    }
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong)
  {
    paramQQAppInterface = paramQQAppInterface.b().a(paramString, paramInt, paramLong);
    if ((paramQQAppInterface != null) && ((paramQQAppInterface instanceof MessageForPtt))) {
      return ((MessageForPtt)paramQQAppInterface).c2cViaOffline;
    }
    return false;
  }
  
  private static boolean a(ujt.d paramd, boolean paramBoolean)
  {
    if (paramd.mSourceMsgInfo != null)
    {
      byte[] arrayOfByte = paramd.mSourceMsgInfo.getSourceMsg();
      if ((arrayOfByte == null) || (arrayOfByte.length < 560)) {
        break label34;
      }
      paramd.aTv = true;
    }
    label34:
    do
    {
      return false;
      if ((paramBoolean) && (paramd.aTv)) {
        return true;
      }
    } while ((paramBoolean) || (paramd.aTv));
    return true;
  }
  
  public static long[] a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, ujt.d paramd)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " sendMessage start currenttime:" + System.currentTimeMillis());
    }
    if ((paramString == null) || (paramString.length() == 0) || (paramd == null) || (paramSessionInfo == null) || (TextUtils.isEmpty(paramSessionInfo.aTl))) {
      paramQQAppInterface = null;
    }
    do
    {
      return paramQQAppInterface;
      paramContext = a(paramQQAppInterface, paramSessionInfo, paramString, paramArrayList, paramd);
      ThreadManager.post(new ChatActivityFacade.14(paramd, paramQQAppInterface, paramSessionInfo), 8, null, true);
      paramQQAppInterface = paramContext;
    } while (!QLog.isColorLevel());
    QLog.d("SendMsgBtn", 2, " sendMessage end currenttime:" + System.currentTimeMillis());
    return paramContext;
  }
  
  public static long[] a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString)
  {
    ujt.d locald = new ujt.d();
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " sendMessage start currenttime:" + System.currentTimeMillis());
    }
    if ((paramString == null) || (paramString.length() == 0) || (paramSessionInfo == null) || (TextUtils.isEmpty(paramSessionInfo.aTl))) {
      paramQQAppInterface = null;
    }
    do
    {
      return paramQQAppInterface;
      paramString = b(paramQQAppInterface, paramSessionInfo, paramString, null, locald);
      ThreadManager.post(new ChatActivityFacade.13(locald, paramQQAppInterface, paramSessionInfo), 8, null, true);
      paramQQAppInterface = paramString;
    } while (!QLog.isColorLevel());
    QLog.d("SendMsgBtn", 2, " sendMessage end currenttime:" + System.currentTimeMillis());
    return paramString;
  }
  
  public static long[] a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, ujt.d paramd)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " createTextMessageToshow start, currenttime:" + System.currentTimeMillis());
    }
    String str = a(paramString, paramArrayList);
    if (str == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    boolean bool4 = false;
    boolean bool3 = false;
    short s2 = 0;
    Random localRandom = new Random();
    for (;;)
    {
      try
      {
        if (a(paramd, false))
        {
          localObject = b(str, paramArrayList, paramd, localArrayList);
          s1 = s2;
          bool1 = bool3;
          paramArrayList = (ArrayList<MessageForText.AtTroopMemberInfo>)localObject;
          bool2 = bool4;
          paramString = (String)localObject;
        }
        try
        {
          if (QLog.isColorLevel())
          {
            bool2 = bool4;
            paramString = (String)localObject;
            QLog.d("SendMsgBtn", 2, " createTextMessage step 1, partAtInfoArrayLists.size() = " + localArrayList.size() + " mSourceMsgInfo:true, symbolLens:" + str.getBytes("utf-8").length + " currenttime:" + System.currentTimeMillis());
            paramArrayList = (ArrayList<MessageForText.AtTroopMemberInfo>)localObject;
            bool1 = bool3;
            s1 = s2;
          }
          paramString = paramArrayList;
          if (QLog.isColorLevel()) {
            QLog.d("SendMsgBtn", 2, " createTextMessageToshow step 2, currenttime:" + System.currentTimeMillis());
          }
          int j = Math.abs(localRandom.nextInt());
          localObject = new long[paramString.size()];
          int i = 0;
          if (i >= paramString.size()) {
            continue;
          }
          str = (String)paramString.get(i);
          if (localArrayList.size() <= i) {
            continue;
          }
          paramArrayList = (ArrayList)localArrayList.get(i);
          if ((paramSessionInfo.cZ == 3000) || (paramSessionInfo.cZ == 1)) {
            j = Math.abs(localRandom.nextInt());
          }
          localObject[i] = a(paramQQAppInterface, paramSessionInfo, str, -1000, bool1, (byte)paramString.size(), (byte)i, s1, j, paramArrayList, paramd);
          i += 1;
          continue;
          if (!a(paramQQAppInterface, paramSessionInfo, str, paramd)) {
            continue;
          }
          localObject = a(str, paramArrayList, paramd, localArrayList);
          s1 = s2;
          bool1 = bool3;
          paramArrayList = (ArrayList<MessageForText.AtTroopMemberInfo>)localObject;
          bool2 = bool4;
          paramString = (String)localObject;
          if (!QLog.isColorLevel()) {
            continue;
          }
          bool2 = bool4;
          paramString = (String)localObject;
          QLog.d("SendMsgBtn", 2, " createTextMessageToshow step 1, partAtInfoArrayLists.size() = " + localArrayList.size() + " isLongTextMsg:true, symbolLens:" + str.getBytes("utf-8").length + " currenttime:" + System.currentTimeMillis());
          s1 = s2;
          bool1 = bool3;
          paramArrayList = (ArrayList<MessageForText.AtTroopMemberInfo>)localObject;
          continue;
          paramArrayList.printStackTrace();
        }
        catch (UnsupportedEncodingException paramArrayList)
        {
          bool1 = bool2;
        }
      }
      catch (UnsupportedEncodingException paramArrayList)
      {
        Object localObject;
        short s1;
        boolean bool2;
        boolean bool1 = false;
        paramString = null;
        continue;
      }
      s1 = 0;
      continue;
      paramArrayList = aqft.a(str, 560, 20, paramArrayList, localArrayList);
      bool2 = bool4;
      paramString = paramArrayList;
      if (paramArrayList.size() > 1)
      {
        bool1 = true;
        bool2 = bool1;
        paramString = paramArrayList;
        if (QLog.isColorLevel())
        {
          bool2 = bool1;
          paramString = paramArrayList;
          QLog.d("SendMsgBtn", 2, " createTextMessageToshow step 1, partAtInfoArrayLists.size() = " + localArrayList.size() + " partArray.size() = " + paramArrayList.size() + " isDivide = " + bool1 + " currenttime:" + System.currentTimeMillis());
        }
        bool2 = bool1;
        paramString = paramArrayList;
        s1 = a(paramQQAppInterface, paramSessionInfo, bool1, (short)0, localRandom);
      }
      else
      {
        bool1 = false;
        continue;
        paramArrayList = null;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " createTextMessageToshow step 3, currenttime:" + System.currentTimeMillis());
    }
    return localObject;
  }
  
  private static long b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChatActivityFacade.QZoneFeeds", 2, "getLastFeedsPublishTimeV2   start");
    }
    BeancurdMsg localBeancurdMsg = ((wkh)paramQQAppInterface.getManager(282)).a(paramSessionInfo.aTl, paramSessionInfo.cZ, 2);
    long l1;
    if (localBeancurdMsg != null) {
      try
      {
        l1 = new JSONObject(localBeancurdMsg.buffer).optLong("time", 0L);
        l2 = l1;
        if (l1 == 0L) {
          l2 = c(paramQQAppInterface, paramSessionInfo);
        }
        return l2;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          QLog.e("ChatActivityFacade.QZoneFeeds", 1, "", localJSONException);
          l1 = 0L;
        }
      }
    }
    Object localObject = paramQQAppInterface.b().b(paramSessionInfo.aTl, 0, new int[] { -2015 });
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (MessageForQzoneFeed)((List)localObject).get(((List)localObject).size() - 1);
      if (localObject != null) {
        ((MessageForQzoneFeed)localObject).parse();
      }
    }
    for (long l2 = ((MessageForQzoneFeed)localObject).feedTime;; l2 = 0L)
    {
      l1 = l2;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("ChatActivityFacade.QZoneFeeds", 2, "getLastFeedsPublishTimeV2   没有qzone历史豆腐块,sessionInfo.curFriendUin=" + paramSessionInfo.aTl + ",sessionInfo.curType=" + paramSessionInfo.cZ + " busiID=" + 2);
      l1 = l2;
      break;
    }
  }
  
  public static long b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString)
  {
    MessageForPtt localMessageForPtt = (MessageForPtt)a(paramQQAppInterface, paramString, paramSessionInfo, -3, 0);
    long l1 = 0L;
    if (localMessageForPtt != null)
    {
      long l2 = localMessageForPtt.uniseq;
      l1 = l2;
      if (l2 != -1L)
      {
        int i = QQRecorder.n(localMessageForPtt);
        int j = aqlv.fj(paramString);
        Bundle localBundle = new Bundle();
        localBundle.putInt("DiyTextId", localMessageForPtt.vipBubbleDiyTextId);
        a(paramQQAppInterface, paramSessionInfo.cZ, paramSessionInfo.aTl, paramString, l2, true, i * 1000, j, true, 0, 0, true, localMessageForPtt.vipSubBubbleId, localBundle);
        l1 = l2;
      }
    }
    return l1;
  }
  
  public static MessageRecord b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (top.fv(paramSessionInfo.cZ))
    {
      List localList = paramQQAppInterface.b().k(paramSessionInfo.aTl, paramSessionInfo.cZ);
      if ((localList != null) && (!localList.isEmpty()))
      {
        int i = localList.size() - 1;
        while (i >= 0)
        {
          paramSessionInfo = (MessageRecord)localList.get(i);
          if (!aqiu.mt(paramSessionInfo.issend))
          {
            paramQQAppInterface = paramSessionInfo;
            if (paramSessionInfo.msgtype != -1034) {
              return paramQQAppInterface;
            }
          }
          i -= 1;
        }
      }
    }
    paramQQAppInterface = null;
    return paramQQAppInterface;
  }
  
  private static String b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    throws JSONException
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("id", paramString1);
    localJSONObject2.put("name", paramString2);
    localJSONObject2.put("address", paramString3);
    localJSONObject2.put("lat", paramString4);
    localJSONObject2.put("lng", paramString5);
    localJSONObject2.put("from", "plusPanel");
    localJSONObject1.put("Location.Search", localJSONObject2);
    return localJSONObject1.toString();
  }
  
  private static ArrayList<String> b(String paramString, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, ujt.d paramd, ArrayList<ArrayList<MessageForText.AtTroopMemberInfo>> paramArrayList1)
  {
    paramd = new ArrayList();
    paramd.add(paramString);
    paramArrayList1.add(paramArrayList);
    return paramd;
  }
  
  public static void b(Context paramContext, QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    paramQQAppInterface = new ChatActivityFacade.16(paramContext, paramChatMessage, paramQQAppInterface);
    paramChatMessage = (InputMethodManager)paramContext.getSystemService("input_method");
    boolean bool = paramChatMessage.isActive();
    if (((paramContext instanceof Activity)) && (bool)) {
      paramChatMessage.hideSoftInputFromWindow(((Activity)paramContext).getWindow().getDecorView().getWindowToken(), 0);
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        new Handler(paramContext.getMainLooper()).postDelayed(paramQQAppInterface, 60L);
        return;
      }
      paramQQAppInterface.run();
      return;
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    if (!ChatActivityUtils.e(paramQQAppInterface, paramSessionInfo)) {}
    label8:
    int i;
    do
    {
      break label8;
      do
      {
        return;
      } while (1024 == paramSessionInfo.cZ);
      i = ((CardHandler)paramQQAppInterface.getBusinessHandler(2)).Ah();
      if (QLog.isDevelopLevel()) {
        QLog.d("ChatActivityFacade", 4, "single way add allow insert " + paramSessionInfo.aTl + " settingValue:" + i);
      }
    } while ((i != 0) && (i != 3));
    String str;
    if (i == 0)
    {
      i = -7006;
      str = "single_way_friend_add_allow_list";
      label99:
      if (ChatActivityUtils.a(paramContext, paramSessionInfo, str)) {
        break label303;
      }
      Iterator localIterator = paramQQAppInterface.b().k(paramSessionInfo.aTl, 0).iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (((MessageRecord)localIterator.next()).msgtype != i);
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("ChatActivityFacade", 4, "single way add allow insert " + paramSessionInfo.aTl + " hasInserted:" + bool);
      }
      if (bool) {
        break;
      }
      ChatActivityUtils.b(paramContext, paramSessionInfo, str);
      paramContext = (MessageForGrayTips)anbi.d(i);
      long l = anaz.gQ() + 1L;
      paramContext.init(paramQQAppInterface.getCurrentAccountUin(), paramSessionInfo.aTl, paramSessionInfo.aTl, "", l, i, paramSessionInfo.cZ, l);
      paramContext.setTextGravity(17);
      paramContext.isread = true;
      if (achp.a(paramQQAppInterface, paramContext, false)) {
        break;
      }
      paramQQAppInterface.b().b(paramContext, paramContext.selfuin);
      return;
      i = -2019;
      str = "single_way_friend_list";
      break label99;
      label303:
      break label8;
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, int paramInt, String paramString1, String paramString2)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramInt, -1, paramString1, paramString2, 2);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, long paramLong)
  {
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      ChatActivityUtils.h(paramContext, 2131693404, 0);
      return;
    }
    MessageRecord localMessageRecord = paramQQAppInterface.b().a(paramSessionInfo.aTl, paramSessionInfo.cZ, paramLong);
    if (localMessageRecord == null)
    {
      ChatActivityUtils.h(paramContext, 2131719483, 0);
      return;
    }
    paramQQAppInterface.b().t(paramSessionInfo.aTl, paramSessionInfo.cZ, paramLong);
    paramContext = anbi.e(localMessageRecord);
    paramQQAppInterface.b().a(paramContext, null, true);
  }
  
  private static void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if ((paramQQAppInterface == null) || (paramSessionInfo == null)) {
      return;
    }
    Object localObject = paramQQAppInterface.b().b(paramSessionInfo.aTl, 0, new int[] { -2015 });
    label48:
    int j;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      int i = 0;
      j = i;
      if (!((Iterator)localObject).hasNext()) {
        break label165;
      }
      MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
      if ((localMessageRecord == null) || (!(localMessageRecord instanceof MessageForQzoneFeed)) || (!((MessageForQzoneFeed)localMessageRecord).isOldStructMsg)) {
        break label175;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivityFacade.QZoneFeeds", 2, "删除老结构的feeds");
      }
      paramQQAppInterface.b().a(localMessageRecord.frienduin, 0, localMessageRecord.msgtype, localMessageRecord.uniseq);
      paramQQAppInterface.b().t(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
      i = 1;
    }
    label165:
    label175:
    for (;;)
    {
      break label48;
      j = 0;
      if (j == 0) {
        break;
      }
      c(paramQQAppInterface, paramSessionInfo);
      return;
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString)
  {
    a(paramQQAppInterface, paramSessionInfo, paramString, 1010, false, (byte)1, (byte)0, (short)0, Math.abs(new Random().nextInt()), null, new ujt.d());
  }
  
  @TargetApi(9)
  public static void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      QLog.e("ChatActivityFacade", 1, "insertRenewalTailTipMsgIfNeeded app == null");
    }
    int i;
    do
    {
      do
      {
        return;
        i = paramSessionInfo.cZ;
      } while ((i != 0) && (i != 1) && (i != 3000) && (i != 1001) && (i != 10002) && (i != 10004) && (i != 1006) && (i != 1004) && (i != 1000) && (i != 3));
      localObject1 = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 4);
      if (!paramBoolean)
      {
        long l = ((SharedPreferences)localObject1).getLong("last_pull_individual_expire_info_time", 0L);
        if (System.currentTimeMillis() - l > 86400000L) {
          break;
        }
      }
      i = ((SharedPreferences)localObject1).getInt("renewal_tail_tip_exit", 0);
    } while (i == 0);
    Object localObject2 = ((SharedPreferences)localObject1).getString("renewal_tail_tip", "");
    Object localObject1 = ((SharedPreferences)localObject1).edit();
    ((SharedPreferences.Editor)localObject1).putInt("renewal_tail_tip_exit", 0);
    if (Build.VERSION.SDK_INT <= 8) {
      ((SharedPreferences.Editor)localObject1).commit();
    }
    for (;;)
    {
      top.a(paramQQAppInterface, paramSessionInfo.aTl, paramSessionInfo.cZ, -4020);
      paramQQAppInterface.a().a(paramSessionInfo.aTl, paramQQAppInterface.getCurrentAccountUin(), paramSessionInfo.cZ, -4020, (String)localObject2);
      VasWebviewUtil.reportCommercialDrainage(paramSessionInfo.aTl, "aio_pay", "aio_show", "", 1, 0, 0, "", String.valueOf(i), "");
      return;
      localObject2 = (aqrb)paramQQAppInterface.getBusinessHandler(71);
      if (localObject2 == null) {
        break;
      }
      ((aqrb)localObject2).XN(1);
      if (Build.VERSION.SDK_INT <= 8)
      {
        ((SharedPreferences)localObject1).edit().putLong("last_pull_individual_expire_info_time", System.currentTimeMillis()).commit();
        return;
      }
      ((SharedPreferences)localObject1).edit().putLong("last_pull_individual_expire_info_time", System.currentTimeMillis()).apply();
      return;
      ((SharedPreferences.Editor)localObject1).apply();
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    paramQQAppInterface.b().t(paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage.uniseq);
    if (paramChatMessage.isSendFromLocal()) {
      paramQQAppInterface.a().oy(paramQQAppInterface.a().y(paramChatMessage.frienduin, paramChatMessage.uniseq));
    }
  }
  
  private static boolean b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    boolean bool = true;
    if ((paramQQAppInterface == null) || (paramQQAppInterface.getApp() == null) || (paramSessionInfo == null)) {
      bool = false;
    }
    long l1;
    long l2;
    do
    {
      return bool;
      l1 = a(paramQQAppInterface, paramSessionInfo, "key_last_req_aio_feeds_time");
      l1 = NetConnInfoCenter.getServerTimeMillis() - l1;
      l2 = QzoneConfig.getInstance().getConfig("QZoneSetting", "requestAIOFeedsDiv", 900000);
      if (l1 <= l2) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ChatActivityFacade.QZoneFeeds", 2, String.format("与上一次请求间隔%d ms  大于等于 下发配置：%d ms,将返回true，可以进行请求", new Object[] { Long.valueOf(l1), Long.valueOf(l2) }));
    return true;
    if (QLog.isColorLevel()) {
      QLog.i("ChatActivityFacade.QZoneFeeds", 2, String.format("与上一次请求间隔%d ms  小于 下发配置：%d ms,将返回false，触发了频率控制，不可以进行请求", new Object[] { Long.valueOf(l1), Long.valueOf(l2) }));
    }
    return false;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ArkAppMessage paramArkAppMessage)
  {
    return a(paramQQAppInterface, paramSessionInfo, paramArkAppMessage, 0);
  }
  
  private static boolean b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (paramSessionInfo == null)) {}
    while (avpw.aLk()) {
      return false;
    }
    if (paramBoolean) {
      return c(paramQQAppInterface, paramSessionInfo);
    }
    return true;
  }
  
  public static long[] b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, ujt.d paramd)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " createTextMessageToshow start, currenttime:" + System.currentTimeMillis());
    }
    String str = a(paramString, paramArrayList);
    if (str == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    boolean bool4 = false;
    boolean bool3 = false;
    short s2 = 0;
    Random localRandom = new Random();
    for (;;)
    {
      try
      {
        if (a(paramd, false))
        {
          localObject = b(str, paramArrayList, paramd, localArrayList);
          s1 = s2;
          bool1 = bool3;
          paramArrayList = (ArrayList<MessageForText.AtTroopMemberInfo>)localObject;
          bool2 = bool4;
          paramString = (String)localObject;
        }
        try
        {
          if (QLog.isColorLevel())
          {
            bool2 = bool4;
            paramString = (String)localObject;
            QLog.d("SendMsgBtn", 2, " createTextMessage step 1, partAtInfoArrayLists.size() = " + localArrayList.size() + " mSourceMsgInfo:true, symbolLens:" + str.getBytes("utf-8").length + " currenttime:" + System.currentTimeMillis());
            paramArrayList = (ArrayList<MessageForText.AtTroopMemberInfo>)localObject;
            bool1 = bool3;
            s1 = s2;
          }
          paramString = paramArrayList;
          if (QLog.isColorLevel()) {
            QLog.d("SendMsgBtn", 2, " createTextMessageToshow step 2, currenttime:" + System.currentTimeMillis());
          }
          int j = Math.abs(localRandom.nextInt());
          localObject = new long[paramString.size()];
          int i = 0;
          if (i >= paramString.size()) {
            continue;
          }
          str = (String)paramString.get(i);
          if (localArrayList.size() <= i) {
            continue;
          }
          paramArrayList = (ArrayList)localArrayList.get(i);
          if ((paramSessionInfo.cZ == 3000) || (paramSessionInfo.cZ == 1)) {
            j = Math.abs(localRandom.nextInt());
          }
          localObject[i] = a(paramQQAppInterface, paramSessionInfo, str, -1000, bool1, (byte)paramString.size(), (byte)i, s1, j, paramArrayList, paramd, true);
          i += 1;
          continue;
          if (!a(paramQQAppInterface, paramSessionInfo, str, paramd)) {
            continue;
          }
          localObject = a(str, paramArrayList, paramd, localArrayList);
          s1 = s2;
          bool1 = bool3;
          paramArrayList = (ArrayList<MessageForText.AtTroopMemberInfo>)localObject;
          bool2 = bool4;
          paramString = (String)localObject;
          if (!QLog.isColorLevel()) {
            continue;
          }
          bool2 = bool4;
          paramString = (String)localObject;
          QLog.d("SendMsgBtn", 2, " createTextMessageToshow step 1, partAtInfoArrayLists.size() = " + localArrayList.size() + " isLongTextMsg:true, symbolLens:" + str.getBytes("utf-8").length + " currenttime:" + System.currentTimeMillis());
          s1 = s2;
          bool1 = bool3;
          paramArrayList = (ArrayList<MessageForText.AtTroopMemberInfo>)localObject;
          continue;
          paramArrayList.printStackTrace();
        }
        catch (UnsupportedEncodingException paramArrayList)
        {
          bool1 = bool2;
        }
      }
      catch (UnsupportedEncodingException paramArrayList)
      {
        Object localObject;
        short s1;
        boolean bool2;
        boolean bool1 = false;
        paramString = null;
        continue;
      }
      s1 = 0;
      continue;
      paramArrayList = aqft.a(str, 560, 20, paramArrayList, localArrayList);
      bool2 = bool4;
      paramString = paramArrayList;
      if (paramArrayList.size() > 1)
      {
        bool1 = true;
        bool2 = bool1;
        paramString = paramArrayList;
        if (QLog.isColorLevel())
        {
          bool2 = bool1;
          paramString = paramArrayList;
          QLog.d("SendMsgBtn", 2, " createTextMessageToshow step 1, partAtInfoArrayLists.size() = " + localArrayList.size() + " partArray.size() = " + paramArrayList.size() + " isDivide = " + bool1 + " currenttime:" + System.currentTimeMillis());
        }
        bool2 = bool1;
        paramString = paramArrayList;
        s1 = a(paramQQAppInterface, paramSessionInfo, bool1, (short)0, localRandom);
      }
      else
      {
        bool1 = false;
        continue;
        paramArrayList = null;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " createTextMessageToshow step 3, currenttime:" + System.currentTimeMillis());
    }
    return localObject;
  }
  
  public static void bJq()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityFacade", 2, "go to dismissActionSheet()!");
    }
    if ((T != null) && (T.isShowing())) {}
    try
    {
      T.dismiss();
      T = null;
      if ((U == null) || (!U.isShowing())) {}
    }
    catch (Exception localException1)
    {
      try
      {
        U.dismiss();
        U = null;
        return;
        localException1 = localException1;
        localException1.printStackTrace();
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
        }
      }
    }
  }
  
  private static long c(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    paramQQAppInterface = paramQQAppInterface.b().b(paramSessionInfo.aTl, 0, new int[] { -2015 });
    if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
    {
      paramQQAppInterface = (MessageRecord)paramQQAppInterface.get(0);
      if ((paramQQAppInterface != null) && ((paramQQAppInterface instanceof MessageForQzoneFeed)))
      {
        paramSessionInfo = (MessageForQzoneFeed)paramQQAppInterface;
        paramSessionInfo.parse();
        if (QLog.isColorLevel()) {
          QLog.w("ChatActivityFacade.QZoneFeeds", 2, "获取到最新空间feeds的：" + String.valueOf(paramQQAppInterface) + "：feeds json:" + paramSessionInfo.feedMsg);
        }
        return paramSessionInfo.feedTime;
      }
      if (QLog.isColorLevel()) {
        QLog.w("ChatActivityFacade.QZoneFeeds", 2, "message record 有误:" + String.valueOf(paramQQAppInterface));
      }
    }
    for (;;)
    {
      return 0L;
      if (QLog.isColorLevel()) {
        QLog.w("ChatActivityFacade.QZoneFeeds", 2, "message recode 为空，无法获取发布时间");
      }
    }
  }
  
  public static void c(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    int i = amzo.seq;
    amzo.seq = i + 1;
    long l = i;
    String str = paramQQAppInterface.getCurrentAccountUin();
    paramSessionInfo = anbi.a(str, paramSessionInfo.aTl, str, paramSessionInfo.cZ, l);
    paramQQAppInterface.b().a(paramSessionInfo, null);
    if (((paramContext instanceof SplashActivity)) || ((paramContext instanceof ChatActivity))) {
      ((FragmentActivity)paramContext).getChatFragment().a().a(paramSessionInfo);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.shakemsg", 2, "create new shake message,shmsgseq is:" + paramSessionInfo.shmsgseq + ",msgUid is:" + paramSessionInfo.msgUid + ",time is:" + System.currentTimeMillis());
    }
  }
  
  public static void c(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, long paramLong)
  {
    paramContext = paramQQAppInterface.b().a(paramSessionInfo.aTl, paramSessionInfo.cZ, paramLong);
    if (paramContext != null)
    {
      paramQQAppInterface.b().t(paramSessionInfo.aTl, paramSessionInfo.cZ, paramLong);
      paramContext = anbi.e(paramContext);
      paramQQAppInterface.b().a(paramContext, null, true);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ChatActivityFacade", 2, "resendApolloMessage : mr is null.");
  }
  
  private static void c(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if ((paramQQAppInterface == null) || (paramQQAppInterface.getApp() == null) || (paramSessionInfo == null)) {
      return;
    }
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("qzone_sp_in_qq", 0);
    paramQQAppInterface = a(paramQQAppInterface, paramSessionInfo, "key_last_req_aio_feeds_time");
    localSharedPreferences.edit().remove(paramQQAppInterface).apply();
  }
  
  public static void c(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    FileManagerEntity localFileManagerEntity;
    if ((paramChatMessage instanceof MessageForFile))
    {
      localFileManagerEntity = paramQQAppInterface.a().a(paramChatMessage.uniseq, paramChatMessage.frienduin, paramChatMessage.istroop);
      if ((localFileManagerEntity == null) && (QLog.isColorLevel())) {
        QLog.w("ChatActivityFacade", 2, "why FileManagerEntity is null?! may be is old data!");
      }
      if (paramChatMessage.isSendFromLocal()) {
        paramQQAppInterface.a().oy(paramQQAppInterface.a().y(paramChatMessage.frienduin, paramChatMessage.uniseq));
      }
      if (localFileManagerEntity != null)
      {
        if (localFileManagerEntity.getCloudType() != 0) {
          break label139;
        }
        paramQQAppInterface.a().js(localFileManagerEntity.nSessionId);
        paramQQAppInterface.a().l(localFileManagerEntity);
        if (localFileManagerEntity.getCloudType() == 0) {
          paramQQAppInterface.a().ju(localFileManagerEntity.nSessionId);
        }
        paramQQAppInterface.a().ca(localFileManagerEntity.nSessionId);
      }
    }
    label139:
    do
    {
      return;
      paramQQAppInterface.a().cc(localFileManagerEntity.nSessionId);
      break;
      if ((paramChatMessage instanceof MessageForDevShortVideo))
      {
        ((DeviceFileHandler)paramQQAppInterface.getBusinessHandler(50)).g(0, ((MessageForDevShortVideo)paramChatMessage).fileSessionId, false);
        return;
      }
    } while (!(paramChatMessage instanceof MessageForDevPtt));
    ((DeviceFileHandler)paramQQAppInterface.getBusinessHandler(50)).g(0, ((MessageForDevPtt)paramChatMessage).fileSessionId, false);
  }
  
  private static boolean c(SessionInfo paramSessionInfo)
  {
    int i = paramSessionInfo.cZ;
    return (i == 0) || (i == 3000) || (i == 1);
  }
  
  private static boolean c(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    boolean bool = true;
    if ((paramQQAppInterface == null) || (paramQQAppInterface.getApp() == null) || (paramSessionInfo == null)) {
      bool = false;
    }
    long l;
    do
    {
      return bool;
      l = a(paramQQAppInterface, paramSessionInfo, "key_last_req_aio_story_feed_time");
      l = NetConnInfoCenter.getServerTimeMillis() - l;
      if (l <= 900000L) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ChatActivityFacade.QZoneFeeds", 2, String.format("Story与上一次请求间隔%d ms  大于等于 下发配置：%d ms,将返回true，可以进行请求", new Object[] { Long.valueOf(l), Long.valueOf(900000L) }));
    return true;
    if (QLog.isColorLevel()) {
      QLog.i("ChatActivityFacade.QZoneFeeds", 2, String.format("Story与上一次请求间隔%d ms  小于 下发配置：%d ms,将返回false，触发了频率控制，不可以进行请求", new Object[] { Long.valueOf(l), Long.valueOf(900000L) }));
    }
    return false;
  }
  
  public static void d(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, 1, -1, "", "", 0);
  }
  
  public static void d(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString)
  {
    ujt.d locald = new ujt.d();
    locald.aTs = false;
    locald.aTt = true;
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramString, null, locald);
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.nearby_bank", 4, "AIO---sendShowLoveMessage");
    }
    anot.a(paramQQAppInterface, "CliOper", "", "", "0X80052A5", "0X80052A5", 0, 0, "", "", "", "");
  }
  
  public static void d(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    MessageRecord localMessageRecord = anbi.d(-4005);
    long l = anaz.gQ();
    localMessageRecord.init(paramQQAppInterface.getCurrentAccountUin(), paramSessionInfo.aTl, paramSessionInfo.aTl, BaseApplicationImpl.getContext().getString(2131695714), l, -4005, paramSessionInfo.cZ, l);
    localMessageRecord.isread = true;
    if (!achp.a(paramQQAppInterface, localMessageRecord, false)) {
      paramQQAppInterface.b().b(localMessageRecord, localMessageRecord.selfuin);
    }
  }
  
  public static void e(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramString, null, new ujt.d());
  }
  
  private static void e(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    paramSessionInfo = paramQQAppInterface.b().b(paramSessionInfo.aTl, 0, new int[] { -2015 });
    if (paramSessionInfo != null)
    {
      paramSessionInfo = paramSessionInfo.iterator();
      while (paramSessionInfo.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramSessionInfo.next();
        if (localMessageRecord != null)
        {
          paramQQAppInterface.b().a(localMessageRecord.frienduin, 0, localMessageRecord.msgtype, localMessageRecord.uniseq);
          paramQQAppInterface.b().t(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
          aqmj.t(paramQQAppInterface.getCurrentUin(), localMessageRecord.frienduin, 0L);
        }
      }
    }
  }
  
  private static void f(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    ((wkh)paramQQAppInterface.getManager(282)).Q(paramSessionInfo.aTl, paramSessionInfo.cZ, 2);
    e(paramQQAppInterface, paramSessionInfo);
  }
  
  public static void fD(List<ChatMessage> paramList)
  {
    if ((d != null) && (paramList != null) && (paramList.size() > 0))
    {
      if (!((ChatMessage)paramList.get(0)).isLongMsg()) {
        break label120;
      }
      Iterator localIterator = paramList.iterator();
      ChatMessage localChatMessage;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localChatMessage = (ChatMessage)localIterator.next();
      } while ((localChatMessage.shmsgseq != d.shmsgseq) || (localChatMessage.msgUid != d.msgUid));
    }
    label120:
    for (int i = 1;; i = 0)
    {
      if (((i != 0) || (paramList.contains(d))) && (T != null)) {
        T.dismiss();
      }
      return;
    }
  }
  
  public static void fE(List<ChatMessage> paramList)
  {
    if ((qn != null) && (paramList != null) && (paramList.size() > 0) && (qn.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ChatMessage localChatMessage1 = (ChatMessage)paramList.next();
        if (qn.contains(localChatMessage1))
        {
          qn.remove(localChatMessage1);
        }
        else if (localChatMessage1.isLongMsg())
        {
          Iterator localIterator = qn.iterator();
          while (localIterator.hasNext())
          {
            ChatMessage localChatMessage2 = (ChatMessage)localIterator.next();
            if ((localChatMessage2.shmsgseq == localChatMessage1.shmsgseq) && (localChatMessage2.msgUid == localChatMessage1.msgUid)) {
              localIterator.remove();
            }
          }
        }
      }
      if ((qn.size() == 0) && (U != null)) {
        U.dismiss();
      }
    }
  }
  
  private static void g(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    QLog.i("ChatActivityFacade.QZoneStoryFeeds", 2, "hasNewFlag == 1,且storyFeeds.size =0 ,视为后台让客户端，需要清理本地缓存");
    ((wkh)paramQQAppInterface.getManager(282)).Q(paramSessionInfo.aTl, paramSessionInfo.cZ, 7);
    Object localObject = paramQQAppInterface.b().b(paramSessionInfo.aTl, 0, new int[] { -2074 });
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if (localMessageRecord != null)
        {
          paramQQAppInterface.b().a(localMessageRecord.frienduin, 0, localMessageRecord.msgtype, localMessageRecord.uniseq);
          paramQQAppInterface.b().t(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
        }
      }
    }
    a(paramQQAppInterface, paramSessionInfo, 0L);
  }
  
  public static void h(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    Object localObject1 = new EventItem(18, null);
    ((EventItem)localObject1).eventType = 538052865;
    Object localObject2 = new JceOutputStream();
    ((JceOutputStream)localObject2).setServerEncoding("utf-8");
    ((EventItem)localObject1).writeTo((JceOutputStream)localObject2);
    localObject1 = new String(((JceOutputStream)localObject2).toByteArray());
    localObject2 = paramQQAppInterface.a();
    paramSessionInfo = paramSessionInfo.aTl;
    paramQQAppInterface = paramQQAppInterface.getCurrentNickname();
    int i = amzo.seq;
    amzo.seq = i + 1;
    ((MessageHandler)localObject2).a(paramSessionInfo, (String)localObject1, (byte)18, paramQQAppInterface, i, -1L);
  }
  
  @TargetApi(9)
  private static boolean o(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramQQAppInterface == null)) {
      return false;
    }
    EmoticonPackage localEmoticonPackage = ((ajdg)paramQQAppInterface.getManager(14)).b(paramString);
    if ((localEmoticonPackage == null) || ((localEmoticonPackage.extraFlags & 0x1) <= 0)) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityFacade", 2, "isShowEmotionRewordTips epId = " + paramString);
    }
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("originalEmotionCountSp_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    int i = paramQQAppInterface.getInt(paramString, 0) + 1;
    paramQQAppInterface = paramQQAppInterface.edit();
    paramQQAppInterface.putInt(paramString, i);
    if (Build.VERSION.SDK_INT <= 8) {
      paramQQAppInterface.commit();
    }
    while (i == 21)
    {
      return true;
      paramQQAppInterface.apply();
    }
    return false;
  }
  
  public static class a
  {
    public long FA;
    public long FB;
    public long FC;
    public int bEU;
    public int bEV;
    public byte[] bY;
  }
  
  public static class b
    extends akln
  {
    public WeakReference<QQAppInterface> bV;
    public SessionInfo sessionInfo;
    
    protected void t(boolean paramBoolean, Bundle paramBundle)
    {
      if (this.bV == null) {
        if (QLog.isColorLevel()) {
          QLog.i("UndealCount.QZoneObserver.QZoneStoryFeeds", 2, "onGetQZoneNewestStoryFeed appRef==null");
        }
      }
      QQAppInterface localQQAppInterface;
      do
      {
        return;
        localQQAppInterface = (QQAppInterface)this.bV.get();
        if ((localQQAppInterface != null) && (this.sessionInfo != null)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("UndealCount.QZoneObserver.QZoneStoryFeeds", 2, "onGetQZoneNewestStoryFeed app == null || sessionInfo == nul");
      return;
      if (paramBoolean) {}
      try
      {
        paramBundle = (FromServiceMsg)paramBundle.getParcelable("KEY_FOR_AIO_STORY_FEED_DATA");
        if (paramBundle != null)
        {
          paramBundle = rxe.a(aqnv.J(paramBundle.getWupBuffer()));
          if (paramBundle != null) {
            ujt.b(localQQAppInterface, this.sessionInfo, paramBundle);
          }
        }
        this.sessionInfo = null;
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.e("UndealCount.QZoneObserver", 1, "call onGetNewestStoryFeed exception " + paramBundle);
      }
    }
  }
  
  public static class c
    extends akln
  {
    public boolean aTr;
    public WeakReference<QQAppInterface> bV;
    public SessionInfo sessionInfo;
    
    protected void u(boolean paramBoolean, Bundle paramBundle)
    {
      if (this.bV == null) {
        if (QLog.isColorLevel()) {
          QLog.i("UndealCount.QZoneObserver.QZoneFeeds", 2, "onGetQZoneNewestFeed appRef==null");
        }
      }
      QQAppInterface localQQAppInterface;
      do
      {
        return;
        localQQAppInterface = (QQAppInterface)this.bV.get();
        if ((localQQAppInterface != null) && (this.sessionInfo != null)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("UndealCount.QZoneObserver.QZoneFeeds", 2, "onGetQZoneNewestFeed app == null || sessionInfo == nul");
      return;
      paramBundle = paramBundle.getSerializable("data");
      if ((paramBoolean) && (paramBundle != null) && ((paramBundle instanceof AIONewestFeedRsp))) {
        ujt.b(localQQAppInterface, this.sessionInfo, (AIONewestFeedRsp)paramBundle, this.aTr);
      }
      paramBundle = (c)ujt.k().get(this.sessionInfo.aTl);
      ujt.k().remove(this.sessionInfo.aTl);
      localQQAppInterface.unRegistObserver(paramBundle);
      this.sessionInfo = null;
    }
  }
  
  public static class d
  {
    public long FD;
    public String aLN;
    public String aLO;
    public String aLP;
    public String aLQ;
    public boolean aSL;
    public boolean aTs = true;
    public boolean aTt;
    public boolean aTu;
    public boolean aTv;
    public boolean aTw;
    public boolean aTx;
    public boolean aTy;
    public int bEW;
    public int bEX = -1;
    public int barrageSourceMsgType;
    public long barrageTimeLocation;
    public boolean isBarrageMsg;
    public boolean mIsMsgSignalOpen;
    public long mMsgSendTime;
    public int mMsgSignalCount;
    public int mMsgSignalNetType;
    public int mMsgSignalSum;
    public int mPasswdRedBagFlag;
    public long mPasswdRedBagSender;
    public MessageForReplyText.SourceMsgInfo mSourceMsgInfo;
    public long mWantGiftSenderUin;
    public EmojiStickerManager.StickerInfo stickerInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ujt
 * JD-Core Version:    0.7.0.1
 */