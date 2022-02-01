package com.tencent.mobileqq.app;

import acfn;
import aciz;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.Pair;
import anoz;
import anpc;
import aqfg;
import aqgo;
import aqgz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.startup.step.HackVm;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import swx;
import sxa;
import txm;

public class MemoryManager
{
  private static long PU;
  private static long PV;
  private static MemoryManager jdField_a_of_type_ComTencentMobileqqAppMemoryManager;
  private static List<String> xD;
  private static List<Pattern> xE;
  private static List<String> xF;
  private b jdField_a_of_type_ComTencentMobileqqAppMemoryManager$b;
  private c jdField_a_of_type_ComTencentMobileqqAppMemoryManager$c;
  private int cwt;
  private int cwu;
  private int cwv;
  private Object cx = new Object();
  private ConcurrentHashMap<String, d> ee = new ConcurrentHashMap(0);
  private boolean mNeedReport;
  
  private MemoryManager()
  {
    if (0.1000000014901161D >= Math.random()) {
      bool = true;
    }
    this.mNeedReport = bool;
    if (QLog.isColorLevel()) {
      QLog.d("Q.Memory.MemoryManager", 2, "memory manager set need report = " + this.mNeedReport);
    }
    a(sxa.a());
  }
  
  public static long C(int paramInt)
  {
    try
    {
      Debug.MemoryInfo[] arrayOfMemoryInfo = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getProcessMemoryInfo(new int[] { paramInt });
      if ((arrayOfMemoryInfo != null) && (arrayOfMemoryInfo.length > 0))
      {
        int i = arrayOfMemoryInfo[0].getTotalPss();
        return i * 1024L;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.Memory.MemoryManager", 2, "getMemory ex pid=" + paramInt, localException);
      }
      return 62914560L;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.Memory.MemoryManager", 2, new Object[] { "getMemory OutOfMemoryError pid=", Integer.valueOf(paramInt), localOutOfMemoryError });
        }
      }
    }
  }
  
  private c a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMemoryManager$c == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppMemoryManager$c = new c();
      this.jdField_a_of_type_ComTencentMobileqqAppMemoryManager$c.init();
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppMemoryManager$c;
  }
  
  public static MemoryManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqAppMemoryManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqAppMemoryManager == null) {
        jdField_a_of_type_ComTencentMobileqqAppMemoryManager = new MemoryManager();
      }
      return jdField_a_of_type_ComTencentMobileqqAppMemoryManager;
    }
    finally {}
  }
  
  public static void a(int paramInt, a parama)
  {
    try
    {
      Debug.MemoryInfo[] arrayOfMemoryInfo = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getProcessMemoryInfo(new int[] { paramInt });
      if ((arrayOfMemoryInfo != null) && (arrayOfMemoryInfo.length > 0))
      {
        parama.pss = (arrayOfMemoryInfo[0].getTotalPss() * 1024L);
        parama.PW = (arrayOfMemoryInfo[0].nativePss * 1024L);
        parama.PX = (arrayOfMemoryInfo[0].dalvikPss * 1024L);
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.Memory.MemoryManager", 2, "getMemory ex pid=" + paramInt, localException);
      }
      parama.pss = 62914560L;
      parama.PW = 31457280L;
      parama.PX = 31457280L;
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.Memory.MemoryManager", 2, new Object[] { "getMemory OutOfMemoryError pid=", Integer.valueOf(paramInt), localOutOfMemoryError });
        }
      }
    }
  }
  
  public static long eS()
  {
    if (PU > 0L) {
      return PU;
    }
    long l1 = aqgz.getSystemTotalMemory();
    PV = l1;
    long l2 = aqgz.getSystemAvaialbeMemory();
    long l3 = (3L * l1 + 7L * l2) / 10L;
    long l4 = aqgz.hH();
    if (l3 <= 157286400L) {
      PU = Math.min(25165824L, l4);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.Memory.MemoryManager", 2, "getAvailClassSize, availClassSize=" + PU / 1048576L + "M, totalMemSize=" + l1 / 1048576L + "M, remainMemSize=" + l2 / 1048576L + "M, availMemSize=" + l3 / 1048576L + "M, classMemSize=" + l4 / 1048576L + "M");
      }
      return PU;
      if (l3 <= 262144000L) {
        PU = Math.min(37748736L, l4);
      } else if (l3 <= 419430400L) {
        PU = Math.min(67108864L, l4);
      } else if (l3 <= 524288000L) {
        PU = Math.min(134217728L, l4);
      } else {
        PU = Math.min(268435456L, l4);
      }
    }
  }
  
  public int AA()
  {
    return this.cwu;
  }
  
  public int AB()
  {
    return this.cwv;
  }
  
  public int Az()
  {
    return this.cwt;
  }
  
  public void Eh(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppMemoryManager$b != null) && ("BG_GUARD".equals(paramString))) {
      this.jdField_a_of_type_ComTencentMobileqqAppMemoryManager$b.bBG();
    }
    if (!this.mNeedReport)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.Memory.MemoryManager", 2, "Report memory do not need report");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.Memory.MemoryManager", 2, "Report memory with action = " + paramString);
    }
    Ei(paramString);
    cJY();
  }
  
  protected void Ei(String paramString)
  {
    Object localObject1 = (ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity");
    d locald;
    if (this.ee.get("LITE_GUARD") == null)
    {
      locald = new d();
      locald.init("LITE_GUARD");
      this.ee.put("LITE_GUARD", locald);
    }
    if (this.ee.get("BG_GUARD") == null)
    {
      locald = new d();
      locald.init("BG_GUARD");
      this.ee.put("BG_GUARD", locald);
    }
    if ("LITE_GUARD".equals(paramString))
    {
      locald = (d)this.ee.get("LITE_GUARD");
      if (locald != null) {
        break label173;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.Memory.MemoryManager", 2, " curStateMemory == null return with no stat");
      }
    }
    label173:
    long l3;
    Object localObject2;
    label228:
    Object localObject4;
    label591:
    HashMap localHashMap;
    for (;;)
    {
      return;
      if (!"BG_GUARD".equals(paramString)) {
        break label1720;
      }
      locald = (d)this.ee.get("BG_GUARD");
      break;
      l3 = aqgz.getSystemAvaialbeMemory();
      localObject2 = new a();
      a(Process.myPid(), (a)localObject2);
      long l4 = ((a)localObject2).pss;
      l1 = 0L;
      try
      {
        localObject1 = ((ActivityManager)localObject1).getRunningAppProcesses();
        long l2 = l1;
        Object localObject3;
        if (localObject1 != null)
        {
          localObject1 = ((List)localObject1).iterator();
          l2 = l1;
          if (((Iterator)localObject1).hasNext())
          {
            localObject3 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next();
            localObject4 = ((ActivityManager.RunningAppProcessInfo)localObject3).processName;
            if ((!((String)localObject4).startsWith("com.tencent.tim")) || (((String)localObject4).equals("com.tencent.tim"))) {
              break label1717;
            }
            l1 = C(((ActivityManager.RunningAppProcessInfo)localObject3).pid) + l1;
            break label1726;
          }
        }
        if ((l3 >= 0L) && (l4 >= 0L) && (l2 >= 0L))
        {
          locald.Qd += l3;
          locald.Qe += l2;
          locald.Qf += l4;
          locald.PX += ((a)localObject2).PX;
          locald.PW += ((a)localObject2).PW;
          locald.Qi += Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
          locald.cwy += 1;
          localObject1 = BaseApplicationImpl.sImageCache;
          locald.Qg += ((MQLruCache)localObject1).maxSize();
          locald.Qh += ((MQLruCache)localObject1).size();
          locald.cwA += ((MQLruCache)localObject1).hitCount();
          i = locald.cwz;
          locald.cwz = (((MQLruCache)localObject1).missCount() + i);
          l3 = System.currentTimeMillis();
          localObject2 = BaseApplicationImpl.getApplication().getSharedPreferences("MemoryManagerMemoryStat", 0);
          l2 = ((SharedPreferences)localObject2).getLong("StateMemoryLastTime", 0L);
          l1 = l2;
          if (l2 == 0L)
          {
            l1 = System.currentTimeMillis();
            ((SharedPreferences)localObject2).edit().putLong("StateMemoryLastTime", l1).commit();
          }
          if (Math.abs(l3 - l1) <= 86400000L) {
            break label1524;
          }
          localObject3 = this.ee.entrySet().iterator();
          for (;;)
          {
            if (!((Iterator)localObject3).hasNext()) {
              break label1501;
            }
            localObject1 = (Map.Entry)((Iterator)localObject3).next();
            localObject4 = (d)((Map.Entry)localObject1).getValue();
            i = ((d)localObject4).cwy;
            if (i > 0) {
              break;
            }
            ((d)localObject4).reset();
          }
          if (!QLog.isColorLevel()) {}
        }
      }
      catch (IllegalStateException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.Memory.MemoryManager", 2, "reportMemoryInfo exception", paramString);
        }
        locald.reset();
        locald.save();
        return;
        localHashMap = new HashMap();
        localObject1 = (String)((Map.Entry)localObject1).getKey();
        if (("BG_GUARD".equals(localObject1)) || ("LITE_GUARD".equals(localObject1))) {
          break label743;
        }
        throw new IllegalStateException("mode illegal");
      }
      catch (Exception paramString) {}
    }
    QLog.d("Q.Memory.MemoryManager", 2, "reportMemoryInfo exception", paramString);
    return;
    label743:
    localHashMap.put("startMode", localObject1);
    long l1 = aqgz.getSystemTotalMemory() / 1024L;
    if (l1 <= 0L) {
      throw new IllegalStateException("sysTotalMemory illegal");
    }
    localHashMap.put("sysTotalMemory", String.valueOf(l1));
    l1 = aqgz.hH() / 1024L;
    if (l1 <= 0L) {
      throw new IllegalStateException("sysClassMemory illegal");
    }
    localHashMap.put("sysClassMemory", String.valueOf(l1));
    l1 = ((d)localObject4).Qd / (i * 1024);
    if (l1 <= 0L) {
      throw new IllegalStateException("sysAvailableMemory illegal");
    }
    localHashMap.put("sysAvailableMemory", String.valueOf(l1));
    l1 = ((d)localObject4).Qe / (i * 1024);
    if (l1 < 0L) {
      throw new IllegalStateException("qqOtherUsedMemory illegal");
    }
    localHashMap.put("qqOtherUsedMemory", String.valueOf(l1));
    l1 = ((d)localObject4).Qf / (i * 1024);
    if (l1 <= 0L) {
      throw new IllegalStateException("qqUsedMemory illegal");
    }
    localHashMap.put("qqUsedMemory", String.valueOf(l1));
    l1 = ((d)localObject4).PX / (i * 1024);
    if (l1 <= 0L) {
      throw new IllegalStateException("dalvikPss illegal " + l1);
    }
    localHashMap.put("dalvikPss", String.valueOf(l1));
    l1 = ((d)localObject4).Qi / (i * 1024);
    if (l1 <= 0L) {
      throw new IllegalStateException("dalvikHeap illegal " + l1);
    }
    localHashMap.put("dalvikHeap", String.valueOf(l1));
    l1 = ((d)localObject4).PW / (i * 1024);
    if (l1 <= 0L) {
      throw new IllegalStateException("nativePss illegal " + l1);
    }
    localHashMap.put("nativePss", String.valueOf(l1));
    localHashMap.put("maxHeap", String.valueOf(Runtime.getRuntime().maxMemory() / 1024L));
    l1 = ((d)localObject4).Qg / (i * 1024);
    if (l1 < 0L) {
      throw new IllegalStateException("imageCacheMax illegal");
    }
    localHashMap.put("imageCacheMax", String.valueOf(l1));
    l1 = ((d)localObject4).Qh / (i * 1024);
    if (l1 < 0L) {
      throw new IllegalStateException("imageCacheUsed illegal");
    }
    localHashMap.put("imageCacheUsed", String.valueOf(l1));
    l1 = ((d)localObject4).cwA / i;
    if (l1 < 0L) {
      throw new IllegalStateException("imageHitCount illegal");
    }
    localHashMap.put("imageHitCount", String.valueOf(l1));
    if (((d)localObject4).cwA + ((d)localObject4).cwz != 0)
    {
      i = ((d)localObject4).cwA * 100 / (((d)localObject4).cwA + ((d)localObject4).cwz);
      label1321:
      l1 = i;
      if (l1 < 0L) {
        throw new IllegalStateException("imageHitRate illegal");
      }
      localHashMap.put("imageHitRate", String.valueOf(l1));
      localHashMap.put("guardConfigId", acfn.a().rB());
      localHashMap.put("memoryConfigId", MagnifierSDK.a().a().aJT);
      localHashMap.put("osVersion", Build.VERSION.RELEASE);
      localHashMap.put("resolution", aqgz.BZ());
      if (!MagnifierSDK.a().a().a.aNO) {
        break label1734;
      }
      localObject1 = "1";
      label1431:
      localHashMap.put("clearMemFlag", localObject1);
      if (!MagnifierSDK.a().a().aQy) {
        break label1742;
      }
    }
    label1717:
    label1720:
    label1726:
    label1734:
    label1742:
    for (int i = 1;; i = 0)
    {
      localHashMap.put("enable_heap_sucide", String.valueOf(i));
      anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "actMemory", true, 0L, 0L, localHashMap, null);
      ((d)localObject4).reset();
      ((d)localObject4).save();
      break label591;
      label1501:
      ((SharedPreferences)localObject2).edit().putLong("StateMemoryLastTime", l3).commit();
      label1524:
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("reportMemoryInfo, start mode =").append(paramString).append("sysTotalMemory=").append(aqgz.getSystemTotalMemory()).append(",statCount=").append(locald.cwy).append(",sysClassMemory=").append(aqgz.hH()).append(",sysAvailableMemory=").append(locald.Qd).append(",qqOtherUsedMemory=").append(locald.Qe).append(",qqUsedMemory=").append(locald.Qf).append(",imageCacheMax=").append(locald.Qg).append(",imageCacheUsed=").append(locald.Qh).append(",imageHitCount=").append(locald.cwA).append(",imageHitTotal=").append(locald.cwA + locald.cwz).append("\n");
        QLog.d("Q.Memory.MemoryManager", 2, ((StringBuilder)localObject1).toString());
      }
      locald.save();
      return;
      break label1726;
      locald = null;
      break;
      break label228;
      i = 0;
      break label1321;
      localObject1 = "0";
      break label1431;
    }
  }
  
  public void a(b paramb)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppMemoryManager$b = paramb;
  }
  
  public float aW()
  {
    long l1 = Runtime.getRuntime().totalMemory();
    long l2 = Runtime.getRuntime().maxMemory();
    return (float)l1 * 1.0F / (float)l2;
  }
  
  protected void aa(long paramLong1, long paramLong2)
  {
    synchronized (this.cx)
    {
      c localc = a();
      localc.PY += paramLong2;
      localc.PZ += paramLong1;
      localc.cww += 1;
      localc.save();
      return;
    }
  }
  
  protected void ab(long paramLong1, long paramLong2)
  {
    synchronized (this.cx)
    {
      c localc = a();
      localc.Qa += paramLong2;
      localc.Qb += paramLong1;
      localc.cwx += 1;
      localc.save();
      return;
    }
  }
  
  public void bBH()
  {
    long l2 = 1L;
    if (BaseApplicationImpl.sProcessId == 1) {}
    try
    {
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("pref_oom", 0);
      if (localSharedPreferences.contains("enable_sucide_heap")) {
        localSharedPreferences.edit().remove("enable_sucide_heap");
      }
      localSharedPreferences.edit().putLong("heap_size", Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
      localSharedPreferences.edit().putLong("sys_pss", C(Process.myPid()));
      localSharedPreferences.edit().putLong("sys_total", PV);
      localSharedPreferences.edit().putLong("heap_free", Runtime.getRuntime().freeMemory());
      localSharedPreferences.edit().putLong("heap_total", Runtime.getRuntime().totalMemory());
      localSharedPreferences.edit().putLong("heap_max", Runtime.getRuntime().maxMemory());
      localSharedPreferences.edit().putLong("heap_org_max", HackVm.amw);
      localSharedPreferences.edit().putInt("leak_actvity_count", this.cwt);
      localSharedPreferences.edit().putInt("leak_qqapp_count", this.cwu);
      localSharedPreferences.edit().putInt("leak_other_count", this.cwv);
      SharedPreferences.Editor localEditor = localSharedPreferences.edit();
      if (MagnifierSDK.a().a().aQy)
      {
        l1 = 1L;
        localEditor.putLong("enable_sucide_heap_new", l1);
        localEditor = localSharedPreferences.edit();
        if (!MagnifierSDK.a().a().aQA) {
          break label395;
        }
      }
      label395:
      for (long l1 = l2;; l1 = 0L)
      {
        localEditor.putLong("en_sucide_ab", l1);
        localSharedPreferences.edit().putString("key_top_act", aciz.rH());
        localSharedPreferences.edit().putString("key_mem_usg", anoz.a().Ak());
        localSharedPreferences.edit().commit();
        return;
        l1 = 0L;
        break;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.d("Q.Memory.MemoryManager", 2, "onOOMCrash", localThrowable);
    }
  }
  
  public final void cJX()
  {
    SharedPreferences localSharedPreferences;
    HashMap localHashMap;
    if (BaseApplicationImpl.sProcessId == 1)
    {
      localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("pref_oom", 0);
      if (localSharedPreferences.contains("enable_sucide_heap")) {
        localSharedPreferences.edit().remove("enable_sucide_heap");
      }
      if (localSharedPreferences.contains("leak_actvity_count"))
      {
        localHashMap = new HashMap(10);
        localHashMap.put("maxHeap", String.valueOf(Runtime.getRuntime().maxMemory()));
        localHashMap.put("osVersion", String.valueOf(Build.VERSION.SDK_INT));
        localHashMap.put("hackResult", String.valueOf(HackVm.sHeapResult));
        localHashMap.put("hackArtResult", String.valueOf(HackVm.dKk));
        localHashMap.put("heap_size", String.valueOf(localSharedPreferences.getLong("heap_size", -1L)));
        localHashMap.put("leak_actvity_count", String.valueOf(localSharedPreferences.getInt("leak_actvity_count", -1)));
        localHashMap.put("leak_qqapp_count", String.valueOf(localSharedPreferences.getInt("leak_qqapp_count", -1)));
        localHashMap.put("leak_other_count", String.valueOf(localSharedPreferences.getInt("leak_other_count", -1)));
        localHashMap.put("sys_pss", String.valueOf(localSharedPreferences.getLong("sys_pss", -1L)));
        localHashMap.put("sys_total", String.valueOf(localSharedPreferences.getLong("sys_total", -1L)));
        localHashMap.put("heap_free", String.valueOf(localSharedPreferences.getLong("heap_free", -1L)));
        localHashMap.put("heap_total", String.valueOf(localSharedPreferences.getLong("heap_total", -1L)));
        localHashMap.put("heap_max", String.valueOf(localSharedPreferences.getLong("heap_max", -1L)));
        localHashMap.put("heap_org_max", String.valueOf(localSharedPreferences.getLong("heap_org_max", -1L)));
        localHashMap.put("oom_scid_count", String.valueOf(localSharedPreferences.getLong("oom_scid_count", -1L)));
        localHashMap.put("enable_sucide_heap_new", String.valueOf(localSharedPreferences.getLong("enable_sucide_heap_new", -1L)));
        localHashMap.put("en_sucide_ab", String.valueOf(localSharedPreferences.getLong("en_sucide_ab", -1L)));
        localHashMap.put("key_top_act", localSharedPreferences.getString("key_top_act", ""));
        localHashMap.put("key_mem_usg", localSharedPreferences.getString("key_mem_usg", ""));
        str = System.getProperty("java.vm.version");
        if (TextUtils.isEmpty(str)) {
          break label550;
        }
      }
    }
    label550:
    for (String str = str.substring(0, 1);; str = "")
    {
      localHashMap.put("vmVersion", str);
      anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "oomInfo", true, 0L, 0L, localHashMap, null);
      localSharedPreferences.edit().putLong("oom_scid_count", 0L);
      localSharedPreferences.edit().remove("leak_actvity_count").commit();
      sxa.a().bBJ();
      return;
    }
  }
  
  protected void cJY()
  {
    synchronized (this.cx)
    {
      localc = a();
      l1 = System.currentTimeMillis();
      long l2 = localc.Qc;
      if (l1 - l2 > 86400000L) {}
      for (;;)
      {
        try
        {
          i = localc.cww;
          j = localc.cwx;
          HashMap localHashMap = new HashMap();
          localHashMap.put("sysTotalMemory", String.valueOf(aqgz.getSystemTotalMemory() / 1024L));
          if (i != 0) {
            continue;
          }
          str = "0";
          localHashMap.put("lowWarningMemory", str);
          if (i != 0) {
            continue;
          }
          str = "0";
          localHashMap.put("lowRemainMemory", str);
          localHashMap.put("lowMemoryCount", String.valueOf(i));
          if (j != 0) {
            continue;
          }
          str = "0";
          localHashMap.put("clearWarningMemory", str);
          if (j != 0) {
            continue;
          }
          str = "0";
          localHashMap.put("clearRemainMemory", str);
          localHashMap.put("clearCount", String.valueOf(j));
          anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "LowMemoryStat", true, 0L, 0L, localHashMap, null);
          if (QLog.isColorLevel()) {
            QLog.d("Q.Memory.MemoryManager", 2, "reportLowMemory, sysTotalMemory=" + String.valueOf(aqgz.getSystemTotalMemory() / 1024L) + ", lowWarningMemory=" + localc.PZ + ", lowRemainMemory=" + localc.PY + ", lowMemoryCount=" + i + ", clearWarningMemory=" + localc.Qb + ", clearRemainMemory=" + localc.Qa + ",clearCount=" + j);
          }
        }
        catch (Exception localException)
        {
          int i;
          int j;
          String str;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.Memory.MemoryManager", 2, "reportMemoryInfo exception", localException);
          localc.reset();
          localc.Qc = l1;
          continue;
          localObject1 = finally;
          throw localObject1;
        }
        finally
        {
          localc.reset();
          localc.Qc = l1;
        }
        localc.save();
        return;
        str = String.valueOf(localc.PZ / (i * 1024));
        continue;
        str = String.valueOf(localc.PY / (i * 1024));
        continue;
        str = String.valueOf(localc.Qb / (j * 1024));
      }
      l2 = localc.Qa / (j * 1024);
      str = String.valueOf(l2);
    }
  }
  
  public void d(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface == null) || (paramQQAppInterface.isReleased)) {}
    while (!MagnifierSDK.a().a().aNO) {
      return;
    }
    paramQQAppInterface.execute(new AlertMemoryRunner(paramQQAppInterface, paramContext, 2));
  }
  
  public void hA(long paramLong)
  {
    long l1;
    if (paramLong == 2L)
    {
      localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("pref_oom", 0);
      l1 = localSharedPreferences.getLong("oom_scid_count", 0L);
      localSharedPreferences.edit().putLong("oom_scid_count", l1 + 1L);
      localSharedPreferences.edit().commit();
    }
    long l3 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    long l4 = Runtime.getRuntime().totalMemory();
    long l5 = Runtime.getRuntime().maxMemory();
    float f = (float)l4 * 1.0F / (float)l5;
    long l6 = aqgz.getSystemAvaialbeMemory();
    long l7 = C(Process.myPid());
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("pref_heap_level", 0);
    if (localSharedPreferences.contains("enable_sucide_heap")) {
      localSharedPreferences.edit().remove("enable_sucide_heap");
    }
    if (paramLong == 2L)
    {
      localSharedPreferences.edit().putLong("guard_type", paramLong);
      localSharedPreferences.edit().putLong("heap_size", l3);
      localSharedPreferences.edit().putLong("heap_total", l4);
      localSharedPreferences.edit().putLong("heap_max", l5);
      localSharedPreferences.edit().putFloat("heap_level", f);
      localSharedPreferences.edit().putLong("sys_total", l6);
      localSharedPreferences.edit().putLong("sys_pss", l7);
      localObject = localSharedPreferences.edit();
      if (MagnifierSDK.a().a().aQy)
      {
        paramLong = 1L;
        ((SharedPreferences.Editor)localObject).putLong("enable_sucide_heap_new", paramLong);
        localObject = localSharedPreferences.edit();
        if (!MagnifierSDK.a().a().aQA) {
          break label382;
        }
        paramLong = 1L;
        label351:
        ((SharedPreferences.Editor)localObject).putLong("en_sucide_ab", paramLong);
        localSharedPreferences.edit().commit();
      }
    }
    label382:
    do
    {
      return;
      paramLong = 0L;
      break;
      paramLong = 0L;
      break label351;
      if (localSharedPreferences.getFloat("heap_level", -1.0F) > 0.0F)
      {
        localObject = new HashMap(10);
        ((HashMap)localObject).put("guard_type", String.valueOf(localSharedPreferences.getLong("guard_type", -1L)));
        ((HashMap)localObject).put("heap_size", String.valueOf(localSharedPreferences.getLong("heap_size", -1L)));
        ((HashMap)localObject).put("heap_total", String.valueOf(localSharedPreferences.getLong("heap_total", -1L)));
        ((HashMap)localObject).put("heap_max", String.valueOf(localSharedPreferences.getLong("heap_max", -1L)));
        ((HashMap)localObject).put("heap_level", String.valueOf(localSharedPreferences.getFloat("heap_level", -1.0F)));
        ((HashMap)localObject).put("sys_total", String.valueOf(localSharedPreferences.getLong("sys_total", -1L)));
        ((HashMap)localObject).put("sys_pss", String.valueOf(localSharedPreferences.getLong("sys_pss", -1L)));
        ((HashMap)localObject).put("enable_sucide_heap_new", String.valueOf(localSharedPreferences.getLong("enable_sucide_heap_new", -1L)));
        ((HashMap)localObject).put("en_sucide_ab", String.valueOf(localSharedPreferences.getLong("en_sucide_ab", -1L)));
        anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "HeapLevel", true, 0L, 0L, (HashMap)localObject, null);
        localSharedPreferences.edit().remove("heap_level").commit();
      }
      localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("MemoryManagerMemoryStat", 0);
      long l2 = localSharedPreferences.getLong("HeapLevelReportLastTime", 0L);
      l1 = l2;
      if (l2 == 0L)
      {
        l1 = System.currentTimeMillis();
        localSharedPreferences.edit().putLong("HeapLevelReportLastTime", l1).commit();
      }
    } while ((Math.abs(System.currentTimeMillis() - l1) <= 86400000L) || (!MagnifierSDK.a().a().aQz));
    Object localObject = new HashMap(10);
    ((HashMap)localObject).put("guard_type", String.valueOf(paramLong));
    ((HashMap)localObject).put("heap_size", String.valueOf(l3));
    ((HashMap)localObject).put("heap_total", String.valueOf(l4));
    ((HashMap)localObject).put("heap_max", String.valueOf(l5));
    ((HashMap)localObject).put("heap_level", String.valueOf(f));
    ((HashMap)localObject).put("sys_total", String.valueOf(l6));
    ((HashMap)localObject).put("sys_pss", String.valueOf(l7));
    if (MagnifierSDK.a().a().aQy)
    {
      i = 1;
      ((HashMap)localObject).put("enable_sucide_heap_new", String.valueOf(i));
      if (!MagnifierSDK.a().a().aQA) {
        break label988;
      }
    }
    label988:
    for (int i = 1;; i = 0)
    {
      ((HashMap)localObject).put("en_sucide_ab", String.valueOf(i));
      anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "HeapLevel", true, 0L, 0L, (HashMap)localObject, null);
      localSharedPreferences.edit().putLong("HeapLevelReportLastTime", System.currentTimeMillis()).commit();
      return;
      i = 0;
      break;
    }
  }
  
  static class AlertMemoryRunner
    implements Runnable
  {
    private int actionType;
    private QQAppInterface app;
    private Context context;
    
    public AlertMemoryRunner(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt)
    {
      this.app = paramQQAppInterface;
      this.context = paramContext;
      this.actionType = paramInt;
      if (MemoryManager.xF == null)
      {
        MemoryManager.aK(new ArrayList());
        MemoryManager.xF.add("com.android.browser");
        MemoryManager.xF.add("com.android.email");
        MemoryManager.xF.add("com.sec.android.app.readershub");
      }
      if (MemoryManager.xE == null)
      {
        MemoryManager.aL(new ArrayList());
        paramQQAppInterface = Pattern.compile("^com.*.android.*");
        MemoryManager.xE.add(paramQQAppInterface);
      }
      if (MemoryManager.xD == null)
      {
        MemoryManager.ar(new ArrayList());
        MemoryManager.xD.add("system");
        MemoryManager.xD.add("com.android.");
        MemoryManager.xD.add("com.google.process.");
        MemoryManager.xD.add("android.process.");
      }
    }
    
    private boolean km(String paramString)
    {
      boolean bool2 = false;
      boolean bool1;
      if (paramString.startsWith("com.tencent.tim"))
      {
        bool1 = true;
        return bool1;
      }
      int i = 0;
      for (;;)
      {
        if (i >= MemoryManager.xF.size()) {
          break label56;
        }
        bool1 = bool2;
        if (paramString.equals(MemoryManager.xF.get(i))) {
          break;
        }
        i += 1;
      }
      label56:
      i = 0;
      while (i < MemoryManager.xE.size())
      {
        if (((Pattern)MemoryManager.xE.get(i)).matcher(paramString).find()) {
          return true;
        }
        i += 1;
      }
      i = 0;
      for (;;)
      {
        bool1 = bool2;
        if (i >= MemoryManager.xD.size()) {
          break;
        }
        if (paramString.startsWith((String)MemoryManager.xD.get(i))) {
          return true;
        }
        i += 1;
      }
    }
    
    @SuppressLint({"NewApi"})
    public void run()
    {
      for (;;)
      {
        long l3;
        try
        {
          boolean bool = this.app.isReleased;
          if (bool) {
            return;
          }
          int i = this.actionType;
          switch (i)
          {
          default: 
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          Intent localIntent;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("Q.Memory.MemoryManager", 2, "AlertMemoryRunner exception, actionType=" + this.actionType, localThrowable);
          localThrowable.printStackTrace();
          return;
          l1 = aqgz.getSystemAvaialbeMemory();
          l2 = aqgz.getSystemTotalMemory();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.Memory.MemoryManager", 2, "clear memory, availMemSize=" + l1 / 1048576L + "M, totalMemSize=" + l2 / 1048576L + "M");
          l3 = MagnifierSDK.a().a().bDb * l2 / 100L;
          if (l1 < l3) {
            continue;
          }
          return;
          Object localObject1 = this.app.getApp().getSharedPreferences("MemoryManagerMemoryStat", 0);
          l4 = ((SharedPreferences)localObject1).getLong("lastClearTime", 0L);
          long l5 = System.currentTimeMillis();
          if (l5 >= l4) {
            continue;
          }
          localObject1 = ((SharedPreferences)localObject1).edit();
          ((SharedPreferences.Editor)localObject1).putLong("lastClearTime", l5);
          ((SharedPreferences.Editor)localObject1).commit();
          return;
          MemoryManager.a().aa(l3, l1);
          l4 = l5 - l4;
          l5 = MagnifierSDK.a().a().clearTime;
          if (l4 >= l5) {
            continue;
          }
          return;
          MemoryManager.a().ab(l3, l1);
          localObject4 = new ArrayList();
          Iterator localIterator = ((ActivityManager)this.context.getSystemService("activity")).getRunningAppProcesses().iterator();
          if (!localIterator.hasNext()) {
            break label647;
          }
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
          String str = localRunningAppProcessInfo.processName;
          if ((localRunningAppProcessInfo.importance == 100) || ((localRunningAppProcessInfo.importance == 200) && ((localRunningAppProcessInfo.importance != 200) || (localRunningAppProcessInfo.importanceReasonCode == 0))) || (km(str))) {
            continue;
          }
          ((ArrayList)localObject4).add(Pair.create(str, Long.valueOf(aqgz.L(localRunningAppProcessInfo.pid))));
          continue;
        }
        finally
        {
          this.app = null;
          this.context = null;
        }
        long l1 = aqgz.getSystemAvaialbeMemory();
        long l2 = aqgz.getSystemTotalMemory();
        if (QLog.isColorLevel()) {
          QLog.d("Q.Memory.MemoryManager", 2, "check memory, availMemSize=" + l1 / 1048576L + "M, totalMemSize=" + l2 / 1048576L + "M");
        }
        l2 = l2 * MagnifierSDK.a().a().bDb / 100L;
        if (l1 >= l2)
        {
          this.app = null;
          this.context = null;
          return;
        }
        localIntent = new Intent(this.context, NotificationActivity.class);
        localIntent.putExtra("type", 10);
        localIntent.setFlags(872415232);
        this.context.startActivity(localIntent);
        continue;
        long l4;
        label647:
        aqfg.aq((ArrayList)localObject4);
        Object localObject4 = (ActivityManager)this.context.getSystemService("activity");
        Object localObject3 = localObject2.edit();
        ((SharedPreferences.Editor)localObject3).putLong("lastClearTime", System.currentTimeMillis());
        ((SharedPreferences.Editor)localObject3).commit();
        localObject3 = anpc.a(BaseApplication.getContext());
        localObject4 = new HashMap();
        ((HashMap)localObject4).put("osVersion", Build.VERSION.RELEASE);
        ((HashMap)localObject4).put("deviceName", Build.MANUFACTURER + "_" + Build.MODEL);
        ((HashMap)localObject4).put("remainMemSize", String.valueOf(l1));
        ((HashMap)localObject4).put("totalMemSize", String.valueOf(l2));
        ((HashMap)localObject4).put("warningMemSize", String.valueOf(l3));
        ((HashMap)localObject4).put("time", String.valueOf(l4 / 60000L));
        ((anpc)localObject3).collectPerformance("", "MemoryClear", true, 0L, 0L, (HashMap)localObject4, "");
      }
    }
  }
  
  public static class a
  {
    public long PW;
    public long PX;
    public long pss;
  }
  
  public static abstract interface b
  {
    public abstract void bBG();
  }
  
  static class c
  {
    long PY;
    long PZ;
    long Qa;
    long Qb;
    long Qc;
    int cww;
    int cwx;
    
    public void init()
    {
      long l = aqgz.getSystemTotalMemory();
      try
      {
        Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("MemoryManagerMemoryStat", 0).getString("LowMemoryStat", null);
        if (localObject == null) {
          return;
        }
        if (((String)localObject).length() == 0) {
          return;
        }
        localObject = new DataInputStream(new ByteArrayInputStream(aqgo.decode((String)localObject, 0)));
        this.PY = ((DataInputStream)localObject).readLong();
        this.PZ = ((DataInputStream)localObject).readLong();
        this.cww = ((DataInputStream)localObject).readInt();
        this.Qa = ((DataInputStream)localObject).readLong();
        this.Qb = ((DataInputStream)localObject).readLong();
        this.cwx = ((DataInputStream)localObject).readInt();
        this.Qc = ((DataInputStream)localObject).readLong();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          reset();
        }
      }
      if ((l < this.PY) || (l < this.PZ) || (l < this.Qa) || (l < this.Qb))
      {
        reset();
        return;
      }
    }
    
    public void reset()
    {
      this.PY = 0L;
      this.PZ = 0L;
      this.cww = 0;
      this.Qa = 0L;
      this.Qb = 0L;
      this.cwx = 0;
      this.Qc = 0L;
    }
    
    public void save()
    {
      try
      {
        Object localObject = new ByteArrayOutputStream();
        DataOutputStream localDataOutputStream = new DataOutputStream((OutputStream)localObject);
        localDataOutputStream.writeLong(this.PY);
        localDataOutputStream.writeLong(this.PZ);
        localDataOutputStream.writeInt(this.cww);
        localDataOutputStream.writeLong(this.Qa);
        localDataOutputStream.writeLong(this.Qb);
        localDataOutputStream.writeInt(this.cwx);
        localDataOutputStream.writeLong(this.Qc);
        localDataOutputStream.flush();
        localObject = ((ByteArrayOutputStream)localObject).toByteArray();
        BaseApplicationImpl.getApplication().getSharedPreferences("MemoryManagerMemoryStat", 0).edit().putString("LowMemoryStat", aqgo.encodeToString((byte[])localObject, 0)).commit();
        return;
      }
      catch (Exception localException) {}
    }
  }
  
  static class d
  {
    public long PW;
    public long PX;
    public long Qd;
    public long Qe;
    public long Qf;
    public long Qg;
    public long Qh;
    public long Qi;
    private String boA;
    public int cwA;
    public int cwy;
    public int cwz;
    
    public void init(String paramString)
    {
      this.boA = paramString;
      try
      {
        paramString = BaseApplicationImpl.getApplication().getSharedPreferences("MemoryManagerMemoryStat", 0).getString(this.boA, null);
        if ((paramString == null) || (paramString.length() == 0))
        {
          reset();
          return;
        }
        paramString = new DataInputStream(new ByteArrayInputStream(aqgo.decode(paramString, 0)));
        this.cwy = paramString.readInt();
        this.Qd = paramString.readLong();
        this.Qe = paramString.readLong();
        this.Qf = paramString.readLong();
        this.Qg = paramString.readLong();
        this.Qh = paramString.readLong();
        this.cwz = paramString.readInt();
        this.cwA = paramString.readInt();
        this.PW = paramString.readLong();
        this.PX = paramString.readLong();
        this.Qi = paramString.readLong();
        return;
      }
      catch (Exception paramString)
      {
        paramString = new HashMap(3);
        paramString.put("type", "wrong-value");
        paramString.put("file", "MemoryManagerMemoryStat");
        paramString.put("key", "MemoryInfomation");
        anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "evSpError", true, 0L, 0L, paramString, null);
        reset();
      }
    }
    
    public void reset()
    {
      this.cwy = 0;
      this.Qd = 0L;
      this.Qe = 0L;
      this.Qf = 0L;
      this.Qg = 0L;
      this.Qh = 0L;
      this.cwz = 0;
      this.cwA = 0;
      this.PW = 0L;
      this.PX = 0L;
      this.Qi = 0L;
    }
    
    public void save()
    {
      try
      {
        Object localObject = new ByteArrayOutputStream();
        DataOutputStream localDataOutputStream = new DataOutputStream((OutputStream)localObject);
        localDataOutputStream.writeInt(this.cwy);
        localDataOutputStream.writeLong(this.Qd);
        localDataOutputStream.writeLong(this.Qe);
        localDataOutputStream.writeLong(this.Qf);
        localDataOutputStream.writeLong(this.Qg);
        localDataOutputStream.writeLong(this.Qh);
        localDataOutputStream.writeInt(this.cwz);
        localDataOutputStream.writeInt(this.cwA);
        localDataOutputStream.writeLong(this.PW);
        localDataOutputStream.writeLong(this.PX);
        localDataOutputStream.writeLong(this.Qi);
        localDataOutputStream.flush();
        localObject = ((ByteArrayOutputStream)localObject).toByteArray();
        BaseApplicationImpl.getApplication().getSharedPreferences("MemoryManagerMemoryStat", 0).edit().putString(this.boA, aqgo.encodeToString((byte[])localObject, 0)).commit();
        return;
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("Q.Memory.MemoryManager", 2, "StatMemory.save exception", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.MemoryManager
 * JD-Core Version:    0.7.0.1
 */