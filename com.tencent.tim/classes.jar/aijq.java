import com.tencent.mobileqq.jsp.MediaApiPlugin;
import com.tencent.qphone.base.util.QLog;
import mqq.app.BaseActivity;
import mqq.app.QQPermissionCallback;
import org.json.JSONObject;

public class aijq
  implements QQPermissionCallback
{
  public aijq(MediaApiPlugin paramMediaApiPlugin, JSONObject paramJSONObject, boolean paramBoolean, BaseActivity paramBaseActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.d(MediaApiPlugin.TAG, 1, "User requestPermissions WRITE_EXTERNAL_STORAGE denied");
    aqha.a(this.d, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.this$0.c(this.bD, this.cku);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aijq
 * JD-Core Version:    0.7.0.1
 */