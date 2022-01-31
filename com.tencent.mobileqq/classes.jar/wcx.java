import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.fragments.SubscribeMultiPicFragment;

public class wcx
  implements View.OnClickListener
{
  public wcx(SubscribeMultiPicFragment paramSubscribeMultiPicFragment) {}
  
  public void onClick(View paramView)
  {
    if (SubscribeMultiPicFragment.a(this.a) != null) {
      this.a.a(SubscribeMultiPicFragment.a(this.a).a(1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wcx
 * JD-Core Version:    0.7.0.1
 */