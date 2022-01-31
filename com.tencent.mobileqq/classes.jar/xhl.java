import com.tencent.mobileqq.activity.recent.RecentOptPopBar;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.PopupMenuDialog.OnClickActionListener;

public class xhl
  implements PopupMenuDialog.OnClickActionListener
{
  public xhl(RecentOptPopBar paramRecentOptPopBar) {}
  
  public void a(PopupMenuDialog.MenuItem paramMenuItem)
  {
    switch (paramMenuItem.a)
    {
    default: 
      return;
    case 2131438720: 
      this.a.g();
      return;
    case 2131439161: 
      this.a.h();
      return;
    case 2131436215: 
      this.a.d();
      return;
    case 2131436212: 
      this.a.c();
      return;
    case 2131436219: 
      this.a.i();
      return;
    case 2131436216: 
      this.a.l();
      return;
    case 2131436225: 
      RecentOptPopBar.a(this.a);
      return;
    case 2131436220: 
      this.a.a(8);
      ReportController.b(this.a.a.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "jiahao.fukuan.click", 0, 0, "", "", "", "");
      return;
    case 2131436210: 
      this.a.k();
      return;
    case 2131438722: 
      this.a.e();
      return;
    }
    this.a.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xhl
 * JD-Core Version:    0.7.0.1
 */