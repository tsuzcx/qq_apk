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
import android.widget.TextView;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
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
  public static final String u = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=%s";
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
    paramBundle = this.jdField_a_of_type_AndroidOsBundle.getString("assignBackText");
    if (!TextUtils.isEmpty(paramBundle)) {
      this.k.setText(paramBundle);
    }
    if (!this.jdField_f_of_type_Boolean)
    {
      this.m.setText("");
      this.p.setImageResource(2130837835);
      this.p.setContentDescription(super.getText(2131562406));
    }
    for (;;)
    {
      b(jdField_b_of_type_Int);
      if (!NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.getApplication())) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.getApplication(), 2131562451, 0).b(super.d());
      }
      return;
      this.m.setVisibility(8);
      this.p.setVisibility(8);
      int i1 = (int)DisplayUtils.a(this, 8.0F);
    }
  }
  
  private void a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = this.s;
    }
    if (str != null)
    {
      paramString = new Intent(this, AccountDetailActivity.class);
      paramString.putExtra("uin", str);
      super.startActivity(paramString);
    }
  }
  
  private void b(int paramInt)
  {
    jdField_c_of_type_Int = paramInt;
    WebSettings.TextSize localTextSize = jdField_a_of_type_ArrayOfComTencentSmttSdkWebSettings$TextSize[paramInt];
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getSettings().setTextSize(localTextSize);
  }
  
  private void e()
  {
    boolean bool2 = false;
    this.g = true;
    Intent localIntent = super.getIntent();
    this.jdField_a_of_type_AndroidOsBundle = localIntent.getExtras();
    this.J = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    this.t = this.jdField_a_of_type_AndroidOsBundle.getString("uin_name");
    this.jdField_f_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("uin_type");
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("openid");
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("token");
    Object localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("url");
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      QLog.w("PublicAccountBrowser", 2, "url not found, use \"\" default");
      localObject1 = "";
    }
    QLog.d("PublicAccountBrowser", 2, "get a url:" + (String)localObject1);
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
      this.y = Integer.parseInt(((String)localObject1).trim());
      this.s = this.jdField_a_of_type_AndroidOsBundle.getString("puin");
      if (!this.jdField_a_of_type_AndroidOsBundle.getBoolean("hide_operation_bar"))
      {
        bool1 = true;
        this.jdField_c_of_type_Boolean = bool1;
        if ((!((String)localObject2).startsWith("http://s.p.qq.com/pub/msg")) && (!((String)localObject2).startsWith("http://s.p.qq.com/pub/show"))) {
          break label523;
        }
        bool1 = true;
        this.jdField_b_of_type_Boolean = bool1;
        if (!this.jdField_a_of_type_AndroidOsBundle.containsKey("hide_operation_bar"))
        {
          if (!this.jdField_b_of_type_Boolean) {
            break label528;
          }
          this.jdField_c_of_type_Boolean = false;
          if (this.jdField_c_of_type_Boolean) {
            break label536;
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
        if ((!this.jdField_f_of_type_Boolean) && ((this.y & 0x23F8) == 9208)) {
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
          label523:
          bool1 = false;
          continue;
          label528:
          this.jdField_c_of_type_Boolean = true;
          continue;
          label536:
          bool1 = false;
        }
      }
    }
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow == null)
    {
      View localView = super.getLayoutInflater().inflate(2130903228, null);
      this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(localView, -1, -2);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(new BitmapDrawable());
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setOutsideTouchable(true);
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(4);
      LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131231681);
      this.jdField_a_of_type_JavaUtilArrayList.add(localLinearLayout);
      localLinearLayout.setOnClickListener(this);
      localLinearLayout = (LinearLayout)localView.findViewById(2131231682);
      this.jdField_a_of_type_JavaUtilArrayList.add(localLinearLayout);
      localLinearLayout.setOnClickListener(this);
      localLinearLayout = (LinearLayout)localView.findViewById(2131231683);
      this.jdField_a_of_type_JavaUtilArrayList.add(localLinearLayout);
      localLinearLayout.setOnClickListener(this);
      localLinearLayout = (LinearLayout)localView.findViewById(2131231684);
      this.jdField_a_of_type_JavaUtilArrayList.add(localLinearLayout);
      localLinearLayout.setOnClickListener(this);
      ((LinearLayout)localView.findViewById(2131231685)).setOnClickListener(this);
    }
    if (!this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing()) {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView, 83, 0, 0);
    }
  }
  
  public String a()
  {
    return "PA";
  }
  
  protected void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if (paramInt == -8) {
      QRUtils.a(1, 2131560546);
    }
  }
  
  protected boolean a(WebView paramWebView, String paramString)
  {
    if ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")) && (!paramString.startsWith("file://"))) {}
    do
    {
      return false;
      QLog.d("PublicAccountBrowser", 2, "shouldOverride: " + paramString);
      b(jdField_b_of_type_Int);
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
    if ((this.y & 0x8) == 0)
    {
      localObject = new PublicAccountBrowser.ActionSheetItem();
      ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = super.getString(2131560568);
      ((PublicAccountBrowser.ActionSheetItem)localObject).k = 2130837751;
      ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
      ((PublicAccountBrowser.ActionSheetItem)localObject).l = 2;
      ((PublicAccountBrowser.ActionSheetItem)localObject).b = "";
      localArrayList.add(localObject);
    }
    if ((this.y & 0x10) == 0)
    {
      localObject = new PublicAccountBrowser.ActionSheetItem();
      ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = super.getString(2131560573);
      ((PublicAccountBrowser.ActionSheetItem)localObject).k = 2130837752;
      ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
      ((PublicAccountBrowser.ActionSheetItem)localObject).l = 3;
      ((PublicAccountBrowser.ActionSheetItem)localObject).b = "";
    }
    if ((this.y & 0x200) == 0)
    {
      localObject = new PublicAccountBrowser.ActionSheetItem();
      ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = super.getString(2131560572);
      ((PublicAccountBrowser.ActionSheetItem)localObject).k = 2130838482;
      ((PublicAccountBrowser.ActionSheetItem)localObject).l = 5;
      ((PublicAccountBrowser.ActionSheetItem)localObject).b = "";
      localArrayList.add(localObject);
    }
    if ((this.y & 0x100) == 0)
    {
      localObject = new PublicAccountBrowser.ActionSheetItem();
      ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = super.getString(2131560571);
      ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
      ((PublicAccountBrowser.ActionSheetItem)localObject).k = 2130838480;
      ((PublicAccountBrowser.ActionSheetItem)localObject).l = 4;
      ((PublicAccountBrowser.ActionSheetItem)localObject).b = "";
      localArrayList.add(localObject);
    }
    Object localObject = new ArrayList();
    PublicAccountBrowser.ActionSheetItem localActionSheetItem;
    if ((!TextUtils.isEmpty(this.s)) && ((this.y & 0x40) == 0))
    {
      localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
      localActionSheetItem.jdField_a_of_type_JavaLangString = super.getString(2131560576);
      localActionSheetItem.k = 2130838479;
      localActionSheetItem.jdField_a_of_type_Boolean = true;
      localActionSheetItem.l = 8;
      localActionSheetItem.b = "";
      ((ArrayList)localObject).add(localActionSheetItem);
    }
    if ((this.y & 0x2000) == 0)
    {
      localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
      localActionSheetItem.jdField_a_of_type_JavaLangString = super.getString(2131560581);
      localActionSheetItem.jdField_a_of_type_Boolean = true;
      localActionSheetItem.k = 2130838584;
      localActionSheetItem.l = 6;
      localActionSheetItem.b = "";
      ((ArrayList)localObject).add(localActionSheetItem);
    }
    if ((this.y & 0x80) == 0)
    {
      localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
      localActionSheetItem.jdField_a_of_type_JavaLangString = super.getString(2131560569);
      localActionSheetItem.k = 2130838481;
      localActionSheetItem.jdField_a_of_type_Boolean = true;
      localActionSheetItem.l = 7;
      localActionSheetItem.b = "";
      ((ArrayList)localObject).add(localActionSheetItem);
    }
    if ((this.y & 0x20) == 0)
    {
      localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
      localActionSheetItem.jdField_a_of_type_JavaLangString = super.getString(2131560570);
      localActionSheetItem.k = 2130837750;
      localActionSheetItem.jdField_a_of_type_Boolean = true;
      localActionSheetItem.l = 1;
      localActionSheetItem.b = "";
      ((ArrayList)localObject).add(localActionSheetItem);
    }
    return (List[])new ArrayList[] { localArrayList, localObject };
  }
  
  public String b_()
  {
    return this.s;
  }
  
  protected void d()
  {
    b();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    Intent localIntent = getIntent();
    String str = localIntent.getStringExtra("url");
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
      this.k.setOnClickListener(this);
      this.m.setText(2131561999);
      this.m.setOnClickListener(this);
    }
    for (;;)
    {
      return true;
      e();
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
  
  protected void l_()
  {
    if ((!TextUtils.isEmpty(this.s)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizAuthorizeConfig.a(this.I)))) {
      this.I = Uri.parse(this.I).buildUpon().appendQueryParameter("puin", this.s).appendQueryParameter("uin", this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.getAccount()).toString();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getSettings().setSupportZoom(true);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      super.onClick(paramView);
      return;
    case 2131231685: 
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
      return;
    case 2131231681: 
      b(0);
      return;
    case 2131231682: 
      b(1);
      return;
    case 2131231683: 
      b(2);
      return;
    }
    b(3);
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = paramView.getTag();
    if (!(localObject instanceof PublicAccountBrowser.ActionSheetItemViewHolder))
    {
      QLog.d("PublicAccountBrowser", 4, "Item clicked but tag not found");
      return;
    }
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
    int i1 = ((PublicAccountBrowser.ActionSheetItemViewHolder)localObject).a.l;
    if (i1 == 7)
    {
      p();
      return;
    }
    if (i1 == 8)
    {
      a(this.s);
      return;
    }
    super.onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountBrowser
 * JD-Core Version:    0.7.0.1
 */