import com.tencent.mobileqq.activity.recent.RecentOptPopBar;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.PopupMenuDialog.OnClickActionListener;

public class xks
  implements PopupMenuDialog.OnClickActionListener
{
  public xks(RecentOptPopBar paramRecentOptPopBar) {}
  
  public void a(PopupMenuDialog.MenuItem paramMenuItem)
  {
    switch (paramMenuItem.a)
    {
    default: 
      return;
    case 2131438738: 
      this.a.g();
      return;
    case 2131439189: 
      this.a.h();
      return;
    case 2131436232: 
      this.a.d();
      return;
    case 2131436229: 
      this.a.c();
      return;
    case 2131436236: 
      this.a.i();
      return;
    case 2131436233: 
      this.a.l();
      return;
    case 2131436242: 
      RecentOptPopBar.a(this.a);
      return;
    case 2131436237: 
      this.a.a(8);
      ReportController.b(this.a.a.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "jiahao.fukuan.click", 0, 0, "", "", "", "");
      return;
    case 2131436227: 
      this.a.k();
      return;
    case 2131438740: 
      this.a.e();
      return;
    }
    this.a.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xks
 * JD-Core Version:    0.7.0.1
 */