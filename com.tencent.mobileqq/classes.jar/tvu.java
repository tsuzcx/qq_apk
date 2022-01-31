import com.tencent.biz.qqcircle.download.QCircleResourceDownloadManager.1;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Set;

public class tvu
  implements bapx
{
  public tvu(QCircleResourceDownloadManager.1 param1) {}
  
  public void onResp(baqw parambaqw)
  {
    tvt.a(this.a.this$0).remove(this.a.a);
    QLog.i(tvt.a, 1, "download  onResp url:  resultcode: " + parambaqw.c);
    QLog.i(tvt.a, 1, "downloadFinish downloadSavePath" + this.a.b);
    if (tvt.a(this.a.this$0, this.a.a)) {
      try
      {
        parambaqw = this.a.this$0.a(this.a.a);
        File localFile = new File(this.a.b);
        QLog.d(tvt.a, 4, "start unzip file to folderPath:" + parambaqw);
        ndr.a(localFile, parambaqw);
        bdcs.a(localFile);
        QLog.i(tvt.a, 1, "unzip success");
        tvt.a(this.a.this$0, this.a.a, this.a.c);
        tvt.a(this.a.this$0, this.a.a, true, parambaqw);
        return;
      }
      catch (Exception parambaqw)
      {
        tvt.a(this.a.this$0, this.a.a, false, "");
        QLog.i("DownLoadZipFile", 1, "unzip file failed" + parambaqw);
        return;
      }
    }
    QLog.i(tvt.a, 1, "is not zip file, not need upzip");
    tvt.a(this.a.this$0, this.a.a, this.a.c);
    tvt.a(this.a.this$0, this.a.a, true, this.a.b);
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tvu
 * JD-Core Version:    0.7.0.1
 */