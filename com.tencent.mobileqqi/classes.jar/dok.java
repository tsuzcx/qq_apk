import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.cur.DragRelativeLayout;
import java.util.List;

public class dok
  implements Runnable
{
  public dok(TroopAssistantActivity paramTroopAssistantActivity, List paramList) {}
  
  public void run()
  {
    RecentAdapter localRecentAdapter;
    if ((TroopAssistantActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssistantActivity).a() == -1) && (TroopAssistantActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssistantActivity) != null))
    {
      localRecentAdapter = TroopAssistantActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssistantActivity);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssistantActivity.b) {
        break label71;
      }
    }
    label71:
    for (int i = 3;; i = 4)
    {
      localRecentAdapter.a(i);
      TroopAssistantActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssistantActivity).a(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssistantActivity.i();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dok
 * JD-Core Version:    0.7.0.1
 */