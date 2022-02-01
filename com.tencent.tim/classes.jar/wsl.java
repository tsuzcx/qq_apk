import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.doodle.control.ColorView;
import com.tencent.mobileqq.activity.aio.doodle.control.ColorView.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class wsl
  implements View.OnClickListener
{
  public wsl(ColorView paramColorView) {}
  
  public void onClick(View paramView)
  {
    if (ColorView.a(this.b) != null) {
      ColorView.a(this.b).onClick();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wsl
 * JD-Core Version:    0.7.0.1
 */