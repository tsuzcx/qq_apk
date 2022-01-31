import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.StoryAlbumEntry;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class uio
  extends uuw
  implements uvj
{
  private volatile int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private uig jdField_a_of_type_Uig;
  private uvt jdField_a_of_type_Uvt;
  yqz jdField_a_of_type_Yqz = null;
  
  public static String a(@NonNull List<uiz> paramList)
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
      switch (((uiz)paramList.next()).jdField_a_of_type_Int)
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
  
  public static List<uke> a(@NonNull HashMap<String, uiy> paramHashMap)
  {
    ArrayList localArrayList = new ArrayList(paramHashMap.size());
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      uiy localuiy = (uiy)((Map.Entry)paramHashMap.next()).getValue();
      if (localuiy.a != null) {
        localArrayList.add(localuiy.a);
      }
    }
    return localArrayList;
  }
  
  public static List<uja> a(uiz paramuiz, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = paramuiz.a();
    if (localList.size() < paramInt)
    {
      localArrayList.addAll(localList);
      localObject1 = localList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((uja)((Iterator)localObject1).next()).a(true);
      }
      paramuiz.a(localList);
      return localArrayList;
    }
    Object localObject1 = localList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (uja)((Iterator)localObject1).next();
      if (((uja)localObject2).a()) {
        ((uja)localObject2).a(false);
      }
    }
    localObject1 = new ukj();
    ((ukj)localObject1).a(localList);
    localObject1 = ((ukj)localObject1).a(paramInt, null, 0).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (List)((Iterator)localObject1).next();
      ((uja)((List)localObject2).get(0)).a(true);
      localArrayList.add(((List)localObject2).get(0));
    }
    paramuiz.a(localList);
    return localArrayList;
  }
  
  private void a(long paramLong1, long paramLong2)
  {
    wxe.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "saveScanTime lastDateAlbumTime=" + paramLong1 + " ,lastScanPictureTime=" + paramLong2);
    uvt localuvt = (uvt)uwa.a(10);
    localuvt.b("key_last_pic_scan_time", Long.valueOf(paramLong2));
    localuvt.b("key_last_date_album_time", Long.valueOf(paramLong1));
    localuvt.b("key_story_home_scan_time", Long.valueOf(paramLong2));
  }
  
  public static void a(List<uiz> paramList)
  {
    if (paramList.isEmpty()) {
      return;
    }
    Collections.sort(paramList, new uiq());
  }
  
  private void a(ujn paramujn)
  {
    Object localObject1 = (uvt)uwa.a(10);
    if ((TextUtils.isEmpty(paramujn.a)) || (TextUtils.isEmpty(paramujn.b)))
    {
      localObject2 = (String)((uvt)localObject1).b("key_album_debug_k", "");
      localObject1 = (String)((uvt)localObject1).b("key_album_debug_sse", "");
      wxe.e("Q.qqstory.recommendAlbum.logic.StoryScanManager", "保存K means 的调试信息失败:" + paramujn.a + " 和 " + paramujn.b);
      wxe.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "sp K means debug sse info:" + (String)localObject1 + " time info:" + (String)localObject2);
      return;
    }
    if (paramujn.a())
    {
      ((uvt)localObject1).b("key_album_debug_k", paramujn.a);
      ((uvt)localObject1).b("key_album_debug_sse", paramujn.b);
      wxe.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "sp K means debug sse info:" + paramujn.b + " time info:" + paramujn.a);
      return;
    }
    Object localObject2 = paramujn.a.split(";");
    paramujn = paramujn.b.split(";");
    ((uvt)localObject1).b("key_album_debug_k", localObject2[0]);
    ((uvt)localObject1).b("key_album_debug_sse", paramujn[0]);
    wxe.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "sp K means debug sse info:" + paramujn[0] + " time info:" + localObject2[0]);
  }
  
  public static void b(@NonNull List<uja> paramList)
  {
    Collections.sort(paramList, new uir());
  }
  
  public List<uiz> a()
  {
    ArrayList localArrayList = new ArrayList();
    uvt localuvt = (uvt)uwa.a(10);
    long l = ((Long)localuvt.b("key_last_home_time", Long.valueOf(-1L))).longValue();
    awgf localawgf = QQStoryContext.a().a().createEntityManager();
    Object localObject = uvx.a(localawgf, StoryAlbumEntry.class, StoryAlbumEntry.class.getSimpleName(), "state=0 ", null, "startTime desc");
    if ((localObject == null) || (((List)localObject).isEmpty())) {
      return localArrayList;
    }
    wxe.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getNewStoryAlbum : new album time=%s,last time=%d", new Object[] { Long.valueOf(((StoryAlbumEntry)((List)localObject).get(0)).startTime), Long.valueOf(l) });
    if (((StoryAlbumEntry)((List)localObject).get(0)).startTime <= l) {
      return localArrayList;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      StoryAlbumEntry localStoryAlbumEntry = (StoryAlbumEntry)((Iterator)localObject).next();
      uiz localuiz;
      try
      {
        localuiz = uiz.a(localStoryAlbumEntry);
        if (!localuiz.c()) {
          break label241;
        }
        localArrayList.add(localuiz);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        xqq.a("getNewStoryAlbum DB info have error:" + localInvalidProtocolBufferMicroException, new Object[0]);
      }
      continue;
      label241:
      wxe.e("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getNewStoryAlbum we find the illegal album and deleted it : " + localuiz);
      localInvalidProtocolBufferMicroException.setStatus(1001);
      localawgf.b(localInvalidProtocolBufferMicroException);
    }
    wxe.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getNewStoryAlbum reslut=%s", new Object[] { localArrayList });
    if (localArrayList.isEmpty()) {
      return localArrayList;
    }
    if (((uiz)localArrayList.get(0)).f() <= l)
    {
      localArrayList.clear();
      return localArrayList;
    }
    localuvt.b("key_last_home_time", Long.valueOf(((uiz)localArrayList.get(0)).f()));
    return localArrayList;
  }
  
  public List<uit> a(long paramLong1, long paramLong2)
  {
    return this.jdField_a_of_type_Uig.a(paramLong1, paramLong2);
  }
  
  @NonNull
  public List<uja> a(Context paramContext)
  {
    uvt localuvt = (uvt)uwa.a(10);
    long l = ((Long)localuvt.b("key_story_home_scan_time", Long.valueOf(-1L))).longValue();
    paramContext = a(paramContext, Math.max(System.currentTimeMillis() / 1000L - 259200L, l));
    wxe.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getNewScanPicList  result=" + paramContext);
    if (paramContext.size() >= 10)
    {
      localuvt.b("key_story_home_scan_time", Long.valueOf(((uja)paramContext.get(0)).b));
      return paramContext;
    }
    return null;
  }
  
  @NonNull
  public List<uja> a(Context paramContext, long paramLong)
  {
    wxe.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getNewPicList scan time = " + paramLong);
    new ArrayList();
    return new uif().a(paramContext, 1L + paramLong, false, 500);
  }
  
  public uig a()
  {
    return this.jdField_a_of_type_Uig;
  }
  
  public void a()
  {
    ((uwg)uwa.a(26)).a(this);
    this.jdField_a_of_type_Uvt = ((uvt)uwa.a(10));
    this.jdField_a_of_type_Yqz = yqz.a();
    this.jdField_a_of_type_Yqz.a();
    this.jdField_a_of_type_Uig = new uig();
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
        wxe.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "trimMemory to be 5");
      } while (Build.VERSION.SDK_INT < 17);
      return;
    }
    wxe.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "clearAllMemory");
  }
  
  public void a(boolean paramBoolean)
  {
    int j = 2;
    Object localObject = this.jdField_a_of_type_Yqz;
    if (paramBoolean)
    {
      i = 2;
      ((yqz)localObject).b(i);
      localObject = (uvt)uwa.a(10);
      if (!paramBoolean) {
        break label54;
      }
    }
    label54:
    for (int i = j;; i = 1)
    {
      ((uvt)localObject).b("sp_key_user_enable_album_scan", Integer.valueOf(i));
      return;
      i = 1;
      break;
    }
  }
  
  public boolean a()
  {
    int i = ((Integer)this.jdField_a_of_type_Uvt.b("sp_key_user_enable_album_scan", Integer.valueOf(0))).intValue();
    if ((i == 0) || (i == -1)) {
      return this.jdField_a_of_type_Uig.b();
    }
    return i != 1;
  }
  
  public boolean a(long paramLong)
  {
    wxe.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "deletedAlbumById=" + paramLong);
    if (paramLong >= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      xqq.a(bool, "It is not allowed to deleted the id<0");
      awgf localawgf = QQStoryContext.a().a().createEntityManager();
      StoryAlbumEntry localStoryAlbumEntry = new StoryAlbumEntry();
      localStoryAlbumEntry.setId(paramLong);
      localStoryAlbumEntry.setStatus(1001);
      return localawgf.b(localStoryAlbumEntry);
    }
  }
  
  public boolean a(Context paramContext)
  {
    boolean bool2;
    if ((this.jdField_a_of_type_Uig != null) && (this.jdField_a_of_type_Uig.a()))
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
          wxe.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "isAlbumModuleEnable :%s , isVersionOk :%s , isStoragePermitOk :%s , isConfigOk :%s", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool3), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
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
    return this.jdField_a_of_type_Uig.b(paramString);
  }
  
  public boolean a(@NonNull List<uiz> paramList, boolean paramBoolean)
  {
    wxe.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "insertAlbumToDb albums=" + paramList.size() + " append=" + paramBoolean);
    boolean bool;
    if (!paramList.isEmpty()) {
      bool = true;
    }
    awgf localawgf;
    for (;;)
    {
      xqq.a(bool, "It is not allow save the empty albums to DB ");
      localawgf = QQStoryContext.a().a().createEntityManager();
      localawgf.a().a();
      if (!paramBoolean) {
        localawgf.a(StoryAlbumEntry.class);
      }
      try
      {
        paramList = paramList.iterator();
        for (;;)
        {
          if (!paramList.hasNext()) {
            break label226;
          }
          uiz localuiz = (uiz)paramList.next();
          localStoryAlbumEntry = localuiz.a();
          if (localStoryAlbumEntry.getId() <= 0L) {
            break;
          }
          localStoryAlbumEntry.setStatus(1001);
          if (!localawgf.a(localStoryAlbumEntry))
          {
            localStoryAlbumEntry.setStatus(1000);
            localawgf.b(localStoryAlbumEntry);
          }
          localuiz.a(localStoryAlbumEntry.getId());
        }
      }
      catch (Exception paramList)
      {
        for (;;)
        {
          StoryAlbumEntry localStoryAlbumEntry;
          wxe.c("Q.qqstory.recommendAlbum.logic.StoryScanManager", "insertAlbumToDb exception=%s", paramList);
          return false;
          bool = false;
          break;
          localawgf.b(localStoryAlbumEntry);
        }
      }
      finally
      {
        localawgf.a().b();
      }
    }
    label226:
    localawgf.a().c();
    localawgf.a().b();
    return true;
  }
  
  public boolean a(uiz paramuiz)
  {
    wxe.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "deletedAlbumById=" + paramuiz);
    awgf localawgf = QQStoryContext.a().a().createEntityManager();
    paramuiz = paramuiz.a();
    paramuiz.setStatus(1001);
    return localawgf.a(paramuiz);
  }
  
  public List<uiz> b()
  {
    ArrayList localArrayList = new ArrayList();
    awgf localawgf = QQStoryContext.a().a().createEntityManager();
    Object localObject = uvx.a(localawgf, StoryAlbumEntry.class, StoryAlbumEntry.class.getSimpleName(), null, null);
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      StoryAlbumEntry localStoryAlbumEntry = (StoryAlbumEntry)((Iterator)localObject).next();
      uiz localuiz;
      try
      {
        localuiz = uiz.a(localStoryAlbumEntry);
        if (!localuiz.c()) {
          break label144;
        }
        if (localuiz.c() < 2) {
          a(localuiz, 10);
        }
        localArrayList.add(localuiz);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        xqq.a("DB info have error:" + localInvalidProtocolBufferMicroException, new Object[0]);
      }
      continue;
      label144:
      wxe.e("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getAlbumListFromDB we find the illegal album and deleted it : " + localuiz);
      localInvalidProtocolBufferMicroException.setStatus(1001);
      localawgf.b(localInvalidProtocolBufferMicroException);
    }
    a(localArrayList);
    wxe.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getAlbumListFromDB reslut=" + localArrayList);
    return localArrayList;
  }
  
  public void b()
  {
    ((uwg)uwa.a(26)).b(this);
    this.jdField_a_of_type_Yqz.b();
  }
  
  public boolean b(Context paramContext)
  {
    if (a(paramContext)) {
      return this.jdField_a_of_type_Uig.c();
    }
    return false;
  }
  
  public boolean b(String paramString)
  {
    return this.jdField_a_of_type_Uig.a(paramString);
  }
  
  public List<ujy> c()
  {
    return this.jdField_a_of_type_Uig.a();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Uig.a();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Int != 0)
    {
      wxe.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "scan task is running so ignore this request.");
      return;
    }
    wxe.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "start scan");
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Int = 1;
    ujn localujn = new ujn();
    Context localContext = QQStoryContext.a().a().getBaseContext();
    Stream.of(Integer.valueOf(0)).map(new ThreadOffFunction("Q.qqstory.recommendAlbum.logic.StoryScanManager", 2)).map(new ujl(localContext, localujn)).map(new ujm(localujn)).map(new ujk(localujn)).map(new ujj(localujn)).subscribe(new uip(this, localujn));
  }
  
  public void e()
  {
    this.jdField_a_of_type_Uig.c();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Uig.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uio
 * JD-Core Version:    0.7.0.1
 */