import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.qwallet.PayCodeEntryActivity;

public class xfs
  implements View.OnClickListener
{
  public xfs(PayCodeEntryActivity paramPayCodeEntryActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a("payCodeEntry.contractLink", "actQQWlxclick", "0004");
    paramView = new Intent();
    paramView.setClass(this.a, QQBrowserActivity.class);
    paramView.putExtra("url", "https://wlx.tenpay.com/traffic/protocol/protocol_list.html?_wv=3");
    paramView.putExtra("hide_operation_bar", true);
    paramView.putExtra("hide_more_button", true);
    paramView.putExtra("startOpenPageTime", System.currentTimeMillis());
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xfs
 * JD-Core Version:    0.7.0.1
 */