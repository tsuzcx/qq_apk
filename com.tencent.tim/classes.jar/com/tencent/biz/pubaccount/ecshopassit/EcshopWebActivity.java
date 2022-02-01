package com.tencent.biz.pubaccount.ecshopassit;

import adak;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import arag;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import com.tencent.widget.SwipListView.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class EcshopWebActivity
  extends QQBrowserActivity
  implements SwipListView.a
{
  public String Yu;
  public String Yv;
  boolean aeu = false;
  boolean aev;
  boolean aew = false;
  Map<Rect, Boolean> dy = new HashMap();
  public List<RecentShopParcel> gb;
  ViewGroup mContainer;
  private long mStartTime;
  long onCreateTime;
  public long rN;
  public long rQ;
  
  public EcshopWebActivity()
  {
    this.s = ShopWebViewFragment.class;
  }
  
  private boolean U(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.dy.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      boolean bool = ((Boolean)localEntry.getValue()).booleanValue();
      if (((Rect)localEntry.getKey()).contains(paramInt1, paramInt2)) {
        return bool;
      }
    }
    return false;
  }
  
  public WebViewFragment a(WebViewTabBarData paramWebViewTabBarData)
  {
    if (this.aeu) {
      return super.a(paramWebViewTabBarData);
    }
    return arag.a(this, paramWebViewTabBarData, super.getIntent());
  }
  
  public void a(Rect paramRect, boolean paramBoolean)
  {
    if (paramRect != null)
    {
      if ((paramBoolean) && (this.dy.containsKey(paramRect))) {
        this.dy.remove(paramRect);
      }
      Iterator localIterator = this.dy.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Rect localRect = (Rect)((Map.Entry)localIterator.next()).getKey();
        if ((localRect.left == paramRect.left) && (localRect.top == paramRect.top)) {
          this.dy.remove(localRect);
        }
      }
      this.dy.put(paramRect, Boolean.valueOf(paramBoolean));
    }
  }
  
  void ap(Bundle paramBundle)
  {
    this.gb = paramBundle.getParcelableArrayList("datas");
    this.Yu = paramBundle.getString("ad_logo");
    this.Yv = paramBundle.getString("ad_jump");
    this.rN = paramBundle.getLong("ad_id", 0L);
    this.rQ = paramBundle.getLong("latest_time", 0L);
    this.aeu = paramBundle.getBoolean("is_tab_show", false);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (this.mContainer == null)
    {
      this.mContainer = ((ViewGroup)findViewById(2131382187));
      if (this.mContainer == null) {
        this.mContainer = ((ViewGroup)findViewById(2131365379));
      }
      if (this.mContainer == null) {
        return super.dispatchTouchEvent(paramMotionEvent);
      }
    }
    View localView = findViewById(2131377361);
    if (localView == null) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    switch (i)
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      if ((!this.aeu) && (!this.aev))
      {
        this.aew = false;
      }
      else if ((this.aev) || (!U((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY() - localView.getBottom())))
      {
        this.aew = true;
        continue;
        if (this.aew)
        {
          this.mContainer.requestDisallowInterceptTouchEvent(true);
          continue;
          this.aew = false;
        }
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    Intent localIntent = new Intent("action_folder_destroy");
    localIntent.putExtra("stay_time", System.currentTimeMillis() - this.onCreateTime);
    sendBroadcast(localIntent);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    Intent localIntent = new Intent("action_folder_set_read");
    if (!this.gb.isEmpty()) {
      localIntent.putExtra("uin", ((RecentShopParcel)this.gb.get(0)).puin);
    }
    sendBroadcast(localIntent);
    adak.a(this.app, "9970", 1, 4, System.currentTimeMillis() - this.mStartTime);
  }
  
  public void doOnRestoreInstanceState(Bundle paramBundle)
  {
    super.doOnRestoreInstanceState(paramBundle);
    paramBundle = paramBundle.getBundle("bundle");
    ap(paramBundle);
    getIntent().putExtra("bundle", paramBundle);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.mStartTime = System.currentTimeMillis();
  }
  
  public void doOnSaveInstanceState(Bundle paramBundle)
  {
    super.doOnSaveInstanceState(paramBundle);
    paramBundle.putBundle("bundle", getIntent().getBundleExtra("bundle"));
  }
  
  public boolean isWrapContent()
  {
    return true;
  }
  
  public void lW(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.gb == null) || (this.gb.isEmpty())) {}
    for (;;)
    {
      return;
      Object localObject = new Intent("action_shop_set_read");
      ((Intent)localObject).putExtra("uin", paramString);
      ((Intent)localObject).putExtra("needDelete", false);
      sendBroadcast((Intent)localObject);
      localObject = this.gb.iterator();
      while (((Iterator)localObject).hasNext())
      {
        RecentShopParcel localRecentShopParcel = (RecentShopParcel)((Iterator)localObject).next();
        if (paramString.equals(localRecentShopParcel.puin)) {
          localRecentShopParcel.unReadNum = 0;
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (paramBundle != null) {
      getIntent().putExtras(paramBundle);
    }
    super.onCreate(paramBundle);
    ap(getIntent().getBundleExtra("bundle"));
    this.onCreateTime = System.currentTimeMillis();
  }
  
  public void onRightIconMenuHide(View paramView)
  {
    this.aev = false;
  }
  
  public void onRightIconMenuShow(View paramView)
  {
    this.aev = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcshopWebActivity
 * JD-Core Version:    0.7.0.1
 */