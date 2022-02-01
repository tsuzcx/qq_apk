package com.tencent.qqmail.ftn.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.qqmail.ftn.Ftn.FileInfo;
import com.tencent.qqmail.utilities.OneStepUtils;
import com.tencent.qqmail.utilities.ui.PtrListView;

class FtnListActivity$35
  implements AdapterView.OnItemLongClickListener
{
  FtnListActivity$35(FtnListActivity paramFtnListActivity) {}
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.this$0.isEditing())
    {
      if (OneStepUtils.isOneStepShowing())
      {
        paramAdapterView = FtnListActivity.access$6500(this.this$0, paramInt);
        if ((paramAdapterView instanceof FileInfo)) {
          FtnListActivity.access$6600(this.this$0, paramView, (FileInfo)paramAdapterView);
        }
      }
      return false;
    }
    paramAdapterView = FtnListActivity.access$6500(this.this$0, paramInt);
    if ((paramAdapterView instanceof FileInfo))
    {
      FtnListActivity.access$3900(this.this$0);
      FtnListActivity.access$700(this.this$0).setItemChecked(paramInt, true);
      FtnListActivity.access$6200(this.this$0, paramInt);
      FtnListActivity.access$6600(this.this$0, paramView, (FileInfo)paramAdapterView);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnListActivity.35
 * JD-Core Version:    0.7.0.1
 */