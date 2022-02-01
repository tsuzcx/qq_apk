import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.activity.TroopTagViewActivity;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class uqb
  extends Handler
{
  public uqb(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((this.this$0.isDestory) || (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null)) {}
    do
    {
      do
      {
        do
        {
          return;
          switch (paramMessage.what)
          {
          default: 
            return;
          case 1: 
            this.this$0.init();
            return;
          case 6: 
            if (QLog.isColorLevel()) {
              QLog.i("Q.chatopttroop", 2, "MSG_UPDATE_TROOP_MEMBER_CARD");
            }
            break;
          }
        } while (this.this$0.p == null);
        paramMessage = (FormSimpleItem)this.this$0.p[6];
      } while (paramMessage == null);
      if (!TextUtils.isEmpty(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.chatopttroop", 2, "handle MSG_UPDATE_TROOP_MEMBER_CARD message and update nick");
        }
        localObject1 = new aofe(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick, 16).k();
        paramMessage.setRightText((CharSequence)localObject1);
        aqpm.a(this.this$0.app, paramMessage.a(), (Spannable)localObject1);
        return;
      }
      paramMessage.setRightText(this.this$0.getString(2131699791));
      aqpm.a(this.this$0.app, paramMessage.a(), new SpannableString(""));
      return;
      localObject2 = this.this$0.p[4];
    } while (localObject2 == null);
    Object localObject1 = null;
    if (paramMessage.obj != null) {
      localObject1 = (String)paramMessage.obj;
    }
    ChatSettingForTroop.a(this.this$0, (View)localObject2, (String)localObject1);
    return;
    if (QLog.isColorLevel()) {
      QLog.i("Q.chatopttroop", 2, "MSG_UPDATE_INFO");
    }
    if (this.this$0.tR != null) {
      this.this$0.tR.setText(acfp.m(2131703771) + this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum + acfp.m(2131703777));
    }
    this.this$0.ww(true);
    this.this$0.bLc();
    this.this$0.fH(this.this$0.qC);
    ChatSettingForTroop.j(this.this$0);
    return;
    Object localObject2 = this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags;
    localObject1 = new Intent(this.this$0, TroopTagViewActivity.class);
    ((Intent)localObject1).putExtra("troopuin", this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    ((Intent)localObject1).putExtra("isAdmin", false);
    paramMessage = "";
    int i;
    if (!TextUtils.isEmpty(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopClassExtText))
    {
      paramMessage = this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopClassExtText;
      i = 1;
    }
    for (;;)
    {
      if (i != 0) {
        ((Intent)localObject1).putExtra("subclass", paramMessage);
      }
      Object localObject3;
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        paramMessage = new StringBuffer();
        localObject2 = ((List)localObject2).iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (String)((Iterator)localObject2).next();
            paramMessage.append((String)localObject3 + "\n");
            continue;
            if ((this.this$0.jdField_a_of_type_Apyg == null) || (TextUtils.isEmpty(this.this$0.jdField_a_of_type_Apyg.name))) {
              break label1404;
            }
            if (acfp.m(2131703764).equals(this.this$0.jdField_a_of_type_Apyg.name))
            {
              i = 0;
              break;
            }
            paramMessage = this.this$0.jdField_a_of_type_Apyg.name;
            i = 1;
            break;
          }
        }
        paramMessage.deleteCharAt(paramMessage.length() - 1);
        ((Intent)localObject1).putExtra("tags", paramMessage.toString());
      }
      ((Intent)localObject1).putExtra("act_type", 1);
      ((Intent)localObject1).putExtra("uin", this.this$0.app.getCurrentAccountUin());
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
      {
        this.this$0.startActivityForResult((Intent)localObject1, 11);
        return;
      }
      this.this$0.startActivity((Intent)localObject1);
      return;
      View localView1 = this.this$0.p[8];
      View localView2 = this.this$0.p[9];
      Switch localSwitch;
      if ((localView2 != null) && (localView1 != null) && ((localView1 instanceof FormSwitchItem)))
      {
        localObject2 = (FormSimpleItem)localView2.findViewById(2131369545);
        localSwitch = ((FormSwitchItem)localView1).a();
        localObject3 = (TextView)localView2.findViewById(2131369234);
        ((TextView)localObject3).setBackgroundResource(2130839684);
        localObject1 = "";
        paramMessage = "";
        Boolean localBoolean = (Boolean)this.this$0.jdField_a_of_type_Aqlz.jb.get(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        if ((localBoolean != null) && (localBoolean.booleanValue())) {
          break label1204;
        }
        if (this.this$0.b == null) {
          break;
        }
        i = this.this$0.b.troopmask;
        if (i != 1) {
          break label1045;
        }
        localView1.setBackgroundResource(2130839689);
        localView1.getBackground().setAlpha(255);
        if (localSwitch.isChecked())
        {
          localSwitch.setTag(Boolean.TRUE);
          localSwitch.setChecked(false);
        }
        localView2.setVisibility(8);
        paramMessage = "";
        localObject1 = "";
        this.this$0.pK.setVisibility(8);
        if (ChatSettingForTroop.a(this.this$0) != null) {
          ChatSettingForTroop.d(this.this$0);
        }
      }
      for (;;)
      {
        ((FormSimpleItem)localObject2).setRightText(new aofk((CharSequence)localObject1, 3));
        ((TextView)localObject3).setText(paramMessage);
        ((TextView)localObject3).setTextColor(this.this$0.getResources().getColor(2131167379));
        aizp.a().an(this.this$0.app, this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        return;
        label1045:
        localView1.setBackgroundResource(2130839695);
        localView1.getBackground().setAlpha(255);
        if (!localSwitch.isChecked())
        {
          localSwitch.setTag(Boolean.TRUE);
          localSwitch.setChecked(true);
        }
        localView2.setVisibility(0);
        switch (i)
        {
        default: 
          paramMessage = "";
          localObject1 = "";
          break;
        case 2: 
          localObject1 = this.this$0.getString(2131699864);
          paramMessage = this.this$0.getString(2131699866);
          break;
        case 3: 
          localObject1 = this.this$0.getString(2131694520);
          paramMessage = this.this$0.getString(2131699862);
          break;
        case 4: 
          localObject1 = this.this$0.getString(2131699868);
          paramMessage = this.this$0.getString(2131699870);
          break;
          label1204:
          localView2.setVisibility(0);
          localView1.setBackgroundResource(2130839695);
          localView1.getBackground().setAlpha(255);
          this.this$0.pK.setVisibility(0);
        }
      }
      paramMessage = this.this$0.p[27];
      if (paramMessage != null)
      {
        localObject1 = (TextView)paramMessage.findViewById(2131379769);
        if (localObject1 != null)
        {
          ((TextView)localObject1).setTextColor(Color.parseColor("#00b6f9"));
          if ("1103".equals(ThemeUtil.getCurrentThemeId())) {
            ((TextView)localObject1).setAlpha(0.5F);
          }
        }
        paramMessage = (ProgressBar)paramMessage.findViewById(2131373615);
        if (paramMessage != null) {
          paramMessage.setVisibility(8);
        }
      }
      QQToast.a(this.this$0, 2, this.this$0.getString(2131691525), 0).show();
      return;
      i = paramMessage.arg1;
      paramMessage = this.this$0.p[30];
      if (!(paramMessage instanceof FormSimpleItem)) {
        break;
      }
      localObject1 = (FormSimpleItem)paramMessage;
      if (i == 0) {}
      for (paramMessage = null;; paramMessage = this.this$0.getResources().getDrawable(2130851400))
      {
        ((FormSimpleItem)localObject1).setRightIcon(paramMessage);
        return;
      }
      label1404:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uqb
 * JD-Core Version:    0.7.0.1
 */