import android.content.res.Resources;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendGrid;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendGridItem;
import com.tencent.mobileqq.data.ActivateFriendItem;
import java.util.ArrayList;

public class whf
  extends acog
{
  public whf(ActivateFriendGrid paramActivateFriendGrid) {}
  
  public void bYc()
  {
    if ((ActivateFriendGrid.a(this.b) == null) || (ActivateFriendGrid.b(this.b) == null)) {
      return;
    }
    int i = 0;
    label23:
    if (i < ActivateFriendGrid.a(this.b).size())
    {
      if (!this.b.b.n(((ActivateFriendItem)ActivateFriendGrid.a(this.b).get(i)).uin, 2)) {
        break label122;
      }
      ((ActivateFriendGridItem)ActivateFriendGrid.b(this.b).get(i)).setChecked(false);
      ((ActivateFriendGridItem)ActivateFriendGrid.b(this.b).get(i)).setBirthday(this.b.getResources().getString(2131689658));
    }
    for (;;)
    {
      i += 1;
      break label23;
      break;
      label122:
      if (this.b.b.m(((ActivateFriendItem)ActivateFriendGrid.a(this.b).get(i)).uin, 2))
      {
        ((ActivateFriendGridItem)ActivateFriendGrid.b(this.b).get(i)).setChecked(false);
        ((ActivateFriendGridItem)ActivateFriendGrid.b(this.b).get(i)).setBirthday(this.b.getResources().getString(2131689661));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     whf
 * JD-Core Version:    0.7.0.1
 */