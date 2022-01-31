import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class bob
  extends TroopObserver
{
  public bob(TroopMemberCardActivity paramTroopMemberCardActivity) {}
  
  protected void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "onSetTroopAdminFail: errorCode=" + paramInt);
    }
    this.a.l();
    Object localObject;
    switch (paramInt)
    {
    case 5: 
    case 6: 
    default: 
      localObject = this.a.getString(2131362864);
      this.a.a(1, (String)localObject);
      return;
    case 4: 
      localObject = (FriendsManagerImp)this.a.app.getManager(8);
      if (localObject != null)
      {
        localObject = ((FriendsManagerImp)localObject).a(this.a.c);
        if (localObject == null) {
          break;
        }
      }
      break;
    }
    for (paramInt = ((TroopInfo)localObject).maxAdminNum;; paramInt = 0)
    {
      if (paramInt > 0)
      {
        localObject = String.format(this.a.getString(2131362868), new Object[] { Integer.valueOf(paramInt) });
        break;
      }
      localObject = this.a.getString(2131362869);
      break;
      localObject = this.a.getString(2131362870);
      break;
    }
  }
  
  protected void a(String paramString1, String paramString2, byte paramByte)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "onSetTroopAdminSuccess: mTroopUin=" + paramString1 + " memberUin=" + paramString2 + " operation=" + paramByte);
    }
    TroopInfo localTroopInfo;
    if ((this.a.c.equals(paramString1)) && (this.a.e.equals(paramString2)))
    {
      paramString1 = (FriendsManagerImp)this.a.app.getManager(8);
      localTroopInfo = paramString1.a(this.a.c);
      if (localTroopInfo != null)
      {
        if (localTroopInfo.Administrator == null) {
          break label401;
        }
        if (localTroopInfo.Administrator.startsWith("|")) {
          localTroopInfo.Administrator = localTroopInfo.Administrator.substring(1);
        }
        if (localTroopInfo.Administrator.endsWith("|")) {
          localTroopInfo.Administrator = localTroopInfo.Administrator.substring(0, localTroopInfo.Administrator.length() - 1);
        }
        if (paramByte != 0) {
          break label411;
        }
        localTroopInfo.Administrator = localTroopInfo.Administrator.replace(paramString2 + "|", "").replace("|" + paramString2, "").replace(paramString2, "");
        label251:
        paramString1.b(localTroopInfo);
      }
      if (paramByte != 0) {
        break label451;
      }
      this.a.a(2, this.a.getString(2131362866));
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole = 1;
      label289:
      paramString1 = "";
      paramString2 = (TextView)this.a.jdField_a_of_type_AndroidViewView.findViewById(2131298876);
      if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole != 2) {
        break label526;
      }
      paramString1 = this.a.getString(2131362844);
      paramString2.setBackgroundResource(2130839433);
      label338:
      if (TextUtils.isEmpty(paramString1)) {
        break label559;
      }
      paramString2.setPadding(AIOUtils.a(5.0F, this.a.getResources()), 0, AIOUtils.a(5.0F, this.a.getResources()), 0);
      paramString2.setText(paramString1);
      paramString2.setVisibility(0);
    }
    for (;;)
    {
      for (;;)
      {
        this.a.a(2);
        this.a.l();
        return;
        label401:
        localTroopInfo.Administrator = "";
        break;
        label411:
        if (paramByte != 1) {
          break label251;
        }
        localTroopInfo.Administrator = (localTroopInfo.Administrator + "|" + paramString2);
        break label251;
        label451:
        if (paramByte != 1) {
          break label289;
        }
        this.a.a(2, this.a.getString(2131362863));
        this.a.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole = 2;
        try
        {
          ReportController.b(this.a.app, "P_CliOper", "Grp_manage", "", "mber_card", "suc_setadmin", 0, 0, this.a.c, "", "", "");
        }
        catch (Exception paramString1) {}
      }
      break label289;
      label526:
      if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole != 3) {
        break label338;
      }
      paramString1 = this.a.getString(2131362845);
      paramString2.setBackgroundResource(2130839434);
      break label338;
      label559:
      paramString2.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bob
 * JD-Core Version:    0.7.0.1
 */