import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.widget.XListView.DrawFinishedListener;

public class ubk
  implements XListView.DrawFinishedListener
{
  public ubk(SubscriptFeedsActivity paramSubscriptFeedsActivity) {}
  
  public void drawFinished()
  {
    if ((!this.a.c) && (this.a.d))
    {
      this.a.c = true;
      ugt.a("SUBSCRIPT_FEEDS_COST", null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ubk
 * JD-Core Version:    0.7.0.1
 */