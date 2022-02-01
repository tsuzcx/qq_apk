import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

class aouq
  implements BusinessObserver
{
  aouq(aoup paramaoup) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.a.X.setEnabled(true);
    this.a.mActivity.getString(2131698503);
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle == null) {
          continue;
        }
        Object localObject = new WebSsoBody.WebSsoResponseBody();
        ((WebSsoBody.WebSsoResponseBody)localObject).mergeFrom(paramBundle);
        paramInt = ((WebSsoBody.WebSsoResponseBody)localObject).ret.get();
        paramBundle = new JSONObject(((WebSsoBody.WebSsoResponseBody)localObject).data.get());
        if (paramInt == 0) {
          continue;
        }
        localObject = paramBundle.optString("msg");
        paramBundle = (Bundle)localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          paramBundle = this.a.mActivity.getString(2131698504, new Object[] { Integer.valueOf(paramInt) });
        }
      }
      catch (Exception paramBundle)
      {
        paramBundle = this.a.mActivity.getString(2131698504, new Object[] { Integer.valueOf(9992) });
        continue;
        paramBundle = this.a.mActivity.getString(2131698504, new Object[] { Integer.valueOf(9991) });
        continue;
      }
      QQToast.a(this.a.mActivity, 1, paramBundle, 0).show(this.a.mActivity.getTitleBarHeight());
      aprv.report("two_comment", "fail", this.a.mBid, "4", "", "");
      this.a.cOP = false;
      return;
      paramBundle = paramBundle.getJSONObject("result");
      aprv.report("two_comment", "suc", this.a.mBid, this.a.cmL, "", "");
      this.a.cOn = true;
      this.a.T(this.a.aEt, paramBundle.toString(), true);
      this.a.dismiss();
      return;
      paramBundle = this.a.mActivity.getString(2131698504, new Object[] { Integer.valueOf(9992) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aouq
 * JD-Core Version:    0.7.0.1
 */