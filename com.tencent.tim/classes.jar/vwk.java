import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import com.tencent.mobileqq.activity.LoginPhoneNumActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SubLoginActivity;
import java.util.Locale;

public class vwk
  implements ausj.a
{
  public vwk(SubLoginActivity paramSubLoginActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.a.ach) {
      return;
    }
    if (paramInt == 0)
    {
      paramView = null;
      if (SubLoginActivity.a(this.a) != null) {
        paramView = SubLoginActivity.a(this.a).getText().toString();
      }
      if (TextUtils.isEmpty(paramView)) {
        break label193;
      }
    }
    label193:
    for (paramView = String.format(Locale.getDefault(), "%s&account=%s", new Object[] { "https://ti.qq.com/safe/forgetpw?source_id=2756", paramView });; paramView = "https://ti.qq.com/safe/forgetpw?source_id=2756")
    {
      Intent localIntent = new Intent(this.a, QQBrowserActivity.class);
      localIntent.putExtra("uin", SubLoginActivity.a(this.a));
      localIntent.putExtra("reqType", 3);
      localIntent.putExtra("url", paramView);
      this.a.startActivity(localIntent);
      for (;;)
      {
        this.a.ach = true;
        this.a.mActionSheet.dismiss();
        return;
        if (paramInt == 1)
        {
          paramView = new Intent(this.a, LoginPhoneNumActivity.class);
          paramView.putExtra("isSubaccount", true);
          paramView.putExtra("fromWhere", this.a.aOa);
          this.a.startActivity(paramView);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vwk
 * JD-Core Version:    0.7.0.1
 */