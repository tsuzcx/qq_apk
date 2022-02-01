package com.tencent.mobileqq.webview.swift;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.ui.RefreshView;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.widget.immersive.ImmersiveUtils;
import riw;
import wja;

public class WebBrowserViewContainer
  extends RelativeLayout
{
  public ProgressBar aq;
  private boolean cXq;
  public FrameLayout ce;
  public FrameLayout cf;
  private final Context context;
  private boolean inited;
  
  public WebBrowserViewContainer(Context paramContext)
  {
    super(paramContext);
    this.context = paramContext;
    setBackgroundColor(-1);
  }
  
  public WebBrowserViewContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
    setBackgroundColor(-1);
  }
  
  public WebBrowserViewContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.context = paramContext;
    setBackgroundColor(-1);
  }
  
  private void Ti(boolean paramBoolean)
  {
    Object localObject = LayoutInflater.from(this.context);
    if (paramBoolean) {}
    for (this.cf = ((FrameLayout)((LayoutInflater)localObject).inflate(2131560160, null));; this.cf = ((FrameLayout)((LayoutInflater)localObject).inflate(2131560159, null)))
    {
      this.cf.setId(2131367234);
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      this.cf.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
  }
  
  private WebViewProgressBar a()
  {
    WebViewProgressBar localWebViewProgressBar = new WebViewProgressBar(this.context);
    localWebViewProgressBar.setId(2131373669);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, wja.dp2px(3.0F, super.getResources()));
    localLayoutParams.addRule(10, -1);
    localWebViewProgressBar.setLayoutParams(localLayoutParams);
    return localWebViewProgressBar;
  }
  
  private RefreshView b()
  {
    RefreshView localRefreshView = new RefreshView(this.context, null);
    localRefreshView.setId(2131382187);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams.gravity = 80;
    localRefreshView.setMinimumHeight(wja.dp2px(50.0F, super.getResources()));
    localRefreshView.setLayoutParams(localLayoutParams);
    localRefreshView.addView(bO());
    localRefreshView.addView(a());
    return localRefreshView;
  }
  
  private View bO()
  {
    View localView = new View(this.context);
    localView.setId(2131371159);
    localView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    localView.setBackgroundColor(1996488704);
    localView.setVisibility(8);
    return localView;
  }
  
  private void bUs()
  {
    this.aq = new ProgressBar(this.context, null, 0);
    this.aq.setId(2131377037);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(wja.dp2px(23.0F, super.getResources()), wja.dp2px(23.0F, super.getResources()));
    localLayoutParams.topMargin = wja.dp2px(-25.0F, super.getResources());
    localLayoutParams.addRule(13, -1);
    this.aq.setIndeterminate(true);
    this.aq.setIndeterminateDrawable(super.getResources().getDrawable(2130839657));
    this.aq.setVisibility(8);
    this.aq.setLayoutParams(localLayoutParams);
  }
  
  private void egE()
  {
    this.ce = new FrameLayout(this.context);
    Object localObject = new RelativeLayout.LayoutParams(-1, -1);
    this.ce.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.ce.setId(2131367814);
    localObject = g();
    this.ce.addView((View)localObject);
    if (!this.cXq)
    {
      localObject = q();
      this.ce.addView((View)localObject);
    }
    if (!this.cXq)
    {
      localObject = b();
      this.ce.addView((View)localObject);
    }
    for (;;)
    {
      egF();
      egG();
      egH();
      return;
      localObject = s();
      this.ce.addView((View)localObject);
    }
  }
  
  private void egF()
  {
    ViewStub localViewStub = new ViewStub(this.context);
    localViewStub.setId(2131363684);
    localViewStub.setLayoutResource(2131560049);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    localLayoutParams.gravity = 80;
    this.ce.addView(localViewStub, localLayoutParams);
  }
  
  private FrameLayout g()
  {
    FrameLayout localFrameLayout = new FrameLayout(this.context);
    localFrameLayout.setId(2131362742);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    localLayoutParams.gravity = 49;
    localFrameLayout.setLayoutParams(localLayoutParams);
    return localFrameLayout;
  }
  
  private LinearLayout q()
  {
    LinearLayout localLinearLayout = new LinearLayout(this.context);
    localLinearLayout.setId(2131363732);
    Object localObject = new FrameLayout.LayoutParams(-1, -1);
    ((FrameLayout.LayoutParams)localObject).gravity = 49;
    localLinearLayout.setBackgroundColor(super.getResources().getColor(2131167649));
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new TextView(this.context);
    ((TextView)localObject).setId(2131363733);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.topMargin = wja.dp2px(20.0F, super.getResources());
    ((TextView)localObject).setGravity(17);
    ((TextView)localObject).setText("");
    ((TextView)localObject).setTextColor(-9472906);
    localLinearLayout.addView((View)localObject, localLayoutParams);
    localObject = new TextView(this.context);
    ((TextView)localObject).setId(2131379266);
    localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = wja.dp2px(8.0F, super.getResources());
    localLayoutParams.gravity = 1;
    ((TextView)localObject).setPadding(wja.dp2px(2.0F, super.getResources()), 0, wja.dp2px(2.0F, super.getResources()), 0);
    ((TextView)localObject).setVisibility(8);
    ((TextView)localObject).setText("QQ浏览器X5内核提供技术支持");
    ((TextView)localObject).setTextColor(-9472906);
    ((TextView)localObject).setCompoundDrawables(super.getResources().getDrawable(2130838991), null, null, null);
    localLinearLayout.addView((View)localObject, localLayoutParams);
    return localLinearLayout;
  }
  
  private RelativeLayout s()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.context, null);
    localRelativeLayout.setId(2131382187);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams.gravity = 80;
    localRelativeLayout.setMinimumHeight(wja.dp2px(50.0F, super.getResources()));
    localRelativeLayout.setLayoutParams(localLayoutParams);
    localRelativeLayout.addView(bO());
    localRelativeLayout.addView(a());
    return localRelativeLayout;
  }
  
  public void Tj(boolean paramBoolean)
  {
    Ti(paramBoolean);
    super.addView(this.cf);
  }
  
  public void egG()
  {
    ViewStub localViewStub = new ViewStub(this.context);
    localViewStub.setId(2131363626);
    localViewStub.setLayoutResource(2131560048);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    localLayoutParams.gravity = 80;
    this.ce.addView(localViewStub, localLayoutParams);
  }
  
  public void egH()
  {
    ViewStub localViewStub = new ViewStub(this.context);
    localViewStub.setId(2131367236);
    localViewStub.setLayoutResource(2131560051);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 53;
    localLayoutParams.height = riw.dip2px(this.context, 44.0F);
    localLayoutParams.topMargin = ImmersiveUtils.getStatusBarHeight(this.context);
    this.ce.addView(localViewStub, localLayoutParams);
  }
  
  public void init(boolean paramBoolean)
  {
    if (!this.inited)
    {
      this.cXq = paramBoolean;
      this.inited = true;
      super.setId(2131363728);
      egE();
      super.addView(this.ce);
      bUs();
      super.addView(this.aq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebBrowserViewContainer
 * JD-Core Version:    0.7.0.1
 */