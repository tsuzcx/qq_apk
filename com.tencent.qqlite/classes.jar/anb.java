import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.thridappshare.ThridAppShareHelper;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.activity.ForwardOperations.CancelCallback;

public class anb
  implements DialogInterface.OnClickListener
{
  public anb(ForwardOperations paramForwardOperations) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.a != null) {
      this.a.a.b();
    }
    ThridAppShareHelper.a(this.a.H, "app_share_cancle", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     anb
 * JD-Core Version:    0.7.0.1
 */