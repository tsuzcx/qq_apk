import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.profile.view.ProfileTagView;
import com.tencent.mobileqq.profile.view.VipTagView;

public class alhe
  extends AnimatorListenerAdapter
{
  public alhe(ProfileTagView paramProfileTagView, boolean paramBoolean, VipTagView paramVipTagView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if ((this.cwP) && (this.this$0.a.e.pa != 0) && (this.a.getTag(2131375588) != null) && (this.a.getTag(2131375588).equals(Boolean.valueOf(true))))
    {
      this.a.setTag(2131375588, Boolean.valueOf(false));
      this.this$0.a(this.a, ((Long)this.a.getTag(2131375590)).longValue());
      return;
    }
    this.a.setShakingState(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alhe
 * JD-Core Version:    0.7.0.1
 */