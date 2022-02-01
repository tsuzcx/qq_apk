import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.filemanager.widget.CloudSendBottomBar;

public class aues
  implements View.OnClickListener
{
  public aues(CloudSendBottomBar paramCloudSendBottomBar) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_selected_dir", CloudSendBottomBar.a(this.this$0));
    if (CloudSendBottomBar.a(this.this$0) != null) {
      localIntent.putParcelableArrayListExtra("key_file_to_be_dealt_with", CloudSendBottomBar.a(this.this$0));
    }
    CloudSendBottomBar.a(this.this$0).setResult(-1, localIntent);
    CloudSendBottomBar.a(this.this$0).finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aues
 * JD-Core Version:    0.7.0.1
 */