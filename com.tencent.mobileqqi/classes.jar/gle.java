import com.tencent.mobileqq.activity.photopreview.CountDownTimer.CountDownTimerListener;
import com.tencent.mobileqq.structmsg.widget.CountdownTextView;
import com.tencent.mobileqq.structmsg.widget.CountdownTextView.TimerCallback;

public class gle
  extends CountDownTimer.CountDownTimerListener
{
  public gle(CountdownTextView paramCountdownTextView, long paramLong, CountdownTextView.TimerCallback paramTimerCallback)
  {
    super(paramLong);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgWidgetCountdownTextView$TimerCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqStructmsgWidgetCountdownTextView$TimerCallback.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqStructmsgWidgetCountdownTextView.a();
  }
  
  public void b(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgWidgetCountdownTextView$TimerCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqStructmsgWidgetCountdownTextView$TimerCallback.a(paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gle
 * JD-Core Version:    0.7.0.1
 */