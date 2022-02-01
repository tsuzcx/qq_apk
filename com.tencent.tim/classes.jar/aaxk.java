import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.selectmember.PhoneContactTabView;
import com.tencent.mobileqq.activity.selectmember.PhoneContactTabView.a;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aaxk
  implements View.OnClickListener
{
  public aaxk(PhoneContactTabView.a parama) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131365942) {}
    aaxn localaaxn;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localaaxn = (aaxn)paramView.getTag();
      if ((localaaxn != null) && (localaaxn.checkBox != null) && (localaaxn.c != null))
      {
        PhoneContact localPhoneContact = localaaxn.c;
        if (localaaxn.checkBox.isEnabled())
        {
          if (localaaxn.uin.startsWith("+")) {}
          for (boolean bool = this.b.a.a.a(localaaxn.uin, localPhoneContact.name, 4, "-1", localPhoneContact.mobileNo);; bool = this.b.a.a.a(localaaxn.uin, localPhoneContact.name, 0, "-1", localPhoneContact.mobileNo))
          {
            localaaxn.checkBox.setChecked(bool);
            if (!AppSetting.enableTalkBack) {
              break;
            }
            if (!localaaxn.checkBox.isChecked()) {
              break label266;
            }
            if (!localaaxn.bAI) {
              break label225;
            }
            paramView.setContentDescription(localaaxn.fe.getText() + this.b.a.a.getString(2131719454));
            break;
          }
          label225:
          paramView.setContentDescription(localaaxn.fe.getText().toString() + acfp.m(2131709501));
        }
      }
    }
    label266:
    if (localaaxn.bAI) {}
    for (int i = this.b.a.a.bY(localaaxn.uin);; i = 0)
    {
      if ((localaaxn.bAI) && (i != 0))
      {
        paramView.setContentDescription(localaaxn.fe.getText() + this.b.a.a.getString(i));
        break;
      }
      paramView.setContentDescription(localaaxn.fe.getText().toString() + acfp.m(2131709498));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaxk
 * JD-Core Version:    0.7.0.1
 */