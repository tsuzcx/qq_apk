import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.biz.pubaccount.readinjoy.ugc.databinding.ObservableArrayList;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.ResultRecord;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.SelectMemberBuddyListAdapter.1.1;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class mou
  implements View.OnClickListener
{
  mou(mot parammot) {}
  
  public void onClick(View paramView)
  {
    QLog.d("FriendTeamListInnerFrameBuddyListAdapter", 2, "----->onBuddyListClick");
    mot.e locale = (mot.e)paramView.getTag();
    boolean bool;
    Object localObject;
    if ((locale != null) && (locale.checkBox != null) && (locale.item != null))
    {
      if (!locale.checkBox.isEnabled()) {
        break label214;
      }
      if (locale.checkBox.isChecked()) {
        break label193;
      }
      bool = true;
      locale.checkBox.setChecked(bool);
      if ((locale.item instanceof Friends))
      {
        localObject = (Friends)locale.item;
        localObject = ResultRecord.a(((Friends)localObject).uin, ((Friends)localObject).name, 1);
        if (!bool) {
          break label198;
        }
        this.this$0.b.add(localObject);
      }
      label116:
      if ((AppSetting.enableTalkBack) && (locale.checkBox.isChecked())) {}
      this.this$0.notifyDataSetChanged();
      if (AppSetting.enableTalkBack) {
        paramView.postDelayed(new SelectMemberBuddyListAdapter.1.1(this, paramView), 2000L);
      }
    }
    for (;;)
    {
      if (mot.a(this.this$0) != null) {
        mot.a(this.this$0).onClick(paramView);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label193:
      bool = false;
      break;
      label198:
      this.this$0.b.remove(localObject);
      break label116;
      label214:
      this.this$0.aQM();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mou
 * JD-Core Version:    0.7.0.1
 */