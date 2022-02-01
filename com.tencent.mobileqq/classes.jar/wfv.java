import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.StoryAlbumEntry;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class wfv
  extends wsd
  implements wsq
{
  private volatile int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  aasb jdField_a_of_type_Aasb = null;
  private wfn jdField_a_of_type_Wfn;
  private wta jdField_a_of_type_Wta;
  
  public static String a(@NonNull List<wgg> paramList)
  {
    if (paramList.isEmpty()) {
      return "";
    }
    paramList = paramList.iterator();
    int n = 0;
    int m = 0;
    int k = 0;
    int j = 0;
    int i = 0;
    if (paramList.hasNext())
    {
      int i1;
      int i2;
      switch (((wgg)paramList.next()).jdField_a_of_type_Int)
      {
      case 5: 
      default: 
        i1 = n;
        i2 = m;
        n = i;
        m = j;
        j = i2;
        i = i1;
      }
      for (;;)
      {
        i1 = n;
        i2 = m;
        n = i;
        m = j;
        j = i2;
        i = i1;
        break;
        i1 = j;
        i2 = i + 1;
        i = n;
        j = m;
        m = i1;
        n = i2;
        continue;
        i2 = j + 1;
        i1 = i;
        i = n;
        j = m;
        m = i2;
        n = i1;
        continue;
        k += 1;
        i1 = j;
        i2 = i;
        i = n;
        j = m;
        m = i1;
        n = i2;
        continue;
        i2 = m + 1;
        m = j;
        i1 = i;
        i = n;
        j = i2;
        n = i1;
        continue;
        i2 = n + 1;
        n = j;
        i1 = i;
        i = i2;
        j = m;
        m = n;
        n = i1;
      }
    }
    paramList = new StringBuilder("{");
    paramList.append("\"festival\":").append(i).append(",");
    paramList.append("\"birthday\":").append(j).append(",");
    paramList.append("\"frequent\":").append(k).append(",");
    paramList.append("\"unfrequent\":").append(m).append(",");
    paramList.append("\"aboard\":").append(n).append(",");
    paramList.append("}");
    return paramList.toString();
  }
  
  public static List<whl> a(@NonNull HashMap<String, wgf> paramHashMap)
  {
    ArrayList localArrayList = new ArrayList(paramHashMap.size());
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      wgf localwgf = (wgf)((Map.Entry)paramHashMap.next()).getValue();
      if (localwgf.a != null) {
        localArrayList.add(localwgf.a);
      }
    }
    return localArrayList;
  }
  
  public static List<wgh> a(wgg paramwgg, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = paramwgg.a();
    if (localList.size() < paramInt)
    {
      localArrayList.addAll(localList);
      localObject1 = localList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((wgh)((Iterator)localObject1).next()).a(true);
      }
      paramwgg.a(localList);
      return localArrayList;
    }
    Object localObject1 = localList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (wgh)((Iterator)localObject1).next();
      if (((wgh)localObject2).a()) {
        ((wgh)localObject2).a(false);
      }
    }
    localObject1 = new whq();
    ((whq)localObject1).a(localList);
    localObject1 = ((whq)localObject1).a(paramInt, null, 0).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (List)((Iterator)localObject1).next();
      ((wgh)((List)localObject2).get(0)).a(true);
      localArrayList.add(((List)localObject2).get(0));
    }
    paramwgg.a(localList);
    return localArrayList;
  }
  
  private void a(long paramLong1, long paramLong2)
  {
    yuk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "saveScanTime lastDateAlbumTime=" + paramLong1 + " ,lastScanPictureTime=" + paramLong2);
    wta localwta = (wta)wth.a(10);
    localwta.b("key_last_pic_scan_time", Long.valueOf(paramLong2));
    localwta.b("key_last_date_album_time", Long.valueOf(paramLong1));
    localwta.b("key_story_home_scan_time", Long.valueOf(paramLong2));
  }
  
  public static void a(List<wgg> paramList)
  {
    if (paramList.isEmpty()) {
      return;
    }
    Collections.sort(paramList, new wfx());
  }
  
  private void a(wgu paramwgu)
  {
    Object localObject1 = (wta)wth.a(10);
    if ((TextUtils.isEmpty(paramwgu.a)) || (TextUtils.isEmpty(paramwgu.b)))
    {
      localObject2 = (String)((wta)localObject1).b("key_album_debug_k", "");
      localObject1 = (String)((wta)localObject1).b("key_album_debug_sse", "");
      yuk.e("Q.qqstory.recommendAlbum.logic.StoryScanManager", "保存K means 的调试信息失败:" + paramwgu.a + " 和 " + paramwgu.b);
      yuk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "sp K means debug sse info:" + (String)localObject1 + " time info:" + (String)localObject2);
      return;
    }
    if (paramwgu.a())
    {
      ((wta)localObject1).b("key_album_debug_k", paramwgu.a);
      ((wta)localObject1).b("key_album_debug_sse", paramwgu.b);
      yuk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "sp K means debug sse info:" + paramwgu.b + " time info:" + paramwgu.a);
      return;
    }
    Object localObject2 = paramwgu.a.split(";");
    paramwgu = paramwgu.b.split(";");
    ((wta)localObject1).b("key_album_debug_k", localObject2[0]);
    ((wta)localObject1).b("key_album_debug_sse", paramwgu[0]);
    yuk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "sp K means debug sse info:" + paramwgu[0] + " time info:" + localObject2[0]);
  }
  
  public static void b(@NonNull List<wgh> paramList)
  {
    Collections.sort(paramList, new wfy());
  }
  
  public List<wgg> a()
  {
    ArrayList localArrayList = new ArrayList();
    wta localwta = (wta)wth.a(10);
    long l = ((Long)localwta.b("key_last_home_time", Long.valueOf(-1L))).longValue();
    EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
    Object localObject = wte.a(localEntityManager, StoryAlbumEntry.class, StoryAlbumEntry.class.getSimpleName(), "state=0 ", null, "startTime desc");
    if ((localObject == null) || (((List)localObject).isEmpty())) {
      return localArrayList;
    }
    yuk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getNewStoryAlbum : new album time=%s,last time=%d", new Object[] { Long.valueOf(((StoryAlbumEntry)((List)localObject).get(0)).startTime), Long.valueOf(l) });
    if (((StoryAlbumEntry)((List)localObject).get(0)).startTime <= l) {
      return localArrayList;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      StoryAlbumEntry localStoryAlbumEntry = (StoryAlbumEntry)((Iterator)localObject).next();
      wgg localwgg;
      try
      {
        localwgg = wgg.a(localStoryAlbumEntry);
        if (!localwgg.c()) {
          break label241;
        }
        localArrayList.add(localwgg);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        znw.a("getNewStoryAlbum DB info have error:" + localInvalidProtocolBufferMicroException, new Object[0]);
      }
      continue;
      label241:
      yuk.e("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getNewStoryAlbum we find the illegal album and deleted it : " + localwgg);
      localInvalidProtocolBufferMicroException.setStatus(1001);
      localEntityManager.remove(localInvalidProtocolBufferMicroException);
    }
    yuk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getNewStoryAlbum reslut=%s", new Object[] { localArrayList });
    if (localArrayList.isEmpty()) {
      return localArrayList;
    }
    if (((wgg)localArrayList.get(0)).f() <= l)
    {
      localArrayList.clear();
      return localArrayList;
    }
    localwta.b("key_last_home_time", Long.valueOf(((wgg)localArrayList.get(0)).f()));
    return localArrayList;
  }
  
  public List<wga> a(long paramLong1, long paramLong2)
  {
    return this.jdField_a_of_type_Wfn.a(paramLong1, paramLong2);
  }
  
  @NonNull
  public List<wgh> a(Context paramContext)
  {
    wta localwta = (wta)wth.a(10);
    long l = ((Long)localwta.b("key_story_home_scan_time", Long.valueOf(-1L))).longValue();
    paramContext = a(paramContext, Math.max(System.currentTimeMillis() / 1000L - 259200L, l));
    yuk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getNewScanPicList  result=" + paramContext);
    if (paramContext.size() >= 10)
    {
      localwta.b("key_story_home_scan_time", Long.valueOf(((wgh)paramContext.get(0)).b));
      return paramContext;
    }
    return null;
  }
  
  @NonNull
  public List<wgh> a(Context paramContext, long paramLong)
  {
    yuk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getNewPicList scan time = " + paramLong);
    new ArrayList();
    return new wfm().a(paramContext, 1L + paramLong, false, 500);
  }
  
  public wfn a()
  {
    return this.jdField_a_of_type_Wfn;
  }
  
  public void a()
  {
    ((wtn)wth.a(26)).a(this);
    this.jdField_a_of_type_Wta = ((wta)wth.a(10));
    this.jdField_a_of_type_Aasb = aasb.a();
    this.jdField_a_of_type_Aasb.a();
    this.jdField_a_of_type_Wfn = new wfn();
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
    case 1: 
      do
      {
        return;
        yuk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "trimMemory to be 5");
      } while (Build.VERSION.SDK_INT < 17);
      return;
    }
    yuk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "clearAllMemory");
  }
  
  public void a(boolean paramBoolean)
  {
    int j = 2;
    Object localObject = this.jdField_a_of_type_Aasb;
    if (paramBoolean)
    {
      i = 2;
      ((aasb)localObject).b(i);
      localObject = (wta)wth.a(10);
      if (!paramBoolean) {
        break label54;
      }
    }
    label54:
    for (int i = j;; i = 1)
    {
      ((wta)localObject).b("sp_key_user_enable_album_scan", Integer.valueOf(i));
      return;
      i = 1;
      break;
    }
  }
  
  public boolean a()
  {
    int i = ((Integer)this.jdField_a_of_type_Wta.b("sp_key_user_enable_album_scan", Integer.valueOf(0))).intValue();
    if ((i == 0) || (i == -1)) {
      return this.jdField_a_of_type_Wfn.b();
    }
    return i != 1;
  }
  
  public boolean a(long paramLong)
  {
    yuk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "deletedAlbumById=" + paramLong);
    if (paramLong >= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      znw.a(bool, "It is not allowed to deleted the id<0");
      EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
      StoryAlbumEntry localStoryAlbumEntry = new StoryAlbumEntry();
      localStoryAlbumEntry.setId(paramLong);
      localStoryAlbumEntry.setStatus(1001);
      return localEntityManager.remove(localStoryAlbumEntry);
    }
  }
  
  public boolean a(Context paramContext)
  {
    boolean bool2;
    if ((this.jdField_a_of_type_Wfn != null) && (this.jdField_a_of_type_Wfn.a()))
    {
      bool2 = true;
      if (Build.VERSION.SDK_INT < 18) {
        break label132;
      }
    }
    label132:
    for (boolean bool3 = true;; bool3 = false)
    {
      boolean bool1;
      if (Build.VERSION.SDK_INT >= 23) {
        if (paramContext.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) {
          bool1 = true;
        }
      }
      for (;;)
      {
        label50:
        if ((bool3) && (bool1) && (bool2)) {}
        for (boolean bool4 = true;; bool4 = false)
        {
          yuk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "isAlbumModuleEnable :%s , isVersionOk :%s , isStoragePermitOk :%s , isConfigOk :%s", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool3), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          return bool4;
          bool2 = false;
          break;
          bool1 = false;
          break label50;
        }
        bool1 = true;
      }
    }
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_Wfn.b(paramString);
  }
  
  public boolean a(@NonNull List<wgg> paramList, boolean paramBoolean)
  {
    yuk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "insertAlbumToDb albums=" + paramList.size() + " append=" + paramBoolean);
    boolean bool;
    if (!paramList.isEmpty()) {
      bool = true;
    }
    EntityManager localEntityManager;
    for (;;)
    {
      znw.a(bool, "It is not allow save the empty albums to DB ");
      localEntityManager = QQStoryContext.a().a().createEntityManager();
      localEntityManager.getTransaction().begin();
      if (!paramBoolean) {
        localEntityManager.drop(StoryAlbumEntry.class);
      }
      try
      {
        paramList = paramList.iterator();
        for (;;)
        {
          if (!paramList.hasNext()) {
            break label226;
          }
          wgg localwgg = (wgg)paramList.next();
          localStoryAlbumEntry = localwgg.a();
          if (localStoryAlbumEntry.getId() <= 0L) {
            break;
          }
          localStoryAlbumEntry.setStatus(1001);
          if (!localEntityManager.update(localStoryAlbumEntry))
          {
            localStoryAlbumEntry.setStatus(1000);
            localEntityManager.persistOrReplace(localStoryAlbumEntry);
          }
          localwgg.a(localStoryAlbumEntry.getId());
        }
      }
      catch (Exception paramList)
      {
        for (;;)
        {
          StoryAlbumEntry localStoryAlbumEntry;
          yuk.c("Q.qqstory.recommendAlbum.logic.StoryScanManager", "insertAlbumToDb exception=%s", paramList);
          return false;
          bool = false;
          break;
          localEntityManager.persistOrReplace(localStoryAlbumEntry);
        }
      }
      finally
      {
        localEntityManager.getTransaction().end();
      }
    }
    label226:
    localEntityManager.getTransaction().commit();
    localEntityManager.getTransaction().end();
    return true;
  }
  
  public boolean a(wgg paramwgg)
  {
    yuk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "deletedAlbumById=" + paramwgg);
    EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
    paramwgg = paramwgg.a();
    paramwgg.setStatus(1001);
    return localEntityManager.update(paramwgg);
  }
  
  public List<wgg> b()
  {
    ArrayList localArrayList = new ArrayList();
    EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
    Object localObject = wte.a(localEntityManager, StoryAlbumEntry.class, StoryAlbumEntry.class.getSimpleName(), null, null);
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      StoryAlbumEntry localStoryAlbumEntry = (StoryAlbumEntry)((Iterator)localObject).next();
      wgg localwgg;
      try
      {
        localwgg = wgg.a(localStoryAlbumEntry);
        if (!localwgg.c()) {
          break label144;
        }
        if (localwgg.c() < 2) {
          a(localwgg, 10);
        }
        localArrayList.add(localwgg);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        znw.a("DB info have error:" + localInvalidProtocolBufferMicroException, new Object[0]);
      }
      continue;
      label144:
      yuk.e("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getAlbumListFromDB we find the illegal album and deleted it : " + localwgg);
      localInvalidProtocolBufferMicroException.setStatus(1001);
      localEntityManager.remove(localInvalidProtocolBufferMicroException);
    }
    a(localArrayList);
    yuk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getAlbumListFromDB reslut=" + localArrayList);
    return localArrayList;
  }
  
  public void b()
  {
    ((wtn)wth.a(26)).b(this);
    this.jdField_a_of_type_Aasb.b();
  }
  
  public boolean b(Context paramContext)
  {
    if (a(paramContext)) {
      return this.jdField_a_of_type_Wfn.c();
    }
    return false;
  }
  
  public boolean b(String paramString)
  {
    return this.jdField_a_of_type_Wfn.a(paramString);
  }
  
  public List<whf> c()
  {
    return this.jdField_a_of_type_Wfn.a();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Wfn.a();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Int != 0)
    {
      yuk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "scan task is running so ignore this request.");
      return;
    }
    yuk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "start scan");
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Int = 1;
    wgu localwgu = new wgu();
    Context localContext = QQStoryContext.a().a().getBaseContext();
    Stream.of(Integer.valueOf(0)).map(new ThreadOffFunction("Q.qqstory.recommendAlbum.logic.StoryScanManager", 2)).map(new wgs(localContext, localwgu)).map(new wgt(localwgu)).map(new wgr(localwgu)).map(new wgq(localwgu)).subscribe(new wfw(this, localwgu));
  }
  
  public void e()
  {
    this.jdField_a_of_type_Wfn.c();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Wfn.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wfv
 * JD-Core Version:    0.7.0.1
 */