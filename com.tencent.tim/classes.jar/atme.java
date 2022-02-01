import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.cloudfile.feeds.CloudFileUploadingStatusBar;
import com.tencent.tim.cloudfile.feeds.CloudUploadingListActivity;

public class atme
  implements View.OnClickListener
{
  public atme(CloudUploadingListActivity paramCloudUploadingListActivity, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    
    if (QLog.isColorLevel()) {
      QLog.i("CloudUploadingListActivity", 2, "not show complete");
    }
    CloudUploadingListActivity.c(this.this$0);
    this.val$dialog.dismiss();
    this.this$0.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atme
 * JD-Core Version:    0.7.0.1
 */