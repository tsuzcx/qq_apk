import com.tencent.biz.qqcircle.download.QCircleResourceDownloadManager.2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Set;

public class ozr
  implements aolm.b
{
  public ozr(QCircleResourceDownloadManager.2 param2) {}
  
  public void onResp(aomh paramaomh)
  {
    ozq.a(this.a.this$0).remove(this.a.val$downloadUrl);
    QLog.i(ozq.TAG, 1, "download  onResp url:  resultcode: " + paramaomh.dPy);
    QLog.i(ozq.TAG, 1, "downloadFinish downloadSavePath" + this.a.arM);
    if (ozq.a(this.a.this$0, this.a.val$downloadUrl)) {
      try
      {
        paramaomh = this.a.this$0.aY(this.a.val$downloadUrl);
        File localFile = new File(this.a.arM);
        QLog.d(ozq.TAG, 4, "start unzip file to folderPath:" + paramaomh);
        jqp.b(localFile, paramaomh);
        aqhq.deleteFile(localFile);
        QLog.i(ozq.TAG, 1, "unzip success");
        ozq.a(this.a.this$0, this.a.val$downloadUrl, this.a.ajt);
        ozq.a(this.a.this$0, this.a.val$downloadUrl, true, paramaomh);
        return;
      }
      catch (Exception paramaomh)
      {
        ozq.a(this.a.this$0, this.a.val$downloadUrl, false, "");
        QLog.i("DownLoadZipFile", 1, "unzip file failed" + paramaomh);
        return;
      }
    }
    QLog.i(ozq.TAG, 1, "is not zip file, not need upzip");
    ozq.a(this.a.this$0, this.a.val$downloadUrl, this.a.ajt);
    ozq.a(this.a.this$0, this.a.val$downloadUrl, true, this.a.arM);
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ozr
 * JD-Core Version:    0.7.0.1
 */