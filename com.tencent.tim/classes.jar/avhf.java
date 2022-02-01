import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import cooperation.qlink.QlAndQQInterface.WorkState;
import java.util.ArrayList;

class avhf
  implements DialogInterface.OnClickListener
{
  avhf(avhc paramavhc, ArrayList paramArrayList, Activity paramActivity, int paramInt, boolean paramBoolean) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.this$0.gK("0X8004855", 1);
    this.this$0.g(avhc.a(this.this$0).mPeerUin, this.qP);
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("string_filepaths", this.qP);
    localBundle.putBoolean("STRING_CONTINUE_SEND_TO_", true);
    avhc.c(this.val$activity, this.val$source, localBundle);
    paramDialogInterface.dismiss();
    if (this.diO) {
      this.val$activity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     avhf
 * JD-Core Version:    0.7.0.1
 */