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

public class uje
  implements IEventReceiver, spo
{
  public static ThreadLocal<SimpleDateFormat> a;
  private static ConcurrentHashMap<String, Long> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public int a;
  private long jdField_a_of_type_Long;
  public ArrayList<ukt> a;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public Map<String, String> a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private sfq<String, FeedItem> jdField_a_of_type_Sfq = new sfq(300);
  public sry a;
  private tws jdField_a_of_type_Tws = new tws("feeItem");
  private uip jdField_a_of_type_Uip = new uip();
  public uja a;
  private ujh jdField_a_of_type_Ujh;
  private uji jdField_a_of_type_Uji;
  public boolean a;
  public int b;
  private ConcurrentHashMap<String, srj> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public uja b;
  private boolean jdField_b_of_type_Boolean = true;
  
  static
  {
    jdField_a_of_type_JavaLangThreadLocal = new ThreadLocal();
  }
  
  public uje()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(0);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  private FeedEntry a(String paramString)
  {
    paramString = sqd.a(QQStoryContext.a().a().createEntityManager(), FeedEntry.class, FeedEntry.class.getSimpleName(), FeedEntry.queryFeedId(), new String[] { paramString });
    if ((paramString != null) && (paramString.size() == 1)) {
      return (FeedEntry)paramString.get(0);
    }
    return null;
  }
  
  private static FeedItem a(boolean paramBoolean, String paramString1, String paramString2)
  {
    uje localuje = (uje)sqg.a(11);
    Object localObject2 = localuje.a(paramString1, paramString2);
    urk.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "find true feedId:%s", localObject2);
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = VideoListFeedItem.makeFakeFeedId(paramString1, paramString2);
      urk.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "make fake feedId:%s", localObject1);
    }
    localObject2 = localuje.a((String)localObject1);
    localObject1 = localObject2;
    if (localObject2 == null) {
      if (!paramBoolean) {
        break label101;
      }
    }
    label101:
    for (paramString1 = ShareGroupFeedItem.createFakeFeedItem(paramString1, paramString2);; paramString1 = GeneralFeedItem.createFakeFeedItem(paramString2))
    {
      localuje.a(paramString1);
      urk.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "save fake item %s", paramString1.feedId);
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
    vkw.a(paramString1);
    return null;
  }
  
  public static ShareGroupFeedItem a(String paramString1, String paramString2)
  {
    paramString1 = a(true, paramString1, paramString2);
    if (paramString1 == null) {}
    while (!(paramString1 instanceof ShareGroupFeedItem))
    {
      vkw.a("feed type wrong for shareGroupItem:%s", new Object[] { paramString1 });
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
      vkw.a("feed type wrong for shareGroupItem:%s", new Object[] { paramString1 });
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
  
  private void a(szd paramszd)
  {
    urk.a("Q.qqstory.home.data.FeedManager", "request feed item list from net, %s", paramszd.b);
    slv.a().a(paramszd, new ujg(this));
  }
  
  public static void b(String paramString)
  {
    Bosses.get().postLightWeightJob(new FeedManager.1(paramString), 10);
  }
  
  public static void d()
  {
    swu.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    tjk.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public FeedItem a(FeedItem paramFeedItem)
  {
    urk.a("Q.qqstory.home.data.FeedManager", "save feed item %s", paramFeedItem.feedId);
    paramFeedItem = (FeedItem)this.jdField_a_of_type_Sfq.a(paramFeedItem.feedId, paramFeedItem);
    FeedEntry localFeedEntry = paramFeedItem.covertToEntry();
    QQStoryContext.a().a().createEntityManager().b(localFeedEntry);
    return paramFeedItem;
  }
  
  public FeedItem a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      urk.e("Q.qqstory.home.data.FeedManager", "feedId is null,you cant queryFeedItem:" + vlk.a(3));
      localObject = null;
    }
    do
    {
      return localObject;
      localFeedItem = (FeedItem)this.jdField_a_of_type_Sfq.a(paramString);
      localObject = localFeedItem;
    } while (localFeedItem != null);
    Object localObject = a(paramString);
    if (localObject == null) {
      return null;
    }
    FeedItem localFeedItem = FeedItem.createFeedItemByType(((FeedEntry)localObject).type);
    if (localFeedItem == null)
    {
      urk.e("Q.qqstory.home.data.FeedManager", "这种类型目前还不支持：" + ((FeedEntry)localObject).type);
      return null;
    }
    localFeedItem.covertFromEntry((FeedEntry)localObject);
    return (FeedItem)this.jdField_a_of_type_Sfq.a(paramString, localFeedItem);
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
    urk.a("Q.qqstory.home.data.FeedManager", "query my feedId unionId:%s, date:%s %s", paramString1, paramString2, this.jdField_a_of_type_JavaUtilHashMap);
    return (String)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1 + paramString2);
  }
  
  public List<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = sqd.a(QQStoryContext.a().a().createEntityManager(), FeedIdListEntry.class, FeedIdListEntry.class.getSimpleName(), null, null);
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
    return ((sqd)sqg.a(5)).a(paramString, 0, paramList, paramBoolean);
  }
  
  public List<FeedItem> a(List<FeedItem> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    atmp localatmp = QQStoryContext.a().a().createEntityManager();
    localatmp.a().a();
    try
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        FeedItem localFeedItem = (FeedItem)paramList.next();
        localFeedItem = (FeedItem)this.jdField_a_of_type_Sfq.a(localFeedItem.feedId, localFeedItem);
        localatmp.b(localFeedItem.covertToEntry());
        localArrayList.add(localFeedItem);
      }
    }
    finally
    {
      localatmp.a().b();
    }
    localatmp.a().b();
    return localArrayList;
  }
  
  public srj a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    srj localsrj = (srj)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (this.jdField_a_of_type_Uji == null)
    {
      this.jdField_a_of_type_Uji = new uji(this);
      sgi.a().registerSubscriber(this.jdField_a_of_type_Uji);
    }
    new swu(Collections.singletonList(paramString), true).a();
    urk.a("Q.qqstory.home.data.FeedManager", "request feed feature : %s", paramString);
    return localsrj;
  }
  
  public uip a()
  {
    return this.jdField_a_of_type_Uip;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Ujh = new ujh(this);
    sgi.a().registerSubscriber(this.jdField_a_of_type_Ujh);
  }
  
  public void a(String paramString)
  {
    FeedEntry localFeedEntry = a(paramString);
    if (localFeedEntry != null)
    {
      localFeedEntry.setStatus(1001);
      QQStoryContext.a().a().createEntityManager().b(localFeedEntry);
    }
    this.jdField_a_of_type_Sfq.a(paramString);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString1 + paramString2, paramString3);
    urk.a("Q.qqstory.home.data.FeedManager", "save my feedId %s", this.jdField_a_of_type_JavaUtilHashMap);
  }
  
  public void a(List<uiw> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      uiw localuiw = (uiw)paramList.next();
      this.jdField_a_of_type_JavaUtilHashMap.put(localuiw.b + localuiw.c, localuiw.a);
    }
  }
  
  public void a(List<String> paramList, boolean paramBoolean)
  {
    atmp localatmp = QQStoryContext.a().a().createEntityManager();
    localatmp.a().a();
    if (paramBoolean) {}
    try
    {
      localatmp.a(FeedIdListEntry.class);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        FeedIdListEntry localFeedIdListEntry = new FeedIdListEntry();
        localFeedIdListEntry.feedId = str;
        localatmp.b(localFeedIdListEntry);
      }
    }
    finally
    {
      localatmp.a().b();
    }
    localatmp.a().b();
  }
  
  public boolean a(String paramString)
  {
    FeedIdListEntry localFeedIdListEntry = new FeedIdListEntry();
    localFeedIdListEntry.feedId = paramString;
    atmp localatmp = QQStoryContext.a().a().createEntityManager();
    localFeedIdListEntry.setStatus(1001);
    return localatmp.a(localFeedIdListEntry, "feedId=?", new String[] { paramString });
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = sqd.a(QQStoryContext.a().a().createEntityManager(), FeedIdListEntry.class, FeedIdListEntry.class.getSimpleName(), null, null);
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
    urk.a("Q.qqstory.home.position", "disableAutoRefresh mIsFirstTimeUse:%b, fromOldLeba:%b, hasRedPoint:%b, mLastViewTime:%d", Boolean.valueOf(this.jdField_b_of_type_Boolean), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Long.valueOf(this.jdField_a_of_type_Long));
    if ((!this.jdField_b_of_type_Boolean) && (paramBoolean1) && (!paramBoolean2) && (this.jdField_a_of_type_Long > 0L))
    {
      long l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      long l2 = ((Long)((spz)sqg.a(10)).b("key_disable_auto_refresh_time", Long.valueOf(60000L))).longValue();
      urk.a("Q.qqstory.home.position", "disableAutoRefresh duration:%d, severConfigTime:%d", Long.valueOf(l1), Long.valueOf(l2));
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
      urk.e("Q.qqstory.home.data.FeedManager", "feedId is null,you cant queryFeedItem:" + vlk.a(3));
      return null;
    }
    return (FeedItem)this.jdField_a_of_type_Sfq.a(paramString);
  }
  
  public List<String> b()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = sqd.a(QQStoryContext.a().a().createEntityManager(), TroopAssistantFeedIdListEntry.class, TroopAssistantFeedIdListEntry.class.getSimpleName(), null, null);
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((TroopAssistantFeedIdListEntry)((Iterator)localObject).next()).feedId);
    }
    return localArrayList;
  }
  
  public List<ukt> b(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = (FeedItem)this.jdField_a_of_type_Sfq.a(str);
      paramList = (List<String>)localObject;
      if (localObject == null)
      {
        localObject = a(str);
        if (localObject != null)
        {
          paramList = FeedItem.createFeedItemByType(((FeedEntry)localObject).type);
          if (paramList == null)
          {
            urk.e("Q.qqstory.home.data.FeedManager", "这种类型目前还不支持：" + ((FeedEntry)localObject).type);
          }
          else
          {
            paramList.covertFromEntry((FeedEntry)localObject);
            this.jdField_a_of_type_Sfq.a(str, paramList);
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
    if (this.jdField_a_of_type_Uji != null) {
      sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Uji);
    }
    if (this.jdField_a_of_type_Ujh != null) {
      sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Ujh);
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public void b(@NonNull List<String> paramList)
  {
    Object localObject1 = new szd();
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
          urk.a("Q.qqstory.home.data.FeedManager", "request feed item list, ignore same request %s", localObject1);
        }
        else
        {
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject1, Long.valueOf(System.currentTimeMillis()));
          localObject2 = new uiw((String)localObject1, 0, "", "");
          paramList.a.add(localObject2);
          paramList.b.add(localObject1);
          if (paramList.a.size() <= 3) {
            break label194;
          }
          a(paramList);
          paramList = new szd();
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
    atmp localatmp = QQStoryContext.a().a().createEntityManager();
    localatmp.a().a();
    if (paramBoolean) {}
    try
    {
      localatmp.a(TroopAssistantFeedIdListEntry.class);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        TroopAssistantFeedIdListEntry localTroopAssistantFeedIdListEntry = new TroopAssistantFeedIdListEntry();
        localTroopAssistantFeedIdListEntry.feedId = str;
        localatmp.b(localTroopAssistantFeedIdListEntry);
      }
    }
    finally
    {
      localatmp.a().b();
    }
    localatmp.a().b();
  }
  
  public FeedItem c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      urk.e("Q.qqstory.home.data.FeedManager", "feedId is null,you cant queryFeedItem:" + vlk.a(3));
    }
    do
    {
      return null;
      paramString = a(paramString);
    } while (paramString == null);
    FeedItem localFeedItem = FeedItem.createFeedItemByType(paramString.type);
    if (localFeedItem == null)
    {
      urk.e("Q.qqstory.home.data.FeedManager", "这种类型目前还不支持：" + paramString.type);
      return null;
    }
    localFeedItem.covertFromEntry(paramString);
    return localFeedItem;
  }
  
  public List<String> c()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = sqd.a(QQStoryContext.a().a().createEntityManager(), MemoriesFeedIdListEntry.class, MemoriesFeedIdListEntry.class.getSimpleName(), null, null);
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
    long l = ((Long)((spz)sqg.a(10)).b("key_disable_auto_refresh_time", Long.valueOf(60000L))).longValue();
    ThreadManager.getUIHandler().postDelayed(new FeedManager.2(this), l);
  }
  
  public void c(List<String> paramList, boolean paramBoolean)
  {
    atmp localatmp = QQStoryContext.a().a().createEntityManager();
    localatmp.a().a();
    if (paramBoolean) {}
    try
    {
      localatmp.a(MemoriesFeedIdListEntry.class);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        MemoriesFeedIdListEntry localMemoriesFeedIdListEntry = new MemoriesFeedIdListEntry();
        localMemoriesFeedIdListEntry.feedId = str;
        localatmp.b(localMemoriesFeedIdListEntry);
      }
    }
    finally
    {
      localatmp.a().b();
    }
    localatmp.a().b();
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uje
 * JD-Core Version:    0.7.0.1
 */