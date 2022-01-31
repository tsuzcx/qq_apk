package com.tencent.mobileqq.filemanager.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import fsm;
import fso;

public class UniformDownloadActivity
  extends BaseActivity
{
  public static String a;
  public static String b = "URL";
  public static String c = "buttonType";
  public static String d = "filename";
  public static String e = "filesize";
  public static String f = "filetype";
  private long jdField_a_of_type_Long = 0L;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  public QQAppInterface a;
  private String g = null;
  private String h = null;
  
  static
  {
    jdField_a_of_type_JavaLangString = "UniformDownloadActivity<FileAssistant>";
  }
  
  private void d()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("_filename_from_dlg", this.h);
    localBundle.putLong("_filesize_from_dlg", this.jdField_a_of_type_Long);
    UniformDownloadMgr.a().a(this.g, localBundle);
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. >>> downloadFile. url:" + this.g);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130903512);
    paramBundle = (TextView)findViewById(2131232778);
    TextView localTextView = (TextView)findViewById(2131232779);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131232771));
    if (localTextView != null)
    {
      if (getIntent().getLongExtra(c, 0L) == 1L) {
        localTextView.setText(2131562563);
      }
      localTextView.setOnClickListener(new fsm(this));
    }
    if (paramBundle != null) {
      paramBundle.setOnClickListener(new fso(this));
    }
    paramBundle = getIntent();
    this.g = paramBundle.getStringExtra(b);
    this.h = paramBundle.getStringExtra(d);
    this.jdField_a_of_type_Long = paramBundle.getLongExtra(e, 0L);
    paramBundle = (TextView)findViewById(2131232774);
    localTextView = (TextView)findViewById(2131232775);
    ImageView localImageView = (ImageView)findViewById(2131232772);
    paramBundle.setText(this.h);
    localTextView.setText(FileUtil.a(this.jdField_a_of_type_Long));
    int i = FileManagerUtil.b(this.h);
    if (i != 0) {
      localImageView.setImageResource(i);
    }
    for (;;)
    {
      return true;
      localImageView.setImageResource(2130838625);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity
 * JD-Core Version:    0.7.0.1
 */