import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionPackage;
import java.util.Iterator;
import java.util.List;

public class yzd
  implements Runnable
{
  public yzd(ApolloPanel paramApolloPanel, List paramList) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.a != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.a.a != null))
    {
      ApolloDaoManager localApolloDaoManager = (ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.a.a.getManager(154);
      if (localApolloDaoManager != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext()) {
          localApolloDaoManager.a((ApolloActionPackage)localIterator.next());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yzd
 * JD-Core Version:    0.7.0.1
 */