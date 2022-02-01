import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.mobileqq.intervideo.InvalidFileException;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.core.common.LoggerFactory;
import com.tencent.shadow.dynamic.host.DynamicPluginManager;
import com.tencent.shadow.dynamic.host.PluginManagerUpdater;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class aicg
{
  private static aicf a;
  public static final IVPluginDataReporter a;
  private static boolean isSet;
  private static final Object sLock;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter = new IVPluginDataReporter();
    sLock = new Object();
    setILoggerFactory();
  }
  
  public static aibz a(Context paramContext, String paramString1, String paramString2)
    throws InterruptedException, TimeoutException, ExecutionException
  {
    try
    {
      paramContext = (aibz)acmo.a(192).submit(new aich(paramContext, paramString1)).get(20L, TimeUnit.SECONDS);
      return paramContext;
    }
    catch (TimeoutException paramContext)
    {
      jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.opType("updateException").d1(paramContext.toString()).report();
      throw paramContext;
    }
    catch (InterruptedException paramContext)
    {
      jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.opType("updateException").d1(paramContext.toString()).report();
      throw paramContext;
    }
    catch (ExecutionException paramContext)
    {
      jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.opType("updateException").d1(paramContext.toString()).report();
      throw paramContext;
    }
  }
  
  private static aicf a(String paramString, aibq paramaibq)
  {
    QLog.i("shadow::Shadow", 2, "pluginManagerWrapper ，sPluginManagerWrapper = " + jdField_a_of_type_Aicf + " bizType:" + paramString);
    synchronized (sLock)
    {
      if (jdField_a_of_type_Aicf == null)
      {
        jdField_a_of_type_Aicf = new aicf(paramString, new DynamicPluginManager(paramaibq));
        QLog.i("shadow::Shadow", 2, "new pluginManagerWrapper : " + jdField_a_of_type_Aicf);
      }
      paramString = jdField_a_of_type_Aicf;
      return paramString;
    }
  }
  
  public static aibz b(Context paramContext, String paramString1, String paramString2)
    throws ExecutionException, InterruptedException
  {
    l1 = System.currentTimeMillis();
    jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.opDepartment("shadow").opName(paramString1).opType("CdnGetBizPm").toUin(paramString2);
    Object localObject1 = new aibt(paramString1);
    if (((aibt)localObject1).getLatest() != null) {
      return new aicf(paramString1, new DynamicPluginManager((PluginManagerUpdater)localObject1));
    }
    localaibq = new aibq(paramContext.getApplicationContext(), paramString1, paramString2, "9_1");
    if (QLog.isColorLevel()) {
      QLog.i("shadow::Shadow", 2, "wasUpdating:" + localaibq.wasUpdating() + " getLatest:" + localaibq.getLatest());
    }
    if ((localaibq.wasUpdating()) || (localaibq.getLatest() == null))
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.i("shadow::Shadow", 2, "needWaitingUpdate:" + bool);
      }
      if (TextUtils.equals("GVideo", paramString1)) {
        localaibq.a(new aici(paramString1));
      }
      paramString2 = localaibq.update();
      if (!bool) {}
    }
    for (;;)
    {
      try
      {
        paramString2.get();
        localObject2 = paramContext.getPackageManager();
        if (localaibq.getLatest() != null)
        {
          paramContext = localaibq.getLatest().getAbsolutePath();
          l2 = System.currentTimeMillis();
          localObject1 = null;
          paramString2 = null;
        }
      }
      catch (ExecutionException paramContext)
      {
        Object localObject2;
        l2 = System.currentTimeMillis();
        jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.d1(Boolean.toString(bool)).d2(Long.toString(l2 - l1)).opResult(1).report();
        throw paramContext;
      }
      catch (InterruptedException paramContext)
      {
        l2 = System.currentTimeMillis();
        jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.d1(Boolean.toString(bool)).d2(Long.toString(l2 - l1)).opResult(2).report();
        throw paramContext;
      }
      try
      {
        localObject2 = ((PackageManager)localObject2).getPackageArchiveInfo(paramContext, 128);
        paramString2 = (String)localObject2;
        localObject1 = localObject2;
        QLog.i("shadow::Shadow", 2, "getPackageArchiveInfo，timespan = " + (System.currentTimeMillis() - l2));
        if (localObject2 == null) {
          paramString1 = "";
        }
      }
      catch (Exception localException)
      {
        if (paramString2 == null) {
          paramString1 = "";
        }
        try
        {
          paramString2 = aszr.getFileMD5String(localaibq.getLatest());
          paramString1 = paramString2;
        }
        catch (IOException paramString2)
        {
          break label497;
        }
        QLog.i("shadow::Shadow", 1, "pluginManager apk file is invalid，apk = " + paramContext + " md5 = " + paramString1);
        jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.d1(paramContext).d2("FileInvalid").d3(paramString1).opResult(1000).report();
        localaibq.drU();
        throw new InvalidFileException("pluginManager apk file is invalid!");
      }
      finally
      {
        if (localException == null) {
          paramString1 = "";
        }
        try
        {
          paramString2 = aszr.getFileMD5String(localaibq.getLatest());
          paramString1 = paramString2;
        }
        catch (IOException paramString2)
        {
          break label592;
        }
        QLog.i("shadow::Shadow", 1, "pluginManager apk file is invalid，apk = " + paramContext + " md5 = " + paramString1);
        jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.d1(paramContext).d2("FileInvalid").d3(paramString1).opResult(1000).report();
        localaibq.drU();
        throw new InvalidFileException("pluginManager apk file is invalid!");
        throw paramString1;
        l2 = System.currentTimeMillis();
        if (TextUtils.equals("GVideo", paramString1)) {}
        for (paramContext = a(paramString1, localaibq);; paramContext = new aicf(paramString1, new DynamicPluginManager(localaibq)))
        {
          jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.d1(Boolean.toString(bool)).d2(Long.toString(l2 - l1)).opResult(0).report();
          return paramContext;
        }
      }
      try
      {
        paramString2 = aszr.getFileMD5String(localaibq.getLatest());
        paramString1 = paramString2;
      }
      catch (IOException paramString2)
      {
        continue;
      }
      QLog.i("shadow::Shadow", 1, "pluginManager apk file is invalid，apk = " + paramContext + " md5 = " + paramString1);
      jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.d1(paramContext).d2("FileInvalid").d3(paramString1).opResult(1000).report();
      localaibq.drU();
      throw new InvalidFileException("pluginManager apk file is invalid!");
      bool = false;
      break;
      paramContext = "";
    }
  }
  
  public static void setILoggerFactory()
  {
    if (!isSet) {}
    try
    {
      LoggerFactory.setILoggerFactory(aibx.a());
      label12:
      isSet = true;
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      break label12;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aicg
 * JD-Core Version:    0.7.0.1
 */