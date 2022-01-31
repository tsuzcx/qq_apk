import android.view.ViewGroup;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.ListenPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.PressToSpeakPanel;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;

public class une
  implements Runnable
{
  public une(PressToSpeakPanel paramPressToSpeakPanel, String paramString, QQRecorder.RecorderParam paramRecorderParam) {}
  
  public void run()
  {
    PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam);
    ListenPanel localListenPanel = (ListenPanel)PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel).findViewById(2131366408);
    localListenPanel.setVisibility(0);
    localListenPanel.setAudioPath(this.jdField_a_of_type_JavaLangString, PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel), this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam);
    localListenPanel.setJumpSource(ListenPanel.a);
    PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel).setStatus(4);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     une
 * JD-Core Version:    0.7.0.1
 */