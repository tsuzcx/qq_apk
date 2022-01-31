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
import com.tencent.mobileqq.app.MemoryManager;
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

public class xoz
  implements akak, akob, IMemoryManager, IAppStateChangeListener
{
  private static xoz jdField_a_of_type_Xoz;
  public static int l = 1;
  public static int m = 2;
  int jdField_a_of_type_Int = -1;
  long jdField_a_of_type_Long = 0L;
  private LinkedList<String> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  List<WeakReference<QQHashMap>> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private Vector<xpa> jdField_a_of_type_JavaUtilVector;
  public boolean a;
  int jdField_b_of_type_Int = -1;
  long jdField_b_of_type_Long = 0L;
  List<WeakReference<QQConcurrentHashMap>> jdField_b_of_type_JavaUtilList = new CopyOnWriteArrayList();
  int jdField_c_of_type_Int = 0;
  long jdField_c_of_type_Long = -1L;
  List<WeakReference<QQLruCache>> jdField_c_of_type_JavaUtilList = new CopyOnWriteArrayList();
  public int d;
  long jdField_d_of_type_Long = -1L;
  List<WeakReference<LruCache>> jdField_d_of_type_JavaUtilList = new CopyOnWriteArrayList();
  public int e;
  int f = 0;
  int g = 0;
  public int h = 0;
  public int i = 0;
  public int j = 0;
  public int k = 0;
  private int n = -1;
  
  private xoz()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("CommonMemoryCacheSP", 0);
    if (localSharedPreferences.contains("lastShotTime")) {
      localSharedPreferences.edit().clear().commit();
    }
    localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("CommonMemoryCacheSP_" + BaseApplicationImpl.sProcessId, 0);
    long l1 = localSharedPreferences.getLong("lastShotTime", 0L);
    if (Math.abs(System.currentTimeMillis() - l1) >= 43200000L)
    {
      if (0.001F >= Math.random()) {
        bool = true;
      }
      this.jdField_a_of_type_Boolean = bool;
      localSharedPreferences.edit().putLong("lastShotTime", System.currentTimeMillis()).putBoolean("lastShotResult", this.jdField_a_of_type_Boolean).apply();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MemoryClearManagerNew", 2, "MemoryClearManagerNew init needReport= " + this.jdField_a_of_type_Boolean);
      }
      this.jdField_a_of_type_JavaUtilVector = new Vector();
      return;
      this.jdField_a_of_type_Boolean = localSharedPreferences.getBoolean("lastShotResult", false);
    }
  }
  
  private static int a()
  {
    int i1;
    int i2;
    Object localObject;
    if (BaseApplicationImpl.sImageHashMap != null)
    {
      Iterator localIterator = BaseApplicationImpl.sImageHashMap.values().iterator();
      i1 = 0;
      i2 = i1;
      if (!localIterator.hasNext()) {
        break label89;
      }
      localObject = localIterator.next();
      if ((localObject instanceof Bitmap)) {
        i1 += Utils.getBitmapSize((Bitmap)localObject);
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
          i1 += Utils.getBitmapSize((Bitmap)localObject);
          continue;
          i2 = 0;
          label89:
          return i2 / 1024;
        }
      }
    }
  }
  
  private static String a(Exception paramException)
  {
    if (paramException == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramException = paramException.getStackTrace();
    int i2 = 0;
    int i1 = 1;
    for (;;)
    {
      String str;
      if (i1 < paramException.length)
      {
        str = paramException[i1].toString();
        if (localStringBuilder.length() != 0) {
          break label90;
        }
        localStringBuilder.append("[");
      }
      for (;;)
      {
        localStringBuilder.append(str);
        i2 += 1;
        if (i2 < 16) {
          break;
        }
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append("]");
        }
        return localStringBuilder.toString();
        label90:
        localStringBuilder.append(",");
      }
      i1 += 1;
    }
  }
  
  public static xoz a()
  {
    if (jdField_a_of_type_Xoz == null) {}
    try
    {
      if (jdField_a_of_type_Xoz == null) {
        jdField_a_of_type_Xoz = new xoz();
      }
      return jdField_a_of_type_Xoz;
    }
    finally {}
  }
  
  public static void a(String paramString, int paramInt)
  {
    String str;
    if (a().jdField_a_of_type_Boolean)
    {
      str = a(new IllegalStateException("reportMemoryMsg : " + paramInt));
      if (QLog.isColorLevel()) {
        QLog.d("CommonMemoryCache", 2, "reportMemoryMsg|stack= " + str);
      }
      localObject = BaseApplicationImpl.sApplication.getRuntime();
      if (localObject == null) {
        break label201;
      }
    }
    label201:
    for (Object localObject = ((AppRuntime)localObject).getAccount();; localObject = null)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_stack", str);
      localHashMap.put("sProcessId", String.valueOf(BaseApplicationImpl.sProcessId));
      if (paramInt == m)
      {
        str = "sImageCacheKey";
        localHashMap.put("key", paramString);
        paramString = str;
      }
      for (;;)
      {
        if (paramString != null) {
          axrl.a(BaseApplicationImpl.getApplication()).a((String)localObject, paramString, true, 0L, 0L, localHashMap, "", true);
        }
        return;
        if (paramInt == l)
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
          break label306;
        }
        localJSONObject.put("getRate", paramCacheInfo.getCount / paramCacheInfo.putCount);
        localJSONObject.put("removeCount", paramCacheInfo.removeCount);
        localJSONObject.put("hitCount", paramCacheInfo.hitCount);
        localJSONObject.put("missCount", paramCacheInfo.missCount);
        if ((paramCacheInfo.hitCount <= 0) && (paramCacheInfo.missCount <= 0)) {
          break label321;
        }
        localJSONObject.put("hitRate", paramCacheInfo.hitCount / (paramCacheInfo.hitCount + paramCacheInfo.missCount));
        localJSONObject.put("lifeTime", paramCacheInfo.lifeTime);
        localJSONObject.put("gapTime", paramCacheInfo.gapTime);
        localJSONObject.put("MemorySize", paramCacheInfo.mMemorySize);
        localJSONObject.put("ClearSize", paramCacheInfo.mClearSize);
        if (!(paramCacheInfo instanceof HashMapInfo)) {
          break label336;
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
      label306:
      localJSONObject.put("getRate", -1.0D);
      continue;
      label321:
      localJSONObject.put("hitRate", -1.0D);
      continue;
      label336:
      if ((paramCacheInfo instanceof LruCacheInfo)) {
        localJSONObject.put("extra_evictionCount", ((LruCacheInfo)paramCacheInfo).evictionCount);
      }
    }
  }
  
  private boolean a(int paramInt)
  {
    return Math.abs(System.currentTimeMillis() - this.jdField_b_of_type_Long) >= paramInt;
  }
  
  private void b(int paramInt)
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
        long l1 = 0L;
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
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
          l1 = ((CacheInfo)localObject2).mMemorySize + l1;
          break label281;
        }
        localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
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
          l1 = ((CacheInfo)localObject2).mMemorySize + l1;
          break label284;
        }
        localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
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
              l1 = ((CacheInfo)localObject2).mMemorySize + l1;
              break label287;
            }
          }
        }
        else
        {
          InitMagnifierSDK.a(localJSONObject, l1);
          return;
        }
      }
      finally {}
      break label287;
      break label284;
      continue;
    }
  }
  
  public String a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      if (this.jdField_a_of_type_JavaUtilLinkedList.size() <= 0) {
        break label81;
      }
      StringBuilder localStringBuilder = new StringBuilder(50);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
      if (localIterator.hasNext()) {
        localStringBuilder.append((String)localIterator.next()).append("-");
      }
    }
    String str = localObject.toString();
    return str;
    label81:
    return "-1";
  }
  
  public void a()
  {
    a(2);
    xox.a(BaseApplicationImpl.class.getClassLoader());
  }
  
  public void a(int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean) {
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
      label142:
      long l3;
      if (l1 > 0L) {
        if (Math.abs(l2 - l1) > 3600000L)
        {
          localHashMap = new HashMap();
          if (!akai.a().a.jdField_a_of_type_Boolean) {
            break label531;
          }
          str1 = "1";
          localHashMap.put("ClearEnable", str1);
          localHashMap.put("DpcConfigId", akai.a().a.jdField_a_of_type_JavaLangString);
          localHashMap.put("trimCount", String.valueOf(this.jdField_d_of_type_Int));
          localHashMap.put("topTrimCount", String.valueOf(this.e));
          localHashMap.put("secondTrimCount", String.valueOf(this.f));
          localHashMap.put("thirdTrimCount", String.valueOf(this.g));
          localHashMap.put("sProcessId", String.valueOf(BaseApplicationImpl.sProcessId));
          l1 = Runtime.getRuntime().maxMemory() / 1024L;
          l3 = Runtime.getRuntime().totalMemory() / 1024L;
          int i1 = (int)(1000L * l3 / l1);
          localHashMap.put("maxMemory", String.valueOf(l1));
          localHashMap.put("totalMemory", String.valueOf(l3));
          localHashMap.put("memoryPercent", String.valueOf(i1));
          localHashMap.put("freeMemory", String.valueOf(Runtime.getRuntime().freeMemory() / 1024L));
          localHashMap.put("clearTotalMem", String.valueOf(this.jdField_d_of_type_Long));
          str1 = null;
          if (paramInt != 2) {
            break label539;
          }
          str1 = "memory_info_on_bg_guard";
          localHashMap.put("memoryPss", String.valueOf(MemoryManager.a(Process.myPid()) / 1024L));
          label396:
          axrl.a(BaseApplicationImpl.getApplication()).a(null, str1, true, 0L, 0L, localHashMap, null);
          localSharedPreferences.edit().putLong(str2, l2).commit();
        }
      }
      for (;;)
      {
        if (BaseApplicationImpl.sProcessId != 1) {
          break label638;
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
          break label640;
        }
        if (Math.abs(l2 - l3) <= l1) {
          break;
        }
        b(paramInt);
        localSharedPreferences.edit().putLong(str1, l2).commit();
        return;
        label531:
        str1 = "0";
        break label142;
        label539:
        if (paramInt != 1) {
          break label396;
        }
        str1 = "memory_info_on_low_report";
        localHashMap.put("everEnterStory", String.valueOf(this.h));
        localHashMap.put("everEnterAIOCapture", String.valueOf(this.i));
        localHashMap.put("enterStory", String.valueOf(this.j));
        localHashMap.put("enterAIOCapture", String.valueOf(this.k));
        break label396;
        localSharedPreferences.edit().putLong(str2, l2).apply();
      }
      label638:
      break;
      label640:
      localSharedPreferences.edit().putLong(str1, l2).commit();
      return;
    }
  }
  
  public void a(int paramInt, xow paramxow)
  {
    xov localxov = akai.a().a;
    if (QLog.isColorLevel()) {
      QLog.d("MemoryClearManagerNew", 2, "onNeedTrimMemory|clear= " + localxov.jdField_a_of_type_Boolean + "configId" + localxov.jdField_a_of_type_JavaLangString);
    }
    if ((a(paramxow.jdField_b_of_type_Int * localxov.jdField_b_of_type_Int * 1000)) && (localxov.jdField_a_of_type_Boolean)) {}
    try
    {
      b(paramInt, paramxow);
      return;
    }
    catch (Exception paramxow)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("MemoryClearManagerNew", 2, "clearMemory Exception= " + paramxow);
    }
  }
  
  public void a(long paramLong)
  {
    a(1);
  }
  
  public void a(xpa paramxpa)
  {
    synchronized (this.jdField_a_of_type_JavaUtilVector)
    {
      this.jdField_a_of_type_JavaUtilVector.add(paramxpa);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int i1 = (int)(Runtime.getRuntime().totalMemory() * 1000L / Runtime.getRuntime().maxMemory());
    long l1;
    String str1;
    if ((i1 > 600) && (i1 - this.n > 250) && (this.jdField_a_of_type_Boolean))
    {
      l1 = System.currentTimeMillis();
      ??? = BaseApplicationImpl.getApplication().getSharedPreferences("CommonMemoryCacheSP_" + BaseApplicationImpl.sProcessId, 0);
      long l2 = ((SharedPreferences)???).getLong("memory_increase_report_time", 0L);
      if (l2 <= 0L) {
        break label373;
      }
      if (Math.abs(l1 - l2) >= 3600000L)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("lastPer", String.valueOf(this.n));
        localHashMap.put("curPer", String.valueOf(i1));
        localHashMap.put("memInfo", a());
        localHashMap.put("topActivity", akdh.a());
        localHashMap.put("totalMemory", String.valueOf(Runtime.getRuntime().totalMemory() / 1024L));
        localHashMap.put("MaxMemory", String.valueOf(Runtime.getRuntime().maxMemory() / 1024L));
        if (!paramBoolean) {
          break label365;
        }
        str1 = "1";
        localHashMap.put("isForeground", str1);
        localHashMap.put("sProcessId", String.valueOf(BaseApplicationImpl.sProcessId));
        axrl.a(BaseApplicationImpl.getApplication()).a(null, "MemoryIncreaseInfo", true, 0L, 0L, localHashMap, "", true);
        ((SharedPreferences)???).edit().putLong("memory_increase_report_time", l1);
      }
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
      {
        if (this.jdField_a_of_type_JavaUtilLinkedList.size() >= 16)
        {
          this.jdField_a_of_type_JavaUtilLinkedList.poll();
          break label409;
          str1 = i1 + str1;
          this.jdField_a_of_type_JavaUtilLinkedList.offer(str1);
          this.n = i1;
          return;
          label365:
          str1 = "0";
          break;
          label373:
          ((SharedPreferences)???).edit().putLong("memory_increase_report_time", l1);
          continue;
          str1 = "0";
        }
      }
      label409:
      if (paramBoolean) {
        String str2 = "1";
      }
    }
  }
  
  public void addConCurrentHashMap(QQConcurrentHashMap paramQQConcurrentHashMap)
  {
    if (paramQQConcurrentHashMap != null) {
      this.jdField_b_of_type_JavaUtilList.add(new WeakReference(paramQQConcurrentHashMap));
    }
  }
  
  public void addHashMap(QQHashMap paramQQHashMap)
  {
    if (paramQQHashMap != null) {
      this.jdField_a_of_type_JavaUtilList.add(new WeakReference(paramQQHashMap));
    }
  }
  
  public void addLruCache(LruCache paramLruCache)
  {
    if (paramLruCache != null) {
      this.jdField_d_of_type_JavaUtilList.add(new WeakReference(paramLruCache));
    }
  }
  
  public void addQQLruCache(QQLruCache paramQQLruCache)
  {
    if (paramQQLruCache != null) {
      this.jdField_c_of_type_JavaUtilList.add(new WeakReference(paramQQLruCache));
    }
  }
  
  public void b()
  {
    try
    {
      Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("mem_cache_oom", 0);
      if (((SharedPreferences)localObject).contains("trim_count")) {
        ((SharedPreferences)localObject).edit().clear().commit();
      }
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences("mem_cache_oom_" + BaseApplicationImpl.sProcessId, 0).edit();
      ((SharedPreferences.Editor)localObject).putInt("trim_count", this.jdField_d_of_type_Int);
      ((SharedPreferences.Editor)localObject).putInt("img_size", BaseApplicationImpl.sImageCache.size() / 1024);
      ((SharedPreferences.Editor)localObject).putInt("img_init_maxsize", BaseApplicationImpl.sImageCacheSize / 1024);
      ((SharedPreferences.Editor)localObject).putInt("img_cur_maxsize", BaseApplicationImpl.sImageCache.maxSize() / 1024);
      ((SharedPreferences.Editor)localObject).putInt("img_hashmap_size", a());
      ((SharedPreferences.Editor)localObject).putInt("clear_type", this.jdField_c_of_type_Int);
      ((SharedPreferences.Editor)localObject).putLong("clear_size", this.jdField_c_of_type_Long);
      ((SharedPreferences.Editor)localObject).putLong("clear_total_size", this.jdField_d_of_type_Long);
      ((SharedPreferences.Editor)localObject).putString("total_memory_info", a());
      ((SharedPreferences.Editor)localObject).putLong("total_size", Runtime.getRuntime().totalMemory() / 1024L);
      ((SharedPreferences.Editor)localObject).putLong("free_size", Runtime.getRuntime().freeMemory() / 1024L);
      ((SharedPreferences.Editor)localObject).putLong("heap_size", (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024L);
      ((SharedPreferences.Editor)localObject).putLong("heap_org_max", HackVm.jdField_a_of_type_Long / 1024L);
      ((SharedPreferences.Editor)localObject).putLong("max_heap", Runtime.getRuntime().maxMemory() / 1024L);
      ((SharedPreferences.Editor)localObject).putString("topActivity", akdh.a());
      ((SharedPreferences.Editor)localObject).putString("key_mem_info", axrg.a().a());
      ((SharedPreferences.Editor)localObject).putInt("hackArtResult", HackVm.jdField_d_of_type_Int);
      ((SharedPreferences.Editor)localObject).putString("clear_config_id", akai.a().a.jdField_a_of_type_JavaLangString);
      ((SharedPreferences.Editor)localObject).putBoolean("clear_config_enable", akai.a().a.jdField_a_of_type_Boolean);
      ((SharedPreferences.Editor)localObject).putInt("enter_aio_capture", this.k);
      ((SharedPreferences.Editor)localObject).putInt("enter_story_capture", this.j);
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void b(int paramInt, xow paramxow)
  {
    long l6;
    Object localObject3;
    int i1;
    long l2;
    long l1;
    int i3;
    int i2;
    long l3;
    long l4;
    int i10;
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
        synchronized (this.jdField_a_of_type_JavaUtilVector)
        {
          localObject3 = this.jdField_a_of_type_JavaUtilVector.iterator();
          i1 = 0;
          if (((Iterator)localObject3).hasNext())
          {
            i1 += ((xpa)((Iterator)localObject3).next()).a();
            continue;
          }
          l2 = i1;
          l1 = i1;
          l1 = 0L + l1;
          l2 = 0L + l2;
          i3 = i1;
          i1 = BaseApplicationImpl.sImageCache.size();
          i2 = (int)(i1 * paramxow.jdField_b_of_type_Float);
          l3 = i1;
          BaseApplicationImpl.sImageCache.trimToSize(i2);
          if ((paramxow.a > 0.0F) && (paramxow.a < 1.0F))
          {
            l4 = MemoryManager.a() * 1L / 32L;
            if (BaseApplicationImpl.sImageCache.maxSize() >= l4) {
              BaseApplicationImpl.sImageCache.resetMaxSize(paramxow.a);
            }
          }
          i10 = 0 + (i1 - i2);
          l4 = i10;
          if (QLog.isColorLevel()) {
            QLog.d("MemoryClearManagerNew", 2, "clearMemory|sImageCache= " + i1);
          }
          i4 = 0;
          i1 = 0;
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
            i2 = Utils.getBitmapSize((Bitmap)localObject3);
            i1 = i2 + i1;
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
      i1 = Utils.getBitmapSize((Bitmap)localObject3) + i1;
    }
    BaseApplicationImpl.sImageHashMap.clear();
    int i4 = i1;
    break label1356;
    label361:
    ??? = this.jdField_c_of_type_JavaUtilList.iterator();
    label478:
    label621:
    int i9;
    if (((Iterator)???).hasNext())
    {
      localObject3 = (WeakReference)((Iterator)???).next();
      if (localObject3 != null)
      {
        Object localObject4 = (QQLruCache)((WeakReference)localObject3).get();
        if (localObject4 != null)
        {
          l3 = ((QQLruCache)localObject4).getCacheInfos().mMemorySize;
          ((QQLruCache)localObject4).clearOnLowMemory((int)(((QQLruCache)localObject4).size() * paramxow.jdField_b_of_type_Float));
          i1 = ((QQLruCache)localObject4).getCacheInfos().mClearSize + i1;
          l1 += l3;
        }
        else
        {
          this.jdField_c_of_type_JavaUtilList.remove(localObject3);
          break label1396;
          ??? = this.jdField_d_of_type_JavaUtilList;
          i2 = ((List)???).size();
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
              localLruCache.trimToSize((int)(localLruCache.size() * paramxow.jdField_b_of_type_Float));
              i1 = localLruCache.getClearMemory() + i1;
              break label1424;
            }
            ((List)???).remove(localObject4);
            break label1427;
          }
          if (!QLog.isColorLevel()) {
            break label1430;
          }
          QLog.d("MemoryClearManagerNew", 2, "clearMemory|LruCache List Size = " + i2);
          break label1430;
          i1 = 0;
          if (paramInt == 1)
          {
            paramxow = this.jdField_b_of_type_JavaUtilList.iterator();
            if (!paramxow.hasNext()) {
              break label1449;
            }
            ??? = (WeakReference)paramxow.next();
            if (??? == null) {
              break label1446;
            }
            localObject3 = (QQConcurrentHashMap)((WeakReference)???).get();
            if (localObject3 != null)
            {
              l3 = ((QQConcurrentHashMap)localObject3).getReportCacheInfo().mMemorySize;
              ((QQConcurrentHashMap)localObject3).onClearOnLowMemory();
              i1 = ((HashMapInfo)((QQConcurrentHashMap)localObject3).getReportCacheInfo()).mClearSize + i1;
              l1 += l3;
              break label1443;
            }
            this.jdField_b_of_type_JavaUtilList.remove(???);
            break label1446;
            label733:
            i1 = 0;
            if (paramInt == 1)
            {
              paramxow = this.jdField_a_of_type_JavaUtilList.iterator();
              if (!paramxow.hasNext()) {
                break label1468;
              }
              ??? = (WeakReference)paramxow.next();
              if (??? == null) {
                break label1465;
              }
              localObject3 = (QQHashMap)((WeakReference)???).get();
              if (localObject3 != null)
              {
                l3 = ((QQHashMap)localObject3).getReportCacheInfo().mMemorySize;
                ((QQHashMap)localObject3).onClearOnLowMemory();
                i1 = ((QQHashMap)localObject3).getReportCacheInfo().mClearSize + i1;
                l1 += l3;
                break label1462;
              }
              this.jdField_a_of_type_JavaUtilList.remove(???);
              break label1465;
              label842:
              paramxow = SkinEngine.getInstances().releasePreloadDrawableCache();
              Object localObject1;
              l2 = localObject1;
              i1 = i9;
              if (paramxow.length < 2) {
                break label1522;
              }
              if ((paramxow[0] instanceof Integer)) {
                i2 = Integer.parseInt(paramxow[0].toString());
              }
              l2 = localObject1;
              i1 = i2;
              if (!(paramxow[1] instanceof Long)) {
                break label1522;
              }
              l2 = Long.parseLong(paramxow[1].toString());
              i1 = i2;
              break label1522;
            }
          }
        }
      }
    }
    for (;;)
    {
      xox.a(BaseApplicationImpl.class.getClassLoader());
      this.jdField_c_of_type_Long = (l4 / 1024L);
      l1 = l3 / 1024L;
      this.jdField_d_of_type_Long += l4;
      this.jdField_d_of_type_Int += 1;
      this.jdField_c_of_type_Int = paramInt;
      if (paramInt == 1) {
        this.e += 1;
      }
      int i5;
      for (;;)
      {
        this.jdField_b_of_type_Long = System.currentTimeMillis();
        this.jdField_b_of_type_Int = ((int)Runtime.getRuntime().totalMemory() / 1024);
        l3 = System.currentTimeMillis();
        paramxow = new StringBuilder(1024);
        paramxow.append("totalMemory=").append(l1).append(", clearTotalMem=").append(this.jdField_d_of_type_Long).append(", trimCount=").append(this.jdField_d_of_type_Int).append(", trimCountTop=").append(this.e).append(", trimCountSecond=").append(this.f).append(", trimCountThrid=").append(this.g).append(", cleatType=").append(paramInt).append(", clearMemory=").append(l4).append("\nlistenerClearSize=").append(i3).append(", imageCacheMemory=").append(i10).append(", staticBitmapSize=").append(i4).append(", qqLruCacheMem=").append(i5).append(", lruCacheMem=").append(i6).append(", qqConcurrentMem=").append(i7).append(", qqHashMapMem=").append(i8).append(", skinEngineCount=").append(i1).append(", skinEngineSize=").append(l2).append(", cost=").append(String.valueOf(l3 - l6));
        if (QLog.isColorLevel()) {
          QLog.d("MemoryClearManagerNew", 2, "ClearMemory|result= \n" + paramxow.toString());
        }
        return;
        if (paramInt == 2) {
          this.f += 1;
        } else if (paramInt == 3) {
          this.g += 1;
        }
      }
      int i8 = 0;
      l3 = l1;
      l1 = l2;
      break label1490;
      int i7 = 0;
      break label733;
      label1341:
      label1344:
      label1356:
      label1396:
      do
      {
        i6 = 0;
        break label621;
        do
        {
          i5 = 0;
          break label1409;
          break label301;
          i3 = 0;
          l1 = 0L;
          l2 = 0L;
          break;
          l2 = l2 + l4 + i4;
          l1 = l3 + l1 + i4;
          i1 = 0;
          if (paramInt == 1) {
            break label361;
          }
        } while (paramInt != 2);
        break label361;
        for (;;)
        {
          break;
        }
        l2 += i1;
        i5 = i1;
        i1 = 0;
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
      l2 += i1;
      int i6 = i1;
      break label621;
      label1443:
      label1446:
      for (;;)
      {
        break;
      }
      label1449:
      l2 += i1;
      i7 = i1;
      break label733;
      label1462:
      label1465:
      for (;;)
      {
        break;
      }
      label1468:
      l3 = i1;
      l2 = l3 + l2;
      l3 = l1;
      l1 = l2;
      i8 = i1;
      label1490:
      i1 = 0;
      i9 = 0;
      i2 = 0;
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
  
  public void b(xpa paramxpa)
  {
    synchronized (this.jdField_a_of_type_JavaUtilVector)
    {
      this.jdField_a_of_type_JavaUtilVector.remove(paramxpa);
      return;
    }
  }
  
  public void c()
  {
    try
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Int = ((int)Runtime.getRuntime().totalMemory() / 1024);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void d()
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
      axrl.a(BaseApplicationImpl.getApplication()).a(null, "memory_oom_Info", true, 0L, 0L, localHashMap, null);
      localSharedPreferences.edit().remove("trim_count").commit();
      return;
    }
  }
  
  public void onRunningBackground()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MemoryClearManagerNew", 2, "onRunningBackground");
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     xoz
 * JD-Core Version:    0.7.0.1
 */