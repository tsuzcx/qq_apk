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

public class pju
  extends prz
  implements psk
{
  private pjp jdField_a_of_type_Pjp;
  private psr jdField_a_of_type_Psr;
  skj mClient = null;
  private volatile int mState = 0;
  private long zS;
  
  private void L(long paramLong1, long paramLong2)
  {
    ram.w("Q.qqstory.recommendAlbum.logic.StoryScanManager", "saveScanTime lastDateAlbumTime=" + paramLong1 + " ,lastScanPictureTime=" + paramLong2);
    psr localpsr = (psr)psx.a(10);
    localpsr.n("key_last_pic_scan_time", Long.valueOf(paramLong2));
    localpsr.n("key_last_date_album_time", Long.valueOf(paramLong1));
    localpsr.n("key_story_home_scan_time", Long.valueOf(paramLong2));
  }
  
  public static List<pkx.a> a(@NonNull HashMap<String, pkc> paramHashMap)
  {
    ArrayList localArrayList = new ArrayList(paramHashMap.size());
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      pkc localpkc = (pkc)((Map.Entry)paramHashMap.next()).getValue();
      if (localpkc.a != null) {
        localArrayList.add(localpkc.a);
      }
    }
    return localArrayList;
  }
  
  public static List<pkd.a> a(pkd parampkd, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = parampkd.bD();
    if (localList.size() < paramInt)
    {
      localArrayList.addAll(localList);
      localObject1 = localList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((pkd.a)((Iterator)localObject1).next()).rD(true);
      }
      parampkd.dN(localList);
      return localArrayList;
    }
    Object localObject1 = localList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (pkd.a)((Iterator)localObject1).next();
      if (((pkd.a)localObject2).Ig()) {
        ((pkd.a)localObject2).rD(false);
      }
    }
    localObject1 = new pla();
    ((pla)localObject1).dK(localList);
    localObject1 = ((pla)localObject1).a(paramInt, null, 0).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (List)((Iterator)localObject1).next();
      ((pkd.a)((List)localObject2).get(0)).rD(true);
      localArrayList.add(((List)localObject2).get(0));
    }
    parampkd.dN(localList);
    return localArrayList;
  }
  
  private void a(pkm parampkm)
  {
    Object localObject1 = (psr)psx.a(10);
    if ((TextUtils.isEmpty(parampkm.asU)) || (TextUtils.isEmpty(parampkm.asV)))
    {
      localObject2 = (String)((psr)localObject1).c("key_album_debug_k", "");
      localObject1 = (String)((psr)localObject1).c("key_album_debug_sse", "");
      ram.e("Q.qqstory.recommendAlbum.logic.StoryScanManager", "保存K means 的调试信息失败:" + parampkm.asU + " 和 " + parampkm.asV);
      ram.w("Q.qqstory.recommendAlbum.logic.StoryScanManager", "sp K means debug sse info:" + (String)localObject1 + " time info:" + (String)localObject2);
      return;
    }
    if (parampkm.Ih())
    {
      ((psr)localObject1).n("key_album_debug_k", parampkm.asU);
      ((psr)localObject1).n("key_album_debug_sse", parampkm.asV);
      ram.w("Q.qqstory.recommendAlbum.logic.StoryScanManager", "sp K means debug sse info:" + parampkm.asV + " time info:" + parampkm.asU);
      return;
    }
    Object localObject2 = parampkm.asU.split(";");
    parampkm = parampkm.asV.split(";");
    ((psr)localObject1).n("key_album_debug_k", localObject2[0]);
    ((psr)localObject1).n("key_album_debug_sse", parampkm[0]);
    ram.w("Q.qqstory.recommendAlbum.logic.StoryScanManager", "sp K means debug sse info:" + parampkm[0] + " time info:" + localObject2[0]);
  }
  
  public static void dH(List<pkd> paramList)
  {
    if (paramList.isEmpty()) {
      return;
    }
    Collections.sort(paramList, new pjw());
  }
  
  public static void dI(@NonNull List<pkd.a> paramList)
  {
    Collections.sort(paramList, new pjx());
  }
  
  public static String r(@NonNull List<pkd> paramList)
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
      switch (((pkd)paramList.next()).mAlbumType)
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
  
  public void Bi()
  {
    this.jdField_a_of_type_Pjp.loadConfig();
  }
  
  public boolean Ic()
  {
    int i = ((Integer)this.jdField_a_of_type_Psr.c("sp_key_user_enable_album_scan", Integer.valueOf(0))).intValue();
    if ((i == 0) || (i == -1)) {
      return this.jdField_a_of_type_Pjp.Ia();
    }
    return i != 1;
  }
  
  @NonNull
  public List<pkd.a> a(Context paramContext, long paramLong)
  {
    ram.w("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getNewPicList scan time = " + paramLong);
    new ArrayList();
    return new pjo().a(paramContext, 1L + paramLong, false, 500);
  }
  
  public pjp a()
  {
    return this.jdField_a_of_type_Pjp;
  }
  
  public boolean a(pkd parampkd)
  {
    ram.w("Q.qqstory.recommendAlbum.logic.StoryScanManager", "deletedAlbumById=" + parampkd);
    EntityManager localEntityManager = QQStoryContext.a().getEntityManagerFactory().createEntityManager();
    parampkd = parampkd.a();
    parampkd.setStatus(1001);
    return localEntityManager.update(parampkd);
  }
  
  public boolean aV(long paramLong)
  {
    ram.w("Q.qqstory.recommendAlbum.logic.StoryScanManager", "deletedAlbumById=" + paramLong);
    if (paramLong >= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      rom.assertTrue(bool, "It is not allowed to deleted the id<0");
      EntityManager localEntityManager = QQStoryContext.a().getEntityManagerFactory().createEntityManager();
      StoryAlbumEntry localStoryAlbumEntry = new StoryAlbumEntry();
      localStoryAlbumEntry.setId(paramLong);
      localStoryAlbumEntry.setStatus(1001);
      return localEntityManager.remove(localStoryAlbumEntry);
    }
  }
  
  public boolean ax(Context paramContext)
  {
    boolean bool2;
    if ((this.jdField_a_of_type_Pjp != null) && (this.jdField_a_of_type_Pjp.HZ()))
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
          ram.w("Q.qqstory.recommendAlbum.logic.StoryScanManager", "isAlbumModuleEnable :%s , isVersionOk :%s , isStoragePermitOk :%s , isConfigOk :%s", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool3), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
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
  
  public boolean ay(Context paramContext)
  {
    if (ax(paramContext)) {
      return this.jdField_a_of_type_Pjp.Ib();
    }
    return false;
  }
  
  public boolean b(@NonNull List<pkd> paramList, boolean paramBoolean)
  {
    ram.w("Q.qqstory.recommendAlbum.logic.StoryScanManager", "insertAlbumToDb albums=" + paramList.size() + " append=" + paramBoolean);
    boolean bool;
    if (!paramList.isEmpty()) {
      bool = true;
    }
    EntityManager localEntityManager;
    for (;;)
    {
      rom.assertTrue(bool, "It is not allow save the empty albums to DB ");
      localEntityManager = QQStoryContext.a().getEntityManagerFactory().createEntityManager();
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
          pkd localpkd = (pkd)paramList.next();
          localStoryAlbumEntry = localpkd.a();
          if (localStoryAlbumEntry.getId() <= 0L) {
            break;
          }
          localStoryAlbumEntry.setStatus(1001);
          if (!localEntityManager.update(localStoryAlbumEntry))
          {
            localStoryAlbumEntry.setStatus(1000);
            localEntityManager.persistOrReplace(localStoryAlbumEntry);
          }
          localpkd.setId(localStoryAlbumEntry.getId());
        }
      }
      catch (Exception paramList)
      {
        for (;;)
        {
          StoryAlbumEntry localStoryAlbumEntry;
          ram.e("Q.qqstory.recommendAlbum.logic.StoryScanManager", "insertAlbumToDb exception=%s", paramList);
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
  
  public List<pku.c> bA()
  {
    return this.jdField_a_of_type_Pjp.bA();
  }
  
  public List<pkd> bB()
  {
    ArrayList localArrayList = new ArrayList();
    psr localpsr = (psr)psx.a(10);
    long l = ((Long)localpsr.c("key_last_home_time", Long.valueOf(-1L))).longValue();
    EntityManager localEntityManager = QQStoryContext.a().getEntityManagerFactory().createEntityManager();
    Object localObject = psu.a(localEntityManager, StoryAlbumEntry.class, StoryAlbumEntry.class.getSimpleName(), "state=0 ", null, "startTime desc");
    if ((localObject == null) || (((List)localObject).isEmpty())) {
      return localArrayList;
    }
    ram.w("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getNewStoryAlbum : new album time=%s,last time=%d", new Object[] { Long.valueOf(((StoryAlbumEntry)((List)localObject).get(0)).startTime), Long.valueOf(l) });
    if (((StoryAlbumEntry)((List)localObject).get(0)).startTime <= l) {
      return localArrayList;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      StoryAlbumEntry localStoryAlbumEntry = (StoryAlbumEntry)((Iterator)localObject).next();
      pkd localpkd;
      try
      {
        localpkd = pkd.a(localStoryAlbumEntry);
        if (!localpkd.If()) {
          break label241;
        }
        localArrayList.add(localpkd);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        rom.fail("getNewStoryAlbum DB info have error:" + localInvalidProtocolBufferMicroException, new Object[0]);
      }
      continue;
      label241:
      ram.e("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getNewStoryAlbum we find the illegal album and deleted it : " + localpkd);
      localInvalidProtocolBufferMicroException.setStatus(1001);
      localEntityManager.remove(localInvalidProtocolBufferMicroException);
    }
    ram.w("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getNewStoryAlbum reslut=%s", new Object[] { localArrayList });
    if (localArrayList.isEmpty()) {
      return localArrayList;
    }
    if (((pkd)localArrayList.get(0)).getStartTime() <= l)
    {
      localArrayList.clear();
      return localArrayList;
    }
    localpsr.n("key_last_home_time", Long.valueOf(((pkd)localArrayList.get(0)).getStartTime()));
    return localArrayList;
  }
  
  public List<pkd> bC()
  {
    ArrayList localArrayList = new ArrayList();
    EntityManager localEntityManager = QQStoryContext.a().getEntityManagerFactory().createEntityManager();
    Object localObject = psu.a(localEntityManager, StoryAlbumEntry.class, StoryAlbumEntry.class.getSimpleName(), null, null);
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      StoryAlbumEntry localStoryAlbumEntry = (StoryAlbumEntry)((Iterator)localObject).next();
      pkd localpkd;
      try
      {
        localpkd = pkd.a(localStoryAlbumEntry);
        if (!localpkd.If()) {
          break label144;
        }
        if (localpkd.sh() < 2) {
          a(localpkd, 10);
        }
        localArrayList.add(localpkd);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        rom.fail("DB info have error:" + localInvalidProtocolBufferMicroException, new Object[0]);
      }
      continue;
      label144:
      ram.e("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getAlbumListFromDB we find the illegal album and deleted it : " + localpkd);
      localInvalidProtocolBufferMicroException.setStatus(1001);
      localEntityManager.remove(localInvalidProtocolBufferMicroException);
    }
    dH(localArrayList);
    ram.w("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getAlbumListFromDB reslut=" + localArrayList);
    return localArrayList;
  }
  
  public void bli()
  {
    this.jdField_a_of_type_Pjp.bli();
  }
  
  public void blj()
  {
    this.jdField_a_of_type_Pjp.blj();
  }
  
  public boolean eS(String paramString)
  {
    return this.jdField_a_of_type_Pjp.eS(paramString);
  }
  
  public boolean eT(String paramString)
  {
    return this.jdField_a_of_type_Pjp.eT(paramString);
  }
  
  public List<pjy> g(long paramLong1, long paramLong2)
  {
    return this.jdField_a_of_type_Pjp.g(paramLong1, paramLong2);
  }
  
  @NonNull
  public List<pkd.a> i(Context paramContext)
  {
    psr localpsr = (psr)psx.a(10);
    long l = ((Long)localpsr.c("key_story_home_scan_time", Long.valueOf(-1L))).longValue();
    paramContext = a(paramContext, Math.max(System.currentTimeMillis() / 1000L - 259200L, l));
    ram.w("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getNewScanPicList  result=" + paramContext);
    if (paramContext.size() >= 10)
    {
      localpsr.n("key_story_home_scan_time", Long.valueOf(((pkd.a)paramContext.get(0)).mCreateTime));
      return paramContext;
    }
    return null;
  }
  
  public void onDestroy()
  {
    ((ptb)psx.a(26)).b(this);
    this.mClient.bzk();
  }
  
  public void onInit()
  {
    ((ptb)psx.a(26)).a(this);
    this.jdField_a_of_type_Psr = ((psr)psx.a(10));
    this.mClient = skj.a();
    this.mClient.bzj();
    this.jdField_a_of_type_Pjp = new pjp();
  }
  
  public void rC(boolean paramBoolean)
  {
    int j = 2;
    Object localObject = this.mClient;
    if (paramBoolean)
    {
      i = 2;
      ((skj)localObject).vI(i);
      localObject = (psr)psx.a(10);
      if (!paramBoolean) {
        break label54;
      }
    }
    label54:
    for (int i = j;; i = 1)
    {
      ((psr)localObject).n("sp_key_user_enable_album_scan", Integer.valueOf(i));
      return;
      i = 1;
      break;
    }
  }
  
  public void start()
  {
    if (this.mState != 0)
    {
      ram.w("Q.qqstory.recommendAlbum.logic.StoryScanManager", "scan task is running so ignore this request.");
      return;
    }
    ram.w("Q.qqstory.recommendAlbum.logic.StoryScanManager", "start scan");
    this.zS = System.currentTimeMillis();
    this.mState = 1;
    pkm localpkm = new pkm();
    Context localContext = QQStoryContext.a().getApplication().getBaseContext();
    Stream.of(Integer.valueOf(0)).map(new ThreadOffFunction("Q.qqstory.recommendAlbum.logic.StoryScanManager", 2)).map(new pkk(localContext, localpkm)).map(new pkl(localpkm)).map(new pkj(localpkm)).map(new pki(localpkm)).subscribe(new pjv(this, localpkm));
  }
  
  public void trimMemory(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
    case 1: 
      do
      {
        return;
        ram.w("Q.qqstory.recommendAlbum.logic.StoryScanManager", "trimMemory to be 5");
      } while (Build.VERSION.SDK_INT < 17);
      return;
    }
    ram.w("Q.qqstory.recommendAlbum.logic.StoryScanManager", "clearAllMemory");
  }
  
  public static class a
    extends plt
  {
    public List<pkd> lP = new ArrayList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pju
 * JD-Core Version:    0.7.0.1
 */