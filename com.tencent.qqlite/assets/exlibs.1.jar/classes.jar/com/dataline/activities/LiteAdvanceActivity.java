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
import bb;
import bc;
import bd;
import com.dataline.util.DataLineReportUtil;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.qfileJumpActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.statistics.StatisticAssist;
import com.tencent.mobileqq.utils.QQUtils;
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
    this.app.getPreferences().edit().putBoolean("auto_receive_files", paramBoolean).commit();
  }
  
  private void b(boolean paramBoolean)
  {
    this.app.getPreferences().edit().putBoolean("dl_pc_online_notify", paramBoolean).commit();
  }
  
  private void c()
  {
    setContentView(2130903151);
    setTitle(2131362438);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131296956);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131296959);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.c = findViewById(2131296960);
    this.c.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296958));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(AppConstants.ay);
    this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131296954));
    this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new bb(this));
    this.jdField_b_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131296955));
    this.jdField_b_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_b_of_type_Boolean);
    this.jdField_b_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new bc(this));
  }
  
  private boolean c()
  {
    return this.app.getPreferences().getBoolean("auto_receive_files", false);
  }
  
  private void d()
  {
    String str = getString(2131361879);
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null, 2131624119);
    localActionSheet.a(str);
    localActionSheet.a(getResources().getString(2131361827), 3);
    localActionSheet.d(2131362794);
    localActionSheet.a(new bd(this, localActionSheet));
    localActionSheet.show();
  }
  
  private void e()
  {
    Intent localIntent = null;
    if (Environment.getExternalStorageState().equals("mounted")) {
      localIntent = new Intent(getApplicationContext(), LocalFileBrowserActivity.class);
    }
    while (localIntent == null)
    {
      return;
      FMToastUtil.a(2131362001);
    }
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("category", 6);
      localIntent.putExtra("bundle", localBundle);
      localIntent.putExtra("localSdCardfile", 0);
      startActivityForResult(localIntent, 103);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void f()
  {
    d();
  }
  
  private boolean f()
  {
    return this.app.getPreferences().getBoolean("dl_pc_online_notify", true);
  }
  
  private void g()
  {
    QQUtils.a(this.app, 2130838504, qfileJumpActivity.class.getName(), getString(2131361822), getTitleBarHeight(), this.jdField_a_of_type_AndroidOsHandler, 500);
    DataLineReportUtil.q(this.app);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramIntent != null) && (paramIntent.getExtras() != null))
    {
      Intent localIntent = new Intent(this, ChatActivity.class);
      localIntent.putExtras(new Bundle(paramIntent.getExtras()));
      localIntent.addFlags(268435456);
      localIntent.addFlags(67108864);
      startActivity(localIntent);
      finish();
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Boolean = c();
    this.jdField_b_of_type_Boolean = f();
    c();
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131296957: 
    case 2131296958: 
    default: 
      return;
    case 2131296956: 
      StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.a(), "dl_ckviewrecvfile");
      e();
      return;
    case 2131296959: 
      g();
      return;
    }
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.dataline.activities.LiteAdvanceActivity
 * JD-Core Version:    0.7.0.1
 */