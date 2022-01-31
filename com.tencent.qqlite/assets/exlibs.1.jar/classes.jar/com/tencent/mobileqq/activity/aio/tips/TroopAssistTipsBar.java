package com.tencent.mobileqq.activity.aio.tips;

import android.view.View;
import android.view.View.OnClickListener;
import cax;
import cay;
import caz;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.widget.UpScrollHideView.onViewHideListener;
import com.tencent.qphone.base.util.QLog;

public class TroopAssistTipsBar
  implements TipsBarTask
{
  private static final String jdField_a_of_type_JavaLangString = TroopAssistTipsBar.class.getSimpleName();
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new caz(this);
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private TipsManager jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public TroopAioTips a;
  private UpScrollHideView.onViewHideListener jdField_a_of_type_ComTencentMobileqqWidgetUpScrollHideView$onViewHideListener = new cay(this);
  private boolean jdField_a_of_type_Boolean = false;
  
  public TroopAssistTipsBar(QQAppInterface paramQQAppInterface, TipsManager paramTipsManager, BaseActivity paramBaseActivity, SessionInfo paramSessionInfo, TroopAioTips paramTroopAioTips)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = paramTipsManager;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips = paramTroopAioTips;
  }
  
  public int a()
  {
    return 3;
  }
  
  public View a(Object... paramVarArgs)
  {
    paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131364145);
    String str = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131364152);
    paramVarArgs = ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramVarArgs, str, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_ComTencentMobileqqWidgetUpScrollHideView$onViewHideListener);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_msg", "", "AIOchat", "exp_setmsg", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
    return paramVarArgs;
  }
  
  public void a()
  {
    if ((a()) || (this.jdField_a_of_type_Boolean)) {
      TroopAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1000) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1);
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips == null) || (!this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "navigateBar is show, return ");
    return;
    ThreadManager.b(new cax(this));
  }
  
  public boolean a()
  {
    return 3 == this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 20;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.TroopAssistTipsBar
 * JD-Core Version:    0.7.0.1
 */