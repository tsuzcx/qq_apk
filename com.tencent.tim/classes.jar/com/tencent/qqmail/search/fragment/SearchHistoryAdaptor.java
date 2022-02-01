package com.tencent.qqmail.search.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.maillist.SearchHistoryItem;
import java.util.ArrayList;

public class SearchHistoryAdaptor
  extends BaseAdapter
{
  private Context mContext;
  private ArrayList<SearchHistoryItem> mSearchHistoryItems = new ArrayList();
  private SearchHistoryListener mSearchHistoryListener;
  
  public SearchHistoryAdaptor(Context paramContext, ArrayList<SearchHistoryItem> paramArrayList)
  {
    this.mContext = paramContext;
    if (paramArrayList != null) {
      this.mSearchHistoryItems.addAll(paramArrayList);
    }
  }
  
  public int getCount()
  {
    return this.mSearchHistoryItems.size();
  }
  
  public SearchHistoryItem getItem(int paramInt)
  {
    return (SearchHistoryItem)this.mSearchHistoryItems.get(paramInt);
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
      localView = LayoutInflater.from(this.mContext).inflate(2131563017, paramViewGroup, false);
      paramView = new ViewHolder();
      paramView.mTitleView = ((TextView)localView.findViewById(2131365360));
      paramView.mCloseView = ((ImageView)localView.findViewById(2131364677));
      localView.setTag(paramView);
    }
    for (;;)
    {
      Object localObject = getItem(paramInt);
      if (localObject != null)
      {
        paramView.mTitleView.setText(((SearchHistoryItem)localObject).getSearchContent());
        paramView.mCloseView.setOnClickListener(new SearchHistoryAdaptor.1(this, paramInt));
      }
      localView.setOnClickListener(new SearchHistoryAdaptor.2(this, (AbsListView)paramViewGroup, paramInt));
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
  }
  
  public void setSearchHistoryItems(ArrayList<SearchHistoryItem> paramArrayList)
  {
    this.mSearchHistoryItems.clear();
    if (this.mSearchHistoryItems != null) {
      this.mSearchHistoryItems.addAll(paramArrayList);
    }
    notifyDataSetChanged();
  }
  
  public void setSearchHistoryListener(SearchHistoryListener paramSearchHistoryListener)
  {
    this.mSearchHistoryListener = paramSearchHistoryListener;
  }
  
  public static abstract interface SearchHistoryListener
  {
    public abstract void delete(int paramInt);
  }
  
  static class ViewHolder
  {
    ImageView mCloseView;
    TextView mTitleView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.SearchHistoryAdaptor
 * JD-Core Version:    0.7.0.1
 */