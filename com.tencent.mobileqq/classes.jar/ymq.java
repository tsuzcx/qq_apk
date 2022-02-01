import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class ymq
  implements DialogInterface.OnClickListener
{
  ymq(ymo paramymo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    yqu.a("home_page", "guide_known", 0, 0, new String[0]);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ymq
 * JD-Core Version:    0.7.0.1
 */