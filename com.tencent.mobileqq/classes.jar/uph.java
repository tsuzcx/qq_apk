import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.widget.XListView.DrawFinishedListener;

public class uph
  implements XListView.DrawFinishedListener
{
  public uph(SubscriptFeedsActivity paramSubscriptFeedsActivity) {}
  
  public void drawFinished()
  {
    if ((!this.a.c) && (this.a.d))
    {
      this.a.c = true;
      uuq.a("SUBSCRIPT_FEEDS_COST", null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uph
 * JD-Core Version:    0.7.0.1
 */