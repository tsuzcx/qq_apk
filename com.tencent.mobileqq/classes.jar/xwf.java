import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.takevideo.DanceMachineQQBrowserActivity.DanceMachineQQBrowserFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class xwf
  implements View.OnClickListener
{
  public xwf(DanceMachineQQBrowserActivity.DanceMachineQQBrowserFragment paramDanceMachineQQBrowserFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.getActivity().finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xwf
 * JD-Core Version:    0.7.0.1
 */