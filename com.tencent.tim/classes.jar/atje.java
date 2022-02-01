import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.cloudfile.WeiYunFileListFragment;

public class atje
  implements View.OnClickListener
{
  public atje(WeiYunFileListFragment paramWeiYunFileListFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.getActivity().doOnBackPressed();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atje
 * JD-Core Version:    0.7.0.1
 */