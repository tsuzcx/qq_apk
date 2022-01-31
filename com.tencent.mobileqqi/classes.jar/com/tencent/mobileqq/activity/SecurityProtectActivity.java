package com.tencent.mobileqq.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticon.DownloadInfo;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.HttpDownloadUtil.DownloadInfoListener;
import com.tencent.mobileqq.utils.JumpQqPimSecureUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import dhm;
import dhn;

public class SecurityProtectActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, HttpDownloadUtil.DownloadInfoListener
{
  private Button jdField_a_of_type_AndroidWidgetButton = null;
  private ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  private TextView jdField_a_of_type_AndroidWidgetTextView = null;
  public Long a;
  public String a;
  private boolean jdField_a_of_type_Boolean = false;
  private TextView jdField_b_of_type_AndroidWidgetTextView = null;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c = false;
  
  public SecurityProtectActivity()
  {
    this.jdField_a_of_type_JavaLangString = "http://qqwx.qq.com/s?aid=index&g_f=407";
    this.jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
  }
  
  public void a(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo.b == 0)
    {
      this.jdField_a_of_type_JavaLangLong = Long.valueOf(paramDownloadInfo.d);
      if ((NetworkUtil.e(a())) && (this.jdField_a_of_type_JavaLangLong.longValue() > 0L))
      {
        paramDownloadInfo = new Bundle();
        paramDownloadInfo.putString("_filename_from_dlg", getString(2131559117));
        paramDownloadInfo.putLong("_filesize_from_dlg", this.jdField_a_of_type_JavaLangLong.longValue());
        UniformDownloadMgr.a().a(this.jdField_a_of_type_JavaLangString, paramDownloadInfo);
      }
    }
    else
    {
      this.jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
    }
    new Handler(Looper.getMainLooper()).post(new dhn(this));
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903951);
    setTitle(2131562385);
    ((TextView)findViewById(2131231456)).setVisibility(8);
    c(2131561746, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131234417));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131232950));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131232960));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131232951));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetButton.setFocusable(true);
    return true;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.c == true)
    {
      finish();
      return;
    }
    this.jdField_a_of_type_Boolean = JumpQqPimSecureUtil.a(this);
    this.jdField_b_of_type_Boolean = JumpQqPimSecureUtil.b(this);
    String str;
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839701);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131562016);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131562764);
      if (!this.jdField_b_of_type_Boolean) {
        break label192;
      }
      str = "qqpimsecure is running";
    }
    for (;;)
    {
      ReportController.b(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_", str, 0, 0, "", "", "", "");
      return;
      if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839702);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131562386);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131562763);
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839700);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131558466);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131563104);
      break;
      label192:
      if (this.jdField_a_of_type_Boolean) {
        str = "qqpimsecure installed but not running";
      } else {
        str = "qqpimsecure not installed";
      }
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    if (this.c == true) {
      finish();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131232951: 
      if (!this.jdField_a_of_type_Boolean)
      {
        ThreadManager.a(new dhm(this));
        this.c = true;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131562257);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        ((LinearLayout)findViewById(2131234418)).setVisibility(0);
        ReportController.b(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_", "click on bluebtn download qqpimsecure", 0, 0, "", "", "", "");
        return;
      }
      if (!this.jdField_b_of_type_Boolean)
      {
        JumpQqPimSecureUtil.a(this, "mobileqq", 7798785);
        ReportController.b(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_", "click on bluebtn weakup qqpimsecure", 0, 0, "", "", "", "");
        return;
      }
      JumpQqPimSecureUtil.a(this, "mobileqq", 8716289);
      ReportController.b(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_", "click on bluebtn run_scan", 0, 0, "", "", "", "");
      return;
    }
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SecurityProtectActivity
 * JD-Core Version:    0.7.0.1
 */