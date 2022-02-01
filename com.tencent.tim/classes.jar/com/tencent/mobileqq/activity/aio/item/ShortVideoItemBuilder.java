package com.tencent.mobileqq.activity.aio.item;

import acfp;
import afei;
import ahgq;
import aiyw;
import ajlp;
import ajlq;
import ajlr;
import ajlt;
import ajlu;
import alar;
import allg;
import allh;
import alli;
import alyr;
import ambj;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anfr;
import anft;
import anfu;
import anfy;
import angi;
import angw;
import angw.a;
import angw.b;
import anot;
import anqs;
import aojn;
import aoko;
import aonk;
import aonn;
import aonu;
import aooi;
import aqbn;
import aqcx;
import aqft;
import aqfv;
import aqha;
import aqhq;
import aqiu;
import aqiw;
import aqju;
import aqoa;
import aqob;
import aqoi;
import armm;
import augo;
import aurs;
import ausj;
import auss;
import avfp;
import aviz;
import avjg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
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
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.customviews.VideoProgressView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.view.CropBubbleVideoView;
import com.tencent.mobileqq.widget.BubbleVideoView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import kbp;
import kct;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import myh;
import mzj;
import org.json.JSONObject;
import sxx;
import tnt;
import ujt;
import wja;
import wko.a;
import wla.a;
import wlz;
import xmt;
import xmu;
import xmv;
import xmw;
import xmx;
import xmy;
import xmz;
import xna;
import xnb;
import xtm;

public class ShortVideoItemBuilder
  extends BaseBubbleBuilder
  implements anft, BaseChatItemLayout.a, wla.a
{
  private static Rect bm;
  private static CopyOnWriteArraySet<CropBubbleVideoView> jdField_g_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
  private static long lastClickTime;
  public static AtomicLong v = new AtomicLong(-1L);
  boolean Fb = false;
  private a a;
  private ListView b;
  int bVu = -1;
  private ajlu c;
  private Runnable es = new ShortVideoItemBuilder.8(this);
  private MessageForShortVideo jdField_g_of_type_ComTencentMobileqqDataMessageForShortVideo;
  public int mBusiType = 0;
  private Handler mHandler;
  private View.OnClickListener mSourceOnClickListener = new xnb(this);
  private aqju w;
  
  public ShortVideoItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    if (paramAIOAnimationConatiner != null) {
      this.b = paramAIOAnimationConatiner.b();
    }
    this.mHandler = new Handler(Looper.getMainLooper());
    if (this.c == null) {
      this.c = ((ajlu)paramQQAppInterface.getManager(324));
    }
    this.a = new a(null);
  }
  
  private boolean Ca()
  {
    if ((this.mParentView != null) && ((this.mParentView instanceof ChatXListView))) {
      return ((ChatXListView)this.mParentView).afP();
    }
    return true;
  }
  
  private Rect a(View paramView, MessageForShortVideo paramMessageForShortVideo)
  {
    if ((paramView == null) || (paramMessageForShortVideo == null)) {
      return null;
    }
    paramView = paramView.findViewById(2131362384);
    if ((paramView instanceof CropBubbleVideoView))
    {
      paramView = (CropBubbleVideoView)paramView;
      Rect localRect = sxx.getViewRect(paramView);
      if (paramMessageForShortVideo.isSend()) {
        localRect.right = ((int)(localRect.right - paramView.triWidth));
      }
      for (;;)
      {
        return localRect;
        float f = localRect.left;
        localRect.left = ((int)(paramView.triWidth + f));
      }
    }
    return null;
  }
  
  public static Drawable a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Drawable localDrawable = null;
    if (aqhq.fileExistsAndNotEmpty(paramString))
    {
      paramString = ShortVideoUtils.k(paramString);
      if (paramString != null) {
        localDrawable = b(paramString.toString(), paramInt1, paramInt2, paramInt3);
      }
    }
    else
    {
      return localDrawable;
    }
    QLog.d("ShortVideoItemBuilder", 2, "url  is null ");
    return null;
  }
  
  private b a(long paramLong)
  {
    if ((this.b != null) && (paramLong > 0L))
    {
      int i = wja.a(paramLong, this.b.getAdapter());
      int j = this.b.getHeaderViewsCount();
      int k = this.b.getFirstVisiblePosition();
      int m = this.b.getLastVisiblePosition();
      if (i <= -1) {
        break label216;
      }
      Object localObject = wja.a(this.b, i);
      if (localObject != null)
      {
        localObject = wja.a((View)localObject);
        if ((localObject != null) && ((localObject instanceof b))) {
          return (b)localObject;
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.w("ShortVideoItemBuilder", 2, "getHolderByMsg() uniseq=" + paramLong + ", posi =" + i + ", view = null");
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "getHolderByMsg() uniseq=" + paramLong + ", posi =" + i + ", firstVisblePosi=" + k + ",lastVisblePosi=" + m + ",headerCount=" + j);
      }
    }
    for (;;)
    {
      return null;
      label216:
      if (QLog.isColorLevel()) {
        QLog.w("ShortVideoItemBuilder", 2, "getHolderByMsg() uniseq=" + paramLong + ", posi<= -1");
      }
    }
  }
  
  private b a(MessageForShortVideo paramMessageForShortVideo)
  {
    b localb = a(paramMessageForShortVideo.uniseq);
    if ((localb == null) && (QLog.isColorLevel())) {
      QLog.d("ShortVideoItemBuilder", 2, "holder is null, seq = " + paramMessageForShortVideo.uniseq);
    }
    return localb;
  }
  
  private void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, VideoPlayParam paramVideoPlayParam)
  {
    StringBuilder localStringBuilder1;
    StringBuilder localStringBuilder2;
    if (QLog.isColorLevel())
    {
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("onPlayError , id = ").append(paramLong);
      localStringBuilder1.append(" , module = ").append(paramInt1);
      localStringBuilder1.append(" , errorType = ").append(paramInt2);
      localStringBuilder1.append(" , errorCode = ").append(paramInt3);
      localStringBuilder2 = localStringBuilder1.append(" , exInfo =");
      if (paramString == null) {
        break label119;
      }
    }
    for (;;)
    {
      localStringBuilder2.append(paramString);
      QLog.e("ShortVideoItemBuilder", 2, localStringBuilder1.toString());
      if (paramInt3 != 14011001) {
        break label218;
      }
      if (this.b != null) {
        break;
      }
      return;
      label119:
      paramString = "null";
    }
    paramString = wja.a(paramLong, this.b.getAdapter());
    if ((paramString instanceof MessageForShortVideo))
    {
      paramString = (MessageForShortVideo)paramString;
      paramString.videoFileStatus = 5002;
      paramString.serial();
      this.app.b().c(paramString.frienduin, this.sessionInfo.cZ, paramString.uniseq, paramString.msgData);
      this.mHandler.post(new ShortVideoItemBuilder.11(this, paramString));
    }
    label218:
    alli.a(paramInt3, paramVideoPlayParam);
  }
  
  private void a(ajlq paramajlq, String paramString, b paramb, ajlt paramajlt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "dealVideoSaveUI onSaveComplete");
    }
    if (paramajlq != null)
    {
      if (paramajlq.result != 0) {
        break label96;
      }
      ajlr.eB(this.mContext);
    }
    for (;;)
    {
      paramajlq.a.b(paramajlt);
      if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(paramb.mMessage.frienduin + paramb.mMessage.uniseq))) {
        paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(8);
      }
      return;
      label96:
      ajlr.eC(this.mContext);
    }
  }
  
  private void a(aqoi paramaqoi, StringBuilder paramStringBuilder, b paramb, MessageForShortVideo paramMessageForShortVideo, int paramInt, long paramLong, boolean paramBoolean)
  {
    boolean bool = ((aonk)paramaqoi).isPause();
    paramStringBuilder.append(" processor:download, pause:" + bool);
    if (bool)
    {
      b(paramb);
      a(paramMessageForShortVideo, paramLong, paramBoolean);
      paramStringBuilder.append(" pause:true, result:download ");
      return;
    }
    if (paramInt == 2005)
    {
      b(paramb);
      QQToast.a(this.mContext, 2131720272, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
      paramStringBuilder.append(" status:recv_error, result:toast recv_error ");
      return;
    }
    if ((paramInt == 2002) || (paramInt == 2000) || (paramInt == 2008) || (paramInt == 2001))
    {
      b(paramb);
      return;
    }
    if (paramInt == 5001)
    {
      b(paramb);
      QQToast.a(this.mContext, 2131720270, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
      paramStringBuilder.append(" status:file_unsafe, result:toast unsafe ");
      return;
    }
    if (paramInt == 5002)
    {
      a(paramb, 2131718875);
      QQToast.a(this.mContext, 2131720271, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
      paramStringBuilder.append(" status:file_expired, result:toast expired ");
      return;
    }
    b(paramb);
    a(paramMessageForShortVideo, paramLong, paramBoolean);
    paramStringBuilder.append(" status:other, result:download ");
  }
  
  private void a(b paramb, int paramInt)
  {
    paramb.JO.setVisibility(0);
    paramb.JO.setText(paramInt);
    paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.Wt(paramb.mMessage.frienduin + paramb.mMessage.uniseq);
    paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
    paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setImageResource(2130850764);
    paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setDrawStatus(3);
  }
  
  private void a(b paramb, View paramView, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForShortVideo)) {}
    for (MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;; localMessageForShortVideo = null)
    {
      if (localMessageForShortVideo == null) {}
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoItemBuilder", 2, "msgForShortVideo.msgTailType=" + localMessageForShortVideo.msgTailType);
        }
        if ((anfy.h(this.mContext, localMessageForShortVideo.msgTailType)) && (paramChatMessage.istroop == 1))
        {
          if (paramb.JQ == null)
          {
            paramb.JQ = new TextView(this.mContext);
            paramb.JQ.setBackgroundResource(2130843454);
            paramb.JQ.setTextSize(1, 12.0F);
            paramb.JQ.setTextColor(this.mContext.getResources().getColor(2131167654));
            paramb.JQ.setText(anfy.j(this.mContext, localMessageForShortVideo.msgTailType));
            paramb.JQ.setSingleLine();
            paramb.JQ.setGravity(16);
            paramb.JQ.setPadding(aqcx.dip2px(this.mContext, 5.0F), 0, aqcx.dip2px(this.mContext, 5.0F), 0);
            paramb.JQ.setOnClickListener(this.mSourceOnClickListener);
            paramChatMessage = new RelativeLayout.LayoutParams(-2, -2);
            paramChatMessage.addRule(3, 2131364503);
            paramChatMessage.addRule(5, 2131364503);
            if ((paramView instanceof ViewGroup)) {
              ((ViewGroup)paramView).addView(paramb.JQ, paramChatMessage);
            }
          }
          paramView = (RelativeLayout.LayoutParams)paramb.JQ.getLayoutParams();
          if (localMessageForShortVideo.isSend()) {}
          for (paramView.leftMargin = BaseChatItemLayout.bNY;; paramView.leftMargin = BaseChatItemLayout.bNX)
          {
            paramb.JQ.setTag(localMessageForShortVideo);
            paramb.JQ.setVisibility(0);
            return;
          }
        }
      } while (paramb.JQ == null);
      paramb.JQ.setVisibility(8);
      return;
    }
  }
  
  private void a(b paramb, MessageForShortVideo paramMessageForShortVideo, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "showVideoThumb, msg.uniseq = " + paramMessageForShortVideo.uniseq);
    }
    paramString = ShortVideoUtils.j(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "showVideoThumb, url = " + paramString);
    }
    if ((QLog.isColorLevel()) && (paramb.u != null)) {
      QLog.d("ShortVideoItemBuilder", 2, "showVideoThumb, holder.d.getURL()=" + paramb.u.getURL());
    }
    paramb.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
    if ((paramb.u != null) && (paramb.u.getURL().equals(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "showVideoThumb, holder.d is reuse !!!");
      }
      if (paramBoolean)
      {
        paramb.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setCoverDrawable(paramb.u);
        return;
      }
      paramb.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
      paramb.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.showCover(paramb.u);
      return;
    }
    Drawable localDrawable = b(paramInt1, paramInt2);
    paramString = URLDrawable.getDrawable(paramString, paramInt1, paramInt2, localDrawable, localDrawable);
    paramb.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
    paramb.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.showCover(paramString);
    paramb.u = paramString;
  }
  
  private void a(b paramb, boolean paramBoolean)
  {
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramb.mMessage;
    int i = localMessageForShortVideo.videoFileStatus;
    long l = 0L;
    if (paramb.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView != null) {
      l = paramb.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getCurPlayingPos();
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "click ppv, msg.uniseq:" + localMessageForShortVideo.uniseq + ",fileType: " + ShortVideoUtils.fe(localMessageForShortVideo.fileType) + ", fileStatus:" + ShortVideoUtils.ff(i) + ", playPosition:" + l);
    }
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append("......click ppv, msg.uniseq:" + localMessageForShortVideo.uniseq);
    String str = ShortVideoUtils.a(localMessageForShortVideo, "mp4");
    if (!localMessageForShortVideo.isSendFromLocal()) {
      a(localMessageForShortVideo, localStringBuilder, i, str, paramb, l, paramBoolean);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoItemBuilder", 2, localStringBuilder.toString());
      }
      return;
      b(localMessageForShortVideo, localStringBuilder, i, str, paramb, l, paramBoolean);
    }
  }
  
  private void a(b paramb, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if ((paramb != null) && (paramb.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout != null))
    {
      if (paramBoolean) {
        b(paramb, false, null);
      }
      paramb.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(paramBoolean, paramOnClickListener);
    }
  }
  
  private void a(b paramb, boolean paramBoolean, MessageForShortVideo paramMessageForShortVideo, String paramString1, String[] paramArrayOfString, String paramString2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "playShortVideo, msg.uniseq = " + paramMessageForShortVideo.uniseq);
    }
    Object localObject;
    int i;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("playShortVideo, thumbPath = ");
      if (paramString2 != null)
      {
        localObject = paramString2;
        QLog.d("ShortVideoItemBuilder", 2, (String)localObject);
      }
    }
    else
    {
      paramb.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
      localObject = new VideoPlayParam();
      ((VideoPlayParam)localObject).mSceneId = 101;
      ((VideoPlayParam)localObject).mSceneName = allh.eO(101);
      ((VideoPlayParam)localObject).mIsMute = true;
      ((VideoPlayParam)localObject).mCallback = new xmu(this, (VideoPlayParam)localObject);
      ((VideoPlayParam)localObject).mIsLocal = paramBoolean;
      ((VideoPlayParam)localObject).mIsLoop = true;
      ((VideoPlayParam)localObject).mVideoPath = paramString1;
      ((VideoPlayParam)localObject).mSavePath = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
      ((VideoPlayParam)localObject).mFileID = (paramMessageForShortVideo.md5 + paramMessageForShortVideo.uniseq);
      ((VideoPlayParam)localObject).mUrls = paramArrayOfString;
      ((VideoPlayParam)localObject).mFileSize = paramMessageForShortVideo.videoFileSize;
      if (paramMessageForShortVideo.videoFileTime > 8) {
        break label322;
      }
      i = 1;
      label228:
      if (i == 0)
      {
        ((VideoPlayParam)localObject).mVideoFileTimeMs = (paramMessageForShortVideo.videoFileTime * 1000);
        ((VideoPlayParam)localObject).mMaxPlayTimeMs = 8000L;
      }
      paramb.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setVideoParam((VideoPlayParam)localObject);
      paramMessageForShortVideo = b(paramInt1, paramInt2);
      if (!TextUtils.isEmpty(paramString2)) {
        break label328;
      }
      paramb.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setCoverDrawable(paramMessageForShortVideo);
    }
    for (;;)
    {
      if (Ca()) {
        paramb.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.play();
      }
      jdField_g_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramb.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView);
      return;
      localObject = "null";
      break;
      label322:
      i = 0;
      break label228;
      label328:
      paramMessageForShortVideo = URLDrawable.getDrawable(ShortVideoUtils.j(paramString2), paramInt1, paramInt2, paramMessageForShortVideo, paramMessageForShortVideo);
      paramb.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setCoverDrawable(paramMessageForShortVideo);
      paramb.u = paramMessageForShortVideo;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo, Context paramContext, SessionInfo paramSessionInfo, Bundle paramBundle, MessageForReplyText paramMessageForReplyText)
  {
    if ((((paramContext instanceof ChatActivity)) || ((paramContext instanceof SplashActivity))) && (!(paramContext instanceof MultiForwardActivity)) && (!paramSessionInfo.beB)) {
      paramBundle.putInt("extra.AIO_CURRENT_PANEL_STATE", ((FragmentActivity)paramContext).getChatFragment().a().vm());
    }
    if (paramSessionInfo.cZ == 1)
    {
      paramBundle.putBoolean("extra.CAN_FORWARD_TO_GROUP_ALBUM", true);
      paramBundle.putString("extra.GROUP_UIN", paramSessionInfo.aTl);
      paramBundle.putString("extra.GROUP_CODE", paramSessionInfo.troopUin);
    }
    if ((paramSessionInfo.cZ == 1) || (paramSessionInfo.cZ == 3000))
    {
      paramBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 2);
      if (paramMessageForReplyText == null) {
        break label342;
      }
      paramBundle.putBoolean("extra.IS_FROM_MULTI_MSG", paramMessageForReplyText.isMultiMsg);
    }
    for (;;)
    {
      paramBundle.putLong("click_video_bubble_time", System.currentTimeMillis());
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramContext.hasNext())
      {
        paramMessageForReplyText = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (paramMessageForReplyText.processName.endsWith("mobileqq")) {
          paramBundle.putInt("extra.MOBILE_QQ_PROCESS_ID", paramMessageForReplyText.pid);
        }
      }
      paramQQAppInterface = (ajlu)paramQQAppInterface.getManager(324);
      boolean bool = paramQQAppInterface.S(paramMessageForShortVideo);
      paramBundle.putBoolean("extra.IS_SAVING_FILE", bool);
      if (bool)
      {
        paramQQAppInterface = paramQQAppInterface.a(paramQQAppInterface.h(paramMessageForShortVideo));
        if ((paramQQAppInterface != null) && (paramQQAppInterface.djL == 1)) {
          paramBundle.putInt("extra.SAVE_FILE_PROGRESS", paramQQAppInterface.progress);
        }
      }
      if (bm != null) {
        paramBundle.putParcelable("KEY_THUMBNAL_BOUND", bm);
      }
      paramBundle.putInt("forward_source_uin_type", paramSessionInfo.cZ);
      paramBundle.putString("uin", paramSessionInfo.aTl);
      paramBundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
      return;
      paramBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 1);
      break;
      label342:
      paramBundle.putBoolean("extra.IS_FROM_MULTI_MSG", paramMessageForShortVideo.isMultiMsg);
    }
  }
  
  private void a(MessageForShortVideo paramMessageForShortVideo, long paramLong)
  {
    if ((paramMessageForShortVideo != null) && (!aqfv.a().b(paramMessageForShortVideo, "0X8009AA6")))
    {
      aqfv.a().g(paramMessageForShortVideo, "0X8009AA6");
      ShortVideoUtils.a(this.app, this.sessionInfo.cZ, paramMessageForShortVideo.frienduin, 1, 1, paramMessageForShortVideo.videoFileTime * 1000, paramLong);
    }
  }
  
  public static void a(MessageForShortVideo paramMessageForShortVideo, long paramLong, Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Bundle paramBundle, MessageForReplyText paramMessageForReplyText)
  {
    if ((mzj.av(paramContext)) || (paramQQAppInterface.bF()))
    {
      QQToast.a(paramContext, 0, 2131720263, 0).show(paramContext.getResources().getDimensionPixelSize(2131299627));
      return;
    }
    if (!paramMessageForShortVideo.isSend()) {
      new alyr(BaseApplication.getContext()).a(paramQQAppInterface, 2002, paramSessionInfo.cZ, paramSessionInfo.aTl, 1001);
    }
    if (MediaPlayerManager.a(paramQQAppInterface).isPlaying()) {
      MediaPlayerManager.a(paramQQAppInterface).stop(true);
    }
    a(paramQQAppInterface, paramMessageForShortVideo, paramContext, paramSessionInfo, paramBundle, paramMessageForReplyText);
    int j = -1;
    int i;
    if ((paramContext instanceof SplashActivity))
    {
      i = 1;
      str = paramMessageForShortVideo.selfuin;
      paramMessageForReplyText = str;
      if (!paramMessageForShortVideo.isMultiMsg) {}
    }
    try
    {
      AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
      paramMessageForReplyText = str;
      if ((localAppRuntime instanceof QQAppInterface)) {
        paramMessageForReplyText = localAppRuntime.getAccount();
      }
    }
    catch (Exception paramMessageForReplyText)
    {
      for (;;)
      {
        paramMessageForReplyText = str;
      }
    }
    if ((paramMessageForShortVideo.istroop == 0) && (aqft.rj(paramMessageForShortVideo.senderuin)) && (!TextUtils.isEmpty(paramMessageForShortVideo.getExtInfoFromExtStr("guide_video_type"))))
    {
      paramBundle.putString("babyq_video_type", paramMessageForShortVideo.getExtInfoFromExtStr("guide_video_type"));
      avfp.a(paramContext, paramBundle, new AIOImageProviderService(paramMessageForReplyText, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo), xtm.a(paramMessageForShortVideo), 13007, i);
    }
    for (;;)
    {
      ((ambj)paramQQAppInterface.getManager(326)).dMe();
      if (!paramMessageForShortVideo.isSend()) {
        new alyr(BaseApplication.getContext()).a(paramQQAppInterface, 2001, paramSessionInfo.cZ, paramSessionInfo.aTl, 1001);
      }
      alar.b(paramQQAppInterface, paramMessageForShortVideo);
      return;
      if ((paramContext instanceof ChatHistoryActivity))
      {
        i = 2;
        break;
      }
      i = j;
      if (!(paramContext instanceof PublicFragmentActivity)) {
        break;
      }
      i = j;
      if (!(((PublicFragmentActivity)paramContext).b() instanceof ChatHistoryBubbleListForTroopFragment)) {
        break;
      }
      i = 2;
      break;
      avfp.a(paramContext, paramBundle, new AIOImageProviderService(paramMessageForReplyText, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo), xtm.a(paramMessageForShortVideo), -1, i);
    }
  }
  
  public static void a(MessageForShortVideo paramMessageForShortVideo, long paramLong, Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean1, boolean paramBoolean2, MessageForReplyText paramMessageForReplyText)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("muate_play", false);
    localBundle.putBoolean("is_one_item", true);
    localBundle.putBoolean("is_ReplyMsg_From_Same_Session", paramBoolean1);
    localBundle.putBoolean(avfp.cKr, paramBoolean2);
    a(paramMessageForShortVideo, paramLong, paramContext, paramQQAppInterface, paramSessionInfo, localBundle, paramMessageForReplyText);
  }
  
  public static void a(MessageForShortVideo paramMessageForShortVideo, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "handleVideoCompressSucceed, seq = " + paramMessageForShortVideo.uniseq);
    }
    angw.a locala = angw.a().a(paramMessageForShortVideo.uniseq);
    if ((paramQQAppInterface != null) && (locala != null)) {
      if (locala.gU() >= 104345600L)
      {
        paramMessageForShortVideo.videoFileStatus = 1005;
        paramMessageForShortVideo.serial();
        paramQQAppInterface.b().c(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo.uniseq, paramMessageForShortVideo.msgData);
        if (paramContext != null)
        {
          QQToast.a(paramContext, paramContext.getResources().getString(2131720243), 0).show(paramContext.getResources().getDimensionPixelSize(2131299627));
          paramContext = ((FragmentActivity)paramContext).getChatFragment();
          if (paramContext != null)
          {
            paramContext = paramContext.a();
            if (paramContext != null) {
              paramContext.aG(false, false);
            }
          }
        }
        ambj.k(paramQQAppInterface, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        return;
        if ((v == null) || (v.get() != paramMessageForShortVideo.uniseq)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("ShortVideoItemBuilder", 2, "CompressTask onPostExecute sRevokeMsRecord==mr.uniseq==" + paramMessageForShortVideo.uniseq + ", just return");
      return;
      paramQQAppInterface.b().c(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo.uniseq, paramMessageForShortVideo.msgData);
      paramContext = anfr.a(0, 0);
      paramMessageForShortVideo = anfr.a(paramMessageForShortVideo, paramContext);
      if (paramMessageForShortVideo != null)
      {
        paramMessageForShortVideo.originalFilePath = locala.zN();
        paramMessageForShortVideo.cFz = false;
        paramContext.c(paramMessageForShortVideo);
      }
      anfr.a(paramContext, paramQQAppInterface);
      v.set(-1L);
      return;
    }
    QLog.i("ShortVideoItemBuilder", 2, "CompressTask onPostExecute QQAppInterface is null...");
  }
  
  private void a(MessageForShortVideo paramMessageForShortVideo, StringBuilder paramStringBuilder, int paramInt, String paramString, b paramb, long paramLong, boolean paramBoolean)
  {
    paramStringBuilder.append(" sendFromLocal:false ");
    if (!aqhq.fileExistsAndNotEmpty(paramString))
    {
      paramStringBuilder.append(" videoPathExists:false ");
      if ((paramMessageForShortVideo.fileType == 6) || (paramMessageForShortVideo.fileType == 17) || (paramMessageForShortVideo.fileType == 9))
      {
        paramStringBuilder.append(" fileType:video, =" + ShortVideoUtils.fe(paramMessageForShortVideo.fileType));
        if ((paramInt == 2005) && (paramMessageForShortVideo.isAllowAutoDown))
        {
          b(paramb);
          QQToast.a(this.mContext, 2131720272, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
          paramStringBuilder.append(" result:toast recv_error ");
          return;
        }
        if (paramInt == 5001)
        {
          b(paramb);
          QQToast.a(this.mContext, 2131720270, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
          paramStringBuilder.append(" result: toast file_unsafe ");
          return;
        }
        if (paramInt == 5002)
        {
          a(paramb, 2131718875);
          QQToast.a(this.mContext, 2131720271, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
          paramStringBuilder.append(" result: toast file_expired ");
          return;
        }
        b(paramb);
        a(paramMessageForShortVideo, paramLong, paramBoolean);
        paramStringBuilder.append(" status:other, result: download ");
        return;
      }
      if (paramInt == 5002)
      {
        a(paramb, 2131718875);
        QQToast.a(this.mContext, 2131720271, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
        paramStringBuilder.append("fileType:not video,videoPathExits:false, result:toast file_expired ");
        return;
      }
      b(paramb);
      a(paramMessageForShortVideo, paramLong, paramBoolean);
      paramStringBuilder.append("fileType:not video,videoPathExits:false, result: download");
      return;
    }
    b(paramb);
    a(paramMessageForShortVideo, paramLong, paramBoolean);
    paramStringBuilder.append("videoPathExists:true, result:play ");
  }
  
  private void a(StringBuilder paramStringBuilder, b paramb, MessageForShortVideo paramMessageForShortVideo, int paramInt, long paramLong, boolean paramBoolean)
  {
    paramStringBuilder.append(" localUploadPath Exists:true ");
    if ((paramMessageForShortVideo.fileType == 6) || (paramMessageForShortVideo.fileType == 17) || (paramMessageForShortVideo.fileType == 9))
    {
      paramStringBuilder.append(" fileType:video ");
      aqoi localaqoi = this.app.a().a(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
      if (localaqoi != null)
      {
        if ((aonu.class.isInstance(localaqoi)) || (aonn.class.isInstance(localaqoi))) {
          if (paramInt == 1005)
          {
            b(paramb);
            paramb.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
            paramStringBuilder.append(" status:send_error, result:show send error ");
          }
        }
        while (!aonk.class.isInstance(localaqoi))
        {
          return;
          if ((paramInt == 1002) || (paramInt == 1001))
          {
            a(paramMessageForShortVideo, paramLong, paramBoolean);
            paramStringBuilder.append(" status:process or start, result:pauseSending ");
            return;
          }
          b(paramb);
          a(paramMessageForShortVideo, paramLong, paramBoolean);
          paramStringBuilder.append(" status:other, result:play ");
          return;
        }
        paramStringBuilder.append(" processor:not up of forward, result: none");
        return;
      }
      b(paramb);
      a(paramMessageForShortVideo, paramLong, paramBoolean);
      paramStringBuilder.append(" processor:null, result:play ");
      return;
    }
    b(paramb);
    a(paramMessageForShortVideo, paramLong, paramBoolean);
    paramStringBuilder.append(" fileType:not video, result: play ");
  }
  
  private boolean a(b paramb)
  {
    if (this.c != null)
    {
      paramb = this.c.a(this.c.h(paramb.mMessage));
      return (paramb != null) && (paramb.djL == 1) && (!paramb.isCompleted);
    }
    return false;
  }
  
  private boolean a(MessageForShortVideo paramMessageForShortVideo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMessageForShortVideo.videoFileStatus == 998)
    {
      bool1 = bool2;
      if (angw.a().a(paramMessageForShortVideo.uniseq) == null)
      {
        paramMessageForShortVideo = ShortVideoUtils.by(paramMessageForShortVideo.videoFileName, "mp4");
        if (!TextUtils.isEmpty(paramMessageForShortVideo)) {
          aqhq.deleteFile(paramMessageForShortVideo);
        }
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void ah(long paramLong, int paramInt)
  {
    if (paramInt == 4)
    {
      localObject = aqfv.a().a(Long.valueOf(paramLong));
      if ((!aqfv.a().E(Long.valueOf(paramLong))) && (localObject != null))
      {
        ShortVideoUtils.a(this.app, "0X8008E51", this.sessionInfo, (MessageRecord)localObject, this.mContext);
        if (!aqfv.a().F(Long.valueOf(((MessageForShortVideo)localObject).uniseq)))
        {
          aqfv.a().bz(Long.valueOf(((MessageForShortVideo)localObject).uniseq));
          ShortVideoUtils.a(this.app, "0X8008E50", this.sessionInfo, (MessageRecord)localObject, this.mContext);
        }
        aqfv.a().f(Long.valueOf(paramLong), true);
      }
    }
    Object localObject = a(paramLong);
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.w("ShortVideoItemBuilder", 2, "holder == null, msgUniseq=" + paramLong);
      }
    }
    boolean bool;
    do
    {
      do
      {
        do
        {
          return;
          if (((MessageForShortVideo)((b)localObject).mMessage).videoFileTime <= 8) {}
          for (bool = true; paramInt == 5; bool = false)
          {
            this.mHandler.postDelayed(new ShortVideoItemBuilder.10(this, bool, (b)localObject), 1200L);
            return;
          }
          if ((paramInt != 7) && (paramInt != 8)) {
            break;
          }
          this.mHandler.removeCallbacksAndMessages(null);
          ((b)localObject).JP.setVisibility(8);
          ((b)localObject).jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
          b((b)localObject);
          ((b)localObject).progressBar.setVisibility(8);
          ((b)localObject).bottomBar.setVisibility(0);
        } while (paramInt != 8);
        localObject = aqfv.a().a(Long.valueOf(paramLong));
      } while (localObject == null);
      a((MessageForShortVideo)localObject, ((MessageForShortVideo)localObject).videoFileTime * 1000);
      return;
    } while (paramInt != 4);
    this.mHandler.removeCallbacksAndMessages(null);
    if (bool) {
      ((b)localObject).JP.setVisibility(8);
    }
    for (;;)
    {
      a((b)localObject);
      ((b)localObject).progressBar.setVisibility(8);
      ((b)localObject).bottomBar.setVisibility(8);
      localObject = aqfv.a().a(Long.valueOf(paramLong));
      if (localObject == null) {
        break;
      }
      a((MessageForShortVideo)localObject, 0L);
      return;
      ((b)localObject).JP.setVisibility(0);
    }
  }
  
  public static Drawable b(int paramInt1, int paramInt2)
  {
    return new afei(Color.rgb(214, 214, 214), paramInt1, paramInt2);
  }
  
  private static Drawable b(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    afei localafei = new afei(Color.rgb(214, 214, 214), paramInt1, paramInt2);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, paramInt1, paramInt2, localafei, localafei);
        localURLDrawable.setTag(aqbn.d(0, 0, paramInt3));
        if (localURLDrawable.getStatus() != 1) {
          localURLDrawable.downloadImediatly();
        }
        return localURLDrawable;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShortVideoItemBuilder", 2, "getCoverDrawable():  getDrawable Exception, coverUrl=" + paramString, localException);
        }
      }
    }
    return localafei;
  }
  
  private void b(b paramb, View paramView, ChatMessage paramChatMessage)
  {
    if (c(paramb))
    {
      if (paramb.tx == null)
      {
        paramb.tx = new ImageView(this.mContext);
        paramb.tx.setImageResource(2130838370);
        paramb.tx.setId(2131364522);
        paramChatMessage = new RelativeLayout.LayoutParams(-2, -2);
        paramChatMessage.bottomMargin = wja.dp2px(16.0F, this.mContext.getResources());
        paramChatMessage.addRule(8, 2131364503);
        paramChatMessage.addRule(0, 2131364503);
        paramChatMessage.addRule(1, 0);
        if ((paramView instanceof ViewGroup)) {
          ((ViewGroup)paramView).addView(paramb.tx, paramChatMessage);
        }
      }
      b(paramb, true, this);
      return;
    }
    b(paramb, false, null);
  }
  
  private void b(b paramb, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if (paramBoolean) {
      if (paramb.tx != null)
      {
        paramb.tx.setVisibility(0);
        paramb.tx.setOnClickListener(paramOnClickListener);
      }
    }
    while (paramb.tx == null) {
      return;
    }
    paramb.tx.setVisibility(8);
    paramb.tx.setOnClickListener(null);
  }
  
  private void b(MessageForShortVideo paramMessageForShortVideo, b paramb)
  {
    int k = 1;
    ajlq localajlq;
    int i;
    if ((this.c != null) && (paramMessageForShortVideo != null) && (paramb != null))
    {
      paramMessageForShortVideo = this.c.h(paramMessageForShortVideo);
      localajlq = this.c.a(paramMessageForShortVideo);
      if ((localajlq != null) && (localajlq.djL == 1))
      {
        if (localajlq.progress >= 0) {
          break label188;
        }
        i = 0;
        j = k;
        if (paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.getVisibility() != 8) {
          if ((paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.getVisibility() != 0) || (paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.egH != 2)) {
            break label213;
          }
        }
      }
    }
    label188:
    label213:
    for (int j = k;; j = 0)
    {
      if ((i < 100) && (j != 0) && (!localajlq.isCompleted) && (localajlq.a != null))
      {
        localajlq.a.a(new xmw(this, paramMessageForShortVideo, paramb));
        this.c.a(paramMessageForShortVideo, localajlq);
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoItemBuilder", 2, "dealVideoSaveUI showSaveProgress");
        }
        a(paramb, i, false);
        paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
      }
      return;
      if (localajlq.progress > 100)
      {
        i = 100;
        break;
      }
      i = localajlq.progress;
      break;
    }
  }
  
  public static void b(MessageForShortVideo paramMessageForShortVideo, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "handleVideoCompressFailure, seq = " + paramMessageForShortVideo.uniseq);
    }
    if (paramQQAppInterface != null)
    {
      paramMessageForShortVideo.videoFileStatus = 1005;
      paramMessageForShortVideo.serial();
      paramQQAppInterface.b().c(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo.uniseq, paramMessageForShortVideo.msgData);
      ambj.k(paramQQAppInterface, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
    }
    if (paramContext != null) {}
  }
  
  private void b(MessageForShortVideo paramMessageForShortVideo, StringBuilder paramStringBuilder, int paramInt, String paramString, b paramb, long paramLong, boolean paramBoolean)
  {
    paramStringBuilder.append(" sendFromLocal:true ");
    if (paramMessageForShortVideo.isMultiMsg) {
      paramMessageForShortVideo.extraflag = 32772;
    }
    if (aqhq.fileExistsAndNotEmpty(paramMessageForShortVideo.videoFileName))
    {
      a(paramStringBuilder, paramb, paramMessageForShortVideo, paramInt, paramLong, paramBoolean);
      return;
    }
    b(paramStringBuilder, paramb, paramMessageForShortVideo, paramInt, paramLong, paramBoolean);
  }
  
  private void b(StringBuilder paramStringBuilder, b paramb, MessageForShortVideo paramMessageForShortVideo, int paramInt, long paramLong, boolean paramBoolean)
  {
    paramStringBuilder.append(" localUploadPath Exists:false ");
    if (!aqhq.fileExistsAndNotEmpty(ShortVideoUtils.a(paramMessageForShortVideo, "mp4")))
    {
      paramStringBuilder.append(" downloadPath Exists:false ");
      if ((paramMessageForShortVideo.fileType == 6) || (paramMessageForShortVideo.fileType == 17) || (paramMessageForShortVideo.fileType == 9))
      {
        aqoi localaqoi = this.app.a().a(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
        if (localaqoi != null)
        {
          if (aonk.class.isInstance(localaqoi))
          {
            a(localaqoi, paramStringBuilder, paramb, paramMessageForShortVideo, paramInt, paramLong, paramBoolean);
            return;
          }
          if (aonu.class.isInstance(localaqoi))
          {
            b(paramb);
            paramb.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
            QQToast.a(this.mContext, 2131720277, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
            paramStringBuilder.append(" processor:upload, result:show upload error and show toast");
            return;
          }
          if (aonn.class.isInstance(localaqoi))
          {
            boolean bool = ((aonn)localaqoi).isPause();
            paramStringBuilder.append(" processor:forward, pause:" + bool);
            if (bool)
            {
              a(paramb, 10, false);
              d(paramMessageForShortVideo, paramb);
              paramStringBuilder.append(" pause:true, result:reforward ");
              return;
            }
            if (paramInt == 5001)
            {
              b(paramb);
              paramb.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
              QQToast.a(this.mContext, 2131720245, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
              paramStringBuilder.append(" status:unsafe, result:toast unsafe ");
              return;
            }
            if (paramInt == 5002)
            {
              a(paramb, 2131718875);
              paramb.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
              QQToast.a(this.mContext, 2131720246, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
              paramStringBuilder.append(" status:expired, result:toast expired ");
              return;
            }
            if (paramInt == 1005)
            {
              b(paramb);
              paramb.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
              paramStringBuilder.append(" status:send_error, result:show send_error ");
              return;
            }
            if ((paramInt == 1002) || (paramInt == 1001))
            {
              a(paramMessageForShortVideo, 0L, paramBoolean);
              return;
            }
            b(paramb);
            a(paramMessageForShortVideo, 0L, paramBoolean);
            paramStringBuilder.append(" status:other, result:plau ");
            return;
          }
          paramStringBuilder.append(" processor:not down or forward or up, result:none ");
          return;
        }
        b(paramb);
        paramStringBuilder.append(" processor:null, result:download ");
        a(paramMessageForShortVideo, 0L, paramBoolean);
        return;
      }
      b(paramb);
      a(paramMessageForShortVideo, paramLong, paramBoolean);
      paramStringBuilder.append(" fileType:not video, result:download ");
      return;
    }
    b(paramb);
    a(paramMessageForShortVideo, paramLong, paramBoolean);
    paramStringBuilder.append(" downloadPath Exists:true，result:play ");
  }
  
  private boolean b(b paramb)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.c != null)
    {
      paramb = this.c.a(this.c.h(paramb.mMessage));
      if ((paramb != null) && (QLog.isColorLevel())) {
        QLog.d("ShortVideoItemBuilder", 2, "isVideoInMultiSaving = true");
      }
      bool1 = bool2;
      if (paramb != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean bw(long paramLong)
  {
    return ((ambj)this.app.getManager(326)).w(this.sessionInfo.aTl, paramLong);
  }
  
  private void c(b paramb)
  {
    if (c(paramb))
    {
      if (paramb.tx != null) {
        break label20;
      }
      cdZ();
    }
    label20:
    while (paramb.tx.getVisibility() == 0) {
      return;
    }
    b(paramb, true, this);
  }
  
  private boolean c(b paramb)
  {
    boolean bool2 = true;
    if ((paramb.mMessage instanceof MessageForShortVideo)) {}
    for (MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramb.mMessage;; localMessageForShortVideo = null)
    {
      if (localMessageForShortVideo == null) {
        return false;
      }
      int i;
      int j;
      if ((localMessageForShortVideo.videoFileStatus == 998) || (localMessageForShortVideo.videoFileStatus == 1002) || (localMessageForShortVideo.videoFileStatus == 1001))
      {
        i = 1;
        if ((localMessageForShortVideo.isMultiMsg) || (localMessageForShortVideo.uiOperatorFlag == 2) || (localMessageForShortVideo.busiType != 0) || (!localMessageForShortVideo.isSendFromLocal()) || (paramb.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.Rn())) {
          break label211;
        }
        j = 1;
        label109:
        if (QLog.isColorLevel())
        {
          paramb = new StringBuilder().append("needShowPauseIcon seq:").append(localMessageForShortVideo.uniseq).append(", videostatus:").append(localMessageForShortVideo.videoFileStatus).append(", iconshow:");
          if ((i == 0) || (j == 0)) {
            break label216;
          }
          bool1 = true;
          QLog.i("ShortVideoItemBuilder", 2, bool1);
        }
        label168:
        if ((i == 0) || (j == 0) || (Build.VERSION.SDK_INT < 21)) {
          break label222;
        }
      }
      label211:
      label216:
      label222:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        return bool1;
        i = 0;
        break;
        j = 0;
        break label109;
        bool1 = false;
        break label168;
      }
    }
  }
  
  private boolean c(MessageForShortVideo paramMessageForShortVideo)
  {
    return false;
  }
  
  private void cdZ()
  {
    try
    {
      if (this.mContext != null)
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
      QLog.d("ShortVideoItemBuilder", 2, "pauseAllVideo");
    }
    if (jdField_g_of_type_JavaUtilConcurrentCopyOnWriteArraySet != null)
    {
      Iterator localIterator = jdField_g_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
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
      QLog.d("ShortVideoItemBuilder", 2, "resumeAllVideo");
    }
    if (jdField_g_of_type_JavaUtilConcurrentCopyOnWriteArraySet != null)
    {
      Iterator localIterator = jdField_g_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
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
      QLog.d("ShortVideoItemBuilder", 2, "releaseAllVideo");
    }
    if (jdField_g_of_type_JavaUtilConcurrentCopyOnWriteArraySet != null)
    {
      Iterator localIterator = jdField_g_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
      while (localIterator.hasNext())
      {
        CropBubbleVideoView localCropBubbleVideoView = (CropBubbleVideoView)localIterator.next();
        if (localCropBubbleVideoView != null)
        {
          localCropBubbleVideoView.releasePlayer(false);
          jdField_g_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(localCropBubbleVideoView);
        }
      }
    }
  }
  
  private boolean d(MessageForShortVideo paramMessageForShortVideo)
  {
    return anqs.a().d(this.mContext, 1, paramMessageForShortVideo.istroop);
  }
  
  private boolean e(MessageForShortVideo paramMessageForShortVideo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMessageForShortVideo != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramMessageForShortVideo.md5)) {
        if (paramMessageForShortVideo.mPreUpload)
        {
          bool1 = bool2;
          if (TextUtils.isEmpty(paramMessageForShortVideo.mLocalMd5)) {}
        }
        else
        {
          String str = ShortVideoUtils.bw(paramMessageForShortVideo.thumbMD5, "jpg");
          paramMessageForShortVideo = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
          bool1 = bool2;
          if (aqhq.fileExistsAndNotEmpty(str))
          {
            bool1 = bool2;
            if (aqhq.fileExistsAndNotEmpty(paramMessageForShortVideo)) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  protected void B(ChatMessage paramChatMessage)
  {
    ((augo)this.app.getManager(374)).B(paramChatMessage);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, wlz paramwlz)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramwlz);
    if ((paramChatMessage instanceof MessageForShortVideo)) {
      this.jdField_g_of_type_ComTencentMobileqqDataMessageForShortVideo = ((MessageForShortVideo)paramChatMessage);
    }
    a(paramChatMessage, paramView, this);
    a((b)paramView.getTag(), paramView, paramChatMessage);
    b((b)paramView.getTag(), paramView, paramChatMessage);
    if (aTl) {}
    try
    {
      paramChatMessage = (b)paramView.getTag();
      paramChatMessage.E.append(paramChatMessage.JN.getText());
      paramChatMessage.E.append(this.jdField_g_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime);
      paramChatMessage.E.append("秒按钮");
      paramView.setContentDescription(paramChatMessage.E.toString());
      return paramView;
    }
    catch (Exception paramChatMessage) {}
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "getBubbleView, message.uniseq = " + paramChatMessage.uniseq);
    }
    paramBaseChatItemLayout = (b)parame;
    Resources localResources = this.mContext.getResources();
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
    boolean bool = localMessageForShortVideo.isSend();
    parame = paramView;
    int i;
    if (paramView == null)
    {
      parame = new RelativeLayout(this.mContext);
      paramView = (CropBubbleVideoView)allg.createCropBubbleView(this.mContext, localMessageForShortVideo.uniseq, null, bool);
      paramView.setId(2131362384);
      paramView.setVisibility(0);
      paramView.setContentDescription(acfp.m(2131714463));
      parame.addView(paramView);
      jdField_g_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramView);
      VideoProgressView localVideoProgressView = new VideoProgressView(this.mContext);
      localVideoProgressView.setId(2131364545);
      parame.addView(localVideoProgressView);
      ProgressBar localProgressBar = new ProgressBar(this.mContext, null, 0);
      i = wja.dp2px(50.0F, this.mContext.getResources());
      Object localObject1 = new RelativeLayout.LayoutParams(i, i);
      ((RelativeLayout.LayoutParams)localObject1).addRule(13);
      parame.addView(localProgressBar, (ViewGroup.LayoutParams)localObject1);
      Object localObject2 = new LinearLayout(this.mContext);
      ((LinearLayout)localObject2).setOrientation(1);
      ((LinearLayout)localObject2).setGravity(17);
      localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(13);
      parame.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
      localObject1 = new TextView(this.mContext);
      Object localObject3 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject3).topMargin = wja.dp2px(70.0F, localResources);
      ((TextView)localObject1).setTextColor(-1);
      ((TextView)localObject1).setTextSize(2, 12.0F);
      ((TextView)localObject1).setId(2131364543);
      ((TextView)localObject1).setVisibility(4);
      ((LinearLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
      localObject2 = new RelativeLayout(this.mContext);
      ((RelativeLayout)localObject2).setBackgroundResource(2130839282);
      localObject3 = new RelativeLayout.LayoutParams(-1, wja.dp2px(55.0F, localResources));
      ((RelativeLayout.LayoutParams)localObject3).addRule(5, 2131362384);
      ((RelativeLayout.LayoutParams)localObject3).addRule(7, 2131362384);
      ((RelativeLayout.LayoutParams)localObject3).addRule(8, 2131362384);
      parame.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject3 = new TextView(this.mContext);
      ((TextView)localObject3).setTextSize(1, 12.0F);
      ((TextView)localObject3).setTextColor(-1);
      Object localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).leftMargin = wja.dp2px(7.0F, localResources);
      ((RelativeLayout.LayoutParams)localObject4).bottomMargin = wja.dp2px(7.0F, localResources);
      ((RelativeLayout.LayoutParams)localObject4).addRule(9);
      ((RelativeLayout.LayoutParams)localObject4).addRule(12);
      ((RelativeLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      localObject4 = new TextView(this.mContext);
      ((TextView)localObject4).setTextSize(1, 12.0F);
      ((TextView)localObject4).setTextColor(-1);
      Object localObject5 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject5).rightMargin = wja.dp2px(7.0F, localResources);
      ((RelativeLayout.LayoutParams)localObject5).bottomMargin = wja.dp2px(7.0F, localResources);
      ((RelativeLayout.LayoutParams)localObject5).addRule(11);
      ((RelativeLayout.LayoutParams)localObject5).addRule(12);
      ((RelativeLayout)localObject2).addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
      localObject5 = new TextView(this.mContext);
      ((TextView)localObject5).setTextSize(1, 14.0F);
      ((TextView)localObject5).setTextColor(-1);
      ((TextView)localObject5).setGravity(17);
      ((TextView)localObject5).setText(2131720264);
      ((TextView)localObject5).setShadowLayer(3.0F, 1.0F, 1.0F, -16777216);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.topMargin = wja.dp2px(14.0F, localResources);
      localLayoutParams.addRule(14);
      parame.addView((View)localObject5, localLayoutParams);
      parame.setOnClickListener(this);
      super.a(parame, paramwlz);
      paramBaseChatItemLayout.progressBar = localProgressBar;
      paramBaseChatItemLayout.bottomBar = ((RelativeLayout)localObject2);
      paramBaseChatItemLayout.JN = ((TextView)localObject3);
      paramBaseChatItemLayout.fZ = ((TextView)localObject4);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView = localVideoProgressView;
      paramBaseChatItemLayout.JO = ((TextView)localObject1);
      paramBaseChatItemLayout.JP = ((TextView)localObject5);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView = paramView;
    }
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setTag(Long.valueOf(localMessageForShortVideo.uniseq));
    aqfv.a().a(Long.valueOf(localMessageForShortVideo.uniseq), localMessageForShortVideo);
    if (paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.mIsSend != bool)
    {
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.mIsSend = bool;
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.invalidate();
    }
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setOnClickListener(this);
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setOnTouchListener(paramwlz);
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setOnLongClickListener(paramwlz);
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setRadius(6.0F, true);
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setShowCorner(false);
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setCornerDirection(bool);
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.bind(paramChatMessage.frienduin + paramChatMessage.uniseq);
    alar.a(this.app, localMessageForShortVideo);
    paramChatMessage = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.JP.getLayoutParams();
    int j;
    if (bool)
    {
      paramChatMessage.rightMargin = (wja.dp2px(paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getTriaWidth(), localResources) / 2);
      paramBaseChatItemLayout.fZ.setText(ShortVideoUtils.stringForTime(localMessageForShortVideo.videoFileTime * 1000));
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
      paramChatMessage = ShortVideoUtils.bw(localMessageForShortVideo.thumbMD5, "jpg");
      paramView = ShortVideoUtils.d(localMessageForShortVideo.thumbWidth, localMessageForShortVideo.thumbHeight);
      i = paramView[0];
      j = paramView[1];
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "getBubbleView, msg.uniseq = " + localMessageForShortVideo.uniseq + " msg.thumbWidth = " + localMessageForShortVideo.thumbWidth + ", msg.thumbHeight = " + localMessageForShortVideo.thumbHeight + ", adjustWidth = " + i + ", adjustHeight = " + j);
      }
      paramView = paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getLayoutParams();
      if (paramView != null) {
        break label1286;
      }
      paramView = new RelativeLayout.LayoutParams(i, j);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setLayoutParams(paramView);
      label1153:
      paramView = paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.getLayoutParams();
      if (paramView != null) {
        break label1328;
      }
      paramView = new LinearLayout.LayoutParams(i, j);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setLayoutParams(paramView);
      label1187:
      if (anfr.cFn)
      {
        anfr.akU = System.currentTimeMillis();
        anfr.cFn = false;
      }
      paramView = b(i, j);
      b(paramBaseChatItemLayout);
      b(localMessageForShortVideo, paramBaseChatItemLayout);
      if ((localMessageForShortVideo.md5 != null) || (localMessageForShortVideo.CheckIsHotVideo()) || (localMessageForShortVideo.isCancelStatus())) {
        break label1370;
      }
      a(localMessageForShortVideo, paramBaseChatItemLayout, paramChatMessage, i, j);
    }
    label1286:
    label1328:
    label1370:
    do
    {
      return parame;
      paramChatMessage.leftMargin = (wja.dp2px(paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getTriaWidth(), localResources) / 2);
      break;
      if ((paramView.width == i) && (paramView.height == j)) {
        break label1153;
      }
      paramView.width = i;
      paramView.height = j;
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setLayoutParams(paramView);
      break label1153;
      if ((paramView.width == i) && (paramView.height == j)) {
        break label1187;
      }
      paramView.width = i;
      paramView.height = j;
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setLayoutParams(paramView);
      break label1187;
      paramBaseChatItemLayout.JO.setVisibility(8);
      paramBaseChatItemLayout.JN.setText(ShortVideoUtils.g(this.mContext, localMessageForShortVideo.videoFileSize));
      paramBaseChatItemLayout.JP.setVisibility(8);
    } while (!a(paramChatMessage, localMessageForShortVideo, paramBaseChatItemLayout, i, j, paramView));
    a(localMessageForShortVideo, paramBaseChatItemLayout);
    return parame;
  }
  
  public aqoa a(aqoa paramaqoa, ChatMessage paramChatMessage, wko.a parama)
  {
    boolean bool3 = false;
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
    parama = (b)parama;
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "getMenuItem, msg.uniseq:" + localMessageForShortVideo.uniseq + ",fileType===>" + ShortVideoUtils.fe(localMessageForShortVideo.fileType) + " ===> fileStatus:" + ShortVideoUtils.ff(localMessageForShortVideo.videoFileStatus));
    }
    b(paramaqoa, this.mContext);
    int i;
    boolean bool1;
    label221:
    boolean bool2;
    if ((localMessageForShortVideo != null) && (!TextUtils.isEmpty(localMessageForShortVideo.md5)))
    {
      paramChatMessage = ShortVideoUtils.bw(localMessageForShortVideo.thumbMD5, "jpg");
      if (aqhq.fileExistsAndNotEmpty(paramChatMessage))
      {
        paramChatMessage = "";
        i = 1;
        if (i == 0) {
          break label485;
        }
        if (!"1".equals(DeviceProfileManager.a().aJ(DeviceProfileManager.AccountDpcManager.DpcAccountNames.shortvideo_forward_switch.name(), "1"))) {
          break label472;
        }
        boolean bool4 = localMessageForShortVideo.checkForward();
        if ((parama.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView == null) || (!parama.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.sd(parama.mMessage.frienduin + parama.mMessage.uniseq))) {
          break label479;
        }
        bool1 = true;
        bool2 = bool3;
        if (parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.sc != null)
        {
          bool2 = bool3;
          if (parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.sc.getVisibility() == 0) {
            bool2 = true;
          }
        }
        if ((!bool4) || (bool1) || (bool2)) {
          break label432;
        }
        paramaqoa.Z(2131367523, this.mContext.getString(2131721067), 2130839086);
        paramChatMessage = paramChatMessage + "inMiddleStatus = false, progeressBarShowing = false, errorIconShowing = false, show forward menu.";
      }
    }
    label432:
    label472:
    label479:
    label485:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "getMenuItem: " + paramChatMessage);
      }
      if ((localMessageForShortVideo != null) && (aqhq.fileExistsAndNotEmpty(ShortVideoUtils.a(localMessageForShortVideo, "mp4")))) {
        paramaqoa.Z(2131366733, this.mContext.getString(2131693407), 2130839085);
      }
      this.Fb = true;
      return paramaqoa;
      paramChatMessage = "thumbFilePath=" + paramChatMessage + " , not exits.";
      i = 0;
      break;
      paramChatMessage = " msg == null or md5 is empty.";
      i = 0;
      break;
      paramChatMessage = paramChatMessage + "progeressBarShowing=" + bool1 + ", errorIconShowing=" + bool2;
      continue;
      paramChatMessage = " not inDPCWhiteList.";
      continue;
      bool1 = false;
      break label221;
    }
  }
  
  public BaseBubbleBuilder.d a(View paramView)
  {
    return null;
  }
  
  public BaseBubbleBuilder.e a()
  {
    return new b();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (!(paramChatMessage instanceof MessageForShortVideo)) {}
    do
    {
      MessageForShortVideo localMessageForShortVideo;
      do
      {
        do
        {
          do
          {
            return;
            localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
            this.bVu = paramInt;
            if (paramInt == 2131365686)
            {
              ujt.b(this.mContext, this.app, paramChatMessage);
              return;
            }
            if (paramInt == 2131372073)
            {
              super.m(paramChatMessage);
              return;
            }
            if (paramInt != 2131367523) {
              break;
            }
            d(localMessageForShortVideo);
          } while (!paramChatMessage.isMultiMsg);
          anot.a(this.app, "dc00898", "", "", "0X8009D66", "0X8009D66", 6, 0, "6", "", "", "");
          return;
          if (paramInt != 2131366733) {
            break;
          }
        } while (!e((MessageForShortVideo)paramChatMessage));
        aviz.a(localMessageForShortVideo).b(this.app, paramChatMessage).b((Activity)this.mContext, this.app.getAccount());
        avjg.a(this.app, 3, 0, paramChatMessage.istroop);
        avjg.a(this.app, 6, 5);
      } while (!paramChatMessage.isMultiMsg);
      anot.a(this.app, "dc00898", "", "", "0X8009D67", "0X8009D67", 6, 0, "6", "", "", "");
      return;
      if (paramInt == 2131372030)
      {
        e(localMessageForShortVideo);
        return;
      }
      if (paramInt != 2131372134) {
        break label337;
      }
      paramContext = a(paramChatMessage.uniseq);
      if (paramContext != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ShortVideoItemBuilder", 2, "onMenuItemClicked(), mute_play, holder == null, message.uniseq = " + paramChatMessage.uniseq);
    return;
    a(paramContext, true);
    anot.a(null, "dc00898", "", "", "0X8009F65", "0X8009F65", 2, 0, "", "", "", "");
    return;
    label337:
    if (paramInt == 2131377998)
    {
      B(paramChatMessage);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  public void a(View paramView, aoko paramaoko, int paramInt1, int paramInt2)
  {
    MessageForShortVideo localMessageForShortVideo;
    do
    {
      try
      {
        paramView = (b)wja.a(paramView);
        localMessageForShortVideo = (MessageForShortVideo)paramView.mMessage;
        VideoProgressView localVideoProgressView = paramView.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView;
        if (localMessageForShortVideo.uniseq != paramaoko.uniseq) {
          return;
        }
      }
      catch (Exception paramView)
      {
        QLog.e("ShortVideoItemBuilder", 2, "handleMessage getHolder error ! ", paramView);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "handleMessage msg.uniseq:" + localMessageForShortVideo.uniseq + ",fileType:" + ShortVideoUtils.fe(paramaoko.fileType) + " ===> fileStatus:" + ShortVideoUtils.ff(paramaoko.status));
      }
      if ((paramaoko.fileType == 6) || (paramaoko.fileType == 17) || (paramaoko.fileType == 9) || (paramaoko.fileType == 20))
      {
        c(paramaoko, paramView, localMessageForShortVideo);
        return;
      }
    } while ((paramaoko.fileType != 7) && (paramaoko.fileType != 18) && (paramaoko.fileType != 16));
    d(paramaoko, paramView, localMessageForShortVideo);
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
  
  public void a(aoko paramaoko, b paramb, MessageForShortVideo paramMessageForShortVideo)
  {
    b(paramb);
    a(paramb);
    int i;
    if ((paramaoko.urls != null) && (d(paramMessageForShortVideo)) && (!b(paramb)) && (!c(paramMessageForShortVideo)))
    {
      String[] arrayOfString = paramaoko.urls;
      paramaoko = paramaoko.domain;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "handleMessage VIDEO ==> STATUS_RECV_PROCESS: domain=" + paramaoko + ", videoUrls=" + Arrays.toString(arrayOfString));
      }
      String str = ShortVideoUtils.bw(paramMessageForShortVideo.thumbMD5, "jpg");
      int[] arrayOfInt = ShortVideoUtils.d(paramMessageForShortVideo.thumbWidth, paramMessageForShortVideo.thumbHeight);
      int j = arrayOfInt[0];
      int k = arrayOfInt[1];
      i = 0;
      while (i < 1)
      {
        if (!TextUtils.isEmpty(paramaoko)) {
          arrayOfString[i] = (arrayOfString[i] + "&txhost=" + paramaoko);
        }
        i += 1;
      }
      a(paramb, false, paramMessageForShortVideo, null, arrayOfString, str, j, k);
      if ((paramMessageForShortVideo.CheckIsHotVideo()) && (!aqfv.a().b(paramMessageForShortVideo, "0X8007EDB")))
      {
        aqfv.a().g(paramMessageForShortVideo, "0X8007EDB");
        anot.a(this.app, "dc00898", "", "", "0X8007EDB", "0X8007EDB", 0, 0, "", "", "", "");
      }
      if (!aqfv.a().b(paramMessageForShortVideo, "0X80077D9"))
      {
        i = kct.a(this.app, this.sessionInfo.aTl, this.sessionInfo.cZ);
        paramaoko = new JSONObject();
      }
    }
    try
    {
      paramaoko.put("uin", this.sessionInfo.aTl);
      paramaoko.put("memNum", i);
      paramaoko.put("msg_uniseq", paramMessageForShortVideo.uniseq);
      label356:
      kbp.a(null, "", "0X80077D9", "0X80077D9", 0, 0, "0", "", "0", kct.a(paramMessageForShortVideo.getMd5(), null, null, null, paramaoko), false);
      aqfv.a().g(paramMessageForShortVideo, "0X80077D9");
      return;
    }
    catch (Exception paramb)
    {
      break label356;
    }
  }
  
  void a(aqoi paramaqoi, b paramb, MessageForShortVideo paramMessageForShortVideo)
  {
    if (paramaqoi == null)
    {
      paramb.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      b(paramb);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "getBubbleView : --> STATUS_SEND_PROCESS, 上传过程中被杀进程然后恢复, uniseq:" + paramMessageForShortVideo.uniseq);
      }
      return;
    }
    if (((ambj)this.app.getManager(326)).x(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq))
    {
      paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setAnimProgress(10, paramMessageForShortVideo.frienduin + paramMessageForShortVideo.uniseq);
      paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
      return;
    }
    int j = paramMessageForShortVideo.videoFileProgress;
    int i = j;
    if ((paramaqoi instanceof aonu))
    {
      paramaqoi = (aonu)paramaqoi;
      i = j;
      if (paramaqoi.getFileSize() != 0L) {
        i = (int)(100L * paramaqoi.fF() / paramaqoi.getFileSize());
      }
    }
    a(paramb, ShortVideoUtils.aL(i, 10), false);
  }
  
  protected void a(b paramb)
  {
    if (a(paramb)) {
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoItemBuilder", 2, "disProgress...file is saving, so return!");
      }
    }
    do
    {
      return;
      if (!bw(paramb.mMessage.uniseq)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ShortVideoItemBuilder", 2, "disProgress fail...video order sending! " + paramb.mMessage.uniseq);
    return;
    if (!paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.sd(paramb.mMessage.frienduin + paramb.mMessage.uniseq))
    {
      paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(8);
      return;
    }
    paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setAnimRunnableListener(new xmv(this, paramb));
  }
  
  public void a(b paramb, int paramInt, boolean paramBoolean)
  {
    if (paramInt < 100)
    {
      paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setDrawStatus(1);
      paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setAnimProgress(paramInt, paramb.mMessage.frienduin + paramb.mMessage.uniseq);
    }
    for (;;)
    {
      paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
      paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVideoCompressStatus(false);
      paramb.JO.setVisibility(8);
      return;
      paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setDrawStatus(1);
      paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setAnimProgress(paramInt, paramb.mMessage.frienduin + paramb.mMessage.uniseq);
    }
  }
  
  public void a(b paramb, MessageForShortVideo paramMessageForShortVideo)
  {
    b(paramb);
    if (b(paramb)) {}
    do
    {
      return;
      paramb = ShortVideoUtils.bw(paramMessageForShortVideo.thumbMD5, "jpg");
    } while (aqhq.fileExistsAndNotEmpty(paramb));
    angi localangi = anfr.a(2, this.mBusiType);
    anfu localanfu = paramMessageForShortVideo.getDownloadInfo(localangi.dFl);
    localanfu.thumbPath = paramb;
    if ((paramMessageForShortVideo.istroop == 0) || (paramMessageForShortVideo.istroop == 1008)) {
      localanfu.fileType = 1002;
    }
    for (;;)
    {
      localangi.c(localanfu);
      localangi.p(paramMessageForShortVideo);
      anfr.a(localangi, this.app);
      return;
      if (paramMessageForShortVideo.istroop == 3000) {
        localanfu.fileType = 1006;
      } else if (paramMessageForShortVideo.istroop == 1) {
        localanfu.fileType = 1004;
      }
    }
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, long paramLong, boolean paramBoolean)
  {
    if (paramMessageForShortVideo.videoFileStatus == 998) {
      return;
    }
    if ((TextUtils.isEmpty(paramMessageForShortVideo.md5)) || (paramMessageForShortVideo.videoFileStatus == 1004))
    {
      QQToast.a(this.mContext, 2131720235, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
      return;
    }
    String str = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    boolean bool2 = NetworkUtils.isMobileConnected(this.mContext);
    if ((anfr.akU != 0L) && (System.currentTimeMillis() - anfr.akU < 300000L)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "startPlayVideo isConfirmed=" + bool1 + " allowPlayInXGTime=" + anfr.akU + " isXGConnected = " + bool2);
      }
      if ((!bool2) || (bool1) || ((aqhq.fileExists(str)) && (paramMessageForShortVideo.videoFileStatus != 2002)) || (paramMessageForShortVideo.videoFileSize < 1048576)) {
        break label348;
      }
      if (!armm.a((Activity)this.mContext, 3, new xmx(this, paramMessageForShortVideo, paramLong, paramBoolean))) {
        break;
      }
      str = this.mContext.getString(2131718418);
      this.w = aqha.a(this.mContext, 230, this.mContext.getString(2131718421), str, this.mContext.getString(2131718419), this.mContext.getString(2131718420), new xmy(this, paramMessageForShortVideo, paramLong, paramBoolean), new xmz(this));
      paramMessageForShortVideo = aiyw.a(this.mContext, this.app, 1, str);
      if ((paramMessageForShortVideo instanceof SpannableString)) {
        this.w.setMessageWithoutAutoLink(paramMessageForShortVideo);
      }
      try
      {
        this.w.show();
        return;
      }
      catch (Throwable paramMessageForShortVideo)
      {
        return;
      }
    }
    label348:
    b(paramMessageForShortVideo, paramLong, paramBoolean);
    ShortVideoUtils.a(this.app, "0X8008E53", this.sessionInfo, paramMessageForShortVideo, this.mContext);
  }
  
  void a(MessageForShortVideo paramMessageForShortVideo, b paramb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "getBubbleView ，video no exits: sendFromLocal=" + paramMessageForShortVideo.isSendFromLocal() + "===>  fileType:" + ShortVideoUtils.fe(paramMessageForShortVideo.fileType) + " ===> videoFileStatus:" + ShortVideoUtils.ff(paramMessageForShortVideo.videoFileStatus) + "===> videoFileProgress:" + paramMessageForShortVideo.videoFileProgress + ", uniseq:" + paramMessageForShortVideo.uniseq);
    }
    aqoi localaqoi = this.app.a().a(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
    if ((paramMessageForShortVideo.fileType == 6) || (paramMessageForShortVideo.fileType == 17) || (paramMessageForShortVideo.fileType == 9) || (paramMessageForShortVideo.fileType == 19) || (paramMessageForShortVideo.fileType == 20)) {}
    switch (paramMessageForShortVideo.videoFileStatus)
    {
    default: 
    case 1001: 
      do
      {
        return;
        if (localaqoi != null) {
          break;
        }
        paramb.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        b(paramb);
      } while (!QLog.isColorLevel());
      QLog.d("ShortVideoItemBuilder", 2, "getBubbleView : --> STATUS_SEND_START, 上传开始被杀进程然后恢复, uniseq:" + paramMessageForShortVideo.uniseq);
      return;
      a(paramb, ShortVideoUtils.aL(paramMessageForShortVideo.videoFileProgress, 10), false);
      return;
    case 1004: 
      paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
      paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.Wt(paramb.mMessage.frienduin + paramb.mMessage.uniseq);
      b(paramb);
      a(paramb, true, this);
      return;
    case 1002: 
      a(localaqoi, paramb, paramMessageForShortVideo);
      return;
    case 1003: 
      b(paramb);
      return;
    case 2001: 
      b(paramb);
      return;
    case 2004: 
      b(paramb);
      return;
    case 2002: 
      b(paramb);
      return;
    }
    a(paramb, 2131718875);
  }
  
  protected void a(MessageForShortVideo paramMessageForShortVideo, b paramb, String paramString, int paramInt1, int paramInt2)
  {
    if (paramMessageForShortVideo.isSendFromLocal())
    {
      paramb.JN.setText("");
      if (aqhq.fileExistsAndNotEmpty(paramString))
      {
        a(paramb, paramMessageForShortVideo, paramString, paramInt1, paramInt2, false);
        if (paramMessageForShortVideo.videoFileStatus != 1005) {
          break label64;
        }
        paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setDrawStatus(2);
        paramb.JO.setVisibility(8);
      }
    }
    label64:
    do
    {
      return;
      paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setDrawStatus(1);
      paramb.progressBar.setVisibility(8);
      paramb.JP.setVisibility(8);
      paramb.JO.setVisibility(8);
      paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
      if ((paramMessageForShortVideo.videoFileStatus != 998) || (a(paramMessageForShortVideo)))
      {
        paramb = new angw.a(this.app, this.mContext, paramMessageForShortVideo, this.a);
        angw.a().a(paramMessageForShortVideo.uniseq, paramb);
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoItemBuilder", 2, "getBubbleView(): msg.md5 == null, start compress task, id:" + paramMessageForShortVideo.uniseq);
        }
      }
      paramMessageForShortVideo = angw.a().a(paramMessageForShortVideo.uniseq);
    } while (paramMessageForShortVideo == null);
    paramMessageForShortVideo.a(this.a);
  }
  
  void a(String paramString, MessageForShortVideo paramMessageForShortVideo)
  {
    if ((paramMessageForShortVideo.CheckIsHotVideo()) && (QLog.isColorLevel()))
    {
      paramMessageForShortVideo = "logHotVideoError ";
      if (paramString != null) {
        paramMessageForShortVideo = "logHotVideoError " + paramString;
      }
      QLog.d("ShortVideoItemBuilder", 2, paramMessageForShortVideo);
    }
  }
  
  public boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (paramChatMessage.isMultiMsg) {}
    do
    {
      do
      {
        return false;
      } while (!paramChatMessage.isSendFromLocal());
      paramChatMessage = (MessageForShortVideo)paramChatMessage;
      if (paramChatMessage.videoFileStatus == 1005)
      {
        a("2131 msg.videoFileStatus == FileMsg.STATUS_SEND_ERROR", paramChatMessage);
        return true;
      }
    } while (paramChatMessage.md5 == null);
    int i;
    if (paramChatMessage.uiOperatorFlag == 2) {
      if ((paramChatMessage.videoFileStatus == 5002) || (paramChatMessage.videoFileStatus == 5001))
      {
        i = 1;
        label78:
        k = i;
        if (i != 0) {
          a("2145 forwardError = true msg.videoFileStatus is " + paramChatMessage.videoFileStatus, paramChatMessage);
        }
      }
    }
    for (int k = i;; k = 0)
    {
      if ((paramChatMessage.videoFileStatus == 1005) || (paramChatMessage.extraflag == 32768)) {
        a("2151 msg.extraflag == MessageRecordInfo.EXTRA_FLAG_SEND_FAIL sendError = true", paramChatMessage);
      }
      for (i = 1;; i = 0)
      {
        int j = i;
        if (paramChatMessage.uiOperatorFlag == 1)
        {
          j = i;
          if (paramChatMessage.videoFileStatus == 1004)
          {
            a("2152 msg send cancel:", paramChatMessage);
            j = 1;
          }
        }
        if (b(paramChatMessage)) {
          j = 1;
        }
        if ((k == 0) && (j == 0)) {
          break;
        }
        return true;
        i = 0;
        break label78;
      }
    }
  }
  
  protected boolean a(String paramString, MessageForShortVideo paramMessageForShortVideo, b paramb, int paramInt1, int paramInt2)
  {
    if ((paramMessageForShortVideo.videoFileStatus == 998) || (paramMessageForShortVideo.videoFileStatus == 1001) || (paramMessageForShortVideo.videoFileStatus == 1002) || (paramMessageForShortVideo.videoFileStatus == 1004)) {}
    for (int i = 1; (!d(paramMessageForShortVideo)) || ((paramMessageForShortVideo.isSendFromLocal()) && (i != 0)) || (b(paramb)) || (c(paramMessageForShortVideo)) || (bw(paramMessageForShortVideo.uniseq)); i = 0)
    {
      a(paramb, paramMessageForShortVideo, paramString, paramInt1, paramInt2, false);
      paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
      return true;
    }
    Object localObject = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "getBubbleView(): videoPath = " + (String)localObject);
    }
    File localFile = new File((String)localObject);
    long l1;
    label202:
    boolean bool1;
    label213:
    boolean bool2;
    if (localFile.exists())
    {
      long l2 = localFile.length();
      if (paramMessageForShortVideo.videoFileTime <= 8)
      {
        l1 = paramMessageForShortVideo.videoFileSize;
        if (l2 >= l1) {
          break label372;
        }
        bool1 = true;
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          QLog.d("ShortVideoItemBuilder", 2, "===> 1 video file  exits, downloadedSize =" + l2 + ", estimatedSize=" + l1 + ", needDownload=" + bool1 + ",videoFileTime=" + paramMessageForShortVideo.videoFileTime);
          bool2 = bool1;
        }
        label289:
        if (!bool2) {
          break label410;
        }
        if ((!aqiw.isWifiConnected(this.mContext)) || (paramMessageForShortVideo.videoFileStatus == 5002)) {
          break label399;
        }
        localObject = anfr.a(this.app, paramMessageForShortVideo, 2);
        if (localObject != null) {
          anfr.a((angi)localObject, this.app);
        }
      }
    }
    for (;;)
    {
      a(paramb, paramMessageForShortVideo, paramString, paramInt1, paramInt2, true);
      break;
      l1 = myh.a(8, paramMessageForShortVideo.videoFileTime, paramMessageForShortVideo.videoFileSize);
      break label202;
      label372:
      bool1 = false;
      break label213;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "===> 2 video file no exits, need download video.");
      }
      bool2 = true;
      break label289;
      label399:
      paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
    }
    label410:
    a(paramb, true, paramMessageForShortVideo, (String)localObject, null, paramString, paramInt1, paramInt2);
    if (paramMessageForShortVideo.videoFileTime <= 8) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      a(paramb);
      if (paramInt1 == 0) {
        paramb.JP.setVisibility(0);
      }
      c(paramMessageForShortVideo);
      return false;
    }
  }
  
  protected boolean a(String paramString, MessageForShortVideo paramMessageForShortVideo, b paramb, int paramInt1, int paramInt2, Drawable paramDrawable)
  {
    boolean bool2 = true;
    boolean bool1;
    if (aqhq.fileExistsAndNotEmpty(paramString)) {
      bool1 = a(paramString, paramMessageForShortVideo, paramb, paramInt1, paramInt2);
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          if (((paramMessageForShortVideo.fileType != 7) && (paramMessageForShortVideo.fileType != 18) && (paramMessageForShortVideo.fileType != 16)) || (paramMessageForShortVideo.videoFileStatus != 5002)) {
            break;
          }
          paramb.JP.setVisibility(8);
          paramb.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
          paramb.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.showCover(paramDrawable);
          a(paramb, 2131718875);
          bool1 = bool2;
        } while (!QLog.isColorLevel());
        QLog.d("ShortVideoItemBuilder", 2, "getBubbleView not download pic : 缩略图不存在，而且文件已经过期，不下载, , uniseq:" + paramMessageForShortVideo.uniseq);
        return true;
        bool1 = bool2;
      } while (paramMessageForShortVideo.extraflag == 32768);
      bool1 = bool2;
    } while (b(paramb));
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "getBubbleView not SendFromLocal : 缩略图不存在，开始下载缩略图, , uniseq:" + paramMessageForShortVideo.uniseq);
    }
    paramb.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
    paramb.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.showCover(paramDrawable);
    paramString = anfr.a(2, this.mBusiType);
    paramb = paramMessageForShortVideo.getDownloadInfo(paramString.dFl);
    paramb.thumbPath = ShortVideoUtils.bw(paramMessageForShortVideo.thumbMD5, "jpg");
    if ((paramMessageForShortVideo.istroop == 0) || (paramMessageForShortVideo.istroop == 1008)) {
      paramb.fileType = 1002;
    }
    for (;;)
    {
      paramb.mRequestType = 2;
      paramString.c(paramb);
      paramString.p(paramMessageForShortVideo);
      anfr.a(paramString, this.app);
      return true;
      if (paramMessageForShortVideo.istroop == 3000) {
        paramb.fileType = 1006;
      } else if (paramMessageForShortVideo.istroop == 1) {
        paramb.fileType = 1004;
      }
    }
  }
  
  public aqob[] a(View paramView)
  {
    paramView = (b)wja.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.mMessage;
    aqoa localaqoa = new aqoa();
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
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
    b localb = (b)parama;
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "getMenuItem, msg.uniseq:" + localMessageForShortVideo.uniseq + ",fileType===>" + ShortVideoUtils.fe(localMessageForShortVideo.fileType) + " ===> fileStatus:" + ShortVideoUtils.ff(localMessageForShortVideo.videoFileStatus));
    }
    b(paramaqoa, this.mContext);
    int i;
    boolean bool1;
    label223:
    boolean bool2;
    if ((localMessageForShortVideo != null) && (!TextUtils.isEmpty(localMessageForShortVideo.md5)))
    {
      parama = ShortVideoUtils.bw(localMessageForShortVideo.thumbMD5, "jpg");
      if (aqhq.fileExistsAndNotEmpty(parama))
      {
        parama = "";
        i = 1;
        if (i == 0) {
          break label618;
        }
        if (!"1".equals(DeviceProfileManager.a().aJ(DeviceProfileManager.AccountDpcManager.DpcAccountNames.shortvideo_forward_switch.name(), "1"))) {
          break label599;
        }
        boolean bool3 = localMessageForShortVideo.checkForward();
        if ((localb.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView == null) || (!localb.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.sd(localb.mMessage.frienduin + localb.mMessage.uniseq))) {
          break label612;
        }
        bool1 = true;
        if ((localb.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.sc == null) || (localb.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.sc.getVisibility() != 0)) {
          break label606;
        }
        bool2 = true;
        label251:
        if ((!bool3) || (bool1) || (bool2)) {
          break label559;
        }
        paramaqoa.Z(2131367523, this.mContext.getString(2131721067), 2130839086);
        parama = parama + "inMiddleStatus = false, progeressBarShowing = false, errorIconShowing = false, show forward menu.";
      }
    }
    label559:
    label599:
    label606:
    label612:
    label618:
    for (;;)
    {
      a(localMessageForShortVideo, paramaqoa);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "getMenuItem: " + parama);
      }
      if ((localMessageForShortVideo != null) && ((localb.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.sc == null) || (localb.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.sc.getVisibility() != 0))) {
        a(paramaqoa, this.sessionInfo.cZ, localMessageForShortVideo);
      }
      a(paramaqoa, localMessageForShortVideo);
      if ((localMessageForShortVideo != null) && (aqhq.fileExistsAndNotEmpty(ShortVideoUtils.a(localMessageForShortVideo, "mp4")))) {
        paramaqoa.Z(2131366733, this.mContext.getString(2131693407), 2130839085);
      }
      super.a(paramaqoa, this.mContext, localMessageForShortVideo, false);
      b(paramChatMessage, paramaqoa);
      super.c(paramaqoa, this.mContext);
      super.e(paramaqoa, this.mContext);
      if ((localMessageForShortVideo != null) && (augo.g(this.app, localMessageForShortVideo))) {
        paramaqoa.Z(2131377998, this.mContext.getString(2131719492), 2130840517);
      }
      this.Fb = true;
      return paramaqoa;
      parama = "thumbFilePath=" + parama + " , not exits.";
      i = 0;
      break;
      parama = " msg == null or md5 is empty.";
      i = 0;
      break;
      parama = parama + "progeressBarShowing=" + bool1 + ", errorIconShowing=" + bool2;
      continue;
      parama = " not inDPCWhiteList.";
      continue;
      bool2 = false;
      break label251;
      bool1 = false;
      break label223;
    }
  }
  
  public String b(ChatMessage paramChatMessage)
  {
    if (aqiu.ms(paramChatMessage.issend)) {
      return acfp.m(2131714471);
    }
    return acfp.m(2131714523);
  }
  
  public void b(aoko paramaoko, b paramb, MessageForShortVideo paramMessageForShortVideo)
  {
    int j = 0;
    int i;
    if (paramMessageForShortVideo.isSendFromLocal())
    {
      if (paramaoko.fileSize == 0L) {
        break label49;
      }
      i = (int)(100L * paramaoko.transferedSize / paramaoko.fileSize);
    }
    for (;;)
    {
      a(paramb, ShortVideoUtils.aL(i, 10), true);
      return;
      label49:
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.e("ShortVideoItemBuilder", 2, "handleMessage VIDEO ==> STATUS_SEND_PROCESS: fileSize == 0 ");
        i = j;
      }
    }
  }
  
  protected void b(b paramb)
  {
    if (a(paramb)) {
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoItemBuilder", 2, "hideProgress...file is saving, so return!");
      }
    }
    do
    {
      return;
      if (!bw(paramb.mMessage.uniseq)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ShortVideoItemBuilder", 2, "hideProgress fail...video order sending! " + paramb.mMessage.uniseq);
    return;
    paramb.JO.setVisibility(8);
    if (!paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.sd(paramb.mMessage.frienduin + paramb.mMessage.uniseq))
    {
      paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setDrawStatus(2);
      return;
    }
    paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setAnimRunnableListener(new xmt(this, paramb));
  }
  
  public void b(MessageForShortVideo paramMessageForShortVideo, long paramLong, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("muate_play", paramBoolean);
    a(paramMessageForShortVideo, paramLong, this.mContext, this.app, this.sessionInfo, localBundle, null);
    ThreadManager.getFileThreadHandler().post(this.es);
  }
  
  protected boolean b(MessageForShortVideo paramMessageForShortVideo)
  {
    if (this.app.a().a(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq) == null) {
      if (paramMessageForShortVideo.CheckIsHotVideo())
      {
        if ((paramMessageForShortVideo.videoFileProgress != 100) && (paramMessageForShortVideo.videoFileStatus != 1003) && (paramMessageForShortVideo.videoFileStatus != 1004) && (paramMessageForShortVideo.videoFileStatus != 2009) && (paramMessageForShortVideo.uiOperatorFlag != 2) && (paramMessageForShortVideo.videoFileStatus != 2003) && (paramMessageForShortVideo.videoFileStatus != 2002)) {
          a("2164 msg.videoFileProgress = " + paramMessageForShortVideo.videoFileProgress + " msg.videoFileStatus = " + paramMessageForShortVideo.videoFileStatus, paramMessageForShortVideo);
        }
      }
      else {
        while ((paramMessageForShortVideo.videoFileProgress != 100) && (paramMessageForShortVideo.videoFileStatus != 1003) && (paramMessageForShortVideo.videoFileStatus != 1004) && (paramMessageForShortVideo.videoFileStatus != 2009) && (paramMessageForShortVideo.uiOperatorFlag != 2) && (paramMessageForShortVideo.videoFileStatus != 2003) && (paramMessageForShortVideo.videoFileStatus != 998) && (paramMessageForShortVideo.isAllowAutoDown == true)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public void bYO()
  {
    super.bYO();
    this.bVu = -1;
    this.Fb = false;
  }
  
  public void c(aoko paramaoko, b paramb, MessageForShortVideo paramMessageForShortVideo)
  {
    switch (paramaoko.status)
    {
    default: 
      return;
    case 1001: 
      if (paramaoko.fileSize == 0L) {
        break;
      }
    }
    for (int i = (int)(100L * paramaoko.transferedSize / paramaoko.fileSize);; i = 0)
    {
      a(paramb, ShortVideoUtils.aL(i, 10), true);
      paramb.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
      c(paramb);
      return;
      a(paramb, 100, true);
      b(paramb);
      b(paramb, false, null);
      angw.a().removeTask(paramb.mMessage.uniseq);
      return;
      b(paramb);
      paramb.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      angw.a().removeTask(paramb.mMessage.uniseq);
      return;
      paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.Wt(paramb.mMessage.frienduin + paramb.mMessage.uniseq);
      b(paramb);
      a(paramb, true, this);
      angw.a().removeTask(paramb.mMessage.uniseq);
      return;
      b(paramb);
      b(paramb, false, null);
      angw.a().removeTask(paramb.mMessage.uniseq);
      return;
      b(paramaoko, paramb, paramMessageForShortVideo);
      return;
      b(paramb);
      paramb.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
      return;
      a(paramb, paramMessageForShortVideo);
      return;
      b(paramb);
      if (paramaoko.errorCode == -5100528) {
        break;
      }
      QQToast.a(this.mContext, 2131720272, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
      return;
      a(paramb, 2131718874);
      if (paramMessageForShortVideo.uiOperatorFlag == 2)
      {
        paramb.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        QQToast.a(this.mContext, 2131720245, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
        return;
      }
      QQToast.a(this.mContext, 2131720270, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
      return;
      a(paramb, 2131718875);
      if (paramMessageForShortVideo.uiOperatorFlag == 2)
      {
        paramb.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        QQToast.a(this.mContext, 2131720246, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
        return;
      }
      QQToast.a(this.mContext, 2131720271, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
      return;
      b(paramb);
      return;
      a(paramaoko, paramb, paramMessageForShortVideo);
      return;
    }
  }
  
  protected void c(MessageForShortVideo paramMessageForShortVideo)
  {
    if ((paramMessageForShortVideo.CheckIsHotVideo()) && (!aqfv.a().b(paramMessageForShortVideo, "0X8007EDB")))
    {
      aqfv.a().g(paramMessageForShortVideo, "0X8007EDB");
      anot.a(this.app, "dc00898", "", "", "0X8007EDB", "0X8007EDB", 0, 0, "", "", "", "");
    }
    int i;
    JSONObject localJSONObject;
    if (!aqfv.a().b(paramMessageForShortVideo, "0X80077D9"))
    {
      i = kct.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.sessionInfo.aTl, this.sessionInfo.cZ);
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("uin", this.sessionInfo.aTl);
      localJSONObject.put("memNum", i);
      localJSONObject.put("msg_uniseq", paramMessageForShortVideo.uniseq);
      label150:
      kbp.a(null, "", "0X80077D9", "0X80077D9", 0, 0, "0", "", "0", kct.a(paramMessageForShortVideo.getMd5(), null, null, null, localJSONObject), false);
      aqfv.a().g(paramMessageForShortVideo, "0X80077D9");
      return;
    }
    catch (Exception localException)
    {
      break label150;
    }
  }
  
  public void c(MessageForShortVideo paramMessageForShortVideo, b paramb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "startUploadVideo：" + paramMessageForShortVideo.toString());
    }
    boolean bool = paramMessageForShortVideo.CheckIsHotVideo();
    String str1 = paramMessageForShortVideo.videoFileName;
    String str2 = ShortVideoUtils.bw(paramMessageForShortVideo.thumbMD5, "jpg");
    if ((!aqhq.fileExistsAndNotEmpty(str1)) && (!bool))
    {
      QQToast.a(this.mContext, 1, 2131720277, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
      b(paramb);
      paramb.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    if ((!aqhq.fileExistsAndNotEmpty(str2)) && (!bool))
    {
      QQToast.a(this.mContext, 1, 2131720278, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
      b(paramb);
      paramb.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    ((ambj)this.app.getManager(326)).a(this.sessionInfo.aTl, paramMessageForShortVideo, paramMessageForShortVideo.videoFileName);
    paramb = anfr.a(1, this.mBusiType);
    paramMessageForShortVideo = anfr.a(this.mBusiType, paramMessageForShortVideo, paramb);
    paramMessageForShortVideo.cjw = bool;
    paramb.c(paramMessageForShortVideo);
    anfr.a(paramb, this.app);
  }
  
  public void d(aoko paramaoko, b paramb, MessageForShortVideo paramMessageForShortVideo)
  {
    switch (paramaoko.status)
    {
    default: 
    case 2001: 
    case 2003: 
    case 2005: 
      label258:
      label270:
      do
      {
        int k;
        do
        {
          do
          {
            return;
          } while (!QLog.isColorLevel());
          QLog.d("ShortVideoItemBuilder", 2, "handleMessage THUMB ==> STATUS_RECV_START:");
          return;
          paramaoko = ShortVideoUtils.bw(paramMessageForShortVideo.thumbMD5, "jpg");
          localObject = ShortVideoUtils.d(paramMessageForShortVideo.thumbWidth, paramMessageForShortVideo.thumbHeight);
          j = localObject[0];
          k = localObject[1];
        } while ((!d(paramMessageForShortVideo)) || (b(paramb)) || (c(paramMessageForShortVideo)));
        Object localObject = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
        File localFile = new File((String)localObject);
        long l1;
        if (localFile.exists())
        {
          long l2 = localFile.length();
          if (paramMessageForShortVideo.videoFileTime <= 8)
          {
            l1 = paramMessageForShortVideo.videoFileSize;
            if (l2 < l1) {
              break label258;
            }
            i = 0;
          }
        }
        for (;;)
        {
          if (i == 0) {
            break label270;
          }
          if (aqiw.isWifiConnected(this.mContext))
          {
            localObject = anfr.a(this.app, paramMessageForShortVideo, 2);
            if (localObject != null) {
              anfr.a((angi)localObject, this.app);
            }
          }
          a(paramb, paramMessageForShortVideo, paramaoko, j, k, true);
          return;
          l1 = myh.a(8, paramMessageForShortVideo.videoFileTime, paramMessageForShortVideo.videoFileSize);
          break;
          i = 1;
          continue;
          i = 1;
        }
        if (paramMessageForShortVideo.videoFileTime <= 8) {}
        for (i = 1;; i = 0)
        {
          a(paramb, true, paramMessageForShortVideo, (String)localObject, null, paramaoko, j, k);
          a(paramb);
          if (i == 0) {
            break;
          }
          paramb.JP.setVisibility(8);
          return;
        }
        paramb.JP.setVisibility(0);
        return;
      } while (!QLog.isColorLevel());
      QLog.d("ShortVideoItemBuilder", 2, "handleMessage THUMB ==> STATUS_RECV_ERROR:");
      return;
    }
    paramaoko = ShortVideoUtils.d(paramMessageForShortVideo.thumbWidth, paramMessageForShortVideo.thumbHeight);
    int i = paramaoko[0];
    int j = paramaoko[1];
    paramb.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
    paramb.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.showCover(b(i, j));
    a(paramb, 2131718875);
    paramb.JP.setVisibility(8);
  }
  
  public void d(MessageForShortVideo paramMessageForShortVideo)
  {
    if (TextUtils.isEmpty(paramMessageForShortVideo.md5))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "Forward menu clicked, md5 is empty.");
      }
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 21);
    localBundle.putBoolean("forward_is_long_video", true);
    localBundle.putBoolean("forward_need_sendmsg", true);
    String str1 = ShortVideoUtils.bw(paramMessageForShortVideo.thumbMD5, "jpg");
    localBundle.putString("forward_thumb", str1);
    localBundle.putInt("selection_mode", this.bOY);
    localBundle.putString("from_uin", ShortVideoUtils.f(paramMessageForShortVideo));
    localBundle.putInt("from_uin_type", this.sessionInfo.cZ);
    localBundle.putString("from_session_uin", this.sessionInfo.aTl);
    localBundle.putInt("from_busi_type", paramMessageForShortVideo.busiType);
    localBundle.putInt("file_send_size", paramMessageForShortVideo.videoFileSize);
    localBundle.putInt("file_send_duration", paramMessageForShortVideo.videoFileTime);
    localBundle.putString("file_name", paramMessageForShortVideo.videoFileName);
    localBundle.putInt("file_format", paramMessageForShortVideo.videoFileFormat);
    String str2 = ShortVideoUtils.e(paramMessageForShortVideo);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "Forward menu clicked, videoPath=" + str2 + ",videoPath = " + str2 + ", " + paramMessageForShortVideo.toLogString());
    }
    localBundle.putString("file_send_path", str2);
    localBundle.putString("thumbfile_send_path", str1);
    localBundle.putString("file_shortvideo_md5", paramMessageForShortVideo.md5);
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
    localBundle.putInt("short_video_msg_tail_type", paramMessageForShortVideo.msgTailType);
    localBundle.putLong("from_msg_uniseq", paramMessageForShortVideo.uniseq);
    if (paramMessageForShortVideo.CheckIsHotVideo())
    {
      localBundle.putString("hot_video_icon", paramMessageForShortVideo.hotVideoIconUrl);
      localBundle.putString("hot_video_icon_sub", paramMessageForShortVideo.hotVideoSubIconUrl);
      localBundle.putString("hot_video_title", paramMessageForShortVideo.hotVideoTitle);
      localBundle.putString("hot_video_url", paramMessageForShortVideo.hotVideoUrl);
    }
    localBundle.putParcelable("key_message_for_shortvideo", paramMessageForShortVideo);
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
    ahgq.f((Activity)this.mContext, paramMessageForShortVideo, 21);
    anot.a(this.app, "CliOper", "", "", "0X80052CC", "0X80052CC", 0, 0, "", "1", "", "");
  }
  
  public void d(MessageForShortVideo paramMessageForShortVideo, b paramb)
  {
    if (paramMessageForShortVideo == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "reForwardVideo：" + paramMessageForShortVideo.toString());
      }
      if (!aqhq.fileExistsAndNotEmpty(ShortVideoUtils.bw(paramMessageForShortVideo.thumbMD5, "jpg")))
      {
        QQToast.a(this.mContext, 1, 2131720278, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
        b(paramb);
        paramb.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        paramMessageForShortVideo.videoFileStatus = 1005;
        return;
      }
      if (!TextUtils.isEmpty(paramMessageForShortVideo.videoFileName))
      {
        ((ambj)this.app.getManager(326)).a(this.sessionInfo.aTl, paramMessageForShortVideo, paramMessageForShortVideo.videoFileName);
        paramb = anfr.a(4, this.mBusiType);
        paramb.b(anfr.a(this.mBusiType, paramMessageForShortVideo, paramb));
        anfr.a(paramb, this.app);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ShortVideoItemBuilder", 2, "ShortVideoItemBuilder:reForwardVideo() path is empty");
  }
  
  public void destroy()
  {
    super.destroy();
    if ((this.w != null) && (this.w.isShowing()))
    {
      this.w.dismiss();
      this.w = null;
    }
    if (jdField_g_of_type_JavaUtilConcurrentCopyOnWriteArraySet != null)
    {
      Iterator localIterator = jdField_g_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
      while (localIterator.hasNext())
      {
        CropBubbleVideoView localCropBubbleVideoView = (CropBubbleVideoView)localIterator.next();
        if (localCropBubbleVideoView != null)
        {
          long l = localCropBubbleVideoView.getCurPlayingPos();
          if (l > 0L)
          {
            MessageForShortVideo localMessageForShortVideo = aqfv.a().a(Integer.valueOf(localCropBubbleVideoView.getId()));
            if (localMessageForShortVideo != null) {
              a(localMessageForShortVideo, l);
            }
          }
          localCropBubbleVideoView.releasePlayer(false);
          jdField_g_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(localCropBubbleVideoView);
        }
      }
    }
  }
  
  public void e(MessageForShortVideo paramMessageForShortVideo)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "onMenuItemClicked(): msg_revoke =>" + paramMessageForShortVideo.toLogString());
    }
    if (paramMessageForShortVideo.md5 == null)
    {
      angw.a().ln(paramMessageForShortVideo.uniseq);
      v.set(paramMessageForShortVideo.uniseq);
      ((QQMessageFacade)this.app.getManager(20)).a(paramMessageForShortVideo.istroop).x(paramMessageForShortVideo);
      ambj.k(this.app, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
      anot.a(this.app, "CliOper", "", "", "0X80056B1", "0X80056B1", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      return;
      aqoi localaqoi = this.app.a().a(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
      if ((localaqoi != null) && ((aonu.class.isInstance(localaqoi)) || (aonn.class.isInstance(localaqoi))))
      {
        boolean bool = ((aojn)localaqoi).isPause();
        i = paramMessageForShortVideo.videoFileStatus;
        if ((bool) || (i == 1002) || (i == 1001))
        {
          this.app.a().B(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
          ((QQMessageFacade)this.app.getManager(20)).a(paramMessageForShortVideo.istroop).x(paramMessageForShortVideo);
          anot.a(this.app, "CliOper", "", "", "0X80056B1", "0X80056B1", 0, 0, "", "", "", "");
          i = j;
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoItemBuilder", 2, "onMenuItemClicked: stop uploading short video");
          }
        }
      }
      for (int i = j; i != 0; i = 1)
      {
        super.j(paramMessageForShortVideo);
        return;
      }
    }
  }
  
  public void ei(View paramView)
  {
    super.ei(paramView);
    paramView = (b)wja.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.mMessage;
    if (localMessageForShortVideo.isSendFromLocal())
    {
      ausj localausj = (ausj)auss.a(this.mContext, null);
      localausj.addButton(2131690230, 5);
      localausj.addCancelButton(2131721058);
      localausj.a(new xna(this, localMessageForShortVideo, paramView, localausj));
      localausj.show();
      if (localMessageForShortVideo.videoFileStatus == 1004) {
        ShortVideoUtils.fW("0X800A374", this.sessionInfo.cZ);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    Object localObject1 = (b)wja.a(paramView);
    bm = a(paramView, (MessageForShortVideo)((b)localObject1).mMessage);
    wja.bcO = true;
    long l = System.currentTimeMillis();
    if ((l - lastClickTime < 1000L) && (l > lastClickTime)) {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoItemBuilder", 2, "click too offen,please try again later ");
      }
    }
    StringBuilder localStringBuilder;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      lastClickTime = l;
      if ((paramView.getId() == 2131364503) || (paramView.getId() == 2131364545))
      {
        a((b)localObject1, false);
      }
      else if (paramView.getId() == 2131364522)
      {
        localStringBuilder = new StringBuilder();
        if (!((b)localObject1).mMessage.isMultiMsg)
        {
          localObject2 = this.app.a().a(((b)localObject1).mMessage.frienduin, ((b)localObject1).mMessage.uniseq);
          if ((!(localObject2 instanceof aonu)) || (!((aonu)localObject2).cNt)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoItemBuilder", 2, "CompressTask pauseOperator!");
          }
        }
      }
    }
    Object localObject2 = angw.a().a(((b)localObject1).mMessage.uniseq);
    if (localObject2 != null)
    {
      ((angw.a)localObject2).p.isPause = true;
      boolean bool = ((angw.a)localObject2).cancel(true);
      localStringBuilder.append("\n ShortVideoItemBuilder task cancel:").append(bool);
      localStringBuilder.append("\n md5 info:").append(((MessageForShortVideo)((b)localObject1).mMessage).md5);
      if ((bool) && (((MessageForShortVideo)((b)localObject1).mMessage).md5 == null))
      {
        bool = ((angw.a)localObject2).awP();
        localStringBuilder.append("\n media codec cancel:").append(bool);
        if (!bool) {
          break label444;
        }
        localStringBuilder.append("\n ffmpeg process cancel!");
      }
    }
    for (;;)
    {
      localObject1 = this.app.a().a(((b)localObject1).mMessage.frienduin, ((b)localObject1).mMessage.uniseq);
      if ((localObject1 instanceof aonu))
      {
        ((aonu)localObject1).pause();
        localStringBuilder.append("\n upload process pause!");
      }
      ShortVideoUtils.fW("0X800A373", this.sessionInfo.cZ);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ShortVideoItemBuilder", 2, "CompressTask pauseOperator info:" + localStringBuilder.toString());
      break;
      label444:
      localStringBuilder.append("\n ffmpeg process cancel exception!");
    }
  }
  
  public void p(ChatMessage paramChatMessage)
  {
    anot.a(this.app, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "3", "", "", "");
  }
  
  class ChatVideoView
    extends BubbleVideoView
  {
    public ChatVideoView(Context paramContext)
    {
      super();
    }
  }
  
  public class a
    implements angw.b
  {
    private a() {}
    
    public void a(MessageForShortVideo paramMessageForShortVideo, float paramFloat)
    {
      ShortVideoItemBuilder.b localb = ShortVideoItemBuilder.a(ShortVideoItemBuilder.this, paramMessageForShortVideo);
      if (localb == null) {
        return;
      }
      paramMessageForShortVideo = paramMessageForShortVideo.frienduin + paramMessageForShortVideo.uniseq;
      localb.a.setAnimProgress(acfp.m(2131714499), paramMessageForShortVideo);
      localb.a.f(paramMessageForShortVideo, paramFloat);
    }
    
    public void a(MessageForShortVideo paramMessageForShortVideo, int paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "CompressUpdateListener,onFinish. seq = " + paramMessageForShortVideo.uniseq);
      }
      aurs.runOnUiThread(new ShortVideoItemBuilder.CompressUpdateListenerImpl.2(this, paramMessageForShortVideo, paramInt));
    }
    
    public void a(MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean)
    {
      ShortVideoItemBuilder.b localb = ShortVideoItemBuilder.a(ShortVideoItemBuilder.this, paramMessageForShortVideo);
      if (localb == null) {
        return;
      }
      aurs.runOnUiThread(new ShortVideoItemBuilder.CompressUpdateListenerImpl.1(this, paramMessageForShortVideo, paramBoolean, localb));
    }
  }
  
  public class b
    extends BaseBubbleBuilder.e
  {
    public TextView JN;
    public TextView JO;
    public TextView JP;
    public TextView JQ;
    public VideoProgressView a;
    public CropBubbleVideoView a;
    public RelativeLayout bottomBar;
    public TextView fZ;
    public ProgressBar progressBar;
    public ImageView tx;
    public URLDrawable u;
    
    public b() {}
    
    public void cdi()
    {
      if (this.a != null)
      {
        long l = this.a.getCurPlayingPos();
        if (l > 0L)
        {
          MessageForShortVideo localMessageForShortVideo = aqfv.a().a(Integer.valueOf(this.a.getId()));
          if (localMessageForShortVideo != null) {
            ShortVideoItemBuilder.a(ShortVideoItemBuilder.this, localMessageForShortVideo, l);
          }
        }
        this.a.releasePlayer(true);
        ShortVideoItemBuilder.b().remove(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder
 * JD-Core Version:    0.7.0.1
 */