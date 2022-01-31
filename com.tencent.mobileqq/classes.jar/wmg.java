import com.tencent.mobileqq.activity.contacts.adapter.ContactsTroopAdapter;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class wmg
  implements Runnable
{
  public wmg(ContactsTroopAdapter paramContactsTroopAdapter, TroopManager paramTroopManager, RecentUserProxy paramRecentUserProxy) {}
  
  public void run()
  {
    ArrayList localArrayList1 = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a();
    ArrayList localArrayList2 = ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.a.getManager(52)).a();
    ThreadManager.getUIHandler().post(new wmh(this, localArrayList1, localArrayList2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wmg
 * JD-Core Version:    0.7.0.1
 */