package com.tencent.mobileqq.theme.diy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class ThemeDiyBgAdapter
  extends BaseAdapter
{
  static String TAG = "ThemeDiyBgAdapter";
  boolean isDIYThemeBefore;
  protected Context mContext;
  ArrayList<ResSuitData> mData = new ArrayList();
  LayoutInflater mInflater;
  int mResType;
  ThemeDIYData themeDIYData;
  ResSuitData tryOnStyleRSD;
  ResSuitData usedStyleRSD;
  
  public ThemeDiyBgAdapter(Context paramContext)
  {
    this.mContext = paramContext;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
  }
  
  public int getCount()
  {
    return this.mData.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.mData == null) || (paramInt < 0) || (paramInt >= this.mData.size())) {
      return null;
    }
    return this.mData.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      paramView = this.mInflater.inflate(2131562263, paramViewGroup, false);
    }
    for (;;)
    {
      ItemView localItemView = (ItemView)paramView;
      Object localObject = getItem(paramInt);
      if (localItemView == null) {
        QLog.e(TAG, 1, "getVie error itemView null");
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        if (localObject == null)
        {
          QLog.e(TAG, 1, "getVie error obj null");
        }
        else
        {
          if ((localObject instanceof ResSuitData.BgSuit))
          {
            ResSuitData localResSuitData1 = (ResSuitData)localObject;
            ResSuitData localResSuitData2 = this.themeDIYData.tryOnBgRSD;
            if (this.isDIYThemeBefore) {}
            for (localObject = this.themeDIYData.usedBgRSD;; localObject = null)
            {
              localItemView.init(localResSuitData1, localResSuitData2, (ResSuitData)localObject, false);
              break;
            }
          }
          localItemView.init((ResSuitData)localObject, this.tryOnStyleRSD, this.usedStyleRSD, false);
        }
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeDiyBgAdapter
 * JD-Core Version:    0.7.0.1
 */