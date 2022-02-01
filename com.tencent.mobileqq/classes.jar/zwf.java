import com.tencent.biz.richframework.download.RFWDownloader.2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Set;

public class zwf
  implements bdvw
{
  public zwf(RFWDownloader.2 param2) {}
  
  public void onResp(bdwt parambdwt)
  {
    zwe.a(this.a.this$0).remove(this.a.a);
    QLog.i("RFWDownloader", 1, "download  onResp url:  resultcode: " + parambdwt.c);
    QLog.i("RFWDownloader", 1, "downloadFinish downloadSavePath" + this.a.b);
    if (zwe.a(this.a.this$0, this.a.a)) {
      try
      {
        parambdwt = this.a.this$0.b(this.a.a);
        File localFile = new File(this.a.b);
        QLog.d("RFWDownloader", 4, "start unzip file to folderPath:" + parambdwt);
        nmk.a(localFile, parambdwt);
        bgmg.a(localFile);
        QLog.i("RFWDownloader", 1, "unzip success");
        zwe.a(this.a.this$0, this.a.a, this.a.c);
        zwe.a(this.a.this$0, this.a.a, true, parambdwt);
        return;
      }
      catch (Exception parambdwt)
      {
        zwe.a(this.a.this$0, this.a.a, false, "");
        QLog.i("DownLoadZipFile", 1, "unzip file failed" + parambdwt);
        return;
      }
    }
    QLog.i("RFWDownloader", 1, "is not zip file, not need upzip");
    zwe.a(this.a.this$0, this.a.a, this.a.c);
    zwe.a(this.a.this$0, this.a.a, true, this.a.b);
  }
  
  public void onUpdateProgeress(bdws parambdws, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zwf
 * JD-Core Version:    0.7.0.1
 */