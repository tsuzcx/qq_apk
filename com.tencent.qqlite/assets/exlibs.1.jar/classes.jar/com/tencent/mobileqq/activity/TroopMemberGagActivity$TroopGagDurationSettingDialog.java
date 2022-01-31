package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import boe;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;

public class TroopMemberGagActivity$TroopGagDurationSettingDialog
  extends Dialog
  implements View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private TroopGagDurationSettingPannel jdField_a_of_type_ComTencentMobileqqActivityTroopGagDurationSettingPannel;
  private View b;
  private View c;
  
  public TroopMemberGagActivity$TroopGagDurationSettingDialog(TroopMemberGagActivity paramTroopMemberGagActivity, Context paramContext)
  {
    super(paramContext, 2131624242);
    requestWindowFeature(1);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = getLayoutInflater().inflate(2130903313, null);
    setContentView(this.jdField_a_of_type_AndroidViewView);
    paramTroopMemberGagActivity = getWindow();
    paramContext = paramTroopMemberGagActivity.getAttributes();
    paramContext.width = -1;
    paramContext.height = -2;
    paramContext.gravity = 81;
    paramTroopMemberGagActivity.setAttributes(paramContext);
    paramTroopMemberGagActivity.setWindowAnimations(2131624243);
    if (Build.VERSION.SDK_INT >= 11) {
      paramTroopMemberGagActivity.setFlags(16777216, 16777216);
    }
    setCancelable(true);
    setCanceledOnTouchOutside(true);
    a();
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopGagDurationSettingPannel = ((TroopGagDurationSettingPannel)this.jdField_a_of_type_AndroidViewView.findViewById(2131297671));
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopGagDurationSettingPannel.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberGagActivity.f, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberGagActivity.g, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberGagActivity.h, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberGagActivity.e);
      this.b = this.jdField_a_of_type_AndroidViewView.findViewById(2131297667);
      this.c = this.jdField_a_of_type_AndroidViewView.findViewById(2131297669);
      this.b.setClickable(true);
      this.c.setClickable(true);
      this.b.setOnClickListener(this);
      this.c.setOnClickListener(this);
      this.b.setFocusable(true);
      this.c.setFocusable(true);
    } while (this.jdField_a_of_type_AndroidContentContext == null);
    String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131362345) + this.jdField_a_of_type_AndroidContentContext.getString(2131362347);
    String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131362346) + this.jdField_a_of_type_AndroidContentContext.getString(2131362347);
    this.b.setContentDescription(str1);
    this.c.setContentDescription(str2);
  }
  
  public void onClick(View paramView)
  {
    TroopGagMgr localTroopGagMgr = (TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberGagActivity.app.getManager(42);
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      dismiss();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberGagActivity.app, "P_CliOper", "Grp_manage", "", "silent", "un_custom_time", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberGagActivity.d, localTroopGagMgr.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberGagActivity.d), "", "");
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberGagActivity.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberGagActivity$TroopGagListAdapter == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberGagActivity.f = this.jdField_a_of_type_ComTencentMobileqqActivityTroopGagDurationSettingPannel.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberGagActivity.g = this.jdField_a_of_type_ComTencentMobileqqActivityTroopGagDurationSettingPannel.b;
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberGagActivity.h = this.jdField_a_of_type_ComTencentMobileqqActivityTroopGagDurationSettingPannel.c;
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberGagActivity.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityTroopGagDurationSettingPannel.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberGagActivity.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberGagActivity$TroopGagListAdapter.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGagMgr$GagItem.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberGagActivity.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberGagActivity.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberGagActivity$TroopGagListAdapter.a.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberGagActivity.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberGagActivity$TroopGagListAdapter.notifyDataSetChanged();
    dismiss();
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberGagActivity.app, "P_CliOper", "Grp_manage", "", "silent", "suc_custom_time", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberGagActivity.d, localTroopGagMgr.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberGagActivity.d), this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberGagActivity.jdField_a_of_type_Int + "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberGagActivity.TroopGagDurationSettingDialog
 * JD-Core Version:    0.7.0.1
 */