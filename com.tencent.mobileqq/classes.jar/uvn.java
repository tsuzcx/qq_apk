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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class uvn
  implements uvi
{
  protected ulk<String, VideoCollectionItem> a;
  protected wnc a;
  protected ulk<String, MemoryInfoEntry> b = new ulk(300);
  
  public uvn()
  {
    this.jdField_a_of_type_Ulk = new ulk(300);
    this.jdField_a_of_type_Wnc = new wnc();
  }
  
  protected static List<? extends awge> a(awgf paramawgf, Class<? extends awge> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramawgf.a(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  protected QQStoryContext a()
  {
    return QQStoryContext.a();
  }
  
  public MemoryInfoEntry a(MemoryInfoEntry paramMemoryInfoEntry)
  {
    a(paramMemoryInfoEntry.unionId);
    paramMemoryInfoEntry = (MemoryInfoEntry)this.b.a(paramMemoryInfoEntry.unionId, paramMemoryInfoEntry);
    MemoryInfoEntry localMemoryInfoEntry = new MemoryInfoEntry();
    localMemoryInfoEntry.copy(paramMemoryInfoEntry);
    a().a().createEntityManager().b(localMemoryInfoEntry);
    return localMemoryInfoEntry;
  }
  
  public MemoryInfoEntry a(String paramString)
  {
    MemoryInfoEntry localMemoryInfoEntry = (MemoryInfoEntry)this.b.a(paramString);
    if (localMemoryInfoEntry != null) {
      return localMemoryInfoEntry;
    }
    paramString = a(a().a().createEntityManager(), MemoryInfoEntry.class, MemoryInfoEntry.class.getSimpleName(), MemoryInfoEntry.getUnionIdSelectionNoArg(), new String[] { String.valueOf(paramString) });
    if ((paramString == null) || (paramString.size() == 0)) {
      return null;
    }
    paramString = (MemoryInfoEntry)paramString.get(0);
    this.b.a(paramString.unionId, paramString);
    return paramString;
  }
  
  public ShareGroupCollectionItem a(String paramString)
  {
    xqq.a(paramString);
    if (paramString == null) {
      localObject = null;
    }
    do
    {
      return localObject;
      localShareGroupCollectionItem = (ShareGroupCollectionItem)this.jdField_a_of_type_Ulk.a(paramString);
      localObject = localShareGroupCollectionItem;
    } while (localShareGroupCollectionItem != null);
    Object localObject = a().a().createEntityManager();
    paramString = a((awgf)localObject, VideoCollectionEntry.class, VideoCollectionEntry.class.getSimpleName(), VideoCollectionEntry.getKeySelectionNoArgs(), new String[] { paramString });
    if ((paramString == null) || (paramString.size() == 0)) {
      return null;
    }
    ShareGroupCollectionItem localShareGroupCollectionItem = new ShareGroupCollectionItem((VideoCollectionEntry)paramString.get(0));
    paramString = ((wfw)uwa.a(7)).a(localShareGroupCollectionItem.groupId);
    if (paramString == null) {
      return null;
    }
    localShareGroupCollectionItem.shareGroupItem = paramString;
    paramString = a((awgf)localObject, StoryVideoListEntry.class, StoryVideoListEntry.class.getSimpleName(), StoryVideoListEntry.getCollectionSelectionNoArg(), new String[] { String.valueOf(5), localShareGroupCollectionItem.key });
    if (paramString != null)
    {
      uvx localuvx = (uvx)uwa.a(5);
      Iterator localIterator = paramString.iterator();
      while (localIterator.hasNext())
      {
        StoryVideoListEntry localStoryVideoListEntry = (StoryVideoListEntry)localIterator.next();
        localObject = localuvx.a(localStoryVideoListEntry.vid);
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
    this.jdField_a_of_type_Ulk.a(localShareGroupCollectionItem.key, localShareGroupCollectionItem);
    return localShareGroupCollectionItem;
  }
  
  public VideoCollectionItem a(@NonNull VideoCollectionItem paramVideoCollectionItem)
  {
    a(paramVideoCollectionItem.key);
    paramVideoCollectionItem = (VideoCollectionItem)this.jdField_a_of_type_Ulk.a(paramVideoCollectionItem.key, paramVideoCollectionItem);
    awgf localawgf = a().a().createEntityManager();
    if (localawgf.a(paramVideoCollectionItem.convertTo())) {
      a(localawgf, paramVideoCollectionItem.key, paramVideoCollectionItem.videoVidList, true);
    }
    return paramVideoCollectionItem;
  }
  
  @Nullable
  public VideoCollectionItem a(String paramString)
  {
    xqq.a(paramString);
    if (paramString == null) {
      localObject1 = null;
    }
    do
    {
      return localObject1;
      localObject2 = (VideoCollectionItem)this.jdField_a_of_type_Ulk.a(paramString);
      localObject1 = localObject2;
    } while (localObject2 != null);
    Object localObject1 = a().a().createEntityManager();
    paramString = a((awgf)localObject1, VideoCollectionEntry.class, VideoCollectionEntry.class.getSimpleName(), VideoCollectionEntry.getKeySelectionNoArgs(), new String[] { paramString });
    if ((paramString == null) || (paramString.size() == 0)) {
      return null;
    }
    paramString = new VideoCollectionItem((VideoCollectionEntry)paramString.get(0));
    Object localObject2 = a((awgf)localObject1, StoryVideoListEntry.class, StoryVideoListEntry.class.getSimpleName(), StoryVideoListEntry.getCollectionSelectionNoArg(), new String[] { String.valueOf(5), paramString.key });
    if (localObject2 != null)
    {
      localObject1 = (uvx)uwa.a(5);
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = ((StoryVideoListEntry)((Iterator)localObject2).next()).vid;
        StoryVideoItem localStoryVideoItem = ((uvx)localObject1).a(str);
        paramString.videoVidList.add(str);
        paramString.collectionVideoUIItemList.add(new wnd(str, localStoryVideoItem));
      }
    }
    this.jdField_a_of_type_Ulk.a(paramString.key, paramString);
    return paramString;
  }
  
  public ArrayList<String> a(String paramString, ArrayList<String> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = a().a().createEntityManager().a(VideoCollectionEntry.class, VideoCollectionEntry.class.getSimpleName(), true, VideoCollectionEntry.getUinSelectionNoArgs(), new String[] { paramString }, null, null, "dbIndex asc", null);
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
  
  public List<MomeriesYearNode> a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = uvx.a(QQStoryContext.a().a().createEntityManager(), MemoriesYearNodeEntry.class, MemoriesYearNodeEntry.class.getSimpleName(), null, null);
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
  
  public List<String> a(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.videoVidList;
    }
    return new ArrayList();
  }
  
  public List<VideoCollectionItem> a(String paramString, VideoCollectionItem paramVideoCollectionItem, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    awgf localawgf = a().a().createEntityManager();
    String str1 = VideoCollectionEntry.getQueryListSql();
    if (paramVideoCollectionItem == null) {}
    for (long l = -1L;; l = paramVideoCollectionItem.dbIndex)
    {
      paramVideoCollectionItem = VideoCollectionEntry.class.getSimpleName();
      String str2 = VideoCollectionEntry.getQueryListSql();
      String str3 = "" + paramLong;
      paramString = localawgf.a(VideoCollectionEntry.class, paramVideoCollectionItem, true, str2, new String[] { paramString, String.valueOf(l) }, null, null, "dbIndex asc", str3);
      if (paramString != null) {
        break;
      }
      return localArrayList;
    }
    wxe.a("MemoryManager", "query sql = %s , resultCount = %d", str1, Integer.valueOf(paramString.size()));
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
  
  public void a() {}
  
  protected void a(awgf paramawgf, String paramString, List<String> paramList, boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = new StoryVideoListEntry();
      ((StoryVideoListEntry)localObject).setStatus(1001);
      paramawgf.a((awge)localObject, StoryVideoListEntry.getCollectionSelectionNoArg(), new String[] { String.valueOf(5), paramString });
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (String)paramList.next();
      StoryVideoListEntry localStoryVideoListEntry = new StoryVideoListEntry();
      localStoryVideoListEntry.listType = 5;
      localStoryVideoListEntry.collectionKey = paramString;
      localStoryVideoListEntry.vid = ((String)localObject);
      paramawgf.b(localStoryVideoListEntry);
    }
  }
  
  public void a(VideoCollectionItem paramVideoCollectionItem)
  {
    awgf localawgf = a().a().createEntityManager();
    paramVideoCollectionItem = a(localawgf, VideoCollectionEntry.class, VideoCollectionEntry.class.getSimpleName(), VideoCollectionEntry.getKeySelectionNoArgs(), new String[] { paramVideoCollectionItem.key });
    if (paramVideoCollectionItem != null)
    {
      paramVideoCollectionItem = paramVideoCollectionItem.iterator();
      while (paramVideoCollectionItem.hasNext())
      {
        VideoCollectionEntry localVideoCollectionEntry = (VideoCollectionEntry)paramVideoCollectionItem.next();
        localVideoCollectionEntry.setStatus(1001);
        localawgf.b(localVideoCollectionEntry);
      }
    }
  }
  
  protected void a(List<VideoCollectionItem> paramList, VideoCollectionItem paramVideoCollectionItem)
  {
    if (paramList.indexOf(paramVideoCollectionItem) > 0) {
      wxe.b("MemoryManager", "data already exist, id=%s, time=%d", paramVideoCollectionItem.collectionId, Long.valueOf(paramVideoCollectionItem.collectionTime));
    }
    int i;
    do
    {
      return;
      i = Collections.binarySearch(paramList, paramVideoCollectionItem, this.jdField_a_of_type_Wnc);
    } while (i >= 0);
    paramList.add(-i - 1, paramVideoCollectionItem);
  }
  
  public void a(List<VideoCollectionItem> paramList, String paramString, boolean paramBoolean)
  {
    uvx localuvx = (uvx)uwa.a(5);
    awgf localawgf = a().a().createEntityManager();
    awgh localawgh = localawgf.a();
    Object localObject;
    try
    {
      localawgh.a();
      if (paramBoolean)
      {
        localObject = a(localawgf, VideoCollectionEntry.class, VideoCollectionEntry.class.getSimpleName(), VideoCollectionEntry.getUinSelectionNoArgs(), new String[] { paramString });
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            VideoCollectionEntry localVideoCollectionEntry = (VideoCollectionEntry)((Iterator)localObject).next();
            localVideoCollectionEntry.setStatus(1001);
            localawgf.b(localVideoCollectionEntry);
          }
        }
      }
      localObject = a(vcg.a(paramString));
    }
    finally
    {
      localawgh.b();
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
        localObject = (VideoCollectionItem)this.jdField_a_of_type_Ulk.a(((VideoCollectionItem)localObject).key, (ulj)localObject);
        ((VideoCollectionItem)localObject).videoItemList = localuvx.a(((VideoCollectionItem)localObject).videoItemList);
        a(localawgf, ((VideoCollectionItem)localObject).key, ((VideoCollectionItem)localObject).videoVidList, true);
        a(((VideoCollectionItem)localObject).key);
        localawgf.b(((VideoCollectionItem)this.jdField_a_of_type_Ulk.a(((VideoCollectionItem)localObject).key, (ulj)localObject)).convertTo());
      }
      localawgh.c();
      a(paramString);
      localawgh.b();
      return;
    }
  }
  
  public void a(List<MomeriesYearNode> paramList, boolean paramBoolean)
  {
    awgf localawgf = QQStoryContext.a().a().createEntityManager();
    localawgf.a().a();
    if (paramBoolean) {}
    try
    {
      localawgf.a(MemoriesFeedIdListEntry.class);
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localawgf.b(((MomeriesYearNode)paramList.next()).convertTo());
      }
    }
    finally
    {
      localawgf.a().b();
    }
    localawgf.a().b();
  }
  
  public List<ShareGroupCollectionItem> b(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = a(a().a().createEntityManager(), VideoCollectionEntry.class, VideoCollectionEntry.class.getSimpleName(), "unionId=? and collectionType=?", new String[] { paramString, String.valueOf(4) });
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
  
  public void b()
  {
    this.jdField_a_of_type_Ulk.a(20);
  }
  
  public void b(List<ShareGroupCollectionItem> paramList, String paramString, boolean paramBoolean)
  {
    uvx localuvx = (uvx)uwa.a(5);
    wfw localwfw = (wfw)uwa.a(7);
    awgf localawgf = a().a().createEntityManager();
    awgh localawgh = localawgf.a();
    try
    {
      localawgh.a();
      if (paramBoolean)
      {
        paramString = a(localawgf, VideoCollectionEntry.class, VideoCollectionEntry.class.getSimpleName(), "unionId=? and collectionType=?", new String[] { paramString, String.valueOf(4) });
        if (paramString != null)
        {
          paramString = paramString.iterator();
          while (paramString.hasNext())
          {
            VideoCollectionEntry localVideoCollectionEntry = (VideoCollectionEntry)paramString.next();
            localVideoCollectionEntry.setStatus(1001);
            localawgf.b(localVideoCollectionEntry);
          }
        }
      }
      paramList = paramList.iterator();
    }
    finally
    {
      localawgh.b();
    }
    while (paramList.hasNext())
    {
      paramString = (ShareGroupCollectionItem)paramList.next();
      paramString = (ShareGroupCollectionItem)this.jdField_a_of_type_Ulk.a(paramString.key, paramString);
      paramString.shareGroupItem = localwfw.a(paramString.shareGroupItem);
      paramString.videoItemList = localuvx.a(paramString.videoItemList);
      a(localawgf, paramString.key, paramString.videoVidList, true);
      localawgf.b(paramString.convertTo());
    }
    localawgh.c();
    localawgh.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uvn
 * JD-Core Version:    0.7.0.1
 */