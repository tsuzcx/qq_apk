import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.troop.aioapp.GrayGroupAppsDbHelper.1;
import com.tencent.mobileqq.troop.aioapp.data.GrayGroupAppEntity;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class aoxy
{
  private final QQAppInterface mApp;
  
  aoxy(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  private void Rr(boolean paramBoolean)
  {
    EntityManager localEntityManager = this.mApp.a().createEntityManager();
    aoxw localaoxw = aoxw.a(this.mApp);
    Object localObject = localEntityManager.query(GrayGroupAppEntity.class);
    if (!aoyb.isEmpty((Collection)localObject))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        GrayGroupAppEntity localGrayGroupAppEntity = (GrayGroupAppEntity)((Iterator)localObject).next();
        if (paramBoolean)
        {
          localGrayGroupAppEntity.updatedTimestamp = 0L;
          a(localGrayGroupAppEntity);
        }
        localaoxw.iJ.put(Long.valueOf(localGrayGroupAppEntity.groupUin), localGrayGroupAppEntity);
      }
    }
    localEntityManager.close();
  }
  
  private void a(GrayGroupAppEntity paramGrayGroupAppEntity)
  {
    EntityManager localEntityManager = this.mApp.a().createEntityManager();
    paramGrayGroupAppEntity.setStatus(1000);
    localEntityManager.persistOrReplace(paramGrayGroupAppEntity);
    localEntityManager.close();
  }
  
  void b(GrayGroupAppEntity paramGrayGroupAppEntity)
  {
    ThreadManagerV2.excute(new GrayGroupAppsDbHelper.1(this, paramGrayGroupAppEntity), 32, null, false);
  }
  
  void dXN()
  {
    this.mApp.a().createEntityManager().delete(GrayGroupAppEntity.class.getSimpleName(), null, null);
  }
  
  public void dXO()
  {
    Rr(false);
  }
  
  public void dXP()
  {
    Rr(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoxy
 * JD-Core Version:    0.7.0.1
 */