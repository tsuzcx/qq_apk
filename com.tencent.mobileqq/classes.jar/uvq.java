import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.PressToSpeakPanel;

public class uvq
  implements Runnable
{
  public uvq(PressToSpeakPanel paramPressToSpeakPanel, int paramInt, double paramDouble) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel.b())
    {
      int i = AudioPanel.a(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel.b(i);
    }
    if (PressToSpeakPanel.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel) == 1)
    {
      PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel).setText("松手试听");
      return;
    }
    if (PressToSpeakPanel.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel) == 2)
    {
      PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel).setText("松手取消发送");
      return;
    }
    PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel).setText(AudioPanel.a(this.jdField_a_of_type_Double));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uvq
 * JD-Core Version:    0.7.0.1
 */