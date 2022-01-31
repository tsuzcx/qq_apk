import android.view.ViewGroup;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.ListenPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.RecordSoundPanel;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;

public class urc
  implements Runnable
{
  public urc(RecordSoundPanel paramRecordSoundPanel, String paramString, QQRecorder.RecorderParam paramRecorderParam) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelRecordSoundPanel.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam);
    ListenPanel localListenPanel = (ListenPanel)this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelRecordSoundPanel.f.findViewById(2131366435);
    localListenPanel.setVisibility(0);
    localListenPanel.setAudioPath(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelRecordSoundPanel.jdField_a_of_type_Double, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam);
    localListenPanel.setJumpSource(ListenPanel.b);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelRecordSoundPanel.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.setStatus(4);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelRecordSoundPanel.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelRecordSoundPanel.setClickable(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     urc
 * JD-Core Version:    0.7.0.1
 */