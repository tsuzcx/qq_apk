import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.pubaccount.weishi_new.util.OuterInterceptManager.1;

public class uxl
  implements DialogInterface.OnCancelListener
{
  public uxl(OuterInterceptManager.1 param1) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.a.a != null) {
      this.a.a.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uxl
 * JD-Core Version:    0.7.0.1
 */