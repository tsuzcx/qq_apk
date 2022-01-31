import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.CommonWebActivity;
import com.tencent.mobileqq.activity.LoginPhoneNumActivity;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class dsr
  implements ActionSheet.OnButtonClickListener
{
  public dsr(SubLoginActivity paramSubLoginActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.a.d) {
      return;
    }
    if (paramInt == 0)
    {
      paramView = new Intent(this.a, CommonWebActivity.class);
      paramView.putExtra("uin", SubLoginActivity.a(this.a));
      paramView.putExtra("reqType", 3);
      paramView.putExtra("url", "https://aq.qq.com/cn2/findpsw/mobile_web_find_input_account?source_id=2756");
      this.a.startActivity(paramView);
    }
    for (;;)
    {
      this.a.d = true;
      this.a.a.dismiss();
      return;
      if (paramInt == 1)
      {
        paramView = new Intent(this.a, LoginPhoneNumActivity.class);
        paramView.putExtra("isSubaccount", true);
        this.a.startActivity(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dsr
 * JD-Core Version:    0.7.0.1
 */