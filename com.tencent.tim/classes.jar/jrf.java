import com.tencent.biz.game.SensorAPIJavaScript;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

public class jrf
{
  public jrf(SensorAPIJavaScript paramSensorAPIJavaScript, String paramString) {}
  
  @QQPermissionDenied(1)
  public void denied()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 1, "CheckPermission user denied = ");
    }
    this.this$0.callJs(this.val$callback, new String[] { "false", "{result: -10, msg: 'no permission to record'}" });
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 1, "CheckPermission user grant = ");
    }
    SensorAPIJavaScript.a(this.this$0, this.val$callback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jrf
 * JD-Core Version:    0.7.0.1
 */