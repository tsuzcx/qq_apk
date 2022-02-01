import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.BindGroupConfirmActivity;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class arpu
  implements arxh.a
{
  public arpu(BindGroupConfirmActivity paramBindGroupConfirmActivity) {}
  
  public void ai(JSONObject paramJSONObject)
  {
    if ((this.this$0.mProgress != null) && (this.this$0.mProgress.isShowing())) {
      this.this$0.mProgress.dismiss();
    }
    try
    {
      if (paramJSONObject.getInt("ret") == 0)
      {
        if (this.this$0.e == null)
        {
          this.this$0.e = new swe(this.this$0);
          this.this$0.e.tV(this.this$0.j.getString(2131690859));
          this.this$0.e.c(this.this$0.j.getString(2131690858, new Object[] { this.this$0.cBx }), this.this$0);
          this.this$0.e.a(this.this$0);
        }
        if (this.this$0.e.isShowing()) {
          return;
        }
        this.this$0.e.show();
        return;
      }
      if ((paramJSONObject.getInt("ret") == 10071) || (paramJSONObject.getInt("ret") == 10000))
      {
        if (this.this$0.aH == null) {
          this.this$0.aH = aqha.a(this.this$0, 230, this.this$0.j.getString(2131690862), this.this$0.j.getString(2131690863), 2131721059, 2131721079, this.this$0, null);
        }
        paramJSONObject = paramJSONObject.getString("msg");
        if (!TextUtils.isEmpty(paramJSONObject)) {
          this.this$0.aH.setMessage(paramJSONObject);
        }
        if (this.this$0.aH.isShowing()) {
          return;
        }
        this.this$0.aH.show();
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      onException(paramJSONObject);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BindGroupConfirmActivity", 2, "The JSONObject has error!");
    }
    paramJSONObject = paramJSONObject.getString("msg");
    QQToast.a(aroi.a().getContext(), paramJSONObject, 0).create(this.this$0.getTitleBarHeight()).show();
  }
  
  public void onException(Exception paramException)
  {
    if ((this.this$0.mProgress != null) && (this.this$0.mProgress.isShowing())) {
      this.this$0.mProgress.dismiss();
    }
    this.this$0.f(paramException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arpu
 * JD-Core Version:    0.7.0.1
 */