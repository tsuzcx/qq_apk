import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class uzk
  implements View.OnClickListener
{
  uzk(uzj paramuzj) {}
  
  public void onClick(View paramView)
  {
    if (uzj.a(this.a).getActivity() != null) {
      uzj.a(this.a).getActivity().doOnBackPressed();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uzk
 * JD-Core Version:    0.7.0.1
 */