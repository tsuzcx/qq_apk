import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.ListenPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.PressToSpeakPanel;

public class ede
  implements Runnable
{
  public ede(PressToSpeakPanel paramPressToSpeakPanel, String paramString) {}
  
  public void run()
  {
    ListenPanel localListenPanel = (ListenPanel)PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel).findViewById(2131232850);
    localListenPanel.setVisibility(0);
    localListenPanel.setAudioPath(this.jdField_a_of_type_JavaLangString, PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel));
    localListenPanel.setJumpSource(ListenPanel.c);
    PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel).setStatus(4);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ede
 * JD-Core Version:    0.7.0.1
 */