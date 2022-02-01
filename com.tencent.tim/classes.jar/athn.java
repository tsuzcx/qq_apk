import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.tim.cloudfile.CloudFileSendRecvSyncActivity;
import com.tencent.tim.cloudfile.CloudFileSendRecvSyncActivity.6.1;
import java.util.Arrays;
import java.util.List;

public class athn
  extends atgd
{
  public athn(CloudFileSendRecvSyncActivity paramCloudFileSendRecvSyncActivity) {}
  
  public void a(boolean paramBoolean1, byte[] paramArrayOfByte, int paramInt1, List<atiu> paramList, boolean paramBoolean2, String paramString, int paramInt2)
  {
    if (this.this$0.isFinishing()) {}
    while (!Arrays.equals(paramArrayOfByte, CloudFileSendRecvSyncActivity.a(this.this$0).Y())) {
      return;
    }
    if ((this.this$0.app != null) && (CloudFileSendRecvSyncActivity.a(this.this$0) != null))
    {
      this.this$0.app.removeObserver(CloudFileSendRecvSyncActivity.a(this.this$0));
      CloudFileSendRecvSyncActivity.a(this.this$0, null);
    }
    CloudFileSendRecvSyncActivity.a(this.this$0).post(new CloudFileSendRecvSyncActivity.6.1(this, paramBoolean1, paramList, paramBoolean2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     athn
 * JD-Core Version:    0.7.0.1
 */