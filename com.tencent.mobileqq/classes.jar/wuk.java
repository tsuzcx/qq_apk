import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class wuk
  implements View.OnClickListener
{
  wuk(wui paramwui) {}
  
  public void onClick(View paramView)
  {
    this.a.a.dismiss();
    yqu.a("msg_tab", "clk_tips", 0, 0, new String[] { "1", "", "", "" });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wuk
 * JD-Core Version:    0.7.0.1
 */