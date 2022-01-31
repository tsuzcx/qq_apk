import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.app.utils.ApolloContentUpdateHandler;
import com.tencent.mobileqq.data.ApolloGameRoamData;
import com.tencent.qphone.base.util.QLog;

public class yvr
  implements Runnable
{
  public yvr(ApolloDaoManager paramApolloDaoManager, ApolloGameRoamData paramApolloGameRoamData) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloDaoManager.a != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloDaoManager", 2, new Object[] { "[saveUserPlayedGameRoamData] game ", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataApolloGameRoamData.gameId), " not in local, try update json" });
      }
      ApolloContentUpdateHandler.a(this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloDaoManager.a, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yvr
 * JD-Core Version:    0.7.0.1
 */