import com.tencent.hlyyb.downloader.Downloader;
import com.tencent.hlyyb.downloader.DownloaderTask;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class aiey
  implements aiew
{
  aiey(aiex paramaiex) {}
  
  public void c(DownloaderTask paramDownloaderTask)
  {
    QLog.d("DownloadManager_Now_for_qq", 1, String.format("onTaskCompleted url=%s filePath=%s", new Object[] { paramDownloaderTask.getUrl(), paramDownloaderTask.getSavePath() }));
    if (aiex.a(this.b) != null) {
      aiex.a(this.b).deleteTask(paramDownloaderTask, false);
    }
    if ((aiex.a(this.b) != null) && (aiex.a(this.b).containsKey(paramDownloaderTask.getUrl())) && (aiex.a(this.b).get(paramDownloaderTask.getUrl()) != null)) {
      ((aiev)aiex.a(this.b).get(paramDownloaderTask.getUrl())).onDownloadComplete();
    }
    aiex.a(this.b, paramDownloaderTask.getUrl());
  }
  
  public void d(DownloaderTask paramDownloaderTask)
  {
    QLog.d("DownloadManager_Now_for_qq", 1, String.format("onTaskDetected url=%s filePath=%s", new Object[] { paramDownloaderTask.getUrl(), paramDownloaderTask.getSaveDir() }));
  }
  
  public void e(DownloaderTask paramDownloaderTask)
  {
    QLog.e("DownloadManager_Now_for_qq", 1, String.format("onTaskFailed url=%s failCode=%s failInfo=%s", new Object[] { paramDownloaderTask.getUrl(), Integer.valueOf(paramDownloaderTask.getFailCode()), paramDownloaderTask.getFailInfo() }));
    if (aiex.a(this.b) != null) {
      aiex.a(this.b).deleteTask(paramDownloaderTask, false);
    }
    if ((aiex.a(this.b) != null) && (aiex.a(this.b).containsKey(paramDownloaderTask.getUrl())) && (aiex.a(this.b).get(paramDownloaderTask.getUrl()) != null)) {
      ((aiev)aiex.a(this.b).get(paramDownloaderTask.getUrl())).onDownloadFailed(paramDownloaderTask.getFailCode(), paramDownloaderTask.getFailCode(), "failed");
    }
    aiex.a(this.b, paramDownloaderTask.getUrl());
  }
  
  public void f(DownloaderTask paramDownloaderTask)
  {
    QLog.d("DownloadManager_Now_for_qq", 1, String.format("onTaskPending url=%s filePath=%s", new Object[] { paramDownloaderTask.getUrl(), paramDownloaderTask.getSaveDir() }));
  }
  
  public void g(DownloaderTask paramDownloaderTask)
  {
    QLog.d("DownloadManager_Now_for_qq", 1, String.format("onTaskStarted url=%s filePath=%s", new Object[] { paramDownloaderTask.getUrl(), paramDownloaderTask.getSaveDir() }));
  }
  
  public void h(DownloaderTask paramDownloaderTask)
  {
    QLog.d("DownloadManager_Now_for_qq", 1, String.format("onTaskReceived url=%s percent=%s", new Object[] { paramDownloaderTask.getUrl(), Integer.valueOf(paramDownloaderTask.getPercentage()) }));
    if ((aiex.a(this.b) != null) && (aiex.a(this.b).containsKey(paramDownloaderTask.getUrl())) && (aiex.a(this.b).get(paramDownloaderTask.getUrl()) != null)) {
      ((aiev)aiex.a(this.b).get(paramDownloaderTask.getUrl())).onDownloadProgress(paramDownloaderTask.getReceivedLength(), paramDownloaderTask.getTotalLength(), paramDownloaderTask.getPercentage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiey
 * JD-Core Version:    0.7.0.1
 */