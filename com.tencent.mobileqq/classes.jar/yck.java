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
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
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

public class yck
  implements IEventReceiver, wja
{
  public static ThreadLocal<SimpleDateFormat> a;
  private static ConcurrentHashMap<String, Long> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public int a;
  private long jdField_a_of_type_Long;
  public ArrayList<ydz> a;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public Map<String, String> a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private vzl<String, FeedItem> jdField_a_of_type_Vzl = new vzl(300);
  public wlk a;
  private xpy jdField_a_of_type_Xpy = new xpy("feeItem");
  private ybv jdField_a_of_type_Ybv = new ybv();
  public ycg a;
  private ycn jdField_a_of_type_Ycn;
  private yco jdField_a_of_type_Yco;
  public boolean a;
  public int b;
  private ConcurrentHashMap<String, wkv> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public ycg b;
  private boolean jdField_b_of_type_Boolean = true;
  
  static
  {
    jdField_a_of_type_JavaLangThreadLocal = new ThreadLocal();
  }
  
  public yck()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(0);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  private FeedEntry a(String paramString)
  {
    paramString = wjp.a(QQStoryContext.a().a().createEntityManager(), FeedEntry.class, FeedEntry.class.getSimpleName(), FeedEntry.queryFeedId(), new String[] { paramString });
    if ((paramString != null) && (paramString.size() == 1)) {
      return (FeedEntry)paramString.get(0);
    }
    return null;
  }
  
  private static FeedItem a(boolean paramBoolean, String paramString1, String paramString2)
  {
    yck localyck = (yck)wjs.a(11);
    Object localObject2 = localyck.a(paramString1, paramString2);
    ykq.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "find true feedId:%s", localObject2);
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = VideoListFeedItem.makeFakeFeedId(paramString1, paramString2);
      ykq.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "make fake feedId:%s", localObject1);
    }
    localObject2 = localyck.a((String)localObject1);
    localObject1 = localObject2;
    if (localObject2 == null) {
      if (!paramBoolean) {
        break label101;
      }
    }
    label101:
    for (paramString1 = ShareGroupFeedItem.createFakeFeedItem(paramString1, paramString2);; paramString1 = GeneralFeedItem.createFakeFeedItem(paramString2))
    {
      localyck.a(paramString1);
      ykq.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "save fake item %s", paramString1.feedId);
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
    zdl.a(paramString1);
    return null;
  }
  
  public static ShareGroupFeedItem a(String paramString1, String paramString2)
  {
    paramString1 = a(true, paramString1, paramString2);
    if (paramString1 == null) {}
    while (!(paramString1 instanceof ShareGroupFeedItem))
    {
      zdl.a("feed type wrong for shareGroupItem:%s", new Object[] { paramString1 });
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
      zdl.a("feed type wrong for shareGroupItem:%s", new Object[] { paramString1 });
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
  
  private void a(wsp paramwsp)
  {
    ykq.a("Q.qqstory.home.data.FeedManager", "request feed item list from net, %s", paramwsp.b);
    wfi.a().a(paramwsp, new ycm(this));
  }
  
  public static void b(String paramString)
  {
    Bosses.get().postLightWeightJob(new FeedManager.1(paramString), 10);
  }
  
  public static void d()
  {
    wqg.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    xcq.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public FeedItem a(FeedItem paramFeedItem)
  {
    ykq.a("Q.qqstory.home.data.FeedManager", "save feed item %s", paramFeedItem.feedId);
    paramFeedItem = (FeedItem)this.jdField_a_of_type_Vzl.a(paramFeedItem.feedId, paramFeedItem);
    FeedEntry localFeedEntry = paramFeedItem.covertToEntry();
    QQStoryContext.a().a().createEntityManager().persistOrReplace(localFeedEntry);
    return paramFeedItem;
  }
  
  public FeedItem a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      ykq.e("Q.qqstory.home.data.FeedManager", "feedId is null,you cant queryFeedItem:" + zdz.a(3));
      localObject = null;
    }
    do
    {
      return localObject;
      localFeedItem = (FeedItem)this.jdField_a_of_type_Vzl.a(paramString);
      localObject = localFeedItem;
    } while (localFeedItem != null);
    Object localObject = a(paramString);
    if (localObject == null) {
      return null;
    }
    FeedItem localFeedItem = FeedItem.createFeedItemByType(((FeedEntry)localObject).type);
    if (localFeedItem == null)
    {
      ykq.e("Q.qqstory.home.data.FeedManager", "这种类型目前还不支持：" + ((FeedEntry)localObject).type);
      return null;
    }
    localFeedItem.covertFromEntry((FeedEntry)localObject);
    return (FeedItem)this.jdField_a_of_type_Vzl.a(paramString, localFeedItem);
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
    ykq.a("Q.qqstory.home.data.FeedManager", "query my feedId unionId:%s, date:%s %s", paramString1, paramString2, this.jdField_a_of_type_JavaUtilHashMap);
    return (String)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1 + paramString2);
  }
  
  public List<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = wjp.a(QQStoryContext.a().a().createEntityManager(), FeedIdListEntry.class, FeedIdListEntry.class.getSimpleName(), null, null);
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
    return ((wjp)wjs.a(5)).a(paramString, 0, paramList, paramBoolean);
  }
  
  public List<FeedItem> a(List<FeedItem> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
    localEntityManager.getTransaction().begin();
    try
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        FeedItem localFeedItem = (FeedItem)paramList.next();
        localFeedItem = (FeedItem)this.jdField_a_of_type_Vzl.a(localFeedItem.feedId, localFeedItem);
        localEntityManager.persistOrReplace(localFeedItem.covertToEntry());
        localArrayList.add(localFeedItem);
      }
    }
    finally
    {
      localEntityManager.getTransaction().end();
    }
    localEntityManager.getTransaction().end();
    return localArrayList;
  }
  
  public wkv a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    wkv localwkv = (wkv)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (this.jdField_a_of_type_Yco == null)
    {
      this.jdField_a_of_type_Yco = new yco(this);
      wad.a().registerSubscriber(this.jdField_a_of_type_Yco);
    }
    new wqg(Collections.singletonList(paramString), true).a();
    ykq.a("Q.qqstory.home.data.FeedManager", "request feed feature : %s", paramString);
    return localwkv;
  }
  
  public ybv a()
  {
    return this.jdField_a_of_type_Ybv;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Ycn = new ycn(this);
    wad.a().registerSubscriber(this.jdField_a_of_type_Ycn);
  }
  
  public void a(String paramString)
  {
    FeedEntry localFeedEntry = a(paramString);
    if (localFeedEntry != null)
    {
      localFeedEntry.setStatus(1001);
      QQStoryContext.a().a().createEntityManager().remove(localFeedEntry);
    }
    this.jdField_a_of_type_Vzl.a(paramString);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString1 + paramString2, paramString3);
    ykq.a("Q.qqstory.home.data.FeedManager", "save my feedId %s", this.jdField_a_of_type_JavaUtilHashMap);
  }
  
  public void a(List<ycc> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ycc localycc = (ycc)paramList.next();
      this.jdField_a_of_type_JavaUtilHashMap.put(localycc.b + localycc.c, localycc.a);
    }
  }
  
  public void a(List<String> paramList, boolean paramBoolean)
  {
    EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
    localEntityManager.getTransaction().begin();
    if (paramBoolean) {}
    try
    {
      localEntityManager.drop(FeedIdListEntry.class);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        FeedIdListEntry localFeedIdListEntry = new FeedIdListEntry();
        localFeedIdListEntry.feedId = str;
        localEntityManager.persistOrReplace(localFeedIdListEntry);
      }
    }
    finally
    {
      localEntityManager.getTransaction().end();
    }
    localEntityManager.getTransaction().end();
  }
  
  public boolean a(String paramString)
  {
    FeedIdListEntry localFeedIdListEntry = new FeedIdListEntry();
    localFeedIdListEntry.feedId = paramString;
    EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
    localFeedIdListEntry.setStatus(1001);
    return localEntityManager.remove(localFeedIdListEntry, "feedId=?", new String[] { paramString });
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = wjp.a(QQStoryContext.a().a().createEntityManager(), FeedIdListEntry.class, FeedIdListEntry.class.getSimpleName(), null, null);
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
    ykq.a("Q.qqstory.home.position", "disableAutoRefresh mIsFirstTimeUse:%b, fromOldLeba:%b, hasRedPoint:%b, mLastViewTime:%d", Boolean.valueOf(this.jdField_b_of_type_Boolean), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Long.valueOf(this.jdField_a_of_type_Long));
    if ((!this.jdField_b_of_type_Boolean) && (paramBoolean1) && (!paramBoolean2) && (this.jdField_a_of_type_Long > 0L))
    {
      long l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      long l2 = ((Long)((wjl)wjs.a(10)).b("key_disable_auto_refresh_time", Long.valueOf(60000L))).longValue();
      ykq.a("Q.qqstory.home.position", "disableAutoRefresh duration:%d, severConfigTime:%d", Long.valueOf(l1), Long.valueOf(l2));
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
      ykq.e("Q.qqstory.home.data.FeedManager", "feedId is null,you cant queryFeedItem:" + zdz.a(3));
      return null;
    }
    return (FeedItem)this.jdField_a_of_type_Vzl.a(paramString);
  }
  
  public List<String> b()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = wjp.a(QQStoryContext.a().a().createEntityManager(), TroopAssistantFeedIdListEntry.class, TroopAssistantFeedIdListEntry.class.getSimpleName(), null, null);
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((TroopAssistantFeedIdListEntry)((Iterator)localObject).next()).feedId);
    }
    return localArrayList;
  }
  
  public List<ydz> b(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = (FeedItem)this.jdField_a_of_type_Vzl.a(str);
      paramList = (List<String>)localObject;
      if (localObject == null)
      {
        localObject = a(str);
        if (localObject != null)
        {
          paramList = FeedItem.createFeedItemByType(((FeedEntry)localObject).type);
          if (paramList == null)
          {
            ykq.e("Q.qqstory.home.data.FeedManager", "这种类型目前还不支持：" + ((FeedEntry)localObject).type);
          }
          else
          {
            paramList.covertFromEntry((FeedEntry)localObject);
            this.jdField_a_of_type_Vzl.a(str, paramList);
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
    if (this.jdField_a_of_type_Yco != null) {
      wad.a().unRegisterSubscriber(this.jdField_a_of_type_Yco);
    }
    if (this.jdField_a_of_type_Ycn != null) {
      wad.a().unRegisterSubscriber(this.jdField_a_of_type_Ycn);
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public void b(@NonNull List<String> paramList)
  {
    Object localObject1 = new wsp();
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
          ykq.a("Q.qqstory.home.data.FeedManager", "request feed item list, ignore same request %s", localObject1);
        }
        else
        {
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject1, Long.valueOf(System.currentTimeMillis()));
          localObject2 = new ycc((String)localObject1, 0, "", "");
          paramList.a.add(localObject2);
          paramList.b.add(localObject1);
          if (paramList.a.size() <= 3) {
            break label194;
          }
          a(paramList);
          paramList = new wsp();
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
    EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
    try
    {
      localEntityManager.getTransaction().begin();
      if (paramBoolean) {
        localEntityManager.drop(TroopAssistantFeedIdListEntry.class);
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        TroopAssistantFeedIdListEntry localTroopAssistantFeedIdListEntry = new TroopAssistantFeedIdListEntry();
        localTroopAssistantFeedIdListEntry.feedId = str;
        localEntityManager.persistOrReplace(localTroopAssistantFeedIdListEntry);
      }
    }
    finally
    {
      localEntityManager.getTransaction().end();
    }
    localEntityManager.getTransaction().end();
  }
  
  public FeedItem c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      ykq.e("Q.qqstory.home.data.FeedManager", "feedId is null,you cant queryFeedItem:" + zdz.a(3));
    }
    do
    {
      return null;
      paramString = a(paramString);
    } while (paramString == null);
    FeedItem localFeedItem = FeedItem.createFeedItemByType(paramString.type);
    if (localFeedItem == null)
    {
      ykq.e("Q.qqstory.home.data.FeedManager", "这种类型目前还不支持：" + paramString.type);
      return null;
    }
    localFeedItem.covertFromEntry(paramString);
    return localFeedItem;
  }
  
  public List<String> c()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = wjp.a(QQStoryContext.a().a().createEntityManager(), MemoriesFeedIdListEntry.class, MemoriesFeedIdListEntry.class.getSimpleName(), null, null);
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
    long l = ((Long)((wjl)wjs.a(10)).b("key_disable_auto_refresh_time", Long.valueOf(60000L))).longValue();
    ThreadManager.getUIHandler().postDelayed(new FeedManager.2(this), l);
  }
  
  public void c(List<String> paramList, boolean paramBoolean)
  {
    EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
    localEntityManager.getTransaction().begin();
    if (paramBoolean) {}
    try
    {
      localEntityManager.drop(MemoriesFeedIdListEntry.class);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        MemoriesFeedIdListEntry localMemoriesFeedIdListEntry = new MemoriesFeedIdListEntry();
        localMemoriesFeedIdListEntry.feedId = str;
        localEntityManager.persistOrReplace(localMemoriesFeedIdListEntry);
      }
    }
    finally
    {
      localEntityManager.getTransaction().end();
    }
    localEntityManager.getTransaction().end();
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yck
 * JD-Core Version:    0.7.0.1
 */