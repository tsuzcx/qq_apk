package android.support.v7.internal.widget;

import android.content.Context;
import android.content.pm.ResolveInfo;
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
  
  private ActivityChooserView$ActivityChooserViewAdapter(ActivityChooserView paramActivityChooserView) {}
  
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
  
  public int getMaxActivityCount()
  {
    return this.mMaxActivityCount;
  }
  
  public boolean getShowDefaultActivity()
  {
    return this.mShowDefaultActivity;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    switch (getItemViewType(paramInt))
    {
    default: 
      throw new IllegalArgumentException();
    case 1: 
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getId() == 1) {
          break;
        }
      }
      else
      {
        localObject = LayoutInflater.from(this.this$0.getContext()).inflate(2130903053, paramViewGroup, false);
        ((View)localObject).setId(1);
        ((TextView)((View)localObject).findViewById(2131230941)).setText(this.this$0.getContext().getString(2131558410));
      }
      break;
    }
    View localView;
    do
    {
      do
      {
        do
        {
          return localObject;
          if (paramView != null)
          {
            localView = paramView;
            if (paramView.getId() == 2131230939) {}
          }
          else
          {
            localView = LayoutInflater.from(this.this$0.getContext()).inflate(2130903053, paramViewGroup, false);
          }
          paramView = this.this$0.getContext().getPackageManager();
          paramViewGroup = (ImageView)localView.findViewById(2131230940);
          localObject = (ResolveInfo)getItem(paramInt);
          paramViewGroup.setImageDrawable(((ResolveInfo)localObject).loadIcon(paramView));
          ((TextView)localView.findViewById(2131230941)).setText(((ResolveInfo)localObject).loadLabel(paramView));
          localObject = localView;
        } while (!this.mShowDefaultActivity);
        localObject = localView;
      } while (paramInt != 0);
      localObject = localView;
    } while (!this.mHighlightDefaultActivity);
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
    ActivityChooserModel localActivityChooserModel = ActivityChooserView.access$000(this.this$0).getDataModel();
    if ((localActivityChooserModel != null) && (this.this$0.isShown())) {
      localActivityChooserModel.unregisterObserver(ActivityChooserView.access$1100(this.this$0));
    }
    this.mDataModel = paramActivityChooserModel;
    if ((paramActivityChooserModel != null) && (this.this$0.isShown())) {
      paramActivityChooserModel.registerObserver(ActivityChooserView.access$1100(this.this$0));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.widget.ActivityChooserView.ActivityChooserViewAdapter
 * JD-Core Version:    0.7.0.1
 */