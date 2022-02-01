package com.tencent.mobileqq.microapp.ui;

import Wallet.ApkgConfig;
import aafz;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.microapp.R.color;
import com.tencent.mobileqq.microapp.R.drawable;
import com.tencent.mobileqq.microapp.R.id;
import com.tencent.mobileqq.microapp.R.layout;
import com.tencent.mobileqq.microapp.a.c;
import com.tencent.mobileqq.microapp.apkg.MiniAppConfig;
import com.tencent.mobileqq.microapp.apkg.f;
import com.tencent.mobileqq.microapp.apkg.q;
import com.tencent.mobileqq.microapp.apkg.u;
import com.tencent.mobileqq.microapp.app.b;
import com.tencent.mobileqq.microapp.appbrand.page.PageWebview;
import com.tencent.mobileqq.microapp.appbrand.page.ServiceWebview;
import com.tencent.mobileqq.microapp.ext.UtilProxy;
import com.tencent.mobileqq.microapp.util.DisplayUtil;
import com.tencent.mobileqq.microapp.widget.WebViewProgressBar;
import com.tencent.mobileqq.microapp.widget.i;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;
import org.json.JSONObject;

public class NavigationBar
  extends RelativeLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  public PageWebview a;
  private com.tencent.mobileqq.microapp.ui.a.a b;
  private ProgressBar c;
  private com.tencent.mobileqq.microapp.appbrand.a d;
  private f e;
  private boolean f;
  private int g = -16777216;
  private int h = -1;
  private String i = "";
  private String j;
  private View k;
  private ImageView l;
  private ImageView m;
  private ImageView n;
  private TextView o;
  private TextView p;
  private View q;
  private WebViewProgressBar r;
  private i s;
  private boolean t;
  private boolean u;
  private boolean v;
  private View w;
  private View x;
  private Listener y;
  
  public NavigationBar(com.tencent.mobileqq.microapp.appbrand.a parama, Context paramContext)
  {
    super(paramContext);
    this.d = parama;
    this.e = parama.c;
    e();
  }
  
  private void d()
  {
    if (this.h == -1)
    {
      this.m.setImageResource(R.drawable.p);
      this.n.setImageResource(R.drawable.l);
      this.l.setImageResource(R.drawable.r);
      localDrawable = getResources().getDrawable(R.drawable.j);
      if (Build.VERSION.SDK_INT < 16) {
        this.x.setBackgroundDrawable(localDrawable);
      }
      for (;;)
      {
        this.w.setBackgroundColor(Color.parseColor("#FFFFFF"));
        return;
        this.x.setBackground(localDrawable);
      }
    }
    this.m.setImageResource(R.drawable.o);
    this.n.setImageResource(R.drawable.k);
    this.l.setImageResource(R.drawable.q);
    Drawable localDrawable = getResources().getDrawable(R.drawable.i);
    if (Build.VERSION.SDK_INT < 16) {
      this.x.setBackgroundDrawable(localDrawable);
    }
    for (;;)
    {
      this.w.setBackgroundColor(Color.parseColor("#EAEAEA"));
      return;
      this.x.setBackground(localDrawable);
    }
  }
  
  private void e()
  {
    if (getContext() != null)
    {
      c();
      this.k = a();
      addView(this.k);
      this.m = ((ImageView)findViewById(R.id.m));
      this.n = ((ImageView)findViewById(R.id.l));
      this.l = ((ImageView)findViewById(R.id.d));
      this.o = ((TextView)findViewById(R.id.c));
      this.p = ((TextView)findViewById(R.id.am));
      this.c = ((ProgressBar)findViewById(R.id.ap));
      this.m.setOnClickListener(this);
      this.n.setOnClickListener(this);
      this.l.setOnClickListener(this);
      this.w = findViewById(R.id.ah);
      this.o.setText(this.i);
      this.o.setTextColor(this.h);
      this.k.setBackgroundColor(this.g);
      this.r = ((WebViewProgressBar)findViewById(R.id.an));
      this.q = findViewById(R.id.ao);
      this.q.setBackgroundColor(this.g);
      this.x = findViewById(R.id.n);
      d();
      this.c.setIndeterminateDrawable(getResources().getDrawable(R.drawable.b));
      this.c.setIndeterminate(true);
      if (this.t)
      {
        this.r.setVisibility(0);
        a((byte)0);
        if (!this.u) {
          break label329;
        }
        this.p.setVisibility(0);
        this.p.setText(this.j);
        if (!this.v) {
          break label341;
        }
        this.l.setVisibility(0);
      }
    }
    label329:
    label341:
    while (!QLog.isColorLevel())
    {
      for (;;)
      {
        return;
        this.r.setVisibility(8);
        continue;
        this.p.setVisibility(8);
      }
      this.l.setVisibility(4);
      return;
    }
    QLog.d("NavigationBar", 2, "[init] context null");
  }
  
  public View a()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    Object localObject1 = new ViewGroup.LayoutParams(-1, -2);
    localRelativeLayout.setPadding(localRelativeLayout.getPaddingLeft(), DisplayUtil.dip2px(getContext(), 7.0F), localRelativeLayout.getPaddingRight(), DisplayUtil.dip2px(getContext(), 7.0F));
    localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = new RelativeLayout(getContext());
    ((RelativeLayout)localObject1).setId(R.id.ai);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(8, R.id.n);
    ((RelativeLayout.LayoutParams)localObject2).addRule(6, R.id.n);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new ImageView(getContext());
    ((ImageView)localObject2).setId(R.id.d);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(getContext(), 43.0F), -1);
    localLayoutParams.addRule(15, -1);
    ((ImageView)localObject2).setPadding(DisplayUtil.dip2px(getContext(), 16.0F), ((ImageView)localObject2).getTop(), ((ImageView)localObject2).getRight(), ((ImageView)localObject2).getBottom());
    ((ImageView)localObject2).setImageResource(R.drawable.q);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    localObject2 = new TextView(getContext());
    ((TextView)localObject2).setId(R.id.am);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = DisplayUtil.dip2px(getContext(), 10.0F);
    localLayoutParams.addRule(1, R.id.d);
    localLayoutParams.addRule(15, -1);
    ((TextView)localObject2).setHint("Back");
    ((TextView)localObject2).setTextSize(1, 20.0F);
    ((TextView)localObject2).setVisibility(8);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    localObject2 = new TextView(getContext());
    ((TextView)localObject2).setId(R.id.c);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(15, -1);
    localLayoutParams.addRule(1, R.id.d);
    localLayoutParams.leftMargin = DisplayUtil.dip2px(getContext(), 10.0F);
    localLayoutParams.rightMargin = DisplayUtil.dip2px(getContext(), 108.0F);
    ((TextView)localObject2).setTextColor(-1);
    ((TextView)localObject2).setSingleLine(true);
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject2).setTextSize(1, 18.0F);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    localObject2 = new ProgressBar(getContext());
    ((ProgressBar)localObject2).setId(R.id.ap);
    localLayoutParams = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(getContext(), 19.0F), DisplayUtil.dip2px(getContext(), 19.0F));
    localLayoutParams.addRule(1, R.id.c);
    localLayoutParams.addRule(13, -1);
    localLayoutParams.leftMargin = DisplayUtil.dip2px(getContext(), 2.0F);
    ((ProgressBar)localObject2).setVisibility(8);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    localObject1 = new RelativeLayout(getContext());
    ((RelativeLayout)localObject1).setId(R.id.n);
    localObject2 = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(getContext(), 99.0F), DisplayUtil.dip2px(getContext(), 35.0F));
    ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject2).topMargin = DisplayUtil.dip2px(getContext(), 25.0F);
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = DisplayUtil.dip2px(getContext(), 9.0F);
    ((RelativeLayout)localObject1).setBackgroundResource(R.drawable.i);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new View(getContext());
    ((View)localObject2).setId(R.id.ah);
    localLayoutParams = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(getContext(), 1.0F), DisplayUtil.dip2px(getContext(), 18.0F));
    localLayoutParams.addRule(13, -1);
    ((View)localObject2).setBackgroundColor(-2039584);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    localObject2 = new ImageView(getContext());
    ((ImageView)localObject2).setId(R.id.m);
    localLayoutParams = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(getContext(), 19.0F), -1);
    localLayoutParams.addRule(9, -1);
    localLayoutParams.addRule(0, R.id.ah);
    int i1 = DisplayUtil.dip2px(getContext(), 5.0F);
    ((ImageView)localObject2).setPadding(i1, i1, i1, i1);
    ((ImageView)localObject2).setBackgroundResource(R.drawable.m);
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    ((ImageView)localObject2).setImageResource(R.drawable.e);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    localObject2 = new ImageView(getContext());
    ((ImageView)localObject2).setId(R.id.l);
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(11, -1);
    localLayoutParams.addRule(1, R.id.ah);
    i1 = DisplayUtil.dip2px(getContext(), 5.0F);
    ((ImageView)localObject2).setPadding(i1, i1, i1, i1);
    ((ImageView)localObject2).setBackgroundResource(R.drawable.n);
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    ((ImageView)localObject2).setImageResource(R.drawable.a);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    localObject1 = new View(getContext());
    ((View)localObject1).setId(R.id.ao);
    localObject2 = new RelativeLayout.LayoutParams(-1, 0);
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, R.id.ai);
    ((RelativeLayout.LayoutParams)localObject2).topMargin = DisplayUtil.dip2px(getContext(), 5.0F);
    ((View)localObject1).setBackgroundColor(getContext().getResources().getColor(R.color.f));
    ((View)localObject1).setVisibility(8);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new WebViewProgressBar(getContext());
    ((WebViewProgressBar)localObject1).setId(R.id.an);
    localObject2 = new RelativeLayout.LayoutParams(-1, 0);
    ((RelativeLayout.LayoutParams)localObject2).topMargin = DisplayUtil.dip2px(getContext(), 5.0F);
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, R.id.ai);
    ((WebViewProgressBar)localObject1).setVisibility(8);
    ((WebViewProgressBar)localObject1).setBackgroundColor(getContext().getResources().getColor(R.color.a));
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    return localRelativeLayout;
  }
  
  public NavigationBar a(int paramInt)
  {
    this.g = paramInt;
    if (this.k != null) {
      this.k.setBackgroundColor(this.g);
    }
    c();
    return this;
  }
  
  public NavigationBar a(u paramu)
  {
    if (paramu != null)
    {
      paramu = paramu.a;
      if (paramu != null)
      {
        b(paramu.c);
        if (!TextUtils.isEmpty(paramu.b)) {
          a(paramu.b);
        }
        a(paramu.a);
        b();
        TextUtils.isEmpty(paramu.d);
        this.t = false;
      }
    }
    return this;
  }
  
  public NavigationBar a(Listener paramListener)
  {
    this.y = paramListener;
    return this;
  }
  
  public NavigationBar a(String paramString)
  {
    if ("black".equals(paramString)) {
      this.h = -16777216;
    }
    for (;;)
    {
      if (this.o != null) {
        this.o.setTextColor(this.h);
      }
      d();
      return this;
      if ("white".equals(paramString)) {
        this.h = -1;
      }
    }
  }
  
  public NavigationBar a(boolean paramBoolean)
  {
    this.v = paramBoolean;
    if (this.l != null)
    {
      if (paramBoolean)
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.o.getLayoutParams();
        localLayoutParams.leftMargin = 0;
        this.o.setLayoutParams(localLayoutParams);
        this.o.requestLayout();
        this.l.setVisibility(0);
      }
    }
    else {
      return this;
    }
    this.l.setVisibility(8);
    return this;
  }
  
  public void a(byte paramByte)
  {
    if (this.s == null)
    {
      this.s = new i();
      if (this.r != null)
      {
        this.r.a(this.s);
        this.s.a(this.r);
      }
    }
    if ((paramByte == 0) && (this.r != null)) {
      this.r.setVisibility(0);
    }
    if ((paramByte == 2) && (this.r != null)) {
      this.r.setVisibility(8);
    }
    this.s.a(paramByte);
  }
  
  public NavigationBar b(String paramString)
  {
    this.i = paramString;
    if (this.o != null) {
      this.o.setText(this.i);
    }
    return this;
  }
  
  public void b()
  {
    this.t = false;
    if (this.c != null) {
      this.c.setVisibility(4);
    }
    if (this.r != null) {
      this.r.setVisibility(4);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void c()
  {
    Object localObject = getContext();
    View localView;
    int i1;
    if ((localObject != null) && ((localObject instanceof Activity)))
    {
      localObject = (Activity)localObject;
      if (!((Activity)localObject).isFinishing())
      {
        localView = ((Activity)localObject).getWindow().getDecorView();
        i1 = this.g;
        if (!c.a(i1)) {
          break label141;
        }
        if ((Build.VERSION.SDK_INT >= 21) && (Build.VERSION.SDK_INT <= 22) && (!aafz.isMIUI()))
        {
          ((Activity)localObject).getWindow().clearFlags(67108864);
          ((Activity)localObject).getWindow().addFlags(-2147483648);
          ((Activity)localObject).getWindow().setStatusBarColor(637534208);
        }
        UtilProxy.setStatusTextColor(true, ((Activity)localObject).getWindow());
        if ((aafz.isFlymeOS()) && (Build.VERSION.SDK_INT >= 23)) {
          ((Activity)localObject).getWindow().getDecorView().setSystemUiVisibility(9216);
        }
      }
    }
    for (;;)
    {
      localView.setBackgroundColor(i1);
      return;
      label141:
      if ((Build.VERSION.SDK_INT >= 21) && (Build.VERSION.SDK_INT <= 22) && (!aafz.isMIUI()))
      {
        ((Activity)localObject).getWindow().clearFlags(-2147483648);
        ((Activity)localObject).getWindow().addFlags(67108864);
        ((Activity)localObject).getWindow().setStatusBarColor(0);
      }
      UtilProxy.setStatusTextColor(false, ((Activity)localObject).getWindow());
      if ((aafz.isFlymeOS()) && (Build.VERSION.SDK_INT >= 16)) {
        ((Activity)localObject).getWindow().getDecorView().setSystemUiVisibility(1280);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i2 = 8;
    Object localObject;
    int i1;
    if (paramView.getId() == R.id.m)
    {
      b.a().a("hideKeyboard");
      this.b = new com.tencent.mobileqq.microapp.ui.a.a(getContext());
      this.b.setContentView(LayoutInflater.from(getContext()).inflate(R.layout.b, null));
      localObject = (TextView)this.b.findViewById(R.id.ab);
      ((TextView)localObject).setOnClickListener(this);
      if (this.f)
      {
        i1 = 8;
        ((TextView)localObject).setVisibility(i1);
        localObject = (TextView)this.b.findViewById(R.id.y);
        i1 = i2;
        if (this.a.isShowShare) {
          i1 = 0;
        }
        ((TextView)localObject).setVisibility(i1);
        ((TextView)localObject).setOnClickListener(this);
        ((TextView)this.b.findViewById(R.id.bg)).setOnClickListener(this);
        localObject = (TextView)this.b.findViewById(R.id.u);
        ((TextView)localObject).setText(String.format("关于%s", new Object[] { this.e.f.config.app_name }));
        ((TextView)localObject).setOnClickListener(this);
        ((TextView)this.b.findViewById(R.id.v)).setOnClickListener(this);
        this.b.show();
        if (this.y != null) {
          this.y.onClickMore(this);
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i1 = 0;
      break;
      if (paramView.getId() == R.id.l)
      {
        if (this.y != null)
        {
          b.a().a("hideInput");
          this.y.onClickClose(this);
        }
      }
      else if (paramView.getId() == R.id.d)
      {
        if (this.y != null) {
          this.y.onClickBack(this);
        }
      }
      else if (paramView.getId() == R.id.ab)
      {
        this.b.dismiss();
        this.d.a(null);
      }
      else if (paramView.getId() == R.id.y)
      {
        this.b.dismiss();
        if (this.a != null)
        {
          localObject = new JSONObject();
          try
          {
            ((JSONObject)localObject).put("fromShareButton", 0);
            localObject = "WeixinJSBridge.subscribeHandler(\"onShareAppMessage\"," + localObject + "," + this.a.pageWebviewId + ")";
            this.d.i.evaluateJavascript((String)localObject, new NavigationBar.1(this));
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
        }
      }
      else if (paramView.getId() == R.id.u)
      {
        this.b.dismiss();
      }
      else if (paramView.getId() == R.id.v)
      {
        this.b.dismiss();
      }
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    if (paramView.getId() == R.id.l)
    {
      if (this.y != null) {
        this.y.onLongClickBack(this);
      }
      return true;
    }
    return false;
  }
  
  public static abstract interface Listener
  {
    public abstract void onClickBack(NavigationBar paramNavigationBar);
    
    public abstract void onClickClose(NavigationBar paramNavigationBar);
    
    public abstract void onClickMore(NavigationBar paramNavigationBar);
    
    public abstract void onLongClickBack(NavigationBar paramNavigationBar);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.ui.NavigationBar
 * JD-Core Version:    0.7.0.1
 */