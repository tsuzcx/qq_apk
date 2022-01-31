import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.device.msg.activities.DevShortVideoItemBuilder.1;
import com.tencent.device.msg.activities.DevShortVideoItemBuilder.2;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.customviews.VideoProgressView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class zsr
  extends afvt
  implements zql
{
  public zsr(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.c = 1;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, aeov paramaeov)
  {
    if (paramChatMessage == null) {
      return null;
    }
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramaeov);
    ((ztk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(paramView, this);
    paramChatMessage = (MessageForShortVideo)paramChatMessage;
    paramViewGroup = (afwd)aekt.a(paramView);
    if (paramChatMessage.videoFileStatus == 1005) {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
    }
    for (;;)
    {
      return paramView;
      if (paramChatMessage.videoFileStatus == 1002)
      {
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        a(paramViewGroup, ShortVideoUtils.a(paramChatMessage.videoFileProgress, 10), false);
      }
      else
      {
        a(paramViewGroup);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
      }
    }
  }
  
  protected void a(afwd paramafwd)
  {
    paramafwd.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(8);
  }
  
  public void a(View paramView)
  {
    paramView = (afwd)aekt.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (localMessageForShortVideo.isSendFromLocal())
    {
      bhpy localbhpy = (bhpy)bhql.a(this.jdField_a_of_type_AndroidContentContext, null);
      localbhpy.a(2131690042, 5);
      localbhpy.c(2131690648);
      localbhpy.a(new zss(this, localMessageForShortVideo, paramView, localbhpy));
      localbhpy.show();
    }
  }
  
  public void a(View paramView, zqm paramzqm)
  {
    paramView = (afwd)aekt.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (localMessageForShortVideo.uniseq != paramzqm.jdField_a_of_type_Long) {}
    int i;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("DeviceShortVideo", 2, "updateView msg.uniseq:" + localMessageForShortVideo.uniseq + " ===> fileStatus:" + ShortVideoUtils.b(paramzqm.jdField_a_of_type_Int));
      }
      i = (int)(100.0F * paramzqm.jdField_a_of_type_Float);
      switch (paramzqm.jdField_a_of_type_Int)
      {
      case 1004: 
      default: 
        return;
      case 1001: 
        a(paramView, ShortVideoUtils.a(i, 10), true);
        paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        return;
      case 1003: 
        a(paramView);
        b();
        return;
      case 1005: 
        b(paramView);
        paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        return;
      }
    } while (!localMessageForShortVideo.isSendFromLocal());
    a(paramView, ShortVideoUtils.a(i, 10), true);
    if (QLog.isColorLevel()) {
      QLog.d("DeviceShortVideo", 2, "handleMessage VIDEO ==> STATUS_SEND_PROCESS, progress=" + i);
    }
    paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
    return;
    b(paramView);
    paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
    return;
    b(paramView);
    b();
    return;
    b(paramView);
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131720128, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
    return;
    b(paramView);
    paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
  }
  
  protected void a(MessageForShortVideo paramMessageForShortVideo)
  {
    if (!bdee.d(BaseApplication.getContext()))
    {
      paramMessageForShortVideo = Looper.getMainLooper();
      if (Thread.currentThread() == paramMessageForShortVideo.getThread())
      {
        armz.a(2131694061);
        return;
      }
      new Handler(paramMessageForShortVideo).post(new DevShortVideoItemBuilder.1(this));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DeviceShortVideo", 2, "startUploadVideo");
    }
    ThreadManager.getFileThreadHandler().post(new DevShortVideoItemBuilder.2(this, paramMessageForShortVideo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     zsr
 * JD-Core Version:    0.7.0.1
 */