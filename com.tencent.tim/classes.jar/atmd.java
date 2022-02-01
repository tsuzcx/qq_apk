import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.cloudfile.feeds.CloudUploadingListActivity;

public class atmd
  implements View.OnClickListener
{
  public atmd(CloudUploadingListActivity paramCloudUploadingListActivity, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    this.val$dialog.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atmd
 * JD-Core Version:    0.7.0.1
 */