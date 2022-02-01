import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class zsb
  implements View.OnClickListener
{
  public zsb(BaseWidgetView paramBaseWidgetView) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a() != null) && (!this.a.a(paramView)))
    {
      this.a.a(this.a.a());
      this.a.a().onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zsb
 * JD-Core Version:    0.7.0.1
 */