package com.tencent.mobileqq.activity.photo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.widget.TextView;
import cku;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.utils.FileUtils;
import java.util.ArrayList;

public class SendPhotoActivity
  extends BaseActivity
{
  public static final String a;
  private ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public ArrayList a;
  public ArrayList b;
  
  static
  {
    jdField_a_of_type_JavaLangString = SendPhotoActivity.class.getName();
  }
  
  private void a(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("PhotoConst.SEND_SIZE_SPEC", -1);
    if (i != -1) {
      PhotoUtils.a(this.app, i, this.b);
    }
  }
  
  private void d()
  {
    String str1 = AppConstants.as + "photo/" + ".nomedia";
    String str2 = AppConstants.as + "thumb/" + ".nomedia";
    String str3 = AppConstants.as + "thumb2/" + ".nomedia";
    FileUtils.b(str1);
    FileUtils.b(str2);
    FileUtils.b(str3);
  }
  
  public void a(int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null) {
        c();
      }
      while (!this.jdField_a_of_type_AndroidAppProgressDialog.isShowing())
      {
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        return;
        this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(this, 2131624120);
        this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(true);
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2130903271);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131297431));
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      Logger.b("PIC_TAG_ERROR", "SendPhotoActivity.showProgressDialog", localThrowable.toString());
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_AndroidAppProgressDialog != null) && (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppProgressDialog.cancel();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (!FileUtils.a(this)) {}
    this.jdField_a_of_type_JavaUtilArrayList = getIntent().getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      Logger.b(jdField_a_of_type_JavaLangString, "initPicUploadInfos", "paths is null");
      finish();
    }
    return true;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    Looper.myQueue().addIdleHandler(new cku(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.SendPhotoActivity
 * JD-Core Version:    0.7.0.1
 */