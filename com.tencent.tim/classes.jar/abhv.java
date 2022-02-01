import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.ApolloQueueDownloader.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;

public class abhv
  implements aqvc, INetInfoHandler
{
  private aqva.a a;
  private LinkedList<aquz> i = new LinkedList();
  public AtomicInteger y = new AtomicInteger(1);
  
  public abhv(AppRuntime paramAppRuntime, aqva.a parama)
  {
    aqva.a locala = parama;
    if (parama == null) {
      locala = new aqva.a();
    }
    this.a = locala;
    if (this.a.eX) {
      AppNetConnInfo.registerConnectionChangeReceiver(paramAppRuntime.getApplication(), this);
    }
  }
  
  private aquz a()
  {
    synchronized (this.i)
    {
      if (!this.i.isEmpty())
      {
        Iterator localIterator = this.i.iterator();
        while (localIterator.hasNext())
        {
          aquz localaquz = (aquz)localIterator.next();
          if (!localaquz.isLoading())
          {
            localaquz.efO();
            return localaquz;
          }
        }
      }
      return null;
    }
  }
  
  public int a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloQueue_Downloader", 2, "cancelTask stopAll=" + paramBoolean + ",key=" + paramString);
    }
    Object localObject;
    synchronized (this.i)
    {
      if (this.i.isEmpty()) {
        break label115;
      }
      if (!paramBoolean) {
        break label119;
      }
      paramString = this.i.iterator();
      if (paramString.hasNext())
      {
        localObject = (aquz)paramString.next();
        ((aquz)localObject).cancel(true);
        ((aquz)localObject).bme();
      }
    }
    this.i.clear();
    for (;;)
    {
      label115:
      return 0;
      label119:
      if ((paramString == null) || (TextUtils.isEmpty(paramString))) {
        break;
      }
      localObject = this.i.iterator();
      ArrayList localArrayList = new ArrayList();
      while (((Iterator)localObject).hasNext())
      {
        aquz localaquz = (aquz)((Iterator)localObject).next();
        if (paramString.equals(localaquz.key))
        {
          if (!localaquz.isLoading())
          {
            ((Iterator)localObject).remove();
            localArrayList.add(localaquz);
          }
          else
          {
            localaquz.cancel(true);
            localaquz.bme();
          }
        }
        else if ((localaquz.isCancel()) && (!localaquz.isLoading()))
        {
          ((Iterator)localObject).remove();
          localArrayList.add(localaquz);
        }
      }
      if (localArrayList.size() > 0) {
        this.i.removeAll(localArrayList);
      }
    }
    return -1;
  }
  
  public aquz a(String paramString)
  {
    LinkedList localLinkedList = this.i;
    if (paramString != null) {}
    try
    {
      if (!this.i.isEmpty())
      {
        Iterator localIterator = this.i.iterator();
        while (localIterator.hasNext())
        {
          aquz localaquz = (aquz)localIterator.next();
          if (paramString.equals(localaquz.key))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloQueue_Downloader", 2, "getTask | " + paramString + " task find =" + localaquz);
            }
            return localaquz;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloQueue_Downloader", 2, "getTask | " + paramString + " task not find");
      }
      return null;
    }
    finally {}
  }
  
  public void a(aquz paramaquz)
  {
    LinkedList localLinkedList = this.i;
    if (paramaquz != null) {}
    try
    {
      if ((!this.i.isEmpty()) && (this.i.contains(paramaquz)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloQueue_Downloader", 2, "removeTask | task=" + paramaquz);
        }
        paramaquz.bme();
        this.i.remove(paramaquz);
      }
      return;
    }
    finally {}
  }
  
  public void a(aquz paramaquz, aquy arg2, Bundle paramBundle)
  {
    if ((!aqva.a(paramaquz)) || (a(paramaquz.key) == paramaquz)) {}
    aquz localaquz;
    do
    {
      return;
      localaquz = a(paramaquz.key);
      if (localaquz == null) {
        break;
      }
    } while ((localaquz == null) || (!localaquz.cWB));
    paramaquz.c(???);
    paramaquz.dy(paramBundle);
    ??? = BaseApplicationImpl.getApplication().getRuntime();
    if ((??? != null) && (paramaquz.a.iUin < 0L)) {
      paramaquz.a.iUin = ???.getLongAccountUin();
    }
    localaquz.h(paramaquz);
    return;
    paramaquz.c(???);
    paramaquz.dy(paramBundle);
    paramaquz.bju = 3;
    ??? = BaseApplicationImpl.getApplication().getRuntime();
    if ((??? != null) && (paramaquz.a.iUin < 0L)) {
      paramaquz.a.iUin = ???.getLongAccountUin();
    }
    for (;;)
    {
      synchronized (this.i)
      {
        paramBundle = a(paramaquz.key);
        if (paramBundle == null)
        {
          paramaquz.atV = ((int)(System.currentTimeMillis() / 1000L));
          if (paramaquz.cWl)
          {
            this.i.addFirst(paramaquz);
            if ((paramaquz.GP != null) && (paramaquz.GP.size() != 0)) {
              break label326;
            }
            ??? = null;
            if (QLog.isColorLevel()) {
              QLog.d("ApolloQueue_Downloader", 2, new Object[] { "startDownload | task=" + paramaquz.key, ", url:", ??? });
            }
            doTask();
            return;
          }
          this.i.addLast(paramaquz);
        }
      }
      if ((paramaquz.cWl) && (!paramBundle.isLoading()) && (this.i.remove(paramBundle)))
      {
        this.i.addFirst(paramBundle);
        continue;
        label326:
        ??? = (String)paramaquz.GP.get(0);
      }
    }
  }
  
  public void doTask()
  {
    for (;;)
    {
      try
      {
        synchronized (this.i)
        {
          Iterator localIterator = this.i.iterator();
          if (!localIterator.hasNext()) {
            break label188;
          }
          aquz localaquz2 = (aquz)localIterator.next();
          if (localaquz2.atW <= 0L) {
            break label323;
          }
          long l = System.currentTimeMillis() / 1000L;
          if ((!localaquz2.isLoading()) && (l > localaquz2.atV + localaquz2.atW))
          {
            bool = true;
            if ((!localaquz2.isCancel()) && (!bool)) {
              continue;
            }
            localIterator.remove();
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("ApolloQueue_Downloader", 2, "remove task[" + localaquz2.key + "], isCancal=" + localaquz2.isCancel() + ", timeOut=" + bool);
          }
        }
        bool = false;
      }
      finally {}
      continue;
      label188:
      if (QLog.isColorLevel()) {
        QLog.d("ApolloQueue_Downloader", 2, "doTask | downloadLimitCount=" + this.y.get() + ",maxDownloadCount=" + 3 + ",downloadQueue size=" + this.i.size());
      }
      for (;;)
      {
        aquz localaquz1;
        if (this.y.get() <= 3)
        {
          localaquz1 = a();
          if (localaquz1 != null) {
            break label295;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ApolloQueue_Downloader", 2, "doTask | run() null");
          }
        }
        return;
        label295:
        ThreadManager.postDownLoadTask(new ApolloQueueDownloader.1(this, localaquz1), 2, null, false);
        this.y.addAndGet(1);
      }
      label323:
      boolean bool = false;
    }
  }
  
  public void onDestroy()
  {
    a(true, null);
  }
  
  public void onNetMobile2None()
  {
    if ((this.i != null) && (this.i.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloQueue_Downloader", 2, "queueDownload network-onNetMobile2None");
      }
      synchronized (this.i)
      {
        Iterator localIterator = this.i.iterator();
        while (localIterator.hasNext())
        {
          aquz localaquz = (aquz)localIterator.next();
          if (localaquz.getStatus() == 2) {
            localaquz.onNetMobile2None();
          }
        }
      }
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloQueue_Downloader", 2, "queueDownload network-onNetMobile2Wifi");
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloQueue_Downloader", 2, "queueDownload network-onNetNone2Mobile");
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloQueue_Downloader", 2, "queueDownload network-onNetNone2Wifi");
    }
  }
  
  public void onNetWifi2Mobile(String arg1)
  {
    if ((this.i != null) && (this.i.size() > 0)) {
      synchronized (this.i)
      {
        Iterator localIterator = this.i.iterator();
        while (localIterator.hasNext())
        {
          aquz localaquz = (aquz)localIterator.next();
          if (localaquz.getStatus() == 2) {
            localaquz.onNetWifi2Mobile();
          }
        }
      }
    }
  }
  
  public void onNetWifi2None()
  {
    if ((this.i != null) && (this.i.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloQueue_Downloader", 2, "queueDownload network-onNetWifi2None");
      }
      synchronized (this.i)
      {
        Iterator localIterator = this.i.iterator();
        while (localIterator.hasNext())
        {
          aquz localaquz = (aquz)localIterator.next();
          if (localaquz.getStatus() == 2) {
            localaquz.onNetWifi2None();
          }
        }
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((this.i != null) && (this.i.size() > 0)) {
      synchronized (this.i)
      {
        Iterator localIterator = this.i.iterator();
        if (localIterator.hasNext())
        {
          aquz localaquz = (aquz)localIterator.next();
          localStringBuilder.append("key=").append(localaquz.key);
          if ((localaquz.GP != null) && (localaquz.GP.size() > 0)) {
            localStringBuilder.append(",size=").append(localaquz.GP.size()).append(",url=").append((String)localaquz.GP.get(0));
          }
          localStringBuilder.append(";");
        }
      }
    }
    return "QueueDownloader task url:" + localObject.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abhv
 * JD-Core Version:    0.7.0.1
 */