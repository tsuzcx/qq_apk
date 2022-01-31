import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.subscribe.widget.textview.FollowTextView;

public class whs
  implements DialogInterface.OnDismissListener
{
  public whs(FollowTextView paramFollowTextView) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    FollowTextView.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     whs
 * JD-Core Version:    0.7.0.1
 */