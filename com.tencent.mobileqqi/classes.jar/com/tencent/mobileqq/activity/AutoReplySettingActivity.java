package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;
import bwj;
import bwk;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.MyCheckBox;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class AutoReplySettingActivity
  extends IphoneTitleBarActivity
{
  static final int jdField_a_of_type_Int = 2010;
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  public View a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private MyCheckBox jdField_a_of_type_ComTencentMobileqqWidgetMyCheckBox;
  public String a;
  public SharedPreferences b;
  private TextView b;
  
  public AutoReplySettingActivity()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131231160);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyCheckBox = ((MyCheckBox)findViewById(2131231013));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231161));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231162));
    this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplication.getContext().getSharedPreferences("share", 0);
    this.jdField_b_of_type_AndroidContentSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
    boolean bool = this.jdField_b_of_type_AndroidContentSharedPreferences.getBoolean(getString(2131563452) + this.jdField_a_of_type_JavaLangString, true);
    String str = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("auto_reply_msg" + this.jdField_a_of_type_JavaLangString, getString(2131561450));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyCheckBox.setChecked(bool);
    if (bool)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new bwj(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetMyCheckBox.setOnCheckedChangeListener(new bwk(this));
      return;
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  protected String a_()
  {
    return getString(2131561584);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 2010))
    {
      paramIntent = paramIntent.getStringExtra("result");
      if (QLog.isColorLevel()) {
        QLog.d("AutoReply", 2, "setAutoReplyMsg to \"" + paramIntent + "\" uin:" + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
      }
      if ((paramIntent != null) && (this.jdField_a_of_type_AndroidContentSharedPreferences != null))
      {
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("auto_reply_msg" + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramIntent).commit();
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramIntent);
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903096);
    setTitle(2131561684);
    this.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    j(2130837729);
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AutoReplySettingActivity
 * JD-Core Version:    0.7.0.1
 */