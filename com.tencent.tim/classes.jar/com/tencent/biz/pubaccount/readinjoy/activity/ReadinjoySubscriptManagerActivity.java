package com.tencent.biz.pubaccount.readinjoy.activity;

import aajx;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqdf.a;
import aqfo;
import com.tencent.biz.pubaccount.AccountDetail.view.ReadInJoyNewFeedsTopGestureLayout;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.SwipListView;
import com.tencent.widget.SwipListView.a;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.Comparator;
import java.util.List;
import kbv;
import kjo;
import kjp;
import kjq;
import kjr;
import mqq.os.MqqHandler;
import wja;

public class ReadinjoySubscriptManagerActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, aqdf.a, SwipListView.a
{
  private a jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity$a;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private boolean afS;
  private View al;
  private SwipListView f;
  private View mEmptyView;
  private aajx mFaceDecoder;
  private TextView ob;
  private Comparator<b> s = new kjo(this);
  
  private void L(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
      View localView = localViewGroup.getChildAt(0);
      Object localObject = localViewGroup;
      if (localView != null)
      {
        localObject = localViewGroup;
        if ((localView instanceof DragFrameLayout)) {
          localObject = (ViewGroup)localView;
        }
      }
      localObject = ((ViewGroup)localObject).getChildAt(0);
      if ((localObject instanceof TopGestureLayout)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)localObject);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(paramBoolean);
    }
  }
  
  private void bT(List<b> paramList)
  {
    if (paramList != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity$a.setData(paramList);
      this.f.AP();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity$a.getCount() == 0)
    {
      this.ob.setVisibility(8);
      this.mEmptyView.setVisibility(0);
      return;
    }
    this.ob.setVisibility(0);
    this.mEmptyView.setVisibility(8);
  }
  
  private void ie()
  {
    ThreadManager.getSubThreadHandler().post(new ReadinjoySubscriptManagerActivity.2(this));
  }
  
  private void initUI()
  {
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler))) {
      ((FlingGestureHandler)this.mFlingHandler).setTopLayout(new ReadInJoyNewFeedsTopGestureLayout(this));
    }
    setLeftViewName(2131690700);
    this.ob = ((TextView)getRightTextView());
    this.ob.setVisibility(8);
    this.ob.setOnClickListener(this);
    this.ob.setText(2131718399);
    this.mEmptyView = findViewById(2131366438);
    TextView localTextView = (TextView)findViewById(2131380239);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity$a = new a(null);
    this.f = ((SwipListView)findViewById(2131378964));
    localTextView = new TextView(this);
    localTextView.setHeight(wja.dp2px(20.0F, getResources()));
    localTextView.setBackgroundResource(2131167595);
    localTextView.setClickable(false);
    localTextView.setHintTextColor(getResources().getColor(2131167595));
    this.f.addHeaderView(localTextView, null, false);
    this.f.setDragEnable(this.afS);
    this.f.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity$a);
    this.f.setRightIconMenuListener(this);
    this.f.setOnItemClickListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity$a);
    this.mFaceDecoder = new aajx(this.app, this, false);
    this.al = findViewById(2131372391);
    if (ThemeUtil.isInNightMode(this.app)) {
      this.al.setVisibility(0);
    }
  }
  
  private void mi(String paramString)
  {
    Context localContext = getApplicationContext();
    new kbv(this.app, paramString, localContext, new kjp(this)).start();
  }
  
  public void aDb()
  {
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      super.getWindow().addFlags(67108864);
      if (this.mSystemBarComp == null) {
        this.mSystemBarComp = new SystemBarCompact(this, true, -1);
      }
      this.mSystemBarComp.init();
      if (!ThemeUtil.isInNightMode(this.app)) {
        break label178;
      }
      if ((aqfo.isMIUI()) || (aqfo.isFlyme())) {
        break label157;
      }
      this.mSystemBarComp.setStatusBarColor(-7829368);
    }
    for (;;)
    {
      this.leftView.setTextColor(-14408926);
      this.leftView.setTextColor(-14408926);
      this.leftView.setBackgroundResource(2130850369);
      if (this.centerView != null) {
        this.centerView.setTextColor(-16777216);
      }
      if (this.ob != null) {
        this.ob.setTextColor(-16777216);
      }
      this.vg.setBackgroundColor(-1);
      return;
      label157:
      this.mSystemBarComp.setStatusBarColor(-7829368);
      this.mSystemBarComp.setStatusBarDarkMode(true);
      continue;
      label178:
      if ((Build.VERSION.SDK_INT >= 23) && (!aqfo.isMIUI()) && (!aqfo.isFlyme()))
      {
        getWindow().getDecorView().setSystemUiVisibility(9216);
        this.mSystemBarComp.setStatusBarColor(-1);
      }
      else if (!aqfo.isFlyme())
      {
        this.mSystemBarComp.setStatusBarColor(-2368549);
      }
      else
      {
        this.mSystemBarComp.setStatusBarColor(-1);
        this.mSystemBarComp.setStatusBarDarkMode(true);
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    setContentView(2131560484);
    initUI();
    aDb();
    ie();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.mFaceDecoder != null)
    {
      this.mFaceDecoder.onDestory();
      this.mFaceDecoder = null;
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    ie();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    boolean bool;
    label41:
    TextView localTextView;
    if (!this.afS)
    {
      bool = true;
      this.afS = bool;
      this.f.setDragEnable(this.afS);
      localTextView = this.ob;
      if (!this.afS) {
        break label95;
      }
    }
    label95:
    for (int i = 2131718379;; i = 2131718399)
    {
      localTextView.setText(i);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity$a.notifyDataSetChanged();
      break;
      bool = false;
      break label41;
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (this.f == null) {}
    for (;;)
    {
      return;
      paramInt2 = this.f.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        Object localObject = this.f.getChildAt(paramInt1);
        if ((((View)localObject).getTag() instanceof c))
        {
          localObject = (c)((View)localObject).getTag();
          if (TextUtils.equals(c.a((c)localObject), paramString))
          {
            new Handler(Looper.getMainLooper()).post(new ReadinjoySubscriptManagerActivity.4(this, (c)localObject, paramBitmap));
            return;
          }
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void onRightIconMenuHide(View paramView)
  {
    L(true);
  }
  
  public void onRightIconMenuShow(View paramView)
  {
    L(false);
  }
  
  public class a
    extends BaseAdapter
    implements AdapterView.c
  {
    private List<ReadinjoySubscriptManagerActivity.b> mData;
    
    private a() {}
    
    private void a(ReadinjoySubscriptManagerActivity.c paramc, int paramInt, View paramView)
    {
      ReadinjoySubscriptManagerActivity.b localb = (ReadinjoySubscriptManagerActivity.b)this.mData.get(paramInt);
      ReadinjoySubscriptManagerActivity.c.a(paramc).setText(ReadinjoySubscriptManagerActivity.b.b(localb));
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)ReadinjoySubscriptManagerActivity.c.a(paramc).getLayoutParams();
      Object localObject = localLayoutParams;
      if (localLayoutParams == null) {
        localObject = new RelativeLayout.LayoutParams(-2, -2);
      }
      ReadinjoySubscriptManagerActivity.c.a(paramc).setImageDrawable(ReadinjoySubscriptManagerActivity.a(ReadinjoySubscriptManagerActivity.this).a(1008, ReadinjoySubscriptManagerActivity.b.c(localb)));
      int i;
      if (ReadinjoySubscriptManagerActivity.a(ReadinjoySubscriptManagerActivity.this))
      {
        ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
        localObject = ReadinjoySubscriptManagerActivity.c.a(paramc);
        if (!ReadinjoySubscriptManagerActivity.a(ReadinjoySubscriptManagerActivity.this)) {
          break label238;
        }
        i = 0;
        label121:
        ((View)localObject).setVisibility(i);
        ReadinjoySubscriptManagerActivity.c.a(paramc).setOnClickListener(new kjq(this, paramView));
        if (paramInt != getCount() - 1) {
          break label245;
        }
        ReadinjoySubscriptManagerActivity.c.b(paramc).setVisibility(8);
        label163:
        ReadinjoySubscriptManagerActivity.c.a(paramc).setOnClickListener(new kjr(this, localb));
        ReadinjoySubscriptManagerActivity.c.a(paramc, ReadinjoySubscriptManagerActivity.b.c(localb));
        if (!ReadinjoySubscriptManagerActivity.a(ReadinjoySubscriptManagerActivity.this)) {
          break label256;
        }
        ReadinjoySubscriptManagerActivity.c.c(paramc).setBackgroundResource(2131167158);
      }
      for (;;)
      {
        ReadinjoySubscriptManagerActivity.c.c(paramc).setPressed(false);
        return;
        ((RelativeLayout.LayoutParams)localObject).leftMargin = ReadinjoySubscriptManagerActivity.this.getResources().getDimensionPixelSize(2131299216);
        break;
        label238:
        i = 8;
        break label121;
        label245:
        ReadinjoySubscriptManagerActivity.c.b(paramc).setVisibility(0);
        break label163;
        label256:
        ReadinjoySubscriptManagerActivity.c.c(paramc).setBackgroundResource(2130842544);
      }
    }
    
    public int getCount()
    {
      if (this.mData != null) {
        return this.mData.size();
      }
      return 0;
    }
    
    public Object getItem(int paramInt)
    {
      if ((this.mData != null) && (paramInt < this.mData.size())) {
        return this.mData.get(paramInt);
      }
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView;
      if (paramView == null)
      {
        paramView = new ReadinjoySubscriptManagerActivity.c(ReadinjoySubscriptManagerActivity.this, null);
        localView = ReadinjoySubscriptManagerActivity.this.getLayoutInflater().inflate(2131560483, paramViewGroup, false);
        ReadinjoySubscriptManagerActivity.c.a(paramView, localView.findViewById(2131365322));
        ReadinjoySubscriptManagerActivity.c.b(paramView, localView.findViewById(2131365679));
        ReadinjoySubscriptManagerActivity.c.a(paramView, (ImageView)localView.findViewById(2131378960));
        ReadinjoySubscriptManagerActivity.c.a(paramView, (TextView)localView.findViewById(2131378966));
        ReadinjoySubscriptManagerActivity.c.a(paramView, (Button)localView.findViewById(2131381244));
        ReadinjoySubscriptManagerActivity.c.c(paramView, localView.findViewById(2131365990));
        localView.setTag(paramView);
        localView.setTag(-3, Integer.valueOf(ReadinjoySubscriptManagerActivity.this.getResources().getDimensionPixelSize(2131299217)));
      }
      for (;;)
      {
        a(paramView, paramInt, localView);
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        ReadinjoySubscriptManagerActivity.c localc = (ReadinjoySubscriptManagerActivity.c)paramView.getTag();
        localView = paramView;
        paramView = localc;
      }
    }
    
    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      paramAdapterView = (ReadinjoySubscriptManagerActivity.b)getItem((int)paramLong);
      if ((paramAdapterView == null) || (ReadinjoySubscriptManagerActivity.a(ReadinjoySubscriptManagerActivity.this))) {
        return;
      }
      paramView = new Intent(ReadinjoySubscriptManagerActivity.this, AccountDetailActivity.class);
      paramView.putExtra("uin", ReadinjoySubscriptManagerActivity.b.c(paramAdapterView));
      paramView.putExtra("report_src_param_type", "");
      paramView.putExtra("report_src_param_name", "");
      ReadinjoySubscriptManagerActivity.this.startActivity(paramView);
    }
    
    public void setData(List<ReadinjoySubscriptManagerActivity.b> paramList)
    {
      if (paramList == null) {
        return;
      }
      this.mData = paramList;
      notifyDataSetChanged();
    }
  }
  
  public class b
  {
    private String ZD;
    private String nickName;
    private String uin;
    
    private b() {}
  }
  
  public class c
  {
    private Button bJ;
    private View containerView;
    private ImageView icon;
    private View jJ;
    private View jK;
    private TextView name;
    private String uin;
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadinjoySubscriptManagerActivity
 * JD-Core Version:    0.7.0.1
 */