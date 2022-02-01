import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.cloudfile.CloudFileSendRecvActivity;

public class atgo
  implements View.OnClickListener
{
  public atgo(CloudFileSendRecvActivity paramCloudFileSendRecvActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.akK()) {
      this.this$0.a.Vr(CloudFileSendRecvActivity.a(this.this$0));
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      CloudFileSendRecvActivity.b(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atgo
 * JD-Core Version:    0.7.0.1
 */