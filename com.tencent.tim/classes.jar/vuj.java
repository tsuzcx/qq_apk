import android.content.res.Resources;
import com.tencent.mobileqq.activity.ShieldFriendsListActivity;
import com.tencent.mobileqq.activity.ShieldFriendsListActivity.b;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class vuj
  extends acfd
{
  public vuj(ShieldFriendsListActivity paramShieldFriendsListActivity) {}
  
  protected void onUpdateFriendShieldFlag(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    super.onUpdateFriendShieldFlag(paramLong, paramBoolean1, paramBoolean2, paramBoolean3, paramString);
    if (!paramBoolean2)
    {
      paramString = this.this$0;
      if (!paramBoolean1)
      {
        paramBoolean1 = true;
        if (ShieldFriendsListActivity.a(paramString, paramLong, paramBoolean1)) {
          QQToast.a(BaseApplication.getContext(), acfp.m(2131714432), 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299627));
        }
      }
    }
    do
    {
      return;
      paramBoolean1 = false;
      break;
      if (ShieldFriendsListActivity.a(this.this$0).isExist(String.valueOf(paramLong)))
      {
        ShieldFriendsListActivity.a(this.this$0, paramLong, paramBoolean1);
        return;
      }
      paramString = ((acff)this.this$0.app.getManager(51)).e(String.valueOf(paramLong));
    } while ((paramString == null) || (paramString.isShield()));
    ShieldFriendsListActivity.a(this.this$0).a(paramString);
    ShieldFriendsListActivity.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vuj
 * JD-Core Version:    0.7.0.1
 */