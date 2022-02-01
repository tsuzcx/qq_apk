import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.annotation.NonNull;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.d;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.BasePicItemBuilder.4;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.customviews.PicProgressView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.transfile.chatpic.PicDownloadExplicitError;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.net.URL;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public abstract class xah
  extends xlg
  implements wla.a
{
  public static boolean bgG = true;
  boolean Fb = false;
  protected ajlu b;
  protected final float mDensity;
  boolean mIsPaused = false;
  
  public xah(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    cdE();
    this.mDensity = paramContext.getResources().getDisplayMetrics().density;
    if (this.b == null) {
      this.b = ((ajlu)paramQQAppInterface.getManager(324));
    }
  }
  
  static Intent a(MessageForPic paramMessageForPic, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("forward_type", 1);
    ((Bundle)localObject).putInt("forward_source_uin_type", paramSessionInfo.cZ);
    Intent localIntent = new Intent();
    localIntent.putExtra("forward_image_width", paramMessageForPic.width);
    localIntent.putExtra("forward_image_height", paramMessageForPic.height);
    localIntent.putExtra("forward_file_size", paramMessageForPic.size);
    localIntent.putExtra("forward_image_type", paramMessageForPic.imageType);
    localIntent.putExtra("forward_filepath", paramMessageForPic.path);
    localIntent.putExtra("forward_download_image_task_key", paramMessageForPic.frienduin + paramMessageForPic.uniseq + paramMessageForPic.istroop);
    localIntent.putExtra("forward_download_image_org_uin", paramMessageForPic.frienduin);
    localIntent.putExtra("forward_download_image_org_uin_type", paramMessageForPic.istroop);
    localIntent.putExtra("forward_download_image_server_path", paramMessageForPic.uuid);
    localIntent.putExtra("forward_download_image_item_id", paramMessageForPic.uniseq);
    localIntent.putExtra("forward_photo_isSend", paramMessageForPic.issend);
    localIntent.putExtra("forward_photo_sender_uin", paramMessageForPic.senderuin);
    localIntent.putExtra("forward_photo_md5", paramMessageForPic.md5);
    localIntent.putExtra("forward_photo_group_fileid", paramMessageForPic.groupFileID);
    localIntent.putExtra("FORWARD_PHOTO_FILE_SIZE_FLAG", paramMessageForPic.fileSizeFlag);
    if (paramMessageForPic.picExtraData != null) {
      localIntent.putExtra("forward_photo_imagebiz_type", paramMessageForPic.picExtraData.imageBizType);
    }
    localIntent.putExtras((Bundle)localObject);
    if ((aqfw.mn(paramMessageForPic.msgtype)) || (paramMessageForPic.msgtype == -3001) || (paramMessageForPic.msgtype == -30002) || (paramMessageForPic.msgtype == -30003))
    {
      i = 1;
      if (i != 0) {
        break label614;
      }
    }
    label614:
    for (int i = 65537;; i = 1)
    {
      localObject = aoop.a(paramMessageForPic, i);
      localIntent.putExtra("forward_urldrawable", true);
      localIntent.putExtra("forward_urldrawable_thumb_url", ((URL)localObject).toString());
      localIntent.putExtra("FORWARD_URL_KEY", paramMessageForPic.localUUID);
      paramContext = ForwardUtils.a(paramContext, paramMessageForPic);
      localIntent.putExtra("forward_urldrawable_big_url", paramContext.getURL().toString());
      localIntent.putExtra("uinname", paramSessionInfo.aTn);
      localIntent.putExtra("PhotoConst.MY_UIN", paramQQAppInterface.getAccount());
      localIntent.putExtra("PhotoConst.MY_NICK", paramQQAppInterface.getCurrentNickname());
      localIntent.putExtra("is_anonymous", jof.a().dd(paramSessionInfo.aTl));
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
      localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1009);
      localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
      localIntent.putExtra("key_confess_topicid", paramSessionInfo.topicId);
      localIntent.addFlags(603979776);
      localIntent.putExtra("FORWARD_MSG_FOR_PIC", paramMessageForPic);
      if (!aqhq.fileExistsAndNotEmpty(paramMessageForPic.path)) {
        break label620;
      }
      localIntent.putExtra("forward_extra", paramMessageForPic.path);
      localIntent.putExtra("direct_send_if_dataline_forward", true);
      localIntent.putExtra("forward_source_uin_type", paramSessionInfo.cZ);
      localIntent.putExtra("BUSI_TYPE", 1009);
      return localIntent;
      i = 0;
      break;
    }
    label620:
    paramQQAppInterface = null;
    paramContext = paramContext.getURL().toString();
    if (aoiz.hasFile(paramContext))
    {
      paramContext = aoiz.getFile(paramContext);
      paramMessageForPic = paramQQAppInterface;
      if (paramContext != null) {
        paramMessageForPic = paramContext.getAbsolutePath();
      }
    }
    for (;;)
    {
      localIntent.putExtra("forward_extra", paramMessageForPic);
      break;
      paramContext = aoiz.getFile(aoop.a(paramMessageForPic, 65537).toString());
      paramMessageForPic = paramQQAppInterface;
      if (paramContext != null)
      {
        paramMessageForPic = paramQQAppInterface;
        if (paramContext.exists()) {
          paramMessageForPic = paramContext.getAbsolutePath();
        }
      }
    }
  }
  
  static URLDrawable a(Context paramContext, MessageForPic paramMessageForPic, ChatThumbView paramChatThumbView, int[] paramArrayOfInt, xah.a parama)
  {
    return new akyg.a(paramMessageForPic).a(paramChatThumbView).a(paramArrayOfInt).a(parama).a().f();
  }
  
  private void a(aqoi paramaqoi, xah.b paramb)
  {
    if (paramb.E == null) {
      return;
    }
    if ((paramaqoi instanceof aojn))
    {
      paramaqoi = (aojn)paramaqoi;
      int i = (int)paramaqoi.hh();
      switch (i)
      {
      default: 
        if (paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null)
        {
          paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(paramb.mMessage.frienduin + paramb.mMessage.uniseq);
          if (paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.sd(paramb.mMessage.frienduin + paramb.mMessage.uniseq)) {
            break label680;
          }
          paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.Wt(paramb.mMessage.frienduin + paramb.mMessage.uniseq);
          paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProcessor(null);
          ((RelativeLayout)paramb.E).removeView(paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
          paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
        }
        break;
      }
      for (;;)
      {
        if (i == 1003) {
          paramb.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        }
        paramb.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
        return;
        if ((paramaqoi.azP()) && (!this.Fb))
        {
          paramb.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
          if (paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null)
          {
            paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(paramb.mMessage.frienduin + paramb.mMessage.uniseq);
            paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.Wt(paramb.mMessage.frienduin + paramb.mMessage.uniseq);
            paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProcessor(null);
            ((RelativeLayout)paramb.E).removeView(paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
            paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
          }
          paramb.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
        }
        paramb.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
        if (paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView == null) {
          break;
        }
        paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.pause = true;
        return;
        paramb.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        if (paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView == null)
        {
          PicProgressView localPicProgressView = new PicProgressView(this.mContext);
          localPicProgressView.setRadius(6.0F, true);
          localPicProgressView.setSharpCornerCor(BubbleImageView.DEFAULT_EDGE_CORDS);
          localPicProgressView.setShowCorner(false);
          localPicProgressView.setCustomSize(1);
          localPicProgressView.setProgressBackgroudColor(2130706432);
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.addRule(6, 2131373231);
          localLayoutParams.addRule(8, 2131373231);
          localLayoutParams.addRule(5, 2131373231);
          localLayoutParams.addRule(7, 2131373231);
          ((RelativeLayout)paramb.E).addView(localPicProgressView, localLayoutParams);
          paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = localPicProgressView;
        }
        paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(paramb.mMessage.frienduin + paramb.mMessage.uniseq);
        paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProcessor(paramaqoi);
        paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setVisibility(0);
        if ((paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null) && ((1001 == i) || (1002 == i))) {
          paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.pause = false;
        }
        if (i != 1002)
        {
          paramb.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
          paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(0);
          return;
        }
        paramb.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
        paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.adc();
        paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setShowProgress(true);
        return;
        label680:
        paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(100);
      }
    }
    if (paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null)
    {
      paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(paramb.mMessage.frienduin + paramb.mMessage.uniseq);
      paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.Wt(paramb.mMessage.frienduin + paramb.mMessage.uniseq);
      paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProcessor(null);
      ((RelativeLayout)paramb.E).removeView(paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
      paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
    }
    paramb.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
  }
  
  static void a(QQAppInterface paramQQAppInterface, Context paramContext, View paramView, ChatMessage paramChatMessage, SessionInfo paramSessionInfo, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramView != null) {
      paramBundle.putParcelable("KEY_THUMBNAL_BOUND", sxx.getViewRect(paramView));
    }
    paramBundle.putBoolean("is_one_item", paramBoolean);
    if (paramSessionInfo.cZ == 1)
    {
      paramBundle.putBoolean("extra.CAN_FORWARD_TO_GROUP_ALBUM", true);
      paramBundle.putString("extra.GROUP_UIN", paramSessionInfo.aTl);
      paramBundle.putString("extra.GROUP_CODE", paramSessionInfo.troopUin);
      paramBundle.putBoolean("extra.IS_HOT_CHAT", ajpd.aK(paramChatMessage));
    }
    String str;
    if ((paramSessionInfo.cZ == 1) || (paramSessionInfo.cZ == 3000))
    {
      paramBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 2);
      paramBundle.putInt("extra.MOBILE_QQ_PROCESS_ID", Process.myPid());
      str = paramChatMessage.selfuin;
      paramView = str;
      if (!paramChatMessage.isMultiMsg) {}
    }
    try
    {
      AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
      paramView = str;
      if ((localAppRuntime instanceof QQAppInterface)) {
        paramView = localAppRuntime.getAccount();
      }
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        paramView.printStackTrace();
        paramView = str;
      }
      paramView = (ajlu)paramQQAppInterface.getManager(324);
      paramBoolean = paramView.S(paramChatMessage);
      paramBundle.putBoolean("extra.IS_SAVING_FILE", paramBoolean);
      if (!paramBoolean) {
        break label325;
      }
      paramView = paramView.a(paramView.h(paramChatMessage));
      if ((paramView == null) || (paramView.djL != 1)) {
        break label325;
      }
      paramBundle.putInt("extra.SAVE_FILE_PROGRESS", paramView.progress);
      label325:
      i = ah(paramContext);
      if (!(paramChatMessage instanceof MessageForPic)) {
        break label382;
      }
    }
    paramBundle.putInt("forward_source_uin_type", paramSessionInfo.cZ);
    paramBundle.putString("uin", paramChatMessage.frienduin);
    paramSessionInfo = new AIOImageProviderService(paramView, paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage);
    if ((paramView == null) || (paramChatMessage.frienduin == null)) {
      if (QLog.isColorLevel()) {
        QLog.i("PicItemBuilder", 2, "PicItemBuilder.enterImagePreview() selfUin || pic.frienduin is null");
      }
    }
    for (;;)
    {
      return;
      paramBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 1);
      break;
      int i;
      paramBundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
      avfp.a(paramContext, paramBundle, paramSessionInfo, xtm.a((MessageForPic)paramChatMessage), -1, i);
      while (QLog.isColorLevel())
      {
        QLog.i("PicItemBuilder", 2, "PicItemBuilder.enterImagePreview()");
        return;
        label382:
        if ((paramChatMessage instanceof MessageForTroopFile))
        {
          paramBundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
          avfp.a(paramContext, paramBundle, paramSessionInfo, xtm.a((MessageForTroopFile)paramChatMessage, paramQQAppInterface), -1, i);
        }
      }
    }
  }
  
  private void a(MessageForPic paramMessageForPic, xah.b paramb)
  {
    Object localObject;
    int i;
    if ((this.b != null) && (paramMessageForPic != null) && (paramb != null))
    {
      paramMessageForPic = this.b.a(paramMessageForPic.getPicDownloadInfo());
      localObject = this.b.a(paramMessageForPic);
      if ((localObject != null) && (((ajlq)localObject).djL == 1))
      {
        if (((ajlq)localObject).progress >= 0) {
          break label318;
        }
        i = 0;
      }
    }
    for (;;)
    {
      if ((i < 100) && (!((ajlq)localObject).isCompleted) && (paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView == null) && (((ajlq)localObject).a != null))
      {
        ((ajlq)localObject).a.a(new xai(this, paramb, paramMessageForPic));
        this.b.a(paramMessageForPic, (ajlq)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("PicItemBuilder", 2, "show picSaveProgress");
        }
        paramMessageForPic = new PicProgressView(this.mContext);
        paramMessageForPic.setRadius(6.0F, true);
        paramMessageForPic.setSharpCornerCor(BubbleImageView.DEFAULT_EDGE_CORDS);
        paramMessageForPic.setShowCorner(false);
        paramMessageForPic.setCustomSize(1);
        paramMessageForPic.setProgressBackgroudColor(2130706432);
        localObject = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131373231);
        ((RelativeLayout.LayoutParams)localObject).addRule(8, 2131373231);
        ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131373231);
        ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131373231);
        ((RelativeLayout)paramb.E).addView(paramMessageForPic, (ViewGroup.LayoutParams)localObject);
        paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = paramMessageForPic;
        paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(paramb.mMessage.frienduin + paramb.mMessage.uniseq);
        paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setVisibility(0);
        paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.pause = false;
        paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(i);
        paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setShowProgress(true);
      }
      return;
      label318:
      if (((ajlq)localObject).progress > 100) {
        i = 100;
      } else {
        i = ((ajlq)localObject).progress;
      }
    }
  }
  
  private static int ah(Context paramContext)
  {
    int j = 2;
    int i;
    if (((paramContext instanceof SplashActivity)) || ((paramContext instanceof ChatActivity))) {
      i = 1;
    }
    do
    {
      do
      {
        do
        {
          return i;
          i = j;
        } while ((paramContext instanceof ChatHistoryActivity));
        i = j;
      } while ((paramContext instanceof ChatHistory));
      if (!(paramContext instanceof PublicFragmentActivity)) {
        break;
      }
      i = j;
    } while ((((PublicFragmentActivity)paramContext).b() instanceof ChatHistoryBubbleListForTroopFragment));
    while (!(paramContext instanceof MultiForwardActivity)) {
      return -1;
    }
    return 5;
  }
  
  private void h(MessageForPic paramMessageForPic)
  {
    ThreadManager.post(new BasePicItemBuilder.4(this, paramMessageForPic), 5, null, false);
    if (paramMessageForPic.isSendFromLocal()) {
      this.app.a().oy(this.app.a().y(paramMessageForPic.frienduin, paramMessageForPic.uniseq));
    }
    akxy.a locala = new akxy.a();
    locala.setLocalPath(paramMessageForPic.path);
    locala.So(5);
    locala.NP(paramMessageForPic.frienduin);
    if (paramMessageForPic.fileSizeFlag == 1) {
      locala.setProtocolType(aooh.a.dQD);
    }
    for (;;)
    {
      locala.NT(paramMessageForPic.senderuin);
      locala.kc(paramMessageForPic.selfuin);
      locala.Sp(paramMessageForPic.istroop);
      locala.St(paramMessageForPic.getConfessTopicId());
      locala.extLong = paramMessageForPic.extLong;
      locala.extStr = paramMessageForPic.extStr;
      Object localObject = new akxy.b();
      ((akxy.b)localObject).msgseq = paramMessageForPic.msgseq;
      ((akxy.b)localObject).shmsgseq = paramMessageForPic.shmsgseq;
      ((akxy.b)localObject).msgUid = paramMessageForPic.msgUid;
      locala.a((akxy.b)localObject);
      locala.kx(paramMessageForPic.uniseq);
      ((ambj)this.app.getManager(326)).aG(this.sessionInfo.aTl, paramMessageForPic.uniseq);
      localObject = akxj.a(4, 5);
      ((akxq)localObject).c(locala.a());
      ((akxq)localObject).b = paramMessageForPic.picExtraData;
      akxj.a((akxq)localObject, this.app);
      return;
      locala.setProtocolType(aooh.a.dQC);
    }
  }
  
  private void i(MessageForPic paramMessageForPic)
  {
    Object localObject1 = this.app.a().a(paramMessageForPic.selfuin, paramMessageForPic.uniseq);
    if ((localObject1 != null) && ((localObject1 instanceof aojr)))
    {
      ((aojr)localObject1).start();
      return;
    }
    this.app.b().t(paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic.uniseq);
    if (paramMessageForPic.isSendFromLocal()) {
      this.app.a().oy(this.app.a().y(paramMessageForPic.frienduin, paramMessageForPic.uniseq));
    }
    localObject1 = new akxm();
    Object localObject2 = new akxy.a();
    ((akxy.a)localObject2).So(1009);
    ((akxy.a)localObject2).setLocalPath(paramMessageForPic.path);
    ((akxy.a)localObject2).Sp(paramMessageForPic.istroop);
    ((akxy.a)localObject2).kc(paramMessageForPic.selfuin);
    ((akxy.a)localObject2).NT(paramMessageForPic.senderuin);
    ((akxy.a)localObject2).NP(paramMessageForPic.frienduin);
    ((akxy.a)localObject2).extLong = paramMessageForPic.extLong;
    ((akxy.a)localObject2).extStr = paramMessageForPic.extStr;
    ((akxy.a)localObject2).setProtocolType(aooh.a.dQE);
    ((akxy.a)localObject2).kx(paramMessageForPic.uniseq);
    ((akxm)localObject1).b = ((akxy.a)localObject2).a();
    if ((!aqhq.fileExistsAndNotEmpty(paramMessageForPic.path)) && ((paramMessageForPic.picExtraObject instanceof aomn)))
    {
      localObject2 = (aomn)paramMessageForPic.picExtraObject;
      akxl.a locala = new akxl.a();
      locala.So(1009);
      locala.kc(paramMessageForPic.selfuin);
      locala.NP(((aomn)localObject2).clT);
      locala.Sp(((aomn)localObject2).dPP);
      locala.setUuid(((aomn)localObject2).clU);
      locala.kw(((aomn)localObject2).aqb);
      locala.setMd5(paramMessageForPic.md5);
      locala.Sq(paramMessageForPic.issend);
      ((akxm)localObject1).a = locala.a();
    }
    ((ambj)this.app.getManager(326)).aG(this.sessionInfo.aTl, paramMessageForPic.uniseq);
    paramMessageForPic = akxj.a(3, 1009);
    paramMessageForPic.c((akxm)localObject1);
    akxj.a(paramMessageForPic, this.app);
  }
  
  protected void B(ChatMessage paramChatMessage)
  {
    ((augo)this.app.getManager(374)).B(paramChatMessage);
  }
  
  protected void C(ChatMessage paramChatMessage)
  {
    xaj localxaj = new xaj(this);
    this.app.a().a(paramChatMessage.frienduin, localxaj);
    anot.a(this.app, "CliOper", "", "", "0X800409B", "0X800409B", 0, 0, "", "", "", "");
  }
  
  protected void D(ChatMessage paramChatMessage)
  {
    this.app.a().aZ(paramChatMessage.frienduin, paramChatMessage.uniseq);
    this.app.a().Sd(this.sessionInfo.aTl);
    notifyDataSetChanged();
    anot.a(this.app, "CliOper", "", "", "0X800409A", "0X800409A", 0, 0, "", "", "", "");
  }
  
  protected void E(ChatMessage paramChatMessage)
  {
    ujt.b(this.mContext, this.app, paramChatMessage);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    boolean bool1 = true;
    paramBaseChatItemLayout = (MessageForPic)paramChatMessage;
    boolean bool2 = avfp.ns(paramBaseChatItemLayout.imageType);
    xah.b localb;
    try
    {
      localb = (xah.b)parame;
      if (localb == null) {
        return paramView;
      }
    }
    catch (Exception paramChatMessage)
    {
      QLog.e("PicItemBuilder", 2, "picitem holer Exception e= " + paramChatMessage);
      throw new ClassCastException("picitem holer Exception e= " + paramChatMessage);
    }
    parame = paramView;
    if (paramView == null)
    {
      parame = new RelativeLayout(this.mContext);
      parame.setId(2131373231);
      paramView = new BubbleImageView(this.mContext);
      i = Build.VERSION.SDK_INT;
      if ((i == 19) || (i == 18)) {
        paramView.aAu = true;
      }
      paramView.setId(2131373231);
      paramView.setAdjustViewBounds(true);
      paramView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramView.setRadius(6.0F);
      paramView.TE(false);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(15);
      parame.addView(paramView, localLayoutParams);
      localb.c = paramView;
      paramView = new ImageView(this.mContext);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(7, 2131373231);
      localLayoutParams.addRule(8, 2131373231);
      parame.addView(paramView, localLayoutParams);
      localb.sS = paramView;
      parame.setOnClickListener(this);
      super.a(parame, paramwlz);
    }
    paramView = localb.c;
    int i = aoop.G(bool2);
    int j = aoop.H(bool2);
    paramView.setMaxWidth(i);
    paramView.setMaxHeight(i);
    paramView.setMinimumWidth(j);
    paramView.setMinimumHeight(j);
    if ((!xkl.a(paramBaseChatItemLayout)) && (!bool2))
    {
      paramView.setShowEdge(bool1);
      if (aTl) {
        paramView.setContentDescription(acfp.m(2131709631));
      }
      if (paramBaseChatItemLayout.isSendFromLocal()) {
        break label454;
      }
      b(paramBaseChatItemLayout, localb, parame, bool2);
      label381:
      if (QLog.isColorLevel()) {
        if ("getview " + localb.jdField_a_of_type_Xah$a == null) {
          break label468;
        }
      }
    }
    label454:
    label468:
    for (paramView = localb.jdField_a_of_type_Xah$a.toString();; paramView = "isDynamic=" + bool2 + "thumbWidth=" + paramBaseChatItemLayout.thumbWidth + "thumbHeight=" + paramBaseChatItemLayout.thumbHeight)
    {
      QLog.d("PicItemBuilder", 2, paramView);
      a(paramChatMessage, parame, this);
      a(paramBaseChatItemLayout, localb);
      return parame;
      bool1 = false;
      break;
      a(paramBaseChatItemLayout, localb, parame, bool2);
      break label381;
    }
  }
  
  public aqoa a(aqoa paramaqoa, ChatMessage paramChatMessage, wko.a parama)
  {
    paramChatMessage = (MessageForPic)paramChatMessage;
    parama = (xah.b)parama;
    int i = parama.a(paramChatMessage);
    parama.getClass();
    if (i != 1)
    {
      parama.getClass();
      if (i != 2)
      {
        parama.getClass();
        if (i != 4)
        {
          parama.getClass();
          if (i != 5) {
            return paramaqoa;
          }
        }
      }
    }
    b(paramaqoa);
    a(paramaqoa, paramChatMessage);
    c(paramaqoa);
    return paramaqoa;
  }
  
  public BaseBubbleBuilder.d a(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      paramView = (xah.b)((View)paramView.getParent()).getTag();
      if (paramView != null) {
        return paramView.c;
      }
    }
    return null;
  }
  
  public BaseBubbleBuilder.e a()
  {
    return new xah.b();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    MessageForPic localMessageForPic;
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForPic)))
    {
      localMessageForPic = (MessageForPic)paramChatMessage;
      if (paramInt == 2131367523) {
        f(localMessageForPic);
      }
    }
    else
    {
      return;
    }
    if (paramInt == 2131362240)
    {
      e(localMessageForPic);
      return;
    }
    if (paramInt == 2131365686)
    {
      E(paramChatMessage);
      return;
    }
    if (paramInt == 2131372073)
    {
      d(localMessageForPic);
      return;
    }
    if (paramInt == 2131377234)
    {
      g(localMessageForPic);
      return;
    }
    if (paramInt == 2131366733)
    {
      c(localMessageForPic);
      return;
    }
    if (paramInt == 2131364237)
    {
      D(paramChatMessage);
      return;
    }
    if (paramInt == 2131364225)
    {
      C(paramChatMessage);
      return;
    }
    if (paramInt == 2131372062)
    {
      super.m(paramChatMessage);
      return;
    }
    if (paramInt == 2131372030)
    {
      super.j(paramChatMessage);
      return;
    }
    if (paramInt == 2131377998)
    {
      B(paramChatMessage);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  public void a(View paramView, aoko paramaoko, int paramInt1, int paramInt2)
  {
    xah.b localb = (xah.b)wja.a(paramView);
    if (localb == null) {
      QLog.e("PicItemBuilder", 2, "handleMessage(): holder is null");
    }
    do
    {
      do
      {
        do
        {
          return;
          try
          {
            paramView = (MessageForPic)localb.mMessage;
            if ((localb.mMessage == null) || (paramView == null))
            {
              QLog.e("PicItemBuilder", 2, "handleMessage(): holder.mMessage is null");
              return;
            }
          }
          catch (ClassCastException paramView)
          {
            for (;;)
            {
              QLog.e("PicItemBuilder", 2, "handleMessage(): cast exception", paramView);
              paramView = null;
            }
            if ((paramInt1 == 2003) && (paramaoko.fileType == 65537))
            {
              boolean bool = avfp.ns(paramView.imageType);
              int i = localb.c.getWidth();
              int j = localb.c.getHeight();
              localb.u.getURL().getProtocol();
              URL localURL = aoop.a(paramView, 65537);
              a(localb, bool, new int[] { i, j }, localURL);
            }
          }
        } while (((paramaoko.fileType != 1) && (paramaoko.fileType != 131075)) || (paramInt1 == 2002) || (paramInt1 == 2001) || (paramView.uniseq != paramaoko.uniseq));
        aonc.a(paramView.istroop, paramView.isSendFromLocal(), 65537, String.valueOf(paramView.uniseq), "PicItemBuilder.transf.in", "status:" + paramInt1 + ",retCode" + paramInt2 + "message.uniseq：" + paramView.uniseq + ",file.uniseq:" + paramaoko.uniseq, null);
        if (paramView.isSendFromLocal())
        {
          a(this.app.a().a(paramView.frienduin, paramView.uniseq), localb);
          if (paramInt1 == 1005) {
            notifyDataSetChanged();
          }
        }
      } while (paramInt1 != 2003);
      b(paramView, localb);
      paramView = xkl.b(this.mContext, (MessageForPic)localb.mMessage, localb.c);
      localb.c.setImageDrawable(paramView);
      localb.u = paramView;
    } while (localb.u == null);
    localb.u.setWatermarkVisibility(4);
  }
  
  void a(aqoa paramaqoa, MessageForPic paramMessageForPic)
  {
    if (aoop.a(this.mContext, paramMessageForPic, 65537)) {
      paramaqoa.Z(2131367523, this.mContext.getString(2131721067), 2130839086);
    }
  }
  
  void a(MessageForPic paramMessageForPic, URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable.getStatus() == 1) && ((paramURLDrawable.getCurrDrawable() instanceof GifDrawable))) {
      this.app.a().b(paramMessageForPic, 2);
    }
  }
  
  protected void a(MessageForPic paramMessageForPic, xah.b paramb, View paramView, boolean paramBoolean)
  {
    if (paramb.u != null) {
      paramb.u.setWatermarkVisibility(4);
    }
    xah.a locala = new xah.a(paramMessageForPic);
    URL localURL = locala.url;
    if ((paramb.u == null) || (!paramb.u.getURL().equals(localURL)))
    {
      URLDrawable localURLDrawable = a(this.mContext, paramMessageForPic, paramb.c, null, locala);
      paramb.c.setImageDrawable(localURLDrawable);
      paramb.u = localURLDrawable;
      paramb.jdField_a_of_type_Xah$a = locala;
      if (paramBoolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PicItemBuilder", 2, "predownloadDynamic pic uniseq=" + paramMessageForPic.uniseq + " url=" + localURL);
        }
        a(paramMessageForPic, paramb.u);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PicItemBuilder", 2, "show send pic uniseq=" + paramMessageForPic.uniseq + " url=" + localURL);
      }
    }
    paramMessageForPic = this.app.a().a(paramMessageForPic.frienduin, paramMessageForPic.uniseq);
    paramb.E = paramView;
    a(paramMessageForPic, paramb);
    if (paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null) {
      paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.pause = true;
    }
  }
  
  void a(xah.b paramb, boolean paramBoolean, int[] paramArrayOfInt, URL paramURL) {}
  
  public boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    boolean bool = true;
    if (paramChatMessage.isMultiMsg) {}
    while (!paramChatMessage.isSendFromLocal()) {
      return false;
    }
    paramChatMessage = (MessageForPic)paramChatMessage;
    if (paramChatMessage.size <= 0L)
    {
      paramChatMessage = this.app.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
      if ((paramChatMessage instanceof aojn))
      {
        long l = ((aojn)paramChatMessage).hh();
        if ((l == 1005L) || ((l == 1006L) && (!this.Fb)) || (l == 1004L)) {}
        for (bool = true;; bool = false) {
          return bool;
        }
      }
      return true;
    }
    if (paramChatMessage.extraflag == 32768) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public aqob[] a(View paramView)
  {
    paramView = (xah.b)wja.a(paramView);
    MessageForPic localMessageForPic = (MessageForPic)paramView.mMessage;
    aqoa localaqoa = new aqoa();
    if (localMessageForPic != null)
    {
      if (!localMessageForPic.isMultiMsg) {
        break label48;
      }
      a(localaqoa, localMessageForPic, paramView);
    }
    for (;;)
    {
      return localaqoa.a();
      label48:
      b(localaqoa, localMessageForPic, paramView);
      super.a(localaqoa, this.mContext, localMessageForPic, true);
    }
  }
  
  public aqoa b(aqoa paramaqoa, ChatMessage paramChatMessage, wko.a parama)
  {
    MessageForPic localMessageForPic = (MessageForPic)paramChatMessage;
    parama = (xah.b)parama;
    this.Fb = true;
    int i = parama.a(localMessageForPic);
    parama.getClass();
    if (i == 1)
    {
      b(paramaqoa);
      a(paramaqoa, localMessageForPic);
      a(localMessageForPic, paramaqoa);
      a(paramaqoa, this.sessionInfo.cZ, localMessageForPic);
      a(paramaqoa, localMessageForPic);
      c(paramaqoa);
      b(paramChatMessage, paramaqoa);
      c(paramaqoa, this.mContext);
    }
    for (;;)
    {
      e(paramaqoa, this.mContext);
      return paramaqoa;
      parama.getClass();
      if (i == 2)
      {
        b(paramaqoa);
        a(paramaqoa, localMessageForPic);
        a(localMessageForPic, paramaqoa);
        a(paramaqoa, this.sessionInfo.cZ, localMessageForPic);
        a(paramaqoa, localMessageForPic);
        c(paramaqoa);
        b(paramChatMessage, paramaqoa);
        c(paramaqoa, this.mContext);
      }
      else
      {
        parama.getClass();
        if (i != 4)
        {
          parama.getClass();
          if (i != 5) {}
        }
        else
        {
          b(paramaqoa);
          a(paramaqoa, localMessageForPic);
          c(paramaqoa);
          a(paramaqoa, localMessageForPic);
          c(paramaqoa, this.mContext);
          continue;
        }
        parama.getClass();
        if (i == 3)
        {
          paramaqoa.Z(2131364237, this.mContext.getString(2131691403), 2130839075);
          if (this.app.a().qm(this.sessionInfo.aTl)) {
            paramaqoa.Z(2131364225, this.mContext.getString(2131691402), 2130839074);
          }
          this.mIsPaused = this.app.a().ql(this.sessionInfo.aTl);
        }
      }
    }
  }
  
  public String b(ChatMessage paramChatMessage)
  {
    if (aqiu.ms(paramChatMessage.issend)) {
      return acfp.m(2131709632);
    }
    return acfp.m(2131709633);
  }
  
  void b(aqoa paramaqoa)
  {
    if (wja.eU(1) == 1) {
      paramaqoa.Z(2131362240, this.mContext.getString(2131694742), 2130839084);
    }
  }
  
  abstract void b(MessageForPic paramMessageForPic, xah.b paramb);
  
  protected void b(MessageForPic paramMessageForPic, xah.b paramb, View paramView, boolean paramBoolean)
  {
    if ((paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null) && (!this.b.S(paramMessageForPic)))
    {
      paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setVisibility(8);
      paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(paramMessageForPic.frienduin + paramMessageForPic.uniseq);
      paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.Wt(paramMessageForPic.frienduin + paramMessageForPic.uniseq);
      paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProcessor(null);
      ((RelativeLayout)paramb.E).removeView(paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
      paramb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
    }
    Object localObject = new xah.a(paramMessageForPic);
    URL localURL = ((xah.a)localObject).url;
    int[] arrayOfInt = new int[2];
    int[] tmp140_138 = arrayOfInt;
    tmp140_138[0] = 0;
    int[] tmp144_140 = tmp140_138;
    tmp144_140[1] = 0;
    tmp144_140;
    if ((paramb.u == null) || (!paramb.u.getURL().equals(localURL)))
    {
      if (paramb.u != null) {
        QLog.d("PicItemBuilder", 2, "holder.d=" + paramb.u.getURL() + "==url=" + localURL);
      }
      URLDrawable localURLDrawable = a(this.mContext, paramMessageForPic, paramb.c, arrayOfInt, (xah.a)localObject);
      paramb.c.setImageDrawable(localURLDrawable);
      paramb.u = localURLDrawable;
      paramb.jdField_a_of_type_Xah$a = ((xah.a)localObject);
      this.app.a().a(paramMessageForPic, 2);
      localObject = localURLDrawable;
      if (QLog.isColorLevel())
      {
        QLog.d("PicItemBuilder", 2, "show receive pic uniseq=" + paramMessageForPic.uniseq + " url=" + localURL);
        localObject = localURLDrawable;
      }
    }
    for (;;)
    {
      if (localObject == null) {
        QLog.d("PicItemBuilder", 2, "d==null");
      }
      a(paramb, paramBoolean, arrayOfInt, localURL);
      paramb.E = paramView;
      return;
      localObject = paramb.u;
      arrayOfInt[0] = paramb.c.getWidth();
      arrayOfInt[1] = paramb.c.getHeight();
    }
  }
  
  public void bYO()
  {
    super.bYO();
    if (this.mIsPaused)
    {
      this.app.a().Sd(this.sessionInfo.aTl);
      this.mIsPaused = false;
    }
    this.Fb = false;
  }
  
  void c(aqoa paramaqoa)
  {
    if (wja.eU(5) == 1) {
      paramaqoa.Z(2131366733, this.mContext.getString(2131693407), 2130839085);
    }
  }
  
  public void c(aqoa paramaqoa, Context paramContext)
  {
    super.c(paramaqoa, paramContext);
  }
  
  protected void c(MessageForPic paramMessageForPic)
  {
    aviz.a(paramMessageForPic).b(this.app, paramMessageForPic).b((Activity)this.mContext, this.app.getAccount());
    avjg.a(this.app, 6, 3);
    avjg.a(this.app, 2, 0, paramMessageForPic.istroop);
  }
  
  protected abstract void c(MessageForPic paramMessageForPic, xah.b paramb);
  
  public void cdE() {}
  
  protected void d(MessageForPic paramMessageForPic)
  {
    super.m(paramMessageForPic);
  }
  
  public void e(aqoa paramaqoa, Context paramContext)
  {
    super.e(paramaqoa, paramContext);
  }
  
  protected void e(MessageForPic paramMessageForPic)
  {
    URLDrawable localURLDrawable = aoop.getDrawable(aoop.a(paramMessageForPic, 1), -1, -1, null, null, false);
    localURLDrawable.setTag(paramMessageForPic);
    xtm.a(this.mContext, this.app, localURLDrawable, paramMessageForPic.frienduin, this.mContext.getResources().getDimensionPixelSize(2131299627), null, paramMessageForPic.picExtraData);
  }
  
  public void ei(View paramView)
  {
    super.ei(paramView);
    if (wja.a(paramView).isMultiMsg) {}
    do
    {
      return;
      paramView = (MessageForPic)((xah.b)wja.a(paramView)).mMessage;
    } while (!paramView.isSendFromLocal());
    ausj localausj = (ausj)auss.a(this.mContext, null);
    localausj.addButton(2131690230, 5);
    localausj.addCancelButton(2131721058);
    localausj.a(new xak(this, paramView, localausj));
    localausj.show();
  }
  
  protected abstract void f(MessageForPic paramMessageForPic);
  
  protected void fj(View paramView)
  {
    Object localObject = (xah.b)wja.a(paramView);
    MessageForPic localMessageForPic = (MessageForPic)((xah.b)localObject).mMessage;
    paramView = ((xah.b)localObject).u;
    if (!localMessageForPic.isSendFromLocal())
    {
      switch (paramView.getStatus())
      {
      default: 
      case 2: 
      case 0: 
        do
        {
          do
          {
            return;
            if ((aqft.cC()) && (aqft.hE() < 20971520L))
            {
              QQToast.a(this.mContext, acfp.m(2131709630), 0).show();
              return;
            }
            localObject = PicDownloadExplicitError.getFailedTip(paramView);
            if (localObject != null)
            {
              QQToast.a(this.mContext, (CharSequence)localObject, 0).show();
              return;
            }
          } while (!aqhq.bP(this.mContext));
          paramView.restartDownload();
          return;
        } while (paramView.isDownloadStarted());
        paramView.startDownload();
        return;
      }
      c(localMessageForPic, (xah.b)localObject);
      return;
    }
    if (paramView.getStatus() == 2)
    {
      if ((aqft.cC()) && (aqft.hE() < 20971520L))
      {
        QQToast.a(this.mContext, acfp.m(2131709634), 0).show();
        return;
      }
      String str = PicDownloadExplicitError.getFailedTip(paramView);
      if (str != null)
      {
        QQToast.a(this.mContext, str, 0).show();
        return;
      }
      if (aqhq.bP(this.mContext)) {
        paramView.restartDownload();
      }
    }
    c(localMessageForPic, (xah.b)localObject);
  }
  
  void g(MessageForPic paramMessageForPic)
  {
    String str = aopa.b(paramMessageForPic);
    if (str != null) {
      QQToast.a(this.mContext, str, 0).show();
    }
    do
    {
      return;
      if (aqhq.fileExistsAndNotEmpty(paramMessageForPic.path))
      {
        h(paramMessageForPic);
        return;
      }
    } while (paramMessageForPic.picExtraFlag != aooh.a.dQE);
    i(paramMessageForPic);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131364503) {
      fj(paramView);
    }
    super.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public static class a
  {
    public boolean bgH;
    public boolean isShowGif;
    public URL url;
    
    public a(MessageForPic paramMessageForPic)
    {
      paramMessageForPic.checkType();
      if (((paramMessageForPic.imageType == 3) || (paramMessageForPic.imageType == 2000)) && (xah.bgG))
      {
        this.bgH = true;
        URL localURL = aoop.a(paramMessageForPic, 1, null);
        if (aoiz.getFile(localURL.toString()) != null)
        {
          this.url = localURL;
          this.isShowGif = true;
          if (QLog.isColorLevel()) {
            QLog.d("PicItemBuilder", 2, "getThumbDrawable,using GIF_BIG,uniseq:" + paramMessageForPic.uniseq + " url:" + this.url);
          }
        }
      }
      if (this.url == null)
      {
        this.url = aoop.a(paramMessageForPic, 65537, null);
        if (QLog.isColorLevel()) {
          QLog.d("PicItemBuilder", 2, "getThumbDrawable,using thumb,uniseq:" + paramMessageForPic.uniseq + " url:" + this.url);
        }
      }
    }
    
    @NonNull
    public String toString()
    {
      if (this.url != null) {
        return this.url.toString();
      }
      return super.toString();
    }
  }
  
  public class b
    extends BaseBubbleBuilder.e
  {
    public PicProgressView a;
    public xah.a a;
    final int bSE = 0;
    final int bSF = 1;
    final int bSG = 2;
    final int bSH = 3;
    final int bSI = 4;
    final int bSJ = 5;
    public BubbleImageView c;
    public ImageView sS;
    public URLDrawable u;
    
    public b() {}
    
    public boolean Sw()
    {
      if (this.a != null) {
        return this.a.isShowGif;
      }
      return false;
    }
    
    int a(MessageForPic paramMessageForPic)
    {
      if (!paramMessageForPic.isSendFromLocal())
      {
        if ((this.u != null) && (this.u.getStatus() == 1)) {
          return 1;
        }
      }
      else
      {
        if (paramMessageForPic.size > 0L) {
          return 2;
        }
        paramMessageForPic = xah.this.app.a().a(paramMessageForPic.frienduin, paramMessageForPic.uniseq);
        if ((paramMessageForPic instanceof aojn))
        {
          paramMessageForPic = (aojn)paramMessageForPic;
          long l = paramMessageForPic.hh();
          if ((l == 1005L) || (l == 1006L) || (l == 1004L) || (paramMessageForPic.hi() == 1003L)) {
            return 4;
          }
          return 3;
        }
        return 5;
      }
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xah
 * JD-Core Version:    0.7.0.1
 */