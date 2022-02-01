package com.tencent.mobileqq.nearby.profilecard;

import acfp;
import akho;
import akhs;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.security.InvalidParameterException;
import java.util.List;

public class SavorTagImg
  extends LinearLayout
  implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener
{
  public static final int[] mc = { 60, 60, 60 };
  static final int[] md = { 85, 60, 60 };
  akho a;
  boolean cso = true;
  public HorizontalListView mListView;
  int mTagType;
  String mTitle;
  public TextView mTitleView;
  
  public SavorTagImg(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SavorTagImg(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView();
  }
  
  private void am(View paramView, int paramInt)
  {
    if (this.a != null)
    {
      Object localObject = (akhs)this.mListView.getAdapter();
      if (localObject != null)
      {
        localObject = (InterestTagInfo)((akhs)localObject).getItem(paramInt);
        if (localObject != null) {
          this.a.a(paramView, this.mTagType, (InterestTagInfo)localObject);
        }
      }
    }
  }
  
  private void initView()
  {
    removeAllViews();
    getResources().getDimensionPixelSize(2131297506);
    int i = getResources().getDimensionPixelSize(2131297507);
    setOrientation(1);
    this.mTitleView = ((TextView)LayoutInflater.from(getContext()).inflate(2131561493, null));
    LinearLayout.LayoutParams localLayoutParams = generateDefaultLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = -2;
    localLayoutParams.topMargin = i;
    localLayoutParams.bottomMargin = i;
    addView(this.mTitleView, localLayoutParams);
  }
  
  @TargetApi(9)
  public void a(String paramString, int paramInt, List<InterestTagInfo> paramList, akho paramakho)
  {
    if (this.mListView != null) {
      throw new InvalidParameterException("SavorTagImg can not init twice");
    }
    this.mTitle = paramString;
    this.mTagType = paramInt;
    this.a = paramakho;
    int i = 0;
    int k;
    int j;
    switch (paramInt)
    {
    default: 
      paramString = getResources();
      float f = paramString.getDisplayMetrics().density;
      k = (int)(mc[i] * f);
      j = (int)(md[i] * f);
      if ((paramInt == 10) || (paramInt == 9) || (paramInt == 11)) {
        j = (int)(mc[i] * f);
      }
      i = paramString.getDimensionPixelSize(2131299327);
      int m = paramString.getDimensionPixelSize(2131297507);
      paramString = new GradientDrawable();
      if (this.mTagType == 7)
      {
        paramString.setColor(getResources().getColor(2131166111));
        paramString.setCornerRadius(10.0F * f);
        paramString.setShape(0);
        int n = getResources().getDimensionPixelSize(2131297787);
        paramString.setSize(n, n);
        label214:
        paramString = new akhs(getContext(), paramString, k, j, paramInt);
        paramString.RQ(0 - i);
        this.mListView = new HorizontalListView(getContext());
        this.mListView.setDividerWidth(i);
        paramakho = generateDefaultLayoutParams();
        paramakho.width = -1;
        paramakho.height = paramString.GQ();
        paramakho.bottomMargin = m;
        addView(this.mListView, paramakho);
        this.mListView.setAdapter(paramString);
        if (this.a == null) {
          break label402;
        }
        this.mListView.setOnItemLongClickListener(this);
        this.mListView.setOnItemClickListener(this);
      }
      break;
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT >= 9) {
        this.mListView.setOverScrollMode(0);
      }
      bJ(paramList);
      return;
      i = 0;
      break;
      i = 1;
      break;
      i = 2;
      break;
      paramString.setColor(getResources().getColor(2131166111));
      paramString.setShape(0);
      paramString.setSize(k, j);
      break label214;
      label402:
      this.mListView.setTransTouchStateToParent(true);
    }
  }
  
  public boolean arQ()
  {
    if (this.mListView != null)
    {
      Rect localRect = new Rect();
      if ((this.mListView.getGlobalVisibleRect(localRect)) && (localRect.bottom - localRect.top >= 0.5D * this.mListView.getMeasuredHeight())) {
        return true;
      }
    }
    return false;
  }
  
  public void bJ(List<InterestTagInfo> paramList)
  {
    if (this.mListView == null) {
      throw new InvalidParameterException("can not updateData before init");
    }
    akhs localakhs = (akhs)this.mListView.getAdapter();
    if (localakhs == null) {
      return;
    }
    localakhs.setData(paramList);
    if (paramList == null) {}
    for (int i = 0; i > 0; i = paramList.size())
    {
      paramList = new StringBuilder(this.mTitle);
      paramList.append('(').append(i).append(')');
      this.mTitleView.setText(paramList.toString());
      this.mListView.setVisibility(0);
      return;
    }
    this.mTitleView.setText(this.mTitle);
    this.mListView.setVisibility(8);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((getContext() instanceof NearbyPeopleProfileActivity)) {
      ((NearbyPeopleProfileActivity)getContext()).setInterceptTouchFlag(false);
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    am(paramView, paramInt);
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    am(paramView, paramInt);
    return true;
  }
  
  public void setRightArrowVisible(boolean paramBoolean)
  {
    if (paramBoolean == this.cso) {
      return;
    }
    this.cso = paramBoolean;
    if (this.cso)
    {
      this.mTitleView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130839512, 0);
      return;
    }
    this.mTitleView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
  }
  
  public void setTitleTextColor(int paramInt)
  {
    this.mTitleView.setTextColor(paramInt);
  }
  
  public String xC()
  {
    if ((this.mListView == null) || (this.mTitle == null)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(acfp.m(2131713992));
    ListAdapter localListAdapter = this.mListView.getAdapter();
    if (localListAdapter == null) {
      return "";
    }
    localStringBuilder.append(this.mTitle).append(localListAdapter.getCount()).append("个");
    int i = 0;
    if (i < localListAdapter.getCount())
    {
      localStringBuilder.append(",");
      Object localObject = (InterestTagInfo)localListAdapter.getItem(i);
      if (localObject != null) {}
      for (localObject = ((InterestTagInfo)localObject).tagName;; localObject = "")
      {
        localStringBuilder.append((String)localObject);
        i += 1;
        break;
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.SavorTagImg
 * JD-Core Version:    0.7.0.1
 */