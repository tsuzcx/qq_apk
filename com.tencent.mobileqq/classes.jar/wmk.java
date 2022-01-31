import android.app.Activity;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView;
import com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView.IAddContactContext;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.ThreadPriorityManager;
import com.tencent.mobileqq.widget.TabBarView;

public class wmk
  implements ContactBaseView.IAddContactContext
{
  public wmk(AddContactsActivity paramAddContactsActivity) {}
  
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
    AddContactsActivity.a(this.a, 2130838219);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -(this.a.getTitleBarHeight() + AddContactsActivity.a(this.a).getHeight() + AddContactsActivity.a(this.a).a()));
    localTranslateAnimation.setDuration(250L);
    localTranslateAnimation.setFillAfter(true);
    localTranslateAnimation.setAnimationListener(new wml(this));
    this.a.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(localTranslateAnimation);
    ThreadPriorityManager.a(true);
  }
  
  public void b()
  {
    this.a.findViewById(2131362867).setVisibility(0);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -(this.a.getTitleBarHeight() + AddContactsActivity.a(this.a).getHeight() + AddContactsActivity.a(this.a).a()), 0.0F);
    localTranslateAnimation.setDuration(250L);
    localTranslateAnimation.setFillAfter(true);
    localTranslateAnimation.setAnimationListener(new wmm(this));
    this.a.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(localTranslateAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wmk
 * JD-Core Version:    0.7.0.1
 */