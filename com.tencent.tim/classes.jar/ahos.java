import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.fragment.ShieldFriendsListFragment;
import com.tencent.mobileqq.fragment.ShieldFriendsListFragment.b;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class ahos
  extends acfd
{
  public ahos(ShieldFriendsListFragment paramShieldFriendsListFragment) {}
  
  protected void onUpdateFriendShieldFlag(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    super.onUpdateFriendShieldFlag(paramLong, paramBoolean1, paramBoolean2, paramBoolean3, paramString);
    if (!paramBoolean2)
    {
      paramString = this.this$0;
      if (!paramBoolean1)
      {
        paramBoolean1 = true;
        if (ShieldFriendsListFragment.a(paramString, paramLong, paramBoolean1)) {
          QQToast.a(BaseApplication.getContext(), acfp.m(2131714431), 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299627));
        }
      }
    }
    do
    {
      return;
      paramBoolean1 = false;
      break;
      if (ShieldFriendsListFragment.a(this.this$0).isExist(String.valueOf(paramLong)))
      {
        ShieldFriendsListFragment.a(this.this$0, paramLong, paramBoolean1);
        return;
      }
      paramString = ((acff)this.this$0.getActivity().app.getManager(51)).e(String.valueOf(paramLong));
    } while ((paramString == null) || (paramString.isShield()));
    ShieldFriendsListFragment.a(this.this$0).a(paramString);
    ShieldFriendsListFragment.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahos
 * JD-Core Version:    0.7.0.1
 */