import android.graphics.Color;
import android.text.Editable;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopRequestRefuseActivity;

public class uig
  implements Runnable
{
  public uig(TroopRequestRefuseActivity paramTroopRequestRefuseActivity, Editable paramEditable) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidTextEditable.length() > 25)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestRefuseActivity.a.setTextColor(-65536);
      TroopRequestRefuseActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestRefuseActivity, false);
    }
    for (;;)
    {
      String str2 = "" + (25 - this.jdField_a_of_type_AndroidTextEditable.length());
      String str1 = str2;
      if (str2.length() > 4) {
        str1 = str2.substring(0, 2) + "…";
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestRefuseActivity.a.setText(str1);
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestRefuseActivity.a.setTextColor(Color.rgb(119, 119, 119));
      TroopRequestRefuseActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestRefuseActivity, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uig
 * JD-Core Version:    0.7.0.1
 */