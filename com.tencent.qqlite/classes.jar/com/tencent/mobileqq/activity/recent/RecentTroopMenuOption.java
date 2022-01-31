package com.tencent.mobileqq.activity.recent;

import android.content.res.Resources;
import clt;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public class RecentTroopMenuOption
{
  protected static final int a = 2;
  private static final String jdField_a_of_type_JavaLangString = "RecentTroopMenuOption";
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  public QQAppInterface a;
  public QQProgressNotifier a;
  
  public RecentTroopMenuOption(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(String paramString1, String paramString2)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(paramString1);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_set_right", 0, 0, paramString1, String.valueOf(i - 1), "", "");
    Resources localResources = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources();
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null, 2131624120);
    localActionSheet.a(localResources.getString(2131363868, new Object[] { paramString2 }));
    i = DBUtils.a().a(paramString1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localActionSheet.b(localResources.getString(2131363869, new Object[] { StringUtil.a(BaseApplication.getContext(), i) }));
    localActionSheet.a(localResources.getString(2131362534), false);
    localActionSheet.a(localResources.getString(2131362535), false);
    localActionSheet.a(localResources.getString(2131362536), false);
    i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(String.valueOf(paramString1));
    switch (i)
    {
    }
    for (;;)
    {
      localActionSheet.d(2131362801);
      localActionSheet.a(new clt(this, i, paramString1, localActionSheet));
      localActionSheet.show();
      return;
      localActionSheet.e(0);
      continue;
      localActionSheet.e(1);
      continue;
      localActionSheet.e(2);
    }
  }
  
  public void a(RecentBaseData paramRecentBaseData)
  {
    a(paramRecentBaseData.a(), paramRecentBaseData.b());
  }
  
  public void a(RecentBaseData paramRecentBaseData, boolean paramBoolean)
  {
    if (paramRecentBaseData == null) {
      return;
    }
    TroopAssistantManager.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBoolean);
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    String str = paramRecentBaseData.a();
    if (paramBoolean) {}
    for (paramRecentBaseData = "1";; paramRecentBaseData = "0")
    {
      ReportController.b(localQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_top_right", 0, 0, str, "4", paramRecentBaseData, "");
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentTroopMenuOption
 * JD-Core Version:    0.7.0.1
 */