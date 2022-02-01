import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.LikeEntry;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class psm
  implements psj
{
  public static final String auO = ppf.fQ("StorySvc.do_like_video");
  public static final String auP = ppf.fQ("StoryGroupSvc.do_like_video");
  private EntityManager em;
  
  public static List<? extends Entity> a(EntityManager paramEntityManager, Class<? extends Entity> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramEntityManager.query(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  private QQStoryContext b()
  {
    return QQStoryContext.a();
  }
  
  public void a(@NonNull LikeEntry paramLikeEntry)
  {
    EntityManager localEntityManager = b().getEntityManagerFactory().createEntityManager();
    localEntityManager.getTransaction().begin();
    try
    {
      paramLikeEntry.type = 3;
      paramLikeEntry.setStatus(1000);
      localEntityManager.persistOrReplace(paramLikeEntry);
      LikeEntry localLikeEntry = new LikeEntry();
      localLikeEntry.copy(paramLikeEntry);
      localLikeEntry.type = 4;
      localLikeEntry.setStatus(1000);
      localEntityManager.persistOrReplace(localLikeEntry);
      localEntityManager.getTransaction().commit();
      return;
    }
    finally
    {
      localEntityManager.getTransaction().end();
    }
  }
  
  public void b(@NonNull LikeEntry paramLikeEntry)
  {
    paramLikeEntry.setStatus(1001);
    this.em.remove(paramLikeEntry, "unionId=? and feedId= ? and type in (?,?)", new String[] { paramLikeEntry.unionId, paramLikeEntry.feedId, String.valueOf(4), String.valueOf(3) });
  }
  
  public void b(@NonNull List<LikeEntry> paramList, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    if (paramBoolean1) {
      i = 4;
    }
    EntityManager localEntityManager;
    Object localObject;
    for (;;)
    {
      localEntityManager = b().getEntityManagerFactory().createEntityManager();
      localEntityManager.getTransaction().begin();
      if (!paramBoolean2) {
        break;
      }
      try
      {
        localObject = c(paramString, paramBoolean1);
        if (localObject == null) {
          break;
        }
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          LikeEntry localLikeEntry = (LikeEntry)((Iterator)localObject).next();
          localLikeEntry.setStatus(1001);
          localEntityManager.remove(localLikeEntry);
        }
        i = 3;
      }
      finally
      {
        localEntityManager.getTransaction().end();
      }
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (LikeEntry)paramList.next();
      ((LikeEntry)localObject).feedId = paramString;
      ((LikeEntry)localObject).type = i;
      localEntityManager.persistOrReplace((Entity)localObject);
    }
    localEntityManager.getTransaction().commit();
    localEntityManager.getTransaction().end();
  }
  
  public List<LikeEntry> c(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 4;; i = 3)
    {
      List localList = a(this.em, LikeEntry.class, LikeEntry.class.getSimpleName(), "feedId=? and type=?", new String[] { paramString, String.valueOf(i) });
      paramString = localList;
      if (localList == null) {
        paramString = new ArrayList();
      }
      return paramString;
    }
  }
  
  public void onDestroy()
  {
    this.em.close();
  }
  
  public void onInit()
  {
    this.em = QQStoryContext.a().getEntityManagerFactory().createEntityManager();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     psm
 * JD-Core Version:    0.7.0.1
 */