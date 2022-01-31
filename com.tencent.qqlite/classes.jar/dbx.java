import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.AboutConfig;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class dbx
  implements Runnable
{
  public dbx(AboutConfig paramAboutConfig) {}
  
  public void run()
  {
    EntityManager localEntityManager = AboutConfig.a(this.a).a().createEntityManager();
    List localList = ResourcePluginInfo.getAll(localEntityManager, 32, false);
    localEntityManager.a();
    if ((localList != null) && (localList.size() > 0))
    {
      AboutConfig.a(this.a);
      AboutConfig.a(this.a, localList);
      if (QLog.isColorLevel()) {
        QLog.d("AboutConfig", 2, "Load about config from DB = " + AboutConfig.a(this.a));
      }
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dbx
 * JD-Core Version:    0.7.0.1
 */