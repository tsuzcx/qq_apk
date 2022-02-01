import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.tim.filemanager.widget.SendBottomBar;

public class aufm
  implements DialogInterface.OnClickListener
{
  public aufm(SendBottomBar paramSendBottomBar) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1) {
      this.this$0.dmE();
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aufm
 * JD-Core Version:    0.7.0.1
 */