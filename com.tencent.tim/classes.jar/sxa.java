import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.os.Process;
import android.support.v4.util.LruCache;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.CacheInfo;
import com.tencent.commonsdk.cache.HashMapInfo;
import com.tencent.commonsdk.cache.IMemoryManager;
import com.tencent.commonsdk.cache.LruCacheInfo;
import com.tencent.commonsdk.cache.QQConcurrentHashMap;
import com.tencent.commonsdk.cache.QQHashMap;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.image.Utils;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.mobileqq.app.MemoryManager.b;
import com.tencent.mobileqq.startup.step.HackVm;
import com.tencent.mobileqq.startup.step.InitMagnifierSDK;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.app.IAppStateChangeListener;
import org.json.JSONException;
import org.json.JSONObject;

public class sxa
  implements IMemoryManager, MemoryManager.b, IAppStateChangeListener, txh
{
  private static sxa a;
  public static int bAb = 1;
  public static int bAc = 2;
  private LinkedList<String> B = new LinkedList();
  long DJ = 0L;
  long DK = -1L;
  long DL = -1L;
  private int bAa = -1;
  int bzQ = -1;
  int bzR = -1;
  public int bzS;
  public int bzT;
  int bzU = 0;
  int bzV = 0;
  public int bzW = 0;
  public int bzX = 0;
  public int bzY = 0;
  public int bzZ = 0;
  int clearType = 0;
  long eu = 0L;
  private Vector<sxa.a> n;
  public boolean needReport;
  List<WeakReference<QQHashMap>> pE = new CopyOnWriteArrayList();
  List<WeakReference<QQConcurrentHashMap>> pF = new CopyOnWriteArrayList();
  List<WeakReference<QQLruCache>> pG = new CopyOnWriteArrayList();
  List<WeakReference<LruCache>> pH = new CopyOnWriteArrayList();
  
  private sxa()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("CommonMemoryCacheSP", 0);
    if (localSharedPreferences.contains("lastShotTime")) {
      localSharedPreferences.edit().clear().commit();
    }
    localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("CommonMemoryCacheSP_" + BaseApplicationImpl.sProcessId, 0);
    long l = localSharedPreferences.getLong("lastShotTime", 0L);
    if (Math.abs(System.currentTimeMillis() - l) >= 43200000L)
    {
      if (0.001F >= Math.random()) {
        bool = true;
      }
      this.needReport = bool;
      localSharedPreferences.edit().putLong("lastShotTime", System.currentTimeMillis()).putBoolean("lastShotResult", this.needReport).apply();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MemoryClearManagerNew", 2, "MemoryClearManagerNew init needReport= " + this.needReport);
      }
      this.n = new Vector();
      return;
      this.needReport = localSharedPreferences.getBoolean("lastShotResult", false);
    }
  }
  
  public static sxa a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new sxa();
      }
      return a;
    }
    finally {}
  }
  
  private void a(JSONObject paramJSONObject, CacheInfo paramCacheInfo, int paramInt1, int paramInt2)
  {
    if ((paramCacheInfo == null) || (paramJSONObject == null)) {
      return;
    }
    for (;;)
    {
      JSONObject localJSONObject;
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("type", paramInt1);
        localJSONObject.put("action", paramInt2);
        localJSONObject.put("capacity", paramCacheInfo.capacity);
        localJSONObject.put("size", paramCacheInfo.size);
        localJSONObject.put("getCount", paramCacheInfo.getCount);
        localJSONObject.put("putCount", paramCacheInfo.putCount);
        if (paramCacheInfo.putCount <= 0) {
          break label301;
        }
        localJSONObject.put("getRate", paramCacheInfo.getCount / paramCacheInfo.putCount);
        localJSONObject.put("removeCount", paramCacheInfo.removeCount);
        localJSONObject.put("hitCount", paramCacheInfo.hitCount);
        localJSONObject.put("missCount", paramCacheInfo.missCount);
        if ((paramCacheInfo.hitCount <= 0) && (paramCacheInfo.missCount <= 0)) {
          break label316;
        }
        localJSONObject.put("hitRate", paramCacheInfo.hitCount / (paramCacheInfo.hitCount + paramCacheInfo.missCount));
        localJSONObject.put("lifeTime", paramCacheInfo.lifeTime);
        localJSONObject.put("gapTime", paramCacheInfo.gapTime);
        localJSONObject.put("MemorySize", paramCacheInfo.mMemorySize);
        localJSONObject.put("ClearSize", paramCacheInfo.mClearSize);
        if (!(paramCacheInfo instanceof HashMapInfo)) {
          break label331;
        }
        localJSONObject.put("extra_traversalCount", ((HashMapInfo)paramCacheInfo).traversalCount);
        paramJSONObject.put(String.valueOf(paramCacheInfo.tagId), localJSONObject);
        return;
      }
      catch (JSONException paramJSONObject) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("MemoryClearManagerNew", 2, paramJSONObject.toString());
      return;
      label301:
      localJSONObject.put("getRate", -1.0D);
      continue;
      label316:
      localJSONObject.put("hitRate", -1.0D);
      continue;
      label331:
      if ((paramCacheInfo instanceof LruCacheInfo)) {
        localJSONObject.put("extra_evictionCount", ((LruCacheInfo)paramCacheInfo).evictionCount);
      }
    }
  }
  
  public static void bI(String paramString, int paramInt)
  {
    String str;
    if (a().needReport)
    {
      str = d(new IllegalStateException("reportMemoryMsg : " + paramInt));
      if (QLog.isColorLevel()) {
        QLog.d("CommonMemoryCache", 2, "reportMemoryMsg|stack= " + str);
      }
      localObject = BaseApplicationImpl.sApplication.getRuntime();
      if (localObject == null) {
        break label202;
      }
    }
    label202:
    for (Object localObject = ((AppRuntime)localObject).getAccount();; localObject = null)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_stack", str);
      localHashMap.put("sProcessId", String.valueOf(BaseApplicationImpl.sProcessId));
      if (paramInt == bAc)
      {
        str = "sImageCacheKey";
        localHashMap.put("key", paramString);
        paramString = str;
      }
      for (;;)
      {
        if (paramString != null) {
          anpc.a(BaseApplicationImpl.getApplication()).collectPerformance((String)localObject, paramString, true, 0L, 0L, localHashMap, "", true);
        }
        return;
        if (paramInt == bAb)
        {
          str = "DexPathListHook";
          localHashMap.put("name", paramString);
          paramString = str;
        }
        else
        {
          paramString = null;
        }
      }
    }
  }
  
  private boolean be(int paramInt)
  {
    return Math.abs(System.currentTimeMillis() - this.eu) >= paramInt;
  }
  
  private static String d(Exception paramException)
  {
    if (paramException == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramException = paramException.getStackTrace();
    int j = 0;
    int i = 1;
    for (;;)
    {
      String str;
      if (i < paramException.length)
      {
        str = paramException[i].toString();
        if (localStringBuilder.length() != 0) {
          break label91;
        }
        localStringBuilder.append("[");
      }
      for (;;)
      {
        localStringBuilder.append(str);
        j += 1;
        if (j < 16) {
          break;
        }
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append("]");
        }
        return localStringBuilder.toString();
        label91:
        localStringBuilder.append(",");
      }
      i += 1;
    }
  }
  
  private static int uz()
  {
    int i;
    int j;
    Object localObject;
    if (BaseApplicationImpl.sImageHashMap != null)
    {
      Iterator localIterator = BaseApplicationImpl.sImageHashMap.values().iterator();
      i = 0;
      j = i;
      if (!localIterator.hasNext()) {
        break label89;
      }
      localObject = localIterator.next();
      if ((localObject instanceof Bitmap)) {
        i += Utils.getBitmapSize((Bitmap)localObject);
      }
    }
    for (;;)
    {
      break;
      if ((localObject instanceof BitmapDrawable))
      {
        localObject = ((BitmapDrawable)localObject).getBitmap();
        if (localObject != null)
        {
          i += Utils.getBitmapSize((Bitmap)localObject);
          continue;
          j = 0;
          label89:
          return j / 1024;
        }
      }
    }
  }
  
  private void yY(int paramInt)
  {
    label278:
    label281:
    label284:
    label287:
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        long l = 0L;
        Iterator localIterator = this.pE.iterator();
        Object localObject2;
        if (localIterator.hasNext())
        {
          localObject2 = (WeakReference)localIterator.next();
          if (localObject2 == null) {
            break label281;
          }
          localObject2 = (QQHashMap)((WeakReference)localObject2).get();
          if (localObject2 == null) {
            break label281;
          }
          localObject2 = ((QQHashMap)localObject2).getReportCacheInfo();
          a(localJSONObject, (CacheInfo)localObject2, 1, paramInt);
          l = ((CacheInfo)localObject2).mMemorySize + l;
          break label281;
        }
        localIterator = this.pF.iterator();
        if (localIterator.hasNext())
        {
          localObject2 = (WeakReference)localIterator.next();
          if (localObject2 == null) {
            break label278;
          }
          localObject2 = (QQConcurrentHashMap)((WeakReference)localObject2).get();
          if (localObject2 == null) {
            break label278;
          }
          localObject2 = ((QQConcurrentHashMap)localObject2).getReportCacheInfo();
          a(localJSONObject, (CacheInfo)localObject2, 1, paramInt);
          l = ((CacheInfo)localObject2).mMemorySize + l;
          break label284;
        }
        localIterator = this.pG.iterator();
        if (localIterator.hasNext())
        {
          localObject2 = (WeakReference)localIterator.next();
          if (localObject2 != null)
          {
            localObject2 = (QQLruCache)((WeakReference)localObject2).get();
            if (localObject2 != null)
            {
              localObject2 = ((QQLruCache)localObject2).getCacheInfos();
              a(localJSONObject, (CacheInfo)localObject2, 2, paramInt);
              l = ((CacheInfo)localObject2).mMemorySize + l;
              break label287;
            }
          }
        }
        else
        {
          InitMagnifierSDK.b(localJSONObject, l);
          return;
        }
      }
      finally {}
      break label287;
      break label284;
      continue;
    }
  }
  
  public void a(int paramInt, swx.a parama)
  {
    swx localswx = MagnifierSDK.a().a().a;
    if (QLog.isColorLevel()) {
      QLog.d("MemoryClearManagerNew", 2, "onNeedTrimMemory|clear= " + localswx.aNO + "configId" + localswx.aHI);
    }
    if ((be(parama.delayTime * localswx.bzO * 1000)) && (localswx.aNO)) {}
    try
    {
      b(paramInt, parama);
      return;
    }
    catch (Exception parama)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("MemoryClearManagerNew", 2, "clearMemory Exception= " + parama);
    }
  }
  
  public void a(sxa.a parama)
  {
    synchronized (this.n)
    {
      this.n.add(parama);
      return;
    }
  }
  
  public void addConCurrentHashMap(QQConcurrentHashMap paramQQConcurrentHashMap)
  {
    if (paramQQConcurrentHashMap != null) {
      this.pF.add(new WeakReference(paramQQConcurrentHashMap));
    }
  }
  
  public void addHashMap(QQHashMap paramQQHashMap)
  {
    if (paramQQHashMap != null) {
      this.pE.add(new WeakReference(paramQQHashMap));
    }
  }
  
  public void addLruCache(LruCache paramLruCache)
  {
    if (paramLruCache != null) {
      this.pH.add(new WeakReference(paramLruCache));
    }
  }
  
  public void addQQLruCache(QQLruCache paramQQLruCache)
  {
    if (paramQQLruCache != null) {
      this.pG.add(new WeakReference(paramQQLruCache));
    }
  }
  
  public void b(int paramInt, swx.a parama)
  {
    long l6;
    Object localObject3;
    int i;
    long l2;
    long l1;
    int k;
    int j;
    long l3;
    long l4;
    int i6;
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("MemoryClearManagerNew", 2, "clearMemory start");
        }
        l6 = System.currentTimeMillis();
        if ((paramInt != 1) && (paramInt != 2)) {
          break label1344;
        }
        label301:
        synchronized (this.n)
        {
          localObject3 = this.n.iterator();
          i = 0;
          if (((Iterator)localObject3).hasNext())
          {
            i += ((sxa.a)((Iterator)localObject3).next()).uA();
            continue;
          }
          l2 = i;
          l1 = i;
          l1 = 0L + l1;
          l2 = 0L + l2;
          k = i;
          i = BaseApplicationImpl.sImageCache.size();
          j = (int)(i * parama.ox);
          l3 = i;
          BaseApplicationImpl.sImageCache.trimToSize(j);
          if ((parama.ow > 0.0F) && (parama.ow < 1.0F))
          {
            l4 = MemoryManager.eS() * 1L / 32L;
            if (BaseApplicationImpl.sImageCache.maxSize() >= l4) {
              BaseApplicationImpl.sImageCache.resetMaxSize(parama.ow);
            }
          }
          i6 = 0 + (i - j);
          l4 = i6;
          if (QLog.isColorLevel()) {
            QLog.d("MemoryClearManagerNew", 2, "clearMemory|sImageCache= " + i);
          }
          m = 0;
          i = 0;
          if (BaseApplicationImpl.sImageHashMap == null) {
            break label1356;
          }
          ??? = BaseApplicationImpl.sImageHashMap.values().iterator();
          if (!((Iterator)???).hasNext()) {
            break;
          }
          localObject3 = ((Iterator)???).next();
          if ((localObject3 instanceof Bitmap))
          {
            j = Utils.getBitmapSize((Bitmap)localObject3);
            i = j + i;
          }
        }
        if (!(localObject3 instanceof BitmapDrawable)) {
          break label1341;
        }
      }
      finally {}
      localObject3 = ((BitmapDrawable)localObject3).getBitmap();
      if (localObject3 == null) {
        break label1341;
      }
      i = Utils.getBitmapSize((Bitmap)localObject3) + i;
    }
    BaseApplicationImpl.sImageHashMap.clear();
    int m = i;
    break label1356;
    label361:
    ??? = this.pG.iterator();
    label478:
    label621:
    int i5;
    if (((Iterator)???).hasNext())
    {
      localObject3 = (WeakReference)((Iterator)???).next();
      if (localObject3 != null)
      {
        Object localObject4 = (QQLruCache)((WeakReference)localObject3).get();
        if (localObject4 != null)
        {
          l3 = ((QQLruCache)localObject4).getCacheInfos().mMemorySize;
          ((QQLruCache)localObject4).clearOnLowMemory((int)(((QQLruCache)localObject4).size() * parama.ox));
          i = ((QQLruCache)localObject4).getCacheInfos().mClearSize + i;
          l1 += l3;
        }
        else
        {
          this.pG.remove(localObject3);
          break label1396;
          ??? = this.pH;
          j = ((List)???).size();
          localObject3 = ((List)???).iterator();
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = (WeakReference)((Iterator)localObject3).next();
            if (localObject4 == null) {
              break label1427;
            }
            LruCache localLruCache = (LruCache)((WeakReference)localObject4).get();
            if (localLruCache != null)
            {
              localLruCache.trimToSize((int)(localLruCache.size() * parama.ox));
              i = localLruCache.getClearMemory() + i;
              break label1424;
            }
            ((List)???).remove(localObject4);
            break label1427;
          }
          if (!QLog.isColorLevel()) {
            break label1430;
          }
          QLog.d("MemoryClearManagerNew", 2, "clearMemory|LruCache List Size = " + j);
          break label1430;
          i = 0;
          if (paramInt == 1)
          {
            parama = this.pF.iterator();
            if (!parama.hasNext()) {
              break label1449;
            }
            ??? = (WeakReference)parama.next();
            if (??? == null) {
              break label1446;
            }
            localObject3 = (QQConcurrentHashMap)((WeakReference)???).get();
            if (localObject3 != null)
            {
              l3 = ((QQConcurrentHashMap)localObject3).getReportCacheInfo().mMemorySize;
              ((QQConcurrentHashMap)localObject3).onClearOnLowMemory();
              i = ((HashMapInfo)((QQConcurrentHashMap)localObject3).getReportCacheInfo()).mClearSize + i;
              l1 += l3;
              break label1443;
            }
            this.pF.remove(???);
            break label1446;
            label733:
            i = 0;
            if (paramInt == 1)
            {
              parama = this.pE.iterator();
              if (!parama.hasNext()) {
                break label1468;
              }
              ??? = (WeakReference)parama.next();
              if (??? == null) {
                break label1465;
              }
              localObject3 = (QQHashMap)((WeakReference)???).get();
              if (localObject3 != null)
              {
                l3 = ((QQHashMap)localObject3).getReportCacheInfo().mMemorySize;
                ((QQHashMap)localObject3).onClearOnLowMemory();
                i = ((QQHashMap)localObject3).getReportCacheInfo().mClearSize + i;
                l1 += l3;
                break label1462;
              }
              this.pE.remove(???);
              break label1465;
              label842:
              parama = SkinEngine.getInstances().releasePreloadDrawableCache();
              Object localObject1;
              l2 = localObject1;
              i = i5;
              if (parama.length < 2) {
                break label1522;
              }
              if ((parama[0] instanceof Integer)) {
                j = Integer.parseInt(parama[0].toString());
              }
              l2 = localObject1;
              i = j;
              if (!(parama[1] instanceof Long)) {
                break label1522;
              }
              l2 = Long.parseLong(parama[1].toString());
              i = j;
              break label1522;
            }
          }
        }
      }
    }
    for (;;)
    {
      swy.a(BaseApplicationImpl.class.getClassLoader());
      this.DK = (l4 / 1024L);
      l1 = l3 / 1024L;
      this.DL += l4;
      this.bzS += 1;
      this.clearType = paramInt;
      if (paramInt == 1) {
        this.bzT += 1;
      }
      int i1;
      for (;;)
      {
        this.eu = System.currentTimeMillis();
        this.bzR = ((int)Runtime.getRuntime().totalMemory() / 1024);
        l3 = System.currentTimeMillis();
        parama = new StringBuilder(1024);
        parama.append("totalMemory=").append(l1).append(", clearTotalMem=").append(this.DL).append(", trimCount=").append(this.bzS).append(", trimCountTop=").append(this.bzT).append(", trimCountSecond=").append(this.bzU).append(", trimCountThrid=").append(this.bzV).append(", cleatType=").append(paramInt).append(", clearMemory=").append(l4).append("\nlistenerClearSize=").append(k).append(", imageCacheMemory=").append(i6).append(", staticBitmapSize=").append(m).append(", qqLruCacheMem=").append(i1).append(", lruCacheMem=").append(i2).append(", qqConcurrentMem=").append(i3).append(", qqHashMapMem=").append(i4).append(", skinEngineCount=").append(i).append(", skinEngineSize=").append(l2).append(", cost=").append(String.valueOf(l3 - l6));
        if (QLog.isColorLevel()) {
          QLog.d("MemoryClearManagerNew", 2, "ClearMemory|result= \n" + parama.toString());
        }
        return;
        if (paramInt == 2) {
          this.bzU += 1;
        } else if (paramInt == 3) {
          this.bzV += 1;
        }
      }
      int i4 = 0;
      l3 = l1;
      l1 = l2;
      break label1490;
      int i3 = 0;
      break label733;
      label1341:
      label1344:
      label1356:
      label1396:
      do
      {
        i2 = 0;
        break label621;
        do
        {
          i1 = 0;
          break label1409;
          break label301;
          k = 0;
          l1 = 0L;
          l2 = 0L;
          break;
          l2 = l2 + l4 + m;
          l1 = l3 + l1 + m;
          i = 0;
          if (paramInt == 1) {
            break label361;
          }
        } while (paramInt != 2);
        break label361;
        for (;;)
        {
          break;
        }
        l2 += i;
        i1 = i;
        i = 0;
        if (paramInt == 1) {
          break label478;
        }
      } while (paramInt != 2);
      label1409:
      break label478;
      label1424:
      label1427:
      for (;;)
      {
        break;
      }
      label1430:
      l2 += i;
      int i2 = i;
      break label621;
      label1443:
      label1446:
      for (;;)
      {
        break;
      }
      label1449:
      l2 += i;
      i3 = i;
      break label733;
      label1462:
      label1465:
      for (;;)
      {
        break;
      }
      label1468:
      l3 = i;
      l2 = l3 + l2;
      l3 = l1;
      l1 = l2;
      i4 = i;
      label1490:
      i = 0;
      i5 = 0;
      j = 0;
      long l5 = 0L;
      if (paramInt == 1) {
        break label842;
      }
      l2 = l5;
      l4 = l1;
      if (paramInt == 2)
      {
        break label842;
        label1522:
        l4 = l1 + l2;
      }
    }
  }
  
  public void b(sxa.a parama)
  {
    synchronized (this.n)
    {
      this.n.remove(parama);
      return;
    }
  }
  
  public void bBG()
  {
    yX(2);
    swy.a(BaseApplicationImpl.class.getClassLoader());
  }
  
  public void bBH()
  {
    try
    {
      Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("mem_cache_oom", 0);
      if (((SharedPreferences)localObject).contains("trim_count")) {
        ((SharedPreferences)localObject).edit().clear().commit();
      }
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences("mem_cache_oom_" + BaseApplicationImpl.sProcessId, 0).edit();
      ((SharedPreferences.Editor)localObject).putInt("trim_count", this.bzS);
      ((SharedPreferences.Editor)localObject).putInt("img_size", BaseApplicationImpl.sImageCache.size() / 1024);
      ((SharedPreferences.Editor)localObject).putInt("img_init_maxsize", BaseApplicationImpl.sImageCacheSize / 1024);
      ((SharedPreferences.Editor)localObject).putInt("img_cur_maxsize", BaseApplicationImpl.sImageCache.maxSize() / 1024);
      ((SharedPreferences.Editor)localObject).putInt("img_hashmap_size", uz());
      ((SharedPreferences.Editor)localObject).putInt("clear_type", this.clearType);
      ((SharedPreferences.Editor)localObject).putLong("clear_size", this.DK);
      ((SharedPreferences.Editor)localObject).putLong("clear_total_size", this.DL);
      ((SharedPreferences.Editor)localObject).putString("total_memory_info", nS());
      ((SharedPreferences.Editor)localObject).putLong("total_size", Runtime.getRuntime().totalMemory() / 1024L);
      ((SharedPreferences.Editor)localObject).putLong("free_size", Runtime.getRuntime().freeMemory() / 1024L);
      ((SharedPreferences.Editor)localObject).putLong("heap_size", (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024L);
      ((SharedPreferences.Editor)localObject).putLong("heap_org_max", HackVm.amw / 1024L);
      ((SharedPreferences.Editor)localObject).putLong("max_heap", Runtime.getRuntime().maxMemory() / 1024L);
      ((SharedPreferences.Editor)localObject).putString("topActivity", aciz.rH());
      ((SharedPreferences.Editor)localObject).putString("key_mem_info", anoz.a().Ak());
      ((SharedPreferences.Editor)localObject).putInt("hackArtResult", HackVm.dKk);
      ((SharedPreferences.Editor)localObject).putString("clear_config_id", MagnifierSDK.a().a().a.aHI);
      ((SharedPreferences.Editor)localObject).putBoolean("clear_config_enable", MagnifierSDK.a().a().a.aNO);
      ((SharedPreferences.Editor)localObject).putInt("enter_aio_capture", this.bzZ);
      ((SharedPreferences.Editor)localObject).putInt("enter_story_capture", this.bzY);
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void bBI()
  {
    try
    {
      this.DJ = System.currentTimeMillis();
      this.bzQ = ((int)Runtime.getRuntime().totalMemory() / 1024);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void bBJ()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("mem_cache_oom_" + BaseApplicationImpl.sProcessId, 0);
    HashMap localHashMap;
    if (localSharedPreferences.contains("trim_count"))
    {
      localHashMap = new HashMap(23);
      localHashMap.put("osVersion", String.valueOf(Build.VERSION.SDK_INT));
      localHashMap.put("hackArtResult", String.valueOf(localSharedPreferences.getInt("hackArtResult", 0)));
      localHashMap.put("trim_count", String.valueOf(localSharedPreferences.getInt("trim_count", -1)));
      localHashMap.put("img_size", String.valueOf(localSharedPreferences.getInt("img_size", -1)));
      localHashMap.put("img_init_maxsize", String.valueOf(localSharedPreferences.getInt("img_init_maxsize", -1)));
      localHashMap.put("img_cur_maxsize", String.valueOf(localSharedPreferences.getInt("img_cur_maxsize", -1)));
      localHashMap.put("img_hashmap_size", String.valueOf(localSharedPreferences.getInt("img_hashmap_size", -1)));
      localHashMap.put("clear_type", String.valueOf(localSharedPreferences.getInt("clear_type", -1)));
      localHashMap.put("clear_size", String.valueOf(localSharedPreferences.getLong("clear_size", -1L)));
      localHashMap.put("clear_total_size", String.valueOf(localSharedPreferences.getLong("clear_total_size", -1L)));
      localHashMap.put("total_memory_info", localSharedPreferences.getString("total_memory_info", "-1"));
      localHashMap.put("max_heap", String.valueOf(localSharedPreferences.getLong("max_heap", -1L)));
      localHashMap.put("total_size", String.valueOf(localSharedPreferences.getLong("total_size", -1L)));
      localHashMap.put("heap_size", String.valueOf(localSharedPreferences.getLong("heap_size", -1L)));
      localHashMap.put("free_size", String.valueOf(localSharedPreferences.getLong("free_size", -1L)));
      localHashMap.put("heap_org_max", String.valueOf(localSharedPreferences.getLong("heap_org_max", -1L)));
      localHashMap.put("topActivity", localSharedPreferences.getString("topActivity", "NULL"));
      localHashMap.put("key_mem_info", localSharedPreferences.getString("key_mem_info", "NULL"));
      localHashMap.put("clear_config_id", localSharedPreferences.getString("clear_config_id", "0"));
      if (!localSharedPreferences.getBoolean("clear_config_enable", false)) {
        break label575;
      }
    }
    label575:
    for (String str = "1";; str = "0")
    {
      localHashMap.put("clear_config_enable", str);
      localHashMap.put("enter_aio_capture", String.valueOf(localSharedPreferences.getInt("enter_aio_capture", 0)));
      localHashMap.put("enter_story_capture", String.valueOf(localSharedPreferences.getInt("enter_story_capture", 0)));
      localHashMap.put("sProcessId", String.valueOf(BaseApplicationImpl.sProcessId));
      anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "memory_oom_Info", true, 0L, 0L, localHashMap, null);
      localSharedPreferences.edit().remove("trim_count").commit();
      return;
    }
  }
  
  public String nS()
  {
    synchronized (this.B)
    {
      if (this.B.size() <= 0) {
        break label81;
      }
      StringBuilder localStringBuilder = new StringBuilder(50);
      Iterator localIterator = this.B.iterator();
      if (localIterator.hasNext()) {
        localStringBuilder.append((String)localIterator.next()).append("-");
      }
    }
    String str = localObject.toString();
    return str;
    label81:
    return "-1";
  }
  
  public void onLowMemory(long paramLong)
  {
    yX(1);
  }
  
  public void onRunningBackground()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MemoryClearManagerNew", 2, "onRunningBackground");
    }
    bBG();
  }
  
  public void vj(boolean paramBoolean)
  {
    int i = (int)(Runtime.getRuntime().totalMemory() * 1000L / Runtime.getRuntime().maxMemory());
    long l1;
    String str1;
    if ((i > 600) && (i - this.bAa > 250) && (this.needReport))
    {
      l1 = System.currentTimeMillis();
      ??? = BaseApplicationImpl.getApplication().getSharedPreferences("CommonMemoryCacheSP_" + BaseApplicationImpl.sProcessId, 0);
      long l2 = ((SharedPreferences)???).getLong("memory_increase_report_time", 0L);
      if (l2 <= 0L) {
        break label374;
      }
      if (Math.abs(l1 - l2) >= 3600000L)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("lastPer", String.valueOf(this.bAa));
        localHashMap.put("curPer", String.valueOf(i));
        localHashMap.put("memInfo", nS());
        localHashMap.put("topActivity", aciz.rH());
        localHashMap.put("totalMemory", String.valueOf(Runtime.getRuntime().totalMemory() / 1024L));
        localHashMap.put("MaxMemory", String.valueOf(Runtime.getRuntime().maxMemory() / 1024L));
        if (!paramBoolean) {
          break label366;
        }
        str1 = "1";
        localHashMap.put("isForeground", str1);
        localHashMap.put("sProcessId", String.valueOf(BaseApplicationImpl.sProcessId));
        anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "MemoryIncreaseInfo", true, 0L, 0L, localHashMap, "", true);
        ((SharedPreferences)???).edit().putLong("memory_increase_report_time", l1);
      }
    }
    for (;;)
    {
      synchronized (this.B)
      {
        if (this.B.size() >= 16)
        {
          this.B.poll();
          break label410;
          str1 = i + str1;
          this.B.offer(str1);
          this.bAa = i;
          return;
          label366:
          str1 = "0";
          break;
          label374:
          ((SharedPreferences)???).edit().putLong("memory_increase_report_time", l1);
          continue;
          str1 = "0";
        }
      }
      label410:
      if (paramBoolean) {
        String str2 = "1";
      }
    }
  }
  
  public void yX(int paramInt)
  {
    if (!this.needReport) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MemoryClearManagerNew", 2, "reportMemoryInfo|action= " + paramInt);
    }
    long l2 = System.currentTimeMillis();
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("CommonMemoryCacheSP_" + BaseApplicationImpl.sProcessId, 0);
    if (paramInt == 1) {}
    for (String str2 = "low_mem_report_rdm_time";; str2 = "bg_mem_report_rdm_time")
    {
      long l1 = localSharedPreferences.getLong(str2, 0L);
      HashMap localHashMap;
      String str1;
      label145:
      long l3;
      if (l1 > 0L) {
        if (Math.abs(l2 - l1) > 3600000L)
        {
          localHashMap = new HashMap();
          if (!MagnifierSDK.a().a().a.aNO) {
            break label537;
          }
          str1 = "1";
          localHashMap.put("ClearEnable", str1);
          localHashMap.put("DpcConfigId", MagnifierSDK.a().a().a.aHI);
          localHashMap.put("trimCount", String.valueOf(this.bzS));
          localHashMap.put("topTrimCount", String.valueOf(this.bzT));
          localHashMap.put("secondTrimCount", String.valueOf(this.bzU));
          localHashMap.put("thirdTrimCount", String.valueOf(this.bzV));
          localHashMap.put("sProcessId", String.valueOf(BaseApplicationImpl.sProcessId));
          l1 = Runtime.getRuntime().maxMemory() / 1024L;
          l3 = Runtime.getRuntime().totalMemory() / 1024L;
          int i = (int)(1000L * l3 / l1);
          localHashMap.put("maxMemory", String.valueOf(l1));
          localHashMap.put("totalMemory", String.valueOf(l3));
          localHashMap.put("memoryPercent", String.valueOf(i));
          localHashMap.put("freeMemory", String.valueOf(Runtime.getRuntime().freeMemory() / 1024L));
          localHashMap.put("clearTotalMem", String.valueOf(this.DL));
          str1 = null;
          if (paramInt != 2) {
            break label545;
          }
          str1 = "memory_info_on_bg_guard";
          localHashMap.put("memoryPss", String.valueOf(MemoryManager.C(Process.myPid()) / 1024L));
          label402:
          anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, str1, true, 0L, 0L, localHashMap, null);
          localSharedPreferences.edit().putLong(str2, l2).commit();
        }
      }
      for (;;)
      {
        if (BaseApplicationImpl.sProcessId != 1) {
          break label644;
        }
        str1 = "cacheReportLastTime";
        if (paramInt == 1) {
          str1 = "lowReportLastTime";
        }
        l3 = localSharedPreferences.getLong(str1, 0L);
        l1 = 43200000L;
        if (paramInt == 1) {
          l1 = 14400000L;
        }
        if (l3 <= 0L) {
          break label646;
        }
        if (Math.abs(l2 - l3) <= l1) {
          break;
        }
        yY(paramInt);
        localSharedPreferences.edit().putLong(str1, l2).commit();
        return;
        label537:
        str1 = "0";
        break label145;
        label545:
        if (paramInt != 1) {
          break label402;
        }
        str1 = "memory_info_on_low_report";
        localHashMap.put("everEnterStory", String.valueOf(this.bzW));
        localHashMap.put("everEnterAIOCapture", String.valueOf(this.bzX));
        localHashMap.put("enterStory", String.valueOf(this.bzY));
        localHashMap.put("enterAIOCapture", String.valueOf(this.bzZ));
        break label402;
        localSharedPreferences.edit().putLong(str2, l2).apply();
      }
      label644:
      break;
      label646:
      localSharedPreferences.edit().putLong(str1, l2).commit();
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract int uA();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     sxa
 * JD-Core Version:    0.7.0.1
 */