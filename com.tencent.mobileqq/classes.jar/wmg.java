import android.os.Message;
import com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class wmg
  implements Runnable
{
  private int jdField_a_of_type_Int;
  
  private wmg(TroopMemberHistoryFragment paramTroopMemberHistoryFragment) {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void run()
  {
    long l1;
    Message localMessage;
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopMemberHistoryFragment.isDetached())
    {
      l1 = System.currentTimeMillis();
      List localList = this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopMemberHistoryFragment.a();
      localMessage = this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopMemberHistoryFragment.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(0, localList);
      localMessage.arg1 = this.jdField_a_of_type_Int;
      if ((localList != null) && (!localList.isEmpty())) {
        break label83;
      }
      localMessage.arg2 = 11;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopMemberHistoryFragment.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
      return;
      label83:
      localMessage.arg2 = 10;
      if (QLog.isColorLevel())
      {
        long l2 = System.currentTimeMillis();
        QLog.d(TroopMemberHistoryFragment.jdField_a_of_type_JavaLangString, 2, "More messages loaded. Costs " + (l2 - l1) + " ms.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wmg
 * JD-Core Version:    0.7.0.1
 */