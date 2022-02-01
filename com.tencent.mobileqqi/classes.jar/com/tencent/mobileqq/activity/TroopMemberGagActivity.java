package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.GagItem;
import dqp;
import java.util.ArrayList;

public class TroopMemberGagActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public static final String a = "TroopMemberGagActivity";
  public static final String b = "param_key_troopUin";
  public static final String c = "param_key_memberUin";
  public int a;
  Button jdField_a_of_type_AndroidWidgetButton;
  ListView jdField_a_of_type_AndroidWidgetListView;
  TroopMemberGagActivity.TroopGagListAdapter jdField_a_of_type_ComTencentMobileqqActivityTroopMemberGagActivity$TroopGagListAdapter;
  dqp jdField_a_of_type_Dqp;
  String d;
  String e;
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130904027);
    setTitle(getString(2131560649));
    paramBundle = ((TroopGagMgr)this.b.getManager(44)).a();
    this.jdField_a_of_type_Int = ((TroopGagMgr.GagItem)paramBundle.get(0)).jdField_a_of_type_Int;
    this.jdField_a_of_type_Dqp = new dqp(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberGagActivity$TroopGagListAdapter = new TroopMemberGagActivity.TroopGagListAdapter(this, paramBundle, this.jdField_a_of_type_Dqp);
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131234603));
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberGagActivity$TroopGagListAdapter);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131234604));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    paramBundle = getIntent();
    this.d = paramBundle.getStringExtra("param_key_troopUin");
    this.e = paramBundle.getStringExtra("param_key_memberUin");
    return true;
  }
  
  public void onClick(View paramView)
  {
    ReportController.b(this.b, "P_CliOper", "Grp_manage", "", "silent_card", "Clk_complete", 0, 0, this.d, this.jdField_a_of_type_Int + "", "", "");
    ((TroopGagMgr)this.b.getManager(44)).a(this.d, this.e, this.jdField_a_of_type_Int);
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberGagActivity
 * JD-Core Version:    0.7.0.1
 */