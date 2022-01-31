import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.HotSortVideoEntry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class uqy
  implements uqz
{
  private awbw a()
  {
    return QQStoryContext.a().a().createEntityManager();
  }
  
  public static List<? extends awbv> a(awbw paramawbw, Class<? extends awbv> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramawbw.a(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  public List<HotSortVideoEntry> a(String paramString)
  {
    List localList = a(a(), HotSortVideoEntry.class, HotSortVideoEntry.class.getSimpleName(), "groupId=?", new String[] { paramString });
    Object localObject = localList;
    if (localList == null) {
      localObject = new ArrayList();
    }
    wsv.a("Q.qqstory:HotSortVideoManager", "query HotSortVideoEntry id: %s, size: %d", paramString, Integer.valueOf(((List)localObject).size()));
    return localObject;
  }
  
  public void a() {}
  
  public void a(HotSortVideoEntry paramHotSortVideoEntry)
  {
    awbw localawbw = a();
    paramHotSortVideoEntry.setStatus(1001);
    localawbw.a(paramHotSortVideoEntry);
  }
  
  public void a(List<HotSortVideoEntry> paramList)
  {
    awbw localawbw = QQStoryContext.a().a().createEntityManager();
    localawbw.a().a();
    try
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        HotSortVideoEntry localHotSortVideoEntry = (HotSortVideoEntry)paramList.next();
        localHotSortVideoEntry.setStatus(1001);
        localawbw.a(localHotSortVideoEntry);
      }
    }
    finally
    {
      localawbw.a().b();
    }
    localawbw.a().b();
  }
  
  public void a(List<HotSortVideoEntry> paramList, String paramString, boolean paramBoolean)
  {
    awbw localawbw = QQStoryContext.a().a().createEntityManager();
    localawbw.a().a();
    Object localObject;
    HotSortVideoEntry localHotSortVideoEntry;
    if (paramBoolean) {
      try
      {
        localObject = a(paramString);
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            localHotSortVideoEntry = (HotSortVideoEntry)((Iterator)localObject).next();
            localHotSortVideoEntry.setStatus(1001);
            localawbw.b(localHotSortVideoEntry);
          }
        }
        localObject = paramList.iterator();
      }
      finally
      {
        localawbw.a().b();
      }
    }
    while (((Iterator)localObject).hasNext())
    {
      localHotSortVideoEntry = (HotSortVideoEntry)((Iterator)localObject).next();
      localHotSortVideoEntry.groupId = paramString;
      localHotSortVideoEntry.setStatus(1000);
      localawbw.b(localHotSortVideoEntry);
    }
    wsv.a("Q.qqstory:HotSortVideoManager", "insert HotSortVideoEntry list groupId is %s, size is %d", paramString, Integer.valueOf(paramList.size()));
    localawbw.a().c();
    localawbw.a().b();
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uqy
 * JD-Core Version:    0.7.0.1
 */