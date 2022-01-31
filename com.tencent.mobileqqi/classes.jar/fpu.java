import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;

public class fpu
  implements Runnable
{
  public fpu(ConditionSearchFriendActivity paramConditionSearchFriendActivity) {}
  
  public void run()
  {
    String str = this.a.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this.a.c);
    Message localMessage = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(1001);
    localMessage.obj = new Object[] { this.a.c, str };
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fpu
 * JD-Core Version:    0.7.0.1
 */