package com.tencent.mobileqq.activity;

import acbn;
import acfp;
import acig;
import acih;
import advr;
import ahpb;
import aiem;
import aien;
import ajra;
import ajrb;
import ajrj;
import ajrk;
import ajvd;
import ajve;
import akks;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anot;
import anov;
import anpo;
import anpo.a;
import aqcx;
import aqft;
import aqha;
import aqju;
import aqmj;
import aqyg;
import aran;
import ardm.q;
import auru;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.dating.DatingFilters;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.mobileqq.fragment.BaseFragment;
import com.tencent.mobileqq.fragment.CommonTabFragment;
import com.tencent.mobileqq.fragment.HotChatFragment;
import com.tencent.mobileqq.fragment.NearbyBaseFragment;
import com.tencent.mobileqq.fragment.NearbyHybridFragment;
import com.tencent.mobileqq.fragment.NearbyMsgFragment;
import com.tencent.mobileqq.fragment.NowLiveFragment;
import com.tencent.mobileqq.freshnews.feed.NearbyImgLoader;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyTitleBarActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.widget.NonSwipeableViewPager;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.a;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import vhu;
import vhv;
import vhw;
import vhy;
import via;
import vib;
import vic;
import vid;

public class NearbyActivity
  extends NearbyTitleBarActivity
  implements Handler.Callback, aran, ardm.q, TabBarView.a
{
  public static String aOq = "https://now.qq.com/qq/nearby/index.html?_wv=3&now_n_http=1&now_n_r=2&_proxy=1";
  public long Gp;
  public long Gq;
  public long Gr;
  public long Gs;
  public long Gt;
  public long Gu;
  public long Gv;
  public long Gw;
  public long Gx;
  public long Gy = 60000L;
  public acig a;
  protected acih a;
  ajrj jdField_a_of_type_Ajrj;
  protected ajve a;
  FragmentManager jdField_a_of_type_AndroidSupportV4AppFragmentManager;
  a jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity$a;
  NonSwipeableViewPager jdField_a_of_type_ComTencentMobileqqWidgetNonSwipeableViewPager;
  boolean aYI = false;
  public boolean aYJ;
  public TabBarView b;
  int bIA = 0;
  int bIB = -1;
  public int bIC = -1;
  public int bID = 1000;
  public int bIw = -1;
  public int bIx;
  public int bIy = 0;
  int bIz = -1;
  public Handler bN = new vid(this);
  RelativeLayout gR;
  public long mClickTime;
  int mFrom = -1;
  public Handler mHandler = new auru(Looper.getMainLooper(), this);
  public long mInitTime;
  boolean mIsInit = false;
  public long mOnCreateMilliTimeStamp;
  ViewPager.OnPageChangeListener mOnPageChangeListener = new via(this);
  public ArrayList<TabInfo> mg = new ArrayList();
  public long onCreateTime;
  ImageView qF;
  public List<View.OnClickListener> qU = new ArrayList();
  RedTouch s;
  public RedTouch t;
  
  public NearbyActivity()
  {
    this.jdField_a_of_type_Ajve = new vhv(this);
    this.jdField_a_of_type_Acih = new vhw(this);
  }
  
  public static RedTouch a(Context paramContext, TabBarView paramTabBarView, int paramInt1, int paramInt2)
  {
    paramInt1 = aqcx.px2dip(paramContext, paramContext.getResources().getDisplayMetrics().widthPixels / paramInt1);
    return new RedTouch(paramContext, paramTabBarView.U(paramInt2)).a(53).d(4).c(paramInt1 / 2 - 8 - 20).a();
  }
  
  public static void a(Context paramContext, TabBarView paramTabBarView, ArrayList<TabInfo> paramArrayList)
  {
    paramTabBarView.setEnableRepeatedClick(true);
    paramTabBarView.setTabTextSize(16);
    paramTabBarView.setSelectColor(Color.parseColor("#00aced"));
    paramTabBarView.setUnselectColor(Color.parseColor("#777777"));
    paramTabBarView.setUnderLineHeight(aqcx.dip2px(paramContext, 3.0F));
    paramTabBarView.setTabHeight(aqcx.dip2px(paramContext, 45.0F));
    int i = paramArrayList.size();
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -1);
    localLayoutParams.gravity = 17;
    localLayoutParams.width = (paramContext.getResources().getDisplayMetrics().widthPixels / i);
    paramTabBarView.setTabLayoutParams(localLayoutParams);
    i = 0;
    while (i < paramArrayList.size())
    {
      paramTabBarView.a(((TabInfo)paramArrayList.get(i)).tabName);
      i += 1;
    }
  }
  
  public static void a(RedTouch paramRedTouch, int paramInt)
  {
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = null;
    if (paramInt == 0) {}
    for (;;)
    {
      paramRedTouch.c(localRedTypeInfo);
      return;
      if (paramInt == -1)
      {
        localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
        localRedTypeInfo.red_type.set(0);
        localRedTypeInfo.red_content.set("");
      }
      else
      {
        Object localObject = String.valueOf(paramInt);
        if (paramInt > 99) {
          localObject = "99+";
        }
        localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
        localRedTypeInfo.red_type.set(4);
        localRedTypeInfo.red_content.set((String)localObject);
        try
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("cn", "#ff0000");
          localRedTypeInfo.red_desc.set(((JSONObject)localObject).toString());
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  private void bRO()
  {
    aqju localaqju = aqha.b(this, 0, null, "地理位置信息已清除", null, "确定", new vhy(this), null);
    localaqju.setCancelable(false);
    localaqju.show();
  }
  
  public static int o(ArrayList<TabInfo> paramArrayList)
  {
    paramArrayList.clear();
    Object localObject = (String)ajrb.c(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "key_tabs_array", "");
    if (QLog.isColorLevel()) {
      QLog.d("nearby.NearbyActivity", 2, "initTabs:" + (String)localObject);
    }
    int i = -1;
    int k;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      k = i;
    }
    for (;;)
    {
      int m;
      int j;
      try
      {
        localObject = new JSONArray((String)localObject);
        m = 0;
        j = 0;
        k = i;
        if (m < ((JSONArray)localObject).length())
        {
          k = i;
          JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(m);
          k = i;
          TabInfo localTabInfo = new TabInfo();
          k = i;
          localTabInfo.tabName = localJSONObject.optString("tabName");
          k = i;
          localTabInfo.tabIndex = localJSONObject.optInt("tabIndex");
          k = i;
          localTabInfo.reportId = localJSONObject.optInt("reportId");
          k = i;
          localTabInfo.tabUrl = localJSONObject.optString("tabUrl");
          k = i;
          localTabInfo.tabType = localJSONObject.optInt("tabType");
          k = i;
          localTabInfo.disableScroll = localJSONObject.optInt("disableScroll");
          k = i;
          localTabInfo.needLoc = localJSONObject.optInt("needLoc");
          k = i;
          localTabInfo.autoEnter = localJSONObject.optInt("AutoEnter");
          k = i;
          if (TextUtils.isEmpty(localTabInfo.tabName)) {
            break label536;
          }
          k = i;
          if (localTabInfo.tabName.length() > 4) {
            break label536;
          }
          k = i;
          if (localTabInfo.tabType == 1) {
            break label553;
          }
          k = i;
          paramArrayList.add(localTabInfo);
          k = i;
          if (localTabInfo.tabType != 6) {
            break label533;
          }
          k = i;
          i = localTabInfo.tabIndex;
          break label544;
        }
        k = i;
        m = paramArrayList.size();
        if (m == 0) {
          continue;
        }
        if (j == 0) {}
      }
      catch (Exception localException1)
      {
        m = 1;
        i = k;
        j = m;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("nearby.NearbyActivity", 2, "initTabs exception:", localException1);
        i = k;
        j = m;
        continue;
        j = 1;
        continue;
      }
      try
      {
        if (!QLog.isColorLevel()) {
          break label558;
        }
        QLog.w("nearby.NearbyActivity", 2, "initTabs, isOldConfig=true, reset tabindex");
      }
      catch (Exception localException2)
      {
        m = 0;
        k = i;
        continue;
      }
      if (j < paramArrayList.size())
      {
        ((TabInfo)paramArrayList.get(j)).tabIndex = j;
        j += 1;
      }
      else
      {
        j = 0;
        if (j != 0)
        {
          localObject = new TabInfo();
          ((TabInfo)localObject).tabName = acfp.m(2131708649);
          ((TabInfo)localObject).tabIndex = 0;
          ((TabInfo)localObject).tabUrl = "https://nearby.qq.com/nearby-index/index.html?_wv=1031&_proxy=1&_wwv=128";
          ((TabInfo)localObject).tabType = 5;
          paramArrayList.add(localObject);
          localObject = new TabInfo();
          ((TabInfo)localObject).tabName = acfp.m(2131708650);
          ((TabInfo)localObject).tabIndex = 1;
          ((TabInfo)localObject).tabUrl = "";
          ((TabInfo)localObject).tabType = 2;
          paramArrayList.add(localObject);
        }
        Collections.sort(paramArrayList);
        return i;
        label533:
        break label544;
        label536:
        continue;
        j = 1;
        continue;
        label544:
        m += 1;
        continue;
        label553:
        j = 1;
        continue;
        label558:
        j = 0;
      }
    }
  }
  
  @NonNull
  private Intent r()
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(new Bundle());
    setIntent(localIntent);
    return localIntent;
  }
  
  public boolean Qj()
  {
    String str = Build.MANUFACTURER + "_" + Build.MODEL;
    return (Build.VERSION.SDK_INT > 10) && (!"Meizu_M040".equals(str));
  }
  
  public aqyg a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity$a != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity$a.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment != null) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity$a.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment.a;
      }
    }
    return localObject1;
  }
  
  public HotChatFragment a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity$a.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment;
  }
  
  public NearbyBaseFragment a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt < this.mg.size())
      {
        localObject1 = (TabInfo)this.mg.get(paramInt);
        localObject1 = (NearbyBaseFragment)this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.findFragmentByTag(((TabInfo)localObject1).getTabTag());
      }
    }
    return localObject1;
  }
  
  public NearbyHybridFragment a()
  {
    NearbyHybridFragment localNearbyHybridFragment = this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity$a.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment;
    int i;
    if ((localNearbyHybridFragment == null) && (this.mg != null) && (this.mg.size() > 0))
    {
      i = 0;
      if (i < this.mg.size())
      {
        Object localObject = (TabInfo)this.mg.get(i);
        localObject = (NearbyBaseFragment)this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.findFragmentByTag(((TabInfo)localObject).getTabTag());
        if (QLog.isColorLevel()) {
          QLog.d("nearby.NearbyActivity", 2, "getNearbyHybridFragment is null, search:" + i + ", " + localObject);
        }
        if ((localObject instanceof NearbyHybridFragment))
        {
          localNearbyHybridFragment = (NearbyHybridFragment)localObject;
          this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity$a.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment = localNearbyHybridFragment;
        }
      }
    }
    for (;;)
    {
      if ((QLog.isColorLevel()) && (localNearbyHybridFragment == null)) {
        QLog.d("nearby.NearbyActivity", 2, "getNearbyHybridFragment is null");
      }
      return localNearbyHybridFragment;
      i += 1;
      break;
    }
  }
  
  public NowLiveFragment a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity$a.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment;
  }
  
  public void a(ahpb paramahpb)
  {
    if (paramahpb == null) {}
    Object localObject;
    do
    {
      return;
      localObject = a(NearbyBaseFragment.dan);
      if (QLog.isColorLevel()) {
        ajrk.m("nearby.NearbyActivity", new Object[] { "updateTitlebar", localObject, paramahpb.a });
      }
    } while (localObject != paramahpb.a);
    if (paramahpb.chN)
    {
      if (this.centerView.getVisibility() != 0) {
        this.centerView.setVisibility(0);
      }
      if (this.gR.getVisibility() != 8) {
        this.gR.setVisibility(8);
      }
      if (!aqft.equalsWithNullCheck(paramahpb.strTitle, getTextTitle())) {
        setTitle(paramahpb.strTitle);
      }
      if (!paramahpb.showProgress) {
        break label412;
      }
      if (!isTitleProgressShowing()) {
        startTitleProgress();
      }
    }
    for (;;)
    {
      if (!paramahpb.chO) {
        break label427;
      }
      if (this.qF.getVisibility() != 0) {
        this.qF.setVisibility(0);
      }
      this.qF.setOnClickListener(paramahpb.fk);
      if ((AppSetting.enableTalkBack) && (paramahpb.bLj != null)) {
        this.qF.setContentDescription(paramahpb.bLj);
      }
      if (paramahpb.daq > 0) {
        this.qF.setImageResource(paramahpb.daq);
      }
      if (this.rightViewText.getVisibility() != 8) {
        this.rightViewText.setVisibility(8);
      }
      this.centerView.setClickable(true);
      this.centerView.setOnClickListener(new vib(this));
      return;
      if (this.centerView.getVisibility() != 4) {
        this.centerView.setVisibility(4);
      }
      if (!aqft.equalsWithNullCheck(paramahpb.strTitle, getTextTitle())) {
        setTitle(paramahpb.strTitle);
      }
      if (this.gR.getVisibility() != 0) {
        this.gR.setVisibility(0);
      }
      if (paramahpb.bLg != null)
      {
        localObject = (TextView)this.gR.findViewById(2131379865);
        if (!aqft.equalsWithNullCheck(paramahpb.bLg, ((TextView)localObject).getText())) {
          ((TextView)localObject).setText(paramahpb.bLg);
        }
      }
      if (paramahpb.bLh == null) {
        break;
      }
      localObject = (TextView)this.gR.findViewById(2131379802);
      if (aqft.equalsWithNullCheck(paramahpb.bLh, ((TextView)localObject).getText())) {
        break;
      }
      ((TextView)localObject).setText(paramahpb.bLh);
      break;
      label412:
      if (isTitleProgressShowing()) {
        stopTitleProgress();
      }
    }
    label427:
    if (this.qF.getVisibility() != 8) {
      this.qF.setVisibility(8);
    }
    if (TextUtils.isEmpty(paramahpb.bLi)) {
      if (this.rightViewText.getVisibility() != 8) {
        this.rightViewText.setVisibility(8);
      }
    }
    for (;;)
    {
      if (!aqft.equalsWithNullCheck(paramahpb.bLi, this.rightViewText.getText())) {
        this.rightViewText.setText(paramahpb.bLi);
      }
      this.rightViewText.setOnClickListener(paramahpb.fk);
      break;
      if (this.rightViewText.getVisibility() != 0) {
        this.rightViewText.setVisibility(0);
      }
    }
  }
  
  public void bRK()
  {
    this.jdField_a_of_type_Acig.bRK();
  }
  
  public void bRL()
  {
    SosoInterface.SosoLbsInfo localSosoLbsInfo = SosoInterface.c();
    if (localSosoLbsInfo == null)
    {
      SosoInterface.a(new vic(this, "NearbyProtocolCoder.Encounter"));
      return;
    }
    this.aYJ = false;
    this.jdField_a_of_type_Acig.c(1, localSosoLbsInfo);
  }
  
  public void bRM()
  {
    this.jdField_a_of_type_Acig.c(2, null);
    this.aYJ = true;
  }
  
  public void bRN()
  {
    this.jdField_a_of_type_Acig.c(3, null);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("nearby.NearbyActivity", 2, "NearbyActivity->doOnActivityResult, reqCode=" + paramInt1);
    }
    if (paramInt1 == 10002)
    {
      paramIntent = new Intent(this, QQBrowserActivity.class);
      paramIntent.putExtra("url", "https://nearby.qq.com/nearby-index/my_msg.html?_wv=1031&_bid=3027");
      startActivity(paramIntent);
      overridePendingTransition(2130772000, 2130772001);
    }
    Object localObject;
    HashMap localHashMap;
    do
    {
      do
      {
        return;
        if ((paramInt1 == 1000) || (paramInt1 == 1001)) {
          akks.c(this, paramInt1, paramInt2, paramIntent);
        }
        if (paramInt1 != 10001) {
          break;
        }
      } while (paramInt2 != -1);
      paramInt1 = paramIntent.getIntExtra("curIndex", -1);
      paramInt2 = paramIntent.getIntExtra("unReadMsgNum", 0);
      boolean bool = paramIntent.getBooleanExtra("isNeedFinish", false);
      if (QLog.isColorLevel()) {
        QLog.d("nearby.msgbox.tab", 2, "index=" + paramInt1 + ", unReadMsgNum=" + paramInt2 + ", isNeedFinish=" + bool);
      }
      if (bool) {
        super.finish();
      }
      for (;;)
      {
        this.bIB = paramInt2;
        a(this.s, paramInt2);
        return;
        if ((paramInt1 >= 0) && (paramInt1 < this.mg.size())) {
          this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(paramInt1, false);
        }
      }
      localObject = a(this.bIw);
      if (!(localObject instanceof CommonTabFragment)) {
        break;
      }
      localObject = (CommonTabFragment)localObject;
      localHashMap = new HashMap();
      localHashMap.put("requestCode", Integer.valueOf(paramInt1));
      localHashMap.put("resultCode", Integer.valueOf(paramInt2));
      localHashMap.put("data", paramIntent);
    } while (((CommonTabFragment)localObject).a(8589934600L, localHashMap, paramInt2, paramInt1, paramIntent));
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    long l = System.currentTimeMillis();
    this.bIx = o(this.mg);
    boolean bool = super.doOnCreate(paramBundle);
    if (getIntent().getBooleanExtra("key_from_location", false))
    {
      finish();
      return true;
    }
    try
    {
      anot.a(null, "dc00899", "grp_lbs", "", "entry", "open_nearby_act_total_tmp", 0, 0, Build.MODEL, Build.VERSION.SDK, "", "");
      label75:
      if (this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface == null)
      {
        finish();
        QLog.e("nearby.NearbyActivity", 1, "doOnCreate app==null, goto finish");
        return false;
      }
      this.jdField_a_of_type_Acig = ((acig)this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getBusinessHandler(3));
      Object localObject1 = getIntent();
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null) {
        paramBundle = r();
      }
      paramBundle.setExtrasClassLoader(DatingFilters.class.getClassLoader());
      if (TextUtils.isEmpty(paramBundle.getStringExtra("big_brother_source_key"))) {
        paramBundle.putExtra("big_brother_source_key", "biz_src_hdsp_nearby");
      }
      localObject1 = null;
      if (paramBundle == null) {
        localObject1 = null;
      }
      for (;;)
      {
        Object localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = aqmj.V(this, this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin());
        }
        if (aqft.equalsWithNullCheck(localObject2, aqmj.V(this, this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin()))) {
          break;
        }
        this.mFrom = 1;
        paramBundle = new Intent(this, QQBrowserActivity.class);
        paramBundle.putExtra("url", URLUtil.guessUrl((String)localObject2));
        startActivity(paramBundle);
        finish();
        return bool;
        try
        {
          localObject2 = paramBundle.getStringExtra("url");
          localObject1 = localObject2;
        }
        catch (Throwable paramBundle)
        {
          if (QLog.isColorLevel()) {
            QLog.i("nearby.NearbyActivity", 2, paramBundle.getMessage(), paramBundle);
          }
          paramBundle = r();
        }
      }
      if (this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.bTJ < this.mg.size()) {}
      for (int i = ((TabInfo)this.mg.get(this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.bTJ)).tabType;; i = 5)
      {
        i = paramBundle.getIntExtra("TAB_TYPE", i);
        if (i == 3)
        {
          this.mClickTime = paramBundle.getLongExtra("ENTER_TIME", l);
          this.mOnCreateMilliTimeStamp = l;
          if (QLog.isDevelopLevel()) {
            ajrk.f("WebSpeedTrace", "mClickTime", new Object[] { "doOnCreate", Long.valueOf(this.mClickTime) });
          }
        }
        if (i == 2)
        {
          this.Gp = paramBundle.getLongExtra("ENTER_TIME", l);
          this.Gq = l;
          if (QLog.isDevelopLevel()) {
            ajrk.f("WebSpeedTrace", "mClickTime", new Object[] { "doOnCreate", Long.valueOf(this.mClickTime) });
          }
        }
        this.jdField_a_of_type_Ajrj = new ajrj(this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface, "grp_lbs", "basic", "visit_time");
        this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.addObserver(this.jdField_a_of_type_Acih);
        this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(this.jdField_a_of_type_Ajve);
        bRK();
        if ((Build.VERSION.SDK_INT >= 23) && (checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)) {
          requestPermissions(new vhu(this), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
        }
        return bool;
      }
    }
    catch (Exception paramBundle)
    {
      break label75;
    }
  }
  
  public void doOnDestroy()
  {
    try
    {
      super.doOnDestroy();
      if (this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface == null) {
        return;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          localException1.printStackTrace();
        }
      }
      Object localObject = (ajra)this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(219);
      if (localObject != null)
      {
        ((ajra)localObject).report();
        ((ajra)localObject).cpR = true;
      }
      localObject = anpo.a(getClass(), hashCode());
      if (localObject != null)
      {
        long l1 = SystemClock.elapsedRealtime();
        long l2 = ((anpo.a)localObject).startTime;
        this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a("CliOper", "", "", ((anpo.a)localObject).cgi, ((anpo.a)localObject).cgi, ((anpo.a)localObject).arg1, 0, Long.toString(l1 - l2), "", "", "");
      }
    }
    try
    {
      int i = getIntent().getIntExtra("FROM_WHERE", -1);
      if (i != 0) {}
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        localException2.printStackTrace();
      }
    }
    NearbyImgLoader.a().release();
    if (this.jdField_a_of_type_Ajrj != null) {
      this.jdField_a_of_type_Ajrj.stop();
    }
    this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.b(this.jdField_a_of_type_Ajve);
    this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.removeObserver(this.jdField_a_of_type_Acih);
    bRM();
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    initTitle();
    if (paramIntent.getBooleanExtra("key_from_location", false))
    {
      bRO();
      return;
    }
    int i = this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.bTJ;
    if (i >= 0)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(i, false);
      if (QLog.isColorLevel()) {
        QLog.i("nearby.NearbyActivity", 2, "doOnNewIntent setSelectedTab:" + i);
      }
    }
    akks.c(this, 1000, -1, paramIntent);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.cpI) {}
    for (this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.bTJ = this.bIw;; this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.bTJ = 0)
    {
      if (QLog.isDevelopLevel()) {
        ajrk.f("Q.nearby", "doOnPause", new Object[] { Boolean.valueOf(this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.cpI), Integer.valueOf(this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.bTJ) });
      }
      ((advr)this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(180)).cUH();
      NearbyBaseFragment localNearbyBaseFragment = a(this.jdField_a_of_type_ComTencentMobileqqWidgetNonSwipeableViewPager.getCurrentItem());
      if ((localNearbyBaseFragment instanceof NearbyHybridFragment))
      {
        ((NearbyHybridFragment)localNearbyBaseFragment).doW();
        ((NearbyHybridFragment)localNearbyBaseFragment).dpf();
      }
      return;
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_Ajrj.start();
    NearbyBaseFragment localNearbyBaseFragment = a(this.jdField_a_of_type_ComTencentMobileqqWidgetNonSwipeableViewPager.getCurrentItem());
    if ((localNearbyBaseFragment instanceof NearbyHybridFragment)) {
      ((NearbyHybridFragment)localNearbyBaseFragment).doV();
    }
    if ((this.t != null) && (aiem.a.redDotNum <= 0)) {
      a(this.t, 0);
    }
  }
  
  public void doOnSaveInstanceState(Bundle paramBundle)
  {
    super.doOnSaveInstanceState(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("nearby.NearbyActivity", 2, "doOnSaveInstanceState");
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.mIsInit))
    {
      this.mIsInit = true;
      this.mHandler.sendEmptyMessageDelayed(1, 1000L);
    }
  }
  
  public int eO(int paramInt)
  {
    Iterator localIterator = this.mg.iterator();
    while (localIterator.hasNext())
    {
      TabInfo localTabInfo = (TabInfo)localIterator.next();
      if (localTabInfo.tabType == paramInt) {
        return localTabInfo.tabIndex;
      }
    }
    return 0;
  }
  
  public void finish()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if ((localInputMethodManager != null) && (getCurrentFocus() != null)) {
      localInputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }
    super.finish();
    if (this.aYI) {
      overridePendingTransition(2130772000, 2130772001);
    }
  }
  
  public int getCurrentIndex()
  {
    return this.bIC;
  }
  
  public long getDetect302Time()
  {
    return 0L;
  }
  
  public boolean getIsReloadUrl()
  {
    aqyg localaqyg = a();
    if (localaqyg == null) {}
    for (boolean bool = false;; bool = localaqyg.getIsReloadUrl())
    {
      if (QLog.isDevelopLevel()) {
        ajrk.f("WebSpeedTrace", "getIsReloadUrl", new Object[] { Boolean.valueOf(bool) });
      }
      return bool;
    }
  }
  
  public int getLayoutResId()
  {
    return 2131559683;
  }
  
  public long getOpenUrlAfterCheckOfflineTime()
  {
    aqyg localaqyg = a();
    if (localaqyg == null) {}
    for (long l = 0L;; l = localaqyg.getOpenUrlAfterCheckOfflineTime())
    {
      if (QLog.isDevelopLevel()) {
        ajrk.f("WebSpeedTrace", "getOpenUrlAfterCheckOfflineTime", new Object[] { Long.valueOf(l) });
      }
      return l;
    }
  }
  
  public long getReadIndexFromOfflineTime()
  {
    aqyg localaqyg = a();
    if (localaqyg == null) {}
    for (long l = 0L;; l = localaqyg.getReadIndexFromOfflineTime())
    {
      if (QLog.isDevelopLevel()) {
        ajrk.f("WebSpeedTrace", "getReadIndexFromOfflineTime", new Object[] { Long.valueOf(l) });
      }
      return l;
    }
  }
  
  public JSONObject getX5Performance()
  {
    aqyg localaqyg = a();
    if (localaqyg != null) {
      return localaqyg.mX5PerformanceJson;
    }
    return null;
  }
  
  public long getgetWebViewTime()
  {
    if (QLog.isDevelopLevel()) {
      ajrk.f("WebSpeedTrace", "getgetWebViewTime", new Object[] { Long.valueOf(this.Gw) });
    }
    return this.Gw;
  }
  
  public long getinitBrowserTime()
  {
    if (QLog.isDevelopLevel()) {
      ajrk.f("WebSpeedTrace", "getinitBrowserTime", new Object[] { Long.valueOf(this.Gx) });
    }
    return this.Gx;
  }
  
  public long getinitTBSTime()
  {
    return 0L;
  }
  
  public long getinitTime()
  {
    if (QLog.isDevelopLevel()) {
      ajrk.f("WebSpeedTrace", "getinitTime", new Object[] { Long.valueOf(this.mInitTime) });
    }
    return this.mInitTime;
  }
  
  public boolean getisWebViewCache()
  {
    boolean bool = WebAccelerateHelper.isWebViewCache;
    if (QLog.isDevelopLevel()) {
      ajrk.f("WebSpeedTrace", "getisWebViewCache", new Object[] { Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  public long getmClickTime()
  {
    if (QLog.isDevelopLevel()) {
      ajrk.f("WebSpeedTrace", "getmClickTime", new Object[] { Long.valueOf(this.mClickTime) });
    }
    return this.mClickTime;
  }
  
  public long getmOnCreateMilliTimeStamp()
  {
    if (QLog.isDevelopLevel()) {
      ajrk.f("WebSpeedTrace", "getmOnCreateMilliTimeStamp", new Object[] { Long.valueOf(this.mOnCreateMilliTimeStamp) });
    }
    return this.mOnCreateMilliTimeStamp;
  }
  
  public boolean getmPerfFirstLoadTag()
  {
    aqyg localaqyg = a();
    if (localaqyg == null) {}
    for (boolean bool = false;; bool = localaqyg.ismPerfFirstLoadTag())
    {
      if (QLog.isDevelopLevel()) {
        ajrk.f("WebSpeedTrace", "getmPerfFirstLoadTag", new Object[] { Boolean.valueOf(bool) });
      }
      return bool;
    }
  }
  
  public long getmStartLoadUrlMilliTimeStamp()
  {
    aqyg localaqyg = a();
    if (localaqyg == null) {}
    for (long l = 0L;; l = localaqyg.mStartLoadUrlMilliTimeStamp)
    {
      if (QLog.isDevelopLevel()) {
        ajrk.f("WebSpeedTrace", "getmStartLoadUrlMilliTimeStamp", new Object[] { Long.valueOf(l) });
      }
      return l;
    }
  }
  
  public long getmTimeBeforeLoadUrl()
  {
    aqyg localaqyg = a();
    if (localaqyg == null) {}
    for (long l = 0L;; l = localaqyg.getmTimeBeforeLoadUrl())
    {
      if (QLog.isDevelopLevel()) {
        ajrk.f("WebSpeedTrace", "getmTimeBeforeLoadUrl", new Object[] { Long.valueOf(l) });
      }
      return l;
    }
  }
  
  public long getonCreateTime()
  {
    if (QLog.isDevelopLevel()) {
      ajrk.f("WebSpeedTrace", "getonCreateTime", new Object[] { Long.valueOf(this.onCreateTime) });
    }
    return this.onCreateTime;
  }
  
  public long getpluginFinished()
  {
    return 0L;
  }
  
  public long getviewInflateTime()
  {
    if (QLog.isDevelopLevel()) {
      ajrk.f("WebSpeedTrace", "getviewInflateTime", new Object[] { Long.valueOf(this.Gv) });
    }
    return this.Gv;
  }
  
  public void grant()
  {
    if (a() != null) {
      a().doR();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      ThreadManager.post(new NearbyActivity.2(this), 8, null, true);
      try
      {
        i = getIntent().getIntExtra("NEARBY_IS_HAS_ICON", 2);
        anpo.a(this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface, getClass(), hashCode(), "0X80059D6", i);
      }
      catch (Throwable paramMessage)
      {
        paramMessage.printStackTrace();
      }
      continue;
      this.bIA += 1;
      if (QLog.isColorLevel()) {
        QLog.d("nearby.msgbox.tab", 2, "MSG_INIT_MSGTAB_REDDOT，retryTime=" + this.bIA + ", msgBoxTabIndex=" + this.bIx);
      }
      int i = this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView.qt();
      if ((this.bIx >= 0) && (i != this.bIx) && (this.s != null))
      {
        paramMessage = this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a();
        if (paramMessage.arB())
        {
          i = paramMessage.GD();
          a(this.s, i);
          if (QLog.isColorLevel()) {
            QLog.d("nearby.msgbox.tab", 2, "MSG_INIT_MSGTAB_REDDOT，curRedNum=" + i + "");
          }
          this.bIB = i;
        }
        else if (this.bIA < 3)
        {
          this.mHandler.sendEmptyMessageDelayed(2, 1000L);
        }
      }
    }
  }
  
  void initTitle()
  {
    setTitle(2131696191);
    this.aYI = getIntent().getBooleanExtra("abp_flag", this.aYI);
    this.mFrom = getIntent().getIntExtra("FROM_WHERE", this.mFrom);
    if ((this.aYI) || (this.mFrom == 0))
    {
      setLeftViewName(2131720741);
      return;
    }
    if (this.mFrom == 1003)
    {
      setLeftViewName(2131694588);
      return;
    }
    if (this.mFrom == 1004)
    {
      setLeftViewName(2131721053);
      return;
    }
    if (this.mFrom == 1002)
    {
      setLeftViewName(2131689680);
      return;
    }
    setLeftViewName(getIntent());
  }
  
  public void initViews()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNonSwipeableViewPager = ((NonSwipeableViewPager)findViewById(2131382093));
    this.jdField_a_of_type_ComTencentMobileqqWidgetNonSwipeableViewPager.TN(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNonSwipeableViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNonSwipeableViewPager.setPagingEnabled(false);
    this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)findViewById(2131379139));
    this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(this);
    a(this, this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView, this.mg);
    if ((this.mg.size() > 0) && (this.bIx >= 0) && (this.bIx < this.mg.size())) {
      this.s = a(this, this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView, this.mg.size(), this.bIx);
    }
    Object localObject = this.mg.iterator();
    int i = 0;
    int m;
    for (;;)
    {
      if (((Iterator)localObject).hasNext())
      {
        if (((TabInfo)((Iterator)localObject).next()).tabType == 7)
        {
          aiem.a.r(this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface);
          this.t = a(this, this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView, this.mg.size(), i);
          this.bIz = i;
          this.mHandler.postDelayed(new NearbyActivity.3(this), 2000L);
        }
      }
      else
      {
        if (this.titleRoot != null)
        {
          this.qF = ((ImageView)this.titleRoot.findViewById(2131377361).findViewById(2131369594));
          this.centerView = ((TextView)this.titleRoot.findViewById(2131369627));
          this.gR = ((RelativeLayout)this.titleRoot.findViewById(2131379823));
        }
        initTitle();
        m = ((Integer)ajrb.c(this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin(), "key_auto_enter_without_redot", Integer.valueOf(0))).intValue();
        j = 0;
        i = -1;
        while (j < this.mg.size())
        {
          localObject = (TabInfo)this.mg.get(j);
          if (((TabInfo)localObject).autoEnter == 1) {
            i = ((TabInfo)localObject).tabIndex;
          }
          j += 1;
        }
      }
      i += 1;
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragmentManager = getSupportFragmentManager();
    this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity$a = new a(this.jdField_a_of_type_AndroidSupportV4AppFragmentManager);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNonSwipeableViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity$a);
    int j = this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.bTJ;
    if (this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().a(5) != null) {
      j = eO(5);
    }
    for (int k = 1;; k = 0)
    {
      if (k != 0)
      {
        if ((m != 1) || (i == -1)) {
          break label860;
        }
        k = i;
        if (getIntent().hasExtra("TAB_TYPE")) {
          k = eO(getIntent().getIntExtra("TAB_TYPE", 5));
        }
        QLog.d("nearby.NearbyActivity", 1, "tabIdx=" + k + ", tabs.size=" + this.mg.size());
        if (k >= 0)
        {
          i = k;
          if (k < this.mg.size()) {}
        }
        else
        {
          i = 0;
        }
        NearbyBaseFragment.dan = i;
        this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.cpI = true;
        this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.bTJ = i;
        j = ((TabInfo)this.mg.get(i)).tabIndex;
        if ((((TabInfo)this.mg.get(i)).autoEnter == 1) && (((TabInfo)this.mg.get(i)).tabUrl != null))
        {
          localObject = ((TabInfo)this.mg.get(i)).tabUrl;
          if (!((String)localObject).contains("?")) {
            break label865;
          }
          localObject = (String)localObject + "&open_way=nearby_auto";
          label665:
          ((TabInfo)this.mg.get(i)).tabUrl = ((String)localObject);
          if (QLog.isColorLevel()) {
            QLog.i("nearby.NearbyActivity", 2, "autoEnter url = " + (String)localObject);
          }
        }
        if (j < 0) {
          break label891;
        }
      }
      for (;;)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(j, false);
        if (QLog.isColorLevel()) {
          QLog.d("nearby.msgbox.tab", 2, "initViews, curIdx=" + j + ", msgTabBoxIdx=" + this.bIx + ", tabs.size=" + this.mg.size());
        }
        this.mHandler.sendEmptyMessageDelayed(2, 1000L);
        this.bIw = j;
        if (QLog.isColorLevel()) {
          ajrk.m("MSG_INIT", new Object[] { Integer.valueOf(i), Integer.valueOf(this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.bTJ), Integer.valueOf(NearbyBaseFragment.dan) });
        }
        return;
        k = i;
        if (i != -1) {
          break;
        }
        label860:
        k = j;
        break;
        label865:
        localObject = (String)localObject + "?open_way=nearby_auto";
        break label665;
        label891:
        j = 0;
      }
    }
  }
  
  public boolean isMainPageUseLocalFile()
  {
    aqyg localaqyg = a();
    if (localaqyg == null) {}
    for (boolean bool = false;; bool = localaqyg.isMainPageUseLocalFile())
    {
      if (QLog.isDevelopLevel()) {
        ajrk.f("WebSpeedTrace", "isMainPageUseLocalFile", new Object[] { Boolean.valueOf(bool) });
      }
      return bool;
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    Object localObject;
    if (this.bIC >= 0)
    {
      localObject = a(this.bIC);
      if ((localObject != null) && (((BaseFragment)localObject).onBackEvent())) {
        return false;
      }
    }
    if ((this.aYI) && (this.mFrom != 0))
    {
      localObject = new Intent(this, SplashActivity.class);
      ((Intent)localObject).putExtra("main_tab_id", 4);
      ((Intent)localObject).setFlags(603979776);
      startActivity((Intent)localObject);
    }
    return super.onBackEvent();
  }
  
  public void onTabSelected(int paramInt1, int paramInt2)
  {
    NearbyBaseFragment localNearbyBaseFragment;
    if (paramInt2 == this.bIC)
    {
      localNearbyBaseFragment = a(this.bIC);
      if (localNearbyBaseFragment != null) {
        localNearbyBaseFragment.doJ();
      }
      if (QLog.isColorLevel()) {
        ajrk.m("onTabClicked", new Object[0]);
      }
    }
    if (QLog.isColorLevel()) {
      ajrk.m("onTabSelected", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.bIw), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqWidgetNonSwipeableViewPager.getCurrentItem()), Integer.valueOf(this.bIC) });
    }
    if ((this.bIC >= 0) && (this.bIC != paramInt2))
    {
      localNearbyBaseFragment = a(this.bIC);
      if (localNearbyBaseFragment != null) {
        localNearbyBaseFragment.onHiddenChanged(true);
      }
      if (paramInt2 == this.bIx) {
        xF(true);
      }
    }
    this.bIC = paramInt2;
    if ((this.bIw < 0) || (paramInt2 != this.bIw) || (paramInt2 != this.jdField_a_of_type_ComTencentMobileqqWidgetNonSwipeableViewPager.getCurrentItem())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNonSwipeableViewPager.setCurrentItem(paramInt2, false);
    }
    if (paramInt2 == 0) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNonSwipeableViewPager.TN(false);
    }
    for (;;)
    {
      if (this.bIw == 3) {
        i(this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface, "0X8005CEA");
      }
      if (this.bIw == 1) {
        this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.reportClickEvent("dc00899", "grp_lbs", "", "anchor_tab", "exp", 0, 0, "", "", "", "");
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetNonSwipeableViewPager.TN(true);
    }
  }
  
  public int pluginStartActivityForResult(WebViewPlugin paramWebViewPlugin, Intent paramIntent, byte paramByte)
  {
    int i = switchRequestCode(paramWebViewPlugin, paramByte);
    if (i == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyActivity", 2, "pluginStartActivityForResult not handled");
      }
      return i;
    }
    startActivityForResult(paramIntent, i);
    return i;
  }
  
  @TargetApi(11)
  public void removeWebViewLayerType()
  {
    if (Build.VERSION.SDK_INT == 16) {
      this.vg.setLayerType(0, null);
    }
  }
  
  public String setLastActivityName()
  {
    if (this.bIw == 2) {
      return getString(2131695650);
    }
    return super.setLastActivityName();
  }
  
  public void setX5Performance(JSONObject paramJSONObject)
  {
    aqyg localaqyg = a();
    if (localaqyg != null) {
      localaqyg.mX5PerformanceJson = paramJSONObject;
    }
  }
  
  public int switchRequestCode(WebViewPlugin paramWebViewPlugin, byte paramByte)
  {
    CustomWebView localCustomWebView = paramWebViewPlugin.mRuntime.getWebView();
    if (localCustomWebView == null) {}
    int i;
    do
    {
      do
      {
        return -1;
      } while (localCustomWebView.getPluginEngine() == null);
      i = WebViewPluginEngine.a(paramWebViewPlugin);
      if (i != -1) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("nearby.NearbyActivity", 2, "switchRequestCode failed: webview index=" + 0 + ", pluginIndex=" + i);
    return -1;
    return i << 8 & 0xFF00 | 0x0 | paramByte & 0xFF;
  }
  
  public void u(View.OnClickListener paramOnClickListener)
  {
    this.qU.add(paramOnClickListener);
  }
  
  public int vA()
  {
    if ((ThemeUtil.getUserCurrentThemeId(this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface).equals("1000")) && (!ThemeUtil.isInNightMode(this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyActivity", 2, "default theme daymode,clear decorview background");
      }
      return 0;
    }
    return 2130838900;
  }
  
  public void xF(boolean paramBoolean)
  {
    String str = acbn.bkF;
    Intent localIntent = new Intent(this, MsgBoxListActivity.class);
    localIntent.putExtra("uin", str);
    localIntent.putExtra("uintype", 1001);
    localIntent.putExtra("isFromNearby", true);
    localIntent.putExtra("tabs", this.mg);
    localIntent.putExtra("msgTabIndex", this.bIx);
    localIntent.putExtra("mUnReadMsgNum", this.bIB);
    localIntent.putExtra("selfSet_leftViewText", acfp.m(2131708644));
    startActivityForResult(localIntent, 10001);
    if (paramBoolean) {
      overridePendingTransition(2130772300, 2130772300);
    }
    if (QLog.isColorLevel()) {
      QLog.d("nearby.msgbox.tab", 2, "startMsgBoxListActivity");
    }
    new anov(null).a("dc00899").b("grp_lbs").c("msg_box").d("page_exp").report();
  }
  
  public static class TabInfo
    implements Serializable, Comparable<TabInfo>
  {
    public static final int TAB_HOT_CHAT = 3;
    public static final int TAB_NEARBY = 1;
    public static final int TAB_NEARBY_HYBRID = 5;
    public static final int TAB_NEARBY_MSG = 6;
    public static final int TAB_NEARBY_YULIAO = 7;
    public static final int TAB_NOW = 2;
    public static final int TAB_WEB = 4;
    public int autoEnter;
    public int disableScroll;
    public int needLoc;
    public int reportId;
    public int tabIndex;
    public String tabName;
    public int tabType;
    public String tabUrl;
    
    public int compareTo(TabInfo paramTabInfo)
    {
      return this.tabIndex - paramTabInfo.tabIndex;
    }
    
    public void fromJson(String paramString)
    {
      try
      {
        paramString = new JSONObject(paramString);
        this.tabName = paramString.optString("tabName");
        this.tabUrl = paramString.optString("tabUrl");
        this.tabIndex = paramString.optInt("tabIndex");
        this.tabType = paramString.optInt("tabType");
        this.disableScroll = paramString.optInt("disableScroll");
        this.needLoc = paramString.optInt("needLoc");
        this.reportId = paramString.optInt("reportId");
        return;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
    
    public String getTabTag()
    {
      return "android:switcher:" + 2131382093 + ":" + this.tabIndex;
    }
    
    public String toJson()
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("tabName", this.tabName);
        localJSONObject.put("tabUrl", this.tabUrl);
        localJSONObject.put("tabIndex", this.tabIndex);
        localJSONObject.put("tabType", this.tabType);
        localJSONObject.put("disableScroll", this.disableScroll);
        localJSONObject.put("needLoc", this.needLoc);
        localJSONObject.put("reportId", this.reportId);
        return localJSONObject.toString();
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
  
  class a
    extends FragmentPagerAdapter
  {
    HotChatFragment jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment;
    NearbyHybridFragment jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment;
    NearbyMsgFragment jdField_a_of_type_ComTencentMobileqqFragmentNearbyMsgFragment;
    NowLiveFragment jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment;
    
    public a(FragmentManager paramFragmentManager)
    {
      super();
    }
    
    public int getCount()
    {
      return NearbyActivity.this.mg.size();
    }
    
    public Fragment getItem(int paramInt)
    {
      Object localObject1 = NearbyActivity.this.a(paramInt);
      Object localObject2 = localObject1;
      NearbyActivity.TabInfo localTabInfo;
      if (localObject1 == null)
      {
        localTabInfo = (NearbyActivity.TabInfo)NearbyActivity.this.mg.get(paramInt);
        if (localTabInfo.tabType != 2) {
          break label82;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment == null) {
          this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment = new NowLiveFragment();
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment;
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          ((NearbyBaseFragment)localObject1).a(localTabInfo);
          localObject2 = localObject1;
        }
        return localObject2;
        label82:
        if (localTabInfo.tabType == 3)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment == null) {
            this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment = new HotChatFragment();
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment;
        }
        else if (localTabInfo.tabType == 4)
        {
          localObject1 = new CommonTabFragment();
        }
        else if (localTabInfo.tabType == 5)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment == null) {
            this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment = new NearbyHybridFragment();
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment;
        }
        else if (localTabInfo.tabType == 6)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyMsgFragment == null) {
            this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyMsgFragment = new NearbyMsgFragment();
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyMsgFragment;
        }
        else if (localTabInfo.tabType == 7)
        {
          localObject1 = new CommonTabFragment();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NearbyActivity
 * JD-Core Version:    0.7.0.1
 */