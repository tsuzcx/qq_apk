import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.dataline.activities.LiteActivity;

public class ai
  implements DialogInterface.OnClickListener
{
  public ai(LiteActivity paramLiteActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     ai
 * JD-Core Version:    0.7.0.1
 */