package com.tencent.biz.pubaccount;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebSettings.TextSize;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.List;

public class PublicAccountBrowser
  extends QQBrowserActivity
  implements View.OnClickListener
{
  public static final long a = 100298324L;
  private static final String a = "PublicAccountBrowser";
  protected static final WebSettings.TextSize[] a;
  protected static int b = 0;
  protected static int c = 0;
  public static final String c = "2632129500";
  protected static final int d = 9;
  public static final String d = "hideRightButton";
  protected static final int e = 3;
  public static final String e = "url";
  public static final String f = "hide_operation_bar";
  public static final String g = "puin";
  public static final String h = "assignBackText";
  public static final String i = "uin";
  public static final String j = "uin_name";
  public static final String k = "uin_type";
  public static final String l = "openid";
  public static final String m = "token";
  public static final String n = "http://s.p.qq.com/pub/msg";
  public static final String o = "http://s.p.qq.com/pub/show";
  public static final String p = "http://s.p.qq.com/pub/history";
  public static final String q = "http://s.p.qq.com/pub/jump";
  public static final String r = "http://browserApp.p.qq.com/";
  public static final String u = "mqqapi://app/action?pkg=com.tencent.qqlite&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=%s";
  public static final String v = "mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=%s&version=1";
  public static final String w = "http://url.cn/JS8oE7";
  public static final String x = "source_name";
  protected Bundle a;
  protected PopupWindow a;
  protected ArrayList a;
  protected boolean b;
  protected boolean c;
  protected boolean d = false;
  protected boolean e = false;
  protected int f;
  protected boolean f;
  protected String s = null;
  protected String t = null;
  
  static
  {
    jdField_b_of_type_Int = 1;
    jdField_c_of_type_Int = 1;
    jdField_a_of_type_ArrayOfComTencentSmttSdkWebSettings$TextSize = new WebSettings.TextSize[] { WebSettings.TextSize.SMALLER, WebSettings.TextSize.NORMAL, WebSettings.TextSize.LARGER, WebSettings.TextSize.LARGEST };
  }
  
  public PublicAccountBrowser()
  {
    this.jdField_a_of_type_AndroidWidgetPopupWindow = null;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_f_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
  }
  
  private void a(Bundle paramBundle)
  {
    c(jdField_b_of_type_Int);
    if (!NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.getApplication())) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.getApplication(), 2131362912, 0).b(super.getTitleBarHeight());
    }
    if (!this.r)
    {
      paramBundle = this.jdField_a_of_type_AndroidOsBundle.getString("assignBackText");
      if (!TextUtils.isEmpty(paramBundle)) {
        this.h.setText(paramBundle);
      }
      if (!this.jdField_f_of_type_Boolean)
      {
        this.j.setText("");
        this.p.setImageResource(2130837745);
        this.p.setContentDescription(super.getText(2131363497));
      }
    }
    else
    {
      return;
    }
    this.j.setVisibility(8);
    this.p.setVisibility(8);
    int i1 = (int)DisplayUtils.a(this, 8.0F);
    ((RelativeLayout.LayoutParams)this.i.getLayoutParams()).setMargins(i1, 0, i1, 0);
  }
  
  private void a(String paramString) {}
  
  private void c(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView == null) || (this.k)) {
      return;
    }
    jdField_c_of_type_Int = paramInt;
    WebSettings.TextSize localTextSize = jdField_a_of_type_ArrayOfComTencentSmttSdkWebSettings$TextSize[paramInt];
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getSettings().setTextSize(localTextSize);
  }
  
  private void u()
  {
    boolean bool2 = false;
    Intent localIntent = super.getIntent();
    this.jdField_a_of_type_AndroidOsBundle = localIntent.getExtras();
    this.L = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    this.t = this.jdField_a_of_type_AndroidOsBundle.getString("uin_name");
    this.jdField_f_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("uin_type");
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("openid");
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("token");
    Object localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("url");
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("PublicAccountBrowser", 2, "url not found, use \"\" default");
      }
      localObject1 = "";
    }
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountBrowser", 2, "get a url:" + Util.b((String)localObject1, new String[0]));
    }
    localObject2 = localObject1;
    if (((String)localObject1).startsWith("http://browserApp.p.qq.com/"))
    {
      localObject2 = localObject1;
      if (!((String)localObject1).contains("?")) {
        localObject2 = (String)localObject1 + "?";
      }
      localObject2 = (String)localObject2 + "&openid=" + str1 + "&token=" + str2;
      localIntent.putExtra("url", (String)localObject2);
    }
    if (localObject2 != null)
    {
      localObject1 = Uri.parse((String)localObject2);
      if ((localObject1 != null) && (((Uri)localObject1).isHierarchical()))
      {
        localObject1 = ((Uri)localObject1).getQueryParameter("_wv");
        if (localObject1 == null) {}
      }
    }
    try
    {
      this.v = Integer.parseInt(((String)localObject1).trim());
      this.s = this.jdField_a_of_type_AndroidOsBundle.getString("puin");
      if (!this.jdField_a_of_type_AndroidOsBundle.getBoolean("hide_operation_bar"))
      {
        bool1 = true;
        this.jdField_c_of_type_Boolean = bool1;
        if ((!((String)localObject2).startsWith("http://s.p.qq.com/pub/msg")) && (!((String)localObject2).startsWith("http://s.p.qq.com/pub/show"))) {
          break label537;
        }
        bool1 = true;
        this.jdField_b_of_type_Boolean = bool1;
        if (!this.jdField_a_of_type_AndroidOsBundle.containsKey("hide_operation_bar"))
        {
          if (!this.jdField_b_of_type_Boolean) {
            break label542;
          }
          this.jdField_c_of_type_Boolean = false;
          if (this.jdField_c_of_type_Boolean) {
            break label550;
          }
          bool1 = true;
          localIntent.putExtra("hide_operation_bar", bool1);
        }
        localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("webStyle");
        if ((localObject1 != null) && (((String)localObject1).equals("noBottomBar"))) {
          this.jdField_c_of_type_Boolean = false;
        }
        localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("disableshare");
        if (!this.jdField_a_of_type_AndroidOsBundle.getBoolean("hideRightButton", false))
        {
          bool1 = bool2;
          if (localObject1 != null)
          {
            bool1 = bool2;
            if (!((String)localObject1).equals("true")) {}
          }
        }
        else
        {
          bool1 = true;
        }
        this.jdField_f_of_type_Boolean = bool1;
        if ((!this.jdField_f_of_type_Boolean) && ((this.v & 0x23F8) == 9208)) {
          this.jdField_f_of_type_Boolean = true;
        }
        localIntent.putExtra("url", (String)localObject2);
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        boolean bool1;
        if (QLog.isDevelopLevel())
        {
          QLog.d("QQBrowser", 4, "sorry, i can not get rules from QQBrowser url, maybe have more than one '_wv' in the url");
          continue;
          bool1 = false;
          continue;
          label537:
          bool1 = false;
          continue;
          label542:
          this.jdField_c_of_type_Boolean = true;
          continue;
          label550:
          bool1 = false;
        }
      }
    }
  }
  
  private void v()
  {
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow == null)
    {
      View localView = super.getLayoutInflater().inflate(2130903194, null);
      this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(localView, -1, -2);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(new BitmapDrawable());
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setOutsideTouchable(true);
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(4);
      LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131297107);
      this.jdField_a_of_type_JavaUtilArrayList.add(localLinearLayout);
      localLinearLayout.setOnClickListener(this);
      localLinearLayout = (LinearLayout)localView.findViewById(2131297108);
      this.jdField_a_of_type_JavaUtilArrayList.add(localLinearLayout);
      localLinearLayout.setOnClickListener(this);
      localLinearLayout = (LinearLayout)localView.findViewById(2131297109);
      this.jdField_a_of_type_JavaUtilArrayList.add(localLinearLayout);
      localLinearLayout.setOnClickListener(this);
      localLinearLayout = (LinearLayout)localView.findViewById(2131297110);
      this.jdField_a_of_type_JavaUtilArrayList.add(localLinearLayout);
      localLinearLayout.setOnClickListener(this);
      ((LinearLayout)localView.findViewById(2131297111)).setOnClickListener(this);
    }
    if (!this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing()) {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView, 83, 0, 0);
    }
  }
  
  protected String a()
  {
    return "PA";
  }
  
  protected void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if (paramInt == -8) {
      QRUtils.a(1, 2131362454);
    }
  }
  
  protected boolean a(WebView paramWebView, String paramString)
  {
    if ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")) && (!paramString.startsWith("file://"))) {}
    do
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountBrowser", 2, "shouldOverride: " + Util.b(paramString, new String[0]));
      }
      c(jdField_b_of_type_Int);
      paramWebView = paramWebView.getUrl();
      if ((TextUtils.isEmpty(paramWebView)) || (paramWebView.startsWith("http://s.p.qq.com/pub/jump"))) {}
      for (int i1 = 1; (this.jdField_c_of_type_Boolean) || (!this.jdField_b_of_type_Boolean) || (i1 != 0); i1 = 0)
      {
        this.e = false;
        return false;
      }
    } while (this.d);
    paramWebView = new Intent(this, PublicAccountBrowser.class);
    paramWebView.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.a());
    paramWebView.putExtra("url", paramString);
    super.startActivity(paramWebView);
    return true;
  }
  
  protected List[] a()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.v & 0x8) == 0)
    {
      localObject = new PublicAccountBrowser.ActionSheetItem();
      ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = super.getString(2131362464);
      ((PublicAccountBrowser.ActionSheetItem)localObject).k = 2130837667;
      ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
      ((PublicAccountBrowser.ActionSheetItem)localObject).l = 2;
      ((PublicAccountBrowser.ActionSheetItem)localObject).b = "";
      localArrayList.add(localObject);
    }
    if ((this.v & 0x4000) == 0)
    {
      localObject = new PublicAccountBrowser.ActionSheetItem();
      ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = super.getString(2131362478);
      ((PublicAccountBrowser.ActionSheetItem)localObject).k = 2130837668;
      ((PublicAccountBrowser.ActionSheetItem)localObject).l = 9;
      ((PublicAccountBrowser.ActionSheetItem)localObject).b = "";
      localArrayList.add(localObject);
    }
    if ((this.v & 0x8000) == 0)
    {
      localObject = new PublicAccountBrowser.ActionSheetItem();
      ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = super.getString(2131362479);
      ((PublicAccountBrowser.ActionSheetItem)localObject).k = 2130837666;
      ((PublicAccountBrowser.ActionSheetItem)localObject).l = 10;
      ((PublicAccountBrowser.ActionSheetItem)localObject).b = "";
      localArrayList.add(localObject);
    }
    if ((this.v & 0x200) == 0)
    {
      localObject = new PublicAccountBrowser.ActionSheetItem();
      ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = super.getString(2131362469);
      ((PublicAccountBrowser.ActionSheetItem)localObject).k = 2130838353;
      ((PublicAccountBrowser.ActionSheetItem)localObject).l = 5;
      ((PublicAccountBrowser.ActionSheetItem)localObject).b = "";
      localArrayList.add(localObject);
    }
    if ((this.v & 0x100) == 0)
    {
      localObject = new PublicAccountBrowser.ActionSheetItem();
      ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = super.getString(2131362468);
      ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
      ((PublicAccountBrowser.ActionSheetItem)localObject).k = 2130838351;
      ((PublicAccountBrowser.ActionSheetItem)localObject).l = 4;
      ((PublicAccountBrowser.ActionSheetItem)localObject).b = "";
      localArrayList.add(localObject);
    }
    Object localObject = new ArrayList();
    if ((!TextUtils.isEmpty(this.s)) && ((this.v & 0x40) == 0))
    {
      localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
      localActionSheetItem.jdField_a_of_type_JavaLangString = super.getString(2131362472);
      localActionSheetItem.k = 2130838350;
      localActionSheetItem.jdField_a_of_type_Boolean = true;
      localActionSheetItem.l = 8;
      localActionSheetItem.b = "";
      ((ArrayList)localObject).add(localActionSheetItem);
    }
    if ((this.v & 0x2000) == 0)
    {
      localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
      localActionSheetItem.jdField_a_of_type_JavaLangString = super.getString(2131362477);
      localActionSheetItem.jdField_a_of_type_Boolean = true;
      localActionSheetItem.k = 2130838509;
      localActionSheetItem.l = 6;
      localActionSheetItem.b = "";
      ((ArrayList)localObject).add(localActionSheetItem);
    }
    if ((this.v & 0x80) == 0)
    {
      localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
      localActionSheetItem.jdField_a_of_type_JavaLangString = super.getString(2131362465);
      localActionSheetItem.k = 2130838352;
      localActionSheetItem.jdField_a_of_type_Boolean = true;
      localActionSheetItem.l = 7;
      localActionSheetItem.b = "";
      ((ArrayList)localObject).add(localActionSheetItem);
    }
    if ((this.v & 0x20) == 0)
    {
      localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
      localActionSheetItem.jdField_a_of_type_JavaLangString = super.getString(2131362466);
      localActionSheetItem.k = 2130837665;
      localActionSheetItem.jdField_a_of_type_Boolean = true;
      localActionSheetItem.l = 1;
      localActionSheetItem.b = "";
      ((ArrayList)localObject).add(localActionSheetItem);
    }
    PublicAccountBrowser.ActionSheetItem localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = super.getString(2131362467);
    localActionSheetItem.k = 2130838341;
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.l = 11;
    localActionSheetItem.b = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList, localObject };
  }
  
  public String b_()
  {
    return this.s;
  }
  
  protected void c()
  {
    if ((!TextUtils.isEmpty(this.s)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizAuthorizeConfig.a(this.K)))) {
      this.K = Uri.parse(this.K).buildUpon().appendQueryParameter("puin", this.s).appendQueryParameter("uin", this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.getAccount()).toString();
    }
  }
  
  protected void d()
  {
    a();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    Intent localIntent = getIntent();
    String str = localIntent.getStringExtra("url");
    this.o = false;
    if ((str != null) && (str.contains("iyouxi.vip.qq.com/vipcenter")))
    {
      super.doOnCreate(paramBundle);
      VasWebviewUtil.a(this, str, 16L, localIntent, false, -1);
      finish();
      return false;
    }
    if (this.jdField_c_of_type_Long != 0L) {
      this.jdField_c_of_type_Long = System.currentTimeMillis();
    }
    if (getIntent().getIntExtra("reqType", -1) == 5)
    {
      super.doOnCreate(paramBundle);
      if (!this.r)
      {
        this.h.setOnClickListener(this);
        this.j.setText(2131362863);
        this.j.setOnClickListener(this);
      }
    }
    for (;;)
    {
      return true;
      u();
      super.doOnCreate(paramBundle);
      a(paramBundle);
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow != null)
    {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
      this.jdField_a_of_type_AndroidWidgetPopupWindow = null;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      super.onClick(paramView);
      return;
    case 2131297111: 
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
      return;
    case 2131297107: 
      c(0);
      return;
    case 2131297108: 
      c(1);
      return;
    case 2131297109: 
      c(2);
      return;
    }
    c(3);
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = paramView.getTag();
    if (!(localObject instanceof PublicAccountBrowser.ActionSheetItemViewHolder)) {
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountBrowser", 2, "Item clicked but tag not found");
      }
    }
    int i1;
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      }
      i1 = ((PublicAccountBrowser.ActionSheetItemViewHolder)localObject).a.l;
      if (i1 == 7)
      {
        v();
        return;
      }
      if (i1 == 8)
      {
        a(this.s);
        return;
      }
      super.onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      if (i1 == 2)
      {
        ReportController.b(null, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.a(), "0X8004B5D", "0X8004B5D", 0, 0, "", "", "", "");
        return;
      }
    } while (i1 != 6);
    ReportController.b(null, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.a(), "0X8004B5E", "0X8004B5E", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountBrowser
 * JD-Core Version:    0.7.0.1
 */