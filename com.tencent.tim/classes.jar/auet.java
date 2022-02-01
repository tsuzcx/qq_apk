import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.tim.filemanager.widget.CloudSendBottomBar;
import com.tencent.tim.filemanager.widget.CloudSendBottomBar.2.1;
import java.util.Arrays;

public class auet
  implements View.OnClickListener
{
  public auet(CloudSendBottomBar paramCloudSendBottomBar) {}
  
  public void onClick(View paramView)
  {
    if (CloudSendBottomBar.a(this.this$0)) {}
    do
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      CloudSendBottomBar.a(this.this$0, true);
      new Handler().postDelayed(new CloudSendBottomBar.2.1(this), 800L);
    } while ((!(CloudSendBottomBar.a(this.this$0) instanceof BaseFileAssistantActivity)) || (!((BaseFileAssistantActivity)CloudSendBottomBar.a(this.this$0)).akL()));
    Intent localIntent = new Intent();
    localIntent.putParcelableArrayListExtra("key_file_to_be_dealt_with", atwb.ep());
    atgc localatgc = (atgc)CloudSendBottomBar.a(this.this$0).getManager(373);
    if ((CloudSendBottomBar.a(this.this$0) != null) && (!Arrays.equals(CloudSendBottomBar.a(this.this$0).Y(), localatgc.aE()))) {
      localIntent.putExtra("key_selected_dir", CloudSendBottomBar.a(this.this$0));
    }
    for (;;)
    {
      CloudSendBottomBar.a(this.this$0).setResult(-1, localIntent);
      CloudSendBottomBar.a(this.this$0).finish();
      break;
      if ((CloudSendBottomBar.a(this.this$0) != null) && (Arrays.equals(CloudSendBottomBar.a(this.this$0).Y(), localatgc.aE())))
      {
        CloudSendBottomBar.a(this.this$0).bf(localatgc.aG());
        localIntent.putExtra("key_selected_dir", CloudSendBottomBar.a(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auet
 * JD-Core Version:    0.7.0.1
 */