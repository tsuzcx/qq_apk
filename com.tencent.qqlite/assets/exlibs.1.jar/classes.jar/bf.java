import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.dataline.activities.LiteMutiPicViewerActivity;

public class bf
  implements DialogInterface.OnClickListener
{
  public bf(LiteMutiPicViewerActivity paramLiteMutiPicViewerActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bf
 * JD-Core Version:    0.7.0.1
 */