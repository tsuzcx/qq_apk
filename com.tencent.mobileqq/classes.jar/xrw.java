import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class xrw
  implements DialogInterface.OnClickListener
{
  xrw(xru paramxru) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    xwa.a("home_page", "guide_known", 0, 0, new String[0]);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xrw
 * JD-Core Version:    0.7.0.1
 */