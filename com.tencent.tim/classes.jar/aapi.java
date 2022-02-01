import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity;

public class aapi
  implements DialogInterface.OnDismissListener
{
  public aapi(EditLocalVideoActivity paramEditLocalVideoActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (EditLocalVideoActivity.a(this.this$0) != null) {
      EditLocalVideoActivity.a(this.this$0).setVisibility(0);
    }
    if (EditLocalVideoActivity.a(this.this$0) != null) {
      EditLocalVideoActivity.a(this.this$0).setVisibility(0);
    }
    if ((EditLocalVideoActivity.a(this.this$0) != null) && (EditLocalVideoActivity.a(this.this$0) != 1)) {
      EditLocalVideoActivity.a(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aapi
 * JD-Core Version:    0.7.0.1
 */