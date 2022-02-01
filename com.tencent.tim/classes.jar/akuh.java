import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.onlinestatus.location.OnlineStatusLocationFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class akuh
  implements View.OnClickListener
{
  public akuh(OnlineStatusLocationFragment paramOnlineStatusLocationFragment) {}
  
  public void onClick(View paramView)
  {
    if ((this.this$0.getActivity() != null) && (!this.this$0.getActivity().isFinishing())) {
      this.this$0.getActivity().finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akuh
 * JD-Core Version:    0.7.0.1
 */