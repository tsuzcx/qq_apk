import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.cloudfile.CloudFileListFragment;

public class atgb
  implements View.OnClickListener
{
  public atgb(CloudFileListFragment paramCloudFileListFragment) {}
  
  public void onClick(View paramView)
  {
    if (CloudFileListFragment.b(this.this$0)) {
      CloudFileListFragment.a(this.this$0).Vr(CloudFileListFragment.c(this.this$0));
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.this$0.getActivity().doOnBackPressed();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atgb
 * JD-Core Version:    0.7.0.1
 */