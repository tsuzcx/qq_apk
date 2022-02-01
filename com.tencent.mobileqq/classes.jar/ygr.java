import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class ygr
  implements DialogInterface.OnClickListener
{
  ygr(ygp paramygp) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ykv.a("home_page", "guide_known", 0, 0, new String[0]);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ygr
 * JD-Core Version:    0.7.0.1
 */