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
import dox;
import doy;
import doz;
import dpa;
import dpc;
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
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new dpc(this);
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new dpa(this);
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
  
  private void f()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131233205));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131233207));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131233204);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131233206));
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)findViewById(2131233209));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131233210));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131233212));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131233211));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity$MemberGridAdapter = new TroopDisbandActivity.MemberGridAdapter(this);
    this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity$MemberGridAdapter);
    this.f = (getResources().getDimensionPixelSize(2131427421) * 2);
    Object localObject = findViewById(2131233208);
    int i = this.f;
    int j = ((View)localObject).getPaddingLeft();
    this.f = (((View)localObject).getPaddingRight() + j + i);
    this.f += getResources().getDimensionPixelSize(2131427494) * 2;
    this.g = getResources().getDimensionPixelSize(2131427493);
    e();
    localObject = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
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
      this.jdField_b_of_type_AndroidWidgetTextView.setText(String.format(getString(2131561513), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.wMemberNum) }));
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.wMemberNum <= 1)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131561492);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131562358);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.setClickable(false);
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity$MemberGridAdapter.a();
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.wMemberNum > 6)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      }
      for (;;)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131561493);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131561468);
        if (!paramBoolean) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity$MemberGridAdapter.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.getSomeMemberUins());
        new dox(this).start();
        return;
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.setClickable(false);
      }
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText("");
    this.jdField_c_of_type_AndroidWidgetTextView.setText("");
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setClickable(false);
  }
  
  protected void d()
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
  
  protected void e()
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
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131233204: 
      paramView = new Intent(this, TroopMemberListActivity.class);
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)
      {
        paramView.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode);
        paramView.putExtra("troop_code", this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin);
      }
      for (;;)
      {
        startActivity(paramView);
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Clk_quit_grplist", 0, 0, "", "", "", "");
        return;
        paramView.putExtra("troop_uin", this.jdField_d_of_type_JavaLangString);
        paramView.putExtra("troop_code", this.jdField_b_of_type_JavaLangString);
      }
    case 2131233212: 
      int j = 1;
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
        paramView = (TroopHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(19);
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
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(0, 2131562292, 1000);
          ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Clk_transgrp", 0, 0, "", "", "", "");
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
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(2, 2131562071, 1500);
        continue;
        if (i != 0) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(2, 2131562488, 1500);
        } else {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(2, 2131563036, 1500);
        }
      }
    }
    paramView = getString(2131562706);
    String str = getString(2131561970);
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    localQQCustomDialog.setTitle(paramView);
    localQQCustomDialog.setMessage(str);
    localQQCustomDialog.setPositiveButton(getString(2131562539), new doy(this, localQQCustomDialog));
    localQQCustomDialog.setPositiveButtonContentDescription(getString(2131558431));
    localQQCustomDialog.setNegativeButton(getString(2131561746), new doz(this));
    localQQCustomDialog.setNegativeButtonContentDescription(getString(2131558432));
    localQQCustomDialog.show();
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Clk_dismiss_grp", 0, 0, "", "", "", "");
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    e();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    c(2130903636);
    setTitle(2131562706);
    d();
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.e = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    f();
  }
  
  protected void onDestroy()
  {
    b(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = null;
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopDisbandActivity
 * JD-Core Version:    0.7.0.1
 */