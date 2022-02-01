import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.fragments.SubscribeBaseFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class sau
  implements View.OnClickListener
{
  sau(sat paramsat) {}
  
  public void onClick(View paramView)
  {
    if ((this.this$0.getParentFragment() instanceof SubscribeBaseFragment)) {
      ((SubscribeBaseFragment)this.this$0.getParentFragment()).a(this.this$0.a(2));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sau
 * JD-Core Version:    0.7.0.1
 */