import android.content.Context;
import android.text.TextUtils;
import com.tencent.hlyyb.HalleyAgent;
import com.tencent.hlyyb.downloader.Downloader;
import com.tencent.hlyyb.downloader.DownloaderTask;
import com.tencent.hlyyb.downloader.DownloaderTaskCategory;
import com.tencent.hlyyb.downloader.DownloaderTaskStatus;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class aiex
{
  public static aiex a;
  private aieu a;
  private aiew jdField_b_of_type_Aiew = new aiey(this);
  private Downloader jdField_b_of_type_ComTencentHlyybDownloaderDownloader;
  Map<String, aiez> lt = new HashMap();
  private HashMap<String, aiev> mDownloadListenerMap;
  private boolean mIsInitFlag;
  private int mRetryCount;
  
  static
  {
    jdField_a_of_type_Aiex = new aiex();
  }
  
  private void Lc(String paramString)
  {
    try
    {
      QLog.d("DownloadManager_Now_for_qq", 1, String.format("removeNowDownloadTask taskUrl=%s", new Object[] { paramString }));
      this.lt.remove(paramString);
      if (this.lt.size() > 0)
      {
        paramString = this.lt.entrySet().iterator();
        while (paramString.hasNext())
        {
          aiez localaiez = (aiez)((Map.Entry)paramString.next()).getValue();
          if (localaiez != null)
          {
            QLog.d("DownloadManager_Now_for_qq", 1, String.format("removeNowDownloadTask next task url=%s", new Object[] { localaiez.url }));
            c(localaiez);
          }
        }
      }
      return;
    }
    finally {}
  }
  
  private DownloaderTask a(String paramString)
  {
    Object localObject = this.jdField_b_of_type_ComTencentHlyybDownloaderDownloader.getAllTasks();
    if ((TextUtils.isEmpty(paramString)) || (localObject == null)) {
      return null;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      DownloaderTask localDownloaderTask = (DownloaderTask)((Iterator)localObject).next();
      if (localDownloaderTask.getUrl().equals(paramString))
      {
        QLog.i("DownloadManager_Now_for_qq", 4, "isHalleyTaskAlreadyExist:YES");
        return localDownloaderTask;
      }
    }
    return null;
  }
  
  private void a(aiez paramaiez)
  {
    DownloaderTask localDownloaderTask = this.jdField_b_of_type_ComTencentHlyybDownloaderDownloader.createNewTask(paramaiez.url, paramaiez.downloadDir, paramaiez.fileName, this.jdField_a_of_type_Aieu);
    localDownloaderTask.setCategory(DownloaderTaskCategory.Cate_CustomMass1);
    localDownloaderTask.setAppScene(paramaiez.via);
    if (!TextUtils.isEmpty(paramaiez.bNA)) {
      localDownloaderTask.setApkId(paramaiez.bNA);
    }
    localDownloaderTask.setNotUseTempFile();
    paramaiez.i(localDownloaderTask);
  }
  
  private void ev(Context paramContext)
  {
    this.jdField_b_of_type_ComTencentHlyybDownloaderDownloader.setProgressInterval(1000);
    this.jdField_b_of_type_ComTencentHlyybDownloaderDownloader.setTaskNumForCategory(DownloaderTaskCategory.Cate_CustomMass1, 3);
    this.jdField_b_of_type_ComTencentHlyybDownloaderDownloader.enableUserAction(true);
    anpl.start();
  }
  
  public void a(String paramString, aiev paramaiev)
  {
    if (this.mDownloadListenerMap == null) {
      this.mDownloadListenerMap = new HashMap();
    }
    this.mDownloadListenerMap.put(paramString, paramaiev);
  }
  
  /* Error */
  public void b(aiez paramaiez)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 45
    //   4: iconst_1
    //   5: ldc 212
    //   7: iconst_2
    //   8: anewarray 4	java/lang/Object
    //   11: dup
    //   12: iconst_0
    //   13: aload_1
    //   14: getfield 102	aiez:url	Ljava/lang/String;
    //   17: aastore
    //   18: dup
    //   19: iconst_1
    //   20: aload_0
    //   21: getfield 34	aiex:lt	Ljava/util/Map;
    //   24: invokeinterface 69 1 0
    //   29: invokestatic 218	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   32: aastore
    //   33: invokestatic 53	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   36: invokestatic 59	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   39: aload_0
    //   40: getfield 34	aiex:lt	Ljava/util/Map;
    //   43: invokeinterface 69 1 0
    //   48: ifne +26 -> 74
    //   51: aload_0
    //   52: getfield 34	aiex:lt	Ljava/util/Map;
    //   55: aload_1
    //   56: getfield 102	aiez:url	Ljava/lang/String;
    //   59: aload_1
    //   60: invokeinterface 219 3 0
    //   65: pop
    //   66: aload_0
    //   67: aload_1
    //   68: invokevirtual 106	aiex:c	(Laiez;)V
    //   71: aload_0
    //   72: monitorexit
    //   73: return
    //   74: aload_0
    //   75: getfield 34	aiex:lt	Ljava/util/Map;
    //   78: aload_1
    //   79: getfield 102	aiez:url	Ljava/lang/String;
    //   82: aload_1
    //   83: invokeinterface 219 3 0
    //   88: pop
    //   89: goto -18 -> 71
    //   92: astore_1
    //   93: aload_0
    //   94: monitorexit
    //   95: aload_1
    //   96: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	aiex
    //   0	97	1	paramaiez	aiez
    // Exception table:
    //   from	to	target	type
    //   2	71	92	finally
    //   74	89	92	finally
  }
  
  public void c(aiez paramaiez)
  {
    DownloaderTask localDownloaderTask = a(paramaiez.url);
    try
    {
      str = paramaiez.url;
      if (TextUtils.isEmpty(str))
      {
        QLog.i("DownloadManager_Now_for_qq", 4, "startDownload, wurl:" + str + "wrong status or parammter");
        if ((this.mDownloadListenerMap != null) && (this.mDownloadListenerMap.containsKey(str))) {
          ((aiev)this.mDownloadListenerMap.get(str)).onDownloadFailed(-1000, -1, "url is invalid");
        }
      }
      else if ((localDownloaderTask == null) || (!str.equals(localDownloaderTask.getUrl())))
      {
        QLog.i("DownloadManager_Now_for_qq", 4, "startDownload: url is changed, thread = " + Thread.currentThread().getId() + "," + str + "path = " + paramaiez.fileName);
        if (localDownloaderTask != null) {}
        a(paramaiez);
        this.jdField_b_of_type_ComTencentHlyybDownloaderDownloader.addNewTask(paramaiez.b());
        QLog.i("DownloadManager_Now_for_qq", 4, "mHellyDownloader.addNewTask");
        return;
      }
    }
    catch (Exception localException)
    {
      String str;
      QLog.i("DownloadManager_Now_for_qq", 4, "startDownload---exception happend:", localException);
      if (this.mRetryCount < 3)
      {
        this.mRetryCount += 1;
        c(paramaiez);
        return;
        paramaiez.i(localException);
        DownloaderTaskStatus localDownloaderTaskStatus = localException.getStatus();
        QLog.i("DownloadManager_Now_for_qq", 4, "startDownload----hstatus:" + localDownloaderTaskStatus);
        if (localDownloaderTaskStatus == DownloaderTaskStatus.COMPLETE)
        {
          if ((this.mDownloadListenerMap != null) && (this.mDownloadListenerMap.containsKey(str))) {
            ((aiev)this.mDownloadListenerMap.get(str)).onDownloadComplete();
          }
          co(localException.getUrl(), false);
          return;
        }
        if (localDownloaderTaskStatus == DownloaderTaskStatus.DOWNLOADING)
        {
          QLog.i("DownloadManager_Now_for_qq", 4, "startDownload----Task is already Downloading!");
          return;
        }
        QLog.i("DownloadManager_Now_for_qq", 4, "startDownload----resume halley task");
        localException.resume();
      }
    }
  }
  
  public void co(String paramString, boolean paramBoolean)
  {
    Object localObject = this.jdField_b_of_type_ComTencentHlyybDownloaderDownloader.getAllTasks();
    if ((TextUtils.isEmpty(paramString)) || (localObject == null)) {}
    DownloaderTask localDownloaderTask;
    do
    {
      return;
      while (!((Iterator)localObject).hasNext()) {
        localObject = ((List)localObject).iterator();
      }
      localDownloaderTask = (DownloaderTask)((Iterator)localObject).next();
    } while (!localDownloaderTask.getUrl().equals(paramString));
    asbt.i("DownloadManager_Now_for_qq", "removeDownloadTask---delete unactive halley task, Id:" + localDownloaderTask.getId());
    this.jdField_b_of_type_ComTencentHlyybDownloaderDownloader.deleteTask(localDownloaderTask, paramBoolean);
  }
  
  public void init(Context paramContext)
  {
    if (this.mIsInitFlag) {
      return;
    }
    this.mIsInitFlag = true;
    this.mRetryCount = 0;
    this.mDownloadListenerMap = new HashMap();
    HalleyAgent.init(paramContext, "1", "now_for_qq");
    this.jdField_b_of_type_ComTencentHlyybDownloaderDownloader = HalleyAgent.getDownloader();
    ev(paramContext);
    this.jdField_a_of_type_Aieu = new aieu(this.jdField_b_of_type_Aiew);
  }
  
  public void removeDownloadListener(String paramString)
  {
    if (this.mDownloadListenerMap != null) {
      this.mDownloadListenerMap.remove(paramString);
    }
  }
  
  public void unInit()
  {
    if (this.jdField_a_of_type_Aieu != null)
    {
      this.jdField_a_of_type_Aieu.unInit();
      this.jdField_a_of_type_Aieu = null;
    }
    if (this.mDownloadListenerMap != null)
    {
      this.mDownloadListenerMap.clear();
      this.mDownloadListenerMap = null;
    }
    this.jdField_b_of_type_ComTencentHlyybDownloaderDownloader = null;
    this.mIsInitFlag = false;
    this.mRetryCount = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiex
 * JD-Core Version:    0.7.0.1
 */