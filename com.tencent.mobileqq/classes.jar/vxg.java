import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.GagStatus;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class vxg
  extends BizTroopObserver
{
  public vxg(TroopChatPie paramTroopChatPie) {}
  
  protected void a(TroopGagMgr.GagStatus paramGagStatus)
  {
    if ((paramGagStatus.jdField_a_of_type_Int == 2) && (paramGagStatus.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGagMgr$SelfGagInfo != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("troop_gag", 2, "onTroopGagStatusChange:" + paramGagStatus.jdField_a_of_type_JavaLangString);
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramGagStatus.jdField_a_of_type_JavaLangString)) {
        this.a.a(paramGagStatus.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGagMgr$SelfGagInfo, true);
      }
    }
  }
  
  protected void a(Object paramObject)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      break label7;
    }
    for (;;)
    {
      label7:
      return;
      if (paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        TroopManager localTroopManager = (TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        TroopInfo localTroopInfo = localTroopManager.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if (localTroopInfo == null) {
          break;
        }
        if (!paramBoolean) {
          if (!TextUtils.isEmpty(paramString3)) {
            QQToast.a(BaseApplicationImpl.getContext(), 1, paramString3, 0).a();
          }
        }
        while ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString1)) && (localTroopInfo != null))
        {
          this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = localTroopInfo.getTroopName();
          paramString1 = this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
          paramString1.putExtra("uinname", localTroopInfo.getTroopName());
          this.a.b(paramString1);
          return;
          localTroopInfo.troopname = paramString2;
          localTroopInfo.hasSetNewTroopName = true;
          if ((this.a.q()) && (localTroopInfo.isNewTroop) && (localTroopInfo.hasSetNewTroopName) && (localTroopInfo.hasSetNewTroopHead))
          {
            localTroopInfo.isNewTroop = false;
            TroopUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localTroopInfo, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, new vxi(this));
          }
          localTroopManager.b(localTroopInfo);
          this.a.bp();
        }
      }
    }
  }
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isResume()) {
      return;
    }
    if (paramBoolean1)
    {
      if (paramBoolean2) {}
      for (String str = this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131430407);; str = this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131430408))
      {
        QQToast.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), 2, str, 1).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
        return;
      }
    }
    QQToast.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), 1, 2131430409, 1).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
  }
  
  protected void c(boolean paramBoolean, Object paramObject)
  {
    long l = ((Long)paramObject).longValue();
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.TroopChatPie", 2, "onGetTroopNewGuide isSuccess = " + paramBoolean + ", troopUin = " + l);
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(String.valueOf(l)))) {
      ThreadManager.post(new vxh(this), 8, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vxg
 * JD-Core Version:    0.7.0.1
 */