import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class vtp
  implements DialogInterface.OnClickListener
{
  vtp(vtm paramvtm) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!this.this$0.bam)
    {
      this.this$0.mDialog.cancel();
      this.this$0.mPause = true;
      vtm.a(this.this$0);
      this.this$0.ii();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vtp
 * JD-Core Version:    0.7.0.1
 */