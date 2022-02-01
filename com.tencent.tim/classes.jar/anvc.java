import com.tencent.mobileqq.structmsg.widget.CountdownTextView;
import com.tencent.mobileqq.structmsg.widget.CountdownTextView.a;

class anvc
  implements CountdownTextView.a
{
  anvc(anva paramanva, CountdownTextView paramCountdownTextView) {}
  
  public void onFinish()
  {
    this.jdField_a_of_type_Anva.anW = 0L;
    this.jdField_a_of_type_Anva.cKa = true;
    this.jdField_a_of_type_ComTencentMobileqqStructmsgWidgetCountdownTextView.setText(anva.a(this.jdField_a_of_type_Anva, 0L));
  }
  
  public void onTick(long paramLong)
  {
    paramLong /= 1000L;
    this.jdField_a_of_type_ComTencentMobileqqStructmsgWidgetCountdownTextView.setText(anva.a(this.jdField_a_of_type_Anva, paramLong));
    this.jdField_a_of_type_Anva.anW = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anvc
 * JD-Core Version:    0.7.0.1
 */