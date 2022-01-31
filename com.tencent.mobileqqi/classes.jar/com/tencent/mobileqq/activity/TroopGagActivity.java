package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.TroopGagInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.Switch;
import com.tencent.widget.XListView;
import duv;
import duw;
import dux;
import java.util.ArrayList;
import java.util.List;

public class TroopGagActivity
  extends IphoneTitleBarActivity
  implements CompoundButton.OnCheckedChangeListener
{
  public LinearLayout a;
  public TextView a;
  BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new duv(this);
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new duw(this);
  TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
  public Switch a;
  public XListView a;
  public dux a;
  public String a;
  public List a;
  LinearLayout b;
  
  public TroopGagActivity()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    String[] arrayOfString;
    int j;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator))
      {
        arrayOfString = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator.split("\\|");
        bool1 = bool2;
        if (arrayOfString != null)
        {
          j = arrayOfString.length;
          i = 0;
        }
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        if (arrayOfString[i].equalsIgnoreCase(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private boolean b(String paramString)
  {
    return (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin)) && (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin));
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("troopuin");
    this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramBundle.b(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this);
    paramBundle = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2130903397, null);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramBundle.findViewById(2131232456));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextAppearance(this, 2131624137);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131560428));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)paramBundle.findViewById(2131231313));
    this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setFocusable(false);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this);
    Object localObject = new AbsListView.LayoutParams(-1, -2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    localObject = View.inflate(this, 2130903646, null);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    localObject = new TextView(this);
    ((TextView)localObject).setPadding(getResources().getDimensionPixelSize(2131427544), 0, getResources().getDimensionPixelSize(2131427544), getResources().getDimensionPixelSize(2131427540));
    ((TextView)localObject).setTextAppearance(this, 2131624137);
    ((TextView)localObject).setText(getResources().getString(2131560427));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = new LinearLayout(this);
    localObject = new AbsListView.LayoutParams(-1, -2);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    localObject = View.inflate(this, 2130903646, null);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    localObject = View.inflate(this, 2130903378, null);
    this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)((View)localObject).findViewById(2131232377));
    TroopGagMgr.TroopGagInfo localTroopGagInfo = ((TroopGagMgr)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(44)).a(this.jdField_a_of_type_JavaLangString, false);
    if ((localTroopGagInfo != null) && (localTroopGagInfo.a != 0L)) {
      this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(true);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
      localObject = View.inflate(this, 2130903646, null);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
      this.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_b_of_type_AndroidWidgetLinearLayout);
      this.jdField_a_of_type_Dux = new dux(this);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Dux);
      this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundResource(2130837729);
      setContentView(paramBundle);
      setTitle(getString(2131562887));
      if (!NetworkUtil.e(BaseApplication.getContext())) {
        QQToast.a(this, 2131562451, 0).b(d());
      }
      a(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
      a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
      ((TroopGagMgr)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(44)).a(this.jdField_a_of_type_JavaLangString, true);
      paramBundle = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      if (paramBundle != null)
      {
        paramBundle = paramBundle.a(this.jdField_a_of_type_JavaLangString);
        ((TroopHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(19)).a(true, this.jdField_a_of_type_JavaLangString, paramBundle.troopcode);
      }
      return true;
      this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(false);
    }
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_Dux != null) {
      this.jdField_a_of_type_Dux.b();
    }
    b(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    super.doOnDestroy();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = (TroopGagMgr)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(44);
    if (paramBoolean)
    {
      paramCompoundButton.a(this.jdField_a_of_type_JavaLangString, 268435455L);
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_manage", "", "silent_mana", "Clk_all", 0, 0, this.jdField_a_of_type_JavaLangString + "", "", "", "");
      return;
    }
    paramCompoundButton.a(this.jdField_a_of_type_JavaLangString, 0L);
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_manage", "", "silent_mana", "close_all", 0, 0, this.jdField_a_of_type_JavaLangString + "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopGagActivity
 * JD-Core Version:    0.7.0.1
 */