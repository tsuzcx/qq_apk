import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.apollo.view.ApolloRecentViewBinder;
import com.tencent.mobileqq.apollo.view.ApolloViewBinder;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class zgg
  implements Runnable
{
  public zgg(ApolloPanel paramApolloPanel) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "func updateLastApolloPanel begins. Thread id = " + Thread.currentThread().getId());
    }
    if (this.a.jdField_a_of_type_JavaUtilList == null) {}
    ApolloViewBinder localApolloViewBinder;
    do
    {
      return;
      localApolloViewBinder = (ApolloViewBinder)this.a.jdField_a_of_type_JavaUtilList.get(0);
    } while ((this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (!(localApolloViewBinder instanceof ApolloRecentViewBinder)));
    if (localApolloViewBinder.c == 2) {
      localApolloViewBinder.c = 0;
    }
    ((ApolloRecentViewBinder)localApolloViewBinder).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.a.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     zgg
 * JD-Core Version:    0.7.0.1
 */