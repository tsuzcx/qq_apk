package android.support.v7.internal.widget;

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
  private ActivityChooserView$Callbacks(ActivityChooserView paramActivityChooserView) {}
  
  private void notifyOnDismissListener()
  {
    if (ActivityChooserView.access$1000(this.this$0) != null) {
      ActivityChooserView.access$1000(this.this$0).onDismiss();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == ActivityChooserView.access$700(this.this$0))
    {
      this.this$0.dismissPopup();
      paramView = ActivityChooserView.access$000(this.this$0).getDefaultActivity();
      int i = ActivityChooserView.access$000(this.this$0).getDataModel().getActivityIndex(paramView);
      paramView = ActivityChooserView.access$000(this.this$0).getDataModel().chooseActivity(i);
      if (paramView != null)
      {
        paramView.addFlags(524288);
        this.this$0.getContext().startActivity(paramView);
      }
      return;
    }
    if (paramView == ActivityChooserView.access$800(this.this$0))
    {
      ActivityChooserView.access$602(this.this$0, false);
      ActivityChooserView.access$500(this.this$0, ActivityChooserView.access$900(this.this$0));
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
      ActivityChooserView.access$500(this.this$0, 2147483647);
    }
    do
    {
      return;
      this.this$0.dismissPopup();
      if (!ActivityChooserView.access$600(this.this$0)) {
        break;
      }
    } while (paramInt <= 0);
    ActivityChooserView.access$000(this.this$0).getDataModel().setDefaultActivity(paramInt);
    return;
    if (ActivityChooserView.access$000(this.this$0).getShowDefaultActivity()) {}
    for (;;)
    {
      paramAdapterView = ActivityChooserView.access$000(this.this$0).getDataModel().chooseActivity(paramInt);
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
    if (paramView == ActivityChooserView.access$700(this.this$0))
    {
      if (ActivityChooserView.access$000(this.this$0).getCount() > 0)
      {
        ActivityChooserView.access$602(this.this$0, true);
        ActivityChooserView.access$500(this.this$0, ActivityChooserView.access$900(this.this$0));
      }
      return true;
    }
    throw new IllegalArgumentException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.widget.ActivityChooserView.Callbacks
 * JD-Core Version:    0.7.0.1
 */