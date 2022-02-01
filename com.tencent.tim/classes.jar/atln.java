import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.cloudfile.feeds.CloudFileUploadingStatusBar;
import com.tencent.tim.cloudfile.feeds.CloudUploadingListActivity;

public class atln
  implements View.OnClickListener
{
  public atln(CloudFileUploadingStatusBar paramCloudFileUploadingStatusBar) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.this$0.getContext(), CloudUploadingListActivity.class);
    this.this$0.getContext().startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atln
 * JD-Core Version:    0.7.0.1
 */