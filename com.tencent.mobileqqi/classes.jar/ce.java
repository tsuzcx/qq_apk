import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.dataline.activities.LiteMutiPicViewerActivity;

public class ce
  implements DialogInterface.OnClickListener
{
  public ce(LiteMutiPicViewerActivity paramLiteMutiPicViewerActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     ce
 * JD-Core Version:    0.7.0.1
 */