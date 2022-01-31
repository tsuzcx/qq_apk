import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.audiopanel.RecordSoundPanel;

public class bug
  implements Runnable
{
  public bug(RecordSoundPanel paramRecordSoundPanel, int paramInt) {}
  
  public void run()
  {
    if (RecordSoundPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelRecordSoundPanel).h())
    {
      RecordSoundPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelRecordSoundPanel).h(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelRecordSoundPanel.onClick(RecordSoundPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelRecordSoundPanel));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bug
 * JD-Core Version:    0.7.0.1
 */