import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.cloudfile.CloudFileSendRecvActivity;

public class athh
  implements View.OnClickListener
{
  public athh(CloudFileSendRecvActivity paramCloudFileSendRecvActivity) {}
  
  public void onClick(View paramView)
  {
    CloudFileSendRecvActivity.b(this.this$0).setVisibility(8);
    aqmj.H(this.this$0, this.this$0.app.getCurrentUin(), false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     athh
 * JD-Core Version:    0.7.0.1
 */