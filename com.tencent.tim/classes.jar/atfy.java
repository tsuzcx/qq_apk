import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.cloudfile.CloudFileListFragment;

public class atfy
  implements View.OnClickListener
{
  public atfy(CloudFileListFragment paramCloudFileListFragment) {}
  
  public void onClick(View paramView)
  {
    CloudFileListFragment.a(this.this$0, false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atfy
 * JD-Core Version:    0.7.0.1
 */