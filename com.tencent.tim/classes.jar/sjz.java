import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.subscribe.widget.textview.FollowTextView;

public class sjz
  implements DialogInterface.OnDismissListener
{
  public sjz(FollowTextView paramFollowTextView) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    FollowTextView.a(this.f, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sjz
 * JD-Core Version:    0.7.0.1
 */