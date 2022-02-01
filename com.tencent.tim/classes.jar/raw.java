import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.takevideo.DanceMachineQQBrowserActivity.DanceMachineQQBrowserFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class raw
  implements View.OnClickListener
{
  public raw(DanceMachineQQBrowserActivity.DanceMachineQQBrowserFragment paramDanceMachineQQBrowserFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.getActivity().finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     raw
 * JD-Core Version:    0.7.0.1
 */