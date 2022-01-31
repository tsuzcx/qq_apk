import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class unl
  implements DialogInterface.OnClickListener
{
  unl(unj paramunj) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    urp.a("home_page", "guide_known", 0, 0, new String[0]);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     unl
 * JD-Core Version:    0.7.0.1
 */