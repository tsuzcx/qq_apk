import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.LightVideoItemBuilder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class xiu
  implements View.OnClickListener
{
  public xiu(LightVideoItemBuilder paramLightVideoItemBuilder) {}
  
  public void onClick(View paramView)
  {
    this.this$0.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xiu
 * JD-Core Version:    0.7.0.1
 */