import com.tencent.mobileqq.activity.bless.BlessTask;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class yln
  extends aquy
{
  yln(ylm paramylm, String paramString1, String paramString2) {}
  
  public void onCancel(aquz paramaquz)
  {
    ylm.a(this.this$0).remove(this.aYI);
  }
  
  public void onDone(aquz paramaquz)
  {
    ylm.a(this.this$0).remove(this.aYI);
    if (paramaquz.getStatus() == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BlessManager", 2, "download finished " + this.val$url);
      }
      if ((this.val$url != null) && (ylm.a(this.this$0) != null) && (this.val$url.equals(ylm.a(this.this$0).starVideo))) {
        ylm.b(this.this$0);
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      ylm.a(this.this$0);
      return;
    }
    QLog.d("BlessManager", 2, "downloadFile failed: " + paramaquz.errMsg + " code=" + paramaquz.errCode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yln
 * JD-Core Version:    0.7.0.1
 */