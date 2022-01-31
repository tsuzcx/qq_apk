import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

class xkj
{
  xkj(xki paramxki, String paramString) {}
  
  @QQPermissionDenied(1)
  public void denied()
  {
    this.jdField_a_of_type_Xki.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "-3", "{}" });
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    akuf.a(new xkk(this, "webview"));
    if (QLog.isColorLevel()) {
      QLog.d("LocationPlugin", 2, "SosoInterface.startLocation");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xkj
 * JD-Core Version:    0.7.0.1
 */