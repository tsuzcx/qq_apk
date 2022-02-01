import com.tencent.biz.pubaccount.weishi_new.WSHomeFragment;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;

public class ofh
  implements osw.a
{
  public ofh(WSHomeFragment paramWSHomeFragment) {}
  
  public void bek()
  {
    WSPublicAccReport.getInstance().reportMessageBubblePopupClick(WSHomeFragment.mCurrentPageIndex);
    WSHomeFragment.b(this.this$0);
    ((olw)this.this$0.b()).R(this.this$0.getActivity(), 601);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ofh
 * JD-Core Version:    0.7.0.1
 */