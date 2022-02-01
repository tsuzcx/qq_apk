import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.utils.PopupDialog;
import com.tencent.av.utils.PopupDialog.a;

public class jkh
  implements DialogInterface.OnClickListener
{
  public jkh(PopupDialog paramPopupDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (PopupDialog.a.q != null) {
      PopupDialog.a.q.onClick(paramDialogInterface, paramInt);
    }
    paramDialogInterface.dismiss();
    PopupDialog.axr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jkh
 * JD-Core Version:    0.7.0.1
 */