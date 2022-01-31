package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.protofile.getopenid.GetOpenidProto.GetOpenidEntry;
import com.tencent.protofile.getopenid.GetOpenidProto.GetOpenidReq;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebBackForwardList;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.ActionSheet.OnDismissListener;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XListView;
import dwz;
import dxd;
import dxe;
import java.net.URLEncoder;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UiApiPlugin
  extends WebViewPlugin
  implements DialogInterface.OnCancelListener, View.OnClickListener, ActionSheet.OnButtonClickListener, ActionSheet.OnDismissListener, OverScrollViewListener
{
  static final byte jdField_a_of_type_Byte = 3;
  public static final int a = 1001;
  public static final String a;
  static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  static final byte jdField_b_of_type_Byte = 4;
  public static final int b = 0;
  static final String jdField_b_of_type_JavaLangString = "name";
  static final byte jdField_c_of_type_Byte = 5;
  public static final int c = 1;
  static final String jdField_c_of_type_JavaLangString = "callback";
  static final String jdField_d_of_type_JavaLangString = "callback_url";
  static final String jdField_e_of_type_JavaLangString = "mode";
  static final String jdField_f_of_type_JavaLangString = "exclude";
  static final String g = "com.tencent.mobileqq.action.ACTION_WEBVIEW_CLOSE";
  static final String h = "ret";
  static final String i = "uin";
  static final String j = "errMsg";
  static final String k = "openids";
  static final String l = "types";
  private ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new dwz(this);
  private View jdField_a_of_type_AndroidViewView;
  TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = null;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private dxe jdField_a_of_type_Dxe;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean jdField_b_of_type_Boolean;
  private boolean jdField_c_of_type_Boolean;
  public int d;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = 0;
  private boolean jdField_e_of_type_Boolean = false;
  private int jdField_f_of_type_Int;
  protected String m = null;
  private String n;
  private String o;
  private String p;
  private String q;
  private String r;
  
  static
  {
    jdField_a_of_type_JavaLangString = UiApiPlugin.class.getSimpleName();
  }
  
  public UiApiPlugin()
  {
    this.jdField_d_of_type_Int = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
    this.b = false;
    this.c = false;
    this.f = -1;
  }
  
  static int a(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      i1 = paramJSONObject.getInt(paramString);
      return i1;
    }
    catch (JSONException localJSONException)
    {
      try
      {
        int i1 = Color.parseColor(paramJSONObject.getString(paramString));
        return i1;
      }
      catch (Exception paramJSONObject) {}
    }
    return 0;
  }
  
  public static void a(Activity paramActivity, AppInterface paramAppInterface, long paramLong, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int i2 = paramArrayOfString.length;
    if ((i2 == 0) || (i2 != paramArrayOfInt.length) || (paramLong == -1L))
    {
      paramActivity.setResult(-1, new Intent().putExtra("ret", 4));
      paramActivity.finish();
      return;
    }
    GetOpenidProto.GetOpenidReq localGetOpenidReq = new GetOpenidProto.GetOpenidReq();
    localGetOpenidReq.appid.set(paramLong);
    int i1 = 0;
    if (i1 < i2)
    {
      GetOpenidProto.GetOpenidEntry localGetOpenidEntry = new GetOpenidProto.GetOpenidEntry();
      for (;;)
      {
        int i3;
        try
        {
          localGetOpenidEntry.id.set(Long.parseLong(paramArrayOfString[i1], 10));
          i3 = paramArrayOfInt[i1];
          if (i3 == 0)
          {
            localGetOpenidEntry.type.set(0);
            localGetOpenidReq.list.add(localGetOpenidEntry);
            i1 += 1;
          }
        }
        catch (NumberFormatException paramAppInterface)
        {
          paramActivity.setResult(-1, new Intent().putExtra("ret", 4).putExtra("errMsg", "uin error"));
          paramActivity.finish();
          return;
        }
        if (i3 == 1)
        {
          localGetOpenidEntry.type.set(1);
        }
        else
        {
          if (i3 != 3000) {
            break label213;
          }
          localGetOpenidEntry.type.set(2);
        }
      }
      label213:
      paramActivity.setResult(-1, new Intent().putExtra("ret", 4).putExtra("errMsg", "uin type error"));
      paramActivity.finish();
      return;
    }
    paramArrayOfString = new NewIntent(BaseApplicationImpl.getContext(), ProtoServlet.class);
    paramArrayOfString.setWithouLogin(true);
    paramArrayOfString.putExtra("cmd", "CommCompSvr.get_openid");
    paramArrayOfString.putExtra("data", localGetOpenidReq.toByteArray());
    paramArrayOfString.setObserver(new dxd(paramActivity));
    paramAppInterface.startServlet(paramArrayOfString);
  }
  
  private void a(String paramString)
  {
    int i1 = 0;
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject1;
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null)
      {
        if (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
          this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        }
        if (paramString.equals(this.n))
        {
          this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
          return;
        }
      }
      localObject1 = this.mRuntime.a();
    } while (localObject1 == null);
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        localObject1 = ActionSheet.a((Context)localObject1, 2131624119);
        Object localObject2 = localJSONObject.optString("title");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((ActionSheet)localObject1).a((CharSequence)localObject2);
        }
        localObject2 = localJSONObject.optJSONArray("items");
        if ((localObject2 == null) || (((JSONArray)localObject2).length() <= 0)) {
          break label286;
        }
        int i3 = ((JSONArray)localObject2).length();
        i2 = i3;
        if (i1 < i3)
        {
          ((ActionSheet)localObject1).c(((JSONArray)localObject2).getString(i1));
          i1 += 1;
          continue;
        }
        localObject2 = localJSONObject.optString("cancel");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((ActionSheet)localObject1).d((CharSequence)localObject2);
        }
        ((ActionSheet)localObject1).a(this);
        ((ActionSheet)localObject1).a(this);
        ((ActionSheet)localObject1).setOnCancelListener(this);
        this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)localObject1);
        this.o = localJSONObject.optString("onclick");
        this.jdField_e_of_type_Int = i2;
        this.n = paramString;
        this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
        return;
      }
      catch (JSONException paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "showActionSheet error:" + paramString.getMessage());
      return;
      label286:
      int i2 = 0;
    }
  }
  
  private void a(JSONObject paramJSONObject)
  {
    Activity localActivity = this.mRuntime.a();
    if (localActivity == null) {}
    int i1;
    String str1;
    String str2;
    String str3;
    boolean bool;
    int i2;
    do
    {
      return;
      i1 = paramJSONObject.optInt("iconID");
      str1 = paramJSONObject.optString("title");
      str2 = paramJSONObject.optString("callback");
      str3 = paramJSONObject.optString("color");
      bool = paramJSONObject.optBoolean("hidden");
      i2 = paramJSONObject.optInt("cornerID");
    } while (!(localActivity instanceof QQBrowserActivity));
    ((QQBrowserActivity)localActivity).a(str2, str1, str3, bool, i1, i2);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean == this.jdField_e_of_type_Boolean) {}
    do
    {
      return;
      if (!paramBoolean) {
        break label214;
      }
      if (this.jdField_a_of_type_AndroidViewView != null) {
        break;
      }
      localObject2 = BaseApplicationImpl.getContext();
      localObject1 = this.mRuntime.a();
    } while ((localObject1 == null) || (((Activity)localObject1).isFinishing()));
    TextView localTextView = new TextView((Context)localObject1);
    localTextView.setText(2131363523);
    localTextView.setBackgroundResource(2130839424);
    localTextView.setGravity(17);
    localTextView.setIncludeFontPadding(false);
    localTextView.setMaxWidth(Util.a((Context)localObject2, 100.0F));
    localTextView.setMinWidth(Util.a((Context)localObject2, 52.0F));
    localTextView.setSingleLine();
    localTextView.setTextColor(((Context)localObject2).getResources().getColor(2131427462));
    localTextView.setTextSize(1, 17.0F);
    Object localObject2 = new RelativeLayout.LayoutParams(-2, Util.a((Context)localObject2, 36.0F));
    ((RelativeLayout.LayoutParams)localObject2).addRule(0, 2131296900);
    ((RelativeLayout.LayoutParams)localObject2).addRule(15, -1);
    localTextView.setOnClickListener(this);
    Object localObject1 = (RelativeLayout)((Activity)localObject1).findViewById(2131296890);
    if (localObject1 != null) {
      ((RelativeLayout)localObject1).addView(localTextView, (ViewGroup.LayoutParams)localObject2);
    }
    this.jdField_a_of_type_AndroidViewView = localTextView;
    for (;;)
    {
      this.jdField_e_of_type_Boolean = true;
      return;
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    label214:
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_e_of_type_Boolean = false;
  }
  
  private void b(String paramString)
  {
    Activity localActivity = this.mRuntime.a();
    if (localActivity == null) {}
    Object localObject;
    do
    {
      return;
      localObject = this.mRuntime.a();
    } while (localObject == null);
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        String str = paramString.optString("url");
        JSONObject localJSONObject = paramString.getJSONObject("options");
        if (localActivity.getClass().getSimpleName().equals("VASWebviewActivity"))
        {
          ((WebView)localObject).loadUrl(str);
          return;
        }
        if ((TextUtils.isEmpty(str)) || (localJSONObject == null) || (!localJSONObject.has("style"))) {
          break;
        }
        paramString = localActivity.getIntent().getExtras();
        if (paramString == null) {
          paramString = new Bundle();
        }
        switch (localJSONObject.optInt("style"))
        {
        case 0: 
          localObject = new Intent(localActivity, localActivity.getClass());
          ((Intent)localObject).putExtras(paramString);
          ((Intent)localObject).putExtra("url", str);
          ((Intent)localObject).setFlags(0);
          localActivity.startActivityForResult((Intent)localObject, 100);
          switch (localJSONObject.optInt("animation"))
          {
          case 0: 
          case 1: 
            localActivity.overridePendingTransition(0, 0);
            return;
            paramString.remove("title");
            paramString.remove("leftViewText");
            paramString.remove("post_data");
            paramString.remove("options");
            continue;
            paramString.putBoolean("hide_more_button", false);
            paramString.putBoolean("hide_operation_bar", true);
          }
          break;
        case 1: 
          paramString.putBoolean("hide_more_button", true);
          paramString.putBoolean("hide_operation_bar", true);
          break;
        case 2: 
          paramString.putBoolean("hide_more_button", false);
          paramString.putBoolean("hide_operation_bar", false);
          paramString.putString("webStyle", "");
          break;
        case 3: 
          paramString.putBoolean("hide_more_button", true);
          paramString.putBoolean("hide_operation_bar", false);
          paramString.putString("webStyle", "");
          continue;
          localActivity.overridePendingTransition(2130968635, 0);
          return;
        }
      }
      catch (JSONException paramString)
      {
        return;
      }
    }
  }
  
  void a()
  {
    Object localObject = this.mRuntime.a();
    Activity localActivity = this.mRuntime.a();
    if ((localObject == null) || (localActivity == null) || (localActivity.isFinishing())) {}
    ViewParent localViewParent;
    do
    {
      return;
      localObject = (View)((WebView)localObject).getParent();
      localViewParent = ((View)localObject).getParent();
    } while (!(localViewParent instanceof ViewGroup));
    if (!this.b)
    {
      this.b = true;
      this.jdField_a_of_type_ComTencentWidgetXListView = new XListView(localActivity);
      this.jdField_a_of_type_ComTencentWidgetXListView.setLayoutParams(new FrameLayout.LayoutParams((FrameLayout.LayoutParams)((View)localObject).getLayoutParams()));
      ((ViewGroup)localViewParent).removeView((View)localObject);
      ((View)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, -2, 0));
      this.jdField_a_of_type_Dxe = new dxe((View)localObject);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Dxe);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(localActivity).inflate(2130903274, this.jdField_a_of_type_ComTencentWidgetXListView, false));
      ((ViewGroup)localViewParent).addView(this.jdField_a_of_type_ComTencentWidgetXListView, 0);
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollDistance(2147483647);
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(0L);
  }
  
  public void a(View paramView, int paramInt)
  {
    if (!TextUtils.isEmpty(this.o)) {
      callJs(this.o, new String[] { "0", Integer.toString(paramInt) });
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (!this.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0L);
      this.jdField_d_of_type_Boolean = true;
      dispatchJsEvent("qbrowserPullDown", null, null);
    }
    return true;
  }
  
  void b()
  {
    if (this.b)
    {
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_d_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentWidgetXListView.C();
      }
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader((View)null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollDistance(0);
    }
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    if (!this.jdField_d_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(0L);
    }
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  public void e()
  {
    if (!TextUtils.isEmpty(this.o)) {
      callJs(this.o, new String[] { "1", Integer.toString(this.jdField_e_of_type_Int) });
    }
  }
  
  protected boolean handleEvent(String paramString, int paramInt, Map paramMap)
  {
    if (paramInt == 6)
    {
      this.jdField_a_of_type_Boolean = false;
      callJs("~function(d,e){try{e=d.createEvent('Event');e.initEvent('qbrowserVisibilityChange');e.hidden=true;d.dispatchEvent(e)}catch(err){}}(document);");
    }
    for (;;)
    {
      return false;
      if (paramInt == 5)
      {
        this.jdField_a_of_type_Boolean = true;
        callJs("~function(d,e){try{e=d.createEvent('Event');e.initEvent('qbrowserVisibilityChange');e.hidden=false;d.dispatchEvent(e)}catch(err){}}(document);");
      }
      else if (paramInt == 14)
      {
        this.m = null;
      }
      else if ((paramInt == 12) || (paramInt == 13))
      {
        if (!TextUtils.isEmpty(this.m))
        {
          callJs(this.m, new String[] { "" });
          return true;
        }
        if (paramInt == 12)
        {
          if (this.f == -1)
          {
            this.f = 0;
            paramString = this.mRuntime.a();
            if ((paramString instanceof QQBrowserActivity))
            {
              Object localObject = paramString.getIntent();
              if (((((QQBrowserActivity)paramString).v & 0x200000) == 0) && (!((Intent)localObject).getBooleanExtra("show_right_close_button", false)))
              {
                localObject = (TextView)paramString.findViewById(2131296901);
                if ((localObject == null) || (((TextView)localObject).getVisibility() != 0) || (!paramString.getString(2131363523).equals(((TextView)localObject).getText()))) {
                  break label214;
                }
              }
            }
          }
          while (this.f == 0)
          {
            return false;
            label214:
            if ((((QQBrowserActivity)paramString).v & 0x4) == 0) {
              this.f = 1;
            }
          }
          paramString = paramMap.get("target");
          if (!(paramString instanceof Integer)) {
            return false;
          }
          paramInt = ((Integer)paramString).intValue();
          if ((paramInt != 1) && (paramInt != 3)) {
            return false;
          }
          paramString = this.mRuntime.a();
          if (paramString != null)
          {
            paramInt = paramString.copyBackForwardList().getCurrentIndex();
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "web history current index:" + paramInt);
            }
            if (paramInt > 1) {
              a(true);
            } else {
              a(false);
            }
          }
        }
      }
    }
  }
  
  /* Error */
  protected boolean handleJsRequest(com.tencent.mobileqq.webviewplugin.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: ldc_w 729
    //   3: aload_3
    //   4: invokevirtual 289	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7: ifeq +2586 -> 2593
    //   10: ldc_w 731
    //   13: aload 4
    //   15: invokevirtual 289	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   18: ifeq +130 -> 148
    //   21: aload 5
    //   23: arraylength
    //   24: ifle +124 -> 148
    //   27: aload_0
    //   28: getfield 296	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   31: invokevirtual 301	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   34: astore_1
    //   35: new 130	org/json/JSONObject
    //   38: dup
    //   39: aload 5
    //   41: iconst_0
    //   42: aaload
    //   43: invokespecial 303	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   46: astore_2
    //   47: aload_2
    //   48: ldc_w 733
    //   51: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   54: astore_3
    //   55: aload_2
    //   56: ldc_w 734
    //   59: invokevirtual 378	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   62: tableswitch	default:+2538 -> 2600, 0:+22->84, 1:+52->114
    //   85: invokestatic 270	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   88: ifne +2512 -> 2600
    //   91: aload_1
    //   92: aload_3
    //   93: iconst_0
    //   94: invokestatic 739	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   97: aload_1
    //   98: invokevirtual 439	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   101: ldc_w 740
    //   104: invokevirtual 743	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   107: invokevirtual 746	com/tencent/mobileqq/widget/QQToast:b	(I)Landroid/widget/Toast;
    //   110: pop
    //   111: goto +2489 -> 2600
    //   114: aload_3
    //   115: invokestatic 270	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   118: ifne +2482 -> 2600
    //   121: aload_1
    //   122: iconst_0
    //   123: aload_3
    //   124: iconst_0
    //   125: invokestatic 749	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   128: iconst_0
    //   129: invokevirtual 751	com/tencent/mobileqq/widget/QQToast:a	(I)Landroid/widget/Toast;
    //   132: astore_1
    //   133: aload_1
    //   134: bipush 23
    //   136: iconst_0
    //   137: iconst_0
    //   138: invokevirtual 755	android/widget/Toast:setGravity	(III)V
    //   141: aload_1
    //   142: invokevirtual 756	android/widget/Toast:show	()V
    //   145: goto +2455 -> 2600
    //   148: ldc_w 758
    //   151: aload 4
    //   153: invokevirtual 289	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   156: ifeq +50 -> 206
    //   159: new 130	org/json/JSONObject
    //   162: dup
    //   163: aload 5
    //   165: iconst_0
    //   166: aaload
    //   167: invokespecial 303	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   170: ldc_w 733
    //   173: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   176: astore_1
    //   177: aload_1
    //   178: invokestatic 270	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   181: ifne +2419 -> 2600
    //   184: aload_0
    //   185: aload_0
    //   186: getfield 296	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   189: invokevirtual 301	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   192: aload_1
    //   193: invokestatic 763	com/tencent/mobileqq/maproam/Utils:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/app/ProgressDialog;
    //   196: putfield 765	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   199: goto +2401 -> 2600
    //   202: astore_1
    //   203: goto +2397 -> 2600
    //   206: ldc_w 767
    //   209: aload 4
    //   211: invokevirtual 289	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   214: ifeq +52 -> 266
    //   217: aload_0
    //   218: getfield 765	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   221: ifnull +2379 -> 2600
    //   224: aload_0
    //   225: getfield 765	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   228: invokevirtual 770	android/app/ProgressDialog:isShowing	()Z
    //   231: ifeq +2369 -> 2600
    //   234: aload_0
    //   235: getfield 765	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   238: invokevirtual 771	android/app/ProgressDialog:dismiss	()V
    //   241: aload_0
    //   242: aconst_null
    //   243: putfield 765	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   246: goto +2354 -> 2600
    //   249: astore_1
    //   250: aload_0
    //   251: aconst_null
    //   252: putfield 765	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   255: goto +2345 -> 2600
    //   258: astore_1
    //   259: aload_0
    //   260: aconst_null
    //   261: putfield 765	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   264: aload_1
    //   265: athrow
    //   266: ldc_w 773
    //   269: aload 4
    //   271: invokevirtual 289	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   274: ifeq +21 -> 295
    //   277: aload 5
    //   279: arraylength
    //   280: iconst_1
    //   281: if_icmpne +14 -> 295
    //   284: aload_0
    //   285: aload 5
    //   287: iconst_0
    //   288: aaload
    //   289: invokespecial 775	com/tencent/mobileqq/jsp/UiApiPlugin:b	(Ljava/lang/String;)V
    //   292: goto +2308 -> 2600
    //   295: ldc_w 777
    //   298: aload 4
    //   300: invokevirtual 289	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   303: ifeq +17 -> 320
    //   306: aload_1
    //   307: aload_0
    //   308: getfield 98	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Boolean	Z
    //   311: invokestatic 783	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   314: invokevirtual 788	com/tencent/mobileqq/webviewplugin/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   317: goto +2283 -> 2600
    //   320: ldc_w 790
    //   323: aload 4
    //   325: invokevirtual 289	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   328: ifeq +49 -> 377
    //   331: aload 5
    //   333: arraylength
    //   334: iconst_1
    //   335: if_icmpne +42 -> 377
    //   338: aload_0
    //   339: new 130	org/json/JSONObject
    //   342: dup
    //   343: aload 5
    //   345: iconst_0
    //   346: aaload
    //   347: invokespecial 303	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   350: invokespecial 792	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;)V
    //   353: goto +2247 -> 2600
    //   356: astore_1
    //   357: invokestatic 354	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   360: ifeq +2240 -> 2600
    //   363: getstatic 83	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   366: iconst_2
    //   367: ldc_w 794
    //   370: aload_1
    //   371: invokestatic 797	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   374: goto +2226 -> 2600
    //   377: ldc_w 799
    //   380: aload 4
    //   382: invokevirtual 289	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   385: ifeq +145 -> 530
    //   388: aload 5
    //   390: arraylength
    //   391: iconst_1
    //   392: if_icmpne +138 -> 530
    //   395: aload_0
    //   396: getfield 296	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   399: invokevirtual 301	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   402: astore_1
    //   403: aload_1
    //   404: ifnull +2202 -> 2606
    //   407: aload_1
    //   408: invokevirtual 398	android/app/Activity:isFinishing	()Z
    //   411: ifeq +6 -> 417
    //   414: goto +2192 -> 2606
    //   417: new 130	org/json/JSONObject
    //   420: dup
    //   421: aload 5
    //   423: iconst_0
    //   424: aaload
    //   425: invokespecial 303	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   428: astore_2
    //   429: aload_2
    //   430: ldc_w 801
    //   433: invokevirtual 804	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   436: astore_3
    //   437: aload_3
    //   438: ifnull +51 -> 489
    //   441: aload_3
    //   442: ldc_w 309
    //   445: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   448: astore 4
    //   450: aload 4
    //   452: invokestatic 270	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   455: ifne +24 -> 479
    //   458: aload_1
    //   459: ldc_w 805
    //   462: invokevirtual 473	android/app/Activity:findViewById	(I)Landroid/view/View;
    //   465: checkcast 400	android/widget/TextView
    //   468: astore_1
    //   469: aload_1
    //   470: ifnull +9 -> 479
    //   473: aload_1
    //   474: aload 4
    //   476: invokevirtual 807	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   479: aload_0
    //   480: aload_3
    //   481: ldc 31
    //   483: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   486: putfield 100	com/tencent/mobileqq/jsp/UiApiPlugin:m	Ljava/lang/String;
    //   489: aload_2
    //   490: ldc_w 809
    //   493: invokevirtual 804	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   496: astore_1
    //   497: aload_1
    //   498: ifnull +2102 -> 2600
    //   501: aload_0
    //   502: aload_1
    //   503: invokespecial 792	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;)V
    //   506: goto +2094 -> 2600
    //   509: astore_1
    //   510: invokestatic 354	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   513: ifeq +2087 -> 2600
    //   516: getstatic 83	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   519: iconst_2
    //   520: ldc_w 811
    //   523: aload_1
    //   524: invokestatic 797	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   527: goto +2073 -> 2600
    //   530: ldc_w 813
    //   533: aload 4
    //   535: invokevirtual 289	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   538: ifeq +21 -> 559
    //   541: aload 5
    //   543: arraylength
    //   544: iconst_1
    //   545: if_icmpne +14 -> 559
    //   548: aload_0
    //   549: aload 5
    //   551: iconst_0
    //   552: aaload
    //   553: invokespecial 815	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/lang/String;)V
    //   556: goto +2044 -> 2600
    //   559: ldc_w 817
    //   562: aload 4
    //   564: invokevirtual 289	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   567: ifeq +147 -> 714
    //   570: aload 5
    //   572: arraylength
    //   573: iconst_1
    //   574: if_icmpne +140 -> 714
    //   577: new 130	org/json/JSONObject
    //   580: dup
    //   581: aload 5
    //   583: iconst_0
    //   584: aaload
    //   585: invokespecial 303	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   588: astore_2
    //   589: aload_2
    //   590: ldc 26
    //   592: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   595: astore_1
    //   596: aload_0
    //   597: aload_2
    //   598: ldc 31
    //   600: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   603: putfield 819	com/tencent/mobileqq/jsp/UiApiPlugin:p	Ljava/lang/String;
    //   606: aload_0
    //   607: getfield 296	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   610: invokevirtual 487	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   613: invokevirtual 824	com/tencent/biz/pubaccount/CustomWebView:getUrl	()Ljava/lang/String;
    //   616: astore_2
    //   617: new 153	android/content/Intent
    //   620: dup
    //   621: aload_0
    //   622: getfield 296	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   625: invokevirtual 301	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   628: ldc_w 826
    //   631: invokespecial 525	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   634: ldc_w 827
    //   637: ldc_w 829
    //   640: invokevirtual 215	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   643: astore_3
    //   644: aload_1
    //   645: invokestatic 270	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   648: ifeq +36 -> 684
    //   651: aload_0
    //   652: getfield 819	com/tencent/mobileqq/jsp/UiApiPlugin:p	Ljava/lang/String;
    //   655: invokestatic 270	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   658: ifeq +26 -> 684
    //   661: aload_3
    //   662: ldc_w 831
    //   665: iconst_1
    //   666: invokevirtual 834	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   669: pop
    //   670: aload_0
    //   671: getfield 296	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   674: invokevirtual 301	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   677: aload_3
    //   678: invokevirtual 838	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   681: goto +1919 -> 2600
    //   684: aload_3
    //   685: ldc 26
    //   687: aload_1
    //   688: invokevirtual 215	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   691: ldc 34
    //   693: aload_2
    //   694: invokevirtual 215	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   697: ldc_w 840
    //   700: iconst_1
    //   701: invokevirtual 834	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   704: pop
    //   705: aload_0
    //   706: aload_3
    //   707: iconst_3
    //   708: invokevirtual 843	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   711: goto +1889 -> 2600
    //   714: ldc_w 845
    //   717: aload 4
    //   719: invokevirtual 289	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   722: ifeq +41 -> 763
    //   725: aload 5
    //   727: arraylength
    //   728: iconst_1
    //   729: if_icmpne +34 -> 763
    //   732: aload_0
    //   733: new 130	org/json/JSONObject
    //   736: dup
    //   737: aload 5
    //   739: iconst_0
    //   740: aaload
    //   741: invokespecial 303	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   744: ldc 31
    //   746: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   749: putfield 100	com/tencent/mobileqq/jsp/UiApiPlugin:m	Ljava/lang/String;
    //   752: goto +1848 -> 2600
    //   755: astore_1
    //   756: aload_1
    //   757: invokevirtual 848	org/json/JSONException:printStackTrace	()V
    //   760: goto +1840 -> 2600
    //   763: ldc_w 850
    //   766: aload 4
    //   768: invokevirtual 289	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   771: ifeq +64 -> 835
    //   774: aload 5
    //   776: arraylength
    //   777: iconst_1
    //   778: if_icmpne +57 -> 835
    //   781: new 130	org/json/JSONObject
    //   784: dup
    //   785: aload 5
    //   787: iconst_0
    //   788: aaload
    //   789: invokespecial 303	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   792: ldc 31
    //   794: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   797: astore_1
    //   798: aload_0
    //   799: getfield 296	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   802: invokevirtual 301	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   805: astore_2
    //   806: aload_2
    //   807: instanceof 390
    //   810: ifeq +1790 -> 2600
    //   813: aload_2
    //   814: checkcast 390	com/tencent/mobileqq/activity/QQBrowserActivity
    //   817: invokevirtual 853	com/tencent/mobileqq/activity/QQBrowserActivity:a	()Lcom/tencent/biz/webviewplugin/Share;
    //   820: aload_1
    //   821: invokevirtual 856	com/tencent/biz/webviewplugin/Share:a	(Ljava/lang/String;)V
    //   824: goto +1776 -> 2600
    //   827: astore_1
    //   828: aload_1
    //   829: invokevirtual 848	org/json/JSONException:printStackTrace	()V
    //   832: goto +1768 -> 2600
    //   835: ldc_w 858
    //   838: aload 4
    //   840: invokevirtual 289	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   843: ifeq +258 -> 1101
    //   846: aload 5
    //   848: arraylength
    //   849: iconst_1
    //   850: if_icmpne +251 -> 1101
    //   853: new 130	org/json/JSONObject
    //   856: dup
    //   857: aload 5
    //   859: iconst_0
    //   860: aaload
    //   861: invokespecial 303	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   864: astore 5
    //   866: aload_0
    //   867: getfield 296	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   870: invokevirtual 301	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   873: astore 4
    //   875: aload 4
    //   877: ifnull +1735 -> 2612
    //   880: aload 4
    //   882: invokevirtual 398	android/app/Activity:isFinishing	()Z
    //   885: ifeq +6 -> 891
    //   888: goto +1724 -> 2612
    //   891: aload 5
    //   893: ldc_w 309
    //   896: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   899: astore_1
    //   900: aload 5
    //   902: ldc_w 733
    //   905: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   908: astore 12
    //   910: aload 5
    //   912: ldc_w 860
    //   915: iconst_1
    //   916: invokevirtual 862	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   919: istore 7
    //   921: aload 5
    //   923: ldc_w 864
    //   926: iconst_1
    //   927: invokevirtual 862	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   930: istore 8
    //   932: aload 5
    //   934: ldc_w 866
    //   937: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   940: astore_2
    //   941: aload 5
    //   943: ldc_w 868
    //   946: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   949: astore_3
    //   950: aload 5
    //   952: ldc 31
    //   954: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   957: astore 5
    //   959: aload 4
    //   961: iconst_0
    //   962: invokestatic 873	com/tencent/mobileqq/utils/DialogUtil:a	(Landroid/content/Context;I)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   965: astore 11
    //   967: aload 11
    //   969: aload_1
    //   970: invokevirtual 879	com/tencent/mobileqq/utils/QQCustomDialog:setTitle	(Ljava/lang/String;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   973: pop
    //   974: aload 11
    //   976: aload 12
    //   978: invokevirtual 883	com/tencent/mobileqq/utils/QQCustomDialog:setMessage	(Ljava/lang/CharSequence;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   981: pop
    //   982: new 885	dxa
    //   985: dup
    //   986: aload_0
    //   987: aload 5
    //   989: invokespecial 888	dxa:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/String;)V
    //   992: astore 12
    //   994: iload 8
    //   996: ifeq +30 -> 1026
    //   999: aload_3
    //   1000: astore_1
    //   1001: aload_3
    //   1002: invokestatic 270	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1005: ifeq +12 -> 1017
    //   1008: aload 4
    //   1010: ldc_w 889
    //   1013: invokevirtual 694	android/app/Activity:getString	(I)Ljava/lang/String;
    //   1016: astore_1
    //   1017: aload 11
    //   1019: aload_1
    //   1020: aload 12
    //   1022: invokevirtual 893	com/tencent/mobileqq/utils/QQCustomDialog:setNegativeButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   1025: pop
    //   1026: iload 7
    //   1028: ifeq +30 -> 1058
    //   1031: aload_2
    //   1032: astore_1
    //   1033: aload_2
    //   1034: invokestatic 270	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1037: ifeq +12 -> 1049
    //   1040: aload 4
    //   1042: ldc_w 894
    //   1045: invokevirtual 694	android/app/Activity:getString	(I)Ljava/lang/String;
    //   1048: astore_1
    //   1049: aload 11
    //   1051: aload_1
    //   1052: aload 12
    //   1054: invokevirtual 897	com/tencent/mobileqq/utils/QQCustomDialog:setPositiveButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   1057: pop
    //   1058: aload 5
    //   1060: invokestatic 270	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1063: ifne +18 -> 1081
    //   1066: aload 11
    //   1068: new 899	dxb
    //   1071: dup
    //   1072: aload_0
    //   1073: aload 5
    //   1075: invokespecial 900	dxb:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/String;)V
    //   1078: invokevirtual 901	com/tencent/mobileqq/utils/QQCustomDialog:setOnCancelListener	(Landroid/content/DialogInterface$OnCancelListener;)V
    //   1081: aload 11
    //   1083: invokevirtual 902	com/tencent/mobileqq/utils/QQCustomDialog:show	()V
    //   1086: goto +1514 -> 2600
    //   1089: astore_1
    //   1090: goto +1510 -> 2600
    //   1093: astore_1
    //   1094: aload_1
    //   1095: invokevirtual 848	org/json/JSONException:printStackTrace	()V
    //   1098: goto +1502 -> 2600
    //   1101: ldc_w 904
    //   1104: aload 4
    //   1106: invokevirtual 289	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1109: ifeq +435 -> 1544
    //   1112: aload 5
    //   1114: arraylength
    //   1115: iconst_1
    //   1116: if_icmpne +428 -> 1544
    //   1119: aload_0
    //   1120: ldc_w 561
    //   1123: putfield 906	com/tencent/mobileqq/jsp/UiApiPlugin:q	Ljava/lang/String;
    //   1126: ldc_w 561
    //   1129: astore_2
    //   1130: new 130	org/json/JSONObject
    //   1133: dup
    //   1134: aload 5
    //   1136: iconst_0
    //   1137: aaload
    //   1138: invokespecial 303	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1141: astore_1
    //   1142: aload_1
    //   1143: ifnull +382 -> 1525
    //   1146: aload_0
    //   1147: getfield 296	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   1150: invokevirtual 301	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1153: astore 5
    //   1155: aload_1
    //   1156: ldc_w 908
    //   1159: ldc_w 910
    //   1162: invokevirtual 913	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1165: astore 12
    //   1167: aload_1
    //   1168: ldc 26
    //   1170: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1173: astore 11
    //   1175: aload_1
    //   1176: ldc_w 491
    //   1179: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1182: astore 13
    //   1184: aload_1
    //   1185: ldc_w 915
    //   1188: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1191: astore 4
    //   1193: aload_1
    //   1194: ldc 31
    //   1196: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1199: astore_3
    //   1200: aload_1
    //   1201: ldc_w 539
    //   1204: iconst_m1
    //   1205: invokevirtual 918	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1208: istore 6
    //   1210: new 130	org/json/JSONObject
    //   1213: dup
    //   1214: aload 13
    //   1216: invokespecial 303	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1219: astore_1
    //   1220: aload_0
    //   1221: getfield 296	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   1224: invokevirtual 487	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   1227: astore 13
    //   1229: aload 13
    //   1231: ifnull +16 -> 1247
    //   1234: aload_1
    //   1235: ldc_w 920
    //   1238: aload 13
    //   1240: invokevirtual 921	com/tencent/smtt/sdk/WebView:getUrl	()Ljava/lang/String;
    //   1243: invokevirtual 925	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1246: pop
    //   1247: ldc_w 927
    //   1250: aload 12
    //   1252: invokevirtual 289	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1255: ifeq +105 -> 1360
    //   1258: new 523	android/os/Bundle
    //   1261: dup
    //   1262: invokespecial 524	android/os/Bundle:<init>	()V
    //   1265: astore_3
    //   1266: aload_3
    //   1267: ldc_w 491
    //   1270: aload_1
    //   1271: invokevirtual 928	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1274: invokevirtual 565	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1277: aload_3
    //   1278: ldc_w 915
    //   1281: aload 4
    //   1283: invokevirtual 565	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1286: goto +1314 -> 2600
    //   1289: astore_1
    //   1290: invokestatic 354	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1293: ifeq +24 -> 1317
    //   1296: getstatic 83	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1299: iconst_2
    //   1300: ldc_w 930
    //   1303: invokestatic 372	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1306: getstatic 83	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1309: iconst_2
    //   1310: aload_1
    //   1311: invokestatic 934	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1314: invokestatic 372	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1317: aload_2
    //   1318: invokestatic 270	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1321: ifne +1279 -> 2600
    //   1324: aload_0
    //   1325: aload_2
    //   1326: iconst_1
    //   1327: anewarray 285	java/lang/String
    //   1330: dup
    //   1331: iconst_0
    //   1332: ldc_w 936
    //   1335: aastore
    //   1336: invokevirtual 655	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1339: goto +1261 -> 2600
    //   1342: astore_1
    //   1343: aconst_null
    //   1344: astore_1
    //   1345: goto -203 -> 1142
    //   1348: astore_1
    //   1349: new 130	org/json/JSONObject
    //   1352: dup
    //   1353: invokespecial 937	org/json/JSONObject:<init>	()V
    //   1356: astore_1
    //   1357: goto -137 -> 1220
    //   1360: ldc_w 910
    //   1363: aload 12
    //   1365: invokevirtual 289	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1368: ifeq +1232 -> 2600
    //   1371: new 153	android/content/Intent
    //   1374: dup
    //   1375: invokespecial 154	android/content/Intent:<init>	()V
    //   1378: astore 12
    //   1380: aload 12
    //   1382: new 939	android/content/ComponentName
    //   1385: dup
    //   1386: aload 5
    //   1388: aload 11
    //   1390: invokespecial 942	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   1393: invokevirtual 946	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   1396: pop
    //   1397: aload 12
    //   1399: ldc_w 491
    //   1402: aload_1
    //   1403: invokevirtual 928	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1406: invokevirtual 215	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1409: pop
    //   1410: aload_0
    //   1411: aload 4
    //   1413: putfield 906	com/tencent/mobileqq/jsp/UiApiPlugin:q	Ljava/lang/String;
    //   1416: aload 4
    //   1418: invokestatic 270	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1421: ifeq +58 -> 1479
    //   1424: aload 5
    //   1426: aload 12
    //   1428: invokevirtual 838	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   1431: goto +1183 -> 2614
    //   1434: ldc_w 948
    //   1437: invokevirtual 951	java/lang/Class:getName	()Ljava/lang/String;
    //   1440: aload 11
    //   1442: invokevirtual 289	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1445: ifeq +1155 -> 2600
    //   1448: aload_0
    //   1449: getfield 102	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   1452: ifnonnull +17 -> 1469
    //   1455: aload_0
    //   1456: invokestatic 956	com/tencent/biz/troop/TroopMemberApiClient:a	()Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   1459: putfield 102	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   1462: aload_0
    //   1463: getfield 102	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   1466: invokevirtual 957	com/tencent/biz/troop/TroopMemberApiClient:a	()V
    //   1469: aload_0
    //   1470: getfield 102	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   1473: invokevirtual 959	com/tencent/biz/troop/TroopMemberApiClient:c	()V
    //   1476: goto +1124 -> 2600
    //   1479: aload_0
    //   1480: aload 12
    //   1482: iconst_4
    //   1483: invokevirtual 843	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   1486: aload_3
    //   1487: invokestatic 270	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1490: ifne +1124 -> 2614
    //   1493: aload_0
    //   1494: aload_3
    //   1495: iconst_1
    //   1496: anewarray 285	java/lang/String
    //   1499: dup
    //   1500: iconst_0
    //   1501: ldc_w 647
    //   1504: aastore
    //   1505: invokevirtual 655	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1508: goto +1106 -> 2614
    //   1511: aload 5
    //   1513: ldc_w 960
    //   1516: ldc_w 961
    //   1519: invokevirtual 542	android/app/Activity:overridePendingTransition	(II)V
    //   1522: goto -88 -> 1434
    //   1525: invokestatic 354	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1528: ifeq +1072 -> 2600
    //   1531: getstatic 83	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1534: iconst_2
    //   1535: ldc_w 963
    //   1538: invokestatic 372	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1541: goto +1059 -> 2600
    //   1544: ldc_w 965
    //   1547: aload 4
    //   1549: invokevirtual 289	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1552: ifeq +295 -> 1847
    //   1555: aload 5
    //   1557: arraylength
    //   1558: iconst_1
    //   1559: if_icmpne +288 -> 1847
    //   1562: new 130	org/json/JSONObject
    //   1565: dup
    //   1566: aload 5
    //   1568: iconst_0
    //   1569: aaload
    //   1570: invokespecial 303	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1573: astore_1
    //   1574: aload_0
    //   1575: getfield 296	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   1578: invokevirtual 301	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1581: astore_2
    //   1582: aload_1
    //   1583: ldc_w 967
    //   1586: invokevirtual 513	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1589: ifeq +70 -> 1659
    //   1592: aload_1
    //   1593: ldc_w 967
    //   1596: invokevirtual 134	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1599: istore 6
    //   1601: aload_2
    //   1602: ldc_w 690
    //   1605: invokevirtual 473	android/app/Activity:findViewById	(I)Landroid/view/View;
    //   1608: checkcast 400	android/widget/TextView
    //   1611: astore_3
    //   1612: aload_2
    //   1613: ldc_w 968
    //   1616: invokevirtual 473	android/app/Activity:findViewById	(I)Landroid/view/View;
    //   1619: checkcast 970	android/widget/ImageView
    //   1622: astore 4
    //   1624: aload_3
    //   1625: ifnull +34 -> 1659
    //   1628: aload 4
    //   1630: ifnull +29 -> 1659
    //   1633: iload 6
    //   1635: iconst_1
    //   1636: if_icmpne +161 -> 1797
    //   1639: aload 4
    //   1641: invokevirtual 974	android/widget/ImageView:getDrawable	()Landroid/graphics/drawable/Drawable;
    //   1644: ifnull +138 -> 1782
    //   1647: aload 4
    //   1649: iconst_0
    //   1650: invokevirtual 975	android/widget/ImageView:setVisibility	(I)V
    //   1653: aload_3
    //   1654: bipush 8
    //   1656: invokevirtual 976	android/widget/TextView:setVisibility	(I)V
    //   1659: aload_1
    //   1660: ldc_w 978
    //   1663: invokevirtual 513	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1666: ifeq +37 -> 1703
    //   1669: aload_1
    //   1670: ldc_w 978
    //   1673: invokestatic 980	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   1676: istore 6
    //   1678: aload_2
    //   1679: ldc_w 469
    //   1682: invokevirtual 473	android/app/Activity:findViewById	(I)Landroid/view/View;
    //   1685: astore_3
    //   1686: aload_3
    //   1687: ifnull +16 -> 1703
    //   1690: iload 6
    //   1692: iconst_m1
    //   1693: if_icmpne +120 -> 1813
    //   1696: aload_3
    //   1697: ldc_w 981
    //   1700: invokevirtual 982	android/view/View:setBackgroundResource	(I)V
    //   1703: aload_1
    //   1704: ldc_w 984
    //   1707: invokevirtual 513	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1710: ifeq +890 -> 2600
    //   1713: aload_1
    //   1714: ldc_w 984
    //   1717: invokestatic 980	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   1720: istore 6
    //   1722: aload_2
    //   1723: instanceof 390
    //   1726: ifeq +874 -> 2600
    //   1729: iload 6
    //   1731: iconst_m1
    //   1732: if_icmpne +99 -> 1831
    //   1735: aload_2
    //   1736: checkcast 390	com/tencent/mobileqq/activity/QQBrowserActivity
    //   1739: invokevirtual 987	com/tencent/mobileqq/activity/QQBrowserActivity:s	()V
    //   1742: goto +858 -> 2600
    //   1745: astore_1
    //   1746: invokestatic 990	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1749: ifeq +851 -> 2600
    //   1752: getstatic 83	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1755: iconst_4
    //   1756: new 356	java/lang/StringBuilder
    //   1759: dup
    //   1760: invokespecial 357	java/lang/StringBuilder:<init>	()V
    //   1763: ldc_w 992
    //   1766: invokevirtual 363	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1769: aload_1
    //   1770: invokevirtual 995	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1773: invokevirtual 369	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1776: invokestatic 372	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1779: goto +821 -> 2600
    //   1782: aload 4
    //   1784: bipush 8
    //   1786: invokevirtual 975	android/widget/ImageView:setVisibility	(I)V
    //   1789: aload_3
    //   1790: iconst_0
    //   1791: invokevirtual 976	android/widget/TextView:setVisibility	(I)V
    //   1794: goto -135 -> 1659
    //   1797: aload_3
    //   1798: bipush 8
    //   1800: invokevirtual 976	android/widget/TextView:setVisibility	(I)V
    //   1803: aload 4
    //   1805: bipush 8
    //   1807: invokevirtual 975	android/widget/ImageView:setVisibility	(I)V
    //   1810: goto -151 -> 1659
    //   1813: aload_3
    //   1814: iconst_0
    //   1815: invokevirtual 982	android/view/View:setBackgroundResource	(I)V
    //   1818: aload_3
    //   1819: iload 6
    //   1821: ldc_w 996
    //   1824: ior
    //   1825: invokevirtual 999	android/view/View:setBackgroundColor	(I)V
    //   1828: goto -125 -> 1703
    //   1831: aload_2
    //   1832: checkcast 390	com/tencent/mobileqq/activity/QQBrowserActivity
    //   1835: iload 6
    //   1837: ldc_w 996
    //   1840: ior
    //   1841: invokevirtual 1001	com/tencent/mobileqq/activity/QQBrowserActivity:b	(I)V
    //   1844: goto +756 -> 2600
    //   1847: ldc_w 1003
    //   1850: aload 4
    //   1852: invokevirtual 289	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1855: ifeq +98 -> 1953
    //   1858: aload 5
    //   1860: arraylength
    //   1861: iconst_1
    //   1862: if_icmpgt +91 -> 1953
    //   1865: aload 5
    //   1867: arraylength
    //   1868: iconst_1
    //   1869: if_icmpne +22 -> 1891
    //   1872: new 130	org/json/JSONObject
    //   1875: dup
    //   1876: aload 5
    //   1878: iconst_0
    //   1879: aaload
    //   1880: invokespecial 303	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1883: ldc_w 1005
    //   1886: iconst_0
    //   1887: invokevirtual 918	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1890: pop
    //   1891: aload_0
    //   1892: getfield 296	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   1895: invokevirtual 301	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1898: astore_1
    //   1899: aload_1
    //   1900: instanceof 390
    //   1903: ifeq +697 -> 2600
    //   1906: aload_1
    //   1907: checkcast 390	com/tencent/mobileqq/activity/QQBrowserActivity
    //   1910: invokevirtual 1007	com/tencent/mobileqq/activity/QQBrowserActivity:l	()V
    //   1913: goto +687 -> 2600
    //   1916: astore_1
    //   1917: invokestatic 990	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1920: ifeq +680 -> 2600
    //   1923: getstatic 83	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1926: iconst_4
    //   1927: new 356	java/lang/StringBuilder
    //   1930: dup
    //   1931: invokespecial 357	java/lang/StringBuilder:<init>	()V
    //   1934: ldc_w 1009
    //   1937: invokevirtual 363	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1940: aload_1
    //   1941: invokevirtual 995	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1944: invokevirtual 369	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1947: invokestatic 372	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1950: goto +650 -> 2600
    //   1953: ldc_w 1011
    //   1956: aload 4
    //   1958: invokevirtual 289	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1961: ifeq +122 -> 2083
    //   1964: aload 5
    //   1966: arraylength
    //   1967: iconst_1
    //   1968: if_icmpne +115 -> 2083
    //   1971: new 130	org/json/JSONObject
    //   1974: dup
    //   1975: aload 5
    //   1977: iconst_0
    //   1978: aaload
    //   1979: invokespecial 303	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1982: astore_1
    //   1983: aload_1
    //   1984: ldc 37
    //   1986: iconst_0
    //   1987: invokevirtual 918	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1990: istore 6
    //   1992: aload_1
    //   1993: ldc 40
    //   1995: iconst_0
    //   1996: invokevirtual 862	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   1999: istore 7
    //   2001: invokestatic 225	com/tencent/common/app/BaseApplicationImpl:getContext	()Landroid/content/Context;
    //   2004: new 153	android/content/Intent
    //   2007: dup
    //   2008: ldc 43
    //   2010: invokespecial 1012	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   2013: ldc 37
    //   2015: iload 6
    //   2017: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2020: ldc 40
    //   2022: iload 7
    //   2024: invokevirtual 834	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   2027: ldc_w 1014
    //   2030: aload_0
    //   2031: getfield 108	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_d_of_type_Int	I
    //   2034: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2037: ldc_w 1016
    //   2040: invokevirtual 1020	android/content/Context:sendBroadcast	(Landroid/content/Intent;Ljava/lang/String;)V
    //   2043: goto +557 -> 2600
    //   2046: astore_1
    //   2047: invokestatic 990	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2050: ifeq +550 -> 2600
    //   2053: getstatic 83	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2056: iconst_4
    //   2057: new 356	java/lang/StringBuilder
    //   2060: dup
    //   2061: invokespecial 357	java/lang/StringBuilder:<init>	()V
    //   2064: ldc_w 1022
    //   2067: invokevirtual 363	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2070: aload_1
    //   2071: invokevirtual 995	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2074: invokevirtual 369	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2077: invokestatic 372	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2080: goto +520 -> 2600
    //   2083: ldc_w 1024
    //   2086: aload 4
    //   2088: invokevirtual 289	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2091: ifeq +237 -> 2328
    //   2094: aload 5
    //   2096: arraylength
    //   2097: iconst_1
    //   2098: if_icmpne +230 -> 2328
    //   2101: aload_0
    //   2102: aconst_null
    //   2103: putfield 1026	com/tencent/mobileqq/jsp/UiApiPlugin:r	Ljava/lang/String;
    //   2106: new 130	org/json/JSONObject
    //   2109: dup
    //   2110: aload 5
    //   2112: iconst_0
    //   2113: aaload
    //   2114: invokespecial 303	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2117: astore_3
    //   2118: aload_3
    //   2119: ldc_w 1027
    //   2122: invokevirtual 1031	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   2125: lstore 9
    //   2127: aload_3
    //   2128: ldc_w 1033
    //   2131: bipush 13
    //   2133: invokevirtual 918	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2136: istore 6
    //   2138: aload_3
    //   2139: ldc 31
    //   2141: invokevirtual 138	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2144: astore_1
    //   2145: aload_0
    //   2146: getfield 296	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   2149: invokevirtual 1036	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   2152: astore_2
    //   2153: aload_2
    //   2154: ifnull +10 -> 2164
    //   2157: aload_2
    //   2158: invokevirtual 1039	com/tencent/common/app/AppInterface:isLogin	()Z
    //   2161: ifne +20 -> 2181
    //   2164: aload_0
    //   2165: aload_1
    //   2166: iconst_1
    //   2167: anewarray 285	java/lang/String
    //   2170: dup
    //   2171: iconst_0
    //   2172: ldc_w 1041
    //   2175: aastore
    //   2176: invokevirtual 655	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2179: iconst_1
    //   2180: ireturn
    //   2181: aload_3
    //   2182: ldc 49
    //   2184: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2187: astore_3
    //   2188: aload_3
    //   2189: invokestatic 270	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2192: ifne +31 -> 2223
    //   2195: aload_3
    //   2196: aload_2
    //   2197: invokevirtual 1044	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   2200: invokevirtual 289	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2203: ifne +20 -> 2223
    //   2206: aload_0
    //   2207: aload_1
    //   2208: iconst_1
    //   2209: anewarray 285	java/lang/String
    //   2212: dup
    //   2213: iconst_0
    //   2214: ldc_w 1046
    //   2217: aastore
    //   2218: invokevirtual 655	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2221: iconst_1
    //   2222: ireturn
    //   2223: aload_0
    //   2224: getfield 296	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   2227: invokevirtual 301	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2230: astore_2
    //   2231: aload_2
    //   2232: ifnull +368 -> 2600
    //   2235: aload_0
    //   2236: aload_1
    //   2237: putfield 1026	com/tencent/mobileqq/jsp/UiApiPlugin:r	Ljava/lang/String;
    //   2240: new 153	android/content/Intent
    //   2243: dup
    //   2244: aload_2
    //   2245: ldc_w 1048
    //   2248: invokespecial 525	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   2251: astore_1
    //   2252: aload_1
    //   2253: ldc_w 1050
    //   2256: bipush 16
    //   2258: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2261: pop
    //   2262: aload_1
    //   2263: ldc_w 1033
    //   2266: iload 6
    //   2268: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2271: pop
    //   2272: aload_1
    //   2273: ldc_w 1027
    //   2276: lload 9
    //   2278: invokevirtual 1053	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   2281: pop
    //   2282: aload_0
    //   2283: aload_1
    //   2284: iconst_5
    //   2285: invokevirtual 843	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   2288: goto +312 -> 2600
    //   2291: astore_1
    //   2292: invokestatic 990	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2295: ifeq +305 -> 2600
    //   2298: getstatic 83	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2301: iconst_4
    //   2302: new 356	java/lang/StringBuilder
    //   2305: dup
    //   2306: invokespecial 357	java/lang/StringBuilder:<init>	()V
    //   2309: ldc_w 1055
    //   2312: invokevirtual 363	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2315: aload_1
    //   2316: invokevirtual 995	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2319: invokevirtual 369	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2322: invokestatic 372	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2325: goto +275 -> 2600
    //   2328: ldc_w 1057
    //   2331: aload 4
    //   2333: invokevirtual 289	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2336: ifeq +264 -> 2600
    //   2339: aload 5
    //   2341: arraylength
    //   2342: iconst_1
    //   2343: if_icmpne +257 -> 2600
    //   2346: new 130	org/json/JSONObject
    //   2349: dup
    //   2350: aload 5
    //   2352: iconst_0
    //   2353: aaload
    //   2354: invokespecial 303	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2357: astore_1
    //   2358: aload_1
    //   2359: ldc_w 1059
    //   2362: invokevirtual 513	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2365: ifeq +109 -> 2474
    //   2368: aload_1
    //   2369: ldc_w 1059
    //   2372: invokevirtual 1062	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   2375: istore 7
    //   2377: iload 7
    //   2379: aload_0
    //   2380: getfield 119	com/tencent/mobileqq/jsp/UiApiPlugin:c	Z
    //   2383: if_icmpeq +217 -> 2600
    //   2386: iload 7
    //   2388: ifeq +79 -> 2467
    //   2391: aload_0
    //   2392: invokevirtual 1063	com/tencent/mobileqq/jsp/UiApiPlugin:a	()V
    //   2395: aload_0
    //   2396: iload 7
    //   2398: putfield 119	com/tencent/mobileqq/jsp/UiApiPlugin:c	Z
    //   2401: aload_0
    //   2402: getfield 296	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   2405: invokevirtual 301	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2408: instanceof 390
    //   2411: ifeq +189 -> 2600
    //   2414: aload_0
    //   2415: getfield 296	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   2418: invokevirtual 301	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2421: checkcast 390	com/tencent/mobileqq/activity/QQBrowserActivity
    //   2424: invokevirtual 1065	com/tencent/mobileqq/activity/QQBrowserActivity:g	()V
    //   2427: goto +173 -> 2600
    //   2430: astore_1
    //   2431: invokestatic 990	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2434: ifeq +166 -> 2600
    //   2437: getstatic 83	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2440: iconst_4
    //   2441: new 356	java/lang/StringBuilder
    //   2444: dup
    //   2445: invokespecial 357	java/lang/StringBuilder:<init>	()V
    //   2448: ldc_w 1067
    //   2451: invokevirtual 363	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2454: aload_1
    //   2455: invokevirtual 995	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2458: invokevirtual 369	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2461: invokestatic 372	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2464: goto +136 -> 2600
    //   2467: aload_0
    //   2468: invokevirtual 1069	com/tencent/mobileqq/jsp/UiApiPlugin:b	()V
    //   2471: goto -76 -> 2395
    //   2474: aload_1
    //   2475: ldc_w 1071
    //   2478: invokevirtual 513	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2481: ifeq +119 -> 2600
    //   2484: aload_0
    //   2485: getfield 641	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_d_of_type_Boolean	Z
    //   2488: ifeq +112 -> 2600
    //   2491: aload_0
    //   2492: iconst_0
    //   2493: putfield 641	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_d_of_type_Boolean	Z
    //   2496: aload_1
    //   2497: ldc_w 1071
    //   2500: invokevirtual 1062	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   2503: istore 7
    //   2505: invokestatic 225	com/tencent/common/app/BaseApplicationImpl:getContext	()Landroid/content/Context;
    //   2508: invokevirtual 439	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   2511: astore_2
    //   2512: iload 7
    //   2514: ifeq +47 -> 2561
    //   2517: aload_0
    //   2518: getfield 624	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader	Lcom/tencent/mobileqq/widget/PullRefreshHeader;
    //   2521: iconst_0
    //   2522: aload_1
    //   2523: ldc_w 733
    //   2526: aload_2
    //   2527: ldc_w 1072
    //   2530: invokevirtual 1073	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   2533: invokevirtual 913	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2536: invokevirtual 1076	com/tencent/mobileqq/widget/PullRefreshHeader:a	(ILjava/lang/String;)V
    //   2539: aload_0
    //   2540: getfield 146	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   2543: new 1078	dxc
    //   2546: dup
    //   2547: aload_0
    //   2548: invokespecial 1079	dxc:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;)V
    //   2551: ldc2_w 1080
    //   2554: invokevirtual 1085	com/tencent/widget/XListView:postDelayed	(Ljava/lang/Runnable;J)Z
    //   2557: pop
    //   2558: goto +42 -> 2600
    //   2561: aload_0
    //   2562: getfield 624	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader	Lcom/tencent/mobileqq/widget/PullRefreshHeader;
    //   2565: iconst_1
    //   2566: aload_1
    //   2567: ldc_w 733
    //   2570: aload_2
    //   2571: ldc_w 1086
    //   2574: invokevirtual 1073	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   2577: invokevirtual 913	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2580: invokevirtual 1076	com/tencent/mobileqq/widget/PullRefreshHeader:a	(ILjava/lang/String;)V
    //   2583: aload_0
    //   2584: getfield 146	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   2587: invokevirtual 1088	com/tencent/widget/XListView:B	()V
    //   2590: goto +10 -> 2600
    //   2593: iconst_0
    //   2594: ireturn
    //   2595: astore 13
    //   2597: goto -1350 -> 1247
    //   2600: iconst_1
    //   2601: ireturn
    //   2602: astore_1
    //   2603: goto -3 -> 2600
    //   2606: iconst_1
    //   2607: ireturn
    //   2608: astore_1
    //   2609: goto -9 -> 2600
    //   2612: iconst_1
    //   2613: ireturn
    //   2614: iload 6
    //   2616: tableswitch	default:+20 -> 2636, 1001:+-1105->1511
    //   2637: <illegal opcode>
    //   2638: astore_3
    //   2639: astore_1
    //   2640: aload_3
    //   2641: astore_2
    //   2642: goto -1352 -> 1290
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2645	0	this	UiApiPlugin
    //   0	2645	1	paramJsBridgeListener	com.tencent.mobileqq.webviewplugin.JsBridgeListener
    //   0	2645	2	paramString1	String
    //   0	2645	3	paramString2	String
    //   0	2645	4	paramString3	String
    //   0	2645	5	paramVarArgs	String[]
    //   1208	1407	6	i1	int
    //   919	1594	7	bool1	boolean
    //   930	65	8	bool2	boolean
    //   2125	152	9	l1	long
    //   965	476	11	localObject1	Object
    //   908	573	12	localObject2	Object
    //   1182	57	13	localObject3	Object
    //   2595	1	13	localJSONException	JSONException
    // Exception table:
    //   from	to	target	type
    //   159	199	202	org/json/JSONException
    //   234	241	249	java/lang/Exception
    //   234	241	258	finally
    //   338	353	356	org/json/JSONException
    //   395	403	509	org/json/JSONException
    //   407	414	509	org/json/JSONException
    //   417	437	509	org/json/JSONException
    //   441	469	509	org/json/JSONException
    //   473	479	509	org/json/JSONException
    //   479	489	509	org/json/JSONException
    //   489	497	509	org/json/JSONException
    //   501	506	509	org/json/JSONException
    //   732	752	755	org/json/JSONException
    //   781	824	827	org/json/JSONException
    //   1081	1086	1089	java/lang/Exception
    //   853	875	1093	org/json/JSONException
    //   880	888	1093	org/json/JSONException
    //   891	994	1093	org/json/JSONException
    //   1001	1017	1093	org/json/JSONException
    //   1017	1026	1093	org/json/JSONException
    //   1033	1049	1093	org/json/JSONException
    //   1049	1058	1093	org/json/JSONException
    //   1058	1081	1093	org/json/JSONException
    //   1081	1086	1093	org/json/JSONException
    //   1146	1210	1289	java/lang/Exception
    //   1210	1220	1289	java/lang/Exception
    //   1220	1229	1289	java/lang/Exception
    //   1234	1247	1289	java/lang/Exception
    //   1247	1286	1289	java/lang/Exception
    //   1349	1357	1289	java/lang/Exception
    //   1360	1416	1289	java/lang/Exception
    //   1130	1142	1342	org/json/JSONException
    //   1210	1220	1348	org/json/JSONException
    //   1562	1624	1745	org/json/JSONException
    //   1639	1659	1745	org/json/JSONException
    //   1659	1686	1745	org/json/JSONException
    //   1696	1703	1745	org/json/JSONException
    //   1703	1729	1745	org/json/JSONException
    //   1735	1742	1745	org/json/JSONException
    //   1782	1794	1745	org/json/JSONException
    //   1797	1810	1745	org/json/JSONException
    //   1813	1828	1745	org/json/JSONException
    //   1831	1844	1745	org/json/JSONException
    //   1865	1891	1916	org/json/JSONException
    //   1891	1913	1916	org/json/JSONException
    //   1971	2043	2046	org/json/JSONException
    //   2101	2153	2291	org/json/JSONException
    //   2157	2164	2291	org/json/JSONException
    //   2164	2179	2291	org/json/JSONException
    //   2181	2221	2291	org/json/JSONException
    //   2223	2231	2291	org/json/JSONException
    //   2235	2288	2291	org/json/JSONException
    //   2346	2386	2430	org/json/JSONException
    //   2391	2395	2430	org/json/JSONException
    //   2395	2427	2430	org/json/JSONException
    //   2467	2471	2430	org/json/JSONException
    //   2474	2512	2430	org/json/JSONException
    //   2517	2558	2430	org/json/JSONException
    //   2561	2590	2430	org/json/JSONException
    //   1220	1229	2595	org/json/JSONException
    //   1234	1247	2595	org/json/JSONException
    //   27	84	2602	org/json/JSONException
    //   84	111	2602	org/json/JSONException
    //   114	145	2602	org/json/JSONException
    //   577	681	2608	org/json/JSONException
    //   684	711	2608	org/json/JSONException
    //   1416	1431	2639	java/lang/Exception
    //   1434	1469	2639	java/lang/Exception
    //   1469	1476	2639	java/lang/Exception
    //   1479	1508	2639	java/lang/Exception
    //   1511	1522	2639	java/lang/Exception
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if (paramByte == 3) {
      if (paramIntent != null) {}
    }
    Object localObject1;
    Object localObject3;
    Object localObject2;
    do
    {
      do
      {
        do
        {
          return;
          localObject1 = paramIntent.getStringExtra("scanResult");
          if (!TextUtils.isEmpty(this.p)) {
            break;
          }
          localObject3 = paramIntent.getStringExtra("callback_url");
          localObject2 = paramIntent.getStringExtra("name");
        } while ((TextUtils.isEmpty((CharSequence)localObject3)) || (TextUtils.isEmpty((CharSequence)localObject2)));
        localObject3 = ((String)localObject3).split("#");
        StringBuilder localStringBuilder = new StringBuilder(localObject3[0]);
        if (localObject3[0].contains("?")) {}
        for (paramIntent = "&";; paramIntent = "?")
        {
          paramIntent = localStringBuilder.append(paramIntent).append((String)localObject2).append("=").append(URLEncoder.encode((String)localObject1));
          if (localObject3.length > 1) {
            paramIntent.append("#").append(localObject3[1]);
          }
          this.mRuntime.a().loadUrl(paramIntent.toString());
          return;
        }
        localObject2 = this.p;
        if (localObject1 == null) {}
        for (paramIntent = "''";; paramIntent = Util.b((String)localObject1))
        {
          callJs((String)localObject2, new String[] { paramIntent });
          return;
        }
        if (paramByte != 4) {
          break;
        }
      } while (TextUtils.isEmpty(this.q));
      if (paramInt == -1)
      {
        if (paramIntent == null) {}
        for (paramIntent = "";; paramIntent = paramIntent.getStringExtra("result"))
        {
          paramIntent = "{\"code\":0,\"data\":{\"retcode\":0,\"result\":" + paramIntent + "}}";
          callJs(this.q, new String[] { paramIntent });
          return;
        }
      }
      callJs(this.q, new String[] { "{\"code\":-1}" });
      return;
    } while ((paramByte != 5) || (TextUtils.isEmpty(this.r)));
    if (paramInt == -1)
    {
      paramInt = paramIntent.getIntExtra("ret", 4);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "select contact ret:" + paramInt);
      }
      localObject1 = new JSONObject();
      for (;;)
      {
        try
        {
          ((JSONObject)localObject1).put("ret", paramInt);
          if (paramInt == 0)
          {
            localObject2 = paramIntent.getStringArrayExtra("openids");
            paramIntent = paramIntent.getIntArrayExtra("types");
            int i1 = localObject2.length;
            localObject3 = new JSONArray();
            paramInt = 0;
            if (paramInt < i1)
            {
              ((JSONArray)localObject3).put(new JSONObject().put("type", paramIntent[paramInt]).put("openID", localObject2[paramInt]));
              paramInt += 1;
              continue;
            }
            ((JSONObject)localObject1).put("contacts", localObject3);
            callJs(this.r, new String[] { ((JSONObject)localObject1).toString() });
            return;
          }
        }
        catch (JSONException paramIntent)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "select contact result json exception", paramIntent);
          }
          callJs(this.r, new String[] { "{\"ret\":4}" });
          return;
        }
        ((JSONObject)localObject1).put("errMsg", paramIntent.getStringExtra("errMsg"));
      }
    }
    callJs(this.r, new String[] { "{\"ret\":3}" });
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (!TextUtils.isEmpty(this.o)) {
      callJs(this.o, new String[] { "1", Integer.toString(this.jdField_e_of_type_Int) });
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidViewView)
    {
      paramView = this.mRuntime.a();
      if (paramView != null) {
        paramView.finish();
      }
    }
  }
  
  protected void onCreate()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_CLOSE");
    this.mRuntime.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter, "com.tencent.msg.permission.pushnotify", null);
  }
  
  protected void onDestroy()
  {
    this.mRuntime.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient != null) {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
    }
    if (this.b)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader((View)null);
      this.jdField_a_of_type_Dxe = null;
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin
 * JD-Core Version:    0.7.0.1
 */