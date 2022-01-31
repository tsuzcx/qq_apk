package com.tencent.biz.webviewplugin;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import buy;
import bva;
import bvc;
import bvd;
import bvf;
import bvh;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.open.appcommon.AppClient;
import com.tencent.protofile.getappinfo.GetAppInfoProto.AndroidInfo;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoRequest;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.protofile.getappinfo.GetAppInfoProto.MsgIconsurl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import cooperation.qzone.QZoneShareManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

public class Share
  implements View.OnClickListener
{
  protected static final int a = 34;
  protected static final int b = 64;
  protected static final int c = 1001;
  protected static final int d = 1;
  public static final int e = 1;
  protected static final String e = "http://openmobile.qq.com/api/get_app_info_by_id?appid=%d";
  public static final int f = 2;
  public static final String f = "http://cgi.connect.qq.com/qqconnectopen/get_urlinfoForQQV2?url=%2$s&uin=%1$s";
  public static final int g = 3;
  public static final String g = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=%s";
  public static final int h = 4;
  public static final String h = "mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=%s&version=1";
  public static final String i = "http://url.cn/JS8oE7";
  public static final String j = "source_name";
  private static String n = "share";
  public float a;
  protected long a;
  protected Handler a;
  public ImageView a;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  public QQBrowserActivity a;
  public QQProgressDialog a;
  WXShareHelper.WXShareListener jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener;
  protected GetAppInfoProto.GetAppinfoResponse a;
  WebView jdField_a_of_type_ComTencentSmttSdkWebView;
  protected String a;
  public WeakReference a;
  protected BusinessObserver a;
  public String b = null;
  public String c = null;
  public String d = null;
  public String k;
  public String l;
  public String m = null;
  
  public Share(AppInterface paramAppInterface, QQBrowserActivity paramQQBrowserActivity)
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse = null;
    this.jdField_a_of_type_MqqObserverBusinessObserver = new bvf(this);
    this.jdField_a_of_type_AndroidOsHandler = new bvh(this);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.k = paramAppInterface.getAccount();
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity = paramQQBrowserActivity;
    this.jdField_a_of_type_Float = paramQQBrowserActivity.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentSmttSdkWebView = paramQQBrowserActivity.a();
    c();
  }
  
  public static final String a(PBRepeatMessageField paramPBRepeatMessageField, int paramInt)
  {
    List localList = null;
    Object localObject = localList;
    int i2;
    int i1;
    if (paramPBRepeatMessageField != null)
    {
      localObject = localList;
      if (!paramPBRepeatMessageField.isEmpty())
      {
        localList = paramPBRepeatMessageField.get();
        i2 = localList.size();
        i1 = 0;
        paramPBRepeatMessageField = null;
        if (i1 >= i2) {
          break label275;
        }
        localObject = (GetAppInfoProto.MsgIconsurl)localList.get(i1);
      }
    }
    label256:
    label263:
    label266:
    label272:
    label275:
    for (;;)
    {
      try
      {
        int i3 = Integer.valueOf(((GetAppInfoProto.MsgIconsurl)localObject).size.get()).intValue();
        if (i3 < paramInt) {
          break label272;
        }
        localObject = ((GetAppInfoProto.MsgIconsurl)localObject).url.get();
        paramPBRepeatMessageField = (PBRepeatMessageField)localObject;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          paramPBRepeatMessageField = (PBRepeatMessageField)localObject;
          localObject = paramPBRepeatMessageField;
          if (paramPBRepeatMessageField == null)
          {
            i1 = i2 - 1;
            if (i1 < 0) {
              break label266;
            }
            localObject = (GetAppInfoProto.MsgIconsurl)localList.get(i1);
          }
        }
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        try
        {
          i2 = Integer.valueOf(((GetAppInfoProto.MsgIconsurl)localObject).size.get()).intValue();
          if (i2 >= paramInt) {
            break label263;
          }
          localObject = ((GetAppInfoProto.MsgIconsurl)localObject).url.get();
          paramPBRepeatMessageField = (PBRepeatMessageField)localObject;
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break label256;
          }
          if (QLog.isColorLevel()) {
            QLog.d(n, 2, "QQBrowserActivity findAppIcon() iconUrl = " + (String)localObject);
          }
          return localObject;
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          if (!QLog.isColorLevel()) {
            break label256;
          }
          QLog.d(n, 2, localNumberFormatException2.getMessage());
        }
        localNumberFormatException1 = localNumberFormatException1;
        if (QLog.isColorLevel()) {
          QLog.d(n, 2, localNumberFormatException1.getMessage());
        }
        i1 += 1;
      }
      for (;;)
      {
        i1 += 1;
        break;
      }
      PBRepeatMessageField localPBRepeatMessageField = paramPBRepeatMessageField;
      continue;
    }
  }
  
  public static String a(String paramString, String... paramVarArgs)
  {
    String str;
    if (TextUtils.isEmpty(paramString))
    {
      str = paramString;
      return str;
    }
    paramString = paramString.replaceAll("(?<=\\?|#|&)((?i)sid|3g_sid|uin|sec_sig|MOBINFO|originuin)=[^&#]*&", "").replaceAll("[\\?#&]((?i)sid|3g_sid|uin|sec_sig|MOBINFO|originuin)=[^&#]*(?=#|$)", "").replaceAll("(?<=\\?|#|&)((?i)from)=androidqq&", "").replaceAll("[\\?#&]((?i)from)=androidqq(?=#|$)", "");
    int i2 = paramVarArgs.length;
    int i1 = 0;
    for (;;)
    {
      str = paramString;
      if (i1 >= i2) {
        break;
      }
      paramString = paramString.replace(paramVarArgs[i1], "");
      i1 += 1;
    }
  }
  
  public static final void a(AppInterface paramAppInterface, Context paramContext, String paramString, long paramLong1, long paramLong2, BusinessObserver paramBusinessObserver)
  {
    GetAppInfoProto.GetAppinfoRequest localGetAppinfoRequest = new GetAppInfoProto.GetAppinfoRequest();
    localGetAppinfoRequest.client_id.set(paramLong1);
    localGetAppinfoRequest.sdkp.set("android");
    localGetAppinfoRequest.os.set(Build.VERSION.RELEASE);
    localGetAppinfoRequest.qqv.set("6.0.0");
    localGetAppinfoRequest.setHasFlag(true);
    paramContext = new NewIntent(paramContext, ProtoServlet.class);
    paramContext.putExtra("uin", paramString);
    paramContext.putExtra("data", localGetAppinfoRequest.toByteArray());
    paramContext.putExtra("cmd", "ConnAuthSvr.get_app_info");
    if (paramLong2 > 0L) {
      paramContext.putExtra("timeout", paramLong2);
    }
    paramContext.setObserver(paramBusinessObserver);
    paramAppInterface.startServlet(paramContext);
  }
  
  public static final void a(AppInterface paramAppInterface, Context paramContext, String paramString, long paramLong, BusinessObserver paramBusinessObserver)
  {
    a(paramAppInterface, paramContext, paramString, paramLong, 0L, paramBusinessObserver);
  }
  
  private void c()
  {
    this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getIntent().getLongExtra("appShareID", 0L);
    if (this.jdField_a_of_type_Long > 0L)
    {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.findViewById(2131231194));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, this.k, AppShareIDUtil.b(this.jdField_a_of_type_Long), this.jdField_a_of_type_MqqObserverBusinessObserver);
    }
  }
  
  public QQProgressDialog a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.d());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131562297);
    }
    return this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  }
  
  public String a()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    for (String str = this.jdField_a_of_type_JavaLangString; TextUtils.isEmpty(str); str = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.d()) {
      return "";
    }
    return a(str, new String[0]);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.b = null;
    this.c = null;
    this.d = null;
    this.m = null;
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Bitmap paramBitmap)
  {
    if (paramInt == 2)
    {
      localObject = new Bundle();
      paramBitmap = paramString1;
      if (TextUtils.isEmpty(paramString1)) {
        paramBitmap = paramString3;
      }
      ((Bundle)localObject).putString("title", paramBitmap);
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = paramString3;
      }
      ((Bundle)localObject).putString("desc", paramString1);
      ((Bundle)localObject).putString("detail_url", paramString3);
      paramString1 = new ArrayList(1);
      paramString1.add(paramString4);
      ((Bundle)localObject).putStringArrayList("image_url", paramString1);
      ((Bundle)localObject).putLong("req_share_id", 0L);
      if (!QZoneShareManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, (Bundle)localObject, null)) {
        QRUtils.a(1, 2131562037);
      }
    }
    label235:
    do
    {
      return;
      if (paramInt == 1)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity instanceof PublicAccountBrowser))
        {
          String str4 = ((PublicAccountBrowser)this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity).b_();
          Resources localResources = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources();
          String str3 = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getIntent().getStringExtra("source_name");
          String str1;
          String str2;
          QQBrowserActivity localQQBrowserActivity;
          if ((TextUtils.isEmpty(str4)) || (TextUtils.isEmpty(str3)))
          {
            paramBitmap = " ";
            localObject = null;
            str1 = null;
            str2 = null;
            str3 = localResources.getString(2131560574);
            localQQBrowserActivity = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity;
            if (!TextUtils.isEmpty(paramString4)) {
              break label348;
            }
            paramString4 = null;
            if (!TextUtils.isEmpty(paramString2)) {
              break label351;
            }
            paramString2 = paramString3;
          }
          for (;;)
          {
            ShareMsgHelper.a(localQQBrowserActivity, 1001, 1, "web_share", str4, paramString4, paramString1, paramString2, String.format(localResources.getString(2131560575), new Object[] { paramString1 }), paramString3, "web", null, null, null, paramBitmap, null, (String)localObject, str1, str2, str3, null);
            return;
            paramBitmap = "plugin";
            localObject = String.format("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=%s", new Object[] { str4 });
            str1 = String.format("mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=%s&version=1", new Object[] { str4 });
            str2 = "http://url.cn/JS8oE7";
            break;
            break label235;
          }
        }
        paramBitmap = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity;
        if (TextUtils.isEmpty(paramString4))
        {
          paramString4 = null;
          if (!TextUtils.isEmpty(paramString2)) {
            break label448;
          }
          paramString2 = paramString3;
        }
        for (;;)
        {
          ShareMsgHelper.a(paramBitmap, 1001, 1, "web_share", "", paramString4, paramString1, paramString2, this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getString(2131560575, new Object[] { paramString1 }), paramString3, "web", null, null, null, " ", null, null, null, null, this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getString(2131560574), null);
          return;
          break;
        }
      }
    } while ((paramInt != 3) && (paramInt != 4));
    label348:
    label351:
    if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener = new bvc(this);
      WXShareHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
    }
    label448:
    this.l = String.valueOf(System.currentTimeMillis());
    paramString4 = WXShareHelper.a();
    Object localObject = this.l;
    if (TextUtils.isEmpty(paramString2))
    {
      paramString2 = paramString3;
      if (paramInt != 3) {
        break label546;
      }
    }
    label546:
    for (paramInt = 0;; paramInt = 1)
    {
      paramString4.a((String)localObject, paramString1, paramBitmap, paramString2, paramString3, paramInt);
      return;
      break;
    }
  }
  
  public void a(Context paramContext, GetAppInfoProto.GetAppinfoResponse paramGetAppinfoResponse)
  {
    try
    {
      if ((paramGetAppinfoResponse.has()) && (paramGetAppinfoResponse.ret.get() == 0))
      {
        this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse = paramGetAppinfoResponse;
        str = a(this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.iconsURL, 64);
        localAndroidInfo = this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.androidInfo;
        if ((TextUtils.isEmpty(str)) || (localAndroidInfo == null) || (localAndroidInfo.packName == null))
        {
          if (QLog.isColorLevel()) {
            QLog.e(n, 2, "QQBrowserActivity getAppInfo(): iconUrl = " + str + ", androidInfo is null, OR androidInfo.packName is null !!!");
          }
        }
        else
        {
          paramGetAppinfoResponse = HttpUtil.a(paramContext, str, "GET", null, null);
          if (paramGetAppinfoResponse == null)
          {
            if (!QLog.isColorLevel()) {
              return;
            }
            QLog.e(n, 2, "QQBrowserActivity getAppInfo(): iconUrl = " + str + ", imageBytes is NULL!!!!!!!!");
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      String str;
      GetAppInfoProto.AndroidInfo localAndroidInfo;
      if (QLog.isColorLevel())
      {
        QLog.d(n, 2, paramContext.getMessage());
        return;
        if (PackageUtil.a(paramContext, localAndroidInfo.packName.get()))
        {
          paramContext = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1001);
          paramContext.obj = BitmapFactory.decodeByteArray(paramGetAppinfoResponse, 0, paramGetAppinfoResponse.length);
          this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramContext);
          return;
        }
        paramContext = HttpUtil.a(paramContext, String.format("http://openmobile.qq.com/api/get_app_info_by_id?appid=%d", new Object[] { Long.valueOf(AppShareIDUtil.b(this.jdField_a_of_type_Long)) }), "GET", null, null);
        if (TextUtils.isEmpty(paramContext))
        {
          if (QLog.isColorLevel()) {
            QLog.d(n, 2, "QQBrowserActivity urlResponse is null");
          }
        }
        else
        {
          paramContext = new JSONObject(paramContext);
          if (paramContext.getInt("retcode") != 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d(n, 2, "QQBrowserActivity retcode is -1");
            }
          }
          else
          {
            paramContext = paramContext.getJSONObject("result");
            if (paramContext != null)
            {
              paramContext = paramContext.getJSONObject("mobile");
              if (paramContext != null)
              {
                paramContext = paramContext.getJSONObject("android");
                if (paramContext != null)
                {
                  str = paramContext.getString("yyb_url");
                  if ((paramContext.getInt("AppState") == 1) && (!TextUtils.isEmpty(str)))
                  {
                    paramContext = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1001);
                    paramContext.obj = BitmapFactory.decodeByteArray(paramGetAppinfoResponse, 0, paramGetAppinfoResponse.length);
                    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramContext);
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    this.m = paramString;
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramInt == 1) {
      paramString = "0";
    }
    for (;;)
    {
      a().show();
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.a(this.m, new String[] { paramString });
      return;
      if (paramInt == 2) {
        paramString = "1";
      } else if (paramInt == 3) {
        paramString = "2";
      } else {
        paramString = "3";
      }
    }
  }
  
  public boolean a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentSmttSdkWebView == null) {}
    Object localObject;
    Uri localUri;
    do
    {
      do
      {
        return false;
        localObject = this.jdField_a_of_type_ComTencentSmttSdkWebView.getUrl();
      } while ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(paramString)));
      localObject = Uri.parse((String)localObject);
      localUri = Uri.parse(paramString);
    } while ((((Uri)localObject).isOpaque()) || (localUri.isOpaque()) || (!((Uri)localObject).getScheme().equals(localUri.getScheme())) || (!((Uri)localObject).getHost().equals(localUri.getHost())));
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    return true;
  }
  
  public boolean a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (!NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity))
    {
      QRUtils.a(1, 2131562449);
      return false;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QRUtils.a(1, 2131562072);
      return false;
    }
    a().b(2131562297);
    Bitmap localBitmap;
    boolean bool1;
    label88:
    boolean bool2;
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null)
    {
      localBitmap = null;
      if ((TextUtils.isEmpty(this.b)) || (TextUtils.isEmpty(this.c))) {
        break label255;
      }
      if (paramString.length() <= 180) {
        break label192;
      }
      bool1 = true;
      if ((this.d == null) || (this.d.length() <= 40)) {
        break label198;
      }
      bool2 = true;
      label110:
      if ((!paramBoolean) || (localBitmap != null) || (TextUtils.isEmpty(this.d))) {
        break label204;
      }
    }
    label192:
    label198:
    label204:
    for (boolean bool3 = true;; bool3 = false)
    {
      if ((!bool1) && (!bool2) && (!bool3)) {
        break label210;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      new buy(this, bool1, paramString, bool2, bool3, localBitmap, paramInt).start();
      return true;
      localBitmap = (Bitmap)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      break;
      bool1 = false;
      break label88;
      bool2 = false;
      break label110;
    }
    label210:
    String str1 = this.b;
    String str2 = this.c;
    String str3 = this.d;
    if (paramBoolean) {}
    for (;;)
    {
      a(paramInt, str1, str2, paramString, str3, localBitmap);
      break;
      localBitmap = null;
    }
    label255:
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    new bva(this, paramString, paramBoolean, localBitmap, paramInt).start();
    return true;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    while ((!TextUtils.isEmpty(paramString3)) && (!a(paramString3))) {
      return false;
    }
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString4;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    return true;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    if (!NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity))
    {
      QRUtils.a(1, 2131562449);
      return false;
    }
    if (TextUtils.isEmpty(paramString4))
    {
      QRUtils.a(1, 2131562072);
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.d());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131562297);
    }
    boolean bool;
    int i1;
    if (paramString5.length() > 180)
    {
      bool = true;
      if ((paramString5 == null) || (paramString5.length() <= 40)) {
        break label154;
      }
      i1 = 1;
      label107:
      if ((!bool) && (i1 == 0)) {
        break label160;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      new bvd(this, bool, paramString5, paramString1, paramString2, paramString3, paramString4, paramString6).start();
    }
    for (;;)
    {
      return true;
      bool = false;
      break;
      label154:
      i1 = 0;
      break label107;
      label160:
      paramString7 = String.format("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=%s", new Object[] { paramString1 });
      paramString8 = String.format("mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=%s&version=1", new Object[] { paramString1 });
      String str = String.format(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131560575), new Object[] { paramString2 });
      ShareMsgHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, 1001, 1, "struct_msg_from_h5", paramString1, paramString5, paramString2, paramString3, str, paramString4, "web", null, null, null, "plugin", null, paramString7, paramString8, "http://url.cn/JS8oE7", paramString6, null);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener != null)
    {
      WXShareHelper.a().b(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
      this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener = null;
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (paramView == this.jdField_a_of_type_AndroidWidgetImageView)
    {
      localObject = "";
      paramView = (View)localObject;
      if (this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse != null)
      {
        paramView = (View)localObject;
        if (this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.androidInfo != null)
        {
          paramView = this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.androidInfo;
          if (!PackageUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, paramView.packName.get())) {
            break label96;
          }
          PackageUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, paramView.packName.get(), null);
        }
      }
    }
    for (paramView = "run";; paramView = "setup")
    {
      Util.a(null, "", "webviewsourceclick", AppShareIDUtil.b(this.jdField_a_of_type_Long), 0L, paramView);
      return;
      label96:
      localObject = new Bundle();
      ((Bundle)localObject).putString("uin", this.k);
      ((Bundle)localObject).putString("sid", this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getIntent().getStringExtra("vkey"));
      ((Bundle)localObject).putString("via", "ANDROIDQQ.STORE.APPDETAIL.SHARE2QQ.WEBVIEW");
      ((Bundle)localObject).putBoolean("autoDownload", true);
      ((Bundle)localObject).putString("packageName", paramView.packName.get());
      AppClient.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, String.valueOf(AppShareIDUtil.b(this.jdField_a_of_type_Long)), 2470, (Bundle)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.Share
 * JD-Core Version:    0.7.0.1
 */