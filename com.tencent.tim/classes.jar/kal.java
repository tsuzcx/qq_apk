import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountBrowser.PublicAccountBrowserFragment;

public class kal
  implements DialogInterface.OnClickListener
{
  public kal(PublicAccountBrowser.PublicAccountBrowserFragment paramPublicAccountBrowserFragment, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.this$0.a(paramDialogInterface, false, this.Vy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kal
 * JD-Core Version:    0.7.0.1
 */