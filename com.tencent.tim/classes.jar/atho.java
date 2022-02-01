import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.tim.cloudfile.CloudFileSendRecvSyncActivity;

public class atho
  implements DialogInterface.OnKeyListener
{
  public atho(CloudFileSendRecvSyncActivity paramCloudFileSendRecvSyncActivity) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      this.this$0.finish();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atho
 * JD-Core Version:    0.7.0.1
 */