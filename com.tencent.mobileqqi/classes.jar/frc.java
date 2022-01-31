import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.LebaConfig;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class frc
  implements Runnable
{
  public frc(LebaConfig paramLebaConfig, ArrayList paramArrayList) {}
  
  public void run()
  {
    Object localObject1 = LebaConfig.a(this.jdField_a_of_type_ComTencentMobileqqConfigLebaConfig).a().createEntityManager();
    Object localObject2 = ResourcePluginInfo.getAll((EntityManager)localObject1, 64, false);
    ((EntityManager)localObject1).a();
    if ((localObject2 != null) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (localObject2 != null) && (((List)localObject2).size() > 0)) {
      localObject1 = ((List)localObject2).iterator();
    }
    label252:
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ResourcePluginInfo)((Iterator)localObject1).next();
        if ((localObject2 != null) && (((ResourcePluginInfo)localObject2).strPkgName != null))
        {
          Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          ResourcePluginInfo localResourcePluginInfo;
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localResourcePluginInfo = (ResourcePluginInfo)localIterator.next();
          } while ((localResourcePluginInfo == null) || (localResourcePluginInfo.strPkgName == null) || (localResourcePluginInfo.strPkgName.compareTo(((ResourcePluginInfo)localObject2).strPkgName) != 0));
        }
      }
      else
      {
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label252;
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.lebatab.config", 2, "addItem=" + localObject2);
          break;
          if (LebaConfig.a(this.jdField_a_of_type_ComTencentMobileqqConfigLebaConfig) != null)
          {
            LebaConfig.a(this.jdField_a_of_type_ComTencentMobileqqConfigLebaConfig).clear();
            LebaConfig.a(this.jdField_a_of_type_ComTencentMobileqqConfigLebaConfig).addAll(this.jdField_a_of_type_JavaUtilArrayList);
          }
          this.jdField_a_of_type_ComTencentMobileqqConfigLebaConfig.d();
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     frc
 * JD-Core Version:    0.7.0.1
 */