import android.content.res.Resources;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.profile.view.ProfileTagView;
import com.tencent.mobileqq.profile.view.VipTagView;

public class alhb
  implements Animation.AnimationListener
{
  public alhb(ProfileTagView paramProfileTagView, VipTagView paramVipTagView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.this$0.a(this.a, true);
  }
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    if (this.this$0.a.e.pa != 0) {
      this.a.setTagColor(this.this$0.getResources().getColor(2131166849), this.this$0.getResources().getColor(2131166847));
    }
  }
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alhb
 * JD-Core Version:    0.7.0.1
 */