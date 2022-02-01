import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class woq
  implements View.OnClickListener
{
  woq(woo paramwoo) {}
  
  public void onClick(View paramView)
  {
    this.a.a.dismiss();
    ykv.a("msg_tab", "clk_tips", 0, 0, new String[] { "1", "", "", "" });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     woq
 * JD-Core Version:    0.7.0.1
 */