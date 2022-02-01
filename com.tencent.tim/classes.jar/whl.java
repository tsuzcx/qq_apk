import android.widget.Button;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendGrid.a;
import com.tencent.mobileqq.activity.activateFriend.BirthdayActivatePage;

public class whl
  implements ActivateFriendGrid.a
{
  public whl(BirthdayActivatePage paramBirthdayActivatePage) {}
  
  public void BW(int paramInt)
  {
    if (paramInt > 0)
    {
      this.a.dM.setEnabled(true);
      return;
    }
    this.a.dM.setEnabled(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     whl
 * JD-Core Version:    0.7.0.1
 */