import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QzoneTranslucentBrowserFragment;

public class avrs
  implements View.OnClickListener
{
  public avrs(QzoneTranslucentBrowserFragment paramQzoneTranslucentBrowserFragment) {}
  
  public void onClick(View paramView)
  {
    if (this.a.getHostActivity() != null) {
      this.a.getHostActivity().finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avrs
 * JD-Core Version:    0.7.0.1
 */