package com.tencent.mobileqq.emoticon;

import acbn;
import acfp;
import aczw;
import afgc;
import afhs;
import afhu;
import afhv;
import afim;
import afkl;
import afmi;
import afnu;
import afqh;
import afqm;
import afqr;
import ahwa;
import ajdg;
import anaz;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import anot;
import aoff;
import aofk;
import aqgv;
import auts;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.CustomEmotionBase;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.data.QQWalletTransferMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.mobileqq.data.VipComicFavorEmoStructMsgInfo;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.io.File;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashMap<Landroid.util.Pair<Ljava.lang.Long;Ljava.lang.Long;>;Ljava.util.List<Lcom.tencent.mobileqq.data.ChatMessage;>;>;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import tog;
import ton;
import top;
import wki;
import xtj;

public class EmojiStickerManager
{
  public static View BM;
  public static int DISMISS;
  public static int DISPLAY;
  public static long Xz;
  private static final EmojiStickerManager a = new EmojiStickerManager();
  public static String bDL;
  public static boolean bYA;
  public static boolean bYB;
  public static boolean bYC;
  public static boolean bYD;
  public static boolean bYE;
  public static boolean bYF;
  public static boolean bYG;
  public static boolean bYH;
  public static int cRA;
  public static int cRB;
  public static int cRC;
  public static int cRD;
  public static int cRE;
  public static int cRF;
  public static int cRy = 5;
  public static int cRz = 1;
  public static float wa;
  public long Xw = -9223372036854775808L;
  public long Xx = -9223372036854775808L;
  public long Xy = -9223372036854775808L;
  public String bDK = "";
  public int bGd = -2147483648;
  private Drawable eC;
  public ConcurrentHashMap<Pair<Long, Long>, ArrayList<Long>> fj = new ConcurrentHashMap();
  public ConcurrentHashMap<String, Long> fk = new ConcurrentHashMap();
  private ColorDrawable i = new ColorDrawable();
  public int mCurType;
  public LRULinkedHashMap<Pair<Long, Long>, ArrayList<Long>> q = new LRULinkedHashMap(64);
  public LRULinkedHashMap<Pair<Long, Long>, Boolean> r = new LRULinkedHashMap(64);
  public ArrayList<Bundle> wg = new ArrayList();
  public List<MessageRecord> zO = new ArrayList();
  
  static
  {
    cRA = cRy;
    cRB = cRy;
    DISMISS = 1;
    cRC = 20;
    cRD = 10;
    wa = 0.01F;
    bDL = "";
    cRF = -1;
  }
  
  private void Q(ChatMessage paramChatMessage)
  {
    if (!paramChatMessage.isread)
    {
      if ((this.mCurType != 0) || (paramChatMessage.time <= this.Xx)) {
        break label35;
      }
      this.Xx = paramChatMessage.time;
    }
    label35:
    while (paramChatMessage.shmsgseq <= this.Xx) {
      return;
    }
    this.Xx = paramChatMessage.shmsgseq;
  }
  
  private static int a(QQAppInterface paramQQAppInterface, String paramString, StructMsgForImageShare paramStructMsgForImageShare, PicMessageExtraData paramPicMessageExtraData)
  {
    String str = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
    afhu localafhu = (afhu)paramQQAppInterface.getManager(149);
    Object localObject = localafhu.ez();
    int j;
    if (localObject != null)
    {
      j = 1;
      int n = 0;
      int k = 0;
      while (k < ((List)localObject).size())
      {
        int m;
        if (!TextUtils.isEmpty(((CustomEmotionData)((List)localObject).get(k)).RomaingType))
        {
          m = n;
          if ("needDel".equals(((CustomEmotionData)((List)localObject).get(k)).RomaingType)) {}
        }
        else
        {
          m = n + 1;
        }
        n = ((CustomEmotionData)((List)localObject).get(k)).emoId;
        if ((paramString != null) && (paramString.equals(((CustomEmotionData)((List)localObject).get(k)).emoPath)))
        {
          a(paramQQAppInterface, paramStructMsgForImageShare, (CustomEmotionData)((List)localObject).get(k));
          return 2;
        }
        if ((str != null) && (((CustomEmotionData)((List)localObject).get(k)).md5 != null) && (str.equals(((CustomEmotionData)((List)localObject).get(k)).md5)))
        {
          a(paramQQAppInterface, paramStructMsgForImageShare, (CustomEmotionData)((List)localObject).get(k));
          if ("needDel".equals(((CustomEmotionData)((List)localObject).get(k)).RomaingType))
          {
            localafhu.a((CustomEmotionData)((List)localObject).get(k), k);
            paramQQAppInterface = paramQQAppInterface.getHandler(ChatActivity.class);
            if (paramQQAppInterface != null) {
              paramQQAppInterface.obtainMessage(10).sendToTarget();
            }
            return 0;
          }
          return 2;
        }
        int i1 = j;
        if (j < n) {
          i1 = n;
        }
        k += 1;
        n = m;
        j = i1;
      }
      if (n >= afhs.cQV) {
        return 3;
      }
    }
    else
    {
      j = 1;
    }
    localObject = new CustomEmotionData();
    ((CustomEmotionData)localObject).uin = paramQQAppInterface.getCurrentAccountUin();
    ((CustomEmotionData)localObject).emoId = (j + 1);
    ((CustomEmotionData)localObject).emoPath = paramString;
    ((CustomEmotionData)localObject).md5 = str;
    if ((paramPicMessageExtraData != null) && (paramPicMessageExtraData.isDiyDouTu())) {
      ((CustomEmotionData)localObject).eId = paramPicMessageExtraData.emojiPkgId;
    }
    localafhu.c((CustomEmotionBase)localObject);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith(acbn.bmO))) {
      anot.a(null, "CliOper", "", "", "ep_mall", "0X800695C", 0, 0, "", "", "", "");
    }
    b(paramQQAppInterface, paramStructMsgForImageShare, (CustomEmotionData)localObject);
    paramQQAppInterface = (afhv)paramQQAppInterface.getManager(103);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.d((CustomEmotionData)localObject);
    }
    return 0;
  }
  
  protected static int a(StringBuilder paramStringBuilder, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, int paramInt4, boolean paramBoolean2)
  {
    int j = 2;
    if (paramBoolean1) {
      if ((paramInt3 > 65535) && (paramInt2 >= paramInt1 + 2))
      {
        paramInt3 = j;
        if (aofk.cLs)
        {
          paramStringBuilder.replace(paramInt1, paramInt1 + 2, "##");
          paramInt3 = j;
        }
        if ((paramInt4 <= 65535) || (paramInt2 < paramInt1 + 2)) {
          break label121;
        }
        if (aofk.cLs) {
          paramStringBuilder.replace(paramInt1 + 2, paramInt1 + 4, "##");
        }
        paramInt1 = paramInt3 + 2;
        label85:
        paramInt2 = paramInt1;
        if (paramBoolean2) {
          paramInt2 = paramInt1 + 1;
        }
      }
    }
    label121:
    do
    {
      return paramInt2;
      if (aofk.cLs) {
        paramStringBuilder.replace(paramInt1, paramInt1 + 1, "#");
      }
      paramInt3 = 1;
      break;
      if (aofk.cLs) {
        paramStringBuilder.replace(paramInt1 + 2, paramInt1 + 3, "#");
      }
      paramInt1 = paramInt3 + 1;
      break label85;
      if ((paramInt3 <= 65535) || (paramInt2 < paramInt1 + 2)) {
        break label185;
      }
      paramInt2 = j;
    } while (!aofk.cLs);
    paramStringBuilder.replace(paramInt1, paramInt1 + 2, "##");
    return 2;
    label185:
    if (aofk.cLs) {
      paramStringBuilder.replace(paramInt1, paramInt1 + 1, "#");
    }
    return 1;
  }
  
  private long a(long paramLong, StickerInfo paramStickerInfo)
  {
    long l;
    if (paramLong != -9223372036854775808L)
    {
      l = paramLong;
      if (paramStickerInfo.hostMsgSeq >= paramLong) {}
    }
    else
    {
      l = paramLong;
      if (paramStickerInfo.hostMsgSeq > this.Xy)
      {
        if (QLog.isColorLevel()) {
          QLog.i("EmojiStickerManager", 2, "new navigate seq: " + paramStickerInfo.hostMsgSeq);
        }
        l = paramStickerInfo.hostMsgSeq;
      }
    }
    return l;
  }
  
  public static Pair<Long, Long> a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return null;
    }
    Object localObject;
    if (paramMessageRecord.msgtype == -2058)
    {
      localObject = a(paramMessageRecord);
      if (localObject == null) {
        break label269;
      }
      if (paramMessageRecord.istroop == 0) {
        paramMessageRecord = new Pair(Long.valueOf(((StickerInfo)localObject).hostMsgSeq), Long.valueOf(((StickerInfo)localObject).hostMsgUid));
      }
    }
    for (;;)
    {
      return paramMessageRecord;
      paramMessageRecord = new Pair(Long.valueOf(((StickerInfo)localObject).hostMsgSeq), Long.valueOf(0L));
      continue;
      if (paramMessageRecord.msgtype == -2006)
      {
        if (paramMessageRecord.istroop == 0) {
          return new Pair(Long.valueOf(paramMessageRecord.shmsgseq), Long.valueOf(paramMessageRecord.msgUid));
        }
        return new Pair(Long.valueOf(paramMessageRecord.shmsgseq), Long.valueOf(0L));
      }
      if (as(paramMessageRecord))
      {
        if (paramMessageRecord.istroop == 0) {
          return new Pair(Long.valueOf(paramMessageRecord.shmsgseq), Long.valueOf(paramMessageRecord.msgUid));
        }
        return new Pair(Long.valueOf(paramMessageRecord.shmsgseq), Long.valueOf(0L));
      }
      if (!(paramMessageRecord instanceof MessageForUniteGrayTip)) {
        break;
      }
      localObject = (MessageForUniteGrayTip)paramMessageRecord;
      if ((((MessageForUniteGrayTip)localObject).tipParam == null) || (((MessageForUniteGrayTip)localObject).tipParam.dbK != 1)) {
        break;
      }
      if (paramMessageRecord.istroop == 0) {
        return new Pair(Long.valueOf(paramMessageRecord.shmsgseq), Long.valueOf(paramMessageRecord.msgUid));
      }
      return new Pair(Long.valueOf(paramMessageRecord.shmsgseq), Long.valueOf(0L));
      label269:
      paramMessageRecord = null;
    }
  }
  
  public static aofk a(QQMessageFacade.Message paramMessage)
  {
    if (paramMessage == null) {}
    do
    {
      do
      {
        return null;
        paramMessage = paramMessage.getExtInfoFromExtStr("sticker_info");
      } while (TextUtils.isEmpty(paramMessage));
      paramMessage = StickerInfo.transformFromJson(paramMessage);
    } while (paramMessage == null);
    return new aofk(paramMessage.msg, 3, 16);
  }
  
  public static aofk a(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage, MsgSummary paramMsgSummary)
  {
    if ((paramQQAppInterface == null) || (paramMessage == null)) {
      return null;
    }
    acfp.m(2131705785);
    String str2 = "";
    Object localObject = paramMessage.getExtInfoFromExtStr("sticker_info");
    String str1 = str2;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = StickerInfo.transformFromJson((String)localObject);
      str1 = str2;
      if (localObject != null)
      {
        str2 = ((StickerInfo)localObject).msg;
        str1 = str2;
        if (bYE)
        {
          if (!paramMessage.senderuin.equals(paramQQAppInterface.getCurrentAccountUin())) {
            break label128;
          }
          str1 = acfp.m(2131705786) + str2;
        }
      }
    }
    for (paramMsgSummary.mEmojiFlag = 1;; paramMsgSummary.mEmojiFlag = 0)
    {
      return new aofk(str1, 3, 16);
      label128:
      str1 = acfp.m(2131705789) + str2;
    }
  }
  
  public static CustomEmotionData a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (afhu)paramQQAppInterface.getManager(149);
    List localList = paramQQAppInterface.ez();
    if (localList != null)
    {
      int j = 0;
      while (j < localList.size())
      {
        if ((paramString != null) && (paramString.equals(((CustomEmotionData)localList.get(j)).emoPath)))
        {
          paramString = (CustomEmotionData)localList.get(j);
          paramQQAppInterface.a(paramString, j);
          return paramString;
        }
        j += 1;
      }
    }
    return null;
  }
  
  private MessageRecord a(ChatXListView paramChatXListView, List<ChatMessage> paramList)
  {
    Object localObject = null;
    int j;
    if (paramChatXListView.getChildCount() > 0)
    {
      j = paramChatXListView.getFirstVisiblePosition() - paramChatXListView.getHeaderViewsCount();
      if ((j < 0) || (j >= paramChatXListView.getAdapter().getCount())) {
        break label63;
      }
    }
    for (;;)
    {
      localObject = paramChatXListView.getAdapter().getItem(j);
      if (!(localObject instanceof MessageRecord)) {
        break;
      }
      return (MessageRecord)localObject;
      label63:
      j = 0;
    }
    return (MessageRecord)paramList.get(0);
  }
  
  public static StickerInfo a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (paramMessageRecord.msgtype == -2058))
    {
      Object localObject;
      if ((paramMessageRecord instanceof MessageForMarketFace))
      {
        paramMessageRecord = (MessageForMarketFace)paramMessageRecord;
        if ((paramMessageRecord != null) && (paramMessageRecord.mMarkFaceMessage != null)) {
          localObject = paramMessageRecord.mMarkFaceMessage.stickerInfo;
        }
      }
      else
      {
        StickerInfo localStickerInfo;
        do
        {
          return localObject;
          if ((!(paramMessageRecord instanceof MessageForText)) && (!(paramMessageRecord instanceof MessageForPic))) {
            break;
          }
          localStickerInfo = paramMessageRecord.stickerInfo;
          localObject = localStickerInfo;
        } while (localStickerInfo != null);
        localObject = paramMessageRecord.getExtInfoFromExtStr("sticker_info");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = StickerInfo.transformFromJson((String)localObject);
          paramMessageRecord.stickerInfo = ((StickerInfo)localObject);
          return localObject;
        }
      }
    }
    return null;
  }
  
  public static EmojiStickerManager a()
  {
    return a;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    String str;
    do
    {
      return null;
      str = paramQQAppInterface.getCurrentUin();
      if (paramInt == 0)
      {
        if (str.equals(paramString2)) {
          return acfp.m(2131705792);
        }
        return acfp.m(2131705791);
      }
      if (paramInt == 1)
      {
        if (str.equals(paramString2)) {
          return paramQQAppInterface.getCurrentNickname();
        }
        return aqgv.h(paramQQAppInterface, paramString1, paramString2);
      }
    } while (paramInt != 3000);
    if (str.equals(paramString2)) {
      return paramQQAppInterface.getCurrentNickname();
    }
    return aqgv.m(paramQQAppInterface, paramString1, paramString2);
  }
  
  private HashMap<Pair<Long, Long>, List<ChatMessage>> a(HashMap<Pair<Long, Long>, List<ChatMessage>> paramHashMap, ChatMessage paramChatMessage)
  {
    Object localObject = paramHashMap;
    if (paramHashMap == null) {
      localObject = new HashMap();
    }
    Pair localPair = a(paramChatMessage);
    if (localPair != null)
    {
      List localList = (List)((HashMap)localObject).get(localPair);
      paramHashMap = localList;
      if (localList == null) {
        paramHashMap = new ArrayList();
      }
      paramHashMap.add(paramChatMessage);
      ((HashMap)localObject).put(localPair, paramHashMap);
    }
    return localObject;
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, URLDrawable paramURLDrawable, String paramString, PicMessageExtraData paramPicMessageExtraData, MessengerService paramMessengerService, Bundle paramBundle)
  {
    new afkl(paramBundle, paramMessengerService, paramURLDrawable, paramQQAppInterface, paramPicMessageExtraData).execute(new Void[0]);
  }
  
  private void a(Messenger paramMessenger, boolean paramBoolean)
  {
    if (paramMessenger != null) {}
    for (;;)
    {
      try
      {
        Message localMessage = Message.obtain(null, 4);
        if (paramMessenger != null)
        {
          Bundle localBundle1 = new Bundle();
          localBundle1.putString("cmd", "emojiStickerRecall");
          localBundle1.putString("callbackid", bDL);
          localBundle1.putInt("respkey", cRF);
          Bundle localBundle2 = new Bundle();
          if (!paramBoolean) {
            continue;
          }
          j = 0;
          localBundle2.putInt("result", j);
          AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
          if ((localAppRuntime instanceof QQAppInterface)) {
            localBundle2.putString("QQ", ((QQAppInterface)localAppRuntime).getCurrentUin());
          }
          j = -1;
          if (this.mCurType != 0) {
            continue;
          }
          j = 1;
          localBundle2.putInt("chatType", j);
          localBundle1.putBundle("response", localBundle2);
          localMessage.setData(localBundle1);
          paramMessenger.send(localMessage);
        }
      }
      catch (RemoteException paramMessenger)
      {
        int j;
        int k;
        QLog.e("EmojiStickerManager", 1, "sendEmojiStickerRecallResponse e =" + paramMessenger);
        continue;
      }
      bYH = false;
      return;
      j = -2;
      continue;
      if (this.mCurType == 1)
      {
        j = 2;
      }
      else
      {
        k = this.mCurType;
        if (k == 3000) {
          j = 3;
        }
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, int paramInt, List<ChatMessage> paramList, long paramLong)
  {
    if ((this.zO != null) && (this.zO.size() > 0))
    {
      if (paramInt <= 0) {
        break label54;
      }
      if (QLog.isColorLevel()) {
        QLog.i("EmojiStickerManager", 2, "has been pull more than once!");
      }
      paramInt = 0;
    }
    for (;;)
    {
      label54:
      Object localObject;
      if (paramInt != 0)
      {
        a(paramQQAppInterface, paramList, paramLong);
        return;
        localObject = (MessageRecord)paramList.get(paramList.size() - 1);
        if ((this.mCurType == 0) && (((MessageRecord)localObject).time > this.Xx))
        {
          if (QLog.isColorLevel()) {
            QLog.i("EmojiStickerManager", 2, "new message coming! getLastRead: " + ((MessageRecord)localObject).time);
          }
          this.bGd = 0;
          paramInt = 0;
          continue;
        }
        if (((MessageRecord)localObject).shmsgseq > this.Xx)
        {
          if (QLog.isColorLevel()) {
            QLog.i("EmojiStickerManager", 2, "new message coming! getLastRead: " + ((MessageRecord)localObject).shmsgseq);
          }
          paramInt = 0;
        }
      }
      else
      {
        paramList = this.zO.iterator();
        while (paramList.hasNext())
        {
          localObject = a((MessageRecord)paramList.next());
          if ((localObject != null) && (!((StickerInfo)localObject).isDisplayed)) {
            ((StickerInfo)localObject).isDisplayed = true;
          }
        }
        this.bGd = 0;
        this.Xw = paramQQAppInterface.a().e(this.bDK, this.mCurType);
        return;
      }
      paramInt = 1;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, StickerInfo paramStickerInfo)
  {
    if ((paramQQAppInterface == null) || (paramStickerInfo == null)) {}
    do
    {
      return;
      try
      {
        if ((paramMessageRecord instanceof MessageForMarketFace))
        {
          MessageForMarketFace localMessageForMarketFace = (MessageForMarketFace)paramMessageRecord;
          if (localMessageForMarketFace.mMarkFaceMessage != null) {
            localMessageForMarketFace.mMarkFaceMessage.stickerInfo = paramStickerInfo;
          }
          localMessageForMarketFace.msgData = aczw.b(localMessageForMarketFace.mMarkFaceMessage);
          paramQQAppInterface.b().c(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq, paramMessageRecord.msgData);
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e("EmojiStickerManager", 1, "save sticker shown status error e = " + paramQQAppInterface);
        return;
      }
    } while ((!(paramMessageRecord instanceof MessageForText)) && (!(paramMessageRecord instanceof MessageForPic)));
    paramMessageRecord.stickerInfo = paramStickerInfo;
    paramMessageRecord.saveExtInfoToExtStr("sticker_info", paramStickerInfo.toJsonString());
    paramQQAppInterface.b().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq, "extStr", paramMessageRecord.extStr);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, StructMsgForImageShare paramStructMsgForImageShare, CustomEmotionData paramCustomEmotionData)
  {
    paramStructMsgForImageShare = xtj.a(paramStructMsgForImageShare);
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramStructMsgForImageShare)) && (paramStructMsgForImageShare.startsWith("comic_plugin.apk")) && (paramCustomEmotionData != null) && (!TextUtils.isEmpty(paramCustomEmotionData.md5)))
    {
      paramQQAppInterface = (afim)paramQQAppInterface.getManager(141);
      VipComicFavorEmoStructMsgInfo localVipComicFavorEmoStructMsgInfo = new VipComicFavorEmoStructMsgInfo();
      localVipComicFavorEmoStructMsgInfo.picMd5 = paramCustomEmotionData.md5;
      localVipComicFavorEmoStructMsgInfo.actionData = paramStructMsgForImageShare;
      if (!localVipComicFavorEmoStructMsgInfo.equals(paramQQAppInterface.a(paramCustomEmotionData.md5)))
      {
        paramStructMsgForImageShare = new ArrayList();
        paramStructMsgForImageShare.add(localVipComicFavorEmoStructMsgInfo);
        paramQQAppInterface.ao(paramStructMsgForImageShare, true);
        if (QLog.isColorLevel()) {
          QLog.d("EmojiStickerManager", 2, "handleOldComicStructMsg , emoStructMsgInfo = " + localVipComicFavorEmoStructMsgInfo);
        }
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, List<ChatMessage> paramList, long paramLong)
  {
    Object localObject1 = (MessageRecord)paramList.get(paramList.size() - 1);
    if (QLog.isColorLevel()) {
      QLog.i("EmojiStickerManager", 2, "insertStickerGrayTips4UnRead, mUnReadCount: " + this.bGd + ", new sticker size: " + this.zO.size());
    }
    MessageForUniteGrayTip localMessageForUniteGrayTip;
    Object localObject2;
    if (this.bGd > 0)
    {
      localMessageForUniteGrayTip = new MessageForUniteGrayTip();
      localMessageForUniteGrayTip.isread = true;
      if (this.bGd > 10) {
        break label395;
      }
      if ((this.mCurType != 1) || (paramLong == -9223372036854775808L)) {
        break label319;
      }
      localObject2 = String.format(acfp.m(2131705784), new Object[] { Integer.valueOf(Math.min(this.zO.size(), this.bGd)) });
      localObject1 = new ahwa(((MessageRecord)localObject1).frienduin, paramQQAppInterface.getCurrentAccountUin(), (String)localObject2, ((MessageRecord)localObject1).istroop, -5023, 1179651, ((MessageRecord)localObject1).time);
      Bundle localBundle = new Bundle();
      localBundle.putInt("key_action", 20);
      localBundle.putString("key_action_DATA", String.valueOf(paramLong));
      ((ahwa)localObject1).addHightlightItem(((String)localObject2).length() - 4, ((String)localObject2).length(), localBundle);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("key", "NewTip");
      ((Bundle)localObject2).putInt("sessionType", this.mCurType);
      ((Bundle)localObject2).putString("ext2", "1");
      this.wg.add(localObject2);
      localMessageForUniteGrayTip.initGrayTipMsg(paramQQAppInterface, (ahwa)localObject1);
    }
    for (;;)
    {
      paramList.add(paramList.size(), localMessageForUniteGrayTip);
      return;
      label319:
      localObject2 = String.format(acfp.m(2131705787), new Object[] { Integer.valueOf(Math.min(this.zO.size(), this.bGd)) });
      localObject1 = new ahwa(((MessageRecord)localObject1).frienduin, paramQQAppInterface.getCurrentAccountUin(), (String)localObject2, ((MessageRecord)localObject1).istroop, -5023, 1179651, ((MessageRecord)localObject1).time);
      break;
      label395:
      if (this.bGd > 10)
      {
        localObject2 = acfp.m(2131705793);
        localMessageForUniteGrayTip.initGrayTipMsg(paramQQAppInterface, new ahwa(((MessageRecord)localObject1).frienduin, paramQQAppInterface.getCurrentAccountUin(), (String)localObject2, ((MessageRecord)localObject1).istroop, -5023, 1179651, ((MessageRecord)localObject1).time));
        paramQQAppInterface = new Bundle();
        paramQQAppInterface.putString("key", "NewTip");
        paramQQAppInterface.putInt("sessionType", this.mCurType);
        paramQQAppInterface.putString("ext2", "2");
        this.wg.add(paramQQAppInterface);
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, List<ChatMessage> paramList, HashMap<Pair<Long, Long>, List<ChatMessage>> paramHashMap)
  {
    Object localObject = new ArrayList();
    a(paramQQAppInterface, paramList, paramHashMap, (List)localObject);
    if (((List)localObject).size() > 0)
    {
      paramQQAppInterface = new Bundle();
      paramQQAppInterface.putString("key", "DeleteHide");
      paramQQAppInterface.putInt("sessionType", this.mCurType);
      this.wg.add(paramQQAppInterface);
    }
    paramQQAppInterface = ((List)localObject).iterator();
    if (paramQQAppInterface.hasNext())
    {
      paramHashMap = (MessageForUniteGrayTip)paramQQAppInterface.next();
      localObject = paramList.iterator();
      int j = 0;
      for (;;)
      {
        if ((!((Iterator)localObject).hasNext()) || (((MessageRecord)((Iterator)localObject).next()).time > paramHashMap.time))
        {
          if (QLog.isColorLevel()) {
            QLog.i("EmojiStickerManager", 2, "insert unfounded gray tips:  host seq: " + paramHashMap.shmsgseq + ", list pos: " + j);
          }
          paramList.add(j, paramHashMap);
          break;
        }
        j += 1;
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, List<ChatMessage> paramList, HashMap<Pair<Long, Long>, List<ChatMessage>> paramHashMap, List<MessageForUniteGrayTip> paramList1)
  {
    long l1;
    label30:
    label57:
    Pair localPair;
    Object localObject1;
    StickerInfo localStickerInfo;
    int j;
    label214:
    Object localObject2;
    if (paramList.size() > 0)
    {
      paramList = (ChatMessage)paramList.get(0);
      if (paramList == null) {
        break label433;
      }
      l1 = paramList.time;
      long l3 = paramQQAppInterface.a().j(this.bDK, this.mCurType);
      paramList = paramHashMap.keySet().iterator();
      do
      {
        if (!paramList.hasNext()) {
          break;
        }
        localPair = (Pair)paramList.next();
        localObject1 = (List)paramHashMap.get(localPair);
      } while ((localObject1 == null) || (((List)localObject1).size() == 0));
      localObject1 = (MessageRecord)((List)localObject1).get(0);
      localStickerInfo = a((MessageRecord)localObject1);
      if (QLog.isColorLevel()) {
        QLog.i("EmojiStickerManager", 2, "unFind msg: shmsgseq: " + localStickerInfo.hostMsgSeq + ", isDisplay: " + localStickerInfo.isDisplayed + ", hostTime: " + localStickerInfo.hostMsgTime);
      }
      if ((!this.r.containsKey(localPair)) && (localStickerInfo.hostMsgTime <= l1)) {
        break label441;
      }
      j = 1;
      k = j;
      if (j != 0) {
        break label621;
      }
      localObject2 = paramQQAppInterface.a(this.mCurType).i(this.bDK, this.mCurType);
      k = j;
      if (localObject2 == null) {
        break label621;
      }
      k = j;
      if (((List)localObject2).size() <= 0) {
        break label621;
      }
      if (localStickerInfo.hostMsgTime >= ((MessageRecord)((List)localObject2).get(0)).time) {
        break label450;
      }
      if (localStickerInfo.hostMsgTime > l3) {
        break label447;
      }
      j = 1;
    }
    label304:
    Object localObject3;
    label433:
    label441:
    label447:
    for (;;)
    {
      if (j == 0) {
        break label626;
      }
      localObject2 = new MessageForUniteGrayTip();
      localObject3 = BaseApplicationImpl.getApplication().getString(2131720460);
      ((MessageForUniteGrayTip)localObject2).initGrayTipMsg(paramQQAppInterface, new ahwa(((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).senderuin, (String)localObject3, this.mCurType, -5040, 1, localStickerInfo.hostMsgTime));
      ((MessageForUniteGrayTip)localObject2).shmsgseq = ((Long)localPair.first).longValue();
      ((MessageForUniteGrayTip)localObject2).msgUid = ((Long)localPair.second).longValue();
      ((MessageForUniteGrayTip)localObject2).time = localStickerInfo.hostMsgTime;
      ((MessageForUniteGrayTip)localObject2).mNeedTimeStamp = false;
      paramList1.add(localObject2);
      break label57;
      paramList = null;
      break;
      l1 = 9223372036854775807L;
      break label30;
      j = 0;
      break label214;
    }
    label450:
    int k = ((List)localObject2).size() - 1;
    label461:
    int m;
    if (k >= 0)
    {
      localObject3 = (MessageRecord)((List)localObject2).get(k);
      if ((((MessageRecord)localObject3).shmsgseq == localStickerInfo.hostMsgSeq) && (((MessageRecord)localObject3).msgUid == localStickerInfo.hostMsgUid))
      {
        m = 1;
        j = 0;
      }
    }
    for (;;)
    {
      k = j;
      if (m == 0)
      {
        localObject2 = paramQQAppInterface.a().h(this.bDK);
        if (localObject2 == null) {}
        for (long l2 = 0L;; l2 = ((Long)((Pair)localObject2).first).longValue())
        {
          if ((localStickerInfo.hostMsgTime <= l2) && (l2 != 0L)) {
            break label593;
          }
          j = 1;
          break;
          k -= 1;
          break label461;
        }
        label593:
        k = j;
        if (this.Xw - localStickerInfo.hostMsgTime > 86400L)
        {
          j = 1;
          break label304;
          return;
        }
      }
      label621:
      j = k;
      break label304;
      label626:
      break;
      m = 0;
    }
  }
  
  public static void a(MessageRecord paramMessageRecord, StickerInfo paramStickerInfo)
  {
    if ((paramMessageRecord == null) || (!ar(paramMessageRecord))) {
      return;
    }
    for (;;)
    {
      int j;
      try
      {
        j = paramMessageRecord.msgtype;
        if (paramStickerInfo == null) {
          break label211;
        }
        paramStickerInfo.originMsgType = paramMessageRecord.msgtype;
      }
      catch (Exception paramMessageRecord) {}
      paramMessageRecord.extLong |= 0x4;
      paramStickerInfo = new JSONObject();
      paramStickerInfo.put("msgType", j);
      paramMessageRecord.saveExtInfoToExtStr("Emoji_Sticker_Info", paramStickerInfo.toString());
      if (!bYE) {
        break;
      }
      paramMessageRecord.msgtype = -2058;
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("EmojiStickerManager", 2, "", paramMessageRecord);
      return;
      Object localObject = (MessageForMarketFace)paramMessageRecord;
      if (((MessageForMarketFace)localObject).mMarkFaceMessage != null) {
        ((MessageForMarketFace)localObject).mMarkFaceMessage.stickerInfo = paramStickerInfo;
      }
      ((MessageForMarketFace)localObject).msgData = aczw.b(((MessageForMarketFace)localObject).mMarkFaceMessage);
      continue;
      paramStickerInfo = paramMessageRecord.getExtInfoFromExtStr("sticker_info");
      if (!TextUtils.isEmpty(paramStickerInfo))
      {
        localObject = StickerInfo.transformFromJson(paramStickerInfo);
        if (localObject != null)
        {
          ((StickerInfo)localObject).originMsgType = j;
          if (j == -1000) {}
          for (paramStickerInfo = paramMessageRecord.msg;; paramStickerInfo = acfp.m(2131705790))
          {
            ((StickerInfo)localObject).msg = paramStickerInfo;
            paramMessageRecord.stickerInfo = ((StickerInfo)localObject);
            paramMessageRecord.saveExtInfoToExtStr("sticker_info", ((StickerInfo)localObject).toJsonString());
            break;
          }
          label211:
          switch (j)
          {
          }
        }
      }
    }
  }
  
  protected static void a(StringBuilder paramStringBuilder, int paramInt1, int paramInt2)
  {
    if (aofk.cLs) {
      paramStringBuilder.replace(paramInt1, paramInt1 + 2, "##");
    }
    while (paramInt2 != 10) {
      return;
    }
    paramStringBuilder.setCharAt(paramInt1 + 1, 'ú');
  }
  
  private void a(List<ChatMessage> paramList, QQAppInterface paramQQAppInterface, HashMap<Pair<Long, Long>, List<ChatMessage>> paramHashMap)
  {
    if (this.mCurType != 0) {
      b(paramQQAppInterface, paramList, paramHashMap);
    }
    for (;;)
    {
      if (paramList.size() == 0) {
        c(paramQQAppInterface, paramList, paramHashMap);
      }
      return;
      a(paramQQAppInterface, paramList, paramHashMap);
    }
  }
  
  private boolean a(long paramLong, boolean paramBoolean, StickerInfo paramStickerInfo)
  {
    if (paramStickerInfo.hostMsgTime < paramLong)
    {
      if (QLog.isColorLevel()) {
        QLog.i("EmojiStickerManager", 2, "need insert unRead tips!");
      }
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  private static boolean a(MessageForQQWalletMsg paramMessageForQQWalletMsg)
  {
    boolean bool = true;
    QQWalletTransferMsgElem localQQWalletTransferMsgElem = null;
    if (paramMessageForQQWalletMsg == null) {
      break label25;
    }
    label25:
    do
    {
      do
      {
        return false;
        if (paramMessageForQQWalletMsg.mQQWalletTransferMsg == null) {
          break;
        }
        localQQWalletTransferMsgElem = paramMessageForQQWalletMsg.mQQWalletTransferMsg.elem;
      } while (localQQWalletTransferMsgElem == null);
      paramMessageForQQWalletMsg = localQQWalletTransferMsgElem.nativeAndroid;
    } while (TextUtils.isEmpty(paramMessageForQQWalletMsg));
    paramMessageForQQWalletMsg = paramMessageForQQWalletMsg.split("\\?");
    if ((!TextUtils.isEmpty(paramMessageForQQWalletMsg[0])) && (paramMessageForQQWalletMsg[0].equals("red"))) {}
    for (;;)
    {
      return bool;
      if (paramMessageForQQWalletMsg.mQQWalletRedPacketMsg == null) {
        break;
      }
      return true;
      bool = false;
    }
  }
  
  private boolean a(List<ChatMessage> paramList, ChatMessage paramChatMessage, StickerInfo paramStickerInfo)
  {
    if (paramStickerInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("EmojiStickerManager", 2, "sticker info is null! WTF!");
      }
      return true;
    }
    if (!bYE)
    {
      paramChatMessage.msgtype = paramStickerInfo.originMsgType;
      return true;
    }
    a().aj(paramChatMessage);
    paramList.remove(paramChatMessage);
    if (QLog.isColorLevel()) {
      QLog.i("EmojiStickerManager", 2, "isDisplay: " + paramStickerInfo.isDisplayed + ", isRead:" + paramChatMessage.isread + ", hostSeq: " + paramStickerInfo.hostMsgSeq + ", hostTime: " + paramStickerInfo.hostMsgTime);
    }
    return false;
  }
  
  public static boolean ar(MessageRecord paramMessageRecord)
  {
    return ((paramMessageRecord instanceof MessageForMarketFace)) || (((paramMessageRecord instanceof MessageForText)) && (paramMessageRecord.msgtype == -1000)) || ((paramMessageRecord instanceof MessageForPic));
  }
  
  public static boolean as(MessageRecord paramMessageRecord)
  {
    boolean bool2 = false;
    int m = paramMessageRecord.msgtype;
    int j;
    if (((paramMessageRecord instanceof MessageForApollo)) && (ApolloGameUtil.ib(((MessageForApollo)paramMessageRecord).msgType)))
    {
      j = 1;
      if ((!(paramMessageRecord instanceof MessageForQQWalletMsg)) || (!a((MessageForQQWalletMsg)paramMessageRecord))) {
        break label146;
      }
    }
    label146:
    for (int k = 1;; k = 0)
    {
      boolean bool1;
      if ((m != -1000) && (m != -2011) && (m != -2039) && ((m != -2025) || (k == 0)) && (m != -2007) && (m != -2000) && (m != -2002) && (m != -2022) && (m != -1035))
      {
        bool1 = bool2;
        if (m != -1049) {}
      }
      else
      {
        bool1 = bool2;
        if (j == 0) {
          bool1 = true;
        }
      }
      return bool1;
      j = 0;
      break;
    }
  }
  
  public static boolean at(MessageRecord paramMessageRecord)
  {
    return ((paramMessageRecord instanceof MessageForMarketFace)) || ((paramMessageRecord instanceof MessageForText)) || ((paramMessageRecord instanceof MessageForPic));
  }
  
  public static boolean au(MessageRecord paramMessageRecord)
  {
    return (paramMessageRecord != null) && ((paramMessageRecord.istroop == 0) || (paramMessageRecord.istroop == 1) || (paramMessageRecord.istroop == 3000));
  }
  
  private static void b(QQAppInterface paramQQAppInterface, StructMsgForImageShare paramStructMsgForImageShare, CustomEmotionData paramCustomEmotionData)
  {
    paramStructMsgForImageShare = xtj.a(paramStructMsgForImageShare);
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramStructMsgForImageShare)) && (paramStructMsgForImageShare.startsWith("comic_plugin.apk")) && (paramCustomEmotionData != null) && (!TextUtils.isEmpty(paramCustomEmotionData.md5)))
    {
      paramQQAppInterface = (afim)paramQQAppInterface.getManager(141);
      VipComicFavorEmoStructMsgInfo localVipComicFavorEmoStructMsgInfo = new VipComicFavorEmoStructMsgInfo();
      localVipComicFavorEmoStructMsgInfo.picMd5 = paramCustomEmotionData.md5;
      localVipComicFavorEmoStructMsgInfo.actionData = paramStructMsgForImageShare;
      paramStructMsgForImageShare = new ArrayList();
      paramStructMsgForImageShare.add(localVipComicFavorEmoStructMsgInfo);
      paramQQAppInterface.ao(paramStructMsgForImageShare, true);
      if (QLog.isColorLevel()) {
        QLog.d("EmojiStickerManager", 2, "handleComicStructMsg , emoStructMsgInfo = " + localVipComicFavorEmoStructMsgInfo);
      }
    }
  }
  
  private void b(QQAppInterface paramQQAppInterface, List<ChatMessage> paramList, HashMap<Pair<Long, Long>, List<ChatMessage>> paramHashMap)
  {
    Object localObject = new ArrayList();
    b(paramQQAppInterface, paramList, paramHashMap, (List)localObject);
    if (((List)localObject).size() > 0)
    {
      paramQQAppInterface = new Bundle();
      paramQQAppInterface.putString("key", "DeleteHide");
      paramQQAppInterface.putInt("sessionType", this.mCurType);
      this.wg.add(paramQQAppInterface);
    }
    paramQQAppInterface = ((List)localObject).iterator();
    if (paramQQAppInterface.hasNext())
    {
      paramHashMap = (MessageForUniteGrayTip)paramQQAppInterface.next();
      localObject = paramList.iterator();
      int j = 0;
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
          if (localMessageRecord.shmsgseq > paramHashMap.shmsgseq) {
            paramHashMap.time = (localMessageRecord.time - 10L);
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.i("EmojiStickerManager", 2, "insert unfind gray tips:  host seq: " + paramHashMap.shmsgseq + ", list pos: " + j);
          }
          paramList.add(j, paramHashMap);
          break;
        }
        j += 1;
      }
    }
  }
  
  private void b(QQAppInterface paramQQAppInterface, List<ChatMessage> paramList, HashMap<Pair<Long, Long>, List<ChatMessage>> paramHashMap, List<MessageForUniteGrayTip> paramList1)
  {
    long l1;
    label30:
    label57:
    Pair localPair1;
    Object localObject1;
    Object localObject2;
    label220:
    int j;
    Object localObject3;
    if (paramList.size() > 0)
    {
      paramList = (ChatMessage)paramList.get(0);
      if (paramList == null) {
        break label433;
      }
      l1 = paramList.shmsgseq;
      long l2 = paramQQAppInterface.a().j(this.bDK, this.mCurType);
      paramList = paramHashMap.keySet().iterator();
      do
      {
        if (!paramList.hasNext()) {
          break;
        }
        localPair1 = (Pair)paramList.next();
        localObject1 = (List)paramHashMap.get(localPair1);
      } while ((localObject1 == null) || (((List)localObject1).size() == 0));
      localObject1 = (MessageRecord)((List)localObject1).get(0);
      localObject2 = a((MessageRecord)localObject1);
      if (QLog.isColorLevel()) {
        QLog.i("EmojiStickerManager", 2, "unFind msg: shmsgseq: " + ((StickerInfo)localObject2).hostMsgSeq + ", isDisplay: " + ((StickerInfo)localObject2).isDisplayed + ", hostTime: " + ((StickerInfo)localObject2).hostMsgTime);
      }
      if ((!this.r.containsKey(localPair1)) && (((Long)localPair1.first).longValue() <= l1)) {
        break label441;
      }
      k = 1;
      j = k;
      if (k == 0)
      {
        localObject3 = paramQQAppInterface.a(this.mCurType).i(this.bDK, this.mCurType);
        j = k;
        if (localObject3 != null)
        {
          j = k;
          if (((List)localObject3).size() > 0)
          {
            if (((StickerInfo)localObject2).hostMsgSeq >= ((MessageRecord)((List)localObject3).get(0)).shmsgseq) {
              break label447;
            }
            j = k;
            if (((StickerInfo)localObject2).hostMsgSeq <= l2) {
              j = 1;
            }
          }
        }
      }
    }
    label314:
    label447:
    label456:
    MessageRecord localMessageRecord;
    for (;;)
    {
      if (j != 0)
      {
        localObject2 = new MessageForUniteGrayTip();
        localObject3 = BaseApplicationImpl.getApplication().getString(2131720460);
        ((MessageForUniteGrayTip)localObject2).initGrayTipMsg(paramQQAppInterface, new ahwa(((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).senderuin, (String)localObject3, this.mCurType, -5040, 1, ((MessageRecord)localObject1).time));
        ((MessageForUniteGrayTip)localObject2).shmsgseq = ((Long)localPair1.first).longValue();
        ((MessageForUniteGrayTip)localObject2).msgUid = ((Long)localPair1.second).longValue();
        ((MessageForUniteGrayTip)localObject2).mNeedTimeStamp = false;
        paramList1.add(localObject2);
        break label57;
        paramList = null;
        break;
        label433:
        l1 = 9223372036854775807L;
        break label30;
        label441:
        k = 0;
        break label220;
        localObject3 = ((List)localObject3).iterator();
        j = k;
        if (((Iterator)localObject3).hasNext())
        {
          localMessageRecord = (MessageRecord)((Iterator)localObject3).next();
          j = k;
          if (localMessageRecord.shmsgseq < l1)
          {
            if (localMessageRecord.msgtype == -2006)
            {
              Pair localPair2 = a(localMessageRecord);
              if (localPair2 != null) {
                this.r.put(localPair2, Boolean.valueOf(true));
              }
            }
            j = k;
            if (localMessageRecord.shmsgseq == ((StickerInfo)localObject2).hostMsgSeq)
            {
              j = k;
              if (!top.s(localMessageRecord)) {
                if (localMessageRecord.msgtype != -2006) {
                  break label618;
                }
              }
            }
          }
        }
      }
    }
    label618:
    for (int k = 1;; k = 0)
    {
      j = k;
      if (k == 0) {
        break label314;
      }
      j = k;
      k = j;
      if (j == 0) {
        break label456;
      }
      k = j;
      if (!as(localMessageRecord)) {
        break label456;
      }
      j = 0;
      break label314;
      break;
    }
  }
  
  protected static void b(StringBuilder paramStringBuilder, int paramInt)
  {
    if (aofk.cLs) {
      paramStringBuilder.replace(paramInt, paramInt + 2, "##");
    }
  }
  
  private boolean b(long paramLong, boolean paramBoolean, StickerInfo paramStickerInfo)
  {
    if (paramStickerInfo.hostMsgSeq < paramLong)
    {
      if (QLog.isColorLevel()) {
        QLog.i("EmojiStickerManager", 2, "need insert unRead tips!");
      }
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  public static int c(StringBuilder paramStringBuilder)
  {
    int i3 = paramStringBuilder.length();
    int i4 = paramStringBuilder.length();
    int j = 0;
    int m = 0;
    int n = 0;
    if (n < i3)
    {
      int i5 = paramStringBuilder.codePointAt(n);
      int k;
      if ((i5 == 20) && (n < i4 - 1))
      {
        k = paramStringBuilder.charAt(n + 1);
        if (k < aoff.dOp)
        {
          a(paramStringBuilder, n, k);
          k = n + 1;
          n = m + 1;
          j += 1;
          m = k;
          k = n;
        }
      }
      label92:
      int i1;
      boolean bool1;
      for (;;)
      {
        if (k > 512)
        {
          return j;
          if ((k >= 255) && (n + 4 < i4))
          {
            c(paramStringBuilder, n);
            n += 4;
            k = m + 1;
            j += 1;
            m = n;
          }
          else
          {
            if (k != 250) {
              break label354;
            }
            b(paramStringBuilder, n);
            n += 1;
            k = m + 1;
            j += 1;
            m = n;
            continue;
            i1 = aoff.jw(i5);
            if (i5 > 65535)
            {
              if (i4 <= n + 2) {
                break label380;
              }
              k = paramStringBuilder.codePointAt(n + 2);
              bool1 = false;
            }
          }
        }
      }
      for (;;)
      {
        label212:
        if (aoff.lM(k)) {}
        label354:
        for (int i2 = 1;; i2 = 0)
        {
          if ((i1 == -1) || (i2 != 0))
          {
            i2 = aoff.aO(i5, k);
            if (i2 != -1) {}
          }
          label247:
          for (boolean bool2 = true;; bool2 = false)
          {
            if (i1 != -1)
            {
              n += a(paramStringBuilder, n, i4, i5, bool2, k, bool1) - 1;
              k = m + 1;
              m = n;
              break label92;
              if (i4 <= n + 1) {
                break label380;
              }
              k = paramStringBuilder.codePointAt(n + 1);
              if ((k != 65039) || (i4 <= n + 2)) {
                break label374;
              }
              k = paramStringBuilder.codePointAt(n + 2);
              bool1 = true;
              break label212;
              i1 = i2;
              break label247;
              n = m + 1;
              m = k;
              break;
            }
            k = m;
            m = n;
            break label92;
          }
        }
        label374:
        bool1 = false;
        continue;
        label380:
        bool1 = false;
        k = -1;
      }
    }
    return j;
  }
  
  private void c(QQAppInterface paramQQAppInterface, List<ChatMessage> paramList, HashMap<Pair<Long, Long>, List<ChatMessage>> paramHashMap)
  {
    Object localObject1 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    int j = 0;
    int k;
    if ((paramHashMap != null) && (paramHashMap.size() > 0))
    {
      Iterator localIterator1 = paramHashMap.keySet().iterator();
      k = 0;
      MessageRecord localMessageRecord = null;
      localObject1 = localObject3;
      while (localIterator1.hasNext())
      {
        localObject3 = (List)paramHashMap.get((Pair)localIterator1.next());
        if ((localObject3 != null) && (((List)localObject3).size() != 0))
        {
          int m = ((List)localObject3).size();
          if (localMessageRecord != null) {
            break label592;
          }
          localMessageRecord = (MessageRecord)((List)localObject3).get(0);
          Iterator localIterator2 = ((List)localObject3).iterator();
          if (localIterator2.hasNext())
          {
            localObject3 = (ChatMessage)localIterator2.next();
            if ((localObject1 == null) && (!((ChatMessage)localObject3).senderuin.equals(localObject1)))
            {
              localObject3 = ((ChatMessage)localObject3).senderuin;
              localObject1 = localObject2;
              localObject2 = localObject3;
            }
            for (;;)
            {
              label179:
              localObject3 = localObject2;
              localObject2 = localObject1;
              localObject1 = localObject3;
              break;
              if ((localObject2 == null) && (!((ChatMessage)localObject3).senderuin.equals(localObject1)))
              {
                localObject3 = ((ChatMessage)localObject3).senderuin;
                localObject2 = localObject1;
                localObject1 = localObject3;
              }
              else
              {
                if ((localObject1 == null) || (localObject2 == null)) {
                  break label595;
                }
                j = 1;
                localObject3 = localObject1;
                localObject1 = localObject2;
                localObject2 = localObject3;
              }
            }
          }
          k = m + k;
        }
      }
      paramHashMap = (HashMap<Pair<Long, Long>, List<ChatMessage>>)localObject2;
      localObject2 = localMessageRecord;
    }
    for (;;)
    {
      if ((k > 0) && (localObject2 != null))
      {
        localObject1 = a(paramQQAppInterface, ((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop, (String)localObject1);
        paramHashMap = a(paramQQAppInterface, ((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop, paramHashMap);
        if ((k != 1) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(paramHashMap))) {
          break label523;
        }
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label513;
        }
        paramHashMap = (HashMap<Pair<Long, Long>, List<ChatMessage>>)localObject1;
      }
      for (;;)
      {
        paramHashMap = String.format("%s在上面贴了%d个表情", new Object[] { paramHashMap, Integer.valueOf(k) });
        localObject2 = new ahwa(((MessageRecord)localObject2).frienduin, paramQQAppInterface.getCurrentAccountUin(), paramHashMap, ((MessageRecord)localObject2).istroop, -5023, 1179651, ((MessageRecord)localObject2).time);
        localObject1 = new MessageForUniteGrayTip();
        ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(paramQQAppInterface, (ahwa)localObject2);
        if (QLog.isColorLevel()) {
          QLog.i("EmojiStickerManager", 2, "insert gray tips for sticker msg! " + paramHashMap);
        }
        ((MessageForUniteGrayTip)localObject1).isread = true;
        paramQQAppInterface = new Bundle();
        paramQQAppInterface.putString("key", "NotGetTip");
        paramQQAppInterface.putInt("sessionType", this.mCurType);
        this.wg.add(paramQQAppInterface);
        paramList.add(localObject1);
        return;
        label513:
        if (!TextUtils.isEmpty(paramHashMap))
        {
          continue;
          label523:
          localObject1 = (String)localObject1 + "、" + paramHashMap;
          paramHashMap = (HashMap<Pair<Long, Long>, List<ChatMessage>>)localObject1;
          if (j != 0) {
            paramHashMap = (String)localObject1 + acfp.m(2131705788);
          }
        }
        else
        {
          paramHashMap = "";
        }
      }
      label592:
      break;
      label595:
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      break label179;
      localObject2 = null;
      k = 0;
      paramHashMap = null;
      j = 0;
    }
  }
  
  protected static void c(StringBuilder paramStringBuilder, int paramInt)
  {
    int m = 2;
    int j = 0;
    char[] arrayOfChar = new char[4];
    arrayOfChar[0] = paramStringBuilder.charAt(paramInt + 4);
    arrayOfChar[1] = paramStringBuilder.charAt(paramInt + 3);
    arrayOfChar[2] = paramStringBuilder.charAt(paramInt + 2);
    arrayOfChar[3] = paramStringBuilder.charAt(paramInt + 1);
    int k = m;
    if (j < 3)
    {
      if (arrayOfChar[j] == 'ú') {
        arrayOfChar[j] = '\n';
      }
      for (;;)
      {
        j += 1;
        break;
        if (arrayOfChar[j] == 'þ') {
          arrayOfChar[j] = '\r';
        }
      }
    }
    if (k < 5)
    {
      if (paramStringBuilder.charAt(paramInt + k) == '\n') {
        paramStringBuilder.setCharAt(paramInt + k, 'ú');
      }
      for (;;)
      {
        k += 1;
        break;
        if (paramStringBuilder.charAt(paramInt + k) == '\r') {
          paramStringBuilder.setCharAt(paramInt + k, 'þ');
        }
      }
    }
  }
  
  public static void cZU()
  {
    ThreadManager.post(new EmojiStickerManager.2(), 5, null, false);
  }
  
  public static void f(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    Object localObject;
    if (paramMessageRecord.istroop != 0)
    {
      localObject = a(paramMessageRecord);
      if (localObject != null)
      {
        localObject = new Pair(Long.valueOf(((StickerInfo)localObject).hostMsgSeq), Long.valueOf(0L));
        if (!a().r.containsKey(localObject)) {
          break label347;
        }
      }
    }
    label347:
    for (int j = 1;; j = 0)
    {
      int k;
      if (j == 0)
      {
        List localList = paramQQAppInterface.a(paramMessageRecord.istroop).h(paramMessageRecord.frienduin, paramMessageRecord.istroop);
        if ((localList != null) && (localList.size() > 0))
        {
          k = localList.size() - 1;
          if (k >= 0)
          {
            paramQQAppInterface = (MessageRecord)localList.get(k);
            if ((paramQQAppInterface.shmsgseq != ((Long)((Pair)localObject).first).longValue()) || (!as(paramQQAppInterface))) {}
          }
        }
      }
      for (;;)
      {
        if (((j != 0) || ((paramQQAppInterface != null) && (paramQQAppInterface.msgtype == -2006))) && (paramQQAppInterface != null)) {
          a().r.put(localObject, Boolean.valueOf(true));
        }
        for (;;)
        {
          a().ak(paramMessageRecord);
          return;
          k -= 1;
          break;
          paramQQAppInterface = a(paramMessageRecord);
          if (paramQQAppInterface != null)
          {
            paramQQAppInterface.hostMsgSeq = ((short)(int)paramQQAppInterface.hostMsgSeq);
            if ((paramMessageRecord instanceof MessageForMarketFace))
            {
              localObject = (MessageForMarketFace)paramMessageRecord;
              if (((MessageForMarketFace)localObject).mMarkFaceMessage != null) {
                ((MessageForMarketFace)localObject).mMarkFaceMessage.stickerInfo = paramQQAppInterface;
              }
              try
              {
                ((MessageForMarketFace)localObject).msgData = aczw.b(((MessageForMarketFace)localObject).mMarkFaceMessage);
              }
              catch (Exception paramQQAppInterface)
              {
                paramQQAppInterface.printStackTrace();
              }
            }
            else if ((paramMessageRecord instanceof MessageForText))
            {
              localObject = (MessageForText)paramMessageRecord;
              ((MessageForText)localObject).stickerInfo = paramQQAppInterface;
              ((MessageForText)localObject).saveExtInfoToExtStr("sticker_info", paramQQAppInterface.toJsonString());
            }
            else if ((paramMessageRecord instanceof MessageForPic))
            {
              localObject = (MessageForPic)paramMessageRecord;
              ((MessageForPic)localObject).stickerInfo = paramQQAppInterface;
              ((MessageForPic)localObject).saveExtInfoToExtStr("sticker_info", paramQQAppInterface.toJsonString());
            }
          }
        }
        paramQQAppInterface = null;
      }
    }
  }
  
  private void kp(List<MessageRecord> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((MessageRecord)paramList.next()).stickerHidden = false;
      }
    }
  }
  
  public static String uv()
  {
    try
    {
      String str = BaseApplicationImpl.getApplication().getDir(".emojiSticker_v2.1", 0).getAbsoluteFile() + File.separator;
      return str;
    }
    catch (Exception localException) {}
    return BaseApplicationImpl.getApplication().getDir(".emojiSticker_v2.1", 0).getAbsoluteFile() + File.separator;
  }
  
  protected afmi a(int paramInt1, int paramInt2, StringBuilder paramStringBuilder)
  {
    int j = 0;
    int k = paramStringBuilder.charAt(paramInt1 + 1);
    Object localObject;
    boolean bool1;
    Emoticon localEmoticon;
    if ((k >= 255) && (paramInt1 + 4 < paramInt2))
    {
      localObject = new char[4];
      localObject[0] = paramStringBuilder.charAt(paramInt1 + 4);
      localObject[1] = paramStringBuilder.charAt(paramInt1 + 3);
      localObject[2] = paramStringBuilder.charAt(paramInt1 + 2);
      localObject[3] = paramStringBuilder.charAt(paramInt1 + 1);
      paramInt1 = 0;
      if (paramInt1 < 3)
      {
        if (localObject[paramInt1] == 'ú') {
          localObject[paramInt1] = 10;
        }
        for (;;)
        {
          paramInt1 += 1;
          break;
          if (localObject[paramInt1] == 'þ') {
            localObject[paramInt1] = 13;
          }
        }
      }
      if (k == 511)
      {
        bool1 = true;
        paramStringBuilder = new afqh(BaseApplicationImpl.getApplication().getRuntime().getAccount());
        localEmoticon = new Emoticon();
        localObject = afgc.a((char[])localObject);
        if ((localObject == null) || (localObject.length != 2)) {
          break label334;
        }
        paramInt1 = localObject[0];
      }
    }
    for (paramInt2 = localObject[1];; paramInt2 = j)
    {
      localEmoticon.eId = String.valueOf(paramInt2);
      localEmoticon.epId = String.valueOf(paramInt1);
      localEmoticon.jobType = 3;
      paramStringBuilder.e = localEmoticon;
      boolean bool2 = bool1;
      if (!bool1)
      {
        localObject = afnu.a();
        bool2 = bool1;
        if (localObject != null)
        {
          localObject = ((ajdg)localObject).b(String.valueOf(paramInt1));
          bool2 = bool1;
          if (localObject != null)
          {
            bool2 = bool1;
            if (((EmoticonPackage)localObject).isAPNG == 2) {
              bool2 = true;
            }
          }
        }
      }
      paramStringBuilder.isAPNG = bool2;
      return paramStringBuilder;
      bool1 = false;
      break;
      if (k == 250) {
        return new afqr(7, 1, 10, "", false);
      }
      return new afqr(7, 1, k, "", false);
      label334:
      paramInt1 = 0;
    }
  }
  
  public afmi a(String paramString)
  {
    int i2;
    int k;
    int i3;
    int m;
    int j;
    if (!TextUtils.isEmpty(paramString))
    {
      int i1 = paramString.length();
      i2 = paramString.length();
      paramString = new StringBuilder().append(paramString);
      k = 0;
      if (k < i1)
      {
        i3 = paramString.codePointAt(k);
        if ((i3 == 20) && (k < i2 - 1)) {
          return a(k, i2, paramString);
        }
        m = aoff.jw(i3);
        if (i3 > 65535)
        {
          if (i2 <= k + 2) {
            break label233;
          }
          j = paramString.codePointAt(k + 2);
        }
      }
    }
    for (;;)
    {
      label101:
      if (aoff.lM(j)) {}
      for (int n = 1;; n = 0)
      {
        if ((m == -1) || (n != 0))
        {
          n = aoff.aO(i3, j);
          j = n;
          if (n != -1) {}
        }
        for (j = m;; j = m)
        {
          if (j != -1)
          {
            return new afqr(7, 2, j, "", false);
            if (i2 <= k + 1) {
              break label233;
            }
            n = paramString.codePointAt(k + 1);
            j = n;
            if (n != 65039) {
              break label101;
            }
            j = n;
            if (i2 <= k + 2) {
              break label101;
            }
            j = paramString.codePointAt(k + 2);
            break label101;
          }
          k += 1;
          break;
          return null;
        }
      }
      label233:
      j = -1;
    }
  }
  
  public URLDrawable a(Context paramContext, Emoticon paramEmoticon)
  {
    if (paramEmoticon == null) {
      return null;
    }
    float f = paramContext.getResources().getDisplayMetrics().density;
    try
    {
      paramContext = new URL("emotion_pic", "fromAIO", paramEmoticon.epId + "_" + paramEmoticon.eId);
      if (paramContext == null)
      {
        QLog.e("EmojiStickerManager", 1, "getStickerDrawable url = null");
        return null;
      }
    }
    catch (MalformedURLException paramContext)
    {
      for (;;)
      {
        QLog.e("EmojiStickerManager", 1, "getStickerDrawable url exception e = " + paramContext.getMessage());
        paramContext = null;
      }
    }
    return URLDrawable.getDrawable(paramContext, (int)(110.0F * f), (int)(f * 110.0F), this.i, this.i, true);
  }
  
  public void a(BaseChatPie paramBaseChatPie, String paramString, int paramInt, boolean paramBoolean)
  {
    paramBaseChatPie.bIP();
    this.bDK = "";
    this.mCurType = 0;
    this.bGd = 0;
    bYH = false;
    bDL = "";
    cRF = -1;
    BM = null;
    List localList = paramBaseChatPie.app.a(paramInt).l(paramString, paramInt);
    ThreadManager.post(new EmojiStickerManager.1(this, localList, paramString, paramInt, paramBoolean), 5, null, false);
    if (paramBaseChatPie.mAIORootView != null)
    {
      paramString = (TopGestureLayout)paramBaseChatPie.mAIORootView;
      GestureDetector localGestureDetector = paramString.getGestureDetector();
      if ((localGestureDetector instanceof afqm))
      {
        paramString.removeView(((afqm)localGestureDetector).b);
        bYA = false;
        paramBaseChatPie.wj(false);
        paramBaseChatPie.wj(false);
      }
      paramString.restoreGestureDetector();
    }
    kp(localList);
    this.Xw = -9223372036854775808L;
    this.Xx = -9223372036854775808L;
    this.Xy = -9223372036854775808L;
  }
  
  protected void a(QQAppInterface paramQQAppInterface, ChatXListView paramChatXListView, int paramInt, List<ChatMessage> paramList, HashMap<Pair<Long, Long>, List<ChatMessage>> paramHashMap, long paramLong, boolean paramBoolean)
  {
    if ((paramList.size() != 0) && (paramChatXListView.getChildCount() != 0) && (paramBoolean) && (this.bGd > 0)) {
      a(paramQQAppInterface, paramInt, paramList, paramLong);
    }
    if ((paramHashMap != null) && (paramHashMap.size() > 0))
    {
      if (paramList.size() <= 0) {
        break label96;
      }
      if (paramChatXListView.getChildCount() > 0)
      {
        if (this.mCurType == 0) {
          break label86;
        }
        b(paramQQAppInterface, paramList, paramHashMap);
      }
    }
    return;
    label86:
    a(paramQQAppInterface, paramList, paramHashMap);
    return;
    label96:
    a(paramList, paramQQAppInterface, paramHashMap);
  }
  
  public void a(QQAppInterface paramQQAppInterface, ChatXListView paramChatXListView, String paramString, int paramInt1, int paramInt2, List<ChatMessage> paramList)
  {
    this.bDK = paramString;
    this.mCurType = paramInt1;
    if ((paramList == null) || (paramList.size() == 0) || (paramChatXListView == null)) {
      return;
    }
    long l7 = System.currentTimeMillis();
    paramInt1 = 0;
    this.fj.clear();
    this.zO.clear();
    paramString = null;
    long l4 = -9223372036854775808L;
    long l1 = -9223372036854775808L;
    long l2 = -9223372036854775808L;
    long l3 = -9223372036854775808L;
    boolean bool = false;
    int j = paramList.size() - 1;
    label91:
    ChatMessage localChatMessage;
    long l5;
    if (j >= 0)
    {
      localChatMessage = (ChatMessage)paramList.get(j);
      if (localChatMessage == null)
      {
        l5 = l1;
        l1 = l3;
        l3 = l5;
      }
    }
    for (;;)
    {
      j -= 1;
      l5 = l3;
      l3 = l1;
      l1 = l5;
      break label91;
      Q(localChatMessage);
      if ((localChatMessage.msgtype == -2058) && (au(localChatMessage)))
      {
        long l6 = l3;
        l5 = l2;
        if (l2 == -9223372036854775808L)
        {
          l6 = l3;
          l5 = l2;
          if (l3 == -9223372036854775808L)
          {
            l6 = l3;
            l5 = l2;
            if (paramChatXListView.getAdapter() != null)
            {
              localObject = a(paramChatXListView, paramList);
              l5 = ((MessageRecord)localObject).shmsgseq;
              l6 = ((MessageRecord)localObject).time;
            }
          }
        }
        Object localObject = a(localChatMessage);
        if (a(paramList, localChatMessage, (StickerInfo)localObject))
        {
          l3 = l1;
          l1 = l6;
          l2 = l5;
        }
        else
        {
          if (!((StickerInfo)localObject).isDisplayed) {
            if (this.mCurType == 0) {
              if (localChatMessage.time > this.Xw)
              {
                this.zO.add(localChatMessage);
                if (l1 != -9223372036854775808L)
                {
                  l3 = l4;
                  l2 = l1;
                  if (((StickerInfo)localObject).hostMsgTime >= l1) {}
                }
                else
                {
                  l3 = l4;
                  l2 = l1;
                  if (((StickerInfo)localObject).hostMsgTime > this.Xy)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.i("EmojiStickerManager", 2, "new navigate seq: " + ((StickerInfo)localObject).hostMsgSeq);
                    }
                    l2 = ((StickerInfo)localObject).hostMsgTime;
                    l3 = ((StickerInfo)localObject).hostMsgSeq;
                  }
                }
                bool = a(l6, bool, (StickerInfo)localObject);
                l1 = l2;
                l2 = l3;
              }
            }
          }
          for (;;)
          {
            paramString = a(paramString, localChatMessage);
            paramInt1 = paramString.size();
            l3 = l1;
            l4 = l2;
            l1 = l6;
            l2 = l5;
            break;
            ((StickerInfo)localObject).isDisplayed = true;
            l2 = l4;
            continue;
            if ((this.mCurType == 1) || (this.mCurType == 3000))
            {
              if (localChatMessage.shmsgseq > this.Xw)
              {
                this.zO.add(localChatMessage);
                l2 = a(l4, (StickerInfo)localObject);
                bool = b(l5, bool, (StickerInfo)localObject);
              }
              else
              {
                ((StickerInfo)localObject).isDisplayed = true;
              }
            }
            else {
              l2 = l4;
            }
          }
        }
      }
      else
      {
        if (paramInt1 > 0)
        {
          paramString.remove(a(localChatMessage));
          paramInt1 = paramString.size();
          l5 = l1;
          l1 = l3;
          l3 = l5;
          continue;
          a(paramQQAppInterface, paramChatXListView, paramInt2, paramList, paramString, l4, bool);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("EmojiStickerManager", 2, "removeStickerMsgAndInsertGrayTips, cost=" + (System.currentTimeMillis() - l7));
          return;
        }
        l5 = l1;
        l1 = l3;
        l3 = l5;
      }
    }
  }
  
  public void aj(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (paramMessageRecord.msgtype == -2058) && (bYE))
    {
      Object localObject = a(paramMessageRecord);
      Pair localPair = a(paramMessageRecord);
      if ((localObject != null) && (localPair != null))
      {
        ArrayList localArrayList = (ArrayList)this.fj.get(localPair);
        localObject = localArrayList;
        if (localArrayList == null) {
          localObject = new ArrayList();
        }
        if (!((ArrayList)localObject).contains(Long.valueOf(paramMessageRecord.uniseq))) {
          ((ArrayList)localObject).add(Long.valueOf(paramMessageRecord.uniseq));
        }
        this.fj.put(localPair, localObject);
      }
    }
  }
  
  public void ak(MessageRecord paramMessageRecord)
  {
    Object localObject;
    Pair localPair;
    ArrayList localArrayList;
    if ((paramMessageRecord != null) && (paramMessageRecord.msgtype == -2058) && (bYE) && (a(paramMessageRecord) != null))
    {
      if ((paramMessageRecord.frienduin.equalsIgnoreCase(this.bDK)) && (this.mCurType == paramMessageRecord.istroop))
      {
        this.bGd = 0;
        localObject = BaseApplicationImpl.getApplication().getRuntime();
        if ((localObject instanceof QQAppInterface)) {
          this.Xw = ((QQAppInterface)localObject).a().e(this.bDK, this.mCurType);
        }
      }
      localPair = a(paramMessageRecord);
      if (localPair != null)
      {
        localArrayList = (ArrayList)this.q.get(localPair);
        if (localArrayList != null) {
          break label230;
        }
        localArrayList = new ArrayList();
      }
    }
    label230:
    for (;;)
    {
      if ((!localArrayList.contains(Long.valueOf(paramMessageRecord.uniseq))) && (localArrayList.size() < cRB)) {
        localArrayList.add(Long.valueOf(paramMessageRecord.uniseq));
      }
      localObject = "1";
      if (paramMessageRecord.istroop == 1) {
        localObject = "2";
      }
      for (;;)
      {
        VasWebviewUtil.reportCommercialDrainage("", "Stick", "Receive", (String)localObject, 1, 0, 0, null, "", "");
        this.q.put(localPair, localArrayList);
        return;
        if (paramMessageRecord.istroop == 3000) {
          localObject = "3";
        }
      }
    }
  }
  
  public void b(Messenger paramMessenger, boolean paramBoolean)
  {
    if (bYH) {
      a(paramMessenger, paramBoolean);
    }
  }
  
  public void b(BaseChatPie paramBaseChatPie, List<ChatMessage> paramList)
  {
    a(paramBaseChatPie.app, paramBaseChatPie.b, paramBaseChatPie.sessionInfo.aTl, paramBaseChatPie.sessionInfo.cZ, paramBaseChatPie.bEi, paramList);
  }
  
  public List<Long> c(MessageRecord paramMessageRecord)
  {
    if ((!bYE) || (paramMessageRecord == null) || (paramMessageRecord.shmsgseq == 0L) || (paramMessageRecord.extraflag == 32772) || (paramMessageRecord.extraflag == 32768) || (paramMessageRecord.isMultiMsg) || (paramMessageRecord.isReMultiMsg)) {}
    do
    {
      return null;
      paramMessageRecord = a(paramMessageRecord);
    } while (paramMessageRecord == null);
    return (List)this.fj.get(paramMessageRecord);
  }
  
  public void cZV()
  {
    if ((BM instanceof BaseChatItemLayout))
    {
      BaseChatItemLayout localBaseChatItemLayout = (BaseChatItemLayout)BM;
      if (localBaseChatItemLayout.qb != null)
      {
        Iterator localIterator = localBaseChatItemLayout.qb.iterator();
        while (localIterator.hasNext())
        {
          a locala = (a)localIterator.next();
          if (locala.alpha != 0) {
            locala.alpha = 255;
          }
        }
        localBaseChatItemLayout.invalidate();
      }
    }
    BM = null;
  }
  
  public Drawable d(Context paramContext)
  {
    if (this.eC == null) {
      return paramContext.getResources().getDrawable(2130840176);
    }
    return this.eC;
  }
  
  public void gs(View paramView)
  {
    BM = (ViewGroup)paramView.getParent();
    if ((BM instanceof BaseChatItemLayout))
    {
      paramView = (BaseChatItemLayout)BM;
      if (paramView.qb != null)
      {
        Iterator localIterator = paramView.qb.iterator();
        while (localIterator.hasNext())
        {
          a locala = (a)localIterator.next();
          if (locala.alpha == 255) {
            locala.alpha = 127;
          }
        }
        paramView.invalidate();
      }
    }
  }
  
  public void t(BaseChatPie paramBaseChatPie)
  {
    this.bDK = paramBaseChatPie.sessionInfo.aTl;
    this.mCurType = paramBaseChatPie.sessionInfo.cZ;
    this.bGd = paramBaseChatPie.app.a().A(this.bDK, this.mCurType);
    this.Xw = paramBaseChatPie.app.a().e(this.bDK, this.mCurType);
    this.Xy = paramBaseChatPie.app.a().j(this.bDK, this.mCurType);
    if (QLog.isColorLevel()) {
      QLog.i("EmojiStickerManager", 2, "init, unReadCnt: " + this.bGd + ", mInitLastReadSeq: " + this.Xw);
    }
  }
  
  public void u(BaseChatPie paramBaseChatPie)
  {
    long l4 = 9223372036854775807L;
    Object localObject2 = null;
    List localList = paramBaseChatPie.a.getList();
    if ((localList == null) || (localList.size() <= 0)) {
      return;
    }
    System.currentTimeMillis();
    Object localObject1 = paramBaseChatPie.b;
    int k;
    int j;
    label103:
    label117:
    long l1;
    label134:
    label149:
    label161:
    long l2;
    long l3;
    if ((localObject1 != null) && (((ChatXListView)localObject1).getAdapter() != null))
    {
      paramBaseChatPie = ((ChatXListView)localObject1).getAdapter();
      if (((ChatXListView)localObject1).getChildCount() > 0) {
        if ((paramBaseChatPie instanceof auts))
        {
          k = ((ChatXListView)localObject1).getFirstVisiblePosition();
          j = ((ChatXListView)localObject1).getLastVisiblePosition();
          if ((k < 0) || (k >= paramBaseChatPie.getCount())) {
            break label288;
          }
          if ((j < 0) || (j >= paramBaseChatPie.getCount())) {
            break label293;
          }
          localObject1 = paramBaseChatPie.getItem(k);
          paramBaseChatPie = paramBaseChatPie.getItem(j);
          if (!(localObject1 instanceof MessageRecord)) {
            break label298;
          }
          localObject1 = (MessageRecord)localObject1;
          if (!(paramBaseChatPie instanceof MessageRecord)) {
            break label314;
          }
          paramBaseChatPie = (MessageRecord)paramBaseChatPie;
          l1 = ((MessageRecord)localObject1).shmsgseq;
          l2 = ((MessageRecord)localObject1).time;
          l3 = paramBaseChatPie.shmsgseq;
          l4 = paramBaseChatPie.time;
        }
      }
    }
    for (;;)
    {
      paramBaseChatPie = localList.iterator();
      for (;;)
      {
        if (!paramBaseChatPie.hasNext()) {
          break label388;
        }
        localObject1 = (ChatMessage)paramBaseChatPie.next();
        if (((ChatMessage)localObject1).istroop == 0)
        {
          if ((((ChatMessage)localObject1).time >= l2) && (((ChatMessage)localObject1).time <= l4)) {
            continue;
          }
          ((ChatMessage)localObject1).stickerHidden = false;
          continue;
          if (!(paramBaseChatPie instanceof wki)) {
            break label393;
          }
          k = ((ChatXListView)localObject1).getFirstVisiblePosition() - ((ChatXListView)localObject1).getHeaderViewsCount();
          j = ((ChatXListView)localObject1).getLastVisiblePosition() - ((ChatXListView)localObject1).getFooterViewsCount();
          break;
          label288:
          k = 0;
          break label103;
          label293:
          j = 0;
          break label117;
          label298:
          localObject1 = (MessageRecord)localList.get(0);
          break label149;
          label314:
          paramBaseChatPie = (MessageRecord)localList.get(localList.size() - 1);
          break label161;
        }
        if (((((ChatMessage)localObject1).istroop == 1) || (((ChatMessage)localObject1).istroop == 3000)) && ((((ChatMessage)localObject1).shmsgseq < l1) || (((ChatMessage)localObject1).shmsgseq > l3))) {
          ((ChatMessage)localObject1).stickerHidden = false;
        }
      }
      label388:
      System.currentTimeMillis();
      return;
      label393:
      j = 0;
      k = 0;
      break;
      localObject1 = null;
      paramBaseChatPie = localObject2;
      break label134;
      l2 = -9223372036854775808L;
      l1 = -9223372036854775808L;
      l3 = 9223372036854775807L;
    }
  }
  
  public void v(BaseChatPie paramBaseChatPie)
  {
    if ((paramBaseChatPie != null) && (paramBaseChatPie.mAIORootView != null) && ((paramBaseChatPie.mAIORootView instanceof TopGestureLayout)))
    {
      TopGestureLayout localTopGestureLayout = (TopGestureLayout)paramBaseChatPie.mAIORootView;
      if (!(localTopGestureLayout.getGestureDetector() instanceof afqm)) {
        localTopGestureLayout.setGestureDetector(new afqm(paramBaseChatPie.mContext, localTopGestureLayout.getGestureListener(), paramBaseChatPie));
      }
    }
  }
  
  public static class EmotionKeywordLayout
    extends RelativeLayout
  {
    public boolean bYJ;
    public boolean bYK;
    BaseChatPie mBaseChatPie;
    
    public EmotionKeywordLayout(Context paramContext, BaseChatPie paramBaseChatPie)
    {
      super();
      this.mBaseChatPie = paramBaseChatPie;
    }
    
    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      switch (paramMotionEvent.getAction())
      {
      }
      for (;;)
      {
        return super.onTouchEvent(paramMotionEvent);
        if (QLog.isColorLevel()) {
          QLog.i("EmojiStickerManager", 2, "EmotionKeywordLayout.onTouchEvent ACTION_DOWN");
        }
        this.bYK = false;
        this.bYJ = false;
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("EmojiStickerManager", 2, "EmotionKeywordLayout.onTouchEvent ACTION_MOVE");
        }
        if ((this.bYJ) && (this.mBaseChatPie.mAIORootView != null))
        {
          if ((!this.bYK) && ((this.mBaseChatPie.mAIORootView instanceof TopGestureLayout)))
          {
            Object localObject = ((TopGestureLayout)this.mBaseChatPie.mAIORootView).getGestureDetector();
            if ((localObject instanceof afqm))
            {
              localObject = (afqm)localObject;
              ((afqm)localObject).lastX = paramMotionEvent.getRawX();
              ((afqm)localObject).lastY = paramMotionEvent.getRawY();
              this.bYK = true;
            }
          }
          this.mBaseChatPie.mAIORootView.onTouchEvent(paramMotionEvent);
          return true;
          if (QLog.isColorLevel()) {
            QLog.i("EmojiStickerManager", 2, "EmotionKeywordLayout.onTouchEvent ACTION_UP");
          }
          if ((this.bYJ) && (this.mBaseChatPie.mAIORootView != null))
          {
            this.mBaseChatPie.bIV();
            this.bYJ = false;
            this.bYK = false;
            this.mBaseChatPie.mAIORootView.onTouchEvent(paramMotionEvent);
            return true;
          }
          this.bYJ = false;
          this.bYK = false;
        }
      }
    }
  }
  
  public static class StickerFrameLayout
    extends RelativeLayout
  {
    ImageView yL;
    
    public StickerFrameLayout(Context paramContext)
    {
      super();
      super.setWillNotDraw(false);
    }
    
    public ImageView u()
    {
      if ((this.yL == null) && (getChildCount() >= 1))
      {
        View localView = getChildAt(0);
        if ((localView instanceof ImageView))
        {
          this.yL = ((ImageView)localView);
          return this.yL;
        }
      }
      return this.yL;
    }
  }
  
  public static class StickerInfo
    implements Serializable
  {
    public static final long serialVersionUID = 1L;
    public float height;
    public long hostMsgSeq;
    public long hostMsgTime;
    public long hostMsgUid;
    public boolean isDisplayed;
    public boolean isShown;
    public String msg = "";
    public int originMsgType;
    public int rotate;
    public float width;
    public float x;
    public float y;
    
    public static StickerInfo transformFromJson(String paramString)
    {
      if (!TextUtils.isEmpty(paramString)) {
        try
        {
          StickerInfo localStickerInfo = new StickerInfo();
          paramString = new JSONObject(paramString);
          localStickerInfo.originMsgType = paramString.optInt("originMsgType");
          localStickerInfo.x = ((float)paramString.optDouble("x"));
          localStickerInfo.y = ((float)paramString.optDouble("y"));
          localStickerInfo.width = ((float)paramString.optDouble("width"));
          localStickerInfo.height = ((float)paramString.optDouble("height"));
          localStickerInfo.rotate = paramString.optInt("rotate");
          localStickerInfo.hostMsgSeq = paramString.optLong("hostMsgSeq");
          localStickerInfo.hostMsgUid = paramString.optLong("hostMsgUid");
          localStickerInfo.hostMsgTime = paramString.optLong("hostMsgTime");
          localStickerInfo.isDisplayed = paramString.optBoolean("isDisplayed");
          localStickerInfo.isShown = paramString.optBoolean("isShown");
          localStickerInfo.msg = paramString.optString("msg");
          return localStickerInfo;
        }
        catch (Exception paramString)
        {
          QLog.e("EmojiStickerManager", 1, "StickerInfo.transformFromJson error + e = " + paramString);
        }
      }
      return null;
    }
    
    public String toJsonString()
    {
      try
      {
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("originMsgType", this.originMsgType);
        ((JSONObject)localObject).put("x", this.x);
        ((JSONObject)localObject).put("y", this.y);
        ((JSONObject)localObject).put("width", this.width);
        ((JSONObject)localObject).put("height", this.height);
        ((JSONObject)localObject).put("rotate", this.rotate);
        ((JSONObject)localObject).put("hostMsgSeq", this.hostMsgSeq);
        ((JSONObject)localObject).put("hostMsgUid", this.hostMsgUid);
        ((JSONObject)localObject).put("hostMsgTime", this.hostMsgTime);
        ((JSONObject)localObject).put("isDisplayed", this.isDisplayed);
        ((JSONObject)localObject).put("isShown", this.isShown);
        ((JSONObject)localObject).put("msg", this.msg);
        localObject = ((JSONObject)localObject).toString();
        return localObject;
      }
      catch (Exception localException)
      {
        QLog.e("EmojiStickerManager", 1, "StickerInfo.toJsonString error + e = " + localException);
      }
      return "";
    }
    
    public String toString()
    {
      return String.format("EmojiStickerInfo, originMsgType: %d,  x: %f, y: %f, width: %f, height: %f, rotate: %d, msgseq: %d, msgUid: %d", new Object[] { Integer.valueOf(this.originMsgType), Float.valueOf(this.x), Float.valueOf(this.y), Float.valueOf(this.width), Float.valueOf(this.height), Integer.valueOf(this.rotate), Long.valueOf(this.hostMsgSeq), Long.valueOf(this.hostMsgUid) });
    }
  }
  
  public static class a
  {
    public int alpha;
    public double angle;
    public int cRG;
    public int cRH;
    public int cRI;
    public int cRJ;
    public Drawable eD;
    public Drawable eE;
    public String epId;
    public int height;
    public boolean isShown;
    public float scale = 1.0F;
    public EmojiStickerManager.StickerInfo stickerInfo;
    public int top;
    public int width;
  }
  
  public static abstract interface b
  {
    public abstract void gt(View paramView);
  }
  
  public static abstract interface c
  {
    public abstract void onResult(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EmojiStickerManager
 * JD-Core Version:    0.7.0.1
 */