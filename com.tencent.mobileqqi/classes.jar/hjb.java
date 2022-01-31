import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderFactory.DownloadConfig;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class hjb
  implements INetInfoHandler, DownloaderInterface
{
  public static final String a;
  protected Context a;
  protected AppInterface a;
  private DownloaderFactory.DownloadConfig jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory$DownloadConfig;
  private HashMap jdField_a_of_type_JavaUtilHashMap = null;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = null;
  
  static
  {
    jdField_a_of_type_JavaLangString = hjb.class.getSimpleName();
  }
  
  public hjb(AppInterface paramAppInterface, DownloaderFactory.DownloadConfig paramDownloadConfig)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentCommonAppAppInterface.a().getApplicationContext();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    DownloaderFactory.DownloadConfig localDownloadConfig = paramDownloadConfig;
    if (paramDownloadConfig == null) {
      localDownloadConfig = new DownloaderFactory.DownloadConfig();
    }
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory$DownloadConfig = localDownloadConfig;
    if (this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory$DownloadConfig.b) {
      AppNetConnInfo.registerConnectionChangeReceiver(paramAppInterface.getApplication(), this);
    }
  }
  
  private void a(DownloadTask paramDownloadTask)
  {
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    if (paramDownloadTask != null) {}
    try
    {
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramDownloadTask.jdField_a_of_type_JavaLangString))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "removeTask | task=" + paramDownloadTask);
        }
        this.jdField_a_of_type_JavaUtilHashMap.remove(paramDownloadTask.jdField_a_of_type_JavaLangString);
      }
      return;
    }
    finally {}
  }
  
  private void a(String paramString)
  {
    ThreadManager.a(new hjc(this, paramString));
  }
  
  public int a(boolean paramBoolean, String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      if (this.jdField_a_of_type_JavaUtilHashMap.isEmpty()) {
        break label123;
      }
      if (paramBoolean)
      {
        paramString = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
        if (!paramString.hasNext()) {
          break label123;
        }
        String str = (String)paramString.next();
        ((DownloadTask)this.jdField_a_of_type_JavaUtilHashMap.get(str)).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      }
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
    {
      paramString = (DownloadTask)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      if (paramString.b.get()) {
        break label127;
      }
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
    }
    for (;;)
    {
      label123:
      return 0;
      label127:
      paramString.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
  }
  
  public DownloadTask a(String paramString)
  {
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    if (paramString != null) {}
    try
    {
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "getTask | find Task url=" + paramString);
        }
        paramString = (DownloadTask)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
        return paramString;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getTask | not find Task url=" + paramString);
      }
      return null;
    }
    finally {}
  }
  
  public void a()
  {
    a(true, null);
  }
  
  public void a(int paramInt, String paramString, File paramFile, DownloadListener arg4, Bundle paramBundle)
  {
    if ((!DownloaderFactory.a(paramString)) || (paramFile == null)) {}
    while (a(paramString) != null) {
      return;
    }
    paramFile = new DownloadTask(paramInt, paramString, paramFile);
    paramFile.a(???);
    paramFile.a(paramBundle);
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramFile);
      a(paramString);
      return;
    }
  }
  
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi() {}
  
  public void onNetNone2Mobile() {}
  
  public void onNetNone2Wifi() {}
  
  public void onNetWifi2Mobile()
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.size() > 0)) {
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
        while (localIterator.hasNext())
        {
          DownloadTask localDownloadTask = (DownloadTask)((Map.Entry)localIterator.next()).getValue();
          if ((localDownloadTask.a() != null) && (localDownloadTask.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2)) {
            localDownloadTask.a().a();
          }
        }
      }
    }
  }
  
  public void onNetWifi2None() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hjb
 * JD-Core Version:    0.7.0.1
 */