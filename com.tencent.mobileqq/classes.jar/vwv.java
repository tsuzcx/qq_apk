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

public class vwv
  extends wio
  implements wjb
{
  private volatile int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  aady jdField_a_of_type_Aady = null;
  private vwo jdField_a_of_type_Vwo;
  private wjl jdField_a_of_type_Wjl;
  
  public static String a(@NonNull List<vxg> paramList)
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
      switch (((vxg)paramList.next()).jdField_a_of_type_Int)
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
  
  public static List<vyl> a(@NonNull HashMap<String, vxf> paramHashMap)
  {
    ArrayList localArrayList = new ArrayList(paramHashMap.size());
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      vxf localvxf = (vxf)((Map.Entry)paramHashMap.next()).getValue();
      if (localvxf.a != null) {
        localArrayList.add(localvxf.a);
      }
    }
    return localArrayList;
  }
  
  public static List<vxh> a(vxg paramvxg, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = paramvxg.a();
    if (localList.size() < paramInt)
    {
      localArrayList.addAll(localList);
      localObject1 = localList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((vxh)((Iterator)localObject1).next()).a(true);
      }
      paramvxg.a(localList);
      return localArrayList;
    }
    Object localObject1 = localList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (vxh)((Iterator)localObject1).next();
      if (((vxh)localObject2).a()) {
        ((vxh)localObject2).a(false);
      }
    }
    localObject1 = new vyq();
    ((vyq)localObject1).a(localList);
    localObject1 = ((vyq)localObject1).a(paramInt, null, 0).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (List)((Iterator)localObject1).next();
      ((vxh)((List)localObject2).get(0)).a(true);
      localArrayList.add(((List)localObject2).get(0));
    }
    paramvxg.a(localList);
    return localArrayList;
  }
  
  private void a(long paramLong1, long paramLong2)
  {
    ykq.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "saveScanTime lastDateAlbumTime=" + paramLong1 + " ,lastScanPictureTime=" + paramLong2);
    wjl localwjl = (wjl)wjs.a(10);
    localwjl.b("key_last_pic_scan_time", Long.valueOf(paramLong2));
    localwjl.b("key_last_date_album_time", Long.valueOf(paramLong1));
    localwjl.b("key_story_home_scan_time", Long.valueOf(paramLong2));
  }
  
  public static void a(List<vxg> paramList)
  {
    if (paramList.isEmpty()) {
      return;
    }
    Collections.sort(paramList, new vwx());
  }
  
  private void a(vxu paramvxu)
  {
    Object localObject1 = (wjl)wjs.a(10);
    if ((TextUtils.isEmpty(paramvxu.a)) || (TextUtils.isEmpty(paramvxu.b)))
    {
      localObject2 = (String)((wjl)localObject1).b("key_album_debug_k", "");
      localObject1 = (String)((wjl)localObject1).b("key_album_debug_sse", "");
      ykq.e("Q.qqstory.recommendAlbum.logic.StoryScanManager", "保存K means 的调试信息失败:" + paramvxu.a + " 和 " + paramvxu.b);
      ykq.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "sp K means debug sse info:" + (String)localObject1 + " time info:" + (String)localObject2);
      return;
    }
    if (paramvxu.a())
    {
      ((wjl)localObject1).b("key_album_debug_k", paramvxu.a);
      ((wjl)localObject1).b("key_album_debug_sse", paramvxu.b);
      ykq.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "sp K means debug sse info:" + paramvxu.b + " time info:" + paramvxu.a);
      return;
    }
    Object localObject2 = paramvxu.a.split(";");
    paramvxu = paramvxu.b.split(";");
    ((wjl)localObject1).b("key_album_debug_k", localObject2[0]);
    ((wjl)localObject1).b("key_album_debug_sse", paramvxu[0]);
    ykq.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "sp K means debug sse info:" + paramvxu[0] + " time info:" + localObject2[0]);
  }
  
  public static void b(@NonNull List<vxh> paramList)
  {
    Collections.sort(paramList, new vwy());
  }
  
  public List<vxg> a()
  {
    ArrayList localArrayList = new ArrayList();
    wjl localwjl = (wjl)wjs.a(10);
    long l = ((Long)localwjl.b("key_last_home_time", Long.valueOf(-1L))).longValue();
    EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
    Object localObject = wjp.a(localEntityManager, StoryAlbumEntry.class, StoryAlbumEntry.class.getSimpleName(), "state=0 ", null, "startTime desc");
    if ((localObject == null) || (((List)localObject).isEmpty())) {
      return localArrayList;
    }
    ykq.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getNewStoryAlbum : new album time=%s,last time=%d", new Object[] { Long.valueOf(((StoryAlbumEntry)((List)localObject).get(0)).startTime), Long.valueOf(l) });
    if (((StoryAlbumEntry)((List)localObject).get(0)).startTime <= l) {
      return localArrayList;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      StoryAlbumEntry localStoryAlbumEntry = (StoryAlbumEntry)((Iterator)localObject).next();
      vxg localvxg;
      try
      {
        localvxg = vxg.a(localStoryAlbumEntry);
        if (!localvxg.c()) {
          break label241;
        }
        localArrayList.add(localvxg);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        zdl.a("getNewStoryAlbum DB info have error:" + localInvalidProtocolBufferMicroException, new Object[0]);
      }
      continue;
      label241:
      ykq.e("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getNewStoryAlbum we find the illegal album and deleted it : " + localvxg);
      localInvalidProtocolBufferMicroException.setStatus(1001);
      localEntityManager.remove(localInvalidProtocolBufferMicroException);
    }
    ykq.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getNewStoryAlbum reslut=%s", new Object[] { localArrayList });
    if (localArrayList.isEmpty()) {
      return localArrayList;
    }
    if (((vxg)localArrayList.get(0)).f() <= l)
    {
      localArrayList.clear();
      return localArrayList;
    }
    localwjl.b("key_last_home_time", Long.valueOf(((vxg)localArrayList.get(0)).f()));
    return localArrayList;
  }
  
  public List<vxa> a(long paramLong1, long paramLong2)
  {
    return this.jdField_a_of_type_Vwo.a(paramLong1, paramLong2);
  }
  
  @NonNull
  public List<vxh> a(Context paramContext)
  {
    wjl localwjl = (wjl)wjs.a(10);
    long l = ((Long)localwjl.b("key_story_home_scan_time", Long.valueOf(-1L))).longValue();
    paramContext = a(paramContext, Math.max(System.currentTimeMillis() / 1000L - 259200L, l));
    ykq.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getNewScanPicList  result=" + paramContext);
    if (paramContext.size() >= 10)
    {
      localwjl.b("key_story_home_scan_time", Long.valueOf(((vxh)paramContext.get(0)).b));
      return paramContext;
    }
    return null;
  }
  
  @NonNull
  public List<vxh> a(Context paramContext, long paramLong)
  {
    ykq.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getNewPicList scan time = " + paramLong);
    new ArrayList();
    return new vwn().a(paramContext, 1L + paramLong, false, 500);
  }
  
  public vwo a()
  {
    return this.jdField_a_of_type_Vwo;
  }
  
  public void a()
  {
    ((wjy)wjs.a(26)).a(this);
    this.jdField_a_of_type_Wjl = ((wjl)wjs.a(10));
    this.jdField_a_of_type_Aady = aady.a();
    this.jdField_a_of_type_Aady.a();
    this.jdField_a_of_type_Vwo = new vwo();
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
        ykq.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "trimMemory to be 5");
      } while (Build.VERSION.SDK_INT < 17);
      return;
    }
    ykq.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "clearAllMemory");
  }
  
  public void a(boolean paramBoolean)
  {
    int j = 2;
    Object localObject = this.jdField_a_of_type_Aady;
    if (paramBoolean)
    {
      i = 2;
      ((aady)localObject).b(i);
      localObject = (wjl)wjs.a(10);
      if (!paramBoolean) {
        break label54;
      }
    }
    label54:
    for (int i = j;; i = 1)
    {
      ((wjl)localObject).b("sp_key_user_enable_album_scan", Integer.valueOf(i));
      return;
      i = 1;
      break;
    }
  }
  
  public boolean a()
  {
    int i = ((Integer)this.jdField_a_of_type_Wjl.b("sp_key_user_enable_album_scan", Integer.valueOf(0))).intValue();
    if ((i == 0) || (i == -1)) {
      return this.jdField_a_of_type_Vwo.b();
    }
    return i != 1;
  }
  
  public boolean a(long paramLong)
  {
    ykq.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "deletedAlbumById=" + paramLong);
    if (paramLong >= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      zdl.a(bool, "It is not allowed to deleted the id<0");
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
    if ((this.jdField_a_of_type_Vwo != null) && (this.jdField_a_of_type_Vwo.a()))
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
          ykq.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "isAlbumModuleEnable :%s , isVersionOk :%s , isStoragePermitOk :%s , isConfigOk :%s", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool3), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
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
    return this.jdField_a_of_type_Vwo.b(paramString);
  }
  
  public boolean a(@NonNull List<vxg> paramList, boolean paramBoolean)
  {
    ykq.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "insertAlbumToDb albums=" + paramList.size() + " append=" + paramBoolean);
    boolean bool;
    if (!paramList.isEmpty()) {
      bool = true;
    }
    EntityManager localEntityManager;
    for (;;)
    {
      zdl.a(bool, "It is not allow save the empty albums to DB ");
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
          vxg localvxg = (vxg)paramList.next();
          localStoryAlbumEntry = localvxg.a();
          if (localStoryAlbumEntry.getId() <= 0L) {
            break;
          }
          localStoryAlbumEntry.setStatus(1001);
          if (!localEntityManager.update(localStoryAlbumEntry))
          {
            localStoryAlbumEntry.setStatus(1000);
            localEntityManager.persistOrReplace(localStoryAlbumEntry);
          }
          localvxg.a(localStoryAlbumEntry.getId());
        }
      }
      catch (Exception paramList)
      {
        for (;;)
        {
          StoryAlbumEntry localStoryAlbumEntry;
          ykq.c("Q.qqstory.recommendAlbum.logic.StoryScanManager", "insertAlbumToDb exception=%s", paramList);
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
  
  public boolean a(vxg paramvxg)
  {
    ykq.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "deletedAlbumById=" + paramvxg);
    EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
    paramvxg = paramvxg.a();
    paramvxg.setStatus(1001);
    return localEntityManager.update(paramvxg);
  }
  
  public List<vxg> b()
  {
    ArrayList localArrayList = new ArrayList();
    EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
    Object localObject = wjp.a(localEntityManager, StoryAlbumEntry.class, StoryAlbumEntry.class.getSimpleName(), null, null);
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      StoryAlbumEntry localStoryAlbumEntry = (StoryAlbumEntry)((Iterator)localObject).next();
      vxg localvxg;
      try
      {
        localvxg = vxg.a(localStoryAlbumEntry);
        if (!localvxg.c()) {
          break label144;
        }
        if (localvxg.c() < 2) {
          a(localvxg, 10);
        }
        localArrayList.add(localvxg);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        zdl.a("DB info have error:" + localInvalidProtocolBufferMicroException, new Object[0]);
      }
      continue;
      label144:
      ykq.e("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getAlbumListFromDB we find the illegal album and deleted it : " + localvxg);
      localInvalidProtocolBufferMicroException.setStatus(1001);
      localEntityManager.remove(localInvalidProtocolBufferMicroException);
    }
    a(localArrayList);
    ykq.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getAlbumListFromDB reslut=" + localArrayList);
    return localArrayList;
  }
  
  public void b()
  {
    ((wjy)wjs.a(26)).b(this);
    this.jdField_a_of_type_Aady.b();
  }
  
  public boolean b(Context paramContext)
  {
    if (a(paramContext)) {
      return this.jdField_a_of_type_Vwo.c();
    }
    return false;
  }
  
  public boolean b(String paramString)
  {
    return this.jdField_a_of_type_Vwo.a(paramString);
  }
  
  public List<vyf> c()
  {
    return this.jdField_a_of_type_Vwo.a();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Int != 0)
    {
      ykq.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "scan task is running so ignore this request.");
      return;
    }
    ykq.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "start scan");
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Int = 1;
    vxu localvxu = new vxu();
    Context localContext = QQStoryContext.a().a().getBaseContext();
    Stream.of(Integer.valueOf(0)).map(new ThreadOffFunction("Q.qqstory.recommendAlbum.logic.StoryScanManager", 2)).map(new vxs(localContext, localvxu)).map(new vxt(localvxu)).map(new vxr(localvxu)).map(new vxq(localvxu)).subscribe(new vww(this, localvxu));
  }
  
  public void d()
  {
    this.jdField_a_of_type_Vwo.c();
  }
  
  public void e()
  {
    this.jdField_a_of_type_Vwo.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vwv
 * JD-Core Version:    0.7.0.1
 */