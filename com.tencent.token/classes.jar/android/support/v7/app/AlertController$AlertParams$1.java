package android.support.v7.app;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

class AlertController$AlertParams$1
  extends ArrayAdapter
{
  AlertController$AlertParams$1(AlertController.AlertParams paramAlertParams, Context paramContext, int paramInt1, int paramInt2, CharSequence[] paramArrayOfCharSequence, AlertController.RecycleListView paramRecycleListView)
  {
    super(paramContext, paramInt1, paramInt2, paramArrayOfCharSequence);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = super.getView(paramInt, paramView, paramViewGroup);
    if ((this.this$0.mCheckedItems != null) && (this.this$0.mCheckedItems[paramInt] != 0)) {
      this.val$listView.setItemChecked(paramInt, true);
    }
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.app.AlertController.AlertParams.1
 * JD-Core Version:    0.7.0.1
 */