import com.tencent.mobileqq.structmsg.view.StructMsgItemTimer;
import com.tencent.mobileqq.structmsg.widget.CountdownTextView;
import com.tencent.mobileqq.structmsg.widget.CountdownTextView.TimerCallback;

public class gpk
  implements CountdownTextView.TimerCallback
{
  public gpk(StructMsgItemTimer paramStructMsgItemTimer, CountdownTextView paramCountdownTextView) {}
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemTimer.jdField_c_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemTimer.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqStructmsgWidgetCountdownTextView.setText(StructMsgItemTimer.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemTimer, 0L));
  }
  
  public void a(long paramLong)
  {
    paramLong /= 1000L;
    this.jdField_a_of_type_ComTencentMobileqqStructmsgWidgetCountdownTextView.setText(StructMsgItemTimer.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemTimer, paramLong));
    this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemTimer.jdField_c_of_type_Long = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gpk
 * JD-Core Version:    0.7.0.1
 */