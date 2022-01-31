package com.tencent.mobileqq.activity.photo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import cix;
import ciy;
import com.tencent.mobileqq.activity.PortraitImageview;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.widget.QQToast;

public class PhotoCropActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public int a;
  Intent jdField_a_of_type_AndroidContentIntent;
  public Handler a;
  public ViewGroup a;
  Button jdField_a_of_type_AndroidWidgetButton;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public PortraitImageview a;
  PhotoCropAction jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropAction;
  public RegionView a;
  public String a;
  boolean jdField_a_of_type_Boolean = false;
  String[] jdField_a_of_type_ArrayOfJavaLangString;
  public int b;
  String b;
  public int c;
  public String c;
  public int d;
  String d;
  public int e;
  public int f;
  
  private boolean c()
  {
    Intent localIntent = getIntent();
    this.jdField_a_of_type_AndroidContentIntent = localIntent;
    this.jdField_b_of_type_JavaLangString = localIntent.getStringExtra("FROM_WHERE");
    localIntent.removeExtra("FROM_WHERE");
    this.jdField_c_of_type_JavaLangString = localIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    this.jdField_d_of_type_JavaLangString = localIntent.getStringExtra("PhotoConst.QZONE_COVER_CROP_LEFT_TITLE");
    this.jdField_b_of_type_Int = localIntent.getIntExtra("PhotoConst.CLIP_WIDTH", 400);
    this.jdField_c_of_type_Int = localIntent.getIntExtra("PhotoConst.CLIP_HEIGHT", 400);
    this.jdField_d_of_type_Int = localIntent.getIntExtra("PhotoConst.TARGET_WIDTH", 400);
    this.e = localIntent.getIntExtra("PhotoConst.TARGET_HEIGHT", 400);
    this.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("PhotoConst.TARGET_PATH");
    if (this.jdField_a_of_type_JavaLangString == null)
    {
      QQToast.a(this, 2131363947, 0).a();
      return false;
    }
    this.f = localIntent.getIntExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", 1);
    this.jdField_a_of_type_Int = localIntent.getIntExtra("PhotoConst.COMPRESS_QUALITY", 100);
    this.jdField_a_of_type_ArrayOfJavaLangString = localIntent.getStringArrayExtra("PhotoConst.QZONE_COVER_SOURCE");
    return true;
  }
  
  @SuppressLint({"NewApi"})
  void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131297422));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131297419));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297421));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_d_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview = new PortraitImageview(this);
  }
  
  protected boolean a()
  {
    if ("FROM_PHOTO_LIST".equals(this.jdField_b_of_type_JavaLangString))
    {
      Intent localIntent = getIntent();
      localIntent.setClass(this, PhotoListActivity.class);
      localIntent.removeExtra("PhotoConst.PHOTO_PATHS");
      startActivity(localIntent);
    }
    finish();
    AlbumUtil.a(this, true, false);
    return true;
  }
  
  protected boolean b()
  {
    return false;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    new ciy(this, null).execute(new Void[0]);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130903266);
    if (!c())
    {
      finish();
      return false;
    }
    a(this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.e, this.f);
    new cix(this, null).execute(new Void[0]);
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131297420: 
    default: 
      return;
    case 2131297419: 
      if (this.jdField_a_of_type_ArrayOfJavaLangString != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropAction == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropAction = new PhotoCropMenuForQzone(this);
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropAction.a(this.jdField_a_of_type_ArrayOfJavaLangString);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoRegionView != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropAction.a();
        }
      }
      for (;;)
      {
        AlbumUtil.c();
        AlbumUtil.a(this.jdField_a_of_type_AndroidContentIntent);
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoRegionView != null) {
          c();
        }
      }
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoCropActivity
 * JD-Core Version:    0.7.0.1
 */