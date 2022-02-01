import com.tencent.mobileqq.activity.activateFriend.ActivateFriendGrid;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendGridItem;
import com.tencent.mobileqq.data.ActivateFriendItem;
import java.util.ArrayList;

public class whe
  extends acfd
{
  public whe(ActivateFriendGrid paramActivateFriendGrid) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    int i = 0;
    for (;;)
    {
      if (i < ActivateFriendGrid.a(this.b).size())
      {
        String str = String.valueOf(((ActivateFriendItem)ActivateFriendGrid.a(this.b).get(i)).uin);
        if (paramString.equals(str))
        {
          paramString = aqgv.b(ActivateFriendGrid.a(this.b), str, false);
          ((ActivateFriendGridItem)ActivateFriendGrid.b(this.b).get(i)).setNickName(paramString);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    while (i < ActivateFriendGrid.a(this.b).size())
    {
      String str = aqgv.A(ActivateFriendGrid.a(this.b), String.valueOf(((ActivateFriendItem)ActivateFriendGrid.a(this.b).get(i)).uin));
      ((ActivateFriendGridItem)ActivateFriendGrid.b(this.b).get(i)).setNickName(str);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     whe
 * JD-Core Version:    0.7.0.1
 */