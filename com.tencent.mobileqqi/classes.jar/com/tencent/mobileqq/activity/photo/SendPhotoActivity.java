package com.tencent.mobileqq.activity.photo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.utils.FileUtils;
import esd;
import java.util.ArrayList;

public class SendPhotoActivity
  extends BaseActivity
{
  public static final String a;
  private ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
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
      PhotoUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, i, this.jdField_b_of_type_JavaUtilArrayList);
    }
  }
  
  private void e()
  {
    String str1 = AppConstants.an + "photo/" + ".nomedia";
    String str2 = AppConstants.an + "thumb/" + ".nomedia";
    String str3 = AppConstants.an + "thumb2/" + ".nomedia";
    FileUtils.b(str1);
    FileUtils.b(str2);
    FileUtils.b(str3);
  }
  
  public void a(int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null) {
        d();
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
        if (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing()) {
          break;
        }
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        return;
        this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(this, 2131624405);
        this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(true);
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2130903317);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131232066));
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      Logger.b("PIC_TAG_ERROR", "SendPhotoActivity.showProgressDialog", localThrowable.toString());
    }
  }
  
  public void d()
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
      return true;
    }
    new esd(this).execute(new Void[0]);
    return true;
  }
  
  public boolean showPreview()
  {
    a(2131562664);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.SendPhotoActivity
 * JD-Core Version:    0.7.0.1
 */