import android.animation.ValueAnimator;
import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView;
import com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView.a;
import com.tencent.mobileqq.app.QQAppInterface;

public class ymw
  implements ContactBaseView.a
{
  public ymw(AddContactsActivity paramAddContactsActivity) {}
  
  public void cjO()
  {
    if (this.a.bnD) {
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, -(this.a.getTitleBarHeight() + 0 + AddContactsActivity.a(this.a).xg()) });
    localValueAnimator.setDuration(250L);
    localValueAnimator.addUpdateListener(new ymx(this));
    localValueAnimator.addListener(new ymy(this));
    localValueAnimator.start();
    aqfp.Sz(true);
  }
  
  public void cjP()
  {
    this.a.findViewById(2131377498).setVisibility(0);
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { -(this.a.getTitleBarHeight() + 0 + AddContactsActivity.a(this.a).xg()), 0 });
    localValueAnimator.setDuration(250L);
    localValueAnimator.addUpdateListener(new ymz(this));
    localValueAnimator.addListener(new yna(this));
    localValueAnimator.start();
  }
  
  public Activity getActivity()
  {
    return this.a;
  }
  
  public QQAppInterface getApp()
  {
    return this.a.app;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ymw
 * JD-Core Version:    0.7.0.1
 */