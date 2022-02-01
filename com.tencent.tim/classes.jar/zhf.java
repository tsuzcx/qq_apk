import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMediaFragment;

public class zhf
  implements DialogInterface.OnClickListener
{
  public zhf(ChatHistoryTroopMediaFragment paramChatHistoryTroopMediaFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.getActivity().setResult(8001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zhf
 * JD-Core Version:    0.7.0.1
 */