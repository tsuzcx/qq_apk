import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.cloudfile.CloudFileSendRecvActivity;
import com.tencent.tim.cloudfile.CloudFileSendRecvActivity.14;

public class atgt
  implements View.OnClickListener
{
  public atgt(CloudFileSendRecvActivity.14 param14) {}
  
  public void onClick(View paramView)
  {
    CloudFileSendRecvActivity.c(this.a.this$0).setVisibility(8);
    aqmj.d(this.a.this$0.getActivity(), this.a.this$0.app.getCurrentAccountUin(), aqmj.getAppVersionCode(this.a.this$0), "acount_uin_first_use_sendrecv");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atgt
 * JD-Core Version:    0.7.0.1
 */