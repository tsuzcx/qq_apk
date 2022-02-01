import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.filemanager.widget.CloudSendBottomBar;
import com.tencent.tim.teamwork.PadInfo;
import java.util.List;

public class auex
  implements View.OnClickListener
{
  public auex(CloudSendBottomBar paramCloudSendBottomBar) {}
  
  public void onClick(View paramView)
  {
    Object localObject = atiz.ek();
    Intent localIntent = new Intent();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (PadInfo)((List)localObject).get(0);
      if (localObject != null)
      {
        localIntent.putExtra("key_type_domain_id", ((PadInfo)localObject).domainId);
        localIntent.putExtra("key_type_pad_id", ((PadInfo)localObject).padId);
        localIntent.putExtra("key_type_title", ((PadInfo)localObject).title);
      }
    }
    CloudSendBottomBar.a(this.this$0).setResult(-1, localIntent);
    CloudSendBottomBar.a(this.this$0).finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auex
 * JD-Core Version:    0.7.0.1
 */