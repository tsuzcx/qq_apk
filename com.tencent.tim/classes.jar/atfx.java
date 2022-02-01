import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.cloudfile.CloudFileListFragment;

public class atfx
  implements View.OnClickListener
{
  public atfx(CloudFileListFragment paramCloudFileListFragment) {}
  
  public void onClick(View paramView)
  {
    if (CloudFileListFragment.a(this.this$0) != null) {
      CloudFileListFragment.a(this.this$0).t(this.this$0.fD, this.this$0.fD.getWidth() - this.this$0.getResources().getDimensionPixelSize(2131299279), this.this$0.getResources().getDimensionPixelSize(2131299276));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atfx
 * JD-Core Version:    0.7.0.1
 */