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

public class xyz
  implements View.OnClickListener
{
  public xyz(FriendTabView paramFriendTabView) {}
  
  public void onClick(View paramView)
  {
    QLog.d("FriendTabView", 2, "----->onBuddyListClick");
    ybp localybp = (ybp)paramView.getTag();
    String str;
    boolean bool;
    if ((localybp != null) && (localybp.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localybp.jdField_a_of_type_JavaLangObject != null))
    {
      str = "";
      if (!(localybp.jdField_a_of_type_JavaLangObject instanceof Friends)) {
        break label233;
      }
      str = ((Friends)localybp.jdField_a_of_type_JavaLangObject).getFriendNickWithAlias();
      if (localybp.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())
      {
        if (!localybp.jdField_a_of_type_JavaLangString.startsWith("+")) {
          break label259;
        }
        bool = this.a.a.a(localybp.jdField_a_of_type_JavaLangString, str, 4, "-1", "");
        label110:
        if (QLog.isDevelopLevel()) {
          QLog.d("FriendTabView", 2, "----->onBuddyListClick = " + bool);
        }
        localybp.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
        if (AppSetting.b)
        {
          if (!localybp.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
            break label284;
          }
          paramView.setContentDescription(localybp.d.getText().toString() + "已选中,双击取消");
        }
      }
    }
    for (;;)
    {
      this.a.c();
      if (AppSetting.b) {
        paramView.postDelayed(new xza(this, paramView), 2000L);
      }
      return;
      label233:
      if (!(localybp.jdField_a_of_type_JavaLangObject instanceof PhoneContact)) {
        break;
      }
      str = ((PhoneContact)localybp.jdField_a_of_type_JavaLangObject).name;
      break;
      label259:
      bool = this.a.a.a(localybp.jdField_a_of_type_JavaLangString, str, 0, "-1", "");
      break label110;
      label284:
      paramView.setContentDescription(localybp.d.getText().toString() + "未选中,双击选中");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xyz
 * JD-Core Version:    0.7.0.1
 */