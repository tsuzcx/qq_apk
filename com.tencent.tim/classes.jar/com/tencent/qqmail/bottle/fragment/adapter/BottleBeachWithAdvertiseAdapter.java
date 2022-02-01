package com.tencent.qqmail.bottle.fragment.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.WrapperListAdapter;
import androidx.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.bottle.model.BottleBeach;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.utilities.ui.InsertionListView.HeaderViewsAdapter;
import java.util.ArrayList;
import java.util.Iterator;

public class BottleBeachWithAdvertiseAdapter
  implements WrapperListAdapter, InsertionListView.HeaderViewsAdapter
{
  public static final int POPULARIZE_ITEM_ID = -1;
  private final BottleBeachAdapter mAdapter;
  @NonNull
  private ArrayList<BottleBeach> popularizedBottleList = new ArrayList();
  
  public BottleBeachWithAdvertiseAdapter(@NonNull BottleBeachAdapter paramBottleBeachAdapter)
  {
    this.mAdapter = paramBottleBeachAdapter;
  }
  
  public boolean areAllItemsEnabled()
  {
    return this.mAdapter.areAllItemsEnabled();
  }
  
  public int getCount()
  {
    return this.popularizedBottleList.size() + this.mAdapter.getCount();
  }
  
  public int getHeaderViewsCount()
  {
    return this.popularizedBottleList.size();
  }
  
  public BottleBeach getItem(int paramInt)
  {
    if (this.popularizedBottleList.size() > paramInt) {
      return (BottleBeach)this.popularizedBottleList.get(paramInt);
    }
    return this.mAdapter.getItem(paramInt - this.popularizedBottleList.size());
  }
  
  public long getItemId(int paramInt)
  {
    if (this.popularizedBottleList.size() > paramInt) {
      return -1L;
    }
    return this.mAdapter.getItemId(paramInt - this.popularizedBottleList.size());
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this.popularizedBottleList.size() > paramInt) {
      return this.mAdapter.getItemViewType(0);
    }
    return this.mAdapter.getItemViewType(paramInt - this.popularizedBottleList.size());
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.popularizedBottleList.size() > paramInt) {
      localObject = (BottleBeach)this.popularizedBottleList.get(paramInt);
    }
    for (Object localObject = this.mAdapter.getView((BottleBeach)localObject, paramView, paramViewGroup, false);; localObject = this.mAdapter.getView(paramInt - this.popularizedBottleList.size(), paramView, paramViewGroup))
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
    }
  }
  
  public int getViewTypeCount()
  {
    return this.mAdapter.getViewTypeCount();
  }
  
  public BottleBeachAdapter getWrappedAdapter()
  {
    return this.mAdapter;
  }
  
  public boolean hasStableIds()
  {
    return this.mAdapter.hasStableIds();
  }
  
  public boolean isEmpty()
  {
    return (this.mAdapter.isEmpty()) && (this.popularizedBottleList.isEmpty());
  }
  
  public boolean isEnabled(int paramInt)
  {
    if (this.popularizedBottleList.size() > paramInt) {
      return true;
    }
    return this.mAdapter.isEnabled(paramInt - this.popularizedBottleList.size());
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.mAdapter.registerDataSetObserver(paramDataSetObserver);
  }
  
  public void setPopularizedData(@NonNull ArrayList<Popularize> paramArrayList)
  {
    Context localContext = this.mAdapter.mContext;
    this.popularizedBottleList.clear();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Object localObject2 = (Popularize)paramArrayList.next();
      Object localObject1 = "" + ((Popularize)localObject2).getId();
      String str1 = ((Popularize)localObject2).getCommercialFromNick();
      String str2 = ((Popularize)localObject2).getSubject();
      localObject2 = ((Popularize)localObject2).getOpenUrl();
      localObject1 = new BottleBeach((String)localObject1, 0L, -1, null, null, null, null, str1, false, localContext.getString(2131690978), null, null, str2, "", 9998, (int)(Math.random() * BottleBeachAdapter.bottle_beach_item_top_colors_resource.length), (String)localObject2);
      this.popularizedBottleList.add(localObject1);
    }
  }
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.mAdapter.unregisterDataSetObserver(paramDataSetObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.adapter.BottleBeachWithAdvertiseAdapter
 * JD-Core Version:    0.7.0.1
 */