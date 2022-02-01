import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class oqg
  implements View.OnClickListener
{
  oqg(oqf paramoqf) {}
  
  public void onClick(View paramView)
  {
    if (oqf.a(this.a).getActivity() != null) {
      oqf.a(this.a).getActivity().doOnBackPressed();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oqg
 * JD-Core Version:    0.7.0.1
 */