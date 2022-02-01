import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.webview.WebViewTitleStyle;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI.6;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.ui.WebViewTopTabView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.FadeIconImageView;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aqzl
{
  public ImageView Fr;
  public String GY;
  public View Jo;
  public View Jp;
  private View Jq;
  public arcd.a a;
  public arcd a;
  public arct a;
  public JsBridgeListener a;
  public WebViewTopTabView a;
  Animation aG;
  Animation aH;
  public ViewGroup aK;
  boolean aMV;
  boolean aMW;
  @Nullable
  private Intent ap;
  aqnc.a<Integer> b = new aqzm(this);
  TouchWebView.OnScrollChangedListener c = new aqzn(this);
  public boolean cXl;
  private boolean cXm;
  boolean cXn = false;
  boolean cXo = false;
  boolean cXp = true;
  public TextView centerView;
  String cyI = null;
  String cyJ = null;
  String cyK = null;
  public FadeIconImageView d;
  public ViewGroup eM;
  private int edQ;
  int edR = 0;
  int edS = 240;
  int edT = 0;
  int edU = 255;
  Drawable fV;
  public tzd h;
  Intent intent;
  public TextView leftView;
  int mTitleAlpha = -1;
  public TextView mWarnTextView;
  public RelativeLayout mx;
  public ImageView oM;
  public TextView rightHighLView;
  public ImageView rightViewImg;
  public TextView rightViewText;
  
  public aqzl(arcd paramarcd)
  {
    this.jdField_a_of_type_Arcd = paramarcd;
    this.jdField_a_of_type_Arcd$a = paramarcd.jdField_a_of_type_Arcd$a;
    this.jdField_a_of_type_Arct = new arct(paramarcd);
  }
  
  private void egD()
  {
    if ((this.ap == null) || (this.rightViewImg == null)) {}
    boolean bool1;
    boolean bool2;
    do
    {
      return;
      bool1 = ahwy.a().aog();
      bool2 = this.ap.getBooleanExtra("fromAio", false);
    } while ((!bool1) || (!bool2));
    this.rightViewImg.setVisibility(8);
  }
  
  @TargetApi(11)
  public JSONObject C(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    JSONObject localJSONObject;
    for (;;)
    {
      return null;
      if (Build.VERSION.SDK_INT >= 11)
      {
        localJSONObject = new JSONObject();
        try
        {
          paramString = Uri.parse(paramString);
          Object localObject = paramString.getQueryParameterNames();
          if ((localObject != null) && (((Set)localObject).size() != 0))
          {
            localObject = ((Set)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              String str1 = (String)((Iterator)localObject).next();
              if (str1.contains("_nav_"))
              {
                String str2 = paramString.getQueryParameter(str1);
                localJSONObject.put(str1.replace("_nav_", ""), str2);
                continue;
                return paramString;
              }
            }
          }
        }
        catch (Exception paramString)
        {
          QLog.e("WebLog_SwiftIphoneTitleBarUI", 1, "getTitlebarConfig error!", paramString);
          paramString = null;
        }
      }
    }
    for (;;)
    {
      paramString = localJSONObject;
    }
  }
  
  public int Mz()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView != null)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.getChildCount())
      {
        if (((RadioButton)this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.getChildAt(i)).isChecked()) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public void Tc(boolean paramBoolean)
  {
    this.jdField_a_of_type_Arcd$a.cYF = paramBoolean;
    if ((paramBoolean) && (this.cyI != null)) {
      setTitle(this.cyI);
    }
    while ((paramBoolean) || (this.cyJ == null)) {
      return;
    }
    setTitle(this.cyJ);
  }
  
  public void Td(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Arcd$a.cYo = true;
      if (this.rightViewText != null) {
        this.rightViewText.setVisibility(8);
      }
      if (this.rightViewImg != null) {
        this.rightViewImg.setVisibility(8);
      }
      if (this.oM != null) {
        this.oM.setVisibility(8);
      }
    }
    do
    {
      return;
      if ((this.rightViewText != null) && (!TextUtils.isEmpty(this.rightViewText.getText()))) {
        this.rightViewText.setVisibility(0);
      }
      if (this.rightViewImg != null)
      {
        this.rightViewImg.setVisibility(0);
        egD();
      }
    } while (this.oM == null);
    this.oM.setVisibility(0);
  }
  
  public void Te(boolean paramBoolean)
  {
    this.cXm = paramBoolean;
  }
  
  public void Tf(boolean paramBoolean)
  {
    if ((this.cXl) && (!paramBoolean) && (this.oM != null)) {
      this.oM.setVisibility(8);
    }
    this.cXl = paramBoolean;
  }
  
  public void Tg(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Arcd.c != null)
    {
      if ((paramBoolean) && (aFY()))
      {
        this.jdField_a_of_type_Arcd.c.edY = 100;
        this.jdField_a_of_type_Arcd.c.bVS();
        this.jdField_a_of_type_Arcd.c.ye(true);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Arcd.c.ye(false);
  }
  
  public void VQ(String paramString)
  {
    if (this.rightViewText != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        break label70;
      }
      this.rightViewText.setText(paramString);
    }
    for (;;)
    {
      this.rightViewText.setVisibility(0);
      this.rightViewText.bringToFront();
      if (this.rightViewImg != null)
      {
        this.rightViewImg.setImageResource(0);
        this.rightViewImg.setBackgroundColor(0);
        this.rightViewImg.setVisibility(8);
      }
      return;
      label70:
      this.rightViewText.setText(2131721059);
    }
  }
  
  public void VR(String paramString)
  {
    this.cyK = paramString;
    paramString = this.jdField_a_of_type_Arcd.a();
    if ((paramString != null) && (!this.cXn))
    {
      paramString.setOnScrollChangedListenerForBiz(this.c);
      this.cXn = true;
    }
  }
  
  public void Yg(int paramInt)
  {
    if (aFY())
    {
      View localView = this.Jq.findViewById(2131371722);
      localView.setBackgroundDrawable(aqhu.d(localView.getBackground(), paramInt));
    }
  }
  
  public void Yh(int paramInt)
  {
    this.centerView.setTextColor(paramInt);
  }
  
  public void Yi(int paramInt)
  {
    this.edQ = paramInt;
  }
  
  public void Yj(int paramInt)
  {
    int i = this.leftView.getCurrentTextColor();
    if ((i != paramInt) && (!this.cXm))
    {
      Te(true);
      Yi(i);
    }
    this.leftView.setTextColor(paramInt);
    this.rightViewText.setTextColor(paramInt);
    if ((this.d != null) && (this.d.getVisibility() == 0))
    {
      localDrawable1 = aqhu.d(this.d.getDrawable(), paramInt);
      if (localDrawable1 != null) {
        this.d.setImageDrawable(localDrawable1);
      }
    }
    Drawable localDrawable2 = this.leftView.getBackground();
    Drawable localDrawable1 = this.rightViewImg.getDrawable();
    if (localDrawable2 != null)
    {
      if (!this.aMV)
      {
        this.fV = localDrawable2;
        this.aMV = true;
      }
      localDrawable2 = aqhu.d(localDrawable2, paramInt);
      if (localDrawable2 != null) {
        this.leftView.setBackgroundDrawable(localDrawable2);
      }
    }
    if (localDrawable1 != null)
    {
      if (!this.aMW) {
        this.aMW = true;
      }
      localDrawable1 = aqhu.d(localDrawable1, paramInt);
      if (localDrawable1 != null)
      {
        this.rightViewImg.setImageDrawable(localDrawable1);
        Yg(paramInt);
      }
    }
    this.rightViewImg.setColorFilter(paramInt);
  }
  
  public void Yk(int paramInt)
  {
    this.jdField_a_of_type_Arcd$a.eet = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setSelectedTab(paramInt);
    }
  }
  
  public void a(int paramInt1, Drawable paramDrawable, int paramInt2)
  {
    Object localObject4 = null;
    Drawable[] arrayOfDrawable = this.centerView.getCompoundDrawables();
    Object localObject3 = arrayOfDrawable[0];
    Drawable localDrawable = arrayOfDrawable[1];
    Object localObject2 = arrayOfDrawable[2];
    Object localObject1 = arrayOfDrawable[3];
    switch (paramInt1)
    {
    default: 
      paramDrawable = (Drawable)localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
    for (;;)
    {
      if ((localObject2 != arrayOfDrawable[0]) || (localDrawable != arrayOfDrawable[1]) || (localObject1 != arrayOfDrawable[2]) || (paramDrawable != arrayOfDrawable[3]))
      {
        this.centerView.setCompoundDrawables((Drawable)localObject2, localDrawable, (Drawable)localObject1, paramDrawable);
        this.centerView.setCompoundDrawablePadding(paramInt2);
        this.centerView.setGravity(17);
      }
      return;
      if (paramDrawable != null)
      {
        paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
        if (localObject2 == null)
        {
          localObject2 = new ColorDrawable(0);
          ((Drawable)localObject2).setBounds(paramDrawable.getBounds());
          localObject3 = localObject1;
          localObject1 = localObject2;
          localObject2 = paramDrawable;
          paramDrawable = (Drawable)localObject3;
          continue;
        }
        if ((localObject2 instanceof ColorDrawable))
        {
          ((Drawable)localObject2).setBounds(paramDrawable.getBounds());
          localObject3 = localObject1;
          localObject1 = localObject2;
          localObject2 = paramDrawable;
          paramDrawable = (Drawable)localObject3;
        }
      }
      else if ((localObject2 instanceof ColorDrawable))
      {
        localObject3 = localObject1;
        localObject1 = null;
        localObject2 = paramDrawable;
        paramDrawable = (Drawable)localObject3;
        continue;
        if (paramDrawable != null)
        {
          paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
          localDrawable = paramDrawable;
          paramDrawable = (Drawable)localObject1;
          localObject1 = localObject2;
          localObject2 = localObject3;
          continue;
          if (paramDrawable != null)
          {
            paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
            if (localObject3 == null)
            {
              localObject2 = new ColorDrawable(0);
              ((Drawable)localObject2).setBounds(paramDrawable.getBounds());
              localObject3 = localObject1;
              localObject1 = paramDrawable;
              paramDrawable = (Drawable)localObject3;
              continue;
            }
            if ((localObject3 instanceof ColorDrawable))
            {
              ((Drawable)localObject3).setBounds(paramDrawable.getBounds());
              localObject2 = localObject3;
              localObject3 = paramDrawable;
              paramDrawable = (Drawable)localObject1;
              localObject1 = localObject3;
            }
          }
          else if ((localObject3 instanceof ColorDrawable))
          {
            localObject3 = localObject1;
            localObject1 = paramDrawable;
            localObject2 = localObject4;
            paramDrawable = (Drawable)localObject3;
            continue;
            if (paramDrawable != null) {
              paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
            }
            localObject1 = localObject2;
            localObject2 = localObject3;
            continue;
          }
          localObject2 = localObject3;
          localObject3 = paramDrawable;
          paramDrawable = (Drawable)localObject1;
          localObject1 = localObject3;
          continue;
        }
        localDrawable = paramDrawable;
        paramDrawable = (Drawable)localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
      }
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = paramDrawable;
      paramDrawable = (Drawable)localObject3;
    }
  }
  
  public final void a(Intent paramIntent, View.OnClickListener paramOnClickListener)
  {
    LayoutInflater.from(this.jdField_a_of_type_Arcd.mRootView.getContext()).inflate(2131558797, this.jdField_a_of_type_Arcd.mRootView);
    this.ap = paramIntent;
    this.aK = ((ViewGroup)this.jdField_a_of_type_Arcd.mRootView.findViewById(2131377361));
    setLayerType(this.aK);
    this.Jq = this.aK.findViewById(2131377523);
    this.Jq.setVisibility(8);
    this.Jq.setPadding(0, -aqnm.dpToPx(12.0F), 0, 0);
    this.leftView = ((TextView)this.aK.findViewById(2131369579));
    this.leftView.setOnClickListener(paramOnClickListener);
    setLayerType(this.leftView);
    if (AppSetting.enableTalkBack) {
      aqcl.changeAccessibilityForView(this.leftView, Button.class.getName());
    }
    if (paramIntent.getBooleanExtra("hide_title_left_arrow", false)) {
      this.leftView.setBackgroundDrawable(null);
    }
    this.d = ((FadeIconImageView)this.aK.findViewById(2131369582));
    this.d.setOnClickListener(paramOnClickListener);
    this.d.setContentDescription(BaseApplicationImpl.getApplication().getResources().getString(2131690108));
    setLeftViewName(paramIntent);
    this.centerView = ((TextView)this.aK.findViewById(2131369627));
    this.mx = ((RelativeLayout)this.aK.findViewById(2131377503));
    this.rightViewText = ((TextView)this.aK.findViewById(2131369612));
    this.rightViewImg = ((ImageView)this.aK.findViewById(2131369594));
    setLayerType(this.rightViewText);
    setLayerType(this.rightViewImg);
    this.rightViewText.setOnClickListener(paramOnClickListener);
    this.rightViewImg.setOnClickListener(paramOnClickListener);
    this.Jo = this.jdField_a_of_type_Arcd.mRootView.findViewById(2131379950);
    this.Fr = ((ImageView)this.Jo.findViewById(2131379948));
    this.mWarnTextView = ((TextView)this.Jo.findViewById(2131379951));
    this.Jp = this.Jo.findViewById(2131379946);
    this.Jp.setOnClickListener(new aqzo(this));
    this.eM = ((ViewGroup)this.aK.findViewById(2131379823));
    removeWebViewLayerType();
    VR(this.cyK);
    bkY();
  }
  
  public void a(aqzl.a parama)
  {
    int i = -1;
    if (parama != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView = new WebViewTopTabView(BaseApplicationImpl.getContext());
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setButtonNum(parama.edW, parama.mIndex);
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setButtonText(parama.ih);
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setButtonBackgroundResource(2130851906, 2130851907, 2130851908);
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setButtonTextColorStateList(2131167643);
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setLeftAndRightPaddingByDp(10);
      Tc(this.jdField_a_of_type_Arcd$a.cYF);
    }
    try
    {
      this.mx.removeAllViews();
      this.mx.addView(this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView, new RelativeLayout.LayoutParams(-2, -1));
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setOnCheckedChangeListener(new aqzr(this));
      if (this.jdField_a_of_type_Arct != null) {
        this.jdField_a_of_type_Arct.dq(parama.cyL, true);
      }
      localTouchWebView = this.jdField_a_of_type_Arcd.a();
      if ((localTouchWebView != null) && (!TextUtils.isEmpty(parama.mCallbackId)))
      {
        str = "ok";
        if (!TextUtils.isEmpty(parama.cyL)) {
          break label263;
        }
        str = "the subTabCallback isEmpty";
        localJSONObject = new JSONObject();
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          TouchWebView localTouchWebView;
          String str;
          JSONObject localJSONObject;
          localJSONObject.put("code", i);
          localJSONObject.put("message", str);
          localTouchWebView.callJs(parama.mCallbackId, new String[] { localJSONObject.toString() });
          return;
          localException1 = localException1;
          localException1.printStackTrace();
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          continue;
        }
        label263:
        i = 0;
      }
    }
  }
  
  public void a(aqzl.b paramb)
  {
    Object localObject1;
    Object localObject2;
    boolean bool;
    if ((paramb != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView != null))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView;
      localObject2 = paramb.pf;
      if (paramb.mFlag != 1) {
        break label56;
      }
      bool = true;
      ((WebViewTopTabView)localObject1).setRedHotStatus((int[])localObject2, bool);
      localObject2 = this.jdField_a_of_type_Arcd.a();
      if (localObject2 != null) {
        break label61;
      }
    }
    for (;;)
    {
      return;
      label56:
      bool = false;
      break;
      label61:
      localObject1 = "OK";
      JSONObject localJSONObject = new JSONObject();
      Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.ai();
      int i;
      if ((localObject3 == null) || (localObject3.length == 0))
      {
        i = -2;
        localObject1 = "sub tab num is error";
        localObject3 = new JSONObject();
      }
      try
      {
        for (;;)
        {
          ((JSONObject)localObject3).put("code", i);
          ((JSONObject)localObject3).put("message", localObject1);
          ((JSONObject)localObject3).put("data", localJSONObject);
          if (TextUtils.isEmpty(paramb.mCallbackId)) {
            break;
          }
          ((TouchWebView)localObject2).callJs(paramb.mCallbackId, new String[] { ((JSONObject)localObject3).toString() });
          return;
          try
          {
            JSONArray localJSONArray = new JSONArray();
            i = 0;
            while (i < localObject3.length)
            {
              localJSONArray.put(localObject3[i]);
              i += 1;
            }
            localJSONObject.put("tabsStatus", localJSONArray);
            if (QLog.isColorLevel()) {
              QLog.i("WebLog_SwiftIphoneTitleBarUI", 2, "tabsStatusArray = " + localJSONArray.toString());
            }
            i = 0;
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
            i = -3;
            String str = "construction json error";
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public void a(TouchWebView paramTouchWebView, boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean2, String paramString1, String paramString2, String paramString3)
  {
    if (paramTouchWebView == null) {}
    do
    {
      return;
      if (!this.cXn)
      {
        paramTouchWebView.setOnScrollChangedListenerForBiz(this.c);
        this.cXn = true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_SwiftIphoneTitleBarUI", 2, "setTitleBarScrollChange:" + paramBoolean1 + ", @" + paramInt1 + ", from " + paramInt2 + " to " + paramInt3 + ", " + paramBoolean2 + ", Before: " + paramString1 + ", After: " + paramString2);
      }
      this.cXo = paramBoolean1;
      BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
      this.edS = ((int)(paramInt1 * localBaseApplicationImpl.getResources().getDisplayMetrics().density + 0.5F));
      this.edT = paramInt2;
      this.edU = paramInt3;
      this.aG = new aqnc(Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), this.b);
      this.aG.setDuration(300L);
      this.aG.setInterpolator(localBaseApplicationImpl, 17432581);
      this.aH = new aqnc(Integer.valueOf(paramInt3), Integer.valueOf(paramInt2), this.b);
      this.aH.setDuration(300L);
      this.aH.setInterpolator(localBaseApplicationImpl, 17432581);
      this.cXp = paramBoolean2;
      this.cyI = paramString1;
      this.cyJ = paramString2;
      this.mTitleAlpha = -1;
      cg(this.edR, false);
    } while (TextUtils.isEmpty(paramString3));
    paramString1 = new JSONObject();
    try
    {
      paramString1.put("result", 0);
      paramString1.put("message", "ok");
      label332:
      paramTouchWebView.callJs(paramString3, new String[] { paramString1.toString() });
      return;
    }
    catch (Exception paramString2)
    {
      break label332;
    }
  }
  
  public void a(WebView paramWebView, String paramString, boolean paramBoolean)
  {
    if ((this.aK == null) || (this.jdField_a_of_type_Arcd$a.isFullScreen)) {}
    do
    {
      return;
      localObject = (RelativeLayout)this.eM.findViewById(2131379823);
    } while (localObject == null);
    paramWebView = (TextView)((RelativeLayout)localObject).findViewById(2131379865);
    Object localObject = (TextView)((RelativeLayout)localObject).findViewById(2131379802);
    if (paramBoolean)
    {
      new Handler(Looper.getMainLooper()).postDelayed(new SwiftIphoneTitleBarUI.6(this, (TextView)localObject, paramWebView, paramString), 50L);
      return;
    }
    if (!TextUtils.isEmpty(((TextView)localObject).getText().toString()))
    {
      paramWebView.setText(paramString);
      return;
    }
    setTitle(paramString);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, JsBridgeListener paramJsBridgeListener, View.OnClickListener paramOnClickListener, tzd paramtzd)
  {
    if ((paramJsBridgeListener != null) && (paramJsBridgeListener.cXk)) {}
    for (int i = 1; paramBoolean; i = 0)
    {
      this.jdField_a_of_type_Arcd$a.cYo = true;
      this.rightViewText.setVisibility(8);
      this.rightViewImg.setVisibility(8);
      if (this.oM != null) {
        this.oM.setVisibility(8);
      }
      Tg(false);
      return;
    }
    if ((this.ap != null) && (this.ap.getIntExtra("reqType", -1) == 7))
    {
      this.rightViewText.setVisibility(8);
      this.rightViewImg.setVisibility(8);
      return;
    }
    if (aFY()) {
      Tg(true);
    }
    for (;;)
    {
      if (paramInt1 == 0)
      {
        if (!TextUtils.isEmpty(paramString2))
        {
          this.rightViewText.setText(paramString2);
          this.rightViewText.setVisibility(0);
          this.rightViewText.bringToFront();
          this.rightViewImg.setImageResource(0);
          this.rightViewImg.setBackgroundColor(0);
          this.rightViewImg.setVisibility(8);
        }
        if (paramString3 != null)
        {
          paramInt1 = 0;
          if (paramString3.length() <= 0) {}
        }
        try
        {
          paramInt1 = Color.parseColor(paramString3);
          this.rightViewImg.setBackgroundColor(paramInt1);
          if ((paramString1 != null) && (i == 0))
          {
            this.GY = paramString1.trim();
            if (this.jdField_a_of_type_Arcd$a.ce.has("txtclr"))
            {
              paramString2 = this.jdField_a_of_type_Arcd$a.ce.optString("txtclr", "");
              if (!TextUtils.isEmpty(paramString2))
              {
                paramString1 = paramString2;
                if (!paramString2.startsWith("#")) {
                  paramString1 = "#" + paramString2;
                }
              }
            }
          }
          try
          {
            paramInt1 = Color.parseColor(paramString1);
            paramString1 = aqhu.d(this.rightViewImg.getDrawable(), paramInt1);
            if (paramString1 != null)
            {
              this.rightViewImg.setImageDrawable(paramString1);
              Yg(paramInt1);
            }
          }
          catch (Exception paramString1)
          {
            for (;;)
            {
              QLog.e("WebLog_SwiftIphoneTitleBarUI", 1, paramString1, new Object[0]);
            }
          }
          Tc(this.jdField_a_of_type_Arcd$a.cYF);
          return;
          Tg(false);
        }
        catch (Exception paramString2)
        {
          for (;;)
          {
            paramInt1 = 0;
            continue;
            if (paramtzd != null)
            {
              this.h = paramtzd;
            }
            else
            {
              this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener = paramJsBridgeListener;
              this.GY = null;
            }
          }
        }
      }
    }
    this.rightViewText.setVisibility(8);
    if ((this.jdField_a_of_type_Arcd.c == null) || (!(this.jdField_a_of_type_Arcd.c instanceof TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment)))
    {
      this.rightViewImg.setVisibility(0);
      egD();
    }
    paramString3 = this.jdField_a_of_type_Arcd$a;
    if (paramInt1 != 4)
    {
      paramBoolean = true;
      label457:
      paramString3.cYo = paramBoolean;
      switch (paramInt1)
      {
      default: 
        this.rightViewImg.setVisibility(8);
        label597:
        paramInt1 = paramInt2;
        if (paramInt2 == 0)
        {
          paramInt1 = paramInt2;
          if (this.cXl) {
            paramInt1 = 10000;
          }
        }
        if (paramInt1 != 0)
        {
          if (this.oM == null)
          {
            this.oM = new ImageView(BaseApplicationImpl.getApplication());
            paramString3 = (RelativeLayout)this.aK.findViewById(2131377502);
            paramString3 = new RelativeLayout.LayoutParams(-2, -2);
            paramString3.addRule(7, 2131369594);
            paramString3.addRule(6, 2131369594);
            paramString3.setMargins(0, 0, 0, 0);
            this.oM.setLayoutParams(paramString3);
            if ((this.rightViewImg.getParent() instanceof RelativeLayout)) {
              ((RelativeLayout)this.rightViewImg.getParent()).addView(this.oM);
            }
          }
          this.oM.setVisibility(0);
          switch (paramInt1)
          {
          default: 
            this.oM.setVisibility(8);
            label785:
            if (!TextUtils.isEmpty(paramString2)) {
              this.rightViewImg.setContentDescription(paramString2);
            }
            if (paramOnClickListener != null) {
              this.rightViewImg.setOnClickListener(paramOnClickListener);
            }
            break;
          }
        }
        break;
      }
    }
    for (;;)
    {
      this.aMV = false;
      this.aMW = false;
      break;
      paramBoolean = false;
      break label457;
      this.jdField_a_of_type_Arcd.a(this.rightViewImg, false, 2130844671, 2130844670);
      this.rightViewImg.setImageDrawable(aqhu.d(this.rightViewImg.getResources().getDrawable(2130844671), this.rightViewImg.getResources().getColor(2131167301)));
      this.rightViewImg.setContentDescription(BaseApplicationImpl.getApplication().getResources().getString(2131693963));
      break label597;
      this.jdField_a_of_type_Arcd.a(this.rightViewImg, false, 2130844669, 2130844669);
      this.rightViewImg.setContentDescription(BaseApplicationImpl.getApplication().getResources().getString(2131693962));
      break label597;
      this.jdField_a_of_type_Arcd.a(this.rightViewImg, false, 2130840667, 2130840667);
      this.rightViewImg.setContentDescription(BaseApplicationImpl.getApplication().getResources().getString(2131693964));
      break label597;
      this.jdField_a_of_type_Arcd.a(this.rightViewImg, false, 2130839618, 2130839618);
      this.rightViewImg.setContentDescription(BaseApplicationImpl.getApplication().getResources().getString(2131693966));
      break label597;
      this.rightViewImg.setImageResource(2130844714);
      this.rightViewImg.setContentDescription(BaseApplicationImpl.getApplication().getResources().getString(2131693968));
      ((AnimationDrawable)this.rightViewImg.getDrawable()).start();
      break label597;
      this.jdField_a_of_type_Arcd.a(this.rightViewImg, false, 2130843364, 2130843367);
      this.rightViewImg.setContentDescription(BaseApplicationImpl.getApplication().getResources().getString(2131721053));
      break label597;
      this.jdField_a_of_type_Arcd.a(this.rightViewImg, false, 2130851141, 2130851145);
      this.rightViewImg.setContentDescription(BaseApplicationImpl.getApplication().getResources().getString(2131721053));
      break label597;
      this.jdField_a_of_type_Arcd.a(this.rightViewImg, false, 2130838993, 2130838993);
      this.rightViewImg.setContentDescription(BaseApplicationImpl.getApplication().getResources().getString(2131693965));
      break label597;
      this.jdField_a_of_type_Arcd.a(this.rightViewImg, false, 2130851313, 2130851313);
      this.rightViewImg.setContentDescription(BaseApplicationImpl.getApplication().getResources().getString(2131693965));
      break label597;
      this.jdField_a_of_type_Arcd.a(this.rightViewImg, false, 2130847226, 2130847225);
      this.rightViewImg.setContentDescription(BaseApplicationImpl.getApplication().getResources().getString(2131693965));
      break label597;
      paramString3 = URLDrawable.getDrawable(QzoneConfig.getInstance().getConfig("QZoneSetting", "sweetIconRUL", "https://qzonestyle.gtimg.cn/aoi/sola/20170905110724_aew14oIQKq.png"), null);
      if (paramString3 == null) {
        break label597;
      }
      this.rightViewImg.setBackgroundDrawable(paramString3);
      paramString3 = (RelativeLayout)this.aK.findViewById(2131377502);
      if (paramString3 == null) {
        break label597;
      }
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramString3.getLayoutParams();
      localLayoutParams.rightMargin = aqnm.dpToPx(10.0F);
      paramString3.setLayoutParams(localLayoutParams);
      break label597;
      this.jdField_a_of_type_Arcd.a(this.rightViewImg, false, 2130840667, 2130840667);
      this.rightViewImg.setContentDescription(BaseApplicationImpl.getApplication().getResources().getString(2131719875));
      break label597;
      this.oM.setImageResource(2130844492);
      break label785;
      this.oM.setImageResource(2130851400);
      break label785;
      if (this.oM == null) {
        break label785;
      }
      this.oM.setVisibility(8);
      break label785;
      if ((paramString1 != null) && (i == 0))
      {
        this.GY = paramString1.trim();
      }
      else if (paramtzd != null)
      {
        this.h = paramtzd;
      }
      else
      {
        this.GY = null;
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener = paramJsBridgeListener;
      }
    }
  }
  
  @TargetApi(17)
  public boolean aFX()
  {
    if ((!this.jdField_a_of_type_Arcd.jdField_a_of_type_Arcd$a.cYl) && (!this.jdField_a_of_type_Arcd$a.cYw) && (this.aK != null) && (this.jdField_a_of_type_Arcd.mRootView != null) && (Build.VERSION.SDK_INT >= 17))
    {
      Object localObject1 = (TextView)this.jdField_a_of_type_Arcd.mRootView.findViewById(2131363733);
      if (localObject1 != null)
      {
        localObject2 = (LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
        if (localObject2 != null)
        {
          ((LinearLayout.LayoutParams)localObject2).topMargin -= ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication());
          ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
      }
      localObject1 = this.jdField_a_of_type_Arcd.mRootView.findViewById(2131382187);
      Object localObject2 = (FrameLayout.LayoutParams)((View)localObject1).getLayoutParams();
      if (localObject2 != null)
      {
        ((FrameLayout.LayoutParams)localObject2).topMargin -= BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299634);
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      return true;
    }
    return false;
  }
  
  public boolean aFY()
  {
    if ((this.jdField_a_of_type_Arcd.a() == null) || (this.jdField_a_of_type_Arcd.a().getPluginEngine() == null)) {}
    WebViewPlugin localWebViewPlugin;
    do
    {
      return false;
      localWebViewPlugin = this.jdField_a_of_type_Arcd.a().getPluginEngine().a(45, false);
    } while (((localWebViewPlugin instanceof UiApiPlugin)) && (((UiApiPlugin)localWebViewPlugin).ckC));
    if ((this.jdField_a_of_type_Arcd$a.cYN) || (this.jdField_a_of_type_Arcd$a.cYO)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean aFZ()
  {
    return cA().getVisibility() == 0;
  }
  
  public boolean bB(boolean paramBoolean)
  {
    int i = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView == null) {
      return false;
    }
    WebViewTopTabView localWebViewTopTabView = this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView;
    if (paramBoolean) {}
    for (;;)
    {
      localWebViewTopTabView.setVisibility(i);
      return true;
      i = 8;
    }
  }
  
  public boolean bC(boolean paramBoolean)
  {
    if (this.aK == null) {
      return false;
    }
    if (paramBoolean)
    {
      this.mTitleAlpha = -1;
      cg(this.edR, this.cXp);
      this.aK.setVisibility(0);
      if (!this.jdField_a_of_type_Arcd.jdField_a_of_type_Arcd$a.isFullScreen) {
        this.jdField_a_of_type_Arcd.s.getWindow().clearFlags(1024);
      }
    }
    for (;;)
    {
      return true;
      dx(0);
      this.aK.setVisibility(8);
      this.jdField_a_of_type_Arcd.s.getWindow().addFlags(1024);
    }
  }
  
  public void bkY() {}
  
  public void bkZ()
  {
    if (this.jdField_a_of_type_Arcd$a.aYy)
    {
      if ((!this.jdField_a_of_type_Arcd$a.cYl) && (!this.jdField_a_of_type_Arcd$a.cYw))
      {
        Resources localResources = this.jdField_a_of_type_Arcd.s.getResources();
        this.aK.setBackgroundColor(localResources.getColor(2131167563));
        if ((this.jdField_a_of_type_Arcd.c != null) && (this.jdField_a_of_type_Arcd.c.Js != null)) {
          this.jdField_a_of_type_Arcd.c.Js.setBackgroundColor(0);
        }
      }
      this.leftView.setTextColor(-1);
      this.rightViewText.setTextColor(-1);
      this.centerView.setTextColor(-1);
      this.jdField_a_of_type_Arcd.a(this.leftView, true, 2130851119, 2130851758);
      this.jdField_a_of_type_Arcd.a(this.rightViewImg, false, 2130840667, 2130840663);
    }
  }
  
  public void bla() {}
  
  public void bn(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      this.leftView.setVisibility(4);
      if ((paramString2 != null) && (paramString2.length() != 0)) {
        break label98;
      }
      this.rightViewText.setVisibility(8);
      label39:
      if (TextUtils.isEmpty(paramString3)) {
        break label126;
      }
    }
    for (;;)
    {
      setTitle(paramString3);
      return;
      this.leftView.setVisibility(0);
      if (!arcp.aGj())
      {
        this.leftView.setText(paramString1);
        break;
      }
      if (this.leftView.getBackground() != null) {
        break;
      }
      this.leftView.setText(paramString1);
      break;
      label98:
      this.rightViewText.setText(paramString2);
      this.rightViewText.setVisibility(0);
      this.rightViewImg.setVisibility(8);
      break label39;
      label126:
      paramString3 = "";
    }
  }
  
  public void c(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (this.Jo != null)
    {
      if (paramBoolean)
      {
        paramInt1 = QQToast.getIconRes(paramInt1);
        this.Fr.setImageDrawable(this.Jo.getResources().getDrawable(paramInt1));
        this.mWarnTextView.setText(this.Jo.getResources().getString(paramInt2));
        this.Jo.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.Jo.setVisibility(8);
  }
  
  public View cA()
  {
    return this.Jq;
  }
  
  void cg(int paramInt, boolean paramBoolean)
  {
    Object localObject2;
    Object localObject1;
    if (this.cXo)
    {
      localObject2 = null;
      if ((paramInt < this.edS) || (!this.jdField_a_of_type_Arcd$a.cYF)) {
        break label94;
      }
      this.jdField_a_of_type_Arcd$a.cYF = false;
      if (!paramBoolean) {
        break label80;
      }
      localObject1 = this.aG;
    }
    for (;;)
    {
      if ((this.aK != null) && (localObject1 != null) && (localObject1 != this.aK.getAnimation()))
      {
        ((Animation)localObject1).reset();
        this.aK.startAnimation((Animation)localObject1);
      }
      return;
      label80:
      dx(this.edU);
      localObject1 = localObject2;
      continue;
      label94:
      localObject1 = localObject2;
      if (paramInt < this.edS)
      {
        localObject1 = localObject2;
        if (!this.jdField_a_of_type_Arcd$a.cYF)
        {
          this.jdField_a_of_type_Arcd$a.cYF = true;
          if (paramBoolean)
          {
            localObject1 = this.aH;
          }
          else
          {
            dx(this.edT);
            localObject1 = localObject2;
          }
        }
      }
    }
  }
  
  public void d(Intent paramIntent, String paramString)
  {
    int k = 2;
    String[] arrayOfString = null;
    int j = 0;
    if ((paramIntent == null) || (TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_Arcd$a.isFullScreen)) {
      return;
    }
    Object localObject;
    if ((this.jdField_a_of_type_Arcd$a.gK & 0x4) == 0L)
    {
      if (!arcp.aGj()) {
        this.leftView.setText(BaseApplicationImpl.getApplication().getResources().getString(2131691039));
      }
    }
    else
    {
      if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("youxi.vip.qq.com/imoj"))) {
        paramIntent.putExtra("isScreenOrientationPortrait", true);
      }
      localObject = paramIntent.getStringExtra("title");
      this.jdField_a_of_type_Arcd$a.cYt = paramIntent.getBooleanExtra("ishiderefresh", false);
      this.jdField_a_of_type_Arcd$a.cYu = paramIntent.getBooleanExtra("ishidebackforward", false);
      boolean bool = paramIntent.getBooleanExtra("hide_left_button", false);
      this.jdField_a_of_type_Arcd$a.cYv = paramIntent.getBooleanExtra("show_right_close_button", false);
      if (QLog.isColorLevel()) {
        QLog.d("QQBrowser", 2, "QQBrowser url=" + jqo.filterKeyForLog(paramString, new String[0]));
      }
      if ((localObject == null) || (((String)localObject).length() <= 0)) {
        break label688;
      }
      this.centerView.setText((CharSequence)localObject);
      label224:
      this.rightViewImg.setContentDescription(BaseApplicationImpl.getApplication().getResources().getString(2131691021));
      if (!this.jdField_a_of_type_Arcd$a.cYo)
      {
        this.rightViewImg.setVisibility(0);
        localObject = this.rightViewImg.getResources().getDrawable(2130840667);
        if ((!this.jdField_a_of_type_Arcd.jdField_a_of_type_Arcd$a.cYl) && (!this.jdField_a_of_type_Arcd$a.cYw)) {
          break label700;
        }
        paramString = aqhu.d((Drawable)localObject, -1);
        label306:
        this.rightViewImg.setImageDrawable(paramString);
        this.rightViewImg.setContentDescription(BaseApplicationImpl.getApplication().getResources().getString(2131693966));
        egD();
      }
      if (aFY())
      {
        if ((!this.jdField_a_of_type_Arcd.jdField_a_of_type_Arcd$a.cYl) && (!this.jdField_a_of_type_Arcd$a.cYw)) {
          break label732;
        }
        Yg(-1);
      }
      label372:
      if (bool) {
        this.leftView.setVisibility(4);
      }
      if (ImmersiveUtils.isSupporImmersive() != 1) {
        break label857;
      }
    }
    label688:
    label700:
    label844:
    label857:
    for (int i = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_Arcd.s) + 0;; i = 0)
    {
      for (;;)
      {
        int m = View.MeasureSpec.makeMeasureSpec(0, 0);
        int n = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.aK.measure(m, n);
        i += this.aK.getMeasuredHeight();
        if (this.jdField_a_of_type_Arcd$a.cYz)
        {
          m = this.aK.getTop();
          n = this.aK.getBottom();
          this.aK.layout(this.aK.getLeft(), m - i, this.aK.getRight(), n - i);
          this.aK.setVisibility(8);
          label506:
          if (this.jdField_a_of_type_Arcd$a.cYv) {
            VQ(paramIntent.getStringExtra("left_close_button_text"));
          }
          if (TextUtils.isEmpty(this.jdField_a_of_type_Arcd$a.czz)) {
            break label844;
          }
        }
        try
        {
          paramIntent = new JSONObject(URLDecoder.decode(this.jdField_a_of_type_Arcd$a.czz));
          i = k;
          if (paramIntent.has("tabNum")) {
            i = paramIntent.getInt("tabNum");
          }
          if (paramIntent.has("subTextArray")) {}
          for (paramIntent = paramIntent.getJSONArray("subTextArray");; paramIntent = null)
          {
            paramString = arrayOfString;
            if (paramIntent == null) {
              break label822;
            }
            paramString = arrayOfString;
            if (paramIntent.length() <= 0) {
              break label822;
            }
            arrayOfString = new String[paramIntent.length()];
            for (;;)
            {
              paramString = arrayOfString;
              if (j >= paramIntent.length()) {
                break;
              }
              arrayOfString[j] = paramIntent.getString(j);
              j += 1;
            }
            if (!paramIntent.getBooleanExtra("hide_title_left_arrow", false)) {
              break;
            }
            this.leftView.setText(BaseApplicationImpl.getApplication().getResources().getString(2131691039));
            break;
            this.centerView.setText("");
            break label224;
            paramString = (String)localObject;
            if (this.jdField_a_of_type_Arcd$a.a == null) {
              break label306;
            }
            paramString = aqhu.d((Drawable)localObject, this.jdField_a_of_type_Arcd$a.a.edP);
            break label306;
            label732:
            if (this.jdField_a_of_type_Arcd$a.a == null) {
              break label372;
            }
            Yg(this.jdField_a_of_type_Arcd$a.a.edP);
            break label372;
            m = this.aK.getTop();
            n = this.aK.getBottom();
            this.aK.layout(this.aK.getLeft(), m + i, this.aK.getRight(), i + n);
            this.aK.setVisibility(0);
            break label506;
          }
          a(new aqzl.a(this.jdField_a_of_type_Arcd$a.eet, i, null, null, paramString));
        }
        catch (JSONException paramIntent)
        {
          for (;;)
          {
            paramIntent.printStackTrace();
          }
        }
      }
      bla();
      return;
    }
  }
  
  public void d(JSONObject paramJSONObject, boolean paramBoolean)
  {
    int j = -1;
    int k = 0;
    if (paramJSONObject != null) {}
    try
    {
      if ((paramJSONObject.length() > 0) && (!this.jdField_a_of_type_Arcd$a.cYG))
      {
        this.jdField_a_of_type_Arcd$a.cYG = aFX();
        if ((this.jdField_a_of_type_Arcd$a.cYL) && (this.jdField_a_of_type_Arcd.eG != null)) {
          this.jdField_a_of_type_Arcd.eG.setPadding(0, (int)aqho.convertDpToPixel(BaseApplicationImpl.getApplication(), 30.0F), 0, 0);
        }
      }
      if (paramJSONObject == null) {
        return;
      }
      if (!this.jdField_a_of_type_Arcd$a.cYG) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_SwiftIphoneTitleBarUI", 2, "titlebar config:" + paramJSONObject.toString());
      }
      localViewGroup = this.aK;
      if (localViewGroup == null) {
        return;
      }
      if (!paramBoolean) {
        break label656;
      }
      localObject2 = paramJSONObject.optString("bgclr", "");
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label795;
      }
      localObject1 = localObject2;
      if (!((String)localObject2).startsWith("#")) {
        localObject1 = "#" + (String)localObject2;
      }
      i = Color.parseColor((String)localObject1);
    }
    catch (Exception paramJSONObject)
    {
      ViewGroup localViewGroup;
      Object localObject2;
      Object localObject1;
      int i;
      label656:
      while (QLog.isColorLevel())
      {
        QLog.d("WebLog_SwiftIphoneTitleBarUI", 2, "game center,doTransparent error:" + paramJSONObject.toString());
        return;
        localViewGroup.getBackground().mutate().setAlpha(j);
        this.jdField_a_of_type_Arcd$a.bPY = j;
        return;
        continue;
        i = -1;
        continue;
        localObject1 = localObject2;
        continue;
        label795:
        localObject1 = localObject2;
        i = -1;
      }
    }
    localViewGroup.setBackgroundColor(i);
    if ((this.jdField_a_of_type_Arcd.c != null) && (this.jdField_a_of_type_Arcd.c.Js != null))
    {
      localObject2 = paramJSONObject.optString("statusclr", "");
      i = k;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        if (!((String)localObject2).startsWith("#"))
        {
          localObject1 = "#" + (String)localObject1;
          i = Color.parseColor((String)localObject1);
        }
      }
      else
      {
        this.jdField_a_of_type_Arcd.c.Js.setBackgroundColor(i);
        anlm.a(true, i, this.jdField_a_of_type_Arcd.s.getWindow());
      }
    }
    else
    {
      localObject2 = paramJSONObject.optString("txtclr", "");
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = localObject2;
        if (!((String)localObject2).startsWith("#")) {
          localObject1 = "#" + (String)localObject2;
        }
        i = Color.parseColor((String)localObject1);
        this.leftView.setTextColor(i);
        if ((this.d != null) && (this.d.getVisibility() == 0))
        {
          localObject1 = aqhu.d(this.d.getDrawable(), i);
          if (localObject1 != null) {
            this.d.setImageDrawable((Drawable)localObject1);
          }
        }
        this.rightViewText.setTextColor(i);
        localObject1 = aqhu.d(this.leftView.getBackground(), i);
        if (localObject1 != null) {
          this.leftView.setBackgroundDrawable((Drawable)localObject1);
        }
        localObject1 = aqhu.d(this.rightViewImg.getDrawable(), i);
        if (localObject1 != null)
        {
          this.rightViewImg.setImageDrawable((Drawable)localObject1);
          Yg(i);
        }
        localObject1 = this.Jq.findViewById(2131371722);
        localObject2 = aqhu.d(((View)localObject1).getBackground(), i);
        if (localObject2 != null) {
          ((View)localObject1).setBackgroundDrawable((Drawable)localObject2);
        }
        localObject1 = paramJSONObject.optString("titleclr", "");
        i = j;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          if (!((String)localObject1).startsWith("#"))
          {
            localObject1 = "#" + (String)localObject1;
            i = Color.parseColor((String)localObject1);
          }
        }
        else
        {
          if ((TextUtils.isEmpty(this.centerView.getText())) && (!TextUtils.isEmpty(this.jdField_a_of_type_Arcd.cyN))) {
            this.centerView.setText(this.jdField_a_of_type_Arcd.cyN);
          }
          this.centerView.setTextColor(i);
          if (paramJSONObject.optInt("trans", -1) == 0) {
            return;
          }
          paramBoolean = paramJSONObject.optBoolean("anim", false);
          i = paramJSONObject.optInt("dur", 0);
          j = paramJSONObject.optInt("alpha", 0);
          if ((paramBoolean) && (i > 0))
          {
            h(localViewGroup, this.jdField_a_of_type_Arcd$a.bPY, j, i);
            return;
          }
        }
      }
    }
  }
  
  public void dkr()
  {
    if (this.rightViewText != null) {
      this.rightViewText.setVisibility(8);
    }
    if (this.rightViewImg != null)
    {
      this.rightViewImg.setVisibility(0);
      egD();
    }
  }
  
  public void dx(int paramInt)
  {
    if (this.aK == null) {}
    do
    {
      do
      {
        return;
      } while (paramInt == this.mTitleAlpha);
      this.mTitleAlpha = paramInt;
      paramInt = Math.max(0, Math.min(paramInt, 255));
      this.aK.getBackground().mutate().setAlpha(paramInt);
      if ((this.jdField_a_of_type_Arcd.c != null) && (this.jdField_a_of_type_Arcd.c.Js != null)) {
        this.jdField_a_of_type_Arcd.c.Js.getBackground().mutate().setAlpha(paramInt);
      }
      if (paramInt == this.edT)
      {
        Tc(true);
        return;
      }
    } while (paramInt != this.edU);
    Tc(false);
  }
  
  public void egA()
  {
    if (this.cXm)
    {
      Yj(this.edQ);
      this.cXm = false;
    }
  }
  
  public void egB()
  {
    this.leftView.setTextColor(BaseApplicationImpl.getApplication().getResources().getColorStateList(2131167298));
    this.rightViewText.setTextColor(BaseApplicationImpl.getApplication().getResources().getColorStateList(2131167298));
    this.centerView.setTextColor(BaseApplicationImpl.getApplication().getResources().getColor(2131167301));
    Object localObject;
    if (this.rightViewImg != null)
    {
      localObject = this.rightViewImg.getDrawable();
      if (localObject != null)
      {
        ((Drawable)localObject).clearColorFilter();
        ((Drawable)localObject).invalidateSelf();
      }
      this.rightViewImg.setImageDrawable((Drawable)localObject);
    }
    if (aFZ())
    {
      localObject = this.Jq.findViewById(2131371722);
      Drawable localDrawable = ((View)localObject).getBackground();
      if (localDrawable != null)
      {
        localDrawable.clearColorFilter();
        localDrawable.invalidateSelf();
      }
      ((View)localObject).setBackgroundDrawable(localDrawable);
    }
    this.leftView.setBackgroundDrawable(this.fV);
  }
  
  public void egC()
  {
    if (this.aK == null) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_Arcd$a.cYF) && (this.jdField_a_of_type_Arcd$a.cYE))
      {
        this.jdField_a_of_type_Arcd$a.cYE = false;
        this.jdField_a_of_type_Arcd$a.cYE = true;
        this.aK.setBackgroundResource(2130851925);
        this.centerView.setTextColor(-1);
        return;
      }
    } while ((this.jdField_a_of_type_Arcd$a.cYF) || (!this.jdField_a_of_type_Arcd$a.cYE));
    this.jdField_a_of_type_Arcd$a.cYE = false;
    this.jdField_a_of_type_Arcd$a.cYE = true;
    this.aK.setBackgroundColor(BaseApplicationImpl.getApplication().getResources().getColor(2131167361));
    egB();
  }
  
  public void f(TouchWebView paramTouchWebView)
  {
    ViewGroup localViewGroup = this.aK;
    if ((this.jdField_a_of_type_Arcd$a.cYC) && (localViewGroup != null) && (!this.jdField_a_of_type_Arcd$a.cYG) && (aFX()))
    {
      this.jdField_a_of_type_Arcd$a.cYG = true;
      this.jdField_a_of_type_Arcd$a.cYD = true;
      this.jdField_a_of_type_Arcd$a.cYF = true;
      localViewGroup.setBackgroundResource(2130851925);
      if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        this.rightViewImg.setBackgroundDrawable(null);
      }
      paramTouchWebView.setOnScrollChangedListenerForBiz(new aqzq(this));
    }
  }
  
  public String getTitle()
  {
    if (this.centerView == null) {
      return "";
    }
    return this.centerView.getText().toString();
  }
  
  public void h(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 0)
    {
      paramView.getBackground().mutate().setAlpha(paramInt2);
      return;
    }
    aqnc localaqnc = new aqnc(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), new aqzp(this, paramView, paramInt2));
    localaqnc.setDuration(paramInt3);
    this.jdField_a_of_type_Arcd$a.mIsAnimating = true;
    paramView.startAnimation(localaqnc);
  }
  
  public void recycle()
  {
    if (this.aG != null) {
      this.aG.setAnimationListener(null);
    }
    if (this.aH != null) {
      this.aH.setAnimationListener(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setOnCheckedChangeListener(null);
    }
  }
  
  @TargetApi(11)
  public void removeWebViewLayerType()
  {
    if (Build.VERSION.SDK_INT == 16) {
      this.aK.setLayerType(0, null);
    }
  }
  
  public void setLayerType(View paramView)
  {
    if (paramView == null) {}
    while (Build.VERSION.SDK_INT <= 10) {
      return;
    }
    paramView.setLayerType(0, null);
  }
  
  public void setLeftViewName(Intent paramIntent)
  {
    if ((this.leftView != null) && (paramIntent != null) && (paramIntent.getExtras() != null)) {
      for (;;)
      {
        boolean bool1;
        boolean bool2;
        try
        {
          String str2 = paramIntent.getExtras().getString("leftViewText");
          int i = paramIntent.getExtras().getInt("individuation_url_type");
          String str1 = str2;
          if (i >= 40300)
          {
            str1 = str2;
            if (i <= 40313)
            {
              str1 = str2;
              if (!TextUtils.isEmpty(str2))
              {
                str1 = str2;
                if (str2.contains(acfp.m(2131715093))) {
                  str1 = BaseApplicationImpl.getApplication().getString(2131691039);
                }
              }
            }
          }
          bool1 = paramIntent.getBooleanExtra("hide_left_button", false);
          bool2 = paramIntent.getBooleanExtra("fromOneCLickCLose", false);
          paramIntent = str1;
          if (str1 == null) {
            paramIntent = BaseApplicationImpl.getApplication().getString(2131691039);
          }
          if (!arcp.aGj())
          {
            this.leftView.setText(paramIntent);
            break label317;
            this.leftView.setVisibility(4);
            label166:
            if (AppSetting.enableTalkBack)
            {
              str1 = this.leftView.getText().toString();
              paramIntent = str1;
              if (!str1.contains(BaseApplicationImpl.getApplication().getString(2131691039))) {
                paramIntent = BaseApplicationImpl.getApplication().getString(2131691039) + str1;
              }
              this.leftView.setContentDescription(paramIntent);
            }
            if (this.d == null) {
              break;
            }
            if (bool2) {
              this.d.setVisibility(0);
            }
          }
          else
          {
            if (this.leftView.getBackground() != null) {
              break label317;
            }
            this.leftView.setText(paramIntent);
          }
        }
        catch (Exception paramIntent)
        {
          QLog.e("WebLog_SwiftIphoneTitleBarUI", 1, "setLeftViewName exception e = ", paramIntent);
          return;
        }
        label317:
        do
        {
          this.leftView.setVisibility(0);
          break label166;
          this.d.setVisibility(8);
          return;
          if (bool1) {
            break;
          }
        } while (!bool2);
      }
    }
  }
  
  @TargetApi(11)
  public void setRightViewTextDisable(int paramInt)
  {
    if (paramInt == 0)
    {
      this.rightViewText.setEnabled(false);
      if (Build.VERSION.SDK_INT >= 11) {
        this.rightViewText.setAlpha(0.5F);
      }
    }
    do
    {
      return;
      this.rightViewText.setEnabled(true);
    } while (Build.VERSION.SDK_INT < 11);
    this.rightViewText.setAlpha(1.0F);
  }
  
  public void setTitle(String paramString)
  {
    this.centerView.setText(paramString);
  }
  
  public static class a
  {
    public String cyL;
    public int edW;
    public String[] ih;
    public String mCallbackId;
    public int mIndex;
    
    public a(int paramInt1, int paramInt2, String paramString1, String paramString2, String... paramVarArgs)
    {
      this.mIndex = paramInt1;
      this.edW = paramInt2;
      this.cyL = paramString1;
      this.mCallbackId = paramString2;
      this.ih = paramVarArgs;
    }
  }
  
  public static class b
  {
    public String mCallbackId;
    public int mFlag;
    public int[] pf;
    
    public b(int[] paramArrayOfInt, int paramInt, String paramString)
    {
      this.pf = paramArrayOfInt;
      this.mFlag = paramInt;
      this.mCallbackId = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqzl
 * JD-Core Version:    0.7.0.1
 */