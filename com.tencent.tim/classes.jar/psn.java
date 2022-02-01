import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.MemoriesFeedIdListEntry;
import com.tencent.biz.qqstory.database.MemoriesYearNodeEntry;
import com.tencent.biz.qqstory.database.MemoryInfoEntry;
import com.tencent.biz.qqstory.database.StoryVideoListEntry;
import com.tencent.biz.qqstory.database.VideoCollectionEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.memory.model.MomeriesYearNode;
import com.tencent.biz.qqstory.storyHome.memory.model.ShareGroupCollectionItem;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.a;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.b;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class psn
  implements psj
{
  protected VideoCollectionItem.a a = new VideoCollectionItem.a();
  protected plv<String, VideoCollectionItem> c = new plv(300);
  protected plv<String, MemoryInfoEntry> d = new plv(300);
  
  protected static List<? extends Entity> a(EntityManager paramEntityManager, Class<? extends Entity> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramEntityManager.query(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  public List<String> N(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.videoVidList;
    }
    return new ArrayList();
  }
  
  public List<ShareGroupCollectionItem> O(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = a(b().getEntityManagerFactory().createEntityManager(), VideoCollectionEntry.class, VideoCollectionEntry.class.getSimpleName(), "unionId=? and collectionType=?", new String[] { paramString, String.valueOf(4) });
    if (paramString == null) {
      return localArrayList;
    }
    paramString = paramString.iterator();
    while (paramString.hasNext())
    {
      ShareGroupCollectionItem localShareGroupCollectionItem = a(((VideoCollectionEntry)paramString.next()).key);
      if (localShareGroupCollectionItem != null) {
        localArrayList.add(localShareGroupCollectionItem);
      }
    }
    return localArrayList;
  }
  
  public MemoryInfoEntry a(MemoryInfoEntry paramMemoryInfoEntry)
  {
    a(paramMemoryInfoEntry.unionId);
    paramMemoryInfoEntry = (MemoryInfoEntry)this.d.a(paramMemoryInfoEntry.unionId, paramMemoryInfoEntry);
    MemoryInfoEntry localMemoryInfoEntry = new MemoryInfoEntry();
    localMemoryInfoEntry.copy(paramMemoryInfoEntry);
    b().getEntityManagerFactory().createEntityManager().persistOrReplace(localMemoryInfoEntry);
    return localMemoryInfoEntry;
  }
  
  public MemoryInfoEntry a(String paramString)
  {
    MemoryInfoEntry localMemoryInfoEntry = (MemoryInfoEntry)this.d.a(paramString);
    if (localMemoryInfoEntry != null) {
      return localMemoryInfoEntry;
    }
    paramString = a(b().getEntityManagerFactory().createEntityManager(), MemoryInfoEntry.class, MemoryInfoEntry.class.getSimpleName(), MemoryInfoEntry.getUnionIdSelectionNoArg(), new String[] { String.valueOf(paramString) });
    if ((paramString == null) || (paramString.size() == 0)) {
      return null;
    }
    paramString = (MemoryInfoEntry)paramString.get(0);
    this.d.a(paramString.unionId, paramString);
    return paramString;
  }
  
  public ShareGroupCollectionItem a(String paramString)
  {
    rom.checkNotNull(paramString);
    if (paramString == null) {
      localObject = null;
    }
    do
    {
      return localObject;
      localShareGroupCollectionItem = (ShareGroupCollectionItem)this.c.a(paramString);
      localObject = localShareGroupCollectionItem;
    } while (localShareGroupCollectionItem != null);
    Object localObject = b().getEntityManagerFactory().createEntityManager();
    paramString = a((EntityManager)localObject, VideoCollectionEntry.class, VideoCollectionEntry.class.getSimpleName(), VideoCollectionEntry.getKeySelectionNoArgs(), new String[] { paramString });
    if ((paramString == null) || (paramString.size() == 0)) {
      return null;
    }
    ShareGroupCollectionItem localShareGroupCollectionItem = new ShareGroupCollectionItem((VideoCollectionEntry)paramString.get(0));
    paramString = ((qqe)psx.a(7)).a(localShareGroupCollectionItem.groupId);
    if (paramString == null) {
      return null;
    }
    localShareGroupCollectionItem.shareGroupItem = paramString;
    paramString = a((EntityManager)localObject, StoryVideoListEntry.class, StoryVideoListEntry.class.getSimpleName(), StoryVideoListEntry.getCollectionSelectionNoArg(), new String[] { String.valueOf(5), localShareGroupCollectionItem.key });
    if (paramString != null)
    {
      psu localpsu = (psu)psx.a(5);
      Iterator localIterator = paramString.iterator();
      while (localIterator.hasNext())
      {
        StoryVideoListEntry localStoryVideoListEntry = (StoryVideoListEntry)localIterator.next();
        localObject = localpsu.a(localStoryVideoListEntry.vid);
        paramString = (String)localObject;
        if (localObject == null)
        {
          paramString = new StoryVideoItem();
          paramString.mVid = localStoryVideoListEntry.vid;
        }
        localShareGroupCollectionItem.videoVidList.add(localStoryVideoListEntry.vid);
        localShareGroupCollectionItem.videoItemList.add(paramString);
      }
    }
    this.c.a(localShareGroupCollectionItem.key, localShareGroupCollectionItem);
    return localShareGroupCollectionItem;
  }
  
  public VideoCollectionItem a(@NonNull VideoCollectionItem paramVideoCollectionItem)
  {
    a(paramVideoCollectionItem.key);
    paramVideoCollectionItem = (VideoCollectionItem)this.c.a(paramVideoCollectionItem.key, paramVideoCollectionItem);
    EntityManager localEntityManager = b().getEntityManagerFactory().createEntityManager();
    if (localEntityManager.update(paramVideoCollectionItem.convertTo())) {
      a(localEntityManager, paramVideoCollectionItem.key, paramVideoCollectionItem.videoVidList, true);
    }
    return paramVideoCollectionItem;
  }
  
  @Nullable
  public VideoCollectionItem a(String paramString)
  {
    rom.checkNotNull(paramString);
    if (paramString == null) {
      localObject1 = null;
    }
    do
    {
      return localObject1;
      localObject2 = (VideoCollectionItem)this.c.a(paramString);
      localObject1 = localObject2;
    } while (localObject2 != null);
    Object localObject1 = b().getEntityManagerFactory().createEntityManager();
    paramString = a((EntityManager)localObject1, VideoCollectionEntry.class, VideoCollectionEntry.class.getSimpleName(), VideoCollectionEntry.getKeySelectionNoArgs(), new String[] { paramString });
    if ((paramString == null) || (paramString.size() == 0)) {
      return null;
    }
    paramString = new VideoCollectionItem((VideoCollectionEntry)paramString.get(0));
    Object localObject2 = a((EntityManager)localObject1, StoryVideoListEntry.class, StoryVideoListEntry.class.getSimpleName(), StoryVideoListEntry.getCollectionSelectionNoArg(), new String[] { String.valueOf(5), paramString.key });
    if (localObject2 != null)
    {
      localObject1 = (psu)psx.a(5);
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = ((StoryVideoListEntry)((Iterator)localObject2).next()).vid;
        StoryVideoItem localStoryVideoItem = ((psu)localObject1).a(str);
        paramString.videoVidList.add(str);
        paramString.collectionVideoUIItemList.add(new VideoCollectionItem.b(str, localStoryVideoItem));
      }
    }
    this.c.a(paramString.key, paramString);
    return paramString;
  }
  
  public ArrayList<String> a(String paramString, ArrayList<String> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = b().getEntityManagerFactory().createEntityManager().query(VideoCollectionEntry.class, VideoCollectionEntry.class.getSimpleName(), true, VideoCollectionEntry.getUinSelectionNoArgs(), new String[] { paramString }, null, null, "dbIndex asc", null);
    if ((paramString == null) || (paramString.size() == 0)) {
      return localArrayList;
    }
    paramString = paramString.iterator();
    while (paramString.hasNext())
    {
      VideoCollectionEntry localVideoCollectionEntry = (VideoCollectionEntry)paramString.next();
      if (localVideoCollectionEntry.collectionType == 1)
      {
        localArrayList.add(localVideoCollectionEntry.key);
        paramArrayList.add(localVideoCollectionEntry.feedId);
      }
    }
    return localArrayList;
  }
  
  public List<VideoCollectionItem> a(String paramString, VideoCollectionItem paramVideoCollectionItem, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    EntityManager localEntityManager = b().getEntityManagerFactory().createEntityManager();
    String str1 = VideoCollectionEntry.getQueryListSql();
    if (paramVideoCollectionItem == null) {}
    for (long l = -1L;; l = paramVideoCollectionItem.dbIndex)
    {
      paramVideoCollectionItem = VideoCollectionEntry.class.getSimpleName();
      String str2 = VideoCollectionEntry.getQueryListSql();
      String str3 = "" + paramLong;
      paramString = localEntityManager.query(VideoCollectionEntry.class, paramVideoCollectionItem, true, str2, new String[] { paramString, String.valueOf(l) }, null, null, "dbIndex asc", str3);
      if (paramString != null) {
        break;
      }
      return localArrayList;
    }
    ram.b("MemoryManager", "query sql = %s , resultCount = %d", str1, Integer.valueOf(paramString.size()));
    paramString = paramString.iterator();
    while (paramString.hasNext())
    {
      paramVideoCollectionItem = a(((VideoCollectionEntry)paramString.next()).key);
      if (paramVideoCollectionItem != null) {
        a(localArrayList, paramVideoCollectionItem);
      }
    }
    return localArrayList;
  }
  
  public void a(VideoCollectionItem paramVideoCollectionItem)
  {
    EntityManager localEntityManager = b().getEntityManagerFactory().createEntityManager();
    paramVideoCollectionItem = a(localEntityManager, VideoCollectionEntry.class, VideoCollectionEntry.class.getSimpleName(), VideoCollectionEntry.getKeySelectionNoArgs(), new String[] { paramVideoCollectionItem.key });
    if (paramVideoCollectionItem != null)
    {
      paramVideoCollectionItem = paramVideoCollectionItem.iterator();
      while (paramVideoCollectionItem.hasNext())
      {
        VideoCollectionEntry localVideoCollectionEntry = (VideoCollectionEntry)paramVideoCollectionItem.next();
        localVideoCollectionEntry.setStatus(1001);
        localEntityManager.remove(localVideoCollectionEntry);
      }
    }
  }
  
  protected void a(EntityManager paramEntityManager, String paramString, List<String> paramList, boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = new StoryVideoListEntry();
      ((StoryVideoListEntry)localObject).setStatus(1001);
      paramEntityManager.remove((Entity)localObject, StoryVideoListEntry.getCollectionSelectionNoArg(), new String[] { String.valueOf(5), paramString });
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (String)paramList.next();
      StoryVideoListEntry localStoryVideoListEntry = new StoryVideoListEntry();
      localStoryVideoListEntry.listType = 5;
      localStoryVideoListEntry.collectionKey = paramString;
      localStoryVideoListEntry.vid = ((String)localObject);
      paramEntityManager.persistOrReplace(localStoryVideoListEntry);
    }
  }
  
  protected void a(List<VideoCollectionItem> paramList, VideoCollectionItem paramVideoCollectionItem)
  {
    if (paramList.indexOf(paramVideoCollectionItem) > 0) {
      ram.d("MemoryManager", "data already exist, id=%s, time=%d", paramVideoCollectionItem.collectionId, Long.valueOf(paramVideoCollectionItem.collectionTime));
    }
    int i;
    do
    {
      return;
      i = Collections.binarySearch(paramList, paramVideoCollectionItem, this.a);
    } while (i >= 0);
    paramList.add(-i - 1, paramVideoCollectionItem);
  }
  
  protected QQStoryContext b()
  {
    return QQStoryContext.a();
  }
  
  public List<MomeriesYearNode> bK()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = psu.a(QQStoryContext.a().getEntityManagerFactory().createEntityManager(), MemoriesYearNodeEntry.class, MemoriesYearNodeEntry.class.getSimpleName(), null, null);
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      MemoriesYearNodeEntry localMemoriesYearNodeEntry = (MemoriesYearNodeEntry)((Iterator)localObject).next();
      MomeriesYearNode localMomeriesYearNode = new MomeriesYearNode();
      localMomeriesYearNode.convertFrom(localMemoriesYearNodeEntry);
      localArrayList.add(localMomeriesYearNode);
    }
    return localArrayList;
  }
  
  public void c(List<VideoCollectionItem> paramList, String paramString, boolean paramBoolean)
  {
    psu localpsu = (psu)psx.a(5);
    EntityManager localEntityManager = b().getEntityManagerFactory().createEntityManager();
    EntityTransaction localEntityTransaction = localEntityManager.getTransaction();
    Object localObject;
    try
    {
      localEntityTransaction.begin();
      if (paramBoolean)
      {
        localObject = a(localEntityManager, VideoCollectionEntry.class, VideoCollectionEntry.class.getSimpleName(), VideoCollectionEntry.getUinSelectionNoArgs(), new String[] { paramString });
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            VideoCollectionEntry localVideoCollectionEntry = (VideoCollectionEntry)((Iterator)localObject).next();
            localVideoCollectionEntry.setStatus(1001);
            localEntityManager.remove(localVideoCollectionEntry);
          }
        }
      }
      localObject = a(pxg.fT(paramString));
    }
    finally
    {
      localEntityTransaction.end();
    }
    if (localObject == null) {}
    for (paramString = new MemoryInfoEntry(paramString);; paramString = (String)localObject)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (VideoCollectionItem)paramList.next();
        long l = paramString.maxCollectionIndex + 1L;
        paramString.maxCollectionIndex = l;
        ((VideoCollectionItem)localObject).dbIndex = l;
        localObject = (VideoCollectionItem)this.c.a(((VideoCollectionItem)localObject).key, (plu)localObject);
        ((VideoCollectionItem)localObject).videoItemList = localpsu.al(((VideoCollectionItem)localObject).videoItemList);
        a(localEntityManager, ((VideoCollectionItem)localObject).key, ((VideoCollectionItem)localObject).videoVidList, true);
        a(((VideoCollectionItem)localObject).key);
        localEntityManager.persistOrReplace(((VideoCollectionItem)this.c.a(((VideoCollectionItem)localObject).key, (plu)localObject)).convertTo());
      }
      localEntityTransaction.commit();
      a(paramString);
      localEntityTransaction.end();
      return;
    }
  }
  
  public void d(List<ShareGroupCollectionItem> paramList, String paramString, boolean paramBoolean)
  {
    psu localpsu = (psu)psx.a(5);
    qqe localqqe = (qqe)psx.a(7);
    EntityManager localEntityManager = b().getEntityManagerFactory().createEntityManager();
    EntityTransaction localEntityTransaction = localEntityManager.getTransaction();
    try
    {
      localEntityTransaction.begin();
      if (paramBoolean)
      {
        paramString = a(localEntityManager, VideoCollectionEntry.class, VideoCollectionEntry.class.getSimpleName(), "unionId=? and collectionType=?", new String[] { paramString, String.valueOf(4) });
        if (paramString != null)
        {
          paramString = paramString.iterator();
          while (paramString.hasNext())
          {
            VideoCollectionEntry localVideoCollectionEntry = (VideoCollectionEntry)paramString.next();
            localVideoCollectionEntry.setStatus(1001);
            localEntityManager.remove(localVideoCollectionEntry);
          }
        }
      }
      paramList = paramList.iterator();
    }
    finally
    {
      localEntityTransaction.end();
    }
    while (paramList.hasNext())
    {
      paramString = (ShareGroupCollectionItem)paramList.next();
      paramString = (ShareGroupCollectionItem)this.c.a(paramString.key, paramString);
      paramString.shareGroupItem = localqqe.a(paramString.shareGroupItem);
      paramString.videoItemList = localpsu.al(paramString.videoItemList);
      a(localEntityManager, paramString.key, paramString.videoVidList, true);
      localEntityManager.persistOrReplace(paramString.convertTo());
    }
    localEntityTransaction.commit();
    localEntityTransaction.end();
  }
  
  public void onDestroy()
  {
    this.c.trimToSize(20);
  }
  
  public void onInit() {}
  
  public void z(List<MomeriesYearNode> paramList, boolean paramBoolean)
  {
    EntityManager localEntityManager = QQStoryContext.a().getEntityManagerFactory().createEntityManager();
    localEntityManager.getTransaction().begin();
    if (paramBoolean) {}
    try
    {
      localEntityManager.drop(MemoriesFeedIdListEntry.class);
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localEntityManager.persistOrReplace(((MomeriesYearNode)paramList.next()).convertTo());
      }
    }
    finally
    {
      localEntityManager.getTransaction().end();
    }
    localEntityManager.getTransaction().end();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     psn
 * JD-Core Version:    0.7.0.1
 */