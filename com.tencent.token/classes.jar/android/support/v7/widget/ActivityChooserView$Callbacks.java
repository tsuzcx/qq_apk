package android.support.v7.widget;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ActionProvider;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupWindow.OnDismissListener;

class ActivityChooserView$Callbacks
  implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener
{
  ActivityChooserView$Callbacks(ActivityChooserView paramActivityChooserView) {}
  
  private void notifyOnDismissListener()
  {
    if (this.this$0.mOnDismissListener != null) {
      this.this$0.mOnDismissListener.onDismiss();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.this$0.mDefaultActivityButton)
    {
      this.this$0.dismissPopup();
      paramView = this.this$0.mAdapter.getDefaultActivity();
      int i = this.this$0.mAdapter.getDataModel().getActivityIndex(paramView);
      paramView = this.this$0.mAdapter.getDataModel().chooseActivity(i);
      if (paramView != null)
      {
        paramView.addFlags(524288);
        this.this$0.getContext().startActivity(paramView);
      }
      return;
    }
    if (paramView == this.this$0.mExpandActivityOverflowButton)
    {
      this.this$0.mIsSelectingDefaultActivity = false;
      this.this$0.showPopupUnchecked(this.this$0.mInitialActivityCount);
      return;
    }
    throw new IllegalArgumentException();
  }
  
  public void onDismiss()
  {
    notifyOnDismissListener();
    if (this.this$0.mProvider != null) {
      this.this$0.mProvider.subUiVisibilityChanged(false);
    }
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    switch (((ActivityChooserView.ActivityChooserViewAdapter)paramAdapterView.getAdapter()).getItemViewType(paramInt))
    {
    default: 
      throw new IllegalArgumentException();
    case 1: 
      this.this$0.showPopupUnchecked(2147483647);
    }
    do
    {
      return;
      this.this$0.dismissPopup();
      if (!this.this$0.mIsSelectingDefaultActivity) {
        break;
      }
    } while (paramInt <= 0);
    this.this$0.mAdapter.getDataModel().setDefaultActivity(paramInt);
    return;
    if (this.this$0.mAdapter.getShowDefaultActivity()) {}
    for (;;)
    {
      paramAdapterView = this.this$0.mAdapter.getDataModel().chooseActivity(paramInt);
      if (paramAdapterView == null) {
        break;
      }
      paramAdapterView.addFlags(524288);
      this.this$0.getContext().startActivity(paramAdapterView);
      return;
      paramInt += 1;
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    if (paramView == this.this$0.mDefaultActivityButton)
    {
      if (this.this$0.mAdapter.getCount() > 0)
      {
        this.this$0.mIsSelectingDefaultActivity = true;
        this.this$0.showPopupUnchecked(this.this$0.mInitialActivityCount);
      }
      return true;
    }
    throw new IllegalArgumentException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.ActivityChooserView.Callbacks
 * JD-Core Version:    0.7.0.1
 */