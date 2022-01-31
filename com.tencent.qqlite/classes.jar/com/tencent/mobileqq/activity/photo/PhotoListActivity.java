package com.tencent.mobileqq.activity.photo;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.hardware.Camera;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import ckb;
import ckc;
import ckd;
import cke;
import ckf;
import ckh;
import ckj;
import com.tencent.mobileqq.activity.DoodleActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.CameraView;
import com.tencent.widget.GestureSelectGridView;
import com.tencent.widget.GestureSelectGridView.OnSelectListener;
import cooperation.qqfav.QfavHelper;
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
  implements View.OnClickListener
{
  public static final String a;
  private static final HashMap jdField_a_of_type_JavaUtilHashMap;
  static final String jdField_b_of_type_JavaLangString = "FROM_WHERE";
  static final String jdField_c_of_type_JavaLangString = "FROM_PHOTO_LIST";
  private static final int jdField_f_of_type_Int = -1;
  private static final int g = 3;
  private static int jdField_o_of_type_Int;
  private static final int jdField_p_of_type_Int = 0;
  private static final int jdField_q_of_type_Int = jdField_a_of_type_JavaUtilHashMap.size();
  public int a;
  private long jdField_a_of_type_Long;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private Camera jdField_a_of_type_AndroidHardwareCamera;
  public AsyncTask a;
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public ckh a;
  private AdapterView.OnItemClickListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = new ckc(this);
  private CameraView jdField_a_of_type_ComTencentWidgetCameraView;
  GestureSelectGridView.OnSelectListener jdField_a_of_type_ComTencentWidgetGestureSelectGridView$OnSelectListener = new ckb(this);
  public GestureSelectGridView a;
  public ArrayList a;
  public boolean a;
  public int b;
  private long jdField_b_of_type_Long;
  Button jdField_b_of_type_AndroidWidgetButton;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  boolean jdField_b_of_type_Boolean = false;
  public int c;
  private long jdField_c_of_type_Long;
  public Button c;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean = false;
  public int d;
  String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean = true;
  String jdField_f_of_type_JavaLangString;
  private int h;
  private int jdField_i_of_type_Int;
  private String jdField_i_of_type_JavaLangString;
  private boolean jdField_i_of_type_Boolean = false;
  private int jdField_j_of_type_Int;
  private String jdField_j_of_type_JavaLangString;
  private boolean jdField_j_of_type_Boolean = false;
  private int jdField_k_of_type_Int;
  private String jdField_k_of_type_JavaLangString = null;
  private boolean jdField_k_of_type_Boolean = false;
  private int jdField_l_of_type_Int;
  private String jdField_l_of_type_JavaLangString;
  private boolean jdField_l_of_type_Boolean;
  private int jdField_m_of_type_Int;
  private String jdField_m_of_type_JavaLangString;
  private boolean jdField_m_of_type_Boolean = false;
  private int jdField_n_of_type_Int = 0;
  private String jdField_n_of_type_JavaLangString;
  private boolean jdField_n_of_type_Boolean = false;
  private boolean jdField_o_of_type_Boolean;
  private boolean jdField_p_of_type_Boolean;
  private boolean jdField_q_of_type_Boolean = false;
  private boolean r;
  
  static
  {
    jdField_a_of_type_JavaLangString = PhotoListActivity.class.getSimpleName();
    jdField_o_of_type_Int = -1;
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilHashMap.put("image", Integer.valueOf(0));
    jdField_a_of_type_JavaUtilHashMap.put("video", Integer.valueOf(1));
    jdField_a_of_type_JavaUtilHashMap.put("mobileqq", Integer.valueOf(2));
  }
  
  public PhotoListActivity()
  {
    this.jdField_a_of_type_Ckh = null;
    this.jdField_c_of_type_Int = 1;
    this.jdField_a_of_type_Boolean = true;
    this.p = false;
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
  
  private void a(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SelectPhotoTrace", 2, jdField_a_of_type_JavaLangString + " initData(),intent extras is:" + paramIntent.getExtras());
    }
    this.jdField_m_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
    if (paramIntent.getBooleanExtra("album_enter_directly", false))
    {
      long l1 = System.currentTimeMillis();
      long l2 = AlbumUtil.jdField_c_of_type_Long;
      if ((this.jdField_m_of_type_Boolean) && (l1 - l2 < 60000L))
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
      this.jdField_i_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", false);
      this.jdField_j_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_NEED_EDIT", false);
      this.jdField_k_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false);
      this.jdField_m_of_type_Int = paramIntent.getIntExtra("uintype", -1);
      this.jdField_n_of_type_Int = paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
      if (this.jdField_c_of_type_Int > 1) {
        this.jdField_a_of_type_Boolean = false;
      }
      this.jdField_l_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", false);
      this.jdField_n_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false);
      this.jdField_l_of_type_JavaLangString = paramIntent.getStringExtra("uinname");
      this.jdField_m_of_type_JavaLangString = paramIntent.getStringExtra("uin");
      if (this.jdField_d_of_type_JavaLangString != null) {
        break label539;
      }
    }
    label539:
    for (String str = this.jdField_h_of_type_JavaLangString;; str = this.jdField_d_of_type_JavaLangString)
    {
      this.jdField_d_of_type_JavaLangString = str;
      this.jdField_l_of_type_Int = paramIntent.getIntExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", MediaFileFilter.MEDIA_FILTER_SHOW_IMAGE.ordinal());
      this.jdField_b_of_type_Long = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_SIZE", 28835840L);
      this.jdField_d_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_PREVIEW_VIDEO", true);
      this.jdField_c_of_type_Long = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_DURATION", 9223372036854775807L);
      if (this.jdField_n_of_type_Boolean) {
        PhotoUtils.a(this, paramIntent, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_n_of_type_Int, true);
      }
      this.jdField_k_of_type_JavaLangString = paramIntent.getStringExtra("PhotoConst.CUSTOM_SENDBTN_TEXT");
      if (("$RecentAlbumId".equals(this.jdField_j_of_type_JavaLangString)) && (paramIntent.getBooleanExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", false)))
      {
        this.p = false;
        this.jdField_q_of_type_Boolean = false;
      }
      StatisticConstants.b(paramIntent);
      return;
      this.jdField_i_of_type_JavaLangString = paramIntent.getStringExtra("ALBUM_NAME");
      this.jdField_j_of_type_JavaLangString = paramIntent.getStringExtra("ALBUM_ID");
      break;
    }
  }
  
  private void a(String paramString)
  {
    if (new File(paramString).length() > 19922944L)
    {
      QQToast.a(this, getResources().getString(2131363966), 0).b(this.jdField_d_of_type_Int);
      this.jdField_n_of_type_Int = 0;
      h();
    }
  }
  
  private void a(ArrayList paramArrayList, int paramInt1, int paramInt2)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null, 2131624120);
    PhotoMagicStickUtils.a(this, paramArrayList, localActionSheet, paramInt1);
    localActionSheet.d(2131362801);
    localActionSheet.a(new ckd(this, paramArrayList, localActionSheet));
    localActionSheet.e(paramInt2);
    localActionSheet.show();
  }
  
  private void a(ArrayList paramArrayList, ActionSheet paramActionSheet, int paramInt)
  {
    if (paramArrayList.size() <= 0) {
      paramActionSheet.dismiss();
    }
    String str;
    do
    {
      return;
      paramActionSheet.e(paramInt);
      str = paramActionSheet.a(paramInt);
    } while (str == null);
    if (QLog.isColorLevel()) {
      QLog.d("_photo", 2, "onQualityBtnClick clikedBtn text:" + str);
    }
    if ((str != null) && (str.contains(getString(2131363954)))) {
      this.jdField_n_of_type_Int = 0;
    }
    for (;;)
    {
      h();
      paramActionSheet.dismiss();
      return;
      if ((str != null) && (str.contains(getString(2131363955))))
      {
        this.jdField_n_of_type_Int = 2;
        if (QLog.isColorLevel()) {
          QLog.d("raw_photo_4_test", 2, "start:" + str + ",photolist:" + paramArrayList.toString());
        }
      }
    }
  }
  
  private boolean a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    if (!"image".equals(MimeHelper.a(paramLocalMediaInfo.jdField_b_of_type_JavaLangString)[0])) {}
    long l1;
    do
    {
      int i1;
      do
      {
        return false;
        i1 = paramLocalMediaInfo.jdField_b_of_type_Int;
      } while (((i1 == 1) && (paramBoolean)) || ((i1 == 2) && (!paramBoolean)));
      if ((i1 != 2) || (!paramBoolean) || (this.jdField_a_of_type_JavaUtilArrayList.size() < this.jdField_c_of_type_Int)) {
        break;
      }
      l1 = System.currentTimeMillis();
    } while (l1 - this.jdField_a_of_type_Long < 700L);
    QQToast.a(this, "最多只能选择" + this.jdField_c_of_type_Int + "张图片", 1000).b(this.jdField_d_of_type_Int);
    this.jdField_a_of_type_Long = l1;
    return false;
    String str = paramLocalMediaInfo.jdField_a_of_type_JavaLangString;
    if (paramBoolean)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(str);
      paramLocalMediaInfo.jdField_b_of_type_Int = 1;
      LinkedHashMap localLinkedHashMap = (LinkedHashMap)AlbumUtil.jdField_b_of_type_JavaUtilHashMap.get(this.jdField_j_of_type_JavaLangString);
      paramLocalMediaInfo = localLinkedHashMap;
      if (localLinkedHashMap == null)
      {
        paramLocalMediaInfo = new LinkedHashMap();
        AlbumUtil.jdField_b_of_type_JavaUtilHashMap.put(this.jdField_j_of_type_JavaLangString, paramLocalMediaInfo);
      }
      paramLocalMediaInfo.put(str, Integer.valueOf(this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.q()));
      paramLocalMediaInfo = AlbumUtil.jdField_c_of_type_JavaUtilHashMap;
      if (!paramLocalMediaInfo.containsKey(str)) {
        paramLocalMediaInfo.put(str, new Pair(this.jdField_j_of_type_JavaLangString, this.jdField_i_of_type_JavaLangString));
      }
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramLocalMediaInfo.jdField_a_of_type_JavaLangString);
      paramLocalMediaInfo.jdField_b_of_type_Int = 2;
      paramLocalMediaInfo = (HashMap)AlbumUtil.jdField_b_of_type_JavaUtilHashMap.get(this.jdField_j_of_type_JavaLangString);
      if (paramLocalMediaInfo != null) {
        paramLocalMediaInfo.remove(str);
      }
      paramLocalMediaInfo = AlbumUtil.jdField_c_of_type_JavaUtilHashMap;
      if (paramLocalMediaInfo.containsKey(str)) {
        paramLocalMediaInfo.remove(str);
      }
    }
  }
  
  private void b(String paramString)
  {
    if (this.jdField_m_of_type_Boolean)
    {
      AlbumUtil.jdField_c_of_type_Long = System.currentTimeMillis();
      AlbumUtil.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_j_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_Ckh.getCount()));
      if (!TextUtils.isEmpty(paramString))
      {
        AlbumUtil.jdField_a_of_type_JavaLangString = paramString;
        HashMap localHashMap = AlbumUtil.jdField_c_of_type_JavaUtilHashMap;
        if (localHashMap.containsKey(paramString))
        {
          paramString = (Pair)localHashMap.get(paramString);
          AlbumUtil.jdField_b_of_type_JavaLangString = (String)paramString.first;
          AlbumUtil.jdField_c_of_type_JavaLangString = (String)paramString.second;
          AlbumUtil.a(this, AlbumUtil.jdField_b_of_type_JavaLangString, AlbumUtil.jdField_c_of_type_JavaLangString);
        }
      }
    }
    AlbumUtil.c();
  }
  
  private void c()
  {
    Resources localResources = getResources();
    int i1 = localResources.getDisplayMetrics().widthPixels;
    this.jdField_j_of_type_Int = localResources.getDimensionPixelSize(2131492959);
    this.jdField_h_of_type_Int = localResources.getDimensionPixelSize(2131492957);
    this.jdField_i_of_type_Int = localResources.getDimensionPixelSize(2131492958);
    this.jdField_k_of_type_Int = AIOUtils.a(1.0F, localResources);
    this.jdField_a_of_type_Int = ((i1 - this.jdField_j_of_type_Int * 2 - this.jdField_h_of_type_Int * 2) / 3);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
  }
  
  private void c(String paramString)
  {
    AlbumUtil.a();
    Intent localIntent = getIntent();
    localIntent.putExtra("ALBUM_NAME", this.jdField_i_of_type_JavaLangString);
    localIntent.putExtra("ALBUM_ID", this.jdField_j_of_type_JavaLangString);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_a_of_type_JavaUtilArrayList);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString);
    if (this.jdField_i_of_type_Boolean)
    {
      Object localObject = localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(DoodleActivity.class.getName())) && (new File(paramString).length() > 19922944L))
      {
        QQToast.a(this, getString(2131363967), 0).b(this.jdField_d_of_type_Int);
        return;
      }
      localObject = AlbumUtil.jdField_c_of_type_JavaUtilHashMap;
      if (!((HashMap)localObject).containsKey(paramString)) {
        ((HashMap)localObject).put(paramString, new Pair(this.jdField_j_of_type_JavaLangString, this.jdField_i_of_type_JavaLangString));
      }
      b(paramString);
      PhotoUtils.a(this, localIntent, this.jdField_a_of_type_JavaUtilArrayList, 0, this.jdField_c_of_type_Boolean);
      return;
    }
    if (!this.jdField_j_of_type_Boolean)
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
      AlbumUtil.a(localIntent, this.jdField_j_of_type_JavaLangString, paramString, this.jdField_m_of_type_Boolean);
      break;
      localIntent.setClass(this, PhotoCropActivity.class);
    }
  }
  
  @TargetApi(9)
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296898));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(getString(2131364539));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296902));
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296892));
    Object localObject;
    if (this.jdField_i_of_type_JavaLangString != null)
    {
      localObject = this.jdField_i_of_type_JavaLangString;
      setTitle((CharSequence)localObject);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131297428));
      h();
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131298348));
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131297429));
      this.jdField_a_of_type_AndroidViewView = findViewById(2131298347);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView = ((GestureSelectGridView)findViewById(2131298349));
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setScrollBarStyle(0);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setNumColumns(3);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setColumnWidth(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setHorizontalSpacing(this.jdField_h_of_type_Int);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setVerticalSpacing(this.jdField_i_of_type_Int);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setPadding(this.jdField_j_of_type_Int, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getPaddingTop(), this.jdField_j_of_type_Int, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getPaddingBottom());
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setOnIndexChangedListener(this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView$OnSelectListener);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setMaximumVelocity((int)(2500.0F * getResources().getDisplayMetrics().density));
      this.jdField_a_of_type_Ckh = new ckh(this);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setAdapter(this.jdField_a_of_type_Ckh);
      String str = this.jdField_k_of_type_JavaLangString;
      localObject = str;
      if (TextUtils.isEmpty(str))
      {
        if (!this.jdField_b_of_type_Boolean) {
          break label447;
        }
        localObject = getString(2131363956);
      }
      label335:
      this.jdField_c_of_type_AndroidWidgetButton.setText((CharSequence)localObject);
      localObject = this.jdField_a_of_type_AndroidViewView;
      if ((!this.jdField_a_of_type_Boolean) && (this.jdField_l_of_type_Int != MediaFileFilter.MEDIA_FILTER_SHOW_VIDEO.ordinal())) {
        break label458;
      }
    }
    label447:
    label458:
    for (int i1 = 8;; i1 = 0)
    {
      ((View)localObject).setVisibility(i1);
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      }
      g();
      return;
      if (this.jdField_l_of_type_Int == MediaFileFilter.MEDIA_FILTER_SHOW_VIDEO.ordinal())
      {
        localObject = "视频";
        break;
      }
      localObject = "最近照片";
      break;
      localObject = getString(2131363957);
      break label335;
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
        this.jdField_a_of_type_AndroidAppDialog = new Dialog(this, 2131624120);
        this.jdField_a_of_type_AndroidAppDialog.setCancelable(true);
        this.jdField_a_of_type_AndroidAppDialog.show();
        this.jdField_a_of_type_AndroidAppDialog.setContentView(2130903271);
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
    if (this.jdField_a_of_type_AndroidAppDialog != null) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.cancel();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException) {}
  }
  
  private void g()
  {
    String str1;
    if (this.jdField_k_of_type_JavaLangString != null)
    {
      str1 = this.jdField_k_of_type_JavaLangString;
      if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
        break label152;
      }
    }
    label152:
    for (boolean bool = true;; bool = false)
    {
      String str2 = str1;
      if (bool) {
        str2 = str1 + "(" + this.jdField_a_of_type_JavaUtilArrayList.size() + ")";
      }
      this.jdField_c_of_type_AndroidWidgetButton.setText(str2);
      this.jdField_c_of_type_AndroidWidgetButton.setEnabled(bool);
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(bool);
      if (!bool) {
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      }
      if (!this.jdField_b_of_type_Boolean) {
        break label157;
      }
      if (bool) {
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      }
      return;
      if (this.jdField_b_of_type_Boolean)
      {
        str1 = getString(2131363956);
        break;
      }
      str1 = getString(2131363957);
      break;
    }
    label157:
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
  }
  
  private void h()
  {
    switch (this.jdField_n_of_type_Int)
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
      localIntent.putExtra("output", Uri.fromFile(localObject));
      startActivityForResult(localIntent, 16);
    }
  }
  
  private void l()
  {
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
    if (QLog.isDevelopLevel())
    {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "[PhotoListActivity] [onActivityResult] requestCode = " + paramInt1 + "  resultCode:" + paramInt2 + "  ok:" + -1 + " mQueryPhotoAfterScan:" + this.r);
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() != 0)) {
        QLog.d(jdField_a_of_type_JavaLangString, 4, "[PhotoListActivity] [onActivityResult] selectedPhotoList = " + this.jdField_a_of_type_JavaUtilArrayList.size());
      }
    }
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    label236:
    while (paramInt1 != 17)
    {
      PhotoUtils.a(this, paramInt1, paramInt2, paramIntent, this.jdField_k_of_type_Boolean, this.jdField_d_of_type_JavaLangString);
      return;
      String str;
      if (this.jdField_a_of_type_Boolean)
      {
        c(this.jdField_n_of_type_JavaLangString);
        paramIntent = getApplicationContext();
        str = this.jdField_n_of_type_JavaLangString;
        if (this.jdField_a_of_type_Boolean) {
          break label236;
        }
      }
      for (;;)
      {
        new ckf(this, paramIntent, str, null, bool);
        return;
        if (this.r) {
          break;
        }
        this.r = true;
        break;
        bool = false;
      }
    }
    AlbumUtil.jdField_c_of_type_Long = 0L;
  }
  
  public void onBackPressed()
  {
    Intent localIntent = getIntent();
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_a_of_type_JavaUtilArrayList);
    localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_n_of_type_Int);
    localIntent.putExtra("peak.myUin", this.jdField_d_of_type_JavaLangString);
    localIntent.setClass(this, AlbumListActivity.class);
    localIntent.addFlags(603979776);
    StatisticConstants.a(localIntent, "PhotoConst.u_album_count");
    startActivity(localIntent);
    finish();
    AlbumUtil.a(this, true, false);
  }
  
  @TargetApi(9)
  public void onClick(View paramView)
  {
    int i2 = 0;
    int i1 = 0;
    switch (paramView.getId())
    {
    }
    Object localObject;
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
          if (!this.jdField_l_of_type_Boolean)
          {
            finish();
            AlbumUtil.a(this, false, false);
            paramView = getIntent();
            if (this.jdField_a_of_type_JavaUtilArrayList != null) {
              i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
            }
            StatisticConstants.a(paramView, i1);
            return;
          }
          paramView = getIntent();
          localObject = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
          String str = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
          if (localObject == null)
          {
            QQToast.a(this, "请设置INIT_ACTIVITY_CLASS_NAME ", 0).a();
            return;
          }
          paramView.setClassName(str, (String)localObject);
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
            break;
            paramView.getStringExtra("PhotoConst.PLUGIN_NAME");
            localObject = paramView.getStringExtra("PhotoConst.PLUGIN_APK");
            str = paramView.getStringExtra("PhotoConst.UIN");
            if ("qqfav.apk".equals(localObject)) {
              QfavHelper.a(this, str, paramView, 2);
            }
          }
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
        StatisticConstants.a(paramView, "PhotoConst.preview_count");
        startActivity(paramView);
        finish();
        AlbumUtil.a(this, true, true);
      } while ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0));
      ReportController.b(null, "CliOper", "0X8004072", this.jdField_d_of_type_JavaLangString, "0X8004072", "0X8004072", 0, this.jdField_a_of_type_JavaUtilArrayList.size(), 0, "", "", "", "");
      return;
      this.jdField_c_of_type_AndroidWidgetButton.setClickable(false);
      if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
        b((String)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1));
      }
      AlbumUtil.a();
      if (this.jdField_a_of_type_JavaUtilArrayList.size() != 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("PhotoList", 2, "size == 0");
    return;
    paramView = getIntent();
    if (paramView.getBooleanExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", false))
    {
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      for (long l1 = 0L; ((Iterator)localObject).hasNext(); l1 += FileUtils.a((String)((Iterator)localObject).next())) {}
      if (l1 > 5242880L) {}
      for (i1 = 1; (FileManagerUtil.a()) && (i1 != 0); i1 = 0)
      {
        FMDialogUtil.a(this, 2131362018, 2131362016, new cke(this));
        return;
      }
    }
    l();
    i1 = i2;
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    StatisticConstants.a(paramView, i1);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    requestWindowFeature(7);
    super.onCreate(paramBundle);
    if (this.p) {
      getWindow().setFormat(-3);
    }
    getWindow().setBackgroundDrawable(null);
    try
    {
      super.setContentView(2130903519);
      getWindow().setFeatureInt(7, 2130903134);
      getWindow().setBackgroundDrawable(null);
      this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplication.getContext().getSharedPreferences("share", 0);
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
  
  protected void onDestroy()
  {
    AlbumThumbManager.a(this).a();
    super.onDestroy();
    if (this.jdField_a_of_type_Ckh != null)
    {
      int i2 = this.jdField_a_of_type_Ckh.getCount();
      int i1 = i2;
      if (this.p)
      {
        i1 = i2;
        if ("$RecentAlbumId".equals(this.jdField_j_of_type_JavaLangString)) {
          i1 = i2 - 1;
        }
      }
      AlbumUtil.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_j_of_type_JavaLangString, Integer.valueOf(i1));
    }
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
  
  protected void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_AndroidOsAsyncTask = null;
    if ((this.p) && (!this.jdField_q_of_type_Boolean)) {
      j();
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "[PhotoListActivity] [onResume] mQueryPhotoAfterScan = " + this.r + "  queryPhotoTask:" + this.jdField_a_of_type_AndroidOsAsyncTask);
    }
    if ((!this.r) && (this.jdField_a_of_type_AndroidOsAsyncTask == null))
    {
      this.jdField_a_of_type_AndroidOsAsyncTask = new ckj(this, null);
      this.jdField_a_of_type_AndroidOsAsyncTask.execute(new Object[0]);
    }
    if ((this.p) && (!this.jdField_q_of_type_Boolean)) {
      i();
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    super.setTitle(paramCharSequence);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(paramCharSequence);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoListActivity
 * JD-Core Version:    0.7.0.1
 */