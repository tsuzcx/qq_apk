import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface;
import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface.c;
import com.tencent.mobileqq.app.soso.SosoInterface;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

public class kam
{
  public kam(PublicAccountJavascriptInterface paramPublicAccountJavascriptInterface, boolean paramBoolean1, int paramInt, boolean paramBoolean2, String paramString, long paramLong) {}
  
  @QQPermissionDenied(1)
  public void denied()
  {
    this.this$0.callJs(this.VA, new String[] { "-3", "{}" });
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    SosoInterface.a(new PublicAccountJavascriptInterface.c(this.this$0, 0, this.adl, this.aGP, this.adm, this.VA, this.ri));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kam
 * JD-Core Version:    0.7.0.1
 */