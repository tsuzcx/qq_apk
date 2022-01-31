package com.dataline.activities;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import bu;
import bv;
import bw;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.statistics.StatisticAssist;
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
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new bu(this);
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  boolean jdField_a_of_type_Boolean = false;
  private TextView b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "LiteWifiphotoActivity";
  }
  
  private void c()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.dataline.wifiphoto.ACTION_WIFIPHOTO_CLOSE");
    localIntentFilter.addAction("com.tencent.dataline.wifiphoto.ACTION_WIFIPHOTO_CONNECTED");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  private void d()
  {
    setTitle(2131361862);
    if (this.jdField_a_of_type_Boolean)
    {
      this.j.setVisibility(4);
      String str = this.h.getText().toString();
      if (str.contains(getString(2131362950)))
      {
        this.b = this.h;
        e();
      }
      do
      {
        return;
        if (str.contains(getString(2131362941)))
        {
          this.b = this.h;
          this.b = this.h;
          e();
          return;
        }
      } while (!str.contains(getString(2131361938)));
      return;
    }
    this.h.setVisibility(4);
    this.j.setVisibility(0);
    this.j.setText(getString(2131361861));
    this.j.setOnClickListener(new bv(this));
  }
  
  private void e()
  {
    int i;
    if (this.b != null)
    {
      QQMessageFacade localQQMessageFacade = this.app.a();
      if (localQQMessageFacade != null)
      {
        i = localQQMessageFacade.e();
        if (i <= 0) {
          break label107;
        }
        if (i <= 99) {
          break label66;
        }
        this.b.setText(getString(2131362950) + "(99+)");
      }
    }
    return;
    label66:
    this.b.setText(getString(2131362950) + "(" + i + ")");
    return;
    label107:
    this.b.setText(getString(2131362950));
  }
  
  protected boolean a()
  {
    StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.a(), "Clk_wp_back");
    return super.a();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903452);
    c();
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("isFromStatusbar", false);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131298085));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296760));
    paramBundle = (DataLineHandler)this.app.a(8);
    if (DataLineHandler.a.a.b()) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131361857);
    }
    for (;;)
    {
      d();
      getWindow().addFlags(128);
      this.app.a().addObserver(this);
      return true;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131361856);
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.app.a() != null) {
      this.app.a().deleteObserver(this);
    }
    unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    DataLineHandler localDataLineHandler = (DataLineHandler)this.app.a(8);
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
      overridePendingTransition(0, 2130968584);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidWidgetButton == paramView)
    {
      StatisticAssist.a(getActivity(), this.app.a(), "Clk_disconnect_wp");
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
    runOnUiThread(new bw(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.dataline.activities.LiteWifiphotoActivity
 * JD-Core Version:    0.7.0.1
 */