import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.recent.RecentOptPopBar;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.widget.PopupMenuDialog;

public class xrc
  implements View.OnClickListener
{
  public xrc(RecentOptPopBar paramRecentOptPopBar) {}
  
  public void onClick(View paramView)
  {
    RecentOptPopBar.a(this.a).dismiss();
    paramView = new CmGameStartChecker.StartCheckParam(2507, false, "check", 0L, 4, 1, 0, 0, "", 226);
    ApolloGameUtil.a(this.a.a, paramView);
    VipUtils.a(CmGameUtil.a(), "cmshow", "Apollo", "ballplay", 0, 0, new String[] { "", "" + ApolloManager.a() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xrc
 * JD-Core Version:    0.7.0.1
 */