import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.AboutConfig;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class fmj
  implements Runnable
{
  public fmj(AboutConfig paramAboutConfig) {}
  
  public void run()
  {
    EntityManager localEntityManager = AboutConfig.a(this.a).a().createEntityManager();
    List localList = ResourcePluginInfo.getAll(localEntityManager, 32, false);
    localEntityManager.a();
    if ((localList != null) && (localList.size() > 0))
    {
      this.a.b();
      AboutConfig.a(this.a, localList);
      if (QLog.isColorLevel()) {
        QLog.d("AboutConfig", 2, "Load about config from DB = " + AboutConfig.a(this.a));
      }
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fmj
 * JD-Core Version:    0.7.0.1
 */