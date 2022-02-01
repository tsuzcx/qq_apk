import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.view.TabLayout;

public class axje
  implements View.OnClickListener
{
  public axje(TabLayout paramTabLayout, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.this$0.nU(this.val$index);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axje
 * JD-Core Version:    0.7.0.1
 */