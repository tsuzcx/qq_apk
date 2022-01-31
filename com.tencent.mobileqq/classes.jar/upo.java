import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;

public class upo
  implements Runnable
{
  public upo(CommonRecordSoundPanel paramCommonRecordSoundPanel, int paramInt, double paramDouble) {}
  
  public void run()
  {
    int i = AudioPanel.a(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.c(i);
    CommonRecordSoundPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel).setText(AudioPanel.a(this.jdField_a_of_type_Double));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.jdField_a_of_type_Double = this.jdField_a_of_type_Double;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     upo
 * JD-Core Version:    0.7.0.1
 */