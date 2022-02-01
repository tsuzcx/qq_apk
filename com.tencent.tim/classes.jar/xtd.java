import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class xtd
  implements DialogInterface.OnClickListener
{
  xtd(xsk paramxsk) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.this$0.c != null) {
      this.this$0.c.pauseDownload();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xtd
 * JD-Core Version:    0.7.0.1
 */