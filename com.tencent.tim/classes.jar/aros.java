import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.agent.AuthorityAccountView;
import com.tencent.open.agent.AuthorityAccountView.DelAccountRunnable;

public class aros
  implements DialogInterface.OnClickListener
{
  public aros(AuthorityAccountView paramAuthorityAccountView, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1) {
      ThreadManager.executeOnSubThread(new AuthorityAccountView.DelAccountRunnable(this.this$0, this.val$account));
    }
    while ((paramInt != 0) || (this.this$0.x == null)) {
      return;
    }
    this.this$0.x.dismiss();
    this.this$0.x = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aros
 * JD-Core Version:    0.7.0.1
 */