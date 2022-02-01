import android.app.Activity;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class zsk
  implements tzd
{
  zsk(zsi paramzsi, String paramString) {}
  
  public void onComplete()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKAvatarSettingManager", 2, "check api, onComplete");
    }
  }
  
  public void onFailure(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKAvatarSettingManager", 2, new Object[] { "check api, onFailure, code=", Integer.valueOf(paramInt), ", msg=", paramString });
    }
    if ((zsi.a(this.this$0).isFinishing()) || (this.this$0.bqN)) {
      return;
    }
    this.this$0.hideProgressDialog();
    if (zsi.a(this.this$0) != null) {
      zsi.a(this.this$0).removeCallbacks(zsi.a(this.this$0));
    }
    this.this$0.dU(acfp.m(2131714073), this.aZY);
  }
  
  public void onPermission(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKAvatarSettingManager", 2, new Object[] { "check api, onPermission, code=", Integer.valueOf(paramInt) });
    }
    if ((zsi.a(this.this$0).isFinishing()) || (this.this$0.bqN)) {
      return;
    }
    this.this$0.hideProgressDialog();
    if (zsi.a(this.this$0) != null) {
      zsi.a(this.this$0).removeCallbacks(zsi.a(this.this$0));
    }
    this.this$0.dU(acfp.m(2131714077), this.aZY);
  }
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKAvatarSettingManager", 2, "check api, onSuccess");
    }
    if ((zsi.a(this.this$0).isFinishing()) || (this.this$0.bqN)) {
      return;
    }
    if (zsi.a(this.this$0) != null) {
      zsi.a(this.this$0).removeCallbacks(zsi.a(this.this$0));
    }
    zsi.a(this.this$0);
  }
  
  public void onTrigger(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKAvatarSettingManager", 2, "check api, onTrigger");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zsk
 * JD-Core Version:    0.7.0.1
 */