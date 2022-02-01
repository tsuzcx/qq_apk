import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.TagEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ljava.lang.String;>;
import java.util.Map;
import java.util.Set;

public class psz
  implements psj
{
  private long Ar;
  private Set<String> aC = Collections.synchronizedSet(new HashSet());
  private EntityManager em;
  
  public static List<? extends Entity> a(EntityManager paramEntityManager, Class<? extends Entity> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramEntityManager.query(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  private QQStoryContext b()
  {
    return QQStoryContext.a();
  }
  
  public List<rmw.a> R(String paramString)
  {
    Object localObject = a(this.em, TagEntry.class, TagEntry.class.getSimpleName(), "feedId=?", new String[] { paramString });
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = new ArrayList();
    }
    localObject = new ArrayList();
    paramString = paramString.iterator();
    while (paramString.hasNext()) {
      ((List)localObject).add(new rmw.a((TagEntry)paramString.next()));
    }
    return localObject;
  }
  
  public List<rmw.a> c(String paramString, List<StoryVideoItem> paramList)
  {
    try
    {
      paramString = d(paramList, R(paramString));
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public List<rmw.a> d(List<StoryVideoItem> paramList, List<rmw.a> paramList1)
  {
    ArrayList localArrayList;
    HashSet localHashSet;
    try
    {
      localArrayList = new ArrayList();
      localHashSet = new HashSet();
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          StoryVideoItem localStoryVideoItem = (StoryVideoItem)paramList.next();
          if ((localStoryVideoItem.mTagInfoBase != null) && (!localHashSet.contains(localStoryVideoItem.mTagInfoBase)))
          {
            localArrayList.add(localStoryVideoItem.mTagInfoBase);
            localHashSet.add(localStoryVideoItem.mTagInfoBase);
          }
        }
      }
      if (paramList1 == null) {
        break label167;
      }
    }
    finally {}
    paramList = paramList1.iterator();
    while (paramList.hasNext())
    {
      paramList1 = (rmw.a)paramList.next();
      if (!localHashSet.contains(paramList1))
      {
        localArrayList.add(paramList1);
        localHashSet.add(paramList1);
      }
    }
    label167:
    return localArrayList;
  }
  
  public void ea(List<String> paramList)
  {
    if (paramList == null) {
      return;
    }
    Object localObject = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    if (Math.abs(this.Ar - System.currentTimeMillis()) > 60000L) {
      this.aC.clear();
    }
    for (;;)
    {
      if (localArrayList.size() > 0) {
        ram.w("Q.qqstory:TagManager", "request still waiting , %s", new Object[] { localArrayList });
      }
      if (paramList.size() == 0) {
        break;
      }
      this.Ar = System.currentTimeMillis();
      localObject = new pyv();
      ((pyv)localObject).np = paramList;
      ppv.a().a((ppw)localObject, new pta(this));
      ram.w("Q.qqstory:TagManager", "request tag list :%s", new Object[] { paramList });
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (this.aC.contains(str)) {
          localArrayList.add(str);
        } else {
          ((List)localObject).add(str);
        }
      }
      paramList = (List<String>)localObject;
    }
  }
  
  public void j(String paramString, List<rmw.a> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject = a(this.em, TagEntry.class, TagEntry.class.getSimpleName(), "feedId=?", new String[] { paramString });
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            TagEntry localTagEntry = (TagEntry)((Iterator)localObject).next();
            localTagEntry.setStatus(1001);
            this.em.remove(localTagEntry);
          }
        }
      }
      finally
      {
        try
        {
          this.em.getTransaction().end();
          throw paramString;
        }
        finally {}
        this.em.getTransaction().begin();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject = ((rmw.a)paramList.next()).a();
          ((TagEntry)localObject).feedId = paramString;
          this.em.persistOrReplace((Entity)localObject);
        }
        this.em.getTransaction().commit();
        this.em.getTransaction().end();
      }
    }
  }
  
  public void onDestroy()
  {
    this.em.close();
  }
  
  public void onInit()
  {
    this.em = b().getEntityManagerFactory().createEntityManager();
  }
  
  public static class a
    extends plt
  {
    public Map<String, pyv.a> fJ = new HashMap();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     psz
 * JD-Core Version:    0.7.0.1
 */