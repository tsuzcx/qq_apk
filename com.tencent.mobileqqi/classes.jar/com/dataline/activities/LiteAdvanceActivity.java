package com.dataline.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import ca;
import cb;
import cc;
import com.dataline.util.DataLineReportUtil;
import com.tencent.mobileqq.activity.qfileJumpActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.statistics.StatisticAssist;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.Switch;
import mqq.app.MobileQQ;

public class LiteAdvanceActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public static final String a = "clear_flag";
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private Switch jdField_a_of_type_ComTencentWidgetSwitch;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private Switch jdField_b_of_type_ComTencentWidgetSwitch;
  private String jdField_b_of_type_JavaLangString = "LiteAdvanceActivity";
  private boolean jdField_b_of_type_Boolean;
  private View c;
  
  private void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putBoolean("auto_receive_files", paramBoolean).commit();
  }
  
  private void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putBoolean("dl_pc_online_notify", paramBoolean).commit();
  }
  
  private boolean c()
  {
    return this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getBoolean("auto_receive_files", false);
  }
  
  private void d()
  {
    setContentView(2130903177);
    setTitle(2131560533);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131231510);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131231512);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.c = findViewById(2131231513);
    this.c.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231511));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(AppConstants.as);
    this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131231508));
    this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new ca(this));
    this.jdField_b_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131231509));
    this.jdField_b_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_b_of_type_Boolean);
    this.jdField_b_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new cb(this));
    String str2 = this.k.getText().toString();
    String str1 = str2;
    if (!getString(2131560958).equals(str2)) {
      str1 = getString(2131559620, new Object[] { str2 });
    }
    this.k.setContentDescription(str1);
  }
  
  private void e()
  {
    String str = getString(2131558553);
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(str);
    localActionSheet.a(getResources().getString(2131558501), 3);
    localActionSheet.d(2131561746);
    localActionSheet.a(new cc(this, localActionSheet));
    localActionSheet.show();
  }
  
  private void f()
  {
    Intent localIntent = null;
    if (Environment.getExternalStorageState().equals("mounted")) {
      localIntent = new Intent(getApplicationContext(), LocalFileBrowserActivity.class);
    }
    while (localIntent == null)
    {
      return;
      FMToastUtil.a(2131558741);
    }
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("category", 6);
      localIntent.putExtra("bundle", localBundle);
      startActivityForResult(localIntent, 100);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private boolean f()
  {
    return this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getBoolean("dl_pc_online_notify", true);
  }
  
  private void g()
  {
    e();
  }
  
  private void h()
  {
    QQUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, 2130838590, qfileJumpActivity.class.getName(), getString(2131558496), d(), this.jdField_a_of_type_AndroidOsHandler, 500);
    DataLineReportUtil.q(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onCreate");
    this.jdField_a_of_type_Boolean = c();
    this.jdField_b_of_type_Boolean = f();
    d();
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131231511: 
    default: 
      return;
    case 2131231510: 
      StatisticAssist.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "dl_ckviewrecvfile");
      f();
      return;
    case 2131231512: 
      h();
      return;
    }
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.dataline.activities.LiteAdvanceActivity
 * JD-Core Version:    0.7.0.1
 */