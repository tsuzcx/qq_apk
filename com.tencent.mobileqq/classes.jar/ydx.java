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
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.videoplatform.CropBubbleVideoView;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class ydx
  extends ShortVideoRealItemBuilder
  implements ybv
{
  private aigq jdField_a_of_type_Aigq = new ydy(this);
  private MessageForShortVideo jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
  
  public ydx(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
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
      localObject2 = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
      localObject1 = localObject2;
      if (!bbdj.b((String)localObject3))
      {
        localObject3 = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
        localObject1 = localObject2;
      }
    }
    for (Object localObject2 = localObject3;; localObject2 = localObject3)
    {
      if (ShortVideoUtils.a())
      {
        paramView = new Bundle();
        paramView.putInt("uintype", paramMessageForShortVideo.istroop);
        paramView.putString("from_uin", ShortVideoUtils.d(paramMessageForShortVideo));
        paramView.putInt("from_uin_type", paramSessionInfo.jdField_a_of_type_Int);
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
      paramView = xpx.a(paramView);
      paramMessageForShortVideo = new Bundle();
      paramMessageForShortVideo.putParcelable("KEY_THUMBNAL_BOUND", paramView);
      if ((((paramContext instanceof ChatActivity)) || ((paramContext instanceof SplashActivity))) && (!(paramContext instanceof MultiForwardActivity))) {
        paramMessageForShortVideo.putInt("extra.AIO_CURRENT_PANEL_STATE", ((FragmentActivity)paramContext).getChatFragment().a().f());
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
      paramMessageForShortVideo.putInt("forward_source_uin_type", paramSessionInfo.jdField_a_of_type_Int);
      paramMessageForShortVideo.putString("uin", localMessageForDevLittleVideo.frienduin);
      paramView = new AIODevLittleVideoData();
      paramView.a = ((String)localObject1);
      paramView.b = ((String)localObject2);
      paramMessageForShortVideo.putBoolean("extra.ENTER_NEW_GALLERY", true);
      bgkh.a(paramContext, paramMessageForShortVideo, new AIOImageProviderService(localMessageForDevLittleVideo.selfuin, localMessageForDevLittleVideo.frienduin, localMessageForDevLittleVideo.istroop, localMessageForDevLittleVideo), paramView, -1, -1);
      return;
    }
  }
  
  private void a(CropBubbleVideoView paramCropBubbleVideoView, String paramString)
  {
    if (a(paramCropBubbleVideoView, paramString))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      localURLDrawableOptions.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      paramCropBubbleVideoView.a(URLDrawable.getDrawable(new File(paramString), localURLDrawableOptions));
    }
  }
  
  public View a(ChatMessage paramChatMessage, acun paramacun, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxn paramacxn)
  {
    paramBaseChatItemLayout = (aeah)paramacun;
    Object localObject1 = this.jdField_a_of_type_AndroidContentContext;
    paramacun = ((Context)localObject1).getResources();
    MessageForDevLittleVideo localMessageForDevLittleVideo = (MessageForDevLittleVideo)paramChatMessage;
    paramChatMessage = ShortVideoUtils.a(localMessageForDevLittleVideo.thumbWidth, localMessageForDevLittleVideo.thumbHeight);
    int i = paramChatMessage[0];
    int j = paramChatMessage[1];
    boolean bool = localMessageForDevLittleVideo.isSend();
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramChatMessage = new RelativeLayout((Context)localObject1);
      paramView = new CropBubbleVideoView(this.jdField_a_of_type_AndroidContentContext, localMessageForDevLittleVideo.uniseq, null, bool);
      paramView.setId(2131362238);
      paramView.setVisibility(0);
      paramView.setContentDescription(ajyc.a(2131703241));
      paramChatMessage.addView(paramView);
      MessageProgressView localMessageProgressView = new MessageProgressView((Context)localObject1);
      paramChatMessage.addView(localMessageProgressView);
      ImageView localImageView = new ImageView((Context)localObject1);
      localImageView.setImageResource(2130837749);
      localImageView.setVisibility(8);
      Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131371608);
      ((RelativeLayout.LayoutParams)localObject2).addRule(8, 2131371608);
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = actn.a(10.0F, paramacun);
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = actn.a(10.0F, paramacun);
      paramChatMessage.addView(localImageView, (ViewGroup.LayoutParams)localObject2);
      localObject2 = new LinearLayout((Context)localObject1);
      ((LinearLayout)localObject2).setOrientation(1);
      ((LinearLayout)localObject2).setGravity(17);
      Object localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(13);
      paramChatMessage.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject1 = new TextView((Context)localObject1);
      localObject3 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject3).topMargin = actn.a(70.0F, paramacun);
      ((TextView)localObject1).setTextColor(-1);
      ((TextView)localObject1).setTextSize(2, 12.0F);
      ((TextView)localObject1).setId(2131364150);
      ((LinearLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
      paramChatMessage.setOnClickListener(this);
      paramChatMessage.setOnTouchListener(paramacxn);
      paramChatMessage.setOnLongClickListener(paramacxn);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView = paramView;
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = localMessageProgressView;
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject1);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView = localImageView;
    }
    paramacun = paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.getLayoutParams();
    if (paramacun == null)
    {
      paramacun = new RelativeLayout.LayoutParams(i, j);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.setLayoutParams(paramacun);
      ((yeu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(paramChatMessage, this);
      paramacxn = paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView;
      paramacun = paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView;
      paramView = paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView;
      if (!localMessageForDevLittleVideo.isSendFromLocal()) {
        break label827;
      }
      if ((localMessageForDevLittleVideo.md5 != null) && (localMessageForDevLittleVideo.md5.length() != 0)) {
        break label630;
      }
      paramView = localMessageForDevLittleVideo.mThumbFilePath;
      if (!bbdj.b(paramView)) {
        break label599;
      }
      if (QLog.isColorLevel()) {
        QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: 占坑");
      }
      a(paramacxn, paramView);
      a(localMessageForDevLittleVideo, paramBaseChatItemLayout, localMessageForDevLittleVideo.videoFileProgress, false);
      ThreadManager.postImmediately(new DevLittleVideoItemBuilder.1(this, localMessageForDevLittleVideo), null, true);
    }
    label599:
    label630:
    do
    {
      do
      {
        do
        {
          return paramChatMessage;
          if ((paramacun.width == i) && (paramacun.height == j)) {
            break;
          }
          paramacun.width = i;
          paramacun.height = j;
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.setLayoutParams(paramacun);
          break;
          paramacxn.a(aywk.a());
          paramacun.setVisibility(4);
        } while (!QLog.isColorLevel());
        QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView:You must get thumb before send video.");
        return paramChatMessage;
        localObject1 = ShortVideoUtils.a(localMessageForDevLittleVideo.thumbMD5, "jpg");
        paramView = localMessageForDevLittleVideo.videoFileName;
        paramacun = paramView;
        if (!bbdj.b(paramView)) {
          paramacun = ShortVideoUtils.a(localMessageForDevLittleVideo, "mp4");
        }
        if (localMessageForDevLittleVideo.videoFileStatus == 1003)
        {
          if ((axey.b) && (ShortVideoUtils.a()) && (bbdj.b(paramacun)))
          {
            if (QLog.isColorLevel()) {
              QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: showVideo(video send finished)");
            }
            a(paramacxn, paramacun, (String)localObject1, localMessageForDevLittleVideo, localMessageForDevLittleVideo.thumbWidth, localMessageForDevLittleVideo.thumbHeight);
            return paramChatMessage;
          }
          if (QLog.isColorLevel()) {
            QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: showThumb(video send finished)");
          }
          a(paramacxn, (String)localObject1);
          return paramChatMessage;
        }
        if (QLog.isColorLevel()) {
          QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: showThumb (video not send finished)");
        }
        a(paramacxn, (String)localObject1);
      } while (localMessageForDevLittleVideo.videoFileStatus != 1002);
      if (QLog.isColorLevel()) {
        QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: showProgress (video sending)");
      }
      a(localMessageForDevLittleVideo, paramBaseChatItemLayout, localMessageForDevLittleVideo.videoFileProgress, false);
      return paramChatMessage;
      paramacun = localMessageForDevLittleVideo.videoFileName;
      paramView = localMessageForDevLittleVideo.mThumbFilePath;
      if (bbdj.b(paramacun))
      {
        if ((axey.b) && (ShortVideoUtils.a()))
        {
          if (QLog.isColorLevel()) {
            QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: showVideo(video recv finished)");
          }
          a(paramacxn, paramacun, paramView, localMessageForDevLittleVideo, localMessageForDevLittleVideo.thumbWidth, localMessageForDevLittleVideo.thumbHeight);
          return paramChatMessage;
        }
        if (bbdj.b(paramView))
        {
          if (QLog.isColorLevel()) {
            QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: showThumb(video recv finished)");
          }
          a(paramacxn, paramView);
          return paramChatMessage;
        }
        c(localMessageForDevLittleVideo);
        return paramChatMessage;
      }
      if (QLog.isColorLevel()) {
        QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: showLoading(video not recv finished)");
      }
      paramacxn.a(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
      if (QLog.isColorLevel()) {
        QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: downloadLittleVideo(video not recv finished)");
      }
      if (!bbev.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext()))
      {
        localMessageForDevLittleVideo.videoFileStatus = 2005;
        localMessageForDevLittleVideo.videoFileProgress = 0;
        localMessageForDevLittleVideo.serial();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForDevLittleVideo.frienduin, localMessageForDevLittleVideo.istroop, localMessageForDevLittleVideo.uniseq, localMessageForDevLittleVideo.msgData);
        return paramChatMessage;
      }
    } while (localMessageForDevLittleVideo.videoFileStatus != 2001);
    label827:
    localMessageForDevLittleVideo.videoFileStatus = 2002;
    localMessageForDevLittleVideo.videoFileProgress = 0;
    localMessageForDevLittleVideo.serial();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForDevLittleVideo.frienduin, localMessageForDevLittleVideo.istroop, localMessageForDevLittleVideo.uniseq, localMessageForDevLittleVideo.msgData);
    a(localMessageForDevLittleVideo, paramBaseChatItemLayout, localMessageForDevLittleVideo.videoFileProgress, false);
    if (!bbdj.b(paramView))
    {
      if (QLog.isColorLevel()) {
        QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: downloadLittleVideoThumb(video not recv finished)");
      }
      c(localMessageForDevLittleVideo);
    }
    b(localMessageForDevLittleVideo);
    return paramChatMessage;
  }
  
  public void a(View paramView)
  {
    paramView = (aeah)actn.a(paramView);
    MessageForDevLittleVideo localMessageForDevLittleVideo = (MessageForDevLittleVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (localMessageForDevLittleVideo.isSendFromLocal())
    {
      localbfol = (bfol)bfoy.a(this.jdField_a_of_type_AndroidContentContext, null);
      localbfol.a(2131689995, 5);
      localbfol.c(2131690596);
      localbfol.a(new ydz(this, localMessageForDevLittleVideo, paramView, localbfol));
      localbfol.show();
      return;
    }
    bfol localbfol = (bfol)bfoy.a(this.jdField_a_of_type_AndroidContentContext, null);
    localbfol.a(2131689997, 5);
    localbfol.c(2131690596);
    localbfol.a(new yea(this, localMessageForDevLittleVideo, paramView, localbfol));
    localbfol.show();
  }
  
  public void a(View paramView, ybw paramybw)
  {
    paramView = (aeah)actn.a(paramView);
    if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq != paramybw.jdField_a_of_type_Long) {}
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
          localMessageForDevLittleVideo = (MessageForDevLittleVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
          if (QLog.isColorLevel()) {
            QLog.d("DevLittleVideoItemBuilder", 2, "updateView msg.uniseq:" + paramybw.jdField_a_of_type_Long + " ===> fileStatus:" + ShortVideoUtils.b(paramybw.jdField_a_of_type_Int));
          }
          localCropBubbleVideoView = paramView.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView;
          i = (int)(paramybw.jdField_a_of_type_Float * 100.0F);
          switch (paramybw.jdField_a_of_type_Int)
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
      } while (!axey.b);
      paramybw = localMessageForDevLittleVideo.videoFileName;
      paramView = paramybw;
      if (!bbdj.b(paramybw)) {
        paramView = ShortVideoUtils.a(localMessageForDevLittleVideo, "mp4");
      }
    } while ((!ShortVideoUtils.a()) || (!bbdj.b(paramView)));
    a(localCropBubbleVideoView, paramView, localMessageForDevLittleVideo.mThumbFilePath, localMessageForDevLittleVideo, localMessageForDevLittleVideo.thumbWidth, localMessageForDevLittleVideo.thumbHeight);
    return;
    if (QLog.isColorLevel()) {
      QLog.i("DevLittleVideoItemBuilder", 2, "VIDEO STATUS_SEND_ERROR");
    }
    paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
    a(paramView);
    b();
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
    paramybw = localMessageForDevLittleVideo.videoFileName;
    String str = localMessageForDevLittleVideo.mThumbFilePath;
    if ((axey.b) && (ShortVideoUtils.a()) && (bbdj.b(paramybw)))
    {
      a(localCropBubbleVideoView, paramybw, str, localMessageForDevLittleVideo, localMessageForDevLittleVideo.thumbWidth, localMessageForDevLittleVideo.thumbHeight);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
    }
    for (;;)
    {
      a(paramView);
      return;
      if (bbdj.b(str))
      {
        a(localCropBubbleVideoView, str);
        paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
      }
      else
      {
        localCropBubbleVideoView.a(aywk.a());
        paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        b();
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
    b();
  }
  
  void a(MessageForDevLittleVideo paramMessageForDevLittleVideo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new DevLittleVideoItemBuilder.5(this, paramMessageForDevLittleVideo));
  }
  
  public boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    paramChatMessage = (MessageForDevLittleVideo)paramChatMessage;
    return (paramChatMessage.videoFileStatus == 1005) || (paramChatMessage.videoFileStatus == 2005);
  }
  
  public bblt[] a(View paramView)
  {
    paramView = new bblr();
    aaod.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    return paramView.a();
  }
  
  void b(MessageForDevLittleVideo paramMessageForDevLittleVideo)
  {
    if (paramMessageForDevLittleVideo.isSendFromLocal()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new DevLittleVideoItemBuilder.6(this, paramMessageForDevLittleVideo));
  }
  
  void c(MessageForDevLittleVideo paramMessageForDevLittleVideo)
  {
    if (paramMessageForDevLittleVideo.isSendFromLocal()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new DevLittleVideoItemBuilder.7(this, paramMessageForDevLittleVideo));
  }
  
  public void onClick(View paramView)
  {
    aeah localaeah = (aeah)actn.a(paramView);
    MessageForDevLittleVideo localMessageForDevLittleVideo = (MessageForDevLittleVideo)localaeah.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (paramView.getId() == 2131364152) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())
    {
      bcpw.a(this.jdField_a_of_type_AndroidContentContext, 2131696181, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
      return;
    }
    if (paramView.getId() == 2131364110)
    {
      String str2 = localMessageForDevLittleVideo.videoFileName;
      paramView = localMessageForDevLittleVideo.mThumbFilePath;
      String str1 = str2;
      if (localMessageForDevLittleVideo.isSendFromLocal())
      {
        String str3 = ShortVideoUtils.a(localMessageForDevLittleVideo.thumbMD5, "jpg");
        paramView = str3;
        str1 = str2;
        if (!bbdj.b(str2))
        {
          str1 = ShortVideoUtils.a(localMessageForDevLittleVideo, "mp4");
          paramView = str3;
        }
      }
      if (!bbdj.b(str1))
      {
        if (QLog.isColorLevel()) {
          QLog.i("DevLittleVideoItemBuilder", 2, "downloadLittleVideo ");
        }
        b(localMessageForDevLittleVideo);
        return;
      }
      if (!bbdj.b(paramView))
      {
        if (QLog.isColorLevel()) {
          QLog.i("DevLittleVideoItemBuilder", 2, "downloadLittleVideoThumb ");
        }
        c(localMessageForDevLittleVideo);
        return;
      }
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800561C", "0X800561C", 0, 0, "", "", "", "");
      a(this.jdField_a_of_type_AndroidContentContext, localMessageForDevLittleVideo, localaeah.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      return;
    }
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ydx
 * JD-Core Version:    0.7.0.1
 */