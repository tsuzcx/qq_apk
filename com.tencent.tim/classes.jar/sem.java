import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.fragments.SubscribeMultiPicFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class sem
  implements View.OnClickListener
{
  public sem(SubscribeMultiPicFragment paramSubscribeMultiPicFragment) {}
  
  public void onClick(View paramView)
  {
    if (SubscribeMultiPicFragment.a(this.this$0) != null) {
      this.this$0.a(SubscribeMultiPicFragment.a(this.this$0).a(1));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sem
 * JD-Core Version:    0.7.0.1
 */