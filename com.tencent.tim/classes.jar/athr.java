import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.cloudfile.CloudFileSendRecvSyncer;

public class athr
  extends accn
{
  public athr(CloudFileSendRecvSyncer paramCloudFileSendRecvSyncer) {}
  
  protected void onGetCloudFileAutoSaveState(boolean paramBoolean1, boolean paramBoolean2)
  {
    QLog.i("CloudFileSendRecvSyncer", 1, "[SRSyncer] startSyncOnJustInited.onGetCloudFileAutoSaveState. isSuccess:" + paramBoolean1 + " isOpen" + paramBoolean2);
    if ((CloudFileSendRecvSyncer.a(this.this$0) != null) && (CloudFileSendRecvSyncer.a(this.this$0) != null))
    {
      CloudFileSendRecvSyncer.a(this.this$0).removeObserver(CloudFileSendRecvSyncer.a(this.this$0));
      CloudFileSendRecvSyncer.a(this.this$0, null);
    }
    if (!CloudFileSendRecvSyncer.a(this.this$0)) {}
    do
    {
      return;
      CloudFileSendRecvSyncer.a(this.this$0, false);
    } while (!paramBoolean2);
    this.this$0.startSync();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     athr
 * JD-Core Version:    0.7.0.1
 */