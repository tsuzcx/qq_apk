import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.thridappshare.ThridAppShareHelper;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.activity.ForwardOperations.CancelCallback;

public class clq
  implements DialogInterface.OnClickListener
{
  public clq(ForwardOperations paramForwardOperations) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.a != null) {
      this.a.a.a();
    }
    ThridAppShareHelper.a(this.a.A, "app_share_cancle", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     clq
 * JD-Core Version:    0.7.0.1
 */