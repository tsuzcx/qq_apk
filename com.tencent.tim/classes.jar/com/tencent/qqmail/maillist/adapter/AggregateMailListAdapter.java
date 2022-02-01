package com.tencent.qqmail.maillist.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.WrapperListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.mail.cursor.IMailListCursor;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.popularize.view.PopularizeMailListItemView;
import com.tencent.qqmail.utilities.ui.HorizontalScrollItemView;
import com.tencent.qqmail.utilities.ui.ItemScrollListView;
import com.tencent.qqmail.utilities.ui.ItemScrollListView.ItemScrollAdapter;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AggregateMailListAdapter
  extends BaseAdapter
  implements WrapperListAdapter, ItemScrollListView.ItemScrollAdapter
{
  public static final int ITEM_VIEW_TYPE_DIVIDER = 3;
  public static final int ITEM_VIEW_TYPE_POPULARIZE = 2;
  private int commercailPopularizeCount = 0;
  private boolean hasCommercialDivider;
  private final QMMailListAdapter mAdapter;
  private int popularizePage;
  
  public AggregateMailListAdapter(Context paramContext, int paramInt, IMailListCursor paramIMailListCursor, ListView paramListView)
  {
    this.mAdapter = new QMMailListAdapter(paramContext, paramInt, paramIMailListCursor, paramListView);
  }
  
  public boolean areAllItemsEnabled()
  {
    return this.mAdapter.areAllItemsEnabled();
  }
  
  public int getCount()
  {
    int i = this.mAdapter.getCount();
    if (i < 0) {
      return i;
    }
    return i + this.commercailPopularizeCount;
  }
  
  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return super.getDropDownView(paramInt, paramView, paramViewGroup);
  }
  
  public Mail getItem(int paramInt)
  {
    if (this.commercailPopularizeCount > paramInt) {
      return null;
    }
    return this.mAdapter.getItem(paramInt - this.commercailPopularizeCount);
  }
  
  public long getItemId(int paramInt)
  {
    if (this.commercailPopularizeCount > paramInt) {
      return 0L;
    }
    return this.mAdapter.getItemId(paramInt - this.commercailPopularizeCount);
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this.commercailPopularizeCount > paramInt)
    {
      if ((this.commercailPopularizeCount - 1 == paramInt) && (this.hasCommercialDivider)) {
        return 3;
      }
      return 2;
    }
    return this.mAdapter.getItemViewType(paramInt - this.commercailPopularizeCount);
  }
  
  public int getPopularizedCount()
  {
    return this.commercailPopularizeCount;
  }
  
  @Nullable
  public Popularize getPopularizedData(int paramInt)
  {
    if (this.mAdapter.popularizedData.size() > paramInt) {
      return (Popularize)this.mAdapter.popularizedData.get(paramInt);
    }
    return null;
  }
  
  @NonNull
  public ArrayList<Popularize> getPopularizedData()
  {
    return this.mAdapter.popularizedData;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (getItemViewType(paramInt) == 2) {
      if ((paramView == null) || (paramView.getTag() == null))
      {
        localObject = new PopularizeMailListItemView(this.mAdapter.context);
        paramView = ItemScrollListView.wrap((View)localObject);
        ((PopularizeMailListItemView)localObject).setPopularize((Popularize)this.mAdapter.popularizedData.get(paramInt));
        ((PopularizeMailListItemView)localObject).setShowAvatar(QMSettingManager.sharedInstance().getMailListIcon());
        localObject = ((HorizontalScrollItemView)paramView).getDeleteView();
        ItemScrollListView.formatRightViewStyle((TextView)localObject, 1);
        ((TextView)localObject).setText(2131692498);
        localObject = paramView;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
      localObject = (PopularizeMailListItemView)((HorizontalScrollItemView)paramView).getContentView();
      break;
      if (getItemViewType(paramInt) == 3)
      {
        paramView = new View(this.mAdapter.context);
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, QMUIKit.dpToPx(8)));
        paramView.setBackgroundResource(2130837680);
        localObject = paramView;
      }
      else
      {
        localObject = this.mAdapter.getView(paramInt - this.commercailPopularizeCount, paramView, paramViewGroup);
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 4;
  }
  
  public ListAdapter getWrappedAdapter()
  {
    return this.mAdapter;
  }
  
  public boolean hasStableIds()
  {
    return this.mAdapter.hasStableIds();
  }
  
  public boolean isEmpty()
  {
    return (this.mAdapter.isEmpty()) && (this.mAdapter.popularizedData.size() == 0);
  }
  
  public boolean isEnabled(int paramInt)
  {
    if (this.commercailPopularizeCount > paramInt) {
      return !this.mAdapter.isEditing();
    }
    return this.mAdapter.isEnabled(paramInt - this.commercailPopularizeCount);
  }
  
  public int isEnabledScroll(int paramInt)
  {
    int i = 2;
    int j = getItemViewType(paramInt);
    if (j == 3) {
      i = 0;
    }
    while (j == 2) {
      return i;
    }
    return this.mAdapter.isEnabledScroll(paramInt - this.commercailPopularizeCount);
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
  }
  
  public void notifyDataSetInvalidated()
  {
    super.notifyDataSetInvalidated();
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    super.registerDataSetObserver(paramDataSetObserver);
  }
  
  public void setIsEditing(boolean paramBoolean)
  {
    this.mAdapter.setIsEditing(paramBoolean);
  }
  
  public void setMailAbsCache(Long paramLong, String paramString)
  {
    this.mAdapter.setMailAbsCache(paramLong, paramString);
  }
  
  public void setMoreLoadingState(int paramInt)
  {
    this.mAdapter.setMoreLoadingState(paramInt);
  }
  
  public void setPopularize(@NonNull ArrayList<Popularize> paramArrayList, int paramInt)
  {
    int i = 0;
    this.popularizePage = paramInt;
    paramInt = i;
    Object localObject;
    if (paramArrayList != null)
    {
      paramInt = i;
      if (this.popularizePage == 1)
      {
        if ((paramArrayList != null) && (paramArrayList.size() != 0)) {
          break label101;
        }
        paramInt = 0;
        localObject = paramArrayList.iterator();
        while (((Iterator)localObject).hasNext()) {
          if (((Popularize)((Iterator)localObject).next()).getType() == 9)
          {
            paramInt += 1;
            this.hasCommercialDivider = true;
          }
        }
      }
    }
    for (;;)
    {
      this.commercailPopularizeCount = paramInt;
      localObject = this.mAdapter;
      if (paramInt > 0) {}
      for (;;)
      {
        ((QMMailListAdapter)localObject).setPopularizedData(paramArrayList);
        return;
        label101:
        paramInt = paramArrayList.size();
        break;
        paramArrayList = new ArrayList();
      }
    }
  }
  
  public void setPopularizedData(ArrayList<Popularize> paramArrayList)
  {
    throw new UnsupportedOperationException("use setPopularize(ArrayList,int)");
  }
  
  public void setWhichRightViewShow(boolean[] paramArrayOfBoolean)
  {
    this.mAdapter.setWhichRightViewShow(paramArrayOfBoolean);
  }
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    super.unregisterDataSetObserver(paramDataSetObserver);
  }
  
  public void verifyAvatar(List<String> paramList)
  {
    this.mAdapter.verifyAvatar(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.adapter.AggregateMailListAdapter
 * JD-Core Version:    0.7.0.1
 */