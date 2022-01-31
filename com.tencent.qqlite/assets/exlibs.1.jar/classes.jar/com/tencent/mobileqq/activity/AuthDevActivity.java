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
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecSvcHandler;
import com.tencent.mobileqq.app.SecSvcObserver;
import com.tencent.mobileqq.equipmentlock.EquipLockWebEntrance;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mqq.observer.WtloginObserver;
import yj;
import yk;
import yl;
import ym;
import yn;
import yo;
import yp;
import yq;
import yr;
import ys;
import yt;
import yu;
import yv;

public class AuthDevActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = "Q.devlock.AuthDevActivity";
  private int jdField_a_of_type_Int = 2;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Handler jdField_a_of_type_AndroidOsHandler = new yj(this);
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new yo(this);
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new ys(this);
  private SecSvcObserver jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver = new yu(this);
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = null;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = null;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet = null;
  private List jdField_a_of_type_JavaUtilList = null;
  private WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new yt(this);
  private boolean jdField_a_of_type_Boolean = false;
  private TextView jdField_b_of_type_AndroidWidgetTextView = null;
  private FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = null;
  private String jdField_b_of_type_JavaLangString = "";
  private boolean jdField_b_of_type_Boolean = true;
  private TextView jdField_c_of_type_AndroidWidgetTextView = null;
  private String jdField_c_of_type_JavaLangString = null;
  private boolean jdField_c_of_type_Boolean = true;
  private String jdField_d_of_type_JavaLangString = null;
  private boolean jdField_d_of_type_Boolean = false;
  
  private void a(String paramString1, ArrayList paramArrayList, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = getResources().getString(2131364174);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null, 2131624119));
    if (paramBoolean1) {}
    for (paramString1 = getString(2131364215, new Object[] { str });; paramString1 = getString(2131364214, new Object[] { str }))
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(paramString1);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(getResources().getString(2131364216), 3, false);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.d(2131362790);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new yr(this, paramString2, paramArrayList, paramInt, paramBoolean2, paramLong));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      return;
    }
  }
  
  private void a(List paramList)
  {
    int j = 4;
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    int k = paramList.size();
    int i = 0;
    while (i < k)
    {
      SvcDevLoginInfo localSvcDevLoginInfo = (SvcDevLoginInfo)paramList.get(i);
      if (localSvcDevLoginInfo == null)
      {
        i += 1;
      }
      else
      {
        View localView = getLayoutInflater().inflate(2130903487, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
        RelativeLayout localRelativeLayout = (RelativeLayout)localView.findViewById(2131296449);
        Object localObject1 = (ImageView)localView.findViewById(2131298209);
        Object localObject2 = (ImageView)localView.findViewById(2131298211);
        label153:
        TextView localTextView;
        if (k == 1)
        {
          localRelativeLayout.setBackgroundResource(2130837928);
          localObject2 = (TextView)localView.findViewById(2131296455);
          localObject1 = (TextView)localView.findViewById(2131296957);
          localTextView = (TextView)localView.findViewById(2131298210);
          if (!TextUtils.isEmpty(localSvcDevLoginInfo.strDeviceName)) {
            break label458;
          }
          ((TextView)localObject2).setText(2131364174);
        }
        for (;;)
        {
          if (Arrays.equals(NetConnInfoCenter.GUID, localSvcDevLoginInfo.vecGuid))
          {
            localTextView.setText("（" + getResources().getString(2131364170) + "）");
            localTextView.setVisibility(0);
          }
          localObject2 = new StringBuffer();
          if (!TextUtils.isEmpty(localSvcDevLoginInfo.strLoginLocation)) {
            ((StringBuffer)localObject2).append(localSvcDevLoginInfo.strLoginLocation);
          }
          if (!TextUtils.isEmpty(localSvcDevLoginInfo.strDeviceTypeInfo))
          {
            if (((StringBuffer)localObject2).length() > 0) {
              ((StringBuffer)localObject2).append(" ");
            }
            ((StringBuffer)localObject2).append(localSvcDevLoginInfo.strDeviceTypeInfo);
          }
          if (((StringBuffer)localObject2).length() > 0) {
            ((TextView)localObject1).setText(((StringBuffer)localObject2).toString());
          }
          localRelativeLayout.setClickable(true);
          localRelativeLayout.setTag(localSvcDevLoginInfo);
          localRelativeLayout.setOnClickListener(new yq(this, localRelativeLayout, i));
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
          break;
          if (i == 0)
          {
            ((ImageView)localObject1).setVisibility(0);
            localRelativeLayout.setBackgroundResource(2130837928);
            break label153;
          }
          if (i == k - 1)
          {
            ((ImageView)localObject1).setVisibility(0);
            localRelativeLayout.setBackgroundResource(2130837930);
            break label153;
          }
          ((ImageView)localObject1).setVisibility(0);
          localRelativeLayout.setBackgroundResource(2130837931);
          break label153;
          label458:
          ((TextView)localObject2).setText(localSvcDevLoginInfo.strDeviceName);
        }
      }
    }
    paramList = this.jdField_a_of_type_AndroidWidgetTextView;
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() == 0)
    {
      i = 4;
      paramList.setVisibility(i);
      paramList = this.jdField_a_of_type_AndroidWidgetTextView;
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() != 0) {
        break label521;
      }
    }
    label521:
    for (i = j;; i = 0)
    {
      paramList.setVisibility(i);
      return;
      i = 0;
      break;
    }
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.AuthDevActivity", 2, "startGetAuthDevList.begin to getAuthLoginDevList");
    }
    boolean bool = EquipmentLockImpl.a().c(this.app, this.jdField_b_of_type_JavaLangString, 0L);
    if (bool) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("Q.devlock.AuthDevActivity", 2, "startGetAuthDevList getAuthLoginDevList failed ret =" + bool);
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ym(this));
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new yn(this));
  }
  
  private void f()
  {
    if (!NetworkUtil.e(this)) {
      QQToast.a(this, getString(2131362785), 0).b(getTitleBarHeight());
    }
    int i;
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_Boolean)
        {
          ReportController.b(this.app, "CliOper", "", "", "My_eq_lock", "My_eq_lock_close", 0, 0, "", "", "", "");
          a();
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevActivity", 2, "onClick.begin to CheckDevLockSms");
        }
        ReportController.b(this.app, "CliOper", "", "", "My_eq_lock", "My_eq_lock_open", 0, 0, "0", "", "", "");
        if (this.jdField_c_of_type_Boolean) {
          break;
        }
      } while ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()));
      d();
      return;
      d();
      this.jdField_c_of_type_Boolean = false;
      String str = this.app.a();
      i = EquipmentLockImpl.a().a(this.app, str, "", null, this.jdField_a_of_type_MqqObserverWtloginObserver);
    } while (i == 0);
    this.jdField_c_of_type_Boolean = true;
    e();
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.AuthDevActivity", 2, "onClick.CheckDevLockSms fail ret=" + i);
    }
    QQToast.a(getApplicationContext(), getString(2131364226), 0).b(getTitleBarHeight());
  }
  
  void a()
  {
    b();
    Dialog localDialog = new Dialog(this, 2131624119);
    localDialog.setContentView(2130903135);
    TextView localTextView1 = (TextView)localDialog.findViewById(2131296915);
    if (localTextView1 != null) {
      localTextView1.setText(getString(2131364217));
    }
    localTextView1 = (TextView)localDialog.findViewById(2131296470);
    if (localTextView1 != null) {
      localTextView1.setText(getString(2131364218));
    }
    localTextView1 = (TextView)localDialog.findViewById(2131296918);
    if (localTextView1 != null) {
      localTextView1.setText(2131363522);
    }
    TextView localTextView2 = (TextView)localDialog.findViewById(2131296919);
    if (localTextView2 != null) {
      localTextView2.setText(2131362790);
    }
    localDialog.setOnDismissListener(new yv(this));
    if (localTextView1 != null) {
      localTextView1.setOnClickListener(new yk(this));
    }
    if (localTextView2 != null) {
      localTextView2.setOnClickListener(new yl(this));
    }
    this.jdField_a_of_type_AndroidAppDialog = localDialog;
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  protected boolean a()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("auth_dev_open", this.jdField_a_of_type_Boolean);
    localIntent.putExtra("allow_set", this.jdField_b_of_type_Boolean);
    setResult(0, localIntent);
    finish();
    return false;
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
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131298202: 
    case 2131298203: 
    default: 
      return;
    case 2131298201: 
      f();
      return;
    }
    this.app.sendWirelessMeibaoReq(1);
    ReportController.b(this.app, "CliOper", "", "", "My_eq_lock", "Clk_protect_detail", 0, 0, "", "", "", "");
    if ((TextUtils.isEmpty(this.app.a())) && (QLog.isColorLevel())) {
      QLog.d("Q.devlock.AuthDevActivity", 2, "onClick current is empty");
    }
    EquipLockWebEntrance.a(this, this.app);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2130903486);
    super.setTitle(2131364204);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)super.findViewById(2131298204));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131298208));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)super.findViewById(2131297063));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131298201));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131298207));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131298205));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131298206));
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131298203));
    paramBundle = SpannableString.valueOf(this.jdField_c_of_type_AndroidWidgetTextView.getText());
    yp localyp = new yp(this);
    int i = this.jdField_c_of_type_AndroidWidgetTextView.getText().toString().indexOf("点击这里");
    paramBundle.setSpan(localyp, i, "点击这里".length() + i, 33);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(paramBundle);
    this.jdField_c_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramBundle = super.getIntent();
    this.jdField_a_of_type_Boolean = paramBundle.getExtras().getBoolean("auth_dev_open");
    this.jdField_c_of_type_JavaLangString = paramBundle.getExtras().getString("country_code");
    this.jdField_d_of_type_JavaLangString = paramBundle.getExtras().getString("phone_num");
    this.jdField_d_of_type_Boolean = paramBundle.getExtras().getBoolean("allow_set");
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    if (this.app == null) {
      this.app = ((QQAppInterface)getAppRuntime());
    }
    paramBundle = this.app.a(LoginInfoActivity.class);
    if (paramBundle != null)
    {
      if (!this.jdField_a_of_type_Boolean) {
        break label510;
      }
      paramBundle.obtainMessage(20140331, 1, 0).sendToTarget();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131364204));
      try
      {
        this.jdField_b_of_type_JavaLangString = getPackageManager().getPackageInfo(getPackageName(), 0).packageName;
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevActivity", 2, "packName = " + this.jdField_b_of_type_JavaLangString);
        }
        addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
        addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_d_of_type_JavaLangString);
        if (this.jdField_a_of_type_Boolean)
        {
          paramBundle = (SecSvcHandler)this.app.a(33);
          if (paramBundle != null) {
            paramBundle.a();
          }
          c();
          return;
          label510:
          paramBundle.obtainMessage(20140331, 0, 0).sendToTarget();
        }
      }
      catch (PackageManager.NameNotFoundException paramBundle)
      {
        for (;;)
        {
          paramBundle.printStackTrace();
        }
        if ((this.jdField_d_of_type_Boolean) && (EquipmentLockImpl.a().c()))
        {
          f();
          return;
        }
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    e();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevActivity
 * JD-Core Version:    0.7.0.1
 */