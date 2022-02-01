package com.tencent.mobileqq.mini.entry.search.ui;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.MiniAppModuleExposureData;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.search.comm.SearchInfo;
import com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager;
import com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager.HotSearchDataChangedListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.util.WeakReference;

public class HotSearchAdapter
  extends BaseAdapter
  implements MiniAppSearchDataManager.HotSearchDataChangedListener
{
  private static final String TAG = "HotSearchAdapter";
  private List<SearchInfo> appList = new ArrayList();
  private WeakReference<Activity> mActivityReference;
  private TextView mHotTitleView;
  private int mRefer;
  
  public HotSearchAdapter(Activity paramActivity, TextView paramTextView, int paramInt)
  {
    this.mActivityReference = new WeakReference(paramActivity);
    this.mHotTitleView = paramTextView;
    this.mRefer = paramInt;
  }
  
  public int getCount()
  {
    return this.appList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.appList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    HotSearchViewHolder localHotSearchViewHolder;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext().getApplicationContext()).inflate(2131559606, paramViewGroup, false);
      localHotSearchViewHolder = new HotSearchViewHolder();
      localHotSearchViewHolder.icon = ((ImageView)paramView.findViewById(2131371694));
      localHotSearchViewHolder.ranking = ((ImageView)paramView.findViewById(2131371696));
      localHotSearchViewHolder.name = ((TextView)paramView.findViewById(2131371698));
      localHotSearchViewHolder.category = ((TextView)paramView.findViewById(2131371699));
      paramView.setTag(localHotSearchViewHolder);
    }
    for (;;)
    {
      SearchInfo localSearchInfo = (SearchInfo)this.appList.get(paramInt);
      try
      {
        localHotSearchViewHolder.update(paramView, localSearchInfo, (Activity)this.mActivityReference.get(), paramInt, this.mRefer);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localHotSearchViewHolder = (HotSearchViewHolder)paramView.getTag();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("HotSearchAdapter", 1, "getView exception: " + Log.getStackTraceString(localException));
        }
      }
    }
  }
  
  public void onHotSearchDataChanged()
  {
    Object localObject = (MiniAppSearchDataManager)MiniAppUtils.getAppInterface().getManager(360);
    setData(((MiniAppSearchDataManager)localObject).getHotSearchData());
    notifyDataSetChanged();
    if (!TextUtils.isEmpty(((MiniAppSearchDataManager)localObject).getHotSearchTitle())) {
      this.mHotTitleView.setText(((MiniAppSearchDataManager)localObject).getHotSearchTitle());
    }
    localObject = (MiniAppExposureManager)MiniAppUtils.getAppInterface().getManager(322);
    Iterator localIterator = this.appList.iterator();
    while (localIterator.hasNext())
    {
      MiniAppConfig localMiniAppConfig = new MiniAppConfig(((SearchInfo)localIterator.next()).miniAppInfo);
      localMiniAppConfig.launchParam.scene = this.mRefer;
      ((MiniAppExposureManager)localObject).addSearchItemAndCheckReport(new MiniAppExposureManager.MiniAppModuleExposureData(localMiniAppConfig, "page_view", "expo"));
    }
  }
  
  public void setData(List<SearchInfo> paramList)
  {
    this.appList.clear();
    this.appList.addAll(paramList);
  }
  
  static class HotSearchViewHolder
  {
    TextView category;
    ImageView icon;
    TextView name;
    ImageView ranking;
    
    public void update(View paramView, SearchInfo paramSearchInfo, Activity paramActivity, int paramInt1, int paramInt2)
    {
      MiniAppInfo localMiniAppInfo = paramSearchInfo.getMiniAppInfo();
      this.icon.setImageDrawable(MiniAppUtils.getIcon(paramView.getContext(), localMiniAppInfo.iconUrl, false, 0, 32));
      this.name.setText(localMiniAppInfo.name);
      this.category.setText(paramSearchInfo.getCategoryDesc());
      if (paramInt1 > 2) {
        this.ranking.setVisibility(8);
      }
      for (;;)
      {
        paramView.setOnClickListener(new HotSearchAdapter.HotSearchViewHolder.1(this, paramActivity, localMiniAppInfo, paramInt2));
        return;
        this.ranking.setVisibility(0);
        if (paramInt1 == 0) {
          this.ranking.setImageResource(2130841820);
        } else if (paramInt1 == 1) {
          this.ranking.setImageResource(2130841821);
        } else if (paramInt1 == 2) {
          this.ranking.setImageResource(2130841822);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.ui.HotSearchAdapter
 * JD-Core Version:    0.7.0.1
 */