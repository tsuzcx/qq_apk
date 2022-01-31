import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.service.profile.ProfileUtil;
import com.tencent.widget.TimePickerView.TimePickerListener;

class enw
  implements TimePickerView.TimePickerListener
{
  enw(env paramenv) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = ProfileUtil.a(paramInt1, paramInt2, paramInt3);
    if (this.a.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(ProfileUtil.a(paramInt1));
    }
    this.a.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.b = paramInt1;
    this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     enw
 * JD-Core Version:    0.7.0.1
 */