import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.service.profile.ProfileUtil;
import com.tencent.widget.TimePickerView;

public class ejg
  implements View.OnClickListener
{
  public ejg(MainAssistObserver paramMainAssistObserver, TextView paramTextView, Button paramButton) {}
  
  public void onClick(View paramView)
  {
    int i = ProfileUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.b);
    int j = ProfileUtil.c(this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.b);
    int k = ProfileUtil.d(this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.b);
    new TimePickerView(this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a, i, j, k, new ejh(this)).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ejg
 * JD-Core Version:    0.7.0.1
 */