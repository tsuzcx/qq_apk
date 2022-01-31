package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.activity.contact.troop.TroopNotificationUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.subaccount.SubAccountAssistantImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class ActiveAccount
  extends AsyncStep
{
  protected int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "onInitState: " + this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    }
    this.a.jdField_a_of_type_Long = System.currentTimeMillis();
    this.a.jdField_a_of_type_AndroidContentSharedPreferences = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("acc_info" + this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
    QQAppInterface localQQAppInterface = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    localQQAppInterface.b();
    ThemeUtil.initTheme(localQQAppInterface);
    localQQAppInterface.a(true);
    SubAccountAssistantImpl.a().c(localQQAppInterface);
    localQQAppInterface.a();
    UniformDownloadMgr.a().a(localQQAppInterface);
    UniformDownloadMgr.a().b();
    if (TroopNotificationUtils.a(localQQAppInterface.a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "addSystemMsgSeq:0");
      }
      localQQAppInterface.a().d("last_group_seq", 0L);
      TroopNotificationUtils.a(localQQAppInterface.a(), false);
      localQQAppInterface.a().d("last_friend_seq_47", 0L);
    }
    return 7;
  }
  
  public void a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.ActiveAccount
 * JD-Core Version:    0.7.0.1
 */