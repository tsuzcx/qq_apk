import android.app.Activity;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView;
import com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView.IAddContactContext;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.ThreadPriorityManager;

public class cbj
  implements ContactBaseView.IAddContactContext
{
  public cbj(AddContactsActivity paramAddContactsActivity) {}
  
  public Activity a()
  {
    return this.a;
  }
  
  public QQAppInterface a()
  {
    return this.a.app;
  }
  
  public void a()
  {
    if (this.a.jdField_a_of_type_Boolean) {
      return;
    }
    AddContactsActivity.a(this.a, 2130837633);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -(this.a.getTitleBarHeight() + AddContactsActivity.a(this.a).a()));
    localTranslateAnimation.setDuration(250L);
    localTranslateAnimation.setFillAfter(true);
    localTranslateAnimation.setAnimationListener(new cbk(this));
    this.a.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(localTranslateAnimation);
    ThreadPriorityManager.a(true);
  }
  
  public void b()
  {
    this.a.findViewById(2131297145).setVisibility(0);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -(this.a.getTitleBarHeight() + AddContactsActivity.a(this.a).a()), 0.0F);
    localTranslateAnimation.setDuration(250L);
    localTranslateAnimation.setFillAfter(true);
    localTranslateAnimation.setAnimationListener(new cbl(this));
    this.a.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(localTranslateAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cbj
 * JD-Core Version:    0.7.0.1
 */