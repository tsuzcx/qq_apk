import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SearchMightKnowFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vtc
  implements View.OnClickListener
{
  public vtc(SearchMightKnowFragment paramSearchMightKnowFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.getActivity().finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vtc
 * JD-Core Version:    0.7.0.1
 */