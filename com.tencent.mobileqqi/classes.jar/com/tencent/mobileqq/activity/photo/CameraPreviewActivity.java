package com.tencent.mobileqq.activity.photo;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBar;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.photo.AIOPhotoListUtils;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.widget.Gallery;
import emg;
import emh;
import emi;
import emj;
import emk;
import eml;
import emm;
import java.util.ArrayList;

public class CameraPreviewActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(0);
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public QQCustomDialog a;
  private Gallery jdField_a_of_type_ComTencentWidgetGallery;
  private emm jdField_a_of_type_Emm;
  String jdField_a_of_type_JavaLangString = null;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_a_of_type_Boolean;
  private int b;
  
  private void a(int paramInt)
  {
    String str1;
    String str2;
    if (paramInt == 6)
    {
      str1 = getString(2131562820);
      str2 = getString(2131562825);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230, str1, str2, new emj(this), null);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnCancelListener(new emk(this));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(new eml(this));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
      if (paramInt == 7)
      {
        str1 = getString(2131562823);
        str2 = getString(2131563058);
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
          return;
        }
        str1 = null;
        str2 = null;
      }
    }
  }
  
  private boolean c()
  {
    if (!Environment.getExternalStorageState().equalsIgnoreCase("mounted"))
    {
      a(7);
      return true;
    }
    if (AIOPhotoListUtils.a() < 10L)
    {
      a(6);
      return true;
    }
    return false;
  }
  
  private void d()
  {
    boolean bool2 = true;
    Intent localIntent = getIntent();
    this.jdField_a_of_type_JavaUtilArrayList = localIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    int i = localIntent.getIntExtra("uintype", 1003);
    boolean bool1 = bool2;
    if (i != 0)
    {
      bool1 = bool2;
      if (i != 1) {
        if (i != 3000) {
          break label69;
        }
      }
    }
    label69:
    for (bool1 = bool2;; bool1 = false)
    {
      this.jdField_a_of_type_Boolean = bool1;
      this.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("PhotoConst.CUSTOM_SENDBTN_TEXT");
      return;
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentWidgetGallery = new Gallery(this);
    this.jdField_a_of_type_ComTencentWidgetGallery.setSpacing(getResources().getDimensionPixelSize(2131427411));
    this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentWidgetGallery, -1, -1);
    this.jdField_a_of_type_Emm = new emm(this);
    this.jdField_a_of_type_ComTencentWidgetGallery.setAdapter(this.jdField_a_of_type_Emm);
  }
  
  protected boolean a()
  {
    return false;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.hide();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    PhotoUtils.a(this, paramInt1, paramInt2, paramIntent, false);
  }
  
  public void onClick(View paramView) {}
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    d();
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)getLayoutInflater().inflate(2130903315, null));
    e();
    getLayoutInflater().inflate(2130903317, this.jdField_a_of_type_AndroidViewViewGroup);
    this.jdField_a_of_type_Int = getResources().getDisplayMetrics().widthPixels;
    this.b = getResources().getDisplayMetrics().heightPixels;
    setContentView(this.jdField_a_of_type_AndroidViewViewGroup);
    if (this.jdField_a_of_type_Boolean) {
      c(2131562154, new emg(this));
    }
    paramBundle = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232063);
    if (this.jdField_a_of_type_JavaLangString != null) {
      paramBundle.setText(this.jdField_a_of_type_JavaLangString);
    }
    paramBundle.setOnClickListener(new emh(this));
    this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232062).setOnClickListener(new emi(this));
    getSupportActionBar().setTitle(2131562660);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.CameraPreviewActivity
 * JD-Core Version:    0.7.0.1
 */