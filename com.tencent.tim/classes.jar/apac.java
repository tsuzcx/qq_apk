import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class apac
  extends apab
  implements View.OnClickListener
{
  protected wiw c;
  protected boolean cPw;
  protected String linkUrl;
  protected Context mContext;
  protected View mView;
  protected String troopUin = "";
  
  protected void cbf()
  {
    this.cPw = false;
    this.mView = null;
    this.linkUrl = null;
    this.mContext = null;
    this.troopUin = null;
  }
  
  public void dYi()
  {
    if (this.c != null) {
      this.c.a(null);
    }
  }
  
  public void onClick(View paramView)
  {
    if (!aqmr.isEmpty(this.linkUrl))
    {
      Intent localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
      localIntent.putExtra("url", this.linkUrl);
      localIntent.putExtra("hide_operation_bar", true);
      localIntent.putExtra("hide_more_button", true);
      paramView.getContext().startActivity(localIntent);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.c != null) {
        this.c.a(null);
      }
      anot.a(this.app, "P_CliOper", "Grp_AIO", "", "sys_msg", "Clk_notice", 0, 0, this.troopUin, "", "", "");
    }
  }
  
  protected void onInit()
  {
    this.cPw = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apac
 * JD-Core Version:    0.7.0.1
 */