import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.selectmember.FriendTabView;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.qphone.base.util.QLog;

public class xvt
  implements View.OnClickListener
{
  public xvt(FriendTabView paramFriendTabView) {}
  
  public void onClick(View paramView)
  {
    QLog.d("FriendTabView", 2, "----->onBuddyListClick");
    xyi localxyi = (xyi)paramView.getTag();
    String str;
    boolean bool;
    if ((localxyi != null) && (localxyi.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localxyi.jdField_a_of_type_JavaLangObject != null))
    {
      str = "";
      if (!(localxyi.jdField_a_of_type_JavaLangObject instanceof Friends)) {
        break label233;
      }
      str = ((Friends)localxyi.jdField_a_of_type_JavaLangObject).getFriendNickWithAlias();
      if (localxyi.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())
      {
        if (!localxyi.jdField_a_of_type_JavaLangString.startsWith("+")) {
          break label259;
        }
        bool = this.a.a.a(localxyi.jdField_a_of_type_JavaLangString, str, 4, "-1", "");
        label110:
        if (QLog.isDevelopLevel()) {
          QLog.d("FriendTabView", 2, "----->onBuddyListClick = " + bool);
        }
        localxyi.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
        if (AppSetting.b)
        {
          if (!localxyi.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
            break label284;
          }
          paramView.setContentDescription(localxyi.d.getText().toString() + "已选中,双击取消");
        }
      }
    }
    for (;;)
    {
      this.a.c();
      if (AppSetting.b) {
        paramView.postDelayed(new xvu(this, paramView), 2000L);
      }
      return;
      label233:
      if (!(localxyi.jdField_a_of_type_JavaLangObject instanceof PhoneContact)) {
        break;
      }
      str = ((PhoneContact)localxyi.jdField_a_of_type_JavaLangObject).name;
      break;
      label259:
      bool = this.a.a.a(localxyi.jdField_a_of_type_JavaLangString, str, 0, "-1", "");
      break label110;
      label284:
      paramView.setContentDescription(localxyi.d.getText().toString() + "未选中,双击选中");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xvt
 * JD-Core Version:    0.7.0.1
 */