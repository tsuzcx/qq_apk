package cooperation.comic.ui;

import aeay;
import aebs;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import aqzl;
import araz;
import arbt;
import arcd;
import arcd.a;
import arhz;
import avcv;
import avdd;
import avdn;
import avdq;
import avdr;
import avds;
import avdt;
import avdz;
import aveb;
import avej;
import ayxa;
import com.tencent.beacon.event.UserAction;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.comic.webbundle.WebBundleFragment;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
import rwt;
import svi;

public class QQComicFragment
  extends WebViewFragment
{
  private avdn a;
  private long azt;
  
  private String M(String paramString1, String paramString2, String paramString3)
  {
    return String.format("%s=%s; PATH=/; DOMAIN=.%s; Max-Age=31556926;", new Object[] { paramString1, paramString2, paramString3 });
  }
  
  public static WebViewFragment b(Intent paramIntent)
  {
    if (Boolean.valueOf(paramIntent.getBooleanExtra("openWithWebBundle", false)).booleanValue()) {
      localObject1 = new WebBundleFragment();
    }
    for (;;)
    {
      Object localObject2 = new Bundle();
      ((Bundle)localObject2).putParcelable("intent", paramIntent);
      ((WebViewFragment)localObject1).setArguments((Bundle)localObject2);
      int i = paramIntent.getIntExtra("reportSourceFrom", 0);
      if (i != 0) {
        localObject2 = paramIntent.getStringExtra("url");
      }
      try
      {
        localObject2 = new URL((String)localObject2);
        avcv.cJt = ((URL)localObject2).getPath().substring(((URL)localObject2).getPath().lastIndexOf("/") + 1);
        avcv.cJs = i + "";
        if ((TextUtils.isEmpty(avcv.cJs)) || ("NULL".equalsIgnoreCase(avcv.cJs))) {
          QLog.e("WebLog_WebViewFragment", 1, "[webFragment] from is null");
        }
        for (;;)
        {
          avcv.actionId = paramIntent.getStringExtra("reportActionFrom");
          avcv.ezv();
          return localObject1;
          localObject1 = new QQComicFragment();
          break;
          if (QLog.isColorLevel()) {
            QLog.d("WebLog_WebViewFragment", 2, "[webFragment] from is " + avcv.cJs);
          }
        }
        return localObject1;
      }
      catch (Exception paramIntent) {}
    }
  }
  
  private void ezA()
  {
    long l = System.currentTimeMillis();
    CookieManager localCookieManager = CookieManager.getInstance();
    String str1 = UserAction.getQIMEI();
    if (str1.isEmpty()) {
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "the qimei is null");
      }
    }
    while (localCookieManager == null) {
      return;
    }
    String str2 = localCookieManager.getCookie(this.mUrl);
    if (str2 != null)
    {
      if (str2.contains("qimei="))
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebLog_WebViewFragment", 2, "the cookie has qimei!");
        }
        QLog.i("WebLog_WebViewFragment", 1, "get qimei cost: " + (System.currentTimeMillis() - l));
        return;
      }
      str1 = M("qimei", str1, "vip.qq.com");
      QLog.d("WebLog_WebViewFragment", 4, "new cookie:" + str1);
      if ((this.mUrl != null) && (!this.mUrl.isEmpty())) {
        localCookieManager.setCookie(this.mUrl, str1);
      }
      ezB();
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "cookieManager sync after cookie is " + localCookieManager.getCookie(this.mUrl));
      }
    }
    for (;;)
    {
      QLog.i("WebLog_WebViewFragment", 1, "set qimei cost: " + (System.currentTimeMillis() - l));
      return;
      QLog.e("WebLog_WebViewFragment", 1, "cookie is null");
    }
  }
  
  private void ezB()
  {
    try
    {
      QLog.d("WebLog_WebViewFragment", 1, "[cookie] sync cookie.");
      CookieSyncManager.getInstance().sync();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      if (this.mApp.getApp() != null)
      {
        CookieSyncManager.createInstance(this.mApp.getApp());
        CookieSyncManager.getInstance().sync();
        QLog.w("WebLog_WebViewFragment", 2, "sync failed, createInstance first");
        return;
      }
      QLog.w("WebLog_WebViewFragment", 2, "application is null");
      return;
    }
    catch (Exception localException)
    {
      QLog.e("WebLog_WebViewFragment", 1, "sync failed, encounter unexpected problem! ");
    }
  }
  
  private void ezC()
  {
    if ((getHostActivity() == null) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer == null)) {}
    for (;;)
    {
      return;
      ayxa.initLiuHaiProperty(getHostActivity());
      ayxa.enableNotch(getHostActivity());
      if (ayxa.sHasNotch)
      {
        if ((this.azt & 1L) == 1L) {}
        for (int i = ayxa.sNotchHeight; this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer.ce != null; i = 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer.ce.setPadding(0, i, 0, 0);
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer.ce.setBackgroundColor(-16777216);
          return;
        }
      }
    }
  }
  
  private void ezz() {}
  
  public void Tk(boolean paramBoolean)
  {
    super.Tk(paramBoolean);
    ezC();
  }
  
  public void Tl(boolean paramBoolean)
  {
    super.Tl(paramBoolean);
    ezC();
  }
  
  String[] X()
  {
    String[] arrayOfString = new String[5];
    Object localObject = a();
    if ((localObject != null) && (((avdn)localObject).a != null))
    {
      localObject = ((avdn)localObject).a.getReportData();
      if (localObject != null)
      {
        arrayOfString[0] = ((String)((HashMap)localObject).get("page_id"));
        arrayOfString[1] = ((String)((HashMap)localObject).get("obj_type"));
        arrayOfString[2] = ((String)((HashMap)localObject).get("ret_id"));
        arrayOfString[3] = ((String)((HashMap)localObject).get("ext2"));
        arrayOfString[4] = ((String)((HashMap)localObject).get("source"));
      }
    }
    return arrayOfString;
  }
  
  public int a(Bundle paramBundle)
  {
    ezC();
    return super.a(paramBundle);
  }
  
  public araz a()
  {
    return new araz(this, 127, new avds(this));
  }
  
  public avdn a()
  {
    if (this.jdField_a_of_type_Avdn != null) {
      return this.jdField_a_of_type_Avdn;
    }
    if ((getWebView() != null) && (getWebView().getPluginEngine() != null))
    {
      WebViewPlugin localWebViewPlugin = getWebView().getPluginEngine().b("comic");
      if ((localWebViewPlugin instanceof avdn))
      {
        this.jdField_a_of_type_Avdn = ((avdn)localWebViewPlugin);
        return this.jdField_a_of_type_Avdn;
      }
    }
    return null;
  }
  
  public boolean aKw()
  {
    avdn localavdn = a();
    JSONObject localJSONObject1;
    if (localavdn != null)
    {
      localavdn = (avdn)localavdn;
      localJSONObject1 = new JSONObject();
    }
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("status", localavdn.ct.get());
      localJSONObject1.put("data", localJSONObject2);
      label54:
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "notifySecretModeChange. status=" + localavdn.ct.get());
      }
      if (!TextUtils.isEmpty(localavdn.cJV)) {
        getWebView().callJs(localavdn.cJV, new String[] { localJSONObject1.toString() });
      }
      return true;
    }
    catch (Exception localException)
    {
      break label54;
    }
  }
  
  public String getUAMark()
  {
    return "VipComic";
  }
  
  public void initWebView()
  {
    super.initWebView();
    ezA();
  }
  
  public void ks(int paramInt1, int paramInt2)
  {
    int i = 0;
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      i = ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication());
    }
    int j = paramInt1;
    int k = paramInt2;
    if (!this.jdField_a_of_type_Arcd.jdField_a_of_type_Arcd$a.cYl)
    {
      if (!this.jdField_a_of_type_Arcd$a.cYw) {
        break label60;
      }
      k = paramInt2;
      j = paramInt1;
    }
    for (;;)
    {
      super.ks(j, k);
      return;
      label60:
      j = paramInt1;
      k = paramInt2;
      if ((this.azt & 1L) == 1L)
      {
        j = paramInt1;
        k = paramInt2;
        if (ayxa.sHasNotch)
        {
          k = paramInt2 - i;
          j = paramInt1 - i;
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (((paramView == this.jdField_a_of_type_Aqzl.rightViewImg) || (paramView == this.jdField_a_of_type_Aqzl.rightHighLView)) && (this.jdField_a_of_type_Aqzl.cXl))
    {
      this.jdField_a_of_type_Aqzl.Tf(false);
      if ((this.browserApp != null) && (this.browserApp.getApp() != null)) {
        this.browserApp.getApp().getSharedPreferences("boodo_" + this.browserApp.getCurrentAccountUin(), 0).edit().putBoolean("private_read_red_dot", true).apply();
      }
    }
    super.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = this.intent.getParcelableExtra("defaultResultData");
    if ((paramBundle instanceof Intent)) {
      getActivity().setResult(0, (Intent)paramBundle);
    }
    ezz();
    avcv.t(this.mApp);
    avcv.gi(getHostActivity());
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    QLog.d("WebLog_WebViewFragment", 4, "QQComicFragment onPageFinished ");
    if (aveb.a != null)
    {
      QLog.d("WebLog_WebViewFragment", 4, "QQComicPluginBridge sFirstInObservable is not null ");
      aveb.a.gk(paramWebView.getContext());
    }
    aveb.h(new avdr(this, paramWebView));
  }
  
  public void onStop()
  {
    super.onStop();
    avdn localavdn = a();
    if (localavdn != null) {
      localavdn.ezy();
    }
  }
  
  public int p(Bundle paramBundle)
  {
    try
    {
      if ((this.mUrl != null) && (this.azt == 0L))
      {
        QLog.d("WebLog_WebViewFragment", 2, new Object[] { "dealWithWvx: url=", this.mUrl });
        String str = Uri.parse(this.mUrl).getQueryParameter("_wvx");
        if (str != null) {
          this.azt = Long.parseLong(str, 10);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("WebLog_WebViewFragment", 2, "dealWithWvx: ", localException);
      }
    }
    return super.p(paramBundle);
  }
  
  public class a
    extends arbt
  {
    public a() {}
    
    private void a(aeay paramaeay, QQBrowserActivity paramQQBrowserActivity)
    {
      Object localObject1 = "";
      Object localObject2 = "";
      Object localObject3 = this.jdField_a_of_type_CooperationComicUiQQComicFragment.getString(2131690945);
      avdn localavdn = this.jdField_a_of_type_CooperationComicUiQQComicFragment.a();
      if (localavdn != null)
      {
        localObject1 = localavdn.cJX;
        localObject2 = localavdn.cJY;
      }
      if ((((String)localObject1).isEmpty()) && (this.jdField_a_of_type_CooperationComicUiQQComicFragment.a != null)) {
        if (!this.jdField_a_of_type_CooperationComicUiQQComicFragment.a.getTitle().isEmpty()) {
          localObject1 = this.jdField_a_of_type_CooperationComicUiQQComicFragment.a.getTitle();
        }
      }
      for (;;)
      {
        if (((String)localObject2).isEmpty()) {
          if (((String)localObject1).equals(localObject3)) {
            localObject2 = paramQQBrowserActivity.getOriginalUrl();
          }
        }
        for (;;)
        {
          for (;;)
          {
            localObject3 = paramQQBrowserActivity.getOriginalUrl();
            paramQQBrowserActivity = avej.N(avej.O((String)localObject3, "from", "1041001"), "from", "1041001");
            if (QLog.isColorLevel()) {
              QLog.d("WebLog_WebViewFragment", 2, "originalUrl is " + (String)localObject3 + " ,newUrl is " + paramQQBrowserActivity);
            }
            localObject3 = new JSONObject();
            try
            {
              ((JSONObject)localObject3).put("colorNoteType", 2);
              if (QLog.isColorLevel()) {
                QLog.d("WebLog_WebViewFragment", 2, "ColorNote mainTitle is " + (String)localObject1 + ",subTitle is " + (String)localObject2 + ",subType is " + paramQQBrowserActivity);
              }
              paramaeay.setServiceInfo(new avdt(this, paramQQBrowserActivity, (String)localObject1, (String)localObject2, ((JSONObject)localObject3).toString().getBytes()));
              return;
              localObject1 = localObject3;
              break;
              localObject2 = localObject3;
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
      }
    }
    
    private void ezD()
    {
      QQBrowserActivity localQQBrowserActivity = (QQBrowserActivity)this.s;
      aeay localaeay = localQQBrowserActivity.getColorNoteController();
      if (localaeay != null)
      {
        if (localaeay.isColorNoteExist()) {
          break label45;
        }
        if (localaeay.canAddColorNote())
        {
          localaeay.insertColorNote();
          localQQBrowserActivity.finish();
        }
      }
      else
      {
        return;
      }
      localaeay.onCannotAdd();
      return;
      label45:
      localaeay.deleteColorNote();
    }
    
    public List<ShareActionSheetBuilder.ActionSheetItem>[] a()
    {
      ArrayList localArrayList1 = new ArrayList();
      Object localObject = this.jdField_a_of_type_CooperationComicUiQQComicFragment.X();
      String str1 = localObject[0];
      String str2 = localObject[1];
      String str3 = localObject[2];
      String str4 = localObject[3];
      String str5 = localObject[4];
      avdd.b(this.jdField_a_of_type_CooperationComicUiQQComicFragment.mApp, str1, str2, str3, "6", str4, str5);
      if ((this.gK & 0x8) == 0L)
      {
        localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
        avdd.b(this.jdField_a_of_type_CooperationComicUiQQComicFragment.mApp, str1, str2, str3, "1", str4, str5);
      }
      if ((this.gK & 0x10) == 0L)
      {
        localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
        avdd.b(this.jdField_a_of_type_CooperationComicUiQQComicFragment.mApp, str1, str2, str3, "2", str4, str5);
      }
      boolean bool = WXShareHelper.a().isWXinstalled();
      if (((this.gK & 0x4000) == 0L) && (bool))
      {
        localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
        avdd.b(this.jdField_a_of_type_CooperationComicUiQQComicFragment.mApp, str1, str2, str3, "3", str4, str5);
      }
      if (((this.gK & 0x8000) == 0L) && (bool))
      {
        localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
        avdd.b(this.jdField_a_of_type_CooperationComicUiQQComicFragment.mApp, str1, str2, str3, "4", str4, str5);
      }
      ArrayList localArrayList2 = new ArrayList();
      if ((this.gK & 0x2000) == 0L)
      {
        localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(14));
        avdd.c(this.jdField_a_of_type_CooperationComicUiQQComicFragment.mApp, str1, str2, str3, "1", str4, str5);
      }
      avdn localavdn = this.jdField_a_of_type_CooperationComicUiQQComicFragment.a();
      int i;
      int j;
      if ((localavdn != null) && (localavdn.ct.get() >= 0))
      {
        if (localavdn.ct.get() != 1) {
          break label646;
        }
        i = 1;
        if (i == 0) {
          break label651;
        }
        j = 117;
        label368:
        localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(j));
        if (i == 0) {
          break label657;
        }
      }
      label646:
      label651:
      label657:
      for (localObject = "5";; localObject = "4")
      {
        avdd.c(this.jdField_a_of_type_CooperationComicUiQQComicFragment.mApp, str1, str2, str3, (String)localObject, str4, str5);
        localObject = (QQBrowserActivity)this.s;
        String str6 = ((QQBrowserActivity)localObject).getOriginalUrl();
        if ((str6 != null) && (str6.indexOf("cancelColorTab=1") == -1))
        {
          aeay localaeay = ((QQBrowserActivity)localObject).getColorNoteController();
          a(localaeay, (QQBrowserActivity)localObject);
          if ((localaeay != null) && (localaeay.shouldDisplayColorNote()) && (!aebs.lt(str6)))
          {
            i = 70;
            localObject = "2";
            if (localaeay.isColorNoteExist())
            {
              i = 82;
              localObject = "3";
            }
            localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(i));
            avdd.c(this.jdField_a_of_type_CooperationComicUiQQComicFragment.mApp, str1, str2, str3, (String)localObject, str4, str5);
          }
        }
        if ((localavdn != null) && ((localavdn.type & 0x2) > 0))
        {
          localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(11));
          avdd.c(this.jdField_a_of_type_CooperationComicUiQQComicFragment.mApp, str1, str2, str3, "9", str4, str5);
        }
        if ((localavdn != null) && ((localavdn.type & 0x1) > 0))
        {
          localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(40));
          avdd.c(this.jdField_a_of_type_CooperationComicUiQQComicFragment.mApp, str1, str2, str3, "10", str4, str5);
        }
        return (List[])new ArrayList[] { localArrayList1, localArrayList2 };
        i = 0;
        break;
        j = 116;
        break label368;
      }
    }
    
    public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
      int j = paramActionSheetItem.action;
      paramShareActionSheet = getShareUrl();
      Object localObject = this.jdField_a_of_type_CooperationComicUiQQComicFragment.X();
      String str1 = localObject[0];
      String str2 = localObject[1];
      String str3 = localObject[2];
      String str4 = localObject[3];
      localObject = localObject[4];
      if ((j == 2) || (j == 73)) {
        if (TextUtils.isEmpty(this.b.aHg)) {
          this.b.a(paramShareActionSheet, 1, false);
        }
      }
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              this.b.g(paramShareActionSheet, 1, false);
              return;
              if (j == 3)
              {
                if (TextUtils.isEmpty(this.b.aHg))
                {
                  this.b.a(paramShareActionSheet, 2, false);
                  return;
                }
                this.b.g(paramShareActionSheet, 2, false);
                return;
              }
              if ((j == 9) || (j == 10))
              {
                int i = -1;
                if (!WXShareHelper.a().isWXinstalled()) {
                  i = 2131721935;
                }
                while (i != -1)
                {
                  rwt.ez(0, i);
                  return;
                  if (!WXShareHelper.a().isWXsupportApi()) {
                    i = 2131721936;
                  }
                }
                if (j == 9)
                {
                  if (TextUtils.isEmpty(this.b.aHg))
                  {
                    this.b.a(paramShareActionSheet, 3, true);
                    return;
                  }
                  this.b.g(paramShareActionSheet, 3, true);
                  return;
                }
                if (TextUtils.isEmpty(this.b.aHg))
                {
                  this.b.a(paramShareActionSheet, 4, true);
                  return;
                }
                this.b.g(paramShareActionSheet, 4, true);
                return;
              }
              if (j != 14) {
                break;
              }
            } while (TextUtils.isEmpty(this.b.aHg));
            this.jdField_a_of_type_CooperationComicUiQQComicFragment.getWebView().callJs(this.b.aHg, new String[] { "6" });
            avdd.d(this.jdField_a_of_type_CooperationComicUiQQComicFragment.mApp, str1, str2, str3, "1", str4, (String)localObject);
            return;
            if (j == 117)
            {
              avdd.d(this.jdField_a_of_type_CooperationComicUiQQComicFragment.mApp, str1, str2, str3, "5", str4, (String)localObject);
              this.jdField_a_of_type_CooperationComicUiQQComicFragment.aKw();
              return;
            }
            if (j == 116)
            {
              avdd.d(this.jdField_a_of_type_CooperationComicUiQQComicFragment.mApp, str1, str2, str3, "4", str4, (String)localObject);
              this.jdField_a_of_type_CooperationComicUiQQComicFragment.aKw();
              return;
            }
            if (j == 70)
            {
              avdd.d(this.jdField_a_of_type_CooperationComicUiQQComicFragment.mApp, str1, str2, str3, "2", str4, (String)localObject);
              ezD();
              return;
            }
            if (j == 82)
            {
              avdd.d(this.jdField_a_of_type_CooperationComicUiQQComicFragment.mApp, str1, str2, str3, "3", str4, (String)localObject);
              ezD();
              return;
            }
            if (j != 72) {
              break;
            }
            if (this.ba == null) {
              this.ba = new Bundle();
            }
            this.ba.putString("to_qq", paramActionSheetItem.uin);
            this.ba.putString("to_uin_name", paramActionSheetItem.label);
            this.ba.putInt("to_uin_type", paramActionSheetItem.uinType);
            if (TextUtils.isEmpty(this.b.aHg))
            {
              this.b.a(paramShareActionSheet, 1, false);
              return;
            }
          } while (this.b.a == null);
          this.b.b().show();
          this.b.a.callJs(this.b.aHg, new String[] { String.valueOf(101) });
          return;
          if (j != 40) {
            break;
          }
        } while (TextUtils.isEmpty(this.b.aHg));
        avdd.d(this.jdField_a_of_type_CooperationComicUiQQComicFragment.mApp, str1, str2, str3, "10", str4, (String)localObject);
        this.jdField_a_of_type_CooperationComicUiQQComicFragment.getWebView().callJs(this.b.aHg, new String[] { "7" });
        return;
      } while ((j != 11) || (TextUtils.isEmpty(this.b.aHg)));
      avdd.d(this.jdField_a_of_type_CooperationComicUiQQComicFragment.mApp, str1, str2, str3, "9", str4, (String)localObject);
      this.jdField_a_of_type_CooperationComicUiQQComicFragment.getWebView().callJs(this.b.aHg, new String[] { "8" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.comic.ui.QQComicFragment
 * JD-Core Version:    0.7.0.1
 */