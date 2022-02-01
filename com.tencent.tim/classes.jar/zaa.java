import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class zaa
  implements View.OnClickListener
{
  public zaa(SimpleSlidingIndicator paramSimpleSlidingIndicator, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if ((this.b.currentPosition == this.val$position) && (this.b.currentPosition >= 0) && (SimpleSlidingIndicator.a(this.b) != null)) {
      SimpleSlidingIndicator.a(this.b).hf(this.val$position);
    }
    this.b.h(this.val$position, true, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zaa
 * JD-Core Version:    0.7.0.1
 */