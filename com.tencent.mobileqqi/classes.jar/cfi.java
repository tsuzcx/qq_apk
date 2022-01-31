import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivity;

public class cfi
  implements Runnable
{
  public cfi(ChatActivity paramChatActivity, Intent paramIntent1, Intent paramIntent2) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.b(this.jdField_a_of_type_AndroidContentIntent);
    this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.n();
    if (this.b.getBooleanExtra("isFromShare", false))
    {
      this.b.removeExtra("forward_type");
      this.b.getExtras().remove("forward_type");
      this.b.removeExtra("isFromShare");
      String str2 = this.b.getExtras().getString("leftBackText");
      String str1;
      if (str2 != null)
      {
        str1 = str2;
        if (!"".equals(str2)) {}
      }
      else
      {
        str1 = this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getString(2131561692);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.a.setText(str1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cfi
 * JD-Core Version:    0.7.0.1
 */