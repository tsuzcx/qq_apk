import com.tencent.biz.qqcircle.download.QCircleResourceDownloadManager.3;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;

public class twg
  implements tvy
{
  public twg(QCircleResourceDownloadManager.3 param3) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    if ((!paramBoolean2) || (paramBoolean3))
    {
      if (twe.a(this.a.this$0).contains(this.a.a))
      {
        QLog.i(twe.a, 1, "getFile ..., file is downloading");
        return;
      }
      QLog.i(twe.a, 1, "getFile ..., start download");
      twe.b(this.a.this$0, this.a.a, paramString);
      return;
    }
    paramString = this.a.this$0.a(this.a.a);
    QLog.i(twe.a, 1, "getFile success, the file is exist path:" + paramString);
    twe.a(this.a.this$0, this.a.a, true, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     twg
 * JD-Core Version:    0.7.0.1
 */