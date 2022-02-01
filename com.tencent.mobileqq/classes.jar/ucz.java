import com.tencent.biz.pubaccount.weishi_new.WSHomeFragment;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;

public class ucz
  implements uwl
{
  public ucz(WSHomeFragment paramWSHomeFragment) {}
  
  public void a(uwk paramuwk)
  {
    if (paramuwk != null) {}
    switch (paramuwk.a)
    {
    default: 
      return;
    case 2131719366: 
      WSPublicAccReport.getInstance().reportNotificationClick(WSHomeFragment.a, WSHomeFragment.b(this.a));
      WSHomeFragment.b(this.a);
      ((ulx)this.a.b()).a(this.a.getActivity(), 602);
      return;
    }
    WSPublicAccReport.getInstance().reportPersonHomeClick(WSHomeFragment.a, WSHomeFragment.b(this.a));
    ((ulx)this.a.b()).a(this.a.getActivity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ucz
 * JD-Core Version:    0.7.0.1
 */