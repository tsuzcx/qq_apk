package com.tencent.mobileqq.activity.photo;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;
import cje;
import cjf;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.XListView;
import cooperation.qqfav.QfavHelper;
import java.util.ArrayList;

public class AlbumListActivity
  extends PeakActivity
{
  public static final int a = 100;
  static final String jdField_a_of_type_JavaLangString = AlbumListActivity.class.getSimpleName();
  public static final String b = "_size>0) GROUP BY (_data";
  static final String jdField_c_of_type_JavaLangString = "peak.myUin";
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public AlbumListAdapter a;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  boolean jdField_a_of_type_Boolean = true;
  int jdField_b_of_type_Int;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  ArrayList jdField_b_of_type_JavaUtilArrayList;
  boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  String jdField_d_of_type_JavaLangString;
  
  private void c()
  {
    Intent localIntent = getIntent();
    this.jdField_a_of_type_JavaUtilArrayList = localIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_b_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", false);
    this.jdField_d_of_type_Int = localIntent.getIntExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", MediaFileFilter.MEDIA_FILTER_DEFAULT.ordinal());
    this.jdField_d_of_type_JavaLangString = localIntent.getStringExtra("peak.myUin");
    if (this.jdField_d_of_type_JavaLangString == null)
    {
      this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface.a();
      if (this.jdField_d_of_type_JavaLangString == null) {
        throw new RuntimeException("must set MY_UIN");
      }
    }
    StatisticConstants.b(localIntent);
  }
  
  @TargetApi(9)
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumListAdapter = new AlbumListAdapter(this, MediaFileFilter.filterOfOrdinal(this.jdField_d_of_type_Int));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131298166));
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumListAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new cjf(this, null));
    if (Build.VERSION.SDK_INT > 8) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollMode(2);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296898));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131364509);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(getString(2131364539));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296902));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296892));
    this.jdField_c_of_type_AndroidWidgetTextView.setText(2131364509);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new cje(this));
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public void onBackPressed()
  {
    int i = 0;
    if (!this.jdField_b_of_type_Boolean)
    {
      finish();
      AlbumUtil.a();
      AlbumUtil.a(this, false, false);
      localIntent = getIntent();
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        i = this.jdField_a_of_type_JavaUtilArrayList.size();
      }
      StatisticConstants.a(localIntent, i);
      return;
    }
    Intent localIntent = getIntent();
    String str1 = localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    String str2 = localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
    if (str1 == null)
    {
      QQToast.a(this, "请设置INIT_ACTIVITY_CLASS_NAME ", 0).a();
      return;
    }
    localIntent.removeExtra("PhotoConst.PHOTO_PATHS");
    localIntent.removeExtra("PhotoConst.SINGLE_PHOTO_PATH");
    localIntent.addFlags(603979776);
    localIntent.setClassName(str2, str1);
    if (!localIntent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false)) {
      startActivity(localIntent);
    }
    for (;;)
    {
      finish();
      AlbumUtil.a(this, false, false);
      break;
      localIntent.getStringExtra("PhotoConst.PLUGIN_NAME");
      str1 = localIntent.getStringExtra("PhotoConst.PLUGIN_APK");
      localIntent.getStringExtra("PhotoConst.UIN");
      if ("qqfav.apk".equals(str1)) {
        QfavHelper.a(this, this.jdField_d_of_type_JavaLangString, localIntent, -1);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    requestWindowFeature(7);
    super.onCreate(paramBundle);
    super.setContentView(2130903474);
    getWindow().setFeatureInt(7, 2130903134);
    this.jdField_b_of_type_Int = getResources().getDimensionPixelSize(2131492953);
    this.jdField_c_of_type_Int = this.jdField_b_of_type_Int;
    c();
    d();
  }
  
  protected void onDestroy()
  {
    AlbumThumbManager.a(this).a();
    if (!this.jdField_c_of_type_Boolean) {
      AlbumUtil.c();
    }
    super.onDestroy();
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.AlbumListActivity
 * JD-Core Version:    0.7.0.1
 */