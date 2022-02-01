package com.tencent.mobileqq.apollo.store;

import abii;
import abim;
import abja;
import abtv;
import abtv.b;
import abua;
import abuc;
import abvc;
import abve;
import abxi;
import acej;
import acfp;
import affz;
import afjy;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqgz;
import aqzl;
import aurf;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.store.openbox.ApolloCardWindow;
import com.tencent.mobileqq.apollo.store.openbox.ApolloCardWindow.a;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.Client;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.ApolloJsPlugin;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONObject;

@TargetApi(14)
public class ApolloStoreActivity
  extends QQBrowserActivity
  implements abja, abua, abuc, Handler.Callback, ApolloCardWindow.a
{
  private abtv jdField_a_of_type_Abtv;
  private ApolloCardWindow jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow;
  private String azS;
  MqqHandler b = new MqqHandler(Looper.getMainLooper(), this);
  private boolean bFp;
  private String bhC;
  private String bhD;
  private String mApolloId;
  private boolean mAttached;
  private boolean mCreated;
  private String mCurrentURL = "";
  private String mCurrentUin;
  int[] mDressIds;
  private String mNickName;
  int mRoleId;
  private RelativeLayout mRootView;
  private String mTab;
  private String mUrl;
  private float sG = 2.0F;
  private float sH = 1.0F;
  private boolean sw = true;
  
  private void Ig(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloStoreActivity_apollo_store_stability_", 2, "reportStorePageLoadSuccess. url:" + this.mCurrentURL);
    }
    abim localabim = abim.a();
    if (localabim.jp(this.mCurrentURL)) {
      localabim.j(null, this.mCurrentURL, 1001, paramInt);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ApolloStoreActivity_apollo_store_stability_", 2, "reportStorePageLoadTimeout. url is not in white list");
  }
  
  private void cFg()
  {
    if ((this.bFp) && (this.mCreated) && (this.mAttached))
    {
      if (super.getAppInterface() == null) {
        this.b.sendEmptyMessageDelayed(255, 1500L);
      }
    }
    else {
      return;
    }
    this.b.sendEmptyMessageDelayed(255, 500L);
  }
  
  private void cFi()
  {
    Object localObject = this.jdField_a_of_type_Abtv.b();
    if (localObject != null)
    {
      ((ApolloTextureView)localObject).getRenderImpl().u(1, this.mApolloId, "Bubble");
      ((ApolloTextureView)localObject).getRenderImpl().stopLoopDelayed(0L);
    }
    localObject = new Intent(this, ApolloGuestsStateActivity.class);
    ((Intent)localObject).putExtra("extra_guest_uin", this.mCurrentUin);
    ((Intent)localObject).putExtra("extra_guest_nick", this.azS);
    ((Intent)localObject).putExtra("extra_guest_from", 4);
    super.startActivity((Intent)localObject);
  }
  
  private void cFl()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloStoreActivity_apollo_store_stability_", 2, "reportStorePageLoadTimeout. url:" + this.mCurrentURL);
    }
    abim localabim = abim.a();
    if (localabim.jp(this.mCurrentURL)) {
      localabim.j(null, this.mCurrentURL, -1000, 0);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ApolloStoreActivity_apollo_store_stability_", 2, "reportStorePageLoadTimeout. url is not in white list");
  }
  
  public void CR(String paramString)
  {
    WebViewFragment localWebViewFragment = c();
    if ((localWebViewFragment == null) || (localWebViewFragment.j == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      paramString = "window && window.apollo && window.apollo.controller && window.apollo.controller.closeBox && window.apollo.controller.closeBox('" + paramString + "')";
      localWebViewFragment.j.callJs(paramString);
    } while (!QLog.isColorLevel());
    QLog.d("ApolloStoreActivity", 2, "onCardWindowClose,callBackStr:" + paramString);
  }
  
  public void CS(String paramString)
  {
    q(paramString, null);
  }
  
  public void Eh(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Abtv != null) {
      this.jdField_a_of_type_Abtv.Eh(paramBoolean);
    }
  }
  
  public void Ic(int paramInt)
  {
    ApolloUtil.d(this, this.mCurrentUin, "lmx_actview");
  }
  
  public void Id(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloStoreActivity", 2, "[openAIActivity], from:" + paramInt);
    }
    if (!ApolloEngine.BJ()) {}
    while ((this.jdField_a_of_type_Abtv == null) || (!"interactive".equals(this.mTab))) {
      return;
    }
    String str = getCurrentAccountUin();
    if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty(this.mCurrentUin))) {}
    for (;;)
    {
      cFi();
      return;
      if (str.equals(this.mCurrentUin)) {}
    }
  }
  
  public void Ie(int paramInt)
  {
    Object localObject = c();
    if ((localObject != null) && (((WebViewFragment)localObject).a != null) && (((WebViewFragment)localObject).a.leftView != null))
    {
      localObject = ((WebViewFragment)localObject).a.leftView;
      if (paramInt <= 0) {
        break label78;
      }
    }
    label78:
    for (int i = 0;; i = 4)
    {
      ((TextView)localObject).setVisibility(i);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloStoreActivity", 2, "setBackViewVisibility,visibility:" + paramInt);
      }
      return;
    }
  }
  
  public void If(int paramInt)
  {
    if (this.jdField_a_of_type_Abtv != null) {
      this.jdField_a_of_type_Abtv.If(paramInt);
    }
  }
  
  public abve a(boolean paramBoolean)
  {
    Object localObject = c();
    if ((localObject != null) && (((WebViewFragment)localObject).j != null))
    {
      localObject = ((WebViewFragment)localObject).j.getPluginEngine();
      if (localObject != null)
      {
        localObject = ((WebViewPluginEngine)localObject).b("apollo");
        if ((localObject != null) && ((localObject instanceof ApolloJsPlugin)))
        {
          localObject = ((ApolloJsPlugin)localObject).getIntercepter();
          if (localObject != null) {
            if (paramBoolean)
            {
              if (((abvc)localObject).Zk()) {
                return ((abvc)localObject).a();
              }
            }
            else {
              return ((abvc)localObject).a();
            }
          }
        }
      }
    }
    return null;
  }
  
  public String a(int paramInt, ApolloWebAvatarParam paramApolloWebAvatarParam)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("initAvatar hasApolloView: ");
    if (this.jdField_a_of_type_Abtv != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.i("ApolloStoreActivity", 1, bool);
      CS("ipc_apollo_query_mine_redinfo");
      if (paramApolloWebAvatarParam != null) {
        break;
      }
      QLog.e("ApolloStoreActivity", 1, "[initAvatar] no request params");
      return "{\"result\":1, \"msg\": \"缺少请求参数\" }";
    }
    this.mApolloId = paramApolloWebAvatarParam.apolloId;
    this.mTab = paramApolloWebAvatarParam.tab;
    this.mCurrentUin = paramApolloWebAvatarParam.uin;
    this.azS = paramApolloWebAvatarParam.nickName;
    this.mRoleId = paramApolloWebAvatarParam.roleId;
    this.mDressIds = paramApolloWebAvatarParam.dressIds;
    if (this.jdField_a_of_type_Abtv != null) {
      return this.jdField_a_of_type_Abtv.a(paramInt, false, paramApolloWebAvatarParam);
    }
    this.b.sendEmptyMessage(258);
    return "{\"result\":0, \"msg\": \"\" }";
  }
  
  public String a(abtv.b paramb)
  {
    if (this.jdField_a_of_type_Abtv != null) {
      return this.jdField_a_of_type_Abtv.a(paramb);
    }
    return abtv.iJ(acfp.m(2131702662));
  }
  
  public void b(int paramInt, int[] paramArrayOfInt)
  {
    if (this.jdField_a_of_type_Abtv != null) {
      this.jdField_a_of_type_Abtv.b(paramInt, paramArrayOfInt);
    }
  }
  
  public void b(ApolloTextureView paramApolloTextureView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow.getVisibility() == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow.bringToFront();
    }
  }
  
  public void b(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_Abtv != null) {
      this.jdField_a_of_type_Abtv.b(paramBoolean, paramFloat1, paramFloat2);
    }
  }
  
  public void c(Activity paramActivity, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      paramActivity = this.mNickName;
      if (this.jdField_a_of_type_Abtv != null) {
        this.jdField_a_of_type_Abtv.a(this, super.getAppInterface(), paramString1, paramActivity);
      }
    }
  }
  
  public void cFh()
  {
    WebViewFragment localWebViewFragment = c();
    if ((localWebViewFragment != null) && (localWebViewFragment.j != null) && (this.jdField_a_of_type_Abtv != null) && (this.jdField_a_of_type_Abtv.isSurfaceReady()))
    {
      localWebViewFragment.j.callJs("window.onReturn &&　window.onReturn()");
      if (QLog.isColorLevel()) {
        QLog.d("ApolloStoreActivity", 2, "onBackEvent");
      }
    }
    for (;;)
    {
      VipUtils.a(null, "cmshow", "Apollo", "0X80065CA", 0, 0, new String[0]);
      return;
      super.onBackEvent();
    }
  }
  
  public void cFj() {}
  
  public void cFk()
  {
    if (getIntent().getIntExtra("extra_key_jump_src", 0) == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloStoreActivity", 2, "send broadcast to finish jump activity");
      }
      Intent localIntent = new Intent();
      localIntent.setAction("BroadcastReceiverFinishActivity");
      sendBroadcast(localIntent);
    }
  }
  
  public String d(int[] paramArrayOfInt)
  {
    if (this.jdField_a_of_type_Abtv != null) {
      return this.jdField_a_of_type_Abtv.d(paramArrayOfInt);
    }
    return abtv.iJ("ApolloViewController not init!");
  }
  
  void dd(Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return;
      this.sH = (acej.aV() / 16.0F);
      if (this.sH != 0.0F) {
        this.sG = (aqgz.getDesity() / this.sH);
      }
    } while (this.sG != 0.0F);
    this.sG = aqgz.getDesity();
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject2 = null;
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloStoreActivity", 2, "doOnActivityResult requestCode:" + paramInt1 + " resultCode:" + paramInt2 + " data:" + paramIntent);
      }
      return;
      if (paramIntent != null) {
        localObject2 = paramIntent.getStringExtra("text");
      }
      Object localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = "";
      }
      for (;;)
      {
        localObject2 = c();
        if ((localObject2 == null) || (((WebViewFragment)localObject2).j == null)) {
          break;
        }
        if (paramInt2 != -1) {
          break label221;
        }
        ((WebViewFragment)localObject2).j.callJs("window.apollo && window.apollo.controller && window.apollo.controller.closeEditor && window.apollo.controller.closeEditor(1,'" + ApolloUtil.iW((String)localObject1) + "')");
        break;
        localObject1 = localObject2;
        if (((String)localObject2).length() > 12) {
          localObject1 = ((String)localObject2).substring(0, 12);
        }
      }
      label221:
      ((WebViewFragment)localObject2).j.callJs("window.apollo && window.apollo.controller && window.apollo.controller.closeEditor && window.apollo.controller.closeEditor(0,'" + ApolloUtil.iW((String)localObject1) + "')");
      continue;
      if (paramInt2 == -1)
      {
        VipUtils.a(null, "cmshow", "Apollo", "QzoneSuccess", 0, 0, new String[0]);
        continue;
        if (this.jdField_a_of_type_Abtv != null)
        {
          localObject1 = this.jdField_a_of_type_Abtv.b();
          if (localObject1 != null) {
            ((ApolloTextureView)localObject1).queueEvent(new ApolloStoreActivity.2(this, paramInt1, paramInt2, paramIntent));
          }
        }
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  public boolean doOnCreate(Bundle paramBundle)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ApolloStoreActivity", 2, "apollo_client ApolloStoreActivity start create!");
    }
    dd(super.getIntent());
    Object localObject2 = super.getIntent().getStringExtra("url");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = abxi.bjj;
    }
    localObject2 = new StringBuilder((String)localObject1);
    String str1 = super.getIntent().getStringExtra("extra_key_url_append");
    this.bFp = super.getIntent().getBooleanExtra("extra_key_open_box", false);
    this.bhD = super.getIntent().getStringExtra("extra_key_box_uin");
    this.bhC = super.getIntent().getStringExtra("extra_key_box_from");
    this.mNickName = super.getIntent().getStringExtra("extra_key_nickname");
    String str2 = super.getIntent().getStringExtra("extra_key_adtag");
    long l2 = aqgz.hL();
    long l3 = aqgz.hK();
    int i = (int)(ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication()) / this.sG);
    if (((String)localObject1).indexOf("?") == -1)
    {
      ((StringBuilder)localObject2).append("?screenWidth=").append((int)((float)l3 / this.sG)).append("&screenHeight=").append((int)((float)l2 / this.sG)).append("&statusBarHeight=").append(i).append("&screenDensity=").append(this.sG);
      if (!TextUtils.isEmpty(str1))
      {
        if (!str1.startsWith("&")) {
          break label550;
        }
        ((StringBuilder)localObject2).append(str1);
      }
      label273:
      if (!TextUtils.isEmpty(str2)) {
        ((StringBuilder)localObject2).append("&adtag=").append(str2);
      }
      if (!this.bFp) {
        break label567;
      }
      ((StringBuilder)localObject2).append("&openCapsule=1");
      ((StringBuilder)localObject2).append("&openBox=true");
    }
    for (;;)
    {
      if (((String)localObject1).indexOf("&_wv") < 0) {
        ((StringBuilder)localObject2).append("&_wv=").append(16777223L);
      }
      if (((String)localObject1).indexOf("&_wwv") < 0) {
        ((StringBuilder)localObject2).append("&_wwv=").append(520L);
      }
      ((StringBuilder)localObject2).append("&webviewOpenType=1");
      this.mUrl = ((StringBuilder)localObject2).toString();
      getIntent().putExtra("url", this.mUrl);
      this.s = ApolloWebViewFragment.class;
      super.doOnCreate(paramBundle);
      ApolloCardWindow.cFv();
      if (!afjy.a().ajq()) {
        afjy.a().a().doBindService(super.getApplicationContext());
      }
      this.mCreated = true;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloStoreActivity", 2, "apollo_client ApolloStoreActivity end create! use:" + (System.currentTimeMillis() - l1));
      }
      return false;
      ((StringBuilder)localObject2).append("&screenWidth=").append((int)((float)l3 / this.sG)).append("&screenHeight=").append((int)((float)l2 / this.sG)).append("&statusBarHeight=").append(i).append("&screenDensity=").append(this.sG);
      break;
      label550:
      ((StringBuilder)localObject2).append("&").append(str1);
      break label273;
      label567:
      ((StringBuilder)localObject2).append("&openCapsule=0");
      ((StringBuilder)localObject2).append("&openBox=false");
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 4).edit();
    ((SharedPreferences.Editor)localObject).remove("apollo_store_watch_current_url");
    ((SharedPreferences.Editor)localObject).apply();
    if (this.jdField_a_of_type_Abtv != null) {
      this.jdField_a_of_type_Abtv.onDestroy();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow.Ej(true);
    }
    this.b.removeCallbacksAndMessages(null);
    localObject = getAppInterface();
    if (localObject != null) {
      ((AppInterface)localObject).removeHandler(ApolloStoreActivity.class);
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    long l1 = aqgz.hL();
    long l2 = aqgz.hK();
    Object localObject2 = paramIntent.getStringExtra("url");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = super.getIntent().getStringExtra("url");
    }
    String str = paramIntent.getStringExtra("extra_key_url_append");
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (TextUtils.isEmpty(abxi.bju)) {
        localObject2 = abxi.bjj;
      }
    }
    else
    {
      int i = (int)(ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication()) / this.sG);
      this.mUrl = ((String)localObject2 + "&screenWidth=" + (int)((float)l2 / this.sG) + "&screenHeight=" + (int)((float)l1 / this.sG) + "&statusBarHeight=" + i + "&screenDensity=" + this.sG);
      if (!TextUtils.isEmpty(str)) {
        if (!str.startsWith("&")) {
          break label371;
        }
      }
    }
    label371:
    for (this.mUrl += str;; this.mUrl = (this.mUrl + "&" + str))
    {
      if (!this.mUrl.contains("tab")) {
        this.mUrl += "&tab=mall";
      }
      if (this.mUrl.indexOf("&_wv") < 0) {
        this.mUrl = (this.mUrl + "&_wv=" + 16777223L);
      }
      if (this.mUrl.indexOf("&_wwv") < 0) {
        this.mUrl = (this.mUrl + "&_wwv=" + 520L);
      }
      paramIntent.putExtra("url", this.mUrl);
      super.doOnNewIntent(paramIntent);
      return;
      localObject2 = abxi.bju;
      break;
    }
  }
  
  public void du(ArrayList<String> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloStoreActivity", 2, "[destoryAvatar]");
    }
    if (this.jdField_a_of_type_Abtv != null) {
      this.jdField_a_of_type_Abtv.du(paramArrayList);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 257: 
    default: 
    case 255: 
    case 256: 
      WebViewFragment localWebViewFragment;
      do
      {
        do
        {
          return false;
        } while (this.mRootView == null);
        if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow = new ApolloCardWindow(this.mRootView.getContext());
          paramMessage = new RelativeLayout.LayoutParams(-1, -1);
          this.mRootView.addView(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow, paramMessage);
        }
        while (this.bFp)
        {
          paramMessage = getAppInterface();
          if (paramMessage == null) {
            break;
          }
          if (TextUtils.isEmpty(this.bhD)) {
            this.bhD = paramMessage.getCurrentAccountUin();
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow.a(this.mRootView, this.bhD, this.bhC, paramMessage, this);
          return false;
          this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow.bringToFront();
        }
        localWebViewFragment = c();
      } while ((localWebViewFragment == null) || (localWebViewFragment.j == null) || (!(paramMessage.obj instanceof String)));
      String str = (String)paramMessage.obj;
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("result", paramMessage.arg1);
        localWebViewFragment.j.callJs(str + "(" + localJSONObject.toString() + ");");
        return false;
      }
      catch (Throwable paramMessage)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloStoreActivity", 2, "[save img] json null");
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramMessage = new StringBuilder().append("recv refresh apollo view msf, apolloView is null: ");
      if (this.jdField_a_of_type_Abtv != null) {
        break label368;
      }
    }
    label368:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("ApolloStoreActivity", 2, bool);
      if ((!ApolloEngine.BJ()) || (this.mRootView == null) || (this.jdField_a_of_type_Abtv != null)) {
        break;
      }
      this.jdField_a_of_type_Abtv = new abtv(this.mRootView, this);
      this.jdField_a_of_type_Abtv.a(this);
      return false;
    }
  }
  
  public String iH(String paramString)
  {
    if ((this.mRootView == null) || (TextUtils.isEmpty(paramString))) {
      return "{\"result\":1,\"msg\":\"uin是空\"}";
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow = new ApolloCardWindow(this);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.mRootView.addView(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow, localLayoutParams);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow.a(this.mRootView, paramString, "store", getAppInterface(), this);
      Eh(false);
      return "{\"result\":0,\"msg\":\"\"}";
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow.bringToFront();
    }
  }
  
  public String iI(String paramString)
  {
    if (this.jdField_a_of_type_Abtv == null) {}
    ApolloTextureView localApolloTextureView;
    do
    {
      return "";
      localApolloTextureView = this.jdField_a_of_type_Abtv.b();
      if (localApolloTextureView != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloStoreActivity", 2, "[saveImage] failed view null");
    return "";
    long l = System.currentTimeMillis();
    ThreadManager.executeOnSubThread(new ApolloStoreActivity.3(this, localApolloTextureView.getBitmap(), l, paramString));
    return "";
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean jA(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_Abtv != null) {
        this.jdField_a_of_type_Abtv.Ei(true);
      }
      Intent localIntent = new Intent(this, ApolloDiyTextFragment.class);
      localIntent.putExtra("extra_key_last_text", paramString);
      localIntent.putExtra("public_fragment_window_feature", 1);
      PublicTransFragmentActivity.startForResult(this, localIntent, ApolloDiyTextFragment.class, 1);
      return true;
    }
    catch (Exception paramString)
    {
      QLog.e("ApolloStoreActivity", 1, paramString.getMessage());
    }
    return false;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.mAttached = true;
    cFg();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloStoreActivity", 2, "onConfigurationChanged orientation:" + paramConfiguration.orientation);
    }
  }
  
  public void onNotifyLongTouch(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloStoreActivity", 2, "onNotifyLongTouch:" + paramString);
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(this.mApolloId))) {
      Id(0);
    }
  }
  
  public void onNotifyStatusChanged(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloStoreActivity", 2, new Object[] { "[onNotifyStatusChanged] status=", Integer.valueOf(paramInt), ", apolloId=", paramString });
    }
    if (7 == paramInt) {
      Id(1);
    }
    for (;;)
    {
      return;
      WebViewFragment localWebViewFragment = c();
      if ((localWebViewFragment != null) && (localWebViewFragment.j != null))
      {
        if (!TextUtils.isEmpty(paramString)) {
          break label100;
        }
        localWebViewFragment.j.callJs("window.apollo && window.apollo.controller && window.apollo.controller.hitAvatar && window.apollo.controller.hitAvatar();");
      }
      while (QLog.isColorLevel())
      {
        QLog.d("ApolloStoreActivity", 2, "apollo.controller.hitAvatar()");
        return;
        label100:
        localWebViewFragment.j.callJs(String.format("window.apollo && window.apollo.controller && window.apollo.controller.hitAvatar && window.apollo.controller.hitAvatar('%s');", new Object[] { paramString }));
      }
    }
  }
  
  public void onSurfaceReady(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloStoreActivity", 2, "Avatar view is Ready.");
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (this.sw))
    {
      this.sw = false;
      cFk();
    }
  }
  
  public String p(ArrayList<ApolloWebAvatarParam> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloStoreActivity", 2, new Object[] { "[updateAvatar] avatarParams=", paramArrayList });
    }
    if (this.jdField_a_of_type_Abtv != null) {
      return this.jdField_a_of_type_Abtv.p(paramArrayList);
    }
    return "{\"result\":1, \"msg\": \"终端发生错误\" }";
  }
  
  public void q(String paramString, Bundle paramBundle)
  {
    Object localObject = c();
    if ((localObject == null) || (((WebViewFragment)localObject).j == null)) {}
    do
    {
      do
      {
        do
        {
          return;
          localObject = ((WebViewFragment)localObject).j.getPluginEngine();
        } while (localObject == null);
        localObject = (ApolloJsPlugin)((WebViewPluginEngine)localObject).b("apollo");
      } while (localObject == null);
      ((ApolloJsPlugin)localObject).mReqBundle.clear();
      if (paramBundle != null) {
        ((ApolloJsPlugin)localObject).mReqBundle = paramBundle;
      }
      ((ApolloJsPlugin)localObject).sendRemoteReq(affz.a(paramString, "", ((ApolloJsPlugin)localObject).getRemoteKey(), ((ApolloJsPlugin)localObject).mReqBundle), false, true);
    } while (!QLog.isColorLevel());
    QLog.d("ApolloStoreActivity", 2, "[doIPCRequest], cmd" + paramString);
  }
  
  public String rk()
  {
    getCurrentAccountUin();
    if (this.jdField_a_of_type_Abtv != null) {
      return this.jdField_a_of_type_Abtv.rl();
    }
    return "{\"result\":1,\"msg\":\"ApolloViewController not init\"}";
  }
  
  public boolean showPreview()
  {
    super.showPreview();
    super.setImmersiveStatus();
    if (this.mSystemBarComp != null)
    {
      this.mSystemBarComp.init();
      int i = super.getResources().getColor(2131167361);
      this.mSystemBarComp.setStatusColor(i);
      this.mSystemBarComp.setStatusBarColor(i);
    }
    return true;
  }
  
  public void w(RelativeLayout paramRelativeLayout)
  {
    if ((paramRelativeLayout != null) && (this.mRootView == null))
    {
      this.mRootView = paramRelativeLayout;
      if ((this.mRootView != null) && (this.jdField_a_of_type_Abtv == null))
      {
        if (!ApolloEngine.BJ()) {
          break label65;
        }
        this.jdField_a_of_type_Abtv = new abtv(this.mRootView, this);
        this.jdField_a_of_type_Abtv.a(this);
      }
    }
    for (;;)
    {
      cFg();
      return;
      label65:
      paramRelativeLayout = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
      if (paramRelativeLayout != null) {
        paramRelativeLayout.setHandler(ApolloStoreActivity.class, this.b);
      }
      ThreadManager.postImmediately(new ApolloStoreActivity.1(this), null, true);
    }
  }
  
  public static class ApolloWebViewFragment
    extends WebViewFragment
    implements Handler.Callback
  {
    private long Os;
    private long Ot;
    private String YP;
    private MqqHandler b = new aurf(Looper.getMainLooper(), this);
    
    public boolean handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        return true;
        if ((getActivity() != null) && ((getActivity() instanceof ApolloStoreActivity)) && (this.Ot == 0L)) {
          ApolloStoreActivity.a((ApolloStoreActivity)getActivity());
        }
        if (QLog.isColorLevel()) {
          QLog.d("WebLog_WebViewFragment_apollo_store_stability_", 2, "handleMessage. MSG_CODE_CHECK_PAGE_LOAD_TIMEOUT");
        }
      }
    }
    
    public void onClick(View paramView)
    {
      if ((paramView == this.jdField_a_of_type_Aqzl.leftView) && ((getActivity() instanceof ApolloStoreActivity))) {
        ((ApolloStoreActivity)getActivity()).cFh();
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        super.onClick(paramView);
      }
    }
    
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
      paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
      if ((getActivity() instanceof ApolloStoreActivity)) {
        ((ApolloStoreActivity)getActivity()).w(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer);
      }
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
    }
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      super.onPageFinished(paramWebView, paramString);
      this.b.removeMessages(1);
      this.Ot = System.currentTimeMillis();
      int i = (int)(this.Ot - this.Os);
      if ((getActivity() != null) && ((getActivity() instanceof ApolloStoreActivity))) {
        ApolloStoreActivity.a((ApolloStoreActivity)getActivity(), i);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloStoreActivity_apollo_store_stability_", 2, new Object[] { "onPageFinished total cost:", Integer.valueOf(i), " url:", paramString });
      }
    }
    
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      super.onPageStarted(paramWebView, paramString, paramBitmap);
      this.Os = System.currentTimeMillis();
      this.Ot = 0L;
      this.b.removeMessages(1);
      long l = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 4).getLong("SP_KEY_APOLLO_STORE_PAGE_LOAD_TIMEOUT_VALUE", 15000L);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloStoreActivity", 2, new Object[] { "page load timeout value is:", Long.valueOf(l) });
      }
      this.b.sendEmptyMessageDelayed(1, l);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloStoreActivity", 2, "onPageStarted url:" + paramString);
      }
      if ((getActivity() instanceof ApolloStoreActivity))
      {
        paramWebView = (ApolloStoreActivity)getActivity();
        if ((this.YP != null) && (!this.YP.equals(paramString)) && (ApolloStoreActivity.a(paramWebView) != null)) {
          ApolloStoreActivity.a(paramWebView).cFp();
        }
        ApolloStoreActivity.a(paramWebView, paramString);
        paramWebView = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 4).edit();
        paramWebView.putString("apollo_store_watch_current_url", paramString);
        paramWebView.apply();
      }
      this.YP = paramString;
    }
    
    public int s(Bundle paramBundle)
    {
      int i = super.s(paramBundle);
      this.jdField_a_of_type_Aqzl.aK.setClickable(false);
      this.jdField_a_of_type_Aqzl.aK.setOnTouchListener(null);
      this.jdField_a_of_type_Aqzl.leftView.setVisibility(8);
      if (getActivity() != null) {
        ImmersiveUtils.clearCoverForStatus(getActivity().getWindow(), true);
      }
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloStoreActivity
 * JD-Core Version:    0.7.0.1
 */