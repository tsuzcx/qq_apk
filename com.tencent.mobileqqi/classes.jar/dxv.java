import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Environment;
import android.os.StatFs;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.PressToSpeakPanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class dxv
  implements Runnable
{
  public dxv(PressToSpeakPanel paramPressToSpeakPanel, MotionEvent paramMotionEvent) {}
  
  public void run()
  {
    PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel, true);
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "delay start record runnable is run,touchValid is:" + PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel));
    }
    int j = PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel).d();
    Object localObject = Environment.getExternalStorageDirectory();
    int i;
    if ((((File)localObject).exists()) && (((File)localObject).canWrite()))
    {
      i = 1;
      if ((!Environment.getExternalStorageState().equals("mounted")) || (i == 0)) {
        break label160;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        if (new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() > 1)
        {
          if (PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel).f())
          {
            QQToast.a(BaseApplication.getContext(), BaseApplication.getContext().getResources().getString(2131558882), 0).b(j);
            return;
            i = 0;
            break;
            label160:
            i = 0;
            continue;
          }
          if (PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel).c())
          {
            QQRecorder.a();
            QQToast.a(BaseApplication.getContext(), 2131561724, 0).b(j);
            return;
          }
          PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel).setStatus(2);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel.a(this.jdField_a_of_type_AndroidViewMotionEvent);
          PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel).e(0);
          PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel);
          PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel).setBackgroundResource(2130839752);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel.j();
          localObject = new Rect();
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel.getWindowVisibleDisplayFrame((Rect)localObject);
          PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel, AudioPanel.a(PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel), ((Rect)localObject).right, ((Rect)localObject).bottom, PressToSpeakPanel.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel).getHeight(), this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel, 0, 0, 0));
          PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel, AudioPanel.a(PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel), PressToSpeakPanel.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel)));
          return;
        }
        QQToast.a(BaseApplication.getContext(), 2131562046, 0).b(j);
        return;
      }
    }
    QQToast.a(BaseApplication.getContext(), 2131562824, 0).b(j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dxv
 * JD-Core Version:    0.7.0.1
 */