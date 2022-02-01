import com.tencent.hlyyb.downloader.DownloaderTask;
import com.tencent.qphone.base.util.QLog;

public class anwr
{
  public String appName = "now";
  public String appid;
  public String bNA = "now_appid_2";
  private DownloaderTask c;
  public long createTime;
  public String downloadDir;
  public String fileName;
  public String packageName;
  public String url;
  public String via = "now_for_qq";
  
  public static anwr a(String paramString1, String paramString2, String paramString3)
  {
    anwr localanwr = new anwr();
    localanwr.appid = "2";
    localanwr.downloadDir = paramString3.substring(0, paramString3.lastIndexOf("/") + 1);
    localanwr.fileName = paramString3.substring(paramString3.lastIndexOf("/") + 1);
    localanwr.url = paramString1;
    localanwr.packageName = paramString2;
    localanwr.createTime = System.currentTimeMillis();
    QLog.i("NowDownloadTaskInfo", 4, localanwr.toString());
    return localanwr;
  }
  
  public DownloaderTask b()
  {
    return this.c;
  }
  
  public void i(DownloaderTask paramDownloaderTask)
  {
    this.c = paramDownloaderTask;
  }
  
  public String toString()
  {
    return "appid = " + this.appid + ", url = " + this.url + ", downloadDir = " + this.downloadDir + ", fileName = " + this.fileName + ", taskSource = " + this.bNA + ", appName = " + this.appName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anwr
 * JD-Core Version:    0.7.0.1
 */