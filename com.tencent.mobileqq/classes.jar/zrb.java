import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.util.WeakReference;

public class zrb
  implements Runnable
{
  private final WeakReference a;
  private final WeakReference b;
  
  public zrb(QQAppInterface paramQQAppInterface, PublicAccountDataManager paramPublicAccountDataManager)
  {
    this.a = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramPublicAccountDataManager);
  }
  
  public void run()
  {
    Object localObject = (QQAppInterface)this.a.get();
    PublicAccountDataManager localPublicAccountDataManager = (PublicAccountDataManager)this.b.get();
    if ((localObject != null) && (localPublicAccountDataManager != null))
    {
      TroopBarAssistantManager.a().a((QQAppInterface)localObject, localPublicAccountDataManager.a());
      ServiceAccountFolderManager.a().c((QQAppInterface)localObject);
      TroopBarAssistantManager.a().g((QQAppInterface)localObject);
      localObject = ReadInJoyLogicEngine.a();
      if (localObject != null) {
        ((ReadInJoyLogicEngine)localObject).e();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zrb
 * JD-Core Version:    0.7.0.1
 */