import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.cloudfile.CloudFileSendRecvActivity;

public class atgp
  implements View.OnClickListener
{
  public atgp(CloudFileSendRecvActivity paramCloudFileSendRecvActivity) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("SendRecvActivity", 4, "[SendRecvFile] reportClick: act=0X8008CD9");
    }
    this.this$0.startActivity(new Intent(this.this$0, QQSettingMsgHistoryActivity.class));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atgp
 * JD-Core Version:    0.7.0.1
 */