import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ark.ArkViewModel;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class wzu
  implements View.OnClickListener
{
  public wzu(ArkAppView paramArkAppView, ArkViewModel paramArkViewModel) {}
  
  public void onClick(View paramView)
  {
    if (this.a != null) {
      this.a.reinitArkContainer();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wzu
 * JD-Core Version:    0.7.0.1
 */