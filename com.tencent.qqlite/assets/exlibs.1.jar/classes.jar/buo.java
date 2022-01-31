import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.PressToSpeakPanel;
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

public class buo
  implements Runnable
{
  public buo(PressToSpeakPanel paramPressToSpeakPanel, MotionEvent paramMotionEvent) {}
  
  public void run()
  {
    PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel, true);
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "delay start record runnable is run,touchValid is:" + PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel));
    }
    Object localObject = PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel).a();
    if ((PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel).a.a == 0) && (StreamParams.a(PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel)))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((QQRecorder.RecorderParam)localObject).a = Boolean.TRUE;
      }
      i = PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel).a().getTitleBarHeight();
      if (FileUtils.a()) {
        break;
      }
      QQToast.a(BaseApplication.getContext(), 2131363016, 0).b(i);
      return;
    }
    if (!QQRecorder.c())
    {
      QQToast.a(BaseApplication.getContext(), 2131363017, 0).b(i);
      return;
    }
    if (!QQRecorder.a(((QQRecorder.RecorderParam)localObject).c))
    {
      QQToast.a(BaseApplication.getContext(), 2131363018, 0).b(i);
      return;
    }
    if (PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel).i())
    {
      QQToast.a(BaseApplication.getContext(), "请稍后单击", 0).b(i);
      return;
    }
    if (PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel).d())
    {
      QQToast.a(BaseApplication.getContext(), 2131363150, 0).b(i);
      return;
    }
    if (AudioHelper.a(1))
    {
      ChatActivityUtils.a(PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel).a());
      return;
    }
    PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel).setStatus(2);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel.a(this.jdField_a_of_type_AndroidViewMotionEvent);
    PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel).f(0);
    PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel, true, (QQRecorder.RecorderParam)localObject);
    PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel).setBackgroundResource(2130839201);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel.g();
    localObject = new Rect();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel.getWindowVisibleDisplayFrame((Rect)localObject);
    PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel, AudioPanel.a(PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel).a(), ((Rect)localObject).right, ((Rect)localObject).bottom, PressToSpeakPanel.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel).getHeight(), this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel, 0, 0, 0));
    PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel, AudioPanel.a(PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel).a(), PressToSpeakPanel.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     buo
 * JD-Core Version:    0.7.0.1
 */