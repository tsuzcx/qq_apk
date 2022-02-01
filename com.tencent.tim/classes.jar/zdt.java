import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONObject;

class zdt
  implements tzd
{
  zdt(zdf paramzdf, String paramString) {}
  
  public void onComplete()
  {
    QLog.d("SDKEmotionSettingManager", 1, "check api, onComplete");
  }
  
  public void onFailure(int paramInt, String paramString)
  {
    QLog.d("SDKEmotionSettingManager", 1, new Object[] { "check api, onFailure, code=", Integer.valueOf(paramInt), ", msg=", paramString });
    if ((zdf.a(this.this$0).isFinishing()) || (this.this$0.bqN))
    {
      QLog.d("SDKEmotionSettingManager", 1, "check api, acitivty finish or timeout");
      return;
    }
    this.this$0.hideProgressDialog();
    if (zdf.a(this.this$0) != null) {
      zdf.a(this.this$0).removeCallbacks(zdf.a(this.this$0));
    }
    this.this$0.dU(acfp.m(2131714085), this.aZY);
  }
  
  public void onPermission(int paramInt)
  {
    QLog.d("SDKEmotionSettingManager", 1, new Object[] { "check api, onPermission, code=", Integer.valueOf(paramInt) });
    if ((zdf.a(this.this$0).isFinishing()) || (this.this$0.bqN)) {
      return;
    }
    this.this$0.hideProgressDialog();
    if (zdf.a(this.this$0) != null) {
      zdf.a(this.this$0).removeCallbacks(zdf.a(this.this$0));
    }
    this.this$0.dU(acfp.m(2131714086), this.aZY);
  }
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    QLog.d("SDKEmotionSettingManager", 1, "check api, onSuccess");
    if ((zdf.a(this.this$0).isFinishing()) || (this.this$0.bqN)) {
      return;
    }
    if (zdf.a(this.this$0) != null) {
      zdf.a(this.this$0).removeCallbacks(zdf.a(this.this$0));
    }
    zdf.b(this.this$0);
  }
  
  public void onTrigger(JSONObject paramJSONObject)
  {
    QLog.d("SDKEmotionSettingManager", 1, "check api, onTrigger");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zdt
 * JD-Core Version:    0.7.0.1
 */