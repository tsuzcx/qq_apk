import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;

class aihi
  implements DialogInterface.OnClickListener
{
  aihi(aihh paramaihh, Bundle paramBundle) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    QIPCClientHelper.getInstance().callServer("TogetherBusinessIPCModule", "action_open_start", this.val$bundle, this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aihi
 * JD-Core Version:    0.7.0.1
 */