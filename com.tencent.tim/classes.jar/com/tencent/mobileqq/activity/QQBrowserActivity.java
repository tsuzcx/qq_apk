package com.tencent.mobileqq.activity;

import aeay;
import aebf;
import aebs;
import aeee;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import anku;
import aopd;
import aqyz;
import aqzl;
import aqzs;
import arag;
import arax;
import araz;
import araz.d;
import arbk;
import arcd.a;
import arcn;
import arcn.a;
import arcp;
import avej;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.lightGame.CmGameFragment;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNote.a;
import com.tencent.mobileqq.colornote.swipeback.SwipePostTableLayout;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import com.tencent.mobileqq.widget.TabBarView.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.IBrowserThirdAppReport;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
import svi;
import vnq;
import vnr;

public class QQBrowserActivity
  extends FragmentActivity
  implements aebf, aqzs, araz.d, IBrowserThirdAppReport
{
  public static long GA;
  public static final HashSet<String> ap = AbsBaseWebViewActivity.ap;
  public static int bJl;
  public final araz a;
  private ColorNote a;
  private FrameLayout aW;
  private boolean aZn = true;
  public int bJk = -1;
  public int bJm;
  protected aeay mColorNoteController;
  public ArrayList<WebViewTabBarData> pt;
  public Class<? extends WebViewFragment> s;
  private View tO;
  
  public QQBrowserActivity()
  {
    this.jdField_a_of_type_Araz = a();
  }
  
  private void Bo(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      if (paramInt == 16908288) {
        QLog.d("WebLog_QQBrowserActivity", 2, "QQBrowserActivity getColorNote,serviceType is ColorNoteConstants.ServiceType.WEB.");
      }
      if (paramInt == 16908292) {
        QLog.d("WebLog_QQBrowserActivity", 2, "QQBrowserActivity getColorNote,serviceType is ColorNoteConstants.ServiceType.BODONG.");
      }
    }
  }
  
  public static WebViewFragment a(int paramInt, QQBrowserActivity paramQQBrowserActivity)
  {
    WebViewTabBarData localWebViewTabBarData = (WebViewTabBarData)paramQQBrowserActivity.pt.get(paramInt);
    WebViewFragment localWebViewFragment = paramQQBrowserActivity.a(localWebViewTabBarData);
    FragmentTransaction localFragmentTransaction = paramQQBrowserActivity.getSupportFragmentManager().beginTransaction();
    paramQQBrowserActivity.a(localFragmentTransaction);
    if (!localWebViewFragment.isAdded()) {
      localFragmentTransaction.add(2131365379, localWebViewFragment, localWebViewTabBarData.tag);
    }
    for (;;)
    {
      localFragmentTransaction.commitAllowingStateLoss();
      paramQQBrowserActivity.bJm = paramInt;
      return localWebViewFragment;
      localFragmentTransaction.show(localWebViewFragment);
    }
  }
  
  public static boolean bs(long paramLong)
  {
    long l = System.currentTimeMillis();
    if (l - GA > paramLong)
    {
      GA = l;
      return true;
    }
    return false;
  }
  
  private void cd(Intent paramIntent)
  {
    String str = arcp.e(paramIntent);
    WebAccelerateHelper.getInstance().preGetKey(str, paramIntent, null);
    WebAccelerateHelper.getInstance().preCheckOffline(str);
    WebAccelerateHelper.getInstance().preFetchResource(str);
  }
  
  private void cw()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_QQBrowserActivity", 2, "finish");
    }
    Object localObject = c();
    if (localObject != null) {
      ((WebViewFragment)localObject).aBB();
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if ((localInputMethodManager != null) && (a(this) != null)) {
      localInputMethodManager.hideSoftInputFromWindow(b(this).getWindowToken(), 0);
    }
    super.finish();
    if ((this.mColorNoteController != null) && ((this.mColorNoteController.isColorNoteExist()) || (this.mColorNoteController.agh()))) {
      overridePendingTransition(0, 0);
    }
    if (getIntent().getBooleanExtra("finish_animation_up_down", false)) {
      overridePendingTransition(0, 2130771990);
    }
    if (getIntent().getBooleanExtra("finish_animation_out_to_right", false)) {
      overridePendingTransition(0, 2130772275);
    }
    if (getIntent().getBooleanExtra("finish_animation_out_to_top", false)) {
      overridePendingTransition(0, 2130772371);
    }
    if (getIntent().getBooleanExtra("finish_animation_none", false)) {
      overridePendingTransition(0, 0);
    }
    if ((localObject != null) && (((WebViewFragment)localObject).jdField_a_of_type_Arcd$a != null))
    {
      if ((((WebViewFragment)localObject).jdField_a_of_type_Arcd$a.Io & 0x100) == 0L) {
        break label261;
      }
      overridePendingTransition(0, 0);
    }
    for (;;)
    {
      if (getIntent().getBooleanExtra("from_risk_hint", false))
      {
        getIntent().removeExtra("from_risk_hint");
        localObject = new Intent(this, LoginInfoActivity.class);
        ((Intent)localObject).putExtra("from_risk_hint", true);
        startActivity((Intent)localObject);
      }
      return;
      label261:
      if ((((WebViewFragment)localObject).jdField_a_of_type_Arcd$a.Io & 0x200) != 0L) {
        overridePendingTransition(0, 2130772013);
      }
    }
  }
  
  public static boolean ho(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        Object localObject = Uri.parse(paramString);
        paramString = ((Uri)localObject).getHost();
        localObject = ((Uri)localObject).getQueryParameter("useCMShowWebview");
        if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("qq.com")) && (!TextUtils.isEmpty((CharSequence)localObject)))
        {
          int i = Integer.parseInt((String)localObject);
          if (i == 1) {
            return true;
          }
        }
        return false;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return false;
      }
    }
    return false;
  }
  
  public araz a()
  {
    return new araz(this, 1, null);
  }
  
  public WebViewFragment a()
  {
    return c();
  }
  
  public WebViewFragment a(Intent paramIntent)
  {
    Object localObject2;
    Object localObject1;
    if (this.s != null) {
      try
      {
        WebViewFragment localWebViewFragment1 = (WebViewFragment)this.s.newInstance();
        localObject2 = new Bundle();
        ((Bundle)localObject2).putParcelable("intent", paramIntent);
        localWebViewFragment1.setArguments((Bundle)localObject2);
        return localWebViewFragment1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localObject1 = new WebViewFragment();
        }
      }
    }
    if (!TextUtils.isEmpty(paramIntent.getStringExtra("fragment_class"))) {
      localObject1 = paramIntent.getStringExtra("fragment_class");
    }
    for (;;)
    {
      try
      {
        localObject1 = Class.forName((String)localObject1).newInstance();
        if (!(localObject1 instanceof WebViewFragment)) {
          break label202;
        }
        localObject2 = (WebViewFragment)localObject1;
        localObject1 = localObject2;
        if (localObject2 != null) {
          break;
        }
        localObject1 = new WebViewFragment();
        break;
      }
      catch (InstantiationException localInstantiationException)
      {
        localInstantiationException.printStackTrace();
        if (0 != 0) {
          break label197;
        }
        WebViewFragment localWebViewFragment2 = new WebViewFragment();
        break;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
        if (0 != 0) {
          break label197;
        }
        WebViewFragment localWebViewFragment3 = new WebViewFragment();
        break;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        localClassNotFoundException.printStackTrace();
        if (0 != 0) {
          break label197;
        }
        localWebViewFragment4 = new WebViewFragment();
        break;
      }
      finally
      {
        if (0 == 0) {
          new WebViewFragment();
        }
      }
      WebViewFragment localWebViewFragment4 = new WebViewFragment();
      break;
      label197:
      localWebViewFragment4 = null;
      break;
      label202:
      localObject2 = null;
    }
  }
  
  public WebViewFragment a(WebViewTabBarData paramWebViewTabBarData)
  {
    if (paramWebViewTabBarData != null)
    {
      Object localObject2 = (WebViewFragment)super.getSupportFragmentManager().findFragmentByTag(paramWebViewTabBarData.tag);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = super.getIntent();
        long l = ((Intent)localObject2).getLongExtra("startOpenPageTime", -1L);
        if ((l == -1L) || (System.currentTimeMillis() - l > 5000L)) {
          ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
        }
        Intent localIntent = new Intent((Intent)localObject2);
        if (!TextUtils.isEmpty(((Intent)localObject2).getStringExtra("fragment_class"))) {
          ((Intent)localObject2).removeExtra("fragment_class");
        }
        localObject1 = arag.a(this, paramWebViewTabBarData, localIntent);
        cd(localIntent);
        ((Intent)localObject2).removeExtra("startOpenPageTime");
        ((Intent)localObject2).removeExtra("qqBrowserActivityCreateTime");
        ((Intent)localObject2).removeExtra("reportSourceFrom");
      }
      return localObject1;
    }
    return null;
  }
  
  public void a(FragmentTransaction paramFragmentTransaction)
  {
    if (paramFragmentTransaction == null) {}
    for (;;)
    {
      return;
      Object localObject = super.getSupportFragmentManager();
      if (localObject != null)
      {
        localObject = ((FragmentManager)localObject).getFragments();
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            Fragment localFragment = (Fragment)((Iterator)localObject).next();
            if (((localFragment instanceof WebViewFragment)) && (localFragment.isVisible())) {
              paramFragmentTransaction.hide(localFragment);
            }
          }
        }
      }
    }
  }
  
  protected void a(SwipePostTableLayout paramSwipePostTableLayout)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_QQBrowserActivity", 2, "QQBrowserActivity initColorNote.");
    }
    int j = 1;
    int i = 1;
    if (!BaseApplicationImpl.getApplication().getRuntime().isLogin()) {
      j = 0;
    }
    if (aebs.lu(getOriginalUrl())) {
      i = 0;
    }
    if ((aebs.lr(getOriginalUrl())) || (TextUtils.isEmpty(getOriginalUrl()))) {
      i = 0;
    }
    if (j != 0) {
      if (i == 0) {
        break label162;
      }
    }
    label162:
    for (this.mColorNoteController = new aeay(this, true, false, paramSwipePostTableLayout, true, true, false, 2131165656);; this.mColorNoteController = new aeay(this, false, true, paramSwipePostTableLayout, true, true, false, 2131165656))
    {
      this.mColorNoteController.attachToActivity(this);
      this.mColorNoteController.setServiceInfo(this);
      this.jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote = getColorNote();
      this.mColorNoteController.a(new vnq(this));
      this.mColorNoteController.setOnPageSwipeListener(new vnr(this));
      this.mColorNoteController.Hm(getOriginalUrl());
      return;
    }
  }
  
  public View aM()
  {
    return this.tO;
  }
  
  protected void aYx()
  {
    a(null);
  }
  
  public boolean an(boolean paramBoolean)
  {
    Object localObject;
    if (this.tO != null)
    {
      localObject = this.tO;
      if (paramBoolean)
      {
        i = 0;
        ((View)localObject).setVisibility(i);
      }
    }
    else if (this.aW != null)
    {
      localObject = (FrameLayout.LayoutParams)this.aW.getLayoutParams();
      if (!paramBoolean) {
        break label86;
      }
    }
    label86:
    for (int i = 54;; i = 0)
    {
      ((FrameLayout.LayoutParams)localObject).bottomMargin = ((int)(i * getResources().getDisplayMetrics().density + 0.5F));
      this.aW.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return false;
      i = 8;
      break;
    }
  }
  
  public WebView b()
  {
    if (a() != null) {
      return a().b();
    }
    return null;
  }
  
  public void bSK()
  {
    this.aZn = true;
  }
  
  public void bSL()
  {
    this.aZn = false;
  }
  
  public void bSM()
  {
    if ((this.pt != null) && (this.pt.size() > 1) && (this.tO == null))
    {
      this.tO = arax.a(this, super.getIntent(), this.pt, new a(this));
      this.tO.setId(2131379122);
      Object localObject = this.aW.getParent();
      if (!(localObject instanceof FrameLayout)) {
        break label154;
      }
      if (!super.getIntent().getBooleanExtra("topTabSwitchFragment", false))
      {
        ((FrameLayout)localObject).addView(this.tO, new FrameLayout.LayoutParams(-1, -2, 80));
        localObject = (FrameLayout.LayoutParams)this.aW.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).bottomMargin = ((int)(54.0F * getResources().getDisplayMetrics().density + 0.5F));
        this.aW.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    return;
    label154:
    QLog.e("WebLog_QQBrowserActivity", 1, "doOnCreate error:should not enter here!");
  }
  
  protected void bv(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public WebViewFragment c()
  {
    Object localObject = super.getSupportFragmentManager();
    if (localObject != null)
    {
      localObject = ((FragmentManager)localObject).getFragments();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Fragment localFragment = (Fragment)((Iterator)localObject).next();
          if (((localFragment instanceof WebViewFragment)) && (localFragment.isVisible())) {
            return (WebViewFragment)localFragment;
          }
        }
      }
    }
    return null;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.i("WebLog_QQBrowserActivity", 2, String.format("doOnActivityResult resultCode=0x%x", new Object[] { Integer.valueOf(paramInt2) }));
    }
    if (paramInt2 == 4660)
    {
      super.setResult(4660);
      finish();
    }
    for (;;)
    {
      WebViewFragment localWebViewFragment = c();
      if (localWebViewFragment != null) {
        localWebViewFragment.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      }
      return;
      if ((paramInt2 == -1) && (paramInt1 == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebLog_QQBrowserActivity", 2, "upload shotphoto request");
        }
        anku.cf(this);
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    arbz.auI = SystemClock.elapsedRealtime();
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_QQBrowserActivity", 2, "doOnCreate start");
    }
    if ((Build.VERSION.SDK_INT > 10) && (!ap.contains(Build.MANUFACTURER + "_" + Build.MODEL))) {
      getWindow().addFlags(16777216);
    }
    getWindow().setFormat(-3);
    getWindow().setBackgroundDrawable(null);
    this.mNeedStatusTrans = false;
    arcn.a.avr = 0L;
    arcn.a.init();
    Object localObject1 = new FrameLayout(this);
    super.doOnCreate(paramBundle);
    super.setContentView((View)localObject1, new FrameLayout.LayoutParams(-1, -1));
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      super.getActivity().getWindow().addFlags(67108864);
    }
    ImmersiveUtils.clearCoverForStatus(getWindow(), true);
    paramBundle = super.getIntent();
    Object localObject2 = paramBundle.getSerializableExtra("tabConfigData");
    if ((localObject2 instanceof ArrayList)) {
      this.pt = ((ArrayList)localObject2);
    }
    if (this.pt == null)
    {
      localObject2 = new WebViewTabBarData();
      ((WebViewTabBarData)localObject2).tag = "web";
      ((WebViewTabBarData)localObject2).url = paramBundle.getStringExtra("url");
      if (((WebViewTabBarData)localObject2).url == null)
      {
        ((WebViewTabBarData)localObject2).url = "";
        QLog.e("WebLog_QQBrowserActivity", 1, "url = null");
      }
      this.pt = new ArrayList(1);
      this.pt.add(localObject2);
      localObject2 = paramBundle.getExtras();
      if (localObject2 != null)
      {
        if (!ho(arcp.e(paramBundle))) {
          break label463;
        }
        this.s = CmGameFragment.class;
      }
      label305:
      this.aW = ((FrameLayout)localObject1);
      if ((this.pt.size() > 1) && (!(((FrameLayout)localObject1).getParent() instanceof FrameLayout)))
      {
        this.aW = new FrameLayout(this);
        ((FrameLayout)localObject1).addView(this.aW, new FrameLayout.LayoutParams(-1, -1));
        QLog.i("WebLog_QQBrowserActivity", 1, "doOnCreate warning:content is not an instance of FrameLayout.");
      }
      this.aW.setId(2131365379);
      int i = paramBundle.getIntExtra("tabDefaultIndex", 0);
      localObject1 = (WebViewTabBarData)this.pt.get(i);
      paramBundle.removeExtra("tabDefaultIndex");
      paramBundle = a((WebViewTabBarData)localObject1);
      if (paramBundle.isAdded()) {
        break label490;
      }
      super.getSupportFragmentManager().beginTransaction().add(2131365379, paramBundle, ((WebViewTabBarData)localObject1).tag).commitAllowingStateLoss();
    }
    for (;;)
    {
      if (this.aZn) {
        aYx();
      }
      return true;
      paramBundle.removeExtra("tabConfigData");
      break;
      label463:
      localObject2 = (Class)((Bundle)localObject2).getSerializable("fragmentClass");
      if (localObject2 == null) {
        break label305;
      }
      this.s = ((Class)localObject2);
      break label305;
      label490:
      super.getSupportFragmentManager().beginTransaction().show(paramBundle).commitAllowingStateLoss();
    }
  }
  
  public void doOnDestroy()
  {
    bJl -= 1;
    if (this.aW != null)
    {
      ViewParent localViewParent = this.aW.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(this.tO);
      }
      this.tO = null;
    }
    if ((this.aZn) && (this.mColorNoteController != null)) {
      this.mColorNoteController.onDestroy();
    }
    try
    {
      super.doOnDestroy();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("WebLog_QQBrowserActivity", 1, localException, new Object[0]);
    }
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    WebViewFragment localWebViewFragment = c();
    if (localWebViewFragment != null) {
      localWebViewFragment.a(paramInt, paramKeyEvent);
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    WebViewFragment localWebViewFragment = c();
    if (localWebViewFragment != null) {
      localWebViewFragment.doOnNewIntent(paramIntent);
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if ((this.aZn) && (this.mColorNoteController != null))
    {
      this.mColorNoteController.onPause();
      if (getIntent().getBooleanExtra("isFromFavourite", false)) {
        this.mColorNoteController.addHistoryNote();
      }
    }
    if (aebs.ls(getOriginalUrl()))
    {
      aeee.e(this, 2, true);
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_QQBrowserActivity", 2, "color note small screen visible by doOnPause");
      }
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if ((this.aZn) && (this.mColorNoteController != null)) {
      this.mColorNoteController.onResume();
    }
    if (aebs.ls(getOriginalUrl()))
    {
      aeee.e(this, 2, false);
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_QQBrowserActivity", 2, "color note small screen invisible by doOnResume");
      }
    }
  }
  
  public void doOnSaveInstanceState(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putBoolean("browserRestoreFlag", true);
    if (this.pt != null) {
      localBundle.putInt("key_maintab", this.bJm);
    }
    super.doOnSaveInstanceState(localBundle);
  }
  
  public void doOnUserLeaveHint()
  {
    Intent localIntent = new Intent("tencent.notify.background");
    localIntent.setPackage(MobileQQ.getContext().getPackageName());
    localIntent.putExtra("selfuin", BaseApplicationImpl.getApplication().getRuntime().getAccount());
    localIntent.putExtra("AccountInfoSync", "mobileqq.web");
    localIntent.putExtra("classname", getClass().getName());
    sendBroadcast(localIntent, "com.tencent.tim.msg.permission.pushnotify");
    super.doOnUserLeaveHint();
  }
  
  public void finish()
  {
    if ((this.aZn) && (this.mColorNoteController != null))
    {
      this.mColorNoteController.exitAnimation();
      return;
    }
    cw();
  }
  
  public ColorNote getColorNote()
  {
    Object localObject4 = null;
    Object localObject8 = super.getIntent();
    Object localObject5 = c();
    Object localObject3 = "";
    Object localObject1;
    if (localObject5 != null)
    {
      localObject4 = ((WebViewFragment)localObject5).b();
      if (!TextUtils.isEmpty(((svi)localObject4).getShareTitle()))
      {
        localObject1 = ((svi)localObject4).getShareTitle();
        localObject3 = ((svi)localObject4).nr();
        localObject5 = ((svi)localObject4).nP();
        if (!TextUtils.isEmpty((CharSequence)localObject5)) {
          break label640;
        }
        localObject4 = aebs.ke(getOriginalUrl());
        localObject5 = localObject3;
        localObject3 = localObject1;
        localObject1 = localObject5;
      }
    }
    for (;;)
    {
      for (;;)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote == null) || (!this.jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote.isTitleAndPicValid())) {
          break label211;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          this.jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote.mMainTitle = ((String)localObject3);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          this.jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote.mSubTitle = ((String)localObject1);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject4)) {
          this.jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote.mPicUrl = ((String)localObject4);
        }
        return this.jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote;
        localObject1 = localObject3;
        if (((WebViewFragment)localObject5).jdField_a_of_type_Aqzl == null) {
          break;
        }
        try
        {
          localObject1 = ((WebViewFragment)localObject5).jdField_a_of_type_Aqzl.getTitle();
        }
        catch (Exception localException1)
        {
          QLog.e("WebLog_QQBrowserActivity", 2, "fragment.mSwiftTitleUI.getTitle()", localException1);
          localObject2 = localObject3;
        }
      }
      break;
      label211:
      localObject5 = b();
      JSONObject localJSONObject = new JSONObject();
      if (localObject5 != null) {}
      for (;;)
      {
        try
        {
          localJSONObject.put("key_scroll_y", ((WebView)localObject5).getWebScrollY());
          localObject5 = getOriginalUrl();
          localObject6 = localObject5;
          if (TextUtils.isEmpty((CharSequence)localObject5)) {
            localObject6 = ((Intent)localObject8).getStringExtra("subType");
          }
          if (localObject6 != null)
          {
            localObject5 = localObject6;
            if (!TextUtils.isEmpty((CharSequence)localObject6)) {}
          }
          else
          {
            localObject5 = "unregistered service sub type";
          }
          localObject6 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject2 = getOriginalUrl();
            try
            {
              localObject6 = new URL((String)localObject2);
              boolean bool = TextUtils.isEmpty(((URL)localObject6).getHost());
              if (!bool) {
                continue;
              }
            }
            catch (RuntimeException localRuntimeException)
            {
              int j;
              QLog.e("WebLog_QQBrowserActivity", 1, localRuntimeException, new Object[0]);
              continue;
            }
            catch (MalformedURLException localMalformedURLException)
            {
              QLog.e("WebLog_QQBrowserActivity", 1, localMalformedURLException, new Object[0]);
              continue;
            }
            catch (Exception localException2)
            {
              QLog.e("WebLog_QQBrowserActivity", 1, localException2, new Object[0]);
              localObject7 = localObject2;
            }
            localObject8 = getOriginalUrl();
            if (!avej.tj((String)localObject8)) {
              break label634;
            }
            j = 16908292;
            localObject6 = avej.O(avej.N(avej.O((String)localObject8, "from", "1041001"), "from", "1041001"), "openFromColorTab", "1");
            i = j;
            localObject5 = localObject6;
            if (QLog.isColorLevel())
            {
              QLog.d("WebLog_QQBrowserActivity", 2, "isBoodoUlr,serviceType is ColorNoteConstants.ServiceType.BODONG, original url is " + (String)localObject8 + ", new url is " + (String)localObject6);
              localObject5 = localObject6;
              i = j;
            }
            Bo(i);
            if (this.mColorNoteController == null) {
              continue;
            }
            localObject2 = this.mColorNoteController.a(i, (String)localObject5, (String)localObject3, (String)localObject2, (String)localObject4, localJSONObject.toString().getBytes());
            this.jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote = ((ColorNote)localObject2);
            return localObject2;
          }
        }
        catch (JSONException localJSONException)
        {
          QLog.e("WebLog_QQBrowserActivity", 1, localJSONException, new Object[0]);
          continue;
          Object localObject6 = ((URL)localObject6).getHost();
          localObject2 = localObject6;
          continue;
          Object localObject7;
          localObject2 = localObject7;
          continue;
          localObject2 = new ColorNote.a().a(i).a(localJSONException).b((String)localObject3).c((String)localObject2).d((String)localObject4).a(localJSONObject.toString().getBytes()).a();
          this.jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote = ((ColorNote)localObject2);
          return localObject2;
        }
        label634:
        int i = 16908288;
      }
      label640:
      localObject4 = localObject2;
      Object localObject2 = localObject3;
      localObject3 = localObject4;
      localObject4 = localJSONException;
      continue;
      localObject3 = "";
      localObject2 = null;
    }
  }
  
  public aeay getColorNoteController()
  {
    return this.mColorNoteController;
  }
  
  public String getCurrentUrl()
  {
    try
    {
      Object localObject = b();
      if (localObject != null)
      {
        localObject = ((WebView)localObject).getUrl();
        return localObject;
      }
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  public Activity getHostActivity()
  {
    return this;
  }
  
  public String getModuleId()
  {
    return "modular_web";
  }
  
  public String getOriginalUrl()
  {
    String str = "";
    try
    {
      Intent localIntent = getIntent();
      if (localIntent != null) {
        str = localIntent.getStringExtra("url");
      }
      return str;
    }
    catch (Throwable localThrowable) {}
    return "";
  }
  
  public boolean isWrapContent()
  {
    boolean bool = false;
    if (getIntent().getBooleanExtra("is_wrap_content", false)) {
      bool = true;
    }
    return bool;
  }
  
  public boolean onBackEvent()
  {
    WebViewFragment localWebViewFragment = c();
    if (localWebViewFragment != null) {
      localWebViewFragment.biT();
    }
    return true;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    WebViewFragment localWebViewFragment = c();
    if (localWebViewFragment != null) {
      localWebViewFragment.doOnConfigurationChanged(paramConfiguration);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_QQBrowserActivity", 2, "onCreate start");
    }
    bJl += 1;
    Intent localIntent = super.getIntent();
    Object localObject = (arbk)this.jdField_a_of_type_Araz.q(1);
    if (localObject != null)
    {
      if (!((arbk)localObject).ae(localIntent))
      {
        QLog.e("WebLog_QQBrowserActivity", 1, "navigate to another activity!");
        super.onCreate(paramBundle);
        super.getActivity().finish();
        return;
      }
      if ((!((arbk)localObject).af(localIntent)) && (QLog.isColorLevel())) {
        QLog.i("WebLog_QQBrowserActivity", 2, "switch to different fragment.");
      }
    }
    if (paramBundle != null)
    {
      if (paramBundle.getBoolean("browserRestoreFlag")) {
        localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      }
      int i = paramBundle.getInt("key_maintab", 0);
      if (i != 0) {
        localIntent.putExtra("key_maintab", i);
      }
    }
    localIntent.putExtra("qqBrowserActivityCreateTime", System.currentTimeMillis());
    QLog.d("WebLog_QQBrowserActivity", 1, "onCreate createTime = " + System.currentTimeMillis());
    arcn.a().ehs();
    arcn.eht();
    if (!WebAccelerateHelper.isWebViewCache)
    {
      ThreadManager.postImmediately(new QQBrowserActivity.1(this), null, false);
      if (aopd.b() == null) {
        ThreadManager.postImmediately(new QQBrowserActivity.2(this), null, false);
      }
      if (!aqyz.a().cXj) {
        ThreadManager.postImmediately(new QQBrowserActivity.3(this), null, false);
      }
    }
    localObject = paramBundle;
    if (getIntent().getBooleanExtra("isFromFavourite", false))
    {
      localObject = paramBundle;
      if (paramBundle == null) {
        localObject = new Bundle();
      }
      ((Bundle)localObject).putAll(localIntent.getExtras());
    }
    super.onCreate((Bundle)localObject);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString) {}
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    WebViewFragment localWebViewFragment = c();
    if (localWebViewFragment != null) {
      localWebViewFragment.onPostThemeChanged();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    WebViewFragment localWebViewFragment = c();
    if (localWebViewFragment != null) {
      localWebViewFragment.doOnWindowFocusChanged(paramBoolean);
    }
  }
  
  public void receiveScreenOff()
  {
    super.receiveScreenOff();
    if ((this.mCanLock) && (!TextUtils.isEmpty(BaseApplicationImpl.getApplication().getRuntime().getAccount())) && (GesturePWDUtils.getGesturePWDState(this, BaseApplicationImpl.getApplication().getRuntime().getAccount()) == 2) && (GesturePWDUtils.getGesturePWDMode(this, BaseApplicationImpl.getApplication().getRuntime().getAccount()) == 21)) {
      startUnlockActivity();
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    if (getWindow().getContainer() == null) {
      requestWindowFeature(7);
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    WebViewFragment localWebViewFragment = c();
    if (localWebViewFragment != null) {
      localWebViewFragment.setTitle(paramCharSequence.toString());
    }
    super.setTitle(paramCharSequence);
  }
  
  protected boolean w(Bundle paramBundle)
  {
    return super.doOnCreate(paramBundle);
  }
  
  static class a
    implements TabBarView.a
  {
    final WeakReference<QQBrowserActivity> j;
    
    a(QQBrowserActivity paramQQBrowserActivity)
    {
      this.j = new WeakReference(paramQQBrowserActivity);
    }
    
    public void onTabSelected(int paramInt1, int paramInt2)
    {
      QQBrowserActivity localQQBrowserActivity = (QQBrowserActivity)this.j.get();
      if (localQQBrowserActivity == null) {}
      while (paramInt1 == paramInt2) {
        return;
      }
      QQBrowserActivity.a(paramInt2, localQQBrowserActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQBrowserActivity
 * JD-Core Version:    0.7.0.1
 */