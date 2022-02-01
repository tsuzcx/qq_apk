import com.tencent.biz.richframework.download.RFWDownloader.3;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;

public class zwg
  implements zwa
{
  public zwg(RFWDownloader.3 param3) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    if ((!paramBoolean2) || (paramBoolean3))
    {
      if (zwe.a(this.a.this$0).contains(this.a.a))
      {
        QLog.i("RFWDownloader", 1, "getFile ..., file is downloading");
        return;
      }
      QLog.i("RFWDownloader", 1, "getFile ..., start download");
      zwe.b(this.a.this$0, this.a.a, paramString);
      return;
    }
    paramString = this.a.this$0.b(this.a.a);
    QLog.i("RFWDownloader", 1, "getFile success, the file is exist path:" + paramString);
    zwe.a(this.a.this$0, this.a.a, true, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zwg
 * JD-Core Version:    0.7.0.1
 */