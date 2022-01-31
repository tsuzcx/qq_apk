package com.tencent.mobileqq.activity.photo;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import cjd;
import cje;
import cjf;
import cjg;
import cji;
import cjj;
import cjk;
import cjl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class PhotoPreviewActivity
  extends PeakActivity
{
  public int a;
  public View a;
  Button jdField_a_of_type_AndroidWidgetButton;
  public CheckBox a;
  public TextView a;
  cjl jdField_a_of_type_Cjl;
  ProGallery jdField_a_of_type_ComTencentMobileqqActivityPhotoProGallery;
  String jdField_a_of_type_JavaLangString;
  public ArrayList a;
  boolean jdField_a_of_type_Boolean = false;
  public int b;
  public View b;
  public Button b;
  String jdField_b_of_type_JavaLangString;
  public ArrayList b;
  boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  View jdField_c_of_type_AndroidViewView;
  String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean = false;
  String jdField_d_of_type_JavaLangString;
  boolean jdField_d_of_type_Boolean = false;
  private String jdField_e_of_type_JavaLangString = null;
  boolean jdField_e_of_type_Boolean = false;
  private boolean i = true;
  private boolean j = false;
  
  public PhotoPreviewActivity()
  {
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private ArrayList a()
  {
    ArrayList localArrayList = new ArrayList();
    int k = 0;
    while (k < this.jdField_b_of_type_JavaUtilArrayList.size())
    {
      Integer localInteger = (Integer)this.jdField_b_of_type_JavaUtilArrayList.get(k);
      if ((localInteger != null) && (localInteger.intValue() >= 0) && (localInteger.intValue() < this.jdField_a_of_type_JavaUtilArrayList.size())) {
        localArrayList.add(this.jdField_a_of_type_JavaUtilArrayList.get(localInteger.intValue()));
      }
      k += 1;
    }
    return localArrayList;
  }
  
  private void a(String paramString)
  {
    if (new File(paramString).length() > 19922944L)
    {
      QQToast.a(this, getResources().getString(2131363966), 0).b(getResources().getDimensionPixelSize(2131492887));
      this.jdField_c_of_type_Int = 0;
      f();
    }
  }
  
  private void a(ArrayList paramArrayList, int paramInt1, int paramInt2)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null, 2131624119);
    PhotoMagicStickUtils.a(this, paramArrayList, localActionSheet, paramInt1);
    localActionSheet.d(2131362790);
    localActionSheet.a(new cjk(this, paramArrayList, localActionSheet));
    localActionSheet.e(paramInt2);
    localActionSheet.show();
  }
  
  private void a(ArrayList paramArrayList, ActionSheet paramActionSheet, int paramInt)
  {
    String str;
    if (paramArrayList.size() > 0)
    {
      paramActionSheet.e(paramInt);
      str = paramActionSheet.a(paramInt);
      if (str == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("_photo", 2, "onQualityBtnClick clikedBtn text:" + str);
      }
      if ((str == null) || (!str.contains(getString(2131363954)))) {
        break label90;
      }
      this.jdField_c_of_type_Int = 0;
    }
    for (;;)
    {
      f();
      paramActionSheet.dismiss();
      return;
      label90:
      if ((str != null) && (str.contains(getString(2131363955))))
      {
        this.jdField_c_of_type_Int = 2;
        if (QLog.isColorLevel()) {
          QLog.d("raw_photo_4_test", 2, "start:" + str + ",photolist:" + paramArrayList.toString());
        }
      }
    }
  }
  
  private void c()
  {
    Intent localIntent = getIntent();
    this.jdField_d_of_type_JavaLangString = localIntent.getStringExtra("FROM_WHERE");
    localIntent.removeExtra("FROM_WHERE");
    this.jdField_a_of_type_JavaUtilArrayList = localIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      localObject = localIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
    }
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (!new File((String)((Iterator)localObject).next()).exists()) {
        ((Iterator)localObject).remove();
      }
    }
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    int k = 0;
    while (k < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      this.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(k));
      k += 1;
    }
    this.jdField_a_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.HANDLE_DEST_RESULT", false);
    this.jdField_b_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", false);
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("PhotoConst.MY_UIN");
      this.jdField_b_of_type_JavaLangString = localIntent.getStringExtra("PhotoConst.MY_NICK");
      this.jdField_c_of_type_JavaLangString = localIntent.getStringExtra("PhotoConst.MY_HEAD_DIR");
    }
    if (this.jdField_a_of_type_JavaLangString == null) {}
    for (localObject = this.h;; localObject = this.jdField_a_of_type_JavaLangString)
    {
      this.jdField_a_of_type_JavaLangString = ((String)localObject);
      this.jdField_a_of_type_Int = localIntent.getIntExtra("uintype", -1);
      this.j = localIntent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false);
      this.jdField_c_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", false);
      this.jdField_d_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.IS_SINGLE_MODE", false);
      this.jdField_c_of_type_Int = localIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
      this.jdField_e_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false);
      if (this.jdField_e_of_type_Boolean) {
        PhotoUtils.a(this, getIntent(), this.jdField_a_of_type_JavaUtilArrayList, this.jdField_c_of_type_Int, true);
      }
      this.jdField_e_of_type_JavaLangString = localIntent.getStringExtra("PhotoConst.CUSTOM_SENDBTN_TEXT");
      return;
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131297424);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131297263);
    if (this.i)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131297432));
    f();
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131297433));
      this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131297431));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296936));
      this.jdField_a_of_type_AndroidWidgetCheckBox.setOnClickListener(new cjd(this));
      this.jdField_c_of_type_AndroidViewView = findViewById(2131297425);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(new cje(this));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new cjf(this));
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new cjg(this));
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoProGallery = ((ProGallery)findViewById(2131297187));
      this.jdField_a_of_type_Cjl = new cjl(this, null);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoProGallery.setAdapter(this.jdField_a_of_type_Cjl);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoProGallery.setOnNoBlankListener(this.jdField_a_of_type_Cjl);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoProGallery.setOnItemSelectedListener(new cji(this));
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoProGallery.setSpacing(getResources().getDimensionPixelSize(2131492924));
      this.jdField_b_of_type_Int = (this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoProGallery.setSelection(this.jdField_b_of_type_Int);
      e();
      if ((this.jdField_c_of_type_Boolean) || (this.jdField_d_of_type_Boolean))
      {
        this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoProGallery.setOnItemClickListener(new cjj(this));
      return;
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
  }
  
  private void e()
  {
    if (this.jdField_b_of_type_Boolean) {}
    for (String str = getString(2131363956);; str = getString(2131363957))
    {
      if (this.jdField_e_of_type_JavaLangString != null) {
        str = this.jdField_e_of_type_JavaLangString;
      }
      if (this.jdField_b_of_type_JavaUtilArrayList.size() <= 0) {
        break label139;
      }
      if ((!this.jdField_c_of_type_Boolean) && (!this.jdField_d_of_type_Boolean)) {
        break;
      }
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
      this.jdField_b_of_type_AndroidWidgetButton.setText(str);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    this.jdField_b_of_type_AndroidWidgetButton.setText(str + "(" + this.jdField_b_of_type_JavaUtilArrayList.size() + ")");
    return;
    label139:
    this.jdField_b_of_type_AndroidWidgetButton.setText(str);
    this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_c_of_type_Int = 0;
    f();
  }
  
  private void f()
  {
    switch (this.jdField_c_of_type_Int)
    {
    case 1: 
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131363954);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131363955);
  }
  
  private void g()
  {
    PhotoUtils.a(this, getIntent(), a(), this.jdField_c_of_type_Int, this.jdField_a_of_type_Boolean);
  }
  
  protected boolean a()
  {
    return false;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isDevelopLevel()) {
      QLog.d(g, 4, "[PhotoPreviewActivity] [onActivityResult] requestCode = " + paramInt1 + "  resultCode:" + paramInt2 + "  ok:" + -1);
    }
    PhotoUtils.a(this, paramInt1, paramInt2, paramIntent, this.j, this.jdField_a_of_type_JavaLangString);
  }
  
  public void onBackPressed()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoProGallery.a(false)) {
      return;
    }
    if ("FROM_PHOTO_LIST".equals(this.jdField_d_of_type_JavaLangString))
    {
      Intent localIntent = getIntent();
      localIntent.setClass(this, PhotoListActivity.class);
      localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_c_of_type_Int);
      if (this.jdField_d_of_type_Boolean) {
        localIntent.removeExtra("PhotoConst.PHOTO_PATHS");
      }
      for (;;)
      {
        startActivity(localIntent);
        finish();
        AlbumUtil.a(this, true, false);
        return;
        localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", a());
      }
    }
    finish();
    AlbumUtil.a(this, true, false);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2130903270);
    c();
    d();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    int k = 0;
    try
    {
      while (k < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if ((String)this.jdField_a_of_type_JavaUtilArrayList.get(k) != null)
        {
          File localFile = new File((String)this.jdField_a_of_type_JavaUtilArrayList.get(k));
          URLDrawable.removeMemoryCacheByUrl(localFile.toURL().toString());
          URLDrawable.removeMemoryCacheByUrl(localFile.toURL().toString() + "#NOSAMPLE");
        }
        k += 1;
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PhotoPreviewActivity", 2, "remove file error");
      }
    }
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    c();
    d();
  }
  
  @TargetApi(9)
  protected void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoPreviewActivity
 * JD-Core Version:    0.7.0.1
 */