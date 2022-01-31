import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatBackgroundSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ach
  implements View.OnClickListener
{
  public ach(ChatBackgroundSettingActivity paramChatBackgroundSettingActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.c();
    Object localObject = this.a.d;
    this.a.d = "null";
    paramView.findViewById(2131296796).setVisibility(0);
    paramView.findViewById(2131296795).setContentDescription(this.a.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131364376, new Object[] { Integer.valueOf(this.a.b + 1) }));
    this.a.b = -1;
    if (localObject != null)
    {
      paramView = (View)localObject;
      if (((String)localObject).trim().length() != 0) {}
    }
    else
    {
      paramView = "null";
    }
    String str = this.a.d;
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
      QLog.d(ChatBackgroundSettingActivity.jdField_a_of_type_JavaLangString, 2, "oldPicPath is:" + paramView + ",newPicPath is:" + (String)localObject);
    }
    if (!paramView.equals(localObject))
    {
      if ((this.a.c == null) || (this.a.c.trim().length() == 0)) {
        ChatBackgroundSettingActivity.a(this.a, this.a.app.a());
      }
      this.a.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ach
 * JD-Core Version:    0.7.0.1
 */