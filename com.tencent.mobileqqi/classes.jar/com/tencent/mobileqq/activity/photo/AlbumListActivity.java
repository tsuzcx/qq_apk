package com.tencent.mobileqq.activity.photo;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qqfav.QfavHelper;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.zebra.ZebraPluginProxyActivity;
import elz;
import ema;
import emb;
import emc;
import emd;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AlbumListActivity
  extends PeakActivity
{
  public static final int a = 100;
  static long jdField_a_of_type_Long = 0L;
  static final String jdField_a_of_type_JavaLangString = AlbumListActivity.class.getSimpleName();
  public static final String b = "_size>0) GROUP BY (_data";
  static final String jdField_c_of_type_JavaLangString = "peak.myUin";
  private Dialog jdField_a_of_type_AndroidAppDialog;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public XListView a;
  public emd a;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  private Comparator jdField_a_of_type_JavaUtilComparator = new emb(this);
  boolean jdField_a_of_type_Boolean = true;
  public int b;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  ArrayList jdField_b_of_type_JavaUtilArrayList;
  boolean jdField_b_of_type_Boolean;
  public int c;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  boolean jdField_c_of_type_Boolean;
  String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  
  private void a(List paramList)
  {
    int i = 0;
    this.jdField_a_of_type_Emd.a(paramList);
    if ((paramList == null) || (paramList.size() == 0)) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setEmptyView(findViewById(2131232884));
    }
    int j;
    int k;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      j = AlbumUtil.a();
      k = this.jdField_a_of_type_Emd.getCount();
      if (k != 0) {
        break label113;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, "AlbumListActivity,start to position,firstVisiblePos is:" + i);
      }
      this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(i);
      this.jdField_a_of_type_Emd.notifyDataSetChanged();
      return;
      label113:
      if (j > k - 1) {
        i = k - 1;
      } else if (j >= 0) {
        i = j;
      }
    }
  }
  
  private boolean a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      paramString = paramString.toLowerCase();
      if (paramString.equalsIgnoreCase("camera")) {
        return true;
      }
    } while (!paramString.equalsIgnoreCase("100media"));
    return true;
  }
  
  private void b(List paramList)
  {
    if (paramList == null) {
      return;
    }
    int j = paramList.size();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < j)
    {
      QQAlbumInfo localQQAlbumInfo = (QQAlbumInfo)paramList.get(i);
      if (a(localQQAlbumInfo.name))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "album " + localQQAlbumInfo.name + " is camera dir");
        }
        localArrayList.add(localQQAlbumInfo);
      }
      i += 1;
    }
    paramList.removeAll(localArrayList);
    Collections.sort(paramList, this.jdField_a_of_type_JavaUtilComparator);
    Collections.sort(localArrayList, this.jdField_a_of_type_JavaUtilComparator);
    paramList.addAll(0, localArrayList);
  }
  
  private void c()
  {
    this.jdField_b_of_type_Int = getResources().getDimensionPixelSize(2131427455);
    this.jdField_c_of_type_Int = this.jdField_b_of_type_Int;
  }
  
  private void d()
  {
    Intent localIntent = getIntent();
    this.jdField_a_of_type_JavaUtilArrayList = localIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_b_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", false);
    this.jdField_c_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.IS_CONTAIN_GIF", true);
    this.jdField_d_of_type_JavaLangString = localIntent.getStringExtra("peak.myUin");
    if (this.jdField_d_of_type_JavaLangString == null)
    {
      this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface.a();
      if (this.jdField_d_of_type_JavaLangString == null) {
        throw new RuntimeException("must set MY_UIN");
      }
    }
  }
  
  @TargetApi(9)
  private void e()
  {
    this.jdField_a_of_type_Emd = new emd(this);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131232883));
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Emd);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new emc(this, null));
    if (Build.VERSION.SDK_INT > 8) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollMode(2);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231456));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231380));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231376));
    this.jdField_c_of_type_AndroidWidgetTextView.setText(2131560963);
    getSupportActionBar().setTitle(2131560963);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getResources().getString(2131558985));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new ema(this));
  }
  
  private void f()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidAppDialog != null) {
        g();
      }
      while (!this.jdField_a_of_type_AndroidAppDialog.isShowing())
      {
        this.jdField_a_of_type_AndroidAppDialog.show();
        return;
        this.jdField_a_of_type_AndroidAppDialog = new Dialog(this, 2131624405);
        this.jdField_a_of_type_AndroidAppDialog.setCancelable(true);
        this.jdField_a_of_type_AndroidAppDialog.show();
        this.jdField_a_of_type_AndroidAppDialog.setContentView(2130903319);
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AlbumListActivity", 2, "dialog error");
      }
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
  }
  
  private void g()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidAppDialog != null) {
        this.jdField_a_of_type_AndroidAppDialog.cancel();
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AlbumListActivity", 2, "cancel dialog error", localException);
      }
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
  }
  
  public List a()
  {
    Object localObject1 = AlbumUtil.a();
    Object localObject2;
    if ((localObject1 == null) || (jdField_a_of_type_Long < AlbumUtil.a()))
    {
      localObject2 = AlbumUtil.a(this, 0, this.jdField_c_of_type_Boolean);
      if (localObject2 != null)
      {
        b((List)localObject2);
        QQAlbumInfo localQQAlbumInfo = AlbumUtil.a();
        localObject1 = localQQAlbumInfo;
        if (localQQAlbumInfo == null) {
          localObject1 = AlbumUtil.a(getApplicationContext(), 200, 100, this.jdField_c_of_type_Boolean);
        }
        if ((((QQAlbumInfo)localObject1).cover != null) && (((QQAlbumInfo)localObject1).cover.jdField_a_of_type_JavaLangString != null) && (((QQAlbumInfo)localObject1).cover.jdField_a_of_type_JavaLangString.length() > 0)) {
          ((List)localObject2).add(0, localObject1);
        }
      }
      jdField_a_of_type_Long = AlbumUtil.a();
      localObject1 = localObject2;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("albumList size is:");
      if (localObject1 == null) {
        break label160;
      }
    }
    label160:
    for (int i = ((List)localObject1).size();; i = 0)
    {
      QLog.d("SelectPhotoTrace", 2, i);
      return localObject1;
    }
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public void onBackPressed()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      finish();
      AlbumUtil.a();
      AlbumUtil.a(this, false, false);
      return;
    }
    Intent localIntent = getIntent();
    String str1 = localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    String str2 = localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
    if (str1 == null)
    {
      QQToast.a(this, getResources().getString(2131558986), 0).a();
      return;
    }
    localIntent.removeExtra("PhotoConst.PHOTO_PATHS");
    localIntent.removeExtra("PhotoConst.SINGLE_PHOTO_PATH");
    localIntent.addFlags(603979776);
    if (str1.startsWith("com.qzone"))
    {
      QzonePluginProxyActivity.a(localIntent, str1);
      localIntent.putExtra("cleartop", true);
      QZoneHelper.a(this, this.jdField_d_of_type_JavaLangString, localIntent, -1);
    }
    for (;;)
    {
      finish();
      AlbumUtil.a(this, false, false);
      return;
      localIntent.setClassName(str2, str1);
      if (!localIntent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false))
      {
        startActivity(localIntent);
      }
      else
      {
        str2 = localIntent.getStringExtra("PhotoConst.PLUGIN_NAME");
        String str3 = localIntent.getStringExtra("PhotoConst.PLUGIN_APK");
        String str4 = localIntent.getStringExtra("PhotoConst.UIN");
        if ("WaterMarkCamera.apk".equals(str2)) {
          localIntent.putExtra("cleartop", true);
        }
        if ("qzone_plugin.apk".equals(str3))
        {
          localIntent.putExtra("qzone_plugin_activity_name", str1);
          QZoneHelper.a(this, str4, localIntent, 2);
        }
        else if ("qqfav.apk".equals(str3))
        {
          QfavHelper.a(this, this.jdField_d_of_type_JavaLangString, localIntent, -1);
        }
        else
        {
          IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
          localPluginParams.jdField_b_of_type_JavaLangString = str3;
          localPluginParams.jdField_d_of_type_JavaLangString = str2;
          localPluginParams.jdField_a_of_type_JavaLangString = str4;
          localPluginParams.e = str1;
          localPluginParams.jdField_a_of_type_JavaLangClass = ZebraPluginProxyActivity.class;
          localPluginParams.jdField_a_of_type_AndroidContentIntent = localIntent;
          localPluginParams.jdField_b_of_type_Int = 2;
          localPluginParams.jdField_a_of_type_AndroidAppDialog = null;
          IPluginManager.a(this, localPluginParams);
        }
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903545);
    c();
    d();
    e();
  }
  
  protected void onDestroy()
  {
    AlbumThumbManager.a(this).a();
    if (!this.jdField_d_of_type_Boolean) {
      AlbumUtil.c();
    }
    super.onDestroy();
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    d();
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    elz localelz = new elz(this);
    if ((AlbumUtil.a() == null) || (jdField_a_of_type_Long < AlbumUtil.a()))
    {
      localelz.execute(new Object[] { "" });
      return;
    }
    a(a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.AlbumListActivity
 * JD-Core Version:    0.7.0.1
 */