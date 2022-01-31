import android.graphics.Rect;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.PressToChangeVoicePanel;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class btz
  implements Runnable
{
  public btz(PressToChangeVoicePanel paramPressToChangeVoicePanel) {}
  
  public void run()
  {
    PressToChangeVoicePanel.a(this.a, true);
    boolean bool = this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.i();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "isRecording is:" + bool);
    }
    if (bool)
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.h())
      {
        this.a.setClickable(false);
        this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.e(2);
      }
      return;
    }
    int i = this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getTitleBarHeight();
    Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
    if (!FileUtils.a()) {
      QQToast.a(BaseApplication.getContext(), 2131363016, 0).b(i);
    }
    for (;;)
    {
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005472", "0X8005472", 0, 0, "", "", "", "");
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel == null) {
        break;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.a(this.a);
      return;
      if (!QQRecorder.c())
      {
        QQToast.a(BaseApplication.getContext(), 2131363017, 0).b(i);
      }
      else if (!QQRecorder.a(((QQRecorder.RecorderParam)localObject).c))
      {
        QQToast.a(BaseApplication.getContext(), 2131363018, 0).b(i);
      }
      else if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d())
      {
        QQToast.a(BaseApplication.getContext(), 2131363150, 0).a();
      }
      else if (AudioHelper.a(1))
      {
        ChatActivityUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
      }
      else
      {
        this.a.f();
        this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(this.a, false, (QQRecorder.RecorderParam)localObject);
        this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.f(2);
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.setStatus(3);
        this.a.h();
        localObject = new Rect();
        this.a.getWindowVisibleDisplayFrame((Rect)localObject);
        this.a.jdField_a_of_type_AndroidWidgetPopupWindow = AudioPanel.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), ((Rect)localObject).right, ((Rect)localObject).bottom, this.a.b.getHeight(), this.a, 0, 0, 0);
        this.a.jdField_a_of_type_AndroidViewView = AudioPanel.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.a.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     btz
 * JD-Core Version:    0.7.0.1
 */