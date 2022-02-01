import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
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
import com.tribe.async.dispatch.QQUIEventReceiver;
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

public class qvf
  implements IEventReceiver, psj
{
  private static ConcurrentHashMap<String, Long> bZ = new ConcurrentHashMap();
  public static ThreadLocal<SimpleDateFormat> n = new ThreadLocal();
  private long Br;
  private qog jdField_a_of_type_Qog = new qog("feeItem");
  private quy jdField_a_of_type_Quy = new quy();
  private qvf.a jdField_a_of_type_Qvf$a;
  private qvf.b jdField_a_of_type_Qvf$b;
  private boolean aFK = true;
  public boolean aFL;
  public int bon;
  public pua c;
  public qve.b c;
  private ConcurrentHashMap<String, ptp> ch = new ConcurrentHashMap();
  public qve.b d;
  private HashMap<String, String> ft = new HashMap();
  public Map<String, String> gb = new HashMap();
  private plv<String, FeedItem> i = new plv(300);
  public int mFirstPosition;
  private AtomicBoolean mIsDestroy = new AtomicBoolean(false);
  public ArrayList<qwa> nk = new ArrayList(0);
  
  private FeedEntry a(String paramString)
  {
    paramString = psu.a(QQStoryContext.a().getEntityManagerFactory().createEntityManager(), FeedEntry.class, FeedEntry.class.getSimpleName(), FeedEntry.queryFeedId(), new String[] { paramString });
    if ((paramString != null) && (paramString.size() == 1)) {
      return (FeedEntry)paramString.get(0);
    }
    return null;
  }
  
  private static FeedItem a(boolean paramBoolean, String paramString1, String paramString2)
  {
    qvf localqvf = (qvf)psx.a(11);
    Object localObject2 = localqvf.ah(paramString1, paramString2);
    ram.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "find true feedId:%s", localObject2);
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = VideoListFeedItem.makeFakeFeedId(paramString1, paramString2);
      ram.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "make fake feedId:%s", localObject1);
    }
    localObject2 = localqvf.a((String)localObject1);
    localObject1 = localObject2;
    if (localObject2 == null) {
      if (!paramBoolean) {
        break label101;
      }
    }
    label101:
    for (paramString1 = ShareGroupFeedItem.createFakeFeedItem(paramString1, paramString2);; paramString1 = GeneralFeedItem.createFakeFeedItem(paramString2))
    {
      localqvf.a(paramString1);
      ram.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "save fake item %s", paramString1.feedId);
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
    rom.checkNotNull(paramString1);
    return null;
  }
  
  public static ShareGroupFeedItem a(String paramString1, String paramString2)
  {
    paramString1 = a(true, paramString1, paramString2);
    if (paramString1 == null) {}
    while (!(paramString1 instanceof ShareGroupFeedItem))
    {
      rom.fail("feed type wrong for shareGroupItem:%s", new Object[] { paramString1 });
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
      rom.fail("feed type wrong for shareGroupItem:%s", new Object[] { paramString1 });
      return null;
    }
    return (ShareGroupFeedItem)paramString1;
  }
  
  private void a(pyk parampyk)
  {
    ram.b("Q.qqstory.home.data.FeedManager", "request feed item list from net, %s", parampyk.nl);
    ppv.a().a(parampyk, new qvh(this));
  }
  
  public static void brf()
  {
    pxk.bZ.clear();
    bZ.clear();
    qgt.ca.clear();
  }
  
  public static SimpleDateFormat c()
  {
    SimpleDateFormat localSimpleDateFormat2 = (SimpleDateFormat)n.get();
    SimpleDateFormat localSimpleDateFormat1 = localSimpleDateFormat2;
    if (localSimpleDateFormat2 == null)
    {
      localSimpleDateFormat1 = new SimpleDateFormat("yyyyMMdd");
      n.set(localSimpleDateFormat1);
    }
    return localSimpleDateFormat1;
  }
  
  public static String jf()
  {
    return c().format(new Date(NetConnInfoCenter.getServerTimeMillis()));
  }
  
  public static void sd(String paramString)
  {
    Bosses.get().postLightWeightJob(new FeedManager.1(paramString), 10);
  }
  
  public void O(String paramString1, String paramString2, String paramString3)
  {
    this.ft.put(paramString1 + paramString2, paramString3);
    ram.b("Q.qqstory.home.data.FeedManager", "save my feedId %s", this.ft);
  }
  
  public void Q(List<String> paramList, boolean paramBoolean)
  {
    EntityManager localEntityManager = QQStoryContext.a().getEntityManagerFactory().createEntityManager();
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
  
  public boolean Q(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = psu.a(QQStoryContext.a().getEntityManagerFactory().createEntityManager(), FeedIdListEntry.class, FeedIdListEntry.class.getSimpleName(), null, null);
    if (localList == null) {
      return false;
    }
    int j = 0;
    boolean bool = false;
    if (j < localList.size())
    {
      FeedIdListEntry localFeedIdListEntry = (FeedIdListEntry)localList.get(j);
      if (localFeedIdListEntry.feedId.equals(paramString1))
      {
        localArrayList.add(paramString2);
        bool = true;
      }
      for (;;)
      {
        j += 1;
        break;
        localArrayList.add(localFeedIdListEntry.feedId);
      }
    }
    if (bool) {
      Q(localArrayList, true);
    }
    return bool;
  }
  
  public void R(List<String> paramList, boolean paramBoolean)
  {
    EntityManager localEntityManager = QQStoryContext.a().getEntityManagerFactory().createEntityManager();
    localEntityManager.getTransaction().begin();
    if (paramBoolean) {}
    try
    {
      localEntityManager.drop(TroopAssistantFeedIdListEntry.class);
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
  
  public void S(List<String> paramList, boolean paramBoolean)
  {
    EntityManager localEntityManager = QQStoryContext.a().getEntityManagerFactory().createEntityManager();
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
  
  public FeedItem a(FeedItem paramFeedItem)
  {
    ram.b("Q.qqstory.home.data.FeedManager", "save feed item %s", paramFeedItem.feedId);
    paramFeedItem = (FeedItem)this.i.a(paramFeedItem.feedId, paramFeedItem);
    FeedEntry localFeedEntry = paramFeedItem.covertToEntry();
    QQStoryContext.a().getEntityManagerFactory().createEntityManager().persistOrReplace(localFeedEntry);
    return paramFeedItem;
  }
  
  public FeedItem a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      ram.e("Q.qqstory.home.data.FeedManager", "feedId is null,you cant queryFeedItem:" + rov.getStackTrace(3));
      localObject = null;
    }
    do
    {
      return localObject;
      localFeedItem = (FeedItem)this.i.a(paramString);
      localObject = localFeedItem;
    } while (localFeedItem != null);
    Object localObject = a(paramString);
    if (localObject == null) {
      return null;
    }
    FeedItem localFeedItem = FeedItem.createFeedItemByType(((FeedEntry)localObject).type);
    if (localFeedItem == null)
    {
      ram.e("Q.qqstory.home.data.FeedManager", "这种类型目前还不支持：" + ((FeedEntry)localObject).type);
      return null;
    }
    localFeedItem.covertFromEntry((FeedEntry)localObject);
    return (FeedItem)this.i.a(paramString, localFeedItem);
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
  
  public List<StoryVideoItem> a(String paramString, List<StoryVideoItem> paramList, boolean paramBoolean)
  {
    return ((psu)psx.a(5)).a(paramString, 0, paramList, paramBoolean);
  }
  
  public ptp a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    ptp localptp = (ptp)this.ch.get(paramString);
    if (this.jdField_a_of_type_Qvf$b == null)
    {
      this.jdField_a_of_type_Qvf$b = new qvf.b(this);
      pmi.a().registerSubscriber(this.jdField_a_of_type_Qvf$b);
    }
    new pxk(Collections.singletonList(paramString), true).sendRequest();
    ram.b("Q.qqstory.home.data.FeedManager", "request feed feature : %s", paramString);
    return localptp;
  }
  
  public quy a()
  {
    return this.jdField_a_of_type_Quy;
  }
  
  public String ah(String paramString1, String paramString2)
  {
    ram.a("Q.qqstory.home.data.FeedManager", "query my feedId unionId:%s, date:%s %s", paramString1, paramString2, this.ft);
    return (String)this.ft.get(paramString1 + paramString2);
  }
  
  public List<FeedItem> au(List<FeedItem> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    EntityManager localEntityManager = QQStoryContext.a().getEntityManagerFactory().createEntityManager();
    localEntityManager.getTransaction().begin();
    try
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        FeedItem localFeedItem = (FeedItem)paramList.next();
        localFeedItem = (FeedItem)this.i.a(localFeedItem.feedId, localFeedItem);
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
  
  public List<qwa> av(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = (FeedItem)this.i.a(str);
      paramList = (List<String>)localObject;
      if (localObject == null)
      {
        localObject = a(str);
        if (localObject != null)
        {
          paramList = FeedItem.createFeedItemByType(((FeedEntry)localObject).type);
          if (paramList == null)
          {
            ram.e("Q.qqstory.home.data.FeedManager", "这种类型目前还不支持：" + ((FeedEntry)localObject).type);
          }
          else
          {
            paramList.covertFromEntry((FeedEntry)localObject);
            this.i.a(str, paramList);
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
  
  public FeedItem b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      ram.e("Q.qqstory.home.data.FeedManager", "feedId is null,you cant queryFeedItem:" + rov.getStackTrace(3));
      return null;
    }
    return (FeedItem)this.i.a(paramString);
  }
  
  public List<String> bV()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = psu.a(QQStoryContext.a().getEntityManagerFactory().createEntityManager(), FeedIdListEntry.class, FeedIdListEntry.class.getSimpleName(), null, null);
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((FeedIdListEntry)((Iterator)localObject).next()).feedId);
    }
    return localArrayList;
  }
  
  public List<String> bW()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = psu.a(QQStoryContext.a().getEntityManagerFactory().createEntityManager(), TroopAssistantFeedIdListEntry.class, TroopAssistantFeedIdListEntry.class.getSimpleName(), null, null);
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((TroopAssistantFeedIdListEntry)((Iterator)localObject).next()).feedId);
    }
    return localArrayList;
  }
  
  public List<String> bX()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = psu.a(QQStoryContext.a().getEntityManagerFactory().createEntityManager(), MemoriesFeedIdListEntry.class, MemoriesFeedIdListEntry.class.getSimpleName(), null, null);
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((MemoriesFeedIdListEntry)((Iterator)localObject).next()).feedId);
    }
    return localArrayList;
  }
  
  public void bre()
  {
    this.Br = System.currentTimeMillis();
    long l = ((Long)((psr)psx.a(10)).c("key_disable_auto_refresh_time", Long.valueOf(60000L))).longValue();
    ThreadManager.getUIHandler().postDelayed(new FeedManager.2(this), l);
  }
  
  public FeedItem c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      ram.e("Q.qqstory.home.data.FeedManager", "feedId is null,you cant queryFeedItem:" + rov.getStackTrace(3));
    }
    do
    {
      return null;
      paramString = a(paramString);
    } while (paramString == null);
    FeedItem localFeedItem = FeedItem.createFeedItemByType(paramString.type);
    if (localFeedItem == null)
    {
      ram.e("Q.qqstory.home.data.FeedManager", "这种类型目前还不支持：" + paramString.type);
      return null;
    }
    localFeedItem.covertFromEntry(paramString);
    return localFeedItem;
  }
  
  public void eE(List<qvd> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      qvd localqvd = (qvd)paramList.next();
      this.ft.put(localqvd.mUnionId + localqvd.ayV, localqvd.mFeedId);
    }
  }
  
  public void eF(@NonNull List<String> paramList)
  {
    Object localObject1 = new pyk();
    Iterator localIterator = paramList.iterator();
    paramList = (List<String>)localObject1;
    while (localIterator.hasNext())
    {
      localObject1 = (String)localIterator.next();
      if (a((String)localObject1) == null)
      {
        Object localObject2 = (Long)bZ.get(localObject1);
        if ((localObject2 != null) && (Math.abs(System.currentTimeMillis() - ((Long)localObject2).longValue()) < 300000L))
        {
          ram.b("Q.qqstory.home.data.FeedManager", "request feed item list, ignore same request %s", localObject1);
        }
        else
        {
          bZ.put(localObject1, Long.valueOf(System.currentTimeMillis()));
          localObject2 = new qvd((String)localObject1, 0, "", "");
          paramList.nk.add(localObject2);
          paramList.nl.add(localObject1);
          if (paramList.nk.size() <= 3) {
            break label194;
          }
          a(paramList);
          paramList = new pyk();
        }
      }
    }
    label194:
    for (;;)
    {
      break;
      if (paramList.nk.size() == 0) {
        return;
      }
      a(paramList);
      return;
    }
  }
  
  public boolean fq(String paramString)
  {
    FeedIdListEntry localFeedIdListEntry = new FeedIdListEntry();
    localFeedIdListEntry.feedId = paramString;
    EntityManager localEntityManager = QQStoryContext.a().getEntityManagerFactory().createEntityManager();
    localFeedIdListEntry.setStatus(1001);
    return localEntityManager.remove(localFeedIdListEntry, "feedId=?", new String[] { paramString });
  }
  
  public boolean g(boolean paramBoolean1, boolean paramBoolean2)
  {
    ram.a("Q.qqstory.home.position", "disableAutoRefresh mIsFirstTimeUse:%b, fromOldLeba:%b, hasRedPoint:%b, mLastViewTime:%d", Boolean.valueOf(this.aFK), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Long.valueOf(this.Br));
    if ((!this.aFK) && (paramBoolean1) && (!paramBoolean2) && (this.Br > 0L))
    {
      long l1 = System.currentTimeMillis() - this.Br;
      long l2 = ((Long)((psr)psx.a(10)).c("key_disable_auto_refresh_time", Long.valueOf(60000L))).longValue();
      ram.b("Q.qqstory.home.position", "disableAutoRefresh duration:%d, severConfigTime:%d", Long.valueOf(l1), Long.valueOf(l2));
      if (l1 < l2)
      {
        this.Br = 0L;
        return true;
      }
    }
    this.aFK = false;
    this.mFirstPosition = 0;
    this.bon = 0;
    this.Br = 0L;
    return false;
  }
  
  public boolean isValidate()
  {
    return !this.mIsDestroy.get();
  }
  
  public void onDestroy()
  {
    this.nk.clear();
    if (this.jdField_a_of_type_Qvf$b != null) {
      pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qvf$b);
    }
    if (this.jdField_a_of_type_Qvf$a != null) {
      pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qvf$a);
    }
    this.mIsDestroy.set(true);
  }
  
  public void onInit()
  {
    this.jdField_a_of_type_Qvf$a = new qvf.a(this);
    pmi.a().registerSubscriber(this.jdField_a_of_type_Qvf$a);
  }
  
  public void sc(String paramString)
  {
    FeedEntry localFeedEntry = a(paramString);
    if (localFeedEntry != null)
    {
      localFeedEntry.setStatus(1001);
      QQStoryContext.a().getEntityManagerFactory().createEntityManager().remove(localFeedEntry);
    }
    this.i.ag(paramString);
  }
  
  public static final class a
    extends QQUIEventReceiver<qvf, psg>
  {
    public a(@NonNull qvf paramqvf)
    {
      super();
    }
    
    public void a(@NonNull qvf paramqvf, @NonNull psg parampsg)
    {
      Iterator localIterator = paramqvf.nk.iterator();
      int j;
      for (int i = 0; localIterator.hasNext(); i = j)
      {
        Object localObject = (qwa)localIterator.next();
        j = i;
        if ((localObject instanceof qvj))
        {
          j = i;
          if (((qvj)localObject).KE())
          {
            localObject = ((qvj)localObject).bS().iterator();
            for (;;)
            {
              j = i;
              if (!((Iterator)localObject).hasNext()) {
                break;
              }
              if (((StoryVideoItem)((Iterator)localObject).next()).mVid.equals(parampsg.vid)) {
                i = 1;
              }
            }
          }
        }
      }
      if (i != 0) {
        paramqvf.nk.clear();
      }
    }
    
    public Class acceptEventClass()
    {
      return psg.class;
    }
  }
  
  public static final class b
    extends QQUIEventReceiver<qvf, pxk.a>
  {
    public b(@NonNull qvf paramqvf)
    {
      super();
    }
    
    public void a(@NonNull qvf paramqvf, @NonNull pxk.a parama)
    {
      ram.b(this.TAG, "receive feature event. %s.", parama.toString());
      if ((parama.b.isSuccess()) && (parama.mO != null))
      {
        parama = parama.mO.iterator();
        while (parama.hasNext())
        {
          ptp localptp = (ptp)parama.next();
          qvf.a(paramqvf).put(localptp.feedId, localptp);
        }
      }
    }
    
    public Class acceptEventClass()
    {
      return pxk.a.class;
    }
  }
  
  public static final class c
    extends plt
  {
    public FeedItem b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qvf
 * JD-Core Version:    0.7.0.1
 */