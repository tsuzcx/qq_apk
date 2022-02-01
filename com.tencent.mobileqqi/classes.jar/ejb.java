import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.main.MainAssistObserver;

public class ejb
  implements RadioGroup.OnCheckedChangeListener
{
  public ejb(MainAssistObserver paramMainAssistObserver, RadioButton paramRadioButton1, RadioButton paramRadioButton2, Button paramButton) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    if ((paramInt == this.jdField_a_of_type_AndroidWidgetRadioButton.getId()) || (paramInt == this.b.getId()))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      if (paramInt != this.jdField_a_of_type_AndroidWidgetRadioButton.getId()) {
        break label53;
      }
    }
    label53:
    while (paramInt != this.b.getId())
    {
      return;
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ejb
 * JD-Core Version:    0.7.0.1
 */