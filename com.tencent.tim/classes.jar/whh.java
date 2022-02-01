import com.tencent.mobileqq.activity.activateFriend.ActivateFriendView;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendViewItem;
import com.tencent.mobileqq.data.ActivateFriendItem;
import java.util.ArrayList;

public class whh
  extends acfd
{
  public whh(ActivateFriendView paramActivateFriendView) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    int i = 0;
    for (;;)
    {
      if (i < ActivateFriendView.a(this.a).size())
      {
        String str = String.valueOf(((ActivateFriendItem)ActivateFriendView.a(this.a).get(i)).uin);
        if (paramString.equals(str))
        {
          paramString = aqgv.b(ActivateFriendView.a(this.a), str, false);
          ((ActivateFriendViewItem)ActivateFriendView.b(this.a).get(i)).setNickName(paramString);
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
    while (i < ActivateFriendView.a(this.a).size())
    {
      String str = aqgv.A(ActivateFriendView.a(this.a), String.valueOf(((ActivateFriendItem)ActivateFriendView.a(this.a).get(i)).uin));
      ((ActivateFriendViewItem)ActivateFriendView.b(this.a).get(i)).setNickName(str);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     whh
 * JD-Core Version:    0.7.0.1
 */