import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.cloudfile.CloudFileSendRecvSyncer;
import com.tencent.tim.cloudfile.CloudFileSendRecvSyncer.2.1;
import com.tencent.tim.cloudfile.CloudFileSendRecvSyncer.SyncState;
import com.tencent.tim.cloudfile.CloudFileSendRecvSyncer.b;
import java.util.List;

public class athq
  implements athu.a
{
  public athq(CloudFileSendRecvSyncer paramCloudFileSendRecvSyncer) {}
  
  public void nH(List<FileManagerEntity> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("[SRSyncer] startSync.onGettedSendRecvFiles size:");
    if (paramList != null) {}
    for (int i = paramList.size();; i = 0)
    {
      QLog.i("CloudFileSendRecvSyncer", 1, i);
      if ((paramList == null) || (paramList.size() == 0)) {
        new Handler(Looper.getMainLooper()).postDelayed(new CloudFileSendRecvSyncer.2.1(this), 1500L);
      }
      CloudFileSendRecvSyncer.a(this.this$0).nI(paramList);
      CloudFileSendRecvSyncer.a(this.this$0, CloudFileSendRecvSyncer.SyncState.SyncState_syncing);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     athq
 * JD-Core Version:    0.7.0.1
 */