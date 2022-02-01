import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class urp
  implements View.OnClickListener
{
  urp(uro paramuro) {}
  
  public void onClick(View paramView)
  {
    if (uro.a(this.a).getActivity() != null) {
      uro.a(this.a).getActivity().doOnBackPressed();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     urp
 * JD-Core Version:    0.7.0.1
 */