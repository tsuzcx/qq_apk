import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class oqe
  implements View.OnClickListener
{
  oqe(oqd paramoqd) {}
  
  public void onClick(View paramView)
  {
    if (oqd.a(this.a).getActivity() != null) {
      oqd.a(this.a).getActivity().doOnBackPressed();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oqe
 * JD-Core Version:    0.7.0.1
 */