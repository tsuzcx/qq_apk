import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.qphone.base.util.QLog;

public class cmz
  implements Animation.AnimationListener
{
  public cmz(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    boolean bool2 = true;
    StringBuilder localStringBuilder;
    if (QLog.isDevelopLevel())
    {
      localStringBuilder = new StringBuilder().append("onAnimationStart, [");
      if (paramAnimation != FriendProfileCardActivity.a(this.a)) {
        break label106;
      }
      bool1 = true;
      localStringBuilder = localStringBuilder.append(bool1).append(",");
      if (paramAnimation != FriendProfileCardActivity.b(this.a)) {
        break label111;
      }
    }
    label106:
    label111:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      QLog.i("Q.profilecard.FrdProfileCard", 4, bool1 + "]");
      if (FriendProfileCardActivity.a(this.a) != null) {
        break label116;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.profilecard.FrdProfileCard", 4, "centerView is null");
      }
      return;
      bool1 = false;
      break;
    }
    label116:
    if (paramAnimation == FriendProfileCardActivity.b(this.a)) {
      FriendProfileCardActivity.a(this.a).setVisibility(8);
    }
    FriendProfileCardActivity.a(this.a).clearAnimation();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    boolean bool2 = true;
    boolean bool1;
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("onAnimationStart, [");
      if (paramAnimation == FriendProfileCardActivity.a(this.a))
      {
        bool1 = true;
        localStringBuilder = localStringBuilder.append(bool1).append(",");
        if (paramAnimation != FriendProfileCardActivity.b(this.a)) {
          break label111;
        }
        bool1 = bool2;
        label61:
        QLog.i("Q.profilecard.FrdProfileCard", 4, bool1 + "]");
      }
    }
    else
    {
      if (FriendProfileCardActivity.a(this.a) != null) {
        break label116;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.profilecard.FrdProfileCard", 4, "centerView is null");
      }
    }
    label111:
    label116:
    while (paramAnimation != FriendProfileCardActivity.a(this.a))
    {
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label61;
    }
    FriendProfileCardActivity.a(this.a).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cmz
 * JD-Core Version:    0.7.0.1
 */