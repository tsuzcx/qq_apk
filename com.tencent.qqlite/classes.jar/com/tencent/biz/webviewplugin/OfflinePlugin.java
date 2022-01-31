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
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.util.LoadedBack2;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
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
import rv;
import rw;
import rx;
import ry;
import rz;
import sa;

public class OfflinePlugin
  extends WebViewPlugin
{
  public static HashMap a;
  static final int jdField_b_of_type_Int = Build.VERSION.SDK_INT;
  protected int a;
  public Handler a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ry(this);
  public LinearLayout a;
  public ProgressBar a;
  public RelativeLayout a;
  public TextView a;
  private AuthorizeConfig jdField_a_of_type_ComTencentBizAuthorizeConfig;
  private LoadedBack2 jdField_a_of_type_ComTencentBizCommonUtilLoadedBack2 = new rz(this);
  private Runnable jdField_a_of_type_JavaLangRunnable = new sa(this);
  private String jdField_a_of_type_JavaLangString = "offline";
  protected ArrayList a;
  public boolean a;
  private String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = false;
  public int c;
  private String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean = false;
  
  public OfflinePlugin()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 0;
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
        localOfflineUpdateStatus.e = ((Activity)localObject1).getResources().getString(2131362499);
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
      localOfflineUpdateStatus.b(1);
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
    localOfflineUpdateStatus.b(0);
    Object localObject1 = ((Activity)localObject1).getResources().getDrawable(2130838642);
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
  
  private void c()
  {
    this.jdField_a_of_type_AndroidOsHandler = new rw(this);
  }
  
  public WebResourceResponse a(String paramString)
  {
    int i = 0;
    int k = 0;
    if ((this.jdField_c_of_type_Boolean) || (TextUtils.isEmpty(paramString)) || (!paramString.startsWith("http"))) {}
    String str2;
    for (;;)
    {
      return null;
      if (((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || ((!TextUtils.isEmpty(paramString)) && (paramString.contains("_bid=")))) && (!a())) {
        try
        {
          String str1 = Uri.parse(paramString).getQueryParameter("_bid");
          str2 = str1;
          if (TextUtils.isEmpty(str1)) {
            str2 = this.jdField_b_of_type_JavaLangString;
          }
          if (!TextUtils.isEmpty(str2)) {
            if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (!str2.equals(this.jdField_b_of_type_JavaLangString)))
            {
              b(paramString);
              if (this.jdField_a_of_type_JavaUtilArrayList == null) {
                this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
              }
              int m = this.jdField_a_of_type_JavaUtilArrayList.size();
              i = 0;
              int j = k;
              if (i < m)
              {
                if (str2.equals(this.jdField_a_of_type_JavaUtilArrayList.get(i))) {
                  j = 1;
                }
              }
              else
              {
                if (j == 0) {
                  this.jdField_a_of_type_JavaUtilArrayList.add(str2);
                }
                if ((j != 0) || (HtmlOffline.f(str2))) {
                  break label251;
                }
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d(this.jdField_a_of_type_JavaLangString, 2, "verfySign fail to reload");
                return null;
              }
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            Object localObject = null;
            continue;
            i += 1;
          }
          label251:
          i = 1;
          if (((this.jdField_c_of_type_Int == 3) || (i != 0)) && (!HtmlOffline.a(str2, paramString)))
          {
            b();
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "shouldInterceptRequest verfy single fail to reload");
            return null;
          }
        }
      }
    }
    return HtmlOffline.a(str2, paramString);
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
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
          if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
          {
            String str1 = HtmlOffline.a(paramString, "_bid=" + this.jdField_b_of_type_JavaLangString);
            if (a()) {
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.i(this.jdField_a_of_type_JavaLangString, 2, "checkOfflineUrl:" + Util.b(str1, new String[0]));
            }
            return str1;
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
        }
      }
    }
  }
  
  public void a()
  {
    if ((jdField_a_of_type_JavaUtilHashMap != null) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)))
    {
      OfflineUpdateStatus localOfflineUpdateStatus = (OfflineUpdateStatus)jdField_a_of_type_JavaUtilHashMap.get(this.jdField_c_of_type_JavaLangString);
      if (localOfflineUpdateStatus != null) {
        localOfflineUpdateStatus.a();
      }
    }
    b();
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
    HtmlOffline.a(this.mRuntime.a().getApplicationContext(), paramString, this.mRuntime.a().a(), new rv(this));
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
          QLog.e("QQBrowserActivity", 2, "checkOfflineUpr:url parse exception:" + Util.b(paramString, new String[0]));
          localObject1 = localObject2;
        }
      }
    }
    return true;
  }
  
  public void b()
  {
    Object localObject = this.mRuntime.a();
    if (localObject == null) {}
    do
    {
      CustomWebView localCustomWebView;
      do
      {
        do
        {
          return;
        } while (!(localObject instanceof QQBrowserActivity));
        localObject = (QQBrowserActivity)localObject;
        localCustomWebView = this.mRuntime.a();
      } while (localCustomWebView == null);
      localCustomWebView.loadUrl(((QQBrowserActivity)localObject).K);
    } while (!QLog.isColorLevel());
    QLog.i(this.jdField_a_of_type_JavaLangString, 2, "reloadCurrentUrl");
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
    if (!HtmlOffline.a(this.mRuntime.a().getApplicationContext(), paramString, new rx(this, l)))
    {
      this.mRuntime.a().a(paramString);
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, "transToLocalUrl: return false");
      }
    }
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
      if ((paramString != null) && ((paramString instanceof QQBrowserActivity))) {
        break label35;
      }
    }
    label35:
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
      paramString = paramString.getResources().getDrawable(2130838642);
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
      paramString = paramString.getResources().getDrawable(2130837747);
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
      this.jdField_a_of_type_ComTencentBizAuthorizeConfig = AuthorizeConfig.a();
      c();
    } while ((localActivity == null) || (!(localActivity instanceof QQBrowserActivity)));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localActivity.findViewById(2131296634));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localActivity.findViewById(2131296637));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localActivity.findViewById(2131296636));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localActivity.findViewById(2131296635));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.OfflinePlugin
 * JD-Core Version:    0.7.0.1
 */