import com.tencent.biz.qqcircle.download.QCircleResourceDownloadManager.2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Set;

public class twf
  implements baug
{
  public twf(QCircleResourceDownloadManager.2 param2) {}
  
  public void onResp(bavf parambavf)
  {
    twe.a(this.a.this$0).remove(this.a.a);
    QLog.i(twe.a, 1, "download  onResp url:  resultcode: " + parambavf.c);
    QLog.i(twe.a, 1, "downloadFinish downloadSavePath" + this.a.b);
    if (twe.a(this.a.this$0, this.a.a)) {
      try
      {
        parambavf = this.a.this$0.a(this.a.a);
        File localFile = new File(this.a.b);
        QLog.d(twe.a, 4, "start unzip file to folderPath:" + parambavf);
        ndr.a(localFile, parambavf);
        bdhb.a(localFile);
        QLog.i(twe.a, 1, "unzip success");
        twe.a(this.a.this$0, this.a.a, this.a.c);
        twe.a(this.a.this$0, this.a.a, true, parambavf);
        return;
      }
      catch (Exception parambavf)
      {
        twe.a(this.a.this$0, this.a.a, false, "");
        QLog.i("DownLoadZipFile", 1, "unzip file failed" + parambavf);
        return;
      }
    }
    QLog.i(twe.a, 1, "is not zip file, not need upzip");
    twe.a(this.a.this$0, this.a.a, this.a.c);
    twe.a(this.a.this$0, this.a.a, true, this.a.b);
  }
  
  public void onUpdateProgeress(bave parambave, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     twf
 * JD-Core Version:    0.7.0.1
 */