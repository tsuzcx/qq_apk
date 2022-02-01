import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory.DownloadConfig;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class hev
  implements INetInfoHandler, DownloaderInterface
{
  public static final String a;
  protected Context a;
  protected AppInterface a;
  private DownloaderFactory.DownloadConfig jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory$DownloadConfig;
  private LinkedList jdField_a_of_type_JavaUtilLinkedList = null;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = null;
  boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaLangString = hev.class.getSimpleName();
  }
  
  public hev(AppInterface paramAppInterface, DownloaderFactory.DownloadConfig paramDownloadConfig)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentCommonAppAppInterface.a().getApplicationContext();
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
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
  
  private void b()
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
      while (localIterator.hasNext())
      {
        DownloadTask localDownloadTask = (DownloadTask)localIterator.next();
        if (localDownloadTask.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
          this.jdField_a_of_type_JavaUtilLinkedList.remove(localDownloadTask);
        }
      }
    }
    if (this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())
    {
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    ThreadManager.a(new hew(this));
  }
  
  public int a(boolean paramBoolean, String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      if (this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) {
        break label180;
      }
      if (paramBoolean)
      {
        paramString = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        if (!paramString.hasNext()) {
          break label180;
        }
        ((DownloadTask)paramString.next()).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      }
    }
    if (paramString != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
      while (localIterator.hasNext())
      {
        DownloadTask localDownloadTask = (DownloadTask)localIterator.next();
        if (paramString.equals(localDownloadTask.jdField_a_of_type_JavaLangString))
        {
          if (!localDownloadTask.b.get()) {
            this.jdField_a_of_type_JavaUtilLinkedList.remove(localDownloadTask);
          } else {
            localDownloadTask.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
          }
        }
        else if ((localDownloadTask.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (!localDownloadTask.b.get())) {
          this.jdField_a_of_type_JavaUtilLinkedList.remove(localDownloadTask);
        }
      }
    }
    label180:
    return 0;
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
              QLog.d(jdField_a_of_type_JavaLangString, 2, "getTask | find Task url=" + paramString);
            }
            return localDownloadTask;
          }
        }
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
  
  /* Error */
  public void a(int paramInt, String paramString, java.io.File arg3, DownloadListener paramDownloadListener, android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: invokestatic 179	com/tencent/mobileqq/vip/DownloaderFactory:a	(Ljava/lang/String;)Z
    //   6: istore 6
    //   8: iload 6
    //   10: ifeq +7 -> 17
    //   13: aload_3
    //   14: ifnonnull +6 -> 20
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: aload_0
    //   21: aload_2
    //   22: invokevirtual 181	hev:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/vip/DownloadTask;
    //   25: ifnonnull -8 -> 17
    //   28: new 134	com/tencent/mobileqq/vip/DownloadTask
    //   31: dup
    //   32: iload_1
    //   33: aload_2
    //   34: aload_3
    //   35: invokespecial 184	com/tencent/mobileqq/vip/DownloadTask:<init>	(ILjava/lang/String;Ljava/io/File;)V
    //   38: astore_2
    //   39: aload_2
    //   40: aload 4
    //   42: invokevirtual 187	com/tencent/mobileqq/vip/DownloadTask:a	(Lcom/tencent/mobileqq/vip/DownloadListener;)V
    //   45: aload_2
    //   46: aload 5
    //   48: invokevirtual 190	com/tencent/mobileqq/vip/DownloadTask:a	(Landroid/os/Bundle;)V
    //   51: aload_0
    //   52: getfield 33	hev:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   55: astore_3
    //   56: aload_3
    //   57: monitorenter
    //   58: aload_0
    //   59: getfield 33	hev:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   62: aload_2
    //   63: invokevirtual 194	java/util/LinkedList:addLast	(Ljava/lang/Object;)V
    //   66: aload_3
    //   67: monitorexit
    //   68: aload_0
    //   69: getfield 144	hev:jdField_a_of_type_Boolean	Z
    //   72: ifne -55 -> 17
    //   75: aload_0
    //   76: iconst_1
    //   77: putfield 144	hev:jdField_a_of_type_Boolean	Z
    //   80: aload_0
    //   81: invokespecial 116	hev:b	()V
    //   84: goto -67 -> 17
    //   87: astore_2
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_2
    //   91: athrow
    //   92: astore_2
    //   93: aload_3
    //   94: monitorexit
    //   95: aload_2
    //   96: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	hev
    //   0	97	1	paramInt	int
    //   0	97	2	paramString	String
    //   0	97	4	paramDownloadListener	DownloadListener
    //   0	97	5	paramBundle	android.os.Bundle
    //   6	3	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	8	87	finally
    //   20	58	87	finally
    //   68	84	87	finally
    //   95	97	87	finally
    //   58	68	92	finally
    //   93	95	92	finally
  }
  
  public void onNetMobile2None() {}
  
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
 * Qualified Name:     hev
 * JD-Core Version:    0.7.0.1
 */