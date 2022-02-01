import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class agkw
{
  private static List<aglf> Bd = new ArrayList();
  
  static
  {
    
    if (!allf.isSDKReady()) {
      allf.a(BaseApplicationImpl.getApplication(), new agkx());
    }
  }
  
  private static void IL(String paramString)
  {
    aglf localaglf = a(paramString);
    if (localaglf != null)
    {
      QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("####   %s pause!", new Object[] { paramString }));
      localaglf.stop();
    }
    for (;;)
    {
      IO(paramString);
      return;
      QLog.w("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("####   %s pause failed, not find!", new Object[] { paramString }));
    }
  }
  
  public static void IM(String paramString)
  {
    IL(paramString);
    IO(paramString);
  }
  
  public static void IN(String paramString)
  {
    aglf localaglf = a(paramString);
    if (localaglf == null)
    {
      QLog.w("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("%s not in downloadList", new Object[] { paramString }));
      return;
    }
    localaglf.dhB();
  }
  
  public static void IO(String paramString)
  {
    aglf localaglf = a(paramString);
    if (localaglf == null)
    {
      QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, "cann't find downloader with:" + paramString);
      return;
    }
    localaglf.stop();
    synchronized (Bd)
    {
      Bd.remove(localaglf);
      QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("####  remove downloader:%s, mapsize:%d", new Object[] { paramString, Integer.valueOf(Bd.size()) }));
      return;
    }
  }
  
  public static aglf a(agsw arg0)
  {
    String str1 = ???.ve();
    QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, "try create downloader:" + str1);
    Object localObject2 = a(str1);
    if (localObject2 != null)
    {
      a(???);
      synchronized (Bd)
      {
        Bd.add(0, localObject2);
        QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("find downloader %s and set to head", new Object[] { str1 }));
        return localObject2;
      }
    }
    localObject2 = new agky(???);
    synchronized (Bd)
    {
      QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, "new downloader:" + str2);
      Bd.add(0, localObject2);
      return localObject2;
    }
  }
  
  private static aglf a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    for (;;)
    {
      synchronized (Bd)
      {
        Iterator localIterator = Bd.iterator();
        if (localIterator.hasNext())
        {
          aglf localaglf = (aglf)localIterator.next();
          if (!paramString.equalsIgnoreCase(localaglf.ve())) {
            continue;
          }
          paramString = localaglf;
          return paramString;
        }
      }
      paramString = null;
    }
  }
  
  public static void a(agsw paramagsw)
  {
    IO(paramagsw.ve());
  }
  
  public static void ci(String paramString, boolean paramBoolean)
  {
    paramString = a(paramString);
    if (paramString == null) {
      return;
    }
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramString.setPlaying(paramBoolean);
      return;
    }
  }
  
  public static void dhz()
  {
    if (Bd.size() == 0)
    {
      QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, "download queue is empty");
      return;
    }
    ??? = Bd.iterator();
    aglf localaglf;
    while (((Iterator)???).hasNext())
    {
      localaglf = (aglf)((Iterator)???).next();
      if (localaglf.isDownloading())
      {
        QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("%s downloading", new Object[] { localaglf.ve() }));
        return;
      }
    }
    synchronized (Bd)
    {
      localaglf = (aglf)Bd.get(0);
      if (localaglf == null)
      {
        QLog.w("FileVideoDownloadManager<FileAssistant>XOXO", 1, "next queue has elment, why get head is null?");
        return;
      }
    }
    localObject2.ZE();
    QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("start %s to download", new Object[] { localObject2.ve() }));
  }
  
  public static void fM(String paramString)
  {
    aglf localaglf1 = a(paramString);
    if (localaglf1 == null)
    {
      QLog.w("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("%s not in downloadList", new Object[] { paramString }));
      return;
    }
    synchronized (Bd)
    {
      Iterator localIterator = Bd.iterator();
      while (localIterator.hasNext())
      {
        aglf localaglf2 = (aglf)localIterator.next();
        if (localaglf2 != localaglf1) {
          localaglf2.stop();
        }
      }
    }
    Bd.remove(localaglf1);
    Bd.add(0, localaglf1);
    QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("downloa %s set to head and stop other succ!", new Object[] { paramString }));
    localaglf1.ZE();
  }
  
  public static void releaseAll()
  {
    ??? = Bd.iterator();
    while (((Iterator)???).hasNext()) {
      ((aglf)((Iterator)???).next()).stop();
    }
    synchronized (Bd)
    {
      Bd.clear();
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void dhA();
    
    public abstract void fH(String paramString1, String paramString2);
    
    public abstract void onError(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agkw
 * JD-Core Version:    0.7.0.1
 */