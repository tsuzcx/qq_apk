import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.List;

public class ygz
  implements Runnable
{
  public ygz(ApolloManager paramApolloManager, DrawerPushItem paramDrawerPushItem) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem == null) {
      return;
    }
    synchronized (ApolloManager.a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloManager))
    {
      if ((ApolloManager.a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloManager) != null) && (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem != null) && (ApolloManager.a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloManager).contains(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem))) {
        ApolloManager.a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloManager).remove(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem);
      }
      if (ApolloManager.a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloManager) != null)
      {
        ApolloManager.a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloManager).b(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem);
        ApolloManager.a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloManager).a();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ygz
 * JD-Core Version:    0.7.0.1
 */