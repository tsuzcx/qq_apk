package com.tencent.mobileqq.activity.photo;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.model.BaseBusinessAlbumInfo;
import ers;
import ert;
import eru;
import erv;
import erw;
import ery;
import erz;
import esa;
import esb;
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
  PreloadGallery jdField_a_of_type_ComTencentMobileqqActivityPhotoPreloadGallery;
  esb jdField_a_of_type_Esb;
  public String a;
  public ArrayList a;
  public boolean a;
  public int b;
  public View b;
  Button jdField_b_of_type_AndroidWidgetButton;
  public String b;
  public ArrayList b;
  boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  View jdField_c_of_type_AndroidViewView;
  public Button c;
  public String c;
  boolean jdField_c_of_type_Boolean = false;
  String jdField_d_of_type_JavaLangString;
  boolean jdField_d_of_type_Boolean = false;
  private String jdField_e_of_type_JavaLangString = null;
  boolean jdField_e_of_type_Boolean = false;
  private String f;
  private String jdField_i_of_type_JavaLangString;
  private boolean jdField_i_of_type_Boolean = true;
  private String jdField_j_of_type_JavaLangString;
  private boolean jdField_j_of_type_Boolean = false;
  private String jdField_k_of_type_JavaLangString;
  private boolean jdField_k_of_type_Boolean = false;
  
  public PhotoPreviewActivity()
  {
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Boolean = false;
  }
  
  private ArrayList a()
  {
    ArrayList localArrayList = new ArrayList();
    int m = 0;
    while (m < this.jdField_b_of_type_JavaUtilArrayList.size())
    {
      Integer localInteger = (Integer)this.jdField_b_of_type_JavaUtilArrayList.get(m);
      if ((localInteger != null) && (localInteger.intValue() >= 0) && (localInteger.intValue() < this.jdField_a_of_type_JavaUtilArrayList.size())) {
        localArrayList.add(this.jdField_a_of_type_JavaUtilArrayList.get(localInteger.intValue()));
      }
      m += 1;
    }
    return localArrayList;
  }
  
  private void a(String paramString)
  {
    if (new File(paramString).length() > 19922944L)
    {
      QQToast.a(this, getResources().getString(2131561477), 0).b(getResources().getDimensionPixelSize(2131427376));
      this.jdField_c_of_type_Int = 0;
      f();
    }
  }
  
  private void a(ArrayList paramArrayList, int paramInt1, int paramInt2)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    PhotoMagicStickUtils.a(this, paramArrayList, localActionSheet, paramInt1);
    localActionSheet.d(2131561746);
    localActionSheet.a(new esa(this, paramArrayList, localActionSheet));
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
      if ((str == null) || (!str.contains(getString(2131562937)))) {
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
      if ((str != null) && (str.contains(getString(2131562273))))
      {
        this.jdField_c_of_type_Int = 1;
        if (QLog.isColorLevel()) {
          QLog.d("raw_photo_4_test", 2, "start:" + str + ",photolist:" + paramArrayList.toString());
        }
      }
    }
  }
  
  private void c()
  {
    Intent localIntent = getIntent();
    this.jdField_a_of_type_JavaUtilArrayList = localIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    this.jdField_d_of_type_JavaLangString = localIntent.getStringExtra("FROM_WHERE");
    localIntent.removeExtra("FROM_WHERE");
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
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
    int m = 0;
    while (m < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      this.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(m));
      m += 1;
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
      this.jdField_j_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false);
      this.jdField_c_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", false);
      this.jdField_d_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.IS_SINGLE_MODE", false);
      this.jdField_c_of_type_Int = localIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
      this.jdField_e_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false);
      if (this.jdField_e_of_type_Boolean) {
        PhotoUtils.a(this, getIntent(), this.jdField_a_of_type_JavaUtilArrayList, this.jdField_c_of_type_Int, true);
      }
      this.jdField_e_of_type_JavaLangString = localIntent.getStringExtra("PhotoConst.CUSTOM_SENDBTN_TEXT");
      this.jdField_k_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.IS_JUMPTO_TROOP_ALBUM", false);
      if (this.jdField_k_of_type_Boolean)
      {
        this.jdField_i_of_type_JavaLangString = localIntent.getStringExtra("uinname");
        this.f = localIntent.getStringExtra("uin");
      }
      if ((this.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_JavaLangString != null))
      {
        localObject = QZoneHelper.a(this.jdField_a_of_type_JavaLangString, this.f);
        if ((localObject == null) || (((BaseBusinessAlbumInfo)localObject).b() == null) || (((BaseBusinessAlbumInfo)localObject).b().equals(""))) {
          break;
        }
        this.jdField_j_of_type_JavaLangString = ((BaseBusinessAlbumInfo)localObject).b();
        this.jdField_k_of_type_JavaLangString = ((BaseBusinessAlbumInfo)localObject).c();
        localIntent.putExtra("UploadPhoto.key_album_id", this.jdField_j_of_type_JavaLangString);
        localIntent.putExtra("UploadPhoto.key_album_name", this.jdField_k_of_type_JavaLangString);
      }
      return;
    }
    localIntent.putExtra("UploadPhoto.key_album_id", "");
    localIntent.putExtra("UploadPhoto.key_album_name", "");
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131232054);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131232052);
    if (this.jdField_i_of_type_Boolean) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131232062));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131232063));
    f();
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131232064));
      this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131232061));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131230941));
      this.jdField_a_of_type_AndroidWidgetCheckBox.setOnClickListener(new ers(this));
      this.jdField_c_of_type_AndroidViewView = findViewById(2131232055);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(new ert(this));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new eru(this));
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new erv(this));
      this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(new erw(this));
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPreloadGallery = ((PreloadGallery)findViewById(2131231775));
      this.jdField_a_of_type_Esb = new esb(this, null);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPreloadGallery.setAdapter(this.jdField_a_of_type_Esb);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPreloadGallery.setOnNoBlankListener(this.jdField_a_of_type_Esb);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPreloadGallery.setOnItemSelectedListener(new ery(this));
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPreloadGallery.setSpacing(getResources().getDimensionPixelSize(2131427408));
      this.jdField_b_of_type_Int = (this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPreloadGallery.setSelection(this.jdField_b_of_type_Int);
      e();
      if ((this.jdField_c_of_type_Boolean) || (this.jdField_d_of_type_Boolean))
      {
        this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPreloadGallery.setOnItemClickListener(new erz(this));
      return;
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    }
  }
  
  private void e()
  {
    if (this.jdField_b_of_type_Boolean) {}
    for (String str = getString(2131562858);; str = getString(2131562536))
    {
      if (this.jdField_k_of_type_Boolean) {
        str = getString(2131563141);
      }
      if (this.jdField_e_of_type_JavaLangString != null) {
        str = this.jdField_e_of_type_JavaLangString;
      }
      if (this.jdField_b_of_type_JavaUtilArrayList.size() <= 0) {
        break label191;
      }
      if ((!this.jdField_c_of_type_Boolean) && (!this.jdField_d_of_type_Boolean)) {
        break;
      }
      this.jdField_c_of_type_AndroidWidgetButton.setEnabled(true);
      this.jdField_c_of_type_AndroidWidgetButton.setText(str);
      return;
    }
    this.jdField_c_of_type_AndroidWidgetButton.setEnabled(true);
    this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
    if ((this.jdField_b_of_type_JavaUtilArrayList.size() == 1) && (!this.jdField_k_of_type_Boolean)) {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetButton.setText(str + "(" + this.jdField_b_of_type_JavaUtilArrayList.size() + ")");
      return;
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    }
    label191:
    this.jdField_c_of_type_AndroidWidgetButton.setText(str);
    this.jdField_c_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_c_of_type_Int = 0;
    f();
  }
  
  private void f()
  {
    switch (this.jdField_c_of_type_Int)
    {
    default: 
      return;
    case 0: 
      this.jdField_b_of_type_AndroidWidgetButton.setText(2131562937);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetButton.setText(2131562273);
  }
  
  private void g()
  {
    if (this.jdField_k_of_type_Boolean)
    {
      AIOGalleryUtils.a(this, getIntent(), this.jdField_a_of_type_JavaLangString, this.f, this.jdField_i_of_type_JavaLangString, this.jdField_j_of_type_JavaLangString, this.jdField_k_of_type_JavaLangString, this.jdField_c_of_type_Int, a());
      return;
    }
    PhotoUtils.a(this, getIntent(), a(), this.jdField_c_of_type_Int, this.jdField_a_of_type_Boolean);
  }
  
  protected boolean a()
  {
    return false;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    PhotoUtils.a(this, paramInt1, paramInt2, paramIntent, this.jdField_j_of_type_Boolean, this.jdField_a_of_type_JavaLangString);
  }
  
  public void onBackPressed()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPreloadGallery.a(false)) {
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
    setContentView(2130903316);
    c();
    d();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    int m = 0;
    try
    {
      while (m < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if ((String)this.jdField_a_of_type_JavaUtilArrayList.get(m) != null)
        {
          File localFile = new File((String)this.jdField_a_of_type_JavaUtilArrayList.get(m));
          URLDrawable.removeMemoryCacheByUrl(localFile.toURL().toString());
          URLDrawable.removeMemoryCacheByUrl(localFile.toURL().toString() + "#NOSAMPLE");
        }
        m += 1;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoPreviewActivity
 * JD-Core Version:    0.7.0.1
 */