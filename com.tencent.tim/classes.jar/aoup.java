import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils;
import com.tencent.mobileqq.widget.QQToast;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import org.json.JSONObject;

public class aoup
  extends aost
{
  Context c;
  protected boolean cOP;
  String cmL = "0";
  String cnb;
  protected String cnc;
  String mBid;
  String mCid;
  String mPid;
  
  public aoup(BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    super(paramBaseActivity, paramBundle);
    this.c = paramBaseActivity.getApplicationContext();
  }
  
  protected void Si(String paramString)
  {
    if (this.cOP) {
      return;
    }
    this.cOP = true;
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("pid", this.mPid);
      localJSONObject.put("cid", this.mCid);
      localJSONObject.put("bid", Long.parseLong(this.mBid));
      localJSONObject.put("target_rid", this.cnb);
      localJSONObject.put("comment", TroopBarPublishUtils.a(paramString, null, null));
      localJSONObject.put("version", "3.4.4.3058");
      localJSONObject.put("extparam", this.cnc);
      paramString = new NewIntent(this.c, jnl.class);
      paramString.putExtra("cmd", "MQUpdateSvc_com_qq_xiaoqu.web.recomment");
      WebSsoBody.WebSsoRequestBody localWebSsoRequestBody = new WebSsoBody.WebSsoRequestBody();
      localWebSsoRequestBody.type.set(0);
      localWebSsoRequestBody.data.set(localJSONObject.toString());
      paramString.putExtra("data", localWebSsoRequestBody.toByteArray());
      this.X.setEnabled(false);
      paramString.setObserver(new aouq(this));
      this.mActivity.getAppRuntime().startServlet(paramString);
      return;
    }
    catch (Exception paramString)
    {
      QQToast.a(this.mActivity, 1, 2131698503, 0).show(this.mActivity.getTitleBarHeight());
      this.cOP = false;
    }
  }
  
  public void dismiss()
  {
    super.dismiss();
    if ((this.ai != null) && (this.ai.length() > 0)) {}
    for (String str = "0";; str = "1")
    {
      aprv.report("two_comment", "un", this.mBid, str, "", "");
      if (!this.cOn) {
        T(this.aEt, null, false);
      }
      return;
    }
  }
  
  protected void initData(Bundle paramBundle)
  {
    super.initData(paramBundle);
    this.mBid = this.bO.optString("bid");
    this.mPid = this.bO.optString("pid");
    this.mCid = this.bO.optString("cid");
    this.cnb = this.bO.optString("rid");
    if ("detail".equals(this.bO.optString("from"))) {}
    for (paramBundle = "0";; paramBundle = "1")
    {
      this.cmL = paramBundle;
      this.cnc = this.bO.optString("extparam");
      this.uP = (this.mActivity.getAppRuntime().getAccount() + "-" + this.mBid + "-" + this.mPid + "-" + this.mCid + "-" + this.cnb);
      aprv.report("two_comment", "exp", this.mBid, this.cmL, "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoup
 * JD-Core Version:    0.7.0.1
 */