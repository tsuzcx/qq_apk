import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class sal
  implements View.OnClickListener
{
  public sal(BaseWidgetView paramBaseWidgetView) {}
  
  public void onClick(View paramView)
  {
    if ((this.c.v() != null) && (!this.c.J(paramView)))
    {
      this.c.dZ(this.c.aB());
      this.c.v().onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sal
 * JD-Core Version:    0.7.0.1
 */