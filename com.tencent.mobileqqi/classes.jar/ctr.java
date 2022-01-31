import android.view.animation.Animation;
import android.widget.TextView;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.widget.BounceScrollView.OnScrollChangedListener;
import com.tencent.qphone.base.util.QLog;

public class ctr
  implements BounceScrollView.OnScrollChangedListener
{
  public ctr(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("PROFILE_TEST", 4, "onScrollChanged, [" + paramInt1 + "," + paramInt2 + "],[" + paramInt3 + "," + paramInt4 + "]");
    }
    if ((this.a.a.a.a == 33) || (FriendProfileCardActivity.a(this.a) == null)) {}
    for (;;)
    {
      return;
      Object localObject2 = null;
      Object localObject1;
      if ((paramInt2 > paramInt4) && (paramInt2 >= this.a.c) && (FriendProfileCardActivity.a(this.a).getVisibility() == 8)) {
        localObject1 = FriendProfileCardActivity.a(this.a);
      }
      while ((localObject1 != null) && (localObject1 != FriendProfileCardActivity.a(this.a).getAnimation()))
      {
        ((Animation)localObject1).reset();
        FriendProfileCardActivity.a(this.a).startAnimation((Animation)localObject1);
        return;
        localObject1 = localObject2;
        if (paramInt2 < paramInt4)
        {
          localObject1 = localObject2;
          if (paramInt2 <= this.a.c)
          {
            localObject1 = localObject2;
            if (FriendProfileCardActivity.a(this.a).getVisibility() == 0) {
              localObject1 = FriendProfileCardActivity.b(this.a);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ctr
 * JD-Core Version:    0.7.0.1
 */