import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.troop.aioapp.FullListGroupAppsDbHelper.1;
import com.tencent.mobileqq.troop.aioapp.data.FullListGroupAppEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class aoxx
{
  private final QQAppInterface mApp;
  
  aoxx(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  private void a(FullListGroupAppEntity paramFullListGroupAppEntity)
  {
    if ((paramFullListGroupAppEntity == null) || (aoyb.isEmpty(paramFullListGroupAppEntity.troopAIOAppInfos)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FullListGroupAppsDbHelper", 2, "saveToDb: invoked. empty full list, no need to persist");
      }
      return;
    }
    EntityManager localEntityManager = this.mApp.a().createEntityManager();
    paramFullListGroupAppEntity.setStatus(1000);
    localEntityManager.delete(FullListGroupAppEntity.class.getSimpleName(), null, null);
    localEntityManager.persistOrReplace(paramFullListGroupAppEntity);
    localEntityManager.close();
  }
  
  void b(FullListGroupAppEntity paramFullListGroupAppEntity)
  {
    ThreadManagerV2.excute(new FullListGroupAppsDbHelper.1(this, paramFullListGroupAppEntity), 32, null, false);
  }
  
  public void dXM()
  {
    EntityManager localEntityManager = this.mApp.a().createEntityManager();
    aoxw localaoxw = aoxw.a(this.mApp);
    Object localObject = localEntityManager.query(FullListGroupAppEntity.class);
    if (!aoyb.isEmpty((Collection)localObject))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        FullListGroupAppEntity localFullListGroupAppEntity = (FullListGroupAppEntity)((Iterator)localObject).next();
        if (!aoyb.isEmpty(localFullListGroupAppEntity.troopAIOAppInfos))
        {
          localaoxw.Hq = localFullListGroupAppEntity.troopAIOAppInfos;
          QLog.i("FullListGroupAppsDbHelper", 1, "buildFullListFromDb: invoked. " + localaoxw.Hq);
          return;
        }
      }
    }
    localEntityManager.close();
  }
  
  void dXN()
  {
    this.mApp.a().createEntityManager().delete(FullListGroupAppEntity.class.getSimpleName(), null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoxx
 * JD-Core Version:    0.7.0.1
 */