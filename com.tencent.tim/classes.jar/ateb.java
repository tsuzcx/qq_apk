import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class ateb
  implements DialogInterface.OnDismissListener
{
  ateb(atdx paramatdx) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (atdx.a(this.a) != null)
    {
      atdx.a(this.a).eef();
      atdx.a(this.a).gR();
      atdx.a(this.a, null);
    }
    if ((this.a.a != null) && (!atdx.a(this.a))) {
      this.a.a.etS();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ateb
 * JD-Core Version:    0.7.0.1
 */