package com.tencent.qqmail.ftn.activity;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.ftn.Ftn.FileInfo;
import com.tencent.qqmail.ftn.model.FtnUI;
import com.tencent.qqmail.utilities.ui.PtrListView;

class FtnListActivity$21
  implements View.OnClickListener
{
  FtnListActivity$21(FtnListActivity paramFtnListActivity) {}
  
  public void onClick(View paramView)
  {
    int i = 0;
    if (!FtnListActivity.access$4100(this.this$0)) {
      this.this$0.onButtonBackClick();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = this.this$0;
      if (!FtnListActivity.access$4300(this.this$0)) {}
      for (boolean bool = true;; bool = false)
      {
        FtnListActivity.access$4400((FtnListActivity)localObject, bool);
        if (!FtnListActivity.access$4300(this.this$0)) {
          break;
        }
        localObject = FtnListActivity.access$900(this.this$0).getFtnUI();
        if (localObject == null) {
          break label186;
        }
        int j = FtnListActivity.access$700(this.this$0).getHeaderViewsCount();
        int k = ((FtnUI)localObject).getCount();
        int m = FtnListActivity.access$900(this.this$0).getUploadItemCount();
        while (i < k)
        {
          FileInfo localFileInfo = ((FtnUI)localObject).get(i);
          FtnListActivity.access$4500(this.this$0).put(i, localFileInfo);
          FtnListActivity.access$4600(this.this$0).put(i, true);
          FtnListActivity.access$700(this.this$0).setItemChecked(i + j + m, true);
          i += 1;
        }
      }
      FtnListActivity.access$1300(this.this$0);
      label186:
      FtnListActivity.access$4700(this.this$0, FtnListActivity.access$4600(this.this$0).size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnListActivity.21
 * JD-Core Version:    0.7.0.1
 */