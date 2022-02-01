package com.tencent.mobileqq.activity.aio.item;

import acfp;
import afei;
import ahgq;
import akxo;
import alyr;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import anfr;
import anft;
import anfu;
import angb;
import angi;
import angt;
import anot;
import aojn;
import aoko;
import aonn;
import aonu;
import aooi;
import aoop;
import aqhq;
import aqip;
import aqiu;
import aqoa;
import aqob;
import ausj;
import auss;
import aviz;
import avjg;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.Utils;
import com.tencent.image.VideoDrawable;
import com.tencent.image.VideoDrawable.VideoDrawableParams;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.d;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.mediadevice.EncodeThread;
import com.tencent.mobileqq.widget.AudioAnimationView;
import com.tencent.mobileqq.widget.CircleBubbleImageView;
import com.tencent.mobileqq.widget.CircleProgressView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URL;
import tnt;
import ujt;
import wja;
import wla;
import wla.a;
import wlz;
import xnc;
import xnd;

public class ShortVideoPTVItemBuilder
  extends BaseBubbleBuilder
  implements anft, wla.a
{
  static int bTn;
  static int bTo;
  public static WeakReference<VideoDrawable> em;
  private static WeakReference<MessageForShortVideo> en;
  static ColorDrawable h = new afei(-10065297, bTn, bTo);
  private ListView b;
  Handler mUiHandler = new Handler(Looper.getMainLooper());
  
  static
  {
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    bTn = wja.dp2px(160.0F, localResources);
    bTo = wja.dp2px(160.0F, localResources);
  }
  
  public ShortVideoPTVItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    if (paramAIOAnimationConatiner != null) {
      this.b = paramAIOAnimationConatiner.b();
    }
    ShortVideoUtils.B(paramQQAppInterface);
    d.initConfig();
  }
  
  private View a(View paramView, c paramc, ChatVideoView paramChatVideoView, MessageForShortVideo paramMessageForShortVideo)
  {
    if (paramMessageForShortVideo.isSendFromLocal())
    {
      String str = paramMessageForShortVideo.mThumbFilePath;
      if (!aqhq.fileExistsAndNotEmpty(str)) {
        break label146;
      }
      if (paramChatVideoView.hM(str))
      {
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: 占坑 msgSeq: " + paramc.mMessage.uniseq);
        }
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = h;
        localURLDrawableOptions.mFailedDrawable = h;
        paramChatVideoView.setURLDrawable(URLDrawable.getDrawable(new File(str), localURLDrawableOptions));
        a(paramc);
        Utils.executeAsyncTaskOnSerialExcuter(new b(this.app, this.mContext, paramMessageForShortVideo), new Void[] { (Void)null });
      }
    }
    label146:
    do
    {
      return paramView;
      paramChatVideoView.setImageDrawable(aoop.getFailedDrawable());
      b(paramc);
    } while (!QLog.isColorLevel());
    QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView():You must get thumb before send video. msgSeq: " + paramc.mMessage.uniseq);
    return paramView;
  }
  
  private View a(View paramView, c paramc, ChatVideoView paramChatVideoView, MessageForShortVideo paramMessageForShortVideo, String paramString1, String paramString2)
  {
    if (paramChatVideoView.hM(paramString1))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: 刷缩略图 " + paramString1 + " msgSeq: " + paramc.mMessage.uniseq);
      }
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = h;
      localURLDrawableOptions.mFailedDrawable = h;
      paramChatVideoView.setURLDrawable(URLDrawable.getDrawable(new File(paramString1), localURLDrawableOptions));
    }
    for (;;)
    {
      paramc.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.stopAnimation();
      if (!aqhq.fileExistsAndNotEmpty(paramString2)) {
        break label253;
      }
      if ((!paramMessageForShortVideo.isSendFromLocal()) || (paramMessageForShortVideo.videoFileProgress > 100) || (paramMessageForShortVideo.videoFileStatus == 1003)) {
        break;
      }
      a(paramc, paramMessageForShortVideo.videoFileProgress);
      return paramView;
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: 刷缩略图用缓存 " + paramString1 + " msgSeq: " + paramc.mMessage.uniseq);
      }
      paramString1 = paramChatVideoView.n;
      if ((paramString1 != null) && (paramString1.getStatus() == 1)) {
        paramChatVideoView.setURLDrawable(paramString1);
      }
    }
    if ((ShortVideoUtils.awI()) && (d.bhO))
    {
      b(paramc);
      return paramView;
    }
    c(paramc);
    return paramView;
    label253:
    if (paramMessageForShortVideo.videoFileStatus == 5002)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPTVItemBuilder", 2, "getBubbleView():短视频已过期不启动下载流程 1 msgSeq: " + paramc.mMessage.uniseq);
      }
      b(paramc, 2131718875);
      return paramView;
    }
    if (this.app.a().a(paramMessageForShortVideo, true))
    {
      b(paramMessageForShortVideo, true);
      a(paramc, paramMessageForShortVideo.videoFileProgress);
      return paramView;
    }
    if (aojn.class.isInstance(this.app.a().a(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq)))
    {
      a(paramc, paramMessageForShortVideo.videoFileProgress);
      return paramView;
    }
    c(paramc);
    return paramView;
  }
  
  private void a(c paramc, MessageForShortVideo paramMessageForShortVideo, URLDrawable paramURLDrawable)
  {
    paramURLDrawable = (VideoDrawable)paramURLDrawable.getCurrDrawable();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, " videoDrawable.isAudioPlaying(): " + paramURLDrawable.isAudioPlaying());
    }
    if (paramURLDrawable.isAudioPlaying())
    {
      paramURLDrawable.stopAudio();
      paramc.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.stopAnimation();
      en = null;
      return;
    }
    if (MediaPlayerManager.a(this.app).isPlaying()) {
      MediaPlayerManager.a(this.app).stop(true);
    }
    if ((em != null) && (em.get() != null) && (em.get() != paramURLDrawable) && (((VideoDrawable)em.get()).isAudioPlaying()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPTVItemBuilder", 2, "onCLick sPlayingAudioDrawable.get() not null && isAudioPlaying, need stop audio.");
      }
      ((VideoDrawable)em.get()).stopAudio();
      if ((en != null) && (en.get() != null))
      {
        a(this.b, (ChatMessage)en.get());
        en = null;
      }
    }
    paramURLDrawable.resetAndPlayAudioOnce();
    em = new WeakReference(paramURLDrawable);
    paramc.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.startAnimation();
    en = new WeakReference(paramMessageForShortVideo);
    paramURLDrawable.setOnAudioPlayOnceListener(new xnd(this));
  }
  
  private void a(c paramc, MessageForShortVideo paramMessageForShortVideo, String paramString, ChatVideoView paramChatVideoView, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ShortVideoPTVItemBuilder", 2, paramString + "VIDEO STATUS_RECV_FINISHED");
    }
    if (d.bhO)
    {
      String str = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
      if (paramChatVideoView.hM(str))
      {
        QLog.i("ShortVideoPTVItemBuilder", 2, paramString + "handleMessage: 刷视频 " + str);
        if ((ShortVideoUtils.awI()) && (aqhq.fileExistsAndNotEmpty(str)))
        {
          paramString = URLDrawable.URLDrawableOptions.obtain();
          paramString.mRequestWidth = paramInt1;
          paramString.mRequestHeight = paramInt2;
          paramString.mLoadingDrawable = h;
          paramString.mFailedDrawable = h;
          VideoDrawable.VideoDrawableParams localVideoDrawableParams = new VideoDrawable.VideoDrawableParams();
          localVideoDrawableParams.mPlayVideoFrame = true;
          localVideoDrawableParams.mVideoRoundCorner = 0;
          localVideoDrawableParams.mRequestedFPS = d.bVw;
          paramString.mExtraInfo = localVideoDrawableParams;
          paramString = URLDrawable.getDrawable(new File(str), paramString);
          if (paramString.getStatus() != 1) {
            break label337;
          }
          paramChatVideoView.setURLDrawable(paramString);
        }
      }
      for (;;)
      {
        if (!paramMessageForShortVideo.isSend()) {
          new alyr(BaseApplication.getContext()).a(this.app, 2003, this.sessionInfo.cZ, this.sessionInfo.aTl, 1002);
        }
        if (paramMessageForShortVideo.subBusiType == 1) {
          anot.a(this.app, "CliOper", "", "", "0X8006199", "0X8006199", 0, 0, "", "", "" + paramMessageForShortVideo.uuid, "" + paramMessageForShortVideo.isSend());
        }
        b(paramc);
        paramc.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.setVisibility(0);
        return;
        label337:
        paramChatVideoView.setVideoDrawable(paramString);
      }
    }
    paramMessageForShortVideo = ShortVideoUtils.bw(paramMessageForShortVideo.thumbMD5, "jpg");
    if (aqhq.fileExistsAndNotEmpty(paramMessageForShortVideo))
    {
      if (!paramChatVideoView.hM(paramMessageForShortVideo)) {
        break label426;
      }
      paramString = URLDrawable.URLDrawableOptions.obtain();
      paramString.mRequestWidth = paramInt1;
      paramString.mRequestHeight = paramInt2;
      paramString.mLoadingDrawable = h;
      paramString.mFailedDrawable = h;
      paramChatVideoView.setURLDrawable(URLDrawable.getDrawable(new File(paramMessageForShortVideo), paramString));
    }
    for (;;)
    {
      c(paramc);
      return;
      label426:
      paramMessageForShortVideo = paramChatVideoView.n;
      if ((paramMessageForShortVideo != null) && (paramMessageForShortVideo.getStatus() == 1)) {
        paramChatVideoView.setURLDrawable(paramMessageForShortVideo);
      }
    }
  }
  
  public static void a(ListView paramListView, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && (paramListView != null))
    {
      i = wja.a(paramChatMessage.uniseq, paramListView.getAdapter());
      if (i > -1)
      {
        paramListView = wja.a(paramListView, i);
        if (paramListView != null)
        {
          paramListView = wja.a(paramListView);
          if ((paramListView != null) && ((paramListView instanceof c)))
          {
            paramListView = (c)paramListView;
            if (paramListView != null) {
              paramListView.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.stopAnimation();
            }
          }
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      int i;
      return;
    }
    QLog.e("ShortVideoPTVItemBuilder", 2, "stopAudioAnimByMsg(), message = " + paramChatMessage);
  }
  
  private View b(View paramView, c paramc, ChatVideoView paramChatVideoView, MessageForShortVideo paramMessageForShortVideo, String paramString1, String paramString2)
  {
    if (!paramMessageForShortVideo.isSend()) {
      new alyr(BaseApplication.getContext()).a(this.app, 2003, this.sessionInfo.cZ, this.sessionInfo.aTl, 1002);
    }
    Object localObject;
    if (paramChatVideoView.hM(paramString2))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: 刷视频 " + paramString2 + " msgSeq: " + paramc.mMessage.uniseq);
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = h;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = h;
      if (!paramChatVideoView.hM(paramString1)) {
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = paramChatVideoView.n;
      }
      VideoDrawable.VideoDrawableParams localVideoDrawableParams = new VideoDrawable.VideoDrawableParams();
      localVideoDrawableParams.mPlayVideoFrame = true;
      localVideoDrawableParams.mPlayAudioFrame = false;
      localVideoDrawableParams.mVideoRoundCorner = 0;
      localVideoDrawableParams.mRequestedFPS = d.bVw;
      ((URLDrawable.URLDrawableOptions)localObject).mExtraInfo = localVideoDrawableParams;
      localObject = URLDrawable.getDrawable(new File(paramString2), (URLDrawable.URLDrawableOptions)localObject);
      paramChatVideoView.setURLDrawable((URLDrawable)localObject);
      if ((((URLDrawable)localObject).getCurrDrawable() instanceof VideoDrawable))
      {
        boolean bool = ((VideoDrawable)((URLDrawable)localObject).getCurrDrawable()).isAudioPlaying();
        if (!bool) {
          break label417;
        }
        paramc.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.startAnimation();
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: 刷视频, isAudioPlaying= " + bool + ", videoPath:" + paramString2 + " msgSeq: " + paramc.mMessage.uniseq);
        }
      }
    }
    for (;;)
    {
      if (!aqhq.fileExistsAndNotEmpty(paramString1))
      {
        f(paramMessageForShortVideo);
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: Video file exist and status finish. Thumb not exist. msgSeq: " + paramc.mMessage.uniseq);
        }
      }
      if (!paramMessageForShortVideo.isSendFromLocal()) {
        break label568;
      }
      paramChatVideoView = this.app.a().a(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
      if (!aojn.class.isInstance(paramChatVideoView)) {
        break label561;
      }
      if (((aojn)paramChatVideoView).hh() == 1002L) {
        a(paramc, paramMessageForShortVideo.videoFileProgress);
      }
      return paramView;
      label417:
      paramc.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.stopAnimation();
      break;
      localObject = paramChatVideoView.n;
      if ((localObject != null) && (((URLDrawable)localObject).getStatus() == 1))
      {
        paramChatVideoView.setURLDrawable((URLDrawable)localObject);
        if ((((URLDrawable)localObject).getCurrDrawable() instanceof VideoDrawable))
        {
          paramChatVideoView = (VideoDrawable)((URLDrawable)localObject).getCurrDrawable();
          if (QLog.isColorLevel()) {
            QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: 刷视频用缓存, isAudioPlaying= " + paramChatVideoView.isAudioPlaying() + ", videoPath:" + paramString2 + " msgSeq: " + paramc.mMessage.uniseq);
          }
          if (paramChatVideoView.isAudioPlaying()) {
            paramc.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.startAnimation();
          } else {
            paramc.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.stopAnimation();
          }
        }
      }
    }
    label561:
    b(paramc);
    return paramView;
    label568:
    b(paramc);
    return paramView;
  }
  
  public static void r(ListView paramListView)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (em != null)
    {
      bool1 = bool2;
      if (em.get() != null)
      {
        bool1 = bool2;
        if (((VideoDrawable)em.get()).isAudioPlaying())
        {
          ((VideoDrawable)em.get()).stopAudio();
          bool2 = true;
          bool1 = bool2;
          if (en != null)
          {
            bool1 = bool2;
            if (en.get() != null)
            {
              a(paramListView, (ChatMessage)en.get());
              bool1 = bool2;
            }
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "stopAudioIfPlaying(), stopSuccess = " + bool1);
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, wlz paramwlz)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramwlz);
    paramwlz = wla.a(this.app);
    if (paramwlz != null) {
      paramwlz.a(paramView, this);
    }
    if ((this.b == null) && (paramViewGroup != null) && ((paramViewGroup instanceof ListView))) {
      this.b = ((ListView)paramViewGroup);
    }
    try
    {
      paramViewGroup = (c)paramView.getTag();
      float f = ((MessageForShortVideo)paramChatMessage).videoFileSize / 1000;
      paramViewGroup.E.append(f);
      paramViewGroup.E.append("K");
      paramViewGroup.E.append(String.valueOf(((MessageForShortVideo)paramChatMessage).videoFileTime));
      paramViewGroup.E.append("秒");
      paramView.setContentDescription(paramViewGroup.E.toString());
      return paramView;
    }
    catch (Exception paramChatMessage) {}
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    paramBaseChatItemLayout = (c)parame;
    Object localObject1 = this.mContext;
    Object localObject3 = ((Context)localObject1).getResources();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "getBubbleView(), message = " + paramChatMessage);
    }
    if (paramView == null)
    {
      parame = new RelativeLayout((Context)localObject1);
      int i = wja.dp2px(160.0F, (Resources)localObject3);
      int j = wja.dp2px(160.0F, (Resources)localObject3);
      paramView = new ChatVideoView((Context)localObject1);
      paramView.setId(2131373231);
      paramView.setScaleType(ImageView.ScaleType.FIT_XY);
      Object localObject2 = new RelativeLayout.LayoutParams(i, j);
      ((RelativeLayout.LayoutParams)localObject2).addRule(13);
      parame.addView(paramView, (ViewGroup.LayoutParams)localObject2);
      localObject2 = new CircleProgressView((Context)localObject1);
      ((CircleProgressView)localObject2).setVisibility(8);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, j);
      localLayoutParams.addRule(13);
      parame.addView((View)localObject2, localLayoutParams);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(14);
      localLayoutParams.addRule(8, 2131373231);
      localLayoutParams.bottomMargin = wja.dp2px(6.0F, (Resources)localObject3);
      localObject3 = new AudioAnimationView((Context)localObject1);
      ((AudioAnimationView)localObject3).setRectCount(7);
      ((AudioAnimationView)localObject3).setSyle(1);
      ((AudioAnimationView)localObject3).setIcon(this.mContext.getResources().getDrawable(2130838314));
      parame.addView((View)localObject3, localLayoutParams);
      localObject1 = new ImageView((Context)localObject1);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13);
      ((ImageView)localObject1).setVisibility(8);
      parame.addView((View)localObject1, localLayoutParams);
      parame.setOnClickListener(this);
      parame.setOnTouchListener(paramwlz);
      parame.setOnLongClickListener(paramwlz);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoPTVItemBuilder$ChatVideoView = paramView;
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView = ((CircleProgressView)localObject2);
      paramBaseChatItemLayout.mIcon = ((ImageView)localObject1);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView = ((AudioAnimationView)localObject3);
    }
    for (;;)
    {
      paramView = paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoPTVItemBuilder$ChatVideoView;
      paramwlz = (MessageForShortVideo)paramChatMessage;
      paramView.mIsSend = paramwlz.isSend();
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.setIsSend(paramwlz.isSend());
      if (aTl)
      {
        localObject1 = new StringBuilder();
        if (!paramChatMessage.isSend()) {
          break label530;
        }
        ((StringBuilder)localObject1).append("你发出视频对讲消息,");
      }
      for (;;)
      {
        float f = ((MessageForShortVideo)paramChatMessage).videoFileSize / 1000;
        ((StringBuilder)localObject1).append("文件大小:");
        ((StringBuilder)localObject1).append(f);
        ((StringBuilder)localObject1).append("K ");
        ((StringBuilder)localObject1).append("视频时长:");
        ((StringBuilder)localObject1).append(String.valueOf(((MessageForShortVideo)paramChatMessage).videoFileTime));
        ((StringBuilder)localObject1).append("秒");
        parame.setContentDescription(((StringBuilder)localObject1).toString());
        if (paramwlz.md5 != null) {
          break;
        }
        return a(parame, paramBaseChatItemLayout, paramView, paramwlz);
        label530:
        ((StringBuilder)localObject1).append(this.sessionInfo.aTn).append("发出视频对讲消息,");
      }
      paramChatMessage = ShortVideoUtils.bw(paramwlz.thumbMD5, "jpg");
      localObject1 = ShortVideoUtils.a(paramwlz, "mp4");
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView() videoPath" + (String)localObject1 + "thumbPath=" + paramChatMessage);
      }
      if ((d.bhO) && (ShortVideoUtils.awI()) && (aqhq.fileExistsAndNotEmpty((String)localObject1)) && ((!paramwlz.isSendFromLocal()) || (paramwlz.videoFileStatus == 1003) || (paramwlz.videoFileStatus == 2003))) {
        return b(parame, paramBaseChatItemLayout, paramView, paramwlz, paramChatMessage, (String)localObject1);
      }
      if (aqhq.fileExistsAndNotEmpty(paramChatMessage)) {
        return a(parame, paramBaseChatItemLayout, paramView, paramwlz, paramChatMessage, (String)localObject1);
      }
      if (paramwlz.videoFileStatus == 5002)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPTVItemBuilder", 2, "getBubbleView():短视频已过期不启动下载流程 2 msgSeq: " + paramBaseChatItemLayout.mMessage.uniseq);
        }
        paramView.setImageDrawable(h);
        b(paramBaseChatItemLayout, 2131718875);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.stopAnimation();
        return parame;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: 下占位图 msgSeq: " + paramBaseChatItemLayout.mMessage.uniseq);
      }
      paramView.setImageDrawable(h);
      f(paramwlz);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.stopAnimation();
      return parame;
      parame = paramView;
    }
  }
  
  public BaseBubbleBuilder.d a(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      paramView = (c)((View)paramView.getParent()).getTag();
      if (paramView != null) {
        return paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoPTVItemBuilder$ChatVideoView;
      }
    }
    return null;
  }
  
  public BaseBubbleBuilder.e a()
  {
    return new c();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    MessageForShortVideo localMessageForShortVideo;
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForShortVideo)))
    {
      localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
      if (paramInt != 2131365686) {
        break label38;
      }
      ujt.b(this.mContext, this.app, localMessageForShortVideo);
    }
    label38:
    do
    {
      do
      {
        return;
        if (paramInt == 2131372073)
        {
          super.m(paramChatMessage);
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
            d(localMessageForShortVideo);
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
        if (paramInt == 2131366733)
        {
          aviz.a(localMessageForShortVideo).b(this.app, paramChatMessage).b((Activity)this.mContext, this.app.getAccount());
          avjg.a(this.app, 3, 0, paramChatMessage.istroop);
          avjg.a(this.app, 6, 5);
          return;
        }
        if (paramInt != 2131372030) {
          break label422;
        }
        if (localMessageForShortVideo.md5 != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ShortVideoPTVItemBuilder", 2, "onMenuItemClicked: msg_revoke => md5 = null");
      return;
      int i = 1;
      paramContext = this.app.a().a(localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
      paramInt = i;
      if (paramContext != null) {
        if (!aonu.class.isInstance(paramContext))
        {
          paramInt = i;
          if (!aonn.class.isInstance(paramContext)) {}
        }
        else
        {
          boolean bool = ((aojn)paramContext).isPause();
          int j = localMessageForShortVideo.videoFileStatus;
          if ((!bool) && (j != 1002))
          {
            paramInt = i;
            if (j != 1001) {}
          }
          else
          {
            i = 0;
            this.app.a().B(localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
            ((QQMessageFacade)this.app.getManager(20)).a(localMessageForShortVideo.istroop).x(localMessageForShortVideo);
            paramInt = i;
            if (QLog.isColorLevel())
            {
              QLog.d("ShortVideoPTVItemBuilder", 2, "onMenuItemClicked: stop uploading short video");
              paramInt = i;
            }
          }
        }
      }
    } while (paramInt == 0);
    super.j(localMessageForShortVideo);
    return;
    label422:
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  public void a(View paramView, aoko paramaoko, int paramInt1, int paramInt2)
  {
    paramView = (c)wja.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.mMessage;
    String str = "handleMessage() msgSeq: " + localMessageForShortVideo.uniseq + " ";
    if (localMessageForShortVideo.uniseq != paramaoko.uniseq) {}
    ChatVideoView localChatVideoView;
    do
    {
      return;
      localChatVideoView = paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoPTVItemBuilder$ChatVideoView;
      Resources localResources = this.mContext.getResources();
      paramInt1 = wja.dp2px(' ', localResources);
      paramInt2 = wja.dp2px(' ', localResources);
      if ((paramaoko.fileType == 6) || (paramaoko.fileType == 17) || (paramaoko.fileType == 9) || (paramaoko.fileType == 20))
      {
        b(paramaoko, paramView, localMessageForShortVideo, str, localChatVideoView, paramInt1, paramInt2);
        return;
      }
    } while ((paramaoko.fileType != 7) && (paramaoko.fileType != 18) && (paramaoko.fileType != 16));
    a(paramaoko, paramView, localMessageForShortVideo, str, localChatVideoView, paramInt1, paramInt2);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(0, BaseChatItemLayout.bNV, 0, BaseChatItemLayout.bNW);
      return;
    }
    paramView.setPadding(0, BaseChatItemLayout.bNV, 0, BaseChatItemLayout.bNW);
  }
  
  protected void a(aoko paramaoko, c paramc, MessageForShortVideo paramMessageForShortVideo, String paramString, ChatVideoView paramChatVideoView, int paramInt1, int paramInt2)
  {
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
        } while (!QLog.isColorLevel());
        QLog.i("ShortVideoPTVItemBuilder", 2, "THUMB STATUS_RECV_START");
        return;
        paramString = ShortVideoUtils.bw(paramMessageForShortVideo.thumbMD5, "jpg");
        paramaoko = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
        boolean bool = aqhq.fileExistsAndNotEmpty(paramaoko);
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, "THUMB STATUS_RECV_FINISHED: videoExists=" + bool + ", sAutoPlayInAIO=" + d.bhO);
        }
        if ((bool) && (d.bhO))
        {
          if (paramChatVideoView.hM(paramaoko))
          {
            if (QLog.isColorLevel()) {
              QLog.i("ShortVideoPTVItemBuilder", 2, "STATUS_RECV_FINISHED: 视频存在,刷缩略图 " + paramString);
            }
            if (ShortVideoUtils.awI())
            {
              paramMessageForShortVideo = URLDrawable.URLDrawableOptions.obtain();
              paramMessageForShortVideo.mRequestWidth = paramInt1;
              paramMessageForShortVideo.mRequestHeight = paramInt2;
              paramMessageForShortVideo.mLoadingDrawable = h;
              paramMessageForShortVideo.mFailedDrawable = h;
              paramString = new VideoDrawable.VideoDrawableParams();
              paramString.mPlayVideoFrame = true;
              paramString.mVideoRoundCorner = 0;
              paramString.mRequestedFPS = d.bVw;
              paramMessageForShortVideo.mExtraInfo = paramString;
              paramChatVideoView.setURLDrawable(URLDrawable.getDrawable(new File(paramaoko), paramMessageForShortVideo));
            }
          }
          for (;;)
          {
            b(paramc);
            return;
            paramaoko = paramChatVideoView.n;
            if ((paramaoko != null) && (paramaoko.getStatus() == 1)) {
              paramChatVideoView.setURLDrawable(paramaoko);
            }
          }
        }
        if (!aqhq.fileExistsAndNotEmpty(paramString)) {
          break;
        }
      } while (!paramChatVideoView.hM(paramString));
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoPTVItemBuilder", 2, "STATUS_RECV_FINISHED: 缩略图存在，刷缩略图 " + paramString);
      }
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = paramInt1;
      localURLDrawableOptions.mRequestHeight = paramInt2;
      localURLDrawableOptions.mLoadingDrawable = h;
      localURLDrawableOptions.mFailedDrawable = h;
      paramChatVideoView.setURLDrawable(URLDrawable.getDrawable(new File(paramString), localURLDrawableOptions));
      if (!aqhq.fileExistsAndNotEmpty(paramaoko))
      {
        if (this.app.a().a(paramMessageForShortVideo, true))
        {
          if (QLog.isColorLevel()) {
            QLog.i("ShortVideoPTVItemBuilder", 2, "STATUS_RECV_FINISHED: 刷缩略图，视频文件不存在， isNeedPredownload=true, downloadVideo");
          }
          b(paramMessageForShortVideo, true);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, "STATUS_RECV_FINISHED: 刷缩略图，视频文件不存在， isNeedPredownload=false, showPauseProgress");
        }
        c(paramc);
        return;
      }
      if (ShortVideoUtils.awI())
      {
        b(paramc);
        return;
      }
      c(paramc);
      return;
      paramChatVideoView.setImageDrawable(aoop.getFailedDrawable());
      return;
    case 5002: 
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoPTVItemBuilder", 2, paramString + "THUMB STATUS_FILE_EXPIRED");
      }
      break;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ShortVideoPTVItemBuilder", 2, paramString + "THUMB STATUS_RECV_ERROR");
    }
    paramaoko = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    if (aqhq.fileExistsAndNotEmpty(paramaoko)) {
      if (paramChatVideoView.hM(paramaoko))
      {
        QLog.i("ShortVideoPTVItemBuilder", 2, paramString + "STATUS_RECV_ERROR: 缩略图下载失败刷视频 " + paramaoko);
        if (ShortVideoUtils.awI())
        {
          paramMessageForShortVideo = URLDrawable.URLDrawableOptions.obtain();
          paramMessageForShortVideo.mRequestWidth = paramInt1;
          paramMessageForShortVideo.mRequestHeight = paramInt2;
          paramMessageForShortVideo.mLoadingDrawable = h;
          paramMessageForShortVideo.mFailedDrawable = h;
          paramString = new VideoDrawable.VideoDrawableParams();
          paramString.mPlayVideoFrame = true;
          paramString.mVideoRoundCorner = 0;
          paramString.mRequestedFPS = d.bVw;
          paramMessageForShortVideo.mExtraInfo = paramString;
          paramChatVideoView.setURLDrawable(URLDrawable.getDrawable(new File(paramaoko), paramMessageForShortVideo));
        }
      }
    }
    for (;;)
    {
      b(paramc);
      return;
      paramaoko = paramChatVideoView.n;
      if ((paramaoko != null) && (paramaoko.getStatus() == 1))
      {
        paramChatVideoView.setURLDrawable(paramaoko);
        continue;
        paramChatVideoView.setImageDrawable(h);
      }
    }
  }
  
  void a(c paramc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "showLoading() msgSeq: " + paramc.mMessage.uniseq);
    }
    paramc.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.setIndeterminate(true);
    paramc.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.showLoading();
    paramc.mIcon.setVisibility(8);
  }
  
  void a(c paramc, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "showProgress(), progress = " + paramInt + " msgSeq: " + paramc.mMessage.uniseq);
    }
    CircleProgressView localCircleProgressView = paramc.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView;
    int i = paramInt;
    if (paramInt > 100)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPTVItemBuilder", 2, "startShowProgress, illegal process:" + paramInt + " msgSeq: " + paramc.mMessage.uniseq);
      }
      i = 100;
    }
    localCircleProgressView.setIndeterminate(false);
    localCircleProgressView.setProgress(i);
    paramc.mIcon.setVisibility(8);
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, c paramc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "startUploadVideo：" + paramMessageForShortVideo.toString());
    }
    Object localObject = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    String str = ShortVideoUtils.bw(paramMessageForShortVideo.thumbMD5, "jpg");
    if (!aqhq.fileExistsAndNotEmpty((String)localObject))
    {
      QQToast.a(this.mContext, 1, 2131720277, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
      paramc.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
    }
    do
    {
      return;
      if (!aqhq.fileExistsAndNotEmpty(str))
      {
        QQToast.a(this.mContext, 1, 2131720278, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
        paramc.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        paramMessageForShortVideo.videoFileStatus = 1005;
        return;
      }
      localObject = anfr.a(1, 3);
      ((angi)localObject).c(anfr.a(((angi)localObject).dFl, paramMessageForShortVideo, (angi)localObject));
      anfr.a((angi)localObject, this.app);
    } while ((!paramMessageForShortVideo.isSendFromLocal()) || (paramMessageForShortVideo.videoFileStatus != 1005) || (paramMessageForShortVideo.videoFileProgress != 0));
    a(paramc, 3);
  }
  
  public boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (!paramChatMessage.isSendFromLocal()) {}
    do
    {
      do
      {
        return false;
        paramChatMessage = (MessageForShortVideo)paramChatMessage;
      } while ((paramChatMessage.md5 == null) || (paramChatMessage.videoFileStatus == 5002));
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
    return true;
  }
  
  public aqob[] a(View paramView)
  {
    int k = 0;
    aqoa localaqoa = new aqoa();
    Object localObject = (c)wja.a(paramView);
    paramView = (MessageForShortVideo)((c)localObject).mMessage;
    if (paramView.md5 != null)
    {
      String str = ShortVideoUtils.bw(paramView.thumbMD5, "jpg");
      ShortVideoUtils.a(paramView, "mp4");
      if (aqhq.fileExistsAndNotEmpty(str)) {
        if ((((c)localObject).jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView == null) || (!((c)localObject).jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.isShowing())) {
          break label271;
        }
      }
    }
    label271:
    for (int i = 1;; i = 0)
    {
      int j = k;
      if (((c)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.sc != null)
      {
        j = k;
        if (((c)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.sc.getVisibility() == 0) {
          j = 1;
        }
      }
      if ((paramView.isSendFromLocal()) && (j == 0)) {
        localaqoa.Z(2131367523, this.mContext.getString(2131721067), 2130839086);
      }
      a(paramView, localaqoa);
      if ((i == 0) && (j == 0)) {
        a(localaqoa, this.sessionInfo.cZ, paramView);
      }
      a(localaqoa, paramView);
      if (paramView.md5 != null)
      {
        localObject = ShortVideoUtils.bw(paramView.thumbMD5, "jpg");
        if (aqhq.fileExistsAndNotEmpty(ShortVideoUtils.a(paramView, "mp4"))) {
          localaqoa.Z(2131366733, this.mContext.getString(2131693407), 2130839085);
        }
        if (aqhq.fileExistsAndNotEmpty((String)localObject)) {
          b(paramView, localaqoa);
        }
      }
      super.e(localaqoa, this.mContext);
      return localaqoa.a();
    }
  }
  
  public String b(ChatMessage paramChatMessage)
  {
    if (aqiu.ms(paramChatMessage.issend)) {
      return acfp.m(2131714502);
    }
    return acfp.m(2131714491);
  }
  
  protected void b(aoko paramaoko, c paramc, MessageForShortVideo paramMessageForShortVideo, String paramString, ChatVideoView paramChatVideoView, int paramInt1, int paramInt2)
  {
    switch (paramaoko.status)
    {
    default: 
    case 1001: 
    case 1003: 
    case 1005: 
    case 1004: 
    case 1002: 
    case 2001: 
    case 2003: 
    case 5001: 
    case 2005: 
    case 5002: 
    case 2004: 
      label657:
      label716:
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, paramString + "VIDEO STATUS_SEND_START progress " + paramMessageForShortVideo.videoFileProgress);
        }
        paramc.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        return;
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, paramString + "VIDEO STATUS_SEND_FINISHED");
        }
        b(paramc);
        return;
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, paramString + "VIDEO STATUS_SEND_ERROR");
        }
        paramc.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        b(paramc);
        paramc.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.setVisibility(8);
        return;
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, paramString + "VIDEO STATUS_SEND_CANCEL");
        }
        b(paramc);
        return;
        paramInt1 = paramMessageForShortVideo.videoFileProgress;
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, paramString + "VIDEO STATUS_SEND_PROCESS " + paramInt1);
        }
        a(paramc, paramInt1);
        return;
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, paramString + "VIDEO STATUS_RECV_START");
        }
        a(paramc, paramMessageForShortVideo.videoFileProgress);
        return;
        a(paramc, paramMessageForShortVideo, paramString, paramChatVideoView, paramInt1, paramInt2);
        return;
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, "VIDEO STATUS_FILE_UNSAFE");
        }
        b(paramc);
        if (paramMessageForShortVideo.uiOperatorFlag == 2)
        {
          paramc.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
          QQToast.a(this.mContext, 2131720245, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
          return;
        }
        QQToast.a(this.mContext, 2131720270, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
        return;
        if (QLog.isColorLevel())
        {
          if (paramaoko.status == 2005) {
            QLog.i("ShortVideoPTVItemBuilder", 2, "VIDEO STATUS_RECV_ERROR");
          }
        }
        else
        {
          paramMessageForShortVideo = ShortVideoUtils.bw(paramMessageForShortVideo.thumbMD5, "jpg");
          if (aqhq.fileExistsAndNotEmpty(paramMessageForShortVideo))
          {
            if (!paramChatVideoView.hM(paramMessageForShortVideo)) {
              break label657;
            }
            if (QLog.isColorLevel()) {
              QLog.i("ShortVideoPTVItemBuilder", 2, "STATUS_FILE_EXPIRED: 刷缩略图 " + paramMessageForShortVideo);
            }
            paramString = URLDrawable.URLDrawableOptions.obtain();
            paramString.mLoadingDrawable = h;
            paramString.mFailedDrawable = h;
            paramChatVideoView.setURLDrawable(URLDrawable.getDrawable(new File(paramMessageForShortVideo), paramString));
          }
        }
        for (;;)
        {
          if (paramaoko.status != 2005) {
            break label716;
          }
          b(paramc, 2131718879);
          return;
          QLog.i("ShortVideoPTVItemBuilder", 2, "VIDEO STATUS_FILE_EXPIRED");
          break;
          if (QLog.isColorLevel()) {
            QLog.i("ShortVideoPTVItemBuilder", 2, "STATUS_FILE_EXPIRED: 刷缩略图用缓存 " + paramMessageForShortVideo);
          }
          paramMessageForShortVideo = paramChatVideoView.n;
          if ((paramMessageForShortVideo != null) && (paramMessageForShortVideo.getStatus() == 1)) {
            paramChatVideoView.setURLDrawable(paramMessageForShortVideo);
          }
        }
        b(paramc, 2131718875);
        return;
      } while (!QLog.isColorLevel());
      QLog.i("ShortVideoPTVItemBuilder", 2, "VIDEO STATUS_RECV_CANCEL");
      return;
    }
    paramInt1 = paramMessageForShortVideo.videoFileProgress;
    if (QLog.isColorLevel()) {
      QLog.i("ShortVideoPTVItemBuilder", 2, "VIDEO STATUS_RECV_PROCESS " + paramInt1);
    }
    a(paramc, paramInt1);
  }
  
  void b(c paramc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "hideProgress() msgSeq: " + paramc.mMessage.uniseq);
    }
    paramc.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.hide();
    paramc.mIcon.setVisibility(8);
  }
  
  void b(c paramc, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "showWarnProgress() msgSeq: " + paramc.mMessage.uniseq);
    }
    paramc.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.hide();
    paramc.mIcon.setVisibility(0);
    paramc.mIcon.setImageResource(2130846629);
    paramc.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.setVisibility(4);
  }
  
  public void b(MessageForShortVideo paramMessageForShortVideo, c paramc)
  {
    if (paramMessageForShortVideo == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPTVItemBuilder", 2, "startUploadVideo：" + paramMessageForShortVideo.toString());
      }
      if (!aqhq.fileExistsAndNotEmpty(ShortVideoUtils.bw(paramMessageForShortVideo.thumbMD5, "jpg")))
      {
        QQToast.a(this.mContext, 1, 2131720278, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
        paramc.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        paramMessageForShortVideo.videoFileStatus = 1005;
        return;
      }
      if (!TextUtils.isEmpty(paramMessageForShortVideo.videoFileName))
      {
        paramc = anfr.a(4, 3);
        paramc.b(anfr.a(paramc.dFl, paramMessageForShortVideo, paramc));
        anfr.a(paramc, this.app);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ShortVideoPTVItemBuilder", 2, "ShortVideoRealItemBuilder:reForwardVideo() path is empty");
  }
  
  void b(MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean)
  {
    int j = 1;
    if (paramMessageForShortVideo.videoFileStatus == 5002)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPTVItemBuilder", 2, "downloadVideo():STATUS_FILE_EXPIRED 短视频已过期不启动下载流程");
      }
      return;
    }
    Object localObject = Environment.getExternalStorageDirectory();
    if ((((File)localObject).exists()) && (((File)localObject).canWrite()))
    {
      i = 1;
      if ((!Environment.getExternalStorageState().equals("mounted")) || (i == 0)) {
        break label109;
      }
    }
    label109:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label114;
      }
      QQToast.a(this.mContext, 1, 2131719242, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
      return;
      i = 0;
      break;
    }
    label114:
    localObject = anfr.a(2, 3);
    anfu localanfu = paramMessageForShortVideo.getDownloadInfo(((angi)localObject).dFl);
    localanfu.localPath = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    localanfu.jv(paramMessageForShortVideo.istroop, 0);
    i = j;
    if (paramBoolean) {
      i = 2;
    }
    localanfu.mRequestType = i;
    localanfu.mSceneType = 2;
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, " startDownloadVideo downloadvideo fileType==" + localanfu.fileType + ", uniseq:" + paramMessageForShortVideo.uniseq + "localPath=" + localanfu.localPath);
    }
    ((angi)localObject).c(localanfu);
    ((angi)localObject).p(paramMessageForShortVideo);
    anfr.a((angi)localObject, this.app);
  }
  
  public void bYO()
  {
    super.bYO();
  }
  
  void c(c paramc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "showPauseProgress() msgSeq: " + paramc.mMessage.uniseq);
    }
    paramc.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.hide();
    paramc.mIcon.setVisibility(0);
    paramc.mIcon.setImageResource(2130846628);
    paramc.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.setVisibility(4);
  }
  
  public void d(MessageForShortVideo paramMessageForShortVideo)
  {
    if (TextUtils.isEmpty(paramMessageForShortVideo.md5))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPTVItemBuilder", 2, "Forward menu clicked, md5 is empty.");
      }
      return;
    }
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
      QLog.d("ShortVideoPTVItemBuilder", 2, "Forward menu clicked, thumbPath=" + str1 + ",videoPath = " + str2 + ", " + paramMessageForShortVideo.toLogString());
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
    localBundle.putBoolean("is_forward_ptv", true);
    localBundle.putInt("special_video_type", paramMessageForShortVideo.specialVideoType);
    if (paramMessageForShortVideo.CheckIsHotVideo())
    {
      localBundle.putString("hot_video_icon", paramMessageForShortVideo.hotVideoIconUrl);
      localBundle.putString("hot_video_icon_sub", paramMessageForShortVideo.hotVideoSubIconUrl);
      localBundle.putString("hot_video_title", paramMessageForShortVideo.hotVideoTitle);
      localBundle.putString("hot_video_url", paramMessageForShortVideo.hotVideoUrl);
    }
    paramMessageForShortVideo = new Intent();
    paramMessageForShortVideo.putExtras(localBundle);
    ahgq.f((Activity)this.mContext, paramMessageForShortVideo, 21);
  }
  
  public void ei(View paramView)
  {
    super.ei(paramView);
    paramView = (c)wja.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.mMessage;
    if (!localMessageForShortVideo.isSendFromLocal()) {
      return;
    }
    ausj localausj = (ausj)auss.a(this.mContext, null);
    localausj.addButton(2131690230, 5);
    localausj.addCancelButton(2131721058);
    localausj.a(new xnc(this, localMessageForShortVideo, paramView, localausj));
    localausj.show();
  }
  
  void f(MessageForShortVideo paramMessageForShortVideo)
  {
    angi localangi = anfr.a(2, 3);
    anfu localanfu = paramMessageForShortVideo.getDownloadInfo(localangi.dFl);
    localanfu.thumbPath = ShortVideoUtils.bw(paramMessageForShortVideo.thumbMD5, "jpg");
    if (QLog.isColorLevel()) {
      QLog.e("ShortVideoPTVItemBuilder", 2, "downloadThumb thumbPath" + localanfu.thumbPath);
    }
    localanfu.jv(paramMessageForShortVideo.istroop, 1);
    localanfu.mRequestType = 2;
    localanfu.mSceneType = 2;
    localangi.c(localanfu);
    localangi.p(paramMessageForShortVideo);
    anfr.a(localangi, this.app);
  }
  
  public void onClick(View paramView)
  {
    c localc = (c)wja.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)localc.mMessage;
    if (paramView.getId() == 2131364545) {}
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (!this.app.bF()) {
          break;
        }
        QQToast.a(this.mContext, 2131698108, 1).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
      }
      if (paramView.getId() != 2131364503) {
        break;
      }
    } while (localMessageForShortVideo.md5 == null);
    Object localObject = ShortVideoUtils.bw(localMessageForShortVideo.thumbMD5, "jpg");
    String str = ShortVideoUtils.a(localMessageForShortVideo, "mp4");
    if (QLog.isColorLevel()) {
      QLog.e("ptvitem", 2, "onClick videoPath=" + str + "thumbPath=" + (String)localObject);
    }
    if (!aqhq.fileExistsAndNotEmpty(str))
    {
      b(localMessageForShortVideo, false);
      anot.a(this.app, "CliOper", "", "", "0X8005E96", "0X8005E96", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (!localMessageForShortVideo.isSend()) {
        new alyr(BaseApplication.getContext()).a(this.app, 2003, this.sessionInfo.cZ, this.sessionInfo.aTl, 1003);
      }
      if (localMessageForShortVideo.isBlessMsg) {
        anot.a(this.app, "CliOper", "", "", "0X8006199", "0X8006199", 0, 0, "", "", "" + localMessageForShortVideo.uuid, "" + localMessageForShortVideo.isSend());
      }
      super.onClick(paramView);
      break;
      if (aqhq.fileExistsAndNotEmpty((String)localObject))
      {
        if ((d.bhO) && (ShortVideoUtils.awI()))
        {
          anot.a(this.app, "CliOper", "", "", "0X8005E95", "0X8005E95", 0, 0, "", "", "", "");
          if (this.b == null) {
            break;
          }
          if ((localc.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoPTVItemBuilder$ChatVideoView.getDrawable() == null) || (!(localc.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoPTVItemBuilder$ChatVideoView.getDrawable() instanceof URLDrawable))) {
            continue;
          }
          localObject = (URLDrawable)localc.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoPTVItemBuilder$ChatVideoView.getDrawable();
          if ((((URLDrawable)localObject).getStatus() != 1) || (!(((URLDrawable)localObject).getCurrDrawable() instanceof VideoDrawable))) {
            continue;
          }
          a(localc, localMessageForShortVideo, (URLDrawable)localObject);
          continue;
        }
        ShortVideoRealItemBuilder.a(this.app, this.mContext, localMessageForShortVideo, localc.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoPTVItemBuilder$ChatVideoView, this.sessionInfo, false, true, true, true, null);
      }
    }
  }
  
  static class ChatVideoView
    extends CircleBubbleImageView
  {
    URLDrawable n;
    URLDrawable v;
    
    public ChatVideoView(Context paramContext)
    {
      super();
      TG(true);
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
  
  public static class a
    extends Handler
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      int i;
      do
      {
        do
        {
          return;
          i = paramMessage.arg1;
          paramMessage = paramMessage.getData();
        } while (!QLog.isColorLevel());
        QLog.i("ShortVideoPTVItemBuilder", 2, "ret is " + i);
        QLog.i("ShortVideoPTVItemBuilder", 2, "data is " + paramMessage);
        return;
        i = paramMessage.arg1;
        switch (paramMessage.arg1)
        {
        default: 
          return;
        }
        paramMessage = paramMessage.getData().getString("maxvideo.file.mp4");
      } while (!QLog.isColorLevel());
      QLog.i("ShortVideoPTVItemBuilder", 2, "ret is " + i);
      QLog.i("ShortVideoPTVItemBuilder", 2, "targetFile is " + paramMessage);
    }
  }
  
  static class b
    extends AsyncTask<Void, Void, Integer>
  {
    MessageForShortVideo j;
    WeakReference<Context> mContext;
    String mVideoMd5;
    String mVideoPath;
    WeakReference<QQAppInterface> n;
    
    public b(QQAppInterface paramQQAppInterface, Context paramContext, MessageForShortVideo paramMessageForShortVideo)
    {
      this.mContext = new WeakReference(paramContext);
      this.n = new WeakReference(paramQQAppInterface);
      this.j = paramMessageForShortVideo;
    }
    
    protected Integer a(Void... paramVarArgs)
    {
      paramVarArgs = null;
      if ((this.mContext == null) || (this.mContext.get() == null)) {
        return Integer.valueOf(7);
      }
      Object localObject = (Context)this.mContext.get();
      if (this.j == null) {
        return Integer.valueOf(7);
      }
      MessageForShortVideo localMessageForShortVideo = this.j;
      if (aqhq.fileExistsAndNotEmpty(localMessageForShortVideo.videoFileName))
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShortVideoPTVItemBuilder", 2, "mr.videoFileName is not null...");
        }
        return Integer.valueOf(5);
      }
      aqip.beginPile();
      localObject = new EncodeThread((Context)localObject, new ShortVideoPTVItemBuilder.a(Looper.getMainLooper()), localMessageForShortVideo.mVideoFileSourceDir, null, null);
      ((EncodeThread)localObject).run();
      String str2 = ((EncodeThread)localObject).cdZ;
      aqip.endPile("ShortVideoPTVItemBuilder", "EncodeThread");
      if (!aqhq.fileExistsAndNotEmpty(str2)) {
        return Integer.valueOf(8);
      }
      localObject = new File(str2);
      long l = ((File)localObject).length();
      if (l == 0L)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShortVideoPTVItemBuilder", 2, "mVideoSize = 0");
        }
        return Integer.valueOf(8);
      }
      try
      {
        localObject = new FileInputStream((File)localObject);
        if (localObject != null)
        {
          localObject = HexUtil.bytes2HexStr(MD5.toMD5Byte((InputStream)localObject, l));
          paramVarArgs = (Void[])localObject;
          if (TextUtils.isEmpty((CharSequence)localObject))
          {
            if (QLog.isColorLevel()) {
              QLog.e("ShortVideoPTVItemBuilder", 2, "processThumb: mVideoMd5 is empty, " + (String)localObject);
            }
            return Integer.valueOf(5);
          }
        }
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        localFileNotFoundException.printStackTrace();
        if (0 != 0)
        {
          str1 = HexUtil.bytes2HexStr(MD5.toMD5Byte(null, l));
          paramVarArgs = str1;
          if (TextUtils.isEmpty(str1))
          {
            if (QLog.isColorLevel()) {
              QLog.e("ShortVideoPTVItemBuilder", 2, "processThumb: mVideoMd5 is empty, " + str1);
            }
            return Integer.valueOf(5);
          }
        }
      }
      finally
      {
        String str1;
        if (0 != 0)
        {
          str1 = HexUtil.bytes2HexStr(MD5.toMD5Byte(null, l));
          if (TextUtils.isEmpty(str1))
          {
            if (QLog.isColorLevel()) {
              QLog.e("ShortVideoPTVItemBuilder", 2, "processThumb: mVideoMd5 is empty, " + str1);
            }
            return Integer.valueOf(5);
          }
        }
      }
      this.mVideoMd5 = paramVarArgs;
      this.mVideoPath = str2;
      localMessageForShortVideo.videoFileSize = ((int)l);
      if (aqhq.fileExistsAndNotEmpty(localMessageForShortVideo.mThumbFilePath))
      {
        paramVarArgs = ShortVideoUtils.bw(localMessageForShortVideo.thumbMD5, "jpg");
        if (!paramVarArgs.equals(localMessageForShortVideo.mThumbFilePath))
        {
          if (!aqhq.rename(paramVarArgs, localMessageForShortVideo.mThumbFilePath)) {
            return Integer.valueOf(5);
          }
          localMessageForShortVideo.mThumbFilePath = paramVarArgs;
        }
      }
      return Integer.valueOf(1);
    }
    
    protected void onPostExecute(Integer paramInteger)
    {
      super.onPostExecute(paramInteger);
      switch (paramInteger.intValue())
      {
      }
      do
      {
        do
        {
          if (QLog.isColorLevel()) {
            QLog.i("ShortVideoPTVItemBuilder", 2, "Error code " + paramInteger);
          }
          return;
        } while (this.n == null);
        paramInteger = (QQAppInterface)this.n.get();
        if (paramInteger != null)
        {
          Object localObject1 = this.j;
          ((MessageForShortVideo)localObject1).md5 = this.mVideoMd5;
          Object localObject2 = ShortVideoUtils.a((MessageForShortVideo)localObject1, "mp4");
          if (!this.mVideoPath.equals(localObject2))
          {
            aqhq.rename(this.mVideoPath, (String)localObject2);
            if (QLog.isColorLevel()) {
              QLog.i("ShortVideoPTVItemBuilder", 2, "onPostExecute destVideoPath " + (String)localObject2);
            }
          }
          ((MessageForShortVideo)localObject1).videoFileName = ((String)localObject2);
          ((MessageForShortVideo)localObject1).serial();
          paramInteger.b().c(((MessageForShortVideo)localObject1).frienduin, ((MessageForShortVideo)localObject1).istroop, ((MessageForShortVideo)localObject1).uniseq, ((MessageForShortVideo)localObject1).msgData);
          localObject2 = anfr.a(0, 3);
          localObject1 = anfr.a(localObject1, (angi)localObject2);
          ((angt)localObject1).cFz = false;
          ((angi)localObject2).c((angt)localObject1);
          anfr.a((angi)localObject2, paramInteger);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.i("ShortVideoPTVItemBuilder", 2, "QQAppInterface is null...");
    }
    
    protected void onPreExecute()
    {
      super.onPreExecute();
    }
  }
  
  public class c
    extends BaseBubbleBuilder.e
  {
    ShortVideoPTVItemBuilder.ChatVideoView jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoPTVItemBuilder$ChatVideoView;
    AudioAnimationView jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView;
    CircleProgressView jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView;
    ImageView mIcon;
    
    public c() {}
  }
  
  public static class d
  {
    public static int bVw = 15;
    public static int bVx = 20;
    public static boolean bhN;
    public static boolean bhO = true;
    
    public static void initConfig()
    {
      Object localObject;
      if (!bhN)
      {
        localObject = DeviceProfileManager.a().aJ(DeviceProfileManager.DpcNames.PtvConfig.name(), null);
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideo.PtvPlayConfig", 2, "initConfig(), ptvConfig=" + (String)localObject);
        }
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label211;
        }
        localObject = ((String)localObject).split("\\|");
        if ((localObject != null) && (localObject.length >= 3) && (TextUtils.isEmpty(localObject[0]))) {}
      }
      try
      {
        bVx = Integer.parseInt(localObject[0]);
        label93:
        if (!TextUtils.isEmpty(localObject[1])) {
          bhO = localObject[1].equals("1");
        }
        if (!TextUtils.isEmpty(localObject[2])) {}
        for (;;)
        {
          try
          {
            bVw = Integer.parseInt(localObject[2]);
            bhN = true;
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideo.PtvPlayConfig", 2, "initConfig(), sReadFromDPC=" + bhN + ", sAutoPlayInAIO:" + bhO + ", sRequestedFPS:" + bVw + ",sPtvMaxTime:" + bVx);
            }
            return;
          }
          catch (Exception localException1)
          {
            bVw = 15;
            continue;
          }
          label211:
          bhO = true;
          bVw = 15;
        }
      }
      catch (Exception localException2)
      {
        break label93;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoPTVItemBuilder
 * JD-Core Version:    0.7.0.1
 */