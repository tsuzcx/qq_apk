import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormCommonSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.cloudfile.CloudFileSendRecvSyncActivity;
import com.tencent.tim.cloudfile.CloudFileSendRecvSyncActivity.PageType;
import com.tencent.tim.cloudfile.CloudFileSendRecvSyncer;
import mqq.app.MobileQQ;

public class athl
  implements View.OnClickListener
{
  public athl(CloudFileSendRecvSyncActivity paramCloudFileSendRecvSyncActivity) {}
  
  public void onClick(View paramView)
  {
    if (!aqiw.isNetSupport(this.this$0.app.getApplication().getApplicationContext())) {
      QQToast.a(this.this$0.getApplicationContext(), 2131696272, 1).show();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (CloudFileSendRecvSyncActivity.a(this.this$0))
      {
        ((CardHandler)this.this$0.app.getBusinessHandler(2)).cHQ();
        CloudFileSendRecvSyncActivity.a(this.this$0, CloudFileSendRecvSyncActivity.PageType.LoadingSwith, null);
      }
      else if (aqmj.ac(this.this$0.app, "tim_cloudfile_autosave_flag"))
      {
        CloudFileSendRecvSyncActivity.a(this.this$0, CloudFileSendRecvSyncActivity.PageType.Syncing, null);
        CloudFileSendRecvSyncer.a().startSync();
      }
      else
      {
        QQToast.a(this.this$0.getApplicationContext(), 2131691708, 0).show(this.this$0.getTitleBarHeight());
        CloudFileSendRecvSyncActivity.a(this.this$0, CloudFileSendRecvSyncActivity.PageType.Swith, null);
        CloudFileSendRecvSyncActivity.a(this.this$0).setOnCheckedChangeListener(null);
        CloudFileSendRecvSyncActivity.a(this.this$0).setChecked(false);
        CloudFileSendRecvSyncActivity.a(this.this$0).setOnCheckedChangeListener(CloudFileSendRecvSyncActivity.a(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     athl
 * JD-Core Version:    0.7.0.1
 */