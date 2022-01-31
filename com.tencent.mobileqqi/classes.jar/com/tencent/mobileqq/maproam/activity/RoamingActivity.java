package com.tencent.mobileqq.maproam.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.map.lbsapi.api.SOSOMapLBSApi;
import com.tencent.mobileqq.activity.PeopleAroundBaseActivity;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.maproam.ChangeViewSizeAnimation;
import com.tencent.mobileqq.maproam.Utils;
import com.tencent.mobileqq.maproam.widget.RoamLocalSearchBar;
import com.tencent.mobileqq.maproam.widget.RoamSearchDialog.OnRoamResultObserver;
import com.tencent.mobileqq.maproam.widget.RoamSearchDialog.OnSearchResultItemClick;
import com.tencent.mobileqq.maproam.widget.RoamingMapView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQMapView.QQMapViewObserver;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;
import com.tencent.tencentmap.mapsdk.map.MapController;
import com.tencent.widget.AdapterView;
import com.tencent.widget.XListView;
import com.tencent.widget.XListView.MotionEventInterceptor;
import gbk;
import gbm;
import gbn;
import gbp;
import gbq;
import gbr;
import gbs;
import gbt;
import gbu;
import gbv;
import gbw;
import gbx;
import gby;
import java.util.List;

public class RoamingActivity
  extends PeopleAroundBaseActivity
  implements Animation.AnimationListener, QQMapView.QQMapViewObserver, XListView.MotionEventInterceptor
{
  public static final String a = ".roam";
  static final int jdField_b_of_type_Int = 0;
  static final String jdField_b_of_type_JavaLangString = "http://imgcache.qq.com/club/mobile/roam/roam_guide.json";
  public static final int c = 400;
  static final int jdField_d_of_type_Int = 2;
  static final int jdField_e_of_type_Int = 1;
  public static final String e = "mode";
  public int C;
  public ViewGroup a;
  Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  public Button a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LBSObserver jdField_a_of_type_ComTencentMobileqqAppLBSObserver = new gbr(this);
  public RoamLocalSearchBar a;
  RoamSearchDialog.OnRoamResultObserver jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog$OnRoamResultObserver = new gbv(this);
  RoamSearchDialog.OnSearchResultItemClick jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog$OnSearchResultItemClick = new gbu(this);
  public RoamingMapView a;
  public GeoPoint a;
  public MapController a;
  gby jdField_a_of_type_Gby = new gby(this, 1, 1, 1, 8);
  public Boolean a;
  Runnable jdField_a_of_type_JavaLangRunnable = new gbk(this);
  public View b;
  Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  public TextView b;
  GeoPoint jdField_b_of_type_ComTencentTencentmapMapsdkMapGeoPoint;
  public ViewGroup c;
  public Animation c;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  ViewGroup jdField_d_of_type_AndroidViewViewGroup;
  public TextView d;
  private ViewGroup jdField_e_of_type_AndroidViewViewGroup;
  int f;
  public String f;
  public int g;
  public String g;
  
  static
  {
    if (!RoamingActivity.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_b_of_type_Boolean = bool;
      return;
    }
  }
  
  public RoamingActivity()
  {
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_f_of_type_Int = 2;
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
    this.jdField_g_of_type_JavaLangString = "";
  }
  
  private void a(double paramDouble1, double paramDouble2, String paramString)
  {
    GeoPoint localGeoPoint;
    if (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController != null)
    {
      localGeoPoint = new GeoPoint((int)(paramDouble1 * 1000000.0D), (int)(paramDouble2 * 1000000.0D));
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController.setCenter(localGeoPoint);
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint = localGeoPoint;
      if ((paramString != null) && (paramString.length() > 0))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
        this.jdField_b_of_type_AndroidWidgetTextView.startAnimation(this.jdField_c_of_type_AndroidViewAnimationAnimation);
        this.jdField_f_of_type_JavaLangString = paramString;
        this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamLocalSearchBar.a(this.jdField_f_of_type_JavaLangString);
      }
    }
    else
    {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    a(localGeoPoint, this.jdField_b_of_type_AndroidWidgetTextView, new gbm(this));
  }
  
  private void a(GeoPoint paramGeoPoint, TextView paramTextView, RoamingActivity.GetAddressTaskListener paramGetAddressTaskListener)
  {
    if (paramGeoPoint != null) {
      new gbx(paramGeoPoint, paramTextView, paramGetAddressTaskListener).execute(new Context[] { getApplicationContext() });
    }
  }
  
  private void k()
  {
    if ((getSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).getBoolean("roaming_usage_tips", true)) && (VipUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface)))
    {
      this.jdField_d_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_d_of_type_AndroidViewViewGroup.findViewById(2131233348).setOnClickListener(this);
    }
  }
  
  private void l()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.a() == 1)
    {
      localObject = new ChangeViewSizeAnimation(this.jdField_c_of_type_AndroidViewViewGroup, this.jdField_c_of_type_AndroidViewViewGroup.getWidth(), this.jdField_c_of_type_AndroidViewViewGroup.getWidth(), this.jdField_c_of_type_AndroidViewViewGroup.getHeight(), getResources().getDimensionPixelSize(2131427577));
      this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.setMapMode(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.m.setVisibility(8);
      this.p.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamLocalSearchBar.setVisibility(8);
      this.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      }
      g();
    }
    for (;;)
    {
      ((Animation)localObject).setDuration(300L);
      ((Animation)localObject).setAnimationListener(this);
      this.jdField_c_of_type_AndroidViewViewGroup.startAnimation((Animation)localObject);
      do
      {
        return;
        localObject = findViewById(16908290);
      } while (localObject == null);
      View localView = findViewById(2131231448);
      localObject = new ChangeViewSizeAnimation(this.jdField_c_of_type_AndroidViewViewGroup, this.jdField_c_of_type_AndroidViewViewGroup.getWidth(), this.jdField_c_of_type_AndroidViewViewGroup.getWidth(), this.jdField_c_of_type_AndroidViewViewGroup.getHeight(), ((View)localObject).getHeight() - localView.getHeight());
      this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.setMapMode(1);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.requestFocusFromTouch();
      this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
      this.p.setVisibility(8);
      this.m.setVisibility(0);
      if (VipUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface)) {
        this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamLocalSearchBar.setVisibility(0);
      }
      k();
      if ((this.jdField_a_of_type_JavaLangBoolean.booleanValue()) && (this.jdField_a_of_type_AndroidViewViewGroup != null)) {
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      }
      setTitle(2131562996);
    }
  }
  
  private void m()
  {
    DialogUtil.a(this, 230).setTitle(getString(2131562948)).setMessage(2131562452).setPositiveButton(getString(2131562540), new gbw(this)).show();
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i;
    if (this.jdField_f_of_type_Int == 2)
    {
      i = 102;
      this.z = i;
      super.a(paramAdapterView, paramView, paramInt, paramLong);
      if (this.jdField_f_of_type_Int != 2) {
        break label76;
      }
    }
    label76:
    for (paramAdapterView = "vip_maproam_randomRoamProfile";; paramAdapterView = "vip_maproam_superRoamProfile")
    {
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Svip", "", "Vip_maproam", paramAdapterView, 0, 0, "", "", "", "");
      return;
      i = 103;
      break;
    }
  }
  
  protected void a(String paramString1, List paramList, String paramString2)
  {
    super.a(paramString1 + ".roam", paramList, paramString2);
  }
  
  protected void a(boolean paramBoolean1, List paramList, boolean paramBoolean2, int paramInt)
  {
    if (1 == this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.a())
    {
      if (paramBoolean1)
      {
        if ((paramList == null) || (paramList.isEmpty())) {
          a(0, 2131562260);
        }
        l();
      }
    }
    else {
      return;
    }
    a(1, 2131562069);
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.a() == 1)
    {
      this.e.dispatchTouchEvent(paramMotionEvent);
      return true;
    }
    return false;
  }
  
  public boolean a(GeoPoint paramGeoPoint)
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint == null) {
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint = paramGeoPoint;
    }
    while (paramGeoPoint == null) {
      return false;
    }
    if ((Math.abs(paramGeoPoint.getLatitudeE6() - this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint.getLatitudeE6()) < 1) && (Math.abs(paramGeoPoint.getLongitudeE6() - this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint.getLongitudeE6()) < 1)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  protected boolean a(String paramString)
  {
    return super.a(paramString + ".roam");
  }
  
  protected View b()
  {
    this.v = 2;
    this.y = x;
    a(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    this.e = ((ViewGroup)getLayoutInflater().inflate(2130903671, null));
    if ((!jdField_b_of_type_Boolean) && (this.e == null)) {
      throw new AssertionError();
    }
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.e.findViewById(2131233350));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131233351));
    this.jdField_d_of_type_AndroidWidgetTextView.setText(2131562017);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131233352));
    Object localObject = this.jdField_a_of_type_AndroidWidgetButton;
    int i;
    if (VipUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      i = 2131562171;
      ((Button)localObject).setText(i);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.e.findViewById(2131233353));
      this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)this.e.findViewById(2131233345));
      this.jdField_d_of_type_AndroidViewViewGroup = ((ViewGroup)this.e.findViewById(2131233347));
      this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView = ((RoamingMapView)this.e.findViewById(2131233243));
      this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.setObserver(this);
      this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.setBuiltInZoomControls(false);
      i = getIntent().getIntExtra("mode", 0);
      this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.setMapMode(i);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.e.findViewById(2131233248));
      this.jdField_b_of_type_AndroidWidgetTextView.setClickable(true);
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130839175, 0);
      TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
      if (!VipUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface)) {
        break label632;
      }
      localObject = "查看此地附近的人";
      label320:
      localTextView.setContentDescription((CharSequence)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.e.findViewById(2131233246));
      localObject = BitmapManager.a(getResources(), 2130839673);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, ((Bitmap)localObject).getHeight());
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.e.findViewById(2131233247));
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130839675);
      this.jdField_c_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, ((Bitmap)localObject).getHeight());
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamLocalSearchBar = ((RoamLocalSearchBar)this.e.findViewById(2131233346));
      this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamLocalSearchBar.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog$OnRoamResultObserver, this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog$OnSearchResultItemClick);
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController = this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.getController();
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController.setZoom(this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.getMaxZoomLevel() - 1);
      if ((-2147483648 == this.r) || (-2147483648 == this.q) || (this.r == 0) || (this.q == 0)) {
        break label639;
      }
      localObject = new GeoPoint(this.q, this.r);
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController.setCenter((GeoPoint)localObject);
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint = ((GeoPoint)localObject);
      this.jdField_b_of_type_ComTencentTencentmapMapsdkMapGeoPoint = ((GeoPoint)localObject);
      a((GeoPoint)localObject, this.jdField_c_of_type_AndroidWidgetTextView, new gbp(this));
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewView = this.e.findViewById(2131233349);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.post(new gbq(this, i));
      return this.e;
      i = 2131562277;
      break;
      label632:
      localObject = "此项功能超级会员专享，是否开通超会";
      break label320;
      label639:
      SOSOMapLBSApi.getInstance().verifyRegCode("QQ2013", "LWPAH-5CHEJ-Y6CR2-AQPLX-IV2JQ");
      e();
    }
  }
  
  public void b(GeoPoint paramGeoPoint)
  {
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 400L);
  }
  
  protected View c()
  {
    TextView localTextView = new TextView(this);
    localTextView.setText(2131562260);
    localTextView.setTextColor(-7829368);
    localTextView.setTextSize(2, 19.0F);
    localTextView.setGravity(17);
    return localTextView;
  }
  
  protected String c()
  {
    return "filter_type_map_roam";
  }
  
  public void c(GeoPoint paramGeoPoint)
  {
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    if (bool)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.setMotionEventInterceptor(this);
      this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this, 2130968618);
      if ((!jdField_b_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewAnimationAnimation == null)) {
        throw new AssertionError();
      }
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setRepeatMode(2);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setRepeatCount(1);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
      this.jdField_b_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this, 2130968619);
      if ((!jdField_b_of_type_Boolean) && (this.jdField_b_of_type_AndroidViewAnimationAnimation == null)) {
        throw new AssertionError();
      }
      this.jdField_b_of_type_AndroidViewAnimationAnimation.setRepeatMode(2);
      this.jdField_b_of_type_AndroidViewAnimationAnimation.setRepeatCount(1);
      this.jdField_c_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this, 2130968644);
      if ((!jdField_b_of_type_Boolean) && (this.jdField_c_of_type_AndroidViewAnimationAnimation == null)) {
        throw new AssertionError();
      }
      this.jdField_c_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
      if (!VipUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface)) {
        break label178;
      }
      j();
    }
    label178:
    while (this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.a() != 1) {
      return bool;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    return bool;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.destroy();
      this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.onDestroy();
    }
    b(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    this.jdField_a_of_type_Gby = null;
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog$OnRoamResultObserver = null;
    Utils.a();
    SOSOMapLBSApi.getInstance().removeLocationUpdate();
  }
  
  void e()
  {
    if (!NetworkUtil.e(this))
    {
      m();
      return;
    }
    showDialog(0);
    SOSOMapLBSApi.getInstance().requestLocationUpdate(getApplicationContext(), this.jdField_a_of_type_Gby);
  }
  
  protected void f()
  {
    super.f();
    this.m = ((TextView)findViewById(2131231380));
    b(this.m);
    this.m.setText("收起");
    this.m.setVisibility(8);
    this.m.setOnClickListener(this);
  }
  
  public void i()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
    this.jdField_c_of_type_AndroidWidgetImageView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
  }
  
  void j()
  {
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(new gbn(this));
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.jdField_a_of_type_AndroidViewAnimationAnimation == paramAnimation) {
      if (this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.a() == 1) {
        this.jdField_b_of_type_AndroidWidgetTextView.startAnimation(this.jdField_c_of_type_AndroidViewAnimationAnimation);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (this.jdField_c_of_type_AndroidViewAnimationAnimation != paramAnimation) {
            break;
          }
        } while (this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.a() != 1);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        return;
        if (1 == this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.a())
        {
          this.jdField_a_of_type_JavaLangRunnable.run();
          return;
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.a() != 0);
      paramAnimation = this.jdField_b_of_type_ComTencentTencentmapMapsdkMapGeoPoint;
    } while (paramAnimation == null);
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController.animateTo(paramAnimation, new gbt(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    switch (paramView.getId())
    {
    default: 
    case 2131231380: 
    case 2131233349: 
    case 2131233248: 
      do
      {
        return;
        l();
        return;
        if (!VipUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface)) {
          break;
        }
        this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint = this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.getMapCenter();
        paramView = this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint;
      } while (paramView == null);
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Svip", "", "Vip_maproam", "vip_maproam_enjoeySuperRoam", 0, 0, "", "", "", "");
      this.jdField_f_of_type_Int = 1;
      this.q = paramView.getLatitudeE6();
      this.r = paramView.getLongitudeE6();
      this.jdField_b_of_type_ComTencentTencentmapMapsdkMapGeoPoint = paramView;
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_AndroidWidgetTextView.getText());
      this.v = 1;
      a(true, false);
      return;
      Utils.a(this, 2131562519, getResources().getString(2131563244), new gbs(this), null);
      return;
    case 2131233348: 
      this.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
      getSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).edit().putBoolean("roaming_usage_tips", false).commit();
      return;
    }
    if (VipUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      this.jdField_f_of_type_Int = 1;
      this.q = this.jdField_g_of_type_Int;
      this.r = this.C;
      paramView = new GeoPoint(this.q, this.r);
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint = paramView;
      this.jdField_b_of_type_ComTencentTencentmapMapsdkMapGeoPoint = paramView;
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_g_of_type_JavaLangString);
      this.v = 1;
      a(true, false);
      return;
    }
    VipUtils.b(this, 1, "mvip.gongneng.mobileqq.ditumanyou.numberandroid");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.maproam.activity.RoamingActivity
 * JD-Core Version:    0.7.0.1
 */