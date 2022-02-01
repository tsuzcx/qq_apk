import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class zsj
  implements DialogInterface.OnClickListener
{
  zsj(zsi paramzsi) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 0)
    {
      this.this$0.cou();
      zsi.a(this.this$0).moveTaskToBack(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zsj
 * JD-Core Version:    0.7.0.1
 */