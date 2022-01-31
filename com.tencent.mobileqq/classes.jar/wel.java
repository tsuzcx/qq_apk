import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ReadInJoySearchHistoryEntity;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class wel
  implements Runnable
{
  public wel(ClassificationSearchActivity paramClassificationSearchActivity, String paramString) {}
  
  public void run()
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchActivity.app.getEntityManagerFactory().createEntityManager();
    Object localObject2 = localEntityManager.a(ReadInJoySearchHistoryEntity.class, true, null, null, null, null, " timestamp DESC ", null);
    Object localObject1;
    if (localObject2 != null)
    {
      Iterator localIterator = ((List)localObject2).iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (ReadInJoySearchHistoryEntity)localIterator.next();
        if (((ReadInJoySearchHistoryEntity)localObject1).keyWord.equals(this.jdField_a_of_type_JavaLangString)) {
          localEntityManager.b((Entity)localObject1);
        }
      }
    }
    for (;;)
    {
      if (localObject1 != null) {
        ((List)localObject2).remove(localObject1);
      }
      if (((List)localObject2).size() == 20)
      {
        localEntityManager.b((Entity)((List)localObject2).get(((List)localObject2).size() - 1));
        ((List)localObject2).remove(((List)localObject2).size() - 1);
      }
      for (localObject1 = localObject2;; localObject1 = new ArrayList())
      {
        localObject2 = new ReadInJoySearchHistoryEntity();
        ((ReadInJoySearchHistoryEntity)localObject2).keyWord = this.jdField_a_of_type_JavaLangString;
        ((ReadInJoySearchHistoryEntity)localObject2).timestamp = System.currentTimeMillis();
        localEntityManager.a((Entity)localObject2);
        ((List)localObject1).add(0, localObject2);
        localEntityManager.a();
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchActivity.a.obtainMessage(1);
        ((Message)localObject2).obj = localObject1;
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchActivity.a.sendMessage((Message)localObject2);
        return;
      }
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wel
 * JD-Core Version:    0.7.0.1
 */