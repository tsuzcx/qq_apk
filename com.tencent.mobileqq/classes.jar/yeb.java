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
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class yeb
  extends adzh
  implements ybv
{
  public yeb(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.c = 1;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, acxn paramacxn)
  {
    if (paramChatMessage == null) {
      return null;
    }
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramacxn);
    ((yeu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(paramView, this);
    paramChatMessage = (MessageForShortVideo)paramChatMessage;
    paramViewGroup = (adzr)actn.a(paramView);
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
  
  protected void a(adzr paramadzr)
  {
    paramadzr.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(8);
  }
  
  public void a(View paramView)
  {
    paramView = (adzr)actn.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (localMessageForShortVideo.isSendFromLocal())
    {
      bfol localbfol = (bfol)bfoy.a(this.jdField_a_of_type_AndroidContentContext, null);
      localbfol.a(2131689995, 5);
      localbfol.c(2131690596);
      localbfol.a(new yec(this, localMessageForShortVideo, paramView, localbfol));
      localbfol.show();
    }
  }
  
  public void a(View paramView, ybw paramybw)
  {
    paramView = (adzr)actn.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (localMessageForShortVideo.uniseq != paramybw.jdField_a_of_type_Long) {}
    int i;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("DeviceShortVideo", 2, "updateView msg.uniseq:" + localMessageForShortVideo.uniseq + " ===> fileStatus:" + ShortVideoUtils.b(paramybw.jdField_a_of_type_Int));
      }
      i = (int)(100.0F * paramybw.jdField_a_of_type_Float);
      switch (paramybw.jdField_a_of_type_Int)
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
    bcpw.a(this.jdField_a_of_type_AndroidContentContext, 2131719585, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
    return;
    b(paramView);
    paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
  }
  
  protected void a(MessageForShortVideo paramMessageForShortVideo)
  {
    if (!bbev.d(BaseApplication.getContext()))
    {
      paramMessageForShortVideo = Looper.getMainLooper();
      if (Thread.currentThread() == paramMessageForShortVideo.getThread())
      {
        aptv.a(2131693944);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     yeb
 * JD-Core Version:    0.7.0.1
 */