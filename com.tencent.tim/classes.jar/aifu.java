import android.app.Activity;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

class aifu
  implements tzd
{
  aifu(aifl paramaifl, WeakReference paramWeakReference, Bundle paramBundle) {}
  
  public void onComplete() {}
  
  public void onFailure(int paramInt, String paramString)
  {
    QLog.e("XProxy|NowProxy", 1, "doraemonAPIManager call login onFailure code = " + paramInt);
    if (this.val$activityRef.get() != null) {
      ((Activity)this.val$activityRef.get()).finish();
    }
    QQToast.a(BaseApplicationImpl.getContext(), 1, acfp.m(2131705352), 0).show();
  }
  
  public void onPermission(int paramInt)
  {
    QLog.e("XProxy|NowProxy", 1, "doraemonAPIManager call login onPermission code = " + paramInt);
    if (this.val$activityRef.get() != null) {
      ((Activity)this.val$activityRef.get()).finish();
    }
    QQToast.a(BaseApplicationImpl.getContext(), 1, acfp.m(2131705353), 0).show();
  }
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    if (this.val$activityRef.get() != null) {
      ((Activity)this.val$activityRef.get()).finish();
    }
    try
    {
      QLog.e("XProxy|NowProxy", 1, "doraemonAPIManager call login onSuccess");
      this.a.accessToken = paramJSONObject.optString("access_token");
      this.a.openId = paramJSONObject.optString("openid");
      this.val$bundle.putString("access_token", this.a.accessToken);
      this.val$bundle.putString("openid", this.a.openId);
      aifl.a(this.a);
      this.a.a.cL(this.val$bundle);
      return;
    }
    catch (Throwable paramJSONObject)
    {
      QLog.e("XProxy|NowProxy", 1, paramJSONObject, new Object[0]);
    }
  }
  
  public void onTrigger(JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aifu
 * JD-Core Version:    0.7.0.1
 */