import com.tencent.mobileqq.activity.recent.RecentOptPopBar;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.PopupMenuDialog.OnClickActionListener;

public class xrf
  implements PopupMenuDialog.OnClickActionListener
{
  public xrf(RecentOptPopBar paramRecentOptPopBar) {}
  
  public void a(PopupMenuDialog.MenuItem paramMenuItem)
  {
    switch (paramMenuItem.a)
    {
    default: 
      return;
    case 2131438761: 
      this.a.m();
      return;
    case 2131439219: 
      this.a.n();
      return;
    case 2131436251: 
      this.a.j();
      return;
    case 2131436248: 
      this.a.i();
      return;
    case 2131436255: 
      this.a.o();
      return;
    case 2131436252: 
      this.a.r();
      return;
    case 2131436261: 
      RecentOptPopBar.a(this.a);
      return;
    case 2131436256: 
      this.a.a(8);
      ReportController.b(this.a.a.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "jiahao.fukuan.click", 0, 0, "", "", "", "");
      return;
    case 2131436246: 
      this.a.q();
      return;
    case 2131438763: 
      this.a.k();
      return;
    }
    this.a.p();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xrf
 * JD-Core Version:    0.7.0.1
 */