package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.biz.common.report.BnrReport.BnrReportCheckUpdate;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationConfigCheckUpdateItem;
import com.tencent.mobileqq.app.AccountRecListItem;
import com.tencent.mobileqq.app.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.GetRichSig;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.PublicAccountHandler.PublicAccountCheckUpdateItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ReqGetSettingsItem;
import com.tencent.mobileqq.app.ReqSystemMsgNewItem;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.profile.ProfileCardCheckUpdate;
import com.tencent.mobileqq.service.message.GetBlackListItem;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.mobileqq.service.profile.GetSimpleInfoCheckUpdateItem;
import com.tencent.mobileqq.util.QQSettingUtil.UserBitFlagCheckUpdate;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import fhv;
import java.util.HashMap;

public class GetCheckUpdate
  extends AsyncStep
{
  fhv a;
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.getPreferences();
    int i = localSharedPreferences.getInt("businessinfo_check_update_interval_" + paramQQAppInterface.a(), 600);
    int j = localSharedPreferences.getInt("businessinfo_last_check_update_timestamp_" + paramQQAppInterface.a(), 0);
    int k = (int)(System.currentTimeMillis() / 1000L);
    if (QLog.isDevelopLevel()) {
      QLog.d("QQInitHandler", 4, "onGetCheckUpdate:lastCheckTime=" + j + ",nowSystemTime=" + k);
    }
    if ((k - j > i) || (k < j))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("QQInitHandler", 4, "onGetCheckUpdate:start send check update new info update time.");
      }
      localSharedPreferences.edit().putInt("businessinfo_last_check_update_timestamp_" + this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.a(), (int)(System.currentTimeMillis() / 1000L)).commit();
      paramQQAppInterface = new BusinessInfoCheckUpdateItem(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a, 110);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(110, paramQQAppInterface);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a().remove(Integer.valueOf(110));
  }
  
  protected int a()
  {
    FriendListHandler localFriendListHandler = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.a(1);
    if (this.h == 39) {}
    for (int i = 1;; i = 4)
    {
      localFriendListHandler.a(true, i);
      return 2;
    }
  }
  
  public void a()
  {
    super.a();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a;
    if (this.h == 39)
    {
      Object localObject = new AccountRecListItem(localQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(112, (CheckUpdateItemInterface)localObject);
      localObject = (PublicAccountHandler)localQQAppInterface.a(10);
      if (((PublicAccountHandler)localObject).c())
      {
        localObject.getClass();
        localObject = new PublicAccountHandler.PublicAccountCheckUpdateItem((PublicAccountHandler)localObject);
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(((PublicAccountHandler.PublicAccountCheckUpdateItem)localObject).b(), (CheckUpdateItemInterface)localObject);
      }
      localObject = new QQSettingUtil.UserBitFlagCheckUpdate(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(106, (CheckUpdateItemInterface)localObject);
      localObject = new BnrReport.BnrReportCheckUpdate(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(118, (CheckUpdateItemInterface)localObject);
      long l1 = System.currentTimeMillis();
      long l2 = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getLong("last_update_time", 0L);
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "DeviceProfileManager.KEY_LAST_UPDATE_TIME=" + l2 + ",nowSystemTime=" + l1);
      }
      if (86400L <= Math.abs(l1 - l2) / 1000L) {
        ConfigServlet.a(localQQAppInterface, 6);
      }
      localObject = new GetSimpleInfoCheckUpdateItem(localQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(113, (CheckUpdateItemInterface)localObject);
      localObject = new GetBlackListItem(localQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(116, (CheckUpdateItemInterface)localObject);
      localObject = new ReqSystemMsgNewItem(localQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(114, (CheckUpdateItemInterface)localObject);
      localObject = new ReqGetSettingsItem(localQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(115, (CheckUpdateItemInterface)localObject);
      localObject = new ProfileCardCheckUpdate(localQQAppInterface);
      if (((ProfileCardCheckUpdate)localObject).a()) {
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(111, (CheckUpdateItemInterface)localObject);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(119, new GetRichSig(localQQAppInterface));
      localObject = new AioAnimationConfigCheckUpdateItem(localQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(120, (CheckUpdateItemInterface)localObject);
      a(localQQAppInterface);
    }
    if (this.jdField_a_of_type_Fhv == null)
    {
      this.jdField_a_of_type_Fhv = new fhv(this, null);
      localQQAppInterface.a(this.jdField_a_of_type_Fhv);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Fhv != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.c(this.jdField_a_of_type_Fhv);
      this.jdField_a_of_type_Fhv = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetCheckUpdate
 * JD-Core Version:    0.7.0.1
 */