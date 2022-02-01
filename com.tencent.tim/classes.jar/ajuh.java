import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ajuh
  implements View.OnClickListener
{
  public ajuh(NearbyGuideActivity paramNearbyGuideActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.this$0.av != null) && (!this.this$0.isFinishing()))
    {
      this.this$0.av.dismiss();
      this.this$0.av = null;
      this.this$0.uu("0X800590A");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajuh
 * JD-Core Version:    0.7.0.1
 */