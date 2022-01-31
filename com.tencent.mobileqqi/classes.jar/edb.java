import android.content.Context;
import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.PressToSpeakPanel;
import com.tencent.qphone.base.util.BaseApplication;

public class edb
  implements Runnable
{
  public edb(PressToSpeakPanel paramPressToSpeakPanel, int paramInt, double paramDouble) {}
  
  public void run()
  {
    int i = AudioPanel.a(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel.a(i);
    if (PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel) == 1) {
      PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel).setText(BaseApplication.getContext().getResources().getString(2131558880));
    }
    for (;;)
    {
      PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel, this.jdField_a_of_type_Double);
      return;
      if (PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel) == 2) {
        PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel).setText(BaseApplication.getContext().getResources().getString(2131558881));
      } else {
        PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel).setText(AudioPanel.a(this.jdField_a_of_type_Double));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     edb
 * JD-Core Version:    0.7.0.1
 */