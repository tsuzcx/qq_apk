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

public class anwp
{
  public static anwp a;
  private anwm a;
  private anwo jdField_b_of_type_Anwo = new anwq(this);
  private Downloader jdField_b_of_type_ComTencentHlyybDownloaderDownloader;
  Map<String, anwr> lt = new HashMap();
  private HashMap<String, anwn> mDownloadListenerMap;
  private boolean mIsInitFlag;
  private int mRetryCount;
  
  static
  {
    jdField_a_of_type_Anwp = new anwp();
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
          anwr localanwr = (anwr)((Map.Entry)paramString.next()).getValue();
          if (localanwr != null)
          {
            QLog.d("DownloadManager_Now_for_qq", 1, String.format("removeNowDownloadTask next task url=%s", new Object[] { localanwr.url }));
            b(localanwr);
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
  
  private void a(anwr paramanwr)
  {
    DownloaderTask localDownloaderTask = this.jdField_b_of_type_ComTencentHlyybDownloaderDownloader.createNewTask(paramanwr.url, paramanwr.downloadDir, paramanwr.fileName, this.jdField_a_of_type_Anwm);
    localDownloaderTask.setCategory(DownloaderTaskCategory.Cate_CustomMass1);
    localDownloaderTask.setAppScene(paramanwr.via);
    if (!TextUtils.isEmpty(paramanwr.bNA)) {
      localDownloaderTask.setApkId(paramanwr.bNA);
    }
    localDownloaderTask.setNotUseTempFile();
    paramanwr.i(localDownloaderTask);
  }
  
  private void ev(Context paramContext)
  {
    this.jdField_b_of_type_ComTencentHlyybDownloaderDownloader.setProgressInterval(1000);
    this.jdField_b_of_type_ComTencentHlyybDownloaderDownloader.setTaskNumForCategory(DownloaderTaskCategory.Cate_CustomMass1, 3);
    this.jdField_b_of_type_ComTencentHlyybDownloaderDownloader.enableUserAction(true);
    anpl.start();
  }
  
  public void a(String paramString, anwn paramanwn)
  {
    if (this.mDownloadListenerMap == null) {
      this.mDownloadListenerMap = new HashMap();
    }
    this.mDownloadListenerMap.put(paramString, paramanwn);
  }
  
  public void b(anwr paramanwr)
  {
    if (this.jdField_b_of_type_ComTencentHlyybDownloaderDownloader == null) {}
    String str;
    do
    {
      for (;;)
      {
        return;
        DownloaderTask localDownloaderTask = a(paramanwr.url);
        try
        {
          str = paramanwr.url;
          if (!TextUtils.isEmpty(str)) {
            break label134;
          }
          QLog.i("DownloadManager_Now_for_qq", 4, "startDownload, wurl:" + str + "wrong status or parammter");
          if ((this.mDownloadListenerMap != null) && (this.mDownloadListenerMap.containsKey(str)))
          {
            ((anwn)this.mDownloadListenerMap.get(str)).onDownloadFailed(-1000, -1, "url is invalid");
            return;
          }
        }
        catch (Exception localException)
        {
          QLog.i("DownloadManager_Now_for_qq", 4, "startDownload---exception happend:", localException);
        }
      }
    } while (this.mRetryCount >= 3);
    this.mRetryCount += 1;
    b(paramanwr);
    return;
    label134:
    if ((localException == null) || (!str.equals(localException.getUrl())))
    {
      QLog.i("DownloadManager_Now_for_qq", 4, "startDownload: url is changed, thread = " + Thread.currentThread().getId() + "," + str + "path = " + paramanwr.fileName);
      if (localException != null) {}
      a(paramanwr);
      this.jdField_b_of_type_ComTencentHlyybDownloaderDownloader.addNewTask(paramanwr.b());
      QLog.i("DownloadManager_Now_for_qq", 4, "mHellyDownloader.addNewTask");
      return;
    }
    paramanwr.i(localException);
    DownloaderTaskStatus localDownloaderTaskStatus = localException.getStatus();
    QLog.i("DownloadManager_Now_for_qq", 4, "startDownload----hstatus:" + localDownloaderTaskStatus);
    if (localDownloaderTaskStatus == DownloaderTaskStatus.COMPLETE)
    {
      if ((this.mDownloadListenerMap != null) && (this.mDownloadListenerMap.containsKey(str))) {
        ((anwn)this.mDownloadListenerMap.get(str)).onDownloadComplete();
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
    this.jdField_a_of_type_Anwm = new anwm(this.jdField_b_of_type_Anwo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anwp
 * JD-Core Version:    0.7.0.1
 */