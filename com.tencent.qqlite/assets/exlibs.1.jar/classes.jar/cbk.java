import android.content.Intent;
import android.view.animation.Animation;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsActivity;
import com.tencent.mobileqq.util.ThreadPriorityManager;
import com.tencent.util.AnimateUtils.AnimationAdapter;

class cbk
  extends AnimateUtils.AnimationAdapter
{
  cbk(cbj paramcbj) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.a = true;
    paramAnimation = new Intent(this.a.a, SearchContactsActivity.class);
    paramAnimation.putExtra("from_key", this.a.a.a());
    this.a.a.startActivity(paramAnimation);
    this.a.a.overridePendingTransition(0, 0);
    ThreadPriorityManager.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cbk
 * JD-Core Version:    0.7.0.1
 */