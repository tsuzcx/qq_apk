package com.tencent.common.app;

import android.app.ActivityManager;
import android.os.Build.VERSION;
import android.support.v4.util.MQLruCache;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngineHandler;
import java.util.HashMap;

public class OOMHandler
  implements SkinEngineHandler
{
  private static final String jdField_a_of_type_JavaLangString = "res-OOM";
  private int jdField_a_of_type_Int = -1;
  private BaseApplicationImpl jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
  
  public OOMHandler(BaseApplicationImpl paramBaseApplicationImpl)
  {
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl = paramBaseApplicationImpl;
  }
  
  public boolean onDecodeOOM(OutOfMemoryError paramOutOfMemoryError, String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Int == -1) {
      this.jdField_a_of_type_Int = ((ActivityManager)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getSystemService("activity")).getMemoryClass();
    }
    long l = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    paramOutOfMemoryError = new StringBuffer("decode resources oom, fileName: ");
    paramOutOfMemoryError.append(paramString);
    paramOutOfMemoryError.append(", is skin file: ");
    paramOutOfMemoryError.append(paramBoolean);
    paramOutOfMemoryError.append(", memory used:");
    paramOutOfMemoryError.append(l);
    paramOutOfMemoryError.append(" , heap size: ");
    paramOutOfMemoryError.append(this.jdField_a_of_type_Int);
    paramOutOfMemoryError.append(", api level:");
    paramOutOfMemoryError.append(Build.VERSION.SDK_INT);
    if (BaseApplicationImpl.a != null)
    {
      paramOutOfMemoryError.append(", imageCache size:");
      paramOutOfMemoryError.append(BaseApplicationImpl.a.size());
    }
    QLog.e("res-OOM", 1, paramOutOfMemoryError.toString());
    paramOutOfMemoryError = new HashMap(4);
    paramOutOfMemoryError.put("param_FailCode", Integer.toString(89100));
    paramOutOfMemoryError.put("param_heapSize", Integer.toString(this.jdField_a_of_type_Int));
    paramOutOfMemoryError.put("param_apiLevel", Integer.toString(Build.VERSION.SDK_INT));
    paramOutOfMemoryError.put("param_cacheUsed", Long.toString(l));
    try
    {
      StatisticCollector.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a(null, "report_resource_decode_OOM", false, 0L, 0L, paramOutOfMemoryError, "");
      if (BaseApplicationImpl.a != null) {
        BaseApplicationImpl.a.evictAll();
      }
      System.gc();
      Thread.yield();
      System.gc();
      return true;
    }
    catch (Exception paramOutOfMemoryError)
    {
      for (;;)
      {
        paramOutOfMemoryError.printStackTrace();
      }
    }
  }
  
  public boolean onDecodeReturnNullBitmap(String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Int == -1) {
      this.jdField_a_of_type_Int = ((ActivityManager)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getSystemService("activity")).getMemoryClass();
    }
    long l = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    StringBuffer localStringBuffer = new StringBuffer("decode resources return null, fileName: ");
    localStringBuffer.append(paramString);
    localStringBuffer.append(", is skin file: ");
    localStringBuffer.append(paramBoolean);
    localStringBuffer.append(", memory used:");
    localStringBuffer.append(l);
    localStringBuffer.append(" , heap size: ");
    localStringBuffer.append(this.jdField_a_of_type_Int);
    localStringBuffer.append(", api level:");
    localStringBuffer.append(Build.VERSION.SDK_INT);
    if (BaseApplicationImpl.a != null)
    {
      localStringBuffer.append(", imageCache size:");
      localStringBuffer.append(BaseApplicationImpl.a.size());
    }
    paramString = new HashMap(4);
    paramString.put("param_FailCode", Integer.toString(89102));
    paramString.put("param_heapSize", Integer.toString(this.jdField_a_of_type_Int));
    paramString.put("param_apiLevel", Integer.toString(Build.VERSION.SDK_INT));
    paramString.put("param_cacheUsed", Long.toString(l));
    try
    {
      StatisticCollector.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a(null, "report_resource_decode_OOM", false, 0L, 0L, paramString, "");
      QLog.e("res-OOM", 1, localStringBuffer.toString());
      if (BaseApplicationImpl.a != null) {
        BaseApplicationImpl.a.evictAll();
      }
      System.gc();
      Thread.yield();
      System.gc();
      return true;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public boolean onSecondDecodeOOM(OutOfMemoryError paramOutOfMemoryError, String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Int == -1) {
      this.jdField_a_of_type_Int = ((ActivityManager)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getSystemService("activity")).getMemoryClass();
    }
    long l = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    StringBuffer localStringBuffer = new StringBuffer("decode resources second oom, fileName: ");
    localStringBuffer.append(paramString);
    localStringBuffer.append(", is skin file: ");
    localStringBuffer.append(paramBoolean);
    localStringBuffer.append(", memory used:");
    localStringBuffer.append(l);
    localStringBuffer.append(" , heap size: ");
    localStringBuffer.append(this.jdField_a_of_type_Int);
    localStringBuffer.append(", api level:");
    localStringBuffer.append(Build.VERSION.SDK_INT);
    if (BaseApplicationImpl.a != null)
    {
      localStringBuffer.append(", imageCache size:");
      localStringBuffer.append(BaseApplicationImpl.a.size());
    }
    paramString = new HashMap(4);
    paramString.put("param_FailCode", Integer.toString(89101));
    paramString.put("param_heapSize", Integer.toString(this.jdField_a_of_type_Int));
    paramString.put("param_apiLevel", Integer.toString(Build.VERSION.SDK_INT));
    paramString.put("param_cacheUsed", Long.toString(l));
    try
    {
      StatisticCollector.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a(null, "report_resource_decode_OOM", false, 0L, 0L, paramString, "");
      QLog.e("res-OOM", 1, localStringBuffer.toString(), paramOutOfMemoryError);
      if (BaseApplicationImpl.a != null) {
        BaseApplicationImpl.a.evictAll();
      }
      System.gc();
      Thread.yield();
      System.gc();
      return true;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.common.app.OOMHandler
 * JD-Core Version:    0.7.0.1
 */