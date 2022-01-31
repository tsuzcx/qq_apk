import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.BaseChatPie;

public class aau
  implements Runnable
{
  public aau(BaseChatPie paramBaseChatPie, Intent paramIntent1, Intent paramIntent2) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.e(this.jdField_a_of_type_AndroidContentIntent);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.D();
    if (this.b.getBooleanExtra("isFromShare", false))
    {
      this.b.removeExtra("forward_type");
      this.b.getExtras().remove("forward_type");
      this.b.removeExtra("isFromShare");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aau
 * JD-Core Version:    0.7.0.1
 */