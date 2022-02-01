package com.tencent.biz.pubaccount.readinjoy.video;

import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.RecyclerViewAccessibilityDelegate;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.accessibility.AccessibilityEvent;
import aqcl;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView.a;
import com.tencent.common.config.AppSetting;
import mtg.b;
import mtg.k;
import mtg.l;
import muj;

public class VideoFeedsAccessibilityHelper
{
  public static void E(View paramView, int paramInt)
  {
    if (!AppSetting.enableTalkBack) {
      return;
    }
    f(paramView, "");
  }
  
  public static void F(View paramView, int paramInt)
  {
    if (!AppSetting.enableTalkBack) {
      return;
    }
    f(paramView, "");
  }
  
  public static void a(View paramView, long paramLong)
  {
    if (!AppSetting.enableTalkBack) {}
    do
    {
      return;
      paramView = muj.a(paramLong);
    } while ((paramView == null) || (!TextUtils.isEmpty(paramView.toString())));
  }
  
  public static void a(ReadInJoyNickNameTextView paramReadInJoyNickNameTextView, ReadInJoyNickNameTextView.a parama)
  {
    if ((!AppSetting.enableTalkBack) || (paramReadInJoyNickNameTextView == null)) {
      return;
    }
    paramReadInJoyNickNameTextView.setOnSetNickNameListener(parama);
  }
  
  public static void a(mtg.k paramk, View.OnClickListener paramOnClickListener)
  {
    if ((!AppSetting.enableTalkBack) || (paramk == null) || (paramk.lP == null)) {
      return;
    }
    paramk.lP.setOnClickListener(paramOnClickListener);
    paramk.lP.setTag(paramk);
  }
  
  public static void b(RecyclerView.ViewHolder paramViewHolder)
  {
    if ((!AppSetting.enableTalkBack) || (paramViewHolder == null)) {}
    do
    {
      return;
      if ((paramViewHolder instanceof mtg.b))
      {
        aqcl.ip(((mtg.b)paramViewHolder).rl);
        return;
      }
    } while (!(paramViewHolder instanceof mtg.l));
    aqcl.ip(((mtg.l)paramViewHolder).titleTextView);
  }
  
  public static void b(RecyclerView paramRecyclerView)
  {
    if ((paramRecyclerView == null) || (!AppSetting.enableTalkBack)) {
      return;
    }
    paramRecyclerView.setAccessibilityDelegateCompat(new VideoFeedsRVAccessibilityDelegate(paramRecyclerView));
  }
  
  public static void c(View paramView, int paramInt, boolean paramBoolean)
  {
    if (!AppSetting.enableTalkBack) {
      return;
    }
    if (paramBoolean) {}
    f(paramView, "");
  }
  
  public static View e(View paramView)
  {
    if ((!AppSetting.enableTalkBack) || (paramView == null)) {
      paramView = null;
    }
    View localView;
    do
    {
      return paramView;
      localView = paramView.findViewById(2131361873);
      paramView = localView;
    } while (localView == null);
    localView.setVisibility(0);
    return localView;
  }
  
  public static void f(View paramView, String paramString)
  {
    if (paramView == null) {
      return;
    }
    paramView.setContentDescription(paramString);
  }
  
  public static void g(View paramView, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!AppSetting.enableTalkBack)) {}
  }
  
  public static void h(View paramView, String paramString)
  {
    if ((AppSetting.enableTalkBack) && (TextUtils.isEmpty(paramString))) {}
  }
  
  public static void n(View paramView, boolean paramBoolean)
  {
    if (!AppSetting.enableTalkBack) {}
  }
  
  public static class VideoFeedsRVAccessibilityDelegate
    extends RecyclerViewAccessibilityDelegate
  {
    public VideoFeedsRVAccessibilityDelegate(RecyclerView paramRecyclerView)
    {
      super();
    }
    
    public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      AccessibilityEventCompat.asRecord(paramAccessibilityEvent).setItemCount(0);
    }
    
    public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
      paramAccessibilityNodeInfoCompat.setScrollable(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAccessibilityHelper
 * JD-Core Version:    0.7.0.1
 */