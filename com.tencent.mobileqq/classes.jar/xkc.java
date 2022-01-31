import android.util.SparseArray;
import com.tencent.mobileqq.activity.recent.HotChatCenterItemBuilder;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.lang.ref.WeakReference;

public class xkc
  implements Runnable
{
  public xkc(HotChatCenterItemBuilder paramHotChatCenterItemBuilder, int paramInt) {}
  
  public void run()
  {
    ??? = ((QQAppInterface)HotChatCenterItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentHotChatCenterItemBuilder).get()).getEntityManagerFactory().createEntityManager();
    HotChatCenterItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentHotChatCenterItemBuilder, ApolloGameUtil.a((EntityManager)???));
    if ((HotChatCenterItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentHotChatCenterItemBuilder) != null) && (HotChatCenterItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentHotChatCenterItemBuilder).size() > 0))
    {
      SparseArray localSparseArray = (SparseArray)HotChatCenterItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentHotChatCenterItemBuilder).get(this.jdField_a_of_type_Int);
      if ((localSparseArray != null) && (localSparseArray.size() > 0))
      {
        if ((HotChatCenterItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentHotChatCenterItemBuilder) != null) && (HotChatCenterItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentHotChatCenterItemBuilder).get() != null)) {
          ApolloGameUtil.a((EntityManager)???, ApolloUtil.a(localSparseArray));
        }
        synchronized (HotChatCenterItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentHotChatCenterItemBuilder))
        {
          localSparseArray.remove(1000);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xkc
 * JD-Core Version:    0.7.0.1
 */