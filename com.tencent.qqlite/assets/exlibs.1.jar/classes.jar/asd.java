import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;

public class asd
  implements Runnable
{
  public asd(Leba paramLeba, LebaViewItem paramLebaViewItem) {}
  
  public void run()
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqActivityLeba.a.a().createEntityManager();
    ResourcePluginInfo.persistOrReplace(localEntityManager, this.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem.a);
    localEntityManager.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     asd
 * JD-Core Version:    0.7.0.1
 */