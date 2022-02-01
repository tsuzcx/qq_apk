import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.Window;

class mwu
  implements DialogInterface.OnShowListener
{
  mwu(mwq parammwq, ausj paramausj) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    mwq.a(this.b, "mShareActionSheet onShow()");
    this.c.getWindow().clearFlags(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mwu
 * JD-Core Version:    0.7.0.1
 */