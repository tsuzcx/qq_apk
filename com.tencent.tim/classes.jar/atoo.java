import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.filemanager.activity.LocalFileBrowserActivity;

public class atoo
  implements View.OnClickListener
{
  public atoo(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public void onClick(View paramView)
  {
    atwb.clearSelected();
    this.this$0.IP(false);
    this.this$0.setResult(5);
    this.this$0.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atoo
 * JD-Core Version:    0.7.0.1
 */