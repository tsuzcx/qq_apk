package com.tencent.qqmail.ftn.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.ftn.Ftn.FileInfo;
import com.tencent.qqmail.ftn.model.FtnNewInfo;
import com.tencent.qqmail.ftn.model.FtnUploadInfo;
import com.tencent.qqmail.utilities.ui.PtrListView;

class FtnListActivity$34
  implements AdapterView.OnItemClickListener
{
  FtnListActivity$34(FtnListActivity paramFtnListActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.this$0.isEditing()) {
      FtnListActivity.access$6200(this.this$0, paramInt);
    }
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      if (paramInt > 0)
      {
        int i = paramInt - FtnListActivity.access$700(this.this$0).getHeaderViewsCount();
        if (i >= 0)
        {
          Object localObject = FtnListActivity.access$900(this.this$0).getItem(i);
          if ((localObject instanceof FileInfo))
          {
            FtnListActivity.access$6300(this.this$0, paramView);
            FtnListActivity.access$6400(this.this$0, paramInt);
          }
          else if ((localObject instanceof FtnUploadInfo))
          {
            FtnListActivity.access$6300(this.this$0, paramView);
          }
          else if ((localObject instanceof FtnNewInfo))
          {
            FtnListActivity.access$6300(this.this$0, paramView);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnListActivity.34
 * JD-Core Version:    0.7.0.1
 */