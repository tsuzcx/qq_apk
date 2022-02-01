import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.cloudfile.CloudFileSendRecvActivity;

public class athf
  implements View.OnClickListener
{
  public athf(CloudFileSendRecvActivity paramCloudFileSendRecvActivity, int paramInt) {}
  
  public void onClick(View paramView)
  {
    CloudFileSendRecvActivity.b(this.this$0).setVisibility(8);
    athu.c(this.this$0.app, this.this$0.getActivity(), this.epE, 2);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     athf
 * JD-Core Version:    0.7.0.1
 */