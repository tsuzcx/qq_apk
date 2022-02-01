import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.hce.HcePluginInstallActivity;
import org.json.JSONObject;

public class avfl
  implements tzd
{
  public avfl(HcePluginInstallActivity paramHcePluginInstallActivity) {}
  
  public void onComplete() {}
  
  public void onFailure(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HcePluginInstallActivity", 2, "mApiCallback onFailure code:" + paramInt + "msg:" + paramString);
    }
    QQToast.a(this.this$0.getApplicationContext(), acfp.m(2131707115), 0).show();
    this.this$0.finish();
  }
  
  public void onPermission(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HcePluginInstallActivity", 2, "mApiCallback onPermission " + paramInt);
    }
    QQToast.a(this.this$0.getApplicationContext(), acfp.m(2131707117), 0).show();
    this.this$0.finish();
  }
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      HcePluginInstallActivity.a(this.this$0, paramJSONObject.optString("openid"));
    }
    HcePluginInstallActivity.b(this.this$0);
  }
  
  public void onTrigger(JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avfl
 * JD-Core Version:    0.7.0.1
 */