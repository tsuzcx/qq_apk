import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class xtt
  implements DialogInterface.OnClickListener
{
  xtt(xtp paramxtp, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      if (this.bWX != 0) {
        break label47;
      }
      this.this$0.c(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) });
    }
    for (;;)
    {
      xtp.b(this.this$0, null);
      return;
      label47:
      if (this.bWX == 1) {
        this.this$0.c(new Integer[] { Integer.valueOf(0), Integer.valueOf(2) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xtt
 * JD-Core Version:    0.7.0.1
 */