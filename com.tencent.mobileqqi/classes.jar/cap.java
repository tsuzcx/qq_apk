import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatBackgroundSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class cap
  implements View.OnClickListener
{
  public cap(ChatBackgroundSettingActivity paramChatBackgroundSettingActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.b();
    Object localObject = this.a.jdField_b_of_type_JavaLangString;
    this.a.jdField_b_of_type_JavaLangString = "null";
    paramView.findViewById(2131231326).setVisibility(0);
    this.a.jdField_b_of_type_Int = -1;
    if (localObject != null)
    {
      paramView = (View)localObject;
      if (((String)localObject).trim().length() != 0) {}
    }
    else
    {
      paramView = "null";
    }
    String str = this.a.jdField_b_of_type_JavaLangString;
    if (str != null)
    {
      localObject = str;
      if (str.trim().length() != 0) {}
    }
    else
    {
      localObject = "null";
    }
    if (QLog.isColorLevel()) {
      QLog.d(ChatBackgroundSettingActivity.c(), 2, "oldPicPath is:" + paramView + ",newPicPath is:" + (String)localObject);
    }
    if (!paramView.equals(localObject))
    {
      if ((ChatBackgroundSettingActivity.a(this.a) == null) || (ChatBackgroundSettingActivity.a(this.a).trim().length() == 0)) {
        ChatBackgroundSettingActivity.a(this.a, this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
      }
      this.a.v_();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cap
 * JD-Core Version:    0.7.0.1
 */