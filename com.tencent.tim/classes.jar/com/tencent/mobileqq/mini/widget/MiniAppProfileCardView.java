package com.tencent.mobileqq.mini.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;

public class MiniAppProfileCardView
  extends LinearLayout
{
  private ColorStateList attrValue;
  private int colorInt;
  private boolean isTheme;
  protected HorzionAdapter mAdapter;
  private Context mContext;
  protected LayoutInflater mLayoutInflater;
  protected HorizontalListView mListView;
  
  public MiniAppProfileCardView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public MiniAppProfileCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public MiniAppProfileCardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.mContext = paramContext;
    this.mLayoutInflater = LayoutInflater.from(paramContext);
    this.mLayoutInflater.inflate(2131561583, this, true);
    this.mListView = ((HorizontalListView)findViewById(2131373658));
    this.mAdapter = new HorzionAdapter();
    this.mListView.setAdapter(this.mAdapter);
    this.mListView.setVisibility(0);
  }
  
  public void setData(ArrayList<MiniAppInfo> paramArrayList)
  {
    if (this.mAdapter != null) {
      this.mAdapter.setData(paramArrayList);
    }
  }
  
  public void setTextColor(int paramInt)
  {
    this.isTheme = true;
    this.colorInt = paramInt;
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    this.isTheme = true;
    this.attrValue = paramColorStateList;
  }
  
  class HorzionAdapter
    extends BaseAdapter
  {
    private ArrayList<MiniAppInfo> miniAppInfoItems;
    
    HorzionAdapter() {}
    
    public int getCount()
    {
      if (this.miniAppInfoItems != null) {
        return this.miniAppInfoItems.size();
      }
      return 0;
    }
    
    public Object getItem(int paramInt)
    {
      if (this.miniAppInfoItems != null) {
        return (MiniAppInfo)this.miniAppInfoItems.get(paramInt);
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
      if ((this.miniAppInfoItems == null) || (this.miniAppInfoItems.size() < 1))
      {
        localObject = paramView;
        localView = paramView;
        paramView = (View)localObject;
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return localView;
      }
      Object localObject = (MiniAppInfo)this.miniAppInfoItems.get(paramInt);
      if (paramView == null) {
        paramView = new MiniAppProfileCardItemView(MiniAppProfileCardView.this.mContext, null);
      }
      for (;;)
      {
        ((MiniAppProfileCardItemView)paramView).setData((MiniAppInfo)localObject, paramInt);
        if (MiniAppProfileCardView.this.isTheme)
        {
          if (MiniAppProfileCardView.this.attrValue == null) {
            break label127;
          }
          ((MiniAppProfileCardItemView)paramView).setTextColor(MiniAppProfileCardView.this.attrValue);
        }
        for (;;)
        {
          localView = paramView;
          break;
          label127:
          ((MiniAppProfileCardItemView)paramView).setTextColor(MiniAppProfileCardView.this.colorInt);
        }
      }
    }
    
    public void setData(ArrayList<MiniAppInfo> paramArrayList)
    {
      this.miniAppInfoItems = paramArrayList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.MiniAppProfileCardView
 * JD-Core Version:    0.7.0.1
 */