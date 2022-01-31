package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import bmf;
import bmg;
import bmh;
import bmi;
import bml;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class TroopDisbandActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public static final int a = 0;
  public static final String a = "Q.troopdisband.disband";
  protected static final int b = 1;
  protected static final int c = 2;
  protected static final int e = 6;
  public long a;
  protected View a;
  protected Button a;
  protected GridView a;
  protected ImageView a;
  protected TextView a;
  public TroopDisbandActivity.MemberGridAdapter a;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new bml(this);
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new bmi(this);
  public TroopInfo a;
  public QQProgressNotifier a;
  public ArrayList a;
  protected Button b;
  protected TextView b;
  public String b;
  protected TextView c;
  public String c;
  public int d;
  public String d;
  public String e;
  protected int f;
  protected int g;
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298507));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298509));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131298506);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298508));
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)findViewById(2131298511));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298513));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131298514));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131298515));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity$MemberGridAdapter = new TroopDisbandActivity.MemberGridAdapter(this);
    this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity$MemberGridAdapter);
    this.f = (getResources().getDimensionPixelSize(2131492927) * 2);
    Object localObject = findViewById(2131298510);
    int i = this.f;
    int j = ((View)localObject).getPaddingLeft();
    this.f = (((View)localObject).getPaddingRight() + j + i);
    this.f += getResources().getDimensionPixelSize(2131492991) * 2;
    this.g = getResources().getDimensionPixelSize(2131492990);
    d();
    localObject = (FriendManager)this.app.getManager(8);
    if (localObject == null) {}
    for (localObject = null;; localObject = ((FriendManager)localObject).a(this.jdField_b_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((TroopInfo)localObject);
      a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo, true);
      return;
    }
  }
  
  public void a(TroopInfo paramTroopInfo, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramTroopInfo;
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)
    {
      this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode;
      this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopname;
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopdisband.disband", 2, "initTroopTips groupInfo mTroopUin =" + this.jdField_b_of_type_JavaLangString + ", wMemberNum=" + this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.wMemberNum + ", troopCreateTime = " + this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopCreateTime);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(String.format(getString(2131363629), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.wMemberNum) }));
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.wMemberNum <= 1)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131363624);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131363627);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.setClickable(false);
        findViewById(2131298512).setClickable(false);
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity$MemberGridAdapter.a();
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      do
      {
        return;
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        findViewById(2131298512).setOnClickListener(this);
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131363625);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131363626);
      } while (!paramBoolean);
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity$MemberGridAdapter.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.getSomeMemberUins());
      new bmf(this).start();
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText("");
    this.jdField_c_of_type_AndroidWidgetTextView.setText("");
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setClickable(false);
  }
  
  protected void c()
  {
    Bundle localBundle = getIntent().getExtras();
    this.jdField_b_of_type_JavaLangString = localBundle.getString("troop_uin");
    this.jdField_d_of_type_JavaLangString = localBundle.getString("troop_code");
    this.jdField_c_of_type_JavaLangString = localBundle.getString("uinname");
    try
    {
      long l = Long.parseLong(this.jdField_b_of_type_JavaLangString);
      if (l <= 0L)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.troopdisband.disband", 2, "troopuin = " + l + " is illegal");
        }
        finish();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.troopdisband.disband", 2, localException.toString());
        }
        finish();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopdisband.disband", 2, "onCreate intent params mTroopUin= " + this.jdField_b_of_type_JavaLangString + ", mTroopName=" + this.jdField_c_of_type_JavaLangString + ", mTroopCode= " + this.jdField_d_of_type_JavaLangString);
    }
  }
  
  protected void d()
  {
    int i = 125;
    int k = getResources().getDisplayMetrics().widthPixels;
    int j = (k - this.f - this.g * 5) / 6;
    if (j > 125) {}
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetGridView.setColumnWidth(i);
      ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetGridView.getLayoutParams();
      if (localLayoutParams != null) {
        localLayoutParams.height = (i + 4);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity$MemberGridAdapter.a(i);
      if (QLog.isColorLevel())
      {
        QLog.i("Q.troopdisband.disband", 2, "initListItemSize|width = " + k + ", columnWidth = " + i);
        QLog.i("Q.troopdisband.disband", 2, "initListItemSize|list.width = " + this.jdField_a_of_type_AndroidWidgetGridView.getWidth() + ", list.height = " + this.jdField_a_of_type_AndroidWidgetGridView.getHeight());
      }
      return;
      i = j;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentViewB(2130903549);
    setTitle(2131363427);
    c();
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.e = this.app.a();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    e();
    return true;
  }
  
  protected void doOnDestroy()
  {
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = null;
    }
    super.doOnDestroy();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    String str;
    if ((paramInt1 == 0) && (paramIntent != null))
    {
      boolean bool = paramIntent.getBooleanExtra("isNeedFinish", false);
      str = paramIntent.getStringExtra("fin_tip_msg");
      paramIntent = paramIntent.getStringExtra("uin");
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopdisband.disband", 2, "onActivityResult|REQUEST_FOR_TROOP_TRANSFER|isNeedFinish = " + bool + ", strTip = " + str);
      }
      if (!bool) {
        break label126;
      }
      localIntent = new Intent();
      localIntent.putExtra("fin_tip_msg", str);
      localIntent.putExtra("uin", paramIntent);
      setResult(paramInt2, localIntent);
      finish();
    }
    label126:
    while (TextUtils.isEmpty(str))
    {
      Intent localIntent;
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(1, str, 1500);
  }
  
  public void onClick(View paramView)
  {
    int j = 1;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131298506: 
    case 2131298512: 
      localObject = new Intent(this, TroopMemberListActivity.class);
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)
      {
        ((Intent)localObject).putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode);
        ((Intent)localObject).putExtra("troop_code", this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin);
      }
      for (paramView = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin;; paramView = this.jdField_b_of_type_JavaLangString)
      {
        ((Intent)localObject).putExtra("param_from", 4);
        startActivity((Intent)localObject);
        try
        {
          ReportController.b(this.app, "P_CliOper", "Grp_mber", "", "mber_list", "Clk_mberlist", 0, 0, paramView, "1", "0", "");
          return;
        }
        catch (Exception paramView)
        {
          return;
        }
        ((Intent)localObject).putExtra("troop_uin", this.jdField_d_of_type_JavaLangString);
        ((Intent)localObject).putExtra("troop_code", this.jdField_b_of_type_JavaLangString);
      }
    case 2131298514: 
      int i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)
      {
        i = j;
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.wMemberNum <= 1) {
          i = 0;
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
      }
      if ((i != 0) && (NetworkUtil.e(this)))
      {
        paramView = (TroopHandler)this.app.a(17);
        if (paramView != null) {
          if ((this.jdField_d_of_type_Int & 0x2) != 0) {}
        }
      }
      for (;;)
      {
        try
        {
          long l = Long.parseLong(this.jdField_b_of_type_JavaLangString);
          this.jdField_d_of_type_Int |= 0x2;
          this.jdField_a_of_type_Long = 0L;
          this.jdField_a_of_type_JavaUtilArrayList.clear();
          paramView.a(l, this.jdField_a_of_type_Long, 4, null, 0, 0);
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(0, 2131363630, 1000);
          ReportController.b(this.app, "CliOper", "", "", "Grp", "Clk_transgrp", 0, 0, "", "", "", "");
          return;
        }
        catch (Exception paramView)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("Q.troopdisband.disband", 2, paramView.toString());
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(2, 2131363631, 1500);
        continue;
        if (i != 0) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(2, 2131363450, 1500);
        } else {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(2, 2131363623, 1500);
        }
      }
    }
    paramView = getString(2131363429);
    Object localObject = getString(2131363425);
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    localQQCustomDialog.setTitle(paramView);
    localQQCustomDialog.setMessage((CharSequence)localObject);
    localQQCustomDialog.setPositiveButton(getString(2131363426), new bmg(this, localQQCustomDialog));
    localQQCustomDialog.setPositiveButtonContentDescription(getString(2131361813));
    localQQCustomDialog.setNegativeButton(getString(2131362794), new bmh(this));
    localQQCustomDialog.setNegativeButtonContentDescription(getString(2131361814));
    localQQCustomDialog.show();
    ReportController.b(this.app, "CliOper", "", "", "Grp", "Clk_dismiss_grp", 0, 0, "", "", "", "");
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopDisbandActivity
 * JD-Core Version:    0.7.0.1
 */