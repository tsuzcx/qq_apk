package com.tencent.mobileqq.activity;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import android.text.format.Time;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import bcw;
import bcz;
import bdb;
import bdc;
import bdd;
import bde;
import bdf;
import bdg;
import bdi;
import bdj;
import bdk;
import bdl;
import bdm;
import bdn;
import bdo;
import bds;
import bdt;
import bdu;
import bdv;
import bdw;
import com.qq.jce.wup.UniPacket;
import com.tencent.biz.common.download.OfflineDownloader;
import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.map.lbsapi.api.SOSOMapLBSApi;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.config.QQMapConstants;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQMapView;
import com.tencent.mobileqq.widget.QQMapView.QQMapViewObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.SelectPicPopupWindow;
import com.tencent.mobileqq.widget.SelectPicPopupWindow.ViewHolder;
import com.tencent.proto.lbsshare.LBSShare.GetShopsByIdsResp;
import com.tencent.proto.lbsshare.LBSShare.LocationResp;
import com.tencent.proto.lbsshare.LBSShare.NearByShopsResp;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;
import com.tencent.tencentmap.mapsdk.map.MapActivity;
import com.tencent.tencentmap.mapsdk.map.MapController;
import com.tencent.tencentmap.mapsdk.map.MapView.LayoutParams;
import com.tencent.theme.SkinnableActivityProcesser;
import com.tencent.theme.SkinnableActivityProcesser.Callback;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.RejectedExecutionException;
import mqq.app.ApplicationLifeController;
import org.json.JSONException;
import org.json.JSONObject;

public class QQMapActivity
  extends MapActivity
  implements QQMapView.QQMapViewObserver, SkinnableActivityProcesser.Callback
{
  private static final int jdField_a_of_type_Int = 0;
  private static final int jdField_b_of_type_Int = 1;
  public static final String e = "QQMapActivity";
  protected static final String f = "fetch_address";
  protected static final String g = "get_location";
  protected static final String h = "com.tencent.mobileqq.onGetStreetViewUrl";
  protected static final int i = 0;
  protected static final String i = "com.tencent.process.exit";
  public double a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new bdj(this);
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public Handler a;
  Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  bdw jdField_a_of_type_Bdw = new bdw(this, 1, 1, 1, 8);
  protected AsyncBack a;
  protected QQMapView a;
  public SelectPicPopupWindow a;
  GeoPoint jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint;
  public MapController a;
  SkinnableActivityProcesser jdField_a_of_type_ComTencentThemeSkinnableActivityProcesser;
  public ActionSheet a;
  public double b;
  float jdField_b_of_type_Float;
  private BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver = new bdk(this);
  public View.OnClickListener b;
  Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  public ImageView b;
  protected TextView b;
  protected List b;
  protected View.OnClickListener c;
  public ImageView c;
  protected TextView c;
  protected View.OnClickListener d;
  protected ImageView d;
  protected TextView d;
  protected View.OnClickListener e;
  protected ImageView e;
  protected TextView e;
  protected View.OnClickListener f;
  protected View f;
  protected TextView f;
  protected View.OnClickListener g;
  protected View g;
  protected View h;
  public boolean h;
  protected View i;
  public boolean i;
  protected View j;
  public String j;
  public boolean j;
  protected View k;
  protected String k;
  boolean k;
  public String l;
  protected boolean l;
  public String m;
  public boolean m;
  public String n;
  public boolean n;
  public String o;
  protected boolean o;
  public String p;
  public boolean p;
  protected String q;
  public String r = null;
  
  public QQMapActivity()
  {
    this.jdField_j_of_type_JavaLangString = "";
    this.jdField_h_of_type_Boolean = false;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_k_of_type_Boolean = false;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_m_of_type_Boolean = false;
    this.jdField_n_of_type_Boolean = true;
    this.jdField_o_of_type_Boolean = false;
    this.jdField_p_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack = null;
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new bdm(this);
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_c_of_type_AndroidViewView$OnClickListener = new bds(this);
    this.jdField_d_of_type_AndroidViewView$OnClickListener = new bdt(this);
    this.jdField_e_of_type_AndroidViewView$OnClickListener = new bdu(this);
    this.jdField_f_of_type_AndroidViewView$OnClickListener = new bdv(this);
    this.jdField_g_of_type_AndroidViewView$OnClickListener = new bcz(this);
  }
  
  static String a(Context paramContext)
  {
    int i1 = Process.myPid();
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if (localRunningAppProcessInfo.pid == i1) {
        return localRunningAppProcessInfo.processName;
      }
    }
    return null;
  }
  
  private static String a(ArrayList paramArrayList, boolean paramBoolean)
  {
    Time localTime = new Time();
    localTime.setToNow();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("com.tencent.process.exit");
    localStringBuilder.append(localTime.year).append(localTime.month + 1).append(localTime.monthDay);
    localStringBuilder.append(localTime.hour);
    if (paramBoolean)
    {
      localStringBuilder.append(localTime.minute - 1);
      if (paramArrayList != null) {
        break label134;
      }
    }
    label134:
    for (paramArrayList = "null";; paramArrayList = paramArrayList.toString())
    {
      localStringBuilder.append(paramArrayList);
      paramArrayList = MD5.toMD5(localStringBuilder.toString());
      return MD5.toMD5(paramArrayList + localStringBuilder.toString());
      localStringBuilder.append(localTime.minute);
      break;
    }
  }
  
  private void a()
  {
    if ((this.jdField_m_of_type_JavaLangString == null) || (this.jdField_m_of_type_JavaLangString.length() == 0))
    {
      if (this.jdField_d_of_type_AndroidWidgetImageView != null) {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if (this.jdField_e_of_type_AndroidWidgetImageView != null) {
        this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if (this.jdField_h_of_type_AndroidViewView != null) {
        this.jdField_h_of_type_AndroidViewView.setVisibility(8);
      }
      if (this.jdField_c_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setClickable(false);
        this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(null);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (this.jdField_c_of_type_AndroidWidgetTextView == null);
        if ((this.jdField_h_of_type_AndroidViewView != null) && (!this.jdField_l_of_type_Boolean))
        {
          this.jdField_h_of_type_AndroidViewView.setVisibility(0);
          this.jdField_h_of_type_AndroidViewView.setOnClickListener(new bcw(this));
        }
      } while (this.jdField_c_of_type_AndroidWidgetTextView.getText().length() <= 0);
      if (this.jdField_d_of_type_AndroidWidgetImageView != null) {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    } while (this.jdField_e_of_type_AndroidWidgetImageView == null);
    this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  private void a(double paramDouble1, double paramDouble2)
  {
    if (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController != null)
    {
      GeoPoint localGeoPoint = new GeoPoint((int)(paramDouble1 * 1000000.0D), (int)(paramDouble2 * 1000000.0D));
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController.setCenter(localGeoPoint);
      if ((this.jdField_l_of_type_JavaLangString == null) || (this.jdField_l_of_type_JavaLangString.length() <= 0)) {
        a(localGeoPoint, this.jdField_c_of_type_AndroidWidgetTextView, false);
      }
    }
    else
    {
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_l_of_type_JavaLangString);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    a();
  }
  
  private void a(GeoPoint paramGeoPoint, TextView paramTextView, boolean paramBoolean)
  {
    this.jdField_j_of_type_JavaLangString = "";
    try
    {
      new QQMapActivity.GetLocNameTask(this, paramGeoPoint, paramTextView).execute(new GeoPoint[] { paramGeoPoint });
      if (paramBoolean) {
        n();
      }
      return;
    }
    catch (RejectedExecutionException paramGeoPoint)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("QQMapActivity", 2, paramGeoPoint.getMessage());
    }
  }
  
  private boolean a(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    if (paramString.contains("geo:0,0")) {
      localIntent.setClassName(QQMapConstants.f, QQMapConstants.c);
    }
    for (;;)
    {
      try
      {
        a(this, localIntent);
        bool = true;
      }
      catch (ActivityNotFoundException localActivityNotFoundException)
      {
        boolean bool = false;
        continue;
        if (!paramString.startsWith("bdapp")) {
          continue;
        }
        int i1 = 4;
        continue;
        if (!paramString.startsWith("androidamap")) {
          continue;
        }
        i1 = 3;
        continue;
        if (!paramString.startsWith("geo:0,0")) {
          continue;
        }
        i1 = 6;
        continue;
        i1 = -1;
        continue;
      }
      if (!paramString.startsWith("sosogeo")) {
        continue;
      }
      i1 = 1;
      if (i1 != -1) {
        ReportController.a(null, "P_CliOper", "Pb_account_lifeservice", "", "rec_locate", "click_navig", 0, 0, String.valueOf(i1), "", "", "");
      }
      return bool;
      if (paramString.startsWith("sosogeo")) {
        localIntent.setClassName(QQMapConstants.d, QQMapConstants.b);
      }
    }
  }
  
  private void b()
  {
    Object localObject3 = null;
    Bundle localBundle = getIntent().getExtras();
    Object localObject4 = localBundle.getString("options");
    if (!TextUtils.isEmpty((CharSequence)localObject4)) {}
    for (;;)
    {
      try
      {
        Object localObject1 = new JSONObject((String)localObject4);
        if (localObject1 == null) {
          break label503;
        }
        localObject3 = ((JSONObject)localObject1).optString("lat");
        localObject4 = ((JSONObject)localObject1).optString("lng");
        this.jdField_o_of_type_JavaLangString = ((JSONObject)localObject1).optString("title");
        this.jdField_l_of_type_JavaLangString = ((JSONObject)localObject1).optString("desc");
        this.jdField_k_of_type_Boolean = "share".equals(((JSONObject)localObject1).opt("action"));
        this.jdField_k_of_type_JavaLangString = ("http://maps.google.com/maps?q=" + (String)localObject3 + "," + (String)localObject4 + "&iwloc=A&hl=zh-CN (" + this.jdField_l_of_type_JavaLangString + ")");
        localObject1 = localObject4;
        localObject4 = localObject3;
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          localObject4 = localBundle.getString("lat");
        }
        localObject3 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject3 = localBundle.getString("lon");
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject4)) && (!TextUtils.isEmpty((CharSequence)localObject3)))
        {
          this.jdField_h_of_type_Boolean = true;
          this.jdField_a_of_type_Double = Double.valueOf((String)localObject4).doubleValue();
          this.jdField_b_of_type_Double = Double.valueOf((String)localObject3).doubleValue();
        }
        if (TextUtils.isEmpty(this.jdField_o_of_type_JavaLangString)) {
          this.jdField_o_of_type_JavaLangString = localBundle.getString("title");
        }
        this.jdField_p_of_type_JavaLangString = localBundle.getString("summary");
        if (TextUtils.isEmpty(this.jdField_k_of_type_JavaLangString)) {
          this.jdField_k_of_type_JavaLangString = localBundle.getString("url");
        }
        if (TextUtils.isEmpty(this.jdField_l_of_type_JavaLangString)) {
          this.jdField_l_of_type_JavaLangString = localBundle.getString("loc");
        }
        if ((this.jdField_l_of_type_JavaLangString != null) && (this.jdField_l_of_type_JavaLangString.contains("+"))) {
          this.jdField_l_of_type_JavaLangString = this.jdField_l_of_type_JavaLangString.replace("+", " ");
        }
        this.q = localBundle.getString("dpid");
        if (this.jdField_h_of_type_Boolean) {
          sendBroadcast(new Intent("com.tencent.mobileqq.getStreetViewUrl").putExtra("latitude", this.jdField_a_of_type_Double).putExtra("longitude", this.jdField_b_of_type_Double));
        }
        this.jdField_b_of_type_Float = getResources().getDisplayMetrics().density;
        this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this, 2130968616);
        this.jdField_a_of_type_AndroidViewAnimationAnimation.setRepeatMode(2);
        this.jdField_a_of_type_AndroidViewAnimationAnimation.setRepeatCount(1);
        this.jdField_b_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this, 2130968617);
        this.jdField_b_of_type_AndroidViewAnimationAnimation.setRepeatMode(2);
        this.jdField_b_of_type_AndroidViewAnimationAnimation.setRepeatCount(1);
        return;
      }
      catch (JSONException localJSONException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("get_params", 2, "parse params failed, options : " + (String)localObject4);
        }
      }
      Object localObject2 = null;
      continue;
      label503:
      localObject4 = null;
      localObject2 = localObject3;
      localObject3 = localObject4;
    }
  }
  
  private boolean b(String paramString)
  {
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    try
    {
      a(this, paramString, 0);
      return true;
    }
    catch (ActivityNotFoundException paramString) {}
    return false;
  }
  
  private static boolean b(String paramString, ArrayList paramArrayList)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    while ((!paramString.equals(a(paramArrayList, false))) && (!paramString.equals(a(paramArrayList, true)))) {
      return false;
    }
    return true;
  }
  
  private static boolean b(ArrayList paramArrayList, Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      bool1 = true;
    }
    do
    {
      return bool1;
      paramContext = a(paramContext);
      bool1 = bool2;
    } while (paramContext == null);
    int i1 = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i1 >= paramArrayList.size()) {
        break;
      }
      if (paramContext.equals(paramArrayList.get(i1))) {
        return true;
      }
      i1 += 1;
    }
  }
  
  private void f()
  {
    findViewById(2131297524).setVisibility(8);
    this.jdField_k_of_type_AndroidViewView = findViewById(2131298582);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView = ((QQMapView)findViewById(2131298583));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298589));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298587));
    this.jdField_h_of_type_AndroidViewView = findViewById(2131298586);
    Object localObject = BitmapManager.a(getResources(), 2130839127);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
    this.jdField_b_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, ((Bitmap)localObject).getHeight());
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298588));
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130839129);
    this.jdField_c_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, ((Bitmap)localObject).getHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.setContentDescription(getString(2131362628));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.setLogoMarginRate(0, 0.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.setLogoMarginRate(1, 0.8F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.setLogoMarginRate(2, 0.0F);
    if (!this.jdField_h_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.setObserver(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.setBuiltInZoomControls(false);
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController = this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.getController();
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController.setZoom(16);
      g();
      t();
      s();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.setObserver(null);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    for (;;)
    {
      try
      {
        this.jdField_f_of_type_AndroidViewView = getLayoutInflater().inflate(2130903221, null);
        localObject = new MapView.LayoutParams(-2, -2, null, 81);
        ((MapView.LayoutParams)localObject).point = new GeoPoint((int)(this.jdField_a_of_type_Double * 1000000.0D), (int)(this.jdField_b_of_type_Double * 1000000.0D));
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.addView(this.jdField_f_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
        this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_f_of_type_AndroidViewView.findViewById(2131297247));
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
        this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_f_of_type_AndroidViewView.findViewById(2131297248));
        this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(4);
        this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_f_of_type_AndroidViewView.findViewById(2131297245));
        this.jdField_i_of_type_AndroidViewView = this.jdField_f_of_type_AndroidViewView.findViewById(2131297244);
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_f_of_type_AndroidViewView.findViewById(2131297246));
        this.jdField_c_of_type_AndroidWidgetTextView.setText("");
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
        this.jdField_j_of_type_AndroidViewView = this.jdField_f_of_type_AndroidViewView.findViewById(2131297249);
        if (!TextUtils.isEmpty(this.jdField_k_of_type_JavaLangString))
        {
          this.jdField_j_of_type_AndroidViewView.setVisibility(0);
          this.jdField_j_of_type_AndroidViewView.setOnClickListener(this.jdField_f_of_type_AndroidViewView$OnClickListener);
          a();
        }
      }
      catch (Resources.NotFoundException localNotFoundException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQMapActivity", 2, localNotFoundException.getMessage());
        }
        super.finish();
        return;
      }
      this.jdField_j_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  private void g()
  {
    String str = TimeZone.getDefault().getID();
    if (QLog.isColorLevel()) {
      QLog.d("QQMapActivity", 2, "default timezone:" + str);
    }
    if (((!"Asia/Shanghai".equals(str)) && (!"Asia/Hong_Kong".equals(str)) && (!"Asia/Chongqing".equals(str)) && (!"Asia/Beijing".equals(str))) || (!"zh".equals(Locale.getDefault().getLanguage())))
    {
      ReportController.a(null, "P_CliOper", "Pb_account_lifeservice", "", "rec_locate", "call_googlemap", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.setGoogleMapEnable(true);
      findViewById(2131298584).setVisibility(0);
      this.jdField_o_of_type_Boolean = true;
    }
  }
  
  private void s()
  {
    Object localObject = (ViewGroup)findViewById(2131296894);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = findViewById(2131296936);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = (TextView)findViewById(2131296901);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
  }
  
  private void t()
  {
    ((ImageView)findViewById(2131298592)).setOnClickListener(new bdb(this));
    ((ImageView)findViewById(2131298593)).setOnClickListener(new bdc(this));
    ((ImageView)findViewById(2131298594)).setOnClickListener(new bdd(this));
  }
  
  public Dialog a(int paramInt1, int paramInt2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    return a(getResources().getString(paramInt1), getResources().getString(paramInt2), paramOnDismissListener);
  }
  
  public Dialog a(String paramString)
  {
    Dialog localDialog = new Dialog(this, 2131624119);
    localDialog.setContentView(2130903145);
    TextView localTextView = (TextView)localDialog.findViewById(2131296470);
    if (localTextView != null) {
      localTextView.setText(paramString);
    }
    return localDialog;
  }
  
  public Dialog a(String paramString1, String paramString2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    Dialog localDialog = new Dialog(this, 2131624119);
    localDialog.setContentView(2130903135);
    TextView localTextView = (TextView)localDialog.findViewById(2131296915);
    if (localTextView != null) {
      localTextView.setText(paramString1);
    }
    paramString1 = (TextView)localDialog.findViewById(2131296470);
    if (paramString1 != null) {
      paramString1.setText(paramString2);
    }
    paramString1 = (TextView)localDialog.findViewById(2131296918);
    if (paramString1 != null) {
      paramString1.setText(2131363354);
    }
    paramString1 = (TextView)localDialog.findViewById(2131296919);
    if (paramString1 != null) {
      paramString1.setText(2131363110);
    }
    localDialog.setOnDismissListener(paramOnDismissListener);
    return localDialog;
  }
  
  public Intent a()
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    GeoPoint localGeoPoint = this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.getMapCenter();
    double d1 = localGeoPoint.getLatitudeE6() / 1000000.0D;
    double d2 = localGeoPoint.getLongitudeE6() / 1000000.0D;
    localBundle.putString("latitude", String.valueOf(d1));
    localBundle.putString("longitude", String.valueOf(d2));
    localBundle.putString("description", this.jdField_j_of_type_JavaLangString);
    if ((TextUtils.isEmpty(this.jdField_o_of_type_JavaLangString)) || (this.jdField_o_of_type_JavaLangString.equals(getString(2131364340)))) {
      this.jdField_o_of_type_JavaLangString = getString(2131363209);
    }
    if (TextUtils.isEmpty(this.jdField_p_of_type_JavaLangString)) {
      this.jdField_p_of_type_JavaLangString = "Unknown Address";
    }
    localBundle.putString("title", this.jdField_o_of_type_JavaLangString);
    localBundle.putString("summary", this.jdField_p_of_type_JavaLangString);
    localBundle.putString("dianping_id", this.q);
    localIntent.putExtras(localBundle);
    return localIntent;
  }
  
  public final Object a(byte[] paramArrayOfByte, String paramString, Object paramObject)
  {
    UniPacket localUniPacket = new UniPacket(true);
    try
    {
      localUniPacket.setEncodeName("utf-8");
      localUniPacket.decode(paramArrayOfByte);
      return localUniPacket.getByClass(paramString, paramObject);
    }
    catch (RuntimeException paramArrayOfByte)
    {
      return (Object)null;
    }
    catch (Exception paramArrayOfByte) {}
    return (Object)null;
  }
  
  protected String a()
  {
    String str = QQMapConstants.jdField_j_of_type_JavaLangString;
    return getSharedPreferences("QQMAP", 0).getString(str, null);
  }
  
  public List a()
  {
    PackageManager localPackageManager = getPackageManager();
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setData(Uri.parse("geo:0,0"));
    return localPackageManager.queryIntentActivities(localIntent, 0);
  }
  
  public void a(LBSShare.GetShopsByIdsResp paramGetShopsByIdsResp) {}
  
  public void a(LBSShare.LocationResp paramLocationResp, Bundle paramBundle) {}
  
  public void a(LBSShare.NearByShopsResp paramNearByShopsResp, Bundle paramBundle) {}
  
  public void a(GeoPoint paramGeoPoint) {}
  
  public void a(GeoPoint paramGeoPoint, String paramString)
  {
    Object localObject = new MapView.LayoutParams(-2, -2, null, 81);
    ((MapView.LayoutParams)localObject).point = paramGeoPoint;
    if (this.jdField_g_of_type_AndroidViewView == null)
    {
      this.jdField_g_of_type_AndroidViewView = getLayoutInflater().inflate(2130903221, null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.addView(this.jdField_g_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_g_of_type_AndroidViewView.findViewById(2131297246));
      this.jdField_d_of_type_AndroidWidgetTextView.setClickable(false);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_g_of_type_AndroidViewView.findViewById(2131297247).setVisibility(8);
      this.jdField_g_of_type_AndroidViewView.findViewById(2131297248).setVisibility(8);
      this.jdField_g_of_type_AndroidViewView.findViewById(2131297244).setVisibility(4);
      paramGeoPoint = (ImageView)this.jdField_g_of_type_AndroidViewView.findViewById(2131297251);
      paramGeoPoint.setImageResource(2130837623);
      paramGeoPoint.setBackgroundDrawable(null);
      paramGeoPoint = (ImageView)this.jdField_g_of_type_AndroidViewView.findViewById(2131297250);
      localObject = AnimationUtils.loadAnimation(this, 17432576);
      ((Animation)localObject).setDuration(800L);
      ((Animation)localObject).setRepeatCount(2);
      ((Animation)localObject).setRepeatCount(-1);
      paramGeoPoint.startAnimation((Animation)localObject);
    }
    for (;;)
    {
      if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
        this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString);
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.updateViewLayout(this.jdField_g_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
    }
  }
  
  boolean a(GeoPoint paramGeoPoint)
  {
    if (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint == null) {
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint = paramGeoPoint;
    }
    while ((paramGeoPoint == null) || (Math.abs(paramGeoPoint.getLatitudeE6() - this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint.getLatitudeE6()) >= 1) || (Math.abs(paramGeoPoint.getLongitudeE6() - this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint.getLongitudeE6()) >= 1)) {
      return false;
    }
    return true;
  }
  
  boolean a(List paramList1, List paramList2)
  {
    if ((paramList1 == null) || (paramList2 == null)) {
      return false;
    }
    if (paramList1.size() == paramList2.size()) {}
    for (int i1 = paramList1.size(); i1 == 0; i1 = 0) {
      return false;
    }
    int i2 = 0;
    while (i2 < i1)
    {
      if (!((ResolveInfo)paramList1.get(i2)).activityInfo.packageName.equalsIgnoreCase(((ResolveInfo)paramList2.get(i2)).activityInfo.packageName)) {
        return false;
      }
      i2 += 1;
    }
    return true;
  }
  
  public boolean a(List paramList, boolean paramBoolean)
  {
    boolean bool2 = false;
    Object localObject1 = null;
    int i2 = paramList.size();
    boolean bool1 = bool2;
    if (paramList != null)
    {
      if (paramList.size() != 0) {
        break label38;
      }
      bool1 = bool2;
    }
    label38:
    int i1;
    Object localObject3;
    Object localObject5;
    do
    {
      return bool1;
      i1 = 0;
      localObject4 = null;
      localObject3 = null;
      bool1 = false;
      localObject2 = null;
      if (i1 >= i2) {
        break label228;
      }
      localObject5 = (ResolveInfo)paramList.get(i1);
      if (!((ResolveInfo)localObject5).activityInfo.packageName.equalsIgnoreCase(QQMapConstants.d)) {
        break;
      }
      bool2 = true;
      bool1 = true;
    } while (paramBoolean);
    Object localObject2 = localObject4;
    Object localObject4 = localObject5;
    bool1 = bool2;
    for (;;)
    {
      i1 += 1;
      localObject5 = localObject4;
      localObject4 = localObject2;
      localObject2 = localObject5;
      break;
      Object localObject6;
      if (((ResolveInfo)localObject5).activityInfo.packageName.equalsIgnoreCase(QQMapConstants.g))
      {
        localObject6 = localObject2;
        localObject2 = localObject4;
        localObject3 = localObject5;
        localObject4 = localObject6;
      }
      else if (((ResolveInfo)localObject5).activityInfo.packageName.equalsIgnoreCase(QQMapConstants.e))
      {
        localObject4 = localObject2;
        localObject2 = localObject5;
      }
      else if (((ResolveInfo)localObject5).activityInfo.packageName.equalsIgnoreCase(QQMapConstants.f))
      {
        localObject6 = localObject2;
        localObject1 = localObject5;
        localObject2 = localObject4;
        localObject4 = localObject6;
        continue;
        label228:
        paramList.removeAll(paramList);
        if (localObject2 != null) {
          paramList.add(localObject2);
        }
        if (localObject3 != null) {
          paramList.add(localObject3);
        }
        if (localObject4 != null) {
          paramList.add(localObject4);
        }
        if (localObject1 != null) {
          paramList.add(localObject1);
        }
        return bool1;
      }
      else
      {
        localObject5 = localObject2;
        localObject2 = localObject4;
        localObject4 = localObject5;
      }
    }
  }
  
  public void b(GeoPoint paramGeoPoint)
  {
    if ((!this.jdField_h_of_type_Boolean) && (!a(paramGeoPoint)))
    {
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint = paramGeoPoint;
      a(paramGeoPoint);
    }
  }
  
  public void b(String paramString)
  {
    String str = QQMapConstants.jdField_j_of_type_JavaLangString;
    SharedPreferences.Editor localEditor = getSharedPreferences("QQMAP", 0).edit();
    localEditor.putString(str, paramString);
    localEditor.commit();
  }
  
  protected void c() {}
  
  public void c(GeoPoint paramGeoPoint)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  public void d() {}
  
  protected void e() {}
  
  public void h()
  {
    this.jdField_i_of_type_Boolean = false;
    findViewById(2131298590).setVisibility(0);
    if (!this.jdField_h_of_type_Boolean)
    {
      TextView localTextView = (TextView)findViewById(2131296905);
      localTextView.setVisibility(0);
      localTextView.setText(localTextView.getTag().toString());
    }
  }
  
  public void i()
  {
    int i2 = a(this).getDimensionPixelSize(2131492887);
    if (Utils.b() < 31457280L)
    {
      QQToast.a(this, 1, getString(2131362617), 1).b(i2);
      return;
    }
    int i1 = 0;
    while ((this.r == null) && (i1 < 3)) {
      try
      {
        HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(QQMapConstants.h).openConnection();
        localHttpURLConnection.setRequestMethod("GET");
        localHttpURLConnection.setInstanceFollowRedirects(false);
        localHttpURLConnection.addRequestProperty("Accept-Charset", "UTF-8;");
        localHttpURLConnection.connect();
        this.r = localHttpURLConnection.getHeaderField(QQMapConstants.jdField_k_of_type_JavaLangString);
        localHttpURLConnection.disconnect();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        i1 += 1;
      }
    }
    if (this.r == null)
    {
      QQToast.a(this, 1, getString(2131362608), 1).b(i2);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSelectPicPopupWindow.dismiss();
      return;
    }
    Object localObject1 = ((SelectPicPopupWindow.ViewHolder)this.jdField_a_of_type_ComTencentMobileqqWidgetSelectPicPopupWindow.a.get(0)).jdField_a_of_type_AndroidWidgetProgressBar;
    Object localObject2 = ((SelectPicPopupWindow.ViewHolder)this.jdField_a_of_type_ComTencentMobileqqWidgetSelectPicPopupWindow.a.get(0)).jdField_a_of_type_AndroidWidgetTextView;
    if (((ProgressBar)localObject1).getVisibility() == 8)
    {
      ((ProgressBar)localObject1).setVisibility(0);
      ((TextView)localObject2).setVisibility(0);
      ((TextView)localObject2).setBackgroundDrawable(null);
      ((TextView)localObject2).setText(getString(2131362616));
    }
    localObject1 = "QQMAP" + QQMapConstants.h;
    localObject2 = getSharedPreferences("QQMAP", 0);
    String str = ((SharedPreferences)localObject2).getString((String)localObject1, null);
    if ((TextUtils.isEmpty(str)) || (str.equalsIgnoreCase(this.r))) {}
    for (;;)
    {
      OfflineDownloader.a(getApplicationContext(), this.r, QQMapConstants.i, this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack);
      localObject2 = ((SharedPreferences)localObject2).edit();
      ((SharedPreferences.Editor)localObject2).putString((String)localObject1, this.r);
      ((SharedPreferences.Editor)localObject2).commit();
      return;
      OfflineDownloader.c(QQMapConstants.i);
    }
  }
  
  public void j()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.d(super.getString(2131362790));
    localActionSheet.a(super.getString(2131362618), 1);
    localActionSheet.a(new bdl(this, localActionSheet));
    localActionSheet.show();
  }
  
  public void k()
  {
    Object localObject2 = a();
    String str1;
    Object localObject1;
    if ((this.jdField_o_of_type_JavaLangString != null) && (!this.jdField_o_of_type_JavaLangString.equals(super.getString(2131363209))))
    {
      str1 = this.jdField_o_of_type_JavaLangString;
      if (localObject2 == null) {
        break label338;
      }
      if (!((String)localObject2).startsWith("sosogeo")) {
        break label124;
      }
      localObject1 = "sosogeo://?q=" + this.jdField_a_of_type_Double + "," + this.jdField_b_of_type_Double + "(" + str1 + ")";
    }
    for (;;)
    {
      if (!a((String)localObject1)) {
        break label338;
      }
      return;
      str1 = this.jdField_l_of_type_JavaLangString;
      break;
      label124:
      if (((String)localObject2).startsWith("bdapp"))
      {
        localObject1 = "bdapp://map/marker?location=" + this.jdField_a_of_type_Double + "," + this.jdField_b_of_type_Double + "&title=" + str1 + "&content=" + this.jdField_l_of_type_JavaLangString + "&src=tencent|qq&coord_type=gcj02";
      }
      else if (((String)localObject2).startsWith("androidamap"))
      {
        localObject1 = "androidamap://viewMap?sourceApplication=tencentqq&lat=" + this.jdField_a_of_type_Double + "&lon=" + this.jdField_b_of_type_Double + "&dev=0&style=0&poiname=" + str1;
      }
      else
      {
        localObject1 = localObject2;
        if (((String)localObject2).startsWith("geo:0,0")) {
          localObject1 = "geo:0,0?q=" + this.jdField_a_of_type_Double + "," + this.jdField_b_of_type_Double + "(" + str1 + ")";
        }
      }
    }
    label338:
    localObject2 = a();
    PackageManager localPackageManager = getPackageManager();
    boolean bool1 = a((List)localObject2, false);
    boolean bool2 = a(this.jdField_b_of_type_JavaUtilList, (List)localObject2);
    this.jdField_b_of_type_JavaUtilList = ((List)localObject2);
    Drawable localDrawable;
    Object localObject3;
    Object localObject4;
    label535:
    Object localObject5;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetSelectPicPopupWindow == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetSelectPicPopupWindow = new SelectPicPopupWindow(getApplicationContext(), null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSelectPicPopupWindow.a(getString(2131362609), 0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSelectPicPopupWindow.a(getString(2131362610), 0, this.jdField_b_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSelectPicPopupWindow.b(getString(2131362611), 0, this.jdField_b_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSelectPicPopupWindow.a(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSelectPicPopupWindow.setOnDismissListener(new bdn(this));
      if (!bool1)
      {
        localDrawable = super.getResources().getDrawable(2130838377);
        localObject3 = super.getString(2131362612);
        localObject4 = super.getString(2131362613);
        if (!new File(QQMapConstants.i).exists()) {
          break label844;
        }
        localObject1 = super.getString(2131362615);
        localObject5 = "sosogeo://?q=" + this.jdField_a_of_type_Double + "," + this.jdField_b_of_type_Double + "(" + str1 + ")";
        this.jdField_a_of_type_ComTencentMobileqqWidgetSelectPicPopupWindow.a(localDrawable, 1, (String)localObject3, (String)localObject4, 0, (String)localObject5, (String)localObject1);
        this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack = new bdo(this);
      }
      localObject3 = ((List)localObject2).iterator();
    }
    label1080:
    for (;;)
    {
      label629:
      if (!((Iterator)localObject3).hasNext()) {
        break label1082;
      }
      localObject5 = (ResolveInfo)((Iterator)localObject3).next();
      String str2 = ((ResolveInfo)localObject5).activityInfo.packageName;
      localDrawable = null;
      localObject1 = null;
      localObject4 = ((ResolveInfo)localObject5).activityInfo.applicationInfo.loadLabel(localPackageManager);
      if (str2.equals(QQMapConstants.d))
      {
        localObject2 = getString(2131362613);
        localObject1 = "sosogeo://?q=" + this.jdField_a_of_type_Double + "," + this.jdField_b_of_type_Double + "(" + str1 + ")";
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label1080;
        }
        localDrawable = FileCategoryUtil.b(getApplicationContext(), ((ResolveInfo)localObject5).activityInfo.applicationInfo.publicSourceDir);
        this.jdField_a_of_type_ComTencentMobileqqWidgetSelectPicPopupWindow.a(localDrawable, 0, localObject4.toString(), (String)localObject2, 1, (String)localObject1, null);
        break label629;
        if (bool2)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetSelectPicPopupWindow.showAtLocation(findViewById(2131298581), 17, 0, 0);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetSelectPicPopupWindow = new SelectPicPopupWindow(getApplicationContext(), null);
        break;
        label844:
        localObject1 = super.getString(2131362614);
        break label535;
        if (str2.equals(QQMapConstants.e))
        {
          localObject1 = "androidamap://viewMap?sourceApplication=tencentqq&lat=" + this.jdField_a_of_type_Double + "&lon=" + this.jdField_b_of_type_Double + "&dev=0&style=0&poiname=" + str1;
          localObject2 = localDrawable;
        }
        else if (str2.equals(QQMapConstants.f))
        {
          localObject1 = "geo:0,0?q=" + this.jdField_a_of_type_Double + "," + this.jdField_b_of_type_Double + "(" + str1 + ")";
          localObject2 = localDrawable;
        }
        else
        {
          localObject2 = localDrawable;
          if (str2.equals(QQMapConstants.g))
          {
            localObject1 = "bdapp://map/marker?location=" + this.jdField_a_of_type_Double + "," + this.jdField_b_of_type_Double + "&title=" + str1 + "&content=" + this.jdField_l_of_type_JavaLangString + "&src=tencent|qq&coord_type=gcj02";
            localObject2 = localDrawable;
          }
        }
      }
    }
    label1082:
    this.jdField_a_of_type_ComTencentMobileqqWidgetSelectPicPopupWindow.showAtLocation(findViewById(2131298581), 17, 0, 0);
  }
  
  public void l()
  {
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("url", this.jdField_m_of_type_JavaLangString);
    localIntent.putExtra("reqType", 4);
    super.startActivity(localIntent);
    e();
  }
  
  protected void m()
  {
    Object localObject = (TextView)findViewById(2131296901);
    ((TextView)localObject).setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    TextView localTextView = (TextView)findViewById(2131296895);
    if (this.jdField_h_of_type_Boolean)
    {
      ((TextView)localObject).setText(2131363166);
      ((TextView)localObject).setContentDescription(getString(2131363166));
      localTextView.setText(2131363166);
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296905));
      if (!this.jdField_h_of_type_Boolean) {
        break label216;
      }
      if (!this.jdField_k_of_type_Boolean) {
        break label162;
      }
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(2131363069);
      this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_e_of_type_AndroidViewView$OnClickListener);
    }
    for (;;)
    {
      this.jdField_f_of_type_AndroidWidgetTextView.setTag(this.jdField_f_of_type_AndroidWidgetTextView.getText());
      return;
      ((TextView)localObject).setText(2131363191);
      ((TextView)localObject).setContentDescription(getString(2131363191));
      localTextView.setText(2131363191);
      break;
      label162:
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      localObject = (ImageView)findViewById(2131296906);
      ((ImageView)localObject).setVisibility(0);
      ((ImageView)localObject).setImageResource(2130838044);
      ((ImageView)localObject).setContentDescription(getString(2131363193));
      ((ImageView)localObject).setOnClickListener(this.jdField_g_of_type_AndroidViewView$OnClickListener);
      continue;
      label216:
      this.jdField_f_of_type_AndroidWidgetTextView.setText(2131363069);
      this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
    }
  }
  
  public void n()
  {
    if (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() == 0)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
      this.jdField_c_of_type_AndroidWidgetImageView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
    }
  }
  
  public void o()
  {
    q();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      Intent localIntent = new Intent(this, ChatActivity.class);
      localIntent.putExtras(new Bundle(paramIntent.getExtras()));
      localIntent.setFlags(67108864);
      super.startActivity(localIntent);
      super.finish();
    }
  }
  
  public void onBackPressed()
  {
    super.setResult(-1, new Intent());
    try
    {
      c();
      super.onBackPressed();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      super.finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentThemeSkinnableActivityProcesser = new SkinnableActivityProcesser(this, this);
    setContentView(2130903579);
    this.jdField_n_of_type_JavaLangString = super.getIntent().getStringExtra("uin");
    sendBroadcast(new Intent("com.tencent.qqlite.addLbsObserver"));
    SOSOMapLBSApi.getInstance().verifyRegCode("QQ2013", "LWPAH-5CHEJ-Y6CR2-AQPLX-IV2JQ");
    b();
    m();
    f();
    if (this.jdField_h_of_type_Boolean) {
      a(this.jdField_a_of_type_Double, this.jdField_b_of_type_Double);
    }
    for (;;)
    {
      paramBundle = new IntentFilter();
      paramBundle.addAction("com.tencent.mobileqq.onGetStreetViewUrl");
      paramBundle.addAction("com.tencent.mobileqq.onGetLbsShareSearch");
      paramBundle.addAction("com.tencent.mobileqq.onGetLbsShareShop");
      paramBundle.addAction("com.tencent.mobileqq.onGetShareShopDetail");
      registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, paramBundle);
      paramBundle = new IntentFilter();
      paramBundle.addAction("android.intent.action.SCREEN_OFF");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
      return;
      q();
    }
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    Object localObject = null;
    switch (paramInt)
    {
    }
    Dialog localDialog;
    View localView;
    do
    {
      return localObject;
      return a(getString(2131363192));
      localDialog = a(2131363204, 2131363205, new bdf(this));
      localObject = localDialog.findViewById(2131296918);
      if (localObject != null) {
        ((View)localObject).setOnClickListener(new bdg(this, localDialog));
      }
      localView = localDialog.findViewById(2131296919);
      localObject = localDialog;
    } while (localView == null);
    localView.setOnClickListener(new bdi(this, localDialog));
    return localDialog;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentThemeSkinnableActivityProcesser != null) {
      this.jdField_a_of_type_ComTencentThemeSkinnableActivityProcesser.destory();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.destroy();
    }
    sendBroadcast(new Intent("com.tencent.mobileqq.removeLbsObserver"));
    sendBroadcast(new Intent("com.tencent.mobileqq.unregisterReceiver"));
    SOSOMapLBSApi.getInstance().removeLocationUpdate();
    super.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    super.unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
  }
  
  public void onPostThemeChanged() {}
  
  public void onPreThemeChanged() {}
  
  protected void onResume()
  {
    super.onResume();
    if (this.jdField_p_of_type_Boolean)
    {
      this.jdField_p_of_type_Boolean = false;
      List localList = a();
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetSelectPicPopupWindow != null) && (a(localList, true))) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetSelectPicPopupWindow.a(0);
      }
    }
    BaseActivity.mAppForground = GesturePWDUtils.getAppForground(this);
    if ((!BaseActivity.mAppForground) && (GesturePWDUtils.getGesturePWDState(this, this.jdField_n_of_type_JavaLangString) == 2) && (GesturePWDUtils.getGesturePWDMode(this, this.jdField_n_of_type_JavaLangString) == 21))
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqbaseactivity", 2, "qqmapactivity.start lock. GesturePWDUnlockActivity");
      }
      super.startActivity(new Intent(this, GesturePWDUnlockActivity.class));
    }
    for (this.jdField_m_of_type_Boolean = true;; this.jdField_m_of_type_Boolean = false)
    {
      if (!BaseActivity.mAppForground)
      {
        BaseActivity.mAppForground = true;
        GesturePWDUtils.setAppForground(this, BaseActivity.mAppForground);
      }
      this.jdField_n_of_type_Boolean = false;
      return;
    }
  }
  
  public void onStart()
  {
    super.onStart();
    ApplicationLifeController.getController().onActivityStart(this);
  }
  
  protected void onStop()
  {
    super.onStop();
    this.jdField_n_of_type_Boolean = true;
    ApplicationLifeController.getController().onActivityStop(this);
    BaseActivity.mAppForground = GesturePWDUtils.getAppForground(this);
    if (!BaseActivity.mAppForground) {
      GesturePWDUtils.setAppForground(this, BaseActivity.mAppForground);
    }
  }
  
  protected void onUserLeaveHint()
  {
    super.onUserLeaveHint();
    sendBroadcast(new Intent("com.tencent.mobileqq.showNotification"));
  }
  
  public void p()
  {
    DialogUtil.a(this, 230).setTitle(getString(2131363374)).setMessage(2131362785).setPositiveButton(getString(2131363109), new bde(this)).show();
  }
  
  public void q()
  {
    if (!NetworkUtil.e(this))
    {
      p();
      SOSOMapLBSApi.getInstance().requestLocationUpdate(this, this.jdField_a_of_type_Bdw);
    }
    do
    {
      return;
      super.showDialog(0);
      SOSOMapLBSApi.getInstance().requestLocationUpdate(this, this.jdField_a_of_type_Bdw);
    } while (!QLog.isColorLevel());
    QLog.d("get_location", 2, "start get lacation");
  }
  
  public void r()
  {
    this.jdField_i_of_type_Boolean = true;
    super.showDialog(1);
    if (!this.jdField_h_of_type_Boolean)
    {
      findViewById(2131298590).setVisibility(4);
      TextView localTextView = (TextView)findViewById(2131296905);
      localTextView.setVisibility(0);
      localTextView.setText(2131363354);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQMapActivity
 * JD-Core Version:    0.7.0.1
 */