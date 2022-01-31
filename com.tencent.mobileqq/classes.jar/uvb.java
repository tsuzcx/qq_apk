import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
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

public class uvb
  implements Runnable
{
  public uvb(PressToChangeVoicePanel paramPressToChangeVoicePanel) {}
  
  public void run()
  {
    PressToChangeVoicePanel.a(this.a, true);
    boolean bool = this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.j();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "isRecording is:" + bool);
    }
    if (bool)
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.i())
      {
        this.a.setClickable(false);
        this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.f(2);
      }
      return;
    }
    PressToChangeVoicePanel.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, "0X8006386");
    if (PressToChangeVoicePanel.jdField_a_of_type_JavaLangString == null)
    {
      QQToast.a(BaseApplication.getContext(), 2131438033, 0).a();
      return;
    }
    com.tencent.mobileqq.transfile.PttInfoCollector.a = SystemClock.uptimeMillis();
    int i = this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getTitleBarHeight();
    Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
    if (!FileUtils.a())
    {
      QQToast.a(BaseApplication.getContext(), 2131433451, 0).b(i);
      label173:
      if (!this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d) {
        break label625;
      }
    }
    label625:
    for (i = 1;; i = 2)
    {
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005472", "0X8005472", i, 0, "", "", "", "7.6.8");
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel == null) {
        break;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.a(this.a);
      return;
      if (!QQRecorder.d())
      {
        QQToast.a(BaseApplication.getContext(), 2131433452, 0).b(i);
        break label173;
      }
      if (!QQRecorder.a(((QQRecorder.RecorderParam)localObject).c))
      {
        QQToast.a(BaseApplication.getContext(), 2131433455, 0).b(i);
        break label173;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())
      {
        QQToast.a(BaseApplication.getContext(), 2131433804, 0).a();
        break label173;
      }
      if (AudioHelper.b(1))
      {
        ChatActivityUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
        break label173;
      }
      this.a.f();
      this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(this.a, false, (QQRecorder.RecorderParam)localObject);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.g(2);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.setStatus(3);
      this.a.h();
      localObject = new Rect();
      Rect localRect = new Rect();
      this.a.b.getGlobalVisibleRect(localRect);
      this.a.getWindowVisibleDisplayFrame((Rect)localObject);
      localRect = new Rect();
      this.a.c.getGlobalVisibleRect(localRect);
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
      this.a.jdField_a_of_type_AndroidWidgetPopupWindow = AudioPanel.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), ((Rect)localObject).width(), i, this.a, 0, 0, 0);
      this.a.jdField_a_of_type_AndroidViewView = AudioPanel.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.a.b, this.a.c);
      break label173;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uvb
 * JD-Core Version:    0.7.0.1
 */