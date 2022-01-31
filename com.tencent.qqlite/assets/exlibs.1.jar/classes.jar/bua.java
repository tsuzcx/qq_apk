import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.PressToChangeVoicePanel;

public class bua
  implements Runnable
{
  public bua(PressToChangeVoicePanel paramPressToChangeVoicePanel, int paramInt, double paramDouble) {}
  
  public void run()
  {
    int i = AudioPanel.a(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToChangeVoicePanel.b(i);
    PressToChangeVoicePanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToChangeVoicePanel).setText(AudioPanel.a(this.jdField_a_of_type_Double));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bua
 * JD-Core Version:    0.7.0.1
 */