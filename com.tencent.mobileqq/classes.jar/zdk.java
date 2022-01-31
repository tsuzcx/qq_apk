import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloGameRankData;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.util.ArrayList;

public final class zdk
  implements Runnable
{
  public zdk(QQAppInterface paramQQAppInterface, ApolloGameRankData paramApolloGameRankData) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqDataApolloGameRankData != null))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqDataApolloGameRankData);
      ((ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(154)).c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager(), localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     zdk
 * JD-Core Version:    0.7.0.1
 */