package com.dataline.activities;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.statistics.StatisticAssist;
import ct;
import cu;
import cv;
import java.util.Observable;
import java.util.Observer;
import mqq.app.MobileQQ;
import wifiphoto.WifiPhotoDataCenter;
import wifiphoto.WifiPhotoStatusMgr;

public class LiteWifiphotoActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, Observer
{
  public static String a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new ct(this);
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  boolean jdField_a_of_type_Boolean = false;
  private TextView b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "LiteWifiphotoActivity";
  }
  
  private void d()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.dataline.wifiphoto.ACTION_WIFIPHOTO_CLOSE");
    localIntentFilter.addAction("com.tencent.dataline.wifiphoto.ACTION_WIFIPHOTO_CONNECTED");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  private void e()
  {
    setTitle(2131558536);
    if (this.jdField_a_of_type_Boolean)
    {
      this.m.setVisibility(4);
      String str = this.k.getText().toString();
      if (str.contains(getString(2131561807)))
      {
        this.jdField_b_of_type_AndroidWidgetTextView = this.k;
        f();
      }
      do
      {
        return;
        if (str.contains(getString(2131561870)))
        {
          this.jdField_b_of_type_AndroidWidgetTextView = this.k;
          this.jdField_b_of_type_AndroidWidgetTextView = this.k;
          f();
          return;
        }
      } while (!str.contains(getString(2131558673)));
      return;
    }
    this.k.setVisibility(4);
    this.m.setVisibility(0);
    this.m.setText(getString(2131558535));
    this.m.setOnClickListener(new cu(this));
  }
  
  private void f()
  {
    int i;
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      QQMessageFacade localQQMessageFacade = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (localQQMessageFacade != null)
      {
        i = localQQMessageFacade.f();
        if (i <= 0) {
          break label107;
        }
        if (i <= 99) {
          break label66;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131561807) + "(99+)");
      }
    }
    return;
    label66:
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131561807) + "(" + i + ")");
    return;
    label107:
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131561807));
  }
  
  protected boolean b()
  {
    StatisticAssist.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "Clk_wp_back");
    return super.b();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903526);
    d();
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("isFromStatusbar", false);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131232792));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231293));
    paramBundle = (DataLineHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
    if (DataLineHandler.a.a.b()) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131558531);
    }
    for (;;)
    {
      e();
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
      return true;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131558530);
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
    }
    unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    DataLineHandler localDataLineHandler = (DataLineHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
    if ((localDataLineHandler != null) && (!DataLineHandler.a.a.a()))
    {
      localDataLineHandler.g();
      finish();
    }
  }
  
  public void finish()
  {
    super.finish();
    if (!this.jdField_a_of_type_Boolean) {
      overridePendingTransition(0, 2130968590);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidWidgetButton == paramView)
    {
      StatisticAssist.a(a(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "Clk_disconnect_wp");
      paramView = (QQAppInterface)getAppRuntime();
      if (paramView != null)
      {
        paramView = (DataLineHandler)paramView.a(8);
        if (paramView != null)
        {
          paramView.h();
          paramView.g();
        }
      }
      finish();
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    runOnUiThread(new cv(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.dataline.activities.LiteWifiphotoActivity
 * JD-Core Version:    0.7.0.1
 */