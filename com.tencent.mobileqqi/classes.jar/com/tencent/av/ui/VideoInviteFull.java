package com.tencent.av.ui;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import bld;
import com.tencent.av.VideoController;
import com.tencent.av.report.AVReport;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

public class VideoInviteFull
  extends VideoInviteActivity
{
  public static String g = "VideoInviteFull";
  final BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new bld(this, 0);
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  final BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver = new bld(this, 1);
  ImageButton jdField_b_of_type_AndroidWidgetImageButton;
  final BroadcastReceiver c = new bld(this, 2);
  public boolean f;
  int i = 0;
  
  public VideoInviteFull()
  {
    this.jdField_f_of_type_Boolean = false;
  }
  
  public void BtnOnClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(false);
      this.jdField_b_of_type_AndroidWidgetImageButton.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      return;
      this.jdField_d_of_type_Boolean = false;
      b();
      if (this.jdField_b_of_type_Boolean)
      {
        ReportController.b(null, "CliOper", "", "", "0X8004398", "0X8004398", 0, 0, Integer.toString(this.jdField_d_of_type_Int), Integer.toString(this.jdField_f_of_type_Int), "", "");
      }
      else
      {
        ReportController.b(null, "CliOper", "", "", "0X80043F6", "0X80043F6", 0, 0, Integer.toString(this.jdField_d_of_type_Int), Integer.toString(this.jdField_f_of_type_Int), "", "");
        continue;
        this.jdField_d_of_type_Boolean = true;
        c();
        if (this.jdField_b_of_type_Boolean)
        {
          ReportController.b(null, "CliOper", "", "", "0X8004397", "0X8004397", 0, 0, Integer.toString(this.jdField_d_of_type_Int), Integer.toString(this.jdField_f_of_type_Int), "", "");
        }
        else
        {
          ReportController.b(null, "CliOper", "", "", "0X80043F5", "0X80043F5", 0, 0, Integer.toString(this.jdField_d_of_type_Int), Integer.toString(this.jdField_f_of_type_Int), "", "");
          continue;
          this.jdField_a_of_type_Boolean = true;
          this.jdField_d_of_type_Boolean = true;
          c();
          ReportController.b(null, "CliOper", "", "", "0X80043F7", "0X80043F7", 0, 0, Integer.toString(this.jdField_d_of_type_Int), Integer.toString(this.jdField_f_of_type_Int), "", "");
        }
      }
    }
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131232259));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131232260));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131232257));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)super.findViewById(2131232264));
    this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)super.findViewById(2131232263));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131232265));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131560129);
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131560237);
      this.jdField_a_of_type_AndroidWidgetImageButton.setBackgroundResource(2130838217);
    }
    g();
    Object localObject;
    if (this.jdField_b_of_type_Boolean)
    {
      UITools.a(this.jdField_b_of_type_AndroidWidgetImageButton, super.getString(2131560159));
      UITools.a(this.jdField_a_of_type_AndroidWidgetImageButton, super.getString(2131560160));
      localObject = this.jdField_d_of_type_JavaLangString + super.getString(2131560157);
      UITools.a(this.jdField_a_of_type_AndroidWidgetTextView, (String)localObject);
    }
    for (;;)
    {
      localObject = (ImageView)super.findViewById(2131232212);
      localObject = (ImageView)super.findViewById(2131232213);
      localObject = (ImageView)super.findViewById(2131232214);
      if (QLog.isColorLevel()) {
        QLog.d(g, 2, "video invite full onCreate OK");
      }
      return;
      UITools.a(this.jdField_b_of_type_AndroidWidgetImageButton, super.getString(2131560184));
      UITools.a(this.jdField_a_of_type_AndroidWidgetImageButton, super.getString(2131560185));
      localObject = this.jdField_d_of_type_JavaLangString + super.getString(2131560183);
      UITools.a(this.jdField_a_of_type_AndroidWidgetTextView, (String)localObject);
    }
  }
  
  void i()
  {
    IntentFilter localIntentFilter = new IntentFilter("tencent.notify.cancel.videorequest");
    super.registerReceiver(this.c, localIntentFilter);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(g, 2, "onCreate");
    }
    AVReport.a().u = SystemClock.elapsedRealtime();
    super.onCreate(paramBundle);
    super.setContentView(2130903354);
    super.getWindow().addFlags(2097152);
    this.i = UITools.b(super.getApplicationContext());
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.SCREEN_OFF");
    super.registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, paramBundle);
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    super.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    i();
    a();
    paramBundle = (TextView)findViewById(2131232261);
    if (!NetworkUtil.g(getApplicationContext()))
    {
      if (NetworkUtil.c(getApplicationContext()))
      {
        paramBundle.setVisibility(0);
        paramBundle.setText(2131560239);
      }
      if (NetworkUtil.d(getApplicationContext()))
      {
        paramBundle.setVisibility(0);
        paramBundle.setText(2131560238);
      }
    }
    while (this.jdField_b_of_type_Boolean)
    {
      ReportController.b(null, "CliOper", "", "", "0X8004396", "0X8004396", 0, 0, Integer.toString(this.jdField_d_of_type_Int), Integer.toString(this.jdField_f_of_type_Int), "", "");
      return;
      if (this.jdField_b_of_type_Boolean)
      {
        paramBundle.setVisibility(0);
        paramBundle.setText(2131560220);
      }
    }
    ReportController.b(null, "CliOper", "", "", "0X80043F4", "0X80043F4", 0, 0, Integer.toString(this.jdField_d_of_type_Int), Integer.toString(this.jdField_f_of_type_Int), "", "");
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d(g, 2, "onDestroy");
    }
    super.unregisterReceiver(this.c);
    super.unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
    super.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (!this.jdField_f_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentAvVideoController.a();
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (!this.jdField_b_of_type_Boolean) {
        break label55;
      }
      ReportController.b(null, "CliOper", "", "", "0X800439A", "0X800439A", 0, 0, Integer.toString(this.jdField_d_of_type_Int), Integer.toString(this.jdField_f_of_type_Int), "", "");
    }
    for (;;)
    {
      return super.onKeyDown(paramInt, paramKeyEvent);
      label55:
      ReportController.b(null, "CliOper", "", "", "0X80043F9", "0X80043F9", 0, 0, Integer.toString(this.jdField_d_of_type_Int), Integer.toString(this.jdField_f_of_type_Int), "", "");
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      AVReport.a().v = SystemClock.elapsedRealtime();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteFull
 * JD-Core Version:    0.7.0.1
 */