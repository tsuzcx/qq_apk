import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.util.WeakReference;

public class zke
  implements Runnable
{
  private final WeakReference a;
  private final WeakReference b;
  
  public zke(QQAppInterface paramQQAppInterface, PublicAccountDataManager paramPublicAccountDataManager)
  {
    this.a = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramPublicAccountDataManager);
  }
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.get();
    PublicAccountDataManager localPublicAccountDataManager = (PublicAccountDataManager)this.b.get();
    if ((localQQAppInterface != null) && (localPublicAccountDataManager != null))
    {
      TroopBarAssistantManager.a().a(localQQAppInterface, localPublicAccountDataManager.a());
      ServiceAccountFolderManager.a().c(localQQAppInterface);
      TroopBarAssistantManager.a().g(localQQAppInterface);
      ReadInJoyLogicEngine.a().e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zke
 * JD-Core Version:    0.7.0.1
 */