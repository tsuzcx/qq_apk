package com.tencent.mobileqq.activity.aio.item;

import acfp;
import afei;
import ainb;
import ainb.a;
import ambw;
import anbb;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
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
import anot;
import aojn;
import aoko;
import aooi;
import aoop;
import aqfv;
import aqhq;
import aqoa;
import aqob;
import ausj;
import auss;
import aviz;
import avjg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AudioPlayerBase;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.d;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager.a;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.mobileqq.widget.BubbleVideoView;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import com.tencent.widget.XListView;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import rar;
import ujt;
import wja;
import wla.a;
import wlz;
import xiu;
import xiv;
import xiw;
import xix;
import xkx;
import xlg;

public class LightVideoItemBuilder
  extends xlg
  implements ainb.a, anft, MediaPlayerManager.a, wla.a
{
  static int bTl;
  static int bTm;
  static int bTn;
  static int bTo;
  static int bTp;
  static int bTq;
  static int bTr;
  protected static ColorDrawable h;
  private static Map<Long, MessageForLightVideo> hL = new ConcurrentHashMap();
  private long IS;
  private MessageForLightVideo a;
  private ListView b;
  private int bTk;
  private AudioPlayerBase c;
  private Handler mHandler = new Handler(Looper.getMainLooper());
  private int thumbHeight;
  private int thumbWidth;
  
  static
  {
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    bTp = BaseChatItemLayout.bNT;
    bTp = Math.min(wja.dp2px(320.0F, localResources), bTp);
    bTq = wja.dp2px(100.0F, localResources);
    bTr = wja.dp2px(100.0F, localResources);
    bTn = wja.dp2px(160.0F, localResources);
    bTo = wja.dp2px(160.0F, localResources);
    h = new afei(-10065297, bTn, bTo);
    bTl = wja.dp2px(8.0F, localResources);
    bTm = wja.dp2px(3.0F, localResources);
  }
  
  public LightVideoItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    if (paramAIOAnimationConatiner != null) {
      this.b = paramAIOAnimationConatiner.b();
    }
    ainb.a().a(this);
  }
  
  private void a(int paramInt, a parama, MessageForLightVideo paramMessageForLightVideo)
  {
    ChatVideoView localChatVideoView = parama.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView;
    switch (paramInt)
    {
    default: 
      return;
    case 2001: 
      c(paramMessageForLightVideo, "THUMB STATUS_RECV_START");
      return;
    case 2003: 
      c(paramMessageForLightVideo, "THUMB STATUS_RECV_FINISHED");
      b(parama, paramMessageForLightVideo, localChatVideoView);
      return;
    }
    c(paramMessageForLightVideo, "THUMB STATUS_FILE_EXPIRED");
  }
  
  private void a(AudioPlayerBase paramAudioPlayerBase, a parama, int paramInt)
  {
    if ((parama == null) || (paramAudioPlayerBase == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoItemBuilder", 2, "refreshVideoWithEarModeJudge! uniseq:" + parama.mMessage.uniseq + " ,loudSpeaker:" + ainb.ckG + " ,position:" + paramInt);
    }
    try
    {
      paramAudioPlayerBase.bYG();
      if (ainb.ckG)
      {
        if (paramAudioPlayerBase.isPlaying()) {
          paramAudioPlayerBase.stop();
        }
        a(parama, false, false, paramInt, true, false);
        return;
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
      a(parama, false, true, paramInt, true, false);
      paramAudioPlayerBase.seekPlay(ShortVideoUtils.a((MessageForShortVideo)parama.mMessage, "mp4"), paramInt + 1000);
    }
  }
  
  private void a(ChatVideoView paramChatVideoView, String paramString, int paramInt1, int paramInt2)
  {
    if (paramChatVideoView.hM(paramString)) {
      paramChatVideoView.setURLDrawable(ainb.a(paramString, paramInt2, paramInt1));
    }
    do
    {
      return;
      paramString = paramChatVideoView.n;
    } while ((paramString == null) || (paramString.getStatus() != 1));
    paramChatVideoView.setURLDrawable(paramString);
  }
  
  private void a(a parama, MessageForLightVideo paramMessageForLightVideo, ChatVideoView paramChatVideoView)
  {
    if (d(paramMessageForLightVideo))
    {
      a(parama, false, false, 0, false, false);
      a(parama, paramMessageForLightVideo, 1);
    }
    do
    {
      return;
      if (p(paramMessageForLightVideo))
      {
        paramChatVideoView = ShortVideoUtils.bw(paramMessageForLightVideo.thumbMD5, "jpg");
        a(parama.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView, paramChatVideoView, this.thumbHeight, this.thumbWidth);
        a(parama, paramMessageForLightVideo, 2);
        return;
      }
      if (!q(paramMessageForLightVideo)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("LightVideoItemBuilder", 2, "shouldBePlayed uniseq:" + this.IS + " ,currPosition:" + this.bTk);
      }
      if (this.bTk > 0)
      {
        a(this.c, parama, 0);
        a(parama, paramMessageForLightVideo, 1);
        this.bTk = 0;
        this.IS = 0L;
        return;
      }
    } while (MediaPlayerManager.a(this.app).k(paramMessageForLightVideo));
    QQToast.a(this.mContext, 1, 2131697384, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
    return;
    if (a(parama, paramMessageForLightVideo, paramChatVideoView))
    {
      a(parama, paramMessageForLightVideo, 3);
      return;
    }
    a(parama, paramMessageForLightVideo, 0);
  }
  
  private void a(a parama, boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3, boolean paramBoolean4) {}
  
  private boolean a(MessageForLightVideo paramMessageForLightVideo, a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoItemBuilder", 2, "startUploadVideo! uniseq:" + paramMessageForLightVideo.uniseq);
    }
    String str1 = paramMessageForLightVideo.videoFileName;
    String str2 = ShortVideoUtils.bw(paramMessageForLightVideo.thumbMD5, "jpg");
    if (!aqhq.fileExistsAndNotEmpty(str1))
    {
      QQToast.a(this.mContext, 1, 2131720277, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
      paramMessageForLightVideo.videoFileStatus = 1005;
      return false;
    }
    if (!aqhq.fileExistsAndNotEmpty(str2))
    {
      QQToast.a(this.mContext, 1, 2131720278, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
      parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForLightVideo.videoFileStatus = 1005;
      return false;
    }
    paramMessageForLightVideo.mThumbFilePath = str2;
    parama = ambw.a(paramMessageForLightVideo);
    parama.dQ = paramMessageForLightVideo.videoFileName;
    parama.mMd5 = paramMessageForLightVideo.mLocalMd5;
    this.app.a().a(parama);
    return true;
  }
  
  private void b(int paramInt, a parama, MessageForLightVideo paramMessageForLightVideo)
  {
    ChatVideoView localChatVideoView = parama.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView;
    int i;
    if (paramMessageForLightVideo.thumbWidth > 0)
    {
      i = paramMessageForLightVideo.thumbWidth;
      label19:
      if (paramMessageForLightVideo.thumbHeight <= 0) {
        break label156;
      }
    }
    label156:
    for (int j = paramMessageForLightVideo.thumbHeight;; j = 100) {
      switch (paramInt)
      {
      default: 
        return;
        i = 100;
        break label19;
      }
    }
    c(paramMessageForLightVideo, "VIDEO STATUS_UPLOAD_FINISHED progress " + paramMessageForLightVideo.videoFileProgress);
    return;
    c(paramMessageForLightVideo, "VIDEO STATUS_SEND_START progress " + paramMessageForLightVideo.videoFileProgress);
    if (paramMessageForLightVideo.busiType != 1) {
      a(paramMessageForLightVideo, parama, paramMessageForLightVideo.videoFileProgress, true);
    }
    parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
    return;
    String str = ShortVideoUtils.a(paramMessageForLightVideo, "mp4");
    boolean bool = aqhq.fileExistsAndNotEmpty(str);
    c(paramMessageForLightVideo, "VIDEO STATUS_SEND_FINISHED ,videofile:" + str + " ,videoexist:" + bool);
    if (bool)
    {
      a(parama, paramMessageForLightVideo, localChatVideoView);
      a(paramMessageForLightVideo, parama, 100, true);
    }
    b(paramMessageForLightVideo);
    return;
    c(paramMessageForLightVideo, "VIDEO STATUS_SEND_ERROR");
    b(paramMessageForLightVideo);
    b(paramMessageForLightVideo, parama, 2131718880);
    a(parama);
    parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
    return;
    c(paramMessageForLightVideo, "VIDEO STATUS_SEND_CANCEL");
    b(paramMessageForLightVideo);
    a(parama);
    return;
    paramInt = paramMessageForLightVideo.videoFileProgress;
    c(paramMessageForLightVideo, "VIDEO STATUS_SEND_PROCESS " + paramInt);
    a(paramMessageForLightVideo, parama, paramInt);
    return;
    c(paramMessageForLightVideo, "VIDEO STATUS_RECV_START");
    a(paramMessageForLightVideo, parama, paramMessageForLightVideo.videoFileProgress, true);
    return;
    c(paramMessageForLightVideo, "VIDEO STATUS_RECV_FINISHED");
    a(parama, paramMessageForLightVideo, localChatVideoView);
    a(paramMessageForLightVideo, parama, 100, true);
    b(parama);
    return;
    c(paramMessageForLightVideo, "VIDEO STATUS_FILE_UNSAFE");
    b(paramMessageForLightVideo, parama, 2131718874);
    if (paramMessageForLightVideo.uiOperatorFlag == 2)
    {
      parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      QQToast.a(this.mContext, 2131720245, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
      return;
    }
    QQToast.a(this.mContext, 2131720270, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
    return;
    c(paramMessageForLightVideo, "VIDEO STATUS_RECV_ERROR");
    a(parama);
    a(paramMessageForLightVideo, parama);
    QQToast.a(this.mContext, 2131720272, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
    return;
    c(paramMessageForLightVideo, "VIDEO STATUS_FILE_EXPIRED");
    str = ShortVideoUtils.bw(paramMessageForLightVideo.thumbMD5, "jpg");
    if (aqhq.fileExistsAndNotEmpty(str)) {
      a(localChatVideoView, str, j, i);
    }
    b(paramMessageForLightVideo, parama, 2131718875);
    return;
    c(paramMessageForLightVideo, "VIDEO STATUS_RECV_CANCEL");
    return;
    paramInt = paramMessageForLightVideo.videoFileProgress;
    c(paramMessageForLightVideo, "VIDEO STATUS_RECV_PROCESS " + paramInt);
    a(paramMessageForLightVideo, parama, paramInt, true);
  }
  
  private void b(a parama, MessageForLightVideo paramMessageForLightVideo, ChatVideoView paramChatVideoView) {}
  
  private void b(MessageForLightVideo paramMessageForLightVideo)
  {
    if ((paramMessageForLightVideo != null) && (paramMessageForLightVideo.progressTask != null))
    {
      this.mHandler.removeCallbacks(paramMessageForLightVideo.progressTask);
      paramMessageForLightVideo.progressTask = null;
    }
  }
  
  private boolean b(a parama, MessageForLightVideo paramMessageForLightVideo, ChatVideoView paramChatVideoView)
  {
    if ((TextUtils.isEmpty(paramMessageForLightVideo.md5)) && (paramMessageForLightVideo.videoFileStatus != 1005) && (paramMessageForLightVideo.extraflag != 32768))
    {
      if (paramMessageForLightVideo.isSendFromLocal())
      {
        Object localObject2 = paramMessageForLightVideo.mThumbFilePath;
        Object localObject1 = localObject2;
        if (!aqhq.fileExistsAndNotEmpty((String)localObject2))
        {
          if (TextUtils.isEmpty(paramMessageForLightVideo.thumbMD5))
          {
            paramChatVideoView.setImageDrawable(aoop.getFailedDrawable());
            a(parama);
            c(paramMessageForLightVideo, "getBubbleView():You must get thumb before send video.");
            return true;
          }
          localObject1 = ShortVideoUtils.bw(paramMessageForLightVideo.thumbMD5, "jpg");
        }
        if (paramChatVideoView.hM((String)localObject1))
        {
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = h;
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = h;
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.thumbWidth;
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.thumbHeight;
          paramChatVideoView.setURLDrawable(URLDrawable.getDrawable(new File((String)localObject1), (URLDrawable.URLDrawableOptions)localObject2));
          boolean bool = a(paramMessageForLightVideo, null);
          if (QLog.isColorLevel()) {
            QLog.d("LightVideoItemBuilder", 2, String.format("getBubbleView, judge mr status uniseq:%d, filestatus:%s, isfailed:%s", new Object[] { Long.valueOf(paramMessageForLightVideo.uniseq), Integer.valueOf(paramMessageForLightVideo.videoFileStatus), Boolean.valueOf(bool) }));
          }
          if (!bool) {
            a(paramMessageForLightVideo, parama, paramMessageForLightVideo.videoFileProgress, true);
          }
        }
      }
      return true;
    }
    return false;
  }
  
  private void c(MessageRecord paramMessageRecord, String paramString)
  {
    if (QLog.isColorLevel())
    {
      paramMessageRecord = "LightVideoItemBuilder" + "[" + paramMessageRecord.uniseq + "]";
      QLog.i("LightVideoItemBuilder", 2, paramMessageRecord + ":content " + paramString);
    }
  }
  
  private void zs(boolean paramBoolean) {}
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, wlz paramwlz)
  {
    paramViewGroup = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramwlz);
    a(paramChatMessage, paramView, this);
    return paramViewGroup;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    paramBaseChatItemLayout = (a)parame;
    Object localObject2 = this.mContext;
    Resources localResources = ((Context)localObject2).getResources();
    MessageForLightVideo localMessageForLightVideo = (MessageForLightVideo)paramChatMessage;
    parame = paramView;
    if (paramView == null)
    {
      parame = new RelativeLayout((Context)localObject2);
      paramView = new ChatVideoView((Context)localObject2);
      paramView.setId(2131373231);
      paramView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramView.setRadius(15.0F);
      paramView.TE(false);
      paramView.setSharpCornerCor(BubbleImageView.DEFAULT_EDGE_CORDS);
      paramView.setContentDescription(acfp.m(2131707677));
      parame.addView(paramView);
      MessageProgressView localMessageProgressView = new MessageProgressView((Context)localObject2);
      parame.addView(localMessageProgressView);
      Object localObject3 = new LinearLayout((Context)localObject2);
      ((LinearLayout)localObject3).setOrientation(1);
      ((LinearLayout)localObject3).setGravity(17);
      Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(13);
      parame.addView((View)localObject3, (ViewGroup.LayoutParams)localObject1);
      localObject1 = new TextView((Context)localObject2);
      Object localObject4 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject4).topMargin = wja.dp2px(70.0F, localResources);
      ((TextView)localObject1).setTextColor(-1);
      ((TextView)localObject1).setTextSize(2, 12.0F);
      ((TextView)localObject1).setId(2131364543);
      ((LinearLayout)localObject3).addView((View)localObject1, (ViewGroup.LayoutParams)localObject4);
      localObject2 = new LinearLayout((Context)localObject2);
      ((LinearLayout)localObject2).setOrientation(0);
      ((LinearLayout)localObject2).setGravity(16);
      ((LinearLayout)localObject2).setBackgroundResource(2130838171);
      ((LinearLayout)localObject2).setId(2131362460);
      ((LinearLayout)localObject2).setOnClickListener(new xiu(this));
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(8, 2131373231);
      ((RelativeLayout.LayoutParams)localObject3).bottomMargin = bTl;
      ((RelativeLayout.LayoutParams)localObject3).addRule(5, 2131373231);
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = bTl;
      parame.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject3 = new ImageView(this.mContext);
      ((ImageView)localObject3).setId(2131374797);
      ((ImageView)localObject3).setPadding(bTl, bTm, bTm, bTm);
      ((LinearLayout)localObject2).addView((View)localObject3);
      localObject4 = new TextView(this.mContext);
      ((TextView)localObject4).setId(2131374802);
      ((TextView)localObject4).setTextColor(-1);
      ((TextView)localObject4).setPadding(0, bTm, bTl, bTm);
      ((LinearLayout)localObject2).addView((View)localObject4);
      parame.setOnClickListener(this);
      parame.setOnTouchListener(paramwlz);
      parame.setOnLongClickListener(paramwlz);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView = paramView;
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = localMessageProgressView;
      paramBaseChatItemLayout.Jg = ((TextView)localObject1);
      paramBaseChatItemLayout.mt = ((ImageView)localObject3);
      paramBaseChatItemLayout.Jh = ((TextView)localObject4);
    }
    paramView = paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView;
    if (AppSetting.enableTalkBack)
    {
      paramwlz = new StringBuilder();
      paramwlz.append("轻量短视频 ");
      paramwlz.append(localMessageForLightVideo.videoFileTime);
      paramwlz.append("秒");
      if ((!localMessageForLightVideo.isSend()) && (!localMessageForLightVideo.isLightVideoRead)) {
        paramwlz.append(" 未播放");
      }
      paramView.setContentDescription(paramwlz.toString());
    }
    paramView.mIsSend = localMessageForLightVideo.isSend();
    paramView.setTag(Long.valueOf(localMessageForLightVideo.uniseq));
    aqfv.a().a(Long.valueOf(localMessageForLightVideo.uniseq), localMessageForLightVideo);
    paramBaseChatItemLayout.Jg.setVisibility(8);
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setRadius(15.0F, true);
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setShowCorner(false);
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setSharpCornerCor(BubbleImageView.DEFAULT_EDGE_CORDS);
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setCornerDirection(localMessageForLightVideo.isSend());
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.bind(paramChatMessage.frienduin + paramChatMessage.uniseq);
    this.thumbWidth = wja.dp2px(160.0F, localResources);
    this.thumbHeight = wja.dp2px(160.0F, localResources);
    localMessageForLightVideo.thumbWidth = this.thumbWidth;
    localMessageForLightVideo.thumbHeight = this.thumbHeight;
    localMessageForLightVideo.hasShowInAIO = true;
    paramChatMessage = paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.getLayoutParams();
    if (paramChatMessage == null)
    {
      paramChatMessage = new RelativeLayout.LayoutParams(this.thumbWidth, this.thumbHeight);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.setLayoutParams(paramChatMessage);
      paramChatMessage = paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getLayoutParams();
      if (paramChatMessage != null) {
        break label882;
      }
      paramChatMessage = new RelativeLayout.LayoutParams(this.thumbWidth, this.thumbHeight);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams(paramChatMessage);
    }
    for (;;)
    {
      a(paramBaseChatItemLayout, localMessageForLightVideo, paramView);
      return parame;
      if ((paramChatMessage.width == this.thumbWidth) && (paramChatMessage.height == this.thumbHeight)) {
        break;
      }
      paramChatMessage.width = this.thumbWidth;
      paramChatMessage.height = this.thumbHeight;
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.setLayoutParams(paramChatMessage);
      break;
      label882:
      if ((paramChatMessage.width != this.thumbWidth) || (paramChatMessage.height != this.thumbHeight))
      {
        paramChatMessage.width = this.thumbWidth;
        paramChatMessage.height = this.thumbHeight;
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams(paramChatMessage);
      }
    }
  }
  
  public BaseBubbleBuilder.d a(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      paramView = (a)((View)paramView.getParent()).getTag();
      if (paramView != null) {
        return paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView;
      }
    }
    return null;
  }
  
  public BaseBubbleBuilder.e a()
  {
    return new a();
  }
  
  public a a(long paramLong)
  {
    if ((this.b != null) && (paramLong > 0L))
    {
      int i = wja.a(paramLong, this.b.getAdapter());
      int j = this.b.getHeaderViewsCount();
      int k = this.b.getFirstVisiblePosition();
      int m = this.b.getLastVisiblePosition();
      if (i <= -1) {
        break label223;
      }
      Object localObject = wja.a(this.b, i);
      if (localObject != null)
      {
        localObject = wja.a((View)localObject);
        if ((localObject != null) && ((localObject instanceof a))) {
          return (a)localObject;
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.w("LightVideoItemBuilder", 2, "getHolderByMsg() uniseq=" + paramLong + ", posi =" + i + ", view = null");
      }
      if (QLog.isColorLevel()) {
        QLog.d("LightVideoItemBuilder", 2, "getHolderByMsg() uniseq=" + paramLong + ", posi =" + i + ", firstVisblePosi=" + k + ",lastVisblePosi=" + m + ",headerCount=" + j);
      }
    }
    for (;;)
    {
      return null;
      label223:
      if (QLog.isColorLevel()) {
        QLog.w("LightVideoItemBuilder", 2, "getHolderByMsg() uniseq=" + paramLong + ", posi<= -1");
      }
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    MessageForLightVideo localMessageForLightVideo;
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForLightVideo)))
    {
      localMessageForLightVideo = (MessageForLightVideo)paramChatMessage;
      if (paramInt == 2131365686)
      {
        ujt.b(this.mContext, this.app, localMessageForLightVideo);
        rar.a("story_grp", "press_msg", 0, 0, new String[] { "4", "", "", "" });
      }
    }
    else
    {
      return;
    }
    if (paramInt == 2131372073)
    {
      super.m(paramChatMessage);
      rar.a("story_grp", "press_msg", 0, 0, new String[] { "5", "", "", "" });
      return;
    }
    if (paramInt == 2131366733)
    {
      aviz.a(localMessageForLightVideo).b(this.app, paramChatMessage).b((Activity)this.mContext, this.app.getAccount());
      avjg.a(this.app, 6, 5);
      avjg.a(this.app, 3, 0, paramChatMessage.istroop);
      rar.a("story_grp", "press_msg", 0, 0, new String[] { "2", "", "", "" });
      return;
    }
    if (paramInt == 2131372030)
    {
      if (d(paramChatMessage)) {
        MediaPlayerManager.a(this.app).stop(true);
      }
      super.j(localMessageForLightVideo);
      rar.a("story_grp", "press_msg", 0, 0, new String[] { "3", "", "", "" });
      return;
    }
    if (paramInt == 2131365642)
    {
      paramContext = new StringBuilder();
      paramContext.append("uniseq:").append(localMessageForLightVideo.uniseq).append("\n");
      Toast.makeText(this.mContext, paramContext.toString(), 1).show();
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  public void a(View paramView, aoko paramaoko, int paramInt1, int paramInt2)
  {
    paramView = (a)wja.a(paramView);
    MessageForLightVideo localMessageForLightVideo = (MessageForLightVideo)paramView.mMessage;
    if (localMessageForLightVideo.uniseq != paramaoko.uniseq) {}
    do
    {
      do
      {
        return;
      } while (this.mContext == null);
      if ((paramaoko.fileType == 327689) || (paramaoko.fileType == 6) || (paramaoko.fileType == 17) || (paramaoko.fileType == 9))
      {
        b(paramaoko.status, paramView, localMessageForLightVideo);
        return;
      }
    } while ((paramaoko.fileType != 7) && (paramaoko.fileType != 18) && (paramaoko.fileType != 16));
    a(paramaoko.status, paramView, localMessageForLightVideo);
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
  
  protected void a(a parama)
  {
    if (!parama.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.sd(parama.mMessage.frienduin + parama.mMessage.uniseq)) {
      parama.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(8);
    }
    for (;;)
    {
      parama.Jg.setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.w("LightVideoItemBuilder", 2, "[hideProgress] set ProgressPieDrawable visible");
      }
      return;
      parama.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimRunnableListener(new xiw(this, parama));
    }
  }
  
  protected void a(a parama, MessageForLightVideo paramMessageForLightVideo, int paramInt)
  {
    if (parama == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoItemBuilder", 2, String.format("handleVideoViewAnimStatus uniseq:%d, status:%d", new Object[] { Long.valueOf(paramMessageForLightVideo.uniseq), Integer.valueOf(paramInt) }));
    }
    parama.Jh.setText(xkx.az(paramMessageForLightVideo.videoFileTime));
    parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(false, null, null);
    paramMessageForLightVideo.videoStatus = paramInt;
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      if ((!paramMessageForLightVideo.isSend()) && (!paramMessageForLightVideo.isLightVideoRead)) {
        parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(true, null, null);
      }
      parama.mt.setImageResource(2130841239);
      return;
    case 1: 
      a(paramMessageForLightVideo);
      paramMessageForLightVideo = (AnimationDrawable)this.mContext.getResources().getDrawable(2130772131);
      parama.mt.setImageDrawable(paramMessageForLightVideo);
      paramMessageForLightVideo.start();
      return;
    case 2: 
      parama.mt.setImageResource(2130841236);
      return;
    }
    if ((!paramMessageForLightVideo.isSend()) && (!paramMessageForLightVideo.isLightVideoRead)) {
      parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(true, null, null);
    }
    parama.mt.setImageResource(2130841236);
  }
  
  public void a(MessageForLightVideo paramMessageForLightVideo)
  {
    if (!paramMessageForLightVideo.isLightVideoRead)
    {
      paramMessageForLightVideo.isLightVideoRead = true;
      paramMessageForLightVideo.saveExtInfoToExtStr(anbb.cdd, "1");
      ThreadManager.post(new LightVideoItemBuilder.2(this, paramMessageForLightVideo), 10, null, false);
    }
  }
  
  void a(MessageForLightVideo paramMessageForLightVideo, a parama)
  {
    parama.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.Wt(paramMessageForLightVideo.frienduin + paramMessageForLightVideo.uniseq);
    parama.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(2);
    parama.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    parama.Jg.setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.w("LightVideoItemBuilder", 2, "[showPauseProgress] uinseq:" + paramMessageForLightVideo.uniseq);
    }
  }
  
  void a(MessageForLightVideo paramMessageForLightVideo, a parama, int paramInt)
  {
    int i = ShortVideoUtils.aL(paramInt, 10);
    if (paramMessageForLightVideo.busiType == 1)
    {
      if (i < 60) {
        return;
      }
      if (paramMessageForLightVideo.progressTask != null)
      {
        this.mHandler.removeCallbacks(paramMessageForLightVideo.progressTask);
        paramMessageForLightVideo.progressTask = null;
        c(paramMessageForLightVideo, "VIDEO STATUS_SEND_PROCESS CLOSE_TASK PROCESS:" + i);
      }
    }
    a(paramMessageForLightVideo, parama, paramInt, true);
  }
  
  protected void a(MessageForLightVideo paramMessageForLightVideo, a parama, int paramInt, boolean paramBoolean)
  {
    parama.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
    parama.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(paramInt, paramMessageForLightVideo.frienduin + paramMessageForLightVideo.uniseq);
    parama.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    parama.Jg.setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.w("LightVideoItemBuilder", 2, "[setProgress] uinseq:" + paramMessageForLightVideo.uniseq + ", p:" + paramInt);
    }
  }
  
  void a(MessageForLightVideo paramMessageForLightVideo, boolean paramBoolean)
  {
    if (paramMessageForLightVideo.videoFileStatus == 5002)
    {
      c(paramMessageForLightVideo, acfp.m(2131707698));
      return;
    }
    angi localangi = anfr.a(2, 2);
    anfu localanfu = paramMessageForLightVideo.getDownloadInfo(localangi.dFl);
    localanfu.localPath = ShortVideoUtils.a(paramMessageForLightVideo, "mp4");
    localanfu.jv(paramMessageForLightVideo.istroop, 0);
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      localanfu.mRequestType = i;
      localanfu.mSceneType = 2;
      if (QLog.isColorLevel()) {
        QLog.d("LightVideoItemBuilder", 2, " startDownloadVideo downloadvideo fileType==" + localanfu.fileType + ", uniseq:" + paramMessageForLightVideo.uniseq);
      }
      localangi.c(localanfu);
      localangi.p(paramMessageForLightVideo);
      anfr.a(localangi, this.app);
      return;
    }
  }
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, long paramLong, float paramFloat) {}
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, boolean paramBoolean) {}
  
  protected boolean a(a parama, MessageForLightVideo paramMessageForLightVideo, ChatVideoView paramChatVideoView)
  {
    boolean bool2 = false;
    if (b(parama, paramMessageForLightVideo, paramChatVideoView))
    {
      bool2 = false;
      return bool2;
    }
    String str1 = ShortVideoUtils.bw(paramMessageForLightVideo.thumbMD5, "jpg");
    String str2 = ShortVideoUtils.a(paramMessageForLightVideo, "mp4");
    boolean bool4 = aqhq.fileExistsAndNotEmpty(str1);
    boolean bool1 = aqhq.fileExistsAndNotEmpty(str2);
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoItemBuilder", 2, String.format("handleVideoFileStatus uniseq:%d, thumb:%s, videofile:%s", new Object[] { Long.valueOf(paramMessageForLightVideo.uniseq), Boolean.valueOf(bool4), Boolean.valueOf(bool1) }));
    }
    if (bool1)
    {
      parama.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(8);
      if ((!paramMessageForLightVideo.isSendFromLocal()) || (paramMessageForLightVideo.isStatusReady())) {
        if ((this.a != null) && (this.a.videoStatus == 1))
        {
          bool2 = true;
          label150:
          a(parama, true, true, 0, false, bool2);
          boolean bool3 = true;
          bool1 = bool3;
          if (QLog.isColorLevel())
          {
            QLog.d("LightVideoItemBuilder", 2, "LightVideo mutePlaying, uniseq:" + paramMessageForLightVideo.uniseq + " ,shouldPause:" + bool2);
            bool1 = bool3;
          }
        }
      }
      for (;;)
      {
        bool2 = bool1;
        if (bool4) {
          break;
        }
        c(paramMessageForLightVideo);
        c(paramMessageForLightVideo, "getBubbleView: Video file exist and status finish. Thumb not exist.");
        return bool1;
        bool2 = false;
        break label150;
        bool1 = bool2;
        if (bool4)
        {
          a(paramChatVideoView, str1, this.thumbHeight, this.thumbWidth);
          bool1 = bool2;
        }
      }
    }
    if (bool4)
    {
      a(paramChatVideoView, str1, this.thumbHeight, this.thumbWidth);
      if (paramMessageForLightVideo.videoFileStatus == 2005) {
        a(paramMessageForLightVideo, parama);
      }
      if (paramMessageForLightVideo.videoFileStatus == 5002)
      {
        c(paramMessageForLightVideo, acfp.m(2131707704));
        b(paramMessageForLightVideo, parama, 2131718875);
        return false;
      }
      if (this.app.a().a(paramMessageForLightVideo, true))
      {
        a(paramMessageForLightVideo, true);
        return false;
      }
      if ((paramMessageForLightVideo.videoFileStatus == 2001) || (paramMessageForLightVideo.videoFileStatus == 2002) || (paramMessageForLightVideo.videoFileStatus == 2000))
      {
        a(paramMessageForLightVideo, parama, paramMessageForLightVideo.videoFileProgress, false);
        return false;
      }
      a(paramMessageForLightVideo, parama);
      return true;
    }
    if (paramMessageForLightVideo.videoFileStatus == 5002)
    {
      c(paramMessageForLightVideo, acfp.m(2131707678));
      paramChatVideoView.setImageDrawable(h);
      b(paramMessageForLightVideo, parama, 2131718875);
      return false;
    }
    c(paramMessageForLightVideo, acfp.m(2131707684));
    paramChatVideoView.setImageDrawable(h);
    c(paramMessageForLightVideo);
    return false;
  }
  
  public boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (!paramChatMessage.isSendFromLocal()) {}
    do
    {
      do
      {
        return false;
        paramChatMessage = (MessageForLightVideo)paramChatMessage;
      } while (paramChatMessage.videoFileStatus == 5002);
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
    } while ((paramChatMessage.videoFileProgress == 100) || (paramChatMessage.videoFileStatus == 1003) || (paramChatMessage.videoFileStatus == 2003));
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoItemBuilder", 2, String.format("isFailed is true, uniseq:%d, fileStatus:%d, fileProgress:%d", new Object[] { Long.valueOf(paramChatMessage.uniseq), Integer.valueOf(paramChatMessage.videoFileStatus), Integer.valueOf(paramChatMessage.videoFileProgress) }));
    }
    return true;
  }
  
  public boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    paramXListView = (MessageForLightVideo)paramChatMessage;
    boolean bool;
    if ((!paramXListView.isSend()) && (!paramXListView.isLightVideoRead) && (paramXListView.isAllReady())) {
      bool = true;
    }
    while (paramXListView.istroop != 0) {
      if ((bool) && (paramXListView.hasShowInAIO))
      {
        return true;
        bool = false;
      }
      else
      {
        return false;
      }
    }
    return bool;
  }
  
  public boolean a(XListView paramXListView, int paramInt1, View paramView, ChatMessage paramChatMessage, AudioPlayerBase paramAudioPlayerBase, int paramInt2)
  {
    paramXListView = (a)wja.a(paramView);
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoItemBuilder", 2, "play! uniseq:" + paramChatMessage.uniseq + " ,viewpositon:" + paramInt1);
    }
    this.c = paramAudioPlayerBase;
    if (paramXListView == null)
    {
      this.IS = paramChatMessage.uniseq;
      this.bTk = paramInt1;
      this.b.smoothScrollToPosition(this.b.getHeaderViewsCount() + paramInt1);
      this.a = ((MessageForLightVideo)paramChatMessage);
      return true;
    }
    this.IS = 0L;
    this.bTk = 0;
    if ((paramXListView != null) && ((paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.getDrawable() instanceof URLDrawable)))
    {
      this.a = ((MessageForLightVideo)paramChatMessage);
      a(paramXListView, (MessageForLightVideo)paramChatMessage, 1);
      zs(true);
      a(paramAudioPlayerBase, paramXListView, 0);
      return true;
    }
    return false;
  }
  
  public aqob[] a(View paramView)
  {
    aqoa localaqoa = new aqoa();
    paramView = (a)wja.a(paramView);
    MessageForLightVideo localMessageForLightVideo = (MessageForLightVideo)paramView.mMessage;
    if ((!TextUtils.isEmpty(localMessageForLightVideo.md5)) && (aqhq.fileExistsAndNotEmpty(ShortVideoUtils.bw(localMessageForLightVideo.thumbMD5, "jpg")))) {
      if ((paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.sc == null) || (paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.sc.getVisibility() != 0)) {
        break label126;
      }
    }
    label126:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        a(localaqoa, this.sessionInfo.cZ, localMessageForLightVideo);
      }
      a(localaqoa, localMessageForLightVideo);
      super.c(localaqoa, this.mContext);
      super.e(localaqoa, this.mContext);
      return localaqoa.a();
    }
  }
  
  public String b(ChatMessage paramChatMessage)
  {
    return acfp.m(2131707700);
  }
  
  protected void b(a parama)
  {
    if (!parama.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.sd(parama.mMessage.frienduin + parama.mMessage.uniseq))
    {
      parama.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(8);
      return;
    }
    parama.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimRunnableListener(new xix(this, parama));
  }
  
  void b(MessageForLightVideo paramMessageForLightVideo, a parama, int paramInt)
  {
    parama.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.Wt(paramMessageForLightVideo.frienduin + paramMessageForLightVideo.uniseq);
    parama.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    parama.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setImageResource(2130850764);
    parama.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(3);
    parama.Jg.setVisibility(0);
    parama.Jg.setText(paramInt);
    if (QLog.isColorLevel()) {
      QLog.w("LightVideoItemBuilder", 2, "[showWarnProgress] uinseq:" + paramMessageForLightVideo.uniseq);
    }
  }
  
  public void bYO()
  {
    super.bYO();
  }
  
  void c(MessageForLightVideo paramMessageForLightVideo)
  {
    angi localangi = anfr.a(2, 2);
    anfu localanfu = paramMessageForLightVideo.getDownloadInfo(localangi.dFl);
    localanfu.thumbPath = ShortVideoUtils.bw(paramMessageForLightVideo.thumbMD5, "jpg");
    localanfu.jv(paramMessageForLightVideo.istroop, 1);
    localanfu.mRequestType = 2;
    localanfu.mSceneType = 2;
    localangi.c(localanfu);
    localangi.p(paramMessageForLightVideo);
    anfr.a(localangi, this.app);
  }
  
  protected boolean d(ChatMessage paramChatMessage)
  {
    ChatMessage localChatMessage = MediaPlayerManager.a(this.app).a();
    return ((localChatMessage == paramChatMessage) || (((localChatMessage instanceof MessageForLightVideo)) && (localChatMessage.uniseq == paramChatMessage.uniseq))) && (((MessageForLightVideo)paramChatMessage).videoStatus == 1);
  }
  
  public void destroy() {}
  
  public boolean e(ChatMessage paramChatMessage)
  {
    return true;
  }
  
  public void ei(View paramView)
  {
    super.ei(paramView);
    paramView = (a)wja.a(paramView);
    MessageForLightVideo localMessageForLightVideo = (MessageForLightVideo)paramView.mMessage;
    if (!localMessageForLightVideo.isSendFromLocal()) {
      return;
    }
    ausj localausj = (ausj)auss.a(this.mContext, null);
    localausj.addButton(2131690230, 5);
    localausj.addCancelButton(2131721058);
    localausj.a(new xiv(this, localMessageForLightVideo, paramView, localausj));
    localausj.show();
  }
  
  public void onClick(View paramView)
  {
    a locala = (a)wja.a(paramView);
    if (locala == null) {}
    MessageForLightVideo localMessageForLightVideo;
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localMessageForLightVideo = (MessageForLightVideo)locala.mMessage;
        if (QLog.isColorLevel()) {
          QLog.d("LightVideoItemBuilder", 2, "onClick! uniseq:" + localMessageForLightVideo.uniseq);
        }
        if (paramView.getId() != 2131364545)
        {
          if (!this.app.bF()) {
            break;
          }
          QQToast.a(this.mContext, 2131698108, 1).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
        }
      }
      if ((paramView.getId() != 2131364503) && (paramView.getId() != 2131362460)) {
        break;
      }
    } while (localMessageForLightVideo.md5 == null);
    if (d(localMessageForLightVideo))
    {
      a(locala, localMessageForLightVideo, 2);
      MediaPlayerManager.a(this.app).stop(false);
    }
    for (;;)
    {
      super.onClick(paramView);
      break;
      String str = ShortVideoUtils.bw(localMessageForLightVideo.thumbMD5, "jpg");
      if (!aqhq.fileExistsAndNotEmpty(ShortVideoUtils.a(localMessageForLightVideo, "mp4")))
      {
        a(localMessageForLightVideo, false);
        a(localMessageForLightVideo, locala, localMessageForLightVideo.videoFileProgress, false);
        this.IS = localMessageForLightVideo.uniseq;
        this.bTk = 0;
      }
      else if (aqhq.fileExistsAndNotEmpty(str))
      {
        anot.a(this.app, "CliOper", "", "", "0X800561C", "0X800561C", 0, 0, "", "", "", "");
        if (!MediaPlayerManager.a(this.app).k(wja.a(paramView))) {
          QQToast.a(this.mContext, 1, 2131697384, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
        }
      }
    }
  }
  
  protected boolean p(ChatMessage paramChatMessage)
  {
    return (paramChatMessage != null) && (((MessageForLightVideo)paramChatMessage).videoStatus == 2);
  }
  
  public void q(ListView paramListView)
  {
    this.b = paramListView;
  }
  
  protected boolean q(ChatMessage paramChatMessage)
  {
    return (paramChatMessage.uniseq == this.IS) && (((MessageForLightVideo)paramChatMessage).isAllReady());
  }
  
  public void zr(boolean paramBoolean)
  {
    ChatMessage localChatMessage = MediaPlayerManager.a(this.app).a();
    if ((localChatMessage != null) && ((localChatMessage instanceof MessageForLightVideo)) && (a(localChatMessage.uniseq) == null) && (QLog.isColorLevel())) {
      QLog.w("LightVideoItemBuilder", 2, "onNearToEar holder == null, uniseq = " + localChatMessage.uniseq);
    }
  }
  
  public static class ChatVideoView
    extends BubbleVideoView
  {
    public URLDrawable n;
    URLDrawable v;
    
    public ChatVideoView(Context paramContext)
    {
      super();
    }
    
    public boolean hM(String paramString)
    {
      return (this.n == null) || (!this.n.getURL().getPath().equals(paramString));
    }
    
    public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
    {
      if (paramURLDrawable == this.v)
      {
        setURLDrawable(paramURLDrawable);
        return;
      }
      super.onLoadFialed(paramURLDrawable, paramThrowable);
    }
    
    @TargetApi(11)
    public void onLoadSuccessed(URLDrawable paramURLDrawable)
    {
      if (paramURLDrawable == this.v) {
        setURLDrawable(paramURLDrawable);
      }
      super.onLoadSuccessed(paramURLDrawable);
    }
    
    public void setImageDrawable(Drawable paramDrawable)
    {
      super.setImageDrawable(paramDrawable);
      if (this.v != null)
      {
        this.v.setURLDrawableListener(null);
        this.v = null;
      }
    }
    
    public void setURLDrawable(URLDrawable paramURLDrawable)
    {
      setImageDrawable(paramURLDrawable);
      if (this.n != paramURLDrawable) {
        this.n = paramURLDrawable;
      }
    }
    
    public void setVideoDrawable(URLDrawable paramURLDrawable)
    {
      if (this.v != null) {
        this.v.setURLDrawableListener(null);
      }
      paramURLDrawable.setURLDrawableListener(this);
      this.v = paramURLDrawable;
      paramURLDrawable.startDownload();
    }
  }
  
  public class a
    extends BaseBubbleBuilder.e
  {
    public TextView Jg;
    public TextView Jh;
    public LightVideoItemBuilder.ChatVideoView a;
    public MessageProgressView a;
    public ImageView mt;
    
    public a() {}
    
    public void cdi() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.LightVideoItemBuilder
 * JD-Core Version:    0.7.0.1
 */