package android.support.v7.widget;

import android.content.Context;
import android.content.pm.ResolveInfo;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.layout;
import android.support.v7.appcompat.R.string;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class ActivityChooserView$ActivityChooserViewAdapter
  extends BaseAdapter
{
  private static final int ITEM_VIEW_TYPE_ACTIVITY = 0;
  private static final int ITEM_VIEW_TYPE_COUNT = 3;
  private static final int ITEM_VIEW_TYPE_FOOTER = 1;
  public static final int MAX_ACTIVITY_COUNT_DEFAULT = 4;
  public static final int MAX_ACTIVITY_COUNT_UNLIMITED = 2147483647;
  private ActivityChooserModel mDataModel;
  private boolean mHighlightDefaultActivity;
  private int mMaxActivityCount = 4;
  private boolean mShowDefaultActivity;
  private boolean mShowFooterView;
  
  ActivityChooserView$ActivityChooserViewAdapter(ActivityChooserView paramActivityChooserView) {}
  
  public int getActivityCount()
  {
    return this.mDataModel.getActivityCount();
  }
  
  public int getCount()
  {
    int j = this.mDataModel.getActivityCount();
    int i = j;
    if (!this.mShowDefaultActivity)
    {
      i = j;
      if (this.mDataModel.getDefaultActivity() != null) {
        i = j - 1;
      }
    }
    j = Math.min(i, this.mMaxActivityCount);
    i = j;
    if (this.mShowFooterView) {
      i = j + 1;
    }
    return i;
  }
  
  public ActivityChooserModel getDataModel()
  {
    return this.mDataModel;
  }
  
  public ResolveInfo getDefaultActivity()
  {
    return this.mDataModel.getDefaultActivity();
  }
  
  public int getHistorySize()
  {
    return this.mDataModel.getHistorySize();
  }
  
  public Object getItem(int paramInt)
  {
    switch (getItemViewType(paramInt))
    {
    default: 
      throw new IllegalArgumentException();
    case 1: 
      return null;
    }
    int i = paramInt;
    if (!this.mShowDefaultActivity)
    {
      i = paramInt;
      if (this.mDataModel.getDefaultActivity() != null) {
        i = paramInt + 1;
      }
    }
    return this.mDataModel.getActivity(i);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.mShowFooterView) && (paramInt == getCount() - 1)) {
      return 1;
    }
    return 0;
  }
  
  public boolean getShowDefaultActivity()
  {
    return this.mShowDefaultActivity;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    switch (getItemViewType(paramInt))
    {
    default: 
      throw new IllegalArgumentException();
    case 1: 
      if (paramView != null)
      {
        localView = paramView;
        if (paramView.getId() == 1) {}
      }
      else
      {
        localView = LayoutInflater.from(this.this$0.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, paramViewGroup, false);
        localView.setId(1);
        ((TextView)localView.findViewById(R.id.title)).setText(this.this$0.getContext().getString(R.string.abc_activity_chooser_view_see_all));
      }
      return localView;
    }
    if (paramView != null)
    {
      localView = paramView;
      if (paramView.getId() == R.id.list_item) {}
    }
    else
    {
      localView = LayoutInflater.from(this.this$0.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, paramViewGroup, false);
    }
    paramView = this.this$0.getContext().getPackageManager();
    paramViewGroup = (ImageView)localView.findViewById(R.id.icon);
    ResolveInfo localResolveInfo = (ResolveInfo)getItem(paramInt);
    paramViewGroup.setImageDrawable(localResolveInfo.loadIcon(paramView));
    ((TextView)localView.findViewById(R.id.title)).setText(localResolveInfo.loadLabel(paramView));
    if ((this.mShowDefaultActivity) && (paramInt == 0) && (this.mHighlightDefaultActivity))
    {
      localView.setActivated(true);
      return localView;
    }
    localView.setActivated(false);
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public int measureContentWidth()
  {
    int i = 0;
    int k = this.mMaxActivityCount;
    this.mMaxActivityCount = 2147483647;
    int m = View.MeasureSpec.makeMeasureSpec(0, 0);
    int n = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i1 = getCount();
    View localView = null;
    int j = 0;
    while (i < i1)
    {
      localView = getView(i, localView, null);
      localView.measure(m, n);
      j = Math.max(j, localView.getMeasuredWidth());
      i += 1;
    }
    this.mMaxActivityCount = k;
    return j;
  }
  
  public void setDataModel(ActivityChooserModel paramActivityChooserModel)
  {
    ActivityChooserModel localActivityChooserModel = this.this$0.mAdapter.getDataModel();
    if ((localActivityChooserModel != null) && (this.this$0.isShown())) {
      localActivityChooserModel.unregisterObserver(this.this$0.mModelDataSetObserver);
    }
    this.mDataModel = paramActivityChooserModel;
    if ((paramActivityChooserModel != null) && (this.this$0.isShown())) {
      paramActivityChooserModel.registerObserver(this.this$0.mModelDataSetObserver);
    }
    notifyDataSetChanged();
  }
  
  public void setMaxActivityCount(int paramInt)
  {
    if (this.mMaxActivityCount != paramInt)
    {
      this.mMaxActivityCount = paramInt;
      notifyDataSetChanged();
    }
  }
  
  public void setShowDefaultActivity(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.mShowDefaultActivity != paramBoolean1) || (this.mHighlightDefaultActivity != paramBoolean2))
    {
      this.mShowDefaultActivity = paramBoolean1;
      this.mHighlightDefaultActivity = paramBoolean2;
      notifyDataSetChanged();
    }
  }
  
  public void setShowFooterView(boolean paramBoolean)
  {
    if (this.mShowFooterView != paramBoolean)
    {
      this.mShowFooterView = paramBoolean;
      notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.ActivityChooserView.ActivityChooserViewAdapter
 * JD-Core Version:    0.7.0.1
 */