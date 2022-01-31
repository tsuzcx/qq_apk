import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.dataline.activities.DLFileViewerActivity;

public class m
  implements DialogInterface.OnClickListener
{
  public m(DLFileViewerActivity paramDLFileViewerActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     m
 * JD-Core Version:    0.7.0.1
 */