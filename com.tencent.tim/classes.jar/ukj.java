import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils.c;

public final class ukj
  implements DialogInterface.OnClickListener
{
  public ukj(ChatActivityUtils.c paramc) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a != null) {
      this.a.onCancel();
    }
    jjk.S(true, false);
    paramDialogInterface.dismiss();
    jjk.awW();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ukj
 * JD-Core Version:    0.7.0.1
 */