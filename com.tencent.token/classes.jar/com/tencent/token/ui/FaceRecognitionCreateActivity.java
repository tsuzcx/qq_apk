package com.tencent.token.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.e;

public class FaceRecognitionCreateActivity
  extends BaseActivity
{
  private Button btn_reg;
  private CheckBox chk;
  private Button fr_btn_scan;
  private boolean fromspalsh;
  private int istry;
  private TextView tv_licence;
  
  public static boolean getFlag()
  {
    try
    {
      boolean bool = RqdApplication.i().getSharedPreferences("create_notice_flag", 0).getBoolean("notice_flag", false);
      return bool;
    }
    catch (Exception localException)
    {
      e.c("SharedPreferences msg " + localException.getMessage());
    }
    return false;
  }
  
  private void initNotice()
  {
    setTitle(2131362242);
    this.chk = ((CheckBox)findViewById(2131296599));
    this.chk.setOnCheckedChangeListener(new il(this));
    this.fr_btn_scan = ((Button)findViewById(2131296604));
    this.fr_btn_scan.setOnClickListener(new im(this));
  }
  
  private void initReg()
  {
    this.chk = ((CheckBox)findViewById(2131296599));
    this.chk.setOnCheckedChangeListener(new ii(this));
    this.tv_licence = ((TextView)findViewById(2131296600));
    this.tv_licence.setText(Html.fromHtml(getResources().getString(2131362478)));
    this.tv_licence.setOnClickListener(new ij(this));
    this.btn_reg = ((Button)findViewById(2131296601));
    this.btn_reg.setOnClickListener(new ik(this));
  }
  
  public static void saveFlag()
  {
    try
    {
      SharedPreferences.Editor localEditor = RqdApplication.i().getSharedPreferences("create_notice_flag", 0).edit();
      localEditor.putBoolean("notice_flag", true);
      localEditor.commit();
      return;
    }
    catch (Exception localException)
    {
      e.c("SharedPreferences msg " + localException.getMessage());
    }
  }
  
  public void onBackPressed()
  {
    if (this.fromspalsh)
    {
      Intent localIntent = new Intent(this, IndexActivity.class);
      localIntent.putExtra("index_from", 21);
      startActivity(localIntent);
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.istry = getIntent().getIntExtra("istry", -1);
    this.fromspalsh = getIntent().getBooleanExtra("fromsplash", false);
    setContentView(2130903094);
    initReg();
  }
  
  protected void setDefaultBackArrow()
  {
    if ((this.mTitleBar.getVisibility() == 0) && (this.mBackArrow != null))
    {
      this.mBackArrow.setVisibility(0);
      this.mBackArrow.setOnClickListener(new ih(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.FaceRecognitionCreateActivity
 * JD-Core Version:    0.7.0.1
 */