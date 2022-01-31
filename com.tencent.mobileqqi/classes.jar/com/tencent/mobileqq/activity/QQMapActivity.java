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
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
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
import android.widget.TextView;
import android.widget.Toast;
import com.qq.jce.wup.UniPacket;
import com.tencent.map.lbsapi.api.SOSOMapLBSApi;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.international.LocaleUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQMapView;
import com.tencent.mobileqq.widget.QQMapView.QQMapViewObserver;
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
import dcg;
import dcj;
import dck;
import dcl;
import dcn;
import dco;
import dcp;
import dcq;
import dcr;
import dcs;
import dct;
import dcu;
import dcw;
import dcx;
import dcy;
import dcz;
import dda;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
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
  protected static final String i = "com.tencent.process.exit";
  protected static final int l = 0;
  public double a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new dco(this);
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  public QQMapView a;
  GeoPoint jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint;
  public MapController a;
  SkinnableActivityProcesser jdField_a_of_type_ComTencentThemeSkinnableActivityProcesser;
  public ActionSheet a;
  dda jdField_a_of_type_Dda = new dda(this, 1, 1, 1, 8);
  public double b;
  float jdField_b_of_type_Float;
  private BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver = new dcp(this);
  protected View.OnClickListener b;
  Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  public ImageView b;
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
  public TextView f;
  protected TextView g;
  public View h;
  public boolean h;
  protected View i;
  public boolean i;
  public View j;
  public String j;
  public boolean j;
  protected View k;
  protected String k;
  boolean k;
  protected View l;
  public String l;
  public boolean l;
  public View m;
  public String m;
  public boolean m;
  public String n;
  public boolean n;
  public String o;
  public boolean o;
  public String p;
  public String q;
  
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
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new dcq(this);
    this.jdField_c_of_type_AndroidViewView$OnClickListener = new dcr(this);
    this.jdField_d_of_type_AndroidViewView$OnClickListener = new dcs(this);
    this.jdField_e_of_type_AndroidViewView$OnClickListener = new dct(this);
    this.jdField_f_of_type_AndroidViewView$OnClickListener = new dcu(this);
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
      if (this.jdField_j_of_type_AndroidViewView != null) {
        this.jdField_j_of_type_AndroidViewView.setVisibility(8);
      }
      if (this.jdField_d_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setClickable(false);
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(null);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (this.jdField_d_of_type_AndroidWidgetTextView == null);
        if ((this.jdField_j_of_type_AndroidViewView != null) && (!this.jdField_l_of_type_Boolean))
        {
          this.jdField_j_of_type_AndroidViewView.setVisibility(0);
          this.jdField_j_of_type_AndroidViewView.setOnClickListener(new dcg(this));
        }
      } while (this.jdField_d_of_type_AndroidWidgetTextView.getText().length() <= 0);
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
        a(localGeoPoint, this.jdField_d_of_type_AndroidWidgetTextView, false);
      }
    }
    else
    {
      return;
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_l_of_type_JavaLangString);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    a();
  }
  
  private void a(GeoPoint paramGeoPoint, TextView paramTextView, boolean paramBoolean)
  {
    this.jdField_j_of_type_JavaLangString = "";
    new dcz(this, paramGeoPoint, paramTextView).execute(new GeoPoint[] { paramGeoPoint });
    if (paramBoolean) {
      o();
    }
  }
  
  private boolean a(String paramString)
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
  
  private boolean a(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = new Intent("android.intent.action.VIEW", Uri.parse(paramString1));
    if ((!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString2))) {
      paramString1.setClassName(paramString3, paramString2);
    }
    try
    {
      a(this, paramString1);
      return true;
    }
    catch (ActivityNotFoundException paramString1) {}
    return false;
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
          break label466;
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
        this.p = localBundle.getString("summary");
        if (TextUtils.isEmpty(this.jdField_k_of_type_JavaLangString)) {
          this.jdField_k_of_type_JavaLangString = localBundle.getString("url");
        }
        if (TextUtils.isEmpty(this.jdField_l_of_type_JavaLangString)) {
          this.jdField_l_of_type_JavaLangString = localBundle.getString("loc");
        }
        this.q = localBundle.getString("dpid");
        if (this.jdField_h_of_type_Boolean) {
          sendBroadcast(new Intent("com.tencent.mobileqq.getStreetViewUrl").putExtra("latitude", this.jdField_a_of_type_Double).putExtra("longitude", this.jdField_b_of_type_Double));
        }
        this.jdField_b_of_type_Float = getResources().getDisplayMetrics().density;
        this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this, 2130968618);
        this.jdField_a_of_type_AndroidViewAnimationAnimation.setRepeatMode(2);
        this.jdField_a_of_type_AndroidViewAnimationAnimation.setRepeatCount(1);
        this.jdField_b_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this, 2130968619);
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
      label466:
      localObject4 = null;
      localObject2 = localObject3;
      localObject3 = localObject4;
    }
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
    findViewById(2131230947).setVisibility(8);
    this.jdField_m_of_type_AndroidViewView = findViewById(2131233242);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView = ((QQMapView)findViewById(2131233243));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131233248));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131233246));
    this.jdField_j_of_type_AndroidViewView = findViewById(2131233245);
    Object localObject = BitmapManager.a(getResources(), 2130839673);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
    this.jdField_b_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, ((Bitmap)localObject).getHeight());
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131233247));
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130839675);
    this.jdField_c_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, ((Bitmap)localObject).getHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.setLogoMarginLeft(-25);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.setLogoMarginBottom(-10);
    if (!this.jdField_h_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.setObserver(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.setBuiltInZoomControls(false);
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController = this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.getController();
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController.setZoom(16);
      g();
      k();
      i();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.setObserver(null);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_h_of_type_AndroidViewView = getLayoutInflater().inflate(2130903265, null);
    localObject = new MapView.LayoutParams(-2, -2, null, 81);
    ((MapView.LayoutParams)localObject).point = new GeoPoint((int)(this.jdField_a_of_type_Double * 1000000.0D), (int)(this.jdField_b_of_type_Double * 1000000.0D));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.addView(this.jdField_h_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_h_of_type_AndroidViewView.findViewById(2131231874));
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_h_of_type_AndroidViewView.findViewById(2131231875));
    this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_h_of_type_AndroidViewView.findViewById(2131231872));
    this.jdField_k_of_type_AndroidViewView = this.jdField_h_of_type_AndroidViewView.findViewById(2131231871);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_h_of_type_AndroidViewView.findViewById(2131231873));
    this.jdField_d_of_type_AndroidWidgetTextView.setText("");
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_l_of_type_AndroidViewView = this.jdField_h_of_type_AndroidViewView.findViewById(2131231876);
    if (!TextUtils.isEmpty(this.jdField_k_of_type_JavaLangString)) {
      this.jdField_l_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_l_of_type_AndroidViewView.setOnClickListener(this.jdField_e_of_type_AndroidViewView$OnClickListener);
      a();
      break;
      this.jdField_l_of_type_AndroidViewView.setVisibility(8);
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
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.setGoogleMapEnable(true);
      this.jdField_o_of_type_Boolean = true;
    }
  }
  
  private void i()
  {
    Object localObject = (ViewGroup)findViewById(2131231448);
    if (localObject != null) {
      IphoneTitleBarActivity.b((View)localObject);
    }
    localObject = findViewById(2131230941);
    if (localObject != null) {
      IphoneTitleBarActivity.b((View)localObject);
    }
    localObject = (TextView)findViewById(2131231456);
    if (localObject != null) {
      IphoneTitleBarActivity.b((View)localObject);
    }
  }
  
  private void j()
  {
    findViewById(2131230941).setBackgroundResource(2130837602);
    ((TextView)findViewById(2131231376)).setVisibility(8);
    TextView localTextView = (TextView)findViewById(2131231456);
    if (this.jdField_h_of_type_Boolean)
    {
      localTextView.setText(2131562304);
      return;
    }
    localTextView.setText(2131562307);
  }
  
  private void k()
  {
    ((ImageView)findViewById(2131233251)).setOnClickListener(new dcw(this));
    ((ImageView)findViewById(2131233252)).setOnClickListener(new dcx(this));
    ((ImageView)findViewById(2131233253)).setOnClickListener(new dcy(this));
  }
  
  public Dialog a(int paramInt1, int paramInt2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    return a(getResources().getString(paramInt1), getResources().getString(paramInt2), paramOnDismissListener);
  }
  
  public Dialog a(String paramString)
  {
    Dialog localDialog = new Dialog(this, 2131624405);
    localDialog.setContentView(2130903171);
    TextView localTextView = (TextView)localDialog.findViewById(2131231029);
    if (localTextView != null) {
      localTextView.setText(paramString);
    }
    return localDialog;
  }
  
  public Dialog a(String paramString1, String paramString2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    Dialog localDialog = new Dialog(this, 2131624405);
    localDialog.setContentView(2130903162);
    TextView localTextView = (TextView)localDialog.findViewById(2131231469);
    if (localTextView != null) {
      localTextView.setText(paramString1);
    }
    paramString1 = (TextView)localDialog.findViewById(2131231029);
    if (paramString1 != null) {
      paramString1.setText(paramString2);
    }
    paramString1 = (TextView)localDialog.findViewById(2131231472);
    if (paramString1 != null) {
      paramString1.setText(2131563132);
    }
    paramString1 = (TextView)localDialog.findViewById(2131231473);
    if (paramString1 != null) {
      paramString1.setText(2131561692);
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
    if ((TextUtils.isEmpty(this.jdField_o_of_type_JavaLangString)) || (this.jdField_o_of_type_JavaLangString.equals(getString(2131561545)))) {
      this.jdField_o_of_type_JavaLangString = getString(2131562308);
    }
    localBundle.putString("title", this.jdField_o_of_type_JavaLangString);
    localBundle.putString("summary", this.p);
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
  
  public void a(LBSShare.GetShopsByIdsResp paramGetShopsByIdsResp) {}
  
  public void a(LBSShare.LocationResp paramLocationResp, Bundle paramBundle) {}
  
  public void a(LBSShare.NearByShopsResp paramNearByShopsResp, Bundle paramBundle) {}
  
  public void a(GeoPoint paramGeoPoint) {}
  
  public void a(GeoPoint paramGeoPoint, String paramString)
  {
    Object localObject = new MapView.LayoutParams(-2, -2, null, 81);
    ((MapView.LayoutParams)localObject).point = paramGeoPoint;
    if (this.jdField_i_of_type_AndroidViewView == null)
    {
      this.jdField_i_of_type_AndroidViewView = getLayoutInflater().inflate(2130903265, null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.addView(this.jdField_i_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_i_of_type_AndroidViewView.findViewById(2131231873));
      this.jdField_e_of_type_AndroidWidgetTextView.setClickable(false);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_i_of_type_AndroidViewView.findViewById(2131231874).setVisibility(8);
      this.jdField_i_of_type_AndroidViewView.findViewById(2131231875).setVisibility(8);
      this.jdField_i_of_type_AndroidViewView.findViewById(2131231871).setVisibility(4);
      paramGeoPoint = (ImageView)this.jdField_i_of_type_AndroidViewView.findViewById(2131231878);
      paramGeoPoint.setImageResource(2130837719);
      paramGeoPoint.setBackgroundDrawable(null);
      paramGeoPoint = (ImageView)this.jdField_i_of_type_AndroidViewView.findViewById(2131231877);
      localObject = AnimationUtils.loadAnimation(this, 17432576);
      ((Animation)localObject).setDuration(800L);
      ((Animation)localObject).setRepeatCount(2);
      ((Animation)localObject).setRepeatCount(-1);
      paramGeoPoint.startAnimation((Animation)localObject);
    }
    for (;;)
    {
      if (this.jdField_e_of_type_AndroidWidgetTextView != null) {
        this.jdField_e_of_type_AndroidWidgetTextView.setText(paramString);
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.updateViewLayout(this.jdField_i_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
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
  
  public void b(GeoPoint paramGeoPoint)
  {
    if ((!this.jdField_h_of_type_Boolean) && (!a(paramGeoPoint)))
    {
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint = paramGeoPoint;
      a(paramGeoPoint, this.jdField_c_of_type_AndroidWidgetTextView, true);
      a(paramGeoPoint);
    }
  }
  
  public void c() {}
  
  public void c(GeoPoint paramGeoPoint)
  {
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  public void d() {}
  
  public void e() {}
  
  public void h()
  {
    this.jdField_i_of_type_Boolean = false;
    findViewById(2131233249).setVisibility(0);
    if (!this.jdField_h_of_type_Boolean)
    {
      TextView localTextView = (TextView)findViewById(2131231380);
      localTextView.setVisibility(0);
      localTextView.setText(localTextView.getTag().toString());
    }
  }
  
  public void l()
  {
    String str1 = "sosogeo://?q=" + this.jdField_a_of_type_Double + "," + this.jdField_b_of_type_Double + "(" + this.jdField_o_of_type_JavaLangString + ")";
    String str2 = "androidamap://viewMap?sourceApplication=tencentqq&lat=" + this.jdField_a_of_type_Double + "&lon=" + this.jdField_b_of_type_Double + "&dev=0&style=0&poiname=" + this.jdField_o_of_type_JavaLangString;
    String str3 = "geo:0,0?q=" + this.jdField_a_of_type_Double + "," + this.jdField_b_of_type_Double + "(" + this.jdField_o_of_type_JavaLangString + ")";
    String str4 = "bdapp://map/marker?location=" + this.jdField_a_of_type_Double + "," + this.jdField_b_of_type_Double + "&title=" + this.jdField_o_of_type_JavaLangString + "&content=" + this.jdField_l_of_type_JavaLangString + "&src=tencent|qq&coord_type=gcj02";
    int i1;
    if (!a(str1, null, null)) {
      if (!a(str4, null, null)) {
        if (!a(str2, null, null)) {
          if (!a(str3, "com.google.android.maps.MapsActivity", "com.google.android.apps.maps")) {
            if (!a("http://apis.map.qq.com/uri/v1/marker?marker=coord:" + this.jdField_a_of_type_Double + "," + this.jdField_b_of_type_Double + ";title:" + this.jdField_o_of_type_JavaLangString + ";addr:" + this.jdField_l_of_type_JavaLangString))
            {
              Toast.makeText(getApplicationContext(), 2131562942, 0).show();
              i1 = 0;
            }
          }
        }
      }
    }
    for (;;)
    {
      ReportController.a(null, "P_CliOper", "Pb_account_lifeservice", "", "rec_locate", "click_navig", 0, 0, String.valueOf(i1), "", "", "");
      return;
      i1 = 7;
      continue;
      i1 = 6;
      continue;
      i1 = 3;
      continue;
      i1 = 4;
      continue;
      i1 = 1;
    }
  }
  
  public void m()
  {
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("url", this.jdField_m_of_type_JavaLangString);
    localIntent.putExtra("reqType", 4);
    super.startActivity(localIntent);
    e();
  }
  
  public void n()
  {
    Object localObject = (TextView)findViewById(2131231456);
    ((TextView)localObject).setText(getIntent().getExtras().getString("leftViewText"));
    ((TextView)localObject).setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    localObject = (TextView)findViewById(2131231376);
    if (this.jdField_h_of_type_Boolean)
    {
      ((TextView)localObject).setText(2131562304);
      this.g = ((TextView)findViewById(2131231380));
      if (!this.jdField_h_of_type_Boolean) {
        break label201;
      }
      if (!this.jdField_k_of_type_Boolean) {
        break label147;
      }
      this.g.setVisibility(0);
      this.g.setText(2131562857);
      this.g.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
    }
    for (;;)
    {
      this.g.setTag(this.g.getText());
      j();
      return;
      ((TextView)localObject).setText(2131562307);
      break;
      label147:
      this.g.setVisibility(8);
      localObject = (ImageView)findViewById(2131231461);
      ((ImageView)localObject).setVisibility(0);
      ((ImageView)localObject).setImageResource(2130838011);
      ((ImageView)localObject).setContentDescription(getString(2131562926));
      ((ImageView)localObject).setOnClickListener(this.jdField_f_of_type_AndroidViewView$OnClickListener);
      continue;
      label201:
      this.g.setText(2131562857);
      this.g.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    }
  }
  
  public void o()
  {
    if (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() == 0)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
      this.jdField_c_of_type_AndroidWidgetImageView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
    }
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
    int i1 = LocaleUtil.b(getApplicationContext());
    LocaleUtil.a(getBaseContext(), i1);
    setContentView(2130903652);
    this.jdField_n_of_type_JavaLangString = super.getIntent().getStringExtra("uin");
    sendBroadcast(new Intent("com.tencent.mobileqq.addLbsObserver"));
    SOSOMapLBSApi.getInstance().verifyRegCode("QQ2013", "LWPAH-5CHEJ-Y6CR2-AQPLX-IV2JQ");
    b();
    n();
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
      r();
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
      return a(getString(2131562166));
      localDialog = a(2131562070, 2131562042, new dck(this));
      localObject = localDialog.findViewById(2131231472);
      if (localObject != null) {
        ((View)localObject).setOnClickListener(new dcl(this, localDialog));
      }
      localView = localDialog.findViewById(2131231473);
      localObject = localDialog;
    } while (localView == null);
    localView.setOnClickListener(new dcn(this, localDialog));
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
    sendBroadcast(new Intent("com.tencent.mobileqq.RemoveLbsObserver"));
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
    BaseActivity.q = GesturePWDUtils.getAppForground(this);
    if ((!BaseActivity.q) && (GesturePWDUtils.getGesturePWDState(this, this.jdField_n_of_type_JavaLangString) == 2) && (GesturePWDUtils.getGesturePWDMode(this, this.jdField_n_of_type_JavaLangString) == 21))
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqbaseactivity", 2, "qqmapactivity.start lock. GesturePWDUnlockActivity");
      }
      super.startActivity(new Intent(this, GesturePWDUnlockActivity.class));
    }
    for (this.jdField_m_of_type_Boolean = true;; this.jdField_m_of_type_Boolean = false)
    {
      if (!BaseActivity.q)
      {
        BaseActivity.q = true;
        GesturePWDUtils.setAppForground(this, BaseActivity.q);
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
    BaseActivity.q = GesturePWDUtils.getAppForground(this);
    if (!BaseActivity.q) {
      GesturePWDUtils.setAppForground(this, BaseActivity.q);
    }
  }
  
  protected void onUserLeaveHint()
  {
    super.onUserLeaveHint();
    sendBroadcast(new Intent("com.tencent.mobileqq.showNotification"));
  }
  
  public void p()
  {
    r();
  }
  
  public void q()
  {
    DialogUtil.a(this, 230).setTitle(getString(2131562948)).setMessage(2131562452).setPositiveButton(getString(2131562540), new dcj(this)).show();
  }
  
  public void r()
  {
    if (!NetworkUtil.e(this)) {
      q();
    }
    do
    {
      return;
      super.showDialog(0);
      SOSOMapLBSApi.getInstance().requestLocationUpdate(this, this.jdField_a_of_type_Dda);
    } while (!QLog.isColorLevel());
    QLog.d("get_location", 2, "start get lacation");
  }
  
  public void s()
  {
    this.jdField_i_of_type_Boolean = true;
    super.showDialog(1);
    if (!this.jdField_h_of_type_Boolean)
    {
      findViewById(2131233249).setVisibility(4);
      TextView localTextView = (TextView)findViewById(2131231380);
      localTextView.setVisibility(0);
      localTextView.setText(2131563132);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQMapActivity
 * JD-Core Version:    0.7.0.1
 */