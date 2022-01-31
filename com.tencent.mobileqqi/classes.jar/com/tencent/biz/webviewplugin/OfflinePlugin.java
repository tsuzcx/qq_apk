package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bup;
import bur;
import bus;
import but;
import buu;
import buv;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.util.LoadedBack2;
import com.tencent.biz.pubaccount.util.OfflineUpdateStatus;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class OfflinePlugin
  extends WebViewPlugin
{
  public static HashMap a;
  static final int jdField_b_of_type_Int = Build.VERSION.SDK_INT;
  public int a;
  public Handler a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new but(this);
  public LinearLayout a;
  public ProgressBar a;
  public RelativeLayout a;
  public TextView a;
  private AuthorizeConfig jdField_a_of_type_ComTencentBizAuthorizeConfig;
  private LoadedBack2 jdField_a_of_type_ComTencentBizCommonUtilLoadedBack2 = new buu(this);
  private Runnable jdField_a_of_type_JavaLangRunnable = new buv(this);
  private String jdField_a_of_type_JavaLangString = "offline";
  protected ArrayList a;
  public boolean a;
  private String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = false;
  private String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean = false;
  
  public OfflinePlugin()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void a(JSONObject paramJSONObject)
  {
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {}
    OfflineUpdateStatus localOfflineUpdateStatus;
    Object localObject2;
    int i;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localObject1 = this.mRuntime.a();
          } while (localObject1 == null);
          if (jdField_a_of_type_JavaUtilHashMap == null) {
            jdField_a_of_type_JavaUtilHashMap = new HashMap();
          }
        } while ((OfflineUpdateStatus)jdField_a_of_type_JavaUtilHashMap.get(this.jdField_c_of_type_JavaLangString) != null);
        localOfflineUpdateStatus = new OfflineUpdateStatus(this.jdField_c_of_type_JavaLangString);
        localOfflineUpdateStatus.a(this.jdField_a_of_type_ComTencentBizCommonUtilLoadedBack2);
        localObject2 = paramJSONObject.optJSONObject("wording");
        if (localObject2 != null)
        {
          localOfflineUpdateStatus.jdField_c_of_type_JavaLangString = ((JSONObject)localObject2).optString("nonWifiUpdatingText");
          localOfflineUpdateStatus.jdField_b_of_type_JavaLangString = ((JSONObject)localObject2).optString("wifiUpdatingText");
          localOfflineUpdateStatus.d = ((JSONObject)localObject2).optString("updateCompletedText");
        }
        localOfflineUpdateStatus.e = ((Activity)localObject1).getResources().getString(2131560617);
        jdField_a_of_type_JavaUtilHashMap.put(this.jdField_c_of_type_JavaLangString, localOfflineUpdateStatus);
        localObject2 = paramJSONObject.optString("url");
        localOfflineUpdateStatus.jdField_f_of_type_JavaLangString = ((String)localObject2);
        i = paramJSONObject.optInt("filesize");
        localOfflineUpdateStatus.jdField_f_of_type_Int = i;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        if (!NetworkUtil.g(((Activity)localObject1).getApplicationContext())) {
          break;
        }
        localOfflineUpdateStatus.e = localOfflineUpdateStatus.jdField_b_of_type_JavaLangString;
        paramJSONObject = localOfflineUpdateStatus.e;
      } while ((TextUtils.isEmpty((CharSequence)localObject2)) || (i <= 0));
      localOfflineUpdateStatus.c(1);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramJSONObject + "0%");
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      HtmlOffline.a(((Activity)localObject1).getApplicationContext(), this.jdField_c_of_type_JavaLangString, (String)localObject2, i, localOfflineUpdateStatus);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2000L);
      return;
      paramJSONObject = localOfflineUpdateStatus.jdField_c_of_type_JavaLangString;
    } while ((TextUtils.isEmpty((CharSequence)localObject2)) || (i <= 0));
    localOfflineUpdateStatus.c(0);
    Object localObject1 = ((Activity)localObject1).getResources().getDrawable(2130838729);
    ((Drawable)localObject1).setBounds(0, 0, 40, 40);
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject1, null, null, null);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramJSONObject);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
  }
  
  private boolean a()
  {
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_b_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentBizAuthorizeConfig != null))
    {
      this.jdField_b_of_type_Boolean = true;
      Object localObject1 = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.a("ex_offline", "");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = ((String)localObject1).split(",");
        Object localObject2 = Build.BRAND;
        String str2 = Build.MODEL;
        String str1 = Build.VERSION.RELEASE;
        localObject2 = new StringBuffer((String)localObject2);
        ((StringBuffer)localObject2).append(" ").append(str2);
        str2 = ((StringBuffer)localObject2).toString().toLowerCase();
        str1 = (" " + str1).toLowerCase();
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          localObject2 = localObject1[i].toLowerCase();
          if ((((String)localObject2).contains(str2)) && (str1.startsWith((String)localObject2)))
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "*****checkOfflineUrl: in ex offline");
            }
            this.jdField_b_of_type_JavaLangString = null;
            this.jdField_c_of_type_Boolean = true;
            return true;
          }
          i += 1;
        }
      }
    }
    return false;
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidOsHandler = new bur(this);
  }
  
  public WebResourceResponse a(String paramString)
  {
    if (this.jdField_c_of_type_Boolean) {}
    while (((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && ((TextUtils.isEmpty(paramString)) || (!paramString.contains("_bid=")))) || (a())) {
      return null;
    }
    try
    {
      Object localObject1 = Uri.parse(paramString).getQueryParameter("_bid");
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = this.jdField_b_of_type_JavaLangString;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (!((String)localObject2).equals(this.jdField_b_of_type_JavaLangString)))
        {
          if (this.jdField_a_of_type_JavaUtilArrayList == null) {
            this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          }
          int j = this.jdField_a_of_type_JavaUtilArrayList.size();
          i = 0;
          if (i >= j) {
            break label229;
          }
          if (((String)localObject2).equals(this.jdField_a_of_type_JavaUtilArrayList.get(i)))
          {
            i = 1;
            if (i == 0) {
              break label195;
            }
            localObject1 = HtmlOffline.a((String)localObject2, paramString, false);
            b(paramString);
            return localObject1;
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2;
        localException.printStackTrace();
        WebResourceResponse localWebResourceResponse = null;
        continue;
        i += 1;
        continue;
        label195:
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
        localWebResourceResponse = HtmlOffline.a((String)localObject2, paramString, true);
        continue;
        localWebResourceResponse = HtmlOffline.a((String)localObject2, paramString, false);
        continue;
        label229:
        int i = 0;
        continue;
        localWebResourceResponse = null;
      }
    }
  }
  
  protected String a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 2, "checkOfflineUrl");
    }
    if ((TextUtils.isEmpty(paramString)) || (!Uri.parse(paramString).isHierarchical())) {}
    for (;;)
    {
      return paramString;
      try
      {
        this.jdField_b_of_type_JavaLangString = Uri.parse(paramString).getQueryParameter("_bid");
        if (this.jdField_c_of_type_JavaLangString == null) {
          this.jdField_c_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
        }
        if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
        {
          this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.b(paramString);
          if (this.jdField_c_of_type_JavaLangString == null) {
            this.jdField_c_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
          }
          if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
            if (!paramString.contains("?"))
            {
              String str1 = paramString + "?";
              str1 = str1 + "&_bid=" + this.jdField_b_of_type_JavaLangString;
              if (a()) {
                continue;
              }
              if (QLog.isColorLevel()) {
                QLog.i(this.jdField_a_of_type_JavaLangString, 2, "checkOfflineUrl:" + str1);
              }
              return str1;
            }
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          continue;
          String str2 = paramString;
          continue;
          str2 = paramString;
        }
      }
    }
  }
  
  public void a()
  {
    if ((jdField_a_of_type_JavaUtilHashMap != null) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)))
    {
      localObject = (OfflineUpdateStatus)jdField_a_of_type_JavaUtilHashMap.get(this.jdField_c_of_type_JavaLangString);
      if (localObject != null) {
        ((OfflineUpdateStatus)localObject).a();
      }
    }
    Object localObject = this.mRuntime.a();
    if (localObject == null) {}
    WebView localWebView;
    do
    {
      do
      {
        return;
      } while (!(localObject instanceof QQBrowserActivity));
      localObject = (QQBrowserActivity)localObject;
      localWebView = this.mRuntime.a();
    } while (localWebView == null);
    localWebView.loadUrl(((QQBrowserActivity)localObject).I);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!a(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 2, "checkOfflineUp.");
    }
    String str = HtmlOffline.a(this.jdField_c_of_type_JavaLangString);
    long l2 = 0L;
    long l1 = l2;
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      l1 = Long.parseLong(str);
      HtmlOffline.a(this.mRuntime.a().getApplicationContext(), paramString, this.mRuntime.a().a(), new bup(this, paramString, l1));
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        l1 = l2;
      }
    }
  }
  
  protected boolean a(String paramString)
  {
    Object localObject2 = "0";
    try
    {
      String str = Uri.parse(paramString).getQueryParameter("_duck");
      localObject2 = str;
      if (TextUtils.isEmpty(str)) {
        localObject2 = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.c(paramString);
      }
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).equals("1")))
      {
        if (QLog.isDevelopLevel()) {
          QLog.e("webviewLoadUrl", 4, "1 checkOfflineUp _duck=1");
        }
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        Object localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.e("QQBrowserActivity", 2, "checkOfflineUpr:url parse exception:" + paramString);
          localObject1 = localObject2;
        }
      }
    }
    return true;
  }
  
  protected void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!a(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 2, "checkOfflineUpNotCallback.");
    }
    HtmlOffline.a(this.mRuntime.a().getApplicationContext(), paramString, this.mRuntime.a().a());
  }
  
  protected void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 2, "webviewLoadUrl...");
    }
    long l = System.currentTimeMillis();
    HtmlOffline.a(this.mRuntime.a().getApplicationContext(), paramString, new bus(this, l));
  }
  
  protected Object handleEvent(String paramString, int paramInt)
  {
    if (paramInt == 11) {
      return a(paramString);
    }
    return null;
  }
  
  protected boolean handleEvent(String paramString, int paramInt, Map paramMap)
  {
    if (paramInt == 5)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      paramString = this.mRuntime.a();
      if (paramString != null) {
        break label28;
      }
    }
    label28:
    do
    {
      do
      {
        return false;
      } while ((jdField_a_of_type_JavaUtilHashMap == null) || (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)));
      paramMap = (OfflineUpdateStatus)jdField_a_of_type_JavaUtilHashMap.get(this.jdField_c_of_type_JavaLangString);
    } while (paramMap == null);
    paramMap.a(this.jdField_a_of_type_ComTencentBizCommonUtilLoadedBack2);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    switch (paramMap.b())
    {
    default: 
      return false;
    case 0: 
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramMap.jdField_c_of_type_JavaLangString);
      paramString = paramString.getResources().getDrawable(2130838729);
      paramString.setBounds(0, 0, 40, 40);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(paramString, null, null, null);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      return false;
    case 1: 
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramMap.e + paramMap.c() + "%");
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      return false;
    case 2: 
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramMap.c());
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return false;
    case 3: 
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramMap.d);
      paramString = paramString.getResources().getDrawable(2130837839);
      paramString.setBounds(0, 0, paramString.getMinimumWidth(), paramString.getMinimumHeight());
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(paramString, null, null, null);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      return false;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    return false;
  }
  
  protected boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    if (this.jdField_c_of_type_Boolean) {}
    do
    {
      do
      {
        return false;
      } while ((!paramString2.equals("http")) && (!paramString2.equals("https")));
      paramString1 = a(paramString1);
    } while (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString));
    c(paramString1);
    return true;
  }
  
  protected void onCreate()
  {
    super.onCreate();
    if (this.mRuntime == null) {}
    Activity localActivity;
    do
    {
      return;
      localActivity = this.mRuntime.a();
    } while ((localActivity == null) || (!(localActivity instanceof QQBrowserActivity)));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localActivity.findViewById(2131231174));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localActivity.findViewById(2131231177));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localActivity.findViewById(2131231176));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localActivity.findViewById(2131231175));
    this.jdField_a_of_type_ComTencentBizAuthorizeConfig = AuthorizeConfig.a();
    b();
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Boolean = true;
    if ((jdField_a_of_type_JavaUtilHashMap != null) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)))
    {
      OfflineUpdateStatus localOfflineUpdateStatus = (OfflineUpdateStatus)jdField_a_of_type_JavaUtilHashMap.get(this.jdField_c_of_type_JavaLangString);
      if (localOfflineUpdateStatus != null)
      {
        localOfflineUpdateStatus.b(this.jdField_a_of_type_ComTencentBizCommonUtilLoadedBack2);
        if (localOfflineUpdateStatus.a() == 0) {
          jdField_a_of_type_JavaUtilHashMap.remove(this.jdField_c_of_type_JavaLangString);
        }
      }
      if (jdField_a_of_type_JavaUtilHashMap.size() == 0) {
        jdField_a_of_type_JavaUtilHashMap = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.OfflinePlugin
 * JD-Core Version:    0.7.0.1
 */