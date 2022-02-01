import android.app.Dialog;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardTroopListFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class uyl
  implements View.OnClickListener
{
  public uyl(ForwardTroopListFragment paramForwardTroopListFragment) {}
  
  public void onClick(View paramView)
  {
    if (!this.this$0.getActivity().isFinishing()) {
      ForwardTroopListFragment.a(this.this$0).dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uyl
 * JD-Core Version:    0.7.0.1
 */