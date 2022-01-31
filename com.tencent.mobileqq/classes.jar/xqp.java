import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.recent.RecentOptPopBar;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

public class xqp
  implements View.OnClickListener
{
  public xqp(RecentOptPopBar paramRecentOptPopBar) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a.a, QQBrowserActivity.class);
    VasWebviewUtil.openQQBrowserActivity(this.a.a, ApolloConstant.ae, -1L, paramView, false, -1);
    VipUtils.a(CmGameUtil.a(), "cmshow", "Apollo", "clickmoregame", 0, 0, new String[] { "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xqp
 * JD-Core Version:    0.7.0.1
 */