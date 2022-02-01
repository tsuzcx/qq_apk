import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ywl
  implements View.OnClickListener
{
  ywl(ywk paramywk, View paramView) {}
  
  public void onClick(View paramView)
  {
    anot.a(ywk.a(this.a), "dc00899", "Grp_contacts_news", "", "notice", "verify_clk", 0, 0, "", "", "", "");
    ywk.a(this.a, true);
    this.val$view.setVisibility(8);
    this.a.notifyDataSetChanged();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ywl
 * JD-Core Version:    0.7.0.1
 */