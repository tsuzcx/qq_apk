package android.support.v7.app;

import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class AlertController$AlertParams$4
  implements AdapterView.OnItemClickListener
{
  AlertController$AlertParams$4(AlertController.AlertParams paramAlertParams, AlertController.RecycleListView paramRecycleListView, AlertController paramAlertController) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.this$0.mCheckedItems != null) {
      this.this$0.mCheckedItems[paramInt] = this.val$listView.isItemChecked(paramInt);
    }
    this.this$0.mOnCheckboxClickListener.onClick(this.val$dialog.mDialog, paramInt, this.val$listView.isItemChecked(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.app.AlertController.AlertParams.4
 * JD-Core Version:    0.7.0.1
 */