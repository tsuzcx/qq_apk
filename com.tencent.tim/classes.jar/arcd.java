import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.webview.WebViewTitleStyle;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.WebView;
import com.tencent.theme.SkinEngine;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class arcd
  extends araz.a
  implements View.OnClickListener, Animation.AnimationListener
{
  public ImageView Fs;
  public ImageView Ft;
  public View Ju;
  public View Jv;
  public int Qx = -1;
  Animation S;
  Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  public aqzg a;
  public aqzl a;
  private arbz jdField_a_of_type_Arbz;
  public final arcd.a a;
  public TextView abM;
  public TextView abN;
  public ProgressBar ar;
  long avp = 0L;
  public WebViewFragment c;
  private boolean cYi;
  public boolean cYj;
  public boolean cYk;
  public FrameLayout cg;
  private View.OnClickListener clickListener;
  public String cyN = "";
  public View eG;
  public ViewGroup eO;
  public ViewGroup eP;
  public ViewGroup eQ;
  public int ees = -1;
  public TextView ix;
  public WebViewProgressBar mLoadingProgressBar;
  public arju mProgressBarController;
  public ViewGroup mRootView;
  public Activity s;
  public boolean zP = true;
  public boolean zQ;
  
  public arcd()
  {
    this.jdField_a_of_type_Arcd$a = new arcd.a();
  }
  
  private WebViewTitleStyle a(String paramString)
  {
    int i1 = 1;
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = Uri.parse(paramString);
    String str1;
    String str2;
    int k;
    if ((localObject != null) && (((Uri)localObject).isHierarchical()))
    {
      paramString = ((Uri)localObject).getQueryParameter("_wvNb");
      str1 = ((Uri)localObject).getQueryParameter("_wvNs");
      str2 = ((Uri)localObject).getQueryParameter("_wvNt");
      localObject = ((Uri)localObject).getQueryParameter("_wvNi");
      k = 0;
    }
    int j;
    for (int i = 0;; i = j)
    {
      for (;;)
      {
        try
        {
          if (TextUtils.isEmpty(paramString)) {
            break;
          }
          i = fs(paramString);
          k = 1;
        }
        catch (Exception paramString)
        {
          j = -1;
          m = -1;
          i = -1;
        }
        try
        {
          if (!TextUtils.isEmpty(str1))
          {
            m = fs(str1);
            k = 1;
          }
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            j = -1;
            m = -1;
          }
        }
        try
        {
          if (TextUtils.isEmpty(str2)) {
            break label240;
          }
          j = fs(str2);
          k = 1;
        }
        catch (Exception paramString)
        {
          j = -1;
          break label195;
        }
        try
        {
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break label234;
          }
          n = fs((String)localObject);
          k = i1;
          if (k == 0) {
            break label229;
          }
          paramString = new WebViewTitleStyle();
          paramString.statusBarColor = m;
          paramString.wP = i;
          paramString.titleColor = j;
          paramString.edP = n;
          return paramString;
        }
        catch (Exception paramString)
        {
          break label195;
        }
        int m = i;
        continue;
        label195:
        QLog.e("SwiftBrowserUIStyleHandler", 1, "getTitleStyleFromWVParams Illegal param, e = ", paramString);
        int n = -1;
        continue;
        label229:
        paramString = null;
        continue;
        label234:
        n = -1;
        continue;
        label240:
        j = -1;
      }
      j = -1;
      k = i;
    }
  }
  
  private WebViewTitleStyle b(String paramString)
  {
    int j = 0;
    int i1 = 1;
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = Uri.parse(paramString);
    String str1;
    String str2;
    if ((localObject != null) && (((Uri)localObject).isHierarchical()))
    {
      paramString = ((Uri)localObject).getQueryParameter("_nav_bgclr");
      str1 = ((Uri)localObject).getQueryParameter("_nav_statusclr");
      str2 = ((Uri)localObject).getQueryParameter("_nav_titleclr");
      localObject = ((Uri)localObject).getQueryParameter("_nav_txtclr");
    }
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          break label248;
        }
        k = fs(paramString);
        i = 1;
      }
      catch (Exception paramString)
      {
        i = -1;
        m = -1;
        k = -1;
      }
      try
      {
        if (!TextUtils.isEmpty(str1))
        {
          m = fs(str1);
          j = 1;
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          label192:
          m = -1;
          n = -1;
          j = i;
          i = n;
        }
      }
      try
      {
        if (TextUtils.isEmpty(str2)) {
          break label243;
        }
        i = fs(str2);
        j = 1;
      }
      catch (Exception paramString)
      {
        i = -1;
        break label192;
      }
      try
      {
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label237;
        }
        n = fs((String)localObject);
        j = i1;
        if (j == 0) {
          break label232;
        }
        paramString = new WebViewTitleStyle();
        paramString.statusBarColor = m;
        paramString.wP = k;
        paramString.titleColor = i;
        paramString.edP = n;
        return paramString;
      }
      catch (Exception paramString)
      {
        break label192;
      }
      int m = 0;
      j = i;
      continue;
      QLog.e("SwiftBrowserUIStyleHandler", 1, "getTitleStyleFromWVParams Illegal param, e = ", paramString);
      int n = -1;
      continue;
      label232:
      paramString = null;
      continue;
      label237:
      n = -1;
      continue;
      label243:
      int i = -1;
      continue;
      label248:
      i = 0;
      int k = -1;
    }
  }
  
  private int fs(String paramString)
  {
    int j = -1;
    int i = j;
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.startsWith("0x")) {
        break label86;
      }
      paramString = paramString.substring(2);
    }
    label86:
    for (;;)
    {
      String str = paramString;
      try
      {
        if (!paramString.startsWith("#")) {
          str = "#" + paramString;
        }
        i = Color.parseColor(str);
      }
      catch (NumberFormatException paramString)
      {
        do
        {
          i = j;
        } while (!QLog.isDevelopLevel());
        QLog.d("SwiftBrowserUIStyleHandler", 4, "Illegal getColorIntFromUrlParams");
        return -1;
      }
      return i;
    }
  }
  
  private void j(Uri paramUri)
  {
    String str = "unknown";
    if (paramUri != null) {}
    try
    {
      str = paramUri.getHost();
      if ((this.jdField_a_of_type_Arcd$a.gK & 0x20000) != 0L) {
        anot.c(null, "dc00898", "", "", "0X800ADD8", "0X800ADD8", 131072, 0, "", "", str, "");
      }
      if ((this.jdField_a_of_type_Arcd$a.gK & 0x1000000) != 0L) {
        anot.c(null, "dc00898", "", "", "0X800ADD8", "0X800ADD8", 16777216, 0, "", "", str, "");
      }
      if ((this.jdField_a_of_type_Arcd$a.gK & 0x2) != 0L) {
        anot.c(null, "dc00898", "", "", "0X800ADD8", "0X800ADD8", 2, 0, "", "", str, "");
      }
      return;
    }
    catch (Throwable paramUri)
    {
      QLog.e("SwiftBrowserUIStyleHandler", 1, paramUri, new Object[0]);
    }
  }
  
  private void w(String paramString1, String paramString2, long paramLong)
  {
    try
    {
      long l1 = System.currentTimeMillis();
      if (!"1".equals(jml.a().H("wv_ctrl_switch", "")))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SwiftBrowserUIStyleHandler", 2, "checkWvParamAuthorize disable");
        }
      }
      else
      {
        if ((!jml.a().z(paramString2, paramString1)) && ((this.jdField_a_of_type_Arcd$a.gK & paramLong) != 0L))
        {
          paramString1 = this.jdField_a_of_type_Arcd$a;
          paramString1.gK &= (0xFFFFFFFF ^ paramLong);
          if (QLog.isColorLevel()) {
            QLog.d("SwiftBrowserUIStyleHandler", 2, new Object[] { "no authorize for wv param domain:", paramString2, " wv:", Long.valueOf(paramLong) });
          }
        }
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel())
        {
          QLog.d("SwiftBrowserUIStyleHandler", 2, new Object[] { "checkWvParamAuthorize cost:", Long.valueOf(l2 - l1), " domain:", paramString2, " wv:", Long.valueOf(paramLong) });
          return;
        }
      }
    }
    catch (Throwable paramString1)
    {
      QLog.e("SwiftBrowserUIStyleHandler", 1, paramString1, new Object[0]);
    }
  }
  
  public void P(int paramInt, Bundle paramBundle)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    super.P(paramInt, paramBundle);
    switch (paramInt)
    {
    case 5: 
    default: 
      return;
    case 2: 
      jqo.le("Web_updateTitleBarUI");
      if (this.jdField_a_of_type_Arcd$a.cYC) {
        this.jdField_a_of_type_Aqzl.egC();
      }
      jqo.lf("Web_updateTitleBarUI");
      return;
    case 3: 
      if (this.Jv != null)
      {
        paramBundle = this.Jv.getParent();
        if ((paramBundle != null) && ((paramBundle instanceof ViewGroup))) {
          ((ViewGroup)paramBundle).removeView(this.Jv);
        }
      }
      this.jdField_a_of_type_Aqzl.egA();
      return;
    case 4: 
      if ((this.jdField_a_of_type_Aqzg.AM != null) && (8 == this.jdField_a_of_type_Aqzg.AO.getVisibility())) {
        this.jdField_a_of_type_Aqzg.egz();
      }
      if (paramBundle.containsKey("Configuration")) {}
      for (paramBundle = (Configuration)paramBundle.getParcelable("Configuration"); (paramBundle != null) && (this.jdField_a_of_type_Aqzg.AO != null) && (paramBundle.orientation == 2) && (this.jdField_a_of_type_Aqzg.AO.getVisibility() == 0); paramBundle = null)
      {
        this.jdField_a_of_type_Aqzg.AO.setVisibility(8);
        return;
      }
    case 6: 
      if ((!this.jdField_a_of_type_Arbz.mIsFirstOnPageStart) && (this.mProgressBarController != null) && (this.mProgressBarController.getCurStatus() != 0)) {
        this.mProgressBarController.enterStatus((byte)0);
      }
      this.ar.setVisibility(8);
      if ((paramBundle == null) || (!paramBundle.containsKey("url"))) {
        break;
      }
    }
    for (paramBundle = paramBundle.getString("url");; paramBundle = null)
    {
      if (!TextUtils.isEmpty(paramBundle)) {
        localObject1 = Uri.parse(paramBundle);
      }
      if ((localObject1 != null) && (((Uri)localObject1).isHierarchical()) && ("simple".equals(((Uri)localObject1).getQueryParameter("style"))))
      {
        this.jdField_a_of_type_Aqzl.rightViewImg.setVisibility(8);
        this.jdField_a_of_type_Arcd$a.cYH = true;
      }
      f(this.jdField_a_of_type_Araz$b.getWebView());
      return;
      if (this.mProgressBarController != null) {
        this.mProgressBarController.enterStatus((byte)2);
      }
      this.ar.setVisibility(8);
      if ((this.jdField_a_of_type_Arcd$a.cYM) || (this.ix == null)) {
        break;
      }
      if ((this.eG != null) && (this.Qx == -1)) {
        this.eG.setBackgroundResource(2131167650);
      }
      this.ix.setVisibility(0);
      if (this.jdField_a_of_type_Araz$b.getWebView() == null) {
        break;
      }
      localObject1 = (TouchWebView)this.jdField_a_of_type_Araz$b.getWebView();
      if (this.abN != null)
      {
        if (((TouchWebView)localObject1).getX5WebViewExtension() == null) {
          break label566;
        }
        this.abN.setVisibility(0);
      }
      for (;;)
      {
        paramBundle = localObject2;
        if ((this.eQ instanceof RefreshView)) {
          paramBundle = (RefreshView)this.eQ;
        }
        if ((paramBundle == null) || (!this.zP)) {
          break;
        }
        ((TouchWebView)localObject1).setOnOverScrollHandler(new arce(this, (TouchWebView)localObject1, paramBundle));
        ((TouchWebView)localObject1).setOnScrollChangedListener(new arcf(this));
        g(this.jdField_a_of_type_Araz$b.getWebView());
        return;
        label566:
        this.abN.setVisibility(8);
      }
    }
  }
  
  public void Tv(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Arcd$a.cYx == paramBoolean) {}
    Object localObject;
    for (;;)
    {
      return;
      this.jdField_a_of_type_Arcd$a.cYx = paramBoolean;
      localObject = null;
      if ((this.s instanceof IphoneTitleBarActivity)) {
        localObject = ((IphoneTitleBarActivity)this.s).getTitleBarView();
      }
      while (localObject != null)
      {
        ((View)localObject).setBackgroundColor(BaseApplicationImpl.getContext().getResources().getColor(2131167361));
        if (!paramBoolean) {
          break label98;
        }
        h((View)localObject, 255, 0, 200);
        return;
        if (this.c != null) {
          localObject = this.jdField_a_of_type_Aqzl.aK;
        }
      }
    }
    label98:
    h((View)localObject, 0, 255, 200);
  }
  
  public void Tw(boolean paramBoolean)
  {
    this.jdField_a_of_type_Aqzl.jdField_a_of_type_Arcd$a.cYv = paramBoolean;
    if (paramBoolean)
    {
      this.jdField_a_of_type_Aqzl.VQ("");
      return;
    }
    this.jdField_a_of_type_Aqzl.dkr();
  }
  
  public TouchWebView a()
  {
    return (TouchWebView)this.jdField_a_of_type_Araz$b.getWebView();
  }
  
  public void a(View paramView, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramView == null) {}
    do
    {
      return;
      int i;
      if ((this.jdField_a_of_type_Arcd$a.cYK) && (!"1000".equals(ThemeUtil.getCurrentThemeId()))) {
        i = 1;
      }
      Drawable localDrawable;
      while (paramBoolean)
      {
        if (i != 0)
        {
          localDrawable = SkinEngine.getInstances().getDefaultThemeDrawable(paramInt1);
          if (localDrawable != null)
          {
            paramView.setBackgroundDrawable(localDrawable);
            return;
            i = 0;
            continue;
          }
        }
        paramView.setBackgroundResource(paramInt2);
        return;
      }
      if ((paramView instanceof ImageView))
      {
        paramView = (ImageView)paramView;
        if (i != 0)
        {
          localDrawable = SkinEngine.getInstances().getDefaultThemeDrawable(paramInt1);
          if (localDrawable != null)
          {
            paramView.setImageDrawable(localDrawable);
            return;
          }
        }
        paramView.setImageResource(paramInt2);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AbsBaseWebViewActivity", 2, "-->setShowDefaultThemeIcon err! resId=" + paramInt1);
  }
  
  @TargetApi(14)
  public void a(WebBrowserViewContainer paramWebBrowserViewContainer, Intent paramIntent, TouchWebView paramTouchWebView)
  {
    long l2 = System.currentTimeMillis();
    this.cg = ((FrameLayout)paramWebBrowserViewContainer.findViewById(2131367814));
    this.cg.setVisibility(0);
    if ((this.jdField_a_of_type_Arcd$a.isFullScreen) && (this.jdField_a_of_type_Arcd$a.Dr != 0L))
    {
      paramWebBrowserViewContainer.Tj(this.jdField_a_of_type_Arcd$a.cYP);
      this.jdField_a_of_type_Aqzg.a(paramWebBrowserViewContainer, this.clickListener);
      this.jdField_a_of_type_Aqzg.ct(this.s);
    }
    long l1 = System.currentTimeMillis();
    this.jdField_a_of_type_Arbz.auB = (l1 - l2);
    this.mLoadingProgressBar = ((WebViewProgressBar)this.cg.findViewById(2131373669));
    this.mProgressBarController = new arju();
    this.mLoadingProgressBar.setController(this.mProgressBarController);
    paramIntent = this.mProgressBarController;
    if (!this.cYk) {}
    for (boolean bool = true;; bool = false)
    {
      paramIntent.xW(bool);
      if ((this.jdField_a_of_type_Arbz.mIsFirstOnPageStart) && (this.mProgressBarController != null) && (this.mProgressBarController.getCurStatus() != 0)) {
        this.mProgressBarController.enterStatus((byte)0);
      }
      jqo.le("Web_qqbrowser_initView_WebViewWrapper");
      this.eQ = ((ViewGroup)this.cg.findViewById(2131382187));
      jqo.lf("Web_qqbrowser_initView_WebViewWrapper");
      l2 = System.currentTimeMillis();
      this.jdField_a_of_type_Arbz.auy = (l2 - l1);
      if (!this.jdField_a_of_type_Arcd$a.cYM)
      {
        this.eG = this.cg.findViewById(2131363732);
        this.ix = ((TextView)this.cg.findViewById(2131363733));
        this.abN = ((TextView)this.cg.findViewById(2131379266));
        this.ix.setVisibility(4);
        this.abN.setVisibility(4);
        if ((this.jdField_a_of_type_Arcd$a.cYl) && ((this.s instanceof BaseActivity))) {
          ((ViewGroup.MarginLayoutParams)this.ix.getLayoutParams()).topMargin = ((BaseActivity)this.s).getTitleBarHeight();
        }
      }
      if (!this.cYj) {
        this.ar = ((ProgressBar)this.cg.findViewById(2131377037));
      }
      if ((this.jdField_a_of_type_Arcd$a.cYL) && (this.eG != null)) {
        this.eG.setPadding(0, (int)aqho.convertDpToPixel(BaseApplicationImpl.getContext(), 30.0F), 0, 0);
      }
      ehp();
      this.s.getWindow().setBackgroundDrawable(null);
      if (this.mRootView != null) {
        this.mRootView.setBackgroundDrawable(null);
      }
      aCR();
      if (this.ees != -1) {
        paramWebBrowserViewContainer.setBackgroundColor(this.ees);
      }
      if (this.jdField_a_of_type_Aqzl != null) {
        this.jdField_a_of_type_Aqzl.bkZ();
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean2, String paramString1, String paramString2, String paramString3)
  {
    if (this.jdField_a_of_type_Araz$b.getWebView() == null) {
      return;
    }
    this.jdField_a_of_type_Aqzl.a((TouchWebView)this.jdField_a_of_type_Araz$b.getWebView(), paramBoolean1, paramInt1, paramInt2, paramInt3, paramBoolean2, paramString1, paramString2, paramString3);
  }
  
  public void aCR()
  {
    if (this.jdField_a_of_type_Araz$b.getWebView() != null)
    {
      WebView localWebView = this.jdField_a_of_type_Araz$b.getWebView();
      localWebView.setId(2131382171);
      if (this.ees != -1) {
        localWebView.setBackgroundColor(this.ees);
      }
      this.eQ.addView(localWebView, 0, new ViewGroup.LayoutParams(-1, -1));
    }
  }
  
  public void bL(boolean paramBoolean, int paramInt)
  {
    if (this.eP == null) {}
    Object localObject;
    int i;
    label40:
    do
    {
      do
      {
        return;
        localObject = this.eP;
        if (!paramBoolean) {
          break;
        }
        i = 0;
        ((ViewGroup)localObject).setVisibility(i);
        localObject = this.abM;
        if (paramInt != 0) {
          break label118;
        }
        paramInt = 2131695364;
        ((TextView)localObject).setText(paramInt);
      } while (this.jdField_a_of_type_Araz$b.getWebView() == null);
      localObject = (FrameLayout.LayoutParams)this.eQ.getLayoutParams();
    } while (localObject == null);
    if (paramBoolean) {}
    for (((FrameLayout.LayoutParams)localObject).bottomMargin = ((int)(this.s.getResources().getDisplayMetrics().density * 75.0F));; ((FrameLayout.LayoutParams)localObject).bottomMargin = 0)
    {
      this.eQ.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      i = 8;
      break;
      label118:
      paramInt = 2131695365;
      break label40;
    }
  }
  
  public void d(Intent paramIntent, String paramString)
  {
    this.jdField_a_of_type_Aqzl.d(paramIntent, paramString);
    d(this.jdField_a_of_type_Arcd$a.ce, false);
    ehh();
  }
  
  public void d(JSONObject paramJSONObject, boolean paramBoolean)
  {
    this.jdField_a_of_type_Aqzl.d(paramJSONObject, paramBoolean);
  }
  
  public void dU(Intent paramIntent)
  {
    int i;
    boolean bool;
    if (((this.jdField_a_of_type_Arcd$a.gK & 0x20000) != 0L) || (paramIntent.getBooleanExtra("isFullScreen", false)))
    {
      i = 1;
      if (i != 0) {
        this.jdField_a_of_type_Arcd$a.isFullScreen = true;
      }
      arcd.a locala = this.jdField_a_of_type_Arcd$a;
      if (((this.jdField_a_of_type_Arcd$a.gK & 0x1000000) == 0L) && (!paramIntent.getBooleanExtra("isTransparentTitle", false))) {
        break label696;
      }
      bool = true;
      label76:
      locala.cYl = bool;
      locala = this.jdField_a_of_type_Arcd$a;
      if (((this.jdField_a_of_type_Arcd$a.Ds & 1L) == 0L) && (!paramIntent.getBooleanExtra("isTransparentTitleAndClickable", false))) {
        break label701;
      }
      bool = true;
      label115:
      locala.cYw = bool;
      locala = this.jdField_a_of_type_Arcd$a;
      if (((this.jdField_a_of_type_Arcd$a.gK & 0x2) == 0L) && (!paramIntent.getBooleanExtra("hide_more_button", false))) {
        break label706;
      }
      bool = true;
      label156:
      locala.cYo = bool;
      locala = this.jdField_a_of_type_Arcd$a;
      if (((this.jdField_a_of_type_Arcd$a.gK & 1L) == 0L) && (!paramIntent.getBooleanExtra("hide_operation_bar", false)) && (!"noBottomBar".equals(paramIntent.getStringExtra("webStyle")))) {
        break label711;
      }
      bool = true;
      label211:
      locala.cYp = bool;
      locala = this.jdField_a_of_type_Arcd$a;
      if ((this.jdField_a_of_type_Arcd$a.Ds & 0x100) == 0L) {
        break label716;
      }
      bool = true;
      label241:
      locala.cYy = bool;
      if (!TextUtils.isEmpty(paramIntent.getStringExtra("key_params_qq")))
      {
        this.jdField_a_of_type_Arcd$a.cYo = true;
        this.jdField_a_of_type_Arcd$a.cYp = true;
      }
      i = paramIntent.getIntExtra("reqType", -1);
      if ((!this.jdField_a_of_type_Arcd$a.cYp) && (i == 6)) {
        this.jdField_a_of_type_Arcd$a.cYp = true;
      }
      this.jdField_a_of_type_Arcd$a.cYq = paramIntent.getBooleanExtra("fromOneCLickCLose", false);
      this.jdField_a_of_type_Arcd$a.cYA = paramIntent.getBooleanExtra("rightTopCancel", false);
      this.jdField_a_of_type_Arcd$a.cYB = paramIntent.getBooleanExtra("webViewMoveTop", false);
      if ((!this.jdField_a_of_type_Arcd$a.cYo) && ((i == 3) || (i == 1) || (!paramIntent.getBooleanExtra("ba_is_login", true)) || (i == 7))) {
        this.jdField_a_of_type_Arcd$a.cYo = true;
      }
      if ((this.jdField_a_of_type_Arcd$a.gK & 0x20000) > 0L) {
        this.jdField_a_of_type_Arcd$a.isFullScreen = true;
      }
      if ((this.jdField_a_of_type_Arcd$a.gK & 0x20000000) != 0L) {
        this.jdField_a_of_type_Arcd$a.cYC = true;
      }
      if ((this.jdField_a_of_type_Arcd$a.gK & 0x800) > 0L)
      {
        this.jdField_a_of_type_Arcd$a.cYn = true;
        this.jdField_a_of_type_Arcd$a.aO = Boolean.valueOf(false);
      }
      if ((this.jdField_a_of_type_Arcd$a.Ds & 0x4) > 0L)
      {
        this.jdField_a_of_type_Arcd$a.cYn = false;
        this.jdField_a_of_type_Arcd$a.aO = Boolean.valueOf(true);
      }
      if ((this.jdField_a_of_type_Arcd$a.Ds & 0x2) > 0L) {
        this.jdField_a_of_type_Arcd$a.cYr = true;
      }
      if ((this.jdField_a_of_type_Arcd$a.Ds & 0x200) > 0L) {
        this.jdField_a_of_type_Arcd$a.cYM = true;
      }
      if ((this.jdField_a_of_type_Arcd$a.Ds & 0x400) > 0L)
      {
        locala = this.jdField_a_of_type_Arcd$a;
        this.jdField_a_of_type_Arcd$a.cYK = true;
        locala.aYy = true;
      }
      if ((this.jdField_a_of_type_Arcd$a.Ds & 0x2000) > 0L) {
        this.jdField_a_of_type_Arcd$a.cYz = true;
      }
      if ((this.jdField_a_of_type_Arcd$a.Io & 1L) > 0L) {
        this.jdField_a_of_type_Arcd$a.cYl = true;
      }
      if ((this.jdField_a_of_type_Arcd$a.Io & 0x8) > 0L) {
        this.jdField_a_of_type_Arcd$a.cYw = true;
      }
      if (!paramIntent.getBooleanExtra("from_single_task", false)) {
        break label721;
      }
      this.jdField_a_of_type_Arcd$a.cYO = true;
    }
    label696:
    label701:
    label706:
    label711:
    label716:
    label721:
    while ((this.jdField_a_of_type_Arcd$a.gK & 0x80000000) <= 0L)
    {
      return;
      i = 0;
      break;
      bool = false;
      break label76;
      bool = false;
      break label115;
      bool = false;
      break label156;
      bool = false;
      break label211;
      bool = false;
      break label241;
    }
    this.jdField_a_of_type_Arcd$a.cYN = jml.a().cZ(paramIntent.getStringExtra("url"));
  }
  
  public void dV(Intent paramIntent)
  {
    if ((paramIntent == null) || (TextUtils.isEmpty(paramIntent.getStringExtra("url")))) {}
    do
    {
      Uri localUri;
      do
      {
        return;
        localObject = paramIntent.getStringExtra("url");
        localUri = Uri.parse((String)localObject);
      } while ((localUri == null) || (!localUri.isHierarchical()));
      if ("1".equals(localUri.getQueryParameter("_qStyle")))
      {
        paramIntent = new WebViewTitleStyle();
        paramIntent.statusBarColor = -16777216;
        paramIntent.wP = -1;
        paramIntent.titleColor = -16777216;
        paramIntent.edP = -16777216;
        this.jdField_a_of_type_Arcd$a.a = paramIntent;
        return;
      }
      WebViewTitleStyle localWebViewTitleStyle = a((String)localObject);
      if (localWebViewTitleStyle != null)
      {
        this.jdField_a_of_type_Arcd$a.a = localWebViewTitleStyle;
        return;
      }
      Object localObject = b((String)localObject);
      if (localObject != null)
      {
        this.jdField_a_of_type_Arcd$a.a = ((WebViewTitleStyle)localObject);
        return;
      }
      paramIntent = (WebViewTitleStyle)paramIntent.getParcelableExtra("titleStyle");
      if (paramIntent != null)
      {
        this.jdField_a_of_type_Arcd$a.a = paramIntent;
        return;
      }
      paramIntent = localUri.getHost();
      paramIntent = (WebViewTitleStyle)aqyz.a().oA.get(paramIntent);
    } while (paramIntent == null);
    this.jdField_a_of_type_Arcd$a.a = paramIntent;
  }
  
  public void egS()
  {
    super.egS();
    this.s = this.jdField_a_of_type_Araz$b.getActivity();
    this.c = this.jdField_a_of_type_Araz$b.b();
    this.jdField_a_of_type_Arbz = ((arbz)this.jdField_a_of_type_Araz$b.c().q(-2));
  }
  
  public void ehg()
  {
    this.jdField_a_of_type_Aqzl = aqyl.a(this);
    this.jdField_a_of_type_Aqzg = aqzf.a(this);
  }
  
  public void ehh()
  {
    if ((this.jdField_a_of_type_Araz$b.getWebView() != null) && (!this.jdField_a_of_type_Arcd$a.isFullScreen)) {
      f((TouchWebView)this.jdField_a_of_type_Araz$b.getWebView());
    }
  }
  
  public void ehi()
  {
    if ((this.jdField_a_of_type_Arcd$a.cYB) && (!this.jdField_a_of_type_Arcd$a.cYG)) {
      this.jdField_a_of_type_Arcd$a.cYG = this.jdField_a_of_type_Aqzl.aFX();
    }
  }
  
  public void ehj()
  {
    ViewStub localViewStub = (ViewStub)this.cg.findViewById(2131363626);
    if (localViewStub == null) {
      return;
    }
    this.eP = ((ViewGroup)localViewStub.inflate());
    this.abM = ((TextView)this.cg.findViewById(2131380511));
    this.abM.setOnClickListener(this.clickListener);
    this.eP.setVisibility(8);
  }
  
  public void ehk()
  {
    ViewStub localViewStub;
    if (this.jdField_a_of_type_Arcd$a.cYA)
    {
      localViewStub = (ViewStub)this.cg.findViewById(2131367236);
      if (localViewStub != null) {}
    }
    else
    {
      return;
    }
    this.Ju = localViewStub.inflate();
    this.Ju.getLayoutParams();
    this.Ju.setOnClickListener(this.clickListener);
  }
  
  public void ehl()
  {
    FrameLayout.LayoutParams localLayoutParams;
    if ((this.jdField_a_of_type_Araz$b.getWebView() != null) && (this.eO != null))
    {
      localLayoutParams = (FrameLayout.LayoutParams)this.eQ.getLayoutParams();
      if (localLayoutParams != null) {}
    }
    else
    {
      return;
    }
    DisplayMetrics localDisplayMetrics;
    float f;
    if (this.cYi)
    {
      localDisplayMetrics = this.s.getResources().getDisplayMetrics();
      f = this.jdField_a_of_type_Arcd$a.bottomMargin;
    }
    for (localLayoutParams.bottomMargin = ((int)(localDisplayMetrics.density * f));; localLayoutParams.bottomMargin = 0)
    {
      this.eQ.setLayoutParams(localLayoutParams);
      return;
    }
  }
  
  public void ehm()
  {
    if (this.jdField_a_of_type_Aqzg.AR != null) {
      this.jdField_a_of_type_Aqzg.AR.setVisibility(0);
    }
    if ((this.jdField_a_of_type_Aqzg.AM != null) && ((this.jdField_a_of_type_Aqzg.AM.getVisibility() == 8) || (this.jdField_a_of_type_Aqzg.AM.getVisibility() == 4))) {
      this.jdField_a_of_type_Aqzg.AM.setVisibility(0);
    }
  }
  
  public void ehn()
  {
    this.jdField_a_of_type_Arcd$a.cYr = true;
    this.s.setRequestedOrientation(2);
  }
  
  public void eho()
  {
    this.jdField_a_of_type_Arcd$a.cYr = true;
    int i = this.s.getResources().getConfiguration().orientation;
    if (QLog.isColorLevel()) {
      QLog.d("restoreOrientationFollowSenSor", 2, "--> orientation = " + i);
    }
    if (i == 1) {
      ehp();
    }
    do
    {
      return;
      this.s.setRequestedOrientation(2);
    } while (!QLog.isColorLevel());
    QLog.d("restoreOrientationFollowSenSor", 2, "--> orientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR 4");
  }
  
  public void ehp()
  {
    int i;
    boolean bool;
    if ((this.jdField_a_of_type_Arcd$a.cYn) || (this.jdField_a_of_type_Arcd$a.aO.booleanValue()))
    {
      i = 1;
      if (i != 0) {
        break label74;
      }
      if ((!this.jdField_a_of_type_Arcd$a.cYo) || (this.jdField_a_of_type_Arcd$a.cYr)) {
        break label69;
      }
      bool = true;
    }
    for (;;)
    {
      if (!bool) {
        break label88;
      }
      this.s.setRequestedOrientation(1);
      return;
      i = 0;
      break;
      label69:
      bool = false;
      continue;
      label74:
      bool = this.jdField_a_of_type_Arcd$a.aO.booleanValue();
    }
    label88:
    if (this.jdField_a_of_type_Arcd$a.cYn)
    {
      this.s.setRequestedOrientation(0);
      return;
    }
    this.s.setRequestedOrientation(-1);
  }
  
  public void f(TouchWebView paramTouchWebView)
  {
    this.jdField_a_of_type_Aqzl.f(paramTouchWebView);
  }
  
  public void f(WebView paramWebView)
  {
    if (this.jdField_a_of_type_Arcd$a.cYq)
    {
      if (this.Fs != null) {
        this.Fs.setEnabled(false);
      }
      if (this.Ft != null) {
        this.Ft.setEnabled(false);
      }
    }
  }
  
  public void ff(boolean paramBoolean)
  {
    if ((!this.jdField_a_of_type_Arcd$a.cYq) || (this.jdField_a_of_type_Arcd$a.isFullScreen)) {}
    TouchWebView localTouchWebView;
    do
    {
      do
      {
        return;
      } while ((this.eO == null) || (this.cYi == paramBoolean));
      if (!paramBoolean) {
        break;
      }
      localTouchWebView = (TouchWebView)this.jdField_a_of_type_Araz$b.getWebView();
    } while ((localTouchWebView != null) && (!localTouchWebView.canGoBack()) && (!localTouchWebView.canGoForward()));
    this.cYi = true;
    this.eO.setVisibility(0);
    this.eO.clearAnimation();
    this.eO.setAnimation(this.S);
    this.S.start();
    anot.c(null, "dc00898", "", "", "0X8009B1E", "0X8009B1E", 0, 0, "", "", "", "");
    return;
    this.cYi = false;
    ehl();
    this.eO.clearAnimation();
    this.eO.setAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.start();
  }
  
  public void g(WebView paramWebView)
  {
    if (this.jdField_a_of_type_Arcd$a.cYq)
    {
      if (!this.jdField_a_of_type_Arcd$a.cYu) {
        break label26;
      }
      f(paramWebView);
    }
    label26:
    do
    {
      return;
      boolean bool = paramWebView.canGoBack();
      if (this.Fs != null) {
        this.Fs.setEnabled(bool);
      }
    } while (this.Ft == null);
    this.Ft.setEnabled(paramWebView.canGoForward());
  }
  
  public void h(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Aqzl.h(paramView, paramInt1, paramInt2, paramInt3);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.S)
    {
      if (this.eO != null) {
        this.eO.setVisibility(0);
      }
      ehl();
    }
    while ((paramAnimation != this.jdField_a_of_type_AndroidViewAnimationAnimation) || (this.eO == null)) {
      return;
    }
    this.eO.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick(View paramView)
  {
    if ((this.s instanceof View.OnClickListener)) {
      ((View.OnClickListener)this.s).onClick(paramView);
    }
    TouchWebView localTouchWebView = (TouchWebView)this.jdField_a_of_type_Araz$b.getWebView();
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((localTouchWebView != null) && (localTouchWebView.canGoBack()))
      {
        localTouchWebView.stopLoading();
        localTouchWebView.goBack();
        WebViewPluginEngine localWebViewPluginEngine = localTouchWebView.getPluginEngine();
        HashMap localHashMap;
        if (localWebViewPluginEngine != null)
        {
          localHashMap = new HashMap(1);
          localHashMap.put("target", Integer.valueOf(3));
          localWebViewPluginEngine.handleEvent(localTouchWebView.getUrl(), 8589934610L, localHashMap);
        }
        g(localTouchWebView);
        anot.c(null, "dc00898", "", "", "0X8009B21", "0X8009B21", 0, 0, "", "", "", "");
        continue;
        if ((localTouchWebView != null) && (localTouchWebView.canGoForward()))
        {
          localTouchWebView.stopLoading();
          localTouchWebView.goForward();
          localWebViewPluginEngine = localTouchWebView.getPluginEngine();
          if (localWebViewPluginEngine != null)
          {
            localHashMap = new HashMap(1);
            localHashMap.put("target", Integer.valueOf(3));
            localWebViewPluginEngine.handleEvent(localTouchWebView.getUrl(), 8589934602L, localHashMap);
          }
          g(localTouchWebView);
          anot.c(null, "dc00898", "", "", "0X8009B20", "0X8009B20", 0, 0, "", "", "", "");
        }
      }
    }
  }
  
  public boolean rS(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      if (this.jdField_a_of_type_Arcd$a.ce == null) {
        this.jdField_a_of_type_Arcd$a.ce = this.jdField_a_of_type_Aqzl.C(paramString);
      }
    } while ((this.jdField_a_of_type_Arcd$a.ce == null) || (this.jdField_a_of_type_Arcd$a.ce.length() == 0));
    if (this.jdField_a_of_type_Arcd$a.ce.optInt("trans", -1) == 0) {
      this.jdField_a_of_type_Arcd$a.cYG = true;
    }
    if (!this.jdField_a_of_type_Arcd$a.cYG) {
      this.jdField_a_of_type_Arcd$a.cYG = this.jdField_a_of_type_Aqzl.aFX();
    }
    return true;
  }
  
  public void setFloatingShareVisible(boolean paramBoolean)
  {
    this.jdField_a_of_type_Aqzg.setFloatingShareVisible(paramBoolean);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.clickListener = paramOnClickListener;
  }
  
  public void w(Intent paramIntent, String paramString)
  {
    if (this.jdField_a_of_type_Arcd$a.isFullScreen) {}
    do
    {
      do
      {
        return;
      } while ((this.eO != null) || (!this.jdField_a_of_type_Arcd$a.cYq));
      paramIntent = (ViewStub)this.cg.findViewById(2131363684);
    } while (paramIntent == null);
    this.eO = ((ViewGroup)paramIntent.inflate());
    this.Fs = ((ImageView)this.cg.findViewById(2131363222));
    this.Fs.setOnClickListener(this);
    this.Fs.setEnabled(false);
    this.Ft = ((ImageView)this.cg.findViewById(2131367523));
    this.Ft.setOnClickListener(this);
    this.Ft.setEnabled(false);
    this.eO.setVisibility(8);
    int i = (int)(this.s.getResources().getDisplayMetrics().density * 50.0F);
    this.S = new TranslateAnimation(0.0F, 0.0F, i, 0.0F);
    this.S.setDuration(300L);
    this.S.setAnimationListener(this);
    this.jdField_a_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, i);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(300L);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
  }
  
  public void xF(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Uri localUri = Uri.parse(paramString);
    String str;
    if (localUri.isHierarchical())
    {
      str = localUri.getQueryParameter("_wv");
      if (str == null) {}
    }
    try
    {
      this.jdField_a_of_type_Arcd$a.gK = Long.parseLong(str, 10);
      w("ui.wvHideActionBtn", paramString, 2L);
      w("ui.wvFullScreen", paramString, 131072L);
      paramString = localUri.getQueryParameter("_fv");
      if (paramString == null) {}
    }
    catch (NumberFormatException localNumberFormatException6)
    {
      try
      {
        this.jdField_a_of_type_Arcd$a.Dr = Long.parseLong(paramString, 10);
        paramString = localUri.getQueryParameter("_fu");
        this.jdField_a_of_type_Arcd$a.cYm = false;
        if (paramString == null) {}
      }
      catch (NumberFormatException localNumberFormatException6)
      {
        try
        {
          if (Long.parseLong(paramString) == 2019L) {
            this.jdField_a_of_type_Arcd$a.cYm = true;
          }
          paramString = localUri.getQueryParameter("_wwv");
          if (paramString == null) {}
        }
        catch (NumberFormatException localNumberFormatException6)
        {
          try
          {
            this.jdField_a_of_type_Arcd$a.Ds = Long.parseLong(paramString, 10);
            str = localUri.getQueryParameter("_cwv");
            if (str == null) {}
          }
          catch (NumberFormatException localNumberFormatException6)
          {
            try
            {
              this.jdField_a_of_type_Arcd$a.Io = Long.parseLong(str, 10);
              paramString = localUri.getQueryParameter("channel");
              if (!TextUtils.isEmpty(paramString)) {
                this.jdField_a_of_type_Arcd$a.czz = URLDecoder.decode(paramString);
              }
              paramString = localUri.getQueryParameter("subIndex");
              if (TextUtils.isEmpty(paramString)) {}
            }
            catch (NumberFormatException localNumberFormatException6)
            {
              try
              {
                this.jdField_a_of_type_Arcd$a.eet = Integer.parseInt(paramString.trim());
                paramString = localUri.getQueryParameter("bgColor");
                if (TextUtils.isEmpty(paramString)) {}
              }
              catch (NumberFormatException localNumberFormatException6)
              {
                try
                {
                  this.ees = ((int)Long.parseLong(paramString, 16));
                  paramString = localUri.getQueryParameter("titleAlpha");
                  if (TextUtils.isEmpty(paramString)) {}
                }
                catch (NumberFormatException localNumberFormatException6)
                {
                  try
                  {
                    for (;;)
                    {
                      this.jdField_a_of_type_Arcd$a.eeu = Integer.parseInt(paramString.trim());
                      paramString = localUri.getAuthority();
                      if ((TextUtils.isEmpty(paramString)) || (!paramString.endsWith("urlshare.cn"))) {
                        break;
                      }
                      this.jdField_a_of_type_Arcd$a.cYP = true;
                      j(localUri);
                      return;
                      localNumberFormatException8 = localNumberFormatException8;
                      QLog.e("SwiftBrowserUIStyleHandler", 1, "parser _wv param(" + str + ") error:" + localNumberFormatException8.getMessage());
                      continue;
                      localNumberFormatException1 = localNumberFormatException1;
                      QLog.e("SwiftBrowserUIStyleHandler", 1, "parser _fv param(" + paramString + ") error:" + localNumberFormatException1.getMessage());
                      continue;
                      localNumberFormatException2 = localNumberFormatException2;
                      QLog.e("SwiftBrowserUIStyleHandler", 1, "parser _fv param(" + paramString + ") error:" + localNumberFormatException2.getMessage());
                      continue;
                      localNumberFormatException3 = localNumberFormatException3;
                      QLog.e("SwiftBrowserUIStyleHandler", 1, "parser _wwv param(" + paramString + ") error:" + localNumberFormatException3.getMessage());
                      continue;
                      localNumberFormatException4 = localNumberFormatException4;
                      QLog.e("SwiftBrowserUIStyleHandler", 1, "parser _cwv param(" + paramString + ") error:" + localNumberFormatException4.getMessage());
                      continue;
                      localNumberFormatException5 = localNumberFormatException5;
                      QLog.e("SwiftBrowserUIStyleHandler", 1, "parser subIndex param(" + paramString + ") error:" + localNumberFormatException5.getMessage());
                    }
                    localNumberFormatException6 = localNumberFormatException6;
                    QLog.e("SwiftBrowserUIStyleHandler", 1, "parser bgColor param(" + paramString + ") error:" + localNumberFormatException6.getMessage());
                  }
                  catch (NumberFormatException localNumberFormatException7)
                  {
                    for (;;)
                    {
                      QLog.e("SwiftBrowserUIStyleHandler", 1, "parser titleAlpha param(" + paramString + ") error:" + localNumberFormatException7.getMessage());
                      continue;
                      this.jdField_a_of_type_Arcd$a.cYP = false;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static class a
  {
    public long Dr = 5L;
    public long Ds;
    public long Io;
    public WebViewTitleStyle a;
    public Boolean aO = Boolean.valueOf(false);
    public boolean aYy;
    public int bPY;
    public int bottomMargin = 50;
    public boolean cYA;
    public boolean cYB;
    public boolean cYC;
    public boolean cYD;
    public boolean cYE;
    public boolean cYF;
    public boolean cYG;
    public boolean cYH;
    public boolean cYI;
    public boolean cYJ;
    public boolean cYK;
    public boolean cYL;
    public boolean cYM;
    public boolean cYN;
    public boolean cYO;
    public boolean cYP;
    public boolean cYl;
    public boolean cYm;
    public boolean cYn;
    public boolean cYo;
    public boolean cYp;
    public boolean cYq;
    public boolean cYr;
    public boolean cYs;
    public boolean cYt;
    public boolean cYu;
    public boolean cYv;
    public boolean cYw;
    public boolean cYx;
    public boolean cYy;
    public boolean cYz;
    public JSONObject ce;
    public String czz;
    public int eet;
    public int eeu = -1;
    public long gK = 4L;
    public boolean isFullScreen;
    public boolean mIsAnimating;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arcd
 * JD-Core Version:    0.7.0.1
 */