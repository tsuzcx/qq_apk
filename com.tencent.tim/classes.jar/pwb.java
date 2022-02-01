import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class pwb
  implements View.OnClickListener
{
  pwb(pvz parampvz) {}
  
  public void onClick(View paramView)
  {
    this.this$0.a.dismiss();
    rar.a("msg_tab", "clk_tips", 0, 0, new String[] { "1", "", "", "" });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pwb
 * JD-Core Version:    0.7.0.1
 */