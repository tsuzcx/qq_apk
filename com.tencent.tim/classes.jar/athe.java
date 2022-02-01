import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.cloudfile.CloudFileSendRecvActivity;

public class athe
  implements View.OnClickListener
{
  public athe(CloudFileSendRecvActivity paramCloudFileSendRecvActivity) {}
  
  public void onClick(View paramView)
  {
    CloudFileSendRecvActivity.a(this.this$0).setVisibility(8);
    this.this$0.a.notifyDataSetChanged();
    aqmj.d(this.this$0, this.this$0.app.getCurrentUin(), 2, false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     athe
 * JD-Core Version:    0.7.0.1
 */