import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

class stf
{
  stf(ste paramste, String paramString) {}
  
  @QQPermissionDenied(1)
  public void denied()
  {
    this.a.callJs(this.VA, new String[] { "-3", "{}" });
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    aczc.a(new stg(this, "webview"));
    if (QLog.isColorLevel()) {
      QLog.d("LocationPlugin", 2, "SosoInterface.startLocation");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     stf
 * JD-Core Version:    0.7.0.1
 */