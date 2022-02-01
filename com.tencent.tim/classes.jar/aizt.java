import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.matchchat.MatchChatMsgListFragment;

public class aizt
  implements DialogInterface.OnDismissListener
{
  public aizt(MatchChatMsgListFragment paramMatchChatMsgListFragment) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    MatchChatMsgListFragment.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aizt
 * JD-Core Version:    0.7.0.1
 */