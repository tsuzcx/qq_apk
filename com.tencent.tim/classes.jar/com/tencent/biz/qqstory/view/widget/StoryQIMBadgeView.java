package com.tencent.biz.qqstory.view.widget;

import acfd;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.LruCache;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import ppg;
import ppg.d;
import rpq;
import rsx;

public class StoryQIMBadgeView
  extends ImageView
  implements View.OnClickListener
{
  private static final LruCache<String, Boolean> l = new LruCache(50);
  private acfd a;
  private String aBX;
  private boolean aJF;
  private QQUserUIItem b;
  private AppInterface mApp;
  
  public StoryQIMBadgeView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public StoryQIMBadgeView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public StoryQIMBadgeView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  @RequiresApi(api=21)
  public StoryQIMBadgeView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    init();
  }
  
  public static void clearCache()
  {
    l.evictAll();
  }
  
  public void g(QQUserUIItem paramQQUserUIItem)
  {
    if ((paramQQUserUIItem == null) || (TextUtils.isEmpty(paramQQUserUIItem.qq))) {
      setVisibility(8);
    }
    do
    {
      do
      {
        return;
        this.b = paramQQUserUIItem;
        if (!ppg.isQQ()) {
          break;
        }
        if ((!this.aJF) && (l.get(this.b.qq) != null))
        {
          ul(((Boolean)l.get(this.b.qq)).booleanValue());
          return;
        }
        if (!this.aJF) {
          setVisibility(8);
        }
        paramQQUserUIItem = QQStoryContext.c();
      } while (paramQQUserUIItem == null);
      paramQQUserUIItem = (FriendListHandler)paramQQUserUIItem.getBusinessHandler(1);
    } while (paramQQUserUIItem == null);
    paramQQUserUIItem.bE(this.b.qq, false);
    return;
    ul(this.b.isVipButNoFriend());
  }
  
  protected void init()
  {
    if (ppg.isQQ()) {
      this.a = new rsx(this);
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (ppg.isQQ())
    {
      this.mApp = QQStoryContext.c();
      if (this.a != null) {
        this.mApp.addObserver(this.a);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.b == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Context localContext = paramView.getContext();
      String str = ppg.d.b(this.b);
      Intent localIntent = new Intent(localContext, QQBrowserActivity.class);
      localIntent.putExtra("url", str);
      localIntent.putExtra("hide_operation_bar", true);
      localContext.startActivity(localIntent);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((ppg.isQQ()) && (this.mApp != null) && (this.a != null))
    {
      this.mApp.removeObserver(this.a);
      this.mApp = null;
    }
  }
  
  public void setForceRefresh(boolean paramBoolean)
  {
    this.aJF = paramBoolean;
  }
  
  public void ul(boolean paramBoolean)
  {
    rpq.p(this);
    if (paramBoolean)
    {
      if (TextUtils.isEmpty(this.aBX))
      {
        this.aBX = ppg.d.a(this.b);
        if (TextUtils.isEmpty(this.aBX)) {
          return;
        }
      }
      rpq.a(this, this.aBX, getMeasuredWidth(), getMeasuredHeight(), null, null);
    }
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      setVisibility(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.StoryQIMBadgeView
 * JD-Core Version:    0.7.0.1
 */