import android.widget.Button;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendGrid.a;
import com.tencent.mobileqq.activity.activateFriend.PositionActivatePage;

public class who
  implements ActivateFriendGrid.a
{
  public who(PositionActivatePage paramPositionActivatePage) {}
  
  public void BW(int paramInt)
  {
    if (paramInt > 0) {
      this.a.dM.setEnabled(true);
    }
    while (paramInt > 1)
    {
      this.a.dM.setText(2131689670);
      return;
      this.a.dM.setEnabled(false);
    }
    this.a.dM.setText(2131689671);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     who
 * JD-Core Version:    0.7.0.1
 */