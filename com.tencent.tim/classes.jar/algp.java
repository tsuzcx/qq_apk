import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.qphone.base.util.QLog;

public class algp
  extends auqs.a
{
  public algp(ProfileHeaderView paramProfileHeaderView, LinearLayout paramLinearLayout, View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ProfileHeaderView.TAG, 2, "ProfileHeaderView updateTips sideOutAnim onAnimationEnd");
    }
    this.jT.removeAllViews();
    this.jT.addView(this.FZ);
    paramAnimation = AnimationUtils.loadAnimation(this.this$0.mActivity, 2130772336);
    paramAnimation.setFillAfter(true);
    this.FZ.startAnimation(paramAnimation);
    if (this.this$0.dth < 4)
    {
      paramAnimation = this.this$0;
      paramAnimation.dth += 1;
      paramAnimation = this.this$0.i.obtainMessage(ProfileHeaderView.dti);
      this.this$0.i.sendMessageDelayed(paramAnimation, 4000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     algp
 * JD-Core Version:    0.7.0.1
 */