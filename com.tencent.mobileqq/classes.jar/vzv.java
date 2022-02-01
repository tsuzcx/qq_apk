import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class vzv
  implements View.OnClickListener
{
  vzv(vzt paramvzt) {}
  
  public void onClick(View paramView)
  {
    this.a.a.dismiss();
    xwa.a("msg_tab", "clk_tips", 0, 0, new String[] { "1", "", "", "" });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vzv
 * JD-Core Version:    0.7.0.1
 */