import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.data.ApolloActionData;

public class yso
  implements Runnable
{
  public yso(ApolloDaoManager paramApolloDaoManager, int paramInt) {}
  
  public void run()
  {
    ApolloActionData localApolloActionData = this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloDaoManager.a(this.jdField_a_of_type_Int);
    if (localApolloActionData != null)
    {
      localApolloActionData.limitFree = 0;
      this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloDaoManager.b(localApolloActionData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yso
 * JD-Core Version:    0.7.0.1
 */