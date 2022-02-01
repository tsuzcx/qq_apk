import android.content.res.Resources;
import com.tencent.mobileqq.activity.contact.newfriend.BaseNewFriendView.INewFriendContext;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.service.circle.ISwitchObserver;

public class eei
  implements ISwitchObserver
{
  public eei(NewFriendActivity paramNewFriendActivity) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!this.a.isFinishing()) && (NewFriendActivity.a(this.a) != null))
    {
      if (!paramBoolean1) {
        break label92;
      }
      this.a.c = paramBoolean2;
      if (!paramBoolean2) {
        break label79;
      }
    }
    label79:
    for (String str = this.a.getString(2131561652);; str = this.a.getString(2131562507))
    {
      str = this.a.getString(2131562212, new Object[] { str });
      NewFriendActivity.a(this.a).a(str, 2);
      return;
    }
    label92:
    NewFriendActivity.a(this.a).a(this.a.getResources().getString(2131562080), 1);
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     eei
 * JD-Core Version:    0.7.0.1
 */