import android.content.Intent;
import android.view.animation.Animation;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsActivity;
import com.tencent.mobileqq.util.ThreadPriorityManager;
import com.tencent.util.AnimateUtils.AnimationAdapter;

class wdw
  extends AnimateUtils.AnimationAdapter
{
  wdw(wdv paramwdv) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.a = true;
    paramAnimation = new Intent(this.a.a, SearchContactsActivity.class);
    paramAnimation.putExtra("from_key", this.a.a.a());
    paramAnimation.putExtra("fromType", 13);
    this.a.a.startActivity(paramAnimation);
    this.a.a.overridePendingTransition(0, 0);
    ThreadPriorityManager.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wdw
 * JD-Core Version:    0.7.0.1
 */