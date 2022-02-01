import com.tencent.biz.pubaccount.weishi_new.WSHomeFragment;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;

public class ucx
  implements uvb
{
  public ucx(WSHomeFragment paramWSHomeFragment) {}
  
  public void a(uva paramuva)
  {
    if (paramuva != null) {}
    switch (paramuva.a)
    {
    default: 
      return;
    case 2131719191: 
      WSPublicAccReport.getInstance().reportNotificationClick(WSHomeFragment.a, WSHomeFragment.b(this.a));
      WSHomeFragment.b(this.a);
      ((ukz)this.a.b()).a(this.a.getActivity(), 602);
      return;
    }
    WSPublicAccReport.getInstance().reportPersonHomeClick(WSHomeFragment.a, WSHomeFragment.b(this.a));
    ((ukz)this.a.b()).a(this.a.getActivity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ucx
 * JD-Core Version:    0.7.0.1
 */