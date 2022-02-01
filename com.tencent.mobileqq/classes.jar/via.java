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

public class via
  extends vtt
  implements vug
{
  private volatile int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private vht jdField_a_of_type_Vht;
  private vuq jdField_a_of_type_Vuq;
  zon jdField_a_of_type_Zon = null;
  
  public static String a(@NonNull List<vil> paramList)
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
      switch (((vil)paramList.next()).jdField_a_of_type_Int)
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
  
  public static List<vjq> a(@NonNull HashMap<String, vik> paramHashMap)
  {
    ArrayList localArrayList = new ArrayList(paramHashMap.size());
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      vik localvik = (vik)((Map.Entry)paramHashMap.next()).getValue();
      if (localvik.a != null) {
        localArrayList.add(localvik.a);
      }
    }
    return localArrayList;
  }
  
  public static List<vim> a(vil paramvil, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = paramvil.a();
    if (localList.size() < paramInt)
    {
      localArrayList.addAll(localList);
      localObject1 = localList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((vim)((Iterator)localObject1).next()).a(true);
      }
      paramvil.a(localList);
      return localArrayList;
    }
    Object localObject1 = localList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (vim)((Iterator)localObject1).next();
      if (((vim)localObject2).a()) {
        ((vim)localObject2).a(false);
      }
    }
    localObject1 = new vjv();
    ((vjv)localObject1).a(localList);
    localObject1 = ((vjv)localObject1).a(paramInt, null, 0).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (List)((Iterator)localObject1).next();
      ((vim)((List)localObject2).get(0)).a(true);
      localArrayList.add(((List)localObject2).get(0));
    }
    paramvil.a(localList);
    return localArrayList;
  }
  
  private void a(long paramLong1, long paramLong2)
  {
    xvv.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "saveScanTime lastDateAlbumTime=" + paramLong1 + " ,lastScanPictureTime=" + paramLong2);
    vuq localvuq = (vuq)vux.a(10);
    localvuq.b("key_last_pic_scan_time", Long.valueOf(paramLong2));
    localvuq.b("key_last_date_album_time", Long.valueOf(paramLong1));
    localvuq.b("key_story_home_scan_time", Long.valueOf(paramLong2));
  }
  
  public static void a(List<vil> paramList)
  {
    if (paramList.isEmpty()) {
      return;
    }
    Collections.sort(paramList, new vic());
  }
  
  private void a(viz paramviz)
  {
    Object localObject1 = (vuq)vux.a(10);
    if ((TextUtils.isEmpty(paramviz.a)) || (TextUtils.isEmpty(paramviz.b)))
    {
      localObject2 = (String)((vuq)localObject1).b("key_album_debug_k", "");
      localObject1 = (String)((vuq)localObject1).b("key_album_debug_sse", "");
      xvv.e("Q.qqstory.recommendAlbum.logic.StoryScanManager", "保存K means 的调试信息失败:" + paramviz.a + " 和 " + paramviz.b);
      xvv.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "sp K means debug sse info:" + (String)localObject1 + " time info:" + (String)localObject2);
      return;
    }
    if (paramviz.a())
    {
      ((vuq)localObject1).b("key_album_debug_k", paramviz.a);
      ((vuq)localObject1).b("key_album_debug_sse", paramviz.b);
      xvv.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "sp K means debug sse info:" + paramviz.b + " time info:" + paramviz.a);
      return;
    }
    Object localObject2 = paramviz.a.split(";");
    paramviz = paramviz.b.split(";");
    ((vuq)localObject1).b("key_album_debug_k", localObject2[0]);
    ((vuq)localObject1).b("key_album_debug_sse", paramviz[0]);
    xvv.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "sp K means debug sse info:" + paramviz[0] + " time info:" + localObject2[0]);
  }
  
  public static void b(@NonNull List<vim> paramList)
  {
    Collections.sort(paramList, new vid());
  }
  
  public List<vil> a()
  {
    ArrayList localArrayList = new ArrayList();
    vuq localvuq = (vuq)vux.a(10);
    long l = ((Long)localvuq.b("key_last_home_time", Long.valueOf(-1L))).longValue();
    EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
    Object localObject = vuu.a(localEntityManager, StoryAlbumEntry.class, StoryAlbumEntry.class.getSimpleName(), "state=0 ", null, "startTime desc");
    if ((localObject == null) || (((List)localObject).isEmpty())) {
      return localArrayList;
    }
    xvv.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getNewStoryAlbum : new album time=%s,last time=%d", new Object[] { Long.valueOf(((StoryAlbumEntry)((List)localObject).get(0)).startTime), Long.valueOf(l) });
    if (((StoryAlbumEntry)((List)localObject).get(0)).startTime <= l) {
      return localArrayList;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      StoryAlbumEntry localStoryAlbumEntry = (StoryAlbumEntry)((Iterator)localObject).next();
      vil localvil;
      try
      {
        localvil = vil.a(localStoryAlbumEntry);
        if (!localvil.c()) {
          break label241;
        }
        localArrayList.add(localvil);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        yos.a("getNewStoryAlbum DB info have error:" + localInvalidProtocolBufferMicroException, new Object[0]);
      }
      continue;
      label241:
      xvv.e("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getNewStoryAlbum we find the illegal album and deleted it : " + localvil);
      localInvalidProtocolBufferMicroException.setStatus(1001);
      localEntityManager.remove(localInvalidProtocolBufferMicroException);
    }
    xvv.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getNewStoryAlbum reslut=%s", new Object[] { localArrayList });
    if (localArrayList.isEmpty()) {
      return localArrayList;
    }
    if (((vil)localArrayList.get(0)).f() <= l)
    {
      localArrayList.clear();
      return localArrayList;
    }
    localvuq.b("key_last_home_time", Long.valueOf(((vil)localArrayList.get(0)).f()));
    return localArrayList;
  }
  
  public List<vif> a(long paramLong1, long paramLong2)
  {
    return this.jdField_a_of_type_Vht.a(paramLong1, paramLong2);
  }
  
  @NonNull
  public List<vim> a(Context paramContext)
  {
    vuq localvuq = (vuq)vux.a(10);
    long l = ((Long)localvuq.b("key_story_home_scan_time", Long.valueOf(-1L))).longValue();
    paramContext = a(paramContext, Math.max(System.currentTimeMillis() / 1000L - 259200L, l));
    xvv.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getNewScanPicList  result=" + paramContext);
    if (paramContext.size() >= 10)
    {
      localvuq.b("key_story_home_scan_time", Long.valueOf(((vim)paramContext.get(0)).b));
      return paramContext;
    }
    return null;
  }
  
  @NonNull
  public List<vim> a(Context paramContext, long paramLong)
  {
    xvv.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getNewPicList scan time = " + paramLong);
    new ArrayList();
    return new vhs().a(paramContext, 1L + paramLong, false, 500);
  }
  
  public vht a()
  {
    return this.jdField_a_of_type_Vht;
  }
  
  public void a()
  {
    ((vvd)vux.a(26)).a(this);
    this.jdField_a_of_type_Vuq = ((vuq)vux.a(10));
    this.jdField_a_of_type_Zon = zon.a();
    this.jdField_a_of_type_Zon.a();
    this.jdField_a_of_type_Vht = new vht();
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
        xvv.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "trimMemory to be 5");
      } while (Build.VERSION.SDK_INT < 17);
      return;
    }
    xvv.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "clearAllMemory");
  }
  
  public void a(boolean paramBoolean)
  {
    int j = 2;
    Object localObject = this.jdField_a_of_type_Zon;
    if (paramBoolean)
    {
      i = 2;
      ((zon)localObject).b(i);
      localObject = (vuq)vux.a(10);
      if (!paramBoolean) {
        break label54;
      }
    }
    label54:
    for (int i = j;; i = 1)
    {
      ((vuq)localObject).b("sp_key_user_enable_album_scan", Integer.valueOf(i));
      return;
      i = 1;
      break;
    }
  }
  
  public boolean a()
  {
    int i = ((Integer)this.jdField_a_of_type_Vuq.b("sp_key_user_enable_album_scan", Integer.valueOf(0))).intValue();
    if ((i == 0) || (i == -1)) {
      return this.jdField_a_of_type_Vht.b();
    }
    return i != 1;
  }
  
  public boolean a(long paramLong)
  {
    xvv.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "deletedAlbumById=" + paramLong);
    if (paramLong >= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      yos.a(bool, "It is not allowed to deleted the id<0");
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
    if ((this.jdField_a_of_type_Vht != null) && (this.jdField_a_of_type_Vht.a()))
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
          xvv.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "isAlbumModuleEnable :%s , isVersionOk :%s , isStoragePermitOk :%s , isConfigOk :%s", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool3), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
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
    return this.jdField_a_of_type_Vht.b(paramString);
  }
  
  public boolean a(@NonNull List<vil> paramList, boolean paramBoolean)
  {
    xvv.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "insertAlbumToDb albums=" + paramList.size() + " append=" + paramBoolean);
    boolean bool;
    if (!paramList.isEmpty()) {
      bool = true;
    }
    EntityManager localEntityManager;
    for (;;)
    {
      yos.a(bool, "It is not allow save the empty albums to DB ");
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
          vil localvil = (vil)paramList.next();
          localStoryAlbumEntry = localvil.a();
          if (localStoryAlbumEntry.getId() <= 0L) {
            break;
          }
          localStoryAlbumEntry.setStatus(1001);
          if (!localEntityManager.update(localStoryAlbumEntry))
          {
            localStoryAlbumEntry.setStatus(1000);
            localEntityManager.persistOrReplace(localStoryAlbumEntry);
          }
          localvil.a(localStoryAlbumEntry.getId());
        }
      }
      catch (Exception paramList)
      {
        for (;;)
        {
          StoryAlbumEntry localStoryAlbumEntry;
          xvv.c("Q.qqstory.recommendAlbum.logic.StoryScanManager", "insertAlbumToDb exception=%s", paramList);
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
  
  public boolean a(vil paramvil)
  {
    xvv.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "deletedAlbumById=" + paramvil);
    EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
    paramvil = paramvil.a();
    paramvil.setStatus(1001);
    return localEntityManager.update(paramvil);
  }
  
  public List<vil> b()
  {
    ArrayList localArrayList = new ArrayList();
    EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
    Object localObject = vuu.a(localEntityManager, StoryAlbumEntry.class, StoryAlbumEntry.class.getSimpleName(), null, null);
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      StoryAlbumEntry localStoryAlbumEntry = (StoryAlbumEntry)((Iterator)localObject).next();
      vil localvil;
      try
      {
        localvil = vil.a(localStoryAlbumEntry);
        if (!localvil.c()) {
          break label144;
        }
        if (localvil.c() < 2) {
          a(localvil, 10);
        }
        localArrayList.add(localvil);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        yos.a("DB info have error:" + localInvalidProtocolBufferMicroException, new Object[0]);
      }
      continue;
      label144:
      xvv.e("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getAlbumListFromDB we find the illegal album and deleted it : " + localvil);
      localInvalidProtocolBufferMicroException.setStatus(1001);
      localEntityManager.remove(localInvalidProtocolBufferMicroException);
    }
    a(localArrayList);
    xvv.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getAlbumListFromDB reslut=" + localArrayList);
    return localArrayList;
  }
  
  public void b()
  {
    ((vvd)vux.a(26)).b(this);
    this.jdField_a_of_type_Zon.b();
  }
  
  public boolean b(Context paramContext)
  {
    if (a(paramContext)) {
      return this.jdField_a_of_type_Vht.c();
    }
    return false;
  }
  
  public boolean b(String paramString)
  {
    return this.jdField_a_of_type_Vht.a(paramString);
  }
  
  public List<vjk> c()
  {
    return this.jdField_a_of_type_Vht.a();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Int != 0)
    {
      xvv.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "scan task is running so ignore this request.");
      return;
    }
    xvv.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "start scan");
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Int = 1;
    viz localviz = new viz();
    Context localContext = QQStoryContext.a().a().getBaseContext();
    Stream.of(Integer.valueOf(0)).map(new ThreadOffFunction("Q.qqstory.recommendAlbum.logic.StoryScanManager", 2)).map(new vix(localContext, localviz)).map(new viy(localviz)).map(new viw(localviz)).map(new viv(localviz)).subscribe(new vib(this, localviz));
  }
  
  public void d()
  {
    this.jdField_a_of_type_Vht.c();
  }
  
  public void e()
  {
    this.jdField_a_of_type_Vht.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     via
 * JD-Core Version:    0.7.0.1
 */