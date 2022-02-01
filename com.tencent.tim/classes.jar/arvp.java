import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.open.appstore.component.CommonTitleBar;
import com.tencent.open.appstore.component.CommonTitleBar.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class arvp
  implements View.OnClickListener
{
  public arvp(CommonTitleBar paramCommonTitleBar) {}
  
  public void onClick(View paramView)
  {
    if (CommonTitleBar.a(this.a) != null) {
      CommonTitleBar.a(this.a).elO();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arvp
 * JD-Core Version:    0.7.0.1
 */