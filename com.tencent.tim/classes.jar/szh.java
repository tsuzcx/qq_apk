import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.device.msg.activities.AIODevLittleVideoData;
import com.tencent.device.msg.activities.DevLittleVideoItemBuilder.1;
import com.tencent.device.msg.activities.DevLittleVideoItemBuilder.5;
import com.tencent.device.msg.activities.DevLittleVideoItemBuilder.6;
import com.tencent.device.msg.activities.DevLittleVideoItemBuilder.7;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.a;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.a;
import com.tencent.mobileqq.videoplatform.view.CropBubbleVideoView;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class szh
  extends ShortVideoRealItemBuilder
  implements szd.b
{
  private aaza.c b = new szi(this);
  private MessageForShortVideo f;
  
  public szh(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public static void a(Context paramContext, MessageForShortVideo paramMessageForShortVideo, View paramView, SessionInfo paramSessionInfo)
  {
    MessageForDevLittleVideo localMessageForDevLittleVideo = (MessageForDevLittleVideo)paramMessageForShortVideo;
    Object localObject3 = paramMessageForShortVideo.videoFileName;
    Object localObject1 = paramMessageForShortVideo.mThumbFilePath;
    if (paramMessageForShortVideo.isSendFromLocal())
    {
      localObject2 = ShortVideoUtils.bw(paramMessageForShortVideo.thumbMD5, "jpg");
      localObject1 = localObject2;
      if (!aqhq.fileExistsAndNotEmpty((String)localObject3))
      {
        localObject3 = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
        localObject1 = localObject2;
      }
    }
    for (Object localObject2 = localObject3;; localObject2 = localObject3)
    {
      if (ShortVideoUtils.awI())
      {
        paramView = new Bundle();
        paramView.putInt("uintype", paramMessageForShortVideo.istroop);
        paramView.putString("from_uin", ShortVideoUtils.f(paramMessageForShortVideo));
        paramView.putInt("from_uin_type", paramSessionInfo.cZ);
        paramView.putInt("from_busi_type", paramMessageForShortVideo.busiType);
        paramView.putInt("file_send_size", paramMessageForShortVideo.videoFileSize);
        paramView.putInt("file_send_duration", paramMessageForShortVideo.videoFileTime);
        paramView.putString("file_name", paramMessageForShortVideo.videoFileName);
        paramView.putInt("file_format", paramMessageForShortVideo.videoFileFormat);
        paramView.putString("file_send_path", (String)localObject2);
        paramView.putString("thumbfile_send_path", (String)localObject1);
        paramView.putString("file_shortvideo_md5", paramMessageForShortVideo.md5);
        paramView.putInt("thumbfile_send_width", paramMessageForShortVideo.thumbWidth);
        paramView.putInt("thumbfile_send_height", paramMessageForShortVideo.thumbHeight);
        paramView.putString("thumbfile_md5", paramMessageForShortVideo.thumbMD5);
        paramView.putString("file_source", paramMessageForShortVideo.fileSource);
        paramView.putString("file_uuid", paramMessageForShortVideo.uuid);
        paramView.putInt("file_thumb_Size", paramMessageForShortVideo.thumbFileSize);
        paramView.putInt("video_play_caller", 0);
        paramView.putLong("message_click_start", System.currentTimeMillis());
        paramView.putParcelable("key_message_for_shortvideo", paramMessageForShortVideo);
        paramMessageForShortVideo = new Intent(paramContext, ShortVideoPlayActivity.class);
        paramMessageForShortVideo.putExtras(paramView);
        paramContext.startActivity(paramMessageForShortVideo);
        return;
      }
      paramView = sxx.getViewRect(paramView);
      paramMessageForShortVideo = new Bundle();
      paramMessageForShortVideo.putParcelable("KEY_THUMBNAL_BOUND", paramView);
      if ((((paramContext instanceof ChatActivity)) || ((paramContext instanceof SplashActivity))) && (!(paramContext instanceof MultiForwardActivity)) && (!paramSessionInfo.beB)) {
        paramMessageForShortVideo.putInt("extra.AIO_CURRENT_PANEL_STATE", ((FragmentActivity)paramContext).getChatFragment().a().vm());
      }
      paramMessageForShortVideo.putBoolean("extra.IS_FROM_MULTI_MSG", false);
      paramView = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramView.hasNext())
      {
        localObject3 = (ActivityManager.RunningAppProcessInfo)paramView.next();
        if (((ActivityManager.RunningAppProcessInfo)localObject3).processName.endsWith("mobileqq")) {
          paramMessageForShortVideo.putInt("extra.MOBILE_QQ_PROCESS_ID", ((ActivityManager.RunningAppProcessInfo)localObject3).pid);
        }
      }
      paramMessageForShortVideo.putInt("forward_source_uin_type", paramSessionInfo.cZ);
      paramMessageForShortVideo.putString("uin", localMessageForDevLittleVideo.frienduin);
      paramView = new AIODevLittleVideoData();
      paramView.aWo = ((String)localObject1);
      paramView.aWp = ((String)localObject2);
      paramMessageForShortVideo.putBoolean("extra.ENTER_NEW_GALLERY", true);
      avfp.a(paramContext, paramMessageForShortVideo, new AIOImageProviderService(localMessageForDevLittleVideo.selfuin, localMessageForDevLittleVideo.frienduin, localMessageForDevLittleVideo.istroop, localMessageForDevLittleVideo), paramView, -1, -1);
      return;
    }
  }
  
  private void a(CropBubbleVideoView paramCropBubbleVideoView, String paramString)
  {
    if (a(paramCropBubbleVideoView, paramString))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = h;
      localURLDrawableOptions.mFailedDrawable = h;
      paramCropBubbleVideoView.showCover(URLDrawable.getDrawable(new File(paramString), localURLDrawableOptions));
    }
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    paramBaseChatItemLayout = (ShortVideoRealItemBuilder.a)parame;
    Object localObject1 = this.mContext;
    parame = ((Context)localObject1).getResources();
    MessageForDevLittleVideo localMessageForDevLittleVideo = (MessageForDevLittleVideo)paramChatMessage;
    paramChatMessage = ShortVideoUtils.d(localMessageForDevLittleVideo.thumbWidth, localMessageForDevLittleVideo.thumbHeight);
    int i = paramChatMessage[0];
    int j = paramChatMessage[1];
    boolean bool = localMessageForDevLittleVideo.isSend();
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramChatMessage = new RelativeLayout((Context)localObject1);
      paramView = (CropBubbleVideoView)allg.createCropBubbleView(this.mContext, localMessageForDevLittleVideo.uniseq, null, bool);
      paramView.setId(2131362384);
      paramView.setVisibility(0);
      paramView.setContentDescription(acfp.m(2131705039));
      paramChatMessage.addView(paramView);
      MessageProgressView localMessageProgressView = new MessageProgressView((Context)localObject1);
      paramChatMessage.addView(localMessageProgressView);
      ImageView localImageView = new ImageView((Context)localObject1);
      localImageView.setImageResource(2130838136);
      localImageView.setVisibility(8);
      Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131373231);
      ((RelativeLayout.LayoutParams)localObject2).addRule(8, 2131373231);
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = wja.dp2px(10.0F, parame);
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = wja.dp2px(10.0F, parame);
      paramChatMessage.addView(localImageView, (ViewGroup.LayoutParams)localObject2);
      localObject2 = new LinearLayout((Context)localObject1);
      ((LinearLayout)localObject2).setOrientation(1);
      ((LinearLayout)localObject2).setGravity(17);
      Object localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(13);
      paramChatMessage.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject1 = new TextView((Context)localObject1);
      localObject3 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject3).topMargin = wja.dp2px(70.0F, parame);
      ((TextView)localObject1).setTextColor(-1);
      ((TextView)localObject1).setTextSize(2, 12.0F);
      ((TextView)localObject1).setId(2131364543);
      ((LinearLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
      paramChatMessage.setOnClickListener(this);
      paramChatMessage.setOnTouchListener(paramwlz);
      paramChatMessage.setOnLongClickListener(paramwlz);
      paramBaseChatItemLayout.b = paramView;
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = localMessageProgressView;
      paramBaseChatItemLayout.mTextView = ((TextView)localObject1);
      paramBaseChatItemLayout.mIcon = localImageView;
    }
    parame = paramBaseChatItemLayout.b.getLayoutParams();
    if (parame == null)
    {
      parame = new RelativeLayout.LayoutParams(i, j);
      paramBaseChatItemLayout.b.setLayoutParams(parame);
      ((szy)this.app.getBusinessHandler(49)).a().a(paramChatMessage, this);
      paramwlz = paramBaseChatItemLayout.b;
      parame = paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView;
      paramView = paramBaseChatItemLayout.mTextView;
      if (!localMessageForDevLittleVideo.isSendFromLocal()) {
        break label826;
      }
      if ((localMessageForDevLittleVideo.md5 != null) && (localMessageForDevLittleVideo.md5.length() != 0)) {
        break label629;
      }
      paramView = localMessageForDevLittleVideo.mThumbFilePath;
      if (!aqhq.fileExistsAndNotEmpty(paramView)) {
        break label598;
      }
      if (QLog.isColorLevel()) {
        QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: 占坑");
      }
      a(paramwlz, paramView);
      a(localMessageForDevLittleVideo, paramBaseChatItemLayout, localMessageForDevLittleVideo.videoFileProgress, false);
      ThreadManager.postImmediately(new DevLittleVideoItemBuilder.1(this, localMessageForDevLittleVideo), null, true);
    }
    label598:
    label629:
    do
    {
      do
      {
        do
        {
          return paramChatMessage;
          if ((parame.width == i) && (parame.height == j)) {
            break;
          }
          parame.width = i;
          parame.height = j;
          paramBaseChatItemLayout.b.setLayoutParams(parame);
          break;
          paramwlz.showCover(aoop.getFailedDrawable());
          parame.setVisibility(4);
        } while (!QLog.isColorLevel());
        QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView:You must get thumb before send video.");
        return paramChatMessage;
        localObject1 = ShortVideoUtils.bw(localMessageForDevLittleVideo.thumbMD5, "jpg");
        paramView = localMessageForDevLittleVideo.videoFileName;
        parame = paramView;
        if (!aqhq.fileExistsAndNotEmpty(paramView)) {
          parame = ShortVideoUtils.a(localMessageForDevLittleVideo, "mp4");
        }
        if (localMessageForDevLittleVideo.videoFileStatus == 1003)
        {
          if ((ShortVideoUtils.a.bhO) && (ShortVideoUtils.awI()) && (aqhq.fileExistsAndNotEmpty(parame)))
          {
            if (QLog.isColorLevel()) {
              QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: showVideo(video send finished)");
            }
            a(paramwlz, parame, (String)localObject1, localMessageForDevLittleVideo, localMessageForDevLittleVideo.thumbWidth, localMessageForDevLittleVideo.thumbHeight);
            return paramChatMessage;
          }
          if (QLog.isColorLevel()) {
            QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: showThumb(video send finished)");
          }
          a(paramwlz, (String)localObject1);
          return paramChatMessage;
        }
        if (QLog.isColorLevel()) {
          QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: showThumb (video not send finished)");
        }
        a(paramwlz, (String)localObject1);
      } while (localMessageForDevLittleVideo.videoFileStatus != 1002);
      if (QLog.isColorLevel()) {
        QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: showProgress (video sending)");
      }
      a(localMessageForDevLittleVideo, paramBaseChatItemLayout, localMessageForDevLittleVideo.videoFileProgress, false);
      return paramChatMessage;
      parame = localMessageForDevLittleVideo.videoFileName;
      paramView = localMessageForDevLittleVideo.mThumbFilePath;
      if (aqhq.fileExistsAndNotEmpty(parame))
      {
        if ((ShortVideoUtils.a.bhO) && (ShortVideoUtils.awI()))
        {
          if (QLog.isColorLevel()) {
            QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: showVideo(video recv finished)");
          }
          a(paramwlz, parame, paramView, localMessageForDevLittleVideo, localMessageForDevLittleVideo.thumbWidth, localMessageForDevLittleVideo.thumbHeight);
          return paramChatMessage;
        }
        if (aqhq.fileExistsAndNotEmpty(paramView))
        {
          if (QLog.isColorLevel()) {
            QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: showThumb(video recv finished)");
          }
          a(paramwlz, paramView);
          return paramChatMessage;
        }
        c(localMessageForDevLittleVideo);
        return paramChatMessage;
      }
      if (QLog.isColorLevel()) {
        QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: showLoading(video not recv finished)");
      }
      paramwlz.showCover(h);
      if (QLog.isColorLevel()) {
        QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: downloadLittleVideo(video not recv finished)");
      }
      if (!aqiw.isNetworkAvailable(this.app.getApplication().getApplicationContext()))
      {
        localMessageForDevLittleVideo.videoFileStatus = 2005;
        localMessageForDevLittleVideo.videoFileProgress = 0;
        localMessageForDevLittleVideo.serial();
        this.app.b().c(localMessageForDevLittleVideo.frienduin, localMessageForDevLittleVideo.istroop, localMessageForDevLittleVideo.uniseq, localMessageForDevLittleVideo.msgData);
        return paramChatMessage;
      }
    } while (localMessageForDevLittleVideo.videoFileStatus != 2001);
    label826:
    localMessageForDevLittleVideo.videoFileStatus = 2002;
    localMessageForDevLittleVideo.videoFileProgress = 0;
    localMessageForDevLittleVideo.serial();
    this.app.b().c(localMessageForDevLittleVideo.frienduin, localMessageForDevLittleVideo.istroop, localMessageForDevLittleVideo.uniseq, localMessageForDevLittleVideo.msgData);
    a(localMessageForDevLittleVideo, paramBaseChatItemLayout, localMessageForDevLittleVideo.videoFileProgress, false);
    if (!aqhq.fileExistsAndNotEmpty(paramView))
    {
      if (QLog.isColorLevel()) {
        QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: downloadLittleVideoThumb(video not recv finished)");
      }
      c(localMessageForDevLittleVideo);
    }
    b(localMessageForDevLittleVideo);
    return paramChatMessage;
  }
  
  public void a(View paramView, szd.c paramc)
  {
    paramView = (ShortVideoRealItemBuilder.a)wja.a(paramView);
    if (paramView.mMessage.uniseq != paramc.mUniseq) {}
    MessageForDevLittleVideo localMessageForDevLittleVideo;
    CropBubbleVideoView localCropBubbleVideoView;
    int i;
    do
    {
      do
      {
        do
        {
          return;
          localMessageForDevLittleVideo = (MessageForDevLittleVideo)paramView.mMessage;
          if (QLog.isColorLevel()) {
            QLog.d("DevLittleVideoItemBuilder", 2, "updateView msg.uniseq:" + paramc.mUniseq + " ===> fileStatus:" + ShortVideoUtils.ff(paramc.mStatus));
          }
          localCropBubbleVideoView = paramView.b;
          i = (int)(paramc.oy * 100.0F);
          switch (paramc.mStatus)
          {
          default: 
            return;
          }
        } while (!QLog.isColorLevel());
        QLog.i("DevLittleVideoItemBuilder", 2, "VIDEO STATUS_SEND_START progress " + localMessageForDevLittleVideo.videoFileProgress);
        return;
        if (QLog.isColorLevel()) {
          QLog.i("DevLittleVideoItemBuilder", 2, "VIDEO STATUS_SEND_FINISHED");
        }
        paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        a(paramView);
      } while (!ShortVideoUtils.a.bhO);
      paramc = localMessageForDevLittleVideo.videoFileName;
      paramView = paramc;
      if (!aqhq.fileExistsAndNotEmpty(paramc)) {
        paramView = ShortVideoUtils.a(localMessageForDevLittleVideo, "mp4");
      }
    } while ((!ShortVideoUtils.awI()) || (!aqhq.fileExistsAndNotEmpty(paramView)));
    a(localCropBubbleVideoView, paramView, localMessageForDevLittleVideo.mThumbFilePath, localMessageForDevLittleVideo, localMessageForDevLittleVideo.thumbWidth, localMessageForDevLittleVideo.thumbHeight);
    return;
    if (QLog.isColorLevel()) {
      QLog.i("DevLittleVideoItemBuilder", 2, "VIDEO STATUS_SEND_ERROR");
    }
    paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
    a(paramView);
    notifyDataSetChanged();
    return;
    if (QLog.isColorLevel()) {
      QLog.i("DevLittleVideoItemBuilder", 2, "VIDEO STATUS_SEND_PROCESS " + i);
    }
    paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
    a(localMessageForDevLittleVideo, paramView, i, true);
    return;
    if (QLog.isColorLevel()) {
      QLog.i("DevLittleVideoItemBuilder", 2, "VIDEO STATUS_SEND_FINISHED");
    }
    paramc = localMessageForDevLittleVideo.videoFileName;
    String str = localMessageForDevLittleVideo.mThumbFilePath;
    if ((ShortVideoUtils.a.bhO) && (ShortVideoUtils.awI()) && (aqhq.fileExistsAndNotEmpty(paramc)))
    {
      a(localCropBubbleVideoView, paramc, str, localMessageForDevLittleVideo, localMessageForDevLittleVideo.thumbWidth, localMessageForDevLittleVideo.thumbHeight);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
    }
    for (;;)
    {
      a(paramView);
      return;
      if (aqhq.fileExistsAndNotEmpty(str))
      {
        a(localCropBubbleVideoView, str);
        paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
      }
      else
      {
        localCropBubbleVideoView.showCover(aoop.getFailedDrawable());
        paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        notifyDataSetChanged();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("DevLittleVideoItemBuilder", 2, "VIDEO STATUS_SEND_PROCESS " + i);
    }
    a(localMessageForDevLittleVideo, paramView, i, true);
    return;
    if (QLog.isColorLevel()) {
      QLog.i("DevLittleVideoItemBuilder", 2, "VIDEO STATUS_SEND_ERROR");
    }
    paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
    a(paramView);
    notifyDataSetChanged();
  }
  
  void a(MessageForDevLittleVideo paramMessageForDevLittleVideo)
  {
    this.app.execute(new DevLittleVideoItemBuilder.5(this, paramMessageForDevLittleVideo));
  }
  
  public boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    paramChatMessage = (MessageForDevLittleVideo)paramChatMessage;
    return (paramChatMessage.videoFileStatus == 1005) || (paramChatMessage.videoFileStatus == 2005);
  }
  
  public aqob[] a(View paramView)
  {
    paramView = new aqoa();
    ujt.a(paramView, this.mContext, this.sessionInfo.cZ);
    return paramView.a();
  }
  
  void b(MessageForDevLittleVideo paramMessageForDevLittleVideo)
  {
    if (paramMessageForDevLittleVideo.isSendFromLocal()) {
      return;
    }
    this.app.execute(new DevLittleVideoItemBuilder.6(this, paramMessageForDevLittleVideo));
  }
  
  void c(MessageForDevLittleVideo paramMessageForDevLittleVideo)
  {
    if (paramMessageForDevLittleVideo.isSendFromLocal()) {
      return;
    }
    this.app.execute(new DevLittleVideoItemBuilder.7(this, paramMessageForDevLittleVideo));
  }
  
  public void ei(View paramView)
  {
    paramView = (ShortVideoRealItemBuilder.a)wja.a(paramView);
    MessageForDevLittleVideo localMessageForDevLittleVideo = (MessageForDevLittleVideo)paramView.mMessage;
    if (localMessageForDevLittleVideo.isSendFromLocal())
    {
      localausj = (ausj)auss.a(this.mContext, null);
      localausj.addButton(2131690230, 5);
      localausj.addCancelButton(2131721058);
      localausj.a(new szj(this, localMessageForDevLittleVideo, paramView, localausj));
      localausj.show();
      return;
    }
    ausj localausj = (ausj)auss.a(this.mContext, null);
    localausj.addButton(2131690232, 5);
    localausj.addCancelButton(2131721058);
    localausj.a(new szk(this, localMessageForDevLittleVideo, paramView, localausj));
    localausj.show();
  }
  
  public void onClick(View paramView)
  {
    ShortVideoRealItemBuilder.a locala = (ShortVideoRealItemBuilder.a)wja.a(paramView);
    MessageForDevLittleVideo localMessageForDevLittleVideo = (MessageForDevLittleVideo)locala.mMessage;
    if (paramView.getId() == 2131364545) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.app.bF())
      {
        QQToast.a(this.mContext, 2131698108, 1).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
      }
      else if (paramView.getId() == 2131364503)
      {
        String str2 = localMessageForDevLittleVideo.videoFileName;
        Object localObject = localMessageForDevLittleVideo.mThumbFilePath;
        String str1 = str2;
        if (localMessageForDevLittleVideo.isSendFromLocal())
        {
          String str3 = ShortVideoUtils.bw(localMessageForDevLittleVideo.thumbMD5, "jpg");
          localObject = str3;
          str1 = str2;
          if (!aqhq.fileExistsAndNotEmpty(str2))
          {
            str1 = ShortVideoUtils.a(localMessageForDevLittleVideo, "mp4");
            localObject = str3;
          }
        }
        if (!aqhq.fileExistsAndNotEmpty(str1))
        {
          if (QLog.isColorLevel()) {
            QLog.i("DevLittleVideoItemBuilder", 2, "downloadLittleVideo ");
          }
          b(localMessageForDevLittleVideo);
        }
        else if (!aqhq.fileExistsAndNotEmpty((String)localObject))
        {
          if (QLog.isColorLevel()) {
            QLog.i("DevLittleVideoItemBuilder", 2, "downloadLittleVideoThumb ");
          }
          c(localMessageForDevLittleVideo);
        }
        else
        {
          anot.a(this.app, "CliOper", "", "", "0X800561C", "0X800561C", 0, 0, "", "", "", "");
          a(this.mContext, localMessageForDevLittleVideo, locala.b, this.sessionInfo);
        }
      }
      else
      {
        super.onClick(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     szh
 * JD-Core Version:    0.7.0.1
 */