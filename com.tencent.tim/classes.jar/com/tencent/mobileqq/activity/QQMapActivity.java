package com.tencent.mobileqq.activity;

import acfp;
import aczc;
import aczc.b;
import ahgq;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import anot;
import anqu;
import anqv;
import anrd;
import aqcw;
import aqha;
import aqiw;
import aqju;
import aqlx;
import ausj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.mini.out.activity.MapActivity;
import com.tencent.mobileqq.pluginsdk.PluginRuntime;
import com.tencent.mobileqq.startup.step.Step;
import com.tencent.mobileqq.startup.step.Step.a;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.a;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQMapView;
import com.tencent.mobileqq.widget.QQMapView.a;
import com.tencent.proto.lbsshare.LBSShare.GetShopsByIdsResp;
import com.tencent.proto.lbsshare.LBSShare.LocationResp;
import com.tencent.proto.lbsshare.LBSShare.NearByShopsResp;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.ROMUtil;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.UiSettings;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.Polyline;
import com.tencent.theme.SkinnableActivityProcesser;
import com.tencent.theme.SkinnableActivityProcesser.Callback;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.RejectedExecutionException;
import jqn;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import org.apache.http.client.HttpClient;
import org.json.JSONException;
import org.json.JSONObject;
import ujs;
import von;
import voo;
import vop;
import voq;
import vor;
import vos;
import vov;
import vow;
import vox;
import voy;
import vpa;
import vpb;
import vpc;
import vpd;

public class QQMapActivity
  extends MapActivity
  implements QQMapView.a, SkinnableActivityProcesser.Callback
{
  protected TextView EW;
  public TextView EX;
  protected TextView EY;
  public TextView EZ;
  public long GH;
  public Polyline a;
  public String aOV;
  public String aOW;
  public String aOX;
  public String aOY;
  public String aOZ;
  public boolean aZD;
  public boolean aZE;
  public boolean aZF;
  boolean aZG = false;
  protected boolean aZH;
  public boolean aZI = false;
  protected boolean aZJ;
  public boolean aZK;
  Animation ap;
  Animation aq;
  public TencentMap b;
  public int bJV;
  aczc.b c = new vpb(this, "QQMapActivity", true);
  protected View.OnClickListener dp = new vov(this);
  protected View.OnClickListener dq = new vow(this);
  protected View.OnClickListener dr;
  protected Button dr;
  protected View.OnClickListener ds = new voy(this);
  public Marker f;
  private Marker g;
  public LinearLayout gn;
  public boolean hasStoped = true;
  public GeoPoint k;
  public double latitude;
  public String location = "";
  public double longitude;
  public boolean mActNeedImmersive = true;
  public ausj mActionSheet;
  private BroadcastReceiver mBroadcastReceiver = new vor(this);
  float mDensity;
  public String mFrom;
  GeoPoint mLastPoint;
  public boolean mNeedStatusTrans = true;
  private BroadcastReceiver mScreenReceiver = new voq(this);
  public String mSelfPoiName;
  public String mStreetViewUrl;
  public SystemBarCompact mSystemBarComp;
  public QQMapView mapView;
  public ImageView pinView;
  SkinnableActivityProcesser processer;
  protected View tT;
  protected View tU;
  protected View tV;
  public View tW;
  protected View tX;
  public String uin;
  protected String url;
  
  public QQMapActivity()
  {
    this.jdField_dr_of_type_AndroidViewView$OnClickListener = new vox(this);
  }
  
  private void bTv()
  {
    super.showDialog(0);
    aczc.a(this.c);
    if (QLog.isColorLevel()) {
      QLog.d("get_location", 2, "start get location");
    }
  }
  
  public static boolean isLegalBroadcast(String paramString, ArrayList<String> paramArrayList)
  {
    if (Foreground.sCountActivity > 0) {}
    while ((paramString == null) || (paramString.length() == 0) || ((!paramString.equals(BaseApplicationImpl.getLocalVerify(paramArrayList, false))) && (!paramString.equals(BaseApplicationImpl.getLocalVerify(paramArrayList, true))))) {
      return false;
    }
    return true;
  }
  
  public Dialog a(int paramInt1, int paramInt2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    return aqcw.a(this, getResources().getString(paramInt1), getResources().getString(paramInt2), paramOnDismissListener);
  }
  
  public Dialog a(String paramString)
  {
    ReportDialog localReportDialog = new ReportDialog(this, 2131756467);
    localReportDialog.setContentView(2131559171);
    TextView localTextView = (TextView)localReportDialog.findViewById(2131365863);
    if (localTextView != null) {
      localTextView.setText(paramString);
    }
    return localReportDialog;
  }
  
  protected void a(GeoPoint paramGeoPoint, TextView paramTextView, boolean paramBoolean)
  {
    this.location = "";
    try
    {
      new a(paramGeoPoint, paramTextView).execute(new GeoPoint[] { paramGeoPoint });
      if (paramBoolean) {
        bTt();
      }
      return;
    }
    catch (RejectedExecutionException paramGeoPoint)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("QQMapActivity", 2, paramGeoPoint.getMessage());
    }
  }
  
  public void a(GeoPoint paramGeoPoint, String paramString)
  {
    do
    {
      try
      {
        paramString = new BitmapFactory.Options();
        paramString.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), 2130838782, paramString);
        if ((this.b != null) && (this.b.getProjection() != null))
        {
          paramGeoPoint = new LatLng(paramGeoPoint.getLatitudeE6() / 1000000.0D, paramGeoPoint.getLongitudeE6() / 1000000.0D);
          if (this.tU != null) {
            continue;
          }
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          try
          {
            this.tU = getLayoutInflater().inflate(2131559482, null);
            paramString = (ImageView)this.tU.findViewById(2131367146);
            paramString.setImageResource(2130838782);
            paramString.setBackgroundDrawable(null);
            this.g = this.b.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromView(this.tU)).position(paramGeoPoint).snippet(""));
            this.g.showInfoWindow();
            return;
          }
          catch (Resources.NotFoundException paramGeoPoint)
          {
            paramGeoPoint.printStackTrace();
            return;
          }
          paramString = paramString;
          paramString.printStackTrace();
        }
      }
    } while ((this.g == null) || ((paramGeoPoint.getLatitude() == this.g.getPosition().getLatitude()) && (paramGeoPoint.getLongitude() == this.g.getPosition().getLongitude())));
    this.g.setPosition(paramGeoPoint);
    this.g.setSnippet("");
    this.g.showInfoWindow();
  }
  
  public void a(LBSShare.GetShopsByIdsResp paramGetShopsByIdsResp) {}
  
  public void a(LBSShare.LocationResp paramLocationResp, Bundle paramBundle) {}
  
  public void a(LBSShare.NearByShopsResp paramNearByShopsResp, Bundle paramBundle) {}
  
  boolean a(GeoPoint paramGeoPoint)
  {
    if (this.mLastPoint == null) {
      this.mLastPoint = paramGeoPoint;
    }
    while ((paramGeoPoint == null) || (Math.abs(paramGeoPoint.getLatitudeE6() - this.mLastPoint.getLatitudeE6()) >= 1) || (Math.abs(paramGeoPoint.getLongitudeE6() - this.mLastPoint.getLongitudeE6()) >= 1)) {
      return false;
    }
    return true;
  }
  
  protected void aC()
  {
    Object localObject = (TextView)findViewById(2131369579);
    ((TextView)localObject).setContentDescription(acfp.m(2131711856));
    ((TextView)localObject).setOnClickListener(this.dp);
    localObject = (TextView)findViewById(2131369627);
    if ("group_activity".equals(this.mFrom))
    {
      ((TextView)localObject).setText(2131691503);
      this.EW = ((TextView)findViewById(2131369612));
      if (!this.aZD) {
        break label213;
      }
      if (!this.aZG) {
        break label159;
      }
      this.EW.setVisibility(0);
      this.EW.setText(2131697027);
      this.EW.setOnClickListener(this.jdField_dr_of_type_AndroidViewView$OnClickListener);
    }
    for (;;)
    {
      this.EW.setTag(this.EW.getText());
      return;
      if (this.aZD)
      {
        ((TextView)localObject).setText(2131721250);
        break;
      }
      ((TextView)localObject).setText(2131691502);
      break;
      label159:
      this.EW.setVisibility(8);
      localObject = (ImageView)findViewById(2131369594);
      ((ImageView)localObject).setVisibility(0);
      ((ImageView)localObject).setImageResource(2130840663);
      ((ImageView)localObject).setContentDescription(getString(2131695992));
      ((ImageView)localObject).setOnClickListener(this.ds);
    }
    label213:
    if ("group_activity".equals(this.mFrom)) {
      this.EW.setText(2131697021);
    }
    for (;;)
    {
      this.EW.setOnClickListener(this.dq);
      break;
      this.EW.setText(2131697027);
    }
  }
  
  protected void aym() {}
  
  public void ayn() {}
  
  protected void ayo() {}
  
  public void ayr()
  {
    this.aZE = false;
    if (!this.aZD)
    {
      TextView localTextView = (TextView)findViewById(2131369612);
      localTextView.setVisibility(0);
      localTextView.setText(localTextView.getTag().toString());
    }
  }
  
  public void ayu() {}
  
  public void bTo()
  {
    this.gn.getViewTreeObserver().addOnGlobalLayoutListener(new von(this));
  }
  
  public void bTp()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqmap", 2, "refreshStreetViewIcon: hideStreet=" + this.aZH + ", url=" + this.mStreetViewUrl);
    }
    if ((this.mStreetViewUrl == null) || (this.mStreetViewUrl.length() == 0)) {
      if (this.tV != null) {
        this.tV.setVisibility(8);
      }
    }
    while ((this.tV == null) || (this.aZH)) {
      return;
    }
    this.tV.setVisibility(0);
    this.tV.setOnClickListener(new vos(this));
  }
  
  public void bTq()
  {
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("url", this.mStreetViewUrl);
    localIntent.putExtra("reqType", 4);
    super.startActivity(localIntent);
    ayo();
  }
  
  protected void bTr()
  {
    String str = TimeZone.getDefault().getID();
    if (QLog.isColorLevel()) {
      QLog.d("QQMapActivity", 2, "default timezone:" + str);
    }
    if (((!"Asia/Shanghai".equals(str)) && (!"Asia/Hong_Kong".equals(str)) && (!"Asia/Chongqing".equals(str)) && (!"Asia/Beijing".equals(str))) || (!"zh".equals(Locale.getDefault().getLanguage())))
    {
      anot.a(null, "P_CliOper", "Pb_account_lifeservice", "", "rec_locate", "call_googlemap", 0, 0, "", "", "", "");
      this.aZJ = true;
    }
  }
  
  public void bTs()
  {
    Object localObject2 = jqn.a(this.aOW, 45, "UTF-8", "...");
    String str1 = jqn.a(this.aOV, 90, "UTF-8", "...");
    Object localObject3 = ujs.aLM + "http://maps.google.com/maps?q=" + this.latitude + "," + this.longitude + "&iwloc=A&hl=zh-CN (" + str1 + ")";
    if (!getResources().getString(2131698324).equals(localObject2)) {}
    for (Object localObject1 = getResources().getString(2131692313) + " " + (String)localObject2;; localObject1 = getResources().getString(2131692313))
    {
      String str2 = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.PoiMapActivity&type=sharedmap&lat=" + this.latitude + "&lon=" + this.longitude + "&title=" + (String)localObject2 + "&loc=" + str1;
      localObject1 = new AbsShareMsg.a(StructMsgForGeneralShare.class).c(32).a((String)localObject1).d((String)localObject3).a("plugin", "", str2, str2, str2).a();
      localObject3 = anrd.a(2);
      ((anqv)localObject3).aU("https://pub.idqqimg.com/pc/misc/lbsshare_icon.jpg", (String)localObject2, str1);
      ((AbsShareMsg)localObject1).addItem((anqu)localObject3);
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("forward_type", -3);
      ((Intent)localObject2).putExtra("stuctmsg_bytes", ((AbsShareMsg)localObject1).getBytes());
      ahgq.f(this, (Intent)localObject2, 0);
      return;
    }
  }
  
  void bTt()
  {
    if (this.pinView.getVisibility() == 0) {
      this.pinView.startAnimation(this.ap);
    }
  }
  
  public void bTu()
  {
    aqha.a(this, 230).setTitle(getString(2131696275)).setMessage(2131693404).setPositiveButton(getString(2131691042), new vpa(this)).show();
  }
  
  public void bTw()
  {
    this.aZE = true;
    if (!isFinishing()) {
      super.showDialog(1);
    }
    if (!this.aZD)
    {
      TextView localTextView = (TextView)findViewById(2131369612);
      localTextView.setVisibility(0);
      localTextView.setText(2131690895);
    }
  }
  
  public void bTx()
  {
    if (this.f == null) {}
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeResource(getResources(), 2130843229);
      if ((localBitmap != null) && (this.k != null))
      {
        this.f = this.b.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromBitmap(localBitmap)).position(new LatLng(this.k.getLatitudeE6() / 1000000.0D, this.k.getLongitudeE6() / 1000000.0D)).title("").snippet(""));
        this.f.showInfoWindow();
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("Q.qqmap", 2, "addSelfLay:", localOutOfMemoryError);
    }
  }
  
  protected void bcu()
  {
    Object localObject = (ViewGroup)findViewById(2131377361);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = findViewById(2131379769);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = (TextView)findViewById(2131369579);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
  }
  
  protected void c(double paramDouble1, double paramDouble2)
  {
    if (this.b != null)
    {
      GeoPoint localGeoPoint = new GeoPoint((int)(paramDouble1 * 1000000.0D), (int)(paramDouble2 * 1000000.0D));
      this.b.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(localGeoPoint.getLatitudeE6() / 1000000.0D, localGeoPoint.getLongitudeE6() / 1000000.0D)));
      if ((this.aOV == null) || (this.aOV.length() <= 0)) {
        a(localGeoPoint, this.EY, false);
      }
    }
    else
    {
      return;
    }
    this.EY.setText(this.aOV);
    bTp();
  }
  
  public void c(GeoPoint paramGeoPoint) {}
  
  protected void initData()
  {
    Object localObject5 = null;
    Object localObject4 = null;
    Bundle localBundle = getIntent().getExtras();
    String str = localBundle.getString("options");
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      try
      {
        Object localObject1 = new JSONObject(str);
        if (localObject1 == null) {
          break label536;
        }
        localObject5 = ((JSONObject)localObject1).optString("lat");
        str = ((JSONObject)localObject1).optString("lng");
        this.aOW = ((JSONObject)localObject1).optString("title");
        this.aOV = ((JSONObject)localObject1).optString("desc");
        if (((JSONObject)localObject1).has("from")) {
          localObject4 = ((JSONObject)localObject1).optString("from");
        }
        this.mFrom = ((String)localObject4);
        this.aZG = "share".equals(((JSONObject)localObject1).opt("action"));
        this.url = ("http://maps.google.com/maps?q=" + (String)localObject5 + "," + str + "&iwloc=A&hl=zh-CN (" + this.aOV + ")");
        localObject1 = str;
        localObject4 = localObject5;
        localObject5 = localObject4;
        if (TextUtils.isEmpty((CharSequence)localObject4)) {
          localObject5 = localBundle.getString("lat");
        }
        localObject4 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject4 = localBundle.getString("lon");
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject5)) && (!TextUtils.isEmpty((CharSequence)localObject4)))
        {
          this.aZD = true;
          this.latitude = Double.valueOf((String)localObject5).doubleValue();
          this.longitude = Double.valueOf((String)localObject4).doubleValue();
        }
        if (TextUtils.isEmpty(this.aOW)) {
          this.aOW = localBundle.getString("title");
        }
        this.aOX = localBundle.getString("summary");
        if (TextUtils.isEmpty(this.url)) {
          this.url = localBundle.getString("url");
        }
        if (TextUtils.isEmpty(this.aOV)) {
          this.aOV = localBundle.getString("loc");
        }
        if ((this.aOV != null) && (this.aOV.contains("+"))) {
          this.aOV = this.aOV.replace("+", " ");
        }
        this.aOY = localBundle.getString("dpid");
        this.mDensity = getResources().getDisplayMetrics().density;
        this.ap = AnimationUtils.loadAnimation(this, 2130772135);
        this.ap.setRepeatMode(2);
        this.ap.setRepeatCount(1);
        this.aq = AnimationUtils.loadAnimation(this, 2130772136);
        this.aq.setRepeatMode(2);
        this.aq.setRepeatCount(1);
        return;
      }
      catch (JSONException localJSONException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("get_params", 2, "parse params failed, options : " + str);
        }
        Object localObject2 = null;
        continue;
      }
      catch (NullPointerException localNullPointerException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("get_params", 2, "parse params failed, options : " + str);
        }
      }
      Object localObject3 = null;
      continue;
      label536:
      localObject4 = null;
      localObject3 = localObject5;
    }
  }
  
  protected void initMap()
  {
    findViewById(2131377783).setVisibility(8);
    this.tW = findViewById(2131374928);
    this.mapView = ((QQMapView)findViewById(2131371118));
    this.pinView = ((ImageView)findViewById(2131373342));
    this.tV = findViewById(2131369971);
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeResource(getResources(), 2130843232);
      if (localBitmap != null)
      {
        this.pinView.setImageBitmap(localBitmap);
        this.pinView.setPadding(0, 0, 0, localBitmap.getHeight());
      }
      this.mapView.setContentDescription(getString(2131697031));
      this.mapView.getMap().getUiSettings().setLogoPosition(0);
      this.mapView.getMap().getUiSettings().setScaleViewEnabled(false);
      this.mapView.getMap().getUiSettings().setGestureScaleByMapCenter(true);
      if (!this.aZD)
      {
        this.pinView.setVisibility(0);
        this.mapView.setObserver(this);
        this.b = this.mapView.getMap();
        this.b.moveCamera(CameraUpdateFactory.zoomTo(15.0F));
        bTr();
        bcu();
        return;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        Object localObject = null;
        continue;
        if (("SMARTISAN".equals(ROMUtil.getRomName())) && (Build.VERSION.SDK_INT >= 11)) {
          this.mapView.setLayerType(1, null);
        }
        this.mapView.setObserver(this);
        this.pinView.setVisibility(4);
        try
        {
          this.tT = getLayoutInflater().inflate(2131559482, null);
          this.mapView.getMap().addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromView(this.tT)).position(new LatLng(this.latitude, this.longitude)));
          bTp();
        }
        catch (Resources.NotFoundException localNotFoundException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQMapActivity", 2, localNotFoundException.getMessage());
          }
          super.finish();
        }
      }
    }
  }
  
  public Intent j()
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    if ((this.mapView != null) && (this.mapView.getMap() != null) && (this.mapView.getMap().getCameraPosition() != null) && (this.mapView.getMap().getCameraPosition().target != null))
    {
      LatLng localLatLng = this.mapView.getMap().getCameraPosition().target;
      localBundle.putString("latitude", String.valueOf(localLatLng.getLatitude()));
      localBundle.putString("longitude", String.valueOf(localLatLng.getLongitude()));
    }
    localBundle.putString("description", this.location);
    if ((TextUtils.isEmpty(this.aOW)) || (this.aOW.equals(getString(2131697026)))) {
      this.aOW = getString(2131695485);
    }
    if (TextUtils.isEmpty(this.aOX)) {
      this.aOX = "Unknown Address";
    }
    localBundle.putString("title", this.aOW);
    localBundle.putString("summary", this.aOX);
    localBundle.putString("dianping_id", this.aOY);
    localIntent.putExtras(localBundle);
    return localIntent;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {}
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    super.setResult(-1, new Intent());
    try
    {
      aym();
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
    this.processer = new SkinnableActivityProcesser(this, this);
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      getWindow().addFlags(67108864);
      if (!this.mActNeedImmersive) {}
    }
    try
    {
      int i = getResources().getColor(2131167361);
      if (this.mSystemBarComp == null)
      {
        this.mSystemBarComp = new SystemBarCompact(this, true, i);
        if (!ThemeUtil.isDefaultOrDIYTheme(false)) {
          break label411;
        }
        this.mSystemBarComp.setStatusDrawable(getResources().getDrawable(2130847060));
      }
      for (;;)
      {
        paramBundle = LayoutInflater.from(this).inflate(2131561790, null);
        if (ImmersiveUtils.isSupporImmersive() == 1)
        {
          paramBundle.setFitsSystemWindows(true);
          paramBundle.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
          ImmersiveUtils.clearCoverForStatus(getWindow(), true);
        }
        super.setContentView(paramBundle);
        this.uin = super.getIntent().getStringExtra("uin");
        sendBroadcast(new Intent("com.tencent.mobileqq.addLbsObserver"));
        this.tX = super.findViewById(2131377591);
        this.jdField_dr_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131377587));
        this.EX = ((TextView)super.findViewById(2131362251));
        this.EY = ((TextView)super.findViewById(2131365758));
        this.EZ = ((TextView)super.findViewById(2131365983));
        this.gn = ((LinearLayout)findViewById(2131380022));
        initData();
        aC();
        initMap();
        if (!this.aZD) {
          break;
        }
        c(this.latitude, this.longitude);
        xR(true);
        paramBundle = new IntentFilter();
        paramBundle.addAction("com.tencent.mobileqq.onGetStreetViewUrl");
        paramBundle.addAction("com.tencent.mobileqq.onGetLbsShareSearch");
        paramBundle.addAction("com.tencent.mobileqq.onGetLbsShareShop");
        paramBundle.addAction("com.tencent.mobileqq.onGetShareShopDetail");
        registerReceiver(this.mBroadcastReceiver, paramBundle);
        paramBundle = new IntentFilter();
        paramBundle.addAction("android.intent.action.SCREEN_OFF");
        registerReceiver(this.mScreenReceiver, paramBundle);
        if (this.aZD) {
          sendBroadcast(new Intent("com.tencent.mobileqq.getStreetViewUrl").putExtra("latitude", this.latitude).putExtra("longitude", this.longitude));
        }
        return;
        label411:
        this.mSystemBarComp.setStatusDrawable(null);
      }
    }
    catch (IllegalStateException paramBundle)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("QQMapActivity", 2, " getResources() has IllegalStateException e = " + paramBundle);
          continue;
          xR(true);
        }
      }
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
      return a(getString(2131694336));
      localDialog = a(2131693750, 2131693749, new vpc(this));
      localObject = localDialog.findViewById(2131365852);
      if (localObject != null) {
        ((View)localObject).setOnClickListener(new voo(this, localDialog));
      }
      localView = localDialog.findViewById(2131365858);
      localObject = localDialog;
    } while (localView == null);
    localView.setOnClickListener(new vop(this, localDialog));
    return localDialog;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.processer != null) {
      this.processer.destory();
    }
    if (this.mapView != null) {
      this.mapView.destroy();
    }
    if (yb())
    {
      sendBroadcast(new Intent("com.tencent.mobileqq.removeLbsObserver"));
      sendBroadcast(new Intent("com.tencent.mobileqq.unregisterReceiver"));
    }
    super.unregisterReceiver(this.mScreenReceiver);
    super.unregisterReceiver(this.mBroadcastReceiver);
  }
  
  public void onMapScrollEnd(GeoPoint paramGeoPoint)
  {
    if ((!this.aZD) && (!a(paramGeoPoint)))
    {
      this.mLastPoint = paramGeoPoint;
      c(paramGeoPoint);
    }
  }
  
  public void onMapScrollStart(GeoPoint paramGeoPoint) {}
  
  public void onPause()
  {
    super.onPause();
    if (this.mapView != null) {
      this.mapView.onPause();
    }
  }
  
  public void onPostThemeChanged() {}
  
  public void onPreThemeChanged() {}
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    if (paramInt == 1)
    {
      if (paramArrayOfInt[0] == 0) {
        xR(this.aZK);
      }
    }
    else {
      return;
    }
    aqha.a(this, paramArrayOfString, paramArrayOfInt);
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.mapView != null) {
      this.mapView.onResume();
    }
    if (this.mSystemBarComp != null) {
      this.mSystemBarComp.init();
    }
    BaseActivity.mAppForground = GesturePWDUtils.getAppForground(this);
    if ((!BaseActivity.mAppForground) && (GesturePWDUtils.getGesturePWDState(this, this.uin) == 2) && (GesturePWDUtils.getGesturePWDMode(this, this.uin) == 21))
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqbaseactivity", 2, "qqmapactivity.start lock. GesturePWDUnlockActivity");
      }
      super.startActivity(new Intent(this, GesturePWDUnlockActivity.class));
    }
    for (this.aZI = true;; this.aZI = false)
    {
      if (!BaseActivity.mAppForground)
      {
        BaseActivity.mAppForground = true;
        GesturePWDUtils.setAppForground(this, BaseActivity.mAppForground);
      }
      this.hasStoped = false;
      if (!this.aZK) {
        xR(false);
      }
      return;
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.mapView != null) {
      this.mapView.onStart();
    }
    Foreground.onStart(null, this);
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.mapView != null) {
      this.mapView.onStop();
    }
    this.hasStoped = true;
    Foreground.onStop(null);
    BaseActivity.mAppForground = GesturePWDUtils.getAppForground(this);
    aczc.b(this.c);
    if (!BaseActivity.mAppForground) {
      GesturePWDUtils.setAppForground(this, BaseActivity.mAppForground);
    }
  }
  
  public void onUserLeaveHint()
  {
    super.onUserLeaveHint();
    sendBroadcast(new Intent("com.tencent.mobileqq.showNotification"));
  }
  
  public void refresh()
  {
    xR(true);
  }
  
  protected void xR(boolean paramBoolean)
  {
    this.aZK = paramBoolean;
    if (!aqiw.isNetSupport(this))
    {
      bTu();
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)
      {
        requestPermissions(new String[] { "android.permission.ACCESS_FINE_LOCATION" }, 1);
        return;
      }
      bTv();
      return;
    }
    bTv();
  }
  
  protected boolean yb()
  {
    return true;
  }
  
  public static class MapRuntime
    extends PluginRuntime
    implements Thread.UncaughtExceptionHandler
  {
    protected Thread.UncaughtExceptionHandler a;
    private BroadcastReceiver mBroadcastReceiver = new vpd(this);
    
    public void onCreate(Bundle paramBundle)
    {
      this.a = Thread.getDefaultUncaughtExceptionHandler();
      Thread.setDefaultUncaughtExceptionHandler(this);
      super.onCreate(paramBundle);
      paramBundle = new IntentFilter();
      paramBundle.addAction("com.tencent.process.exit");
      paramBundle.addAction("mqq.intent.action.ACCOUNT_CHANGED");
      paramBundle.addAction("mqq.intent.action.LOGOUT");
      paramBundle.addAction("mqq.intent.action.EXIT_" + MobileQQ.getMobileQQ().getPackageName());
      MobileQQ.getContext().registerReceiver(this.mBroadcastReceiver, paramBundle);
      Step.a.b(12, BaseApplicationImpl.sDirector, null).step();
    }
    
    public void uncaughtException(Thread paramThread, Throwable paramThrowable)
    {
      PluginRuntime.handleCrash(paramThrowable, "QQMapActivity", MobileQQ.getContext());
      if (this.a != null) {
        this.a.uncaughtException(paramThread, paramThrowable);
      }
    }
  }
  
  public class a
    extends AsyncTask<GeoPoint, Void, String>
  {
    TextView Fa;
    protected HttpClient a;
    protected GeoPoint d;
    
    public a(GeoPoint paramGeoPoint, TextView paramTextView)
    {
      this.d = paramGeoPoint;
      this.Fa = paramTextView;
      this.Fa.setTag(this.d);
    }
    
    protected String a(GeoPoint... paramVarArgs)
    {
      int i = 0;
      if (i < 3)
      {
        if (isCancelled())
        {
          localObject = "";
          label17:
          return localObject;
        }
        paramVarArgs = aqlx.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQMapActivity.getApplicationContext(), this.d.getLatitudeE6() / 1000000.0D, this.d.getLongitudeE6() / 1000000.0D, 3, this.jdField_a_of_type_OrgApacheHttpClientHttpClient);
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder().append(i).append(" time: ReverseGeocode.getFromLocation, address: ");
          if (paramVarArgs != null) {
            break label125;
          }
        }
        label125:
        for (Object localObject = "";; localObject = paramVarArgs)
        {
          QLog.i("fetch_address", 2, (String)localObject);
          if (paramVarArgs != null)
          {
            localObject = paramVarArgs;
            if (paramVarArgs.length() > 0) {
              break label17;
            }
          }
          i += 1;
          break;
        }
      }
      return "";
    }
    
    protected void onPostExecute(String paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("fetch_address", 2, "get address finish, onPostExecute, result:" + paramString);
      }
      if (this.Fa != null)
      {
        GeoPoint localGeoPoint = (GeoPoint)this.Fa.getTag();
        if ((localGeoPoint.getLatitudeE6() == this.d.getLatitudeE6()) && (localGeoPoint.getLongitudeE6() == this.d.getLongitudeE6()) && (paramString != null) && (paramString.length() > 0))
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityQQMapActivity.aZD) {
            break label115;
          }
          this.Fa.setText(paramString);
          this.Fa.setVisibility(0);
        }
      }
      return;
      label115:
      this.jdField_a_of_type_ComTencentMobileqqActivityQQMapActivity.location = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQMapActivity
 * JD-Core Version:    0.7.0.1
 */