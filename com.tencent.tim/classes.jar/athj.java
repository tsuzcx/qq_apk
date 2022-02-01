import android.os.Bundle;
import com.tencent.tim.cloudfile.CloudFileSendRecvSyncActivity;
import com.tencent.tim.cloudfile.CloudFileSendRecvSyncActivity.PageType;
import com.tencent.tim.cloudfile.CloudFileSendRecvSyncer.a;

public class athj
  extends CloudFileSendRecvSyncer.a
{
  public athj(CloudFileSendRecvSyncActivity paramCloudFileSendRecvSyncActivity) {}
  
  public void f(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (this.this$0.isFinishing()) {
      return;
    }
    if ((paramInt2 > 0) || (paramInt1 == 0))
    {
      CloudFileSendRecvSyncActivity.b(this.this$0);
      return;
    }
    if (paramInt6 != 0)
    {
      Bundle localBundle = new Bundle();
      if (paramInt6 == 1) {
        localBundle.putBoolean("needupvip", true);
      }
      CloudFileSendRecvSyncActivity.a(this.this$0, CloudFileSendRecvSyncActivity.PageType.SynFailed_spaceimit, localBundle);
      return;
    }
    if (paramInt3 <= 0)
    {
      CloudFileSendRecvSyncActivity.b(this.this$0);
      return;
    }
    CloudFileSendRecvSyncActivity.a(this.this$0, CloudFileSendRecvSyncActivity.PageType.SynFailed, null);
  }
  
  public void i(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (this.this$0.isFinishing()) {}
    while (paramInt2 <= 0) {
      return;
    }
    CloudFileSendRecvSyncActivity.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     athj
 * JD-Core Version:    0.7.0.1
 */