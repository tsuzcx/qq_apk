import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.PressToChangeVoicePanel;
import com.tencent.mobileqq.activity.aio.audiopanel.PressToSpeakPanel;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ptt.StreamParams;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class uqj
  implements Runnable
{
  public uqj(PressToSpeakPanel paramPressToSpeakPanel, MotionEvent paramMotionEvent) {}
  
  public void run()
  {
    if ((PressToSpeakPanel.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel)) && (PressToSpeakPanel.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel) > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "delay start record runnable is run,but use once enabled and mUsedCount is " + PressToSpeakPanel.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel));
      }
      return;
    }
    PressToSpeakPanel.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel, true);
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "delay start record runnable is run,touchValid is:" + PressToSpeakPanel.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel));
    }
    if (!PressToSpeakPanel.c())
    {
      PressToSpeakPanel.a(true);
      PressToChangeVoicePanel.a(PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel), false, "0X8006385");
    }
    Object localObject = PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel).a();
    if ((PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel).a.a == 0) && (StreamParams.a(PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel))) && (!GoldMsgChatHelper.a(PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel).a)) && (!PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel).G) && (!PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel).a.j)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((QQRecorder.RecorderParam)localObject).a = Boolean.TRUE;
      }
      i = PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel).a().getTitleBarHeight();
      com.tencent.mobileqq.transfile.PttInfoCollector.a = SystemClock.uptimeMillis();
      if (FileUtils.a()) {
        break;
      }
      QQToast.a(BaseApplication.getContext(), 2131433437, 0).b(i);
      return;
    }
    if (!QQRecorder.d())
    {
      QQToast.a(BaseApplication.getContext(), 2131433438, 0).b(i);
      return;
    }
    if (!QQRecorder.a(((QQRecorder.RecorderParam)localObject).c))
    {
      QQToast.a(BaseApplication.getContext(), 2131433441, 0).b(i);
      return;
    }
    if (PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel).j())
    {
      QQToast.a(BaseApplication.getContext(), "请稍后单击", 0).b(i);
      return;
    }
    if (PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel).c())
    {
      QQToast.a(BaseApplication.getContext(), 2131433788, 0).b(i);
      return;
    }
    if (AudioHelper.b(1))
    {
      ChatActivityUtils.a(PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel).a());
      return;
    }
    PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel).setStatus(2);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel.a(this.jdField_a_of_type_AndroidViewMotionEvent);
    PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel).g(0);
    PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel, true, (QQRecorder.RecorderParam)localObject);
    PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel).setBackgroundResource(2130845609);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel.g();
    localObject = new Rect();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel.getWindowVisibleDisplayFrame((Rect)localObject);
    Rect localRect = new Rect();
    PressToSpeakPanel.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel).getGlobalVisibleRect(localRect);
    localRect = new Rect();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel.a.getGlobalVisibleRect(localRect);
    int j = localRect.bottom;
    if (((!Build.MODEL.startsWith("Coolpad")) || (Build.VERSION.SDK_INT != 19)) && ((!Build.MODEL.startsWith("Coolpad A8")) || (Build.VERSION.SDK_INT != 22)) && ((!Build.MODEL.startsWith("Coolpad B770")) || (Build.VERSION.SDK_INT != 22)))
    {
      i = j;
      if (Build.MODEL.startsWith("ivvi"))
      {
        i = j;
        if (Build.VERSION.SDK_INT != 22) {}
      }
    }
    else
    {
      i = j - ((Rect)localObject).top;
    }
    PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel, AudioPanel.a(PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel).a(), ((Rect)localObject).width(), i, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel, 0, 0, 0));
    PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel, AudioPanel.a(PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel).a(), PressToSpeakPanel.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel), this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uqj
 * JD-Core Version:    0.7.0.1
 */