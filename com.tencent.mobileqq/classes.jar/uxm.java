import com.tencent.biz.pubaccount.weishi_new.WSHomeFragment;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;

public class uxm
  implements vtb
{
  public uxm(WSHomeFragment paramWSHomeFragment) {}
  
  public void a(vta paramvta)
  {
    if (paramvta != null) {}
    switch (paramvta.a)
    {
    default: 
      return;
    case 2131720137: 
      WSPublicAccReport.getInstance().reportNotificationClick(WSHomeFragment.a, WSHomeFragment.b(this.a));
      WSHomeFragment.b(this.a);
      ((vic)this.a.b()).a(this.a.getActivity(), 602);
      return;
    }
    WSPublicAccReport.getInstance().reportPersonHomeClick(WSHomeFragment.a, WSHomeFragment.b(this.a));
    ((vic)this.a.b()).a(this.a.getActivity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uxm
 * JD-Core Version:    0.7.0.1
 */