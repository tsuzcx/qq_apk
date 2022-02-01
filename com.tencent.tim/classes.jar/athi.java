import com.tencent.mobileqq.widget.FormCommonSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.tim.cloudfile.CloudFileSendRecvSyncActivity;
import com.tencent.tim.cloudfile.CloudFileSendRecvSyncActivity.PageType;
import com.tencent.tim.cloudfile.CloudFileSendRecvSyncer;

public class athi
  extends accn
{
  public athi(CloudFileSendRecvSyncActivity paramCloudFileSendRecvSyncActivity) {}
  
  protected void onGetCloudFileAutoSaveState(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.this$0.isFinishing()) {
      return;
    }
    if (paramBoolean1)
    {
      CloudFileSendRecvSyncActivity.a(this.this$0, true);
      return;
    }
    CloudFileSendRecvSyncActivity.a(this.this$0, CloudFileSendRecvSyncActivity.PageType.LoadingSwithFailed, null);
  }
  
  protected void onSetCloudFileAutoSaveState(boolean paramBoolean)
  {
    if (this.this$0.isFinishing()) {
      return;
    }
    CloudFileSendRecvSyncActivity.a(this.this$0);
    CloudFileSendRecvSyncActivity.a(this.this$0).setOnCheckedChangeListener(null);
    if (paramBoolean)
    {
      paramBoolean = aqmj.ac(this.this$0.app, "tim_cloudfile_autosave_flag");
      CloudFileSendRecvSyncActivity.a(this.this$0).setChecked(paramBoolean);
      if (paramBoolean)
      {
        CloudFileSendRecvSyncActivity.a(this.this$0, CloudFileSendRecvSyncActivity.PageType.Syncing, null);
        CloudFileSendRecvSyncer.a().startSync();
      }
    }
    for (;;)
    {
      CloudFileSendRecvSyncActivity.a(this.this$0).setOnCheckedChangeListener(CloudFileSendRecvSyncActivity.a(this.this$0));
      return;
      paramBoolean = aqmj.ac(this.this$0.app, "tim_cloudfile_autosave_flag");
      CloudFileSendRecvSyncActivity.a(this.this$0).setChecked(paramBoolean);
      QQToast.a(this.this$0.getApplicationContext(), 2131697171, 0).show(this.this$0.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     athi
 * JD-Core Version:    0.7.0.1
 */