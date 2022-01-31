import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;

public class xkj
  implements DialogInterface.OnClickListener
{
  public xkj(RecentAdapter paramRecentAdapter) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ((CardHandler)this.a.a.a(2)).j(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xkj
 * JD-Core Version:    0.7.0.1
 */