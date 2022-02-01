import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.selectmember.FriendTabView;
import com.tencent.mobileqq.activity.selectmember.FriendTabView.3.1;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aaxb
  implements View.OnClickListener
{
  public aaxb(FriendTabView paramFriendTabView) {}
  
  public void onClick(View paramView)
  {
    QLog.d("FriendTabView", 2, "----->onBuddyListClick");
    aayg.e locale = (aayg.e)paramView.getTag();
    String str;
    boolean bool;
    if ((locale != null) && (locale.checkBox != null) && (locale.item != null))
    {
      str = "";
      if (!(locale.item instanceof Friends)) {
        break label243;
      }
      str = ((Friends)locale.item).getFriendNickWithAlias();
      if (locale.checkBox.isEnabled())
      {
        if (!locale.uin.startsWith("+")) {
          break label269;
        }
        bool = this.a.a.a(locale.uin, str, 4, "-1", "");
        label110:
        if (QLog.isDevelopLevel()) {
          QLog.d("FriendTabView", 2, "----->onBuddyListClick = " + bool);
        }
        locale.checkBox.setChecked(bool);
        if (AppSetting.enableTalkBack)
        {
          if (!locale.checkBox.isChecked()) {
            break label294;
          }
          paramView.setContentDescription(locale.rc.getText().toString() + acfp.m(2131706648));
        }
      }
    }
    for (;;)
    {
      this.a.notifyDataSetChanged();
      if (AppSetting.enableTalkBack) {
        paramView.postDelayed(new FriendTabView.3.1(this, paramView), 2000L);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label243:
      if (!(locale.item instanceof PhoneContact)) {
        break;
      }
      str = ((PhoneContact)locale.item).name;
      break;
      label269:
      bool = this.a.a.a(locale.uin, str, 0, "-1", "");
      break label110;
      label294:
      paramView.setContentDescription(locale.rc.getText().toString() + acfp.m(2131706649));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaxb
 * JD-Core Version:    0.7.0.1
 */