import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vkt
  implements View.OnClickListener
{
  public vkt(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  public void onClick(View paramView)
  {
    aqqb.b.J(this.this$0, "settings");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vkt
 * JD-Core Version:    0.7.0.1
 */