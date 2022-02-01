import com.tencent.biz.pubaccount.weishi_new.WSHomeFragment;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;

public class ujp
  implements vei
{
  public ujp(WSHomeFragment paramWSHomeFragment) {}
  
  public void a(veh paramveh)
  {
    if (paramveh != null) {}
    switch (paramveh.a)
    {
    default: 
      return;
    case 2131719684: 
      WSPublicAccReport.getInstance().reportNotificationClick(WSHomeFragment.a, WSHomeFragment.b(this.a));
      WSHomeFragment.b(this.a);
      ((utr)this.a.b()).a(this.a.getActivity(), 602);
      return;
    }
    WSPublicAccReport.getInstance().reportPersonHomeClick(WSHomeFragment.a, WSHomeFragment.b(this.a));
    ((utr)this.a.b()).a(this.a.getActivity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ujp
 * JD-Core Version:    0.7.0.1
 */