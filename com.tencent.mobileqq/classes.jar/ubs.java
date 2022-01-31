import android.os.Handler;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity.ATroopMember;
import java.util.List;

class ubs
  implements Runnable
{
  ubs(ubr paramubr, TroopMemberListActivity.ATroopMember paramATroopMember) {}
  
  public void run()
  {
    this.jdField_a_of_type_Ubr.jdField_a_of_type_Ubp.a.a(this.jdField_a_of_type_Ubr.jdField_a_of_type_JavaLangString);
    synchronized (this.jdField_a_of_type_Ubr.jdField_a_of_type_Ubp.a)
    {
      this.jdField_a_of_type_Ubr.jdField_a_of_type_Ubp.a.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ATroopMember);
      this.jdField_a_of_type_Ubr.jdField_a_of_type_Ubp.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(9);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ubs
 * JD-Core Version:    0.7.0.1
 */