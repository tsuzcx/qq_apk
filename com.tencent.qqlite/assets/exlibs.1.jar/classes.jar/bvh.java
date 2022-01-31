import android.view.ViewGroup;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.ListenPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.RecordSoundPanel;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;

public class bvh
  implements Runnable
{
  public bvh(RecordSoundPanel paramRecordSoundPanel, String paramString, QQRecorder.RecorderParam paramRecorderParam) {}
  
  public void run()
  {
    RecordSoundPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelRecordSoundPanel).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam);
    ListenPanel localListenPanel = (ListenPanel)RecordSoundPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelRecordSoundPanel).findViewById(2131298126);
    localListenPanel.setVisibility(0);
    localListenPanel.setAudioPath(this.jdField_a_of_type_JavaLangString, RecordSoundPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelRecordSoundPanel), this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam);
    localListenPanel.setJumpSource(ListenPanel.d);
    RecordSoundPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelRecordSoundPanel).setStatus(4);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelRecordSoundPanel.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelRecordSoundPanel.setClickable(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bvh
 * JD-Core Version:    0.7.0.1
 */