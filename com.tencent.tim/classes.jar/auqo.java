import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.cloudfile.feeds.CloudUploadingListActivity;
import com.tencent.tim.widget.TimFileUploadInfoBar;

public class auqo
  implements View.OnClickListener
{
  public auqo(TimFileUploadInfoBar paramTimFileUploadInfoBar) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(TimFileUploadInfoBar.a(this.this$0), CloudUploadingListActivity.class);
    TimFileUploadInfoBar.a(this.this$0).startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auqo
 * JD-Core Version:    0.7.0.1
 */