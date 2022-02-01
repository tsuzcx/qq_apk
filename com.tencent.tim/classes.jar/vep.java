import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.KeepAliveGuideActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vep
  implements View.OnClickListener
{
  public vep(KeepAliveGuideActivity paramKeepAliveGuideActivity) {}
  
  public void onClick(View paramView)
  {
    if (aqfo.isMIUI()) {
      KeepAliveGuideActivity.b(this.this$0);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      KeepAliveGuideActivity.c(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vep
 * JD-Core Version:    0.7.0.1
 */