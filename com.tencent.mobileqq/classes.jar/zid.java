import com.tencent.mobileqq.app.PPCLoginAuthHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;

public class zid
  implements Runnable
{
  public zid(PPCLoginAuthHandler paramPPCLoginAuthHandler) {}
  
  public void run()
  {
    EntityManager localEntityManager = this.a.a.getEntityManagerFactory(this.a.a.getCurrentAccountUin()).createEntityManager();
    ExtensionInfo localExtensionInfo = (ExtensionInfo)localEntityManager.a(ExtensionInfo.class, this.a.a.getAccount());
    if (localExtensionInfo != null)
    {
      localExtensionInfo.commingRingId = 0L;
      localEntityManager.a(localExtensionInfo);
    }
    for (;;)
    {
      localEntityManager.a();
      return;
      localExtensionInfo = new ExtensionInfo();
      localExtensionInfo.uin = this.a.a.getAccount();
      localEntityManager.a(localExtensionInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zid
 * JD-Core Version:    0.7.0.1
 */