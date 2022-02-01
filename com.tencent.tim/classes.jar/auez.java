import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.cloudfile.CloudFileDirBrowserActivity;
import com.tencent.tim.filemanager.widget.CloudSendBottomBar;

public class auez
  implements View.OnClickListener
{
  public auez(CloudSendBottomBar paramCloudSendBottomBar) {}
  
  public void onClick(View paramView)
  {
    FileInfo localFileInfo = new FileInfo();
    Object localObject = (atgc)CloudSendBottomBar.a(this.this$0).getManager(373);
    localFileInfo.bf(((atgc)localObject).aE());
    localFileInfo.setName(((atgc)localObject).EO());
    localObject = new Intent(CloudSendBottomBar.a(this.this$0), CloudFileDirBrowserActivity.class);
    ((Intent)localObject).putExtra("key_file_info", localFileInfo);
    ((Intent)localObject).putExtra("key_file_browser_mode", 1);
    ((Intent)localObject).putExtra("key_bottom_bar_left_action", 1);
    ((Intent)localObject).putExtra("key_bottom_bar_right_action", 5);
    ((Intent)localObject).putExtra("key_is_root_dir_selectable", false);
    CloudSendBottomBar.a(this.this$0).startActivityForResult((Intent)localObject, 2);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auez
 * JD-Core Version:    0.7.0.1
 */