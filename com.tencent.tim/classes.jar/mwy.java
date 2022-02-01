import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.View;
import android.view.Window;
import com.tencent.mobileqq.widget.share.ShareActionSheet;

class mwy
  implements DialogInterface.OnShowListener
{
  mwy(mwq parammwq) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    mwq.a(this.b, "mShareActionSheet onShow()");
    this.b.mShareHelper.a().getWindow().getDecorView().setSystemUiVisibility(mwq.a(this.b).getWindow().getDecorView().getSystemUiVisibility());
    this.b.mShareHelper.a().getWindow().clearFlags(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mwy
 * JD-Core Version:    0.7.0.1
 */