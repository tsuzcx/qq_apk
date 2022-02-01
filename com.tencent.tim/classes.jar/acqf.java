import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.app.hiddenchat.HiddenChatFragment;

class acqf
  implements DialogInterface.OnClickListener
{
  acqf(acqe paramacqe, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("back_for_hidden_chat", true);
    paramDialogInterface.setFlags(603979776);
    HiddenChatFragment.b(this.val$activity, 3, 0, paramDialogInterface);
    anot.a(this.a.app, "dc00898", "", "", "0X800A34A", "0X800A34A", 0, 0, "0", "0", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acqf
 * JD-Core Version:    0.7.0.1
 */