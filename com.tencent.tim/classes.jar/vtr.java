import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class vtr
  implements DialogInterface.OnClickListener
{
  vtr(vtm paramvtm) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.this$0.mDialog.show();
    this.this$0.mPause = false;
    vtm.c(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vtr
 * JD-Core Version:    0.7.0.1
 */