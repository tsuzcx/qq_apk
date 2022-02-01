import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.ChatSettingForTroop.33.1;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import tencent.im.oidb.cmd0xea4.oidb_0xea4.ExtraInfo;
import tencent.im.oidb.cmd0xea4.oidb_0xea4.RspBody;

public class uqe
  extends acnd
{
  public uqe(ChatSettingForTroop paramChatSettingForTroop) {}
  
  protected void a(oidb_0xea4.RspBody paramRspBody, int paramInt)
  {
    if (paramRspBody.group_id.has())
    {
      localObject = String.valueOf(paramRspBody.group_id.get());
      if ((this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (!TextUtils.equals(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, (CharSequence)localObject))) {
        if (QLog.isColorLevel()) {
          QLog.e("Q.chatopttroop", 2, "onGetNewTroopAppList troopUin not match. rsp uin=" + (String)localObject + ", current uin=" + this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      Object localObject;
      do
      {
        do
        {
          return;
        } while (paramInt != 3);
        if (QLog.isColorLevel()) {
          QLog.d("raymondguo", 2, "game feed service type 3 refresh");
        }
        localObject = this.this$0.p[28];
      } while (localObject == null);
      if (paramRspBody.extra_info.tab_infos.size() > 0)
      {
        ((View)localObject).setVisibility(0);
        this.this$0.fI(paramRspBody.extra_info.tab_infos.get());
        return;
      }
      ((View)localObject).setVisibility(8);
      return;
    }
    QLog.e("Q.chatopttroop", 2, "onGetNewTroopAppList service 3 group_id lost. current uin=" + this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
  }
  
  protected void c(boolean paramBoolean, int paramInt, long paramLong, ArrayList<aptv> paramArrayList)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("RobotMemberFormItem onGetAddedRobots suc:").append(paramBoolean).append(" retCode:").append(paramInt).append(" troopuin:").append(paramLong).append(" infos:");
      if (paramArrayList != null) {
        break label90;
      }
    }
    label90:
    for (String str = "null";; str = paramArrayList.toString())
    {
      QLog.d("Q.chatopttroop", 2, str);
      this.this$0.runOnUiThread(new ChatSettingForTroop.33.1(this, paramArrayList));
      return;
    }
  }
  
  protected void eE(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if (QLog.isColorLevel())
    {
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) {
        bool = true;
      }
      QLog.d("Q.chatopttroop", 2, new Object[] { "onTroopManagerFailed. reqType=", Integer.valueOf(paramInt1), ", result=", Integer.valueOf(paramInt2), ", hasTroopInfoData=", Boolean.valueOf(bool) });
    }
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    do
    {
      return;
      if ((1 == paramInt1) && ((this.this$0.isResume()) || (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption == 1)))
      {
        this.this$0.ath();
        apuh.t(this.this$0, paramInt2);
        this.this$0.authKey = null;
        return;
      }
    } while ((!this.this$0.isResume()) || ((paramInt1 != 2) && (paramInt1 != 9)));
    if (this.this$0.jdField_a_of_type_Arib == null) {
      this.this$0.jdField_a_of_type_Arib = new arib(this.this$0);
    }
    this.this$0.jdField_a_of_type_Arib.aq(2, 2131693293, 1500);
    this.this$0.finish();
  }
  
  protected void q(int paramInt1, int paramInt2, String paramString)
  {
    Object localObject;
    boolean bool;
    if (QLog.isColorLevel())
    {
      if (TextUtils.isEmpty(paramString))
      {
        localObject = "";
        if (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {
          break label107;
        }
        bool = true;
        label30:
        QLog.d("Q.chatopttroop", 2, new Object[] { "onTroopManagerSuccess. reqType=", Integer.valueOf(paramInt1), ", result=", Integer.valueOf(paramInt2), ", troopUin=", localObject, ", hasTroopInfoData=", Boolean.valueOf(bool) });
      }
    }
    else {
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) {
        break label113;
      }
    }
    label107:
    label113:
    do
    {
      for (;;)
      {
        return;
        localObject = paramString;
        break;
        bool = false;
        break label30;
        if ((1 == paramInt1) && ((this.this$0.isResume()) || (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption == 1)))
        {
          this.this$0.ath();
          if (this.this$0.jdField_a_of_type_Arib == null) {
            this.this$0.jdField_a_of_type_Arib = new arib(this.this$0);
          }
          switch (paramInt2)
          {
          case -1: 
          default: 
            this.this$0.jdField_a_of_type_Arib.aq(2, 2131695144, 1500);
          }
          for (;;)
          {
            this.this$0.authKey = null;
            return;
            ((acms)this.this$0.app.getBusinessHandler(20)).ad(Long.parseLong(paramString), Long.parseLong(this.this$0.app.getAccount()));
            continue;
            this.this$0.jdField_a_of_type_Arib.aq(2, 2131695145, 1500);
            this.this$0.finish();
            ChatSettingForTroop.a(this.this$0, true);
            localObject = (TroopManager)this.this$0.app.getManager(52);
            if (localObject != null)
            {
              ((TroopManager)localObject).l(((TroopManager)localObject).b(paramString));
              continue;
              this.this$0.jdField_a_of_type_Arib.aq(2, 2131721390, 1500);
            }
          }
        }
        if (this.this$0.isResume())
        {
          if (paramInt1 != 3) {
            break label539;
          }
          if (paramInt2 == 0)
          {
            paramString = (TroopManager)this.this$0.app.getManager(52);
            if (paramString == null) {}
            for (paramString = null;; paramString = paramString.b(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))
            {
              if ((paramString == null) || (paramString.wMemberNum == this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum)) {
                break label537;
              }
              this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateTroopAdmMemberNum(paramString.Administrator, paramString.wMemberNum, this.this$0.app.getCurrentAccountUin(), this.this$0.getResources());
              if (this.this$0.tR == null) {
                break;
              }
              this.this$0.tR.setText(acfp.m(2131703770) + this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum + acfp.m(2131703772));
              return;
            }
          }
        }
      }
    } while (((paramInt1 != 2) && (paramInt1 != 9)) || (paramInt2 != 0));
    label537:
    label539:
    paramString = new Intent();
    paramString.putExtra("isNeedFinish", true);
    this.this$0.setResult(-1, paramString);
    this.this$0.finish();
  }
  
  protected void uX(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, String.format("onGetAddTroopWebInfo url=%s", new Object[] { paramString }));
    }
    if (!this.this$0.isResume()) {
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      QQToast.a(this.this$0, 2, 2131718833, 1).show(this.this$0.getTitleBarHeight());
    }
    for (;;)
    {
      this.this$0.finish();
      return;
      paramString = paramString + "?_wv=1031&troopUin=" + this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin + "&isVerify=" + 0;
      Intent localIntent = new Intent(this.this$0, QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("hide_left_button", true);
      localIntent.putExtra("show_right_close_button", true);
      localIntent.putExtra("finish_animation_up_down", true);
      this.this$0.startActivity(localIntent);
      this.this$0.overridePendingTransition(2130772009, 2130772002);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uqe
 * JD-Core Version:    0.7.0.1
 */