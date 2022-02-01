import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class vcs
  implements DialogInterface.OnClickListener
{
  vcs(vcn paramvcn) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1) {
      this.a.a().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vcs
 * JD-Core Version:    0.7.0.1
 */