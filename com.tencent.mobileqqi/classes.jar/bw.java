import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.dataline.activities.LiteMutiPicViewerActivity;

public class bw
  implements DialogInterface.OnClickListener
{
  public bw(LiteMutiPicViewerActivity paramLiteMutiPicViewerActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bw
 * JD-Core Version:    0.7.0.1
 */