import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.activity.recent.DrawerFrame.IDrawerCallbacks;
import com.tencent.qphone.base.util.QLog;

public class cfi
  implements DrawerFrame.IDrawerCallbacks
{
  public cfi(Conversation paramConversation) {}
  
  public void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "onDrawerStartMoving");
    }
    if ((!Conversation.e(this.a)) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe != null) && (!this.a.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.c)) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.f();
    }
    if (!this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.b()) {
      this.a.m();
    }
  }
  
  @TargetApi(11)
  public void a(float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      if (Conversation.a(this.a) != null) {
        Conversation.a(this.a).setAlpha(1.0F - paramFloat);
      }
      if (this.a.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.a.jdField_a_of_type_AndroidWidgetTextView.setAlpha(1.0F - paramFloat);
      }
    }
  }
  
  public void a(int paramInt)
  {
    if ((!Conversation.e(this.a)) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.a();
    }
    this.a.a(paramInt, true);
    if (Build.VERSION.SDK_INT < 11)
    {
      if (Conversation.a(this.a) != null) {
        Conversation.a(this.a).setVisibility(8);
      }
      if (this.a.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
  }
  
  public void b(int paramInt)
  {
    if ((!Conversation.e(this.a)) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.b();
    }
    this.a.a(paramInt, false);
    if (Build.VERSION.SDK_INT < 11)
    {
      if (Conversation.a(this.a) != null) {
        Conversation.a(this.a).setVisibility(0);
      }
      if (this.a.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cfi
 * JD-Core Version:    0.7.0.1
 */