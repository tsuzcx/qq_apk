import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vyg
  implements View.OnClickListener
{
  public vyg(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public void onClick(View paramView)
  {
    TroopAssistantActivity.a(this.this$0);
    anot.a(this.this$0.app, "dc00899", "Grp_msg", "", "helper-guide", "Clk_close", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vyg
 * JD-Core Version:    0.7.0.1
 */