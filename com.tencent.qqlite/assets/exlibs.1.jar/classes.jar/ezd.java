import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
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
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public final class ezd
  implements INetInfoHandler, DownloaderInterface
{
  public static final String a;
  Handler jdField_a_of_type_AndroidOsHandler;
  protected AppInterface a;
  private DownloaderFactory.DownloadConfig jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory$DownloadConfig;
  Runnable jdField_a_of_type_JavaLangRunnable = new eze(this);
  private LinkedList jdField_a_of_type_JavaUtilLinkedList;
  AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
  boolean jdField_a_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_JavaLangString = ezd.class.getSimpleName();
  }
  
  public ezd(AppInterface paramAppInterface, DownloaderFactory.DownloadConfig paramDownloadConfig)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    DownloaderFactory.DownloadConfig localDownloadConfig = paramDownloadConfig;
    if (paramDownloadConfig == null) {
      localDownloadConfig = new DownloaderFactory.DownloadConfig();
    }
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory$DownloadConfig = localDownloadConfig;
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a().getApplicationContext().getMainLooper());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory$DownloadConfig.jdField_a_of_type_Boolean) {
      AppNetConnInfo.registerConnectionChangeReceiver(paramAppInterface.getApplication(), this);
    }
  }
  
  private DownloadTask a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      if (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        while (localIterator.hasNext())
        {
          DownloadTask localDownloadTask = (DownloadTask)localIterator.next();
          if (!localDownloadTask.a())
          {
            localDownloadTask.a();
            return localDownloadTask;
          }
        }
      }
      return null;
    }
  }
  
  public int a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "cancelTask stopAll=" + paramBoolean + ",key=" + paramString);
    }
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      if (this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) {
        break label107;
      }
      if (!paramBoolean) {
        break label111;
      }
      paramString = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
      if (paramString.hasNext()) {
        ((DownloadTask)paramString.next()).a(true);
      }
    }
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    for (;;)
    {
      label107:
      return 0;
      label111:
      if ((paramString == null) || (TextUtils.isEmpty(paramString))) {
        break;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
      while (localIterator.hasNext())
      {
        DownloadTask localDownloadTask = (DownloadTask)localIterator.next();
        if (paramString.equals(localDownloadTask.jdField_a_of_type_JavaLangString))
        {
          if (!localDownloadTask.a())
          {
            localIterator.remove();
            this.jdField_a_of_type_JavaUtilLinkedList.remove(localDownloadTask);
          }
          else
          {
            localDownloadTask.a(true);
          }
        }
        else if ((localDownloadTask.b()) && (!localDownloadTask.a()))
        {
          localIterator.remove();
          this.jdField_a_of_type_JavaUtilLinkedList.remove(localDownloadTask);
        }
      }
    }
    return -1;
  }
  
  public DownloadTask a(String paramString)
  {
    LinkedList localLinkedList = this.jdField_a_of_type_JavaUtilLinkedList;
    if (paramString != null) {}
    try
    {
      if (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        while (localIterator.hasNext())
        {
          DownloadTask localDownloadTask = (DownloadTask)localIterator.next();
          if (paramString.equals(localDownloadTask.jdField_a_of_type_JavaLangString))
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "getTask | " + paramString + " task find =" + localDownloadTask);
            }
            return localDownloadTask;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getTask | " + paramString + " task not find");
      }
      return null;
    }
    finally {}
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    a(true, null);
  }
  
  public void a(DownloadTask paramDownloadTask)
  {
    LinkedList localLinkedList = this.jdField_a_of_type_JavaUtilLinkedList;
    if (paramDownloadTask != null) {}
    try
    {
      if ((!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) && (this.jdField_a_of_type_JavaUtilLinkedList.contains(paramDownloadTask)))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "removeTask | task=" + paramDownloadTask);
        }
        this.jdField_a_of_type_JavaUtilLinkedList.remove(paramDownloadTask);
      }
      return;
    }
    finally {}
  }
  
  public void a(DownloadTask arg1, DownloadListener arg2, Bundle paramBundle)
  {
    if ((!DownloaderFactory.a(???)) || (a(???.jdField_a_of_type_JavaLangString) != null)) {
      return;
    }
    ???.a(???);
    ???.a(paramBundle);
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
      {
        if (a(???.jdField_a_of_type_JavaLangString) == null)
        {
          ???.c = ((int)(System.currentTimeMillis() / 1000L));
          if (???.b) {
            this.jdField_a_of_type_JavaUtilLinkedList.addFirst(???);
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "startDownload | task=" + ???.jdField_a_of_type_JavaLangString);
          }
          if ((this.jdField_a_of_type_AndroidOsHandler == null) || (this.jdField_a_of_type_Boolean)) {}
        }
      }
      synchronized (this.jdField_a_of_type_AndroidOsHandler)
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
        }
        c();
        return;
        this.jdField_a_of_type_JavaUtilLinkedList.addLast(???);
        continue;
        ??? = finally;
        throw ???;
      }
    }
  }
  
  void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "filterTask begin...");
    }
    if (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) {
      synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
      {
        int i = (int)(System.currentTimeMillis() / 1000L);
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        while (localIterator.hasNext())
        {
          DownloadTask localDownloadTask = (DownloadTask)localIterator.next();
          if ((!localDownloadTask.a()) && (localDownloadTask.d > 0L) && (i > localDownloadTask.c + localDownloadTask.d))
          {
            DownloadListener localDownloadListener = localDownloadTask.a();
            localDownloadTask.z = -102;
            localDownloadTask.a(-1);
            if (localDownloadListener != null) {
              localDownloadListener.onDone(localDownloadTask);
            }
            localIterator.remove();
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "filterTask end...");
    }
  }
  
  void c()
  {
    try
    {
      synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        while (localIterator.hasNext())
        {
          DownloadTask localDownloadTask = (DownloadTask)localIterator.next();
          if (localDownloadTask.b())
          {
            localIterator.remove();
            this.jdField_a_of_type_JavaUtilLinkedList.remove(localDownloadTask);
          }
        }
      }
      if (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) {
        break label123;
      }
    }
    finally {}
    if (this.jdField_a_of_type_AndroidOsHandler != null) {}
    for (;;)
    {
      synchronized (this.jdField_a_of_type_AndroidOsHandler)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        this.jdField_a_of_type_Boolean = false;
        return;
      }
      label123:
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "doTask | downloadLimitCount=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ",maxDownloadCount=" + 5 + ",downloadQueue size=" + this.jdField_a_of_type_JavaUtilLinkedList.size());
      }
      while (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() <= 5)
      {
        ThreadManager.a(new ezf(this));
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
      }
    }
  }
  
  public void onNetMobile2None()
  {
    if ((this.jdField_a_of_type_JavaUtilLinkedList != null) && (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)) {
      synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        while (localIterator.hasNext())
        {
          DownloadTask localDownloadTask = (DownloadTask)localIterator.next();
          if ((localDownloadTask.a() != null) && (localDownloadTask.a() == 2)) {
            localDownloadTask.a().onNetMobile2None();
          }
        }
      }
    }
  }
  
  public void onNetMobile2Wifi() {}
  
  public void onNetNone2Mobile() {}
  
  public void onNetNone2Wifi() {}
  
  public void onNetWifi2Mobile()
  {
    if ((this.jdField_a_of_type_JavaUtilLinkedList != null) && (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)) {
      synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        while (localIterator.hasNext())
        {
          DownloadTask localDownloadTask = (DownloadTask)localIterator.next();
          if ((localDownloadTask.a() != null) && (localDownloadTask.a() == 2)) {
            localDownloadTask.a().onNetWifi2Mobile();
          }
        }
      }
    }
  }
  
  public void onNetWifi2None()
  {
    if ((this.jdField_a_of_type_JavaUtilLinkedList != null) && (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)) {
      synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        while (localIterator.hasNext())
        {
          DownloadTask localDownloadTask = (DownloadTask)localIterator.next();
          if ((localDownloadTask.a() != null) && (localDownloadTask.a() == 2)) {
            localDownloadTask.a().onNetWifi2None();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ezd
 * JD-Core Version:    0.7.0.1
 */