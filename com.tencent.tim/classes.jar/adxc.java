import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloadListener;
import com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloaderTask;
import com.tencent.mobileqq.data.RockDownloadInfo;
import java.util.ArrayList;
import javax.annotation.Nonnull;

public class adxc
{
  @android.support.annotation.Nullable
  public static ArrayList<RockDownloadInfo> a(@NonNull RockDownloadInfo paramRockDownloadInfo)
  {
    RockDownloaderTask localRockDownloaderTask = new RockDownloaderTask();
    localRockDownloaderTask.setDownloadInfo(paramRockDownloadInfo);
    localRockDownloaderTask.setTaskCheckLevel(1);
    localRockDownloaderTask.setRuntime(BaseApplicationImpl.getApplication().getRuntime());
    return adwx.a(localRockDownloaderTask);
  }
  
  public static void a(@Nonnull RockDownloadInfo paramRockDownloadInfo, @javax.annotation.Nullable adww paramadww)
  {
    RockDownloaderTask localRockDownloaderTask = new RockDownloaderTask();
    localRockDownloaderTask.setDownloadInfo(paramRockDownloadInfo);
    localRockDownloaderTask.setTaskCheckLevel(1);
    localRockDownloaderTask.setRuntime(BaseApplicationImpl.getApplication().getRuntime());
    localRockDownloaderTask.setQueryAPKListener(paramadww);
    adwx.b(localRockDownloaderTask);
  }
  
  public static void a(@Nonnull RockDownloadInfo paramRockDownloadInfo, @javax.annotation.Nullable RockDownloadListener paramRockDownloadListener)
  {
    if (!aqiw.isWifiEnabled(BaseApplicationImpl.context))
    {
      if (paramRockDownloadListener != null)
      {
        paramRockDownloadListener.onDownloadFail(paramRockDownloadInfo, acfp.m(2131713980), 10009);
        paramRockDownloadListener.onDownloadFinish(paramRockDownloadInfo);
      }
      return;
    }
    RockDownloaderTask localRockDownloaderTask = new RockDownloaderTask();
    localRockDownloaderTask.setDownloadInfo(paramRockDownloadInfo);
    localRockDownloaderTask.setTaskCheckLevel(1);
    localRockDownloaderTask.setRuntime(BaseApplicationImpl.getApplication().getRuntime());
    localRockDownloaderTask.setRockDownloadListener(paramRockDownloadListener);
    adwx.a(localRockDownloaderTask);
  }
  
  public static boolean b(@Nonnull RockDownloadInfo paramRockDownloadInfo)
  {
    RockDownloaderTask localRockDownloaderTask = new RockDownloaderTask();
    localRockDownloaderTask.setDownloadInfo(paramRockDownloadInfo);
    localRockDownloaderTask.setTaskCheckLevel(1);
    localRockDownloaderTask.setRuntime(BaseApplicationImpl.getApplication().getRuntime());
    return adwx.b(localRockDownloaderTask);
  }
  
  public static boolean c(@Nonnull RockDownloadInfo paramRockDownloadInfo)
  {
    RockDownloaderTask localRockDownloaderTask = new RockDownloaderTask();
    localRockDownloaderTask.setDownloadInfo(paramRockDownloadInfo);
    localRockDownloaderTask.setTaskCheckLevel(1);
    localRockDownloaderTask.setRuntime(BaseApplicationImpl.getApplication().getRuntime());
    return adwx.a(localRockDownloaderTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adxc
 * JD-Core Version:    0.7.0.1
 */