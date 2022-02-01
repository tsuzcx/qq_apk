import com.tencent.biz.pubaccount.weishi_new.WSHomeFragment;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;

public class ofk
  implements osx.b
{
  public ofk(WSHomeFragment paramWSHomeFragment) {}
  
  public void a(osx.a parama)
  {
    if (parama != null) {}
    switch (parama.id)
    {
    default: 
      return;
    case 2131721928: 
      WSPublicAccReport.getInstance().reportNotificationClick(WSHomeFragment.mCurrentPageIndex);
      WSHomeFragment.b(this.this$0);
      ((olw)this.this$0.b()).R(this.this$0.getActivity(), 602);
      return;
    }
    WSPublicAccReport.getInstance().reportPersonHomeClick(WSHomeFragment.mCurrentPageIndex);
    ((olw)this.this$0.b()).cr(this.this$0.getActivity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ofk
 * JD-Core Version:    0.7.0.1
 */