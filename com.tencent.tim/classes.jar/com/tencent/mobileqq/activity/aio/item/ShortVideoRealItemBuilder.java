package com.tencent.mobileqq.activity.aio.item;

import aaqi;
import aasp;
import aaza;
import aaza.c;
import aaza.d;
import acfp;
import afei;
import ahgq;
import ajlu;
import akxo;
import allg;
import allh;
import alwy;
import alyr;
import ambj;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import anfr;
import anft;
import anfu;
import angb;
import angi;
import angt;
import anhq;
import aniq;
import anjo;
import anku;
import anot;
import anpc;
import anqs;
import aojn;
import aoko;
import aonu;
import aooi;
import aoop;
import aqft;
import aqfv;
import aqhq;
import aqiw;
import aqoa;
import aqob;
import augo;
import ausj;
import auss;
import avfp;
import aviz;
import avjg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.Utils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.d;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout.a;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.a;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.view.CropBubbleVideoView;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import rar;
import rnw;
import sxx;
import ujt;
import wja;
import wko.a;
import wla.a;
import wlz;
import xlg;
import xne;
import xnf;
import xng;
import xnh;
import xni;
import xnj;
import xnk;
import xtm;

public class ShortVideoRealItemBuilder
  extends xlg
  implements anft, BaseChatItemLayout.a, wla.a
{
  protected static int bTn;
  protected static int bTo;
  protected static int bTp;
  protected static int bTq;
  protected static int bTr;
  public static int bVy;
  public static int bVz;
  public static boolean bhP;
  private static boolean bhQ;
  private static boolean bhR;
  protected static CopyOnWriteArraySet<CropBubbleVideoView> g;
  private static HashMap<String, String> gO;
  protected static ColorDrawable h = new afei(-10065297, bTn, bTo);
  private static Map<Long, MessageForShortVideo> hL;
  private static long lastClickTime;
  private aaza.c jdField_b_of_type_Aaza$c = new xnk(this);
  private ListView jdField_b_of_type_ComTencentWidgetListView;
  public long clickTime = 0L;
  private MessageForShortVideo f;
  private Handler mHandler = new Handler(Looper.getMainLooper());
  
  static
  {
    aoop.dWu();
    bhP = true;
    bVy = 960;
    bVz = 720;
    hL = new ConcurrentHashMap();
    gO = new HashMap();
    g = new CopyOnWriteArraySet();
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    bTp = BaseChatItemLayout.bNT;
    bTp = Math.min(wja.dp2px(320.0F, localResources), bTp);
    bTq = wja.dp2px(100.0F, localResources);
    bTr = wja.dp2px(100.0F, localResources);
    bTn = wja.dp2px(aniq.dHh, localResources);
    bTo = wja.dp2px(aniq.dHi, localResources);
  }
  
  public ShortVideoRealItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    if (paramAIOAnimationConatiner != null) {
      this.jdField_b_of_type_ComTencentWidgetListView = paramAIOAnimationConatiner.b();
    }
    ShortVideoUtils.B(paramQQAppInterface);
    ShortVideoUtils.a.initConfig();
    ced();
  }
  
  private boolean Ca()
  {
    if ((this.mParentView != null) && ((this.mParentView instanceof ChatXListView))) {
      return ((ChatXListView)this.mParentView).afP();
    }
    return true;
  }
  
  public static List<? extends Entity> a(EntityManager paramEntityManager, Class<? extends Entity> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramEntityManager.query(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  private void a(a parama, View paramView)
  {
    if (a(parama))
    {
      if (parama.tx == null)
      {
        parama.tx = new ImageView(this.mContext);
        parama.tx.setImageResource(2130838370);
        parama.tx.setId(2131364522);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.bottomMargin = wja.dp2px(16.0F, this.mContext.getResources());
        localLayoutParams.addRule(8, 2131364503);
        localLayoutParams.addRule(0, 2131364503);
        localLayoutParams.addRule(1, 0);
        if ((paramView instanceof ViewGroup)) {
          ((ViewGroup)paramView).addView(parama.tx, localLayoutParams);
        }
      }
      a(parama, true, this);
      return;
    }
    a(parama, false, null);
  }
  
  private void a(a parama, MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean)
  {
    if (paramMessageForShortVideo.md5 == null) {
      QQToast.a(this.mContext, 2131720235, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
    }
    String str;
    do
    {
      for (;;)
      {
        return;
        if (paramMessageForShortVideo.redBagType == LocalMediaInfo.REDBAG_TYPE_GET) {
          anjo.R(this.app, true);
        }
        aaqi.ec("", "0X8006A1C");
        aasp.c("shortvideo_bubble", null);
        rar.a("story_grp", "aio_msg", 0, 0, new String[] { "", "", "", "" });
        str = ShortVideoUtils.bw(paramMessageForShortVideo.thumbMD5, "jpg");
        if (aqhq.fileExistsAndNotEmpty(ShortVideoUtils.a(paramMessageForShortVideo, "mp4"))) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoRealItemBuilder", 2, "onClick, video file not exist");
        }
        if (paramMessageForShortVideo.videoFileStatus == 5002)
        {
          b(paramMessageForShortVideo, parama, 2131718875);
          QQToast.a(this.mContext, 2131720271, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
        }
        while (!paramMessageForShortVideo.isSend())
        {
          new alyr(BaseApplication.getContext()).a(this.app, 2001, this.sessionInfo.cZ, this.sessionInfo.aTl, 1003);
          return;
          b(paramMessageForShortVideo, false);
          a(paramMessageForShortVideo, parama, paramMessageForShortVideo.videoFileProgress, false);
        }
      }
    } while (!aqhq.fileExistsAndNotEmpty(str));
    anot.a(this.app, "CliOper", "", "", "0X800561C", "0X800561C", 0, 0, "", "", "", "");
    a(this.app, this.mContext, paramMessageForShortVideo, parama.b, this.sessionInfo, paramBoolean, false, true, true, null);
  }
  
  private void a(a parama, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if (paramBoolean) {
      if (parama.tx != null)
      {
        parama.tx.setVisibility(0);
        parama.tx.setOnClickListener(paramOnClickListener);
      }
    }
    while (parama.tx == null) {
      return;
    }
    parama.tx.setVisibility(8);
    parama.tx.setOnClickListener(null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, MessageForShortVideo paramMessageForShortVideo, View paramView, SessionInfo paramSessionInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, MessageForReplyText paramMessageForReplyText)
  {
    anot.a(paramQQAppInterface, "dc00898", "", "", "0X8007429", "0X8007429", 0, 0, "", "", "", "");
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoRealItemBuilder", 2, "enterRichMediaPreview");
    }
    if (MediaPlayerManager.a(paramQQAppInterface).isPlaying()) {
      MediaPlayerManager.a(paramQQAppInterface).stop(true);
    }
    paramView = sxx.getViewRect(paramView);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("KEY_THUMBNAL_BOUND", paramView);
    if ((((paramContext instanceof ChatActivity)) || ((paramContext instanceof SplashActivity))) && (!(paramContext instanceof MultiForwardActivity)) && (!paramSessionInfo.beB)) {
      localBundle.putInt("extra.AIO_CURRENT_PANEL_STATE", ((FragmentActivity)paramContext).getChatFragment().a().vm());
    }
    if (paramSessionInfo.cZ == 1)
    {
      localBundle.putBoolean("extra.CAN_FORWARD_TO_GROUP_ALBUM", true);
      localBundle.putString("extra.GROUP_UIN", paramSessionInfo.aTl);
      localBundle.putString("extra.GROUP_CODE", paramSessionInfo.troopUin);
    }
    if ((paramSessionInfo.cZ == 1) || (paramSessionInfo.cZ == 3000))
    {
      localBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 2);
      if (paramMessageForReplyText == null) {
        break label576;
      }
      localBundle.putBoolean("extra.IS_FROM_MULTI_MSG", paramMessageForReplyText.isMultiMsg);
      label231:
      localBundle.putLong("click_video_bubble_time", System.currentTimeMillis());
      paramView = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramView.hasNext())
      {
        paramMessageForReplyText = (ActivityManager.RunningAppProcessInfo)paramView.next();
        if (paramMessageForReplyText.processName.endsWith("mobileqq")) {
          localBundle.putInt("extra.MOBILE_QQ_PROCESS_ID", paramMessageForReplyText.pid);
        }
      }
      paramView = paramMessageForShortVideo.selfuin;
      if (!paramMessageForShortVideo.isMultiMsg) {
        break label685;
      }
    }
    label685:
    for (;;)
    {
      try
      {
        AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        paramMessageForReplyText = paramView;
        if ((localAppRuntime instanceof QQAppInterface)) {
          paramMessageForReplyText = localAppRuntime.getAccount();
        }
        paramView = paramMessageForReplyText;
      }
      catch (Exception paramMessageForReplyText)
      {
        int j;
        label576:
        continue;
        if (!(paramContext instanceof ChatHistoryActivity)) {
          continue;
        }
        int i = 2;
        continue;
        i = j;
        if (!(paramContext instanceof PublicFragmentActivity)) {
          continue;
        }
        i = j;
        if (!(((PublicFragmentActivity)paramContext).b() instanceof ChatHistoryBubbleListForTroopFragment)) {
          continue;
        }
        i = 2;
        continue;
        localBundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
        avfp.a(paramContext, localBundle, new AIOImageProviderService(paramView, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo), xtm.a(paramMessageForShortVideo), -1, i);
        continue;
      }
      localBundle.putInt("forward_source_uin_type", paramSessionInfo.cZ);
      localBundle.putString("uin", paramSessionInfo.aTl);
      j = -1;
      if ((paramContext instanceof SplashActivity))
      {
        i = 1;
        localBundle.putBoolean("muate_play", paramBoolean1);
        localBundle.putBoolean("is_one_item", paramBoolean2);
        localBundle.putBoolean("is_ReplyMsg_From_Same_Session", paramBoolean3);
        localBundle.putBoolean(avfp.cKr, paramBoolean4);
        if ((paramMessageForShortVideo.istroop != 0) || (!aqft.rj(paramMessageForShortVideo.senderuin)) || (TextUtils.isEmpty(paramMessageForShortVideo.getExtInfoFromExtStr("guide_video_type")))) {
          continue;
        }
        localBundle.putString("babyq_video_type", paramMessageForShortVideo.getExtInfoFromExtStr("guide_video_type"));
        localBundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
        avfp.a(paramContext, localBundle, new AIOImageProviderService(paramView, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo), xtm.a(paramMessageForShortVideo), 13007, i);
        if (!paramMessageForShortVideo.isSend()) {
          new alyr(BaseApplication.getContext()).a(paramQQAppInterface, 2001, paramSessionInfo.cZ, paramSessionInfo.aTl, 1001);
        }
        ShortVideoUtils.a(paramQQAppInterface, "0X8008E53", paramSessionInfo, paramMessageForShortVideo, paramContext);
        return;
        localBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 1);
        break;
        localBundle.putBoolean("extra.IS_FROM_MULTI_MSG", paramMessageForShortVideo.isMultiMsg);
        break label231;
      }
    }
  }
  
  private void a(MessageForShortVideo paramMessageForShortVideo, a parama, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (!paramMessageForShortVideo.isSend()) {
      new alyr(BaseApplication.getContext()).a(this.app, 2001, this.sessionInfo.cZ, this.sessionInfo.aTl, 1002);
    }
    c(paramMessageForShortVideo, acfp.m(2131714486) + paramString2);
    a(parama.b, paramString2, paramString1, paramMessageForShortVideo, paramInt1, paramInt2);
    if ((rnw.a(parama.mMessage.istroop, parama.mMessage)) && (!aqfv.a().b(parama.mMessage, "aio_msg|play_msg_video")))
    {
      aqfv.a().g(parama.mMessage, "aio_msg|play_msg_video");
      rar.a("aio_msg", "play_msg_video", 0, 0, new String[] { "", "", "", rnw.a((MessageForShortVideo)parama.mMessage) });
    }
    if (!aqhq.fileExistsAndNotEmpty(paramString1))
    {
      f(paramMessageForShortVideo);
      c(paramMessageForShortVideo, "getBubbleView: Video file exist and status finish. Thumb not exist.");
    }
  }
  
  private void a(MessageForShortVideo paramMessageForShortVideo, a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = b(paramMessageForShortVideo);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      bhR = true;
      this.f = paramMessageForShortVideo;
      aaza.d locald = new aaza.d(paramMessageForShortVideo.mThumbFilePath, paramMessageForShortVideo.thumbMD5, null, paramMessageForShortVideo.thumbWidth, paramMessageForShortVideo.thumbHeight);
      localObject = new aaza(this.app, this.mContext, (String)localObject, paramMessageForShortVideo.mediacodecEncode, locald, paramMessageForShortVideo);
      aaza.dn.put(Long.valueOf(paramMessageForShortVideo.uniseq), localObject);
      ((aaza)localObject).b(this.jdField_b_of_type_Aaza$c);
      ((aaza)localObject).Dm(false);
      Utils.executeAsyncTaskOnSerialExcuter((AsyncTask)localObject, new Void[] { (Void)null });
      ThreadManager.getUIHandler().post(new ShortVideoRealItemBuilder.12(this, paramBoolean1, parama, paramMessageForShortVideo, paramBoolean2));
    }
  }
  
  private void a(boolean paramBoolean, CropBubbleVideoView paramCropBubbleVideoView, MessageForShortVideo paramMessageForShortVideo, a parama, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    a(parama, paramString1, paramMessageForShortVideo, paramInt1, paramInt2);
    if ((aqhq.fileExistsAndNotEmpty(paramString2)) || ((paramMessageForShortVideo.isSend()) && (paramMessageForShortVideo.md5 == null) && (paramMessageForShortVideo.videoFileStatus == 1004)))
    {
      paramInt1 = 0;
      if ((paramMessageForShortVideo.videoFileStatus == 1005) || (paramMessageForShortVideo.extraflag == 32768) || (paramMessageForShortVideo.videoFileStatus == 1004)) {
        paramInt1 = 1;
      }
      paramCropBubbleVideoView = this.app.a().a(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
      paramInt2 = paramInt1;
      if (paramMessageForShortVideo.isSendFromLocal())
      {
        paramInt2 = paramInt1;
        if (paramMessageForShortVideo.videoFileProgress < 100)
        {
          paramInt2 = paramInt1;
          if (paramMessageForShortVideo.videoFileStatus != 1003)
          {
            paramInt2 = paramInt1;
            if (paramCropBubbleVideoView == null) {
              paramInt2 = 1;
            }
          }
        }
      }
      if (paramInt2 != 0) {
        b(paramMessageForShortVideo, parama, 2131718880);
      }
      do
      {
        return;
        if ((!ShortVideoUtils.awI()) || (!paramBoolean))
        {
          c(paramMessageForShortVideo, parama);
          return;
        }
      } while (paramMessageForShortVideo.videoFileStatus == 1003);
      if (ShortVideoUtils.aL(paramMessageForShortVideo.videoFileProgress, 10) <= 60) {}
      for (paramInt1 = 1; (paramMessageForShortVideo.busiType == 1) && (paramInt1 != 0); paramInt1 = 0)
      {
        if (paramMessageForShortVideo.progress > 60) {
          paramMessageForShortVideo.progress = 60;
        }
        a(paramMessageForShortVideo, parama, paramMessageForShortVideo.videoFileProgress, paramMessageForShortVideo.progress);
        return;
      }
      a(paramMessageForShortVideo, parama, paramMessageForShortVideo.videoFileProgress, false);
      return;
    }
    if (paramMessageForShortVideo.videoFileStatus == 2005) {
      c(paramMessageForShortVideo, parama);
    }
    if (paramMessageForShortVideo.videoFileStatus == 5002)
    {
      c(paramMessageForShortVideo, acfp.m(2131714477));
      b(paramMessageForShortVideo, parama, 2131718875);
      return;
    }
    if (this.app.a().a(paramMessageForShortVideo, true))
    {
      b(paramMessageForShortVideo, true);
      return;
    }
    if ((paramMessageForShortVideo.videoFileStatus == 2001) || (paramMessageForShortVideo.videoFileStatus == 2002) || (paramMessageForShortVideo.videoFileStatus == 2000))
    {
      a(paramMessageForShortVideo, parama, paramMessageForShortVideo.videoFileProgress, false);
      return;
    }
    c(paramMessageForShortVideo, parama);
  }
  
  private boolean a(a parama)
  {
    boolean bool2 = true;
    if ((parama.mMessage instanceof MessageForShortVideo)) {}
    for (MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)parama.mMessage;; localMessageForShortVideo = null)
    {
      if (localMessageForShortVideo == null) {
        return false;
      }
      int i;
      int j;
      if ((localMessageForShortVideo.videoFileStatus == 998) || (localMessageForShortVideo.videoFileStatus == 1002) || (localMessageForShortVideo.videoFileStatus == 1001))
      {
        i = 1;
        if ((localMessageForShortVideo.isMultiMsg) || (localMessageForShortVideo.uiOperatorFlag == 2) || (localMessageForShortVideo.busiType != 1) || (!localMessageForShortVideo.isSendFromLocal()) || (parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.Rn())) {
          break label205;
        }
        j = 1;
        label110:
        if (QLog.isColorLevel())
        {
          parama = new StringBuilder().append("shortVideoCancel needShowPauseIcon seq:").append(localMessageForShortVideo.uniseq).append(", videostatus:").append(localMessageForShortVideo.videoFileStatus).append(", iconshow:");
          if ((i == 0) || (j == 0)) {
            break label210;
          }
          bool1 = true;
          QLog.i("ShortVideoRealItemBuilder", 2, bool1);
        }
        label169:
        if ((i == 0) || (j == 0)) {
          break label216;
        }
      }
      label205:
      label210:
      label216:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        return bool1;
        i = 0;
        break;
        j = 0;
        break label110;
        bool1 = false;
        break label169;
      }
    }
  }
  
  private boolean a(a parama, MessageForShortVideo paramMessageForShortVideo, int paramInt1, int paramInt2, CropBubbleVideoView paramCropBubbleVideoView)
  {
    if ((TextUtils.isEmpty(paramMessageForShortVideo.md5)) && (paramMessageForShortVideo.videoFileStatus != 1005) && (paramMessageForShortVideo.extraflag != 32768) && (paramMessageForShortVideo.videoFileStatus != 1004))
    {
      String str1;
      if (paramMessageForShortVideo.isSendFromLocal())
      {
        String str2 = paramMessageForShortVideo.mThumbFilePath;
        str1 = str2;
        if (aqhq.fileExistsAndNotEmpty(str2)) {
          break label119;
        }
        if (!TextUtils.isEmpty(paramMessageForShortVideo.thumbMD5)) {
          break label107;
        }
        paramCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
        paramCropBubbleVideoView.showCover(aoop.getFailedDrawable());
        a(parama);
        c(paramMessageForShortVideo, "getBubbleView():You must get thumb before send video.");
      }
      label107:
      label119:
      do
      {
        do
        {
          for (;;)
          {
            return true;
            str1 = ShortVideoUtils.bw(paramMessageForShortVideo.thumbMD5, "jpg");
            if (a(paramCropBubbleVideoView, str1))
            {
              a(parama, str1, paramMessageForShortVideo, paramInt1, paramInt2);
              b(parama, paramMessageForShortVideo);
              if ((this.f == null) || ((this.f.uniseq != paramMessageForShortVideo.uniseq) && (!hL.containsKey(Long.valueOf(paramMessageForShortVideo.uniseq))))) {}
              for (paramInt1 = 1; (!paramMessageForShortVideo.mPreUpload) && (TextUtils.isEmpty(paramMessageForShortVideo.md5)) && (paramInt1 != 0) && (paramMessageForShortVideo.busiType == 1); paramInt1 = 0)
              {
                if (bhR) {
                  break label239;
                }
                a(paramMessageForShortVideo, null, false, true);
                return true;
              }
            }
          }
        } while (hL.containsKey(Long.valueOf(paramMessageForShortVideo.uniseq)));
        hL.put(Long.valueOf(paramMessageForShortVideo.uniseq), paramMessageForShortVideo);
      } while (!QLog.isColorLevel());
      label239:
      QLog.i("ShortVideoRealItemBuilder", 2, "messageMap size:" + hL.size() + ", [" + paramMessageForShortVideo.uniseq + "] added, mEncoding:" + bhR);
      return true;
    }
    return false;
  }
  
  private void b(a parama, MessageForShortVideo paramMessageForShortVideo)
  {
    parama = new WeakReference(parama);
    if (paramMessageForShortVideo.busiType == 1)
    {
      if (paramMessageForShortVideo.progressTask == null)
      {
        paramMessageForShortVideo.progressTask = new ShortVideoRealItemBuilder.1(this, paramMessageForShortVideo, parama);
        this.mHandler.removeCallbacks(paramMessageForShortVideo.progressTask);
        this.mHandler.post(paramMessageForShortVideo.progressTask);
      }
      return;
    }
    if (paramMessageForShortVideo.mShowProgressTask == null) {
      paramMessageForShortVideo.mShowProgressTask = new ShortVideoRealItemBuilder.2(this, parama, paramMessageForShortVideo);
    }
    this.mHandler.removeCallbacks(paramMessageForShortVideo.mShowProgressTask);
    this.mHandler.post(paramMessageForShortVideo.mShowProgressTask);
  }
  
  private void b(a parama, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if ((parama != null) && (parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout != null))
    {
      if (paramBoolean) {
        a(parama, false, null);
      }
      parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(paramBoolean, paramOnClickListener);
    }
  }
  
  private void c(MessageRecord paramMessageRecord, String paramString)
  {
    if (QLog.isColorLevel())
    {
      paramMessageRecord = "ShortVideoRealItemBuilder" + "[" + paramMessageRecord.uniseq + "]";
      QLog.i("ShortVideoRealItemBuilder", 2, paramMessageRecord + ":content " + paramString);
    }
  }
  
  private void cdZ()
  {
    try
    {
      if ((this.mContext != null) && ((this.mContext instanceof FragmentActivity)))
      {
        Object localObject = ((FragmentActivity)this.mContext).getChatFragment();
        if (localObject != null)
        {
          localObject = ((ChatFragment)localObject).a();
          if (localObject != null) {
            ((BaseChatPie)localObject).aG(false, false);
          }
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public static void cea()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoRealItemBuilder", 2, "pauseAllVideo");
    }
    if (g != null)
    {
      Iterator localIterator = g.iterator();
      while (localIterator.hasNext())
      {
        CropBubbleVideoView localCropBubbleVideoView = (CropBubbleVideoView)localIterator.next();
        if (localCropBubbleVideoView != null) {
          localCropBubbleVideoView.pause();
        }
      }
    }
  }
  
  public static void ceb()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoRealItemBuilder", 2, "resumeAllVideo");
    }
    if (g != null)
    {
      Iterator localIterator = g.iterator();
      while (localIterator.hasNext())
      {
        CropBubbleVideoView localCropBubbleVideoView = (CropBubbleVideoView)localIterator.next();
        if (localCropBubbleVideoView != null) {
          localCropBubbleVideoView.resume();
        }
      }
    }
  }
  
  public static void cec()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoRealItemBuilder", 2, "releaseAllVideo");
    }
    if (g != null)
    {
      Iterator localIterator = g.iterator();
      while (localIterator.hasNext())
      {
        CropBubbleVideoView localCropBubbleVideoView = (CropBubbleVideoView)localIterator.next();
        if (localCropBubbleVideoView != null)
        {
          localCropBubbleVideoView.releasePlayer(false);
          g.remove(localCropBubbleVideoView);
        }
      }
    }
  }
  
  private void ced()
  {
    int j = 720;
    int k = 540;
    Object localObject;
    int i;
    if (!bhQ)
    {
      localObject = DeviceProfileManager.a().aJ(DeviceProfileManager.DpcNames.ShortVideoHDConfig.name(), null);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoRealItemBuilder", 2, "initVideoHDConfig(), shortVideoHDConfig=" + (String)localObject);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if ((localObject != null) && (localObject.length >= 3))
        {
          if (!TextUtils.isEmpty(localObject[0])) {
            bhP = localObject[0].equals("1");
          }
          i = j;
          if (TextUtils.isEmpty(localObject[1])) {}
        }
      }
    }
    try
    {
      i = Integer.parseInt(localObject[1]);
      j = k;
      if (!TextUtils.isEmpty(localObject[2])) {}
      try
      {
        j = Integer.parseInt(localObject[2]);
        bVy = Math.max(i, j);
        bVz = Math.min(i, j);
        bhQ = true;
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoRealItemBuilder", 2, "initVideoHDConfig(), sReadHDConfig=" + bhQ + ", sHDEnable:" + bhP + ", sHDMaxLength:" + bVy + ", sHDMinLength:" + bVz);
        }
        return;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          j = k;
        }
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        i = j;
      }
    }
  }
  
  private boolean d(MessageForShortVideo paramMessageForShortVideo)
  {
    return anqs.a().d(this.mContext, 2, paramMessageForShortVideo.istroop);
  }
  
  private boolean f(MessageForShortVideo paramMessageForShortVideo)
  {
    ajlu localajlu = (ajlu)this.app.getManager(324);
    if (localajlu != null)
    {
      paramMessageForShortVideo = localajlu.a(localajlu.h(paramMessageForShortVideo));
      if ((paramMessageForShortVideo != null) && (QLog.isColorLevel())) {
        QLog.d("ShortVideoRealItemBuilder", 2, "isVideoInMultiSaving = true");
      }
      return paramMessageForShortVideo != null;
    }
    return false;
  }
  
  private void ga(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("doEncodeNext, curMsg:");
      if (this.f != null)
      {
        localObject = Long.valueOf(this.f.uniseq);
        QLog.i("ShortVideoRealItemBuilder", 2, localObject + ", seq:" + paramLong + ", contains:" + aaza.dn.containsKey(Long.valueOf(paramLong)));
      }
    }
    else
    {
      aaza.dn.remove(Long.valueOf(paramLong));
      if (this.f != null) {
        hL.remove(Long.valueOf(this.f.uniseq));
      }
      if ((this.f != null) && (this.f.progressTask != null)) {
        this.f.progressTask = null;
      }
      bhR = false;
      this.f = null;
      if (hL.size() != 0)
      {
        localObject = hL.entrySet().iterator();
        if (!((Iterator)localObject).hasNext()) {
          break label308;
        }
      }
    }
    label308:
    for (Object localObject = (MessageForShortVideo)((Map.Entry)((Iterator)localObject).next()).getValue();; localObject = null)
    {
      if (localObject != null)
      {
        ThreadManager.postImmediately(new ShortVideoRealItemBuilder.9(this, (MessageForShortVideo)localObject), null, true);
        hL.remove(Long.valueOf(((MessageForShortVideo)localObject).uniseq));
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoRealItemBuilder", 2, "messageMap size:" + hL.size() + ", [" + ((MessageForShortVideo)localObject).uniseq + "] start upload!");
        }
      }
      return;
      localObject = "";
      break;
    }
  }
  
  private void h(MessageForShortVideo paramMessageForShortVideo)
  {
    if ((paramMessageForShortVideo != null) && (paramMessageForShortVideo.progressTask != null))
    {
      this.mHandler.removeCallbacks(paramMessageForShortVideo.progressTask);
      paramMessageForShortVideo.progressTask = null;
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, wlz paramwlz)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramwlz);
    a(paramChatMessage, paramView, this);
    a((a)paramView.getTag(), paramView);
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    a locala = (a)parame;
    Context localContext = this.mContext;
    Resources localResources = localContext.getResources();
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
    parame = ShortVideoUtils.d(localMessageForShortVideo.thumbWidth, localMessageForShortVideo.thumbHeight);
    int i = parame[0];
    int j = parame[1];
    boolean bool = localMessageForShortVideo.isSend();
    parame = paramView;
    if (paramView == null)
    {
      parame = new RelativeLayout(localContext);
      paramView = (CropBubbleVideoView)allg.createCropBubbleView(this.mContext, localMessageForShortVideo.uniseq, null, bool);
      paramView.setId(2131362384);
      paramView.setVisibility(0);
      paramView.setContentDescription(acfp.m(2131714510));
      parame.addView(paramView);
      MessageProgressView localMessageProgressView = new MessageProgressView(localContext);
      parame.addView(localMessageProgressView);
      ImageView localImageView = new ImageView(localContext);
      localImageView.setImageResource(2130838136);
      localImageView.setVisibility(8);
      Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131362384);
      ((RelativeLayout.LayoutParams)localObject1).addRule(8, 2131362384);
      ((RelativeLayout.LayoutParams)localObject1).bottomMargin = wja.dp2px(10.0F, localResources);
      ((RelativeLayout.LayoutParams)localObject1).rightMargin = wja.dp2px(10.0F, localResources);
      parame.addView(localImageView, (ViewGroup.LayoutParams)localObject1);
      g.add(paramView);
      localObject1 = new LinearLayout(localContext);
      ((LinearLayout)localObject1).setOrientation(1);
      ((LinearLayout)localObject1).setGravity(17);
      Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(13);
      parame.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      localObject2 = new TextView(localContext);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.topMargin = wja.dp2px(70.0F, localResources);
      ((TextView)localObject2).setTextColor(-1);
      ((TextView)localObject2).setTextSize(2, 12.0F);
      ((TextView)localObject2).setId(2131364543);
      ((LinearLayout)localObject1).addView((View)localObject2, localLayoutParams);
      parame.setOnClickListener(this);
      super.a(parame, paramwlz);
      locala.b = paramView;
      locala.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = localMessageProgressView;
      locala.mTextView = ((TextView)localObject2);
      locala.mIcon = localImageView;
    }
    paramView = locala.b;
    if (aTl) {
      paramView.setContentDescription(acfp.m(2131714472));
    }
    locala.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
    paramView.mIsSend = localMessageForShortVideo.isSend();
    paramView.setTag(Long.valueOf(localMessageForShortVideo.uniseq));
    aqfv.a().a(Long.valueOf(localMessageForShortVideo.uniseq), localMessageForShortVideo);
    locala.mTextView.setVisibility(8);
    a(locala, localMessageForShortVideo);
    paramwlz = locala.b.getLayoutParams();
    if (paramwlz == null)
    {
      paramwlz = new RelativeLayout.LayoutParams(i, j);
      locala.b.setLayoutParams(paramwlz);
      paramwlz = locala.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getLayoutParams();
      if (paramwlz != null) {
        break label705;
      }
      paramwlz = new RelativeLayout.LayoutParams(i, j);
      locala.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams(paramwlz);
    }
    for (;;)
    {
      if (paramBaseChatItemLayout != null)
      {
        a(this.app, paramBaseChatItemLayout, this.sessionInfo, paramChatMessage, this);
        if ((!(this.mContext instanceof MultiForwardActivity)) && (!this.sessionInfo.beB))
        {
          a(this.app, paramBaseChatItemLayout, locala, paramChatMessage);
          anjo.a(parame, locala, paramChatMessage, localContext);
        }
      }
      g(localMessageForShortVideo);
      a(localMessageForShortVideo, locala, localResources, bool);
      if (!a(locala, localMessageForShortVideo, i, j, paramView)) {
        break label752;
      }
      return parame;
      if ((paramwlz.width == i) && (paramwlz.height == j)) {
        break;
      }
      paramwlz.width = i;
      paramwlz.height = j;
      locala.b.setLayoutParams(paramwlz);
      break;
      label705:
      if ((paramwlz.width != i) || (paramwlz.height != j))
      {
        paramwlz.width = i;
        paramwlz.height = j;
        locala.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams(paramwlz);
      }
    }
    label752:
    paramChatMessage = ShortVideoUtils.bw(localMessageForShortVideo.thumbMD5, "jpg");
    paramBaseChatItemLayout = ShortVideoUtils.a(localMessageForShortVideo, "mp4");
    bool = d(localMessageForShortVideo);
    if ((bool) && (aqhq.fileExistsAndNotEmpty(paramBaseChatItemLayout)) && ((!localMessageForShortVideo.isSendFromLocal()) || (localMessageForShortVideo.videoFileStatus == 1003) || (localMessageForShortVideo.videoFileStatus == 2003) || (localMessageForShortVideo.isMultiMsg == true)))
    {
      a(localMessageForShortVideo, locala, paramChatMessage, paramBaseChatItemLayout, i, j);
      return parame;
    }
    if (aqhq.fileExistsAndNotEmpty(paramChatMessage))
    {
      a(bool, paramView, localMessageForShortVideo, locala, paramChatMessage, paramBaseChatItemLayout, i, j);
      return parame;
    }
    if (localMessageForShortVideo.videoFileStatus == 5002)
    {
      c(localMessageForShortVideo, acfp.m(2131714503));
      paramView.setID(localMessageForShortVideo.uniseq);
      paramView.showCover(h);
      b(localMessageForShortVideo, locala, 2131718875);
      return parame;
    }
    c(localMessageForShortVideo, acfp.m(2131714524));
    paramView.setID(localMessageForShortVideo.uniseq);
    paramView.showCover(h);
    f(localMessageForShortVideo);
    return parame;
  }
  
  public aqoa a(aqoa paramaqoa, ChatMessage paramChatMessage, wko.a parama)
  {
    int k = 0;
    paramChatMessage = (MessageForShortVideo)paramChatMessage;
    parama = (a)parama;
    b(paramaqoa, this.mContext);
    int j = k;
    if (!TextUtils.isEmpty(paramChatMessage.md5)) {
      if (paramChatMessage.mPreUpload)
      {
        j = k;
        if (TextUtils.isEmpty(paramChatMessage.mLocalMd5)) {}
      }
      else
      {
        String str = ShortVideoUtils.bw(paramChatMessage.thumbMD5, "jpg");
        paramChatMessage = ShortVideoUtils.a(paramChatMessage, "mp4");
        j = k;
        if (aqhq.fileExistsAndNotEmpty(str)) {
          if ((parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.sc == null) || (parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.sc.getVisibility() != 0)) {
            break label185;
          }
        }
      }
    }
    label185:
    for (int i = 1;; i = 0)
    {
      j = k;
      if (i == 0)
      {
        paramaqoa.Z(2131367523, this.mContext.getString(2131721067), 2130839086);
        j = k;
        if (aqhq.fileExistsAndNotEmpty(paramChatMessage)) {
          j = 1;
        }
      }
      if (j != 0) {
        paramaqoa.Z(2131366733, this.mContext.getString(2131693407), 2130839085);
      }
      return paramaqoa;
    }
  }
  
  public BaseBubbleBuilder.d a(View paramView)
  {
    return null;
  }
  
  public BaseBubbleBuilder.e a()
  {
    return new a();
  }
  
  public a a(long paramLong)
  {
    if ((this.jdField_b_of_type_ComTencentWidgetListView != null) && (paramLong > 0L))
    {
      int i = wja.a(paramLong, this.jdField_b_of_type_ComTencentWidgetListView.getAdapter());
      int j = this.jdField_b_of_type_ComTencentWidgetListView.getHeaderViewsCount();
      int k = this.jdField_b_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
      int m = this.jdField_b_of_type_ComTencentWidgetListView.getLastVisiblePosition();
      if (i <= -1) {
        break label225;
      }
      Object localObject = wja.a(this.jdField_b_of_type_ComTencentWidgetListView, i);
      if (localObject != null)
      {
        localObject = wja.a((View)localObject);
        if ((localObject != null) && ((localObject instanceof a))) {
          return (a)localObject;
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.w("ShortVideoRealItemBuilder", 2, "getHolderByMsg() uniseq=" + paramLong + ", posi =" + i + ", view = null");
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoRealItemBuilder", 2, "getHolderByMsg() uniseq=" + paramLong + ", posi =" + i + ", firstVisblePosi=" + k + ",lastVisblePosi=" + m + ",headerCount=" + j);
      }
    }
    for (;;)
    {
      return null;
      label225:
      if (QLog.isColorLevel()) {
        QLog.w("ShortVideoRealItemBuilder", 2, "getHolderByMsg() uniseq=" + paramLong + ", posi<= -1");
      }
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    MessageForShortVideo localMessageForShortVideo;
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForShortVideo)))
    {
      localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
      if (paramInt != 2131365686) {
        break label77;
      }
      ujt.b(this.mContext, this.app, localMessageForShortVideo);
      rar.a("story_grp", "press_msg", 0, 0, new String[] { "4", "", "", "" });
    }
    label77:
    do
    {
      do
      {
        return;
        if (paramInt == 2131372073)
        {
          super.m(paramChatMessage);
          rar.a("story_grp", "press_msg", 0, 0, new String[] { "5", "", "", "" });
          return;
        }
        if (paramInt == 2131367523)
        {
          paramInt = akxo.b(this.app, paramChatMessage.istroop, paramChatMessage.frienduin);
          if (paramInt == 3) {
            paramContext = "1";
          }
          for (;;)
          {
            anot.a(this.app, "CliOper", "", "", "0X8005624", "0X8005624", 0, 0, paramContext, "", "", "");
            rar.a("story_grp", "press_msg", 0, 0, new String[] { "1", "", "", "" });
            d(localMessageForShortVideo);
            if (!paramChatMessage.isMultiMsg) {
              break;
            }
            anot.a(this.app, "dc00898", "", "", "0X8009D66", "0X8009D66", 5, 0, "5", "", "", "");
            return;
            if (paramInt == 2) {
              paramContext = "2";
            } else if (paramInt == 0) {
              paramContext = "3";
            } else {
              paramContext = "4";
            }
          }
        }
        if (paramInt != 2131366733) {
          break;
        }
        aviz.a(localMessageForShortVideo).b(this.app, paramChatMessage).b((Activity)this.mContext, this.app.getAccount());
        avjg.a(this.app, 3, 0, paramChatMessage.istroop);
        avjg.a(this.app, 6, 5);
        rar.a("story_grp", "press_msg", 0, 0, new String[] { "2", "", "", "" });
      } while (!paramChatMessage.isMultiMsg);
      anot.a(this.app, "dc00898", "", "", "0X8009D67", "0X8009D67", 5, 0, "5", "", "", "");
      return;
      if (paramInt == 2131372030)
      {
        super.j(localMessageForShortVideo);
        rar.a("story_grp", "press_msg", 0, 0, new String[] { "3", "", "", "" });
        return;
      }
      if (paramInt == 2131365642)
      {
        paramContext = new StringBuilder();
        paramContext.append("uniseq:").append(localMessageForShortVideo.uniseq).append("\n");
        Toast.makeText(this.mContext, paramContext.toString(), 1).show();
        return;
      }
      if (paramInt != 2131372134) {
        break label665;
      }
      paramContext = a(localMessageForShortVideo.uniseq);
      if (paramContext != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ShortVideoRealItemBuilder", 2, "onMenuItemClicked(), mute_play, holder == null, mr.uniseq = " + localMessageForShortVideo.uniseq);
    return;
    a(paramContext, localMessageForShortVideo, true);
    anot.a(null, "dc00898", "", "", "0X8009F65", "0X8009F65", 1, 0, "", "", "", "");
    return;
    label665:
    if (paramInt == 2131377998)
    {
      ((augo)this.app.getManager(374)).B(paramChatMessage);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  public void a(View paramView, aoko paramaoko, int paramInt1, int paramInt2)
  {
    paramView = wja.a(paramView);
    if (!(paramView instanceof a)) {}
    MessageForShortVideo localMessageForShortVideo;
    int i;
    int j;
    label188:
    label195:
    do
    {
      do
      {
        do
        {
          return;
          paramView = (a)paramView;
          localMessageForShortVideo = (MessageForShortVideo)paramView.mMessage;
        } while (localMessageForShortVideo.uniseq != paramaoko.uniseq);
        this.mHandler.removeCallbacks(localMessageForShortVideo.mShowProgressTask);
        if (localMessageForShortVideo.mShowProgressTask != null) {
          localMessageForShortVideo.mShowProgressTask = null;
        }
      } while (this.mContext == null);
      Resources localResources = this.mContext.getResources();
      if (localMessageForShortVideo.thumbWidth > 0)
      {
        paramInt1 = localMessageForShortVideo.thumbWidth;
        if (localMessageForShortVideo.thumbHeight <= 0) {
          break label188;
        }
      }
      for (paramInt2 = localMessageForShortVideo.thumbHeight;; paramInt2 = 100)
      {
        i = wja.dp2px(paramInt1, localResources);
        j = wja.dp2px(paramInt2, localResources);
        if ((paramaoko.fileType != 6) && (paramaoko.fileType != 17) && (paramaoko.fileType != 9) && (paramaoko.fileType != 20)) {
          break label195;
        }
        a(paramaoko, paramView, localMessageForShortVideo, paramInt1, paramInt2, i, j);
        return;
        paramInt1 = 100;
        break;
      }
    } while ((paramaoko.fileType != 7) && (paramaoko.fileType != 18) && (paramaoko.fileType != 16));
    b(paramaoko, paramView, localMessageForShortVideo, paramInt1, paramInt2, i, j);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    int i = this.mContext.getResources().getDimensionPixelSize(2131296410);
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.bNY, BaseChatItemLayout.bNV, i, BaseChatItemLayout.bNW);
      return;
    }
    paramView.setPadding(i, BaseChatItemLayout.bNV, BaseChatItemLayout.bNY, BaseChatItemLayout.bNW);
  }
  
  public void a(aoko paramaoko, a parama, MessageForShortVideo paramMessageForShortVideo, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    switch (paramaoko.status)
    {
    default: 
    case 1007: 
    case 1001: 
    case 1003: 
    case 1005: 
    case 1004: 
    case 1002: 
    case 2001: 
    case 2003: 
    case 5001: 
    case 2005: 
      do
      {
        do
        {
          return;
          a(parama, false, null);
          aaza.dn.remove(Long.valueOf(paramMessageForShortVideo.uniseq));
          c(paramMessageForShortVideo, "VIDEO STATUS_UPLOAD_FINISHED progress " + paramMessageForShortVideo.videoFileProgress);
          return;
          c(paramMessageForShortVideo, "VIDEO STATUS_SEND_START progress " + paramMessageForShortVideo.videoFileProgress);
          if (paramMessageForShortVideo.busiType != 1) {
            a(paramMessageForShortVideo, parama, paramMessageForShortVideo.videoFileProgress, true);
          }
          parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
          aaza.dn.remove(Long.valueOf(paramMessageForShortVideo.uniseq));
          return;
          c(paramMessageForShortVideo, "VIDEO STATUS_SEND_FINISHED");
          h(paramMessageForShortVideo);
          xY(paramMessageForShortVideo.mVideoFileSourceDir);
          a(paramMessageForShortVideo, parama, 100, true);
          a(parama, false, null);
          aaza.dn.remove(Long.valueOf(paramMessageForShortVideo.uniseq));
          return;
          c(paramMessageForShortVideo, "VIDEO STATUS_SEND_ERROR");
          h(paramMessageForShortVideo);
          b(paramMessageForShortVideo, parama, 2131718880);
          parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
          aaza.dn.remove(Long.valueOf(paramMessageForShortVideo.uniseq));
          return;
          c(paramMessageForShortVideo, "VIDEO STATUS_SEND_CANCEL");
          parama.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.Wt(parama.mMessage.frienduin + parama.mMessage.uniseq);
          h(paramMessageForShortVideo);
          a(parama);
          b(paramMessageForShortVideo, parama, 2131718880);
          b(parama, true, this);
          aaza.dn.remove(Long.valueOf(paramMessageForShortVideo.uniseq));
          return;
          paramInt1 = paramMessageForShortVideo.videoFileProgress;
          c(paramMessageForShortVideo, "VIDEO STATUS_SEND_PROCESS " + paramInt1);
          a(paramMessageForShortVideo, parama, paramInt1);
          return;
          c(paramMessageForShortVideo, "VIDEO STATUS_RECV_START");
          a(paramMessageForShortVideo, parama, paramMessageForShortVideo.videoFileProgress, true);
          return;
          c(paramMessageForShortVideo, "VIDEO STATUS_RECV_FINISHED");
          if (!d(paramMessageForShortVideo)) {
            break;
          }
          paramaoko = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
          c(paramMessageForShortVideo, acfp.m(2131714507) + paramaoko);
          if ((ShortVideoUtils.awI()) && (aqhq.fileExistsAndNotEmpty(paramaoko)))
          {
            c(paramMessageForShortVideo, acfp.m(2131714519) + paramaoko);
            String str = ShortVideoUtils.bw(paramMessageForShortVideo.thumbMD5, "jpg");
            a(parama.b, paramaoko, str, paramMessageForShortVideo, paramInt1, paramInt2);
            if (!paramMessageForShortVideo.isSend()) {
              new alyr(BaseApplication.getContext()).a(this.app, 2001, this.sessionInfo.cZ, this.sessionInfo.aTl, 1002);
            }
          }
          a(paramMessageForShortVideo, parama, 100, true);
        } while (!paramMessageForShortVideo.isMultiMsg);
        a(parama);
        return;
        a(parama, ShortVideoUtils.bw(paramMessageForShortVideo.thumbMD5, "jpg"), paramMessageForShortVideo, paramInt3, paramInt4);
        c(paramMessageForShortVideo, parama);
        return;
        c(paramMessageForShortVideo, "VIDEO STATUS_FILE_UNSAFE");
        b(paramMessageForShortVideo, parama, 2131718874);
        if (paramMessageForShortVideo.uiOperatorFlag == 2)
        {
          parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
          QQToast.a(this.mContext, 2131720245, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
          return;
        }
        QQToast.a(this.mContext, 2131720270, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
        return;
        c(paramMessageForShortVideo, "VIDEO STATUS_RECV_ERROR");
        a(parama);
        c(paramMessageForShortVideo, parama);
      } while (paramaoko.errorCode == -5100528);
      QQToast.a(this.mContext, 2131720272, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
      return;
    case 5002: 
      c(paramMessageForShortVideo, "VIDEO STATUS_FILE_EXPIRED");
      a(parama, ShortVideoUtils.bw(paramMessageForShortVideo.thumbMD5, "jpg"), paramMessageForShortVideo, paramInt3, paramInt4);
      b(paramMessageForShortVideo, parama, 2131718875);
      return;
    case 2004: 
      c(paramMessageForShortVideo, "VIDEO STATUS_RECV_CANCEL");
      return;
    }
    paramInt1 = paramMessageForShortVideo.videoFileProgress;
    c(paramMessageForShortVideo, "VIDEO STATUS_RECV_PROCESS " + paramInt1);
    a(paramMessageForShortVideo, parama, paramInt1, true);
  }
  
  public void a(a parama)
  {
    if (!parama.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.sd(parama.mMessage.frienduin + parama.mMessage.uniseq)) {
      parama.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(8);
    }
    for (;;)
    {
      parama.mTextView.setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.w("ShortVideoRealItemBuilder", 2, "[hideProgress] set mProgressView gone");
      }
      return;
      parama.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimRunnableListener(new xni(this, parama));
    }
  }
  
  protected void a(a parama, MessageForShortVideo paramMessageForShortVideo)
  {
    parama.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setRadius(6.0F, true);
    parama.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setShowCorner(false);
    parama.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setCornerDirection(paramMessageForShortVideo.isSend());
    parama.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.bind(paramMessageForShortVideo.frienduin + paramMessageForShortVideo.uniseq);
    if ((paramMessageForShortVideo.fileType == 6) || (paramMessageForShortVideo.fileType == 17) || (paramMessageForShortVideo.fileType == 9) || (paramMessageForShortVideo.fileType == 20))
    {
      if ((paramMessageForShortVideo.videoFileStatus == 1003) || (paramMessageForShortVideo.videoFileStatus == 2003)) {
        b(parama);
      }
    }
    else {
      return;
    }
    parama.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
  }
  
  public void a(a parama, String paramString, MessageForShortVideo paramMessageForShortVideo, int paramInt1, int paramInt2)
  {
    if ((aqhq.fileExistsAndNotEmpty(paramString)) && (a(parama.b, paramString)))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = paramInt1;
      localURLDrawableOptions.mRequestHeight = paramInt2;
      localURLDrawableOptions.mLoadingDrawable = h;
      localURLDrawableOptions.mFailedDrawable = h;
      paramString = URLDrawable.getDrawable(new File(paramString), localURLDrawableOptions);
      parama.b.setID(paramMessageForShortVideo.uniseq);
      parama.b.showCover(paramString);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseChatItemLayout paramBaseChatItemLayout, a parama, MessageRecord paramMessageRecord)
  {
    boolean bool2 = false;
    if ((paramMessageRecord instanceof MessageForShortVideo))
    {
      paramMessageRecord = (MessageForShortVideo)paramMessageRecord;
      if (paramMessageRecord.redBagType != LocalMediaInfo.REDBAG_TYPE_GET) {
        break label108;
      }
      if (parama.bVA != LocalMediaInfo.REDBAG_TYPE_GET) {
        break label40;
      }
    }
    label40:
    label108:
    do
    {
      do
      {
        return;
        parama.bVA = LocalMediaInfo.REDBAG_TYPE_GET;
        paramQQAppInterface = new xne(this, paramQQAppInterface);
        parama = new SpannableString(this.mContext.getResources().getString(2131720248));
        parama.setSpan(new ForegroundColorSpan(-1), 0, parama.length(), 17);
        paramBaseChatItemLayout.setTailMessage(true, parama, paramQQAppInterface, anjo.axB());
        return;
        if ((!paramMessageRecord.CheckIsDanceVideo()) || (!anhq.ly(this.sessionInfo.cZ))) {
          break;
        }
      } while (parama.bVA == 2);
      parama.bVA = 2;
      boolean bool3 = alwy.auJ();
      boolean bool4 = anku.z(paramQQAppInterface);
      paramQQAppInterface = new xnf(this, bool3, bool4, paramQQAppInterface);
      parama = new SpannableString(this.mContext.getResources().getString(2131720236));
      parama.setSpan(new ForegroundColorSpan(-1), 0, parama.length(), 17);
      boolean bool1 = bool2;
      if (bool3)
      {
        bool1 = bool2;
        if (bool4) {
          bool1 = true;
        }
      }
      paramBaseChatItemLayout.setTailMessage(true, parama, paramQQAppInterface, bool1);
      return;
    } while (parama.bVA == 0);
    parama.bVA = 0;
    paramBaseChatItemLayout.setTailMessage(false, null, null);
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, long paramLong)
  {
    if ((paramMessageForShortVideo != null) && (!aqfv.a().b(paramMessageForShortVideo, "0X8009AA6")))
    {
      aqfv.a().g(paramMessageForShortVideo, "0X8009AA6");
      ShortVideoUtils.a(this.app, this.sessionInfo.cZ, paramMessageForShortVideo.frienduin, 1, 2, paramMessageForShortVideo.videoFileTime * 1000, paramLong);
    }
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, a parama)
  {
    c(paramMessageForShortVideo, "startUploadVideo：" + paramMessageForShortVideo.toString());
    Object localObject = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    String str = ShortVideoUtils.bw(paramMessageForShortVideo.thumbMD5, "jpg");
    if (!aqhq.fileExistsAndNotEmpty((String)localObject))
    {
      QQToast.a(this.mContext, 1, 2131720277, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
      parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    if (!aqhq.fileExistsAndNotEmpty(str))
    {
      QQToast.a(this.mContext, 1, 2131720278, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
      parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    ((ambj)this.app.getManager(326)).a(this.sessionInfo.aTl, paramMessageForShortVideo, paramMessageForShortVideo.videoFileName);
    localObject = anfr.a(1, 2);
    ((angi)localObject).c(anfr.a(2, paramMessageForShortVideo, (angi)localObject));
    anfr.a((angi)localObject, this.app);
    a(paramMessageForShortVideo, parama, paramMessageForShortVideo.videoFileProgress, true);
  }
  
  void a(MessageForShortVideo paramMessageForShortVideo, a parama, int paramInt)
  {
    int i = ShortVideoUtils.aL(paramInt, 10);
    if (paramMessageForShortVideo.busiType == 1)
    {
      if (i < 60) {
        return;
      }
      if (paramMessageForShortVideo.progressTask != null)
      {
        this.mHandler.removeCallbacks(paramMessageForShortVideo.progressTask);
        paramMessageForShortVideo.progressTask = null;
        c(paramMessageForShortVideo, "VIDEO STATUS_SEND_PROCESS CLOSE_TASK PROCESS:" + i);
      }
    }
    a(paramMessageForShortVideo, parama, paramInt, true);
  }
  
  protected void a(MessageForShortVideo paramMessageForShortVideo, a parama, int paramInt1, int paramInt2)
  {
    if ((ShortVideoUtils.aL(paramMessageForShortVideo.videoFileProgress, 10) > 60) || (paramInt2 > 60)) {}
    do
    {
      return;
      paramInt2 = ShortVideoUtils.aL(paramInt2, 0);
      parama.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
      parama.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(paramInt2, paramMessageForShortVideo.frienduin + paramMessageForShortVideo.uniseq);
      parama.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
      parama.mTextView.setVisibility(8);
      if ((paramMessageForShortVideo.progressTask != null) && (aqiw.isNetSupport(this.mContext)))
      {
        paramMessageForShortVideo.progress += 3;
        this.mHandler.postDelayed(paramMessageForShortVideo.progressTask, 1000L);
      }
    } while (!QLog.isColorLevel());
    QLog.w("ShortVideoRealItemBuilder", 2, "[setProgress] uinseq:" + paramMessageForShortVideo.uniseq + ", p:" + paramInt1 + ", progress:" + paramInt2);
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, a parama, int paramInt, boolean paramBoolean)
  {
    parama.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
    parama.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(paramInt, paramMessageForShortVideo.frienduin + paramMessageForShortVideo.uniseq);
    parama.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    parama.mTextView.setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.w("ShortVideoRealItemBuilder", 2, "[setProgress] uinseq:" + paramMessageForShortVideo.uniseq + ", p:" + paramInt);
    }
  }
  
  protected void a(MessageForShortVideo paramMessageForShortVideo, a parama, Resources paramResources, boolean paramBoolean)
  {
    int i = Math.max(paramMessageForShortVideo.thumbWidth, paramMessageForShortVideo.thumbHeight);
    int j = Math.min(paramMessageForShortVideo.thumbWidth, paramMessageForShortVideo.thumbHeight);
    if ((bhP) && (i >= bVy) && (j >= bVz))
    {
      paramMessageForShortVideo = (RelativeLayout.LayoutParams)parama.mIcon.getLayoutParams();
      if (paramBoolean) {}
      for (paramMessageForShortVideo.rightMargin = wja.dp2px(parama.b.getTriaWidth() + 8.0F, paramResources);; paramMessageForShortVideo.rightMargin = wja.dp2px(8.0F, paramResources))
      {
        parama.mIcon.setVisibility(0);
        return;
      }
    }
    parama.mIcon.setVisibility(8);
  }
  
  protected void a(CropBubbleVideoView paramCropBubbleVideoView, String paramString1, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("playShortVideoByPath uniseq=").append(paramMessageForShortVideo.uniseq).append(", videoPath = ");
      if (paramString1 != null)
      {
        localObject = paramString1;
        localStringBuilder = localStringBuilder.append((String)localObject).append(", thumbPath = ");
        if (paramString2 == null) {
          break label224;
        }
        localObject = paramString2;
        label64:
        QLog.d("ShortVideoRealItemBuilder", 2, (String)localObject);
      }
    }
    else
    {
      paramCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
      localObject = new VideoPlayParam();
      ((VideoPlayParam)localObject).mSceneId = 100;
      ((VideoPlayParam)localObject).mSceneName = allh.eO(100);
      ((VideoPlayParam)localObject).mIsMute = true;
      ((VideoPlayParam)localObject).mCallback = new xng(this);
      ((VideoPlayParam)localObject).mIsLocal = true;
      ((VideoPlayParam)localObject).mIsLoop = true;
      ((VideoPlayParam)localObject).mVideoPath = paramString1;
      ((VideoPlayParam)localObject).mFileSize = paramMessageForShortVideo.videoFileSize;
      paramCropBubbleVideoView.setVideoParam((VideoPlayParam)localObject);
      paramString1 = new afei(-10065297, 100, 100);
      if (!TextUtils.isEmpty(paramString2)) {
        break label232;
      }
      paramCropBubbleVideoView.setCoverDrawable(paramString1);
    }
    for (;;)
    {
      if (Ca()) {
        paramCropBubbleVideoView.play();
      }
      g.add(paramCropBubbleVideoView);
      return;
      localObject = "null";
      break;
      label224:
      localObject = "null";
      break label64;
      label232:
      paramCropBubbleVideoView.setCoverDrawable(URLDrawable.getDrawable(ShortVideoUtils.j(paramString2).toString(), paramInt1, paramInt2, paramString1, paramString1));
    }
  }
  
  public boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (paramChatMessage.isMultiMsg) {}
    do
    {
      do
      {
        do
        {
          return false;
        } while (!paramChatMessage.isSendFromLocal());
        paramChatMessage = (MessageForShortVideo)paramChatMessage;
        if ((paramChatMessage.md5 == null) && (paramChatMessage.videoFileStatus == 1004)) {
          return true;
        }
      } while ((paramChatMessage.md5 == null) || (paramChatMessage.videoFileStatus == 5002));
      if ((paramChatMessage.busiType == 1) && (paramChatMessage.uiOperatorFlag == 1) && (paramChatMessage.videoFileStatus == 1004)) {
        return true;
      }
      paramBaseChatItemLayout = this.app.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
      if ((paramBaseChatItemLayout instanceof aojn))
      {
        if (((aojn)paramBaseChatItemLayout).hh() == 1005L) {}
        for (boolean bool = true;; bool = false) {
          return bool;
        }
      }
      if (paramChatMessage.videoFileStatus == 1005) {
        return true;
      }
    } while ((paramChatMessage.videoFileProgress == 100) || (paramChatMessage.videoFileStatus == 1003) || (paramChatMessage.videoFileStatus == 2003) || (paramChatMessage.isAllowAutoDown != true));
    return true;
  }
  
  protected boolean a(CropBubbleVideoView paramCropBubbleVideoView, String paramString)
  {
    paramCropBubbleVideoView = paramCropBubbleVideoView.getCoverDrawable();
    if (paramCropBubbleVideoView == null) {
      return true;
    }
    return (!(paramCropBubbleVideoView instanceof URLDrawable)) || (!((URLDrawable)paramCropBubbleVideoView).getURL().getPath().equals(paramString));
  }
  
  public aqob[] a(View paramView)
  {
    aqoa localaqoa = new aqoa();
    paramView = (a)wja.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.mMessage;
    if (localMessageForShortVideo != null)
    {
      if (!localMessageForShortVideo.isMultiMsg) {
        break label48;
      }
      a(localaqoa, localMessageForShortVideo, paramView);
    }
    for (;;)
    {
      return localaqoa.a();
      label48:
      b(localaqoa, localMessageForShortVideo, paramView);
    }
  }
  
  public aqoa b(aqoa paramaqoa, ChatMessage paramChatMessage, wko.a parama)
  {
    int m = 1;
    int j = 0;
    int i = 0;
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
    parama = (a)parama;
    b(paramaqoa, this.mContext);
    int k;
    label167:
    int n;
    if ((!TextUtils.isEmpty(localMessageForShortVideo.md5)) && ((!localMessageForShortVideo.mPreUpload) || (!TextUtils.isEmpty(localMessageForShortVideo.mLocalMd5))))
    {
      String str1 = ShortVideoUtils.bw(localMessageForShortVideo.thumbMD5, "jpg");
      String str2 = ShortVideoUtils.a(localMessageForShortVideo, "mp4");
      if (aqhq.fileExistsAndNotEmpty(str1)) {
        if ((parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.sc != null) && (parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.sc.getVisibility() == 0))
        {
          k = 1;
          if (k == 0)
          {
            paramaqoa.Z(2131367523, this.mContext.getString(2131721067), 2130839086);
            a(localMessageForShortVideo, paramaqoa);
            j = m;
            if (aqhq.fileExistsAndNotEmpty(str2))
            {
              i = 1;
              j = m;
            }
            m = i;
            n = j;
            if (k == 0)
            {
              a(paramaqoa, this.sessionInfo.cZ, localMessageForShortVideo);
              n = j;
            }
          }
        }
      }
    }
    for (m = i;; m = j)
    {
      a(paramaqoa, localMessageForShortVideo);
      if (m != 0) {
        paramaqoa.Z(2131366733, this.mContext.getString(2131693407), 2130839085);
      }
      super.a(paramaqoa, this.mContext, paramChatMessage);
      if (n != 0) {
        b(localMessageForShortVideo, paramaqoa);
      }
      super.c(paramaqoa, this.mContext);
      super.e(paramaqoa, this.mContext);
      if (augo.g(this.app, localMessageForShortVideo)) {
        paramaqoa.Z(2131377998, this.mContext.getString(2131719492), 2130840517);
      }
      return paramaqoa;
      j = 0;
      break label167;
      k = 0;
      break;
      n = 0;
    }
  }
  
  public String b(ChatMessage paramChatMessage)
  {
    return acfp.m(2131714525);
  }
  
  public String b(MessageForShortVideo paramMessageForShortVideo)
  {
    paramMessageForShortVideo = paramMessageForShortVideo.mVideoFileSourceDir + File.separator + "configure.txt";
    if (!aqhq.fileExistsAndNotEmpty(paramMessageForShortVideo))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoRealItemBuilder", 2, "configure file empty!");
      }
      return null;
    }
    try
    {
      paramMessageForShortVideo = aqhq.readFileToString(new File(paramMessageForShortVideo));
      if (paramMessageForShortVideo == null) {
        break label98;
      }
      paramMessageForShortVideo = paramMessageForShortVideo.replaceAll("[\\t\\n\\r]", "");
      boolean bool = TextUtils.isEmpty(paramMessageForShortVideo);
      if (bool) {
        break label98;
      }
    }
    catch (Exception paramMessageForShortVideo)
    {
      for (;;)
      {
        paramMessageForShortVideo.printStackTrace();
        paramMessageForShortVideo = null;
      }
    }
    return paramMessageForShortVideo;
  }
  
  public void b(aoko paramaoko, a parama, MessageForShortVideo paramMessageForShortVideo, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    String str;
    switch (paramaoko.status)
    {
    default: 
    case 2001: 
    case 2003: 
      do
      {
        do
        {
          return;
          c(paramMessageForShortVideo, "THUMB STATUS_RECV_START");
          return;
          c(paramMessageForShortVideo, "THUMB STATUS_RECV_FINISHED");
          paramaoko = ShortVideoUtils.bw(paramMessageForShortVideo.thumbMD5, "jpg");
          str = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
          if ((!aqhq.fileExistsAndNotEmpty(str)) || (!d(paramMessageForShortVideo))) {
            break;
          }
          c(paramMessageForShortVideo, acfp.m(2131714479) + paramaoko);
        } while (!ShortVideoUtils.awI());
        a(parama.b, str, paramaoko, paramMessageForShortVideo, paramInt1, paramInt2);
        return;
        a(parama, paramaoko, paramMessageForShortVideo, paramInt3, paramInt4);
        if (!aqhq.fileExistsAndNotEmpty(paramaoko)) {
          break;
        }
      } while (!a(parama.b, paramaoko));
      c(paramMessageForShortVideo, acfp.m(2131714467) + paramaoko);
      if (!aqhq.fileExistsAndNotEmpty(str))
      {
        if (this.app.a().a(paramMessageForShortVideo, true))
        {
          b(paramMessageForShortVideo, true);
          return;
        }
        c(paramMessageForShortVideo, parama);
        return;
      }
      if (ShortVideoUtils.awI())
      {
        a(parama);
        return;
      }
      c(paramMessageForShortVideo, parama);
      return;
      parama.b.setID(paramMessageForShortVideo.uniseq);
      parama.b.showCover(aoop.getFailedDrawable());
      return;
    case 5002: 
      c(paramMessageForShortVideo, "THUMB STATUS_FILE_EXPIRED");
    }
    c(paramMessageForShortVideo, "THUMB STATUS_RECV_ERROR");
    paramaoko = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    if (aqhq.fileExistsAndNotEmpty(paramaoko))
    {
      c(paramMessageForShortVideo, acfp.m(2131714464) + paramaoko);
      if (ShortVideoUtils.awI())
      {
        str = ShortVideoUtils.bw(paramMessageForShortVideo.thumbMD5, "jpg");
        a(parama.b, paramaoko, str, paramMessageForShortVideo, paramInt1, paramInt2);
      }
    }
    for (;;)
    {
      a(parama);
      return;
      parama.b.setID(paramMessageForShortVideo.uniseq);
      parama.b.showCover(h);
    }
  }
  
  public void b(a parama)
  {
    if (!parama.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.sd(parama.mMessage.frienduin + parama.mMessage.uniseq)) {
      parama.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(8);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ShortVideoRealItemBuilder", 2, "[disProgress] set mProgressView gone");
      }
      return;
      parama.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimRunnableListener(new xnj(this, parama));
    }
  }
  
  public void b(MessageForShortVideo paramMessageForShortVideo, a parama)
  {
    if (paramMessageForShortVideo == null) {
      return;
    }
    c(paramMessageForShortVideo, "reForwardVideo：" + paramMessageForShortVideo.toString());
    if (!aqhq.fileExistsAndNotEmpty(ShortVideoUtils.bw(paramMessageForShortVideo.thumbMD5, "jpg")))
    {
      QQToast.a(this.mContext, 1, 2131720278, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
      parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    if (!TextUtils.isEmpty(paramMessageForShortVideo.videoFileName))
    {
      ((ambj)this.app.getManager(326)).a(this.sessionInfo.aTl, paramMessageForShortVideo, paramMessageForShortVideo.videoFileName);
      parama = anfr.a(4, 2);
      parama.b(anfr.a(2, paramMessageForShortVideo, parama));
      anfr.a(parama, this.app);
      return;
    }
    c(paramMessageForShortVideo, "ShortVideoRealItemBuilder:reForwardVideo() path is empty");
  }
  
  void b(MessageForShortVideo paramMessageForShortVideo, a parama, int paramInt)
  {
    parama.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.Wt(paramMessageForShortVideo.frienduin + paramMessageForShortVideo.uniseq);
    parama.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    parama.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setImageResource(2130850764);
    parama.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(3);
    if (QLog.isColorLevel()) {
      QLog.w("ShortVideoRealItemBuilder", 2, "[showWarnProgress] set mProgressView visible");
    }
    parama.mTextView.setVisibility(0);
    parama.mTextView.setText(paramInt);
  }
  
  void b(MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean)
  {
    if (paramMessageForShortVideo.videoFileStatus == 5002)
    {
      c(paramMessageForShortVideo, acfp.m(2131714484));
      return;
    }
    angi localangi = anfr.a(2, 2);
    anfu localanfu = paramMessageForShortVideo.getDownloadInfo(localangi.dFl);
    localanfu.localPath = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    localanfu.jv(paramMessageForShortVideo.istroop, 0);
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      localanfu.mRequestType = i;
      localanfu.mSceneType = 2;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoRealItemBuilder", 2, " startDownloadVideo downloadvideo fileType==" + localanfu.fileType + ", uniseq:" + paramMessageForShortVideo.uniseq);
      }
      localangi.c(localanfu);
      localangi.p(paramMessageForShortVideo);
      anfr.a(localangi, this.app);
      return;
    }
  }
  
  public void bYO()
  {
    super.bYO();
  }
  
  public void c(MessageForShortVideo paramMessageForShortVideo, a parama)
  {
    parama.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.Wt(paramMessageForShortVideo.frienduin + paramMessageForShortVideo.uniseq);
    parama.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(2);
    parama.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    parama.mTextView.setVisibility(8);
  }
  
  public void d(MessageForShortVideo paramMessageForShortVideo)
  {
    if (TextUtils.isEmpty(paramMessageForShortVideo.md5)) {
      c(paramMessageForShortVideo, "Forward menu clicked, md5 is empty.");
    }
    do
    {
      return;
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", 21);
      localBundle.putBoolean("forward_need_sendmsg", true);
      String str1 = ShortVideoUtils.bw(paramMessageForShortVideo.thumbMD5, "jpg");
      localBundle.putString("forward_thumb", str1);
      localBundle.putString("from_uin", ShortVideoUtils.f(paramMessageForShortVideo));
      localBundle.putInt("from_uin_type", this.sessionInfo.cZ);
      localBundle.putString("from_session_uin", this.sessionInfo.aTl);
      localBundle.putInt("from_busi_type", paramMessageForShortVideo.busiType);
      localBundle.putInt("file_send_size", paramMessageForShortVideo.videoFileSize);
      localBundle.putInt("file_send_duration", paramMessageForShortVideo.videoFileTime);
      localBundle.putString("file_name", paramMessageForShortVideo.videoFileName);
      localBundle.putInt("file_format", paramMessageForShortVideo.videoFileFormat);
      localBundle.putInt("selection_mode", this.bOY);
      String str2 = ShortVideoUtils.e(paramMessageForShortVideo);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoRealItemBuilder", 2, "Forward menu clicked, videoPath=" + str2 + ",videoPath = " + str2 + ", " + paramMessageForShortVideo.toLogString());
      }
      localBundle.putString("file_send_path", str2);
      localBundle.putString("thumbfile_send_path", str1);
      localBundle.putString("file_shortvideo_md5", paramMessageForShortVideo.md5);
      if (!TextUtils.isEmpty(paramMessageForShortVideo.mLocalMd5)) {
        localBundle.putString("file_shortvideo_local_md5", paramMessageForShortVideo.mLocalMd5);
      }
      localBundle.putInt("thumbfile_send_width", paramMessageForShortVideo.thumbWidth);
      localBundle.putInt("thumbfile_send_height", paramMessageForShortVideo.thumbHeight);
      localBundle.putString("thumbfile_md5", paramMessageForShortVideo.thumbMD5);
      localBundle.putString("file_source", paramMessageForShortVideo.fileSource);
      localBundle.putString("file_uuid", paramMessageForShortVideo.uuid);
      localBundle.putInt("file_thumb_Size", paramMessageForShortVideo.thumbFileSize);
      localBundle.putBoolean("support_progressive", paramMessageForShortVideo.supportProgressive);
      localBundle.putInt("file_width", paramMessageForShortVideo.fileWidth);
      localBundle.putInt("file_height", paramMessageForShortVideo.fileHeight);
      localBundle.putInt("special_video_type", paramMessageForShortVideo.specialVideoType);
      localBundle.putLong("from_msg_uniseq", paramMessageForShortVideo.uniseq);
      if (paramMessageForShortVideo.CheckIsHotVideo())
      {
        localBundle.putString("hot_video_icon", paramMessageForShortVideo.hotVideoIconUrl);
        localBundle.putString("hot_video_icon_sub", paramMessageForShortVideo.hotVideoSubIconUrl);
        localBundle.putString("hot_video_title", paramMessageForShortVideo.hotVideoTitle);
        localBundle.putString("hot_video_url", paramMessageForShortVideo.hotVideoUrl);
      }
      if ((paramMessageForShortVideo.redBagType == LocalMediaInfo.REDBAG_TYPE_GET) && (paramMessageForShortVideo.isSend()))
      {
        localBundle.putInt("param_key_redbag_type", paramMessageForShortVideo.redBagType);
        localBundle.putString("param_key_redbag_video_id", paramMessageForShortVideo.shortVideoId);
      }
      if (!TextUtils.isEmpty(paramMessageForShortVideo.templateId))
      {
        localBundle.putString("widgetinfo", paramMessageForShortVideo.templateId);
        localBundle.putString("key_camera_material_name", paramMessageForShortVideo.templateName);
      }
      if (aqhq.fileExistsAndNotEmpty(str2))
      {
        localBundle.putBoolean("k_dataline", true);
        localBundle.putString("forward_extra", str2);
        localBundle.putBoolean("direct_send_if_dataline_forward", true);
        localBundle.putInt("forward_source_uin_type", this.sessionInfo.cZ);
      }
      paramMessageForShortVideo = new Intent();
      paramMessageForShortVideo.putExtras(localBundle);
    } while (this.mContext == null);
    ahgq.f((Activity)this.mContext, paramMessageForShortVideo, 21);
  }
  
  public void destroy()
  {
    super.destroy();
    Object localObject1 = hL.values().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (MessageForShortVideo)((Iterator)localObject1).next();
      if (((MessageForShortVideo)localObject2).progressTask != null) {
        ((MessageForShortVideo)localObject2).progressTask = null;
      }
    }
    if (g != null)
    {
      localObject1 = g.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (CropBubbleVideoView)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          long l = ((CropBubbleVideoView)localObject2).getCurPlayingPos();
          if (l > 0L)
          {
            MessageForShortVideo localMessageForShortVideo = aqfv.a().a(Integer.valueOf(((CropBubbleVideoView)localObject2).getId()));
            if (localMessageForShortVideo != null) {
              a(localMessageForShortVideo, l);
            }
          }
          ((CropBubbleVideoView)localObject2).releasePlayer(false);
          g.remove(localObject2);
        }
      }
    }
    hL.clear();
    this.mHandler.removeCallbacksAndMessages(null);
    this.mContext = null;
    localObject1 = this.f;
    if ((localObject1 != null) && (((MessageForShortVideo)localObject1).progressTask != null)) {
      ((MessageForShortVideo)localObject1).progressTask = null;
    }
    this.jdField_b_of_type_ComTencentWidgetListView = null;
  }
  
  public void ei(View paramView)
  {
    super.ei(paramView);
    paramView = (a)wja.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.mMessage;
    if (!localMessageForShortVideo.isSendFromLocal()) {}
    do
    {
      return;
      ausj localausj = (ausj)auss.a(this.mContext, null);
      localausj.addButton(2131690230, 5);
      localausj.addCancelButton(2131721058);
      localausj.a(new xnh(this, localMessageForShortVideo, paramView, localausj));
      localausj.show();
    } while (localMessageForShortVideo.videoFileStatus != 1004);
    ShortVideoUtils.fW("0X800A7EF", this.sessionInfo.cZ);
  }
  
  void f(MessageForShortVideo paramMessageForShortVideo)
  {
    if (f(paramMessageForShortVideo)) {
      return;
    }
    angi localangi = anfr.a(2, 2);
    anfu localanfu = paramMessageForShortVideo.getDownloadInfo(localangi.dFl);
    localanfu.thumbPath = ShortVideoUtils.bw(paramMessageForShortVideo.thumbMD5, "jpg");
    localanfu.jv(paramMessageForShortVideo.istroop, 1);
    localanfu.mRequestType = 2;
    localanfu.mSceneType = 2;
    localangi.c(localanfu);
    localangi.p(paramMessageForShortVideo);
    anfr.a(localangi, this.app);
  }
  
  protected void g(MessageForShortVideo paramMessageForShortVideo)
  {
    if (!aqfv.a().b(paramMessageForShortVideo, "0X8007428"))
    {
      aqfv.a().g(paramMessageForShortVideo, "0X8007428");
      anot.a(this.app, "dc00898", "", "", "0X8007428", "0X8007428", 0, 0, "", "", "", "");
    }
    if ((paramMessageForShortVideo.CheckIsHotVideo()) && (!aqfv.a().b(paramMessageForShortVideo, "0X8007EDB")))
    {
      aqfv.a().g(paramMessageForShortVideo, "0X8007EDB");
      anot.a(this.app, "dc00898", "", "", "0X8007EDB", "0X8007EDB", 0, 0, "", "", "", "");
    }
  }
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if ((l - lastClickTime < 500L) && (l > lastClickTime)) {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoRealItemBuilder", 2, "click too offen, please try again later!");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      lastClickTime = l;
      Object localObject;
      if (paramView.getId() == 2131364531)
      {
        localObject = (MessageRecord)paramView.getTag();
        if (localObject != null) {
          ((FlashChatManager)this.app.getManager(217)).a(paramView.getContext(), (MessageRecord)localObject);
        }
      }
      else
      {
        a locala = (a)wja.a(paramView);
        MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)locala.mMessage;
        if (paramView.getId() != 2131364545) {
          if (this.app.bF())
          {
            QQToast.a(this.mContext, 2131698108, 1).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
          }
          else
          {
            if (paramView.getId() == 2131364503) {
              a(locala, localMessageForShortVideo, false);
            }
            if (paramView.getId() == 2131364522)
            {
              if (!locala.mMessage.isMultiMsg)
              {
                localObject = this.app.a().a(locala.mMessage.frienduin, locala.mMessage.uniseq);
                if (((localObject instanceof aonu)) && (((aonu)localObject).cNt))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ShortVideoRealItemBuilder", 2, "shortVideoCancel pauseOperator BDHSuccess!");
                  }
                }
                else
                {
                  StringBuilder localStringBuilder1 = new StringBuilder();
                  localObject = this.app.a().a(locala.mMessage.frienduin, locala.mMessage.uniseq);
                  if ((localObject instanceof aonu))
                  {
                    ((aonu)localObject).pause();
                    localStringBuilder1.append("\n shortVideoCancel uploadProcess pause!");
                    ShortVideoUtils.fW("0X800A7EE", this.sessionInfo.cZ);
                    if (QLog.isColorLevel()) {
                      QLog.d("ShortVideoRealItemBuilder", 2, "shortVideoCancel pauseOperator info:" + localStringBuilder1.toString());
                    }
                  }
                  else
                  {
                    aaza localaaza = (aaza)aaza.dn.remove(Long.valueOf(locala.mMessage.uniseq));
                    StringBuilder localStringBuilder2 = localStringBuilder1.append("\n shortVideoCancel uniseq:");
                    if (localaaza != null)
                    {
                      localObject = Long.valueOf(localaaza.l.uniseq);
                      label440:
                      localObject = localStringBuilder2.append(localObject).append(", msgUniseq:").append(locala.mMessage.uniseq).append(", encodeFinish:");
                      if ((localaaza == null) || (!localaaza.bBm)) {
                        break label637;
                      }
                    }
                    label637:
                    for (boolean bool = true;; bool = false)
                    {
                      ((StringBuilder)localObject).append(bool);
                      if ((localaaza == null) || (localaaza.l.uniseq != locala.mMessage.uniseq) || (!localaaza.cancel())) {
                        break;
                      }
                      this.mHandler.removeCallbacks(localMessageForShortVideo.progressTask);
                      localMessageForShortVideo.progressTask = null;
                      localMessageForShortVideo.videoFileStatus = 1004;
                      localMessageForShortVideo.md5 = null;
                      localMessageForShortVideo.serial();
                      this.app.b().c(localMessageForShortVideo.frienduin, localMessageForShortVideo.istroop, localMessageForShortVideo.uniseq, localMessageForShortVideo.msgData);
                      ambj.k(this.app, localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
                      cdZ();
                      this.f = null;
                      bhR = false;
                      break;
                      localObject = "-1";
                      break label440;
                    }
                  }
                }
              }
            }
            else {
              super.onClick(paramView);
            }
          }
        }
      }
    }
  }
  
  public void p(ChatMessage paramChatMessage)
  {
    anot.a(this.app, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "3", "", "", "");
  }
  
  void xY(String paramString)
  {
    ThreadManager.post(new ShortVideoRealItemBuilder.4(this, paramString), 5, null, false);
  }
  
  public static class UploadTask
    implements Runnable
  {
    WeakReference<ShortVideoRealItemBuilder> ep;
    long finishTime = 0L;
    MessageForShortVideo k;
    WeakReference<Context> mContext;
    String mVideoPath;
    WeakReference<QQAppInterface> n;
    long startTime = 0L;
    
    public UploadTask(QQAppInterface paramQQAppInterface, Context paramContext, MessageForShortVideo paramMessageForShortVideo, String paramString, ShortVideoRealItemBuilder paramShortVideoRealItemBuilder)
    {
      this.mContext = new WeakReference(paramContext);
      this.n = new WeakReference(paramQQAppInterface);
      this.ep = new WeakReference(paramShortVideoRealItemBuilder);
      this.k = paramMessageForShortVideo;
      this.mVideoPath = paramString;
    }
    
    private void ga(long paramLong)
    {
      ShortVideoRealItemBuilder localShortVideoRealItemBuilder = (ShortVideoRealItemBuilder)this.ep.get();
      if (localShortVideoRealItemBuilder != null) {
        ShortVideoRealItemBuilder.a(localShortVideoRealItemBuilder, paramLong);
      }
    }
    
    public void run()
    {
      if (this.k == null) {
        return;
      }
      this.startTime = System.currentTimeMillis();
      MessageForShortVideo localMessageForShortVideo = this.k;
      Object localObject1 = localMessageForShortVideo.videoFileName;
      Object localObject2 = (ShortVideoRealItemBuilder)this.ep.get();
      if (aqhq.fileExistsAndNotEmpty((String)localObject1))
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShortVideoRealItemBuilder", 2, "mr.videoFileName is not null...");
        }
        ga(localMessageForShortVideo.uniseq);
        return;
      }
      if (!aqhq.fileExistsAndNotEmpty(this.mVideoPath))
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShortVideoRealItemBuilder", 2, "uploadTask file is null!");
        }
        ga(localMessageForShortVideo.uniseq);
        return;
      }
      localObject1 = (QQAppInterface)this.n.get();
      if (localObject1 != null) {
        ((QQAppInterface)localObject1).getHwEngine().preConnect();
      }
      long l = new File(this.mVideoPath).length();
      if (l == 0L)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShortVideoRealItemBuilder", 2, "uploadTask file mVideoSize = 0");
        }
        ga(localMessageForShortVideo.uniseq);
        return;
      }
      if (TextUtils.isEmpty(localMessageForShortVideo.md5))
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShortVideoRealItemBuilder", 2, "process videoMd5 is empty, videoMd5: " + localMessageForShortVideo.md5);
        }
        ga(localMessageForShortVideo.uniseq);
        return;
      }
      localMessageForShortVideo.videoFileSize = ((int)l);
      if (aqhq.fileExistsAndNotEmpty(localMessageForShortVideo.mThumbFilePath))
      {
        localObject2 = ShortVideoUtils.bw(localMessageForShortVideo.thumbMD5, "jpg");
        if (!((String)localObject2).equals(localMessageForShortVideo.mThumbFilePath))
        {
          if (!aqhq.rename(localMessageForShortVideo.mThumbFilePath, (String)localObject2))
          {
            if (QLog.isColorLevel()) {
              QLog.e("ShortVideoRealItemBuilder", 2, "process mThumbFilePath error!");
            }
            ga(localMessageForShortVideo.uniseq);
            return;
          }
          localMessageForShortVideo.mThumbFilePath = ((String)localObject2);
        }
      }
      if (localObject1 != null)
      {
        localObject2 = ShortVideoUtils.a(localMessageForShortVideo, "mp4");
        if (!this.mVideoPath.equals(localObject2))
        {
          aqhq.rename(this.mVideoPath, (String)localObject2);
          if (QLog.isColorLevel()) {
            QLog.i("ShortVideoRealItemBuilder", 2, "onPostExecute destVideoPath " + (String)localObject2);
          }
        }
        localMessageForShortVideo.videoFileName = ((String)localObject2);
        localMessageForShortVideo.serial();
        if (!(localMessageForShortVideo instanceof MessageForDevLittleVideo)) {
          break label603;
        }
      }
      label603:
      for (int i = 4;; i = 2)
      {
        ((QQAppInterface)localObject1).b().c(localMessageForShortVideo.frienduin, localMessageForShortVideo.istroop, localMessageForShortVideo.uniseq, localMessageForShortVideo.msgData);
        localObject2 = anfr.a(0, i);
        angt localangt = anfr.a(localMessageForShortVideo, (angi)localObject2);
        localangt.cFz = false;
        ((angi)localObject2).c(localangt);
        anfr.a((angi)localObject2, (QQAppInterface)localObject1);
        this.finishTime = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoRealItemBuilder", 2, "[" + localMessageForShortVideo.uniseq + "]mMessageForShortVideo = " + localMessageForShortVideo + "\n |- upload cost:" + (this.finishTime - this.startTime) / 1000.0D);
        }
        localObject1 = ((QQAppInterface)localObject1).getCurrentAccountUin();
        anpc.a(BaseApplicationImpl.getContext()).collectPerformance((String)localObject1, "actShortVideoGenerateDuration", true, 0L, 0L, ShortVideoRealItemBuilder.gO, "");
        ga(localMessageForShortVideo.uniseq);
        return;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("ShortVideoRealItemBuilder", 2, "QQAppInterface is null...");
        return;
      }
    }
  }
  
  public class a
    extends BaseBubbleBuilder.e
  {
    public MessageProgressView a;
    public CropBubbleVideoView b;
    public int bVA;
    public int bVB;
    public ImageView mIcon;
    public TextView mTextView;
    public ImageView tx;
    
    public a() {}
    
    public void cee()
    {
      if (this.b != null)
      {
        long l = this.b.getCurPlayingPos();
        if (l > 0L)
        {
          MessageForShortVideo localMessageForShortVideo = aqfv.a().a(Integer.valueOf(this.b.getId()));
          if (localMessageForShortVideo != null) {
            ShortVideoRealItemBuilder.this.a(localMessageForShortVideo, l);
          }
        }
        this.b.releasePlayer(true);
        ShortVideoRealItemBuilder.g.remove(this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder
 * JD-Core Version:    0.7.0.1
 */