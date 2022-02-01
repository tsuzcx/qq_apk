package com.tencent.mobileqq.activity;

import acbn;
import acfp;
import aduk;
import aeif;
import aeob;
import aeoc;
import aetp;
import aetq;
import aeuj;
import aeuk;
import affz;
import afjy;
import ahbj;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aoao;
import aobh;
import aobm;
import aobu;
import aobw;
import aoca;
import aocb;
import aocc;
import aodb;
import aqfx;
import aqfy;
import aqgv;
import aqhq;
import aqhu;
import aqiw;
import aqzl;
import araz;
import arbf;
import arbs;
import arbt;
import arbz;
import arcd;
import arcd.a;
import arcn.a;
import arcp;
import auru;
import ausj;
import auss;
import avqq;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.GifDrawable;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.photo.CameraPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.Client.b;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.teamwork.SharePolicyInfo;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.webview.sonic.SonicClientImpl;
import com.tencent.mobileqq.webview.swift.SwiftReuseTouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import ilp;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jqc;
import jqo;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import org.json.JSONException;
import org.json.JSONObject;
import svi;
import vws;
import vwt;
import vwu;
import vwv;
import vww;
import vwx;
import vwy;
import vwz;
import vxa;
import vxb;
import wja;

public class TeamWorkDocEditBrowserActivity
  extends QQBrowserActivity
{
  public AppInterface mApp;
  
  public TeamWorkDocEditBrowserActivity()
  {
    this.s = TeamWorkDocEditBrowserFragment.class;
  }
  
  public static Intent a(Intent paramIntent, String paramString, Context paramContext)
  {
    paramIntent.putExtra("title", " ");
    paramIntent.putExtra("hide_more_button", true);
    paramIntent.putExtra("webStyle", "noBottomBar");
    paramIntent.putExtra("isScreenOrientationPortrait", true);
    paramIntent.putExtra("url", paramString);
    paramIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    paramIntent.putExtra("big_brother_source_key", "biz_src_jc_xiaolv");
    return paramIntent;
  }
  
  public static void a(Context paramContext, Bundle paramBundle, boolean paramBoolean)
  {
    Object localObject3;
    Object localObject1;
    if (aqiw.isNetSupport(BaseApplication.getContext()))
    {
      localObject3 = paramBundle.getString("tdsourcetag");
      if (localObject3 != null)
      {
        localObject2 = paramBundle.getString("url");
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = localObject2;
          if (!((String)localObject2).contains("tdsourcetag")) {
            localObject1 = aobw.bD((String)localObject2, (String)localObject3);
          }
        }
        if (a(paramContext, (String)localObject1, (String)localObject3, paramBundle.getBoolean("temp_preview_from_qq")))
        {
          QLog.e("TeamWorkDocEditBrowserActivity", 2, "openDocsMiniApp");
          localObject1 = paramBundle.getString("tdsourcetag", "");
          if (((paramContext instanceof Activity)) && ((((String)localObject1).equals("s_QQ_file_share_edit")) || (((String)localObject1).equals("s_qq_file_edit"))))
          {
            QLog.d("TeamWorkDocEditBrowserActivity", 2, "openDocsMiniApp in TeamWorkDocEditBrowserActivity");
            ((Activity)paramContext).finish();
          }
          aobw.e(paramBundle, "0X8009ED7");
          return;
        }
      }
      aobw.e(paramBundle, "0X8009ED6");
      localObject3 = new Intent(paramContext, TeamWorkDocEditBrowserActivity.class);
      Object localObject2 = paramBundle.getString("url");
      i = paramBundle.getInt("key_team_work_edit_type");
      localObject1 = localObject2;
      Object localObject4;
      Object localObject5;
      if (aobw.pO((String)localObject2))
      {
        localObject1 = localObject2;
        if ((paramContext instanceof FragmentActivity))
        {
          localObject4 = (FragmentActivity)paramContext;
          localObject5 = ((FragmentActivity)localObject4).getChatFragment();
          localObject1 = localObject2;
          if (localObject5 != null)
          {
            localObject5 = ((ChatFragment)localObject5).a();
            localObject1 = localObject2;
            if (localObject5 != null)
            {
              String str = ((BaseChatPie)localObject5).sessionInfo.aTl;
              localObject1 = localObject2;
              if (!TextUtils.isEmpty((CharSequence)localObject2))
              {
                localObject1 = localObject2;
                if (!TextUtils.isEmpty(str)) {
                  if (((BaseChatPie)localObject5).sessionInfo.cZ != 0)
                  {
                    localObject1 = localObject2;
                    if (((BaseChatPie)localObject5).sessionInfo.cZ != 1) {}
                  }
                  else
                  {
                    localObject4 = aobw.c(((FragmentActivity)localObject4).app, str, ((BaseChatPie)localObject5).sessionInfo.cZ);
                    localObject1 = "?" + (String)localObject4;
                    if (((String)localObject2).contains("?")) {
                      localObject1 = "&" + (String)localObject4;
                    }
                    localObject1 = (String)localObject2 + (String)localObject1;
                  }
                }
              }
            }
          }
        }
      }
      if (paramBundle.getBoolean("temp_preview_from_qq")) {
        ((Intent)localObject3).putExtra("temp_preview_from_qq", true);
      }
      if (paramBundle.getParcelable("key_team_work_file_import_info") != null)
      {
        ((Intent)localObject3).putExtra("key_team_work_file_import_info", paramBundle.getParcelable("key_team_work_file_import_info"));
        if (((TeamWorkFileImportInfo)paramBundle.getParcelable("key_team_work_file_import_info")).cLa) {
          ((Intent)localObject3).putExtra("key_is_new_pad_flag", true);
        }
      }
      if (paramBundle.getBoolean("doc_from_aio", false))
      {
        ((Intent)localObject3).putExtra("doc_from_aio", true);
        if ((((Intent)localObject3).getBooleanExtra("doc_from_aio", false)) && ((paramContext instanceof FragmentActivity)))
        {
          localObject2 = (FragmentActivity)paramContext;
          localObject4 = ((FragmentActivity)localObject2).getChatFragment();
          if (localObject4 != null)
          {
            localObject4 = ((ChatFragment)localObject4).a();
            if (localObject4 != null)
            {
              localObject5 = ((BaseChatPie)localObject4).sessionInfo.aTl;
              int j = ((BaseChatPie)localObject4).sessionInfo.cZ;
              if ((!TextUtils.isEmpty((CharSequence)localObject5)) && (j != -1))
              {
                ((Intent)localObject3).putExtra("doc_from_aio_uin", (String)localObject5);
                ((Intent)localObject3).putExtra("doc_from_aio_peertype", j);
                ((Intent)localObject3).putExtra("doc_from_aio_nickname", aqgv.e(((FragmentActivity)localObject2).app, (String)localObject5, j));
              }
            }
          }
        }
        if (paramBundle.getBoolean("doc_from_forward_dialog", false)) {
          ((Intent)localObject3).putExtra("doc_from_forward_dialog", true);
        }
        if (paramBundle.getString("tdsourcetag") == null) {
          break label838;
        }
        localObject2 = paramBundle.getString("tdsourcetag");
        ((Intent)localObject3).putExtra("tdsourcetag", (String)localObject2);
        ((Intent)localObject3).putExtra("url", aobw.bD((String)localObject1, (String)localObject2));
        label670:
        ((Intent)localObject3).putExtra("key_team_work_edit_type", i);
        ((Intent)localObject3).putExtra("hide_more_button", true);
        ((Intent)localObject3).putExtra("webStyle", "noBottomBar");
        ((Intent)localObject3).putExtra("isScreenOrientationPortrait", true);
        ((Intent)localObject3).putExtra("title", " ");
        ((Intent)localObject3).putExtra("big_brother_source_key", "biz_src_jc_file");
        if (TextUtils.isEmpty(((Intent)localObject3).getStringExtra("big_brother_source_key"))) {
          ((Intent)localObject3).putExtra("big_brother_source_key", "biz_src_jc_xiaolv");
        }
        if (paramBundle.getBoolean("doc_from_forward_dialog", false)) {
          break label851;
        }
        i = 1;
        label762:
        if (i != 0) {
          ((Intent)localObject3).addFlags(603979776);
        }
        if ((!paramBoolean) || (!(paramContext instanceof Activity))) {
          break label895;
        }
      }
    }
    label838:
    label851:
    label895:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        ((Activity)paramContext).startActivityForResult((Intent)localObject3, 14001);
        return;
        if ((BaseActivity.sTopActivity == null) || (!(BaseActivity.sTopActivity instanceof SplashActivity)) || (SplashActivity.bKT != 2)) {
          break;
        }
        ((Intent)localObject3).putExtra("doc_from_aio", true);
        break;
        ((Intent)localObject3).putExtra("url", (String)localObject1);
        break label670;
        i = 0;
        break label762;
      }
      paramContext.startActivity((Intent)localObject3);
      return;
      QQToast.a(BaseApplication.getContext(), paramContext.getResources().getString(2131693404), 0).show(paramContext.getResources().getDimensionPixelSize(2131299627));
      return;
    }
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramString2 == null) || (paramContext == null)) {
      return false;
    }
    String str3 = (String)aobw.nK.get(paramString2);
    if (str3 == null) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TeamWorkDocEditBrowserActivity", 2, "openDocsMiniApp:configType " + str3);
    }
    paramString2 = (aeob)aeif.a().o(418);
    if (paramString2 == null) {
      return false;
    }
    paramString2 = (aeoc)paramString2.F().get(str3);
    if (paramString2 == null) {
      return false;
    }
    if (paramString2.ahr()) {}
    for (;;)
    {
      try
      {
        LaunchParam localLaunchParam = new LaunchParam();
        String str4 = paramString2.getAppid();
        String str2 = paramString2.getPath();
        String str1 = "";
        paramString2 = str2;
        Object localObject = str1;
        if (!str3.equals("docs_miniapp_config_templatelist"))
        {
          if (TextUtils.isEmpty(paramString1))
          {
            paramString2 = new StringBuilder().append(str2).append("?needSave=");
            if (!paramBoolean) {
              break label436;
            }
            paramString1 = "1";
            paramString2 = paramString1;
            localObject = str1;
          }
        }
        else
        {
          MiniAppLauncher.launchMiniAppById(paramContext, str4, paramString2, (String)localObject, null, null, 2012);
          if (!QLog.isColorLevel()) {
            break label434;
          }
          QLog.i("TeamWorkDocEditBrowserActivity", 2, "openDocsMiniApp:open :scene = " + localLaunchParam.scene + "miniAppId = " + localLaunchParam.miniAppId + "entryPath = " + localLaunchParam.entryPath + "navigateExtData = " + localLaunchParam.navigateExtData);
          break label434;
        }
        localObject = new StringBuilder().append(str2).append("?url=").append(URLEncoder.encode(paramString1, "utf-8")).append("&needSave=");
        if (paramBoolean)
        {
          paramString2 = "1";
          paramString2 = paramString2;
          localObject = "url=" + paramString1;
          continue;
        }
        paramString2 = "0";
        continue;
        return false;
      }
      catch (UnsupportedEncodingException paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TeamWorkDocEditBrowserActivity", 2, "openDocsMiniApp " + paramContext.getMessage());
        }
        if (TextUtils.equals(str3, "s_qq_mini_importing")) {
          aodb.aN(null, "0X800A4B5");
        }
      }
      label434:
      return true;
      label436:
      paramString1 = "0";
    }
  }
  
  public static boolean g(Context paramContext, String paramString1, String paramString2)
  {
    return a(paramContext, paramString1, paramString2, false);
  }
  
  public void BF(int paramInt)
  {
    WebViewFragment localWebViewFragment = c();
    if ((localWebViewFragment instanceof TeamWorkDocEditBrowserFragment)) {
      ((TeamWorkDocEditBrowserFragment)localWebViewFragment).BF(paramInt);
    }
  }
  
  public ArrayList<String> a(ArrayList<String> paramArrayList, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return paramArrayList;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    String str;
    label192:
    HashMap localHashMap;
    Object localObject3;
    if (i < paramArrayList.size())
    {
      str = (String)paramArrayList.get(i);
      if (ahbj.isFileExists(str))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TeamWorkDocEditBrowserActivity", 4, "local url:" + str);
        }
        if (ahbj.getFileSize(str) <= 5242880L) {
          break label452;
        }
        if (QLog.isColorLevel()) {
          QLog.d("TeamWorkDocEditBrowserActivity", 4, "file length:" + ahbj.getFileSize(str));
        }
        if ((paramInt != 0) || (GifDrawable.isGifFile(new File(str)))) {
          break label446;
        }
        localObject1 = avqq.c(str, i);
        if (localObject1 == null) {
          break label444;
        }
        str = ((File)localObject1).getAbsolutePath();
        localArrayList2.add(localObject1);
        localHashMap = new HashMap();
        localHashMap.put("Connection", "keep-alive");
        localHashMap.put("Referer", paramString4);
        localObject1 = (TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2);
        WebViewFragment localWebViewFragment = c();
        localObject3 = "";
        if (localWebViewFragment != null) {
          localObject3 = localWebViewFragment.getCurrentUrl();
        }
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          break label579;
        }
        if (!((String)localObject3).contains("docx.qq.com")) {
          break label455;
        }
      }
    }
    label444:
    label446:
    label452:
    label455:
    Object localObject2;
    label579:
    for (Object localObject1 = ((TicketManager)localObject1).getPskey(this.mApp.getCurrentAccountUin(), "docx.qq.com");; localObject2 = null)
    {
      for (;;)
      {
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = CookieManager.getInstance();
          if (localObject1 != null) {
            localHashMap.put("Cookie", ((CookieManager)localObject1).getCookie((String)localObject3));
          }
          localObject1 = new HashMap();
          ((Map)localObject1).put("type", paramString3);
          localObject3 = new HashMap();
          ((Map)localObject3).put("share_image", str);
          localObject1 = jqc.a(paramString4, paramString1, paramString2, (Map)localObject1, (Map)localObject3, localHashMap);
          if (localObject1 == null) {}
        }
        try
        {
          localObject1 = new JSONObject((String)localObject1).getString("url");
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            localArrayList1.add(localObject1);
          }
          i += 1;
          break;
          return null;
          if (paramInt == 2) {}
          break label192;
          if (!((String)localObject3).contains("docs.qq.com")) {
            break label579;
          }
          localObject1 = ((TicketManager)localObject1).getPskey(this.mApp.getCurrentAccountUin(), "docs.qq.com");
          continue;
          localHashMap.put("Cookie", "p_skey=" + (String)localObject1 + ";p_uin=" + this.mApp.getCurrentAccountUin() + ";skey=" + paramString2);
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("TeamWorkDocEditBrowserActivity", 4, localJSONException.getMessage());
            }
          }
        }
      }
      avqq.fr(localArrayList2);
      return localArrayList1;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mApp = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web"));
    return super.doOnCreate(paramBundle);
  }
  
  public void doOnStop()
  {
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
    super.doOnStop();
  }
  
  public static class TeamWorkDocEditBrowserFragment
    extends WebViewFragment
  {
    TextView FO = null;
    private boolean Wl;
    private aoao jdField_a_of_type_Aoao;
    private aocc jdField_a_of_type_Aocc;
    boolean aMX = false;
    private boolean aNr;
    private aduk b;
    public InputLinearLayout b;
    private int bKX = -1;
    public int bKY;
    public int bKZ;
    public int bLa;
    public int bLb = -1;
    private int bLc;
    public boolean baE = true;
    public boolean baF = true;
    public boolean baG;
    public boolean baH;
    private boolean baI;
    private boolean baJ;
    private boolean baK;
    private boolean baL = true;
    boolean baM = false;
    boolean baN = false;
    private boolean baO;
    private int bzk = -1000;
    Handler.Callback d = new vws(this);
    public Button dB;
    Handler.Callback e = new vwv(this);
    auru f;
    public RelativeLayout hg;
    public EditText mEditText;
    private boolean mEditable;
    ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener = new vwt(this);
    public int mKeyboardHeight;
    public String mRefer;
    public String mSelfUin;
    Handler mUIHandler;
    ImageView ri;
    ImageView rj;
    ImageView rk;
    private ImageView rl;
    SessionInfo sessionInfo = new SessionInfo();
    private View uS;
    String workId = "";
    
    private void BG(int paramInt)
    {
      if (getActivity() == null) {
        return;
      }
      String str1;
      String str2;
      Object localObject2;
      SharedPreferences localSharedPreferences;
      int i;
      switch (paramInt)
      {
      default: 
        str1 = "key_team_work_user_click_count";
        paramInt = aetq.a().Cv();
        str2 = aetq.a().tP();
        localObject2 = aetq.a().tQ();
        localObject1 = acfp.m(2131715200);
        localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("tim_convert_teamwork_pre_" + getActivity().getCurrentAccountUin(), 4);
        i = localSharedPreferences.getInt(str1, 0);
        if (i >= paramInt) {
          break label385;
        }
        if ((!TextUtils.isEmpty(str2)) || (!TextUtils.isEmpty((CharSequence)localObject2))) {
          break;
        }
      }
      for (Object localObject1 = getResources().getString(2131720966);; localObject1 = str2 + "\n" + (String)localObject2)
      {
        localObject2 = new Intent(getActivity(), DialogActivity.class);
        ((Intent)localObject2).addFlags(268435456);
        ((Intent)localObject2).addFlags(536870912);
        ((Intent)localObject2).addFlags(67108864);
        ((Intent)localObject2).addFlags(131072);
        ((Intent)localObject2).putExtra("key_dialog_type", DialogActivity.bGv);
        ((Intent)localObject2).putExtra("key_dialog_title", acfp.m(2131715139));
        ((Intent)localObject2).putExtra("key_dialog_content", (String)localObject1);
        ((Intent)localObject2).putExtra("key_teamwork_url", oZ());
        getActivity().startActivity((Intent)localObject2);
        report(20);
        localObject1 = localSharedPreferences.edit();
        ((SharedPreferences.Editor)localObject1).putInt(str1, i + 1);
        ((SharedPreferences.Editor)localObject1).commit();
        return;
        str1 = "key_team_work_user_click_count";
        paramInt = aetq.a().Cv();
        str2 = aetq.a().tR();
        localObject2 = aetq.a().tS();
        localObject1 = acfp.m(2131715151);
        break;
        str1 = "key_team_work_content_edit_click_count";
        paramInt = aetq.a().Cw();
        str2 = aetq.a().tT();
        localObject2 = aetq.a().tU();
        localObject1 = acfp.m(2131715150);
        break;
      }
      label385:
      QQToast.a(getActivity(), (CharSequence)localObject1, 0).show(getActivity().getResources().getDimensionPixelSize(2131299627));
    }
    
    private void a(int paramInt, String paramString, ImageView paramImageView)
    {
      if ((paramImageView == null) || (TextUtils.isEmpty(paramString))) {
        return;
      }
      switch (paramInt)
      {
      default: 
        paramInt = -1;
      }
      for (;;)
      {
        if (paramInt != -1) {
          this.jdField_b_of_type_Aduk = new aduk(getHostActivity(), paramInt);
        }
        if (this.jdField_b_of_type_Aduk == null) {
          break;
        }
        this.jdField_b_of_type_Aduk.init();
        this.jdField_b_of_type_Aduk.a(new vxa(this, paramImageView));
        this.jdField_b_of_type_Aduk.getFaceBitmap(paramString, true);
        return;
        paramInt = 1;
        continue;
        paramInt = 4;
        continue;
        paramInt = 101;
      }
    }
    
    private boolean a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
    {
      if (paramTeamWorkFileImportInfo == null) {
        paramTeamWorkFileImportInfo = (TeamWorkFileImportInfo)getIntent().getParcelableExtra("key_team_work_file_import_info");
      }
      for (;;)
      {
        return (paramTeamWorkFileImportInfo != null) && (paramTeamWorkFileImportInfo.dNQ == 12);
      }
    }
    
    private void aC()
    {
      Object localObject2;
      Object localObject1;
      if (this.jdField_a_of_type_Arcd.jdField_a_of_type_Arcd$a.isFullScreen)
      {
        QLog.e("WebLog_WebViewFragment", 1, "isFullScreen");
        if (getIntent().getStringExtra("url") != null)
        {
          localObject2 = new StringBuilder().append("isFullScreen url: ").append(getIntent().getStringExtra("url")).append(" mRulesFromUrl fullScreen ");
          if ((this.jdField_a_of_type_Arcd$a.gK & 0x20000) <= 0L) {
            break label536;
          }
          localObject1 = "true";
          QLog.e("WebLog_WebViewFragment", 1, (String)localObject1);
        }
      }
      boolean bool;
      if (this.jdField_a_of_type_Aqzl.aK != null)
      {
        this.jdField_a_of_type_Aqzl.rightViewImg.setVisibility(8);
        localObject1 = getIntent();
        localObject2 = getResources().getColorStateList(2131167299);
        this.jdField_a_of_type_Aqzl.leftView.setTextColor((ColorStateList)localObject2);
        this.jdField_a_of_type_Aqzl.rightViewText.setTextColor((ColorStateList)localObject2);
        this.jdField_a_of_type_Aqzl.leftView.setBackgroundResource(2130840658);
        if ((this.jdField_a_of_type_Aoao == null) || (!this.jdField_a_of_type_Aoao.isCoverVisible())) {
          this.jdField_a_of_type_Aqzl.aK.setBackgroundColor(Color.parseColor("#f6f7f9"));
        }
        this.jdField_a_of_type_Aqzl.centerView.setTextSize(18.0F);
        this.jdField_a_of_type_Aqzl.centerView.setTextColor(Color.parseColor("#333333"));
        this.jdField_a_of_type_Aqzl.centerView.setMaxEms(13);
        this.jdField_a_of_type_Aqzl.centerView.getLayoutParams().height = -2;
        this.FO = ((TextView)this.jdField_a_of_type_Aqzl.aK.findViewById(2131369631));
        this.FO.setTextColor(Color.parseColor("#777777"));
        this.FO.setTextSize(12.0F);
        this.FO.setMaxEms(13);
        this.rl = ((ImageView)this.jdField_a_of_type_Aqzl.aK.findViewById(2131369600));
        this.bLb = ((Intent)localObject1).getIntExtra("key_team_work_pad_list_type", -1);
        if ((!((Intent)localObject1).getBooleanExtra("temp_preview_from_qq", false)) || (getCurrentUrl() == null) || (!getCurrentUrl().contains("preview=1"))) {
          break label543;
        }
        bool = true;
        label383:
        this.baK = bool;
        if (QLog.isColorLevel()) {
          QLog.i("WebLog_WebViewFragment", 2, "getShareUrl:" + getShareUrl() + "  tempPreviewFromQQ:" + this.baK);
        }
        if (!this.baK) {
          break label684;
        }
        localObject1 = (TeamWorkFileImportInfo)getIntent().getParcelableExtra("key_team_work_file_import_info");
        if ((this.bKY == 0) && (localObject1 != null))
        {
          if (((TeamWorkFileImportInfo)localObject1).nFileType != 3) {
            break label548;
          }
          this.bKY = 1;
        }
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_Aoao == null) || (!this.jdField_a_of_type_Aoao.isCoverVisible())) {
          break label565;
        }
        this.jdField_a_of_type_Aqzl.rightViewImg.setVisibility(8);
        this.jdField_a_of_type_Aqzl.rightViewText.setVisibility(8);
        this.jdField_a_of_type_Aqzl.leftView.setVisibility(8);
        return;
        label536:
        localObject1 = "false";
        break;
        label543:
        bool = false;
        break label383;
        label548:
        if (((TeamWorkFileImportInfo)localObject1).nFileType == 6) {
          this.bKY = 2;
        }
      }
      label565:
      this.jdField_a_of_type_Aqzl.rightViewText.setVisibility(0);
      this.jdField_a_of_type_Aqzl.leftView.setVisibility(0);
      bVT();
      this.rl.setVisibility(8);
      this.jdField_a_of_type_Aqzl.rightViewImg.setVisibility(8);
      this.jdField_a_of_type_Aqzl.rightViewText.setVisibility(0);
      this.jdField_a_of_type_Aqzl.rightViewText.setText(acfp.m(2131715146));
      this.jdField_a_of_type_Aqzl.leftView.setText(acfp.m(2131715166));
      this.bKX = 1;
      this.jdField_a_of_type_Aqzl.rightViewText.setOnClickListener(new vwz(this));
      for (;;)
      {
        ye(true);
        return;
        label684:
        if (((Intent)localObject1).getBooleanExtra("temp_preview_from_qq", false))
        {
          this.bKX = 3;
          bVT();
        }
        else
        {
          bVT();
        }
      }
    }
    
    private void bVO()
    {
      this.c = new vwx(this);
    }
    
    private void bVP()
    {
      Bundle localBundle = new Bundle();
      if (getIntent().getParcelableExtra("key_team_work_file_import_info") != null) {
        localBundle.putParcelable("key_team_work_file_import_info", getIntent().getParcelableExtra("key_team_work_file_import_info"));
      }
      localBundle = affz.a("ipc_cmd_get_team_work_url", "", this.c.key, localBundle);
      afjy.a().cq(localBundle);
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "-->service binded  make ipc request");
      }
      this.baL = true;
    }
    
    private void bVU()
    {
      aobw.a((TeamWorkFileImportInfo)getIntent().getParcelableExtra("key_team_work_file_import_info"), getCurrentUrl(), "0X8009F33");
      bVV();
    }
    
    private void bVV()
    {
      TeamWorkFileImportInfo localTeamWorkFileImportInfo = (TeamWorkFileImportInfo)getIntent().getParcelableExtra("key_team_work_file_import_info");
      if (a(localTeamWorkFileImportInfo))
      {
        aodb.aN(null, "0X800A753");
        anot.a(null, "dc00898", "", "", "0X800A757", "0X800A757", 0, 0, "", "", String.valueOf(SystemClock.elapsedRealtime() - localTeamWorkFileImportInfo.createTime), "");
      }
    }
    
    private String oZ()
    {
      String str2 = getWebView().getUrl();
      String str1 = str2;
      if (!TextUtils.isEmpty(str2))
      {
        int i = str2.indexOf("&preview=1");
        str1 = str2;
        if (i >= 0) {
          str1 = str2.substring(0, i - 1);
        }
      }
      return str1;
    }
    
    private void wB(String paramString)
    {
      if (jqc.isValidUrl(paramString)) {
        this.j.loadUrl(paramString);
      }
      this.baK = false;
      this.rl.setVisibility(0);
      this.jdField_a_of_type_Aqzl.rightViewText.setOnClickListener(null);
      this.jdField_a_of_type_Aqzl.rightViewText.setVisibility(8);
      this.jdField_a_of_type_Aqzl.leftView.setBackgroundResource(2130840658);
      this.jdField_a_of_type_Aqzl.leftView.setText(2131690700);
      this.bKX = 2;
      bVL();
      bVR();
      this.baN = false;
      this.jdField_a_of_type_Aqzl.rightViewImg.setVisibility(8);
      if (this.baJ) {
        this.rl.setVisibility(8);
      }
    }
    
    public void BF(int paramInt)
    {
      this.bKY = paramInt;
      if (this.bKY == 2) {
        if (this.baF)
        {
          this.jdField_b_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(0);
          this.bKZ = this.jdField_b_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getLayoutParams().height;
        }
      }
      for (;;)
      {
        bVL();
        return;
        this.jdField_b_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
        break;
        if (this.bKY == 1) {
          this.bKZ = this.hg.getLayoutParams().height;
        }
      }
    }
    
    public void BH(int paramInt)
    {
      this.baO = true;
      this.bLc = paramInt;
    }
    
    public void Qq()
    {
      arbt localarbt = (arbt)this.jdField_a_of_type_Araz.q(4);
      if (localarbt != null)
      {
        svi localsvi = a();
        if ((localsvi != null) && (aobw.pN(localsvi.getShareUrl())))
        {
          getHostActivity().getIntent().putExtra("big_brother_source_key", "biz_src_xl_docs");
          aobu localaobu = new aobu(getHostActivity());
          localaobu.s((TeamWorkFileImportInfo)getIntent().getParcelableExtra("key_team_work_file_import_info"));
          localarbt.a = localaobu;
        }
        localarbt.a(localsvi, this.jdField_a_of_type_Arcd$a.gK);
        aobw.s(getIntent(), "0X800A16D");
      }
    }
    
    public int a(Bundle paramBundle)
    {
      int i = super.a(paramBundle);
      if ((this.jdField_a_of_type_Aoao != null) && (this.jdField_a_of_type_Aoao.isCoverVisible())) {
        this.jdField_a_of_type_Aqzl.aK.setBackgroundColor(-1);
      }
      if (getIntent().getBooleanExtra("temp_preview_show_loading", false))
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebLog_WebViewFragment", 2, "-->service KEY_TEMP_SHOW_LOADING");
        }
        bVO();
        afjy.a().a(this.c);
        if (afjy.a().ajq()) {
          bVP();
        }
      }
      if (this.jdField_a_of_type_Arcd.mRootView == null) {
        this.jdField_a_of_type_Arcd.mRootView = ((ViewGroup)super.getActivity().findViewById(2131363728));
      }
      this.jdField_a_of_type_Arcd.mRootView.getViewTreeObserver().addOnGlobalLayoutListener(this.mGlobalLayoutListener);
      LayoutInflater.from(super.getActivity()).inflate(2131563164, this.jdField_a_of_type_Arcd.mRootView);
      this.sessionInfo.aTl = acbn.bkS;
      this.sessionInfo.cZ = 7119;
      this.hg = ((RelativeLayout)super.getActivity().findViewById(2131379269));
      this.ri = ((ImageView)super.getActivity().findViewById(2131373265));
      this.ri.setOnClickListener(this);
      this.rj = ((ImageView)super.getActivity().findViewById(2131378280));
      this.rj.setOnClickListener(this);
      this.rk = ((ImageView)super.getActivity().findViewById(2131368522));
      this.rk.setOnClickListener(this);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioInputLinearLayout = ((InputLinearLayout)super.getActivity().findViewById(2131379291));
      this.mEditText = ((EditText)super.getActivity().findViewById(2131379290));
      this.mEditText.setImeOptions(1);
      this.mEditText.setOnEditorActionListener(new vww(this));
      this.dB = ((Button)super.getActivity().findViewById(2131379292));
      this.dB.setOnClickListener(this);
      if (this.bKY == 1)
      {
        super.getWebView().requestFocus();
        this.bKZ = this.hg.getLayoutParams().height;
      }
      while (this.bKY != 2)
      {
        aC();
        return i;
      }
      if (this.baF) {
        this.jdField_b_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(0);
      }
      for (;;)
      {
        this.bKZ = this.jdField_b_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getLayoutParams().height;
        break;
        this.jdField_b_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
      }
    }
    
    public aocc a(ViewGroup paramViewGroup)
    {
      boolean bool2 = false;
      if ((this.jdField_a_of_type_Arcd$a.Ds & 0x40) != 0L) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        this.jdField_a_of_type_Aocc = new aocc(this.mApp, super.getActivity(), this, this.intent, bool1);
        this.jdField_a_of_type_Aocc.setSonicClient(this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl);
        TouchWebView localTouchWebView = this.jdField_a_of_type_Aocc.a();
        if (this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl != null) {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl.bindWebView(localTouchWebView);
        }
        this.mPluginEngine.e(localTouchWebView);
        localTouchWebView.setPluginEngine(this.mPluginEngine);
        if ((localTouchWebView instanceof SwiftReuseTouchWebView))
        {
          arbz localarbz = this.jdField_a_of_type_Arbz;
          bool1 = bool2;
          if (1 == ((SwiftReuseTouchWebView)localTouchWebView).flag) {
            bool1 = true;
          }
          localarbz.cXY = bool1;
        }
        if (localTouchWebView.getX5WebViewExtension() != null) {
          this.aMX = true;
        }
        localTouchWebView.getView().setOnTouchListener(this);
        if (this.avR) {
          localTouchWebView.setMask(true);
        }
        if (paramViewGroup != null) {
          paramViewGroup.addView(localTouchWebView);
        }
        return this.jdField_a_of_type_Aocc;
      }
    }
    
    public void aCP()
    {
      jqo.le("Web_readyToLoadUrl");
      if (this.j == null) {
        return;
      }
      aBA();
      if ((this.jdField_a_of_type_Arbz.cXQ) && (this.jdField_a_of_type_Arbz.auw > 0L))
      {
        anot.b(null, "P_CliOper", "BizTechReport", "", "web", "plugin_start_time", 0, 1, (int)((System.nanoTime() - this.jdField_a_of_type_Arbz.auw) / 1000000L), "", "", "", "" + this.jdField_a_of_type_Arbz.flag);
        this.jdField_a_of_type_Arbz.auw = 0L;
      }
      this.jdField_a_of_type_Arbz.mTimeBeforeLoadUrl = System.currentTimeMillis();
      long l = this.jdField_a_of_type_Arbz.mTimeBeforeLoadUrl;
      l = this.jdField_a_of_type_Arbz.mClickTime;
      if (!TextUtils.isEmpty(this.mUrl))
      {
        if ((aeuk.a().ahY()) && (!TextUtils.isEmpty(aoca.cka)) && (this.mUrl.contains(aoca.cka))) {
          break label221;
        }
        this.j.loadUrl(this.mUrl);
      }
      for (;;)
      {
        jqo.lf("Web_readyToLoadUrl");
        this.jdField_a_of_type_Arbz.a(this.j, this.mUrl, 0, 0, 0, 0, 0, null);
        return;
        label221:
        if (this.jdField_a_of_type_Aocc.cLd) {
          aocb.b(aobh.nP(this.mUrl), this.j);
        } else {
          this.j.loadUrl(this.mUrl);
        }
      }
    }
    
    public void aP()
    {
      if (ilp.checkAVCameraUsed(BaseApplicationImpl.getContext())) {
        return;
      }
      Object localObject1 = super.getActivity();
      Object localObject2 = new File(acbn.SDCARD_PATH + "photo/");
      if ((!((File)localObject2).exists()) && (!((File)localObject2).mkdirs()))
      {
        QQToast.a((Context)localObject1, 2131719242, 0).show();
        return;
      }
      localObject1 = acbn.SDCARD_PATH + "photo/" + System.currentTimeMillis() + ".jpg";
      PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getApplication()).edit().putString("camera_photo_path", (String)localObject1).commit();
      localObject2 = new Intent();
      FileProvider7Helper.setSystemCapture(super.getActivity(), new File((String)localObject1), (Intent)localObject2);
      super.getActivity().startActivityForResult((Intent)localObject2, 5);
    }
    
    public void ax(boolean paramBoolean, int paramInt)
    {
      this.mEditable = paramBoolean;
      this.bzk = paramInt;
      if (this.jdField_a_of_type_Aqzl.centerView == null) {}
      for (;;)
      {
        return;
        Drawable localDrawable;
        if ((!paramBoolean) || (paramInt == 0)) {
          if (!paramBoolean) {
            localDrawable = getResources().getDrawable(2130851579);
          }
        }
        while (localDrawable != null)
        {
          this.jdField_a_of_type_Aqzl.centerView.setCompoundDrawablePadding(wja.dp2px(6.0F, getResources()));
          this.jdField_a_of_type_Aqzl.centerView.setCompoundDrawablesWithIntrinsicBounds(null, null, localDrawable, null);
          return;
          if (paramInt == 0)
          {
            localDrawable = getResources().getDrawable(2130851578);
            continue;
            this.jdField_a_of_type_Aqzl.centerView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
          }
          else
          {
            localDrawable = null;
          }
        }
      }
    }
    
    public void bVI()
    {
      if (this.rl != null) {
        this.rl.setVisibility(0);
      }
    }
    
    public void bVJ()
    {
      if (this.jdField_a_of_type_Aqzl.centerView != null) {
        this.jdField_a_of_type_Aqzl.centerView.clearFocus();
      }
      if (this.FO != null) {
        this.FO.clearFocus();
      }
    }
    
    public void bVK()
    {
      this.baN = true;
    }
    
    public void bVL()
    {
      boolean bool2 = false;
      if ((this.jdField_a_of_type_Aqzl == null) || (this.jdField_a_of_type_Aqzl.centerView == null)) {}
      do
      {
        return;
        if (this.jdField_a_of_type_Aqzl.centerView.isFocused()) {
          this.jdField_a_of_type_Aqzl.centerView.clearFocus();
        }
        this.jdField_a_of_type_Aqzl.centerView.setVisibility(0);
        boolean bool1 = bool2;
        if (this.intent.getBooleanExtra("temp_preview_from_qq", false))
        {
          bool1 = bool2;
          if (getCurrentUrl() != null)
          {
            bool1 = bool2;
            if (getCurrentUrl().contains("preview=1")) {
              bool1 = true;
            }
          }
        }
        this.baK = bool1;
        if (this.baK)
        {
          this.jdField_a_of_type_Aqzl.centerView.setText(getResources().getString(2131720973));
          return;
        }
        if (this.bKY == 2)
        {
          this.jdField_a_of_type_Aqzl.centerView.setText(2131720971);
          return;
        }
      } while (this.bKY != 1);
      this.jdField_a_of_type_Aqzl.centerView.setText(2131720971);
    }
    
    public void bVM()
    {
      if (!isFullScreen())
      {
        super.getActivity().getWindow().setFlags(1024, 1024);
        this.jdField_a_of_type_Arcd$a.isFullScreen = true;
        egN();
        Tl(false);
      }
    }
    
    public void bVN()
    {
      if (isFullScreen())
      {
        super.getActivity().getWindow().clearFlags(1024);
        this.jdField_a_of_type_Arcd$a.isFullScreen = false;
        egO();
        Tl(true);
      }
    }
    
    public void bVQ()
    {
      if ((this.jdField_a_of_type_Aoao != null) && (this.jdField_a_of_type_Aoao.isCoverVisible())) {}
      do
      {
        return;
        if ((!this.baK) && (!this.jdField_a_of_type_Arcd$a.cYo)) {
          this.rl.setVisibility(0);
        }
      } while (!this.baJ);
      this.rl.setVisibility(8);
    }
    
    public void bVR()
    {
      this.jdField_a_of_type_Aqzl.rightViewImg.setImageResource(2130851580);
      this.jdField_a_of_type_Aqzl.rightViewImg.setOnClickListener(new vwy(this));
    }
    
    public void bVS()
    {
      boolean bool = this.intent.getBooleanExtra("doc_from_aio", false);
      String str1 = this.intent.getStringExtra("doc_from_aio_uin");
      int i = this.intent.getIntExtra("doc_from_aio_peertype", -1);
      String str2 = this.intent.getStringExtra("doc_from_aio_nickname");
      if ((bool) && (!TextUtils.isEmpty(str1)) && (i != -1))
      {
        if (this.mMiniMsgUser == null)
        {
          this.mMiniMsgUser = new aobm(getActivity(), getMiniMsgUserParam(), str1, i, str2);
          this.mMiniMsgUser.onForeground();
        }
        this.jdField_a_of_type_Aqzl.cA().setVisibility(0);
        return;
      }
      this.jdField_a_of_type_Aqzl.cA().setVisibility(8);
    }
    
    public void bVT()
    {
      if (this.rl != null)
      {
        this.rl.setVisibility(8);
        Object localObject = new StateListDrawable();
        Drawable localDrawable = getResources().getDrawable(2130851682);
        ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localDrawable);
        localDrawable = getResources().getDrawable(2130851681);
        ((StateListDrawable)localObject).addState(new int[] { 16842910 }, localDrawable);
        localDrawable = getResources().getDrawable(2130851682);
        ((StateListDrawable)localObject).addState(new int[0], localDrawable);
        this.rl.setImageDrawable((Drawable)localObject);
        this.rl.setClickable(true);
        localObject = (RelativeLayout.LayoutParams)this.rl.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).leftMargin = wja.dp2px(16.0F, getResources());
        this.rl.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = (arbt)this.jdField_a_of_type_Araz.q(4);
        ((arbt)localObject).Tr(true);
        ((arbt)localObject).bfz = true;
        this.rl.setOnClickListener(new vxb(this));
      }
    }
    
    void bVW()
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "onDestroy");
      }
      arbz localarbz = this.jdField_a_of_type_Arbz;
      this.isDestroyed = true;
      localarbz.isDestroyed = true;
      if (this.jdField_a_of_type_Aocc != null)
      {
        this.jdField_a_of_type_Aocc.destroy();
        this.jdField_a_of_type_Aocc = null;
        this.j = null;
      }
      this.mApp = null;
    }
    
    public void biT()
    {
      if (this.Wl)
      {
        this.Wl = false;
        ThreadManager.excute(new TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.10(this), 16, null, true);
      }
      label140:
      for (;;)
      {
        return;
        if (this.j == null)
        {
          super.biT();
          return;
        }
        if (this.j.canGoBack())
        {
          HashMap localHashMap = new HashMap(1);
          localHashMap.put("target", Integer.valueOf(2));
          if (this.j.goBack(localHashMap)) {
            reset();
          }
        }
        for (;;)
        {
          if (this.jdField_a_of_type_Aqzl == null) {
            break label140;
          }
          this.jdField_a_of_type_Aqzl.jdField_a_of_type_Arcd$a.cYn = false;
          this.jdField_a_of_type_Aqzl.jdField_a_of_type_Arcd$a.aO = Boolean.valueOf(true);
          if (this.jdField_a_of_type_Arcd == null) {
            break;
          }
          this.jdField_a_of_type_Arcd.ehp();
          return;
          super.biT();
        }
      }
    }
    
    void cS(ArrayList<String> paramArrayList)
    {
      int i = 0;
      while (i < paramArrayList.size())
      {
        String str = (String)paramArrayList.get(i);
        f(this).callJs("readyToInsertImageForNativeJSBridge('" + str + "')");
        i += 1;
      }
    }
    
    public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      switch (paramInt1)
      {
      }
      do
      {
        do
        {
          do
          {
            return;
          } while (paramInt2 != -1);
          k(paramIntent);
          return;
        } while ((paramInt2 != -1) || (paramIntent == null));
        localObject = paramIntent.getExtras();
        paramIntent = ((Bundle)localObject).getString("uin");
        paramInt1 = ((Bundle)localObject).getInt("uintype", 0);
      } while ((this.jdField_a_of_type_Svi.a() == null) || ((this.jdField_a_of_type_Svi.a().policy != 0) && (this.jdField_a_of_type_Svi.a().policy != 1)));
      Object localObject = new ArrayList(1);
      ((List)localObject).add(paramIntent);
      ThreadManager.excute(new TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.13(this, paramInt1, (List)localObject), 128, null, false);
    }
    
    public boolean doOnCreate(Bundle paramBundle)
    {
      super.doOnCreate(paramBundle);
      mg(8980L);
      if (this.jdField_a_of_type_Aqzl.centerView != null) {
        this.jdField_a_of_type_Aqzl.centerView.clearFocus();
      }
      this.f = new auru(ThreadManager.getSubThreadLooper(), this.d);
      this.mUIHandler = new auru(Looper.getMainLooper(), this.e);
      getIntent().getExtras().setClassLoader(getClass().getClassLoader());
      initData();
      return true;
    }
    
    public void doOnNewIntent(Intent paramIntent)
    {
      super.doOnNewIntent(paramIntent);
      if (this.f != null)
      {
        Message localMessage = this.f.obtainMessage();
        localMessage.what = 1;
        localMessage.obj = paramIntent;
        this.f.sendMessage(localMessage);
      }
    }
    
    public void dw(String paramString1, String paramString2)
    {
      if ((this.jdField_a_of_type_Aqzl.centerView != null) && (this.FO != null))
      {
        bVJ();
        int i = b().uw();
        boolean bool = b().isEditable();
        if (QLog.isColorLevel()) {
          QLog.i("WebLog_WebViewFragment", 1, "setEditTitle policy:" + i + ",editable:" + bool);
        }
        if (paramString1 != null)
        {
          if (!TextUtils.isEmpty(paramString2)) {
            this.FO.setTextColor(Color.parseColor(paramString2));
          }
          this.FO.setText(paramString1);
          if (!TextUtils.isEmpty(paramString1)) {
            break label129;
          }
          this.FO.setVisibility(8);
        }
      }
      return;
      label129:
      this.FO.setVisibility(0);
    }
    
    public void e(Context paramContext, ArrayList<String> paramArrayList)
    {
      cS(paramArrayList);
    }
    
    public void f(ArrayList<String> paramArrayList)
    {
      Intent localIntent = new Intent(super.getActivity(), NewPhotoListActivity.class);
      localIntent.putExtra("enter_from", 27);
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", TeamWorkDocEditBrowserActivity.class.getName());
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
      localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
      localIntent.putExtra(aqfx.REQUEST_CODE, 55);
      localIntent.putExtra("uin", acbn.bkS);
      localIntent.putExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", true);
      localIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
      localIntent.putExtra("LASTFROM", this.jdField_a_of_type_Aqzl.leftView.getText().toString());
      localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
      localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
      localIntent.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", true);
      localIntent.putExtra("PhotoConst.original_button", true);
      localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
      if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
        localIntent.putExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
      }
      super.startActivity(localIntent);
      aqfy.anim(super.getActivity(), false, true);
    }
    
    void initData()
    {
      String str = super.getCurrentUrl();
      if (str != null)
      {
        Object localObject = str.split("/");
        if (localObject != null) {
          this.workId = localObject[(localObject.length - 1)];
        }
        localObject = Uri.parse(str).getQueryParameter("type");
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (TextUtils.isDigitsOnly((CharSequence)localObject))) {
          this.bKY = Integer.valueOf((String)localObject).intValue();
        }
      }
      if (this.mApp == null) {
        this.mApp = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web"));
      }
      this.mSelfUin = this.mApp.getCurrentAccountUin();
      if (!TextUtils.isEmpty(str))
      {
        if (!str.contains("docx.qq.com")) {
          break label184;
        }
        this.mRefer = ("https://" + this.mApp.getCurrentAccountUin() + ".docx.qq.com/ep/api/attach_local?tag=" + this.workId);
      }
      for (;;)
      {
        this.baJ = getActivity().getIntent().getBooleanExtra("doc_from_forward_dialog", false);
        return;
        label184:
        if (str.contains("docs.qq.com")) {
          this.mRefer = ("https://" + this.mApp.getCurrentAccountUin() + ".docs.qq.com/ep/api/attach_local?tag=" + this.workId);
        }
      }
    }
    
    public void initWebView()
    {
      int i = -1;
      long l1;
      long l2;
      if (this.j == null)
      {
        this.j = a(null).a();
        this.j.getView().setOnTouchListener(this);
        this.j.setOnLongClickListener(new a());
        l1 = System.currentTimeMillis();
        if ((this.jdField_a_of_type_Arcd$a.gK & 0x10000) == 0L) {
          break label434;
        }
        i = 2;
        if (AppSetting.aNT) {
          i = 2;
        }
        this.j.getSettings().setCacheMode(i);
        if (QLog.isColorLevel()) {
          QLog.i("WebLog_WebViewFragment", 2, "setCacheMode=" + i);
        }
        this.j.getSettings().setAllowFileAccessFromFileURLs(false);
        this.j.getSettings().setAllowUniversalAccessFromFileURLs(false);
        l2 = System.currentTimeMillis();
        this.jdField_a_of_type_Arbz.auz = (l2 - l1);
        this.jdField_a_of_type_Arbz.auY = l2;
        if (QLog.isColorLevel()) {
          QLog.d("WebLog_WebViewFragment", 2, "init browser, cost = " + this.jdField_a_of_type_Arbz.auz);
        }
        l2 = System.currentTimeMillis();
        IX5WebViewExtension localIX5WebViewExtension = this.j.getX5WebViewExtension();
        if (localIX5WebViewExtension == null) {
          break label489;
        }
        i = 1;
        label228:
        if (i == 0) {
          break label518;
        }
        Bundle localBundle = arcp.v();
        if (localBundle != null) {
          localIX5WebViewExtension.invokeMiscMethod("setDomainsAndArgumentForImageRequest", localBundle);
        }
        if (!this.jdField_a_of_type_Arbz.isWebViewCache) {
          break label494;
        }
        l1 = 2L;
        if (!(this.j instanceof SwiftReuseTouchWebView)) {
          break label542;
        }
        if (1 != ((SwiftReuseTouchWebView)this.j).flag) {
          break label513;
        }
        i = 1;
      }
      for (;;)
      {
        label295:
        if (QLog.isColorLevel()) {
          QLog.i("WebLog_WebViewFragment", 2, String.format("reportInitPerformance, initType: %d, webViewType: %d, TbsAccelerator.sCostTime: %d", new Object[] { Long.valueOf(l1), Integer.valueOf(i), Long.valueOf(arcn.a.avr) }));
        }
        System.currentTimeMillis();
        this.j.reportInitPerformance(l1, i, this.jdField_a_of_type_Arbz.mOnCreateMilliTimeStamp, arcn.a.avr);
        System.currentTimeMillis();
        this.jdField_a_of_type_Arbz.eeh = 2;
        label513:
        label518:
        for (this.jdField_a_of_type_Arbz.czr = String.valueOf(QbSdk.getTbsVersion(BaseApplicationImpl.getApplication()));; this.jdField_a_of_type_Arbz.czr = String.valueOf(Build.VERSION.SDK_INT))
        {
          l1 = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.i("WebLog_WebViewFragment", 2, "setDomainsAndArgumentForImageRequest, cost=" + (l1 - l2));
          }
          return;
          label434:
          switch (this.intent.getIntExtra("reqType", -1))
          {
          case 2: 
          case 3: 
          default: 
            break;
          case 1: 
            i = 2;
            break;
          case 4: 
            i = 0;
            break;
            label489:
            i = 0;
            break label228;
            label494:
            if (arbz.aeo) {}
            for (i = 1;; i = 0)
            {
              l1 = i;
              break;
            }
            i = 0;
            break label295;
            this.jdField_a_of_type_Arbz.eeh = 1;
          }
        }
        label542:
        i = 0;
      }
    }
    
    void k(Intent paramIntent)
    {
      paramIntent = null;
      Object localObject = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getApplication()).getString("camera_photo_path", "");
      if (!((String)localObject).equalsIgnoreCase(""))
      {
        wmj.aTe = (String)localObject;
        paramIntent = Uri.fromFile(new File((String)localObject));
      }
      PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getApplication()).edit().remove("camera_photo_path").commit();
      if (paramIntent == null) {
        return;
      }
      paramIntent = aqhu.getRealPathFromContentURI(BaseApplicationImpl.getApplication(), paramIntent);
      if (paramIntent != null)
      {
        aqhu.cn(super.getActivity(), paramIntent);
        if (!aqhq.rr(paramIntent))
        {
          QQToast.a(super.getActivity(), super.getString(2131693663), 0).show(getTitleBarHeight());
          return;
        }
        if (!new File(paramIntent).exists()) {
          QQToast.a(super.getActivity(), getString(2131696981), 0).show(getTitleBarHeight());
        }
      }
      else
      {
        QQToast.a(super.getActivity(), getString(2131696981), 0).show(getTitleBarHeight());
        return;
      }
      localObject = new Intent();
      ArrayList localArrayList = new ArrayList();
      ((Intent)localObject).setClass(super.getActivity(), CameraPreviewActivity.class);
      localArrayList.add(paramIntent);
      ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", TeamWorkDocEditBrowserActivity.class.getName());
      ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", TeamWorkDocEditBrowserActivity.class.getName());
      ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      ((Intent)localObject).putExtra("PhotoConst.HANDLE_DEST_RESULT", false);
      ((Intent)localObject).putExtra(aqfx.REQUEST_CODE, 55);
      ((Intent)localObject).putExtra("uin", acbn.bkS);
      ((Intent)localObject).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
      ((Intent)localObject).putExtra("LASTFROM", this.jdField_a_of_type_Aqzl.leftView.getText().toString());
      super.getActivity().startActivity((Intent)localObject);
    }
    
    public void m(boolean paramBoolean, String paramString1, String paramString2)
    {
      String str = b().nR();
      if ((paramBoolean) && (!TextUtils.isEmpty(str))) {
        rS(str);
      }
      do
      {
        do
        {
          return;
        } while (!TextUtils.isEmpty(str));
        if (this.baM)
        {
          this.baM = false;
          bVL();
        }
      } while (paramBoolean);
      dw(paramString1, paramString2);
    }
    
    public void onClick(View paramView)
    {
      if (paramView.getId() != 2131369579) {
        super.onClick(paramView);
      }
      int i = paramView.getId();
      Object localObject1 = (InputMethodManager)super.getActivity().getSystemService("input_method");
      switch (i)
      {
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if ((this.bKX == 1) && (this.baN))
        {
          report(15);
          localObject1 = (ausj)auss.a(getActivity(), null);
          ((ausj)localObject1).setMainTitle(getResources().getString(2131720967));
          ((ausj)localObject1).addButton(getResources().getString(2131720965), 5);
          ((ausj)localObject1).addButton(getResources().getString(2131720901), 5);
          ((ausj)localObject1).addCancelButton(2131721058);
          ((ausj)localObject1).a(new vwu(this, (ausj)localObject1));
          ((ausj)localObject1).show();
        }
        else if ((this.bKX == 2) && (this.baN))
        {
          report(15);
          BG(2);
          getActivity().finish();
        }
        else if ((this.bKX == 3) && (this.baN))
        {
          report(15);
          BG(3);
          getActivity().finish();
        }
        else
        {
          if ((this.jdField_a_of_type_Svi != null) && (this.aNr) && (this.jdField_a_of_type_Svi.Np()) && (getIntent().getBooleanExtra("key_is_new_pad_flag", false)))
          {
            localObject1 = new Bundle();
            ((Bundle)localObject1).putString("savedUrl", getCurrentUrl());
            localObject2 = (TeamWorkFileImportInfo)getIntent().getParcelableExtra("key_team_work_file_import_info");
            if (localObject2 != null)
            {
              if (this.jdField_a_of_type_Svi.getShareTitle() != null) {
                break label413;
              }
              ((TeamWorkFileImportInfo)localObject2).fileName = "";
              label362:
              if (((TeamWorkFileImportInfo)localObject2).nFileType != 3) {
                break label428;
              }
              ((Bundle)localObject1).putInt("editType", 1);
            }
          }
          for (;;)
          {
            ((Bundle)localObject1).putParcelable("key_team_work_file_import_info", (Parcelable)localObject2);
            localObject1 = affz.a("ipc_save_team_work", "", -1, (Bundle)localObject1);
            afjy.a().cq((Bundle)localObject1);
            biT();
            break;
            label413:
            ((TeamWorkFileImportInfo)localObject2).fileName = this.jdField_a_of_type_Svi.getShareTitle();
            break label362;
            label428:
            if (((TeamWorkFileImportInfo)localObject2).nFileType == 6) {
              ((Bundle)localObject1).putInt("editType", 2);
            }
          }
          if (localObject1 != null) {
            ((InputMethodManager)localObject1).hideSoftInputFromWindow(super.getActivity().getWindow().getDecorView().getWindowToken(), 0);
          }
          b(this).clearFocus();
          if (this.f != null)
          {
            localObject1 = this.f.obtainMessage();
            ((Message)localObject1).what = 2;
            this.f.sendMessageDelayed((Message)localObject1, 500L);
          }
          yc(false);
          continue;
          ((InputMethodManager)localObject1).hideSoftInputFromWindow(super.getActivity().getWindow().getDecorView().getWindowToken(), 0);
          c(this).clearFocus();
          if (this.f != null)
          {
            localObject1 = this.f.obtainMessage();
            ((Message)localObject1).what = 3;
            this.f.sendMessageDelayed((Message)localObject1, 500L);
          }
          yc(false);
          continue;
          ((InputMethodManager)localObject1).hideSoftInputFromWindow(super.getActivity().getWindow().getDecorView().getWindowToken(), 0);
          d(this).clearFocus();
          continue;
          Object localObject2 = this.mEditText.getText().toString();
          try
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("value", localObject2);
            localObject2 = localJSONObject.toString();
            e(this).callJs("setCellValue(" + (String)localObject2 + ")");
            ((InputMethodManager)localObject1).hideSoftInputFromWindow(super.getActivity().getWindow().getDecorView().getWindowToken(), 0);
          }
          catch (JSONException localJSONException) {}
          if (QLog.isDevelopLevel()) {
            QLog.d("WebLog_WebViewFragment", 4, localJSONException, new Object[0]);
          }
        }
      }
    }
    
    @TargetApi(16)
    public void onDestroy()
    {
      bVU();
      aobw.s(getIntent(), "0X800A16C");
      super.onDestroy();
      bVW();
      if (this.jdField_a_of_type_Aoao != null) {
        this.jdField_a_of_type_Aoao.doOnDestroy();
      }
      if (this.f != null)
      {
        this.f.removeCallbacksAndMessages(null);
        this.f.removeMessages(0);
        this.f = null;
      }
      if ((this.jdField_a_of_type_Arcd != null) && (this.jdField_a_of_type_Arcd.mRootView != null) && (this.mGlobalLayoutListener != null))
      {
        if (Build.VERSION.SDK_INT >= 16) {
          break label133;
        }
        this.jdField_a_of_type_Arcd.mRootView.getViewTreeObserver().removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
      }
      for (;;)
      {
        this.mGlobalLayoutListener = null;
        if (this.jdField_b_of_type_Aduk != null) {
          this.jdField_b_of_type_Aduk.destroy();
        }
        return;
        label133:
        this.jdField_a_of_type_Arcd.mRootView.getViewTreeObserver().removeOnGlobalLayoutListener(this.mGlobalLayoutListener);
      }
    }
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      super.onPageFinished(paramWebView, paramString);
      if ((Build.VERSION.SDK_INT >= 19) && (!this.isDestroyed) && (this.jdField_a_of_type_Aocc != null) && (this.jdField_a_of_type_Aocc.a() != null)) {
        onReceivedTitle(paramWebView, paramWebView.getTitle());
      }
      super.getWebView().callJs("setDocxShareInfo", new String[] { "" });
      if (this.jdField_a_of_type_Aqzl.centerView != null) {
        this.jdField_a_of_type_Aqzl.centerView.clearFocus();
      }
      if (this.bKY == 1) {
        super.getWebView().requestFocus();
      }
      if ((this.jdField_a_of_type_Aoao != null) && (this.jdField_a_of_type_Aoao.isCoverVisible()))
      {
        this.jdField_a_of_type_Aoao.dUe();
        aC();
        if (this.bzk != -1000)
        {
          ax(this.mEditable, this.bzk);
          bVQ();
        }
        paramWebView = (TeamWorkFileImportInfo)getIntent().getParcelableExtra("key_team_work_file_import_info");
        if (a(paramWebView))
        {
          aodb.aN(null, "0X800A754");
          anot.a(null, "dc00898", "", "", "0X800A756", "0X800A756", 0, 0, "", "", String.valueOf(SystemClock.elapsedRealtime() - paramWebView.createTime), "");
        }
      }
      if ((paramString != null) && ((paramString.contains("/template")) || (paramString.contains("desktop/m/templates_list.html")) || (paramString.contains("docs.qq.com/desktop/m/send.html"))))
      {
        if (this.rl != null) {
          this.rl.setVisibility(8);
        }
        if (this.jdField_a_of_type_Aqzl.rightViewImg != null) {
          this.jdField_a_of_type_Aqzl.rightViewImg.setVisibility(8);
        }
      }
      if ((this.baJ) && (this.rl != null)) {
        this.rl.setVisibility(8);
      }
    }
    
    public void onResume()
    {
      super.onResume();
      if (this.baO)
      {
        this.baO = false;
        this.jdField_a_of_type_Svi.g(1, this.bLc, 1, true);
      }
    }
    
    public void onStop()
    {
      if (super.getWebView() != null) {
        super.getWebView().clearFocus();
      }
      super.onStop();
    }
    
    public void rS(String paramString)
    {
      if ((this.jdField_a_of_type_Aqzl.centerView != null) && (!TextUtils.isEmpty(paramString)))
      {
        this.baM = true;
        this.jdField_a_of_type_Aqzl.centerView.setVisibility(0);
        this.jdField_a_of_type_Aqzl.centerView.setText(paramString);
        if (this.FO != null) {
          this.FO.setVisibility(8);
        }
      }
    }
    
    public void report(int paramInt)
    {
      String str = "";
      int i = getIntent().getIntExtra("tdsourcetab", -1);
      if (paramInt == 0) {
        if (i == 3)
        {
          anot.a(getActivity().app, "dc00898", "", "", "0X800A074", "0X800A074", 0, 0, "", "", "", "");
          str = "0X80074D2";
        }
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(str)) {
          anot.a(getActivity().app, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
        }
        return;
        if (i != 20) {
          break;
        }
        anot.a(getActivity().app, "dc00898", "", "", "0X800A07C", "0X800A07C", 0, 0, "", "", "", "");
        break;
        if (paramInt == 1)
        {
          if (i == 3) {
            anot.a(getActivity().app, "dc00898", "", "", "0X800A075", "0X800A075", 0, 0, "", "", "", "");
          }
          for (;;)
          {
            str = "0X80074D3";
            break;
            if (i == 20) {
              anot.a(getActivity().app, "dc00898", "", "", "0X800A07D", "0X800A07D", 0, 0, "", "", "", "");
            }
          }
        }
        if (paramInt == 2)
        {
          if (i == 3) {
            anot.a(getActivity().app, "dc00898", "", "", "0X800A076", "0X800A076", 0, 0, "", "", "", "");
          }
          for (;;)
          {
            str = "0X80074D4";
            break;
            if (i == 20) {
              anot.a(getActivity().app, "dc00898", "", "", "0X800A07E", "0X800A07E", 0, 0, "", "", "", "");
            }
          }
        }
        if (paramInt == 3)
        {
          str = "0X80075FF";
        }
        else if (paramInt == 4)
        {
          str = "0X80075FE";
        }
        else if (paramInt == 5)
        {
          str = "0X8007762";
        }
        else if (paramInt == 6)
        {
          str = "0X8007764";
        }
        else if (paramInt == 7)
        {
          str = "0X8007763";
        }
        else if (paramInt == 8)
        {
          str = "0X8007A29";
        }
        else if (paramInt == 9)
        {
          str = "0X8007A2A";
        }
        else if (paramInt == 10)
        {
          str = "0X8007A2B";
        }
        else if (paramInt == 11)
        {
          str = "0X8007A2C";
        }
        else if (paramInt == 12)
        {
          str = "0X8007A30";
        }
        else if (paramInt == 13)
        {
          str = "0X8007A31";
        }
        else if (paramInt == 14)
        {
          str = "0X8007CE5";
        }
        else
        {
          if (paramInt == 15)
          {
            if (i == 3) {
              anot.a(getActivity().app, "dc00898", "", "", "0X800A073", "0X800A073", 0, 0, "", "", "", "");
            }
            for (;;)
            {
              str = "0X8008A3B";
              break;
              if (i == 20) {
                anot.a(getActivity().app, "dc00898", "", "", "0X800A07B", "0X800A07B", 0, 0, "", "", "", "");
              }
            }
          }
          if (paramInt == 17) {
            str = "0X8009068";
          } else if (paramInt == 18) {
            str = "0X8008A3A";
          } else if (paramInt == 20) {
            str = "0X8009069";
          } else if (paramInt == 19) {
            str = "0X8008A3E";
          }
        }
      }
    }
    
    public void reset()
    {
      super.reset();
      if (this.FO != null) {
        this.FO.setVisibility(8);
      }
      this.jdField_a_of_type_Aqzl.centerView.setText("");
    }
    
    public int s(Bundle paramBundle)
    {
      int i = super.s(paramBundle);
      if (this.jdField_a_of_type_Aqzl.leftView != null) {
        this.jdField_a_of_type_Aqzl.leftView.setText(getResources().getString(2131691039));
      }
      if (this.jdField_a_of_type_Aqzl.rightViewImg != null) {
        this.jdField_a_of_type_Aqzl.rightViewImg.setVisibility(8);
      }
      if ((getIntent().hasExtra("temp_preview_show_loading")) && ((this.jdField_a_of_type_Arcd.mRootView instanceof RelativeLayout)))
      {
        this.jdField_a_of_type_Aoao = new aoao((RelativeLayout)this.jdField_a_of_type_Arcd.mRootView, getActivity(), this.browserApp);
        this.uS = this.jdField_a_of_type_Aoao.a(paramBundle);
        if (a(null)) {
          aodb.aN(null, "0X800A752");
        }
      }
      return i;
    }
    
    public void wC(String paramString)
    {
      report(17);
      ThreadManager.executeOnNetWorkThread(new TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.8(this, paramString));
    }
    
    public void wD(String paramString)
    {
      if (paramString != null) {
        try
        {
          QLog.d("WebLog_WebViewFragment", 2, paramString);
          JSONObject localJSONObject = new JSONObject(paramString);
          int i = localJSONObject.getInt("ret");
          String str = localJSONObject.optString("url");
          localJSONObject.optString("error");
          if (i == 0) {
            this.mUIHandler.sendMessage(this.mUIHandler.obtainMessage(2, str));
          }
          while (QLog.isColorLevel())
          {
            QLog.e("WebLog_WebViewFragment", 2, "handleSaveTempPadResult: " + paramString);
            return;
            this.mUIHandler.sendMessage(this.mUIHandler.obtainMessage(3, str));
            continue;
            this.mUIHandler.sendMessage(this.mUIHandler.obtainMessage(3));
          }
        }
        catch (JSONException paramString)
        {
          if (QLog.isColorLevel()) {
            QLog.e("WebLog_WebViewFragment", 2, paramString, new Object[0]);
          }
          this.mUIHandler.sendMessage(this.mUIHandler.obtainMessage(3));
          return;
        }
      }
    }
    
    public void yb(boolean paramBoolean)
    {
      this.aNr = paramBoolean;
    }
    
    public void yc(boolean paramBoolean)
    {
      this.baE = paramBoolean;
      if ((this.hg != null) && (this.bKY == 1))
      {
        if (this.baE) {
          this.hg.setVisibility(0);
        }
      }
      else {
        return;
      }
      this.hg.setVisibility(8);
    }
    
    public void yd(boolean paramBoolean)
    {
      this.baF = paramBoolean;
      if ((this.jdField_b_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) && (this.bKY == 2))
      {
        if (this.baF) {
          this.jdField_b_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(0);
        }
      }
      else {
        return;
      }
      this.jdField_b_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
    }
    
    public void ye(boolean paramBoolean)
    {
      if ((this.jdField_a_of_type_Aqzl.cA() != null) && (this.intent != null))
      {
        paramBoolean = this.intent.getBooleanExtra("doc_from_aio", false);
        String str = this.intent.getStringExtra("doc_from_aio_uin");
        int i = this.intent.getIntExtra("doc_from_aio_peertype", -1);
        if ((paramBoolean) && (!TextUtils.isEmpty(str)) && (i != -1))
        {
          this.jdField_a_of_type_Aqzl.cA().setVisibility(0);
          bVS();
          a(i, str, (ImageView)this.jdField_a_of_type_Aqzl.cA().findViewById(2131371722));
          return;
        }
      }
      this.jdField_a_of_type_Aqzl.cA().setVisibility(8);
    }
    
    class a
      implements View.OnLongClickListener
    {
      a() {}
      
      public boolean onLongClick(View paramView)
      {
        if (!TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.a(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.this).J("web_view_long_click", true))
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("WebLog_WebViewFragment", 1, "disable long click on current url!");
          }
          return true;
        }
        if (!TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.b(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.this).J("image_long_click", false))
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("WebLog_WebViewFragment", 1, "disable image long click on current url!");
          }
          return false;
        }
        arbf localarbf = (arbf)TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.this.a.q(8);
        if ((localarbf != null) && (localarbf.U(paramView))) {}
        for (boolean bool = true;; bool = false) {
          return bool;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity
 * JD-Core Version:    0.7.0.1
 */