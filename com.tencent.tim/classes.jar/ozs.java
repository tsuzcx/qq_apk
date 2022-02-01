import com.tencent.biz.qqcircle.download.QCircleResourceDownloadManager.3;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;

public class ozs
  implements ozn
{
  public ozs(QCircleResourceDownloadManager.3 param3) {}
  
  public void b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    if ((!paramBoolean2) || (paramBoolean3))
    {
      if (ozq.a(this.a.this$0).contains(this.a.val$downloadUrl))
      {
        QLog.i(ozq.TAG, 1, "getFile ..., file is downloading");
        return;
      }
      QLog.i(ozq.TAG, 1, "getFile ..., start download");
      ozq.b(this.a.this$0, this.a.val$downloadUrl, paramString);
      return;
    }
    paramString = this.a.this$0.aY(this.a.val$downloadUrl);
    QLog.i(ozq.TAG, 1, "getFile success, the file is exist path:" + paramString);
    ozq.a(this.a.this$0, this.a.val$downloadUrl, true, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ozs
 * JD-Core Version:    0.7.0.1
 */