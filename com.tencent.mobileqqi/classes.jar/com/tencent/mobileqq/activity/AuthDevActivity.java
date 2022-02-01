package com.tencent.mobileqq.activity;

import QQService.SvcDevLoginInfo;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bvk;
import bvl;
import bvm;
import bvn;
import bvo;
import bvp;
import bvq;
import bvr;
import bvs;
import bvt;
import bvu;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.equipmentlock.EquipLockWebEntrance;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mqq.observer.WtloginObserver;

public class AuthDevActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = "Q.devlock.AuthDevActivity";
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Handler jdField_a_of_type_AndroidOsHandler = new bvk(this);
  private Button jdField_a_of_type_AndroidWidgetButton = null;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new bvq(this);
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = null;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private List jdField_a_of_type_JavaUtilList = null;
  private WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new bvr(this);
  private boolean jdField_a_of_type_Boolean = false;
  private String jdField_b_of_type_JavaLangString = "";
  private boolean jdField_b_of_type_Boolean = true;
  private String jdField_c_of_type_JavaLangString = null;
  private boolean jdField_c_of_type_Boolean = true;
  private String jdField_d_of_type_JavaLangString = null;
  private boolean jdField_d_of_type_Boolean = false;
  
  private void a(String paramString1, ArrayList paramArrayList, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = getResources().getString(2131563124);
    }
    if (paramBoolean1) {}
    for (paramString1 = getString(2131562156, new Object[] { str });; paramString1 = getString(2131562157, new Object[] { str }))
    {
      DialogUtil.a(this, 230, str, paramString1, new bvo(this, paramString2, paramArrayList, paramInt, paramBoolean2, paramLong), new bvp(this)).show();
      return;
    }
  }
  
  private void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    int j;
    int i;
    SvcDevLoginInfo localSvcDevLoginInfo;
    for (;;)
    {
      return;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      j = paramList.size();
      i = 0;
      while (i < j)
      {
        localSvcDevLoginInfo = (SvcDevLoginInfo)paramList.get(i);
        if (localSvcDevLoginInfo != null) {
          break label76;
        }
        i += 1;
      }
    }
    label76:
    View localView = getLayoutInflater().inflate(2130903567, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
    RelativeLayout localRelativeLayout = (RelativeLayout)localView.findViewById(2131230995);
    label116:
    Object localObject;
    TextView localTextView1;
    TextView localTextView2;
    if (j == 1)
    {
      localRelativeLayout.setBackgroundResource(2130837877);
      localObject = (TextView)localView.findViewById(2131231000);
      localTextView1 = (TextView)localView.findViewById(2131231506);
      localTextView2 = (TextView)localView.findViewById(2131232941);
      if (!TextUtils.isEmpty(localSvcDevLoginInfo.strDeviceName)) {
        break label399;
      }
      ((TextView)localObject).setText(2131563124);
    }
    for (;;)
    {
      if (Arrays.equals(NetConnInfoCenter.GUID, localSvcDevLoginInfo.vecGuid))
      {
        localTextView2.setText("（" + getResources().getString(2131561897) + "）");
        localTextView2.setVisibility(0);
      }
      localObject = new StringBuffer();
      if (!TextUtils.isEmpty(localSvcDevLoginInfo.strLoginLocation)) {
        ((StringBuffer)localObject).append(localSvcDevLoginInfo.strLoginLocation);
      }
      if (!TextUtils.isEmpty(localSvcDevLoginInfo.strDeviceTypeInfo))
      {
        if (((StringBuffer)localObject).length() > 0) {
          ((StringBuffer)localObject).append(" ");
        }
        ((StringBuffer)localObject).append(localSvcDevLoginInfo.strDeviceTypeInfo);
      }
      if (((StringBuffer)localObject).length() > 0) {
        localTextView1.setText(((StringBuffer)localObject).toString());
      }
      localRelativeLayout.setClickable(true);
      localRelativeLayout.setTag(localSvcDevLoginInfo);
      localRelativeLayout.setOnClickListener(new bvn(this, localRelativeLayout, i));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
      break;
      if (i == 0)
      {
        localRelativeLayout.setBackgroundResource(2130837882);
        break label116;
      }
      if (i == j - 1)
      {
        localRelativeLayout.setBackgroundResource(2130837879);
        break label116;
      }
      localRelativeLayout.setBackgroundResource(2130837881);
      break label116;
      label399:
      ((TextView)localObject).setText(localSvcDevLoginInfo.strDeviceName);
    }
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.AuthDevActivity", 2, "startGetAuthDevList.begin to getAuthLoginDevList");
    }
    boolean bool = EquipmentLockImpl.a().c(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString, 0L);
    if (bool) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("Q.devlock.AuthDevActivity", 2, "startGetAuthDevList getAuthLoginDevList failed ret =" + bool);
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new bvl(this));
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new bvm(this));
  }
  
  private void g()
  {
    if (!NetworkUtil.e(this)) {
      QQToast.a(this, getString(2131562452), 0).b(d());
    }
    int i;
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_Boolean)
        {
          ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "My_eq_lock", "My_eq_lock_close", 0, 0, "", "", "", "");
          a();
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevActivity", 2, "onClick.begin to CheckDevLockSms");
        }
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "My_eq_lock", "My_eq_lock_open", 0, 0, "0", "", "", "");
        if (this.jdField_c_of_type_Boolean) {
          break;
        }
      } while ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()));
      e();
      return;
      e();
      this.jdField_c_of_type_Boolean = false;
      String str = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
      i = EquipmentLockImpl.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, str, "", null, this.jdField_a_of_type_MqqObserverWtloginObserver);
    } while (i == 0);
    this.jdField_c_of_type_Boolean = true;
    f();
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.AuthDevActivity", 2, "onClick.CheckDevLockSms fail ret=" + i);
    }
    QQToast.a(getApplicationContext(), getString(2131562041), 0).b(d());
  }
  
  void a()
  {
    b();
    Dialog localDialog = new Dialog(this, 2131624405);
    localDialog.setContentView(2130903162);
    TextView localTextView1 = (TextView)localDialog.findViewById(2131231468);
    if (localTextView1 != null) {
      localTextView1.setText(getString(2131561948));
    }
    localTextView1 = (TextView)localDialog.findViewById(2131231029);
    if (localTextView1 != null) {
      localTextView1.setText(getString(2131561951));
    }
    localTextView1 = (TextView)localDialog.findViewById(2131231471);
    if (localTextView1 != null) {
      localTextView1.setText(2131561842);
    }
    TextView localTextView2 = (TextView)localDialog.findViewById(2131231472);
    if (localTextView2 != null) {
      localTextView2.setText(2131561746);
    }
    localDialog.setOnDismissListener(new bvs(this));
    if (localTextView1 != null) {
      localTextView1.setOnClickListener(new bvt(this));
    }
    if (localTextView2 != null) {
      localTextView2.setOnClickListener(new bvu(this));
    }
    this.jdField_a_of_type_AndroidAppDialog = localDialog;
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog == null) || (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      label24:
      this.jdField_a_of_type_AndroidAppDialog = null;
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  protected boolean b()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("auth_dev_open", this.jdField_a_of_type_Boolean);
    localIntent.putExtra("allow_set", this.jdField_b_of_type_Boolean);
    setResult(0, localIntent);
    finish();
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131232937: 
    default: 
      return;
    case 2131232936: 
      g();
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.sendWirelessMeibaoReq(1);
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "My_eq_lock", "Clk_protect_detail", 0, 0, "", "", "", "");
    if ((TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a())) && (QLog.isColorLevel())) {
      QLog.d("Q.devlock.AuthDevActivity", 2, "onClick current is empty");
    }
    EquipLockWebEntrance.a(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2130903566);
    super.setTitle(2131561941);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)super.findViewById(2131232938));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131232940));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)super.findViewById(2131231617));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131232936));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    paramBundle = super.getIntent();
    this.jdField_a_of_type_Boolean = paramBundle.getExtras().getBoolean("auth_dev_open");
    this.jdField_c_of_type_JavaLangString = paramBundle.getExtras().getString("country_code");
    this.jdField_d_of_type_JavaLangString = paramBundle.getExtras().getString("phone_num");
    this.jdField_d_of_type_Boolean = paramBundle.getExtras().getBoolean("allow_set");
    paramBundle = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(LoginInfoActivity.class);
    if (paramBundle != null)
    {
      if (!this.jdField_a_of_type_Boolean) {
        break label306;
      }
      paramBundle.obtainMessage(20140331, 1, 0).sendToTarget();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131561947));
      }
      try
      {
        for (;;)
        {
          this.jdField_b_of_type_JavaLangString = getPackageManager().getPackageInfo(getPackageName(), 0).packageName;
          if (QLog.isColorLevel()) {
            QLog.d("Q.devlock.AuthDevActivity", 2, "packName = " + this.jdField_b_of_type_JavaLangString);
          }
          a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_d_of_type_JavaLangString);
          if (!this.jdField_a_of_type_Boolean) {
            break label346;
          }
          this.jdField_a_of_type_AndroidWidgetButton.setText(getString(2131561947));
          d();
          return;
          label306:
          paramBundle.obtainMessage(20140331, 0, 0).sendToTarget();
          break;
          this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131562008));
        }
      }
      catch (PackageManager.NameNotFoundException paramBundle)
      {
        for (;;)
        {
          paramBundle.printStackTrace();
        }
        label346:
        if ((this.jdField_d_of_type_Boolean) && (EquipmentLockImpl.a().c()))
        {
          g();
          return;
        }
        this.jdField_a_of_type_AndroidWidgetButton.setText(getString(2131562008));
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    f();
    b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevActivity
 * JD-Core Version:    0.7.0.1
 */