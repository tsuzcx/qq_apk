import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.FeedEntry;
import com.tencent.biz.qqstory.database.FeedIdListEntry;
import com.tencent.biz.qqstory.database.MemoriesFeedIdListEntry;
import com.tencent.biz.qqstory.database.TroopAssistantFeedIdListEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedManager.1;
import com.tencent.biz.qqstory.storyHome.model.FeedManager.2;
import com.tencent.biz.qqstory.storyHome.model.FeedManager.3;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import com.tencent.biz.qqstory.storyHome.model.ShareGroupFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ljava.lang.String;>;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class uvx
  implements IEventReceiver, tch
{
  public static ThreadLocal<SimpleDateFormat> a;
  private static ConcurrentHashMap<String, Long> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public int a;
  private long jdField_a_of_type_Long;
  public ArrayList<uxm> a;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public Map<String, String> a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private ssj<String, FeedItem> jdField_a_of_type_Ssj = new ssj(300);
  public ter a;
  private ujl jdField_a_of_type_Ujl = new ujl("feeItem");
  private uvi jdField_a_of_type_Uvi = new uvi();
  public uvt a;
  private uwa jdField_a_of_type_Uwa;
  private uwb jdField_a_of_type_Uwb;
  public boolean a;
  public int b;
  private ConcurrentHashMap<String, tec> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public uvt b;
  private boolean jdField_b_of_type_Boolean = true;
  
  static
  {
    jdField_a_of_type_JavaLangThreadLocal = new ThreadLocal();
  }
  
  public uvx()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(0);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  private FeedEntry a(String paramString)
  {
    paramString = tcw.a(QQStoryContext.a().a().createEntityManager(), FeedEntry.class, FeedEntry.class.getSimpleName(), FeedEntry.queryFeedId(), new String[] { paramString });
    if ((paramString != null) && (paramString.size() == 1)) {
      return (FeedEntry)paramString.get(0);
    }
    return null;
  }
  
  private static FeedItem a(boolean paramBoolean, String paramString1, String paramString2)
  {
    uvx localuvx = (uvx)tcz.a(11);
    Object localObject2 = localuvx.a(paramString1, paramString2);
    ved.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "find true feedId:%s", localObject2);
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = VideoListFeedItem.makeFakeFeedId(paramString1, paramString2);
      ved.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "make fake feedId:%s", localObject1);
    }
    localObject2 = localuvx.a((String)localObject1);
    localObject1 = localObject2;
    if (localObject2 == null) {
      if (!paramBoolean) {
        break label101;
      }
    }
    label101:
    for (paramString1 = ShareGroupFeedItem.createFakeFeedItem(paramString1, paramString2);; paramString1 = GeneralFeedItem.createFakeFeedItem(paramString2))
    {
      localuvx.a(paramString1);
      ved.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "save fake item %s", paramString1.feedId);
      localObject1 = paramString1;
      return localObject1;
    }
  }
  
  public static GeneralFeedItem a(String paramString1, String paramString2)
  {
    paramString1 = a(false, paramString1, paramString2);
    if ((paramString1 != null) && ((paramString1 instanceof GeneralFeedItem))) {
      return (GeneralFeedItem)paramString1;
    }
    vxp.a(paramString1);
    return null;
  }
  
  public static ShareGroupFeedItem a(String paramString1, String paramString2)
  {
    paramString1 = a(true, paramString1, paramString2);
    if (paramString1 == null) {}
    while (!(paramString1 instanceof ShareGroupFeedItem))
    {
      vxp.a("feed type wrong for shareGroupItem:%s", new Object[] { paramString1 });
      return null;
    }
    return (ShareGroupFeedItem)paramString1;
  }
  
  public static VideoListFeedItem a(String paramString1, String paramString2)
  {
    paramString1 = a(true, paramString1, paramString2);
    if (paramString1 == null) {}
    while (!(paramString1 instanceof ShareGroupFeedItem))
    {
      vxp.a("feed type wrong for shareGroupItem:%s", new Object[] { paramString1 });
      return null;
    }
    return (ShareGroupFeedItem)paramString1;
  }
  
  public static String a()
  {
    return a().format(new Date(NetConnInfoCenter.getServerTimeMillis()));
  }
  
  public static SimpleDateFormat a()
  {
    SimpleDateFormat localSimpleDateFormat2 = (SimpleDateFormat)jdField_a_of_type_JavaLangThreadLocal.get();
    SimpleDateFormat localSimpleDateFormat1 = localSimpleDateFormat2;
    if (localSimpleDateFormat2 == null)
    {
      localSimpleDateFormat1 = new SimpleDateFormat("yyyyMMdd");
      jdField_a_of_type_JavaLangThreadLocal.set(localSimpleDateFormat1);
    }
    return localSimpleDateFormat1;
  }
  
  private void a(tlw paramtlw)
  {
    ved.a("Q.qqstory.home.data.FeedManager", "request feed item list from net, %s", paramtlw.b);
    syo.a().a(paramtlw, new uvz(this));
  }
  
  public static void b(String paramString)
  {
    Bosses.get().postLightWeightJob(new FeedManager.1(paramString), 10);
  }
  
  public static void d()
  {
    tjn.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    twd.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public FeedItem a(FeedItem paramFeedItem)
  {
    ved.a("Q.qqstory.home.data.FeedManager", "save feed item %s", paramFeedItem.feedId);
    paramFeedItem = (FeedItem)this.jdField_a_of_type_Ssj.a(paramFeedItem.feedId, paramFeedItem);
    FeedEntry localFeedEntry = paramFeedItem.covertToEntry();
    QQStoryContext.a().a().createEntityManager().b(localFeedEntry);
    return paramFeedItem;
  }
  
  public FeedItem a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      ved.e("Q.qqstory.home.data.FeedManager", "feedId is null,you cant queryFeedItem:" + vyd.a(3));
      localObject = null;
    }
    do
    {
      return localObject;
      localFeedItem = (FeedItem)this.jdField_a_of_type_Ssj.a(paramString);
      localObject = localFeedItem;
    } while (localFeedItem != null);
    Object localObject = a(paramString);
    if (localObject == null) {
      return null;
    }
    FeedItem localFeedItem = FeedItem.createFeedItemByType(((FeedEntry)localObject).type);
    if (localFeedItem == null)
    {
      ved.e("Q.qqstory.home.data.FeedManager", "这种类型目前还不支持：" + ((FeedEntry)localObject).type);
      return null;
    }
    localFeedItem.covertFromEntry((FeedEntry)localObject);
    return (FeedItem)this.jdField_a_of_type_Ssj.a(paramString, localFeedItem);
  }
  
  @Nullable
  public FeedItem a(@NonNull String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    FeedItem localFeedItem = b(paramString);
    if (localFeedItem != null) {
      return localFeedItem;
    }
    Bosses.get().postLightWeightJob(new FeedManager.3(this, paramString, paramBoolean), 0);
    return null;
  }
  
  public String a(String paramString1, String paramString2)
  {
    ved.a("Q.qqstory.home.data.FeedManager", "query my feedId unionId:%s, date:%s %s", paramString1, paramString2, this.jdField_a_of_type_JavaUtilHashMap);
    return (String)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1 + paramString2);
  }
  
  public List<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = tcw.a(QQStoryContext.a().a().createEntityManager(), FeedIdListEntry.class, FeedIdListEntry.class.getSimpleName(), null, null);
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((FeedIdListEntry)((Iterator)localObject).next()).feedId);
    }
    return localArrayList;
  }
  
  public List<StoryVideoItem> a(String paramString, List<StoryVideoItem> paramList, boolean paramBoolean)
  {
    return ((tcw)tcz.a(5)).a(paramString, 0, paramList, paramBoolean);
  }
  
  public List<FeedItem> a(List<FeedItem> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    aukp localaukp = QQStoryContext.a().a().createEntityManager();
    localaukp.a().a();
    try
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        FeedItem localFeedItem = (FeedItem)paramList.next();
        localFeedItem = (FeedItem)this.jdField_a_of_type_Ssj.a(localFeedItem.feedId, localFeedItem);
        localaukp.b(localFeedItem.covertToEntry());
        localArrayList.add(localFeedItem);
      }
    }
    finally
    {
      localaukp.a().b();
    }
    localaukp.a().b();
    return localArrayList;
  }
  
  public tec a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    tec localtec = (tec)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (this.jdField_a_of_type_Uwb == null)
    {
      this.jdField_a_of_type_Uwb = new uwb(this);
      stb.a().registerSubscriber(this.jdField_a_of_type_Uwb);
    }
    new tjn(Collections.singletonList(paramString), true).a();
    ved.a("Q.qqstory.home.data.FeedManager", "request feed feature : %s", paramString);
    return localtec;
  }
  
  public uvi a()
  {
    return this.jdField_a_of_type_Uvi;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Uwa = new uwa(this);
    stb.a().registerSubscriber(this.jdField_a_of_type_Uwa);
  }
  
  public void a(String paramString)
  {
    FeedEntry localFeedEntry = a(paramString);
    if (localFeedEntry != null)
    {
      localFeedEntry.setStatus(1001);
      QQStoryContext.a().a().createEntityManager().b(localFeedEntry);
    }
    this.jdField_a_of_type_Ssj.a(paramString);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString1 + paramString2, paramString3);
    ved.a("Q.qqstory.home.data.FeedManager", "save my feedId %s", this.jdField_a_of_type_JavaUtilHashMap);
  }
  
  public void a(List<uvp> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      uvp localuvp = (uvp)paramList.next();
      this.jdField_a_of_type_JavaUtilHashMap.put(localuvp.b + localuvp.c, localuvp.a);
    }
  }
  
  public void a(List<String> paramList, boolean paramBoolean)
  {
    aukp localaukp = QQStoryContext.a().a().createEntityManager();
    localaukp.a().a();
    if (paramBoolean) {}
    try
    {
      localaukp.a(FeedIdListEntry.class);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        FeedIdListEntry localFeedIdListEntry = new FeedIdListEntry();
        localFeedIdListEntry.feedId = str;
        localaukp.b(localFeedIdListEntry);
      }
    }
    finally
    {
      localaukp.a().b();
    }
    localaukp.a().b();
  }
  
  public boolean a(String paramString)
  {
    FeedIdListEntry localFeedIdListEntry = new FeedIdListEntry();
    localFeedIdListEntry.feedId = paramString;
    aukp localaukp = QQStoryContext.a().a().createEntityManager();
    localFeedIdListEntry.setStatus(1001);
    return localaukp.a(localFeedIdListEntry, "feedId=?", new String[] { paramString });
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = tcw.a(QQStoryContext.a().a().createEntityManager(), FeedIdListEntry.class, FeedIdListEntry.class.getSimpleName(), null, null);
    if (localList == null) {
      return false;
    }
    int i = 0;
    boolean bool = false;
    if (i < localList.size())
    {
      FeedIdListEntry localFeedIdListEntry = (FeedIdListEntry)localList.get(i);
      if (localFeedIdListEntry.feedId.equals(paramString1))
      {
        localArrayList.add(paramString2);
        bool = true;
      }
      for (;;)
      {
        i += 1;
        break;
        localArrayList.add(localFeedIdListEntry.feedId);
      }
    }
    if (bool) {
      a(localArrayList, true);
    }
    return bool;
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    ved.a("Q.qqstory.home.position", "disableAutoRefresh mIsFirstTimeUse:%b, fromOldLeba:%b, hasRedPoint:%b, mLastViewTime:%d", Boolean.valueOf(this.jdField_b_of_type_Boolean), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Long.valueOf(this.jdField_a_of_type_Long));
    if ((!this.jdField_b_of_type_Boolean) && (paramBoolean1) && (!paramBoolean2) && (this.jdField_a_of_type_Long > 0L))
    {
      long l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      long l2 = ((Long)((tcs)tcz.a(10)).b("key_disable_auto_refresh_time", Long.valueOf(60000L))).longValue();
      ved.a("Q.qqstory.home.position", "disableAutoRefresh duration:%d, severConfigTime:%d", Long.valueOf(l1), Long.valueOf(l2));
      if (l1 < l2)
      {
        this.jdField_a_of_type_Long = 0L;
        return true;
      }
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    return false;
  }
  
  public FeedItem b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      ved.e("Q.qqstory.home.data.FeedManager", "feedId is null,you cant queryFeedItem:" + vyd.a(3));
      return null;
    }
    return (FeedItem)this.jdField_a_of_type_Ssj.a(paramString);
  }
  
  public List<String> b()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = tcw.a(QQStoryContext.a().a().createEntityManager(), TroopAssistantFeedIdListEntry.class, TroopAssistantFeedIdListEntry.class.getSimpleName(), null, null);
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((TroopAssistantFeedIdListEntry)((Iterator)localObject).next()).feedId);
    }
    return localArrayList;
  }
  
  public List<uxm> b(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = (FeedItem)this.jdField_a_of_type_Ssj.a(str);
      paramList = (List<String>)localObject;
      if (localObject == null)
      {
        localObject = a(str);
        if (localObject != null)
        {
          paramList = FeedItem.createFeedItemByType(((FeedEntry)localObject).type);
          if (paramList == null)
          {
            ved.e("Q.qqstory.home.data.FeedManager", "这种类型目前还不支持：" + ((FeedEntry)localObject).type);
          }
          else
          {
            paramList.covertFromEntry((FeedEntry)localObject);
            this.jdField_a_of_type_Ssj.a(str, paramList);
          }
        }
      }
      else
      {
        localArrayList.add(paramList.generateAndPackageHomeFeedFromDB());
      }
    }
    return localArrayList;
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (this.jdField_a_of_type_Uwb != null) {
      stb.a().unRegisterSubscriber(this.jdField_a_of_type_Uwb);
    }
    if (this.jdField_a_of_type_Uwa != null) {
      stb.a().unRegisterSubscriber(this.jdField_a_of_type_Uwa);
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public void b(@NonNull List<String> paramList)
  {
    Object localObject1 = new tlw();
    Iterator localIterator = paramList.iterator();
    paramList = (List<String>)localObject1;
    while (localIterator.hasNext())
    {
      localObject1 = (String)localIterator.next();
      if (a((String)localObject1) == null)
      {
        Object localObject2 = (Long)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject1);
        if ((localObject2 != null) && (Math.abs(System.currentTimeMillis() - ((Long)localObject2).longValue()) < 300000L))
        {
          ved.a("Q.qqstory.home.data.FeedManager", "request feed item list, ignore same request %s", localObject1);
        }
        else
        {
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject1, Long.valueOf(System.currentTimeMillis()));
          localObject2 = new uvp((String)localObject1, 0, "", "");
          paramList.a.add(localObject2);
          paramList.b.add(localObject1);
          if (paramList.a.size() <= 3) {
            break label194;
          }
          a(paramList);
          paramList = new tlw();
        }
      }
    }
    label194:
    for (;;)
    {
      break;
      if (paramList.a.size() == 0) {
        return;
      }
      a(paramList);
      return;
    }
  }
  
  public void b(List<String> paramList, boolean paramBoolean)
  {
    aukp localaukp = QQStoryContext.a().a().createEntityManager();
    localaukp.a().a();
    if (paramBoolean) {}
    try
    {
      localaukp.a(TroopAssistantFeedIdListEntry.class);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        TroopAssistantFeedIdListEntry localTroopAssistantFeedIdListEntry = new TroopAssistantFeedIdListEntry();
        localTroopAssistantFeedIdListEntry.feedId = str;
        localaukp.b(localTroopAssistantFeedIdListEntry);
      }
    }
    finally
    {
      localaukp.a().b();
    }
    localaukp.a().b();
  }
  
  public FeedItem c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      ved.e("Q.qqstory.home.data.FeedManager", "feedId is null,you cant queryFeedItem:" + vyd.a(3));
    }
    do
    {
      return null;
      paramString = a(paramString);
    } while (paramString == null);
    FeedItem localFeedItem = FeedItem.createFeedItemByType(paramString.type);
    if (localFeedItem == null)
    {
      ved.e("Q.qqstory.home.data.FeedManager", "这种类型目前还不支持：" + paramString.type);
      return null;
    }
    localFeedItem.covertFromEntry(paramString);
    return localFeedItem;
  }
  
  public List<String> c()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = tcw.a(QQStoryContext.a().a().createEntityManager(), MemoriesFeedIdListEntry.class, MemoriesFeedIdListEntry.class.getSimpleName(), null, null);
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((MemoriesFeedIdListEntry)((Iterator)localObject).next()).feedId);
    }
    return localArrayList;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    long l = ((Long)((tcs)tcz.a(10)).b("key_disable_auto_refresh_time", Long.valueOf(60000L))).longValue();
    ThreadManager.getUIHandler().postDelayed(new FeedManager.2(this), l);
  }
  
  public void c(List<String> paramList, boolean paramBoolean)
  {
    aukp localaukp = QQStoryContext.a().a().createEntityManager();
    localaukp.a().a();
    if (paramBoolean) {}
    try
    {
      localaukp.a(MemoriesFeedIdListEntry.class);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        MemoriesFeedIdListEntry localMemoriesFeedIdListEntry = new MemoriesFeedIdListEntry();
        localMemoriesFeedIdListEntry.feedId = str;
        localaukp.b(localMemoriesFeedIdListEntry);
      }
    }
    finally
    {
      localaukp.a().b();
    }
    localaukp.a().b();
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uvx
 * JD-Core Version:    0.7.0.1
 */