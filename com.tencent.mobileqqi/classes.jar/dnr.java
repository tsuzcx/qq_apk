import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SubaccountUgActivity;
import com.tencent.mobileqq.subaccount.SubAccountAssistantManager;

public class dnr
  implements View.OnClickListener
{
  public dnr(SubaccountUgActivity paramSubaccountUgActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a.a(), QQBrowserActivity.class);
    paramView.putExtra("uin", this.a.a.a(this.a.b));
    paramView.putExtra("reqType", 3);
    paramView.putExtra("url", "https://aq.qq.com/cn2/findpsw/mobile_web_find_input_account?source_id=2756");
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dnr
 * JD-Core Version:    0.7.0.1
 */