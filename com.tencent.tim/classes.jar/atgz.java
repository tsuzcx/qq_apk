import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.tim.cloudfile.CloudFileSendRecvActivity;
import java.util.List;

public class atgz
  implements DialogInterface.OnClickListener
{
  public atgz(CloudFileSendRecvActivity paramCloudFileSendRecvActivity, List paramList) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (CloudFileSendRecvActivity.a(this.this$0) != null)
    {
      this.this$0.a.setMode(3);
      this.this$0.a.notifyDataSetChanged();
      CloudFileSendRecvActivity.a(this.this$0).o(1, this.val$fileList.toArray());
      this.this$0.IP(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atgz
 * JD-Core Version:    0.7.0.1
 */