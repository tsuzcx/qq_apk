package com.tencent.mobileqq.activity.photo;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.hardware.Camera;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.view.MenuItemCompat;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.DoodleActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.FileProvider7Helper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.CameraView;
import com.tencent.widget.GestureSelectGridView;
import com.tencent.widget.GestureSelectGridView.OnSelectListener;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qqfav.QfavHelper;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.model.BaseBusinessAlbumInfo;
import cooperation.zebra.ZebraPluginProxyActivity;
import emu;
import emv;
import emw;
import emx;
import emy;
import ena;
import enc;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class PhotoListActivity
  extends PeakActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  static final String jdField_a_of_type_JavaLangString = PhotoListActivity.class.getSimpleName();
  static final String jdField_b_of_type_JavaLangString = "FROM_WHERE";
  static final String jdField_c_of_type_JavaLangString = "FROM_PHOTO_LIST";
  private static final int jdField_f_of_type_Int = 100;
  private static final int g = -1;
  private static final int h = 3;
  private static int jdField_o_of_type_Int = -1;
  private static final int jdField_p_of_type_Int = 1;
  private static final int jdField_q_of_type_Int = 0;
  public int a;
  long jdField_a_of_type_Long;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Camera jdField_a_of_type_AndroidHardwareCamera;
  public AsyncTask a;
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private AdapterView.OnItemClickListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = new emv(this);
  private CameraView jdField_a_of_type_ComTencentWidgetCameraView;
  GestureSelectGridView.OnSelectListener jdField_a_of_type_ComTencentWidgetGestureSelectGridView$OnSelectListener = new emu(this);
  public GestureSelectGridView a;
  public ena a;
  public ArrayList a;
  public boolean a;
  public int b;
  View jdField_b_of_type_AndroidViewView;
  Button jdField_b_of_type_AndroidWidgetButton;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  boolean jdField_b_of_type_Boolean = false;
  public int c;
  Button jdField_c_of_type_AndroidWidgetButton;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean = false;
  public int d;
  public Button d;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean = true;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean = false;
  String jdField_f_of_type_JavaLangString;
  private int jdField_i_of_type_Int;
  private String jdField_i_of_type_JavaLangString;
  private boolean jdField_i_of_type_Boolean = false;
  private int jdField_j_of_type_Int;
  private String jdField_j_of_type_JavaLangString;
  private boolean jdField_j_of_type_Boolean = false;
  private int jdField_k_of_type_Int;
  private String jdField_k_of_type_JavaLangString = null;
  private boolean jdField_k_of_type_Boolean;
  private int jdField_l_of_type_Int;
  private String jdField_l_of_type_JavaLangString;
  private boolean jdField_l_of_type_Boolean = false;
  private int jdField_m_of_type_Int;
  private String jdField_m_of_type_JavaLangString;
  private boolean jdField_m_of_type_Boolean = false;
  private int jdField_n_of_type_Int = -1;
  private String jdField_n_of_type_JavaLangString;
  private boolean jdField_n_of_type_Boolean = true;
  private String jdField_o_of_type_JavaLangString;
  private boolean jdField_o_of_type_Boolean;
  private String jdField_p_of_type_JavaLangString;
  private boolean jdField_p_of_type_Boolean;
  private boolean jdField_q_of_type_Boolean;
  private boolean r = false;
  private boolean s;
  private boolean t = false;
  
  public PhotoListActivity()
  {
    this.jdField_c_of_type_Int = 1;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Ena = null;
    this.q = false;
  }
  
  @TargetApi(8)
  private File a()
  {
    Object localObject = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    String str = "JPEG_" + (String)localObject + "_";
    if ("mounted".equals(Environment.getExternalStorageState()))
    {
      boolean bool = false;
      if (Build.VERSION.SDK_INT > 7)
      {
        localObject = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        bool = true;
      }
      while (bool)
      {
        localObject = File.createTempFile(str, ".jpg", (File)localObject);
        this.jdField_n_of_type_JavaLangString = ((File)localObject).getAbsolutePath();
        return localObject;
        File localFile = new File(Environment.getExternalStorageDirectory(), "DCIM");
        localObject = localFile;
        if (!localFile.exists())
        {
          bool = localFile.mkdirs();
          localObject = localFile;
        }
      }
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    if (paramInt == this.jdField_n_of_type_Int) {
      return;
    }
    this.jdField_n_of_type_Int = paramInt;
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.jdField_b_of_type_AndroidWidgetButton.setText(2131562937);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetButton.setText(2131562273);
  }
  
  private void a(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SelectPhotoTrace", 2, jdField_a_of_type_JavaLangString + " initData(),intent extras is:" + paramIntent.getExtras());
    }
    boolean bool;
    label341:
    Object localObject;
    if (paramIntent.getBooleanExtra("album_enter_directly", false))
    {
      if (System.currentTimeMillis() - AlbumUtil.jdField_b_of_type_Long < 60000L)
      {
        this.jdField_i_of_type_JavaLangString = paramIntent.getStringExtra("ALBUM_NAME");
        this.jdField_j_of_type_JavaLangString = paramIntent.getStringExtra("ALBUM_ID");
      }
      if (this.jdField_j_of_type_JavaLangString == null)
      {
        this.jdField_j_of_type_JavaLangString = "$RecentAlbumId";
        this.jdField_i_of_type_JavaLangString = null;
      }
      this.jdField_a_of_type_JavaUtilArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      this.jdField_c_of_type_Int = paramIntent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
      this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_MODE", true);
      this.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", false);
      this.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("PhotoConst.MY_UIN");
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_e_of_type_JavaLangString = paramIntent.getStringExtra("PhotoConst.MY_NICK");
        this.f = paramIntent.getStringExtra("PhotoConst.MY_HEAD_DIR");
      }
      this.jdField_c_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.HANDLE_DEST_RESULT", false);
      this.jdField_e_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", false);
      this.jdField_i_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_NEED_EDIT", false);
      this.jdField_j_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false);
      this.jdField_l_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
      this.jdField_m_of_type_Int = paramIntent.getIntExtra("uintype", -1);
      if (this.jdField_c_of_type_Int > 1) {
        this.jdField_a_of_type_Boolean = false;
      }
      this.jdField_k_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", false);
      this.jdField_m_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false);
      this.jdField_n_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_CONTAIN_GIF", true);
      if (this.jdField_m_of_type_Int != 1) {
        break label593;
      }
      bool = true;
      this.jdField_p_of_type_Boolean = bool;
      this.jdField_l_of_type_JavaLangString = paramIntent.getStringExtra("uinname");
      this.jdField_m_of_type_JavaLangString = paramIntent.getStringExtra("uin");
      if (this.jdField_d_of_type_JavaLangString != null) {
        break label598;
      }
      localObject = this.h;
      label381:
      this.jdField_d_of_type_JavaLangString = ((String)localObject);
      if (this.jdField_m_of_type_Boolean)
      {
        int i1 = paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
        PhotoUtils.a(this, paramIntent, this.jdField_a_of_type_JavaUtilArrayList, i1, true);
      }
      this.jdField_k_of_type_JavaLangString = paramIntent.getStringExtra("PhotoConst.CUSTOM_SENDBTN_TEXT");
      if ((this.jdField_p_of_type_Boolean) && (this.jdField_d_of_type_JavaLangString != null))
      {
        localObject = QZoneHelper.a(this.jdField_d_of_type_JavaLangString, this.jdField_m_of_type_JavaLangString);
        if ((localObject == null) || (((BaseBusinessAlbumInfo)localObject).b() == null) || (((BaseBusinessAlbumInfo)localObject).b().equals(""))) {
          break label607;
        }
        this.jdField_o_of_type_JavaLangString = ((BaseBusinessAlbumInfo)localObject).b();
        this.jdField_p_of_type_JavaLangString = ((BaseBusinessAlbumInfo)localObject).c();
        paramIntent.putExtra("UploadPhoto.key_album_id", this.jdField_o_of_type_JavaLangString);
        paramIntent.putExtra("UploadPhoto.key_album_name", this.jdField_p_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      this.t = paramIntent.getBooleanExtra("PhotoConst.IS_JUMPTO_TROOP_ALBUM", false);
      if (("$RecentAlbumId".equals(this.jdField_j_of_type_JavaLangString)) && (paramIntent.getBooleanExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", false)))
      {
        this.q = false;
        this.r = false;
      }
      return;
      this.jdField_i_of_type_JavaLangString = paramIntent.getStringExtra("ALBUM_NAME");
      this.jdField_j_of_type_JavaLangString = paramIntent.getStringExtra("ALBUM_ID");
      break;
      label593:
      bool = false;
      break label341;
      label598:
      localObject = this.jdField_d_of_type_JavaLangString;
      break label381;
      label607:
      paramIntent.putExtra("UploadPhoto.key_album_id", "");
      paramIntent.putExtra("UploadPhoto.key_album_name", "");
    }
  }
  
  private void a(String paramString)
  {
    if (new File(paramString).length() > 19922944L)
    {
      QQToast.a(this, getResources().getString(2131561477), 0).b(this.jdField_d_of_type_Int);
      a(0);
    }
  }
  
  private void a(ArrayList paramArrayList, int paramInt1, int paramInt2)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    PhotoMagicStickUtils.a(this, paramArrayList, localActionSheet, paramInt1);
    localActionSheet.d(2131561746);
    localActionSheet.a(new emw(this, paramArrayList, localActionSheet));
    localActionSheet.e(paramInt2);
    localActionSheet.show();
  }
  
  private boolean a(LocalPhotoInfo paramLocalPhotoInfo, boolean paramBoolean)
  {
    int i1 = paramLocalPhotoInfo.e;
    if (((i1 == 1) && (paramBoolean)) || ((i1 == 2) && (!paramBoolean))) {}
    long l1;
    do
    {
      return false;
      if ((i1 != 2) || (!paramBoolean) || (this.jdField_a_of_type_JavaUtilArrayList.size() < this.jdField_c_of_type_Int)) {
        break;
      }
      l1 = System.currentTimeMillis();
    } while (l1 - this.jdField_a_of_type_Long < 700L);
    QQToast.a(this, getString(2131558990, new Object[] { Integer.valueOf(this.jdField_c_of_type_Int) }), 1000).b(this.jdField_d_of_type_Int);
    this.jdField_a_of_type_Long = l1;
    return false;
    String str = paramLocalPhotoInfo.jdField_a_of_type_JavaLangString;
    if (paramBoolean)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(str);
      paramLocalPhotoInfo.e = 1;
      LinkedHashMap localLinkedHashMap = (LinkedHashMap)AlbumUtil.jdField_b_of_type_JavaUtilHashMap.get(this.jdField_j_of_type_JavaLangString);
      paramLocalPhotoInfo = localLinkedHashMap;
      if (localLinkedHashMap == null)
      {
        paramLocalPhotoInfo = new LinkedHashMap();
        AlbumUtil.jdField_b_of_type_JavaUtilHashMap.put(this.jdField_j_of_type_JavaLangString, paramLocalPhotoInfo);
      }
      paramLocalPhotoInfo.put(str, Integer.valueOf(this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.q()));
      paramLocalPhotoInfo = AlbumUtil.jdField_c_of_type_JavaUtilHashMap;
      if (!paramLocalPhotoInfo.containsKey(str)) {
        paramLocalPhotoInfo.put(str, new Pair(this.jdField_j_of_type_JavaLangString, this.jdField_i_of_type_JavaLangString));
      }
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramLocalPhotoInfo.jdField_a_of_type_JavaLangString);
      paramLocalPhotoInfo.e = 2;
      paramLocalPhotoInfo = (HashMap)AlbumUtil.jdField_b_of_type_JavaUtilHashMap.get(this.jdField_j_of_type_JavaLangString);
      if (paramLocalPhotoInfo != null) {
        paramLocalPhotoInfo.remove(str);
      }
      paramLocalPhotoInfo = AlbumUtil.jdField_c_of_type_JavaUtilHashMap;
      if (paramLocalPhotoInfo.containsKey(str)) {
        paramLocalPhotoInfo.remove(str);
      }
    }
  }
  
  private void b(Intent paramIntent)
  {
    this.jdField_o_of_type_JavaLangString = paramIntent.getStringExtra("UploadPhoto.key_album_id");
    this.jdField_p_of_type_JavaLangString = paramIntent.getStringExtra("UploadPhoto.key_album_name");
    this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(this.t);
    String str2 = "";
    String str1 = "";
    int i1;
    if (TextUtils.isEmpty(this.jdField_o_of_type_JavaLangString))
    {
      paramIntent = getString(2131561448);
      i1 = 2131563144;
    }
    for (;;)
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setText(paramIntent);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(i1);
      getIntent().putExtra("UploadPhoto.key_album_name", str2);
      getIntent().putExtra("UploadPhoto.key_album_id", str1);
      return;
      paramIntent = "《" + this.jdField_p_of_type_JavaLangString + "》";
      i1 = 2131563143;
      str2 = this.jdField_p_of_type_JavaLangString;
      str1 = this.jdField_o_of_type_JavaLangString;
    }
  }
  
  private void b(String paramString)
  {
    AlbumUtil.a();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
    Intent localIntent = getIntent();
    localIntent.putExtra("ALBUM_NAME", this.jdField_i_of_type_JavaLangString);
    localIntent.putExtra("ALBUM_ID", this.jdField_j_of_type_JavaLangString);
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_a_of_type_JavaUtilArrayList);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString);
    if (this.jdField_e_of_type_Boolean)
    {
      String str = localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      if ((!TextUtils.isEmpty(str)) && (str.equals(DoodleActivity.class.getName())) && (new File(paramString).length() > 19922944L))
      {
        QQToast.a(this, getString(2131563077), 0).b(this.jdField_d_of_type_Int);
        return;
      }
      h();
      PhotoUtils.a(this, localIntent, this.jdField_a_of_type_JavaUtilArrayList, 0, this.jdField_c_of_type_Boolean);
      return;
    }
    if (!this.jdField_i_of_type_Boolean)
    {
      localIntent.setClass(this, PhotoPreviewActivity.class);
      localIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
      localIntent.addFlags(603979776);
      startActivity(localIntent);
      finish();
      AlbumUtil.a(this, true, true);
      return;
    }
    if (100 == localIntent.getIntExtra("Business_Origin", 0))
    {
      localIntent.setClass(this, PhotoCropForPortraitActivity.class);
      localIntent.putExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", 0);
    }
    for (;;)
    {
      AlbumUtil.a(localIntent, this.jdField_j_of_type_JavaLangString, paramString, this.jdField_l_of_type_Boolean);
      break;
      localIntent.setClass(this, PhotoCropActivity.class);
    }
  }
  
  private void c()
  {
    Resources localResources = getResources();
    int i1 = localResources.getDisplayMetrics().widthPixels;
    this.jdField_k_of_type_Int = localResources.getDimensionPixelSize(2131427461);
    this.jdField_i_of_type_Int = localResources.getDimensionPixelSize(2131427459);
    this.jdField_j_of_type_Int = localResources.getDimensionPixelSize(2131427460);
    this.jdField_l_of_type_Int = AIOUtils.a(1.0F, localResources);
    this.jdField_a_of_type_Int = ((i1 - this.jdField_k_of_type_Int * 2 - this.jdField_i_of_type_Int * 2) / 3);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
  }
  
  @TargetApi(9)
  private void d()
  {
    Intent localIntent = getIntent();
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231456));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getResources().getString(2131558991));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231380));
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(getResources().getString(2131558992));
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231376));
    Object localObject;
    if (this.jdField_i_of_type_JavaLangString != null)
    {
      localObject = this.jdField_i_of_type_JavaLangString;
      setTitle((CharSequence)localObject);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131232065));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131232066));
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131233027));
      this.jdField_d_of_type_AndroidWidgetButton = ((Button)findViewById(2131232067));
      this.jdField_a_of_type_AndroidViewView = findViewById(2131233026);
      this.jdField_b_of_type_AndroidViewView = findViewById(2131233022);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131233024));
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView = ((GestureSelectGridView)findViewById(2131233028));
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setScrollBarStyle(0);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setNumColumns(3);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setColumnWidth(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setHorizontalSpacing(this.jdField_i_of_type_Int);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setVerticalSpacing(this.jdField_j_of_type_Int);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setPadding(this.jdField_k_of_type_Int, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getPaddingTop(), this.jdField_k_of_type_Int, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getPaddingBottom());
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setOnIndexChangedListener(this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView$OnSelectListener);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setMaximumVelocity((int)(2500.0F * getResources().getDisplayMetrics().density));
      this.jdField_a_of_type_Ena = new ena(this);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setAdapter(this.jdField_a_of_type_Ena);
      String str = this.jdField_k_of_type_JavaLangString;
      localObject = str;
      if (TextUtils.isEmpty(str))
      {
        if (!this.t) {
          break label603;
        }
        localObject = getString(2131563141);
      }
      label403:
      this.jdField_d_of_type_AndroidWidgetButton.setText((CharSequence)localObject);
      localObject = this.jdField_a_of_type_AndroidViewView;
      if (!this.jdField_a_of_type_Boolean) {
        break label632;
      }
    }
    label603:
    label632:
    for (int i1 = 8;; i1 = 0)
    {
      ((View)localObject).setVisibility(i1);
      this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetButton.setOnClickListener(this);
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
        this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      }
      g();
      a(localIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0));
      if ((this.jdField_p_of_type_Boolean) && (this.jdField_d_of_type_JavaLangString != null))
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131233025));
        this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)this.jdField_b_of_type_AndroidViewView.findViewById(2131233023));
        this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
        this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
        b(localIntent);
      }
      return;
      localObject = BaseApplicationImpl.getContext().getString(2131561293);
      break;
      if (this.jdField_b_of_type_Boolean)
      {
        localObject = getString(2131562858);
        break label403;
      }
      localObject = getString(2131562536);
      break label403;
    }
  }
  
  private void e()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidAppDialog != null) {
        f();
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
        QLog.e("PhotoListActivity", 2, "dialog error");
      }
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      this.jdField_a_of_type_AndroidAppDialog.cancel();
    }
  }
  
  private void g()
  {
    Object localObject1;
    if (this.jdField_k_of_type_JavaLangString != null)
    {
      localObject1 = this.jdField_k_of_type_JavaLangString;
      int i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
      if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
        break label216;
      }
      bool = true;
      label32:
      Object localObject2 = localObject1;
      if (bool)
      {
        localObject1 = new StringBuilder((String)localObject1);
        ((StringBuilder)localObject1).append("(");
        ((StringBuilder)localObject1).append(i1);
        ((StringBuilder)localObject1).append(")");
        localObject2 = ((StringBuilder)localObject1).toString();
      }
      this.jdField_d_of_type_AndroidWidgetButton.setEnabled(bool);
      this.jdField_c_of_type_AndroidWidgetButton.setEnabled(bool);
      this.jdField_d_of_type_AndroidWidgetButton.setText((CharSequence)localObject2);
      if (!bool)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(bool);
        this.jdField_b_of_type_AndroidWidgetButton.setEnabled(bool);
      }
      if (!this.jdField_b_of_type_Boolean) {
        break label226;
      }
      if (bool)
      {
        this.jdField_b_of_type_AndroidWidgetButton.setEnabled(bool);
        if ((this.jdField_a_of_type_JavaUtilArrayList.size() != 1) || (this.t)) {
          break label221;
        }
      }
    }
    label216:
    label221:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(bool);
      return;
      if (this.t)
      {
        localObject1 = getString(2131563141);
        break;
      }
      if (this.jdField_b_of_type_Boolean)
      {
        localObject1 = getString(2131562858);
        break;
      }
      localObject1 = getString(2131562536);
      break;
      bool = false;
      break label32;
    }
    label226:
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
  }
  
  private void h()
  {
    if (this.jdField_l_of_type_Boolean)
    {
      AlbumUtil.jdField_b_of_type_Long = System.currentTimeMillis();
      AlbumUtil.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_j_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_Ena.getCount()));
      int i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
      if (i1 > 0)
      {
        Object localObject = (String)this.jdField_a_of_type_JavaUtilArrayList.get(i1 - 1);
        AlbumUtil.jdField_a_of_type_JavaLangString = (String)localObject;
        HashMap localHashMap = AlbumUtil.jdField_c_of_type_JavaUtilHashMap;
        if (localHashMap.containsKey(localObject))
        {
          localObject = (Pair)localHashMap.get(localObject);
          AlbumUtil.jdField_b_of_type_JavaLangString = (String)((Pair)localObject).first;
          AlbumUtil.jdField_c_of_type_JavaLangString = (String)((Pair)localObject).second;
          AlbumUtil.a(this, AlbumUtil.jdField_b_of_type_JavaLangString, AlbumUtil.jdField_c_of_type_JavaLangString);
        }
      }
    }
    AlbumUtil.c();
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidHardwareCamera = Camera.open();
    if (this.jdField_a_of_type_AndroidHardwareCamera == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetCameraView = new CameraView(this);
    this.jdField_a_of_type_ComTencentWidgetCameraView.setCamera(this.jdField_a_of_type_AndroidHardwareCamera);
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_AndroidHardwareCamera == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetCameraView.setCamera(null);
    this.jdField_a_of_type_ComTencentWidgetCameraView = null;
    this.jdField_a_of_type_AndroidHardwareCamera.release();
    this.jdField_a_of_type_AndroidHardwareCamera = null;
  }
  
  private void k()
  {
    Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
    Object localObject;
    if (localIntent.resolveActivity(getPackageManager()) != null) {
      localObject = null;
    }
    try
    {
      File localFile = a();
      localObject = localFile;
    }
    catch (IOException localIOException)
    {
      label31:
      break label31;
    }
    if (localObject != null)
    {
      FileProvider7Helper.setSystemCapture(this, localObject, localIntent);
      startActivityForResult(localIntent, 1);
    }
  }
  
  private void l()
  {
    if (this.t)
    {
      AIOGalleryUtils.a(this, getIntent(), this.jdField_d_of_type_JavaLangString, this.jdField_m_of_type_JavaLangString, this.jdField_l_of_type_JavaLangString, this.jdField_o_of_type_JavaLangString, this.jdField_p_of_type_JavaLangString, this.jdField_n_of_type_Int, this.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
    PhotoUtils.a(this, getIntent(), this.jdField_a_of_type_JavaUtilArrayList, this.jdField_n_of_type_Int, this.jdField_c_of_type_Boolean);
  }
  
  protected boolean a()
  {
    return false;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = true;
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((this.jdField_p_of_type_Boolean) && (paramIntent != null) && (paramInt1 == 100) && (paramInt2 == -1))
    {
      b(paramIntent);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      return;
    }
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      String str;
      if (this.jdField_a_of_type_Boolean)
      {
        b(this.jdField_n_of_type_JavaLangString);
        paramIntent = getApplicationContext();
        str = this.jdField_n_of_type_JavaLangString;
        if (this.jdField_a_of_type_Boolean) {
          break label120;
        }
      }
      for (;;)
      {
        new emy(this, paramIntent, str, null, bool);
        return;
        if (this.s) {
          break;
        }
        this.s = true;
        break;
        label120:
        bool = false;
      }
    }
    PhotoUtils.a(this, paramInt1, paramInt2, paramIntent, this.jdField_j_of_type_Boolean, this.jdField_d_of_type_JavaLangString);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.t = paramBoolean;
    getIntent().putExtra("PhotoConst.IS_JUMPTO_TROOP_ALBUM", this.t);
    g();
  }
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    int i1 = 0;
    switch (paramView.getId())
    {
    default: 
    case 2131231456: 
    case 2131231380: 
    case 2131232065: 
    case 2131232066: 
    case 2131233027: 
    case 2131232067: 
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              onBackPressed();
              return;
              AlbumUtil.c();
              AlbumUtil.a();
              if (!this.jdField_k_of_type_Boolean)
              {
                finish();
                AlbumUtil.a(this, false, false);
                return;
              }
              paramView = getIntent();
              String str1 = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
              String str2 = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
              if (str1 == null)
              {
                QQToast.a(this, getResources().getString(2131558993), 0).a();
                return;
              }
              paramView.setClassName(str2, str1);
              paramView.removeExtra("PhotoConst.PHOTO_PATHS");
              paramView.removeExtra("PhotoConst.SINGLE_PHOTO_PATH");
              paramView.addFlags(603979776);
              if (!paramView.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false)) {
                startActivity(paramView);
              }
              for (;;)
              {
                finish();
                AlbumUtil.a(this, false, false);
                return;
                str2 = paramView.getStringExtra("PhotoConst.PLUGIN_NAME");
                String str3 = paramView.getStringExtra("PhotoConst.PLUGIN_APK");
                String str4 = paramView.getStringExtra("PhotoConst.UIN");
                if ("WaterMarkCamera.apk".equals(str2)) {
                  paramView.putExtra("cleartop", true);
                }
                if ("qzone_plugin.apk".equals(str3))
                {
                  QzonePluginProxyActivity.a(paramView, str1);
                  QZoneHelper.a(this, str4, paramView, 2);
                }
                else if ("qqfav.apk".equals(str3))
                {
                  QfavHelper.a(this, str4, paramView, 2);
                }
                else
                {
                  IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
                  localPluginParams.jdField_b_of_type_JavaLangString = str3;
                  localPluginParams.jdField_d_of_type_JavaLangString = str2;
                  localPluginParams.jdField_a_of_type_JavaLangString = str4;
                  localPluginParams.jdField_e_of_type_JavaLangString = str1;
                  localPluginParams.jdField_a_of_type_JavaLangClass = ZebraPluginProxyActivity.class;
                  localPluginParams.jdField_a_of_type_AndroidContentIntent = paramView;
                  localPluginParams.jdField_b_of_type_Int = 2;
                  localPluginParams.jdField_a_of_type_AndroidAppDialog = null;
                  localPluginParams.jdField_c_of_type_Int = 10000;
                  localPluginParams.f = null;
                  IPluginManager.a(this, localPluginParams);
                }
              }
            } while (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0);
            PhotoMagicStickUtils.a((String)this.jdField_a_of_type_JavaUtilArrayList.get(0), this, this.jdField_c_of_type_Boolean, this.jdField_m_of_type_Int, this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.f);
            return;
          } while (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0);
          a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_m_of_type_Int, this.jdField_n_of_type_Int);
          return;
          AlbumUtil.a();
          paramView = getIntent();
          paramView.putExtra("ALBUM_NAME", this.jdField_i_of_type_JavaLangString);
          paramView.putExtra("ALBUM_ID", this.jdField_j_of_type_JavaLangString);
          paramView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_a_of_type_JavaUtilArrayList);
          paramView.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
          paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_n_of_type_Int);
          jdField_o_of_type_Int = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.q();
          paramView.setClass(this, PhotoPreviewActivity.class);
          paramView.addFlags(603979776);
          startActivity(paramView);
          finish();
          AlbumUtil.a(this, true, true);
        } while ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0));
        ReportController.b(null, "CliOper", "0X8004075", this.jdField_d_of_type_JavaLangString, "0X8004075", "0X8004075", 0, this.jdField_a_of_type_JavaUtilArrayList.size(), 0, "", "", "", "");
        return;
        this.jdField_d_of_type_AndroidWidgetButton.setClickable(false);
        h();
        AlbumUtil.a();
        if (this.jdField_a_of_type_JavaUtilArrayList.size() != 0) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("PhotoList", 2, "size == 0");
      return;
      if (getIntent().getBooleanExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", false))
      {
        paramView = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        for (long l1 = 0L; paramView.hasNext(); l1 += FileUtils.a((String)paramView.next())) {}
        if (l1 > 5242880L) {
          i1 = 1;
        }
        if ((FileManagerUtil.a()) && (i1 != 0))
        {
          FMDialogUtil.a(this, 2131558759, 2131558756, new emx(this));
          return;
        }
      }
      l();
      return;
    case 2131233024: 
      paramView = this.jdField_a_of_type_AndroidWidgetCheckBox;
      if (!this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {}
      for (;;)
      {
        paramView.setChecked(bool);
        return;
        bool = false;
      }
    }
    paramView = QZoneHelper.UserInfo.a();
    paramView.jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    paramView.jdField_b_of_type_JavaLangString = this.jdField_l_of_type_JavaLangString;
    QZoneHelper.d(this, paramView, this.jdField_m_of_type_JavaLangString, this.jdField_l_of_type_JavaLangString, 100);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (this.q) {
      getWindow().setFormat(-3);
    }
    getWindow().setBackgroundDrawable(null);
    try
    {
      setContentView(2130903597);
      getWindow().setBackgroundDrawable(null);
      c();
      paramBundle = getIntent();
      a(paramBundle);
      d();
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, jdField_a_of_type_JavaLangString + " onCreate(),extra is:" + paramBundle.getExtras());
      }
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, jdField_a_of_type_JavaLangString + ",hashCode is:" + System.identityHashCode(this));
      }
      return;
    }
    catch (Throwable paramBundle)
    {
      finish();
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    MenuItemCompat.setShowAsAction(paramMenu.add(0, 2131231456, 0, getString(2131561636)), 1);
    return true;
  }
  
  protected void onDestroy()
  {
    AlbumThumbManager.a(this).a();
    super.onDestroy();
    int i2 = this.jdField_a_of_type_Ena.getCount();
    int i1 = i2;
    if (this.q)
    {
      i1 = i2;
      if ("$RecentAlbumId".equals(this.jdField_j_of_type_JavaLangString)) {
        i1 = i2 - 1;
      }
    }
    AlbumUtil.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_j_of_type_JavaLangString, Integer.valueOf(i1));
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("SelectPhotoTrace", 2, jdField_a_of_type_JavaLangString + " onNewIntent() is called,extra is:" + paramIntent.getExtras());
    }
    if (QLog.isColorLevel()) {
      QLog.d("SelectPhotoTrace", 2, jdField_a_of_type_JavaLangString + "hashCode is:" + System.identityHashCode(this));
    }
    setIntent(paramIntent);
    a(paramIntent);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131231456)
    {
      paramMenuItem = getIntent();
      paramMenuItem.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_a_of_type_JavaUtilArrayList);
      paramMenuItem.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_n_of_type_Int);
      paramMenuItem.putExtra("peak.myUin", this.jdField_d_of_type_JavaLangString);
      paramMenuItem.setClass(this, AlbumListActivity.class);
      paramMenuItem.addFlags(603979776);
      startActivity(paramMenuItem);
      finish();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_AndroidOsAsyncTask != null)
    {
      this.jdField_a_of_type_AndroidOsAsyncTask.cancel(true);
      this.jdField_a_of_type_AndroidOsAsyncTask = null;
    }
    if ((this.q) && (!this.r)) {
      j();
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if ((!this.s) && (this.jdField_a_of_type_AndroidOsAsyncTask == null))
    {
      this.jdField_a_of_type_AndroidOsAsyncTask = new enc(this, null);
      this.jdField_a_of_type_AndroidOsAsyncTask.execute(new Object[0]);
    }
    if ((this.q) && (!this.r)) {
      i();
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    super.setTitle(paramCharSequence);
    this.jdField_d_of_type_AndroidWidgetTextView.setText(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoListActivity
 * JD-Core Version:    0.7.0.1
 */