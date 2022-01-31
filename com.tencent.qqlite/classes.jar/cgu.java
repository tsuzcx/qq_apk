import android.app.Dialog;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.phone.ContactListView;

public class cgu
  implements Animation.AnimationListener
{
  public cgu(ContactListView paramContactListView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    ContactListView.a(this.a).show();
    this.a.b.setAnimation(null);
    this.a.a.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cgu
 * JD-Core Version:    0.7.0.1
 */