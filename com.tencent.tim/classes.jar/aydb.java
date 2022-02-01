import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aydb
  implements View.OnClickListener
{
  aydb(ayda paramayda) {}
  
  public void onClick(View paramView)
  {
    if (ayda.a(this.a) == -1) {
      ayda.a(this.a, "Clk_add_topic");
    }
    TroopBarPublishUtils.g((Activity)this.a.getContext(), 1001, ayda.a(this.a));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aydb
 * JD-Core Version:    0.7.0.1
 */