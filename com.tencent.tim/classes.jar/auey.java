import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.filemanager.widget.CloudSendBottomBar;

public class auey
  implements View.OnClickListener
{
  public auey(CloudSendBottomBar paramCloudSendBottomBar) {}
  
  public void onClick(View paramView)
  {
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("key_parent_dir_key", CloudSendBottomBar.a(this.this$0).Y());
    localBundle.putBoolean("key_create_form_bottom_bar", true);
    auhk.a locala = CloudSendBottomBar.a(this.this$0).a(1);
    localBundle.putBoolean("key_top_level_dir", false);
    localBundle.putInt("key_file_browser_mode", 1);
    localBundle.putInt("key_bottom_bar_left_action", 1);
    localBundle.putInt("key_bottom_bar_right_action", this.this$0.ero);
    locala.setBundle(localBundle);
    locala.show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auey
 * JD-Core Version:    0.7.0.1
 */