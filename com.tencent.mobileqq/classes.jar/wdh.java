import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.fragments.SubscribeVideoDetailFragment;

public class wdh
  implements View.OnClickListener
{
  public wdh(SubscribeVideoDetailFragment paramSubscribeVideoDetailFragment) {}
  
  public void onClick(View paramView)
  {
    if (SubscribeVideoDetailFragment.a(this.a) != null) {
      this.a.a(SubscribeVideoDetailFragment.a(this.a).a(1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wdh
 * JD-Core Version:    0.7.0.1
 */