import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;

public class ahdq
  implements DialogInterface.OnClickListener
{
  public ahdq(SendBottomBar paramSendBottomBar) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1) {
      this.this$0.dmE();
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahdq
 * JD-Core Version:    0.7.0.1
 */