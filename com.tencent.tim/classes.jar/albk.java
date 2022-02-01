import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabel;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelInfo;
import java.util.Iterator;
import java.util.List;

public class albk
  implements Animator.AnimatorListener
{
  public albk(PersonalityLabelGalleryActivity paramPersonalityLabelGalleryActivity, long paramLong) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = PersonalityLabelGalleryActivity.a(this.this$0).personalityLabelInfos.iterator();
    while (paramAnimator.hasNext())
    {
      PersonalityLabelInfo localPersonalityLabelInfo = (PersonalityLabelInfo)paramAnimator.next();
      if (this.afZ == localPersonalityLabelInfo.id)
      {
        PersonalityLabelGalleryActivity.a(this.this$0).personalityLabelInfos.remove(localPersonalityLabelInfo);
        paramAnimator = PersonalityLabelGalleryActivity.a(this.this$0);
        paramAnimator.remainCount += 1;
        this.this$0.b(PersonalityLabelGalleryActivity.a(this.this$0), false);
        PersonalityLabelGalleryActivity.b(this.this$0, true);
        if ((!this.this$0.atl()) && (this.this$0.cvT)) {
          PersonalityLabelGalleryActivity.a(this.this$0, false);
        }
        if (this.this$0.mSubHandler.hasMessages(0)) {
          this.this$0.mSubHandler.removeMessages(0);
        }
        paramAnimator = this.this$0.mSubHandler.obtainMessage(0, PersonalityLabelGalleryActivity.a(this.this$0));
        this.this$0.mSubHandler.sendMessageDelayed(paramAnimator, 500L);
      }
    }
    ((albz)this.this$0.app.getBusinessHandler(112)).kD(this.afZ);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     albk
 * JD-Core Version:    0.7.0.1
 */