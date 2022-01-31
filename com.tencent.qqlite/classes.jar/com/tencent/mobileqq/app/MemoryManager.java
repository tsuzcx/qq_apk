package com.tencent.mobileqq.app;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import cte;
import ctq;
import ctr;
import cts;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class MemoryManager
{
  private static final byte jdField_a_of_type_Byte = 1;
  private static final long jdField_a_of_type_Long = 1048576L;
  private static MemoryManager jdField_a_of_type_ComTencentMobileqqAppMemoryManager = null;
  public static final String a = "com.tencent.process.exit";
  private static List jdField_a_of_type_JavaUtilList = null;
  private static final byte jdField_b_of_type_Byte = 2;
  private static long jdField_b_of_type_Long = 0L;
  public static final String b = "MemoryInfomation";
  private static List jdField_b_of_type_JavaUtilList = null;
  public static final String c = "MemoryAlertAutoClear";
  private static List jdField_c_of_type_JavaUtilList = null;
  private static final String d = "Q.Memory.MemoryManager";
  private int jdField_a_of_type_Int = 0;
  private ctr jdField_a_of_type_Ctr = null;
  private cts jdField_a_of_type_Cts = null;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private boolean jdField_a_of_type_Boolean = false;
  private boolean jdField_b_of_type_Boolean = false;
  private long jdField_c_of_type_Long = 900000L;
  private boolean jdField_c_of_type_Boolean = false;
  
  public static long a()
  {
    if (jdField_b_of_type_Long > 0L) {
      return jdField_b_of_type_Long;
    }
    long l1 = DeviceInfoUtil.c();
    long l2 = DeviceInfoUtil.d();
    long l3 = (3L * l1 + 7L * l2) / 10L;
    long l4 = DeviceInfoUtil.e();
    if (l3 <= 157286400L) {
      jdField_b_of_type_Long = Math.min(25165824L, l4);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.Memory.MemoryManager", 2, "getAvailClassSize, availClassSize=" + jdField_b_of_type_Long / 1048576L + "M, totalMemSize=" + l1 / 1048576L + "M, remainMemSize=" + l2 / 1048576L + "M, availMemSize=" + l3 / 1048576L + "M, classMemSize=" + l4 / 1048576L + "M");
      }
      return jdField_b_of_type_Long;
      if (l3 <= 262144000L) {
        jdField_b_of_type_Long = Math.min(37748736L, l4);
      } else if (l3 <= 419430400L) {
        jdField_b_of_type_Long = Math.min(67108864L, l4);
      } else if (l3 <= 524288000L) {
        jdField_b_of_type_Long = Math.min(134217728L, l4);
      } else {
        jdField_b_of_type_Long = Math.min(268435456L, l4);
      }
    }
  }
  
  public static long a(int paramInt)
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
    }
    return 62914560L;
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
  
  private ctr a()
  {
    if (this.jdField_a_of_type_Ctr == null)
    {
      this.jdField_a_of_type_Ctr = new ctr(this);
      this.jdField_a_of_type_Ctr.a();
    }
    return this.jdField_a_of_type_Ctr;
  }
  
  private void d()
  {
    if (!this.jdField_c_of_type_Boolean) {
      try
      {
        Object localObject1;
        if (!this.jdField_c_of_type_Boolean)
        {
          localObject1 = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.new_memory_strategy.name());
          if (QLog.isColorLevel()) {
            QLog.d("Q.Memory.MemoryManager", 2, "parseDpc strategy=" + (String)localObject1);
          }
        }
        try
        {
          localObject1 = ((String)localObject1).split("\\|");
          if (localObject1[0].equals("1")) {
            this.jdField_a_of_type_Boolean = true;
          }
          localObject1 = localObject1[1].split(";");
          if (localObject1[0].equals("1"))
          {
            this.jdField_b_of_type_Boolean = true;
            this.jdField_a_of_type_Int = Integer.parseInt(localObject1[1]);
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.Memory.MemoryManager", 2, "parseDpc ok trick=" + this.jdField_a_of_type_Boolean + ";clear=" + this.jdField_b_of_type_Boolean + ";clearValue=" + this.jdField_a_of_type_Int);
          }
          this.jdField_c_of_type_Boolean = true;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.Memory.MemoryManager", 2, "parseDpc err", localException);
            }
          }
        }
        return;
      }
      finally {}
    }
  }
  
  public int a()
  {
    d();
    if (this.jdField_a_of_type_Int > 50) {
      this.jdField_a_of_type_Int = 50;
    }
    if (this.jdField_a_of_type_Int < 1) {
      this.jdField_a_of_type_Int = 1;
    }
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    b();
    c();
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      ctr localctr = a();
      localctr.jdField_a_of_type_Long += paramLong2;
      localctr.jdField_b_of_type_Long += paramLong1;
      localctr.jdField_a_of_type_Int += 1;
      localctr.c();
      return;
    }
  }
  
  public void a(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface == null) || (paramQQAppInterface.i)) {}
    while (!b()) {
      return;
    }
    paramQQAppInterface.a(new ctq(paramQQAppInterface, paramContext, 2));
  }
  
  public boolean a()
  {
    d();
    return this.jdField_a_of_type_Boolean;
  }
  
  public long b()
  {
    d();
    if (this.jdField_c_of_type_Long < 900000L) {
      this.jdField_c_of_type_Long = 900000L;
    }
    return this.jdField_c_of_type_Long;
  }
  
  protected void b()
  {
    Object localObject1 = (ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity");
    if (this.jdField_a_of_type_Cts == null)
    {
      this.jdField_a_of_type_Cts = new cts(this);
      this.jdField_a_of_type_Cts.a();
    }
    if (this.jdField_a_of_type_Cts.jdField_b_of_type_Long == 0L) {
      this.jdField_a_of_type_Cts.jdField_b_of_type_Long = DeviceInfoUtil.c();
    }
    if (this.jdField_a_of_type_Cts.jdField_c_of_type_Long == 0L) {
      this.jdField_a_of_type_Cts.jdField_c_of_type_Long = DeviceInfoUtil.e();
    }
    long l3 = DeviceInfoUtil.d();
    long l4 = a(Process.myPid());
    localObject1 = ((ActivityManager)localObject1).getRunningAppProcesses();
    long l1;
    long l2;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      l1 = 0L;
      l2 = l1;
      if (!((Iterator)localObject1).hasNext()) {
        break label194;
      }
      localObject2 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next();
      String str = ((ActivityManager.RunningAppProcessInfo)localObject2).processName;
      if ((!str.startsWith("com.tencent.qqlite")) || (str.equals("com.tencent.qqlite"))) {
        break label980;
      }
      l1 += a(((ActivityManager.RunningAppProcessInfo)localObject2).pid);
    }
    label194:
    label975:
    label980:
    for (;;)
    {
      break;
      l2 = 0L;
      if ((l3 < 0L) || (l4 < 0L) || (l2 < 0L)) {
        return;
      }
      if (this.jdField_a_of_type_Cts.jdField_a_of_type_Long == 0L) {
        this.jdField_a_of_type_Cts.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      localObject1 = this.jdField_a_of_type_Cts;
      ((cts)localObject1).d += l3;
      localObject1 = this.jdField_a_of_type_Cts;
      ((cts)localObject1).e = (l2 + ((cts)localObject1).e);
      localObject1 = this.jdField_a_of_type_Cts;
      ((cts)localObject1).f += l4;
      localObject1 = this.jdField_a_of_type_Cts;
      ((cts)localObject1).jdField_a_of_type_Int += 1;
      localObject1 = BaseApplicationImpl.a;
      localObject2 = this.jdField_a_of_type_Cts;
      ((cts)localObject2).g += ((MQLruCache)localObject1).maxSize();
      localObject2 = this.jdField_a_of_type_Cts;
      ((cts)localObject2).h += ((MQLruCache)localObject1).size();
      localObject2 = this.jdField_a_of_type_Cts;
      ((cts)localObject2).jdField_c_of_type_Int += ((MQLruCache)localObject1).hitCount();
      localObject2 = this.jdField_a_of_type_Cts;
      int i = ((cts)localObject2).jdField_b_of_type_Int;
      ((cts)localObject2).jdField_b_of_type_Int = (((MQLruCache)localObject1).missCount() + i);
      l1 = System.currentTimeMillis();
      for (;;)
      {
        try
        {
          if (l1 - this.jdField_a_of_type_Cts.jdField_a_of_type_Long > 86400000L)
          {
            i = this.jdField_a_of_type_Cts.jdField_a_of_type_Int;
            localObject1 = new HashMap();
            ((HashMap)localObject1).put("sysTotalMemory", String.valueOf(this.jdField_a_of_type_Cts.jdField_b_of_type_Long / 1024L));
            ((HashMap)localObject1).put("sysClassMemory", String.valueOf(this.jdField_a_of_type_Cts.jdField_c_of_type_Long / 1024L));
            ((HashMap)localObject1).put("sysAvailableMemory", String.valueOf(this.jdField_a_of_type_Cts.d / (i * 1024)));
            ((HashMap)localObject1).put("qqOtherUsedMemory", String.valueOf(this.jdField_a_of_type_Cts.e / (i * 1024)));
            ((HashMap)localObject1).put("qqUsedMemory", String.valueOf(this.jdField_a_of_type_Cts.f / (i * 1024)));
            ((HashMap)localObject1).put("imageCacheMax", String.valueOf(this.jdField_a_of_type_Cts.g / (i * 1024)));
            ((HashMap)localObject1).put("imageCacheUsed", String.valueOf(this.jdField_a_of_type_Cts.h / (i * 1024)));
            ((HashMap)localObject1).put("imageHitCount", String.valueOf(this.jdField_a_of_type_Cts.jdField_c_of_type_Int / i));
            if (this.jdField_a_of_type_Cts.jdField_c_of_type_Int + this.jdField_a_of_type_Cts.jdField_b_of_type_Int == 0) {
              break label975;
            }
            d1 = this.jdField_a_of_type_Cts.jdField_c_of_type_Int * 100.0D / (this.jdField_a_of_type_Cts.jdField_c_of_type_Int + this.jdField_a_of_type_Cts.jdField_b_of_type_Int);
            ((HashMap)localObject1).put("imageHitRate", String.valueOf(d1));
            ((HashMap)localObject1).put("guardConfigId", cte.a().a());
            StatisticCollector.a(BaseApplicationImpl.a()).a(null, "actMemory", true, 0L, 0L, (HashMap)localObject1, null);
            this.jdField_a_of_type_Cts.jdField_a_of_type_Long = l1;
            this.jdField_a_of_type_Cts.b();
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.Memory.MemoryManager", 2, "reportMemoryInfo, startTime=" + this.jdField_a_of_type_Cts.jdField_a_of_type_Long + ", statCount=" + this.jdField_a_of_type_Cts.jdField_a_of_type_Int + ", sysTotalMemory=" + this.jdField_a_of_type_Cts.jdField_b_of_type_Long + ", sysAvailableMemory=" + this.jdField_a_of_type_Cts.d + ", qqOtherUsedMemory=" + this.jdField_a_of_type_Cts.e + ", qqUsedMemory=" + this.jdField_a_of_type_Cts.f + ",imageCacheMax=" + this.jdField_a_of_type_Cts.g + ",imageCacheUsed=" + this.jdField_a_of_type_Cts.h + ",imageHitCount=" + this.jdField_a_of_type_Cts.jdField_c_of_type_Int + ",imageHitTotal=" + (this.jdField_a_of_type_Cts.jdField_c_of_type_Int + this.jdField_a_of_type_Cts.jdField_b_of_type_Int));
          }
          this.jdField_a_of_type_Cts.c();
          return;
        }
        catch (Exception localException) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.Memory.MemoryManager", 2, "reportMemoryInfo exception", localException);
        return;
        double d1 = 0.0D;
      }
    }
  }
  
  public void b(long paramLong1, long paramLong2)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      ctr localctr = a();
      localctr.jdField_c_of_type_Long += paramLong2;
      localctr.d += paramLong1;
      localctr.jdField_b_of_type_Int += 1;
      localctr.c();
      return;
    }
  }
  
  public boolean b()
  {
    d();
    return this.jdField_b_of_type_Boolean;
  }
  
  protected void c()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      localctr = a();
      l1 = System.currentTimeMillis();
      long l2 = localctr.e;
      if (l1 - l2 > 86400000L) {}
      for (;;)
      {
        try
        {
          i = localctr.jdField_a_of_type_Int;
          j = localctr.jdField_b_of_type_Int;
          HashMap localHashMap = new HashMap();
          localHashMap.put("sysTotalMemory", String.valueOf(DeviceInfoUtil.c() / 1024L));
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
          StatisticCollector.a(BaseApplicationImpl.a()).a(null, "LowMemoryStat", true, 0L, 0L, localHashMap, null);
          if (QLog.isColorLevel()) {
            QLog.d("Q.Memory.MemoryManager", 2, "reportLowMemory, sysTotalMemory=" + String.valueOf(DeviceInfoUtil.c() / 1024L) + ", lowWarningMemory=" + localctr.jdField_b_of_type_Long + ", lowRemainMemory=" + localctr.jdField_a_of_type_Long + ", lowMemoryCount=" + i + ", clearWarningMemory=" + localctr.d + ", clearRemainMemory=" + localctr.jdField_c_of_type_Long + ",clearCount=" + j);
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
          localctr.b();
          localctr.e = l1;
          continue;
          localObject1 = finally;
          throw localObject1;
        }
        finally
        {
          localctr.b();
          localctr.e = l1;
        }
        localctr.c();
        return;
        str = String.valueOf(localctr.jdField_b_of_type_Long / (i * 1024));
        continue;
        str = String.valueOf(localctr.jdField_a_of_type_Long / (i * 1024));
        continue;
        str = String.valueOf(localctr.d / (j * 1024));
      }
      l2 = localctr.jdField_c_of_type_Long / (j * 1024);
      str = String.valueOf(l2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.MemoryManager
 * JD-Core Version:    0.7.0.1
 */