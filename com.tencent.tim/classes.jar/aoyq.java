import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troop.createNewTroop.ContactListAdapter.2.1;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopContactView;
import com.tencent.mobileqq.troop.createNewTroop.RelationTroopEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aoyq
  implements View.OnClickListener
{
  aoyq(aoyo paramaoyo) {}
  
  public void onClick(View paramView)
  {
    QLog.d("createNewTroop.ContactListAdapter", 2, "----->onBuddyListClick");
    aoyo.e locale = (aoyo.e)paramView.getTag();
    Object localObject;
    boolean bool;
    if ((locale != null) && (locale.checkBox != null) && (locale.item != null))
    {
      localObject = "";
      if (!(locale.item instanceof Friends)) {
        break label263;
      }
      localObject = ((Friends)locale.item).getFriendNickWithAlias();
      if (locale.checkBox.isEnabled())
      {
        if (!locale.uin.startsWith("+")) {
          break label329;
        }
        bool = this.this$0.a.a(locale.uin, (String)localObject, 4, "-1");
        label108:
        if (QLog.isDevelopLevel()) {
          QLog.d("createNewTroop.ContactListAdapter", 2, "----->onBuddyListClick = " + bool);
        }
        if (locale.groupId == 1007L) {
          this.this$0.b.dYc();
        }
        locale.checkBox.setChecked(bool);
        if (AppSetting.enableTalkBack)
        {
          if (!locale.checkBox.isChecked()) {
            break label352;
          }
          paramView.setContentDescription(locale.rc.getText().toString() + acfp.m(2131704406));
        }
      }
    }
    for (;;)
    {
      this.this$0.cnv();
      if (AppSetting.enableTalkBack) {
        paramView.postDelayed(new ContactListAdapter.2.1(this, paramView), 2000L);
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        label263:
        if ((locale.item instanceof PhoneContact))
        {
          localObject = ((PhoneContact)locale.item).name;
          break;
        }
        if (!(locale.item instanceof RelationTroopEntity)) {
          break;
        }
        localObject = (RelationTroopEntity)locale.item;
        this.this$0.a.Bf(((RelationTroopEntity)localObject).troopInfo.troopuin);
      }
      label329:
      bool = this.this$0.a.a(locale.uin, (String)localObject, 0, "-1");
      break label108;
      label352:
      paramView.setContentDescription(locale.rc.getText().toString() + acfp.m(2131704405));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoyq
 * JD-Core Version:    0.7.0.1
 */