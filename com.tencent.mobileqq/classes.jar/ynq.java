import com.tencent.mobileqq.adapter.ForwardRecentListAdapter;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class ynq
  implements Runnable
{
  public ynq(ForwardRecentListAdapter paramForwardRecentListAdapter, List paramList) {}
  
  public void run()
  {
    ArrayList localArrayList = ForwardRecentListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentListAdapter, this.jdField_a_of_type_JavaUtilList);
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      ThreadManager.getUIHandler().post(new ynr(this, localArrayList));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ynq
 * JD-Core Version:    0.7.0.1
 */