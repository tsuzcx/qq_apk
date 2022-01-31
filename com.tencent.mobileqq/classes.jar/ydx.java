import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.fragments.SubscribeBaseFragment;

class ydx
  implements View.OnClickListener
{
  ydx(ydw paramydw) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.getParentFragment() instanceof SubscribeBaseFragment)) {
      ((SubscribeBaseFragment)this.a.getParentFragment()).a(this.a.a(2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ydx
 * JD-Core Version:    0.7.0.1
 */