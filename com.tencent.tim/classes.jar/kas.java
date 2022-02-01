import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface;
import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface.c;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

public class kas
{
  public kas(PublicAccountJavascriptInterface paramPublicAccountJavascriptInterface, String paramString, long paramLong) {}
  
  @QQPermissionDenied(1)
  public void denied()
  {
    this.this$0.callJs(this.VA, new String[] { "-3", "{}" });
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    SosoInterface.a(new PublicAccountJavascriptInterface.c(this.this$0, 0, this.VA, this.ri));
    if (QLog.isColorLevel()) {
      QLog.d("PAjs.location", 2, "SosoInterface.startLocation");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kas
 * JD-Core Version:    0.7.0.1
 */