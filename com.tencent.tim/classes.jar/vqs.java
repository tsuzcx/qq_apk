import QQService.SvcDevLoginInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.RecentLoginDevActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class vqs
  implements View.OnClickListener
{
  public vqs(RecentLoginDevActivity paramRecentLoginDevActivity, RelativeLayout paramRelativeLayout, int paramInt) {}
  
  public void onClick(View paramView)
  {
    SvcDevLoginInfo localSvcDevLoginInfo = (SvcDevLoginInfo)this.val$layout.getTag();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localSvcDevLoginInfo.stDeviceItemDes);
    RecentLoginDevActivity.a(this.this$0, localSvcDevLoginInfo.strDeviceName, localArrayList, RecentLoginDevActivity.a(this.this$0), this.bDX);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vqs
 * JD-Core Version:    0.7.0.1
 */