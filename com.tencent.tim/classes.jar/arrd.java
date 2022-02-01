import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.agent.OpenAuthorityAccountView;
import com.tencent.open.agent.OpenAuthorityAccountView.DelAccountRunnable;

public class arrd
  implements DialogInterface.OnClickListener
{
  public arrd(OpenAuthorityAccountView paramOpenAuthorityAccountView, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1) {
      ThreadManager.executeOnSubThread(new OpenAuthorityAccountView.DelAccountRunnable(this.this$0, this.val$account));
    }
    while ((paramInt != 0) || (this.this$0.x == null)) {
      return;
    }
    this.this$0.x.dismiss();
    this.this$0.x = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arrd
 * JD-Core Version:    0.7.0.1
 */