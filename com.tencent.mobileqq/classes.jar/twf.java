import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.app.message.QQMessageFacade;

public class twf
  implements Runnable
{
  public twf(TroopAssistantActivity paramTroopAssistantActivity, QQMessageFacade paramQQMessageFacade, TextView paramTextView) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b();
    String str1 = "" + i;
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssistantActivity.e)
    {
      str1 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssistantActivity.getString(2131433297) + "(" + i + ")";
      if (i > 99) {
        str1 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssistantActivity.getString(2131433297) + "(99+)";
      }
      if (i <= 0) {
        str1 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssistantActivity.getString(2131433297);
      }
    }
    String str2 = str1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssistantActivity.e)
    {
      str2 = str1;
      if (i > 99) {
        str2 = "99+";
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssistantActivity.runOnUiThread(new twg(this, i, str2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     twf
 * JD-Core Version:    0.7.0.1
 */