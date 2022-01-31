import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.subscribe.widget.textview.FollowTextView;

public class ypz
  implements DialogInterface.OnDismissListener
{
  public ypz(FollowTextView paramFollowTextView) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    FollowTextView.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ypz
 * JD-Core Version:    0.7.0.1
 */