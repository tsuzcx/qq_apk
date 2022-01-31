import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.fragments.SubscribeMultiPicFragment;

public class yey
  implements View.OnClickListener
{
  public yey(SubscribeMultiPicFragment paramSubscribeMultiPicFragment) {}
  
  public void onClick(View paramView)
  {
    if (SubscribeMultiPicFragment.a(this.a) != null) {
      this.a.a(SubscribeMultiPicFragment.a(this.a).a(1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yey
 * JD-Core Version:    0.7.0.1
 */