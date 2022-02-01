import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface;

public class kav
  implements DialogInterface.OnCancelListener
{
  public kav(PublicAccountJavascriptInterface paramPublicAccountJavascriptInterface, String paramString) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.this$0.callJs(this.VA, new String[] { "-3", "{}" });
    this.this$0.adj = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kav
 * JD-Core Version:    0.7.0.1
 */