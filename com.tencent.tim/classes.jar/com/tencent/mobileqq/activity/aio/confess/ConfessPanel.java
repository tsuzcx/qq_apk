package com.tencent.mobileqq.activity.aio.confess;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.XPanelContainer.e;
import wqy;

public class ConfessPanel
  extends RelativeLayout
  implements View.OnClickListener, View.OnLongClickListener, XPanelContainer.e
{
  public static int bQS = -1;
  public static final int bQT;
  public static int bQU;
  private FrameLayout U;
  private wqy a;
  private int bQV;
  private int bQW;
  private boolean bfw;
  private boolean bfx;
  private TouchWebView c;
  public QQAppInterface mApp;
  private BaseChatPie mBaseChatPie;
  private Context mContext;
  private int mLastHeight;
  private boolean yu;
  
  static
  {
    int i = BaseApplicationImpl.sApplication.getResources().getDisplayMetrics().widthPixels;
    bQT = ff(i);
    bQU = i;
  }
  
  public ConfessPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public ConfessPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static int a(Resources paramResources, int paramInt1, int paramInt2)
  {
    int j = paramInt1 + paramInt2;
    int k = paramResources.getDisplayMetrics().heightPixels;
    int i;
    if (j <= k)
    {
      i = j;
      if (j <= k * 0.6F) {}
    }
    else
    {
      i = (int)(k * 0.6F);
    }
    j = i;
    if (i < XPanelContainer.euZ + paramInt2) {
      j = XPanelContainer.euZ + paramInt2;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ConfessPanel", 2, String.format("adjustPanelHeight [maxPanelH,toolbarH,screenH,ExternalH,dstHeight]=[%d,%d,%d,%d,%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(k), Integer.valueOf(XPanelContainer.euZ), Integer.valueOf(j) }));
    }
    return j;
  }
  
  private void a(BaseChatPie paramBaseChatPie, int paramInt)
  {
    if (paramBaseChatPie == null) {
      return;
    }
    this.bQV = h(paramBaseChatPie);
    this.bQW = (a(getResources(), paramInt, this.bQV) - this.bQV);
  }
  
  private void cbc()
  {
    if (this.yu)
    {
      if (this.c != null)
      {
        ViewParent localViewParent = this.c.getParent();
        if ((localViewParent != null) && ((localViewParent instanceof ViewGroup))) {
          ((ViewGroup)localViewParent).removeAllViewsInLayout();
        }
        this.c.removeAllViews();
      }
      if (this.a != null) {
        this.a.onDestroy();
      }
      this.c = null;
      this.yu = false;
    }
  }
  
  public static int ff(int paramInt)
  {
    return (int)(paramInt * 1.0F / 1.132931F);
  }
  
  public static int h(BaseChatPie paramBaseChatPie)
  {
    int i = 0;
    InputLinearLayout localInputLinearLayout = paramBaseChatPie.a;
    paramBaseChatPie = paramBaseChatPie.b;
    if (localInputLinearLayout != null) {
      i = 0 + localInputLinearLayout.getHeight();
    }
    int j = i;
    if (paramBaseChatPie != null) {
      j = i + paramBaseChatPie.getHeight();
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConfessPanel", 2, "getToolbarHeight =" + j);
    }
    return j;
  }
  
  private void initWebView()
  {
    if (!this.yu)
    {
      this.a = new wqy(this.mContext, this.mBaseChatPie.a(), this.mApp);
      this.c = this.a.b(this.U);
      this.c.getSettings().setMediaPlaybackRequiresUserGesture(false);
      this.c.getPluginEngine().b(this.a);
      this.yu = true;
    }
  }
  
  public void init(QQAppInterface paramQQAppInterface, Context paramContext, BaseChatPie paramBaseChatPie)
  {
    this.mApp = paramQQAppInterface;
    this.mContext = paramContext;
    this.mBaseChatPie = paramBaseChatPie;
    a(this.mBaseChatPie, bQT);
    bQS = XPanelContainer.aLe;
    this.U = ((FrameLayout)findViewById(2131365208));
  }
  
  public int nA()
  {
    if ((BaseApplicationImpl.sApplication != null) && (BaseApplicationImpl.sApplication.getResources() != null))
    {
      ViewParent localViewParent = getParent();
      if ((localViewParent instanceof View))
      {
        int i = ((View)localViewParent).getWidth();
        if ((bQU != i) && (i > 0))
        {
          bQU = i;
          QLog.d("ConfessPanel", 2, "getPanelHeight , sLastScreenWidth:" + bQU + " winwidth:" + i);
          int j = ff(i);
          a(this.mBaseChatPie, j);
          QLog.d("ConfessPanel", 2, "getPanelHeight , sLastScreenWidth:" + bQU + " winwidth:" + i + " nWinHeight:" + j);
          return this.bQW;
        }
      }
    }
    QLog.d("ConfessPanel", 2, "getPanelHeight , use max height:" + this.bQW);
    return this.bQW;
  }
  
  public void o(int paramInt, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConfessPanel", 2, "onActivityResult, requestCode = " + paramInt);
    }
    if (this.bfx)
    {
      WebViewPlugin localWebViewPlugin = this.c.getPluginEngine().a(42, true);
      if (localWebViewPlugin != null) {
        localWebViewPlugin.onActivityResult(paramIntent, (byte)1, -1);
      }
    }
  }
  
  public void onClick(View paramView) {}
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.bfw)
    {
      if (XPanelContainer.aLe == this.mLastHeight) {
        XPanelContainer.aLe = bQS;
      }
      QLog.d("ConfessPanel", 2, "onDetachedFromWindow, set mExternalPanelheight :" + XPanelContainer.aLe);
    }
    this.bfw = false;
  }
  
  public boolean onLongClick(View paramView)
  {
    return false;
  }
  
  public void onShow()
  {
    bQS = XPanelContainer.aLe;
    QLog.d("ConfessPanel", 2, "onShow mOriginPanelHeight:" + bQS);
    this.bfw = true;
    this.mLastHeight = nA();
    XPanelContainer.aLe = this.mLastHeight;
    QLog.d("ConfessPanel", 2, "set mExternalPanelheight :" + XPanelContainer.aLe);
    if ((this.bfx) && (!this.yu)) {
      initWebView();
    }
    if (this.bfx)
    {
      String str = this.mBaseChatPie.a().getIntent().getStringExtra("url");
      if (QLog.isColorLevel()) {
        QLog.d("ConfessPanel", 2, "onShow url :" + str);
      }
      this.a.loadUrl(str);
    }
  }
  
  public void unInit()
  {
    QLog.d("ConfessPanel", 2, "unInit");
    cbc();
    this.mApp = null;
  }
  
  public int vV()
  {
    this.mLastHeight = nA();
    QLog.d("ConfessPanel", 2, "getDefaultExternalPanelheight , orginal:" + XPanelContainer.aLe + " return:" + this.mLastHeight);
    return this.mLastHeight;
  }
  
  public void yQ(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConfessPanel", 2, "onHide :" + paramBoolean);
    }
    this.bfw = false;
    this.mLastHeight = 0;
    if (!paramBoolean) {
      XPanelContainer.aLe = bQS;
    }
    QLog.d("ConfessPanel", 2, "set mExternalPanelheight :" + XPanelContainer.aLe);
    if (this.bfx) {
      cbc();
    }
    setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.confess.ConfessPanel
 * JD-Core Version:    0.7.0.1
 */