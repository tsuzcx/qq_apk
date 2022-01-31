import android.widget.Button;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendGrid.GridCallBack;
import com.tencent.mobileqq.activity.activateFriend.BirthdayActivatePage;

public class ujb
  implements ActivateFriendGrid.GridCallBack
{
  public ujb(BirthdayActivatePage paramBirthdayActivatePage) {}
  
  public void a(int paramInt)
  {
    if (paramInt > 0)
    {
      this.a.a.setEnabled(true);
      return;
    }
    this.a.a.setEnabled(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ujb
 * JD-Core Version:    0.7.0.1
 */