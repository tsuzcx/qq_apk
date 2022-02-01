import android.app.Application;
import android.content.res.Resources;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormCommonSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.cloudfile.CloudFileSendRecvSyncActivity;
import mqq.app.MobileQQ;

public class athk
  implements CompoundButton.OnCheckedChangeListener
{
  public athk(CloudFileSendRecvSyncActivity paramCloudFileSendRecvSyncActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = true;
    if ((paramBoolean) && (QLog.isDevelopLevel())) {
      QLog.i("CloudFileSendRecvSyncActivity", 4, "[SendRecvFile] reportClick: act=0X8008CD7");
    }
    if (!aqiw.isNetSupport(this.this$0.app.getApplication().getApplicationContext()))
    {
      QQToast.a(this.this$0.getApplicationContext(), 2131696272, 1).show();
      CloudFileSendRecvSyncActivity.a(this.this$0).setOnCheckedChangeListener(null);
      FormCommonSwitchItem localFormCommonSwitchItem = CloudFileSendRecvSyncActivity.a(this.this$0);
      if (!paramBoolean)
      {
        localFormCommonSwitchItem.setChecked(bool);
        CloudFileSendRecvSyncActivity.a(this.this$0).setOnCheckedChangeListener(CloudFileSendRecvSyncActivity.a(this.this$0));
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      bool = false;
      break;
      if (paramBoolean)
      {
        CloudFileSendRecvSyncActivity.a(this.this$0).setOnCheckedChangeListener(null);
        CloudFileSendRecvSyncActivity.a(this.this$0, this.this$0.getApplication().getResources().getString(2131719579));
        ((CardHandler)this.this$0.app.getBusinessHandler(2)).d((short)0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     athk
 * JD-Core Version:    0.7.0.1
 */