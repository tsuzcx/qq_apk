package com.tencent.biz.pubaccount.ecshopassit;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import ankt;
import anlm;
import aqhu;
import aqzl;
import arcd.a;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.c;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.a;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.webview.WebViewTitleStyle;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.FadeIconImageView;
import com.tencent.widget.SwipListView;
import com.tencent.widget.SwipListView.a;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import kea;
import kec;
import keg;
import kei;
import kej;
import kek;
import kel;
import org.json.JSONObject;
import wja;

public class ShopWebViewFragment
  extends WebViewFragment
  implements DragFrameLayout.c
{
  DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  SosoInterface.a jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$a = new kel(this, 0, true, false, 600000L, false, false, "ecshop");
  public kea a;
  public int aIl;
  public ViewGroup aK;
  boolean aex;
  boolean aey;
  public keg b;
  public String[] bf = new String[4];
  public TextView centerView;
  SwipListView d;
  public List<RecentShopParcel> gb;
  RedTouch h;
  ImageView hN;
  boolean isFromSearch;
  boolean isWhiteList;
  public int lastY;
  public TextView leftView;
  public int mCurrentIndex = 0;
  ImageView mLeftBackIcon;
  TextView mLeftBackText;
  View mMaskView;
  BroadcastReceiver mReceiver = new kek(this);
  public ImageView rightViewImg;
  public TextView rightViewText;
  int unReadNum;
  
  void a(LayoutInflater paramLayoutInflater)
  {
    this.d = ((SwipListView)paramLayoutInflater.inflate(2131560178, null));
    paramLayoutInflater = paramLayoutInflater.inflate(2131562095, null);
    paramLayoutInflater.findViewById(2131363840).setOnClickListener(new kei(this));
    if (this.isWhiteList)
    {
      localObject = paramLayoutInflater.findViewById(2131380005);
      View localView = paramLayoutInflater.findViewById(2131363840);
      if (localObject != null) {
        ((View)localObject).setBackgroundColor(Color.parseColor("#FFFFFFFF"));
      }
      if (localView != null) {
        localView.setBackgroundResource(2130847971);
      }
      localObject = (TextView)paramLayoutInflater.findViewById(2131364025);
      ((TextView)localObject).setTextColor(Color.parseColor("#FF000000"));
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130838945, 0);
      paramLayoutInflater.findViewById(2131365990).setBackgroundColor(Color.parseColor("#FFF9F9FB"));
      this.d.setBackgroundResource(2131166476);
    }
    this.d.addHeaderView(paramLayoutInflater);
    this.b = new keg(getActivity(), this.d, this.jdField_a_of_type_Kea, this.bf[0]);
    this.d.setAdapter(this.b);
    this.b.bJ(this.gb);
    this.b.setDragHost(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
    this.d.setDragEnable(true);
    if ((getActivity() instanceof SwipListView.a)) {
      this.d.setRightIconMenuListener((SwipListView.a)getActivity());
    }
    if (!this.isWhiteList) {
      return;
    }
    paramLayoutInflater = new JSONObject();
    Object localObject = new JSONObject();
    this.d.setOnTouchListener(new kej(this, paramLayoutInflater, (JSONObject)localObject));
  }
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.getMode() == -1) && (paramDragFrameLayout.bI() != null) && (paramDragFrameLayout.bI().getId() == 2131381284))
    {
      paramDragFrameLayout = (RecentShopParcel)paramDragFrameLayout.bI().getTag(2131375406);
      if (paramDragFrameLayout != null)
      {
        paramDragFrameLayout.unReadNum = 0;
        Intent localIntent = new Intent("action_shop_set_read");
        localIntent.putExtra("uin", paramDragFrameLayout.puin);
        localIntent.putExtra("needDelete", false);
        getActivity().sendBroadcast(localIntent);
      }
    }
  }
  
  void aQ()
  {
    if ((this.leftView == null) || (this.mLeftBackText == null) || (this.mLeftBackText == null)) {
      return;
    }
    Object localObject2;
    if ((this.aey) && (!this.isWhiteList))
    {
      this.leftView.setVisibility(8);
      this.mLeftBackIcon.setVisibility(0);
      this.mLeftBackText.setVisibility(0);
      localObject2 = this.mLeftBackText;
      label66:
      if (localObject2 == null) {
        break label267;
      }
      localObject1 = "" + this.unReadNum;
      if ((this.aey) && (!this.isWhiteList)) {
        break label269;
      }
      localObject1 = getString(2131720735) + "(" + this.unReadNum + ")";
      if (this.unReadNum > 99) {
        localObject1 = getString(2131720735) + "(99+)";
      }
    }
    Object localObject3;
    for (;;)
    {
      localObject3 = localObject1;
      if (this.unReadNum > 0) {
        break label285;
      }
      localObject3 = localObject1;
      if (this.isFromSearch) {
        break label285;
      }
      localObject1 = getString(2131720735);
      localObject3 = localObject1;
      if (!this.aey) {
        break label285;
      }
      localObject3 = localObject1;
      if (this.isWhiteList) {
        break label285;
      }
      ((TextView)localObject2).setVisibility(8);
      return;
      this.leftView.setVisibility(0);
      this.mLeftBackIcon.setVisibility(8);
      this.mLeftBackText.setVisibility(8);
      localObject2 = this.leftView;
      break label66;
      label267:
      break;
      label269:
      if (this.unReadNum > 99) {
        localObject1 = "99+";
      }
    }
    label285:
    Object localObject1 = localObject2;
    if (this.isFromSearch)
    {
      if (!this.isWhiteList) {
        break label331;
      }
      this.mLeftBackIcon.setVisibility(8);
      localObject1 = localObject2;
    }
    for (;;)
    {
      localObject2 = getResources().getString(2131691039);
      localObject3 = localObject2;
      ((TextView)localObject1).setText(localObject3);
      return;
      label331:
      this.mLeftBackIcon.setVisibility(0);
      this.leftView.setVisibility(0);
      this.mLeftBackText.setVisibility(8);
      localObject1 = this.leftView;
      ((TextView)localObject1).setBackgroundResource(0);
    }
  }
  
  public int b(Bundle paramBundle)
  {
    int i = super.b(paramBundle);
    this.aK = this.jdField_a_of_type_Aqzl.aK;
    this.leftView = this.jdField_a_of_type_Aqzl.leftView;
    this.centerView = this.jdField_a_of_type_Aqzl.centerView;
    this.rightViewText = this.jdField_a_of_type_Aqzl.rightViewText;
    this.rightViewImg = this.jdField_a_of_type_Aqzl.rightViewImg;
    su();
    if (this.avR)
    {
      if (this.j != null) {
        this.j.setMask(false);
      }
      if (this.mMaskView == null)
      {
        this.mMaskView = new View(getActivity());
        this.mMaskView.setBackgroundColor(1996488704);
        paramBundle = new RelativeLayout.LayoutParams(-1, -1);
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer.addView(this.mMaskView, paramBundle);
      }
      this.mMaskView.bringToFront();
    }
    if ((this.isWhiteList) && (this.hN != null) && (this.rightViewImg != null))
    {
      this.hN.refreshDrawableState();
      this.rightViewImg.refreshDrawableState();
    }
    return i;
  }
  
  public void cm(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (this.mCurrentIndex == 1))
    {
      this.mCurrentIndex = 0;
      if (this.d != null) {
        this.d.setVisibility(8);
      }
    }
    do
    {
      for (;;)
      {
        return;
        if ((paramInt1 != 1) || (this.mCurrentIndex != 0)) {
          break;
        }
        this.mCurrentIndex = 1;
        if (this.d == null)
        {
          a(LayoutInflater.from(getActivity()));
          RelativeLayout localRelativeLayout = (RelativeLayout)this.j.getParent();
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
          localLayoutParams.topMargin = paramInt2;
          localRelativeLayout.addView(this.d, localLayoutParams);
        }
        while (this.mMaskView != null)
        {
          this.mMaskView.bringToFront();
          return;
          ((RelativeLayout.LayoutParams)this.d.getLayoutParams()).topMargin = paramInt2;
          this.d.setVisibility(0);
          this.b.bJ(this.gb);
          this.d.requestLayout();
        }
      }
    } while ((paramInt1 != 1) || (this.d == null));
    ((RelativeLayout.LayoutParams)this.d.getLayoutParams()).topMargin = paramInt2;
    this.d.requestLayout();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    if (!this.isWhiteList)
    {
      int i = ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication());
      this.Js = new View(super.getActivity());
      this.Js.setId(2131378720);
      this.Js.setBackgroundResource(2130851105);
      paramBundle = new RelativeLayout.LayoutParams(-1, i);
      paramBundle.addRule(10, -1);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer.addView(this.Js, paramBundle);
      LayoutInflater.from(getActivity()).inflate(2131558797, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer);
      this.aK = ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer.findViewById(2131377361));
      this.aK.setBackgroundResource(2130851105);
      ((RelativeLayout.LayoutParams)this.aK.getLayoutParams()).topMargin = i;
      this.leftView = ((TextView)this.aK.findViewById(2131369579));
      this.leftView.setOnClickListener(this);
      this.centerView = ((TextView)this.aK.findViewById(2131369627));
      this.rightViewText = ((TextView)this.aK.findViewById(2131369612));
      this.rightViewImg = ((ImageView)this.aK.findViewById(2131369594));
      this.rightViewText.setOnClickListener(this);
      this.rightViewImg.setOnClickListener(this);
      su();
      return true;
    }
    return super.doOnCreate(paramBundle);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      super.onClick(paramView);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (getActivity() != null)
      {
        getActivity().doOnBackPressed();
        continue;
        if (this.j != null)
        {
          String str1 = WebViewPlugin.toJsScript("onEnterUserInfo", new JSONObject(), new JSONObject());
          this.j.callJs(str1);
        }
        if (this.h != null) {
          this.h.dGB();
        }
        this.jdField_a_of_type_Kea.aG(getActivity(), this.bf[3]);
        try
        {
          this.jdField_a_of_type_Kea.a.a(134248547, null, null, null, null, 0L, false);
        }
        catch (Exception localException) {}
        continue;
        if (this.j != null)
        {
          String str2 = WebViewPlugin.toJsScript("onSearchBtnClick", new JSONObject(), new JSONObject());
          this.j.callJs(str2);
        }
      }
    }
  }
  
  /* Error */
  public void onCreate(Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 493	com/tencent/mobileqq/webview/swift/WebViewFragment:onCreate	(Landroid/os/Bundle;)V
    //   5: aload_0
    //   6: getfield 497	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:mApp	Lcom/tencent/common/app/AppInterface;
    //   9: ifnonnull +14 -> 23
    //   12: aload_0
    //   13: aload_0
    //   14: invokevirtual 149	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   17: invokevirtual 501	android/support/v4/app/FragmentActivity:getAppInterface	()Lcom/tencent/common/app/AppInterface;
    //   20: putfield 497	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:mApp	Lcom/tencent/common/app/AppInterface;
    //   23: aload_0
    //   24: new 474	kea
    //   27: dup
    //   28: aload_0
    //   29: getfield 497	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:mApp	Lcom/tencent/common/app/AppInterface;
    //   32: aload_0
    //   33: invokespecial 504	kea:<init>	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment;)V
    //   36: putfield 151	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:jdField_a_of_type_Kea	Lkea;
    //   39: aload_0
    //   40: getfield 508	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:intent	Landroid/content/Intent;
    //   43: ldc_w 510
    //   46: invokevirtual 514	android/content/Intent:hasExtra	(Ljava/lang/String;)Z
    //   49: ifeq +204 -> 253
    //   52: aload_0
    //   53: getfield 508	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:intent	Landroid/content/Intent;
    //   56: ldc_w 510
    //   59: invokevirtual 518	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   62: astore_1
    //   63: aload_1
    //   64: ldc 216
    //   66: invokevirtual 524	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   69: invokevirtual 530	android/os/Bundle:setClassLoader	(Ljava/lang/ClassLoader;)V
    //   72: aload_0
    //   73: aload_1
    //   74: ldc_w 532
    //   77: iconst_0
    //   78: invokevirtual 536	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   81: putfield 104	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:isWhiteList	Z
    //   84: aload_1
    //   85: ldc_w 538
    //   88: lconst_0
    //   89: invokevirtual 542	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   92: lstore_3
    //   93: aload_1
    //   94: ldc_w 544
    //   97: iconst_0
    //   98: invokevirtual 536	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   101: istore 5
    //   103: lload_3
    //   104: lconst_0
    //   105: lcmp
    //   106: ifne +230 -> 336
    //   109: lconst_0
    //   110: lstore_3
    //   111: aload_0
    //   112: aload_1
    //   113: ldc_w 546
    //   116: invokevirtual 550	android/os/Bundle:getStringArray	(Ljava/lang/String;)[Ljava/lang/String;
    //   119: putfield 54	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:bf	[Ljava/lang/String;
    //   122: aload_0
    //   123: aload_1
    //   124: ldc_w 552
    //   127: invokevirtual 556	android/os/Bundle:getParcelableArrayList	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   130: putfield 162	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:gb	Ljava/util/List;
    //   133: aload_0
    //   134: aload_1
    //   135: ldc_w 558
    //   138: iconst_0
    //   139: invokevirtual 536	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   142: putfield 560	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:aex	Z
    //   145: aload_0
    //   146: aload_1
    //   147: ldc_w 561
    //   150: iconst_0
    //   151: invokevirtual 565	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   154: putfield 271	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:unReadNum	I
    //   157: aload_0
    //   158: aload_1
    //   159: ldc_w 567
    //   162: iconst_1
    //   163: invokevirtual 536	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   166: putfield 253	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:aey	Z
    //   169: aload_0
    //   170: aload_1
    //   171: ldc_w 569
    //   174: iconst_0
    //   175: invokevirtual 536	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   178: putfield 291	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:isFromSearch	Z
    //   181: aload_0
    //   182: getfield 151	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:jdField_a_of_type_Kea	Lkea;
    //   185: aload_0
    //   186: getfield 104	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:isWhiteList	Z
    //   189: putfield 572	kea:aet	Z
    //   192: aload_0
    //   193: getfield 104	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:isWhiteList	Z
    //   196: ifeq +22 -> 218
    //   199: aload_0
    //   200: getfield 151	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:jdField_a_of_type_Kea	Lkea;
    //   203: getfield 481	kea:a	Lkec;
    //   206: ldc_w 573
    //   209: aconst_null
    //   210: aconst_null
    //   211: aconst_null
    //   212: aconst_null
    //   213: lconst_0
    //   214: iconst_0
    //   215: invokevirtual 487	kec:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZ)V
    //   218: aload_0
    //   219: getfield 151	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:jdField_a_of_type_Kea	Lkea;
    //   222: getfield 481	kea:a	Lkec;
    //   225: astore 6
    //   227: iload 5
    //   229: ifeq +116 -> 345
    //   232: ldc_w 575
    //   235: astore_1
    //   236: aload 6
    //   238: ldc_w 576
    //   241: aconst_null
    //   242: aload_1
    //   243: lload_3
    //   244: invokestatic 580	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   247: aconst_null
    //   248: lconst_0
    //   249: iconst_0
    //   250: invokevirtual 487	kec:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZ)V
    //   253: aload_0
    //   254: aload_0
    //   255: invokevirtual 149	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   258: invokestatic 583	com/tencent/mobileqq/activity/recent/cur/DragFrameLayout:b	(Landroid/app/Activity;)Lcom/tencent/mobileqq/activity/recent/cur/DragFrameLayout;
    //   261: putfield 168	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout	Lcom/tencent/mobileqq/activity/recent/cur/DragFrameLayout;
    //   264: aload_0
    //   265: getfield 168	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout	Lcom/tencent/mobileqq/activity/recent/cur/DragFrameLayout;
    //   268: aload_0
    //   269: iconst_0
    //   270: invokevirtual 586	com/tencent/mobileqq/activity/recent/cur/DragFrameLayout:a	(Lcom/tencent/mobileqq/activity/recent/cur/DragFrameLayout$c;Z)V
    //   273: new 588	android/content/IntentFilter
    //   276: dup
    //   277: invokespecial 589	android/content/IntentFilter:<init>	()V
    //   280: astore_1
    //   281: aload_1
    //   282: ldc_w 591
    //   285: invokevirtual 594	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   288: aload_1
    //   289: ldc_w 596
    //   292: invokevirtual 594	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   295: aload_0
    //   296: invokevirtual 149	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   299: aload_0
    //   300: getfield 63	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:mReceiver	Landroid/content/BroadcastReceiver;
    //   303: aload_1
    //   304: invokevirtual 600	android/support/v4/app/FragmentActivity:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   307: pop
    //   308: aload_0
    //   309: getfield 151	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:jdField_a_of_type_Kea	Lkea;
    //   312: astore_1
    //   313: aload_0
    //   314: getfield 497	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:mApp	Lcom/tencent/common/app/AppInterface;
    //   317: astore 6
    //   319: aload_0
    //   320: getfield 162	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:gb	Ljava/util/List;
    //   323: ifnonnull +29 -> 352
    //   326: iconst_0
    //   327: istore_2
    //   328: aload_1
    //   329: aload 6
    //   331: iload_2
    //   332: invokevirtual 604	kea:c	(Lmqq/app/AppRuntime;I)V
    //   335: return
    //   336: invokestatic 610	java/lang/System:currentTimeMillis	()J
    //   339: lload_3
    //   340: lsub
    //   341: lstore_3
    //   342: goto -231 -> 111
    //   345: ldc_w 612
    //   348: astore_1
    //   349: goto -113 -> 236
    //   352: aload_0
    //   353: getfield 162	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:gb	Ljava/util/List;
    //   356: invokeinterface 617 1 0
    //   361: istore_2
    //   362: goto -34 -> 328
    //   365: astore_1
    //   366: return
    //   367: astore_1
    //   368: goto -115 -> 253
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	371	0	this	ShopWebViewFragment
    //   0	371	1	paramBundle	Bundle
    //   327	35	2	i	int
    //   92	250	3	l	long
    //   101	127	5	bool	boolean
    //   225	105	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   295	326	365	java/lang/Exception
    //   328	335	365	java/lang/Exception
    //   352	362	365	java/lang/Exception
    //   192	218	367	java/lang/Exception
    //   218	227	367	java/lang/Exception
    //   236	253	367	java/lang/Exception
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.isWhiteList) {}
    for (;;)
    {
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      this.mCurrentIndex = 1;
      a(LayoutInflater.from(getActivity()));
      paramViewGroup = new RelativeLayout.LayoutParams(-1, -1);
      paramViewGroup.addRule(3, 2131377407);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer.addView(this.d, paramViewGroup);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    try
    {
      getActivity().unregisterReceiver(this.mReceiver);
      label15:
      if (this.b != null)
      {
        this.b.destroy();
        this.b = null;
      }
      if (this.jdField_a_of_type_Kea != null) {
        this.jdField_a_of_type_Kea.destroy();
      }
      return;
    }
    catch (Exception localException)
    {
      break label15;
    }
  }
  
  public void onResume()
  {
    int j = 1;
    int i = 1;
    super.onResume();
    if ((this.gb != null) && (!this.gb.isEmpty())) {
      if (Build.VERSION.SDK_INT >= 23) {
        if (getActivity().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
          break label98;
        }
      }
    }
    for (;;)
    {
      j = i;
      if (i == 0)
      {
        getActivity().requestPermissions("android.permission.ACCESS_FINE_LOCATION", 10, new String[0]);
        j = i;
      }
      if (j != 0) {
        SosoInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$a);
      }
      if (this.b != null) {
        this.b.notifyDataSetChanged();
      }
      return;
      label98:
      i = 0;
    }
  }
  
  public void oy(int paramInt)
  {
    if (this.hN == null) {
      return;
    }
    if ((paramInt == 1) && (this.hN != null))
    {
      this.hN.setVisibility(0);
      this.h = new RedTouch(getActivity(), this.hN);
      this.h.a(53);
      this.h.a();
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      localRedTypeInfo.red_type.set(0);
      this.h.c(localRedTypeInfo);
      this.h.setVisibility(0);
      return;
    }
    this.h.setVisibility(4);
  }
  
  void su()
  {
    this.mLeftBackIcon = new FadeIconImageView(getActivity());
    this.mLeftBackText = new TextView(getActivity());
    Object localObject1;
    Object localObject2;
    int i;
    if (!this.isWhiteList)
    {
      this.leftView.setVisibility(8);
      this.mLeftBackIcon.setId(2131369967);
      this.mLeftBackIcon.setOnClickListener(this);
      this.mLeftBackIcon.setImageResource(2130851759);
      localObject1 = (RelativeLayout)this.aK.findViewById(2131377501);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(15);
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = wja.dp2px(10.0F, getResources());
      ((RelativeLayout)localObject1).addView(this.mLeftBackIcon, (ViewGroup.LayoutParams)localObject2);
      this.mLeftBackText.setId(2131380514);
      this.mLeftBackText.setOnClickListener(this);
      this.mLeftBackText.setTextColor(getResources().getColor(2131167654));
      this.mLeftBackText.setTextSize(1, 17.0F);
      this.mLeftBackText.setBackgroundResource(2130838072);
      this.mLeftBackText.setGravity(17);
      i = wja.dp2px(3.0F, getResources());
      int j = wja.dp2px(4.0F, getResources());
      this.mLeftBackText.setPadding(i, 0, i, 0);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(15);
      ((RelativeLayout.LayoutParams)localObject2).addRule(1, 2131369967);
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = j;
      ((RelativeLayout)localObject1).addView(this.mLeftBackText, (ViewGroup.LayoutParams)localObject2);
      localObject1 = new int[4][];
      localObject1[0] = { 16842919 };
      localObject1[1] = { 16842912 };
      localObject1[2] = { 16842913 };
      localObject1[3] = new int[0];
      if (!this.aey) {
        break label835;
      }
      if (!this.isWhiteList)
      {
        this.aK.setBackgroundResource(2130851106);
        localObject2 = getResources().getColorStateList(2131167302);
        this.centerView.setTextColor((ColorStateList)localObject2);
        localObject2 = new ColorStateList((int[][])localObject1, new int[] { 2147483647, 2147483647, 2147483647, -1 });
        this.rightViewText.setTextColor((ColorStateList)localObject2);
        getActivity().setStatusBarBlue();
      }
      if (Build.VERSION.SDK_INT >= 19) {}
    }
    label835:
    try
    {
      localObject2 = (ViewGroup.MarginLayoutParams)this.aK.getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject2).topMargin = (ankt.dip2px(29.0F) - ImmersiveUtils.getStatusBarHeight(getActivity().getApplicationContext()));
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "Change mBackWrapper topMargin=" + ((ViewGroup.MarginLayoutParams)localObject2).topMargin);
      }
      this.aK.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    catch (Throwable localThrowable)
    {
      label507:
      break label507;
    }
    if (this.isWhiteList)
    {
      this.aK.setBackgroundResource(0);
      this.aK.setBackgroundColor(-1);
      ImmersiveUtils.a(getActivity().getWindow(), true);
      if (this.Js != null) {
        this.Js.setBackgroundResource(2130852004);
      }
      i = wja.dp2px(3.0F, getResources());
      localObject1 = new ColorStateList((int[][])localObject1, new int[] { 2130706432, 2130706432, 2130706432, -16777216 });
      this.centerView.setTextColor((ColorStateList)localObject1);
      this.leftView.setTextColor((ColorStateList)localObject1);
      this.leftView.setBackgroundResource(2130850369);
      this.rightViewImg.setVisibility(0);
      this.hN.setVisibility(0);
      this.rightViewImg.setPadding(i, i, i, i);
      this.hN.setPadding(i, i, i, i);
      this.hN.setImageDrawable(aqhu.b(2130847978, getActivity()));
      this.rightViewImg.setImageDrawable(aqhu.b(2130847979, getActivity()));
      this.rightViewImg.setOnClickListener(this);
      this.hN.setOnClickListener(this);
      i = wja.dp2px(4.0F, getResources());
      ((RelativeLayout.LayoutParams)this.rightViewImg.getLayoutParams()).rightMargin = i;
    }
    for (;;)
    {
      aQ();
      return;
      i = wja.dp2px(30.0F, getResources());
      this.hN = new FadeIconImageView(getActivity());
      this.hN.setId(2131369600);
      this.hN.setScaleType(ImageView.ScaleType.CENTER);
      localObject1 = new RelativeLayout.LayoutParams(i, i);
      ((RelativeLayout.LayoutParams)localObject1).addRule(1, 2131369594);
      ((RelativeLayout)this.rightViewImg.getParent()).addView(this.hN, (ViewGroup.LayoutParams)localObject1);
      break;
      if ((!this.mNeedStatusTrans) || (ImmersiveUtils.isSupporImmersive() != 1)) {
        break label507;
      }
      if (this.Js != null)
      {
        if ((this.jdField_a_of_type_Arcd$a != null) && (this.jdField_a_of_type_Arcd$a.a != null))
        {
          this.Js.setBackgroundColor(this.jdField_a_of_type_Arcd$a.a.statusBarColor);
          anlm.a(true, this.jdField_a_of_type_Arcd$a.a.statusBarColor, getHostActivity().getWindow());
          break label507;
        }
        this.Js.setBackgroundColor(getResources().getColor(2131167361));
        anlm.a(false, getResources().getColor(2131167361), getHostActivity().getWindow());
        break label507;
      }
      setImmersiveStatus();
      break label507;
      this.rightViewText.setVisibility(0);
      this.rightViewText.setOnClickListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.ShopWebViewFragment
 * JD-Core Version:    0.7.0.1
 */