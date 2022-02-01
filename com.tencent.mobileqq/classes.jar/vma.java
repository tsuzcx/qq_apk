import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.pubaccount.weishi_new.util.OuterInterceptManager.1;

public class vma
  implements DialogInterface.OnCancelListener
{
  public vma(OuterInterceptManager.1 param1) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.a.a != null) {
      this.a.a.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vma
 * JD-Core Version:    0.7.0.1
 */