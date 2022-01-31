import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.JoinGroupHandler;
import com.tencent.biz.JoinGroupHandler.IJoinGroupCB;

public class js
  implements DialogInterface.OnDismissListener
{
  public js(JoinGroupHandler paramJoinGroupHandler) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    JoinGroupHandler.a(this.a).c();
    JoinGroupHandler.a(this.a, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     js
 * JD-Core Version:    0.7.0.1
 */